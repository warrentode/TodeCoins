package com.github.warrentode.todecoins.datagen.loot_tables.entity_drops;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.github.warrentode.todecoins.datagen.ModLootTableGenProvider.*;

public class CollectibleCoinDropsHolidayGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.HOLIDAY_COLLECTIBLE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(0)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_DROPS)
                                        .when(BIRTHDAY_EVENT).when(LootItemRandomChanceCondition.randomChance(0.01F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_DROPS)
                                        .when(HALLOWEEN_EVENT).when(LootItemRandomChanceCondition.randomChance(0.01F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_DROPS)
                                        .when(CHRISTMAS_EVENT).when(LootItemRandomChanceCondition.randomChance(0.01F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EASTER_COIN_DROPS)
                                        .when(EASTER_EVENT).when(LootItemRandomChanceCondition.randomChance(0.01F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NEW_YEAR_COIN_DROPS)
                                        .when(NEW_YEAR_EVENT).when(LootItemRandomChanceCondition.randomChance(0.01F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_DROPS)
                                        .when(ANNIVERSARY_EVENT).when(LootItemRandomChanceCondition.randomChance(0.01F)))
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.BIRTHDAY_COIN.get()).when(BIRTHDAY_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.HALLOWEEN_COIN.get()).when(HALLOWEEN_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.CHRISTMAS_COIN.get()).when(CHRISTMAS_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EASTER_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.EASTER_COIN.get()).when(EASTER_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NEW_YEAR_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.NEW_YEAR_COIN.get()).when(NEW_YEAR_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.SCHOLAR_OWL_COIN.get()).when(ANNIVERSARY_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .setQuality(0).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.TUXEDO_CAT_COIN.get()).when(ANNIVERSARY_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .setQuality(0).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.LITTLE_BEAR_COIN.get()).when(ANNIVERSARY_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .setQuality(0).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_SUNFLOWER_COIN.get()).when(ANNIVERSARY_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .setQuality(0).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_COSMOS_COIN.get()).when(ANNIVERSARY_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .setQuality(0).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_CARNATION_COIN.get()).when(ANNIVERSARY_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .setQuality(0).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get()).when(ANNIVERSARY_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .setQuality(0).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get()).when(ANNIVERSARY_EVENT)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .setQuality(0).setWeight(1))
                        ));
    }
}