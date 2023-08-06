package net.warrentode.todecoins.datagen.recipes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.warrentode.todecoins.datagen.recipes.recipe.CoinPressRecipesGen;
import net.warrentode.todecoins.datagen.recipes.recipe.CraftingRecipesGen;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RecipesGen extends RecipeProvider {
    public RecipesGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        CraftingRecipesGen.register(consumer);
        CoinPressRecipesGen.register(consumer);
    }
}