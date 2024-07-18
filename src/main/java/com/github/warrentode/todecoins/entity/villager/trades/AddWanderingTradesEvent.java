package com.github.warrentode.todecoins.entity.villager.trades;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AddWanderingTradesEvent {
    static int novice = 1;
    static int apprentice = 2;

    @SubscribeEvent
    public static void addCustomTrades(@NotNull WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> commonTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();
    }
}