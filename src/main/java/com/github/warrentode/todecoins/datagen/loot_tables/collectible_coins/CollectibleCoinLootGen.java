package com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
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

public class CollectibleCoinLootGen implements LootTableSubProvider {
    @Override
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.BOSS_COLLECTIBLE_COIN_DROPS,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .setBonusRolls(ConstantValue.exactly(0F))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SPRING_BOSS_COIN_DROPS).when(SPRING))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SUMMER_BOSS_COIN_DROPS).when(SUMMER))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.AUTUMN_BOSS_COIN_DROPS).when(AUTUMN))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.WINTER_BOSS_COIN_DROPS).when(WINTER))
        ));
        consumer.accept(ModBuiltInLootTables.MASTER_COLLECTIBLE_COIN_DROPS,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .setBonusRolls(ConstantValue.exactly(0F))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SPRING_COIN_DROPS).when(SPRING))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SUMMER_COIN_DROPS).when(SUMMER))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.AUTUMN_COIN_DROPS).when(AUTUMN))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.WINTER_COIN_DROPS).when(WINTER))
                ));
        consumer.accept(TradeLootTables.MYSTERY_COIN_PACK,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .setBonusRolls(ConstantValue.exactly(0F))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.HERO_COIN_LOOT))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.HOLIDAY_COIN_LOOT))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SPRING_COINS_LOOT).when(SPRING))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SUMMER_COINS_LOOT).when(SUMMER))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.AUTUMN_COINS_LOOT).when(AUTUMN))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.WINTER_COINS_LOOT).when(WINTER))

                ));
        consumer.accept(TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .setBonusRolls(ConstantValue.exactly(0F))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.HERO_COIN_LOOT_INVERTED))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.HOLIDAY_COIN_LOOT_INVERTED))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SPRING_COINS_LOOT).when(SPRING.invert()))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SUMMER_COINS_LOOT).when(SUMMER.invert()))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.AUTUMN_COINS_LOOT).when(AUTUMN.invert()))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.WINTER_COINS_LOOT).when(WINTER.invert()))

                ));
        consumer.accept(ModBuiltInLootTables.COLLECTIBLE_COIN_MASTER_CHEST_LOOT,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .setBonusRolls(ConstantValue.exactly(0F))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.HOLIDAY_COIN_LOOT))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SPRING_COINS_LOOT).when(SPRING))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SUMMER_COINS_LOOT).when(SUMMER))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.AUTUMN_COINS_LOOT).when(AUTUMN))
                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.WINTER_COINS_LOOT).when(WINTER))

                ));
        consumer.accept(ModBuiltInLootTables.HOLIDAY_COIN_LOOT_INVERTED,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_BIRTHDAY.get())
                                        .when(BIRTHDAY_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_CHRISTMAS.get())
                                        .when(CHRISTMAS_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HALLOWEEN.get())
                                        .when(HALLOWEEN_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_EASTER.get())
                                        .when(EASTER_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_NEW_YEAR.get())
                                        .when(NEW_YEAR_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_SCHOLAR_OWL.get())
                                        .when(ANNIVERSARY_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_TUXEDO_CAT.get())
                                        .when(ANNIVERSARY_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_LITTLE_BEAR.get())
                                        .when(ANNIVERSARY_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PATRON_CARNATION.get())
                                        .when(ANNIVERSARY_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PATRON_COSMOS.get())
                                        .when(ANNIVERSARY_EVENT.invert()))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PATRON_SUNFLOWER.get())
                                        .when(ANNIVERSARY_EVENT.invert()))
                        ));
        consumer.accept(ModBuiltInLootTables.HOLIDAY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_BIRTHDAY.get())
                                        .when(BIRTHDAY_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_CHRISTMAS.get())
                                        .when(CHRISTMAS_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_HALLOWEEN.get())
                                        .when(HALLOWEEN_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_EASTER.get())
                                        .when(EASTER_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_NEW_YEAR.get())
                                        .when(NEW_YEAR_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_SCHOLAR_OWL.get())
                                        .when(ANNIVERSARY_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_TUXEDO_CAT.get())
                                        .when(ANNIVERSARY_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_LITTLE_BEAR.get())
                                        .when(ANNIVERSARY_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PATRON_CARNATION.get())
                                        .when(ANNIVERSARY_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PATRON_COSMOS.get())
                                        .when(ANNIVERSARY_EVENT))
                                .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PATRON_SUNFLOWER.get())
                                        .when(ANNIVERSARY_EVENT))
                        ));
    }
}