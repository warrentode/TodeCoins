package com.github.warrentode.todecoins.entity.trades.trade_api;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class TradeInjectionHelper {

    private static final Set<Entity> alreadyInjected = Collections.newSetFromMap(new WeakHashMap<>());

    public static void tryInjectTrades(Merchant merchant) {
        if (!(merchant instanceof Entity entity)) return;

        // Prevent duplicate injection
        if (alreadyInjected.contains(entity)) return;

        EntityType<?> type = entity.getType();
        TradeOfferManager tradeManager = TodeCoins.TRADE_OFFER_MANAGER;
        TradeOfferManager.MerchantLevel level = TradeOfferManager.MerchantLevel.NOVICE; // or detect from entity logic

        tradeManager.getOffersForMerchant(type, level).ifPresent(trades -> {
            MerchantOffers offers = merchant.getOffers();

            for (VillagerTrades.ItemListing listing : trades) {
                MerchantOffer offer = listing.getOffer(entity, entity.level.random);
                if (offer != null) {
                    offers.add(offer);
                }
            }

            alreadyInjected.add(entity);
            TodeCoins.LOGGER.info("Injected custom trades into entity: {}", type);
        });
    }

    public static void clearCache() {
        alreadyInjected.clear();
    }
}