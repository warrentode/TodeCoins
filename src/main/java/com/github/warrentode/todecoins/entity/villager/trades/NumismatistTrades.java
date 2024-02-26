package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.entity.villager.trades.tradetypes.item_set.MapForItemSetTrade;
import com.github.warrentode.todecoins.entity.villager.trades.tradetypes.item_set.OneSetForTwoSetsTrade;
import com.github.warrentode.todecoins.entity.villager.trades.tradetypes.loot_table.*;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;

public class NumismatistTrades {
    static int rarityLevel1 = 1;
    static int rarityLevel2 = 2;

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> pMap) {
        return new Int2ObjectOpenHashMap<>(pMap);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> NUMISMATIST_TRADES = makeTrades();

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        // 5 normal, season based trades
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // a season coin for an off season coin trade
                                new OneLootTableItemForOneLootTableItemTrade(
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        OneLootTableItemForOneLootTableItemTrade.DEFAULT_SUPPLY,
                                        OneLootTableItemForOneLootTableItemTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // an off season coin for a season coin trade
                                new OneLootTableItemForOneLootTableItemTrade(
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        OneLootTableItemForOneLootTableItemTrade.DEFAULT_SUPPLY,
                                        OneLootTableItemForOneLootTableItemTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // offer a map for a season coin
                                new MapForOneLootTableItemTrade(
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        Items.COMPASS.getDefaultInstance(), 1,
                                        ForgeTags.StructureTags.ON_VILLAGE_EXPLORER_MAPS,
                                        "Merchant Map", MapDecoration.Type.MANSION,
                                        MapForItemSetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        MapForItemSetTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // offer a container for 2 coins
                                new OneLootTableItemForTwoLootTableItemsTrade(
                                        ModBuiltInLootTables.NUMISMATIST_CONTAINER_OFFERS,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        OneSetForTwoSetsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        OneSetForTwoSetsTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // offer a coin pack in a shulker box for 2 coins
                                new LootBoxForTwoLootTableItemsTrade(
                                        Items.SHULKER_BOX.getDefaultInstance(),
                                        "tooltips.collectible_coin_pack",
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        LootBoxForTwoLootTableItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        LootBoxForTwoLootTableItemsTrade.XP_LEVEL_1_SELL, 0
                                )
                        },
                        // 1 rare offer for 2 coins
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // offer a rare item for 2 coins
                                new OneLootTableItemForTwoLootTableItemsTrade(
                                        ModBuiltInLootTables.NUMISMATIST_RARE_OFFERS,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        OneSetForTwoSetsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        OneSetForTwoSetsTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // enchanted book for 2 coins
                                new EnchantedItemForTwoLootTableItemsTrade(
                                        Items.BOOK.getDefaultInstance(), 1,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        OneSetForTwoSetsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        OneSetForTwoSetsTrade.XP_LEVEL_1_SELL, 0
                                )
                        }));
    }
}