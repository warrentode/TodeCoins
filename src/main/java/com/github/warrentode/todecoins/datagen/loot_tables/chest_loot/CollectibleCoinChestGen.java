package com.github.warrentode.todecoins.datagen.loot_tables.chest_loot;

import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static com.github.warrentode.todecoins.datagen.ModLootTableGenProvider.*;

public class CollectibleCoinChestGen extends ChestLoot {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.COLLECTIBLE_COIN_CHEST_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT)
                                        .when(BIRTHDAY_EVENT).when(IN_OVERWORLD)
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT)
                                        .when(ANNIVERSARY_EVENT).when(IN_OVERWORLD)
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT)
                                        .when(HALLOWEEN_EVENT).when(IN_OVERWORLD)
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT)
                                        .when(CHRISTMAS_EVENT).when(IN_OVERWORLD)
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_EASTER_COIN_LOOT)
                                        .when(EASTER_EVENT).when(IN_OVERWORLD)
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_NEW_YEAR_COIN_LOOT)
                                        .when(NEW_YEAR_EVENT).when(IN_OVERWORLD)
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.SPRING_COINS_CHEST)
                                        .when(SPRING.or(EASTER_EVENT).or(NEW_YEAR_EVENT)).when(IN_OVERWORLD)
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.SUMMER_COINS_CHEST)
                                        .when(SUMMER).when(IN_OVERWORLD)
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.AUTUMN_COINS_CHEST)
                                        .when(AUTUMN.or(HALLOWEEN_EVENT)).when(IN_OVERWORLD)
                                        .setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.WINTER_COINS_CHEST)
                                        .when(WINTER.or(CHRISTMAS_EVENT).or(BIRTHDAY_EVENT).or(ANNIVERSARY_EVENT)).when(IN_OVERWORLD)
                                        .setWeight(1).setQuality(6))

                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT)
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .when(IN_OVERWORLD.invert())
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_EASTER_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_NEW_YEAR_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F))
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.SPRING_COINS_CHEST)
                                        .when(IN_OVERWORLD.invert())
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.SUMMER_COINS_CHEST)
                                        .when(IN_OVERWORLD.invert())
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.AUTUMN_COINS_CHEST)
                                        .when(IN_OVERWORLD.invert())
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.WINTER_COINS_CHEST)
                                        .when(IN_OVERWORLD.invert())
                                        .setWeight(1).setQuality(6))
                        )
        );
    }
}