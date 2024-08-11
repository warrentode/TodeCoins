package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LibrarianTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Librarian Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> LIBRARIAN_3_REQUEST_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> LIBRARIAN_3_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> LIBRARIAN_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_OFFER_3;

    static {
        // LIBRARIAN TRADES
        BUILDER.push("Librarian Trade Settings");
        // level 1
        BUILDER.push("Librarian Level One Trade One");
        LIBRARIAN_1_REQUEST_1 = BUILDER
                .comment(" Librarian 1 Trade Request 1 Table")
                .define("librarian_1_trade_request_1_table",
                        TradeLootTables.SMALLEST_COIN.toString());
        LIBRARIAN_1_OFFER_1 = BUILDER
                .comment(" Librarian 1 Trade Offer 1 Table")
                .define("librarian_1_trade_offer_1_table",
                        TradeLootTables.GUIDE_BOOKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level One Trade Two");
        LIBRARIAN_1_REQUEST_2 = BUILDER
                .comment(" Librarian 1 Trade Request 2 Table")
                .define("librarian_1_trade_request_2_table",
                        TradeLootTables.PAPER_TABLE.toString());
        LIBRARIAN_1_OFFER_2 = BUILDER
                .comment(" Librarian 1 Trade Offer 2 Table")
                .define("librarian_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level One Trade Three")
                .comment(" Rare Trade");
        LIBRARIAN_1_REQUEST_3 = BUILDER
                .comment(" Librarian 1 Trade Request 2 Table")
                .define("librarian_1_trade_request_3_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level One Trade Four");
        LIBRARIAN_1_REQUEST_4 = BUILDER
                .comment(" Librarian 1 Trade Request 4 Table")
                .define("librarian_1_trade_request_4_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_1_OFFER_4 = BUILDER
                .comment(" Librarian 1 Trade Offer 4 Table")
                .define("librarian_1_trade_offer_4_table",
                        TradeLootTables.BOOKSHELF_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Librarian Level Two Trade One");
        LIBRARIAN_2_REQUEST_1 = BUILDER
                .comment(" Librarian 2 Trade Request 1 Table")
                .define("librarian_2_trade_request_1_table",
                        TradeLootTables.BOOK_TABLE.toString());
        LIBRARIAN_2_OFFER_1 = BUILDER
                .comment(" Librarian 2 Trade Offer 1 Table")
                .define("librarian_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Two Trade Two")
                .comment(" Rare Trade");
        LIBRARIAN_2_REQUEST_2 = BUILDER
                .comment(" Librarian 2 Trade Request 2 Table")
                .define("librarian_2_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Two Trade Three");
        LIBRARIAN_2_REQUEST_3 = BUILDER
                .comment(" Librarian 2 Trade Request 3 Table")
                .define("librarian_2_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_2_OFFER_3 = BUILDER
                .comment(" Librarian 2 Trade Offer 3 Table")
                .define("librarian_2_trade_offer_3_table",
                        TradeLootTables.LANTERN_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Librarian Level Three Trade One")
                .comment(" Rare Trade");
        LIBRARIAN_3_REQUEST_1 = BUILDER
                .comment(" Librarian 3 Trade Request 1 Table")
                .define("librarian_3_trade_request_1_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Three Trade Two");
        LIBRARIAN_3_REQUEST_2 = BUILDER
                .comment(" Librarian 3 Trade Request 2 Table")
                .define("librarian_3_trade_request_2_table",
                        TradeLootTables.TAGGED_INK_TABLE.toString());
        LIBRARIAN_3_REQUEST_2_COUNT = BUILDER
                .define("librarian_3_trade_request_2_count", 3);
        LIBRARIAN_3_OFFER_2 = BUILDER
                .comment(" Librarian 3 Trade Offer 2 Table")
                .define("librarian_3_trade_offer_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Three Trade Three");
        LIBRARIAN_3_REQUEST_3 = BUILDER
                .comment(" Librarian 3 Trade Request 3 Table")
                .define("librarian_3_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_3_OFFER_3 = BUILDER
                .comment(" Librarian 3 Trade Offer 3 Table")
                .define("librarian_3_trade_offer_3_table",
                        TradeLootTables.TAGGED_GLASS_TABLE.toString());
        LIBRARIAN_3_OFFER_3_COUNT = BUILDER
                .define("librarian_3_trade_request_3_count", 1);
        BUILDER.pop();
        // level 4
        BUILDER.push("Librarian Level Four Trade One");
        LIBRARIAN_4_REQUEST_1 = BUILDER
                .comment(" Librarian 4 Trade Request 1 Table")
                .define("librarian_4_trade_request_1_table",
                        TradeLootTables.BOOK_TABLE.toString());
        LIBRARIAN_4_OFFER_1 = BUILDER
                .comment(" Librarian 4 Trade Offer 1 Table")
                .define("librarian_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Four Trade Two")
                .comment(" Rare Trade");
        LIBRARIAN_4_REQUEST_2 = BUILDER
                .comment(" Librarian 4 Trade Request 2 Table")
                .define("librarian_4_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Four Trade Three");
        LIBRARIAN_4_REQUEST_3 = BUILDER
                .comment(" Librarian 4 Trade Request 3 Table")
                .define("librarian_4_trade_request_3_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_4_OFFER_3 = BUILDER
                .comment(" Librarian 4 Trade Offer 3 Table")
                .define("librarian_4_trade_offer_3_table",
                        TradeLootTables.CLOCK_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Librarian Level Five Trade One");
        LIBRARIAN_5_REQUEST_1 = BUILDER
                .comment(" Librarian 5 Trade Request 1 Table")
                .define("librarian_5_trade_request_1_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_5_OFFER_1 = BUILDER
                .comment(" Librarian 5 Trade Offer 1 Table")
                .define("librarian_5_trade_offer_1_table",
                        TradeLootTables.TAGGED_INK_TABLE.toString());
        LIBRARIAN_5_OFFER_1_COUNT = BUILDER
                .define("librarian_5_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Librarian Level Five Trade Two");
        LIBRARIAN_5_REQUEST_2 = BUILDER
                .comment(" Librarian 5 Trade Request 2 Table")
                .define("librarian_5_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_5_OFFER_2 = BUILDER
                .comment(" Librarian 5 Trade Offer 2 Table")
                .define("librarian_5_trade_offer_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Five Trade Three");
        LIBRARIAN_5_REQUEST_3 = BUILDER
                .comment(" Librarian 5 Trade Request 3 Table")
                .define("librarian_5_trade_request_3_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_5_OFFER_3 = BUILDER
                .comment(" Librarian 5 Trade Offer 2 Table")
                .define("librarian_5_trade_offer_2_table",
                        TradeLootTables.NAME_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // LIBRARIAN TRADE GETTERS
    public static String getLibrarian5Offer3() {
        if (Objects.equals(LIBRARIAN_5_OFFER_3.get(), LIBRARIAN_5_OFFER_3.getDefault())) {
            return LIBRARIAN_5_OFFER_3.getDefault();
        }
        else {
            return LIBRARIAN_5_OFFER_3.get();
        }
    }
    public static String getLibrarian5Request3() {
        if (Objects.equals(LIBRARIAN_5_REQUEST_3.get(), LIBRARIAN_5_REQUEST_3.getDefault())) {
            return LIBRARIAN_5_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_5_REQUEST_3.get();
        }
    }
    public static String getLibrarian5Offer2() {
        if (Objects.equals(LIBRARIAN_5_OFFER_2.get(), LIBRARIAN_5_OFFER_2.getDefault())) {
            return LIBRARIAN_5_OFFER_2.getDefault();
        }
        else {
            return LIBRARIAN_5_OFFER_2.get();
        }
    }
    public static String getLibrarian5Request2() {
        if (Objects.equals(LIBRARIAN_5_REQUEST_2.get(), LIBRARIAN_5_REQUEST_2.getDefault())) {
            return LIBRARIAN_5_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_5_REQUEST_2.get();
        }
    }
    public static int getLibrarian5Offer1Count() {
        if (Objects.equals(LIBRARIAN_5_OFFER_1_COUNT.get(), LIBRARIAN_5_OFFER_1_COUNT.getDefault())) {
            return LIBRARIAN_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return LIBRARIAN_5_OFFER_1_COUNT.get();
        }
    }
    public static String getLibrarian5Offer1() {
        if (Objects.equals(LIBRARIAN_5_OFFER_1.get(), LIBRARIAN_5_OFFER_1.getDefault())) {
            return LIBRARIAN_5_OFFER_1.getDefault();
        }
        else {
            return LIBRARIAN_5_OFFER_1.get();
        }
    }
    public static String getLibrarian5Request1() {
        if (Objects.equals(LIBRARIAN_5_REQUEST_1.get(), LIBRARIAN_5_REQUEST_1.getDefault())) {
            return LIBRARIAN_5_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_5_REQUEST_1.get();
        }
    }
    public static String getLibrarian4Request3() {
        if (Objects.equals(LIBRARIAN_4_REQUEST_3.get(), LIBRARIAN_4_REQUEST_3.getDefault())) {
            return LIBRARIAN_4_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_4_REQUEST_3.get();
        }
    }
    public static String getLibrarian4Offer3() {
        if (Objects.equals(LIBRARIAN_4_OFFER_3.get(), LIBRARIAN_4_OFFER_3.getDefault())) {
            return LIBRARIAN_4_OFFER_3.getDefault();
        }
        else {
            return LIBRARIAN_4_OFFER_3.get();
        }
    }
    public static String getLibrarian4Request2() {
        if (Objects.equals(LIBRARIAN_4_REQUEST_2.get(), LIBRARIAN_4_REQUEST_2.getDefault())) {
            return LIBRARIAN_4_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_4_REQUEST_2.get();
        }
    }
    public static String getLibrarian4Offer1() {
        if (Objects.equals(LIBRARIAN_4_OFFER_1.get(), LIBRARIAN_4_OFFER_1.getDefault())) {
            return LIBRARIAN_4_OFFER_1.getDefault();
        }
        else {
            return LIBRARIAN_4_OFFER_1.get();
        }
    }
    public static String getLibrarian4Request1() {
        if (Objects.equals(LIBRARIAN_4_REQUEST_1.get(), LIBRARIAN_4_REQUEST_1.getDefault())) {
            return LIBRARIAN_4_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_4_REQUEST_1.get();
        }
    }
    public static String getLibrarian3Offer3() {
        if (Objects.equals(LIBRARIAN_3_OFFER_3.get(), LIBRARIAN_3_OFFER_3.getDefault())) {
            return LIBRARIAN_3_OFFER_3.getDefault();
        }
        else {
            return LIBRARIAN_3_OFFER_3.get();
        }
    }
    public static int getLibrarian3Offer3Count() {
        if (Objects.equals(LIBRARIAN_3_OFFER_3_COUNT.get(), LIBRARIAN_3_OFFER_3_COUNT.getDefault())) {
            return LIBRARIAN_3_OFFER_3_COUNT.getDefault();
        }
        else {
            return LIBRARIAN_3_OFFER_3_COUNT.get();
        }
    }
    public static String getLibrarian3Request3() {
        if (Objects.equals(LIBRARIAN_3_REQUEST_3.get(), LIBRARIAN_3_REQUEST_3.getDefault())) {
            return LIBRARIAN_3_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_3_REQUEST_3.get();
        }
    }
    public static String getLibrarian3Offer2() {
        if (Objects.equals(LIBRARIAN_3_OFFER_2.get(), LIBRARIAN_3_OFFER_2.getDefault())) {
            return LIBRARIAN_3_OFFER_2.getDefault();
        }
        else {
            return LIBRARIAN_3_OFFER_2.get();
        }
    }
    public static int getLibrarian3Request2Count() {
        if (Objects.equals(LIBRARIAN_3_REQUEST_2_COUNT.get(), LIBRARIAN_3_REQUEST_2_COUNT.getDefault())) {
            return LIBRARIAN_3_REQUEST_2_COUNT.getDefault();
        }
        else {
            return LIBRARIAN_3_REQUEST_2_COUNT.get();
        }
    }
    public static String getLibrarian3Request2() {
        if (Objects.equals(LIBRARIAN_3_REQUEST_2.get(), LIBRARIAN_3_REQUEST_2.getDefault())) {
            return LIBRARIAN_3_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_3_REQUEST_2.get();
        }
    }
    public static String getLibrarian3Request1() {
        if (Objects.equals(LIBRARIAN_3_REQUEST_1.get(), LIBRARIAN_3_REQUEST_1.getDefault())) {
            return LIBRARIAN_3_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_3_REQUEST_1.get();
        }
    }
    public static String getLibrarian2Request3() {
        if (Objects.equals(LIBRARIAN_2_REQUEST_3.get(), LIBRARIAN_2_REQUEST_3.getDefault())) {
            return LIBRARIAN_2_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_2_REQUEST_3.get();
        }
    }
    public static String getLibrarian2Offer3() {
        if (Objects.equals(LIBRARIAN_2_OFFER_3.get(), LIBRARIAN_2_OFFER_3.getDefault())) {
            return LIBRARIAN_2_OFFER_3.getDefault();
        }
        else {
            return LIBRARIAN_2_OFFER_3.get();
        }
    }
    public static String getLibrarian2Request2() {
        if (Objects.equals(LIBRARIAN_2_REQUEST_2.get(), LIBRARIAN_2_REQUEST_2.getDefault())) {
            return LIBRARIAN_2_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_2_REQUEST_2.get();
        }
    }
    public static String getLibrarian2Offer1() {
        if (Objects.equals(LIBRARIAN_2_OFFER_1.get(), LIBRARIAN_2_OFFER_1.getDefault())) {
            return LIBRARIAN_2_OFFER_1.getDefault();
        }
        else {
            return LIBRARIAN_2_OFFER_1.get();
        }
    }
    public static String getLibrarian2Request1() {
        if (Objects.equals(LIBRARIAN_2_REQUEST_1.get(), LIBRARIAN_2_REQUEST_1.getDefault())) {
            return LIBRARIAN_2_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_2_REQUEST_1.get();
        }
    }
    public static String getLibrarian1Offer1() {
        if (Objects.equals(LIBRARIAN_1_OFFER_1.get(), LIBRARIAN_1_OFFER_1.getDefault())) {
            return LIBRARIAN_1_OFFER_1.getDefault();
        }
        else {
            return LIBRARIAN_1_OFFER_1.get();
        }
    }
    public static String getLibrarian1Request1() {
        if (Objects.equals(LIBRARIAN_1_REQUEST_1.get(), LIBRARIAN_1_REQUEST_1.getDefault())) {
            return LIBRARIAN_1_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_1_REQUEST_1.get();
        }
    }
    public static String getLibrarian1Offer2() {
        if (Objects.equals(LIBRARIAN_1_OFFER_2.get(), LIBRARIAN_1_OFFER_2.getDefault())) {
            return LIBRARIAN_1_OFFER_2.getDefault();
        }
        else {
            return LIBRARIAN_1_OFFER_2.get();
        }
    }
    public static String getLibrarian1Request2() {
        if (Objects.equals(LIBRARIAN_1_REQUEST_2.get(), LIBRARIAN_1_REQUEST_2.getDefault())) {
            return LIBRARIAN_1_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_1_REQUEST_2.get();
        }
    }
    public static String getLibrarian1Request3() {
        if (Objects.equals(LIBRARIAN_1_REQUEST_3.get(), LIBRARIAN_1_REQUEST_3.getDefault())) {
            return LIBRARIAN_1_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_1_REQUEST_3.get();
        }
    }
    public static String getLibrarian1Offer4() {
        if (Objects.equals(LIBRARIAN_1_OFFER_4.get(), LIBRARIAN_1_OFFER_4.getDefault())) {
            return LIBRARIAN_1_OFFER_4.getDefault();
        }
        else {
            return LIBRARIAN_1_OFFER_4.get();
        }
    }
    public static String getLibrarian1Request4() {
        if (Objects.equals(LIBRARIAN_1_REQUEST_4.get(), LIBRARIAN_1_REQUEST_4.getDefault())) {
            return LIBRARIAN_1_REQUEST_4.getDefault();
        }
        else {
            return LIBRARIAN_1_REQUEST_4.get();
        }
    }
}