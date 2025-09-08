package com.github.warrentode.todecoins.entity.trades;

public class TradeOfferConstants {
    /** values for xp multiplier by level */
    public static final int novice = 1;
    public static final int apprentice = 2;
    public static final int journeyman = 3;
    public static final int expert = 4;
    public static final int master = 5;
    public static final int common = 1;
    public static final int rare = 2;

    /** variables for default values */
    public static final int BASE_XP = 5;
    public static final int COMMON_MAX_TRADES = 12;
    public static final int RARE_MAX_TRADES = 3;
    public static final float COMMON_TRADE_MULTIPLIER = 0.05F;
    public static final float RARE_TRADE_MULTIPLIER = 0.2F;

    /** variables for the json entry labels, intended to make the trade format uniform, consistent,
    and easily understood across all trade types */
    // the item the villager is buying
    public static final String requestStack = "requested_item";
    // the loot table the villager is buying from
    public static final String requestTable = "requested_table";
    // the amount of the item the villager is buying
    public static final String requestStackCount = "requested_item_count";
    // the second item in a pair the villager is buying
    public static final String secondaryRequestStack = "secondary_requested_item";
    // the second loot table the villager is buying from
    public static final String secondaryRequestTable = "secondary_requested_table";
    // the amount of the second item in a pair the villager is buying
    public static final String secondaryRequestStackCount = "secondary_requested_item_count";
    // the item the villager is selling
    public static final String offerStack = "offered_item";
    // the loot table the villager is selling from
    public static final String offerTable = "offered_table";
    // the amount of the item the villager is selling
    public static final String offerStackCount = "offered_item_count";
    // type aware item list the villager is selling
    public static final String offerStackList = "offered_item_list";
    // when emerald is the hardcoded item, this is their count
    public static final String emeraldCount = "emerald_count";
    // max number of trades before restocking
    public static final String maxUses = "max_trades";
    // experience gained per trade
    public static final String experience = "trade_experience";
    // multiplier applied to the cost of the trade
    public static final String multiplier = "price_multiplier";
    // potion hasEffect on an item
    public static final String effect = "potion_effect";
    // potion duration the item's potion hasEffect has
    public static final String duration = "potion_duration";
    // tag for the structure the map points to
    public static final String structureTag = "structure_tag";
    // translation key for the map's display name
    public static final String mapName = "map_name_key";
    // the map's marker for the structure it points to
    public static final String mapMarker = "map_marker";
    // when arrows is the hardcoded item, this is their count
    public static final String arrowCount = "arrow_count";
    // when tipped arrows is the hardcoded item, this is their count
    public static final String tippedArrowCount = "tipped_arrow_count";
}