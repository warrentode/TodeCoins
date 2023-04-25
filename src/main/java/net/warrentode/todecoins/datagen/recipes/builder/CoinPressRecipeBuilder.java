package net.warrentode.todecoins.datagen.recipes.builder;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.recipe.CoinPressRecipe;
import net.warrentode.todecoins.screen.coinpressgui.CoinPressRecipeBookTab;
import org.jetbrains.annotations.Nullable;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CoinPressRecipeBuilder {
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Item result;
    private final int count;
    private final int stampingTime;
    private final float experience;
    private CoinPressRecipeBookTab tab;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    
    public CoinPressRecipeBuilder(Item resultIn, int count, int stampingTime, float experience) {
        this.result = resultIn.asItem();
        this.count = count;
        this.stampingTime = stampingTime;
        this.experience = experience;
    }
    
    public static CoinPressRecipeBuilder coinPressRecipe(Item result, int count, int stampingTime, float experience) {
        return new CoinPressRecipeBuilder(result, count, stampingTime, experience);
    }
    
    public CoinPressRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return addIngredient(Ingredient.of(tagIn));
    }
    
    public CoinPressRecipeBuilder addIngredient(ItemLike itemIn) {
        return addIngredient(itemIn, 1);
    }
    
    private CoinPressRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            addIngredient(Ingredient.of(itemIn));
        }
        return this;
    }
    
    public CoinPressRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return addIngredient(ingredientIn, 1);
    }
    
    public CoinPressRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            ingredients.add(ingredientIn);
        }
        return this;
    }
    
    public CoinPressRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }
    
    @SuppressWarnings("unused")
    public CoinPressRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }
    @SuppressWarnings("unused")
    public CoinPressRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
        advancement.addCriterion("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
        return this;
    }
    
    public CoinPressRecipeBuilder setRecipeBookTab(CoinPressRecipeBookTab tab) {
        this.tab = tab;
        return this;
    }
    
    @SuppressWarnings("unused")
    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
        if (location != null) {
            build(consumerIn, TodeCoins.MODID + ":coinpress/" + location.getPath());
        }
    }
    
    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Coinpress Recipe " + save + " should remove its 'save' argument");
        }
        else {
            build(consumerIn, new ResourceLocation(save));
        }
    }
    
    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        if (!advancement.getCriteria().isEmpty()) {
            advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                    .rewards(AdvancementRewards.Builder.recipe(id))
                    .requirements(RequirementsStrategy.OR);
            ResourceLocation advancementId = null;
            if (result.getItemCategory() != null) {
                advancementId = new ResourceLocation(id.getNamespace(), "recipes/" + result.getItemCategory().getRecipeFolderName() + "/" + id.getPath());
            }
            if (advancementId != null) {
                consumerIn.accept(new Result(id, result, count, ingredients, stampingTime, experience, tab, advancement, advancementId));
            }
        } else {
            consumerIn.accept(new CoinPressRecipeBuilder.Result(id, result, count, ingredients, stampingTime, experience, tab));
        }
    }
    
    public static class Result implements FinishedRecipe {
        public ResourceLocation id;
        public List<Ingredient> ingredients;
        public Item result;
        public int count;
        public int stampingTime;
        public float experience;
        public CoinPressRecipeBookTab tab;
        public Advancement.Builder advancement;
        public ResourceLocation advancementId;
        
        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int stampingTimeIn,
                float experienceIn, CoinPressRecipeBookTab tabIn, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = idIn;
            this.tab = tabIn;
            this.ingredients = ingredientsIn;
            this.result = resultIn;
            this.count = countIn;
            this.stampingTime = stampingTimeIn;
            this.experience = experienceIn;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }
        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int stampingTimeIn,
                float experienceIn, CoinPressRecipeBookTab tabIn) {
            //noinspection DataFlowIssue
            this(idIn, resultIn, countIn, ingredientsIn, stampingTimeIn, experienceIn, tabIn, null, null);
        }
        
        @Override
        public void serializeRecipeData(JsonObject json) {
            if (tab != null) {
                json.addProperty("recipe_book_tab", tab.toString());
            }
            
            JsonArray arrayIngredients = new JsonArray();
            
            for (Ingredient ingredient : ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }
            json.add("ingredients", arrayIngredients);
            
            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result)).toString());
            if (count > 1) {
                objectResult.addProperty("count", count);
            }
            json.add("result", objectResult);
            
            if (experience > 0) {
                json.addProperty("experience", experience);
            }
            json.addProperty("stampingTime", stampingTime);
        }
        
        @Override
        public ResourceLocation getId() {
            return id;
        }
        
        @Override
        
        
        public RecipeSerializer<?> getType() {
            return CoinPressRecipe.Serializer.INSTANCE;
        }
        
        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return advancement != null ? advancement.serializeToJson() : null;
        }
        
        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}