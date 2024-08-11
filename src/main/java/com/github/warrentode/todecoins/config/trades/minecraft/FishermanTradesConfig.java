package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FishermanTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Fisherman Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_1_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_2_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_4_REQUEST_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_5_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_5_OFFER_2;

    static {
        // FISHERMAN TRADES
        BUILDER.push("Fisherman Trade Settings");
        // level 1
        BUILDER.push("Fisherman Level One Trade One");
        FISHERMAN_1_REQUEST_1 = BUILDER
                .comment(" Fisherman 1 Trade Request 1 Table")
                .define("fisherman_1_trade_request_1_table",
                        TradeLootTables.TAGGED_STRING_TABLE.toString());
        FISHERMAN_1_REQUEST_1_COUNT = BUILDER
                .define("fisherman_1_trade_request_1_count", 16);
        FISHERMAN_1_OFFER_1 = BUILDER
                .comment(" Fisherman 1 Trade Offer 1 Table")
                .define("fisherman_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level One Trade Two");
        FISHERMAN_1_REQUEST_2 = BUILDER
                .comment(" Fisherman 1 Trade Request 2 Table")
                .define("fisherman_1_trade_request_2_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        FISHERMAN_1_OFFER_2 = BUILDER
                .comment(" Fisherman 1 Trade Offer 2 Table")
                .define("fisherman_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level One Trade Three");
        FISHERMAN_1_REQUEST_3 = BUILDER
                .comment(" Fisherman 1 Trade Request 3 Table")
                .define("fisherman_1_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_1_OFFER_3 = BUILDER
                .comment(" Fisherman 1 Trade Offer 3 Table")
                .define("fisherman_1_trade_offer_3_table",
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE.toString());
        FISHERMAN_1_OFFER_3_COUNT = BUILDER
                .define("fisherman_1_trade_offer_3_count", 6);
        BUILDER.pop();
        BUILDER.push("Fisherman Level One Trade Four")
                .comment(" Rare Trade");
        FISHERMAN_1_REQUEST_4 = BUILDER
                .comment(" Fisherman 1 Trade Request 4 Table")
                .define("fisherman_1_trade_request_4_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_1_OFFER_4 = BUILDER
                .comment(" Fisherman 1 Trade Offer 4 Table")
                .define("fisherman_1_trade_offer_4_table",
                        TradeLootTables.FISH_BUCKET_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Fisherman Level Two Trade One");
        FISHERMAN_2_REQUEST_1 = BUILDER
                .comment(" Fisherman 2 Trade Request 1 Table")
                .define("fisherman_2_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        FISHERMAN_2_REQUEST_1_COUNT = BUILDER
                .define("fisherman_2_trade_request_1_count", 6);
        FISHERMAN_2_OFFER_1 = BUILDER
                .comment(" Fisherman 2 Trade Offer 1 Table")
                .define("fisherman_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level Two Trade Three");
        FISHERMAN_2_REQUEST_2 = BUILDER
                .comment(" Fisherman 2 Trade Request 2 Table")
                .define("fisherman_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_2_OFFER_2 = BUILDER
                .comment(" Fisherman 2 Trade Offer 2 Table")
                .define("fisherman_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE.toString());
        FISHERMAN_2_OFFER_2_COUNT = BUILDER
                .define("fisherman_2_trade_offer_2_count", 6);
        BUILDER.pop();
        BUILDER.push("Fisherman Level Two Trade Three");
        FISHERMAN_2_REQUEST_3 = BUILDER
                .comment(" Fisherman 2 Trade Request 3 Table")
                .define("fisherman_2_trade_request_3_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_2_OFFER_3 = BUILDER
                .comment(" Fisherman 2 Trade Offer 3 Table")
                .define("fisherman_2_trade_offer_3_table",
                        TradeLootTables.CAMPFIRE_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Fisherman Level Three Trade One");
        FISHERMAN_3_REQUEST_1 = BUILDER
                .comment(" Fisherman 3 Trade Request 1 Table")
                .define("fisherman_3_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        FISHERMAN_3_REQUEST_1_COUNT = BUILDER
                .define("fisherman_3_trade_request_1_count", 6);
        FISHERMAN_3_OFFER_1 = BUILDER
                .comment(" Fisherman 3 Trade Offer 1 Table")
                .define("fisherman_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level Three Trade Two");
        FISHERMAN_3_REQUEST_2 = BUILDER
                .comment(" Fisherman 3 Trade Request 2 Table")
                .define("fisherman_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_3_OFFER_2 = BUILDER
                .comment(" Fisherman 3 Trade Offer 2 Table")
                .define("fisherman_3_trade_offer_2_table",
                        TradeLootTables.FISHING_GEAR_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Fisherman Level Four Trade One");
        FISHERMAN_4_REQUEST_1 = BUILDER
                .comment(" Fisherman 4 Trade Request 1 Table")
                .define("fisherman_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_4_OFFER_1 = BUILDER
                .comment(" Fisherman 4 Trade Offer 1 Table")
                .comment(" Available if Supplementaries or Turtle Block Academy mod is Loaded")
                .define("fisherman_4_trade_offer_1_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        FISHERMAN_4_OFFER_1_COUNT = BUILDER
                .define("fisherman_4_trade_offer_1_count", 18);
        BUILDER.pop();
        BUILDER.push("Fisherman Level Four Trade Two")
                .comment(" Rare Trade");
        FISHERMAN_4_REQUEST_2 = BUILDER
                .comment(" Fisherman 4 Trade Request 2 Table")
                .define("fisherman_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_4_OFFER_2 = BUILDER
                .comment(" Fisherman 4 Trade Offer 2 Table")
                .define("fisherman_4_trade_offer_2_table",
                        TradeLootTables.FISHING_ROD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level Four Trade Three");
        FISHERMAN_4_REQUEST_3 = BUILDER
                .comment(" Fisherman 4 Trade Request 3 Table")
                .define("fisherman_4_trade_request_3_table",
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        FISHERMAN_4_REQUEST_3_COUNT = BUILDER
                .define("fisherman_4_trade_request_3_count", 6);
        FISHERMAN_4_OFFER_3 = BUILDER
                .comment(" Fisherman 4 Trade Offer 3 Table")
                .define("fisherman_4_trade_offer_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Fisherman Level Five Trade One");
        FISHERMAN_5_REQUEST_1 = BUILDER
                .comment(" Fisherman 5 Trade Request 1 Table")
                .define("fisherman_5_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        FISHERMAN_5_REQUEST_1_COUNT = BUILDER
                .define("fisherman_5_trade_request_1_count", 6);
        FISHERMAN_5_OFFER_1 = BUILDER
                .comment(" Fisherman 5 Trade Offer 1 Table")
                .define("fisherman_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level Five Trade Two");
        FISHERMAN_5_REQUEST_2 = BUILDER
                .comment(" Fisherman 5 Trade Request 2 Table")
                .define("fisherman_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_5_OFFER_2 = BUILDER
                .comment(" Fisherman 5 Trade Offer 2 Table")
                .define("fisherman_5_trade_offer_2_table",
                        TradeLootTables.FISHING_GEAR_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // FISHERMAN TRADE GETTERS
    public static String getFisherman5Offer2() {
        if (Objects.equals(FISHERMAN_5_OFFER_2.get(), FISHERMAN_5_OFFER_2.getDefault())) {
            return FISHERMAN_5_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_5_OFFER_2.get();
        }
    }
    public static String getFisherman5Request2() {
        if (Objects.equals(FISHERMAN_5_REQUEST_2.get(), FISHERMAN_5_REQUEST_2.getDefault())) {
            return FISHERMAN_5_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_5_REQUEST_2.get();
        }
    }
    public static String getFisherman5Offer1() {
        if (Objects.equals(FISHERMAN_5_OFFER_1.get(), FISHERMAN_5_OFFER_1.getDefault())) {
            return FISHERMAN_5_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_5_OFFER_1.get();
        }
    }
    public static int getFisherman5Request1Count() {
        if (Objects.equals(FISHERMAN_5_REQUEST_1_COUNT.get(), FISHERMAN_5_REQUEST_1_COUNT.getDefault())) {
            return FISHERMAN_5_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_5_REQUEST_1_COUNT.get();
        }
    }
    public static String getFisherman5Request1() {
        if (Objects.equals(FISHERMAN_5_REQUEST_1.get(), FISHERMAN_5_REQUEST_1.getDefault())) {
            return FISHERMAN_5_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_5_REQUEST_1.get();
        }
    }
    public static String getFisherman4Offer3() {
        if (Objects.equals(FISHERMAN_4_OFFER_3.get(), FISHERMAN_4_OFFER_3.getDefault())) {
            return FISHERMAN_4_OFFER_3.getDefault();
        }
        else {
            return FISHERMAN_4_OFFER_3.get();
        }
    }
    public static int getFisherman4Request3Count() {
        if (Objects.equals(FISHERMAN_4_REQUEST_3_COUNT.get(), FISHERMAN_4_REQUEST_3_COUNT.getDefault())) {
            return FISHERMAN_4_REQUEST_3_COUNT.getDefault();
        }
        else {
            return FISHERMAN_4_REQUEST_3_COUNT.get();
        }
    }
    public static String getFisherman4Request3() {
        if (Objects.equals(FISHERMAN_4_REQUEST_3.get(), FISHERMAN_4_REQUEST_3.getDefault())) {
            return FISHERMAN_4_REQUEST_3.getDefault();
        }
        else {
            return FISHERMAN_4_REQUEST_3.get();
        }
    }
    public static String getFisherman4Offer2() {
        if (Objects.equals(FISHERMAN_4_OFFER_2.get(), FISHERMAN_4_OFFER_2.getDefault())) {
            return FISHERMAN_4_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_4_OFFER_2.get();
        }
    }
    public static String getFisherman4Request2() {
        if (Objects.equals(FISHERMAN_4_REQUEST_2.get(), FISHERMAN_4_REQUEST_2.getDefault())) {
            return FISHERMAN_4_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_4_REQUEST_2.get();
        }
    }
    public static int getFisherman4Offer1Count() {
        if (Objects.equals(FISHERMAN_4_OFFER_1_COUNT.get(), FISHERMAN_4_OFFER_1_COUNT.getDefault())) {
            return FISHERMAN_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_4_OFFER_1_COUNT.get();
        }
    }
    public static String getFisherman4Offer1() {
        if (Objects.equals(FISHERMAN_4_OFFER_1.get(), FISHERMAN_4_OFFER_1.getDefault())) {
            return FISHERMAN_4_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_4_OFFER_1.get();
        }
    }
    public static String getFisherman4Request1() {
        if (Objects.equals(FISHERMAN_4_REQUEST_1.get(), FISHERMAN_4_REQUEST_1.getDefault())) {
            return FISHERMAN_4_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_4_REQUEST_1.get();
        }
    }
    public static String getFisherman3Offer2() {
        if (Objects.equals(FISHERMAN_3_OFFER_2.get(), FISHERMAN_3_OFFER_2.getDefault())) {
            return FISHERMAN_3_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_3_OFFER_2.get();
        }
    }
    public static String getFisherman3Request2() {
        if (Objects.equals(FISHERMAN_3_REQUEST_2.get(), FISHERMAN_3_REQUEST_2.getDefault())) {
            return FISHERMAN_3_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_3_REQUEST_2.get();
        }
    }
    public static String getFisherman3Offer1() {
        if (Objects.equals(FISHERMAN_3_OFFER_1.get(), FISHERMAN_3_OFFER_1.getDefault())) {
            return FISHERMAN_3_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_3_OFFER_1.get();
        }
    }
    public static int getFisherman3Request1Count() {
        if (Objects.equals(FISHERMAN_3_REQUEST_1_COUNT.get(), FISHERMAN_3_REQUEST_1_COUNT.getDefault())) {
            return FISHERMAN_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getFisherman3Request1() {
        if (Objects.equals(FISHERMAN_3_REQUEST_1.get(), FISHERMAN_3_REQUEST_1.getDefault())) {
            return FISHERMAN_3_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_3_REQUEST_1.get();
        }
    }
    public static String getFisherman2Offer3() {
        if (Objects.equals(FISHERMAN_2_OFFER_3.get(), FISHERMAN_2_OFFER_3.getDefault())) {
            return FISHERMAN_2_OFFER_3.getDefault();
        }
        else {
            return FISHERMAN_2_OFFER_3.get();
        }
    }
    public static String getFisherman2Request3() {
        if (Objects.equals(FISHERMAN_2_REQUEST_3.get(), FISHERMAN_2_REQUEST_3.getDefault())) {
            return FISHERMAN_2_REQUEST_3.getDefault();
        }
        else {
            return FISHERMAN_2_REQUEST_3.get();
        }
    }
    public static int getFisherman2Offer2Count() {
        if (Objects.equals(FISHERMAN_2_OFFER_2_COUNT.get(), FISHERMAN_2_OFFER_2_COUNT.getDefault())) {
            return FISHERMAN_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return FISHERMAN_2_OFFER_2_COUNT.get();
        }
    }
    public static String getFisherman2Offer2() {
        if (Objects.equals(FISHERMAN_2_OFFER_2.get(), FISHERMAN_2_OFFER_2.getDefault())) {
            return FISHERMAN_2_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_2_OFFER_2.get();
        }
    }
    public static String getFisherman2Request2() {
        if (Objects.equals(FISHERMAN_2_REQUEST_2.get(), FISHERMAN_2_REQUEST_2.getDefault())) {
            return FISHERMAN_2_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_2_REQUEST_2.get();
        }
    }
    public static String getFisherman2Offer1() {
        if (Objects.equals(FISHERMAN_2_OFFER_1.get(), FISHERMAN_2_OFFER_1.getDefault())) {
            return FISHERMAN_2_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_2_OFFER_1.get();
        }
    }
    public static int getFisherman2Request1Count() {
        if (Objects.equals(FISHERMAN_2_REQUEST_1_COUNT.get(), FISHERMAN_2_REQUEST_1_COUNT.getDefault())) {
            return FISHERMAN_2_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_2_REQUEST_1_COUNT.get();
        }
    }
    public static String getFisherman2Request1() {
        if (Objects.equals(FISHERMAN_2_REQUEST_1.get(), FISHERMAN_2_REQUEST_1.getDefault())) {
            return FISHERMAN_2_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_2_REQUEST_1.get();
        }
    }
    public static String getFisherman1Offer4() {
        if (Objects.equals(FISHERMAN_1_OFFER_4.get(), FISHERMAN_1_OFFER_4.getDefault())) {
            return FISHERMAN_1_OFFER_4.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_4.get();
        }
    }
    public static String getFisherman1Request4() {
        if (Objects.equals(FISHERMAN_1_REQUEST_4.get(), FISHERMAN_1_REQUEST_4.getDefault())) {
            return FISHERMAN_1_REQUEST_4.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_4.get();
        }
    }
    public static String getFisherman1Offer3() {
        if (Objects.equals(FISHERMAN_1_OFFER_3.get(), FISHERMAN_1_OFFER_3.getDefault())) {
            return FISHERMAN_1_OFFER_3.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_3.get();
        }
    }
    public static int getFisherman1Offer3Count() {
        if (Objects.equals(FISHERMAN_1_OFFER_3_COUNT.get(), FISHERMAN_1_OFFER_3_COUNT.getDefault())) {
            return FISHERMAN_1_OFFER_3_COUNT.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_3_COUNT.get();
        }
    }
    public static String getFisherman1Request3() {
        if (Objects.equals(FISHERMAN_1_REQUEST_3.get(), FISHERMAN_1_REQUEST_3.getDefault())) {
            return FISHERMAN_1_REQUEST_3.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_3.get();
        }
    }
    public static String getFisherman1Offer2() {
        if (Objects.equals(FISHERMAN_1_OFFER_2.get(), FISHERMAN_1_OFFER_2.getDefault())) {
            return FISHERMAN_1_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_2.get();
        }
    }
    public static String getFisherman1Request2() {
        if (Objects.equals(FISHERMAN_1_REQUEST_2.get(), FISHERMAN_1_REQUEST_2.getDefault())) {
            return FISHERMAN_1_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_2.get();
        }
    }
    public static String getFisherman1Offer1() {
        if (Objects.equals(FISHERMAN_1_OFFER_1.get(), FISHERMAN_1_OFFER_1.getDefault())) {
            return FISHERMAN_1_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_1.get();
        }
    }
    public static int getFisherman1Request1Count() {
        if (Objects.equals(FISHERMAN_1_REQUEST_1_COUNT.get(), FISHERMAN_1_REQUEST_1_COUNT.getDefault())) {
            return FISHERMAN_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getFisherman1Request1() {
        if (Objects.equals(FISHERMAN_1_REQUEST_1.get(), FISHERMAN_1_REQUEST_1.getDefault())) {
            return FISHERMAN_1_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_1.get();
        }
    }
}