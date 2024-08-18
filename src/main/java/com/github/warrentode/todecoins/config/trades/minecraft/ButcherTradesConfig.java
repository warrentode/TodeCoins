package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ButcherTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Butcher Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_3_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_4_OFFER_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_5_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_5_OFFER_2_COUNT;

    static {
        // BUTCHER TRADES
        BUILDER.push("Butcher Trade Settings");
        // level 1
        BUILDER.push("Butcher Level One Trade One");
        BUTCHER_1_REQUEST_1 = BUILDER
                .comment(" Butcher 1 Trade Request 1 Table")
                .define("butcher_1_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_MEATS_TABLE.toString());
        BUTCHER_1_REQUEST_1_COUNT = BUILDER
                .defineInRange("butcher_1_trade_request_1_count", 12, 1, 64);
        BUTCHER_1_OFFER_1 = BUILDER
                .comment(" Butcher 1 Trade Offer 1 Table")
                .define("butcher_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level One Trade Two");
        BUTCHER_1_REQUEST_2 = BUILDER
                .comment(" Butcher 1 Trade Request 2 Table")
                .define("butcher_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_1_OFFER_2 = BUILDER
                .comment(" Butcher 1 Trade Offer 2 Table")
                .define("butcher_1_trade_offer_2_table",
                        TradeLootTables.TAGGED_MEAT_SOUPS_TABLE.toString());
        BUTCHER_1_OFFER_2_COUNT = BUILDER
                .defineInRange("butcher_1_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 2
        BUILDER.push("Butcher Level Two Trade One");
        BUTCHER_2_REQUEST_1 = BUILDER
                .comment(" Butcher 2 Trade Request 1 Table")
                .define("butcher_2_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        BUTCHER_2_OFFER_1 = BUILDER
                .comment(" Butcher 2 Trade Offer 1 Table")
                .define("butcher_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Two Trade Two");
        BUTCHER_2_REQUEST_2 = BUILDER
                .comment(" Butcher 2 Trade Request 2 Table")
                .define("butcher_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_2_OFFER_2 = BUILDER
                .comment(" Butcher 2 Trade Offer 2 Table")
                .define("butcher_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        BUTCHER_2_OFFER_2_COUNT = BUILDER
                .defineInRange("butcher_2_trade_offer_2_count", 6, 1, 64);
        BUILDER.pop();
        // level 3
        BUILDER.push("Butcher Level Three Trade One");
        BUTCHER_3_REQUEST_1 = BUILDER
                .comment(" Butcher 3 Trade Request 1 Table")
                .define("butcher_3_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_MEATS_TABLE.toString());
        BUTCHER_3_REQUEST_1_COUNT = BUILDER
                .defineInRange("butcher_3_trade_request_1_count", 12, 1, 64);
        BUTCHER_3_OFFER_1 = BUILDER
                .comment(" Butcher 3 Trade Offer 1 Table")
                .define("butcher_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Three Trade Two")
                .comment(" Available if Farmers Delight mod is Loaded");
        BUTCHER_3_REQUEST_2 = BUILDER
                .comment(" Butcher 3 Trade Request 2 Table")
                .define("butcher_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_3_OFFER_2 = BUILDER
                .comment(" Butcher 3 Trade Offer 2 Table")
                .define("butcher_3_trade_offer_2_table",
                        TradeLootTables.STONE_TIER_KNIVES.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Three Trade Three");
        BUTCHER_3_REQUEST_3 = BUILDER
                .comment(" Butcher 3 Trade Request 3 Table")
                .define("butcher_3_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_3_OFFER_3 = BUILDER
                .comment(" Butcher 2 Trade Offer 2 Table")
                .define("butcher_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        BUTCHER_3_OFFER_3_COUNT = BUILDER
                .defineInRange("butcher_2_trade_offer_2_count", 6, 1, 64);
        BUILDER.pop();
        // level 4
        BUILDER.push("Butcher Level Four Trade One");
        BUTCHER_4_REQUEST_1 = BUILDER
                .comment(" Butcher 4 Trade Request 1 Table")
                .define("butcher_4_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        BUTCHER_4_OFFER_1 = BUILDER
                .comment(" Butcher 4 Trade Offer 1 Table")
                .define("butcher_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Four Trade Two")
                .comment(" Available if Salt mod or Turtle Block Academy mod is Loaded");
        BUTCHER_4_REQUEST_2 = BUILDER
                .comment(" Butcher 4 Trade Request 2 Table")
                .define("butcher_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_4_OFFER_2 = BUILDER
                .comment(" Butcher 4 Trade Offer 2 Table")
                .define("butcher_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_SALTS_TABLE.toString());
        BUTCHER_4_OFFER_2_COUNT = BUILDER
                .defineInRange("butcher_4_trade_offer_2_count", 18, 1, 64);
        BUILDER.pop();
        BUILDER.push("Butcher Level Four Trade Three")
                .comment(" Available if Supplementaries mod is Loaded");
        BUTCHER_4_REQUEST_3 = BUILDER
                .comment(" Butcher 4 Trade Request 3 Table")
                .define("butcher_4_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_4_OFFER_3 = BUILDER
                .comment(" Butcher 4 Trade Offer 3 Table")
                .define("butcher_4_trade_offer_3_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        BUTCHER_4_OFFER_3_COUNT = BUILDER
                .defineInRange("butcher_4_trade_offer_3_count", 18, 1, 64);
        BUILDER.pop();
        BUILDER.push("Butcher Level Four Trade Four");
        BUTCHER_4_REQUEST_4 = BUILDER
                .comment(" Butcher 4 Trade Request 4 Table")
                .define("butcher_4_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_4_OFFER_4 = BUILDER
                .comment(" Butcher 4 Trade Offer 4 Table")
                .define("butcher_4_trade_offer_4_table",
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        BUTCHER_4_OFFER_4_COUNT = BUILDER
                .defineInRange("butcher_4_trade_offer_4_count", 6, 1, 64);
        BUILDER.pop();
        // level 5
        BUILDER.push("Butcher Level Five Trade One");
        BUTCHER_5_REQUEST_1 = BUILDER
                .comment(" Butcher 5 Trade Request 1 Table")
                .define("butcher_5_trade_request_1_table",
                        TradeLootTables.TAGGED_FOX_FOOD_TABLE.toString());
        BUTCHER_5_REQUEST_1_COUNT = BUILDER
                .defineInRange("butcher_5_trade_request_1_count", 8, 1, 64);
        BUTCHER_5_OFFER_1 = BUILDER
                .comment(" Butcher 5 Trade Offer 1 Table")
                .define("butcher_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Five Trade Two");
        BUTCHER_5_REQUEST_2 = BUILDER
                .comment(" Butcher 5 Trade Request 2 Table")
                .define("butcher_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_5_OFFER_2 = BUILDER
                .comment(" Butcher 5 Trade Offer 2 Table")
                .define("butcher_5_trade_offer_2_table",
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        BUTCHER_5_OFFER_2_COUNT = BUILDER
                .defineInRange("butcher_5_trade_offer_23_count", 6, 1, 64);
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // BUTCHER TRADE GETTERS
    public static int getButcher5Offer2Count() {
        if (Objects.equals(BUTCHER_5_OFFER_2_COUNT.get(), BUTCHER_5_OFFER_2_COUNT.getDefault())) {
            return BUTCHER_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return BUTCHER_5_OFFER_2_COUNT.get();
        }
    }
    public static String getButcher5Offer2() {
        if (Objects.equals(BUTCHER_5_OFFER_2.get(), BUTCHER_5_OFFER_2.getDefault())) {
            return BUTCHER_5_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_5_OFFER_2.get();
        }
    }
    public static String getButcher5Request2() {
        if (Objects.equals(BUTCHER_5_REQUEST_2.get(), BUTCHER_5_REQUEST_2.getDefault())) {
            return BUTCHER_5_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_5_REQUEST_2.get();
        }
    }
    public static String getButcher5Offer1() {
        if (Objects.equals(BUTCHER_5_OFFER_1.get(), BUTCHER_5_OFFER_1.getDefault())) {
            return BUTCHER_5_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_5_OFFER_1.get();
        }
    }
    public static int getButcher5Request1Count() {
        if (Objects.equals(BUTCHER_5_REQUEST_1_COUNT.get(), BUTCHER_5_REQUEST_1_COUNT.getDefault())) {
            return BUTCHER_5_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BUTCHER_5_REQUEST_1_COUNT.get();
        }
    }
    public static String getButcher5Request1() {
        if (Objects.equals(BUTCHER_5_REQUEST_1.get(), BUTCHER_5_REQUEST_1.getDefault())) {
            return BUTCHER_5_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_5_REQUEST_1.get();
        }
    }
    public static int getButcher4Offer4Count() {
        if (Objects.equals(BUTCHER_4_OFFER_4_COUNT.get(), BUTCHER_4_OFFER_4_COUNT.getDefault())) {
            return BUTCHER_4_OFFER_4_COUNT.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_4_COUNT.get();
        }
    }
    public static String getButcher4Offer4() {
        if (Objects.equals(BUTCHER_4_OFFER_4.get(), BUTCHER_4_OFFER_4.getDefault())) {
            return BUTCHER_4_OFFER_4.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_4.get();
        }
    }
    public static String getButcher4Request4() {
        if (Objects.equals(BUTCHER_4_REQUEST_4.get(), BUTCHER_4_REQUEST_4.getDefault())) {
            return BUTCHER_4_REQUEST_4.getDefault();
        }
        else {
            return BUTCHER_4_REQUEST_4.get();
        }
    }
    public static int getButcher4Offer3Count() {
        if (Objects.equals(BUTCHER_4_OFFER_3_COUNT.get(), BUTCHER_4_OFFER_3_COUNT.getDefault())) {
            return BUTCHER_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_3_COUNT.get();
        }
    }
    public static String getButcher4Offer3() {
        if (Objects.equals(BUTCHER_4_OFFER_3.get(), BUTCHER_4_OFFER_3.getDefault())) {
            return BUTCHER_4_OFFER_3.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_3.get();
        }
    }
    public static String getButcher4Request3() {
        if (Objects.equals(BUTCHER_4_REQUEST_3.get(), BUTCHER_4_REQUEST_3.getDefault())) {
            return BUTCHER_4_REQUEST_3.getDefault();
        }
        else {
            return BUTCHER_4_REQUEST_3.get();
        }
    }
    public static int getButcher4Offer2Count() {
        if (Objects.equals(BUTCHER_4_OFFER_2_COUNT.get(), BUTCHER_4_OFFER_2_COUNT.getDefault())) {
            return BUTCHER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getButcher4Offer2() {
        if (Objects.equals(BUTCHER_4_OFFER_2.get(), BUTCHER_4_OFFER_2.getDefault())) {
            return BUTCHER_4_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_2.get();
        }
    }
    public static String getButcher4Request2() {
        if (Objects.equals(BUTCHER_4_REQUEST_2.get(), BUTCHER_4_REQUEST_2.getDefault())) {
            return BUTCHER_4_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_4_REQUEST_2.get();
        }
    }
    public static String getButcher4Offer1() {
        if (Objects.equals(BUTCHER_4_OFFER_1.get(), BUTCHER_4_OFFER_1.getDefault())) {
            return BUTCHER_4_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_1.get();
        }
    }
    public static String getButcher4Request1() {
        if (Objects.equals(BUTCHER_4_REQUEST_1.get(), BUTCHER_4_REQUEST_1.getDefault())) {
            return BUTCHER_4_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_4_REQUEST_1.get();
        }
    }
    public static int getButcher3Offer3Count() {
        if (Objects.equals(BUTCHER_3_OFFER_3_COUNT.get(), BUTCHER_3_OFFER_3_COUNT.getDefault())) {
            return BUTCHER_3_OFFER_3_COUNT.getDefault();
        }
        else {
            return BUTCHER_3_OFFER_3_COUNT.get();
        }
    }
    public static String getButcher3Offer3() {
        if (Objects.equals(BUTCHER_3_OFFER_3.get(), BUTCHER_3_OFFER_3.getDefault())) {
            return BUTCHER_3_OFFER_3.getDefault();
        }
        else {
            return BUTCHER_3_OFFER_3.get();
        }
    }
    public static String getButcher3Request3() {
        if (Objects.equals(BUTCHER_3_REQUEST_3.get(), BUTCHER_3_REQUEST_3.getDefault())) {
            return BUTCHER_3_REQUEST_3.getDefault();
        }
        else {
            return BUTCHER_3_REQUEST_3.get();
        }
    }
    public static String getButcher3Offer2() {
        if (Objects.equals(BUTCHER_3_OFFER_2.get(), BUTCHER_3_OFFER_2.getDefault())) {
            return BUTCHER_3_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_3_OFFER_2.get();
        }
    }
    public static String getButcher3Request2() {
        if (Objects.equals(BUTCHER_3_REQUEST_2.get(), BUTCHER_3_REQUEST_2.getDefault())) {
            return BUTCHER_3_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_3_REQUEST_2.get();
        }
    }
    public static String getButcher3Offer1() {
        if (Objects.equals(BUTCHER_3_OFFER_1.get(), BUTCHER_3_OFFER_1.getDefault())) {
            return BUTCHER_3_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_3_OFFER_1.get();
        }
    }
    public static int getButcher3Request1Count() {
        if (Objects.equals(BUTCHER_3_REQUEST_1_COUNT.get(), BUTCHER_3_REQUEST_1_COUNT.getDefault())) {
            return BUTCHER_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BUTCHER_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getButcher3Request1() {
        if (Objects.equals(BUTCHER_3_REQUEST_1.get(), BUTCHER_3_REQUEST_1.getDefault())) {
            return BUTCHER_3_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_3_REQUEST_1.get();
        }
    }
    public static int getButcher2Offer2Count() {
        if (Objects.equals(BUTCHER_2_OFFER_2_COUNT.get(), BUTCHER_2_OFFER_2_COUNT.getDefault())) {
            return BUTCHER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return BUTCHER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getButcher2Offer2() {
        if (Objects.equals(BUTCHER_2_OFFER_2.get(), BUTCHER_2_OFFER_2.getDefault())) {
            return BUTCHER_2_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_2_OFFER_2.get();
        }
    }
    public static String getButcher2Request2() {
        if (Objects.equals(BUTCHER_2_REQUEST_2.get(), BUTCHER_2_REQUEST_2.getDefault())) {
            return BUTCHER_2_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_2_REQUEST_2.get();
        }
    }
    public static String getButcher2Offer1() {
        if (Objects.equals(BUTCHER_2_OFFER_1.get(), BUTCHER_2_OFFER_1.getDefault())) {
            return BUTCHER_2_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_2_OFFER_1.get();
        }
    }
    public static String getButcher2Request1() {
        if (Objects.equals(BUTCHER_2_REQUEST_1.get(), BUTCHER_2_REQUEST_1.getDefault())) {
            return BUTCHER_2_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_2_REQUEST_1.get();
        }
    }
    public static int getButcher1Offer2Count() {
        if (Objects.equals(BUTCHER_1_OFFER_2_COUNT.get(), BUTCHER_1_OFFER_2_COUNT.getDefault())) {
            return BUTCHER_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return BUTCHER_1_OFFER_2_COUNT.get();
        }
    }
    public static String getButcher1Offer2() {
        if (Objects.equals(BUTCHER_1_OFFER_2.get(), BUTCHER_1_OFFER_2.getDefault())) {
            return BUTCHER_1_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_1_OFFER_2.get();
        }
    }
    public static String getButcher1Request2() {
        if (Objects.equals(BUTCHER_1_REQUEST_2.get(), BUTCHER_1_REQUEST_2.getDefault())) {
            return BUTCHER_1_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_1_REQUEST_2.get();
        }
    }
    public static String getButcher1Offer1() {
        if (Objects.equals(BUTCHER_1_OFFER_1.get(), BUTCHER_1_OFFER_1.getDefault())) {
            return BUTCHER_1_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_1_OFFER_1.get();
        }
    }
    public static int getButcher1Request1Count() {
        if (Objects.equals(BUTCHER_1_REQUEST_1_COUNT.get(), BUTCHER_1_REQUEST_1_COUNT.getDefault())) {
            return BUTCHER_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BUTCHER_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getButcher1Request1() {
        if (Objects.equals(BUTCHER_1_REQUEST_1.get(), BUTCHER_1_REQUEST_1.getDefault())) {
            return BUTCHER_1_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_1_REQUEST_1.get();
        }
    }
}