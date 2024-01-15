package com.github.warrentode.todecoins.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CRIMSON_SPORE_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 0.9F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.1F).build();

    public static final FoodProperties WARPED_SPICE_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 0.9F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.1F).build();

    public static final FoodProperties MILK_BONE_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 0.9F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 0.1F).build();

    public static final FoodProperties ULTIMATE_DARK_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 600, 0), 0.9F)
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 600, 0), 0.1F).build();

    public static final FoodProperties BUBBLY_BERRY_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0), 1.0F).build();

    public static final FoodProperties VELVETY_CLOVER_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 600, 0), 1.0F).build();

    public static final FoodProperties FESTIVE_FUDGE_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0F).build();

    public static final FoodProperties FUEGO_FUDGE_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1.0F).build();

    public static final FoodProperties CARMEL_CRISP_CHOCOLATE_COIN = new FoodProperties.Builder()
            .alwaysEat().fast().nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F).build();
}