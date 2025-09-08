package com.github.warrentode.todecoins.potion;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import org.jetbrains.annotations.NotNull;
import net.minecraft.world.item.Items;

// BetterBrewingRecipe Class by CAS-ual-TY from https://github.com/CAS-ual-TY/Extra-Potions (GPL-3.0 License)
// https://github.com/CAS-ual-TY/Extra-Potions/blob/main/LICENSE
// Modified by WarrenTode with ChatGPT assistance to support splash and lingering variants automatically.

public class BetterBrewingRecipe implements IBrewingRecipe {
    private final Potion inputPotion;
    private final Item ingredient;
    private final Potion outputPotion;

    public BetterBrewingRecipe(Potion inputPotion, Item ingredient, Potion outputPotion) {
        this.inputPotion = inputPotion;
        this.ingredient = ingredient;
        this.outputPotion = outputPotion;
    }

    @Override
    public final boolean isInput(@NotNull ItemStack stack) {
        // CHANGE: Original version only checked normal potions.
        // This now uses isPotionMatch() to also allow splash and lingering bottles.
        return isPotionMatch(stack, inputPotion);
    }

    @Override
    public final boolean isIngredient(ItemStack stack) {
        // SAME as original — ingredient check is unchanged.
        return stack.getItem() == this.ingredient;
    }

    @Override
    public final @NotNull ItemStack getOutput(@NotNull ItemStack input, @NotNull ItemStack ingredient) {
        // SAME as original — basic validation
        if (!isInput(input) || !isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }

        // CHANGE: Preserve the bottle type (normal, splash, lingering) from the input.
        ItemStack result = new ItemStack(input.getItem());

        // SAME as original — ensure we have a fresh tag and set the new potion
        result.setTag(new CompoundTag());
        PotionUtils.setPotion(result, this.outputPotion);
        return result;
    }

    /**
     * CHANGE: New helper method that allows normal, splash, or lingering bottles
     * and verifies they contain the correct potion.
     */
    private boolean isPotionMatch(ItemStack stack, Potion potion) {
        Item item = stack.getItem();

        // Acceptable bottle types
        if (item != Items.POTION && item != Items.SPLASH_POTION && item != Items.LINGERING_POTION) {
            return false;
        }

        // SAME logic as original for potion comparison
        return PotionUtils.getPotion(stack) == potion;
    }
}