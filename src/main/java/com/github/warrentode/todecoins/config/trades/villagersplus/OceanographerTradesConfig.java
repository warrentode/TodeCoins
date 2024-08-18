package com.github.warrentode.todecoins.config.trades.villagersplus;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OceanographerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Oceanographer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCEANOGRAPHER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_3_REQUEST_1_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_3_REQUEST_1_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_3_REQUEST_1_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_3_REQUEST_1_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCEANOGRAPHER_5_OFFER_2;

    static {
        // OCEANOGRAPHER TRADES
        BUILDER.push("Oceanographer Trade Settings");
        // level 1
        BUILDER.push("Oceanographer Level One Trade One");
        OCEANOGRAPHER_1_REQUEST_1 = BUILDER
                .comment(" Oceanographer 1 Trade Request 1 Table")
                .define("oceanographer_1_trade_request_1_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        OCEANOGRAPHER_1_OFFER_1 = BUILDER
                .comment(" Oceanographer 1 Trade Offer 1 Table")
                .define("oceanographer_1_trade_offer_1_table",
                        TradeLootTables.PRISMARINE_SHARD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Oceanographer Level One Trade Two");
        OCEANOGRAPHER_1_REQUEST_2 = BUILDER
                .comment(" Oceanographer 1 Trade Request 2 Table")
                .define("oceanographer_1_trade_request_2_table",
                        TradeLootTables.ONE_LUCKY_COIN_TABLE.toString());
        OCEANOGRAPHER_1_OFFER_2 = BUILDER
                .comment(" Oceanographer 1 Trade Offer 2 Table")
                .define("oceanographer_1_trade_offer_2_table",
                        TradeLootTables.SEA_LANTERN_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Oceanographer Level Two Trade One");
        OCEANOGRAPHER_2_REQUEST_1 = BUILDER
                .comment(" Oceanographer 2 Trade Request 1 Table")
                .define("oceanographer_2_trade_request_1_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        OCEANOGRAPHER_2_OFFER_1 = BUILDER
                .comment(" Oceanographer 2 Trade Offer 1 Table")
                .define("oceanographer_2_trade_offer_1_table",
                        TradeLootTables.OCEAN_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Oceanographer Level Two Trade Two");
        OCEANOGRAPHER_2_REQUEST_2 = BUILDER
                .comment(" Oceanographer 2 Trade Request 2 Table")
                .define("oceanographer_2_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        OCEANOGRAPHER_2_OFFER_2 = BUILDER
                .comment(" Oceanographer 2 Trade Offer 2 Table")
                .define("oceanographer_2_trade_offer_2_table",
                        TradeLootTables.CORAL_BLOCK_TAG_TABLE.toString());
        OCEANOGRAPHER_2_OFFER_2_COUNT = BUILDER
                .defineInRange("oceanographer_2_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 3
        BUILDER.push("Oceanographer Level Three Trade One")
                .comment(" Rare Trade");
        OCEANOGRAPHER_3_REQUEST_1 = BUILDER
                .comment(" Oceanographer 3 Trade Request 1 Table")
                .define("oceanographer_3_trade_request_1_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        OCEANOGRAPHER_3_REQUEST_1_SECONDARY = BUILDER
                .comment(" Oceanographer 3 Trade Secondary Request 1 Table")
                .define("oceanographer_3_trade_secondary_request_1_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        OCEANOGRAPHER_3_REQUEST_1_STRUCTURE_TAG = BUILDER
                .comment(" Oceanographer 3 Trade Request 1 Structure Tag")
                .define("oceanographer_3_trade_secondary_request_1_structure_tag",
                        "turtleblockacademy:worldgen/structure/ocean_poi");
        OCEANOGRAPHER_3_REQUEST_1_MAP_NAME = BUILDER
                .comment(" Oceanographer 3 Trade Request 1 Map Name")
                .define("oceanographer_3_trade_secondary_request_1_map_name",
                        "Ocean Explorer Map");
        OCEANOGRAPHER_3_REQUEST_1_MAP_MARKER = BUILDER
                .comment(" Oceanographer 3 Trade Request 1 Map Marker")
                .define("oceanographer_3_trade_secondary_request_1_map_marker",
                        String.valueOf(MapDecoration.Type.MONUMENT));
        BUILDER.pop();
        BUILDER.push("Oceanographer Level Three Trade Two");
        OCEANOGRAPHER_3_REQUEST_2 = BUILDER
                .comment(" Oceanographer 3 Trade Request 2 Table")
                .define("oceanographer_3_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        OCEANOGRAPHER_3_OFFER_2 = BUILDER
                .comment(" Oceanographer 3 Trade Offer 2 Table")
                .define("oceanographer_3_trade_offer_2_table",
                        TradeLootTables.SEASHELL_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Oceanographer Level Four Trade One");
        OCEANOGRAPHER_4_REQUEST_1 = BUILDER
                .comment(" Oceanographer 4 Trade Request 1 Table")
                .define("oceanographer_4_trade_request_1_table",
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY.toString());
        OCEANOGRAPHER_4_OFFER_1 = BUILDER
                .comment(" Oceanographer 4 Trade Offer 1 Table")
                .define("oceanographer_4_trade_offer_1_table",
                        TradeLootTables.HEART_OF_THE_SEA_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Oceanographer Level Four Trade Two");
        OCEANOGRAPHER_4_REQUEST_2 = BUILDER
                .comment(" Oceanographer 4 Trade Request 2 Table")
                .define("oceanographer_4_trade_request_2_table",
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        OCEANOGRAPHER_4_OFFER_2 = BUILDER
                .comment(" Oceanographer 4 Trade Offer 2 Table")
                .define("oceanographer_4_trade_offer_2_table",
                        TradeLootTables.TRIDENT_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Oceanographer Level Five Trade One")
                .comment(" Enchanted Item Trade")
                .comment(" Rare Trade");
        OCEANOGRAPHER_5_REQUEST_1 = BUILDER
                .comment(" Oceanographer 5 Trade Request 1 Table")
                .define("oceanographer_5_trade_request_1_table",
                        TradeLootTables.ONE_LUCKY_COIN_TABLE.toString());
        OCEANOGRAPHER_5_OFFER_1 = BUILDER
                .comment(" Oceanographer 5 Trade Offer 1 Table")
                .define("oceanographer_5_trade_offer_1_table",
                        TradeLootTables.TRIDENT_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Oceanographer Level Five Trade Two");
        OCEANOGRAPHER_5_REQUEST_2 = BUILDER
                .comment(" Oceanographer 5 Trade Request 2 Table")
                .define("oceanographer_5_trade_request_2_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        OCEANOGRAPHER_5_OFFER_2 = BUILDER
                .comment(" Oceanographer 5 Trade Offer 2 Table")
                .define("oceanographer_5_trade_offer_2_table",
                        TradeLootTables.OCEAN_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // OCEANOGRAPHER TRADE GETTERS
    public static String getOceanographer5Offer2() {
        if (Objects.equals(OCEANOGRAPHER_5_OFFER_2.get(), OCEANOGRAPHER_5_OFFER_2.getDefault())) {
            return OCEANOGRAPHER_5_OFFER_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_5_OFFER_2.get();
        }
    }
    public static String getOceanographer5Request2() {
        if (Objects.equals(OCEANOGRAPHER_5_REQUEST_2.get(), OCEANOGRAPHER_5_REQUEST_2.getDefault())) {
            return OCEANOGRAPHER_5_REQUEST_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_5_REQUEST_2.get();
        }
    }
    public static String getOceanographer5Offer1() {
        if (Objects.equals(OCEANOGRAPHER_5_OFFER_1.get(), OCEANOGRAPHER_5_OFFER_1.getDefault())) {
            return OCEANOGRAPHER_5_OFFER_1.getDefault();
        }
        else {
            return OCEANOGRAPHER_5_OFFER_1.get();
        }
    }
    public static String getOceanographer5Request1() {
        if (Objects.equals(OCEANOGRAPHER_5_REQUEST_1.get(), OCEANOGRAPHER_5_REQUEST_1.getDefault())) {
            return OCEANOGRAPHER_5_REQUEST_1.getDefault();
        }
        else {
            return OCEANOGRAPHER_5_REQUEST_1.get();
        }
    }
    public static String getOceanographer4Offer2() {
        if (Objects.equals(OCEANOGRAPHER_4_OFFER_2.get(), OCEANOGRAPHER_4_OFFER_2.getDefault())) {
            return OCEANOGRAPHER_4_OFFER_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_4_OFFER_2.get();
        }
    }
    public static String getOceanographer4Request2() {
        if (Objects.equals(OCEANOGRAPHER_4_REQUEST_2.get(), OCEANOGRAPHER_4_REQUEST_2.getDefault())) {
            return OCEANOGRAPHER_4_REQUEST_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_4_REQUEST_2.get();
        }
    }
    public static String getOceanographer4Offer1() {
        if (Objects.equals(OCEANOGRAPHER_4_OFFER_1.get(), OCEANOGRAPHER_4_OFFER_1.getDefault())) {
            return OCEANOGRAPHER_4_OFFER_1.getDefault();
        }
        else {
            return OCEANOGRAPHER_4_OFFER_1.get();
        }
    }
    public static String getOceanographer4Request1() {
        if (Objects.equals(OCEANOGRAPHER_4_REQUEST_1.get(), OCEANOGRAPHER_4_REQUEST_1.getDefault())) {
            return OCEANOGRAPHER_4_REQUEST_1.getDefault();
        }
        else {
            return OCEANOGRAPHER_4_REQUEST_1.get();
        }
    }
    public static String getOceanographer3Offer2() {
        if (Objects.equals(OCEANOGRAPHER_3_OFFER_2.get(), OCEANOGRAPHER_3_OFFER_2.getDefault())) {
            return OCEANOGRAPHER_3_OFFER_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_3_OFFER_2.get();
        }
    }
    public static String getOceanographer3Request2() {
        if (Objects.equals(OCEANOGRAPHER_3_REQUEST_2.get(), OCEANOGRAPHER_3_REQUEST_2.getDefault())) {
            return OCEANOGRAPHER_3_REQUEST_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_3_REQUEST_2.get();
        }
    }
    public static String getOceanographer3Request1MapMarker() {
        if (Objects.equals(OCEANOGRAPHER_3_REQUEST_1_MAP_MARKER.get(), OCEANOGRAPHER_3_REQUEST_1_MAP_MARKER.getDefault())) {
            return OCEANOGRAPHER_3_REQUEST_1_MAP_MARKER.getDefault();
        }
        else {
            return OCEANOGRAPHER_3_REQUEST_1_MAP_MARKER.get();
        }
    }
    public static String getOceanographer3Request1MapName() {
        if (Objects.equals(OCEANOGRAPHER_3_REQUEST_1_MAP_NAME.get(), OCEANOGRAPHER_3_REQUEST_1_MAP_NAME.getDefault())) {
            return OCEANOGRAPHER_3_REQUEST_1_MAP_NAME.getDefault();
        }
        else {
            return OCEANOGRAPHER_3_REQUEST_1_MAP_NAME.get();
        }
    }
    public static String getOceanographer3Request1StructureTag() {
        if (Objects.equals(OCEANOGRAPHER_3_REQUEST_1_STRUCTURE_TAG.get(), OCEANOGRAPHER_3_REQUEST_1_STRUCTURE_TAG.getDefault())) {
            return OCEANOGRAPHER_3_REQUEST_1_STRUCTURE_TAG.getDefault();
        }
        else {
            return OCEANOGRAPHER_3_REQUEST_1_STRUCTURE_TAG.get();
        }
    }
    public static String getOceanographer3Request1Secondary() {
        if (Objects.equals(OCEANOGRAPHER_3_REQUEST_1_SECONDARY.get(), OCEANOGRAPHER_3_REQUEST_1_SECONDARY.getDefault())) {
            return OCEANOGRAPHER_3_REQUEST_1_SECONDARY.getDefault();
        }
        else {
            return OCEANOGRAPHER_3_REQUEST_1_SECONDARY.get();
        }
    }
    public static String getOceanographer3Request1() {
        if (Objects.equals(OCEANOGRAPHER_3_REQUEST_1.get(), OCEANOGRAPHER_3_REQUEST_1.getDefault())) {
            return OCEANOGRAPHER_3_REQUEST_1.getDefault();
        }
        else {
            return OCEANOGRAPHER_3_REQUEST_1.get();
        }
    }
    public static int getOceanographer2Offer2Count() {
        if (Objects.equals(OCEANOGRAPHER_2_OFFER_2_COUNT.get(), OCEANOGRAPHER_2_OFFER_2_COUNT.getDefault())) {
            return OCEANOGRAPHER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return OCEANOGRAPHER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getOceanographer2Offer2() {
        if (Objects.equals(OCEANOGRAPHER_2_OFFER_2.get(), OCEANOGRAPHER_2_OFFER_2.getDefault())) {
            return OCEANOGRAPHER_2_OFFER_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_2_OFFER_2.get();
        }
    }
    public static String getOceanographer2Request2() {
        if (Objects.equals(OCEANOGRAPHER_2_REQUEST_2.get(), OCEANOGRAPHER_2_REQUEST_2.getDefault())) {
            return OCEANOGRAPHER_2_REQUEST_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_2_REQUEST_2.get();
        }
    }
    public static String getOceanographer2Offer1() {
        if (Objects.equals(OCEANOGRAPHER_2_OFFER_1.get(), OCEANOGRAPHER_2_OFFER_1.getDefault())) {
            return OCEANOGRAPHER_2_OFFER_1.getDefault();
        }
        else {
            return OCEANOGRAPHER_2_OFFER_1.get();
        }
    }
    public static String getOceanographer2Request1() {
        if (Objects.equals(OCEANOGRAPHER_2_REQUEST_1.get(), OCEANOGRAPHER_2_REQUEST_1.getDefault())) {
            return OCEANOGRAPHER_2_REQUEST_1.getDefault();
        }
        else {
            return OCEANOGRAPHER_2_REQUEST_1.get();
        }
    }
    public static String getOceanographer1Offer2() {
        if (Objects.equals(OCEANOGRAPHER_1_OFFER_2.get(), OCEANOGRAPHER_1_OFFER_2.getDefault())) {
            return OCEANOGRAPHER_1_OFFER_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_1_OFFER_2.get();
        }
    }
    public static String getOceanographer1Request2() {
        if (Objects.equals(OCEANOGRAPHER_1_REQUEST_2.get(), OCEANOGRAPHER_1_REQUEST_2.getDefault())) {
            return OCEANOGRAPHER_1_REQUEST_2.getDefault();
        }
        else {
            return OCEANOGRAPHER_1_REQUEST_2.get();
        }
    }
    public static String getOceanographer1Offer1() {
        if (Objects.equals(OCEANOGRAPHER_1_OFFER_1.get(), OCEANOGRAPHER_1_OFFER_1.getDefault())) {
            return OCEANOGRAPHER_1_OFFER_1.getDefault();
        }
        else {
            return OCEANOGRAPHER_1_OFFER_1.get();
        }
    }
    public static String getOceanographer1Request1() {
        if (Objects.equals(OCEANOGRAPHER_1_REQUEST_1.get(), OCEANOGRAPHER_1_REQUEST_1.getDefault())) {
            return OCEANOGRAPHER_1_REQUEST_1.getDefault();
        }
        else {
            return OCEANOGRAPHER_1_REQUEST_1.get();
        }
    }
}