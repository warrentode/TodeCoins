package net.warrentode.todecoins.screen.coinpressgui;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import java.util.function.Supplier;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.item.custom.CoinItem;
import net.warrentode.todecoins.recipe.CoinPressRecipe;

public class CoinPressRecipeCategories {
    public static final Supplier<RecipeBookCategories> SEARCH = Suppliers.memoize(() -> RecipeBookCategories.create("SEARCH",
            new ItemStack(Items.RECOVERY_COMPASS)));
    public static final Supplier<RecipeBookCategories> COINS = Suppliers.memoize(() -> RecipeBookCategories.create("COINS",
            new ItemStack(ModItems.COPPER_COIN.get())));
    public static final Supplier<RecipeBookCategories> BANK_NOTES = Suppliers.memoize(() -> RecipeBookCategories.create("COOKING_DRINKS",
            new ItemStack(ModItems.EMERALD_BANK_NOTE.get())));

    public static void init(RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(TodeCoins.RECIPE_TYPE_COINPRESS, ImmutableList.of(SEARCH.get(), COINS.get(), BANK_NOTES.get()));
        event.registerAggregateCategory(SEARCH.get(), ImmutableList.of(COINS.get(), BANK_NOTES.get()));
        event.registerRecipeCategoryFinder(CoinPressRecipe.Type.INSTANCE, recipe ->
        {
            if (recipe instanceof CoinPressRecipe coinPressRecipe) {
                CoinPressRecipeBookTab tab = coinPressRecipe.getRecipeBookTab();
                if (tab != null) {
                    return switch (tab) {
                        case COINS -> COINS.get();
                        case BANK_NOTES -> BANK_NOTES.get();
                    };
                }
            }

            // Default for Recipe Book
            if (recipe.getResultItem().getItem() instanceof CoinItem) {
                return COINS.get();
            }
            return COINS.get();
        });
    }
}