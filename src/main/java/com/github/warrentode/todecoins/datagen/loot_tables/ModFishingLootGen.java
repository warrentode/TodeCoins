package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.conditions.curio.CodFishCharmCondition;
import com.github.warrentode.todecoins.loot.conditions.curio.PufferfishCharmCondition;
import com.github.warrentode.todecoins.loot.conditions.curio.SalmonFishCharmCondition;
import com.github.warrentode.todecoins.loot.conditions.curio.TropicalFishCharmCondition;
import com.github.warrentode.todecoins.loot.conditions.season.AutumnCondition;
import com.github.warrentode.todecoins.loot.conditions.season.SpringCondition;
import com.github.warrentode.todecoins.loot.conditions.season.SummerCondition;
import com.github.warrentode.todecoins.loot.conditions.season.WinterCondition;
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
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
    public static final LootItemCondition.Builder SPRING = SpringCondition.season();
    public static final LootItemCondition.Builder SUMMER = SummerCondition.season();
    public static final LootItemCondition.Builder AUTUMN = AutumnCondition.season();
    public static final LootItemCondition.Builder WINTER = WinterCondition.season();

    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.TODECOINS_FISHING_COINS,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_COD_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_SALMON_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_PUFFERFISH_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_TROPICAL_FISH_COIN.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(ModItems.IRON_COD_COIN.get()).when(SUMMER))
                                        .add(LootItem.lootTableItem(ModItems.IRON_SALMON_COIN.get()).when(SUMMER))
                                        .add(LootItem.lootTableItem(ModItems.IRON_PUFFERFISH_COIN.get()).when(SUMMER))
                                        .add(LootItem.lootTableItem(ModItems.IRON_TROPICAL_FISH_COIN.get()).when(SUMMER))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_COD_COIN.get()).when(AUTUMN))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_SALMON_COIN.get()).when(AUTUMN))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_PUFFERFISH_COIN.get()).when(AUTUMN))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_TROPICAL_FISH_COIN.get()).when(AUTUMN))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_COD_COIN.get()).when(WINTER))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_SALMON_COIN.get()).when(WINTER))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_PUFFERFISH_COIN.get()).when(WINTER))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_TROPICAL_FISH_COIN.get()).when(WINTER))
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
        consumer.accept(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_JUNK,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.STRING))
                                .add(LootItem.lootTableItem(Items.STICK))
                                .add(LootItem.lootTableItem(Items.BONE))
                                .add(LootItem.lootTableItem(Items.GLASS_BOTTLE))
                                .add(LootItem.lootTableItem(Items.SNOWBALL).when(IN_FROZEN_OCEAN.or(IN_FROZEN_RIVER).or(IN_DEEP_FROZEN_OCEAN)))
                                .add(LootItem.lootTableItem(Items.MUDDY_MANGROVE_ROOTS).when(IN_MANGROVE_SWAMP))
                                .add(LootItem.lootTableItem(Items.HANGING_ROOTS).when(IN_LUSH_CAVES))
                                .add(LootItem.lootTableItem(Items.DEAD_TUBE_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                .add(LootItem.lootTableItem(Items.DEAD_BRAIN_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                .add(LootItem.lootTableItem(Items.DEAD_BUBBLE_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                .add(LootItem.lootTableItem(Items.DEAD_FIRE_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                .add(LootItem.lootTableItem(Items.DEAD_HORN_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                .when(COD_CHARM.or(SALMON_CHARM).or(PUFFERFISH_CHARM.or(TROPICAL_FISH_CHARM)))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_TREASURE,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()).setWeight(15).setQuality(0))
                                .add(LootItem.lootTableItem(ModItems.IRON_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.6F)).setWeight(7).setQuality(1))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.5F)).setWeight(6).setQuality(2))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.4F)).setWeight(5).setQuality(3))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.3F)).setWeight(4).setQuality(4))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.2F)).setWeight(3).setQuality(5))
                                .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F)).setWeight(2).setQuality(6))
                                .add(LootItem.lootTableItem(ModBlocks.COPPER_COIN_BAG.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.8F)).setWeight(1).setQuality(0))
                                .add(LootItem.lootTableItem(ModBlocks.IRON_COIN_BAG.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.7F)).setWeight(1).setQuality(1))
                                .add(LootItem.lootTableItem(ModBlocks.GOLD_COIN_BAG.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.6F)).setWeight(1).setQuality(1))
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.5F)).setWeight(1).setQuality(2))
                                .add(LootItem.lootTableItem(ModBlocks.NETHERITE_COIN_BAG.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.4F)).setWeight(1).setQuality(3))
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.3F)).setWeight(1).setQuality(4))
                                .add(LootItem.lootTableItem(ModBlocks.EMERALD_BANK_NOTE_BAG.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.2F)).setWeight(1).setQuality(5))
                                .add(LootItem.lootTableItem(ModItems.LUCKY_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.1F)).setWeight(1).setQuality(6))
                                .when(COD_CHARM.or(SALMON_CHARM).or(PUFFERFISH_CHARM.or(TROPICAL_FISH_CHARM)))
                        ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_COD_COIN_FISHING,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0, 1))
                                .add(LootItem.lootTableItem(Items.COD)
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN).or(IN_LUKEWARM_OCEAN)
                                                .or(IN_DEEP_LUKEWARM_OCEAN).or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)))
                        )
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
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_JUNK).setQuality(-2)
                                                .when(TimeCheck.time(IntRange.range(0, 5999)).or(TimeCheck.time(IntRange.range(12001, 23999)))))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_TREASURE).setQuality(2)
                                                .when(TimeCheck.time(IntRange.range(0, 5999)).or(TimeCheck.time(IntRange.range(12001, 23999)))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_SALMON_COIN_FISHING,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0, 1))
                                .add(LootItem.lootTableItem(Items.SALMON)
                                        .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN)))
                        )
                        .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.SALMON).setWeight(50).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN).or(IN_RIVER).or(IN_FROZEN_RIVER)
                                                        .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN)))
                                        .add(LootItem.lootTableItem(Items.COD).setWeight(10).when(WeatherCheck.weather().setRaining(false))
                                                .when(TimeCheck.time(IntRange.range(6000, 12000)))
                                                .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN)))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_JUNK).setQuality(-2)
                                                .when(TimeCheck.time(IntRange.range(0, 5999)).or(TimeCheck.time(IntRange.range(12001, 23999)))))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_TREASURE).setQuality(2)
                                                .when(TimeCheck.time(IntRange.range(0, 5999)).or(TimeCheck.time(IntRange.range(12001, 23999)))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_PUFFERFISH_COIN_FISHING,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0, 1))
                                .add(LootItem.lootTableItem(Items.PUFFERFISH)
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                        )
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
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_JUNK).setQuality(-2)
                                                .when(TimeCheck.time(IntRange.range(0, 5999)).or(TimeCheck.time(IntRange.range(12001, 23999)))))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_TREASURE).setQuality(2)
                                                .when(TimeCheck.time(IntRange.range(0, 5999)).or(TimeCheck.time(IntRange.range(12001, 23999)))))
                                 ));
        consumer.accept(ModBuiltInLootTables.TODECOINS_TROPICAL_FISH_COIN_FISHING,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0, 1))
                                .add(LootItem.lootTableItem(Items.TROPICAL_FISH)
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)
                                        .or(IN_MANGROVE_SWAMP).or(IN_LUSH_CAVES)))
                        )
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
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_JUNK).setQuality(-2)
                                                .when(TimeCheck.time(IntRange.range(0, 5999)).or(TimeCheck.time(IntRange.range(12001, 23999)))))
                                        .add(LootTableReference.lootTableReference(ModBuiltInLootTables.TODECOINS_FISHING_EXTRA_TREASURE).setQuality(2)
                                                .when(TimeCheck.time(IntRange.range(0, 5999)).or(TimeCheck.time(IntRange.range(12001, 23999)))))
                                 ));
    }
}