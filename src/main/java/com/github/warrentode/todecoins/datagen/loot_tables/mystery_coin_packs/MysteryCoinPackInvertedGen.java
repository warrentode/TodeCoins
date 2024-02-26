package com.github.warrentode.todecoins.datagen.loot_tables.mystery_coin_packs;

import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.conditions.season.*;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class MysteryCoinPackInvertedGen extends ChestLoot {
    public static final LootItemCondition.Builder IN_OVERWORLD =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.OVERWORLD));
    public static final LootItemCondition.Builder BIRTHDAY_EVENT = BirthdayCondition.event();
    public static final LootItemCondition.Builder HALLOWEEN_EVENT = HalloweenCondition.event();
    public static final LootItemCondition.Builder CHRISTMAS_EVENT = ChristmasCondition.event();
    public static final LootItemCondition.Builder EASTER_EVENT = EasterCondition.event();
    public static final LootItemCondition.Builder NEW_YEAR_EVENT = NewYearCondition.event();
    public static final LootItemCondition.Builder ANNIVERSARY_EVENT = AnniversaryCondition.event();
    public static final LootItemCondition.Builder SPRING = SpringCondition.season();
    public static final LootItemCondition.Builder SUMMER = SummerCondition.season();
    public static final LootItemCondition.Builder AUTUMN = AutumnCondition.season();
    public static final LootItemCondition.Builder WINTER = WinterCondition.season();

    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(6))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT)
                                        .when(IN_OVERWORLD).when(BIRTHDAY_EVENT.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_BIRTHDAY_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT)
                                        .when(IN_OVERWORLD).when(ANNIVERSARY_EVENT.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_ANNIVERSARY_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT)
                                        .when(IN_OVERWORLD).when(HALLOWEEN_EVENT.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_HALLOWEEN_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT)
                                        .when(IN_OVERWORLD).when(CHRISTMAS_EVENT.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_CHRISTMAS_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_NEW_YEAR_COIN_LOOT)
                                        .when(IN_OVERWORLD).when(NEW_YEAR_EVENT.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_NEW_YEAR_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_EASTER_COIN_LOOT)
                                        .when(IN_OVERWORLD).when(EASTER_EVENT.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference
                                        .lootTableReference(ModBuiltInLootTables.TODECOINS_EASTER_COIN_LOOT)
                                        .when(IN_OVERWORLD.invert())
                                        .when(LootItemRandomChanceCondition.randomChance(0.25F)))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SPRING_MYSTERY_COIN_PACK)
                                        .when(IN_OVERWORLD).when(SPRING.invert().or(EASTER_EVENT.invert()).or(NEW_YEAR_EVENT.invert())))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SPRING_MYSTERY_COIN_PACK)
                                        .when(IN_OVERWORLD.invert()))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SUMMER_MYSTERY_COIN_PACK)
                                        .when(IN_OVERWORLD).when(SUMMER.invert()))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.SUMMER_MYSTERY_COIN_PACK)
                                        .when(IN_OVERWORLD.invert()))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.AUTUMN_MYSTERY_COIN_PACK)
                                        .when(IN_OVERWORLD).when(AUTUMN.invert().or(HALLOWEEN_EVENT.invert())))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.AUTUMN_MYSTERY_COIN_PACK)
                                        .when(IN_OVERWORLD.invert()))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.WINTER_MYSTERY_COIN_PACK)
                                        .when(IN_OVERWORLD).when(WINTER.invert().or(CHRISTMAS_EVENT.invert()).or(BIRTHDAY_EVENT.invert()).or(ANNIVERSARY_EVENT.invert())))
                                .add(LootTableReference.lootTableReference(ModBuiltInLootTables.WINTER_MYSTERY_COIN_PACK)
                                        .when(IN_OVERWORLD.invert()))
                        ));
    }
}