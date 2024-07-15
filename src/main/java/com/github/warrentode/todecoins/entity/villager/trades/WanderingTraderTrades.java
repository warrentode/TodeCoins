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
    static int common = 1;
    static int rare = 2;
    static int BASE_XP = CommonConfig.getBaseXP();
    static int COMMON_MAX_TRADES = CommonConfig.getCommonMaxTrades();
    static int RARE_MAX_TRADES = CommonConfig.getRareMaxTrades();
    static float COMMON_TRADE_MULTIPLIER = CommonConfig.getCommonTradeMultiplier();
    static float RARE_TRADE_MULTIPLIER = CommonConfig.getRareTradeMultiplier();

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull WandererTradesEvent event) {
            List<VillagerTrades.ItemListing> commonTrades = event.getGenericTrades();
            List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

            if (CommonConfig.getCustomTrades()) {
                commonTrades.clear();
                rareTrades.clear();

                // COMMON TRADES
                commonTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getFlowerSellTable()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getSaplingSellTable()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getSeedTagTable()),
                        CommonConfig.getSeedCount(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getSlimeballTagTable()),
                        CommonConfig.getSlimeballCount(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getSandTagTable()),
                        CommonConfig.getSandCount(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                        CommonConfig.getDyeSellCount(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getSeaShellTable()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingTraderCommonOffersTable()),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));
                commonTrades.add(new LootTableForTagTable(
                        ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getCoralBlockTagTable()),
                        CommonConfig.getCoralBlockCount(),
                        COMMON_MAX_TRADES, BASE_XP, COMMON_TRADE_MULTIPLIER
                ));

                // RARE TRADES
                rareTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getFishBucketTable()),
                        RARE_MAX_TRADES, BASE_XP, RARE_MAX_TRADES
                ));
                rareTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getSixEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getIceTable()),
                        RARE_MAX_TRADES, BASE_XP, RARE_MAX_TRADES
                ));
                rareTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getSpecialDirtTable()),
                        RARE_MAX_TRADES, BASE_XP, RARE_MAX_TRADES
                ));
                rareTrades.add(new LootTableForLootTable(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        ResourceLocation.tryParse(CommonConfig.getWanderingTraderRareOffersTable()),
                        RARE_MAX_TRADES, BASE_XP, RARE_MAX_TRADES
                ));
            }
        }
    }
}