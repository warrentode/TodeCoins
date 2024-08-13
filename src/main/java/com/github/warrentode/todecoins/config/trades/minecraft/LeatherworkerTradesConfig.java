package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LeatherworkerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Leatherworker Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEATHERWORKER_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEATHERWORKER_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_5_OFFER_2;

    static {
        // LEATHERWORKER TRADES
        BUILDER.push("Leatherworker Trade Settings");
        // level 1
        BUILDER.push("Leatherworker Level One Trade One");
        LEATHERWORKER_1_REQUEST_1 = BUILDER
                .comment(" Leatherworker 1 Trade Request 1 Table")
                .define("leatherworker_1_trade_request_1_table",
                        TradeLootTables.TAGGED_LEATHER_TABLE.toString());
        LEATHERWORKER_1_REQUEST_1_COUNT = BUILDER
                .define("leatherworker_1_trade_request_1_count", 6);
        LEATHERWORKER_1_OFFER_1 = BUILDER
                .comment(" Leatherworker 1 Trade Offer 1 Table")
                .define("leatherworker_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level One Trade Two")
                .comment(" Dyed Armor Trade");
        LEATHERWORKER_1_REQUEST_2 = BUILDER
                .comment(" Leatherworker 1 Trade Request 2 Table")
                .define("leatherworker_1_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_1_OFFER_2 = BUILDER
                .comment(" Leatherworker 1 Trade Offer 2 Table")
                .define("leatherworker_1_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_LEGGINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level One Trade Three")
                .comment(" Dyed Armor Trade");
        LEATHERWORKER_1_REQUEST_3 = BUILDER
                .comment(" Leatherworker 1 Trade Request 3 Table")
                .define("leatherworker_1_trade_request_3_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_1_OFFER_3 = BUILDER
                .comment(" Leatherworker 1 Trade Offer 3 Table")
                .define("leatherworker_1_trade_offer_3_table",
                        TradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Leatherworker Level Two Trade One");
        LEATHERWORKER_2_REQUEST_1 = BUILDER
                .comment(" Leatherworker 2 Trade Request 1 Table")
                .define("leatherworker_2_trade_request_1_table",
                        TradeLootTables.FLINT_BUY_TABLE.toString());
        LEATHERWORKER_2_OFFER_1 = BUILDER
                .comment(" Leatherworker 2 Trade Offer 1 Table")
                .define("leatherworker_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Two Trade Two")
                .comment(" Dyed Armor Trade");
        LEATHERWORKER_2_REQUEST_2 = BUILDER
                .comment(" Leatherworker 2 Trade Request 2 Table")
                .define("leatherworker_2_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_2_OFFER_2 = BUILDER
                .comment(" Leatherworker 2 Trade Offer 2 Table")
                .define("leatherworker_2_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Two Trade Three")
                .comment(" Dyed Armor Trade");
        LEATHERWORKER_2_REQUEST_3 = BUILDER
                .comment(" Leatherworker 2 Trade Request 3 Table")
                .define("leatherworker_2_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_2_OFFER_3 = BUILDER
                .comment(" Leatherworker 2 Trade Offer 3 Table")
                .define("leatherworker_2_trade_offer_3_table",
                        TradeLootTables.LEATHER_TIER_BOOTS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Leatherworker Level Three Trade One");
        LEATHERWORKER_3_REQUEST_1 = BUILDER
                .comment(" Leatherworker 3 Trade Request 1 Table")
                .define("leatherworker_3_trade_request_1_table",
                        TradeLootTables.TAGGED_LEATHER_TABLE.toString());
        LEATHERWORKER_3_REQUEST_1_COUNT = BUILDER
                .define("leatherworker_3_trade_request_1_count", 6);
        LEATHERWORKER_3_OFFER_1 = BUILDER
                .comment(" Leatherworker 3 Trade Offer 1 Table")
                .define("leatherworker_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Three Trade Two")
                .comment(" Dyed Armor Trade");
        LEATHERWORKER_3_REQUEST_2 = BUILDER
                .comment(" Leatherworker 3 Trade Request 2 Table")
                .define("leatherworker_3_trade_request_2_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_3_OFFER_2 = BUILDER
                .comment(" Leatherworker 3 Trade Offer 2 Table")
                .define("leatherworker_3_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Leatherworker Level Four Trade One");
        LEATHERWORKER_4_REQUEST_1 = BUILDER
                .comment(" Leatherworker 4 Trade Request 1 Table")
                .define("leatherworker_4_trade_request_1_table",
                        TradeLootTables.SCUTE_TABLE.toString());
        LEATHERWORKER_4_OFFER_1 = BUILDER
                .comment(" Leatherworker 4 Trade Offer 1 Table")
                .define("leatherworker_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Four Trade Two")
                .comment(" Dyed Armor Trade");
        LEATHERWORKER_4_REQUEST_2 = BUILDER
                .comment(" Leatherworker 4 Trade Request 2 Table")
                .define("leatherworker_4_trade_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_4_OFFER_2 = BUILDER
                .comment(" Leatherworker 4 Trade Offer 2 Table")
                .define("leatherworker_4_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Leatherworker Level Five Trade One");
        LEATHERWORKER_5_REQUEST_1 = BUILDER
                .comment(" Leatherworker 5 Trade Request 1 Table")
                .define("leatherworker_5_trade_request_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_5_OFFER_1 = BUILDER
                .comment(" Leatherworker 5 Trade Offer 1 Table")
                .define("leatherworker_5_trade_offer_1_table",
                        TradeLootTables.SADDLE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Five Trade Two")
                .comment(" Dyed Armor Trade");
        LEATHERWORKER_5_REQUEST_2 = BUILDER
                .comment(" Leatherworker 5 Trade Request 2 Table")
                .define("leatherworker_5_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_5_OFFER_2 = BUILDER
                .comment(" Leatherworker 5 Trade Offer 2 Table")
                .define("leatherworker_5_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // LEATHERWORKER TRADE GETTERS
    public static String getLeatherworker5Offer2() {
        if (Objects.equals(LEATHERWORKER_5_OFFER_2.get(), LEATHERWORKER_5_OFFER_2.getDefault())) {
            return LEATHERWORKER_5_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_5_OFFER_2.get();
        }
    }
    public static String getLeatherworker5Request2() {
        if (Objects.equals(LEATHERWORKER_5_REQUEST_2.get(), LEATHERWORKER_5_REQUEST_2.getDefault())) {
            return LEATHERWORKER_5_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_5_REQUEST_2.get();
        }
    }
    public static String getLeatherworker5Offer1() {
        if (Objects.equals(LEATHERWORKER_5_OFFER_1.get(), LEATHERWORKER_5_OFFER_1.getDefault())) {
            return LEATHERWORKER_5_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_5_OFFER_1.get();
        }
    }
    public static String getLeatherworker5Request1() {
        if (Objects.equals(LEATHERWORKER_5_REQUEST_1.get(), LEATHERWORKER_5_REQUEST_1.getDefault())) {
            return LEATHERWORKER_5_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_5_REQUEST_1.get();
        }
    }
    public static String getLeatherworker4Offer2() {
        if (Objects.equals(LEATHERWORKER_4_OFFER_2.get(), LEATHERWORKER_4_OFFER_2.getDefault())) {
            return LEATHERWORKER_4_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_4_OFFER_2.get();
        }
    }
    public static String getLeatherworker4Request2() {
        if (Objects.equals(LEATHERWORKER_4_REQUEST_2.get(), LEATHERWORKER_4_REQUEST_2.getDefault())) {
            return LEATHERWORKER_4_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_4_REQUEST_2.get();
        }
    }
    public static String getLeatherworker4Offer1() {
        if (Objects.equals(LEATHERWORKER_4_OFFER_1.get(), LEATHERWORKER_4_OFFER_1.getDefault())) {
            return LEATHERWORKER_4_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_4_OFFER_1.get();
        }
    }
    public static String getLeatherworker4Request1() {
        if (Objects.equals(LEATHERWORKER_4_REQUEST_1.get(), LEATHERWORKER_4_REQUEST_1.getDefault())) {
            return LEATHERWORKER_4_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_4_REQUEST_1.get();
        }
    }
    public static String getLeatherworker3Offer2() {
        if (Objects.equals(LEATHERWORKER_3_OFFER_2.get(), LEATHERWORKER_3_OFFER_2.getDefault())) {
            return LEATHERWORKER_3_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_3_OFFER_2.get();
        }
    }
    public static String getLeatherworker3Request2() {
        if (Objects.equals(LEATHERWORKER_3_REQUEST_2.get(), LEATHERWORKER_3_REQUEST_2.getDefault())) {
            return LEATHERWORKER_3_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_3_REQUEST_2.get();
        }
    }
    public static String getLeatherworker3Offer1() {
        if (Objects.equals(LEATHERWORKER_3_OFFER_1.get(), LEATHERWORKER_3_OFFER_1.getDefault())) {
            return LEATHERWORKER_3_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_3_OFFER_1.get();
        }
    }
    public static int getLeatherworker3Request1Count() {
        if (Objects.equals(LEATHERWORKER_3_REQUEST_1_COUNT.get(), LEATHERWORKER_3_REQUEST_1_COUNT.getDefault())) {
            return LEATHERWORKER_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return LEATHERWORKER_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getLeatherworker3Request1() {
        if (Objects.equals(LEATHERWORKER_3_REQUEST_1.get(), LEATHERWORKER_3_REQUEST_1.getDefault())) {
            return LEATHERWORKER_3_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_3_REQUEST_1.get();
        }
    }
    public static String getLeatherworker2Offer3() {
        if (Objects.equals(LEATHERWORKER_2_OFFER_3.get(), LEATHERWORKER_2_OFFER_3.getDefault())) {
            return LEATHERWORKER_2_OFFER_3.getDefault();
        }
        else {
            return LEATHERWORKER_2_OFFER_3.get();
        }
    }
    public static String getLeatherworker2Request3() {
        if (Objects.equals(LEATHERWORKER_2_REQUEST_3.get(), LEATHERWORKER_2_REQUEST_3.getDefault())) {
            return LEATHERWORKER_2_REQUEST_3.getDefault();
        }
        else {
            return LEATHERWORKER_2_REQUEST_3.get();
        }
    }
    public static String getLeatherworker2Offer2() {
        if (Objects.equals(LEATHERWORKER_2_OFFER_2.get(), LEATHERWORKER_2_OFFER_2.getDefault())) {
            return LEATHERWORKER_2_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_2_OFFER_2.get();
        }
    }
    public static String getLeatherworker2Request2() {
        if (Objects.equals(LEATHERWORKER_2_REQUEST_2.get(), LEATHERWORKER_2_REQUEST_2.getDefault())) {
            return LEATHERWORKER_2_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_2_REQUEST_2.get();
        }
    }
    public static String getLeatherworker2Offer1() {
        if (Objects.equals(LEATHERWORKER_2_OFFER_1.get(), LEATHERWORKER_2_OFFER_1.getDefault())) {
            return LEATHERWORKER_2_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_2_OFFER_1.get();
        }
    }
    public static String getLeatherworker2Request1() {
        if (Objects.equals(LEATHERWORKER_2_REQUEST_1.get(), LEATHERWORKER_2_REQUEST_1.getDefault())) {
            return LEATHERWORKER_2_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_2_REQUEST_1.get();
        }
    }
    public static String getLeatherworker1Offer3() {
        if (Objects.equals(LEATHERWORKER_1_OFFER_3.get(), LEATHERWORKER_1_OFFER_3.getDefault())) {
            return LEATHERWORKER_1_OFFER_3.getDefault();
        }
        else {
            return LEATHERWORKER_1_OFFER_3.get();
        }
    }
    public static String getLeatherworker1Request3() {
        if (Objects.equals(LEATHERWORKER_1_REQUEST_3.get(), LEATHERWORKER_1_REQUEST_3.getDefault())) {
            return LEATHERWORKER_1_REQUEST_3.getDefault();
        }
        else {
            return LEATHERWORKER_1_REQUEST_3.get();
        }
    }
    public static String getLeatherworker1Offer2() {
        if (Objects.equals(LEATHERWORKER_1_OFFER_2.get(), LEATHERWORKER_1_OFFER_2.getDefault())) {
            return LEATHERWORKER_1_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_1_OFFER_2.get();
        }
    }
    public static String getLeatherworker1Request2() {
        if (Objects.equals(LEATHERWORKER_1_REQUEST_2.get(), LEATHERWORKER_1_REQUEST_2.getDefault())) {
            return LEATHERWORKER_1_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_1_REQUEST_2.get();
        }
    }
    public static String getLeatherworker1Offer1() {
        if (Objects.equals(LEATHERWORKER_1_OFFER_1.get(), LEATHERWORKER_1_OFFER_1.getDefault())) {
            return LEATHERWORKER_1_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_1_OFFER_1.get();
        }
    }
    public static int getLeatherworker1Request1Count() {
        if (Objects.equals(LEATHERWORKER_1_REQUEST_1_COUNT.get(), LEATHERWORKER_1_REQUEST_1_COUNT.getDefault())) {
            return LEATHERWORKER_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return LEATHERWORKER_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getLeatherworker1Request1() {
        if (Objects.equals(LEATHERWORKER_1_REQUEST_1.get(), LEATHERWORKER_1_REQUEST_1.getDefault())) {
            return LEATHERWORKER_1_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_1_REQUEST_1.get();
        }
    }
}