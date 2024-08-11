package com.github.warrentode.todecoins.config.trades.minecraft;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WanderingTraderTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Wandering Trader Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_3;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_4;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_6;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_6_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_7;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_7_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_9;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_9;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_10;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_10;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_10_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_OFFER_4;

    static {
        // WANDERING TRADER TRADES
        BUILDER.push("Wandering Trader Trade Settings");
        BUILDER.push("Wandering Trader Common Trade One");
        WANDERING_REQUEST_1 = BUILDER
                .comment(" Wandering Trader Request 1 Table")
                .define("wandering_trader_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_1 = BUILDER
                .comment(" Wandering Trader Offer 1 Table")
                .define("wandering_trader_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Two");
        WANDERING_REQUEST_2 = BUILDER
                .comment(" Wandering Trader Request 2 Table")
                .define("wandering_trader_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_2 = BUILDER
                .comment(" Wandering Trader Offer 2 Table")
                .define("wandering_trader_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Three");
        WANDERING_REQUEST_3 = BUILDER
                .comment(" Wandering Trader Request 3 Table")
                .define("wandering_trader_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_3 = BUILDER
                .comment(" Wandering Trader Offer 3 Tag Table")
                .define("wandering_trader_offer_3_tag_table",
                        TradeLootTables.SEED_TAG_TABLE.toString());
        WANDERING_OFFER_3_COUNT = BUILDER
                .comment(" Wandering Trader Offer 3 Count Override")
                .defineInRange("wandering_trader_offer_3_table_override", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Four");
        WANDERING_REQUEST_4 = BUILDER
                .comment(" Wandering Trader Request 4 Table")
                .define("wandering_trader_request_4_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_4 = BUILDER
                .comment(" Wandering Trader Offer 4 Tag Table")
                .define("wandering_trader_offer_4_tag_table",
                        TradeLootTables.SLIMEBALL_TAG_TABLE.toString());
        WANDERING_OFFER_4_COUNT = BUILDER
                .comment(" Wandering Trader Offer 4 Count Override")
                .defineInRange("wandering_trader_offer_4_table_override", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Five");
        WANDERING_REQUEST_5 = BUILDER
                .comment(" Wandering Trader Request 5 Table")
                .define("wandering_trader_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_5 = BUILDER
                .comment(" Wandering Trader Offer 5 Tag Table")
                .define("wandering_trader_offer_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Six");
        WANDERING_REQUEST_6 = BUILDER
                .comment(" Wandering Trader Request 6 Table")
                .define("wandering_trader_request_6_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_6 = BUILDER
                .comment(" Wandering Trader Offer 6 Tag Table")
                .define("wandering_trader_offer_6_tag_table",
                        TradeLootTables.SAND_TAG_TABLE.toString());
        WANDERING_OFFER_6_COUNT = BUILDER
                .comment(" Wandering Trader Offer 6 Count Override")
                .defineInRange("wandering_trader_offer_6_table_override", 6, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Seven");
        WANDERING_REQUEST_7 = BUILDER
                .comment(" Wandering Trader Offer 7 Table")
                .define("wandering_trader_request_7_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_7 = BUILDER
                .comment(" Wandering Trader Request 7 Tag Table")
                .define("wandering_trader_offer_7_tag_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        WANDERING_OFFER_7_COUNT = BUILDER
                .comment(" Wandering Trader Offer 7 Count Override")
                .defineInRange("wandering_trader_offer_7_table_override", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Eight");
        WANDERING_REQUEST_8 = BUILDER
                .comment(" Wandering Trader Request 8 Table")
                .define("wandering_trader_request_8_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_8 = BUILDER
                .comment(" Wandering Trader Offer 8 Table")
                .define("wandering_trader_offer_8_table",
                        TradeLootTables.SEASHELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Nine");
        WANDERING_REQUEST_9 = BUILDER
                .comment(" Wandering Trader Request 9 Table")
                .define("wandering_trader_request_9_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_9 = BUILDER
                .comment(" Wandering Trader Offer 9 Table")
                .define("wandering_trader_offer_9_table",
                        TradeLootTables.WANDERING_TRADER_COMMON_OFFERS.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Ten");
        WANDERING_REQUEST_10 = BUILDER
                .comment(" Wandering Trader Request 10 Table")
                .define("wandering_trader_request_10_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_10 = BUILDER
                .comment(" Wandering Trader Offer 10 Tag Table")
                .define("wandering_trader_offer_10_tag_table",
                        TradeLootTables.CORAL_BLOCK_TAG_TABLE.toString());
        WANDERING_OFFER_10_COUNT = BUILDER
                .comment(" Wandering Trader Offer 10 Count Override")
                .defineInRange("wandering_trader_offer_10_table_override", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Rare Trade One");
        WANDERING_RARE_REQUEST_1 = BUILDER
                .comment(" Wandering Trader Rare Request 1 Table")
                .define("wandering_trader_rare_request_1_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_RARE_OFFER_1 = BUILDER
                .comment(" Wandering Trader Rare Offer 1 Table")
                .define("wandering_trader_rare_offer_1_table",
                        TradeLootTables.FISH_BUCKET_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Rare Trade Two");
        WANDERING_RARE_REQUEST_2 = BUILDER
                .comment(" Wandering Trader Rare Request 2 Table")
                .define("wandering_trader_rare_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_RARE_OFFER_2 = BUILDER
                .comment(" Wandering Trader Rare Offer 2 Table")
                .define("wandering_trader_rare_offer_2_table",
                        TradeLootTables.ICE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Rare Trade Three");
        WANDERING_RARE_REQUEST_3 = BUILDER
                .comment(" Wandering Trader Rare Request 3 Table")
                .define("wandering_trader_rare_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_RARE_OFFER_3 = BUILDER
                .comment(" Wandering Trader Rare Offer 3 Table")
                .define("wandering_trader_rare_offer_3_table",
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Rare Trade Four");
        WANDERING_RARE_REQUEST_4 = BUILDER
                .comment(" Wandering Trader Rare Request 4 Table")
                .define("wandering_trader_rare_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_RARE_OFFER_4 = BUILDER
                .comment(" Wandering Trader Rare Offer 4 Table")
                .define("wandering_trader_rare_offer_4_table",
                        TradeLootTables.WANDERING_TRADER_RARE_OFFERS.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // WANDERING TRADER TRADE GETTERS
    public static String getWanderingRareOffer4() {
        if (Objects.equals(WANDERING_RARE_OFFER_4.get(), WANDERING_RARE_OFFER_4.getDefault())) {
            return WANDERING_RARE_OFFER_4.getDefault();
        }
        else {
            return WANDERING_RARE_OFFER_4.get();
        }
    }
    public static String getWanderingRareRequest4() {
        if (Objects.equals(WANDERING_RARE_REQUEST_4.get(), WANDERING_RARE_REQUEST_4.getDefault())) {
            return WANDERING_RARE_REQUEST_4.getDefault();
        }
        else {
            return WANDERING_RARE_REQUEST_4.get();
        }
    }
    public static String getWanderingRareOffer3() {
        if (Objects.equals(WANDERING_RARE_OFFER_3.get(), WANDERING_RARE_OFFER_3.getDefault())) {
            return WANDERING_RARE_OFFER_3.getDefault();
        }
        else {
            return WANDERING_RARE_OFFER_3.get();
        }
    }
    public static String getWanderingRareRequest3() {
        if (Objects.equals(WANDERING_RARE_REQUEST_3.get(), WANDERING_RARE_REQUEST_3.getDefault())) {
            return WANDERING_RARE_REQUEST_3.getDefault();
        }
        else {
            return WANDERING_RARE_REQUEST_3.get();
        }
    }
    public static String getWanderingRareOffer2() {
        if (Objects.equals(WANDERING_RARE_OFFER_2.get(), WANDERING_RARE_OFFER_2.getDefault())) {
            return WANDERING_RARE_OFFER_2.getDefault();
        }
        else {
            return WANDERING_RARE_OFFER_2.get();
        }
    }
    public static String getWanderingRareRequest2() {
        if (Objects.equals(WANDERING_RARE_REQUEST_2.get(), WANDERING_RARE_REQUEST_2.getDefault())) {
            return WANDERING_RARE_REQUEST_2.getDefault();
        }
        else {
            return WANDERING_RARE_REQUEST_2.get();
        }
    }
    public static String getWanderingRareOffer1() {
        if (Objects.equals(WANDERING_RARE_OFFER_1.get(), WANDERING_RARE_OFFER_1.getDefault())) {
            return WANDERING_RARE_OFFER_1.getDefault();
        }
        else {
            return WANDERING_RARE_OFFER_1.get();
        }
    }
    public static String getWanderingRareRequest1() {
        if (Objects.equals(WANDERING_RARE_REQUEST_1.get(), WANDERING_RARE_REQUEST_1.getDefault())) {
            return WANDERING_RARE_REQUEST_1.getDefault();
        }
        else {
            return WANDERING_RARE_REQUEST_1.get();
        }
    }
    public static int getWanderingOffer10Count() {
        if (Objects.equals(WANDERING_OFFER_10_COUNT.get(), WANDERING_OFFER_10_COUNT.getDefault())) {
            return WANDERING_OFFER_10_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_10_COUNT.get();
        }
    }
    public static String getWanderingOffer10() {
        if (Objects.equals(WANDERING_OFFER_10.get(), WANDERING_OFFER_10.getDefault())) {
            return WANDERING_OFFER_10.getDefault();
        }
        else {
            return WANDERING_OFFER_10.get();
        }
    }
    public static String getWanderingRequest10() {
        if (Objects.equals(WANDERING_REQUEST_10.get(), WANDERING_REQUEST_10.getDefault())) {
            return WANDERING_REQUEST_10.getDefault();
        }
        else {
            return WANDERING_REQUEST_10.get();
        }
    }
    public static String getWanderingOffer9() {
        if (Objects.equals(WANDERING_OFFER_9.get(), WANDERING_OFFER_9.getDefault())) {
            return WANDERING_OFFER_9.getDefault();
        }
        else {
            return WANDERING_OFFER_9.get();
        }
    }
    public static String getWanderingRequest9() {
        if (Objects.equals(WANDERING_REQUEST_9.get(), WANDERING_REQUEST_9.getDefault())) {
            return WANDERING_REQUEST_9.getDefault();
        }
        else {
            return WANDERING_REQUEST_9.get();
        }
    }
    public static String getWanderingOffer8() {
        if (Objects.equals(WANDERING_OFFER_8.get(), WANDERING_OFFER_8.getDefault())) {
            return WANDERING_OFFER_8.getDefault();
        }
        else {
            return WANDERING_OFFER_8.get();
        }
    }
    public static String getWanderingRequest8() {
        if (Objects.equals(WANDERING_REQUEST_8.get(), WANDERING_REQUEST_8.getDefault())) {
            return WANDERING_REQUEST_8.getDefault();
        }
        else {
            return WANDERING_REQUEST_8.get();
        }
    }
    public static int getWanderingOffer7Count() {
        if (Objects.equals(WANDERING_OFFER_7_COUNT.get(), WANDERING_OFFER_7_COUNT.getDefault())) {
            return WANDERING_OFFER_7_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_7_COUNT.get();
        }
    }
    public static String getWanderingOffer7() {
        if (Objects.equals(WANDERING_OFFER_7.get(), WANDERING_OFFER_7.getDefault())) {
            return WANDERING_OFFER_7.getDefault();
        }
        else {
            return WANDERING_OFFER_7.get();
        }
    }
    public static String getWanderingRequest7() {
        if (Objects.equals(WANDERING_REQUEST_7.get(), WANDERING_REQUEST_7.getDefault())) {
            return WANDERING_REQUEST_7.getDefault();
        }
        else {
            return WANDERING_REQUEST_7.get();
        }
    }
    public static int getWanderingOffer6Count() {
        if (Objects.equals(WANDERING_OFFER_6_COUNT.get(), WANDERING_OFFER_6_COUNT.getDefault())) {
            return WANDERING_OFFER_6_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_6_COUNT.get();
        }
    }
    public static String getWanderingOffer6() {
        if (Objects.equals(WANDERING_OFFER_6.get(), WANDERING_OFFER_6.getDefault())) {
            return WANDERING_OFFER_6.getDefault();
        }
        else {
            return WANDERING_OFFER_6.get();
        }
    }
    public static String getWanderingRequest6() {
        if (Objects.equals(WANDERING_REQUEST_6.get(), WANDERING_REQUEST_6.getDefault())) {
            return WANDERING_REQUEST_6.getDefault();
        }
        else {
            return WANDERING_REQUEST_6.get();
        }
    }
    public static String getWanderingOffer5() {
        if (Objects.equals(WANDERING_OFFER_5.get(), WANDERING_OFFER_5.getDefault())) {
            return WANDERING_OFFER_5.getDefault();
        }
        else {
            return WANDERING_OFFER_5.get();
        }
    }
    public static String getWanderingRequest5() {
        if (Objects.equals(WANDERING_REQUEST_5.get(), WANDERING_REQUEST_5.getDefault())) {
            return WANDERING_REQUEST_5.getDefault();
        }
        else {
            return WANDERING_REQUEST_5.get();
        }
    }
    public static int getWanderingOffer4Count() {
        if (Objects.equals(WANDERING_OFFER_4_COUNT.get(), WANDERING_OFFER_4_COUNT.getDefault())) {
            return WANDERING_OFFER_4_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_4_COUNT.get();
        }
    }
    public static String getWanderingOffer4() {
        if (Objects.equals(WANDERING_OFFER_4.get(), WANDERING_OFFER_4.getDefault())) {
            return WANDERING_OFFER_4.getDefault();
        }
        else {
            return WANDERING_OFFER_4.get();
        }
    }
    public static String getWanderingRequest4() {
        if (Objects.equals(WANDERING_REQUEST_4.get(), WANDERING_REQUEST_4.getDefault())) {
            return WANDERING_REQUEST_4.getDefault();
        }
        else {
            return WANDERING_REQUEST_4.get();
        }
    }
    public static int getWanderingOffer3Count() {
        if (Objects.equals(WANDERING_OFFER_3_COUNT.get(), WANDERING_OFFER_3_COUNT.getDefault())) {
            return WANDERING_OFFER_3_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_3_COUNT.get();
        }
    }
    public static String getWanderingOffer3() {
        if (Objects.equals(WANDERING_OFFER_3.get(), WANDERING_OFFER_3.getDefault())) {
            return WANDERING_OFFER_3.getDefault();
        }
        else {
            return WANDERING_OFFER_3.get();
        }
    }
    public static String getWanderingRequest3() {
        if (Objects.equals(WANDERING_REQUEST_3.get(), WANDERING_REQUEST_3.getDefault())) {
            return WANDERING_REQUEST_3.getDefault();
        }
        else {
            return WANDERING_REQUEST_3.get();
        }
    }
    public static String getWanderingOffer2() {
        if (Objects.equals(WANDERING_OFFER_2.get(), WANDERING_OFFER_2.getDefault())) {
            return WANDERING_OFFER_2.getDefault();
        }
        else {
            return WANDERING_OFFER_2.get();
        }
    }
    public static String getWanderingRequest2() {
        if (Objects.equals(WANDERING_REQUEST_2.get(), WANDERING_REQUEST_2.getDefault())) {
            return WANDERING_REQUEST_2.getDefault();
        }
        else {
            return WANDERING_REQUEST_2.get();
        }
    }
    public static String getWanderingOffer1() {
        if (Objects.equals(WANDERING_OFFER_1.get(), WANDERING_OFFER_1.getDefault())) {
            return WANDERING_OFFER_1.getDefault();
        }
        else {
            return WANDERING_OFFER_1.get();
        }
    }
    public static String getWanderingRequest1() {
        if (Objects.equals(WANDERING_REQUEST_1.get(), WANDERING_REQUEST_1.getDefault())) {
            return WANDERING_REQUEST_1.getDefault();
        }
        else {
            return WANDERING_REQUEST_1.get();
        }
    }
}