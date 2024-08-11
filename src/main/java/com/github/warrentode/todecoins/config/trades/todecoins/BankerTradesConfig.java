package com.github.warrentode.todecoins.config.trades.todecoins;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BankerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Banker Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_OFFER_4;

    static {
        // BANKER TRADES
        BUILDER.push("Banker Trade Settings");
        // level 1
        BUILDER.push("Banker Level One Trade One");
        BANKER_1_REQUEST_1 = BUILDER
                .comment(" Banker 1 Trade Request 1 Table")
                .define("banker_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_TABLE.toString());
        BANKER_1_OFFER_1 = BUILDER
                .comment(" Banker 1 Trade Offer 1 Table")
                .define("banker_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level One Trade Two");
        BANKER_1_REQUEST_2 = BUILDER
                .comment(" Banker 1 Trade Request 2 Table")
                .define("banker_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BANKER_1_OFFER_2 = BUILDER
                .comment(" Banker 1 Trade Offer 2 Table")
                .define("banker_1_trade_offer_2_table",
                        TradeLootTables.ONE_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Banker Level Two Trade One");
        BANKER_2_REQUEST_1 = BUILDER
                .comment(" Banker 2 Trade Request 1 Table")
                .define("banker_2_trade_request_1_table",
                        TradeLootTables.SIXTEEN_EMERALD_TABLE.toString());
        BANKER_2_OFFER_1 = BUILDER
                .comment(" Banker 2 Trade Offer 1 Table")
                .define("banker_2_trade_offer_1_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Two Trade Two");
        BANKER_2_REQUEST_2 = BUILDER
                .comment(" Banker 2 Trade Request 2 Table")
                .define("banker_2_trade_request_2_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        BANKER_2_OFFER_2 = BUILDER
                .comment(" Banker 2 Trade Offer 2 Table")
                .define("banker_2_trade_offer_2_table",
                        TradeLootTables.SIXTEEN_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Banker Level Three Trade One");
        BANKER_3_REQUEST_1 = BUILDER
                .comment(" Banker 3 Trade Request 1 Table")
                .define("banker_3_trade_request_1_table",
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE.toString());
        BANKER_3_OFFER_1 = BUILDER
                .comment(" Banker 3 Trade Offer 1 Table")
                .define("banker_3_trade_offer_1_table",
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Three Trade Two");
        BANKER_3_REQUEST_2 = BUILDER
                .comment(" Banker 3 Trade Request 2 Table")
                .define("banker_3_trade_request_2_table",
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        BANKER_3_OFFER_2 = BUILDER
                .comment(" Banker 3 Trade Offer 2 Table")
                .define("banker_3_trade_offer_2_table",
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Banker Level Four Trade One");
        BANKER_4_REQUEST_1 = BUILDER
                .comment(" Banker 4 Trade Request 1 Table")
                .define("banker_4_trade_request_1_table",
                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE.toString());
        BANKER_4_OFFER_1 = BUILDER
                .comment(" Banker 4 Trade Offer 1 Table")
                .define("banker_4_trade_offer_1_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Four Trade Two");
        BANKER_4_REQUEST_2 = BUILDER
                .comment(" Banker 4 Trade Request 2 Table")
                .define("banker_4_trade_request_2_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BANKER_4_OFFER_2 = BUILDER
                .comment(" Banker 4 Trade Offer 2 Table")
                .define("banker_4_trade_offer_2_table",
                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Banker Level Five Trade One");
        BANKER_5_REQUEST_1 = BUILDER
                .comment(" Banker 5 Trade Request 1 Table")
                .define("banker_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        BANKER_5_OFFER_1 = BUILDER
                .comment(" Banker 5 Trade Offer 1 Table")
                .define("banker_5_trade_offer_1_table",
                        TradeLootTables.ONE_EMERALD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Five Trade Two");
        BANKER_5_REQUEST_2 = BUILDER
                .comment(" Banker 5 Trade Request 2 Table")
                .define("banker_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BANKER_5_OFFER_2 = BUILDER
                .comment(" Banker 5 Trade Offer 2 Table")
                .define("banker_5_trade_offer_2_table",
                        TradeLootTables.ONE_EMERALD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Five Trade Three");
        BANKER_5_REQUEST_3 = BUILDER
                .comment(" Banker 5 Trade Request 3 Table")
                .define("banker_5_trade_request_3_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_METALS.toString());
        BANKER_5_OFFER_3 = BUILDER
                .comment(" Banker 5 Trade Offer 3 Table")
                .define("banker_5_trade_offer_3_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Five Trade Four");
        BANKER_5_REQUEST_4 = BUILDER
                .comment(" Banker 5 Trade Request 4 Table")
                .define("banker_5_trade_request_4_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_GEMS.toString());
        BANKER_5_OFFER_4 = BUILDER
                .comment(" Banker 5 Trade Offer 4 Table")
                .define("banker_5_trade_offer_4_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // BANKER TRADE GETTERS
    public static String getBanker5Offer4() {
        if (Objects.equals(BANKER_5_OFFER_4.get(), BANKER_5_OFFER_4.getDefault())) {
            return BANKER_5_OFFER_4.getDefault();
        }
        else {
            return BANKER_5_OFFER_4.get();
        }
    }
    public static String getBanker5Request4() {
        if (Objects.equals(BANKER_5_REQUEST_4.get(), BANKER_5_REQUEST_4.getDefault())) {
            return BANKER_5_REQUEST_4.getDefault();
        }
        else {
            return BANKER_5_REQUEST_4.get();
        }
    }
    public static String getBanker5Offer3() {
        if (Objects.equals(BANKER_5_OFFER_3.get(), BANKER_5_OFFER_3.getDefault())) {
            return BANKER_5_OFFER_3.getDefault();
        }
        else {
            return BANKER_5_OFFER_3.get();
        }
    }
    public static String getBanker5Request3() {
        if (Objects.equals(BANKER_5_REQUEST_3.get(), BANKER_5_REQUEST_3.getDefault())) {
            return BANKER_5_REQUEST_3.getDefault();
        }
        else {
            return BANKER_5_REQUEST_3.get();
        }
    }
    public static String getBanker5Offer2() {
        if (Objects.equals(BANKER_5_OFFER_2.get(), BANKER_5_OFFER_2.getDefault())) {
            return BANKER_5_OFFER_2.getDefault();
        }
        else {
            return BANKER_5_OFFER_2.get();
        }
    }
    public static String getBanker5Request2() {
        if (Objects.equals(BANKER_5_REQUEST_2.get(), BANKER_5_REQUEST_2.getDefault())) {
            return BANKER_5_REQUEST_2.getDefault();
        }
        else {
            return BANKER_5_REQUEST_2.get();
        }
    }
    public static String getBanker5Offer1() {
        if (Objects.equals(BANKER_5_OFFER_1.get(), BANKER_5_OFFER_1.getDefault())) {
            return BANKER_5_OFFER_1.getDefault();
        }
        else {
            return BANKER_5_OFFER_1.get();
        }
    }
    public static String getBanker5Request1() {
        if (Objects.equals(BANKER_5_REQUEST_1.get(), BANKER_5_REQUEST_1.getDefault())) {
            return BANKER_5_REQUEST_1.getDefault();
        }
        else {
            return BANKER_5_REQUEST_1.get();
        }
    }
    public static String getBanker4Offer2() {
        if (Objects.equals(BANKER_4_OFFER_2.get(), BANKER_4_OFFER_2.getDefault())) {
            return BANKER_4_OFFER_2.getDefault();
        }
        else {
            return BANKER_4_OFFER_2.get();
        }
    }
    public static String getBanker4Request2() {
        if (Objects.equals(BANKER_4_REQUEST_2.get(), BANKER_4_REQUEST_2.getDefault())) {
            return BANKER_4_REQUEST_2.getDefault();
        }
        else {
            return BANKER_4_REQUEST_2.get();
        }
    }
    public static String getBanker4Offer1() {
        if (Objects.equals(BANKER_4_OFFER_1.get(), BANKER_4_OFFER_1.getDefault())) {
            return BANKER_4_OFFER_1.getDefault();
        }
        else {
            return BANKER_4_OFFER_1.get();
        }
    }
    public static String getBanker4Request1() {
        if (Objects.equals(BANKER_4_REQUEST_1.get(), BANKER_4_REQUEST_1.getDefault())) {
            return BANKER_4_REQUEST_1.getDefault();
        }
        else {
            return BANKER_4_REQUEST_1.get();
        }
    }
    public static String getBanker3Offer2() {
        if (Objects.equals(BANKER_3_OFFER_2.get(), BANKER_3_OFFER_2.getDefault())) {
            return BANKER_3_OFFER_2.getDefault();
        }
        else {
            return BANKER_3_OFFER_2.get();
        }
    }
    public static String getBanker3Request2() {
        if (Objects.equals(BANKER_3_REQUEST_2.get(), BANKER_3_REQUEST_2.getDefault())) {
            return BANKER_3_REQUEST_2.getDefault();
        }
        else {
            return BANKER_3_REQUEST_2.get();
        }
    }
    public static String getBanker3Offer1() {
        if (Objects.equals(BANKER_3_OFFER_1.get(), BANKER_3_OFFER_1.getDefault())) {
            return BANKER_3_OFFER_1.getDefault();
        }
        else {
            return BANKER_3_OFFER_1.get();
        }
    }
    public static String getBanker3Request1() {
        if (Objects.equals(BANKER_3_REQUEST_1.get(), BANKER_3_REQUEST_1.getDefault())) {
            return BANKER_3_REQUEST_1.getDefault();
        }
        else {
            return BANKER_3_REQUEST_1.get();
        }
    }
    public static String getBanker2Offer2() {
        if (Objects.equals(BANKER_2_OFFER_2.get(), BANKER_2_OFFER_2.getDefault())) {
            return BANKER_2_OFFER_2.getDefault();
        }
        else {
            return BANKER_2_OFFER_2.get();
        }
    }
    public static String getBanker2Request2() {
        if (Objects.equals(BANKER_2_REQUEST_2.get(), BANKER_2_REQUEST_2.getDefault())) {
            return BANKER_2_REQUEST_2.getDefault();
        }
        else {
            return BANKER_2_REQUEST_2.get();
        }
    }
    public static String getBanker2Offer1() {
        if (Objects.equals(BANKER_2_OFFER_1.get(), BANKER_2_OFFER_1.getDefault())) {
            return BANKER_2_OFFER_1.getDefault();
        }
        else {
            return BANKER_2_OFFER_1.get();
        }
    }
    public static String getBanker2Request1() {
        if (Objects.equals(BANKER_2_REQUEST_1.get(), BANKER_2_REQUEST_1.getDefault())) {
            return BANKER_2_REQUEST_1.getDefault();
        }
        else {
            return BANKER_2_REQUEST_1.get();
        }
    }
    public static String getBanker1Offer2() {
        if (Objects.equals(BANKER_1_OFFER_2.get(), BANKER_1_OFFER_2.getDefault())) {
            return BANKER_1_OFFER_2.getDefault();
        }
        else {
            return BANKER_1_OFFER_2.get();
        }
    }
    public static String getBanker1Request2() {
        if (Objects.equals(BANKER_1_REQUEST_2.get(), BANKER_1_REQUEST_2.getDefault())) {
            return BANKER_1_REQUEST_2.getDefault();
        }
        else {
            return BANKER_1_REQUEST_2.get();
        }
    }
    public static String getBanker1Offer1() {
        if (Objects.equals(BANKER_1_OFFER_1.get(), BANKER_1_OFFER_1.getDefault())) {
            return BANKER_1_OFFER_1.getDefault();
        }
        else {
            return BANKER_1_OFFER_1.get();
        }
    }
    public static String getBanker1Request1() {
        if (Objects.equals(BANKER_1_REQUEST_1.get(), BANKER_1_REQUEST_1.getDefault())) {
            return BANKER_1_REQUEST_1.getDefault();
        }
        else {
            return BANKER_1_REQUEST_1.get();
        }
    }
}