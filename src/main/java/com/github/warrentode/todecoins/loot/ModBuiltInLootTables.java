package com.github.warrentode.todecoins.loot;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModBuiltInLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();

    // master chest loot for injection
    public static final ResourceLocation MASTER_CHEST_LOOT = register(MODID + ":" + "chests/master_chest");
    public static final ResourceLocation MASTER_DROPS_LOOT = register(MODID + ":" + "entity/master_drops");

    // collectible coin loot tables
    public static final ResourceLocation COLLECTIBLE_COIN_MASTER_CHEST_LOOT = register(MODID + ":" + "chests/collectible/seasonal/master_coin_loot");
    public static final ResourceLocation COLLECTIBLE_COIN_GIFT_LOOT = register(MODID + ":" + "gameplay/hero_of_the_village/todecoins_coin_gift_loot");

    // seasonal event collectible coin loot tables
    public static final ResourceLocation HOLIDAY_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/holiday_coins");
    public static final ResourceLocation HOLIDAY_COIN_LOOT_INVERTED = register(MODID + ":" + "chests/collectible/seasonal/holiday_coins_inverted");
    public static final ResourceLocation HERO_COIN_LOOT = register(MODID + ":" + "gameplay/hero_of_the_village/hero_coins");
    public static final ResourceLocation HERO_COIN_LOOT_INVERTED = register(MODID + ":" + "gameplay/hero_of_the_village/hero_coins_inverted");

    // season collectible coin loot tables
    public static final ResourceLocation SPRING_COINS_LOOT = register(MODID + ":" + "chests/collectible/seasonal/spring_coins");
    public static final ResourceLocation SUMMER_COINS_LOOT = register(MODID + ":" + "chests/collectible/seasonal/summer_coins");
    public static final ResourceLocation AUTUMN_COINS_LOOT = register(MODID + ":" + "chests/collectible/seasonal/autumn_coins");
    public static final ResourceLocation WINTER_COINS_LOOT = register(MODID + ":" + "chests/collectible/seasonal/winter_coins");

    // seasonal collectible coin entity drop loot tables
    public static final ResourceLocation MASTER_COLLECTIBLE_COIN_DROPS = register(MODID + ":" + "entity/collectible/master_coin_drops");
    public static final ResourceLocation BOSS_COLLECTIBLE_COIN_DROPS = register(MODID + ":" + "entity/collectible/boss_coin_drops");
    public static final ResourceLocation SPRING_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/spring_coin_drops");
    public static final ResourceLocation SPRING_BOSS_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/spring_boss_coin_drops");
    public static final ResourceLocation SUMMER_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/summer_coin_drops");
    public static final ResourceLocation SUMMER_BOSS_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/summer_boss_coin_drops");
    public static final ResourceLocation AUTUMN_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/autumn_coin_drops");
    public static final ResourceLocation AUTUMN_BOSS_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/autumn_boss_coin_drops");
    public static final ResourceLocation WINTER_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/winter_coin_drops");
    public static final ResourceLocation WINTER_BOSS_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/winter_boss_coin_drops");

    // rascal coin reward table
    public static final ResourceLocation RASCAL_COIN_REWARD = register(MODID + ":" + "gameplay/rewards/rascal_coin_reward");

    // extra fishing loot
    public static final ResourceLocation FISHING_COINS = register(MODID + ":" + "gameplay/fishing/coins");
    public static final ResourceLocation FISHING_EXTRA_JUNK = register(MODID + ":" + "gameplay/fishing/extra_junk");
    public static final ResourceLocation FISHING_BONUS_FISH = register(MODID + ":" + "gameplay/fishing/bonus_fish");

    // mod villager chest and gift loot tables
    public static final ResourceLocation BANKER_CHEST = register(MODID + ":" + "chests/village/villager_banker");
    public static final ResourceLocation LEPRECHAUN_CHEST = register(MODID + ":" + "chests/village/villager_leprechaun");
    public static final ResourceLocation BANKER_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/banker_gift");
    public static final ResourceLocation LEPRECHAUN_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/leprechaun_gift");

    // piglin bartering loot tables
    public static final ResourceLocation NETHER_GOLD_COIN_PIGLIN_BARTERING = register(MODID + ":" + "gameplay/bartering/nether_gold_coin_piglin_bartering");
    public static final ResourceLocation NETHERITE_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/netherite_piglin_coin_barter_loot");
    public static final ResourceLocation GOLD_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/gold_piglin_coin_barter_loot");
    public static final ResourceLocation IRON_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/iron_piglin_coin_barter_loot");
    public static final ResourceLocation COPPER_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/copper_piglin_coin_barter_loot");
    public static final ResourceLocation ZOMBIE_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/zombie_piglin_barter_loot");
    public static final ResourceLocation PIGLIN_EVENT_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/piglin_event_barter_loot");

    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    private static ResourceLocation register(String path) {
        return register(ResourceLocation.parse(path));
    }

    private static ResourceLocation register(ResourceLocation path) {
        if (LOCATIONS.add(path)) {
            return path;
        }
        else {
            throw new IllegalArgumentException(path + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}