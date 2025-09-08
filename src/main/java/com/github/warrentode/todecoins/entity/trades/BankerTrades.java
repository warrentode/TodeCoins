package com.github.warrentode.todecoins.entity.trades;

import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.LootTableForLootTable;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.entity.trades.TradeOfferConstants.*;

public class BankerTrades {
    @Contract("_ -> new")
    private static @NotNull Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> hashMap) {
        return new Int2ObjectOpenHashMap<>(hashMap);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> BANKER_TRADES = makeTrades();

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> makeTrades() {
        return BANKER_TRADES = toIntMap(
                ImmutableMap.of(
                        novice, new VillagerTrades.ItemListing[]{
                                new LootTableForLootTable(
                                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                                ),
                                new LootTableForLootTable(
                                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                                )
                        },
                        apprentice, new VillagerTrades.ItemListing[]{
                                new LootTableForLootTable(
                                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                                ),
                                new LootTableForLootTable(
                                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                                )
                        },
                        journeyman, new VillagerTrades.ItemListing[]{
                                new LootTableForLootTable(
                                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                                ),
                                new LootTableForLootTable(
                                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                                )
                        },
                        expert, new VillagerTrades.ItemListing[]{
                                new LootTableForLootTable(
                                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                                ),
                                new LootTableForLootTable(
                                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                                )
                        },
                        master, new VillagerTrades.ItemListing[]{
                                new LootTableForLootTable(
                                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                                ),
                                new LootTableForLootTable(
                                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY,
                                        COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                                )
                        }
                ));
    }
}