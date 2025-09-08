package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static com.github.warrentode.todecoins.datagen.LootTablesGen.*;

public class EntityLootGen implements LootTableSubProvider {
    @Override
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.MASTER_DROPS_LOOT,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .setBonusRolls(ConstantValue.exactly(0F))
                        .add(LootTableReference.lootTableReference(
                                        ModBuiltInLootTables.MASTER_COLLECTIBLE_COIN_DROPS)
                                .when(DROPS_COLLECTIBLE_COIN_BLACKLISTED.invert()
                                        .and(COLLECTIBLE_COIN_CHANCE.and(IS_BOSS.invert()))))
                        .add(LootTableReference.lootTableReference(TradeLootTables.ONE_EMERALD_VALUE_CURRENCY)
                                .when(DROPS_CURRENCY_BLACKLISTED.invert()
                                        .and(CURRENCY_CHANCE.and(IS_BOSS.invert()))))
                        .add(LootTableReference.lootTableReference(
                                        ModBuiltInLootTables.BOSS_COLLECTIBLE_COIN_DROPS)
                                .when(DROPS_COLLECTIBLE_COIN_BLACKLISTED.invert()
                                        .and(IS_BOSS)))
                        .add(LootTableReference.lootTableReference(
                                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY)
                                .when(DROPS_CURRENCY_BLACKLISTED.invert()
                                        .and(IS_BOSS)))
                ));
    }
}