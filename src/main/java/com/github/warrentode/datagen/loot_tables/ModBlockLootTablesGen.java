package com.github.warrentode.datagen.loot_tables;

import com.github.warrentode.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

import static com.github.warrentode.TodeCoins.MODID;

public class ModBlockLootTablesGen extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.COINPRESSBLOCK.get());
        this.dropSelf(ModBlocks.POT_OF_GOLD.get());

        this.dropSelf(ModBlocks.ENDONIAN_BLOCK.get());

        this.dropSelf(ModBlocks.COPPER_COIN_BAG.get());
        this.dropSelf(ModBlocks.IRON_COIN_BAG.get());
        this.dropSelf(ModBlocks.GOLD_COIN_BAG.get());
        this.dropSelf(ModBlocks.NETHER_GOLD_COIN_BAG.get());
        this.dropSelf(ModBlocks.NETHERITE_COIN_BAG.get());
        this.dropSelf(ModBlocks.ENDONIAN_COIN_BAG.get());
        this.dropSelf(ModBlocks.LUCKY_COIN_BAG.get());

        this.dropSelf(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get());
        this.dropSelf(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get());
        this.dropSelf(ModBlocks.EMERALD_BANK_NOTE_BAG.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        //noinspection deprecation
        return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> MODID.equals(Registry.BLOCK.getKey(block).getNamespace())).collect(Collectors.toSet());
    }
}