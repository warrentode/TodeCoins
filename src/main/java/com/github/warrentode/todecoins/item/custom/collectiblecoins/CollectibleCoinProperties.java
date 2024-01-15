package com.github.warrentode.todecoins.item.custom.collectiblecoins;

import java.util.function.Supplier;

public class CollectibleCoinProperties {

    public enum Material {
        COPPER(() -> 256, () -> 1200, () -> 0),
        IRON(() -> 256, () -> 1800, () -> 1),
        GOLDEN(() -> 256, () -> 2400, () -> 2),
        NETHERITE(() -> 256, () -> 1200, () -> 0),
        ENDONIAN(() -> 320, () -> 1800, () -> 1);

        public static final Material[] COIN_MATERIALS = values();

        public static Material get(int ordinal) {
            return COIN_MATERIALS[ordinal];
        }

        private final Supplier<Integer> coinMaxDurability;
        private final Supplier<Integer> materialEffectDuration;
        private final Supplier<Integer> materialEffectAmplifier;

        Material(Supplier<Integer> coinMaxDurability, Supplier<Integer> materialEffectDuration, Supplier<Integer> materialEffectAmplifier) {
            this.coinMaxDurability = coinMaxDurability;
            this.materialEffectDuration = materialEffectDuration;
            this.materialEffectAmplifier = materialEffectAmplifier;
        }

        public Material getCoinMaterial() {
            return get(ordinal());
        }

        public Integer getCoinMaxDurability() {
            return this.coinMaxDurability.get();
        }

        public Integer getCoinMaterialEffectDuration() {
            return this.materialEffectDuration.get();
        }

        public Integer getCoinMaterialEffectAmplifier() {
            return this.materialEffectAmplifier.get();
        }
    }
}