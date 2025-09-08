package com.github.warrentode.todecoins.entity.trades;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.ItemForLootTable;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.LootTableForLootTable;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.LootTableForItem;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.entity.trades.TradeOfferConstants.*;

public class LeprechaunTrades {
    @Contract("_ -> new")
    private static @NotNull Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> hashMap) {
        return new Int2ObjectOpenHashMap<>(hashMap);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> LEPRECHAUN_TRADES = makeTrades();

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> makeTrades() {
        return LEPRECHAUN_TRADES = toIntMap(ImmutableMap.of(
                novice, new VillagerTrades.ItemListing[]{
                        new LootTableForItem(
                                TradeLootTables.THREE_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                Items.EMERALD.getDefaultInstance(), 3,
                                RARE_MAX_TRADES, BASE_XP * novice, RARE_TRADE_MULTIPLIER
                        ),
                        new ItemForLootTable(
                                Items.EMERALD.getDefaultInstance(), 3,
                                TradeLootTables.THREE_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                RARE_MAX_TRADES, BASE_XP * novice, RARE_TRADE_MULTIPLIER
                        )
                },
                apprentice, new VillagerTrades.ItemListing[]{
                        new ItemForLootTable(
                                TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                                TradeLootTables.THREE_EMERALD_VALUE_GEMS,
                                RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                        ),
                        new ItemForLootTable(
                                TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                                TradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS,
                                RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                        ),
                        new ItemForLootTable(
                                Items.EMERALD.getDefaultInstance(), 6,
                                TradeLootTables.SIX_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                        ),
                        new ItemForLootTable(
                                Items.EMERALD.getDefaultInstance(), 6,
                                TradeLootTables.SIX_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                        ),
                        new LootTableForLootTable(
                                TradeLootTables.SIX_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                TradeLootTables.SIX_EMERALD_VALUE_GEMS,
                                RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                        ),
                        new ItemForLootTable(
                                TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                                TradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS,
                                RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                        ),
                        new ItemForLootTable(
                                Items.EMERALD.getDefaultInstance(), 6,
                                TradeLootTables.SIX_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                        )
                },
                journeyman, new VillagerTrades.ItemListing[]{
                        new ItemForLootTable(
                                TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                                TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_ITEMS,
                                RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                        ),
                        new ItemForLootTable(
                                Items.EMERALD.getDefaultInstance(), 32,
                                TradeLootTables.THIRTY_TWO_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                        ),
                        new LootTableForLootTable(
                                TradeLootTables.THIRTY_TWO_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                TradeLootTables.THIRTY_TWO_EMERALD_VALUE_GEMS,
                                RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                        ),
                        new ItemForLootTable(
                                Items.EMERALD.getDefaultInstance(), 64,
                                TradeLootTables.SIXTY_FOUR_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                        ),
                        new ItemForLootTable(
                                TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                                TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_ITEMS,
                                RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                        ),
                        new LootTableForLootTable(
                                TradeLootTables.SIXTY_FOUR_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                                TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_GEMS,
                                RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                        )
                },
                expert, new VillagerTrades.ItemListing[]{
                        new LootTableForLootTable(
                                TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_LEPRECHAUN_VALUE_CURRENCY,
                                TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                                RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                        ),
                        new LootTableForLootTable(
                                TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_LEPRECHAUN_VALUE_CURRENCY,
                                TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                                RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                        )
                },
                master, new VillagerTrades.ItemListing[]{
                        new LootTableForLootTable(
                                TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_GEMS,
                                TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_LEPRECHAUN_VALUE_CURRENCY,
                                RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                        ),
                        new LootTableForItem(
                                TradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS,
                                TCItems.LUCKY_COIN.get().getDefaultInstance(), 3,
                                RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                        ),
                        new LootTableForItem(
                                TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS,
                                TCItems.LUCKY_COIN.get().getDefaultInstance(), 27,
                                RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                        ),
                        new LootTableForLootTable(
                                TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                                TradeLootTables.TAGGED_TRIMS_TABLE,
                                RARE_MAX_TRADES,
                                BASE_XP * master,
                                RARE_TRADE_MULTIPLIER
                        )
                }
        ));
    }
}