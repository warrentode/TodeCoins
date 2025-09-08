package com.github.warrentode.todecoins.entity.trades;

import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.*;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.tags.TCStructureTags;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class NumismatistTrades {
    // for default trades
    static final int rarityLevel1 = 1;
    static final int rarityLevel2 = 2;
    static final int maxUses = TradeOfferConstants.RARE_MAX_TRADES;
    static final int baseXP = TradeOfferConstants.BASE_XP;
    static final float priceMultiplier = 0;

    @Contract("_ -> new")
    private static @NotNull Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> hashMap) {
        return new Int2ObjectOpenHashMap<>(hashMap);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> NUMISMATIST_TRADES = makeTrades();

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> makeTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        // 5 normal, season based trades
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // a season coin for an off season coin trade
                                new LootTableForLootTable(
                                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        TradeLootTables.MYSTERY_COIN_PACK,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // an off season coin for a season coin trade
                                new LootTableForLootTable(
                                        TradeLootTables.MYSTERY_COIN_PACK,
                                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // offer a map for a season coin
                                new TwoLootTableForMap(
                                        TradeLootTables.MYSTERY_COIN_PACK,
                                        TradeLootTables.COMPASS_TABLE,
                                        TCStructureTags.SETTLEMENT,
                                        "filled_map.settlement",
                                        MapDecoration.Type.TARGET_POINT,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // offer a container for 2 coins
                                new TwoLootTableForLootTable(
                                        TradeLootTables.MYSTERY_COIN_PACK,
                                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        TradeLootTables.NUMISMATIST_CONTAINER_OFFERS,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // offer a coin pack in a shulker box for 2 coins
                                new TwoLootTableForLootBox(
                                        Items.SHULKER_BOX.getDefaultInstance(),
                                        "tooltip.todecoins.collectible_coin_pack",
                                        TradeLootTables.MYSTERY_COIN_PACK,
                                        TradeLootTables.MYSTERY_COIN_PACK,
                                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        maxUses, baseXP, priceMultiplier
                                )
                        },
                        // 1 rare offer for 2 coins
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // offer a rare item for 2 coins
                                new TwoLootTableForLootTable(
                                        TradeLootTables.NUMISMATIST_RARE_OFFERS,
                                        TradeLootTables.MYSTERY_COIN_PACK,
                                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // enchanted book for 2 coins
                                new TwoLootTableForEnchantedItem(
                                        Items.BOOK.getDefaultInstance(),
                                        TradeLootTables.MYSTERY_COIN_PACK,
                                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        maxUses, baseXP, priceMultiplier
                                )
                        }));
    }
}