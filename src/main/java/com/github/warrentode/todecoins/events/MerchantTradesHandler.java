package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.Config;
import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class MerchantTradesHandler {

    /** Replaces the trades of other supported mod's custom merchants based on config toggle setting */

    @SubscribeEvent
    public static void onEntityJoinLevelEvent(@NotNull EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();

        // checks for supported modded merchants
        if (entity instanceof Merchant trader) {
            if (ModList.get().isLoaded("goblintraders") && Config.getReplaceGoblinTraderTrades()) {
                EntityType<?> goblinTraderType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse("goblintraders:goblin_trader"));
                EntityType<?> veinGoblinTraderType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse("goblintraders:vein_goblin_trader"));

                if (goblinTraderType != null && entity.getType() == goblinTraderType) {
                    // Clear existing trades
                    MerchantOffers offers = trader.getOffers();
                    offers.clear();

                    // Seed random similarly to the trader
                    Random random = new Random();
                    RandomSource randomSource = RandomSource.create();

                    // Add COMMON trades
                    TodeCoins.TRADE_OFFER_MANAGER.getOffersForGoblinTrader(TradeOfferManager.MerchantLevel.COMMON)
                            .ifPresent(commonTrades -> {
                                List<VillagerTrades.ItemListing> shuffled = Arrays.asList(commonTrades);
                                Collections.shuffle(shuffled, random);
                                for (VillagerTrades.ItemListing listing : shuffled) {
                                    MerchantOffer offer = listing.getOffer(entity, randomSource);
                                    if (offer != null) offers.add(offer);
                                }
                            });

                    // Add RARE trades
                    TodeCoins.TRADE_OFFER_MANAGER.getOffersForGoblinTrader(TradeOfferManager.MerchantLevel.RARE)
                            .ifPresent(rareTrades -> {
                                List<VillagerTrades.ItemListing> shuffled = Arrays.asList(rareTrades);
                                Collections.shuffle(shuffled, random);
                                if (!shuffled.isEmpty()) {
                                    MerchantOffer offer = shuffled.get(0).getOffer(entity, randomSource);
                                    if (offer != null) offers.add(offer);
                                }
                            });
                }
                if (veinGoblinTraderType != null && entity.getType() == veinGoblinTraderType) {
                    // Clear existing trades
                    MerchantOffers offers = trader.getOffers();
                    offers.clear();

                    // Seed random similarly to the trader
                    Random random = new Random();
                    RandomSource randomSource = RandomSource.create();

                    // Add COMMON trades
                    TodeCoins.TRADE_OFFER_MANAGER.getOffersForGoblinTrader(TradeOfferManager.MerchantLevel.COMMON)
                            .ifPresent(commonTrades -> {
                                List<VillagerTrades.ItemListing> shuffled = Arrays.asList(commonTrades);
                                Collections.shuffle(shuffled, random);
                                for (VillagerTrades.ItemListing listing : shuffled) {
                                    MerchantOffer offer = listing.getOffer(entity, randomSource);
                                    if (offer != null) offers.add(offer);
                                }
                            });

                    // Add RARE trades
                    TodeCoins.TRADE_OFFER_MANAGER.getOffersForGoblinTrader(TradeOfferManager.MerchantLevel.RARE)
                            .ifPresent(rareTrades -> {
                                List<VillagerTrades.ItemListing> shuffled = Arrays.asList(rareTrades);
                                Collections.shuffle(shuffled, random);
                                if (!shuffled.isEmpty()) {
                                    MerchantOffer offer = shuffled.get(0).getOffer(entity, randomSource);
                                    if (offer != null) offers.add(offer);
                                }
                            });
                }
            }
            if (ModList.get().isLoaded("supplementaries") && Config.getReplaceRedMerchantTrades()) {
                EntityType<?> redMerchantType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse("supplementaries:red_merchant"));

                if (redMerchantType != null && entity.getType() == redMerchantType) {
                    // Clear existing trades
                    MerchantOffers offers = trader.getOffers();
                    offers.clear();

                    // Seed random similarly to the trader
                    Random random = new Random();
                    RandomSource randomSource = RandomSource.create();

                    // Add COMMON trades
                    TodeCoins.TRADE_OFFER_MANAGER.getOffersForRedMerchant(TradeOfferManager.MerchantLevel.COMMON)
                            .ifPresent(commonTrades -> {
                                List<VillagerTrades.ItemListing> shuffled = Arrays.asList(commonTrades);
                                Collections.shuffle(shuffled, random);
                                for (VillagerTrades.ItemListing listing : shuffled) {
                                    MerchantOffer offer = listing.getOffer(entity, randomSource);
                                    if (offer != null) offers.add(offer);
                                }
                            });

                    // Add RARE trades
                    TodeCoins.TRADE_OFFER_MANAGER.getOffersForRedMerchant(TradeOfferManager.MerchantLevel.RARE)
                            .ifPresent(rareTrades -> {
                                List<VillagerTrades.ItemListing> shuffled = Arrays.asList(rareTrades);
                                Collections.shuffle(shuffled, random);
                                if (!shuffled.isEmpty()) {
                                    MerchantOffer offer = shuffled.get(0).getOffer(entity, randomSource);
                                    if (offer != null) offers.add(offer);
                                }
                            });
                }
            }
        }
    }
}