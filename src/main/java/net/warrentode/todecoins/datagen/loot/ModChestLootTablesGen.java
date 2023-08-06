package net.warrentode.todecoins.datagen.loot;

import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.item.Items;
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
import net.warrentode.todecoins.loot.conditions.AnniversaryCondition;
import net.warrentode.todecoins.loot.conditions.BirthdayCondition;
import net.warrentode.todecoins.loot.conditions.ChristmasCondition;
import net.warrentode.todecoins.loot.conditions.HalloweenCondition;

import java.util.function.BiConsumer;

public class ModChestLootTablesGen extends ChestLoot {
    public static final LootItemCondition.Builder IN_NETHER_WASTES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.NETHER_WASTES));
    public static final LootItemCondition.Builder IN_WARPED_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WARPED_FOREST));
    public static final LootItemCondition.Builder IN_CRIMSON_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.CRIMSON_FOREST));
    public static final LootItemCondition.Builder IN_BASALT_DELTAS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.BASALT_DELTAS));
    public static final LootItemCondition.Builder IN_SOUL_SAND_VALLEY = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SOUL_SAND_VALLEY));
    public static final LootItemCondition.Builder BIRTHDAY_EVENT = BirthdayCondition.event();
    public static final LootItemCondition.Builder HALLOWEEN_EVENT = HalloweenCondition.event();
    public static final LootItemCondition.Builder CHRISTMAS_EVENT = ChristmasCondition.event();
    public static final LootItemCondition.Builder ANNIVERSARY_EVENT = AnniversaryCondition.event();

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
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST).or(IN_BASALT_DELTAS).or(IN_SOUL_SAND_VALLEY))
                                        .setWeight(5).setQuality(2))
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
                                        .when(BIRTHDAY_EVENT)
                                        .setWeight(7).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT)
                                        .when(HALLOWEEN_EVENT)
                                        .setWeight(7).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT)
                                        .when(CHRISTMAS_EVENT)
                                        .setWeight(7).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT)
                                        .when(ANNIVERSARY_EVENT)
                                        .setWeight(7).setQuality(0))
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
    }
}