package com.github.warrentode.todecoins.config;

import com.github.warrentode.todecoins.loot.VillagerTradeLootTables;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> USE_MOD_TRADES;
    public static final ForgeConfigSpec.ConfigValue<Integer> BASE_TRADE_XP;
    public static final ForgeConfigSpec.ConfigValue<Integer> COMMON_MAX_TRADES;
    public static final ForgeConfigSpec.ConfigValue<Integer> RARE_MAX_TRADES;
    public static final ForgeConfigSpec.ConfigValue<Float> COMMON_TRADE_MULTIPLIER;
    public static final ForgeConfigSpec.ConfigValue<Float> RARE_TRADE_MULTIPLIER;
    public static final ForgeConfigSpec.ConfigValue<Boolean> RESET_TRADES_ON_RESTOCK;
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
    public static final ForgeConfigSpec.ConfigValue<String> EQUIPMENT_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTING_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> FIVE_EMERALD_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> TWO_GOLD_POT_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> TWO_GOLD_POT_ITEMS;
    public static final ForgeConfigSpec.ConfigValue<String> FOUR_GOLD_POT_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> FOUR_GOLD_POT_ITEMS;
    public static final ForgeConfigSpec.ConfigValue<String> THIRTY_GOLD_POT_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> THIRTY_GOLD_POT_ITEMS;
    public static final ForgeConfigSpec.ConfigValue<String> SIXTY_GOLD_POT_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> SIXTY_GOLD_POT_ITEMS;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_NOTE_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> LUCKY_COIN_GEMS;
    public static final ForgeConfigSpec.ConfigValue<String> THREE_LUCKY_COIN_ITEMS;
    public static final ForgeConfigSpec.ConfigValue<String> TWENTY_SEVEN_LUCKY_COIN_ITEMS;
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
    public static final ForgeConfigSpec.ConfigValue<Integer> WOOL_TAG_BUY_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> WOOL_TAG_SELL_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WOOL_CARPET_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> WOOL_CARPET_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BED_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> BED_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ASH_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> ASH_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHING_GEAR_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> FISHING_ROD_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> LANTERN_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PAINTINGS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHER_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEATHER_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> INK_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> INK_TAG_BUY_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> INK_TAG_SELL_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> DYE_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> DYE_TAG_BUY_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> DYE_TAG_SELL_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BOOKSHELF_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> GUIDE_BOOK_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> SMALLEST_COIN;
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
    public static final ForgeConfigSpec.ConfigValue<String> ONE_EMERALD_FUEL;
    public static final ForgeConfigSpec.ConfigValue<String> BELL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> FLINT_BUY_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> FLINT_SELL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> ANVIL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> SHEARS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> CLAY_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PAPER_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> BOOK_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> CLOCK_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> COMPASS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> SCUTE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> SADDLE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> STICK_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> STICK_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GRAVEL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> STRING_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> STRING_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FEATHER_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> TRIPWIRE_HOOK_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> FISH_BUCKET_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> CAMPFIRE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> GOLDEN_FOOD_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> MONSTER_PARTS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> GLASS_BOTTLE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> POTION_INGREDIENTS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> EXPERIENCE_BOTTLE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> BLANK_MAP_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> MERCHANT_MAP_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> MERCHANT_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> MERCHANT_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_MAP_1_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_MAP_1_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_MAP_1_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_MAP_2_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_MAP_2_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_MAP_2_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_MAP_3_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_MAP_3_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_MAP_3_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> BANNER_PATTERN_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> ITEM_FRAME_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> SHIELD_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> FLOWER_BUY_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> FLOWER_SELL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> BOTTLED_HONEY_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> HONEY_BLOCK_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> HONEY_COMB_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> CANDLE_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> CANDLE_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BEEHIVE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> BEE_EGG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_CONTAINER_OFFERS;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_OFFERS;
    public static final ForgeConfigSpec.ConfigValue<String> SEED_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> SEED_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SAPLING_SELL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> SLIMEBALL_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> SLIMEBALL_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SAND_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> SAND_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SEASHELL_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> ICE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> SPECIAL_DIRT_BLOCKS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_TRADER_RARE_OFFERS;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_TRADER_COMMON_OFFERS;
    public static final ForgeConfigSpec.ConfigValue<String> CORAL_BLOCK_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> CORAL_BLOCK_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_FRAGMENTS_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> MUSIC_DISC_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> MUSIC_DISC_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> RECYCLABLE_GLASS_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> RECYCLABLE_GLASS_TAG_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWING_TOOLS_TAG_TABLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASSBLOWING_TOOLS_TAG_COUNT;

    static {
        BUILDER.push("Config Settings for TodeCoins");
        USE_MOD_TRADES = BUILDER
                .comment(" Use Trade Tables? Default: false")
                .define("use_trade_tables", false);
        BASE_TRADE_XP = BUILDER
                .comment(" Experience per Trade Level")
                .define("xp_per_level_multiplier", 5);
        COMMON_MAX_TRADES = BUILDER
                .comment(" Max Trades for Common Items")
                .define("common_max_trades", 16);
        COMMON_TRADE_MULTIPLIER = BUILDER
                .comment(" Price Multiplier for Common Items")
                .define("common_trade_multiplier", 0.05F);
        RARE_MAX_TRADES = BUILDER
                .comment(" Max Trades for Rare Items")
                .comment(" Applied to All WANDERING TRADER and todevillagers:retired_trader Rare Trades, Entity Bucket Tag, Enchanted Items, Enchanted Books, NUMISMATIST trades, and LEPRECHAUN Trades")
                .define("rare_max_trades", 3);
        RARE_TRADE_MULTIPLIER = BUILDER
                .comment(" Price Multiplier for Rare Items")
                .comment(" Applied to All Rare Trades, Enchanted Items, Enchanted Books, and LEPRECHAUN Trades")
                .comment("NUMISMATIST Trades have an unchangeable multiplier of 0")
                .define("rare_trade_multiplier", 0.2F);
        RESET_TRADES_ON_RESTOCK = BUILDER
                .comment(" Reset Trades on Restock?")
                .define("reset_trades_on_restock", false);

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
        SEED_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("seed_tag_table",
                        VillagerTradeLootTables.SEED_TAG_TABLE.toString());
        SEED_TAG_COUNT = BUILDER.define("seed_tag_amount", 1);
        SAND_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader, todevillagers:glassblower")
                .define("sand_tag_table",
                        VillagerTradeLootTables.SAND_TAG_TABLE.toString());
        SAND_TAG_COUNT = BUILDER.define("sand_tag_amount", 6);
        RAW_MEAT_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" BUTCHER")
                .define("raw_meat_tag_table",
                        VillagerTradeLootTables.TAGGED_RAW_MEATS_TABLE.toString());
        RAW_MEAT_TAG_COUNT = BUILDER.define("raw_meat_tag_amount", 8);
        COOKED_MEAT_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" BUTCHER")
                .define("cooked_meat_tag_table",
                        VillagerTradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        COOKED_MEAT_TAG_COUNT = BUILDER.define("cooked_meat_tag_amount", 8);
        MEAT_SOUP_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" BUTCHER")
                .define("meat_soup_tag_table",
                        VillagerTradeLootTables.TAGGED_MEAT_SOUPS_TABLE.toString());
        MEAT_SOUP_TAG_COUNT = BUILDER.define("meat_soup_tag_amount", 1);
        VEG_GRAIN_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FARMER")
                .define("vegetable_and_grain_tags_table",
                        VillagerTradeLootTables.TAGGED_VEGGIES_AND_GRAINS_TABLE.toString());
        VEG_GRAIN_TAG_COUNT = BUILDER.define("vegetables_and_grain_tag_amount", 16);
        BREAD_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FARMER")
                .define("bread_tag_table",
                        VillagerTradeLootTables.TAGGED_BREADS_TABLE.toString());
        BREAD_TAG_COUNT = BUILDER.define("bread_tag_amount", 6);
        GOURD_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FARMER")
                .define("gourd_tag_table",
                        VillagerTradeLootTables.TAGGED_GOURDS_TABLE.toString());
        GOURD_TAG_COUNT = BUILDER.define("gourd_tag_amount", 6);
        PIE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FARMER")
                .define("pie_tag_table",
                        VillagerTradeLootTables.TAGGED_PIES_TABLE.toString());
        PIE_TAG_COUNT = BUILDER.define("pie_tag_amount", 4);
        FRUIT_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FARMER")
                .define("fruit_tag_table",
                        VillagerTradeLootTables.TAGGED_FRUITS_TABLE.toString());
        FRUIT_TAG_COUNT = BUILDER.define("fruit_tag_amount", 4);
        COOKIE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FARMER")
                .define("cookie_tag_table",
                        VillagerTradeLootTables.TAGGED_COOKIES_TABLE.toString());
        COOKIE_TAG_COUNT = BUILDER.define("cookie_tag_amount", 18);
        CAKE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FARMER")
                .define("cake_tag_table",
                        VillagerTradeLootTables.TAGGED_CAKES_TABLE.toString());
        CAKE_TAG_COUNT = BUILDER.define("cake_tag_amount", 1);
        PREPPED_SEAFOOD_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FISHERMAN")
                .define("prepared_seafood_tag_table",
                        VillagerTradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE.toString());
        PREPPED_SEAFOOD_TAG_COUNT = BUILDER.define("prepared_seafood_tag_amount", 6);
        RAW_SEAFOOD_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FISHERMAN")
                .define("raw_seafood_tag_table",
                        VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        RAW_SEAFOOD_TAG_COUNT = BUILDER.define("raw_seafood_tag_amount", 8);
        GLASS_PANE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" CARTOGRAPHER, todevillagers:glassblower")
                .define("glass_pane_tag_table",
                        VillagerTradeLootTables.TAGGED_GLASS_PANES_TABLE.toString());
        GLASS_PANE_TAG_COUNT = BUILDER.define("glass_pane_tag_amount", 11);
        GLASS_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" LIBRARIAN")
                .comment(" Available on LIBRARIAN if TodeVillagers mod is not loaded, todevillagers:glass")
                .define("glass_tag_table",
                        VillagerTradeLootTables.TAGGED_GLASS_PANES_TABLE.toString());
        GLASS_TAG_COUNT = BUILDER.define("glass_tag_amount", 4);
        BANNER_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" SHEPHERD, CARTOGRAPHER")
                .define("banner_tag_table",
                        VillagerTradeLootTables.TAGGED_BANNER_TABLE.toString());
        BANNER_TAG_COUNT = BUILDER.define("banner_tag_amount", 1);
        WOOL_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" SHEPHERD")
                .define("wool_tag_table",
                        VillagerTradeLootTables.TAGGED_WOOL_TABLE.toString());
        WOOL_TAG_BUY_COUNT = BUILDER.define("wool_tag_buy_amount", 18);
        WOOL_TAG_SELL_COUNT = BUILDER.define("wool_tag_sell_amount", 1);
        WOOL_CARPET_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" SHEPHERD")
                .define("wool_carpet_tag_table",
                        VillagerTradeLootTables.TAGGED_WOOL_CARPETS_TABLE.toString());
        WOOL_CARPET_TAG_COUNT = BUILDER.define("wool_carpet_tag_amount", 4);
        SHEARS_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" SHEPHERD, friendsandfoes:beekeeper")
                .define("shears_table",
                        VillagerTradeLootTables.SHEARS_TABLE.toString());
        BED_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" SHEPHERD")
                .define("bed_tag_table",
                        VillagerTradeLootTables.TAGGED_BEDS_TABLE.toString());
        BED_TAG_COUNT = BUILDER.define("bed_tag_amount", 1);
        LEATHER_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" LEATHERWORKER")
                .define("leather_tag_table",
                        VillagerTradeLootTables.TAGGED_LEATHER_TABLE.toString());
        LEATHER_TAG_COUNT = BUILDER.define("leather_tag_amount", 6);
        INK_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" LIBRARIAN")
                .define("ink_tag_table",
                        VillagerTradeLootTables.TAGGED_INK_TABLE.toString());
        INK_TAG_BUY_COUNT = BUILDER.define("ink_tag_buy_amount", 5);
        INK_TAG_SELL_COUNT = BUILDER.define("ink_tag_sell_amount", 2);
        DYE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" SHEPHERD, WANDERING TRADER")
                .define("dye_tag_table",
                        VillagerTradeLootTables.TAGGED_DYES_TABLE.toString());
        DYE_TAG_BUY_COUNT = BUILDER.define("dye_tag_buy_amount", 12);
        DYE_TAG_SELL_COUNT = BUILDER.define("dye_tag_sell_amount", 3);
        SALT_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" BUTCHER")
                .comment(" Trade Unlocked with either Salt mod or Turtle Block Academy mod Loaded")
                .define("salt_tag_table",
                        VillagerTradeLootTables.TAGGED_SALTS_TABLE.toString());
        SALT_TAG_COUNT = BUILDER.define("salt_tag_amount", 8);
        ASH_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" ARMORER, BUTCHER, WEAPONSMITH, TOOLSMITH, FISHERMAN")
                .comment(" Trade Unlocked with either Supplementaries mod or Turtle Block Academy mod Loaded")
                .define("ash_tag_table",
                        VillagerTradeLootTables.TAGGED_ASH_TABLE.toString());
        ASH_TAG_COUNT = BUILDER.define("ash_tag_amount", 8);
        QUIVER_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" Trade Unlocked with Supplementaries mod Loaded")
                .comment(" FLETCHER")
                .define("quiver_tag_table",
                        VillagerTradeLootTables.TAGGED_QUIVERS_TABLE.toString());
        QUIVER_TAG_COUNT = BUILDER.define("quiver_tag_amount", 1);
        STICK_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FLETCHER")
                .define("stick_tag_table",
                        VillagerTradeLootTables.TAGGED_STICK_TABLE.toString());
        STICK_TAG_COUNT = BUILDER.define("stick_tag_amount", 32);
        STRING_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FLETCHER, FISHERMAN, friendsandfoes:beekeeper")
                .define("string_tag_table",
                        VillagerTradeLootTables.TAGGED_STRING_TABLE.toString());
        STRING_TAG_COUNT = BUILDER.define("string_tag_amount", 14);
        CANDLE_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" friendsandfoes:beekeeper")
                .define("candle_tag_table",
                        VillagerTradeLootTables.TAGGED_CANDLE_TABLE.toString());
        CANDLE_TAG_COUNT = BUILDER.define("candle_tag_amount", 4);
        RECYCLABLE_GLASS_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" todevillagers:glassblower")
                .define("recyclable_glass_tag_table",
                        VillagerTradeLootTables.RECYCLABLE_GLASS_TAG_TABLE.toString());
        RECYCLABLE_GLASS_TAG_COUNT = BUILDER.define("recyclable_glass_tag_amount", 4);
        CORAL_BLOCK_TAG_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("coral_block_tag_table",
                        VillagerTradeLootTables.CORAL_BLOCK_TAG_TABLE.toString());
        CORAL_BLOCK_TAG_COUNT = BUILDER.define("coral_block_tag_amount", 1);

        SLIMEBALL_TAG_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("slimeball_tag_table",
                        VillagerTradeLootTables.SLIMEBALL_TAG_TABLE.toString());
        SLIMEBALL_TAG_COUNT = BUILDER
                .define("slimeball_tag_count", 1);

        GLASSBLOWING_TOOLS_TAG_TABLE = BUILDER
                .comment(" 6 Emerald Value")
                .comment(" todevillagers:glassblower")
                .define("glassblowing_tools_tag_table",
                        VillagerTradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE.toString());
        GLASSBLOWING_TOOLS_TAG_COUNT = BUILDER.define("glassblowing_tools_tag_amount", 1);

        MUSIC_DISC_TAG_TABLE = BUILDER
                .comment(" 26 Emerald Value")
                .comment(" todevillagers:disc_jockey")
                .define("music_disc_tag_table",
                        VillagerTradeLootTables.MUSIC_DISC_TAG_TABLE.toString());
        MUSIC_DISC_TAG_COUNT = BUILDER
                .define("music_disc_tag_count", 1);

        BUILDER.pop();

        BUILDER.push("Item Loot Tables for Trades");
        GUIDE_BOOK_TABLE = BUILDER
                .comment(" 1 Copper Coin Value")
                .comment(" LIBRARIAN")
                .comment(" Unlocked with Patchouli mod Loaded")
                .define("guide_book_table",
                        VillagerTradeLootTables.GUIDE_BOOKS_TABLE.toString());
        SMALLEST_COIN = BUILDER
                .comment(" 1 Copper Coin Value")
                .comment(" LIBRARIAN")
                .comment(" Guide Book Price")
                .define("smallest_coin",
                        VillagerTradeLootTables.SMALLEST_COIN.toString());
        PAPER_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" LIBRARIAN, CARTOGRAPHER")
                .define("paper_table",
                        VillagerTradeLootTables.PAPER_TABLE.toString());
        BOOK_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" LIBRARIAN")
                .define("book_table",
                        VillagerTradeLootTables.BOOK_TABLE.toString());
        ONE_EMERALD_METALS = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WEAPONSMITH, TOOLSMITH, ARMORER, CLERIC")
                .define("one_emerald_metals",
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        EQUIPMENT_GEMS = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WEAPONSMITH, ARMORER")
                .define("equipment_gems",
                        VillagerTradeLootTables.EQUIPMENT_GEMS_TABLE.toString());
        ENCHANTING_GEMS = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" CLERIC")
                .define("enchanting_gems",
                        VillagerTradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        ONE_EMERALD_GEMS = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" MASON, BANKER, todevillagers:disc_jockey")
                .define("one_emerald_gems",
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        ONE_EMERALD_FUEL = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" ARMORER, FISHERMAN, BUTCHER, TOOLSMITH, WEAPONSMITH, todevillagers:glassblower")
                .define("one_emerald_fuel",
                        VillagerTradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        FISHING_GEAR_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FISHERMAN")
                .define("fishing_gear_table",
                        VillagerTradeLootTables.FISHING_GEAR_TABLE.toString());
        FISHING_ROD_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FISHERMAN")
                .define("fishing_rod_table",
                        VillagerTradeLootTables.FISHING_ROD_TABLE.toString());
        LANTERN_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" LIBRARIAN")
                .define("lantern_table",
                        VillagerTradeLootTables.LANTERN_TABLE.toString());
        OVERWORLD_BRICK_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" MASON")
                .define("overworld_brick_table",
                        VillagerTradeLootTables.OVERWORLD_BRICK_TABLE.toString());
        OVERWORLD_BRICK_BLOCK_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" MASON")
                .define("overworld_brick_block_table",
                        VillagerTradeLootTables.OVERWORLD_BRICK_BLOCKS_TABLE.toString());
        OVERWORLD_STONE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" MASON")
                .define("overworld_stone_table",
                        VillagerTradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE.toString());
        OVERWORLD_POLISHED_STONE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" MASON")
                .define("overworld_polished_stone_table",
                        VillagerTradeLootTables.OVERWORLD_POLISHED_STONE_TABLE.toString());
        OTHER_STONE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" MASON")
                .define("overworld_polished_stone_table",
                        VillagerTradeLootTables.OVERWORLD_POLISHED_STONE_TABLE.toString());
        TERRACOTTA_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" MASON")
                .define("terracotta_table",
                        VillagerTradeLootTables.TERRACOTTA_BLOCKS_TABLE.toString());
        GLAZED_TERRACOTTA_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" MASON")
                .define("glazed_terracotta_table",
                        VillagerTradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE.toString());
        CLAY_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" MASON")
                .define("clay_table",
                        VillagerTradeLootTables.CLAY_TABLE.toString());
        STONE_KNIFE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" TOOLSMITH")
                .comment(" Trade Unlocked with Farmers Delight mod Loaded")
                .define("stone_tier_knife_table",
                        VillagerTradeLootTables.STONE_TIER_KNIVES.toString());
        STONE_TOOL_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" TOOLSMITH")
                .define("stone_tier_tools_table",
                        VillagerTradeLootTables.STONE_TIER_TOOLS_TABLE.toString());
        CHAINMAIL_HELMET_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" ARMORER")
                .define("chainmail_tier_helmets_table",
                        VillagerTradeLootTables.CHAINMAIL_TIER_HELMETS_TABLE.toString());
        CHAINMAIL_BOOTS_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" ARMORER")
                .define("chainmail_tier_boots_table",
                        VillagerTradeLootTables.CHAINMAIL_TIER_BOOTS_TABLE.toString());
        FLINT_BUY_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WEAPONSMITH, TOOLSMITH, LEATHERWORKER, FLETCHER")
                .define("flint_buy_table",
                        VillagerTradeLootTables.FLINT_BUY_TABLE.toString());
        FLINT_SELL_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FLETCHER")
                .define("flint_sell_table",
                        VillagerTradeLootTables.FLINT_SELL_TABLE.toString());
        SCUTE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" CLERIC, LEATHERWORKER")
                .define("scute_table",
                        VillagerTradeLootTables.SCUTE_TABLE.toString());
        GRAVEL_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FLETCHER")
                .define("gravel_table",
                        VillagerTradeLootTables.GRAVEL_TABLE.toString());
        FEATHER_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FLETCHER")
                .define("feather_table",
                        VillagerTradeLootTables.FEATHER_TABLE.toString());
        TRIPWIRE_HOOK_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" FLETCHER")
                .define("tripwire_hook_table",
                        VillagerTradeLootTables.TRIPWIRE_HOOK_TABLE.toString());
        MONSTER_PARTS_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" CLERIC")
                .define("mob_parts_table",
                        VillagerTradeLootTables.MOB_PARTS_TABLE.toString());
        GLASS_BOTTLE_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" CLERIC, friendsandfoes:beekeeper, todevillagers:glassblower")
                .define("glass_bottle_table",
                        VillagerTradeLootTables.GLASS_BOTTLE_TABLE.toString());
        POTION_INGREDIENTS_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" CLERIC")
                .define("potion_ingredients_table",
                        VillagerTradeLootTables.POTION_INGREDIENTS_TABLE.toString());
        FLOWER_BUY_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" friendsandfoes:beekeeper")
                .define("flower_buy_table",
                        VillagerTradeLootTables.FLOWER_BUY_TABLE.toString());
        FLOWER_SELL_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("flower_sell_table",
                        VillagerTradeLootTables.FLOWER_SELL_TABLE.toString());
        BOTTLED_HONEY_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" friendsandfoes:beekeeper")
                .define("bottled_honey_table",
                        VillagerTradeLootTables.BOTTLED_HONEY_TABLE.toString());
        HONEY_BLOCK_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" friendsandfoes:beekeeper")
                .define("honey_block_table",
                        VillagerTradeLootTables.HONEY_BLOCK_TABLE.toString());
        HONEY_COMB_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" friendsandfoes:beekeeper")
                .define("honey_comb_table",
                        VillagerTradeLootTables.HONEY_COMB_TABLE.toString());
        SPECIAL_DIRT_BLOCKS_TABLE = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("special_dirt_blocks_table",
                        VillagerTradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        WANDERING_TRADER_COMMON_OFFERS = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("wandering_trader_common_offers",
                        VillagerTradeLootTables.WANDERING_TRADER_COMMON_OFFERS.toString());
        WANDERING_TRADER_RARE_OFFERS = BUILDER
                .comment(" 1 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("wandering_trader_rare_offers",
                        VillagerTradeLootTables.WANDERING_TRADER_RARE_OFFERS.toString());

        PAINTINGS_TABLE = BUILDER
                .comment(" 2 Emerald Value")
                .comment(" SHEPHERD")
                .define("paintings_table",
                        VillagerTradeLootTables.PAINTINGS_TABLE.toString());
        CAMPFIRE_TABLE = BUILDER
                .comment(" 2 Emerald Value")
                .comment(" FISHERMAN")
                .define("campfire_table",
                        VillagerTradeLootTables.CAMPFIRE_TABLE.toString());

        IRON_TOOL_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" Enchanted: 20 Emerald Value")
                .comment(" TOOLSMITH")
                .define("iron_tier_tools_table",
                        VillagerTradeLootTables.IRON_TIER_TOOLS_TABLE.toString());
        IRON_WEAPON_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" Enchanted: 20 Emerald Value")
                .comment(" WEAPONSMITH")
                .define("iron_tier_weapons_table",
                        VillagerTradeLootTables.IRON_TIER_WEAPONS_TABLE.toString());
        LEATHER_HELMET_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" LEATHERWORKER")
                .define("leather_tier_helmets_table",
                        VillagerTradeLootTables.LEATHER_TIER_HELMETS_TABLE.toString());
        CHAINMAIL_LEGGINGS_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" ARMORER")
                .define("chainmail_tier_leggings_table",
                        VillagerTradeLootTables.CHAINMAIL_TIER_LEGGINGS_TABLE.toString());
        TWO_GOLD_POT_GEMS = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("two_gold_pot_gems",
                        VillagerTradeLootTables.TWO_POT_OF_GOLD_VALUE_GEMS.toString());
        TWO_GOLD_POT_ITEMS = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("two_gold_pot_items",
                        VillagerTradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS.toString());
        BOWS_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" Enchanted: 7 Emerald Value")
                .comment(" FLETCHER")
                .define("bows_and_crossbows_table",
                        VillagerTradeLootTables.BOWS_TABLE.toString());
        FISH_BUCKET_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" FISHERMAN")
                .define("fish_bucket_table",
                        VillagerTradeLootTables.FISH_BUCKET_TABLE.toString());
        EXPERIENCE_BOTTLE_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" CLERIC")
                .define("experience_bottle_table",
                        VillagerTradeLootTables.EXPERIENCE_BOTTLE_TABLE.toString());
        DISC_FRAGMENTS_TABLE = BUILDER
                .comment(" 3 Emerald Value")
                .comment(" todevillagers:disc_jockey")
                .define("disc_fragments_table",
                        VillagerTradeLootTables.DISC_FRAGMENTS_TABLE.toString());

        DIAMOND_TOOL_TABLE = BUILDER
                .comment(" 4 Emerald Value")
                .comment(" Enchanted: 26 Emerald Value")
                .comment(" TOOLSMITH")
                .define("diamond_tier_tools_table",
                        VillagerTradeLootTables.DIAMOND_TIER_TOOLS_TABLE.toString());
        CHAINMAIL_CHESTPLATE_TABLE = BUILDER
                .comment(" 4 Emerald Value")
                .comment(" ARMORER")
                .define("chainmail_tier_chestplate_table",
                        VillagerTradeLootTables.CHAINMAIL_TIER_CHESTPLATES_TABLE.toString());
        LEATHER_BOOTS_TABLE = BUILDER
                .comment(" 4 Emerald Value")
                .comment(" LEATHERWORKER")
                .define("leather_tier_boots_table",
                        VillagerTradeLootTables.LEATHER_TIER_BOOTS_TABLE.toString());
        IRON_BOOTS_TABLE = BUILDER
                .comment(" 4 Emerald Value")
                .comment(" ARMORER")
                .define("iron_tier_boots_table",
                        VillagerTradeLootTables.IRON_TIER_BOOTS_TABLE.toString());
        COMPASS_TABLE = BUILDER
                .comment(" 4 Emerald Value")
                .comment(" LIBRARIAN, CARTOGRAPHER, NUMISMATIST")
                .define("compass_table",
                        VillagerTradeLootTables.COMPASS_TABLE.toString());

        FIVE_EMERALD_GEMS = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" CLERIC")
                .define("five_emerald_gems",
                        VillagerTradeLootTables.FIVE_EMERALD_VALUE_GEMS.toString());
        LEATHER_LEGGINGS_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" LEATHERWORKER")
                .define("leather_tier_leggings_table",
                        VillagerTradeLootTables.LEATHER_TIER_LEGGINGS_TABLE.toString());
        IRON_HELMET_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" ARMORER")
                .define("iron_tier_helmets_table",
                        VillagerTradeLootTables.IRON_TIER_HELMETS_TABLE.toString());
        CLOCK_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" LIBRARIAN")
                .define("clock_table",
                        VillagerTradeLootTables.CLOCK_TABLE.toString());
        GOLDEN_FOOD_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" FARMER")
                .define("golden_food_table",
                        VillagerTradeLootTables.GOLDEN_FOOD_TABLE.toString());
        SHIELD_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" ARMORER")
                .define("shield_table",
                        VillagerTradeLootTables.SHIELD_TABLE.toString());
        BEEHIVE_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" friendsandfoes:beekeeper")
                .define("beehive_table",
                        VillagerTradeLootTables.BEEHIVE_TABLE.toString());
        BEE_EGG_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" friendsandfoes:beekeeper")
                .define("bee_egg_table",
                        VillagerTradeLootTables.BEE_EGG_TABLE.toString());
        SEASHELL_TABLE = BUILDER
                .comment(" 5 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("seashell_table",
                        VillagerTradeLootTables.SEASHELL_TABLE.toString());

        FOUR_GOLD_POT_GEMS = BUILDER
                .comment(" 6 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("four_gold_pot_gems",
                        VillagerTradeLootTables.FOUR_POT_OF_GOLD_VALUE_GEMS.toString());
        FOUR_GOLD_POT_ITEMS = BUILDER
                .comment(" 6 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("four_gold_pot_items",
                        VillagerTradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS.toString());
        LEATHER_HORSE_ARMOR_TABLE = BUILDER
                .comment(" 6 Emerald Value")
                .comment(" LEATHERWORKER")
                .define("leather_tier_horse_armor",
                        VillagerTradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE.toString());
        SADDLE_TABLE = BUILDER
                .comment(" 6 Emerald Value")
                .comment(" LEATHERWORKER")
                .define("saddle_table",
                        VillagerTradeLootTables.SADDLE_TABLE.toString());
        SAPLING_SELL_TABLE = BUILDER
                .comment(" 6 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("sapling_sell_table",
                        VillagerTradeLootTables.SAPLING_SELL_TABLE.toString());
        ICE_TABLE = BUILDER
                .comment(" 6 Emerald Value")
                .comment(" WANDERING TRADER, todevillagers:retired_trader")
                .define("ice_table",
                        VillagerTradeLootTables.ICE_TABLE.toString());

        LEATHER_CHESTPLATE_TABLE = BUILDER
                .comment(" 7 Emerald Value")
                .comment(" LEATHERWORKER")
                .define("leather_tier_chestplates_table",
                        VillagerTradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE.toString());
        IRON_LEGGINGS_TABLE = BUILDER
                .comment(" 7 Emerald Value")
                .comment(" ARMORER")
                .define("iron_tier_leggings_table",
                        VillagerTradeLootTables.IRON_TIER_LEGGINGS_TABLE.toString());
        BLANK_MAP_TABLE = BUILDER
                .comment(" 7 Emerald Value")
                .comment(" CARTOGRAPHER")
                .define("blank_map_table",
                        VillagerTradeLootTables.BLANK_MAP_TABLE.toString());
        ITEM_FRAME_TABLE = BUILDER
                .comment(" 7 Emerald Value")
                .comment(" CARTOGRAPHER")
                .define("item_frame_table",
                        VillagerTradeLootTables.ITEM_FRAME_TABLE.toString());

        ANVIL_TABLE = BUILDER
                .comment(" 8 Emerald Value")
                .comment(" WEAPONSMITH")
                .define("anvil_table",
                        VillagerTradeLootTables.ANVIL_TABLE.toString());
        BANNER_PATTERN_TABLE = BUILDER
                .comment(" 8 Emerald Value")
                .comment(" CARTOGRAPHER")
                .define("banner_pattern_table",
                        VillagerTradeLootTables.BANNER_PATTERN_TABLE.toString());

        BOOKSHELF_TABLE = BUILDER
                .comment(" 9 Emerald Value")
                .comment(" LIBRARIAN")
                .define("bookshelf_table",
                        VillagerTradeLootTables.BOOKSHELF_TABLE.toString());
        IRON_HORSE_ARMOR_TABLE = BUILDER
                .comment(" 9 Emerald Value")
                .comment(" ARMORER")
                .define("iron_tier_horse_armor",
                        VillagerTradeLootTables.IRON_TIER_HORSE_ARMOR_TABLE.toString());
        IRON_CHESTPLATE_TABLE = BUILDER
                .comment(" 9 Emerald Value")
                .comment(" ARMORER")
                .define("iron_tier_chestplates_table",
                        VillagerTradeLootTables.IRON_TIER_CHESTPLATES_TABLE.toString());

        GOLD_TOOL_TABLE = BUILDER
                .comment(" 20 Emerald Value")
                .comment(" TOOLSMITH")
                .define("gold_tier_tools_table",
                        VillagerTradeLootTables.GOLD_TIER_TOOLS_TABLE.toString());
        GOLD_WEAPON_TABLE = BUILDER
                .comment(" 20 Emerald Value")
                .comment(" WEAPONSMITH")
                .define("gold_tier_weapons_table",
                        VillagerTradeLootTables.GOLD_TIER_WEAPONS_TABLE.toString());
        DIAMOND_HELMET_TABLE = BUILDER
                .comment(" 20 Emerald Value")
                .comment(" ARMORER")
                .define("diamond_tier_helmets_table",
                        VillagerTradeLootTables.DIAMOND_TIER_HELMETS_TABLE.toString());
        DIAMOND_BOOTS_TABLE = BUILDER
                .comment(" 20 Emerald Value")
                .comment(" ARMORER")
                .define("diamond_tier_boots_table",
                        VillagerTradeLootTables.DIAMOND_TIER_BOOTS_TABLE.toString());

        DIAMOND_CHESTPLATE_TABLE = BUILDER
                .comment(" 26 Emerald Value")
                .comment(" ARMORER")
                .define("diamond_tier_chestplates_table",
                        VillagerTradeLootTables.DIAMOND_TIER_CHESTPLATES_TABLE.toString());
        DIAMOND_LEGGINGS_TABLE = BUILDER
                .comment(" 26 Emerald Value")
                .comment(" ARMORER")
                .define("diamond_tier_leggings_table",
                        VillagerTradeLootTables.DIAMOND_TIER_LEGGINGS_TABLE.toString());
        DIAMOND_WEAPON_TABLE = BUILDER
                .comment(" 26 Emerald Value")
                .comment(" WEAPONSMITH")
                .define("diamond_tier_weapons_table",
                        VillagerTradeLootTables.DIAMOND_TIER_WEAPONS_TABLE.toString());

        BELL_TABLE = BUILDER
                .comment(" 36 Emerald Value")
                .comment(" ARMORER, WEAPONSMITH, TOOLSMITH")
                .define("bell_table",
                        VillagerTradeLootTables.BELL_TABLE.toString());

        THIRTY_GOLD_POT_GEMS = BUILDER
                .comment(" 45 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("thirty_gold_pot_gems",
                        VillagerTradeLootTables.THIRTY_POT_OF_GOLD_VALUE_GEMS.toString());
        THIRTY_GOLD_POT_ITEMS = BUILDER
                .comment(" 45 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("thirty_gold_pot_items",
                        VillagerTradeLootTables.THIRTY_POT_OF_GOLD_VALUE_ITEMS.toString());

        EMERALD_NOTE_METALS = BUILDER
                .comment(" 64 Emerald Value")
                .comment(" BANKER")
                .define("emerald_bank_note_metals",
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_METALS.toString());
        EMERALD_NOTE_GEMS = BUILDER
                .comment(" 64 Emerald Value")
                .comment(" BANKER")
                .define("emerald_bank_note_gems",
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_GEMS.toString());

        SIXTY_GOLD_POT_GEMS = BUILDER
                .comment(" 90 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("sixty_gold_pot_gems",
                        VillagerTradeLootTables.SIXTY_POT_OF_GOLD_VALUE_GEMS.toString());
        SIXTY_GOLD_POT_ITEMS = BUILDER
                .comment(" 90 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("sixty_gold_pot_items",
                        VillagerTradeLootTables.SIXTY_POT_OF_GOLD_VALUE_GEMS.toString());

        LUCKY_COIN_GEMS = BUILDER
                .comment(" 192 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("lucky_coin_gems",
                        VillagerTradeLootTables.SINGLE_LUCKY_COIN_VALUE_GEMS.toString());
        THREE_LUCKY_COIN_ITEMS = BUILDER
                .comment(" 576 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("three_lucky_coin_items",
                        VillagerTradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS.toString());
        NETHERITE_TOOL_TABLE = BUILDER
                .comment(" 9 Lucky Coin Value")
                .comment(" TOOLSMITH")
                .define("netherite_tier_tools_table",
                        VillagerTradeLootTables.NETHERITE_TIER_TOOLS_TABLE.toString());
        NETHERITE_WEAPON_TABLE = BUILDER
                .comment(" WEAPONSMITH")
                .comment(" 9 Lucky Coin Value")
                .define("netherite_tier_weapons_table",
                        VillagerTradeLootTables.NETHERITE_TIER_WEAPONS_TABLE.toString());
        TWENTY_SEVEN_LUCKY_COIN_ITEMS = BUILDER
                .comment(" 576 Emerald Value")
                .comment(" LEPRECHAUN")
                .define("twenty_seven_lucky_coin_items",
                        VillagerTradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS.toString());

        NUMISMATIST_CONTAINER_OFFERS = BUILDER
                .comment(" 2 Collectible Coin Value")
                .comment(" NUMISMATIST")
                .define("numismatist_container_table",
                        VillagerTradeLootTables.NUMISMATIST_CONTAINER_OFFERS.toString());
        NUMISMATIST_RARE_OFFERS = BUILDER
                .comment(" 2 Collectible Coin Value")
                .comment(" NUMISMATIST")
                .define("numismatist_rare_offer_table",
                        VillagerTradeLootTables.NUMISMATIST_RARE_OFFERS.toString());
        BUILDER.pop();

        BUILDER.push("Structure Map Configs");
        MERCHANT_MAP_STRUCTURE_TAG = BUILDER
                .comment(" NUMISMATIST")
                .define("merchant_map_structure_tag",
                        ForgeTags.StructureTags.ON_VILLAGE_EXPLORER_MAPS.location().toString());
        MERCHANT_MAP_NAME = BUILDER
                .comment(" NUMISMATIST")
                .define("merchant_map_name",
                        "Merchant Map");
        MERCHANT_MAP_MARKER = BUILDER
                .comment(" NUMISMATIST")
                .define("merchant_map_marker",
                        MapDecoration.Type.MANSION.toString());
        CARTOGRAPHER_MAP_1_STRUCTURE_TAG = BUILDER
                .comment(" CARTOGRAPHER")
                .define("cartographer_map_1_structure_tag",
                        ForgeTags.StructureTags.OVERWORLD_POI.location().toString()
                        );
        CARTOGRAPHER_MAP_1_NAME = BUILDER
                .comment(" CARTOGRAPHER")
                .define("cartographer_map_1_name",
                        "Overworld Exploration Map");
        CARTOGRAPHER_MAP_1_MARKER = BUILDER
                .comment(" CARTOGRAPHER")
                .define("cartographer_map_1_marker",
                        MapDecoration.Type.TARGET_POINT.toString());
        CARTOGRAPHER_MAP_2_STRUCTURE_TAG = BUILDER
                .comment(" CARTOGRAPHER")
                .define("cartographer_map_2_structure_tag",
                        ForgeTags.StructureTags.OVERWORLD_POI.location().toString());
        CARTOGRAPHER_MAP_2_NAME = BUILDER
                .comment(" CARTOGRAPHER")
                .define("cartographer_map_2_name",
                        "Overworld Exploration Map");
        CARTOGRAPHER_MAP_2_MARKER = BUILDER
                .comment(" CARTOGRAPHER")
                .define("cartographer_map_2_marker",
                        MapDecoration.Type.TARGET_POINT.toString());
        CARTOGRAPHER_MAP_3_STRUCTURE_TAG = BUILDER
                .comment(" CARTOGRAPHER")
                .define("cartographer_map_2_structure_tag",
                        ForgeTags.StructureTags.OVERWORLD_POI.location().toString());
        CARTOGRAPHER_MAP_3_NAME = BUILDER
                .comment(" CARTOGRAPHER")
                .define("cartographer_map_2_name",
                        "Overworld Exploration Map");
        CARTOGRAPHER_MAP_3_MARKER = BUILDER
                .comment(" CARTOGRAPHER")
                .define("cartographer_map_2_marker",
                        MapDecoration.Type.TARGET_POINT.toString());
        BUILDER.pop();

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static @NotNull TagKey<Structure> getStructureTag(String structureTag) {
        ResourceLocation structureTagLocation = ResourceLocation.tryParse(structureTag);
        if (structureTagLocation != null) {
            return ForgeTags.forgeStructureTag(structureTagLocation.getNamespace(), structureTagLocation.getPath());
        }
        else return ForgeTags.StructureTags.OVERWORLD_POI;
    }

    // map configs
    public static String getMerchantMapStructureTag() {
        if (Objects.equals(MERCHANT_MAP_STRUCTURE_TAG.get(), MERCHANT_MAP_STRUCTURE_TAG.getDefault())) {
            return MERCHANT_MAP_STRUCTURE_TAG.getDefault();
        }
        else {
            return MERCHANT_MAP_STRUCTURE_TAG.get();
        }
    }
    public static String getMerchantMapName() {
        if (Objects.equals(MERCHANT_MAP_NAME.get(), MERCHANT_MAP_NAME.getDefault())) {
            return MERCHANT_MAP_NAME.getDefault();
        }
        else {
            return MERCHANT_MAP_NAME.get();
        }
    }
    public static String getMerchantMapMarker() {
        if (Objects.equals(MERCHANT_MAP_MARKER.get(), MERCHANT_MAP_MARKER.getDefault())) {
            return MERCHANT_MAP_MARKER.getDefault();
        }
        else {
            return MERCHANT_MAP_MARKER.get();
        }
    }
    public static String getCartographerMap1StructureTag() {
        if (Objects.equals(CARTOGRAPHER_MAP_1_STRUCTURE_TAG.get(), CARTOGRAPHER_MAP_1_STRUCTURE_TAG.getDefault())) {
            return CARTOGRAPHER_MAP_1_STRUCTURE_TAG.getDefault();
        }
        else {
            return CARTOGRAPHER_MAP_1_STRUCTURE_TAG.get();
        }
    }
    public static String getCartographerMap1Name() {
        if (Objects.equals(CARTOGRAPHER_MAP_1_NAME.get(), CARTOGRAPHER_MAP_1_NAME.getDefault())) {
            return CARTOGRAPHER_MAP_1_NAME.getDefault();
        }
        else {
            return CARTOGRAPHER_MAP_1_NAME.get();
        }
    }
    public static String getCartographerMap1Marker() {
        if (Objects.equals(CARTOGRAPHER_MAP_1_MARKER.get(), CARTOGRAPHER_MAP_1_MARKER.getDefault())) {
            return CARTOGRAPHER_MAP_1_MARKER.getDefault();
        }
        else {
            return CARTOGRAPHER_MAP_1_MARKER.get();
        }
    }
    public static String getCartographerMap2StructureTag() {
        if (Objects.equals(CARTOGRAPHER_MAP_2_STRUCTURE_TAG.get(), CARTOGRAPHER_MAP_2_STRUCTURE_TAG.getDefault())) {
            return CARTOGRAPHER_MAP_2_STRUCTURE_TAG.getDefault();
        }
        else {
            return CARTOGRAPHER_MAP_2_STRUCTURE_TAG.get();
        }
    }
    public static String getCartographerMap2Name() {
        if (Objects.equals(CARTOGRAPHER_MAP_2_NAME.get(), CARTOGRAPHER_MAP_2_NAME.getDefault())) {
            return CARTOGRAPHER_MAP_2_NAME.getDefault();
        }
        else {
            return CARTOGRAPHER_MAP_2_NAME.get();
        }
    }
    public static String getCartographerMap2Marker() {
        if (Objects.equals(CARTOGRAPHER_MAP_2_MARKER.get(), CARTOGRAPHER_MAP_2_MARKER.getDefault())) {
            return CARTOGRAPHER_MAP_2_MARKER.getDefault();
        }
        else {
            return CARTOGRAPHER_MAP_2_MARKER.get();
        }
    }
    public static String getCartographerMap3StructureTag() {
        if (Objects.equals(CARTOGRAPHER_MAP_3_STRUCTURE_TAG.get(), CARTOGRAPHER_MAP_3_STRUCTURE_TAG.getDefault())) {
            return CARTOGRAPHER_MAP_3_STRUCTURE_TAG.getDefault();
        }
        else {
            return CARTOGRAPHER_MAP_3_STRUCTURE_TAG.get();
        }
    }
    public static String getCartographerMap3Name() {
        if (Objects.equals(CARTOGRAPHER_MAP_3_NAME.get(), CARTOGRAPHER_MAP_3_NAME.getDefault())) {
            return CARTOGRAPHER_MAP_3_NAME.getDefault();
        }
        else {
            return CARTOGRAPHER_MAP_3_NAME.get();
        }
    }
    public static String getCartographerMap3Marker() {
        if (Objects.equals(CARTOGRAPHER_MAP_3_MARKER.get(), CARTOGRAPHER_MAP_3_MARKER.getDefault())) {
            return CARTOGRAPHER_MAP_3_MARKER.getDefault();
        }
        else {
            return CARTOGRAPHER_MAP_3_MARKER.get();
        }
    }
    // item loot tables
    public static String getWanderingTraderCommonOffersTable() {
        if (Objects.equals(WANDERING_TRADER_COMMON_OFFERS.get(),
                WANDERING_TRADER_COMMON_OFFERS.getDefault())) {
            return WANDERING_TRADER_COMMON_OFFERS.getDefault();
        }
        else {
            return WANDERING_TRADER_COMMON_OFFERS.get();
        }
    }
    public static String getWanderingTraderRareOffersTable() {
        if (Objects.equals(WANDERING_TRADER_RARE_OFFERS.get(), WANDERING_TRADER_RARE_OFFERS.getDefault())) {
            return WANDERING_TRADER_RARE_OFFERS.getDefault();
        }
        else {
            return WANDERING_TRADER_RARE_OFFERS.get();
        }
    }
    public static String getNumismatistRareOfferTable() {
        if (Objects.equals(NUMISMATIST_RARE_OFFERS.get(), NUMISMATIST_RARE_OFFERS.getDefault())) {
            return NUMISMATIST_RARE_OFFERS.getDefault();
        }
        else {
            return NUMISMATIST_RARE_OFFERS.get();
        }
    }
    public static String getNumismatistContainerTable() {
        if (Objects.equals(NUMISMATIST_CONTAINER_OFFERS.get(), NUMISMATIST_CONTAINER_OFFERS.getDefault())) {
            return NUMISMATIST_CONTAINER_OFFERS.getDefault();
        }
        else {
            return NUMISMATIST_CONTAINER_OFFERS.get();
        }
    }
    public static String getSpecialDirtTable() {
        if (Objects.equals(SPECIAL_DIRT_BLOCKS_TABLE.get(), SPECIAL_DIRT_BLOCKS_TABLE.getDefault())) {
            return SPECIAL_DIRT_BLOCKS_TABLE.getDefault();
        }
        else {
            return SPECIAL_DIRT_BLOCKS_TABLE.get();
        }
    }
    public static String getGlassblowingToolsTagTable() {
        if (Objects.equals(GLASSBLOWING_TOOLS_TAG_TABLE.get(), GLASSBLOWING_TOOLS_TAG_TABLE.getDefault())) {
            return GLASSBLOWING_TOOLS_TAG_TABLE.getDefault();
        }
        else {
            return GLASSBLOWING_TOOLS_TAG_TABLE.get();
        }
    }
    public static int getGlassblowingToolsCount() {
        if (Objects.equals(GLASSBLOWING_TOOLS_TAG_COUNT.get(), GLASSBLOWING_TOOLS_TAG_COUNT.getDefault())) {
            return GLASSBLOWING_TOOLS_TAG_COUNT.getDefault();
        }
        else {
            return GLASSBLOWING_TOOLS_TAG_COUNT.get();
        }
    }
    public static String getRecyclableGlassTagTable() {
        if (Objects.equals(RECYCLABLE_GLASS_TAG_TABLE.get(), RECYCLABLE_GLASS_TAG_TABLE.getDefault())) {
            return RECYCLABLE_GLASS_TAG_TABLE.getDefault();
        }
        else {
            return RECYCLABLE_GLASS_TAG_TABLE.get();
        }
    }
    public static int getRecyclableGlassTagCount() {
        if (Objects.equals(RECYCLABLE_GLASS_TAG_COUNT.get(), RECYCLABLE_GLASS_TAG_COUNT.getDefault())) {
            return RECYCLABLE_GLASS_TAG_COUNT.getDefault();
        }
        else {
            return RECYCLABLE_GLASS_TAG_COUNT.get();
        }
    }
    public static String getMusicDiscTagTable() {
        if (Objects.equals(MUSIC_DISC_TAG_TABLE.get(), MUSIC_DISC_TAG_TABLE.getDefault())) {
            return MUSIC_DISC_TAG_TABLE.getDefault();
        }
        else {
            return MUSIC_DISC_TAG_TABLE.get();
        }
    }
    public static int getMusicDiscTagCount() {
        if (Objects.equals(MUSIC_DISC_TAG_COUNT.get(), MUSIC_DISC_TAG_COUNT.getDefault())) {
            return MUSIC_DISC_TAG_COUNT.getDefault();
        }
        else {
            return MUSIC_DISC_TAG_COUNT.get();
        }
    }
    public static String getIceTable() {
        if (Objects.equals(ICE_TABLE.get(), ICE_TABLE.getDefault())) {
            return ICE_TABLE.getDefault();
        }
        else {
            return ICE_TABLE.get();
        }
    }
    public static String getSaplingSellTable() {
        if (Objects.equals(SAPLING_SELL_TABLE.get(), SAPLING_SELL_TABLE.getDefault())) {
            return SAPLING_SELL_TABLE.getDefault();
        }
        else {
            return SAPLING_SELL_TABLE.get();
        }
    }
    public static String getBeeEggTable() {
        if (Objects.equals(BEE_EGG_TABLE.get(), BEE_EGG_TABLE.getDefault())) {
            return BEE_EGG_TABLE.getDefault();
        }
        else {
            return BEE_EGG_TABLE.get();
        }
    }
    public static String getSeaShellTable() {
        if (Objects.equals(SEASHELL_TABLE.get(), SEASHELL_TABLE.getDefault())) {
            return SEASHELL_TABLE.getDefault();
        }
        else {
            return SEASHELL_TABLE.get();
        }
    }
    public static String getBeehiveTable() {
        if (Objects.equals(BEEHIVE_TABLE.get(), BEEHIVE_TABLE.getDefault())) {
            return BEEHIVE_TABLE.getDefault();
        }
        else {
            return BEEHIVE_TABLE.get();
        }
    }
    public static String getHoneyCombTable() {
        if (Objects.equals(HONEY_COMB_TABLE.get(), HONEY_COMB_TABLE.getDefault())) {
            return HONEY_COMB_TABLE.getDefault();
        }
        else {
            return HONEY_COMB_TABLE.get();
        }
    }
    public static String getHoneyBlockTable() {
        if (Objects.equals(HONEY_BLOCK_TABLE.get(), HONEY_BLOCK_TABLE.getDefault())) {
            return HONEY_BLOCK_TABLE.getDefault();
        }
        else {
            return HONEY_BLOCK_TABLE.get();
        }
    }
    public static String getBottledHoneyTable() {
        if (Objects.equals(BOTTLED_HONEY_TABLE.get(), BOTTLED_HONEY_TABLE.getDefault())) {
            return BOTTLED_HONEY_TABLE.getDefault();
        }
        else {
            return BOTTLED_HONEY_TABLE.get();
        }
    }
    public static String getFlowerSellTable() {
        if (Objects.equals(FLOWER_SELL_TABLE.get(), FLOWER_SELL_TABLE.getDefault())) {
            return FLOWER_SELL_TABLE.getDefault();
        }
        else {
            return FLOWER_SELL_TABLE.get();
        }
    }
    public static String getFlowerBuyTable() {
        if (Objects.equals(FLOWER_BUY_TABLE.get(), FLOWER_BUY_TABLE.getDefault())) {
            return FLOWER_BUY_TABLE.getDefault();
        }
        else {
            return FLOWER_BUY_TABLE.get();
        }
    }
    public static String getShieldTable() {
        if (Objects.equals(SHIELD_TABLE.get(), SHIELD_TABLE.getDefault())) {
            return SHIELD_TABLE.getDefault();
        }
        else {
            return SHIELD_TABLE.get();
        }
    }
    public static String getItemFrameTable() {
        if (Objects.equals(ITEM_FRAME_TABLE.get(), ITEM_FRAME_TABLE.getDefault())) {
            return ITEM_FRAME_TABLE.getDefault();
        }
        else {
            return ITEM_FRAME_TABLE.get();
        }
    }
    public static String getBannerPatternTable() {
        if (Objects.equals(BANNER_PATTERN_TABLE.get(), BANNER_PATTERN_TABLE.getDefault())) {
            return BANNER_PATTERN_TABLE.getDefault();
        }
        else {
            return BANNER_PATTERN_TABLE.get();
        }
    }
    public static String getDiscFragmentsTable() {
        if (Objects.equals(DISC_FRAGMENTS_TABLE.get(), DISC_FRAGMENTS_TABLE.getDefault())) {
            return DISC_FRAGMENTS_TABLE.getDefault();
        }
        else {
            return DISC_FRAGMENTS_TABLE.get();
        }
    }
    public static String getExperienceBottleTable() {
        if (Objects.equals(EXPERIENCE_BOTTLE_TABLE.get(), EXPERIENCE_BOTTLE_TABLE.getDefault())) {
            return EXPERIENCE_BOTTLE_TABLE.getDefault();
        }
        else {
            return EXPERIENCE_BOTTLE_TABLE.get();
        }
    }
    public static String getBlankMapTable() {
        if (Objects.equals(BLANK_MAP_TABLE.get(), BLANK_MAP_TABLE.getDefault())) {
            return BLANK_MAP_TABLE.getDefault();
        }
        else {
            return BLANK_MAP_TABLE.get();
        }
    }
    public static String getGlassBottleTable() {
        if (Objects.equals(GLASS_BOTTLE_TABLE.get(), GLASS_BOTTLE_TABLE.getDefault())) {
            return GLASS_BOTTLE_TABLE.getDefault();
        }
        else {
            return GLASS_BOTTLE_TABLE.get();
        }
    }
    public static String getPotionIngredientTable() {
        if (Objects.equals(POTION_INGREDIENTS_TABLE.get(), POTION_INGREDIENTS_TABLE.getDefault())) {
            return POTION_INGREDIENTS_TABLE.getDefault();
        }
        else {
            return POTION_INGREDIENTS_TABLE.get();
        }
    }
    public static String getMobPartsTable() {
        if (Objects.equals(MONSTER_PARTS_TABLE.get(), MONSTER_PARTS_TABLE.getDefault())) {
            return MONSTER_PARTS_TABLE.getDefault();
        }
        else {
            return MONSTER_PARTS_TABLE.get();
        }
    }
    public static String getGoldenFoodTable() {
        if (Objects.equals(GOLDEN_FOOD_TABLE.get(), GOLDEN_FOOD_TABLE.getDefault())) {
            return GOLDEN_FOOD_TABLE.getDefault();
        }
        else {
            return GOLDEN_FOOD_TABLE.get();
        }
    }
    public static String getCampfireTable() {
        if (Objects.equals(CAMPFIRE_TABLE.get(), CAMPFIRE_TABLE.getDefault())) {
            return CAMPFIRE_TABLE.getDefault();
        }
        else {
            return CAMPFIRE_TABLE.get();
        }
    }
    public static String getFishBucketTable() {
        if (Objects.equals(FISH_BUCKET_TABLE.get(), FISH_BUCKET_TABLE.getDefault())) {
            return FISH_BUCKET_TABLE.getDefault();
        }
        else {
            return FISH_BUCKET_TABLE.get();
        }
    }
    public static String getFlintSellTable() {
        if (Objects.equals(FLINT_SELL_TABLE.get(), FLINT_SELL_TABLE.getDefault())) {
            return FLINT_SELL_TABLE.getDefault();
        }
        else {
            return FLINT_SELL_TABLE.get();
        }
    }
    public static String getTripwireHookTable() {
        if (Objects.equals(TRIPWIRE_HOOK_TABLE.get(), TRIPWIRE_HOOK_TABLE.getDefault())) {
            return TRIPWIRE_HOOK_TABLE.getDefault();
        }
        else {
            return TRIPWIRE_HOOK_TABLE.get();
        }
    }
    public static String getFeatherTable() {
        if (Objects.equals(FEATHER_TABLE.get(), FEATHER_TABLE.getDefault())) {
            return FEATHER_TABLE.getDefault();
        }
        else {
            return FEATHER_TABLE.get();
        }
    }
    public static String getGravelTable() {
        if (Objects.equals(GRAVEL_TABLE.get(), GRAVEL_TABLE.getDefault())) {
            return GRAVEL_TABLE.getDefault();
        }
        else {
            return GRAVEL_TABLE.get();
        }
    }
    public static String getSaddleTable() {
        if (Objects.equals(SADDLE_TABLE.get(), SADDLE_TABLE.getDefault())) {
            return SADDLE_TABLE.getDefault();
        }
        else {
            return SADDLE_TABLE.get();
        }
    }
    public static String getScuteTable() {
        if (Objects.equals(SCUTE_TABLE.get(), SCUTE_TABLE.getDefault())) {
            return SCUTE_TABLE.getDefault();
        }
        else {
            return SCUTE_TABLE.get();
        }
    }
    public static String getCompassTable() {
        if (Objects.equals(COMPASS_TABLE.get(), COMPASS_TABLE.getDefault())) {
            return COMPASS_TABLE.getDefault();
        }
        else {
            return COMPASS_TABLE.get();
        }
    }
    public static String getClockTable() {
        if (Objects.equals(CLOCK_TABLE.get(), CLOCK_TABLE.getDefault())) {
            return CLOCK_TABLE.getDefault();
        }
        else {
            return CLOCK_TABLE.get();
        }
    }
    public static String getBookTable() {
        if (Objects.equals(BOOK_TABLE.get(), BOOK_TABLE.getDefault())) {
            return BOOK_TABLE.getDefault();
        }
        else {
            return BOOK_TABLE.get();
        }
    }
    public static String getPaperTable() {
        if (Objects.equals(PAPER_TABLE.get(), PAPER_TABLE.getDefault())) {
            return PAPER_TABLE.getDefault();
        }
        else {
            return PAPER_TABLE.get();
        }
    }
    public static String getClayTable() {
        if (Objects.equals(CLAY_TABLE.get(), CLAY_TABLE.getDefault())) {
            return CLAY_TABLE.getDefault();
        }
        else {
            return CLAY_TABLE.get();
        }
    }
    public static String getShearsTable() {
        if (Objects.equals(SHEARS_TABLE.get(), SHEARS_TABLE.getDefault())) {
            return SHEARS_TABLE.getDefault();
        }
        else {
            return SHEARS_TABLE.get();
        }
    }
    public static String getAnvilTable() {
        if (Objects.equals(ANVIL_TABLE.get(), ANVIL_TABLE.getDefault())) {
            return ANVIL_TABLE.getDefault();
        }
        else {
            return ANVIL_TABLE.get();
        }
    }
    public static String getFlintBuyTable() {
        if (Objects.equals(FLINT_BUY_TABLE.get(), FLINT_BUY_TABLE.getDefault())) {
            return FLINT_BUY_TABLE.getDefault();
        }
        else {
            return FLINT_BUY_TABLE.get();
        }
    }
    public static String getBellTable() {
        if (Objects.equals(BELL_TABLE.get(), BELL_TABLE.getDefault())) {
            return BELL_TABLE.getDefault();
        }
        else {
            return BELL_TABLE.get();
        }
    }
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
    public static String getCoralBlockTagTable() {
        if (Objects.equals(CORAL_BLOCK_TAG_TABLE.get(), CORAL_BLOCK_TAG_TABLE.getDefault())) {
            return CORAL_BLOCK_TAG_TABLE.getDefault();
        }
        else {
            return CORAL_BLOCK_TAG_TABLE.get();
        }
    }
    public static int getCoralBlockCount() {
        if (Objects.equals(CORAL_BLOCK_TAG_COUNT.get(), CORAL_BLOCK_TAG_COUNT.getDefault())) {
            return CORAL_BLOCK_TAG_COUNT.getDefault();
        }
        else {
            return CORAL_BLOCK_TAG_COUNT.get();
        }
    }
    public static String getCandleTagTable() {
        if (Objects.equals(CANDLE_TAG_TABLE.get(), CANDLE_TAG_TABLE.getDefault())) {
            return CANDLE_TAG_TABLE.getDefault();
        }
        else {
            return CANDLE_TAG_TABLE.get();
        }
    }
    public static int getCandleCount() {
        if (Objects.equals(CANDLE_TAG_COUNT.get(), CANDLE_TAG_COUNT.getDefault())) {
            return CANDLE_TAG_COUNT.getDefault();
        }
        else {
            return CANDLE_TAG_COUNT.get();
        }
    }
    public static String getStringTagTable() {
        if (Objects.equals(STRING_TAG_TABLE.get(), STRING_TAG_TABLE.getDefault())) {
            return STRING_TAG_TABLE.getDefault();
        }
        else {
            return STRING_TAG_TABLE.get();
        }
    }
    public static int getStringCount() {
        if (Objects.equals(STRING_TAG_COUNT.get(), STRING_TAG_COUNT.getDefault())) {
            return STRING_TAG_COUNT.getDefault();
        }
        else {
            return STRING_TAG_COUNT.get();
        }
    }
    public static String getStickTagTable() {
        if (Objects.equals(STICK_TAG_TABLE.get(), STICK_TAG_TABLE.getDefault())) {
            return STICK_TAG_TABLE.getDefault();
        }
        else {
            return STICK_TAG_TABLE.get();
        }
    }
    public static int getStickCount() {
        if (Objects.equals(STICK_TAG_COUNT.get(), STICK_TAG_COUNT.getDefault())) {
            return STICK_TAG_COUNT.getDefault();
        }
        else {
            return STICK_TAG_COUNT.get();
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
    public static String getSmallestCoin() {
        if (Objects.equals(SMALLEST_COIN.get(), SMALLEST_COIN.getDefault())) {
            return SMALLEST_COIN.getDefault();
        }
        else {
            return SMALLEST_COIN.get();
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
    public static int getDyeBuyCount() {
        if (Objects.equals(DYE_TAG_BUY_COUNT.get(), DYE_TAG_BUY_COUNT.getDefault())) {
            return DYE_TAG_BUY_COUNT.getDefault();
        }
        else {
            return DYE_TAG_BUY_COUNT.get();
        }
    }
    public static int getDyeSellCount() {
        if (Objects.equals(DYE_TAG_SELL_COUNT.get(), DYE_TAG_SELL_COUNT.getDefault())) {
            return DYE_TAG_SELL_COUNT.getDefault();
        }
        else {
            return DYE_TAG_SELL_COUNT.get();
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
    public static int getInkSellCount() {
        if (Objects.equals(INK_TAG_SELL_COUNT.get(), INK_TAG_SELL_COUNT.getDefault())) {
            return INK_TAG_SELL_COUNT.getDefault();
        }
        else {
            return INK_TAG_SELL_COUNT.get();
        }
    }
    public static int getInkBuyCount() {
        if (Objects.equals(INK_TAG_BUY_COUNT.get(), INK_TAG_BUY_COUNT.getDefault())) {
            return INK_TAG_BUY_COUNT.getDefault();
        }
        else {
            return INK_TAG_BUY_COUNT.get();
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
    public static String getFishingRodTable() {
        if (Objects.equals(FISHING_ROD_TABLE.get(), FISHING_ROD_TABLE.getDefault())) {
            return FISHING_ROD_TABLE.getDefault();
        }
        else {
            return FISHING_ROD_TABLE.get();
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
    public static int getWoolSellCount() {
        if (Objects.equals(WOOL_TAG_SELL_COUNT.get(), WOOL_TAG_SELL_COUNT.getDefault())) {
            return WOOL_TAG_SELL_COUNT.getDefault();
        }
        else {
            return WOOL_TAG_SELL_COUNT.get();
        }
    }
    public static int getWoolBuyCount() {
        if (Objects.equals(WOOL_TAG_BUY_COUNT.get(), WOOL_TAG_BUY_COUNT.getDefault())) {
            return WOOL_TAG_BUY_COUNT.getDefault();
        }
        else {
            return WOOL_TAG_BUY_COUNT.get();
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
    public static String getSandTagTable() {
        if (Objects.equals(SAND_TAG_TABLE.get(), SAND_TAG_TABLE.getDefault())) {
            return SAND_TAG_TABLE.getDefault();
        }
        else {
            return SAND_TAG_TABLE.get();
        }
    }
    public static int getSandCount() {
        if (Objects.equals(SAND_TAG_COUNT.get(), SAND_TAG_COUNT.getDefault())) {
            return SAND_TAG_COUNT.getDefault();
        }
        else {
            return SAND_TAG_COUNT.get();
        }
    }
    public static String getSeedTagTable() {
        if (Objects.equals(SEED_TAG_TABLE.get(), SEED_TAG_TABLE.getDefault())) {
            return SEED_TAG_TABLE.getDefault();
        }
        else {
            return SEED_TAG_TABLE.get();
        }
    }
    public static int getSeedCount() {
        if (Objects.equals(SEED_TAG_COUNT.get(), SEED_TAG_COUNT.getDefault())) {
            return SEED_TAG_COUNT.getDefault();
        }
        else {
            return SEED_TAG_COUNT.get();
        }
    }
    public static String getSlimeballTagTable() {
        if (Objects.equals(SLIMEBALL_TAG_TABLE.get(), SLIMEBALL_TAG_TABLE.getDefault())) {
            return SLIMEBALL_TAG_TABLE.getDefault();
        }
        else {
            return SLIMEBALL_TAG_TABLE.get();
        }
    }
    public static int getSlimeballCount() {
        if (Objects.equals(SLIMEBALL_TAG_COUNT.get(), SLIMEBALL_TAG_COUNT.getDefault())) {
            return SLIMEBALL_TAG_COUNT.getDefault();
        }
        else {
            return SLIMEBALL_TAG_COUNT.get();
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
    public static String getTwentySevenLuckyCoinItemsTable() {
        if (Objects.equals(TWENTY_SEVEN_LUCKY_COIN_ITEMS.get(), TWENTY_SEVEN_LUCKY_COIN_ITEMS.getDefault())) {
            return TWENTY_SEVEN_LUCKY_COIN_ITEMS.getDefault();
        }
        else {
            return TWENTY_SEVEN_LUCKY_COIN_ITEMS.get();
        }
    }
    public static String getThreeLuckyCoinItemsTable() {
        if (Objects.equals(THREE_LUCKY_COIN_ITEMS.get(), THREE_LUCKY_COIN_ITEMS.getDefault())) {
            return THREE_LUCKY_COIN_ITEMS.getDefault();
        }
        else {
            return THREE_LUCKY_COIN_ITEMS.get();
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
    public static String getSixtyGoldPotItemsTable() {
        if (Objects.equals(SIXTY_GOLD_POT_ITEMS.get(), SIXTY_GOLD_POT_ITEMS.getDefault())) {
            return SIXTY_GOLD_POT_ITEMS.getDefault();
        }
        else {
            return SIXTY_GOLD_POT_ITEMS.get();
        }
    }
    public static String getThirtyGoldPotItemsTable() {
        if (Objects.equals(THIRTY_GOLD_POT_ITEMS.get(), THIRTY_GOLD_POT_ITEMS.getDefault())) {
            return THIRTY_GOLD_POT_ITEMS.getDefault();
        }
        else {
            return THIRTY_GOLD_POT_ITEMS.get();
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
    public static String getFourGoldPotItemsTable() {
        if (Objects.equals(FOUR_GOLD_POT_ITEMS.get(), FOUR_GOLD_POT_ITEMS.getDefault())) {
            return FOUR_GOLD_POT_ITEMS.getDefault();
        }
        else {
            return FOUR_GOLD_POT_ITEMS.get();
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
    public static String getTwoGoldPotItemsTable() {
        if (Objects.equals(TWO_GOLD_POT_ITEMS.get(), TWO_GOLD_POT_ITEMS.getDefault())) {
            return TWO_GOLD_POT_ITEMS.getDefault();
        }
        else {
            return TWO_GOLD_POT_ITEMS.get();
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
    public static String getOneEmeraldFuelTable() {
        if (Objects.equals(ONE_EMERALD_FUEL.get(), ONE_EMERALD_FUEL.getDefault())) {
            return ONE_EMERALD_FUEL.getDefault();
        }
        else {
            return ONE_EMERALD_FUEL.get();
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
    public static String getEquipmentGemsTable() {
        if (Objects.equals(EQUIPMENT_GEMS.get(), EQUIPMENT_GEMS.getDefault())) {
            return EQUIPMENT_GEMS.getDefault();
        }
        else {
            return EQUIPMENT_GEMS.get();
        }
    }
    public static String getEnchantingGemsTable() {
        if (Objects.equals(ENCHANTING_GEMS.get(), ENCHANTING_GEMS.getDefault())) {
            return ENCHANTING_GEMS.getDefault();
        }
        else {
            return ENCHANTING_GEMS.get();
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
    public static int getCommonMaxTrades() {
        if (Objects.equals(COMMON_MAX_TRADES.get(), COMMON_MAX_TRADES.getDefault())) {
            return COMMON_MAX_TRADES.getDefault();
        }
        else {
            return COMMON_MAX_TRADES.get();
        }
    }
    public static float getCommonTradeMultiplier() {
        if (Objects.equals(COMMON_TRADE_MULTIPLIER.get(), COMMON_TRADE_MULTIPLIER.getDefault())) {
            return COMMON_TRADE_MULTIPLIER.getDefault();
        }
        else {
            return COMMON_TRADE_MULTIPLIER.get();
        }
    }
    public static int getRareMaxTrades() {
        if (Objects.equals(RARE_MAX_TRADES.get(), RARE_MAX_TRADES.getDefault())) {
            return RARE_MAX_TRADES.getDefault();
        }
        else {
            return RARE_MAX_TRADES.get();
        }
    }
    public static float getRareTradeMultiplier() {
        if (Objects.equals(RARE_TRADE_MULTIPLIER.get(), RARE_TRADE_MULTIPLIER.getDefault())) {
            return RARE_TRADE_MULTIPLIER.getDefault();
        }
        else {
            return RARE_TRADE_MULTIPLIER.get();
        }
    }
    public static Boolean getResetTrades() {
        if (Objects.equals(RESET_TRADES_ON_RESTOCK.get(), RESET_TRADES_ON_RESTOCK.getDefault())) {
            return RESET_TRADES_ON_RESTOCK.getDefault();
        }
        else {
            return RESET_TRADES_ON_RESTOCK.get();
        }
    }
}