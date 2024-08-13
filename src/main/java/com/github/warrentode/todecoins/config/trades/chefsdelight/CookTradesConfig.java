package com.github.warrentode.todecoins.config.trades.chefsdelight;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CookTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Cook Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> COOK_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_1_REQUEST_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> COOK_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> COOK_5_OFFER_2_COUNT;

    static {
        // COOK TRADES
        BUILDER.push("Cook Trade Settings");
        // level 1
        BUILDER.push("Cook Level One Trade One");
        COOK_1_REQUEST_1 = BUILDER
                .comment(" Cook 1 Trade Offer 1 Table")
                .define("cook_1_trade_offer_1_table",
                        TradeLootTables.INGREDIENTS_TAG_TABLE.toString());
        COOK_1_REQUEST_1_COUNT = BUILDER
                .define("cook_1_trade_request_1_count", 16);
        COOK_1_OFFER_1 = BUILDER
                .comment(" Cook 1 Trade Request 1 Table")
                .define("cook_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cook Level One Trade Two");
        COOK_1_REQUEST_2 = BUILDER
                .comment(" Cook 1 Trade Request 2 Table")
                .define("cook_1_trade_request_2_table",
                        TradeLootTables.INGREDIENTS_TAG_TABLE.toString());
        COOK_1_REQUEST_2_COUNT = BUILDER
                .define("cook_1_trade_request_2_count", 16);
        COOK_1_OFFER_2 = BUILDER
                .comment(" Cook 1 Trade Offer 2 Table")
                .define("cook_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Cook Level Two Trade One");
        COOK_2_REQUEST_1 = BUILDER
                .comment(" Cook 2 Trade Request 1 Table")
                .define("cook_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        COOK_2_OFFER_1 = BUILDER
                .comment(" Cook 2 Trade Offer 1 Table")
                .define("cook_2_trade_offer_1_table",
                        TradeLootTables.SANDWICH_TAG_TABLE.toString());
        COOK_2_OFFER_1_COUNT = BUILDER
                .define("cook_2_trade_offer_1_count", 6);
        BUILDER.pop();
        BUILDER.push("Cook Level Two Trade Two");
        COOK_2_REQUEST_2 = BUILDER
                .comment(" Cook 2 Trade Request 2 Table")
                .define("cook_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        COOK_2_OFFER_2 = BUILDER
                .comment(" Cook 2 Trade Offer 2 Table")
                .define("cook_2_trade_offer_2_table",
                        TradeLootTables.SIDE_DISH_TAG_TABLE.toString());
        COOK_2_OFFER_2_COUNT = BUILDER
                .define("cook_2_trade_offer_2_count", 6);
        BUILDER.pop();
        // level 3
        BUILDER.push("Cook Level Three Trade One");
        COOK_3_REQUEST_1 = BUILDER
                .comment(" Cook 3 Trade Request 1 Table")
                .define("cook_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        COOK_3_OFFER_1 = BUILDER
                .comment(" Cook 3 Trade Offer 1 Table")
                .define("cook_3_trade_offer_1_table",
                        TradeLootTables.SOUP_TAG_TABLE.toString());
        COOK_3_OFFER_1_COUNT = BUILDER
                .define("cook_3_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Cook Level Three Trade Two");
        COOK_3_REQUEST_2 = BUILDER
                .comment(" Cook 3 Trade Request 2 Table")
                .define("cook_3_trade_request_2_count",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        COOK_3_OFFER_2 = BUILDER
                .comment(" Cook 3 Trade Offer 2 Table")
                .define("cook_3_trade_offer_2_table",
                        TradeLootTables.PLATED_FOODS_TAG_TABLE.toString());
        COOK_3_OFFER_2_COUNT = BUILDER
                .define("cook_3_trade_offer_2_count", 6);
        BUILDER.pop();
        // level 4
        BUILDER.push("Cook Level Four Trade One");
        COOK_4_REQUEST_1 = BUILDER
                .comment(" Cook 4 Trade Request 1 Table")
                .define("cook_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        COOK_4_OFFER_1 = BUILDER
                .comment(" Cook 4 Trade Offer 1 Table")
                .define("cook_4_trade_offer_1_table",
                        TradeLootTables.DESSERT_TAG_TABLE.toString());
        COOK_4_OFFER_1_COUNT = BUILDER
                .define("cook_4_trade_offer_1_count", 4);
        BUILDER.pop();
        BUILDER.push("Cook Level Four Trade Two");
        COOK_4_REQUEST_2 = BUILDER
                .comment(" Cook 4 Trade Request 2 Table")
                .define("cook_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        COOK_4_OFFER_2 = BUILDER
                .comment(" Cook 4 Trade Offer 2 Table")
                .define("cook_4_trade_offer_2_table",
                        TradeLootTables.DESSERT_TAG_TABLE.toString());
        COOK_4_OFFER_2_COUNT = BUILDER
                .define("cook_3_trade_offer_2_count", 4);
        BUILDER.pop();
        // level 5
        BUILDER.push("Cook Level Five Trade One")
                .comment(" Rare Trade");
        COOK_5_REQUEST_1 = BUILDER
                .comment(" Cook 5 Trade Request 1 Table")
                .define("cook_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        COOK_5_OFFER_1 = BUILDER
                .comment(" Cook 5 Trade Offer 1 Table")
                .define("cook_5_trade_offer_1_table",
                        TradeLootTables.INGREDIENTS_TAG_TABLE.toString());
        COOK_5_OFFER_1_COUNT = BUILDER
                .define("cook_5_trade_offer_1_count", 9);
        BUILDER.pop();
        BUILDER.push("Cook Level Five Trade Two")
                .comment(" Rare Trade");
        COOK_5_REQUEST_2 = BUILDER
                .comment(" Cook 5 Trade Request 2 Table")
                .define("cook_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        COOK_5_OFFER_2 = BUILDER
                .comment(" Cook 5 Trade Offer 2 Table")
                .define("cook_5_trade_offer_2_table",
                        TradeLootTables.INGREDIENTS_TAG_TABLE.toString());
        COOK_5_OFFER_2_COUNT = BUILDER
                .define("cook_5_trade_offer_2_count", 9);
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // COOK TRADE GETTERS
    public static int getCook5Offer2Count() {
        if (Objects.equals(COOK_5_OFFER_2_COUNT.get(), COOK_5_OFFER_2_COUNT.getDefault())) {
            return COOK_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return COOK_5_OFFER_2_COUNT.get();
        }
    }
    public static String getCook5Offer2() {
        if (Objects.equals(COOK_5_OFFER_2.get(), COOK_5_OFFER_2.getDefault())) {
            return COOK_5_OFFER_2.getDefault();
        }
        else {
            return COOK_5_OFFER_2.get();
        }
    }
    public static String getCook5Request2() {
        if (Objects.equals(COOK_5_REQUEST_2.get(), COOK_5_REQUEST_2.getDefault())) {
            return COOK_5_REQUEST_2.getDefault();
        }
        else {
            return COOK_5_REQUEST_2.get();
        }
    }
    public static int getCook5Offer1Count() {
        if (Objects.equals(COOK_5_OFFER_1_COUNT.get(), COOK_5_OFFER_1_COUNT.getDefault())) {
            return COOK_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return COOK_5_OFFER_1_COUNT.get();
        }
    }
    public static String getCook5Offer1() {
        if (Objects.equals(COOK_5_OFFER_1.get(), COOK_5_OFFER_1.getDefault())) {
            return COOK_5_OFFER_1.getDefault();
        }
        else {
            return COOK_5_OFFER_1.get();
        }
    }
    public static String getCook5Request1() {
        if (Objects.equals(COOK_5_REQUEST_1.get(), COOK_5_REQUEST_1.getDefault())) {
            return COOK_5_REQUEST_1.getDefault();
        }
        else {
            return COOK_5_REQUEST_1.get();
        }
    }
    public static int getCook4Offer2Count() {
        if (Objects.equals(COOK_4_OFFER_2_COUNT.get(), COOK_4_OFFER_2_COUNT.getDefault())) {
            return COOK_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return COOK_4_OFFER_2_COUNT.get();
        }
    }
    public static String getCook4Offer2() {
        if (Objects.equals(COOK_4_OFFER_2.get(), COOK_4_OFFER_2.getDefault())) {
            return COOK_4_OFFER_2.getDefault();
        }
        else {
            return COOK_4_OFFER_2.get();
        }
    }
    public static String getCook4Request2() {
        if (Objects.equals(COOK_4_REQUEST_2.get(), COOK_4_REQUEST_2.getDefault())) {
            return COOK_4_REQUEST_2.getDefault();
        }
        else {
            return COOK_4_REQUEST_2.get();
        }
    }
    public static int getCook4Offer1Count() {
        if (Objects.equals(COOK_4_OFFER_1_COUNT.get(), COOK_4_OFFER_1_COUNT.getDefault())) {
            return COOK_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return COOK_4_OFFER_1_COUNT.get();
        }
    }
    public static String getCook4Offer1() {
        if (Objects.equals(COOK_4_OFFER_1.get(), COOK_4_OFFER_1.getDefault())) {
            return COOK_4_OFFER_1.getDefault();
        }
        else {
            return COOK_4_OFFER_1.get();
        }
    }
    public static String getCook4Request1() {
        if (Objects.equals(COOK_4_REQUEST_1.get(), COOK_4_REQUEST_1.getDefault())) {
            return COOK_4_REQUEST_1.getDefault();
        }
        else {
            return COOK_4_REQUEST_1.get();
        }
    }
    public static int getCook3Offer2Count() {
        if (Objects.equals(COOK_3_OFFER_2_COUNT.get(), COOK_3_OFFER_2_COUNT.getDefault())) {
            return COOK_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return COOK_3_OFFER_2_COUNT.get();
        }
    }
    public static String getCook3Offer2() {
        if (Objects.equals(COOK_3_OFFER_2.get(), COOK_3_OFFER_2.getDefault())) {
            return COOK_3_OFFER_2.getDefault();
        }
        else {
            return COOK_3_OFFER_2.get();
        }
    }
    public static String getCook3Request2() {
        if (Objects.equals(COOK_3_REQUEST_2.get(), COOK_3_REQUEST_2.getDefault())) {
            return COOK_3_REQUEST_2.getDefault();
        }
        else {
            return COOK_3_REQUEST_2.get();
        }
    }
    public static int getCook3Offer1Count() {
        if (Objects.equals(COOK_3_OFFER_1_COUNT.get(), COOK_3_OFFER_1_COUNT.getDefault())) {
            return COOK_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return COOK_3_OFFER_1_COUNT.get();
        }
    }
    public static String getCook3Offer1() {
        if (Objects.equals(COOK_3_OFFER_1.get(), COOK_3_OFFER_1.getDefault())) {
            return COOK_3_OFFER_1.getDefault();
        }
        else {
            return COOK_3_OFFER_1.get();
        }
    }
    public static String getCook3Request1() {
        if (Objects.equals(COOK_3_REQUEST_1.get(), COOK_3_REQUEST_1.getDefault())) {
            return COOK_3_REQUEST_1.getDefault();
        }
        else {
            return COOK_3_REQUEST_1.get();
        }
    }
    public static int getCook2Offer2Count() {
        if (Objects.equals(COOK_2_OFFER_2_COUNT.get(), COOK_2_OFFER_2_COUNT.getDefault())) {
            return COOK_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return COOK_2_OFFER_2_COUNT.get();
        }
    }
    public static String getCook2Offer2() {
        if (Objects.equals(COOK_2_OFFER_2.get(), COOK_2_OFFER_2.getDefault())) {
            return COOK_2_OFFER_2.getDefault();
        }
        else {
            return COOK_2_OFFER_2.get();
        }
    }
    public static String getCook2Request2() {
        if (Objects.equals(COOK_2_REQUEST_2.get(), COOK_2_REQUEST_2.getDefault())) {
            return COOK_2_REQUEST_2.getDefault();
        }
        else {
            return COOK_2_REQUEST_2.get();
        }
    }
    public static int getCook2Offer1Count() {
        if (Objects.equals(COOK_2_OFFER_1_COUNT.get(), COOK_2_OFFER_1_COUNT.getDefault())) {
            return COOK_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return COOK_2_OFFER_1_COUNT.get();
        }
    }
    public static String getCook2Offer1() {
        if (Objects.equals(COOK_2_OFFER_1.get(), COOK_2_OFFER_1.getDefault())) {
            return COOK_2_OFFER_1.getDefault();
        }
        else {
            return COOK_2_OFFER_1.get();
        }
    }
    public static String getCook2Request1() {
        if (Objects.equals(COOK_2_REQUEST_1.get(), COOK_2_REQUEST_1.getDefault())) {
            return COOK_2_REQUEST_1.getDefault();
        }
        else {
            return COOK_2_REQUEST_1.get();
        }
    }
    public static String getCook1Offer2() {
        if (Objects.equals(COOK_1_OFFER_2.get(), COOK_1_OFFER_2.getDefault())) {
            return COOK_1_OFFER_2.getDefault();
        }
        else {
            return COOK_1_OFFER_2.get();
        }
    }
    public static int getCook1Request2Count() {
        if (Objects.equals(COOK_1_REQUEST_2_COUNT.get(), COOK_1_REQUEST_2_COUNT.getDefault())) {
            return COOK_1_REQUEST_2_COUNT.getDefault();
        }
        else {
            return COOK_1_REQUEST_2_COUNT.get();
        }
    }
    public static String getCook1Request2() {
        if (Objects.equals(COOK_1_REQUEST_2.get(), COOK_1_REQUEST_2.getDefault())) {
            return COOK_1_REQUEST_2.getDefault();
        }
        else {
            return COOK_1_REQUEST_2.get();
        }
    }
    public static String getCook1Offer1() {
        if (Objects.equals(COOK_1_OFFER_1.get(), COOK_1_OFFER_1.getDefault())) {
            return COOK_1_OFFER_1.getDefault();
        }
        else {
            return COOK_1_OFFER_1.get();
        }
    }
    public static int getCook1Request1Count() {
        if (Objects.equals(COOK_1_REQUEST_1_COUNT.get(), COOK_1_REQUEST_1_COUNT.getDefault())) {
            return COOK_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return COOK_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getCook1Request1() {
        if (Objects.equals(COOK_1_REQUEST_1.get(), COOK_1_REQUEST_1.getDefault())) {
            return COOK_1_REQUEST_1.getDefault();
        }
        else {
            return COOK_1_REQUEST_1.get();
        }
    }
}