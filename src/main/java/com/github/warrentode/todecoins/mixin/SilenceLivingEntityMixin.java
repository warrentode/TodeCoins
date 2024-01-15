package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.effect.ModEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class SilenceLivingEntityMixin {
    @Unique
    LivingEntity todeCoins$livingEntity = (LivingEntity) ((Object) this);

    @Inject(
            method = {"triggerItemUseEffects(Lnet/minecraft/world/item/ItemStack;I)V"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    protected void todeCoins_triggerItemUseEffects(ItemStack stack, int amount, CallbackInfo ci) {
        if (todeCoins$livingEntity.hasEffect(ModEffects.SILENCE_CLOAK.get())) {
            if (!stack.isEmpty() && todeCoins$livingEntity.isUsingItem()) {
                if (stack.getUseAnimation() == UseAnim.DRINK) {
                    ci.cancel();
                }

                if (stack.getUseAnimation() == UseAnim.EAT) {
                    todeCoins$livingEntity.spawnItemParticles(stack, amount);
                    ci.cancel();
                }
            }
        }
    }
}