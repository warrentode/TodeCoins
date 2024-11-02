package com.github.warrentode.todecoins.config.trades.todecoins;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PiglinMerchantTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Piglin Merchant Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> PIGLIN_MERCHANT_1_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> PIGLIN_MERCHANT_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<Integer> PIGLIN_MERCHANT_1_OFFER_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_1_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> PIGLIN_MERCHANT_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> PIGLIN_MERCHANT_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<List<String>> PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST;
    public static final ForgeConfigSpec.ConfigValue<Integer> PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST_LEVEL;

    static {
        // TRADES
        BUILDER.push("Piglin Merchant Trade Settings");
        // level 1
        BUILDER.push("Piglin Merchant Level One Trade One");
        PIGLIN_MERCHANT_1_REQUEST_1 = BUILDER
                .comment(" Piglin Merchant 1 Trade Request 1 Table")
                .define("piglin_merchant_1_trade_request_1_table",
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE.toString());
        PIGLIN_MERCHANT_1_OFFER_1 = BUILDER
                .comment(" Piglin Merchant 1 Trade Offer 1 Table")
                .define("piglin_merchant_1_trade_offer_1_table",
                        TradeLootTables.CHEAP_TRADE_GOODS.toString());
        PIGLIN_MERCHANT_1_OFFER_1_COUNT = BUILDER
                .defineInRange("piglin_merchant_1_trade_offer_1_count", 6, 1, 64);
        BUILDER.pop();
        BUILDER.push("Piglin Merchant Level One Trade Two");
        PIGLIN_MERCHANT_1_REQUEST_2 = BUILDER
                .comment(" Piglin Merchant 1 Trade Request 2 Table")
                .define("piglin_merchant_1_trade_request_2_table",
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE.toString());
        PIGLIN_MERCHANT_1_OFFER_2 = BUILDER
                .comment(" Piglin Merchant 1 Trade Offer 2 Table")
                .define("piglin_merchant_1_trade_offer_2_table",
                        TradeLootTables.COMMON_TRADE_GOODS.toString());
        PIGLIN_MERCHANT_1_OFFER_2_COUNT = BUILDER
                .defineInRange("piglin_merchant_1_trade_offer_2_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Piglin Merchant Level One Trade Three");
        PIGLIN_MERCHANT_1_REQUEST_3 = BUILDER
                .comment(" Piglin Merchant 1 Trade Request 3 Table")
                .define("piglin_merchant_1_trade_request_3_table",
                        TradeLootTables.SIX_NETHER_GOLD_COIN_BAG_TABLE.toString());
        PIGLIN_MERCHANT_1_OFFER_3 = BUILDER
                .comment(" Piglin Merchant 1 Trade Offer 3 Table")
                .define("piglin_merchant_1_trade_offer_3_table",
                        TradeLootTables.IRON_TIER_EQUIPMENT_SET.toString());
        BUILDER.pop();
        BUILDER.push("Piglin Merchant Level One Trade Four");
        PIGLIN_MERCHANT_1_REQUEST_4 = BUILDER
                .comment(" Piglin Merchant 1 Trade Request 4 Table")
                .define("piglin_merchant_1_trade_request_4_table",
                        TradeLootTables.FIFTEEN_NETHER_GOLD_COIN_TABLE.toString());
        PIGLIN_MERCHANT_1_OFFER_4 = BUILDER
                .comment(" Piglin Merchant 1 Trade Offer 4 Table")
                .define("piglin_merchant_1_trade_offer_4_table",
                        TradeLootTables.UNCOMMON_TRADE_GOODS.toString());
        PIGLIN_MERCHANT_1_OFFER_4_COUNT = BUILDER
                .defineInRange("piglin_merchant_1_trade_offer_4_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Piglin Merchant Level One Trade Five");
        PIGLIN_MERCHANT_1_REQUEST_5 = BUILDER
                .comment(" Piglin Merchant 1 Trade Request 5 Table")
                .define("piglin_merchant_1_trade_request_5_table",
                        TradeLootTables.NINE_NETHER_GOLD_COIN_BAG_TABLE.toString());
        PIGLIN_MERCHANT_1_OFFER_5 = BUILDER
                .comment(" Piglin Merchant 1 Trade Offer 5 Table")
                .define("piglin_merchant_1_trade_offer_5_table",
                        TradeLootTables.DIAMOND_TIER_EQUIPMENT_SET.toString());
        BUILDER.pop();
        BUILDER.push("Piglin Merchant Level Two Trade One");
        PIGLIN_MERCHANT_2_REQUEST_1 = BUILDER
                .comment(" Piglin Merchant 2 Trade Request 1 Table")
                .define("piglin_merchant_2_trade_request_1_table",
                        TradeLootTables.RARE_BARTER_CURRENCY.toString());
        PIGLIN_MERCHANT_2_OFFER_1 = BUILDER
                .comment(" Piglin Merchant 2 Trade Offer 1 Table")
                .define("piglin_merchant_2_trade_offer_1_table",
                        TradeLootTables.RARE_TRADE_GOODS.toString());
        PIGLIN_MERCHANT_2_OFFER_1_COUNT = BUILDER
                .defineInRange("piglin_merchant_2_trade_offer_1_count", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Piglin Merchant Level Two Trade Two");
        PIGLIN_MERCHANT_2_REQUEST_2 = BUILDER
                .comment(" Piglin Merchant 2 Trade Request 2 Table")
                .define("piglin_merchant_2_trade_request_2_table",
                        TradeLootTables.RARE_BARTER_CURRENCY.toString());
        PIGLIN_MERCHANT_2_OFFER_2 = BUILDER
                .comment(" Piglin Merchant 2 Trade Offer 2 Table")
                .define("piglin_merchant_2_trade_offer_2_table",
                        TradeLootTables.RARE_TRADE_GOODS.toString());
        BUILDER.pop();
        BUILDER.push("Piglin Merchant Level Two Trade Three");
        PIGLIN_MERCHANT_2_REQUEST_3 = BUILDER
                .comment(" Piglin Merchant 2 Trade Request 3 Table")
                .define("piglin_merchant_2_trade_request_3_table",
                        TradeLootTables.RARE_BARTER_CURRENCY.toString());
        PIGLIN_MERCHANT_2_OFFER_3 = BUILDER
                .comment(" Piglin Merchant 2 Trade Offer 3 Table")
                .define("piglin_merchant_2_trade_offer_3_table",
                        TradeLootTables.IRON_TIER_BOOTS_TABLE.toString());
        PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST = BUILDER
                .comment(" Piglin Merchant 2 Trade Offer 3 Enchantment List")
                .define("piglin_merchant_2_offer_3_enchantment_list",
                        List.of("minecraft:soul_speed"));
        PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST_LEVEL = BUILDER
                .comment(" Piglin Merchant 2 Trade Offer 3 Enchantment Level of the Set")
                .defineInRange("piglin_merchant_2_offer_3_enchantment_list_level", 1, 1, 10);
        BUILDER.pop();

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    // TRADE GETTERS
    public static int getPiglinMerchant1Offer1Count() {
        if (Objects.equals(PIGLIN_MERCHANT_1_OFFER_1_COUNT.get(), PIGLIN_MERCHANT_1_OFFER_1_COUNT.getDefault())) {
            return PIGLIN_MERCHANT_1_OFFER_1_COUNT.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_OFFER_1_COUNT.get();
        }
    }
    public static String getPiglinMerchant1Offer1() {
        if (Objects.equals(PIGLIN_MERCHANT_1_OFFER_1.get(), PIGLIN_MERCHANT_1_OFFER_1.getDefault())) {
            return PIGLIN_MERCHANT_1_OFFER_1.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_OFFER_1.get();
        }
    }
    public static String getPiglinMerchant1Request1() {
        if (Objects.equals(PIGLIN_MERCHANT_1_REQUEST_1.get(), PIGLIN_MERCHANT_1_REQUEST_1.getDefault())) {
            return PIGLIN_MERCHANT_1_REQUEST_1.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_REQUEST_1.get();
        }
    }
    public static int getPiglinMerchant1Offer2Count() {
        if (Objects.equals(PIGLIN_MERCHANT_1_OFFER_2_COUNT.get(), PIGLIN_MERCHANT_1_OFFER_2_COUNT.getDefault())) {
            return PIGLIN_MERCHANT_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_OFFER_2_COUNT.get();
        }
    }
    public static String getPiglinMerchant1Offer2() {
        if (Objects.equals(PIGLIN_MERCHANT_1_OFFER_2.get(), PIGLIN_MERCHANT_1_OFFER_2.getDefault())) {
            return PIGLIN_MERCHANT_1_OFFER_2.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_OFFER_2.get();
        }
    }
    public static String getPiglinMerchant1Request2() {
        if (Objects.equals(PIGLIN_MERCHANT_1_REQUEST_2.get(), PIGLIN_MERCHANT_1_REQUEST_2.getDefault())) {
            return PIGLIN_MERCHANT_1_REQUEST_2.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_REQUEST_2.get();
        }
    }
    public static String getPiglinMerchant1Offer3() {
        if (Objects.equals(PIGLIN_MERCHANT_1_OFFER_3.get(), PIGLIN_MERCHANT_1_OFFER_3.getDefault())) {
            return PIGLIN_MERCHANT_1_OFFER_3.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_OFFER_3.get();
        }
    }
    public static String getPiglinMerchant1Request3() {
        if (Objects.equals(PIGLIN_MERCHANT_1_REQUEST_3.get(), PIGLIN_MERCHANT_1_REQUEST_3.getDefault())) {
            return PIGLIN_MERCHANT_1_REQUEST_3.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_REQUEST_3.get();
        }
    }
    public static int getPiglinMerchant1Offer4Count() {
        if (Objects.equals(PIGLIN_MERCHANT_1_OFFER_4_COUNT.get(), PIGLIN_MERCHANT_1_OFFER_4_COUNT.getDefault())) {
            return PIGLIN_MERCHANT_1_OFFER_4_COUNT.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_OFFER_4_COUNT.get();
        }
    }
    public static String getPiglinMerchant1Offer4() {
        if (Objects.equals(PIGLIN_MERCHANT_1_OFFER_4.get(), PIGLIN_MERCHANT_1_OFFER_4.getDefault())) {
            return PIGLIN_MERCHANT_1_OFFER_4.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_OFFER_4.get();
        }
    }
    public static String getPiglinMerchant1Request4() {
        if (Objects.equals(PIGLIN_MERCHANT_1_REQUEST_4.get(), PIGLIN_MERCHANT_1_REQUEST_4.getDefault())) {
            return PIGLIN_MERCHANT_1_REQUEST_4.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_REQUEST_4.get();
        }
    }
    public static String getPiglinMerchant1Offer5() {
        if (Objects.equals(PIGLIN_MERCHANT_1_OFFER_5.get(), PIGLIN_MERCHANT_1_OFFER_5.getDefault())) {
            return PIGLIN_MERCHANT_1_OFFER_5.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_OFFER_5.get();
        }
    }
    public static String getPiglinMerchant1Request5() {
        if (Objects.equals(PIGLIN_MERCHANT_1_REQUEST_5.get(), PIGLIN_MERCHANT_1_REQUEST_5.getDefault())) {
            return PIGLIN_MERCHANT_1_REQUEST_5.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_1_REQUEST_5.get();
        }
    }
    public static int getPiglinMerchant2Offer1Count() {
        if (Objects.equals(PIGLIN_MERCHANT_2_OFFER_1_COUNT.get(), PIGLIN_MERCHANT_2_OFFER_1_COUNT.getDefault())) {
            return PIGLIN_MERCHANT_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_2_OFFER_1_COUNT.get();
        }
    }
    public static String getPiglinMerchant2Offer1() {
        if (Objects.equals(PIGLIN_MERCHANT_2_OFFER_1.get(), PIGLIN_MERCHANT_2_OFFER_1.getDefault())) {
            return PIGLIN_MERCHANT_2_OFFER_1.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_2_OFFER_1.get();
        }
    }
    public static String getPiglinMerchant2Request1() {
        if (Objects.equals(PIGLIN_MERCHANT_2_REQUEST_1.get(), PIGLIN_MERCHANT_2_REQUEST_1.getDefault())) {
            return PIGLIN_MERCHANT_2_REQUEST_1.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_2_REQUEST_1.get();
        }
    }
    public static String getPiglinMerchant2Offer2() {
        if (Objects.equals(PIGLIN_MERCHANT_2_OFFER_2.get(), PIGLIN_MERCHANT_2_OFFER_2.getDefault())) {
            return PIGLIN_MERCHANT_2_OFFER_2.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_2_OFFER_2.get();
        }
    }
    public static String getPiglinMerchant2Request2() {
        if (Objects.equals(PIGLIN_MERCHANT_2_REQUEST_2.get(), PIGLIN_MERCHANT_2_REQUEST_2.getDefault())) {
            return PIGLIN_MERCHANT_2_REQUEST_2.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_2_REQUEST_2.get();
        }
    }
    public static String getPiglinMerchant2Offer3() {
        if (Objects.equals(PIGLIN_MERCHANT_2_OFFER_3.get(), PIGLIN_MERCHANT_2_OFFER_3.getDefault())) {
            return PIGLIN_MERCHANT_2_OFFER_3.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_2_OFFER_3.get();
        }
    }
    public static String getPiglinMerchant2Request3() {
        if (Objects.equals(PIGLIN_MERCHANT_2_REQUEST_3.get(), PIGLIN_MERCHANT_2_REQUEST_3.getDefault())) {
            return PIGLIN_MERCHANT_2_REQUEST_3.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_2_REQUEST_3.get();
        }
    }
    public static List<String> getPiglinMerchant2EnchantmentList() {
        if (Objects.equals(PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST.get(), PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST.getDefault())) {
            return PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST.get();
        }
    }
    public static int getPiglinMerchant2EnchantmentListLevel() {
        if (Objects.equals(PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST_LEVEL.get(), PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST_LEVEL.getDefault())) {
            return PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST_LEVEL.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_2_OFFER_3_ENCHANTMENT_LIST_LEVEL.get();
        }
    }
}