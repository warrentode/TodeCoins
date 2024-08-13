package com.github.warrentode.todecoins.config.trades.morevillagers;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MinerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Miner Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> MINER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MINER_5_OFFER_2;

    static {
        // MINER TRADES
        BUILDER.push(" Miner Trade Settings");
        // level 1
        BUILDER.push(" Miner Level One Trade One");
        MINER_1_REQUEST_1 = BUILDER
                .comment(" Miner 1 Trade Request 1 Table")
                .define("miner_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MINER_1_OFFER_1 = BUILDER
                .comment(" Miner 1 Trade Offer 1 Table")
                .define("miner_1_trade_offer_1_table",
                        TradeLootTables.TORCH_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Miner Level One Trade Two");
        MINER_1_REQUEST_2 = BUILDER
                .comment(" Miner 1 Trade Request 2 Table")
                .define("miner_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MINER_1_OFFER_2 = BUILDER
                .comment(" Miner 1 Trade Offer 2 Table")
                .define("miner_1_trade_offer_2_table",
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push(" Miner Level Two Trade One");
        MINER_2_REQUEST_1 = BUILDER
                .comment(" Miner 2 Trade Request 1 Table")
                .define("miner_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MINER_2_OFFER_1 = BUILDER
                .comment(" Miner 2 Trade Offer 1 Table")
                .define("miner_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        BUILDER.pop();
        BUILDER.push(" Miner Level Two Trade Two");
        MINER_2_REQUEST_2 = BUILDER
                .comment(" Miner 2 Trade Request 2 Table")
                .define("miner_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MINER_2_OFFER_2 = BUILDER
                .comment(" Miner 2 Trade Offer 2 Table")
                .define("miner_2_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push(" Miner Level Three Trade One");
        MINER_3_REQUEST_1 = BUILDER
                .comment(" Miner 3 Trade Request 1 Table")
                .define("miner_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MINER_3_OFFER_1 = BUILDER
                .comment(" Miner 3 Trade Offer 1 Table")
                .define("miner_3_trade_offer_1_table",
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Miner Level Three Trade Two");
        MINER_3_REQUEST_2 = BUILDER
                .comment(" Miner 3 Trade Request 2 Table")
                .define("miner_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MINER_3_OFFER_2 = BUILDER
                .comment(" Miner 3 Trade Offer 2 Table")
                .define("miner_3_trade_offer_2_table",
                        TradeLootTables.LANTERN_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push(" Miner Level Four Trade One");
        MINER_4_REQUEST_1 = BUILDER
                .comment(" Miner 4 Trade Request 1 Table")
                .define("miner_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MINER_4_OFFER_1 = BUILDER
                .comment(" Miner 4 Trade Offer 1 Table")
                .define("miner_4_trade_offer_1_table",
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Miner Level Four Trade Two");
        MINER_4_REQUEST_2 = BUILDER
                .comment(" Miner 4 Trade Request 2 Table")
                .define("miner_4_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        MINER_4_OFFER_2 = BUILDER
                .comment(" Miner 4 Trade Offer 2 Table")
                .define("miner_4_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push(" Miner Level Five Trade One")
                .comment(" Enchanted Item Trade")
                .comment(" Rare Trade");
        MINER_5_REQUEST_1 = BUILDER
                .comment(" Miner 5 Trade Request 1 Table")
                .define("miner_5_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        MINER_5_OFFER_1 = BUILDER
                .comment(" Miner 5 Trade Offer 1 Table")
                .define("miner_5_trade_offer_1_table",
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push(" Miner Level Five Trade Two");
        MINER_5_REQUEST_2 = BUILDER
                .comment(" Miner 5 Trade Request 2 Table")
                .define("miner_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MINER_5_OFFER_2 = BUILDER
                .comment(" Miner 5 Trade Offer 2 Table")
                .define("miner_5_trade_offer_2_table",
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // MINER TRADE GETTERS
    public static String getMiner5Offer2() {
        if (Objects.equals(MINER_5_OFFER_2.get(), MINER_5_OFFER_2.getDefault())) {
            return MINER_5_OFFER_2.getDefault();
        }
        else {
            return MINER_5_OFFER_2.get();
        }
    }
    public static String getMiner5Request2() {
        if (Objects.equals(MINER_5_REQUEST_2.get(), MINER_5_REQUEST_2.getDefault())) {
            return MINER_5_REQUEST_2.getDefault();
        }
        else {
            return MINER_5_REQUEST_2.get();
        }
    }
    public static String getMiner5Offer1() {
        if (Objects.equals(MINER_5_OFFER_1.get(), MINER_5_OFFER_1.getDefault())) {
            return MINER_5_OFFER_1.getDefault();
        }
        else {
            return MINER_5_OFFER_1.get();
        }
    }
    public static String getMiner5Request1() {
        if (Objects.equals(MINER_5_REQUEST_1.get(), MINER_5_REQUEST_1.getDefault())) {
            return MINER_5_REQUEST_1.getDefault();
        }
        else {
            return MINER_5_REQUEST_1.get();
        }
    }
    public static String getMiner4Offer2() {
        if (Objects.equals(MINER_4_OFFER_2.get(), MINER_4_OFFER_2.getDefault())) {
            return MINER_4_OFFER_2.getDefault();
        }
        else {
            return MINER_4_OFFER_2.get();
        }
    }
    public static String getMiner4Request2() {
        if (Objects.equals(MINER_4_REQUEST_2.get(), MINER_4_REQUEST_2.getDefault())) {
            return MINER_4_REQUEST_2.getDefault();
        }
        else {
            return MINER_4_REQUEST_2.get();
        }
    }
    public static String getMiner4Offer1() {
        if (Objects.equals(MINER_4_OFFER_1.get(), MINER_4_OFFER_1.getDefault())) {
            return MINER_4_OFFER_1.getDefault();
        }
        else {
            return MINER_4_OFFER_1.get();
        }
    }
    public static String getMiner4Request1() {
        if (Objects.equals(MINER_4_REQUEST_1.get(), MINER_4_REQUEST_1.getDefault())) {
            return MINER_4_REQUEST_1.getDefault();
        }
        else {
            return MINER_4_REQUEST_1.get();
        }
    }
    public static String getMiner3Offer2() {
        if (Objects.equals(MINER_3_OFFER_2.get(), MINER_3_OFFER_2.getDefault())) {
            return MINER_3_OFFER_2.getDefault();
        }
        else {
            return MINER_3_OFFER_2.get();
        }
    }
    public static String getMiner3Request2() {
        if (Objects.equals(MINER_3_REQUEST_2.get(), MINER_3_REQUEST_2.getDefault())) {
            return MINER_3_REQUEST_2.getDefault();
        }
        else {
            return MINER_3_REQUEST_2.get();
        }
    }
    public static String getMiner3Offer1() {
        if (Objects.equals(MINER_3_OFFER_1.get(), MINER_3_OFFER_1.getDefault())) {
            return MINER_3_OFFER_1.getDefault();
        }
        else {
            return MINER_3_OFFER_1.get();
        }
    }
    public static String getMiner3Request1() {
        if (Objects.equals(MINER_3_REQUEST_1.get(), MINER_3_REQUEST_1.getDefault())) {
            return MINER_3_REQUEST_1.getDefault();
        }
        else {
            return MINER_3_REQUEST_1.get();
        }
    }
    public static String getMiner2Offer2() {
        if (Objects.equals(MINER_2_OFFER_2.get(), MINER_2_OFFER_2.getDefault())) {
            return MINER_2_OFFER_2.getDefault();
        }
        else {
            return MINER_2_OFFER_2.get();
        }
    }
    public static String getMiner2Request2() {
        if (Objects.equals(MINER_2_REQUEST_2.get(), MINER_2_REQUEST_2.getDefault())) {
            return MINER_2_REQUEST_2.getDefault();
        }
        else {
            return MINER_2_REQUEST_2.get();
        }
    }
    public static String getMiner2Offer1() {
        if (Objects.equals(MINER_2_OFFER_1.get(), MINER_2_OFFER_1.getDefault())) {
            return MINER_2_OFFER_1.getDefault();
        }
        else {
            return MINER_2_OFFER_1.get();
        }
    }
    public static String getMiner2Request1() {
        if (Objects.equals(MINER_2_REQUEST_1.get(), MINER_2_REQUEST_1.getDefault())) {
            return MINER_2_REQUEST_1.getDefault();
        }
        else {
            return MINER_2_REQUEST_1.get();
        }
    }
    public static String getMiner1Offer2() {
        if (Objects.equals(MINER_1_OFFER_2.get(), MINER_1_OFFER_2.getDefault())) {
            return MINER_1_OFFER_2.getDefault();
        }
        else {
            return MINER_1_OFFER_2.get();
        }
    }
    public static String getMiner1Request2() {
        if (Objects.equals(MINER_1_REQUEST_2.get(), MINER_1_REQUEST_2.getDefault())) {
            return MINER_1_REQUEST_2.getDefault();
        }
        else {
            return MINER_1_REQUEST_2.get();
        }
    }
    public static String getMiner1Offer1() {
        if (Objects.equals(MINER_1_OFFER_1.get(), MINER_1_OFFER_1.getDefault())) {
            return MINER_1_OFFER_1.getDefault();
        }
        else {
            return MINER_1_OFFER_1.get();
        }
    }
    public static String getMiner1Request1() {
        if (Objects.equals(MINER_1_REQUEST_1.get(), MINER_1_REQUEST_1.getDefault())) {
            return MINER_1_REQUEST_1.getDefault();
        }
        else {
            return MINER_1_REQUEST_1.get();
        }
    }
}