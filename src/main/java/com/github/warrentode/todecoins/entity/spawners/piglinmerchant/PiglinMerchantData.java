package com.github.warrentode.todecoins.entity.spawners.piglinmerchant;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.jetbrains.annotations.NotNull;

// AUTHOR: MrCrayfish https://github.com/MrCrayfish/GoblinTraders/tree/1.19.X - modified for my mod,
// not sure how else to set the data up for this so it doesn't bug out
public class PiglinMerchantData {
    private final PiglinMerchantSavedData piglinMerchantSavedData;
    private int piglinMerchantSpawnDelay;
    private int piglinMerchantSpawnChance;

    public PiglinMerchantData(PiglinMerchantSavedData piglinMerchantSavedData) {
        this.piglinMerchantSavedData = piglinMerchantSavedData;
    }

    public void setPiglinMerchantSpawnDelay(int piglinMerchantSpawnDelay) {
        this.piglinMerchantSpawnDelay = piglinMerchantSpawnDelay;
        this.piglinMerchantSavedData.setDirty(true);
    }

    public void setPiglinMerchantSpawnChance(int piglinMerchantSpawnChance) {
        this.piglinMerchantSpawnChance = piglinMerchantSpawnChance;
        this.piglinMerchantSavedData.setDirty(true);
    }

    public int getPiglinMerchantSpawnDelay() {
        return piglinMerchantSpawnDelay;
    }

    public int getPiglinMerchantSpawnChance() {
        return piglinMerchantSpawnChance;
    }

    public void read(@NotNull CompoundTag compound) {
        if (compound.contains("PiglinMerchantSpawnDelay", Tag.TAG_INT)) {
            this.piglinMerchantSpawnDelay = compound.getInt("PiglinMerchantSpawnDelay");
        }
        if (compound.contains("PiglinMerchantSpawnChance", Tag.TAG_INT)) {
            this.piglinMerchantSpawnChance = compound.getInt("PiglinMerchantSpawnChance");
        }
    }

    public void write(@NotNull CompoundTag compound) {
        compound.putInt("PiglinMerchantSpawnDelay", this.piglinMerchantSpawnDelay);
        compound.putInt("PiglinMerchantSpawnChance", this.piglinMerchantSpawnChance);
    }
}