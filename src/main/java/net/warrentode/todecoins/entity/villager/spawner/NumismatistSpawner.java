package net.warrentode.todecoins.entity.villager.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.animal.horse.TraderLlama;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.levelgen.Heightmap;
import net.warrentode.todecoins.entity.ModEntityTypes;
import net.warrentode.todecoins.entity.villager.Numismatist;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;

public class NumismatistSpawner implements CustomSpawner {
    private final NumismatistData data;
    private final EntityType<Numismatist> entityType;
    private static final int tickDelayBeforeSpawn = 1200;
    public static final int defaultSpawnDelay = 24000;
    public static final int defaultDespawnDelay = 48000;
    private static final int minSpawnChance = 25;
    private static final int maxSpawnChance = 75;
    private static final int spawnChanceIncrease = minSpawnChance;
    private static final int OneInXChanceToSpawn = 10;
    private static final int spawnAttempts = 10;
    private final RandomSource random = RandomSource.create();
    private int tickDelay;
    private int spawnDelay;
    private int spawnChance;

    public NumismatistSpawner(@NotNull MinecraftServer server, String key, EntityType<Numismatist> entityType) {
        this.data = NumismatistSavedData.get(server).getNumismatistData(key);
        this.entityType = entityType;
        this.tickDelay = tickDelayBeforeSpawn;
        this.spawnDelay = this.data.getNumismatistSpawnDelay();
        this.spawnChance = this.data.getNumismatistSpawnChance();
        if (this.spawnDelay == 0 && this.spawnChance == 0) {
            this.spawnDelay = defaultSpawnDelay;
            this.spawnChance = minSpawnChance;
            this.data.setNumismatistSpawnDelay(this.spawnDelay);
            this.data.setNumismatistSpawnChance(this.spawnChance);
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
            this.data.setNumismatistSpawnDelay(this.spawnDelay);
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
                    this.data.setNumismatistSpawnChance(this.spawnChance);
                    if (this.random.nextInt(100) > i) {
                        return 0;
                    }
                    else if (this.spawn(serverLevel)) {
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

    private boolean spawn(@NotNull ServerLevel serverLevel) {
        Player player = serverLevel.getRandomPlayer();
        if (player == null) {
            return true;
        }
        else if (this.random.nextInt(OneInXChanceToSpawn) != 0) {
            return false;
        }
        else {
            BlockPos pos = player.blockPosition();
            int i = 48;
            PoiManager poiManager = serverLevel.getPoiManager();
            Optional<BlockPos> optional = poiManager.find((poiTypeHolder) -> poiTypeHolder.is(PoiTypes.MEETING),
                    (pos1) -> true, pos, 48, PoiManager.Occupancy.ANY);
            BlockPos pos1 = optional.orElse(pos);
            BlockPos pos2 = this.findSpawnPositionNear(serverLevel, pos1, 48);
            if (pos2 != null && this.hasEnoughSpace(serverLevel, pos2)) {
                if (serverLevel.getBiome(pos2).is(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS)) {
                    return false;
                }

                Numismatist trader = ModEntityTypes.NUMISMATIST.get().spawn(serverLevel, null,
                        null, null, pos2, MobSpawnType.EVENT, false, false);
                if (trader != null) {
                    for (int j = 0; j < 2; ++j) {
                        this.tryToSpawnLlamaFor(serverLevel, trader, 4);
                    }

                    trader.setDespawnDelay(defaultDespawnDelay);
                    trader.setWanderTarget(pos1);
                    trader.restrictTo(pos1, 16);
                    return true;
                }
            }

            return false;
        }
    }

    private void tryToSpawnLlamaFor(ServerLevel serverLevel, @NotNull Numismatist numismatist, int maxDistance) {
        BlockPos pos = this.findSpawnPositionNear(serverLevel, numismatist.blockPosition(), maxDistance);
        if (pos != null) {
            TraderLlama traderllama = EntityType.TRADER_LLAMA.spawn(serverLevel, null, null,
                    null, pos, MobSpawnType.EVENT, false, false);
            if (traderllama != null) {
                traderllama.setLeashedTo(numismatist, true);
            }
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
            if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, reader, blockPos1, ModEntityTypes.NUMISMATIST.get())) {
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