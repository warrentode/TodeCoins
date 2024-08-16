package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClericTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Cleric Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_5_OFFER_2;

    static {
        // CLERIC TRADES
        BUILDER.push("Cleric Trade Settings");
        // level 1
        BUILDER.push("Cleric Level One Trade One");
        CLERIC_1_REQUEST_1 = BUILDER
                .comment(" Cleric 1 Trade Request 1 Table")
                .define("cleric_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        CLERIC_1_OFFER_1 = BUILDER
                .comment(" Cleric 1 Trade Offer 1 Table")
                .define("cleric_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level One Trade Two");
        CLERIC_1_REQUEST_2 = BUILDER
                .comment(" Cleric 1 Trade Request 2 Table")
                .define("cleric_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_1_OFFER_2 = BUILDER
                .comment(" Cleric 1 Trade Offer 2 Table")
                .define("cleric_1_trade_offer_2_table",
                        TradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Cleric Level Two Trade One");
        CLERIC_2_REQUEST_1 = BUILDER
                .comment(" Cleric 2 Trade Request 1 Table")
                .define("cleric_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        CLERIC_2_OFFER_1 = BUILDER
                .comment(" Cleric 2 Trade Offer 1 Table")
                .define("cleric_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Two Trade Two");
        CLERIC_2_REQUEST_2 = BUILDER
                .comment(" Cleric 2 Trade Request 2 Table")
                .define("cleric_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_2_OFFER_2 = BUILDER
                .comment(" Cleric 2 Trade Offer 2 Table")
                .define("cleric_2_trade_offer_2_table",
                        TradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Cleric Level Three Trade One");
        CLERIC_3_REQUEST_1 = BUILDER
                .comment(" Cleric 3 Trade Request 1 Table")
                .define("cleric_3_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        CLERIC_3_OFFER_1 = BUILDER
                .comment(" Cleric 3 Trade Offer 1 Table")
                .define("cleric_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Three Trade Two");
        CLERIC_3_REQUEST_2 = BUILDER
                .comment(" Cleric 3 Trade Request 2 Table")
                .define("cleric_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_3_OFFER_2 = BUILDER
                .comment(" Cleric 3 Trade Offer 2 Table")
                .define("cleric_3_trade_offer_2_table",
                        TradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Cleric Level Four Trade One");
        CLERIC_4_REQUEST_1 = BUILDER
                .comment(" Cleric 4 Trade Request 1 Table")
                .define("cleric_4_trade_request_1_table",
                        TradeLootTables.SCUTE_TABLE.toString());
        CLERIC_4_OFFER_1 = BUILDER
                .comment(" Cleric 4 Trade Offer 1 Table")
                .define("cleric_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Four Trade Two");
        CLERIC_4_REQUEST_2 = BUILDER
                .comment(" Cleric 4 Trade Request 2 Table")
                .define("cleric_4_trade_request_2_table",
                        TradeLootTables.GLASS_BOTTLE_TABLE.toString());
        CLERIC_4_OFFER_2 = BUILDER
                .comment(" Cleric 4 Trade Offer 2 Table")
                .define("cleric_4_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Four Trade Three");
        CLERIC_4_REQUEST_3 = BUILDER
                .comment(" Cleric 4 Trade Request 3 Table")
                .define("cleric_4_trade_request_3_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_4_OFFER_3 = BUILDER
                .comment(" Cleric 4 Trade Offer 3 Table")
                .define("cleric_4_trade_offer_3_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Cleric Level Five Trade One");
        CLERIC_5_REQUEST_1 = BUILDER
                .comment(" Cleric 5 Trade Request 1 Table")
                .define("cleric_5_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        CLERIC_5_OFFER_1 = BUILDER
                .comment(" Cleric 5 Trade Offer 1 Table")
                .define("cleric_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Five Trade Two");
        CLERIC_5_REQUEST_2 = BUILDER
                .comment(" Cleric 5 Trade Request 2 Table")
                .define("cleric_5_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_5_OFFER_2 = BUILDER
                .comment(" Cleric 5 Trade Offer 2 Table")
                .define("cleric_5_trade_offer_2_table",
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // CLERIC TRADE GETTERS
    public static String getCleric5Offer2() {
        if (Objects.equals(CLERIC_5_OFFER_2.get(), CLERIC_5_OFFER_2.getDefault())) {
            return CLERIC_5_OFFER_2.getDefault();
        }
        else {
            return CLERIC_5_OFFER_2.get();
        }
    }
    public static String getCleric5Request2() {
        if (Objects.equals(CLERIC_5_REQUEST_2.get(), CLERIC_5_REQUEST_2.getDefault())) {
            return CLERIC_5_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_5_REQUEST_2.get();
        }
    }
    public static String getCleric5Offer1() {
        if (Objects.equals(CLERIC_5_OFFER_1.get(), CLERIC_5_OFFER_1.getDefault())) {
            return CLERIC_5_OFFER_1.getDefault();
        }
        else {
            return CLERIC_5_OFFER_1.get();
        }
    }
    public static String getCleric5Request1() {
        if (Objects.equals(CLERIC_5_REQUEST_1.get(), CLERIC_5_REQUEST_1.getDefault())) {
            return CLERIC_5_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_5_REQUEST_1.get();
        }
    }
    public static String getCleric4Offer3() {
        if (Objects.equals(CLERIC_4_OFFER_3.get(), CLERIC_4_OFFER_3.getDefault())) {
            return CLERIC_4_OFFER_3.getDefault();
        }
        else {
            return CLERIC_4_OFFER_3.get();
        }
    }
    public static String getCleric4Request3() {
        if (Objects.equals(CLERIC_4_REQUEST_3.get(), CLERIC_4_REQUEST_3.getDefault())) {
            return CLERIC_4_REQUEST_3.getDefault();
        }
        else {
            return CLERIC_4_REQUEST_3.get();
        }
    }
    public static String getCleric4Offer2() {
        if (Objects.equals(CLERIC_4_OFFER_2.get(), CLERIC_4_OFFER_2.getDefault())) {
            return CLERIC_4_OFFER_2.getDefault();
        }
        else {
            return CLERIC_4_OFFER_2.get();
        }
    }
    public static String getCleric4Request2() {
        if (Objects.equals(CLERIC_4_REQUEST_2.get(), CLERIC_4_REQUEST_2.getDefault())) {
            return CLERIC_4_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_4_REQUEST_2.get();
        }
    }
    public static String getCleric4Offer1() {
        if (Objects.equals(CLERIC_4_OFFER_1.get(), CLERIC_4_OFFER_1.getDefault())) {
            return CLERIC_4_OFFER_1.getDefault();
        }
        else {
            return CLERIC_4_OFFER_1.get();
        }
    }
    public static String getCleric4Request1() {
        if (Objects.equals(CLERIC_4_REQUEST_1.get(), CLERIC_4_REQUEST_1.getDefault())) {
            return CLERIC_4_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_4_REQUEST_1.get();
        }
    }
    public static String getCleric3Offer2() {
        if (Objects.equals(CLERIC_3_OFFER_2.get(), CLERIC_3_OFFER_2.getDefault())) {
            return CLERIC_3_OFFER_2.getDefault();
        }
        else {
            return CLERIC_3_OFFER_2.get();
        }
    }
    public static String getCleric3Request2() {
        if (Objects.equals(CLERIC_3_REQUEST_2.get(), CLERIC_3_REQUEST_2.getDefault())) {
            return CLERIC_3_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_3_REQUEST_2.get();
        }
    }
    public static String getCleric3Offer1() {
        if (Objects.equals(CLERIC_3_OFFER_1.get(), CLERIC_3_OFFER_1.getDefault())) {
            return CLERIC_3_OFFER_1.getDefault();
        }
        else {
            return CLERIC_3_OFFER_1.get();
        }
    }
    public static String getCleric3Request1() {
        if (Objects.equals(CLERIC_3_REQUEST_1.get(), CLERIC_3_REQUEST_1.getDefault())) {
            return CLERIC_3_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_3_REQUEST_1.get();
        }
    }
    public static String getCleric2Offer2() {
        if (Objects.equals(CLERIC_2_OFFER_2.get(), CLERIC_2_OFFER_2.getDefault())) {
            return CLERIC_2_OFFER_2.getDefault();
        }
        else {
            return CLERIC_2_OFFER_2.get();
        }
    }
    public static String getCleric2Request2() {
        if (Objects.equals(CLERIC_2_REQUEST_2.get(), CLERIC_2_REQUEST_2.getDefault())) {
            return CLERIC_2_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_2_REQUEST_2.get();
        }
    }
    public static String getCleric2Offer1() {
        if (Objects.equals(CLERIC_2_OFFER_1.get(), CLERIC_2_OFFER_1.getDefault())) {
            return CLERIC_2_OFFER_1.getDefault();
        }
        else {
            return CLERIC_2_OFFER_1.get();
        }
    }
    public static String getCleric2Request1() {
        if (Objects.equals(CLERIC_2_REQUEST_1.get(), CLERIC_2_REQUEST_1.getDefault())) {
            return CLERIC_2_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_2_REQUEST_1.get();
        }
    }
    public static String getCleric1Offer2() {
        if (Objects.equals(CLERIC_1_OFFER_2.get(), CLERIC_1_OFFER_2.getDefault())) {
            return CLERIC_1_OFFER_2.getDefault();
        }
        else {
            return CLERIC_1_OFFER_2.get();
        }
    }
    public static String getCleric1Request2() {
        if (Objects.equals(CLERIC_1_REQUEST_2.get(), CLERIC_1_REQUEST_2.getDefault())) {
            return CLERIC_1_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_1_REQUEST_2.get();
        }
    }
    public static String getCleric1Offer1() {
        if (Objects.equals(CLERIC_1_OFFER_1.get(), CLERIC_1_OFFER_1.getDefault())) {
            return CLERIC_1_OFFER_1.getDefault();
        }
        else {
            return CLERIC_1_OFFER_1.get();
        }
    }
    public static String getCleric1Request1() {
        if (Objects.equals(CLERIC_1_REQUEST_1.get(), CLERIC_1_REQUEST_1.getDefault())) {
            return CLERIC_1_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_1_REQUEST_1.get();
        }
    }
}