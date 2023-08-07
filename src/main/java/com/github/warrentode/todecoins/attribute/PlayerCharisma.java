package com.github.warrentode.todecoins.attribute;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlayerCharisma {
    private final LivingEntity entity;
    private static int charisma;
    private static int charismaBonus;
    private final int MIN_CHR = 0;
    private static int MAX_CHR = 100;

    public PlayerCharisma(@Nullable LivingEntity entity) {
        this.entity = entity;
    }

    public static int getCharisma() {
        return charisma;
    }

    public static int getCharismaBonus(@NotNull Player player) {
        List<LivingEntity> list = player.level.getEntitiesOfClass(LivingEntity.class,
                player.getBoundingBox().inflate(25, 8, 25),
                EntitySelector.NO_SPECTATORS);

        int charismaBonus = 0;
        //noinspection UnusedAssignment
        for (LivingEntity entity : list) {
            charismaBonus += 10 * getCharisma();
        }

        return Math.min(charismaBonus, MAX_CHR);
    }

    public static void setCharisma(int CHR) {
        charisma = CHR;
    }

    public static void addCharisma(int addedCHR) {
        setCharisma(getCharisma() + addedCHR);
    }

    public static void subtractCharisma(int subtractedCHR) {
        setCharisma(getCharisma() - subtractedCHR);
    }

    public void copyFrom(@NotNull PlayerCharisma source) {
        source.charisma = getCharisma();
    }

    public void saveNBTData(@NotNull CompoundTag nbt) {
        nbt.putInt("charisma", charisma);
    }

    public void loadNBTData(@NotNull CompoundTag nbt) {
        charisma = nbt.getInt("charisma");
    }
}