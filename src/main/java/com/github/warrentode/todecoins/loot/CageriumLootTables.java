package com.github.warrentode.todecoins.loot;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class CageriumLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);


    public static final ResourceLocation ALLAY = register("minecraft", "allay");
    public static final ResourceLocation AXOLOTL = register("minecraft", "axolotl");
    public static final ResourceLocation BAT = register("minecraft", "bat");
    public static final ResourceLocation BEE = register("minecraft", "bee");
    public static final ResourceLocation BLAZE = register("minecraft", "blaze");
    public static final ResourceLocation CAT = register("minecraft", "cat");
    public static final ResourceLocation CAVE_SPIDER = register("minecraft", "cave_spider");
    public static final ResourceLocation CHICKEN = register("minecraft", "chicken");
    public static final ResourceLocation COD = register("minecraft", "cod");
    public static final ResourceLocation COW = register("minecraft", "cow");
    public static final ResourceLocation CREEPER = register("minecraft", "creeper");
    public static final ResourceLocation DOLPHIN = register("minecraft", "dolphin");
    public static final ResourceLocation DONKEY = register("minecraft", "donkey");
    public static final ResourceLocation DROWNED = register("minecraft", "drowned");
    public static final ResourceLocation ELDER_GUARDIAN = register("minecraft", "elder_guardian");
    public static final ResourceLocation ENDER_DRAGON = register("minecraft", "ender_dragon");
    public static final ResourceLocation ENDERMAN = register("minecraft", "enderman");
    public static final ResourceLocation ENDERMITE = register("minecraft", "endermite");
    public static final ResourceLocation EVOKER = register("minecraft", "evoker");
    public static final ResourceLocation FOX = register("minecraft", "fox");
    public static final ResourceLocation FROG = register("minecraft", "frog");
    public static final ResourceLocation GHAST = register("minecraft", "ghast");
    public static final ResourceLocation GLOW_SQUID = register("minecraft", "glow_squid");
    public static final ResourceLocation GOAT = register("minecraft", "goat");
    public static final ResourceLocation GUARDIAN = register("minecraft", "guardian");
    public static final ResourceLocation HORSE = register("minecraft", "horse");
    public static final ResourceLocation HUSK = register("minecraft", "husk");
    public static final ResourceLocation RAVAGER = register("minecraft", "ravager");
    public static final ResourceLocation ILLUSIONER = register("minecraft", "illusioner");
    public static final ResourceLocation IRON_GOLEM = register("minecraft", "iron_golem");
    public static final ResourceLocation LLAMA = register("minecraft", "llama");
    public static final ResourceLocation MAGMA_CUBE = register("minecraft", "magma_cube");
    public static final ResourceLocation MULE = register("minecraft", "mule");
    public static final ResourceLocation MOOSHROOM = register("minecraft", "mooshroom");
    public static final ResourceLocation OCELOT = register("minecraft", "ocelot");
    public static final ResourceLocation PANDA = register("minecraft", "panda");
    public static final ResourceLocation PARROT = register("minecraft", "parrot");
    public static final ResourceLocation PHANTOM = register("minecraft", "phantom");
    public static final ResourceLocation PIG = register("minecraft", "pig");
    public static final ResourceLocation PILLAGER = register("minecraft", "pillager");
    public static final ResourceLocation POLAR_BEAR = register("minecraft", "polar_bear");
    public static final ResourceLocation PUFFERFISH = register("minecraft", "pufferfish");
    public static final ResourceLocation RABBIT = register("minecraft", "rabbit");
    public static final ResourceLocation SALMON = register("minecraft", "salmon");
    public static final ResourceLocation SHEEP = register("minecraft", "sheep");
    public static final ResourceLocation SHEEP_BLACK = register("minecraft", "sheep_black");
    public static final ResourceLocation SHEEP_BLUE = register("minecraft", "sheep_blue");
    public static final ResourceLocation SHEEP_BROWN = register("minecraft", "sheep_brown");
    public static final ResourceLocation SHEEP_CYAN = register("minecraft", "sheep_cyan");
    public static final ResourceLocation SHEEP_GRAY = register("minecraft", "sheep_gray");
    public static final ResourceLocation SHEEP_GREEN = register("minecraft", "sheep_green");
    public static final ResourceLocation SHEEP_LIGHT_BLUE = register("minecraft", "sheep_light_blue");
    public static final ResourceLocation SHEEP_LIGHT_GRAY = register("minecraft", "sheep_light_gray");
    public static final ResourceLocation SHEEP_LIME = register("minecraft", "sheep_lime");
    public static final ResourceLocation SHEEP_MAGENTA = register("minecraft", "sheep_magenta");
    public static final ResourceLocation SHEEP_ORANGE = register("minecraft", "sheep_orange");
    public static final ResourceLocation SHEEP_PINK = register("minecraft", "sheep_pink");
    public static final ResourceLocation SHEEP_PURPLE = register("minecraft", "sheep_purple");
    public static final ResourceLocation SHEEP_RED = register("minecraft", "sheep_red");
    public static final ResourceLocation SHEEP_WHITE = register("minecraft", "sheep_white");
    public static final ResourceLocation SHEEP_YELLOW = register("minecraft", "sheep_yellow");
    public static final ResourceLocation SHULKER = register("minecraft", "shulker");
    public static final ResourceLocation SILVERFISH = register("minecraft", "silverfish");
    public static final ResourceLocation SKELETON = register("minecraft", "skeleton");
    public static final ResourceLocation SKELETON_HORSE = register("minecraft", "skeleton_horse");
    public static final ResourceLocation SLIME = register("minecraft", "slime");
    public static final ResourceLocation SNOW_GOLEM = register("minecraft", "snow_golem");
    public static final ResourceLocation SPIDER = register("minecraft", "spider");
    public static final ResourceLocation SQUID = register("minecraft", "squid");
    public static final ResourceLocation STRAY = register("minecraft", "stray");
    public static final ResourceLocation STRIDER = register("minecraft", "strider");
    public static final ResourceLocation TADPOLE = register("minecraft", "tadpole");
    public static final ResourceLocation TRADER_LLAMA = register("minecraft", "trader_llama");
    public static final ResourceLocation TROPICAL_FISH = register("minecraft", "tropical_fish");
    public static final ResourceLocation TURTLE = register("minecraft", "turtle");
    public static final ResourceLocation VEX = register("minecraft", "vex");
    public static final ResourceLocation VILLAGER = register("minecraft", "villager");
    public static final ResourceLocation WARDEN = register("minecraft", "warden");
    public static final ResourceLocation WANDERING_TRADER = register("minecraft", "wandering_trader");
    public static final ResourceLocation VINDICATOR = register("minecraft", "vindicator");
    public static final ResourceLocation WITCH = register("minecraft", "witch");
    public static final ResourceLocation WITHER = register("minecraft", "wither");
    public static final ResourceLocation WITHER_SKELETON = register("minecraft", "wither_skeleton");
    public static final ResourceLocation WOLF = register("minecraft", "wolf");
    public static final ResourceLocation ZOGLIN = register("minecraft", "zoglin");
    public static final ResourceLocation ZOMBIE = register("minecraft", "zombie");
    public static final ResourceLocation ZOMBIE_HORSE = register("minecraft", "zombie_horse");
    public static final ResourceLocation ZOMBIFIED_PIGLIN = register("minecraft", "zombified_piglin");
    public static final ResourceLocation HOGLIN = register("minecraft", "hoglin");
    public static final ResourceLocation PIGLIN = register("minecraft", "piglin");
    public static final ResourceLocation PIGLIN_BRUTE = register("minecraft", "piglin_brute");
    public static final ResourceLocation ZOMBIE_VILLAGER = register("minecraft", "zombie_villager");
    public static final ResourceLocation NUMISMATIST = register("todecoins", "numismatist");

    private static ResourceLocation register(String modid, String entity) {
        return register(new ResourceLocation(modid, "cagerium/" + entity));
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