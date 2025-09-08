package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.item.TCItems;
import net.mcreator.festivedelight.init.FestiveDelightModItems;
import net.mcreator.festivedelight.init.FestiveDelightModTabs;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabHandler {

    @SubscribeEvent
    public static void onBuildCreativeTabContents(@NotNull BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> currentTab = event.getTabKey();

        // Add items from TCItems that belong in this tab
        TCItems.ITEM_CATEGORIES.forEach((item, category) -> {
            if (category.getTab() == currentTab) {
                var location = ForgeRegistries.ITEMS.getKey(item.get());
                if (location != null && !location.getPath().contains("collectible")) {
                    event.accept(item.get());
                }
            }
        });

        if (ModList.get().isLoaded("festive_delight")) {
            if (currentTab == FestiveDelightModTabs.FESTIVE_DELIGHT.getKey()) {
                event.accept(FestiveDelightModItems.SPRING_ROLLS);
                event.accept(FestiveDelightModItems.LONGEVITY_NOODLE);
                event.accept(FestiveDelightModItems.SUS_BREAD);
            }
        }

        // Special cases for hidden spawn eggs
        if (currentTab == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(Items.WITHER_SPAWN_EGG);
            event.accept(Items.ENDER_DRAGON_SPAWN_EGG);
            event.accept(Items.WARDEN_SPAWN_EGG);
        }
    }
}