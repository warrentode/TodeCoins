package com.github.warrentode.todecoins.config.trades.morevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WoodworkerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Woodworker Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WOODWORKER_5_OFFER_2;

    static {
        // WOODWORKER TRADES
        BUILDER.push(" Woodworker Trade Settings");
        // level 1
        BUILDER.push(" Woodworker Level One Trade One");
        WOODWORKER_1_REQUEST_1 = BUILDER
                .comment(" Woodworker 1 Trade Request 1 Table")
                .define("woodworker_1_trade_request_1_table",
                        TradeLootTables.SAPLING_BUY_TABLE.toString());
        WOODWORKER_1_OFFER_1 = BUILDER
                .comment(" Woodworker 1 Trade Offer 1 Table")
                .define("woodworker_1_trade_offer_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Woodworker Level One Trade Two");
        WOODWORKER_1_REQUEST_2 = BUILDER
                .comment(" Woodworker 1 Trade Request 2 Table")
                .define("woodworker_1_trade_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        WOODWORKER_1_OFFER_2 = BUILDER
                .comment(" Woodworker 1 Trade Offer 2 Table")
                .define("woodworker_1_trade_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push(" Woodworker Level Two Trade One");
        WOODWORKER_2_REQUEST_1 = BUILDER
                .comment(" Woodworker 2 Trade Request 1 Table")
                .define("woodworker_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WOODWORKER_2_OFFER_1 = BUILDER
                .comment(" Woodworker 2 Trade Offer 1 Table")
                .define("woodworker_2_trade_offer_1_table",
                        TradeLootTables.LOGS_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Woodworker Level Two Trade Two");
        WOODWORKER_2_REQUEST_2 = BUILDER
                .comment(" Woodworker 2 Trade Request 2 Table")
                .define("woodworker_2_trade_request_2_table",
                        TradeLootTables.LOGS_BUY_TABLE.toString());
        WOODWORKER_2_OFFER_2 = BUILDER
                .comment(" Woodworker 2 Trade Offer 2 Table")
                .define("woodworker_2_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push(" Woodworker Level Three Trade One");
        WOODWORKER_3_REQUEST_1 = BUILDER
                .comment(" Woodworker 3 Trade Request 1 Table")
                .define("woodworker_3_trade_request_1_table",
                        TradeLootTables.SAPLING_BUY_TABLE.toString());
        WOODWORKER_3_OFFER_1 = BUILDER
                .comment(" Woodworker 3 Trade Offer 1 Table")
                .define("woodworker_3_trade_offer_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Woodworker Level Three Trade Two");
        WOODWORKER_3_REQUEST_2 = BUILDER
                .comment(" Woodworker 3 Trade Request 2 Table")
                .define("woodworker_3_trade_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        WOODWORKER_3_OFFER_2 = BUILDER
                .comment(" Woodworker 3 Trade Offer 2 Table")
                .define("woodworker_3_trade_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push(" Woodworker Level Four Trade One");
        WOODWORKER_4_REQUEST_1 = BUILDER
                .comment(" Woodworker 4 Trade Request 1 Table")
                .define("woodworker_4_trade_request_1_table",
                        TradeLootTables.LOGS_BUY_TABLE.toString());
        WOODWORKER_4_OFFER_1 = BUILDER
                .comment(" Woodworker 4 Trade Offer 1 Table")
                .define("woodworker_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Woodworker Level Four Trade Two");
        WOODWORKER_4_REQUEST_2 = BUILDER
                .comment(" Woodworker 4 Trade Request 2 Table")
                .define("woodworker_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WOODWORKER_4_OFFER_2 = BUILDER
                .comment(" Woodworker 4 Trade Offer 2 Table")
                .define("woodworker_4_trade_offer_2_table",
                        TradeLootTables.LOGS_SELL_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push(" Woodworker Level Five Trade One")
                .comment(" Rare Trade");
        WOODWORKER_5_REQUEST_1 = BUILDER
                .comment(" Woodworker 5 Trade Request 1 Table")
                .define("woodworker_5_trade_request_1_table",
                        TradeLootTables.SIXTEEN_EMERALD_TABLE.toString());
        WOODWORKER_5_OFFER_1 = BUILDER
                .comment(" Woodworker 5 Trade Offer 1 Table")
                .define("woodworker_5_trade_offer_1_table",
                        TradeLootTables.IRON_TIER_LUMBER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Woodworker Level Five Trade Two");
        WOODWORKER_5_REQUEST_2 = BUILDER
                .comment(" Woodworker 5 Trade Request 2 Table")
                .define("woodworker_5_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        WOODWORKER_5_OFFER_2 = BUILDER
                .comment(" Woodworker 5 Trade Offer 2 Table")
                .define("woodworker_5_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_LUMBER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // WOODWORKER TRADE GETTERS
    public static String getWoodworker5Offer2() {
        if (Objects.equals(WOODWORKER_5_OFFER_2.get(), WOODWORKER_5_OFFER_2.getDefault())) {
            return WOODWORKER_5_OFFER_2.getDefault();
        }
        else {
            return WOODWORKER_5_OFFER_2.get();
        }
    }
    public static String getWoodworker5Request2() {
        if (Objects.equals(WOODWORKER_5_REQUEST_2.get(), WOODWORKER_5_REQUEST_2.getDefault())) {
            return WOODWORKER_5_REQUEST_2.getDefault();
        }
        else {
            return WOODWORKER_5_REQUEST_2.get();
        }
    }
    public static String getWoodworker5Offer1() {
        if (Objects.equals(WOODWORKER_5_OFFER_1.get(), WOODWORKER_5_OFFER_1.getDefault())) {
            return WOODWORKER_5_OFFER_1.getDefault();
        }
        else {
            return WOODWORKER_5_OFFER_1.get();
        }
    }
    public static String getWoodworker5Request1() {
        if (Objects.equals(WOODWORKER_5_REQUEST_1.get(), WOODWORKER_5_REQUEST_1.getDefault())) {
            return WOODWORKER_5_REQUEST_1.getDefault();
        }
        else {
            return WOODWORKER_5_REQUEST_1.get();
        }
    }
    public static String getWoodworker4Offer2() {
        if (Objects.equals(WOODWORKER_4_OFFER_2.get(), WOODWORKER_4_OFFER_2.getDefault())) {
            return WOODWORKER_4_OFFER_2.getDefault();
        }
        else {
            return WOODWORKER_4_OFFER_2.get();
        }
    }
    public static String getWoodworker4Request2() {
        if (Objects.equals(WOODWORKER_4_REQUEST_2.get(), WOODWORKER_4_REQUEST_2.getDefault())) {
            return WOODWORKER_4_REQUEST_2.getDefault();
        }
        else {
            return WOODWORKER_4_REQUEST_2.get();
        }
    }
    public static String getWoodworker4Offer1() {
        if (Objects.equals(WOODWORKER_4_OFFER_1.get(), WOODWORKER_4_OFFER_1.getDefault())) {
            return WOODWORKER_4_OFFER_1.getDefault();
        }
        else {
            return WOODWORKER_4_OFFER_1.get();
        }
    }
    public static String getWoodworker4Request1() {
        if (Objects.equals(WOODWORKER_4_REQUEST_1.get(), WOODWORKER_4_REQUEST_1.getDefault())) {
            return WOODWORKER_4_REQUEST_1.getDefault();
        }
        else {
            return WOODWORKER_4_REQUEST_1.get();
        }
    }
    public static String getWoodworker3Offer2() {
        if (Objects.equals(WOODWORKER_3_OFFER_2.get(), WOODWORKER_3_OFFER_2.getDefault())) {
            return WOODWORKER_3_OFFER_2.getDefault();
        }
        else {
            return WOODWORKER_3_OFFER_2.get();
        }
    }
    public static String getWoodworker3Request2() {
        if (Objects.equals(WOODWORKER_3_REQUEST_2.get(), WOODWORKER_3_REQUEST_2.getDefault())) {
            return WOODWORKER_3_REQUEST_2.getDefault();
        }
        else {
            return WOODWORKER_3_REQUEST_2.get();
        }
    }
    public static String getWoodworker3Offer1() {
        if (Objects.equals(WOODWORKER_3_OFFER_1.get(), WOODWORKER_3_OFFER_1.getDefault())) {
            return WOODWORKER_3_OFFER_1.getDefault();
        }
        else {
            return WOODWORKER_3_OFFER_1.get();
        }
    }
    public static String getWoodworker3Request1() {
        if (Objects.equals(WOODWORKER_3_REQUEST_1.get(), WOODWORKER_3_REQUEST_1.getDefault())) {
            return WOODWORKER_3_REQUEST_1.getDefault();
        }
        else {
            return WOODWORKER_3_REQUEST_1.get();
        }
    }
    public static String getWoodworker2Offer2() {
        if (Objects.equals(WOODWORKER_2_OFFER_2.get(), WOODWORKER_2_OFFER_2.getDefault())) {
            return WOODWORKER_2_OFFER_2.getDefault();
        }
        else {
            return WOODWORKER_2_OFFER_2.get();
        }
    }
    public static String getWoodworker2Request2() {
        if (Objects.equals(WOODWORKER_2_REQUEST_2.get(), WOODWORKER_2_REQUEST_2.getDefault())) {
            return WOODWORKER_2_REQUEST_2.getDefault();
        }
        else {
            return WOODWORKER_2_REQUEST_2.get();
        }
    }
    public static String getWoodworker2Offer1() {
        if (Objects.equals(WOODWORKER_2_OFFER_1.get(), WOODWORKER_2_OFFER_1.getDefault())) {
            return WOODWORKER_2_OFFER_1.getDefault();
        }
        else {
            return WOODWORKER_2_OFFER_1.get();
        }
    }
    public static String getWoodworker2Request1() {
        if (Objects.equals(WOODWORKER_2_REQUEST_1.get(), WOODWORKER_2_REQUEST_1.getDefault())) {
            return WOODWORKER_2_REQUEST_1.getDefault();
        }
        else {
            return WOODWORKER_2_REQUEST_1.get();
        }
    }
    public static String getWoodworker1Offer2() {
        if (Objects.equals(WOODWORKER_1_OFFER_2.get(), WOODWORKER_1_OFFER_2.getDefault())) {
            return WOODWORKER_1_OFFER_2.getDefault();
        }
        else {
            return WOODWORKER_1_OFFER_2.get();
        }
    }
    public static String getWoodworker1Request2() {
        if (Objects.equals(WOODWORKER_1_REQUEST_2.get(), WOODWORKER_1_REQUEST_2.getDefault())) {
            return WOODWORKER_1_REQUEST_2.getDefault();
        }
        else {
            return WOODWORKER_1_REQUEST_2.get();
        }
    }
    public static String getWoodworker1Offer1() {
        if (Objects.equals(WOODWORKER_1_OFFER_1.get(), WOODWORKER_1_OFFER_1.getDefault())) {
            return WOODWORKER_1_OFFER_1.getDefault();
        }
        else {
            return WOODWORKER_1_OFFER_1.get();
        }
    }
    public static String getWoodworker1Request1() {
        if (Objects.equals(WOODWORKER_1_REQUEST_1.get(), WOODWORKER_1_REQUEST_1.getDefault())) {
            return WOODWORKER_1_REQUEST_1.getDefault();
        }
        else {
            return WOODWORKER_1_REQUEST_1.get();
        }
    }
}