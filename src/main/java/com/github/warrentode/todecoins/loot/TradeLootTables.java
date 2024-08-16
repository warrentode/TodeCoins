package com.github.warrentode.todecoins.loot;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TradeLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    // currency exchange tables
    public static final ResourceLocation SINGLE_LUCKY_COIN_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/single_lucky_coin_value_currency");
    public static final ResourceLocation SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/single_lucky_coin_bag_value_currency");

    public static final ResourceLocation TWENTY_SEVEN_LUCKY_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/twenty_seven_lucky_coin_table");
    public static final ResourceLocation THREE_LUCKY_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/three_lucky_coin_table");
    public static final ResourceLocation ONE_LUCKY_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/one_lucky_coin_table");

    public static final ResourceLocation SEVEN_NETHERITE_COIN_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/seven_netherite_coin_value_currency");

    public static final ResourceLocation SIXTY_POTS_OF_GOLD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/sixty_pot_of_gold_value_currency");
    public static final ResourceLocation THIRTY_POTS_OF_GOLD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/thirty_pot_of_gold_value_currency");
    public static final ResourceLocation FOUR_POTS_OF_GOLD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/four_pot_of_gold_value_currency");
    public static final ResourceLocation TWO_POTS_OF_GOLD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/two_pot_of_gold_value_currency");

    public static final ResourceLocation SIXTY_POTS_OF_GOLD_TABLE = register(MODID + ":" + "trade_tables/currency/sixty_pot_of_gold_table");
    public static final ResourceLocation THIRTY_POTS_OF_GOLD_TABLE = register(MODID + ":" + "trade_tables/currency/thirty_pot_of_gold_table");
    public static final ResourceLocation FOUR_POTS_OF_GOLD_TABLE = register(MODID + ":" + "trade_tables/currency/four_pot_of_gold_table");
    public static final ResourceLocation TWO_POTS_OF_GOLD_TABLE = register(MODID + ":" + "trade_tables/currency/two_pot_of_gold_table");

    public static final ResourceLocation EMERALD_BANK_NOTE_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/emerald_bank_note_value_currency");
    public static final ResourceLocation EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/emerald_quarter_half_note_value_currency");
    public static final ResourceLocation EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/emerald_quarter_bank_note_value_currency");

    public static final ResourceLocation THIRTY_SIX_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/thirty_six_emerald_value_currency");
    public static final ResourceLocation TWENTY_SIX_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/twenty_six_emerald_value_currency");
    public static final ResourceLocation TWENTY_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/twenty_emerald_value_currency");
    public static final ResourceLocation FOURTEEN_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/fourteen_emerald_value_currency");
    public static final ResourceLocation TEN_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/ten_emerald_value_currency");
    public static final ResourceLocation NINE_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/nine_emerald_value_currency");
    public static final ResourceLocation EIGHT_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/eight_emerald_value_currency");
    public static final ResourceLocation SEVEN_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/seven_emerald_value_currency");
    public static final ResourceLocation SIX_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/six_emerald_value_currency");
    public static final ResourceLocation FIVE_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/five_emerald_value_currency");
    public static final ResourceLocation FOUR_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/four_emerald_value_currency");
    public static final ResourceLocation THREE_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/three_emerald_value_currency");
    public static final ResourceLocation TWO_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/two_emerald_value_currency");
    public static final ResourceLocation SINGLE_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/single_emerald_value_currency");
    public static final ResourceLocation SMALLEST_COIN = register(MODID + ":" + "trade_tables/currency/smallest_coin");

    public static final ResourceLocation SIXTY_FOUR_EMERALD_TABLE = register(MODID + ":" + "trade_tables/currency/sixty_four_emerald_table");
    public static final ResourceLocation THIRTY_TWO_EMERALD_TABLE = register(MODID + ":" + "trade_tables/currency/thirty_two_emerald_table");
    public static final ResourceLocation SIXTEEN_EMERALD_TABLE = register(MODID + ":" + "trade_tables/currency/sixteen_emerald_table");
    public static final ResourceLocation ONE_EMERALD_TABLE = register(MODID + ":" + "trade_tables/currency/one_emerald_table");

    // nether dimension currency
    public static final ResourceLocation THREE_NETHER_GOLD_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/three_nether_gold_coin_table");
    public static final ResourceLocation NINE_NETHER_GOLD_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/nine_nether_gold_coin_table");
    public static final ResourceLocation EIGHTEEN_NETHERITE_COIN_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/eighteen_netherite_coin_value_currency");
    public static final ResourceLocation THIRTY_NETHER_GOLD_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/thirty_nether_gold_coin_table");
    public static final ResourceLocation FORTY_TWO_NETHER_GOLD_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/forty_two_nether_gold_coin_table");

    // end dimension currency
    public static final ResourceLocation ENDONIAN_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/endonian_coin_table");
    public static final ResourceLocation FIVE_ENDONIAN_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/five_endonian_coin_table");
    public static final ResourceLocation FOURTEEN_ENDONIAN_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/fourteen_endonian_coin_table");
    public static final ResourceLocation THIRTY_TWO_ENDONIAN_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/thirty_two_endonian_coin_table");
    public static final ResourceLocation FIFTY_ENDONIAN_COIN_TABLE = register(MODID + ":" + "trade_tables/currency/fifty_endonian_coin_table");

    // gems
    public static final ResourceLocation SINGLE_LUCKY_COIN_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/single_lucky_coin_value_gems");
    public static final ResourceLocation EMERALD_BANK_NOTE_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/emerald_bank_note_value_gems");
    public static final ResourceLocation SIXTY_POT_OF_GOLD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/sixty_pot_of_gold_value_gems");
    public static final ResourceLocation THIRTY_POT_OF_GOLD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/thirty_pot_of_gold_value_gems");
    public static final ResourceLocation FOUR_POT_OF_GOLD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/four_pot_of_gold_value_gems");
    public static final ResourceLocation TWO_POT_OF_GOLD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/two_pot_of_gold_value_gems");
    public static final ResourceLocation FIVE_EMERALD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/five_emerald_value_gems");
    public static final ResourceLocation SINGLE_EMERALD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/single_emerald_value_gems");
    public static final ResourceLocation ENCHANTING_GEMS_TABLE = register(MODID + ":" + "trade_tables/gems/enchanting_gems_table");
    public static final ResourceLocation EQUIPMENT_GEMS_TABLE = register(MODID + ":" + "trade_tables/gems/equipment_gems_table");
    public static final ResourceLocation PRISMARINE_SHARD_TABLE = register(MODID + ":" + "trade_tables/gems/prismarine_shard_table");

    // metals
    public static final ResourceLocation EMERALD_BANK_NOTE_VALUE_METALS = register(MODID + ":" + "trade_tables/metals/emerald_bank_note_value_metals");
    public static final ResourceLocation SINGLE_EMERALD_VALUE_METALS = register(MODID + ":" + "trade_tables/metals/single_emerald_value_metals");
    public static final ResourceLocation SINGLE_EMERALD_VALUE_GOLD = register(MODID + ":" + "trade_tables/metals/single_emerald_value_gold");
    public static final ResourceLocation THREE_EMERALD_VALUE_GOLD = register(MODID + ":" + "trade_tables/metals/three_emerald_value_gold");

    // food
    public static final ResourceLocation TAGGED_RAW_MEATS_TABLE = register(MODID + ":" + "trade_tables/food/tagged_raw_meats_table");
    public static final ResourceLocation TAGGED_MEAT_SOUPS_TABLE = register(MODID + ":" + "trade_tables/food/tagged_meat_soups_table");
    public static final ResourceLocation TAGGED_COOKED_MEATS_TABLE = register(MODID + ":" + "trade_tables/food/tagged_cooked_meats_table");
    public static final ResourceLocation TAGGED_SALTS_TABLE = register(MODID + ":" + "trade_tables/food/tagged_salts_table");
    public static final ResourceLocation TAGGED_VEGGIES_AND_GRAINS_TABLE = register(MODID + ":" + "trade_tables/food/tagged_veggies_and_grains_table");
    public static final ResourceLocation TAGGED_BREADS_TABLE = register(MODID + ":" + "trade_tables/food/tagged_crops_table");
    public static final ResourceLocation TAGGED_GOURDS_TABLE = register(MODID + ":" + "trade_tables/food/tagged_gourds_table");
    public static final ResourceLocation TAGGED_PIES_TABLE = register(MODID + ":" + "trade_tables/food/tagged_pies_table");
    public static final ResourceLocation TAGGED_FRUITS_TABLE = register(MODID + ":" + "trade_tables/food/tagged_fruits_table");
    public static final ResourceLocation TAGGED_COOKIES_TABLE = register(MODID + ":" + "trade_tables/food/tagged_cookies_table");
    public static final ResourceLocation TAGGED_CAKES_TABLE = register(MODID + ":" + "trade_tables/food/tagged_cakes_table");
    public static final ResourceLocation TAGGED_PREPARED_SEAFOOD_TABLE = register(MODID + ":" + "trade_tables/food/tagged_prepared_seafood_table");
    public static final ResourceLocation TAGGED_RAW_SEAFOOD_TABLE = register(MODID + ":" + "trade_tables/food/tagged_raw_seafood_table");
    public static final ResourceLocation TAGGED_FOX_FOOD_TABLE = register(MODID + ":" + "trade_tables/food/tagged_fox_food_table");
    public static final ResourceLocation GOLDEN_FOOD_TABLE = register(MODID + ":" + "trade_tables/food/golden_food_table");
    public static final ResourceLocation BOTTLED_HONEY_TABLE = register(MODID + ":" + "trade_tables/food/bottled_honey_table");
    public static final ResourceLocation SEED_TAG_TABLE = register(MODID + ":" + "trade_tables/food/seed_tag_table");
    public static final ResourceLocation INGREDIENTS_TAG_TABLE = register(MODID + ":" + "trade_tables/food/ingredients_tag_table");
    public static final ResourceLocation FEAST_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/food/feast_blocks_table");
    public static final ResourceLocation SANDWICH_TAG_TABLE = register(MODID + ":" + "trade_tables/food/sandwich_tag_table");
    public static final ResourceLocation SIDE_DISH_TAG_TABLE = register(MODID + ":" + "trade_tables/food/side_dish_tag_table");
    public static final ResourceLocation SOUP_TAG_TABLE = register(MODID + ":" + "trade_tables/food/soup_tag_table");
    public static final ResourceLocation PLATED_FOODS_TAG_TABLE = register(MODID + ":" + "trade_tables/food/plated_foods_tag_table");
    public static final ResourceLocation DESSERT_TAG_TABLE = register(MODID + ":" + "trade_tables/food/dessert_tag_table");
    public static final ResourceLocation DRINKS_TAG_TABLE = register(MODID + ":" + "trade_tables/food/drinks_tag_table");
    public static final ResourceLocation COFFEE_INGREDIENTS_TAG_TABLE = register(MODID + ":" + "trade_tables/food/coffee_ingredients_tag_table");
    public static final ResourceLocation PET_FOOD_TAG_TABLE = register(MODID + ":" + "trade_tables/food/pet_food_tag_table");

    // textiles
    public static final ResourceLocation TAGGED_WOOL_TABLE = register(MODID + ":" + "trade_tables/textiles/tagged_wool_table");
    public static final ResourceLocation TAGGED_LEATHER_TABLE = register(MODID + ":" + "trade_tables/textiles/tagged_leather_table");
    public static final ResourceLocation TAGGED_STRING_TABLE = register(MODID + ":" + "trade_tables/textiles/tagged_string_table");
    public static final ResourceLocation TAGGED_DYES_TABLE = register(MODID + ":" + "trade_tables/textiles/tagged_dyes_table");
    public static final ResourceLocation FEATHER_TABLE = register(MODID + ":" + "trade_tables/textiles/feather_table");

    // glass
    public static final ResourceLocation TAGGED_GLASS_PANES_TABLE = register(MODID + ":" + "trade_tables/glass/tagged_glass_panes_table");
    public static final ResourceLocation TAGGED_GLASS_TABLE = register(MODID + ":" + "trade_tables/glass/tagged_glass_table");
    public static final ResourceLocation GLASS_BOTTLE_TABLE = register(MODID + ":" + "trade_tables/glass/glass_bottle_table");
    public static final ResourceLocation RECYCLABLE_GLASS_TAG_TABLE = register(MODID + ":" + "trade_tables/glass/recyclable_glass_tag_table");

    // decor
    public static final ResourceLocation TAGGED_BANNER_TABLE = register(MODID + ":" + "trade_tables/decor/tagged_banner_table");
    public static final ResourceLocation TAGGED_WOOL_CARPETS_TABLE = register(MODID + ":" + "trade_tables/decor/tagged_wool_carpets_table");
    public static final ResourceLocation TAGGED_BEDS_TABLE = register(MODID + ":" + "trade_tables/decor/tagged_beds_table");
    public static final ResourceLocation PAINTINGS_TABLE = register(MODID + ":" + "trade_tables/decor/paintings_table");
    public static final ResourceLocation TAGGED_CANDLE_TABLE = register(MODID + ":" + "trade_tables/decor/tagged_candle_table");
    public static final ResourceLocation LANTERN_TABLE = register(MODID + ":" + "trade_tables/decor/lantern_table");
    public static final ResourceLocation TORCH_TABLE = register(MODID + ":" + "trade_tables/decor/torch_table");
    public static final ResourceLocation CAMPFIRE_TABLE = register(MODID + ":" + "trade_tables/decor/campfire_table");
    public static final ResourceLocation SOUL_LIGHTS_TABLE = register(MODID + ":" + "trade_tables/decor/soul_lights_table");
    public static final ResourceLocation ITEM_FRAME_TABLE = register(MODID + ":" + "trade_tables/decor/item_frame_table");
    public static final ResourceLocation FLOWER_BUY_TABLE = register(MODID + ":" + "trade_tables/decor/flower_buy_table");
    public static final ResourceLocation FLOWER_SELL_TABLE = register(MODID + ":" + "trade_tables/decor/flower_sell_table");
    public static final ResourceLocation SAPLING_SELL_TABLE = register(MODID + ":" + "trade_tables/decor/sapling_sell_table");
    public static final ResourceLocation SAPLING_BUY_TABLE = register(MODID + ":" + "trade_tables/decor/sapling_buy_table");
    public static final ResourceLocation FLOWER_POT_TABLE = register(MODID + ":" + "trade_tables/decor/flower_pot_table");
    public static final ResourceLocation DECOR_PLANTS_TABLE = register(MODID + ":" + "trade_tables/decor/decor_plants_table");
    public static final ResourceLocation TRELLIS_TAG_TABLE = register(MODID + ":" + "trade_tables/decor/trellis_tag_table");
    public static final ResourceLocation FRAMES_TABLE = register(MODID + ":" + "trade_tables/decor/frames_table");

    // beekeeping
    public static final ResourceLocation BEEHIVE_TABLE = register(MODID + ":" + "trade_tables/beekeeping/beehive_table");
    public static final ResourceLocation BEE_EGG_TABLE = register(MODID + ":" + "trade_tables/beekeeping/bee_egg_table");
    public static final ResourceLocation HONEY_BLOCK_TABLE = register(MODID + ":" + "trade_tables/beekeeping/honey_block_table");
    public static final ResourceLocation HONEY_COMB_TABLE = register(MODID + ":" + "trade_tables/beekeeping/honey_comb_table");

    // mob parts
    public static final ResourceLocation ONE_EMERALD_VALUE_MOB_PARTS_TABLE = register(MODID + ":" + "trade_tables/mob_parts/one_emerald_value_mob_parts_table");
    public static final ResourceLocation FIVE_EMERALD_VALUE_MOB_PARTS_TABLE = register(MODID + ":" + "trade_tables/mob_parts/five_emerald_value_mob_parts_table");
    public static final ResourceLocation TEN_EMERALD_VALUE_MOB_PARTS_TABLE = register(MODID + ":" + "trade_tables/mob_parts/ten_emerald_value_mob_parts_table");
    public static final ResourceLocation SCUTE_TABLE = register(MODID + ":" + "trade_tables/mob_parts/scute_table");
    public static final ResourceLocation SLIMEBALL_TAG_TABLE = register(MODID + ":" + "trade_tables/mob_parts/slimeball_tag_table");

    // brewing
    public static final ResourceLocation POTION_INGREDIENTS_TABLE = register(MODID + ":" + "trade_tables/brewing/potion_ingredients_table");
    public static final ResourceLocation EXPERIENCE_BOTTLE_TABLE = register(MODID + ":" + "trade_tables/brewing/experience_bottle_table");
    public static final ResourceLocation GHAST_TEAR_TABLE = register(MODID + ":" + "trade_tables/brewing/ghast_tear_table");
    public static final ResourceLocation NETHER_WART_TABLE = register(MODID + ":" + "trade_tables/brewing/nether_wart_table");

    // music
    public static final ResourceLocation DISC_FRAGMENTS_TABLE = register(MODID + ":" + "trade_tables/music/disc_fragments_table");
    public static final ResourceLocation MUSIC_DISC_TAG_TABLE = register(MODID + ":" + "trade_tables/music/music_disc_tag_table");

    // library
    public static final ResourceLocation BOOKSHELF_TABLE = register(MODID + ":" + "trade_tables/library/bookshelf_table");
    public static final ResourceLocation GUIDE_BOOKS_TABLE = register(MODID + ":" + "trade_tables/library/guide_books");
    public static final ResourceLocation PAPER_TABLE = register(MODID + ":" + "trade_tables/library/paper_table");
    public static final ResourceLocation BOOK_TABLE = register(MODID + ":" + "trade_tables/library/book_table");
    public static final ResourceLocation TAGGED_INK_TABLE = register(MODID + ":" + "trade_tables/library/tagged_ink_table");
    public static final ResourceLocation REFRESH_BOOK_TABLE = register(MODID + ":" + "trade_tables/library/refresh_book_table");

    // blocks
    public static final ResourceLocation OCEAN_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/blocks/ocean_blocks_table");
    public static final ResourceLocation SEA_LANTERN_TABLE = register(MODID + ":" + "trade_tables/blocks/sea_lantern_table");
    public static final ResourceLocation GRAVEL_TABLE = register(MODID + ":" + "trade_tables/blocks/gravel_table");
    public static final ResourceLocation SAND_TAG_TABLE = register(MODID + ":" + "trade_tables/blocks/sand_tag_table");
    public static final ResourceLocation CORAL_BLOCK_TAG_TABLE = register(MODID + ":" + "trade_tables/blocks/coral_block_tag_table");
    public static final ResourceLocation SPECIAL_DIRT_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/blocks/special_dirt_blocks_table");
    public static final ResourceLocation ICE_TABLE = register(MODID + ":" + "trade_tables/blocks/ice_table");
    public static final ResourceLocation OVERWORLD_BRICK_TABLE = register(MODID + ":" + "trade_tables/blocks/stone/overworld_brick");
    public static final ResourceLocation OVERWORLD_STONE_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/blocks/stone/overworld_stone_blocks");
    public static final ResourceLocation OVERWORLD_BRICK_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/blocks/stone/overworld_brick_blocks");
    public static final ResourceLocation OVERWORLD_POLISHED_STONE_TABLE = register(MODID + ":" + "trade_tables/blocks/stone/overworld_polished_stone_blocks");
    public static final ResourceLocation OVERWORLD_OTHER_STONE_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/blocks/stone/overworld_other_stone_blocks");
    public static final ResourceLocation TERRACOTTA_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/blocks/terracotta/terracotta_blocks");
    public static final ResourceLocation GLAZED_TERRACOTTA_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/blocks/terracotta/glazed_terracotta_blocks");
    public static final ResourceLocation NETHER_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/blocks/nether_blocks_table");
    public static final ResourceLocation LOGS_BUY_TABLE = register(MODID + ":" + "trade_tables/blocks/logs_buy_table");
    public static final ResourceLocation LOGS_SELL_TABLE = register(MODID + ":" + "trade_tables/blocks/logs_sell_table");
    public static final ResourceLocation END_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/blocks/end_blocks_table");

    // tools
    public static final ResourceLocation TRIPWIRE_HOOK_TABLE = register(MODID + ":" + "trade_tables/tools/tripwire_hook_table");
    public static final ResourceLocation FISH_BUCKET_TABLE = register(MODID + ":" + "trade_tables/tools/fish_bucket_table");
    public static final ResourceLocation FISHING_ROD_TABLE = register(MODID + ":" + "trade_tables/tools/fishing_rod_table");
    public static final ResourceLocation GLASSBLOWING_TOOLS_TAG_TABLE = register(MODID + ":" + "trade_tables/tools/glassblowing_tools_tag_table");
    public static final ResourceLocation STONE_TIER_KNIVES = register(MODID + ":" + "trade_tables/tools/stone_tier_knives_table");
    public static final ResourceLocation STONE_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/stone_tier_tools");
    public static final ResourceLocation IRON_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/iron_tier_tools");
    public static final ResourceLocation SHEARS_TABLE = register(MODID + ":" + "trade_tables/tools/shears_table");
    public static final ResourceLocation GOLD_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/gold_tier_tools");
    public static final ResourceLocation DIAMOND_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/diamond_tier_tools");
    public static final ResourceLocation NETHERITE_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/netherite_tier_tools");
    public static final ResourceLocation CLOCK_TABLE = register(MODID + ":" + "trade_tables/tools/clock_table");
    public static final ResourceLocation COMPASS_TABLE = register(MODID + ":" + "trade_tables/tools/compass_table");
    public static final ResourceLocation IRON_TIER_LUMBER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/iron_tier_lumber_tools_table");
    public static final ResourceLocation DIAMOND_TIER_LUMBER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/diamond_tier_lumber_tools_table");

    // weapons
    public static final ResourceLocation IRON_TIER_WEAPONS_TABLE = register(MODID + ":" + "trade_tables/weapons/iron_tier_weapons");
    public static final ResourceLocation GOLD_TIER_WEAPONS_TABLE = register(MODID + ":" + "trade_tables/weapons/gold_tier_weapons");
    public static final ResourceLocation DIAMOND_TIER_WEAPONS_TABLE = register(MODID + ":" + "trade_tables/weapons/diamond_tier_weapons");
    public static final ResourceLocation NETHERITE_TIER_WEAPONS_TABLE = register(MODID + ":" + "trade_tables/weapons/netherite_tier_weapons");
    public static final ResourceLocation BOWS_TABLE = register(MODID + ":" + "trade_tables/weapons/bows");
    public static final ResourceLocation TAGGED_QUIVERS_TABLE = register(MODID + ":" + "trade_tables/weapons/quivers");
    public static final ResourceLocation TRIDENT_TABLE = register(MODID + ":" + "trade_tables/weapons/trident");

    // horse gear
    public static final ResourceLocation SADDLE_TABLE = register(MODID + ":" + "trade_tables/horse_gear/saddle_table");
    public static final ResourceLocation LEATHER_TIER_HORSE_ARMOR_TABLE = register(MODID + ":" + "trade_tables/horse_gear/leather_tier_horse_armor");
    public static final ResourceLocation GOLD_TIER_HORSE_ARMOR_TABLE = register(MODID + ":" + "trade_tables/horse_gear/gold_tier_horse_armor");
    public static final ResourceLocation IRON_TIER_HORSE_ARMOR_TABLE = register(MODID + ":" + "trade_tables/horse_gear/iron_tier_horse_armor");
    public static final ResourceLocation DIAMOND_TIER_HORSE_ARMOR_TABLE = register(MODID + ":" + "trade_tables/horse_gear/diamond_tier_horse_armor");

    // armor
    public static final ResourceLocation SHIELD_TABLE = register(MODID + ":" + "trade_tables/armor/shield_table");

    public static final ResourceLocation LEATHER_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/helmets/leather_tier_helmets");
    public static final ResourceLocation CHAINMAIL_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/helmets/chainmail_tier_helmets");
    public static final ResourceLocation IRON_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/helmets/iron_tier_helmets");
    public static final ResourceLocation GOLD_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/helmets/gold_tier_helmets");
    public static final ResourceLocation DIAMOND_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/helmets/diamond_tier_helmets");
    public static final ResourceLocation NETHERITE_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/helmets/netherite_tier_helmets");

    public static final ResourceLocation LEATHER_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/chestplate/leather_tier_chestplates");
    public static final ResourceLocation CHAINMAIL_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/chestplate/chainmail_tier_chestplates");
    public static final ResourceLocation IRON_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/chestplate/iron_tier_chestplates");
    public static final ResourceLocation GOLD_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/chestplate/gold_tier_chestplates");
    public static final ResourceLocation DIAMOND_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/chestplate/diamond_tier_chestplates");
    public static final ResourceLocation NETHERITE_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/chestplate/netherite_tier_chestplates");

    public static final ResourceLocation LEATHER_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/leggings/leather_tier_leggings");
    public static final ResourceLocation CHAINMAIL_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/leggings/chainmail_tier_leggings");
    public static final ResourceLocation IRON_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/leggings/iron_tier_leggings");
    public static final ResourceLocation GOLD_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/leggings/gold_tier_leggings");
    public static final ResourceLocation DIAMOND_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/leggings/diamond_tier_leggings");
    public static final ResourceLocation NETHERITE_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/leggings/netherite_tier_leggings");

    public static final ResourceLocation LEATHER_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/boots/leather_tier_boots");
    public static final ResourceLocation CHAINMAIL_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/boots/chainmail_tier_boots");
    public static final ResourceLocation IRON_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/boots/iron_tier_boots");
    public static final ResourceLocation GOLD_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/boots/gold_tier_boots");
    public static final ResourceLocation DIAMOND_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/boots/diamond_tier_boots");
    public static final ResourceLocation NETHERITE_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/boots/netherite_tier_boots");

    public static final ResourceLocation DYEABLE_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/boots/dyeable");
    public static final ResourceLocation DYEABLE_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/leggings/dyeable");
    public static final ResourceLocation DYEABLE_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/chestplates/dyeable");
    public static final ResourceLocation DYEABLE_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/helmets/dyeable");

    // misc item tables
    public static final ResourceLocation TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS = register(MODID + ":" + "trade_tables/misc/twenty_seven_lucky_coin_value_items");
    public static final ResourceLocation THREE_LUCKY_COIN_VALUE_ITEMS = register(MODID + ":" + "trade_tables/misc/single_lucky_coin_value_items");
    public static final ResourceLocation SIXTY_POT_OF_GOLD_VALUE_ITEMS = register(MODID + ":" + "trade_tables/misc/sixty_pot_of_gold_value_items");
    public static final ResourceLocation THIRTY_POT_OF_GOLD_VALUE_ITEMS = register(MODID + ":" + "trade_tables/misc/thirty_pot_of_gold_value_items");
    public static final ResourceLocation FOUR_POT_OF_GOLD_VALUE_ITEMS = register(MODID + ":" + "trade_tables/misc/four_pot_of_gold_value_items");
    public static final ResourceLocation TWO_POT_OF_GOLD_VALUE_ITEMS = register(MODID + ":" + "trade_tables/misc/two_pot_of_gold_value_items");
    public static final ResourceLocation BLANK_MAP_TABLE = register(MODID + ":" + "trade_tables/misc/blank_map_table");
    public static final ResourceLocation SEASHELL_TABLE = register(MODID + ":" + "trade_tables/misc/seashell_table");
    public static final ResourceLocation FISHING_GEAR_TABLE = register(MODID + ":" + "trade_tables/misc/fishing_gear_table");
    public static final ResourceLocation ONE_EMERALD_VALUE_FUEL = register(MODID + ":" + "trade_tables/misc/one_emerald_value_fuel_table");
    public static final ResourceLocation TAGGED_ASH_TABLE = register(MODID + ":" + "trade_tables/misc/tagged_ash_table");
    public static final ResourceLocation TAGGED_STICK_TABLE = register(MODID + ":" + "trade_tables/misc/tagged_stick_table");
    public static final ResourceLocation BELL_TABLE = register(MODID + ":" + "trade_tables/misc/bell_table");
    public static final ResourceLocation FLINT_BUY_TABLE = register(MODID + ":" + "trade_tables/misc/flint_buy_table");
    public static final ResourceLocation FLINT_SELL_TABLE = register(MODID + ":" + "trade_tables/misc/flint_sell_table");
    public static final ResourceLocation ANVIL_TABLE = register(MODID + ":" + "trade_tables/misc/anvil_table");
    public static final ResourceLocation CLAY_TABLE = register(MODID + ":" + "trade_tables/misc/clay_table");
    public static final ResourceLocation BANNER_PATTERN_TABLE = register(MODID + ":" + "trade_tables/misc/banner_pattern_table");
    public static final ResourceLocation HEART_OF_THE_SEA_TABLE = register(MODID + ":" + "trade_tables/misc/heart_of_the_sea_table");
    public static final ResourceLocation NETHER_STAR_TABLE = register(MODID + ":" + "trade_tables/misc/nether_star_table");
    public static final ResourceLocation END_ROD_TABLE = register(MODID + ":" + "trade_tables/misc/end_rod_table");
    public static final ResourceLocation ENDER_PEARL_TABLE = register(MODID + ":" + "trade_tables/misc/ender_pearl_table");
    public static final ResourceLocation FIREWORK_ROCKET_TABLE = register(MODID + ":" + "trade_tables/misc/firework_rocket_table");
    public static final ResourceLocation DRAGON_BREATH_TABLE = register(MODID + ":" + "trade_tables/misc/dragon_breath_table");
    public static final ResourceLocation SHULKER_SHELL_TABLE = register(MODID + ":" + "trade_tables/misc/shulker_shell_table");
    public static final ResourceLocation DRAGON_HEAD_TABLE = register(MODID + ":" + "trade_tables/misc/dragon_head_table");
    public static final ResourceLocation NINE_EMERALD_VALUE_REDSTONE = register(MODID + ":" + "trade_tables/misc/nine_emerald_value_redstone");
    public static final ResourceLocation REDSTONE_TORCH_TABLE = register(MODID + ":" + "trade_tables/misc/redstone_torch_table");
    public static final ResourceLocation REDSTONE_COMPONENTS_TABLE = register(MODID + ":" + "trade_tables/misc/redstone_components_table");
    public static final ResourceLocation BONE_MEAL_TABLE = register(MODID + ":" + "trade_tables/misc/bone_meal_table");
    public static final ResourceLocation NAME_TAG_TABLE = register(MODID + ":" + "trade_tables/misc/name_tag_table");
    public static final ResourceLocation TAILOR_TOOLS_TABLE = register(MODID + ":" + "trade_tables/misc/tailor_tools_table");
    public static final ResourceLocation PATTERNS_TAG_TABLE = register(MODID + ":" + "trade_tables/misc/patterns_tag_table");
    public static final ResourceLocation TEXTILES_TAG_TABLE = register(MODID + ":" + "trade_tables/misc/textiles_tag_table");
    public static final ResourceLocation COOKING_TOOLS_TABLE = register(MODID + ":" + "trade_tables/misc/cooking_tools_table");
    public static final ResourceLocation CUPS_TAG_TABLE = register(MODID + ":" + "trade_tables/misc/cups_tag_table");
    public static final ResourceLocation PET_SUPPLIES_TAG_TABLE = register(MODID + ":" + "trade_tables/misc/pet_supplies_tag_table");
    public static final ResourceLocation ENCHANTABLE_PET_GEAR_TAG_TABLE = register(MODID + ":" + "trade_tables/misc/enchantable_pet_gear_tag_table");

    // numismatist merchant specific offers loot tables
    public static final ResourceLocation NUMISMATIST_RARE_OFFERS =
            register(MODID + ":" + "trade_tables/numismatist/rare_offers");
    public static final ResourceLocation NUMISMATIST_CONTAINER_OFFERS =
            register(MODID + ":" + "trade_tables/numismatist/container_offers");

    // wandering trader specific offers loot tables
    public static final ResourceLocation WANDERING_TRADER_COMMON_OFFERS =
            register(MODID + ":" + "trade_tables/wandering_trader/common_offers");
    public static final ResourceLocation WANDERING_TRADER_RARE_OFFERS =
            register(MODID + ":" + "trade_tables/wandering_trader/rare_offers");

    private static ResourceLocation register(String path) {
        return register(new ResourceLocation(path));
    }

    private static ResourceLocation register(ResourceLocation path) {
        if (LOCATIONS.add(path)) {
            return path;
        }
        else {
            throw new IllegalArgumentException(path + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}