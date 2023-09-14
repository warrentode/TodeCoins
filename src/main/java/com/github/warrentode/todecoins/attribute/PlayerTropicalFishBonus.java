package com.github.warrentode.todecoins.attribute;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerTropicalFishBonus {
    private final LivingEntity entity;
    private static int tropicalFishBonus;
    private static int tropicalFishModifier;
    private static final int MIN_BONUS = 0;
    private static final int MAX_BONUS = 1;

    public PlayerTropicalFishBonus(@Nullable LivingEntity entity) {
        this.entity = entity;
    }

    public static int getBonus() {
        return tropicalFishBonus;
    }

    public static void setBonus(int bonus) {
        tropicalFishBonus = bonus;
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

    public void copyFrom(@NotNull PlayerTropicalFishBonus source) {
        source.tropicalFishBonus = getBonus();
    }

    public void saveNBTData(@NotNull CompoundTag nbt) {
        nbt.putInt("tropical_fish_bonus", tropicalFishBonus);
    }

    public void loadNBTData(@NotNull CompoundTag nbt) {
        tropicalFishBonus = nbt.getInt("tropical_fish_bonus");
    }
}