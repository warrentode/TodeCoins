package net.warrentode.todecoins.entity.villager.spawner;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.jetbrains.annotations.NotNull;

// AUTHOR: MrCrayfish https://github.com/MrCrayfish/GoblinTraders/tree/1.19.X
public class NumismatistData {
    private NumismatistSavedData data;
    private int numismatistSpawnDelay;
    private int numismatistSpawnChance;

    public NumismatistData(NumismatistSavedData data) {
        this.data = data;
    }

    public void setNumismatistSpawnDelay(int numismatistSpawnDelay) {
        this.numismatistSpawnDelay = numismatistSpawnDelay;
        this.data.setDirty(true);
    }

    public void setNumismatistSpawnChance(int numismatistSpawnChance) {
        this.numismatistSpawnChance = numismatistSpawnChance;
        this.data.setDirty(true);
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