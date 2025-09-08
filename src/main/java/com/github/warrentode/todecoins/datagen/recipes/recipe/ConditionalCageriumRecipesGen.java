package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.datagen.recipes.builder.RemainderShapelessRecipeBuilder;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.mehvahdjukaar.cagerium.Cagerium;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.github.warrentode.todecoins.datagen.RecipesGen.setLocation;

public class ConditionalCageriumRecipesGen extends RecipeProvider implements IConditionBuilder {
    public ConditionalCageriumRecipesGen(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        register(consumer);
    }

    public void register(Consumer<FinishedRecipe> consumer) {
        condCageRecipes(consumer);
    }

    private void condCageRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // skeleton key
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(RemainderShapelessRecipeBuilder.shapelessRemainderRecipe(RecipeCategory.MISC, Cagerium.CAGE_KEY.get(), 1)
                        .addIngredient(Items.BONE_BLOCK)
                        .addIngredient(TCItemTags.TOOLS_CARVING)
                        .unlockedBy("has_bone_block", has(Items.BONE_BLOCK))
                        ::build)
                .build(consumer, setLocation("cagerium", Cagerium.CAGE_KEY.get().toString()));
        // burning upgrade
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Cagerium.FIRE_UPGRADE.get(), 1)
                        .requires(Cagerium.CAGE_KEY.get())
                        .requires(Items.BLAZE_POWDER)
                        .requires(Items.SLIME_BALL)
                        .unlockedBy("has_cage_key", has(Cagerium.CAGE_KEY.get()))
                        ::save)
                .build(consumer, setLocation("cagerium", Cagerium.FIRE_UPGRADE.get().toString()));
        // binding wood plate
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Cagerium.TERRARIUM_BASE.get(), 1)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(ItemTags.WOODEN_SLABS)
                        .requires(ItemTags.WOODEN_SLABS)
                        .requires(ItemTags.WOODEN_SLABS)
                        .unlockedBy("has_dragon_breath_for_wood_plate", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, setLocation("cagerium", Cagerium.TERRARIUM_BASE.get().toString()));
        // terrarium
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Cagerium.TERRARIUM_ITEM.get(), 1)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.TINTED_GLASS)
                        .requires(Items.TINTED_GLASS)
                        .requires(Items.TINTED_GLASS)
                        .requires(Items.TINTED_GLASS)
                        .requires(Items.TINTED_GLASS)
                        .requires(TCItemTags.NETHERITE_INGOT)
                        .requires(TCItemTags.NETHERITE_INGOT)
                        .requires(Cagerium.TERRARIUM_BASE.get())
                        .unlockedBy("has_dragon_breath_for_terrarium", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, setLocation("cagerium", Cagerium.TERRARIUM_ITEM.get().toString()));
        // ominous skull
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Cagerium.CAGE_BASE.get(), 1)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.WITHER_SKELETON_SKULL)
                        .requires(Items.WITHER_SKELETON_SKULL)
                        .requires(TCItemTags.NETHERITE_NUGGET)
                        .requires(TCItemTags.NETHERITE_NUGGET)
                        .requires(TCItemTags.NETHERITE_NUGGET)
                        .requires(TCItemTags.NETHERITE_NUGGET)
                        .unlockedBy("has_dragon_breath_for_ominous_skull", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, setLocation("cagerium", Cagerium.CAGE_BASE.get().toString()));
        // cage
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Cagerium.CAGE_ITEM.get(), 1)
                        .requires(Cagerium.CAGE_BASE.get())
                        .requires(Cagerium.CAGE_BASE.get())
                        .requires(Cagerium.CAGE_BASE.get())
                        .requires(Cagerium.CAGE_BASE.get())
                        .requires(Items.IRON_BARS)
                        .requires(Items.IRON_BARS)
                        .requires(Items.IRON_INGOT)
                        .requires(Items.IRON_INGOT)
                        .unlockedBy("has_cage_base", has(Cagerium.CAGE_BASE.get()))
                        ::save)
                .build(consumer, setLocation("cagerium", Cagerium.CAGE_ITEM.get().toString()));
        // binding gemstone
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Cagerium.PLATE_GEM.get(), 1)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(TCItemTags.ONE_EMERALD_CURRENCY_GEMS)
                        .requires(TCItemTags.ONE_EMERALD_CURRENCY_GEMS)
                        .requires(TCItemTags.NETHERITE_NUGGET)
                        .requires(TCItemTags.NETHERITE_NUGGET)
                        .requires(TCItemTags.NETHERITE_NUGGET)
                        .requires(TCItemTags.NETHERITE_NUGGET)
                        .unlockedBy("has_dragon_breath", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, setLocation("cagerium", Cagerium.PLATE_GEM.get().toString()));
        // plate
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Cagerium.PLATE_ITEM.get(), 1)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Cagerium.PLATE_GEM.get())
                        .requires(Cagerium.PLATE_GEM.get())
                        .requires(TCItemTags.NETHERITE_INGOT)
                        .requires(TCItemTags.NETHERITE_INGOT)
                        .requires(TCItemTags.NETHERITE_INGOT)
                        .unlockedBy("has_dragon_breath", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, setLocation("cagerium", Cagerium.PLATE_ITEM.get().toString()));
    }
}