package com.github.warrentode.todecoins.potion;

import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import java.util.List;

public class TCBrewingRecipes {

    /**
     * Call this from commonSetup() with enqueueWork().
     */
    public static void registerAll() {
        // Thick potion - normally unbrewable, made available here as a base
        BrewingRecipeRegistry.addRecipe(
                new BetterBrewingRecipe(Potions.WATER, TCItems.LUCKY_COIN.get(), Potions.THICK)
        );

        // Define all potion progressions
        List<PotionRecipeData> allRecipes = List.of(
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.BONE, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.HOLY_STRIKE_POTION.get(), TCPotions.HOLY_STRIKE_POTION_2.get(), TCPotions.HOLY_STRIKE_POTION_3.get(),
                                TCPotions.HOLY_STRIKE_POTION_4.get(), TCPotions.HOLY_STRIKE_POTION_5.get(), TCPotions.HOLY_STRIKE_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.WITHER_ROSE, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.WITHERING_STRIKE_POTION.get(), TCPotions.WITHERING_STRIKE_POTION_2.get(), TCPotions.WITHERING_STRIKE_POTION_3.get(),
                                TCPotions.WITHERING_STRIKE_POTION_4.get(), TCPotions.WITHERING_STRIKE_POTION_5.get(), TCPotions.WITHERING_STRIKE_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.ECHO_SHARD, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.SILENCE_CLOAK_POTION.get(), TCPotions.SILENCE_CLOAK_POTION_2.get(), TCPotions.SILENCE_CLOAK_POTION_3.get(),
                                TCPotions.SILENCE_CLOAK_POTION_4.get(), TCPotions.SILENCE_CLOAK_POTION_5.get(), TCPotions.SILENCE_CLOAK_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.SPIDER_EYE, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.ARTHROPOD_BLIGHT_POTION.get(), TCPotions.ARTHROPOD_BLIGHT_POTION_2.get(), TCPotions.ARTHROPOD_BLIGHT_POTION_3.get(),
                                TCPotions.ARTHROPOD_BLIGHT_POTION_4.get(), TCPotions.ARTHROPOD_BLIGHT_POTION_5.get(), TCPotions.ARTHROPOD_BLIGHT_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.GHAST_TEAR, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.HEALING_MIST_POTION.get(), TCPotions.HEALING_MIST_POTION_2.get(), TCPotions.HEALING_MIST_POTION_3.get(),
                                TCPotions.HEALING_MIST_POTION_4.get(), TCPotions.HEALING_MIST_POTION_5.get(), TCPotions.HEALING_MIST_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.GLOW_INK_SAC, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.GLOWING_AURA_POTION.get(), TCPotions.GLOWING_AURA_POTION_2.get(), TCPotions.GLOWING_AURA_POTION_3.get(),
                                TCPotions.GLOWING_AURA_POTION_4.get(), TCPotions.GLOWING_AURA_POTION_5.get(), TCPotions.GLOWING_AURA_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.FIRE_CHARGE, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.BURNING_STRIKE_POTION.get(), TCPotions.BURNING_STRIKE_POTION_2.get(), TCPotions.BURNING_STRIKE_POTION_3.get(),
                                TCPotions.BURNING_STRIKE_POTION_4.get(), TCPotions.BURNING_STRIKE_POTION_5.get(), TCPotions.BURNING_STRIKE_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.SNOWBALL, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.FROST_STRIKE_POTION.get(), TCPotions.FROST_STRIKE_POTION_2.get(), TCPotions.FROST_STRIKE_POTION_3.get(),
                                TCPotions.FROST_STRIKE_POTION_4.get(), TCPotions.FROST_STRIKE_POTION_5.get(), TCPotions.FROST_STRIKE_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.ARROW, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.ILLAGER_BANE_POTION.get(), TCPotions.ILLAGER_BANE_POTION_2.get(), TCPotions.ILLAGER_BANE_POTION_3.get(),
                                TCPotions.ILLAGER_BANE_POTION_4.get(), TCPotions.ILLAGER_BANE_POTION_5.get(), TCPotions.ILLAGER_BANE_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.GOLDEN_CARROT, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.BLIND_SHIELD_POTION.get(), TCPotions.BLIND_SHIELD_POTION_2.get(), TCPotions.BLIND_SHIELD_POTION_3.get(),
                                TCPotions.BLIND_SHIELD_POTION_4.get(), TCPotions.BLIND_SHIELD_POTION_5.get(), TCPotions.BLIND_SHIELD_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.LIGHTNING_ROD, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.THUNDERSTRIKE_POTION.get(), TCPotions.THUNDERSTRIKE_POTION_2.get(), TCPotions.THUNDERSTRIKE_POTION_3.get(),
                                TCPotions.THUNDERSTRIKE_POTION_4.get(), TCPotions.THUNDERSTRIKE_POTION_5.get(), TCPotions.THUNDERSTRIKE_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Blocks.SWEET_BERRY_BUSH.asItem(), Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.THORN_SHIELD_POTION.get(), TCPotions.THORN_SHIELD_POTION_2.get(), TCPotions.THORN_SHIELD_POTION_3.get(),
                                TCPotions.THORN_SHIELD_POTION_4.get(), TCPotions.THORN_SHIELD_POTION_5.get(), TCPotions.THORN_SHIELD_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.PUFFERFISH, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.VENOM_STRIKE_POTION.get(), TCPotions.VENOM_STRIKE_POTION_2.get(), TCPotions.VENOM_STRIKE_POTION_3.get(),
                                TCPotions.VENOM_STRIKE_POTION_4.get(), TCPotions.VENOM_STRIKE_POTION_5.get(), TCPotions.VENOM_STRIKE_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{TCItems.LUCKY_COIN.get(), Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                Potions.LUCK, TCPotions.LUCK_POTION_2.get(), TCPotions.LUCK_POTION_3.get(),
                                TCPotions.LUCK_POTION_4.get(), TCPotions.LUCK_POTION_5.get(), TCPotions.LUCK_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.COBWEB, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.UNHINDERED_POTION.get(), TCPotions.UNHINDERED_POTION_2.get(), TCPotions.UNHINDERED_POTION_3.get(),
                                TCPotions.UNHINDERED_POTION_4.get(), TCPotions.UNHINDERED_POTION_5.get(), TCPotions.UNHINDERED_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.RABBIT_HIDE, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.HUNTERS_WARD_POTION.get(), TCPotions.HUNTERS_WARD_POTION_2.get(), TCPotions.HUNTERS_WARD_POTION_3.get(),
                                TCPotions.HUNTERS_WARD_POTION_4.get(), TCPotions.HUNTERS_WARD_POTION_5.get(), TCPotions.HUNTERS_WARD_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.LUCK,
                        new Item[]{Items.FERMENTED_SPIDER_EYE, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.UNLUCK_POTION.get(), TCPotions.UNLUCK_POTION_2.get(), TCPotions.UNLUCK_POTION_3.get(),
                                TCPotions.UNLUCK_POTION_4.get(), TCPotions.UNLUCK_POTION_5.get(), TCPotions.UNLUCK_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.LUCK,
                        new Item[]{Items.FEATHER, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.FISHERMANS_BLESSING_POTION.get(), TCPotions.FISHERMANS_BLESSING_POTION_2.get(), TCPotions.FISHERMANS_BLESSING_POTION_3.get(),
                                TCPotions.FISHERMANS_BLESSING_POTION_4.get(), TCPotions.FISHERMANS_BLESSING_POTION_5.get(), TCPotions.FISHERMANS_BLESSING_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.FEATHER, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.GUST_STRIKE_POTION.get(), TCPotions.GUST_STRIKE_POTION_2.get(), TCPotions.GUST_STRIKE_POTION_3.get(),
                                TCPotions.GUST_STRIKE_POTION_4.get(), TCPotions.GUST_STRIKE_POTION_5.get(), TCPotions.GUST_STRIKE_POTION_6.get()
                        }
                ),
                new PotionRecipeData(
                        Potions.THICK,
                        new Item[]{Items.SUNFLOWER, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST, Items.GLOWSTONE_DUST}, // tiered ingredients
                        new Potion[]{
                                TCPotions.POLLINATING_STEP_POTION.get(), TCPotions.POLLINATING_STEP_POTION_2.get(), TCPotions.POLLINATING_STEP_POTION_3.get(),
                                TCPotions.POLLINATING_STEP_POTION_4.get(), TCPotions.POLLINATING_STEP_POTION_5.get(), TCPotions.POLLINATING_STEP_POTION_6.get()
                        }
                )
        );

        // Build the long-variant mapping dynamically from the recipe data
        // This ensures getLongVariant() will automatically work for all mod potion tiers
        PotionsHelper.buildLongVariants(allRecipes);

        // Register each recipe dynamically
        for (PotionRecipeData recipeData : allRecipes) {
            Potion basePotion = recipeData.basePotion();

            for (int i = 0; i < recipeData.tierPotions().length; i++) {
                Item ingredient = recipeData.tierIngredients()[Math.min(i, recipeData.tierIngredients().length - 1)];
                Potion outputPotion = recipeData.tierPotions()[i];

                // NORMAL potion recipe
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(basePotion, ingredient, outputPotion));

                // NEW: Long (extended duration) potion
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(outputPotion, Items.REDSTONE, PotionsHelper.getLongVariant(outputPotion)));

                // NEW: Splash potion
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(outputPotion, Items.GUNPOWDER, PotionsHelper.getSplash(outputPotion)));

                // NEW: Lingering potion
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(PotionsHelper.getSplash(outputPotion), Items.DRAGON_BREATH, PotionsHelper.getLingering(outputPotion)));

                // Next tier uses current output as input
                basePotion = outputPotion;
            }
        }
    }

    /**
     * Holds the data for one potion progression
     */
    public record PotionRecipeData(Potion basePotion, Item[] tierIngredients, Potion[] tierPotions) {
    }
}