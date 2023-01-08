package net.warrentode.todecoins.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ForgeTags {
    public static final TagKey<Block> STORAGE_BLOCKS = forgeBlockTag("storage_blocks");

    public static final TagKey<Item> TEXTILES = forgeItemTag("textiles");
    public static final TagKey<Item> GEMS = forgeItemTag("gems");
    public static final TagKey<Item> NUGGETS = forgeItemTag("nuggets");
    public static final TagKey<Item> INGOTS = forgeItemTag("ingots");
    public static final TagKey<Item> COPPER_NUGGET = forgeItemTag("nuggets/copper");
    public static final TagKey<Item> IRON_NUGGET = forgeItemTag("nuggets/iron");
    public static final TagKey<Item> GOLD_NUGGET = forgeItemTag("nuggets/gold");
    public static final TagKey<Item> COPPER_INGOT = forgeItemTag("ingots/copper");
    public static final TagKey<Item> IRON_INGOT = forgeItemTag("ingots/iron");
    public static final TagKey<Item> GOLD_INGOT = forgeItemTag("ingots/gold");
    public static final TagKey<Item> NETHERITE_INGOT = forgeItemTag("ingots/netherite");

    private static TagKey<Block> forgeBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge", path));
    }
    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", path));
    }
}
