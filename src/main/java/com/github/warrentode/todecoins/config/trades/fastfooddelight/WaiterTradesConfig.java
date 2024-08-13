package com.github.warrentode.todecoins.config.trades.fastfooddelight;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WaiterTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Waiter Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_1_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WAITER_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> WAITER_5_OFFER_2_COUNT;

    static {
        // WAITER TRADES
        BUILDER.push("Waiter Trade Settings");
        // level 1
        BUILDER.push("Waiter Level One Trade One");
        WAITER_1_REQUEST_1 = BUILDER
                .comment(" Waiter 1 Trade Request 1 Table")
                .define("waiter_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_1_OFFER_1 = BUILDER
                .comment(" Waiter 1 Trade Offer 1 Table")
                .define("waiter_1_trade_offer_1_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        WAITER_1_OFFER_1_COUNT = BUILDER
                .define("waiter_1_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Waiter Level One Trade Two");
        WAITER_1_REQUEST_2 = BUILDER
                .comment(" Waiter 1 Trade Request 2 Table")
                .define("waiter_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_1_OFFER_2 = BUILDER
                .comment(" Waiter 1 Trade Offer 2 Table")
                .define("waiter_1_trade_offer_2_table",
                        TradeLootTables.SIDE_DISH_TAG_TABLE.toString());
        WAITER_1_OFFER_2_COUNT = BUILDER
                .define("waiter_1_trade_offer_2_count", 6);
        BUILDER.pop();
        // level 2
        BUILDER.push("Waiter Level Two Trade One");
        WAITER_2_REQUEST_1 = BUILDER
                .comment(" Waiter 2 Trade Request 1 Table")
                .define("waiter_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_2_OFFER_1 = BUILDER
                .comment(" Waiter 2 Trade Offer 1 Table")
                .define("waiter_2_trade_offer_1_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        WAITER_2_OFFER_1_COUNT = BUILDER
                .define("waiter_2_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Waiter Level Two Trade Two");
        WAITER_2_REQUEST_2 = BUILDER
                .comment(" Waiter 2 Trade Request 2 Table")
                .define("waiter_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_2_OFFER_2 = BUILDER
                .comment(" Waiter 2 Trade Offer 2 Table")
                .define("waiter_2_trade_offer_2_table",
                        TradeLootTables.SANDWICH_TAG_TABLE.toString());
        WAITER_2_OFFER_2_COUNT = BUILDER
                .define("waiter_2_trade_offer_2_count", 6);
        BUILDER.pop();
        // level 3
        BUILDER.push("Waiter Level Three Trade One");
        WAITER_3_REQUEST_1 = BUILDER
                .comment(" Waiter 3 Trade Request 1 Table")
                .define("waiter_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_3_OFFER_1 = BUILDER
                .comment(" Waiter 3 Trade Offer 1 Table")
                .define("waiter_3_trade_offer_1_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        WAITER_3_OFFER_1_COUNT = BUILDER
                .define("waiter_3_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Waiter Level Three Trade Two");
        WAITER_3_REQUEST_2 = BUILDER
                .comment(" Waiter 3 Trade Request 2 Table")
                .define("waiter_3_trade_request_2_count",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_3_OFFER_2 = BUILDER
                .comment(" Waiter 3 Trade Offer 2 Table")
                .define("waiter_3_trade_offer_2_table",
                        TradeLootTables.SOUP_TAG_TABLE.toString());
        WAITER_3_OFFER_2_COUNT = BUILDER
                .define("waiter_3_trade_offer_2_count", 1);
        BUILDER.pop();
        // level 4
        BUILDER.push("Waiter Level Four Trade One");
        WAITER_4_REQUEST_1 = BUILDER
                .comment(" Waiter 4 Trade Request 1 Table")
                .define("waiter_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_4_OFFER_1 = BUILDER
                .comment(" Waiter 4 Trade Offer 1 Table")
                .define("waiter_4_trade_offer_1_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        WAITER_4_OFFER_1_COUNT = BUILDER
                .define("waiter_4_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Waiter Level Four Trade Two");
        WAITER_4_REQUEST_2 = BUILDER
                .comment(" Waiter 4 Trade Request 2 Table")
                .define("waiter_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_4_OFFER_2 = BUILDER
                .comment(" Waiter 4 Trade Offer 2 Table")
                .define("waiter_4_trade_offer_2_table",
                        TradeLootTables.PLATED_FOODS_TAG_TABLE.toString());
        WAITER_4_OFFER_2_COUNT = BUILDER
                .define("waiter_3_trade_offer_2_count", 4);
        BUILDER.pop();
        // level 5
        BUILDER.push("Waiter Level Five Trade One")
                .comment(" Rare Trade");
        WAITER_5_REQUEST_1 = BUILDER
                .comment(" Waiter 5 Trade Request 1 Table")
                .define("waiter_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_5_OFFER_1 = BUILDER
                .comment(" Waiter 5 Trade Offer 1 Table")
                .define("waiter_5_trade_offer_1_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        WAITER_5_OFFER_1_COUNT = BUILDER
                .define("waiter_5_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Waiter Level Five Trade Two")
                .comment(" Rare Trade");
        WAITER_5_REQUEST_2 = BUILDER
                .comment(" Waiter 5 Trade Request 2 Table")
                .define("waiter_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WAITER_5_OFFER_2 = BUILDER
                .comment(" Waiter 5 Trade Offer 2 Table")
                .define("waiter_5_trade_offer_2_table",
                        TradeLootTables.DESSERT_TAG_TABLE.toString());
        WAITER_5_OFFER_2_COUNT = BUILDER
                .define("waiter_5_trade_offer_2_count", 1);
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // WAITER TRADE GETTERS
    public static int getWaiter5Offer2Count() {
        if (Objects.equals(WAITER_5_OFFER_2_COUNT.get(), WAITER_5_OFFER_2_COUNT.getDefault())) {
            return WAITER_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return WAITER_5_OFFER_2_COUNT.get();
        }
    }
    public static String getWaiter5Offer2() {
        if (Objects.equals(WAITER_5_OFFER_2.get(), WAITER_5_OFFER_2.getDefault())) {
            return WAITER_5_OFFER_2.getDefault();
        }
        else {
            return WAITER_5_OFFER_2.get();
        }
    }
    public static String getWaiter5Request2() {
        if (Objects.equals(WAITER_5_REQUEST_2.get(), WAITER_5_REQUEST_2.getDefault())) {
            return WAITER_5_REQUEST_2.getDefault();
        }
        else {
            return WAITER_5_REQUEST_2.get();
        }
    }
    public static int getWaiter5Offer1Count() {
        if (Objects.equals(WAITER_5_OFFER_1_COUNT.get(), WAITER_5_OFFER_1_COUNT.getDefault())) {
            return WAITER_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return WAITER_5_OFFER_1_COUNT.get();
        }
    }
    public static String getWaiter5Offer1() {
        if (Objects.equals(WAITER_5_OFFER_1.get(), WAITER_5_OFFER_1.getDefault())) {
            return WAITER_5_OFFER_1.getDefault();
        }
        else {
            return WAITER_5_OFFER_1.get();
        }
    }
    public static String getWaiter5Request1() {
        if (Objects.equals(WAITER_5_REQUEST_1.get(), WAITER_5_REQUEST_1.getDefault())) {
            return WAITER_5_REQUEST_1.getDefault();
        }
        else {
            return WAITER_5_REQUEST_1.get();
        }
    }
    public static int getWaiter4Offer2Count() {
        if (Objects.equals(WAITER_4_OFFER_2_COUNT.get(), WAITER_4_OFFER_2_COUNT.getDefault())) {
            return WAITER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return WAITER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getWaiter4Offer2() {
        if (Objects.equals(WAITER_4_OFFER_2.get(), WAITER_4_OFFER_2.getDefault())) {
            return WAITER_4_OFFER_2.getDefault();
        }
        else {
            return WAITER_4_OFFER_2.get();
        }
    }
    public static String getWaiter4Request2() {
        if (Objects.equals(WAITER_4_REQUEST_2.get(), WAITER_4_REQUEST_2.getDefault())) {
            return WAITER_4_REQUEST_2.getDefault();
        }
        else {
            return WAITER_4_REQUEST_2.get();
        }
    }
    public static int getWaiter4Offer1Count() {
        if (Objects.equals(WAITER_4_OFFER_1_COUNT.get(), WAITER_4_OFFER_1_COUNT.getDefault())) {
            return WAITER_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return WAITER_4_OFFER_1_COUNT.get();
        }
    }
    public static String getWaiter4Offer1() {
        if (Objects.equals(WAITER_4_OFFER_1.get(), WAITER_4_OFFER_1.getDefault())) {
            return WAITER_4_OFFER_1.getDefault();
        }
        else {
            return WAITER_4_OFFER_1.get();
        }
    }
    public static String getWaiter4Request1() {
        if (Objects.equals(WAITER_4_REQUEST_1.get(), WAITER_4_REQUEST_1.getDefault())) {
            return WAITER_4_REQUEST_1.getDefault();
        }
        else {
            return WAITER_4_REQUEST_1.get();
        }
    }
    public static int getWaiter3Offer2Count() {
        if (Objects.equals(WAITER_3_OFFER_2_COUNT.get(), WAITER_3_OFFER_2_COUNT.getDefault())) {
            return WAITER_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return WAITER_3_OFFER_2_COUNT.get();
        }
    }
    public static String getWaiter3Offer2() {
        if (Objects.equals(WAITER_3_OFFER_2.get(), WAITER_3_OFFER_2.getDefault())) {
            return WAITER_3_OFFER_2.getDefault();
        }
        else {
            return WAITER_3_OFFER_2.get();
        }
    }
    public static String getWaiter3Request2() {
        if (Objects.equals(WAITER_3_REQUEST_2.get(), WAITER_3_REQUEST_2.getDefault())) {
            return WAITER_3_REQUEST_2.getDefault();
        }
        else {
            return WAITER_3_REQUEST_2.get();
        }
    }
    public static int getWaiter3Offer1Count() {
        if (Objects.equals(WAITER_3_OFFER_1_COUNT.get(), WAITER_3_OFFER_1_COUNT.getDefault())) {
            return WAITER_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return WAITER_3_OFFER_1_COUNT.get();
        }
    }
    public static String getWaiter3Offer1() {
        if (Objects.equals(WAITER_3_OFFER_1.get(), WAITER_3_OFFER_1.getDefault())) {
            return WAITER_3_OFFER_1.getDefault();
        }
        else {
            return WAITER_3_OFFER_1.get();
        }
    }
    public static String getWaiter3Request1() {
        if (Objects.equals(WAITER_3_REQUEST_1.get(), WAITER_3_REQUEST_1.getDefault())) {
            return WAITER_3_REQUEST_1.getDefault();
        }
        else {
            return WAITER_3_REQUEST_1.get();
        }
    }
    public static int getWaiter2Offer2Count() {
        if (Objects.equals(WAITER_2_OFFER_2_COUNT.get(), WAITER_2_OFFER_2_COUNT.getDefault())) {
            return WAITER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return WAITER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getWaiter2Offer2() {
        if (Objects.equals(WAITER_2_OFFER_2.get(), WAITER_2_OFFER_2.getDefault())) {
            return WAITER_2_OFFER_2.getDefault();
        }
        else {
            return WAITER_2_OFFER_2.get();
        }
    }
    public static String getWaiter2Request2() {
        if (Objects.equals(WAITER_2_REQUEST_2.get(), WAITER_2_REQUEST_2.getDefault())) {
            return WAITER_2_REQUEST_2.getDefault();
        }
        else {
            return WAITER_2_REQUEST_2.get();
        }
    }
    public static int getWaiter2Offer1Count() {
        if (Objects.equals(WAITER_2_OFFER_1_COUNT.get(), WAITER_2_OFFER_1_COUNT.getDefault())) {
            return WAITER_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return WAITER_2_OFFER_1_COUNT.get();
        }
    }
    public static String getWaiter2Offer1() {
        if (Objects.equals(WAITER_2_OFFER_1.get(), WAITER_2_OFFER_1.getDefault())) {
            return WAITER_2_OFFER_1.getDefault();
        }
        else {
            return WAITER_2_OFFER_1.get();
        }
    }
    public static String getWaiter2Request1() {
        if (Objects.equals(WAITER_2_REQUEST_1.get(), WAITER_2_REQUEST_1.getDefault())) {
            return WAITER_2_REQUEST_1.getDefault();
        }
        else {
            return WAITER_2_REQUEST_1.get();
        }
    }
    public static int getWaiter1Offer2Count() {
        if (Objects.equals(WAITER_1_OFFER_2_COUNT.get(), WAITER_1_OFFER_2_COUNT.getDefault())) {
            return WAITER_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return WAITER_1_OFFER_2_COUNT.get();
        }
    }
    public static String getWaiter1Offer2() {
        if (Objects.equals(WAITER_1_OFFER_2.get(), WAITER_1_OFFER_2.getDefault())) {
            return WAITER_1_OFFER_2.getDefault();
        }
        else {
            return WAITER_1_OFFER_2.get();
        }
    }
    public static String getWaiter1Request2() {
        if (Objects.equals(WAITER_1_REQUEST_2.get(), WAITER_1_REQUEST_2.getDefault())) {
            return WAITER_1_REQUEST_2.getDefault();
        }
        else {
            return WAITER_1_REQUEST_2.get();
        }
    }
    public static int getWaiter1Offer1Count() {
        if (Objects.equals(WAITER_1_OFFER_1_COUNT.get(), WAITER_1_OFFER_1_COUNT.getDefault())) {
            return WAITER_1_OFFER_1_COUNT.getDefault();
        }
        else {
            return WAITER_1_OFFER_1_COUNT.get();
        }
    }
    public static String getWaiter1Offer1() {
        if (Objects.equals(WAITER_1_OFFER_1.get(), WAITER_1_OFFER_1.getDefault())) {
            return WAITER_1_OFFER_1.getDefault();
        }
        else {
            return WAITER_1_OFFER_1.get();
        }
    }
    public static String getWaiter1Request1() {
        if (Objects.equals(WAITER_1_REQUEST_1.get(), WAITER_1_REQUEST_1.getDefault())) {
            return WAITER_1_REQUEST_1.getDefault();
        }
        else {
            return WAITER_1_REQUEST_1.get();
        }
    }
}