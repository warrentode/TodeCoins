package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

import java.util.function.Consumer;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ConditionalCookingPotRecipesGen extends RecipeProvider implements IConditionBuilder {
    public ConditionalCookingPotRecipesGen(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        register(consumer);
    }

    public void register(Consumer<FinishedRecipe> consumer) {
        cookingPotRecipes(consumer);
    }

    private void cookingPotRecipes(Consumer<FinishedRecipe> consumer) {
        chocolateCoinCookingPotTemplate_AB(consumer, TCItems.CHOCOLATE_COIN_CRIMSON_SPORE.get(), 4, Items.CRIMSON_FUNGUS, Items.ROTTEN_FLESH);
        chocolateCoinCookingPotTemplate_AB(consumer, TCItems.CHOCOLATE_COIN_WARPED_SPICE.get(), 4, Items.WARPED_FUNGUS, Items.PUFFERFISH);
        chocolateCoinCookingPotTemplate_AB(consumer, TCItems.CHOCOLATE_COIN_MILK_BONE.get(), 4, Items.BONE_MEAL, Items.COBWEB);
        chocolateCoinCookingPotTemplate_AB(consumer, TCItems.CHOCOLATE_COIN_ULTIMATE_DARK.get(), 4, Items.EMERALD, Items.INK_SAC);
        chocolateCoinCookingPotTemplate_AB(consumer, TCItems.CHOCOLATE_COIN_FUEGO_FUDGE.get(), 4, Items.MAGMA_CREAM, Items.GLOWSTONE_DUST);
        chocolateCoinCookingPotTemplate_AB(consumer, TCItems.CHOCOLATE_COIN_CARMEL_CRISP.get(), 4, Items.HONEY_BLOCK, Items.COOKIE);
        chocolateCoinCookingPotTemplate_AtB(consumer, TCItems.CHOCOLATE_COIN_BUBBLY_BERRY.get(), 4, Items.PHANTOM_MEMBRANE, TCItemTags.BERRIES);
        chocolateCoinCookingPotTemplate_AtB(consumer, TCItems.CHOCOLATE_COIN_FESTIVE_FUDGE.get(), 4, Items.GLOW_LICHEN, TCItemTags.COCOA_INGREDIENTS);
        chocolateCoinCookingPotTemplate_tAtB(consumer, TCItems.CHOCOLATE_COIN_VELVETY_CLOVER.get(), 2, TCItemTags.CLOVER, TCItemTags.CLOVER);
    }

    @SuppressWarnings("SameParameterValue")
    private void chocolateCoinCookingPotTemplate_tAtB(Consumer<FinishedRecipe> consumer, Item result, int resultAmount, TagKey<Item> flavorA, TagKey<Item> flavorB) {
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(result, resultAmount, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                        .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                        .addIngredient(TCItemTags.COCOA_INGREDIENTS)
                        .addIngredient(TCItemTags.SWEETENER)
                        .addIngredient(TCItemTags.MILK)
                        .addIngredient(TCItemTags.FAT)
                        .addIngredient(flavorA)
                        .addIngredient(flavorB)
                        .unlockedBy("has_cocoa", has(TCItemTags.COCOA_INGREDIENTS)),
                "cooking/chocolate_coins/" + result, consumer, modLoaded("farmersdelight"));
    }

    @SuppressWarnings("SameParameterValue")
    private void chocolateCoinCookingPotTemplate_AtB(Consumer<FinishedRecipe> consumer, Item result, int resultAmount, Item flavorA, TagKey<Item> flavorB) {
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(result, resultAmount, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                        .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                        .addIngredient(TCItemTags.COCOA_INGREDIENTS)
                        .addIngredient(TCItemTags.SWEETENER)
                        .addIngredient(TCItemTags.MILK)
                        .addIngredient(TCItemTags.FAT)
                        .addIngredient(flavorA)
                        .addIngredient(flavorB)
                        .unlockedBy("has_cocoa", has(TCItemTags.COCOA_INGREDIENTS)),
                "cooking/chocolate_coins/" + result, consumer, modLoaded("farmersdelight"));
    }

    @SuppressWarnings("SameParameterValue")
    private void chocolateCoinCookingPotTemplate_AB(Consumer<FinishedRecipe> consumer, Item result, int resultAmount, Item flavorA, Item flavorB) {
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(result, resultAmount, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                        .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                        .addIngredient(TCItemTags.COCOA_INGREDIENTS)
                        .addIngredient(TCItemTags.SWEETENER)
                        .addIngredient(TCItemTags.MILK)
                        .addIngredient(TCItemTags.FAT)
                        .addIngredient(flavorA)
                        .addIngredient(flavorB)
                        .unlockedBy("has_cocoa", has(TCItemTags.COCOA_INGREDIENTS)),
                "cooking/chocolate_coins/" + result, consumer, modLoaded("farmersdelight"));
    }

    private void wrap(CookingPotRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, MODID, name, consumer, conds);
    }

    @SuppressWarnings("SameParameterValue")
    private void wrap(@NotNull CookingPotRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition @NotNull ... conds) {
        ResourceLocation loc = ResourceLocation.parse(modid + ":" + name);
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.build(f -> recipe[0] = f, loc);
        ConditionalRecipe.Builder cond = ConditionalRecipe.builder();
        if (conds.length >= 1) {
            for (ICondition currentCond : conds) {
                cond.addCondition(currentCond);
            }
        }
        cond.addRecipe(recipe[0])
                .generateAdvancement()
                .build(consumer, loc);
    }
}