package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.datagen.loot_tables.*;
import com.github.warrentode.todecoins.datagen.loot_tables.chest_loot.*;
import com.github.warrentode.todecoins.datagen.loot_tables.entity_drops.*;
import com.github.warrentode.todecoins.datagen.loot_tables.mystery_coin_packs.*;
import com.github.warrentode.todecoins.loot.conditions.season.*;
import com.github.warrentode.todecoins.loot.conditions.tag.BiomeTagCondition;
import com.github.warrentode.todecoins.loot.conditions.tag.EntityTypeTagCondition;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTableGenProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>>
            loot_tables = ImmutableList.of(
            Pair.of(ModGiftLootGen::new, LootContextParamSets.GIFT),
            Pair.of(ModBlockLootTablesGen::new, LootContextParamSets.BLOCK),
            Pair.of(CustomPiglinBarterLootGen::new, LootContextParamSets.PIGLIN_BARTER),
            Pair.of(ModFishingLootGen::new, LootContextParamSets.FISHING),
            Pair.of(CageriumLootTablesGen::new, LootContextParamSets.ENTITY),
            Pair.of(TradeLootTablesGen::new, LootContextParamSets.CHEST),

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

    // entity checks
    public static final LootItemCondition.Builder DROPS_CURRENCY =
            EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.DROPS_CURRENCY).build();
    public static final LootItemCondition.Builder DROPS_BOSS_CURRENCY =
            EntityTypeTagCondition.isTag(ForgeTags.EntityTypes.BOSSES).build();

    // dimension checks
    public static final LootItemCondition.Builder IN_OVERWORLD =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.OVERWORLD));
    public static final LootItemCondition.Builder IN_NETHER =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.NETHER));
    public static final LootItemCondition.Builder IN_END =
            LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.END));

    // seasonal checks
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

    // overworld structure checks
    public static final LootItemCondition.Builder IN_OCEAN_MONUMENT = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.OCEAN_MONUMENT.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_ANCIENT_CITY = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.ANCIENT_CITY.unwrapKey().orElseThrow()));
    // nether structure checks
    public static final LootItemCondition.Builder IN_NETHER_FORTRESS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.FORTRESS.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_BASTION_REMNANTS = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.BASTION_REMNANT.unwrapKey().orElseThrow()));
    public static final LootItemCondition.Builder IN_RUINED_PORTAL_NETHER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.RUINED_PORTAL_NETHER.unwrapKey().orElseThrow()));
    // end structure checks
    public static final LootItemCondition.Builder IN_END_CITY = LocationCheck.checkLocation(LocationPredicate.Builder.location().setStructure(Structures.END_CITY.unwrapKey().orElseThrow()));

    // biome tag checks
    public static final LootItemCondition.Builder HAS_SUNFLOWER = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_SUNFLOWER);
    public static final LootItemCondition.Builder HAS_PEONY = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_PEONY);
    public static final LootItemCondition.Builder HAS_ROSE_BUSH = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_ROSE_BUSH);
    public static final LootItemCondition.Builder HAS_LILAC = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_LILAC);
    public static final LootItemCondition.Builder HAS_BUTTERCUP = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_BUTTERCUP);
    public static final LootItemCondition.Builder HAS_LILY_OF_THE_VALLEY = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_LILY_OF_THE_VALLEY);
    public static final LootItemCondition.Builder HAS_CORNFLOWER = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_CORNFLOWER);
    public static final LootItemCondition.Builder HAS_OXEYE_DAISY = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_OXEYE_DAISY);
    public static final LootItemCondition.Builder HAS_PINK_TULIP = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_PINK_TULIP);
    public static final LootItemCondition.Builder HAS_WHITE_TULIP = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_WHITE_TULIP);
    public static final LootItemCondition.Builder HAS_ORANGE_TULIP = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_ORANGE_TULIP);
    public static final LootItemCondition.Builder HAS_RED_TULIP = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_RED_TULIP);
    public static final LootItemCondition.Builder HAS_AZURE_BLUET = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_AZURE_BLUET);
    public static final LootItemCondition.Builder HAS_ALLIUM = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_ALLIUM);
    public static final LootItemCondition.Builder HAS_BLUE_ORCHID = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_BLUE_ORCHID);
    public static final LootItemCondition.Builder HAS_SPRUCE = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_SPRUCE);
    public static final LootItemCondition.Builder HAS_MANGROVE = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_MANGROVE);
    public static final LootItemCondition.Builder HAS_ACACIA = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_ACACIA);
    public static final LootItemCondition.Builder HAS_JUNGLE = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_JUNGLE);
    public static final LootItemCondition.Builder HAS_BIRCH = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_BIRCH);
    public static final LootItemCondition.Builder HAS_DARK_OAK = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_DARK_OAK);
    public static final LootItemCondition.Builder NETHER_BIOMES = BiomeTagCondition.tag().set(ForgeTags.Biomes.NETHER_BIOMES);
    public static final LootItemCondition.Builder HAS_WARPED_FUNGUS = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_WARPED_FUNGUS);
    public static final LootItemCondition.Builder HAS_CRIMSON_FUNGUS = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_CRIMSON_FUNGUS);
    public static final LootItemCondition.Builder HAS_SANDSTONE = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_SANDSTONE);
    public static final LootItemCondition.Builder HAS_RED_SANDSTONE = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_RED_SANDSTONE);
    public static final LootItemCondition.Builder HAS_MOSSY_STONE = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_MOSSY_STONE);
    public static final LootItemCondition.Builder HAS_PUFFERFISH = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_PUFFERFISH);
    public static final LootItemCondition.Builder HAS_TROPICAL_FISH = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_TROPICAL_FISH);
    public static final LootItemCondition.Builder HAS_SALMON = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_SALMON);
    public static final LootItemCondition.Builder HAS_FROGS = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_FROGS);
    public static final LootItemCondition.Builder HAS_AXOLOTL = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_AXOLOTL);
    public static final LootItemCondition.Builder HAS_MUD = BiomeTagCondition.tag().set(ForgeTags.Biomes.HAS_MUD);
}