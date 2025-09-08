package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.attribute.ModAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributeHandler {
    @SubscribeEvent
    public static void onEntityAttributeModificationEvent(@NotNull final EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, ModAttributes.CHARISMA.get());
    }
}