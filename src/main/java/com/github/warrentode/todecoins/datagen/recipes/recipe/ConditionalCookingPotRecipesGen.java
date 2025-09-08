package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

import java.util.function.Consumer;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.datagen.RecipesGen.setLocation;

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
        chocolateCoinCookingPotTemplate(consumer, TCItems.CHOCOLATE_COIN_CRIMSON_SPORE.get(), 4, Items.CRIMSON_FUNGUS, Items.ROTTEN_FLESH, null, null);
        chocolateCoinCookingPotTemplate(consumer, TCItems.CHOCOLATE_COIN_WARPED_SPICE.get(), 4, Items.WARPED_FUNGUS, Items.PUFFERFISH, null, null);
        chocolateCoinCookingPotTemplate(consumer, TCItems.CHOCOLATE_COIN_MILK_BONE.get(), 4, Items.BONE_MEAL, Items.COBWEB, null, null);
        chocolateCoinCookingPotTemplate(consumer, TCItems.CHOCOLATE_COIN_ULTIMATE_DARK.get(), 4, Items.EMERALD, Items.INK_SAC, null, null);
        chocolateCoinCookingPotTemplate(consumer, TCItems.CHOCOLATE_COIN_FUEGO_FUDGE.get(), 4, Items.MAGMA_CREAM, Items.GLOWSTONE_DUST, null, null);
        chocolateCoinCookingPotTemplate(consumer, TCItems.CHOCOLATE_COIN_CARMEL_CRISP.get(), 4, Items.HONEY_BLOCK, Items.COOKIE, null, null);
        chocolateCoinCookingPotTemplate(consumer, TCItems.CHOCOLATE_COIN_BUBBLY_BERRY.get(), 4, null,Items.PHANTOM_MEMBRANE, TCItemTags.BERRIES, null);
        chocolateCoinCookingPotTemplate(consumer, TCItems.CHOCOLATE_COIN_FESTIVE_FUDGE.get(), 4, null, Items.GLOW_LICHEN, TCItemTags.COCOA_INGREDIENTS, null);
        chocolateCoinCookingPotTemplate(consumer, TCItems.CHOCOLATE_COIN_VELVETY_CLOVER.get(), 2, null,null, TCItemTags.CLOVER, TCItemTags.CLOVER);
    }

    private void chocolateCoinCookingPotTemplate(Consumer<FinishedRecipe> consumer, Item result, int resultAmount, @Nullable Item flavorA, @Nullable Item flavorB, @Nullable TagKey<Item> flavorTagA, @Nullable TagKey<Item> flavorTagB) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded("farmersdelight"))
                .addRecipe(finishedRecipeConsumer -> {
                    CookingPotRecipeBuilder builder = CookingPotRecipeBuilder
                            .cookingPotRecipe(result, resultAmount, CookingRecipes.NORMAL_COOKING, CookingRecipes.SMALL_EXP)
                            .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                            .addIngredient(TCItemTags.COCOA_INGREDIENTS)
                            .addIngredient(TCItemTags.SWEETENER)
                            .addIngredient(TCItemTags.MILK)
                            .addIngredient(TCItemTags.FAT);

                    int ingredientCount = 4;

                    if (flavorA != null) {
                        builder.addIngredient(flavorA);
                        ingredientCount++;
                    }
                    else if (flavorTagA != null) {
                        builder.addIngredient(flavorTagA);
                        ingredientCount++;
                    }

                    if (flavorB != null) {
                        builder.addIngredient(flavorB);
                        ingredientCount++;
                    }
                    else if (flavorTagB != null) {
                        builder.addIngredient(flavorTagB);
                        ingredientCount++;
                    }

                    // enforce exactly 6 ingredients
                    if (ingredientCount != 6) {
                        throw new IllegalArgumentException("Chocolate coin recipe for " + result + " must have exactly 6 ingredients (found " + ingredientCount + ")");
                    }

                    builder.unlockedBy("has_cocoa", has(TCItemTags.COCOA_INGREDIENTS))
                            .build(consumer, setLocation(MODID, "cooking/chocolate_coins/" + result));
                });
    }
}