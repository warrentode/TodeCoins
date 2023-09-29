package com.github.warrentode.todecoins.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CRIMSON_SPORE_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100), 0.9F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200), 0.1F).build();

    public static final FoodProperties WARPED_SPICE_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.9F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 0.1F).build();

    public static final FoodProperties MILK_BONE_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100), 0.9F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200), 0.1F).build();

    public static final FoodProperties ULTIMATE_DARK_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 100), 0.9F)
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 200), 0.1F).build();
}