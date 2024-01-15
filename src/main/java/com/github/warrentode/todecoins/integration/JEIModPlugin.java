package com.github.warrentode.todecoins.integration;

import com.github.warrentode.todecoins.recipe.CoinPressRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@JeiPlugin
public class JEIModPlugin implements IModPlugin {
    public static RecipeType<CoinPressRecipe> COINPRESS_TYPE =
            new RecipeType<>(CoinPressRecipeCategory.UID, CoinPressRecipe.class);

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CoinPressRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        assert Minecraft.getInstance().level != null;
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level.getRecipeManager());

        List<CoinPressRecipe> recipes = recipeManager.getAllRecipesFor(CoinPressRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(COINPRESS_TYPE.getUid(), CoinPressRecipe.class), recipes);
        registration.getJeiHelpers().getIngredientManager().getAllItemStacks();
    }
}