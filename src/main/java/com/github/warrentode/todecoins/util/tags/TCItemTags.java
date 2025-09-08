package com.github.warrentode.todecoins.util.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TCItemTags {
        // will need to add creaking, happy ghast, breeze, and bogged when updating to 1.21
        public static final TagKey<Item> NO_AI_EGGS = itemTag(MODID,"no_ai_spawn_eggs");
        public static final TagKey<Item> TOOLS_CARVING = itemTag("forge","tools/carving");

        public static final TagKey<Item> FRIENDSHIP_BRACELETS = itemTag(MODID, "friendship_bracelets");

        public static final TagKey<Item> BUCKET_REMAINDERS = itemTag("forge", "bucket_remainders");
        public static final TagKey<Item> BOWL_REMAINDERS = itemTag("forge", "bowl_remainders");
        public static final TagKey<Item> BOTTLE_REMAINDERS = itemTag("forge", "bottle_remainders");
        public static final TagKey<Item> MATCHING_ITEM_REMAINDERS = itemTag("forge", "matching_item_remainders");

        public static final TagKey<Item> TIP_JAR_ITEMS = itemTag(MODID, "tip_jar_items");
        public static final TagKey<Item> CURRENCY_SINGLES = itemTag(MODID, "currency_singles");
        public static final TagKey<Item> CURRENCY = itemTag(MODID, "currency");
        public static final TagKey<Item> CURRENCY_MATERIALS = itemTag(MODID, "currency_materials");
        public static final TagKey<Item> CURRENCY_STAMPS = itemTag(MODID, "currency_stamps");
        public static final TagKey<Item> ONE_EMERALD_CURRENCY_GEMS = itemTag(MODID, "one_emerald_currency_gems");

        public static final TagKey<Item> TEXTILES = itemTag("forge","textiles");
        public static final TagKey<Item> FIBRE = itemTag("forge","textiles/fibre");
        public static final TagKey<Item> FABRIC = itemTag("forge","textiles/fabric");
        public static final TagKey<Item> THREAD = itemTag("forge","textiles/thread");
        public static final TagKey<Item> STRING = itemTag("forge", "textiles/string");
        public static final TagKey<Item> PAPER = itemTag("forge", "textiles/paper");
        public static final TagKey<Item> BARK = itemTag("forge", "textiles/bark");
        // for basic leather type items
        public static final TagKey<Item> LEATHER = itemTag("forge", "leather");
        // for fancy leather types items - like cut leather
        public static final TagKey<Item> LEATHER_TEXTILES = itemTag("forge", "textiles/leather");
        public static final TagKey<Item> DYES = itemTag("forge","dyes");

        public static final TagKey<Item> CURRENCY_FIBER = itemTag("forge","textiles/currency_fiber");
        public static final TagKey<Item> CURRENCY_PAPER = itemTag("forge","textiles/currency_paper");

        public static final TagKey<Item> NUGGETS = itemTag("forge","nuggets");
        public static final TagKey<Item> COPPER_NUGGET = itemTag("forge","nuggets/copper");
        public static final TagKey<Item> IRON_NUGGET = itemTag("forge","nuggets/iron");
        public static final TagKey<Item> GOLD_NUGGET = itemTag("forge","nuggets/gold");
        public static final TagKey<Item> LUCKY_NUGGET = itemTag("forge","nuggets/lucky");
        public static final TagKey<Item> NETHERITE_NUGGET = itemTag("forge","nuggets/netherite");
        public static final TagKey<Item> ENDONIAN_NUGGET = itemTag("forge","nuggets/endonian_nugget");

        public static final TagKey<Item> INGOTS = itemTag("forge","ingots");
        public static final TagKey<Item> COPPER_INGOT = itemTag("forge","ingots/copper");
        public static final TagKey<Item> IRON_INGOT = itemTag("forge","ingots/iron");
        public static final TagKey<Item> GOLD_INGOT = itemTag("forge","ingots/gold");
        public static final TagKey<Item> NETHERITE_INGOT = itemTag("forge","ingots/netherite");
        public static final TagKey<Item> ENDONIAN_INGOT = itemTag("forge","ingots/endonian_ingot");

        public static final TagKey<Item> RECYCLABLE_GLASS = itemTag("forge", "recyclable_glass");
        public static final TagKey<Item> GLASSBLOWER_TOOLS = itemTag("forge", "glassblower_tools");
        public static final TagKey<Item> SOUL_BINDER = itemTag("forge","soul_binder");
        public static final TagKey<Item> TOTEMS = itemTag("forge","totems");
        public static final TagKey<Item> WALLETS = itemTag(MODID,"wallets");
        public static final TagKey<Item> BUNDLES = itemTag("forge","bundles");
        public static final TagKey<Item> CRAB_TRAP = itemTag("crabbersdelight", "crab_trap");

        public static final TagKey<Item> ROPES = itemTag("forge","ropes");
        public static final TagKey<Item> STICKS = itemTag("forge","sticks");
        public static final TagKey<Item> ASH = itemTag("forge", "ash");
        public static final TagKey<Item> CLOVER = itemTag("forge", "clover");
        public static final TagKey<Item> SALT = itemTag("forge", "salt");
        public static final TagKey<Item> TRIMS = itemTag("forge", "trims");
        public static final TagKey<Item> SLIMEBALLS = itemTag("forge", "slimeballs");
        public static final TagKey<Item> GUIDE_BOOKS = itemTag("patchouli", "guide_book");
        public static final TagKey<Item> DECORATIVE_BOOKS = itemTag("forge", "decor_books");
        public static final TagKey<Item> LANTERNS = itemTag("forge", "lanterns");
        public static final TagKey<Item> INK = itemTag("forge", "ink");
        public static final TagKey<Item> GLAZED_TERRACOTTA = itemTag("forge", "glazed_terracotta");
        public static final TagKey<Item> PACKAGE_CONTAINERS = itemTag("forge", "package_containers");
        public static final TagKey<Item> PLANTERS = itemTag("forge", "planters");
        public static final TagKey<Item> BLINDS = itemTag("forge", "blinds");
        public static final TagKey<Item> PICTURE_FRAMES = itemTag("forge", "picture_frames");
        public static final TagKey<Item> TRELLIS = itemTag("forge", "trellis");
        public static final TagKey<Item> CANDELABRA = itemTag("forge", "candelabras");
        public static final TagKey<Item> SAND = itemTag("forge", "sand");
        public static final TagKey<Item> FUNGUS = itemTag("forge", "fungus");

        public static final TagKey<Item> END_SAPLINGS = itemTag(MODID, "extra_end_biome_saplings");
        public static final TagKey<Item> END_LOGS = itemTag(MODID, "extra_end_biome_logs");

        public static final TagKey<Item> PET_BEDS = itemTag("forge","pet_beds");
        public static final TagKey<Item> PET_FOOD = itemTag("forge", "pet_food");
        public static final TagKey<Item> PET_SUPPLIES = itemTag("forge", "pet_supplies");
        public static final TagKey<Item> ENCHANTABLE_PET_GEAR = itemTag("forge", "enchantable_pet_gear");

        public static final TagKey<Item> REFRESH_BOOK = itemTag("forge", "refresh_book");
        public static final TagKey<Item> SEWING_PATTERNS = itemTag("forge", "patterns");

        public static final TagKey<Item> CUPS = itemTag("forge", "cups");
        public static final TagKey<Item> BOWLS = itemTag("forge", "bowls");
        public static final TagKey<Item> SLEDS = itemTag("forge", "sleds");

        public static final TagKey<Item> INGREDIENTS = itemTag("forge", "ingredients");

        public static final TagKey<Item> BREAD = itemTag("forge", "ingredients/bread");
        public static final TagKey<Item> COCOA_INGREDIENTS = itemTag("forge", "ingredients/cocoa");
        public static final TagKey<Item> COFFEE_INGREDIENTS = itemTag("forge", "ingredients/coffee");
        public static final TagKey<Item> SWEETENER = itemTag("forge", "ingredients/sugar");
        public static final TagKey<Item> MILK = itemTag("forge", "milk/milk");
        public static final TagKey<Item> DRINKS = itemTag("forge", "drinks");
        public static final TagKey<Item> GOURDS = itemTag("forge", "gourds");
        public static final TagKey<Item> PIES = itemTag("forge", "pies");
        public static final TagKey<Item> COOKIES = itemTag("forge", "cookies");
        public static final TagKey<Item> COOKIE_CUTTERS = itemTag("forge", "cookie_cutters");
        public static final TagKey<Item> CANDY = itemTag("forge", "candy");
        public static final TagKey<Item> CHOCOLATE_BARS = itemTag("supplementaries", "chocolate_bars");
        public static final TagKey<Item> SWEETS = itemTag("hauntedharvest", "sweets");
        public static final TagKey<Item> CAKES = itemTag("forge", "cakes");
        public static final TagKey<Item> BERRIES = itemTag("forge", "crops/berries");
        public static final TagKey<Item> FAT = itemTag("forge", "fat");
        public static final TagKey<Item> KAWAII_COFFEE_INGREDIENTS = itemTag("forge", "ingredients/kawaii_coffee_ingredients");
        public static final TagKey<Item> CROPS_FRUIT = itemTag("forge", "crops/fruits");
        public static final TagKey<Item> CROPS_APPLES = itemTag("forge", "crops/apples");

        public static final TagKey<Item> RAW_MEATS = itemTag("forge", "ingredients/raw_meats");
        public static final TagKey<Item> RAW_BEEF = itemTag("forge", "raw_meats/raw_beef");
        public static final TagKey<Item> RAW_CHICKEN = itemTag("forge", "raw_meats/raw_chicken");
        public static final TagKey<Item> RAW_BACON = itemTag("forge", "raw_pork/raw_bacon");
        public static final TagKey<Item> RAW_PORK = itemTag("forge", "raw_meats/raw_pork");
        public static final TagKey<Item> RAW_MUTTON = itemTag("forge", "raw_meats/raw_mutton");
        public static final TagKey<Item> RAW_RABBIT = itemTag("forge", "raw_meats/raw_rabbit");
        public static final TagKey<Item> RAW_VENISON = itemTag("forge", "raw_meats/raw_venison");
        public static final TagKey<Item> RAW_GOAT = itemTag("forge", "raw_meats/raw_goat");

        public static final TagKey<Item> COOKED_MEATS = itemTag("forge", "ingredients/cooked_meats");
        public static final TagKey<Item> COOKED_BEEF = itemTag("forge", "cooked_meats/cooked_beef");
        public static final TagKey<Item> COOKED_CHICKEN = itemTag("forge", "cooked_meats/cooked_chicken");
        public static final TagKey<Item> COOKED_BACON = itemTag("forge", "cooked_pork/cooked_bacon");
        public static final TagKey<Item> COOKED_PORK = itemTag("forge", "cooked_meats/cooked_pork");
        public static final TagKey<Item> COOKED_MUTTON = itemTag("forge", "cooked_meats/cooked_mutton");
        public static final TagKey<Item> COOKED_RABBIT = itemTag("forge", "cooked_meats/cooked_rabbit");
        public static final TagKey<Item> COOKED_VENISON = itemTag("forge", "cooked_meats/cooked_venison");
        public static final TagKey<Item> COOKED_GOAT = itemTag("forge", "cooked_meats/cooked_goat");

        public static final TagKey<Item> SOUPS = itemTag("forge", "soups");
        public static final TagKey<Item> MEAT_SOUPS = itemTag("forge", "soups/meat_soups");
        public static final TagKey<Item> VEGETABLE_SOUPS = itemTag("forge", "soups/vegetable_soups");
        public static final TagKey<Item> FISH_SOUPS = itemTag("forge", "soups/fish_soups");

        public static final TagKey<Item> SUSHI = itemTag("forge", "sushi");

        public static final TagKey<Item> RAW_FISHES = itemTag("forge", "ingredients/raw_fishes");
        public static final TagKey<Item> RAW_SQUID = itemTag("forge", "raw_fishes/raw_squid");
        public static final TagKey<Item> RAW_GLOW_SQUID = itemTag("forge", "raw_fishes/raw_glow_squid");
        public static final TagKey<Item> RAW_CRAB = itemTag("forge", "raw_fishes/raw_crab");
        public static final TagKey<Item> RAW_CLAM = itemTag("forge", "raw_fishes/raw_clam");
        public static final TagKey<Item> RAW_SHRIMP = itemTag("forge", "raw_fishes/raw_shrimp");
        public static final TagKey<Item> RAW_CLAWSTER = itemTag("forge", "raw_fishes/raw_clawster");
        public static final TagKey<Item> RAW_GUARDIAN = itemTag("forge", "raw_fishes/raw_guardian");
        public static final TagKey<Item> RAW_ELDER_GUARDIAN = itemTag("forge", "raw_fishes/raw_elder_guardian");
        public static final TagKey<Item> RAW_SALMON = itemTag("forge", "raw_fishes/raw_salmon");
        public static final TagKey<Item> RAW_COD = itemTag("forge", "raw_fishes/raw_cod");
        public static final TagKey<Item> RAW_PUFFERFISH = itemTag("forge", "raw_fishes/raw_pufferfish");
        public static final TagKey<Item> RAW_TROPICAL_FISH = itemTag("forge", "raw_fishes/raw_tropical_fish");

        public static final TagKey<Item> COOKED_FISHES = itemTag("forge", "cooked_fishes");
        public static final TagKey<Item> COOKED_SQUID = itemTag("forge", "cooked_fishes/cooked_squid");
        public static final TagKey<Item> COOKED_GLOW_SQUID = itemTag("forge", "cooked_fishes/cooked_glow_squid");
        public static final TagKey<Item> COOKED_CRAB = itemTag("forge", "cooked_fishes/cooked_crab");
        public static final TagKey<Item> COOKED_CLAM = itemTag("forge", "cooked_fishes/cooked_clam");
        public static final TagKey<Item> COOKED_SHRIMP = itemTag("forge", "cooked_fishes/cooked_shrimp");
        public static final TagKey<Item> COOKED_CLAWSTER = itemTag("forge", "cooked_fishes/cooked_clawster");
        public static final TagKey<Item> COOKED_GUARDIAN = itemTag("forge", "cooked_fishes/cooked_guardian");
        public static final TagKey<Item> COOKED_ELDER_GUARDIAN = itemTag("forge", "cooked_fishes/cooked_elder_guardian");
        public static final TagKey<Item> COOKED_SALMON = itemTag("forge", "cooked_fishes/cooked_salmon");
        public static final TagKey<Item> COOKED_COD = itemTag("forge", "cooked_fishes/cooked_cod");
        public static final TagKey<Item> COOKED_TROPICAL_FISH = itemTag("forge", "cooked_fishes/cooked_tropical_fish");

        public static final TagKey<Item> SANDWICHES = itemTag("forge", "sandwiches");
        public static final TagKey<Item> SIDE_DISHES = itemTag("forge", "side_dishes");
        public static final TagKey<Item> PLATED_FOODS = itemTag("forge", "plated_foods");
        public static final TagKey<Item> DESSERTS = itemTag("forge", "desserts");

        public static final TagKey<Item> PIGLIN_BARTER_ITEMS = itemTag("forge", "piglin_barter_items");
        public static final TagKey<Item> PIGLIN_WANTED_ITEMS = itemTag("forge", "piglin_wanted_items");
        public static final TagKey<Item> PIGLIN_LOVED = itemTag("minecraft", "piglin_loved");
        public static final TagKey<Item> PIGLIN_MERCHANT_FOOD = itemTag(MODID, "piglin_merchant_food");
        public static final TagKey<Item> PIGLIN_MERCHANT_CHEAP_GOODS = itemTag(MODID, "piglin_merchant_cheap_goods");
        public static final TagKey<Item> PIGLIN_MERCHANT_COMMON_GOODS = itemTag(MODID, "piglin_merchant_common_goods");
        public static final TagKey<Item> PIGLIN_MERCHANT_UNCOMMON_GOODS = itemTag(MODID, "piglin_merchant_goods");
        public static final TagKey<Item> PIGLIN_MERCHANT_RARE_GOODS = itemTag(MODID, "piglin_merchant_rare_goods");

        public static final TagKey<Item> SHULKER_BOXES = itemTag("forge","shulker_boxes");

        public static final TagKey<Item> TOOLS_CHISELS = itemTag("forge", "tools/chisels");
        public static final TagKey<Item> TOOLS_KNIVES = itemTag("forge", "tools/knives");
        public static final TagKey<Item> WOOD_TIER_KNIVES = itemTag("forge", "tools/wood/knives");
        public static final TagKey<Item> STONE_TIER_KNIVES = itemTag("forge", "tools/stone/knives");
        public static final TagKey<Item> IRON_TIER_KNIVES = itemTag("forge", "tools/iron/knives");
        public static final TagKey<Item> GOLD_TIER_KNIVES = itemTag("forge", "tools/gold/knives");
        public static final TagKey<Item> DIAMOND_TIER_KNIVES = itemTag("forge", "tools/diamond/knives");
        public static final TagKey<Item> NETHERITE_TIER_KNIVES = itemTag("forge", "tools/netherite/knives");
        public static final TagKey<Item> BEYOND_TIER_KNIVES = itemTag("forge", "tools/beyond/knives");
        public static final TagKey<Item> TOOLS_SEWING = itemTag("forge", "tools/sewing");
        public static final TagKey<Item> WOOD_TIER_SEWING_TOOLS = itemTag("forge", "tools/wood/sewing_tools");
        public static final TagKey<Item> STONE_TIER_SEWING_TOOLS = itemTag("forge", "tools/stone/sewing_tools");
        public static final TagKey<Item> IRON_TIER_SEWING_TOOLS = itemTag("forge", "tools/iron/sewing_tools");
        public static final TagKey<Item> GOLD_TIER_SEWING_TOOLS = itemTag("forge", "tools/gold/sewing_tools");
        public static final TagKey<Item> DIAMOND_TIER_SEWING_TOOLS = itemTag("forge", "tools/diamond/sewing_tools");
        public static final TagKey<Item> NETHERITE_TIER_SEWING_TOOLS = itemTag("forge", "tools/netherite/sewing_tools");

        public static final TagKey<Item> DYEABLE_ARMOR = itemTag("forge", "armor/dyeable");

        // ---------- COLLECTIBLE COIN TAGS ----------
        public static final TagKey<Item> COLLECTIBLE_COINS_TAG = itemTag(MODID, "collectible/coins");
        public static final TagKey<Item> BOSS_COINS_TAG = itemTag(MODID, "collectible/boss");

        public static final TagKey<Item> CELEBRATION_COINS_TAG = itemTag(MODID, "collectible/celebration_coins");
        public static final TagKey<Item> ANNIVERSARY_COINS_TAG = itemTag(MODID, "collectible/celebration/anniversary");
        public static final TagKey<Item> LIFETIME_COINS_TAG = itemTag(MODID, "collectible/celebration/anniversary/lifetime");
        public static final TagKey<Item> PATRON_COINS_TAG = itemTag(MODID, "collectible/celebration/anniversary/patron");
        public static final TagKey<Item> HOLIDAY_COINS_TAG = itemTag(MODID, "collectible/celebration/holiday");
        public static final TagKey<Item> HERO_COINS_TAG = itemTag(MODID, "collectible/celebration/hero");
        // these tags are for subcoin checks in the coin set item class
        public static final TagKey<Item> EASTER_COIN_TAG = itemTag(MODID, "collectible/celebration/holiday/easter");
        public static final TagKey<Item> BIRTHDAY_COIN_TAG = itemTag(MODID, "collectible/celebration/holiday/birthday");
        public static final TagKey<Item> HALLOWEEN_COIN_TAG = itemTag(MODID, "collectible/celebration/holiday/halloween");
        public static final TagKey<Item> CHRISTMAS_COIN_TAG = itemTag(MODID, "collectible/celebration/holiday/christmas");
        public static final TagKey<Item> NEW_YEAR_COIN_TAG = itemTag(MODID, "collectible/celebration/holiday/new_year");

        public static final TagKey<Item> ENTITY_COIN_SETS_TAG = itemTag(MODID, "collectible/entity_coin_sets");

        public static final TagKey<Item> FISH_COINS_TAG = itemTag(MODID, "collectible/fish");
        public static final TagKey<Item> FISH_COINS_COD_TAG = itemTag(MODID, "collectible/fish/cod");
        public static final TagKey<Item> FISH_COINS_SALMON_TAG = itemTag(MODID, "collectible/fish/salmon");
        public static final TagKey<Item> FISH_COINS_PUFFERFISH_TAG = itemTag(MODID, "collectible/fish/pufferfish");
        public static final TagKey<Item> FISH_COINS_TROPICAL_FISH_TAG = itemTag(MODID, "collectible/fish/tropical_fish");

        public static final TagKey<Item> AERIAL_COINS_TAG = itemTag(MODID, "collectible/aerial");
        public static final TagKey<Item> AERIAL_COINS_ALLAY_TAG = itemTag(MODID, "collectible/aerial/allay");
        public static final TagKey<Item> AERIAL_COINS_BAT_TAG = itemTag(MODID, "collectible/aerial/bat");
        public static final TagKey<Item> AERIAL_COINS_DRAGON_TAG = itemTag(MODID, "collectible/aerial/dragon");
        public static final TagKey<Item> AERIAL_COINS_GHAST_TAG = itemTag(MODID, "collectible/aerial/ghast");
        public static final TagKey<Item> AERIAL_COINS_HAPPY_GHAST_TAG = itemTag(MODID, "collectible/aerial/happy_ghast");
        public static final TagKey<Item> AERIAL_COINS_PARROT_TAG = itemTag(MODID, "collectible/aerial/parrot");
        public static final TagKey<Item> AERIAL_COINS_PHANTOM_TAG = itemTag(MODID, "collectible/aerial/phantom");
        public static final TagKey<Item> AERIAL_COINS_GLARE_TAG = itemTag(MODID, "collectible/aerial/glare");
        public static final TagKey<Item> AERIAL_COINS_BEE_TAG = itemTag(MODID, "collectible/aerial/bee");
        public static final TagKey<Item> AERIAL_COINS_BREEZE_TAG = itemTag(MODID, "collectible/aerial/breeze");

        public static final TagKey<Item> AQUATIC_COINS_TAG = itemTag(MODID, "collectible/aquatic");
        public static final TagKey<Item> AQUATIC_COINS_AXOLOTL_TAG = itemTag(MODID, "collectible/aquatic/axolotl");
        public static final TagKey<Item> AQUATIC_COINS_CRAB_TAG = itemTag(MODID, "collectible/aquatic/crab");
        public static final TagKey<Item> AQUATIC_COINS_DOLPHIN_TAG = itemTag(MODID, "collectible/aquatic/dolphin");
        public static final TagKey<Item> AQUATIC_COINS_ELDER_GUARDIAN_TAG = itemTag(MODID, "collectible/aquatic/elder_guardian");
        public static final TagKey<Item> AQUATIC_COINS_FROG_TAG = itemTag(MODID, "collectible/aquatic/frog");
        public static final TagKey<Item> AQUATIC_COINS_GLOW_SQUID_TAG = itemTag(MODID, "collectible/aquatic/squid");
        public static final TagKey<Item> AQUATIC_COINS_GUARDIAN_TAG = itemTag(MODID, "collectible/aquatic/guardian");
        public static final TagKey<Item> AQUATIC_COINS_PENGUIN_TAG = itemTag(MODID, "collectible/aquatic/penguin");
        public static final TagKey<Item> AQUATIC_COINS_SQUID_TAG = itemTag(MODID, "collectible/aquatic/squid");
        public static final TagKey<Item> AQUATIC_COINS_TADPOLE_TAG = itemTag(MODID, "collectible/aquatic/tadpole");
        public static final TagKey<Item> AQUATIC_COINS_TURTLE_TAG = itemTag(MODID, "collectible/aquatic/turtle");

        public static final TagKey<Item> STEED_COINS_TAG = itemTag(MODID,"collectible/steed");
        public static final TagKey<Item> STEED_COINS_HORSE_TAG = itemTag(MODID,"collectible/steed/horse");
        public static final TagKey<Item> STEED_COINS_DONKEY_TAG = itemTag(MODID,"collectible/steed/donkey");
        public static final TagKey<Item> STEED_COINS_MULE_TAG = itemTag(MODID,"collectible/steed/mule");
        public static final TagKey<Item> STEED_COINS_SKELETON_HORSE_TAG = itemTag(MODID,"collectible/steed/skeleton_horse");
        public static final TagKey<Item> STEED_COINS_ZOMBIE_HORSE_TAG = itemTag(MODID,"collectible/steed/zombie_horse");
        public static final TagKey<Item> STEED_COINS_LLAMA_TAG = itemTag(MODID,"collectible/steed/llama");
        public static final TagKey<Item> STEED_COINS_TRADER_LLAMA_TAG = itemTag(MODID,"collectible/steed/trader_llama");
        public static final TagKey<Item> STEED_COINS_CAMEL_TAG = itemTag(MODID,"collectible/steed/camel");
        public static final TagKey<Item> STEED_COINS_STRIDER_TAG = itemTag(MODID,"collectible/steed/strider");

        public static final TagKey<Item> BREEDABLE_COINS_TAG = itemTag(MODID,"collectible/breedable");
        public static final TagKey<Item> BREEDABLE_COINS_ARMADILLO_TAG = itemTag(MODID,"collectible/breedable/armadillo");
        public static final TagKey<Item> BREEDABLE_COINS_CAT_TAG = itemTag(MODID,"collectible/breedable/cat");
        public static final TagKey<Item> BREEDABLE_COINS_CHICKEN_TAG = itemTag(MODID,"collectible/breedable/chicken");
        public static final TagKey<Item> BREEDABLE_COINS_COW_TAG = itemTag(MODID,"collectible/breedable/cow");
        public static final TagKey<Item> BREEDABLE_COINS_FOX_TAG = itemTag(MODID,"collectible/breedable/fox");
        public static final TagKey<Item> BREEDABLE_COINS_GOAT_TAG = itemTag(MODID,"collectible/breedable/goat");
        public static final TagKey<Item> BREEDABLE_COINS_MOOBLOOM_TAG = itemTag(MODID,"collectible/breedable/moobloom");
        public static final TagKey<Item> BREEDABLE_COINS_MOOSHROOM_TAG = itemTag(MODID,"collectible/breedable/mooshroom");
        public static final TagKey<Item> BREEDABLE_COINS_OCELOT_TAG = itemTag(MODID,"collectible/breedable/ocelot");
        public static final TagKey<Item> BREEDABLE_COINS_PANDA_TAG = itemTag(MODID,"collectible/breedable/panda");
        public static final TagKey<Item> BREEDABLE_COINS_PIG_TAG = itemTag(MODID,"collectible/breedable/pig");
        public static final TagKey<Item> BREEDABLE_COINS_RABBIT_TAG = itemTag(MODID,"collectible/breedable/rabbit");
        public static final TagKey<Item> BREEDABLE_COINS_SHEEP_TAG = itemTag(MODID,"collectible/breedable/sheep");
        public static final TagKey<Item> BREEDABLE_COINS_WOLF_TAG = itemTag(MODID,"collectible/breedable/wolf");

        public static final TagKey<Item> WILD_COINS_TAG = itemTag(MODID, "collectible/wild");
        public static final TagKey<Item> WILD_COINS_MAULER_TAG = itemTag(MODID, "collectible/wild/mauler");
        public static final TagKey<Item> WILD_COINS_POLAR_BEAR_TAG = itemTag(MODID, "collectible/wild/polar_bear");
        public static final TagKey<Item> WILD_COINS_SQUIRREL_TAG = itemTag(MODID, "collectible/wild/squirrel");

        public static final TagKey<Item> ARTHROPOD_COINS_TAG = itemTag(MODID,"collectible/arthropod");
        public static final TagKey<Item> ARTHROPOD_COINS_CAVE_SPIDER_TAG = itemTag(MODID,"collectible/arthropod/cave_spider");
        public static final TagKey<Item> ARTHROPOD_COINS_ENDERMITE_TAG = itemTag(MODID,"collectible/arthropod/endermite");
        public static final TagKey<Item> ARTHROPOD_COINS_SILVERFISH_TAG = itemTag(MODID,"collectible/arthropod/silverfish");
        public static final TagKey<Item> ARTHROPOD_COINS_SPIDER_TAG = itemTag(MODID,"collectible/arthropod/spider");

        public static final TagKey<Item> UNDEAD_COINS_TAG = itemTag(MODID, "collectible/undead");
        public static final TagKey<Item> UNDEAD_COINS_DROWNED_TAG = itemTag(MODID, "collectible/undead/drowned");
        public static final TagKey<Item> UNDEAD_COINS_HUSK_TAG = itemTag(MODID, "collectible/undead/husk");
        public static final TagKey<Item> UNDEAD_COINS_SKELETON_TAG = itemTag(MODID, "collectible/undead/skeleton");
        public static final TagKey<Item> UNDEAD_COINS_STRAY_TAG = itemTag(MODID, "collectible/undead/stray");
        public static final TagKey<Item> UNDEAD_COINS_WITHER_TAG = itemTag(MODID, "collectible/undead/wither");
        public static final TagKey<Item> UNDEAD_COINS_WITHER_SKELETON_TAG = itemTag(MODID, "collectible/undead/wither_skeleton");
        public static final TagKey<Item> UNDEAD_COINS_ZOGLIN_TAG = itemTag(MODID, "collectible/undead/zoglin");
        public static final TagKey<Item> UNDEAD_COINS_ZOMBIE_TAG = itemTag(MODID, "collectible/undead/zombie");
        public static final TagKey<Item> UNDEAD_COINS_ZOMBIE_VILLAGER_TAG = itemTag(MODID, "collectible/undead/zombie_villager");
        public static final TagKey<Item> UNDEAD_COINS_ZOMBIFIED_PIGLIN_TAG = itemTag(MODID, "collectible/undead/zombified_piglin");
        public static final TagKey<Item> UNDEAD_COINS_BOGGED_TAG = itemTag(MODID, "collectible/undead/bogged");

        public static final TagKey<Item> PIGLIN_COINS_TAG = itemTag(MODID,"collectible/piglin");
        public static final TagKey<Item> PIGLIN_COINS_PIGLIN_BRUTE_TAG = itemTag(MODID,"collectible/piglin/brute");
        public static final TagKey<Item> PIGLIN_COINS_HOGLIN_TAG = itemTag(MODID,"collectible/piglin/hoglin");
        public static final TagKey<Item> PIGLIN_COINS_PIGLIN_MERCHANT_TAG = itemTag(MODID,"collectible/piglin/merchant");
        public static final TagKey<Item> PIGLIN_COINS_PIGLIN_TAG = itemTag(MODID,"collectible/piglin/piglin");

        public static final TagKey<Item> RAIDER_COINS_TAG = itemTag(MODID,"collectible/raider");
        public static final TagKey<Item> RAIDER_COINS_EVOKER_TAG = itemTag(MODID,"collectible/raider/evoker");
        public static final TagKey<Item> RAIDER_COINS_ICEOLOGER_TAG = itemTag(MODID,"collectible/raider/iceologer");
        public static final TagKey<Item> RAIDER_COINS_ILLUSIONER_TAG = itemTag(MODID,"collectible/raider/illusioner");
        public static final TagKey<Item> RAIDER_COINS_PILLAGER_TAG = itemTag(MODID,"collectible/raider/pillager");
        public static final TagKey<Item> RAIDER_COINS_RAVAGER_TAG = itemTag(MODID,"collectible/raider/ravager");
        public static final TagKey<Item> RAIDER_COINS_VEX_TAG = itemTag(MODID,"collectible/raider/vex");
        public static final TagKey<Item> RAIDER_COINS_VINDICATOR_TAG = itemTag(MODID,"collectible/raider/vindicator");
        public static final TagKey<Item> RAIDER_COINS_WITCH_TAG = itemTag(MODID,"collectible/raider/witch");

        public static final TagKey<Item> GOLEM_COINS_TAG = itemTag(MODID, "collectible/golem");
        public static final TagKey<Item> GOLEM_COINS_COPPER_GOLEM_TAG = itemTag(MODID, "collectible/golem/copper_golem");
        public static final TagKey<Item> GOLEM_COINS_IRON_GOLEM_TAG = itemTag(MODID, "collectible/golem/iron_golem");
        public static final TagKey<Item> GOLEM_COINS_SNOW_GOLEM_TAG = itemTag(MODID, "collectible/golem/snow_golem");
        public static final TagKey<Item> GOLEM_COINS_TUFF_GOLEM_TAG = itemTag(MODID, "collectible/golem/tuff_golem");

        public static final TagKey<Item> SLIME_COINS_TAG = itemTag(MODID,"collectible/slime");
        public static final TagKey<Item> SLIME_COINS_MAGMA_CUBE_TAG = itemTag(MODID,"collectible/slime/magma_cube");
        public static final TagKey<Item> SLIME_COINS_SLIME_TAG = itemTag(MODID,"collectible/slime/slime");

        public static final TagKey<Item> HUMANOID_COINS_TAG = itemTag(MODID, "collectible/humanoid");
        public static final TagKey<Item> HUMANOID_COINS_GUARD_TAG = itemTag(MODID, "collectible/humanoid/guard");
        public static final TagKey<Item> HUMANOID_COINS_NUMISMATIST_TAG = itemTag(MODID, "collectible/humanoid/numismatist");
        public static final TagKey<Item> HUMANOID_COINS_RASCAL_TAG = itemTag(MODID, "collectible/humanoid/rascal");
        public static final TagKey<Item> HUMANOID_COINS_VILLAGER_TAG = itemTag(MODID, "collectible/humanoid/villager");
        public static final TagKey<Item> HUMANOID_COINS_WANDERING_TRADER_TAG = itemTag(MODID, "collectible/humanoid/wandering_trader");

        public static final TagKey<Item> BLAZE_COINS_TAG = itemTag(MODID,"collectible/blaze");
        public static final TagKey<Item> BLAZE_COINS_BLAZE_TAG = itemTag(MODID,"collectible/blaze/blaze");
        public static final TagKey<Item> BLAZE_COINS_WILDFIRE_TAG = itemTag(MODID,"collectible/blaze/wildfire");

        public static final TagKey<Item> MISC_COINS_TAG = itemTag(MODID,"collectible/misc");
        public static final TagKey<Item> MISC_COINS_CREEPER_TAG = itemTag(MODID,"collectible/misc/creeper");
        public static final TagKey<Item> MISC_COINS_ENDERMAN_TAG = itemTag(MODID,"collectible/misc/enderman");
        public static final TagKey<Item> MISC_COINS_GIANT_TAG = itemTag(MODID,"collectible/misc/giant");
        public static final TagKey<Item> MISC_COINS_SHULKER_TAG = itemTag(MODID,"collectible/misc/shulker");
        public static final TagKey<Item> MISC_COINS_WARDEN_TAG = itemTag(MODID,"collectible/misc/warden");
        public static final TagKey<Item> MISC_COINS_SNIFFER_TAG = itemTag(MODID,"collectible/misc/sniffer");
        public static final TagKey<Item> MISC_COINS_CREAKING_TAG = itemTag(MODID,"collectible/misc/creaking");

        private static @NotNull TagKey<Item> itemTag(String modid, String path) {
                return TagKey.create(Registries.ITEM, ResourceLocation.parse(modid + ":" + path));
        }
}