package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.config.trades.todecoins.NumismatistTradesConfig;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table.*;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
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
    static int maxUses = 3;
    static int baseXP = 5;
    static float priceMultiplier = 0;
    static int CONFIG_BASE_XP = CommonConfig.getBaseXP();
    static int CONFIG_RARE_MAX_TRADES = CommonConfig.getRareMaxUses();

    @Contract("_ -> new")
    private static @NotNull Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> hashMap) {
        return new Int2ObjectOpenHashMap<>(hashMap);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> NUMISMATIST_TRADES = makeTrades();

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> makeTrades() {
        // config trades
        if (CommonConfig.getCustomTrades()) {
            return NUMISMATIST_TRADES = toIntMap(
                    ImmutableMap.of(
                            // 5 normal, season based trades
                            rarityLevel1, new VillagerTrades.ItemListing[]{
                                    // a season coin for an off season coin trade
                                    new LootTableForLootTable(
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistTradeRequest1()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistTradeOffer1()),
                                            CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP, priceMultiplier
                                    ),
                                    // an off season coin for a season coin trade
                                    new LootTableForLootTable(
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistTradeRequest2()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistTradeOffer2()),
                                            CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP, priceMultiplier
                                    ),
                                    // offer a map for a season coin
                                    new TwoLootTableForMap(
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistTradeRequest3A()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistTradeRequest3B()),
                                            CommonConfig.getStructureTag(NumismatistTradesConfig.getNumismatistTrade3StructureTag()),
                                            NumismatistTradesConfig.getNumismatistTrade3MapName(),
                                            MapDecoration.Type.valueOf(NumismatistTradesConfig.getNumismatistTrade3MapMarker()),
                                            CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP, priceMultiplier
                                    ),
                                    // offer a container for 2 coins
                                    new LootTableForTwoLootTable(
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistOffer4()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistRequest4A()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistRequest4B()),
                                            CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP, priceMultiplier
                                    ),
                                    // offer a coin pack in a shulker box for 2 coins
                                    new TwoLootTableForLootBox(
                                            Items.SHULKER_BOX.getDefaultInstance(),
                                            NumismatistTradesConfig.getNumismatistLootBoxDisplayName(),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistLootBoxLootTable()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistRequest5A()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistRequest5B()),
                                            CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP, priceMultiplier
                                    )
                            },
                            // 1 rare offer for 2 coins
                            rarityLevel2, new VillagerTrades.ItemListing[]{
                                    // offer a rare item for 2 coins
                                    new LootTableForTwoLootTable(
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistRareOffer()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistRareRequest1A()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistRareRequest1B()),
                                            CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP, priceMultiplier
                                    ),
                                    // enchanted book for 2 coins
                                    new TwoLootTableForEnchanted(
                                            Items.BOOK.getDefaultInstance(),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistRareRequest2A()),
                                            ResourceLocation.tryParse(NumismatistTradesConfig.getNumismatistRareRequest2B()),
                                            CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP, priceMultiplier
                                    )
                            }));
        }
        // default trades
        else {
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
                                    new TwoLootTableForMap(
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
                                    new TwoLootTableForLootBox(
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
}