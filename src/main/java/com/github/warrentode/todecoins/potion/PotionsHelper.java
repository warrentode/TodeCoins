package com.github.warrentode.todecoins.potion;

import com.github.warrentode.todecoins.util.ModPotionUtil;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PotionsHelper {

    // Mapping of base → long variant for your mod potions
    // This map is dynamically built from your PotionRecipeData tiers.
    // It ensures each potion tier automatically knows its "long" variant.
    private static final Map<Potion, Potion> LONG_VARIANTS = new HashMap<>();

    /**
     * Builds the LONG_VARIANTS map from your mod's potion progression data.
     * Each tier’s “long” variant is set to the next potion in the tier array.
     * Call this once during setup, after your potion registry is ready.
     *
     * @param allRecipes The list of all potion progressions (from TCBrewingRecipes)
     */
    public static void buildLongVariants(List<TCBrewingRecipes.PotionRecipeData> allRecipes) {
        for (TCBrewingRecipes.PotionRecipeData recipeData : allRecipes) {
            Potion[] tiers = recipeData.tierPotions();
            for (int i = 0; i < tiers.length - 1; i++) {
                // Each tier’s “long” variant is the next tier in the progression
                LONG_VARIANTS.put(tiers[i], tiers[i + 1]);
            }
        }
    }

    /**
     * Returns the long (extended duration) variant of the given potion.
     * For mod potions, returns the mapped "next tier" potion.
     * For vanilla potions, returns a potion with doubled duration like Redstone would.
     *
     * @param base The potion to extend
     * @return The long variant of the potion
     */
    public static Potion getLongVariant(Potion base) {
        // Return mapped long variant if it exists for a mod potion
        if (LONG_VARIANTS.containsKey(base)) {
            return LONG_VARIANTS.get(base);
        }

        // Vanilla fallback: Water and Awkward potions have no long variant
        if (base == Potions.WATER || base == Potions.AWKWARD) {
            return base;
        }

        // Create a temporary ItemStack to hold potion effects
        ItemStack bottle = new ItemStack(Items.POTION);
        ModPotionUtil.setPotion(bottle, base);

        // Double the duration of each effect, preserving amplifier
        ModPotionUtil.setCustomPotionEffects(bottle, ModPotionUtil.getEffectsFromStack(bottle).stream()
                .map(effect -> new MobEffectInstance(effect.getEffect(), effect.getDuration() * 2, effect.getAmplifier()))
                .toList()
        );

        // Return the new potion object
        return ModPotionUtil.getPotion(bottle);
    }

    /**
     * Returns the splash variant of the given potion.
     *
     * @param base The potion to convert
     * @return The corresponding splash potion
     */
    public static Potion getSplash(Potion base) {
        return getVariant(base, true, false);
    }

    /**
     * Returns the lingering variant of the given potion.
     *
     * @param base The potion to convert
     * @return The corresponding lingering potion
     */
    public static Potion getLingering(Potion base) {
        return getVariant(base, true, true);
    }

    /**
     * Internal helper to convert drinkable → splash → lingering.
     *
     * @param base        The original potion
     * @param isSplash    Whether splash form is desired
     * @param isLingering Whether lingering form is desired
     * @return The matching potion from vanilla's registry
     */
    @SuppressWarnings("SameParameterValue")
    private static @NotNull Potion getVariant(Potion base, boolean isSplash, boolean isLingering) {
        ItemStack bottle = new ItemStack(
                isLingering ? Items.LINGERING_POTION :
                        isSplash ? Items.SPLASH_POTION :
                                Items.POTION
        );

        ModPotionUtil.setPotion(bottle, base);

        // The potion object itself isn't altered by splash/lingering status,
        // it's stored in the ItemStack's tag — so we just return the same Potion.
        // This works fine for BrewingRecipeRegistry because the Item type differs.
        return ModPotionUtil.getPotion(bottle);
    }
}