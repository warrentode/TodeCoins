package com.github.warrentode.todecoins.datagen.loot_tables.entity_drops;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.conditions.tag.EntityTypeTagCondition;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CoinDropsBossGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    public static final LootItemCondition.Builder IN_NETHER =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.NETHER));
    public static final LootItemCondition.Builder IN_THE_END =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.END));
    public static final LootItemCondition.Builder DROPS_BOSS_CURRENCY =
            EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.BOSSES).build();

    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_CURRENCY_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(10.0F, 15.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(1)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_DROPS)
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F))
                                        .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(6))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_COPPER_COIN_DROPS)
                                        .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(0))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_IRON_COIN_DROPS)
                                        .when(DROPS_BOSS_CURRENCY).setWeight(2).setQuality(0))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_GOLD_COIN_DROPS)
                                        .when(DROPS_BOSS_CURRENCY).setWeight(3).setQuality(1))
                                .add(LootTableReference.
                                        lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_NETHER_GOLD_COIN_DROPS)
                                        .when(DROPS_BOSS_CURRENCY).when(IN_NETHER).setWeight(4).setQuality(1))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_ENDONIAN_COIN_DROPS)
                                        .setWeight(5).setQuality(3).when(DROPS_BOSS_CURRENCY).when(IN_THE_END))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_QUARTER_BANK_NOTE_DROPS)
                                        .when(DROPS_BOSS_CURRENCY).setWeight(6).setQuality(2))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_NETHERITE_COIN_DROPS)
                                        .when(DROPS_BOSS_CURRENCY).setWeight(7).setQuality(3))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_HALF_BANK_NOTE_DROPS)
                                        .when(DROPS_BOSS_CURRENCY).setWeight(8).setQuality(3))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_BANK_NOTE_DROPS)
                                        .when(DROPS_BOSS_CURRENCY).setWeight(9).setQuality(4))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_NETHERITE_COIN_DROPS)
                                        .when(DROPS_BOSS_CURRENCY).setWeight(10).setQuality(5))
                                .add(EmptyLootItem.emptyItem())
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_COPPER_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(ModBlocks.COPPER_COIN_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_IRON_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(ModBlocks.IRON_COIN_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(ModBlocks.GOLD_COIN_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_NETHER_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()).when(IN_NETHER)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_ENDONIAN_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(ModBlocks.ENDONIAN_COIN_BAG.get()).when(IN_THE_END)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_QUARTER_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_NETHERITE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(ModBlocks.NETHERITE_COIN_BAG.get()).when(IN_NETHER)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_HALF_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem
                                        .lootTableItem(ModBlocks.EMERALD_BANK_NOTE_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem
                                        .lootTableItem(ModItems.LUCKY_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(0F))))
                        ));
    }
}