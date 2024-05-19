package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.datagen.loot_tables.*;
import com.github.warrentode.todecoins.datagen.loot_tables.chest_loot.*;
import com.github.warrentode.todecoins.datagen.loot_tables.entity_drops.*;
import com.github.warrentode.todecoins.datagen.loot_tables.merchant.MerchantOffersGen;
import com.github.warrentode.todecoins.datagen.loot_tables.mystery_coin_packs.*;
import com.github.warrentode.todecoins.loot.conditions.season.*;
import com.github.warrentode.todecoins.loot.conditions.tag.EntityTypeTagCondition;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTableGenProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>>
            loot_tables = ImmutableList.of(
            Pair.of(ModGiftLootGen::new, LootContextParamSets.GIFT),
            Pair.of(ModBlockLootTablesGen::new, LootContextParamSets.BLOCK),
            Pair.of(CustomPiglinBarterLootGen::new, LootContextParamSets.PIGLIN_BARTER),
            Pair.of(ModFishingLootGen::new, LootContextParamSets.FISHING),
            Pair.of(CageriumLootTablesGen::new, LootContextParamSets.ENTITY),
            Pair.of(MerchantOffersGen::new, LootContextParamSets.CHEST),

            Pair.of(CoinDropsEntityGen::new, LootContextParamSets.ENTITY),
            Pair.of(CoinDropsBossGen::new, LootContextParamSets.ENTITY),
            Pair.of(CollectibleCoinDropsHolidayGen::new, LootContextParamSets.ENTITY),
            Pair.of(CollectibleCoinDropsSeasonalGen::new, LootContextParamSets.ENTITY),
            Pair.of(CollectibleCoinDropsSpringGen::new, LootContextParamSets.ENTITY),
            Pair.of(CollectibleCoinDropsSummerGen::new, LootContextParamSets.ENTITY),
            Pair.of(CollectibleCoinDropsAutumnGen::new, LootContextParamSets.ENTITY),
            Pair.of(CollectibleCoinDropsWinterGen::new, LootContextParamSets.ENTITY),

            Pair.of(ModChestLootTablesGen::new, LootContextParamSets.CHEST),
            Pair.of(CollectibleCoinChestGen::new, LootContextParamSets.CHEST),
            Pair.of(CollectibleCoinChestHolidayGen::new, LootContextParamSets.CHEST),
            Pair.of(CollectibleCoinsChestSpringGen::new, LootContextParamSets.CHEST),
            Pair.of(CollectibleCoinsChestSummerGen::new, LootContextParamSets.CHEST),
            Pair.of(CollectibleCoinsChestAutumnGen::new, LootContextParamSets.CHEST),
            Pair.of(CollectibleCoinsChestWinterGen::new, LootContextParamSets.CHEST),

            Pair.of(MysteryCoinPackGen::new, LootContextParamSets.CHEST),
            Pair.of(MysteryCoinPackInvertedGen::new, LootContextParamSets.CHEST),
            Pair.of(MysteryCoinPackSpringGen::new, LootContextParamSets.CHEST),
            Pair.of(MysteryCoinPackSummerGen::new, LootContextParamSets.CHEST),
            Pair.of(MysteryCoinPackAutumnGen::new, LootContextParamSets.CHEST),
            Pair.of(MysteryCoinPackWinterGen::new, LootContextParamSets.CHEST)
    );

    public ModLootTableGenProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return loot_tables;
    }

    @Override
    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationTracker) {
        map.forEach((id, table) -> LootTables.validate(validationTracker, id, table));
    }

    // entity checks
    public static final LootItemCondition.Builder DROPS_CURRENCY =
            EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.DROPS_CURRENCY).build();
    public static final LootItemCondition.Builder DROPS_BOSS_CURRENCY =
            EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.BOSSES).build();

    // dimension checks
    public static final LootItemCondition.Builder IN_OVERWORLD =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.OVERWORLD));
    public static final LootItemCondition.Builder IN_NETHER =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.NETHER));
    public static final LootItemCondition.Builder IN_THE_END =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.END));

    // seasonal checks
    public static final LootItemCondition.Builder BIRTHDAY_EVENT = BirthdayCondition.event();
    public static final LootItemCondition.Builder HALLOWEEN_EVENT = HalloweenCondition.event();
    public static final LootItemCondition.Builder CHRISTMAS_EVENT = ChristmasCondition.event();
    public static final LootItemCondition.Builder EASTER_EVENT = EasterCondition.event();
    public static final LootItemCondition.Builder NEW_YEAR_EVENT = NewYearCondition.event();
    public static final LootItemCondition.Builder ANNIVERSARY_EVENT = AnniversaryCondition.event();
    public static final LootItemCondition.Builder SPRING = SpringCondition.season();
    public static final LootItemCondition.Builder SUMMER = SummerCondition.season();
    public static final LootItemCondition.Builder AUTUMN = AutumnCondition.season();
    public static final LootItemCondition.Builder WINTER = WinterCondition.season();

    // overworld structure checks
    public static final LootItemCondition.Builder IN_IGLOO = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.IGLOO.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_OCEAN.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_DESERT = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_DESERT.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_JUNGLE = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_JUNGLE.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_MOUNTAIN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_MOUNTAIN.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_SWAMP = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_SWAMP.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_STANDARD = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_STANDARD.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_OCEAN_MONUMENT = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.OCEAN_MONUMENT.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_OCEAN_RUIN_WARM = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.OCEAN_RUIN_WARM.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_OCEAN_RUIN_COLD = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.OCEAN_RUIN_COLD.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_ANCIENT_CITY = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.ANCIENT_CITY.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_DESERT_PYRAMID = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.DESERT_PYRAMID.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_JUNGLE_TEMPLE = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.JUNGLE_TEMPLE.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_VILLAGE_DESERT = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.VILLAGE_DESERT.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_VILLAGE_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.VILLAGE_PLAINS.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_VILLAGE_SAVANNA = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.VILLAGE_SAVANNA.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_VILLAGE_SNOWY = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.VILLAGE_SNOWY.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_VILLAGE_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.VILLAGE_TAIGA.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_MINESHAFT = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.MINESHAFT.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_MINESHAFT_MESA = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.MINESHAFT_MESA.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_STRONGHOLD = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.STRONGHOLD.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_SWAMP_HUT = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.SWAMP_HUT.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_PILLAGER_OUTPOST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.PILLAGER_OUTPOST.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_MANSION = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.WOODLAND_MANSION.unwrapKey().orElseThrow()));
    // nether structure checks
    public static final LootItemCondition.Builder IN_NETHER_FORTRESS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.FORTRESS.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_BASTION_REMNANTS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.BASTION_REMNANT.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_NETHER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_NETHER.unwrapKey().orElseThrow()));
    // end structure checks
    public static final LootItemCondition.Builder IN_END_CITY = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.END_CITY.unwrapKey().orElseThrow()));

    // biome checks
    public static final LootItemCondition.Builder IN_STONY_PEAKS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.STONY_PEAKS));
    public static final LootItemCondition.Builder IN_FROZEN_PEAKS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FROZEN_PEAKS));
    public static final LootItemCondition.Builder IN_JAGGED_PEAKS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.JAGGED_PEAKS));
    public static final LootItemCondition.Builder IN_SNOWY_SLOPES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SNOWY_SLOPES));
    public static final LootItemCondition.Builder IN_ICE_SPIKES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.ICE_SPIKES));
    public static final LootItemCondition.Builder IN_SNOWY_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SNOWY_PLAINS));
    public static final LootItemCondition.Builder IN_MUSHROOM_FIELDS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.MUSHROOM_FIELDS));
    public static final LootItemCondition.Builder IN_NETHER_WASTES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.NETHER_WASTES));
    public static final LootItemCondition.Builder IN_WARPED_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WARPED_FOREST));
    public static final LootItemCondition.Builder IN_CRIMSON_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.CRIMSON_FOREST));
    public static final LootItemCondition.Builder IN_BASALT_DELTAS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.BASALT_DELTAS));
    public static final LootItemCondition.Builder IN_SOUL_SAND_VALLEY = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SOUL_SAND_VALLEY));
    public static final LootItemCondition.Builder IN_JUNGLE = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.JUNGLE));
    public static final LootItemCondition.Builder IN_SPARSE_JUNGLE = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SPARSE_JUNGLE));
    public static final LootItemCondition.Builder IN_BAMBOO_JUNGLE = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.BAMBOO_JUNGLE));
    public static final LootItemCondition.Builder IN_DESERT = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DESERT));
    public static final LootItemCondition.Builder IN_BADLANDS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.BADLANDS));
    public static final LootItemCondition.Builder IN_ERODED_BADLANDS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.ERODED_BADLANDS));
    public static final LootItemCondition.Builder IN_WOODED_BADLANDS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WOODED_BADLANDS));
    public static final LootItemCondition.Builder IN_MEADOW = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.MEADOW));
    public static final LootItemCondition.Builder IN_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.PLAINS));
    public static final LootItemCondition.Builder IN_SAVANNA = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SAVANNA));
    public static final LootItemCondition.Builder IN_SAVANNA_PLATEAU = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SAVANNA_PLATEAU));
    public static final LootItemCondition.Builder IN_WINDSWEPT_SAVANNA = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WINDSWEPT_SAVANNA));
    public static final LootItemCondition.Builder IN_WINDSWEPT_HILLS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WINDSWEPT_HILLS));
    public static final LootItemCondition.Builder IN_WINDSWEPT_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WINDSWEPT_FOREST));
    public static final LootItemCondition.Builder IN_WINDSWEPT_GRAVELLY_HILLS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS));
    public static final LootItemCondition.Builder IN_SUNFLOWER_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SUNFLOWER_PLAINS));
    public static final LootItemCondition.Builder IN_SWAMP = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SWAMP));
    public static final LootItemCondition.Builder IN_MANGROVE_SWAMP = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.MANGROVE_SWAMP));
    public static final LootItemCondition.Builder IN_GROVE = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.GROVE));
    public static final LootItemCondition.Builder IN_SNOWY_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SNOWY_TAIGA));
    public static final LootItemCondition.Builder IN_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.TAIGA));
    public static final LootItemCondition.Builder IN_OLD_GROWTH_PINE_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.OLD_GROWTH_PINE_TAIGA));
    public static final LootItemCondition.Builder IN_OLD_GROWTH_SPRUCE_TAIGA = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA));
    public static final LootItemCondition.Builder IN_FLOWER_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FLOWER_FOREST));
    public static final LootItemCondition.Builder IN_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FOREST));
    public static final LootItemCondition.Builder IN_BIRCH_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.BIRCH_FOREST));
    public static final LootItemCondition.Builder IN_DARK_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DARK_FOREST));
    public static final LootItemCondition.Builder IN_OLD_GROWTH_BIRCH_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.OLD_GROWTH_BIRCH_FOREST));
    public static final LootItemCondition.Builder IN_DRIPSTONE_CAVES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DRIPSTONE_CAVES));
    public static final LootItemCondition.Builder IN_LUSH_CAVES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.LUSH_CAVES));
    public static final LootItemCondition.Builder IN_DEEP_DARK = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_DARK));
    public static final LootItemCondition.Builder IN_BEACH = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.BEACH));
    public static final LootItemCondition.Builder IN_STONY_SHORE = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.STONY_SHORE));
    public static final LootItemCondition.Builder IN_SNOWY_BEACH = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SNOWY_BEACH));
    public static final LootItemCondition.Builder IN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_OCEAN));
    public static final LootItemCondition.Builder IN_LUKEWARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.LUKEWARM_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_LUKEWARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_LUKEWARM_OCEAN));
    public static final LootItemCondition.Builder IN_COLD_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.COLD_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_COLD_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_COLD_OCEAN));
    public static final LootItemCondition.Builder IN_RIVER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.RIVER));
    public static final LootItemCondition.Builder IN_FROZEN_RIVER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FROZEN_RIVER));
    public static final LootItemCondition.Builder IN_FROZEN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FROZEN_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_FROZEN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_FROZEN_OCEAN));
    public static final LootItemCondition.Builder IN_WARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WARM_OCEAN));

}