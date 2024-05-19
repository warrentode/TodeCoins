package com.github.warrentode.todecoins.datagen.loot_tables.entity_drops;

import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.github.warrentode.todecoins.datagen.ModLootTableGenProvider.*;

public class CollectibleCoinDropsSeasonalGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.ENTITY_COLLECTIBLE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(0)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_SPRING_ENTITY_COIN_DROPS)
                                        .when(SPRING.or(EASTER_EVENT).or(NEW_YEAR_EVENT))
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_SUMMER_ENTITY_COIN_DROPS)
                                        .when(SUMMER).when(LootItemRandomChanceCondition.randomChance(0.1F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_AUTUMN_ENTITY_COIN_DROPS)
                                        .when(AUTUMN.or(HALLOWEEN_EVENT)).when(LootItemRandomChanceCondition.randomChance(0.1F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_WINTER_ENTITY_COIN_DROPS)
                                        .when(WINTER.or(CHRISTMAS_EVENT).or(BIRTHDAY_EVENT).or(ANNIVERSARY_EVENT))
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F)))
                        )
        );
        consumer.accept(ModBuiltInLootTables.BOSS_COLLECTIBLE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .setBonusRolls(ConstantValue.exactly(1))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(DROPS_BOSS_CURRENCY)
                                .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(1)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_SPRING_ENTITY_COIN_DROPS).when(SPRING))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_SUMMER_ENTITY_COIN_DROPS).when(SUMMER))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_AUTUMN_ENTITY_COIN_DROPS).when(AUTUMN))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_WINTER_ENTITY_COIN_DROPS).when(WINTER))
                        )
        );
    }
}