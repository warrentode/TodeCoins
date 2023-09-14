package com.github.warrentode.todecoins.attribute;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerPufferfishBonus {
    private final LivingEntity entity;
    private static int pufferfishBonus;
    private static int pufferfishModifier;
    private static final int MIN_BONUS = 0;
    private static final int MAX_BONUS = 1;

    public PlayerPufferfishBonus(@Nullable LivingEntity entity) {
        this.entity = entity;
    }

    public static int getBonus() {
        return pufferfishBonus;
    }

    public static void setBonus(int bonus) {
        pufferfishBonus = bonus;
    }

    public static void addBonus(int addedBonus) {
        if (getBonus() == MIN_BONUS) {
            setBonus(getBonus() + addedBonus);
        }
        else if (getBonus() > MAX_BONUS) {
            setBonus(MAX_BONUS);
        }
    }

    public static void subtractBonus(int subtractedBonus) {
        if (getBonus() > MIN_BONUS) {
            setBonus(getBonus() - subtractedBonus);
        }
        else if (getBonus() < MIN_BONUS) {
            setBonus(MIN_BONUS);
        }
    }

    public void copyFrom(@NotNull PlayerPufferfishBonus source) {
        source.pufferfishBonus = getBonus();
    }

    public void saveNBTData(@NotNull CompoundTag nbt) {
        nbt.putInt("pufferfish_bonus", pufferfishBonus);
    }

    public void loadNBTData(@NotNull CompoundTag nbt) {
        pufferfishBonus = nbt.getInt("pufferfish_bonus");
    }
}