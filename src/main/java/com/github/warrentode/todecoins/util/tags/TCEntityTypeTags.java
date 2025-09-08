package com.github.warrentode.todecoins.util.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class TCEntityTypeTags {
    public static final TagKey<EntityType<?>> DROPS_CURRENCY_BLACKLIST = entityTypeTag("forge","drops_currency_blacklist");
    public static final TagKey<EntityType<?>> DROPS_COLLECTIBLE_COIN_BLACKLIST = entityTypeTag("forge","drops_collectible_coin_blacklist");

    public static final TagKey<EntityType<?>> BOSSES = entityTypeTag("cagerium","bosses");
    public static final TagKey<EntityType<?>> CAGERIUM_BLACKLIST = entityTypeTag("cagerium","cagerium_blacklist");

    public static final TagKey<EntityType<?>> KNOWN_ENTITIES = entityTypeTag("forge", "known_entities");

    public static final TagKey<EntityType<?>> ILLAGERS = entityTypeTag("forge", "illagers");
    public static final TagKey<EntityType<?>> ZOMBIES = entityTypeTag("forge", "zombies");

    public static final TagKey<EntityType<?>> ALLAY_TYPES = entityTypeTag("forge", "allay");
    public static final TagKey<EntityType<?>> ARMAIDLLO_TYPES = entityTypeTag("forge", "armadillo");
    public static final TagKey<EntityType<?>> AXOLOTL_TYPES = entityTypeTag("forge", "axolotl");
    public static final TagKey<EntityType<?>> BAT_TYPES = entityTypeTag("forge", "bat");
    public static final TagKey<EntityType<?>> BEE_TYPES = entityTypeTag("forge", "bee");
    public static final TagKey<EntityType<?>> BLAZE_TYPES = entityTypeTag("forge", "blaze");
    public static final TagKey<EntityType<?>> CAMEL_TYPES = entityTypeTag("forge", "camel");
    public static final TagKey<EntityType<?>> CAT_TYPES = entityTypeTag("forge", "cat");
    public static final TagKey<EntityType<?>> CAVE_SPIDER_TYPES = entityTypeTag("forge", "cave_spider");
    public static final TagKey<EntityType<?>> CHICKEN_TYPES = entityTypeTag("forge", "chicken");
    public static final TagKey<EntityType<?>> COD_TYPES = entityTypeTag("forge", "cod");
    public static final TagKey<EntityType<?>> COW_TYPES = entityTypeTag("forge", "cow");
    public static final TagKey<EntityType<?>> CREEPER_TYPES = entityTypeTag("forge", "creeper");
    public static final TagKey<EntityType<?>> DOLPHIN_TYPES = entityTypeTag("forge", "dolphin");
    public static final TagKey<EntityType<?>> DONKEY_TYPES = entityTypeTag("forge", "donkey");
    public static final TagKey<EntityType<?>> DROWNED_TYPES = entityTypeTag("forge", "drowned");
    public static final TagKey<EntityType<?>> ELDER_GUARDIAN_TYPES = entityTypeTag("forge", "elder_guardian");
    public static final TagKey<EntityType<?>> ENDER_DRAGON_TYPES = entityTypeTag("forge", "ender_dragon");
    public static final TagKey<EntityType<?>> ENDERMAN_TYPES = entityTypeTag("forge", "enderman");
    public static final TagKey<EntityType<?>> ENDERMITES_TYPES = entityTypeTag("forge", "endermites");
    public static final TagKey<EntityType<?>> EVOKER_TYPES = entityTypeTag("forge", "evoker");
    public static final TagKey<EntityType<?>> FOX_TYPES = entityTypeTag("forge", "fox");
    public static final TagKey<EntityType<?>> FROG_TYPES = entityTypeTag("forge", "frog");
    public static final TagKey<EntityType<?>> GHAST_TYPES = entityTypeTag("forge", "ghast");
    public static final TagKey<EntityType<?>> GIANT_TYPES = entityTypeTag("forge", "giant");
    public static final TagKey<EntityType<?>> GLOW_SQUID_TYPES = entityTypeTag("forge", "glow_squid");
    public static final TagKey<EntityType<?>> GOAT_TYPES = entityTypeTag("forge", "goat");
    public static final TagKey<EntityType<?>> GUARDIAN_TYPES = entityTypeTag("forge", "guardian");
    public static final TagKey<EntityType<?>> HORSE_TYPES = entityTypeTag("forge", "horse");
    public static final TagKey<EntityType<?>> HUSK_TYPES = entityTypeTag("forge", "husk");
    public static final TagKey<EntityType<?>> ILLUSIONER_TYPES = entityTypeTag("forge", "illusioner");
    public static final TagKey<EntityType<?>> IRON_GOLEM_TYPES = entityTypeTag("forge", "iron_golem");
    public static final TagKey<EntityType<?>> LLAMA_TYPES = entityTypeTag("forge", "llama");
    public static final TagKey<EntityType<?>> MAGMA_CUBE_TYPES = entityTypeTag("forge", "magma_cube");
    public static final TagKey<EntityType<?>> MULE_TYPES = entityTypeTag("forge", "mule");
    public static final TagKey<EntityType<?>> MOOSHROOM_TYPES = entityTypeTag("forge", "mooshroom");
    public static final TagKey<EntityType<?>> OCELOT_TYPES = entityTypeTag("forge", "ocelot");
    public static final TagKey<EntityType<?>> NUMISMATIST_TYPES = entityTypeTag("forge", "numismatist");
    public static final TagKey<EntityType<?>> PANDA_TYPES = entityTypeTag("forge", "panda");
    public static final TagKey<EntityType<?>> PARROT_TYPES = entityTypeTag("forge", "parrot");
    public static final TagKey<EntityType<?>> PHANTOM_TYPES = entityTypeTag("forge", "phantom");
    public static final TagKey<EntityType<?>> PIG_TYPES = entityTypeTag("forge", "pig");
    public static final TagKey<EntityType<?>> PIGLIN_TYPES = entityTypeTag("forge", "piglin");
    public static final TagKey<EntityType<?>> PILLAGER_TYPES = entityTypeTag("forge", "pillager");
    public static final TagKey<EntityType<?>> POLAR_BEAR_TYPES = entityTypeTag("forge", "polar_bear");
    public static final TagKey<EntityType<?>> PUFFERFISH_TYPES = entityTypeTag("forge", "pufferfish");
    public static final TagKey<EntityType<?>> RABBIT_TYPES = entityTypeTag("forge", "rabbit");
    public static final TagKey<EntityType<?>> RAVAGER_TYPES = entityTypeTag("forge", "ravager");
    public static final TagKey<EntityType<?>> SALMON_TYPES = entityTypeTag("forge", "salmon");
    public static final TagKey<EntityType<?>> SHEEP_TYPES = entityTypeTag("forge", "sheep");
    public static final TagKey<EntityType<?>> SHULKER_TYPES = entityTypeTag("forge", "shulker");
    public static final TagKey<EntityType<?>> SILVERFISH_TYPES = entityTypeTag("forge", "silverfish");
    public static final TagKey<EntityType<?>> SKELETON_TYPES = entityTypeTag("forge", "skeleton");
    public static final TagKey<EntityType<?>> SKELETON_HORSE_TYPES = entityTypeTag("forge", "skeleton_horse");
    public static final TagKey<EntityType<?>> SLIME_TYPES = entityTypeTag("forge", "slime");
    public static final TagKey<EntityType<?>> SNIFFER_TYPES = entityTypeTag("forge", "sniffer");
    public static final TagKey<EntityType<?>> SNOW_GOLEM_TYPES = entityTypeTag("forge", "snow_golem");
    public static final TagKey<EntityType<?>> SPIDER_TYPES = entityTypeTag("forge", "spider");
    public static final TagKey<EntityType<?>> SQUID_TYPES = entityTypeTag("forge", "squid");
    public static final TagKey<EntityType<?>> STRAY_TYPES = entityTypeTag("forge", "stray");
    public static final TagKey<EntityType<?>> STRIDER_TYPES = entityTypeTag("forge", "strider");
    public static final TagKey<EntityType<?>> TADPOLE_TYPES = entityTypeTag("forge", "tadpole");
    public static final TagKey<EntityType<?>> TRADER_LLAMA_TYPES = entityTypeTag("forge", "trader_llama");
    public static final TagKey<EntityType<?>> TROPICAL_FISH_TYPES = entityTypeTag("forge", "tropical_fish");
    public static final TagKey<EntityType<?>> TURTLE_TYPES = entityTypeTag("forge", "turtle");
    public static final TagKey<EntityType<?>> VEX_TYPES = entityTypeTag("forge", "vex");
    public static final TagKey<EntityType<?>> VILLAGER_TYPES = entityTypeTag("forge", "villager");
    public static final TagKey<EntityType<?>> VINDICATOR_TYPES = entityTypeTag("forge", "vindicator");
    public static final TagKey<EntityType<?>> WARDEN_TYPES = entityTypeTag("forge", "warden");
    public static final TagKey<EntityType<?>> WANDERING_TRADER_TYPES = entityTypeTag("forge", "wandering_trader");
    public static final TagKey<EntityType<?>> WITCH_TYPES = entityTypeTag("forge", "witch");
    public static final TagKey<EntityType<?>> WITHER_TYPES = entityTypeTag("forge", "wither");
    public static final TagKey<EntityType<?>> WITHER_SKELETON_TYPES = entityTypeTag("forge", "wither_skeleton");
    public static final TagKey<EntityType<?>> WOLF_TYPES = entityTypeTag("forge", "wolf");
    public static final TagKey<EntityType<?>> ZOGLIN_TYPES = entityTypeTag("forge", "zoglin");
    public static final TagKey<EntityType<?>> ZOMBIE_TYPES = entityTypeTag("forge", "zombie");
    public static final TagKey<EntityType<?>> ZOMBIE_HORSE_TYPES = entityTypeTag("forge", "zombie_horse");
    public static final TagKey<EntityType<?>> ZOMBIFIED_PIGLIN_TYPES = entityTypeTag("forge", "zombified_piglin");
    public static final TagKey<EntityType<?>> HOGLIN_TYPES = entityTypeTag("forge", "hoglin");
    public static final TagKey<EntityType<?>> PIGLIN_BRUTE_TYPES = entityTypeTag("forge", "piglin_brute");
    public static final TagKey<EntityType<?>> PIGLIN_MERCHANT_TYPES = entityTypeTag("forge", "piglin_merchant");
    public static final TagKey<EntityType<?>> ZOMBIE_VILLAGER_TYPES = entityTypeTag("forge", "zombie_villager");

    // friends and foes
    public static final TagKey<EntityType<?>> COPPER_GOLEM_TYPES = entityTypeTag("forge", "copper_golem");
    public static final TagKey<EntityType<?>> GLARE_TYPES = entityTypeTag("forge", "glare");
    public static final TagKey<EntityType<?>> ICEOLOGER_TYPES = entityTypeTag("forge", "iceologer");
    public static final TagKey<EntityType<?>> MAULER_TYPES = entityTypeTag("forge", "mauler");
    public static final TagKey<EntityType<?>> MOOBLOOM_TYPES = entityTypeTag("forge", "moobloom");
    public static final TagKey<EntityType<?>> TUFF_GOLEM_TYPES = entityTypeTag("forge", "tuff_golem");
    public static final TagKey<EntityType<?>> WILDFIRE_TYPES = entityTypeTag("forge", "wildfire");
    public static final TagKey<EntityType<?>> RASCAL_TYPES = entityTypeTag("forge", "rascal");

    // ecologics
    public static final TagKey<EntityType<?>> CRAB_TYPES = entityTypeTag("forge", "crab");
    public static final TagKey<EntityType<?>> SQUIRREL_TYPES = entityTypeTag("forge", "squirrel");
    public static final TagKey<EntityType<?>> PENGUIN_TYPES = entityTypeTag("forge", "penguin");

    // guard villagers
    public static final TagKey<EntityType<?>> GUARD_TYPES = entityTypeTag("forge", "guard");

    // vanilla sneak peek
    public static final TagKey<EntityType<?>> BREEZE_TYPES = entityTypeTag("forge", "breeze");
    public static final TagKey<EntityType<?>> BOGGED_TYPES = entityTypeTag("forge", "bogged");
    public static final TagKey<EntityType<?>> CREAKING_TYPES = entityTypeTag("forge", "creeking");
    public static final TagKey<EntityType<?>> HAPPY_GHAST_TYPES = entityTypeTag("forge", "happy_ghast");

    private static TagKey<EntityType<?>> entityTypeTag(String modid, String path) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse(modid + ":" + path));
    }
}