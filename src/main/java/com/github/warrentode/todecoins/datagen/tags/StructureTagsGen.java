package com.github.warrentode.todecoins.datagen.tags;

import com.github.warrentode.todecoins.util.tags.ForgeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.level.levelgen.structure.BuiltinStructures.*;

public class StructureTagsGen extends StructureTagsProvider {
    public StructureTagsGen(DataGenerator pGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.registerForgeTags();
    }

    private void registerForgeTags() {
        tag(ForgeTags.StructureTags.ON_ANCIENT_CITY_EXPLORER_MAPS)
                .add(ANCIENT_CITY);
        tag(ForgeTags.StructureTags.ON_BASTION_REMNANT_EXPLORER_MAPS)
                .add(BASTION_REMNANT);
        tag(ForgeTags.StructureTags.ON_DESERT_PYRAMID_EXPLORER_MAPS)
                .add(DESERT_PYRAMID);
        tag(ForgeTags.StructureTags.ON_END_CITY_EXPLORER_MAPS)
                .add(END_CITY);
        tag(ForgeTags.StructureTags.ON_IGLOO_EXPLORER_MAPS)
                .add(IGLOO);
        tag(ForgeTags.StructureTags.ON_JUNGLE_TEMPLE_EXPLORER_MAPS)
                .add(JUNGLE_TEMPLE);
        tag(ForgeTags.StructureTags.ON_MINESHAFT_EXPLORER_MAPS)
                .add(MINESHAFT)
                .add(MINESHAFT_MESA);
        tag(ForgeTags.StructureTags.ON_NETHER_FORTRESS_EXPLORER_MAPS)
                .add(FORTRESS);
        tag(ForgeTags.StructureTags.ON_NETHER_FOSSIL_EXPLORER_MAPS)
                .add(NETHER_FOSSIL);
        tag(ForgeTags.StructureTags.ON_NETHER_RUINED_PORTAL_EXPLORER_MAPS)
                .add(RUINED_PORTAL_NETHER);
        tag(ForgeTags.StructureTags.ON_OCEAN_RUIN_EXPLORER_MAPS)
                .add(OCEAN_RUIN_WARM)
                .add(OCEAN_RUIN_COLD);
        tag(ForgeTags.StructureTags.ON_OCEAN_MONUMENT_EXPLORER_MAPS)
                .add(OCEAN_MONUMENT);
        tag(ForgeTags.StructureTags.ON_OVERWORLD_RUINED_PORTAL_EXPLORER_MAPS)
                .add(RUINED_PORTAL_STANDARD)
                .add(RUINED_PORTAL_DESERT)
                .add(RUINED_PORTAL_JUNGLE)
                .add(RUINED_PORTAL_SWAMP)
                .add(RUINED_PORTAL_MOUNTAIN)
                .add(RUINED_PORTAL_OCEAN);
        tag(ForgeTags.StructureTags.ON_PILLAGER_OUTPOST_EXPLORER_MAPS)
                .add(PILLAGER_OUTPOST);
        tag(ForgeTags.StructureTags.ON_WOODLAND_EXPLORER_MAPS)
                .add(WOODLAND_MANSION);
        tag(ForgeTags.StructureTags.ON_SHIPWRECK_EXPLORER_MAPS)
                .add(SHIPWRECK)
                .add(SHIPWRECK_BEACHED);
        tag(ForgeTags.StructureTags.ON_STRONGHOLD_EXPLORER_MAPS)
                .add(STRONGHOLD);
        tag(ForgeTags.StructureTags.ON_SWAMP_HUT_EXPLORER_MAPS)
                .add(SWAMP_HUT);
        tag(ForgeTags.StructureTags.ON_VILLAGE_EXPLORER_MAPS)
                .add(VILLAGE_DESERT)
                .add(VILLAGE_PLAINS)
                .add(VILLAGE_SAVANNA)
                .add(VILLAGE_SNOWY)
                .add(VILLAGE_TAIGA);
        tag(ForgeTags.StructureTags.ON_TREASURE_MAPS)
                .add(BURIED_TREASURE);
    }
}