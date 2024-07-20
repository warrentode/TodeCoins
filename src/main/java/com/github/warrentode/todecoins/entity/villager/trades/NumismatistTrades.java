package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.config.CommonConfig;
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
    static int priceMultiplier = 0;

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
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistTradeRequest1()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistTradeOffer1()),
                                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXp(), (float) CommonConfig.getRarePriceMultiplier()
                                    ),
                                    // an off season coin for a season coin trade
                                    new LootTableForLootTable(
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistTradeRequest2()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistTradeOffer2()),
                                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXp(), (float) CommonConfig.getRarePriceMultiplier()
                                    ),
                                    // offer a map for a season coin
                                    new MapForLootTablesTrade(
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistTradeRequest3A()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistTradeRequest3B()),
                                            CommonConfig.getStructureTag(CommonConfig.getNumismatistTrade3StructureTag()),
                                            CommonConfig.getNumismatistTrade3MapName(),
                                            MapDecoration.Type.valueOf(CommonConfig.getNumismatistTrade3MapMarker()),
                                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXp(), (float) CommonConfig.getRarePriceMultiplier()
                                    ),
                                    // offer a container for 2 coins
                                    new LootTableForTwoLootTable(
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistOffer4()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistRequest4A()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistRequest4B()),
                                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXp(), (float) CommonConfig.getRarePriceMultiplier()
                                    ),
                                    // offer a coin pack in a shulker box for 2 coins
                                    new LootBoxForTwoLootTable(
                                            Items.SHULKER_BOX.getDefaultInstance(),
                                            CommonConfig.getNumismatistLootBoxDisplayName(),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistLootBoxLootTable()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistRequest5A()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistRequest5B()),
                                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXp(), (float) CommonConfig.getRarePriceMultiplier()
                                    )
                            },
                            // 1 rare offer for 2 coins
                            rarityLevel2, new VillagerTrades.ItemListing[]{
                                    // offer a rare item for 2 coins
                                    new LootTableForTwoLootTable(
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistRareOffer()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistRareRequest1A()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistRareRequest1B()),
                                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXp(), (float) CommonConfig.getRarePriceMultiplier()
                                    ),
                                    // enchanted book for 2 coins
                                    new TwoLootTableForEnchanted(
                                            Items.BOOK.getDefaultInstance(),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistRareRequest2A()),
                                            ResourceLocation.tryParse(CommonConfig.getNumismatistRareRequest2B()),
                                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXp(), (float) CommonConfig.getRarePriceMultiplier()
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
                                    new MapForLootTablesTrade(
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
}