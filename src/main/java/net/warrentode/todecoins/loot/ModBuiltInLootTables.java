package net.warrentode.todecoins.loot;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModBuiltInLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    // bonus fishing loot tables
    public static final ResourceLocation TODECOINS_BONUS_FISHING = register(MODID + ":" + "gameplay/fishing/bonus");
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
    public static final ResourceLocation TODECOINS_EMERALD_QUARTER_BANK_NOTE_LOOT = register(MODID + ":" + "chests/currency/todecoins_emerald_quarter_bank_note_loot");
    public static final ResourceLocation TODECOINS_EMERALD_HALF_BANK_NOTE_LOOT = register(MODID + ":" + "chests/currency/todecoins_emerald_half_bank_note_loot");
    public static final ResourceLocation TODECOINS_EMERALD_BANK_NOTE_LOOT = register(MODID + ":" + "chests/currency/todecoins_emerald_bank_note_loot");

    // seasonal event collectible coin chest loot tables
    public static final ResourceLocation TODECOINS_BIRTHDAY_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_birthday_coin_loot");
    public static final ResourceLocation TODECOINS_HALLOWEEN_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_halloween_coin_loot");
    public static final ResourceLocation TODECOINS_CHRISTMAS_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_christmas_coin_loot");
    public static final ResourceLocation TODECOINS_ANNIVERSARY_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_anniversary_coin_loot");
    public static final ResourceLocation TODECOINS_SPRING_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_spring_coin_loot");
    public static final ResourceLocation TODECOINS_SUMMER_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_summer_coin_loot");
    public static final ResourceLocation TODECOINS_AUTUMN_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_autumn_coin_loot");
    public static final ResourceLocation TODECOINS_WINTER_COIN_LOOT = register(MODID + ":" + "chests/collectible/seasonal/todecoins_winter_coin_loot");

    // entity specific collectible coin chest loot tables
    public static final ResourceLocation TODECOINS_ALLAY_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_allay_coin_loot");
    public static final ResourceLocation TODECOINS_AXOLOTL_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_axolotl_coin_loot");
    public static final ResourceLocation TODECOINS_BAT_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_bat_coin_loot");
    public static final ResourceLocation TODECOINS_BEE_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_bee_coin_loot");
    public static final ResourceLocation TODECOINS_BLAZE_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_blaze_coin_loot");
    public static final ResourceLocation TODECOINS_CAMEL_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_camel_coin_loot");
    public static final ResourceLocation TODECOINS_CAT_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_cat_coin_loot");
    public static final ResourceLocation TODECOINS_CAVE_SPIDER_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_cave_spider_coin_loot");
    public static final ResourceLocation TODECOINS_CHICKEN_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_chicken_coin_loot");
    public static final ResourceLocation TODECOINS_COD_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_cod_coin_loot");
    public static final ResourceLocation TODECOINS_ENDERMAN_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_enderman_coin_loot");
    public static final ResourceLocation TODECOINS_OCELOT_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_ocelot_coin_loot");
    public static final ResourceLocation TODECOINS_PIGLIN_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_piglin_coin_loot");
    public static final ResourceLocation TODECOINS_PUFFERFISH_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_pufferfish_coin_loot");
    public static final ResourceLocation TODECOINS_SALMON_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_salmon_coin_loot");
    public static final ResourceLocation TODECOINS_TROPICAL_FISH_COIN_LOOT = register(MODID + ":" + "chests/collectible/entity/todecoins_tropical_fish_coin_loot");

    // injected chest loot table
    public static final ResourceLocation TODECOINS_CHEST_LOOT = register(MODID + ":" + "chests/todecoins_chest");

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
    public static final ResourceLocation PIGLIN_EVENT_BARTER_LOOT = register(MODID + ":" + "gameplay/bartering/piglin_event_barter_loot");

    // injected currency entity drop loot table
    public static final ResourceLocation TODECOINS_CURRENCY_DROPS = register(MODID + ":" + "entity/todecoins_currency_drops");

    // base currency entity drop loot tables - added to the master table
    public static final ResourceLocation TODECOINS_COPPER_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_copper_coin_drops");
    public static final ResourceLocation TODECOINS_IRON_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_iron_coin_drops");
    public static final ResourceLocation TODECOINS_GOLD_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_gold_coin_drops");
    public static final ResourceLocation TODECOINS_NETHERITE_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_netherite_coin_drops");
    public static final ResourceLocation TODECOINS_NETHER_GOLD_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_nether_gold_coin_drops");
    public static final ResourceLocation TODECOINS_EMERALD_QUARTER_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_emerald_quarter_bank_note_drops");
    public static final ResourceLocation TODECOINS_EMERALD_HALF_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_emerald_half_bank_note_drops");
    public static final ResourceLocation TODECOINS_EMERALD_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_emerald_bank_note_drops");
    public static final ResourceLocation TODECOINS_LUCKY_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_lucky_coin_drops");

    // injected boss specific currency entity drop loot table
    public static final ResourceLocation TODECOINS_BOSS_CURRENCY_DROPS = register(MODID + ":" + "entity/todecoins_boss_currency_drops");

    // base boss specific currency entity drop loot tables - added to the master table
    public static final ResourceLocation TODECOINS_BOSS_COPPER_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_copper_coin_drops");
    public static final ResourceLocation TODECOINS_BOSS_IRON_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_copper_iron_drops");
    public static final ResourceLocation TODECOINS_BOSS_GOLD_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_gold_coin_drops");
    public static final ResourceLocation TODECOINS_BOSS_NETHERITE_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_netherite_coin_drops");
    public static final ResourceLocation TODECOINS_BOSS_NETHER_GOLD_COIN_DROPS = register(MODID + ":" + "entity/coins/todecoins_boss_nether_gold_coin_drops");
    public static final ResourceLocation TODECOINS_BOSS_EMERALD_QUARTER_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_boss_emerald_quarter_bank_note_drops");
    public static final ResourceLocation TODECOINS_BOSS_EMERALD_HALF_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_boss_emerald_half_bank_note_drops");
    public static final ResourceLocation TODECOINS_BOSS_EMERALD_BANK_NOTE_DROPS = register(MODID + ":" + "entity/notes/todecoins_boss_emerald_bank_note_drops");

    // entity specific collectible coin drop loot tables - added to the master tables
    public static final ResourceLocation TODECOINS_ALLAY_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_allay_coin_drops");
    public static final ResourceLocation TODECOINS_AXOLOTL_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_axolotl_coin_drops");
    public static final ResourceLocation TODECOINS_BAT_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_bat_coin_drops");
    public static final ResourceLocation TODECOINS_BEE_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_bee_coin_drops");
    public static final ResourceLocation TODECOINS_BLAZE_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_blaze_coin_drops");
    public static final ResourceLocation TODECOINS_CAMEL_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_camel_coin_drops");
    public static final ResourceLocation TODECOINS_CAT_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_cat_coin_drops");
    public static final ResourceLocation TODECOINS_CAVE_SPIDER_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_cave_spider_coin_drops");
    public static final ResourceLocation TODECOINS_CHICKEN_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_chicken_coin_drops");
    public static final ResourceLocation TODECOINS_COD_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_cod_coin_drops");
    public static final ResourceLocation TODECOINS_ENDERMAN_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_enderman_coin_drops");
    public static final ResourceLocation TODECOINS_OCELOT_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_ocelot_coin_drops");
    public static final ResourceLocation TODECOINS_PIGLIN_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_piglin_coin_drops");
    public static final ResourceLocation TODECOINS_PUFFERFISH_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_pufferfish_coin_drops");
    public static final ResourceLocation TODECOINS_SALMON_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_salmon_coin_drops");
    public static final ResourceLocation TODECOINS_TROPICAL_FISH_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_tropical_fish_coin_drops");

    // event dependent collectible coin entity drop loot tables - added to the master tables
    public static final ResourceLocation TODECOINS_HALLOWEEN_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_halloween_coin_drops");
    public static final ResourceLocation TODECOINS_BIRTHDAY_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_birthday_coin_drops");
    public static final ResourceLocation TODECOINS_CHRISTMAS_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_christmas_coin_drops");
    public static final ResourceLocation TODECOINS_ANNIVERSARY_COIN_DROPS = register(MODID + ":" + "entity/collectible/todecoins_anniversary_coin_drops");

    private static ResourceLocation register(String path) {
        return register(new ResourceLocation(path));
    }

    private static ResourceLocation register(ResourceLocation path) {
        if (LOCATIONS.add(path)) {
            return path;
        } else {
            throw new IllegalArgumentException(path + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}