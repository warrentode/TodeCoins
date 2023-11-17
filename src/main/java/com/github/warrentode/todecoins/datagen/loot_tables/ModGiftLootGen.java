package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.conditions.season.*;
import net.minecraft.data.loot.GiftLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class ModGiftLootGen extends GiftLoot {
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        // injected gift loot table
        consumer.accept(ModBuiltInLootTables.TODECOINS_HERO_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_HERO_COIN.get()).when(SpringCondition.season()))
                                        .add(LootItem.lootTableItem(ModItems.IRON_HERO_COIN.get()).when(SummerCondition.season()))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_HERO_COIN.get()).when(AutumnCondition.season()))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_HERO_COIN.get()).when(WinterCondition.season()))
                                 )
                       );
        // injected gift loot table
        consumer.accept(ModBuiltInLootTables.TODECOINS_COIN_GIFT_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HERO_COIN_LOOT).setWeight(5))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT).setWeight(1).when(BirthdayCondition.event()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT).setWeight(1).when(AnniversaryCondition.event()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT).setWeight(1).when(ChristmasCondition.event()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT).setWeight(1).when(ChristmasCondition.event()))
                                 )
                       );
        // gift loot for mod villagers
        consumer.accept(ModBuiltInLootTables.BANKER_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.CURRENCY_STAMP.get()))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_COIN_GIFT_LOOT))
                                 )
                       );
        consumer.accept(ModBuiltInLootTables.LEPRECHAUN_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_COIN_GIFT_LOOT))
                                 )
                       );
    }
}