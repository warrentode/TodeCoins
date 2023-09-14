package com.github.warrentode.todecoins.attribute;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerSalmonBonus {
    private final LivingEntity entity;
    private static int salmonBonus;
    private static int salmonModifier;
    private static final int MIN_BONUS = 0;
    private static final int MAX_BONUS = 1;

    public PlayerSalmonBonus(@Nullable LivingEntity entity) {
        this.entity = entity;
    }

    public static int getBonus() {
        return salmonBonus;
    }

    public static void setBonus(int bonus) {
        salmonBonus = bonus;
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

    public void copyFrom(@NotNull PlayerSalmonBonus source) {
        source.salmonBonus = getBonus();
    }

    public void saveNBTData(@NotNull CompoundTag nbt) {
        nbt.putInt("salmon_bonus", salmonBonus);
    }

    public void loadNBTData(@NotNull CompoundTag nbt) {
        salmonBonus = nbt.getInt("salmon_bonus");
    }
}