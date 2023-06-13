package net.warrentode.todecoins.datagen.recipes.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
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
                        .unlockedBy("has_allay_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ALLAY_COIN.get(), ModItems.IRON_ALLAY_COIN.get(), ModItems.GOLD_ALLAY_COIN.get(), ModItems.NETHERITE_ALLAY_COIN.get()))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.ALLAY_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement()
                                                .parent(new ResourceLocation("cagerium", "spawn_eggs/" + Items.ALLAY_SPAWN_EGG))
                                                .display(Items.PIG_SPAWN_EGG,
                                                        Component.literal("Spawn Egg Recipes"),
                                                        Component.literal("Optional Recipes for when Cagerium is Loaded"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.ALLAY_SPAWN_EGG)))
                                                .addCriterion("has_soul_binder", has(ModTags.Items.SOUL_BINDER))
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
                        .unlockedBy("has_axolotl_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_AXOLOTL_COIN.get(), ModItems.IRON_AXOLOTL_COIN.get(), ModItems.GOLD_AXOLOTL_COIN.get(), ModItems.NETHERITE_AXOLOTL_COIN.get()))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.AXOLOTL_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement()
                                                .parent(new ResourceLocation("cagerium", "spawn_eggs/" + Items.AXOLOTL_SPAWN_EGG))
                                                .display(Items.PIG_SPAWN_EGG,
                                                        Component.translatable("advancement.optional.spawn_egg_recipes"),
                                                        Component.translatable("advancement.optional.spawn_egg_recipes.desc"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.AXOLOTL_SPAWN_EGG)))
                                                .addCriterion("has_soul_binder", has(ModTags.Items.SOUL_BINDER))
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
                        .unlockedBy("has_bat_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BAT_COIN.get(), ModItems.IRON_BAT_COIN.get(), ModItems.GOLD_BAT_COIN.get(), ModItems.NETHERITE_BAT_COIN.get()))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.BAT_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement()
                                                .parent(new ResourceLocation("cagerium", "spawn_eggs/" + Items.BAT_SPAWN_EGG))
                                                .display(Items.PIG_SPAWN_EGG,
                                                        Component.literal("Spawn Egg Recipes"),
                                                        Component.literal("Optional Recipes for when Cagerium is Loaded"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.BAT_SPAWN_EGG)))
                                                .addCriterion("has_soul_binder", has(ModTags.Items.SOUL_BINDER))
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
                        .unlockedBy("has_cat_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAT_COIN.get(), ModItems.IRON_CAT_COIN.get(), ModItems.GOLD_CAT_COIN.get(), ModItems.NETHERITE_CAT_COIN.get()))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.CAT_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement()
                                                .parent(new ResourceLocation("cagerium", "spawn_eggs/" + Items.CAT_SPAWN_EGG))
                                                .display(Items.PIG_SPAWN_EGG,
                                                        Component.literal("Spawn Egg Recipes"),
                                                        Component.literal("Optional Recipes for when Cagerium is Loaded"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.CAT_SPAWN_EGG)))
                                                .addCriterion("has_soul_binder", has(ModTags.Items.SOUL_BINDER))
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
                        .unlockedBy("has_enderman_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDERMAN_COIN.get(), ModItems.IRON_ENDERMAN_COIN.get(), ModItems.GOLD_ENDERMAN_COIN.get(), ModItems.NETHERITE_ENDERMAN_COIN.get()))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.ENDERMAN_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement()
                                                .parent(new ResourceLocation("cagerium", "spawn_eggs/" + Items.ENDERMAN_SPAWN_EGG))
                                                .display(Items.PIG_SPAWN_EGG,
                                                        Component.literal("Spawn Egg Recipes"),
                                                        Component.literal("Optional Recipes for when Cagerium is Loaded"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.ENDERMAN_SPAWN_EGG)))
                                                .addCriterion("has_soul_binder", has(ModTags.Items.SOUL_BINDER))
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
                        .unlockedBy("has_ocelot_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_OCELOT_COIN.get(), ModItems.IRON_OCELOT_COIN.get(), ModItems.GOLD_OCELOT_COIN.get(), ModItems.NETHERITE_OCELOT_COIN.get()))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.OCELOT_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement()
                                                .parent(new ResourceLocation("cagerium", "spawn_eggs/" + Items.OCELOT_SPAWN_EGG))
                                                .display(Items.PIG_SPAWN_EGG,
                                                        Component.literal("Spawn Egg Recipes"),
                                                        Component.literal("Optional Recipes for when Cagerium is Loaded"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.OCELOT_SPAWN_EGG)))
                                                .addCriterion("has_soul_binder", has(ModTags.Items.SOUL_BINDER))
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
                        .unlockedBy("has_piglin_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_COIN.get(), ModItems.IRON_PIGLIN_COIN.get(), ModItems.GOLD_PIGLIN_COIN.get(), ModItems.NETHERITE_PIGLIN_COIN.get()))
                        ::save)
                .setAdvancement(new ResourceLocation("cagerium", "recipes/spawn_eggs/" + Items.PIGLIN_SPAWN_EGG),
                        ConditionalAdvancement.builder()
                                .addCondition(and(modLoaded("cagerium"), TRUE()))
                                .addAdvancement(
                                        Advancement.Builder.advancement()
                                                .parent(new ResourceLocation("cagerium", "spawn_eggs/" + Items.PIGLIN_SPAWN_EGG))
                                                .display(Items.PIG_SPAWN_EGG,
                                                        Component.literal("Spawn Egg Recipes"),
                                                        Component.literal("Optional Recipes for when Cagerium is Loaded"),
                                                        null, FrameType.TASK, false, false, false)
                                                .rewards(AdvancementRewards.Builder.recipe(new ResourceLocation("cagerium", "spawn_eggs/" + Items.PIGLIN_SPAWN_EGG)))
                                                .addCriterion("has_soul_binder", has(ModTags.Items.SOUL_BINDER))
                                               )
                               )
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.PIGLIN_SPAWN_EGG));

    }
}