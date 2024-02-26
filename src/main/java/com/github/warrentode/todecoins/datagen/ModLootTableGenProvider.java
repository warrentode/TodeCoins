package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.datagen.loot_tables.*;
import com.github.warrentode.todecoins.datagen.loot_tables.chest_loot.*;
import com.github.warrentode.todecoins.datagen.loot_tables.entity_drops.*;
import com.github.warrentode.todecoins.datagen.loot_tables.merchant.MerchantOffersGen;
import com.github.warrentode.todecoins.datagen.loot_tables.mystery_coin_packs.*;
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
            loot_tables = ImmutableList
            .of(
                    Pair.of(ModGiftLootGen::new, LootContextParamSets.GIFT),
                    Pair.of(ModBlockLootTablesGen::new, LootContextParamSets.BLOCK),
                    Pair.of(CustomPiglinBarterLootGen::new, LootContextParamSets.PIGLIN_BARTER),
                    Pair.of(ModFishingLootGen::new, LootContextParamSets.FISHING),
                    Pair.of(CageriumLootTablesGen::new, LootContextParamSets.ENTITY),
                    Pair.of(MerchantOffersGen::new, LootContextParamSets.CHEST),

                    Pair.of(CoinDropsEntityGen::new, LootContextParamSets.ENTITY),
                    Pair.of(CoinDropsBossGen::new, LootContextParamSets.ENTITY),
                    Pair.of(CollectibleCoinDropsHolidayGen::new, LootContextParamSets.ENTITY),
                    Pair.of(CollectibleCoinDropsSeasonalGen::new, LootContextParamSets.ENTITY),
                    Pair.of(CollectibleCoinDropsSpringGen::new, LootContextParamSets.ENTITY),
                    Pair.of(CollectibleCoinDropsSummerGen::new, LootContextParamSets.ENTITY),
                    Pair.of(CollectibleCoinDropsAutumnGen::new, LootContextParamSets.ENTITY),
                    Pair.of(CollectibleCoinDropsWinterGen::new, LootContextParamSets.ENTITY),

                    Pair.of(ModChestLootTablesGen::new, LootContextParamSets.CHEST),
                    Pair.of(CollectibleCoinChestGen::new, LootContextParamSets.CHEST),
                    Pair.of(CollectibleCoinChestHolidayGen::new, LootContextParamSets.CHEST),
                    Pair.of(CollectibleCoinsChestSpringGen::new, LootContextParamSets.CHEST),
                    Pair.of(CollectibleCoinsChestSummerGen::new, LootContextParamSets.CHEST),
                    Pair.of(CollectibleCoinsChestAutumnGen::new, LootContextParamSets.CHEST),
                    Pair.of(CollectibleCoinsChestWinterGen::new, LootContextParamSets.CHEST),

                    Pair.of(MysteryCoinPackGen::new, LootContextParamSets.CHEST),
                    Pair.of(MysteryCoinPackInvertedGen::new, LootContextParamSets.CHEST),
                    Pair.of(MysteryCoinPackSpringGen::new, LootContextParamSets.CHEST),
                    Pair.of(MysteryCoinPackSummerGen::new, LootContextParamSets.CHEST),
                    Pair.of(MysteryCoinPackAutumnGen::new, LootContextParamSets.CHEST),
                    Pair.of(MysteryCoinPackWinterGen::new, LootContextParamSets.CHEST)
            );

    public ModLootTableGenProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return loot_tables;
    }

    @Override
    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationTracker) {
        map.forEach((id, table) -> LootTables.validate(validationTracker, id, table));
    }
}