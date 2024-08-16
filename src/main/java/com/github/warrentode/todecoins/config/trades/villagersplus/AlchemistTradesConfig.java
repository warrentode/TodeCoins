package com.github.warrentode.todecoins.config.trades.villagersplus;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AlchemistTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Alchemist Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_2_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_2_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_3_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_3_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_4_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_4_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ALCHEMIST_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> ALCHEMIST_5_REQUEST_1_DURATION;

    static {
        // ALCHEMIST TRADES
        BUILDER.push("Alchemist Trade Settings");
        // level 1
        BUILDER.push("Alchemist Level One Trade One");
        ALCHEMIST_1_REQUEST_1 = BUILDER
                .comment(" Alchemist 1 Trade Request 1 Table")
                .define("alchemist_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_1_OFFER_1 = BUILDER
                .comment(" Alchemist 1 Trade Offer 1 Table")
                .define("alchemist_1_trade_offer_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level One Trade Two");
        ALCHEMIST_1_REQUEST_2 = BUILDER
                .comment(" Alchemist 1 Trade Request 2 Table")
                .define("alchemist_1_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_1_OFFER_2 = BUILDER
                .comment(" Alchemist 1 Trade Offer 2 Table")
                .define("alchemist_1_trade_offer_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level One Trade Three");
        ALCHEMIST_1_REQUEST_3 = BUILDER
                .comment(" Alchemist 1 Trade Request 3 Table")
                .define("alchemist_1_trade_request_3_table",
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_1_OFFER_3 = BUILDER
                .comment(" Alchemist 1 Trade Offer 2 Table")
                .define("alchemist_1_trade_offer_2_table",
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level One Trade Four");
        ALCHEMIST_1_REQUEST_4 = BUILDER
                .comment(" Alchemist 1 Trade Request 4 Table")
                .define("alchemist_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_1_OFFER_4 = BUILDER
                .comment(" Alchemist 1 Trade Offer 4 Table")
                .define("alchemist_1_trade_offer_4_table",
                        TradeLootTables.GLASS_BOTTLE_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Alchemist Level Two Trade One");
        ALCHEMIST_2_REQUEST_1 = BUILDER
                .comment(" Alchemist 2 Trade Request 1 Table")
                .define("alchemist_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_2_OFFER_1 = BUILDER
                .comment(" Alchemist 2 Trade Offer 1 Table")
                .define("alchemist_2_trade_offer_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level Two Trade Two");
        ALCHEMIST_2_REQUEST_2 = BUILDER
                .comment(" Alchemist 2 Trade Request 2 Table")
                .define("alchemist_2_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_2_OFFER_2 = BUILDER
                .comment(" Alchemist 2 Trade Offer 2 Table")
                .define("alchemist_2_trade_offer_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level Two Trade Three");
        ALCHEMIST_2_REQUEST_3 = BUILDER
                .comment(" Alchemist 2 Trade Request 3 Table")
                .define("alchemist_2_trade_request_3_table",
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_2_OFFER_3 = BUILDER
                .comment(" Alchemist 2 Trade Offer 2 Table")
                .define("alchemist_2_trade_offer_2_table",
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level Two Trade Four");
        ALCHEMIST_2_REQUEST_4 = BUILDER
                .comment(" Alchemist 2 Trade Request 4 Table")
                .define("alchemist_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_2_OFFER_4 = BUILDER
                .comment(" Alchemist 2 Trade Offer 4 Table")
                .define("alchemist_2_trade_offer_4_table",
                        TradeLootTables.GLASS_BOTTLE_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Alchemist Level Three Trade One");
        ALCHEMIST_3_REQUEST_1 = BUILDER
                .comment(" Alchemist 3 Trade Request 1 Table")
                .define("alchemist_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_3_OFFER_1 = BUILDER
                .comment(" Alchemist 3 Trade Offer 1 Table")
                .define("alchemist_3_trade_offer_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level Three Trade Two");
        ALCHEMIST_3_REQUEST_2 = BUILDER
                .comment(" Alchemist 3 Trade Request 2 Table")
                .define("alchemist_3_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_3_OFFER_2 = BUILDER
                .comment(" Alchemist 3 Trade Offer 2 Table")
                .define("alchemist_3_trade_offer_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level Three Trade Three");
        ALCHEMIST_3_REQUEST_3 = BUILDER
                .comment(" Alchemist 3 Trade Request 3 Table")
                .define("alchemist_3_trade_request_3_table",
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_3_OFFER_3 = BUILDER
                .comment(" Alchemist 3 Trade Offer 2 Table")
                .define("alchemist_3_trade_offer_2_table",
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level Three Trade Four");
        ALCHEMIST_3_REQUEST_4 = BUILDER
                .comment(" Alchemist 3 Trade Request 4 Table")
                .define("alchemist_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_3_OFFER_4 = BUILDER
                .comment(" Alchemist 3 Trade Offer 4 Table")
                .define("alchemist_3_trade_offer_4_table",
                        TradeLootTables.GLASS_BOTTLE_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Alchemist Level Four Trade One");
        ALCHEMIST_4_REQUEST_1 = BUILDER
                .comment(" Alchemist 4 Trade Request 1 Table")
                .define("alchemist_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_4_OFFER_1 = BUILDER
                .comment(" Alchemist 4 Trade Offer 1 Table")
                .define("alchemist_4_trade_offer_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level Four Trade Two");
        ALCHEMIST_4_REQUEST_2 = BUILDER
                .comment(" Alchemist 4 Trade Request 2 Table")
                .define("alchemist_4_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_4_OFFER_2 = BUILDER
                .comment(" Alchemist 4 Trade Offer 2 Table")
                .define("alchemist_4_trade_offer_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level Four Trade Three");
        ALCHEMIST_4_REQUEST_3 = BUILDER
                .comment(" Alchemist 4 Trade Request 3 Table")
                .define("alchemist_4_trade_request_3_table",
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_4_OFFER_3 = BUILDER
                .comment(" Alchemist 4 Trade Offer 2 Table")
                .define("alchemist_4_trade_offer_2_table",
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Alchemist Level Four Trade Four");
        ALCHEMIST_4_REQUEST_4 = BUILDER
                .comment(" Alchemist 4 Trade Request 4 Table")
                .define("alchemist_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ALCHEMIST_4_OFFER_4 = BUILDER
                .comment(" Alchemist 4 Trade Offer 4 Table")
                .define("alchemist_4_trade_offer_4_table",
                        TradeLootTables.GLASS_BOTTLE_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Alchemist Level Five Potion Trade")
                .comment(" All Level Five Trades are This")
                .comment(" All Potion Effects Added");
        ALCHEMIST_5_REQUEST_1 = BUILDER
                .comment(" Alchemist 5 Trade Request 1 Table")
                .define("alchemist_5_trade_request_1_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        ALCHEMIST_5_REQUEST_1_DURATION = BUILDER
                .define("potion_duration", 300);
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // ALCHEMIST TRADE GETTERS
    public static int getAlchemist5Request1Duration() {
        if (Objects.equals(ALCHEMIST_5_REQUEST_1_DURATION.get(), ALCHEMIST_5_REQUEST_1_DURATION.getDefault())) {
            return ALCHEMIST_5_REQUEST_1_DURATION.getDefault();
        }
        else {
            return ALCHEMIST_5_REQUEST_1_DURATION.get();
        }
    }
    public static String getAlchemist5Request1() {
        if (Objects.equals(ALCHEMIST_5_REQUEST_1.get(), ALCHEMIST_5_REQUEST_1.getDefault())) {
            return ALCHEMIST_5_REQUEST_1.getDefault();
        }
        else {
            return ALCHEMIST_5_REQUEST_1.get();
        }
    }
    public static String getAlchemist4Offer4() {
        if (Objects.equals(ALCHEMIST_4_OFFER_4.get(), ALCHEMIST_4_OFFER_4.getDefault())) {
            return ALCHEMIST_4_OFFER_4.getDefault();
        }
        else {
            return ALCHEMIST_4_OFFER_4.get();
        }
    }
    public static String getAlchemist4Request4() {
        if (Objects.equals(ALCHEMIST_4_REQUEST_4.get(), ALCHEMIST_4_REQUEST_4.getDefault())) {
            return ALCHEMIST_4_REQUEST_4.getDefault();
        }
        else {
            return ALCHEMIST_4_REQUEST_4.get();
        }
    }
    public static String getAlchemist4Offer3() {
        if (Objects.equals(ALCHEMIST_4_OFFER_3.get(), ALCHEMIST_4_OFFER_3.getDefault())) {
            return ALCHEMIST_4_OFFER_3.getDefault();
        }
        else {
            return ALCHEMIST_4_OFFER_3.get();
        }
    }
    public static String getAlchemist4Request3() {
        if (Objects.equals(ALCHEMIST_4_REQUEST_3.get(), ALCHEMIST_4_REQUEST_3.getDefault())) {
            return ALCHEMIST_4_REQUEST_3.getDefault();
        }
        else {
            return ALCHEMIST_4_REQUEST_3.get();
        }
    }
    public static String getAlchemist4Offer2() {
        if (Objects.equals(ALCHEMIST_4_OFFER_2.get(), ALCHEMIST_4_OFFER_2.getDefault())) {
            return ALCHEMIST_4_OFFER_2.getDefault();
        }
        else {
            return ALCHEMIST_4_OFFER_2.get();
        }
    }
    public static String getAlchemist4Request2() {
        if (Objects.equals(ALCHEMIST_4_REQUEST_2.get(), ALCHEMIST_4_REQUEST_2.getDefault())) {
            return ALCHEMIST_4_REQUEST_2.getDefault();
        }
        else {
            return ALCHEMIST_4_REQUEST_2.get();
        }
    }
    public static String getAlchemist4Offer1() {
        if (Objects.equals(ALCHEMIST_4_OFFER_1.get(), ALCHEMIST_4_OFFER_1.getDefault())) {
            return ALCHEMIST_4_OFFER_1.getDefault();
        }
        else {
            return ALCHEMIST_4_OFFER_1.get();
        }
    }
    public static String getAlchemist4Request1() {
        if (Objects.equals(ALCHEMIST_4_REQUEST_1.get(), ALCHEMIST_4_REQUEST_1.getDefault())) {
            return ALCHEMIST_4_REQUEST_1.getDefault();
        }
        else {
            return ALCHEMIST_4_REQUEST_1.get();
        }
    }
    public static String getAlchemist3Offer4() {
        if (Objects.equals(ALCHEMIST_3_OFFER_4.get(), ALCHEMIST_3_OFFER_4.getDefault())) {
            return ALCHEMIST_3_OFFER_3.getDefault();
        }
        else {
            return ALCHEMIST_3_OFFER_4.get();
        }
    }
    public static String getAlchemist3Request4() {
        if (Objects.equals(ALCHEMIST_3_REQUEST_4.get(), ALCHEMIST_3_REQUEST_4.getDefault())) {
            return ALCHEMIST_3_REQUEST_4.getDefault();
        }
        else {
            return ALCHEMIST_3_REQUEST_4.get();
        }
    }
    public static String getAlchemist3Offer3() {
        if (Objects.equals(ALCHEMIST_3_OFFER_3.get(), ALCHEMIST_3_OFFER_3.getDefault())) {
            return ALCHEMIST_3_OFFER_3.getDefault();
        }
        else {
            return ALCHEMIST_3_OFFER_3.get();
        }
    }
    public static String getAlchemist3Request3() {
        if (Objects.equals(ALCHEMIST_3_REQUEST_3.get(), ALCHEMIST_3_REQUEST_3.getDefault())) {
            return ALCHEMIST_3_REQUEST_3.getDefault();
        }
        else {
            return ALCHEMIST_3_REQUEST_3.get();
        }
    }
    public static String getAlchemist3Offer2() {
        if (Objects.equals(ALCHEMIST_3_OFFER_2.get(), ALCHEMIST_3_OFFER_2.getDefault())) {
            return ALCHEMIST_3_OFFER_2.getDefault();
        }
        else {
            return ALCHEMIST_3_OFFER_2.get();
        }
    }
    public static String getAlchemist3Request2() {
        if (Objects.equals(ALCHEMIST_3_REQUEST_2.get(), ALCHEMIST_3_REQUEST_2.getDefault())) {
            return ALCHEMIST_3_REQUEST_2.getDefault();
        }
        else {
            return ALCHEMIST_3_REQUEST_2.get();
        }
    }
    public static String getAlchemist3Offer1() {
        if (Objects.equals(ALCHEMIST_3_OFFER_1.get(), ALCHEMIST_3_OFFER_1.getDefault())) {
            return ALCHEMIST_3_OFFER_1.getDefault();
        }
        else {
            return ALCHEMIST_3_OFFER_1.get();
        }
    }
    public static String getAlchemist3Request1() {
        if (Objects.equals(ALCHEMIST_3_REQUEST_1.get(), ALCHEMIST_3_REQUEST_1.getDefault())) {
            return ALCHEMIST_3_REQUEST_1.getDefault();
        }
        else {
            return ALCHEMIST_3_REQUEST_1.get();
        }
    }
    public static String getAlchemist2Offer4() {
        if (Objects.equals(ALCHEMIST_2_OFFER_4.get(), ALCHEMIST_2_OFFER_4.getDefault())) {
            return ALCHEMIST_2_OFFER_4.getDefault();
        }
        else {
            return ALCHEMIST_2_OFFER_4.get();
        }
    }
    public static String getAlchemist2Request4() {
        if (Objects.equals(ALCHEMIST_2_REQUEST_4.get(), ALCHEMIST_2_REQUEST_4.getDefault())) {
            return ALCHEMIST_2_REQUEST_4.getDefault();
        }
        else {
            return ALCHEMIST_2_REQUEST_4.get();
        }
    }
    public static String getAlchemist2Offer3() {
        if (Objects.equals(ALCHEMIST_2_OFFER_3.get(), ALCHEMIST_2_OFFER_3.getDefault())) {
            return ALCHEMIST_2_OFFER_3.getDefault();
        }
        else {
            return ALCHEMIST_2_OFFER_3.get();
        }
    }
    public static String getAlchemist2Request3() {
        if (Objects.equals(ALCHEMIST_2_REQUEST_3.get(), ALCHEMIST_2_REQUEST_3.getDefault())) {
            return ALCHEMIST_2_REQUEST_3.getDefault();
        }
        else {
            return ALCHEMIST_2_REQUEST_3.get();
        }
    }
    public static String getAlchemist2Offer2() {
        if (Objects.equals(ALCHEMIST_2_OFFER_2.get(), ALCHEMIST_2_OFFER_2.getDefault())) {
            return ALCHEMIST_2_OFFER_2.getDefault();
        }
        else {
            return ALCHEMIST_2_OFFER_2.get();
        }
    }
    public static String getAlchemist2Request2() {
        if (Objects.equals(ALCHEMIST_2_REQUEST_2.get(), ALCHEMIST_2_REQUEST_2.getDefault())) {
            return ALCHEMIST_2_REQUEST_2.getDefault();
        }
        else {
            return ALCHEMIST_2_REQUEST_2.get();
        }
    }
    public static String getAlchemist2Offer1() {
        if (Objects.equals(ALCHEMIST_2_OFFER_1.get(), ALCHEMIST_2_OFFER_1.getDefault())) {
            return ALCHEMIST_2_OFFER_1.getDefault();
        }
        else {
            return ALCHEMIST_2_OFFER_1.get();
        }
    }
    public static String getAlchemist2Request1() {
        if (Objects.equals(ALCHEMIST_2_REQUEST_1.get(), ALCHEMIST_2_REQUEST_1.getDefault())) {
            return ALCHEMIST_2_REQUEST_1.getDefault();
        }
        else {
            return ALCHEMIST_2_REQUEST_1.get();
        }
    }
    public static String getAlchemist1Offer4() {
        if (Objects.equals(ALCHEMIST_1_OFFER_4.get(), ALCHEMIST_1_OFFER_4.getDefault())) {
            return ALCHEMIST_1_OFFER_4.getDefault();
        }
        else {
            return ALCHEMIST_1_OFFER_4.get();
        }
    }
    public static String getAlchemist1Request4() {
        if (Objects.equals(ALCHEMIST_1_REQUEST_4.get(), ALCHEMIST_1_REQUEST_4.getDefault())) {
            return ALCHEMIST_1_REQUEST_4.getDefault();
        }
        else {
            return ALCHEMIST_1_REQUEST_4.get();
        }
    }
    public static String getAlchemist1Offer3() {
        if (Objects.equals(ALCHEMIST_1_OFFER_3.get(), ALCHEMIST_1_OFFER_3.getDefault())) {
            return ALCHEMIST_1_OFFER_3.getDefault();
        }
        else {
            return ALCHEMIST_1_OFFER_3.get();
        }
    }
    public static String getAlchemist1Request3() {
        if (Objects.equals(ALCHEMIST_1_REQUEST_3.get(), ALCHEMIST_1_REQUEST_3.getDefault())) {
            return ALCHEMIST_1_REQUEST_3.getDefault();
        }
        else {
            return ALCHEMIST_1_REQUEST_3.get();
        }
    }
    public static String getAlchemist1Offer2() {
        if (Objects.equals(ALCHEMIST_1_OFFER_2.get(), ALCHEMIST_1_OFFER_2.getDefault())) {
            return ALCHEMIST_1_OFFER_2.getDefault();
        }
        else {
            return ALCHEMIST_1_OFFER_2.get();
        }
    }
    public static String getAlchemist1Request2() {
        if (Objects.equals(ALCHEMIST_1_REQUEST_2.get(), ALCHEMIST_1_REQUEST_2.getDefault())) {
            return ALCHEMIST_1_REQUEST_2.getDefault();
        }
        else {
            return ALCHEMIST_1_REQUEST_2.get();
        }
    }
    public static String getAlchemist1Offer1() {
        if (Objects.equals(ALCHEMIST_1_OFFER_1.get(), ALCHEMIST_1_OFFER_1.getDefault())) {
            return ALCHEMIST_1_OFFER_1.getDefault();
        }
        else {
            return ALCHEMIST_1_OFFER_1.get();
        }
    }
    public static String getAlchemist1Request1() {
        if (Objects.equals(ALCHEMIST_1_REQUEST_1.get(), ALCHEMIST_1_REQUEST_1.getDefault())) {
            return ALCHEMIST_1_REQUEST_1.getDefault();
        }
        else {
            return ALCHEMIST_1_REQUEST_1.get();
        }
    }
}