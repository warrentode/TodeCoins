package com.github.warrentode.todecoins.mixin.villagers;

import com.github.warrentode.todecoins.Config;
import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(WanderingTrader.class)
public class WanderingTraderMixin {

    @Unique
    final WanderingTrader todeCoins$wanderingTrader = (WanderingTrader) (Object) this;


    @Inject(method = "updateTrades", at = @At("HEAD"), cancellable = true)
    protected void updateTrades(@NotNull CallbackInfo ci) {
        if (Config.getReplaceWanderingTraderTrades()) {
            todeCoins$rebuildTrades();
            ci.cancel();
        }
    }

    @Unique
    protected void todeCoins$rebuildTrades() {
        // Get the common and rare trades from your TradeOfferManager
        TradeOfferManager manager = TodeCoins.TRADE_OFFER_MANAGER;
        Optional<VillagerTrades.ItemListing[]> commonTradesOpt = manager.getWanderingTraderOffers(TradeOfferManager.MerchantLevel.COMMON);
        Optional<VillagerTrades.ItemListing[]> rareTradesOpt = manager.getWanderingTraderOffers(TradeOfferManager.MerchantLevel.RARE);

        // Only use custom trades if both common and rare exist
        if (commonTradesOpt.isPresent() && rareTradesOpt.isPresent()) {
            VillagerTrades.ItemListing[] commonTrades = commonTradesOpt.get();
            VillagerTrades.ItemListing[] rareTrades = rareTradesOpt.get();

            MerchantOffers offers = todeCoins$wanderingTrader.getOffers();
            RandomSource randomSource = RandomSource.create();
            int maxTrades = Config.getMaxWandererTrades(); // configurable

            // Add up to maxTrades from commonTrades, randomly repeating if necessary
            for (int i = 0; i < maxTrades; i++) {
                VillagerTrades.ItemListing listing = commonTrades[randomSource.nextInt(commonTrades.length)];
                MerchantOffer offer = listing.getOffer(todeCoins$wanderingTrader, randomSource);
                if (offer != null) offers.add(offer);
            }

            // Add one random rare trade
            VillagerTrades.ItemListing rareListing = rareTrades[randomSource.nextInt(rareTrades.length)];
            MerchantOffer rareOffer = rareListing.getOffer(todeCoins$wanderingTrader, randomSource);
            if (rareOffer != null) offers.add(rareOffer);

            // Cancel the normal trade population since we're replacing it
            return;
        }

        // Fallback to vanilla trade behavior if custom trades aren't present
        VillagerTrades.ItemListing[] vanillaCommon = VillagerTrades.WANDERING_TRADER_TRADES.get(1);
        VillagerTrades.ItemListing[] vanillaRare = VillagerTrades.WANDERING_TRADER_TRADES.get(2);
        if (vanillaCommon != null && vanillaRare != null) {
            RandomSource randomSource = RandomSource.create();
            MerchantOffers merchantOffers = todeCoins$wanderingTrader.getOffers();
            todeCoins$wanderingTrader.addOffersFromItemListings(merchantOffers, vanillaCommon, Config.getMaxWandererTrades());
            VillagerTrades.ItemListing rareListing = vanillaRare[randomSource.nextInt(vanillaRare.length)];
            MerchantOffer merchantOffer = rareListing.getOffer(todeCoins$wanderingTrader, randomSource);
            if (merchantOffer != null) merchantOffers.add(merchantOffer);
        }
    }
}