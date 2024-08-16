package com.github.warrentode.todecoins.config.trades.villagersplus;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OccultistTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Occultist Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_1_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_1_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_2_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_2_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_3_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_3_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_4_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_5_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> OCCULTIST_5_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_OFFER_7;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> OCCULTIST_5_OFFER_8;

    static {
        // OCCULTIST TRADES
        BUILDER.push("Occultist Trade Settings");
        // level 1
        BUILDER.push("Occultist Level One Trade One");
        OCCULTIST_1_REQUEST_1 = BUILDER
                .comment(" Occultist 1 Trade Request 1 Table")
                .define("occultist_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_1_OFFER_1 = BUILDER
                .comment(" Occultist 1 Trade Offer 1 Table")
                .define("occultist_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level One Trade TWo");
        OCCULTIST_1_REQUEST_2 = BUILDER
                .comment(" Occultist 1 Trade Request 2 Table")
                .define("occultist_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_1_OFFER_2 = BUILDER
                .comment(" Occultist 1 Trade Offer 2 Table")
                .define("occultist_1_trade_offer_2_table",
                        TradeLootTables.TAGGED_CANDLE_TABLE.toString());
        OCCULTIST_1_OFFER_2_COUNT = BUILDER
                .defineInRange("occultist_1_trade_offer_2_table", 4, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level One Trade Three");
        OCCULTIST_1_REQUEST_3 = BUILDER
                .comment(" Occultist 1 Trade Request 3 Table")
                .define("occultist_1_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_1_OFFER_3 = BUILDER
                .comment(" Occultist 1 Trade Offer 2 Table")
                .define("occultist_1_trade_offer_2_table",
                        TradeLootTables.TAGGED_INK_TABLE.toString());
        OCCULTIST_1_OFFER_3_COUNT = BUILDER
                .defineInRange("occultist_1_trade_offer_2_table", 3, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level One Trade Four");
        OCCULTIST_1_REQUEST_4 = BUILDER
                .comment(" Occultist 1 Trade Request 4 Table")
                .define("occultist_1_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_1_OFFER_4 = BUILDER
                .comment(" Occultist 1 Trade Offer 4 Table")
                .define("occultist_1_trade_offer_4_table",
                        TradeLootTables.LANTERN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level One Trade Five");
        OCCULTIST_1_REQUEST_5 = BUILDER
                .comment(" Occultist 1 Trade Request 5 Table")
                .define("occultist_1_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_1_OFFER_5 = BUILDER
                .comment(" Occultist 1 Trade Offer 5 Table")
                .define("occultist_1_trade_offer_5_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level One Trade Six");
        OCCULTIST_1_REQUEST_6 = BUILDER
                .comment(" Occultist 1 Trade Request 6 Table")
                .define("occultist_1_trade_request_6_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_1_OFFER_6 = BUILDER
                .comment(" Occultist 1 Trade Offer 6 Table")
                .define("occultist_1_trade_offer_6_table",
                        TradeLootTables.TORCH_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level One Trade Seven");
        OCCULTIST_1_REQUEST_7 = BUILDER
                .comment(" Occultist 1 Trade Request 7 Table")
                .define("occultist_1_trade_request_7_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_1_OFFER_7 = BUILDER
                .comment(" Occultist 1 Trade Offer 7 Table")
                .define("occultist_1_trade_offer_7_table",
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level One Trade Eight");
        OCCULTIST_1_REQUEST_8 = BUILDER
                .comment(" Occultist 1 Trade Request 8 Table")
                .define("occultist_1_trade_request_8_table",
                        TradeLootTables.POISONOUS_POTATO_TABLE.toString());
        OCCULTIST_1_OFFER_8 = BUILDER
                .comment(" Occultist 1 Trade Offer 8 Table")
                .define("occultist_1_trade_offer_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Occultist Level Two Trade One");
        OCCULTIST_2_REQUEST_1 = BUILDER
                .comment(" Occultist 2 Trade Request 1 Table")
                .define("occultist_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_2_OFFER_1 = BUILDER
                .comment(" Occultist 2 Trade Offer 1 Table")
                .define("occultist_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Two Trade TWo");
        OCCULTIST_2_REQUEST_2 = BUILDER
                .comment(" Occultist 2 Trade Request 2 Table")
                .define("occultist_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_2_OFFER_2 = BUILDER
                .comment(" Occultist 2 Trade Offer 2 Table")
                .define("occultist_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_CANDLE_TABLE.toString());
        OCCULTIST_2_OFFER_2_COUNT = BUILDER
                .defineInRange("occultist_2_trade_offer_2_table", 4, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level Two Trade Three");
        OCCULTIST_2_REQUEST_3 = BUILDER
                .comment(" Occultist 2 Trade Request 3 Table")
                .define("occultist_2_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_2_OFFER_3 = BUILDER
                .comment(" Occultist 2 Trade Offer 3 Table")
                .define("occultist_2_trade_offer_3_table",
                        TradeLootTables.TAGGED_INK_TABLE.toString());
        OCCULTIST_2_OFFER_3_COUNT = BUILDER
                .defineInRange("occultist_2_trade_offer_3_table", 3, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level Two Trade Four");
        OCCULTIST_2_REQUEST_4 = BUILDER
                .comment(" Occultist 2 Trade Request 4 Table")
                .define("occultist_2_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_2_OFFER_4 = BUILDER
                .comment(" Occultist 2 Trade Offer 4 Table")
                .define("occultist_2_trade_offer_4_table",
                        TradeLootTables.LANTERN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Two Trade Five");
        OCCULTIST_2_REQUEST_5 = BUILDER
                .comment(" Occultist 2 Trade Request 5 Table")
                .define("occultist_2_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_2_OFFER_5 = BUILDER
                .comment(" Occultist 2 Trade Offer 5 Table")
                .define("occultist_2_trade_offer_5_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Two Trade Six");
        OCCULTIST_2_REQUEST_6 = BUILDER
                .comment(" Occultist 2 Trade Request 6 Table")
                .define("occultist_2_trade_request_6_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_2_OFFER_6 = BUILDER
                .comment(" Occultist 2 Trade Offer 6 Table")
                .define("occultist_2_trade_offer_6_table",
                        TradeLootTables.TORCH_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Two Trade Seven");
        OCCULTIST_2_REQUEST_7 = BUILDER
                .comment(" Occultist 2 Trade Request 7 Table")
                .define("occultist_2_trade_request_7_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_2_OFFER_7 = BUILDER
                .comment(" Occultist 2 Trade Offer 7 Table")
                .define("occultist_2_trade_offer_7_table",
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Two Trade Eight");
        OCCULTIST_2_REQUEST_8 = BUILDER
                .comment(" Occultist 2 Trade Request 8 Table")
                .define("occultist_2_trade_request_8_table",
                        TradeLootTables.POISONOUS_POTATO_TABLE.toString());
        OCCULTIST_2_OFFER_8 = BUILDER
                .comment(" Occultist 2 Trade Offer 8 Table")
                .define("occultist_2_trade_offer_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Occultist Level Three Trade One");
        OCCULTIST_3_REQUEST_1 = BUILDER
                .comment(" Occultist 3 Trade Request 1 Table")
                .define("occultist_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_3_OFFER_1 = BUILDER
                .comment(" Occultist 3 Trade Offer 1 Table")
                .define("occultist_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Three Trade TWo");
        OCCULTIST_3_REQUEST_2 = BUILDER
                .comment(" Occultist 3 Trade Request 2 Table")
                .define("occultist_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_3_OFFER_2 = BUILDER
                .comment(" Occultist 3 Trade Offer 2 Table")
                .define("occultist_3_trade_offer_2_table",
                        TradeLootTables.TAGGED_CANDLE_TABLE.toString());
        OCCULTIST_3_OFFER_2_COUNT = BUILDER
                .defineInRange("occultist_3_trade_offer_2_table", 4, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level Three Trade Three");
        OCCULTIST_3_REQUEST_3 = BUILDER
                .comment(" Occultist 3 Trade Request 3 Table")
                .define("occultist_3_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_3_OFFER_3 = BUILDER
                .comment(" Occultist 3 Trade Offer 3 Table")
                .define("occultist_3_trade_offer_3_table",
                        TradeLootTables.TAGGED_INK_TABLE.toString());
        OCCULTIST_3_OFFER_3_COUNT = BUILDER
                .defineInRange("occultist_3_trade_offer_3_table", 3, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level Three Trade Four");
        OCCULTIST_3_REQUEST_4 = BUILDER
                .comment(" Occultist 3 Trade Request 4 Table")
                .define("occultist_3_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_3_OFFER_4 = BUILDER
                .comment(" Occultist 3 Trade Offer 4 Table")
                .define("occultist_3_trade_offer_4_table",
                        TradeLootTables.LANTERN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Three Trade Five");
        OCCULTIST_3_REQUEST_5 = BUILDER
                .comment(" Occultist 3 Trade Request 5 Table")
                .define("occultist_3_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_3_OFFER_5 = BUILDER
                .comment(" Occultist 3 Trade Offer 5 Table")
                .define("occultist_3_trade_offer_5_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Three Trade Six");
        OCCULTIST_3_REQUEST_6 = BUILDER
                .comment(" Occultist 3 Trade Request 6 Table")
                .define("occultist_3_trade_request_6_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_3_OFFER_6 = BUILDER
                .comment(" Occultist 3 Trade Offer 6 Table")
                .define("occultist_3_trade_offer_6_table",
                        TradeLootTables.TORCH_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Three Trade Seven");
        OCCULTIST_3_REQUEST_7 = BUILDER
                .comment(" Occultist 3 Trade Request 7 Table")
                .define("occultist_3_trade_request_7_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_3_OFFER_7 = BUILDER
                .comment(" Occultist 3 Trade Offer 7 Table")
                .define("occultist_3_trade_offer_7_table",
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Three Trade Eight");
        OCCULTIST_3_REQUEST_8 = BUILDER
                .comment(" Occultist 3 Trade Request 8 Table")
                .define("occultist_3_trade_request_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_3_OFFER_8 = BUILDER
                .comment(" Occultist 3 Trade Offer 8 Table")
                .define("occultist_3_trade_offer_8_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Occultist Level Four Trade One");
        OCCULTIST_4_REQUEST_1 = BUILDER
                .comment(" Occultist 4 Trade Request 1 Table")
                .define("occultist_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_4_OFFER_1 = BUILDER
                .comment(" Occultist 4 Trade Offer 1 Table")
                .define("occultist_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Four Trade TWo");
        OCCULTIST_4_REQUEST_2 = BUILDER
                .comment(" Occultist 4 Trade Request 2 Table")
                .define("occultist_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_4_OFFER_2 = BUILDER
                .comment(" Occultist 4 Trade Offer 2 Table")
                .define("occultist_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_CANDLE_TABLE.toString());
        OCCULTIST_4_OFFER_2_COUNT = BUILDER
                .defineInRange("occultist_4_trade_offer_2_table", 4, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level Four Trade Three");
        OCCULTIST_4_REQUEST_3 = BUILDER
                .comment(" Occultist 4 Trade Request 3 Table")
                .define("occultist_4_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_4_OFFER_3 = BUILDER
                .comment(" Occultist 4 Trade Offer 3 Table")
                .define("occultist_4_trade_offer_3_table",
                        TradeLootTables.TAGGED_INK_TABLE.toString());
        OCCULTIST_4_OFFER_3_COUNT = BUILDER
                .defineInRange("occultist_4_trade_offer_3_table", 3, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level Four Trade Four");
        OCCULTIST_4_REQUEST_4 = BUILDER
                .comment(" Occultist 4 Trade Request 4 Table")
                .define("occultist_4_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_4_OFFER_4 = BUILDER
                .comment(" Occultist 4 Trade Offer 4 Table")
                .define("occultist_4_trade_offer_4_table",
                        TradeLootTables.LANTERN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Four Trade Five");
        OCCULTIST_4_REQUEST_5 = BUILDER
                .comment(" Occultist 4 Trade Request 5 Table")
                .define("occultist_4_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_4_OFFER_5 = BUILDER
                .comment(" Occultist 4 Trade Offer 5 Table")
                .define("occultist_4_trade_offer_5_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Four Trade Six");
        OCCULTIST_4_REQUEST_6 = BUILDER
                .comment(" Occultist 4 Trade Request 6 Table")
                .define("occultist_4_trade_request_6_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_4_OFFER_6 = BUILDER
                .comment(" Occultist 4 Trade Offer 6 Table")
                .define("occultist_4_trade_offer_6_table",
                        TradeLootTables.TORCH_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Four Trade Seven");
        OCCULTIST_4_REQUEST_7 = BUILDER
                .comment(" Occultist 4 Trade Request 7 Table")
                .define("occultist_4_trade_request_7_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_4_OFFER_7 = BUILDER
                .comment(" Occultist 4 Trade Offer 7 Table")
                .define("occultist_4_trade_offer_7_table",
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Four Trade Eight");
        OCCULTIST_4_REQUEST_8 = BUILDER
                .comment(" Occultist 4 Trade Request 8 Table")
                .define("occultist_4_trade_request_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_4_OFFER_8 = BUILDER
                .comment(" Occultist 4 Trade Offer 8 Table")
                .define("occultist_4_trade_offer_8_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Occultist Level Five Trade One");
        OCCULTIST_5_REQUEST_1 = BUILDER
                .comment(" Occultist 5 Trade Request 1 Table")
                .define("occultist_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_5_OFFER_1 = BUILDER
                .comment(" Occultist 5 Trade Offer 1 Table")
                .define("occultist_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Five Trade TWo");
        OCCULTIST_5_REQUEST_2 = BUILDER
                .comment(" Occultist 5 Trade Request 2 Table")
                .define("occultist_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_5_OFFER_2 = BUILDER
                .comment(" Occultist 5 Trade Offer 2 Table")
                .define("occultist_5_trade_offer_2_table",
                        TradeLootTables.TAGGED_CANDLE_TABLE.toString());
        OCCULTIST_5_OFFER_2_COUNT = BUILDER
                .defineInRange("occultist_5_trade_offer_2_table", 4, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level Five Trade Three");
        OCCULTIST_5_REQUEST_3 = BUILDER
                .comment(" Occultist 5 Trade Request 3 Table")
                .define("occultist_5_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_5_OFFER_3 = BUILDER
                .comment(" Occultist 5 Trade Offer 3 Table")
                .define("occultist_5_trade_offer_3_table",
                        TradeLootTables.TAGGED_INK_TABLE.toString());
        OCCULTIST_5_OFFER_3_COUNT = BUILDER
                .defineInRange("occultist_5_trade_offer_3_table", 3, 1, 64);
        BUILDER.pop();
        BUILDER.push("Occultist Level Five Trade Four");
        OCCULTIST_5_REQUEST_4 = BUILDER
                .comment(" Occultist 5 Trade Request 4 Table")
                .define("occultist_5_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_5_OFFER_4 = BUILDER
                .comment(" Occultist 5 Trade Offer 4 Table")
                .define("occultist_5_trade_offer_4_table",
                        TradeLootTables.LANTERN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Five Trade Five");
        OCCULTIST_5_REQUEST_5 = BUILDER
                .comment(" Occultist 5 Trade Request 5 Table")
                .define("occultist_5_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_5_OFFER_5 = BUILDER
                .comment(" Occultist 5 Trade Offer 5 Table")
                .define("occultist_5_trade_offer_5_table",
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Five Trade Six");
        OCCULTIST_5_REQUEST_6 = BUILDER
                .comment(" Occultist 5 Trade Request 6 Table")
                .define("occultist_5_trade_request_6_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_5_OFFER_6 = BUILDER
                .comment(" Occultist 5 Trade Offer 6 Table")
                .define("occultist_5_trade_offer_6_table",
                        TradeLootTables.TORCH_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Five Trade Seven");
        OCCULTIST_5_REQUEST_7 = BUILDER
                .comment(" Occultist 5 Trade Request 7 Table")
                .define("occultist_5_trade_request_7_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_5_OFFER_7 = BUILDER
                .comment(" Occultist 5 Trade Offer 7 Table")
                .define("occultist_5_trade_offer_7_table",
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Occultist Level Five Trade Eight");
        OCCULTIST_5_REQUEST_8 = BUILDER
                .comment(" Occultist 5 Trade Request 8 Table")
                .define("occultist_5_trade_request_8_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        OCCULTIST_5_OFFER_8 = BUILDER
                .comment(" Occultist 5 Trade Offer 8 Table")
                .define("occultist_5_trade_offer_8_table",
                        TradeLootTables.BONE_MEAL_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // OCCULTIST TRADE GETTERS
    public static String getOccultist5Offer8() {
        if (Objects.equals(OCCULTIST_5_OFFER_8.get(), OCCULTIST_5_OFFER_8.getDefault())) {
            return OCCULTIST_5_OFFER_8.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_8.get();
        }
    }
    public static String getOccultist5Request8() {
        if (Objects.equals(OCCULTIST_5_REQUEST_8.get(), OCCULTIST_5_REQUEST_8.getDefault())) {
            return OCCULTIST_5_REQUEST_8.getDefault();
        }
        else {
            return OCCULTIST_5_REQUEST_8.get();
        }
    }
    public static String getOccultist5Offer7() {
        if (Objects.equals(OCCULTIST_5_OFFER_7.get(), OCCULTIST_5_OFFER_7.getDefault())) {
            return OCCULTIST_5_OFFER_7.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_7.get();
        }
    }
    public static String getOccultist5Request7() {
        if (Objects.equals(OCCULTIST_5_REQUEST_7.get(), OCCULTIST_5_REQUEST_7.getDefault())) {
            return OCCULTIST_5_REQUEST_7.getDefault();
        }
        else {
            return OCCULTIST_5_REQUEST_7.get();
        }
    }
    public static String getOccultist5Offer6() {
        if (Objects.equals(OCCULTIST_5_OFFER_6.get(), OCCULTIST_5_OFFER_6.getDefault())) {
            return OCCULTIST_5_OFFER_6.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_6.get();
        }
    }
    public static String getOccultist5Request6() {
        if (Objects.equals(OCCULTIST_5_REQUEST_6.get(), OCCULTIST_5_REQUEST_6.getDefault())) {
            return OCCULTIST_5_REQUEST_6.getDefault();
        }
        else {
            return OCCULTIST_5_REQUEST_6.get();
        }
    }
    public static String getOccultist5Offer5() {
        if (Objects.equals(OCCULTIST_5_OFFER_5.get(), OCCULTIST_5_OFFER_5.getDefault())) {
            return OCCULTIST_5_OFFER_5.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_5.get();
        }
    }
    public static String getOccultist5Request5() {
        if (Objects.equals(OCCULTIST_5_REQUEST_5.get(), OCCULTIST_5_REQUEST_5.getDefault())) {
            return OCCULTIST_5_REQUEST_5.getDefault();
        }
        else {
            return OCCULTIST_5_REQUEST_5.get();
        }
    }
    public static String getOccultist5Offer4() {
        if (Objects.equals(OCCULTIST_5_OFFER_4.get(), OCCULTIST_5_OFFER_4.getDefault())) {
            return OCCULTIST_5_OFFER_4.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_4.get();
        }
    }
    public static String getOccultist5Request4() {
        if (Objects.equals(OCCULTIST_5_REQUEST_4.get(), OCCULTIST_5_REQUEST_4.getDefault())) {
            return OCCULTIST_5_REQUEST_4.getDefault();
        }
        else {
            return OCCULTIST_5_REQUEST_4.get();
        }
    }
    public static int getOccultist5Offer3Count() {
        if (Objects.equals(OCCULTIST_5_OFFER_3_COUNT.get(), OCCULTIST_5_OFFER_3_COUNT.getDefault())) {
            return OCCULTIST_5_OFFER_3_COUNT.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_3_COUNT.get();
        }
    }
    public static String getOccultist5Offer3() {
        if (Objects.equals(OCCULTIST_5_OFFER_3.get(), OCCULTIST_5_OFFER_3.getDefault())) {
            return OCCULTIST_5_OFFER_3.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_3.get();
        }
    }
    public static String getOccultist5Request3() {
        if (Objects.equals(OCCULTIST_5_REQUEST_3.get(), OCCULTIST_5_REQUEST_3.getDefault())) {
            return OCCULTIST_5_REQUEST_3.getDefault();
        }
        else {
            return OCCULTIST_5_REQUEST_3.get();
        }
    }
    public static int getOccultist5Offer2Count() {
        if (Objects.equals(OCCULTIST_5_OFFER_2_COUNT.get(), OCCULTIST_5_OFFER_2_COUNT.getDefault())) {
            return OCCULTIST_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_2_COUNT.get();
        }
    }
    public static String getOccultist5Offer2() {
        if (Objects.equals(OCCULTIST_5_OFFER_2.get(), OCCULTIST_5_OFFER_2.getDefault())) {
            return OCCULTIST_5_OFFER_2.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_2.get();
        }
    }
    public static String getOccultist5Request2() {
        if (Objects.equals(OCCULTIST_5_REQUEST_2.get(), OCCULTIST_5_REQUEST_2.getDefault())) {
            return OCCULTIST_5_REQUEST_2.getDefault();
        }
        else {
            return OCCULTIST_5_REQUEST_2.get();
        }
    }
    public static String getOccultist5Offer1() {
        if (Objects.equals(OCCULTIST_5_OFFER_1.get(), OCCULTIST_5_OFFER_1.getDefault())) {
            return OCCULTIST_5_OFFER_1.getDefault();
        }
        else {
            return OCCULTIST_5_OFFER_1.get();
        }
    }
    public static String getOccultist5Request1() {
        if (Objects.equals(OCCULTIST_5_REQUEST_1.get(), OCCULTIST_5_REQUEST_1.getDefault())) {
            return OCCULTIST_5_REQUEST_1.getDefault();
        }
        else {
            return OCCULTIST_5_REQUEST_1.get();
        }
    }
    public static String getOccultist4Offer8() {
        if (Objects.equals(OCCULTIST_4_OFFER_8.get(), OCCULTIST_4_OFFER_8.getDefault())) {
            return OCCULTIST_4_OFFER_8.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_8.get();
        }
    }
    public static String getOccultist4Request8() {
        if (Objects.equals(OCCULTIST_4_REQUEST_8.get(), OCCULTIST_4_REQUEST_8.getDefault())) {
            return OCCULTIST_4_REQUEST_8.getDefault();
        }
        else {
            return OCCULTIST_4_REQUEST_8.get();
        }
    }
    public static String getOccultist4Offer7() {
        if (Objects.equals(OCCULTIST_4_OFFER_7.get(), OCCULTIST_4_OFFER_7.getDefault())) {
            return OCCULTIST_4_OFFER_7.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_7.get();
        }
    }
    public static String getOccultist4Request7() {
        if (Objects.equals(OCCULTIST_4_REQUEST_7.get(), OCCULTIST_4_REQUEST_7.getDefault())) {
            return OCCULTIST_4_REQUEST_7.getDefault();
        }
        else {
            return OCCULTIST_4_REQUEST_7.get();
        }
    }
    public static String getOccultist4Offer6() {
        if (Objects.equals(OCCULTIST_4_OFFER_6.get(), OCCULTIST_4_OFFER_6.getDefault())) {
            return OCCULTIST_4_OFFER_6.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_6.get();
        }
    }
    public static String getOccultist4Request6() {
        if (Objects.equals(OCCULTIST_4_REQUEST_6.get(), OCCULTIST_4_REQUEST_6.getDefault())) {
            return OCCULTIST_4_REQUEST_6.getDefault();
        }
        else {
            return OCCULTIST_4_REQUEST_6.get();
        }
    }
    public static String getOccultist4Offer5() {
        if (Objects.equals(OCCULTIST_4_OFFER_5.get(), OCCULTIST_4_OFFER_5.getDefault())) {
            return OCCULTIST_4_OFFER_5.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_5.get();
        }
    }
    public static String getOccultist4Request5() {
        if (Objects.equals(OCCULTIST_4_REQUEST_5.get(), OCCULTIST_4_REQUEST_5.getDefault())) {
            return OCCULTIST_4_REQUEST_5.getDefault();
        }
        else {
            return OCCULTIST_4_REQUEST_5.get();
        }
    }
    public static String getOccultist4Offer4() {
        if (Objects.equals(OCCULTIST_4_OFFER_4.get(), OCCULTIST_4_OFFER_4.getDefault())) {
            return OCCULTIST_4_OFFER_4.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_4.get();
        }
    }
    public static String getOccultist4Request4() {
        if (Objects.equals(OCCULTIST_4_REQUEST_4.get(), OCCULTIST_4_REQUEST_4.getDefault())) {
            return OCCULTIST_4_REQUEST_4.getDefault();
        }
        else {
            return OCCULTIST_4_REQUEST_4.get();
        }
    }
    public static int getOccultist4Offer3Count() {
        if (Objects.equals(OCCULTIST_4_OFFER_3_COUNT.get(), OCCULTIST_4_OFFER_3_COUNT.getDefault())) {
            return OCCULTIST_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_3_COUNT.get();
        }
    }
    public static String getOccultist4Offer3() {
        if (Objects.equals(OCCULTIST_4_OFFER_3.get(), OCCULTIST_4_OFFER_3.getDefault())) {
            return OCCULTIST_4_OFFER_3.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_3.get();
        }
    }
    public static String getOccultist4Request3() {
        if (Objects.equals(OCCULTIST_4_REQUEST_3.get(), OCCULTIST_4_REQUEST_3.getDefault())) {
            return OCCULTIST_4_REQUEST_3.getDefault();
        }
        else {
            return OCCULTIST_4_REQUEST_3.get();
        }
    }
    public static int getOccultist4Offer2Count() {
        if (Objects.equals(OCCULTIST_4_OFFER_2_COUNT.get(), OCCULTIST_4_OFFER_2_COUNT.getDefault())) {
            return OCCULTIST_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_2_COUNT.get();
        }
    }
    public static String getOccultist4Offer2() {
        if (Objects.equals(OCCULTIST_4_OFFER_2.get(), OCCULTIST_4_OFFER_2.getDefault())) {
            return OCCULTIST_4_OFFER_2.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_2.get();
        }
    }
    public static String getOccultist4Request2() {
        if (Objects.equals(OCCULTIST_4_REQUEST_2.get(), OCCULTIST_4_REQUEST_2.getDefault())) {
            return OCCULTIST_4_REQUEST_2.getDefault();
        }
        else {
            return OCCULTIST_4_REQUEST_2.get();
        }
    }
    public static String getOccultist4Offer1() {
        if (Objects.equals(OCCULTIST_4_OFFER_1.get(), OCCULTIST_4_OFFER_1.getDefault())) {
            return OCCULTIST_4_OFFER_1.getDefault();
        }
        else {
            return OCCULTIST_4_OFFER_1.get();
        }
    }
    public static String getOccultist4Request1() {
        if (Objects.equals(OCCULTIST_4_REQUEST_1.get(), OCCULTIST_4_REQUEST_1.getDefault())) {
            return OCCULTIST_4_REQUEST_1.getDefault();
        }
        else {
            return OCCULTIST_4_REQUEST_1.get();
        }
    }
    public static String getOccultist3Offer8() {
        if (Objects.equals(OCCULTIST_3_OFFER_8.get(), OCCULTIST_3_OFFER_8.getDefault())) {
            return OCCULTIST_3_OFFER_8.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_8.get();
        }
    }
    public static String getOccultist3Request8() {
        if (Objects.equals(OCCULTIST_3_REQUEST_8.get(), OCCULTIST_3_REQUEST_8.getDefault())) {
            return OCCULTIST_3_REQUEST_8.getDefault();
        }
        else {
            return OCCULTIST_3_REQUEST_8.get();
        }
    }
    public static String getOccultist3Offer7() {
        if (Objects.equals(OCCULTIST_3_OFFER_7.get(), OCCULTIST_3_OFFER_7.getDefault())) {
            return OCCULTIST_3_OFFER_7.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_7.get();
        }
    }
    public static String getOccultist3Request7() {
        if (Objects.equals(OCCULTIST_3_REQUEST_7.get(), OCCULTIST_3_REQUEST_7.getDefault())) {
            return OCCULTIST_3_REQUEST_7.getDefault();
        }
        else {
            return OCCULTIST_3_REQUEST_7.get();
        }
    }
    public static String getOccultist3Offer6() {
        if (Objects.equals(OCCULTIST_3_OFFER_6.get(), OCCULTIST_3_OFFER_6.getDefault())) {
            return OCCULTIST_3_OFFER_6.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_6.get();
        }
    }
    public static String getOccultist3Request6() {
        if (Objects.equals(OCCULTIST_3_REQUEST_6.get(), OCCULTIST_3_REQUEST_6.getDefault())) {
            return OCCULTIST_3_REQUEST_6.getDefault();
        }
        else {
            return OCCULTIST_3_REQUEST_6.get();
        }
    }
    public static String getOccultist3Offer5() {
        if (Objects.equals(OCCULTIST_3_OFFER_5.get(), OCCULTIST_3_OFFER_5.getDefault())) {
            return OCCULTIST_3_OFFER_5.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_5.get();
        }
    }
    public static String getOccultist3Request5() {
        if (Objects.equals(OCCULTIST_3_REQUEST_5.get(), OCCULTIST_3_REQUEST_5.getDefault())) {
            return OCCULTIST_3_REQUEST_5.getDefault();
        }
        else {
            return OCCULTIST_3_REQUEST_5.get();
        }
    }
    public static String getOccultist3Offer4() {
        if (Objects.equals(OCCULTIST_3_OFFER_4.get(), OCCULTIST_3_OFFER_4.getDefault())) {
            return OCCULTIST_3_OFFER_4.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_4.get();
        }
    }
    public static String getOccultist3Request4() {
        if (Objects.equals(OCCULTIST_3_REQUEST_4.get(), OCCULTIST_3_REQUEST_4.getDefault())) {
            return OCCULTIST_3_REQUEST_4.getDefault();
        }
        else {
            return OCCULTIST_3_REQUEST_4.get();
        }
    }
    public static int getOccultist3Offer3Count() {
        if (Objects.equals(OCCULTIST_3_OFFER_3_COUNT.get(), OCCULTIST_3_OFFER_3_COUNT.getDefault())) {
            return OCCULTIST_3_OFFER_3_COUNT.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_3_COUNT.get();
        }
    }
    public static String getOccultist3Offer3() {
        if (Objects.equals(OCCULTIST_3_OFFER_3.get(), OCCULTIST_3_OFFER_3.getDefault())) {
            return OCCULTIST_3_OFFER_3.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_3.get();
        }
    }
    public static String getOccultist3Request3() {
        if (Objects.equals(OCCULTIST_3_REQUEST_3.get(), OCCULTIST_3_REQUEST_3.getDefault())) {
            return OCCULTIST_3_REQUEST_3.getDefault();
        }
        else {
            return OCCULTIST_3_REQUEST_3.get();
        }
    }
    public static int getOccultist3Offer2Count() {
        if (Objects.equals(OCCULTIST_3_OFFER_2_COUNT.get(), OCCULTIST_3_OFFER_2_COUNT.getDefault())) {
            return OCCULTIST_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_2_COUNT.get();
        }
    }
    public static String getOccultist3Offer2() {
        if (Objects.equals(OCCULTIST_3_OFFER_2.get(), OCCULTIST_3_OFFER_2.getDefault())) {
            return OCCULTIST_3_OFFER_2.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_2.get();
        }
    }
    public static String getOccultist3Request2() {
        if (Objects.equals(OCCULTIST_3_REQUEST_2.get(), OCCULTIST_3_REQUEST_2.getDefault())) {
            return OCCULTIST_3_REQUEST_2.getDefault();
        }
        else {
            return OCCULTIST_3_REQUEST_2.get();
        }
    }
    public static String getOccultist3Offer1() {
        if (Objects.equals(OCCULTIST_3_OFFER_1.get(), OCCULTIST_3_OFFER_1.getDefault())) {
            return OCCULTIST_3_OFFER_1.getDefault();
        }
        else {
            return OCCULTIST_3_OFFER_1.get();
        }
    }
    public static String getOccultist3Request1() {
        if (Objects.equals(OCCULTIST_3_REQUEST_1.get(), OCCULTIST_3_REQUEST_1.getDefault())) {
            return OCCULTIST_3_REQUEST_1.getDefault();
        }
        else {
            return OCCULTIST_3_REQUEST_1.get();
        }
    }
    public static String getOccultist2Offer8() {
        if (Objects.equals(OCCULTIST_2_OFFER_8.get(), OCCULTIST_2_OFFER_8.getDefault())) {
            return OCCULTIST_2_OFFER_8.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_8.get();
        }
    }
    public static String getOccultist2Request8() {
        if (Objects.equals(OCCULTIST_2_REQUEST_8.get(), OCCULTIST_2_REQUEST_8.getDefault())) {
            return OCCULTIST_2_REQUEST_8.getDefault();
        }
        else {
            return OCCULTIST_2_REQUEST_8.get();
        }
    }
    public static String getOccultist2Offer7() {
        if (Objects.equals(OCCULTIST_2_OFFER_7.get(), OCCULTIST_2_OFFER_7.getDefault())) {
            return OCCULTIST_2_OFFER_7.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_7.get();
        }
    }
    public static String getOccultist2Request7() {
        if (Objects.equals(OCCULTIST_2_REQUEST_7.get(), OCCULTIST_2_REQUEST_7.getDefault())) {
            return OCCULTIST_2_REQUEST_7.getDefault();
        }
        else {
            return OCCULTIST_2_REQUEST_7.get();
        }
    }
    public static String getOccultist2Offer6() {
        if (Objects.equals(OCCULTIST_2_OFFER_6.get(), OCCULTIST_2_OFFER_6.getDefault())) {
            return OCCULTIST_2_OFFER_6.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_6.get();
        }
    }
    public static String getOccultist2Request6() {
        if (Objects.equals(OCCULTIST_2_REQUEST_6.get(), OCCULTIST_2_REQUEST_6.getDefault())) {
            return OCCULTIST_2_REQUEST_6.getDefault();
        }
        else {
            return OCCULTIST_2_REQUEST_6.get();
        }
    }
    public static String getOccultist2Offer5() {
        if (Objects.equals(OCCULTIST_2_OFFER_5.get(), OCCULTIST_2_OFFER_5.getDefault())) {
            return OCCULTIST_2_OFFER_5.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_5.get();
        }
    }
    public static String getOccultist2Request5() {
        if (Objects.equals(OCCULTIST_2_REQUEST_5.get(), OCCULTIST_2_REQUEST_5.getDefault())) {
            return OCCULTIST_2_REQUEST_5.getDefault();
        }
        else {
            return OCCULTIST_2_REQUEST_5.get();
        }
    }
    public static String getOccultist2Offer4() {
        if (Objects.equals(OCCULTIST_2_OFFER_4.get(), OCCULTIST_2_OFFER_4.getDefault())) {
            return OCCULTIST_2_OFFER_4.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_4.get();
        }
    }
    public static String getOccultist2Request4() {
        if (Objects.equals(OCCULTIST_2_REQUEST_4.get(), OCCULTIST_2_REQUEST_4.getDefault())) {
            return OCCULTIST_2_REQUEST_4.getDefault();
        }
        else {
            return OCCULTIST_2_REQUEST_4.get();
        }
    }
    public static int getOccultist2Offer3Count() {
        if (Objects.equals(OCCULTIST_2_OFFER_3_COUNT.get(), OCCULTIST_2_OFFER_3_COUNT.getDefault())) {
            return OCCULTIST_2_OFFER_3_COUNT.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_3_COUNT.get();
        }
    }
    public static String getOccultist2Offer3() {
        if (Objects.equals(OCCULTIST_2_OFFER_3.get(), OCCULTIST_2_OFFER_3.getDefault())) {
            return OCCULTIST_2_OFFER_3.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_3.get();
        }
    }
    public static String getOccultist2Request3() {
        if (Objects.equals(OCCULTIST_2_REQUEST_3.get(), OCCULTIST_2_REQUEST_3.getDefault())) {
            return OCCULTIST_2_REQUEST_3.getDefault();
        }
        else {
            return OCCULTIST_2_REQUEST_3.get();
        }
    }
    public static int getOccultist2Offer2Count() {
        if (Objects.equals(OCCULTIST_2_OFFER_2_COUNT.get(), OCCULTIST_2_OFFER_2_COUNT.getDefault())) {
            return OCCULTIST_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_2_COUNT.get();
        }
    }
    public static String getOccultist2Offer2() {
        if (Objects.equals(OCCULTIST_2_OFFER_2.get(), OCCULTIST_2_OFFER_2.getDefault())) {
            return OCCULTIST_2_OFFER_2.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_2.get();
        }
    }
    public static String getOccultist2Request2() {
        if (Objects.equals(OCCULTIST_2_REQUEST_2.get(), OCCULTIST_2_REQUEST_2.getDefault())) {
            return OCCULTIST_2_REQUEST_2.getDefault();
        }
        else {
            return OCCULTIST_2_REQUEST_2.get();
        }
    }
    public static String getOccultist2Offer1() {
        if (Objects.equals(OCCULTIST_2_OFFER_1.get(), OCCULTIST_2_OFFER_1.getDefault())) {
            return OCCULTIST_2_OFFER_1.getDefault();
        }
        else {
            return OCCULTIST_2_OFFER_1.get();
        }
    }
    public static String getOccultist2Request1() {
        if (Objects.equals(OCCULTIST_2_REQUEST_1.get(), OCCULTIST_2_REQUEST_1.getDefault())) {
            return OCCULTIST_2_REQUEST_1.getDefault();
        }
        else {
            return OCCULTIST_2_REQUEST_1.get();
        }
    }
    public static String getOccultist1Offer8() {
        if (Objects.equals(OCCULTIST_1_OFFER_8.get(), OCCULTIST_1_OFFER_8.getDefault())) {
            return OCCULTIST_1_OFFER_8.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_8.get();
        }
    }
    public static String getOccultist1Request8() {
        if (Objects.equals(OCCULTIST_1_REQUEST_8.get(), OCCULTIST_1_REQUEST_8.getDefault())) {
            return OCCULTIST_1_REQUEST_8.getDefault();
        }
        else {
            return OCCULTIST_1_REQUEST_8.get();
        }
    }
    public static String getOccultist1Offer7() {
        if (Objects.equals(OCCULTIST_1_OFFER_7.get(), OCCULTIST_1_OFFER_7.getDefault())) {
            return OCCULTIST_1_OFFER_7.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_7.get();
        }
    }
    public static String getOccultist1Request7() {
        if (Objects.equals(OCCULTIST_1_REQUEST_7.get(), OCCULTIST_1_REQUEST_7.getDefault())) {
            return OCCULTIST_1_REQUEST_7.getDefault();
        }
        else {
            return OCCULTIST_1_REQUEST_7.get();
        }
    }
    public static String getOccultist1Offer6() {
        if (Objects.equals(OCCULTIST_1_OFFER_6.get(), OCCULTIST_1_OFFER_6.getDefault())) {
            return OCCULTIST_1_OFFER_6.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_6.get();
        }
    }
    public static String getOccultist1Request6() {
        if (Objects.equals(OCCULTIST_1_REQUEST_6.get(), OCCULTIST_1_REQUEST_6.getDefault())) {
            return OCCULTIST_1_REQUEST_6.getDefault();
        }
        else {
            return OCCULTIST_1_REQUEST_6.get();
        }
    }
    public static String getOccultist1Offer5() {
        if (Objects.equals(OCCULTIST_1_OFFER_5.get(), OCCULTIST_1_OFFER_5.getDefault())) {
            return OCCULTIST_1_OFFER_5.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_5.get();
        }
    }
    public static String getOccultist1Request5() {
        if (Objects.equals(OCCULTIST_1_REQUEST_5.get(), OCCULTIST_1_REQUEST_5.getDefault())) {
            return OCCULTIST_1_REQUEST_5.getDefault();
        }
        else {
            return OCCULTIST_1_REQUEST_5.get();
        }
    }
    public static String getOccultist1Offer4() {
        if (Objects.equals(OCCULTIST_1_OFFER_4.get(), OCCULTIST_1_OFFER_4.getDefault())) {
            return OCCULTIST_1_OFFER_4.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_4.get();
        }
    }
    public static String getOccultist1Request4() {
        if (Objects.equals(OCCULTIST_1_REQUEST_4.get(), OCCULTIST_1_REQUEST_4.getDefault())) {
            return OCCULTIST_1_REQUEST_4.getDefault();
        }
        else {
            return OCCULTIST_1_REQUEST_4.get();
        }
    }
    public static int getOccultist1Offer3Count() {
        if (Objects.equals(OCCULTIST_1_OFFER_3_COUNT.get(), OCCULTIST_1_OFFER_3_COUNT.getDefault())) {
            return OCCULTIST_1_OFFER_3_COUNT.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_3_COUNT.get();
        }
    }
    public static String getOccultist1Offer3() {
        if (Objects.equals(OCCULTIST_1_OFFER_3.get(), OCCULTIST_1_OFFER_3.getDefault())) {
            return OCCULTIST_1_OFFER_3.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_3.get();
        }
    }
    public static String getOccultist1Request3() {
        if (Objects.equals(OCCULTIST_1_REQUEST_3.get(), OCCULTIST_1_REQUEST_3.getDefault())) {
            return OCCULTIST_1_REQUEST_3.getDefault();
        }
        else {
            return OCCULTIST_1_REQUEST_3.get();
        }
    }
    public static int getOccultist1Offer2Count() {
        if (Objects.equals(OCCULTIST_1_OFFER_2_COUNT.get(), OCCULTIST_1_OFFER_2_COUNT.getDefault())) {
            return OCCULTIST_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_2_COUNT.get();
        }
    }
    public static String getOccultist1Offer2() {
        if (Objects.equals(OCCULTIST_1_OFFER_2.get(), OCCULTIST_1_OFFER_2.getDefault())) {
            return OCCULTIST_1_OFFER_2.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_2.get();
        }
    }
    public static String getOccultist1Request2() {
        if (Objects.equals(OCCULTIST_1_REQUEST_2.get(), OCCULTIST_1_REQUEST_2.getDefault())) {
            return OCCULTIST_1_REQUEST_2.getDefault();
        }
        else {
            return OCCULTIST_1_REQUEST_2.get();
        }
    }
    public static String getOccultist1Offer1() {
        if (Objects.equals(OCCULTIST_1_OFFER_1.get(), OCCULTIST_1_OFFER_1.getDefault())) {
            return OCCULTIST_1_OFFER_1.getDefault();
        }
        else {
            return OCCULTIST_1_OFFER_1.get();
        }
    }
    public static String getOccultist1Request1() {
        if (Objects.equals(OCCULTIST_1_REQUEST_1.get(), OCCULTIST_1_REQUEST_1.getDefault())) {
            return OCCULTIST_1_REQUEST_1.getDefault();
        }
        else {
            return OCCULTIST_1_REQUEST_1.get();
        }
    }
}