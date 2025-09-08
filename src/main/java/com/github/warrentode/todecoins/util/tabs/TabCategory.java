package com.github.warrentode.todecoins.util.tabs;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;

public enum TabCategory {
    CURRENCY(CreativeModeTabs.INGREDIENTS),
    TOOL(CreativeModeTabs.TOOLS_AND_UTILITIES),
    EQUIPMENT(CreativeModeTabs.COMBAT),
    FOOD(CreativeModeTabs.FOOD_AND_DRINKS),
    SPAWN(CreativeModeTabs.SPAWN_EGGS),
    BUILDING(CreativeModeTabs.BUILDING_BLOCKS),
    DECORATIVE(CreativeModeTabs.FUNCTIONAL_BLOCKS),
    NATURAL(CreativeModeTabs.NATURAL_BLOCKS);

    private final ResourceKey<CreativeModeTab> tab;

    TabCategory(ResourceKey<CreativeModeTab> tab) {
        this.tab = tab;
    }

    public ResourceKey<CreativeModeTab> getTab() {
        return tab;
    }
}