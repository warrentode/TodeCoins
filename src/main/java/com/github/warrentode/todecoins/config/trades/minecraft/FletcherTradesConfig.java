package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FletcherTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Fletcher Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FLETCHER_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FLETCHER_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FLETCHER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_5_REQUEST_2;

    static {
        // FLETCHER TRADES
        BUILDER.push("Fletcher Trade Settings");
        // level 1
        BUILDER.push("Fletcher Level One Trade One");
        FLETCHER_1_REQUEST_1 = BUILDER
                .comment(" Fletcher 1 Trade Request 1 Table")
                .define("fletcher_1_trade_request_1_table",
                        TradeLootTables.TAGGED_STICK_TABLE.toString());
        FLETCHER_1_REQUEST_1_COUNT = BUILDER
                .defineInRange("fletcher_1_trade_request_1_count", 16, 1, 64);
        FLETCHER_1_OFFER_1 = BUILDER
                .comment(" Fletcher 1 Trade Offer 1 Table")
                .define("fletcher_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level One Trade Two");
        FLETCHER_1_REQUEST_2 = BUILDER
                .comment(" Fletcher 1 Trade Request 2 Table")
                .define("fletcher_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FLETCHER_1_REQUEST_2_SECONDARY = BUILDER
                .comment(" Fletcher 1 Trade Secondary Request 2 Table")
                .define("fletcher_1_trade_secondary_request_2_table",
                        TradeLootTables.GRAVEL_TABLE.toString());
        FLETCHER_1_OFFER_2 = BUILDER
                .comment(" Fletcher 1 Trade Offer 2 Table")
                .define("fletcher_1_trade_offer_2_table",
                        TradeLootTables.FLINT_SELL_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Fletcher Level Two Trade One");
        FLETCHER_2_REQUEST_1 = BUILDER
                .comment(" Fletcher 2 Trade Request 1 Table")
                .define("fletcher_2_trade_request_1_table",
                        TradeLootTables.FLINT_BUY_TABLE.toString());
        FLETCHER_2_OFFER_1 = BUILDER
                .comment(" Fletcher 2 Trade Offer 1 Table")
                .define("fletcher_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level Two Trade Two");
        FLETCHER_2_REQUEST_2 = BUILDER
                .comment(" Fletcher 2 Trade Request 2 Table")
                .define("fletcher_2_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        FLETCHER_2_OFFER_2 = BUILDER
                .comment(" Fletcher 2 Trade Offer 2 Table")
                .define("fletcher_2_trade_offer_2_table",
                        TradeLootTables.BOWS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Fletcher Level Three Trade One");
        FLETCHER_3_REQUEST_1 = BUILDER
                .comment(" Fletcher 3 Trade Request 1 Table")
                .define("fletcher_3_trade_request_1_table",
                        TradeLootTables.TAGGED_STRING_TABLE.toString());
        FLETCHER_3_REQUEST_1_COUNT = BUILDER
                .defineInRange("fletcher_3_trade_request_1_count", 16, 1, 64);
        FLETCHER_3_OFFER_1 = BUILDER
                .comment(" Fletcher 3 Trade Offer 1 Table")
                .define("fletcher_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level Three Trade Two");
        FLETCHER_3_REQUEST_2 = BUILDER
                .comment(" Fletcher 3 Trade Request 2 Table")
                .define("fletcher_3_trade_request_2_table",
                        TradeLootTables.FEATHER_TABLE.toString());
        FLETCHER_3_OFFER_2 = BUILDER
                .comment(" Fletcher 3 Trade Offer 2 Table")
                .define("fletcher_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Fletcher Level Four Trade One")
                .comment(" Enchanted Item Trade")
                .comment(" Rare Trade");
        FLETCHER_4_REQUEST_1 = BUILDER
                .comment(" Fletcher 4 Trade Request 1 Table")
                .define("fletcher_4_trade_request_1_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        FLETCHER_4_OFFER_1 = BUILDER
                .comment(" Fletcher 4 Trade Offer 1 Table")
                .define("fletcher_4_trade_offer_1_table",
                        TradeLootTables.BOWS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level Four Trade Two");
        FLETCHER_4_REQUEST_2 = BUILDER
                .comment(" Fletcher 4 Trade Request 2 Table")
                .comment(" Available if Supplementaries mod is Loaded")
                .define("fletcher_4_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        FLETCHER_4_OFFER_2 = BUILDER
                .comment(" Fletcher 4 Trade Offer 2 Table")
                .comment(" Available if Supplementaries mod is Loaded")
                .define("fletcher_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_QUIVERS_TABLE.toString());
        FLETCHER_4_OFFER_2_COUNT = BUILDER
                .defineInRange("fletcher_4_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Fletcher Level Four Trade Two");
        FLETCHER_4_REQUEST_3 = BUILDER
                .comment(" Fletcher 4 Trade Request 3 Table")
                .define("fletcher_4_trade_request_3_table",
                        TradeLootTables.TRIPWIRE_HOOK_TABLE.toString());
        FLETCHER_4_OFFER_3 = BUILDER
                .comment(" Fletcher 4 Trade Offer 3 Table")
                .define("fletcher_4_trade_offer_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Fletcher Level Five Trade One")
                .comment(" Tipped Arrow Trade");
        FLETCHER_5_REQUEST_1 = BUILDER
                .comment(" Fletcher 5 Trade Request 1 Table")
                .define("fletcher_5_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level Five Trade Two")
                .comment(" Tipped Arrow Trade");
        FLETCHER_5_REQUEST_2 = BUILDER
                .comment(" Fletcher 5 Trade Request 2 Table")
                .define("fletcher_5_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // FLETCHER TRADE GETTERS
    public static String getFletcher5Request2() {
        if (Objects.equals(FLETCHER_5_REQUEST_2.get(), FLETCHER_5_REQUEST_2.getDefault())) {
            return FLETCHER_5_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_5_REQUEST_2.get();
        }
    }
    public static String getFletcher5Request1() {
        if (Objects.equals(FLETCHER_5_REQUEST_1.get(), FLETCHER_5_REQUEST_1.getDefault())) {
            return FLETCHER_5_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_5_REQUEST_1.get();
        }
    }
    public static String getFletcher4Offer3() {
        if (Objects.equals(FLETCHER_4_OFFER_3.get(), FLETCHER_4_OFFER_3.getDefault())) {
            return FLETCHER_4_OFFER_3.getDefault();
        }
        else {
            return FLETCHER_4_OFFER_3.get();
        }
    }
    public static String getFletcher4Request3() {
        if (Objects.equals(FLETCHER_4_REQUEST_3.get(), FLETCHER_4_REQUEST_3.getDefault())) {
            return FLETCHER_4_REQUEST_3.getDefault();
        }
        else {
            return FLETCHER_4_REQUEST_3.get();
        }
    }
    public static int getFletcher4Offer2Count() {
        if (Objects.equals(FLETCHER_4_OFFER_2_COUNT.get(), FLETCHER_4_OFFER_2_COUNT.getDefault())) {
            return FLETCHER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return FLETCHER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getFletcher4Offer2() {
        if (Objects.equals(FLETCHER_4_OFFER_2.get(), FLETCHER_4_OFFER_2.getDefault())) {
            return FLETCHER_4_OFFER_2.getDefault();
        }
        else {
            return FLETCHER_4_OFFER_2.get();
        }
    }
    public static String getFletcher4Request2() {
        if (Objects.equals(FLETCHER_4_REQUEST_2.get(), FLETCHER_4_REQUEST_2.getDefault())) {
            return FLETCHER_4_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_4_REQUEST_2.get();
        }
    }
    public static String getFletcher4Offer1() {
        if (Objects.equals(FLETCHER_4_OFFER_1.get(), FLETCHER_4_OFFER_1.getDefault())) {
            return FLETCHER_4_OFFER_1.getDefault();
        }
        else {
            return FLETCHER_4_OFFER_1.get();
        }
    }
    public static String getFletcher4Request1() {
        if (Objects.equals(FLETCHER_4_REQUEST_1.get(), FLETCHER_4_REQUEST_1.getDefault())) {
            return FLETCHER_4_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_4_REQUEST_1.get();
        }
    }
    public static String getFletcher3Offer2() {
        if (Objects.equals(FLETCHER_3_OFFER_2.get(), FLETCHER_3_OFFER_2.getDefault())) {
            return FLETCHER_3_OFFER_2.getDefault();
        }
        else {
            return FLETCHER_3_OFFER_2.get();
        }
    }
    public static String getFletcher3Request2() {
        if (Objects.equals(FLETCHER_3_REQUEST_2.get(), FLETCHER_3_REQUEST_2.getDefault())) {
            return FLETCHER_3_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_3_REQUEST_2.get();
        }
    }
    public static String getFletcher3Offer1() {
        if (Objects.equals(FLETCHER_3_OFFER_1.get(), FLETCHER_3_OFFER_1.getDefault())) {
            return FLETCHER_3_OFFER_1.getDefault();
        }
        else {
            return FLETCHER_3_OFFER_1.get();
        }
    }
    public static int getFletcher3Request1Count() {
        if (Objects.equals(FLETCHER_3_REQUEST_1_COUNT.get(), FLETCHER_3_REQUEST_1_COUNT.getDefault())) {
            return FLETCHER_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FLETCHER_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getFletcher3Request1() {
        if (Objects.equals(FLETCHER_3_REQUEST_1.get(), FLETCHER_3_REQUEST_1.getDefault())) {
            return FLETCHER_3_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_3_REQUEST_1.get();
        }
    }
    public static String getFletcher2Offer2() {
        if (Objects.equals(FLETCHER_2_OFFER_2.get(), FLETCHER_2_OFFER_2.getDefault())) {
            return FLETCHER_2_OFFER_2.getDefault();
        }
        else {
            return FLETCHER_2_OFFER_2.get();
        }
    }
    public static String getFletcher2Request2() {
        if (Objects.equals(FLETCHER_2_REQUEST_2.get(), FLETCHER_2_REQUEST_2.getDefault())) {
            return FLETCHER_2_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_2_REQUEST_2.get();
        }
    }
    public static String getFletcher2Offer1() {
        if (Objects.equals(FLETCHER_2_OFFER_1.get(), FLETCHER_2_OFFER_1.getDefault())) {
            return FLETCHER_2_OFFER_1.getDefault();
        }
        else {
            return FLETCHER_2_OFFER_1.get();
        }
    }
    public static String getFletcher2Request1() {
        if (Objects.equals(FLETCHER_2_REQUEST_1.get(), FLETCHER_2_REQUEST_1.getDefault())) {
            return FLETCHER_2_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_2_REQUEST_1.get();
        }
    }
    public static String getFletcher1Offer2() {
        if (Objects.equals(FLETCHER_1_OFFER_2.get(), FLETCHER_1_OFFER_2.getDefault())) {
            return FLETCHER_1_OFFER_2.getDefault();
        }
        else {
            return FLETCHER_1_OFFER_2.get();
        }
    }
    public static String getFletcher1Request2Secondary() {
        if (Objects.equals(FLETCHER_1_REQUEST_2_SECONDARY.get(), FLETCHER_1_REQUEST_2_SECONDARY.getDefault())) {
            return FLETCHER_1_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return FLETCHER_1_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getFletcher1Request2() {
        if (Objects.equals(FLETCHER_1_REQUEST_2.get(), FLETCHER_1_REQUEST_2.getDefault())) {
            return FLETCHER_1_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_1_REQUEST_2.get();
        }
    }
    public static String getFletcher1Offer1() {
        if (Objects.equals(FLETCHER_1_OFFER_1.get(), FLETCHER_1_OFFER_1.getDefault())) {
            return FLETCHER_1_OFFER_1.getDefault();
        }
        else {
            return FLETCHER_1_OFFER_1.get();
        }
    }
    public static int getFletcher1Request1Count() {
        if (Objects.equals(FLETCHER_1_REQUEST_1_COUNT.get(), FLETCHER_1_REQUEST_1_COUNT.getDefault())) {
            return FLETCHER_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FLETCHER_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getFletcher1Request1() {
        if (Objects.equals(FLETCHER_1_REQUEST_1.get(), FLETCHER_1_REQUEST_1.getDefault())) {
            return FLETCHER_1_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_1_REQUEST_1.get();
        }
    }
}