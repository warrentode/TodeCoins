package com.github.warrentode.todecoins.config.trades.annabethsextravillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotterTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Potter Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> POTTER_5_OFFER_2;

    static {
        // POTTER TRADES
        BUILDER.push("Potter Trade Settings");
        // level 1
        BUILDER.push("Potter Level One Trade One");
        POTTER_1_REQUEST_1 = BUILDER
                .comment(" Potter 1 Trade Request 1 Table")
                .define("potter_1_trade_request_1_table",
                        TradeLootTables.CLAY_TABLE.toString());
        POTTER_1_OFFER_1 = BUILDER
                .comment(" Potter 1 Trade Offer 1 Table")
                .define("potter_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Potter Level One Trade Two");
        POTTER_1_REQUEST_2 = BUILDER
                .comment(" Potter 1 Trade Request 2 Table")
                .define("potter_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        POTTER_1_OFFER_2 = BUILDER
                .comment(" Potter 1 Trade Offer 2 Table")
                .define("potter_1_trade_offer_2_table",
                        TradeLootTables.FLOWER_POT_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Potter Level Two Trade One");
        POTTER_2_REQUEST_1 = BUILDER
                .comment(" Potter 2 Trade Request 1 Table")
                .define("potter_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        POTTER_2_OFFER_1 = BUILDER
                .comment(" Potter 2 Trade Offer 1 Table")
                .define("potter_2_trade_offer_1_table",
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Potter Level Two Trade Two");
        POTTER_2_REQUEST_2 = BUILDER
                .comment(" Potter 2 Trade Request 2 Table")
                .define("potter_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        POTTER_2_OFFER_2 = BUILDER
                .comment(" Potter 2 Trade Offer 2 Table")
                .define("potter_2_trade_offer_2_table",
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Potter Level Three Trade One");
        POTTER_3_REQUEST_1 = BUILDER
                .comment(" Potter 3 Trade Request 1 Table")
                .define("potter_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        POTTER_3_OFFER_1 = BUILDER
                .comment(" Potter 3 Trade Offer 1 Table")
                .define("potter_3_trade_offer_1_table",
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Potter Level Three Trade Two");
        POTTER_3_REQUEST_2 = BUILDER
                .comment(" Potter 3 Trade Request 2 Table")
                .define("potter_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        POTTER_3_OFFER_2 = BUILDER
                .comment(" Potter 3 Trade Offer 2 Table")
                .define("potter_3_trade_offer_2_table",
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Potter Level Four Trade One");
        POTTER_4_REQUEST_1 = BUILDER
                .comment(" Potter 4 Trade Request 1 Table")
                .define("potter_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        POTTER_4_OFFER_1 = BUILDER
                .comment(" Potter 4 Trade Offer 1 Table")
                .define("potter_4_trade_offer_1_table",
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Potter Level Four Trade Two");
        POTTER_4_REQUEST_2 = BUILDER
                .comment(" Potter 4 Trade Request 2 Table")
                .define("potter_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        POTTER_4_OFFER_2 = BUILDER
                .comment(" Potter 4 Trade Offer 2 Table")
                .define("potter_4_trade_offer_2_table",
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Potter Level Five Trade One");
        POTTER_5_REQUEST_1 = BUILDER
                .comment(" Potter 5 Trade Request 1 Table")
                .define("potter_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        POTTER_5_OFFER_1 = BUILDER
                .comment(" Potter 5 Trade Offer 1 Table")
                .define("potter_5_trade_offer_1_table",
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Potter Level Five Trade Two");
        POTTER_5_REQUEST_2 = BUILDER
                .comment(" Potter 5 Trade Request 2 Table")
                .define("potter_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        POTTER_5_OFFER_2 = BUILDER
                .comment(" Potter 5 Trade Offer 2 Table")
                .define("potter_5_trade_offer_2_table",
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // POTTER TRADE GETTERS
    public static String getPotter5Offer2() {
        if (Objects.equals(POTTER_5_OFFER_2.get(), POTTER_5_OFFER_2.getDefault())) {
            return POTTER_5_OFFER_2.getDefault();
        }
        else {
            return POTTER_5_OFFER_2.get();
        }
    }
    public static String getPotter5Request2() {
        if (Objects.equals(POTTER_5_REQUEST_2.get(), POTTER_5_REQUEST_2.getDefault())) {
            return POTTER_5_REQUEST_2.getDefault();
        }
        else {
            return POTTER_5_REQUEST_2.get();
        }
    }
    public static String getPotter5Offer1() {
        if (Objects.equals(POTTER_5_OFFER_1.get(), POTTER_5_OFFER_1.getDefault())) {
            return POTTER_5_OFFER_1.getDefault();
        }
        else {
            return POTTER_5_OFFER_1.get();
        }
    }
    public static String getPotter5Request1() {
        if (Objects.equals(POTTER_5_REQUEST_1.get(), POTTER_5_REQUEST_1.getDefault())) {
            return POTTER_5_REQUEST_1.getDefault();
        }
        else {
            return POTTER_5_REQUEST_1.get();
        }
    }
    public static String getPotter4Offer2() {
        if (Objects.equals(POTTER_4_OFFER_2.get(), POTTER_4_OFFER_2.getDefault())) {
            return POTTER_4_OFFER_2.getDefault();
        }
        else {
            return POTTER_4_OFFER_2.get();
        }
    }
    public static String getPotter4Request2() {
        if (Objects.equals(POTTER_4_REQUEST_2.get(), POTTER_4_REQUEST_2.getDefault())) {
            return POTTER_4_REQUEST_2.getDefault();
        }
        else {
            return POTTER_4_REQUEST_2.get();
        }
    }
    public static String getPotter4Offer1() {
        if (Objects.equals(POTTER_4_OFFER_1.get(), POTTER_4_OFFER_1.getDefault())) {
            return POTTER_4_OFFER_1.getDefault();
        }
        else {
            return POTTER_4_OFFER_1.get();
        }
    }
    public static String getPotter4Request1() {
        if (Objects.equals(POTTER_4_REQUEST_1.get(), POTTER_4_REQUEST_1.getDefault())) {
            return POTTER_4_REQUEST_1.getDefault();
        }
        else {
            return POTTER_4_REQUEST_1.get();
        }
    }
    public static String getPotter3Offer2() {
        if (Objects.equals(POTTER_3_OFFER_2.get(), POTTER_3_OFFER_2.getDefault())) {
            return POTTER_3_OFFER_2.getDefault();
        }
        else {
            return POTTER_3_OFFER_2.get();
        }
    }
    public static String getPotter3Request2() {
        if (Objects.equals(POTTER_3_REQUEST_2.get(), POTTER_3_REQUEST_2.getDefault())) {
            return POTTER_3_REQUEST_2.getDefault();
        }
        else {
            return POTTER_3_REQUEST_2.get();
        }
    }
    public static String getPotter3Offer1() {
        if (Objects.equals(POTTER_3_OFFER_1.get(), POTTER_3_OFFER_1.getDefault())) {
            return POTTER_3_OFFER_1.getDefault();
        }
        else {
            return POTTER_3_OFFER_1.get();
        }
    }
    public static String getPotter3Request1() {
        if (Objects.equals(POTTER_3_REQUEST_1.get(), POTTER_3_REQUEST_1.getDefault())) {
            return POTTER_3_REQUEST_1.getDefault();
        }
        else {
            return POTTER_3_REQUEST_1.get();
        }
    }
    public static String getPotter2Offer2() {
        if (Objects.equals(POTTER_2_OFFER_2.get(), POTTER_2_OFFER_2.getDefault())) {
            return POTTER_2_OFFER_2.getDefault();
        }
        else {
            return POTTER_2_OFFER_2.get();
        }
    }
    public static String getPotter2Request2() {
        if (Objects.equals(POTTER_2_REQUEST_2.get(), POTTER_2_REQUEST_2.getDefault())) {
            return POTTER_2_REQUEST_2.getDefault();
        }
        else {
            return POTTER_2_REQUEST_2.get();
        }
    }
    public static String getPotter2Offer1() {
        if (Objects.equals(POTTER_2_OFFER_1.get(), POTTER_2_OFFER_1.getDefault())) {
            return POTTER_2_OFFER_1.getDefault();
        }
        else {
            return POTTER_2_OFFER_1.get();
        }
    }
    public static String getPotter2Request1() {
        if (Objects.equals(POTTER_2_REQUEST_1.get(), POTTER_2_REQUEST_1.getDefault())) {
            return POTTER_2_REQUEST_1.getDefault();
        }
        else {
            return POTTER_2_REQUEST_1.get();
        }
    }
    public static String getPotter1Offer2() {
        if (Objects.equals(POTTER_1_OFFER_2.get(), POTTER_1_OFFER_2.getDefault())) {
            return POTTER_1_OFFER_2.getDefault();
        }
        else {
            return POTTER_1_OFFER_2.get();
        }
    }
    public static String getPotter1Request2() {
        if (Objects.equals(POTTER_1_REQUEST_2.get(), POTTER_1_REQUEST_2.getDefault())) {
            return POTTER_1_REQUEST_2.getDefault();
        }
        else {
            return POTTER_1_REQUEST_2.get();
        }
    }
    public static String getPotter1Offer1() {
        if (Objects.equals(POTTER_1_OFFER_1.get(), POTTER_1_OFFER_1.getDefault())) {
            return POTTER_1_OFFER_1.getDefault();
        }
        else {
            return POTTER_1_OFFER_1.get();
        }
    }
    public static String getPotter1Request1() {
        if (Objects.equals(POTTER_1_REQUEST_1.get(), POTTER_1_REQUEST_1.getDefault())) {
            return POTTER_1_REQUEST_1.getDefault();
        }
        else {
            return POTTER_1_REQUEST_1.get();
        }
    }
}