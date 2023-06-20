package net.warrentode.todecoins.datagen.loot_tables;

import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
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
import net.warrentode.todecoins.loot.conditions.season.*;
import net.warrentode.todecoins.loot.conditions.tag.EntityTypeTagCondition;
import net.warrentode.todecoins.util.tags.ForgeTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CurrencyDropLootTablesGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    public static final LootItemCondition.Builder IN_NETHER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.NETHER));
    public static final LootItemCondition.Builder DROPS_CURRENCY = EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.DROPS_CURRENCY).build();
    public static final LootItemCondition.Builder DROPS_BOSS_CURRENCY = EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.BOSSES).build();
    public static final LootItemCondition.Builder BIRTHDAY_EVENT = BirthdayCondition.event();
    public static final LootItemCondition.Builder HALLOWEEN_EVENT = HalloweenCondition.event();
    public static final LootItemCondition.Builder CHRISTMAS_EVENT = ChristmasCondition.event();
    public static final LootItemCondition.Builder ANNIVERSARY_EVENT = AnniversaryCondition.event();
    public static final LootItemCondition.Builder SPRING = SpringCondition.season();
    public static final LootItemCondition.Builder SUMMER = SummerCondition.season();
    public static final LootItemCondition.Builder AUTUMN = AutumnCondition.season();
    public static final LootItemCondition.Builder WINTER = WinterCondition.season();

    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        // injected entity loot table
        consumer.accept(ModBuiltInLootTables.TODECOINS_CURRENCY_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_COPPER_COIN_DROPS)
                                                .setWeight(1).setQuality(1).when(DROPS_CURRENCY))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_IRON_COIN_DROPS)
                                                .setWeight(1).setQuality(2).when(DROPS_CURRENCY))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_GOLD_COIN_DROPS)
                                                .setWeight(1).setQuality(3).when(DROPS_CURRENCY))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_DROPS)
                                                .setWeight(1).setQuality(3).when(DROPS_CURRENCY).when(IN_NETHER))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_DROPS)
                                                .setWeight(1).setQuality(4).when(DROPS_CURRENCY))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_DROPS)
                                                .setWeight(1).setQuality(5).when(DROPS_CURRENCY))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_DROPS)
                                                .setWeight(1).setQuality(5).when(DROPS_CURRENCY))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_DROPS)
                                                .setWeight(1).setQuality(6).when(DROPS_CURRENCY))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_DROPS)
                                                .when(BIRTHDAY_EVENT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_DROPS)
                                                .when(HALLOWEEN_EVENT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_DROPS)
                                                .when(CHRISTMAS_EVENT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_DROPS)
                                                .when(ANNIVERSARY_EVENT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ALLAY_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.ALLAY_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_AXOLOTL_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.AXOLOTL_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BAT_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.BAT_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BEE_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.BEE_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CAMEL_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.CAMEL_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CAT_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.CAT_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHICKEN_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.CHICKEN_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ENDERMAN_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.ENDERMAN_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_PIGLIN_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.PIGLIN_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CAVE_SPIDER_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.CAVE_SPIDER_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BLAZE_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.BLAZE_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_COD_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.COD_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_SALMON_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.SALMON_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_PUFFERFISH_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.PUFFERFISH_TYPES).build()))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_TROPICAL_FISH_COIN_DROPS)
                                                .setQuality(1).when(EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.TROPICAL_FISH_TYPES).build()))
                                 ));
        // injected entity loot table
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_CURRENCY_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_COPPER_COIN_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(-1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_IRON_COIN_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(0))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_GOLD_COIN_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_NETHER_GOLD_COIN_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).when(IN_NETHER).setWeight(1).setQuality(1))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_QUARTER_BANK_NOTE_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(2))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_NETHERITE_COIN_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(3))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_HALF_BANK_NOTE_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(3))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_BANK_NOTE_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(4))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BOSS_NETHERITE_COIN_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(5))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_DROPS)
                                                .when(DROPS_BOSS_CURRENCY).setWeight(1).setQuality(6))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_DROPS)
                                                .when(BIRTHDAY_EVENT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_DROPS)
                                                .when(HALLOWEEN_EVENT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_DROPS)
                                                .when(CHRISTMAS_EVENT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_DROPS)
                                                .when(ANNIVERSARY_EVENT))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_COPPER_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()).when(DROPS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_COPPER_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.COPPER_COIN_BAG.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_IRON_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.IRON_COIN.get()).when(DROPS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_IRON_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.IRON_COIN.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.IRON_COIN_BAG.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get()).when(DROPS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.GOLD_COIN_BAG.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHER_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).when(IN_NETHER).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_NETHER_GOLD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).when(IN_NETHER).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()).when(IN_NETHER).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_QUARTER_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get()).when(DROPS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_QUARTER_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_NETHERITE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_COIN.get()).when(DROPS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_NETHERITE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_COIN.get()).when(IN_NETHER).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.NETHERITE_COIN_BAG.get()).when(IN_NETHER).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_HALF_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get()).when(DROPS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_HALF_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_EMERALD_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get()).when(DROPS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BOSS_EMERALD_BANK_NOTE_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                        .add(LootItem.lootTableItem(ModBlocks.EMERALD_BANK_NOTE_BAG.get()).when(DROPS_BOSS_CURRENCY)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_LUCKY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.LUCKY_COIN.get()).when(DROPS_CURRENCY)
                                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.BIRTHDAY_COIN_2023.get()).when(BIRTHDAY_EVENT)
                                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.HALLOWEEN_COIN_2023.get()).when(HALLOWEEN_EVENT)
                                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.CHRISTMAS_COIN_2023.get()).when(CHRISTMAS_EVENT)
                                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .setBonusRolls(ConstantValue.exactly(1.0F))
                                        // newest coins weight = total number of entries
                                        .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_COSMOS_COIN.get()).when(ANNIVERSARY_EVENT)
                                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))
                                                .setQuality(0).setWeight(4))
                                        .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get()).when(ANNIVERSARY_EVENT)
                                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))
                                                .setQuality(0).setWeight(4))
                                        // old coins weight = 1
                                        .add(LootItem.lootTableItem(ModItems.MARSHALL_NASH_CARNATION_COIN.get()).when(ANNIVERSARY_EVENT)
                                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))
                                                .setQuality(0).setWeight(1))
                                        .add(LootItem.lootTableItem(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get()).when(ANNIVERSARY_EVENT)
                                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))
                                                .setQuality(0).setWeight(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_ALLAY_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_ALLAY_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_ALLAY_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_ALLAY_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_ALLAY_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_AXOLOTL_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_AXOLOTL_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_AXOLOTL_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_AXOLOTL_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_AXOLOTL_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BAT_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_BAT_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_BAT_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_BAT_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_BAT_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BEE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_BEE_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_BEE_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_BEE_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_BEE_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_CAMEL_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CAMEL_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CAMEL_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CAMEL_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CAMEL_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_CAT_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CAT_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CAT_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CAT_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CAT_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_ENDERMAN_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMAN_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_ENDERMAN_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMAN_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMAN_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_OCELOT_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_OCELOT_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_OCELOT_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_OCELOT_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_OCELOT_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_PIGLIN_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_COIN.get()).when(SPRING).setWeight(1).when(LootItemKilledByPlayerCondition.killedByPlayer()).setQuality(2))
                                        .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_COIN.get()).when(SUMMER).setWeight(1).when(LootItemKilledByPlayerCondition.killedByPlayer()).setQuality(2))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_COIN.get()).when(AUTUMN).setWeight(1).when(LootItemKilledByPlayerCondition.killedByPlayer()).setQuality(2))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_COIN.get()).when(WINTER).setWeight(1).when(LootItemKilledByPlayerCondition.killedByPlayer()).setQuality(2))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_CHICKEN_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CHICKEN_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CHICKEN_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CHICKEN_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CHICKEN_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_CAVE_SPIDER_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_CAVE_SPIDER_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_CAVE_SPIDER_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_CAVE_SPIDER_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_CAVE_SPIDER_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BLAZE_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_BLAZE_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_BLAZE_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_BLAZE_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_BLAZE_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_TROPICAL_FISH_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_TROPICAL_FISH_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_TROPICAL_FISH_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_TROPICAL_FISH_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_TROPICAL_FISH_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_PUFFERFISH_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_PUFFERFISH_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_PUFFERFISH_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_PUFFERFISH_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_PUFFERFISH_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_SALMON_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_SALMON_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_SALMON_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_SALMON_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_SALMON_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_COD_COIN_DROPS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_COD_COIN.get()).when(SPRING).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.IRON_COD_COIN.get()).when(SUMMER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_COD_COIN.get()).when(AUTUMN).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_COD_COIN.get()).when(WINTER).when(LootItemKilledByPlayerCondition.killedByPlayer()).setWeight(1).setQuality(1))
                                 ));
    }
}