package com.github.warrentode.todecoins.config.trades.todecoins;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LeprechaunTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Leprechaun Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_OFFER_3;

    static {
        // LEPRECHAUN TRADES
        BUILDER.push("Leprechaun Trade Settings");
        // level 1
        BUILDER.push("Leprechaun Level One Trade One");
        LEPRECHAUN_1_REQUEST_1 = BUILDER
                .comment(" Leprechaun 1 Trade Request 1 Table")
                .define("leprechaun_1_trade_request_1_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        LEPRECHAUN_1_OFFER_1 = BUILDER
                .comment(" Leprechaun 1 Trade Offer 1 Table")
                .define("leprechaun_1_trade_offer_1_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level One Trade Two");
        LEPRECHAUN_1_REQUEST_2 = BUILDER
                .comment(" Leprechaun 1 Trade Request 2 Table")
                .define("leprechaun_1_trade_request_2_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_1_OFFER_2 = BUILDER
                .comment(" Leprechaun 1 Trade Offer 2 Table")
                .define("leprechaun_1_trade_offer_2_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Leprechaun Level Two Trade One")
                .comment(" Rare Trade");
        LEPRECHAUN_2_REQUEST_1 = BUILDER
                .comment(" Leprechaun 2 Trade Request 1 Table")
                .define("leprechaun_2_trade_request_1_table",
                        TradeLootTables.TWO_POT_OF_GOLD_VALUE_GEMS.toString());
        LEPRECHAUN_2_OFFER_1 = BUILDER
                .comment(" Leprechaun 2 Trade Offer 1 Table")
                .define("leprechaun_2_trade_offer_1_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Two")
                .comment(" Rare Trade");
        LEPRECHAUN_2_REQUEST_2 = BUILDER
                .comment(" Leprechaun 2 Trade Request 2 Table")
                .define("leprechaun_2_trade_request_2_table",
                        TradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS.toString());
        LEPRECHAUN_2_OFFER_2 = BUILDER
                .comment(" Leprechaun 2 Trade Offer 2 Table")
                .define("leprechaun_2_trade_offer_2_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Three")
                .comment(" Rare Trade");
        LEPRECHAUN_2_REQUEST_3 = BUILDER
                .comment(" Leprechaun 2 Trade Request 3 Table")
                .define("leprechaun_2_trade_request_3_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_2_OFFER_3 = BUILDER
                .comment(" Leprechaun 2 Trade Offer 3 Table")
                .define("leprechaun_2_trade_offer_3_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Four")
                .comment(" Rare Trade");
        LEPRECHAUN_2_REQUEST_4 = BUILDER
                .comment(" Leprechaun 2 Trade Request 4 Table")
                .define("leprechaun_2_trade_request_4_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_2_OFFER_4 = BUILDER
                .comment(" Leprechaun 2 Trade Offer 4 Table")
                .define("leprechaun_2_trade_offer_4_table",
                        TradeLootTables.FOUR_POT_OF_GOLD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Five")
                .comment(" Rare Trade");
        LEPRECHAUN_2_REQUEST_5 = BUILDER
                .comment(" Leprechaun 2 Trade Request 5 Table")
                .define("leprechaun_2_trade_request_5_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_2_OFFER_5 = BUILDER
                .comment(" Leprechaun 2 Trade Offer 5 Table")
                .define("leprechaun_2_trade_offer_5_table",
                        TradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Six")
                .comment(" Rare Trade");
        LEPRECHAUN_2_REQUEST_6 = BUILDER
                .comment(" Leprechaun 2 Trade Request 6 Table")
                .define("leprechaun_2_trade_request_6_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_2_OFFER_6 = BUILDER
                .comment(" Leprechaun 2 Trade Offer 6 Table")
                .define("leprechaun_2_trade_offer_6_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Leprechaun Level Three Trade One")
                .comment(" Rare Trade");
        LEPRECHAUN_3_REQUEST_1 = BUILDER
                .comment(" Leprechaun 3 Trade Request 1 Table")
                .define("leprechaun_3_trade_request_1_table",
                        TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_1 = BUILDER
                .comment(" Leprechaun 3 Trade Offer 1 Table")
                .define("leprechaun_3_trade_offer_1_table",
                        TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_ITEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade Two")
                .comment(" Rare Trade");
        LEPRECHAUN_3_REQUEST_2 = BUILDER
                .comment(" Leprechaun 3 Trade Request 2 Table")
                .define("leprechaun_3_trade_request_2_table",
                        TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_2 = BUILDER
                .comment(" Leprechaun 3 Trade Offer 2 Table")
                .define("leprechaun_3_trade_offer_2_table",
                        TradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade Three")
                .comment(" Rare Trade");
        LEPRECHAUN_3_REQUEST_3 = BUILDER
                .comment(" Leprechaun 3 Trade Request 3 Table")
                .define("leprechaun_3_trade_request_3_table",
                        TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_3 = BUILDER
                .comment(" Leprechaun 3 Trade Offer 3 Table")
                .define("leprechaun_3_trade_offer_3_table",
                        TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade Four")
                .comment(" Rare Trade");
        LEPRECHAUN_3_REQUEST_4 = BUILDER
                .comment(" Leprechaun 3 Trade Request 4 Table")
                .define("leprechaun_3_trade_request_4_table",
                        TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_4 = BUILDER
                .comment(" Leprechaun 3 Trade Offer 4 Table")
                .define("leprechaun_3_trade_offer_4_table",
                        TradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade Five")
                .comment(" Rare Trade");
        LEPRECHAUN_3_REQUEST_5 = BUILDER
                .comment(" Leprechaun 3 Trade Request 5 Table")
                .define("leprechaun_3_trade_request_5_table",
                        TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_5 = BUILDER
                .comment(" Leprechaun 3 Trade Offer 5 Table")
                .define("leprechaun_3_trade_offer_5_table",
                        TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_ITEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade Six")
                .comment(" Rare Trade");
        LEPRECHAUN_3_REQUEST_6 = BUILDER
                .comment(" Leprechaun 3 Trade Request 6 Table")
                .define("leprechaun_3_trade_request_6_table",
                        TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_6 = BUILDER
                .comment(" Leprechaun 3 Trade Offer 6 Table")
                .define("leprechaun_3_trade_offer_6_table",
                        TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_GEMS.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Leprechaun Level Four Trade One")
                .comment(" Rare Trade");
        LEPRECHAUN_4_REQUEST_1 = BUILDER
                .comment(" Leprechaun 4 Trade Request 1 Table")
                .define("leprechaun_4_trade_request_1_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY.toString());
        LEPRECHAUN_4_OFFER_1 = BUILDER
                .comment(" Leprechaun 4 Trade Offer 1 Table")
                .define("leprechaun_4_trade_offer_1_table",
                        TradeLootTables.ONE_LUCKY_COIN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Four Trade Two")
                .comment(" Rare Trade");
        LEPRECHAUN_4_REQUEST_2 = BUILDER
                .comment(" Leprechaun 4 Trade Request 2 Table")
                .define("leprechaun_4_trade_request_2_table",
                        TradeLootTables.ONE_LUCKY_COIN_TABLE.toString());
        LEPRECHAUN_4_OFFER_2 = BUILDER
                .comment(" Leprechaun 4 Trade Offer 2 Table")
                .define("leprechaun_4_trade_offer_2_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Leprechaun Level Five Trade One")
                .comment(" Rare Trade");
        LEPRECHAUN_5_REQUEST_1 = BUILDER
                .comment(" Leprechaun 5 Trade Request 1 Table")
                .define("leprechaun_5_trade_request_1_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_GEMS.toString());
        LEPRECHAUN_5_OFFER_1 = BUILDER
                .comment(" Leprechaun 5 Trade Offer 1 Table")
                .define("leprechaun_5_trade_offer_1_table",
                        TradeLootTables.ONE_LUCKY_COIN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Five Trade Two")
                .comment(" Rare Trade");
        LEPRECHAUN_5_REQUEST_2 = BUILDER
                .comment(" Leprechaun 5 Trade Request 2 Table")
                .define("leprechaun_5_trade_request_2_table",
                        TradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS.toString());
        LEPRECHAUN_5_OFFER_2 = BUILDER
                .comment(" Leprechaun 5 Trade Offer 2 Table")
                .define("leprechaun_5_trade_offer_2_table",
                        TradeLootTables.THREE_LUCKY_COIN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Five Trade Three")
                .comment(" Rare Trade");
        LEPRECHAUN_5_REQUEST_3 = BUILDER
                .comment(" Leprechaun 5 Trade Request 3 Table")
                .define("leprechaun_5_trade_request_3_table",
                        TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS.toString());
        LEPRECHAUN_5_OFFER_3 = BUILDER
                .comment(" Leprechaun 5 Trade Offer 3 Table")
                .define("leprechaun_5_trade_offer_3_table",
                        TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // LEPRECHAUN TRADE GETTERS
    public static String getLeprechaun5Offer3() {
        if (Objects.equals(LEPRECHAUN_5_OFFER_3.get(), LEPRECHAUN_5_OFFER_3.getDefault())) {
            return LEPRECHAUN_5_OFFER_3.getDefault();
        }
        else {
            return LEPRECHAUN_5_OFFER_3.get();
        }
    }
    public static String getLeprechaun5Request3() {
        if (Objects.equals(LEPRECHAUN_5_REQUEST_3.get(), LEPRECHAUN_5_REQUEST_3.getDefault())) {
            return LEPRECHAUN_5_REQUEST_3.getDefault();
        }
        else {
            return LEPRECHAUN_5_REQUEST_3.get();
        }
    }
    public static String getLeprechaun5Offer2() {
        if (Objects.equals(LEPRECHAUN_5_OFFER_2.get(), LEPRECHAUN_5_OFFER_2.getDefault())) {
            return LEPRECHAUN_5_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_5_OFFER_2.get();
        }
    }
    public static String getLeprechaun5Request2() {
        if (Objects.equals(LEPRECHAUN_5_REQUEST_2.get(), LEPRECHAUN_5_REQUEST_2.getDefault())) {
            return LEPRECHAUN_5_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_5_REQUEST_2.get();
        }
    }
    public static String getLeprechaun5Offer1() {
        if (Objects.equals(LEPRECHAUN_5_OFFER_1.get(), LEPRECHAUN_5_OFFER_1.getDefault())) {
            return LEPRECHAUN_5_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_5_OFFER_1.get();
        }
    }
    public static String getLeprechaun5Request1() {
        if (Objects.equals(LEPRECHAUN_5_REQUEST_1.get(), LEPRECHAUN_5_REQUEST_1.getDefault())) {
            return LEPRECHAUN_5_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_5_REQUEST_1.get();
        }
    }
    public static String getLeprechaun4Offer2() {
        if (Objects.equals(LEPRECHAUN_4_OFFER_2.get(), LEPRECHAUN_4_OFFER_2.getDefault())) {
            return LEPRECHAUN_4_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_4_OFFER_2.get();
        }
    }
    public static String getLeprechaun4Request2() {
        if (Objects.equals(LEPRECHAUN_4_REQUEST_2.get(), LEPRECHAUN_4_REQUEST_2.getDefault())) {
            return LEPRECHAUN_4_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_4_REQUEST_2.get();
        }
    }
    public static String getLeprechaun4Offer1() {
        if (Objects.equals(LEPRECHAUN_4_OFFER_1.get(), LEPRECHAUN_4_OFFER_1.getDefault())) {
            return LEPRECHAUN_4_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_4_OFFER_1.get();
        }
    }
    public static String getLeprechaun4Request1() {
        if (Objects.equals(LEPRECHAUN_4_REQUEST_1.get(), LEPRECHAUN_4_REQUEST_1.getDefault())) {
            return LEPRECHAUN_4_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_4_REQUEST_1.get();
        }
    }
    public static String getLeprechaun3Offer6() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_6.get(), LEPRECHAUN_3_OFFER_6.getDefault())) {
            return LEPRECHAUN_3_OFFER_6.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_6.get();
        }
    }
    public static String getLeprechaun3Request6() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_6.get(), LEPRECHAUN_3_REQUEST_6.getDefault())) {
            return LEPRECHAUN_3_REQUEST_6.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_6.get();
        }
    }
    public static String getLeprechaun3Offer5() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_5.get(), LEPRECHAUN_3_OFFER_5.getDefault())) {
            return LEPRECHAUN_3_OFFER_5.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_5.get();
        }
    }
    public static String getLeprechaun3Request5() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_5.get(), LEPRECHAUN_3_REQUEST_5.getDefault())) {
            return LEPRECHAUN_3_REQUEST_5.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_5.get();
        }
    }
    public static String getLeprechaun3Offer4() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_4.get(), LEPRECHAUN_3_OFFER_4.getDefault())) {
            return LEPRECHAUN_3_OFFER_4.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_4.get();
        }
    }
    public static String getLeprechaun3Request4() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_4.get(), LEPRECHAUN_3_OFFER_4.getDefault())) {
            return LEPRECHAUN_3_OFFER_4.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_4.get();
        }
    }
    public static String getLeprechaun3Offer3() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_3.get(), LEPRECHAUN_3_OFFER_3.getDefault())) {
            return LEPRECHAUN_3_OFFER_3.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_3.get();
        }
    }
    public static String getLeprechaun3Request3() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_3.get(), LEPRECHAUN_3_REQUEST_3.getDefault())) {
            return LEPRECHAUN_3_REQUEST_3.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_3.get();
        }
    }
    public static String getLeprechaun3Offer2() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_2.get(), LEPRECHAUN_3_OFFER_2.getDefault())) {
            return LEPRECHAUN_3_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_2.get();
        }
    }
    public static String getLeprechaun3Request2() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_2.get(), LEPRECHAUN_3_REQUEST_2.getDefault())) {
            return LEPRECHAUN_3_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_2.get();
        }
    }
    public static String getLeprechaun3Offer1() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_1.get(), LEPRECHAUN_3_OFFER_1.getDefault())) {
            return LEPRECHAUN_3_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_1.get();
        }
    }
    public static String getLeprechaun3Request1() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_1.get(), LEPRECHAUN_3_REQUEST_1.getDefault())) {
            return LEPRECHAUN_3_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_1.get();
        }
    }
    public static String getLeprechaun2Offer6() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_6.get(), LEPRECHAUN_2_OFFER_6.getDefault())) {
            return LEPRECHAUN_2_OFFER_6.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_6.get();
        }
    }
    public static String getLeprechaun2Request6() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_6.get(), LEPRECHAUN_2_REQUEST_6.getDefault())) {
            return LEPRECHAUN_2_REQUEST_6.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_6.get();
        }
    }
    public static String getLeprechaun2Offer5() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_5.get(), LEPRECHAUN_2_OFFER_5.getDefault())) {
            return LEPRECHAUN_2_OFFER_5.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_5.get();
        }
    }
    public static String getLeprechaun2Request5() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_5.get(), LEPRECHAUN_2_REQUEST_5.getDefault())) {
            return LEPRECHAUN_2_REQUEST_5.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_5.get();
        }
    }
    public static String getLeprechaun2Offer4() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_4.get(), LEPRECHAUN_2_OFFER_4.getDefault())) {
            return LEPRECHAUN_2_OFFER_4.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_4.get();
        }
    }
    public static String getLeprechaun2Request4() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_4.get(), LEPRECHAUN_2_REQUEST_4.getDefault())) {
            return LEPRECHAUN_2_REQUEST_4.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_4.get();
        }
    }
    public static String getLeprechaun2Offer3() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_3.get(), LEPRECHAUN_2_OFFER_3.getDefault())) {
            return LEPRECHAUN_2_OFFER_3.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_3.get();
        }
    }
    public static String getLeprechaun2Request3() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_3.get(), LEPRECHAUN_2_REQUEST_3.getDefault())) {
            return LEPRECHAUN_2_REQUEST_3.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_3.get();
        }
    }
    public static String getLeprechaun2Offer2() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_2.get(), LEPRECHAUN_2_OFFER_2.getDefault())) {
            return LEPRECHAUN_2_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_2.get();
        }
    }
    public static String getLeprechaun2Request2() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_2.get(), LEPRECHAUN_2_REQUEST_2.getDefault())) {
            return LEPRECHAUN_2_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_2.get();
        }
    }
    public static String getLeprechaun2Offer1() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_1.get(), LEPRECHAUN_2_OFFER_1.getDefault())) {
            return LEPRECHAUN_2_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_1.get();
        }
    }
    public static String getLeprechaun2Request1() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_1.get(), LEPRECHAUN_2_REQUEST_1.getDefault())) {
            return LEPRECHAUN_2_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_1.get();
        }
    }
    public static String getLeprechaun1Offer2() {
        if (Objects.equals(LEPRECHAUN_1_OFFER_2.get(), LEPRECHAUN_1_OFFER_2.getDefault())) {
            return LEPRECHAUN_1_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_1_OFFER_2.get();
        }
    }
    public static String getLeprechaun1Request2() {
        if (Objects.equals(LEPRECHAUN_1_REQUEST_2.get(), LEPRECHAUN_1_REQUEST_2.getDefault())) {
            return LEPRECHAUN_1_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_1_REQUEST_2.get();
        }
    }
    public static String getLeprechaun1Offer1() {
        if (Objects.equals(LEPRECHAUN_1_OFFER_1.get(), LEPRECHAUN_1_OFFER_1.getDefault())) {
            return LEPRECHAUN_1_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_1_OFFER_1.get();
        }
    }
    public static String getLeprechaun1Request1() {
        if (Objects.equals(LEPRECHAUN_1_REQUEST_1.get(), LEPRECHAUN_1_REQUEST_1.getDefault())) {
            return LEPRECHAUN_1_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_1_REQUEST_1.get();
        }
    }
}