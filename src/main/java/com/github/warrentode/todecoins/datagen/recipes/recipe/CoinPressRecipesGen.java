package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.datagen.recipes.builder.CoinPressRecipeBuilder;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.recipe.recipebook.CoinPressRecipeBookTab;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class CoinPressRecipesGen {
    public static final int BASIC_STAMP_TIME = 50;
    public static final int NETHER_STAMP_TIME = 75;
    public static final int ENDONIAN_STAMP_TIME = 100;

    public static final float BASIC_XP = 0.35F;
    public static final float NETHER_XP = 0.65F;
    public static final float ENDONIAN_XP = 0.95F;

    public static void register(Consumer<FinishedRecipe> consumer) {
        stampCoins(consumer);
        stampNotes(consumer);
    }

    private static void stampCoins(Consumer<FinishedRecipe> consumer) {
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.COPPER_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.CURRENCY_STAMP.get())
                .addIngredient(TCItemTags.COPPER_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.CURRENCY_STAMP.get()))
                .build(consumer);

        CoinPressRecipeBuilder.coinPressRecipe(TCItems.IRON_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.CURRENCY_STAMP.get())
                .addIngredient(TCItemTags.IRON_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.GOLD_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.CURRENCY_STAMP.get())
                .addIngredient(TCItemTags.GOLD_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.NETHERITE_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.CURRENCY_STAMP.get())
                .addIngredient(TCItemTags.NETHERITE_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.LUCKY_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.CURRENCY_STAMP.get())
                .addIngredient(TCItemTags.LUCKY_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.NETHER_GOLD_COIN.get(), 1, NETHER_STAMP_TIME, NETHER_XP)
                .addIngredient(TCItems.NETHER_CURRENCY_STAMP.get())
                .addIngredient(TCItemTags.GOLD_INGOT)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_nether_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.NETHER_CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.ENDONIAN_COIN.get(), 2, ENDONIAN_STAMP_TIME, ENDONIAN_XP)
                .addIngredient(TCItems.ENDONIAN_CURRENCY_STAMP.get())
                .addIngredient(TCItemTags.ENDONIAN_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_endonian_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ENDONIAN_CURRENCY_STAMP.get()))
                .build(consumer);

        CoinPressRecipeBuilder.coinPressRecipe(TCItems.LAPIS_FLORIN.get(), 8, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.GEM_CURRENCY_STAMP.get())
                .addIngredient(Tags.Items.GEMS_LAPIS)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_gem_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.GEM_CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.AMETHYST_FLORIN.get(), 4, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.GEM_CURRENCY_STAMP.get())
                .addIngredient(Tags.Items.GEMS_AMETHYST)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_gem_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.GEM_CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.DIAMOND_FLORIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.GEM_CURRENCY_STAMP.get())
                .addIngredient(Tags.Items.GEMS_DIAMOND)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_gem_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.GEM_CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.EMERALD_FLORIN.get(), 1, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.GEM_CURRENCY_STAMP.get())
                .addIngredient(Tags.Items.GEMS_EMERALD)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_gem_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.GEM_CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.ECHO_FLORIN.get(), 1, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.GEM_CURRENCY_STAMP.get())
                .addIngredient(Items.ECHO_SHARD)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_gem_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.GEM_CURRENCY_STAMP.get()))
                .build(consumer);
    }

    private static void stampNotes(Consumer<FinishedRecipe> consumer) {
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.EMERALD_QUARTER_BANK_NOTE.get(), 1, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.CURRENCY_STAMP.get())
                .addIngredient(TCItems.EMERALD_COARSE_WOVE_PAPER.get())
                .setRecipeBookTab(CoinPressRecipeBookTab.BANK_NOTES)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.EMERALD_HALF_BANK_NOTE.get(), 1, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.CURRENCY_STAMP.get())
                .addIngredient(TCItems.EMERALD_WOVE_PAPER.get())
                .setRecipeBookTab(CoinPressRecipeBookTab.BANK_NOTES)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(TCItems.EMERALD_BANK_NOTE.get(), 1, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(TCItems.CURRENCY_STAMP.get())
                .addIngredient(TCItems.EMERALD_SMOOTH_WOVE_PAPER.get())
                .setRecipeBookTab(CoinPressRecipeBookTab.BANK_NOTES)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.CURRENCY_STAMP.get()))
                .build(consumer);
    }
}