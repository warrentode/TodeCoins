package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.datagen.RecipesGen.*;

public class RepairRecipes extends RecipeProvider implements IConditionBuilder {
    public RepairRecipes(@NotNull DataGenerator generator) {
        super(generator.getPackOutput());
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        register(consumer);
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        bracelets(consumer);
        collectibleCoins(consumer);
    }

    private static void bracelets(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.BRACELET_FRIENDSHIP_EMERALD.get(), 1)
                .group("bracelets")
                .requires(TCItems.ENDONIAN_THREAD.get())
                .requires(TCItems.EMERALD_THREAD.get())
                .requires(TCItems.BRACELET_FRIENDSHIP_EMERALD.get())
                .unlockedBy("has_emerald_friendship_bracelet",
                        has(TCItems.BRACELET_FRIENDSHIP_EMERALD.get()))
                .save(consumer, setLocation(MODID, "repair/bracelets/" +
                        TCItems.BRACELET_FRIENDSHIP_EMERALD.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,TCItems.BRACELET_FRIENDSHIP_ECHO.get(), 1)
                .group("bracelets")
                .requires(TCItems.ENDONIAN_THREAD.get())
                .requires(TCItems.ECHO_THREAD.get())
                .requires(TCItems.BRACELET_FRIENDSHIP_ECHO.get())
                .unlockedBy("has_echo_friendship_bracelet",
                        has(TCItems.BRACELET_FRIENDSHIP_ECHO.get()))
                .save(consumer, setLocation(MODID, "repair/bracelets/" +
                        TCItems.BRACELET_FRIENDSHIP_ECHO.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,TCItems.BRACELET_FRIENDSHIP_ENDONIAN.get(), 1)
                .group("bracelets")
                .requires(TCItems.ENDONIAN_THREAD.get())
                .requires(TCItems.ENDONIAN_THREAD.get())
                .requires(TCItems.BRACELET_FRIENDSHIP_ENDONIAN.get())
                .unlockedBy("has_endonian_friendship_bracelet",
                        has(TCItems.BRACELET_FRIENDSHIP_ENDONIAN.get()))
                .save(consumer, setLocation(MODID, "repair/bracelets/" +
                        TCItems.BRACELET_FRIENDSHIP_ENDONIAN.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,TCItems.BRACELET_FRIENDSHIP_LUCKY.get(), 1)
                .group("bracelets")
                .requires(TCItems.ENDONIAN_THREAD.get())
                .requires(TCItems.LUCKY_THREAD.get())
                .requires(TCItems.BRACELET_FRIENDSHIP_LUCKY.get())
                .unlockedBy("has_lucky_friendship_bracelet",
                        has(TCItems.BRACELET_FRIENDSHIP_LUCKY.get()))
                .save(consumer, setLocation(MODID, "repair/bracelets/" +
                        TCItems.BRACELET_FRIENDSHIP_LUCKY.get()));
    }

    private static void collectibleCoins(Consumer<FinishedRecipe> consumer) {
        getCoinByMaterial().forEach((material, coins) -> {
            Item nugget = getNuggetForCoin(material);
            for (CollectibleCoinItem coin : coins) {
                String coinPath = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(coin)).getPath();
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, coin, 1)
                        .group("collectible_coins")
                        .requires(coin)
                        .requires(nugget)
                        .unlockedBy("has_" + coinPath, has(coin))
                        .save(consumer, setLocation(MODID, "repair/collectible_coins/" + coinPath));
            }
        });
    }
}