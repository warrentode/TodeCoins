package net.warrentode.todecoins.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.RecipeMatcher;
import net.warrentode.todecoins.TodeCoins;
import org.jetbrains.annotations.NotNull;

public class CoinPressRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    final String group;
    private final ItemStack result;
    private final NonNullList<Ingredient> recipeItems;
    private final boolean isSimple;
    static int width = 2;
    static int height = 1;
    static final int MAX_WIDTH = 2;
    static final int MAX_HEIGHT = 1;

    public CoinPressRecipe(ResourceLocation id, String group, ItemStack result, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.group = group;
        this.result = result;
        this.recipeItems = recipeItems;
        this.isSimple = recipeItems.stream().allMatch(Ingredient::isSimple);
        width = MAX_WIDTH;
        height = MAX_HEIGHT;
    }

    @Override
    public boolean matches(@NotNull SimpleContainer inventory, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }
        StackedContents stackedcontents = new StackedContents();
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int i = 0;

        for(int j = 0; j < 2; ++j) {
            ItemStack itemstack = inventory.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                if (isSimple)
                    stackedcontents.accountStack(itemstack, 1);
                else inputs.add(itemstack);
            }
        }

        return i == this.recipeItems.size() && (isSimple ? stackedcontents.canCraft(this, null) : RecipeMatcher.findMatches(inputs,  this.recipeItems) != null);
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull SimpleContainer inventory) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return width * height >= this.recipeItems.size();
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return result.copy();
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CoinPressRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        @SuppressWarnings("unused")
        public static final String ID = "coinpress";
    }

    public static class Serializer implements RecipeSerializer<CoinPressRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        @SuppressWarnings("unused")
        public static final ResourceLocation ID =
                new ResourceLocation(TodeCoins.MOD_ID, "coinpress");
        private static final int width = MAX_WIDTH;
        private static final int height = MAX_HEIGHT;

        @Override
        public @NotNull CoinPressRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject pSerializedRecipe) {
            String group = GsonHelper.getAsString(pSerializedRecipe, "group", "");
            NonNullList<Ingredient> inputs = itemsFromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients"));
            if (inputs.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            } else if (inputs.size() > width * height) {
                throw new JsonParseException("Too many ingredients for shapeless recipe. The maximum is " + width * height);
            } else {
                ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));
                return new CoinPressRecipe(id, group, itemstack, inputs);
            }
        }

        private @NotNull NonNullList<Ingredient> itemsFromJson(@NotNull JsonArray ingredients) {
            NonNullList<Ingredient> inputs = NonNullList.create();

            for(int i = 0; i < ingredients.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredients.get(i));
                //noinspection ConstantValue,PointlessBooleanExpression
                if (true || !ingredient.isEmpty()) {
                    // FORGE: Skip checking if an ingredient is empty during shapeless recipe deserialization
                    // to prevent complex ingredients from caching tags too early.
                    // Can not be done using a config value due to sync issues.
                    inputs.add(ingredient);
                }
            }

            return inputs;
        }

        public CoinPressRecipe fromNetwork(@NotNull ResourceLocation id, @NotNull FriendlyByteBuf buf) {
            String group = buf.readUtf();
            int i = buf.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(i, Ingredient.EMPTY);

            //noinspection Java8ListReplaceAll
            for(int j = 0; j < inputs.size(); ++j) {
                inputs.set(j, Ingredient.fromNetwork(buf));
            }

            ItemStack itemstack = buf.readItem();
            return new CoinPressRecipe(id, group, itemstack, inputs);
        }

        public void toNetwork(@NotNull FriendlyByteBuf buf, @NotNull CoinPressRecipe pRecipe) {
            buf.writeVarInt(CoinPressRecipe.width);
            buf.writeVarInt(CoinPressRecipe.height);
            buf.writeUtf(pRecipe.group);

            for (Ingredient ingredient : pRecipe.recipeItems) {
                ingredient.toNetwork(buf);
            }

            buf.writeItem(pRecipe.result);
        }
    }
}
