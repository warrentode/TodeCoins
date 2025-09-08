package com.github.warrentode.todecoins.util.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TCBlockTags {
    public static final TagKey<Block> DROPS_FOUR_LEAF_CLOVER = blockTag(MODID,"drops_four_leaf_clover");
    public static final TagKey<Block> STORAGE_BLOCKS = blockTag("forge","storage_blocks");
    public static final TagKey<Block> CURRENCY_BLOCKS = blockTag(MODID,"storage_blocks/currency_blocks");
    public static final TagKey<Block> JOB_BLOCKS = blockTag(MODID,"job_blocks");

    private static @NotNull TagKey<Block> blockTag(String modid, String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.parse(modid + ":" + path));
    }
}