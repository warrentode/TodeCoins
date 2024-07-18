package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table.*;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


public class AddNumismatistTrades {
    static int rarityLevel1 = 1;
    static int rarityLevel2 = 2;
    static int maxUses = 3;
    static int baseXP = 5;
    static int priceMultiplier = 0;

    @Contract("_ -> new")
    private static @NotNull Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> pMap) {
        return new Int2ObjectOpenHashMap<>(pMap);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> NUMISMATIST_TRADES = makeTrades();

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        // 5 normal, season based trades
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // a season coin for an off season coin trade
                                new LootTableForLootTable(
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // an off season coin for a season coin trade
                                new LootTableForLootTable(
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // offer a map for a season coin
                                new MapForLootTables(
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        TradeLootTables.COMPASS_TABLE,
                                        ForgeTags.StructureTags.ON_VILLAGE_EXPLORER_MAPS,
                                        "Merchant Map", MapDecoration.Type.MANSION,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // offer a container for 2 coins
                                new LootTableForTwoLootTable(
                                        TradeLootTables.NUMISMATIST_CONTAINER_OFFERS,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // offer a coin pack in a shulker box for 2 coins
                                new LootBoxForTwoLootTable(
                                        Items.SHULKER_BOX.getDefaultInstance(),
                                        "tooltips.collectible_coin_pack",
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        maxUses, baseXP, priceMultiplier
                                )
                        },
                        // 1 rare offer for 2 coins
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // offer a rare item for 2 coins
                                new LootTableForTwoLootTable(
                                        TradeLootTables.NUMISMATIST_RARE_OFFERS,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // enchanted book for 2 coins
                                new TwoLootTableForEnchanted(
                                        Items.BOOK.getDefaultInstance(),
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        maxUses, baseXP, priceMultiplier
                                )
                        }));
    }
}