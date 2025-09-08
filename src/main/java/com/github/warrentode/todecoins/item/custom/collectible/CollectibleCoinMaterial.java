package com.github.warrentode.todecoins.item.custom.collectible;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;

public enum CollectibleCoinMaterial {
    COPPER(32, 1200, 3, Attributes.MAX_HEALTH, 10),
    IRON(48, 1000, 2, Attributes.ATTACK_DAMAGE, 2),
    GOLD(16, 1400, 4, Attributes.LUCK, 1),
    NETHERITE(80, 600, 0, Attributes.ARMOR, 2),
    ENDONIAN(64, 800, 1, Attributes.ATTACK_SPEED, 2);

    private final int maxDurability;
    private final int effectDuration;
    private final int effectAmplifier;
    private final Attribute materialAttribute;
    private final int attributeValue;

    CollectibleCoinMaterial(int maxDurability, int effectDuration, int effectAmplifier, Attribute materialAttribute, int attributeValue) {
        this.maxDurability = maxDurability;
        this.effectDuration = effectDuration;
        this.effectAmplifier = effectAmplifier;
        this.materialAttribute = materialAttribute;
        this.attributeValue = attributeValue;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public int getEffectDuration() {
        return effectDuration;
    }

    public int getEffectAmplifier() {
        return effectAmplifier;
    }

    public Attribute getMaterialAttribute() {
        return materialAttribute;
    }

    public int getAttributeValue() {
        return attributeValue;
    }

    public static CollectibleCoinMaterial fromOrdinal(int ordinal) {
        CollectibleCoinMaterial[] values = values();
        if (ordinal < 0 || ordinal >= values.length) {
            throw new IllegalArgumentException("Invalid ordinal for CollectibleCoinMaterial: " + ordinal);
        }
        return values[ordinal];
    }
}