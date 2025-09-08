package com.github.warrentode.todecoins.util.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.jetbrains.annotations.NotNull;

public class TCStructureTags {
    public static final TagKey<Structure> ON_ANCIENT_CITY_EXPLORER_MAPS = modStructureTag("worldgen/structure/ancient_city");
    public static final TagKey<Structure> ON_BASTION_REMNANT_EXPLORER_MAPS = modStructureTag("worldgen/structure/bastion_remnant");
    public static final TagKey<Structure> ON_DESERT_PYRAMID_EXPLORER_MAPS = modStructureTag("worldgen/structure/desert_pyramid");
    public static final TagKey<Structure> ON_END_CITY_EXPLORER_MAPS = modStructureTag("worldgen/structure/end_city");
    public static final TagKey<Structure> ON_IGLOO_EXPLORER_MAPS = modStructureTag("worldgen/structure/igloo");
    public static final TagKey<Structure> ON_JUNGLE_TEMPLE_EXPLORER_MAPS = modStructureTag("worldgen/structure/jungle_temple");
    public static final TagKey<Structure> ON_MINESHAFT_EXPLORER_MAPS = modStructureTag("worldgen/structure/mineshaft");
    public static final TagKey<Structure> ON_NETHER_FORTRESS_EXPLORER_MAPS = modStructureTag("worldgen/structure/nether_fortress");
    public static final TagKey<Structure> ON_NETHER_FOSSIL_EXPLORER_MAPS = modStructureTag("worldgen/structure/nether_fossil");
    public static final TagKey<Structure> ON_NETHER_RUINED_PORTAL_EXPLORER_MAPS = modStructureTag("worldgen/structure/nether_ruined_portal");
    public static final TagKey<Structure> ON_OCEAN_RUIN_EXPLORER_MAPS = modStructureTag("worldgen/structure/ocean_ruin");
    public static final TagKey<Structure> ON_OCEAN_MONUMENT_EXPLORER_MAPS = modStructureTag("worldgen/structure/monument");
    public static final TagKey<Structure> ON_OVERWORLD_RUINED_PORTAL_EXPLORER_MAPS = modStructureTag("worldgen/structure/overworld_ruined_portal");
    public static final TagKey<Structure> ON_PILLAGER_OUTPOST_EXPLORER_MAPS = modStructureTag("worldgen/structure/pillager_outpost");
    public static final TagKey<Structure> ON_WOODLAND_EXPLORER_MAPS = modStructureTag("worldgen/structure/mansion");
    public static final TagKey<Structure> ON_SHIPWRECK_EXPLORER_MAPS = modStructureTag("worldgen/structure/shipwreck");
    public static final TagKey<Structure> ON_STRONGHOLD_EXPLORER_MAPS = modStructureTag("worldgen/structure/stronghold");
    public static final TagKey<Structure> ON_SWAMP_HUT_EXPLORER_MAPS = modStructureTag("worldgen/structure/swamp_hut");
    public static final TagKey<Structure> ON_VILLAGE_EXPLORER_MAPS = modStructureTag("worldgen/structure/village");
    public static final TagKey<Structure> ON_TREASURE_MAPS = modStructureTag("worldgen/structure/treasure");

    public static final TagKey<Structure> OVERWORLD_POI = modStructureTag("worldgen/structure/overworld_poi");
    public static final TagKey<Structure> OVERWORLD_END_POI = modStructureTag("worldgen/structure/overworld_end_poi");
    public static final TagKey<Structure> OVERWORLD_NETHER_POI = modStructureTag("worldgen/structure/overworld_nether_poi");

    public static final TagKey<Structure> DESERT_POI = modStructureTag("worldgen/structure/desert_poi");
    public static final TagKey<Structure> JUNGLE_POI = modStructureTag("worldgen/structure/jungle_poi");
    public static final TagKey<Structure> OCEAN_POI = modStructureTag("worldgen/structure/ocean_poi");
    public static final TagKey<Structure> PILLAGER_POI = modStructureTag("worldgen/structure/pillager_poi");
    public static final TagKey<Structure> MISC_POI = modStructureTag("worldgen/structure/misc_poi");
    public static final TagKey<Structure> TREASURE_POI = modStructureTag("worldgen/structure/treasure_poi");
    public static final TagKey<Structure> UNDERGROUND_POI = modStructureTag("worldgen/structure/underground_poi");
    public static final TagKey<Structure> NETHER_POI = modStructureTag("worldgen/structure/nether_poi");
    public static final TagKey<Structure> END_POI = modStructureTag("worldgen/structure/end_poi");
    public static final TagKey<Structure> SETTLEMENT = modStructureTag("worldgen/structure/settlement");
    public static final TagKey<Structure> WITCH_SIGHTING = modStructureTag("worldgen/structure/witch_sighting");
    public static final TagKey<Structure> WAY_SIGN_DESTINATIONS = modStructureTag("supplementaries","worldgen/structure/way_sign_destinations");
    public static final TagKey<Structure> OVERWORLD_SLIME_ISLANDS = modStructureTag("worldgen/structure/overworld_slime_islands");
    public static final TagKey<Structure> NETHER_SLIME_ISLANDS = modStructureTag("worldgen/structure/nether_slime_islands");
    public static final TagKey<Structure> END_SLIME_ISLANDS = modStructureTag("worldgen/structure/end_slime_islands");

    public static @NotNull TagKey<Structure> modStructureTag(String path) {
        return TagKey.create(Registries.STRUCTURE, ResourceLocation.parse("forge:" + path));
    }
    public static @NotNull TagKey<Structure> modStructureTag(String modid, String path) {
        return TagKey.create(Registries.STRUCTURE, ResourceLocation.parse(modid + ":" + path));
    }
}