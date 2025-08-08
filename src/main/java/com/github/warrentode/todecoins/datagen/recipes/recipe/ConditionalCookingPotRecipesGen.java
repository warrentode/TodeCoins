package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

import java.util.function.Consumer;

public class ConditionalCookingPotRecipesGen extends RecipeProvider implements IConditionBuilder {
    public ConditionalCookingPotRecipesGen(DataGenerator generator) {
        super(generator);
    }

    @SuppressWarnings("removal")
    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get(),
                                        4, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                                .addIngredient(TodeCoinsTags.Items.COCOA_INGREDIENTS)
                                .addIngredient(TodeCoinsTags.Items.SUGAR)
                                .addIngredient(TodeCoinsTags.Items.MILK)
                                .addIngredient(TodeCoinsTags.Items.FAT)
                                .addIngredient(Items.CRIMSON_FUNGUS)
                                .addIngredient(Items.ROTTEN_FLESH)
                                .unlockedBy("has_cocoa", has(TodeCoinsTags.Items.COCOA))
                                .build(consumer, new ResourceLocation("todecoins", "cooking/chocolate_coins/"
                                        + ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(and(modLoaded("todecoins")))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.WARPED_SPICE_CHOCOLATE_COIN.get(),
                                        4, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                                .addIngredient(TodeCoinsTags.Items.COCOA_INGREDIENTS)
                                .addIngredient(TodeCoinsTags.Items.SUGAR)
                                .addIngredient(TodeCoinsTags.Items.MILK)
                                .addIngredient(TodeCoinsTags.Items.FAT)
                                .addIngredient(Items.WARPED_FUNGUS)
                                .addIngredient(Items.PUFFERFISH)
                                .unlockedBy("has_cocoa", has(TodeCoinsTags.Items.COCOA))
                                .build(consumer, new ResourceLocation("todecoins", "cooking/chocolate_coins/"
                                        + ModItems.WARPED_SPICE_CHOCOLATE_COIN.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(and(modLoaded("todecoins")))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.MILK_BONE_CHOCOLATE_COIN.get(),
                                        4, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                                .addIngredient(TodeCoinsTags.Items.COCOA_INGREDIENTS)
                                .addIngredient(TodeCoinsTags.Items.SUGAR)
                                .addIngredient(TodeCoinsTags.Items.MILK)
                                .addIngredient(TodeCoinsTags.Items.FAT)
                                .addIngredient(Items.BONE_MEAL)
                                .addIngredient(Items.COBWEB)
                                .unlockedBy("has_cocoa", has(TodeCoinsTags.Items.COCOA))
                                .build(consumer, new ResourceLocation("todecoins", "cooking/chocolate_coins/"
                                        + ModItems.MILK_BONE_CHOCOLATE_COIN.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(and(modLoaded("todecoins")))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get(),
                                        4, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                                .addIngredient(TodeCoinsTags.Items.COCOA_INGREDIENTS)
                                .addIngredient(TodeCoinsTags.Items.SUGAR)
                                .addIngredient(TodeCoinsTags.Items.MILK)
                                .addIngredient(TodeCoinsTags.Items.FAT)
                                .addIngredient(Items.EMERALD)
                                .addIngredient(Items.INK_SAC)
                                .unlockedBy("has_cocoa", has(TodeCoinsTags.Items.COCOA))
                                .build(consumer, new ResourceLocation("todecoins", "cooking/chocolate_coins/"
                                        + ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(and(modLoaded("todecoins")))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get(),
                                        4, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                                .addIngredient(TodeCoinsTags.Items.COCOA_INGREDIENTS)
                                .addIngredient(TodeCoinsTags.Items.SUGAR)
                                .addIngredient(TodeCoinsTags.Items.MILK)
                                .addIngredient(TodeCoinsTags.Items.FAT)
                                .addIngredient(TodeCoinsTags.Items.BERRIES)
                                .addIngredient(Items.PHANTOM_MEMBRANE)
                                .unlockedBy("has_cocoa", has(TodeCoinsTags.Items.COCOA))
                                .build(consumer, new ResourceLocation("todecoins", "cooking/chocolate_coins/"
                                        + ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(and(modLoaded("todecoins")))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get(),
                                        4, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                                .addIngredient(TodeCoinsTags.Items.COCOA_INGREDIENTS)
                                .addIngredient(TodeCoinsTags.Items.SUGAR)
                                .addIngredient(TodeCoinsTags.Items.MILK)
                                .addIngredient(TodeCoinsTags.Items.FAT)
                                .addIngredient(TodeCoinsTags.Items.CLOVER)
                                .addIngredient(TodeCoinsTags.Items.CLOVER)
                                .unlockedBy("has_cocoa", has(TodeCoinsTags.Items.COCOA))
                                .build(consumer, new ResourceLocation("todecoins", "cooking/chocolate_coins/"
                                        + ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(and(modLoaded("todecoins")))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get(),
                                        4, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                                .addIngredient(TodeCoinsTags.Items.COCOA_INGREDIENTS)
                                .addIngredient(TodeCoinsTags.Items.SUGAR)
                                .addIngredient(TodeCoinsTags.Items.MILK)
                                .addIngredient(TodeCoinsTags.Items.FAT)
                                .addIngredient(TodeCoinsTags.Items.COCOA)
                                .addIngredient(Items.GLOW_LICHEN)
                                .unlockedBy("has_cocoa", has(TodeCoinsTags.Items.COCOA))
                                .build(consumer, new ResourceLocation("todecoins", "cooking/chocolate_coins/"
                                        + ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(and(modLoaded("todecoins")))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get(),
                                        4, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                                .addIngredient(TodeCoinsTags.Items.COCOA_INGREDIENTS)
                                .addIngredient(TodeCoinsTags.Items.SUGAR)
                                .addIngredient(TodeCoinsTags.Items.MILK)
                                .addIngredient(TodeCoinsTags.Items.FAT)
                                .addIngredient(Items.MAGMA_CREAM)
                                .addIngredient(Items.GLOWSTONE_DUST)
                                .unlockedBy("has_cocoa", has(TodeCoinsTags.Items.COCOA))
                                .build(consumer, new ResourceLocation("todecoins", "cooking/chocolate_coins/"
                                        + ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get()))
                );
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addCondition(and(modLoaded("todecoins")))
                .addRecipe(finishedRecipeConsumer ->
                        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get(),
                                        4, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                                .addIngredient(TodeCoinsTags.Items.COCOA_INGREDIENTS)
                                .addIngredient(TodeCoinsTags.Items.SUGAR)
                                .addIngredient(TodeCoinsTags.Items.MILK)
                                .addIngredient(TodeCoinsTags.Items.FAT)
                                .addIngredient(Items.HONEY_BLOCK)
                                .addIngredient(Items.COOKIE)
                                .unlockedBy("has_cocoa", has(TodeCoinsTags.Items.COCOA))
                                .build(consumer, new ResourceLocation("todecoins", "cooking/chocolate_coins/"
                                        + ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get()))
                );
    }
}