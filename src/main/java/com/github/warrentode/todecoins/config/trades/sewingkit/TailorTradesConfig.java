package com.github.warrentode.todecoins.config.trades.sewingkit;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TailorTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Tailor Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_1_REQUEST_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_1_REQUEST_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_1_REQUEST_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_2_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_2_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_5_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> TAILOR_5_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAILOR_5_OFFER_3_COUNT;

    static {
        // TAILOR TRADES
        BUILDER.push("Tailor Trade Settings");
        // level 1
        BUILDER.push("Tailor Level One Trade One");
        TAILOR_1_REQUEST_1 = BUILDER
                .comment(" Tailor 1 Trade Request 1 Table")
                .define("tailor_1_trade_request_1_table",
                        TradeLootTables.TAGGED_LEATHER_TABLE.toString());
        TAILOR_1_REQUEST_1_COUNT = BUILDER
                .define("tailor_1_trade_request_1_count", 6);
        TAILOR_1_OFFER_1 = BUILDER
                .comment(" Tailor 1 Trade Offer 1 Table")
                .define("tailor_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Tailor Level One Trade Two");
        TAILOR_1_REQUEST_2 = BUILDER
                .comment(" Tailor 1 Trade Request 2 Table")
                .define("tailor_1_trade_request_2_table",
                        TradeLootTables.TAGGED_WOOL_TABLE.toString());
        TAILOR_1_REQUEST_2_COUNT = BUILDER
                .define("tailor_1_trade_offer_1_count", 18);
        TAILOR_1_OFFER_2 = BUILDER
                .comment(" Tailor 1 Trade Offer 2 Table")
                .define("tailor_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Tailor Level One Trade Three");
        TAILOR_1_REQUEST_3 = BUILDER
                .comment(" Tailor 1 Trade Request 3 Table")
                .define("tailor_1_trade_request_3_table",
                        TradeLootTables.TAGGED_STRING_TABLE.toString());
        TAILOR_1_REQUEST_3_COUNT = BUILDER
                .define("tailor_1_trade_request_3_count", 16);
        TAILOR_1_OFFER_3 = BUILDER
                .comment(" Tailor 1 Trade Offer 3 Table")
                .define("tailor_1_trade_offer_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Tailor Level One Trade Four");
        TAILOR_1_REQUEST_4 = BUILDER
                .comment(" Tailor 1 Trade Request 4 Table")
                .define("tailor_1_trade_request_4_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        TAILOR_1_REQUEST_4_COUNT = BUILDER
                .define("tailor_1_trade_offer_4_count", 6);
        TAILOR_1_OFFER_4 = BUILDER
                .comment(" Tailor 1 Trade Offer 4 Table")
                .define("tailor_1_trade_offer_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Tailor Level Two Trade One")
                .comment(" Dyed Armor Trade");
        TAILOR_2_REQUEST_1 = BUILDER
                .comment(" Tailor 2 Trade Request 1 Table")
                .define("tailor_2_trade_request_1_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        TAILOR_2_OFFER_1 = BUILDER
                .comment(" Tailor 2 Trade Offer 1 Table")
                .define("tailor_2_trade_offer_1_table",
                        TradeLootTables.DYEABLE_LEGGINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Tailor Level Two Trade Two")
                .comment(" Dyed Armor Trade");
        TAILOR_2_REQUEST_2 = BUILDER
                .comment(" Tailor 2 Trade Request 2 Table")
                .define("tailor_2_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        TAILOR_2_OFFER_2 = BUILDER
                .comment(" Tailor 2 Trade Offer 2 Table")
                .define("tailor_2_trade_offer_2_table",
                        TradeLootTables.DYEABLE_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Tailor Level Two Trade Three")
                .comment(" Dyed Armor Trade");
        TAILOR_2_REQUEST_3 = BUILDER
                .comment(" Tailor 2 Trade Request 3 Table")
                .define("tailor_2_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        TAILOR_2_OFFER_3 = BUILDER
                .comment(" Tailor 2 Trade Offer 3 Table")
                .define("tailor_2_trade_offer_3_table",
                        TradeLootTables.DYEABLE_BOOTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Tailor Level Two Trade Four")
                .comment(" Dyed Armor Trade");
        TAILOR_2_REQUEST_4 = BUILDER
                .comment(" Tailor 2 Trade Request 4 Table")
                .define("tailor_2_trade_request_4_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        TAILOR_2_OFFER_4 = BUILDER
                .comment(" Tailor 2 Trade Offer 4 Table")
                .define("tailor_2_trade_offer_4_table",
                        TradeLootTables.DYEABLE_BOOTS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Tailor Level Three Trade One");
        TAILOR_3_REQUEST_1 = BUILDER
                .comment(" Tailor 3 Trade Request 1 Table")
                .define("tailor_3_trade_request_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        TAILOR_3_REQUEST_1_COUNT = BUILDER
                .define("tailor_3_trade_request_1_count", 3);
        TAILOR_3_OFFER_1 = BUILDER
                .comment(" Tailor 3 Trade Offer 1 Table")
                .define("tailor_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Tailor Level Three Trade Two");
        TAILOR_3_REQUEST_2 = BUILDER
                .comment(" Tailor 3 Trade Request 2 Table")
                .define("tailor_3_trade_request_2_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        TAILOR_3_OFFER_2 = BUILDER
                .comment(" Tailor 3 Trade Offer 2 Table")
                .define("tailor_3_trade_offer_2_table",
                        TradeLootTables.PATTERNS_TAG_TABLE.toString());
        TAILOR_3_OFFER_2_COUNT = BUILDER
                .define("tailor_3_trade_offer_2_count", 1);
        BUILDER.pop();
        // level 4
        BUILDER.push("Tailor Level Four Trade One");
        TAILOR_4_REQUEST_1 = BUILDER
                .comment(" Tailor 4 Trade Request 1 Table")
                .define("tailor_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TAILOR_4_OFFER_1 = BUILDER
                .comment(" Tailor 4 Trade Offer 1 Table")
                .define("tailor_4_trade_offer_1_table",
                        TradeLootTables.TEXTILES_TAG_TABLE.toString());
        TAILOR_4_OFFER_1_COUNT = BUILDER
                .define("tailor_4_trade_offer_1_count", 6);
        BUILDER.pop();
        BUILDER.push("Tailor Level Four Trade Two");
        TAILOR_4_REQUEST_2 = BUILDER
                .comment(" Tailor 4 Trade Request 2 Table")
                .define("tailor_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TAILOR_4_OFFER_2 = BUILDER
                .comment(" Tailor 4 Trade Offer 2 Table")
                .define("tailor_4_trade_offer_2_table",
                        TradeLootTables.TAILOR_TOOLS_TABLE.toString());
        TAILOR_4_OFFER_2_COUNT = BUILDER
                .define("tailor_4_trade_offer_2_count", 1);
        BUILDER.pop();
        // level 5
        BUILDER.push("Tailor Level Five Trade One");
        TAILOR_5_REQUEST_1 = BUILDER
                .comment(" Tailor 5 Trade Request 1 Table")
                .define("tailor_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TAILOR_5_OFFER_1 = BUILDER
                .comment(" Tailor 5 Trade Offer 1 Table")
                .define("tailor_5_trade_offer_1_table",
                        TradeLootTables.TEXTILES_TAG_TABLE.toString());
        TAILOR_5_OFFER_1_COUNT = BUILDER
                .define("tailor_5_trade_offer_1_count", 6);
        BUILDER.pop();
        BUILDER.push("Tailor Level Five Trade Two");
        TAILOR_5_REQUEST_2 = BUILDER
                .comment(" Tailor 5 Trade Request 2 Table")
                .define("tailor_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TAILOR_5_OFFER_2 = BUILDER
                .comment(" Tailor 5 Trade Offer 2 Table")
                .define("tailor_5_trade_offer_2_table",
                        TradeLootTables.TAILOR_TOOLS_TABLE.toString());
        TAILOR_5_OFFER_2_COUNT = BUILDER
                .define("tailor_5_trade_offer_2_count", 1);
        BUILDER.pop();
        BUILDER.push("Tailor Level Five Trade Three");
        TAILOR_5_REQUEST_3= BUILDER
                .comment(" Tailor 5 Trade Request 3 Table")
                .define("tailor_5_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TAILOR_5_OFFER_3 = BUILDER
                .comment(" Tailor 5 Trade Offer 3 Table")
                .define("tailor_5_trade_offer_3_table",
                        TradeLootTables.PATTERNS_TAG_TABLE.toString());
        TAILOR_5_OFFER_3_COUNT = BUILDER
                .define("tailor_5_trade_offer_3_count", 1);
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // TAILOR TRADE GETTERS
    public static int getTailor5Offer3Count() {
        if (Objects.equals(TAILOR_5_OFFER_3_COUNT.get(), TAILOR_5_OFFER_3_COUNT.getDefault())) {
            return TAILOR_5_OFFER_3_COUNT.getDefault();
        }
        else {
            return TAILOR_5_OFFER_3_COUNT.get();
        }
    }
    public static String getTailor5Offer3() {
        if (Objects.equals(TAILOR_5_OFFER_3.get(), TAILOR_5_OFFER_3.getDefault())) {
            return TAILOR_5_OFFER_3.getDefault();
        }
        else {
            return TAILOR_5_OFFER_3.get();
        }
    }
    public static String getTailor5Request3() {
        if (Objects.equals(TAILOR_5_REQUEST_3.get(), TAILOR_5_REQUEST_3.getDefault())) {
            return TAILOR_5_REQUEST_3.getDefault();
        }
        else {
            return TAILOR_5_REQUEST_3.get();
        }
    }
    public static int getTailor5Offer2Count() {
        if (Objects.equals(TAILOR_5_OFFER_2_COUNT.get(), TAILOR_5_OFFER_2_COUNT.getDefault())) {
            return TAILOR_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return TAILOR_5_OFFER_2_COUNT.get();
        }
    }
    public static String getTailor5Offer2() {
        if (Objects.equals(TAILOR_5_OFFER_2.get(), TAILOR_5_OFFER_2.getDefault())) {
            return TAILOR_5_OFFER_2.getDefault();
        }
        else {
            return TAILOR_5_OFFER_2.get();
        }
    }
    public static String getTailor5Request2() {
        if (Objects.equals(TAILOR_5_REQUEST_2.get(), TAILOR_5_REQUEST_2.getDefault())) {
            return TAILOR_5_REQUEST_2.getDefault();
        }
        else {
            return TAILOR_5_REQUEST_2.get();
        }
    }
    public static int getTailor5Offer1Count() {
        if (Objects.equals(TAILOR_5_OFFER_1_COUNT.get(), TAILOR_5_OFFER_1_COUNT.getDefault())) {
            return TAILOR_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return TAILOR_5_OFFER_1_COUNT.get();
        }
    }
    public static String getTailor5Offer1() {
        if (Objects.equals(TAILOR_5_OFFER_1.get(), TAILOR_5_OFFER_1.getDefault())) {
            return TAILOR_5_OFFER_1.getDefault();
        }
        else {
            return TAILOR_5_OFFER_1.get();
        }
    }
    public static String getTailor5Request1() {
        if (Objects.equals(TAILOR_5_REQUEST_1.get(), TAILOR_5_REQUEST_1.getDefault())) {
            return TAILOR_5_REQUEST_1.getDefault();
        }
        else {
            return TAILOR_5_REQUEST_1.get();
        }
    }
    public static int getTailor4Offer2Count() {
        if (Objects.equals(TAILOR_4_OFFER_2_COUNT.get(), TAILOR_4_OFFER_2_COUNT.getDefault())) {
            return TAILOR_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return TAILOR_4_OFFER_2_COUNT.get();
        }
    }
    public static String getTailor4Offer2() {
        if (Objects.equals(TAILOR_4_OFFER_2.get(), TAILOR_4_OFFER_2.getDefault())) {
            return TAILOR_4_OFFER_2.getDefault();
        }
        else {
            return TAILOR_4_OFFER_2.get();
        }
    }
    public static String getTailor4Request2() {
        if (Objects.equals(TAILOR_4_REQUEST_2.get(), TAILOR_4_REQUEST_2.getDefault())) {
            return TAILOR_4_REQUEST_2.getDefault();
        }
        else {
            return TAILOR_4_REQUEST_2.get();
        }
    }
    public static int getTailor4Offer1Count() {
        if (Objects.equals(TAILOR_4_OFFER_1_COUNT.get(), TAILOR_4_OFFER_1_COUNT.getDefault())) {
            return TAILOR_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return TAILOR_4_OFFER_1_COUNT.get();
        }
    }
    public static String getTailor4Offer1() {
        if (Objects.equals(TAILOR_4_OFFER_1.get(), TAILOR_4_OFFER_1.getDefault())) {
            return TAILOR_4_OFFER_1.getDefault();
        }
        else {
            return TAILOR_4_OFFER_1.get();
        }
    }
    public static String getTailor4Request1() {
        if (Objects.equals(TAILOR_4_REQUEST_1.get(), TAILOR_4_REQUEST_1.getDefault())) {
            return TAILOR_4_REQUEST_1.getDefault();
        }
        else {
            return TAILOR_4_REQUEST_1.get();
        }
    }
    public static int getTailor3Offer2Count() {
        if (Objects.equals(TAILOR_3_OFFER_2_COUNT.get(), TAILOR_3_OFFER_2_COUNT.getDefault())) {
            return TAILOR_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return TAILOR_3_OFFER_2_COUNT.get();
        }
    }
    public static String getTailor3Offer2() {
        if (Objects.equals(TAILOR_3_OFFER_2.get(), TAILOR_3_OFFER_2.getDefault())) {
            return TAILOR_3_OFFER_2.getDefault();
        }
        else {
            return TAILOR_3_OFFER_2.get();
        }
    }
    public static String getTailor3Request2() {
        if (Objects.equals(TAILOR_3_REQUEST_2.get(), TAILOR_3_REQUEST_2.getDefault())) {
            return TAILOR_3_REQUEST_2.getDefault();
        }
        else {
            return TAILOR_3_REQUEST_2.get();
        }
    }
    public static String getTailor3Offer1() {
        if (Objects.equals(TAILOR_3_OFFER_1.get(), TAILOR_3_OFFER_1.getDefault())) {
            return TAILOR_3_OFFER_1.getDefault();
        }
        else {
            return TAILOR_3_OFFER_1.get();
        }
    }
    public static int getTailor3Request1Count() {
        if (Objects.equals(TAILOR_3_REQUEST_1_COUNT.get(), TAILOR_3_REQUEST_1_COUNT.getDefault())) {
            return TAILOR_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return TAILOR_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getTailor3Request1() {
        if (Objects.equals(TAILOR_3_REQUEST_1.get(), TAILOR_3_REQUEST_1.getDefault())) {
            return TAILOR_3_REQUEST_1.getDefault();
        }
        else {
            return TAILOR_3_REQUEST_1.get();
        }
    }
    public static String getTailor2Offer4() {
        if (Objects.equals(TAILOR_2_OFFER_4.get(), TAILOR_2_OFFER_4.getDefault())) {
            return TAILOR_2_OFFER_4.getDefault();
        }
        else {
            return TAILOR_2_OFFER_4.get();
        }
    }
    public static String getTailor2Request4() {
        if (Objects.equals(TAILOR_2_REQUEST_4.get(), TAILOR_2_REQUEST_4.getDefault())) {
            return TAILOR_2_REQUEST_4.getDefault();
        }
        else {
            return TAILOR_2_REQUEST_4.get();
        }
    }
    public static String getTailor2Offer3() {
        if (Objects.equals(TAILOR_2_OFFER_3.get(), TAILOR_2_OFFER_3.getDefault())) {
            return TAILOR_2_OFFER_3.getDefault();
        }
        else {
            return TAILOR_2_OFFER_3.get();
        }
    }
    public static String getTailor2Request3() {
        if (Objects.equals(TAILOR_2_REQUEST_3.get(), TAILOR_2_REQUEST_3.getDefault())) {
            return TAILOR_2_REQUEST_3.getDefault();
        }
        else {
            return TAILOR_2_REQUEST_3.get();
        }
    }
    public static String getTailor2Offer2() {
        if (Objects.equals(TAILOR_2_OFFER_2.get(), TAILOR_2_OFFER_2.getDefault())) {
            return TAILOR_2_OFFER_2.getDefault();
        }
        else {
            return TAILOR_2_OFFER_2.get();
        }
    }
    public static String getTailor2Request2() {
        if (Objects.equals(TAILOR_2_REQUEST_2.get(), TAILOR_2_REQUEST_2.getDefault())) {
            return TAILOR_2_REQUEST_2.getDefault();
        }
        else {
            return TAILOR_2_REQUEST_2.get();
        }
    }
    public static String getTailor2Offer1() {
        if (Objects.equals(TAILOR_2_OFFER_1.get(), TAILOR_2_OFFER_1.getDefault())) {
            return TAILOR_2_OFFER_1.getDefault();
        }
        else {
            return TAILOR_2_OFFER_1.get();
        }
    }
    public static String getTailor2Request1() {
        if (Objects.equals(TAILOR_2_REQUEST_1.get(), TAILOR_2_REQUEST_1.getDefault())) {
            return TAILOR_2_REQUEST_1.getDefault();
        }
        else {
            return TAILOR_2_REQUEST_1.get();
        }
    }
    public static String getTailor1Offer4() {
        if (Objects.equals(TAILOR_1_OFFER_4.get(), TAILOR_1_OFFER_4.getDefault())) {
            return TAILOR_1_OFFER_4.getDefault();
        }
        else {
            return TAILOR_1_OFFER_4.get();
        }
    }
    public static int getTailor1Request4Count() {
        if (Objects.equals(TAILOR_1_REQUEST_4_COUNT.get(), TAILOR_1_REQUEST_4_COUNT.getDefault())) {
            return TAILOR_1_REQUEST_4_COUNT.getDefault();
        }
        else {
            return TAILOR_1_REQUEST_4_COUNT.get();
        }
    }
    public static String getTailor1Request4() {
        if (Objects.equals(TAILOR_1_REQUEST_4.get(), TAILOR_1_REQUEST_4.getDefault())) {
            return TAILOR_1_REQUEST_4.getDefault();
        }
        else {
            return TAILOR_1_REQUEST_4.get();
        }
    }
    public static String getTailor1Offer3() {
        if (Objects.equals(TAILOR_1_OFFER_3.get(), TAILOR_1_OFFER_3.getDefault())) {
            return TAILOR_1_OFFER_3.getDefault();
        }
        else {
            return TAILOR_1_OFFER_3.get();
        }
    }
    public static int getTailor1Request3Count() {
        if (Objects.equals(TAILOR_1_REQUEST_3_COUNT.get(), TAILOR_1_REQUEST_3_COUNT.getDefault())) {
            return TAILOR_1_REQUEST_3_COUNT.getDefault();
        }
        else {
            return TAILOR_1_REQUEST_3_COUNT.get();
        }
    }
    public static String getTailor1Request3() {
        if (Objects.equals(TAILOR_1_REQUEST_3.get(), TAILOR_1_REQUEST_3.getDefault())) {
            return TAILOR_1_REQUEST_3.getDefault();
        }
        else {
            return TAILOR_1_REQUEST_3.get();
        }
    }
    public static String getTailor1Offer2() {
        if (Objects.equals(TAILOR_1_OFFER_2.get(), TAILOR_1_OFFER_2.getDefault())) {
            return TAILOR_1_OFFER_2.getDefault();
        }
        else {
            return TAILOR_1_OFFER_2.get();
        }
    }
    public static int getTailor1Request2Count() {
        if (Objects.equals(TAILOR_1_REQUEST_2_COUNT.get(), TAILOR_1_REQUEST_2_COUNT.getDefault())) {
            return TAILOR_1_REQUEST_2_COUNT.getDefault();
        }
        else {
            return TAILOR_1_REQUEST_2_COUNT.get();
        }
    }
    public static String getTailor1Request2() {
        if (Objects.equals(TAILOR_1_REQUEST_2.get(), TAILOR_1_REQUEST_2.getDefault())) {
            return TAILOR_1_REQUEST_2.getDefault();
        }
        else {
            return TAILOR_1_REQUEST_2.get();
        }
    }
    public static String getTailor1Offer1() {
        if (Objects.equals(TAILOR_1_OFFER_1.get(), TAILOR_1_OFFER_1.getDefault())) {
            return TAILOR_1_OFFER_1.getDefault();
        }
        else {
            return TAILOR_1_OFFER_1.get();
        }
    }
    public static int getTailor1Request1Count() {
        if (Objects.equals(TAILOR_1_REQUEST_1_COUNT.get(), TAILOR_1_REQUEST_1_COUNT.getDefault())) {
            return TAILOR_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return TAILOR_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getTailor1Request1() {
        if (Objects.equals(TAILOR_1_REQUEST_1.get(), TAILOR_1_REQUEST_1.getDefault())) {
            return TAILOR_1_REQUEST_1.getDefault();
        }
        else {
            return TAILOR_1_REQUEST_1.get();
        }
    }
}