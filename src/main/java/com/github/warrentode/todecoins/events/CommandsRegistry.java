package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.commands.TradeCommands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommandsRegistry {
    /**
     * Central registry for all mod commands.
     * Currently handles just the JSON trade commands; additional commands to be added here.
     */
    @SubscribeEvent
    public static void registerCommands(@NotNull RegisterCommandsEvent event) {
        TradeCommands.register(event.getDispatcher());
    }
}