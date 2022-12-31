package net.warrentode.todecoins.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.warrentode.todecoins.TodeCoins;

public class ModTags {
    public static final TagKey<Block> CURRENCY_BAGS = modBlockTag("currency_bags");

    public static final TagKey<Item> BANKNOTES = modItemTag("banknotes");
    public static final TagKey<Item> COINS = modItemTag("coins");
    public static final TagKey<Item> CURRENCY = modItemTag("currency");

    public static final TagKey<Block> STORAGE_BLOCKS = forgeBlockTag("forge:storage_blocks");

    public static final TagKey<Item> GEMS = forgeItemTag("forge:gems");
    public static final TagKey<Item> TEXTILES = forgeItemTag("forge:textiles");
    public static final TagKey<Item> COPPER_NUGGET = forgeItemTag("forge:nuggets/copper");
    public static final TagKey<Item> COPPER_INGOT = forgeItemTag("forge:ingots/copper");
    public static final TagKey<Item> IRON_NUGGET = forgeItemTag("forge:nuggets/iron");
    public static final TagKey<Item> IRON_INGOT = forgeItemTag("forge:ingots/iron");
    public static final TagKey<Item> GOLD_NUGGET = forgeItemTag("forge:nuggets/gold");
    public static final TagKey<Item> GOLD_INGOT = forgeItemTag("forge:ingots/gold");
    public static final TagKey<Item> NETHERITE_INGOT = forgeItemTag("forge:ingots/netherite");

    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(TodeCoins.MOD_ID, path));
    }
    private static TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(TodeCoins.MOD_ID, path));
    }

    private static TagKey<Block> forgeBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge", path));
    }
    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", path));
    }
}