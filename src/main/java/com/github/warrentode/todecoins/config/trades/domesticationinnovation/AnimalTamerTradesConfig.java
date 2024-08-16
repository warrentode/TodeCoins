package com.github.warrentode.todecoins.config.trades.domesticationinnovation;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AnimalTamerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Animal Tamer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANIMAL_TAMER_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANIMAL_TAMER_2_REQUEST_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANIMAL_TAMER_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANIMAL_TAMER_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANIMAL_TAMER_5_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ANIMAL_TAMER_5_OFFER_3;

    static {
        // ANIMAL_TAMER TRADES
        BUILDER.push("Animal Tamer Trade Settings");
        // level 1
        BUILDER.push("Animal Tamer Level One Trade One");
        ANIMAL_TAMER_1_REQUEST_1 = BUILDER
                .comment(" Animal Tamer 1 Trade Request 1 Table")
                .define("animal_tamer_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_1_OFFER_1 = BUILDER
                .comment(" Animal Tamer 1 Trade Offer 1 Table")
                .define("animal_tamer_1_trade_offer_1_table",
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level One Trade Two");
        ANIMAL_TAMER_1_REQUEST_2 = BUILDER
                .comment(" Animal Tamer 1 Trade Request 2 Table")
                .define("animal_tamer_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_1_OFFER_2 = BUILDER
                .comment(" Animal Tamer 1 Trade Offer 2 Table")
                .define("animal_tamer_1_trade_offer_2_table",
                        TradeLootTables.PET_FOOD_TAG_TABLE.toString());
        ANIMAL_TAMER_1_OFFER_2_COUNT = BUILDER
                .define("animal_tamer_1_trade_offer_2_count", 3);
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level One Trade Three")
                .comment(" Rare Trade");
        ANIMAL_TAMER_1_REQUEST_3 = BUILDER
                .comment(" Animal Tamer 1 Trade Request 3 Table")
                .define("animal_tamer_1_trade_request_3_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_1_OFFER_3 = BUILDER
                .comment(" Animal Tamer 1 Trade Offer 3 Table")
                .define("animal_tamer_1_trade_offer_3_table",
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Animal Tamer Level Two Trade One");
        ANIMAL_TAMER_2_REQUEST_1 = BUILDER
                .comment(" Animal Tamer 2 Trade Request 1 Table")
                .define("animal_tamer_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_2_OFFER_1 = BUILDER
                .comment(" Animal Tamer 2 Trade Offer 1 Table")
                .define("animal_tamer_2_trade_offer_1_table",
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level Two Trade Two");
        ANIMAL_TAMER_2_REQUEST_2 = BUILDER
                .comment(" Animal Tamer 2 Trade Offer 2 Table")
                .define("animal_tamer_2_trade_request_2_table",
                        TradeLootTables.PET_FOOD_TAG_TABLE.toString());
        ANIMAL_TAMER_2_REQUEST_2_COUNT = BUILDER
                .define("animal_tamer_2_trade_request_2_count", 3);
        ANIMAL_TAMER_2_OFFER_2 = BUILDER
                .comment(" Animal Tamer 2 Trade Request 2 Table")
                .define("animal_tamer_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level Two Trade Three")
                .comment(" Rare Trade");
        ANIMAL_TAMER_2_REQUEST_3 = BUILDER
                .comment(" Animal Tamer 2 Trade Request 3 Table")
                .define("animal_tamer_2_trade_request_3_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_2_OFFER_3 = BUILDER
                .comment(" Animal Tamer 2 Trade Offer 3 Table")
                .define("animal_tamer_2_trade_offer_3_table",
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Animal Tamer Level Three Trade One");
        ANIMAL_TAMER_3_REQUEST_1 = BUILDER
                .comment(" Animal Tamer 3 Trade Request 1 Table")
                .define("animal_tamer_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_3_OFFER_1 = BUILDER
                .comment(" Animal Tamer 3 Trade Offer 1 Table")
                .define("animal_tamer_3_trade_offer_1_table",
                        TradeLootTables.PET_FOOD_TAG_TABLE.toString());
        ANIMAL_TAMER_3_OFFER_1_COUNT = BUILDER
                .define("animal_tamer_3_trade_offer_1_count", 3);
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level Three Trade Two");
        ANIMAL_TAMER_3_REQUEST_2 = BUILDER
                .comment(" Animal Tamer 3 Trade Request 2 Table")
                .define("animal_tamer_3_trade_request_2_count",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_3_OFFER_2 = BUILDER
                .comment(" Animal Tamer 3 Trade Offer 2 Table")
                .define("animal_tamer_3_trade_offer_2_table",
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level Three Trade Three")
                .comment(" Rare Trade");
        ANIMAL_TAMER_3_REQUEST_3 = BUILDER
                .comment(" Animal Tamer 3 Trade Request 3 Table")
                .define("animal_tamer_3_trade_request_3_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_3_OFFER_3 = BUILDER
                .comment(" Animal Tamer 3 Trade Offer 3 Table")
                .define("animal_tamer_3_trade_offer_3_table",
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Animal Tamer Level Four Trade One");
        ANIMAL_TAMER_4_REQUEST_1 = BUILDER
                .comment(" Animal Tamer 4 Trade Request 1 Table")
                .define("animal_tamer_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_4_OFFER_1 = BUILDER
                .comment(" Animal Tamer 4 Trade Offer 1 Table")
                .define("animal_tamer_4_trade_offer_1_table",
                        TradeLootTables.PET_FOOD_TAG_TABLE.toString());
        ANIMAL_TAMER_4_OFFER_1_COUNT = BUILDER
                .define("animal_tamer_4_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level Four Trade Two");
        ANIMAL_TAMER_4_REQUEST_2 = BUILDER
                .comment(" Animal Tamer 4 Trade Request 2 Table")
                .define("animal_tamer_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_4_OFFER_2 = BUILDER
                .comment(" Animal Tamer 4 Trade Offer 2 Table")
                .define("animal_tamer_4_trade_offer_2_table",
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level Four Trade Three")
                .comment(" Rare Trade");
        ANIMAL_TAMER_4_REQUEST_3 = BUILDER
                .comment(" Animal Tamer 4 Trade Request 3 Table")
                .define("animal_tamer_4_trade_request_3_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_4_OFFER_3 = BUILDER
                .comment(" Animal Tamer 4 Trade Offer 3 Table")
                .define("animal_tamer_4_trade_offer_3_table",
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Animal Tamer Level Five Trade One");
        ANIMAL_TAMER_5_REQUEST_1 = BUILDER
                .comment(" Animal Tamer 5 Trade Request 1 Table")
                .define("animal_tamer_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_5_OFFER_1 = BUILDER
                .comment(" Animal Tamer 5 Trade Offer 1 Table")
                .define("animal_tamer_5_trade_offer_1_table",
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level Five Trade Two")
                .comment(" Rare Trade");
        ANIMAL_TAMER_5_REQUEST_2 = BUILDER
                .comment(" Animal Tamer 5 Trade Request 2 Table")
                .define("animal_tamer_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_5_OFFER_2 = BUILDER
                .comment(" Animal Tamer 5 Trade Offer 2 Table")
                .define("animal_tamer_5_trade_offer_2_table",
                        TradeLootTables.PET_FOOD_TAG_TABLE.toString());
        ANIMAL_TAMER_5_OFFER_2_COUNT = BUILDER
                .define("animal_tamer_5_trade_offer_2_count", 3);
        BUILDER.pop();
        BUILDER.push("Animal Tamer Level Five Trade Three")
                .comment(" Rare Trade");
        ANIMAL_TAMER_5_REQUEST_3 = BUILDER
                .comment(" Animal Tamer 5 Trade Request 3 Table")
                .define("animal_tamer_5_trade_request_3_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ANIMAL_TAMER_5_OFFER_3 = BUILDER
                .comment(" Animal Tamer 5 Trade Offer 3 Table")
                .define("animal_tamer_5_trade_offer_3_table",
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // ANIMAL_TAMER TRADE GETTERS
    public static String getAnimalTamer5Offer3() {
        if (Objects.equals(ANIMAL_TAMER_5_OFFER_3.get(), ANIMAL_TAMER_5_OFFER_3.getDefault())) {
            return ANIMAL_TAMER_5_OFFER_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_5_OFFER_3.get();
        }
    }
    public static String getAnimalTamer5Request3() {
        if (Objects.equals(ANIMAL_TAMER_5_OFFER_3.get(), ANIMAL_TAMER_5_OFFER_3.getDefault())) {
            return ANIMAL_TAMER_5_OFFER_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_5_OFFER_3.get();
        }
    }
    public static int getAnimalTamer5Offer2Count() {
        if (Objects.equals(ANIMAL_TAMER_5_OFFER_2_COUNT.get(), ANIMAL_TAMER_5_OFFER_2_COUNT.getDefault())) {
            return ANIMAL_TAMER_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return ANIMAL_TAMER_5_OFFER_2_COUNT.get();
        }
    }
    public static String getAnimalTamer5Offer2() {
        if (Objects.equals(ANIMAL_TAMER_5_OFFER_2.get(), ANIMAL_TAMER_5_OFFER_2.getDefault())) {
            return ANIMAL_TAMER_5_OFFER_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_5_OFFER_2.get();
        }
    }
    public static String getAnimalTamer5Request2() {
        if (Objects.equals(ANIMAL_TAMER_5_REQUEST_2.get(), ANIMAL_TAMER_5_REQUEST_2.getDefault())) {
            return ANIMAL_TAMER_5_REQUEST_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_5_REQUEST_2.get();
        }
    }
    public static String getAnimalTamer5Offer1() {
        if (Objects.equals(ANIMAL_TAMER_5_OFFER_1.get(), ANIMAL_TAMER_5_OFFER_1.getDefault())) {
            return ANIMAL_TAMER_5_OFFER_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_5_OFFER_1.get();
        }
    }
    public static String getAnimalTamer5Request1() {
        if (Objects.equals(ANIMAL_TAMER_5_REQUEST_1.get(), ANIMAL_TAMER_5_REQUEST_1.getDefault())) {
            return ANIMAL_TAMER_5_REQUEST_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_5_REQUEST_1.get();
        }
    }
    public static String getAnimalTamer4Offer3() {
        if (Objects.equals(ANIMAL_TAMER_4_OFFER_3.get(), ANIMAL_TAMER_4_OFFER_3.getDefault())) {
            return ANIMAL_TAMER_4_OFFER_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_4_OFFER_3.get();
        }
    }
    public static String getAnimalTamer4Request3() {
        if (Objects.equals(ANIMAL_TAMER_4_REQUEST_3.get(), ANIMAL_TAMER_4_REQUEST_3.getDefault())) {
            return ANIMAL_TAMER_4_REQUEST_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_4_REQUEST_3.get();
        }
    }
    public static String getAnimalTamer4Offer2() {
        if (Objects.equals(ANIMAL_TAMER_4_OFFER_2.get(), ANIMAL_TAMER_4_OFFER_2.getDefault())) {
            return ANIMAL_TAMER_4_OFFER_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_4_OFFER_2.get();
        }
    }
    public static String getAnimalTamer4Request2() {
        if (Objects.equals(ANIMAL_TAMER_4_REQUEST_2.get(), ANIMAL_TAMER_4_REQUEST_2.getDefault())) {
            return ANIMAL_TAMER_4_REQUEST_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_4_REQUEST_2.get();
        }
    }
    public static int getAnimalTamer4Offer1Count() {
        if (Objects.equals(ANIMAL_TAMER_4_OFFER_1_COUNT.get(), ANIMAL_TAMER_4_OFFER_1_COUNT.getDefault())) {
            return ANIMAL_TAMER_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return ANIMAL_TAMER_4_OFFER_1_COUNT.get();
        }
    }
    public static String getAnimalTamer4Offer1() {
        if (Objects.equals(ANIMAL_TAMER_4_OFFER_1.get(), ANIMAL_TAMER_4_OFFER_1.getDefault())) {
            return ANIMAL_TAMER_4_OFFER_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_4_OFFER_1.get();
        }
    }
    public static String getAnimalTamer4Request1() {
        if (Objects.equals(ANIMAL_TAMER_4_REQUEST_1.get(), ANIMAL_TAMER_4_REQUEST_1.getDefault())) {
            return ANIMAL_TAMER_4_REQUEST_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_4_REQUEST_1.get();
        }
    }
    public static String getAnimalTamer3Offer3() {
        if (Objects.equals(ANIMAL_TAMER_3_OFFER_3.get(), ANIMAL_TAMER_3_OFFER_3.getDefault())) {
            return ANIMAL_TAMER_3_OFFER_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_3_OFFER_3.get();
        }
    }
    public static String getAnimalTamer3Request3() {
        if (Objects.equals(ANIMAL_TAMER_3_REQUEST_3.get(), ANIMAL_TAMER_3_REQUEST_3.getDefault())) {
            return ANIMAL_TAMER_3_REQUEST_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_3_REQUEST_3.get();
        }
    }
    public static String getAnimalTamer3Offer2() {
        if (Objects.equals(ANIMAL_TAMER_3_OFFER_2.get(), ANIMAL_TAMER_3_OFFER_2.getDefault())) {
            return ANIMAL_TAMER_3_OFFER_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_3_OFFER_2.get();
        }
    }
    public static String getAnimalTamer3Request2() {
        if (Objects.equals(ANIMAL_TAMER_3_REQUEST_2.get(), ANIMAL_TAMER_3_REQUEST_2.getDefault())) {
            return ANIMAL_TAMER_3_REQUEST_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_3_REQUEST_2.get();
        }
    }
    public static int getAnimalTamer3Offer1Count() {
        if (Objects.equals(ANIMAL_TAMER_3_OFFER_1_COUNT.get(), ANIMAL_TAMER_3_OFFER_1_COUNT.getDefault())) {
            return ANIMAL_TAMER_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return ANIMAL_TAMER_3_OFFER_1_COUNT.get();
        }
    }
    public static String getAnimalTamer3Offer1() {
        if (Objects.equals(ANIMAL_TAMER_3_OFFER_1.get(), ANIMAL_TAMER_3_OFFER_1.getDefault())) {
            return ANIMAL_TAMER_3_OFFER_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_3_OFFER_1.get();
        }
    }
    public static String getAnimalTamer3Request1() {
        if (Objects.equals(ANIMAL_TAMER_3_REQUEST_1.get(), ANIMAL_TAMER_3_REQUEST_1.getDefault())) {
            return ANIMAL_TAMER_3_REQUEST_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_3_REQUEST_1.get();
        }
    }
    public static String getAnimalTamer2Offer3() {
        if (Objects.equals(ANIMAL_TAMER_2_OFFER_3.get(), ANIMAL_TAMER_2_OFFER_3.getDefault())) {
            return ANIMAL_TAMER_2_OFFER_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_2_OFFER_3.get();
        }
    }
    public static String getAnimalTamer2Request3() {
        if (Objects.equals(ANIMAL_TAMER_2_REQUEST_3.get(), ANIMAL_TAMER_2_REQUEST_3.getDefault())) {
            return ANIMAL_TAMER_2_REQUEST_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_2_REQUEST_3.get();
        }
    }
    public static int getAnimalTamer2Request2Count() {
        if (Objects.equals(ANIMAL_TAMER_2_REQUEST_2_COUNT.get(), ANIMAL_TAMER_2_REQUEST_2_COUNT.getDefault())) {
            return ANIMAL_TAMER_2_REQUEST_2_COUNT.getDefault();
        }
        else {
            return ANIMAL_TAMER_2_REQUEST_2_COUNT.get();
        }
    }
    public static String getAnimalTamer2Offer2() {
        if (Objects.equals(ANIMAL_TAMER_2_OFFER_2.get(), ANIMAL_TAMER_2_OFFER_2.getDefault())) {
            return ANIMAL_TAMER_2_OFFER_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_2_OFFER_2.get();
        }
    }
    public static String getAnimalTamer2Request2() {
        if (Objects.equals(ANIMAL_TAMER_2_REQUEST_2.get(), ANIMAL_TAMER_2_REQUEST_2.getDefault())) {
            return ANIMAL_TAMER_2_REQUEST_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_2_REQUEST_2.get();
        }
    }
    public static String getAnimalTamer2Offer1() {
        if (Objects.equals(ANIMAL_TAMER_2_OFFER_1.get(), ANIMAL_TAMER_2_OFFER_1.getDefault())) {
            return ANIMAL_TAMER_2_OFFER_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_2_OFFER_1.get();
        }
    }
    public static String getAnimalTamer2Request1() {
        if (Objects.equals(ANIMAL_TAMER_2_REQUEST_1.get(), ANIMAL_TAMER_2_REQUEST_1.getDefault())) {
            return ANIMAL_TAMER_2_REQUEST_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_2_REQUEST_1.get();
        }
    }
    public static String getAnimalTamer1Offer3() {
        if (Objects.equals(ANIMAL_TAMER_1_OFFER_3.get(), ANIMAL_TAMER_1_OFFER_3.getDefault())) {
            return ANIMAL_TAMER_1_OFFER_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_1_OFFER_3.get();
        }
    }
    public static String getAnimalTamer1Request3() {
        if (Objects.equals(ANIMAL_TAMER_1_REQUEST_3.get(), ANIMAL_TAMER_1_REQUEST_3.getDefault())) {
            return ANIMAL_TAMER_1_REQUEST_3.getDefault();
        }
        else {
            return ANIMAL_TAMER_1_REQUEST_3.get();
        }
    }
    public static String getAnimalTamer1Offer2() {
        if (Objects.equals(ANIMAL_TAMER_1_OFFER_2.get(), ANIMAL_TAMER_1_OFFER_2.getDefault())) {
            return ANIMAL_TAMER_1_OFFER_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_1_OFFER_2.get();
        }
    }
    public static int getAnimalTamer1Offer2Count() {
        if (Objects.equals(ANIMAL_TAMER_1_OFFER_2_COUNT.get(), ANIMAL_TAMER_1_OFFER_2_COUNT.getDefault())) {
            return ANIMAL_TAMER_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return ANIMAL_TAMER_1_OFFER_2_COUNT.get();
        }
    }
    public static String getAnimalTamer1Request2() {
        if (Objects.equals(ANIMAL_TAMER_1_REQUEST_2.get(), ANIMAL_TAMER_1_REQUEST_2.getDefault())) {
            return ANIMAL_TAMER_1_REQUEST_2.getDefault();
        }
        else {
            return ANIMAL_TAMER_1_REQUEST_2.get();
        }
    }
    public static String getAnimalTamer1Offer1() {
        if (Objects.equals(ANIMAL_TAMER_1_OFFER_1.get(), ANIMAL_TAMER_1_OFFER_1.getDefault())) {
            return ANIMAL_TAMER_1_OFFER_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_1_OFFER_1.get();
        }
    }
    public static String getAnimalTamer1Request1() {
        if (Objects.equals(ANIMAL_TAMER_1_REQUEST_1.get(), ANIMAL_TAMER_1_REQUEST_1.getDefault())) {
            return ANIMAL_TAMER_1_REQUEST_1.getDefault();
        }
        else {
            return ANIMAL_TAMER_1_REQUEST_1.get();
        }
    }
}