package com.github.warrentode.todecoins.entity.spawners.piglinmerchant;

import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;

public class PiglinMerchantSpawner implements CustomSpawner {
    private final PiglinMerchantData data;
    @SuppressWarnings("unused")
    private final EntityType<PiglinMerchant> entityType;
    public static final int defaultSpawnDelay = CommonConfig.getPiglinMerchantNetherSpawnDelay();
    public static final int defaultDespawnDelay = CommonConfig.getPiglinMerchantNetherDespawnDelay();
    private static final int tickDelayBeforeSpawn = defaultSpawnDelay / 20;
    private static final int minSpawnChance = 25;
    private static final int maxSpawnChance = 100;
    private static final int spawnChanceIncrease = minSpawnChance;
    private static final int spawnAttempts = 10;
    private static final int OneInXChanceToSpawn = spawnAttempts;
    private final RandomSource random = RandomSource.create();
    private int tickDelay;
    private int spawnDelay;
    private int spawnChance;

    public PiglinMerchantSpawner(MinecraftServer server, String key, @NotNull EntityType<PiglinMerchant> entityType){
        this.data = PiglinMerchantSavedData.get(server).getPiglinMerchantData(key);
        this.entityType = entityType;
        this.tickDelay = tickDelayBeforeSpawn;
        this.spawnDelay = this.data.getPiglinMerchantSpawnDelay();
        this.spawnChance = this.data.getPiglinMerchantSpawnChance();
        if (this.spawnDelay == 0 && this.spawnChance == 0) {
            this.spawnDelay = defaultSpawnDelay;
            this.data.setPiglinMerchantSpawnDelay(this.spawnDelay);
            this.spawnChance = minSpawnChance;
            this.data.setPiglinMerchantSpawnChance(this.spawnChance);
        }
    }

    public int tick(@NotNull ServerLevel serverLevel, boolean spawnHostiles, boolean spawnPassives) {
        if (!serverLevel.getGameRules().getBoolean(GameRules.RULE_DO_TRADER_SPAWNING)) {
            return 0;
        }
        else if (--this.tickDelay > 0) {
            return 0;
        }
        else {
            this.tickDelay = tickDelayBeforeSpawn;
            this.spawnDelay -= tickDelayBeforeSpawn;
            this.data.setPiglinMerchantSpawnDelay(this.spawnDelay);
            if (this.spawnDelay > 0) {
                return 0;
            }
            else {
                this.spawnDelay = defaultSpawnDelay;
                if (!serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
                    return 0;
                }
                else {
                    int i = this.spawnChance;
                    this.spawnChance = Mth.clamp(this.spawnChance + spawnChanceIncrease, minSpawnChance, maxSpawnChance);
                    this.data.setPiglinMerchantSpawnChance(this.spawnChance);
                    if (this.random.nextInt(100) > i) {
                        return 0;
                    }
                    else if (this.spawnTrader(serverLevel)) {
                        this.spawnChance = minSpawnChance;
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
    }

    private boolean spawnTrader(@NotNull ServerLevel serverLevel) {
        Player player = serverLevel.getRandomPlayer();
        if (player == null) {
            return true;
        }
        else if (this.random.nextInt(OneInXChanceToSpawn) != 0) {
            return false;
        }
        else {
            BlockPos pos = player.blockPosition();
            int maxDistance = 48;
            PoiManager poiManager = serverLevel.getPoiManager();
            Optional<BlockPos> optional = poiManager.find((poiTypeHolder) -> poiTypeHolder.is(PoiTypes.NETHER_PORTAL),
                                                          (pos1) -> true, pos, maxDistance, PoiManager.Occupancy.ANY);
            BlockPos pos1 = optional.orElse(pos);
            BlockPos pos2 = this.findSpawnPositionNear(serverLevel, pos1, maxDistance);
            if (pos2 != null && this.hasEnoughSpace(serverLevel, pos2)) {
                if (!serverLevel.getBiome(pos2).is(ForgeTags.Biomes.HAS_RUINED_PORTALS)) {
                    return false;
                }

                PiglinMerchant trader = ModEntityTypes.PIGLINMERCHANT.get()
                        .spawn(serverLevel, null,null, null, pos2,
                                MobSpawnType.EVENT, false, false);

                if (trader != null) {
                    trader.setDespawnDelay(defaultDespawnDelay);
                    trader.setWanderTarget(pos1);
                    trader.restrictTo(pos1, (maxDistance / 6));
                    return true;
                }
            }

            return false;
        }
    }

    @Nullable
    private BlockPos findSpawnPositionNear(LevelReader reader, BlockPos pos, int maxDistance) {
        BlockPos blockPos = null;

        for (int i = 0; i < spawnAttempts; ++i) {
            int j = pos.getX() + this.random.nextInt(maxDistance * 2) - maxDistance;
            int k = pos.getZ() + this.random.nextInt(maxDistance * 2) - maxDistance;
            int l = reader.getHeight(Heightmap.Types.WORLD_SURFACE, j, k);
            BlockPos blockPos1 = new BlockPos(j, l, k);
            if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, reader, blockPos1, ModEntityTypes.PIGLINMERCHANT.get())) {
                blockPos = blockPos1;
                break;
            }
        }

        return blockPos;
    }

    private boolean hasEnoughSpace(BlockGetter getter, BlockPos pos) {
        for (BlockPos pos1 : BlockPos.betweenClosed(pos, pos.offset(1, 2, 1))) {
            if (!getter.getBlockState(pos1).getCollisionShape(getter, pos1).isEmpty()) {
                return false;
            }
        }

        return true;
    }
}