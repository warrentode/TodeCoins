package net.warrentode.todecoins.datagen.recipes.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.recipe.recipebook.CoinPressRecipeBookTab;
import net.warrentode.todecoins.util.tags.ForgeTags;

import java.util.function.Consumer;

import static net.warrentode.todecoins.datagen.recipes.builder.CoinPressRecipeBuilder.coinPressRecipe;

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
        coinPressRecipe(ModItems.COPPER_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.COPPER_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);

        coinPressRecipe(ModItems.IRON_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.IRON_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        coinPressRecipe(ModItems.GOLD_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.GOLD_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        coinPressRecipe(ModItems.NETHERITE_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.NETHERITE_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        coinPressRecipe(ModItems.LUCKY_COIN.get(), 2, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.LUCKY_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        coinPressRecipe(ModItems.NETHER_GOLD_COIN.get(), 1, NETHER_STAMP_TIME, NETHER_XP)
                .addIngredient(ModItems.NETHER_CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.GOLD_INGOT)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_nether_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHER_CURRENCY_STAMP.get()))
                .build(consumer);
        coinPressRecipe(ModItems.ENDONIAN_COIN.get(), 1, ENDONIAN_STAMP_TIME, ENDONIAN_XP)
                .addIngredient(ModItems.ENDONIAN_CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.ENDONIAN_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_endonian_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDONIAN_CURRENCY_STAMP.get()))
                .build(consumer);
    }

    private static void stampNotes(Consumer<FinishedRecipe> consumer) {
        coinPressRecipe(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ModItems.EMERALD_COARSE_WOVE_PAPER.get())
                .setRecipeBookTab(CoinPressRecipeBookTab.BANK_NOTES)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        coinPressRecipe(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ModItems.EMERALD_WOVE_PAPER.get())
                .setRecipeBookTab(CoinPressRecipeBookTab.BANK_NOTES)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        coinPressRecipe(ModItems.EMERALD_BANK_NOTE.get(), 1, BASIC_STAMP_TIME, BASIC_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ModItems.EMERALD_SMOOTH_WOVE_PAPER.get())
                .setRecipeBookTab(CoinPressRecipeBookTab.BANK_NOTES)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
    }
}