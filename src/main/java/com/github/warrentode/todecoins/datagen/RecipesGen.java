package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.datagen.recipes.recipe.*;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinItem;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinMaterial;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class RecipesGen extends RecipeProvider {
    private final PackOutput output;

    public RecipesGen(PackOutput output) {
        super(output);
        this.output = output;
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        CraftingRecipesGen.register(consumer);
        CoinPressRecipesGen.register(consumer);
        RepairRecipes.register(consumer);

        ConditionalCageriumRecipesGen condCageRecipes = new ConditionalCageriumRecipesGen(this.output);
        condCageRecipes.register(consumer);

        ConditionalCookingPotRecipesGen condCookPot = new ConditionalCookingPotRecipesGen(this.output);
        condCookPot.register(consumer);

        ConditionalSpawnEggRecipes condEggRecipes = new ConditionalSpawnEggRecipes(this.output);
        condEggRecipes.register(consumer);
    }

    @Contract("_, _ -> new")
    public static @NotNull ResourceLocation setLocation(String modid, String path) {
        return ResourceLocation.parse(modid + ":recipes/" + path);
    }

    public static Item getNuggetForCoin(@NotNull CollectibleCoinMaterial material) {
        return switch (material) {
            case COPPER -> TCItems.COPPER_NUGGET.get();
            case IRON -> Items.IRON_NUGGET;
            case GOLD -> Items.GOLD_NUGGET;
            case NETHERITE -> TCItems.NETHERITE_NUGGET.get();
            case ENDONIAN -> TCItems.ENDONIAN_NUGGET.get();
        };
    }

    public static @NotNull Map<CollectibleCoinMaterial, List<CollectibleCoinItem>> getCoinByMaterial() {
        Map<CollectibleCoinMaterial, List<CollectibleCoinItem>> coinsByMaterial = new EnumMap<>(CollectibleCoinMaterial.class);

        ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> item instanceof CollectibleCoinItem)
                .map(item -> (CollectibleCoinItem) item)
                .forEach(coin -> coinsByMaterial.computeIfAbsent(coin.getMaterial(), coinMaterial -> new ArrayList<>()).add(coin));

        return coinsByMaterial;
    }



}