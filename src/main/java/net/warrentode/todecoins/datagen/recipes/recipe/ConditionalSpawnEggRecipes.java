package net.warrentode.todecoins.datagen.recipes.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalAdvancement;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.warrentode.todecoins.util.tags.ForgeTags;
import net.warrentode.todecoins.util.tags.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ConditionalSpawnEggRecipes extends RecipeProvider implements IConditionBuilder {
    public ConditionalSpawnEggRecipes(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.ALLAY_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .unlockedBy("has_allay_coin", has(ModTags.Items.ALLAY_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.ALLAY_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.ALLAY_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.ALLAY_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.ALLAY_SPAWN_EGG)))
                                                .addCriterion("has_allay_coin", has(ModTags.Items.ALLAY_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.ALLAY_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.AXOLOTL_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.AXOLOTL_COIN_SET)
                        .unlockedBy("has_axolotl_coin", has(ModTags.Items.AXOLOTL_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.AXOLOTL_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.AXOLOTL_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.AXOLOTL_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.AXOLOTL_SPAWN_EGG)))
                                                .addCriterion("has_axolotl_coin", has(ModTags.Items.AXOLOTL_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.AXOLOTL_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.BAT_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.BAT_COIN_SET)
                        .unlockedBy("has_bat_coin", has(ModTags.Items.BAT_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.BAT_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.BAT_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.BAT_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.BAT_SPAWN_EGG)))
                                                .addCriterion("has_bat_coin", has(ModTags.Items.BAT_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.BAT_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.CAT_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.CAT_COIN_SET)
                        .unlockedBy("has_cat_coin", has(ModTags.Items.CAT_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.CAT_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.CAT_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.CAT_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.CAT_SPAWN_EGG)))
                                                .addCriterion("has_cat_coin", has(ModTags.Items.CAT_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.CAT_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.ENDERMAN_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.ENDERMAN_COIN_SET)
                        .unlockedBy("has_enderman_coin", has(ModTags.Items.ENDERMAN_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.ENDERMAN_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.ENDERMAN_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.ENDERMAN_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.ENDERMAN_SPAWN_EGG)))
                                                .addCriterion("has_enderman_coin", has(ModTags.Items.ENDERMAN_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.ENDERMAN_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.OCELOT_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.OCELOT_COIN_SET)
                        .unlockedBy("has_ocelot_coin", has(ModTags.Items.OCELOT_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.OCELOT_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.OCELOT_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.OCELOT_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.OCELOT_SPAWN_EGG)))
                                                .addCriterion("has_ocelot_coin", has(ModTags.Items.OCELOT_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.OCELOT_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.PIGLIN_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.PIGLIN_COIN_SET)
                        .unlockedBy("has_piglin_coin", has(ModTags.Items.PIGLIN_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.PIGLIN_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.PIGLIN_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.PIGLIN_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.PIGLIN_SPAWN_EGG)))
                                                .addCriterion("has_piglin_coin", has(ModTags.Items.PIGLIN_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.PIGLIN_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.CHICKEN_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.CHICKEN_COIN_SET)
                        .unlockedBy("has_chicken_coin", has(ModTags.Items.CHICKEN_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.CHICKEN_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.CHICKEN_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.CHICKEN_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.CHICKEN_SPAWN_EGG)))
                                                .addCriterion("has_chicken_coin", has(ModTags.Items.CHICKEN_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.CHICKEN_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.BLAZE_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.BLAZE_COIN_SET)
                        .unlockedBy("has_blaze_coin", has(ModTags.Items.BLAZE_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.BLAZE_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.BLAZE_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.BLAZE_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.BLAZE_SPAWN_EGG)))
                                                .addCriterion("has_blaze_coin", has(ModTags.Items.BLAZE_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.BLAZE_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.CAVE_SPIDER_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.CAVE_SPIDER_COIN_SET)
                        .unlockedBy("has_cave_spider_coin", has(ModTags.Items.CAVE_SPIDER_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.CAVE_SPIDER_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.CAVE_SPIDER_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.CAVE_SPIDER_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.CAVE_SPIDER_SPAWN_EGG)))
                                                .addCriterion("has_cave_spider_coin", has(ModTags.Items.CAVE_SPIDER_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.CAVE_SPIDER_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.COD_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.COD_COIN_SET)
                        .unlockedBy("has_cod_coin", has(ModTags.Items.COD_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.COD_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.COD_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.COD_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.COD_SPAWN_EGG)))
                                                .addCriterion("has_cod_coin", has(ModTags.Items.COD_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.COD_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.SALMON_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.SALMON_COIN_SET)
                        .unlockedBy("has_salmon_coin", has(ModTags.Items.SALMON_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.SALMON_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.SALMON_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.SALMON_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.SALMON_SPAWN_EGG)))
                                                .addCriterion("has_salmon_coin", has(ModTags.Items.SALMON_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.SALMON_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.PUFFERFISH_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.PUFFERFISH_COIN_SET)
                        .unlockedBy("has_pufferfish_coin", has(ModTags.Items.PUFFERFISH_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.PUFFERFISH_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.PUFFERFISH_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.PUFFERFISH_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.PUFFERFISH_SPAWN_EGG)))
                                                .addCriterion("has_pufferfish_coin", has(ModTags.Items.PUFFERFISH_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.PUFFERFISH_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.TROPICAL_FISH_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.TROPICAL_FISH_COIN_SET)
                        .unlockedBy("has_tropical_fish_coin", has(ModTags.Items.TROPICAL_FISH_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.TROPICAL_FISH_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.TROPICAL_FISH_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.TROPICAL_FISH_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.TROPICAL_FISH_SPAWN_EGG)))
                                                .addCriterion("has_tropical_fish_coin", has(ModTags.Items.TROPICAL_FISH_COIN_SET))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.TROPICAL_FISH_SPAWN_EGG));
    }
}