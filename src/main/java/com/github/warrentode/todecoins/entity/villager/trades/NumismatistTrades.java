package com.github.warrentode.todecoins.event.trades;

import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table.*;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;

public class NumismatistTrades {
    static int rarityLevel1 = 1;
    static int rarityLevel2 = 2;
    static int MAX_USES = CommonConfig.getRareMaxTrades();
    static float PRICE_MULTIPLIER = 0F;

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
                                new LootTableForLootTable(
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        MAX_USES, 5 * rarityLevel1, PRICE_MULTIPLIER
                                ),
                                // an off season coin for a season coin trade
                                new LootTableForLootTable(
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        MAX_USES, 5 * rarityLevel1, PRICE_MULTIPLIER
                                ),
                                // offer a map for a season coin
                                new MapForLootTables(
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ResourceLocation.tryParse(CommonConfig.getCompassTable()),
                                        CommonConfig.getStructureTag(CommonConfig.getMerchantMapStructureTag()),
                                        CommonConfig.getMerchantMapName(),
                                        MapDecoration.Type.valueOf(CommonConfig.getMerchantMapMarker()),
                                        MAX_USES, 5 * rarityLevel1, PRICE_MULTIPLIER
                                ),
                                // offer a container for 2 coins
                                new LootTableForTwoLootTable(
                                        ResourceLocation.tryParse(CommonConfig.getNumismatistContainerTable()),
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        MAX_USES, 5 * rarityLevel1, PRICE_MULTIPLIER
                                ),
                                // offer a coin pack in a shulker box for 2 coins
                                new LootBoxForTwoLootTable(
                                        Items.SHULKER_BOX.getDefaultInstance(),
                                        "tooltips.collectible_coin_pack",
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        MAX_USES, 5 * rarityLevel1, PRICE_MULTIPLIER
                                )
                        },
                        // 1 rare offer for 2 coins
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // offer a rare item for 2 coins
                                new LootTableForTwoLootTable(
                                        ResourceLocation.tryParse(CommonConfig.getNumismatistRareOfferTable()),
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        MAX_USES, 5 * rarityLevel2, PRICE_MULTIPLIER
                                ),
                                // enchanted book for 2 coins
                                new TwoLootTableForEnchanted(
                                        Items.BOOK.getDefaultInstance(),
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK,
                                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                                        MAX_USES, 5 * rarityLevel2, PRICE_MULTIPLIER
                                )
                        }));
    }
}