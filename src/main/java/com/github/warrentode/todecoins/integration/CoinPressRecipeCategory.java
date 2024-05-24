package com.github.warrentode.todecoins.integration;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.recipe.CoinPressRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class CoinPressRecipeCategory implements IRecipeCategory<CoinPressRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(MODID, "coinpress");
    public static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/gui/coin_press_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CoinPressRecipeCategory(@NotNull IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 29, 4, 137, 68);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COINPRESSBLOCK.get()));
    }

    @Override
    public @NotNull RecipeType<CoinPressRecipe> getRecipeType() {
        return JEIModPlugin.COINPRESS_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("container.coin_press_block_gui");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull CoinPressRecipe recipe, @NotNull IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 5, 43).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 41, 43).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 113, 43).addItemStack(recipe.getResultItem());
    }
}