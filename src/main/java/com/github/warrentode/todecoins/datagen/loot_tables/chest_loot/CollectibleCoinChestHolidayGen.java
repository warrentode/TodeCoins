package com.github.warrentode.todecoins.datagen.loot_tables.chest_loot;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class CollectibleCoinChestHolidayGen extends ChestLoot {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.BIRTHDAY_COIN.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.CHRISTMAS_COIN.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.HALLOWEEN_COIN.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EASTER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.EASTER_COIN.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NEW_YEAR_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.NEW_YEAR_COIN.get()))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.LITTLE_BEAR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.TUXEDO_CAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.SCHOLAR_OWL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_SUNFLOWER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_COSMOS_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_CARNATION_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get()))
                        ));
    }
}