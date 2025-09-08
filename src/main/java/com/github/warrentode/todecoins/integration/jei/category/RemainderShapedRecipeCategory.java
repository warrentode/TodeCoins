package com.github.warrentode.todecoins.integration.jei.category;

import com.github.warrentode.todecoins.integration.jei.JEIModPlugin;
import com.github.warrentode.todecoins.recipe.RemainderShapedRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.core.RegistryAccess;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class RemainderShapedRecipeCategory implements IRecipeCategory<RemainderShapedRecipe> {
    public static final ResourceLocation UID = ResourceLocation.parse(MODID+ ":remainder_shaped");
    private static final ResourceLocation TEXTURE = ResourceLocation.parse("minecraft:textures/gui/container/crafting_table.png");

    private final IDrawable background;
    private final IDrawable icon;

    public RemainderShapedRecipeCategory(@NotNull IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 29, 16, 128, 54); // matches vanilla crafting grid
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(net.minecraft.world.level.block.Blocks.CRAFTING_TABLE));
    }

    @Override
    public @NotNull RecipeType<RemainderShapedRecipe> getRecipeType() {
        return JEIModPlugin.REMAINDER_SHAPED_TYPE;
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
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull RemainderShapedRecipe recipe, @NotNull IFocusGroup group) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;
        if (level == null) throw new NullPointerException("level must not be null");
        RegistryAccess registryAccess = level.registryAccess();

        // Place inputs
        for (int y = 0; y < recipe.getHeight(); y++) {
            for (int x = 0; x < recipe.getWidth(); x++) {
                int index = x + y * recipe.getWidth();
                builder.addSlot(RecipeIngredientRole.INPUT, 5 + x * 18, 5 + y * 18)
                        .addIngredients(recipe.getIngredients().get(index));
            }
        }

        // Output
        builder.addSlot(RecipeIngredientRole.OUTPUT, 95, 23)
                .addItemStack(recipe.getResultItem(registryAccess));
    }
}