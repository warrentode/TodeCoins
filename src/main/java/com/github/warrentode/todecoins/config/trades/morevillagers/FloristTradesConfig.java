package com.github.warrentode.todecoins.config.trades.morevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FloristTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Florist Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLORIST_5_OFFER_2;

    static {
        // FLORIST TRADES
        BUILDER.push(" Florist Trade Settings");
        // level 1
        BUILDER.push(" Florist Level One Trade One");
        FLORIST_1_REQUEST_1 = BUILDER
                .comment(" Florist 1 Trade Request 1 Table")
                .define("florist_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FLORIST_1_OFFER_1 = BUILDER
                .comment(" Florist 1 Trade Offer 1 Table")
                .define("florist_1_trade_offer_1_table",
                        TradeLootTables.FLOWER_POT_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Florist Level One Trade Two");
        FLORIST_1_REQUEST_2 = BUILDER
                .comment(" Florist 1 Trade Request 2 Table")
                .define("florist_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FLORIST_1_OFFER_2 = BUILDER
                .comment(" Florist 1 Trade Offer 2 Table")
                .define("florist_1_trade_offer_2_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push(" Florist Level Two Trade One");
        FLORIST_2_REQUEST_1 = BUILDER
                .comment(" Florist 2 Trade Request 1 Table")
                .define("florist_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FLORIST_2_OFFER_1 = BUILDER
                .comment(" Florist 2 Trade Offer 1 Table")
                .define("florist_2_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Florist Level Two Trade Two");
        FLORIST_2_REQUEST_2 = BUILDER
                .comment(" Florist 2 Trade Request 2 Table")
                .define("florist_2_trade_request_2_table",
                        TradeLootTables.FLOWER_BUY_TABLE.toString());
        FLORIST_2_OFFER_2 = BUILDER
                .comment(" Florist 2 Trade Offer 2 Table")
                .define("florist_2_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push(" Florist Level Three Trade One");
        FLORIST_3_REQUEST_1 = BUILDER
                .comment(" Florist 3 Trade Request 1 Table")
                .define("florist_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FLORIST_3_OFFER_1 = BUILDER
                .comment(" Florist 3 Trade Offer 1 Table")
                .define("florist_3_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Florist Level Three Trade Two");
        FLORIST_3_REQUEST_2 = BUILDER
                .comment(" Florist 3 Trade Request 2 Table")
                .define("florist_3_trade_request_2_table",
                        TradeLootTables.FLOWER_BUY_TABLE.toString());
        FLORIST_3_OFFER_2 = BUILDER
                .comment(" Florist 3 Trade Offer 2 Table")
                .define("florist_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push(" Florist Level Four Trade One");
        FLORIST_4_REQUEST_1 = BUILDER
                .comment(" Florist 4 Trade Request 1 Table")
                .define("florist_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FLORIST_4_OFFER_1 = BUILDER
                .comment(" Florist 4 Trade Offer 1 Table")
                .define("florist_4_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Florist Level Four Trade Two");
        FLORIST_4_REQUEST_2 = BUILDER
                .comment(" Florist 4 Trade Request 2 Table")
                .define("florist_4_trade_request_2_table",
                        TradeLootTables.FLOWER_BUY_TABLE.toString());
        FLORIST_4_OFFER_2 = BUILDER
                .comment(" Florist 4 Trade Offer 2 Table")
                .define("florist_4_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push(" Florist Level Five Trade One");
        FLORIST_5_REQUEST_1 = BUILDER
                .comment(" Florist 5 Trade Request 1 Table")
                .define("florist_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FLORIST_5_OFFER_1 = BUILDER
                .comment(" Florist 5 Trade Offer 1 Table")
                .define("florist_5_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Florist Level Five Trade Two");
        FLORIST_5_REQUEST_2 = BUILDER
                .comment(" Florist 5 Trade Request 2 Table")
                .define("florist_5_trade_request_2_table",
                        TradeLootTables.FLINT_BUY_TABLE.toString());
        FLORIST_5_OFFER_2 = BUILDER
                .comment(" Florist 5 Trade Offer 2 Table")
                .define("florist_5_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // FLORIST TRADE GETTERS
    public static String getFlorist5Offer2() {
        if (Objects.equals(FLORIST_5_OFFER_2.get(), FLORIST_5_OFFER_2.getDefault())) {
            return FLORIST_5_OFFER_2.getDefault();
        }
        else {
            return FLORIST_5_OFFER_2.get();
        }
    }
    public static String getFlorist5Request2() {
        if (Objects.equals(FLORIST_5_REQUEST_2.get(), FLORIST_5_REQUEST_2.getDefault())) {
            return FLORIST_5_REQUEST_2.getDefault();
        }
        else {
            return FLORIST_5_REQUEST_2.get();
        }
    }
    public static String getFlorist5Offer1() {
        if (Objects.equals(FLORIST_5_OFFER_1.get(), FLORIST_5_OFFER_1.getDefault())) {
            return FLORIST_5_OFFER_1.getDefault();
        }
        else {
            return FLORIST_5_OFFER_1.get();
        }
    }
    public static String getFlorist5Request1() {
        if (Objects.equals(FLORIST_5_REQUEST_1.get(), FLORIST_5_REQUEST_1.getDefault())) {
            return FLORIST_5_REQUEST_1.getDefault();
        }
        else {
            return FLORIST_5_REQUEST_1.get();
        }
    }
    public static String getFlorist4Offer2() {
        if (Objects.equals(FLORIST_4_OFFER_2.get(), FLORIST_4_OFFER_2.getDefault())) {
            return FLORIST_4_OFFER_2.getDefault();
        }
        else {
            return FLORIST_4_OFFER_2.get();
        }
    }
    public static String getFlorist4Request2() {
        if (Objects.equals(FLORIST_4_REQUEST_2.get(), FLORIST_4_REQUEST_2.getDefault())) {
            return FLORIST_4_REQUEST_2.getDefault();
        }
        else {
            return FLORIST_4_REQUEST_2.get();
        }
    }
    public static String getFlorist4Offer1() {
        if (Objects.equals(FLORIST_4_OFFER_1.get(), FLORIST_4_OFFER_1.getDefault())) {
            return FLORIST_4_OFFER_1.getDefault();
        }
        else {
            return FLORIST_4_OFFER_1.get();
        }
    }
    public static String getFlorist4Request1() {
        if (Objects.equals(FLORIST_4_REQUEST_1.get(), FLORIST_4_REQUEST_1.getDefault())) {
            return FLORIST_4_REQUEST_1.getDefault();
        }
        else {
            return FLORIST_4_REQUEST_1.get();
        }
    }
    public static String getFlorist3Offer2() {
        if (Objects.equals(FLORIST_3_OFFER_2.get(), FLORIST_3_OFFER_2.getDefault())) {
            return FLORIST_3_OFFER_2.getDefault();
        }
        else {
            return FLORIST_3_OFFER_2.get();
        }
    }
    public static String getFlorist3Request2() {
        if (Objects.equals(FLORIST_3_REQUEST_2.get(), FLORIST_3_REQUEST_2.getDefault())) {
            return FLORIST_3_REQUEST_2.getDefault();
        }
        else {
            return FLORIST_3_REQUEST_2.get();
        }
    }
    public static String getFlorist3Offer1() {
        if (Objects.equals(FLORIST_3_OFFER_1.get(), FLORIST_3_OFFER_1.getDefault())) {
            return FLORIST_3_OFFER_1.getDefault();
        }
        else {
            return FLORIST_3_OFFER_1.get();
        }
    }
    public static String getFlorist3Request1() {
        if (Objects.equals(FLORIST_3_REQUEST_1.get(), FLORIST_3_REQUEST_1.getDefault())) {
            return FLORIST_3_REQUEST_1.getDefault();
        }
        else {
            return FLORIST_3_REQUEST_1.get();
        }
    }
    public static String getFlorist2Offer2() {
        if (Objects.equals(FLORIST_2_OFFER_2.get(), FLORIST_2_OFFER_2.getDefault())) {
            return FLORIST_2_OFFER_2.getDefault();
        }
        else {
            return FLORIST_2_OFFER_2.get();
        }
    }
    public static String getFlorist2Request2() {
        if (Objects.equals(FLORIST_2_REQUEST_2.get(), FLORIST_2_REQUEST_2.getDefault())) {
            return FLORIST_2_REQUEST_2.getDefault();
        }
        else {
            return FLORIST_2_REQUEST_2.get();
        }
    }
    public static String getFlorist2Offer1() {
        if (Objects.equals(FLORIST_2_OFFER_1.get(), FLORIST_2_OFFER_1.getDefault())) {
            return FLORIST_2_OFFER_1.getDefault();
        }
        else {
            return FLORIST_2_OFFER_1.get();
        }
    }
    public static String getFlorist2Request1() {
        if (Objects.equals(FLORIST_2_REQUEST_1.get(), FLORIST_2_REQUEST_1.getDefault())) {
            return FLORIST_2_REQUEST_1.getDefault();
        }
        else {
            return FLORIST_2_REQUEST_1.get();
        }
    }
    public static String getFlorist1Offer2() {
        if (Objects.equals(FLORIST_1_OFFER_2.get(), FLORIST_1_OFFER_2.getDefault())) {
            return FLORIST_1_OFFER_2.getDefault();
        }
        else {
            return FLORIST_1_OFFER_2.get();
        }
    }
    public static String getFlorist1Request2() {
        if (Objects.equals(FLORIST_1_REQUEST_2.get(), FLORIST_1_REQUEST_2.getDefault())) {
            return FLORIST_1_REQUEST_2.getDefault();
        }
        else {
            return FLORIST_1_REQUEST_2.get();
        }
    }
    public static String getFlorist1Offer1() {
        if (Objects.equals(FLORIST_1_OFFER_1.get(), FLORIST_1_OFFER_1.getDefault())) {
            return FLORIST_1_OFFER_1.getDefault();
        }
        else {
            return FLORIST_1_OFFER_1.get();
        }
    }
    public static String getFlorist1Request1() {
        if (Objects.equals(FLORIST_1_REQUEST_1.get(), FLORIST_1_REQUEST_1.getDefault())) {
            return FLORIST_1_REQUEST_1.getDefault();
        }
        else {
            return FLORIST_1_REQUEST_1.get();
        }
    }
}