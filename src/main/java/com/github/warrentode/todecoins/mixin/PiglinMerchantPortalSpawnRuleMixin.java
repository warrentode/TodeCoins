package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.entity.ModEntityTypes;
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

import static com.github.warrentode.todecoins.config.CommonConfig.getPiglinMerchantPortalTickSpawnRate;

@Mixin(NetherPortalBlock.class)
public abstract class PiglinMerchantPortalSpawnRuleMixin {
    @SuppressWarnings("CanBeFinal")
    @Unique
    Block piglinmerchant$pBlock = (Block) (Object) this;

    @Inject(at = @At("HEAD"), method = "randomTick")
    private void piglinmerchant_randomTick(BlockState blockState, @NotNull ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource, CallbackInfo ci) {
        if (serverLevel.dimensionType().natural() && serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) && randomSource.nextInt(getPiglinMerchantPortalTickSpawnRate()) < serverLevel.getDifficulty().getId()) {
            while(serverLevel.getBlockState(blockPos).is(piglinmerchant$pBlock)) {
                blockPos = blockPos.below();
            }

            if (serverLevel.getBlockState(blockPos).isValidSpawn(serverLevel, blockPos, ModEntityTypes.PIGLINMERCHANT.get())) {
                Entity entity = ModEntityTypes.PIGLINMERCHANT.get().spawn(serverLevel, null, null, null, blockPos.above(), MobSpawnType.STRUCTURE, false, false);
                if (entity != null) {
                    entity.setPortalCooldown();
                }
            }
        }
    }
}