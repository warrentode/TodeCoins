package com.github.warrentode.todecoins.entity.trades;

import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom.*;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class NumismatistTrades {
    // for default trades
    static int rarityLevel1 = 1;
    static int rarityLevel2 = 2;
    static int maxUses = TradeOfferConstants.RARE_MAX_TRADES;
    static int baseXP = TradeOfferConstants.BASE_XP;
    static float priceMultiplier = 0;

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
                                new LootTableForLootTableFactory(
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // an off season coin for a season coin trade
                                new LootTableForLootTableFactory(
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // offer a map for a season coin
                                new TwoLootTableForMapFactory(
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                                        ResourceLocation.tryParse(TradeLootTables.COMPASS_TABLE.toString()),
                                        TodeCoinsTags.StructureTags.SETTLEMENT.location().toString(),
                                        "Settlement Map",
                                        MapDecoration.Type.TARGET_POINT.toString(),
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // offer a container for 2 coins
                                new TwoLootTableForLootTableFactory(
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                                        ResourceLocation.tryParse(TradeLootTables.NUMISMATIST_CONTAINER_OFFERS.toString()),
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // offer a coin pack in a shulker box for 2 coins
                                new TwoLootTableForLootBoxFactory(
                                        Items.SHULKER_BOX.getDefaultInstance(),
                                        "tooltips.collectible_coin_pack",
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                                        maxUses, baseXP, priceMultiplier
                                )
                        },
                        // 1 rare offer for 2 coins
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // offer a rare item for 2 coins
                                new TwoLootTableForLootTableFactory(
                                        ResourceLocation.tryParse(TradeLootTables.NUMISMATIST_RARE_OFFERS.toString()),
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                                        maxUses, baseXP, priceMultiplier
                                ),
                                // enchanted book for 2 coins
                                new TwoLootTableForEnchantedItemFactory(
                                        Items.BOOK.getDefaultInstance(),
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                                        maxUses, baseXP, priceMultiplier
                                )
                        }));
    }
}