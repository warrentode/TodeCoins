package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.effect.ModEffects;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public class SilenceMobMixin {
    @Unique
    Mob todeCoins$mob = (Mob) ((Object) this);

    @Inject(
            method = {"playAmbientSound()V"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void todeCoins_playAmbientSound(CallbackInfo ci) {
        if (todeCoins$mob.hasEffect(ModEffects.SILENCE_CLOAK.get())) {
            ci.cancel();
        }
    }
}