package com.github.warrentode.todecoins.datagen.tags;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class BlockTagsGen extends BlockTagsProvider {
    public BlockTagsGen(DataGenerator pGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.registerModTags();
        this.registerMinecraftTags();
        this.registerForgeTags();
        this.registerBlockMineables();
    }

    protected void registerBlockMineables() {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.POT_OF_GOLD.get())
                .add(ModBlocks.COINPRESSBLOCK.get());
    }
    protected void registerMinecraftTags() {
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.POT_OF_GOLD.get())
                .add(ModBlocks.COINPRESSBLOCK.get());
    }
    protected void registerForgeTags() {
        tag(ForgeTags.Blocks.STORAGE_BLOCKS)
                .addTag(ForgeTags.Blocks.CURRENCY_BLOCKS);
        tag(ForgeTags.Blocks.CURRENCY_BLOCKS)
                .addTag(ModTags.Blocks.CURRENCY_BLOCKS);
    }
    protected void registerModTags() {
        tag(ModTags.Blocks.DROPS_FOUR_LEAF_CLOVER)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:clover")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:huge_clover_petal")))
                .add(Blocks.GRASS)
                .add(Blocks.TALL_GRASS);
        tag(ModTags.Blocks.STORAGE_BLOCKS)
                .addTag(ModTags.Blocks.CURRENCY_BLOCKS);
        tag(ModTags.Blocks.CURRENCY_BLOCKS).add(
                ModBlocks.COPPER_COIN_BAG.get(),
                ModBlocks.IRON_COIN_BAG.get(),
                ModBlocks.GOLD_COIN_BAG.get(),
                ModBlocks.NETHERITE_COIN_BAG.get(),
                ModBlocks.NETHER_GOLD_COIN_BAG.get(),
                ModBlocks.ENDONIAN_COIN_BAG.get(),
                ModBlocks.LUCKY_COIN_BAG.get(),
                ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get(),
                ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get(),
                ModBlocks.EMERALD_BANK_NOTE_BAG.get(),
                ModBlocks.POT_OF_GOLD.get()
        );
        tag(ModTags.Blocks.JOB_BLOCKS).add(
                ModBlocks.COINPRESSBLOCK.get(),
                ModBlocks.POT_OF_GOLD.get()
        );
    }
}