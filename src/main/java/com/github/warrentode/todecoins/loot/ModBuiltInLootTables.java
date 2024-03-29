package com.github.warrentode.todecoins.loot;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModBuiltInLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();

    // bonus fishing loot tables
    public static final ResourceLocation TODECOINS_BONUS_FISHING = register(MODID + ":" + "gameplay/fishing/bonus");
    public static final ResourceLocation TODECOINS_FISHING_EXTRA_JUNK = register(MODID + ":" + "gameplay/fishing/extra_junk");
    public static final ResourceLocation TODECOINS_FISHING_EXTRA_TREASURE = register(MODID + ":" + "gameplay/fishing/extra_treasure");
    public static final ResourceLocation TODECOINS_FISHING_COINS = register(MODID + ":" + "gameplay/fishing/coins");
    public static final ResourceLocation TODECOINS_COD_COIN_FISHING = register(MODID + ":" + "gameplay/fishing/cod_coin");
    public static final ResourceLocation TODECOINS_SALMON_COIN_FISHING = register(MODID + ":" + "gameplay/fishing/salmon_coin");
    public static final ResourceLocation TODECOINS_PUFFERFISH_COIN_FISHING = register(MODID + ":" + "gameplay/fishing/pufferfish_coin");
    public static final ResourceLocation TODECOINS_TROPICAL_FISH_COIN_FISHING = register(MODID + ":" + "gameplay/fishing/tropical_fish_coin");
    // currency chest loot tables
    public static final ResourceLocation TODECOINS_COPPER_COIN_LOOT = register(MODID + ":" + "chests/currency/todecoins_copper_coin_loot");
    public static final ResourceLocation TODECOINS_IRON_COIN_LOOT = register(MODID + ":" + "chests/currency/todecoins_iron_coin_loot");
    public static final ResourceLocation TODECOINS_GOLD_COIN_LOOT = register(MODID + ":" + "chests/currency/todecoins_gold_coin_loot");
    public static final ResourceLocation TODECOINS_LUCKY_COIN_LOOT = register(MODID + ":" + "chests/currency/todecoins_lucky_coin_loot");
    public static final ResourceLocation TODECOINS_NETHERITE_COIN_LOOT = register(MODID + ":" + "chests/currency/todecoins_netherite_coin_loot");
    public static final ResourceLocation TODECOINS_NETHER_GOLD_COIN_LOOT = register(MODID + ":" + "chests/currency/todecoins_nether_gold_coin_loot");
    public static final ResourceLocation TODECOINS_ENDONIAN_COIN_LOOT = register(MODID + ":" + "chests/currency/todecoins_endonian_coin_loot");
    public static final ResourceLocation TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT = register(MODID + ":" + "chests/currency/todecoins_emerald_quarter_bank_note_loot");
    public static final ResourceLocation TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT = register(MODID + ":" + "chests/currency/todecoins_emerald_half_bank_note_loot");
    public static final ResourceLocation TODECOINS_EMERALD_BANK_NOTE_LOOT = register(MODID + ":" + "chests/currency/todecoins_emerald_bank_note_loot");
    // rascal coin reward table
    public static final ResourceLocation RASCAL_COIN_REWARD = register(MODID + ":" + "chests/collectible/rascal_coin_reward");

    // numismatist merchant offers loot tables
    public static final ResourceLocation NUMISMATIST_RARE_OFFERS =
            register(MODID + ":" + "chests/merchant/rare_offers");
    public static final ResourceLocation NUMISMATIST_CONTAINER_OFFERS =
            register(MODID + ":" + "chests/merchant/container_offers");

    // seasonal event collectible coin chest loot tables
    public static final ResourceLocation MYSTERY_COIN_PACK_INVERTED = register(MODID + ":" + "chests/collectible/seasonal/numismatist_request_list");
    public static final ResourceLocation MYSTERY_COIN_PACK = register(MODID + ":" + "chests/collectible/seasonal/mystery_coin_pack");
    public static final ResourceLocation SPRING_MYSTERY_COIN_PACK = register(MODID + ":" + "chests/collectible/seasonal/mystery_coin_pack_spring");
    public static final ResourceLocation SUMMER_MYSTERY_COIN_PACK = register(MODID + ":" + "chests/collectible/seasonal/mystery_coin_pack_summer");
    public static final ResourceLocation AUTUMN_MYSTERY_COIN_PACK = register(MODID + ":" + "chests/collectible/seasonal/mystery_coin_pack_autumn");
    public static final ResourceLocation WINTER_MYSTERY_COIN_PACK = register(MODID + ":" + "chests/collectible/seasonal/mystery_coin_pack_winter");
    public static final ResourceLocation COLLECTIBLE_COIN_CHEST_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_collectible_coin_loot");
    public static final ResourceLocation TODECOINS_BIRTHDAY_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_birthday_coin_loot");
    public static final ResourceLocation TODECOINS_HALLOWEEN_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_halloween_coin_loot");
    public static final ResourceLocation TODECOINS_CHRISTMAS_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_christmas_coin_loot");
    public static final ResourceLocation TODECOINS_EASTER_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_easter_coin_loot");
    public static final ResourceLocation TODECOINS_NEW_YEAR_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_new_year_coin_loot");
    public static final ResourceLocation TODECOINS_ANNIVERSARY_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_anniversary_coin_loot");
    public static final ResourceLocation SPRING_COINS_CHEST = register(MODID + ":" + "chests/collectible/seasonal/todecoins_spring_coin_loot");
    public static final ResourceLocation SUMMER_COINS_CHEST = register(MODID + ":" + "chests/collectible/seasonal/todecoins_summer_coin_loot");
    public static final ResourceLocation AUTUMN_COINS_CHEST = register(MODID + ":" + "chests/collectible/seasonal/todecoins_autumn_coin_loot");
    public static final ResourceLocation WINTER_COINS_CHEST = register(MODID + ":" + "chests/collectible/seasonal/todecoins_winter_coin_loot");
    // injected chest loot table
    public static final ResourceLocation TODECOINS_CHEST_LOOT = register(MODID + ":" + "chests/todecoins_chest");
    public static final ResourceLocation ENDONIAN_MATERIALS_LOOT = register(MODID + ":" + "chests/endonian_materials_loot");
    // mod villager chest and gift loot tables
    public static final ResourceLocation BANKER_CHEST = register(MODID + ":" + "chests/village/villager_banker");
    public static final ResourceLocation LEPRECHAUN_CHEST = register(MODID + ":" + "chests/village/villager_leprechaun");
    public static final ResourceLocation BANKER_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/banker_gift");
    public static final ResourceLocation LEPRECHAUN_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/leprechaun_gift");
    // injected villager gift loot tables
    public static final ResourceLocation TODECOINS_HERO_COIN_LOOT = register(MODID + ":" + "gameplay/hero_of_the_village/todecoins_hero_coin_loot");
    public static final ResourceLocation TODECOINS_COIN_GIFT_LOOT = register(MODID + ":" + "gameplay/hero_of_the_village/todecoins_coin_gift_loot");
    // piglin bartering loot tables
    public static final ResourceLocation NETHER_GOLD_COIN_PIGLIN_BARTERING = register(MODID + ":" + "gameplay/bartering/nether_gold_coin_piglin_bartering");
    public static final ResourceLocation NETHERITE_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/netherite_piglin_coin_barter_loot");
    public static final ResourceLocation GOLD_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/gold_piglin_coin_barter_loot");
    public static final ResourceLocation IRON_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/iron_piglin_coin_barter_loot");
    public static final ResourceLocation COPPER_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/copper_piglin_coin_barter_loot");
    public static final ResourceLocation ZOMBIE_PIGLIN_COIN_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/zombie_piglin_barter_loot");
    public static final ResourceLocation PIGLIN_EVENT_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/piglin_event_barter_loot");
    // injected currency entity drop loot table - master table
    public static final ResourceLocation TODECOINS_CURRENCY_DROPS = register(MODID + ":" + "entity/todecoins_currency_drops");
    // base currency entity drop loot tables - added to the master table
    public static final ResourceLocation TODECOINS_COPPER_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_copper_coin_drops");
    public static final ResourceLocation TODECOINS_IRON_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_iron_coin_drops");
    public static final ResourceLocation TODECOINS_GOLD_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_gold_coin_drops");
    public static final ResourceLocation TODECOINS_NETHERITE_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_netherite_coin_drops");
    public static final ResourceLocation TODECOINS_NETHER_GOLD_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_nether_gold_coin_drops");
    public static final ResourceLocation TODECOINS_ENDONIAN_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_endonian_coin_drops");
    public static final ResourceLocation TODECOINS_EMERALD_QUARTER_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_emerald_quarter_bank_note_drops");
    public static final ResourceLocation TODECOINS_EMERALD_HALF_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_emerald_half_bank_note_drops");
    public static final ResourceLocation TODECOINS_EMERALD_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_emerald_bank_note_drops");
    public static final ResourceLocation TODECOINS_LUCKY_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_lucky_coin_drops");
    // injected boss specific currency entity drop loot table - master table
    public static final ResourceLocation TODECOINS_BOSS_CURRENCY_DROPS = register(MODID + ":" + "entity/todecoins_boss_currency_drops");
    // base boss specific currency entity drop loot tables - added to the master table
    public static final ResourceLocation TODECOINS_BOSS_COPPER_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_copper_coin_drops");
    public static final ResourceLocation TODECOINS_BOSS_IRON_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_copper_iron_drops");
    public static final ResourceLocation TODECOINS_BOSS_GOLD_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_gold_coin_drops");
    public static final ResourceLocation TODECOINS_BOSS_NETHERITE_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_netherite_coin_drops");
    public static final ResourceLocation TODECOINS_BOSS_NETHER_GOLD_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_nether_gold_coin_drops");
    public static final ResourceLocation TODECOINS_BOSS_ENDONIAN_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_endonian_coin_drops");
    public static final ResourceLocation TODECOINS_BOSS_EMERALD_QUARTER_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_boss_emerald_quarter_bank_note_drops");
    public static final ResourceLocation TODECOINS_BOSS_EMERALD_HALF_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_boss_emerald_half_bank_note_drops");
    public static final ResourceLocation TODECOINS_BOSS_EMERALD_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_boss_emerald_bank_note_drops");
    // seasonal collectible coin entity drop loot tables - added to the master tables
    public static final ResourceLocation ENTITY_COLLECTIBLE_COIN_DROPS = register(MODID + ":" + "entity/collectible/entity_collectible_coin_drops");
    public static final ResourceLocation BOSS_COLLECTIBLE_COIN_DROPS = register(MODID + ":" + "entity/collectible/boss_collectible_coin_drops");
    public static final ResourceLocation HOLIDAY_COLLECTIBLE_COIN_DROPS = register(MODID + ":" + "entity/collectible/holiday_collectible_coin_drops");
    public static final ResourceLocation TODECOINS_HALLOWEEN_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_halloween_coin_drops");
    public static final ResourceLocation TODECOINS_BIRTHDAY_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_birthday_coin_drops");
    public static final ResourceLocation TODECOINS_CHRISTMAS_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_christmas_coin_drops");
    public static final ResourceLocation TODECOINS_EASTER_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_easter_coin_drops");
    public static final ResourceLocation TODECOINS_NEW_YEAR_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_new_year_coin_drops");
    public static final ResourceLocation TODECOINS_ANNIVERSARY_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_anniversary_coin_drops");
    public static final ResourceLocation TODECOINS_SPRING_ENTITY_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/todecoins_spring_coin_drops");
    public static final ResourceLocation TODECOINS_SUMMER_ENTITY_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/todecoins_summer_coin_drops");
    public static final ResourceLocation TODECOINS_AUTUMN_ENTITY_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/todecoins_autumn_coin_drops");
    public static final ResourceLocation TODECOINS_WINTER_ENTITY_COIN_DROPS = register(MODID + ":" + "entity/collectible/seasonal/todecoins_winter_coin_drops");
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    private static ResourceLocation register(String path) {
        return register(new ResourceLocation(path));
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