package com.github.warrentode.todecoins.recipe.recipebook;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.recipe.CoinPressRecipe;
import com.github.warrentode.todecoins.recipe.TCRecipes;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class CoinPressRecipeCategories {
    public static final Supplier<RecipeBookCategories> COINPRESS_SEARCH = Suppliers.memoize(() -> RecipeBookCategories.create("COINPRESS_SEARCH", new ItemStack(Items.COMPASS)));
    public static final Supplier<RecipeBookCategories> COINPRESS_COINS = Suppliers.memoize(() -> RecipeBookCategories.create("COINPRESS_COINS", new ItemStack(TCItems.COPPER_COIN.get())));
    public static final Supplier<RecipeBookCategories> COINPRESS_BANK_NOTES = Suppliers.memoize(() -> RecipeBookCategories.create("COINPRESS_BANK_NOTES", new ItemStack(TCItems.EMERALD_BANK_NOTE.get())));
    public static final Supplier<RecipeBookCategories> COINPRESS_MISC = Suppliers.memoize(() -> RecipeBookCategories.create("COINPRESS_MISC", new ItemStack(TCItems.CURRENCY_STAMP.get()), new ItemStack(TCItems.NETHER_CURRENCY_STAMP.get())));

    public static void init(@NotNull RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(TCRecipes.COINPRESS_BOOK, ImmutableList.of(COINPRESS_SEARCH.get(), COINPRESS_COINS.get(), COINPRESS_BANK_NOTES.get(), COINPRESS_MISC.get()));
        event.registerAggregateCategory(COINPRESS_SEARCH.get(), ImmutableList.of(COINPRESS_COINS.get(), COINPRESS_BANK_NOTES.get(), COINPRESS_MISC.get()));
        event.registerRecipeCategoryFinder(TCRecipes.RECIPE_TYPE_COINPRESS.get(), recipe ->
        {
            if (recipe instanceof CoinPressRecipe coinPressRecipe) {
                CoinPressRecipeBookTab tab = coinPressRecipe.getRecipeBookTab();
                if (tab != null) {
                    return switch (tab) {
                        case COINS -> COINPRESS_COINS.get();
                        case BANK_NOTES -> COINPRESS_BANK_NOTES.get();
                        case MISC -> COINPRESS_MISC.get();
                    };
                }
            }

            // If no tab is specified in recipe, this fallback organizes them instead
            return COINPRESS_MISC.get();
        });
    }
}