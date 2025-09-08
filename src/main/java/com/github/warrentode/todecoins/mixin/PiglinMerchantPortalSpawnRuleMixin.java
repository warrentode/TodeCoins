package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.entity.TCEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.github.warrentode.todecoins.Config.getPiglinMerchantPortalTickSpawnChance;

@Mixin(NetherPortalBlock.class)
public abstract class PiglinMerchantPortalSpawnRuleMixin {
    @Unique
    final Block piglinmerchant$pBlock = (Block) (Object) this;

    @Inject(at = @At("HEAD"), method = "randomTick")
    private void piglinmerchant_randomTick(BlockState blockState, @NotNull ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource, CallbackInfo ci) {
        if (serverLevel.dimensionType().natural() && serverLevel.getGameRules().getBoolean(GameRules.RULE_DO_TRADER_SPAWNING) && randomSource.nextInt(getPiglinMerchantPortalTickSpawnChance()) < serverLevel.getDifficulty().getId()) {
            while(serverLevel.getBlockState(blockPos).is(piglinmerchant$pBlock)) {
                blockPos = blockPos.below();
            }

            if (serverLevel.getBlockState(blockPos).isValidSpawn(serverLevel, blockPos, TCEntityTypes.PIGLINMERCHANT.get())) {
                Entity entity = TCEntityTypes.PIGLINMERCHANT.get().spawn(serverLevel, blockPos.above(), MobSpawnType.STRUCTURE);
                if (entity != null) {
                    entity.setPortalCooldown();
                }
            }
        }
    }
}