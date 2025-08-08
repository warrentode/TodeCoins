package com.github.warrentode.todecoins.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TodeCoinsTags {
    public interface Biomes {
        TagKey<Biome> HAS_SUNFLOWER = modBiomeTag("has_sunflower");
        TagKey<Biome> HAS_PEONY = modBiomeTag("has_peony");
        TagKey<Biome> HAS_ROSE_BUSH = modBiomeTag("has_rose_bush");
        TagKey<Biome> HAS_LILAC = modBiomeTag("has_lilac");
        TagKey<Biome> HAS_BUTTERCUP = modBiomeTag("has_buttercup");
        TagKey<Biome> HAS_LILY_OF_THE_VALLEY = modBiomeTag("has_lily_of_the_valley");
        TagKey<Biome> HAS_CORNFLOWER = modBiomeTag("has_cornflower");
        TagKey<Biome> HAS_OXEYE_DAISY = modBiomeTag("has_oxeye_daisy");
        TagKey<Biome> HAS_PINK_TULIP = modBiomeTag("has_pink_tulip");
        TagKey<Biome> HAS_WHITE_TULIP = modBiomeTag("has_white_tulip");
        TagKey<Biome> HAS_ORANGE_TULIP = modBiomeTag("has_orange_tulip");
        TagKey<Biome> HAS_RED_TULIP = modBiomeTag("has_red_tulip");
        TagKey<Biome> HAS_AZURE_BLUET = modBiomeTag("has_azure_bluet");
        TagKey<Biome> HAS_ALLIUM = modBiomeTag("has_allium");
        TagKey<Biome> HAS_BLUE_ORCHID = modBiomeTag("has_blue_orchid");
        TagKey<Biome> HAS_SPRUCE = modBiomeTag("has_spruce");
        TagKey<Biome> HAS_MANGROVE = modBiomeTag("has_mangrove");
        TagKey<Biome> HAS_ACACIA = modBiomeTag("has_acacia");
        TagKey<Biome> HAS_JUNGLE = modBiomeTag("has_jungle");
        TagKey<Biome> HAS_BIRCH = modBiomeTag("has_birch");
        TagKey<Biome> HAS_DARK_OAK = modBiomeTag("has_dark_oak");
        TagKey<Biome> NETHER_BIOMES = modBiomeTag("nether_biomes");
        TagKey<Biome> HAS_WARPED_FUNGUS = modBiomeTag("has_warped_fungus");
        TagKey<Biome> HAS_CRIMSON_FUNGUS = modBiomeTag("has_crimson_fungus");
        TagKey<Biome> HAS_SANDSTONE = modBiomeTag("has_sandstone");
        TagKey<Biome> HAS_RED_SANDSTONE = modBiomeTag("has_red_sandstone");
        TagKey<Biome> HAS_MOSSY_STONE = modBiomeTag("has_mossy_stone");
        TagKey<Biome> HAS_PUFFERFISH = modBiomeTag("has_pufferfish");
        TagKey<Biome> HAS_TROPICAL_FISH = modBiomeTag("has_tropical_fish");
        TagKey<Biome> HAS_SALMON = modBiomeTag("has_salmon");
        TagKey<Biome> HAS_FROGS = modBiomeTag("has_frogs");
        TagKey<Biome> HAS_AXOLOTL = modBiomeTag("has_axolotl");
        TagKey<Biome> HAS_MUD = modBiomeTag("has_mud");
        TagKey<Biome> HAS_RUINED_PORTALS = modBiomeTag("has_ruined_portals");
    }

    public interface StructureTags {
        TagKey<Structure> ON_ANCIENT_CITY_EXPLORER_MAPS = modStructureTag("worldgen/structure/ancient_city");
        TagKey<Structure> ON_BASTION_REMNANT_EXPLORER_MAPS = modStructureTag("worldgen/structure/bastion_remnant");
        TagKey<Structure> ON_DESERT_PYRAMID_EXPLORER_MAPS = modStructureTag("worldgen/structure/desert_pyramid");
        TagKey<Structure> ON_END_CITY_EXPLORER_MAPS = modStructureTag("worldgen/structure/end_city");
        TagKey<Structure> ON_IGLOO_EXPLORER_MAPS = modStructureTag("worldgen/structure/igloo");
        TagKey<Structure> ON_JUNGLE_TEMPLE_EXPLORER_MAPS = modStructureTag("worldgen/structure/jungle_temple");
        TagKey<Structure> ON_MINESHAFT_EXPLORER_MAPS = modStructureTag("worldgen/structure/mineshaft");
        TagKey<Structure> ON_NETHER_FORTRESS_EXPLORER_MAPS = modStructureTag("worldgen/structure/nether_fortress");
        TagKey<Structure> ON_NETHER_FOSSIL_EXPLORER_MAPS = modStructureTag("worldgen/structure/nether_fossil");
        TagKey<Structure> ON_NETHER_RUINED_PORTAL_EXPLORER_MAPS = modStructureTag("worldgen/structure/nether_ruined_portal");
        TagKey<Structure> ON_OCEAN_RUIN_EXPLORER_MAPS = modStructureTag("worldgen/structure/ocean_ruin");
        TagKey<Structure> ON_OCEAN_MONUMENT_EXPLORER_MAPS = modStructureTag("worldgen/structure/monument");
        TagKey<Structure> ON_OVERWORLD_RUINED_PORTAL_EXPLORER_MAPS = modStructureTag("worldgen/structure/overworld_ruined_portal");
        TagKey<Structure> ON_PILLAGER_OUTPOST_EXPLORER_MAPS = modStructureTag("worldgen/structure/pillager_outpost");
        TagKey<Structure> ON_WOODLAND_EXPLORER_MAPS = modStructureTag("worldgen/structure/mansion");
        TagKey<Structure> ON_SHIPWRECK_EXPLORER_MAPS = modStructureTag("worldgen/structure/shipwreck");
        TagKey<Structure> ON_STRONGHOLD_EXPLORER_MAPS = modStructureTag("worldgen/structure/stronghold");
        TagKey<Structure> ON_SWAMP_HUT_EXPLORER_MAPS = modStructureTag("worldgen/structure/swamp_hut");
        TagKey<Structure> ON_VILLAGE_EXPLORER_MAPS = modStructureTag("worldgen/structure/village");
        TagKey<Structure> ON_TREASURE_MAPS = modStructureTag("worldgen/structure/treasure");

        TagKey<Structure> OVERWORLD_POI = modStructureTag("worldgen/structure/overworld_poi");
        TagKey<Structure> OVERWORLD_END_POI = modStructureTag("worldgen/structure/overworld_end_poi");
        TagKey<Structure> OVERWORLD_NETHER_POI = modStructureTag("worldgen/structure/overworld_nether_poi");

        TagKey<Structure> DESERT_POI = modStructureTag("worldgen/structure/desert_poi");
        TagKey<Structure> JUNGLE_POI = modStructureTag("worldgen/structure/jungle_poi");
        TagKey<Structure> OCEAN_POI = modStructureTag("worldgen/structure/ocean_poi");
        TagKey<Structure> PILLAGER_POI = modStructureTag("worldgen/structure/pillager_poi");
        TagKey<Structure> MISC_POI = modStructureTag("worldgen/structure/misc_poi");
        TagKey<Structure> TREASURE_POI = modStructureTag("worldgen/structure/treasure_poi");
        TagKey<Structure> UNDERGROUND_POI = modStructureTag("worldgen/structure/underground_poi");
        TagKey<Structure> NETHER_POI = modStructureTag("worldgen/structure/nether_poi");
        TagKey<Structure> END_POI = modStructureTag("worldgen/structure/end_poi");
        TagKey<Structure> SETTLEMENT = modStructureTag("worldgen/structure/settlement");
        TagKey<Structure> WITCH_SIGHTING = modStructureTag("worldgen/structure/witch_sighting");
        TagKey<Structure> WAY_SIGN_DESTINATIONS = modStructureTag("supplementaries","worldgen/structure/way_sign_destinations");
        TagKey<Structure> OVERWORLD_SLIME_ISLANDS = modStructureTag("worldgen/structure/overworld_slime_islands");
        TagKey<Structure> NETHER_SLIME_ISLANDS = modStructureTag("worldgen/structure/nether_slime_islands");
        TagKey<Structure> END_SLIME_ISLANDS = modStructureTag("worldgen/structure/end_slime_islands");
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> CAGERIUM_BOSSES = entityTypeTag("cagerium","bosses");
        public static final TagKey<EntityType<?>> CAGERIUM_BLACKLIST = entityTypeTag("cagerium","cagerium_blacklist");

        public static final TagKey<EntityType<?>> BOSSES = entityTypeTag("forge", "bosses");
        public static final TagKey<EntityType<?>> DROPS_CURRENCY = entityTypeTag("forge", "drops_currency");
        public static final TagKey<EntityType<?>> ILLAGERS = entityTypeTag("forge", "illagers");
        public static final TagKey<EntityType<?>> ZOMBIES = entityTypeTag("forge", "zombies");

        public static final TagKey<EntityType<?>> ALLAY_TYPES = entityTypeTag("forge", "allay");
        public static final TagKey<EntityType<?>> AXOLOTL_TYPES = entityTypeTag("forge", "axolotl");
        public static final TagKey<EntityType<?>> BAT_TYPES = entityTypeTag("forge", "bat");
        public static final TagKey<EntityType<?>> BEE_TYPES = entityTypeTag("forge", "bee");
        public static final TagKey<EntityType<?>> BLAZE_TYPES = entityTypeTag("forge", "blaze");
        public static final TagKey<EntityType<?>> CAT_TYPES = entityTypeTag("forge", "cat");
        public static final TagKey<EntityType<?>> CAVE_SPIDER_TYPES = entityTypeTag("forge", "cave_spider");
        public static final TagKey<EntityType<?>> CHICKEN_TYPES = entityTypeTag("forge", "chicken");
        public static final TagKey<EntityType<?>> COD_TYPES = entityTypeTag("forge", "cod");
        public static final TagKey<EntityType<?>> COW_TYPES = entityTypeTag("forge", "cow");
        public static final TagKey<EntityType<?>> CREEPER_TYPES = entityTypeTag("forge", "creeper");
        public static final TagKey<EntityType<?>> DOLPHIN_TYPES = entityTypeTag("forge", "dolphin");
        public static final TagKey<EntityType<?>> DONKEY_TYPES = entityTypeTag("forge", "donkey");
        public static final TagKey<EntityType<?>> DROWNED_TYPES = entityTypeTag("forge", "drowned");
        public static final TagKey<EntityType<?>> ELDER_GUARDIAN_TYPES = entityTypeTag("forge", "elder_guardian");
        public static final TagKey<EntityType<?>> ENDER_DRAGON_TYPES = entityTypeTag("forge", "ender_dragon");
        public static final TagKey<EntityType<?>> ENDERMAN_TYPES = entityTypeTag("forge", "enderman");
        public static final TagKey<EntityType<?>> ENDERMITES_TYPES = entityTypeTag("forge", "endermites");
        public static final TagKey<EntityType<?>> EVOKER_TYPES = entityTypeTag("forge", "evoker");
        public static final TagKey<EntityType<?>> FOX_TYPES = entityTypeTag("forge", "fox");
        public static final TagKey<EntityType<?>> FROG_TYPES = entityTypeTag("forge", "frog");
        public static final TagKey<EntityType<?>> GHAST_TYPES = entityTypeTag("forge", "ghast");
        public static final TagKey<EntityType<?>> GIANT_TYPES = entityTypeTag("forge", "giant");
        public static final TagKey<EntityType<?>> GLOW_SQUID_TYPES = entityTypeTag("forge", "glow_squid");
        public static final TagKey<EntityType<?>> GOAT_TYPES = entityTypeTag("forge", "goat");
        public static final TagKey<EntityType<?>> GUARDIAN_TYPES = entityTypeTag("forge", "guardian");
        public static final TagKey<EntityType<?>> HORSE_TYPES = entityTypeTag("forge", "horse");
        public static final TagKey<EntityType<?>> HUSK_TYPES = entityTypeTag("forge", "husk");
        public static final TagKey<EntityType<?>> ILLUSIONER_TYPES = entityTypeTag("forge", "illusioner");
        public static final TagKey<EntityType<?>> IRON_GOLEM_TYPES = entityTypeTag("forge", "iron_golem");
        public static final TagKey<EntityType<?>> LLAMA_TYPES = entityTypeTag("forge", "llama");
        public static final TagKey<EntityType<?>> MAGMA_CUBE_TYPES = entityTypeTag("forge", "magma_cube");
        public static final TagKey<EntityType<?>> MULE_TYPES = entityTypeTag("forge", "mule");
        public static final TagKey<EntityType<?>> MOOSHROOM_TYPES = entityTypeTag("forge", "mooshroom");
        public static final TagKey<EntityType<?>> OCELOT_TYPES = entityTypeTag("forge", "ocelot");
        public static final TagKey<EntityType<?>> NUMISMATIST_TYPES = entityTypeTag("forge", "numismatist");
        public static final TagKey<EntityType<?>> PANDA_TYPES = entityTypeTag("forge", "panda");
        public static final TagKey<EntityType<?>> PARROT_TYPES = entityTypeTag("forge", "parrot");
        public static final TagKey<EntityType<?>> PHANTOM_TYPES = entityTypeTag("forge", "phantom");
        public static final TagKey<EntityType<?>> PIG_TYPES = entityTypeTag("forge", "pig");
        public static final TagKey<EntityType<?>> PIGLIN_TYPES = entityTypeTag("forge", "piglin");
        public static final TagKey<EntityType<?>> PILLAGER_TYPES = entityTypeTag("forge", "pillager");
        public static final TagKey<EntityType<?>> POLAR_BEAR_TYPES = entityTypeTag("forge", "polar_bear");
        public static final TagKey<EntityType<?>> PUFFERFISH_TYPES = entityTypeTag("forge", "pufferfish");
        public static final TagKey<EntityType<?>> RABBIT_TYPES = entityTypeTag("forge", "rabbit");
        public static final TagKey<EntityType<?>> RAVAGER_TYPES = entityTypeTag("forge", "ravager");
        public static final TagKey<EntityType<?>> SALMON_TYPES = entityTypeTag("forge", "salmon");
        public static final TagKey<EntityType<?>> SHEEP_TYPES = entityTypeTag("forge", "sheep");
        public static final TagKey<EntityType<?>> SHULKER_TYPES = entityTypeTag("forge", "shulker");
        public static final TagKey<EntityType<?>> SILVERFISH_TYPES = entityTypeTag("forge", "silverfish");
        public static final TagKey<EntityType<?>> SKELETON_TYPES = entityTypeTag("forge", "skeleton");
        public static final TagKey<EntityType<?>> SKELETON_HORSE_TYPES = entityTypeTag("forge", "skeleton_horse");
        public static final TagKey<EntityType<?>> SLIME_TYPES = entityTypeTag("forge", "slime");
        public static final TagKey<EntityType<?>> SNOW_GOLEM_TYPES = entityTypeTag("forge", "snow_golem");
        public static final TagKey<EntityType<?>> SPIDER_TYPES = entityTypeTag("forge", "spider");
        public static final TagKey<EntityType<?>> SQUID_TYPES = entityTypeTag("forge", "squid");
        public static final TagKey<EntityType<?>> STRAY_TYPES = entityTypeTag("forge", "stray");
        public static final TagKey<EntityType<?>> STRIDER_TYPES = entityTypeTag("forge", "strider");
        public static final TagKey<EntityType<?>> TADPOLE_TYPES = entityTypeTag("forge", "tadpole");
        public static final TagKey<EntityType<?>> TRADER_LLAMA_TYPES = entityTypeTag("forge", "trader_llama");
        public static final TagKey<EntityType<?>> TROPICAL_FISH_TYPES = entityTypeTag("forge", "tropical_fish");
        public static final TagKey<EntityType<?>> TURTLE_TYPES = entityTypeTag("forge", "turtle");
        public static final TagKey<EntityType<?>> VEX_TYPES = entityTypeTag("forge", "vex");
        public static final TagKey<EntityType<?>> VILLAGER_TYPES = entityTypeTag("forge", "villager");
        public static final TagKey<EntityType<?>> VINDICATOR_TYPES = entityTypeTag("forge", "vindicator");
        public static final TagKey<EntityType<?>> WARDEN_TYPES = entityTypeTag("forge", "warden");
        public static final TagKey<EntityType<?>> WANDERING_TRADER_TYPES = entityTypeTag("forge", "wandering_trader");
        public static final TagKey<EntityType<?>> WITCH_TYPES = entityTypeTag("forge", "witch");
        public static final TagKey<EntityType<?>> WITHER_TYPES = entityTypeTag("forge", "wither");
        public static final TagKey<EntityType<?>> WITHER_SKELETON_TYPES = entityTypeTag("forge", "wither_skeleton");
        public static final TagKey<EntityType<?>> WOLF_TYPES = entityTypeTag("forge", "wolf");
        public static final TagKey<EntityType<?>> ZOGLIN_TYPES = entityTypeTag("forge", "zoglin");
        public static final TagKey<EntityType<?>> ZOMBIE_TYPES = entityTypeTag("forge", "zombie");
        public static final TagKey<EntityType<?>> ZOMBIE_HORSE_TYPES = entityTypeTag("forge", "zombie_horse");
        public static final TagKey<EntityType<?>> ZOMBIFIED_PIGLIN_TYPES = entityTypeTag("forge", "zombified_piglin");
        public static final TagKey<EntityType<?>> HOGLIN_TYPES = entityTypeTag("forge", "hoglin");
        public static final TagKey<EntityType<?>> PIGLIN_BRUTE_TYPES = entityTypeTag("forge", "piglin_brute");
        public static final TagKey<EntityType<?>> PIGLIN_MERCHANT_TYPES = entityTypeTag("forge", "piglin_merchant");
        public static final TagKey<EntityType<?>> ZOMBIE_VILLAGER_TYPES = entityTypeTag("forge", "zombie_villager");

        // friends and foes
        public static final TagKey<EntityType<?>> COPPER_GOLEM_TYPES = entityTypeTag("forge", "copper_golem");
        public static final TagKey<EntityType<?>> GLARE_TYPES = entityTypeTag("forge", "glare");
        public static final TagKey<EntityType<?>> ICEOLOGER_TYPES = entityTypeTag("forge", "iceologer");
        public static final TagKey<EntityType<?>> MAULER_TYPES = entityTypeTag("forge", "mauler");
        public static final TagKey<EntityType<?>> MOOBLOOM_TYPES = entityTypeTag("forge", "moobloom");
        public static final TagKey<EntityType<?>> TUFF_GOLEM_TYPES = entityTypeTag("forge", "tuff_golem");
        public static final TagKey<EntityType<?>> WILDFIRE_TYPES = entityTypeTag("forge", "wildfire");
        public static final TagKey<EntityType<?>> RASCAL_TYPES = entityTypeTag("forge", "rascal");

        // ecologics
        public static final TagKey<EntityType<?>> CAMEL_TYPES = entityTypeTag("forge", "camel");
        public static final TagKey<EntityType<?>> CRAB_TYPES = entityTypeTag("forge", "crab");
        public static final TagKey<EntityType<?>> SQUIRREL_TYPES = entityTypeTag("forge", "squirrel");
        public static final TagKey<EntityType<?>> PENGUIN_TYPES = entityTypeTag("forge", "penguin");

        // guard villagers
        public static final TagKey<EntityType<?>> GUARD_TYPES = entityTypeTag("forge", "guard");

        // vanilla sneak peek
        public static final TagKey<EntityType<?>> SNIFFER_TYPES = entityTypeTag("forge", "sniffer");
        public static final TagKey<EntityType<?>> ARMADILLO_TYPES = entityTypeTag("forge", "armadillo");
    }

    public static class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS_FORGE_TAG = modBlockTag("forge", "storage_blocks");
        public static final TagKey<Block> CURRENCY_BLOCKS_FORGE_TAG = modBlockTag("forge", "storage_blocks/currency_blocks");

        public static final TagKey<Block> STORAGE_BLOCKS = modBlockTag("storage_blocks");
        public static final TagKey<Block> CURRENCY_BLOCKS = modBlockTag("storage_blocks/currency_blocks");
        public static final TagKey<Block> JOB_BLOCKS = modBlockTag("job_blocks");
        public static final TagKey<Block> DROPS_FOUR_LEAF_CLOVER = modBlockTag("drops_four_leaf_clover");
    }

    public static class Items {
        public static final TagKey<Item> NO_AI_EGGS = modItemTag("no_ai_spawn_eggs");
        public static final TagKey<Item> TOOLS_CARVING = modItemTag("tools/carving");
        public static final TagKey<Item> NEEDLES = modItemTag("turtleblockacademy", "needles");
        public static final TagKey<Item> PATTERNS = modItemTag("sewingkit", "patterns");
        public static final TagKey<Item> FILE = modItemTag("sewingkit", "file");
        public static final TagKey<Item> WALLETS = modItemTag("wallets");
        public static final TagKey<Item> BUNDLES = modItemTag("bundles");
        public static final TagKey<Item> SHULKER_BOXES = modItemTag("shulker_boxes");
        public static final TagKey<Item> BLINDS = modItemTag("turtleblockacademy", "blinds");
        public static final TagKey<Item> PICTURE_FRAMES = modItemTag("turtleblockacademy", "picture_frames");
        public static final TagKey<Item> TRELLIS = modItemTag("turtleblockacademy", "trellis");
        public static final TagKey<Item> HANGING_POT = modItemTag("beautify","hanging_pot");
        public static final TagKey<Item> FLOWER_BOX = modItemTag("supplementaries","flower_box");
        public static final TagKey<Item> PET_BEDS = modItemTag("domesticationinnovation","pet_beds");
        public static final TagKey<Item> STICKS = modItemTag(MODID,"sticks");

        public static final TagKey<Item> CHARM = modItemTag("curios", "charm");
        public static final TagKey<Item> BELT = modItemTag("curios", "belt");

        public static final TagKey<Item> CURRENCY = modItemTag("currency");
        public static final TagKey<Item> BANKNOTES = modItemTag("currency/banknotes");
        public static final TagKey<Item> COINS = modItemTag("currency/coins");

        public static final TagKey<Item> CURRENCY_MATERIALS = modItemTag("currency_materials");
        public static final TagKey<Item> CURRENCY_STAMPS = modItemTag("currency_stamps");

        public static final TagKey<Item> BANKNOTES_FORGE_TAG = modItemTag("forge", "banknotes");
        public static final TagKey<Item> COINS_FORGE_TAG = modItemTag("forge", "coins");
        public static final TagKey<Item> CURRENCY_FORGE_TAG = modItemTag("forge", "currency");
        public static final TagKey<Item> CURRENCY_MATERIALS_FORGE_TAG = modItemTag("forge", "currency_materials");
        public static final TagKey<Item> CURRENCY_STAMPS_FORGE_TAG = modItemTag("forge", "currency_stamps");

        public static final TagKey<Item> COLLECTIBLE_COINS = modItemTag("collectible_coins");
        public static final TagKey<Item> COPPER_COLLECTIBLE_COINS = modItemTag("collectible_coins/copper");
        public static final TagKey<Item> IRON_COLLECTIBLE_COINS = modItemTag("collectible_coins/iron");
        public static final TagKey<Item> GOLD_COLLECTIBLE_COINS = modItemTag("collectible_coins/gold");
        public static final TagKey<Item> NETHERITE_COLLECTIBLE_COINS = modItemTag("collectible_coins/netherite");
        public static final TagKey<Item> ENDONIAN_COLLECTIBLE_COINS = modItemTag("collectible_coins/endonian");

        // holiday coins
        public static final TagKey<Item> HOLIDAY_COIN_SET = modItemTag("collectible_coins/holiday_coin_set");
        // patron coins
        public static final TagKey<Item> PATRON_COIN_SET = modItemTag("collectible_coins/patron_coin_set");
        public static final TagKey<Item> LIFETIME_PATRON_COIN_SET = modItemTag("collectible_coins/patron_coins/lifetime_patron_coin_set");
        public static final TagKey<Item> CARNATION_PATRON_COIN_SET = modItemTag("collectible_coins/patron_coins/carnation_patron_coin_set");
        public static final TagKey<Item> COSMOS_PATRON_COIN_SET = modItemTag("collectible_coins/patron_coins/cosmos_patron_coin_set");
        public static final TagKey<Item> SUNFLOWER_PATRON_COIN_SET = modItemTag("collectible_coins/patron_coins/sunflower_patron_coin_set");
        // gameplay coins
        public static final TagKey<Item> GAMEPLAY_COIN_SET = modItemTag("collectible_coins/gameplay_coin_set");
        public static final TagKey<Item> HERO_COIN_SET = modItemTag("collectible_coins/gameplay_coins/hero_coin_set");
        public static final TagKey<Item> FISHING_COIN_SET = modItemTag("collectible_coins/gameplay_coins/fishing_coin_set");
        //entity coins
        public static final TagKey<Item> ENTITY_COIN_SET = modItemTag("collectible_coins/entity_coin_set");
        public static final TagKey<Item> ALLAY_COIN_SET = modItemTag("collectible_coins/entity_coins/allay_coin_set");
        public static final TagKey<Item> AXOLOTL_COIN_SET = modItemTag("collectible_coins/entity_coins/axolotl_coin_set");
        public static final TagKey<Item> BAT_COIN_SET = modItemTag("collectible_coins/entity_coins/bat_coin_set");
        public static final TagKey<Item> BEE_COIN_SET = modItemTag("collectible_coins/entity_coins/bee_coin_set");
        public static final TagKey<Item> BLAZE_COIN_SET = modItemTag("collectible_coins/entity_coins/blaze_coin_set");
        public static final TagKey<Item> CAT_COIN_SET = modItemTag("collectible_coins/entity_coins/cat_coin_set");
        public static final TagKey<Item> CAVE_SPIDER_COIN_SET = modItemTag("collectible_coins/entity_coins/cave_spider_coin_set");
        public static final TagKey<Item> CHICKEN_COIN_SET = modItemTag("collectible_coins/entity_coins/chicken_coin_set");
        public static final TagKey<Item> COD_COIN_SET = modItemTag("collectible_coins/entity_coins/cod_coin_set");
        public static final TagKey<Item> COW_COIN_SET = modItemTag("collectible_coins/entity_coins/cow_coin_set");
        public static final TagKey<Item> CREEPER_COIN_SET = modItemTag("collectible_coins/entity_coins/creeper_coin_set");
        public static final TagKey<Item> DOLPHIN_COIN_SET = modItemTag("collectible_coins/entity_coins/dolphin_coin_set");
        public static final TagKey<Item> DONKEY_COIN_SET = modItemTag("collectible_coins/entity_coins/donkey_coin_set");
        public static final TagKey<Item> DROWNED_COIN_SET = modItemTag("collectible_coins/entity_coins/drowned_coin_set");
        public static final TagKey<Item> ELDER_GUARDIAN_COIN_SET = modItemTag("collectible_coins/entity_coins/elder_guardian_coin_set");
        public static final TagKey<Item> ENDER_DRAGON_COIN_SET = modItemTag("collectible_coins/entity_coins/ender_dragon_coin_set");
        public static final TagKey<Item> ENDERMAN_COIN_SET = modItemTag("collectible_coins/entity_coins/enderman_coin_set");
        public static final TagKey<Item> ENDERMITE_COIN_SET = modItemTag("collectible_coins/entity_coins/endermite_coin_set");
        public static final TagKey<Item> EVOKER_COIN_SET = modItemTag("collectible_coins/entity_coins/evoker_coin_set");
        public static final TagKey<Item> FOX_COIN_SET = modItemTag("collectible_coins/entity_coins/fox_coin_set");
        public static final TagKey<Item> FROG_COIN_SET = modItemTag("collectible_coins/entity_coins/frog_coin_set");
        public static final TagKey<Item> GHAST_COIN_SET = modItemTag("collectible_coins/entity_coins/ghast_coin_set");
        public static final TagKey<Item> GIANT_COIN_SET = modItemTag("collectible_coins/entity_coins/giant_coin_set");
        public static final TagKey<Item> GLOW_SQUID_COIN_SET = modItemTag("collectible_coins/entity_coins/glow_squid_coin_set");
        public static final TagKey<Item> GOAT_COIN_SET = modItemTag("collectible_coins/entity_coins/goat_coin_set");
        public static final TagKey<Item> GUARDIAN_COIN_SET = modItemTag("collectible_coins/entity_coins/guardian_coin_set");
        public static final TagKey<Item> HOGLIN_COIN_SET = modItemTag("collectible_coins/entity_coins/hoglin_coin_set");
        public static final TagKey<Item> HORSE_COIN_SET = modItemTag("collectible_coins/entity_coins/horse_coin_set");
        public static final TagKey<Item> HUSK_COIN_SET = modItemTag("collectible_coins/entity_coins/husk_coin_set");
        public static final TagKey<Item> IRON_GOLEM_COIN_SET = modItemTag("collectible_coins/entity_coins/iron_golem_coin_set");
        public static final TagKey<Item> ILLUSIONER_COIN_SET = modItemTag("collectible_coins/entity_coins/illusioner_coin_set");
        public static final TagKey<Item> LLAMA_COIN_SET = modItemTag("collectible_coins/entity_coins/llama_coin_set");
        public static final TagKey<Item> MAGMA_CUBE_COIN_SET = modItemTag("collectible_coins/entity_coins/magma_cube_coin_set");
        public static final TagKey<Item> MOOSHROOM_COIN_SET = modItemTag("collectible_coins/entity_coins/mooshroom_coin_set");
        public static final TagKey<Item> MULE_COIN_SET = modItemTag("collectible_coins/entity_coins/mule_coin_set");
        public static final TagKey<Item> NUMISMATIST_COIN_SET = modItemTag("collectible_coins/entity_coins/numismatist_coin_set");
        public static final TagKey<Item> OCELOT_COIN_SET = modItemTag("collectible_coins/entity_coins/ocelot_coin_set");
        public static final TagKey<Item> PANDA_COIN_SET = modItemTag("collectible_coins/entity_coins/panda_coin_set");
        public static final TagKey<Item> PARROT_COIN_SET = modItemTag("collectible_coins/entity_coins/parrot_coin_set");
        public static final TagKey<Item> PHANTOM_COIN_SET = modItemTag("collectible_coins/entity_coins/phantom_coin_set");
        public static final TagKey<Item> PIG_COIN_SET = modItemTag("collectible_coins/entity_coins/pig_coin_set");
        public static final TagKey<Item> PIGLIN_BRUTE_COIN_SET = modItemTag("collectible_coins/entity_coins/piglin_brute_coin_set");
        public static final TagKey<Item> PIGLIN_COIN_SET = modItemTag("collectible_coins/entity_coins/piglin_coin_set");
        public static final TagKey<Item> PIGLIN_MERCHANT_COIN_SET = modItemTag("collectible_coins/entity_coins/piglin_merchant_coin_set");
        public static final TagKey<Item> PILLAGER_COIN_SET = modItemTag("collectible_coins/entity_coins/pillager_coin_set");
        public static final TagKey<Item> POLAR_BEAR_COIN_SET = modItemTag("collectible_coins/entity_coins/polar_bear_coin_set");
        public static final TagKey<Item> PUFFERFISH_COIN_SET = modItemTag("collectible_coins/entity_coins/pufferfish_coin_set");
        public static final TagKey<Item> RABBIT_COIN_SET = modItemTag("collectible_coins/entity_coins/rabbit_coin_set");
        public static final TagKey<Item> RAVAGER_COIN_SET = modItemTag("collectible_coins/entity_coins/ravager_coin_set");
        public static final TagKey<Item> SALMON_COIN_SET = modItemTag("collectible_coins/entity_coins/salmon_coin_set");
        public static final TagKey<Item> SHEEP_COIN_SET = modItemTag("collectible_coins/entity_coins/sheep_coin_set");
        public static final TagKey<Item> SHULKER_COIN_SET = modItemTag("collectible_coins/entity_coins/shulker_coin_set");
        public static final TagKey<Item> SILVERFISH_COIN_SET = modItemTag("collectible_coins/entity_coins/silverfish_coin_set");
        public static final TagKey<Item> SKELETON_COIN_SET = modItemTag("collectible_coins/entity_coins/skeleton_coin_set");
        public static final TagKey<Item> SKELETON_HORSE_COIN_SET = modItemTag("collectible_coins/entity_coins/skeleton_horse_coin_set");
        public static final TagKey<Item> SLIME_COIN_SET = modItemTag("collectible_coins/entity_coins/slime_coin_set");
        public static final TagKey<Item> SNIFFER_COIN_SET = modItemTag("collectible_coins/entity_coins/sniffer_coin_set");
        public static final TagKey<Item> ARMADILLO_COIN_SET = modItemTag("collectible_coins/entity_coins/armadillo_coin_set");
        public static final TagKey<Item> SNOW_GOLEM_COIN_SET = modItemTag("collectible_coins/entity_coins/snow_golem_coin_set");
        public static final TagKey<Item> SPIDER_COIN_SET = modItemTag("collectible_coins/entity_coins/spider_coin_set");
        public static final TagKey<Item> STRAY_COIN_SET = modItemTag("collectible_coins/entity_coins/stray_coin_set");
        public static final TagKey<Item> STRIDER_COIN_SET = modItemTag("collectible_coins/entity_coins/strider_coin_set");
        public static final TagKey<Item> SQUID_COIN_SET = modItemTag("collectible_coins/entity_coins/squid_coin_set");
        public static final TagKey<Item> TADPOLE_COIN_SET = modItemTag("collectible_coins/entity_coins/tadpole_coin_set");
        public static final TagKey<Item> TRADER_LLAMA_COIN_SET = modItemTag("collectible_coins/entity_coins/trader_llama_coin_set");
        public static final TagKey<Item> TROPICAL_FISH_COIN_SET = modItemTag("collectible_coins/entity_coins/tropical_fish_coin_set");
        public static final TagKey<Item> TURTLE_COIN_SET = modItemTag("collectible_coins/entity_coins/turtle_coin_set");
        public static final TagKey<Item> VEX_COIN_SET = modItemTag("collectible_coins/entity_coins/vex_coin_set");
        public static final TagKey<Item> VILLAGER_COIN_SET = modItemTag("collectible_coins/entity_coins/villager_coin_set");
        public static final TagKey<Item> VINDICATOR_COIN_SET = modItemTag("collectible_coins/entity_coins/vindicator_coin_set");
        public static final TagKey<Item> WANDERING_TRADER_COIN_SET = modItemTag("collectible_coins/entity_coins/wandering_trader_coin_set");
        public static final TagKey<Item> WARDEN_COIN_SET = modItemTag("collectible_coins/entity_coins/warden_coin_set");
        public static final TagKey<Item> WITCH_COIN_SET = modItemTag("collectible_coins/entity_coins/witch_coin_set");
        public static final TagKey<Item> WITHER_COIN_SET = modItemTag("collectible_coins/entity_coins/wither_coin_set");
        public static final TagKey<Item> WITHER_SKELETON_COIN_SET = modItemTag("collectible_coins/entity_coins/wither_skeleton_coin_set");
        public static final TagKey<Item> WOLF_COIN_SET = modItemTag("collectible_coins/entity_coins/wolf_coin_set");
        public static final TagKey<Item> ZOGLIN_COIN_SET = modItemTag("collectible_coins/entity_coins/zoglin_coin_set");
        public static final TagKey<Item> ZOMBIE_COIN_SET = modItemTag("collectible_coins/entity_coins/zombie_coin_set");
        public static final TagKey<Item> ZOMBIE_HORSE_COIN_SET = modItemTag("collectible_coins/entity_coins/zombie_horse_coin_set");
        public static final TagKey<Item> ZOMBIE_VILLAGER_COIN_SET = modItemTag("collectible_coins/entity_coins/zombie_villager_coin_set");
        public static final TagKey<Item> ZOMBIFIED_PIGLIN_COIN_SET = modItemTag("collectible_coins/entity_coins/zombified_piglin_coin_set");
        // ecologics theme
        public static final TagKey<Item> CAMEL_COIN_SET = modItemTag("collectible_coins/entity_coins/camel_coin_set");
        public static final TagKey<Item> CRAB_COIN_SET = modItemTag("collectible_coins/entity_coins/crab_coin_set");
        public static final TagKey<Item> SQUIRREL_COIN_SET = modItemTag("collectible_coins/entity_coins/squirrel_coin_set");
        public static final TagKey<Item> PENGUIN_COIN_SET = modItemTag("collectible_coins/entity_coins/penguin_coin_set");
        // guard villagers theme
        public static final TagKey<Item> GUARD_COIN_SET = modItemTag("collectible_coins/entity_coins/guard_coin_set");
        // friends and foes theme
        public static final TagKey<Item> MOOBLOOM_COIN_SET = modItemTag("collectible_coins/entity_coins/moobloom_coin_set");
        public static final TagKey<Item> COPPER_GOLEM_COIN_SET = modItemTag("collectible_coins/entity_coins/copper_golem_coin_set");
        public static final TagKey<Item> GLARE_COIN_SET = modItemTag("collectible_coins/entity_coins/glare_coin_set");
        public static final TagKey<Item> ICEOLOGER_COIN_SET = modItemTag("collectible_coins/entity_coins/iceologer_coin_set");
        public static final TagKey<Item> MAULER_COIN_SET = modItemTag("collectible_coins/entity_coins/mauler_coin_set");
        public static final TagKey<Item> WILDFIRE_COIN_SET = modItemTag("collectible_coins/entity_coins/wildfire_coin_set");
        public static final TagKey<Item> TUFF_GOLEM_COIN_SET = modItemTag("collectible_coins/entity_coins/tuff_golem_coin_set");
        public static final TagKey<Item> RASCAL_COIN_SET = modItemTag("collectible_coins/entity_coins/rascal_coin_set");

        public static final TagKey<Item> TEXTILES = modItemTag("textiles");
        public static final TagKey<Item> FIBRE = modItemTag("textiles/fibre");
        public static final TagKey<Item> FABRIC = modItemTag("textiles/fabric");
        public static final TagKey<Item> THREAD = modItemTag("textiles/thread");
        public static final TagKey<Item> CURRENCY_FIBER = modItemTag("textiles/currency_fiber");
        public static final TagKey<Item> CURRENCY_PAPER = modItemTag("textiles/currency_paper");

        public static final TagKey<Item> GEM_CURRENCY = modItemTag("gem_currency");
        public static final TagKey<Item> SOUL_BINDER = modItemTag("soul_binder");
        public static final TagKey<Item> JAR_PLACEABLE = modItemTag("jar_placeable");
        public static final TagKey<Item> REFRESH_BOOK = modItemTag("villager_enchanter", "refresh_book");
        public static final TagKey<Item> BOOKSTACK = modItemTag("beautify", "bookstack");
        public static final TagKey<Item> PACKAGE_CONTAINERS = modItemTag("wares", "package_containers");

        public static final TagKey<Item> NUGGETS = modItemTag("nuggets");
        public static final TagKey<Item> COPPER_NUGGET = modItemTag("nuggets/copper");
        public static final TagKey<Item> IRON_NUGGET = modItemTag("nuggets/iron");
        public static final TagKey<Item> GOLD_NUGGET = modItemTag("nuggets/gold");
        public static final TagKey<Item> LUCKY_NUGGET = modItemTag("nuggets/lucky");
        public static final TagKey<Item> NETHERITE_NUGGET = modItemTag("nuggets/netherite");
        public static final TagKey<Item> ENDONIAN_NUGGET = modItemTag("nuggets/endonian_nugget");

        public static final TagKey<Item> INGOTS = modItemTag("ingots");
        public static final TagKey<Item> COPPER_INGOT = modItemTag("ingots/copper");
        public static final TagKey<Item> IRON_INGOT = modItemTag("ingots/iron");
        public static final TagKey<Item> GOLD_INGOT = modItemTag("ingots/gold");
        public static final TagKey<Item> NETHERITE_INGOT = modItemTag("ingots/netherite");
        public static final TagKey<Item> ENDONIAN_INGOT = modItemTag("ingots/endonian_ingot");

        public static final TagKey<Item> GOGGLES = modItemTag("create", "goggle");
        public static final TagKey<Item> COPPER_MATERIALS = modItemTag("create", "materials/copper");
        public static final TagKey<Item> IRON_MATERIALS = modItemTag("create", "materials/iron");
        public static final TagKey<Item> ZINC_MATERIALS = modItemTag("create", "materials/zinc");
        public static final TagKey<Item> HYDRAULIC_EQUIPMENT = modItemTag("create", "equipment/hydraulic");
        public static final TagKey<Item> MECHANICAL_EQUIPMENT = modItemTag("create", "equipment/mechanical");
        public static final TagKey<Item> MINING_EQUIPMENT = modItemTag("create", "equipment/mining");
        public static final TagKey<Item> TRAIN_EQUIPMENT = modItemTag("create", "equipment/train");
        public static final TagKey<Item> COPPER_DIVING_GEAR = modItemTag("create", "copper_diving_gear");
        public static final TagKey<Item> CREATE_INGOTS = modItemTag("forge", "ingots/create_ingots");
        public static final TagKey<Item> TOOLS_WRENCH = modItemTag("forge", "tools/wrench");
        public static final TagKey<Item> ENGINEER_TOOLS = modItemTag("forge", "tools/engineer_tools");

        public static final TagKey<Item> PIGLIN_MERCHANT_RARE_GOODS = modItemTag("todepiglins", "piglin_merchant_rare_goods");
        public static final TagKey<Item> PIGLIN_MERCHANT_UNCOMMON_GOODS = modItemTag("todepiglins", "piglin_merchant_goods");
        public static final TagKey<Item> PIGLIN_MERCHANT_COMMON_GOODS = modItemTag("todepiglins", "piglin_merchant_common_goods");
        public static final TagKey<Item> PIGLIN_MERCHANT_CHEAP_GOODS = modItemTag("todepiglins", "piglin_merchant_cheap_goods");

        public static final TagKey<Item> NETHER_BLOCKS = modItemTag("todepiglins", "nether_stones");
        public static final TagKey<Item> FUNGUS = modItemTag("todepiglins", "fungus");

        public static final TagKey<Item> PIGLIN_BARTER_ITEMS = modItemTag("forge", "piglin_barter_items");
        public static final TagKey<Item> PIGLIN_WANTED_ITEMS = modItemTag("forge", "piglin_wanted_items");
        public static final TagKey<Item> PIGLIN_LOVED = modItemTag("minecraft", "piglin_loved");
        public static final TagKey<Item> PIGLIN_FOOD = modItemTag("minecraft", "piglin_food");
        public static final TagKey<Item> PIGLIN_MERCHANT_FOOD = modItemTag(MODID, "piglin_merchant_food");

        public static final TagKey<Item> COOKIES = modItemTag("supplementaries", "cookies");
        public static final TagKey<Item> CHOCOLATE = modItemTag("supplementaries", "chocolate_bars");
        public static final TagKey<Item> CANDY = modItemTag("hauntedharvest", "candy");
        public static final TagKey<Item> SWEETS = modItemTag("hauntedharvest", "sweets");

        public static final TagKey<Item> CROPS = modItemTag("forge", "crops");
        public static final TagKey<Item> CROPS_VEGETABLES = modItemTag("forge", "crops/vegetables");
        public static final TagKey<Item> CROPS_GRAINS = modItemTag("forge", "crops/grains");
        public static final TagKey<Item> CROPS_WHEAT = modItemTag("forge", "crops/wheat");
        public static final TagKey<Item> CROPS_POTATO = modItemTag("forge", "crops/potato");
        public static final TagKey<Item> CROPS_CARROTS = modItemTag("forge", "crops/carrots");
        public static final TagKey<Item> CROPS_BEETROOT = modItemTag("forge", "crops/beetroot");
        public static final TagKey<Item> CROPS_CABBAGE = modItemTag("forge", "crops/cabbage");
        public static final TagKey<Item> CROPS_ONION = modItemTag("forge", "crops/onion");
        public static final TagKey<Item> CROPS_RICE = modItemTag("forge", "crops/rice");
        public static final TagKey<Item> CROPS_TOMATO = modItemTag("forge", "crops/tomato");
        public static final TagKey<Item> CROPS_FLAX = modItemTag("forge", "crops/flax");
        public static final TagKey<Item> CROPS_CORN = modItemTag("forge", "crops/corn");
        public static final TagKey<Item> CROPS_FRUIT = modItemTag("forge", "crops/fruits");
        public static final TagKey<Item> CROPS_APPLES = modItemTag("forge", "crops/apples");

        public static final TagKey<Item> SEEDS = modItemTag("forge", "seeds");
        public static final TagKey<Item> SLIMEBALLS = modItemTag("forge", "slimeballs");
        public static final TagKey<Item> SAND = modItemTag("forge", "sand");
        public static final TagKey<Item> CORAL_BLOCKS = modItemTag("forge", "coral_blocks");
        public static final TagKey<Item> RECYCLABLE_GLASS = modItemTag("forge", "recyclable_glass");
        public static final TagKey<Item> GLASSBLOWER_TOOLS = modItemTag("todevillagers", "glassblower_tools");

        public static final TagKey<Item> GOURDS = modItemTag("forge", "gourds");
        public static final TagKey<Item> PIES = modItemTag("forge", "pies");
        public static final TagKey<Item> COOKIES_FORGE_TAG = modItemTag("forge", "cookies");
        public static final TagKey<Item> CAKES = modItemTag("forge", "cakes");

        public static final TagKey<Item> SANDWICHES = modItemTag("forge", "sandwiches");
        public static final TagKey<Item> SIDE_DISHES = modItemTag("forge", "side_dishes");
        public static final TagKey<Item> PLATED_FOODS = modItemTag("forge", "plated_foods");
        public static final TagKey<Item> DESSERTS = modItemTag("forge", "desserts");
        public static final TagKey<Item> DRINKS = modItemTag("forge", "drinks");
        public static final TagKey<Item> FAST_FOOD_SIDE_DISHES = modItemTag("forge", "fast_food_side_dishes");
        public static final TagKey<Item> FAST_FOOD_SANDWICHES = modItemTag("forge", "fast_food_sandwiches");
        public static final TagKey<Item> FAST_FOOD_DRINKS = modItemTag("forge", "fast_food_drinks");
        public static final TagKey<Item> FAST_FOOD_DESSERTS = modItemTag("forge", "fast_food_desserts");
        public static final TagKey<Item> KAWAII_DESSERTS = modItemTag("forge", "kawaii_desserts");
        public static final TagKey<Item> KAWAII_DRINKS = modItemTag("forge", "kawaii_drinks");
        public static final TagKey<Item> KAWAII_CUPS = modItemTag("forge", "kawaii_cups");

        public static final TagKey<Item> PET_FOOD = modItemTag("forge", "pet_food");
        public static final TagKey<Item> PET_SUPPLIES = modItemTag("forge", "pet_supplies");
        public static final TagKey<Item> ENCHANTABLE_PET_GEAR = modItemTag("forge", "enchantable_pet_gear");

        public static final TagKey<Item> INGREDIENTS = modItemTag("forge", "ingredients");

        public static final TagKey<Item> BREAD = modItemTag("forge", "ingredients/bread");
        public static final TagKey<Item> KAWAII_COFFEE_INGREDIENTS = modItemTag("forge", "ingredients/kawaii_coffee");

        public static final TagKey<Item> RAW_MEATS = modItemTag("forge", "ingredients/raw_meats");
        public static final TagKey<Item> RAW_BEEF = modItemTag("forge", "raw_meats/raw_beef");
        public static final TagKey<Item> RAW_CHICKEN = modItemTag("forge", "raw_meats/raw_chicken");
        public static final TagKey<Item> RAW_BACON = modItemTag("forge", "raw_pork/raw_bacon");
        public static final TagKey<Item> RAW_PORK = modItemTag("forge", "raw_meats/raw_pork");
        public static final TagKey<Item> RAW_MUTTON = modItemTag("forge", "raw_meats/raw_mutton");
        public static final TagKey<Item> RAW_RABBIT = modItemTag("forge", "raw_meats/raw_rabbit");
        public static final TagKey<Item> RAW_VENISON = modItemTag("forge", "raw_meats/raw_venison");
        public static final TagKey<Item> RAW_GOAT = modItemTag("forge", "raw_meats/raw_goat");

        public static final TagKey<Item> COOKED_MEATS = modItemTag("forge", "ingredients/cooked_meats");
        public static final TagKey<Item> COOKED_BEEF = modItemTag("forge", "cooked_meats/cooked_beef");
        public static final TagKey<Item> COOKED_CHICKEN = modItemTag("forge", "cooked_meats/cooked_chicken");
        public static final TagKey<Item> COOKED_BACON = modItemTag("forge", "cooked_pork/cooked_bacon");
        public static final TagKey<Item> COOKED_PORK = modItemTag("forge", "cooked_meats/cooked_pork");
        public static final TagKey<Item> COOKED_MUTTON = modItemTag("forge", "cooked_meats/cooked_mutton");
        public static final TagKey<Item> COOKED_RABBIT = modItemTag("forge", "cooked_meats/cooked_rabbit");
        public static final TagKey<Item> COOKED_VENISON = modItemTag("forge", "cooked_meats/cooked_venison");
        public static final TagKey<Item> COOKED_GOAT = modItemTag("forge", "cooked_meats/cooked_goat");

        public static final TagKey<Item> RAW_FISHES = modItemTag("forge", "ingredients/raw_fishes");
        public static final TagKey<Item> RAW_SQUID = modItemTag("forge", "raw_fishes/raw_squid");
        public static final TagKey<Item> RAW_GLOW_SQUID = modItemTag("forge", "raw_fishes/raw_glow_squid");
        public static final TagKey<Item> RAW_CRAB = modItemTag("forge", "raw_fishes/raw_crab");
        public static final TagKey<Item> RAW_CLAM = modItemTag("forge", "raw_fishes/raw_clam");
        public static final TagKey<Item> RAW_SHRIMP = modItemTag("forge", "raw_fishes/raw_shrimp");
        public static final TagKey<Item> RAW_CLAWSTER = modItemTag("forge", "raw_fishes/raw_clawster");
        public static final TagKey<Item> RAW_GUARDIAN = modItemTag("forge", "raw_fishes/raw_guardian");
        public static final TagKey<Item> RAW_ELDER_GUARDIAN = modItemTag("forge", "raw_fishes/raw_elder_guardian");
        public static final TagKey<Item> RAW_SALMON = modItemTag("forge", "raw_fishes/raw_salmon");
        public static final TagKey<Item> RAW_COD = modItemTag("forge", "raw_fishes/raw_cod");
        public static final TagKey<Item> RAW_PUFFERFISH = modItemTag("forge", "raw_fishes/raw_pufferfish");
        public static final TagKey<Item> RAW_TROPICAL_FISH = modItemTag("forge", "raw_fishes/raw_tropical_fish");

        public static final TagKey<Item> COOKED_FISHES = modItemTag("forge", "cooked_fishes");
        public static final TagKey<Item> COOKED_SQUID = modItemTag("forge", "cooked_fishes/cooked_squid");
        public static final TagKey<Item> COOKED_GLOW_SQUID = modItemTag("forge", "cooked_fishes/cooked_glow_squid");
        public static final TagKey<Item> COOKED_CRAB = modItemTag("forge", "cooked_fishes/cooked_crab");
        public static final TagKey<Item> COOKED_CLAM = modItemTag("forge", "cooked_fishes/cooked_clam");
        public static final TagKey<Item> COOKED_SHRIMP = modItemTag("forge", "cooked_fishes/cooked_shrimp");
        public static final TagKey<Item> COOKED_CLAWSTER = modItemTag("forge", "cooked_fishes/cooked_clawster");
        public static final TagKey<Item> COOKED_GUARDIAN = modItemTag("forge", "cooked_fishes/cooked_guardian");
        public static final TagKey<Item> COOKED_ELDER_GUARDIAN = modItemTag("forge", "cooked_fishes/cooked_elder_guardian");
        public static final TagKey<Item> COOKED_SALMON = modItemTag("forge", "cooked_fishes/cooked_salmon");
        public static final TagKey<Item> COOKED_COD = modItemTag("forge", "cooked_fishes/cooked_cod");
        public static final TagKey<Item> COOKED_TROPICAL_FISH = modItemTag("forge", "cooked_fishes/cooked_tropical_fish");

        public static final TagKey<Item> SOUPS = modItemTag("forge", "soups");
        public static final TagKey<Item> MEAT_SOUPS = modItemTag("forge", "soups/meat_soups");
        public static final TagKey<Item> VEGETABLE_SOUPS = modItemTag("forge", "soups/vegetable_soups");

        public static final TagKey<Item> FISH_SOUPS = modItemTag("forge", "soups/fish_soups");
        public static final TagKey<Item> SUSHI = modItemTag("forge", "sushi");

        public static final TagKey<Item> CRAB_TRAP = modItemTag("crabbersdelight", "crab_trap");

        public static final TagKey<Item> MILK_TYPES = modItemTag("forge", "milk");
        public static final TagKey<Item> MILK = modItemTag("forge", "milk/milk");
        public static final TagKey<Item> MILK_BOTTLES = modItemTag("forge", "milk/milk_bottle");
        public static final TagKey<Item> COCOA = modItemTag("forge", "cocoa");
        public static final TagKey<Item> COCOA_INGREDIENTS = modItemTag("forge", "ingredients/cocoa");
        public static final TagKey<Item> SUGAR = modItemTag("forge", "sugar");
        public static final TagKey<Item> FAT = modItemTag("forge", "fat");
        public static final TagKey<Item> CLOVER = modItemTag("forge", "clover");
        public static final TagKey<Item> BERRIES = modItemTag("forge", "crops/berries");

        public static final TagKey<Item> SALTS = modItemTag("forge", "salts");
        public static final TagKey<Item> ASH = modItemTag("forge", "ash");
        public static final TagKey<Item> QUIVERS = modItemTag("forge", "quivers");
        public static final TagKey<Item> INK = modItemTag("forge", "ink");
        public static final TagKey<Item> GUIDE_BOOKS = modItemTag("forge", "guide_books");
        public static final TagKey<Item> GLAZED_TERRACOTTA = modItemTag("forge", "glazed_terracotta");
        public static final TagKey<Item> RODS = modItemTag("forge", "rods");
        public static final TagKey<Item> DYES = modItemTag("forge","dyes");

        public static final TagKey<Item> TOOLS_KNIVES = modItemTag("forge", "tools/knives");
        public static final TagKey<Item> TOOLS_CHISELS = modItemTag("forge", "tools/chisels");

        public static final TagKey<Item> LEATHER = modItemTag("forge", "leather");
        public static final TagKey<Item> TEXTILES_FORGE_TAG = modItemTag("forge", "textiles");
        public static final TagKey<Item> LEATHER_TEXTILES = modItemTag("forge", "textiles/leather");
        public static final TagKey<Item> BARK = modItemTag("forge", "textiles/bark");
        public static final TagKey<Item> FIBRE_FORGE_TAG = modItemTag("forge", "textiles/fibre");
        public static final TagKey<Item> STRING = modItemTag("forge", "textiles/string");
        public static final TagKey<Item> PAPER = modItemTag("forge", "textiles/paper");
        public static final TagKey<Item> FABRIC_FORGE_TAG = modItemTag("forge", "textiles/fabric");
        public static final TagKey<Item> THREAD_FORGE_TAG = modItemTag("forge", "textiles/thread");
        public static final TagKey<Item> CURRENCY_FIBER_FORGE_TAG = modItemTag("forge", "textiles/currency_fiber");
        public static final TagKey<Item> CURRENCY_PAPER_FORGE_TAG = modItemTag("forge", "textiles/currency_paper");

        public static final TagKey<Item> DYEABLE_HELMETS = modItemTag("forge", "dyeable_helmets");
        public static final TagKey<Item> DYEABLE_CHESTPLATES = modItemTag("forge", "dyeable_chestplates");
        public static final TagKey<Item> DYEABLE_LEGGINGS = modItemTag("forge", "dyeable_leggings");
        public static final TagKey<Item> DYEABLE_BOOTS = modItemTag("forge", "dyeable_boots");

        public static final TagKey<Item> GEM_CURRENCY_FORGE_TAG = modItemTag("forge", "gem_currency");
        public static final TagKey<Item> AMETHYST = modItemTag("forge", "gem_currency/amethyst");
        public static final TagKey<Item> DIAMOND = modItemTag("forge", "gem_currency/diamond");
        public static final TagKey<Item> ECHO_SHARD = modItemTag("forge", "gem_currency/echo_shard");
        public static final TagKey<Item> EMERALD = modItemTag("forge", "gem_currency/emerald");
        public static final TagKey<Item> END_CRYSTAL = modItemTag("forge", "gem_currency/end_crystal");
        public static final TagKey<Item> ENDER_EYE = modItemTag("forge", "gem_currency/ender_eye");
        public static final TagKey<Item> ENDER_PEARL = modItemTag("forge", "gem_currency/ender_pearl");
        public static final TagKey<Item> GLOWSTONE = modItemTag("forge", "gem_currency/glowstone");
        public static final TagKey<Item> LAPIS_LAZULI = modItemTag("forge", "gem_currency/lapis_lazuli");
        public static final TagKey<Item> NETHER_STAR = modItemTag("forge", "gem_currency/nether_star");
        public static final TagKey<Item> PRISMARINE = modItemTag("forge", "gem_currency/prismarine");
        public static final TagKey<Item> QUARTZ = modItemTag("forge", "gem_currency/quartz");
        public static final TagKey<Item> REDSTONE = modItemTag("forge", "gem_currency/redstone");

        public static final TagKey<Item> NUGGETS_FORGE_TAG = modItemTag("forge", "nuggets");
        public static final TagKey<Item> COPPER_NUGGET_FORGE_TAG = modItemTag("forge", "nuggets/copper");
        public static final TagKey<Item> IRON_NUGGET_FORGE_TAG = modItemTag("forge", "nuggets/iron");
        public static final TagKey<Item> GOLD_NUGGET_FORGE_TAG = modItemTag("forge", "nuggets/gold");
        public static final TagKey<Item> LUCKY_NUGGET_FORGE_TAG = modItemTag("forge", "nuggets/lucky");
        public static final TagKey<Item> NETHERITE_NUGGET_FORGE_TAG = modItemTag("forge", "nuggets/netherite");
        public static final TagKey<Item> ENDONIAN_NUGGET_FORGE_TAG = modItemTag("forge", "nuggets/endonian_nugget");

        public static final TagKey<Item> INGOTS_FORGE_TAG = modItemTag("forge", "ingots");
        public static final TagKey<Item> COPPER_INGOT_FORGE_TAG = modItemTag("forge", "ingots/copper");
        public static final TagKey<Item> IRON_INGOT_FORGE_TAG = modItemTag("forge", "ingots/iron");
        public static final TagKey<Item> GOLD_INGOT_FORGE_TAG = modItemTag("forge", "ingots/gold");
        public static final TagKey<Item> NETHERITE_INGOT_FORGE_TAG = modItemTag("forge", "ingots/netherite");
        public static final TagKey<Item> ENDONIAN_INGOT_FORGE_TAG = modItemTag("forge", "ingots/endonian_ingot");
    }

    private static @NotNull TagKey<Biome> modBiomeTag(String name) {
        //noinspection removal
        return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("forge", name));
    }

    public static @NotNull TagKey<Structure> modStructureTag(String path) {
        //noinspection removal
        return TagKey.create(Registry.STRUCTURE_REGISTRY, new ResourceLocation("forge", path));
    }
    public static @NotNull TagKey<Structure> modStructureTag(String modid, String path) {
        //noinspection removal
        return TagKey.create(Registry.STRUCTURE_REGISTRY, new ResourceLocation(modid, path));
    }

    private static @NotNull TagKey<EntityType<?>> entityTypeTag(String modid, String path) {
        //noinspection removal
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(modid, path));
    }

    private static @NotNull TagKey<Block> modBlockTag(String path) {
        //noinspection removal
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(MODID, path));
    }
    @SuppressWarnings("SameParameterValue")
    private static @NotNull TagKey<Block> modBlockTag(String modid, String path) {
        //noinspection removal
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(modid, path));
    }

    private static @NotNull TagKey<Item> modItemTag(String path) {
        //noinspection removal
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, path));
    }
    private static @NotNull TagKey<Item> modItemTag(String modid, String path) {
        //noinspection removal
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(modid, path));
    }
}