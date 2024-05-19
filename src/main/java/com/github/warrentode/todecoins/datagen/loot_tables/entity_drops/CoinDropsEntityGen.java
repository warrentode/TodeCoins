package com.github.warrentode.todecoins.datagen.loot_tables.entity_drops;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.github.warrentode.todecoins.datagen.ModLootTableGenProvider.*;

public class CoinDropsEntityGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.TODECOINS_CURRENCY_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(0)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_COPPER_COIN_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.8F))
                                        .setWeight(10).setQuality(1).when(DROPS_CURRENCY))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_IRON_COIN_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.7F))
                                        .setWeight(9).setQuality(2).when(DROPS_CURRENCY))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_GOLD_COIN_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.6F))
                                        .setWeight(8).setQuality(3).when(DROPS_CURRENCY))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F))
                                        .setWeight(7).setQuality(3).when(DROPS_CURRENCY).when(IN_NETHER))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_ENDONIAN_COIN_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.4F))
                                        .setWeight(6).setQuality(3).when(DROPS_CURRENCY).when(IN_THE_END))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.3F))
                                        .setWeight(5).setQuality(4).when(DROPS_CURRENCY))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.5F))
                                        .setWeight(4).setQuality(5).when(DROPS_CURRENCY).when(IN_NETHER))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.2F))
                                        .setWeight(3).setQuality(5).when(DROPS_CURRENCY))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.01F))
                                        .setWeight(2).setQuality(6).when(DROPS_CURRENCY))
                                .add(EmptyLootItem.emptyItem())
                        ));

        consumer.accept(ModBuiltInLootTables.TODECOINS_COPPER_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0F, 1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_IRON_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0F, 1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.IRON_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0F, 1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0F, 1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).when(IN_NETHER)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_ENDONIAN_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0F, 1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.ENDONIAN_COIN.get()).when(IN_THE_END)

                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0F, 1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0F, 1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0F, 1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0F, 1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))))
                        ));
    }
}