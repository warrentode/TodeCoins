package com.github.warrentode.todecoins.config.trades.kawaiidishes;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BaristaTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Barista Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_1_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_1_REQUEST_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_2_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_2_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_2_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_2_REQUEST_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_2_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_3_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_3_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_3_REQUEST_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_3_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_4_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_4_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_4_REQUEST_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_4_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_5_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_5_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_5_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_5_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_5_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<Integer> BARISTA_5_REQUEST_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BARISTA_5_OFFER_4;

    static {
        // BARISTA TRADES
        BUILDER.push("Barista Trade Settings");
        // level 1
        BUILDER.push("Barista Level One Trade One");
        BARISTA_1_REQUEST_1 = BUILDER
                .comment(" Barista 1 Trade Request 1 Table")
                .define("barista_1_trade_request_1_table",
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE.toString());
        BARISTA_1_REQUEST_1_COUNT = BUILDER
                .define("barista_1_trade_request_1_count", 12);
        BARISTA_1_OFFER_1 = BUILDER
                .comment(" Barista 1 Trade Offer 1 Table")
                .define("barista_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Barista Level One Trade Two");
        BARISTA_1_REQUEST_2 = BUILDER
                .comment(" Barista 1 Trade Request 2 Table")
                .define("barista_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_1_OFFER_2 = BUILDER
                .comment(" Barista 1 Trade Offer 2 Table")
                .define("barista_1_trade_offer_2_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        BARISTA_1_OFFER_2_COUNT = BUILDER
                .define("barista_1_trade_offer_2_count", 12);
        BUILDER.pop();
        BUILDER.push("Barista Level One Trade Three");
        BARISTA_1_REQUEST_3 = BUILDER
                .comment(" Barista 1 Trade Request 3 Table")
                .define("barista_1_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_1_OFFER_3 = BUILDER
                .comment(" Barista 1 Trade Offer 3 Table")
                .define("barista_1_trade_offer_3_table",
                        TradeLootTables.DESSERT_TAG_TABLE.toString());
        BARISTA_1_OFFER_3_COUNT = BUILDER
                .define("barista_1_trade_offer_3_count", 6);
        BUILDER.pop();
        BUILDER.push("Barista Level One Trade Four");
        BARISTA_1_REQUEST_4 = BUILDER
                .comment(" Barista 1 Trade Offer 4 Table")
                .define("barista_1_trade_offer_4_table",
                        TradeLootTables.CUPS_TAG_TABLE.toString());
        BARISTA_1_REQUEST_4_COUNT = BUILDER
                .define("barista_1_trade_offer_4_count", 9);
        BARISTA_1_OFFER_4 = BUILDER
                .comment(" Barista 1 Trade Request 4 Table")
                .define("barista_1_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Barista Level Two Trade One");
        BARISTA_2_REQUEST_1 = BUILDER
                .comment(" Barista 2 Trade Request 1 Table")
                .define("barista_2_trade_request_1_table",
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE.toString());
        BARISTA_2_REQUEST_1_COUNT = BUILDER
                .define("barista_2_trade_request_1_count", 12);
        BARISTA_2_OFFER_1 = BUILDER
                .comment(" Barista 2 Trade Offer 1 Table")
                .define("barista_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Two");
        BARISTA_2_REQUEST_2 = BUILDER
                .comment(" Barista 2 Trade Request 2 Table")
                .define("barista_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_2_OFFER_2 = BUILDER
                .comment(" Barista 2 Trade Offer 2 Table")
                .define("barista_2_trade_offer_2_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        BARISTA_2_OFFER_2_COUNT = BUILDER
                .define("barista_2_trade_offer_2_count", 12);
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Three");
        BARISTA_2_REQUEST_3 = BUILDER
                .comment(" Barista 2 Trade Request 3 Table")
                .define("barista_2_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_2_OFFER_3 = BUILDER
                .comment(" Barista 2 Trade Offer 3 Table")
                .define("barista_2_trade_offer_3_table",
                        TradeLootTables.DESSERT_TAG_TABLE.toString());
        BARISTA_2_OFFER_3_COUNT = BUILDER
                .define("barista_2_trade_offer_3_count", 6);
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Four");
        BARISTA_2_REQUEST_4 = BUILDER
                .comment(" Barista 2 Trade Offer 4 Table")
                .define("barista_2_trade_offer_4_table",
                        TradeLootTables.CUPS_TAG_TABLE.toString());
        BARISTA_2_REQUEST_4_COUNT = BUILDER
                .define("barista_2_trade_offer_4_count", 9);
        BARISTA_2_OFFER_4 = BUILDER
                .comment(" Barista 2 Trade Request 4 Table")
                .define("barista_2_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Barista Level Three Trade One");
        BARISTA_3_REQUEST_1 = BUILDER
                .comment(" Barista 3 Trade Request 1 Table")
                .define("barista_3_trade_request_1_table",
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE.toString());
        BARISTA_3_REQUEST_1_COUNT = BUILDER
                .define("barista_3_trade_request_1_count", 12);
        BARISTA_3_OFFER_1 = BUILDER
                .comment(" Barista 3 Trade Offer 1 Table")
                .define("barista_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Two");
        BARISTA_3_REQUEST_2 = BUILDER
                .comment(" Barista 3 Trade Request 2 Table")
                .define("barista_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_3_OFFER_2 = BUILDER
                .comment(" Barista 3 Trade Offer 2 Table")
                .define("barista_3_trade_offer_2_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        BARISTA_3_OFFER_2_COUNT = BUILDER
                .define("barista_3_trade_offer_2_count", 12);
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Three");
        BARISTA_3_REQUEST_3 = BUILDER
                .comment(" Barista 3 Trade Request 3 Table")
                .define("barista_3_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_3_OFFER_3 = BUILDER
                .comment(" Barista 3 Trade Offer 3 Table")
                .define("barista_3_trade_offer_3_table",
                        TradeLootTables.DESSERT_TAG_TABLE.toString());
        BARISTA_3_OFFER_3_COUNT = BUILDER
                .define("barista_3_trade_offer_3_count", 6);
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Four");
        BARISTA_3_REQUEST_4 = BUILDER
                .comment(" Barista 3 Trade Request 4 Table")
                .define("barista_3_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_3_OFFER_4 = BUILDER
                .comment(" Barista 3 Trade Offer 4 Table")
                .define("barista_3_trade_offer_4_table",
                        TradeLootTables.CUPS_TAG_TABLE.toString());
        BARISTA_3_REQUEST_4_COUNT = BUILDER
                .define("barista_3_trade_offer_4_count", 9);
        BUILDER.pop();
        // level 4
        BUILDER.push("Barista Level Four Trade One");
        BARISTA_4_REQUEST_1 = BUILDER
                .comment(" Barista 4 Trade Request 1 Table")
                .define("barista_4_trade_request_1_table",
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE.toString());
        BARISTA_4_REQUEST_1_COUNT = BUILDER
                .define("barista_4_trade_request_1_count", 12);
        BARISTA_4_OFFER_1 = BUILDER
                .comment(" Barista 4 Trade Offer 1 Table")
                .define("barista_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Two");
        BARISTA_4_REQUEST_2 = BUILDER
                .comment(" Barista 4 Trade Request 2 Table")
                .define("barista_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_4_OFFER_2 = BUILDER
                .comment(" Barista 4 Trade Offer 2 Table")
                .define("barista_4_trade_offer_2_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        BARISTA_4_OFFER_2_COUNT = BUILDER
                .define("barista_4_trade_offer_2_count", 12);
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Three");
        BARISTA_4_REQUEST_3 = BUILDER
                .comment(" Barista 4 Trade Request 3 Table")
                .define("barista_4_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_4_OFFER_3 = BUILDER
                .comment(" Barista 4 Trade Offer 3 Table")
                .define("barista_4_trade_offer_3_table",
                        TradeLootTables.DESSERT_TAG_TABLE.toString());
        BARISTA_4_OFFER_3_COUNT = BUILDER
                .define("barista_4_trade_offer_3_count", 6);
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Four");
        BARISTA_4_REQUEST_4 = BUILDER
                .comment(" Barista 4 Trade Offer 4 Table")
                .define("barista_4_trade_offer_4_table",
                        TradeLootTables.CUPS_TAG_TABLE.toString());
        BARISTA_4_REQUEST_4_COUNT = BUILDER
                .define("barista_4_trade_offer_4_count", 9);
        BARISTA_4_OFFER_4 = BUILDER
                .comment(" Barista 4 Trade Request 4 Table")
                .define("barista_4_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Barista Level Five Trade One");
        BARISTA_5_REQUEST_1 = BUILDER
                .comment(" Barista 5 Trade Request 1 Table")
                .define("barista_5_trade_request_1_table",
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE.toString());
        BARISTA_5_REQUEST_1_COUNT = BUILDER
                .define("barista_5_trade_request_1_count", 12);
        BARISTA_5_OFFER_1 = BUILDER
                .comment(" Barista 5 Trade Offer 1 Table")
                .define("barista_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Two");
        BARISTA_5_REQUEST_2 = BUILDER
                .comment(" Barista 5 Trade Request 2 Table")
                .define("barista_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_5_OFFER_2 = BUILDER
                .comment(" Barista 5 Trade Offer 2 Table")
                .define("barista_5_trade_offer_2_table",
                        TradeLootTables.DRINKS_TAG_TABLE.toString());
        BARISTA_5_OFFER_2_COUNT = BUILDER
                .define("barista_5_trade_offer_2_count", 12);
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Three");
        BARISTA_5_REQUEST_3 = BUILDER
                .comment(" Barista 5 Trade Request 3 Table")
                .define("barista_5_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BARISTA_5_OFFER_3 = BUILDER
                .comment(" Barista 5 Trade Offer 3 Table")
                .define("barista_5_trade_offer_3_table",
                        TradeLootTables.DESSERT_TAG_TABLE.toString());
        BARISTA_5_OFFER_3_COUNT = BUILDER
                .define("barista_5_trade_offer_3_count", 6);
        BUILDER.pop();
        BUILDER.push("Barista Level Two Trade Four");
        BARISTA_5_REQUEST_4 = BUILDER
                .comment(" Barista 5 Trade Offer 4 Table")
                .define("barista_5_trade_offer_4_table",
                        TradeLootTables.CUPS_TAG_TABLE.toString());
        BARISTA_5_REQUEST_4_COUNT = BUILDER
                .define("barista_5_trade_offer_4_count", 9);
        BARISTA_5_OFFER_4 = BUILDER
                .comment(" Barista 5 Trade Request 4 Table")
                .define("barista_5_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // BARISTA TRADE GETTERS
    public static int getBarista5Request4Count() {
        if (Objects.equals(BARISTA_5_REQUEST_4_COUNT.get(), BARISTA_5_REQUEST_4_COUNT.getDefault())) {
            return BARISTA_5_REQUEST_4_COUNT.getDefault();
        }
        else {
            return BARISTA_5_REQUEST_4_COUNT.get();
        }
    }
    public static String getBarista5Request4() {
        if (Objects.equals(BARISTA_5_REQUEST_4.get(), BARISTA_5_REQUEST_4.getDefault())) {
            return BARISTA_5_REQUEST_4.getDefault();
        }
        else {
            return BARISTA_5_REQUEST_4.get();
        }
    }
    public static int getBarista5Offer3Count() {
        if (Objects.equals(BARISTA_5_OFFER_3_COUNT.get(), BARISTA_5_OFFER_3_COUNT.getDefault())) {
            return BARISTA_5_OFFER_3_COUNT.getDefault();
        }
        else {
            return BARISTA_5_OFFER_3_COUNT.get();
        }
    }
    public static String getBarista5Offer3() {
        if (Objects.equals(BARISTA_5_OFFER_3.get(), BARISTA_5_OFFER_3.getDefault())) {
            return BARISTA_5_OFFER_3.getDefault();
        }
        else {
            return BARISTA_5_OFFER_3.get();
        }
    }
    public static String getBarista5Request3() {
        if (Objects.equals(BARISTA_5_REQUEST_3.get(), BARISTA_5_REQUEST_3.getDefault())) {
            return BARISTA_5_REQUEST_3.getDefault();
        }
        else {
            return BARISTA_5_REQUEST_3.get();
        }
    }
    public static int getBarista5Offer2Count() {
        if (Objects.equals(BARISTA_5_OFFER_2_COUNT.get(), BARISTA_5_OFFER_2_COUNT.getDefault())) {
            return BARISTA_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return BARISTA_5_OFFER_2_COUNT.get();
        }
    }
    public static String getBarista5Offer2() {
        if (Objects.equals(BARISTA_5_OFFER_2.get(), BARISTA_5_OFFER_2.getDefault())) {
            return BARISTA_5_OFFER_2.getDefault();
        }
        else {
            return BARISTA_5_OFFER_2.get();
        }
    }
    public static String getBarista5Request2() {
        if (Objects.equals(BARISTA_5_REQUEST_2.get(), BARISTA_5_REQUEST_2.getDefault())) {
            return BARISTA_5_REQUEST_2.getDefault();
        }
        else {
            return BARISTA_5_REQUEST_2.get();
        }
    }
    public static int getBarista5Request1Count() {
        if (Objects.equals(BARISTA_5_REQUEST_1_COUNT.get(), BARISTA_5_REQUEST_1_COUNT.getDefault())) {
            return BARISTA_5_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BARISTA_5_REQUEST_1_COUNT.get();
        }
    }
    public static String getBarista5Offer1() {
        if (Objects.equals(BARISTA_5_OFFER_1.get(), BARISTA_5_OFFER_1.getDefault())) {
            return BARISTA_5_OFFER_1.getDefault();
        }
        else {
            return BARISTA_5_OFFER_1.get();
        }
    }
    public static String getBarista5Request1() {
        if (Objects.equals(BARISTA_5_REQUEST_1.get(), BARISTA_5_REQUEST_1.getDefault())) {
            return BARISTA_5_REQUEST_1.getDefault();
        }
        else {
            return BARISTA_5_REQUEST_1.get();
        }
    }
    public static int getBarista4Request4Count() {
        if (Objects.equals(BARISTA_4_REQUEST_4_COUNT.get(), BARISTA_4_REQUEST_4_COUNT.getDefault())) {
            return BARISTA_4_REQUEST_4_COUNT.getDefault();
        }
        else {
            return BARISTA_4_REQUEST_4_COUNT.get();
        }
    }
    public static String getBarista4Request4() {
        if (Objects.equals(BARISTA_4_REQUEST_4.get(), BARISTA_4_REQUEST_4.getDefault())) {
            return BARISTA_4_REQUEST_4.getDefault();
        }
        else {
            return BARISTA_4_REQUEST_4.get();
        }
    }
    public static int getBarista4Offer3Count() {
        if (Objects.equals(BARISTA_4_OFFER_3_COUNT.get(), BARISTA_4_OFFER_3_COUNT.getDefault())) {
            return BARISTA_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return BARISTA_4_OFFER_3_COUNT.get();
        }
    }
    public static String getBarista4Offer3() {
        if (Objects.equals(BARISTA_4_OFFER_3.get(), BARISTA_4_OFFER_3.getDefault())) {
            return BARISTA_4_OFFER_3.getDefault();
        }
        else {
            return BARISTA_4_OFFER_3.get();
        }
    }
    public static String getBarista4Request3() {
        if (Objects.equals(BARISTA_4_REQUEST_3.get(), BARISTA_4_REQUEST_3.getDefault())) {
            return BARISTA_4_REQUEST_3.getDefault();
        }
        else {
            return BARISTA_4_REQUEST_3.get();
        }
    }
    public static int getBarista4Offer2Count() {
        if (Objects.equals(BARISTA_4_OFFER_2_COUNT.get(), BARISTA_4_OFFER_2_COUNT.getDefault())) {
            return BARISTA_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return BARISTA_4_OFFER_2_COUNT.get();
        }
    }
    public static String getBarista4Offer2() {
        if (Objects.equals(BARISTA_4_OFFER_2.get(), BARISTA_4_OFFER_2.getDefault())) {
            return BARISTA_4_OFFER_2.getDefault();
        }
        else {
            return BARISTA_4_OFFER_2.get();
        }
    }
    public static String getBarista4Request2() {
        if (Objects.equals(BARISTA_4_REQUEST_2.get(), BARISTA_4_REQUEST_2.getDefault())) {
            return BARISTA_4_REQUEST_2.getDefault();
        }
        else {
            return BARISTA_4_REQUEST_2.get();
        }
    }
    public static int getBarista4Request1Count() {
        if (Objects.equals(BARISTA_4_REQUEST_1_COUNT.get(), BARISTA_4_REQUEST_1_COUNT.getDefault())) {
            return BARISTA_4_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BARISTA_4_REQUEST_1_COUNT.get();
        }
    }
    public static String getBarista4Offer1() {
        if (Objects.equals(BARISTA_4_OFFER_1.get(), BARISTA_4_OFFER_1.getDefault())) {
            return BARISTA_4_OFFER_1.getDefault();
        }
        else {
            return BARISTA_4_OFFER_1.get();
        }
    }
    public static String getBarista4Request1() {
        if (Objects.equals(BARISTA_4_REQUEST_1.get(), BARISTA_4_REQUEST_1.getDefault())) {
            return BARISTA_4_REQUEST_1.getDefault();
        }
        else {
            return BARISTA_4_REQUEST_1.get();
        }
    }
    public static int getBarista3Request4Count() {
        if (Objects.equals(BARISTA_3_REQUEST_4_COUNT.get(), BARISTA_3_REQUEST_4_COUNT.getDefault())) {
            return BARISTA_3_REQUEST_4_COUNT.getDefault();
        }
        else {
            return BARISTA_3_REQUEST_4_COUNT.get();
        }
    }
    public static String getBarista3Request4() {
        if (Objects.equals(BARISTA_3_REQUEST_4.get(), BARISTA_3_REQUEST_4.getDefault())) {
            return BARISTA_3_REQUEST_4.getDefault();
        }
        else {
            return BARISTA_3_REQUEST_4.get();
        }
    }
    public static int getBarista3Offer3Count() {
        if (Objects.equals(BARISTA_3_OFFER_3_COUNT.get(), BARISTA_3_OFFER_3_COUNT.getDefault())) {
            return BARISTA_3_OFFER_3_COUNT.getDefault();
        }
        else {
            return BARISTA_3_OFFER_3_COUNT.get();
        }
    }
    public static String getBarista3Offer3() {
        if (Objects.equals(BARISTA_3_OFFER_3.get(), BARISTA_3_OFFER_3.getDefault())) {
            return BARISTA_3_OFFER_3.getDefault();
        }
        else {
            return BARISTA_3_OFFER_3.get();
        }
    }
    public static String getBarista3Request3() {
        if (Objects.equals(BARISTA_3_REQUEST_3.get(), BARISTA_3_REQUEST_3.getDefault())) {
            return BARISTA_3_REQUEST_3.getDefault();
        }
        else {
            return BARISTA_3_REQUEST_3.get();
        }
    }
    public static int getBarista3Offer2Count() {
        if (Objects.equals(BARISTA_3_OFFER_2_COUNT.get(), BARISTA_3_OFFER_2_COUNT.getDefault())) {
            return BARISTA_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return BARISTA_3_OFFER_2_COUNT.get();
        }
    }
    public static String getBarista3Offer2() {
        if (Objects.equals(BARISTA_3_OFFER_2.get(), BARISTA_3_OFFER_2.getDefault())) {
            return BARISTA_3_OFFER_2.getDefault();
        }
        else {
            return BARISTA_3_OFFER_2.get();
        }
    }
    public static String getBarista3Request2() {
        if (Objects.equals(BARISTA_3_REQUEST_2.get(), BARISTA_3_REQUEST_2.getDefault())) {
            return BARISTA_3_REQUEST_2.getDefault();
        }
        else {
            return BARISTA_3_REQUEST_2.get();
        }
    }
    public static int getBarista3Request1Count() {
        if (Objects.equals(BARISTA_3_REQUEST_1_COUNT.get(), BARISTA_3_REQUEST_1_COUNT.getDefault())) {
            return BARISTA_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BARISTA_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getBarista3Offer1() {
        if (Objects.equals(BARISTA_3_OFFER_1.get(), BARISTA_3_OFFER_1.getDefault())) {
            return BARISTA_3_OFFER_1.getDefault();
        }
        else {
            return BARISTA_3_OFFER_1.get();
        }
    }
    public static String getBarista3Request1() {
        if (Objects.equals(BARISTA_3_REQUEST_1.get(), BARISTA_3_REQUEST_1.getDefault())) {
            return BARISTA_3_REQUEST_1.getDefault();
        }
        else {
            return BARISTA_3_REQUEST_1.get();
        }
    }
    public static int getBarista2Request4Count() {
        if (Objects.equals(BARISTA_2_REQUEST_4_COUNT.get(), BARISTA_2_REQUEST_4_COUNT.getDefault())) {
            return BARISTA_2_REQUEST_4_COUNT.getDefault();
        }
        else {
            return BARISTA_2_REQUEST_4_COUNT.get();
        }
    }
    public static String getBarista2Request4() {
        if (Objects.equals(BARISTA_2_REQUEST_4.get(), BARISTA_2_REQUEST_4.getDefault())) {
            return BARISTA_2_REQUEST_4.getDefault();
        }
        else {
            return BARISTA_2_REQUEST_4.get();
        }
    }
    public static int getBarista2Offer3Count() {
        if (Objects.equals(BARISTA_2_OFFER_3_COUNT.get(), BARISTA_2_OFFER_3_COUNT.getDefault())) {
            return BARISTA_2_OFFER_3_COUNT.getDefault();
        }
        else {
            return BARISTA_2_OFFER_3_COUNT.get();
        }
    }
    public static String getBarista2Offer3() {
        if (Objects.equals(BARISTA_2_OFFER_3.get(), BARISTA_2_OFFER_3.getDefault())) {
            return BARISTA_2_OFFER_3.getDefault();
        }
        else {
            return BARISTA_2_OFFER_3.get();
        }
    }
    public static String getBarista2Request3() {
        if (Objects.equals(BARISTA_2_REQUEST_3.get(), BARISTA_2_REQUEST_3.getDefault())) {
            return BARISTA_2_REQUEST_3.getDefault();
        }
        else {
            return BARISTA_2_REQUEST_3.get();
        }
    }
    public static int getBarista2Offer2Count() {
        if (Objects.equals(BARISTA_2_OFFER_2_COUNT.get(), BARISTA_2_OFFER_2_COUNT.getDefault())) {
            return BARISTA_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return BARISTA_2_OFFER_2_COUNT.get();
        }
    }
    public static String getBarista2Offer2() {
        if (Objects.equals(BARISTA_2_OFFER_2.get(), BARISTA_2_OFFER_2.getDefault())) {
            return BARISTA_2_OFFER_2.getDefault();
        }
        else {
            return BARISTA_2_OFFER_2.get();
        }
    }
    public static String getBarista2Request2() {
        if (Objects.equals(BARISTA_2_REQUEST_2.get(), BARISTA_2_REQUEST_2.getDefault())) {
            return BARISTA_2_REQUEST_2.getDefault();
        }
        else {
            return BARISTA_2_REQUEST_2.get();
        }
    }
    public static int getBarista2Request1Count() {
        if (Objects.equals(BARISTA_2_REQUEST_1_COUNT.get(), BARISTA_2_REQUEST_1_COUNT.getDefault())) {
            return BARISTA_2_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BARISTA_2_REQUEST_1_COUNT.get();
        }
    }
    public static String getBarista2Offer1() {
        if (Objects.equals(BARISTA_2_OFFER_1.get(), BARISTA_2_OFFER_1.getDefault())) {
            return BARISTA_2_OFFER_1.getDefault();
        }
        else {
            return BARISTA_2_OFFER_1.get();
        }
    }
    public static String getBarista2Request1() {
        if (Objects.equals(BARISTA_2_REQUEST_1.get(), BARISTA_2_REQUEST_1.getDefault())) {
            return BARISTA_2_REQUEST_1.getDefault();
        }
        else {
            return BARISTA_2_REQUEST_1.get();
        }
    }
    public static String getBarista1Offer4() {
        if (Objects.equals(BARISTA_1_OFFER_4.get(), BARISTA_1_OFFER_4.getDefault())) {
            return BARISTA_1_OFFER_4.getDefault();
        }
        else {
            return BARISTA_1_OFFER_4.get();
        }
    }
    public static int getBarista1Request4Count() {
        if (Objects.equals(BARISTA_1_REQUEST_4_COUNT.get(), BARISTA_1_REQUEST_4_COUNT.getDefault())) {
            return BARISTA_1_REQUEST_4_COUNT.getDefault();
        }
        else {
            return BARISTA_1_REQUEST_4_COUNT.get();
        }
    }
    public static String getBarista1Request4() {
        if (Objects.equals(BARISTA_1_REQUEST_4.get(), BARISTA_1_REQUEST_4.getDefault())) {
            return BARISTA_1_REQUEST_4.getDefault();
        }
        else {
            return BARISTA_1_REQUEST_4.get();
        }
    }
    public static int getBarista1Offer3Count() {
        if (Objects.equals(BARISTA_1_OFFER_3_COUNT.get(), BARISTA_1_OFFER_3_COUNT.getDefault())) {
            return BARISTA_1_OFFER_3_COUNT.getDefault();
        }
        else {
            return BARISTA_1_OFFER_3_COUNT.get();
        }
    }
    public static String getBarista1Offer3() {
        if (Objects.equals(BARISTA_1_OFFER_3.get(), BARISTA_1_OFFER_3.getDefault())) {
            return BARISTA_1_OFFER_3.getDefault();
        }
        else {
            return BARISTA_1_OFFER_3.get();
        }
    }
    public static String getBarista1Request3() {
        if (Objects.equals(BARISTA_1_REQUEST_3.get(), BARISTA_1_REQUEST_3.getDefault())) {
            return BARISTA_1_REQUEST_3.getDefault();
        }
        else {
            return BARISTA_1_REQUEST_3.get();
        }
    }
    public static int getBarista1Offer2Count() {
        if (Objects.equals(BARISTA_1_OFFER_2_COUNT.get(), BARISTA_1_OFFER_2_COUNT.getDefault())) {
            return BARISTA_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return BARISTA_1_OFFER_2_COUNT.get();
        }
    }
    public static String getBarista1Offer2() {
        if (Objects.equals(BARISTA_1_OFFER_2.get(), BARISTA_1_OFFER_2.getDefault())) {
            return BARISTA_1_OFFER_2.getDefault();
        }
        else {
            return BARISTA_1_OFFER_2.get();
        }
    }
    public static String getBarista1Request2() {
        if (Objects.equals(BARISTA_1_REQUEST_2.get(), BARISTA_1_REQUEST_2.getDefault())) {
            return BARISTA_1_REQUEST_2.getDefault();
        }
        else {
            return BARISTA_1_REQUEST_2.get();
        }
    }
    public static int getBarista1Request1Count() {
        if (Objects.equals(BARISTA_1_REQUEST_1_COUNT.get(), BARISTA_1_REQUEST_1_COUNT.getDefault())) {
            return BARISTA_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BARISTA_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getBarista1Offer1() {
        if (Objects.equals(BARISTA_1_OFFER_1.get(), BARISTA_1_OFFER_1.getDefault())) {
            return BARISTA_1_OFFER_1.getDefault();
        }
        else {
            return BARISTA_1_OFFER_1.get();
        }
    }
    public static String getBarista1Request1() {
        if (Objects.equals(BARISTA_1_REQUEST_1.get(), BARISTA_1_REQUEST_1.getDefault())) {
            return BARISTA_1_REQUEST_1.getDefault();
        }
        else {
            return BARISTA_1_REQUEST_1.get();
        }
    }
}