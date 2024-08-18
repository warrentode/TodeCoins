package com.github.warrentode.todecoins.config.trades.dynamicvillage;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MechanicalEngineerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // MechanicalEngineer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_1_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_1_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_1_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_1_OFFER_5_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MECHANICAL_ENGINEER_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> MECHANICAL_ENGINEER_5_OFFER_2_COUNT;

    static {
        // MECHANICAL ENGINEER TRADES
        BUILDER.push("Mechanical Engineer Trade Settings");
        // level 1
        BUILDER.push("Mechanical Engineer Level One Trade One");
        MECHANICAL_ENGINEER_1_REQUEST_1 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Request 1 Table")
                .define("mechanical_engineer_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_1_OFFER_1 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Offer 1 Table")
                .define("mechanical_engineer_1_trade_offer_1_table",
                        TradeLootTables.CREATE_INGOTS_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_1_OFFER_1_COUNT = BUILDER
                .defineInRange("mechanical_engineer_1_trade_offer_1_count", 3, 1, 64);
        BUILDER.pop();
        BUILDER.push("Mechanical Engineer Level One Trade TWo");
        MECHANICAL_ENGINEER_1_REQUEST_2 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Request 2 Table")
                .define("mechanical_engineer_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_1_OFFER_2 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Offer 2 Table")
                .define("mechanical_engineer_1_trade_offer_2_table",
                        TradeLootTables.ZINC_MATERIALS_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_1_OFFER_2_COUNT = BUILDER
                .defineInRange("mechanical_engineer_1_trade_offer_2_count", 4, 1, 64);
        BUILDER.pop();
        BUILDER.push("Mechanical Engineer Level One Trade Three");
        MECHANICAL_ENGINEER_1_REQUEST_3 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Request 3 Table")
                .define("mechanical_engineer_1_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_1_OFFER_3 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Offer 2 Table")
                .define("mechanical_engineer_1_trade_offer_2_table",
                        TradeLootTables.WRENCH_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_1_OFFER_3_COUNT = BUILDER
                .defineInRange("mechanical_engineer_1_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Mechanical Engineer Level One Trade Four");
        MECHANICAL_ENGINEER_1_REQUEST_4 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Request 4 Table")
                .define("mechanical_engineer_1_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_1_OFFER_4 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Offer 4 Table")
                .define("mechanical_engineer_1_trade_offer_4_table",
                        TradeLootTables.GOGGLES_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Mechanical Engineer Level One Trade Five");
        MECHANICAL_ENGINEER_1_REQUEST_5 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Request 5 Table")
                .define("mechanical_engineer_1_trade_request_5_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_1_OFFER_5 = BUILDER
                .comment(" Mechanical Engineer 1 Trade Offer 5 Table")
                .define("mechanical_engineer_1_trade_offer_5_table",
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_1_OFFER_5_COUNT = BUILDER
                .defineInRange("mechanical_engineer_1_trade_offer_5_count", 1, 1, 64);
        BUILDER.pop();
        // level 2
        BUILDER.push("Mechanical Engineer Level Two Trade One");
        MECHANICAL_ENGINEER_2_REQUEST_1 = BUILDER
                .comment(" Mechanical Engineer 2 Trade Request 1 Table")
                .define("mechanical_engineer_2_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_2_OFFER_1 = BUILDER
                .comment(" Mechanical Engineer 2 Trade Offer 1 Table")
                .define("mechanical_engineer_2_trade_offer_1_table",
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_2_OFFER_1_COUNT = BUILDER
                .defineInRange("mechanical_engineer_2_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Mechanical Engineer Level Two Trade TWo");
        MECHANICAL_ENGINEER_2_REQUEST_2 = BUILDER
                .comment(" Mechanical Engineer 2 Trade Request 2 Table")
                .define("mechanical_engineer_2_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_2_OFFER_2 = BUILDER
                .comment(" Mechanical Engineer 2 Trade Offer 2 Table")
                .define("mechanical_engineer_2_trade_offer_2_table",
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_2_OFFER_2_COUNT = BUILDER
                .defineInRange("mechanical_engineer_2_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 3
        BUILDER.push("Mechanical Engineer Level Three Trade One");
        MECHANICAL_ENGINEER_3_REQUEST_1 = BUILDER
                .comment(" Mechanical Engineer 3 Trade Request 1 Table")
                .define("mechanical_engineer_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_3_OFFER_1 = BUILDER
                .comment(" Mechanical Engineer 3 Trade Offer 1 Table")
                .define("mechanical_engineer_3_trade_offer_1_table",
                        TradeLootTables.ENGINEER_TOOLS_TABLE.toString());
        MECHANICAL_ENGINEER_3_OFFER_1_COUNT = BUILDER
                .defineInRange("mechanical_engineer_3_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Mechanical Engineer Level Three Trade TWo");
        MECHANICAL_ENGINEER_3_REQUEST_2 = BUILDER
                .comment(" Mechanical Engineer 3 Trade Request 2 Table")
                .define("mechanical_engineer_3_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_3_OFFER_2 = BUILDER
                .comment(" Mechanical Engineer 3 Trade Offer 2 Table")
                .define("mechanical_engineer_3_trade_offer_2_table",
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_3_OFFER_2_COUNT = BUILDER
                .defineInRange("mechanical_engineer_3_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 4
        BUILDER.push("Mechanical Engineer Level Four Trade One");
        MECHANICAL_ENGINEER_4_REQUEST_1 = BUILDER
                .comment(" Mechanical Engineer 4 Trade Request 1 Table")
                .define("mechanical_engineer_4_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_4_OFFER_1 = BUILDER
                .comment(" Mechanical Engineer 4 Trade Offer 1 Table")
                .define("mechanical_engineer_4_trade_offer_1_table",
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_4_OFFER_1_COUNT = BUILDER
                .defineInRange("mechanical_engineer_4_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Mechanical Engineer Level Four Trade TWo");
        MECHANICAL_ENGINEER_4_REQUEST_2 = BUILDER
                .comment(" Mechanical Engineer 4 Trade Request 2 Table")
                .define("mechanical_engineer_4_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_4_OFFER_2 = BUILDER
                .comment(" Mechanical Engineer 4 Trade Offer 2 Table")
                .define("mechanical_engineer_4_trade_offer_2_table",
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_4_OFFER_2_COUNT = BUILDER
                .defineInRange("mechanical_engineer_4_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 5
        BUILDER.push("Mechanical Engineer Level Five Trade One");
        MECHANICAL_ENGINEER_5_REQUEST_1 = BUILDER
                .comment(" Mechanical Engineer 5 Trade Request 1 Table")
                .define("mechanical_engineer_5_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_5_OFFER_1 = BUILDER
                .comment(" Mechanical Engineer 5 Trade Offer 1 Table")
                .define("mechanical_engineer_5_trade_offer_1_table",
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_5_OFFER_1_COUNT = BUILDER
                .defineInRange("mechanical_engineer_5_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Mechanical Engineer Level Five Trade TWo");
        MECHANICAL_ENGINEER_5_REQUEST_2 = BUILDER
                .comment(" Mechanical Engineer 5 Trade Request 2 Table")
                .define("mechanical_engineer_5_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        MECHANICAL_ENGINEER_5_OFFER_2 = BUILDER
                .comment(" Mechanical Engineer 5 Trade Offer 2 Table")
                .define("mechanical_engineer_5_trade_offer_2_table",
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE.toString());
        MECHANICAL_ENGINEER_5_OFFER_2_COUNT = BUILDER
                .defineInRange("mechanical_engineer_5_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // MECHANICAL_ENGINEER TRADE GETTERS
    public static int getMechanicalEngineer5Offer2Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_5_OFFER_2_COUNT.get(), MECHANICAL_ENGINEER_5_OFFER_2_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_5_OFFER_2_COUNT.get();
        }
    }
    public static String getMechanicalEngineer5Offer2() {
        if (Objects.equals(MECHANICAL_ENGINEER_5_OFFER_2.get(), MECHANICAL_ENGINEER_5_OFFER_2.getDefault())) {
            return MECHANICAL_ENGINEER_5_OFFER_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_5_OFFER_2.get();
        }
    }
    public static String getMechanicalEngineer5Request2() {
        if (Objects.equals(MECHANICAL_ENGINEER_5_REQUEST_2.get(), MECHANICAL_ENGINEER_5_REQUEST_2.getDefault())) {
            return MECHANICAL_ENGINEER_5_REQUEST_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_5_REQUEST_2.get();
        }
    }
    public static int getMechanicalEngineer5Offer1Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_5_OFFER_1_COUNT.get(), MECHANICAL_ENGINEER_5_OFFER_1_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_5_OFFER_1_COUNT.get();
        }
    }
    public static String getMechanicalEngineer5Offer1() {
        if (Objects.equals(MECHANICAL_ENGINEER_5_OFFER_1.get(), MECHANICAL_ENGINEER_5_OFFER_1.getDefault())) {
            return MECHANICAL_ENGINEER_5_OFFER_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_5_OFFER_1.get();
        }
    }
    public static String getMechanicalEngineer5Request1() {
        if (Objects.equals(MECHANICAL_ENGINEER_5_REQUEST_1.get(), MECHANICAL_ENGINEER_5_REQUEST_1.getDefault())) {
            return MECHANICAL_ENGINEER_5_REQUEST_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_5_REQUEST_1.get();
        }
    }
    public static int getMechanicalEngineer4Offer2Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_4_OFFER_2_COUNT.get(), MECHANICAL_ENGINEER_4_OFFER_2_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getMechanicalEngineer4Offer2() {
        if (Objects.equals(MECHANICAL_ENGINEER_4_OFFER_2.get(), MECHANICAL_ENGINEER_4_OFFER_2.getDefault())) {
            return MECHANICAL_ENGINEER_4_OFFER_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_4_OFFER_2.get();
        }
    }
    public static String getMechanicalEngineer4Request2() {
        if (Objects.equals(MECHANICAL_ENGINEER_4_REQUEST_2.get(), MECHANICAL_ENGINEER_4_REQUEST_2.getDefault())) {
            return MECHANICAL_ENGINEER_4_REQUEST_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_4_REQUEST_2.get();
        }
    }
    public static int getMechanicalEngineer4Offer1Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_4_OFFER_1_COUNT.get(), MECHANICAL_ENGINEER_4_OFFER_1_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_4_OFFER_1_COUNT.get();
        }
    }
    public static String getMechanicalEngineer4Offer1() {
        if (Objects.equals(MECHANICAL_ENGINEER_4_OFFER_1.get(), MECHANICAL_ENGINEER_4_OFFER_1.getDefault())) {
            return MECHANICAL_ENGINEER_4_OFFER_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_4_OFFER_1.get();
        }
    }
    public static String getMechanicalEngineer4Request1() {
        if (Objects.equals(MECHANICAL_ENGINEER_4_REQUEST_1.get(), MECHANICAL_ENGINEER_4_REQUEST_1.getDefault())) {
            return MECHANICAL_ENGINEER_4_REQUEST_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_4_REQUEST_1.get();
        }
    }
    public static int getMechanicalEngineer3Offer2Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_3_OFFER_2_COUNT.get(), MECHANICAL_ENGINEER_3_OFFER_2_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_3_OFFER_2_COUNT.get();
        }
    }
    public static String getMechanicalEngineer3Offer2() {
        if (Objects.equals(MECHANICAL_ENGINEER_3_OFFER_2.get(), MECHANICAL_ENGINEER_3_OFFER_2.getDefault())) {
            return MECHANICAL_ENGINEER_3_OFFER_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_3_OFFER_2.get();
        }
    }
    public static String getMechanicalEngineer3Request2() {
        if (Objects.equals(MECHANICAL_ENGINEER_3_REQUEST_2.get(), MECHANICAL_ENGINEER_3_REQUEST_2.getDefault())) {
            return MECHANICAL_ENGINEER_3_REQUEST_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_3_REQUEST_2.get();
        }
    }
    public static int getMechanicalEngineer3Offer1Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_3_OFFER_1_COUNT.get(), MECHANICAL_ENGINEER_3_OFFER_1_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_3_OFFER_1_COUNT.get();
        }
    }
    public static String getMechanicalEngineer3Offer1() {
        if (Objects.equals(MECHANICAL_ENGINEER_3_OFFER_1.get(), MECHANICAL_ENGINEER_3_OFFER_1.getDefault())) {
            return MECHANICAL_ENGINEER_3_OFFER_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_3_OFFER_1.get();
        }
    }
    public static String getMechanicalEngineer3Request1() {
        if (Objects.equals(MECHANICAL_ENGINEER_3_REQUEST_1.get(), MECHANICAL_ENGINEER_3_REQUEST_1.getDefault())) {
            return MECHANICAL_ENGINEER_3_REQUEST_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_3_REQUEST_1.get();
        }
    }
    public static int getMechanicalEngineer2Offer2Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_2_OFFER_2_COUNT.get(), MECHANICAL_ENGINEER_2_OFFER_2_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getMechanicalEngineer2Offer2() {
        if (Objects.equals(MECHANICAL_ENGINEER_2_OFFER_2.get(), MECHANICAL_ENGINEER_2_OFFER_2.getDefault())) {
            return MECHANICAL_ENGINEER_2_OFFER_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_2_OFFER_2.get();
        }
    }
    public static String getMechanicalEngineer2Request2() {
        if (Objects.equals(MECHANICAL_ENGINEER_2_REQUEST_2.get(), MECHANICAL_ENGINEER_2_REQUEST_2.getDefault())) {
            return MECHANICAL_ENGINEER_2_REQUEST_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_2_REQUEST_2.get();
        }
    }
    public static int getMechanicalEngineer2Offer1Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_2_OFFER_1_COUNT.get(), MECHANICAL_ENGINEER_2_OFFER_1_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_2_OFFER_1_COUNT.get();
        }
    }
    public static String getMechanicalEngineer2Offer1() {
        if (Objects.equals(MECHANICAL_ENGINEER_2_OFFER_1.get(), MECHANICAL_ENGINEER_2_OFFER_1.getDefault())) {
            return MECHANICAL_ENGINEER_2_OFFER_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_2_OFFER_1.get();
        }
    }
    public static String getMechanicalEngineer2Request1() {
        if (Objects.equals(MECHANICAL_ENGINEER_2_REQUEST_1.get(), MECHANICAL_ENGINEER_2_REQUEST_1.getDefault())) {
            return MECHANICAL_ENGINEER_2_REQUEST_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_2_REQUEST_1.get();
        }
    }
    public static int getMechanicalEngineer1Offer5Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_OFFER_5_COUNT.get(), MECHANICAL_ENGINEER_1_OFFER_5_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_1_OFFER_5_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_OFFER_5_COUNT.get();
        }
    }
    public static String getMechanicalEngineer1Offer5() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_OFFER_5.get(), MECHANICAL_ENGINEER_1_OFFER_5.getDefault())) {
            return MECHANICAL_ENGINEER_1_OFFER_5.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_OFFER_5.get();
        }
    }
    public static String getMechanicalEngineer1Request5() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_REQUEST_5.get(), MECHANICAL_ENGINEER_1_REQUEST_5.getDefault())) {
            return MECHANICAL_ENGINEER_1_REQUEST_5.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_REQUEST_5.get();
        }
    }
    public static String getMechanicalEngineer1Offer4() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_OFFER_4.get(), MECHANICAL_ENGINEER_1_OFFER_4.getDefault())) {
            return MECHANICAL_ENGINEER_1_OFFER_4.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_OFFER_4.get();
        }
    }
    public static String getMechanicalEngineer1Request4() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_REQUEST_4.get(), MECHANICAL_ENGINEER_1_REQUEST_4.getDefault())) {
            return MECHANICAL_ENGINEER_1_REQUEST_4.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_REQUEST_4.get();
        }
    }
    public static int getMechanicalEngineer1Offer3Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_OFFER_3_COUNT.get(), MECHANICAL_ENGINEER_1_OFFER_3_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_1_OFFER_3_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_OFFER_3_COUNT.get();
        }
    }
    public static String getMechanicalEngineer1Offer3() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_OFFER_3.get(), MECHANICAL_ENGINEER_1_OFFER_3.getDefault())) {
            return MECHANICAL_ENGINEER_1_OFFER_3.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_OFFER_3.get();
        }
    }
    public static String getMechanicalEngineer1Request3() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_REQUEST_3.get(), MECHANICAL_ENGINEER_1_REQUEST_3.getDefault())) {
            return MECHANICAL_ENGINEER_1_REQUEST_3.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_REQUEST_3.get();
        }
    }
    public static int getMechanicalEngineer1Offer2Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_OFFER_2_COUNT.get(), MECHANICAL_ENGINEER_1_OFFER_2_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_OFFER_2_COUNT.get();
        }
    }
    public static String getMechanicalEngineer1Offer2() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_OFFER_2.get(), MECHANICAL_ENGINEER_1_OFFER_2.getDefault())) {
            return MECHANICAL_ENGINEER_1_OFFER_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_OFFER_2.get();
        }
    }
    public static String getMechanicalEngineer1Request2() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_REQUEST_2.get(), MECHANICAL_ENGINEER_1_REQUEST_2.getDefault())) {
            return MECHANICAL_ENGINEER_1_REQUEST_2.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_REQUEST_2.get();
        }
    }
    public static int getMechanicalEngineer1Offer1Count() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_OFFER_1_COUNT.get(), MECHANICAL_ENGINEER_1_OFFER_1_COUNT.getDefault())) {
            return MECHANICAL_ENGINEER_1_OFFER_1_COUNT.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_OFFER_1_COUNT.get();
        }
    }
    public static String getMechanicalEngineer1Offer1() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_OFFER_1.get(), MECHANICAL_ENGINEER_1_OFFER_1.getDefault())) {
            return MECHANICAL_ENGINEER_1_OFFER_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_OFFER_1.get();
        }
    }
    public static String getMechanicalEngineer1Request1() {
        if (Objects.equals(MECHANICAL_ENGINEER_1_REQUEST_1.get(), MECHANICAL_ENGINEER_1_REQUEST_1.getDefault())) {
            return MECHANICAL_ENGINEER_1_REQUEST_1.getDefault();
        }
        else {
            return MECHANICAL_ENGINEER_1_REQUEST_1.get();
        }
    }
}