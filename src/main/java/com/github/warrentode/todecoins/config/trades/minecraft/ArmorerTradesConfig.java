package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmorerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Armorer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> ARMORER_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_5_OFFER_2;

    static {
        // ARMORER TRADES
        BUILDER.push("Armorer Trade Settings");
        // level 1
        BUILDER.push("Armorer Level One Trade One");
        ARMORER_1_REQUEST_1 = BUILDER
                .comment(" Armorer 1 Trade Request 1 Table")
                .define("armorer_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        ARMORER_1_OFFER_1 = BUILDER
                .comment(" Armorer 1 Trade Offer 1 Table")
                .define("armorer_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level One Trade Two");
        ARMORER_1_REQUEST_2 = BUILDER
                .comment(" Armorer 1 Trade Request 2 Table")
                .define("armorer_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_1_OFFER_2 = BUILDER
                .comment(" Armorer 1 Trade Offer 2 Table")
                .define("armorer_1_trade_offer_2_table",
                        TradeLootTables.CHAINMAIL_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level One Trade Three");
        ARMORER_1_REQUEST_3 = BUILDER
                .comment(" Armorer 1 Trade Request 3 Table")
                .define("armorer_1_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_1_OFFER_3 = BUILDER
                .comment(" Armorer 1 Trade Offer 3 Table")
                .define("armorer_1_trade_offer_3_table",
                        TradeLootTables.CHAINMAIL_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level One Trade Four");
        ARMORER_1_REQUEST_4 = BUILDER
                .comment(" Armorer 1 Trade Request 4 Table")
                .define("armorer_1_trade_request_4_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_1_OFFER_4 = BUILDER
                .comment(" Armorer 1 Trade Offer 4 Table")
                .define("armorer_1_trade_offer_4_table",
                        TradeLootTables.CHAINMAIL_TIER_LEGGINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level One Trade Five");
        ARMORER_1_REQUEST_5 = BUILDER
                .comment(" Armorer 1 Trade Request 5 Table")
                .define("armorer_1_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_1_OFFER_5 = BUILDER
                .comment(" Armorer 1 Trade Offer 4 Table")
                .define("armorer_1_trade_offer_4_table",
                        TradeLootTables.CHAINMAIL_TIER_BOOTS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Armorer Level Two Trade One");
        ARMORER_2_REQUEST_1 = BUILDER
                .comment(" Armorer 2 Trade Request 1 Table")
                .define("armorer_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        ARMORER_2_OFFER_1 = BUILDER
                .comment(" Armorer 2 Trade Offer 1 Table")
                .define("armorer_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Two Trade Two");
        ARMORER_2_REQUEST_2 = BUILDER
                .comment(" Armorer 2 Trade Request 2 Table")
                .define("armorer_2_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_2_OFFER_2 = BUILDER
                .comment(" Armorer 2 Trade Offer 2 Table")
                .define("armorer_2_trade_offer_2_table",
                        TradeLootTables.BELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Two Trade Three");
        ARMORER_2_REQUEST_3 = BUILDER
                .comment(" Armorer 2 Trade Request 3 Table")
                .define("armorer_2_trade_request_3_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_2_OFFER_3 = BUILDER
                .comment(" Armorer 2 Trade Offer 3 Table")
                .define("armorer_2_trade_offer_3_table",
                        TradeLootTables.IRON_TIER_LEGGINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Two Trade Four");
        ARMORER_2_REQUEST_4 = BUILDER
                .comment(" Armorer 2 Trade Request 4 Table")
                .define("armorer_2_trade_request_4_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_2_OFFER_4 = BUILDER
                .comment(" Armorer 2 Trade Offer 4 Table")
                .define("armorer_2_trade_offer_4_table",
                        TradeLootTables.IRON_TIER_BOOTS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Armorer Level Three Trade One");
        ARMORER_3_REQUEST_1 = BUILDER
                .comment(" Armorer 3 Trade Request 1 Table")
                .define("armorer_3_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        ARMORER_3_OFFER_1 = BUILDER
                .comment(" Armorer 3 Trade Offer 1 Table")
                .define("armorer_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Two");
        ARMORER_3_REQUEST_2 = BUILDER
                .comment(" Armorer 3 Trade Request 2 Table")
                .define("armorer_3_trade_request_2_table",
                        TradeLootTables.EQUIPMENT_GEMS_TABLE.toString());
        ARMORER_3_OFFER_2 = BUILDER
                .comment(" Armorer 3 Trade Offer 2 Table")
                .define("armorer_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Three");
        ARMORER_3_REQUEST_3 = BUILDER
                .comment(" Armorer 3 Trade Request 3 Table")
                .define("armorer_3_trade_request_3_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_3_OFFER_3 = BUILDER
                .comment(" Armorer 3 Trade Offer 3 Table")
                .define("armorer_3_trade_offer_3_table",
                        TradeLootTables.IRON_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Four");
        ARMORER_3_REQUEST_4 = BUILDER
                .comment(" Armorer 3 Trade Request 4 Table")
                .define("armorer_3_trade_request_4_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_3_OFFER_4 = BUILDER
                .comment(" Armorer 3 Trade Offer 4 Table")
                .define("armorer_3_trade_offer_4_table",
                        TradeLootTables.IRON_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Five");
        ARMORER_3_REQUEST_5 = BUILDER
                .comment(" Armorer 3 Trade Request 5 Table")
                .define("armorer_3_trade_request_5_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_3_OFFER_5 = BUILDER
                .comment(" Armorer 3 Trade Offer 5 Table")
                .define("armorer_3_trade_offer_5_table",
                        TradeLootTables.SHIELD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Six");
        ARMORER_3_REQUEST_6 = BUILDER
                .comment(" Armorer 3 Trade Request 6 Table")
                .define("armorer_3_trade_request_6_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_3_OFFER_6 = BUILDER
                .comment(" Armorer 3 Trade Offer 6 Table")
                .define("armorer_3_trade_offer_6_table",
                        TradeLootTables.IRON_TIER_HORSE_ARMOR_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Armorer Level Four Trade One")
                .comment(" Rare Trade");
        ARMORER_4_REQUEST_1 = BUILDER
                .comment(" Armorer 4 Trade Request 1 Table")
                .define("armorer_4_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_4_OFFER_1 = BUILDER
                .comment(" Armorer 4 Trade Offer 1 Table")
                .define("armorer_4_trade_offer_1_table",
                        TradeLootTables.DIAMOND_TIER_LEGGINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Four Trade Two")
                .comment(" Rare Trade");
        ARMORER_4_REQUEST_2 = BUILDER
                .comment(" Armorer 4 Trade Request 2 Table")
                .define("armorer_4_trade_request_2_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_4_OFFER_2 = BUILDER
                .comment(" Armorer 4 Trade Offer 2 Table")
                .define("armorer_4_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_BOOTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Four Trade Three")
                .comment(" Available if Supplementaries mod is Loaded");
        ARMORER_4_REQUEST_3 = BUILDER
                .comment(" Armorer 4 Trade Request 3 Table")
                .define("armorer_4_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_4_OFFER_3 = BUILDER
                .comment(" Armorer 4 Trade Offer 3 Table")
                .define("armorer_4_trade_offer_3_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        ARMORER_4_OFFER_3_COUNT = BUILDER
                .define("armorer_4_trade_offer_3_count", 18);
        BUILDER.pop();
        // level 5
        BUILDER.push("Armorer Level Five Trade One")
                .comment(" Rare Trade");
        ARMORER_5_REQUEST_1 = BUILDER
                .comment(" Armorer 5 Trade Request 1 Table")
                .define("armorer_5_trade_request_1_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_5_OFFER_1 = BUILDER
                .comment(" Armorer 5 Trade Offer 1 Table")
                .define("armorer_5_trade_offer_1_table",
                        TradeLootTables.DIAMOND_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Five Trade Two")
                .comment(" Rare Trade");
        ARMORER_5_REQUEST_2 = BUILDER
                .comment(" Armorer 5 Trade Request 2 Table")
                .define("armorer_5_trade_request_2_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_5_OFFER_2 = BUILDER
                .comment(" Armorer 5 Trade Offer 2 Table")
                .define("armorer_5_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // ARMORER TRADE GETTERS
    public static String getArmorer5Offer2() {
        if (Objects.equals(ARMORER_5_OFFER_2.get(), ARMORER_5_OFFER_2.getDefault())) {
            return ARMORER_5_OFFER_2.getDefault();
        }
        else {
            return ARMORER_5_OFFER_2.get();
        }
    }
    public static String getArmorer5Request2() {
        if (Objects.equals(ARMORER_5_REQUEST_2.get(), ARMORER_5_REQUEST_2.getDefault())) {
            return ARMORER_5_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_5_REQUEST_2.get();
        }
    }
    public static String getArmorer5Offer1() {
        if (Objects.equals(ARMORER_5_OFFER_1.get(), ARMORER_5_OFFER_1.getDefault())) {
            return ARMORER_5_OFFER_1.getDefault();
        }
        else {
            return ARMORER_5_OFFER_1.get();
        }
    }
    public static String getArmorer5Request1() {
        if (Objects.equals(ARMORER_5_REQUEST_1.get(), ARMORER_5_REQUEST_1.getDefault())) {
            return ARMORER_5_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_5_REQUEST_1.get();
        }
    }
    public static int getArmorer4Offer3Count() {
        if (Objects.equals(ARMORER_4_OFFER_3_COUNT.get(), ARMORER_4_OFFER_3_COUNT.getDefault())) {
            return ARMORER_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return ARMORER_4_OFFER_3_COUNT.get();
        }
    }
    public static String getArmorer4Offer3() {
        if (Objects.equals(ARMORER_4_OFFER_3.get(), ARMORER_4_OFFER_3.getDefault())) {
            return ARMORER_4_OFFER_3.getDefault();
        }
        else {
            return ARMORER_4_OFFER_3.get();
        }
    }
    public static String getArmorer4Request3() {
        if (Objects.equals(ARMORER_4_REQUEST_3.get(), ARMORER_4_REQUEST_3.getDefault())) {
            return ARMORER_4_REQUEST_3.getDefault();
        }
        else {
            return ARMORER_4_REQUEST_3.get();
        }
    }
    public static String getArmorer4Offer2() {
        if (Objects.equals(ARMORER_4_OFFER_2.get(), ARMORER_4_OFFER_2.getDefault())) {
            return ARMORER_4_OFFER_2.getDefault();
        }
        else {
            return ARMORER_4_OFFER_2.get();
        }
    }
    public static String getArmorer4Request2() {
        if (Objects.equals(ARMORER_4_REQUEST_2.get(), ARMORER_4_REQUEST_2.getDefault())) {
            return ARMORER_4_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_4_REQUEST_2.get();
        }
    }
    public static String getArmorer4Offer1() {
        if (Objects.equals(ARMORER_4_OFFER_1.get(), ARMORER_4_OFFER_1.getDefault())) {
            return ARMORER_4_OFFER_1.getDefault();
        }
        else {
            return ARMORER_4_OFFER_1.get();
        }
    }
    public static String getArmorer4Request1() {
        if (Objects.equals(ARMORER_4_REQUEST_1.get(), ARMORER_4_REQUEST_1.getDefault())) {
            return ARMORER_4_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_4_REQUEST_1.get();
        }
    }
    public static String getArmorer3Offer6() {
        if (Objects.equals(ARMORER_3_OFFER_6.get(), ARMORER_3_OFFER_6.getDefault())) {
            return ARMORER_3_OFFER_6.getDefault();
        }
        else {
            return ARMORER_3_OFFER_6.get();
        }
    }
    public static String getArmorer3Request6() {
        if (Objects.equals(ARMORER_3_REQUEST_6.get(), ARMORER_3_REQUEST_6.getDefault())) {
            return ARMORER_3_REQUEST_6.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_6.get();
        }
    }
    public static String getArmorer3Offer5() {
        if (Objects.equals(ARMORER_3_OFFER_5.get(), ARMORER_3_OFFER_5.getDefault())) {
            return ARMORER_3_OFFER_5.getDefault();
        }
        else {
            return ARMORER_3_OFFER_5.get();
        }
    }
    public static String getArmorer3Request5() {
        if (Objects.equals(ARMORER_3_REQUEST_5.get(), ARMORER_3_REQUEST_5.getDefault())) {
            return ARMORER_3_REQUEST_5.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_5.get();
        }
    }
    public static String getArmorer3Offer4() {
        if (Objects.equals(ARMORER_3_OFFER_4.get(), ARMORER_3_OFFER_4.getDefault())) {
            return ARMORER_3_OFFER_4.getDefault();
        }
        else {
            return ARMORER_3_OFFER_4.get();
        }
    }
    public static String getArmorer3Request4() {
        if (Objects.equals(ARMORER_3_REQUEST_4.get(), ARMORER_3_REQUEST_4.getDefault())) {
            return ARMORER_3_REQUEST_4.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_4.get();
        }
    }
    public static String getArmorer3Offer3() {
        if (Objects.equals(ARMORER_3_OFFER_3.get(), ARMORER_3_OFFER_3.getDefault())) {
            return ARMORER_3_OFFER_3.getDefault();
        }
        else {
            return ARMORER_3_OFFER_3.get();
        }
    }
    public static String getArmorer3Request3() {
        if (Objects.equals(ARMORER_3_REQUEST_3.get(), ARMORER_3_REQUEST_3.getDefault())) {
            return ARMORER_3_REQUEST_3.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_3.get();
        }
    }
    public static String getArmorer3Offer2() {
        if (Objects.equals(ARMORER_3_OFFER_2.get(), ARMORER_3_OFFER_2.getDefault())) {
            return ARMORER_3_OFFER_2.getDefault();
        }
        else {
            return ARMORER_3_OFFER_2.get();
        }
    }
    public static String getArmorer3Request2() {
        if (Objects.equals(ARMORER_3_REQUEST_2.get(), ARMORER_3_REQUEST_2.getDefault())) {
            return ARMORER_3_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_2.get();
        }
    }
    public static String getArmorer3Offer1() {
        if (Objects.equals(ARMORER_3_OFFER_1.get(), ARMORER_3_OFFER_1.getDefault())) {
            return ARMORER_3_OFFER_1.getDefault();
        }
        else {
            return ARMORER_3_OFFER_1.get();
        }
    }
    public static String getArmorer3Request1() {
        if (Objects.equals(ARMORER_3_REQUEST_1.get(), ARMORER_3_REQUEST_1.getDefault())) {
            return ARMORER_3_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_1.get();
        }
    }
    public static String getArmorer2Offer4() {
        if (Objects.equals(ARMORER_2_OFFER_4.get(), ARMORER_2_OFFER_4.getDefault())) {
            return ARMORER_2_OFFER_4.getDefault();
        }
        else {
            return ARMORER_2_OFFER_4.get();
        }
    }
    public static String getArmorer2Request4() {
        if (Objects.equals(ARMORER_2_REQUEST_4.get(), ARMORER_2_REQUEST_4.getDefault())) {
            return ARMORER_2_REQUEST_4.getDefault();
        }
        else {
            return ARMORER_2_REQUEST_4.get();
        }
    }
    public static String getArmorer2Offer3() {
        if (Objects.equals(ARMORER_2_OFFER_3.get(), ARMORER_2_OFFER_3.getDefault())) {
            return ARMORER_2_OFFER_3.getDefault();
        }
        else {
            return ARMORER_2_OFFER_3.get();
        }
    }
    public static String getArmorer2Request3() {
        if (Objects.equals(ARMORER_2_REQUEST_3.get(), ARMORER_2_REQUEST_3.getDefault())) {
            return ARMORER_2_REQUEST_3.getDefault();
        }
        else {
            return ARMORER_2_REQUEST_3.get();
        }
    }
    public static String getArmorer2Offer2() {
        if (Objects.equals(ARMORER_2_OFFER_2.get(), ARMORER_2_OFFER_2.getDefault())) {
            return ARMORER_2_OFFER_2.getDefault();
        }
        else {
            return ARMORER_2_OFFER_2.get();
        }
    }
    public static String getArmorer2Request2() {
        if (Objects.equals(ARMORER_2_REQUEST_2.get(), ARMORER_2_REQUEST_2.getDefault())) {
            return ARMORER_2_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_2_REQUEST_2.get();
        }
    }
    public static String getArmorer2Offer1() {
        if (Objects.equals(ARMORER_2_OFFER_1.get(), ARMORER_2_OFFER_1.getDefault())) {
            return ARMORER_2_OFFER_1.getDefault();
        }
        else {
            return ARMORER_2_OFFER_1.get();
        }
    }
    public static String getArmorer2Request1() {
        if (Objects.equals(ARMORER_2_REQUEST_1.get(), ARMORER_2_REQUEST_1.getDefault())) {
            return ARMORER_2_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_2_REQUEST_1.get();
        }
    }
    public static String getArmorer1Offer5() {
        if (Objects.equals(ARMORER_1_OFFER_5.get(), ARMORER_1_OFFER_5.getDefault())) {
            return ARMORER_1_OFFER_5.getDefault();
        }
        else {
            return ARMORER_1_OFFER_5.get();
        }
    }
    public static String getArmorer1Request5() {
        if (Objects.equals(ARMORER_1_REQUEST_5.get(), ARMORER_1_REQUEST_5.getDefault())) {
            return ARMORER_1_REQUEST_5.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_5.get();
        }
    }
    public static String getArmorer1Offer4() {
        if (Objects.equals(ARMORER_1_OFFER_4.get(), ARMORER_1_OFFER_4.getDefault())) {
            return ARMORER_1_OFFER_4.getDefault();
        }
        else {
            return ARMORER_1_OFFER_4.get();
        }
    }
    public static String getArmorer1Request4() {
        if (Objects.equals(ARMORER_1_REQUEST_4.get(), ARMORER_1_REQUEST_4.getDefault())) {
            return ARMORER_1_REQUEST_4.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_4.get();
        }
    }
    public static String getArmorer1Offer3() {
        if (Objects.equals(ARMORER_1_OFFER_3.get(), ARMORER_1_OFFER_3.getDefault())) {
            return ARMORER_1_OFFER_3.getDefault();
        }
        else {
            return ARMORER_1_OFFER_3.get();
        }
    }
    public static String getArmorer1Request3() {
        if (Objects.equals(ARMORER_1_REQUEST_3.get(), ARMORER_1_REQUEST_3.getDefault())) {
            return ARMORER_1_REQUEST_3.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_3.get();
        }
    }
    public static String getArmorer1Offer2() {
        if (Objects.equals(ARMORER_1_OFFER_2.get(), ARMORER_1_OFFER_2.getDefault())) {
            return ARMORER_1_OFFER_2.getDefault();
        }
        else {
            return ARMORER_1_OFFER_2.get();
        }
    }
    public static String getArmorer1Request2() {
        if (Objects.equals(ARMORER_1_REQUEST_2.get(), ARMORER_1_REQUEST_2.getDefault())) {
            return ARMORER_1_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_2.get();
        }
    }
    public static String getArmorer1Offer1() {
        if (Objects.equals(ARMORER_1_OFFER_1.get(), ARMORER_1_OFFER_1.getDefault())) {
            return ARMORER_1_OFFER_1.getDefault();
        }
        else {
            return ARMORER_1_OFFER_1.get();
        }
    }
    public static String getArmorer1Request1() {
        if (Objects.equals(ARMORER_1_REQUEST_1.get(), ARMORER_1_REQUEST_1.getDefault())) {
            return ARMORER_1_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_1.get();
        }
    }
}