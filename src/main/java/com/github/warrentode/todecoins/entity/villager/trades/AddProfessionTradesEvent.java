package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.config.CommonConfig;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class AddProfessionTradesEvent {
    static int novice = 1;
    static int apprentice = 2;
    static int journeyman = 3;
    static int expert = 4;
    static int master = 5;

    //TODO: add morevillagers trades
    //TODO: add annabethsextravillagers trades
    //TODO: add sewingkit trades
    //TODO: add beautify trades
    //TODO: add chefsdelight trades
    //TODO: add domesticationinnovation trades
    //TODO: add dynamicvillage (create) trades
    //TODO: add fastfooddelight trades
    //TODO: add goblintraders trades json files?
    //TODO: add sawmill trades
    //TODO: add todepiglin trades
    //TODO: merge todepiglin with todecoins
    //TODO: add unusualend wandering trader trades?
    //TODO: add villagerenchanter trades
    //TODO: add villagersplus trades
    //TODO: add wares trades?

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();


            if (CommonConfig.getCustomTrades()) {
                trades.get(novice).clear();
                trades.get(apprentice).clear();
                trades.get(journeyman).clear();
                trades.get(expert).clear();
                trades.get(master).clear();

            }
        }
    }
}