package com.github.warrentode.todecoins.config.trades.morevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnderianTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Enderian Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_4_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_4_REQUEST_2_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_4_REQUEST_2_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_4_REQUEST_2_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENDERIAN_5_OFFER_2;

    static {
        // ENDERIAN TRADES
        BUILDER.push(" Enderian Trade Settings");
        // level 1
        BUILDER.push(" Enderian Level One Trade One");
        ENDERIAN_1_REQUEST_1 = BUILDER
                .comment(" Enderian 1 Trade Request 1 Table")
                .define("enderian_1_trade_request_1_table",
                        TradeLootTables.ENDONIAN_COIN_TABLE.toString());
        ENDERIAN_1_OFFER_1 = BUILDER
                .comment(" Enderian 1 Trade Offer 1 Table")
                .define("enderian_1_trade_offer_1_table",
                        TradeLootTables.END_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Enderian Level One Trade Two");
        ENDERIAN_1_REQUEST_2 = BUILDER
                .comment(" Enderian 1 Trade Request 2 Table")
                .define("enderian_1_trade_request_2_table",
                        TradeLootTables.ENDONIAN_COIN_TABLE.toString());
        ENDERIAN_1_OFFER_2 = BUILDER
                .comment(" Enderian 1 Trade Offer 2 Table")
                .define("enderian_1_trade_offer_2_table",
                        TradeLootTables.END_ROD_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push(" Enderian Level Two Trade One");
        ENDERIAN_2_REQUEST_1 = BUILDER
                .comment(" Enderian 2 Trade Request 1 Table")
                .define("enderian_2_trade_request_1_table",
                        TradeLootTables.FIVE_ENDONIAN_COIN_TABLE.toString());
        ENDERIAN_2_OFFER_1 = BUILDER
                .comment(" Enderian 2 Trade Offer 1 Table")
                .define("enderian_2_trade_offer_1_table",
                        TradeLootTables.ENDER_PEARL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Enderian Level Two Trade Two");
        ENDERIAN_2_REQUEST_2 = BUILDER
                .comment(" Enderian 2 Trade Request 2 Table")
                .define("enderian_2_trade_request_2_table",
                        TradeLootTables.ENDONIAN_COIN_TABLE.toString());
        ENDERIAN_2_OFFER_2 = BUILDER
                .comment(" Enderian 2 Trade Offer 2 Table")
                .define("enderian_2_trade_offer_2_table",
                        TradeLootTables.FIREWORK_ROCKET_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push(" Enderian Level Three Trade One");
        ENDERIAN_3_REQUEST_1 = BUILDER
                .comment(" Enderian 3 Trade Request 1 Table")
                .define("enderian_3_trade_request_1_table",
                        TradeLootTables.ENDONIAN_COIN_TABLE.toString());
        ENDERIAN_3_OFFER_1 = BUILDER
                .comment(" Enderian 3 Trade Offer 1 Table")
                .define("enderian_3_trade_offer_1_table",
                        TradeLootTables.DRAGON_BREATH_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Enderian Level Three Trade Two");
        ENDERIAN_3_REQUEST_2 = BUILDER
                .comment(" Enderian 3 Trade Request 2 Table")
                .define("enderian_3_trade_request_2_table",
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        ENDERIAN_3_OFFER_2 = BUILDER
                .comment(" Enderian 3 Trade Offer 2 Table")
                .define("enderian_3_trade_offer_2_table",
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push(" Enderian Level Four Trade One");
        ENDERIAN_4_REQUEST_1 = BUILDER
                .comment(" Enderian 4 Trade Request 1 Table")
                .define("enderian_4_trade_request_1_table",
                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE.toString());
        ENDERIAN_4_OFFER_1 = BUILDER
                .comment(" Enderian 4 Trade Offer 1 Table")
                .define("enderian_4_trade_offer_1_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Enderian Level Four Trade Two")
                .comment(" Rare Trade");
        ENDERIAN_4_REQUEST_2 = BUILDER
                .comment(" Enderian 4 Trade Request 2 Table")
                .define("enderian_4_trade_request_2_table",
                        TradeLootTables.FOURTEEN_ENDONIAN_COIN_TABLE.toString());
        ENDERIAN_4_REQUEST_2_SECONDARY = BUILDER
                .comment(" Enderian 4 Trade Secondary Request 2 Table")
                .define("enderian_4_trade_secondary_request_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        ENDERIAN_4_REQUEST_2_STRUCTURE_TAG = BUILDER
                .comment(" Enderian 4 Trade Request 2 Structure Tag")
                .define("enderian_4_trade_secondary_request_2_structure_tag",
                        "turtleblockacademy:worldgen/structure/end_poi");
        ENDERIAN_4_REQUEST_2_MAP_NAME = BUILDER
                .comment(" Enderian 4 Trade Request 2 Map Name")
                .define("enderian_4_trade_secondary_request_2_map_name",
                        "End Explorer Map");
        ENDERIAN_4_REQUEST_2_MAP_MARKER = BUILDER
                .comment(" Enderian 4 Trade Request 2 Map Marker")
                .define("enderian_4_trade_secondary_request_2_map_marker",
                        String.valueOf(MapDecoration.Type.BLUE_MARKER));
        BUILDER.pop();
        // level 5
        BUILDER.push(" Enderian Level Five Trade One");
        ENDERIAN_5_REQUEST_1 = BUILDER
                .comment(" Enderian 5 Trade Request 1 Table")
                .define("enderian_5_trade_request_1_table",
                        TradeLootTables.THIRTY_TWO_ENDONIAN_COIN_TABLE.toString());
        ENDERIAN_5_OFFER_1 = BUILDER
                .comment(" Enderian 5 Trade Offer 1 Table")
                .define("enderian_5_trade_offer_1_table",
                        TradeLootTables.SHULKER_SHELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Enderian Level Five Trade Two");
        ENDERIAN_5_REQUEST_2 = BUILDER
                .comment(" Enderian 5 Trade Request 2 Table")
                .define("enderian_5_trade_request_2_table",
                        TradeLootTables.FIFTY_ENDONIAN_COIN_TABLE.toString());
        ENDERIAN_5_OFFER_2 = BUILDER
                .comment(" Enderian 5 Trade Offer 2 Table")
                .define("enderian_5_trade_offer_2_table",
                        TradeLootTables.DRAGON_HEAD_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // ENDERIAN TRADE GETTERS
    public static String getEnderian5Offer2() {
        if (Objects.equals(ENDERIAN_5_OFFER_2.get(), ENDERIAN_5_OFFER_2.getDefault())) {
            return ENDERIAN_5_OFFER_2.getDefault();
        }
        else {
            return ENDERIAN_5_OFFER_2.get();
        }
    }
    public static String getEnderian5Request2() {
        if (Objects.equals(ENDERIAN_5_REQUEST_2.get(), ENDERIAN_5_REQUEST_2.getDefault())) {
            return ENDERIAN_5_REQUEST_2.getDefault();
        }
        else {
            return ENDERIAN_5_REQUEST_2.get();
        }
    }
    public static String getEnderian5Offer1() {
        if (Objects.equals(ENDERIAN_5_OFFER_1.get(), ENDERIAN_5_OFFER_1.getDefault())) {
            return ENDERIAN_5_OFFER_1.getDefault();
        }
        else {
            return ENDERIAN_5_OFFER_1.get();
        }
    }
    public static String getEnderian5Request1() {
        if (Objects.equals(ENDERIAN_5_REQUEST_1.get(), ENDERIAN_5_REQUEST_1.getDefault())) {
            return ENDERIAN_5_REQUEST_1.getDefault();
        }
        else {
            return ENDERIAN_5_REQUEST_1.get();
        }
    }
    public static String getEnderian4Request2MapMarker() {
        if (Objects.equals(ENDERIAN_4_REQUEST_2_MAP_MARKER.get(), ENDERIAN_4_REQUEST_2_MAP_MARKER.getDefault())) {
            return ENDERIAN_4_REQUEST_2_MAP_MARKER.getDefault();
        }
        else {
            return ENDERIAN_4_REQUEST_2_MAP_MARKER.get();
        }
    }
    public static String getEnderian4Request2MapName() {
        if (Objects.equals(ENDERIAN_4_REQUEST_2_MAP_NAME.get(), ENDERIAN_4_REQUEST_2_MAP_NAME.getDefault())) {
            return ENDERIAN_4_REQUEST_2_MAP_NAME.getDefault();
        }
        else {
            return ENDERIAN_4_REQUEST_2_MAP_NAME.get();
        }
    }
    public static String getEnderian4Request2StructureTag() {
        if (Objects.equals(ENDERIAN_4_REQUEST_2_STRUCTURE_TAG.get(), ENDERIAN_4_REQUEST_2_STRUCTURE_TAG.getDefault())) {
            return ENDERIAN_4_REQUEST_2_STRUCTURE_TAG.getDefault();
        }
        else {
            return ENDERIAN_4_REQUEST_2_STRUCTURE_TAG.get();
        }
    }
    public static String getEnderian4Request2Secondary() {
        if (Objects.equals(ENDERIAN_4_REQUEST_2_SECONDARY.get(), ENDERIAN_4_REQUEST_2_SECONDARY.getDefault())) {
            return ENDERIAN_4_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return ENDERIAN_4_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getEnderian4Request2() {
        if (Objects.equals(ENDERIAN_4_REQUEST_2.get(), ENDERIAN_4_REQUEST_2.getDefault())) {
            return ENDERIAN_4_REQUEST_2.getDefault();
        }
        else {
            return ENDERIAN_4_REQUEST_2.get();
        }
    }
    public static String getEnderian4Offer1() {
        if (Objects.equals(ENDERIAN_4_OFFER_1.get(), ENDERIAN_4_OFFER_1.getDefault())) {
            return ENDERIAN_4_OFFER_1.getDefault();
        }
        else {
            return ENDERIAN_4_OFFER_1.get();
        }
    }
    public static String getEnderian4Request1() {
        if (Objects.equals(ENDERIAN_4_REQUEST_1.get(), ENDERIAN_4_REQUEST_1.getDefault())) {
            return ENDERIAN_4_REQUEST_1.getDefault();
        }
        else {
            return ENDERIAN_4_REQUEST_1.get();
        }
    }
    public static String getEnderian3Offer2() {
        if (Objects.equals(ENDERIAN_3_OFFER_2.get(), ENDERIAN_3_OFFER_2.getDefault())) {
            return ENDERIAN_3_OFFER_2.getDefault();
        }
        else {
            return ENDERIAN_3_OFFER_2.get();
        }
    }
    public static String getEnderian3Request2() {
        if (Objects.equals(ENDERIAN_3_REQUEST_2.get(), ENDERIAN_3_REQUEST_2.getDefault())) {
            return ENDERIAN_3_REQUEST_2.getDefault();
        }
        else {
            return ENDERIAN_3_REQUEST_2.get();
        }
    }
    public static String getEnderian3Offer1() {
        if (Objects.equals(ENDERIAN_3_OFFER_1.get(), ENDERIAN_3_OFFER_1.getDefault())) {
            return ENDERIAN_3_OFFER_1.getDefault();
        }
        else {
            return ENDERIAN_3_OFFER_1.get();
        }
    }
    public static String getEnderian3Request1() {
        if (Objects.equals(ENDERIAN_3_REQUEST_1.get(), ENDERIAN_3_REQUEST_1.getDefault())) {
            return ENDERIAN_3_REQUEST_1.getDefault();
        }
        else {
            return ENDERIAN_3_REQUEST_1.get();
        }
    }
    public static String getEnderian2Offer2() {
        if (Objects.equals(ENDERIAN_2_OFFER_2.get(), ENDERIAN_2_OFFER_2.getDefault())) {
            return ENDERIAN_2_OFFER_2.getDefault();
        }
        else {
            return ENDERIAN_2_OFFER_2.get();
        }
    }
    public static String getEnderian2Request2() {
        if (Objects.equals(ENDERIAN_2_REQUEST_2.get(), ENDERIAN_2_REQUEST_2.getDefault())) {
            return ENDERIAN_2_REQUEST_2.getDefault();
        }
        else {
            return ENDERIAN_2_REQUEST_2.get();
        }
    }
    public static String getEnderian2Offer1() {
        if (Objects.equals(ENDERIAN_2_OFFER_1.get(), ENDERIAN_2_OFFER_1.getDefault())) {
            return ENDERIAN_2_OFFER_1.getDefault();
        }
        else {
            return ENDERIAN_2_OFFER_1.get();
        }
    }
    public static String getEnderian2Request1() {
        if (Objects.equals(ENDERIAN_2_REQUEST_1.get(), ENDERIAN_2_REQUEST_1.getDefault())) {
            return ENDERIAN_2_REQUEST_1.getDefault();
        }
        else {
            return ENDERIAN_2_REQUEST_1.get();
        }
    }
    public static String getEnderian1Offer2() {
        if (Objects.equals(ENDERIAN_1_OFFER_2.get(), ENDERIAN_1_OFFER_2.getDefault())) {
            return ENDERIAN_1_OFFER_2.getDefault();
        }
        else {
            return ENDERIAN_1_OFFER_2.get();
        }
    }
    public static String getEnderian1Request2() {
        if (Objects.equals(ENDERIAN_1_REQUEST_2.get(), ENDERIAN_1_REQUEST_2.getDefault())) {
            return ENDERIAN_1_REQUEST_2.getDefault();
        }
        else {
            return ENDERIAN_1_REQUEST_2.get();
        }
    }
    public static String getEnderian1Offer1() {
        if (Objects.equals(ENDERIAN_1_OFFER_1.get(), ENDERIAN_1_OFFER_1.getDefault())) {
            return ENDERIAN_1_OFFER_1.getDefault();
        }
        else {
            return ENDERIAN_1_OFFER_1.get();
        }
    }
    public static String getEnderian1Request1() {
        if (Objects.equals(ENDERIAN_1_REQUEST_1.get(), ENDERIAN_1_REQUEST_1.getDefault())) {
            return ENDERIAN_1_REQUEST_1.getDefault();
        }
        else {
            return ENDERIAN_1_REQUEST_1.get();
        }
    }
}