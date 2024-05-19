package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.ExplorationMapFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static com.github.warrentode.todecoins.datagen.ModLootTableGenProvider.*;

public class ModChestLootTablesGen extends ChestLoot {
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