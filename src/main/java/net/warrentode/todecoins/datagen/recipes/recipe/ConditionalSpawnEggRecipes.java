package net.warrentode.todecoins.datagen.recipes.recipe;

import net.mehvahdjukaar.cagerium.Cagerium;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.util.tags.ForgeTags;
import net.warrentode.todecoins.util.tags.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static samebutdifferent.ecologics.registry.ModItems.CAMEL_SPAWN_EGG;
import static samebutdifferent.ecologics.registry.ModItems.PRICKLY_PEAR;

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
                        .requires(ModTags.Items.ALLAY_COIN_SET)
                        .unlockedBy("has_allay_coin", has(ModTags.Items.ALLAY_COIN_SET))
                        ::save)
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
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + ModItems.NUMISMATIST_SPAWN_EGG.get()));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.DOLPHIN_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.DOLPHIN_COIN_SET)
                        .unlockedBy("has_dolphin_coin", has(ModTags.Items.DOLPHIN_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.DOLPHIN_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.GOAT_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.GOAT_COIN_SET)
                        .unlockedBy("has_goat_coin", has(ModTags.Items.GOAT_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.GOAT_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Cagerium.IRON_GOLEM_SPAWN_EGG.get(), 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.IRON_GOLEM_COIN_SET)
                        .unlockedBy("has_iron_golem_coin", has(ModTags.Items.IRON_GOLEM_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Cagerium.IRON_GOLEM_SPAWN_EGG.get()));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.LLAMA_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.LLAMA_COIN_SET)
                        .unlockedBy("has_llama_coin", has(ModTags.Items.LLAMA_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.LLAMA_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.TRADER_LLAMA_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.TRADER_LLAMA_COIN_SET)
                        .unlockedBy("has_trader_lama_coin", has(ModTags.Items.TRADER_LLAMA_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.TRADER_LLAMA_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.PANDA_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.PANDA_COIN_SET)
                        .unlockedBy("has_panda_coin", has(ModTags.Items.PANDA_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.PANDA_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.POLAR_BEAR_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.POLAR_BEAR_COIN_SET)
                        .unlockedBy("has_polar_bear_coin", has(ModTags.Items.POLAR_BEAR_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.POLAR_BEAR_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.SPIDER_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.SPIDER_COIN_SET)
                        .unlockedBy("has_spider_coin", has(ModTags.Items.SPIDER_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.SPIDER_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.WOLF_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.WOLF_COIN_SET)
                        .unlockedBy("has_wolf_coin", has(ModTags.Items.WOLF_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.WOLF_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.ZOMBIFIED_PIGLIN_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.ZOMBIFIED_PIGLIN_COIN_SET)
                        .unlockedBy("has_zombified_piglin_coin", has(ModTags.Items.ZOMBIFIED_PIGLIN_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.ZOMBIFIED_PIGLIN_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.CREEPER_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.CREEPER_COIN_SET)
                        .unlockedBy("has_creeper_coin", has(ModTags.Items.CREEPER_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.CREEPER_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.DROWNED_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.DROWNED_COIN_SET)
                        .unlockedBy("has_drowned_coin", has(ModTags.Items.DROWNED_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.DROWNED_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.ELDER_GUARDIAN_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.ELDER_GUARDIAN_COIN_SET)
                        .unlockedBy("has_elder_guardian_coin", has(ModTags.Items.ELDER_GUARDIAN_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.ELDER_GUARDIAN_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.GUARDIAN_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.GUARDIAN_COIN_SET)
                        .unlockedBy("has_guardian_coin", has(ModTags.Items.GUARDIAN_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.GUARDIAN_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.ENDERMITE_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.ENDERMITE_COIN_SET)
                        .unlockedBy("has_endermite_coin", has(ModTags.Items.ENDERMITE_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.ENDERMITE_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.EVOKER_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.EVOKER_COIN_SET)
                        .unlockedBy("has_evoker_coin", has(ModTags.Items.EVOKER_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.EVOKER_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(Items.BEE_SPAWN_EGG, 1)
                        .requires(Tags.Items.EGGS)
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.BEE_COIN_SET)
                        .unlockedBy("has_bee_coin", has(ModTags.Items.BEE_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + Items.BEE_SPAWN_EGG));

        ConditionalRecipe.builder()
                .addCondition(and(modLoaded("cagerium"), TRUE()))
                .addCondition(and(modLoaded("ecologics"), TRUE()))
                .addRecipe(ShapelessRecipeBuilder.shapeless(CAMEL_SPAWN_EGG.get(), 1)
                        .requires(Tags.Items.EGGS)
                        .requires(PRICKLY_PEAR.get())
                        .requires(Items.HEART_OF_THE_SEA)
                        .requires(ModTags.Items.SOUL_BINDER)
                        .requires(ForgeTags.Items.NETHERITE_NUGGET)
                        .requires(ModTags.Items.CAMEL_COIN_SET)
                        .unlockedBy("has_camel_coin", has(ModTags.Items.CAMEL_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + CAMEL_SPAWN_EGG.get()));
    }
}