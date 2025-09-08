package com.github.warrentode.todecoins.datagen.models;

import com.github.warrentode.todecoins.block.TCBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

// this setup is only for the model files, not the blockstate files
public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(PackOutput output, String modid, ExistingFileHelper helper) {
        super(output, modid, helper);
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

        models().cubeBottomTop("lapis_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/lapis_coin_bag_top"));
        models().cubeBottomTop("amethyst_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/amethyst_coin_bag_top"));
        models().cubeBottomTop("diamond_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/diamond_coin_bag_top"));
        models().cubeBottomTop("emerald_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/emerald_coin_bag_top"));
        models().cubeBottomTop("echo_coin_bag",
                modLoc("block/bag_side"),
                modLoc("block/bag_bottom"),
                modLoc("block/echo_coin_bag_top"));

        simpleBlockItem(TCBlocks.ENDONIAN_BLOCK.get(), cubeAll(TCBlocks.ENDONIAN_BLOCK.get()));
        simpleBlockItem(TCBlocks.ENDONIAN_ORE.get(), cubeAll(TCBlocks.ENDONIAN_ORE.get()));

        // block items
        itemModels().withExistingParent("copper_coin_bag", modLoc("block/copper_coin_bag"));
        itemModels().withExistingParent("iron_coin_bag", modLoc("block/iron_coin_bag"));
        itemModels().withExistingParent("gold_coin_bag", modLoc("block/gold_coin_bag"));
        itemModels().withExistingParent("nether_gold_coin_bag", modLoc("block/nether_gold_coin_bag"));
        itemModels().withExistingParent("endonian_coin_bag", modLoc("block/endonian_coin_bag"));
        itemModels().withExistingParent("netherite_coin_bag", modLoc("block/netherite_coin_bag"));
        itemModels().withExistingParent("lucky_coin_bag", modLoc("block/lucky_coin_bag"));

        itemModels().withExistingParent("lapis_coin_bag", modLoc("block/lapis_coin_bag"));
        itemModels().withExistingParent("amethyst_coin_bag", modLoc("block/amethyst_coin_bag"));
        itemModels().withExistingParent("diamond_coin_bag", modLoc("block/diamond_coin_bag"));
        itemModels().withExistingParent("emerald_coin_bag", modLoc("block/emerald_coin_bag"));
        itemModels().withExistingParent("echo_coin_bag", modLoc("block/echo_coin_bag"));

        itemModels().withExistingParent("emerald_bank_note_bag", modLoc("block/emerald_bank_note_bag"));
        itemModels().withExistingParent("emerald_half_bank_note_bag", modLoc("block/emerald_half_bank_note_bag"));
        itemModels().withExistingParent("emerald_quarter_bank_note_bag", modLoc("block/emerald_quarter_bank_note_bag"));
    }
}