package com.github.warrentode.todecoins.entity.piglinmerchant;

import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table_types.LootTableForLootTable;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class PiglinMerchantTrades {
    // for default trades
    static int rarityLevel1 = 1;
    static int rarityLevel2 = 2;
    static int commonSupply = 12;
    static int rareSupply = 3;
    static int baseXP = 5;
    static float priceMultiplier = 0;
    static int CONFIG_BASE_XP = CommonConfig.getBaseXP();
    static int CONFIG_COMMON_MAX_TRADES = CommonConfig.getRareMaxUses();
    static int CONFIG_RARE_MAX_TRADES = CommonConfig.getRareMaxUses();

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
                                new LootTableForLootTable(
                                        TradeLootTables.CHEAP_BARTER_CURRENCY,
                                        TradeLootTables.CHEAP_TRADE_GOODS,
                                        commonSupply, baseXP, priceMultiplier
                                ),
                                // common currency barter loot
                                new LootTableForLootTable(
                                        TradeLootTables.COMMON_BARTER_CURRENCY,
                                        TradeLootTables.COMMON_TRADE_GOODS,
                                        commonSupply, baseXP, priceMultiplier
                                ),
                                // common currency enchantable barter loot
                                new LootTableForLootTable(
                                        TradeLootTables.COMMON_BARTER_CURRENCY,
                                        TradeLootTables.COMMON_ENCHANTABLE_GOODS,
                                        commonSupply, baseXP, priceMultiplier
                                ),
                                // uncommon currency barter loot
                                new LootTableForLootTable(
                                        TradeLootTables.UNCOMMON_BARTER_CURRENCY,
                                        TradeLootTables.UNCOMMON_TRADE_GOODS,
                                        commonSupply, baseXP,
                                        priceMultiplier
                                ),
                                // uncommon currency enchantable barter loot
                                new LootTableForLootTable(
                                        TradeLootTables.UNCOMMON_BARTER_CURRENCY,
                                        TradeLootTables.UNCOMMON_ENCHANTABLE_GOODS,
                                        commonSupply, baseXP, priceMultiplier
                                )
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // rare currency barter loot
                                new LootTableForLootTable(
                                        TradeLootTables.RARE_BARTER_CURRENCY,
                                        TradeLootTables.RARE_TRADE_GOODS,
                                        rareSupply, baseXP, priceMultiplier
                                ),
                                // rare currency enchantable barter loot
                                new LootTableForLootTable(
                                        TradeLootTables.RARE_BARTER_CURRENCY,
                                        TradeLootTables.RARE_ENCHANTABLE_GOODS,
                                        rareSupply, baseXP, priceMultiplier
                                )
                        }
                )
        );
    }
}