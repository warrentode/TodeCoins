package com.github.warrentode.todecoins.recipe;

import com.github.warrentode.todecoins.TodeCoins;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TodeCoins.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, TodeCoins.MODID);

    public static final RegistryObject<RecipeSerializer<CoinPressRecipe>> COINPRESS_SERIALIZER =
            SERIALIZERS.register("coinpress", CoinPressRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<CoinPressRecipe>> RECIPE_TYPE_COINPRESS =
            RECIPE_TYPE.register("coinpress", () -> CoinPressRecipe.Type.INSTANCE);

    public static final RecipeBookType COINPRESS_BOOK = RecipeBookType.create("COINPRESS");

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        RECIPE_TYPE.register(eventBus);
    }
}