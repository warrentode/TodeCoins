package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.config.trades.minecraft.WanderingTraderTradesConfig;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table.LootTableForLootTable;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table.LootTableForTagTable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class WanderingTraderTrades {
    static int BASE_XP = CommonConfig.getBaseXP();
    static int COMMON_MAX_TRADES = CommonConfig.getCommonMaxUses();
    static int RARE_MAX_TRADES = CommonConfig.getRareMaxUses();
    static float COMMON_TRADE_MULTIPLIER = (float) CommonConfig.getCommonTradeMultiplier();
    static float RARE_TRADE_MULTIPLIER = (float) CommonConfig.getRareTradeMultiplier();
    static boolean REPLACE_TRADES = CommonConfig.getReplaceTrades();

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull WandererTradesEvent event) {
            List<VillagerTrades.ItemListing> commonWandererTrades = event.getGenericTrades();
            List<VillagerTrades.ItemListing> rareWandererTrades = event.getRareTrades();

            if (CommonConfig.getCustomTrades()) {
                if (REPLACE_TRADES) {
                    commonWandererTrades.clear();
                    rareWandererTrades.clear();
                }

                for (int i = 0; i < CommonConfig.getMaxWandererTrades(); ++i) {
                    // COMMON TRADES
                    commonWandererTrades.add(new LootTableForLootTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest1()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer1()),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                    commonWandererTrades.add(new LootTableForLootTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest2()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer2()),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                    commonWandererTrades.add(new LootTableForTagTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest3()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer3()),
                            WanderingTraderTradesConfig.getWanderingOffer3Count(),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                    commonWandererTrades.add(new LootTableForTagTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest4()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer4()),
                            WanderingTraderTradesConfig.getWanderingOffer4Count(),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                    commonWandererTrades.add(new LootTableForLootTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest5()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer5()),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                    commonWandererTrades.add(new LootTableForTagTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest6()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer6()),
                            WanderingTraderTradesConfig.getWanderingOffer6Count(),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                    commonWandererTrades.add(new LootTableForTagTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest7()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer7()),
                            WanderingTraderTradesConfig.getWanderingOffer7Count(),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                    commonWandererTrades.add(new LootTableForLootTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest8()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer8()),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                    commonWandererTrades.add(new LootTableForLootTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest9()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer9()),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                    commonWandererTrades.add(new LootTableForTagTable(
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRequest10()),
                            ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingOffer10()),
                            WanderingTraderTradesConfig.getWanderingOffer10Count(),
                            COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                    ));
                }

                // RARE TRADES
                rareWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRareRequest1()),
                        ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRareOffer1()),
                        RARE_MAX_TRADES, BASE_XP, RARE_TRADE_MULTIPLIER
                ));
                rareWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRareRequest2()),
                        ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRareOffer2()),
                        RARE_MAX_TRADES, BASE_XP, RARE_TRADE_MULTIPLIER
                ));
                rareWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRareRequest3()),
                        ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRareOffer3()),
                        RARE_MAX_TRADES, BASE_XP, RARE_TRADE_MULTIPLIER
                ));
                rareWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRareRequest4()),
                        ResourceLocation.tryParse(WanderingTraderTradesConfig.getWanderingRareOffer4()),
                        RARE_MAX_TRADES, BASE_XP, RARE_TRADE_MULTIPLIER
                ));
            }
        }
    }
}