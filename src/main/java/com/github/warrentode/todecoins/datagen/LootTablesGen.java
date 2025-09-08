package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.datagen.loot_tables.*;
import com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins.CollectibleCoinLootGen;
import com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins.entity.AutumnCoinDropsGen;
import com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins.entity.SpringCoinDropsGen;
import com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins.entity.SummerCoinDropsGen;
import com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins.entity.WinterCoinDropsGen;
import com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins.trading.AutumnCoinLootGen;
import com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins.trading.SpringCoinLootGen;
import com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins.trading.SummerCoinLootGen;
import com.github.warrentode.todecoins.datagen.loot_tables.collectible_coins.trading.WinterCoinLootGen;
import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.loot.condition.EntityHasEffectCondition;
import com.github.warrentode.todecoins.loot.condition.ModCheckCondition;
import com.github.warrentode.todecoins.loot.condition.season.*;
import com.github.warrentode.todecoins.loot.condition.tag.BiomeTagCondition;
import com.github.warrentode.todecoins.loot.condition.tag.EntityTypeTagCondition;
import com.github.warrentode.todecoins.util.tags.TCBiomeTags;
import com.github.warrentode.todecoins.util.tags.TCEntityTypeTags;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class LootTablesGen {
    @Contract("_ -> new")
    public static @NotNull LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(BlockLootGen::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(GiftLootGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(TradeLootTablesGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(CollectibleCoinLootGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(SpringCoinLootGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(AutumnCoinLootGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(SummerCoinLootGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(WinterCoinLootGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(AutumnCoinDropsGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(SpringCoinDropsGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(SummerCoinDropsGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(WinterCoinDropsGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(ChestLootGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(EntityLootGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(FishingLootGen::new, LootContextParamSets.ALL_PARAMS),
                new LootTableProvider.SubProviderEntry(PiglinBarterLootGen::new, LootContextParamSets.ALL_PARAMS)
        ));
    }

    // mod loaded checks
    public static final LootItemCondition.Builder CAGERIUM_LOADED = ModCheckCondition.mod().isLoaded("cagerium");
    public static final LootItemCondition.Builder FRIENDSANDFOES_LOADED = ModCheckCondition.mod().isLoaded("friendsandfoes");
    public static final LootItemCondition.Builder BIOMESOPLENTY_LOADED = ModCheckCondition.mod().isLoaded("biomesoplenty");
    public static final LootItemCondition.Builder FARMERSDELIGHT_LOADED = ModCheckCondition.mod().isLoaded("farmersdelight");
    public static final LootItemCondition.Builder FESTIVE_DELIGHT_LOADED = ModCheckCondition.mod().isLoaded("festive_delight");
    public static final LootItemCondition.Builder DELIGHTFUL_LOADED = ModCheckCondition.mod().isLoaded("delightful");
    public static final LootItemCondition.Builder SUPPLEMENTARIES_LOADED = ModCheckCondition.mod().isLoaded("supplementaries");
    public static final LootItemCondition.Builder SNOWY_SPIRIT_LOADED = ModCheckCondition.mod().isLoaded("snowyspirit");
    public static final LootItemCondition.Builder TCONSTRUCT_LOADED = ModCheckCondition.mod().isLoaded("tconstruct");
    public static final LootItemCondition.Builder TBA_LOADED = ModCheckCondition.mod().isLoaded("turtleblockacademy");
    public static final LootItemCondition.Builder SALT_MOD_LOADED = ModCheckCondition.mod().isLoaded("salt");
    public static final LootItemCondition.Builder AETHER_LOADED = ModCheckCondition.mod().isLoaded("aether");
    public static final LootItemCondition.Builder ECOLOGICS_LOADED = ModCheckCondition.mod().isLoaded("ecologics");
    public static final LootItemCondition.Builder CRABBERSDELIGHT_LOADED = ModCheckCondition.mod().isLoaded("crabbersdelight");
    public static final LootItemCondition.Builder PATCHOULI_LOADED = ModCheckCondition.mod().isLoaded("patchouli");
    public static final LootItemCondition.Builder BEAUTIFY_LOADED = ModCheckCondition.mod().isLoaded("beautify");
    public static final LootItemCondition.Builder KAWAIIDISHES_LOADED = ModCheckCondition.mod().isLoaded("kawaiidishes");
    public static final LootItemCondition.Builder FASTFOODDELIGHT_LOADED = ModCheckCondition.mod().isLoaded("fastfooddelight");
    public static final LootItemCondition.Builder VILLAGER_ENCHANTER_LOADED = ModCheckCondition.mod().isLoaded("villager_enchanter");
    public static final LootItemCondition.Builder SEWINGKIT_LOADED = ModCheckCondition.mod().isLoaded("sewingkit");
    public static final LootItemCondition.Builder TODEVILLAGERS_LOADED = ModCheckCondition.mod().isLoaded("todevillagers");
    public static final LootItemCondition.Builder CREATE_DECO_LOADED = ModCheckCondition.mod().isLoaded("createdeco");
    public static final LootItemCondition.Builder CREATE_LOADED = ModCheckCondition.mod().isLoaded("create");

    // random chance checks
    public static final LootItemCondition.Builder COLLECTIBLE_COIN_CHANCE = LootItemRandomChanceCondition.randomChance(0.05F);
    public static final LootItemCondition.Builder CURRENCY_CHANCE = LootItemRandomChanceCondition.randomChance(0.1F);

    // entity checks
    public static final LootItemCondition.Builder DROPS_CURRENCY_BLACKLISTED = EntityTypeTagCondition.isTag(TCEntityTypeTags.DROPS_CURRENCY_BLACKLIST).build();
    public static final LootItemCondition.Builder DROPS_COLLECTIBLE_COIN_BLACKLISTED = EntityTypeTagCondition.isTag(TCEntityTypeTags.DROPS_COLLECTIBLE_COIN_BLACKLIST).build();

    // dimension checks
    public static final LootItemCondition.Builder IN_OVERWORLD = LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.OVERWORLD));

    // effect checks
    public static final LootItemCondition.Builder HAS_FISHERMANS_BLESSING = EntityHasEffectCondition.hasEffect(TCMobEffects.FISHERMANS_BLESSING.get());

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

    // entity tag checks
    public static final LootItemCondition.Builder IS_BOSS = EntityTypeTagCondition.isTag(TCEntityTypeTags.BOSSES).build();
    public static final LootItemCondition.Builder IS_KNOWN_ENTITY = EntityTypeTagCondition.isTag(TCEntityTypeTags.KNOWN_ENTITIES).build();
    public static final LootItemCondition.Builder IS_BOGGED = EntityTypeTagCondition.isTag(TCEntityTypeTags.BOGGED_TYPES).build();
    public static final LootItemCondition.Builder IS_BREEZE = EntityTypeTagCondition.isTag(TCEntityTypeTags.BREEZE_TYPES).build();
    public static final LootItemCondition.Builder IS_CREAKING = EntityTypeTagCondition.isTag(TCEntityTypeTags.CREAKING_TYPES).build();
    public static final LootItemCondition.Builder IS_HAPPY_GHAST = EntityTypeTagCondition.isTag(TCEntityTypeTags.HAPPY_GHAST_TYPES).build();
    public static final LootItemCondition.Builder IS_ALLAY = EntityTypeTagCondition.isTag(TCEntityTypeTags.ALLAY_TYPES).build();
    public static final LootItemCondition.Builder IS_ARMAIDLLO = EntityTypeTagCondition.isTag(TCEntityTypeTags.ARMAIDLLO_TYPES).build();
    public static final LootItemCondition.Builder IS_AXOLOTL = EntityTypeTagCondition.isTag(TCEntityTypeTags.AXOLOTL_TYPES).build();
    public static final LootItemCondition.Builder IS_BAT = EntityTypeTagCondition.isTag(TCEntityTypeTags.BAT_TYPES).build();
    public static final LootItemCondition.Builder IS_BEE = EntityTypeTagCondition.isTag(TCEntityTypeTags.BEE_TYPES).build();
    public static final LootItemCondition.Builder IS_BLAZE = EntityTypeTagCondition.isTag(TCEntityTypeTags.BLAZE_TYPES).build();
    public static final LootItemCondition.Builder IS_CAMEL = EntityTypeTagCondition.isTag(TCEntityTypeTags.CAMEL_TYPES).build();
    public static final LootItemCondition.Builder IS_CAT = EntityTypeTagCondition.isTag(TCEntityTypeTags.CAT_TYPES).build();
    public static final LootItemCondition.Builder IS_CAVE_SPIDER = EntityTypeTagCondition.isTag(TCEntityTypeTags.CAVE_SPIDER_TYPES).build();
    public static final LootItemCondition.Builder IS_CHICKEN = EntityTypeTagCondition.isTag(TCEntityTypeTags.CHICKEN_TYPES).build();
    public static final LootItemCondition.Builder IS_COD = EntityTypeTagCondition.isTag(TCEntityTypeTags.COD_TYPES).build();
    public static final LootItemCondition.Builder IS_COW = EntityTypeTagCondition.isTag(TCEntityTypeTags.COW_TYPES).build();
    public static final LootItemCondition.Builder IS_COPPER_GOLEM = EntityTypeTagCondition.isTag(TCEntityTypeTags.COPPER_GOLEM_TYPES).build();
    public static final LootItemCondition.Builder IS_CREEPER = EntityTypeTagCondition.isTag(TCEntityTypeTags.CREEPER_TYPES).build();
    public static final LootItemCondition.Builder IS_CRAB = EntityTypeTagCondition.isTag(TCEntityTypeTags.CRAB_TYPES).build();
    public static final LootItemCondition.Builder IS_DOLPHIN = EntityTypeTagCondition.isTag(TCEntityTypeTags.DOLPHIN_TYPES).build();
    public static final LootItemCondition.Builder IS_DONKEY = EntityTypeTagCondition.isTag(TCEntityTypeTags.DONKEY_TYPES).build();
    public static final LootItemCondition.Builder IS_DROWNED = EntityTypeTagCondition.isTag(TCEntityTypeTags.DROWNED_TYPES).build();
    public static final LootItemCondition.Builder IS_ELDER_GUARDIAN = EntityTypeTagCondition.isTag(TCEntityTypeTags.ELDER_GUARDIAN_TYPES).build();
    public static final LootItemCondition.Builder IS_ENDER_DRAGON = EntityTypeTagCondition.isTag(TCEntityTypeTags.ENDER_DRAGON_TYPES).build();
    public static final LootItemCondition.Builder IS_ENDERMAN = EntityTypeTagCondition.isTag(TCEntityTypeTags.ENDERMAN_TYPES).build();
    public static final LootItemCondition.Builder IS_ENDERMITE = EntityTypeTagCondition.isTag(TCEntityTypeTags.ENDERMITES_TYPES).build();
    public static final LootItemCondition.Builder IS_EVOKER = EntityTypeTagCondition.isTag(TCEntityTypeTags.EVOKER_TYPES).build();
    public static final LootItemCondition.Builder IS_FOX = EntityTypeTagCondition.isTag(TCEntityTypeTags.FOX_TYPES).build();
    public static final LootItemCondition.Builder IS_FROG = EntityTypeTagCondition.isTag(TCEntityTypeTags.FROG_TYPES).build();
    public static final LootItemCondition.Builder IS_GHAST = EntityTypeTagCondition.isTag(TCEntityTypeTags.GHAST_TYPES).build();
    public static final LootItemCondition.Builder IS_GIANT = EntityTypeTagCondition.isTag(TCEntityTypeTags.GIANT_TYPES).build();
    public static final LootItemCondition.Builder IS_GLARE = EntityTypeTagCondition.isTag(TCEntityTypeTags.GLARE_TYPES).build();
    public static final LootItemCondition.Builder IS_GLOW_SQUID = EntityTypeTagCondition.isTag(TCEntityTypeTags.GLOW_SQUID_TYPES).build();
    public static final LootItemCondition.Builder IS_GOAT = EntityTypeTagCondition.isTag(TCEntityTypeTags.GOAT_TYPES).build();
    public static final LootItemCondition.Builder IS_GUARD = EntityTypeTagCondition.isTag(TCEntityTypeTags.GUARD_TYPES).build();
    public static final LootItemCondition.Builder IS_GUARDIAN = EntityTypeTagCondition.isTag(TCEntityTypeTags.GUARDIAN_TYPES).build();
    public static final LootItemCondition.Builder IS_HOGLIN = EntityTypeTagCondition.isTag(TCEntityTypeTags.HOGLIN_TYPES).build();
    public static final LootItemCondition.Builder IS_HORSE = EntityTypeTagCondition.isTag(TCEntityTypeTags.HORSE_TYPES).build();
    public static final LootItemCondition.Builder IS_HUSK = EntityTypeTagCondition.isTag(TCEntityTypeTags.HUSK_TYPES).build();
    public static final LootItemCondition.Builder IS_ICEOLOGER = EntityTypeTagCondition.isTag(TCEntityTypeTags.ICEOLOGER_TYPES).build();
    public static final LootItemCondition.Builder IS_ILLUSIONER = EntityTypeTagCondition.isTag(TCEntityTypeTags.ILLUSIONER_TYPES).build();
    public static final LootItemCondition.Builder IS_IRON_GOLEM = EntityTypeTagCondition.isTag(TCEntityTypeTags.IRON_GOLEM_TYPES).build();
    public static final LootItemCondition.Builder IS_LLAMA = EntityTypeTagCondition.isTag(TCEntityTypeTags.LLAMA_TYPES).build();
    public static final LootItemCondition.Builder IS_MAGMA_CUBE = EntityTypeTagCondition.isTag(TCEntityTypeTags.MAGMA_CUBE_TYPES).build();
    public static final LootItemCondition.Builder IS_MAULER = EntityTypeTagCondition.isTag(TCEntityTypeTags.MAULER_TYPES).build();
    public static final LootItemCondition.Builder IS_MOOBLOOM = EntityTypeTagCondition.isTag(TCEntityTypeTags.MOOBLOOM_TYPES).build();
    public static final LootItemCondition.Builder IS_MOOSHROOM = EntityTypeTagCondition.isTag(TCEntityTypeTags.MOOSHROOM_TYPES).build();
    public static final LootItemCondition.Builder IS_MULE = EntityTypeTagCondition.isTag(TCEntityTypeTags.MULE_TYPES).build();
    public static final LootItemCondition.Builder IS_NUMISMATIST = EntityTypeTagCondition.isTag(TCEntityTypeTags.NUMISMATIST_TYPES).build();
    public static final LootItemCondition.Builder IS_OCELOT = EntityTypeTagCondition.isTag(TCEntityTypeTags.OCELOT_TYPES).build();
    public static final LootItemCondition.Builder IS_PARROT = EntityTypeTagCondition.isTag(TCEntityTypeTags.PARROT_TYPES).build();
    public static final LootItemCondition.Builder IS_PANDA = EntityTypeTagCondition.isTag(TCEntityTypeTags.PANDA_TYPES).build();
    public static final LootItemCondition.Builder IS_PHANTOM = EntityTypeTagCondition.isTag(TCEntityTypeTags.PHANTOM_TYPES).build();
    public static final LootItemCondition.Builder IS_PENGUIN = EntityTypeTagCondition.isTag(TCEntityTypeTags.PENGUIN_TYPES).build();
    public static final LootItemCondition.Builder IS_PILLAGER = EntityTypeTagCondition.isTag(TCEntityTypeTags.PILLAGER_TYPES).build();
    public static final LootItemCondition.Builder IS_PIG = EntityTypeTagCondition.isTag(TCEntityTypeTags.PIG_TYPES).build();
    public static final LootItemCondition.Builder IS_PIGLIN = EntityTypeTagCondition.isTag(TCEntityTypeTags.PIGLIN_TYPES).build();
    public static final LootItemCondition.Builder IS_PIGLIN_BRUTE = EntityTypeTagCondition.isTag(TCEntityTypeTags.PIGLIN_BRUTE_TYPES).build();
    public static final LootItemCondition.Builder IS_PIGLIN_MERCHANT = EntityTypeTagCondition.isTag(TCEntityTypeTags.PIGLIN_MERCHANT_TYPES).build();
    public static final LootItemCondition.Builder IS_POALR_BEAR = EntityTypeTagCondition.isTag(TCEntityTypeTags.POLAR_BEAR_TYPES).build();
    public static final LootItemCondition.Builder IS_PUFFERFISH = EntityTypeTagCondition.isTag(TCEntityTypeTags.PUFFERFISH_TYPES).build();
    public static final LootItemCondition.Builder IS_RABBIT = EntityTypeTagCondition.isTag(TCEntityTypeTags.RABBIT_TYPES).build();
    public static final LootItemCondition.Builder IS_RAVAGER = EntityTypeTagCondition.isTag(TCEntityTypeTags.RAVAGER_TYPES).build();
    public static final LootItemCondition.Builder IS_RASCAL = EntityTypeTagCondition.isTag(TCEntityTypeTags.RASCAL_TYPES).build();
    public static final LootItemCondition.Builder IS_SALMON = EntityTypeTagCondition.isTag(TCEntityTypeTags.SALMON_TYPES).build();
    public static final LootItemCondition.Builder IS_SHEEP = EntityTypeTagCondition.isTag(TCEntityTypeTags.SHEEP_TYPES).build();
    public static final LootItemCondition.Builder IS_SHULKER = EntityTypeTagCondition.isTag(TCEntityTypeTags.SHULKER_TYPES).build();
    public static final LootItemCondition.Builder IS_SILVERFISH = EntityTypeTagCondition.isTag(TCEntityTypeTags.SILVERFISH_TYPES).build();
    public static final LootItemCondition.Builder IS_SKELETON = EntityTypeTagCondition.isTag(TCEntityTypeTags.SKELETON_TYPES).build();
    public static final LootItemCondition.Builder IS_SKELETON_HORSE = EntityTypeTagCondition.isTag(TCEntityTypeTags.SKELETON_HORSE_TYPES).build();
    public static final LootItemCondition.Builder IS_SLIME = EntityTypeTagCondition.isTag(TCEntityTypeTags.SLIME_TYPES).build();
    public static final LootItemCondition.Builder IS_SNIFFER = EntityTypeTagCondition.isTag(TCEntityTypeTags.SNIFFER_TYPES).build();
    public static final LootItemCondition.Builder IS_SNOW_GOLEM = EntityTypeTagCondition.isTag(TCEntityTypeTags.SNOW_GOLEM_TYPES).build();
    public static final LootItemCondition.Builder IS_SPIDER = EntityTypeTagCondition.isTag(TCEntityTypeTags.SPIDER_TYPES).build();
    public static final LootItemCondition.Builder IS_SQUID = EntityTypeTagCondition.isTag(TCEntityTypeTags.SQUID_TYPES).build();
    public static final LootItemCondition.Builder IS_SQUIRREL = EntityTypeTagCondition.isTag(TCEntityTypeTags.SQUIRREL_TYPES).build();
    public static final LootItemCondition.Builder IS_STRAY = EntityTypeTagCondition.isTag(TCEntityTypeTags.STRAY_TYPES).build();
    public static final LootItemCondition.Builder IS_TADPOLE = EntityTypeTagCondition.isTag(TCEntityTypeTags.TADPOLE_TYPES).build();
    public static final LootItemCondition.Builder IS_TROPICAL_FISH = EntityTypeTagCondition.isTag(TCEntityTypeTags.TROPICAL_FISH_TYPES).build();
    public static final LootItemCondition.Builder IS_TRADER_LLAMA = EntityTypeTagCondition.isTag(TCEntityTypeTags.TRADER_LLAMA_TYPES).build();
    public static final LootItemCondition.Builder IS_TURTLE = EntityTypeTagCondition.isTag(TCEntityTypeTags.TURTLE_TYPES).build();
    public static final LootItemCondition.Builder IS_TUFF_GOLEM = EntityTypeTagCondition.isTag(TCEntityTypeTags.TUFF_GOLEM_TYPES).build();
    public static final LootItemCondition.Builder IS_VEX = EntityTypeTagCondition.isTag(TCEntityTypeTags.VEX_TYPES).build();
    public static final LootItemCondition.Builder IS_VINDICATOR = EntityTypeTagCondition.isTag(TCEntityTypeTags.VINDICATOR_TYPES).build();
    public static final LootItemCondition.Builder IS_VILLAGER = EntityTypeTagCondition.isTag(TCEntityTypeTags.VILLAGER_TYPES).build();
    public static final LootItemCondition.Builder IS_WANDERING_TRADER = EntityTypeTagCondition.isTag(TCEntityTypeTags.WANDERING_TRADER_TYPES).build();
    public static final LootItemCondition.Builder IS_WARDEN = EntityTypeTagCondition.isTag(TCEntityTypeTags.WARDEN_TYPES).build();
    public static final LootItemCondition.Builder IS_WITCH = EntityTypeTagCondition.isTag(TCEntityTypeTags.WITCH_TYPES).build();
    public static final LootItemCondition.Builder IS_WILDFIRE = EntityTypeTagCondition.isTag(TCEntityTypeTags.WILDFIRE_TYPES).build();
    public static final LootItemCondition.Builder IS_WITHER = EntityTypeTagCondition.isTag(TCEntityTypeTags.WITHER_TYPES).build();
    public static final LootItemCondition.Builder IS_WITHER_SKELETON = EntityTypeTagCondition.isTag(TCEntityTypeTags.WITHER_SKELETON_TYPES).build();
    public static final LootItemCondition.Builder IS_WOLF = EntityTypeTagCondition.isTag(TCEntityTypeTags.WOLF_TYPES).build();
    public static final LootItemCondition.Builder IS_ZOGLIN = EntityTypeTagCondition.isTag(TCEntityTypeTags.ZOGLIN_TYPES).build();
    public static final LootItemCondition.Builder IS_ZOMBIE = EntityTypeTagCondition.isTag(TCEntityTypeTags.ZOMBIE_TYPES).build();
    public static final LootItemCondition.Builder IS_ZOMBIE_HORSE = EntityTypeTagCondition.isTag(TCEntityTypeTags.ZOMBIE_HORSE_TYPES).build();
    public static final LootItemCondition.Builder IS_ZOMBIE_VILLAGER = EntityTypeTagCondition.isTag(TCEntityTypeTags.ZOMBIE_VILLAGER_TYPES).build();
    public static final LootItemCondition.Builder IS_ZOMBIFIED_PIGLIN = EntityTypeTagCondition.isTag(TCEntityTypeTags.ZOMBIFIED_PIGLIN_TYPES).build();

    // general biome tag checks
    public static final LootItemCondition.Builder IN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_OCEAN));
    public static final LootItemCondition.Builder IN_LUKEWARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.LUKEWARM_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_LUKEWARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_LUKEWARM_OCEAN));
    public static final LootItemCondition.Builder IN_COLD_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.COLD_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_COLD_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_COLD_OCEAN));
    public static final LootItemCondition.Builder IN_RIVER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.RIVER));
    public static final LootItemCondition.Builder IN_FROZEN_RIVER = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FROZEN_RIVER));
    public static final LootItemCondition.Builder IN_FROZEN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.FROZEN_OCEAN));
    public static final LootItemCondition.Builder IN_DEEP_FROZEN_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.DEEP_FROZEN_OCEAN));
    public static final LootItemCondition.Builder IN_WARM_OCEAN = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.WARM_OCEAN));
    public static final LootItemCondition.Builder IN_MANGROVE_SWAMP = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.MANGROVE_SWAMP));
    public static final LootItemCondition.Builder IN_LUSH_CAVES = LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(Biomes.LUSH_CAVES));

    // currency/trade biome regions
    public static final LootItemCondition.Builder IN_NETHER = BiomeTagCondition.tag().set(TCBiomeTags.NETHER_BIOMES);
    public static final LootItemCondition.Builder IN_END = BiomeTagCondition.tag().set(TCBiomeTags.END_BIOMES);
    public static final LootItemCondition.Builder IN_UNDERGROUND = BiomeTagCondition.tag().set(Tags.Biomes.IS_UNDERGROUND);
    public static final LootItemCondition.Builder IN_MOUNTAIN = BiomeTagCondition.tag().set(Tags.Biomes.IS_MOUNTAIN);
    public static final LootItemCondition.Builder IN_LEPRECHAUN = BiomeTagCondition.tag().set(TCBiomeTags.HAS_LEPRECHAUN_WAGON);

    // biome has entity checks
    public static final LootItemCondition.Builder HAS_PUFFERFISH = BiomeTagCondition.tag().set(TCBiomeTags.HAS_PUFFERFISH);
    public static final LootItemCondition.Builder HAS_TROPICAL_FISH = BiomeTagCondition.tag().set(TCBiomeTags.HAS_TROPICAL_FISH);
    public static final LootItemCondition.Builder HAS_SALMON = BiomeTagCondition.tag().set(TCBiomeTags.HAS_SALMON);
    public static final LootItemCondition.Builder HAS_FROGS = BiomeTagCondition.tag().set(TCBiomeTags.HAS_FROGS);
    public static final LootItemCondition.Builder HAS_AXOLOTL = BiomeTagCondition.tag().set(TCBiomeTags.HAS_AXOLOTL);

    // biome has flower checks
    public static final LootItemCondition.Builder HAS_SUNFLOWER = BiomeTagCondition.tag().set(TCBiomeTags.HAS_SUNFLOWER);
    public static final LootItemCondition.Builder HAS_PEONY = BiomeTagCondition.tag().set(TCBiomeTags.HAS_PEONY);
    public static final LootItemCondition.Builder HAS_ROSE_BUSH = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ROSE_BUSH);
    public static final LootItemCondition.Builder HAS_LILAC = BiomeTagCondition.tag().set(TCBiomeTags.HAS_LILAC);
    public static final LootItemCondition.Builder HAS_BUTTERCUP = BiomeTagCondition.tag().set(TCBiomeTags.HAS_BUTTERCUP);
    public static final LootItemCondition.Builder HAS_LILY_OF_THE_VALLEY = BiomeTagCondition.tag().set(TCBiomeTags.HAS_LILY_OF_THE_VALLEY);
    public static final LootItemCondition.Builder HAS_CORNFLOWER = BiomeTagCondition.tag().set(TCBiomeTags.HAS_CORNFLOWER);
    public static final LootItemCondition.Builder HAS_OXEYE_DAISY = BiomeTagCondition.tag().set(TCBiomeTags.HAS_OXEYE_DAISY);
    public static final LootItemCondition.Builder HAS_PINK_TULIP = BiomeTagCondition.tag().set(TCBiomeTags.HAS_PINK_TULIP);
    public static final LootItemCondition.Builder HAS_WHITE_TULIP = BiomeTagCondition.tag().set(TCBiomeTags.HAS_WHITE_TULIP);
    public static final LootItemCondition.Builder HAS_ORANGE_TULIP = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ORANGE_TULIP);
    public static final LootItemCondition.Builder HAS_RED_TULIP = BiomeTagCondition.tag().set(TCBiomeTags.HAS_RED_TULIP);
    public static final LootItemCondition.Builder HAS_AZURE_BLUET = BiomeTagCondition.tag().set(TCBiomeTags.HAS_AZURE_BLUET);
    public static final LootItemCondition.Builder HAS_ALLIUM = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ALLIUM);
    public static final LootItemCondition.Builder HAS_BLUE_ORCHID = BiomeTagCondition.tag().set(TCBiomeTags.HAS_BLUE_ORCHID);
    public static final LootItemCondition.Builder HAS_GOLDENROD = BiomeTagCondition.tag().set(TCBiomeTags.HAS_GOLDENROD);
    public static final LootItemCondition.Builder HAS_WILDFLOWER = BiomeTagCondition.tag().set(TCBiomeTags.HAS_WILDFLOWER);
    public static final LootItemCondition.Builder HAS_WILTED_LILY = BiomeTagCondition.tag().set(TCBiomeTags.HAS_WILTED_LILY);
    public static final LootItemCondition.Builder HAS_PINK_HIBISCUS = BiomeTagCondition.tag().set(TCBiomeTags.HAS_PINK_HIBISCUS);
    public static final LootItemCondition.Builder HAS_BLUE_HYDRANGEA = BiomeTagCondition.tag().set(TCBiomeTags.HAS_BLUE_HYDRANGEA);
    public static final LootItemCondition.Builder HAS_VIOLET = BiomeTagCondition.tag().set(TCBiomeTags.HAS_VIOLET);
    public static final LootItemCondition.Builder HAS_ROSE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ROSE);
    public static final LootItemCondition.Builder HAS_ORANGE_COSMOS = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ORANGE_COSMOS);
    public static final LootItemCondition.Builder HAS_PINK_DAFFODIL = BiomeTagCondition.tag().set(TCBiomeTags.HAS_PINK_DAFFODIL);
    public static final LootItemCondition.Builder HAS_WITHER_ROSE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_WITHER_ROSE);
    public static final LootItemCondition.Builder HAS_GLOWFLOWER = BiomeTagCondition.tag().set(TCBiomeTags.HAS_GLOWFLOWER);
    public static final LootItemCondition.Builder HAS_LAVENDER = BiomeTagCondition.tag().set(TCBiomeTags.HAS_LAVENDER);
    public static final LootItemCondition.Builder HAS_WHITE_LAVENDER = BiomeTagCondition.tag().set(TCBiomeTags.HAS_WHITE_LAVENDER);
    public static final LootItemCondition.Builder HAS_ICY_IRIS = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ICY_IRIS);
    public static final LootItemCondition.Builder HAS_BURNING_BLOSSOM = BiomeTagCondition.tag().set(TCBiomeTags.HAS_BURNING_BLOSSOM);
    public static final LootItemCondition.Builder HAS_ENDBLOOM = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ENDBLOOM);
    public static final LootItemCondition.Builder HAS_PURPLE_FLOWER = BiomeTagCondition.tag().set(TCBiomeTags.HAS_PURPLE_FLOWER);
    public static final LootItemCondition.Builder HAS_WHITE_FLOWER = BiomeTagCondition.tag().set(TCBiomeTags.HAS_WHITE_FLOWER);

    // biome has decor plant checks
    public static final LootItemCondition.Builder HAS_CATTAIL = BiomeTagCondition.tag().set(TCBiomeTags.HAS_CATTAIL);
    public static final LootItemCondition.Builder HAS_CLOVER = BiomeTagCondition.tag().set(TCBiomeTags.HAS_CLOVER);

    // biome has tree checks
    public static final LootItemCondition.Builder HAS_WARPED_FUNGUS = BiomeTagCondition.tag().set(TCBiomeTags.HAS_WARPED_FUNGUS);
    public static final LootItemCondition.Builder HAS_CRIMSON_FUNGUS = BiomeTagCondition.tag().set(TCBiomeTags.HAS_CRIMSON_FUNGUS);
    public static final LootItemCondition.Builder HAS_SPRUCE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_SPRUCE);
    public static final LootItemCondition.Builder HAS_MANGROVE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_MANGROVE);
    public static final LootItemCondition.Builder HAS_ACACIA = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ACACIA);
    public static final LootItemCondition.Builder HAS_JUNGLE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_JUNGLE);
    public static final LootItemCondition.Builder HAS_BIRCH = BiomeTagCondition.tag().set(TCBiomeTags.HAS_BIRCH);
    public static final LootItemCondition.Builder HAS_DARK_OAK = BiomeTagCondition.tag().set(TCBiomeTags.HAS_DARK_OAK);
    public static final LootItemCondition.Builder HAS_CHERRY = BiomeTagCondition.tag().set(TCBiomeTags.HAS_CHERRY);
    public static final LootItemCondition.Builder HAS_FIR = BiomeTagCondition.tag().set(TCBiomeTags.HAS_FIR);
    public static final LootItemCondition.Builder HAS_PINE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_PINE);
    public static final LootItemCondition.Builder HAS_REDWOOD = BiomeTagCondition.tag().set(TCBiomeTags.HAS_REDWOOD);
    public static final LootItemCondition.Builder HAS_MAHOGANY = BiomeTagCondition.tag().set(TCBiomeTags.HAS_MAHOGANY);
    public static final LootItemCondition.Builder HAS_JACARANDA = BiomeTagCondition.tag().set(TCBiomeTags.HAS_JACARANDA);
    public static final LootItemCondition.Builder HAS_PALM = BiomeTagCondition.tag().set(TCBiomeTags.HAS_PALM);
    public static final LootItemCondition.Builder HAS_WILLOW = BiomeTagCondition.tag().set(TCBiomeTags.HAS_WILLOW);
    public static final LootItemCondition.Builder HAS_DEAD = BiomeTagCondition.tag().set(TCBiomeTags.HAS_DEAD);
    public static final LootItemCondition.Builder HAS_MAGIC = BiomeTagCondition.tag().set(TCBiomeTags.HAS_MAGIC);
    public static final LootItemCondition.Builder HAS_UMBRAN = BiomeTagCondition.tag().set(TCBiomeTags.HAS_UMBRAN);
    public static final LootItemCondition.Builder HAS_HELLBARK = BiomeTagCondition.tag().set(TCBiomeTags.HAS_HELLBARK);
    public static final LootItemCondition.Builder HAS_EMPYREAL = BiomeTagCondition.tag().set(TCBiomeTags.HAS_EMPYREAL);
    public static final LootItemCondition.Builder HAS_FLOWERING_OAK = BiomeTagCondition.tag().set(TCBiomeTags.HAS_FLOWERING_OAK);
    public static final LootItemCondition.Builder HAS_RAINBOW_BIRCH = BiomeTagCondition.tag().set(TCBiomeTags.HAS_RAINBOW_BIRCH);
    public static final LootItemCondition.Builder HAS_RED_MAPLE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_RED_MAPLE);
    public static final LootItemCondition.Builder HAS_ORIGIN = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ORIGIN);
    public static final LootItemCondition.Builder HAS_YELLOW_MAPLE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_YELLOW_MAPLE);
    public static final LootItemCondition.Builder HAS_ORANGE_MAPLE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ORANGE_MAPLE);
    public static final LootItemCondition.Builder HAS_SNOWBLOSSOM = BiomeTagCondition.tag().set(TCBiomeTags.HAS_SNOWBLOSSOM);
    public static final LootItemCondition.Builder HAS_COCONUT = BiomeTagCondition.tag().set(TCBiomeTags.HAS_COCONUT);
    public static final LootItemCondition.Builder HAS_AZALEA = BiomeTagCondition.tag().set(TCBiomeTags.HAS_AZALEA);
    public static final LootItemCondition.Builder HAS_AETHER_SKYROOT = BiomeTagCondition.tag().set(TCBiomeTags.HAS_AETHER_SKYROOT);
    public static final LootItemCondition.Builder HAS_GOLDEN_OAK = BiomeTagCondition.tag().set(TCBiomeTags.HAS_GOLDEN_OAK);
    public static final LootItemCondition.Builder HAS_BLOODSHROOM = BiomeTagCondition.tag().set(TCBiomeTags.HAS_BLOODSHROOM);
    public static final LootItemCondition.Builder HAS_ENDERBARK = BiomeTagCondition.tag().set(TCBiomeTags.HAS_ENDERBARK);
    public static final LootItemCondition.Builder HAS_GREENHEART = BiomeTagCondition.tag().set(TCBiomeTags.HAS_GREENHEART);

    // biomes has block checks
    public static final LootItemCondition.Builder HAS_SANDSTONE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_SANDSTONE);
    public static final LootItemCondition.Builder HAS_RED_SANDSTONE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_RED_SANDSTONE);
    public static final LootItemCondition.Builder HAS_MOSSY_STONE = BiomeTagCondition.tag().set(TCBiomeTags.HAS_MOSSY_STONE);
    public static final LootItemCondition.Builder HAS_MUD = BiomeTagCondition.tag().set(TCBiomeTags.HAS_MUD);
}