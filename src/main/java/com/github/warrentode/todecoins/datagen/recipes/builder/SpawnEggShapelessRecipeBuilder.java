package com.github.warrentode.todecoins.datagen.recipes.builder;

import com.github.warrentode.todecoins.recipe.TCRecipes;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class SpawnEggShapelessRecipeBuilder {
    private final RecipeCategory category;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Item result;
    private String group = "";
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    private SpawnEggShapelessRecipeBuilder(RecipeCategory category, @NotNull ItemLike resultIn) {
        this.result = resultIn.asItem();
        this.category = category;
    }

    public static @NotNull SpawnEggShapelessRecipeBuilder shapelessSpawnEggRecipe(RecipeCategory category, ItemLike result) {
        return new SpawnEggShapelessRecipeBuilder(category, result);
    }

    public SpawnEggShapelessRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return addIngredient(Ingredient.of(tagIn));
    }

    public SpawnEggShapelessRecipeBuilder addIngredient(ItemLike itemIn) {
        return addIngredient(Ingredient.of(itemIn));
    }

    public SpawnEggShapelessRecipeBuilder addIngredient(Ingredient ingredientIn) {
        ingredients.add(ingredientIn);
        return this;
    }

    public SpawnEggShapelessRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public SpawnEggShapelessRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public SpawnEggShapelessRecipeBuilder group(String groupIn) {
        this.group = groupIn;
        return this;
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
        assert location != null;
        build(consumerIn, MODID + ":spawn_eggs/" + location.getPath());
    }

    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        build(consumerIn, ResourceLocation.parse(save));
    }

    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        if (!advancement.getCriteria().isEmpty()) {
            advancement.parent(ResourceLocation.parse("recipes/root"))
                    .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                    .rewards(AdvancementRewards.Builder.recipe(id))
                    .requirements(RequirementsStrategy.OR);

            ResourceLocation advancementId = ResourceLocation.parse(id.getNamespace() + ":recipes/" + id.getPath());
            consumerIn.accept(new Result(id, result, ingredients, category, group, advancement, advancementId));
        }
        else {
            consumerIn.accept(new Result(id, result, ingredients, category, group, null, null));
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final String group;
        private final RecipeCategory category;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, Item result, List<Ingredient> ingredients, RecipeCategory category, String group,
                      @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
            this.id = id;
            this.result = result;
            this.ingredients = ingredients;
            this.category = category;
            this.group = group;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(@NotNull JsonObject json) {
            if (!group.isEmpty()) json.addProperty("group", group);
            if (category != null) json.addProperty("recipe_book_category", category.toString());

            JsonArray arrayIngredients = new JsonArray();
            for (Ingredient ingredient : ingredients) arrayIngredients.add(ingredient.toJson());
            json.add("ingredients", arrayIngredients);

            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result)).toString());
            json.add("result", objectResult);
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return TCRecipes.SPAWN_EGG_SHAPELESS_SERIALIZER.get();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return advancement != null ? advancement.serializeToJson() : null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return advancementId;
        }
    }
}