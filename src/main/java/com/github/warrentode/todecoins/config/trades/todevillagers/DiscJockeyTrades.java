package com.github.warrentode.todecoins.config.trades.todevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DiscJockeyTrades {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Disc Jockey Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> DISC_JOCKEY_5_OFFER_2;

    static {
        // DISC_JOCKEY TRADES
        BUILDER.push("DiscJockey Trade Settings");
        // level 1
        BUILDER.push("DiscJockey Level One Trade One");
        DISC_JOCKEY_1_REQUEST_1 = BUILDER
                .comment(" DiscJockey 1 Trade Request 1 Table")
                .define("disc_jockey_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        DISC_JOCKEY_1_OFFER_1 = BUILDER
                .comment(" DiscJockey 1 Trade Offer 1 Table")
                .define("disc_jockey_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("DiscJockey Level One Trade Two");
        DISC_JOCKEY_1_REQUEST_2 = BUILDER
                .comment(" DiscJockey 1 Trade Request 2 Table")
                .define("disc_jockey_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        DISC_JOCKEY_1_OFFER_2 = BUILDER
                .comment(" DiscJockey 1 Trade Offer 2 Table")
                .define("disc_jockey_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("DiscJockey Level One Trade Three");
        DISC_JOCKEY_1_REQUEST_3 = BUILDER
                .comment(" DiscJockey 1 Trade Request 3 Table")
                .define("disc_jockey_1_trade_request_3_table",
                        TradeLootTables.DISC_FRAGMENTS_TABLE.toString());
        DISC_JOCKEY_1_OFFER_3 = BUILDER
                .comment(" DiscJockey 1 Trade Offer 3 Table")
                .define("disc_jockey_1_trade_offer_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("DiscJockey Level Two Trade One")
                .comment(" Rare Trade");
        DISC_JOCKEY_2_REQUEST_1 = BUILDER
                .comment(" DiscJockey 2 Trade Request 1 Table")
                .define("disc_jockey_2_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        DISC_JOCKEY_2_OFFER_1 = BUILDER
                .comment(" DiscJockey 2 Trade Offer 1 Table")
                .define("disc_jockey_2_trade_offer_1_table",
                        TradeLootTables.MUSIC_DISC_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("DiscJockey Level Two Trade Two");
        DISC_JOCKEY_2_REQUEST_2 = BUILDER
                .comment(" DiscJockey 2 Trade Request 2 Table")
                .define("disc_jockey_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        DISC_JOCKEY_2_OFFER_2 = BUILDER
                .comment(" DiscJockey 2 Trade Offer 2 Table")
                .define("disc_jockey_2_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("DiscJockey Level Three Trade One")
                .comment(" Rare Trade");
        DISC_JOCKEY_3_REQUEST_1 = BUILDER
                .comment(" DiscJockey 3 Trade Request 1 Table")
                .define("disc_jockey_3_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        DISC_JOCKEY_3_OFFER_1 = BUILDER
                .comment(" DiscJockey 3 Trade Offer 1 Table")
                .define("disc_jockey_3_trade_offer_1_table",
                        TradeLootTables.MUSIC_DISC_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("DiscJockey Level Three Trade Two");
        DISC_JOCKEY_3_REQUEST_2 = BUILDER
                .comment(" DiscJockey 3 Trade Request 2 Table")
                .define("disc_jockey_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        DISC_JOCKEY_3_OFFER_2 = BUILDER
                .comment(" DiscJockey 3 Trade Offer 2 Table")
                .define("disc_jockey_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("DiscJockey Level Four Trade One")
                .comment(" Rare Trade");
        DISC_JOCKEY_4_REQUEST_1 = BUILDER
                .comment(" DiscJockey 4 Trade Request 1 Table")
                .define("disc_jockey_4_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        DISC_JOCKEY_4_OFFER_1 = BUILDER
                .comment(" DiscJockey 4 Trade Offer 1 Table")
                .define("disc_jockey_4_trade_offer_1_table",
                        TradeLootTables.MUSIC_DISC_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("DiscJockey Level Four Trade Two");
        DISC_JOCKEY_4_REQUEST_2 = BUILDER
                .comment(" DiscJockey 4 Trade Request 2 Table")
                .define("disc_jockey_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        DISC_JOCKEY_4_OFFER_2 = BUILDER
                .comment(" DiscJockey 4 Trade Offer 2 Table")
                .define("disc_jockey_4_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("DiscJockey Level Five Trade One")
                .comment(" Rare Trade");
        DISC_JOCKEY_5_REQUEST_1 = BUILDER
                .comment(" DiscJockey 5 Trade Request 1 Table")
                .define("disc_jockey_5_trade_request_1_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        DISC_JOCKEY_5_OFFER_1 = BUILDER
                .comment(" DiscJockey 5 Trade Offer 1 Table")
                .define("disc_jockey_5_trade_offer_1_table",
                        TradeLootTables.MUSIC_DISC_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("DiscJockey Level Five Trade Two");
        DISC_JOCKEY_5_REQUEST_2 = BUILDER
                .comment(" DiscJockey 5 Trade Request 2 Table")
                .define("disc_jockey_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        DISC_JOCKEY_5_OFFER_2 = BUILDER
                .comment(" DiscJockey 5 Trade Offer 2 Table")
                .define("disc_jockey_5_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // DISC_JOCKEY TRADE GETTERS
    public static String getDiscJockey5Offer2() {
        if (Objects.equals(DISC_JOCKEY_5_OFFER_2.get(), DISC_JOCKEY_5_OFFER_2.getDefault())) {
            return DISC_JOCKEY_5_OFFER_2.getDefault();
        }
        else {
            return DISC_JOCKEY_5_OFFER_2.get();
        }
    }
    public static String getDiscJockey5Request2() {
        if (Objects.equals(DISC_JOCKEY_5_REQUEST_2.get(), DISC_JOCKEY_5_REQUEST_2.getDefault())) {
            return DISC_JOCKEY_5_REQUEST_2.getDefault();
        }
        else {
            return DISC_JOCKEY_5_REQUEST_2.get();
        }
    }
    public static String getDiscJockey5Offer1() {
        if (Objects.equals(DISC_JOCKEY_5_OFFER_1.get(), DISC_JOCKEY_5_OFFER_1.getDefault())) {
            return DISC_JOCKEY_5_OFFER_1.getDefault();
        }
        else {
            return DISC_JOCKEY_5_OFFER_1.get();
        }
    }
    public static String getDiscJockey5Request1() {
        if (Objects.equals(DISC_JOCKEY_5_REQUEST_1.get(), DISC_JOCKEY_5_REQUEST_1.getDefault())) {
            return DISC_JOCKEY_5_REQUEST_1.getDefault();
        }
        else {
            return DISC_JOCKEY_5_REQUEST_1.get();
        }
    }
    public static String getDiscJockey4Offer2() {
        if (Objects.equals(DISC_JOCKEY_4_OFFER_2.get(), DISC_JOCKEY_4_OFFER_2.getDefault())) {
            return DISC_JOCKEY_4_OFFER_2.getDefault();
        }
        else {
            return DISC_JOCKEY_4_OFFER_2.get();
        }
    }
    public static String getDiscJockey4Request2() {
        if (Objects.equals(DISC_JOCKEY_4_REQUEST_2.get(), DISC_JOCKEY_4_REQUEST_2.getDefault())) {
            return DISC_JOCKEY_4_REQUEST_2.getDefault();
        }
        else {
            return DISC_JOCKEY_4_REQUEST_2.get();
        }
    }
    public static String getDiscJockey4Offer1() {
        if (Objects.equals(DISC_JOCKEY_4_OFFER_1.get(), DISC_JOCKEY_4_OFFER_1.getDefault())) {
            return DISC_JOCKEY_4_OFFER_1.getDefault();
        }
        else {
            return DISC_JOCKEY_4_OFFER_1.get();
        }
    }
    public static String getDiscJockey4Request1() {
        if (Objects.equals(DISC_JOCKEY_4_REQUEST_1.get(), DISC_JOCKEY_4_REQUEST_1.getDefault())) {
            return DISC_JOCKEY_4_REQUEST_1.getDefault();
        }
        else {
            return DISC_JOCKEY_4_REQUEST_1.get();
        }
    }
    public static String getDiscJockey3Offer2() {
        if (Objects.equals(DISC_JOCKEY_3_OFFER_2.get(), DISC_JOCKEY_3_OFFER_2.getDefault())) {
            return DISC_JOCKEY_3_OFFER_2.getDefault();
        }
        else {
            return DISC_JOCKEY_3_OFFER_2.get();
        }
    }
    public static String getDiscJockey3Request2() {
        if (Objects.equals(DISC_JOCKEY_3_REQUEST_2.get(), DISC_JOCKEY_3_REQUEST_2.getDefault())) {
            return DISC_JOCKEY_3_REQUEST_2.getDefault();
        }
        else {
            return DISC_JOCKEY_3_REQUEST_2.get();
        }
    }
    public static String getDiscJockey3Offer1() {
        if (Objects.equals(DISC_JOCKEY_3_OFFER_1.get(), DISC_JOCKEY_3_OFFER_1.getDefault())) {
            return DISC_JOCKEY_3_OFFER_1.getDefault();
        }
        else {
            return DISC_JOCKEY_3_OFFER_1.get();
        }
    }
    public static String getDiscJockey3Request1() {
        if (Objects.equals(DISC_JOCKEY_3_REQUEST_1.get(), DISC_JOCKEY_3_REQUEST_1.getDefault())) {
            return DISC_JOCKEY_3_REQUEST_1.getDefault();
        }
        else {
            return DISC_JOCKEY_3_REQUEST_1.get();
        }
    }
    public static String getDiscJockey2Offer2() {
        if (Objects.equals(DISC_JOCKEY_2_OFFER_2.get(), DISC_JOCKEY_2_OFFER_2.getDefault())) {
            return DISC_JOCKEY_2_OFFER_2.getDefault();
        }
        else {
            return DISC_JOCKEY_2_OFFER_2.get();
        }
    }
    public static String getDiscJockey2Request2() {
        if (Objects.equals(DISC_JOCKEY_2_REQUEST_2.get(), DISC_JOCKEY_2_REQUEST_2.getDefault())) {
            return DISC_JOCKEY_2_REQUEST_2.getDefault();
        }
        else {
            return DISC_JOCKEY_2_REQUEST_2.get();
        }
    }
    public static String getDiscJockey2Offer1() {
        if (Objects.equals(DISC_JOCKEY_2_OFFER_1.get(), DISC_JOCKEY_2_OFFER_1.getDefault())) {
            return DISC_JOCKEY_2_OFFER_1.getDefault();
        }
        else {
            return DISC_JOCKEY_2_OFFER_1.get();
        }
    }
    public static String getDiscJockey2Request1() {
        if (Objects.equals(DISC_JOCKEY_2_REQUEST_1.get(), DISC_JOCKEY_2_REQUEST_1.getDefault())) {
            return DISC_JOCKEY_2_REQUEST_1.getDefault();
        }
        else {
            return DISC_JOCKEY_2_REQUEST_1.get();
        }
    }
    public static String getDiscJockey1Offer3() {
        if (Objects.equals(DISC_JOCKEY_1_OFFER_3.get(), DISC_JOCKEY_1_OFFER_3.getDefault())) {
            return DISC_JOCKEY_1_OFFER_3.getDefault();
        }
        else {
            return DISC_JOCKEY_1_OFFER_3.get();
        }
    }
    public static String getDiscJockey1Request3() {
        if (Objects.equals(DISC_JOCKEY_1_REQUEST_3.get(), DISC_JOCKEY_1_REQUEST_3.getDefault())) {
            return DISC_JOCKEY_1_REQUEST_3.getDefault();
        }
        else {
            return DISC_JOCKEY_1_REQUEST_3.get();
        }
    }
    public static String getDiscJockey1Offer2() {
        if (Objects.equals(DISC_JOCKEY_1_OFFER_2.get(), DISC_JOCKEY_1_OFFER_2.getDefault())) {
            return DISC_JOCKEY_1_OFFER_2.getDefault();
        }
        else {
            return DISC_JOCKEY_1_OFFER_2.get();
        }
    }
    public static String getDiscJockey1Request2() {
        if (Objects.equals(DISC_JOCKEY_1_REQUEST_2.get(), DISC_JOCKEY_1_REQUEST_2.getDefault())) {
            return DISC_JOCKEY_1_REQUEST_2.getDefault();
        }
        else {
            return DISC_JOCKEY_1_REQUEST_2.get();
        }
    }
    public static String getDiscJockey1Offer1() {
        if (Objects.equals(DISC_JOCKEY_1_OFFER_1.get(), DISC_JOCKEY_1_OFFER_1.getDefault())) {
            return DISC_JOCKEY_1_OFFER_1.getDefault();
        }
        else {
            return DISC_JOCKEY_1_OFFER_1.get();
        }
    }
    public static String getDiscJockey1Request1() {
        if (Objects.equals(DISC_JOCKEY_1_REQUEST_1.get(), DISC_JOCKEY_1_REQUEST_1.getDefault())) {
            return DISC_JOCKEY_1_REQUEST_1.getDefault();
        }
        else {
            return DISC_JOCKEY_1_REQUEST_1.get();
        }
    }
}