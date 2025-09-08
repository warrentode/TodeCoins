package com.github.warrentode.todecoins.util.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;

public class TCBiomeTags {
    // has flower/plant biomes
    public static final TagKey<Biome> HAS_SUNFLOWER = modBiomeTag("has_sunflower");
    public static final TagKey<Biome> HAS_PEONY = modBiomeTag("has_peony");
    public static final TagKey<Biome> HAS_ROSE_BUSH = modBiomeTag("has_rose_bush");
    public static final TagKey<Biome> HAS_LILAC = modBiomeTag("has_lilac");
    public static final TagKey<Biome> HAS_BUTTERCUP = modBiomeTag("has_buttercup");
    public static final TagKey<Biome> HAS_LILY_OF_THE_VALLEY = modBiomeTag("has_lily_of_the_valley");
    public static final TagKey<Biome> HAS_CORNFLOWER = modBiomeTag("has_cornflower");
    public static final TagKey<Biome> HAS_OXEYE_DAISY = modBiomeTag("has_oxeye_daisy");
    public static final TagKey<Biome> HAS_PINK_TULIP = modBiomeTag("has_pink_tulip");
    public static final TagKey<Biome> HAS_WHITE_TULIP = modBiomeTag("has_white_tulip");
    public static final TagKey<Biome> HAS_ORANGE_TULIP = modBiomeTag("has_orange_tulip");
    public static final TagKey<Biome> HAS_RED_TULIP = modBiomeTag("has_red_tulip");
    public static final TagKey<Biome> HAS_AZURE_BLUET = modBiomeTag("has_azure_bluet");
    public static final TagKey<Biome> HAS_ALLIUM = modBiomeTag("has_allium");
    public static final TagKey<Biome> HAS_BLUE_ORCHID = modBiomeTag("has_blue_orchid");
    public static final TagKey<Biome> HAS_GOLDENROD = modBiomeTag("has_goldenrod");
    public static final TagKey<Biome> HAS_WILDFLOWER = modBiomeTag("has_wildflower");
    public static final TagKey<Biome> HAS_CATTAIL = modBiomeTag("has_cattail");
    public static final TagKey<Biome> HAS_WILTED_LILY = modBiomeTag("has_wilted_lily");
    public static final TagKey<Biome> HAS_BLUE_HYDRANGEA = modBiomeTag("has_blue_hydrangea");
    public static final TagKey<Biome> HAS_PINK_HIBISCUS = modBiomeTag("has_pink_hibiscus");
    public static final TagKey<Biome> HAS_VIOLET = modBiomeTag("has_violet");
    public static final TagKey<Biome> HAS_ORANGE_COSMOS = modBiomeTag("has_orange_cosmos");
    public static final TagKey<Biome> HAS_ROSE = modBiomeTag("has_rose");
    public static final TagKey<Biome> HAS_WITHER_ROSE = modBiomeTag("has_wither_rose");
    public static final TagKey<Biome> HAS_GLOWFLOWER = modBiomeTag("has_glowflower");
    public static final TagKey<Biome> HAS_PINK_DAFFODIL = modBiomeTag("has_pink_daffodil");
    public static final TagKey<Biome> HAS_LAVENDER = modBiomeTag("has_lavender");
    public static final TagKey<Biome> HAS_WHITE_LAVENDER = modBiomeTag("has_white_lavender");
    public static final TagKey<Biome> HAS_ICY_IRIS = modBiomeTag("has_icy_iris");
    public static final TagKey<Biome> HAS_ENDBLOOM = modBiomeTag("has_endbloom");
    public static final TagKey<Biome> HAS_BURNING_BLOSSOM = modBiomeTag("has_burning_blossom");
    public static final TagKey<Biome> HAS_PURPLE_FLOWER = modBiomeTag("has_purple_flower");
    public static final TagKey<Biome> HAS_WHITE_FLOWER = modBiomeTag("has_white_flower");
    public static final TagKey<Biome> HAS_CLOVER = modBiomeTag("has_clover");

    // has log/sapling biomes
    public static final TagKey<Biome> HAS_SPRUCE = modBiomeTag("has_spruce");
    public static final TagKey<Biome> HAS_MANGROVE = modBiomeTag("has_mangrove");
    public static final TagKey<Biome> HAS_ACACIA = modBiomeTag("has_acacia");
    public static final TagKey<Biome> HAS_JUNGLE = modBiomeTag("has_jungle");
    public static final TagKey<Biome> HAS_BIRCH = modBiomeTag("has_birch");
    public static final TagKey<Biome> HAS_DARK_OAK = modBiomeTag("has_dark_oak");
    public static final TagKey<Biome> HAS_CHERRY = modBiomeTag("has_cherry");
    public static final TagKey<Biome> HAS_WARPED_FUNGUS = modBiomeTag("has_warped_fungus");
    public static final TagKey<Biome> HAS_CRIMSON_FUNGUS = modBiomeTag("has_crimson_fungus");
    public static final TagKey<Biome> HAS_FIR = modBiomeTag("has_fir");
    public static final TagKey<Biome> HAS_PINE = modBiomeTag("has_pine");
    public static final TagKey<Biome> HAS_REDWOOD = modBiomeTag("has_redwood");
    public static final TagKey<Biome> HAS_MAHOGANY = modBiomeTag("has_mahogany");
    public static final TagKey<Biome> HAS_JACARANDA = modBiomeTag("has_jacaranda");
    public static final TagKey<Biome> HAS_PALM = modBiomeTag("has_palm");
    public static final TagKey<Biome> HAS_WILLOW = modBiomeTag("has_willow");
    public static final TagKey<Biome> HAS_DEAD = modBiomeTag("has_dead");
    public static final TagKey<Biome> HAS_MAGIC = modBiomeTag("has_magic");
    public static final TagKey<Biome> HAS_UMBRAN = modBiomeTag("has_umbran");
    public static final TagKey<Biome> HAS_HELLBARK = modBiomeTag("has_hellbark");
    public static final TagKey<Biome> HAS_EMPYREAL = modBiomeTag("has_empyreal");
    public static final TagKey<Biome> HAS_COCONUT = modBiomeTag("has_coconut");
    public static final TagKey<Biome> HAS_AZALEA = modBiomeTag("has_azalea");
    public static final TagKey<Biome> HAS_CHORUS_NEST = modBiomeTag("has_chorus_nest");
    public static final TagKey<Biome> HAS_EBONY = modBiomeTag("has_ebony");
    public static final TagKey<Biome> HAS_PREAM = modBiomeTag("has_pream");
    public static final TagKey<Biome> HAS_AETHER_SKYROOT = modBiomeTag("has_aether_skyroot");
    public static final TagKey<Biome> HAS_GOLDEN_OAK = modBiomeTag("has_golden_oak");
    public static final TagKey<Biome> HAS_BLOODSHROOM = modBiomeTag("has_bloodshroom");
    public static final TagKey<Biome> HAS_ENDERBARK = modBiomeTag("has_enderbark");
    public static final TagKey<Biome> HAS_GREENHEART = modBiomeTag("has_greenheart");
    public static final TagKey<Biome> HAS_FLOWERING_OAK = modBiomeTag("has_flowering_oak");
    public static final TagKey<Biome> HAS_RAINBOW_BIRCH = modBiomeTag("has_rainbow_birch");
    public static final TagKey<Biome> HAS_ORIGIN = modBiomeTag("has_origin");
    public static final TagKey<Biome> HAS_RED_MAPLE = modBiomeTag("has_red_maple");
    public static final TagKey<Biome> HAS_YELLOW_MAPLE = modBiomeTag("has_yellow_maple");
    public static final TagKey<Biome> HAS_ORANGE_MAPLE = modBiomeTag("has_orange_maple");
    public static final TagKey<Biome> HAS_SNOWBLOSSOM = modBiomeTag("has_snowblossom");

    // has block biome
    public static final TagKey<Biome> HAS_SANDSTONE = modBiomeTag("has_sandstone");
    public static final TagKey<Biome> HAS_RED_SANDSTONE = modBiomeTag("has_red_sandstone");
    public static final TagKey<Biome> HAS_MOSSY_STONE = modBiomeTag("has_mossy_stone");
    public static final TagKey<Biome> HAS_MUD = modBiomeTag("has_mud");
    public static final TagKey<Biome> HAS_ENDONIAN_ORE = modBiomeTag("has_endonian_ore");

    // has entity biome
    public static final TagKey<Biome> HAS_PUFFERFISH = modBiomeTag("has_pufferfish");
    public static final TagKey<Biome> HAS_TROPICAL_FISH = modBiomeTag("has_tropical_fish");
    public static final TagKey<Biome> HAS_SALMON = modBiomeTag("has_salmon");
    public static final TagKey<Biome> HAS_FROGS = modBiomeTag("has_frogs");
    public static final TagKey<Biome> HAS_AXOLOTL = modBiomeTag("has_axolotl");

    // has structure biome
    public static final TagKey<Biome> HAS_RUINED_PORTALS = modBiomeTag("has_ruined_portals");
    public static final TagKey<Biome> HAS_LEPRECHAUN_WAGON = modBiomeTag("has_structure/leprechaun_wagon");

    // biome group
    public static final TagKey<Biome> NETHER_BIOMES = modBiomeTag("nether_biomes");
    public static final TagKey<Biome> END_BIOMES = modBiomeTag("end_biomes");


    private static @NotNull TagKey<Biome> modBiomeTag(String name) {
        return TagKey.create(Registries.BIOME, ResourceLocation.parse("forge:" + name));
    }
}