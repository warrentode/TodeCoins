package com.github.warrentode.todecoins.config.trades.morevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HunterTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Hunter Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HUNTER_5_OFFER_2;

    static {
        // HUNTER TRADES
        BUILDER.push(" Hunter Trade Settings");
        // level 1
        BUILDER.push(" Hunter Level One Trade One");
        HUNTER_1_REQUEST_1 = BUILDER
                .comment(" Hunter 1 Trade Request 1 Table")
                .define("hunter_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        HUNTER_1_OFFER_1 = BUILDER
                .comment(" Hunter 1 Trade Offer 1 Table")
                .define("hunter_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Hunter Level One Trade Two");
        HUNTER_1_REQUEST_2 = BUILDER
                .comment(" Hunter 1 Trade Request 2 Table")
                .define("hunter_1_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        HUNTER_1_OFFER_2 = BUILDER
                .comment(" Hunter 1 Trade Offer 2 Table")
                .define("hunter_1_trade_offer_2_table",
                        TradeLootTables.SLIMEBALL_TAG_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push(" Hunter Level Two Trade One");
        HUNTER_2_REQUEST_1 = BUILDER
                .comment(" Hunter 2 Trade Request 1 Table")
                .define("hunter_2_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        HUNTER_2_OFFER_1 = BUILDER
                .comment(" Hunter 2 Trade Offer 1 Table")
                .define("hunter_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Hunter Level Two Trade Two");
        HUNTER_2_REQUEST_2 = BUILDER
                .comment(" Hunter 2 Trade Request 2 Table")
                .define("hunter_2_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        HUNTER_2_OFFER_2 = BUILDER
                .comment(" Hunter 2 Trade Offer 2 Table")
                .define("hunter_2_trade_offer_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push(" Hunter Level Three Trade One");
        HUNTER_3_REQUEST_1 = BUILDER
                .comment(" Hunter 3 Trade Request 1 Table")
                .define("hunter_3_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        HUNTER_3_OFFER_1 = BUILDER
                .comment(" Hunter 3 Trade Offer 1 Table")
                .define("hunter_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Hunter Level Three Trade Two");
        HUNTER_3_REQUEST_2 = BUILDER
                .comment(" Hunter 3 Trade Request 2 Table")
                .define("hunter_3_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        HUNTER_3_OFFER_2 = BUILDER
                .comment(" Hunter 3 Trade Offer 2 Table")
                .define("hunter_3_trade_offer_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push(" Hunter Level Four Trade One");
        HUNTER_4_REQUEST_1 = BUILDER
                .comment(" Hunter 4 Trade Request 1 Table")
                .define("hunter_4_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        HUNTER_4_OFFER_1 = BUILDER
                .comment(" Hunter 4 Trade Offer 1 Table")
                .define("hunter_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push(" Hunter Level Four Trade Two");
        HUNTER_4_REQUEST_2 = BUILDER
                .comment(" Hunter 4 Trade Request 2 Table")
                .define("hunter_4_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        HUNTER_4_OFFER_2 = BUILDER
                .comment(" Hunter 4 Trade Offer 2 Table")
                .define("hunter_4_trade_offer_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push(" Hunter Level Five Trade One");
        HUNTER_5_REQUEST_1 = BUILDER
                .comment(" Hunter 5 Trade Request 1 Table")
                .define("hunter_5_trade_request_1_table",
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY.toString());
        HUNTER_5_OFFER_1 = BUILDER
                .comment(" Hunter 5 Trade Offer 1 Table")
                .define("hunter_5_trade_offer_1_table",
                        TradeLootTables.TEN_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Hunter Level Five Trade Two");
        HUNTER_5_REQUEST_2 = BUILDER
                .comment(" Hunter 5 Trade Request 2 Table")
                .define("hunter_5_trade_request_2_table",
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY.toString());
        HUNTER_5_OFFER_2 = BUILDER
                .comment(" Hunter 5 Trade Offer 2 Table")
                .define("hunter_5_trade_offer_2_table",
                        TradeLootTables.TEN_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // HUNTER TRADE GETTERS
    public static String getHunter5Offer2() {
        if (Objects.equals(HUNTER_5_OFFER_2.get(), HUNTER_5_OFFER_2.getDefault())) {
            return HUNTER_5_OFFER_2.getDefault();
        }
        else {
            return HUNTER_5_OFFER_2.get();
        }
    }
    public static String getHunter5Request2() {
        if (Objects.equals(HUNTER_5_REQUEST_2.get(), HUNTER_5_REQUEST_2.getDefault())) {
            return HUNTER_5_REQUEST_2.getDefault();
        }
        else {
            return HUNTER_5_REQUEST_2.get();
        }
    }
    public static String getHunter5Offer1() {
        if (Objects.equals(HUNTER_5_OFFER_1.get(), HUNTER_5_OFFER_1.getDefault())) {
            return HUNTER_5_OFFER_1.getDefault();
        }
        else {
            return HUNTER_5_OFFER_1.get();
        }
    }
    public static String getHunter5Request1() {
        if (Objects.equals(HUNTER_5_REQUEST_1.get(), HUNTER_5_REQUEST_1.getDefault())) {
            return HUNTER_5_REQUEST_1.getDefault();
        }
        else {
            return HUNTER_5_REQUEST_1.get();
        }
    }
    public static String getHunter4Offer2() {
        if (Objects.equals(HUNTER_4_OFFER_2.get(), HUNTER_4_OFFER_2.getDefault())) {
            return HUNTER_4_OFFER_2.getDefault();
        }
        else {
            return HUNTER_4_OFFER_2.get();
        }
    }
    public static String getHunter4Request2() {
        if (Objects.equals(HUNTER_4_REQUEST_2.get(), HUNTER_4_REQUEST_2.getDefault())) {
            return HUNTER_4_REQUEST_2.getDefault();
        }
        else {
            return HUNTER_4_REQUEST_2.get();
        }
    }
    public static String getHunter4Offer1() {
        if (Objects.equals(HUNTER_4_OFFER_1.get(), HUNTER_4_OFFER_1.getDefault())) {
            return HUNTER_4_OFFER_1.getDefault();
        }
        else {
            return HUNTER_4_OFFER_1.get();
        }
    }
    public static String getHunter4Request1() {
        if (Objects.equals(HUNTER_4_REQUEST_1.get(), HUNTER_4_REQUEST_1.getDefault())) {
            return HUNTER_4_REQUEST_1.getDefault();
        }
        else {
            return HUNTER_4_REQUEST_1.get();
        }
    }
    public static String getHunter3Offer2() {
        if (Objects.equals(HUNTER_3_OFFER_2.get(), HUNTER_3_OFFER_2.getDefault())) {
            return HUNTER_3_OFFER_2.getDefault();
        }
        else {
            return HUNTER_3_OFFER_2.get();
        }
    }
    public static String getHunter3Request2() {
        if (Objects.equals(HUNTER_3_REQUEST_2.get(), HUNTER_3_REQUEST_2.getDefault())) {
            return HUNTER_3_REQUEST_2.getDefault();
        }
        else {
            return HUNTER_3_REQUEST_2.get();
        }
    }
    public static String getHunter3Offer1() {
        if (Objects.equals(HUNTER_3_OFFER_1.get(), HUNTER_3_OFFER_1.getDefault())) {
            return HUNTER_3_OFFER_1.getDefault();
        }
        else {
            return HUNTER_3_OFFER_1.get();
        }
    }
    public static String getHunter3Request1() {
        if (Objects.equals(HUNTER_3_REQUEST_1.get(), HUNTER_3_REQUEST_1.getDefault())) {
            return HUNTER_3_REQUEST_1.getDefault();
        }
        else {
            return HUNTER_3_REQUEST_1.get();
        }
    }
    public static String getHunter2Offer2() {
        if (Objects.equals(HUNTER_2_OFFER_2.get(), HUNTER_2_OFFER_2.getDefault())) {
            return HUNTER_2_OFFER_2.getDefault();
        }
        else {
            return HUNTER_2_OFFER_2.get();
        }
    }
    public static String getHunter2Request2() {
        if (Objects.equals(HUNTER_2_REQUEST_2.get(), HUNTER_2_REQUEST_2.getDefault())) {
            return HUNTER_2_REQUEST_2.getDefault();
        }
        else {
            return HUNTER_2_REQUEST_2.get();
        }
    }
    public static String getHunter2Offer1() {
        if (Objects.equals(HUNTER_2_OFFER_1.get(), HUNTER_2_OFFER_1.getDefault())) {
            return HUNTER_2_OFFER_1.getDefault();
        }
        else {
            return HUNTER_2_OFFER_1.get();
        }
    }
    public static String getHunter2Request1() {
        if (Objects.equals(HUNTER_2_REQUEST_1.get(), HUNTER_2_REQUEST_1.getDefault())) {
            return HUNTER_2_REQUEST_1.getDefault();
        }
        else {
            return HUNTER_2_REQUEST_1.get();
        }
    }
    public static String getHunter1Offer2() {
        if (Objects.equals(HUNTER_1_OFFER_2.get(), HUNTER_1_OFFER_2.getDefault())) {
            return HUNTER_1_OFFER_2.getDefault();
        }
        else {
            return HUNTER_1_OFFER_2.get();
        }
    }
    public static String getHunter1Request2() {
        if (Objects.equals(HUNTER_1_REQUEST_2.get(), HUNTER_1_REQUEST_2.getDefault())) {
            return HUNTER_1_REQUEST_2.getDefault();
        }
        else {
            return HUNTER_1_REQUEST_2.get();
        }
    }
    public static String getHunter1Offer1() {
        if (Objects.equals(HUNTER_1_OFFER_1.get(), HUNTER_1_OFFER_1.getDefault())) {
            return HUNTER_1_OFFER_1.getDefault();
        }
        else {
            return HUNTER_1_OFFER_1.get();
        }
    }
    public static String getHunter1Request1() {
        if (Objects.equals(HUNTER_1_REQUEST_1.get(), HUNTER_1_REQUEST_1.getDefault())) {
            return HUNTER_1_REQUEST_1.getDefault();
        }
        else {
            return HUNTER_1_REQUEST_1.get();
        }
    }
}