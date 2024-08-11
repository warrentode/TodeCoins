package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MasonTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Mason Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> MASON_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_5_OFFER_2;

    static {
        // MASON TRADES
        BUILDER.push("Mason Trade Settings");
        // level 1
        BUILDER.push("Mason Level One Trade One");
        MASON_1_REQUEST_1 = BUILDER
                .comment(" Mason 1 Trade Request 1 Table")
                .define("mason_1_trade_request_1_table",
                        TradeLootTables.CLAY_TABLE.toString());
        MASON_1_OFFER_1 = BUILDER
                .comment(" Mason 1 Trade Offer 1 Table")
                .define("mason_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level One Trade Two");
        MASON_1_REQUEST_2 = BUILDER
                .comment(" Mason 1 Trade Request 2 Table")
                .define("mason_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_1_OFFER_2 = BUILDER
                .comment(" Mason 1 Trade Offer 2 Table")
                .define("mason_1_trade_offer_2_table",
                        TradeLootTables.OVERWORLD_BRICK_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Mason Level Two Trade One");
        MASON_2_REQUEST_1 = BUILDER
                .comment(" Mason 2 Trade Request 1 Table")
                .define("mason_2_trade_request_1_table",
                        TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE.toString());
        MASON_2_OFFER_1 = BUILDER
                .comment(" Mason 2 Trade Offer 1 Table")
                .define("mason_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level Two Trade Two");
        MASON_2_REQUEST_2 = BUILDER
                .comment(" Mason 2 Trade Request 2 Table")
                .define("mason_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_2_OFFER_2 = BUILDER
                .comment(" Mason 2 Trade Offer 2 Table")
                .define("mason_2_trade_offer_2_table",
                        TradeLootTables.OVERWORLD_BRICK_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Mason Level Three Trade One");
        MASON_3_REQUEST_1 = BUILDER
                .comment(" Mason 3 Trade Request 1 Table")
                .define("mason_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_3_OFFER_1 = BUILDER
                .comment(" Mason 3 Trade Offer 1 Table")
                .define("mason_3_trade_offer_1_table",
                        TradeLootTables.OVERWORLD_POLISHED_STONE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level Three Trade Two");
        MASON_3_REQUEST_2 = BUILDER
                .comment(" Mason 3 Trade Request 2 Table")
                .define("mason_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_3_OFFER_2 = BUILDER
                .comment(" Mason 3 Trade Offer 2 Table")
                .define("mason_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Mason Level Four Trade One");
        MASON_4_REQUEST_1 = BUILDER
                .comment(" Mason 4 Trade Request 1 Table")
                .define("mason_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_4_OFFER_1 = BUILDER
                .comment(" Mason 4 Trade Offer 1 Table")
                .define("mason_4_trade_offer_1_table",
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level Four Trade Two");
        MASON_4_REQUEST_2 = BUILDER
                .comment(" Mason 4 Trade Request 2 Table")
                .define("mason_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_4_OFFER_2 = BUILDER
                .comment(" Mason 4 Trade Offer 2 Table")
                .define("mason_4_trade_offer_2_table",
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Mason Level Five Trade One");
        MASON_5_REQUEST_1 = BUILDER
                .comment(" Mason 5 Trade Request 1 Table")
                .define("mason_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        MASON_5_OFFER_1 = BUILDER
                .comment(" Mason 5 Trade Offer 1 Table")
                .define("mason_5_trade_offer_1_table",
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level Five Trade Two");
        MASON_5_REQUEST_2 = BUILDER
                .comment(" Mason 5 Trade Request 2 Table")
                .define("mason_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_5_OFFER_2 = BUILDER
                .comment(" Mason 5 Trade Offer 2 Table")
                .define("mason_5_trade_offer_2_table",
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // MASON TRADE GETTERS
    public static String getMason5Offer2() {
        if (Objects.equals(MASON_5_OFFER_2.get(), MASON_5_OFFER_2.getDefault())) {
            return MASON_5_OFFER_2.getDefault();
        }
        else {
            return MASON_5_OFFER_2.get();
        }
    }
    public static String getMason5Request2() {
        if (Objects.equals(MASON_5_REQUEST_2.get(), MASON_5_REQUEST_2.getDefault())) {
            return MASON_5_REQUEST_2.getDefault();
        }
        else {
            return MASON_5_REQUEST_2.get();
        }
    }
    public static String getMason5Offer1() {
        if (Objects.equals(MASON_5_OFFER_1.get(), MASON_5_OFFER_1.getDefault())) {
            return MASON_5_OFFER_1.getDefault();
        }
        else {
            return MASON_5_OFFER_1.get();
        }
    }
    public static String getMason5Request1() {
        if (Objects.equals(MASON_5_REQUEST_1.get(), MASON_5_REQUEST_1.getDefault())) {
            return MASON_5_REQUEST_1.getDefault();
        }
        else {
            return MASON_5_REQUEST_1.get();
        }
    }
    public static String getMason4Offer2() {
        if (Objects.equals(MASON_4_OFFER_2.get(), MASON_4_OFFER_2.getDefault())) {
            return MASON_4_OFFER_2.getDefault();
        }
        else {
            return MASON_4_OFFER_2.get();
        }
    }
    public static String getMason4Request2() {
        if (Objects.equals(MASON_4_REQUEST_2.get(), MASON_4_REQUEST_2.getDefault())) {
            return MASON_4_REQUEST_2.getDefault();
        }
        else {
            return MASON_4_REQUEST_2.get();
        }
    }
    public static String getMason4Offer1() {
        if (Objects.equals(MASON_4_OFFER_1.get(), MASON_4_OFFER_1.getDefault())) {
            return MASON_4_OFFER_1.getDefault();
        }
        else {
            return MASON_4_OFFER_1.get();
        }
    }
    public static String getMason4Request1() {
        if (Objects.equals(MASON_4_REQUEST_1.get(), MASON_4_REQUEST_1.getDefault())) {
            return MASON_4_REQUEST_1.getDefault();
        }
        else {
            return MASON_4_REQUEST_1.get();
        }
    }
    public static String getMason3Offer2() {
        if (Objects.equals(MASON_3_OFFER_2.get(), MASON_3_OFFER_2.getDefault())) {
            return MASON_3_OFFER_2.getDefault();
        }
        else {
            return MASON_3_OFFER_2.get();
        }
    }
    public static String getMason3Request2() {
        if (Objects.equals(MASON_3_REQUEST_2.get(), MASON_3_REQUEST_2.getDefault())) {
            return MASON_3_REQUEST_2.getDefault();
        }
        else {
            return MASON_3_REQUEST_2.get();
        }
    }
    public static String getMason3Offer1() {
        if (Objects.equals(MASON_3_OFFER_1.get(), MASON_3_OFFER_1.getDefault())) {
            return MASON_3_OFFER_1.getDefault();
        }
        else {
            return MASON_3_OFFER_1.get();
        }
    }
    public static String getMason3Request1() {
        if (Objects.equals(MASON_3_REQUEST_1.get(), MASON_3_REQUEST_1.getDefault())) {
            return MASON_3_REQUEST_1.getDefault();
        }
        else {
            return MASON_3_REQUEST_1.get();
        }
    }
    public static String getMason2Offer2() {
        if (Objects.equals(MASON_2_OFFER_2.get(), MASON_2_OFFER_2.getDefault())) {
            return MASON_2_OFFER_2.getDefault();
        }
        else {
            return MASON_2_OFFER_2.get();
        }
    }
    public static String getMason2Request2() {
        if (Objects.equals(MASON_2_REQUEST_2.get(), MASON_2_REQUEST_2.getDefault())) {
            return MASON_2_REQUEST_2.getDefault();
        }
        else {
            return MASON_2_REQUEST_2.get();
        }
    }
    public static String getMason2Offer1() {
        if (Objects.equals(MASON_2_OFFER_1.get(), MASON_2_OFFER_1.getDefault())) {
            return MASON_2_OFFER_1.getDefault();
        }
        else {
            return MASON_2_OFFER_1.get();
        }
    }
    public static String getMason2Request1() {
        if (Objects.equals(MASON_2_REQUEST_1.get(), MASON_2_REQUEST_1.getDefault())) {
            return MASON_2_REQUEST_1.getDefault();
        }
        else {
            return MASON_2_REQUEST_1.get();
        }
    }
    public static String getMason1Offer2() {
        if (Objects.equals(MASON_1_OFFER_2.get(), MASON_1_OFFER_2.getDefault())) {
            return MASON_1_OFFER_2.getDefault();
        }
        else {
            return MASON_1_OFFER_2.get();
        }
    }
    public static String getMason1Request2() {
        if (Objects.equals(MASON_1_REQUEST_2.get(), MASON_1_REQUEST_2.getDefault())) {
            return MASON_1_REQUEST_2.getDefault();
        }
        else {
            return MASON_1_REQUEST_2.get();
        }
    }
    public static String getMason1Offer1() {
        if (Objects.equals(MASON_1_OFFER_1.get(), MASON_1_OFFER_1.getDefault())) {
            return MASON_1_OFFER_1.getDefault();
        }
        else {
            return MASON_1_OFFER_1.get();
        }
    }
    public static String getMason1Request1() {
        if (Objects.equals(MASON_1_REQUEST_1.get(), MASON_1_REQUEST_1.getDefault())) {
            return MASON_1_REQUEST_1.getDefault();
        }
        else {
            return MASON_1_REQUEST_1.get();
        }
    }
}