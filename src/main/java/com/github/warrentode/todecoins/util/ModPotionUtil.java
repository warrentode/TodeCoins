package com.github.warrentode.todecoins.util;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;

import java.util.List;

public class ModPotionUtil {

    /**
     * Sets the potion type for an ItemStack.
     *
     * @param stack  The ItemStack to modify
     * @param potion The potion to apply
     */
    public static void setPotion(ItemStack stack, Potion potion) {
        PotionUtils.setPotion(stack, potion);
    }

    /**
     * Returns the potion type from an ItemStack.
     *
     * @param stack The ItemStack to check
     * @return The potion contained in the stack
     */
    public static Potion getPotion(ItemStack stack) {
        return PotionUtils.getPotion(stack);
    }

    /**
     * Returns a list of all active potion effects on an ItemStack.
     *
     * @param stack The ItemStack to inspect
     * @return List of EffectInstance
     */
    public static List<MobEffectInstance> getEffectsFromStack(ItemStack stack) {
        return PotionUtils.getCustomEffects(stack);
    }

    /**
     * Sets custom potion effects for an ItemStack.
     *
     * @param stack   The ItemStack to modify
     * @param effects List of EffectInstance to apply
     */
    public static void setCustomPotionEffects(ItemStack stack, List<MobEffectInstance> effects) {
        PotionUtils.setCustomEffects(stack, effects);
    }
}