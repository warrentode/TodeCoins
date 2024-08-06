package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.config.CommonConfig;
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

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull WandererTradesEvent event) {
            List<VillagerTrades.ItemListing> commonWandererTrades = event.getGenericTrades();
            List<VillagerTrades.ItemListing> rareWandererTrades = event.getRareTrades();

            if (CommonConfig.getCustomTrades()) {
                commonWandererTrades.clear();
                rareWandererTrades.clear();

                // COMMON TRADES
                commonWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest1()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer1()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest2()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer2()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonWandererTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest3()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer3()),
                        CommonConfig.getWanderingOffer3Count(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonWandererTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest4()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer4()),
                        CommonConfig.getWanderingOffer4Count(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest5()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer5()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonWandererTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest6()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer6()),
                        CommonConfig.getWanderingOffer6Count(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonWandererTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest7()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer7()),
                        CommonConfig.getWanderingOffer7Count(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest8()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer8()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest9()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer9()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonWandererTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRequest10()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingOffer10()),
                        CommonConfig.getWanderingOffer10Count(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));

                // RARE TRADES
                rareWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRareRequest1()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingRareOffer1()),
                        RARE_MAX_TRADES, BASE_XP, RARE_TRADE_MULTIPLIER
                ));
                rareWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRareRequest2()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingRareOffer2()),
                        RARE_MAX_TRADES, BASE_XP, RARE_TRADE_MULTIPLIER
                ));
                rareWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRareRequest3()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingRareOffer3()),
                        RARE_MAX_TRADES, BASE_XP, RARE_TRADE_MULTIPLIER
                ));
                rareWandererTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getWanderingRareRequest4()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingRareOffer4()),
                        RARE_MAX_TRADES, BASE_XP, RARE_TRADE_MULTIPLIER
                ));
            }
        }
    }
}