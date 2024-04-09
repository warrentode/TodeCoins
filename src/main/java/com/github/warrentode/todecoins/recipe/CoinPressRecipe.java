package com.github.warrentode.todecoins.recipe;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.recipe.recipebook.CoinPressRecipeBookTab;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.EnumSet;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class CoinPressRecipe implements Recipe<RecipeWrapper> {
    public static final int INPUT_SLOTS = 2;
    private final ResourceLocation id;
    private final String group;
    private final CoinPressRecipeBookTab tab;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;
    private final float experience;
    private final int stampingTime;

    public CoinPressRecipe(ResourceLocation id, String group, @Nullable CoinPressRecipeBookTab tab, NonNullList<Ingredient> ingredients, ItemStack result, float experience, int stampingTime) {
        this.id = id;
        this.group = group;
        this.tab = tab;
        this.ingredients = ingredients;
        this.result = result;
        this.experience = experience;
        this.stampingTime = stampingTime;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }

    @Override
    public @NotNull String getGroup() {
        return this.group;
    }

    @Nullable
    public CoinPressRecipeBookTab getRecipeBookTab() {
        return this.tab;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return this.result;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull RecipeWrapper inventory) {
        return this.result.copy();
    }

    public float getExperience() {
        return this.experience;
    }

    public int getStampingTime() {
        return this.stampingTime;
    }

    @Override
    public boolean matches(@NotNull RecipeWrapper inventory, @NotNull Level level) {
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int i = 0;

        for (int j = 0; j < INPUT_SLOTS; ++j) {
            ItemStack stack = inventory.getItem(j);
            if (!stack.isEmpty()) {
                ++i;
                inputs.add(stack);
            }
        }
        return i == this.ingredients.size() && net.minecraftforge.common.util.RecipeMatcher.findMatches(inputs, this.ingredients) != null;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredients.size();
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.COINPRESSBLOCK.get());
    }

    public static class Type implements RecipeType<CoinPressRecipe> {
        public static final Type INSTANCE = new Type();
        @SuppressWarnings("unused")
        public static final String ID = "glassblowing";

        private Type() {
        }
    }

    public static class Serializer implements RecipeSerializer<CoinPressRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        @SuppressWarnings("unused")
        public static final ResourceLocation ID = new ResourceLocation(MODID, "glassblowing");

        public Serializer() {
        }

        private static NonNullList<Ingredient> readIngredients(@NotNull JsonArray json) {
            NonNullList<Ingredient> inputs = NonNullList.create();

            for (int i = 0; i < json.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(json.get(i));
                if (!ingredient.isEmpty()) {
                    inputs.add(ingredient);
                }
            }

            return inputs;
        }

        @Override
        public @NotNull CoinPressRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject json) {
            final String group = GsonHelper.getAsString(json, "group", "");
            final NonNullList<Ingredient> inputs = readIngredients(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (inputs.isEmpty()) {
                throw new JsonParseException("No ingredients for coinpress recipe");
            }
            else if (inputs.size() > CoinPressRecipe.INPUT_SLOTS) {
                throw new JsonParseException("Too many ingredients for coinpress recipe! The max is " + CoinPressRecipe.INPUT_SLOTS);
            }
            else {
                final String tabKey = GsonHelper.getAsString(json, "recipe_book_tab", null);
                final CoinPressRecipeBookTab tab = CoinPressRecipeBookTab.findByName(tabKey);
                if (tabKey != null && tab == null) {
                    TodeCoins.LOGGER.warn("Optional field 'recipe_book_tab' does not match any valid tab. If defined, must be one of the following: {}", EnumSet.allOf(CoinPressRecipeBookTab.class));
                }
                ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
                final float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
                final int stampingTime = GsonHelper.getAsInt(json, "stampingTime", 50);
                return new CoinPressRecipe(id, group, tab, inputs, result, experience, stampingTime);
            }
        }

        @Nullable
        @Override
        public CoinPressRecipe fromNetwork(@NotNull ResourceLocation id, @NotNull FriendlyByteBuf buf) {
            String group = buf.readUtf();
            CoinPressRecipeBookTab tab = CoinPressRecipeBookTab.findByName(buf.readUtf());
            int i = buf.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(i, Ingredient.EMPTY);

            //noinspection Java8ListReplaceAll
            for (int j = 0; j < inputs.size(); ++j) {
                inputs.set(j, Ingredient.fromNetwork(buf));
            }

            ItemStack result = buf.readItem();
            float experience = buf.readFloat();
            int stampingTime = buf.readVarInt();
            return new CoinPressRecipe(id, group, tab, inputs, result, experience, stampingTime);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buf, @NotNull CoinPressRecipe recipe) {
            buf.writeUtf(recipe.group);
            buf.writeUtf(recipe.tab != null ? recipe.tab.toString() : "");
            buf.writeVarInt(recipe.ingredients.size());

            for (Ingredient ingredient : recipe.ingredients) {
                ingredient.toNetwork(buf);
            }

            buf.writeItem(recipe.result);
            buf.writeFloat(recipe.experience);
            buf.writeVarInt(recipe.stampingTime);
        }
    }
}