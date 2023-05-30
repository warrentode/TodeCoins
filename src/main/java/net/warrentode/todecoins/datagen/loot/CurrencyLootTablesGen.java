package net.warrentode.todecoins.datagen.loot;

import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.warrentode.todecoins.loot.conditions.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CurrencyLootTablesGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    public static final LootItemCondition.Builder IN_NETHER_WASTES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.NETHER_WASTES));
    public static final LootItemCondition.Builder IN_WARPED_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WARPED_FOREST));
    public static final LootItemCondition.Builder IN_CRIMSON_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.CRIMSON_FOREST));
    public static final LootItemCondition.Builder IN_BASALT_DELTAS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.BASALT_DELTAS));
    public static final LootItemCondition.Builder IN_SOUL_SAND_VALLEY = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SOUL_SAND_VALLEY));
    public static final LootItemCondition.Builder BIRTHDAY_EVENT = BirthdayCondition.event();
    public static final LootItemCondition.Builder HALLOWEEN_EVENT = HalloweenCondition.event();
    public static final LootItemCondition.Builder CHRISTMAS_EVENT = ChristmasCondition.event();
    public static final LootItemCondition.Builder ANNIVERSARY_EVENT = AnniversaryCondition.event();

    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        // injected entity loot table
        consumer.accept(ModBuiltInLootTables.TODECOINS_CURRENCY_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_COPPER_COIN_DROPS)
                                        .setWeight(1).setQuality(1))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_IRON_COIN_DROPS)
                                        .setWeight(1).setQuality(2))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_GOLD_COIN_DROPS)
                                        .setWeight(1).setQuality(3))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_DROPS)
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST).or(IN_BASALT_DELTAS).or(IN_SOUL_SAND_VALLEY))
                                        .setWeight(1).setQuality(3))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_DROPS)
                                        .setWeight(1).setQuality(4))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_DROPS)
                                        .setWeight(1).setQuality(5))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_DROPS)
                                        .setWeight(1).setQuality(5))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_DROPS)
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_DROPS)
                                        .when(BIRTHDAY_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_DROPS)
                                        .when(HALLOWEEN_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_DROPS)
                                        .when(CHRISTMAS_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_DROPS)
                                        .when(ANNIVERSARY_EVENT))
                        )
        );
        // injected entity loot table
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_CURRENCY_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_COPPER_COIN_DROPS)
                                        .setWeight(1).setQuality(-1))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_IRON_COIN_DROPS)
                                        .setWeight(1).setQuality(0))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_GOLD_COIN_DROPS)
                                        .setWeight(1).setQuality(1))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_NETHER_GOLD_COIN_DROPS)
                                        .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST).or(IN_BASALT_DELTAS).or(IN_SOUL_SAND_VALLEY))
                                        .setWeight(1).setQuality(1))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_QUARTER_BANK_NOTE_DROPS)
                                        .setWeight(1).setQuality(2))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_NETHERITE_COIN_DROPS)
                                        .setWeight(1).setQuality(3))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_HALF_BANK_NOTE_DROPS)
                                        .setWeight(1).setQuality(3))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_BANK_NOTE_DROPS)
                                        .setWeight(1).setQuality(4))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_NETHERITE_COIN_DROPS)
                                        .setWeight(1).setQuality(5))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_DROPS)
                                        .setWeight(1).setQuality(6))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_DROPS)
                                        .when(BIRTHDAY_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_DROPS)
                                        .when(HALLOWEEN_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_DROPS)
                                        .when(CHRISTMAS_EVENT))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_DROPS)
                                        .when(ANNIVERSARY_EVENT))
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_COPPER_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_COPPER_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(ModBlocks.COPPER_COIN_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_IRON_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.IRON_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_IRON_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.IRON_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(ModBlocks.IRON_COIN_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(ModBlocks.GOLD_COIN_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST).or(IN_BASALT_DELTAS).or(IN_SOUL_SAND_VALLEY))
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_NETHER_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST).or(IN_BASALT_DELTAS).or(IN_SOUL_SAND_VALLEY))
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_QUARTER_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_NETHERITE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST).or(IN_BASALT_DELTAS).or(IN_SOUL_SAND_VALLEY))
                                .add(LootItem.lootTableItem(ModBlocks.NETHERITE_COIN_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST).or(IN_BASALT_DELTAS).or(IN_SOUL_SAND_VALLEY))
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_HALF_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_BANK_NOTE_BAG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.LUCKY_COIN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        // injected entity loot table
        consumer.accept(ModBuiltInLootTables.TODECOINS_ENDERMAN_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMAN_COIN.get()).when(SpringCondition.season()).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.IRON_ENDERMAN_COIN.get()).when(SummerCondition.season()).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMAN_COIN.get()).when(SpringCondition.season()).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMAN_COIN.get()).when(SpringCondition.season()).setWeight(1))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.BIRTHDAY_COIN_2023.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(BIRTHDAY_EVENT)
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.HALLOWEEN_COIN_2023.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .when(HALLOWEEN_EVENT))
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.CHRISTMAS_COIN_2023.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(CHRISTMAS_EVENT)
                        )
        );
        consumer.accept(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                // newest coins weight = total number of entries
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_COSMOS_COIN.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))
                                        .setQuality(0).setWeight(4))
                                .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))
                                        .setQuality(0).setWeight(4))
                                // old coins weight = 1
                                .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_CARNATION_COIN.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))
                                        .setQuality(0).setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))
                                        .setQuality(0).setWeight(1))
                                .when(ANNIVERSARY_EVENT)
                        )
        );
    }
}