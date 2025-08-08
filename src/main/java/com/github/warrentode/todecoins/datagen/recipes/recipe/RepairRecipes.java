package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class RepairRecipes extends RecipeProvider implements IConditionBuilder {
    public RepairRecipes(DataGenerator pGenerator) {
        super(pGenerator);
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        copperCoins(consumer);
        ironCoins(consumer);
        goldCoins(consumer);
        netheriteCoins(consumer);
        endonianCoins(consumer);
        bracelets(consumer);
    }

    @SuppressWarnings("removal")
    private static void bracelets(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.BRACELET_FRIENDSHIP_EMERALD.get(), 1)
                .group("bracelets")
                .requires(ModItems.ENDONIAN_THREAD.get())
                .requires(ModItems.EMERALD_THREAD.get())
                .requires(ModItems.BRACELET_FRIENDSHIP_EMERALD.get())
                .unlockedBy("has_emerald_friendship_bracelet",
                        has(ModItems.BRACELET_FRIENDSHIP_EMERALD.get()))
                .save(consumer, new ResourceLocation(MODID, "bracelet_repair/" +
                        ModItems.BRACELET_FRIENDSHIP_EMERALD.get()));

        ShapelessRecipeBuilder.shapeless(ModItems.BRACELET_FRIENDSHIP_ECHO.get(), 1)
                .group("bracelets")
                .requires(ModItems.ENDONIAN_THREAD.get())
                .requires(ModItems.ECHO_THREAD.get())
                .requires(ModItems.BRACELET_FRIENDSHIP_ECHO.get())
                .unlockedBy("has_echo_friendship_bracelet",
                        has(ModItems.BRACELET_FRIENDSHIP_ECHO.get()))
                .save(consumer, new ResourceLocation(MODID, "bracelet_repair/" +
                        ModItems.BRACELET_FRIENDSHIP_ECHO.get()));

        ShapelessRecipeBuilder.shapeless(ModItems.BRACELET_FRIENDSHIP_ENDONIAN.get(), 1)
                .group("bracelets")
                .requires(ModItems.ENDONIAN_THREAD.get())
                .requires(ModItems.ENDONIAN_THREAD.get())
                .requires(ModItems.BRACELET_FRIENDSHIP_ENDONIAN.get())
                .unlockedBy("has_endonian_friendship_bracelet",
                        has(ModItems.BRACELET_FRIENDSHIP_ENDONIAN.get()))
                .save(consumer, new ResourceLocation(MODID, "bracelet_repair/" +
                        ModItems.BRACELET_FRIENDSHIP_ENDONIAN.get()));

        ShapelessRecipeBuilder.shapeless(ModItems.BRACELET_FRIENDSHIP_LUCKY.get(), 1)
                .group("bracelets")
                .requires(ModItems.ENDONIAN_THREAD.get())
                .requires(ModItems.LUCKY_THREAD.get())
                .requires(ModItems.BRACELET_FRIENDSHIP_LUCKY.get())
                .unlockedBy("has_lucky_friendship_bracelet",
                        has(ModItems.BRACELET_FRIENDSHIP_LUCKY.get()))
                .save(consumer, new ResourceLocation(MODID, "bracelet_repair/" +
                        ModItems.BRACELET_FRIENDSHIP_LUCKY.get()));
    }

    private static void copperCoins(Consumer<FinishedRecipe> consumer) {
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ALLAY_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ARMADILLO_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_AXOLOTL_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_BAT_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_BEE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_BLAZE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_WILDFIRE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_CAMEL_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_CAVE_SPIDER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_CHICKEN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_COPPER_GOLEM_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_COW_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_CRAB_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_CREEPER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SLIME_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_MAGMA_CUBE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_DOLPHIN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_DONKEY_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ENDER_DRAGON_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_DROWNED_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ENDERMAN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ENDERMITE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_EVOKER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_CAT_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_OCELOT_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_FOX_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_FROG_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_GHAST_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_GIANT_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_GLARE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_GLOW_SQUID_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_GOAT_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_GUARD_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_GUARDIAN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ELDER_GUARDIAN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_HOGLIN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_HORSE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ICEOLOGER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ILLUSIONER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_IRON_GOLEM_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_LLAMA_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_MAULER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_MOOBLOOM_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_MOOSHROOM_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_MULE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_NUMISMATIST_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PANDA_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PARROT_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PENGUIN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PHANTOM_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PIG_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PIGLIN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PIGLIN_BRUTE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PIGLIN_MERCHANT_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PILLAGER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_POLAR_BEAR_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_RABBIT_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_RASCAL_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_RAVAGER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SHEEP_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SHULKER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SILVERFISH_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SKELETON_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SKELETON_HORSE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SNIFFER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SNOW_GOLEM_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SPIDER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SQUID_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SQUIRREL_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_STRAY_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_STRIDER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_TADPOLE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_TRADER_LLAMA_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_TUFF_GOLEM_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_TURTLE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_VEX_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_VILLAGER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_VINDICATOR_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_WANDERING_TRADER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_WARDEN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_WITCH_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_WITHER_SKELETON_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_WITHER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_WOLF_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ZOGLIN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ZOMBIE_HORSE_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_COD_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_PUFFERFISH_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_SALMON_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_TROPICAL_FISH_COIN.get());
        copperCoinRepairRecipe(consumer, ModItems.COPPER_HERO_COIN.get());
    }

    @SuppressWarnings("removal")
    private static void copperCoinRepairRecipe(Consumer<FinishedRecipe> consumer, Item coin) {
        ShapelessRecipeBuilder.shapeless(coin, 1)
                .group("collectible_coins_copper")
                .requires(TodeCoinsTags.Items.COPPER_NUGGET)
                .requires(coin)
                .unlockedBy("has_copper_nugget", has(TodeCoinsTags.Items.COPPER_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "collectible_coin_repair/copper/" + coin));
    }

    private static void ironCoins(Consumer<FinishedRecipe> consumer) {
        ironCoinRepairRecipe(consumer, ModItems.IRON_ALLAY_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ARMADILLO_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_AXOLOTL_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_BAT_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_BEE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_BLAZE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_WILDFIRE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_CAMEL_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_CAVE_SPIDER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_CHICKEN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_COPPER_GOLEM_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_COW_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_CRAB_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_CREEPER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SLIME_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_MAGMA_CUBE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_DOLPHIN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_DONKEY_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ENDER_DRAGON_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_DROWNED_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ENDERMAN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ENDERMITE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_EVOKER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_CAT_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_OCELOT_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_FOX_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_FROG_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_GHAST_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_GIANT_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_GLARE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_GLOW_SQUID_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_GOAT_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_GUARD_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_GUARDIAN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ELDER_GUARDIAN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_HOGLIN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_HORSE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ICEOLOGER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ILLUSIONER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_IRON_GOLEM_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_LLAMA_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_MAULER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_MOOBLOOM_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_MOOSHROOM_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_MULE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_NUMISMATIST_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PANDA_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PARROT_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PENGUIN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PHANTOM_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PIG_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PIGLIN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PIGLIN_BRUTE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PIGLIN_MERCHANT_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PILLAGER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_POLAR_BEAR_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_RABBIT_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_RASCAL_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_RAVAGER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SHEEP_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SHULKER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SILVERFISH_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SKELETON_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SKELETON_HORSE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SNIFFER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SNOW_GOLEM_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SPIDER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SQUID_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SQUIRREL_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_STRAY_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_STRIDER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_TADPOLE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_TRADER_LLAMA_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_TUFF_GOLEM_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_TURTLE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_VEX_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_VILLAGER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_VINDICATOR_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_WANDERING_TRADER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_WARDEN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_WITCH_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_WITHER_SKELETON_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_WITHER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_WOLF_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ZOGLIN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ZOMBIE_HORSE_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_ZOMBIE_VILLAGER_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_COD_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_PUFFERFISH_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_SALMON_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_TROPICAL_FISH_COIN.get());
        ironCoinRepairRecipe(consumer, ModItems.IRON_HERO_COIN.get());
    }

    @SuppressWarnings("removal")
    private static void ironCoinRepairRecipe(Consumer<FinishedRecipe> consumer, Item coin) {
        ShapelessRecipeBuilder.shapeless(coin, 1)
                .group("collectible_coins_iron")
                .requires(TodeCoinsTags.Items.IRON_NUGGET)
                .requires(coin)
                .unlockedBy("has_iron_nugget", has(TodeCoinsTags.Items.IRON_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "collectible_coin_repair/iron/" + coin));
    }

    private static void goldCoins(Consumer<FinishedRecipe> consumer) {
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ALLAY_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ARMADILLO_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_AXOLOTL_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_BAT_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_BEE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_BLAZE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_WILDFIRE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_CAMEL_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_CAVE_SPIDER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_CHICKEN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_COPPER_GOLEM_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_COW_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_CRAB_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_CREEPER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SLIME_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_MAGMA_CUBE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_DOLPHIN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_DONKEY_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ENDER_DRAGON_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_DROWNED_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ENDERMAN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ENDERMITE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_EVOKER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_CAT_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_OCELOT_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_FOX_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_FROG_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_GHAST_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_GIANT_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_GLARE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_GLOW_SQUID_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_GOAT_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_GUARD_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_GUARDIAN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ELDER_GUARDIAN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_HOGLIN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_HORSE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ICEOLOGER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ILLUSIONER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_IRON_GOLEM_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_LLAMA_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_MAULER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_MOOBLOOM_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_MOOSHROOM_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_MULE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_NUMISMATIST_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PANDA_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PARROT_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PENGUIN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PHANTOM_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PIG_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PIGLIN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PIGLIN_BRUTE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PIGLIN_MERCHANT_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PILLAGER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_POLAR_BEAR_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_RABBIT_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_RASCAL_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_RAVAGER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SHEEP_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SHULKER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SILVERFISH_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SKELETON_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SKELETON_HORSE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SNIFFER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SNOW_GOLEM_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SPIDER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SQUID_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SQUIRREL_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_STRAY_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_STRIDER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_TADPOLE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_TRADER_LLAMA_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_TUFF_GOLEM_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_TURTLE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_VEX_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_VILLAGER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_VINDICATOR_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_WANDERING_TRADER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_WARDEN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_WITCH_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_WITHER_SKELETON_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_WITHER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_WOLF_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ZOGLIN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ZOMBIE_HORSE_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_COD_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_PUFFERFISH_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_SALMON_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_TROPICAL_FISH_COIN.get());
        goldCoinRepairRecipe(consumer, ModItems.GOLD_HERO_COIN.get());
    }

    @SuppressWarnings("removal")
    private static void goldCoinRepairRecipe(Consumer<FinishedRecipe> consumer, Item coin) {
        ShapelessRecipeBuilder.shapeless(coin, 1)
                .group("collectible_coins_gold")
                .requires(TodeCoinsTags.Items.GOLD_NUGGET)
                .requires(coin)
                .unlockedBy("has_gold_nugget", has(TodeCoinsTags.Items.GOLD_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "collectible_coin_repair/gold/" + coin));
    }

    private static void netheriteCoins(Consumer<FinishedRecipe> consumer) {
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ALLAY_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ARMADILLO_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_AXOLOTL_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_BAT_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_BEE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_BLAZE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_WILDFIRE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_CAMEL_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_CAVE_SPIDER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_CHICKEN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_COPPER_GOLEM_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_COW_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_CRAB_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_CREEPER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SLIME_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_MAGMA_CUBE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_DOLPHIN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_DONKEY_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ENDER_DRAGON_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_DROWNED_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ENDERMAN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ENDERMITE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_EVOKER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_CAT_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_OCELOT_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_FOX_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_FROG_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_GHAST_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_GIANT_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_GLARE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_GLOW_SQUID_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_GOAT_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_GUARD_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_GUARDIAN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_HOGLIN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_HORSE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ICEOLOGER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ILLUSIONER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_IRON_GOLEM_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_LLAMA_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_MAULER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_MOOBLOOM_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_MOOSHROOM_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_MULE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_NUMISMATIST_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PANDA_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PARROT_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PENGUIN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PHANTOM_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PIG_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PIGLIN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PILLAGER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_POLAR_BEAR_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_RABBIT_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_RASCAL_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_RAVAGER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SHEEP_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SHULKER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SILVERFISH_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SKELETON_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SKELETON_HORSE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SNIFFER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SNOW_GOLEM_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SPIDER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SQUID_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SQUIRREL_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_STRAY_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_STRIDER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_TADPOLE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_TRADER_LLAMA_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_TUFF_GOLEM_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_TURTLE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_VEX_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_VILLAGER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_VINDICATOR_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_WANDERING_TRADER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_WARDEN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_WITCH_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_WITHER_SKELETON_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_WITHER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_WOLF_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ZOGLIN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_COD_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_PUFFERFISH_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_SALMON_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_TROPICAL_FISH_COIN.get());
        netheriteCoinRepairRecipe(consumer, ModItems.NETHERITE_HERO_COIN.get());
    }

    @SuppressWarnings("removal")
    private static void netheriteCoinRepairRecipe(Consumer<FinishedRecipe> consumer, Item coin) {
        ShapelessRecipeBuilder.shapeless(coin, 1)
                .group("collectible_coins_netherite")
                .requires(TodeCoinsTags.Items.NETHERITE_NUGGET)
                .requires(coin)
                .unlockedBy("has_netherite_nugget", has(TodeCoinsTags.Items.NETHERITE_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "collectible_coin_repair/netherite/" + coin));
    }

    private static void endonianCoins(Consumer<FinishedRecipe> consumer) {
        endonianCoinRepairRecipe(consumer, ModItems.BIRTHDAY_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.CHRISTMAS_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.EASTER_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.HALLOWEEN_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.NEW_YEAR_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.MARSHALL_NASH_CARNATION_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.MARSHALL_NASH_COSMOS_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.MARSHALL_NASH_SUNFLOWER_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.SCHOLAR_OWL_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.TUXEDO_CAT_COIN.get());
        endonianCoinRepairRecipe(consumer, ModItems.LITTLE_BEAR_COIN.get());
    }

    @SuppressWarnings("removal")
    private static void endonianCoinRepairRecipe(Consumer<FinishedRecipe> consumer, Item coin) {
        ShapelessRecipeBuilder.shapeless(coin, 1)
                .group("collectible_coins_endonian")
                .requires(TodeCoinsTags.Items.ENDONIAN_NUGGET)
                .requires(coin)
                .unlockedBy("has_endonian_nugget", has(TodeCoinsTags.Items.ENDONIAN_NUGGET))
                .save(consumer, new ResourceLocation(MODID, "collectible_coin_repair/endonian/" + coin));
    }
}