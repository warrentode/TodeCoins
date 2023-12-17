package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class CraftingRecipesGen extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipesGen(DataGenerator pGenerator) {
        super(pGenerator);
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        armorRecipes(consumer);
        currencyStampsRecipes(consumer);
        jobBlockRecipes(consumer);
        nuggetRecipes(consumer);
        storageBlockRecipes(consumer);
        textileRecipes(consumer);
        collectibleCoinSmeltingRecipes(consumer);
        collectibleCoinBlastingRecipes(consumer);
        holidayChocolateCoinRecipes(consumer);
    }

    private static void holidayChocolateCoinRecipes(Consumer<FinishedRecipe> consumer) {
        chocolateCoinRecipeTemplate(consumer, ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get(), 4, Items.CRIMSON_FUNGUS, Items.ROTTEN_FLESH);
        chocolateCoinRecipeTemplate(consumer, ModItems.WARPED_SPICE_CHOCOLATE_COIN.get(), 4, Items.WARPED_FUNGUS, Items.PUFFERFISH);
        chocolateCoinRecipeTemplate(consumer, ModItems.MILK_BONE_CHOCOLATE_COIN.get(), 4, Items.BONE_MEAL, Items.COBWEB);
        chocolateCoinRecipeTemplate(consumer, ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get(), 4, Items.EMERALD, Items.INK_SAC);
        chocolateCoinRecipeTemplate(consumer, ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get(), 4, Items.MAGMA_CREAM, Items.GLOWSTONE_DUST);
        chocolateCoinRecipeTemplate(consumer, ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get(), 4, Items.HONEY_BLOCK, Items.COOKIE);

        chocolateCoinRecipeTemplate2(consumer, ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get(), 4, ForgeTags.Items.BERRIES, Items.PHANTOM_MEMBRANE);
        chocolateCoinRecipeTemplate2(consumer, ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get(), 4, ForgeTags.Items.COCOA, Items.GLOW_LICHEN);

        chocolateCoinRecipeTemplate3(consumer, ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get(), 4, ForgeTags.Items.CLOVER, ForgeTags.Items.CLOVER);
    }

    private static void chocolateCoinRecipeTemplate(Consumer<FinishedRecipe> consumer, Item result, int resultAmount, Item flavorA, Item flavorB) {
        ShapelessRecipeBuilder.shapeless(result, resultAmount)
                .group("chocolate_coins")
                .requires(ForgeTags.Items.COCOA)
                .requires(ForgeTags.Items.SUGAR)
                .requires(ForgeTags.Items.MILK)
                .requires(ForgeTags.Items.FAT)
                // flavoring "extract" item 1
                .requires(flavorA)
                // flavoring "extract" item 2
                .requires(flavorB)
                .unlockedBy("has_cocoa", has(ForgeTags.Items.COCOA))
                .save(consumer, new ResourceLocation(MODID, "chocolate_coins/" + result));
    }

    private static void chocolateCoinRecipeTemplate2(Consumer<FinishedRecipe> consumer, Item result, int resultAmount, TagKey<Item> flavorA, Item flavorB) {
        ShapelessRecipeBuilder.shapeless(result, resultAmount)
                .group("chocolate_coins")
                .requires(ForgeTags.Items.COCOA)
                .requires(ForgeTags.Items.SUGAR)
                .requires(ForgeTags.Items.MILK)
                .requires(ForgeTags.Items.FAT)
                // flavoring "extract" item 1
                .requires(flavorA)
                // flavoring "extract" item 2
                .requires(flavorB)
                .unlockedBy("has_cocoa", has(ForgeTags.Items.COCOA))
                .save(consumer, new ResourceLocation(MODID, "chocolate_coins/" + result));
    }

    private static void chocolateCoinRecipeTemplate3(Consumer<FinishedRecipe> consumer, Item result, int resultAmount, TagKey<Item> flavorA, TagKey<Item> flavorB) {
        ShapelessRecipeBuilder.shapeless(result, resultAmount)
                .group("chocolate_coins")
                .requires(ForgeTags.Items.COCOA)
                .requires(ForgeTags.Items.SUGAR)
                .requires(ForgeTags.Items.MILK)
                .requires(ForgeTags.Items.FAT)
                // flavoring "extract" item 1
                .requires(flavorA)
                // flavoring "extract" item 2
                .requires(flavorB)
                .unlockedBy("has_cocoa", has(ForgeTags.Items.COCOA))
                .save(consumer, new ResourceLocation(MODID, "chocolate_coins/" + result));
    }

    static Ingredient copperCollectibleCoin = Ingredient.of(ModTags.Items.COPPER_COLLECTIBLE_COINS);
    static Ingredient ironCollectibleCoin = Ingredient.of(ModTags.Items.IRON_COLLECTIBLE_COINS);
    static Ingredient goldCollectibleCoin = Ingredient.of(ModTags.Items.GOLD_COLLECTIBLE_COINS);
    static Ingredient netheriteCollectibleCoin = Ingredient.of(ModTags.Items.NETHERITE_COLLECTIBLE_COINS);
    static Ingredient endonianCollectibleCoin = Ingredient.of(ModTags.Items.ENDONIAN_COLLECTIBLE_COINS);

    private static void collectibleCoinSmeltingRecipes(Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(copperCollectibleCoin, ModItems.COPPER_NUGGET.get(), 0.1F, 100)
                .unlockedBy("has_copper_collectible_coin", has(ModTags.Items.COPPER_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/smelting/copper_nugget"));
        SimpleCookingRecipeBuilder.smelting(ironCollectibleCoin, Items.IRON_NUGGET, 0.1F, 100)
                .unlockedBy("has_iron_collectible_coin", has(ModTags.Items.IRON_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/smelting/iron_nugget"));
        SimpleCookingRecipeBuilder.smelting(goldCollectibleCoin, Items.GOLD_NUGGET, 0.1F, 100)
                .unlockedBy("has_gold_collectible_coin", has(ModTags.Items.GOLD_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/smelting/gold_nugget"));
        SimpleCookingRecipeBuilder.smelting(netheriteCollectibleCoin, ModItems.NETHERITE_NUGGET.get(), 0.1F, 100)
                .unlockedBy("has_netherite_collectible_coin", has(ModTags.Items.NETHERITE_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/smelting/netherite_nugget"));
        SimpleCookingRecipeBuilder.smelting(endonianCollectibleCoin, ModItems.ENDONIAN_NUGGET.get(), 0.1F, 100)
                .unlockedBy("has_endonian_collectible_coin", has(ModTags.Items.ENDONIAN_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/smelting/endonian_nugget"));
    }

    private static void collectibleCoinBlastingRecipes(Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.blasting(copperCollectibleCoin, ModItems.COPPER_NUGGET.get(), 0.1F, 100)
                .unlockedBy("has_copper_collectible_coin", has(ModTags.Items.COPPER_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/blasting/copper_nugget"));
        SimpleCookingRecipeBuilder.blasting(ironCollectibleCoin, Items.IRON_NUGGET, 0.1F, 100)
                .unlockedBy("has_iron_collectible_coin", has(ModTags.Items.IRON_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/blasting/iron_nugget"));
        SimpleCookingRecipeBuilder.blasting(goldCollectibleCoin, Items.GOLD_NUGGET, 0.1F, 100)
                .unlockedBy("has_gold_collectible_coin", has(ModTags.Items.GOLD_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/blasting/gold_nugget"));
        SimpleCookingRecipeBuilder.blasting(netheriteCollectibleCoin, ModItems.NETHERITE_NUGGET.get(), 0.1F, 100)
                .unlockedBy("has_netherite_collectible_coin", has(ModTags.Items.NETHERITE_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/blasting/netherite_nugget"));
        SimpleCookingRecipeBuilder.blasting(endonianCollectibleCoin, ModItems.ENDONIAN_NUGGET.get(), 0.1F, 100)
                .unlockedBy("has_endonian_collectible_coin", has(ModTags.Items.ENDONIAN_COLLECTIBLE_COINS))
                .save(consumer, new ResourceLocation(MODID, "nuggets/blasting/endonian_nugget"));
    }

    private static void armorRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.LUCKY_HAT.get(), 1)
                .pattern("CCC")
                .pattern("C C")
                .define('C', ModItems.LUCKY_FABRIC.get())
                .unlockedBy("has_lucky_fabric", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_FABRIC.get()))
                .save(consumer, new ResourceLocation(MODID, "armor/lucky_fabric/lucky_hat"));
        ShapedRecipeBuilder.shaped(ModItems.LUCKY_SHIRT.get(), 1)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.LUCKY_FABRIC.get())
                .unlockedBy("has_lucky_fabric", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_FABRIC.get()))
                .save(consumer, new ResourceLocation(MODID, "armor/lucky_fabric/lucky_shirt"));
        ShapedRecipeBuilder.shaped(ModItems.LUCKY_BOOTS.get(), 1)
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.LUCKY_FABRIC.get())
                .unlockedBy("has_lucky_fabric", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_FABRIC.get()))
                .save(consumer, new ResourceLocation(MODID, "armor/lucky_fabric/lucky_boots"));
        ShapedRecipeBuilder.shaped(ModItems.LUCKY_PANTS.get(), 1)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.LUCKY_FABRIC.get())
                .unlockedBy("has_lucky_fabric", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_FABRIC.get()))
                .save(consumer, new ResourceLocation(MODID, "armor/lucky_fabric/lucky_pants"));
    }

    private static void currencyStampsRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.CURRENCY_STAMP.get(), 1)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" S ")
                .define('S', Items.SMOOTH_STONE_SLAB)
                .define('C', Items.COBBLESTONE)
                .unlockedBy("has_smooth_stone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SMOOTH_STONE_SLAB))
                .save(consumer, new ResourceLocation(MODID, "currency_stamps/currency_stamp"));
        ShapedRecipeBuilder.shaped(ModItems.NETHER_CURRENCY_STAMP.get(), 1)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" S ")
                .define('S', Items.BLACKSTONE_SLAB)
                .define('C', Items.CHISELED_POLISHED_BLACKSTONE)
                .unlockedBy("has_chiseled_polished_blackstone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CHISELED_POLISHED_BLACKSTONE))
                .save(consumer, new ResourceLocation(MODID, "currency_stamps/nether_currency_stamp"));
        ShapedRecipeBuilder.shaped(ModItems.ENDONIAN_CURRENCY_STAMP.get(), 1)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" S ")
                .define('S', Items.PURPUR_SLAB)
                .define('C', Items.ENDER_EYE)
                .unlockedBy("has_purpur_slab", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PURPUR_SLAB))
                .save(consumer, new ResourceLocation(MODID, "currency_stamps/endonian_currency_stamp"));
    }
    private static void jobBlockRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModBlocks.COINPRESSBLOCK.get(), 1)
                .pattern("III")
                .pattern("DID")
                .pattern("PPP")
                .define('I', Items.IRON_INGOT)
                .define('D', Items.POLISHED_DEEPSLATE)
                .define('P', ItemTags.PLANKS)
                .unlockedBy("has_polished_deepslate", InventoryChangeTrigger.TriggerInstance.hasItems(Items.POLISHED_DEEPSLATE))
                .save(consumer, new ResourceLocation(MODID, "job_blocks/coin_press"));
        ShapedRecipeBuilder.shaped(ModBlocks.POT_OF_GOLD.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.GOLD_COIN_BAG.get())
                .unlockedBy("has_gold_coin_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GOLD_COIN_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "job_blocks/pot_of_gold"));
        ShapelessRecipeBuilder.shapeless(ModBlocks.GOLD_COIN_BAG.get(), 9)
                .requires(ModBlocks.POT_OF_GOLD.get())
                .unlockedBy("has_pot_of_gold", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.POT_OF_GOLD.get()))
                .save(consumer, new ResourceLocation(MODID, "job_blocks/bags_of_gold_from_pot_of_gold"));
    }
    private static void nuggetRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(Items.COPPER_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ForgeTags.Items.COPPER_NUGGET)
                .unlockedBy("has_copper_nugget", has(ForgeTags.Items.COPPER_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "ingots/ingot_from_nuggets/copper_ingot"));
        ShapedRecipeBuilder.shaped(Items.NETHERITE_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ForgeTags.Items.NETHERITE_NUGGET)
                .unlockedBy("has_netherite_nugget", has(ForgeTags.Items.NETHERITE_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "ingots/ingot_from_nuggets/netherite_ingot"));
        ShapedRecipeBuilder.shaped(ModItems.ENDONIAN_INGOT.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ForgeTags.Items.ENDONIAN_NUGGET)
                .unlockedBy("has_endonian_nugget", has(ForgeTags.Items.ENDONIAN_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "ingots/ingot_from_nuggets/endonian_ingot"));

        ShapedRecipeBuilder.shaped(ModItems.LUCKY_NUGGET.get(), 1)
                .pattern("###")
                .pattern(" # ")
                .pattern("###")
                .define('#', ModItems.FOUR_LEAF_CLOVER.get())
                .unlockedBy("has_four_leaf_clover", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOUR_LEAF_CLOVER.get()))
                .save(consumer, new ResourceLocation(MODID, "nuggets/nugget_from_other/lucky_nugget"));

        ShapelessRecipeBuilder.shapeless(ModItems.COPPER_NUGGET.get(), 9)
                .requires(ForgeTags.Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingot", has(ForgeTags.Items.COPPER_INGOT))
                .save(consumer, new ResourceLocation(MODID, "nuggets/nuggets_from_ingots/copper_nugget"));
        ShapelessRecipeBuilder.shapeless(ModItems.NETHERITE_NUGGET.get(), 9)
                .requires(ForgeTags.Items.NETHERITE_INGOT)
                .unlockedBy("has_netherite_ingot", has(ForgeTags.Items.NETHERITE_INGOT))
                .save(consumer, new ResourceLocation(MODID, "nuggets/nuggets_from_ingots/netherite_nugget"));
        ShapelessRecipeBuilder.shapeless(ModItems.ENDONIAN_NUGGET.get(), 9)
                .requires(ForgeTags.Items.ENDONIAN_INGOT)
                .unlockedBy("has_endonian_ingot", has(ForgeTags.Items.ENDONIAN_INGOT))
                .save(consumer, new ResourceLocation(MODID, "nuggets/nuggets_from_ingots/endonian_nugget"));


        ShapelessRecipeBuilder.shapeless(ModItems.COPPER_NUGGET.get())
                .requires(ModItems.COPPER_COIN.get(), 2)
                .unlockedBy("has_copper_coin", has(ForgeTags.Items.COPPER_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "nuggets/nugget_from_coins/copper_nugget"));
        ShapelessRecipeBuilder.shapeless(Items.IRON_NUGGET)
                .requires(ModItems.IRON_COIN.get(), 2)
                .unlockedBy("has_iron_coin", has(ForgeTags.Items.IRON_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "nuggets/nugget_from_coins/iron_nugget"));
        ShapelessRecipeBuilder.shapeless(Items.GOLD_NUGGET)
                .requires(ModItems.GOLD_COIN.get(), 2)
                .unlockedBy("has_gold_coin", has(ForgeTags.Items.GOLD_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "nuggets/nugget_from_coins/gold_nugget"));
        ShapelessRecipeBuilder.shapeless(ModItems.NETHERITE_NUGGET.get())
                .requires(ModItems.NETHERITE_COIN.get(), 2)
                .unlockedBy("has_netherite_coin", has(ForgeTags.Items.NETHERITE_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "nuggets/nugget_from_coins/netherite_nugget"));
        ShapelessRecipeBuilder.shapeless(ModItems.ENDONIAN_NUGGET.get())
                .requires(ModItems.ENDONIAN_COIN.get(), 2)
                .unlockedBy("has_endonian_coin", has(ForgeTags.Items.ENDONIAN_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "nuggets/nugget_from_coins/endonian_nugget"));
    }
    private static void storageBlockRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModBlocks.COPPER_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.COPPER_COIN.get())
                .unlockedBy("has_copper_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COIN.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/coins_to_bags/copper_bag"));
        ShapedRecipeBuilder.shaped(ModBlocks.IRON_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.IRON_COIN.get())
                .unlockedBy("has_iron_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COIN.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/coins_to_bags/iron_bag"));
        ShapedRecipeBuilder.shaped(ModBlocks.GOLD_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.GOLD_COIN.get())
                .unlockedBy("has_gold_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COIN.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/coins_to_bags/gold_bag"));
        ShapedRecipeBuilder.shaped(ModBlocks.NETHERITE_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.NETHERITE_COIN.get())
                .unlockedBy("has_netherite_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COIN.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/coins_to_bags/netherite_coin_bag"));
        ShapedRecipeBuilder.shaped(ModBlocks.ENDONIAN_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.ENDONIAN_COIN.get())
                .unlockedBy("has_endonian_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDONIAN_COIN.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/coins_to_bags/endonian_coin_bag"));
        ShapedRecipeBuilder.shaped(ModBlocks.NETHER_GOLD_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.NETHER_GOLD_COIN.get())
                .unlockedBy("has_nether_gold_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHER_GOLD_COIN.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/coins_to_bags/nether_gold_bag"));
        ShapedRecipeBuilder.shaped(ModBlocks.LUCKY_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.LUCKY_COIN.get())
                .unlockedBy("has_lucky_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_BANK_NOTE.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/coin_to_bags/lucky_coin_bag"));
        ShapedRecipeBuilder.shaped(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.EMERALD_QUARTER_BANK_NOTE.get())
                .unlockedBy("has_emerald_quarter_note", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_QUARTER_BANK_NOTE.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bank_notes_to_bags/emerald_quarter_bank_note_bag"));
        ShapedRecipeBuilder.shaped(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.EMERALD_HALF_BANK_NOTE.get())
                .unlockedBy("has_emerald_half_note", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_HALF_BANK_NOTE.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bank_notes_to_bags/emerald_half_bank_note_bag"));
        ShapedRecipeBuilder.shaped(ModBlocks.EMERALD_BANK_NOTE_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.EMERALD_BANK_NOTE.get())
                .unlockedBy("has_emerald_note", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_BANK_NOTE.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bank_notes_to_bags/emerald_bank_note_bag"));

        ShapedRecipeBuilder.shaped(ModBlocks.ENDONIAN_BLOCK.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ForgeTags.Items.ENDONIAN_INGOT)
                .unlockedBy("has_endonian_ingot", has(ForgeTags.Items.ENDONIAN_INGOT))
                .save(consumer, new ResourceLocation(MODID, "blocks/blocks_from_ingots/endonian_block"));
        ShapedRecipeBuilder.shaped(ModBlocks.ENDONIAN_BLOCK.get(), 1)
                .pattern("# #")
                .pattern(" P ")
                .pattern("# #")
                .define('#', Items.CHORUS_FLOWER)
                .define('P', Items.ENDER_PEARL)
                .unlockedBy("has_chorus_flower", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CHORUS_FLOWER))
                .save(consumer, new ResourceLocation(MODID, "blocks/blocks_from_other/endonian_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.COPPER_COIN.get(), 9)
                .requires(ModBlocks.COPPER_COIN_BAG.get())
                .unlockedBy("has_copper_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COPPER_COIN_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_coins/copper_coins"));
        ShapelessRecipeBuilder.shapeless(ModItems.IRON_COIN.get(), 9)
                .requires(ModBlocks.IRON_COIN_BAG.get())
                .unlockedBy("has_iron_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_COIN_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_coins/iron_coins"));
        ShapelessRecipeBuilder.shapeless(ModItems.GOLD_COIN.get(), 9)
                .requires(ModBlocks.GOLD_COIN_BAG.get())
                .unlockedBy("has_gold_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GOLD_COIN_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_coins/gold_coins"));
        ShapelessRecipeBuilder.shapeless(ModItems.NETHERITE_COIN.get(), 9)
                .requires(ModBlocks.NETHERITE_COIN_BAG.get())
                .unlockedBy("has_netherite_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHERITE_COIN_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_coins/netherite_coins"));
        ShapelessRecipeBuilder.shapeless(ModItems.ENDONIAN_COIN.get(), 9)
                .requires(ModBlocks.ENDONIAN_COIN_BAG.get())
                .unlockedBy("has_endonian_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ENDONIAN_COIN_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_coins/endonian_coins"));
        ShapelessRecipeBuilder.shapeless(ModItems.NETHER_GOLD_COIN.get(), 9)
                .requires(ModBlocks.NETHER_GOLD_COIN_BAG.get())
                .unlockedBy("has_nether_gold_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHER_GOLD_COIN_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_coins/nether_gold_coins"));
        ShapelessRecipeBuilder.shapeless(ModItems.LUCKY_COIN.get(), 9)
                .requires(ModBlocks.LUCKY_COIN_BAG.get())
                .unlockedBy("has_lucky_coin_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.LUCKY_COIN_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_coins/lucky_coins"));
        ShapelessRecipeBuilder.shapeless(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 9)
                .requires(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get())
                .unlockedBy("has_emerald_quarter_note_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_bank_notes/emerald_quarter_bank_notes"));
        ShapelessRecipeBuilder.shapeless(ModItems.EMERALD_HALF_BANK_NOTE.get(), 9)
                .requires(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get())
                .unlockedBy("has_emerald_half_note_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_bank_notes/emerald_half_bank_notes"));
        ShapelessRecipeBuilder.shapeless(ModItems.EMERALD_BANK_NOTE.get(), 9)
                .requires(ModBlocks.EMERALD_BANK_NOTE_BAG.get())
                .unlockedBy("has_emerald_note_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMERALD_BANK_NOTE_BAG.get()))
                .save(consumer, new ResourceLocation(MODID, "storage_blocks/bags_to_bank_notes/emerald_bank_notes"));

        ShapelessRecipeBuilder.shapeless(ModItems.ENDONIAN_INGOT.get(), 9)
                .requires(ModBlocks.ENDONIAN_BLOCK.get())
                .unlockedBy("has_endonian_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ENDONIAN_BLOCK.get()))
                .save(consumer, new ResourceLocation(MODID, "ingots/ingot_from_blocks/endonian_ingot"));
    }
    private static void textileRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_FIBER.get(), 1)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .define('#', ForgeTags.Items.CURRENCY_FIBER)
                .define('E', Items.EMERALD)
                .unlockedBy("has_emerald", has(ForgeTags.Items.CURRENCY_FIBER))
                .save(consumer, new ResourceLocation(MODID, "textiles/fiber/emerald_fiber"));
        ShapedRecipeBuilder.shaped(ModItems.LUCKY_FIBER.get(), 1)
                .pattern("###")
                .pattern("#C#")
                .pattern("###")
                .define('#', ForgeTags.Items.CURRENCY_FIBER)
                .define('C', ModItems.LUCKY_COIN.get())
                .unlockedBy("has_lucky_coin", has(ModItems.LUCKY_COIN.get()))
                .save(consumer, new ResourceLocation(MODID, "textiles/fiber/lucky_fiber"));

        ShapelessRecipeBuilder.shapeless(ModItems.EMERALD_SMOOTH_WOVE_PAPER.get(), 1)
                .requires(ModItems.EMERALD_FIBER.get(), 8)
                .unlockedBy("has_emerald_fiber", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_FIBER.get()))
                .save(consumer, new ResourceLocation(MODID, "textiles/paper/emerald_smooth_wove_paper"));
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_WOVE_PAPER.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.EMERALD_FIBER.get())
                .unlockedBy("has_emerald_fiber", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_FIBER.get()))
                .save(consumer, new ResourceLocation(MODID, "textiles/paper/emerald_wove_paper"));
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_COARSE_WOVE_PAPER.get(), 1)
                .pattern("##")
                .define('#', ModItems.EMERALD_FIBER.get())
                .unlockedBy("has_emerald_fiber", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_FIBER.get()))
                .save(consumer, new ResourceLocation(MODID, "textiles/paper/emerald_coarse_wove_paper"));

        ShapedRecipeBuilder.shaped(ModItems.LUCKY_FABRIC.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.LUCKY_THREAD.get())
                .unlockedBy("has_lucky_thread", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_THREAD.get()))
                .save(consumer, new ResourceLocation(MODID, "textiles/fabric/lucky_fabric"));

        ShapedRecipeBuilder.shaped(ModItems.LUCKY_THREAD.get(), 1)
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.LUCKY_FIBER.get())
                .unlockedBy("has_lucky_fiber", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_FIBER.get()))
                .save(consumer, new ResourceLocation(MODID, "textiles/thread/lucky_thread"));
    }
}