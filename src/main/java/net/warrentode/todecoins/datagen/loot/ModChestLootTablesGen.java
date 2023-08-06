package net.warrentode.todecoins.datagen.loot;

import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;

import java.util.function.BiConsumer;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModChestLootTablesGen extends ChestLoot {
    public static final LootItemCondition.Builder IN_NETHER_WASTES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.NETHER_WASTES));
    public static final LootItemCondition.Builder IN_WARPED_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WARPED_FOREST));
    public static final LootItemCondition.Builder IN_CRIMSON_FOREST = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.CRIMSON_FOREST));
    public static final LootItemCondition.Builder IN_BASALT_DELTAS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.BASALT_DELTAS));
    public static final LootItemCondition.Builder IN_SOUL_SAND_VALLEY = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.SOUL_SAND_VALLEY));

    private static final ResourceLocation TODECOINS_CHEST_LOOT = new ResourceLocation(MODID, "chests/todecoins_chest");
    private static final ResourceLocation TODECOINS_COPPER_COIN_LOOT = new ResourceLocation(MODID, "chests/todecoins_copper_coin_loot");
    private static final ResourceLocation TODECOINS_IRON_COIN_LOOT = new ResourceLocation(MODID, "chests/todecoins_iron_coin_loot");
    private static final ResourceLocation TODECOINS_GOLD_COIN_LOOT = new ResourceLocation(MODID, "chests/todecoins_gold_coin_loot");
    private static final ResourceLocation TODECOINS_LUCKY_COIN_LOOT = new ResourceLocation(MODID, "chests/todecoins_lucky_coin_loot");
    private static final ResourceLocation TODECOINS_NETHERITE_COIN_LOOT = new ResourceLocation(MODID, "chests/todecoins_netherite_coin_loot");
    private static final ResourceLocation TODECOINS_NETHER_GOLD_COIN_LOOT = new ResourceLocation(MODID, "chests/todecoins_nether_gold_coin_loot");
    private static final ResourceLocation TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT = new ResourceLocation(MODID, "chests/todecoins_emerald_quarter_bank_note_loot");
    private static final ResourceLocation TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT = new ResourceLocation(MODID, "chests/todecoins_emerald_half_bank_note_loot");
    private static final ResourceLocation TODECOINS_EMERALD_BANK_NOTE_LOOT = new ResourceLocation(MODID, "chests/todecoins_emerald_bank_note_loot");

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(TODECOINS_CHEST_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(1.0F))
                                .add(LootTableReference.lootTableReference(TODECOINS_COPPER_COIN_LOOT)
                                        .setWeight(7).setQuality(0))
                                          .add(LootTableReference.lootTableReference(TODECOINS_IRON_COIN_LOOT)
                                                       .setWeight(6).setQuality(1))
                                          .add(LootTableReference.lootTableReference(TODECOINS_GOLD_COIN_LOOT)
                                                       .setWeight(5).setQuality(2))
                                          .add(LootTableReference.lootTableReference(TODECOINS_NETHER_GOLD_COIN_LOOT)
                                                       .when(IN_NETHER_WASTES.or(IN_CRIMSON_FOREST).or(IN_WARPED_FOREST).or(IN_BASALT_DELTAS).or(IN_SOUL_SAND_VALLEY))
                                                       .setWeight(5).setQuality(2))
                                          .add(LootTableReference.lootTableReference(TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT)
                                                       .setWeight(4).setQuality(3))
                                          .add(LootTableReference.lootTableReference(TODECOINS_NETHERITE_COIN_LOOT)
                                                       .setWeight(4).setQuality(4))
                                          .add(LootTableReference.lootTableReference(TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT)
                                                       .setWeight(3).setQuality(4))
                                          .add(LootTableReference.lootTableReference(TODECOINS_EMERALD_BANK_NOTE_LOOT)
                                                       .setWeight(2).setQuality(5))
                                          .add(LootTableReference.lootTableReference(TODECOINS_LUCKY_COIN_LOOT)
                                                       .setWeight(1).setQuality(6))
                        )
        );
        consumer.accept(TODECOINS_COPPER_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                          .setRolls(UniformGenerator.between(1.0F, 7.0F))
                                          .setBonusRolls(ConstantValue.exactly(1.0F))
                                          .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()).setWeight(1)
                                                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 7.0F))))
                                          .add(LootItem.lootTableItem(ModBlocks.COPPER_COIN_BAG.get()))
                )
        );
        consumer.accept(TODECOINS_IRON_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                          .setRolls(UniformGenerator.between(1.0F, 6.0F))
                                          .setBonusRolls(ConstantValue.exactly(1.0F))
                                          .add(LootItem.lootTableItem(ModItems.IRON_COIN.get()).setWeight(1)
                                                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F))))
                                          .add(LootItem.lootTableItem(ModBlocks.IRON_COIN_BAG.get()))
                        )
        );
        consumer.accept(TODECOINS_GOLD_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                          .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                          .setBonusRolls(ConstantValue.exactly(1.0F))
                                          .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get()).setWeight(1)
                                                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                          .add(LootItem.lootTableItem(ModBlocks.GOLD_COIN_BAG.get()))
                        )
        );
        consumer.accept(TODECOINS_NETHER_GOLD_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                          .setRolls(UniformGenerator.between(1.0F, 5.0F))
                                          .setBonusRolls(ConstantValue.exactly(1.0F))
                                          .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).setWeight(1)
                                                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                          .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()))
                        )
        );
        consumer.accept(TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                          .setRolls(UniformGenerator.between(1.0F, 4.0F))
                                          .setBonusRolls(ConstantValue.exactly(1.0F))
                                          .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get()).setWeight(1)
                                                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                                          .add(LootItem.lootTableItem(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()))
                        )
        );
        consumer.accept(TODECOINS_NETHERITE_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                          .setRolls(UniformGenerator.between(1.0F, 3.0F))
                                          .setBonusRolls(ConstantValue.exactly(1.0F))
                                          .add(LootItem.lootTableItem(ModItems.NETHER_GOLD_COIN.get()).setWeight(1)
                                                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                                          .add(LootItem.lootTableItem(ModBlocks.NETHER_GOLD_COIN_BAG.get()))
                        )
        );
        consumer.accept(TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                          .setRolls(UniformGenerator.between(1.0F, 3.0F))
                                          .setBonusRolls(ConstantValue.exactly(1.0F))
                                          .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get()).setWeight(1)
                                                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                                          .add(LootItem.lootTableItem(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()))
                        )
        );
        consumer.accept(TODECOINS_EMERALD_BANK_NOTE_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                          .setRolls(UniformGenerator.between(1.0F, 2.0F))
                                          .setBonusRolls(ConstantValue.exactly(1.0F))
                                          .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get()).setWeight(1)
                                                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                                          .add(LootItem.lootTableItem(ModBlocks.EMERALD_BANK_NOTE_BAG.get()))
                        )
        );
        consumer.accept(TODECOINS_LUCKY_COIN_LOOT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                          .setRolls(ConstantValue.exactly(1.0F))
                                          .add(LootItem.lootTableItem(ModItems.LUCKY_COIN.get()))
                        )
        );
    }
}