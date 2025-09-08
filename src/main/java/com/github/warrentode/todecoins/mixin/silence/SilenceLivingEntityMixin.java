package com.github.warrentode.todecoins.mixin.silence;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class SilenceLivingEntityMixin {
    @Unique
    private boolean todeCoins$hasSilenceCloakEffect() {
        Entity entity = (Entity) (Object) this;

        if (entity instanceof LivingEntity livingEntity) {
            return livingEntity.hasEffect(TCMobEffects.SILENCE_CLOAK.get());
        }

        else if (entity instanceof Player playerEntity && ModList.get().isLoaded("curios")) {
            return CuriosHelper.hasCurioItemEquipped(playerEntity,
                    TCItems.COLLECTIBLE_COIN_WARDEN_COPPER.get(),
                    TCItems.COLLECTIBLE_COIN_WARDEN_IRON.get(),
                    TCItems.COLLECTIBLE_COIN_WARDEN_GOLD.get(),
                    TCItems.COLLECTIBLE_COIN_WARDEN_NETHERITE.get()
            );
        }

        return false;
    }

    @Inject(method = {"triggerItemUseEffects(Lnet/minecraft/world/item/ItemStack;I)V"}, at = @At("HEAD"), cancellable = true)
    protected final void todeCoins$triggerItemUseEffects(ItemStack stack, int amount, CallbackInfo ci) {
        LivingEntity todeCoins$livingEntity = (LivingEntity) ((Object) this);
        if (todeCoins$hasSilenceCloakEffect()) {
            if (!stack.isEmpty() && todeCoins$livingEntity.isUsingItem()) {
                if (stack.getUseAnimation() == UseAnim.DRINK) {
                    ci.cancel();
                }
                else if (stack.getUseAnimation() == UseAnim.EAT) {
                    todeCoins$livingEntity.spawnItemParticles(stack, amount);
                    ci.cancel();
                }
            }
        }
    }
    @Inject(method = {"playHurtSound"}, at = @At("HEAD"), cancellable = true)
    private void todeCoins$playHurtSound(CallbackInfo ci) {
        if (todeCoins$hasSilenceCloakEffect()) {
            ci.cancel();
        }
    }
}