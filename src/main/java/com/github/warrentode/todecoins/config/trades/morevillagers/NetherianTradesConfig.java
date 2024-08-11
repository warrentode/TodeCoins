package com.github.warrentode.todecoins.config.trades.morevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetherianTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Netherian Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_3_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_3_REQUEST_2_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_3_REQUEST_2_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_3_REQUEST_2_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> NETHERIAN_5_OFFER_2;

    static {
        // NETHERIAN TRADES
        BUILDER.push("Netherian Trade Settings");
        // level 1
        BUILDER.push("Netherian Level One Trade One");
        NETHERIAN_1_REQUEST_1 = BUILDER
                .comment(" Netherian 1 Trade Request 1 Table")
                .define("netherian_1_trade_request_1_table",
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE.toString());
        NETHERIAN_1_OFFER_1 = BUILDER
                .comment(" Netherian 1 Trade Offer 1 Table")
                .define("netherian_1_trade_offer_1_table",
                        TradeLootTables.SOUL_LIGHTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Netherian Level One Trade Two");
        NETHERIAN_1_REQUEST_2 = BUILDER
                .comment(" Netherian 1 Trade Request 2 Table")
                .define("netherian_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GOLD.toString());
        NETHERIAN_1_OFFER_2 = BUILDER
                .comment(" Netherian 1 Trade Offer 2 Table")
                .define("netherian_1_trade_offer_2_table",
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Netherian Level Two Trade One");
        NETHERIAN_2_REQUEST_1 = BUILDER
                .comment(" Netherian 2 Trade Request 1 Table")
                .define("netherian_2_trade_request_1_table",
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE.toString());
        NETHERIAN_2_OFFER_1 = BUILDER
                .comment(" Netherian 2 Trade Offer 1 Table")
                .define("netherian_2_trade_offer_1_table",
                        TradeLootTables.NETHER_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Netherian Level Two Trade Two");
        NETHERIAN_2_REQUEST_2 = BUILDER
                .comment(" Netherian 2 Trade Request 2 Table")
                .define("netherian_2_trade_request_2_table",
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE.toString());
        NETHERIAN_2_OFFER_2 = BUILDER
                .comment(" Netherian 2 Trade Offer 2 Table")
                .define("netherian_2_trade_offer_2_table",
                        TradeLootTables.NETHER_WART_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Netherian Level Three Trade One");
        NETHERIAN_3_REQUEST_1 = BUILDER
                .comment(" Netherian 3 Trade Request 1 Table")
                .define("netherian_3_trade_request_1_table",
                        TradeLootTables.THIRTY_NETHER_GOLD_COIN_TABLE.toString());
        NETHERIAN_3_OFFER_1 = BUILDER
                .comment(" Netherian 3 Trade Offer 1 Table")
                .define("netherian_3_trade_offer_1_table",
                        TradeLootTables.GHAST_TEAR_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Netherian Level Three Trade Two")
                .comment(" Rare Trade");
        NETHERIAN_3_REQUEST_2 = BUILDER
                .comment(" Netherian 3 Trade Request 2 Table")
                .define("netherian_3_trade_request_2_table",
                        TradeLootTables.FORTY_TWO_NETHER_GOLD_COIN_TABLE.toString());
        NETHERIAN_3_REQUEST_2_SECONDARY = BUILDER
                .comment(" Netherian 3 Trade Secondary Request 2 Table")
                .define("netherian_3_trade_secondary_request_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        NETHERIAN_3_REQUEST_2_STRUCTURE_TAG = BUILDER
                .comment(" Netherian 3 Trade Request 2 Structure Tag")
                .define("netherian_3_trade_secondary_request_2_structure_tag",
                        "turtleblockacademy:worldgen/structure/nether_poi");
        NETHERIAN_3_REQUEST_2_MAP_NAME = BUILDER
                .comment(" Netherian 3 Trade Request 2 Map Name")
                .define("netherian_3_trade_secondary_request_2_map_name",
                        "Nether Explorer Map");
        NETHERIAN_3_REQUEST_2_MAP_MARKER = BUILDER
                .comment(" Netherian 3 Trade Request 2 Map Marker")
                .define("netherian_5_trade_secondary_request_2_map_marker",
                        String.valueOf(MapDecoration.Type.RED_MARKER));
        BUILDER.pop();
        // level 4
        BUILDER.push("Netherian Level Four Trade One");
        NETHERIAN_4_REQUEST_1 = BUILDER
                .comment(" Netherian 4 Trade Request 1 Table")
                .define("netherian_4_trade_request_1_table",
                        TradeLootTables.NINE_NETHER_GOLD_COIN_TABLE.toString());
        NETHERIAN_4_OFFER_1 = BUILDER
                .comment(" Netherian 4 Trade Offer 1 Table")
                .define("netherian_4_trade_offer_1_table",
                        TradeLootTables.THREE_EMERALD_VALUE_GOLD.toString());
        BUILDER.pop();
        BUILDER.push("Netherian Level Four Trade Two");
        NETHERIAN_4_REQUEST_2 = BUILDER
                .comment(" Netherian 4 Trade Request 2 Table")
                .define("netherian_4_trade_request_2_table",
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE.toString());
        NETHERIAN_4_OFFER_2 = BUILDER
                .comment(" Netherian 4 Trade Offer 2 Table")
                .define("netherian_4_trade_offer_2_table",
                        TradeLootTables.NETHER_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Netherian Level Five Trade One");
        NETHERIAN_5_REQUEST_1 = BUILDER
                .comment(" Netherian 5 Trade Request 1 Table")
                .define("netherian_5_trade_request_1_table",
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE.toString());
        NETHERIAN_5_OFFER_1 = BUILDER
                .comment(" Netherian 5 Trade Offer 1 Table")
                .define("netherian_5_trade_offer_1_table",
                        TradeLootTables.NETHER_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Netherian Level Five Trade Two");
        NETHERIAN_5_REQUEST_2 = BUILDER
                .comment(" Netherian 5 Trade Request 2 Table")
                .define("netherian_5_trade_request_2_table",
                        TradeLootTables.EIGHTEEN_NETHERITE_COIN_VALUE_CURRENCY.toString());
        NETHERIAN_5_OFFER_2 = BUILDER
                .comment(" Netherian 5 Trade Offer 2 Table")
                .define("netherian_5_trade_offer_2_table",
                        TradeLootTables.NETHER_STAR_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // NETHERIAN TRADE GETTERS
    public static String getNetherian5Offer2() {
        if (Objects.equals(NETHERIAN_5_OFFER_2.get(), NETHERIAN_5_OFFER_2.getDefault())) {
            return NETHERIAN_5_OFFER_2.getDefault();
        }
        else {
            return NETHERIAN_5_OFFER_2.get();
        }
    }
    public static String getNetherian5Request2() {
        if (Objects.equals(NETHERIAN_5_REQUEST_2.get(), NETHERIAN_5_REQUEST_2.getDefault())) {
            return NETHERIAN_5_REQUEST_2.getDefault();
        }
        else {
            return NETHERIAN_5_REQUEST_2.get();
        }
    }
    public static String getNetherian5Offer1() {
        if (Objects.equals(NETHERIAN_5_OFFER_1.get(), NETHERIAN_5_OFFER_1.getDefault())) {
            return NETHERIAN_5_OFFER_1.getDefault();
        }
        else {
            return NETHERIAN_5_OFFER_1.get();
        }
    }
    public static String getNetherian5Request1() {
        if (Objects.equals(NETHERIAN_5_REQUEST_1.get(), NETHERIAN_5_REQUEST_1.getDefault())) {
            return NETHERIAN_5_REQUEST_1.getDefault();
        }
        else {
            return NETHERIAN_5_REQUEST_1.get();
        }
    }
    public static String getNetherian4Offer2() {
        if (Objects.equals(NETHERIAN_4_OFFER_2.get(), NETHERIAN_4_OFFER_2.getDefault())) {
            return NETHERIAN_4_OFFER_2.getDefault();
        }
        else {
            return NETHERIAN_4_OFFER_2.get();
        }
    }
    public static String getNetherian4Request2() {
        if (Objects.equals(NETHERIAN_4_REQUEST_2.get(), NETHERIAN_4_REQUEST_2.getDefault())) {
            return NETHERIAN_4_REQUEST_2.getDefault();
        }
        else {
            return NETHERIAN_4_REQUEST_2.get();
        }
    }
    public static String getNetherian4Offer1() {
        if (Objects.equals(NETHERIAN_4_OFFER_1.get(), NETHERIAN_4_OFFER_1.getDefault())) {
            return NETHERIAN_4_OFFER_1.getDefault();
        }
        else {
            return NETHERIAN_4_OFFER_1.get();
        }
    }
    public static String getNetherian4Request1() {
        if (Objects.equals(NETHERIAN_4_REQUEST_1.get(), NETHERIAN_4_REQUEST_1.getDefault())) {
            return NETHERIAN_4_REQUEST_1.getDefault();
        }
        else {
            return NETHERIAN_4_REQUEST_1.get();
        }
    }
    public static String getNetherian3Request2MapMarker() {
        if (Objects.equals(NETHERIAN_3_REQUEST_2_MAP_MARKER.get(), NETHERIAN_3_REQUEST_2_MAP_MARKER.getDefault())) {
            return NETHERIAN_3_REQUEST_2_MAP_MARKER.getDefault();
        }
        else {
            return NETHERIAN_3_REQUEST_2_MAP_MARKER.get();
        }
    }
    public static String getNetherian3Request2MapName() {
        if (Objects.equals(NETHERIAN_3_REQUEST_2_MAP_NAME.get(), NETHERIAN_3_REQUEST_2_MAP_NAME.getDefault())) {
            return NETHERIAN_3_REQUEST_2_MAP_NAME.getDefault();
        }
        else {
            return NETHERIAN_3_REQUEST_2_MAP_NAME.get();
        }
    }
    public static String getNetherian3Request2StructureTag() {
        if (Objects.equals(NETHERIAN_3_REQUEST_2_STRUCTURE_TAG.get(), NETHERIAN_3_REQUEST_2_STRUCTURE_TAG.getDefault())) {
            return NETHERIAN_3_REQUEST_2_STRUCTURE_TAG.getDefault();
        }
        else {
            return NETHERIAN_3_REQUEST_2_STRUCTURE_TAG.get();
        }
    }
    public static String getNetherian3Request2Secondary() {
        if (Objects.equals(NETHERIAN_3_REQUEST_2_SECONDARY.get(), NETHERIAN_3_REQUEST_2_SECONDARY.getDefault())) {
            return NETHERIAN_3_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return NETHERIAN_3_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getNetherian3Request2() {
        if (Objects.equals(NETHERIAN_3_REQUEST_2.get(), NETHERIAN_3_REQUEST_2.getDefault())) {
            return NETHERIAN_3_REQUEST_2.getDefault();
        }
        else {
            return NETHERIAN_3_REQUEST_2.get();
        }
    }
    public static String getNetherian3Offer1() {
        if (Objects.equals(NETHERIAN_3_OFFER_1.get(), NETHERIAN_3_OFFER_1.getDefault())) {
            return NETHERIAN_3_OFFER_1.getDefault();
        }
        else {
            return NETHERIAN_3_OFFER_1.get();
        }
    }
    public static String getNetherian3Request1() {
        if (Objects.equals(NETHERIAN_3_REQUEST_1.get(), NETHERIAN_3_REQUEST_1.getDefault())) {
            return NETHERIAN_3_REQUEST_1.getDefault();
        }
        else {
            return NETHERIAN_3_REQUEST_1.get();
        }
    }
    public static String getNetherian2Offer2() {
        if (Objects.equals(NETHERIAN_2_OFFER_2.get(), NETHERIAN_2_OFFER_2.getDefault())) {
            return NETHERIAN_2_OFFER_2.getDefault();
        }
        else {
            return NETHERIAN_2_OFFER_2.get();
        }
    }
    public static String getNetherian2Request2() {
        if (Objects.equals(NETHERIAN_2_REQUEST_2.get(), NETHERIAN_2_REQUEST_2.getDefault())) {
            return NETHERIAN_2_REQUEST_2.getDefault();
        }
        else {
            return NETHERIAN_2_REQUEST_2.get();
        }
    }
    public static String getNetherian2Offer1() {
        if (Objects.equals(NETHERIAN_2_OFFER_1.get(), NETHERIAN_2_OFFER_1.getDefault())) {
            return NETHERIAN_2_OFFER_1.getDefault();
        }
        else {
            return NETHERIAN_2_OFFER_1.get();
        }
    }
    public static String getNetherian2Request1() {
        if (Objects.equals(NETHERIAN_2_REQUEST_1.get(), NETHERIAN_2_REQUEST_1.getDefault())) {
            return NETHERIAN_2_REQUEST_1.getDefault();
        }
        else {
            return NETHERIAN_2_REQUEST_1.get();
        }
    }
    public static String getNetherian1Offer2() {
        if (Objects.equals(NETHERIAN_1_OFFER_2.get(), NETHERIAN_1_OFFER_2.getDefault())) {
            return NETHERIAN_1_OFFER_2.getDefault();
        }
        else {
            return NETHERIAN_1_OFFER_2.get();
        }
    }
    public static String getNetherian1Request2() {
        if (Objects.equals(NETHERIAN_1_REQUEST_2.get(), NETHERIAN_1_REQUEST_2.getDefault())) {
            return NETHERIAN_1_REQUEST_2.getDefault();
        }
        else {
            return NETHERIAN_1_REQUEST_2.get();
        }
    }
    public static String getNetherian1Offer1() {
        if (Objects.equals(NETHERIAN_1_OFFER_1.get(), NETHERIAN_1_OFFER_1.getDefault())) {
            return NETHERIAN_1_OFFER_1.getDefault();
        }
        else {
            return NETHERIAN_1_OFFER_1.get();
        }
    }
    public static String getNetherian1Request1() {
        if (Objects.equals(NETHERIAN_1_REQUEST_1.get(), NETHERIAN_1_REQUEST_1.getDefault())) {
            return NETHERIAN_1_REQUEST_1.getDefault();
        }
        else {
            return NETHERIAN_1_REQUEST_1.get();
        }
    }
}