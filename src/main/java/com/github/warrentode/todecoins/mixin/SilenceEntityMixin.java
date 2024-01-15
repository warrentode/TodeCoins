package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class SilenceEntityMixin {
    @Unique
    Entity todeCoins$entity = (Entity) ((Object) this);

    @Inject(
            method = {"dampensVibrations()Z"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    protected void todeCoins_dampensVibrations(CallbackInfoReturnable<Boolean> cir) {
        if (todeCoins$entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(ModEffects.SILENCE_CLOAK.get())) {
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(
            method = {"isSilent()Z"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    protected void todeCoins_isSilent(CallbackInfoReturnable<Boolean> cir) {
        if (todeCoins$entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(ModEffects.SILENCE_CLOAK.get())) {
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(
            method = {"playStepSound(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    protected void todeCoins_playStepSound(BlockPos blockPos, BlockState blockState, CallbackInfo ci) {
        if (todeCoins$entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(ModEffects.SILENCE_CLOAK.get())) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"playAmethystStepSound(Lnet/minecraft/world/level/block/state/BlockState;)V"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    protected void todeCoins_playAmethystStepSound(BlockState pState, CallbackInfo ci) {
        if (todeCoins$entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(ModEffects.SILENCE_CLOAK.get())) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = {"playSwimSound(F)V"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    protected void todeCoins_playSwimSound(float volume, CallbackInfo ci) {
        if (todeCoins$entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(ModEffects.SILENCE_CLOAK.get())) {
                ci.cancel();
            }
        }
    }
}