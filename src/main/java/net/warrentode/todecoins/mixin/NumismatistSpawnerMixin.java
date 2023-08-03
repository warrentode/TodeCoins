package net.warrentode.todecoins.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.animal.horse.TraderLlama;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.WanderingTraderSpawner;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.storage.ServerLevelData;
import net.warrentode.todecoins.entity.ModEntityTypes;
import net.warrentode.todecoins.entity.villager.Numismatist;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Optional;

@Mixin(WanderingTraderSpawner.class)
public abstract class NumismatistSpawnerMixin {
    @Shadow
    @Final
    private RandomSource random;
    @Final
    @Shadow
    private ServerLevelData serverLevelData;
    @Unique
    private String todeCoins$merchant;

    @Inject(method = "spawn", at = @At("HEAD"), cancellable = true)
    public void todecoins_wanderingTrader_spawn(@NotNull ServerLevel serverLevel, CallbackInfoReturnable<Boolean> cir) {
        Player player = serverLevel.getRandomPlayer();
        if (player == null) {
            cir.setReturnValue(true);
        }
        else if (this.random.nextInt(10) != 0) {
            cir.setReturnValue(false);
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
                    cir.setReturnValue(false);
                }

                Numismatist numismatist = ModEntityTypes.NUMISMATIST.get().spawn(serverLevel, null,
                        null, null, pos2, MobSpawnType.EVENT, false, false);

                if (this.random.nextInt(10) >= 8) {
                    todeCoins$merchant = String.valueOf(numismatist);
                }

                if (Objects.equals(todeCoins$merchant, String.valueOf(numismatist))) {
                    if (numismatist != null) {
                        for (int j = 0; j < 2; ++j) {
                            this.todeCoins$tryToSpawnLlamaForTrader(serverLevel, numismatist, 4);
                        }

                        this.serverLevelData.setWanderingTraderId(numismatist.getUUID());
                        numismatist.setDespawnDelay(48000);
                        numismatist.setWanderTarget(pos1);
                        numismatist.restrictTo(pos1, 16);
                        cir.setReturnValue(true);
                        cir.cancel();
                    }
                }
            }
            cir.setReturnValue(false);
        }
    }

    @Unique
    private void todeCoins$tryToSpawnLlamaForTrader(ServerLevel serverLevel, @NotNull Numismatist numismatist, int maxDistance) {
        BlockPos pos = this.findSpawnPositionNear(serverLevel, numismatist.blockPosition(), maxDistance);
        if (pos != null) {
            TraderLlama traderllama = EntityType.TRADER_LLAMA.spawn(serverLevel, null, null,
                    null, pos, MobSpawnType.EVENT, false, false);
            if (traderllama != null) {
                traderllama.setLeashedTo(numismatist, true);
            }
        }
    }

    @Shadow
    protected abstract void tryToSpawnLlamaFor(ServerLevel pServerLevel, WanderingTrader pTrader, int pMaxDistance);

    @Shadow
    protected abstract boolean hasEnoughSpace(BlockGetter reader, BlockPos pos);

    @Shadow
    protected abstract BlockPos findSpawnPositionNear(LevelReader world, BlockPos pos, int i);
}