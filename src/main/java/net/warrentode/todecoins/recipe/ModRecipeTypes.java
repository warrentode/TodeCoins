package net.warrentode.todecoins.recipe;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MODID);
    
    public static final RegistryObject<RecipeType<CoinPressRecipe>> COINPRESS = RECIPE_TYPES.register("coinpress",
            () -> registerRecipeType("coinpress"));
    
    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<>() {
            public String toString() {
                return MODID + ":" + identifier;
            }
        };
    }
}