package com.github.warrentode.todecoins.entity.spawners.numismatist;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.jetbrains.annotations.NotNull;

// AUTHOR: MrCrayfish https://github.com/MrCrayfish/GoblinTraders - modified for my mod,
// not sure how else to set the data up for this so it doesn't bug out
public class NumismatistData {
    private NumismatistSavedData numismatistSavedData;
    private int numismatistSpawnDelay;
    private int numismatistSpawnChance;

    public NumismatistData(NumismatistSavedData numismatistSavedData) {
        this.numismatistSavedData = numismatistSavedData;
    }

    public void setNumismatistSpawnDelay(int numismatistSpawnDelay) {
        this.numismatistSpawnDelay = numismatistSpawnDelay;
        this.numismatistSavedData.setDirty(true);
    }

    public void setNumismatistSpawnChance(int numismatistSpawnChance) {
        this.numismatistSpawnChance = numismatistSpawnChance;
        this.numismatistSavedData.setDirty(true);
    }

    public int getNumismatistSpawnDelay() {
        return numismatistSpawnDelay;
    }

    public int getNumismatistSpawnChance() {
        return numismatistSpawnChance;
    }

    public void read(@NotNull CompoundTag compound) {
        if (compound.contains("NumismatistSpawnDelay", Tag.TAG_INT)) {
            this.numismatistSpawnDelay = compound.getInt("NumismatistSpawnDelay");
        }
        if (compound.contains("NumismatistSpawnChance", Tag.TAG_INT)) {
            this.numismatistSpawnChance = compound.getInt("NumismatistSpawnChance");
        }
    }

    public void write(@NotNull CompoundTag compound) {
        compound.putInt("NumismatistSpawnDelay", this.numismatistSpawnDelay);
        compound.putInt("NumismatistSpawnChance", this.numismatistSpawnChance);
    }
}