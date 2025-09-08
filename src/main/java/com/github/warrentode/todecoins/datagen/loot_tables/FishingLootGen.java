package com.github.warrentode.todecoins.datagen.loot_tables;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static com.github.warrentode.todecoins.datagen.LootTablesGen.*;

public class FishingLootGen implements LootTableSubProvider {
    @Override
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.FISHING_COINS,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_COD_COPPER.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_SALMON_COPPER.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PUFFERFISH_COPPER.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_TROPICAL_FISH_COPPER.get()).when(SPRING))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_COD_IRON.get()).when(SUMMER))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_SALMON_IRON.get()).when(SUMMER))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PUFFERFISH_IRON.get()).when(SUMMER))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_TROPICAL_FISH_IRON.get()).when(SUMMER))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_COD_GOLD.get()).when(AUTUMN))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_SALMON_GOLD.get()).when(AUTUMN))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PUFFERFISH_GOLD.get()).when(AUTUMN))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_TROPICAL_FISH_GOLD.get()).when(AUTUMN))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_COD_NETHERITE.get()).when(WINTER))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_SALMON_NETHERITE.get()).when(WINTER))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_PUFFERFISH_NETHERITE.get()).when(WINTER))
                                        .add(LootItem.lootTableItem(TCItems.COLLECTIBLE_COIN_TROPICAL_FISH_NETHERITE.get()).when(WINTER))
                        ));
        consumer.accept(ModBuiltInLootTables.FISHING_EXTRA_JUNK,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.GLASS_BOTTLE))
                                .add(LootItem.lootTableItem(Items.SNOWBALL).when(IN_FROZEN_OCEAN.or(IN_FROZEN_RIVER).or(IN_DEEP_FROZEN_OCEAN)))
                                .add(LootItem.lootTableItem(Items.MUDDY_MANGROVE_ROOTS).when(IN_MANGROVE_SWAMP))
                                .add(LootItem.lootTableItem(Items.HANGING_ROOTS).when(IN_LUSH_CAVES))
                                .add(LootItem.lootTableItem(Items.DEAD_TUBE_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                .add(LootItem.lootTableItem(Items.DEAD_BRAIN_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                .add(LootItem.lootTableItem(Items.DEAD_BUBBLE_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                .add(LootItem.lootTableItem(Items.DEAD_FIRE_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                                .add(LootItem.lootTableItem(Items.DEAD_HORN_CORAL_FAN).when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN).or(IN_WARM_OCEAN)))
                        ));
        consumer.accept(ModBuiltInLootTables.FISHING_BONUS_FISH,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.COD)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)))
                                        .when(HAS_FISHERMANS_BLESSING)
                                        .when(IN_OCEAN.or(IN_DEEP_OCEAN)
                                                .or(IN_LUKEWARM_OCEAN).or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_COLD_OCEAN).or(IN_DEEP_COLD_OCEAN)))
                                .add(LootItem.lootTableItem(Items.SALMON)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)))
                                        .when(HAS_FISHERMANS_BLESSING)
                                        .when(IN_COLD_OCEAN.or(IN_DEEP_COLD_OCEAN)
                                                .or(IN_RIVER).or(IN_FROZEN_RIVER)
                                                .or(IN_FROZEN_OCEAN).or(IN_DEEP_FROZEN_OCEAN)))
                                .add(LootItem.lootTableItem(Items.PUFFERFISH)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)))
                                        .when(HAS_FISHERMANS_BLESSING)
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_WARM_OCEAN)))
                                .add(LootItem.lootTableItem(Items.TROPICAL_FISH)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)))
                                        .when(HAS_FISHERMANS_BLESSING)
                                        .when(IN_LUKEWARM_OCEAN.or(IN_DEEP_LUKEWARM_OCEAN)
                                                .or(IN_WARM_OCEAN).or(IN_MANGROVE_SWAMP)
                                                .or(IN_LUSH_CAVES)))
                        ));
    }
}