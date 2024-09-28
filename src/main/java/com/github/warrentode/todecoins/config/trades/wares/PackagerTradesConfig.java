package com.github.warrentode.todecoins.config.trades.wares;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PackagerTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Packager Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_1_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_ID;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_TITLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_PRICE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_OFFER_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_BUYER_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_BUYER_ADDRESS;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_BUYER_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_SEAL;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_1_OFFER_2_AGREEMENT_SEAL_TOOLTIP;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_1_OFFER_2_AGREEMENT_ORDER_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_1_OFFER_2_AGREEMENT_ORDER_XP;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_2_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_ID;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_TITLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_PRICE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_OFFER_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_BUYER_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_BUYER_ADDRESS;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_BUYER_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_SEAL;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_2_OFFER_2_AGREEMENT_SEAL_TOOLTIP;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_2_OFFER_2_AGREEMENT_ORDER_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_2_OFFER_2_AGREEMENT_ORDER_XP;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_ID;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_TITLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_PRICE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_OFFER_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_BUYER_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_BUYER_ADDRESS;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_BUYER_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_SEAL;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_3_OFFER_2_AGREEMENT_SEAL_TOOLTIP;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_3_OFFER_2_AGREEMENT_ORDER_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_3_OFFER_2_AGREEMENT_ORDER_XP;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_ID;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_TITLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_PRICE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_OFFER_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_BUYER_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_BUYER_ADDRESS;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_BUYER_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_SEAL;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_4_OFFER_2_AGREEMENT_SEAL_TOOLTIP;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_4_OFFER_2_AGREEMENT_ORDER_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_4_OFFER_2_AGREEMENT_ORDER_XP;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_ID;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_TITLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_PRICE_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_OFFER_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_BUYER_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_BUYER_ADDRESS;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_BUYER_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_SEAL;
    public static final ForgeConfigSpec.ConfigValue<String> PACKAGER_5_OFFER_2_AGREEMENT_SEAL_TOOLTIP;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_5_OFFER_2_AGREEMENT_ORDER_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACKAGER_5_OFFER_2_AGREEMENT_ORDER_XP;

    static {
        // PACKAGER TRADES
        BUILDER.push("Packager Trade Settings");
        // level 1
        BUILDER.push("Packager Level One Trade One");
        PACKAGER_1_REQUEST_1 = BUILDER
                .comment(" Packager 1 Trade Request 1 Table")
                .define("packager_1_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_1_OFFER_1 = BUILDER
                .comment(" Packager 1 Trade Offer 1 Table")
                .define("packager_1_trade_offer_1_table",
                        TradeLootTables.PACKAGE_TAG_TABLE.toString());
        PACKAGER_1_OFFER_1_COUNT = BUILDER
                .comment(" Packager 1 Trade Offer 1 Table")
                .defineInRange("packager_1_trade_offer_1_count", 8, 1, 64);
        BUILDER.pop();
        BUILDER.push("Packager Level One Trade Two");
        PACKAGER_1_REQUEST_2 = BUILDER
                .comment(" Packager 1 Trade Request 2 Table")
                .define("packager_1_trade_request_2_table",
                        TradeLootTables.SMALLEST_COIN.toString());
        PACKAGER_1_OFFER_2_AGREEMENT_ID = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement ID")
                .define("packager_1_offer_2_agreement_id", "packager_delivery_agreement_1");
        PACKAGER_1_OFFER_2_AGREEMENT_TITLE = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Tile")
                .define("packager_1_offer_2_agreement_title", "Delivery Order");
        PACKAGER_1_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Tile")
                .define("packager_1_offer_2_agreement_backside_message", "Deliveries Sent All Over Minecraft On Demand!");
        PACKAGER_1_OFFER_2_AGREEMENT_PRICE_TABLE = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Price Table")
                .define("packager_1_offer_2_agreement_price_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_1_OFFER_2_AGREEMENT_OFFER_TABLE = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Offer Table")
                .define("packager_1_offer_2_agreement_offer_table",
                        TradeLootTables.WANDERING_TRADER_COMMON_OFFERS.toString());
        PACKAGER_1_OFFER_2_AGREEMENT_BUYER_NAME = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Buyer Name")
                .define("packager_1_offer_2_agreement_buyer_name", "Packager");
        PACKAGER_1_OFFER_2_AGREEMENT_BUYER_ADDRESS = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Buyer Name")
                .define("packager_1_offer_2_agreement_buyer_name", "100 Tode Lane, Todeville Minecraft 00000");
        PACKAGER_1_OFFER_2_AGREEMENT_BUYER_MESSAGE = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Buyer Name")
                .define("packager_1_offer_2_agreement_buyer_name", "Willing to pay on delivery for these goods right away!");
        PACKAGER_1_OFFER_2_AGREEMENT_SEAL = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Seal")
                .define("packager_1_offer_2_agreement_seal", "default");
        PACKAGER_1_OFFER_2_AGREEMENT_SEAL_TOOLTIP = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Seal Tooltip")
                .define("packager_1_offer_2_agreement_seal_tooltip", "Wares R Us");
        PACKAGER_1_OFFER_2_AGREEMENT_ORDER_COUNT = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Order Count")
                .defineInRange("packager_1_offer_2_agreement_order_count", 12, 1, Integer.MAX_VALUE);
        PACKAGER_1_OFFER_2_AGREEMENT_ORDER_XP = BUILDER
                .comment(" Packager 1 Trade Offer 2 Agreement Order Experience")
                .defineInRange("packager_1_offer_2_agreement_order_experience", 5, 0, Integer.MAX_VALUE);
        BUILDER.pop();
        // level 2
        BUILDER.push("Packager Level Two Trade One");
        PACKAGER_2_REQUEST_1 = BUILDER
                .comment(" Packager 2 Trade Request 1 Table")
                .define("packager_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_2_OFFER_1 = BUILDER
                .comment(" Packager 2 Trade Offer 1 Table")
                .define("packager_2_trade_offer_1_table",
                        TradeLootTables.PACKAGE_TAG_TABLE.toString());
        PACKAGER_2_OFFER_1_COUNT = BUILDER
                .comment(" Packager 2 Trade Offer 1 Table")
                .defineInRange("packager_2_trade_offer_1_count", 8, 1, 64);
        BUILDER.pop();
        BUILDER.push("Packager Level Two Trade Two");
        PACKAGER_2_REQUEST_2 = BUILDER
                .comment(" Packager 2 Trade Request 2 Table")
                .define("packager_2_trade_request_2_table",
                        TradeLootTables.SMALLEST_COIN.toString());
        PACKAGER_2_OFFER_2_AGREEMENT_ID = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement ID")
                .define("packager_2_offer_2_agreement_id", "packager_delivery_agreement_1");
        PACKAGER_2_OFFER_2_AGREEMENT_TITLE = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Tile")
                .define("packager_2_offer_2_agreement_title", "Delivery Order");
        PACKAGER_2_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Tile")
                .define("packager_2_offer_2_agreement_backside_message", "Deliveries Sent All Over Minecraft On Demand!");
        PACKAGER_2_OFFER_2_AGREEMENT_PRICE_TABLE = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Price Table")
                .define("packager_2_offer_2_agreement_price_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_2_OFFER_2_AGREEMENT_OFFER_TABLE = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Offer Table")
                .define("packager_2_offer_2_agreement_offer_table",
                        TradeLootTables.WANDERING_TRADER_COMMON_OFFERS.toString());
        PACKAGER_2_OFFER_2_AGREEMENT_BUYER_NAME = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Buyer Name")
                .define("packager_2_offer_2_agreement_buyer_name", "Packager");
        PACKAGER_2_OFFER_2_AGREEMENT_BUYER_ADDRESS = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Buyer Name")
                .define("packager_2_offer_2_agreement_buyer_name", "100 Tode Lane, Todeville Minecraft 00000");
        PACKAGER_2_OFFER_2_AGREEMENT_BUYER_MESSAGE = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Buyer Name")
                .define("packager_2_offer_2_agreement_buyer_name", "Willing to pay on delivery for these goods right away!");
        PACKAGER_2_OFFER_2_AGREEMENT_SEAL = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Seal")
                .define("packager_2_offer_2_agreement_seal", "default");
        PACKAGER_2_OFFER_2_AGREEMENT_SEAL_TOOLTIP = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Seal Tooltip")
                .define("packager_2_offer_2_agreement_seal_tooltip", "Wares R Us");
        PACKAGER_2_OFFER_2_AGREEMENT_ORDER_COUNT = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Order Count")
                .defineInRange("packager_2_offer_2_agreement_order_count", 12, 1, Integer.MAX_VALUE);
        PACKAGER_2_OFFER_2_AGREEMENT_ORDER_XP = BUILDER
                .comment(" Packager 2 Trade Offer 2 Agreement Order Experience")
                .defineInRange("packager_2_offer_2_agreement_order_experience", 5, 0, Integer.MAX_VALUE);
        BUILDER.pop();
        // level 3
        BUILDER.push("Packager Level Three Trade One");
        PACKAGER_3_REQUEST_1 = BUILDER
                .comment(" Packager 3 Trade Request 1 Table")
                .define("packager_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_3_OFFER_1 = BUILDER
                .comment(" Packager 3 Trade Offer 1 Table")
                .define("packager_3_trade_offer_1_table",
                        TradeLootTables.PACKAGE_TAG_TABLE.toString());
        PACKAGER_3_OFFER_1_COUNT = BUILDER
                .comment(" Packager 3 Trade Offer 1 Table")
                .defineInRange("packager_3_trade_offer_1_count", 8, 1, 64);
        BUILDER.pop();
        BUILDER.push("Packager Level Three Trade Two");
        PACKAGER_3_REQUEST_2 = BUILDER
                .comment(" Packager 3 Trade Request 2 Table")
                .define("packager_3_trade_request_2_table",
                        TradeLootTables.SMALLEST_COIN.toString());
        PACKAGER_3_OFFER_2_AGREEMENT_ID = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement ID")
                .define("packager_3_offer_2_agreement_id", "packager_delivery_agreement_1");
        PACKAGER_3_OFFER_2_AGREEMENT_TITLE = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Tile")
                .define("packager_3_offer_2_agreement_title", "Delivery Order");
        PACKAGER_3_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Tile")
                .define("packager_3_offer_2_agreement_backside_message", "Deliveries Sent All Over Minecraft On Demand!");
        PACKAGER_3_OFFER_2_AGREEMENT_PRICE_TABLE = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Price Table")
                .define("packager_3_offer_2_agreement_price_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_3_OFFER_2_AGREEMENT_OFFER_TABLE = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Offer Table")
                .define("packager_3_offer_2_agreement_offer_table",
                        TradeLootTables.WANDERING_TRADER_COMMON_OFFERS.toString());
        PACKAGER_3_OFFER_2_AGREEMENT_BUYER_NAME = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Buyer Name")
                .define("packager_3_offer_2_agreement_buyer_name", "Packager");
        PACKAGER_3_OFFER_2_AGREEMENT_BUYER_ADDRESS = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Buyer Name")
                .define("packager_3_offer_2_agreement_buyer_name", "100 Tode Lane, Todeville Minecraft 00000");
        PACKAGER_3_OFFER_2_AGREEMENT_BUYER_MESSAGE = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Buyer Name")
                .define("packager_3_offer_2_agreement_buyer_name", "Willing to pay on delivery for these goods right away!");
        PACKAGER_3_OFFER_2_AGREEMENT_SEAL = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Seal")
                .define("packager_3_offer_2_agreement_seal", "default");
        PACKAGER_3_OFFER_2_AGREEMENT_SEAL_TOOLTIP = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Seal Tooltip")
                .define("packager_3_offer_2_agreement_seal_tooltip", "Wares R Us");
        PACKAGER_3_OFFER_2_AGREEMENT_ORDER_COUNT = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Order Count")
                .defineInRange("packager_3_offer_2_agreement_order_count", 12, 1, Integer.MAX_VALUE);
        PACKAGER_3_OFFER_2_AGREEMENT_ORDER_XP = BUILDER
                .comment(" Packager 3 Trade Offer 2 Agreement Order Experience")
                .defineInRange("packager_3_offer_2_agreement_order_experience", 5, 0, Integer.MAX_VALUE);
        BUILDER.pop();
        // level 4
        BUILDER.push("Packager Level Four Trade One");
        PACKAGER_4_REQUEST_1 = BUILDER
                .comment(" Packager 4 Trade Request 1 Table")
                .define("packager_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_4_OFFER_1 = BUILDER
                .comment(" Packager 4 Trade Offer 1 Table")
                .define("packager_4_trade_offer_1_table",
                        TradeLootTables.PACKAGE_TAG_TABLE.toString());
        PACKAGER_4_OFFER_1_COUNT = BUILDER
                .comment(" Packager 4 Trade Offer 1 Table")
                .defineInRange("packager_4_trade_offer_1_count", 8, 1, 64);
        BUILDER.pop();
        BUILDER.push("Packager Level Four Trade Two");
        PACKAGER_4_REQUEST_2 = BUILDER
                .comment(" Packager 4 Trade Request 2 Table")
                .define("packager_4_trade_request_2_table",
                        TradeLootTables.SMALLEST_COIN.toString());
        PACKAGER_4_OFFER_2_AGREEMENT_ID = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement ID")
                .define("packager_4_offer_2_agreement_id", "packager_delivery_agreement_1");
        PACKAGER_4_OFFER_2_AGREEMENT_TITLE = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Tile")
                .define("packager_4_offer_2_agreement_title", "Delivery Order");
        PACKAGER_4_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Tile")
                .define("packager_4_offer_2_agreement_backside_message", "Deliveries Sent All Over Minecraft On Demand!");
        PACKAGER_4_OFFER_2_AGREEMENT_PRICE_TABLE = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Price Table")
                .define("packager_4_offer_2_agreement_price_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_4_OFFER_2_AGREEMENT_OFFER_TABLE = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Offer Table")
                .define("packager_4_offer_2_agreement_offer_table",
                        TradeLootTables.WANDERING_TRADER_COMMON_OFFERS.toString());
        PACKAGER_4_OFFER_2_AGREEMENT_BUYER_NAME = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Buyer Name")
                .define("packager_4_offer_2_agreement_buyer_name", "Packager");
        PACKAGER_4_OFFER_2_AGREEMENT_BUYER_ADDRESS = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Buyer Name")
                .define("packager_4_offer_2_agreement_buyer_name", "100 Tode Lane, Todeville Minecraft 00000");
        PACKAGER_4_OFFER_2_AGREEMENT_BUYER_MESSAGE = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Buyer Name")
                .define("packager_4_offer_2_agreement_buyer_name", "Willing to pay on delivery for these goods right away!");
        PACKAGER_4_OFFER_2_AGREEMENT_SEAL = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Seal")
                .define("packager_4_offer_2_agreement_seal", "default");
        PACKAGER_4_OFFER_2_AGREEMENT_SEAL_TOOLTIP = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Seal Tooltip")
                .define("packager_4_offer_2_agreement_seal_tooltip", "Wares R Us");
        PACKAGER_4_OFFER_2_AGREEMENT_ORDER_COUNT = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Order Count")
                .defineInRange("packager_4_offer_2_agreement_order_count", 12, 1, Integer.MAX_VALUE);
        PACKAGER_4_OFFER_2_AGREEMENT_ORDER_XP = BUILDER
                .comment(" Packager 4 Trade Offer 2 Agreement Order Experience")
                .defineInRange("packager_4_offer_2_agreement_order_experience", 5, 0, Integer.MAX_VALUE);
        BUILDER.pop();
        // level 5
        BUILDER.push("Packager Level Five Trade One");
        PACKAGER_5_REQUEST_1 = BUILDER
                .comment(" Packager 5 Trade Request 1 Table")
                .define("packager_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_5_OFFER_1 = BUILDER
                .comment(" Packager 5 Trade Offer 1 Table")
                .define("packager_5_trade_offer_1_table",
                        TradeLootTables.PACKAGE_TAG_TABLE.toString());
        PACKAGER_5_OFFER_1_COUNT = BUILDER
                .comment(" Packager 5 Trade Offer 1 Table")
                .defineInRange("packager_5_trade_offer_1_count", 8, 1, 64);
        BUILDER.pop();
        BUILDER.push("Packager Level Five Trade Two");
        PACKAGER_5_REQUEST_2 = BUILDER
                .comment(" Packager 5 Trade Request 2 Table")
                .define("packager_5_trade_request_2_table",
                        TradeLootTables.SMALLEST_COIN.toString());
        PACKAGER_5_OFFER_2_AGREEMENT_ID = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement ID")
                .define("packager_5_offer_2_agreement_id", "packager_delivery_agreement_1");
        PACKAGER_5_OFFER_2_AGREEMENT_TITLE = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Tile")
                .define("packager_5_offer_2_agreement_title", "Delivery Order");
        PACKAGER_5_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Tile")
                .define("packager_5_offer_2_agreement_backside_message", "Deliveries Sent All Over Minecraft On Demand!");
        PACKAGER_5_OFFER_2_AGREEMENT_PRICE_TABLE = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Price Table")
                .define("packager_5_offer_2_agreement_price_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        PACKAGER_5_OFFER_2_AGREEMENT_OFFER_TABLE = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Offer Table")
                .define("packager_5_offer_2_agreement_offer_table",
                        TradeLootTables.WANDERING_TRADER_COMMON_OFFERS.toString());
        PACKAGER_5_OFFER_2_AGREEMENT_BUYER_NAME = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Buyer Name")
                .define("packager_5_offer_2_agreement_buyer_name", "Packager");
        PACKAGER_5_OFFER_2_AGREEMENT_BUYER_ADDRESS = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Buyer Name")
                .define("packager_5_offer_2_agreement_buyer_name", "100 Tode Lane, Todeville Minecraft 00000");
        PACKAGER_5_OFFER_2_AGREEMENT_BUYER_MESSAGE = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Buyer Name")
                .define("packager_5_offer_2_agreement_buyer_name", "Willing to pay on delivery for these goods right away!");
        PACKAGER_5_OFFER_2_AGREEMENT_SEAL = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Seal")
                .define("packager_5_offer_2_agreement_seal", "default");
        PACKAGER_5_OFFER_2_AGREEMENT_SEAL_TOOLTIP = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Seal Tooltip")
                .define("packager_5_offer_2_agreement_seal_tooltip", "Wares R Us");
        PACKAGER_5_OFFER_2_AGREEMENT_ORDER_COUNT = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Order Count")
                .defineInRange("packager_5_offer_2_agreement_order_count", 12, 1, Integer.MAX_VALUE);
        PACKAGER_5_OFFER_2_AGREEMENT_ORDER_XP = BUILDER
                .comment(" Packager 5 Trade Offer 2 Agreement Order Experience")
                .defineInRange("packager_5_offer_2_agreement_order_experience", 5, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // PACKAGER TRADE GETTERS
    public static int getPackager5Offer2AgreementOrderXP() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_ORDER_XP.get(), PACKAGER_5_OFFER_2_AGREEMENT_ORDER_XP.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_ORDER_XP.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_ORDER_XP.get();
        }
    }
    public static int getPackager5Offer2AgreementOrderCount() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_ORDER_COUNT.get(), PACKAGER_5_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_ORDER_COUNT.get();
        }
    }
    public static String getPackager5Offer2AgreementSealTooltip() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get(), PACKAGER_5_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get();
        }
    }
    public static String getPackager5Offer2AgreementSeal() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_SEAL.get(), PACKAGER_5_OFFER_2_AGREEMENT_SEAL.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_SEAL.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_SEAL.get();
        }
    }
    public static String getPackager5Offer2AgreementBuyerMessage() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_BUYER_MESSAGE.get(), PACKAGER_5_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_BUYER_MESSAGE.get();
        }
    }
    public static String getPackager5Offer2AgreementBuyerAddress() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_BUYER_ADDRESS.get(), PACKAGER_5_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_BUYER_ADDRESS.get();
        }
    }
    public static String getPackager5Offer2AgreementBuyerName() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_BUYER_NAME.get(), PACKAGER_5_OFFER_2_AGREEMENT_BUYER_NAME.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_BUYER_NAME.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_BUYER_NAME.get();
        }
    }
    public static String getPackager5Offer2AgreementOfferTable() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_OFFER_TABLE.get(), PACKAGER_5_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_OFFER_TABLE.get();
        }
    }
    public static String getPackager5Offer2AgreementPriceTable() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_PRICE_TABLE.get(), PACKAGER_5_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_PRICE_TABLE.get();
        }
    }
    public static String getPackager5Offer3AgreementBacksideMessage() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get(), PACKAGER_5_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get();
        }
    }
    public static String getPackager5Offer2AgreementTitle() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_TITLE.get(), PACKAGER_5_OFFER_2_AGREEMENT_TITLE.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_TITLE.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_TITLE.get();
        }
    }
    public static String getPackager5Offer2AgreementID() {
        if (Objects.equals(PACKAGER_5_OFFER_2_AGREEMENT_ID.get(), PACKAGER_5_OFFER_2_AGREEMENT_ID.getDefault())) {
            return PACKAGER_5_OFFER_2_AGREEMENT_ID.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_2_AGREEMENT_ID.get();
        }
    }
    public static String getPackager5Request2() {
        if (Objects.equals(PACKAGER_5_REQUEST_2.get(), PACKAGER_5_REQUEST_2.getDefault())) {
            return PACKAGER_5_REQUEST_2.getDefault();
        }
        else {
            return PACKAGER_5_REQUEST_2.get();
        }
    }
    public static int getPackager5Offer1Count() {
        if (Objects.equals(PACKAGER_5_OFFER_1_COUNT.get(), PACKAGER_5_OFFER_1_COUNT.getDefault())) {
            return PACKAGER_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_1_COUNT.get();
        }
    }
    public static String getPackager5Offer1() {
        if (Objects.equals(PACKAGER_5_OFFER_1.get(), PACKAGER_5_OFFER_1.getDefault())) {
            return PACKAGER_5_OFFER_1.getDefault();
        }
        else {
            return PACKAGER_5_OFFER_1.get();
        }
    }
    public static String getPackager5Request1() {
        if (Objects.equals(PACKAGER_5_REQUEST_1.get(), PACKAGER_5_REQUEST_1.getDefault())) {
            return PACKAGER_5_REQUEST_1.getDefault();
        }
        else {
            return PACKAGER_5_REQUEST_1.get();
        }
    }
    public static int getPackager4Offer2AgreementOrderXP() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_ORDER_XP.get(), PACKAGER_4_OFFER_2_AGREEMENT_ORDER_XP.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_ORDER_XP.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_ORDER_XP.get();
        }
    }
    public static int getPackager4Offer2AgreementOrderCount() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_ORDER_COUNT.get(), PACKAGER_4_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_ORDER_COUNT.get();
        }
    }
    public static String getPackager4Offer2AgreementSealTooltip() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get(), PACKAGER_4_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get();
        }
    }
    public static String getPackager4Offer2AgreementSeal() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_SEAL.get(), PACKAGER_4_OFFER_2_AGREEMENT_SEAL.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_SEAL.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_SEAL.get();
        }
    }
    public static String getPackager4Offer2AgreementBuyerMessage() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_BUYER_MESSAGE.get(), PACKAGER_4_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_BUYER_MESSAGE.get();
        }
    }
    public static String getPackager4Offer2AgreementBuyerAddress() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_BUYER_ADDRESS.get(), PACKAGER_4_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_BUYER_ADDRESS.get();
        }
    }
    public static String getPackager4Offer2AgreementBuyerName() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_BUYER_NAME.get(), PACKAGER_4_OFFER_2_AGREEMENT_BUYER_NAME.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_BUYER_NAME.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_BUYER_NAME.get();
        }
    }
    public static String getPackager4Offer2AgreementOfferTable() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_OFFER_TABLE.get(), PACKAGER_4_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_OFFER_TABLE.get();
        }
    }
    public static String getPackager4Offer2AgreementPriceTable() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_PRICE_TABLE.get(), PACKAGER_4_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_PRICE_TABLE.get();
        }
    }
    public static String getPackager4Offer3AgreementBacksideMessage() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get(), PACKAGER_4_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get();
        }
    }
    public static String getPackager4Offer2AgreementTitle() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_TITLE.get(), PACKAGER_4_OFFER_2_AGREEMENT_TITLE.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_TITLE.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_TITLE.get();
        }
    }
    public static String getPackager4Offer2AgreementID() {
        if (Objects.equals(PACKAGER_4_OFFER_2_AGREEMENT_ID.get(), PACKAGER_4_OFFER_2_AGREEMENT_ID.getDefault())) {
            return PACKAGER_4_OFFER_2_AGREEMENT_ID.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_2_AGREEMENT_ID.get();
        }
    }
    public static String getPackager4Request2() {
        if (Objects.equals(PACKAGER_4_REQUEST_2.get(), PACKAGER_4_REQUEST_2.getDefault())) {
            return PACKAGER_4_REQUEST_2.getDefault();
        }
        else {
            return PACKAGER_4_REQUEST_2.get();
        }
    }
    public static int getPackager4Offer1Count() {
        if (Objects.equals(PACKAGER_4_OFFER_1_COUNT.get(), PACKAGER_4_OFFER_1_COUNT.getDefault())) {
            return PACKAGER_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_1_COUNT.get();
        }
    }
    public static String getPackager4Offer1() {
        if (Objects.equals(PACKAGER_4_OFFER_1.get(), PACKAGER_4_OFFER_1.getDefault())) {
            return PACKAGER_4_OFFER_1.getDefault();
        }
        else {
            return PACKAGER_4_OFFER_1.get();
        }
    }
    public static String getPackager4Request1() {
        if (Objects.equals(PACKAGER_4_REQUEST_1.get(), PACKAGER_4_REQUEST_1.getDefault())) {
            return PACKAGER_4_REQUEST_1.getDefault();
        }
        else {
            return PACKAGER_4_REQUEST_1.get();
        }
    }
    public static int getPackager3Offer2AgreementOrderXP() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_ORDER_XP.get(), PACKAGER_3_OFFER_2_AGREEMENT_ORDER_XP.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_ORDER_XP.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_ORDER_XP.get();
        }
    }
    public static int getPackager3Offer2AgreementOrderCount() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_ORDER_COUNT.get(), PACKAGER_3_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_ORDER_COUNT.get();
        }
    }
    public static String getPackager3Offer2AgreementSealTooltip() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get(), PACKAGER_3_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get();
        }
    }
    public static String getPackager3Offer2AgreementSeal() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_SEAL.get(), PACKAGER_3_OFFER_2_AGREEMENT_SEAL.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_SEAL.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_SEAL.get();
        }
    }
    public static String getPackager3Offer2AgreementBuyerMessage() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_BUYER_MESSAGE.get(), PACKAGER_3_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_BUYER_MESSAGE.get();
        }
    }
    public static String getPackager3Offer2AgreementBuyerAddress() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_BUYER_ADDRESS.get(), PACKAGER_3_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_BUYER_ADDRESS.get();
        }
    }
    public static String getPackager3Offer2AgreementBuyerName() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_BUYER_NAME.get(), PACKAGER_3_OFFER_2_AGREEMENT_BUYER_NAME.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_BUYER_NAME.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_BUYER_NAME.get();
        }
    }
    public static String getPackager3Offer2AgreementOfferTable() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_OFFER_TABLE.get(), PACKAGER_3_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_OFFER_TABLE.get();
        }
    }
    public static String getPackager3Offer2AgreementPriceTable() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_PRICE_TABLE.get(), PACKAGER_3_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_PRICE_TABLE.get();
        }
    }
    public static String getPackager3Offer3AgreementBacksideMessage() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get(), PACKAGER_3_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get();
        }
    }
    public static String getPackager3Offer2AgreementTitle() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_TITLE.get(), PACKAGER_3_OFFER_2_AGREEMENT_TITLE.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_TITLE.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_TITLE.get();
        }
    }
    public static String getPackager3Offer2AgreementID() {
        if (Objects.equals(PACKAGER_3_OFFER_2_AGREEMENT_ID.get(), PACKAGER_3_OFFER_2_AGREEMENT_ID.getDefault())) {
            return PACKAGER_3_OFFER_2_AGREEMENT_ID.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_2_AGREEMENT_ID.get();
        }
    }
    public static String getPackager3Request2() {
        if (Objects.equals(PACKAGER_3_REQUEST_2.get(), PACKAGER_3_REQUEST_2.getDefault())) {
            return PACKAGER_3_REQUEST_2.getDefault();
        }
        else {
            return PACKAGER_3_REQUEST_2.get();
        }
    }
    public static int getPackager3Offer1Count() {
        if (Objects.equals(PACKAGER_3_OFFER_1_COUNT.get(), PACKAGER_3_OFFER_1_COUNT.getDefault())) {
            return PACKAGER_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_1_COUNT.get();
        }
    }
    public static String getPackager3Offer1() {
        if (Objects.equals(PACKAGER_3_OFFER_1.get(), PACKAGER_3_OFFER_1.getDefault())) {
            return PACKAGER_3_OFFER_1.getDefault();
        }
        else {
            return PACKAGER_3_OFFER_1.get();
        }
    }
    public static String getPackager3Request1() {
        if (Objects.equals(PACKAGER_3_REQUEST_1.get(), PACKAGER_3_REQUEST_1.getDefault())) {
            return PACKAGER_3_REQUEST_1.getDefault();
        }
        else {
            return PACKAGER_3_REQUEST_1.get();
        }
    }
    public static int getPackager2Offer2AgreementOrderXP() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_ORDER_XP.get(), PACKAGER_2_OFFER_2_AGREEMENT_ORDER_XP.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_ORDER_XP.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_ORDER_XP.get();
        }
    }
    public static int getPackager2Offer2AgreementOrderCount() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_ORDER_COUNT.get(), PACKAGER_2_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_ORDER_COUNT.get();
        }
    }
    public static String getPackager2Offer2AgreementSealTooltip() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get(), PACKAGER_2_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get();
        }
    }
    public static String getPackager2Offer2AgreementSeal() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_SEAL.get(), PACKAGER_2_OFFER_2_AGREEMENT_SEAL.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_SEAL.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_SEAL.get();
        }
    }
    public static String getPackager2Offer2AgreementBuyerMessage() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_BUYER_MESSAGE.get(), PACKAGER_2_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_BUYER_MESSAGE.get();
        }
    }
    public static String getPackager2Offer2AgreementBuyerAddress() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_BUYER_ADDRESS.get(), PACKAGER_2_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_BUYER_ADDRESS.get();
        }
    }
    public static String getPackager2Offer2AgreementBuyerName() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_BUYER_NAME.get(), PACKAGER_2_OFFER_2_AGREEMENT_BUYER_NAME.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_BUYER_NAME.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_BUYER_NAME.get();
        }
    }
    public static String getPackager2Offer2AgreementOfferTable() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_OFFER_TABLE.get(), PACKAGER_2_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_OFFER_TABLE.get();
        }
    }
    public static String getPackager2Offer2AgreementPriceTable() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_PRICE_TABLE.get(), PACKAGER_2_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_PRICE_TABLE.get();
        }
    }
    public static String getPackager2Offer2AgreementBacksideMessage() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get(), PACKAGER_2_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get();
        }
    }
    public static String getPackager2Offer2AgreementTitle() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_TITLE.get(), PACKAGER_2_OFFER_2_AGREEMENT_TITLE.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_TITLE.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_TITLE.get();
        }
    }
    public static String getPackager2Offer2AgreementID() {
        if (Objects.equals(PACKAGER_2_OFFER_2_AGREEMENT_ID.get(), PACKAGER_2_OFFER_2_AGREEMENT_ID.getDefault())) {
            return PACKAGER_2_OFFER_2_AGREEMENT_ID.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_2_AGREEMENT_ID.get();
        }
    }
    public static String getPackager2Request2() {
        if (Objects.equals(PACKAGER_2_REQUEST_2.get(), PACKAGER_2_REQUEST_2.getDefault())) {
            return PACKAGER_2_REQUEST_2.getDefault();
        }
        else {
            return PACKAGER_2_REQUEST_2.get();
        }
    }
    public static int getPackager2Offer1Count() {
        if (Objects.equals(PACKAGER_2_OFFER_1_COUNT.get(), PACKAGER_2_OFFER_1_COUNT.getDefault())) {
            return PACKAGER_2_OFFER_1_COUNT.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_1_COUNT.get();
        }
    }
    public static String getPackager2Offer1() {
        if (Objects.equals(PACKAGER_2_OFFER_1.get(), PACKAGER_2_OFFER_1.getDefault())) {
            return PACKAGER_2_OFFER_1.getDefault();
        }
        else {
            return PACKAGER_2_OFFER_1.get();
        }
    }
    public static String getPackager2Request1() {
        if (Objects.equals(PACKAGER_2_REQUEST_1.get(), PACKAGER_2_REQUEST_1.getDefault())) {
            return PACKAGER_2_REQUEST_1.getDefault();
        }
        else {
            return PACKAGER_2_REQUEST_1.get();
        }
    }
    public static int getPackager1Offer2AgreementOrderXP() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_ORDER_XP.get(), PACKAGER_1_OFFER_2_AGREEMENT_ORDER_XP.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_ORDER_XP.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_ORDER_XP.get();
        }
    }
    public static int getPackager1Offer2AgreementOrderCount() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_ORDER_COUNT.get(), PACKAGER_1_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_ORDER_COUNT.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_ORDER_COUNT.get();
        }
    }
    public static String getPackager1Offer2AgreementSealTooltip() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get(), PACKAGER_1_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_SEAL_TOOLTIP.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_SEAL_TOOLTIP.get();
        }
    }
    public static String getPackager1Offer2AgreementSeal() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_SEAL.get(), PACKAGER_1_OFFER_2_AGREEMENT_SEAL.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_SEAL.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_SEAL.get();
        }
    }
    public static String getPackager1Offer2AgreementBuyerMessage() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_BUYER_MESSAGE.get(), PACKAGER_1_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_BUYER_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_BUYER_MESSAGE.get();
        }
    }
    public static String getPackager1Offer2AgreementBuyerAddress() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_BUYER_ADDRESS.get(), PACKAGER_1_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_BUYER_ADDRESS.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_BUYER_ADDRESS.get();
        }
    }
    public static String getPackager1Offer2AgreementBuyerName() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_BUYER_NAME.get(), PACKAGER_1_OFFER_2_AGREEMENT_BUYER_NAME.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_BUYER_NAME.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_BUYER_NAME.get();
        }
    }
    public static String getPackager1Offer2AgreementOfferTable() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_OFFER_TABLE.get(), PACKAGER_1_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_OFFER_TABLE.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_OFFER_TABLE.get();
        }
    }
    public static String getPackager1Offer2AgreementPriceTable() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_PRICE_TABLE.get(), PACKAGER_1_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_PRICE_TABLE.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_PRICE_TABLE.get();
        }
    }
    public static String getPackager1Offer2AgreementBacksideMessage() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get(), PACKAGER_1_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_BACKSIDE_MESSAGE.get();
        }
    }
    public static String getPackager1Offer2AgreementTitle() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_TITLE.get(), PACKAGER_1_OFFER_2_AGREEMENT_TITLE.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_TITLE.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_TITLE.get();
        }
    }
    public static String getPackager1Offer2AgreementID() {
        if (Objects.equals(PACKAGER_1_OFFER_2_AGREEMENT_ID.get(), PACKAGER_1_OFFER_2_AGREEMENT_ID.getDefault())) {
            return PACKAGER_1_OFFER_2_AGREEMENT_ID.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_2_AGREEMENT_ID.get();
        }
    }
    public static String getPackager1Request2() {
        if (Objects.equals(PACKAGER_1_REQUEST_2.get(), PACKAGER_1_REQUEST_2.getDefault())) {
            return PACKAGER_1_REQUEST_2.getDefault();
        }
        else {
            return PACKAGER_1_REQUEST_2.get();
        }
    }
    public static int getPackager1Offer1Count() {
        if (Objects.equals(PACKAGER_1_OFFER_1_COUNT.get(), PACKAGER_1_OFFER_1_COUNT.getDefault())) {
            return PACKAGER_1_OFFER_1_COUNT.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_1_COUNT.get();
        }
    }
    public static String getPackager1Offer1() {
        if (Objects.equals(PACKAGER_1_OFFER_1.get(), PACKAGER_1_OFFER_1.getDefault())) {
            return PACKAGER_1_OFFER_1.getDefault();
        }
        else {
            return PACKAGER_1_OFFER_1.get();
        }
    }
    public static String getPackager1Request1() {
        if (Objects.equals(PACKAGER_1_REQUEST_1.get(), PACKAGER_1_REQUEST_1.getDefault())) {
            return PACKAGER_1_REQUEST_1.getDefault();
        }
        else {
            return PACKAGER_1_REQUEST_1.get();
        }
    }
}