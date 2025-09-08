package com.github.warrentode.todecoins.recipe.recipebook;

import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class CoinPressRecipeBookComponent extends RecipeBookComponent {
    protected static final ResourceLocation RECIPE_TAB_BUTTONS = ResourceLocation.parse(MODID + ":" + "textures/gui/recipe_book_buttons.png");

    @Override
    protected void initFilterButtonTextures() {
        this.filterButton.initTextureValues(0, 0, 28, 18, RECIPE_TAB_BUTTONS);
    }

    @SuppressWarnings("unused")
    public void hide() {
        this.setVisible(false);
    }

    @Override
    @Nonnull
    protected Component getRecipeFilterName() {
        return Component.translatable("container.recipe_book.coin_press");
    }

    @Override
    public void setupGhostRecipe(@NotNull Recipe<?> recipe, @NotNull List<Slot> slots) {
        if (this.minecraft.level == null) {
            return;
        }
        ItemStack resultStack = recipe.getResultItem(this.minecraft.level.registryAccess());
        this.ghostRecipe.setRecipe(recipe);
        NonNullList<Ingredient> nonnulllist = recipe.getIngredients();
        if (slots.get(2).getItem().isEmpty()) {
            this.ghostRecipe.addIngredient(Ingredient.of(resultStack), (slots.get(2)).x, (slots.get(2)).y);
        }

        Iterator<Ingredient> iterator = nonnulllist.iterator();

        for (int i = 0; i < 3; ++i) {
            if (!iterator.hasNext()) {
                return;
            }

            Ingredient ingredient = iterator.next();
            if (!ingredient.isEmpty()) {
                Slot slot1 = slots.get(i);
                this.ghostRecipe.addIngredient(ingredient, slot1.x, slot1.y);
            }
        }
    }
}