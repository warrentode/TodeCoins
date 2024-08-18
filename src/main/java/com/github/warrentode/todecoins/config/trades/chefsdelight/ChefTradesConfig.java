package com.github.warrentode.todecoins.config.trades.chefsdelight;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChefTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Chef Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> CHEF_1_REQUEST_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> CHEF_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> CHEF_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> CHEF_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> CHEF_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> CHEF_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> CHEF_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CHEF_5_OFFER_2;

    static {
        // CHEF TRADES
        BUILDER.push("Chef Trade Settings");
        // level 1
        BUILDER.push("Chef Level One Trade One");
        CHEF_1_REQUEST_1 = BUILDER
                .comment(" Chef 1 Trade Request 1 Table")
                .define("chef_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CHEF_1_OFFER_1 = BUILDER
                .comment(" Chef 1 Trade Offer 1 Table")
                .define("chef_1_trade_offer_1_table",
                        TradeLootTables.COOKING_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Chef Level One Trade Two");
        CHEF_1_REQUEST_2 = BUILDER
                .comment(" Chef 1 Trade Request 2 Table")
                .define("chef_1_trade_request_2_table",
                        TradeLootTables.INGREDIENTS_TAG_TABLE.toString());
        CHEF_1_REQUEST_2_COUNT = BUILDER
                .defineInRange("chef_1_trade_request_2_count", 16, 1, 64);
        CHEF_1_OFFER_2 = BUILDER
                .comment(" Chef 1 Trade Offer 2 Table")
                .define("chef_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Chef Level Two Trade One");
        CHEF_2_REQUEST_1 = BUILDER
                .comment(" Chef 2 Trade Request 1 Table")
                .define("chef_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CHEF_2_OFFER_1 = BUILDER
                .comment(" Chef 2 Trade Offer 1 Table")
                .define("chef_2_trade_offer_1_table",
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        CHEF_2_OFFER_1_COUNT = BUILDER
                .defineInRange("chef_2_trade_offer_1_count", 6, 1, 64);
        BUILDER.pop();
        BUILDER.push("Chef Level Two Trade Two");
        CHEF_2_REQUEST_2 = BUILDER
                .comment(" Chef 2 Trade Request 2 Table")
                .define("chef_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CHEF_2_OFFER_2 = BUILDER
                .comment(" Chef 2 Trade Offer 2 Table")
                .define("chef_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_COOKIES_TABLE.toString());
        CHEF_2_OFFER_2_COUNT = BUILDER
                .defineInRange("chef_2_trade_offer_2_count", 8, 1, 64);
        BUILDER.pop();
        // level 3
        BUILDER.push("Chef Level Three Trade One");
        CHEF_3_REQUEST_1 = BUILDER
                .comment(" Chef 3 Trade Request 1 Table")
                .define("chef_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CHEF_3_OFFER_1 = BUILDER
                .comment(" Chef 3 Trade Offer 1 Table")
                .define("chef_3_trade_offer_1_table",
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE.toString());
        CHEF_3_OFFER_1_COUNT = BUILDER
                .defineInRange("chef_3_trade_offer_1_count", 6, 1, 64);
        BUILDER.pop();
        BUILDER.push("Chef Level Three Trade Two");
        CHEF_3_REQUEST_2 = BUILDER
                .comment(" Chef 3 Trade Request 2 Table")
                .define("chef_3_trade_request_2_count",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CHEF_3_OFFER_2 = BUILDER
                .comment(" Chef 3 Trade Offer 2 Table")
                .define("chef_3_trade_offer_2_table",
                        TradeLootTables.SOUP_TAG_TABLE.toString());
        CHEF_3_OFFER_2_COUNT = BUILDER
                .defineInRange("chef_3_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        // level 4
        BUILDER.push("Chef Level Four Trade One");
        CHEF_4_REQUEST_1 = BUILDER
                .comment(" Chef 4 Trade Request 1 Table")
                .define("chef_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CHEF_4_OFFER_1 = BUILDER
                .comment(" Chef 4 Trade Offer 1 Table")
                .define("chef_4_trade_offer_1_table",
                        TradeLootTables.TAGGED_CAKES_TABLE.toString());
        CHEF_4_OFFER_1_COUNT = BUILDER
                .defineInRange("chef_4_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Chef Level Four Trade Two");
        CHEF_4_REQUEST_2 = BUILDER
                .comment(" Chef 4 Trade Request 2 Table")
                .define("chef_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CHEF_4_OFFER_2 = BUILDER
                .comment(" Chef 4 Trade Offer 2 Table")
                .define("chef_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_PIES_TABLE.toString());
        CHEF_4_OFFER_2_COUNT = BUILDER
                .defineInRange("chef_3_trade_offer_2_count", 4, 1, 64);
        BUILDER.pop();
        // level 5
        BUILDER.push("Chef Level Five Trade One")
                .comment(" Rare Trade");
        CHEF_5_REQUEST_1 = BUILDER
                .comment(" Chef 5 Trade Request 1 Table")
                .define("chef_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CHEF_5_OFFER_1 = BUILDER
                .comment(" Chef 5 Trade Offer 1 Table")
                .define("chef_5_trade_offer_1_table",
                        TradeLootTables.FEAST_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Chef Level Five Trade Two")
                .comment(" Rare Trade");
        CHEF_5_REQUEST_2 = BUILDER
                .comment(" Chef 5 Trade Request 2 Table")
                .define("chef_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CHEF_5_OFFER_2 = BUILDER
                .comment(" Chef 5 Trade Offer 2 Table")
                .define("chef_5_trade_offer_2_table",
                        TradeLootTables.FEAST_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // CHEF TRADE GETTERS
    public static String getChef5Offer2() {
        if (Objects.equals(CHEF_5_OFFER_2.get(), CHEF_5_OFFER_2.getDefault())) {
            return CHEF_5_OFFER_2.getDefault();
        }
        else {
            return CHEF_5_OFFER_2.get();
        }
    }
    public static String getChef5Request2() {
        if (Objects.equals(CHEF_5_REQUEST_2.get(), CHEF_5_REQUEST_2.getDefault())) {
            return CHEF_5_REQUEST_2.getDefault();
        }
        else {
            return CHEF_5_REQUEST_2.get();
        }
    }
    public static String getChef5Offer1() {
        if (Objects.equals(CHEF_5_OFFER_1.get(), CHEF_5_OFFER_1.getDefault())) {
            return CHEF_5_OFFER_1.getDefault();
        }
        else {
            return CHEF_5_OFFER_1.get();
        }
    }
    public static String getChef5Request1() {
        if (Objects.equals(CHEF_5_REQUEST_1.get(), CHEF_5_REQUEST_1.getDefault())) {
            return CHEF_5_REQUEST_1.getDefault();
        }
        else {
            return CHEF_5_REQUEST_1.get();
        }
    }
    public static int getChef4Offer2Count() {
        if (Objects.equals(CHEF_4_OFFER_2_COUNT.get(), CHEF_4_OFFER_2_COUNT.getDefault())) {
            return CHEF_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return CHEF_4_OFFER_2_COUNT.get();
        }
    }
    public static String getChef4Offer2() {
        if (Objects.equals(CHEF_4_OFFER_2.get(), CHEF_4_OFFER_2.getDefault())) {
            return CHEF_4_OFFER_2.getDefault();
        }
        else {
            return CHEF_4_OFFER_2.get();
        }
    }
    public static String getChef4Request2() {
        if (Objects.equals(CHEF_4_REQUEST_2.get(), CHEF_4_REQUEST_2.getDefault())) {
            return CHEF_4_REQUEST_2.getDefault();
        }
        else {
            return CHEF_4_REQUEST_2.get();
        }
    }
    public static int getChef4Offer1Count() {
        if (Objects.equals(CHEF_4_OFFER_1_COUNT.get(), CHEF_4_OFFER_1_COUNT.getDefault())) {
            return CHEF_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return CHEF_4_OFFER_1_COUNT.get();
        }
    }
    public static String getChef4Offer1() {
        if (Objects.equals(CHEF_4_OFFER_1.get(), CHEF_4_OFFER_1.getDefault())) {
            return CHEF_4_OFFER_1.getDefault();
        }
        else {
            return CHEF_4_OFFER_1.get();
        }
    }
    public static String getChef4Request1() {
        if (Objects.equals(CHEF_4_REQUEST_1.get(), CHEF_4_REQUEST_1.getDefault())) {
            return CHEF_4_REQUEST_1.getDefault();
        }
        else {
            return CHEF_4_REQUEST_1.get();
        }
    }
    public static int getChef3Offer2Count() {
        if (Objects.equals(CHEF_3_OFFER_2_COUNT.get(), CHEF_3_OFFER_2_COUNT.getDefault())) {
            return CHEF_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return CHEF_3_OFFER_2_COUNT.get();
        }
    }
    public static String getChef3Offer2() {
        if (Objects.equals(CHEF_3_OFFER_2.get(), CHEF_3_OFFER_2.getDefault())) {
            return CHEF_3_OFFER_2.getDefault();
        }
        else {
            return CHEF_3_OFFER_2.get();
        }
    }
    public static String getChef3Request2() {
        if (Objects.equals(CHEF_3_REQUEST_2.get(), CHEF_3_REQUEST_2.getDefault())) {
            return CHEF_3_REQUEST_2.getDefault();
        }
        else {
            return CHEF_3_REQUEST_2.get();
        }
    }
    public static int getChef3Offer1Count() {
        if (Objects.equals(CHEF_3_OFFER_1_COUNT.get(), CHEF_3_OFFER_1_COUNT.getDefault())) {
            return CHEF_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return CHEF_3_OFFER_1_COUNT.get();
        }
    }
    public static String getChef3Offer1() {
        if (Objects.equals(CHEF_3_OFFER_1.get(), CHEF_3_OFFER_1.getDefault())) {
            return CHEF_3_OFFER_1.getDefault();
        }
        else {
            return CHEF_3_OFFER_1.get();
        }
    }
    public static String getChef3Request1() {
        if (Objects.equals(CHEF_3_REQUEST_1.get(), CHEF_3_REQUEST_1.getDefault())) {
            return CHEF_3_REQUEST_1.getDefault();
        }
        else {
            return CHEF_3_REQUEST_1.get();
        }
    }
    public static int getChef2Offer2Count() {
        if (Objects.equals(CHEF_2_OFFER_2_COUNT.get(), CHEF_2_OFFER_2_COUNT.getDefault())) {
            return CHEF_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return CHEF_2_OFFER_2_COUNT.get();
        }
    }
    public static String getChef2Offer2() {
        if (Objects.equals(CHEF_2_OFFER_2.get(), CHEF_2_OFFER_2.getDefault())) {
            return CHEF_2_OFFER_2.getDefault();
        }
        else {
            return CHEF_2_OFFER_2.get();
        }
    }
    public static String getChef2Request2() {
        if (Objects.equals(CHEF_2_REQUEST_2.get(), CHEF_2_REQUEST_2.getDefault())) {
            return CHEF_2_REQUEST_2.getDefault();
        }
        else {
            return CHEF_2_REQUEST_2.get();
        }
    }
    public static int getChef2Offer1Count() {
        if (Objects.equals(CHEF_2_OFFER_1_COUNT.get(), CHEF_2_OFFER_1_COUNT.getDefault())) {
            return CHEF_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return CHEF_2_OFFER_1_COUNT.get();
        }
    }
    public static String getChef2Offer1() {
        if (Objects.equals(CHEF_2_OFFER_1.get(), CHEF_2_OFFER_1.getDefault())) {
            return CHEF_2_OFFER_1.getDefault();
        }
        else {
            return CHEF_2_OFFER_1.get();
        }
    }
    public static String getChef2Request1() {
        if (Objects.equals(CHEF_2_REQUEST_1.get(), CHEF_2_REQUEST_1.getDefault())) {
            return CHEF_2_REQUEST_1.getDefault();
        }
        else {
            return CHEF_2_REQUEST_1.get();
        }
    }
    public static String getChef1Offer2() {
        if (Objects.equals(CHEF_1_OFFER_2.get(), CHEF_1_OFFER_2.getDefault())) {
            return CHEF_1_OFFER_2.getDefault();
        }
        else {
            return CHEF_1_OFFER_2.get();
        }
    }
    public static int getChef1Request2Count() {
        if (Objects.equals(CHEF_1_REQUEST_2_COUNT.get(), CHEF_1_REQUEST_2_COUNT.getDefault())) {
            return CHEF_1_REQUEST_2_COUNT.getDefault();
        }
        else {
            return CHEF_1_REQUEST_2_COUNT.get();
        }
    }
    public static String getChef1Request2() {
        if (Objects.equals(CHEF_1_REQUEST_2.get(), CHEF_1_REQUEST_2.getDefault())) {
            return CHEF_1_REQUEST_2.getDefault();
        }
        else {
            return CHEF_1_REQUEST_2.get();
        }
    }
    public static String getChef1Offer1() {
        if (Objects.equals(CHEF_1_OFFER_1.get(), CHEF_1_OFFER_1.getDefault())) {
            return CHEF_1_OFFER_1.getDefault();
        }
        else {
            return CHEF_1_OFFER_1.get();
        }
    }
    public static String getChef1Request1() {
        if (Objects.equals(CHEF_1_REQUEST_1.get(), CHEF_1_REQUEST_1.getDefault())) {
            return CHEF_1_REQUEST_1.getDefault();
        }
        else {
            return CHEF_1_REQUEST_1.get();
        }
    }
}