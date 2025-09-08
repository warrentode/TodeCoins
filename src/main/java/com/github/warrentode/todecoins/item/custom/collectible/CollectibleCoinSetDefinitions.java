package com.github.warrentode.todecoins.item.custom.collectible;

import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.effect.TCMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;

public enum CollectibleCoinSetDefinitions {
    AERIAL_COIN_SET(MobEffects.SLOW_FALLING, Attributes.FLYING_SPEED, 0.1),
    AQUATIC_COIN_SET(MobEffects.WATER_BREATHING, Attributes.MOVEMENT_SPEED, 0.1),
    ARTHROPOD_COIN_SET(TCMobEffects.ARTHROPOD_BLIGHT.get(), Attributes.ATTACK_DAMAGE, 1.0),
    BLAZE_COIN_SET(TCMobEffects.BURNING_STRIKE.get(), Attributes.ATTACK_DAMAGE, 1.0),
    BREEDABLE_COIN_SET(MobEffects.HEALTH_BOOST, Attributes.MAX_HEALTH, 10.0),
    CELEBRATION_COIN_SET(MobEffects.HERO_OF_THE_VILLAGE, Attributes.LUCK, 1.0),
    FISH_COIN_SET(TCMobEffects.FISHERMANS_BLESSING.get(), Attributes.MOVEMENT_SPEED, 1.0),
    GOLEM_COIN_SET(MobEffects.DAMAGE_RESISTANCE, Attributes.ATTACK_KNOCKBACK, 1.0),
    HUMANOID_COIN_SET(TCMobEffects.THORN_SHIELD.get(), ModAttributes.CHARISMA.get(), 1.0),
    MISC_COIN_SET(MobEffects.ABSORPTION, Attributes.ARMOR, 1.0),
    PIGLIN_COIN_SET(MobEffects.FIRE_RESISTANCE, Attributes.ARMOR_TOUGHNESS, 1.0),
    RAIDER_COIN_SET(TCMobEffects.ILLAGER_BANE.get(), Attributes.ATTACK_DAMAGE, 1.0),
    SLIME_COIN_SET(MobEffects.JUMP, Attributes.JUMP_STRENGTH, 0.1),
    STEED_COIN_SET(MobEffects.MOVEMENT_SPEED, Attributes.MOVEMENT_SPEED, 0.1),
    UNDEAD_COIN_SET(TCMobEffects.HOLY_STRIKE.get(), Attributes.ARMOR, 1.0),
    WILD_ANIMAL_COIN_SET(MobEffects.DAMAGE_BOOST, Attributes.ARMOR_TOUGHNESS, 1.0);

    private final MobEffect setEffect;
    private final Attribute setAttribute;
    private final double setAttributeValue; // store as double for all attributes

    CollectibleCoinSetDefinitions(MobEffect setEffect, Attribute setAttribute, double setAttributeValue) {
        this.setEffect = setEffect;
        this.setAttribute = setAttribute;
        this.setAttributeValue = setAttributeValue;
    }

    public MobEffect getSetEffect() {
        return setEffect;
    }

    public Attribute getSetAttribute() {
        return setAttribute;
    }

    public double getSetAttributeValue() {
        return setAttributeValue;
    }

    public int getSetAttributeValueAsInt() {
        return (int) Math.round(setAttributeValue); // convert to int when needed
    }

    public static String getEffectTooltipString(MobEffect coinEffect) {
        return coinEffect.getDescriptionId();
    }
}