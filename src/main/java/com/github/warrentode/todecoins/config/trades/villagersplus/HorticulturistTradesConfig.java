package com.github.warrentode.todecoins.config.trades.villagersplus;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorticulturistTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Horticulturist Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_1_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_1_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_2_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_2_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_3_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_3_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_4_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_5_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> HORTICULTURIST_5_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> HORTICULTURIST_5_OFFER_8;

    static {
        // HORTICULTURIST TRADES
        BUILDER.push("Horticulturist Trade Settings");
        // level 1
        BUILDER.push("Horticulturist Level One Trade One");
        HORTICULTURIST_1_REQUEST_1 = BUILDER
                .comment(" Horticulturist 1 Trade Request 1 Table")
                .define("horticulturist_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_1 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 1 Table")
                .define("horticulturist_1_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level One Trade TWo");
        HORTICULTURIST_1_REQUEST_2 = BUILDER
                .comment(" Horticulturist 1 Trade Request 2 Table")
                .define("horticulturist_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_2 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 2 Table")
                .define("horticulturist_1_trade_offer_2_table",
                        TradeLootTables.SEED_TAG_TABLE.toString());
        HORTICULTURIST_1_OFFER_2_COUNT = BUILDER
                .defineInRange("horticulturist_1_trade_offer_2_table", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level One Trade Three");
        HORTICULTURIST_1_REQUEST_3 = BUILDER
                .comment(" Horticulturist 1 Trade Request 3 Table")
                .define("horticulturist_1_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_3 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 3 Table")
                .define("horticulturist_1_trade_offer_3_table",
                        TradeLootTables.LEAVES_TAG_TABLE.toString());
        HORTICULTURIST_1_OFFER_3_COUNT = BUILDER
                .defineInRange("horticulturist_1_trade_offer_2_count", 2, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level One Trade Four");
        HORTICULTURIST_1_REQUEST_4 = BUILDER
                .comment(" Horticulturist 1 Trade Request 4 Table")
                .define("horticulturist_1_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_4 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 4 Table")
                .define("horticulturist_1_trade_offer_4_table",
                        TradeLootTables.DECOR_PLANTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level One Trade Five");
        HORTICULTURIST_1_REQUEST_5 = BUILDER
                .comment(" Horticulturist 1 Trade Request 5 Table")
                .define("horticulturist_1_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_5 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 5 Table")
                .define("horticulturist_1_trade_offer_5_table",
                        TradeLootTables.FLOWER_POT_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level One Trade Six");
        HORTICULTURIST_1_REQUEST_6 = BUILDER
                .comment(" Horticulturist 1 Trade Request 6 Table")
                .define("horticulturist_1_trade_request_6_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_6 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 6 Table")
                .define("horticulturist_1_trade_offer_6_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level One Trade Seven");
        HORTICULTURIST_1_REQUEST_7 = BUILDER
                .comment(" Horticulturist 1 Trade Request 7 Table")
                .define("horticulturist_1_trade_request_7_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_7 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 7 Table")
                .define("horticulturist_1_trade_offer_7_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level One Trade Eight");
        HORTICULTURIST_1_REQUEST_8 = BUILDER
                .comment(" Horticulturist 1 Trade Request 8 Table")
                .define("horticulturist_1_trade_request_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_1_OFFER_8 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 8 Table")
                .define("horticulturist_1_trade_offer_8_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Horticulturist Level Two Trade One");
        HORTICULTURIST_2_REQUEST_1 = BUILDER
                .comment(" Horticulturist 2 Trade Request 1 Table")
                .define("horticulturist_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_1 = BUILDER
                .comment(" Horticulturist 2 Trade Offer 1 Table")
                .define("horticulturist_2_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Two Trade TWo");
        HORTICULTURIST_2_REQUEST_2 = BUILDER
                .comment(" Horticulturist 2 Trade Request 2 Table")
                .define("horticulturist_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_2 = BUILDER
                .comment(" Horticulturist 2 Trade Offer 2 Table")
                .define("horticulturist_2_trade_offer_2_table",
                        TradeLootTables.SEED_TAG_TABLE.toString());
        HORTICULTURIST_2_OFFER_2_COUNT = BUILDER
                .defineInRange("horticulturist_2_trade_offer_2_table", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Two Trade Three");
        HORTICULTURIST_2_REQUEST_3 = BUILDER
                .comment(" Horticulturist 2 Trade Request 3 Table")
                .define("horticulturist_2_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_3 = BUILDER
                .comment(" Horticulturist 2 Trade Offer 3 Table")
                .define("horticulturist_2_trade_offer_3_table",
                        TradeLootTables.LEAVES_TAG_TABLE.toString());
        HORTICULTURIST_2_OFFER_3_COUNT = BUILDER
                .defineInRange("horticulturist_2_trade_offer_3_count", 2, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Two Trade Four");
        HORTICULTURIST_2_REQUEST_4 = BUILDER
                .comment(" Horticulturist 2 Trade Request 4 Table")
                .define("horticulturist_2_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_4 = BUILDER
                .comment(" Horticulturist 2 Trade Offer 4 Table")
                .define("horticulturist_2_trade_offer_4_table",
                        TradeLootTables.DECOR_PLANTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Two Trade Five");
        HORTICULTURIST_2_REQUEST_5 = BUILDER
                .comment(" Horticulturist 2 Trade Request 5 Table")
                .define("horticulturist_1_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_5 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 5 Table")
                .define("horticulturist_1_trade_offer_5_table",
                        TradeLootTables.FLOWER_POT_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Two Trade Six");
        HORTICULTURIST_2_REQUEST_6 = BUILDER
                .comment(" Horticulturist 2 Trade Request 6 Table")
                .define("horticulturist_2_trade_request_6_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_6 = BUILDER
                .comment(" Horticulturist 2 Trade Offer 6 Table")
                .define("horticulturist_2_trade_offer_6_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Two Trade Seven");
        HORTICULTURIST_2_REQUEST_7 = BUILDER
                .comment(" Horticulturist 2 Trade Request 7 Table")
                .define("horticulturist_2_trade_request_7_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_7 = BUILDER
                .comment(" Horticulturist 2 Trade Offer 7 Table")
                .define("horticulturist_2_trade_offer_7_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Two Trade Eight");
        HORTICULTURIST_2_REQUEST_8 = BUILDER
                .comment(" Horticulturist 2 Trade Request 8 Table")
                .define("horticulturist_2_trade_request_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_2_OFFER_8 = BUILDER
                .comment(" Horticulturist 2 Trade Offer 8 Table")
                .define("horticulturist_2_trade_offer_8_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Horticulturist Level Three Trade One");
        HORTICULTURIST_3_REQUEST_1 = BUILDER
                .comment(" Horticulturist 3 Trade Request 1 Table")
                .define("horticulturist_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_1 = BUILDER
                .comment(" Horticulturist 3 Trade Offer 1 Table")
                .define("horticulturist_3_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Three Trade TWo");
        HORTICULTURIST_3_REQUEST_2 = BUILDER
                .comment(" Horticulturist 3 Trade Request 2 Table")
                .define("horticulturist_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_2 = BUILDER
                .comment(" Horticulturist 3 Trade Offer 2 Table")
                .define("horticulturist_3_trade_offer_2_table",
                        TradeLootTables.SEED_TAG_TABLE.toString());
        HORTICULTURIST_3_OFFER_2_COUNT = BUILDER
                .defineInRange("horticulturist_3_trade_offer_2_table", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Three Trade Three");
        HORTICULTURIST_3_REQUEST_3 = BUILDER
                .comment(" Horticulturist 3 Trade Request 3 Table")
                .define("horticulturist_3_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_3 = BUILDER
                .comment(" Horticulturist 3 Trade Offer 3 Table")
                .define("horticulturist_3_trade_offer_3_table",
                        TradeLootTables.LEAVES_TAG_TABLE.toString());
        HORTICULTURIST_3_OFFER_3_COUNT = BUILDER
                .defineInRange("horticulturist_3_trade_offer_3_count", 2, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Three Trade Four");
        HORTICULTURIST_3_REQUEST_4 = BUILDER
                .comment(" Horticulturist 3 Trade Request 4 Table")
                .define("horticulturist_3_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_4 = BUILDER
                .comment(" Horticulturist 3 Trade Offer 4 Table")
                .define("horticulturist_3_trade_offer_4_table",
                        TradeLootTables.DECOR_PLANTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Three Trade Five");
        HORTICULTURIST_3_REQUEST_5 = BUILDER
                .comment(" Horticulturist 3 Trade Request 5 Table")
                .define("horticulturist_1_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_5 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 5 Table")
                .define("horticulturist_1_trade_offer_5_table",
                        TradeLootTables.FLOWER_POT_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Three Trade Six");
        HORTICULTURIST_3_REQUEST_6 = BUILDER
                .comment(" Horticulturist 3 Trade Request 6 Table")
                .define("horticulturist_3_trade_request_6_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_6 = BUILDER
                .comment(" Horticulturist 3 Trade Offer 6 Table")
                .define("horticulturist_3_trade_offer_6_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Three Trade Seven");
        HORTICULTURIST_3_REQUEST_7 = BUILDER
                .comment(" Horticulturist 3 Trade Request 7 Table")
                .define("horticulturist_3_trade_request_7_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_7 = BUILDER
                .comment(" Horticulturist 3 Trade Offer 7 Table")
                .define("horticulturist_3_trade_offer_7_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Three Trade Eight");
        HORTICULTURIST_3_REQUEST_8 = BUILDER
                .comment(" Horticulturist 3 Trade Request 8 Table")
                .define("horticulturist_3_trade_request_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_3_OFFER_8 = BUILDER
                .comment(" Horticulturist 3 Trade Offer 8 Table")
                .define("horticulturist_3_trade_offer_8_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Horticulturist Level Four Trade One");
        HORTICULTURIST_4_REQUEST_1 = BUILDER
                .comment(" Horticulturist 4 Trade Request 1 Table")
                .define("horticulturist_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_1 = BUILDER
                .comment(" Horticulturist 4 Trade Offer 1 Table")
                .define("horticulturist_4_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Four Trade TWo");
        HORTICULTURIST_4_REQUEST_2 = BUILDER
                .comment(" Horticulturist 4 Trade Request 2 Table")
                .define("horticulturist_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_2 = BUILDER
                .comment(" Horticulturist 4 Trade Offer 2 Table")
                .define("horticulturist_4_trade_offer_2_table",
                        TradeLootTables.SEED_TAG_TABLE.toString());
        HORTICULTURIST_4_OFFER_2_COUNT = BUILDER
                .defineInRange("horticulturist_4_trade_offer_2_table", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Four Trade Three");
        HORTICULTURIST_4_REQUEST_3 = BUILDER
                .comment(" Horticulturist 4 Trade Request 3 Table")
                .define("horticulturist_4_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_3 = BUILDER
                .comment(" Horticulturist 4 Trade Offer 3 Table")
                .define("horticulturist_4_trade_offer_3_table",
                        TradeLootTables.LEAVES_TAG_TABLE.toString());
        HORTICULTURIST_4_OFFER_3_COUNT = BUILDER
                .defineInRange("horticulturist_4_trade_offer_3_count", 2, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Four Trade Four");
        HORTICULTURIST_4_REQUEST_4 = BUILDER
                .comment(" Horticulturist 4 Trade Request 4 Table")
                .define("horticulturist_4_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_4 = BUILDER
                .comment(" Horticulturist 4 Trade Offer 4 Table")
                .define("horticulturist_4_trade_offer_4_table",
                        TradeLootTables.DECOR_PLANTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Four Trade Five");
        HORTICULTURIST_4_REQUEST_5 = BUILDER
                .comment(" Horticulturist 4 Trade Request 5 Table")
                .define("horticulturist_1_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_5 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 5 Table")
                .define("horticulturist_1_trade_offer_5_table",
                        TradeLootTables.FLOWER_POT_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Four Trade Six");
        HORTICULTURIST_4_REQUEST_6 = BUILDER
                .comment(" Horticulturist 4 Trade Request 6 Table")
                .define("horticulturist_4_trade_request_6_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_6 = BUILDER
                .comment(" Horticulturist 4 Trade Offer 6 Table")
                .define("horticulturist_4_trade_offer_6_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Four Trade Seven");
        HORTICULTURIST_4_REQUEST_7 = BUILDER
                .comment(" Horticulturist 4 Trade Request 7 Table")
                .define("horticulturist_4_trade_request_7_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_7 = BUILDER
                .comment(" Horticulturist 4 Trade Offer 7 Table")
                .define("horticulturist_4_trade_offer_7_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Four Trade Eight");
        HORTICULTURIST_4_REQUEST_8 = BUILDER
                .comment(" Horticulturist 4 Trade Request 8 Table")
                .define("horticulturist_4_trade_request_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_4_OFFER_8 = BUILDER
                .comment(" Horticulturist 4 Trade Offer 8 Table")
                .define("horticulturist_4_trade_offer_8_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Horticulturist Level Five Trade One");
        HORTICULTURIST_5_REQUEST_1 = BUILDER
                .comment(" Horticulturist 5 Trade Request 1 Table")
                .define("horticulturist_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_1 = BUILDER
                .comment(" Horticulturist 5 Trade Offer 1 Table")
                .define("horticulturist_5_trade_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Five Trade TWo");
        HORTICULTURIST_5_REQUEST_2 = BUILDER
                .comment(" Horticulturist 5 Trade Request 2 Table")
                .define("horticulturist_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_2 = BUILDER
                .comment(" Horticulturist 5 Trade Offer 2 Table")
                .define("horticulturist_5_trade_offer_2_table",
                        TradeLootTables.SEED_TAG_TABLE.toString());
        HORTICULTURIST_5_OFFER_2_COUNT = BUILDER
                .defineInRange("horticulturist_5_trade_offer_2_table", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Five Trade Three");
        HORTICULTURIST_5_REQUEST_3 = BUILDER
                .comment(" Horticulturist 5 Trade Request 3 Table")
                .define("horticulturist_5_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_3 = BUILDER
                .comment(" Horticulturist 5 Trade Offer 3 Table")
                .define("horticulturist_5_trade_offer_3_table",
                        TradeLootTables.LEAVES_TAG_TABLE.toString());
        HORTICULTURIST_5_OFFER_3_COUNT = BUILDER
                .defineInRange("horticulturist_5_trade_offer_3_count", 2, 1, 64);
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Five Trade Four");
        HORTICULTURIST_5_REQUEST_4 = BUILDER
                .comment(" Horticulturist 5 Trade Request 4 Table")
                .define("horticulturist_5_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_4 = BUILDER
                .comment(" Horticulturist 5 Trade Offer 4 Table")
                .define("horticulturist_5_trade_offer_4_table",
                        TradeLootTables.DECOR_PLANTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Five Trade Five");
        HORTICULTURIST_5_REQUEST_5 = BUILDER
                .comment(" Horticulturist 5 Trade Request 5 Table")
                .define("horticulturist_1_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_5 = BUILDER
                .comment(" Horticulturist 1 Trade Offer 5 Table")
                .define("horticulturist_1_trade_offer_5_table",
                        TradeLootTables.FLOWER_POT_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Five Trade Six");
        HORTICULTURIST_5_REQUEST_6 = BUILDER
                .comment(" Horticulturist 5 Trade Request 6 Table")
                .define("horticulturist_5_trade_request_6_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_6 = BUILDER
                .comment(" Horticulturist 5 Trade Offer 6 Table")
                .define("horticulturist_5_trade_offer_6_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Five Trade Seven");
        HORTICULTURIST_5_REQUEST_7 = BUILDER
                .comment(" Horticulturist 5 Trade Request 7 Table")
                .define("horticulturist_5_trade_request_7_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_7 = BUILDER
                .comment(" Horticulturist 5 Trade Offer 7 Table")
                .define("horticulturist_5_trade_offer_7_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Horticulturist Level Five Trade Eight");
        HORTICULTURIST_5_REQUEST_8 = BUILDER
                .comment(" Horticulturist 5 Trade Request 8 Table")
                .define("horticulturist_5_trade_request_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        HORTICULTURIST_5_OFFER_8 = BUILDER
                .comment(" Horticulturist 5 Trade Offer 8 Table")
                .define("horticulturist_5_trade_offer_8_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // HORTICULTURIST TRADE GETTERS
    public static String getHorticulturist5Offer8() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_8.get(), HORTICULTURIST_5_OFFER_8.getDefault())) {
            return HORTICULTURIST_5_OFFER_8.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_8.get();
        }
    }
    public static String getHorticulturist5Request8() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_8.get(), HORTICULTURIST_5_REQUEST_8.getDefault())) {
            return HORTICULTURIST_5_REQUEST_8.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_8.get();
        }
    }
    public static String getHorticulturist5Offer7() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_7.get(), HORTICULTURIST_5_OFFER_7.getDefault())) {
            return HORTICULTURIST_5_OFFER_7.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_7.get();
        }
    }
    public static String getHorticulturist5Request7() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_7.get(), HORTICULTURIST_5_REQUEST_7.getDefault())) {
            return HORTICULTURIST_5_REQUEST_7.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_7.get();
        }
    }
    public static String getHorticulturist5Offer6() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_6.get(), HORTICULTURIST_5_OFFER_6.getDefault())) {
            return HORTICULTURIST_5_OFFER_6.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_6.get();
        }
    }
    public static String getHorticulturist5Request6() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_6.get(), HORTICULTURIST_5_REQUEST_6.getDefault())) {
            return HORTICULTURIST_5_REQUEST_6.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_6.get();
        }
    }
    public static String getHorticulturist5Offer5() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_5.get(), HORTICULTURIST_5_OFFER_5.getDefault())) {
            return HORTICULTURIST_5_OFFER_5.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_5.get();
        }
    }
    public static String getHorticulturist5Request5() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_5.get(), HORTICULTURIST_5_REQUEST_5.getDefault())) {
            return HORTICULTURIST_5_REQUEST_5.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_5.get();
        }
    }
    public static String getHorticulturist5Offer4() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_4.get(), HORTICULTURIST_5_OFFER_4.getDefault())) {
            return HORTICULTURIST_5_OFFER_4.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_4.get();
        }
    }
    public static String getHorticulturist5Request4() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_4.get(), HORTICULTURIST_5_REQUEST_4.getDefault())) {
            return HORTICULTURIST_5_REQUEST_4.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_4.get();
        }
    }
    public static int getHorticulturist5Offer3Count() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_3_COUNT.get(), HORTICULTURIST_5_OFFER_3_COUNT.getDefault())) {
            return HORTICULTURIST_5_OFFER_3_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_3_COUNT.get();
        }
    }
    public static String getHorticulturist5Offer3() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_3.get(), HORTICULTURIST_5_OFFER_3.getDefault())) {
            return HORTICULTURIST_5_OFFER_3.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_3.get();
        }
    }
    public static String getHorticulturist5Request3() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_3.get(), HORTICULTURIST_5_REQUEST_3.getDefault())) {
            return HORTICULTURIST_5_REQUEST_3.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_3.get();
        }
    }
    public static int getHorticulturist5Offer2Count() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_2_COUNT.get(), HORTICULTURIST_5_OFFER_2_COUNT.getDefault())) {
            return HORTICULTURIST_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_2_COUNT.get();
        }
    }
    public static String getHorticulturist5Offer2() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_2.get(), HORTICULTURIST_5_OFFER_2.getDefault())) {
            return HORTICULTURIST_5_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_2.get();
        }
    }
    public static String getHorticulturist5Request2() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_2.get(), HORTICULTURIST_5_REQUEST_2.getDefault())) {
            return HORTICULTURIST_5_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_2.get();
        }
    }
    public static String getHorticulturist5Offer1() {
        if (Objects.equals(HORTICULTURIST_5_OFFER_1.get(), HORTICULTURIST_5_OFFER_1.getDefault())) {
            return HORTICULTURIST_5_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_5_OFFER_1.get();
        }
    }
    public static String getHorticulturist5Request1() {
        if (Objects.equals(HORTICULTURIST_5_REQUEST_1.get(), HORTICULTURIST_5_REQUEST_1.getDefault())) {
            return HORTICULTURIST_5_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_5_REQUEST_1.get();
        }
    }
    public static String getHorticulturist4Offer8() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_8.get(), HORTICULTURIST_4_OFFER_8.getDefault())) {
            return HORTICULTURIST_4_OFFER_8.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_8.get();
        }
    }
    public static String getHorticulturist4Request8() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_8.get(), HORTICULTURIST_4_REQUEST_8.getDefault())) {
            return HORTICULTURIST_4_REQUEST_8.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_8.get();
        }
    }
    public static String getHorticulturist4Offer7() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_7.get(), HORTICULTURIST_4_OFFER_7.getDefault())) {
            return HORTICULTURIST_4_OFFER_7.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_7.get();
        }
    }
    public static String getHorticulturist4Request7() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_7.get(), HORTICULTURIST_4_REQUEST_7.getDefault())) {
            return HORTICULTURIST_4_REQUEST_7.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_7.get();
        }
    }
    public static String getHorticulturist4Offer6() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_6.get(), HORTICULTURIST_4_OFFER_6.getDefault())) {
            return HORTICULTURIST_4_OFFER_6.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_6.get();
        }
    }
    public static String getHorticulturist4Request6() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_6.get(), HORTICULTURIST_4_REQUEST_6.getDefault())) {
            return HORTICULTURIST_4_REQUEST_6.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_6.get();
        }
    }
    public static String getHorticulturist4Offer5() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_5.get(), HORTICULTURIST_4_OFFER_5.getDefault())) {
            return HORTICULTURIST_4_OFFER_5.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_5.get();
        }
    }
    public static String getHorticulturist4Request5() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_5.get(), HORTICULTURIST_4_REQUEST_5.getDefault())) {
            return HORTICULTURIST_4_REQUEST_5.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_5.get();
        }
    }
    public static String getHorticulturist4Offer4() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_4.get(), HORTICULTURIST_4_OFFER_4.getDefault())) {
            return HORTICULTURIST_4_OFFER_4.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_4.get();
        }
    }
    public static String getHorticulturist4Request4() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_4.get(), HORTICULTURIST_4_REQUEST_4.getDefault())) {
            return HORTICULTURIST_4_REQUEST_4.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_4.get();
        }
    }
    public static int getHorticulturist4Offer3Count() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_3_COUNT.get(), HORTICULTURIST_4_OFFER_3_COUNT.getDefault())) {
            return HORTICULTURIST_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_3_COUNT.get();
        }
    }
    public static String getHorticulturist4Offer3() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_3.get(), HORTICULTURIST_4_OFFER_3.getDefault())) {
            return HORTICULTURIST_4_OFFER_3.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_3.get();
        }
    }
    public static String getHorticulturist4Request3() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_3.get(), HORTICULTURIST_4_REQUEST_3.getDefault())) {
            return HORTICULTURIST_4_REQUEST_3.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_3.get();
        }
    }
    public static int getHorticulturist4Offer2Count() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_2_COUNT.get(), HORTICULTURIST_4_OFFER_2_COUNT.getDefault())) {
            return HORTICULTURIST_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_2_COUNT.get();
        }
    }
    public static String getHorticulturist4Offer2() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_2.get(), HORTICULTURIST_4_OFFER_2.getDefault())) {
            return HORTICULTURIST_4_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_2.get();
        }
    }
    public static String getHorticulturist4Request2() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_2.get(), HORTICULTURIST_4_REQUEST_2.getDefault())) {
            return HORTICULTURIST_4_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_2.get();
        }
    }
    public static String getHorticulturist4Offer1() {
        if (Objects.equals(HORTICULTURIST_4_OFFER_1.get(), HORTICULTURIST_4_OFFER_1.getDefault())) {
            return HORTICULTURIST_4_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_4_OFFER_1.get();
        }
    }
    public static String getHorticulturist4Request1() {
        if (Objects.equals(HORTICULTURIST_4_REQUEST_1.get(), HORTICULTURIST_4_REQUEST_1.getDefault())) {
            return HORTICULTURIST_4_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_4_REQUEST_1.get();
        }
    }
    public static String getHorticulturist3Offer8() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_8.get(), HORTICULTURIST_3_OFFER_8.getDefault())) {
            return HORTICULTURIST_3_OFFER_8.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_8.get();
        }
    }
    public static String getHorticulturist3Request8() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_8.get(), HORTICULTURIST_3_REQUEST_8.getDefault())) {
            return HORTICULTURIST_3_REQUEST_8.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_8.get();
        }
    }
    public static String getHorticulturist3Offer7() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_7.get(), HORTICULTURIST_3_OFFER_7.getDefault())) {
            return HORTICULTURIST_3_OFFER_7.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_7.get();
        }
    }
    public static String getHorticulturist3Request7() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_7.get(), HORTICULTURIST_3_REQUEST_7.getDefault())) {
            return HORTICULTURIST_3_REQUEST_7.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_7.get();
        }
    }
    public static String getHorticulturist3Offer6() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_6.get(), HORTICULTURIST_3_OFFER_6.getDefault())) {
            return HORTICULTURIST_3_OFFER_6.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_6.get();
        }
    }
    public static String getHorticulturist3Request6() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_6.get(), HORTICULTURIST_3_REQUEST_6.getDefault())) {
            return HORTICULTURIST_3_REQUEST_6.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_6.get();
        }
    }
    public static String getHorticulturist3Offer5() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_5.get(), HORTICULTURIST_3_OFFER_5.getDefault())) {
            return HORTICULTURIST_3_OFFER_5.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_5.get();
        }
    }
    public static String getHorticulturist3Request5() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_5.get(), HORTICULTURIST_3_REQUEST_5.getDefault())) {
            return HORTICULTURIST_3_REQUEST_5.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_5.get();
        }
    }
    public static String getHorticulturist3Offer4() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_4.get(), HORTICULTURIST_3_OFFER_4.getDefault())) {
            return HORTICULTURIST_3_OFFER_4.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_4.get();
        }
    }
    public static String getHorticulturist3Request4() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_4.get(), HORTICULTURIST_3_REQUEST_4.getDefault())) {
            return HORTICULTURIST_3_REQUEST_4.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_4.get();
        }
    }
    public static int getHorticulturist3Offer3Count() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_3_COUNT.get(), HORTICULTURIST_3_OFFER_3_COUNT.getDefault())) {
            return HORTICULTURIST_3_OFFER_3_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_3_COUNT.get();
        }
    }
    public static String getHorticulturist3Offer3() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_3.get(), HORTICULTURIST_3_OFFER_3.getDefault())) {
            return HORTICULTURIST_3_OFFER_3.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_3.get();
        }
    }
    public static String getHorticulturist3Request3() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_3.get(), HORTICULTURIST_3_REQUEST_3.getDefault())) {
            return HORTICULTURIST_3_REQUEST_3.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_3.get();
        }
    }
    public static int getHorticulturist3Offer2Count() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_2_COUNT.get(), HORTICULTURIST_3_OFFER_2_COUNT.getDefault())) {
            return HORTICULTURIST_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_2_COUNT.get();
        }
    }
    public static String getHorticulturist3Offer2() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_2.get(), HORTICULTURIST_3_OFFER_2.getDefault())) {
            return HORTICULTURIST_3_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_2.get();
        }
    }
    public static String getHorticulturist3Request2() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_2.get(), HORTICULTURIST_3_REQUEST_2.getDefault())) {
            return HORTICULTURIST_3_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_2.get();
        }
    }
    public static String getHorticulturist3Offer1() {
        if (Objects.equals(HORTICULTURIST_3_OFFER_1.get(), HORTICULTURIST_3_OFFER_1.getDefault())) {
            return HORTICULTURIST_3_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_3_OFFER_1.get();
        }
    }
    public static String getHorticulturist3Request1() {
        if (Objects.equals(HORTICULTURIST_3_REQUEST_1.get(), HORTICULTURIST_3_REQUEST_1.getDefault())) {
            return HORTICULTURIST_3_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_3_REQUEST_1.get();
        }
    }
    public static String getHorticulturist2Offer8() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_8.get(), HORTICULTURIST_2_OFFER_8.getDefault())) {
            return HORTICULTURIST_2_OFFER_8.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_8.get();
        }
    }
    public static String getHorticulturist2Request8() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_8.get(), HORTICULTURIST_2_REQUEST_8.getDefault())) {
            return HORTICULTURIST_2_REQUEST_8.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_8.get();
        }
    }
    public static String getHorticulturist2Offer7() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_7.get(), HORTICULTURIST_2_OFFER_7.getDefault())) {
            return HORTICULTURIST_2_OFFER_7.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_7.get();
        }
    }
    public static String getHorticulturist2Request7() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_7.get(), HORTICULTURIST_2_REQUEST_7.getDefault())) {
            return HORTICULTURIST_2_REQUEST_7.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_7.get();
        }
    }
    public static String getHorticulturist2Offer6() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_6.get(), HORTICULTURIST_2_OFFER_6.getDefault())) {
            return HORTICULTURIST_2_OFFER_6.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_6.get();
        }
    }
    public static String getHorticulturist2Request6() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_6.get(), HORTICULTURIST_2_REQUEST_6.getDefault())) {
            return HORTICULTURIST_2_REQUEST_6.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_6.get();
        }
    }
    public static String getHorticulturist2Offer5() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_5.get(), HORTICULTURIST_2_OFFER_5.getDefault())) {
            return HORTICULTURIST_2_OFFER_5.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_5.get();
        }
    }
    public static String getHorticulturist2Request5() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_5.get(), HORTICULTURIST_2_REQUEST_5.getDefault())) {
            return HORTICULTURIST_2_REQUEST_5.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_5.get();
        }
    }
    public static String getHorticulturist2Offer4() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_4.get(), HORTICULTURIST_2_OFFER_4.getDefault())) {
            return HORTICULTURIST_2_OFFER_4.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_4.get();
        }
    }
    public static String getHorticulturist2Request4() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_4.get(), HORTICULTURIST_2_REQUEST_4.getDefault())) {
            return HORTICULTURIST_2_REQUEST_4.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_4.get();
        }
    }
    public static int getHorticulturist2Offer3Count() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_3_COUNT.get(), HORTICULTURIST_2_OFFER_3_COUNT.getDefault())) {
            return HORTICULTURIST_2_OFFER_3_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_3_COUNT.get();
        }
    }
    public static String getHorticulturist2Offer3() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_3.get(), HORTICULTURIST_2_OFFER_3.getDefault())) {
            return HORTICULTURIST_2_OFFER_3.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_3.get();
        }
    }
    public static String getHorticulturist2Request3() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_3.get(), HORTICULTURIST_2_REQUEST_3.getDefault())) {
            return HORTICULTURIST_2_REQUEST_3.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_3.get();
        }
    }
    public static int getHorticulturist2Offer2Count() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_2_COUNT.get(), HORTICULTURIST_2_OFFER_2_COUNT.getDefault())) {
            return HORTICULTURIST_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_2_COUNT.get();
        }
    }
    public static String getHorticulturist2Offer2() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_2.get(), HORTICULTURIST_2_OFFER_2.getDefault())) {
            return HORTICULTURIST_2_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_2.get();
        }
    }
    public static String getHorticulturist2Request2() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_2.get(), HORTICULTURIST_2_REQUEST_2.getDefault())) {
            return HORTICULTURIST_2_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_2.get();
        }
    }
    public static String getHorticulturist2Offer1() {
        if (Objects.equals(HORTICULTURIST_2_OFFER_1.get(), HORTICULTURIST_2_OFFER_1.getDefault())) {
            return HORTICULTURIST_2_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_2_OFFER_1.get();
        }
    }
    public static String getHorticulturist2Request1() {
        if (Objects.equals(HORTICULTURIST_2_REQUEST_1.get(), HORTICULTURIST_2_REQUEST_1.getDefault())) {
            return HORTICULTURIST_2_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_2_REQUEST_1.get();
        }
    }
    public static String getHorticulturist1Offer8() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_8.get(), HORTICULTURIST_1_OFFER_8.getDefault())) {
            return HORTICULTURIST_1_OFFER_8.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_8.get();
        }
    }
    public static String getHorticulturist1Request8() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_8.get(), HORTICULTURIST_1_REQUEST_8.getDefault())) {
            return HORTICULTURIST_1_REQUEST_8.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_8.get();
        }
    }
    public static String getHorticulturist1Offer7() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_7.get(), HORTICULTURIST_1_OFFER_7.getDefault())) {
            return HORTICULTURIST_1_OFFER_7.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_7.get();
        }
    }
    public static String getHorticulturist1Request7() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_7.get(), HORTICULTURIST_1_REQUEST_7.getDefault())) {
            return HORTICULTURIST_1_REQUEST_7.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_7.get();
        }
    }
    public static String getHorticulturist1Offer6() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_6.get(), HORTICULTURIST_1_OFFER_6.getDefault())) {
            return HORTICULTURIST_1_OFFER_6.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_6.get();
        }
    }
    public static String getHorticulturist1Request6() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_6.get(), HORTICULTURIST_1_REQUEST_6.getDefault())) {
            return HORTICULTURIST_1_REQUEST_6.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_6.get();
        }
    }
    public static String getHorticulturist1Offer5() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_5.get(), HORTICULTURIST_1_OFFER_5.getDefault())) {
            return HORTICULTURIST_1_OFFER_5.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_5.get();
        }
    }
    public static String getHorticulturist1Request5() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_5.get(), HORTICULTURIST_1_REQUEST_5.getDefault())) {
            return HORTICULTURIST_1_REQUEST_5.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_5.get();
        }
    }
    public static String getHorticulturist1Offer4() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_4.get(), HORTICULTURIST_1_OFFER_4.getDefault())) {
            return HORTICULTURIST_1_OFFER_4.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_4.get();
        }
    }
    public static String getHorticulturist1Request4() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_4.get(), HORTICULTURIST_1_REQUEST_4.getDefault())) {
            return HORTICULTURIST_1_REQUEST_4.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_4.get();
        }
    }
    public static int getHorticulturist1Offer3Count() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_3_COUNT.get(), HORTICULTURIST_1_OFFER_3_COUNT.getDefault())) {
            return HORTICULTURIST_1_OFFER_3_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_3_COUNT.get();
        }
    }
    public static String getHorticulturist1Offer3() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_3.get(), HORTICULTURIST_1_OFFER_3.getDefault())) {
            return HORTICULTURIST_1_OFFER_3.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_3.get();
        }
    }
    public static String getHorticulturist1Request3() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_3.get(), HORTICULTURIST_1_REQUEST_3.getDefault())) {
            return HORTICULTURIST_1_REQUEST_3.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_3.get();
        }
    }
    public static int getHorticulturist1Offer2Count() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_2_COUNT.get(), HORTICULTURIST_1_OFFER_2_COUNT.getDefault())) {
            return HORTICULTURIST_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_2_COUNT.get();
        }
    }
    public static String getHorticulturist1Offer2() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_2.get(), HORTICULTURIST_1_OFFER_2.getDefault())) {
            return HORTICULTURIST_1_OFFER_2.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_2.get();
        }
    }
    public static String getHorticulturist1Request2() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_2.get(), HORTICULTURIST_1_REQUEST_2.getDefault())) {
            return HORTICULTURIST_1_REQUEST_2.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_2.get();
        }
    }
    public static String getHorticulturist1Offer1() {
        if (Objects.equals(HORTICULTURIST_1_OFFER_1.get(), HORTICULTURIST_1_OFFER_1.getDefault())) {
            return HORTICULTURIST_1_OFFER_1.getDefault();
        }
        else {
            return HORTICULTURIST_1_OFFER_1.get();
        }
    }
    public static String getHorticulturist1Request1() {
        if (Objects.equals(HORTICULTURIST_1_REQUEST_1.get(), HORTICULTURIST_1_REQUEST_1.getDefault())) {
            return HORTICULTURIST_1_REQUEST_1.getDefault();
        }
        else {
            return HORTICULTURIST_1_REQUEST_1.get();
        }
    }
}