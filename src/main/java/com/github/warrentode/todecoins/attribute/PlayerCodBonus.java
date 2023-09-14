package com.github.warrentode.todecoins.attribute;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerCodBonus {
    private final LivingEntity entity;
    private static int codBonus;
    private static int codModifier;
    private static final int MIN_BONUS = 0;
    private static final int MAX_BONUS = 1;

    public PlayerCodBonus(@Nullable LivingEntity entity) {
        this.entity = entity;
    }

    public static int getBonus() {
        return codBonus;
    }

    public static void setBonus(int bonus) {
        codBonus = bonus;
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

    public void copyFrom(@NotNull PlayerCodBonus source) {
        source.codBonus = getBonus();
    }

    public void saveNBTData(@NotNull CompoundTag nbt) {
        nbt.putInt("cod_bonus", codBonus);
    }

    public void loadNBTData(@NotNull CompoundTag nbt) {
        codBonus = nbt.getInt("cod_bonus");
    }
}