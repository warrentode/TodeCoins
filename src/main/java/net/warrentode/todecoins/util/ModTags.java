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
    public static final TagKey<Item> GEMS = modItemTag("gems");
    public static final TagKey<Item> TEXTILES = modItemTag("textiles");

    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(TodeCoins.MOD_ID, path));;
    }
    private static TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(TodeCoins.MOD_ID, path));;
    }
}