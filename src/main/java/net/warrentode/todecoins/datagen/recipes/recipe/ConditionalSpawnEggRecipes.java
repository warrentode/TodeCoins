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
import net.warrentode.todecoins.item.ModItems;
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

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.COW_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.COW_COIN_SET)
                        .unlockedBy("has_cow_coin", has(ModTags.Items.COW_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.COW_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.COW_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.COW_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.COW_SPAWN_EGG)))
                                                .addCriterion("has_cow_coin", has(ModTags.Items.COW_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.COW_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.MOOSHROOM_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.MOOSHROOM_COIN_SET)
                        .unlockedBy("has_mooshroom_coin", has(ModTags.Items.MOOSHROOM_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.MOOSHROOM_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.MOOSHROOM_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.MOOSHROOM_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.MOOSHROOM_SPAWN_EGG)))
                                                .addCriterion("has_mooshroom_coin", has(ModTags.Items.MOOSHROOM_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.MOOSHROOM_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.DONKEY_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.DONKEY_COIN_SET)
                        .unlockedBy("has_donkey_coin", has(ModTags.Items.DONKEY_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.DONKEY_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.DONKEY_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.DONKEY_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.DONKEY_SPAWN_EGG)))
                                                .addCriterion("has_donkey_coin", has(ModTags.Items.DONKEY_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.DONKEY_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.HORSE_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.HORSE_COIN_SET)
                        .unlockedBy("has_horse_coin", has(ModTags.Items.HORSE_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.HORSE_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.HORSE_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.HORSE_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.HORSE_SPAWN_EGG)))
                                                .addCriterion("has_horse_coin", has(ModTags.Items.HORSE_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.HORSE_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.MULE_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.MULE_COIN_SET)
                        .unlockedBy("has_mule_coin", has(ModTags.Items.MULE_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.MULE_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.MULE_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.MULE_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.MULE_SPAWN_EGG)))
                                                .addCriterion("has_mule_coin", has(ModTags.Items.MULE_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.MULE_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.SKELETON_HORSE_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.SKELETON_HORSE_COIN_SET)
                        .unlockedBy("has_skeleton_horse_coin", has(ModTags.Items.SKELETON_HORSE_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.SKELETON_HORSE_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.SKELETON_HORSE_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.SKELETON_HORSE_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.SKELETON_HORSE_SPAWN_EGG)))
                                                .addCriterion("has_skeleton_horse_coin", has(ModTags.Items.SKELETON_HORSE_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.SKELETON_HORSE_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.ZOMBIE_HORSE_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.ZOMBIE_HORSE_COIN_SET)
                        .unlockedBy("has_zombie_horse_coin", has(ModTags.Items.ZOMBIE_HORSE_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.ZOMBIE_HORSE_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.ZOMBIE_HORSE_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.ZOMBIE_HORSE_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.ZOMBIE_HORSE_SPAWN_EGG)))
                                                .addCriterion("has_zombie_horse_coin", has(ModTags.Items.ZOMBIE_HORSE_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.ZOMBIE_HORSE_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.FOX_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.FOX_COIN_SET)
                        .unlockedBy("has_fox_coin", has(ModTags.Items.FOX_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.FOX_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.FOX_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.FOX_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.FOX_SPAWN_EGG)))
                                                .addCriterion("has_fox_coin", has(ModTags.Items.FOX_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.FOX_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.FROG_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.FROG_COIN_SET)
                        .unlockedBy("has_frog_coin", has(ModTags.Items.FROG_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.FROG_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.FROG_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.FROG_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.FROG_SPAWN_EGG)))
                                                .addCriterion("has_frog_coin", has(ModTags.Items.FROG_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.FROG_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.GLOW_SQUID_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.GLOW_SQUID_COIN_SET)
                        .unlockedBy("has_glow_squid_coin", has(ModTags.Items.GLOW_SQUID_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.GLOW_SQUID_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.GLOW_SQUID_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.GLOW_SQUID_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.GLOW_SQUID_SPAWN_EGG)))
                                                .addCriterion("has_glow_squid_coin", has(ModTags.Items.GLOW_SQUID_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.GLOW_SQUID_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.SQUID_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.SQUID_COIN_SET)
                        .unlockedBy("has_squid_coin", has(ModTags.Items.SQUID_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.SQUID_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.SQUID_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.SQUID_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.SQUID_SPAWN_EGG)))
                                                .addCriterion("has_squid_coin", has(ModTags.Items.SQUID_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.SQUID_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.PARROT_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.PARROT_COIN_SET)
                        .unlockedBy("has_parrot_coin", has(ModTags.Items.PARROT_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.PARROT_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.PARROT_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.PARROT_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.PARROT_SPAWN_EGG)))
                                                .addCriterion("has_parrot_coin", has(ModTags.Items.PARROT_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.PARROT_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.PIG_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.PIG_COIN_SET)
                        .unlockedBy("has_pig_coin", has(ModTags.Items.PIG_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.PIG_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.PIG_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.PIG_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.PIG_SPAWN_EGG)))
                                                .addCriterion("has_pig_coin", has(ModTags.Items.PIG_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.PIG_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.HOGLIN_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.HOGLIN_COIN_SET)
                        .unlockedBy("has_hoglin_coin", has(ModTags.Items.HOGLIN_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.HOGLIN_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.HOGLIN_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.HOGLIN_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.HOGLIN_SPAWN_EGG)))
                                                .addCriterion("has_hoglin_coin", has(ModTags.Items.HOGLIN_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.HOGLIN_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.RABBIT_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.RABBIT_COIN_SET)
                        .unlockedBy("has_rabbit_coin", has(ModTags.Items.RABBIT_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.RABBIT_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.RABBIT_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.RABBIT_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.RABBIT_SPAWN_EGG)))
                                                .addCriterion("has_rabbit_coin", has(ModTags.Items.RABBIT_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.RABBIT_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.SHEEP_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.SHEEP_COIN_SET)
                        .unlockedBy("has_sheep_coin", has(ModTags.Items.SHEEP_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.SHEEP_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.SHEEP_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.SHEEP_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.SHEEP_SPAWN_EGG)))
                                                .addCriterion("has_sheep_coin", has(ModTags.Items.SHEEP_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.SHEEP_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModItems.SNOW_GOLEM_SPAWN_EGG.get(), 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.SNOW_GOLEM_COIN_SET)
                        .unlockedBy("has_snow_golem_coin", has(ModTags.Items.SNOW_GOLEM_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + ModItems.SNOW_GOLEM_SPAWN_EGG.get()),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(ModItems.SNOW_GOLEM_SPAWN_EGG.get(),
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + ModItems.SNOW_GOLEM_SPAWN_EGG.get()),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + ModItems.SNOW_GOLEM_SPAWN_EGG.get())))
                                                .addCriterion("has_snow_golem_coin", has(ModTags.Items.SNOW_GOLEM_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + ModItems.SNOW_GOLEM_SPAWN_EGG.get()));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.STRIDER_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.STRIDER_COIN_SET)
                        .unlockedBy("has_strider_coin", has(ModTags.Items.STRIDER_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.STRIDER_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.STRIDER_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.STRIDER_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.STRIDER_SPAWN_EGG)))
                                                .addCriterion("has_strider_coin", has(ModTags.Items.STRIDER_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.STRIDER_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.TADPOLE_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.TADPOLE_COIN_SET)
                        .unlockedBy("has_tadpole_coin", has(ModTags.Items.TADPOLE_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.TADPOLE_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.TADPOLE_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.TADPOLE_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.TADPOLE_SPAWN_EGG)))
                                                .addCriterion("has_tadpole_coin", has(ModTags.Items.TADPOLE_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.TADPOLE_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.TURTLE_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.TURTLE_COIN_SET)
                        .unlockedBy("has_turtle_coin", has(ModTags.Items.TURTLE_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.TURTLE_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.TURTLE_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.TURTLE_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.TURTLE_SPAWN_EGG)))
                                                .addCriterion("has_turtle_coin", has(ModTags.Items.TURTLE_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.TURTLE_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.VILLAGER_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.VILLAGER_COIN_SET)
                        .unlockedBy("has_villager_coin", has(ModTags.Items.VILLAGER_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.VILLAGER_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.VILLAGER_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.VILLAGER_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.VILLAGER_SPAWN_EGG)))
                                                .addCriterion("has_villager_coin", has(ModTags.Items.VILLAGER_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.VILLAGER_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.WANDERING_TRADER_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.WANDERING_TRADER_COIN_SET)
                        .unlockedBy("has_wandering_trader_coin", has(ModTags.Items.WANDERING_TRADER_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.WANDERING_TRADER_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(Items.WANDERING_TRADER_SPAWN_EGG,
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + Items.WANDERING_TRADER_SPAWN_EGG),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.WANDERING_TRADER_SPAWN_EGG)))
                                                .addCriterion("has_wandering_trader_coin", has(ModTags.Items.WANDERING_TRADER_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.WANDERING_TRADER_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(ModItems.NUMISMATIST_SPAWN_EGG.get(), 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.NUMISMATIST_COIN_SET)
                        .unlockedBy("has_numismatist_coin", has(ModTags.Items.NUMISMATIST_COIN_SET))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + ModItems.NUMISMATIST_SPAWN_EGG.get()),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement().display(ModItems.NUMISMATIST_SPAWN_EGG.get(),
                                                        Component.translatable("advancement.dependency.spawn_egg_recipes." + ModItems.NUMISMATIST_SPAWN_EGG.get()),
                                                        Component.translatable("advancement.dependency.condition.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + ModItems.NUMISMATIST_SPAWN_EGG.get())))
                                                .addCriterion("has_numismatist_coin", has(ModTags.Items.NUMISMATIST_COIN_SET))
                                )
                )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + ModItems.NUMISMATIST_SPAWN_EGG.get()));
    }
}