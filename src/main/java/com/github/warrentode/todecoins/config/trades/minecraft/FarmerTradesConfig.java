package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarmerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Farmer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_2_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_5_OFFER_2;

    static {
        // FARMER TRADES
        BUILDER.push("Farmer Trade Settings");
        // level 1
        BUILDER.push("Farmer Level One Trade One");
        FARMER_1_REQUEST_1 = BUILDER
                .comment(" Farmer 1 Trade Request 1 Table")
                .define("farmer_1_trade_request_1_table",
                        TradeLootTables.TAGGED_VEGGIES_AND_GRAINS_TABLE.toString());
        FARMER_1_REQUEST_1_COUNT = BUILDER
                .define("farmer_1_trade_request_1_count", 24);
        FARMER_1_OFFER_1 = BUILDER
                .comment(" Farmer 1 Trade Offer 1 Table")
                .define("farmer_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Farmer Level One Trade Two");
        FARMER_1_REQUEST_2 = BUILDER
                .comment(" Farmer 1 Trade Request 2 Table")
                .define("farmer_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_1_OFFER_2 = BUILDER
                .comment(" Farmer 1 Trade Offer 2 Table")
                .define("farmer_1_trade_offer_2_table",
                        TradeLootTables.TAGGED_BREADS_TABLE.toString());
        FARMER_1_OFFER_2_COUNT = BUILDER
                .define("farmer_1_trade_offer_2_count", 6);
        BUILDER.pop();
        // level 2
        BUILDER.push("Farmer Level Two Trade One");
        FARMER_2_REQUEST_1 = BUILDER
                .comment(" Farmer 2 Trade Request 1 Table")
                .define("farmer_2_trade_request_1_table",
                        TradeLootTables.TAGGED_GOURDS_TABLE.toString());
        FARMER_2_REQUEST_1_COUNT = BUILDER
                .define("farmer_2_trade_request_1_count", 6);
        FARMER_2_OFFER_1 = BUILDER
                .comment(" Farmer 2 Trade Offer 1 Table")
                .define("farmer_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Farmer Level Two Trade Two");
        FARMER_2_REQUEST_2 = BUILDER
                .comment(" Farmer 2 Trade Request 2 Table")
                .define("farmer_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_2_OFFER_2 = BUILDER
                .comment(" Farmer 2 Trade Offer 2 Table")
                .define("farmer_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_PIES_TABLE.toString());
        FARMER_2_OFFER_2_COUNT = BUILDER
                .define("farmer_2_trade_offer_2_count", 4);
        BUILDER.pop();
        // level 3
        BUILDER.push("Farmer Level Three Trade One");
        FARMER_3_REQUEST_1 = BUILDER
                .comment(" Farmer 3 Trade Request 1 Table")
                .define("farmer_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_3_OFFER_1 = BUILDER
                .comment(" Farmer 3 Trade Offer 1 Table")
                .define("farmer_3_trade_offer_1_table",
                        TradeLootTables.TAGGED_FRUITS_TABLE.toString());
        FARMER_3_OFFER_1_COUNT = BUILDER
                .define("farmer_3_trade_offer_1_count", 6);
        BUILDER.pop();
        BUILDER.push("Farmer Level Three Trade Two");
        FARMER_3_REQUEST_2 = BUILDER
                .comment(" Farmer 3 Trade Request 2 Table")
                .define("farmer_3_trade_request_2_count",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_3_OFFER_2 = BUILDER
                .comment(" Farmer 3 Trade Offer 2 Table")
                .define("farmer_3_trade_offer_2_table",
                        TradeLootTables.TAGGED_COOKIES_TABLE.toString());
        FARMER_3_OFFER_2_COUNT = BUILDER
                .define("farmer_3_trade_offer_2_count", 8);
        BUILDER.pop();
        // level 4
        BUILDER.push("Farmer Level Four Trade One");
        FARMER_4_REQUEST_1 = BUILDER
                .comment(" Farmer 4 Trade Request 1 Table")
                .define("farmer_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_4_OFFER_1 = BUILDER
                .comment(" Farmer 4 Trade Offer 1 Table")
                .define("farmer_4_trade_offer_1_table",
                        TradeLootTables.TAGGED_CAKES_TABLE.toString());
        FARMER_4_OFFER_1_COUNT = BUILDER
                .define("farmer_4_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Farmer Level Four Trade Two");
        FARMER_4_REQUEST_2 = BUILDER
                .comment(" Farmer 4 Trade Request 2 Table")
                .comment(" Suspicious Stew Trade - adds all registered mob effects")
                .define("farmer_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Farmer Level Five Trade One")
                .comment(" Rare Trade");
        FARMER_5_REQUEST_1 = BUILDER
                .comment(" Farmer 5 Trade Request 1 Table")
                .define("farmer_5_trade_request_1_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_5_OFFER_1 = BUILDER
                .comment(" Farmer 5 Trade Offer 1 Table")
                .define("farmer_5_trade_offer_1_table",
                        TradeLootTables.GOLDEN_FOOD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Farmer Level Five Trade Two")
                .comment(" Rare Trade");
        FARMER_5_REQUEST_2 = BUILDER
                .comment(" Farmer 5 Trade Request 2 Table")
                .define("farmer_5_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_5_OFFER_2 = BUILDER
                .comment(" Farmer 5 Trade Offer 2 Table")
                .define("farmer_5_trade_offer_2_table",
                        TradeLootTables.GOLDEN_FOOD_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // FARMER TRADE GETTERS
    public static String getFarmer5Offer2() {
        if (Objects.equals(FARMER_5_OFFER_2.get(), FARMER_5_OFFER_2.getDefault())) {
            return FARMER_5_OFFER_2.getDefault();
        }
        else {
            return FARMER_5_OFFER_2.get();
        }
    }
    public static String getFarmer5Request2() {
        if (Objects.equals(FARMER_5_REQUEST_2.get(), FARMER_5_REQUEST_2.getDefault())) {
            return FARMER_5_REQUEST_2.getDefault();
        }
        else {
            return FARMER_5_REQUEST_2.get();
        }
    }
    public static String getFarmer5Offer1() {
        if (Objects.equals(FARMER_5_OFFER_1.get(), FARMER_5_OFFER_1.getDefault())) {
            return FARMER_5_OFFER_1.getDefault();
        }
        else {
            return FARMER_5_OFFER_1.get();
        }
    }
    public static String getFarmer5Request1() {
        if (Objects.equals(FARMER_5_REQUEST_1.get(), FARMER_5_REQUEST_1.getDefault())) {
            return FARMER_5_REQUEST_1.getDefault();
        }
        else {
            return FARMER_5_REQUEST_1.get();
        }
    }
    public static String getFarmer4Request2() {
        if (Objects.equals(FARMER_4_REQUEST_2.get(), FARMER_4_REQUEST_2.getDefault())) {
            return FARMER_4_REQUEST_2.getDefault();
        }
        else {
            return FARMER_4_REQUEST_2.get();
        }
    }
    public static int getFarmer4Offer1Count() {
        if (Objects.equals(FARMER_4_OFFER_1_COUNT.get(), FARMER_4_OFFER_1_COUNT.getDefault())) {
            return FARMER_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return FARMER_4_OFFER_1_COUNT.get();
        }
    }
    public static String getFarmer4Offer1() {
        if (Objects.equals(FARMER_4_OFFER_1.get(), FARMER_4_OFFER_1.getDefault())) {
            return FARMER_4_OFFER_1.getDefault();
        }
        else {
            return FARMER_4_OFFER_1.get();
        }
    }
    public static String getFarmer4Request1() {
        if (Objects.equals(FARMER_4_REQUEST_1.get(), FARMER_4_REQUEST_1.getDefault())) {
            return FARMER_4_REQUEST_1.getDefault();
        }
        else {
            return FARMER_4_REQUEST_1.get();
        }
    }
    public static int getFarmer3Offer2Count() {
        if (Objects.equals(FARMER_3_OFFER_2_COUNT.get(), FARMER_3_OFFER_2_COUNT.getDefault())) {
            return FARMER_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return FARMER_3_OFFER_2_COUNT.get();
        }
    }
    public static String getFarmer3Offer2() {
        if (Objects.equals(FARMER_3_OFFER_2.get(), FARMER_3_OFFER_2.getDefault())) {
            return FARMER_3_OFFER_2.getDefault();
        }
        else {
            return FARMER_3_OFFER_2.get();
        }
    }
    public static String getFarmer3Request2() {
        if (Objects.equals(FARMER_3_REQUEST_2.get(), FARMER_3_REQUEST_2.getDefault())) {
            return FARMER_3_REQUEST_2.getDefault();
        }
        else {
            return FARMER_3_REQUEST_2.get();
        }
    }
    public static int getFarmer3Offer1Count() {
        if (Objects.equals(FARMER_3_OFFER_1_COUNT.get(), FARMER_3_OFFER_1_COUNT.getDefault())) {
            return FARMER_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return FARMER_3_OFFER_1_COUNT.get();
        }
    }
    public static String getFarmer3Offer1() {
        if (Objects.equals(FARMER_3_OFFER_1.get(), FARMER_3_OFFER_1.getDefault())) {
            return FARMER_3_OFFER_1.getDefault();
        }
        else {
            return FARMER_3_OFFER_1.get();
        }
    }
    public static String getFarmer3Request1() {
        if (Objects.equals(FARMER_3_REQUEST_1.get(), FARMER_3_REQUEST_1.getDefault())) {
            return FARMER_3_REQUEST_1.getDefault();
        }
        else {
            return FARMER_3_REQUEST_1.get();
        }
    }
    public static int getFarmer2Offer2Count() {
        if (Objects.equals(FARMER_2_OFFER_2_COUNT.get(), FARMER_2_OFFER_2_COUNT.getDefault())) {
            return FARMER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return FARMER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getFarmer2Offer2() {
        if (Objects.equals(FARMER_2_OFFER_2.get(), FARMER_2_OFFER_2.getDefault())) {
            return FARMER_2_OFFER_2.getDefault();
        }
        else {
            return FARMER_2_OFFER_2.get();
        }
    }
    public static String getFarmer2Request2() {
        if (Objects.equals(FARMER_2_REQUEST_2.get(), FARMER_2_REQUEST_2.getDefault())) {
            return FARMER_2_REQUEST_2.getDefault();
        }
        else {
            return FARMER_2_REQUEST_2.get();
        }
    }
    public static String getFarmer2Offer1() {
        if (Objects.equals(FARMER_2_OFFER_1.get(), FARMER_2_OFFER_1.getDefault())) {
            return FARMER_2_OFFER_1.getDefault();
        }
        else {
            return FARMER_2_OFFER_1.get();
        }
    }
    public static int getFarmer2Request1Count() {
        if (Objects.equals(FARMER_2_REQUEST_1_COUNT.get(), FARMER_2_REQUEST_1_COUNT.getDefault())) {
            return FARMER_2_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FARMER_2_REQUEST_1_COUNT.get();
        }
    }
    public static String getFarmer2Request1() {
        if (Objects.equals(FARMER_2_REQUEST_1.get(), FARMER_2_REQUEST_1.getDefault())) {
            return FARMER_2_REQUEST_1.getDefault();
        }
        else {
            return FARMER_2_REQUEST_1.get();
        }
    }
    public static int getFarmer1Offer2Count() {
        if (Objects.equals(FARMER_1_OFFER_2_COUNT.get(), FARMER_1_OFFER_2_COUNT.getDefault())) {
            return FARMER_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return FARMER_1_OFFER_2_COUNT.get();
        }
    }
    public static String getFarmer1Offer2() {
        if (Objects.equals(FARMER_1_OFFER_2.get(), FARMER_1_OFFER_2.getDefault())) {
            return FARMER_1_OFFER_2.getDefault();
        }
        else {
            return FARMER_1_OFFER_2.get();
        }
    }
    public static String getFarmer1Request2() {
        if (Objects.equals(FARMER_1_REQUEST_2.get(), FARMER_1_REQUEST_2.getDefault())) {
            return FARMER_1_REQUEST_2.getDefault();
        }
        else {
            return FARMER_1_REQUEST_2.get();
        }
    }
    public static String getFarmer1Offer1() {
        if (Objects.equals(FARMER_1_OFFER_1.get(), FARMER_1_OFFER_1.getDefault())) {
            return FARMER_1_OFFER_1.getDefault();
        }
        else {
            return FARMER_1_OFFER_1.get();
        }
    }
    public static int getFarmer1Request1Count() {
        if (Objects.equals(FARMER_1_REQUEST_1_COUNT.get(), FARMER_1_REQUEST_1_COUNT.getDefault())) {
            return FARMER_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FARMER_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getFarmer1Request1() {
        if (Objects.equals(FARMER_1_REQUEST_1.get(), FARMER_1_REQUEST_1.getDefault())) {
            return FARMER_1_REQUEST_1.getDefault();
        }
        else {
            return FARMER_1_REQUEST_1.get();
        }
    }
}