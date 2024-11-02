package com.github.warrentode.todecoins.config.trades.villagersplus;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorticulturistTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Horticulturist Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_2;

    static {
        // HORTICULTURIST TRADES
        BUILDER.push("Horticulturist Trade Settings");
        // level 1
        BUILDER.push("Horticulturist Level One Trade One");
        HORTICULTURIST_1_REQUEST_1 = BUILDER
                .comment(" Horticulturist 1 Trade Request 1 Table")
                .define("horticulturist_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_1 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 1 Table")
                .define("horticulturist_1_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level One Trade TWo");
        HORTICULTURIST_1_REQUEST_2 = BUILDER
                .comment(" Horticulturist 1 Trade Request 2 Table")
                .define("horticulturist_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_2 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 2 Table")
                .define("horticulturist_1_trade_offer_2_table",
                        TradeLootTables.SEED_TAG_TABLE.toString());
        HORTICULTURIST_1_OFFER_2_COUNT = BUILDER
                .defineInRange("horticulturist_1_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 2
        BUILDER.push("Horticulturist Level Two Trade One");
        HORTICULTURIST_2_REQUEST_1 = BUILDER
                .comment(" Horticulturist 2 Trade Request 1 Table")
                .define("horticulturist_2_trade_request_1_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_1 = BUILDER
                .comment(" Horticulturist 2 Trade Offer 1 Table")
                .define("horticulturist_2_trade_offer_1_table",
                        TradeLootTables.LEAVES_TAG_TABLE.toString());
        HORTICULTURIST_2_OFFER_1_COUNT = BUILDER
                .defineInRange("horticulturist_2_trade_offer_1_count", 2, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Two Trade Two");
        HORTICULTURIST_2_REQUEST_2 = BUILDER
                .comment(" Horticulturist 2 Trade Request 2 Table")
                .define("horticulturist_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_2 = BUILDER
                .comment(" Horticulturist 2 Trade Offer 2 Table")
                .define("horticulturist_2_trade_offer_2_table",
                        TradeLootTables.DECOR_PLANTS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Horticulturist Level Three Trade One");
        HORTICULTURIST_3_REQUEST_1 = BUILDER
                .comment(" Horticulturist 3 Trade Request 1 Table")
                .define("horticulturist_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_1 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 1 Table")
                .define("horticulturist_1_trade_offer_1_table",
                        TradeLootTables.FLOWER_POT_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Three Trade Two");
        HORTICULTURIST_3_REQUEST_2 = BUILDER
                .comment(" Horticulturist 3 Trade Request 2 Table")
                .define("horticulturist_3_trade_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_2 = BUILDER
                .comment(" Horticulturist 3 Trade Offer 2 Table")
                .define("horticulturist_3_trade_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Horticulturist Level Four Trade One");
        HORTICULTURIST_4_REQUEST_1 = BUILDER
                .comment(" Horticulturist 4 Trade Request 1 Table")
                .define("horticulturist_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_1 = BUILDER
                .comment(" Horticulturist 4 Trade Offer 1 Table")
                .define("horticulturist_4_trade_offer_1_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Four Trade Two");
        HORTICULTURIST_4_REQUEST_2 = BUILDER
                .comment(" Horticulturist 4 Trade Request 2 Table")
                .define("horticulturist_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_2 = BUILDER
                .comment(" Horticulturist 4 Trade Offer 2 Table")
                .define("horticulturist_4_trade_offer_2_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Horticulturist Level Five Trade One");
        HORTICULTURIST_5_REQUEST_1 = BUILDER
                .comment(" Horticulturist 5 Trade Request 1 Table")
                .define("horticulturist_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_1 = BUILDER
                .comment(" Horticulturist 5 Trade Offer 1 Table")
                .define("horticulturist_5_trade_offer_1_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Five Trade Two");
        HORTICULTURIST_5_REQUEST_2 = BUILDER
                .comment(" Horticulturist 5 Trade Request 2 Table")
                .define("horticulturist_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_2 = BUILDER
                .comment(" Horticulturist 5 Trade Offer 2 Table")
                .define("horticulturist_5_trade_offer_2_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // HORTICULTURIST TRADE GETTERS
    public static String getHorticulturist5Offer2() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_2.get(), HORTICULTURIST_5_OFFER_2.getDefault())) {
            return HORTICULTURIST_5_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_2.get();
        }
    }
    public static String getHorticulturist5Request2() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_2.get(), HORTICULTURIST_5_REQUEST_2.getDefault())) {
            return HORTICULTURIST_5_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_2.get();
        }
    }
    public static String getHorticulturist5Offer1() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_1.get(), HORTICULTURIST_5_OFFER_1.getDefault())) {
            return HORTICULTURIST_5_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_1.get();
        }
    }
    public static String getHorticulturist5Request1() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_1.get(), HORTICULTURIST_5_REQUEST_1.getDefault())) {
            return HORTICULTURIST_5_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_1.get();
        }
    }
    public static String getHorticulturist4Offer2() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_2.get(), HORTICULTURIST_4_OFFER_2.getDefault())) {
            return HORTICULTURIST_4_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_2.get();
        }
    }
    public static String getHorticulturist4Request2() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_2.get(), HORTICULTURIST_4_REQUEST_2.getDefault())) {
            return HORTICULTURIST_4_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_2.get();
        }
    }
    public static String getHorticulturist4Offer1() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_1.get(), HORTICULTURIST_4_OFFER_1.getDefault())) {
            return HORTICULTURIST_4_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_1.get();
        }
    }
    public static String getHorticulturist4Request1() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_1.get(), HORTICULTURIST_4_REQUEST_1.getDefault())) {
            return HORTICULTURIST_4_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_1.get();
        }
    }
    public static String getHorticulturist3Offer2() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_2.get(), HORTICULTURIST_3_OFFER_2.getDefault())) {
            return HORTICULTURIST_3_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_2.get();
        }
    }
    public static String getHorticulturist3Request2() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_2.get(), HORTICULTURIST_3_REQUEST_2.getDefault())) {
            return HORTICULTURIST_3_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_2.get();
        }
    }
    public static String getHorticulturist3Offer1() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_1.get(), HORTICULTURIST_3_OFFER_1.getDefault())) {
            return HORTICULTURIST_3_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_1.get();
        }
    }
    public static String getHorticulturist3Request1() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_1.get(), HORTICULTURIST_3_REQUEST_1.getDefault())) {
            return HORTICULTURIST_3_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_1.get();
        }
    }
    public static String getHorticulturist2Offer2() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_2.get(), HORTICULTURIST_2_OFFER_2.getDefault())) {
            return HORTICULTURIST_2_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_2.get();
        }
    }
    public static String getHorticulturist2Request2() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_2.get(), HORTICULTURIST_2_REQUEST_2.getDefault())) {
            return HORTICULTURIST_2_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_2.get();
        }
    }
    public static int getHorticulturist2Offer1Count() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_1_COUNT.get(), HORTICULTURIST_2_OFFER_1_COUNT.getDefault())) {
            return HORTICULTURIST_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_1_COUNT.get();
        }
    }
    public static String getHorticulturist2Offer1() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_1.get(), HORTICULTURIST_2_OFFER_1.getDefault())) {
            return HORTICULTURIST_2_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_1.get();
        }
    }
    public static String getHorticulturist2Request1() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_1.get(), HORTICULTURIST_2_REQUEST_1.getDefault())) {
            return HORTICULTURIST_2_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_1.get();
        }
    }
    public static int getHorticulturist1Offer2Count() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_2_COUNT.get(), HORTICULTURIST_1_OFFER_2_COUNT.getDefault())) {
            return HORTICULTURIST_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_2_COUNT.get();
        }
    }
    public static String getHorticulturist1Offer2() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_2.get(), HORTICULTURIST_1_OFFER_2.getDefault())) {
            return HORTICULTURIST_1_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_2.get();
        }
    }
    public static String getHorticulturist1Request2() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_2.get(), HORTICULTURIST_1_REQUEST_2.getDefault())) {
            return HORTICULTURIST_1_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_2.get();
        }
    }
    public static String getHorticulturist1Offer1() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_1.get(), HORTICULTURIST_1_OFFER_1.getDefault())) {
            return HORTICULTURIST_1_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_1.get();
        }
    }
    public static String getHorticulturist1Request1() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_1.get(), HORTICULTURIST_1_REQUEST_1.getDefault())) {
            return HORTICULTURIST_1_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_1.get();
        }
    }
}