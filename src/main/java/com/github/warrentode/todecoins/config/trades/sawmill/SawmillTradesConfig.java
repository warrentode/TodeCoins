package com.github.warrentode.todecoins.config.trades.sawmill;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SawmillTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Sawmill Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SAWMILL_5_OFFER_2;

    static {
        // SAWMILL TRADES
        BUILDER.push(" Sawmill Trade Settings");
        // level 1
        BUILDER.push(" Sawmill Level One Trade One");
        SAWMILL_1_REQUEST_1 = BUILDER
                .comment(" Sawmill 1 Trade Request 1 Table")
                .define("sawmill_1_trade_request_1_table",
                        TradeLootTables.SAPLING_BUY_TABLE.toString());
        SAWMILL_1_OFFER_1 = BUILDER
                .comment(" Sawmill 1 Trade Offer 1 Table")
                .define("sawmill_1_trade_offer_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Sawmill Level One Trade Two");
        SAWMILL_1_REQUEST_2 = BUILDER
                .comment(" Sawmill 1 Trade Request 2 Table")
                .define("sawmill_1_trade_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        SAWMILL_1_OFFER_2 = BUILDER
                .comment(" Sawmill 1 Trade Offer 2 Table")
                .define("sawmill_1_trade_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push(" Sawmill Level Two Trade One");
        SAWMILL_2_REQUEST_1 = BUILDER
                .comment(" Sawmill 2 Trade Request 1 Table")
                .define("sawmill_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SAWMILL_2_OFFER_1 = BUILDER
                .comment(" Sawmill 2 Trade Offer 1 Table")
                .define("sawmill_2_trade_offer_1_table",
                        TradeLootTables.LOGS_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Sawmill Level Two Trade Two");
        SAWMILL_2_REQUEST_2 = BUILDER
                .comment(" Sawmill 2 Trade Request 2 Table")
                .define("sawmill_2_trade_request_2_table",
                        TradeLootTables.LOGS_BUY_TABLE.toString());
        SAWMILL_2_OFFER_2 = BUILDER
                .comment(" Sawmill 2 Trade Offer 2 Table")
                .define("sawmill_2_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push(" Sawmill Level Three Trade One");
        SAWMILL_3_REQUEST_1 = BUILDER
                .comment(" Sawmill 3 Trade Request 1 Table")
                .define("sawmill_3_trade_request_1_table",
                        TradeLootTables.SAPLING_BUY_TABLE.toString());
        SAWMILL_3_OFFER_1 = BUILDER
                .comment(" Sawmill 3 Trade Offer 1 Table")
                .define("sawmill_3_trade_offer_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Sawmill Level Three Trade Two");
        SAWMILL_3_REQUEST_2 = BUILDER
                .comment(" Sawmill 3 Trade Request 2 Table")
                .define("sawmill_3_trade_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        SAWMILL_3_OFFER_2 = BUILDER
                .comment(" Sawmill 3 Trade Offer 2 Table")
                .define("sawmill_3_trade_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push(" Sawmill Level Four Trade One");
        SAWMILL_4_REQUEST_1 = BUILDER
                .comment(" Sawmill 4 Trade Request 1 Table")
                .define("sawmill_4_trade_request_1_table",
                        TradeLootTables.LOGS_BUY_TABLE.toString());
        SAWMILL_4_OFFER_1 = BUILDER
                .comment(" Sawmill 4 Trade Offer 1 Table")
                .define("sawmill_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Sawmill Level Four Trade Two");
        SAWMILL_4_REQUEST_2 = BUILDER
                .comment(" Sawmill 4 Trade Request 2 Table")
                .define("sawmill_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SAWMILL_4_OFFER_2 = BUILDER
                .comment(" Sawmill 4 Trade Offer 2 Table")
                .define("sawmill_4_trade_offer_2_table",
                        TradeLootTables.LOGS_SELL_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push(" Sawmill Level Five Trade One")
                .comment(" Rare Trade");
        SAWMILL_5_REQUEST_1 = BUILDER
                .comment(" Sawmill 5 Trade Request 1 Table")
                .define("sawmill_5_trade_request_1_table",
                        TradeLootTables.SIXTEEN_EMERALD_TABLE.toString());
        SAWMILL_5_OFFER_1 = BUILDER
                .comment(" Sawmill 5 Trade Offer 1 Table")
                .define("sawmill_5_trade_offer_1_table",
                        TradeLootTables.IRON_TIER_LUMBER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Sawmill Level Five Trade Two");
        SAWMILL_5_REQUEST_2 = BUILDER
                .comment(" Sawmill 5 Trade Request 2 Table")
                .define("sawmill_5_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        SAWMILL_5_OFFER_2 = BUILDER
                .comment(" Sawmill 5 Trade Offer 2 Table")
                .define("sawmill_5_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_LUMBER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // SAWMILL TRADE GETTERS
    public static String getSawmill5Offer2() {
        if (Objects.equals(SAWMILL_5_OFFER_2.get(), SAWMILL_5_OFFER_2.getDefault())) {
            return SAWMILL_5_OFFER_2.getDefault();
        }
        else {
            return SAWMILL_5_OFFER_2.get();
        }
    }
    public static String getSawmill5Request2() {
        if (Objects.equals(SAWMILL_5_REQUEST_2.get(), SAWMILL_5_REQUEST_2.getDefault())) {
            return SAWMILL_5_REQUEST_2.getDefault();
        }
        else {
            return SAWMILL_5_REQUEST_2.get();
        }
    }
    public static String getSawmill5Offer1() {
        if (Objects.equals(SAWMILL_5_OFFER_1.get(), SAWMILL_5_OFFER_1.getDefault())) {
            return SAWMILL_5_OFFER_1.getDefault();
        }
        else {
            return SAWMILL_5_OFFER_1.get();
        }
    }
    public static String getSawmill5Request1() {
        if (Objects.equals(SAWMILL_5_REQUEST_1.get(), SAWMILL_5_REQUEST_1.getDefault())) {
            return SAWMILL_5_REQUEST_1.getDefault();
        }
        else {
            return SAWMILL_5_REQUEST_1.get();
        }
    }
    public static String getSawmill4Offer2() {
        if (Objects.equals(SAWMILL_4_OFFER_2.get(), SAWMILL_4_OFFER_2.getDefault())) {
            return SAWMILL_4_OFFER_2.getDefault();
        }
        else {
            return SAWMILL_4_OFFER_2.get();
        }
    }
    public static String getSawmill4Request2() {
        if (Objects.equals(SAWMILL_4_REQUEST_2.get(), SAWMILL_4_REQUEST_2.getDefault())) {
            return SAWMILL_4_REQUEST_2.getDefault();
        }
        else {
            return SAWMILL_4_REQUEST_2.get();
        }
    }
    public static String getSawmill4Offer1() {
        if (Objects.equals(SAWMILL_4_OFFER_1.get(), SAWMILL_4_OFFER_1.getDefault())) {
            return SAWMILL_4_OFFER_1.getDefault();
        }
        else {
            return SAWMILL_4_OFFER_1.get();
        }
    }
    public static String getSawmill4Request1() {
        if (Objects.equals(SAWMILL_4_REQUEST_1.get(), SAWMILL_4_REQUEST_1.getDefault())) {
            return SAWMILL_4_REQUEST_1.getDefault();
        }
        else {
            return SAWMILL_4_REQUEST_1.get();
        }
    }
    public static String getSawmill3Offer2() {
        if (Objects.equals(SAWMILL_3_OFFER_2.get(), SAWMILL_3_OFFER_2.getDefault())) {
            return SAWMILL_3_OFFER_2.getDefault();
        }
        else {
            return SAWMILL_3_OFFER_2.get();
        }
    }
    public static String getSawmill3Request2() {
        if (Objects.equals(SAWMILL_3_REQUEST_2.get(), SAWMILL_3_REQUEST_2.getDefault())) {
            return SAWMILL_3_REQUEST_2.getDefault();
        }
        else {
            return SAWMILL_3_REQUEST_2.get();
        }
    }
    public static String getSawmill3Offer1() {
        if (Objects.equals(SAWMILL_3_OFFER_1.get(), SAWMILL_3_OFFER_1.getDefault())) {
            return SAWMILL_3_OFFER_1.getDefault();
        }
        else {
            return SAWMILL_3_OFFER_1.get();
        }
    }
    public static String getSawmill3Request1() {
        if (Objects.equals(SAWMILL_3_REQUEST_1.get(), SAWMILL_3_REQUEST_1.getDefault())) {
            return SAWMILL_3_REQUEST_1.getDefault();
        }
        else {
            return SAWMILL_3_REQUEST_1.get();
        }
    }
    public static String getSawmill2Offer2() {
        if (Objects.equals(SAWMILL_2_OFFER_2.get(), SAWMILL_2_OFFER_2.getDefault())) {
            return SAWMILL_2_OFFER_2.getDefault();
        }
        else {
            return SAWMILL_2_OFFER_2.get();
        }
    }
    public static String getSawmill2Request2() {
        if (Objects.equals(SAWMILL_2_REQUEST_2.get(), SAWMILL_2_REQUEST_2.getDefault())) {
            return SAWMILL_2_REQUEST_2.getDefault();
        }
        else {
            return SAWMILL_2_REQUEST_2.get();
        }
    }
    public static String getSawmill2Offer1() {
        if (Objects.equals(SAWMILL_2_OFFER_1.get(), SAWMILL_2_OFFER_1.getDefault())) {
            return SAWMILL_2_OFFER_1.getDefault();
        }
        else {
            return SAWMILL_2_OFFER_1.get();
        }
    }
    public static String getSawmill2Request1() {
        if (Objects.equals(SAWMILL_2_REQUEST_1.get(), SAWMILL_2_REQUEST_1.getDefault())) {
            return SAWMILL_2_REQUEST_1.getDefault();
        }
        else {
            return SAWMILL_2_REQUEST_1.get();
        }
    }
    public static String getSawmill1Offer2() {
        if (Objects.equals(SAWMILL_1_OFFER_2.get(), SAWMILL_1_OFFER_2.getDefault())) {
            return SAWMILL_1_OFFER_2.getDefault();
        }
        else {
            return SAWMILL_1_OFFER_2.get();
        }
    }
    public static String getSawmill1Request2() {
        if (Objects.equals(SAWMILL_1_REQUEST_2.get(), SAWMILL_1_REQUEST_2.getDefault())) {
            return SAWMILL_1_REQUEST_2.getDefault();
        }
        else {
            return SAWMILL_1_REQUEST_2.get();
        }
    }
    public static String getSawmill1Offer1() {
        if (Objects.equals(SAWMILL_1_OFFER_1.get(), SAWMILL_1_OFFER_1.getDefault())) {
            return SAWMILL_1_OFFER_1.getDefault();
        }
        else {
            return SAWMILL_1_OFFER_1.get();
        }
    }
    public static String getSawmill1Request1() {
        if (Objects.equals(SAWMILL_1_REQUEST_1.get(), SAWMILL_1_REQUEST_1.getDefault())) {
            return SAWMILL_1_REQUEST_1.getDefault();
        }
        else {
            return SAWMILL_1_REQUEST_1.get();
        }
    }
}