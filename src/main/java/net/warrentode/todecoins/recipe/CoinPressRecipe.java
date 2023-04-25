package net.warrentode.todecoins.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.EnumSet;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.warrentode.todecoins.ModLogger;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.screen.coinpressgui.CoinPressRecipeBookTab;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.warrentode.todecoins.TodeCoins.MODID;
import static net.warrentode.todecoins.recipe.CoinPressRecipe.Serializer.ID;

public class CoinPressRecipe implements Recipe<RecipeWrapper> {
    private final ResourceLocation id;
    final String group;
    private final CoinPressRecipeBookTab tab;
    private final ItemStack result;
    private final NonNullList<Ingredient> recipeItems;
    private final float experience;
    private final int stampingTime;
    private final boolean isSimple;
    static int width = 2;
    static int height = 1;
    static final int MAX_WIDTH = 2;
    static final int MAX_HEIGHT = 1;
    
    public CoinPressRecipe(ResourceLocation id, String group, CoinPressRecipeBookTab tab, ItemStack result, NonNullList<Ingredient> recipeItems, float experience, int stampingTime) {
        this.id = id;
        this.group = group;
        this.tab = tab;
        this.result = result;
        this.recipeItems = recipeItems;
        this.isSimple = recipeItems.stream().allMatch(Ingredient::isSimple);
        this.experience = experience;
        this.stampingTime = stampingTime;
        width = MAX_WIDTH;
        height = MAX_HEIGHT;
    }
    
    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }
    
    @SuppressWarnings({"unused", "SameReturnValue"})
    public ResourceLocation getResourceID() {
        return ID;
    }
    
    @Override
    public @NotNull String getGroup() {
        return this.group;
    }
    
    @Nullable
    public CoinPressRecipeBookTab getRecipeBookTab() {
        return this.tab;
    }
    
    public float getExperience() {
        return this.experience;
    }
    
    public int getStampingTime() {
        return this.stampingTime;
    }
    
    @Override
    public boolean matches(@NotNull RecipeWrapper inventory, @NotNull Level level) {
        if (level.isClientSide()) {
            return false;
        }
        StackedContents stackedcontents = new StackedContents();
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int i = 0;
        
        for (int j = 0; j < 2; ++j) {
            ItemStack itemstack = inventory.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                if (isSimple) stackedcontents.accountStack(itemstack, 1);
                else inputs.add(itemstack);
            }
        }
        
        return i == this.recipeItems.size() && (isSimple ? stackedcontents.canCraft(this, null) : RecipeMatcher.findMatches(inputs, this.recipeItems) != null);
    }
    
    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }
    
    @Override
    public @NotNull ItemStack assemble(@NotNull RecipeWrapper inventory) {
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
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }
    
    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }
    
    @Override
    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(ModItems.CURRENCY_STAMP.get());
    }
    
    public static class Type implements RecipeType<CoinPressRecipe> {
        private Type() {}
        
        public static final Type INSTANCE = new Type();
        @SuppressWarnings("unused")
        public static final String ID = "coinpress";
    }
    
    public static class Serializer implements RecipeSerializer<CoinPressRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(MODID, "coinpress");
        private static final int width = MAX_WIDTH;
        private static final int height = MAX_HEIGHT;
        
        @Override
        public @NotNull CoinPressRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");
            NonNullList<Ingredient> inputs = itemsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (inputs.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            }
            else if (inputs.size() > width * height) {
                throw new JsonParseException("Too many ingredients for shapeless recipe. The maximum is " + width * height);
            }
            else {
                final String tabKeyIn = GsonHelper.getAsString(json, "recipe_book_tab", null);
                final CoinPressRecipeBookTab tabIn = CoinPressRecipeBookTab.findByName(tabKeyIn);
                if (tabKeyIn != null && tabIn == null) {
                    ModLogger.warn("Optional field 'recipe_book_tab' does not match any valid tab. If defined, must be one of the following: "
                                           + EnumSet.allOf(CoinPressRecipeBookTab.class));
                }
                ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
                final float experienceIn = GsonHelper.getAsFloat(json, "experience", 0.0F);
                final int stampingTimeIn = GsonHelper.getAsInt(json, "stampingtime", 50);
                return new CoinPressRecipe(id, group, tabIn, itemstack, inputs, experienceIn, stampingTimeIn);
            }
        }
        
        private @NotNull NonNullList<Ingredient> itemsFromJson(@NotNull JsonArray ingredients) {
            NonNullList<Ingredient> inputs = NonNullList.create();
            
            for (int i = 0; i < ingredients.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredients.get(i));
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
            CoinPressRecipeBookTab tabIn = CoinPressRecipeBookTab.findByName(buf.readUtf());
            int i = buf.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(i, Ingredient.EMPTY);
            
            //noinspection Java8ListReplaceAll
            for (int j = 0; j < inputs.size(); ++j) {
                inputs.set(j, Ingredient.fromNetwork(buf));
            }
            
            ItemStack itemstack = buf.readItem();
            float experienceIn = buf.readFloat();
            int stampingTimeIn = buf.readVarInt();
            return new CoinPressRecipe(id, group, tabIn, itemstack, inputs, experienceIn, stampingTimeIn);
        }
        
        public void toNetwork(@NotNull FriendlyByteBuf buf, @NotNull CoinPressRecipe pRecipe) {
            buf.writeVarInt(CoinPressRecipe.width);
            buf.writeVarInt(CoinPressRecipe.height);
            buf.writeUtf(pRecipe.group);
            buf.writeUtf(pRecipe.tab != null ? pRecipe.tab.toString() : "");
            
            for (Ingredient ingredient : pRecipe.recipeItems) {
                ingredient.toNetwork(buf);
            }
            
            buf.writeItem(pRecipe.result);
            buf.writeFloat(pRecipe.experience);
            buf.writeVarInt(pRecipe.stampingTime);
        }
    }
}
