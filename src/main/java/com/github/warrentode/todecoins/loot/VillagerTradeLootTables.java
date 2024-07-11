package com.github.warrentode.todecoins.loot;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class VillagerTradeLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    // currency exchange tables
    public static final ResourceLocation SINGLE_LUCKY_COIN_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/single_lucky_coin_value_currency");

    public static final ResourceLocation SIXTY_POTS_OF_GOLD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/sixty_pot_of_gold_value_currency");
    public static final ResourceLocation THIRTY_POTS_OF_GOLD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/thirty_pot_of_gold_value_currency");
    public static final ResourceLocation FOUR_POTS_OF_GOLD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/four_pot_of_gold_value_currency");
    public static final ResourceLocation TWO_POTS_OF_GOLD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/two_pot_of_gold_value_currency");

    public static final ResourceLocation EMERALD_BANK_NOTE_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/emerald_bank_note_value_currency");
    public static final ResourceLocation EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/emerald_quarter_half_note_value_currency");
    public static final ResourceLocation EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/emerald_quarter_bank_note_value_currency");

    public static final ResourceLocation THIRTY_SIX_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/thirty_six_emerald_value_currency");
    public static final ResourceLocation TWENTY_SIX_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/twenty_six_emerald_value_currency");
    public static final ResourceLocation TWENTY_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/twenty_emerald_value_currency");
    public static final ResourceLocation FOURTEEN_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/fourteen_emerald_value_currency");
    public static final ResourceLocation NINE_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/nine_emerald_value_currency");
    public static final ResourceLocation EIGHT_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/eight_emerald_value_currency");
    public static final ResourceLocation SEVEN_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/seven_emerald_value_currency");
    public static final ResourceLocation SIX_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/six_emerald_value_currency");
    public static final ResourceLocation FIVE_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/five_emerald_value_currency");
    public static final ResourceLocation FOUR_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/four_emerald_value_currency");
    public static final ResourceLocation THREE_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/three_emerald_value_currency");
    public static final ResourceLocation TWO_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/two_emerald_value_currency");
    public static final ResourceLocation SINGLE_EMERALD_VALUE_CURRENCY = register(MODID + ":" + "trade_tables/currency/single_emerald_value_currency");

    // set value item tables
    public static final ResourceLocation TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS = register(MODID + ":" + "trade_tables/assorted_items/twenty_seven_lucky_coin_value_items");
    public static final ResourceLocation THREE_LUCKY_COIN_VALUE_ITEMS = register(MODID + ":" + "trade_tables/assorted_items/single_lucky_coin_value_items");
    public static final ResourceLocation SIXTY_POTS_OF_GOLD_VALUE_ITEMS = register(MODID + ":" + "trade_tables/assorted_items/sixty_pot_of_gold_value_items");
    public static final ResourceLocation THIRTY_POTS_OF_GOLD_VALUE_ITEMS = register(MODID + ":" + "trade_tables/assorted_items/thirty_pot_of_gold_value_items");
    public static final ResourceLocation FOUR_POT_OF_GOLD_VALUE_ITEMS = register(MODID + ":" + "trade_tables/assorted_items/four_pot_of_gold_value_items");
    public static final ResourceLocation TWO_POT_OF_GOLD_VALUE_ITEMS = register(MODID + ":" + "trade_tables/assorted_items/two_pot_of_gold_value_items");

    // metals
    public static final ResourceLocation EMERALD_BANK_NOTE_VALUE_METALS = register(MODID + ":" + "trade_tables/metals/emerald_bank_note_value_metals");
    public static final ResourceLocation SINGLE_EMERALD_VALUE_METALS = register(MODID + ":" + "trade_tables/metals/single_emerald_value_metals");

    // gems
    public static final ResourceLocation SINGLE_LUCKY_COIN_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/single_lucky_coin_value_gems");
    public static final ResourceLocation EMERALD_BANK_NOTE_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/emerald_bank_note_value_gems");
    public static final ResourceLocation SIXTY_POTS_OF_GOLD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/sixty_pot_of_gold_value_gems");
    public static final ResourceLocation THIRTY_POTS_OF_GOLD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/thirty_pot_of_gold_value_gems");
    public static final ResourceLocation FOUR_POT_OF_GOLD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/four_pot_of_gold_value_gems");
    public static final ResourceLocation TWO_POT_OF_GOLD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/two_pot_of_gold_value_gems");
    public static final ResourceLocation FIVE_EMERALD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/five_emerald_value_gems");
    public static final ResourceLocation SINGLE_EMERALD_VALUE_GEMS = register(MODID + ":" + "trade_tables/gems/single_emerald_value_gems");

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

    // glass
    public static final ResourceLocation TAGGED_GLASS_PANES_TABLE = register(MODID + ":" + "trade_tables/glass/tagged_glass_panes_table");
    public static final ResourceLocation TAGGED_GLASS_TABLE = register(MODID + ":" + "trade_tables/glass/tagged_glass_table");

    // wool
    public static final ResourceLocation TAGGED_BANNER_TABLE = register(MODID + ":" + "trade_tables/wool/tagged_banner_table");
    public static final ResourceLocation TAGGED_WOOL_TABLE = register(MODID + ":" + "trade_tables/wool/tagged_wool_table");
    public static final ResourceLocation TAGGED_WOOL_CARPETS_TABLE = register(MODID + ":" + "trade_tables/wool/tagged_wool_carpets_table");
    public static final ResourceLocation TAGGED_BEDS_TABLE = register(MODID + ":" + "trade_tables/wool/tagged_beds_table");

    // assorted items
    public static final ResourceLocation FISHING_GEAR_TABLE = register(MODID + ":" + "trade_tables/assorted_items/fishing_gear_table");
    public static final ResourceLocation LANTERN_TABLE = register(MODID + ":" + "trade_tables/assorted_items/lantern_table");
    public static final ResourceLocation PAINTINGS_TABLE = register(MODID + ":" + "trade_tables/assorted_items/paintings_table");
    public static final ResourceLocation TAGGED_ASH_TABLE = register(MODID + ":" + "trade_tables/assorted_items/tagged_ash_table");
    public static final ResourceLocation TAGGED_LEATHER_TABLE = register(MODID + ":" + "trade_tables/assorted_items/tagged_leather_table");
    public static final ResourceLocation TAGGED_INK_TABLE = register(MODID + ":" + "trade_tables/assorted_items/tagged_ink_table");
    public static final ResourceLocation TAGGED_DYES_TABLE = register(MODID + ":" + "trade_tables/assorted_items/tagged_dyes_table");

    // books and bookshelves
    public static final ResourceLocation BOOKSHELF_TABLE = register(MODID + ":" + "trade_tables/library/bookshelf_table");
    public static final ResourceLocation GUIDE_BOOKS_TABLE = register(MODID + ":" + "trade_tables/library/guide_books");

    // stone block trade tables
    public static final ResourceLocation SINGLE_BRICK_TABLE = register(MODID + ":" + "trade_tables/stone/single_brick");
    public static final ResourceLocation OVERWORLD_STONE_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/stone/overworld_stone_blocks");
    public static final ResourceLocation OVERWORLD_BRICK_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/stone/overworld_brick_blocks");
    public static final ResourceLocation OVERWORLD_POLISHED_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/stone/overworld_polished_stone_blocks");
    public static final ResourceLocation OTHER_STONE_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/stone/other_stone_blocks");

    public static final ResourceLocation TERRACOTTA_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/terracotta/terracotta_blocks");
    public static final ResourceLocation GLAZED_TERRACOTTA_BLOCKS_TABLE = register(MODID + ":" + "trade_tables/terracotta/glazed_terracotta_blocks");

    // equipment trade tables
    public static final ResourceLocation STONE_TIER_KNIVES = register(MODID + ":" + "trade_tables/tools/stone_tier_knives_table");
    public static final ResourceLocation STONE_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/stone_tier_tools");
    public static final ResourceLocation IRON_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/iron_tier_tools");
    public static final ResourceLocation GOLD_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/gold_tier_tools");
    public static final ResourceLocation DIAMOND_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/diamond_tier_tools");
    public static final ResourceLocation NETHERITE_TIER_TOOLS_TABLE = register(MODID + ":" + "trade_tables/tools/netherite_tier_tools");

    public static final ResourceLocation LEATHER_TIER_HORSE_ARMOR_TABLE = register(MODID + ":" + "trade_tables/armor/horse/leather_tier_horse_armor");
    public static final ResourceLocation GOLD_TIER_HORSE_ARMOR_TABLE = register(MODID + ":" + "trade_tables/armor/horse/gold_tier_horse_armor");
    public static final ResourceLocation IRON_TIER_HORSE_ARMOR_TABLE = register(MODID + ":" + "trade_tables/armor/horse/iron_tier_horse_armor");
    public static final ResourceLocation DIAMOND_TIER_HORSE_ARMOR_TABLE = register(MODID + ":" + "trade_tables/armor/horse/diamond_tier_horse_armor");

    public static final ResourceLocation LEATHER_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/leather_tier_helmets");
    public static final ResourceLocation CHAINMAIL_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/chainmail_tier_helmets");
    public static final ResourceLocation IRON_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/iron_tier_helmets");
    public static final ResourceLocation GOLD_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/gold_tier_helmets");
    public static final ResourceLocation DIAMOND_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/diamond_tier_helmets");
    public static final ResourceLocation NETHERITE_TIER_HELMETS_TABLE = register(MODID + ":" + "trade_tables/armor/netherite_tier_helmets");

    public static final ResourceLocation LEATHER_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/leather_tier_chestplates");
    public static final ResourceLocation CHAINMAIL_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/chainmail_tier_chestplates");
    public static final ResourceLocation IRON_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/iron_tier_chestplates");
    public static final ResourceLocation GOLD_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/gold_tier_chestplates");
    public static final ResourceLocation DIAMOND_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/diamond_tier_chestplates");
    public static final ResourceLocation NETHERITE_TIER_CHESTPLATES_TABLE = register(MODID + ":" + "trade_tables/armor/netherite_tier_chestplates");

    public static final ResourceLocation LEATHER_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/leather_tier_leggings");
    public static final ResourceLocation CHAINMAIL_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/chainmail_tier_leggings");
    public static final ResourceLocation IRON_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/iron_tier_leggings");
    public static final ResourceLocation GOLD_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/gold_tier_leggings");
    public static final ResourceLocation DIAMOND_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/diamond_tier_leggings");
    public static final ResourceLocation NETHERITE_TIER_LEGGINGS_TABLE = register(MODID + ":" + "trade_tables/armor/netherite_tier_leggings");

    public static final ResourceLocation LEATHER_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/leather_tier_boots");
    public static final ResourceLocation CHAINMAIL_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/chainmail_tier_boots");
    public static final ResourceLocation IRON_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/iron_tier_boots");
    public static final ResourceLocation GOLD_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/gold_tier_boots");
    public static final ResourceLocation DIAMOND_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/diamond_tier_boots");
    public static final ResourceLocation NETHERITE_TIER_BOOTS_TABLE = register(MODID + ":" + "trade_tables/armor/netherite_tier_boots");

    public static final ResourceLocation BOWS_TABLE = register(MODID + ":" + "trade_tables/weapons/bows");
    public static final ResourceLocation TAGGED_QUIVERS_TABLE = register(MODID + ":" + "trade_tables/weapons/quivers");

    // numismatist merchant specific offers loot tables
    public static final ResourceLocation NUMISMATIST_RARE_OFFERS =
            register(MODID + ":" + "trade_tables/numismatist/rare_offers");
    public static final ResourceLocation NUMISMATIST_CONTAINER_OFFERS =
            register(MODID + ":" + "trade_tables/numismatist/container_offers");

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