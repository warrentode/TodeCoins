package com.github.warrentode.todecoins.entity.piglinmerchant;

import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.config.trades.todecoins.PiglinMerchantTradesConfig;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table_types.LootTableForEnchantedTable;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table_types.LootTableForTagTable;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class PiglinMerchantTrades {
    // for default trades
    static int rarityLevel1 = 1;
    static int rarityLevel2 = 2;
    static int commonSupply = CommonConfig.getCommonMaxUses();
    static int rareSupply = CommonConfig.getRareMaxUses();
    static int baseXP = CommonConfig.getBaseXP();
    static float commonTradeMultiplier = (float) CommonConfig.getCommonTradeMultiplier();
    static float rareTradeMultiplier = (float) CommonConfig.getRareTradeMultiplier();

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
                                new LootTableForTagTable(
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Request1()),
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Offer1()),
                                        PiglinMerchantTradesConfig.getPiglinMerchant1Offer1Count(),
                                        commonSupply, baseXP, commonTradeMultiplier
                                ),
                                // common currency barter loot
                                new LootTableForTagTable(
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Request2()),
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Offer2()),
                                        PiglinMerchantTradesConfig.getPiglinMerchant1Offer2Count(),
                                        commonSupply, baseXP, commonTradeMultiplier
                                ),
                                // common currency enchantable barter loot
                                new LootTableForEnchantedTable(
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Offer3()),
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Request3()),
                                        rareSupply, baseXP, rareTradeMultiplier
                                ),
                                // uncommon currency barter loot
                                new LootTableForTagTable(
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Request4()),
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Offer4()),
                                        PiglinMerchantTradesConfig.getPiglinMerchant1Offer4Count(),
                                        rareSupply, baseXP, rareTradeMultiplier
                                ),
                                // uncommon currency enchantable barter loot
                                new LootTableForEnchantedTable(
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Offer5()),
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant1Request5()),
                                        rareSupply, baseXP, rareSupply
                                )
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // rare currency barter loot
                                new LootTableForTagTable(
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant2Request1()),
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant2Offer1()),
                                        PiglinMerchantTradesConfig.getPiglinMerchant2Offer1Count(),
                                        rareSupply, baseXP, rareSupply
                                ),
                                // rare currency enchantable barter loot
                                new LootTableForEnchantedTable(
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant2Offer2()),
                                        ResourceLocation.tryParse(PiglinMerchantTradesConfig.getPiglinMerchant2Request2()),
                                        rareSupply, baseXP, rareSupply
                                )
                        }
                )
        );
    }
}