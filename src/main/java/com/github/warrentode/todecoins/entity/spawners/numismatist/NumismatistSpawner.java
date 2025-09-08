package com.github.warrentode.todecoins.entity.spawners.numismatist;

import com.github.warrentode.todecoins.Config;
import com.github.warrentode.todecoins.entity.TCEntityTypes;
import com.github.warrentode.todecoins.entity.villager.Numismatist;
import com.github.warrentode.todecoins.entity.villager.TCVillagers;
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
import net.minecraft.world.entity.animal.horse.TraderLlama;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;

public class NumismatistSpawner implements CustomSpawner {
    private final NumismatistData numismatistData;
    @SuppressWarnings("unused")
    private final EntityType<Numismatist> entityType;
    public static final int defaultSpawnDelay = Config.getNumismatistSpawnDelay();
    public static final int defaultDespawnDelay = Config.getNumismatistDespawnDelay();
    private static final int tickDelayBeforeSpawn = defaultSpawnDelay / 20;
    private static final int minSpawnChance = 25;
    private static final int maxSpawnChance = 75;
    private static final int spawnChanceIncrease = minSpawnChance;
    private static final int spawnAttempts = 10;
    private static final int OneInXChanceToSpawn = spawnAttempts;
    private final RandomSource random = RandomSource.create();
    private int tickDelay;
    private int spawnDelay;
    private int spawnChance;

    public NumismatistSpawner(@NotNull MinecraftServer server, String key, EntityType<Numismatist> entityType) {
        this.numismatistData = NumismatistSavedData.get(server).getNumismatistData(key);
        this.entityType = entityType;
        this.tickDelay = tickDelayBeforeSpawn;
        this.spawnDelay = numismatistData.getNumismatistSpawnDelay();
        this.spawnChance = numismatistData.getNumismatistSpawnChance();
        if (this.spawnDelay == 0 && this.spawnChance == 0) {
            this.spawnDelay = defaultSpawnDelay;
            numismatistData.setNumismatistSpawnDelay(this.spawnDelay);
            this.spawnChance = minSpawnChance;
            numismatistData.setNumismatistSpawnChance(this.spawnChance);
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
            this.numismatistData.setNumismatistSpawnDelay(this.spawnDelay);
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
                    this.numismatistData.setNumismatistSpawnChance(this.spawnChance);
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
            int distance = 48;
            PoiManager poiManager = serverLevel.getPoiManager();
            Optional<BlockPos> optional = poiManager.find((poiTypeHolder) -> poiTypeHolder.is(TCVillagers.BANKER_POI.getId()),
                    (pos1) -> true, pos, distance, PoiManager.Occupancy.ANY);
            BlockPos pos1 = optional.orElse(pos);
            BlockPos pos2 = this.findSpawnPositionNear(serverLevel, pos1, distance);
            if (pos2 != null && this.hasEnoughSpace(serverLevel, pos2)) {
                if (serverLevel.getBiome(pos2).is(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS)) {
                    return false;
                }

                Numismatist trader = TCEntityTypes.NUMISMATIST.get()
                        .spawn(serverLevel, pos2, MobSpawnType.EVENT);
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

    @SuppressWarnings("SameParameterValue")
    private void tryToSpawnLlamaFor(ServerLevel serverLevel, @NotNull Numismatist numismatist, int maxDistance) {
        BlockPos pos = this.findSpawnPositionNear(serverLevel, numismatist.blockPosition(), maxDistance);
        if (pos != null) {
            TraderLlama traderllama = EntityType.TRADER_LLAMA
                    .spawn(serverLevel, pos, MobSpawnType.EVENT);
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
            if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, reader, blockPos1, TCEntityTypes.NUMISMATIST.get())) {
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