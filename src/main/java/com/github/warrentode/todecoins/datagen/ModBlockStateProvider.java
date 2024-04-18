package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper helper) {
        super(gen, modid, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        // blocks
        models().cubeBottomTop("copper_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/copper_coin_bag_top"));
        models().cubeBottomTop("iron_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/iron_coin_bag_top"));
        models().cubeBottomTop("gold_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/gold_coin_bag_top"));
        models().cubeBottomTop("nether_gold_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/nether_gold_coin_bag_top"));
        models().cubeBottomTop("endonian_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/endonian_coin_bag_top"));
        models().cubeBottomTop("netherite_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/netherite_coin_bag_top"));
        models().cubeBottomTop("lucky_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/lucky_coin_bag_top"));

        models().cubeBottomTop("emerald_bank_note_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/emerald_bank_note_bag_top"));
        models().cubeBottomTop("emerald_half_bank_note_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/emerald_half_bank_note_bag_top"));
        models().cubeBottomTop("emerald_quarter_bank_note_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/emerald_quarter_bank_note_bag_top"));

        simpleBlockItem(ModBlocks.ENDONIAN_BLOCK.get(), cubeAll(ModBlocks.ENDONIAN_BLOCK.get()));

        // block items
        itemModels().withExistingParent("copper_coin_bag", modLoc("block/copper_coin_bag"));
        itemModels().withExistingParent("iron_coin_bag", modLoc("block/iron_coin_bag"));
        itemModels().withExistingParent("gold_coin_bag", modLoc("block/gold_coin_bag"));
        itemModels().withExistingParent("nether_gold_coin_bag", modLoc("block/nether_gold_coin_bag"));
        itemModels().withExistingParent("endonian_coin_bag", modLoc("block/endonian_coin_bag"));
        itemModels().withExistingParent("netherite_coin_bag", modLoc("block/netherite_coin_bag"));
        itemModels().withExistingParent("lucky_coin_bag", modLoc("block/lucky_coin_bag"));

        itemModels().withExistingParent("emerald_bank_note_bag", modLoc("block/emerald_bank_note_bag"));
        itemModels().withExistingParent("emerald_half_bank_note_bag", modLoc("block/emerald_half_bank_note_bag"));
        itemModels().withExistingParent("emerald_quarter_bank_note_bag", modLoc("block/emerald_quarter_bank_note_bag"));
    }
}