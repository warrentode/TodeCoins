package com.github.warrentode.todecoins.datagen.tags;

import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class BiomeTagsGen extends BiomeTagsProvider {
    public BiomeTagsGen(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.BiomesTags.GEM_CURRENCY_BIOMES)
                // underground biomes
                .add(Biomes.LUSH_CAVES)
                .add(Biomes.DRIPSTONE_CAVES)
                .add(Biomes.DEEP_DARK);
        tag(ModTags.BiomesTags.COPPER_CURRENCY_BIOMES)
                // fungus ville
                .add(Biomes.MUSHROOM_FIELDS)
                // oceans and rivers
                .add(Biomes.DEEP_COLD_OCEAN)
                .add(Biomes.COLD_OCEAN)
                .add(Biomes.DEEP_OCEAN)
                .add(Biomes.OCEAN)
                .add(Biomes.DEEP_LUKEWARM_OCEAN)
                .add(Biomes.LUKEWARM_OCEAN)
                .add(Biomes.WARM_OCEAN)
                .add(Biomes.RIVER)
                // shorelines
                .add(Biomes.STONY_SHORE)
                .add(Biomes.BEACH)
                // mountains
                .add(Biomes.STONY_PEAKS)
                // forests
                .add(Biomes.OLD_GROWTH_BIRCH_FOREST)
                .add(Biomes.DARK_FOREST)
                .add(Biomes.BIRCH_FOREST)
                .add(Biomes.FLOWER_FOREST)
                // fields
                .add(Biomes.FOREST)
                .add(Biomes.PLAINS)
                .add(Biomes.SUNFLOWER_PLAINS)
                .add(Biomes.MEADOW);
        tag(ModTags.BiomesTags.IRON_CURRENCY_BIOMES)
                // tropical or subtropical regions
                .add(Biomes.WINDSWEPT_SAVANNA)
                .add(Biomes.WINDSWEPT_FOREST)
                .add(Biomes.WINDSWEPT_GRAVELLY_HILLS)
                .add(Biomes.WINDSWEPT_HILLS)
                .add(Biomes.SAVANNA_PLATEAU)
                .add(Biomes.SAVANNA)
                // boreal or evergreen forests
                .add(Biomes.TAIGA)
                .add(Biomes.OLD_GROWTH_SPRUCE_TAIGA)
                .add(Biomes.OLD_GROWTH_PINE_TAIGA)
                // wetlands
                .add(Biomes.SWAMP)
                .add(Biomes.MANGROVE_SWAMP);
        tag(ModTags.BiomesTags.GOLD_CURRENCY_BIOMES)
                // frozen or snowy biomes
                .add(Biomes.DEEP_FROZEN_OCEAN)
                .add(Biomes.FROZEN_OCEAN)
                .add(Biomes.SNOWY_BEACH)
                .add(Biomes.FROZEN_RIVER)
                .add(Biomes.JAGGED_PEAKS)
                .add(Biomes.FROZEN_PEAKS)
                .add(Biomes.SNOWY_SLOPES)
                .add(Biomes.GROVE)
                .add(Biomes.SNOWY_TAIGA)
                .add(Biomes.SNOWY_PLAINS)
                .add(Biomes.ICE_SPIKES)
                // desert or dry biomes
                .add(Biomes.WOODED_BADLANDS)
                .add(Biomes.ERODED_BADLANDS)
                .add(Biomes.BADLANDS)
                .add(Biomes.DESERT)
                // rainforests
                .add(Biomes.BAMBOO_JUNGLE)
                .add(Biomes.SPARSE_JUNGLE)
                .add(Biomes.JUNGLE);
        tag(ModTags.BiomesTags.NETHER_CURRENCY_BIOMES)
                // nether gold and netherite and quartz
                .add(Biomes.NETHER_WASTES)
                .add(Biomes.WARPED_FOREST)
                .add(Biomes.CRIMSON_FOREST)
                .add(Biomes.SOUL_SAND_VALLEY)
                .add(Biomes.BASALT_DELTAS);
        tag(ModTags.BiomesTags.ENDONIAN_CURRENCY_BIOMES)
                // endonian coin
                .add(Biomes.THE_END)
                .add(Biomes.END_HIGHLANDS)
                .add(Biomes.END_MIDLANDS)
                .add(Biomes.SMALL_END_ISLANDS)
                .add(Biomes.END_BARRENS);
    }
}