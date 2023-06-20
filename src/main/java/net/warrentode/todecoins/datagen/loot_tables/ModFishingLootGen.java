package net.warrentode.todecoins.datagen.loot_tables;

import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.loot.FishingLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.TimeCheck;
import net.minecraft.world.level.storage.loot.predicates.WeatherCheck;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.warrentode.todecoins.loot.conditions.curio.CodFishCharmCondition;
import net.warrentode.todecoins.loot.conditions.curio.PufferfishCharmCondition;
import net.warrentode.todecoins.loot.conditions.curio.SalmonFishCharmCondition;
import net.warrentode.todecoins.loot.conditions.curio.TropicalFishCharmCondition;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class ModFishingLootGen extends FishingLoot {
    LootItemCondition.Builder COD_CHARM = CodFishCharmCondition.matches();
    LootItemCondition.Builder SALMON_CHARM = SalmonFishCharmCondition.matches();
    LootItemCondition.Builder PUFFERFISH_CHARM = PufferfishCharmCondition.matches();
    LootItemCondition.Builder TROPICAL_FISH_CHARM = TropicalFishCharmCondition.matches();

    // Cod Biomes
    public static final LootItemCondition.Builder IN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_OCEAN));

    // Cod & Pufferfish & Tropical Fish Biomes
    public static final LootItemCondition.Builder IN_LUKEWARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.LUKEWARM_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_LUKEWARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_LUKEWARM_OCEAN));

    // Cod & Salmon Biomes
    public static final LootItemCondition.Builder IN_COLD_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.COLD_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_COLD_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_COLD_OCEAN));

    // Salmon biomes
    public static final LootItemCondition.Builder IN_RIVER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.RIVER));
    public static final LootItemCondition.Builder IN_FROZEN_RIVER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FROZEN_RIVER));
    public static final LootItemCondition.Builder IN_FROZEN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FROZEN_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_FROZEN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_FROZEN_OCEAN));

    // Pufferfish & Tropical Fish Biomes
    public static final LootItemCondition.Builder IN_WARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WARM_OCEAN));

    // Tropical Fish Biomes
    public static final LootItemCondition.Builder IN_MANGROVE_SWAMP = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.MANGROVE_SWAMP));
    public static final LootItemCondition.Builder IN_LUSH_CAVES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.LUSH_CAVES));


    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.TODECOINS_FISHING_COINS,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_COD_COIN_LOOT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_PUFFERFISH_COIN_LOOT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_SALMON_COIN_LOOT))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_TROPICAL_FISH_COIN_LOOT))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_BONUS_FISHING,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_COD_COIN_FISHING).when(COD_CHARM))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_SALMON_COIN_FISHING).when(SALMON_CHARM))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_PUFFERFISH_COIN_FISHING).when(PUFFERFISH_CHARM))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_TROPICAL_FISH_COIN_FISHING).when(TROPICAL_FISH_CHARM))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_COD_COIN_FISHING,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.COD).setWeight(50).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                        .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)))
                                        .add(LootItem.lootTableItem(Items.SALMON).setWeight(10).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN)))
                                        .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(10).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_LUKEWARM_OCEAN.or(IN_LUKEWARM_OCEAN)))
                                        .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(10).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_LUKEWARM_OCEAN.or(IN_LUKEWARM_OCEAN)))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_SALMON_COIN_FISHING,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.SALMON).setWeight(50).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)
                                                        .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN)))
                                        .add(LootItem.lootTableItem(Items.COD).setWeight(10).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN)))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_PUFFERFISH_COIN_FISHING,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(50).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                        .add(LootItem.lootTableItem(Items.COD).setWeight(10).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN)))
                                        .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(10).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_TROPICAL_FISH_COIN_FISHING,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(50).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                                        .or(IN_MANGROVE_SWAMP).or(IN_LUSH_CAVES)))
                                        .add(LootItem.lootTableItem(Items.COD).setWeight(10).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN)))
                                        .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(10).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                 ));
    }
}