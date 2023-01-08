package net.warrentode.todecoins.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.warrentode.todecoins.TodeCoins;

public class ModTags {
    public static final TagKey<Block> CURRENCY_BLOCKS = modBlockTag("storage_blocks");

    public static final TagKey<Item> BANKNOTES = modItemTag("banknotes");
    public static final TagKey<Item> COINS = modItemTag("coins");
    public static final TagKey<Item> CURRENCY = modItemTag("currency");
    public static final TagKey<Item> CURRENCY_MATERIALS = modItemTag("currency_materials");
    public static final TagKey<Item> TEXTILES = modItemTag("textiles");
    public static final TagKey<Item> FIBRE = modItemTag("textiles/fibre");
    public static final TagKey<Item> CURRENCY_FIBER = modItemTag("textiles/currency_fiber");
    public static final TagKey<Item> CURRENCY_PAPER = modItemTag("textiles/currency_paper");

    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(TodeCoins.MOD_ID, path));
    }
    private static TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(TodeCoins.MOD_ID, path));
    }
}