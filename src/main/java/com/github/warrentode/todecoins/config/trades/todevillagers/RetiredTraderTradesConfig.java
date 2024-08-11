package com.github.warrentode.todecoins.config.trades.todevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RetiredTraderTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Retired Trader Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> RETIRED_TRADER_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> RETIRED_TRADER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> RETIRED_TRADER_2_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> RETIRED_TRADER_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> RETIRED_TRADER_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> RETIRED_TRADER_5_OFFER_2;

    static {
        // RETIRED_TRADER TRADES
        BUILDER.push("Retired Trader Trade Settings");
        // level 1
        BUILDER.push("Retired Trader Level One Trade One");
        RETIRED_TRADER_1_REQUEST_1 = BUILDER
                .comment(" Retired Trader 1 Trade Request 1 Table")
                .define("retired_trader_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_1_OFFER_1 = BUILDER
                .comment(" Retired Trader 1 Trade Offer 1 Table")
                .define("retired_trader_1_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Retired Trader Level One Trade Two");
        RETIRED_TRADER_1_REQUEST_2 = BUILDER
                .comment(" Retired Trader 1 Trade Request 2 Table")
                .define("retired_trader_1_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_1_OFFER_2 = BUILDER
                .comment(" Retired Trader 1 Trade Offer 2 Table")
                .define("retired_trader_1_trade_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Retired Trader Level One Trade Three");
        RETIRED_TRADER_1_REQUEST_3 = BUILDER
                .comment(" Retired Trader 1 Trade Request 3 Table")
                .define("retired_trader_1_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_1_OFFER_3 = BUILDER
                .comment(" Retired Trader 1 Trade Offer 3 Table")
                .define("retired_trader_1_trade_offer_3_table",
                        TradeLootTables.WANDERING_TRADER_COMMON_OFFERS.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Retired Trader Level Two Trade One");
        RETIRED_TRADER_2_REQUEST_1 = BUILDER
                .comment(" Retired Trader 2 Trade Request 1 Table")
                .define("retired_trader_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_2_OFFER_1 = BUILDER
                .comment(" Retired Trader 2 Trade Offer 1 Table")
                .define("retired_trader_2_trade_offer_1_table",
                        TradeLootTables.SEED_TAG_TABLE.toString());
        RETIRED_TRADER_2_OFFER_1_COUNT = BUILDER
                .define("retired_trader_2_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Retired Trader Level Two Trade Two");
        RETIRED_TRADER_2_REQUEST_2 = BUILDER
                .comment(" Retired Trader 2 Trade Request 2 Table")
                .define("retired_trader_2_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_2_OFFER_2 = BUILDER
                .comment(" Retired Trader 2 Trade Offer 2 Table")
                .define("retired_trader_2_trade_offer_2_table",
                        TradeLootTables.SLIMEBALL_TAG_TABLE.toString());
        RETIRED_TRADER_2_OFFER_2_COUNT = BUILDER
                .define("retired_trader_2_trade_offer_2_count", 1);
        BUILDER.pop();
        BUILDER.push("Retired Trader Level Two Trade Three");
        RETIRED_TRADER_2_REQUEST_3 = BUILDER
                .comment(" Retired Trader 2 Trade Request 3 Table")
                .define("retired_trader_2_trade_request_3_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_2_OFFER_3 = BUILDER
                .comment(" Retired Trader 2 Trade Offer 3 Table")
                .define("retired_trader_2_trade_offer_3_table",
                        TradeLootTables.CORAL_BLOCK_TAG_TABLE.toString());
        RETIRED_TRADER_2_OFFER_3_COUNT = BUILDER
                .define("retired_trader_2_trade_offer_3_count", 1);
        BUILDER.pop();
        // level 3
        BUILDER.push("Retired Trader Level Three Trade One");
        RETIRED_TRADER_3_REQUEST_1 = BUILDER
                .comment(" Retired Trader 3 Trade Request 1 Table")
                .define("retired_trader_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_3_OFFER_1 = BUILDER
                .comment(" Retired Trader 3 Trade Offer 1 Table")
                .define("retired_trader_3_trade_offer_1_table",
                        TradeLootTables.SAND_TAG_TABLE.toString());
        RETIRED_TRADER_3_OFFER_1_COUNT = BUILDER
                .define("retired_trader_3_trade_offer_1_count", 6);
        BUILDER.pop();
        BUILDER.push("Retired Trader Level Three Trade Two");
        RETIRED_TRADER_3_REQUEST_2 = BUILDER
                .comment(" Retired Trader 3 Trade Request 2 Table")
                .define("retired_trader_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_3_OFFER_2 = BUILDER
                .comment(" Retired Trader 3 Trade Offer 2 Table")
                .define("retired_trader_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Retired Trader Level Three Trade Three")
                .comment(" Rare Trade");
        RETIRED_TRADER_3_REQUEST_3 = BUILDER
                .comment(" Retired Trader 3 Trade Request 3 Table")
                .define("retired_trader_3_trade_request_3_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_3_OFFER_3 = BUILDER
                .comment(" Retired Trader 3 Trade Offer 3 Table")
                .define("retired_trader_3_trade_offer_3_table",
                        TradeLootTables.FISH_BUCKET_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Retired Trader Level Four Trade One");
        RETIRED_TRADER_4_REQUEST_1 = BUILDER
                .comment(" Retired Trader 4 Trade Request 1 Table")
                .define("retired_trader_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_4_OFFER_1 = BUILDER
                .comment(" Retired Trader 4 Trade Offer 1 Table")
                .define("retired_trader_4_trade_offer_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        RETIRED_TRADER_4_OFFER_1_COUNT = BUILDER
                .define("retired_trader_4_trade_offer_1_count", 3);
        BUILDER.pop();
        BUILDER.push("Retired Trader Level Four Trade Two");
        RETIRED_TRADER_4_REQUEST_2 = BUILDER
                .comment(" Retired Trader 4 Trade Request 2 Table")
                .define("retired_trader_4_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_4_OFFER_2 = BUILDER
                .comment(" Retired Trader 4 Trade Offer 2 Table")
                .define("retired_trader_4_trade_offer_2_table",
                        TradeLootTables.SEASHELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Retired Trader Level Four Trade Three")
                .comment(" Rare Trade");
        RETIRED_TRADER_4_REQUEST_3 = BUILDER
                .comment(" Retired Trader 4 Trade Request 3 Table")
                .define("retired_trader_4_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_4_OFFER_3 = BUILDER
                .comment(" Retired Trader 4 Trade Offer 3 Table")
                .define("retired_trader_4_trade_offer_3_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Retired Trader Level Five Trade One")
                .comment(" Rare Trade");
        RETIRED_TRADER_5_REQUEST_1 = BUILDER
                .comment(" Retired Trader 5 Trade Request 1 Table")
                .define("retired_trader_5_trade_request_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_5_OFFER_1 = BUILDER
                .comment(" Retired Trader 5 Trade Offer 1 Table")
                .define("retired_trader_5_trade_offer_1_table",
                        TradeLootTables.ICE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Retired Trader Level Five Trade Two")
                .comment(" Rare Trade");
        RETIRED_TRADER_5_REQUEST_2 = BUILDER
                .comment(" Retired Trader 5 Trade Request 2 Table")
                .define("retired_trader_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        RETIRED_TRADER_5_OFFER_2 = BUILDER
                .comment(" Retired Trader 5 Trade Offer 2 Table")
                .define("retired_trader_5_trade_offer_2_table",
                        TradeLootTables.WANDERING_TRADER_RARE_OFFERS.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // RETIRED_TRADER TRADE GETTERS
    public static String getRetiredTrader5Offer2() {
        if (Objects.equals(RETIRED_TRADER_5_OFFER_2.get(), RETIRED_TRADER_5_OFFER_2.getDefault())) {
            return RETIRED_TRADER_5_OFFER_2.getDefault();
        }
        else {
            return RETIRED_TRADER_5_OFFER_2.get();
        }
    }
    public static String getRetiredTrader5Request2() {
        if (Objects.equals(RETIRED_TRADER_5_REQUEST_2.get(), RETIRED_TRADER_5_REQUEST_2.getDefault())) {
            return RETIRED_TRADER_5_REQUEST_2.getDefault();
        }
        else {
            return RETIRED_TRADER_5_REQUEST_2.get();
        }
    }
    public static String getRetiredTrader5Offer1() {
        if (Objects.equals(RETIRED_TRADER_5_OFFER_1.get(), RETIRED_TRADER_5_OFFER_1.getDefault())) {
            return RETIRED_TRADER_5_OFFER_1.getDefault();
        }
        else {
            return RETIRED_TRADER_5_OFFER_1.get();
        }
    }
    public static String getRetiredTrader5Request1() {
        if (Objects.equals(RETIRED_TRADER_5_REQUEST_1.get(), RETIRED_TRADER_5_REQUEST_1.getDefault())) {
            return RETIRED_TRADER_5_REQUEST_1.getDefault();
        }
        else {
            return RETIRED_TRADER_5_REQUEST_1.get();
        }
    }
    public static String getRetiredTrader4Offer3() {
        if (Objects.equals(RETIRED_TRADER_4_OFFER_3.get(), RETIRED_TRADER_4_OFFER_3.getDefault())) {
            return RETIRED_TRADER_4_OFFER_3.getDefault();
        }
        else {
            return RETIRED_TRADER_4_OFFER_3.get();
        }
    }
    public static String getRetiredTrader4Request3() {
        if (Objects.equals(RETIRED_TRADER_4_REQUEST_3.get(), RETIRED_TRADER_4_REQUEST_3.getDefault())) {
            return RETIRED_TRADER_4_REQUEST_3.getDefault();
        }
        else {
            return RETIRED_TRADER_4_REQUEST_3.get();
        }
    }
    public static String getRetiredTrader4Offer2() {
        if (Objects.equals(RETIRED_TRADER_4_OFFER_2.get(), RETIRED_TRADER_4_OFFER_2.getDefault())) {
            return RETIRED_TRADER_4_OFFER_2.getDefault();
        }
        else {
            return RETIRED_TRADER_4_OFFER_2.get();
        }
    }
    public static String getRetiredTrader4Request2() {
        if (Objects.equals(RETIRED_TRADER_4_REQUEST_2.get(), RETIRED_TRADER_4_REQUEST_2.getDefault())) {
            return RETIRED_TRADER_4_REQUEST_2.getDefault();
        }
        else {
            return RETIRED_TRADER_4_REQUEST_2.get();
        }
    }
    public static int getRetiredTrader4Offer1Count() {
        if (Objects.equals(RETIRED_TRADER_4_OFFER_1_COUNT.get(), RETIRED_TRADER_4_OFFER_1_COUNT.getDefault())) {
            return RETIRED_TRADER_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return RETIRED_TRADER_4_OFFER_1_COUNT.get();
        }
    }
    public static String getRetiredTrader4Offer1() {
        if (Objects.equals(RETIRED_TRADER_4_OFFER_1.get(), RETIRED_TRADER_4_OFFER_1.getDefault())) {
            return RETIRED_TRADER_4_OFFER_1.getDefault();
        }
        else {
            return RETIRED_TRADER_4_OFFER_1.get();
        }
    }
    public static String getRetiredTrader4Request1() {
        if (Objects.equals(RETIRED_TRADER_4_REQUEST_1.get(), RETIRED_TRADER_4_REQUEST_1.getDefault())) {
            return RETIRED_TRADER_4_REQUEST_1.getDefault();
        }
        else {
            return RETIRED_TRADER_4_REQUEST_1.get();
        }
    }
    public static String getRetiredTrader3Offer3() {
        if (Objects.equals(RETIRED_TRADER_3_OFFER_3.get(), RETIRED_TRADER_3_OFFER_3.getDefault())) {
            return RETIRED_TRADER_3_OFFER_3.getDefault();
        }
        else {
            return RETIRED_TRADER_3_OFFER_3.get();
        }
    }
    public static String getRetiredTrader3Request3() {
        if (Objects.equals(RETIRED_TRADER_3_REQUEST_3.get(), RETIRED_TRADER_3_REQUEST_3.getDefault())) {
            return RETIRED_TRADER_3_REQUEST_3.getDefault();
        }
        else {
            return RETIRED_TRADER_3_REQUEST_3.get();
        }
    }
    public static String getRetiredTrader3Offer2() {
        if (Objects.equals(RETIRED_TRADER_3_OFFER_2.get(), RETIRED_TRADER_3_OFFER_2.getDefault())) {
            return RETIRED_TRADER_3_OFFER_2.getDefault();
        }
        else {
            return RETIRED_TRADER_3_OFFER_2.get();
        }
    }
    public static String getRetiredTrader3Request2() {
        if (Objects.equals(RETIRED_TRADER_3_REQUEST_2.get(), RETIRED_TRADER_3_REQUEST_2.getDefault())) {
            return RETIRED_TRADER_3_REQUEST_2.getDefault();
        }
        else {
            return RETIRED_TRADER_3_REQUEST_2.get();
        }
    }
    public static int getRetiredTrader3Offer1Count() {
        if (Objects.equals(RETIRED_TRADER_3_OFFER_1_COUNT.get(), RETIRED_TRADER_3_OFFER_1_COUNT.getDefault())) {
            return RETIRED_TRADER_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return RETIRED_TRADER_3_OFFER_1_COUNT.get();
        }
    }
    public static String getRetiredTrader3Offer1() {
        if (Objects.equals(RETIRED_TRADER_3_OFFER_1.get(), RETIRED_TRADER_3_OFFER_1.getDefault())) {
            return RETIRED_TRADER_3_OFFER_1.getDefault();
        }
        else {
            return RETIRED_TRADER_3_OFFER_1.get();
        }
    }
    public static String getRetiredTrader3Request1() {
        if (Objects.equals(RETIRED_TRADER_3_REQUEST_1.get(), RETIRED_TRADER_3_REQUEST_1.getDefault())) {
            return RETIRED_TRADER_3_REQUEST_1.getDefault();
        }
        else {
            return RETIRED_TRADER_3_REQUEST_1.get();
        }
    }
    public static int getRetiredTrader2Offer3Count() {
        if (Objects.equals(RETIRED_TRADER_2_OFFER_3_COUNT.get(), RETIRED_TRADER_2_OFFER_3_COUNT.getDefault())) {
            return RETIRED_TRADER_2_OFFER_3_COUNT.getDefault();
        }
        else {
            return RETIRED_TRADER_2_OFFER_3_COUNT.get();
        }
    }
    public static String getRetiredTrader2Offer3() {
        if (Objects.equals(RETIRED_TRADER_2_OFFER_3.get(), RETIRED_TRADER_2_OFFER_3.getDefault())) {
            return RETIRED_TRADER_2_OFFER_3.getDefault();
        }
        else {
            return RETIRED_TRADER_2_OFFER_3.get();
        }
    }
    public static String getRetiredTrader2Request3() {
        if (Objects.equals(RETIRED_TRADER_2_REQUEST_3.get(), RETIRED_TRADER_2_REQUEST_3.getDefault())) {
            return RETIRED_TRADER_2_REQUEST_3.getDefault();
        }
        else {
            return RETIRED_TRADER_2_REQUEST_3.get();
        }
    }
    public static int getRetiredTrader2Offer2Count() {
        if (Objects.equals(RETIRED_TRADER_2_OFFER_2_COUNT.get(), RETIRED_TRADER_2_OFFER_2_COUNT.getDefault())) {
            return RETIRED_TRADER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return RETIRED_TRADER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getRetiredTrader2Offer2() {
        if (Objects.equals(RETIRED_TRADER_2_OFFER_2.get(), RETIRED_TRADER_2_OFFER_2.getDefault())) {
            return RETIRED_TRADER_2_OFFER_2.getDefault();
        }
        else {
            return RETIRED_TRADER_2_OFFER_2.get();
        }
    }
    public static String getRetiredTrader2Request2() {
        if (Objects.equals(RETIRED_TRADER_2_REQUEST_2.get(), RETIRED_TRADER_2_REQUEST_2.getDefault())) {
            return RETIRED_TRADER_2_REQUEST_2.getDefault();
        }
        else {
            return RETIRED_TRADER_2_REQUEST_2.get();
        }
    }
    public static int getRetiredTrader2Offer1Count() {
        if (Objects.equals(RETIRED_TRADER_2_OFFER_1_COUNT.get(), RETIRED_TRADER_2_OFFER_1_COUNT.getDefault())) {
            return RETIRED_TRADER_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return RETIRED_TRADER_2_OFFER_1_COUNT.get();
        }
    }
    public static String getRetiredTrader2Offer1() {
        if (Objects.equals(RETIRED_TRADER_2_OFFER_1.get(), RETIRED_TRADER_2_OFFER_1.getDefault())) {
            return RETIRED_TRADER_2_OFFER_1.getDefault();
        }
        else {
            return RETIRED_TRADER_2_OFFER_1.get();
        }
    }
    public static String getRetiredTrader2Request1() {
        if (Objects.equals(RETIRED_TRADER_2_REQUEST_1.get(), RETIRED_TRADER_2_REQUEST_1.getDefault())) {
            return RETIRED_TRADER_2_REQUEST_1.getDefault();
        }
        else {
            return RETIRED_TRADER_2_REQUEST_1.get();
        }
    }
    public static String getRetiredTrader1Offer3() {
        if (Objects.equals(RETIRED_TRADER_1_OFFER_3.get(), RETIRED_TRADER_1_OFFER_3.getDefault())) {
            return RETIRED_TRADER_1_OFFER_3.getDefault();
        }
        else {
            return RETIRED_TRADER_1_OFFER_3.get();
        }
    }
    public static String getRetiredTrader1Request3() {
        if (Objects.equals(RETIRED_TRADER_1_REQUEST_3.get(), RETIRED_TRADER_1_REQUEST_3.getDefault())) {
            return RETIRED_TRADER_1_REQUEST_3.getDefault();
        }
        else {
            return RETIRED_TRADER_1_REQUEST_3.get();
        }
    }
    public static String getRetiredTrader1Offer2() {
        if (Objects.equals(RETIRED_TRADER_1_OFFER_2.get(), RETIRED_TRADER_1_OFFER_2.getDefault())) {
            return RETIRED_TRADER_1_OFFER_2.getDefault();
        }
        else {
            return RETIRED_TRADER_1_OFFER_2.get();
        }
    }
    public static String getRetiredTrader1Request2() {
        if (Objects.equals(RETIRED_TRADER_1_REQUEST_2.get(), RETIRED_TRADER_1_REQUEST_2.getDefault())) {
            return RETIRED_TRADER_1_REQUEST_2.getDefault();
        }
        else {
            return RETIRED_TRADER_1_REQUEST_2.get();
        }
    }
    public static String getRetiredTrader1Offer1() {
        if (Objects.equals(RETIRED_TRADER_1_OFFER_1.get(), RETIRED_TRADER_1_OFFER_1.getDefault())) {
            return RETIRED_TRADER_1_OFFER_1.getDefault();
        }
        else {
            return RETIRED_TRADER_1_OFFER_1.get();
        }
    }
    public static String getRetiredTrader1Request1() {
        if (Objects.equals(RETIRED_TRADER_1_REQUEST_1.get(), RETIRED_TRADER_1_REQUEST_1.getDefault())) {
            return RETIRED_TRADER_1_REQUEST_1.getDefault();
        }
        else {
            return RETIRED_TRADER_1_REQUEST_1.get();
        }
    }
}