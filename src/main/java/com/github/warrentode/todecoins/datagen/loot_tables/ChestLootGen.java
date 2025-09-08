package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static com.github.warrentode.todecoins.datagen.LootTablesGen.COLLECTIBLE_COIN_CHANCE;
import static com.github.warrentode.todecoins.datagen.LootTablesGen.CURRENCY_CHANCE;

public class ChestLootGen implements LootTableSubProvider {
    @Override
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.MASTER_CHEST_LOOT,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .setBonusRolls(ConstantValue.exactly(0F))
                        .add(LootTableReference.lootTableReference(
                                        ModBuiltInLootTables.COLLECTIBLE_COIN_MASTER_CHEST_LOOT)
                                .when(COLLECTIBLE_COIN_CHANCE))
                        .add(LootTableReference.lootTableReference(TradeLootTables.ONE_EMERALD_VALUE_CURRENCY)
                                .when(CURRENCY_CHANCE))
                ));

        // village chest loot for custom villagers
        consumer.accept(ModBuiltInLootTables.LEPRECHAUN_CHEST,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(10.0F))
                                .add(LootItem.lootTableItem(TCBlocks.GOLD_COIN_BAG.get()))
                                .add(LootItem.lootTableItem(Items.MAP)
                                        .when(LootItemRandomChanceCondition.randomChance(0.05F))
                                        .apply(ExplorationMapFunction.makeExplorationMap()
                                                .setDestination(StructureTags.ON_TREASURE_MAPS)
                                                .setMapDecoration(MapDecoration.Type.RED_X)
                                                .setZoom((byte) 1)
                                                .setSkipKnownStructures(false))
                                        .apply(SetNameFunction.setName(Component.translatable("filled_map.rainbow_end"))))
                                .add(LootTableReference.lootTableReference(TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE))
                                .add(LootTableReference.lootTableReference(TradeLootTables.LOGS_SELL_TABLE))
                                .add(LootTableReference.lootTableReference(TradeLootTables.ONE_EMERALD_VALUE_FUEL))
                                .add(LootTableReference.lootTableReference(TradeLootTables.WANDERING_SELL_ONE_EMERALD_VALUE_TABLE))
                                .add(LootTableReference.lootTableReference(TradeLootTables.WANDERING_PURCHASE_TABLE))
                        ));
        consumer.accept(ModBuiltInLootTables.BANKER_CHEST,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(3.0F))
                        .add(LootTableReference.lootTableReference(TradeLootTables.ONE_EMERALD_VALUE_CURRENCY))
                        .add(LootTableReference.lootTableReference(TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS))
                        .add(LootItem.lootTableItem(TCItems.CURRENCY_STAMP.get()))
                ));
    }
}