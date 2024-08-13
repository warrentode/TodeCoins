package com.github.warrentode.todecoins.config.trades.beautify;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BotanistTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Botanist Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BOTANIST_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BOTANIST_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BOTANIST_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BOTANIST_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BOTANIST_5_OFFER_2;

    static {
        // BOTANIST TRADES
        BUILDER.push("Botanist Trade Settings");
        // level 1
        BUILDER.push("Botanist Level One Trade One");
        BOTANIST_1_REQUEST_1 = BUILDER
                .comment(" Botanist 1 Trade Request 1 Table")
                .define("botanist_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_1_OFFER_1 = BUILDER
                .comment(" Botanist 1 Trade Offer 1 Table")
                .define("botanist_1_trade_offer_1_table",
                        TradeLootTables.FLOWER_POT_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Botanist Level One Trade Two");
        BOTANIST_1_REQUEST_2 = BUILDER
                .comment(" Botanist 1 Trade Request 2 Table")
                .define("botanist_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_1_OFFER_2 = BUILDER
                .comment(" Botanist 1 Trade Offer 2 Table")
                .define("botanist_1_trade_offer_2_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Botanist Level One Trade Three");
        BOTANIST_1_REQUEST_3 = BUILDER
                .comment(" Botanist 1 Trade Request 3 Table")
                .define("botanist_1_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_1_OFFER_3 = BUILDER
                .comment(" Botanist 1 Trade Offer 3 Table")
                .define("botanist_1_trade_offer_3_table",
                        TradeLootTables.DECOR_PLANTS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Botanist Level Two Trade One");
        BOTANIST_2_REQUEST_1 = BUILDER
                .comment(" Botanist 2 Trade Request 1 Table")
                .define("botanist_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_2_OFFER_1 = BUILDER
                .comment(" Botanist 2 Trade Offer 1 Table")
                .define("botanist_2_trade_offer_1_table",
                        TradeLootTables.TRELLIS_TAG_TABLE.toString());
        BOTANIST_2_OFFER_1_COUNT = BUILDER
                .define("botanist_2_trade_offer_1_count", 2);
        BUILDER.pop();
        BUILDER.push("Botanist Level Two Trade Two");
        BOTANIST_2_REQUEST_2 = BUILDER
                .comment(" Botanist 2 Trade Request 2 Table")
                .define("botanist_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_2_OFFER_2 = BUILDER
                .comment(" Botanist 2 Trade Offer 2 Table")
                .define("botanist_2_trade_offer_2_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Botanist Level Three Trade One");
        BOTANIST_3_REQUEST_1 = BUILDER
                .comment(" Botanist 3 Trade Request 1 Table")
                .define("botanist_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_3_OFFER_1 = BUILDER
                .comment(" Botanist 3 Trade Offer 1 Table")
                .define("botanist_3_trade_offer_1_table",
                        TradeLootTables.FRAMES_TABLE.toString());
        BOTANIST_3_OFFER_1_COUNT = BUILDER
                .define("botanist_3_trade_offer_1_count", 2);
        BUILDER.pop();
        BUILDER.push("Botanist Level Three Trade Two");
        BOTANIST_3_REQUEST_2 = BUILDER
                .comment(" Botanist 3 Trade Request 2 Table")
                .define("botanist_3_trade_request_2_count",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_3_OFFER_2 = BUILDER
                .comment(" Botanist 3 Trade Offer 2 Table")
                .define("botanist_3_trade_offer_2_table",
                        TradeLootTables.TAGGED_CANDLE_TABLE.toString());
        BOTANIST_3_OFFER_2_COUNT = BUILDER
                .define("botanist_3_trade_offer_2_count", 4);
        BUILDER.pop();
        // level 4
        BUILDER.push("Botanist Level Four Trade One");
        BOTANIST_4_REQUEST_1 = BUILDER
                .comment(" Botanist 4 Trade Request 1 Table")
                .define("botanist_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_4_OFFER_1 = BUILDER
                .comment(" Botanist 4 Trade Offer 1 Table")
                .define("botanist_4_trade_offer_1_table",
                        TradeLootTables.LANTERN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Botanist Level Four Trade Two");
        BOTANIST_4_REQUEST_2 = BUILDER
                .comment(" Botanist 4 Trade Request 2 Table")
                .define("botanist_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_4_OFFER_2 = BUILDER
                .comment(" Botanist 4 Trade Offer 2 Table")
                .define("botanist_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_CANDLE_TABLE.toString());
        BOTANIST_4_OFFER_2_COUNT = BUILDER
                .define("botanist_3_trade_offer_2_count", 4);
        BUILDER.pop();
        // level 5
        BUILDER.push("Botanist Level Five Trade One")
                .comment(" Rare Trade");
        BOTANIST_5_REQUEST_1 = BUILDER
                .comment(" Botanist 5 Trade Request 1 Table")
                .define("botanist_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_5_OFFER_1 = BUILDER
                .comment(" Botanist 5 Trade Offer 1 Table")
                .define("botanist_5_trade_offer_1_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Botanist Level Five Trade Two")
                .comment(" Rare Trade");
        BOTANIST_5_REQUEST_2 = BUILDER
                .comment(" Botanist 5 Trade Request 2 Table")
                .define("botanist_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BOTANIST_5_OFFER_2 = BUILDER
                .comment(" Botanist 5 Trade Offer 2 Table")
                .define("botanist_5_trade_offer_2_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // BOTANIST TRADE GETTERS
    public static String getBotanist5Offer2() {
        if (Objects.equals(BOTANIST_5_OFFER_2.get(), BOTANIST_5_OFFER_2.getDefault())) {
            return BOTANIST_5_OFFER_2.getDefault();
        }
        else {
            return BOTANIST_5_OFFER_2.get();
        }
    }
    public static String getBotanist5Request2() {
        if (Objects.equals(BOTANIST_5_REQUEST_2.get(), BOTANIST_5_REQUEST_2.getDefault())) {
            return BOTANIST_5_REQUEST_2.getDefault();
        }
        else {
            return BOTANIST_5_REQUEST_2.get();
        }
    }
    public static String getBotanist5Offer1() {
        if (Objects.equals(BOTANIST_5_OFFER_1.get(), BOTANIST_5_OFFER_1.getDefault())) {
            return BOTANIST_5_OFFER_1.getDefault();
        }
        else {
            return BOTANIST_5_OFFER_1.get();
        }
    }
    public static String getBotanist5Request1() {
        if (Objects.equals(BOTANIST_5_REQUEST_1.get(), BOTANIST_5_REQUEST_1.getDefault())) {
            return BOTANIST_5_REQUEST_1.getDefault();
        }
        else {
            return BOTANIST_5_REQUEST_1.get();
        }
    }
    public static int getBotanist4Offer2Count() {
        if (Objects.equals(BOTANIST_4_OFFER_2_COUNT.get(), BOTANIST_4_OFFER_2_COUNT.getDefault())) {
            return BOTANIST_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return BOTANIST_4_OFFER_2_COUNT.get();
        }
    }
    public static String getBotanist4Offer2() {
        if (Objects.equals(BOTANIST_4_OFFER_2.get(), BOTANIST_4_OFFER_2.getDefault())) {
            return BOTANIST_4_OFFER_2.getDefault();
        }
        else {
            return BOTANIST_4_OFFER_2.get();
        }
    }
    public static String getBotanist4Request2() {
        if (Objects.equals(BOTANIST_4_REQUEST_2.get(), BOTANIST_4_REQUEST_2.getDefault())) {
            return BOTANIST_4_REQUEST_2.getDefault();
        }
        else {
            return BOTANIST_4_REQUEST_2.get();
        }
    }
    public static String getBotanist4Offer1() {
        if (Objects.equals(BOTANIST_4_OFFER_1.get(), BOTANIST_4_OFFER_1.getDefault())) {
            return BOTANIST_4_OFFER_1.getDefault();
        }
        else {
            return BOTANIST_4_OFFER_1.get();
        }
    }
    public static String getBotanist4Request1() {
        if (Objects.equals(BOTANIST_4_REQUEST_1.get(), BOTANIST_4_REQUEST_1.getDefault())) {
            return BOTANIST_4_REQUEST_1.getDefault();
        }
        else {
            return BOTANIST_4_REQUEST_1.get();
        }
    }
    public static int getBotanist3Offer2Count() {
        if (Objects.equals(BOTANIST_3_OFFER_2_COUNT.get(), BOTANIST_3_OFFER_2_COUNT.getDefault())) {
            return BOTANIST_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return BOTANIST_3_OFFER_2_COUNT.get();
        }
    }
    public static String getBotanist3Offer2() {
        if (Objects.equals(BOTANIST_3_OFFER_2.get(), BOTANIST_3_OFFER_2.getDefault())) {
            return BOTANIST_3_OFFER_2.getDefault();
        }
        else {
            return BOTANIST_3_OFFER_2.get();
        }
    }
    public static String getBotanist3Request2() {
        if (Objects.equals(BOTANIST_3_REQUEST_2.get(), BOTANIST_3_REQUEST_2.getDefault())) {
            return BOTANIST_3_REQUEST_2.getDefault();
        }
        else {
            return BOTANIST_3_REQUEST_2.get();
        }
    }
    public static int getBotanist3Offer1Count() {
        if (Objects.equals(BOTANIST_3_OFFER_1_COUNT.get(), BOTANIST_3_OFFER_1_COUNT.getDefault())) {
            return BOTANIST_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return BOTANIST_3_OFFER_1_COUNT.get();
        }
    }
    public static String getBotanist3Offer1() {
        if (Objects.equals(BOTANIST_3_OFFER_1.get(), BOTANIST_3_OFFER_1.getDefault())) {
            return BOTANIST_3_OFFER_1.getDefault();
        }
        else {
            return BOTANIST_3_OFFER_1.get();
        }
    }
    public static String getBotanist3Request1() {
        if (Objects.equals(BOTANIST_3_REQUEST_1.get(), BOTANIST_3_REQUEST_1.getDefault())) {
            return BOTANIST_3_REQUEST_1.getDefault();
        }
        else {
            return BOTANIST_3_REQUEST_1.get();
        }
    }
    public static String getBotanist2Offer2() {
        if (Objects.equals(BOTANIST_2_OFFER_2.get(), BOTANIST_2_OFFER_2.getDefault())) {
            return BOTANIST_2_OFFER_2.getDefault();
        }
        else {
            return BOTANIST_2_OFFER_2.get();
        }
    }
    public static String getBotanist2Request2() {
        if (Objects.equals(BOTANIST_2_REQUEST_2.get(), BOTANIST_2_REQUEST_2.getDefault())) {
            return BOTANIST_2_REQUEST_2.getDefault();
        }
        else {
            return BOTANIST_2_REQUEST_2.get();
        }
    }
    public static int getBotanist2Offer1Count() {
        if (Objects.equals(BOTANIST_2_OFFER_1_COUNT.get(), BOTANIST_2_OFFER_1_COUNT.getDefault())) {
            return BOTANIST_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return BOTANIST_2_OFFER_1_COUNT.get();
        }
    }
    public static String getBotanist2Offer1() {
        if (Objects.equals(BOTANIST_2_OFFER_1.get(), BOTANIST_2_OFFER_1.getDefault())) {
            return BOTANIST_2_OFFER_1.getDefault();
        }
        else {
            return BOTANIST_2_OFFER_1.get();
        }
    }
    public static String getBotanist2Request1() {
        if (Objects.equals(BOTANIST_2_REQUEST_1.get(), BOTANIST_2_REQUEST_1.getDefault())) {
            return BOTANIST_2_REQUEST_1.getDefault();
        }
        else {
            return BOTANIST_2_REQUEST_1.get();
        }
    }
    public static String getBotanist1Offer3() {
        if (Objects.equals(BOTANIST_1_OFFER_3.get(), BOTANIST_1_OFFER_3.getDefault())) {
            return BOTANIST_1_OFFER_3.getDefault();
        }
        else {
            return BOTANIST_1_OFFER_3.get();
        }
    }
    public static String getBotanist1Request3() {
        if (Objects.equals(BOTANIST_1_REQUEST_3.get(), BOTANIST_1_REQUEST_3.getDefault())) {
            return BOTANIST_1_REQUEST_3.getDefault();
        }
        else {
            return BOTANIST_1_REQUEST_3.get();
        }
    }
    public static String getBotanist1Offer2() {
        if (Objects.equals(BOTANIST_1_OFFER_2.get(), BOTANIST_1_OFFER_2.getDefault())) {
            return BOTANIST_1_OFFER_2.getDefault();
        }
        else {
            return BOTANIST_1_OFFER_2.get();
        }
    }
    public static String getBotanist1Request2() {
        if (Objects.equals(BOTANIST_1_REQUEST_2.get(), BOTANIST_1_REQUEST_2.getDefault())) {
            return BOTANIST_1_REQUEST_2.getDefault();
        }
        else {
            return BOTANIST_1_REQUEST_2.get();
        }
    }
    public static String getBotanist1Offer1() {
        if (Objects.equals(BOTANIST_1_OFFER_1.get(), BOTANIST_1_OFFER_1.getDefault())) {
            return BOTANIST_1_OFFER_1.getDefault();
        }
        else {
            return BOTANIST_1_OFFER_1.get();
        }
    }
    public static String getBotanist1Request1() {
        if (Objects.equals(BOTANIST_1_REQUEST_1.get(), BOTANIST_1_REQUEST_1.getDefault())) {
            return BOTANIST_1_REQUEST_1.getDefault();
        }
        else {
            return BOTANIST_1_REQUEST_1.get();
        }
    }
}