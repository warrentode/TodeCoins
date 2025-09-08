package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static com.github.warrentode.todecoins.datagen.LootTablesGen.*;

public class GiftLootGen implements LootTableSubProvider {
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        // injected gift loot table
        consumer.accept(ModBuiltInLootTables.HERO_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HERO_COPPER.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HERO_IRON.get()).when(SUMMER))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HERO_GOLD.get()).when(AUTUMN))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HERO_NETHERITE.get()).when(WINTER))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.HERO_COIN_LOOT_INVERTED,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HERO_COPPER.get()).when(SPRING.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HERO_IRON.get()).when(SUMMER.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HERO_GOLD.get()).when(AUTUMN.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HERO_NETHERITE.get()).when(WINTER.invert()))
                        )
        );
        // injected gift loot table
        consumer.accept(ModBuiltInLootTables.COLLECTIBLE_COIN_GIFT_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.HERO_COIN_LOOT).setWeight(5))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.HOLIDAY_COIN_LOOT).setWeight(1))
                                 )
                       );
        // gift loot for mod villagers
        consumer.accept(ModBuiltInLootTables.BANKER_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(TCItems.CURRENCY_STAMP.get()))
                                        .add(LootItem.lootTableItem(TCItems.COPPER_COIN.get()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.COLLECTIBLE_COIN_GIFT_LOOT))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.LEPRECHAUN_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(TCItems.GOLD_COIN.get()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.COLLECTIBLE_COIN_GIFT_LOOT))
                                 )
                       );
        // injected rascal reward loot
        consumer.accept(ModBuiltInLootTables.RASCAL_COIN_REWARD,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_RASCAL_COPPER.get()).when(SPRING))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_RASCAL_IRON.get()).when(SUMMER))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_RASCAL_GOLD.get()).when(AUTUMN))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_RASCAL_NETHERITE.get()).when(WINTER))
                        ));
    }
}