package com.github.warrentode.todecoins.config.trades.todecoins;

import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NumismatistTradesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Numismatist Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_3A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_3B;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_TRADE_3_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_TRADE_3_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_TRADE_3_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_4A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_4B;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_LOOT_BOX_DISPLAY_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_LOOT_BOX_LOOT_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_5A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_5B;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_OFFER;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_REQUEST_1A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_REQUEST_1B;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_REQUEST_2A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_REQUEST_2B;

    static {
        // NUMISMATIST TRADES
        BUILDER.push("Numismatist Trade Settings")
                .comment(" All these Trades use the Rare Max Trades Setting");
        BUILDER.push("Numismatist Common Trade One");
        NUMISMATIST_REQUEST_1 = BUILDER
                .comment(" Numismatist Trade Request 1 Table")
                .define("numismatist_trade_request_1_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        NUMISMATIST_OFFER_1 = BUILDER
                .comment(" Numismatist Trade Offer 1 Table")
                .define("numismatist_trade_offer_1_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Common Trade Two");
        NUMISMATIST_REQUEST_2 = BUILDER
                .comment(" Numismatist Trade Request 2 Table")
                .define("numismatist_trade_request_2_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_OFFER_2 = BUILDER
                .comment(" Numismatist Trade Offer 2 Table")
                .define("numismatist_trade_offer_2_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Common Trade Three");
        NUMISMATIST_REQUEST_3A = BUILDER
                .comment(" Numismatist Trade Request 3A Table")
                .define("numismatist_trade_request_3a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_3B = BUILDER
                .comment(" Numismatist Trade Request 3B Table")
                .define("numismatist_trade_request_3b_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        NUMISMATIST_TRADE_3_STRUCTURE_TAG = BUILDER
                .comment(" Numismatist Trade 2 Structure Tag")
                .define("numismatist_trade_3_structure_tag",
                        "forge:worldgen/structure/village");
        NUMISMATIST_TRADE_3_MAP_NAME = BUILDER
                .comment(" Numismatist Trade 3 Map Name")
                .define("numismatist_trade_3_map_name",
                        "Merchant Map");
        NUMISMATIST_TRADE_3_MAP_MARKER = BUILDER
                .comment(" Numismatist Trade 3 Map Marker")
                .define("numismatist_trade_3_map_marker",
                        MapDecoration.Type.MANSION.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Common Trade Four");
        NUMISMATIST_REQUEST_4A = BUILDER
                .comment(" Numismatist Trade Request 4A Table")
                .define("numismatist_trade_request_4a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_4B = BUILDER
                .comment(" Numismatist Trade Request 4B Table")
                .define("numismatist_trade_request_4b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        NUMISMATIST_OFFER_4 = BUILDER
                .comment(" Numismatist Trade Offer 4 Table")
                .define("numismatist_trade_offer_4_table",
                        TradeLootTables.NUMISMATIST_CONTAINER_OFFERS.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Common Trade Five");
        NUMISMATIST_LOOT_BOX_DISPLAY_NAME = BUILDER
                .comment(" Numismatist Loot Box Display Name")
                .comment(" sorry, I don't know how to make a single item/block customizable in a config file")
                .define("numismatist_trade_loot_box_display_name",
                        "tooltips.collectible_coin_pack");
        NUMISMATIST_LOOT_BOX_LOOT_TABLE = BUILDER
                .comment(" Numismatist Trade Loot Box Loot Table")
                .comment(" recommend blacklisting this loot table in lootr")
                .define("numismatist_trade_loot_box_loot_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_5A = BUILDER
                .comment(" Numismatist Trade Request 5A Table")
                .define("numismatist_trade_request_5a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_5B = BUILDER
                .comment(" Numismatist Trade Request 5B Table")
                .define("numismatist_trade_request_5b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Rare Trade One");
        NUMISMATIST_RARE_OFFER = BUILDER
                .comment(" Numismatist Trade Rare Offers Table")
                .define("numismatist_trade_offers_table",
                        TradeLootTables.NUMISMATIST_RARE_OFFERS.toString());
        NUMISMATIST_RARE_REQUEST_1A = BUILDER
                .comment(" Numismatist Trade Rare Request 1A Table")
                .define("numismatist_trade_rare_request_1a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_RARE_REQUEST_1B = BUILDER
                .comment(" Numismatist Trade Rare Request 1B Table")
                .define("numismatist_trade_rare_request_1b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Rare Trade Two");
        NUMISMATIST_RARE_REQUEST_2A = BUILDER
                .comment(" Numismatist Trade Rare Request 2A Table")
                .comment(" for enchanted book offer")
                .define("numismatist_trade_rare_request_2a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_RARE_REQUEST_2B = BUILDER
                .comment(" Numismatist Trade Rare Request 2B Table")
                .comment(" for enchanted book offer")
                .define("numismatist_trade_rare_request_2b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // NUMISMATIST TRADE GETTERS
    public static String getNumismatistRareRequest2B() {
        if (Objects.equals(NUMISMATIST_RARE_REQUEST_2B.get(), NUMISMATIST_RARE_REQUEST_2B.getDefault())) {
            return NUMISMATIST_RARE_REQUEST_2B.getDefault();
        }
        else {
            return NUMISMATIST_RARE_REQUEST_2B.get();
        }
    }
    public static String getNumismatistRareRequest2A() {
        if (Objects.equals(NUMISMATIST_RARE_REQUEST_2A.get(), NUMISMATIST_RARE_REQUEST_2A.getDefault())) {
            return NUMISMATIST_RARE_REQUEST_2A.getDefault();
        }
        else {
            return NUMISMATIST_RARE_REQUEST_2A.get();
        }
    }
    public static String getNumismatistRareOffer() {
        if (Objects.equals(NUMISMATIST_RARE_OFFER.get(), NUMISMATIST_RARE_OFFER.getDefault())) {
            return NUMISMATIST_RARE_OFFER.getDefault();
        }
        else {
            return NUMISMATIST_RARE_OFFER.get();
        }
    }
    public static String getNumismatistRareRequest1B() {
        if (Objects.equals(NUMISMATIST_RARE_REQUEST_1B.get(), NUMISMATIST_RARE_REQUEST_1B.getDefault())) {
            return NUMISMATIST_RARE_REQUEST_1B.getDefault();
        }
        else {
            return NUMISMATIST_RARE_REQUEST_1B.get();
        }
    }
    public static String getNumismatistRareRequest1A() {
        if (Objects.equals(NUMISMATIST_RARE_REQUEST_1A.get(), NUMISMATIST_RARE_REQUEST_1A.getDefault())) {
            return NUMISMATIST_RARE_REQUEST_1A.getDefault();
        }
        else {
            return NUMISMATIST_RARE_REQUEST_1A.get();
        }
    }
    public static String getNumismatistRequest5B() {
        if (Objects.equals(NUMISMATIST_REQUEST_5B.get(), NUMISMATIST_REQUEST_5B.getDefault())) {
            return NUMISMATIST_REQUEST_5B.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_5B.get();
        }
    }
    public static String getNumismatistRequest5A() {
        if (Objects.equals(NUMISMATIST_REQUEST_5A.get(), NUMISMATIST_REQUEST_5A.getDefault())) {
            return NUMISMATIST_REQUEST_5A.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_5A.get();
        }
    }
    public static String getNumismatistLootBoxLootTable() {
        if (Objects.equals(NUMISMATIST_LOOT_BOX_LOOT_TABLE.get(), NUMISMATIST_LOOT_BOX_LOOT_TABLE.getDefault())) {
            return NUMISMATIST_LOOT_BOX_LOOT_TABLE.getDefault();
        }
        else {
            return NUMISMATIST_LOOT_BOX_LOOT_TABLE.get();
        }
    }
    public static String getNumismatistLootBoxDisplayName() {
        if (Objects.equals(NUMISMATIST_LOOT_BOX_DISPLAY_NAME.get(), NUMISMATIST_LOOT_BOX_DISPLAY_NAME.getDefault())) {
            return NUMISMATIST_LOOT_BOX_DISPLAY_NAME.getDefault();
        }
        else {
            return NUMISMATIST_LOOT_BOX_DISPLAY_NAME.get();
        }
    }
    public static String getNumismatistOffer4() {
        if (Objects.equals(NUMISMATIST_OFFER_4.get(), NUMISMATIST_OFFER_4.getDefault())) {
            return NUMISMATIST_OFFER_4.getDefault();
        }
        else {
            return NUMISMATIST_OFFER_4.get();
        }
    }
    public static String getNumismatistRequest4B() {
        if (Objects.equals(NUMISMATIST_REQUEST_4B.get(), NUMISMATIST_REQUEST_4B.getDefault())) {
            return NUMISMATIST_REQUEST_4B.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_4B.get();
        }
    }
    public static String getNumismatistRequest4A() {
        if (Objects.equals(NUMISMATIST_REQUEST_4A.get(), NUMISMATIST_REQUEST_4A.getDefault())) {
            return NUMISMATIST_REQUEST_4A.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_4A.get();
        }
    }
    public static String getNumismatistTrade3MapMarker() {
        if (Objects.equals(NUMISMATIST_TRADE_3_MAP_MARKER.get(), NUMISMATIST_TRADE_3_MAP_MARKER.getDefault())) {
            return NUMISMATIST_TRADE_3_MAP_MARKER.getDefault();
        }
        else {
            return NUMISMATIST_TRADE_3_MAP_MARKER.get();
        }
    }
    public static String getNumismatistTrade3MapName() {
        if (Objects.equals(NUMISMATIST_TRADE_3_MAP_NAME.get(), NUMISMATIST_TRADE_3_MAP_NAME.getDefault())) {
            return NUMISMATIST_TRADE_3_MAP_NAME.getDefault();
        }
        else {
            return NUMISMATIST_TRADE_3_MAP_NAME.get();
        }
    }
    public static String getNumismatistTrade3StructureTag() {
        if (Objects.equals(NUMISMATIST_TRADE_3_STRUCTURE_TAG.get(), NUMISMATIST_TRADE_3_STRUCTURE_TAG.getDefault())) {
            return NUMISMATIST_TRADE_3_STRUCTURE_TAG.getDefault();
        }
        else {
            return NUMISMATIST_TRADE_3_STRUCTURE_TAG.get();
        }
    }
    public static String getNumismatistTradeRequest3B() {
        if (Objects.equals(NUMISMATIST_REQUEST_3B.get(), NUMISMATIST_REQUEST_3B.getDefault())) {
            return NUMISMATIST_REQUEST_3B.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_3B.get();
        }
    }
    public static String getNumismatistTradeRequest3A() {
        if (Objects.equals(NUMISMATIST_REQUEST_3A.get(), NUMISMATIST_REQUEST_3A.getDefault())) {
            return NUMISMATIST_REQUEST_3A.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_3A.get();
        }
    }
    public static String getNumismatistTradeOffer2() {
        if (Objects.equals(NUMISMATIST_OFFER_2.get(), NUMISMATIST_OFFER_2.getDefault())) {
            return NUMISMATIST_OFFER_2.getDefault();
        }
        else {
            return NUMISMATIST_OFFER_2.get();
        }
    }
    public static String getNumismatistTradeRequest2() {
        if (Objects.equals(NUMISMATIST_REQUEST_2.get(), NUMISMATIST_REQUEST_2.getDefault())) {
            return NUMISMATIST_REQUEST_2.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_2.get();
        }
    }
    public static String getNumismatistTradeOffer1() {
        if (Objects.equals(NUMISMATIST_OFFER_1.get(), NUMISMATIST_OFFER_1.getDefault())) {
            return NUMISMATIST_OFFER_1.getDefault();
        }
        else {
            return NUMISMATIST_OFFER_1.get();
        }
    }
    public static String getNumismatistTradeRequest1() {
        if (Objects.equals(NUMISMATIST_REQUEST_1.get(), NUMISMATIST_REQUEST_1.getDefault())) {
            return NUMISMATIST_REQUEST_1.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_1.get();
        }
    }
}