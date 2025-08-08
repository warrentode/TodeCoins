package com.github.warrentode.todecoins.entity.trades;

import com.github.warrentode.todecoins.config.Config;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom.*;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class WanderingTraderTrades {
    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull WandererTradesEvent event) {
            List<VillagerTrades.ItemListing> commonWandererTrades = event.getGenericTrades();
            List<VillagerTrades.ItemListing> rareWandererTrades = event.getRareTrades();

            commonWandererTrades.clear();
            rareWandererTrades.clear();

            for (int i = 0; i < Config.getMaxWandererTrades(); ++i) {
                // COMMON TRADES
                commonWandererTrades.add(
                        new LootTableForLootTableFactory(
                                ResourceLocation.tryParse(TradeLootTables.WANDERING_PURCHASE_TABLE.toString()),
                                ResourceLocation.tryParse(TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString()),
                                TradeOfferConstants.RARE_MAX_TRADES,
                                TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                                TradeOfferConstants.RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForTagTableFactory(
                                ResourceLocation.tryParse(TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString()),
                                ResourceLocation.tryParse(TradeLootTables.TAGGED_DYES_TABLE.toString()),
                                3,
                                TradeOfferConstants.RARE_MAX_TRADES,
                                TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                                TradeOfferConstants.RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForLootTableFactory(
                                ResourceLocation.tryParse(TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString()),
                                ResourceLocation.tryParse(TradeLootTables.WANDERING_SELL_TWO_EMERALD_VALUE_TABLE.toString()),
                                TradeOfferConstants.RARE_MAX_TRADES,
                                TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                                TradeOfferConstants.RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForLootTableFactory(
                                ResourceLocation.tryParse(TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString()),
                                ResourceLocation.tryParse(TradeLootTables.WANDERING_SELL_THREE_EMERALD_VALUE_TABLE.toString()),
                                TradeOfferConstants.RARE_MAX_TRADES,
                                TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                                TradeOfferConstants.RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForItemFactory(
                                ResourceLocation.tryParse(TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString()),
                                new ItemStack(Items.SLIME_BALL),
                                1,
                                TradeOfferConstants.RARE_MAX_TRADES,
                                TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                                TradeOfferConstants.RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForLootTableFactory(
                                ResourceLocation.tryParse(TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString()),
                                ResourceLocation.tryParse(TradeLootTables.WANDERING_SELL_FIVE_EMERALD_VALUE_TABLE.toString()),
                                TradeOfferConstants.RARE_MAX_TRADES,
                                TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                                TradeOfferConstants.RARE_TRADE_MULTIPLIER
                        ));
            }

            // RARE TRADES
            rareWandererTrades.add(
                    new LootTableForLootTableFactory(
                            ResourceLocation.tryParse(TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString()),
                            ResourceLocation.tryParse(TradeLootTables.WANDERING_SELL_SPECIAL_TABLE.toString()),
                            TradeOfferConstants.RARE_MAX_TRADES,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                            TradeOfferConstants.RARE_TRADE_MULTIPLIER
                    ));
            rareWandererTrades.add(
                    new LootTableForEnchantedItemTableFactory(
                            ResourceLocation.tryParse(TradeLootTables.IRON_TIER_TOOLS_TABLE.toString()),
                            ResourceLocation.tryParse(TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString()),
                            TradeOfferConstants.RARE_MAX_TRADES,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                            TradeOfferConstants.RARE_TRADE_MULTIPLIER
                    ));
            rareWandererTrades.add(
                    new LootTableForItemFactory(
                            ResourceLocation.tryParse(TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString()),
                            new ItemStack(Items.BLUE_ICE),
                            1,
                            TradeOfferConstants.RARE_MAX_TRADES,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                            TradeOfferConstants.RARE_TRADE_MULTIPLIER
                    ));
            rareWandererTrades.add(
                    new LootTableForLootBoxFactory(
                            new ItemStack(Items.SHULKER_BOX),
                            "Mystery Loot Box",
                            ResourceLocation.tryParse(BuiltInLootTables.ABANDONED_MINESHAFT.toString()),
                            ResourceLocation.tryParse(TradeLootTables.SIXTEEN_EMERALD_TABLE.toString()),
                            1,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                            TradeOfferConstants.RARE_TRADE_MULTIPLIER
                    ));
        }
    }
}