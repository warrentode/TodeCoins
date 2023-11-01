package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.loot.CageriumLootTables;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;
import samebutdifferent.ecologics.registry.ModItems;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CageriumLootTablesGen implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    // the primary purpose of these tables is to keep currency out of the auto farming system to preserve gameplay
    // balance and this needs to be hardcoded into this class to prevent GLM from accidentally landing in these tables
    protected static final EntityPredicate.Builder ENTITY_ON_FIRE = EntityPredicate.Builder.entity()
            .flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build());
    private static final ResourceLocation FISHING_FISH = path("minecraft", "cagerium/gameplay/fishing/fish");

    static ResourceLocation path(String modid, String path) {
        return new ResourceLocation(modid, path);
    }

    private static LootTable.Builder createSheepTable(ItemLike pWool) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pWool)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootTableReference.lootTableReference(CageriumLootTables.SHEEP)));
    }

    private LootItemCondition.Builder killedByFrog() {
        return DamageSourceCondition.hasDamageSource(DamageSourcePredicate.Builder.damageType()
                                                             .source(EntityPredicate.Builder.entity()
                                                                             .of(EntityType.FROG)));
    }

    private LootItemCondition.Builder killedByFrogVariant(FrogVariant variant) {
        return DamageSourceCondition.hasDamageSource(DamageSourcePredicate.Builder.damageType()
                                                             .source(EntityPredicate.Builder.entity()
                                                                             .of(EntityType.FROG)
                                                                             .subPredicate(EntitySubPredicate.variant(
                                                                                     variant))));
    }

    @Override public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        // and I think it's really stupid that I can't seem to import the vanilla built in loot tables and need to
        // rewrite them completely into my datagen
        consumer.accept(FISHING_FISH, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.COD).setWeight(60))
                                  .add(LootItem.lootTableItem(Items.SALMON).setWeight(25))
                                  .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(2))
                                  .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(13))));

        consumer.accept(CageriumLootTables.SHEEP_YELLOW, createSheepTable(Blocks.YELLOW_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_WHITE, createSheepTable(Blocks.WHITE_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_RED, createSheepTable(Blocks.RED_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_PURPLE, createSheepTable(Blocks.PURPLE_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_PINK, createSheepTable(Blocks.PINK_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_ORANGE, createSheepTable(Blocks.ORANGE_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_MAGENTA, createSheepTable(Blocks.MAGENTA_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_LIME, createSheepTable(Blocks.LIME_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_LIGHT_GRAY, createSheepTable(Blocks.LIGHT_GRAY_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_LIGHT_BLUE, createSheepTable(Blocks.LIGHT_BLUE_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_GREEN, createSheepTable(Blocks.GREEN_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_GRAY, createSheepTable(Blocks.GRAY_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_CYAN, createSheepTable(Blocks.CYAN_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_BROWN, createSheepTable(Blocks.BROWN_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_BLUE, createSheepTable(Blocks.BLUE_WOOL));
        consumer.accept(CageriumLootTables.SHEEP_BLACK, createSheepTable(Blocks.BLACK_WOOL));

        consumer.accept(CageriumLootTables.ALLAY, LootTable.lootTable());
        consumer.accept(CageriumLootTables.AXOLOTL, LootTable.lootTable());
        consumer.accept(CageriumLootTables.BAT, LootTable.lootTable());
        consumer.accept(CageriumLootTables.BEE, LootTable.lootTable());
        consumer.accept(CageriumLootTables.ENDER_DRAGON, LootTable.lootTable());
        consumer.accept(CageriumLootTables.ENDERMITE, LootTable.lootTable());
        consumer.accept(CageriumLootTables.FROG, LootTable.lootTable());
        consumer.accept(CageriumLootTables.FOX, LootTable.lootTable());
        consumer.accept(CageriumLootTables.GOAT, LootTable.lootTable());
        consumer.accept(CageriumLootTables.ILLUSIONER, LootTable.lootTable());
        consumer.accept(CageriumLootTables.OCELOT, LootTable.lootTable());
        consumer.accept(CageriumLootTables.PILLAGER, LootTable.lootTable());
        consumer.accept(CageriumLootTables.SILVERFISH, LootTable.lootTable());
        consumer.accept(CageriumLootTables.TADPOLE, LootTable.lootTable());
        consumer.accept(CageriumLootTables.VEX, LootTable.lootTable());
        consumer.accept(CageriumLootTables.VILLAGER, LootTable.lootTable());
        consumer.accept(CageriumLootTables.WANDERING_TRADER, LootTable.lootTable());
        consumer.accept(CageriumLootTables.WITHER, LootTable.lootTable());
        consumer.accept(CageriumLootTables.WOLF, LootTable.lootTable());
        consumer.accept(CageriumLootTables.PIGLIN, LootTable.lootTable());
        consumer.accept(CageriumLootTables.PIGLIN_BRUTE, LootTable.lootTable());
        consumer.accept(CageriumLootTables.GIANT, LootTable.lootTable());
        consumer.accept(CageriumLootTables.NUMISMATIST, LootTable.lootTable());
        consumer.accept(CageriumLootTables.ICEOLOGER, LootTable.lootTable());
        consumer.accept(CageriumLootTables.WILDFIRE, LootTable.lootTable());
        consumer.accept(CageriumLootTables.PENGUIN, LootTable.lootTable());
        consumer.accept(CageriumLootTables.SQUIRREL, LootTable.lootTable());
        consumer.accept(CageriumLootTables.GUARD, LootTable.lootTable());
        consumer.accept(CageriumLootTables.RASCAL, LootTable.lootTable());

        consumer.accept(CageriumLootTables.CRAB, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.CRAB_CLAW.get()).apply(SetItemCountFunction.setCount(
                                        ConstantValue.exactly(1.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition.hasProperties(
                                                LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))));

        consumer.accept(CageriumLootTables.CAMEL, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER)
                                .apply(SetItemCountFunction.setCount(
                                        UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(
                                        UniformGenerator.between(0.0F, 1.0F))))));

        consumer.accept(CageriumLootTables.MOOBLOOM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(
                                UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BEEF).apply(SetItemCountFunction.setCount(
                                        UniformGenerator.between(1.0F, 3.0F)))
                                .apply(SmeltItemFunction.smelted()
                                        .when(LootItemEntityPropertyCondition.hasProperties(
                                                LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                ));
        consumer.accept(CageriumLootTables.COPPER_GOLEM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(Items.COPPER_INGOT))
                ));
        consumer.accept(CageriumLootTables.TUFF_GOLEM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(Items.TUFF))
                ));
        consumer.accept(CageriumLootTables.GLARE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0F, 2.0F))
                        .add(LootItem.lootTableItem(Items.GLOW_BERRIES))
                ));
        consumer.accept(CageriumLootTables.CAT, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.STRING)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F))))));
        consumer.accept(CageriumLootTables.CAVE_SPIDER, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.STRING)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.SPIDER_EYE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(-1.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())));
        consumer.accept(CageriumLootTables.CHICKEN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.FEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.CHICKEN)
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.COD, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.COD)
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BONE_MEAL))
                                  .when(LootItemRandomChanceCondition.randomChance(0.05F))));
        consumer.accept(CageriumLootTables.COW, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.LEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BEEF)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(1.0F, 3.0F)))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.CREEPER, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.GUNPOWDER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .add(TagEntry.expandTag(ItemTags.CREEPER_DROP_MUSIC_DISCS))
                                  .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.KILLER,
                                                                                      EntityPredicate.Builder.entity()
                                                                                              .of(EntityTypeTags.SKELETONS)))));
        consumer.accept(CageriumLootTables.DOLPHIN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.COD)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS,
                                                                      ENTITY_ON_FIRE))))));
        consumer.accept(CageriumLootTables.DONKEY, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.LEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.DROWNED, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.COPPER_INGOT))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.11F, 0.02F))));
        consumer.accept(CageriumLootTables.ELDER_GUARDIAN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.PRISMARINE_SHARD)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.COD)
                                               .setWeight(3)
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                                  .add(LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS)
                                               .setWeight(2)
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .add(EmptyLootItem.emptyItem()))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Blocks.WET_SPONGE))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer()))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootTableReference.lootTableReference(Objects.requireNonNull(FISHING_FISH))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.025F, 0.01F))));
        consumer.accept(CageriumLootTables.ENDERMAN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ENDER_PEARL)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.EVOKER, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.TOTEM_OF_UNDYING)))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.EMERALD)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())));
        consumer.accept(CageriumLootTables.GHAST, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.GHAST_TEAR)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.GUNPOWDER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.GLOW_SQUID, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.GLOW_INK_SAC)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(1.0F, 3.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.GUARDIAN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.PRISMARINE_SHARD)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.COD)
                                               .setWeight(2)
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                                  .add(LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS)
                                               .setWeight(2)
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .add(EmptyLootItem.emptyItem()))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootTableReference.lootTableReference(Objects.requireNonNull(FISHING_FISH))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.025F, 0.01F))));
        consumer.accept(CageriumLootTables.HORSE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.LEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.HUSK, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.IRON_INGOT))
                                  .add(LootItem.lootTableItem(Items.CARROT))
                                  .add(LootItem.lootTableItem(Items.POTATO)
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.025F, 0.01F))));
        consumer.accept(CageriumLootTables.RAVAGER, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.SADDLE)
                                               .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
        consumer.accept(CageriumLootTables.IRON_GOLEM, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Blocks.POPPY)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(3.0F, 5.0F))))));
        consumer.accept(CageriumLootTables.LLAMA, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.LEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.MAGMA_CUBE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.MAGMA_CREAM)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(-2.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .when(this.killedByFrog().invert())
                                               .when(LootItemEntityPropertyCondition.hasProperties(
                                                       LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity()
                                                               .subPredicate(SlimePredicate.sized(
                                                                       MinMaxBounds.Ints.atLeast(2))))))
                                  .add(LootItem.lootTableItem(Items.PEARLESCENT_FROGLIGHT)
                                               .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                               .when(this.killedByFrogVariant(FrogVariant.WARM)))
                                  .add(LootItem.lootTableItem(Items.VERDANT_FROGLIGHT)
                                               .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                               .when(this.killedByFrogVariant(FrogVariant.COLD)))
                                  .add(LootItem.lootTableItem(Items.OCHRE_FROGLIGHT)
                                               .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                               .when(this.killedByFrogVariant(FrogVariant.TEMPERATE)))));
        consumer.accept(CageriumLootTables.MULE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.LEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.MOOSHROOM, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.LEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BEEF)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(1.0F, 3.0F)))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.PANDA, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Blocks.BAMBOO)
                                               .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
        consumer.accept(CageriumLootTables.PARROT, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.FEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(1.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.PHANTOM, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.PHANTOM_MEMBRANE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())));
        consumer.accept(CageriumLootTables.PIG, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.PORKCHOP)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(1.0F, 3.0F)))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.POLAR_BEAR, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.COD)
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                               .setWeight(3)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .add(LootItem.lootTableItem(Items.SALMON)
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.PUFFERFISH, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.PUFFERFISH)
                                               .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BONE_MEAL))
                                  .when(LootItemRandomChanceCondition.randomChance(0.05F))));
        consumer.accept(CageriumLootTables.RABBIT, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.RABBIT_HIDE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.RABBIT)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.RABBIT_FOOT))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.1F, 0.03F))));
        consumer.accept(CageriumLootTables.SALMON, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.SALMON)
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BONE_MEAL))
                                  .when(LootItemRandomChanceCondition.randomChance(0.05F))));
        consumer.accept(CageriumLootTables.SHEEP, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.MUTTON)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(1.0F, 2.0F)))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.SHULKER, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.SHULKER_SHELL))
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.5F, 0.0625F))));
        consumer.accept(CageriumLootTables.SKELETON, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ARROW)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BONE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.SKELETON_HORSE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BONE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.SLIME, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.SLIME_BALL)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .when(this.killedByFrog().invert()))
                                  .add(LootItem.lootTableItem(Items.SLIME_BALL)
                                               .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                               .when(this.killedByFrog()))
                                  .when(LootItemEntityPropertyCondition
                                                .hasProperties(
                                                        LootContext.EntityTarget.THIS,
                                                        EntityPredicate.Builder.entity()
                                                                .subPredicate(SlimePredicate.sized(
                                                                        MinMaxBounds.Ints.exactly(1)))))));
        consumer.accept(CageriumLootTables.SNOW_GOLEM, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.SNOWBALL)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 15.0F))))));
        consumer.accept(CageriumLootTables.SPIDER, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.STRING)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.SPIDER_EYE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(-1.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())));
        consumer.accept(CageriumLootTables.SQUID, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.INK_SAC)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(1.0F, 3.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.STRAY, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ARROW)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BONE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)).setLimit(1))
                                               .apply(SetPotionFunction.setPotion(Potions.SLOWNESS)))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())));
        consumer.accept(CageriumLootTables.STRIDER, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.STRING)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(2.0F, 5.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.TRADER_LLAMA, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.LEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.TROPICAL_FISH, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.TROPICAL_FISH)
                                               .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BONE_MEAL))
                                  .when(LootItemRandomChanceCondition.randomChance(0.05F))));
        consumer.accept(CageriumLootTables.TURTLE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Blocks.SEAGRASS)
                                               .setWeight(3)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BOWL))
                                  .when(DamageSourceCondition.hasDamageSource(
                                          DamageSourcePredicate.Builder.damageType().isLightning(true)))));
        consumer.accept(CageriumLootTables.WARDEN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.SCULK_CATALYST))));
        consumer.accept(CageriumLootTables.VINDICATOR, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.EMERALD)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())));
        consumer.accept(CageriumLootTables.WITCH, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(UniformGenerator.between(1.0F, 3.0F))
                                  .add(LootItem.lootTableItem(Items.GLOWSTONE_DUST)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .add(LootItem.lootTableItem(Items.SUGAR)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .add(LootItem.lootTableItem(Items.REDSTONE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .add(LootItem.lootTableItem(Items.SPIDER_EYE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .add(LootItem.lootTableItem(Items.GLASS_BOTTLE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .add(LootItem.lootTableItem(Items.GUNPOWDER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))
                                  .add(LootItem.lootTableItem(Items.STICK)
                                               .setWeight(2)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.WITHER_SKELETON, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.COAL)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(-1.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.BONE)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Blocks.WITHER_SKELETON_SKULL))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.025F, 0.01F))));
        consumer.accept(CageriumLootTables.ZOGLIN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(1.0F, 3.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.ZOMBIE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.IRON_INGOT))
                                  .add(LootItem.lootTableItem(Items.CARROT))
                                  .add(LootItem.lootTableItem(Items.POTATO)
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.025F, 0.01F))));
        consumer.accept(CageriumLootTables.ZOMBIE_HORSE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.ZOMBIFIED_PIGLIN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.GOLD_NUGGET)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.GOLD_INGOT))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.025F, 0.01F))));
        consumer.accept(CageriumLootTables.HOGLIN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.PORKCHOP)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(2.0F, 4.0F)))
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.LEATHER)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 1.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F))))));
        consumer.accept(CageriumLootTables.ZOMBIE_VILLAGER, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                               .apply(SetItemCountFunction.setCount(
                                                       UniformGenerator.between(0.0F, 2.0F)))
                                               .apply(LootingEnchantFunction.lootingMultiplier(
                                                       UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool()
                                  .setRolls(ConstantValue.exactly(1.0F))
                                  .add(LootItem.lootTableItem(Items.IRON_INGOT))
                                  .add(LootItem.lootTableItem(Items.CARROT))
                                  .add(LootItem.lootTableItem(Items.POTATO)
                                               .apply(SmeltItemFunction.smelted()
                                                              .when(LootItemEntityPropertyCondition.hasProperties(
                                                                      LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
                                  .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                  .when(LootItemRandomChanceWithLootingCondition
                                                .randomChanceAndLootingBoost(0.025F, 0.01F))));
    }
}