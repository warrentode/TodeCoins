package com.github.warrentode.todecoins.item.custom.bracelet;

import java.util.function.Supplier;

public enum BraceletProperties {
    EMERALD(() -> 32, () -> 2400),
    ENDONIAN(() -> 64, () -> 1200),
    ECHO(() -> 128, () -> 600),
    LUCKY(() -> 256, () -> 300);

    public static final BraceletProperties[] braceletMaterials = values();

    public static BraceletProperties get(int ordinal) {
        return braceletMaterials[ordinal];
    }

    private final Supplier<Integer> braceletDurability;
    private final Supplier<Integer> braceletCooldown;

    BraceletProperties(Supplier<Integer> braceletDurability, Supplier<Integer> braceletCooldown) {
        this.braceletDurability = braceletDurability;
        this.braceletCooldown = braceletCooldown;
    }

    public BraceletProperties getMaterials() {
        return get(ordinal());
    }

    public int getMaxUses() {
        return this.braceletDurability.get();
    }

    public int getCooldown() {
        return this.braceletCooldown.get();
    }
}