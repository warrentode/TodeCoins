package com.github.warrentode.todecoins.recipe;

import com.github.warrentode.todecoins.util.tags.TCItemTags;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.common.crafting.CraftingHelper;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class SpawnEggShapelessRecipe extends ShapelessRecipe {
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;
    private final ResourceLocation id;
    private final String group;
    final CraftingBookCategory category;
    private final boolean showNotification;

    public SpawnEggShapelessRecipe(ResourceLocation id, String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients, boolean showNotification) {
        super(id, group, category, result, ingredients);
        this.id = id;
        this.group = group;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
        this.showNotification = showNotification;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }

    @Override
    public @NotNull String getGroup() {
        return this.group;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess registryAccess) {
        return this.result;
    }

    @Override
    public boolean showNotification() {
        return this.showNotification;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingContainer container, @NotNull RegistryAccess registryAccess) {
        ItemStack result = getResultItem(registryAccess).copy(); // copy to avoid modifying original
        if (result.is(TCItemTags.NO_AI_EGGS)) {
            result.getOrCreateTagElement("EntityTag").putBoolean("NoAI", true);
        }
        return result;
    }

    public static class Type implements RecipeType<SpawnEggShapelessRecipe> {
        public static final SpawnEggShapelessRecipe.Type INSTANCE = new SpawnEggShapelessRecipe.Type();
        @SuppressWarnings("unused")
        public static final String ID = "spawn_egg_shapeless";

        private Type() {
        }
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return SpawnEggShapelessRecipe.Serializer.INSTANCE;
    }

    // --- Serializer ---
    public static class Serializer implements RecipeSerializer<SpawnEggShapelessRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        @SuppressWarnings("unused")
        public static final ResourceLocation ID = ResourceLocation.parse(MODID + "spawn_egg_shapeless");

        @Override
        public @NotNull SpawnEggShapelessRecipe fromJson(@NotNull ResourceLocation recipeID, @NotNull JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group", "");
            CraftingBookCategory recipeCategory = CraftingBookCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category", null), CraftingBookCategory.MISC);
            boolean flag = GsonHelper.getAsBoolean(jsonObject, "show_notification", true);
            NonNullList<Ingredient> ingredients = NonNullList.create();
            for (JsonElement element : GsonHelper.getAsJsonArray(jsonObject, "ingredients")) {
                ingredients.add(Ingredient.fromJson(element));
            }
            ItemStack result = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(jsonObject, "result"), true, true);
            return new SpawnEggShapelessRecipe(recipeID, group, recipeCategory, result, ingredients, flag);
        }

        @Override
        public SpawnEggShapelessRecipe fromNetwork(@NotNull ResourceLocation recipeID, @NotNull FriendlyByteBuf byteBuf) {
            String group = byteBuf.readUtf();
            CraftingBookCategory recipeCategory = byteBuf.readEnum(CraftingBookCategory.class);
            boolean flag = byteBuf.readBoolean();
            int size = byteBuf.readVarInt();
            NonNullList<Ingredient> ingredients = NonNullList.withSize(size, Ingredient.EMPTY);
            for (int i = 0; i < size; i++) {
                ingredients.set(i, Ingredient.fromNetwork(byteBuf));
            }
            ItemStack result = byteBuf.readItem();
            return new SpawnEggShapelessRecipe(recipeID, group, recipeCategory, result, ingredients, flag);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf byteBuf, @NotNull SpawnEggShapelessRecipe recipe) {
            byteBuf.writeUtf(recipe.group);
            byteBuf.writeEnum(recipe.category);
            byteBuf.writeBoolean(recipe.showNotification);
            byteBuf.writeVarInt(recipe.ingredients.size());
            for (Ingredient ingredient : recipe.ingredients) {
                ingredient.toNetwork(byteBuf);
            }
            byteBuf.writeItem(recipe.result);
        }
    }
}