package com.github.warrentode.todecoins.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

// helper class for ore in step 2
public class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier modifierList, PlacementModifier placementModifier) {
        return List.of(modifierList, InSquarePlacement.spread(), placementModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinSize, PlacementModifier heightRange) {
        // in-game count placement determines the number of blocks in a vein
        return orePlacement(CountPlacement.of(veinSize), heightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
    }
}