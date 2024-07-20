package com.github.warrentode.todecoins.config;

import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // general trade setting variables
    public static final ForgeConfigSpec.BooleanValue USE_MOD_TRADES;
    public static final ForgeConfigSpec.IntValue BASE_XP;
    public static final ForgeConfigSpec.IntValue MAX_USES;
    public static final ForgeConfigSpec.IntValue RARE_MAX_USES;
    public static final ForgeConfigSpec.DoubleValue PRICE_MULTIPLIER;
    public static final ForgeConfigSpec.DoubleValue RARE_PRICE_MULTIPLIER;
    public static final ForgeConfigSpec.BooleanValue RESET_TRADES_ON_RESTOCK;
    public static final ForgeConfigSpec.IntValue MAX_VILLAGER_TRADES_PER_LEVEL;
    public static final ForgeConfigSpec.IntValue MAX_WANDERER_COMMON_TRADES;
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
        // general trade variable setters
        BUILDER.push("General Trade Settings");
        USE_MOD_TRADES = BUILDER
                .comment(" Use Loot Table Trades?")
                .define("use_loot_table_trades", false);
        BASE_XP = BUILDER
                .comment("Default Base XP per Level")
                .defineInRange("default_base_xp_per_level", 5, 0, Integer.MAX_VALUE);
        MAX_USES = BUILDER
                .comment("Default Max Uses per Trade")
                .defineInRange("default_max_uses_per_trade", 12, 1, Integer.MAX_VALUE);
        RARE_MAX_USES = BUILDER
                .comment("Default Max Uses per Rare Trade")
                .defineInRange("default_max_uses_per_rare_trade", 3, 1, Integer.MAX_VALUE);
        PRICE_MULTIPLIER = BUILDER
                .comment("Default Price Multiplier")
                .defineInRange("default_common_price_multiplier", 0.05, 0, Double.MAX_VALUE);
        RARE_PRICE_MULTIPLIER = BUILDER
                .comment("Default Price Multiplier")
                .defineInRange("default_rare_price_multiplier", 0.2, 0, Double.MAX_VALUE);
        RESET_TRADES_ON_RESTOCK = BUILDER
                .comment(" Reset Villager Trades on Restock?")
                .define("reset_trades_on_restock", false);
        MAX_VILLAGER_TRADES_PER_LEVEL = BUILDER
                .comment(" Max Trades per Villager Profession Level")
                .defineInRange("max_villager_trades_per_level", 2, 2, Integer.MAX_VALUE);
        MAX_WANDERER_COMMON_TRADES = BUILDER
                .comment(" Max Wandering Common Trades")
                .comment("technically applies to the Numismatist as well, but he only has 5 common trades made for him at this time")
                .defineInRange("max_wanderer_common_trades", 5, 5, Integer.MAX_VALUE);
        BUILDER.pop();

        // NUMISMATIST TRADES
        BUILDER.push("Numismatist Trade Settings")
                .comment("uses the rare max uses, base xp setting, and price multiplier set to 0");
        NUMISMATIST_REQUEST_1 = BUILDER
                .comment("Numismatist Trade Request 1 Table")
                .define("numismatist_trade_request_1_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        NUMISMATIST_OFFER_1 = BUILDER
                .comment("Numismatist Trade Offer 1 Table")
                .define("numismatist_trade_offer_1_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_2 = BUILDER
                .comment("Numismatist Trade Request 2 Table")
                .define("numismatist_trade_request_2_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_OFFER_2 = BUILDER
                .comment("Numismatist Trade Offer 2 Table")
                .define("numismatist_trade_offer_2_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        NUMISMATIST_REQUEST_3A = BUILDER
                .comment("Numismatist Trade Request 3A Table")
                .define("numismatist_trade_request_3a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_3B = BUILDER
                .comment("Numismatist Trade Request 3B Table")
                .define("numismatist_trade_request_3b_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        NUMISMATIST_TRADE_3_STRUCTURE_TAG = BUILDER
                .comment("Numismatist Trade 2 Structure Tag")
                .define("numismatist_trade_3_structure_tag",
                        ForgeTags.StructureTags.ON_VILLAGE_EXPLORER_MAPS.toString());
        NUMISMATIST_TRADE_3_MAP_NAME = BUILDER
                .comment("Numismatist Trade 3 Map Name")
                .define("numismatist_trade_3_map_name",
                        "Merchant Map");
        NUMISMATIST_TRADE_3_MAP_MARKER = BUILDER
                .comment("Numismatist Trade 3 Map Marker")
                .define("numismatist_trade_3_map_marker",
                        MapDecoration.Type.MANSION.toString());
        NUMISMATIST_REQUEST_4A = BUILDER
                .comment("Numismatist Trade Request 4A Table")
                .define("numismatist_trade_request_4a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_4B = BUILDER
                .comment("Numismatist Trade Request 4B Table")
                .define("numismatist_trade_request_4b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        NUMISMATIST_OFFER_4 = BUILDER
                .comment("Numismatist Trade Offer 4 Table")
                .define("numismatist_trade_offer_4_table",
                        TradeLootTables.NUMISMATIST_CONTAINER_OFFERS.toString());
        NUMISMATIST_LOOT_BOX_DISPLAY_NAME = BUILDER
                .comment("Numismatist Loot Box Display Name")
                .comment("sorry, I don't know how to make a single item/block customizable in a config file")
                .define("numismatist_trade_loot_box_display_name",
                        "tooltips.collectible_coin_pack");
        NUMISMATIST_LOOT_BOX_LOOT_TABLE = BUILDER
                .comment("Numismatist Trade Loot Box Loot Table")
                .comment("recommend blacklisting this loot table in lootr")
                .define("numismatist_trade_loot_box_loot_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_5A = BUILDER
                .comment("Numismatist Trade Request 5A Table")
                .define("numismatist_trade_request_5a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_5B = BUILDER
                .comment("Numismatist Trade Request 5B Table")
                .define("numismatist_trade_request_5b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        NUMISMATIST_RARE_OFFER = BUILDER
                .comment("Numismatist Trade Rare Offers Table")
                .define("numismatist_trade_offers_table",
                        TradeLootTables.NUMISMATIST_RARE_OFFERS.toString());
        NUMISMATIST_RARE_REQUEST_1A = BUILDER
                .comment("Numismatist Trade Rare Request 1A Table")
                .define("numismatist_trade_rare_request_1a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_RARE_REQUEST_1B = BUILDER
                .comment("Numismatist Trade Rare Request 1B Table")
                .define("numismatist_trade_rare_request_1b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        NUMISMATIST_RARE_REQUEST_2A = BUILDER
                .comment("Numismatist Trade Rare Request 2A Table")
                .comment("for enchanted book offer")
                .define("numismatist_trade_rare_request_2a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_RARE_REQUEST_2B = BUILDER
                .comment("Numismatist Trade Rare Request 2B Table")
                .comment("for enchanted book offer")
                .define("numismatist_trade_rare_request_2b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());

        BUILDER.pop();


        SPEC = BUILDER.build();
    }

    public static @NotNull TagKey<Structure> getStructureTag(String structureTag) {
        ResourceLocation structureTagLocation = ResourceLocation.tryParse(structureTag);
        if (structureTagLocation != null) {
            return ForgeTags.forgeStructureTag(structureTagLocation.getNamespace(), structureTagLocation.getPath());
        }
        else return ForgeTags.StructureTags.OVERWORLD_POI;
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
    // general trade setting getters
    public static Boolean getCustomTrades() {
        if (Objects.equals(USE_MOD_TRADES.get(), USE_MOD_TRADES.getDefault())) {
            return USE_MOD_TRADES.getDefault();
        }
        else {
            return USE_MOD_TRADES.get();
        }
    }
    public static Boolean getResetTrades() {
        if (Objects.equals(RESET_TRADES_ON_RESTOCK.get(), RESET_TRADES_ON_RESTOCK.getDefault())) {
            return RESET_TRADES_ON_RESTOCK.getDefault();
        }
        else {
            return RESET_TRADES_ON_RESTOCK.get();
        }
    }
    public static int getBaseXp() {
        if (Objects.equals(BASE_XP.get(), BASE_XP.getDefault())) {
            return BASE_XP.getDefault();
        }
        else {
            return BASE_XP.get();
        }
    }
    public static int getRareMaxUses() {
        if (Objects.equals(RARE_MAX_USES.get(), RARE_MAX_USES.getDefault())) {
            return RARE_MAX_USES.getDefault();
        }
        else {
            return RARE_MAX_USES.get();
        }
    }
    public static int getMaxUses() {
        if (Objects.equals(MAX_USES.get(), MAX_USES.getDefault())) {
            return MAX_USES.getDefault();
        }
        else {
            return MAX_USES.get();
        }
    }
    public static double getPriceMultiplier() {
        if (Objects.equals(PRICE_MULTIPLIER.get(), PRICE_MULTIPLIER.getDefault())) {
            return PRICE_MULTIPLIER.getDefault();
        }
        else {
            return PRICE_MULTIPLIER.get();
        }
    }
    public static double getRarePriceMultiplier() {
        if (Objects.equals(RARE_PRICE_MULTIPLIER.get(), RARE_PRICE_MULTIPLIER.getDefault())) {
            return RARE_PRICE_MULTIPLIER.getDefault();
        }
        else {
            return RARE_PRICE_MULTIPLIER.get();
        }
    }
    public static int getMaxVillagerTradesPerLevel() {
        if (Objects.equals(MAX_VILLAGER_TRADES_PER_LEVEL.get(), MAX_VILLAGER_TRADES_PER_LEVEL.getDefault())) {
            return MAX_VILLAGER_TRADES_PER_LEVEL.getDefault();
        }
        else {
            return MAX_VILLAGER_TRADES_PER_LEVEL.get();
        }
    }
    public static int getMaxWandererCommonTradesPerLevel() {
        if (Objects.equals(MAX_WANDERER_COMMON_TRADES.get(), MAX_WANDERER_COMMON_TRADES.getDefault())) {
            return MAX_WANDERER_COMMON_TRADES.getDefault();
        }
        else {
            return MAX_WANDERER_COMMON_TRADES.get();
        }
    }
}