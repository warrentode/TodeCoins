package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class BlockLootGen extends BlockLootSubProvider {
    public BlockLootGen() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(TCBlocks.ENDONIAN_ORE.get(),
                (block) -> this.createOreDrop(block, TCItems.ENDONIAN_CRYSTAL.get()));

        List<Block> blockList = ForgeRegistries.BLOCKS.getValues().stream()
                .filter(item -> item.getDescriptionId().contains(MODID))
                .filter(item -> !item.getDescriptionId().contains("ore"))
                .toList();

        blockList.forEach(this::dropSelf);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(block -> MODID.equals(Objects.requireNonNull(
                                ForgeRegistries.BLOCKS.getKey(block))
                        .getNamespace())).collect(Collectors.toSet());
    }
}