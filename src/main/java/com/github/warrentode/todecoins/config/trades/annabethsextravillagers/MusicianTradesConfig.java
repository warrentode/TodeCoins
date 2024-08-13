package com.github.warrentode.todecoins.config.trades.annabethsextravillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusicianTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Musician Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MUSICIAN_5_OFFER_2;

    static {
        // MUSICIAN TRADES
        BUILDER.push("Musician Trade Settings");
        // level 1
        BUILDER.push("Musician Level One Trade One");
        MUSICIAN_1_REQUEST_1 = BUILDER
                .comment(" Musician 1 Trade Request 1 Table")
                .define("musician_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        MUSICIAN_1_OFFER_1 = BUILDER
                .comment(" Musician 1 Trade Offer 1 Table")
                .define("musician_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Musician Level One Trade Two");
        MUSICIAN_1_REQUEST_2 = BUILDER
                .comment(" Musician 1 Trade Request 2 Table")
                .define("musician_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MUSICIAN_1_OFFER_2 = BUILDER
                .comment(" Musician 1 Trade Offer 2 Table")
                .define("musician_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Musician Level One Trade Three");
        MUSICIAN_1_REQUEST_3 = BUILDER
                .comment(" Musician 1 Trade Request 3 Table")
                .define("musician_1_trade_request_3_table",
                        TradeLootTables.DISC_FRAGMENTS_TABLE.toString());
        MUSICIAN_1_OFFER_3 = BUILDER
                .comment(" Musician 1 Trade Offer 3 Table")
                .define("musician_1_trade_offer_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Musician Level Two Trade One")
                .comment(" Rare Trade");
        MUSICIAN_2_REQUEST_1 = BUILDER
                .comment(" Musician 2 Trade Request 1 Table")
                .define("musician_2_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        MUSICIAN_2_OFFER_1 = BUILDER
                .comment(" Musician 2 Trade Offer 1 Table")
                .define("musician_2_trade_offer_1_table",
                        TradeLootTables.MUSIC_DISC_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Musician Level Two Trade Two");
        MUSICIAN_2_REQUEST_2 = BUILDER
                .comment(" Musician 2 Trade Request 2 Table")
                .define("musician_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        MUSICIAN_2_OFFER_2 = BUILDER
                .comment(" Musician 2 Trade Offer 2 Table")
                .define("musician_2_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Musician Level Three Trade One")
                .comment(" Rare Trade");
        MUSICIAN_3_REQUEST_1 = BUILDER
                .comment(" Musician 3 Trade Request 1 Table")
                .define("musician_3_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        MUSICIAN_3_OFFER_1 = BUILDER
                .comment(" Musician 3 Trade Offer 1 Table")
                .define("musician_3_trade_offer_1_table",
                        TradeLootTables.MUSIC_DISC_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Musician Level Three Trade Two");
        MUSICIAN_3_REQUEST_2 = BUILDER
                .comment(" Musician 3 Trade Request 2 Table")
                .define("musician_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        MUSICIAN_3_OFFER_2 = BUILDER
                .comment(" Musician 3 Trade Offer 2 Table")
                .define("musician_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Musician Level Four Trade One")
                .comment(" Rare Trade");
        MUSICIAN_4_REQUEST_1 = BUILDER
                .comment(" Musician 4 Trade Request 1 Table")
                .define("musician_4_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        MUSICIAN_4_OFFER_1 = BUILDER
                .comment(" Musician 4 Trade Offer 1 Table")
                .define("musician_4_trade_offer_1_table",
                        TradeLootTables.MUSIC_DISC_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Musician Level Four Trade Two");
        MUSICIAN_4_REQUEST_2 = BUILDER
                .comment(" Musician 4 Trade Request 2 Table")
                .define("musician_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        MUSICIAN_4_OFFER_2 = BUILDER
                .comment(" Musician 4 Trade Offer 2 Table")
                .define("musician_4_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Musician Level Five Trade One")
                .comment(" Rare Trade");
        MUSICIAN_5_REQUEST_1 = BUILDER
                .comment(" Musician 5 Trade Request 1 Table")
                .define("musician_5_trade_request_1_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        MUSICIAN_5_OFFER_1 = BUILDER
                .comment(" Musician 5 Trade Offer 1 Table")
                .define("musician_5_trade_offer_1_table",
                        TradeLootTables.MUSIC_DISC_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Musician Level Five Trade Two");
        MUSICIAN_5_REQUEST_2 = BUILDER
                .comment(" Musician 5 Trade Request 2 Table")
                .define("musician_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        MUSICIAN_5_OFFER_2 = BUILDER
                .comment(" Musician 5 Trade Offer 2 Table")
                .define("musician_5_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // MUSICIAN TRADE GETTERS
    public static String getMusician5Offer2() {
        if (Objects.equals(MUSICIAN_5_OFFER_2.get(), MUSICIAN_5_OFFER_2.getDefault())) {
            return MUSICIAN_5_OFFER_2.getDefault();
        }
        else {
            return MUSICIAN_5_OFFER_2.get();
        }
    }
    public static String getMusician5Request2() {
        if (Objects.equals(MUSICIAN_5_REQUEST_2.get(), MUSICIAN_5_REQUEST_2.getDefault())) {
            return MUSICIAN_5_REQUEST_2.getDefault();
        }
        else {
            return MUSICIAN_5_REQUEST_2.get();
        }
    }
    public static String getMusician5Offer1() {
        if (Objects.equals(MUSICIAN_5_OFFER_1.get(), MUSICIAN_5_OFFER_1.getDefault())) {
            return MUSICIAN_5_OFFER_1.getDefault();
        }
        else {
            return MUSICIAN_5_OFFER_1.get();
        }
    }
    public static String getMusician5Request1() {
        if (Objects.equals(MUSICIAN_5_REQUEST_1.get(), MUSICIAN_5_REQUEST_1.getDefault())) {
            return MUSICIAN_5_REQUEST_1.getDefault();
        }
        else {
            return MUSICIAN_5_REQUEST_1.get();
        }
    }
    public static String getMusician4Offer2() {
        if (Objects.equals(MUSICIAN_4_OFFER_2.get(), MUSICIAN_4_OFFER_2.getDefault())) {
            return MUSICIAN_4_OFFER_2.getDefault();
        }
        else {
            return MUSICIAN_4_OFFER_2.get();
        }
    }
    public static String getMusician4Request2() {
        if (Objects.equals(MUSICIAN_4_REQUEST_2.get(), MUSICIAN_4_REQUEST_2.getDefault())) {
            return MUSICIAN_4_REQUEST_2.getDefault();
        }
        else {
            return MUSICIAN_4_REQUEST_2.get();
        }
    }
    public static String getMusician4Offer1() {
        if (Objects.equals(MUSICIAN_4_OFFER_1.get(), MUSICIAN_4_OFFER_1.getDefault())) {
            return MUSICIAN_4_OFFER_1.getDefault();
        }
        else {
            return MUSICIAN_4_OFFER_1.get();
        }
    }
    public static String getMusician4Request1() {
        if (Objects.equals(MUSICIAN_4_REQUEST_1.get(), MUSICIAN_4_REQUEST_1.getDefault())) {
            return MUSICIAN_4_REQUEST_1.getDefault();
        }
        else {
            return MUSICIAN_4_REQUEST_1.get();
        }
    }
    public static String getMusician3Offer2() {
        if (Objects.equals(MUSICIAN_3_OFFER_2.get(), MUSICIAN_3_OFFER_2.getDefault())) {
            return MUSICIAN_3_OFFER_2.getDefault();
        }
        else {
            return MUSICIAN_3_OFFER_2.get();
        }
    }
    public static String getMusician3Request2() {
        if (Objects.equals(MUSICIAN_3_REQUEST_2.get(), MUSICIAN_3_REQUEST_2.getDefault())) {
            return MUSICIAN_3_REQUEST_2.getDefault();
        }
        else {
            return MUSICIAN_3_REQUEST_2.get();
        }
    }
    public static String getMusician3Offer1() {
        if (Objects.equals(MUSICIAN_3_OFFER_1.get(), MUSICIAN_3_OFFER_1.getDefault())) {
            return MUSICIAN_3_OFFER_1.getDefault();
        }
        else {
            return MUSICIAN_3_OFFER_1.get();
        }
    }
    public static String getMusician3Request1() {
        if (Objects.equals(MUSICIAN_3_REQUEST_1.get(), MUSICIAN_3_REQUEST_1.getDefault())) {
            return MUSICIAN_3_REQUEST_1.getDefault();
        }
        else {
            return MUSICIAN_3_REQUEST_1.get();
        }
    }
    public static String getMusician2Offer2() {
        if (Objects.equals(MUSICIAN_2_OFFER_2.get(), MUSICIAN_2_OFFER_2.getDefault())) {
            return MUSICIAN_2_OFFER_2.getDefault();
        }
        else {
            return MUSICIAN_2_OFFER_2.get();
        }
    }
    public static String getMusician2Request2() {
        if (Objects.equals(MUSICIAN_2_REQUEST_2.get(), MUSICIAN_2_REQUEST_2.getDefault())) {
            return MUSICIAN_2_REQUEST_2.getDefault();
        }
        else {
            return MUSICIAN_2_REQUEST_2.get();
        }
    }
    public static String getMusician2Offer1() {
        if (Objects.equals(MUSICIAN_2_OFFER_1.get(), MUSICIAN_2_OFFER_1.getDefault())) {
            return MUSICIAN_2_OFFER_1.getDefault();
        }
        else {
            return MUSICIAN_2_OFFER_1.get();
        }
    }
    public static String getMusician2Request1() {
        if (Objects.equals(MUSICIAN_2_REQUEST_1.get(), MUSICIAN_2_REQUEST_1.getDefault())) {
            return MUSICIAN_2_REQUEST_1.getDefault();
        }
        else {
            return MUSICIAN_2_REQUEST_1.get();
        }
    }
    public static String getMusician1Offer3() {
        if (Objects.equals(MUSICIAN_1_OFFER_3.get(), MUSICIAN_1_OFFER_3.getDefault())) {
            return MUSICIAN_1_OFFER_3.getDefault();
        }
        else {
            return MUSICIAN_1_OFFER_3.get();
        }
    }
    public static String getMusician1Request3() {
        if (Objects.equals(MUSICIAN_1_REQUEST_3.get(), MUSICIAN_1_REQUEST_3.getDefault())) {
            return MUSICIAN_1_REQUEST_3.getDefault();
        }
        else {
            return MUSICIAN_1_REQUEST_3.get();
        }
    }
    public static String getMusician1Offer2() {
        if (Objects.equals(MUSICIAN_1_OFFER_2.get(), MUSICIAN_1_OFFER_2.getDefault())) {
            return MUSICIAN_1_OFFER_2.getDefault();
        }
        else {
            return MUSICIAN_1_OFFER_2.get();
        }
    }
    public static String getMusician1Request2() {
        if (Objects.equals(MUSICIAN_1_REQUEST_2.get(), MUSICIAN_1_REQUEST_2.getDefault())) {
            return MUSICIAN_1_REQUEST_2.getDefault();
        }
        else {
            return MUSICIAN_1_REQUEST_2.get();
        }
    }
    public static String getMusician1Offer1() {
        if (Objects.equals(MUSICIAN_1_OFFER_1.get(), MUSICIAN_1_OFFER_1.getDefault())) {
            return MUSICIAN_1_OFFER_1.getDefault();
        }
        else {
            return MUSICIAN_1_OFFER_1.get();
        }
    }
    public static String getMusician1Request1() {
        if (Objects.equals(MUSICIAN_1_REQUEST_1.get(), MUSICIAN_1_REQUEST_1.getDefault())) {
            return MUSICIAN_1_REQUEST_1.getDefault();
        }
        else {
            return MUSICIAN_1_REQUEST_1.get();
        }
    }
}