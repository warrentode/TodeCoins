package com.github.warrentode.todecoins.config.trades.annabethsextravillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CarpenterTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Carpenter Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARPENTER_5_OFFER_2;

    static {
        // CARPENTER TRADES
        BUILDER.push(" Carpenter Trade Settings");
        // level 1
        BUILDER.push(" Carpenter Level One Trade One");
        CARPENTER_1_REQUEST_1 = BUILDER
                .comment(" Carpenter 1 Trade Request 1 Table")
                .define("carpenter_1_trade_request_1_table",
                        TradeLootTables.SAPLING_BUY_TABLE.toString());
        CARPENTER_1_OFFER_1 = BUILDER
                .comment(" Carpenter 1 Trade Offer 1 Table")
                .define("carpenter_1_trade_offer_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Carpenter Level One Trade Two");
        CARPENTER_1_REQUEST_2 = BUILDER
                .comment(" Carpenter 1 Trade Request 2 Table")
                .define("carpenter_1_trade_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        CARPENTER_1_OFFER_2 = BUILDER
                .comment(" Carpenter 1 Trade Offer 2 Table")
                .define("carpenter_1_trade_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push(" Carpenter Level Two Trade One");
        CARPENTER_2_REQUEST_1 = BUILDER
                .comment(" Carpenter 2 Trade Request 1 Table")
                .define("carpenter_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CARPENTER_2_OFFER_1 = BUILDER
                .comment(" Carpenter 2 Trade Offer 1 Table")
                .define("carpenter_2_trade_offer_1_table",
                        TradeLootTables.LOGS_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Carpenter Level Two Trade Two");
        CARPENTER_2_REQUEST_2 = BUILDER
                .comment(" Carpenter 2 Trade Request 2 Table")
                .define("carpenter_2_trade_request_2_table",
                        TradeLootTables.LOGS_BUY_TABLE.toString());
        CARPENTER_2_OFFER_2 = BUILDER
                .comment(" Carpenter 2 Trade Offer 2 Table")
                .define("carpenter_2_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push(" Carpenter Level Three Trade One");
        CARPENTER_3_REQUEST_1 = BUILDER
                .comment(" Carpenter 3 Trade Request 1 Table")
                .define("carpenter_3_trade_request_1_table",
                        TradeLootTables.SAPLING_BUY_TABLE.toString());
        CARPENTER_3_OFFER_1 = BUILDER
                .comment(" Carpenter 3 Trade Offer 1 Table")
                .define("carpenter_3_trade_offer_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Carpenter Level Three Trade Two");
        CARPENTER_3_REQUEST_2 = BUILDER
                .comment(" Carpenter 3 Trade Request 2 Table")
                .define("carpenter_3_trade_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        CARPENTER_3_OFFER_2 = BUILDER
                .comment(" Carpenter 3 Trade Offer 2 Table")
                .define("carpenter_3_trade_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push(" Carpenter Level Four Trade One");
        CARPENTER_4_REQUEST_1 = BUILDER
                .comment(" Carpenter 4 Trade Request 1 Table")
                .define("carpenter_4_trade_request_1_table",
                        TradeLootTables.LOGS_BUY_TABLE.toString());
        CARPENTER_4_OFFER_1 = BUILDER
                .comment(" Carpenter 4 Trade Offer 1 Table")
                .define("carpenter_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Carpenter Level Four Trade Two");
        CARPENTER_4_REQUEST_2 = BUILDER
                .comment(" Carpenter 4 Trade Request 2 Table")
                .define("carpenter_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CARPENTER_4_OFFER_2 = BUILDER
                .comment(" Carpenter 4 Trade Offer 2 Table")
                .define("carpenter_4_trade_offer_2_table",
                        TradeLootTables.LOGS_SELL_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push(" Carpenter Level Five Trade One")
                .comment(" Rare Trade");
        CARPENTER_5_REQUEST_1 = BUILDER
                .comment(" Carpenter 5 Trade Request 1 Table")
                .define("carpenter_5_trade_request_1_table",
                        TradeLootTables.SIXTEEN_EMERALD_TABLE.toString());
        CARPENTER_5_OFFER_1 = BUILDER
                .comment(" Carpenter 5 Trade Offer 1 Table")
                .define("carpenter_5_trade_offer_1_table",
                        TradeLootTables.IRON_TIER_LUMBER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Carpenter Level Five Trade Two");
        CARPENTER_5_REQUEST_2 = BUILDER
                .comment(" Carpenter 5 Trade Request 2 Table")
                .define("carpenter_5_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        CARPENTER_5_OFFER_2 = BUILDER
                .comment(" Carpenter 5 Trade Offer 2 Table")
                .define("carpenter_5_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_LUMBER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // CARPENTER TRADE GETTERS
    public static String getCarpenter5Offer2() {
        if (Objects.equals(CARPENTER_5_OFFER_2.get(), CARPENTER_5_OFFER_2.getDefault())) {
            return CARPENTER_5_OFFER_2.getDefault();
        }
        else {
            return CARPENTER_5_OFFER_2.get();
        }
    }
    public static String getCarpenter5Request2() {
        if (Objects.equals(CARPENTER_5_REQUEST_2.get(), CARPENTER_5_REQUEST_2.getDefault())) {
            return CARPENTER_5_REQUEST_2.getDefault();
        }
        else {
            return CARPENTER_5_REQUEST_2.get();
        }
    }
    public static String getCarpenter5Offer1() {
        if (Objects.equals(CARPENTER_5_OFFER_1.get(), CARPENTER_5_OFFER_1.getDefault())) {
            return CARPENTER_5_OFFER_1.getDefault();
        }
        else {
            return CARPENTER_5_OFFER_1.get();
        }
    }
    public static String getCarpenter5Request1() {
        if (Objects.equals(CARPENTER_5_REQUEST_1.get(), CARPENTER_5_REQUEST_1.getDefault())) {
            return CARPENTER_5_REQUEST_1.getDefault();
        }
        else {
            return CARPENTER_5_REQUEST_1.get();
        }
    }
    public static String getCarpenter4Offer2() {
        if (Objects.equals(CARPENTER_4_OFFER_2.get(), CARPENTER_4_OFFER_2.getDefault())) {
            return CARPENTER_4_OFFER_2.getDefault();
        }
        else {
            return CARPENTER_4_OFFER_2.get();
        }
    }
    public static String getCarpenter4Request2() {
        if (Objects.equals(CARPENTER_4_REQUEST_2.get(), CARPENTER_4_REQUEST_2.getDefault())) {
            return CARPENTER_4_REQUEST_2.getDefault();
        }
        else {
            return CARPENTER_4_REQUEST_2.get();
        }
    }
    public static String getCarpenter4Offer1() {
        if (Objects.equals(CARPENTER_4_OFFER_1.get(), CARPENTER_4_OFFER_1.getDefault())) {
            return CARPENTER_4_OFFER_1.getDefault();
        }
        else {
            return CARPENTER_4_OFFER_1.get();
        }
    }
    public static String getCarpenter4Request1() {
        if (Objects.equals(CARPENTER_4_REQUEST_1.get(), CARPENTER_4_REQUEST_1.getDefault())) {
            return CARPENTER_4_REQUEST_1.getDefault();
        }
        else {
            return CARPENTER_4_REQUEST_1.get();
        }
    }
    public static String getCarpenter3Offer2() {
        if (Objects.equals(CARPENTER_3_OFFER_2.get(), CARPENTER_3_OFFER_2.getDefault())) {
            return CARPENTER_3_OFFER_2.getDefault();
        }
        else {
            return CARPENTER_3_OFFER_2.get();
        }
    }
    public static String getCarpenter3Request2() {
        if (Objects.equals(CARPENTER_3_REQUEST_2.get(), CARPENTER_3_REQUEST_2.getDefault())) {
            return CARPENTER_3_REQUEST_2.getDefault();
        }
        else {
            return CARPENTER_3_REQUEST_2.get();
        }
    }
    public static String getCarpenter3Offer1() {
        if (Objects.equals(CARPENTER_3_OFFER_1.get(), CARPENTER_3_OFFER_1.getDefault())) {
            return CARPENTER_3_OFFER_1.getDefault();
        }
        else {
            return CARPENTER_3_OFFER_1.get();
        }
    }
    public static String getCarpenter3Request1() {
        if (Objects.equals(CARPENTER_3_REQUEST_1.get(), CARPENTER_3_REQUEST_1.getDefault())) {
            return CARPENTER_3_REQUEST_1.getDefault();
        }
        else {
            return CARPENTER_3_REQUEST_1.get();
        }
    }
    public static String getCarpenter2Offer2() {
        if (Objects.equals(CARPENTER_2_OFFER_2.get(), CARPENTER_2_OFFER_2.getDefault())) {
            return CARPENTER_2_OFFER_2.getDefault();
        }
        else {
            return CARPENTER_2_OFFER_2.get();
        }
    }
    public static String getCarpenter2Request2() {
        if (Objects.equals(CARPENTER_2_REQUEST_2.get(), CARPENTER_2_REQUEST_2.getDefault())) {
            return CARPENTER_2_REQUEST_2.getDefault();
        }
        else {
            return CARPENTER_2_REQUEST_2.get();
        }
    }
    public static String getCarpenter2Offer1() {
        if (Objects.equals(CARPENTER_2_OFFER_1.get(), CARPENTER_2_OFFER_1.getDefault())) {
            return CARPENTER_2_OFFER_1.getDefault();
        }
        else {
            return CARPENTER_2_OFFER_1.get();
        }
    }
    public static String getCarpenter2Request1() {
        if (Objects.equals(CARPENTER_2_REQUEST_1.get(), CARPENTER_2_REQUEST_1.getDefault())) {
            return CARPENTER_2_REQUEST_1.getDefault();
        }
        else {
            return CARPENTER_2_REQUEST_1.get();
        }
    }
    public static String getCarpenter1Offer2() {
        if (Objects.equals(CARPENTER_1_OFFER_2.get(), CARPENTER_1_OFFER_2.getDefault())) {
            return CARPENTER_1_OFFER_2.getDefault();
        }
        else {
            return CARPENTER_1_OFFER_2.get();
        }
    }
    public static String getCarpenter1Request2() {
        if (Objects.equals(CARPENTER_1_REQUEST_2.get(), CARPENTER_1_REQUEST_2.getDefault())) {
            return CARPENTER_1_REQUEST_2.getDefault();
        }
        else {
            return CARPENTER_1_REQUEST_2.get();
        }
    }
    public static String getCarpenter1Offer1() {
        if (Objects.equals(CARPENTER_1_OFFER_1.get(), CARPENTER_1_OFFER_1.getDefault())) {
            return CARPENTER_1_OFFER_1.getDefault();
        }
        else {
            return CARPENTER_1_OFFER_1.get();
        }
    }
    public static String getCarpenter1Request1() {
        if (Objects.equals(CARPENTER_1_REQUEST_1.get(), CARPENTER_1_REQUEST_1.getDefault())) {
            return CARPENTER_1_REQUEST_1.getDefault();
        }
        else {
            return CARPENTER_1_REQUEST_1.get();
        }
    }
}