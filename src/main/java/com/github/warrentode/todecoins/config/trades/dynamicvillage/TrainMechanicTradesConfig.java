package com.github.warrentode.todecoins.config.trades.dynamicvillage;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrainMechanicTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Train Mechanic Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_1_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TRAIN_MECHANIC_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRAIN_MECHANIC_5_OFFER_2_COUNT;

    static {
        // TRAIN MECHANIC TRADES
        BUILDER.push("Train Mechanic Trade Settings");
        // level 1
        BUILDER.push("Train Mechanic Level One Trade One");
        TRAIN_MECHANIC_1_REQUEST_1 = BUILDER
                .comment(" Train Mechanic 1 Trade Request 1 Table")
                .define("train_mechanic_1_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_1_OFFER_1 = BUILDER
                .comment(" Train Mechanic 1 Trade Offer 1 Table")
                .define("train_mechanic_1_trade_offer_1_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_1_OFFER_1_COUNT = BUILDER
                .defineInRange("train_mechanic_1_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Train Mechanic Level One Trade TWo");
        TRAIN_MECHANIC_1_REQUEST_2 = BUILDER
                .comment(" Train Mechanic 1 Trade Request 2 Table")
                .define("train_mechanic_1_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_1_OFFER_2 = BUILDER
                .comment(" Train Mechanic 1 Trade Offer 2 Table")
                .define("train_mechanic_1_trade_offer_2_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_1_OFFER_2_COUNT = BUILDER
                .defineInRange("train_mechanic_1_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 2
        BUILDER.push("Train Mechanic Level Two Trade One");
        TRAIN_MECHANIC_2_REQUEST_1 = BUILDER
                .comment(" Train Mechanic 2 Trade Request 1 Table")
                .define("train_mechanic_2_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_2_OFFER_1 = BUILDER
                .comment(" Train Mechanic 2 Trade Offer 1 Table")
                .define("train_mechanic_2_trade_offer_1_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_2_OFFER_1_COUNT = BUILDER
                .defineInRange("train_mechanic_2_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Train Mechanic Level Two Trade TWo");
        TRAIN_MECHANIC_2_REQUEST_2 = BUILDER
                .comment(" Train Mechanic 2 Trade Request 2 Table")
                .define("train_mechanic_2_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_2_OFFER_2 = BUILDER
                .comment(" Train Mechanic 2 Trade Offer 2 Table")
                .define("train_mechanic_2_trade_offer_2_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_2_OFFER_2_COUNT = BUILDER
                .defineInRange("train_mechanic_2_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 3
        BUILDER.push("Train Mechanic Level Three Trade One");
        TRAIN_MECHANIC_3_REQUEST_1 = BUILDER
                .comment(" Train Mechanic 3 Trade Request 1 Table")
                .define("train_mechanic_3_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_3_OFFER_1 = BUILDER
                .comment(" Train Mechanic 3 Trade Offer 1 Table")
                .define("train_mechanic_3_trade_offer_1_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_3_OFFER_1_COUNT = BUILDER
                .defineInRange("train_mechanic_3_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Train Mechanic Level Three Trade TWo");
        TRAIN_MECHANIC_3_REQUEST_2 = BUILDER
                .comment(" Train Mechanic 3 Trade Request 2 Table")
                .define("train_mechanic_3_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_3_OFFER_2 = BUILDER
                .comment(" Train Mechanic 3 Trade Offer 2 Table")
                .define("train_mechanic_3_trade_offer_2_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_3_OFFER_2_COUNT = BUILDER
                .defineInRange("train_mechanic_3_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 4
        BUILDER.push("Train Mechanic Level Four Trade One");
        TRAIN_MECHANIC_4_REQUEST_1 = BUILDER
                .comment(" Train Mechanic 4 Trade Request 1 Table")
                .define("train_mechanic_4_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_4_OFFER_1 = BUILDER
                .comment(" Train Mechanic 4 Trade Offer 1 Table")
                .define("train_mechanic_4_trade_offer_1_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_4_OFFER_1_COUNT = BUILDER
                .defineInRange("train_mechanic_4_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Train Mechanic Level Four Trade TWo");
        TRAIN_MECHANIC_4_REQUEST_2 = BUILDER
                .comment(" Train Mechanic 4 Trade Request 2 Table")
                .define("train_mechanic_4_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_4_OFFER_2 = BUILDER
                .comment(" Train Mechanic 4 Trade Offer 2 Table")
                .define("train_mechanic_4_trade_offer_2_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_4_OFFER_2_COUNT = BUILDER
                .defineInRange("train_mechanic_4_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 5
        BUILDER.push("Train Mechanic Level Five Trade One");
        TRAIN_MECHANIC_5_REQUEST_1 = BUILDER
                .comment(" Train Mechanic 5 Trade Request 1 Table")
                .define("train_mechanic_5_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_5_OFFER_1 = BUILDER
                .comment(" Train Mechanic 5 Trade Offer 1 Table")
                .define("train_mechanic_5_trade_offer_1_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_5_OFFER_1_COUNT = BUILDER
                .defineInRange("train_mechanic_5_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Train Mechanic Level Five Trade TWo");
        TRAIN_MECHANIC_5_REQUEST_2 = BUILDER
                .comment(" Train Mechanic 5 Trade Request 2 Table")
                .define("train_mechanic_5_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        TRAIN_MECHANIC_5_OFFER_2 = BUILDER
                .comment(" Train Mechanic 5 Trade Offer 2 Table")
                .define("train_mechanic_5_trade_offer_2_table",
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE.toString());
        TRAIN_MECHANIC_5_OFFER_2_COUNT = BUILDER
                .defineInRange("train_mechanic_5_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // TRAIN_MECHANIC TRADE GETTERS
    public static int getTrainMechanic5Offer2Count() {
        if (Objects.equals(TRAIN_MECHANIC_5_OFFER_2_COUNT.get(), TRAIN_MECHANIC_5_OFFER_2_COUNT.getDefault())) {
            return TRAIN_MECHANIC_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_5_OFFER_2_COUNT.get();
        }
    }
    public static String getTrainMechanic5Offer2() {
        if (Objects.equals(TRAIN_MECHANIC_5_OFFER_2.get(), TRAIN_MECHANIC_5_OFFER_2.getDefault())) {
            return TRAIN_MECHANIC_5_OFFER_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_5_OFFER_2.get();
        }
    }
    public static String getTrainMechanic5Request2() {
        if (Objects.equals(TRAIN_MECHANIC_5_REQUEST_2.get(), TRAIN_MECHANIC_5_REQUEST_2.getDefault())) {
            return TRAIN_MECHANIC_5_REQUEST_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_5_REQUEST_2.get();
        }
    }
    public static int getTrainMechanic5Offer1Count() {
        if (Objects.equals(TRAIN_MECHANIC_5_OFFER_1_COUNT.get(), TRAIN_MECHANIC_5_OFFER_1_COUNT.getDefault())) {
            return TRAIN_MECHANIC_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_5_OFFER_1_COUNT.get();
        }
    }
    public static String getTrainMechanic5Offer1() {
        if (Objects.equals(TRAIN_MECHANIC_5_OFFER_1.get(), TRAIN_MECHANIC_5_OFFER_1.getDefault())) {
            return TRAIN_MECHANIC_5_OFFER_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_5_OFFER_1.get();
        }
    }
    public static String getTrainMechanic5Request1() {
        if (Objects.equals(TRAIN_MECHANIC_5_REQUEST_1.get(), TRAIN_MECHANIC_5_REQUEST_1.getDefault())) {
            return TRAIN_MECHANIC_5_REQUEST_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_5_REQUEST_1.get();
        }
    }
    public static int getTrainMechanic4Offer2Count() {
        if (Objects.equals(TRAIN_MECHANIC_4_OFFER_2_COUNT.get(), TRAIN_MECHANIC_4_OFFER_2_COUNT.getDefault())) {
            return TRAIN_MECHANIC_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_4_OFFER_2_COUNT.get();
        }
    }
    public static String getTrainMechanic4Offer2() {
        if (Objects.equals(TRAIN_MECHANIC_4_OFFER_2.get(), TRAIN_MECHANIC_4_OFFER_2.getDefault())) {
            return TRAIN_MECHANIC_4_OFFER_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_4_OFFER_2.get();
        }
    }
    public static String getTrainMechanic4Request2() {
        if (Objects.equals(TRAIN_MECHANIC_4_REQUEST_2.get(), TRAIN_MECHANIC_4_REQUEST_2.getDefault())) {
            return TRAIN_MECHANIC_4_REQUEST_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_4_REQUEST_2.get();
        }
    }
    public static int getTrainMechanic4Offer1Count() {
        if (Objects.equals(TRAIN_MECHANIC_4_OFFER_1_COUNT.get(), TRAIN_MECHANIC_4_OFFER_1_COUNT.getDefault())) {
            return TRAIN_MECHANIC_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_4_OFFER_1_COUNT.get();
        }
    }
    public static String getTrainMechanic4Offer1() {
        if (Objects.equals(TRAIN_MECHANIC_4_OFFER_1.get(), TRAIN_MECHANIC_4_OFFER_1.getDefault())) {
            return TRAIN_MECHANIC_4_OFFER_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_4_OFFER_1.get();
        }
    }
    public static String getTrainMechanic4Request1() {
        if (Objects.equals(TRAIN_MECHANIC_4_REQUEST_1.get(), TRAIN_MECHANIC_4_REQUEST_1.getDefault())) {
            return TRAIN_MECHANIC_4_REQUEST_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_4_REQUEST_1.get();
        }
    }
    public static int getTrainMechanic3Offer2Count() {
        if (Objects.equals(TRAIN_MECHANIC_3_OFFER_2_COUNT.get(), TRAIN_MECHANIC_3_OFFER_2_COUNT.getDefault())) {
            return TRAIN_MECHANIC_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_3_OFFER_2_COUNT.get();
        }
    }
    public static String getTrainMechanic3Offer2() {
        if (Objects.equals(TRAIN_MECHANIC_3_OFFER_2.get(), TRAIN_MECHANIC_3_OFFER_2.getDefault())) {
            return TRAIN_MECHANIC_3_OFFER_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_3_OFFER_2.get();
        }
    }
    public static String getTrainMechanic3Request2() {
        if (Objects.equals(TRAIN_MECHANIC_3_REQUEST_2.get(), TRAIN_MECHANIC_3_REQUEST_2.getDefault())) {
            return TRAIN_MECHANIC_3_REQUEST_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_3_REQUEST_2.get();
        }
    }
    public static int getTrainMechanic3Offer1Count() {
        if (Objects.equals(TRAIN_MECHANIC_3_OFFER_1_COUNT.get(), TRAIN_MECHANIC_3_OFFER_1_COUNT.getDefault())) {
            return TRAIN_MECHANIC_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_3_OFFER_1_COUNT.get();
        }
    }
    public static String getTrainMechanic3Offer1() {
        if (Objects.equals(TRAIN_MECHANIC_3_OFFER_1.get(), TRAIN_MECHANIC_3_OFFER_1.getDefault())) {
            return TRAIN_MECHANIC_3_OFFER_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_3_OFFER_1.get();
        }
    }
    public static String getTrainMechanic3Request1() {
        if (Objects.equals(TRAIN_MECHANIC_3_REQUEST_1.get(), TRAIN_MECHANIC_3_REQUEST_1.getDefault())) {
            return TRAIN_MECHANIC_3_REQUEST_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_3_REQUEST_1.get();
        }
    }
    public static int getTrainMechanic2Offer2Count() {
        if (Objects.equals(TRAIN_MECHANIC_2_OFFER_2_COUNT.get(), TRAIN_MECHANIC_2_OFFER_2_COUNT.getDefault())) {
            return TRAIN_MECHANIC_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_2_OFFER_2_COUNT.get();
        }
    }
    public static String getTrainMechanic2Offer2() {
        if (Objects.equals(TRAIN_MECHANIC_2_OFFER_2.get(), TRAIN_MECHANIC_2_OFFER_2.getDefault())) {
            return TRAIN_MECHANIC_2_OFFER_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_2_OFFER_2.get();
        }
    }
    public static String getTrainMechanic2Request2() {
        if (Objects.equals(TRAIN_MECHANIC_2_REQUEST_2.get(), TRAIN_MECHANIC_2_REQUEST_2.getDefault())) {
            return TRAIN_MECHANIC_2_REQUEST_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_2_REQUEST_2.get();
        }
    }
    public static int getTrainMechanic2Offer1Count() {
        if (Objects.equals(TRAIN_MECHANIC_2_OFFER_1_COUNT.get(), TRAIN_MECHANIC_2_OFFER_1_COUNT.getDefault())) {
            return TRAIN_MECHANIC_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_2_OFFER_1_COUNT.get();
        }
    }
    public static String getTrainMechanic2Offer1() {
        if (Objects.equals(TRAIN_MECHANIC_2_OFFER_1.get(), TRAIN_MECHANIC_2_OFFER_1.getDefault())) {
            return TRAIN_MECHANIC_2_OFFER_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_2_OFFER_1.get();
        }
    }
    public static String getTrainMechanic2Request1() {
        if (Objects.equals(TRAIN_MECHANIC_2_REQUEST_1.get(), TRAIN_MECHANIC_2_REQUEST_1.getDefault())) {
            return TRAIN_MECHANIC_2_REQUEST_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_2_REQUEST_1.get();
        }
    }
    public static int getTrainMechanic1Offer2Count() {
        if (Objects.equals(TRAIN_MECHANIC_1_OFFER_2_COUNT.get(), TRAIN_MECHANIC_1_OFFER_2_COUNT.getDefault())) {
            return TRAIN_MECHANIC_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_1_OFFER_2_COUNT.get();
        }
    }
    public static String getTrainMechanic1Offer2() {
        if (Objects.equals(TRAIN_MECHANIC_1_OFFER_2.get(), TRAIN_MECHANIC_1_OFFER_2.getDefault())) {
            return TRAIN_MECHANIC_1_OFFER_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_1_OFFER_2.get();
        }
    }
    public static String getTrainMechanic1Request2() {
        if (Objects.equals(TRAIN_MECHANIC_1_REQUEST_2.get(), TRAIN_MECHANIC_1_REQUEST_2.getDefault())) {
            return TRAIN_MECHANIC_1_REQUEST_2.getDefault();
        }
        else {
            return TRAIN_MECHANIC_1_REQUEST_2.get();
        }
    }
    public static int getTrainMechanic1Offer1Count() {
        if (Objects.equals(TRAIN_MECHANIC_1_OFFER_1_COUNT.get(), TRAIN_MECHANIC_1_OFFER_1_COUNT.getDefault())) {
            return TRAIN_MECHANIC_1_OFFER_1_COUNT.getDefault();
        }
        else {
            return TRAIN_MECHANIC_1_OFFER_1_COUNT.get();
        }
    }
    public static String getTrainMechanic1Offer1() {
        if (Objects.equals(TRAIN_MECHANIC_1_OFFER_1.get(), TRAIN_MECHANIC_1_OFFER_1.getDefault())) {
            return TRAIN_MECHANIC_1_OFFER_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_1_OFFER_1.get();
        }
    }
    public static String getTrainMechanic1Request1() {
        if (Objects.equals(TRAIN_MECHANIC_1_REQUEST_1.get(), TRAIN_MECHANIC_1_REQUEST_1.getDefault())) {
            return TRAIN_MECHANIC_1_REQUEST_1.getDefault();
        }
        else {
            return TRAIN_MECHANIC_1_REQUEST_1.get();
        }
    }
}