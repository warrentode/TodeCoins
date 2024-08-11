package com.github.warrentode.todecoins.config.trades.morevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EngineerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Engineer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENGINEER_5_OFFER_2;

    static {
        // ENGINEER TRADES
        BUILDER.push(" Engineer Trade Settings");
        // level 1
        BUILDER.push(" Engineer Level One Trade One");
        ENGINEER_1_REQUEST_1 = BUILDER
                .comment(" Engineer 1 Trade Request 1 Table")
                .define("engineer_1_trade_request_1_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ENGINEER_1_OFFER_1 = BUILDER
                .comment(" Engineer 1 Trade Offer 1 Table")
                .define("engineer_1_trade_offer_1_table",
                        TradeLootTables.NINE_EMERALD_VALUE_REDSTONE.toString());
        BUILDER.pop();
        BUILDER.push(" Engineer Level One Trade Two");
        ENGINEER_1_REQUEST_2 = BUILDER
                .comment(" Engineer 1 Trade Request 2 Table")
                .define("engineer_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENGINEER_1_OFFER_2 = BUILDER
                .comment(" Engineer 1 Trade Offer 2 Table")
                .define("engineer_1_trade_offer_2_table",
                        TradeLootTables.REDSTONE_TORCH_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push(" Engineer Level Two Trade One");
        ENGINEER_2_REQUEST_1 = BUILDER
                .comment(" Engineer 2 Trade Request 1 Table")
                .define("engineer_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENGINEER_2_OFFER_1 = BUILDER
                .comment(" Engineer 2 Trade Offer 1 Table")
                .define("engineer_2_trade_offer_1_table",
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Engineer Level Two Trade Two");
        ENGINEER_2_REQUEST_2 = BUILDER
                .comment(" Engineer 2 Trade Request 2 Table")
                .define("engineer_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENGINEER_2_OFFER_2 = BUILDER
                .comment(" Engineer 2 Trade Offer 2 Table")
                .define("engineer_2_trade_offer_2_table",
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push(" Engineer Level Three Trade One");
        ENGINEER_3_REQUEST_1 = BUILDER
                .comment(" Engineer 3 Trade Request 1 Table")
                .define("engineer_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENGINEER_3_OFFER_1 = BUILDER
                .comment(" Engineer 3 Trade Offer 1 Table")
                .define("engineer_3_trade_offer_1_table",
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Engineer Level Three Trade Two");
        ENGINEER_3_REQUEST_2 = BUILDER
                .comment(" Engineer 3 Trade Request 2 Table")
                .define("engineer_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENGINEER_3_OFFER_2 = BUILDER
                .comment(" Engineer 3 Trade Offer 2 Table")
                .define("engineer_3_trade_offer_2_table",
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push(" Engineer Level Four Trade One");
        ENGINEER_4_REQUEST_1 = BUILDER
                .comment(" Engineer 4 Trade Request 1 Table")
                .define("engineer_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENGINEER_4_OFFER_1 = BUILDER
                .comment(" Engineer 4 Trade Offer 1 Table")
                .define("engineer_4_trade_offer_1_table",
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Engineer Level Four Trade Two");
        ENGINEER_4_REQUEST_2 = BUILDER
                .comment(" Engineer 4 Trade Request 2 Table")
                .define("engineer_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENGINEER_4_OFFER_2 = BUILDER
                .comment(" Engineer 4 Trade Offer 2 Table")
                .define("engineer_4_trade_offer_2_table",
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push(" Engineer Level Five Trade One");
        ENGINEER_5_REQUEST_1 = BUILDER
                .comment(" Engineer 5 Trade Request 1 Table")
                .define("engineer_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        ENGINEER_5_OFFER_1 = BUILDER
                .comment(" Engineer 5 Trade Offer 1 Table")
                .define("engineer_5_trade_offer_1_table",
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Engineer Level Five Trade Two");
        ENGINEER_5_REQUEST_2 = BUILDER
                .comment(" Engineer 5 Trade Request 2 Table")
                .define("engineer_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENGINEER_5_OFFER_2 = BUILDER
                .comment(" Engineer 5 Trade Offer 2 Table")
                .define("engineer_5_trade_offer_2_table",
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // ENGINEER TRADE GETTERS
    public static String getEngineer5Offer2() {
        if (Objects.equals(ENGINEER_5_OFFER_2.get(), ENGINEER_5_OFFER_2.getDefault())) {
            return ENGINEER_5_OFFER_2.getDefault();
        }
        else {
            return ENGINEER_5_OFFER_2.get();
        }
    }
    public static String getEngineer5Request2() {
        if (Objects.equals(ENGINEER_5_REQUEST_2.get(), ENGINEER_5_REQUEST_2.getDefault())) {
            return ENGINEER_5_REQUEST_2.getDefault();
        }
        else {
            return ENGINEER_5_REQUEST_2.get();
        }
    }
    public static String getEngineer5Offer1() {
        if (Objects.equals(ENGINEER_5_OFFER_1.get(), ENGINEER_5_OFFER_1.getDefault())) {
            return ENGINEER_5_OFFER_1.getDefault();
        }
        else {
            return ENGINEER_5_OFFER_1.get();
        }
    }
    public static String getEngineer5Request1() {
        if (Objects.equals(ENGINEER_5_REQUEST_1.get(), ENGINEER_5_REQUEST_1.getDefault())) {
            return ENGINEER_5_REQUEST_1.getDefault();
        }
        else {
            return ENGINEER_5_REQUEST_1.get();
        }
    }
    public static String getEngineer4Offer2() {
        if (Objects.equals(ENGINEER_4_OFFER_2.get(), ENGINEER_4_OFFER_2.getDefault())) {
            return ENGINEER_4_OFFER_2.getDefault();
        }
        else {
            return ENGINEER_4_OFFER_2.get();
        }
    }
    public static String getEngineer4Request2() {
        if (Objects.equals(ENGINEER_4_REQUEST_2.get(), ENGINEER_4_REQUEST_2.getDefault())) {
            return ENGINEER_4_REQUEST_2.getDefault();
        }
        else {
            return ENGINEER_4_REQUEST_2.get();
        }
    }
    public static String getEngineer4Offer1() {
        if (Objects.equals(ENGINEER_4_OFFER_1.get(), ENGINEER_4_OFFER_1.getDefault())) {
            return ENGINEER_4_OFFER_1.getDefault();
        }
        else {
            return ENGINEER_4_OFFER_1.get();
        }
    }
    public static String getEngineer4Request1() {
        if (Objects.equals(ENGINEER_4_REQUEST_1.get(), ENGINEER_4_REQUEST_1.getDefault())) {
            return ENGINEER_4_REQUEST_1.getDefault();
        }
        else {
            return ENGINEER_4_REQUEST_1.get();
        }
    }
    public static String getEngineer3Offer2() {
        if (Objects.equals(ENGINEER_3_OFFER_2.get(), ENGINEER_3_OFFER_2.getDefault())) {
            return ENGINEER_3_OFFER_2.getDefault();
        }
        else {
            return ENGINEER_3_OFFER_2.get();
        }
    }
    public static String getEngineer3Request2() {
        if (Objects.equals(ENGINEER_3_REQUEST_2.get(), ENGINEER_3_REQUEST_2.getDefault())) {
            return ENGINEER_3_REQUEST_2.getDefault();
        }
        else {
            return ENGINEER_3_REQUEST_2.get();
        }
    }
    public static String getEngineer3Offer1() {
        if (Objects.equals(ENGINEER_3_OFFER_1.get(), ENGINEER_3_OFFER_1.getDefault())) {
            return ENGINEER_3_OFFER_1.getDefault();
        }
        else {
            return ENGINEER_3_OFFER_1.get();
        }
    }
    public static String getEngineer3Request1() {
        if (Objects.equals(ENGINEER_3_REQUEST_1.get(), ENGINEER_3_REQUEST_1.getDefault())) {
            return ENGINEER_3_REQUEST_1.getDefault();
        }
        else {
            return ENGINEER_3_REQUEST_1.get();
        }
    }
    public static String getEngineer2Offer2() {
        if (Objects.equals(ENGINEER_2_OFFER_2.get(), ENGINEER_2_OFFER_2.getDefault())) {
            return ENGINEER_2_OFFER_2.getDefault();
        }
        else {
            return ENGINEER_2_OFFER_2.get();
        }
    }
    public static String getEngineer2Request2() {
        if (Objects.equals(ENGINEER_2_REQUEST_2.get(), ENGINEER_2_REQUEST_2.getDefault())) {
            return ENGINEER_2_REQUEST_2.getDefault();
        }
        else {
            return ENGINEER_2_REQUEST_2.get();
        }
    }
    public static String getEngineer2Offer1() {
        if (Objects.equals(ENGINEER_2_OFFER_1.get(), ENGINEER_2_OFFER_1.getDefault())) {
            return ENGINEER_2_OFFER_1.getDefault();
        }
        else {
            return ENGINEER_2_OFFER_1.get();
        }
    }
    public static String getEngineer2Request1() {
        if (Objects.equals(ENGINEER_2_REQUEST_1.get(), ENGINEER_2_REQUEST_1.getDefault())) {
            return ENGINEER_2_REQUEST_1.getDefault();
        }
        else {
            return ENGINEER_2_REQUEST_1.get();
        }
    }
    public static String getEngineer1Offer2() {
        if (Objects.equals(ENGINEER_1_OFFER_2.get(), ENGINEER_1_OFFER_2.getDefault())) {
            return ENGINEER_1_OFFER_2.getDefault();
        }
        else {
            return ENGINEER_1_OFFER_2.get();
        }
    }
    public static String getEngineer1Request2() {
        if (Objects.equals(ENGINEER_1_REQUEST_2.get(), ENGINEER_1_REQUEST_2.getDefault())) {
            return ENGINEER_1_REQUEST_2.getDefault();
        }
        else {
            return ENGINEER_1_REQUEST_2.get();
        }
    }
    public static String getEngineer1Offer1() {
        if (Objects.equals(ENGINEER_1_OFFER_1.get(), ENGINEER_1_OFFER_1.getDefault())) {
            return ENGINEER_1_OFFER_1.getDefault();
        }
        else {
            return ENGINEER_1_OFFER_1.get();
        }
    }
    public static String getEngineer1Request1() {
        if (Objects.equals(ENGINEER_1_REQUEST_1.get(), ENGINEER_1_REQUEST_1.getDefault())) {
            return ENGINEER_1_REQUEST_1.getDefault();
        }
        else {
            return ENGINEER_1_REQUEST_1.get();
        }
    }
}