package com.github.warrentode.todecoins.entity.spawners.numismatist;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

// AUTHOR: MrCrayfish https://github.com/MrCrayfish/GoblinTraders - modified for my mod,
// not sure how else to set the data up for this so it doesn't bug out
public class NumismatistSavedData extends SavedData {
    private static final String DATA_NAME = MODID + "numismatist";

    private final Map<String, NumismatistData> data = new HashMap<>();

    public NumismatistSavedData() {
    }

    public NumismatistData getNumismatistData(String key) {
        return this.data.computeIfAbsent(key, s -> new NumismatistData(this));
    }

    public NumismatistSavedData read(@NotNull CompoundTag tag) {
        if (tag.contains("NumismatistSpawnDelay", Tag.TAG_INT)) {
            this.getNumismatistData("Numismatist").setNumismatistSpawnDelay(tag.getInt("NumismatistSpawnDelay"));
        }
        if (tag.contains("NumismatistSpawnChance", Tag.TAG_INT)) {
            this.getNumismatistData("Numismatist").setNumismatistSpawnChance(tag.getInt("NumismatistSpawnChance"));
        }
        if (tag.contains("Data", Tag.TAG_LIST)) {
            this.data.clear();
            ListTag list = tag.getList("Data", Tag.TAG_COMPOUND);
            list.forEach(nbt -> {
                CompoundTag todeNumismatistTag = (CompoundTag) nbt;
                String key = todeNumismatistTag.getString("Key");
                NumismatistData data = new NumismatistData(this);
                data.read(todeNumismatistTag);
                this.data.put(key, data);
            });
        }
        return this;
    }

    @Override
    public @NotNull CompoundTag save(@NotNull CompoundTag compound) {
        ListTag list = new ListTag();
        this.data.forEach((s, todeNumismatistData) -> {
            CompoundTag todeNumismatistTag = new CompoundTag();
            todeNumismatistData.write(todeNumismatistTag);
            todeNumismatistTag.putString("Key", s);
            list.add(todeNumismatistTag);
        });
        compound.put("Data", list);
        return compound;
    }

    public static NumismatistSavedData get(@NotNull MinecraftServer server) {
        ServerLevel serverLevel = server.createCommandSourceStack().getLevel();
        return serverLevel.getDataStorage().computeIfAbsent(tag -> new NumismatistSavedData().read(tag), NumismatistSavedData::new, DATA_NAME);
    }
}