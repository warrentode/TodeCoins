package com.github.warrentode.todecoins.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.jetbrains.annotations.NotNull;

public class ForgeTags {
    public static class EntityTypes {
        public static final TagKey<EntityType<?>> BOSSES = forgeEntityTypeTag("forge", "bosses");
        public static final TagKey<EntityType<?>> DROPS_CURRENCY = forgeEntityTypeTag("forge", "drops_currency");
        public static final TagKey<EntityType<?>> ILLAGERS = forgeEntityTypeTag("forge", "illagers");
        public static final TagKey<EntityType<?>> ZOMBIES = forgeEntityTypeTag("forge", "zombies");

        public static final TagKey<EntityType<?>> ALLAY_TYPES = forgeEntityTypeTag("forge", "allay");
        public static final TagKey<EntityType<?>> AXOLOTL_TYPES = forgeEntityTypeTag("forge", "axolotl");
        public static final TagKey<EntityType<?>> BAT_TYPES = forgeEntityTypeTag("forge", "bat");
        public static final TagKey<EntityType<?>> BEE_TYPES = forgeEntityTypeTag("forge", "bee");
        public static final TagKey<EntityType<?>> BLAZE_TYPES = forgeEntityTypeTag("forge", "blaze");
        public static final TagKey<EntityType<?>> CAT_TYPES = forgeEntityTypeTag("forge", "cat");
        public static final TagKey<EntityType<?>> CAVE_SPIDER_TYPES = forgeEntityTypeTag("forge", "cave_spider");
        public static final TagKey<EntityType<?>> CHICKEN_TYPES = forgeEntityTypeTag("forge", "chicken");
        public static final TagKey<EntityType<?>> COD_TYPES = forgeEntityTypeTag("forge", "cod");
        public static final TagKey<EntityType<?>> COW_TYPES = forgeEntityTypeTag("forge", "cow");
        public static final TagKey<EntityType<?>> CREEPER_TYPES = forgeEntityTypeTag("forge", "creeper");
        public static final TagKey<EntityType<?>> DOLPHIN_TYPES = forgeEntityTypeTag("forge", "dolphin");
        public static final TagKey<EntityType<?>> DONKEY_TYPES = forgeEntityTypeTag("forge", "donkey");
        public static final TagKey<EntityType<?>> DROWNED_TYPES = forgeEntityTypeTag("forge", "drowned");
        public static final TagKey<EntityType<?>> ELDER_GUARDIAN_TYPES = forgeEntityTypeTag("forge", "elder_guardian");
        public static final TagKey<EntityType<?>> ENDER_DRAGON_TYPES = forgeEntityTypeTag("forge", "ender_dragon");
        public static final TagKey<EntityType<?>> ENDERMAN_TYPES = forgeEntityTypeTag("forge", "enderman");
        public static final TagKey<EntityType<?>> ENDERMITES_TYPES = forgeEntityTypeTag("forge", "endermites");
        public static final TagKey<EntityType<?>> EVOKER_TYPES = forgeEntityTypeTag("forge", "evoker");
        public static final TagKey<EntityType<?>> FOX_TYPES = forgeEntityTypeTag("forge", "fox");
        public static final TagKey<EntityType<?>> FROG_TYPES = forgeEntityTypeTag("forge", "frog");
        public static final TagKey<EntityType<?>> GHAST_TYPES = forgeEntityTypeTag("forge", "ghast");
        public static final TagKey<EntityType<?>> GIANT_TYPES = forgeEntityTypeTag("forge", "giant");
        public static final TagKey<EntityType<?>> GLOW_SQUID_TYPES = forgeEntityTypeTag("forge", "glow_squid");
        public static final TagKey<EntityType<?>> GOAT_TYPES = forgeEntityTypeTag("forge", "goat");
        public static final TagKey<EntityType<?>> GUARDIAN_TYPES = forgeEntityTypeTag("forge", "guardian");
        public static final TagKey<EntityType<?>> HORSE_TYPES = forgeEntityTypeTag("forge", "horse");
        public static final TagKey<EntityType<?>> HUSK_TYPES = forgeEntityTypeTag("forge", "husk");
        public static final TagKey<EntityType<?>> ILLUSIONER_TYPES = forgeEntityTypeTag("forge", "illusioner");
        public static final TagKey<EntityType<?>> IRON_GOLEM_TYPES = forgeEntityTypeTag("forge", "iron_golem");
        public static final TagKey<EntityType<?>> LLAMA_TYPES = forgeEntityTypeTag("forge", "llama");
        public static final TagKey<EntityType<?>> MAGMA_CUBE_TYPES = forgeEntityTypeTag("forge", "magma_cube");
        public static final TagKey<EntityType<?>> MULE_TYPES = forgeEntityTypeTag("forge", "mule");
        public static final TagKey<EntityType<?>> MOOSHROOM_TYPES = forgeEntityTypeTag("forge", "mooshroom");
        public static final TagKey<EntityType<?>> OCELOT_TYPES = forgeEntityTypeTag("forge", "ocelot");
        public static final TagKey<EntityType<?>> NUMISMATIST_TYPES = forgeEntityTypeTag("forge", "numismatist");
        public static final TagKey<EntityType<?>> PANDA_TYPES = forgeEntityTypeTag("forge", "panda");
        public static final TagKey<EntityType<?>> PARROT_TYPES = forgeEntityTypeTag("forge", "parrot");
        public static final TagKey<EntityType<?>> PHANTOM_TYPES = forgeEntityTypeTag("forge", "phantom");
        public static final TagKey<EntityType<?>> PIG_TYPES = forgeEntityTypeTag("forge", "pig");
        public static final TagKey<EntityType<?>> PIGLIN_TYPES = forgeEntityTypeTag("forge", "piglin");
        public static final TagKey<EntityType<?>> PILLAGER_TYPES = forgeEntityTypeTag("forge", "pillager");
        public static final TagKey<EntityType<?>> POLAR_BEAR_TYPES = forgeEntityTypeTag("forge", "polar_bear");
        public static final TagKey<EntityType<?>> PUFFERFISH_TYPES = forgeEntityTypeTag("forge", "pufferfish");
        public static final TagKey<EntityType<?>> RABBIT_TYPES = forgeEntityTypeTag("forge", "rabbit");
        public static final TagKey<EntityType<?>> RAVAGER_TYPES = forgeEntityTypeTag("forge", "ravager");
        public static final TagKey<EntityType<?>> SALMON_TYPES = forgeEntityTypeTag("forge", "salmon");
        public static final TagKey<EntityType<?>> SHEEP_TYPES = forgeEntityTypeTag("forge", "sheep");
        public static final TagKey<EntityType<?>> SHULKER_TYPES = forgeEntityTypeTag("forge", "shulker");
        public static final TagKey<EntityType<?>> SILVERFISH_TYPES = forgeEntityTypeTag("forge", "silverfish");
        public static final TagKey<EntityType<?>> SKELETON_TYPES = forgeEntityTypeTag("forge", "skeleton");
        public static final TagKey<EntityType<?>> SKELETON_HORSE_TYPES = forgeEntityTypeTag("forge", "skeleton_horse");
        public static final TagKey<EntityType<?>> SLIME_TYPES = forgeEntityTypeTag("forge", "slime");
        public static final TagKey<EntityType<?>> SNOW_GOLEM_TYPES = forgeEntityTypeTag("forge", "snow_golem");
        public static final TagKey<EntityType<?>> SPIDER_TYPES = forgeEntityTypeTag("forge", "spider");
        public static final TagKey<EntityType<?>> SQUID_TYPES = forgeEntityTypeTag("forge", "squid");
        public static final TagKey<EntityType<?>> STRAY_TYPES = forgeEntityTypeTag("forge", "stray");
        public static final TagKey<EntityType<?>> STRIDER_TYPES = forgeEntityTypeTag("forge", "strider");
        public static final TagKey<EntityType<?>> TADPOLE_TYPES = forgeEntityTypeTag("forge", "tadpole");
        public static final TagKey<EntityType<?>> TRADER_LLAMA_TYPES = forgeEntityTypeTag("forge", "trader_llama");
        public static final TagKey<EntityType<?>> TROPICAL_FISH_TYPES = forgeEntityTypeTag("forge", "tropical_fish");
        public static final TagKey<EntityType<?>> TURTLE_TYPES = forgeEntityTypeTag("forge", "turtle");
        public static final TagKey<EntityType<?>> VEX_TYPES = forgeEntityTypeTag("forge", "vex");
        public static final TagKey<EntityType<?>> VILLAGER_TYPES = forgeEntityTypeTag("forge", "villager");
        public static final TagKey<EntityType<?>> VINDICATOR_TYPES = forgeEntityTypeTag("forge", "vindicator");
        public static final TagKey<EntityType<?>> WARDEN_TYPES = forgeEntityTypeTag("forge", "warden");
        public static final TagKey<EntityType<?>> WANDERING_TRADER_TYPES = forgeEntityTypeTag("forge", "wandering_trader");
        public static final TagKey<EntityType<?>> WITCH_TYPES = forgeEntityTypeTag("forge", "witch");
        public static final TagKey<EntityType<?>> WITHER_TYPES = forgeEntityTypeTag("forge", "wither");
        public static final TagKey<EntityType<?>> WITHER_SKELETON_TYPES = forgeEntityTypeTag("forge", "wither_skeleton");
        public static final TagKey<EntityType<?>> WOLF_TYPES = forgeEntityTypeTag("forge", "wolf");
        public static final TagKey<EntityType<?>> ZOGLIN_TYPES = forgeEntityTypeTag("forge", "zoglin");
        public static final TagKey<EntityType<?>> ZOMBIE_TYPES = forgeEntityTypeTag("forge", "zombie");
        public static final TagKey<EntityType<?>> ZOMBIE_HORSE_TYPES = forgeEntityTypeTag("forge", "zombie_horse");
        public static final TagKey<EntityType<?>> ZOMBIFIED_PIGLIN_TYPES = forgeEntityTypeTag("forge", "zombified_piglin");
        public static final TagKey<EntityType<?>> HOGLIN_TYPES = forgeEntityTypeTag("forge", "hoglin");
        public static final TagKey<EntityType<?>> PIGLIN_BRUTE_TYPES = forgeEntityTypeTag("forge", "piglin_brute");
        public static final TagKey<EntityType<?>> PIGLIN_MERCHANT_TYPES = forgeEntityTypeTag("forge", "piglin_merchant");
        public static final TagKey<EntityType<?>> ZOMBIE_VILLAGER_TYPES = forgeEntityTypeTag("forge", "zombie_villager");

        // friends and foes
        public static final TagKey<EntityType<?>> COPPER_GOLEM_TYPES = forgeEntityTypeTag("forge", "copper_golem");
        public static final TagKey<EntityType<?>> GLARE_TYPES = forgeEntityTypeTag("forge", "glare");
        public static final TagKey<EntityType<?>> ICEOLOGER_TYPES = forgeEntityTypeTag("forge", "iceologer");
        public static final TagKey<EntityType<?>> MAULER_TYPES = forgeEntityTypeTag("forge", "mauler");
        public static final TagKey<EntityType<?>> MOOBLOOM_TYPES = forgeEntityTypeTag("forge", "moobloom");
        public static final TagKey<EntityType<?>> TUFF_GOLEM_TYPES = forgeEntityTypeTag("forge", "tuff_golem");
        public static final TagKey<EntityType<?>> WILDFIRE_TYPES = forgeEntityTypeTag("forge", "wildfire");
        public static final TagKey<EntityType<?>> RASCAL_TYPES = forgeEntityTypeTag("forge", "rascal");

        // ecologics
        public static final TagKey<EntityType<?>> CAMEL_TYPES = forgeEntityTypeTag("forge", "camel");
        public static final TagKey<EntityType<?>> CRAB_TYPES = forgeEntityTypeTag("forge", "crab");
        public static final TagKey<EntityType<?>> SQUIRREL_TYPES = forgeEntityTypeTag("forge", "squirrel");
        public static final TagKey<EntityType<?>> PENGUIN_TYPES = forgeEntityTypeTag("forge", "penguin");

        // guard villagers
        public static final TagKey<EntityType<?>> GUARD_TYPES = forgeEntityTypeTag("forge", "guard");

        // vanilla sneak peek
        public static final TagKey<EntityType<?>> SNIFFER_TYPES = forgeEntityTypeTag("forge", "sniffer");
        public static final TagKey<EntityType<?>> ARMADILLO_TYPES = forgeEntityTypeTag("forge", "armadillo");
    }

    public static class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS = forgeBlockTag("forge", "storage_blocks");
        public static final TagKey<Block> CURRENCY_BLOCKS = forgeBlockTag("forge", "storage_blocks/currency_blocks");
    }

    public static class Items {
        public static final TagKey<Item> CROPS = forgeItemTag("forge", "crops");
        public static final TagKey<Item> CROPS_VEGETABLES = forgeItemTag("forge", "crops/vegetables");
        public static final TagKey<Item> CROPS_GRAINS = forgeItemTag("forge", "crops/grains");
        public static final TagKey<Item> CROPS_WHEAT = forgeItemTag("forge", "crops/wheat");
        public static final TagKey<Item> CROPS_POTATO = forgeItemTag("forge", "crops/potato");
        public static final TagKey<Item> CROPS_CARROTS = forgeItemTag("forge", "crops/carrots");
        public static final TagKey<Item> CROPS_BEETROOT = forgeItemTag("forge", "crops/beetroot");
        public static final TagKey<Item> CROPS_CABBAGE = forgeItemTag("forge", "crops/cabbage");
        public static final TagKey<Item> CROPS_ONION = forgeItemTag("forge", "crops/onion");
        public static final TagKey<Item> CROPS_RICE = forgeItemTag("forge", "crops/rice");
        public static final TagKey<Item> CROPS_TOMATO = forgeItemTag("forge", "crops/tomato");
        public static final TagKey<Item> CROPS_FLAX = forgeItemTag("forge", "crops/flax");
        public static final TagKey<Item> CROPS_CORN = forgeItemTag("forge", "crops/corn");
        public static final TagKey<Item> CROPS_FRUIT = forgeItemTag("forge", "crops/fruits");
        public static final TagKey<Item> CROPS_APPLES = forgeItemTag("forge", "crops/apples");

        public static final TagKey<Item> SEEDS = forgeItemTag("forge", "seeds");
        public static final TagKey<Item> SLIMEBALLS = forgeItemTag("forge", "slimeballs");
        public static final TagKey<Item> SAND = forgeItemTag("forge", "sand");
        public static final TagKey<Item> CORAL_BLOCKS = forgeItemTag("forge", "coral_blocks");
        public static final TagKey<Item> RECYCLABLE_GLASS = forgeItemTag("forge", "recyclable_glass");
        public static final TagKey<Item> GLASSBLOWER_TOOLS = forgeItemTag("todevillagers", "glassblower_tools");

        public static final TagKey<Item> GOURDS = forgeItemTag("forge", "gourds");
        public static final TagKey<Item> PIES = forgeItemTag("forge", "pies");
        public static final TagKey<Item> COOKIES = forgeItemTag("forge", "cookies");
        public static final TagKey<Item> CAKES = forgeItemTag("forge", "cakes");
        public static final TagKey<Item> SANDWICHES = forgeItemTag("forge", "sandwiches");
        public static final TagKey<Item> SIDE_DISHES = forgeItemTag("forge", "side_dishes");
        public static final TagKey<Item> PLATED_FOODS = forgeItemTag("forge", "plated_foods");
        public static final TagKey<Item> DESSERTS = forgeItemTag("forge", "desserts");

        public static final TagKey<Item> INGREDIENTS = forgeItemTag("forge", "ingredients");

        public static final TagKey<Item> BREAD = forgeItemTag("forge", "ingredients/bread");

        public static final TagKey<Item> RAW_MEATS = forgeItemTag("forge", "ingredients/raw_meats");
        public static final TagKey<Item> RAW_BEEF = forgeItemTag("forge", "raw_meats/raw_beef");
        public static final TagKey<Item> RAW_CHICKEN = forgeItemTag("forge", "raw_meats/raw_chicken");
        public static final TagKey<Item> RAW_BACON = forgeItemTag("forge", "raw_pork/raw_bacon");
        public static final TagKey<Item> RAW_PORK = forgeItemTag("forge", "raw_meats/raw_pork");
        public static final TagKey<Item> RAW_MUTTON = forgeItemTag("forge", "raw_meats/raw_mutton");
        public static final TagKey<Item> RAW_RABBIT = forgeItemTag("forge", "raw_meats/raw_rabbit");
        public static final TagKey<Item> RAW_VENISON = forgeItemTag("forge", "raw_meats/raw_venison");
        public static final TagKey<Item> RAW_GOAT = forgeItemTag("forge", "raw_meats/raw_goat");

        public static final TagKey<Item> COOKED_MEATS = forgeItemTag("forge", "ingredients/cooked_meats");
        public static final TagKey<Item> COOKED_BEEF = forgeItemTag("forge", "cooked_meats/cooked_beef");
        public static final TagKey<Item> COOKED_CHICKEN = forgeItemTag("forge", "cooked_meats/cooked_chicken");
        public static final TagKey<Item> COOKED_BACON = forgeItemTag("forge", "cooked_pork/cooked_bacon");
        public static final TagKey<Item> COOKED_PORK = forgeItemTag("forge", "cooked_meats/cooked_pork");
        public static final TagKey<Item> COOKED_MUTTON = forgeItemTag("forge", "cooked_meats/cooked_mutton");
        public static final TagKey<Item> COOKED_RABBIT = forgeItemTag("forge", "cooked_meats/cooked_rabbit");
        public static final TagKey<Item> COOKED_VENISON = forgeItemTag("forge", "cooked_meats/cooked_venison");
        public static final TagKey<Item> COOKED_GOAT = forgeItemTag("forge", "cooked_meats/cooked_goat");

        public static final TagKey<Item> RAW_FISHES = forgeItemTag("forge", "ingredients/raw_fishes");
        public static final TagKey<Item> RAW_SQUID = forgeItemTag("forge", "raw_fishes/raw_squid");
        public static final TagKey<Item> RAW_GLOW_SQUID = forgeItemTag("forge", "raw_fishes/raw_glow_squid");
        public static final TagKey<Item> RAW_CRAB = forgeItemTag("forge", "raw_fishes/raw_crab");
        public static final TagKey<Item> RAW_CLAM = forgeItemTag("forge", "raw_fishes/raw_clam");
        public static final TagKey<Item> RAW_SHRIMP = forgeItemTag("forge", "raw_fishes/raw_shrimp");
        public static final TagKey<Item> RAW_CLAWSTER = forgeItemTag("forge", "raw_fishes/raw_clawster");
        public static final TagKey<Item> RAW_GUARDIAN = forgeItemTag("forge", "raw_fishes/raw_guardian");
        public static final TagKey<Item> RAW_ELDER_GUARDIAN = forgeItemTag("forge", "raw_fishes/raw_elder_guardian");
        public static final TagKey<Item> RAW_SALMON = forgeItemTag("forge", "raw_fishes/raw_salmon");
        public static final TagKey<Item> RAW_COD = forgeItemTag("forge", "raw_fishes/raw_cod");
        public static final TagKey<Item> RAW_PUFFERFISH = forgeItemTag("forge", "raw_fishes/raw_pufferfish");
        public static final TagKey<Item> RAW_TROPICAL_FISH = forgeItemTag("forge", "raw_fishes/raw_tropical_fish");

        public static final TagKey<Item> COOKED_FISHES = forgeItemTag("forge", "cooked_fishes");
        public static final TagKey<Item> COOKED_SQUID = forgeItemTag("forge", "cooked_fishes/cooked_squid");
        public static final TagKey<Item> COOKED_GLOW_SQUID = forgeItemTag("forge", "cooked_fishes/cooked_glow_squid");
        public static final TagKey<Item> COOKED_CRAB = forgeItemTag("forge", "cooked_fishes/cooked_crab");
        public static final TagKey<Item> COOKED_CLAM = forgeItemTag("forge", "cooked_fishes/cooked_clam");
        public static final TagKey<Item> COOKED_SHRIMP = forgeItemTag("forge", "cooked_fishes/cooked_shrimp");
        public static final TagKey<Item> COOKED_CLAWSTER = forgeItemTag("forge", "cooked_fishes/cooked_clawster");
        public static final TagKey<Item> COOKED_GUARDIAN = forgeItemTag("forge", "cooked_fishes/cooked_guardian");
        public static final TagKey<Item> COOKED_ELDER_GUARDIAN = forgeItemTag("forge", "cooked_fishes/cooked_elder_guardian");
        public static final TagKey<Item> COOKED_SALMON = forgeItemTag("forge", "cooked_fishes/cooked_salmon");
        public static final TagKey<Item> COOKED_COD = forgeItemTag("forge", "cooked_fishes/cooked_cod");
        public static final TagKey<Item> COOKED_TROPICAL_FISH = forgeItemTag("forge", "cooked_fishes/cooked_tropical_fish");

        public static final TagKey<Item> SOUPS = forgeItemTag("forge", "soups");
        public static final TagKey<Item> MEAT_SOUPS = forgeItemTag("forge", "soups/meat_soups");
        public static final TagKey<Item> VEGETABLE_SOUPS = forgeItemTag("forge", "soups/vegetable_soups");

        public static final TagKey<Item> FISH_SOUPS = forgeItemTag("forge", "soups/fish_soups");
        public static final TagKey<Item> SUSHI = forgeItemTag("forge", "sushi");

        public static final TagKey<Item> CRAB_TRAP = forgeItemTag("crabbersdelight", "crab_trap");

        public static final TagKey<Item> MILK_TYPES = forgeItemTag("forge", "milk");
        public static final TagKey<Item> MILK = forgeItemTag("forge", "milk/milk");
        public static final TagKey<Item> MILK_BOTTLES = forgeItemTag("forge", "milk/milk_bottle");
        public static final TagKey<Item> COCOA = forgeItemTag("forge", "cocoa");
        public static final TagKey<Item> COCOA_INGREDIENTS = forgeItemTag("forge", "ingredients/cocoa");
        public static final TagKey<Item> SUGAR = forgeItemTag("forge", "sugar");
        public static final TagKey<Item> FAT = forgeItemTag("forge", "fat");
        public static final TagKey<Item> CLOVER = forgeItemTag("forge", "clover");
        public static final TagKey<Item> BERRIES = forgeItemTag("forge", "crops/berries");

        public static final TagKey<Item> SALTS = forgeItemTag("forge", "salts");
        public static final TagKey<Item> ASH = forgeItemTag("forge", "ash");
        public static final TagKey<Item> QUIVERS = forgeItemTag("forge", "quivers");
        public static final TagKey<Item> INK = forgeItemTag("forge", "ink");
        public static final TagKey<Item> GUIDE_BOOKS = forgeItemTag("forge", "guide_books");
        public static final TagKey<Item> GLAZED_TERRACOTTA = forgeItemTag("forge", "glazed_terracotta");
        public static final TagKey<Item> STICKS = forgeItemTag("forge", "rods");
        public static final TagKey<Item> DYES = forgeItemTag("forge","dyes");

        public static final TagKey<Item> TOOLS_KNIVES = forgeItemTag("forge", "tools/knives");
        public static final TagKey<Item> TOOLS_CHISELS = forgeItemTag("forge", "tools/chisels");
        public static final TagKey<Item> BANKNOTES = forgeItemTag("forge", "banknotes");
        public static final TagKey<Item> COINS = forgeItemTag("forge", "coins");
        public static final TagKey<Item> CURRENCY = forgeItemTag("forge", "currency");
        public static final TagKey<Item> CURRENCY_MATERIALS = forgeItemTag("forge", "currency_materials");
        public static final TagKey<Item> CURRENCY_STAMPS = forgeItemTag("forge", "currency_stamps");

        public static final TagKey<Item> PIGLIN_BARTER_ITEMS = forgeItemTag("forge", "piglin_barter_items");

        public static final TagKey<Item> LEATHER = forgeItemTag("forge", "leather");
        public static final TagKey<Item> TEXTILES = forgeItemTag("forge", "textiles");
        public static final TagKey<Item> LEATHER_TEXTILES = forgeItemTag("forge", "textiles/leather");
        public static final TagKey<Item> BARK = forgeItemTag("forge", "textiles/bark");
        public static final TagKey<Item> FIBRE = forgeItemTag("forge", "textiles/fibre");
        public static final TagKey<Item> STRING = forgeItemTag("forge", "textiles/string");
        public static final TagKey<Item> PAPER = forgeItemTag("forge", "textiles/paper");
        public static final TagKey<Item> FABRIC = forgeItemTag("forge", "textiles/fabric");
        public static final TagKey<Item> THREAD = forgeItemTag("forge", "textiles/thread");
        public static final TagKey<Item> CURRENCY_FIBER = forgeItemTag("forge", "textiles/currency_fiber");
        public static final TagKey<Item> CURRENCY_PAPER = forgeItemTag("forge", "textiles/currency_paper");

        public static final TagKey<Item> DYEABLE_HELMETS = forgeItemTag("forge", "dyeable_helmets");
        public static final TagKey<Item> DYEABLE_CHESTPLATES = forgeItemTag("forge", "dyeable_chestplates");
        public static final TagKey<Item> DYEABLE_LEGGINGS = forgeItemTag("forge", "dyeable_leggings");
        public static final TagKey<Item> DYEABLE_BOOTS = forgeItemTag("forge", "dyeable_boots");

        public static final TagKey<Item> GEM_CURRENCY = forgeItemTag("forge", "gem_currency");
        public static final TagKey<Item> AMETHYST = forgeItemTag("forge", "gem_currency/amethyst");
        public static final TagKey<Item> DIAMOND = forgeItemTag("forge", "gem_currency/diamond");
        public static final TagKey<Item> ECHO_SHARD = forgeItemTag("forge", "gem_currency/echo_shard");
        public static final TagKey<Item> EMERALD = forgeItemTag("forge", "gem_currency/emerald");
        public static final TagKey<Item> END_CRYSTAL = forgeItemTag("forge", "gem_currency/end_crystal");
        public static final TagKey<Item> ENDER_EYE = forgeItemTag("forge", "gem_currency/ender_eye");
        public static final TagKey<Item> ENDER_PEARL = forgeItemTag("forge", "gem_currency/ender_pearl");
        public static final TagKey<Item> GLOWSTONE = forgeItemTag("forge", "gem_currency/glowstone");
        public static final TagKey<Item> LAPIS_LAZULI = forgeItemTag("forge", "gem_currency/lapis_lazuli");
        public static final TagKey<Item> NETHER_STAR = forgeItemTag("forge", "gem_currency/nether_star");
        public static final TagKey<Item> PRISMARINE = forgeItemTag("forge", "gem_currency/prismarine");
        public static final TagKey<Item> QUARTZ = forgeItemTag("forge", "gem_currency/quartz");
        public static final TagKey<Item> REDSTONE = forgeItemTag("forge", "gem_currency/redstone");

        public static final TagKey<Item> NUGGETS = forgeItemTag("forge", "nuggets");
        public static final TagKey<Item> COPPER_NUGGET = forgeItemTag("forge", "nuggets/copper");
        public static final TagKey<Item> IRON_NUGGET = forgeItemTag("forge", "nuggets/iron");
        public static final TagKey<Item> GOLD_NUGGET = forgeItemTag("forge", "nuggets/gold");
        public static final TagKey<Item> LUCKY_NUGGET = forgeItemTag("forge", "nuggets/lucky");
        public static final TagKey<Item> NETHERITE_NUGGET = forgeItemTag("forge", "nuggets/netherite");
        public static final TagKey<Item> ENDONIAN_NUGGET = forgeItemTag("forge", "nuggets/endonian_nugget");

        public static final TagKey<Item> INGOTS = forgeItemTag("forge", "ingots");
        public static final TagKey<Item> COPPER_INGOT = forgeItemTag("forge", "ingots/copper");
        public static final TagKey<Item> IRON_INGOT = forgeItemTag("forge", "ingots/iron");
        public static final TagKey<Item> GOLD_INGOT = forgeItemTag("forge", "ingots/gold");
        public static final TagKey<Item> NETHERITE_INGOT = forgeItemTag("forge", "ingots/netherite");
        public static final TagKey<Item> ENDONIAN_INGOT = forgeItemTag("forge", "ingots/endonian_ingot");
    }

    public interface StructureTags {
        TagKey<Structure> ON_ANCIENT_CITY_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/ancient_city");
        TagKey<Structure> ON_BASTION_REMNANT_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/bastion_remnant");
        TagKey<Structure> ON_DESERT_PYRAMID_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/desert_pyramid");
        TagKey<Structure> ON_END_CITY_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/end_city");
        TagKey<Structure> ON_IGLOO_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/igloo");
        TagKey<Structure> ON_JUNGLE_TEMPLE_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/jungle_temple");
        TagKey<Structure> ON_MINESHAFT_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/mineshaft");
        TagKey<Structure> ON_NETHER_FORTRESS_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/nether_fortress");
        TagKey<Structure> ON_NETHER_FOSSIL_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/nether_fossil");
        TagKey<Structure> ON_NETHER_RUINED_PORTAL_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/nether_ruined_portal");
        TagKey<Structure> ON_OCEAN_RUIN_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/ocean_ruin");
        TagKey<Structure> ON_OCEAN_MONUMENT_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/monument");
        TagKey<Structure> ON_OVERWORLD_RUINED_PORTAL_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/overworld_ruined_portal");
        TagKey<Structure> ON_PILLAGER_OUTPOST_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/pillager_outpost");
        TagKey<Structure> ON_WOODLAND_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/mansion");
        TagKey<Structure> ON_SHIPWRECK_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/shipwreck");
        TagKey<Structure> ON_STRONGHOLD_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/stronghold");
        TagKey<Structure> ON_SWAMP_HUT_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/swamp_hut");
        TagKey<Structure> ON_VILLAGE_EXPLORER_MAPS = forgeStructureTag("forge", "worldgen/structure/village");
        TagKey<Structure> ON_TREASURE_MAPS = forgeStructureTag("forge", "worldgen/structure/treasure");

        TagKey<Structure> OVERWORLD_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/overworld_poi");
        TagKey<Structure> OVERWORLD_END_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/overworld_end_poi");
        TagKey<Structure> OVERWORLD_NETHER_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/overworld_nether_poi");

        TagKey<Structure> DESERT_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/desert_poi");
        TagKey<Structure> JUNGLE_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/jungle_poi");
        TagKey<Structure> OCEAN_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/ocean_poi");
        TagKey<Structure> PILLAGER_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/pillager_poi");
        TagKey<Structure> MISC_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/misc_poi");
        TagKey<Structure> TREASURE_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/treasure_poi");
        TagKey<Structure> UNDERGROUND_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/underground_poi");
        TagKey<Structure> NETHER_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/nether_poi");
        TagKey<Structure> END_POI = forgeStructureTag("turtleblockacademy", "worldgen/structure/end_poi");
        TagKey<Structure> SETTLEMENT = forgeStructureTag("turtleblockacademy", "worldgen/structure/settlement");
        TagKey<Structure> WITCH_SIGHTING = forgeStructureTag("turtleblockacademy", "worldgen/structure/witch_sighting");
        TagKey<Structure> WAY_SIGN_DESTINATIONS = forgeStructureTag("supplementaries", "worldgen/structure/way_sign_destinations");
        TagKey<Structure> OVERWORLD_SLIME_ISLANDS = forgeStructureTag("tconstruct", "worldgen/structure/overworld_slime_islands");
        TagKey<Structure> NETHER_SLIME_ISLANDS = forgeStructureTag("tconstruct", "worldgen/structure/nether_slime_islands");
        TagKey<Structure> END_SLIME_ISLANDS = forgeStructureTag("tconstruct", "worldgen/structure/end_slime_islands");
    }

    public interface Biomes {
        TagKey<Biome> HAS_SUNFLOWER = forgeBiomeTag("has_sunflower");
        TagKey<Biome> HAS_PEONY = forgeBiomeTag("has_peony");
        TagKey<Biome> HAS_ROSE_BUSH = forgeBiomeTag("has_rose_bush");
        TagKey<Biome> HAS_LILAC = forgeBiomeTag("has_lilac");
        TagKey<Biome> HAS_BUTTERCUP = forgeBiomeTag("has_buttercup");
        TagKey<Biome> HAS_LILY_OF_THE_VALLEY = forgeBiomeTag("has_lily_of_the_valley");
        TagKey<Biome> HAS_CORNFLOWER = forgeBiomeTag("has_cornflower");
        TagKey<Biome> HAS_OXEYE_DAISY = forgeBiomeTag("has_oxeye_daisy");
        TagKey<Biome> HAS_PINK_TULIP = forgeBiomeTag("has_pink_tulip");
        TagKey<Biome> HAS_WHITE_TULIP = forgeBiomeTag("has_white_tulip");
        TagKey<Biome> HAS_ORANGE_TULIP = forgeBiomeTag("has_orange_tulip");
        TagKey<Biome> HAS_RED_TULIP = forgeBiomeTag("has_red_tulip");
        TagKey<Biome> HAS_AZURE_BLUET = forgeBiomeTag("has_azure_bluet");
        TagKey<Biome> HAS_ALLIUM = forgeBiomeTag("has_allium");
        TagKey<Biome> HAS_BLUE_ORCHID = forgeBiomeTag("has_blue_orchid");
        TagKey<Biome> HAS_SPRUCE = forgeBiomeTag("has_spruce");
        TagKey<Biome> HAS_MANGROVE = forgeBiomeTag("has_mangrove");
        TagKey<Biome> HAS_ACACIA = forgeBiomeTag("has_acacia");
        TagKey<Biome> HAS_JUNGLE = forgeBiomeTag("has_jungle");
        TagKey<Biome> HAS_BIRCH = forgeBiomeTag("has_birch");
        TagKey<Biome> HAS_DARK_OAK = forgeBiomeTag("has_dark_oak");
        TagKey<Biome> NETHER_BIOMES = forgeBiomeTag("nether_biomes");
        TagKey<Biome> HAS_WARPED_FUNGUS = forgeBiomeTag("has_warped_fungus");
        TagKey<Biome> HAS_CRIMSON_FUNGUS = forgeBiomeTag("has_crimson_fungus");
        TagKey<Biome> HAS_SANDSTONE = forgeBiomeTag("has_sandstone");
        TagKey<Biome> HAS_RED_SANDSTONE = forgeBiomeTag("has_red_sandstone");
        TagKey<Biome> HAS_MOSSY_STONE = forgeBiomeTag("has_mossy_stone");
        TagKey<Biome> HAS_PUFFERFISH = forgeBiomeTag("has_pufferfish");
        TagKey<Biome> HAS_TROPICAL_FISH = forgeBiomeTag("has_tropical_fish");
        TagKey<Biome> HAS_SALMON = forgeBiomeTag("has_salmon");
        TagKey<Biome> HAS_FROGS = forgeBiomeTag("has_frogs");
        TagKey<Biome> HAS_AXOLOTL = forgeBiomeTag("has_axolotl");
        TagKey<Biome> HAS_MUD = forgeBiomeTag("has_mud");
    }

    private static @NotNull TagKey<Biome> forgeBiomeTag(String name) {
        return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("forge", name));
    }

    @SuppressWarnings({"unused", "SameParameterValue"})
    private static TagKey<EntityType<?>> forgeEntityTypeTag(String modid, String path) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(modid, path));
    }

    @SuppressWarnings({"unused", "SameParameterValue"})
    private static TagKey<Block> forgeBlockTag(String modid, String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(modid, path));
    }

    @SuppressWarnings({"unused", "SameParameterValue"})
    private static TagKey<Item> forgeItemTag(String modid, String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(modid, path));
    }

    public static TagKey<Structure> forgeStructureTag(String modid, String path) {
        return TagKey.create(Registry.STRUCTURE_REGISTRY, new ResourceLocation(modid, path));
    }
}