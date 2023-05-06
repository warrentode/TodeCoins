package net.warrentode.todecoins.datagen.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.warrentode.todecoins.villager.ModVillagers;
import org.jetbrains.annotations.Nullable;

public class PoiTypeTagsGen extends PoiTypeTagsProvider {
    public PoiTypeTagsGen(DataGenerator pGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(net.minecraft.tags.PoiTypeTags.ACQUIRABLE_JOB_SITE).add(
                ModVillagers.BANKER_POI.get(),
                ModVillagers.LEPRECHAUN_POI.get()
        );
    }
}