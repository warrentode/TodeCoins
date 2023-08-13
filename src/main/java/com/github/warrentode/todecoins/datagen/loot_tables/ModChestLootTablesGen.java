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

import java.util.function.BiConsumer;

public class ModChestLootTablesGen extends ChestLoot {
    // time checks
    public static final LootItemCondition.Builder IS_NIGHT = TimeCheck.time(IntRange.range(12000, 23000));
    // weather checks
    public static final LootItemCondition.Builder IS_THUNDERING = WeatherCheck.weather().setThundering(true);

    // structure checks
    public static final LootItemCondition.Builder IN_IGLOO = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.IGLOO.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_OCEAN.unwrapKey().orElseThrow()));
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
    public static final LootItemCondition.Builder IN_NETHER_FORTRESS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.FORTRESS.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_BASTION_REMNANTS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.BASTION_REMNANT.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_NETHER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_NETHER.unwrapKey().orElseThrow()));
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
    public static final LootItemCondition.Builder ANNIVERSARY_EVENT = AnniversaryCondition.event();
    public static final LootItemCondition.Builder SPRING = SpringCondition.season();
    public static final LootItemCondition.Builder SUMMER = SummerCondition.season();
    public static final LootItemCondition.Builder AUTUMN = AutumnCondition.season();
    public static final LootItemCondition.Builder WINTER = WinterCondition.season();

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
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
                                        .setWeight(7).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_IRON_COIN_LOOT)
                                        .setWeight(6).setQuality(1))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_GOLD_COIN_LOOT)
                                        .setWeight(5).setQuality(2))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_LOOT)
                                        .setWeight(5).setQuality(2).when(IN_NETHER))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ENDONIAN_COIN_LOOT)
                                        .setWeight(5).setQuality(2).when(IN_THE_END))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT)
                                        .setWeight(4).setQuality(3))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_LOOT)
                                        .setWeight(4).setQuality(4))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT)
                                        .setWeight(3).setQuality(4))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_LOOT)
                                        .setWeight(2).setQuality(5))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_COLLECTIBLE_COIN_LOOT)
                                        .setWeight(1).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_LOOT)
                                        .setWeight(1).setQuality(6))
                        ));
        // tables used in other chest loot tables
        consumer.accept(ModBuiltInLootTables.TODECOINS_COLLECTIBLE_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 7.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT)
                                        .when(BIRTHDAY_EVENT).setWeight(7).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT)
                                        .when(ANNIVERSARY_EVENT).setWeight(7).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT)
                                        .when(HALLOWEEN_EVENT).setWeight(7).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT)
                                        .when(CHRISTMAS_EVENT).setWeight(7).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_SPRING_COIN_LOOT)
                                        .when(SPRING).setWeight(1).setQuality(6))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_SUMMER_COIN_LOOT)
                                        .when(SUMMER).setWeight(1).setQuality(6))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_AUTUMN_COIN_LOOT)
                                        .when(AUTUMN).setWeight(1).setQuality(6))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_WINTER_COIN_LOOT)
                                        .when(WINTER).setWeight(1).setQuality(6))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_COPPER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 7.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 7.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.COPPER_COIN_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_IRON_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 6.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.IRON_COIN.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.IRON_COIN_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_GOLD_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.GOLD_COIN_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).setWeight(1).when(IN_NETHER)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()).setWeight(1).when(IN_NETHER))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_ENDONIAN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.ENDONIAN_COIN.get()).setWeight(1).when(IN_THE_END)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()).setWeight(1).when(IN_THE_END))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 3.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 3.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 2.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get()).setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_BANK_NOTE_BAG.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.LUCKY_COIN.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .when(BIRTHDAY_EVENT)
                                .add(LootItem.lootTableItem(ModItems.BIRTHDAY_COIN_2023.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .when(CHRISTMAS_EVENT)
                                .add(LootItem.lootTableItem(ModItems.CHRISTMAS_COIN_2023.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .when(HALLOWEEN_EVENT)
                                .add(LootItem.lootTableItem(ModItems.HALLOWEEN_COIN_2023.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .when(ANNIVERSARY_EVENT)
                                // newest coins weight = total number of entries
                                .add(LootItem.lootTableItem(ModItems.LITTLE_BEAR_COIN.get())
                                        .setQuality(0).setWeight(7))
                                .add(LootItem.lootTableItem(ModItems.TUXEDO_CAT_COIN.get())
                                        .setQuality(0).setWeight(7))
                                .add(LootItem.lootTableItem(ModItems.SCHOLAR_OWL_COIN.get())
                                        .setQuality(0).setWeight(7))
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_COSMOS_COIN.get())
                                        .setQuality(0).setWeight(7))
                                .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get())
                                        .setQuality(0).setWeight(7))
                                // old coins weight = 1
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_CARNATION_COIN.get())
                                        .setQuality(0).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get())
                                        .setQuality(0).setWeight(1))
                        ));
        // entity coins by season
        consumer.accept(ModBuiltInLootTables.TODECOINS_SPRING_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ALLAY_COIN.get())
                                        .when(IN_MANSION.or(IN_PILLAGER_OUTPOST)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_AXOLOTL_COIN.get())
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES)
                                                .or(IN_LUSH_CAVES)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_BAT_COIN.get())
                                        .when(IN_SWAMP_HUT.or(IN_MINESHAFT).or(IN_MINESHAFT_MESA)
                                                .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES).or(IN_STRONGHOLD)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_BEE_COIN.get())
                                        .when(IN_MEADOW.or(IN_PLAINS).or(IN_SUNFLOWER_PLAINS)
                                                .or(IN_MANGROVE_SWAMP).or(IN_FLOWER_FOREST).or(IN_FOREST)
                                                .or(IN_BIRCH_FOREST).or(IN_OLD_GROWTH_BIRCH_FOREST)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_BLAZE_COIN.get())
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_CAMEL_COIN.get())
                                        .when(IN_DESERT).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_CAT_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_CAVE_SPIDER_COIN.get())
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_CHICKEN_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_COD_COIN.get())
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_LUKEWARM_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN).or(IN_BEACH).or(IN_STONY_SHORE)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_COW_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMAN_COIN.get())
                                        .when(IN_WARPED_FOREST.or(IN_THE_END)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_FOX_COIN.get())
                                        .when(IN_GROVE.or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_FROG_COIN.get())
                                        .when(IN_MANGROVE_SWAMP.or(IN_SWAMP)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_MOOBLOOM_COIN.get())
                                        .when(IN_FLOWER_FOREST.or(IN_MEADOW).or(IN_SUNFLOWER_PLAINS)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_MOOSHROOM_COIN.get())
                                        .when(IN_MUSHROOM_FIELDS).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_OCELOT_COIN.get())
                                        .when(IN_JUNGLE.or(IN_SPARSE_JUNGLE).or(IN_BAMBOO_JUNGLE)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_COIN.get())
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_PUFFERFISH_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                                .or(IN_BEACH).or(IN_STONY_SHORE)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SALMON_COIN.get())
                                        .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_BEACH)
                                                .or(IN_STONY_SHORE).or(IN_SNOWY_BEACH)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_TROPICAL_FISH_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                                .or(IN_MANGROVE_SWAMP).or(IN_LUSH_CAVES)
                                                .or(IN_BEACH).or(IN_STONY_SHORE)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_COIN.get())
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_SAVANNA).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_DONKEY_COIN.get())
                                        .when(IN_PLAINS.or(IN_MEADOW).or(IN_SUNFLOWER_PLAINS).or(IN_SAVANNA).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_MULE_COIN.get())
                                        .when(IN_VILLAGE_SAVANNA.or(IN_VILLAGE_DESERT).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SKELETON_HORSE_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)
                                                .or(IN_ANCIENT_CITY).or(IN_JUNGLE_TEMPLE).or(IN_DESERT_PYRAMID)
                                                .or(IN_STRONGHOLD).or(IN_NETHER_FORTRESS).or(IN_RUINED_PORTAL_NETHER)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOMBIE_HORSE_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)
                                                .or(IN_ANCIENT_CITY).or(IN_JUNGLE_TEMPLE).or(IN_DESERT_PYRAMID).or(IN_STRONGHOLD)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SQUID_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_GLOW_SQUID_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_PARROT_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_JUNGLE.or(IN_BAMBOO_JUNGLE)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_HOGLIN_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_CRIMSON_FOREST.or(IN_BASTION_REMNANTS)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_PIG_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_FOREST).or(IN_SWAMP)
                                                .or(IN_MANGROVE_SWAMP).or(IN_SAVANNA_PLATEAU).or(IN_SAVANNA)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_BIRCH_FOREST).or(IN_BIRCH_FOREST).or(IN_JUNGLE)
                                                .or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE).or(IN_VILLAGE_TAIGA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_RABBIT_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_SNOWY_SLOPES).or(IN_GROVE)
                                                .or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA).or(IN_MEADOW)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_DESERT)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SHEEP_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_FOREST).or(IN_SWAMP)
                                                .or(IN_MANGROVE_SWAMP).or(IN_SAVANNA_PLATEAU).or(IN_SAVANNA)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_BIRCH_FOREST).or(IN_BIRCH_FOREST).or(IN_JUNGLE)
                                                .or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE).or(IN_VILLAGE_TAIGA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SNIFFER_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN_RUIN_COLD.or(IN_OCEAN_RUIN_WARM)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_NUMISMATIST_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_WANDERING_TRADER_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_VILLAGER_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SNOW_GOLEM_COIN.get()).when(SPRING)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_SNOWY_TAIGA).or(IN_GROVE)
                                                .or(IN_SNOWY_SLOPES).or(IN_FROZEN_PEAKS).or(IN_JAGGED_PEAKS)
                                                .or(IN_FROZEN_RIVER).or(IN_SNOWY_BEACH).or(IN_FROZEN_OCEAN)
                                                .or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_TADPOLE_COIN.get())
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_BASALT_DELTAS)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_TURTLE_COIN.get())
                                        .when(IN_BEACH).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_DOLPHIN_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_OCEAN)
                                                .or(IN_DEEP_OCEAN).or(IN_WARM_OCEAN)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_GOAT_COIN.get())
                                        .when(IN_FROZEN_PEAKS.or(IN_JAGGED_PEAKS).or(IN_SNOWY_SLOPES)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_IRON_GOLEM_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_LLAMA_COIN.get()).when(SPRING)
                                        .when(IN_WINDSWEPT_HILLS.or(IN_WINDSWEPT_FOREST)
                                                .or(IN_WINDSWEPT_GRAVELLY_HILLS).or(IN_SAVANNA_PLATEAU)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_TRADER_LLAMA_COIN.get()).when(SPRING)
                                        .when(IN_WINDSWEPT_HILLS.or(IN_WINDSWEPT_FOREST)
                                                .or(IN_WINDSWEPT_GRAVELLY_HILLS).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_DESERT).or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_PANDA_COIN.get()).when(SPRING)
                                        .when(IN_JUNGLE.or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_POLAR_BEAR_COIN.get()).when(SPRING)
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SPIDER_COIN.get()).when(SPRING)
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES)
                                                .or(IN_LUSH_CAVES).or(IN_STRONGHOLD)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_WOLF_COIN.get()).when(SPRING)
                                        .when(IN_GROVE.or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA).or(IN_FOREST)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get())
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_NETHER_FORTRESS)
                                                .or(IN_RUINED_PORTAL_NETHER)).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_CREEPER_COIN.get())
                                        .when(IN_OVERWORLD).when(SPRING))

                                .add(LootItem.lootTableItem(ModItems.COPPER_DROWNED_COIN.get()).when(SPRING)
                                        .when(IN_RIVER.or(IN_FROZEN_RIVER).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_OCEAN).or(IN_DEEP_OCEAN)
                                                .or(IN_WARM_OCEAN).or(IN_DRIPSTONE_CAVES)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_ELDER_GUARDIAN_COIN.get()).when(SPRING)
                                        .when(IN_OCEAN_MONUMENT.or(IN_DEEP_OCEAN).or(IN_DEEP_FROZEN_OCEAN)
                                                .or(IN_DEEP_COLD_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_RUINED_PORTAL_OCEAN).or(IN_OCEAN_RUIN_WARM)
                                                .or(IN_OCEAN_RUIN_COLD)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_GUARDIAN_COIN.get()).when(SPRING)
                                        .when(IN_OCEAN_MONUMENT.or(IN_DEEP_OCEAN).or(IN_DEEP_FROZEN_OCEAN)
                                                .or(IN_DEEP_COLD_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_RUINED_PORTAL_OCEAN).or(IN_OCEAN_RUIN_WARM)
                                                .or(IN_OCEAN_RUIN_COLD)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMITE_COIN.get()).when(SPRING)
                                        .when(IN_THE_END))

                                .add(LootItem.lootTableItem(ModItems.COPPER_EVOKER_COIN.get()).when(SPRING)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.COPPER_VINDICATOR_COIN.get()).when(SPRING)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.COPPER_VEX_COIN.get()).when(SPRING)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.COPPER_GHAST_COIN.get()).when(SPRING)
                                        .when(IN_NETHER))

                                .add(LootItem.lootTableItem(ModItems.COPPER_HUSK_COIN.get()).when(SPRING)
                                        .when(IN_DESERT))

                                .add(LootItem.lootTableItem(ModItems.COPPER_MAGMA_CUBE_COIN.get()).when(SPRING)
                                        .when(IN_NETHER_WASTES.or(IN_BASALT_DELTAS).or(IN_NETHER_FORTRESS)
                                                .or(IN_BASTION_REMNANTS)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SLIME_COIN.get()).when(SPRING)
                                        .when(IN_SWAMP.or(IN_MANGROVE_SWAMP)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_PHANTOM_COIN.get()).when(SPRING)
                                        .when(IS_NIGHT.or(IS_THUNDERING).or(IN_NETHER).invert()))

                                .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_BRUTE_COIN.get()).when(SPRING)
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_PILLAGER_COIN.get()).when(SPRING)
                                        .when(IN_PILLAGER_OUTPOST))

                                .add(LootItem.lootTableItem(ModItems.COPPER_RAVAGER_COIN.get()).when(SPRING)
                                        .when(IN_PILLAGER_OUTPOST))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SHULKER_COIN.get()).when(SPRING)
                                        .when(IN_THE_END))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SILVERFISH_COIN.get()).when(SPRING)
                                        .when(IN_STRONGHOLD.or(IN_IGLOO).or(IN_MANSION).or(IN_MEADOW).or(IN_GROVE)
                                                .or(IN_SNOWY_SLOPES).or(IN_JAGGED_PEAKS).or(IN_FROZEN_PEAKS)
                                                .or(IN_STONY_PEAKS)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SKELETON_COIN.get()).when(SPRING)
                                        .when(IN_OVERWORLD.or(IN_NETHER_FORTRESS).or(IN_SOUL_SAND_VALLEY)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_STRAY_COIN.get()).when(SPRING)
                                        .when(IN_FROZEN_RIVER.or(IN_SNOWY_PLAINS).or(IN_ICE_SPIKES).or(IN_FROZEN_OCEAN)
                                                .or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_WARDEN_COIN.get()).when(SPRING)
                                        .when(IN_DEEP_DARK))

                                .add(LootItem.lootTableItem(ModItems.COPPER_WITCH_COIN.get()).when(SPRING)
                                        .when(IN_SWAMP_HUT))

                                .add(LootItem.lootTableItem(ModItems.COPPER_WITHER_SKELETON_COIN.get()).when(SPRING)
                                        .when(IN_NETHER_FORTRESS))

                                .add(LootItem.lootTableItem(ModItems.COPPER_WITHER_COIN.get()).when(SPRING)
                                        .when(IN_NETHER_FORTRESS))

                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOGLIN_COIN.get()).when(SPRING)
                                        .when(IN_OVERWORLD))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_SUMMER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.IRON_ALLAY_COIN.get())
                                        .when(IN_MANSION.or(IN_PILLAGER_OUTPOST)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_AXOLOTL_COIN.get())
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES)
                                                .or(IN_LUSH_CAVES)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_BAT_COIN.get())
                                        .when(IN_SWAMP_HUT.or(IN_MINESHAFT).or(IN_MINESHAFT_MESA)
                                                .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES).or(IN_STRONGHOLD)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_BEE_COIN.get())
                                        .when(IN_MEADOW.or(IN_PLAINS).or(IN_SUNFLOWER_PLAINS)
                                                .or(IN_MANGROVE_SWAMP).or(IN_FLOWER_FOREST).or(IN_FOREST)
                                                .or(IN_BIRCH_FOREST).or(IN_OLD_GROWTH_BIRCH_FOREST)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_BLAZE_COIN.get())
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_CAMEL_COIN.get())
                                        .when(IN_DESERT).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_CAT_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_CAVE_SPIDER_COIN.get())
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_CHICKEN_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_COD_COIN.get())
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_LUKEWARM_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN).or(IN_BEACH).or(IN_STONY_SHORE)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_COW_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_ENDERMAN_COIN.get())
                                        .when(IN_WARPED_FOREST.or(IN_THE_END)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_FOX_COIN.get())
                                        .when(IN_GROVE.or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_FROG_COIN.get())
                                        .when(IN_MANGROVE_SWAMP.or(IN_SWAMP)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_MOOBLOOM_COIN.get())
                                        .when(IN_FLOWER_FOREST.or(IN_MEADOW).or(IN_SUNFLOWER_PLAINS)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_MOOSHROOM_COIN.get())
                                        .when(IN_MUSHROOM_FIELDS).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_OCELOT_COIN.get())
                                        .when(IN_JUNGLE.or(IN_SPARSE_JUNGLE).or(IN_BAMBOO_JUNGLE)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_COIN.get())
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_PUFFERFISH_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                                .or(IN_BEACH).or(IN_STONY_SHORE)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_SALMON_COIN.get())
                                        .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_BEACH)
                                                .or(IN_STONY_SHORE).or(IN_SNOWY_BEACH)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_TROPICAL_FISH_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                                .or(IN_MANGROVE_SWAMP).or(IN_LUSH_CAVES)
                                                .or(IN_BEACH).or(IN_STONY_SHORE)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_HORSE_COIN.get())
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_SAVANNA).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_DONKEY_COIN.get())
                                        .when(IN_PLAINS.or(IN_MEADOW).or(IN_SUNFLOWER_PLAINS).or(IN_SAVANNA).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_MULE_COIN.get())
                                        .when(IN_VILLAGE_SAVANNA.or(IN_VILLAGE_DESERT).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_SKELETON_HORSE_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)
                                                .or(IN_ANCIENT_CITY).or(IN_JUNGLE_TEMPLE).or(IN_DESERT_PYRAMID)
                                                .or(IN_STRONGHOLD).or(IN_NETHER_FORTRESS).or(IN_RUINED_PORTAL_NETHER)))

                                .add(LootItem.lootTableItem(ModItems.IRON_ZOMBIE_HORSE_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)
                                                .or(IN_ANCIENT_CITY).or(IN_JUNGLE_TEMPLE).or(IN_DESERT_PYRAMID).or(IN_STRONGHOLD)))

                                .add(LootItem.lootTableItem(ModItems.IRON_SQUID_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)))

                                .add(LootItem.lootTableItem(ModItems.IRON_GLOW_SQUID_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)))

                                .add(LootItem.lootTableItem(ModItems.IRON_PARROT_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_JUNGLE.or(IN_BAMBOO_JUNGLE)))

                                .add(LootItem.lootTableItem(ModItems.IRON_HOGLIN_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_CRIMSON_FOREST.or(IN_BASTION_REMNANTS)))

                                .add(LootItem.lootTableItem(ModItems.IRON_PIG_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_FOREST).or(IN_SWAMP)
                                                .or(IN_MANGROVE_SWAMP).or(IN_SAVANNA_PLATEAU).or(IN_SAVANNA)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_BIRCH_FOREST).or(IN_BIRCH_FOREST).or(IN_JUNGLE)
                                                .or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE).or(IN_VILLAGE_TAIGA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.IRON_RABBIT_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_SNOWY_SLOPES).or(IN_GROVE)
                                                .or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA).or(IN_MEADOW)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_DESERT)))

                                .add(LootItem.lootTableItem(ModItems.IRON_SHEEP_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_FOREST).or(IN_SWAMP)
                                                .or(IN_MANGROVE_SWAMP).or(IN_SAVANNA_PLATEAU).or(IN_SAVANNA)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_BIRCH_FOREST).or(IN_BIRCH_FOREST).or(IN_JUNGLE)
                                                .or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE).or(IN_VILLAGE_TAIGA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.IRON_SNIFFER_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN_RUIN_COLD.or(IN_OCEAN_RUIN_WARM)))

                                .add(LootItem.lootTableItem(ModItems.IRON_NUMISMATIST_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.IRON_WANDERING_TRADER_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.IRON_VILLAGER_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.IRON_SNOW_GOLEM_COIN.get()).when(SUMMER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_SNOWY_TAIGA).or(IN_GROVE)
                                                .or(IN_SNOWY_SLOPES).or(IN_FROZEN_PEAKS).or(IN_JAGGED_PEAKS)
                                                .or(IN_FROZEN_RIVER).or(IN_SNOWY_BEACH).or(IN_FROZEN_OCEAN)
                                                .or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.IRON_TADPOLE_COIN.get())
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_BASALT_DELTAS)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_TURTLE_COIN.get())
                                        .when(IN_BEACH).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_DOLPHIN_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_OCEAN)
                                                .or(IN_DEEP_OCEAN).or(IN_WARM_OCEAN)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_GOAT_COIN.get())
                                        .when(IN_FROZEN_PEAKS.or(IN_JAGGED_PEAKS).or(IN_SNOWY_SLOPES)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_IRON_GOLEM_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_LLAMA_COIN.get()).when(SUMMER)
                                        .when(IN_WINDSWEPT_HILLS.or(IN_WINDSWEPT_FOREST)
                                                .or(IN_WINDSWEPT_GRAVELLY_HILLS).or(IN_SAVANNA_PLATEAU)))

                                .add(LootItem.lootTableItem(ModItems.IRON_TRADER_LLAMA_COIN.get()).when(SUMMER)
                                        .when(IN_WINDSWEPT_HILLS.or(IN_WINDSWEPT_FOREST)
                                                .or(IN_WINDSWEPT_GRAVELLY_HILLS).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_DESERT).or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.IRON_PANDA_COIN.get()).when(SUMMER)
                                        .when(IN_JUNGLE.or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE)))

                                .add(LootItem.lootTableItem(ModItems.IRON_POLAR_BEAR_COIN.get()).when(SUMMER)
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.IRON_SPIDER_COIN.get()).when(SUMMER)
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES)
                                                .or(IN_LUSH_CAVES).or(IN_STRONGHOLD)))

                                .add(LootItem.lootTableItem(ModItems.IRON_WOLF_COIN.get()).when(SUMMER)
                                        .when(IN_GROVE.or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA).or(IN_FOREST)))

                                .add(LootItem.lootTableItem(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get())
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_NETHER_FORTRESS)
                                                .or(IN_RUINED_PORTAL_NETHER)).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_CREEPER_COIN.get())
                                        .when(IN_OVERWORLD).when(SUMMER))

                                .add(LootItem.lootTableItem(ModItems.IRON_DROWNED_COIN.get()).when(SUMMER)
                                        .when(IN_RIVER.or(IN_FROZEN_RIVER).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_OCEAN).or(IN_DEEP_OCEAN)
                                                .or(IN_WARM_OCEAN).or(IN_DRIPSTONE_CAVES)))

                                .add(LootItem.lootTableItem(ModItems.IRON_ELDER_GUARDIAN_COIN.get()).when(SUMMER)
                                        .when(IN_OCEAN_MONUMENT.or(IN_DEEP_OCEAN).or(IN_DEEP_FROZEN_OCEAN)
                                                .or(IN_DEEP_COLD_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_RUINED_PORTAL_OCEAN).or(IN_OCEAN_RUIN_WARM)
                                                .or(IN_OCEAN_RUIN_COLD)))

                                .add(LootItem.lootTableItem(ModItems.IRON_GUARDIAN_COIN.get()).when(SUMMER)
                                        .when(IN_OCEAN_MONUMENT.or(IN_DEEP_OCEAN).or(IN_DEEP_FROZEN_OCEAN)
                                                .or(IN_DEEP_COLD_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_RUINED_PORTAL_OCEAN).or(IN_OCEAN_RUIN_WARM)
                                                .or(IN_OCEAN_RUIN_COLD)))

                                .add(LootItem.lootTableItem(ModItems.IRON_ENDERMITE_COIN.get()).when(SUMMER)
                                        .when(IN_THE_END))

                                .add(LootItem.lootTableItem(ModItems.IRON_EVOKER_COIN.get()).when(SUMMER)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.IRON_VINDICATOR_COIN.get()).when(SUMMER)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.IRON_VEX_COIN.get()).when(SUMMER)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.IRON_GHAST_COIN.get()).when(SUMMER)
                                        .when(IN_NETHER))

                                .add(LootItem.lootTableItem(ModItems.IRON_HUSK_COIN.get()).when(SUMMER)
                                        .when(IN_DESERT))

                                .add(LootItem.lootTableItem(ModItems.IRON_MAGMA_CUBE_COIN.get()).when(SUMMER)
                                        .when(IN_NETHER_WASTES.or(IN_BASALT_DELTAS).or(IN_NETHER_FORTRESS)
                                                .or(IN_BASTION_REMNANTS)))

                                .add(LootItem.lootTableItem(ModItems.IRON_SLIME_COIN.get()).when(SUMMER)
                                        .when(IN_SWAMP.or(IN_MANGROVE_SWAMP)))

                                .add(LootItem.lootTableItem(ModItems.IRON_PHANTOM_COIN.get()).when(SUMMER)
                                        .when(IS_NIGHT.or(IS_THUNDERING).or(IN_NETHER).invert()))

                                .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_BRUTE_COIN.get()).when(SUMMER)
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)))

                                .add(LootItem.lootTableItem(ModItems.IRON_PILLAGER_COIN.get()).when(SUMMER)
                                        .when(IN_PILLAGER_OUTPOST))

                                .add(LootItem.lootTableItem(ModItems.IRON_RAVAGER_COIN.get()).when(SUMMER)
                                        .when(IN_PILLAGER_OUTPOST))

                                .add(LootItem.lootTableItem(ModItems.IRON_SHULKER_COIN.get()).when(SUMMER)
                                        .when(IN_THE_END))

                                .add(LootItem.lootTableItem(ModItems.IRON_SILVERFISH_COIN.get()).when(SUMMER)
                                        .when(IN_STRONGHOLD.or(IN_IGLOO).or(IN_MANSION).or(IN_MEADOW).or(IN_GROVE)
                                                .or(IN_SNOWY_SLOPES).or(IN_JAGGED_PEAKS).or(IN_FROZEN_PEAKS)
                                                .or(IN_STONY_PEAKS)))

                                .add(LootItem.lootTableItem(ModItems.IRON_SKELETON_COIN.get()).when(SUMMER)
                                        .when(IN_OVERWORLD.or(IN_NETHER_FORTRESS).or(IN_SOUL_SAND_VALLEY)))

                                .add(LootItem.lootTableItem(ModItems.IRON_STRAY_COIN.get()).when(SUMMER)
                                        .when(IN_FROZEN_RIVER.or(IN_SNOWY_PLAINS).or(IN_ICE_SPIKES).or(IN_FROZEN_OCEAN)
                                                .or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.IRON_WARDEN_COIN.get()).when(SUMMER)
                                        .when(IN_DEEP_DARK))

                                .add(LootItem.lootTableItem(ModItems.IRON_WITCH_COIN.get()).when(SUMMER)
                                        .when(IN_SWAMP_HUT))

                                .add(LootItem.lootTableItem(ModItems.IRON_WITHER_SKELETON_COIN.get()).when(SUMMER)
                                        .when(IN_NETHER_FORTRESS))

                                .add(LootItem.lootTableItem(ModItems.IRON_WITHER_COIN.get()).when(SUMMER)
                                        .when(IN_NETHER_FORTRESS))

                                .add(LootItem.lootTableItem(ModItems.IRON_ZOGLIN_COIN.get()).when(SUMMER)
                                        .when(IN_OVERWORLD))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_AUTUMN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ALLAY_COIN.get())
                                        .when(IN_MANSION.or(IN_PILLAGER_OUTPOST)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_AXOLOTL_COIN.get())
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES)
                                                .or(IN_LUSH_CAVES)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_BAT_COIN.get())
                                        .when(IN_SWAMP_HUT.or(IN_MINESHAFT).or(IN_MINESHAFT_MESA)
                                                .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES).or(IN_STRONGHOLD)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_BEE_COIN.get())
                                        .when(IN_MEADOW.or(IN_PLAINS).or(IN_SUNFLOWER_PLAINS)
                                                .or(IN_MANGROVE_SWAMP).or(IN_FLOWER_FOREST).or(IN_FOREST)
                                                .or(IN_BIRCH_FOREST).or(IN_OLD_GROWTH_BIRCH_FOREST)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_BLAZE_COIN.get())
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_CAMEL_COIN.get())
                                        .when(IN_DESERT).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_CAT_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_CAVE_SPIDER_COIN.get())
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_CHICKEN_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_COD_COIN.get())
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_LUKEWARM_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN).or(IN_BEACH).or(IN_STONY_SHORE)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_COW_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMAN_COIN.get())
                                        .when(IN_WARPED_FOREST.or(IN_THE_END)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_FOX_COIN.get())
                                        .when(IN_GROVE.or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_FROG_COIN.get())
                                        .when(IN_MANGROVE_SWAMP.or(IN_SWAMP)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_MOOBLOOM_COIN.get())
                                        .when(IN_FLOWER_FOREST.or(IN_MEADOW).or(IN_SUNFLOWER_PLAINS)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_MOOSHROOM_COIN.get())
                                        .when(IN_MUSHROOM_FIELDS).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_OCELOT_COIN.get())
                                        .when(IN_JUNGLE.or(IN_SPARSE_JUNGLE).or(IN_BAMBOO_JUNGLE)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_COIN.get())
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_PUFFERFISH_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                                .or(IN_BEACH).or(IN_STONY_SHORE)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SALMON_COIN.get())
                                        .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_BEACH)
                                                .or(IN_STONY_SHORE).or(IN_SNOWY_BEACH)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_TROPICAL_FISH_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                                .or(IN_MANGROVE_SWAMP).or(IN_LUSH_CAVES).or(IN_BEACH)
                                                .or(IN_STONY_SHORE)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_HORSE_COIN.get())
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_SAVANNA).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_DONKEY_COIN.get())
                                        .when(IN_PLAINS.or(IN_MEADOW).or(IN_SUNFLOWER_PLAINS).or(IN_SAVANNA).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_MULE_COIN.get())
                                        .when(IN_VILLAGE_SAVANNA.or(IN_VILLAGE_DESERT).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SKELETON_HORSE_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)
                                                .or(IN_ANCIENT_CITY).or(IN_JUNGLE_TEMPLE).or(IN_DESERT_PYRAMID)
                                                .or(IN_STRONGHOLD).or(IN_NETHER_FORTRESS).or(IN_RUINED_PORTAL_NETHER)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOMBIE_HORSE_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)
                                                .or(IN_ANCIENT_CITY).or(IN_JUNGLE_TEMPLE).or(IN_DESERT_PYRAMID).or(IN_STRONGHOLD)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SQUID_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_GLOW_SQUID_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_PARROT_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_JUNGLE.or(IN_BAMBOO_JUNGLE)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_HOGLIN_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_CRIMSON_FOREST.or(IN_BASTION_REMNANTS)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_PIG_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_FOREST).or(IN_SWAMP)
                                                .or(IN_MANGROVE_SWAMP).or(IN_SAVANNA_PLATEAU).or(IN_SAVANNA)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_BIRCH_FOREST).or(IN_BIRCH_FOREST).or(IN_JUNGLE)
                                                .or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE).or(IN_VILLAGE_TAIGA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_RABBIT_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_SNOWY_SLOPES).or(IN_GROVE)
                                                .or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA).or(IN_MEADOW)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_DESERT)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SHEEP_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_FOREST).or(IN_SWAMP)
                                                .or(IN_MANGROVE_SWAMP).or(IN_SAVANNA_PLATEAU).or(IN_SAVANNA)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_BIRCH_FOREST).or(IN_BIRCH_FOREST).or(IN_JUNGLE)
                                                .or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE).or(IN_VILLAGE_TAIGA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SNIFFER_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN_RUIN_COLD.or(IN_OCEAN_RUIN_WARM)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_NUMISMATIST_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_WANDERING_TRADER_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_VILLAGER_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SNOW_GOLEM_COIN.get()).when(AUTUMN)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_SNOWY_TAIGA).or(IN_GROVE)
                                                .or(IN_SNOWY_SLOPES).or(IN_FROZEN_PEAKS).or(IN_JAGGED_PEAKS)
                                                .or(IN_FROZEN_RIVER).or(IN_SNOWY_BEACH).or(IN_FROZEN_OCEAN)
                                                .or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_TADPOLE_COIN.get())
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_BASALT_DELTAS)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_TURTLE_COIN.get())
                                        .when(IN_BEACH).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_DOLPHIN_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_OCEAN)
                                                .or(IN_DEEP_OCEAN).or(IN_WARM_OCEAN)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_GOAT_COIN.get())
                                        .when(IN_FROZEN_PEAKS.or(IN_JAGGED_PEAKS).or(IN_SNOWY_SLOPES)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_IRON_GOLEM_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_LLAMA_COIN.get()).when(AUTUMN)
                                        .when(IN_WINDSWEPT_HILLS.or(IN_WINDSWEPT_FOREST)
                                                .or(IN_WINDSWEPT_GRAVELLY_HILLS).or(IN_SAVANNA_PLATEAU)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_TRADER_LLAMA_COIN.get()).when(AUTUMN)
                                        .when(IN_WINDSWEPT_HILLS.or(IN_WINDSWEPT_FOREST)
                                                .or(IN_WINDSWEPT_GRAVELLY_HILLS).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_DESERT).or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_PANDA_COIN.get()).when(AUTUMN)
                                        .when(IN_JUNGLE.or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_POLAR_BEAR_COIN.get()).when(AUTUMN)
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SPIDER_COIN.get()).when(AUTUMN)
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES)
                                                .or(IN_LUSH_CAVES).or(IN_STRONGHOLD)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_WOLF_COIN.get()).when(AUTUMN)
                                        .when(IN_GROVE.or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA).or(IN_FOREST)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get())
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_NETHER_FORTRESS)
                                                .or(IN_RUINED_PORTAL_NETHER)).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_CREEPER_COIN.get())
                                        .when(IN_OVERWORLD).when(AUTUMN))

                                .add(LootItem.lootTableItem(ModItems.GOLD_DROWNED_COIN.get()).when(AUTUMN)
                                        .when(IN_RIVER.or(IN_FROZEN_RIVER).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_OCEAN).or(IN_DEEP_OCEAN)
                                                .or(IN_WARM_OCEAN).or(IN_DRIPSTONE_CAVES)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_ELDER_GUARDIAN_COIN.get()).when(AUTUMN)
                                        .when(IN_OCEAN_MONUMENT.or(IN_DEEP_OCEAN).or(IN_DEEP_FROZEN_OCEAN)
                                                .or(IN_DEEP_COLD_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_RUINED_PORTAL_OCEAN).or(IN_OCEAN_RUIN_WARM)
                                                .or(IN_OCEAN_RUIN_COLD)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_GUARDIAN_COIN.get()).when(AUTUMN)
                                        .when(IN_OCEAN_MONUMENT.or(IN_DEEP_OCEAN).or(IN_DEEP_FROZEN_OCEAN)
                                                .or(IN_DEEP_COLD_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_RUINED_PORTAL_OCEAN).or(IN_OCEAN_RUIN_WARM)
                                                .or(IN_OCEAN_RUIN_COLD)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMITE_COIN.get()).when(AUTUMN)
                                        .when(IN_THE_END))

                                .add(LootItem.lootTableItem(ModItems.GOLD_EVOKER_COIN.get()).when(AUTUMN)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.GOLD_VINDICATOR_COIN.get()).when(AUTUMN)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.GOLD_VEX_COIN.get()).when(AUTUMN)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.GOLD_GHAST_COIN.get()).when(AUTUMN)
                                        .when(IN_NETHER))

                                .add(LootItem.lootTableItem(ModItems.GOLD_HUSK_COIN.get()).when(AUTUMN)
                                        .when(IN_DESERT))

                                .add(LootItem.lootTableItem(ModItems.GOLD_MAGMA_CUBE_COIN.get()).when(AUTUMN)
                                        .when(IN_NETHER_WASTES.or(IN_BASALT_DELTAS).or(IN_NETHER_FORTRESS)
                                                .or(IN_BASTION_REMNANTS)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SLIME_COIN.get()).when(AUTUMN)
                                        .when(IN_SWAMP.or(IN_MANGROVE_SWAMP)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_PHANTOM_COIN.get()).when(AUTUMN)
                                        .when(IS_NIGHT.or(IS_THUNDERING).or(IN_NETHER).invert()))

                                .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_BRUTE_COIN.get()).when(AUTUMN)
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_PILLAGER_COIN.get()).when(AUTUMN)
                                        .when(IN_PILLAGER_OUTPOST))

                                .add(LootItem.lootTableItem(ModItems.GOLD_RAVAGER_COIN.get()).when(AUTUMN)
                                        .when(IN_PILLAGER_OUTPOST))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SHULKER_COIN.get()).when(AUTUMN)
                                        .when(IN_THE_END))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SILVERFISH_COIN.get()).when(AUTUMN)
                                        .when(IN_STRONGHOLD.or(IN_IGLOO).or(IN_MANSION).or(IN_MEADOW).or(IN_GROVE)
                                                .or(IN_SNOWY_SLOPES).or(IN_JAGGED_PEAKS).or(IN_FROZEN_PEAKS)
                                                .or(IN_STONY_PEAKS)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SKELETON_COIN.get()).when(AUTUMN)
                                        .when(IN_OVERWORLD.or(IN_NETHER_FORTRESS).or(IN_SOUL_SAND_VALLEY)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_STRAY_COIN.get()).when(AUTUMN)
                                        .when(IN_FROZEN_RIVER.or(IN_SNOWY_PLAINS).or(IN_ICE_SPIKES).or(IN_FROZEN_OCEAN)
                                                .or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.GOLD_WARDEN_COIN.get()).when(AUTUMN)
                                        .when(IN_DEEP_DARK))

                                .add(LootItem.lootTableItem(ModItems.GOLD_WITCH_COIN.get()).when(AUTUMN)
                                        .when(IN_SWAMP_HUT))

                                .add(LootItem.lootTableItem(ModItems.GOLD_WITHER_SKELETON_COIN.get()).when(AUTUMN)
                                        .when(IN_NETHER_FORTRESS))

                                .add(LootItem.lootTableItem(ModItems.GOLD_WITHER_COIN.get()).when(AUTUMN)
                                        .when(IN_NETHER_FORTRESS))

                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOGLIN_COIN.get()).when(AUTUMN)
                                        .when(IN_OVERWORLD))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_WINTER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ALLAY_COIN.get())
                                        .when(IN_MANSION.or(IN_PILLAGER_OUTPOST)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_AXOLOTL_COIN.get())
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES)
                                                .or(IN_LUSH_CAVES)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_BAT_COIN.get())
                                        .when(IN_SWAMP_HUT.or(IN_MINESHAFT).or(IN_MINESHAFT_MESA)
                                                .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES).or(IN_STRONGHOLD)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_BEE_COIN.get())
                                        .when(IN_MEADOW.or(IN_PLAINS).or(IN_SUNFLOWER_PLAINS)
                                                .or(IN_MANGROVE_SWAMP).or(IN_FLOWER_FOREST).or(IN_FOREST)
                                                .or(IN_BIRCH_FOREST).or(IN_OLD_GROWTH_BIRCH_FOREST)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_BLAZE_COIN.get())
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CAMEL_COIN.get())
                                        .when(IN_DESERT).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CAT_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CAVE_SPIDER_COIN.get())
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CHICKEN_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COD_COIN.get())
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_LUKEWARM_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN).or(IN_BEACH).or(IN_STONY_SHORE)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COW_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMAN_COIN.get())
                                        .when(IN_WARPED_FOREST.or(IN_THE_END)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_FOX_COIN.get())
                                        .when(IN_GROVE.or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_FROG_COIN.get())
                                        .when(IN_MANGROVE_SWAMP.or(IN_SWAMP)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MOOBLOOM_COIN.get())
                                        .when(IN_FLOWER_FOREST.or(IN_MEADOW).or(IN_SUNFLOWER_PLAINS)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MOOSHROOM_COIN.get())
                                        .when(IN_MUSHROOM_FIELDS).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_OCELOT_COIN.get())
                                        .when(IN_JUNGLE.or(IN_SPARSE_JUNGLE).or(IN_BAMBOO_JUNGLE)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_COIN.get())
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PUFFERFISH_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                                .or(IN_BEACH).or(IN_STONY_SHORE)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SALMON_COIN.get())
                                        .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_BEACH)
                                                .or(IN_STONY_SHORE).or(IN_SNOWY_BEACH)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TROPICAL_FISH_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                                .or(IN_MANGROVE_SWAMP).or(IN_LUSH_CAVES)
                                                .or(IN_BEACH).or(IN_STONY_SHORE)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HORSE_COIN.get())
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_SAVANNA).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_DONKEY_COIN.get())
                                        .when(IN_PLAINS.or(IN_MEADOW).or(IN_SUNFLOWER_PLAINS).or(IN_SAVANNA).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MULE_COIN.get())
                                        .when(IN_VILLAGE_SAVANNA.or(IN_VILLAGE_DESERT).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SKELETON_HORSE_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)
                                                .or(IN_ANCIENT_CITY).or(IN_JUNGLE_TEMPLE).or(IN_DESERT_PYRAMID)
                                                .or(IN_STRONGHOLD).or(IN_NETHER_FORTRESS).or(IN_RUINED_PORTAL_NETHER)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)
                                                .or(IN_ANCIENT_CITY).or(IN_JUNGLE_TEMPLE).or(IN_DESERT_PYRAMID).or(IN_STRONGHOLD)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SQUID_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GLOW_SQUID_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PARROT_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_JUNGLE.or(IN_BAMBOO_JUNGLE)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HOGLIN_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_CRIMSON_FOREST.or(IN_BASTION_REMNANTS)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIG_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_FOREST).or(IN_SWAMP)
                                                .or(IN_MANGROVE_SWAMP).or(IN_SAVANNA_PLATEAU).or(IN_SAVANNA)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_BIRCH_FOREST).or(IN_BIRCH_FOREST).or(IN_JUNGLE)
                                                .or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE).or(IN_VILLAGE_TAIGA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_RABBIT_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_SNOWY_SLOPES).or(IN_GROVE)
                                                .or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA).or(IN_MEADOW)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_DESERT)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SHEEP_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_PLAINS.or(IN_SUNFLOWER_PLAINS).or(IN_FOREST).or(IN_SWAMP)
                                                .or(IN_MANGROVE_SWAMP).or(IN_SAVANNA_PLATEAU).or(IN_SAVANNA)
                                                .or(IN_WINDSWEPT_SAVANNA).or(IN_TAIGA).or(IN_FLOWER_FOREST)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_BIRCH_FOREST).or(IN_BIRCH_FOREST).or(IN_JUNGLE)
                                                .or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE).or(IN_VILLAGE_TAIGA)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_DESERT)
                                                .or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SNIFFER_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_OCEAN_RUIN_COLD.or(IN_OCEAN_RUIN_WARM)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_NUMISMATIST_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WANDERING_TRADER_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_VILLAGER_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SNOW_GOLEM_COIN.get()).when(WINTER)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_SNOWY_TAIGA).or(IN_GROVE)
                                                .or(IN_SNOWY_SLOPES).or(IN_FROZEN_PEAKS).or(IN_JAGGED_PEAKS)
                                                .or(IN_FROZEN_RIVER).or(IN_SNOWY_BEACH).or(IN_FROZEN_OCEAN)
                                                .or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TADPOLE_COIN.get())
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_BASALT_DELTAS)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TURTLE_COIN.get())
                                        .when(IN_BEACH).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_DOLPHIN_COIN.get())
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_OCEAN)
                                                .or(IN_DEEP_OCEAN).or(IN_WARM_OCEAN)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GOAT_COIN.get())
                                        .when(IN_FROZEN_PEAKS.or(IN_JAGGED_PEAKS).or(IN_SNOWY_SLOPES)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_IRON_GOLEM_COIN.get())
                                        .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_TAIGA)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_LLAMA_COIN.get()).when(WINTER)
                                        .when(IN_WINDSWEPT_HILLS.or(IN_WINDSWEPT_FOREST)
                                                .or(IN_WINDSWEPT_GRAVELLY_HILLS).or(IN_SAVANNA_PLATEAU)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TRADER_LLAMA_COIN.get()).when(WINTER)
                                        .when(IN_WINDSWEPT_HILLS.or(IN_WINDSWEPT_FOREST)
                                                .or(IN_WINDSWEPT_GRAVELLY_HILLS).or(IN_SAVANNA_PLATEAU)
                                                .or(IN_VILLAGE_TAIGA).or(IN_VILLAGE_SNOWY).or(IN_VILLAGE_PLAINS)
                                                .or(IN_VILLAGE_DESERT).or(IN_VILLAGE_SAVANNA)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PANDA_COIN.get()).when(WINTER)
                                        .when(IN_JUNGLE.or(IN_BAMBOO_JUNGLE).or(IN_SPARSE_JUNGLE)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_POLAR_BEAR_COIN.get()).when(WINTER)
                                        .when(IN_SNOWY_PLAINS.or(IN_ICE_SPIKES).or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SPIDER_COIN.get()).when(WINTER)
                                        .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES)
                                                .or(IN_LUSH_CAVES).or(IN_STRONGHOLD)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WOLF_COIN.get()).when(WINTER)
                                        .when(IN_GROVE.or(IN_SNOWY_TAIGA).or(IN_OLD_GROWTH_PINE_TAIGA)
                                                .or(IN_OLD_GROWTH_SPRUCE_TAIGA).or(IN_TAIGA).or(IN_FOREST)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get())
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_NETHER_FORTRESS)
                                                .or(IN_RUINED_PORTAL_NETHER)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CREEPER_COIN.get())
                                        .when(IN_OVERWORLD).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_DROWNED_COIN.get())
                                        .when(IN_RIVER.or(IN_FROZEN_RIVER).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_OCEAN).or(IN_DEEP_OCEAN)
                                                .or(IN_WARM_OCEAN).or(IN_DRIPSTONE_CAVES)).when(WINTER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get()).when(WINTER)
                                        .when(IN_OCEAN_MONUMENT.or(IN_DEEP_OCEAN).or(IN_DEEP_FROZEN_OCEAN)
                                                .or(IN_DEEP_COLD_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_RUINED_PORTAL_OCEAN).or(IN_OCEAN_RUIN_WARM)
                                                .or(IN_OCEAN_RUIN_COLD)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GUARDIAN_COIN.get()).when(WINTER)
                                        .when(IN_OCEAN_MONUMENT.or(IN_DEEP_OCEAN).or(IN_DEEP_FROZEN_OCEAN)
                                                .or(IN_DEEP_COLD_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_RUINED_PORTAL_OCEAN).or(IN_OCEAN_RUIN_WARM)
                                                .or(IN_OCEAN_RUIN_COLD)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMITE_COIN.get()).when(WINTER)
                                        .when(IN_THE_END))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_EVOKER_COIN.get()).when(WINTER)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_VINDICATOR_COIN.get()).when(WINTER)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_VEX_COIN.get()).when(WINTER)
                                        .when(IN_MANSION))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GHAST_COIN.get()).when(WINTER)
                                        .when(IN_NETHER))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HUSK_COIN.get()).when(WINTER)
                                        .when(IN_DESERT))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MAGMA_CUBE_COIN.get()).when(WINTER)
                                        .when(IN_NETHER_WASTES.or(IN_BASALT_DELTAS).or(IN_NETHER_FORTRESS)
                                                .or(IN_BASTION_REMNANTS)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SLIME_COIN.get()).when(WINTER)
                                        .when(IN_SWAMP.or(IN_MANGROVE_SWAMP)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PHANTOM_COIN.get()).when(WINTER)
                                        .when(IS_NIGHT.or(IS_THUNDERING).or(IN_NETHER).invert()))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get()).when(WINTER)
                                        .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS)
                                                .or(IN_SOUL_SAND_VALLEY).or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES)
                                                .or(IN_BASALT_DELTAS)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PILLAGER_COIN.get()).when(WINTER)
                                        .when(IN_PILLAGER_OUTPOST))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_RAVAGER_COIN.get()).when(WINTER)
                                        .when(IN_PILLAGER_OUTPOST))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SHULKER_COIN.get()).when(WINTER)
                                        .when(IN_THE_END))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SILVERFISH_COIN.get()).when(WINTER)
                                        .when(IN_STRONGHOLD.or(IN_IGLOO).or(IN_MANSION).or(IN_MEADOW).or(IN_GROVE)
                                                .or(IN_SNOWY_SLOPES).or(IN_JAGGED_PEAKS).or(IN_FROZEN_PEAKS)
                                                .or(IN_STONY_PEAKS)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SKELETON_COIN.get()).when(WINTER)
                                        .when(IN_OVERWORLD.or(IN_NETHER_FORTRESS).or(IN_SOUL_SAND_VALLEY)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_STRAY_COIN.get()).when(WINTER)
                                        .when(IN_FROZEN_RIVER.or(IN_SNOWY_PLAINS).or(IN_ICE_SPIKES).or(IN_FROZEN_OCEAN)
                                                .or(IN_DEEP_FROZEN_OCEAN)))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WARDEN_COIN.get()).when(WINTER)
                                        .when(IN_DEEP_DARK))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WITCH_COIN.get()).when(WINTER)
                                        .when(IN_SWAMP_HUT))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WITHER_SKELETON_COIN.get()).when(WINTER)
                                        .when(IN_NETHER_FORTRESS))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WITHER_COIN.get()).when(WINTER)
                                        .when(IN_NETHER_FORTRESS))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOGLIN_COIN.get()).when(WINTER)
                                        .when(IN_OVERWORLD))
                        ));

        consumer.accept(ModBuiltInLootTables.SPRING_MYSTERY_COIN_PACK,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ALLAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_AXOLOTL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_BAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_BEE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_BLAZE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CAMEL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CAVE_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CHICKEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COD_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COW_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_FOX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_FROG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_MOOBLOOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_MOOSHROOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_OCELOT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PUFFERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SALMON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_TROPICAL_FISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_DONKEY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_MULE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SKELETON_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOMBIE_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GLOW_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PARROT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_HOGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PIG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_RABBIT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SHEEP_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SNIFFER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_NUMISMATIST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WANDERING_TRADER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_VILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SNOW_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_TADPOLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_TURTLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_DOLPHIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GOAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_IRON_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_TRADER_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PANDA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_POLAR_BEAR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WOLF_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CREEPER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_DROWNED_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ELDER_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMITE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_EVOKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GHAST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_HUSK_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_MAGMA_CUBE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SLIME_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PHANTOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_BRUTE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_RAVAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SHULKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SILVERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_STRAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_VEX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_VINDICATOR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WARDEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WITCH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WITHER_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WITHER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.COPPER_HOGLIN_COIN.get()))
                        ));

        consumer.accept(ModBuiltInLootTables.SUMMER_MYSTERY_COIN_PACK,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.IRON_ALLAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_AXOLOTL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_BAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_BEE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_BLAZE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_CAMEL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_CAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_CAVE_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_CHICKEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_COD_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_COW_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_ENDERMAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_FOX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_FROG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_MOOBLOOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_MOOSHROOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_OCELOT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_PUFFERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SALMON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_TROPICAL_FISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_DONKEY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_MULE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SKELETON_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_ZOMBIE_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_GLOW_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_PARROT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_HOGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_PIG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_RABBIT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SHEEP_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SNIFFER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_NUMISMATIST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_WANDERING_TRADER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_VILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SNOW_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_TADPOLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_TURTLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_DOLPHIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_GOAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_IRON_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_TRADER_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_PANDA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_POLAR_BEAR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_WOLF_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_CREEPER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_DROWNED_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_ELDER_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_ENDERMITE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_EVOKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_GHAST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_HUSK_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_MAGMA_CUBE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SLIME_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_PHANTOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_BRUTE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_PILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_RAVAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SHULKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SILVERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_STRAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_VEX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_VINDICATOR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_WARDEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_WITCH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_WITHER_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_WITHER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.IRON_HOGLIN_COIN.get()))
                        ));

        consumer.accept(ModBuiltInLootTables.AUTUMN_MYSTERY_COIN_PACK,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ALLAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_AXOLOTL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_BAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_BEE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_BLAZE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CAMEL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CAVE_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CHICKEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COD_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COW_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_FOX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_FROG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_MOOBLOOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_MOOSHROOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_OCELOT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PUFFERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SALMON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_TROPICAL_FISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_DONKEY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_MULE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SKELETON_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOMBIE_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GLOW_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PARROT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_HOGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PIG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_RABBIT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SHEEP_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SNIFFER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_NUMISMATIST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WANDERING_TRADER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_VILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SNOW_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_TADPOLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_TURTLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_DOLPHIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GOAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_IRON_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_TRADER_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PANDA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_POLAR_BEAR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WOLF_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CREEPER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_DROWNED_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ELDER_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMITE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_EVOKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GHAST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_HUSK_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_MAGMA_CUBE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SLIME_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PHANTOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_BRUTE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_RAVAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SHULKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SILVERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_STRAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_VEX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_VINDICATOR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WARDEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WITCH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WITHER_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WITHER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_HOGLIN_COIN.get()))
                        ));

        consumer.accept(ModBuiltInLootTables.WINTER_MYSTERY_COIN_PACK,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ALLAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_AXOLOTL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_BAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_BEE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_BLAZE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CAMEL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CAVE_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CHICKEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COD_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COW_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_FOX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_FROG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MOOBLOOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MOOSHROOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_OCELOT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PUFFERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SALMON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TROPICAL_FISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_DONKEY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MULE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SKELETON_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GLOW_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PARROT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HOGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_RABBIT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SHEEP_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SNIFFER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_NUMISMATIST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WANDERING_TRADER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_VILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SNOW_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TADPOLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TURTLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_DOLPHIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GOAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_IRON_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TRADER_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PANDA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_POLAR_BEAR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WOLF_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CREEPER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_DROWNED_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMITE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_EVOKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GHAST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HUSK_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MAGMA_CUBE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SLIME_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PHANTOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_RAVAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SHULKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SILVERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_STRAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_VEX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_VINDICATOR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WARDEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WITCH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WITHER_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WITHER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HOGLIN_COIN.get()))
                        ));

        consumer.accept(ModBuiltInLootTables.MYSTERY_COIN_PACK,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(6))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT).when(BIRTHDAY_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT).when(ANNIVERSARY_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT).when(HALLOWEEN_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT).when(CHRISTMAS_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SPRING_MYSTERY_COIN_PACK).when(SPRING))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SUMMER_MYSTERY_COIN_PACK).when(SUMMER))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.AUTUMN_MYSTERY_COIN_PACK).when(AUTUMN))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.WINTER_MYSTERY_COIN_PACK).when(WINTER))
                        ));
    }
}