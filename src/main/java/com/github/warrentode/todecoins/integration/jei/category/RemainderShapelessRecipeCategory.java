package com.github.warrentode.todecoins.integration.jei.category;

import com.github.warrentode.todecoins.integration.jei.JEIModPlugin;
import com.github.warrentode.todecoins.recipe.RemainderShapelessRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import mezz.jei.api.recipe.RecipeType;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class RemainderShapelessRecipeCategory implements IRecipeCategory<RemainderShapelessRecipe> {
    public static final ResourceLocation UID = ResourceLocation.parse(MODID+ ":remainder_shapeless");
    private static final ResourceLocation TEXTURE = ResourceLocation.parse("minecraft:textures/gui/container/crafting_table.png");

    private final IDrawable background;
    private final IDrawable icon;

    public RemainderShapelessRecipeCategory(@NotNull IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 29, 16, 128, 54);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(net.minecraft.world.level.block.Blocks.CRAFTING_TABLE));
    }

    @Override
    public @NotNull RecipeType<RemainderShapelessRecipe> getRecipeType() {
        return JEIModPlugin.REMAINDER_SHAPELESS_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("container.crafting");
    }

    @Override
    @SuppressWarnings("removal")
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull RemainderShapelessRecipe recipe, @NotNull IFocusGroup group) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;
        if (level == null) throw new NullPointerException("level must not be null");
        RegistryAccess registryAccess = level.registryAccess();

        int x = 5, y = 5;
        for (var ingredient : recipe.getIngredients()) {
            builder.addSlot(RecipeIngredientRole.INPUT, x, y).addIngredients(ingredient);
            x += 18;
            if (x > 50) { x = 5; y += 18; } // simple wrap
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 95, 23)
                .addItemStack(recipe.getResultItem(registryAccess));
    }
}