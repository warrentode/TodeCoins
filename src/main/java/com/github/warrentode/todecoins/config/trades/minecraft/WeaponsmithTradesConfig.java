package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WeaponsmithTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Weaponsmith Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> WEAPONSMITH_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_5_OFFER_2;

    static {
        // WEAPONSMITH TRADES
        BUILDER.push("Weaponsmith Trade Settings");
        // level 1
        BUILDER.push("Weaponsmith Level One Trade One");
        WEAPONSMITH_1_REQUEST_1 = BUILDER
                .comment(" Weaponsmith 1 Trade Request 1 Table")
                .define("weaponsmith_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        WEAPONSMITH_1_OFFER_1 = BUILDER
                .comment(" Weaponsmith 1 Trade Offer 1 Table")
                .define("weaponsmith_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level One Trade Two");
        WEAPONSMITH_1_REQUEST_2 = BUILDER
                .comment(" Weaponsmith 1 Trade Request 2 Table")
                .define("weaponsmith_1_trade_request_2_table",
                        TradeLootTables.IRON_TIER_WEAPONS_TABLE.toString());
        WEAPONSMITH_1_OFFER_2 = BUILDER
                .comment(" Weaponsmith 1 Trade Offer 2 Table")
                .define("weaponsmith_1_trade_offer_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Weaponsmith Level Two Trade One");
        WEAPONSMITH_2_REQUEST_1 = BUILDER
                .comment(" Weaponsmith 2 Trade Request 1 Table")
                .define("weaponsmith_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        WEAPONSMITH_2_OFFER_1 = BUILDER
                .comment(" Weaponsmith 2 Trade Offer 1 Table")
                .define("weaponsmith_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Two Trade Two")
                .comment(" Rare Trade");
        WEAPONSMITH_2_REQUEST_2 = BUILDER
                .comment(" Weaponsmith 2 Trade Request 2 Table")
                .define("weaponsmith_2_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        WEAPONSMITH_2_OFFER_2 = BUILDER
                .comment(" Weaponsmith 2 Trade Offer 2 Table")
                .define("weaponsmith_2_trade_offer_2_table",
                        TradeLootTables.BELL_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Weaponsmith Level Three Trade One");
        WEAPONSMITH_3_REQUEST_1 = BUILDER
                .comment(" Weaponsmith 3 Trade Request 1 Table")
                .define("weaponsmith_3_trade_request_1_table",
                        TradeLootTables.FLINT_BUY_TABLE.toString());
        WEAPONSMITH_3_OFFER_1 = BUILDER
                .comment(" Weaponsmith 3 Trade Offer 1 Table")
                .define("weaponsmith_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Three Trade Two");
        WEAPONSMITH_3_REQUEST_2 = BUILDER
                .comment(" Weaponsmith 3 Trade Request 2 Table")
                .define("weaponsmith_3_trade_request_2_table",
                        TradeLootTables.EQUIPMENT_GEMS_TABLE.toString());
        WEAPONSMITH_3_OFFER_2 = BUILDER
                .comment(" Weaponsmith 3 Trade Offer 2 Table")
                .define("weaponsmith_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Weaponsmith Level Four Trade One")
                .comment(" Rare Trade");
        WEAPONSMITH_4_REQUEST_1 = BUILDER
                .comment(" Weaponsmith 4 Trade Request 1 Table")
                .define("weaponsmith_4_trade_request_1_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        WEAPONSMITH_4_OFFER_1 = BUILDER
                .comment(" Weaponsmith 4 Trade Offer 1 Table")
                .define("weaponsmith_4_trade_offer_1_table",
                        TradeLootTables.GOLD_TIER_WEAPONS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Four Trade Two");
        WEAPONSMITH_4_REQUEST_2 = BUILDER
                .comment(" Weaponsmith 4 Trade Request 2 Table")
                .comment(" for either supplementaries mod or turtleblockacademy mod")
                .define("weaponsmith_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WEAPONSMITH_4_OFFER_2 = BUILDER
                .comment(" Weaponsmith 4 Trade Offer 2 Table")
                .define("weaponsmith_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        WEAPONSMITH_4_OFFER_2_COUNT = BUILDER
                .define("weaponsmith_4_trade_offer_2_count", 18);
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Four Trade Three");
        WEAPONSMITH_4_REQUEST_3 = BUILDER
                .comment(" Weaponsmith 4 Trade Request 3 Table")
                .define("weaponsmith_4_trade_request_3_table",
                        TradeLootTables.ANVIL_TABLE.toString());
        WEAPONSMITH_4_OFFER_3 = BUILDER
                .comment(" Weaponsmith 4 Trade Offer 3 Table")
                .define("weaponsmith_4_trade_offer_3_table",
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Weaponsmith Level Five Trade One")
                .comment(" Rare Trade");
        WEAPONSMITH_5_REQUEST_1 = BUILDER
                .comment(" Weaponsmith 5 Trade Request 1 Table")
                .define("weaponsmith_5_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        WEAPONSMITH_5_OFFER_1 = BUILDER
                .comment(" Weaponsmith 5 Trade Offer 1 Table")
                .define("weaponsmith_5_trade_offer_1_table",
                        TradeLootTables.DIAMOND_TIER_WEAPONS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Five Trade Two")
                .comment(" Rare Trade");
        WEAPONSMITH_5_REQUEST_2 = BUILDER
                .comment(" Weaponsmith 5 Trade Request 2 Table")
                .define("weaponsmith_5_trade_request_2_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY.toString());
        WEAPONSMITH_5_OFFER_2 = BUILDER
                .comment(" Weaponsmith 5 Trade Offer 2 Table")
                .define("weaponsmith_5_trade_offer_2_table",
                        TradeLootTables.NETHERITE_TIER_WEAPONS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // WEAPONSMITH TRADE GETTERS
    public static String getWeaponsmith5Offer2() {
        if (Objects.equals(WEAPONSMITH_5_OFFER_2.get(), WEAPONSMITH_5_OFFER_2.getDefault())) {
            return WEAPONSMITH_5_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_5_OFFER_2.get();
        }
    }
    public static String getWeaponsmith5Request2() {
        if (Objects.equals(WEAPONSMITH_5_REQUEST_2.get(), WEAPONSMITH_5_REQUEST_2.getDefault())) {
            return WEAPONSMITH_5_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_5_REQUEST_2.get();
        }
    }
    public static String getWeaponsmith5Offer1() {
        if (Objects.equals(WEAPONSMITH_5_OFFER_1.get(), WEAPONSMITH_5_OFFER_1.getDefault())) {
            return WEAPONSMITH_5_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_5_OFFER_1.get();
        }
    }
    public static String getWeaponsmith5Request1() {
        if (Objects.equals(WEAPONSMITH_5_REQUEST_1.get(), WEAPONSMITH_5_REQUEST_1.getDefault())) {
            return WEAPONSMITH_5_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_5_REQUEST_1.get();
        }
    }
    public static String getWeaponsmith4Offer2() {
        if (Objects.equals(WEAPONSMITH_4_OFFER_2.get(), WEAPONSMITH_4_OFFER_2.getDefault())) {
            return WEAPONSMITH_4_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_4_OFFER_2.get();
        }
    }
    public static String getWeaponsmith4Request2() {
        if (Objects.equals(WEAPONSMITH_4_REQUEST_2.get(), WEAPONSMITH_4_REQUEST_2.getDefault())) {
            return WEAPONSMITH_4_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_4_REQUEST_2.get();
        }
    }
    public static int getWeaponsmith4Offer2Count() {
        if (Objects.equals(WEAPONSMITH_4_OFFER_2_COUNT.get(), WEAPONSMITH_4_OFFER_2_COUNT.getDefault())) {
            return WEAPONSMITH_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return WEAPONSMITH_4_OFFER_2_COUNT.get();
        }
    }
    public static String getWeaponsmith4Offer3() {
        if (Objects.equals(WEAPONSMITH_4_OFFER_3.get(), WEAPONSMITH_4_OFFER_3.getDefault())) {
            return WEAPONSMITH_4_OFFER_3.getDefault();
        }
        else {
            return WEAPONSMITH_4_OFFER_3.get();
        }
    }
    public static String getWeaponsmith4Request3() {
        if (Objects.equals(WEAPONSMITH_4_REQUEST_3.get(), WEAPONSMITH_4_REQUEST_3.getDefault())) {
            return WEAPONSMITH_4_REQUEST_3.getDefault();
        }
        else {
            return WEAPONSMITH_4_REQUEST_3.get();
        }
    }
    public static String getWeaponsmith4Offer1() {
        if (Objects.equals(WEAPONSMITH_4_OFFER_1.get(), WEAPONSMITH_4_OFFER_1.getDefault())) {
            return WEAPONSMITH_4_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_4_OFFER_1.get();
        }
    }
    public static String getWeaponsmith4Request1() {
        if (Objects.equals(WEAPONSMITH_4_REQUEST_1.get(), WEAPONSMITH_4_REQUEST_1.getDefault())) {
            return WEAPONSMITH_4_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_4_REQUEST_1.get();
        }
    }
    public static String getWeaponsmith3Offer2() {
        if (Objects.equals(WEAPONSMITH_3_OFFER_2.get(), WEAPONSMITH_3_OFFER_2.getDefault())) {
            return WEAPONSMITH_3_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_3_OFFER_2.get();
        }
    }
    public static String getWeaponsmith3Request2() {
        if (Objects.equals(WEAPONSMITH_3_REQUEST_2.get(), WEAPONSMITH_3_REQUEST_2.getDefault())) {
            return WEAPONSMITH_3_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_3_REQUEST_2.get();
        }
    }
    public static String getWeaponsmith3Offer1() {
        if (Objects.equals(WEAPONSMITH_3_OFFER_1.get(), WEAPONSMITH_3_OFFER_1.getDefault())) {
            return WEAPONSMITH_3_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_3_OFFER_1.get();
        }
    }
    public static String getWeaponsmith3Request1() {
        if (Objects.equals(WEAPONSMITH_3_REQUEST_1.get(), WEAPONSMITH_3_REQUEST_1.getDefault())) {
            return WEAPONSMITH_3_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_3_REQUEST_1.get();
        }
    }
    public static String getWeaponsmith2Offer2() {
        if (Objects.equals(WEAPONSMITH_2_OFFER_2.get(), WEAPONSMITH_2_OFFER_2.getDefault())) {
            return WEAPONSMITH_2_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_2_OFFER_2.get();
        }
    }
    public static String getWeaponsmith2Request2() {
        if (Objects.equals(WEAPONSMITH_2_REQUEST_2.get(), WEAPONSMITH_2_REQUEST_2.getDefault())) {
            return WEAPONSMITH_2_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_2_REQUEST_2.get();
        }
    }
    public static String getWeaponsmith2Offer1() {
        if (Objects.equals(WEAPONSMITH_2_OFFER_1.get(), WEAPONSMITH_2_OFFER_1.getDefault())) {
            return WEAPONSMITH_2_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_2_OFFER_1.get();
        }
    }
    public static String getWeaponsmith2Request1() {
        if (Objects.equals(WEAPONSMITH_2_REQUEST_1.get(), WEAPONSMITH_2_REQUEST_1.getDefault())) {
            return WEAPONSMITH_2_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_2_REQUEST_1.get();
        }
    }
    public static String getWeaponsmith1Offer2() {
        if (Objects.equals(WEAPONSMITH_1_OFFER_2.get(), WEAPONSMITH_1_OFFER_2.getDefault())) {
            return WEAPONSMITH_1_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_1_OFFER_2.get();
        }
    }
    public static String getWeaponsmith1Request2() {
        if (Objects.equals(WEAPONSMITH_1_REQUEST_2.get(), WEAPONSMITH_1_REQUEST_2.getDefault())) {
            return WEAPONSMITH_1_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_1_REQUEST_2.get();
        }
    }
    public static String getWeaponsmith1Offer1() {
        if (Objects.equals(WEAPONSMITH_1_OFFER_1.get(), WEAPONSMITH_1_OFFER_1.getDefault())) {
            return WEAPONSMITH_1_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_1_OFFER_1.get();
        }
    }
    public static String getWeaponsmith1Request1() {
        if (Objects.equals(WEAPONSMITH_1_REQUEST_1.get(), WEAPONSMITH_1_REQUEST_1.getDefault())) {
            return WEAPONSMITH_1_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_1_REQUEST_1.get();
        }
    }
}