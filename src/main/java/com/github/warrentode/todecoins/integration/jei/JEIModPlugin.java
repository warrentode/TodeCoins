package com.github.warrentode.todecoins.integration.jei;

import com.github.warrentode.todecoins.integration.jei.category.CoinPressRecipeCategory;
import com.github.warrentode.todecoins.integration.jei.category.RemainderShapedRecipeCategory;
import com.github.warrentode.todecoins.integration.jei.category.RemainderShapelessRecipeCategory;
import com.github.warrentode.todecoins.integration.jei.category.SpawnEggShapelessRecipeCategory;
import com.github.warrentode.todecoins.recipe.CoinPressRecipe;
import com.github.warrentode.todecoins.recipe.RemainderShapedRecipe;
import com.github.warrentode.todecoins.recipe.RemainderShapelessRecipe;
import com.github.warrentode.todecoins.recipe.SpawnEggShapelessRecipe;
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
    public static final RecipeType<CoinPressRecipe> COINPRESS_TYPE =
            new RecipeType<>(CoinPressRecipeCategory.UID, CoinPressRecipe.class);
    public static final RecipeType<RemainderShapedRecipe> REMAINDER_SHAPED_TYPE =
            new RecipeType<>(RemainderShapedRecipeCategory.UID, RemainderShapedRecipe.class);
    public static final RecipeType<RemainderShapelessRecipe> REMAINDER_SHAPELESS_TYPE =
            new RecipeType<>(RemainderShapelessRecipeCategory.UID, RemainderShapelessRecipe.class);
    public static final RecipeType<SpawnEggShapelessRecipe> SPAWN_EGG_SHAPELESS_TYPE =
            new RecipeType<>(SpawnEggShapelessRecipeCategory.UID, SpawnEggShapelessRecipe.class);

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ResourceLocation.parse(MODID+ ":jei_plugin");
    }

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CoinPressRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new RemainderShapedRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new RemainderShapelessRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SpawnEggShapelessRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        assert Minecraft.getInstance().level != null;
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level.getRecipeManager());

        List<CoinPressRecipe> coinPressRecipes = recipeManager.getAllRecipesFor(CoinPressRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(COINPRESS_TYPE.getUid(), CoinPressRecipe.class), coinPressRecipes);

        List<RemainderShapedRecipe> remainderShapedRecipes = recipeManager.getAllRecipesFor(RemainderShapedRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(REMAINDER_SHAPED_TYPE.getUid(), RemainderShapedRecipe.class), remainderShapedRecipes);

        List<RemainderShapelessRecipe> remainderShapelessRecipes = recipeManager.getAllRecipesFor(RemainderShapelessRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(REMAINDER_SHAPELESS_TYPE.getUid(), RemainderShapelessRecipe.class), remainderShapelessRecipes);

        List<SpawnEggShapelessRecipe> spawnEggShapelessRecipes = recipeManager.getAllRecipesFor(SpawnEggShapelessRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(SPAWN_EGG_SHAPELESS_TYPE.getUid(), SpawnEggShapelessRecipe.class), spawnEggShapelessRecipes);

        registration.getJeiHelpers().getIngredientManager().getAllItemStacks();
    }
}