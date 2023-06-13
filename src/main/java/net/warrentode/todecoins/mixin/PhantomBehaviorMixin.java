package net.warrentode.todecoins.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;

@Mixin(Phantom.PhantomSweepAttackGoal.class)
public abstract class PhantomBehaviorMixin {
    private static boolean isWearingCatCoin(Player player) {
        Optional<SlotResult> optional1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_PIGLIN_COIN.get());
        Optional<SlotResult> optional2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_PIGLIN_COIN.get());
        Optional<SlotResult> optional3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_PIGLIN_COIN.get());
        Optional<SlotResult> optional4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_PIGLIN_COIN.get());
        ItemStack catCoin = null;

        if (TodeCoins.isCuriosLoaded()) {
            if (optional1.isPresent()) {
                catCoin = optional1.get().stack();
            }
            else if (optional2.isPresent()) {
                catCoin = optional2.get().stack();
            }
            else if (optional3.isPresent()) {
                catCoin = optional3.get().stack();
            }
            else if (optional4.isPresent()) {
                catCoin = optional4.get().stack();
            }
        }
        return catCoin != null;
    }

    @Inject(at = @At("HEAD"), method = "canContinueToUse()Z", cancellable = true)
    private void canContinueToUse(CallbackInfoReturnable<Boolean> cir) {
        Player player = Minecraft.getInstance().player;
        if (isWearingCatCoin(player)) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}