package com.github.warrentode.todecoins.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModTags {
    public static class Blocks {
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

        public static final TagKey<Item> CURRENCY = modItemTag("currency");
        public static final TagKey<Item> BANKNOTES = modItemTag("currency/banknotes");
        public static final TagKey<Item> COINS = modItemTag("currency/coins");

        public static final TagKey<Item> CURRENCY_MATERIALS = modItemTag("currency_materials");
        public static final TagKey<Item> CURRENCY_STAMPS = modItemTag("currency_stamps");

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
    }

    private static @NotNull TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(MODID, path));
    }

    private static @NotNull TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, path));
    }

    private static @NotNull TagKey<Item> modItemTag(String modid, String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(modid, path));
    }
}