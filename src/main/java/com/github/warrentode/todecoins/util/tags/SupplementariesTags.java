package com.github.warrentode.todecoins.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SupplementariesTags {
    public static class Items {
        public static final TagKey<Item> COOKIES = supplementariesItemTag("cookies");
    }

    private static TagKey<Item> supplementariesItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("supplementaries", path));
    }
}