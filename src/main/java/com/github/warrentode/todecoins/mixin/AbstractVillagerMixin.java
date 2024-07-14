package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.config.CommonConfig;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.item.trading.MerchantOffers;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractVillager.class)
public abstract class AbstractVillagerMixin {
    @Unique
    AbstractVillager todeCoins$abstractVillager = (AbstractVillager)(Object) this;
    @Shadow public abstract MerchantOffers getOffers();
    @Accessor("offers")
    abstract void setOffers(MerchantOffers offer);

    @Inject(at = {@At("HEAD")}, method = {"getOffers()Lnet/minecraft/world/item/trading/MerchantOffers;"}, cancellable = true)
    private void todeCoins_resetOffers(@NotNull CallbackInfoReturnable<MerchantOffers> cir) {
        MerchantOffers offers = getOffers();
        MerchantOffers newOffers = new MerchantOffers();

        if (CommonConfig.getResetTrades()) {
            offers.clear();
            setOffers(newOffers);
            todeCoins$abstractVillager.updateTrades();
            cir.setReturnValue(newOffers);
        }
    }
}