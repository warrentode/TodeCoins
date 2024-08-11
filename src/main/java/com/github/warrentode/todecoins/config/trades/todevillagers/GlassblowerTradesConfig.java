package com.github.warrentode.todecoins.config.trades.todevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GlassblowerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Glassblower Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASSBLOWER_1_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASSBLOWER_1_REQUEST_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASSBLOWER_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASSBLOWER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASSBLOWER_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASSBLOWER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASSBLOWER_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> GLASSBLOWER_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLASSBLOWER_5_OFFER_2_COUNT;

    static {
        // GLASSBLOWER TRADES
        BUILDER.push("Glassblower Trade Settings");
        // level 1
        BUILDER.push("Glassblower Level One Trade One");
        GLASSBLOWER_1_REQUEST_1 = BUILDER
                .comment(" Glassblower 1 Trade Request 1 Table")
                .define("glassblower_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        GLASSBLOWER_1_OFFER_1 = BUILDER
                .comment(" Glassblower 1 Trade Offer 1 Table")
                .define("glassblower_1_trade_offer_1_table",
                        TradeLootTables.RECYCLABLE_GLASS_TAG_TABLE.toString());
        GLASSBLOWER_1_OFFER_1_COUNT = BUILDER
                .define("glassblower_1_trade_offer_1_count", 4);
        BUILDER.pop();
        BUILDER.push("Glassblower Level One Trade Two");
        GLASSBLOWER_1_REQUEST_2 = BUILDER
                .comment(" Glassblower 1 Trade Request 2 Table")
                .define("glassblower_1_trade_request_2_table",
                        TradeLootTables.SAND_TAG_TABLE.toString());
        GLASSBLOWER_1_REQUEST_2_COUNT = BUILDER
                .define("glassblower_1_trade_request_2_count", 6);
        GLASSBLOWER_1_OFFER_2 = BUILDER
                .comment(" Glassblower 1 Trade Offer 2 Table")
                .define("glassblower_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Glassblower Level One Trade Three");
        GLASSBLOWER_1_REQUEST_3 = BUILDER
                .comment(" Glassblower 1 Trade Request 3 Table")
                .define("glassblower_1_trade_request_3_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        GLASSBLOWER_1_OFFER_3 = BUILDER
                .comment(" Glassblower 1 Trade Offer 3 Table")
                .define("glassblower_1_trade_offer_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Glassblower Level Two Trade One");
        GLASSBLOWER_2_REQUEST_1 = BUILDER
                .comment(" Glassblower 2 Trade Request 1 Table")
                .define("glassblower_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        GLASSBLOWER_2_OFFER_1 = BUILDER
                .comment(" Glassblower 2 Trade Offer 1 Table")
                .define("glassblower_2_trade_offer_1_table",
                        TradeLootTables.TAGGED_GLASS_TABLE.toString());
        GLASSBLOWER_2_OFFER_1_COUNT = BUILDER
                .define("glassblower_2_trade_offer_1_count", 4);
        BUILDER.pop();
        BUILDER.push("Glassblower Level Two Trade Two");
        GLASSBLOWER_2_REQUEST_2 = BUILDER
                .comment(" Glassblower 2 Trade Request 2 Table")
                .define("glassblower_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        GLASSBLOWER_2_OFFER_2 = BUILDER
                .comment(" Glassblower 2 Trade Offer 2 Table")
                .define("glassblower_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE.toString());
        GLASSBLOWER_2_OFFER_2_COUNT = BUILDER
                .define("glassblower_2_trade_offer_2_count", 16);
        BUILDER.pop();
        BUILDER.push("Glassblower Level Two Trade Three");
        GLASSBLOWER_2_REQUEST_3 = BUILDER
                .comment(" Glassblower 2 Trade Request 3 Table")
                .define("glassblower_2_trade_request_3_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        GLASSBLOWER_2_OFFER_3 = BUILDER
                .comment(" Glassblower 2 Trade Offer 3 Table")
                .define("glassblower_2_trade_offer_3_table",
                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Glassblower Level Three Trade One");
        GLASSBLOWER_3_REQUEST_1 = BUILDER
                .comment(" Glassblower 3 Trade Request 1 Table")
                .define("glassblower_3_trade_request_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        GLASSBLOWER_3_OFFER_1 = BUILDER
                .comment(" Glassblower 3 Trade Offer 1 Table")
                .define("glassblower_3_trade_offer_1_table",
                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Glassblower Level Three Trade Two");
        GLASSBLOWER_3_REQUEST_2 = BUILDER
                .comment(" Glassblower 3 Trade Request 2 Table")
                .define("glassblower_3_trade_request_2_table",
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        GLASSBLOWER_3_OFFER_2 = BUILDER
                .comment(" Glassblower 3 Trade Offer 2 Table")
                .define("glassblower_3_trade_offer_2_table",
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Glassblower Level Four Trade One");
        GLASSBLOWER_4_REQUEST_1 = BUILDER
                .comment(" Glassblower 4 Trade Request 1 Table")
                .define("glassblower_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        GLASSBLOWER_4_OFFER_1 = BUILDER
                .comment(" Glassblower 4 Trade Offer 1 Table")
                .define("glassblower_4_trade_offer_1_table",
                        TradeLootTables.TAGGED_GLASS_TABLE.toString());
        GLASSBLOWER_4_OFFER_1_COUNT = BUILDER
                .define("glassblower_4_trade_offer_1_count", 4);
        BUILDER.pop();
        BUILDER.push("Glassblower Level Four Trade Two");
        GLASSBLOWER_4_REQUEST_2 = BUILDER
                .comment(" Glassblower 4 Trade Request 2 Table")
                .define("glassblower_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        GLASSBLOWER_4_OFFER_2 = BUILDER
                .comment(" Glassblower 4 Trade Offer 2 Table")
                .define("glassblower_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_GLASS_TABLE.toString());
        GLASSBLOWER_4_OFFER_2_COUNT = BUILDER
                .define("glassblower_4_trade_offer_2_count", 4);
        BUILDER.pop();
        // level 5
        BUILDER.push("Glassblower Level Five Trade One");
        GLASSBLOWER_5_REQUEST_1 = BUILDER
                .comment(" Glassblower 5 Trade Request 1 Table")
                .define("glassblower_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        GLASSBLOWER_5_OFFER_1 = BUILDER
                .comment(" Glassblower 5 Trade Offer 1 Table")
                .define("glassblower_5_trade_offer_1_table",
                        TradeLootTables.TAGGED_GLASS_TABLE.toString());
        GLASSBLOWER_5_OFFER_1_COUNT = BUILDER
                .define("glassblower_5_trade_offer_1_count", 4);
        BUILDER.pop();
        BUILDER.push("Glassblower Level Five Trade Two");
        GLASSBLOWER_5_REQUEST_2 = BUILDER
                .comment(" Glassblower 5 Trade Request 2 Table")
                .define("glassblower_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        GLASSBLOWER_5_OFFER_2 = BUILDER
                .comment(" Glassblower 5 Trade Offer 2 Table")
                .define("glassblower_5_trade_offer_2_table",
                        TradeLootTables.TAGGED_GLASS_TABLE.toString());
        GLASSBLOWER_5_OFFER_2_COUNT = BUILDER
                .define("glassblower_5_trade_offer_2_count", 4);
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // GLASSBLOWER TRADE GETTERS
    public static int getGlassblower5Offer2Count() {
        if (Objects.equals(GLASSBLOWER_5_OFFER_2_COUNT.get(), GLASSBLOWER_5_OFFER_2_COUNT.getDefault())) {
            return GLASSBLOWER_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return GLASSBLOWER_5_OFFER_2_COUNT.get();
        }
    }
    public static String getGlassblower5Offer2() {
        if (Objects.equals(GLASSBLOWER_5_OFFER_2.get(), GLASSBLOWER_5_OFFER_2.getDefault())) {
            return GLASSBLOWER_5_OFFER_2.getDefault();
        }
        else {
            return GLASSBLOWER_5_OFFER_2.get();
        }
    }
    public static String getGlassblower5Request2() {
        if (Objects.equals(GLASSBLOWER_5_REQUEST_2.get(), GLASSBLOWER_5_REQUEST_2.getDefault())) {
            return GLASSBLOWER_5_REQUEST_2.getDefault();
        }
        else {
            return GLASSBLOWER_5_REQUEST_2.get();
        }
    }
    public static int getGlassblower5Offer1Count() {
        if (Objects.equals(GLASSBLOWER_5_OFFER_1_COUNT.get(), GLASSBLOWER_5_OFFER_1_COUNT.getDefault())) {
            return GLASSBLOWER_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return GLASSBLOWER_5_OFFER_1_COUNT.get();
        }
    }
    public static String getGlassblower5Offer1() {
        if (Objects.equals(GLASSBLOWER_5_OFFER_1.get(), GLASSBLOWER_5_OFFER_1.getDefault())) {
            return GLASSBLOWER_5_OFFER_1.getDefault();
        }
        else {
            return GLASSBLOWER_5_OFFER_1.get();
        }
    }
    public static String getGlassblower5Request1() {
        if (Objects.equals(GLASSBLOWER_5_REQUEST_1.get(), GLASSBLOWER_5_REQUEST_1.getDefault())) {
            return GLASSBLOWER_5_REQUEST_1.getDefault();
        }
        else {
            return GLASSBLOWER_5_REQUEST_1.get();
        }
    }
    public static int getGlassblower4Offer2Count() {
        if (Objects.equals(GLASSBLOWER_4_OFFER_2_COUNT.get(), GLASSBLOWER_4_OFFER_2_COUNT.getDefault())) {
            return GLASSBLOWER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return GLASSBLOWER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getGlassblower4Offer2() {
        if (Objects.equals(GLASSBLOWER_4_OFFER_2.get(), GLASSBLOWER_4_OFFER_2.getDefault())) {
            return GLASSBLOWER_4_OFFER_2.getDefault();
        }
        else {
            return GLASSBLOWER_4_OFFER_2.get();
        }
    }
    public static String getGlassblower4Request2() {
        if (Objects.equals(GLASSBLOWER_4_REQUEST_2.get(), GLASSBLOWER_4_REQUEST_2.getDefault())) {
            return GLASSBLOWER_4_REQUEST_2.getDefault();
        }
        else {
            return GLASSBLOWER_4_REQUEST_2.get();
        }
    }
    public static int getGlassblower4Offer1Count() {
        if (Objects.equals(GLASSBLOWER_4_OFFER_1_COUNT.get(), GLASSBLOWER_4_OFFER_1_COUNT.getDefault())) {
            return GLASSBLOWER_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return GLASSBLOWER_4_OFFER_1_COUNT.get();
        }
    }
    public static String getGlassblower4Offer1() {
        if (Objects.equals(GLASSBLOWER_4_OFFER_1.get(), GLASSBLOWER_4_OFFER_1.getDefault())) {
            return GLASSBLOWER_4_OFFER_1.getDefault();
        }
        else {
            return GLASSBLOWER_4_OFFER_1.get();
        }
    }
    public static String getGlassblower4Request1() {
        if (Objects.equals(GLASSBLOWER_4_REQUEST_1.get(), GLASSBLOWER_4_REQUEST_1.getDefault())) {
            return GLASSBLOWER_4_REQUEST_1.getDefault();
        }
        else {
            return GLASSBLOWER_4_REQUEST_1.get();
        }
    }
    public static String getGlassblower3Offer2() {
        if (Objects.equals(GLASSBLOWER_3_OFFER_2.get(), GLASSBLOWER_3_OFFER_2.getDefault())) {
            return GLASSBLOWER_3_OFFER_2.getDefault();
        }
        else {
            return GLASSBLOWER_3_OFFER_2.get();
        }
    }
    public static String getGlassblower3Request2() {
        if (Objects.equals(GLASSBLOWER_3_REQUEST_2.get(), GLASSBLOWER_3_REQUEST_2.getDefault())) {
            return GLASSBLOWER_3_REQUEST_2.getDefault();
        }
        else {
            return GLASSBLOWER_3_REQUEST_2.get();
        }
    }
    public static String getGlassblower3Offer1() {
        if (Objects.equals(GLASSBLOWER_3_OFFER_1.get(), GLASSBLOWER_3_OFFER_1.getDefault())) {
            return GLASSBLOWER_3_OFFER_1.getDefault();
        }
        else {
            return GLASSBLOWER_3_OFFER_1.get();
        }
    }
    public static String getGlassblower3Request1() {
        if (Objects.equals(GLASSBLOWER_3_REQUEST_1.get(), GLASSBLOWER_3_REQUEST_1.getDefault())) {
            return GLASSBLOWER_3_REQUEST_1.getDefault();
        }
        else {
            return GLASSBLOWER_3_REQUEST_1.get();
        }
    }
    public static String getGlassblower2Offer3() {
        if (Objects.equals(GLASSBLOWER_2_OFFER_3.get(), GLASSBLOWER_2_OFFER_3.getDefault())) {
            return GLASSBLOWER_2_OFFER_3.getDefault();
        }
        else {
            return GLASSBLOWER_2_OFFER_3.get();
        }
    }
    public static String getGlassblower2Request3() {
        if (Objects.equals(GLASSBLOWER_2_REQUEST_3.get(), GLASSBLOWER_2_REQUEST_3.getDefault())) {
            return GLASSBLOWER_2_REQUEST_3.getDefault();
        }
        else {
            return GLASSBLOWER_2_REQUEST_3.get();
        }
    }
    public static int getGlassblower2Offer2Count() {
        if (Objects.equals(GLASSBLOWER_2_OFFER_2_COUNT.get(), GLASSBLOWER_2_OFFER_2_COUNT.getDefault())) {
            return GLASSBLOWER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return GLASSBLOWER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getGlassblower2Offer2() {
        if (Objects.equals(GLASSBLOWER_2_OFFER_2.get(), GLASSBLOWER_2_OFFER_2.getDefault())) {
            return GLASSBLOWER_2_OFFER_2.getDefault();
        }
        else {
            return GLASSBLOWER_2_OFFER_2.get();
        }
    }
    public static String getGlassblower2Request2() {
        if (Objects.equals(GLASSBLOWER_2_REQUEST_2.get(), GLASSBLOWER_2_REQUEST_2.getDefault())) {
            return GLASSBLOWER_2_REQUEST_2.getDefault();
        }
        else {
            return GLASSBLOWER_2_REQUEST_2.get();
        }
    }
    public static int getGlassblower2Offer1Count() {
        if (Objects.equals(GLASSBLOWER_2_OFFER_1_COUNT.get(), GLASSBLOWER_2_OFFER_1_COUNT.getDefault())) {
            return GLASSBLOWER_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return GLASSBLOWER_2_OFFER_1_COUNT.get();
        }
    }
    public static String getGlassblower2Offer1() {
        if (Objects.equals(GLASSBLOWER_2_OFFER_1.get(), GLASSBLOWER_2_OFFER_1.getDefault())) {
            return GLASSBLOWER_2_OFFER_1.getDefault();
        }
        else {
            return GLASSBLOWER_2_OFFER_1.get();
        }
    }
    public static String getGlassblower2Request1() {
        if (Objects.equals(GLASSBLOWER_2_REQUEST_1.get(), GLASSBLOWER_2_REQUEST_1.getDefault())) {
            return GLASSBLOWER_2_REQUEST_1.getDefault();
        }
        else {
            return GLASSBLOWER_2_REQUEST_1.get();
        }
    }
    public static String getGlassblower1Offer3() {
        if (Objects.equals(GLASSBLOWER_1_OFFER_3.get(), GLASSBLOWER_1_OFFER_3.getDefault())) {
            return GLASSBLOWER_1_OFFER_3.getDefault();
        }
        else {
            return GLASSBLOWER_1_OFFER_3.get();
        }
    }
    public static String getGlassblower1Request3() {
        if (Objects.equals(GLASSBLOWER_1_REQUEST_3.get(), GLASSBLOWER_1_REQUEST_3.getDefault())) {
            return GLASSBLOWER_1_REQUEST_3.getDefault();
        }
        else {
            return GLASSBLOWER_1_REQUEST_3.get();
        }
    }
    public static String getGlassblower1Offer2() {
        if (Objects.equals(GLASSBLOWER_1_OFFER_2.get(), GLASSBLOWER_1_OFFER_2.getDefault())) {
            return GLASSBLOWER_1_OFFER_2.getDefault();
        }
        else {
            return GLASSBLOWER_1_OFFER_2.get();
        }
    }
    public static int getGlassblower1Request2Count() {
        if (Objects.equals(GLASSBLOWER_1_REQUEST_2_COUNT.get(), GLASSBLOWER_1_REQUEST_2_COUNT.getDefault())) {
            return GLASSBLOWER_1_REQUEST_2_COUNT.getDefault();
        }
        else {
            return GLASSBLOWER_1_REQUEST_2_COUNT.get();
        }
    }
    public static String getGlassblower1Request2() {
        if (Objects.equals(GLASSBLOWER_1_REQUEST_2.get(), GLASSBLOWER_1_REQUEST_2.getDefault())) {
            return GLASSBLOWER_1_REQUEST_2.getDefault();
        }
        else {
            return GLASSBLOWER_1_REQUEST_2.get();
        }
    }
    public static int getGlassblower1Offer1Count() {
        if (Objects.equals(GLASSBLOWER_1_OFFER_1_COUNT.get(), GLASSBLOWER_1_OFFER_1_COUNT.getDefault())) {
            return GLASSBLOWER_1_OFFER_1_COUNT.getDefault();
        }
        else {
            return GLASSBLOWER_1_OFFER_1_COUNT.get();
        }
    }
    public static String getGlassblower1Offer1() {
        if (Objects.equals(GLASSBLOWER_1_OFFER_1.get(), GLASSBLOWER_1_OFFER_1.getDefault())) {
            return GLASSBLOWER_1_OFFER_1.getDefault();
        }
        else {
            return GLASSBLOWER_1_OFFER_1.get();
        }
    }
    public static String getGlassblower1Request1() {
        if (Objects.equals(GLASSBLOWER_1_REQUEST_1.get(), GLASSBLOWER_1_REQUEST_1.getDefault())) {
            return GLASSBLOWER_1_REQUEST_1.getDefault();
        }
        else {
            return GLASSBLOWER_1_REQUEST_1.get();
        }
    }
}