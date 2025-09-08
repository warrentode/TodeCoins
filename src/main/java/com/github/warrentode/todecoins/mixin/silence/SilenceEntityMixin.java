package com.github.warrentode.todecoins.mixin.silence;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class SilenceEntityMixin {

    @Unique
    private boolean todeCoins$hasSilenceCloakEffect() {
        Entity entity = (Entity) (Object) this;

        if (entity instanceof Player playerEntity && ModList.get().isLoaded("curios")) {
            return CuriosHelper.hasCurioItemEquipped(playerEntity,
                    TCItems.COLLECTIBLE_COIN_WARDEN_COPPER.get(),
                    TCItems.COLLECTIBLE_COIN_WARDEN_IRON.get(),
                    TCItems.COLLECTIBLE_COIN_WARDEN_GOLD.get(),
                    TCItems.COLLECTIBLE_COIN_WARDEN_NETHERITE.get()
            );
        }

        return (entity instanceof LivingEntity livingEntity)
                && livingEntity.hasEffect(TCMobEffects.SILENCE_CLOAK.get());
    }

    @Inject(method = {"dampensVibrations()Z"}, at = @At("HEAD"), cancellable = true)
    protected final void todeCoins$dampensVibrations(CallbackInfoReturnable<Boolean> cir) {
        if (todeCoins$hasSilenceCloakEffect()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = {"isSilent()Z"}, at = @At("HEAD"), cancellable = true)
    protected final void todeCoins$isSilent(CallbackInfoReturnable<Boolean> cir) {
        if (todeCoins$hasSilenceCloakEffect()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = {"playStepSound(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V"}, at = @At("HEAD"), cancellable = true)
    protected final void todeCoins$playStepSound(BlockPos blockPos, BlockState blockState, CallbackInfo ci) {
        if (todeCoins$hasSilenceCloakEffect()) {
            ci.cancel();
        }
    }

    @Inject(method = {"playAmethystStepSound()V"}, at = @At("HEAD"), cancellable = true)
    protected final void todeCoins$playAmethystStepSound(CallbackInfo ci) {
        if (todeCoins$hasSilenceCloakEffect()) {
            ci.cancel();
        }
    }

    @Inject(method = {"playSwimSound(F)V"}, at = @At("HEAD"), cancellable = true)
    protected final void todeCoins$playSwimSound(float volume, CallbackInfo ci) {
        if (todeCoins$hasSilenceCloakEffect()) {
            ci.cancel();
        }
    }
}