package com.github.warrentode.todecoins.config.trades.villager_enchanter;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnchanterTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Enchanter Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> ENCHANTER_1_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> ENCHANTER_2_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> ENCHANTER_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> ENCHANTER_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> ENCHANTER_5_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ENCHANTER_5_REQUEST_3;

    static {
        // ENCHANTER TRADES
        BUILDER.push("Enchanter Trade Settings");
        // level 1
        BUILDER.push("Enchanter Level One Trade One")
                .comment(" Rare Trade");
        ENCHANTER_1_REQUEST_1 = BUILDER
                .comment(" Enchanter 1 Trade Request 1 Table")
                .define("enchanter_1_trade_request_1_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        ENCHANTER_1_OFFER_1 = BUILDER
                .comment(" Enchanter 1 Trade Offer 1 Table")
                .define("enchanter_1_trade_offer_1_table",
                        TradeLootTables.REFRESH_BOOK_TABLE.toString());
        ENCHANTER_1_OFFER_1_COUNT = BUILDER
                .defineInRange("enchanter_1_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Enchanter Level One Trade Two")
                .comment(" Rare Trade");
        ENCHANTER_1_REQUEST_2 = BUILDER
                .comment(" Enchanter 1 Trade Request 2 Table")
                .define("enchanter_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENCHANTER_1_OFFER_2 = BUILDER
                .comment(" Enchanter 1 Trade Offer 2 Table")
                .define("enchanter_1_trade_offer_2_table",
                        TradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Enchanter Level One Trade Three")
                .comment(" Rare Trade");
        ENCHANTER_1_REQUEST_3 = BUILDER
                .comment(" Enchanter 1 Trade Request 2 Table")
                .define("enchanter_1_trade_request_3_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Enchanter Level Two Trade One");
        ENCHANTER_2_REQUEST_1 = BUILDER
                .comment(" Enchanter 2 Trade Request 1 Table")
                .define("enchanter_2_trade_request_1_table",
                        TradeLootTables.BOOK_TABLE.toString());
        ENCHANTER_2_OFFER_1 = BUILDER
                .comment(" Enchanter 2 Trade Offer 1 Table")
                .define("enchanter_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Enchanter Level Two Trade Two")
                .comment(" Rare Trade");
        ENCHANTER_2_REQUEST_2 = BUILDER
                .comment(" Enchanter 2 Trade Request 2 Table")
                .define("enchanter_2_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Enchanter Level Two Trade Three")
                .comment(" Rare Trade");
        ENCHANTER_2_REQUEST_3 = BUILDER
                .comment(" Enchanter 2 Trade Request 3 Table")
                .define("enchanter_2_trade_request_3_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        ENCHANTER_2_OFFER_3 = BUILDER
                .comment(" Enchanter 2 Trade Offer 3 Table")
                .define("enchanter_2_trade_offer_3_table",
                        TradeLootTables.REFRESH_BOOK_TABLE.toString());
        ENCHANTER_2_OFFER_3_COUNT = BUILDER
                .defineInRange("enchanter_1_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        // level 3
        BUILDER.push("Enchanter Level Three Trade One")
                .comment(" Rare Trade");
        ENCHANTER_3_REQUEST_1 = BUILDER
                .comment(" Enchanter 3 Trade Request 1 Table")
                .define("enchanter_3_trade_request_1_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Enchanter Level Three Trade Two")
                .comment(" Rare Trade");
        ENCHANTER_3_REQUEST_2 = BUILDER
                .comment(" Enchanter 3 Trade Request 2 Table")
                .define("enchanter_3_trade_request_2_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        ENCHANTER_3_OFFER_2 = BUILDER
                .comment(" Enchanter 3 Trade Offer 2 Table")
                .define("enchanter_3_trade_offer_2_table",
                        TradeLootTables.REFRESH_BOOK_TABLE.toString());
        ENCHANTER_3_OFFER_2_COUNT = BUILDER
                .defineInRange("enchanter_3_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Enchanter Level Three Trade Three");
        ENCHANTER_3_REQUEST_3 = BUILDER
                .comment(" Enchanter 3 Trade Request 3 Table")
                .define("enchanter_3_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENCHANTER_3_OFFER_3 = BUILDER
                .comment(" Enchanter 3 Trade Offer 3 Table")
                .define("enchanter_3_trade_offer_3_table",
                        TradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Enchanter Level Four Trade One");
        ENCHANTER_4_REQUEST_1 = BUILDER
                .comment(" Enchanter 4 Trade Request 1 Table")
                .define("enchanter_4_trade_request_1_table",
                        TradeLootTables.BOOK_TABLE.toString());
        ENCHANTER_4_OFFER_1 = BUILDER
                .comment(" Enchanter 4 Trade Offer 1 Table")
                .define("enchanter_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Enchanter Level Four Trade Two")
                .comment(" Rare Trade");
        ENCHANTER_4_REQUEST_2 = BUILDER
                .comment(" Enchanter 4 Trade Request 2 Table")
                .define("enchanter_4_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Enchanter Level Four Trade Three")
                .comment(" Rare Trade");
        ENCHANTER_4_REQUEST_3 = BUILDER
                .comment(" Enchanter 4 Trade Request 3 Table")
                .define("enchanter_4_trade_request_3_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        ENCHANTER_4_OFFER_3 = BUILDER
                .comment(" Enchanter 4 Trade Offer 3 Table")
                .define("enchanter_4_trade_offer_3_table",
                        TradeLootTables.REFRESH_BOOK_TABLE.toString());
        ENCHANTER_4_OFFER_3_COUNT = BUILDER
                .defineInRange("enchanter_4_trade_offer_3_count", 1, 1, 64);
        BUILDER.pop();
        // level 5
        BUILDER.push("Enchanter Level Five Trade One");
        ENCHANTER_5_REQUEST_1 = BUILDER
                .comment(" Enchanter 5 Trade Request 1 Table")
                .define("enchanter_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ENCHANTER_5_OFFER_1 = BUILDER
                .comment(" Enchanter 5 Trade Offer 1 Table")
                .define("enchanter_5_trade_offer_1_table",
                        TradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Enchanter Level Five Trade Two")
                .comment(" Rare Trade");
        ENCHANTER_5_REQUEST_2 = BUILDER
                .comment(" Enchanter 5 Trade Request 2 Table")
                .define("enchanter_5_trade_request_2_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        ENCHANTER_5_OFFER_2 = BUILDER
                .comment(" Enchanter 5 Trade Offer 2 Table")
                .define("enchanter_5_trade_offer_2_table",
                        TradeLootTables.REFRESH_BOOK_TABLE.toString());
        ENCHANTER_5_OFFER_2_COUNT = BUILDER
                .defineInRange("enchanter_5_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Enchanter Level Five Trade Three");
        ENCHANTER_5_REQUEST_3 = BUILDER
                .comment(" Enchanter 5 Trade Request 3 Table")
                .define("enchanter_5_trade_request_3_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // ENCHANTER TRADE GETTERS
    public static String getEnchanter5Request3() {
        if (Objects.equals(ENCHANTER_5_REQUEST_3.get(), ENCHANTER_5_REQUEST_3.getDefault())) {
            return ENCHANTER_5_REQUEST_3.getDefault();
        }
        else {
            return ENCHANTER_5_REQUEST_3.get();
        }
    }
    public static int getEnchanter5Offer2Count() {
        if (Objects.equals(ENCHANTER_5_OFFER_2_COUNT.get(), ENCHANTER_5_OFFER_2_COUNT.getDefault())) {
            return ENCHANTER_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return ENCHANTER_5_OFFER_2_COUNT.get();
        }
    }
    public static String getEnchanter5Offer2() {
        if (Objects.equals(ENCHANTER_5_OFFER_2.get(), ENCHANTER_5_OFFER_2.getDefault())) {
            return ENCHANTER_5_OFFER_2.getDefault();
        }
        else {
            return ENCHANTER_5_OFFER_2.get();
        }
    }
    public static String getEnchanter5Request2() {
        if (Objects.equals(ENCHANTER_5_REQUEST_2.get(), ENCHANTER_5_REQUEST_2.getDefault())) {
            return ENCHANTER_5_REQUEST_2.getDefault();
        }
        else {
            return ENCHANTER_5_REQUEST_2.get();
        }
    }
    public static String getEnchanter5Offer1() {
        if (Objects.equals(ENCHANTER_5_OFFER_1.get(), ENCHANTER_5_OFFER_1.getDefault())) {
            return ENCHANTER_5_OFFER_1.getDefault();
        }
        else {
            return ENCHANTER_5_OFFER_1.get();
        }
    }
    public static String getEnchanter5Request1() {
        if (Objects.equals(ENCHANTER_5_REQUEST_1.get(), ENCHANTER_5_REQUEST_1.getDefault())) {
            return ENCHANTER_5_REQUEST_1.getDefault();
        }
        else {
            return ENCHANTER_5_REQUEST_1.get();
        }
    }
    public static int getEnchanter4Offer3Count() {
        if (Objects.equals(ENCHANTER_4_OFFER_3_COUNT.get(), ENCHANTER_4_OFFER_3_COUNT.getDefault())) {
            return ENCHANTER_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return ENCHANTER_4_OFFER_3_COUNT.get();
        }
    }
    public static String getEnchanter4Offer3() {
        if (Objects.equals(ENCHANTER_4_OFFER_3.get(), ENCHANTER_4_OFFER_3.getDefault())) {
            return ENCHANTER_4_OFFER_3.getDefault();
        }
        else {
            return ENCHANTER_4_OFFER_3.get();
        }
    }
    public static String getEnchanter4Request3() {
        if (Objects.equals(ENCHANTER_4_REQUEST_3.get(), ENCHANTER_4_REQUEST_3.getDefault())) {
            return ENCHANTER_4_REQUEST_3.getDefault();
        }
        else {
            return ENCHANTER_4_REQUEST_3.get();
        }
    }
    public static String getEnchanter4Request2() {
        if (Objects.equals(ENCHANTER_4_REQUEST_2.get(), ENCHANTER_4_REQUEST_2.getDefault())) {
            return ENCHANTER_4_REQUEST_2.getDefault();
        }
        else {
            return ENCHANTER_4_REQUEST_2.get();
        }
    }
    public static String getEnchanter4Offer1() {
        if (Objects.equals(ENCHANTER_4_OFFER_1.get(), ENCHANTER_4_OFFER_1.getDefault())) {
            return ENCHANTER_4_OFFER_1.getDefault();
        }
        else {
            return ENCHANTER_4_OFFER_1.get();
        }
    }
    public static String getEnchanter4Request1() {
        if (Objects.equals(ENCHANTER_4_REQUEST_1.get(), ENCHANTER_4_REQUEST_1.getDefault())) {
            return ENCHANTER_4_REQUEST_1.getDefault();
        }
        else {
            return ENCHANTER_4_REQUEST_1.get();
        }
    }
    public static String getEnchanter3Offer3() {
        if (Objects.equals(ENCHANTER_3_OFFER_3.get(), ENCHANTER_3_OFFER_3.getDefault())) {
            return ENCHANTER_3_OFFER_3.getDefault();
        }
        else {
            return ENCHANTER_3_OFFER_3.get();
        }
    }
    public static String getEnchanter3Request3() {
        if (Objects.equals(ENCHANTER_3_REQUEST_3.get(), ENCHANTER_3_REQUEST_3.getDefault())) {
            return ENCHANTER_3_REQUEST_3.getDefault();
        }
        else {
            return ENCHANTER_3_REQUEST_3.get();
        }
    }
    public static String getEnchanter3Offer2() {
        if (Objects.equals(ENCHANTER_3_OFFER_2.get(), ENCHANTER_3_OFFER_2.getDefault())) {
            return ENCHANTER_3_OFFER_2.getDefault();
        }
        else {
            return ENCHANTER_3_OFFER_2.get();
        }
    }
    public static int getEnchanter3Offer2Count() {
        if (Objects.equals(ENCHANTER_3_OFFER_2_COUNT.get(), ENCHANTER_3_OFFER_2_COUNT.getDefault())) {
            return ENCHANTER_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return ENCHANTER_3_OFFER_2_COUNT.get();
        }
    }
    public static String getEnchanter3Request2() {
        if (Objects.equals(ENCHANTER_3_REQUEST_2.get(), ENCHANTER_3_REQUEST_2.getDefault())) {
            return ENCHANTER_3_REQUEST_2.getDefault();
        }
        else {
            return ENCHANTER_3_REQUEST_2.get();
        }
    }
    public static String getEnchanter3Request1() {
        if (Objects.equals(ENCHANTER_3_REQUEST_1.get(), ENCHANTER_3_REQUEST_1.getDefault())) {
            return ENCHANTER_3_REQUEST_1.getDefault();
        }
        else {
            return ENCHANTER_3_REQUEST_1.get();
        }
    }
    public static int getEnchanter2Offer3Count() {
        if (Objects.equals(ENCHANTER_2_OFFER_3_COUNT.get(), ENCHANTER_2_OFFER_3_COUNT.getDefault())) {
            return ENCHANTER_2_OFFER_3_COUNT.getDefault();
        }
        else {
            return ENCHANTER_2_OFFER_3_COUNT.get();
        }
    }
    public static String getEnchanter2Offer3() {
        if (Objects.equals(ENCHANTER_2_OFFER_3.get(), ENCHANTER_2_OFFER_3.getDefault())) {
            return ENCHANTER_2_OFFER_3.getDefault();
        }
        else {
            return ENCHANTER_2_OFFER_3.get();
        }
    }
    public static String getEnchanter2Request3() {
        if (Objects.equals(ENCHANTER_2_REQUEST_3.get(), ENCHANTER_2_REQUEST_3.getDefault())) {
            return ENCHANTER_2_REQUEST_3.getDefault();
        }
        else {
            return ENCHANTER_2_REQUEST_3.get();
        }
    }
    public static String getEnchanter2Request2() {
        if (Objects.equals(ENCHANTER_2_REQUEST_2.get(), ENCHANTER_2_REQUEST_2.getDefault())) {
            return ENCHANTER_2_REQUEST_2.getDefault();
        }
        else {
            return ENCHANTER_2_REQUEST_2.get();
        }
    }
    public static String getEnchanter2Offer1() {
        if (Objects.equals(ENCHANTER_2_OFFER_1.get(), ENCHANTER_2_OFFER_1.getDefault())) {
            return ENCHANTER_2_OFFER_1.getDefault();
        }
        else {
            return ENCHANTER_2_OFFER_1.get();
        }
    }
    public static String getEnchanter2Request1() {
        if (Objects.equals(ENCHANTER_2_REQUEST_1.get(), ENCHANTER_2_REQUEST_1.getDefault())) {
            return ENCHANTER_2_REQUEST_1.getDefault();
        }
        else {
            return ENCHANTER_2_REQUEST_1.get();
        }
    }
    public static String getEnchanter1Request3() {
        if (Objects.equals(ENCHANTER_1_REQUEST_3.get(), ENCHANTER_1_REQUEST_3.getDefault())) {
            return ENCHANTER_1_REQUEST_3.getDefault();
        }
        else {
            return ENCHANTER_1_REQUEST_3.get();
        }
    }
    public static String getEnchanter1Offer2() {
        if (Objects.equals(ENCHANTER_1_OFFER_2.get(), ENCHANTER_1_OFFER_2.getDefault())) {
            return ENCHANTER_1_OFFER_2.getDefault();
        }
        else {
            return ENCHANTER_1_OFFER_2.get();
        }
    }
    public static String getEnchanter1Request2() {
        if (Objects.equals(ENCHANTER_1_REQUEST_2.get(), ENCHANTER_1_REQUEST_2.getDefault())) {
            return ENCHANTER_1_REQUEST_2.getDefault();
        }
        else {
            return ENCHANTER_1_REQUEST_2.get();
        }
    }
    public static int getEnchanter1Offer1Count() {
        if (Objects.equals(ENCHANTER_1_OFFER_1_COUNT.get(), ENCHANTER_1_OFFER_1_COUNT.getDefault())) {
            return ENCHANTER_1_OFFER_1_COUNT.getDefault();
        }
        else {
            return ENCHANTER_1_OFFER_1_COUNT.get();
        }
    }
    public static String getEnchanter1Offer1() {
        if (Objects.equals(ENCHANTER_1_OFFER_1.get(), ENCHANTER_1_OFFER_1.getDefault())) {
            return ENCHANTER_1_OFFER_1.getDefault();
        }
        else {
            return ENCHANTER_1_OFFER_1.get();
        }
    }
    public static String getEnchanter1Request1() {
        if (Objects.equals(ENCHANTER_1_REQUEST_1.get(), ENCHANTER_1_REQUEST_1.getDefault())) {
            return ENCHANTER_1_REQUEST_1.getDefault();
        }
        else {
            return ENCHANTER_1_REQUEST_1.get();
        }
    }
}