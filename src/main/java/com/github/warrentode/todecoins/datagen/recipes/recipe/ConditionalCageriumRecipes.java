package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.util.TodeCoinsTags;
import net.mehvahdjukaar.cagerium.Cagerium;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ConditionalCageriumRecipes extends RecipeProvider implements IConditionBuilder {
    public ConditionalCageriumRecipes(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // skeleton key
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Cagerium.CAGE_KEY.get(), 1)
                        .requires(Items.BONE_BLOCK)
                        .requires(TodeCoinsTags.Items.TOOLS_CARVING)
                        .unlockedBy("has_bone_block", has(Items.BONE_BLOCK))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", Cagerium.CAGE_KEY.get().toString()));
        // burning upgrade
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Cagerium.FIRE_UPGRADE.get(), 1)
                        .requires(Cagerium.CAGE_KEY.get())
                        .requires(Items.BLAZE_POWDER)
                        .requires(Items.SLIME_BALL)
                        .unlockedBy("has_cage_key", has(Cagerium.CAGE_KEY.get()))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", Cagerium.FIRE_UPGRADE.get().toString()));
        // binding wood plate
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Cagerium.TERRARIUM_BASE.get(), 1)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(ItemTags.WOODEN_SLABS)
                        .requires(ItemTags.WOODEN_SLABS)
                        .requires(ItemTags.WOODEN_SLABS)
                        .unlockedBy("has_dragon_breath_for_wood_plate", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", Cagerium.TERRARIUM_BASE.get().toString()));
        // terrarium
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Cagerium.TERRARIUM_ITEM.get(), 1)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.TINTED_GLASS)
                        .requires(Items.TINTED_GLASS)
                        .requires(Items.TINTED_GLASS)
                        .requires(Items.TINTED_GLASS)
                        .requires(Items.TINTED_GLASS)
                        .requires(TodeCoinsTags.Items.NETHERITE_INGOT_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_INGOT_FORGE_TAG)
                        .requires(Cagerium.TERRARIUM_BASE.get())
                        .unlockedBy("has_dragon_breath_for_terrarium", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", Cagerium.TERRARIUM_ITEM.get().toString()));
        // ominous skull
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Cagerium.CAGE_BASE.get(), 1)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.WITHER_SKELETON_SKULL)
                        .requires(Items.WITHER_SKELETON_SKULL)
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        .unlockedBy("has_dragon_breath_for_ominous_skull", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", Cagerium.CAGE_BASE.get().toString()));
        // cage
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Cagerium.CAGE_ITEM.get(), 1)
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
                .build(consumer, new ResourceLocation("cagerium", Cagerium.CAGE_ITEM.get().toString()));
        // binding gemstone
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Cagerium.PLATE_GEM.get(), 1)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(TodeCoinsTags.Items.GEM_CURRENCY_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.GEM_CURRENCY_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        .unlockedBy("has_dragon_breath_for_binding_gem", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", Cagerium.PLATE_GEM.get().toString()));
        // plate
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Cagerium.PLATE_ITEM.get(), 1)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Items.DRAGON_BREATH)
                        .requires(Cagerium.PLATE_GEM.get())
                        .requires(Cagerium.PLATE_GEM.get())
                        .requires(TodeCoinsTags.Items.NETHERITE_INGOT_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_INGOT_FORGE_TAG)
                        .requires(TodeCoinsTags.Items.NETHERITE_INGOT_FORGE_TAG)
                        .unlockedBy("has_dragon_breath_for_plate", has(Items.DRAGON_BREATH))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", Cagerium.PLATE_ITEM.get().toString()));
    }
}