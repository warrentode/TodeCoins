package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.config.CommonConfig;
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
            }
        }
    }
}