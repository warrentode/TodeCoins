package com.github.warrentode.todecoins.entity.trades;

import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom.LootTableForEnchantedItemTableFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom.LootTableForSpecifiedEnchantmentFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom.LootTableForTagTableFactory;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class PiglinMerchantTrades {
    // for default trades
    static int rarityLevel1 = 1;
    static int rarityLevel2 = 2;
    static int commonSupply = TradeOfferConstants.COMMON_MAX_TRADES;
    static int rareSupply = TradeOfferConstants.RARE_MAX_TRADES;
    static int baseXP = TradeOfferConstants.BASE_XP;
    static float commonTradeMultiplier = TradeOfferConstants.COMMON_TRADE_MULTIPLIER;
    static float rareTradeMultiplier = TradeOfferConstants.RARE_TRADE_MULTIPLIER;

    @Contract("_ -> new")
    private static @NotNull Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> PIGLINMERCHANT_TRADES = makeTrades();

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeTrades() {
        return PIGLINMERCHANT_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // cheap barter loot trade
                                new LootTableForTagTableFactory(
                                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.CHEAP_TRADE_GOODS,
                                        6, commonSupply, baseXP, commonTradeMultiplier
                                ),
                                // common currency barter loot
                                new LootTableForTagTableFactory(
                                        ResourceLocation.tryParse(TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE.toString()),
                                        ResourceLocation.tryParse(TradeLootTables.COMMON_TRADE_GOODS.toString()),
                                        1,
                                        commonSupply, baseXP, commonTradeMultiplier
                                ),
                                // common currency enchantable barter loot
                                new LootTableForEnchantedItemTableFactory(
                                        ResourceLocation.tryParse(TradeLootTables.IRON_TIER_EQUIPMENT_SET.toString()),
                                        ResourceLocation.tryParse(TradeLootTables.SIX_NETHER_GOLD_COIN_BAG_TABLE.toString()),
                                        rareSupply, baseXP, rareTradeMultiplier
                                ),
                                // uncommon currency barter loot
                                new LootTableForTagTableFactory(
                                        ResourceLocation.tryParse(TradeLootTables.FIFTEEN_NETHER_GOLD_COIN_TABLE.toString()),
                                        ResourceLocation.tryParse(TradeLootTables.UNCOMMON_TRADE_GOODS.toString()),
                                        1, rareSupply, baseXP, rareTradeMultiplier
                                ),
                                // uncommon currency enchantable barter loot
                                new LootTableForEnchantedItemTableFactory(
                                        ResourceLocation.tryParse(TradeLootTables.NINE_NETHER_GOLD_COIN_BAG_TABLE.toString()),
                                        ResourceLocation.tryParse(TradeLootTables.DIAMOND_TIER_EQUIPMENT_SET.toString()),
                                        rareSupply, baseXP, rareSupply
                                )
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // rare currency barter loot
                                new LootTableForTagTableFactory(
                                        ResourceLocation.tryParse(TradeLootTables.RARE_BARTER_CURRENCY.toString()),
                                        ResourceLocation.tryParse(TradeLootTables.RARE_TRADE_GOODS.toString()),
                                        1, rareSupply, baseXP, rareSupply
                                ),
                                // rare currency enchantable barter loot
                                new LootTableForEnchantedItemTableFactory(
                                        ResourceLocation.tryParse(TradeLootTables.RARE_BARTER_CURRENCY.toString()),
                                        ResourceLocation.tryParse(TradeLootTables.RARE_TRADE_GOODS.toString()),
                                        rareSupply, baseXP, rareSupply
                                ),
                                // rare soul speed boots trade
                                new LootTableForSpecifiedEnchantmentFactory(
                                        ResourceLocation.tryParse(TradeLootTables.IRON_TIER_BOOTS_TABLE.toString()),
                                        ResourceLocation.tryParse(TradeLootTables.RARE_BARTER_CURRENCY.toString()),
                                        rareSupply, baseXP, rareSupply,
                                        1,"minecraft:soul_speed"
                                )
                        }
                )
        );
    }
}