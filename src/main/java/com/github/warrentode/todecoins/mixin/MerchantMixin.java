package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.inventory.MerchantMenu;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MerchantMenu.class)
public abstract class MerchantMixin {
    // This is the marker used in the merchant's persistent NBT
    @Unique
    private static final String TRADE_INJECTED_TAG = "todecoins.trade_injected";

    @Inject(method = "setOffers", at = @At("HEAD"))
    private void onSetOffers(MerchantOffers offers, CallbackInfo ci) {
        // Get the merchant instance from this menu
        Merchant merchant = ((MerchantMenuAccessor) this).getTrader();
        if (!(merchant instanceof Entity entity)) return;

        CompoundTag data = entity.getPersistentData();
        if (data.getBoolean(TRADE_INJECTED_TAG)) {
            return; // Already injected
        }

        // Get your custom trades from TradeOfferManager
        TradeOfferManager.MerchantLevel level = TradeOfferManager.MerchantLevel.NOVICE; // or your own logic

        TodeCoins.TRADE_OFFER_MANAGER.getOffersForMerchant(entity.getType(), level).ifPresent(customTrades -> {
            for (VillagerTrades.ItemListing trade : customTrades) {
                MerchantOffer offer = trade.getOffer(entity, entity.level.random);
                if (offer != null) offers.add(offer);
            }
        });

        // Mark as injected so it doesn't duplicate
        data.putBoolean(TRADE_INJECTED_TAG, true);
    }
}