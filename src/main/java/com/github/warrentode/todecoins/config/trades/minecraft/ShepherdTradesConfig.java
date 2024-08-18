package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShepherdTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Shepherd Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_2_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_2_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_4_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_5_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_5_OFFER_2;

    static {
        // SHEPHERD TRADES
        BUILDER.push("Shepherd Trade Settings");
        // level 1
        BUILDER.push("Shepherd Level One Trade One");
        SHEPHERD_1_REQUEST_1 = BUILDER
                .comment(" Shepherd 1 Trade Request 1 Table")
                .define("shepherd_1_trade_request_1_table",
                        TradeLootTables.TAGGED_WOOL_TABLE.toString());
        SHEPHERD_1_REQUEST_1_COUNT = BUILDER
                .defineInRange("shepherd_1_trade_offer_1_count", 18, 1, 64);
        SHEPHERD_1_OFFER_1 = BUILDER
                .comment(" Shepherd 1 Trade Offer 1 Table")
                .define("shepherd_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level One Trade Two");
        SHEPHERD_1_REQUEST_2 = BUILDER
                .comment(" Shepherd 1 Trade Request 2 Table")
                .define("shepherd_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_1_OFFER_2 = BUILDER
                .comment(" Shepherd 1 Trade Offer 2 Table")
                .define("shepherd_1_trade_offer_2_table",
                        TradeLootTables.SHEARS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Shepherd Level Two Trade One");
        SHEPHERD_2_REQUEST_1 = BUILDER
                .comment(" Shepherd 2 Trade Request 1 Table")
                .define("shepherd_2_trade_request_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        SHEPHERD_2_REQUEST_1_COUNT = BUILDER
                .defineInRange("shepherd_2_trade_offer_1_count", 6, 1, 64);
        SHEPHERD_2_OFFER_1 = BUILDER
                .comment(" Shepherd 2 Trade Offer 1 Table")
                .define("shepherd_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level Two Trade Two");
        SHEPHERD_2_REQUEST_2 = BUILDER
                .comment(" Shepherd 2 Trade Request 2 Table")
                .define("shepherd_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_2_OFFER_2 = BUILDER
                .comment(" Shepherd 2 Trade Offer 2 Table")
                .define("shepherd_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_WOOL_TABLE.toString());
        SHEPHERD_2_OFFER_2_COUNT = BUILDER
                .defineInRange("shepherd_2_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Shepherd Level Two Trade Three");
        SHEPHERD_2_REQUEST_3 = BUILDER
                .comment(" Shepherd 2 Trade Request 3 Table")
                .define("shepherd_2_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_2_OFFER_3 = BUILDER
                .comment(" Shepherd 2 Trade Offer 3 Table")
                .define("shepherd_2_trade_offer_3_table",
                        TradeLootTables.TAGGED_WOOL_CARPETS_TABLE.toString());
        SHEPHERD_2_OFFER_3_COUNT = BUILDER
                .defineInRange("shepherd_2_trade_offer_3_count", 3, 1, 64);
        BUILDER.pop();
        // level 3
        BUILDER.push("Shepherd Level Three Trade One");
        SHEPHERD_3_REQUEST_1 = BUILDER
                .comment(" Shepherd 3 Trade Request 1 Table")
                .define("shepherd_3_trade_request_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        SHEPHERD_3_REQUEST_1_COUNT = BUILDER
                .defineInRange("shepherd_3_trade_offer_1_count", 6, 1, 64);
        SHEPHERD_3_OFFER_1 = BUILDER
                .comment(" Shepherd 2 Trade Offer 1 Table")
                .define("shepherd_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level Three Trade Two");
        SHEPHERD_3_REQUEST_2 = BUILDER
                .comment(" Shepherd 3 Trade Request 2 Table")
                .define("shepherd_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_3_OFFER_2 = BUILDER
                .comment(" Shepherd 3 Trade Offer 2 Table")
                .define("shepherd_3_trade_offer_2_table",
                        TradeLootTables.TAGGED_BEDS_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Shepherd Level Four Trade One");
        SHEPHERD_4_REQUEST_1 = BUILDER
                .comment(" Shepherd 4 Trade Request 1 Table")
                .define("shepherd_4_trade_request_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        SHEPHERD_4_REQUEST_1_COUNT = BUILDER
                .defineInRange("shepherd_4_trade_offer_1_count", 6, 1, 64);
        SHEPHERD_4_OFFER_1 = BUILDER
                .comment(" Shepherd 4 Trade Offer 1 Table")
                .define("shepherd_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level Four Trade Two");
        SHEPHERD_4_REQUEST_2 = BUILDER
                .comment(" Shepherd 4 Trade Request 2 Table")
                .define("shepherd_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_4_OFFER_2 = BUILDER
                .comment(" Shepherd 4 Trade Offer 2 Table")
                .define("shepherd_4_trade_offer_2_table",
                        TradeLootTables.BANNER_PATTERN_TABLE.toString());
        SHEPHERD_4_OFFER_2_COUNT = BUILDER
                .defineInRange("shepherd_4_trade_offer_2_count", 3, 1, 64);
        BUILDER.pop();
        // level 5
        BUILDER.push("Shepherd Level Five Trade One");
        SHEPHERD_5_REQUEST_1 = BUILDER
                .comment(" Shepherd 5 Trade Request 1 Table")
                .define("shepherd_5_trade_request_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        SHEPHERD_5_REQUEST_1_COUNT = BUILDER
                .defineInRange("shepherd_5_trade_offer_1_count", 6, 1, 64);
        SHEPHERD_5_OFFER_1 = BUILDER
                .comment(" Shepherd 5 Trade Offer 1 Table")
                .define("shepherd_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level Five Trade Two");
        SHEPHERD_5_REQUEST_2 = BUILDER
                .comment(" Shepherd 5 Trade Request 2 Table")
                .define("shepherd_5_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_5_OFFER_2 = BUILDER
                .comment(" Shepherd 5 Trade Offer 2 Table")
                .define("shepherd_5_trade_offer_2_table",
                        TradeLootTables.PAINTINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // SHEPHERD TRADE GETTERS
    public static String getShepherd5Offer2() {
        if (Objects.equals(SHEPHERD_5_OFFER_2.get(), SHEPHERD_5_OFFER_2.getDefault())) {
            return SHEPHERD_5_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_5_OFFER_2.get();
        }
    }
    public static String getShepherd5Request2() {
        if (Objects.equals(SHEPHERD_5_REQUEST_2.get(), SHEPHERD_5_REQUEST_2.getDefault())) {
            return SHEPHERD_5_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_5_REQUEST_2.get();
        }
    }
    public static String getShepherd5Offer1() {
        if (Objects.equals(SHEPHERD_5_OFFER_1.get(), SHEPHERD_5_OFFER_1.getDefault())) {
            return SHEPHERD_5_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_5_OFFER_1.get();
        }
    }
    public static int getShepherd5Request1Count() {
        if (Objects.equals(SHEPHERD_5_REQUEST_1_COUNT.get(), SHEPHERD_5_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_5_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_5_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd5Request1() {
        if (Objects.equals(SHEPHERD_5_REQUEST_1.get(), SHEPHERD_5_REQUEST_1.getDefault())) {
            return SHEPHERD_5_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_5_REQUEST_1.get();
        }
    }
    public static int getShepherd4Offer2Count() {
        if (Objects.equals(SHEPHERD_4_OFFER_2_COUNT.get(), SHEPHERD_4_OFFER_2_COUNT.getDefault())) {
            return SHEPHERD_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return SHEPHERD_4_OFFER_2_COUNT.get();
        }
    }
    public static String getShepherd4Offer2() {
        if (Objects.equals(SHEPHERD_4_OFFER_2.get(), SHEPHERD_4_OFFER_2.getDefault())) {
            return SHEPHERD_4_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_4_OFFER_2.get();
        }
    }
    public static String getShepherd4Request2() {
        if (Objects.equals(SHEPHERD_4_REQUEST_2.get(), SHEPHERD_4_REQUEST_2.getDefault())) {
            return SHEPHERD_4_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_4_REQUEST_2.get();
        }
    }
    public static String getShepherd4Offer1() {
        if (Objects.equals(SHEPHERD_4_OFFER_1.get(), SHEPHERD_4_OFFER_1.getDefault())) {
            return SHEPHERD_4_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_4_OFFER_1.get();
        }
    }
    public static int getShepherd4Request1Count() {
        if (Objects.equals(SHEPHERD_4_REQUEST_1_COUNT.get(), SHEPHERD_4_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_4_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_4_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd4Request1() {
        if (Objects.equals(SHEPHERD_4_REQUEST_1.get(), SHEPHERD_4_REQUEST_1.getDefault())) {
            return SHEPHERD_4_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_4_REQUEST_1.get();
        }
    }
    public static String getShepherd3Offer2() {
        if (Objects.equals(SHEPHERD_3_OFFER_2.get(), SHEPHERD_3_OFFER_2.getDefault())) {
            return SHEPHERD_3_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_3_OFFER_2.get();
        }
    }
    public static String getShepherd3Request2() {
        if (Objects.equals(SHEPHERD_3_REQUEST_2.get(), SHEPHERD_3_REQUEST_2.getDefault())) {
            return SHEPHERD_3_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_3_REQUEST_2.get();
        }
    }
    public static String getShepherd3Offer1() {
        if (Objects.equals(SHEPHERD_3_OFFER_1.get(), SHEPHERD_3_OFFER_1.getDefault())) {
            return SHEPHERD_3_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_3_OFFER_1.get();
        }
    }
    public static int getShepherd3Request1Count() {
        if (Objects.equals(SHEPHERD_3_REQUEST_1_COUNT.get(), SHEPHERD_3_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd3Request1() {
        if (Objects.equals(SHEPHERD_3_REQUEST_1.get(), SHEPHERD_3_REQUEST_1.getDefault())) {
            return SHEPHERD_3_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_3_REQUEST_1.get();
        }
    }
    public static int getShepherd2Offer3Count() {
        if (Objects.equals(SHEPHERD_2_OFFER_3_COUNT.get(), SHEPHERD_2_OFFER_3_COUNT.getDefault())) {
            return SHEPHERD_2_OFFER_3_COUNT.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_3_COUNT.get();
        }
    }
    public static String getShepherd2Offer3() {
        if (Objects.equals(SHEPHERD_2_OFFER_3.get(), SHEPHERD_2_OFFER_3.getDefault())) {
            return SHEPHERD_2_OFFER_3.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_3.get();
        }
    }
    public static String getShepherd2Request3() {
        if (Objects.equals(SHEPHERD_2_REQUEST_3.get(), SHEPHERD_2_REQUEST_3.getDefault())) {
            return SHEPHERD_2_REQUEST_3.getDefault();
        }
        else {
            return SHEPHERD_2_REQUEST_3.get();
        }
    }
    public static int getShepherd2Offer2Count() {
        if (Objects.equals(SHEPHERD_2_OFFER_2_COUNT.get(), SHEPHERD_2_OFFER_2_COUNT.getDefault())) {
            return SHEPHERD_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_2_COUNT.get();
        }
    }
    public static String getShepherd2Offer2() {
        if (Objects.equals(SHEPHERD_2_OFFER_2.get(), SHEPHERD_2_OFFER_2.getDefault())) {
            return SHEPHERD_2_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_2.get();
        }
    }
    public static String getShepherd2Request2() {
        if (Objects.equals(SHEPHERD_2_REQUEST_2.get(), SHEPHERD_2_REQUEST_2.getDefault())) {
            return SHEPHERD_2_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_2_REQUEST_2.get();
        }
    }
    public static String getShepherd2Offer1() {
        if (Objects.equals(SHEPHERD_2_OFFER_1.get(), SHEPHERD_2_OFFER_1.getDefault())) {
            return SHEPHERD_2_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_1.get();
        }
    }
    public static int getShepherd2Request1Count() {
        if (Objects.equals(SHEPHERD_2_REQUEST_1_COUNT.get(), SHEPHERD_2_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_2_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_2_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd2Request1() {
        if (Objects.equals(SHEPHERD_2_REQUEST_1.get(), SHEPHERD_2_REQUEST_1.getDefault())) {
            return SHEPHERD_2_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_2_REQUEST_1.get();
        }
    }
    public static String getShepherd1Offer2() {
        if (Objects.equals(SHEPHERD_1_OFFER_2.get(), SHEPHERD_1_OFFER_2.getDefault())) {
            return SHEPHERD_1_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_1_OFFER_2.get();
        }
    }
    public static String getShepherd1Request2() {
        if (Objects.equals(SHEPHERD_1_REQUEST_2.get(), SHEPHERD_1_REQUEST_2.getDefault())) {
            return SHEPHERD_1_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_1_REQUEST_2.get();
        }
    }
    public static String getShepherd1Offer1() {
        if (Objects.equals(SHEPHERD_1_OFFER_1.get(), SHEPHERD_1_OFFER_1.getDefault())) {
            return SHEPHERD_1_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_1_OFFER_1.get();
        }
    }
    public static int getShepherd1Request1Count() {
        if (Objects.equals(SHEPHERD_1_REQUEST_1_COUNT.get(), SHEPHERD_1_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd1Request1() {
        if (Objects.equals(SHEPHERD_1_REQUEST_1.get(), SHEPHERD_1_REQUEST_1.getDefault())) {
            return SHEPHERD_1_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_1_REQUEST_1.get();
        }
    }
}