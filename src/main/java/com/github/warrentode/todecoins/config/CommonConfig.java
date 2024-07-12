package com.github.warrentode.todecoins.config;

import com.github.warrentode.todecoins.loot.VillagerTradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> USE_MOD_TRADES;
    public static final ForgeConfigSpec.ConfigValue<Integer> BASE_TRADE_XP;
    // currency value tables
    public static final ForgeConfigSpec.ConfigValue<String> ONE_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> TWO_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> THREE_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> FOUR_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> FIVE_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> SIX_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> SEVEN_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EIGHT_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> NINE_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> FOURTEEN_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> TWENTY_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> TWENTY_SIX_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> THIRTY_SIX_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_QUARTER_NOTE_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_HALF_NOTE_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_NOTE_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> TWO_GOLD_POT_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> FOUR_GOLD_POT_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> THIRTY_GOLD_POT_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> SIXTY_GOLD_POT_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> ONE_LUCKY_COIN_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> ONE_LUCKY_COIN_BAG_VALUE;
    // item loot tables
    public static final ForgeConfigSpec.ConfigValue<String> ONE_EMERALD_METALS;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_NOTE_METALS;
    public static final ForgeConfigSpec.ConfigValue<String> ONE_EMERALD_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> FIVE_EMERALD_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> TWO_GOLD_POT_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> FOUR_GOLD_POT_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> THIRTY_GOLD_POT_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> SIXTY_GOLD_POT_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_NOTE_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> LUCKY_COIN_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> RAW_MEAT_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> RAW_MEAT_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MEAT_SOUP_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> MEAT_SOUP_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOKED_MEAT_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOKED_MEAT_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SALT_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> SALT_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> VEG_GRAIN_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> VEG_GRAIN_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BREAD_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> BREAD_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GOURD_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> GOURD_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PIE_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> PIE_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FRUIT_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> FRUIT_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOKIE_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOKIE_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CAKE_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> CAKE_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PREPPED_SEAFOOD_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> PREPPED_SEAFOOD_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> RAW_SEAFOOD_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> RAW_SEAFOOD_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASS_PANE_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASS_PANE_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASS_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASS_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BANNER_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> BANNER_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WOOL_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> WOOL_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WOOL_CARPET_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> WOOL_CARPET_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BED_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> BED_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ASH_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> ASH_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHING_GEAR_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> LANTERN_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PAINTINGS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHER_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEATHER_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> INK_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> INK_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> DYE_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> DYE_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BOOKSHELF_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> GUIDE_BOOK_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> OVERWORLD_BRICK_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> OVERWORLD_STONE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> OVERWORLD_BRICK_BLOCK_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> OVERWORLD_POLISHED_STONE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> OTHER_STONE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> TERRACOTTA_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> GLAZED_TERRACOTTA_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> STONE_KNIFE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> STONE_TOOL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> IRON_TOOL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> GOLD_TOOL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> DIAMOND_TOOL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERITE_TOOL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHER_HORSE_ARMOR_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> IRON_HORSE_ARMOR_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHER_HELMET_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> CHAINMAIL_HELMET_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> IRON_HELMET_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> DIAMOND_HELMET_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHER_CHESTPLATE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> CHAINMAIL_CHESTPLATE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> IRON_CHESTPLATE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> DIAMOND_CHESTPLATE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHER_LEGGINGS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> CHAINMAIL_LEGGINGS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> IRON_LEGGINGS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> DIAMOND_LEGGINGS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHER_BOOTS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> CHAINMAIL_BOOTS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> IRON_BOOTS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> DIAMOND_BOOTS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> BOWS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> QUIVER_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> QUIVER_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> IRON_WEAPON_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> DIAMOND_WEAPON_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> GOLD_WEAPON_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERITE_WEAPON_TABLE;

    static {
        BUILDER.push("Config Settings for TodeCoins");
        USE_MOD_TRADES = BUILDER
                .comment(" Use Trade Tables? Default: false")
                .define("use_trade_tables", false);
        BASE_TRADE_XP = BUILDER
                .comment(" Experience per Trade Level Default: 5")
                .define("xp_per_level", 5);

        BUILDER.push("Lucky Coin Value Loot Tables");
        ONE_LUCKY_COIN_VALUE = BUILDER
                .comment(" 1 Lucky Coin = 192 Emeralds")
                .define("lucky_coin_value",
                        VillagerTradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY.toString());
        ONE_LUCKY_COIN_BAG_VALUE = BUILDER
                .comment(" 9 Lucky Coin Value")
                .define("lucky_coin_bag_value",
                        VillagerTradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY.toString());
        BUILDER.pop();

        BUILDER.push("Pot of Gold Value Loot Tables");
        TWO_GOLD_POT_VALUE = BUILDER
                .comment(" 2 Pots of Gold = 3 Emeralds")
                .define("two_gold_pot_value",
                        VillagerTradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        FOUR_GOLD_POT_VALUE = BUILDER
                .comment(" 4 Pots of Gold = 6 Emeralds")
                .define("four_gold_pot_value",
                        VillagerTradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        THIRTY_GOLD_POT_VALUE = BUILDER
                .comment(" 30 Pots of Gold = 45 Emeralds")
                .define("thirty_gold_pot_value",
                        VillagerTradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        SIXTY_GOLD_POT_VALUE = BUILDER
                .comment(" 60 Pots of Gold = 90 Emeralds")
                .define("sixty_gold_pot_value",
                        VillagerTradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();

        BUILDER.push("Emerald Bank Note Value Loot Tables");
        EMERALD_QUARTER_NOTE_VALUE = BUILDER
                .comment(" 1 Emerald Quarter Bank Note = 16 Emeralds")
                .define("emerald_quarter_note_value",
                        VillagerTradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        EMERALD_HALF_NOTE_VALUE = BUILDER
                .comment(" 1 Emerald Half Bank Note = 32 Emeralds")
                .define("emerald_half_note_value",
                        VillagerTradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        EMERALD_NOTE_VALUE = BUILDER
                .comment(" 1 Emerald Bank Note = 64 Emeralds")
                .define("emerald_note_value",
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();

        BUILDER.push("Emerald Value Loot Tables");
        ONE_EMERALD_VALUE = BUILDER
                .comment(" 1 Emerald Value Currency")
                .define("one_emerald_value",
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TWO_EMERALD_VALUE = BUILDER
                .comment(" 2 Emerald Value Currency")
                .define("two_emerald_value",
                        VillagerTradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        THREE_EMERALD_VALUE = BUILDER
                .comment(" 3 Emerald Value Currency")
                .define("three_emerald_value",
                        VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        FOUR_EMERALD_VALUE = BUILDER
                .comment(" 4 Emerald Value Currency")
                .define("four_emerald_value",
                        VillagerTradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        FIVE_EMERALD_VALUE = BUILDER
                .comment(" 5 Emerald Value Currency")
                .define("five_emerald_value",
                        VillagerTradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        SIX_EMERALD_VALUE = BUILDER
                .comment(" 6 Emerald Value Currency")
                .define("six_emerald_value",
                        VillagerTradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        SEVEN_EMERALD_VALUE = BUILDER
                .comment(" 7 Emerald Value Currency")
                .define("seven_emerald_value",
                        VillagerTradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        EIGHT_EMERALD_VALUE = BUILDER
                .comment(" 8 Emerald Value Currency")
                .define("eight_emerald_value",
                        VillagerTradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY.toString());
        NINE_EMERALD_VALUE = BUILDER
                .comment(" 9 Emerald Value Currency")
                .define("nine_emerald_value",
                        VillagerTradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        FOURTEEN_EMERALD_VALUE = BUILDER
                .comment(" 14 Emerald Value Currency")
                .define("fourteen_emerald_value",
                        VillagerTradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        TWENTY_EMERALD_VALUE = BUILDER
                .comment(" 20 Emerald Value Currency")
                .define("twenty_emerald_value",
                        VillagerTradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        TWENTY_SIX_EMERALD_VALUE = BUILDER
                .comment(" 26 Emerald Value Currency")
                .define("twenty_six_emerald_value",
                        VillagerTradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        THIRTY_SIX_EMERALD_VALUE = BUILDER
                .comment(" 36 Emerald Value Currency")
                .define("thirty_six_emerald_value",
                        VillagerTradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();

        BUILDER.push("Item Tag Loot Tables for Trades");
        RAW_MEAT_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("raw_meat_tag_table",
                        VillagerTradeLootTables.TAGGED_RAW_MEATS_TABLE.toString());
        RAW_MEAT_TAG_COUNT = BUILDER.define("raw_meat_tag_amount", 8);
        COOKED_MEAT_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("cooked_meat_tag_table",
                        VillagerTradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        COOKED_MEAT_TAG_COUNT = BUILDER.define("cooked_meat_tag_amount", 8);
        MEAT_SOUP_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("meat_soup_tag_table",
                        VillagerTradeLootTables.TAGGED_MEAT_SOUPS_TABLE.toString());
        MEAT_SOUP_TAG_COUNT = BUILDER.define("meat_soup_tag_amount", 1);
        VEG_GRAIN_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("vegetable_and_grain_tags_table",
                        VillagerTradeLootTables.TAGGED_VEGGIES_AND_GRAINS_TABLE.toString());
        VEG_GRAIN_TAG_COUNT = BUILDER.define("vegetables_and_grain_tag_amount", 16);
        BREAD_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("bread_tag_table",
                        VillagerTradeLootTables.TAGGED_BREADS_TABLE.toString());
        BREAD_TAG_COUNT = BUILDER.define("bread_tag_amount", 6);
        GOURD_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .comment(" 1 Emerald Value")
                .define("gourd_tag_table",
                        VillagerTradeLootTables.TAGGED_GOURDS_TABLE.toString());
        GOURD_TAG_COUNT = BUILDER.define("gourd_tag_amount", 6);
        PIE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("pie_tag_table",
                        VillagerTradeLootTables.TAGGED_PIES_TABLE.toString());
        PIE_TAG_COUNT = BUILDER.define("pie_tag_amount", 4);
        FRUIT_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("fruit_tag_table",
                        VillagerTradeLootTables.TAGGED_FRUITS_TABLE.toString());
        FRUIT_TAG_COUNT = BUILDER.define("fruit_tag_amount", 4);
        COOKIE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("cookie_tag_table",
                        VillagerTradeLootTables.TAGGED_COOKIES_TABLE.toString());
        COOKIE_TAG_COUNT = BUILDER.define("cookie_tag_amount", 18);
        CAKE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("cake_tag_table",
                        VillagerTradeLootTables.TAGGED_CAKES_TABLE.toString());
        CAKE_TAG_COUNT = BUILDER.define("cake_tag_amount", 1);
        PREPPED_SEAFOOD_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("prepared_seafood_tag_table",
                        VillagerTradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE.toString());
        PREPPED_SEAFOOD_TAG_COUNT = BUILDER.define("prepared_seafood_tag_amount", 6);
        RAW_SEAFOOD_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("raw_seafood_tag_table",
                        VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        RAW_SEAFOOD_TAG_COUNT = BUILDER.define("raw_seafood_tag_amount", 8);
        GLASS_PANE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("glass_pane_tag_table",
                        VillagerTradeLootTables.TAGGED_GLASS_PANES_TABLE.toString());
        GLASS_PANE_TAG_COUNT = BUILDER.define("glass_pane_tag_amount", 11);
        GLASS_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("glass_tag_table",
                        VillagerTradeLootTables.TAGGED_GLASS_PANES_TABLE.toString());
        GLASS_TAG_COUNT = BUILDER.define("glass_tag_amount", 4);
        BANNER_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("banner_tag_table",
                        VillagerTradeLootTables.TAGGED_BANNER_TABLE.toString());
        BANNER_TAG_COUNT = BUILDER.define("banner_tag_amount", 1);
        WOOL_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("wool_tag_table",
                        VillagerTradeLootTables.TAGGED_WOOL_TABLE.toString());
        WOOL_TAG_COUNT = BUILDER.define("wool_tag_amount", 1);
        WOOL_CARPET_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("wool_carpet_tag_table",
                        VillagerTradeLootTables.TAGGED_WOOL_CARPETS_TABLE.toString());
        WOOL_CARPET_TAG_COUNT = BUILDER.define("wool_carpet_tag_amount", 4);
        BED_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("bed_tag_table",
                        VillagerTradeLootTables.TAGGED_BEDS_TABLE.toString());
        BED_TAG_COUNT = BUILDER.define("bed_tag_amount", 1);
        LEATHER_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("leather_tag_table",
                        VillagerTradeLootTables.TAGGED_LEATHER_TABLE.toString());
        LEATHER_TAG_COUNT = BUILDER.define("leather_tag_amount", 6);
        INK_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("ink_tag_table",
                        VillagerTradeLootTables.TAGGED_INK_TABLE.toString());
        INK_TAG_COUNT = BUILDER.define("ink_tag_amount", 5);
        DYE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .define("dye_tag_table",
                        VillagerTradeLootTables.TAGGED_DYES_TABLE.toString());
        DYE_TAG_COUNT = BUILDER.define("dye_tag_amount", 12);
        SALT_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .comment(" Trade Unlocked with either Salt mod or Turtle Block Academy mod Loaded")
                .define("salt_tag_table",
                        VillagerTradeLootTables.TAGGED_SALTS_TABLE.toString());
        SALT_TAG_COUNT = BUILDER.define("salt_tag_amount", 8);
        ASH_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .comment(" Trade Unlocked with either Supplementaries mod or Turtle Block Academy mod Loaded")
                .define("ash_tag_table",
                        VillagerTradeLootTables.TAGGED_ASH_TABLE.toString());
        ASH_TAG_COUNT = BUILDER.define("ash_tag_amount", 8);
        QUIVER_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value Item Tag Loot Table")
                .comment(" Trade Unlocked with Supplementaries mod Loaded")
                .define("quiver_tag_table",
                        VillagerTradeLootTables.TAGGED_QUIVERS_TABLE.toString());
        QUIVER_TAG_COUNT = BUILDER.define("quiver_tag_amount", 1);
        BUILDER.pop();

        BUILDER.push("Item Loot Tables for Trades");
        GUIDE_BOOK_TABLE = BUILDER
                .comment(" 1 Copper Coin Value")
                .define("guide_book_table",
                        VillagerTradeLootTables.GUIDE_BOOKS_TABLE.toString());
        ONE_EMERALD_METALS = BUILDER
                .comment(" 1 Emerald Value")
                .define("one_emerald_metals",
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        ONE_EMERALD_GEMS = BUILDER
                .comment(" 1 Emerald Value")
                .define("one_emerald_gems",
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        FISHING_GEAR_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("fishing_gear_table",
                        VillagerTradeLootTables.FISHING_GEAR_TABLE.toString());
        LANTERN_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("lantern_table",
                        VillagerTradeLootTables.LANTERN_TABLE.toString());
        OVERWORLD_BRICK_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("overworld_brick_table",
                        VillagerTradeLootTables.OVERWORLD_BRICK_TABLE.toString());
        OVERWORLD_BRICK_BLOCK_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("overworld_brick_block_table",
                        VillagerTradeLootTables.OVERWORLD_BRICK_BLOCKS_TABLE.toString());
        OVERWORLD_STONE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("overworld_stone_table",
                        VillagerTradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE.toString());
        OVERWORLD_POLISHED_STONE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("overworld_polished_stone_table",
                        VillagerTradeLootTables.OVERWORLD_POLISHED_STONE_TABLE.toString());
        OTHER_STONE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("overworld_polished_stone_table",
                        VillagerTradeLootTables.OVERWORLD_POLISHED_STONE_TABLE.toString());
        TERRACOTTA_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("terracotta_table",
                        VillagerTradeLootTables.TERRACOTTA_BLOCKS_TABLE.toString());
        GLAZED_TERRACOTTA_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("glazed_terracotta_table",
                        VillagerTradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE.toString());
        STONE_KNIFE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" Trade Unlocked with Farmers Delight mod Loaded")
                .define("stone_tier_knife_table",
                        VillagerTradeLootTables.STONE_TIER_KNIVES.toString());
        STONE_TOOL_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("stone_tier_tools_table",
                        VillagerTradeLootTables.STONE_TIER_TOOLS_TABLE.toString());
        CHAINMAIL_HELMET_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("chainmail_tier_helmets_table",
                        VillagerTradeLootTables.CHAINMAIL_TIER_HELMETS_TABLE.toString());
        CHAINMAIL_BOOTS_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .define("chainmail_tier_boots_table",
                        VillagerTradeLootTables.CHAINMAIL_TIER_BOOTS_TABLE.toString());

        PAINTINGS_TABLE = BUILDER
                .comment(" 2 Emerald Value")
                .define("paintings_table",
                        VillagerTradeLootTables.PAINTINGS_TABLE.toString());

        IRON_TOOL_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" Enchanted: 20 Emerald Value")
                .define("iron_tier_tools_table",
                        VillagerTradeLootTables.IRON_TIER_TOOLS_TABLE.toString());
        IRON_WEAPON_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" Enchanted: 20 Emerald Value")
                .define("iron_tier_weapons_table",
                        VillagerTradeLootTables.IRON_TIER_WEAPONS_TABLE.toString());
        LEATHER_HELMET_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .define("leather_tier_helmets_table",
                        VillagerTradeLootTables.LEATHER_TIER_HELMETS_TABLE.toString());
        CHAINMAIL_LEGGINGS_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .define("chainmail_tier_leggings_table",
                        VillagerTradeLootTables.CHAINMAIL_TIER_LEGGINGS_TABLE.toString());
        TWO_GOLD_POT_GEMS = BUILDER
                .comment(" 3 Emerald Value")
                .define("two_gold_pot_gems",
                        VillagerTradeLootTables.TWO_POT_OF_GOLD_VALUE_GEMS.toString());
        BOWS_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" Enchanted: 7 Emerald Value")
                .define("bows_table",
                        VillagerTradeLootTables.BOWS_TABLE.toString());

        DIAMOND_TOOL_TABLE = BUILDER
                .comment(" 4 Emerald Value")
                .comment(" Enchanted: 26 Emerald Value")
                .define("diamond_tier_tools_table",
                        VillagerTradeLootTables.DIAMOND_TIER_TOOLS_TABLE.toString());
        CHAINMAIL_CHESTPLATE_TABLE = BUILDER
                .comment(" 4 Emerald Value")
                .define("chainmail_tier_chestplate_table",
                        VillagerTradeLootTables.CHAINMAIL_TIER_CHESTPLATES_TABLE.toString());
        LEATHER_BOOTS_TABLE = BUILDER
                .comment(" 4 Emerald Value")
                .define("leather_tier_boots_table",
                        VillagerTradeLootTables.LEATHER_TIER_BOOTS_TABLE.toString());
        IRON_BOOTS_TABLE = BUILDER
                .comment(" 4 Emerald Value")
                .define("iron_tier_boots_table",
                        VillagerTradeLootTables.IRON_TIER_BOOTS_TABLE.toString());

        FIVE_EMERALD_GEMS = BUILDER
                .comment(" 5 Emerald Value")
                .define("five_emerald_gems",
                        VillagerTradeLootTables.FIVE_EMERALD_VALUE_GEMS.toString());
        LEATHER_LEGGINGS_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .define("leather_tier_leggings_table",
                        VillagerTradeLootTables.LEATHER_TIER_LEGGINGS_TABLE.toString());
        IRON_HELMET_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .define("iron_tier_helmets_table",
                        VillagerTradeLootTables.IRON_TIER_HELMETS_TABLE.toString());

        FOUR_GOLD_POT_GEMS = BUILDER
                .comment(" 6 Emerald Value")
                .define("four_gold_pot_gems",
                        VillagerTradeLootTables.FOUR_POT_OF_GOLD_VALUE_GEMS.toString());
        LEATHER_HORSE_ARMOR_TABLE = BUILDER
                .comment(" 6 Emerald Value")
                .define("leather_tier_horse_armor",
                        VillagerTradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE.toString());

        LEATHER_CHESTPLATE_TABLE = BUILDER
                .comment(" 7 Emerald Value")
                .define("leather_tier_chestplates_table",
                        VillagerTradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE.toString());
        IRON_LEGGINGS_TABLE = BUILDER
                .comment(" 7 Emerald Value")
                .define("iron_tier_leggings_table",
                        VillagerTradeLootTables.IRON_TIER_LEGGINGS_TABLE.toString());

        BOOKSHELF_TABLE = BUILDER
                .comment(" 9 Emerald Value")
                .define("bookshelf_table",
                        VillagerTradeLootTables.BOOKSHELF_TABLE.toString());
        IRON_HORSE_ARMOR_TABLE = BUILDER
                .comment(" 9 Emerald Value")
                .define("iron_tier_horse_armor",
                        VillagerTradeLootTables.IRON_TIER_HORSE_ARMOR_TABLE.toString());
        IRON_CHESTPLATE_TABLE = BUILDER
                .comment(" 9 Emerald Value")
                .define("iron_tier_chestplates_table",
                        VillagerTradeLootTables.IRON_TIER_CHESTPLATES_TABLE.toString());

        GOLD_TOOL_TABLE = BUILDER
                .comment(" 20 Emerald Value")
                .define("gold_tier_tools_table",
                        VillagerTradeLootTables.GOLD_TIER_TOOLS_TABLE.toString());
        GOLD_WEAPON_TABLE = BUILDER
                .comment(" 20 Emerald Value")
                .define("gold_tier_weapons_table",
                        VillagerTradeLootTables.GOLD_TIER_WEAPONS_TABLE.toString());
        DIAMOND_HELMET_TABLE = BUILDER
                .comment(" 20 Emerald Value")
                .define("diamond_tier_helmets_table",
                        VillagerTradeLootTables.DIAMOND_TIER_HELMETS_TABLE.toString());
        DIAMOND_BOOTS_TABLE = BUILDER
                .comment(" 20 Emerald Value")
                .define("diamond_tier_boots_table",
                        VillagerTradeLootTables.DIAMOND_TIER_BOOTS_TABLE.toString());

        DIAMOND_CHESTPLATE_TABLE = BUILDER
                .comment(" 26 Emerald Value")
                .define("diamond_tier_chestplates_table",
                        VillagerTradeLootTables.DIAMOND_TIER_CHESTPLATES_TABLE.toString());
        DIAMOND_LEGGINGS_TABLE = BUILDER
                .comment(" 26 Emerald Value")
                .define("diamond_tier_leggings_table",
                        VillagerTradeLootTables.DIAMOND_TIER_LEGGINGS_TABLE.toString());
        DIAMOND_WEAPON_TABLE = BUILDER
                .comment(" 26 Emerald Value")
                .define("diamond_tier_weapons_table",
                        VillagerTradeLootTables.DIAMOND_TIER_WEAPONS_TABLE.toString());

        THIRTY_GOLD_POT_GEMS = BUILDER
                .comment(" 45 Emerald Value")
                .define("thirty_gold_pot_gems",
                        VillagerTradeLootTables.THIRTY_POT_OF_GOLD_VALUE_GEMS.toString());

        EMERALD_NOTE_METALS = BUILDER
                .comment(" 64 Emerald Value")
                .define("emerald_bank_note_metals",
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_METALS.toString());
        EMERALD_NOTE_GEMS = BUILDER
                .comment(" 64 Emerald Value")
                .define("emerald_bank_note_gems",
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_GEMS.toString());

        SIXTY_GOLD_POT_GEMS = BUILDER
                .comment(" 90 Emerald Value")
                .define("sixty_gold_pot_gems",
                        VillagerTradeLootTables.SIXTY_POT_OF_GOLD_VALUE_GEMS.toString());

        LUCKY_COIN_GEMS = BUILDER
                .comment(" 192 Emerald Value")
                .define("lucky_coin_gems",
                        VillagerTradeLootTables.SINGLE_LUCKY_COIN_VALUE_GEMS.toString());
        NETHERITE_TOOL_TABLE = BUILDER
                .comment(" 9 Lucky Coin Value")
                .define("netherite_tier_tools_table",
                        VillagerTradeLootTables.NETHERITE_TIER_TOOLS_TABLE.toString());
        NETHERITE_WEAPON_TABLE = BUILDER
                .comment(" 9 Lucky Coin Value")
                .define("netherite_tier_weapons_table",
                        VillagerTradeLootTables.NETHERITE_TIER_WEAPONS_TABLE.toString());
        BUILDER.pop();

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
    // item loot tables
    public static String getNetheriteTierWeaponTable() {
        if (Objects.equals(NETHERITE_WEAPON_TABLE.get(), NETHERITE_WEAPON_TABLE.getDefault())) {
            return NETHERITE_WEAPON_TABLE.getDefault();
        }
        else {
            return NETHERITE_WEAPON_TABLE.get();
        }
    }
    public static String getGoldTierWeaponTable() {
        if (Objects.equals(GOLD_WEAPON_TABLE.get(), GOLD_WEAPON_TABLE.getDefault())) {
            return GOLD_WEAPON_TABLE.getDefault();
        }
        else {
            return GOLD_WEAPON_TABLE.get();
        }
    }
    public static String getDiamondTierWeaponTable() {
        if (Objects.equals(DIAMOND_WEAPON_TABLE.get(), DIAMOND_WEAPON_TABLE.getDefault())) {
            return DIAMOND_WEAPON_TABLE.getDefault();
        }
        else {
            return DIAMOND_WEAPON_TABLE.get();
        }
    }
    public static String getIronWeaponTable() {
        if (Objects.equals(IRON_WEAPON_TABLE.get(), IRON_WEAPON_TABLE.getDefault())) {
            return IRON_WEAPON_TABLE.getDefault();
        }
        else {
            return IRON_WEAPON_TABLE.get();
        }
    }
    public static String getQuiversTagTable() {
        if (Objects.equals(QUIVER_TAG_TABLE.get(), QUIVER_TAG_TABLE.getDefault())) {
            return QUIVER_TAG_TABLE.getDefault();
        }
        else {
            return QUIVER_TAG_TABLE.get();
        }
    }
    public static int getQuiverCount() {
        if (Objects.equals(QUIVER_TAG_COUNT.get(), QUIVER_TAG_COUNT.getDefault())) {
            return QUIVER_TAG_COUNT.getDefault();
        }
        else {
            return QUIVER_TAG_COUNT.get();
        }
    }
    public static String getBowsTable() {
        if (Objects.equals(BOWS_TABLE.get(), BOWS_TABLE.getDefault())) {
            return BOWS_TABLE.getDefault();
        }
        else {
            return BOWS_TABLE.get();
        }
    }
    public static String getDiamondTierBootsTable() {
        if (Objects.equals(DIAMOND_BOOTS_TABLE.get(), DIAMOND_BOOTS_TABLE.getDefault())) {
            return DIAMOND_BOOTS_TABLE.getDefault();
        }
        else {
            return DIAMOND_BOOTS_TABLE.get();
        }
    }
    public static String getIronTierBootsTable() {
        if (Objects.equals(IRON_BOOTS_TABLE.get(), IRON_BOOTS_TABLE.getDefault())) {
            return IRON_BOOTS_TABLE.getDefault();
        }
        else {
            return IRON_BOOTS_TABLE.get();
        }
    }
    public static String getChainmailTierBootsTable() {
        if (Objects.equals(CHAINMAIL_BOOTS_TABLE.get(), CHAINMAIL_BOOTS_TABLE.getDefault())) {
            return CHAINMAIL_BOOTS_TABLE.getDefault();
        }
        else {
            return CHAINMAIL_BOOTS_TABLE.get();
        }
    }
    public static String getLeatherTierBootsTable() {
        if (Objects.equals(LEATHER_BOOTS_TABLE.get(), LEATHER_BOOTS_TABLE.getDefault())) {
            return LEATHER_BOOTS_TABLE.getDefault();
        }
        else {
            return LEATHER_BOOTS_TABLE.get();
        }
    }
    public static String getDiamondTierLeggingsTable() {
        if (Objects.equals(DIAMOND_LEGGINGS_TABLE.get(), DIAMOND_LEGGINGS_TABLE.getDefault())) {
            return DIAMOND_LEGGINGS_TABLE.getDefault();
        }
        else {
            return DIAMOND_LEGGINGS_TABLE.get();
        }
    }
    public static String getIronTierLeggingsTable() {
        if (Objects.equals(IRON_LEGGINGS_TABLE.get(), IRON_LEGGINGS_TABLE.getDefault())) {
            return IRON_LEGGINGS_TABLE.getDefault();
        }
        else {
            return IRON_LEGGINGS_TABLE.get();
        }
    }
    public static String getChainmailTierLeggingsTable() {
        if (Objects.equals(CHAINMAIL_LEGGINGS_TABLE.get(), CHAINMAIL_LEGGINGS_TABLE.getDefault())) {
            return CHAINMAIL_LEGGINGS_TABLE.getDefault();
        }
        else {
            return CHAINMAIL_LEGGINGS_TABLE.get();
        }
    }
    public static String getLeatherTierLeggingsTable() {
        if (Objects.equals(LEATHER_LEGGINGS_TABLE.get(), LEATHER_LEGGINGS_TABLE.getDefault())) {
            return LEATHER_LEGGINGS_TABLE.getDefault();
        }
        else {
            return LEATHER_LEGGINGS_TABLE.get();
        }
    }
    public static String getDiamondTierChestplateTable() {
        if (Objects.equals(DIAMOND_CHESTPLATE_TABLE.get(), DIAMOND_CHESTPLATE_TABLE.getDefault())) {
            return DIAMOND_CHESTPLATE_TABLE.getDefault();
        }
        else {
            return DIAMOND_CHESTPLATE_TABLE.get();
        }
    }
    public static String getIronTierChestplateTable() {
        if (Objects.equals(IRON_CHESTPLATE_TABLE.get(), IRON_CHESTPLATE_TABLE.getDefault())) {
            return IRON_CHESTPLATE_TABLE.getDefault();
        }
        else {
            return IRON_CHESTPLATE_TABLE.get();
        }
    }
    public static String getChainmailTierChestplateTable() {
        if (Objects.equals(CHAINMAIL_CHESTPLATE_TABLE.get(), CHAINMAIL_CHESTPLATE_TABLE.getDefault())) {
            return CHAINMAIL_CHESTPLATE_TABLE.getDefault();
        }
        else {
            return CHAINMAIL_CHESTPLATE_TABLE.get();
        }
    }
    public static String getLeatherTierChestplateTable() {
        if (Objects.equals(LEATHER_CHESTPLATE_TABLE.get(), LEATHER_CHESTPLATE_TABLE.getDefault())) {
            return LEATHER_CHESTPLATE_TABLE.getDefault();
        }
        else {
            return LEATHER_CHESTPLATE_TABLE.get();
        }
    }
    public static String getDiamondTierHelmetTable() {
        if (Objects.equals(DIAMOND_HELMET_TABLE.get(), DIAMOND_HELMET_TABLE.getDefault())) {
            return DIAMOND_HELMET_TABLE.getDefault();
        }
        else {
            return DIAMOND_HELMET_TABLE.get();
        }
    }
    public static String getIronTierHelmetTable() {
        if (Objects.equals(IRON_HELMET_TABLE.get(), IRON_HELMET_TABLE.getDefault())) {
            return IRON_HELMET_TABLE.getDefault();
        }
        else {
            return IRON_HELMET_TABLE.get();
        }
    }
    public static String getChainmailTierHelmetTable() {
        if (Objects.equals(CHAINMAIL_HELMET_TABLE.get(), CHAINMAIL_HELMET_TABLE.getDefault())) {
            return CHAINMAIL_HELMET_TABLE.getDefault();
        }
        else {
            return CHAINMAIL_HELMET_TABLE.get();
        }
    }
    public static String getLeatherTierHelmetTable() {
        if (Objects.equals(LEATHER_HELMET_TABLE.get(), LEATHER_HELMET_TABLE.getDefault())) {
            return LEATHER_HELMET_TABLE.getDefault();
        }
        else {
            return LEATHER_HELMET_TABLE.get();
        }
    }
    public static String getIronTierHorseArmorTable() {
        if (Objects.equals(IRON_HORSE_ARMOR_TABLE.get(), IRON_HORSE_ARMOR_TABLE.getDefault())) {
            return IRON_HORSE_ARMOR_TABLE.getDefault();
        }
        else {
            return IRON_HORSE_ARMOR_TABLE.get();
        }
    }
    public static String getLeatherTierHorseArmorTable() {
        if (Objects.equals(LEATHER_HORSE_ARMOR_TABLE.get(), LEATHER_HORSE_ARMOR_TABLE.getDefault())) {
            return LEATHER_HORSE_ARMOR_TABLE.getDefault();
        }
        else {
            return LEATHER_HORSE_ARMOR_TABLE.get();
        }
    }
    public static String getNetheriteTierToolTable() {
        if (Objects.equals(NETHERITE_TOOL_TABLE.get(), NETHERITE_TOOL_TABLE.getDefault())) {
            return NETHERITE_TOOL_TABLE.getDefault();
        }
        else {
            return NETHERITE_TOOL_TABLE.get();
        }
    }
    public static String getDiamondTierToolTable() {
        if (Objects.equals(DIAMOND_TOOL_TABLE.get(), DIAMOND_TOOL_TABLE.getDefault())) {
            return DIAMOND_TOOL_TABLE.getDefault();
        }
        else {
            return DIAMOND_TOOL_TABLE.get();
        }
    }
    public static String getGoldTierToolTable() {
        if (Objects.equals(GOLD_TOOL_TABLE.get(), GOLD_TOOL_TABLE.getDefault())) {
            return GOLD_TOOL_TABLE.getDefault();
        }
        else {
            return GOLD_TOOL_TABLE.get();
        }
    }
    public static String getIronTierToolTable() {
        if (Objects.equals(IRON_TOOL_TABLE.get(), IRON_TOOL_TABLE.getDefault())) {
            return IRON_TOOL_TABLE.getDefault();
        }
        else {
            return IRON_TOOL_TABLE.get();
        }
    }
    public static String getStoneTierToolTable() {
        if (Objects.equals(STONE_KNIFE_TABLE.get(), STONE_KNIFE_TABLE.getDefault())) {
            return STONE_KNIFE_TABLE.getDefault();
        }
        else {
            return STONE_KNIFE_TABLE.get();
        }
    }
    public static String getStoneTierKnifeTable() {
        if (Objects.equals(STONE_KNIFE_TABLE.get(), STONE_KNIFE_TABLE.getDefault())) {
            return STONE_KNIFE_TABLE.getDefault();
        }
        else {
            return STONE_KNIFE_TABLE.get();
        }
    }
    public static String getGlazedTerracottaTable() {
        if (Objects.equals(GLAZED_TERRACOTTA_TABLE.get(), GLAZED_TERRACOTTA_TABLE.getDefault())) {
            return GLAZED_TERRACOTTA_TABLE.getDefault();
        }
        else {
            return GLAZED_TERRACOTTA_TABLE.get();
        }
    }
    public static String getTerracottaTable() {
        if (Objects.equals(TERRACOTTA_TABLE.get(), TERRACOTTA_TABLE.getDefault())) {
            return TERRACOTTA_TABLE.getDefault();
        }
        else {
            return TERRACOTTA_TABLE.get();
        }
    }
    public static String getOtherStoneTable() {
        if (Objects.equals(OTHER_STONE_TABLE.get(), OTHER_STONE_TABLE.getDefault())) {
            return OTHER_STONE_TABLE.getDefault();
        }
        else {
            return OTHER_STONE_TABLE.get();
        }
    }
    public static String getOverworldPolishedStoneTable() {
        if (Objects.equals(OVERWORLD_POLISHED_STONE_TABLE.get(), OVERWORLD_POLISHED_STONE_TABLE.getDefault())) {
            return OVERWORLD_POLISHED_STONE_TABLE.getDefault();
        }
        else {
            return OVERWORLD_POLISHED_STONE_TABLE.get();
        }
    }
    public static String getOverworldBrickBlockTable() {
        if (Objects.equals(OVERWORLD_BRICK_BLOCK_TABLE.get(), OVERWORLD_BRICK_BLOCK_TABLE.getDefault())) {
            return OVERWORLD_BRICK_BLOCK_TABLE.getDefault();
        }
        else {
            return OVERWORLD_BRICK_BLOCK_TABLE.get();
        }
    }
    public static String getOverworldStoneTable() {
        if (Objects.equals(OVERWORLD_STONE_TABLE.get(), OVERWORLD_STONE_TABLE.getDefault())) {
            return OVERWORLD_STONE_TABLE.getDefault();
        }
        else {
            return OVERWORLD_STONE_TABLE.get();
        }
    }
    public static String getOverworldBrickTable() {
        if (Objects.equals(OVERWORLD_BRICK_TABLE.get(), OVERWORLD_BRICK_TABLE.getDefault())) {
            return OVERWORLD_BRICK_TABLE.getDefault();
        }
        else {
            return OVERWORLD_BRICK_TABLE.get();
        }
    }
    public static String getGuideBookTable() {
        if (Objects.equals(GUIDE_BOOK_TABLE.get(), GUIDE_BOOK_TABLE.getDefault())) {
            return GUIDE_BOOK_TABLE.getDefault();
        }
        else {
            return GUIDE_BOOK_TABLE.get();
        }
    }
    public static String getBookshelfTable() {
        if (Objects.equals(BOOKSHELF_TABLE.get(), BOOKSHELF_TABLE.getDefault())) {
            return BOOKSHELF_TABLE.getDefault();
        }
        else {
            return BOOKSHELF_TABLE.get();
        }
    }
    public static String getDyeTagTable() {
        if (Objects.equals(DYE_TAG_TABLE.get(), DYE_TAG_TABLE.getDefault())) {
            return DYE_TAG_TABLE.getDefault();
        }
        else {
            return DYE_TAG_TABLE.get();
        }
    }
    public static int getDyeCount() {
        if (Objects.equals(DYE_TAG_COUNT.get(), DYE_TAG_COUNT.getDefault())) {
            return DYE_TAG_COUNT.getDefault();
        }
        else {
            return DYE_TAG_COUNT.get();
        }
    }
    public static String getInkTagTable() {
        if (Objects.equals(INK_TAG_TABLE.get(), INK_TAG_TABLE.getDefault())) {
            return INK_TAG_TABLE.getDefault();
        }
        else {
            return INK_TAG_TABLE.get();
        }
    }
    public static int getInkCount() {
        if (Objects.equals(INK_TAG_COUNT.get(), INK_TAG_COUNT.getDefault())) {
            return INK_TAG_COUNT.getDefault();
        }
        else {
            return INK_TAG_COUNT.get();
        }
    }
    public static String getLeatherTagTable() {
        if (Objects.equals(LEATHER_TAG_TABLE.get(), LEATHER_TAG_TABLE.getDefault())) {
            return LEATHER_TAG_TABLE.getDefault();
        }
        else {
            return LEATHER_TAG_TABLE.get();
        }
    }
    public static int getLeatherCount() {
        if (Objects.equals(LEATHER_TAG_COUNT.get(), LEATHER_TAG_COUNT.getDefault())) {
            return LEATHER_TAG_COUNT.getDefault();
        }
        else {
            return LEATHER_TAG_COUNT.get();
        }
    }
    public static String getAshTagTable() {
        if (Objects.equals(ASH_TAG_TABLE.get(), ASH_TAG_TABLE.getDefault())) {
            return ASH_TAG_TABLE.getDefault();
        }
        else {
            return ASH_TAG_TABLE.get();
        }
    }
    public static int getAshCount() {
        if (Objects.equals(ASH_TAG_COUNT.get(), ASH_TAG_COUNT.getDefault())) {
            return ASH_TAG_COUNT.getDefault();
        }
        else {
            return ASH_TAG_COUNT.get();
        }
    }
    public static String getPaintingsTable() {
        if (Objects.equals(PAINTINGS_TABLE.get(), PAINTINGS_TABLE.getDefault())) {
            return PAINTINGS_TABLE.getDefault();
        }
        else {
            return PAINTINGS_TABLE.get();
        }
    }
    public static String getLanternTable() {
        if (Objects.equals(LANTERN_TABLE.get(), LANTERN_TABLE.getDefault())) {
            return LANTERN_TABLE.getDefault();
        }
        else {
            return LANTERN_TABLE.get();
        }
    }
    public static String getFishingGearTable() {
        if (Objects.equals(FISHING_GEAR_TABLE.get(), FISHING_GEAR_TABLE.getDefault())) {
            return FISHING_GEAR_TABLE.getDefault();
        }
        else {
            return FISHING_GEAR_TABLE.get();
        }
    }
    public static String getBedTagTable() {
        if (Objects.equals(BED_TAG_TABLE.get(), BED_TAG_TABLE.getDefault())) {
            return BED_TAG_TABLE.getDefault();
        }
        else {
            return BED_TAG_TABLE.get();
        }
    }
    public static int getBedCount() {
        if (Objects.equals(BED_TAG_COUNT.get(), BED_TAG_COUNT.getDefault())) {
            return BED_TAG_COUNT.getDefault();
        }
        else {
            return BED_TAG_COUNT.get();
        }
    }
    public static String getWoolCarpetTagTable() {
        if (Objects.equals(WOOL_CARPET_TAG_TABLE.get(), WOOL_CARPET_TAG_TABLE.getDefault())) {
            return WOOL_CARPET_TAG_TABLE.getDefault();
        }
        else {
            return WOOL_CARPET_TAG_TABLE.get();
        }
    }
    public static int getWoolCarpetCount() {
        if (Objects.equals(WOOL_CARPET_TAG_COUNT.get(), WOOL_CARPET_TAG_COUNT.getDefault())) {
            return WOOL_CARPET_TAG_COUNT.getDefault();
        }
        else {
            return WOOL_CARPET_TAG_COUNT.get();
        }
    }
    public static String getWoolTagTable() {
        if (Objects.equals(WOOL_TAG_TABLE.get(), WOOL_TAG_TABLE.getDefault())) {
            return WOOL_TAG_TABLE.getDefault();
        }
        else {
            return WOOL_TAG_TABLE.get();
        }
    }
    public static int getWoolCount() {
        if (Objects.equals(WOOL_TAG_COUNT.get(), WOOL_TAG_COUNT.getDefault())) {
            return WOOL_TAG_COUNT.getDefault();
        }
        else {
            return WOOL_TAG_COUNT.get();
        }
    }
    public static String getBannerTagTable() {
        if (Objects.equals(BANNER_TAG_TABLE.get(), BANNER_TAG_TABLE.getDefault())) {
            return BANNER_TAG_TABLE.getDefault();
        }
        else {
            return BANNER_TAG_TABLE.get();
        }
    }
    public static int getBannerCount() {
        if (Objects.equals(BANNER_TAG_COUNT.get(), BANNER_TAG_COUNT.getDefault())) {
            return BANNER_TAG_COUNT.getDefault();
        }
        else {
            return BANNER_TAG_COUNT.get();
        }
    }
    public static String getGlassTagTable() {
        if (Objects.equals(GLASS_TAG_TABLE.get(), GLASS_TAG_TABLE.getDefault())) {
            return GLASS_TAG_TABLE.getDefault();
        }
        else {
            return GLASS_TAG_TABLE.get();
        }
    }
    public static int getGlassCount() {
        if (Objects.equals(GLASS_TAG_COUNT.get(), GLASS_TAG_COUNT.getDefault())) {
            return GLASS_TAG_COUNT.getDefault();
        }
        else {
            return GLASS_TAG_COUNT.get();
        }
    }
    public static String getGlassPaneTagTable() {
        if (Objects.equals(GLASS_PANE_TAG_TABLE.get(), GLASS_PANE_TAG_TABLE.getDefault())) {
            return GLASS_PANE_TAG_TABLE.getDefault();
        }
        else {
            return GLASS_PANE_TAG_TABLE.get();
        }
    }
    public static int getGlassPaneCount() {
        if (Objects.equals(GLASS_PANE_TAG_COUNT.get(), GLASS_PANE_TAG_COUNT.getDefault())) {
            return GLASS_PANE_TAG_COUNT.getDefault();
        }
        else {
            return GLASS_PANE_TAG_COUNT.get();
        }
    }
    public static String getRawSeafoodTagTable() {
        if (Objects.equals(RAW_SEAFOOD_TAG_TABLE.get(), RAW_SEAFOOD_TAG_TABLE.getDefault())) {
            return RAW_SEAFOOD_TAG_TABLE.getDefault();
        }
        else {
            return RAW_SEAFOOD_TAG_TABLE.get();
        }
    }
    public static int getRawSeafoodCount() {
        if (Objects.equals(RAW_SEAFOOD_TAG_COUNT.get(), RAW_SEAFOOD_TAG_COUNT.getDefault())) {
            return RAW_SEAFOOD_TAG_COUNT.getDefault();
        }
        else {
            return RAW_SEAFOOD_TAG_COUNT.get();
        }
    }
    public static String getPreppedSeafoodTagTable() {
        if (Objects.equals(PREPPED_SEAFOOD_TAG_TABLE.get(), PREPPED_SEAFOOD_TAG_TABLE.getDefault())) {
            return PREPPED_SEAFOOD_TAG_TABLE.getDefault();
        }
        else {
            return PREPPED_SEAFOOD_TAG_TABLE.get();
        }
    }
    public static int getPreppedSeafoodCount() {
        if (Objects.equals(PREPPED_SEAFOOD_TAG_COUNT.get(), PREPPED_SEAFOOD_TAG_COUNT.getDefault())) {
            return PREPPED_SEAFOOD_TAG_COUNT.getDefault();
        }
        else {
            return PREPPED_SEAFOOD_TAG_COUNT.get();
        }
    }
    public static String getCakeTagTable() {
        if (Objects.equals(CAKE_TAG_TABLE.get(), CAKE_TAG_TABLE.getDefault())) {
            return CAKE_TAG_TABLE.getDefault();
        }
        else {
            return CAKE_TAG_TABLE.get();
        }
    }
    public static int getCakeCount() {
        if (Objects.equals(CAKE_TAG_COUNT.get(), CAKE_TAG_COUNT.getDefault())) {
            return CAKE_TAG_COUNT.getDefault();
        }
        else {
            return CAKE_TAG_COUNT.get();
        }
    }
    public static String getCookieTagTable() {
        if (Objects.equals(COOKIE_TAG_TABLE.get(), COOKIE_TAG_TABLE.getDefault())) {
            return COOKIE_TAG_TABLE.getDefault();
        }
        else {
            return COOKIE_TAG_TABLE.get();
        }
    }
    public static int getCookieCount() {
        if (Objects.equals(COOKIE_TAG_COUNT.get(), COOKIE_TAG_COUNT.getDefault())) {
            return COOKIE_TAG_COUNT.getDefault();
        }
        else {
            return COOKIE_TAG_COUNT.get();
        }
    }
    public static String getFruitTagTable() {
        if (Objects.equals(FRUIT_TAG_TABLE.get(), FRUIT_TAG_TABLE.getDefault())) {
            return FRUIT_TAG_TABLE.getDefault();
        }
        else {
            return FRUIT_TAG_TABLE.get();
        }
    }
    public static int getFruitCount() {
        if (Objects.equals(FRUIT_TAG_COUNT.get(), FRUIT_TAG_COUNT.getDefault())) {
            return FRUIT_TAG_COUNT.getDefault();
        }
        else {
            return FRUIT_TAG_COUNT.get();
        }
    }
    public static String getPieTagTable() {
        if (Objects.equals(PIE_TAG_TABLE.get(), PIE_TAG_TABLE.getDefault())) {
            return PIE_TAG_TABLE.getDefault();
        }
        else {
            return PIE_TAG_TABLE.get();
        }
    }
    public static int getPieCount() {
        if (Objects.equals(PIE_TAG_COUNT.get(), PIE_TAG_COUNT.getDefault())) {
            return PIE_TAG_COUNT.getDefault();
        }
        else {
            return PIE_TAG_COUNT.get();
        }
    }
    public static String getGourdTagTable() {
        if (Objects.equals(GOURD_TAG_TABLE.get(), GOURD_TAG_TABLE.getDefault())) {
            return GOURD_TAG_TABLE.getDefault();
        }
        else {
            return GOURD_TAG_TABLE.get();
        }
    }
    public static int getGourdCount() {
        if (Objects.equals(GOURD_TAG_COUNT.get(), GOURD_TAG_COUNT.getDefault())) {
            return GOURD_TAG_COUNT.getDefault();
        }
        else {
            return GOURD_TAG_COUNT.get();
        }
    }
    public static String getBreadTagTable() {
        if (Objects.equals(BREAD_TAG_TABLE.get(), BREAD_TAG_TABLE.getDefault())) {
            return BREAD_TAG_TABLE.getDefault();
        }
        else {
            return BREAD_TAG_TABLE.get();
        }
    }
    public static int getBreadCount() {
        if (Objects.equals(BREAD_TAG_COUNT.get(), BREAD_TAG_COUNT.getDefault())) {
            return BREAD_TAG_COUNT.getDefault();
        }
        else {
            return BREAD_TAG_COUNT.get();
        }
    }
    public static String getVegGrainTagTable() {
        if (Objects.equals(VEG_GRAIN_TAG_TABLE.get(), VEG_GRAIN_TAG_TABLE.getDefault())) {
            return VEG_GRAIN_TAG_TABLE.getDefault();
        }
        else {
            return VEG_GRAIN_TAG_TABLE.get();
        }
    }
    public static int getVegGrainCount() {
        if (Objects.equals(VEG_GRAIN_TAG_COUNT.get(), VEG_GRAIN_TAG_COUNT.getDefault())) {
            return VEG_GRAIN_TAG_COUNT.getDefault();
        }
        else {
            return VEG_GRAIN_TAG_COUNT.get();
        }
    }
    public static String getSaltTagTable() {
        if (Objects.equals(SALT_TAG_TABLE.get(), SALT_TAG_TABLE.getDefault())) {
            return SALT_TAG_TABLE.getDefault();
        }
        else {
            return SALT_TAG_TABLE.get();
        }
    }
    public static int getSaltCount() {
        if (Objects.equals(SALT_TAG_COUNT.get(), SALT_TAG_COUNT.getDefault())) {
            return SALT_TAG_COUNT.getDefault();
        }
        else {
            return SALT_TAG_COUNT.get();
        }
    }
    public static String getCookedMeatTagTable() {
        if (Objects.equals(COOKED_MEAT_TAG_TABLE.get(), COOKED_MEAT_TAG_TABLE.getDefault())) {
            return COOKED_MEAT_TAG_TABLE.getDefault();
        }
        else {
            return COOKED_MEAT_TAG_TABLE.get();
        }
    }
    public static int getCookedMeatCount() {
        if (Objects.equals(COOKED_MEAT_TAG_COUNT.get(), COOKED_MEAT_TAG_COUNT.getDefault())) {
            return COOKED_MEAT_TAG_COUNT.getDefault();
        }
        else {
            return COOKED_MEAT_TAG_COUNT.get();
        }
    }
    public static String getMeatSoupTagTable() {
        if (Objects.equals(MEAT_SOUP_TAG_TABLE.get(), MEAT_SOUP_TAG_TABLE.getDefault())) {
            return MEAT_SOUP_TAG_TABLE.getDefault();
        }
        else {
            return MEAT_SOUP_TAG_TABLE.get();
        }
    }
    public static int getMeatSoupCount() {
        if (Objects.equals(MEAT_SOUP_TAG_COUNT.get(), MEAT_SOUP_TAG_COUNT.getDefault())) {
            return MEAT_SOUP_TAG_COUNT.getDefault();
        }
        else {
            return RAW_MEAT_TAG_COUNT.get();
        }
    }
    public static String getRawMeatTagTable() {
        if (Objects.equals(RAW_MEAT_TAG_TABLE.get(), RAW_MEAT_TAG_TABLE.getDefault())) {
            return RAW_MEAT_TAG_TABLE.getDefault();
        }
        else {
            return RAW_MEAT_TAG_TABLE.get();
        }
    }
    public static int getRawMeatCount() {
        if (Objects.equals(RAW_MEAT_TAG_COUNT.get(), RAW_MEAT_TAG_COUNT.getDefault())) {
            return RAW_MEAT_TAG_COUNT.getDefault();
        }
        else {
            return RAW_MEAT_TAG_COUNT.get();
        }
    }
    public static String getLuckyCoinGemsTable() {
        if (Objects.equals(LUCKY_COIN_GEMS.get(), LUCKY_COIN_GEMS.getDefault())) {
            return LUCKY_COIN_GEMS.getDefault();
        }
        else {
            return LUCKY_COIN_GEMS.get();
        }
    }
    public static String getEmeraldNoteGemsTable() {
        if (Objects.equals(EMERALD_NOTE_GEMS.get(), EMERALD_NOTE_GEMS.getDefault())) {
            return EMERALD_NOTE_GEMS.getDefault();
        }
        else {
            return EMERALD_NOTE_GEMS.get();
        }
    }
    public static String getSixtyGoldPotGemsTable() {
        if (Objects.equals(SIXTY_GOLD_POT_GEMS.get(), SIXTY_GOLD_POT_GEMS.getDefault())) {
            return SIXTY_GOLD_POT_GEMS.getDefault();
        }
        else {
            return SIXTY_GOLD_POT_GEMS.get();
        }
    }
    public static String getThirtyGoldPotGemsTable() {
        if (Objects.equals(THIRTY_GOLD_POT_GEMS.get(), THIRTY_GOLD_POT_GEMS.getDefault())) {
            return THIRTY_GOLD_POT_GEMS.getDefault();
        }
        else {
            return THIRTY_GOLD_POT_GEMS.get();
        }
    }
    public static String getFourGoldPotGemsTable() {
        if (Objects.equals(FOUR_GOLD_POT_GEMS.get(), FOUR_GOLD_POT_GEMS.getDefault())) {
            return FOUR_GOLD_POT_GEMS.getDefault();
        }
        else {
            return FOUR_GOLD_POT_GEMS.get();
        }
    }
    public static String getTwoGoldPotGemsTable() {
        if (Objects.equals(TWO_GOLD_POT_GEMS.get(), TWO_GOLD_POT_GEMS.getDefault())) {
            return TWO_GOLD_POT_GEMS.getDefault();
        }
        else {
            return TWO_GOLD_POT_GEMS.get();
        }
    }
    public static String getFiveEmeraldGemsTable() {
        if (Objects.equals(FIVE_EMERALD_GEMS.get(), FIVE_EMERALD_GEMS.getDefault())) {
            return FIVE_EMERALD_GEMS.getDefault();
        }
        else {
            return FIVE_EMERALD_GEMS.get();
        }
    }
    public static String getOneEmeraldGemsTable() {
        if (Objects.equals(ONE_EMERALD_GEMS.get(), ONE_EMERALD_GEMS.getDefault())) {
            return ONE_EMERALD_GEMS.getDefault();
        }
        else {
            return ONE_EMERALD_GEMS.get();
        }
    }
    public static String getOneEmeraldMetalsTable() {
        if (Objects.equals(ONE_EMERALD_METALS.get(), ONE_EMERALD_METALS.getDefault())) {
            return ONE_EMERALD_METALS.getDefault();
        }
        else {
            return ONE_EMERALD_METALS.get();
        }
    }
    public static String getEmeraldNoteMetalsTable() {
        if (Objects.equals(EMERALD_NOTE_METALS.get(), EMERALD_NOTE_METALS.getDefault())) {
            return EMERALD_NOTE_METALS.getDefault();
        }
        else {
            return EMERALD_NOTE_METALS.get();
        }
    }
    // currency value tables
    public static String getLuckyCoinBagValueCurrency() {
        if (Objects.equals(ONE_LUCKY_COIN_BAG_VALUE.get(), ONE_LUCKY_COIN_BAG_VALUE.getDefault())) {
            return ONE_LUCKY_COIN_BAG_VALUE.getDefault();
        }
        else {
            return ONE_LUCKY_COIN_BAG_VALUE.get();
        }
    }
    public static String getOneLuckyCoinCurrencyTable() {
        if (Objects.equals(ONE_LUCKY_COIN_VALUE.get(), ONE_LUCKY_COIN_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return ONE_LUCKY_COIN_VALUE.get();
        }
    }
    public static String getSixtyPotGoldCurrencyTable() {
        if (Objects.equals(SIXTY_GOLD_POT_VALUE.get(), SIXTY_GOLD_POT_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return SIXTY_GOLD_POT_VALUE.get();
        }
    }
    public static String getThirtyPotGoldCurrencyTable() {
        if (Objects.equals(THIRTY_GOLD_POT_VALUE.get(), THIRTY_GOLD_POT_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return THIRTY_GOLD_POT_VALUE.get();
        }
    }
    public static String getFourPotGoldCurrencyTable() {
        if (Objects.equals(FOUR_GOLD_POT_VALUE.get(), FOUR_GOLD_POT_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return FOUR_GOLD_POT_VALUE.get();
        }
    }
    public static String getTwoPotGoldCurrencyTable() {
        if (Objects.equals(TWO_GOLD_POT_VALUE.get(), TWO_GOLD_POT_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return TWO_GOLD_POT_VALUE.get();
        }
    }
    public static String getEmeraldNoteCurrencyTable() {
        if (Objects.equals(EMERALD_NOTE_VALUE.get(), EMERALD_NOTE_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return EMERALD_NOTE_VALUE.get();
        }
    }
    public static String getEmeraldHalfNoteCurrencyTable() {
        if (Objects.equals(EMERALD_HALF_NOTE_VALUE.get(), EMERALD_HALF_NOTE_VALUE.getDefault())) {
            return EMERALD_HALF_NOTE_VALUE.getDefault();
        }
        else {
            return EMERALD_HALF_NOTE_VALUE.get();
        }
    }
    public static String getEmeraldQuarterNoteCurrencyTable() {
        if (Objects.equals(EMERALD_QUARTER_NOTE_VALUE.get(), EMERALD_QUARTER_NOTE_VALUE.getDefault())) {
            return EMERALD_QUARTER_NOTE_VALUE.getDefault();
        }
        else {
            return EMERALD_QUARTER_NOTE_VALUE.get();
        }
    }
    public static String getThirtySixEmeraldCurrencyTable() {
        if (Objects.equals(THIRTY_SIX_EMERALD_VALUE.get(), THIRTY_SIX_EMERALD_VALUE.getDefault())) {
            return THIRTY_SIX_EMERALD_VALUE.getDefault();
        }
        else {
            return THIRTY_SIX_EMERALD_VALUE.get();
        }
    }
    public static String getTwentySixEmeraldCurrencyTable() {
        if (Objects.equals(TWENTY_SIX_EMERALD_VALUE.get(), TWENTY_SIX_EMERALD_VALUE.getDefault())) {
            return TWENTY_SIX_EMERALD_VALUE.getDefault();
        }
        else {
            return TWENTY_SIX_EMERALD_VALUE.get();
        }
    }
    public static String getTwentyEmeraldCurrencyTable() {
        if (Objects.equals(TWENTY_EMERALD_VALUE.get(), TWENTY_EMERALD_VALUE.getDefault())) {
            return TWENTY_EMERALD_VALUE.getDefault();
        }
        else {
            return TWENTY_EMERALD_VALUE.get();
        }
    }
    public static String getFourteenEmeraldCurrencyTable() {
        if (Objects.equals(FOURTEEN_EMERALD_VALUE.get(), FOURTEEN_EMERALD_VALUE.getDefault())) {
            return FOURTEEN_EMERALD_VALUE.getDefault();
        }
        else {
            return FOURTEEN_EMERALD_VALUE.get();
        }
    }
    public static String getNineEmeraldCurrencyTable() {
        if (Objects.equals(NINE_EMERALD_VALUE.get(), NINE_EMERALD_VALUE.getDefault())) {
            return NINE_EMERALD_VALUE.getDefault();
        }
        else {
            return NINE_EMERALD_VALUE.get();
        }
    }
    public static String getEightEmeraldCurrencyTable() {
        if (Objects.equals(EIGHT_EMERALD_VALUE.get(), EIGHT_EMERALD_VALUE.getDefault())) {
            return EIGHT_EMERALD_VALUE.getDefault();
        }
        else {
            return EIGHT_EMERALD_VALUE.get();
        }
    }
    public static String getSevenEmeraldCurrencyTable() {
        if (Objects.equals(SEVEN_EMERALD_VALUE.get(), SEVEN_EMERALD_VALUE.getDefault())) {
            return SEVEN_EMERALD_VALUE.getDefault();
        }
        else {
            return SEVEN_EMERALD_VALUE.get();
        }
    }
    public static String getSixEmeraldCurrencyTable() {
        if (Objects.equals(SIX_EMERALD_VALUE.get(), SIX_EMERALD_VALUE.getDefault())) {
            return SIX_EMERALD_VALUE.getDefault();
        }
        else {
            return SIX_EMERALD_VALUE.get();
        }
    }
    public static String getFiveEmeraldCurrencyTable() {
        if (Objects.equals(FIVE_EMERALD_VALUE.get(), FIVE_EMERALD_VALUE.getDefault())) {
            return FIVE_EMERALD_VALUE.getDefault();
        }
        else {
            return FIVE_EMERALD_VALUE.get();
        }
    }
    public static String getFourEmeraldCurrencyTable() {
        if (Objects.equals(FOUR_EMERALD_VALUE.get(), FOUR_EMERALD_VALUE.getDefault())) {
            return FOUR_EMERALD_VALUE.getDefault();
        }
        else {
            return FOUR_EMERALD_VALUE.get();
        }
    }
    public static String getThreeEmeraldCurrencyTable() {
        if (Objects.equals(THREE_EMERALD_VALUE.get(), THREE_EMERALD_VALUE.getDefault())) {
            return THREE_EMERALD_VALUE.getDefault();
        }
        else {
            return THREE_EMERALD_VALUE.get();
        }
    }
    public static String getTwoEmeraldCurrencyTable() {
        if (Objects.equals(TWO_EMERALD_VALUE.get(), TWO_EMERALD_VALUE.getDefault())) {
            return TWO_EMERALD_VALUE.getDefault();
        }
        else {
            return TWO_EMERALD_VALUE.get();
        }
    }
    public static String getOneEmeraldCurrencyTable() {
        if (Objects.equals(ONE_EMERALD_VALUE.get(), ONE_EMERALD_VALUE.getDefault())) {
            return ONE_EMERALD_VALUE.getDefault();
        }
        else {
            return ONE_EMERALD_VALUE.get();
        }
    }
    // use table trades setting
    public static Boolean getCustomTrades() {
        if (Objects.equals(USE_MOD_TRADES.get(), USE_MOD_TRADES.getDefault())) {
            return USE_MOD_TRADES.getDefault();
        }
        else {
            return USE_MOD_TRADES.get();
        }
    }
    public static int getBaseXP() {
        if (Objects.equals(BASE_TRADE_XP.get(), BASE_TRADE_XP.getDefault())) {
            return BASE_TRADE_XP.getDefault();
        }
        else {
            return BASE_TRADE_XP.get();
        }
    }
}