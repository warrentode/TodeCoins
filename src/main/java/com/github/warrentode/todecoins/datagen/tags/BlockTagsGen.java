package com.github.warrentode.todecoins.datagen.tags;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.util.tags.TCBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class BlockTagsGen extends BlockTagsProvider {
    public BlockTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
        registerBlockMineables();
        registerBlockLootTags();
        registerBlockTags();
        registerPOITags();
    }

    private void registerBlockMineables() {
        // tool harvested by
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TCBlocks.ENDONIAN_ORE.get());
        // material tier of the tool
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(TCBlocks.ENDONIAN_ORE.get());
    }

    private void registerBlockLootTags() {
        tag(TCBlockTags.DROPS_FOUR_LEAF_CLOVER)
                .add(Blocks.GRASS)
                .add(Blocks.TALL_GRASS)
                .add(Blocks.FERN)
                .add(Blocks.LARGE_FERN)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:clover")))
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:huge_clover_petal")));
    }

    private void registerBlockTags() {
        tag(TCBlockTags.STORAGE_BLOCKS)
                .addTag(TCBlockTags.CURRENCY_BLOCKS);
        tag(TCBlockTags.CURRENCY_BLOCKS)
                .add(TCBlocks.COPPER_COIN_BAG.get())
                .add(TCBlocks.IRON_COIN_BAG.get())
                .add(TCBlocks.GOLD_COIN_BAG.get())
                .add(TCBlocks.NETHERITE_COIN_BAG.get())
                .add(TCBlocks.NETHER_GOLD_COIN_BAG.get())
                .add(TCBlocks.ENDONIAN_COIN_BAG.get())
                .add(TCBlocks.LUCKY_COIN_BAG.get())
                .add(TCBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get())
                .add(TCBlocks.EMERALD_HALF_BANK_NOTE_BAG.get())
                .add(TCBlocks.EMERALD_BANK_NOTE_BAG.get())
                .add(TCBlocks.POT_OF_GOLD.get());
    }

    private void registerPOITags() {
        tag(TCBlockTags.JOB_BLOCKS)
                .add(TCBlocks.COINPRESSBLOCK.get())
                .add(TCBlocks.POT_OF_GOLD.get());
    }
}