package com.github.warrentode.todecoins.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SupplementariesTags {
    public static class Items {
        public static final TagKey<Item> COOKIES = supplementariesItemTag("supplementaries", "cookies");
        public static final TagKey<Item> CHOCOLATE = supplementariesItemTag("supplementaries", "chocolate_bars");
        public static final TagKey<Item> CANDY = supplementariesItemTag("hauntedharvest", "candy");
        public static final TagKey<Item> SWEETS = supplementariesItemTag("hauntedharvest", "sweets");
    }

    private static TagKey<Item> supplementariesItemTag(String modid, String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(modid, path));
    }
}