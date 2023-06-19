package net.warrentode.todecoins.datagen.loot_tables;

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
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.ExplorationMapFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.warrentode.todecoins.loot.conditions.*;

import java.util.function.BiConsumer;

public class ModChestLootTablesGen extends ChestLoot {
    // structure checks
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
    public static final LootItemCondition.Builder IN_SUNFLOWER_PLAINS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SUNFLOWER_PLAINS));
    public static final LootItemCondition.Builder IN_MANGROVE_SWAMP = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.MANGROVE_SWAMP));
    public static final LootItemCondition.Builder IN_FLOWER_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FLOWER_FOREST));
    public static final LootItemCondition.Builder IN_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FOREST));
    public static final LootItemCondition.Builder IN_BIRCH_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.BIRCH_FOREST));
    public static final LootItemCondition.Builder IN_OLD_GROWTH_BIRCH_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.OLD_GROWTH_BIRCH_FOREST));
    public static final LootItemCondition.Builder IN_DRIPSTONE_CAVES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DRIPSTONE_CAVES));
    public static final LootItemCondition.Builder IN_LUSH_CAVES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.LUSH_CAVES));

    // dimension/level checks
    public static final LootItemCondition.Builder IN_THE_END = LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.END));

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
        consumer.accept(ModBuiltInLootTables.LEPRECHAUN_CHEST,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.MAP)
                                                .apply(ExplorationMapFunction.makeExplorationMap()
                                                        .setDestination(StructureTags.ON_TREASURE_MAPS)
                                                        .setMapDecoration(MapDecoration.Type.RED_X)
                                                        .setZoom((byte) 1)
                                                        .setSkipKnownStructures(false))
                                                .apply(SetNameFunction.setName(Component.translatable("filled_map.buried_treasure"))))
                                 )
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHEST_LOOT))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.BANKER_CHEST,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.CURRENCY_STAMP.get()))
                                 )
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHEST_LOOT))
                                 )
                       );
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
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS).or(IN_SOUL_SAND_VALLEY)
                                                        .or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST).or(IN_NETHER_WASTES).or(IN_BASALT_DELTAS)).setWeight(5).setQuality(2))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT)
                                                .setWeight(4).setQuality(3))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_LOOT)
                                                .setWeight(4).setQuality(4))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT)
                                                .setWeight(3).setQuality(4))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_LOOT)
                                                .setWeight(2).setQuality(5))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_LOOT)
                                                .setWeight(1).setQuality(6))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT)
                                                .when(BIRTHDAY_EVENT).setWeight(7).setQuality(0))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT)
                                                .when(HALLOWEEN_EVENT).setWeight(7).setQuality(0))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT)
                                                .when(CHRISTMAS_EVENT).setWeight(7).setQuality(0))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT)
                                                .when(ANNIVERSARY_EVENT).setWeight(7).setQuality(0))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ALLAY_COIN_LOOT)
                                                .when(IN_MANSION.or(IN_PILLAGER_OUTPOST)).setWeight(1).setQuality(1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_AXOLOTL_COIN_LOOT)
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)).setWeight(1).setQuality(1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BAT_COIN_LOOT)
                                                .when(IN_SWAMP_HUT.or(IN_MINESHAFT).or(IN_MINESHAFT_MESA).or(IN_DRIPSTONE_CAVES)
                                                        .or(IN_LUSH_CAVES).or(IN_STRONGHOLD)).setWeight(1).setQuality(1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BEE_COIN_LOOT)
                                                .when(IN_MEADOW.or(IN_PLAINS).or(IN_SUNFLOWER_PLAINS).or(IN_MANGROVE_SWAMP)
                                                        .or(IN_FLOWER_FOREST).or(IN_FOREST).or(IN_BIRCH_FOREST).or(IN_OLD_GROWTH_BIRCH_FOREST)).setWeight(1).setQuality(1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CAMEL_COIN_LOOT).when(IN_DESERT).setWeight(1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CAT_COIN_LOOT)
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).setWeight(1).setQuality(1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHICKEN_COIN_LOOT)
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).setWeight(1).setQuality(6))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ENDERMAN_COIN_LOOT)
                                                .when(IN_WARPED_FOREST.or(IN_THE_END)).setWeight(1).setQuality(6))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_OCELOT_COIN_LOOT)
                                                .when(IN_JUNGLE.or(IN_SPARSE_JUNGLE).or(IN_BAMBOO_JUNGLE)).setWeight(1).setQuality(1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_PIGLIN_COIN_LOOT)
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS).or(IN_SOUL_SAND_VALLEY)
                                                        .or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES).or(IN_BASALT_DELTAS)).setWeight(1).setQuality(6))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CAVE_SPIDER_COIN_LOOT)
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)).setWeight(1).setQuality(6))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BLAZE_COIN_LOOT)
                                                .when(IN_NETHER_FORTRESS).setWeight(1).setQuality(6))
                                 )
                       );
        // tables used in other chest loot tables
        consumer.accept(ModBuiltInLootTables.TODECOINS_COPPER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 7.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()).setWeight(1)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 7.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.COPPER_COIN_BAG.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_IRON_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 6.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.IRON_COIN.get()).setWeight(1)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.IRON_COIN_BAG.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_GOLD_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get()).setWeight(1)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.GOLD_COIN_BAG.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).setWeight(1)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get()).setWeight(1)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 3.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).setWeight(1)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 3.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get()).setWeight(1)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 2.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get()).setWeight(1)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.EMERALD_BANK_NOTE_BAG.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.LUCKY_COIN.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .when(BIRTHDAY_EVENT)
                                        .add(LootItem.lootTableItem(ModItems.BIRTHDAY_COIN_2023.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .when(CHRISTMAS_EVENT)
                                        .add(LootItem.lootTableItem(ModItems.CHRISTMAS_COIN_2023.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .when(HALLOWEEN_EVENT)
                                        .add(LootItem.lootTableItem(ModItems.HALLOWEEN_COIN_2023.get()))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .when(ANNIVERSARY_EVENT)
                                        // newest coins weight = total number of entries
                                        .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_COSMOS_COIN.get())
                                                .setQuality(0).setWeight(4))
                                        .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get())
                                                .setQuality(0).setWeight(4))
                                        // old coins weight = 1
                                        .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_CARNATION_COIN.get())
                                                .setQuality(0).setWeight(1))
                                        .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get())
                                                .setQuality(0).setWeight(1))
                                 )
                       );
        // entity themed chest loot
        consumer.accept(ModBuiltInLootTables.TODECOINS_ALLAY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_ALLAY_COIN.get())
                                                .when(IN_MANSION.or(IN_PILLAGER_OUTPOST)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_ALLAY_COIN.get())
                                                .when(IN_MANSION.or(IN_PILLAGER_OUTPOST)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_ALLAY_COIN.get())
                                                .when(IN_MANSION.or(IN_PILLAGER_OUTPOST)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_ALLAY_COIN.get())
                                                .when(IN_MANSION.or(IN_PILLAGER_OUTPOST)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_AXOLOTL_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_AXOLOTL_COIN.get())
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)
                                                        .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_AXOLOTL_COIN.get())
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)
                                                        .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_AXOLOTL_COIN.get())
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)
                                                        .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_AXOLOTL_COIN.get())
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)
                                                        .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BAT_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_BAT_COIN.get())
                                                .when(IN_SWAMP_HUT.or(IN_MINESHAFT).or(IN_MINESHAFT_MESA)
                                                        .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES).or(IN_STRONGHOLD)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_BAT_COIN.get())
                                                .when(IN_SWAMP_HUT.or(IN_MINESHAFT).or(IN_MINESHAFT_MESA)
                                                        .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES).or(IN_STRONGHOLD)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_BAT_COIN.get())
                                                .when(IN_SWAMP_HUT.or(IN_MINESHAFT).or(IN_MINESHAFT_MESA)
                                                        .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES).or(IN_STRONGHOLD)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_BAT_COIN.get())
                                                .when(IN_SWAMP_HUT.or(IN_MINESHAFT).or(IN_MINESHAFT_MESA)
                                                        .or(IN_DRIPSTONE_CAVES).or(IN_LUSH_CAVES).or(IN_STRONGHOLD)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BEE_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_BEE_COIN.get())
                                                .when(IN_MEADOW.or(IN_PLAINS).or(IN_SUNFLOWER_PLAINS)
                                                        .or(IN_MANGROVE_SWAMP).or(IN_FLOWER_FOREST).or(IN_FOREST)
                                                        .or(IN_BIRCH_FOREST).or(IN_OLD_GROWTH_BIRCH_FOREST)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_BEE_COIN.get())
                                                .when(IN_MEADOW.or(IN_PLAINS).or(IN_SUNFLOWER_PLAINS)
                                                        .or(IN_MANGROVE_SWAMP).or(IN_FLOWER_FOREST).or(IN_FOREST)
                                                        .or(IN_BIRCH_FOREST).or(IN_OLD_GROWTH_BIRCH_FOREST)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_BEE_COIN.get())
                                                .when(IN_MEADOW.or(IN_PLAINS).or(IN_SUNFLOWER_PLAINS)
                                                        .or(IN_MANGROVE_SWAMP).or(IN_FLOWER_FOREST).or(IN_FOREST)
                                                        .or(IN_BIRCH_FOREST).or(IN_OLD_GROWTH_BIRCH_FOREST)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_BEE_COIN.get())
                                                .when(IN_MEADOW.or(IN_PLAINS).or(IN_SUNFLOWER_PLAINS)
                                                        .or(IN_MANGROVE_SWAMP).or(IN_FLOWER_FOREST).or(IN_FOREST)
                                                        .or(IN_BIRCH_FOREST).or(IN_OLD_GROWTH_BIRCH_FOREST)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_CAMEL_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CAMEL_COIN.get())
                                                .when(IN_DESERT).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CAMEL_COIN.get())
                                                .when(IN_DESERT).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CAMEL_COIN.get())
                                                .when(IN_DESERT).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CAMEL_COIN.get())
                                                .when(IN_DESERT).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_CAT_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CAT_COIN.get())
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CAT_COIN.get())
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CAT_COIN.get())
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CAT_COIN.get())
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_CHICKEN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CHICKEN_COIN.get())
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CHICKEN_COIN.get())
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CHICKEN_COIN.get())
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CHICKEN_COIN.get())
                                                .when(IN_VILLAGE_DESERT.or(IN_VILLAGE_PLAINS).or(IN_VILLAGE_SAVANNA).or(IN_VILLAGE_SNOWY)
                                                        .or(IN_VILLAGE_TAIGA).or(IN_SWAMP_HUT)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_ENDERMAN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMAN_COIN.get())
                                                .when(IN_WARPED_FOREST.or(IN_THE_END)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_ENDERMAN_COIN.get())
                                                .when(IN_WARPED_FOREST.or(IN_THE_END)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMAN_COIN.get())
                                                .when(IN_WARPED_FOREST.or(IN_THE_END)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMAN_COIN.get())
                                                .when(IN_WARPED_FOREST.or(IN_THE_END)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_OCELOT_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_OCELOT_COIN.get())
                                                .when(IN_JUNGLE.or(IN_SPARSE_JUNGLE).or(IN_BAMBOO_JUNGLE)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_OCELOT_COIN.get())
                                                .when(IN_JUNGLE.or(IN_SPARSE_JUNGLE).or(IN_BAMBOO_JUNGLE)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_OCELOT_COIN.get())
                                                .when(IN_JUNGLE.or(IN_SPARSE_JUNGLE).or(IN_BAMBOO_JUNGLE)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_OCELOT_COIN.get())
                                                .when(IN_JUNGLE.or(IN_SPARSE_JUNGLE).or(IN_BAMBOO_JUNGLE)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_PIGLIN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_COIN.get())
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS).or(IN_SOUL_SAND_VALLEY)
                                                        .or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES).or(IN_BASALT_DELTAS)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_COIN.get())
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS).or(IN_SOUL_SAND_VALLEY)
                                                        .or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES).or(IN_BASALT_DELTAS)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_COIN.get())
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS).or(IN_SOUL_SAND_VALLEY)
                                                        .or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES).or(IN_BASALT_DELTAS)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_COIN.get())
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER).or(IN_BASTION_REMNANTS).or(IN_SOUL_SAND_VALLEY)
                                                        .or(IN_CRIMSON_FOREST).or(IN_NETHER_WASTES).or(IN_BASALT_DELTAS)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_CAVE_SPIDER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CAVE_SPIDER_COIN.get())
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CAVE_SPIDER_COIN.get())
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CAVE_SPIDER_COIN.get())
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CAVE_SPIDER_COIN.get())
                                                .when(IN_MINESHAFT.or(IN_MINESHAFT_MESA)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BLAZE_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_BLAZE_COIN.get())
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER)).when(SPRING).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_BLAZE_COIN.get())
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER)).when(SUMMER).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_BLAZE_COIN.get())
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER)).when(AUTUMN).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_BLAZE_COIN.get())
                                                .when(IN_NETHER_FORTRESS.or(IN_RUINED_PORTAL_NETHER)).when(WINTER).setWeight(1).setQuality(1))
                                 )
                       );
        // entity coins by seasons
        consumer.accept(ModBuiltInLootTables.TODECOINS_SPRING_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_ALLAY_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_AXOLOTL_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_BAT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_BEE_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_BLAZE_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CAMEL_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CAT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CAVE_SPIDER_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CHICKEN_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMAN_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_OCELOT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_COIN.get()).when(SPRING))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_SUMMER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.IRON_ALLAY_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_AXOLOTL_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_BAT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_BEE_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_BLAZE_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CAMEL_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CAT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CAVE_SPIDER_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CHICKEN_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_ENDERMAN_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_OCELOT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_COIN.get()).when(SPRING))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_AUTUMN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_ALLAY_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_AXOLOTL_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_BAT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_BEE_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_BLAZE_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CAMEL_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CAT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CAVE_SPIDER_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CHICKEN_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMAN_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_OCELOT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_COIN.get()).when(SPRING))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_WINTER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_ALLAY_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_AXOLOTL_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_BAT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_BEE_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_BLAZE_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CAMEL_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CAT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CAVE_SPIDER_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CHICKEN_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMAN_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_OCELOT_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_COIN.get()).when(SPRING))
                                 ));
    }
}