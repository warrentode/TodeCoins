package com.github.warrentode.todecoins.events;


import com.github.warrentode.todecoins.datagen.translations.SpecialHandlingTranslations;
import com.github.warrentode.todecoins.util.seasonal.CalendarUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerLoginHandler {

    @SubscribeEvent
    public static void onPlayerLogin(@NotNull PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        Level level = player.level;
        if (!(level instanceof ServerLevel serverLevel)) return;

        // Only notify if there are birthday/custom events today
        List<String> todayEvents = CalendarUtil.getTodayEventNames(serverLevel);
        if (todayEvents.isEmpty()) return;

        // Send formatted message
        for (String eventName : todayEvents) {
            player.sendSystemMessage(Component.empty().append(Component.translatable(SpecialHandlingTranslations.customEventPrefix).withStyle(ChatFormatting.GOLD))
                            .append(Component.literal(eventName).withStyle(ChatFormatting.AQUA, ChatFormatting.BOLD))
                            .append(Component.translatable(SpecialHandlingTranslations.customEventSuffix).withStyle(ChatFormatting.GOLD))
            );
        }
    }
}