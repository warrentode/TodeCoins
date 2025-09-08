package com.github.warrentode.todecoins.datagen.tags;

import com.github.warrentode.todecoins.entity.villager.TCVillagers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class PoiTypeTagsGen extends PoiTypeTagsProvider {
    public PoiTypeTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(net.minecraft.tags.PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .add(Objects.requireNonNull(TCVillagers.BANKER_POI.getKey()))
                .add(Objects.requireNonNull(TCVillagers.LEPRECHAUN_POI.getKey()));
    }
}