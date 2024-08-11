package com.github.warrentode.todecoins.config.trades.friendsandfoes;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BeekeeperTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Beekeeper Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BEEKEEPER_4_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BEEKEEPER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_5_OFFER_2;

    static {
        // BEEKEEPER TRADES
        BUILDER.push("Beekeeper Trade Settings");
        // level 1
        BUILDER.push("Beekeeper Level One Trade One");
        BEEKEEPER_1_REQUEST_1 = BUILDER
                .comment(" Beekeeper 1 Trade Request 1 Table")
                .define("beekeeper_1_trade_request_1_table",
                        TradeLootTables.FLOWER_BUY_TABLE.toString());
        BEEKEEPER_1_OFFER_1 = BUILDER
                .comment(" Beekeeper 1 Trade Offer 1 Table")
                .define("beekeeper_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level One Trade Two");
        BEEKEEPER_1_REQUEST_2 = BUILDER
                .comment(" Beekeeper 1 Trade Request 2 Table")
                .define("beekeeper_1_trade_request_2_table",
                        TradeLootTables.GLASS_BOTTLE_TABLE.toString());
        BEEKEEPER_1_OFFER_2 = BUILDER
                .comment(" Beekeeper 1 Trade Offer 2 Table")
                .define("beekeeper_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Beekeeper Level Two Trade One");
        BEEKEEPER_2_REQUEST_1 = BUILDER
                .comment(" Beekeeper 2 Trade Request 1 Table")
                .define("beekeeper_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_2_OFFER_1 = BUILDER
                .comment(" Beekeeper 2 Trade Offer 1 Table")
                .define("beekeeper_2_trade_offer_1_table",
                        TradeLootTables.BOTTLED_HONEY_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level Two Trade Two");
        BEEKEEPER_2_REQUEST_2 = BUILDER
                .comment(" Beekeeper 2 Trade Request 2 Table")
                .define("beekeeper_2_trade_request_2_table",
                        TradeLootTables.SHEARS_TABLE.toString());
        BEEKEEPER_2_OFFER_2 = BUILDER
                .comment(" Beekeeper 2 Trade Offer 2 Table")
                .define("beekeeper_2_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Beekeeper Level Three Trade One");
        BEEKEEPER_3_REQUEST_1 = BUILDER
                .comment(" Beekeeper 3 Trade Request 1 Table")
                .define("beekeeper_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_3_OFFER_1 = BUILDER
                .comment(" Beekeeper 3 Trade Offer 1 Table")
                .define("beekeeper_3_trade_offer_1_table",
                        TradeLootTables.HONEY_BLOCK_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level Three Trade Two");
        BEEKEEPER_3_REQUEST_2 = BUILDER
                .comment(" Beekeeper 3 Trade Request 2 Table")
                .define("beekeeper_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_3_OFFER_2 = BUILDER
                .comment(" Beekeeper 3 Trade Offer 2 Table")
                .define("beekeeper_3_trade_offer_2_table",
                        TradeLootTables.HONEY_COMB_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Beekeeper Level Four Trade One");
        BEEKEEPER_4_REQUEST_1 = BUILDER
                .comment(" Beekeeper 4 Trade Request 1 Table")
                .define("beekeeper_4_trade_request_1_table",
                        TradeLootTables.TAGGED_STRING_TABLE.toString());
        BEEKEEPER_4_REQUEST_1_COUNT = BUILDER
                .define("beekeeper_4_trade_request_1_count", 16);
        BEEKEEPER_4_OFFER_1 = BUILDER
                .comment(" Beekeeper 4 Trade Offer 1 Table")
                .define("beekeeper_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level Four Trade Two");
        BEEKEEPER_4_REQUEST_2 = BUILDER
                .comment(" Beekeeper 4 Trade Request 2 Table")
                .define("beekeeper_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_4_OFFER_2 = BUILDER
                .comment(" Beekeeper 4 Trade Offer 2 Table")
                .define("beekeeper_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_CANDLE_TABLE.toString());
        BEEKEEPER_4_OFFER_2_COUNT = BUILDER
                .define("beekeeper_4_trade_offer_2_count", 4);
        BUILDER.pop();
        // level 5
        BUILDER.push("Beekeeper Level Five Trade One");
        BEEKEEPER_5_REQUEST_1 = BUILDER
                .comment(" Beekeeper 5 Trade Request 1 Table")
                .define("beekeeper_5_trade_request_1_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_5_OFFER_1 = BUILDER
                .comment(" Beekeeper 5 Trade Offer 1 Table")
                .define("beekeeper_5_trade_offer_1_table",
                        TradeLootTables.BEEHIVE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level Five Trade Two");
        BEEKEEPER_5_REQUEST_2 = BUILDER
                .comment(" Beekeeper 5 Trade Request 2 Table")
                .define("beekeeper_5_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_5_OFFER_2 = BUILDER
                .comment(" Beekeeper 5 Trade Offer 2 Table")
                .define("beekeeper_5_trade_offer_2_table",
                        TradeLootTables.BEE_EGG_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // BEEKEEPER TRADE GETTERS
    public static String getBeekeeper5Offer2() {
        if (Objects.equals(BEEKEEPER_5_OFFER_2.get(), BEEKEEPER_5_OFFER_2.getDefault())) {
            return BEEKEEPER_5_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_5_OFFER_2.get();
        }
    }
    public static String getBeekeeper5Request2() {
        if (Objects.equals(BEEKEEPER_5_REQUEST_2.get(), BEEKEEPER_5_REQUEST_2.getDefault())) {
            return BEEKEEPER_5_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_5_REQUEST_2.get();
        }
    }
    public static String getBeekeeper5Offer1() {
        if (Objects.equals(BEEKEEPER_5_OFFER_1.get(), BEEKEEPER_5_OFFER_1.getDefault())) {
            return BEEKEEPER_5_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_5_OFFER_1.get();
        }
    }
    public static String getBeekeeper5Request1() {
        if (Objects.equals(BEEKEEPER_5_REQUEST_1.get(), BEEKEEPER_5_REQUEST_1.getDefault())) {
            return BEEKEEPER_5_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_5_REQUEST_1.get();
        }
    }
    public static int getBeekeeper4Offer2Count() {
        if (Objects.equals(BEEKEEPER_4_OFFER_2_COUNT.get(), BEEKEEPER_4_OFFER_2_COUNT.getDefault())) {
            return BEEKEEPER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return BEEKEEPER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getBeekeeper4Offer2() {
        if (Objects.equals(BEEKEEPER_4_OFFER_2.get(), BEEKEEPER_4_OFFER_2.getDefault())) {
            return BEEKEEPER_4_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_4_OFFER_2.get();
        }
    }
    public static String getBeekeeper4Request2() {
        if (Objects.equals(BEEKEEPER_4_REQUEST_2.get(), BEEKEEPER_4_REQUEST_2.getDefault())) {
            return BEEKEEPER_4_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_4_REQUEST_2.get();
        }
    }
    public static String getBeekeeper4Offer1() {
        if (Objects.equals(BEEKEEPER_4_OFFER_1.get(), BEEKEEPER_4_OFFER_1.getDefault())) {
            return BEEKEEPER_4_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_4_OFFER_1.get();
        }
    }
    public static int getBeekeeper4Request1Count() {
        if (Objects.equals(BEEKEEPER_4_REQUEST_1_COUNT.get(), BEEKEEPER_4_REQUEST_1_COUNT.getDefault())) {
            return BEEKEEPER_4_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BEEKEEPER_4_REQUEST_1_COUNT.get();
        }
    }
    public static String getBeekeeper4Request1() {
        if (Objects.equals(BEEKEEPER_4_REQUEST_1.get(), BEEKEEPER_4_REQUEST_1.getDefault())) {
            return BEEKEEPER_4_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_4_REQUEST_1.get();
        }
    }
    public static String getBeekeeper3Offer2() {
        if (Objects.equals(BEEKEEPER_3_OFFER_2.get(), BEEKEEPER_3_OFFER_2.getDefault())) {
            return BEEKEEPER_3_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_3_OFFER_2.get();
        }
    }
    public static String getBeekeeper3Request2() {
        if (Objects.equals(BEEKEEPER_3_REQUEST_2.get(), BEEKEEPER_3_REQUEST_2.getDefault())) {
            return BEEKEEPER_3_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_3_REQUEST_2.get();
        }
    }
    public static String getBeekeeper3Offer1() {
        if (Objects.equals(BEEKEEPER_3_OFFER_1.get(), BEEKEEPER_3_OFFER_1.getDefault())) {
            return BEEKEEPER_3_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_3_OFFER_1.get();
        }
    }
    public static String getBeekeeper3Request1() {
        if (Objects.equals(BEEKEEPER_3_REQUEST_1.get(), BEEKEEPER_3_REQUEST_1.getDefault())) {
            return BEEKEEPER_3_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_3_REQUEST_1.get();
        }
    }
    public static String getBeekeeper2Offer2() {
        if (Objects.equals(BEEKEEPER_2_OFFER_2.get(), BEEKEEPER_2_OFFER_2.getDefault())) {
            return BEEKEEPER_2_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_2_OFFER_2.get();
        }
    }
    public static String getBeekeeper2Request2() {
        if (Objects.equals(BEEKEEPER_2_REQUEST_2.get(), BEEKEEPER_2_REQUEST_2.getDefault())) {
            return BEEKEEPER_2_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_2_REQUEST_2.get();
        }
    }
    public static String getBeekeeper2Offer1() {
        if (Objects.equals(BEEKEEPER_2_OFFER_1.get(), BEEKEEPER_2_OFFER_1.getDefault())) {
            return BEEKEEPER_2_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_2_OFFER_1.get();
        }
    }
    public static String getBeekeeper2Request1() {
        if (Objects.equals(BEEKEEPER_2_REQUEST_1.get(), BEEKEEPER_2_REQUEST_1.getDefault())) {
            return BEEKEEPER_2_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_2_REQUEST_1.get();
        }
    }
    public static String getBeekeeper1Offer2() {
        if (Objects.equals(BEEKEEPER_1_OFFER_2.get(), BEEKEEPER_1_OFFER_2.getDefault())) {
            return BEEKEEPER_1_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_1_OFFER_2.get();
        }
    }
    public static String getBeekeeper1Request2() {
        if (Objects.equals(BEEKEEPER_1_REQUEST_2.get(), BEEKEEPER_1_REQUEST_2.getDefault())) {
            return BEEKEEPER_1_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_1_REQUEST_2.get();
        }
    }
    public static String getBeekeeper1Offer1() {
        if (Objects.equals(BEEKEEPER_1_OFFER_1.get(), BEEKEEPER_1_OFFER_1.getDefault())) {
            return BEEKEEPER_1_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_1_OFFER_1.get();
        }
    }
    public static String getBeekeeper1Request1() {
        if (Objects.equals(BEEKEEPER_1_REQUEST_1.get(), BEEKEEPER_1_REQUEST_1.getDefault())) {
            return BEEKEEPER_1_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_1_REQUEST_1.get();
        }
    }
}