package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ToolsmithTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Toolsmith Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> TOOLSMITH_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_OFFER_3;

    static {
        // TOOLSMITH TRADES
        BUILDER.push("Toolsmith Trade Settings");
        // level 1
        BUILDER.push("Toolsmith Level One Trade One");
        TOOLSMITH_1_REQUEST_1 = BUILDER
                .comment(" Toolsmith 1 Trade Request 1 Table")
                .define("toolsmith_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        TOOLSMITH_1_OFFER_1 = BUILDER
                .comment(" Toolsmith 1 Trade Offer 1 Table")
                .define("toolsmith_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level One Trade Two");
        TOOLSMITH_1_REQUEST_2 = BUILDER
                .comment(" Toolsmith 1 Trade Request 2 Table")
                .define("toolsmith_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_1_OFFER_2 = BUILDER
                .comment(" Toolsmith 1 Trade Offer 2 Table")
                .define("toolsmith_1_trade_offer_2_table",
                        TradeLootTables.STONE_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Toolsmith Level Two Trade One");
        TOOLSMITH_2_REQUEST_1 = BUILDER
                .comment(" Toolsmith 2 Trade Request 1 Table")
                .define("toolsmith_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        TOOLSMITH_2_OFFER_1 = BUILDER
                .comment(" Toolsmith 2 Trade Offer 1 Table")
                .define("toolsmith_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Two Trade Two")
                .comment(" Rare Trade");
        TOOLSMITH_2_REQUEST_2 = BUILDER
                .comment(" Toolsmith 2 Trade Request 2 Table")
                .define("toolsmith_2_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_2_OFFER_2 = BUILDER
                .comment(" Toolsmith 2 Trade Offer 2 Table")
                .define("toolsmith_2_trade_offer_2_table",
                        TradeLootTables.BELL_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Toolsmith Level Three Trade One");
        TOOLSMITH_3_REQUEST_1 = BUILDER
                .comment(" Toolsmith 3 Trade Request 1 Table")
                .define("toolsmith_3_trade_request_1_table",
                        TradeLootTables.IRON_TIER_TOOLS_TABLE.toString());
        TOOLSMITH_3_OFFER_1 = BUILDER
                .comment(" Toolsmith 3 Trade Offer 1 Table")
                .define("toolsmith_3_trade_offer_1_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Three Trade Two");
        TOOLSMITH_3_REQUEST_2 = BUILDER
                .comment(" Toolsmith 3 Trade Request 2 Table")
                .define("toolsmith_3_trade_request_2_table",
                        TradeLootTables.FLINT_BUY_TABLE.toString());
        TOOLSMITH_3_OFFER_2 = BUILDER
                .comment(" Toolsmith 3 Trade Offer 2 Table")
                .define("toolsmith_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Toolsmith Level Four Trade One")
                .comment(" Rare Trade");
        TOOLSMITH_4_REQUEST_1 = BUILDER
                .comment(" Toolsmith 4 Trade Request 1 Table")
                .define("toolsmith_4_trade_request_1_table",
                        TradeLootTables.SIXTEEN_EMERALD_TABLE.toString());
        TOOLSMITH_4_OFFER_1 = BUILDER
                .comment(" Toolsmith 4 Trade Offer 1 Table")
                .define("toolsmith_4_trade_offer_1_table",
                        TradeLootTables.IRON_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Four Trade Two");
        TOOLSMITH_4_REQUEST_2 = BUILDER
                .comment(" Toolsmith 4 Trade Request 2 Table")
                .define("toolsmith_4_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_4_OFFER_2 = BUILDER
                .comment(" Toolsmith 4 Trade Offer 2 Table")
                .define("toolsmith_4_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Four Trade Three");
        TOOLSMITH_4_REQUEST_3 = BUILDER
                .comment(" Toolsmith 4 Trade Request 3 Table")
                .comment(" for either supplementaries mod or turtleblockacademy mod")
                .define("toolsmith_4_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_4_OFFER_3 = BUILDER
                .comment(" Toolsmith 4 Trade Offer 3 Table")
                .define("toolsmith_4_trade_offer_3_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        TOOLSMITH_4_OFFER_3_COUNT = BUILDER
                .define("toolsmith_4_trade_offer_2_count", 18);
        BUILDER.pop();
        // level 5
        BUILDER.push("Toolsmith Level Five Trade One")
                .comment(" Rare Trade");
        TOOLSMITH_5_REQUEST_1 = BUILDER
                .comment(" Toolsmith 5 Trade Request 1 Table")
                .define("toolsmith_5_trade_request_1_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_5_OFFER_1 = BUILDER
                .comment(" Toolsmith 5 Trade Offer 1 Table")
                .define("toolsmith_5_trade_offer_1_table",
                        TradeLootTables.GOLD_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Five Trade Two")
                .comment(" Rare Trade");
        TOOLSMITH_5_REQUEST_2 = BUILDER
                .comment(" Toolsmith 5 Trade Request 2 Table")
                .define("toolsmith_5_trade_request_2_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY.toString());
        TOOLSMITH_5_OFFER_2 = BUILDER
                .comment(" Toolsmith 5 Trade Offer 2 Table")
                .define("toolsmith_5_trade_offer_2_table",
                        TradeLootTables.NETHERITE_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Five Trade Three")
                .comment(" Rare Trade");
        TOOLSMITH_5_REQUEST_3 = BUILDER
                .comment(" Toolsmith 5 Trade Request 3 Table")
                .define("toolsmith_5_trade_request_3_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_5_OFFER_3 = BUILDER
                .comment(" Toolsmith 5 Trade Offer 3 Table")
                .define("toolsmith_5_trade_offer_3_table",
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // TOOLSMITH TRADE GETTERS
    public static String getToolsmith5Offer3() {
        if (Objects.equals(TOOLSMITH_5_OFFER_3.get(), TOOLSMITH_5_OFFER_3.getDefault())) {
            return TOOLSMITH_5_OFFER_3.getDefault();
        }
        else {
            return TOOLSMITH_5_OFFER_3.get();
        }
    }
    public static String getToolsmith5Request3() {
        if (Objects.equals(TOOLSMITH_5_REQUEST_3.get(), TOOLSMITH_5_REQUEST_3.getDefault())) {
            return TOOLSMITH_5_REQUEST_3.getDefault();
        }
        else {
            return TOOLSMITH_5_REQUEST_3.get();
        }
    }
    public static String getToolsmith5Offer2() {
        if (Objects.equals(TOOLSMITH_5_OFFER_2.get(), TOOLSMITH_5_OFFER_2.getDefault())) {
            return TOOLSMITH_5_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_5_OFFER_2.get();
        }
    }
    public static String getToolsmith5Request2() {
        if (Objects.equals(TOOLSMITH_5_REQUEST_2.get(), TOOLSMITH_5_REQUEST_2.getDefault())) {
            return TOOLSMITH_5_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_5_REQUEST_2.get();
        }
    }
    public static String getToolsmith5Offer1() {
        if (Objects.equals(TOOLSMITH_5_OFFER_1.get(), TOOLSMITH_5_OFFER_1.getDefault())) {
            return TOOLSMITH_5_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_5_OFFER_1.get();
        }
    }
    public static String getToolsmith5Request1() {
        if (Objects.equals(TOOLSMITH_5_REQUEST_1.get(), TOOLSMITH_5_REQUEST_1.getDefault())) {
            return TOOLSMITH_5_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_5_REQUEST_1.get();
        }
    }
    public static String getToolsmith4Offer3() {
        if (Objects.equals(TOOLSMITH_4_OFFER_3.get(), TOOLSMITH_4_OFFER_3.getDefault())) {
            return TOOLSMITH_4_OFFER_3.getDefault();
        }
        else {
            return TOOLSMITH_4_OFFER_3.get();
        }
    }
    public static String getToolsmith4Request3() {
        if (Objects.equals(TOOLSMITH_4_REQUEST_3.get(), TOOLSMITH_4_REQUEST_3.getDefault())) {
            return TOOLSMITH_4_REQUEST_3.getDefault();
        }
        else {
            return TOOLSMITH_4_REQUEST_3.get();
        }
    }
    public static int getToolsmith4Offer3Count() {
        if (Objects.equals(TOOLSMITH_4_OFFER_3_COUNT.get(), TOOLSMITH_4_OFFER_3_COUNT.getDefault())) {
            return TOOLSMITH_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return TOOLSMITH_4_OFFER_3_COUNT.get();
        }
    }
    public static String getToolsmith4Offer2() {
        if (Objects.equals(TOOLSMITH_4_OFFER_2.get(), TOOLSMITH_4_OFFER_2.getDefault())) {
            return TOOLSMITH_4_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_4_OFFER_2.get();
        }
    }
    public static String getToolsmith4Request2() {
        if (Objects.equals(TOOLSMITH_4_REQUEST_2.get(), TOOLSMITH_4_REQUEST_2.getDefault())) {
            return TOOLSMITH_4_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_4_REQUEST_2.get();
        }
    }
    public static String getToolsmith4Offer1() {
        if (Objects.equals(TOOLSMITH_4_OFFER_1.get(), TOOLSMITH_4_OFFER_1.getDefault())) {
            return TOOLSMITH_4_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_4_OFFER_1.get();
        }
    }
    public static String getToolsmith4Request1() {
        if (Objects.equals(TOOLSMITH_4_REQUEST_1.get(), TOOLSMITH_4_REQUEST_1.getDefault())) {
            return TOOLSMITH_4_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_4_REQUEST_1.get();
        }
    }
    public static String getToolsmith3Offer2() {
        if (Objects.equals(TOOLSMITH_3_OFFER_2.get(), TOOLSMITH_3_OFFER_2.getDefault())) {
            return TOOLSMITH_3_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_3_OFFER_2.get();
        }
    }
    public static String getToolsmith3Request2() {
        if (Objects.equals(TOOLSMITH_3_REQUEST_2.get(), TOOLSMITH_3_REQUEST_2.getDefault())) {
            return TOOLSMITH_3_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_3_REQUEST_2.get();
        }
    }
    public static String getToolsmith3Offer1() {
        if (Objects.equals(TOOLSMITH_3_OFFER_1.get(), TOOLSMITH_3_OFFER_1.getDefault())) {
            return TOOLSMITH_3_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_3_OFFER_1.get();
        }
    }
    public static String getToolsmith3Request1() {
        if (Objects.equals(TOOLSMITH_3_REQUEST_1.get(), TOOLSMITH_3_REQUEST_1.getDefault())) {
            return TOOLSMITH_3_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_3_REQUEST_1.get();
        }
    }
    public static String getToolsmith2Offer2() {
        if (Objects.equals(TOOLSMITH_2_OFFER_2.get(), TOOLSMITH_2_OFFER_2.getDefault())) {
            return TOOLSMITH_2_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_2_OFFER_2.get();
        }
    }
    public static String getToolsmith2Request2() {
        if (Objects.equals(TOOLSMITH_2_REQUEST_2.get(), TOOLSMITH_2_REQUEST_2.getDefault())) {
            return TOOLSMITH_2_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_2_REQUEST_2.get();
        }
    }
    public static String getToolsmith2Offer1() {
        if (Objects.equals(TOOLSMITH_2_OFFER_1.get(), TOOLSMITH_2_OFFER_1.getDefault())) {
            return TOOLSMITH_2_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_2_OFFER_1.get();
        }
    }
    public static String getToolsmith2Request1() {
        if (Objects.equals(TOOLSMITH_2_REQUEST_1.get(), TOOLSMITH_2_REQUEST_1.getDefault())) {
            return TOOLSMITH_2_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_2_REQUEST_1.get();
        }
    }
    public static String getToolsmith1Offer2() {
        if (Objects.equals(TOOLSMITH_1_OFFER_2.get(), TOOLSMITH_1_OFFER_2.getDefault())) {
            return TOOLSMITH_1_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_1_OFFER_2.get();
        }
    }
    public static String getToolsmith1Request2() {
        if (Objects.equals(TOOLSMITH_1_REQUEST_2.get(), TOOLSMITH_1_REQUEST_2.getDefault())) {
            return TOOLSMITH_1_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_1_REQUEST_2.get();
        }
    }
    public static String getToolsmith1Offer1() {
        if (Objects.equals(TOOLSMITH_1_OFFER_1.get(), TOOLSMITH_1_OFFER_1.getDefault())) {
            return TOOLSMITH_1_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_1_OFFER_1.get();
        }
    }
    public static String getToolsmith1Request1() {
        if (Objects.equals(TOOLSMITH_1_REQUEST_1.get(), TOOLSMITH_1_REQUEST_1.getDefault())) {
            return TOOLSMITH_1_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_1_REQUEST_1.get();
        }
    }
}