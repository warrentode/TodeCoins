package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.conditions.season.*;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.ExplorationMapFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class ModChestLootTablesGen extends ChestLoot {
    // time checks
    public static final LootItemCondition.Builder IS_NIGHT = TimeCheck.time(IntRange.range(12000, 23000));
    // weather checks
    public static final LootItemCondition.Builder IS_THUNDERING = WeatherCheck.weather().setThundering(true);

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
    // dimension/level checks
    public static final LootItemCondition.Builder IN_THE_END = LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.END));
    public static final LootItemCondition.Builder IN_OVERWORLD = LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.OVERWORLD));
    public static final LootItemCondition.Builder IN_NETHER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.NETHER));
    // event/holiday/season checks
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

    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.ENDONIAN_MATERIALS_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(3, 5))
                                .setBonusRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(ModItems.ENDONIAN_CURRENCY_STAMP.get()).setWeight(1).setQuality(1))
                                .add(LootItem.lootTableItem(ModItems.ENDONIAN_NUGGET.get()).setWeight(1).setQuality(4))
                                .add(LootItem.lootTableItem(ModItems.ENDONIAN_INGOT.get()).setWeight(1).setQuality(5))
                                .add(LootItem.lootTableItem(ModBlocks.ENDONIAN_BLOCK.get()).setWeight(1).setQuality(6))
                                .add(LootItem.lootTableItem(Items.CHORUS_FLOWER).setWeight(10).setQuality(0)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))))
                                .add(LootItem.lootTableItem(Items.ENDER_PEARL).setWeight(10).setQuality(0)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))))
                        ));
        consumer.accept(ModBuiltInLootTables.LEPRECHAUN_CHEST,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(Items.MAP)
                                        .apply(ExplorationMapFunction.makeExplorationMap()
                                                .setDestination(StructureTags.ON_TREASURE_MAPS)
                                                .setMapDecoration(MapDecoration.Type.RED_X)
                                                .setZoom((byte) 1)
                                                .setSkipKnownStructures(false))
                                        .apply(SetNameFunction.setName(Component.translatable("filled_map.buried_treasure")))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHEST_LOOT))
                        ));
        consumer.accept(ModBuiltInLootTables.BANKER_CHEST,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.CURRENCY_STAMP.get())))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHEST_LOOT))
                        ));
        // injected loot table
        consumer.accept(ModBuiltInLootTables.TODECOINS_CHEST_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_COPPER_COIN_LOOT)
                                        .setWeight(7).setQuality(0).when(LootItemRandomChanceCondition.randomChance(0.8F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_IRON_COIN_LOOT)
                                        .setWeight(6).setQuality(1).when(LootItemRandomChanceCondition.randomChance(0.7F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_GOLD_COIN_LOOT)
                                        .setWeight(5).setQuality(2).when(LootItemRandomChanceCondition.randomChance(0.6F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_LOOT)
                                        .setWeight(5).setQuality(2).when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)).when(LootItemRandomChanceCondition.randomChance(0.5F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ENDONIAN_COIN_LOOT)
                                        .setWeight(5).setQuality(2).when(IN_END_CITY).when(LootItemRandomChanceCondition.randomChance(0.4F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT)
                                        .setWeight(4).setQuality(3).when(LootItemRandomChanceCondition.randomChance(0.3F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_LOOT)
                                        .setWeight(4).setQuality(4).when(IN_NETHER).when(LootItemRandomChanceCondition.randomChance(0.2F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT)
                                        .setWeight(3).setQuality(4).when(LootItemRandomChanceCondition.randomChance(0.3F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_LOOT)
                                        .setWeight(2).setQuality(5).when(LootItemRandomChanceCondition.randomChance(0.1F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.COLLECTIBLE_COIN_CHEST_LOOT)
                                        .setWeight(1).setQuality(0).when(LootItemRandomChanceCondition.randomChance(0.5F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_LOOT)
                                        .setWeight(1).setQuality(6).when(LootItemRandomChanceCondition.randomChance(0.001F)))
                        ));
        // tables used in other chest loot tables
        consumer.accept(ModBuiltInLootTables.TODECOINS_COPPER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 7.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 7.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.COPPER_COIN_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_IRON_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 6.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.IRON_COIN.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.IRON_COIN_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_GOLD_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.GOLD_COIN_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).setWeight(1)
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()).setWeight(1)
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_ENDONIAN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.ENDONIAN_COIN.get()).setWeight(1)
                                        .when(IN_END_CITY)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.ENDONIAN_COIN_BAG.get()).setWeight(1)
                                        .when(IN_END_CITY))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 3.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 3.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 2.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_BANK_NOTE_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.LUCKY_COIN.get()))
                        ));

        consumer.accept(ModBuiltInLootTables.RASCAL_COIN_REWARD,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_RASCAL_COIN.get()).when(SPRING).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_RASCAL_COIN.get()).when(IN_OVERWORLD.invert()))
                                .add(LootItem.lootTableItem(ModItems.IRON_RASCAL_COIN.get()).when(SUMMER).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_RASCAL_COIN.get()).when(IN_OVERWORLD.invert()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_RASCAL_COIN.get()).when(AUTUMN).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.GOLD_RASCAL_COIN.get()).when(IN_OVERWORLD.invert()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_RASCAL_COIN.get()).when(WINTER).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_RASCAL_COIN.get()).when(IN_OVERWORLD.invert()))
                        ));
    }
}