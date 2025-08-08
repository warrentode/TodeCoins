package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.faboslav.friendsandfoes.init.FriendsAndFoesItems;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import net.mehvahdjukaar.cagerium.Cagerium;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import tallestegg.guardvillagers.GuardItems;

import java.util.function.Consumer;

public class ConditionalSpawnEggRecipes extends RecipeProvider implements IConditionBuilder {
    public ConditionalSpawnEggRecipes(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // this one will never need to load due to cagerium being required to load for all spawn egg recipes to even work but it's here for the sake of completion
        // and of course, people are free to edit the recipe in the files to make it active for their modpacks or whatever if they wish
        recipeNotTemplate(consumer, "guardvillagers", "cagerium", GuardItems.IRON_GOLEM_SPAWN_EGG.get(), Items.IRON_SWORD, TodeCoinsTags.Items.IRON_GOLEM_COIN_SET);

        // these load only if other mods are not loaded
        recipeNotTemplate(consumer, "todecoins", "friendsandfoes", ModItems.ILLUSIONER_SPAWN_EGG.get(), ModItems.COPPER_COIN.get(), TodeCoinsTags.Items.ILLUSIONER_COIN_SET);
        recipeNotTemplate(consumer, "todecoins", "guardvillagers", ModItems.SNOW_GOLEM_SPAWN_EGG.get(), ModItems.COPPER_COIN.get(), TodeCoinsTags.Items.SNOW_GOLEM_COIN_SET);
        recipeNotTemplate(consumer, "guardvillagers", "friendsandfoes", GuardItems.ILLUSIONER_SPAWN_EGG.get(), Items.IRON_SWORD, TodeCoinsTags.Items.ILLUSIONER_COIN_SET);

        // needs its own mod to be loaded, obviously
        recipeAndTemplate(consumer, "guardvillagers", GuardItems.GUARD_SPAWN_EGG.get(), Items.IRON_SWORD, TodeCoinsTags.Items.GUARD_COIN_SET);
        recipeAndTemplate(consumer, "guardvillagers", GuardItems.SNOW_GOLEM_SPAWN_EGG.get(), Items.IRON_SWORD, TodeCoinsTags.Items.SNOW_GOLEM_COIN_SET);

        recipeAndTemplate(consumer, "ecologics", samebutdifferent.ecologics.registry.ModItems.CAMEL_SPAWN_EGG.get(), samebutdifferent.ecologics.registry.ModItems.PRICKLY_PEAR.get(), TodeCoinsTags.Items.CAMEL_COIN_SET);
        recipeAndTemplate(consumer, "ecologics", samebutdifferent.ecologics.registry.ModItems.COCONUT_CRAB_SPAWN_EGG.get(), samebutdifferent.ecologics.registry.ModItems.COCONUT_HUSK.get(), TodeCoinsTags.Items.CRAB_COIN_SET);
        recipeAndTemplate(consumer, "ecologics", samebutdifferent.ecologics.registry.ModItems.SQUIRREL_SPAWN_EGG.get(), samebutdifferent.ecologics.registry.ModItems.WALNUT.get(), TodeCoinsTags.Items.SQUIRREL_COIN_SET);
        recipeAndTemplate(consumer, "ecologics", samebutdifferent.ecologics.registry.ModItems.PENGUIN_SPAWN_EGG.get(), samebutdifferent.ecologics.registry.ModItems.PENGUIN_FEATHER.get(), TodeCoinsTags.Items.PENGUIN_COIN_SET);

        recipeAndTemplate(consumer, "friendsandfoes", FriendsAndFoesItems.COPPER_GOLEM_SPAWN_EGG.get(), FriendsAndFoesItems.BUTTERCUP.get(), TodeCoinsTags.Items.COPPER_GOLEM_COIN_SET);
        recipeAndTemplate(consumer, "friendsandfoes", FriendsAndFoesItems.GLARE_SPAWN_EGG.get(), FriendsAndFoesItems.BUTTERCUP.get(), TodeCoinsTags.Items.GLARE_COIN_SET);
        recipeAndTemplate(consumer, "friendsandfoes", FriendsAndFoesItems.ICEOLOGER_SPAWN_EGG.get(), FriendsAndFoesItems.BUTTERCUP.get(), TodeCoinsTags.Items.ICEOLOGER_COIN_SET);
        recipeAndTemplate(consumer, "friendsandfoes", FriendsAndFoesItems.ILLUSIONER_SPAWN_EGG.get(), FriendsAndFoesItems.BUTTERCUP.get(), TodeCoinsTags.Items.ILLUSIONER_COIN_SET);
        recipeAndTemplate(consumer, "friendsandfoes", FriendsAndFoesItems.MOOBLOOM_SPAWN_EGG.get(), FriendsAndFoesItems.BUTTERCUP.get(), TodeCoinsTags.Items.MOOBLOOM_COIN_SET);
        recipeAndTemplate(consumer, "friendsandfoes", FriendsAndFoesItems.TUFF_GOLEM_SPAWN_EGG.get(), FriendsAndFoesItems.BUTTERCUP.get(), TodeCoinsTags.Items.TUFF_GOLEM_COIN_SET);
        recipeAndTemplate(consumer, "friendsandfoes", FriendsAndFoesItems.WILDFIRE_SPAWN_EGG.get(), FriendsAndFoesItems.BUTTERCUP.get(), TodeCoinsTags.Items.WILDFIRE_COIN_SET);

        // just needs cagerium loaded
        recipeTemplate(consumer, "todecoins", ModItems.GIANT_SPAWN_EGG.get(), ModItems.COPPER_COIN.get(), TodeCoinsTags.Items.GIANT_COIN_SET);
        recipeTemplate(consumer, "todecoins", ModItems.NUMISMATIST_SPAWN_EGG.get(), ModItems.COPPER_COIN.get(), TodeCoinsTags.Items.NUMISMATIST_COIN_SET);

        recipeTemplate(consumer, "cagerium", Cagerium.ENDER_DRAGON_SPAWN_EGG.get(), Cagerium.CAGE_KEY.get(), TodeCoinsTags.Items.ENDER_DRAGON_COIN_SET);
        recipeTemplate(consumer, "cagerium", Cagerium.IRON_GOLEM_SPAWN_EGG.get(), Cagerium.CAGE_KEY.get(), TodeCoinsTags.Items.IRON_GOLEM_COIN_SET);
        recipeTemplate(consumer, "cagerium", Cagerium.WITHER_SPAWN_EGG.get(), Cagerium.CAGE_KEY.get(), TodeCoinsTags.Items.WITHER_COIN_SET);

        recipeTemplate(consumer, "minecraft", Items.ALLAY_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.ALLAY_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.AXOLOTL_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.AXOLOTL_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.BAT_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.BAT_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.BEE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.BEE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.BLAZE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.BLAZE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.CAT_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.CAT_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.CAVE_SPIDER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.CAVE_SPIDER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.CHICKEN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.CHICKEN_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.COD_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.COD_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.COW_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.COW_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.CREEPER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.CREEPER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.DOLPHIN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.DOLPHIN_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.DONKEY_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.DONKEY_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.DROWNED_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.DROWNED_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.ELDER_GUARDIAN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.ELDER_GUARDIAN_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.ENDERMAN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.ENDERMAN_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.ENDERMITE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.ENDERMITE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.EVOKER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.EVOKER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.FOX_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.FOX_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.FROG_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.FROG_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.GHAST_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.GHAST_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.GLOW_SQUID_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.GLOW_SQUID_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.GOAT_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.GOAT_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.GUARDIAN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.GUARDIAN_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.HOGLIN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.HOGLIN_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.HORSE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.HORSE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.HUSK_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.HUSK_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.LLAMA_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.LLAMA_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.MAGMA_CUBE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.MAGMA_CUBE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.MOOSHROOM_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.MOOSHROOM_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.MULE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.MULE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.OCELOT_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.OCELOT_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.PANDA_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.PANDA_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.PARROT_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.PARROT_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.PHANTOM_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.PHANTOM_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.PIG_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.PIG_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.PIGLIN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.PIGLIN_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.PIGLIN_BRUTE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.PIGLIN_BRUTE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.PILLAGER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.PILLAGER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.POLAR_BEAR_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.POLAR_BEAR_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.PUFFERFISH_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.PUFFERFISH_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.RABBIT_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.RABBIT_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.RAVAGER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.RAVAGER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.SALMON_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.SALMON_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.SHEEP_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.SHEEP_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.SHULKER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.SHULKER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.SILVERFISH_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.SILVERFISH_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.SKELETON_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.SKELETON_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.SKELETON_HORSE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.SKELETON_HORSE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.SLIME_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.SLIME_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.SPIDER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.SPIDER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.SQUID_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.SQUID_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.STRAY_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.STRAY_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.STRIDER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.STRIDER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.TADPOLE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.TADPOLE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.TRADER_LLAMA_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.TRADER_LLAMA_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.TROPICAL_FISH_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.TROPICAL_FISH_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.TURTLE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.TURTLE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.VEX_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.VEX_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.VILLAGER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.VILLAGER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.VINDICATOR_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.VINDICATOR_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.WANDERING_TRADER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.WANDERING_TRADER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.WARDEN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.WARDEN_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.WITCH_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.WITCH_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.WITHER_SKELETON_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.WITHER_SKELETON_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.WOLF_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.WOLF_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.ZOGLIN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.ZOGLIN_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.ZOMBIE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.ZOMBIE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.ZOMBIE_HORSE_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.ZOMBIE_HORSE_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.ZOMBIE_VILLAGER_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.ZOMBIE_VILLAGER_COIN_SET);
        recipeTemplate(consumer, "minecraft", Items.ZOMBIFIED_PIGLIN_SPAWN_EGG, Items.STONE_PICKAXE, TodeCoinsTags.Items.ZOMBIFIED_PIGLIN_COIN_SET);
    }

    protected void recipeTemplate(Consumer<FinishedRecipe> consumer, String modid, Item result, Item namespaceItem, TagKey<Item> entityCoinSet) {
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(modLoaded("cagerium"))
                .addRecipe(ShapelessRecipeBuilder.shapeless(result, 1)
                        .group("spawn_eggs")
                        // egg base
                        .requires(Tags.Items.EGGS)
                        // soul activator
                        .requires(TodeCoinsTags.Items.SOUL_BINDER)
                        // material item cost
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        // life bringer item
                        .requires(Items.HEART_OF_THE_SEA)
                        // namespace identifier item
                        .requires(namespaceItem)
                        // entity identifier item tag
                        .requires(entityCoinSet)
                        .unlockedBy("has_collectible_entity_coin", has(TodeCoinsTags.Items.ENTITY_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + modid + "/" + result));
    }

    protected void recipeNotTemplate(Consumer<FinishedRecipe> consumer, String modid, String modidNot, Item result, Item namespaceItem, TagKey<Item> entityCoinSet) {
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(modLoaded("cagerium"))
                .addCondition(not(modLoaded(modidNot)))
                .addRecipe(ShapelessRecipeBuilder.shapeless(result, 1)
                        .group("spawn_eggs")
                        // egg base
                        .requires(Tags.Items.EGGS)
                        // soul activator
                        .requires(TodeCoinsTags.Items.SOUL_BINDER)
                        // material item cost
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        // life bringer item
                        .requires(Items.HEART_OF_THE_SEA)
                        // namespace identifier item
                        .requires(namespaceItem)
                        // entity identifier item tag
                        .requires(entityCoinSet)
                        .unlockedBy("has_collectible_entity_coin", has(TodeCoinsTags.Items.ENTITY_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + modid + "/" + result));
    }

    protected void recipeAndTemplate(Consumer<FinishedRecipe> consumer, String modid, Item result, Item namespaceItem, TagKey<Item> entityCoinSet) {
        //noinspection removal
        ConditionalRecipe.builder()
                .addCondition(modLoaded("cagerium"))
                .addCondition(and(modLoaded(modid)))
                .addRecipe(ShapelessRecipeBuilder.shapeless(result, 1)
                        .group("spawn_eggs")
                        // egg base
                        .requires(Tags.Items.EGGS)
                        // soul activator
                        .requires(TodeCoinsTags.Items.SOUL_BINDER)
                        // material item cost
                        .requires(TodeCoinsTags.Items.NETHERITE_NUGGET_FORGE_TAG)
                        // life bringer item
                        .requires(Items.HEART_OF_THE_SEA)
                        // namespace identifier item
                        .requires(namespaceItem)
                        // entity identifier item tag
                        .requires(entityCoinSet)
                        .unlockedBy("has_collectible_entity_coin", has(TodeCoinsTags.Items.ENTITY_COIN_SET))
                        ::save)
                .build(consumer, new ResourceLocation("cagerium", "spawn_eggs/" + modid + "/" + result));
    }
}