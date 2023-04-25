package net.warrentode.todecoins.datagen.recipes.recipe;

import java.util.function.Consumer;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.warrentode.todecoins.datagen.recipes.builder.CoinPressRecipeBuilder;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.screen.coinpressgui.CoinPressRecipeBookTab;
import net.warrentode.todecoins.util.tags.ForgeTags;

public class CoinPressRecipes {
    public static final int NUGGET_STAMP_TIME = 50;
    public static final int NOTE_STAMP_TIME = 75;
    
    public static final float NUGGET_XP = 0.35F;
    public static final float NOTE_XP = 0.65F;
    
    public static void register(Consumer<FinishedRecipe> consumer) {
        stampCoins(consumer);
        stampNotes(consumer);
    }
    
    private static void stampCoins(Consumer<FinishedRecipe> consumer) {
        CoinPressRecipeBuilder.coinPressRecipe(ModItems.COPPER_COIN.get(), 2, NUGGET_STAMP_TIME, NUGGET_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.COPPER_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        
        CoinPressRecipeBuilder.coinPressRecipe(ModItems.IRON_COIN.get(), 2, NUGGET_STAMP_TIME, NUGGET_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.IRON_INGOT)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(ModItems.GOLD_COIN.get(), 2, NUGGET_STAMP_TIME, NUGGET_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.GOLD_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(ModItems.NETHERITE_COIN.get(), 2, NUGGET_STAMP_TIME, NUGGET_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.NETHERITE_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(ModItems.LUCKY_COIN.get(), 2, NUGGET_STAMP_TIME, NUGGET_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.GOLD_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(ModItems.NETHER_GOLD_COIN.get(), 1, NUGGET_STAMP_TIME, NUGGET_XP)
                .addIngredient(ModItems.NETHER_CURRENCY_STAMP.get())
                .addIngredient(ForgeTags.Items.NETHERITE_NUGGET)
                .setRecipeBookTab(CoinPressRecipeBookTab.COINS)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
    }
    
    private static void stampNotes(Consumer<FinishedRecipe> consumer) {
        CoinPressRecipeBuilder.coinPressRecipe(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1, NOTE_STAMP_TIME, NOTE_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ModItems.EMERALD_COARSE_WOVE_PAPER.get())
                .setRecipeBookTab(CoinPressRecipeBookTab.BANK_NOTES)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1, NOTE_STAMP_TIME, NOTE_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ModItems.EMERALD_WOVE_PAPER.get())
                .setRecipeBookTab(CoinPressRecipeBookTab.BANK_NOTES)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
        CoinPressRecipeBuilder.coinPressRecipe(ModItems.EMERALD_BANK_NOTE.get(), 1, NOTE_STAMP_TIME, NOTE_XP)
                .addIngredient(ModItems.CURRENCY_STAMP.get())
                .addIngredient(ModItems.EMERALD_SMOOTH_WOVE_PAPER.get())
                .setRecipeBookTab(CoinPressRecipeBookTab.BANK_NOTES)
                .unlockedBy("has_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                .build(consumer);
    }
}
