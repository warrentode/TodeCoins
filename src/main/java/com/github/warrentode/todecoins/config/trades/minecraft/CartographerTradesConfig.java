package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CartographerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Cartographer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> CARTOGRAPHER_2_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> CARTOGRAPHER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2_MAP_MARKER;

    static {
        // CARTOGRAPHER TRADES
        BUILDER.push("Cartographer Trade Settings");
        // level 1
        BUILDER.push("Cartographer Level One Trade One");
        CARTOGRAPHER_1_REQUEST_1 = BUILDER
                .comment(" Cartographer 1 Trade Request 1 Table")
                .define("cartographer_1_trade_request_1_table",
                        TradeLootTables.PAPER_TABLE.toString());
        CARTOGRAPHER_1_OFFER_1 = BUILDER
                .comment(" Cartographer 1 Trade Offer 1 Table")
                .define("cartographer_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level One Trade Two");
        CARTOGRAPHER_1_REQUEST_2 = BUILDER
                .comment(" Cartographer 1 Trade Request 2 Table")
                .define("cartographer_1_trade_request_2_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_1_OFFER_2 = BUILDER
                .comment(" Cartographer 1 Trade Offer 2 Table")
                .define("cartographer_1_trade_offer_2_table",
                        TradeLootTables.BLANK_MAP_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Cartographer Level Two Trade One");
        CARTOGRAPHER_2_REQUEST_1 = BUILDER
                .comment(" Cartographer 2 Trade Request 1 Table")
                .define("cartographer_2_trade_request_1_table",
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE.toString());
        CARTOGRAPHER_2_REQUEST_1_COUNT = BUILDER
                .defineInRange("cartographer_2_trade_request_1_count", 16, 1, 64);
        CARTOGRAPHER_2_OFFER_1 = BUILDER
                .comment(" Cartographer 2 Trade Offer 1 Table")
                .define("cartographer_2_trade_offer_1_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level Two Trade Two")
                .comment(" Rare Trade");
        CARTOGRAPHER_2_REQUEST_2 = BUILDER
                .comment(" Cartographer 2 Trade Request 2 Table")
                .define("cartographer_2_trade_request_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_2_REQUEST_2_SECONDARY = BUILDER
                .comment(" Cartographer 2 Trade Secondary Request 2 Table")
                .define("cartographer_2_trade_secondary_request_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG = BUILDER
                .comment(" Cartographer 2 Trade Request 2 Structure Tag")
                .define("cartographer_2_trade_secondary_request_2_structure_tag",
                        "turtleblockacademy:worldgen/structure/overworld_poi");
        CARTOGRAPHER_2_REQUEST_2_MAP_NAME = BUILDER
                .comment(" Cartographer 2 Trade Request 2 Map Name")
                .define("cartographer_2_trade_secondary_request_2_map_name",
                        "Overworld Explorer Map");
        CARTOGRAPHER_2_REQUEST_2_MAP_MARKER = BUILDER
                .comment(" Cartographer 2 Trade Request 2 Map Marker")
                .define("cartographer_2_trade_secondary_request_2_map_marker",
                        String.valueOf(MapDecoration.Type.TARGET_X));
        CARTOGRAPHER_2_OFFER_2 = BUILDER
                .comment(" Cartographer 2 Trade Offer 2 Table")
                .define("cartographer_2_trade_offer_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Cartographer Level Three Trade One");
        CARTOGRAPHER_3_REQUEST_1 = BUILDER
                .comment(" Cartographer 3 Trade Request 1 Table")
                .define("cartographer_3_trade_request_1_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        CARTOGRAPHER_3_OFFER_1 = BUILDER
                .comment(" Cartographer 3 Trade Offer 1 Table")
                .define("cartographer_3_trade_offer_1_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level Three Trade Two")
                .comment(" Rare Trade");
        CARTOGRAPHER_3_REQUEST_2 = BUILDER
                .comment(" Cartographer 3 Trade Request 2 Table")
                .define("cartographer_3_trade_request_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_3_REQUEST_2_SECONDARY = BUILDER
                .comment(" Cartographer 3 Trade Secondary Request 2 Table")
                .define("cartographer_3_trade_secondary_request_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG = BUILDER
                .comment(" Cartographer 3 Trade Request 2 Structure Tag")
                .define("cartographer_3_trade_secondary_request_2_structure_tag",
                        "turtleblockacademy:worldgen/structure/overworld_poi");
        CARTOGRAPHER_3_REQUEST_2_MAP_NAME = BUILDER
                .comment(" Cartographer 3 Trade Request 2 Map Name")
                .define("cartographer_3_trade_secondary_request_2_map_name",
                        "Overworld Explorer Map");
        CARTOGRAPHER_3_REQUEST_2_MAP_MARKER = BUILDER
                .comment(" Cartographer 3 Trade Request 2 Map Marker")
                .define("cartographer_3_trade_secondary_request_2_map_marker",
                        String.valueOf(MapDecoration.Type.TARGET_X));
        CARTOGRAPHER_3_OFFER_2 = BUILDER
                .comment(" Cartographer 3 Trade Offer 2 Table")
                .define("cartographer_3_trade_offer_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Cartographer Level Four Trade One");
        CARTOGRAPHER_4_REQUEST_1 = BUILDER
                .comment(" Cartographer 4 Trade Request 1 Table")
                .define("cartographer_4_trade_request_1_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_4_OFFER_1 = BUILDER
                .comment(" Cartographer 4 Trade Offer 1 Table")
                .define("cartographer_4_trade_offer_1_table",
                        TradeLootTables.ITEM_FRAME_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level Four Trade Two");
        CARTOGRAPHER_4_REQUEST_2 = BUILDER
                .comment(" Cartographer 4 Trade Request 2 Table")
                .define("cartographer_4_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_4_OFFER_2 = BUILDER
                .comment(" Cartographer 4 Trade Offer 2 Table")
                .define("cartographer_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_BANNER_TABLE.toString());
        CARTOGRAPHER_4_OFFER_2_COUNT = BUILDER
                .defineInRange("cartographer_4_trade_offer_2_count", 3, 1, 64);
        BUILDER.pop();
        // level 5
        BUILDER.push("Cartographer Level Five Trade One");
        CARTOGRAPHER_5_REQUEST_1 = BUILDER
                .comment(" Cartographer 5 Trade Request 1 Table")
                .define("cartographer_5_trade_request_1_table",
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_5_OFFER_1 = BUILDER
                .comment(" Cartographer 5 Trade Offer 1 Table")
                .define("cartographer_5_trade_offer_1_table",
                        TradeLootTables.BANNER_PATTERN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level Five Trade Two")
                .comment(" Rare Trade");
        CARTOGRAPHER_5_REQUEST_2 = BUILDER
                .comment(" Cartographer 5 Trade Request 2 Table")
                .define("cartographer_5_trade_request_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_5_REQUEST_2_SECONDARY = BUILDER
                .comment(" Cartographer 5 Trade Secondary Request 2 Table")
                .define("cartographer_5_trade_secondary_request_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG = BUILDER
                .comment(" Cartographer 5 Trade Request 2 Structure Tag")
                .define("cartographer_5_trade_secondary_request_2_structure_tag",
                        "turtleblockacademy:worldgen/structure/overworld_poi");
        CARTOGRAPHER_5_REQUEST_2_MAP_NAME = BUILDER
                .comment(" Cartographer 5 Trade Request 2 Map Name")
                .define("cartographer_5_trade_secondary_request_2_map_name",
                        "Overworld Explorer Map");
        CARTOGRAPHER_5_REQUEST_2_MAP_MARKER = BUILDER
                .comment(" Cartographer 5 Trade Request 2 Map Marker")
                .define("cartographer_5_trade_secondary_request_2_map_marker",
                        String.valueOf(MapDecoration.Type.TARGET_X));
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // CARTOGRAPHER TRADE GETTERS
    public static String getCartographer5Request2MapMarker() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2_MAP_MARKER.get(), CARTOGRAPHER_5_REQUEST_2_MAP_MARKER.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2_MAP_MARKER.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2_MAP_MARKER.get();
        }
    }
    public static String getCartographer5Request2MapName() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2_MAP_NAME.get(), CARTOGRAPHER_5_REQUEST_2_MAP_NAME.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2_MAP_NAME.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2_MAP_NAME.get();
        }
    }
    public static String getCartographer5Request2StructureTag() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG.get(), CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG.get();
        }
    }
    public static String getCartographer5Request2Secondary() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2_SECONDARY.get(), CARTOGRAPHER_5_REQUEST_2_SECONDARY.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getCartographer5Request2() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2.get(), CARTOGRAPHER_5_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2.get();
        }
    }
    public static String getCartographer5Offer1() {
        if (Objects.equals(CARTOGRAPHER_5_OFFER_1.get(), CARTOGRAPHER_5_OFFER_1.getDefault())) {
            return CARTOGRAPHER_5_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_5_OFFER_1.get();
        }
    }
    public static String getCartographer5Request1() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_1.get(), CARTOGRAPHER_5_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_1.get();
        }
    }
    public static int getCartographer4Offer2Count() {
        if (Objects.equals(CARTOGRAPHER_4_OFFER_2_COUNT.get(), CARTOGRAPHER_4_OFFER_2_COUNT.getDefault())) {
            return CARTOGRAPHER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return CARTOGRAPHER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getCartographer4Offer2() {
        if (Objects.equals(CARTOGRAPHER_4_OFFER_2.get(), CARTOGRAPHER_4_OFFER_2.getDefault())) {
            return CARTOGRAPHER_4_OFFER_2.getDefault();
        }
        else {
            return CARTOGRAPHER_4_OFFER_2.get();
        }
    }
    public static String getCartographer4Request2() {
        if (Objects.equals(CARTOGRAPHER_4_REQUEST_2.get(), CARTOGRAPHER_4_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_4_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_4_REQUEST_2.get();
        }
    }
    public static String getCartographer4Offer1() {
        if (Objects.equals(CARTOGRAPHER_4_OFFER_1.get(), CARTOGRAPHER_4_OFFER_1.getDefault())) {
            return CARTOGRAPHER_4_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_4_OFFER_1.get();
        }
    }
    public static String getCartographer4Request1() {
        if (Objects.equals(CARTOGRAPHER_4_REQUEST_1.get(), CARTOGRAPHER_4_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_4_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_4_REQUEST_1.get();
        }
    }
    public static String getCartographer3Request2MapMarker() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2_MAP_MARKER.get(), CARTOGRAPHER_3_REQUEST_2_MAP_MARKER.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2_MAP_MARKER.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2_MAP_MARKER.get();
        }
    }
    public static String getCartographer3Request2MapName() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2_MAP_NAME.get(), CARTOGRAPHER_3_REQUEST_2_MAP_NAME.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2_MAP_NAME.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2_MAP_NAME.get();
        }
    }
    public static String getCartographer3Request2StructureTag() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG.get(), CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG.get();
        }
    }
    public static String getCartographer3Request2Secondary() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2_SECONDARY.get(), CARTOGRAPHER_3_REQUEST_2_SECONDARY.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getCartographer3Request2() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2.get(), CARTOGRAPHER_3_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2.get();
        }
    }
    public static String getCartographer3Offer1() {
        if (Objects.equals(CARTOGRAPHER_3_OFFER_1.get(), CARTOGRAPHER_3_OFFER_1.getDefault())) {
            return CARTOGRAPHER_3_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_3_OFFER_1.get();
        }
    }
    public static String getCartographer3Request1() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_1.get(), CARTOGRAPHER_3_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_1.get();
        }
    }
    public static String getCartographer2Request2MapMarker() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2_MAP_MARKER.get(), CARTOGRAPHER_2_REQUEST_2_MAP_MARKER.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2_MAP_MARKER.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2_MAP_MARKER.get();
        }
    }
    public static String getCartographer2Request2MapName() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2_MAP_NAME.get(), CARTOGRAPHER_2_REQUEST_2_MAP_NAME.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2_MAP_NAME.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2_MAP_NAME.get();
        }
    }
    public static String getCartographer2Request2StructureTag() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG.get(), CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG.get();
        }
    }
    public static String getCartographer2Request2Secondary() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2_SECONDARY.get(), CARTOGRAPHER_2_REQUEST_2_SECONDARY.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getCartographer2Request2() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2.get(), CARTOGRAPHER_2_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2.get();
        }
    }
    public static String getCartographer2Offer1() {
        if (Objects.equals(CARTOGRAPHER_2_OFFER_1.get(), CARTOGRAPHER_2_OFFER_1.getDefault())) {
            return CARTOGRAPHER_2_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_2_OFFER_1.get();
        }
    }
    public static int getCartographer2Request1Count() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_1_COUNT.get(), CARTOGRAPHER_2_REQUEST_1_COUNT.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_1_COUNT.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_1_COUNT.get();
        }
    }
    public static String getCartographer2Request1() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_1.get(), CARTOGRAPHER_2_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_1.get();
        }
    }
    public static String getCartographer1Offer2() {
        if (Objects.equals(CARTOGRAPHER_1_OFFER_2.get(), CARTOGRAPHER_1_OFFER_2.getDefault())) {
            return CARTOGRAPHER_1_OFFER_2.getDefault();
        }
        else {
            return CARTOGRAPHER_1_OFFER_2.get();
        }
    }
    public static String getCartographer1Request2() {
        if (Objects.equals(CARTOGRAPHER_1_REQUEST_2.get(), CARTOGRAPHER_1_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_1_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_1_REQUEST_2.get();
        }
    }
    public static String getCartographer1Offer1() {
        if (Objects.equals(CARTOGRAPHER_1_OFFER_1.get(), CARTOGRAPHER_1_OFFER_1.getDefault())) {
            return CARTOGRAPHER_1_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_1_OFFER_1.get();
        }
    }
    public static String getCartographer1Request1() {
        if (Objects.equals(CARTOGRAPHER_1_REQUEST_1.get(), CARTOGRAPHER_1_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_1_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_1_REQUEST_1.get();
        }
    }
}