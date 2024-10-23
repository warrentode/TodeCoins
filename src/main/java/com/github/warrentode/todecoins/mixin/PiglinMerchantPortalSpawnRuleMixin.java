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
    private void piglinmerchant_randomTick(BlockState pState, @NotNull ServerLevel pLevel, BlockPos pPos, RandomSource pRandom, CallbackInfo ci) {
        if (pLevel.dimensionType().natural() && pLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) && pRandom.nextInt(getPiglinMerchantPortalTickSpawnRate()) < pLevel.getDifficulty().getId()) {
            while(pLevel.getBlockState(pPos).is(piglinmerchant$pBlock)) {
                pPos = pPos.below();
            }

            if (pLevel.getBlockState(pPos).isValidSpawn(pLevel, pPos, ModEntityTypes.PIGLINMERCHANT.get())) {
                Entity entity = ModEntityTypes.PIGLINMERCHANT.get().spawn(pLevel, null, null, null, pPos.above(), MobSpawnType.STRUCTURE, false, false);
                if (entity != null) {
                    entity.setPortalCooldown();
                }
            }
        }
    }
}