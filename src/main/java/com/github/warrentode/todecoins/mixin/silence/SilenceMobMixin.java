package com.github.warrentode.todecoins.mixin.silence;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public class SilenceMobMixin {

    @Inject(method = {"playAmbientSound()V"}, at = @At("HEAD"), cancellable = true)
    private void todeCoins$playAmbientSound(CallbackInfo ci) {
        Mob todeCoins$mob = (Mob) ((Object) this);
        if (todeCoins$mob.hasEffect(TCMobEffects.SILENCE_CLOAK.get())) {
            ci.cancel();
        }
    }

    @Inject(method = {"playHurtSound"},at = @At("HEAD"),cancellable = true)
    private void todeCoins$playHurtSound(CallbackInfo ci) {
        Mob todeCoins$mob = (Mob) ((Object) this);
        if (todeCoins$mob.hasEffect(TCMobEffects.SILENCE_CLOAK.get())) {
            ci.cancel();
        }
    }
}