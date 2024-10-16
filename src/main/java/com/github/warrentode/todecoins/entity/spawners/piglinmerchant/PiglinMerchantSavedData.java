package com.github.warrentode.todecoins.entity.spawners.piglinmerchant;

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

// AUTHOR: MrCrayfish https://github.com/MrCrayfish/GoblinTraders/tree/1.19.X- modified for my mod,
// not sure how else to set the data up for this so it doesn't bug out
public class PiglinMerchantSavedData extends SavedData {
    private static final String DATA_NAME = MODID + "piglinmerchant";
    private final Map<String, PiglinMerchantData> data = new HashMap<>();

    public PiglinMerchantSavedData() {}

    public PiglinMerchantData getPiglinMerchantData(String key) {
        return this.data.computeIfAbsent(key, s -> new PiglinMerchantData(this));
    }

    public PiglinMerchantSavedData read(@NotNull CompoundTag tag) {
        if (tag.contains("PiglinMerchantSpawnDelay", Tag.TAG_INT)) {
            this.getPiglinMerchantData("PiglinMerchant").setPiglinMerchantSpawnDelay(tag.getInt("PiglinMerchantSpawnDelay"));
        }
        if (tag.contains("PiglinMerchantSpawnChance", Tag.TAG_INT)) {
            this.getPiglinMerchantData("PiglinMerchant").setPiglinMerchantSpawnChance(tag.getInt("PiglinMerchantSpawnChance"));
        }
        if (tag.contains("Data", Tag.TAG_LIST)) {
            this.data.clear();
            ListTag list = tag.getList("Data", Tag.TAG_COMPOUND);
            list.forEach(nbt -> {
                CompoundTag todePiglinMerchantTag = (CompoundTag) nbt;
                String key = todePiglinMerchantTag.getString("Key");
                PiglinMerchantData data = new PiglinMerchantData(this);
                data.read(todePiglinMerchantTag);
                this.data.put(key, data);
            });
        }
        return this;
    }

    @Override
    public @NotNull CompoundTag save(@NotNull CompoundTag compound) {
        ListTag list = new ListTag();
        this.data.forEach((s, todePiglinMerchantData) -> {
            CompoundTag todePiglinMerchantTag = new CompoundTag();
            todePiglinMerchantData.write(todePiglinMerchantTag);
            todePiglinMerchantTag.putString("Key", s);
            list.add(todePiglinMerchantTag);
        });
        compound.put("Data", list);
        return compound;
    }

    public static PiglinMerchantSavedData get(@NotNull MinecraftServer server) {
        ServerLevel serverLevel = server.createCommandSourceStack().getLevel();
        return serverLevel.getDataStorage().computeIfAbsent(tag -> new PiglinMerchantSavedData().read(tag), PiglinMerchantSavedData::new, DATA_NAME);
    }
}