package net.warrentode.todecoins.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class CuriosTags {
    public static class Items {
        public static final TagKey<Item> CHARM = curiosItemTag("charm");
    }

    private static @NotNull TagKey<Item> curiosItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("curios", path));
    }
}