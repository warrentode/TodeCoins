package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class BlockLootGen extends BlockLootSubProvider {
    private final Set<Block> blockTables = new HashSet<>();

    public BlockLootGen() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(TCBlocks.COINPRESSBLOCK.get());
        this.dropSelf(TCBlocks.POT_OF_GOLD.get());

        this.dropSelf(TCBlocks.ENDONIAN_BLOCK.get());

        this.dropSelf(TCBlocks.COPPER_COIN_BAG.get());
        this.dropSelf(TCBlocks.IRON_COIN_BAG.get());
        this.dropSelf(TCBlocks.GOLD_COIN_BAG.get());
        this.dropSelf(TCBlocks.NETHER_GOLD_COIN_BAG.get());
        this.dropSelf(TCBlocks.NETHERITE_COIN_BAG.get());
        this.dropSelf(TCBlocks.ENDONIAN_COIN_BAG.get());
        this.dropSelf(TCBlocks.LUCKY_COIN_BAG.get());

        this.dropSelf(TCBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get());
        this.dropSelf(TCBlocks.EMERALD_HALF_BANK_NOTE_BAG.get());
        this.dropSelf(TCBlocks.EMERALD_BANK_NOTE_BAG.get());


        this.add(TCBlocks.ENDONIAN_ORE.get(),
                (block) -> this.createOreDrop(block, TCItems.ENDONIAN_CRYSTAL.get()));
    }

    @Override
    protected void add(@NotNull Block block, @NotNull LootTable.Builder builder) {
        this.blockTables.add(block);
        this.map.put(block.getLootTable(), builder);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return blockTables;
    }
}