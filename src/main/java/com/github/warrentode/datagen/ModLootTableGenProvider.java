package com.github.warrentode.datagen;

import com.github.warrentode.datagen.loot_tables.*;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTableGenProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>>
            loot_tables = ImmutableList.of(
            Pair.of(ModChestLootTablesGen::new, LootContextParamSets.CHEST),
            Pair.of(ModBlockLootTablesGen::new, LootContextParamSets.BLOCK),
            Pair.of(ModGiftLootGen::new, LootContextParamSets.GIFT),
            Pair.of(CurrencyDropLootTablesGen::new, LootContextParamSets.ENTITY),
            Pair.of(CustomPiglinBarterLootGen::new, LootContextParamSets.PIGLIN_BARTER),
            Pair.of(ModFishingLootGen::new, LootContextParamSets.FISHING)
                                          );

    public ModLootTableGenProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return loot_tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationTracker) {
        map.forEach((id, table) -> LootTables.validate(validationTracker, id, table));
    }
}