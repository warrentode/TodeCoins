package com.github.warrentode.todecoins.entity.trades;

import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.LootTableForEnchantedItemTable;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.LootTableForLootTable;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.LootTableForSpecifiedEnchantmentLootTable;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.LootTableForTagTable;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class PiglinMerchantTrades {
    // for default trades
    static final int rarityLevel1 = 1;
    static final int rarityLevel2 = 2;
    static final int commonSupply = TradeOfferConstants.COMMON_MAX_TRADES;
    static final int rareSupply = TradeOfferConstants.RARE_MAX_TRADES;
    static final int baseXP = TradeOfferConstants.BASE_XP;
    static final float commonTradeMultiplier = TradeOfferConstants.COMMON_TRADE_MULTIPLIER;
    static final float rareTradeMultiplier = TradeOfferConstants.RARE_TRADE_MULTIPLIER;

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
                                new LootTableForTagTable(
                                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                                        TradeLootTables.CHEAP_TRADE_GOODS,
                                        6, commonSupply, baseXP, commonTradeMultiplier
                                ),
                                // common currency barter loot
                                new LootTableForTagTable(
                                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                                        TradeLootTables.COMMON_TRADE_GOODS,
                                        1,
                                        commonSupply, baseXP, commonTradeMultiplier
                                ),
                                // common currency enchantable barter loot
                                new LootTableForEnchantedItemTable(
                                        TradeLootTables.IRON_TIER_EQUIPMENT_SET,
                                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                        rareSupply, baseXP, rareTradeMultiplier
                                ),
                                // uncommon currency barter loot
                                new LootTableForTagTable(
                                        TradeLootTables.FIVE_EMERALD_NETHER_CURRENCY_VALUE,
                                        TradeLootTables.UNCOMMON_TRADE_GOODS,
                                        1, rareSupply, baseXP, rareTradeMultiplier
                                ),
                                // uncommon currency enchantable barter loot
                                new LootTableForEnchantedItemTable(
                                        TradeLootTables.DIAMOND_TIER_EQUIPMENT_SET,
                                        TradeLootTables.TWENTY_SIX_EMERALD_NETHER_CURRENCY_VALUE,
                                        rareSupply, baseXP, rareSupply
                                )
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // rare currency barter loot
                                new LootTableForTagTable(
                                        TradeLootTables.RARE_BARTER_CURRENCY,
                                        TradeLootTables.RARE_TRADE_GOODS,
                                        1, rareSupply, baseXP, rareSupply
                                ),
                                // rare currency enchantable barter loot
                                new LootTableForEnchantedItemTable(
                                        TradeLootTables.NETHERITE_TIER_EQUIPMENT_SET,
                                        TradeLootTables.RARE_BARTER_CURRENCY,
                                        rareSupply, baseXP, rareSupply
                                ),
                                // rare soul speed boots trade
                                new LootTableForSpecifiedEnchantmentLootTable(
                                        TradeLootTables.IRON_TIER_BOOTS_TABLE,
                                        TradeLootTables.RARE_BARTER_CURRENCY,
                                        rareSupply, baseXP, rareSupply,
                                        1, new EnchantmentInstance[]{new EnchantmentInstance(Enchantments.SOUL_SPEED, 1)}
                                ),
                                // rare netherite gear trade
                                new LootTableForLootTable(
                                        TradeLootTables.FIVE_HUNDRED_SEVENTY_SIX_EMERALD_NETHER_VALUE_CURRENCY,
                                        TradeLootTables.NETHERITE_TIER_EQUIPMENT_SET,
                                        rareSupply, baseXP, rareSupply
                                )
                        }
                )
        );
    }
}