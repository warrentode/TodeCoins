package com.github.warrentode.todecoins.config.trades.dynamicvillage;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HydraulicEngineerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // HydraulicEngineer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> HYDRAULIC_ENGINEER_1_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> HYDRAULIC_ENGINEER_1_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_1_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> HYDRAULIC_ENGINEER_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> HYDRAULIC_ENGINEER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> HYDRAULIC_ENGINEER_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> HYDRAULIC_ENGINEER_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> HYDRAULIC_ENGINEER_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> HYDRAULIC_ENGINEER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> HYDRAULIC_ENGINEER_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HYDRAULIC_ENGINEER_5_OFFER_2;

    static {
        // HYDRAULIC ENGINEER TRADES
        BUILDER.push("Hydraulic Engineer Trade Settings");
        // level 1
        BUILDER.push("Hydraulic Engineer Level One Trade One");
        HYDRAULIC_ENGINEER_1_REQUEST_1 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Request 1 Table")
                .define("hydraulic_engineer_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_1_OFFER_1 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Offer 1 Table")
                .define("hydraulic_engineer_1_trade_offer_1_table",
                        TradeLootTables.COPPER_MATERIALS_TAG_TABLE.toString());
        HYDRAULIC_ENGINEER_1_OFFER_1_COUNT = BUILDER
                .defineInRange("hydraulic_engineer_1_trade_offer_1_count", 9, 1, 64);
        BUILDER.pop();
        BUILDER.push("Hydraulic Engineer Level One Trade TWo");
        HYDRAULIC_ENGINEER_1_REQUEST_2 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Request 2 Table")
                .define("hydraulic_engineer_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_1_OFFER_2 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Offer 2 Table")
                .define("hydraulic_engineer_1_trade_offer_2_table",
                        TradeLootTables.DRIED_KELP_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Hydraulic Engineer Level One Trade Three");
        HYDRAULIC_ENGINEER_1_REQUEST_3 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Request 3 Table")
                .define("hydraulic_engineer_1_trade_request_3_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_1_OFFER_3 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Offer 2 Table")
                .define("hydraulic_engineer_1_trade_offer_2_table",
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE.toString());
        HYDRAULIC_ENGINEER_1_OFFER_3_COUNT = BUILDER
                .defineInRange("hydraulic_engineer_1_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Hydraulic Engineer Level One Trade Four");
        HYDRAULIC_ENGINEER_1_REQUEST_4 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Request 4 Table")
                .define("hydraulic_engineer_1_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_1_OFFER_4 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Offer 4 Table")
                .define("hydraulic_engineer_1_trade_offer_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        BUILDER.pop();
        BUILDER.push("Hydraulic Engineer Level One Trade Five");
        HYDRAULIC_ENGINEER_1_REQUEST_5 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Request 5 Table")
                .define("hydraulic_engineer_1_trade_request_5_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_1_OFFER_5 = BUILDER
                .comment(" Hydraulic Engineer 1 Trade Offer 5 Table")
                .define("hydraulic_engineer_1_trade_offer_5_table",
                        TradeLootTables.COPPER_DIVING_GEAR_TAG_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Hydraulic Engineer Level Two Trade One");
        HYDRAULIC_ENGINEER_2_REQUEST_1 = BUILDER
                .comment(" Hydraulic Engineer 2 Trade Request 1 Table")
                .define("hydraulic_engineer_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_2_OFFER_1 = BUILDER
                .comment(" Hydraulic Engineer 2 Trade Offer 1 Table")
                .define("hydraulic_engineer_2_trade_offer_1_table",
                        TradeLootTables.COPPER_MATERIALS_TAG_TABLE.toString());
        HYDRAULIC_ENGINEER_2_OFFER_1_COUNT = BUILDER
                .defineInRange("hydraulic_engineer_2_trade_offer_1_count", 9, 1, 64);
        BUILDER.pop();
        BUILDER.push("Hydraulic Engineer Level Two Trade TWo");
        HYDRAULIC_ENGINEER_2_REQUEST_2 = BUILDER
                .comment(" Hydraulic Engineer 2 Trade Request 2 Table")
                .define("hydraulic_engineer_2_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_2_OFFER_2 = BUILDER
                .comment(" Hydraulic Engineer 2 Trade Offer 2 Table")
                .define("hydraulic_engineer_2_trade_offer_2_table",
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE.toString());
        HYDRAULIC_ENGINEER_2_OFFER_2_COUNT = BUILDER
                .defineInRange("hydraulic_engineer_2_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 3
        BUILDER.push("Hydraulic Engineer Level Three Trade One");
        HYDRAULIC_ENGINEER_3_REQUEST_1 = BUILDER
                .comment(" Hydraulic Engineer 3 Trade Request 1 Table")
                .define("hydraulic_engineer_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_3_OFFER_1 = BUILDER
                .comment(" Hydraulic Engineer 3 Trade Offer 1 Table")
                .define("hydraulic_engineer_3_trade_offer_1_table",
                        TradeLootTables.COPPER_MATERIALS_TAG_TABLE.toString());
        HYDRAULIC_ENGINEER_3_OFFER_1_COUNT = BUILDER
                .defineInRange("hydraulic_engineer_3_trade_offer_1_count", 9, 1, 64);
        BUILDER.pop();
        BUILDER.push("Hydraulic Engineer Level Three Trade TWo");
        HYDRAULIC_ENGINEER_3_REQUEST_2 = BUILDER
                .comment(" Hydraulic Engineer 3 Trade Request 2 Table")
                .define("hydraulic_engineer_3_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_3_OFFER_2 = BUILDER
                .comment(" Hydraulic Engineer 3 Trade Offer 2 Table")
                .define("hydraulic_engineer_3_trade_offer_2_table",
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE.toString());
        HYDRAULIC_ENGINEER_3_OFFER_2_COUNT = BUILDER
                .defineInRange("hydraulic_engineer_3_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 4
        BUILDER.push("Hydraulic Engineer Level Four Trade One");
        HYDRAULIC_ENGINEER_4_REQUEST_1 = BUILDER
                .comment(" Hydraulic Engineer 4 Trade Request 1 Table")
                .define("hydraulic_engineer_4_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_4_OFFER_1 = BUILDER
                .comment(" Hydraulic Engineer 4 Trade Offer 1 Table")
                .define("hydraulic_engineer_4_trade_offer_1_table",
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE.toString());
        HYDRAULIC_ENGINEER_4_OFFER_1_COUNT = BUILDER
                .defineInRange("hydraulic_engineer_4_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Hydraulic Engineer Level Four Trade TWo");
        HYDRAULIC_ENGINEER_4_REQUEST_2 = BUILDER
                .comment(" Hydraulic Engineer 4 Trade Request 2 Table")
                .define("hydraulic_engineer_4_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_4_OFFER_2 = BUILDER
                .comment(" Hydraulic Engineer 4 Trade Offer 2 Table")
                .define("hydraulic_engineer_4_trade_offer_2_table",
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE.toString());
        HYDRAULIC_ENGINEER_4_OFFER_2_COUNT = BUILDER
                .defineInRange("hydraulic_engineer_4_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 5
        BUILDER.push("Hydraulic Engineer Level Five Trade One");
        HYDRAULIC_ENGINEER_5_REQUEST_1 = BUILDER
                .comment(" Hydraulic Engineer 5 Trade Request 1 Table")
                .define("hydraulic_engineer_5_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_5_OFFER_1 = BUILDER
                .comment(" Hydraulic Engineer 5 Trade Offer 1 Table")
                .define("hydraulic_engineer_5_trade_offer_1_table",
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE.toString());
        HYDRAULIC_ENGINEER_5_OFFER_1_COUNT = BUILDER
                .defineInRange("hydraulic_engineer_5_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Hydraulic Engineer Level Five Trade TWo");
        HYDRAULIC_ENGINEER_5_REQUEST_2 = BUILDER
                .comment(" Hydraulic Engineer 5 Trade Request 2 Table")
                .define("hydraulic_engineer_5_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        HYDRAULIC_ENGINEER_5_OFFER_2 = BUILDER
                .comment(" Hydraulic Engineer 5 Trade Offer 2 Table")
                .define("hydraulic_engineer_5_trade_offer_2_table",
                        TradeLootTables.COPPER_DIVING_GEAR_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // HYDRAULIC_ENGINEER TRADE GETTERS
    public static String getHydraulicEngineer5Offer2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_5_OFFER_2.get(), HYDRAULIC_ENGINEER_5_OFFER_2.getDefault())) {
            return HYDRAULIC_ENGINEER_5_OFFER_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_5_OFFER_2.get();
        }
    }
    public static String getHydraulicEngineer5Request2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_5_REQUEST_2.get(), HYDRAULIC_ENGINEER_5_REQUEST_2.getDefault())) {
            return HYDRAULIC_ENGINEER_5_REQUEST_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_5_REQUEST_2.get();
        }
    }
    public static int getHydraulicEngineer5Offer1Count() {
        if (Objects.equals(HYDRAULIC_ENGINEER_5_OFFER_1_COUNT.get(), HYDRAULIC_ENGINEER_5_OFFER_1_COUNT.getDefault())) {
            return HYDRAULIC_ENGINEER_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_5_OFFER_1_COUNT.get();
        }
    }
    public static String getHydraulicEngineer5Offer1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_5_OFFER_1.get(), HYDRAULIC_ENGINEER_5_OFFER_1.getDefault())) {
            return HYDRAULIC_ENGINEER_5_OFFER_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_5_OFFER_1.get();
        }
    }
    public static String getHydraulicEngineer5Request1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_5_REQUEST_1.get(), HYDRAULIC_ENGINEER_5_REQUEST_1.getDefault())) {
            return HYDRAULIC_ENGINEER_5_REQUEST_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_5_REQUEST_1.get();
        }
    }
    public static int getHydraulicEngineer4Offer2Count() {
        if (Objects.equals(HYDRAULIC_ENGINEER_4_OFFER_2_COUNT.get(), HYDRAULIC_ENGINEER_4_OFFER_2_COUNT.getDefault())) {
            return HYDRAULIC_ENGINEER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getHydraulicEngineer4Offer2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_4_OFFER_2.get(), HYDRAULIC_ENGINEER_4_OFFER_2.getDefault())) {
            return HYDRAULIC_ENGINEER_4_OFFER_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_4_OFFER_2.get();
        }
    }
    public static String getHydraulicEngineer4Request2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_4_REQUEST_2.get(), HYDRAULIC_ENGINEER_4_REQUEST_2.getDefault())) {
            return HYDRAULIC_ENGINEER_4_REQUEST_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_4_REQUEST_2.get();
        }
    }
    public static int getHydraulicEngineer4Offer1Count() {
        if (Objects.equals(HYDRAULIC_ENGINEER_4_OFFER_1_COUNT.get(), HYDRAULIC_ENGINEER_4_OFFER_1_COUNT.getDefault())) {
            return HYDRAULIC_ENGINEER_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_4_OFFER_1_COUNT.get();
        }
    }
    public static String getHydraulicEngineer4Offer1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_4_OFFER_1.get(), HYDRAULIC_ENGINEER_4_OFFER_1.getDefault())) {
            return HYDRAULIC_ENGINEER_4_OFFER_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_4_OFFER_1.get();
        }
    }
    public static String getHydraulicEngineer4Request1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_4_REQUEST_1.get(), HYDRAULIC_ENGINEER_4_REQUEST_1.getDefault())) {
            return HYDRAULIC_ENGINEER_4_REQUEST_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_4_REQUEST_1.get();
        }
    }
    public static int getHydraulicEngineer3Offer2Count() {
        if (Objects.equals(HYDRAULIC_ENGINEER_3_OFFER_2_COUNT.get(), HYDRAULIC_ENGINEER_3_OFFER_2_COUNT.getDefault())) {
            return HYDRAULIC_ENGINEER_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_3_OFFER_2_COUNT.get();
        }
    }
    public static String getHydraulicEngineer3Offer2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_3_OFFER_2.get(), HYDRAULIC_ENGINEER_3_OFFER_2.getDefault())) {
            return HYDRAULIC_ENGINEER_3_OFFER_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_3_OFFER_2.get();
        }
    }
    public static String getHydraulicEngineer3Request2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_3_REQUEST_2.get(), HYDRAULIC_ENGINEER_3_REQUEST_2.getDefault())) {
            return HYDRAULIC_ENGINEER_3_REQUEST_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_3_REQUEST_2.get();
        }
    }
    public static int getHydraulicEngineer3Offer1Count() {
        if (Objects.equals(HYDRAULIC_ENGINEER_3_OFFER_1_COUNT.get(), HYDRAULIC_ENGINEER_3_OFFER_1_COUNT.getDefault())) {
            return HYDRAULIC_ENGINEER_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_3_OFFER_1_COUNT.get();
        }
    }
    public static String getHydraulicEngineer3Offer1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_3_OFFER_1.get(), HYDRAULIC_ENGINEER_3_OFFER_1.getDefault())) {
            return HYDRAULIC_ENGINEER_3_OFFER_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_3_OFFER_1.get();
        }
    }
    public static String getHydraulicEngineer3Request1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_3_REQUEST_1.get(), HYDRAULIC_ENGINEER_3_REQUEST_1.getDefault())) {
            return HYDRAULIC_ENGINEER_3_REQUEST_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_3_REQUEST_1.get();
        }
    }
    public static int getHydraulicEngineer2Offer2Count() {
        if (Objects.equals(HYDRAULIC_ENGINEER_2_OFFER_2_COUNT.get(), HYDRAULIC_ENGINEER_2_OFFER_2_COUNT.getDefault())) {
            return HYDRAULIC_ENGINEER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getHydraulicEngineer2Offer2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_2_OFFER_2.get(), HYDRAULIC_ENGINEER_2_OFFER_2.getDefault())) {
            return HYDRAULIC_ENGINEER_2_OFFER_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_2_OFFER_2.get();
        }
    }
    public static String getHydraulicEngineer2Request2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_2_REQUEST_2.get(), HYDRAULIC_ENGINEER_2_REQUEST_2.getDefault())) {
            return HYDRAULIC_ENGINEER_2_REQUEST_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_2_REQUEST_2.get();
        }
    }
    public static int getHydraulicEngineer2Offer1Count() {
        if (Objects.equals(HYDRAULIC_ENGINEER_2_OFFER_1_COUNT.get(), HYDRAULIC_ENGINEER_2_OFFER_1_COUNT.getDefault())) {
            return HYDRAULIC_ENGINEER_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_2_OFFER_1_COUNT.get();
        }
    }
    public static String getHydraulicEngineer2Offer1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_2_OFFER_1.get(), HYDRAULIC_ENGINEER_2_OFFER_1.getDefault())) {
            return HYDRAULIC_ENGINEER_2_OFFER_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_2_OFFER_1.get();
        }
    }
    public static String getHydraulicEngineer2Request1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_2_REQUEST_1.get(), HYDRAULIC_ENGINEER_2_REQUEST_1.getDefault())) {
            return HYDRAULIC_ENGINEER_2_REQUEST_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_2_REQUEST_1.get();
        }
    }
    public static String getHydraulicEngineer1Offer5() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_OFFER_5.get(), HYDRAULIC_ENGINEER_1_OFFER_5.getDefault())) {
            return HYDRAULIC_ENGINEER_1_OFFER_5.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_OFFER_5.get();
        }
    }
    public static String getHydraulicEngineer1Request5() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_REQUEST_5.get(), HYDRAULIC_ENGINEER_1_REQUEST_5.getDefault())) {
            return HYDRAULIC_ENGINEER_1_REQUEST_5.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_REQUEST_5.get();
        }
    }
    public static String getHydraulicEngineer1Offer4() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_OFFER_4.get(), HYDRAULIC_ENGINEER_1_OFFER_4.getDefault())) {
            return HYDRAULIC_ENGINEER_1_OFFER_4.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_OFFER_4.get();
        }
    }
    public static String getHydraulicEngineer1Request4() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_REQUEST_4.get(), HYDRAULIC_ENGINEER_1_REQUEST_4.getDefault())) {
            return HYDRAULIC_ENGINEER_1_REQUEST_4.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_REQUEST_4.get();
        }
    }
    public static int getHydraulicEngineer1Offer3Count() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_OFFER_3_COUNT.get(), HYDRAULIC_ENGINEER_1_OFFER_3_COUNT.getDefault())) {
            return HYDRAULIC_ENGINEER_1_OFFER_3_COUNT.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_OFFER_3_COUNT.get();
        }
    }
    public static String getHydraulicEngineer1Offer3() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_OFFER_3.get(), HYDRAULIC_ENGINEER_1_OFFER_3.getDefault())) {
            return HYDRAULIC_ENGINEER_1_OFFER_3.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_OFFER_3.get();
        }
    }
    public static String getHydraulicEngineer1Request3() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_REQUEST_3.get(), HYDRAULIC_ENGINEER_1_REQUEST_3.getDefault())) {
            return HYDRAULIC_ENGINEER_1_REQUEST_3.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_REQUEST_3.get();
        }
    }
    public static String getHydraulicEngineer1Offer2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_OFFER_2.get(), HYDRAULIC_ENGINEER_1_OFFER_2.getDefault())) {
            return HYDRAULIC_ENGINEER_1_OFFER_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_OFFER_2.get();
        }
    }
    public static String getHydraulicEngineer1Request2() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_REQUEST_2.get(), HYDRAULIC_ENGINEER_1_REQUEST_2.getDefault())) {
            return HYDRAULIC_ENGINEER_1_REQUEST_2.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_REQUEST_2.get();
        }
    }
    public static int getHydraulicEngineer1Offer1Count() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_OFFER_1_COUNT.get(), HYDRAULIC_ENGINEER_1_OFFER_1_COUNT.getDefault())) {
            return HYDRAULIC_ENGINEER_1_OFFER_1_COUNT.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_OFFER_1_COUNT.get();
        }
    }
    public static String getHydraulicEngineer1Offer1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_OFFER_1.get(), HYDRAULIC_ENGINEER_1_OFFER_1.getDefault())) {
            return HYDRAULIC_ENGINEER_1_OFFER_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_OFFER_1.get();
        }
    }
    public static String getHydraulicEngineer1Request1() {
        if (Objects.equals(HYDRAULIC_ENGINEER_1_REQUEST_1.get(), HYDRAULIC_ENGINEER_1_REQUEST_1.getDefault())) {
            return HYDRAULIC_ENGINEER_1_REQUEST_1.getDefault();
        }
        else {
            return HYDRAULIC_ENGINEER_1_REQUEST_1.get();
        }
    }
}