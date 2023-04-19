package net.warrentode.todecoins.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import static net.warrentode.todecoins.TodeCoins.MODID;

@SuppressWarnings("unused")
public class ModTags {
    public static final TagKey<Block> CURRENCY_BLOCKS = modBlockTag("storage_blocks/currency_blocks");
    public static final TagKey<Block> JOB_BLOCKS = modBlockTag("job_blocks");

    public static final TagKey<Item> BANKNOTES = modItemTag("banknotes");
    public static final TagKey<Item> COINS = modItemTag("coins");
    public static final TagKey<Item> CURRENCY = modItemTag("currency");
    public static final TagKey<Item> CURRENCY_MATERIALS = modItemTag("currency_materials");
    public static final TagKey<Item> CURRENCY_STAMPS = modItemTag("currency_stamps");

    public static final TagKey<Item> COPPER_NUGGET = modItemTag("nuggets/copper");
    public static final TagKey<Item> IRON_NUGGET = modItemTag("nuggets/iron");
    public static final TagKey<Item> GOLD_NUGGET = modItemTag("nuggets/gold");
    public static final TagKey<Item> NETHERITE_NUGGET = modItemTag("nuggets/netherite");

    public static final TagKey<Item> COPPER_INGOT = modItemTag("ingots/copper");
    public static final TagKey<Item> IRON_INGOT = modItemTag("ingots/iron");
    public static final TagKey<Item> GOLD_INGOT = modItemTag("ingots/gold");
    public static final TagKey<Item> NETHERITE_INGOT = modItemTag("ingots/netherite");

    public static final TagKey<Item> TEXTILES = modItemTag("textiles");
    public static final TagKey<Item> FIBRE = modItemTag("textiles/fibre");
    public static final TagKey<Item> FABRIC = modItemTag("textiles/fabric");
    public static final TagKey<Item> THREAD = modItemTag("textiles/thread");
    public static final TagKey<Item> CURRENCY_FIBER = modItemTag("textiles/currency_fiber");
    public static final TagKey<Item> CURRENCY_PAPER = modItemTag("textiles/currency_paper");

    private static @NotNull TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(MODID, path));
    }
    private static @NotNull TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, path));
    }
}