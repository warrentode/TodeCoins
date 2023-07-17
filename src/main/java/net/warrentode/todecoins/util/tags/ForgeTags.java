package net.warrentode.todecoins.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class ForgeTags {
    public static class EntityTypes {
        public static final TagKey<EntityType<?>> BOSSES = forgeEntityTypeTag("bosses");
        public static final TagKey<EntityType<?>> DROPS_CURRENCY = forgeEntityTypeTag("drops_currency");
        public static final TagKey<EntityType<?>> ILLAGERS = forgeEntityTypeTag("illagers");

        public static final TagKey<EntityType<?>> ALLAY_TYPES = forgeEntityTypeTag("allay");
        public static final TagKey<EntityType<?>> AXOLOTL_TYPES = forgeEntityTypeTag("axolotl");
        public static final TagKey<EntityType<?>> BAT_TYPES = forgeEntityTypeTag("bat");
        public static final TagKey<EntityType<?>> BEE_TYPES = forgeEntityTypeTag("bee");
        public static final TagKey<EntityType<?>> BLAZE_TYPES = forgeEntityTypeTag("blaze");
        public static final TagKey<EntityType<?>> CAMEL_TYPES = forgeEntityTypeTag("camel");
        public static final TagKey<EntityType<?>> CAT_TYPES = forgeEntityTypeTag("cat");
        public static final TagKey<EntityType<?>> CAVE_SPIDER_TYPES = forgeEntityTypeTag("cave_spider");
        public static final TagKey<EntityType<?>> CHICKEN_TYPES = forgeEntityTypeTag("chicken");
        public static final TagKey<EntityType<?>> COD_TYPES = forgeEntityTypeTag("cod");
        public static final TagKey<EntityType<?>> COW_TYPES = forgeEntityTypeTag("cow");
        public static final TagKey<EntityType<?>> CREEPER_TYPES = forgeEntityTypeTag("creeper");
        public static final TagKey<EntityType<?>> DOLPHIN_TYPES = forgeEntityTypeTag("dolphin");
        public static final TagKey<EntityType<?>> DONKEY_TYPES = forgeEntityTypeTag("donkey");
        public static final TagKey<EntityType<?>> DROWNED_TYPES = forgeEntityTypeTag("drowned");
        public static final TagKey<EntityType<?>> ELDER_GUARDIAN_TYPES = forgeEntityTypeTag("elder_guardian");
        public static final TagKey<EntityType<?>> ENDER_DRAGON_TYPES = forgeEntityTypeTag("ender_dragon");
        public static final TagKey<EntityType<?>> ENDERMAN_TYPES = forgeEntityTypeTag("enderman");
        public static final TagKey<EntityType<?>> ENDERMITES_TYPES = forgeEntityTypeTag("endermites");
        public static final TagKey<EntityType<?>> EVOKER_TYPES = forgeEntityTypeTag("evoker");
        public static final TagKey<EntityType<?>> FOX_TYPES = forgeEntityTypeTag("fox");
        public static final TagKey<EntityType<?>> FROG_TYPES = forgeEntityTypeTag("frog");
        public static final TagKey<EntityType<?>> GHAST_TYPES = forgeEntityTypeTag("ghast");
        public static final TagKey<EntityType<?>> GLOW_SQUID_TYPES = forgeEntityTypeTag("glow_squid");
        public static final TagKey<EntityType<?>> GOAT_TYPES = forgeEntityTypeTag("goat");
        public static final TagKey<EntityType<?>> GUARDIAN_TYPES = forgeEntityTypeTag("guardian");
        public static final TagKey<EntityType<?>> HORSE_TYPES = forgeEntityTypeTag("horse");
        public static final TagKey<EntityType<?>> HUSK_TYPES = forgeEntityTypeTag("husk");
        public static final TagKey<EntityType<?>> ILLUSIONER_TYPES = forgeEntityTypeTag("illusioner");
        public static final TagKey<EntityType<?>> IRON_GOLEM_TYPES = forgeEntityTypeTag("iron_golem");
        public static final TagKey<EntityType<?>> LLAMA_TYPES = forgeEntityTypeTag("llama");
        public static final TagKey<EntityType<?>> MAGMA_CUBE_TYPES = forgeEntityTypeTag("magma_cube");
        public static final TagKey<EntityType<?>> MULE_TYPES = forgeEntityTypeTag("mule");
        public static final TagKey<EntityType<?>> MOOBLOOM_TYPES = forgeEntityTypeTag("moobloom");
        public static final TagKey<EntityType<?>> MOOSHROOM_TYPES = forgeEntityTypeTag("mooshroom");
        public static final TagKey<EntityType<?>> OCELOT_TYPES = forgeEntityTypeTag("ocelot");
        public static final TagKey<EntityType<?>> NUMISMATIST_TYPES = forgeEntityTypeTag("numismatist");
        public static final TagKey<EntityType<?>> PANDA_TYPES = forgeEntityTypeTag("panda");
        public static final TagKey<EntityType<?>> PARROT_TYPES = forgeEntityTypeTag("parrot");
        public static final TagKey<EntityType<?>> PHANTOM_TYPES = forgeEntityTypeTag("phantom");
        public static final TagKey<EntityType<?>> PIG_TYPES = forgeEntityTypeTag("pig");
        public static final TagKey<EntityType<?>> PIGLIN_TYPES = forgeEntityTypeTag("piglin");
        public static final TagKey<EntityType<?>> PILLAGER_TYPES = forgeEntityTypeTag("pillager");
        public static final TagKey<EntityType<?>> POLAR_BEAR_TYPES = forgeEntityTypeTag("polar_bear");
        public static final TagKey<EntityType<?>> PUFFERFISH_TYPES = forgeEntityTypeTag("pufferfish");
        public static final TagKey<EntityType<?>> RABBIT_TYPES = forgeEntityTypeTag("rabbit");
        public static final TagKey<EntityType<?>> RAVAGER_TYPES = forgeEntityTypeTag("ravager");
        public static final TagKey<EntityType<?>> SALMON_TYPES = forgeEntityTypeTag("salmon");
        public static final TagKey<EntityType<?>> SHEEP_TYPES = forgeEntityTypeTag("sheep");
        public static final TagKey<EntityType<?>> SHULKER_TYPES = forgeEntityTypeTag("shulker");
        public static final TagKey<EntityType<?>> SNIFFER_TYPES = forgeEntityTypeTag("sniffer");
        public static final TagKey<EntityType<?>> SILVERFISH_TYPES = forgeEntityTypeTag("silverfish");
        public static final TagKey<EntityType<?>> SKELETON_TYPES = forgeEntityTypeTag("skeleton");
        public static final TagKey<EntityType<?>> SKELETON_HORSE_TYPES = forgeEntityTypeTag("skeleton_horse");
        public static final TagKey<EntityType<?>> SLIME_TYPES = forgeEntityTypeTag("slime");
        public static final TagKey<EntityType<?>> SNOW_GOLEM_TYPES = forgeEntityTypeTag("snow_golem");
        public static final TagKey<EntityType<?>> SPIDER_TYPES = forgeEntityTypeTag("spider");
        public static final TagKey<EntityType<?>> SQUID_TYPES = forgeEntityTypeTag("squid");
        public static final TagKey<EntityType<?>> STRAY_TYPES = forgeEntityTypeTag("stray");
        public static final TagKey<EntityType<?>> STRIDER_TYPES = forgeEntityTypeTag("strider");
        public static final TagKey<EntityType<?>> TADPOLE_TYPES = forgeEntityTypeTag("tadpole");
        public static final TagKey<EntityType<?>> TRADER_LLAMA_TYPES = forgeEntityTypeTag("trader_llama");
        public static final TagKey<EntityType<?>> TROPICAL_FISH_TYPES = forgeEntityTypeTag("tropical_fish");
        public static final TagKey<EntityType<?>> TURTLE_TYPES = forgeEntityTypeTag("turtle");
        public static final TagKey<EntityType<?>> VEX_TYPES = forgeEntityTypeTag("vex");
        public static final TagKey<EntityType<?>> VILLAGER_TYPES = forgeEntityTypeTag("villager");
        public static final TagKey<EntityType<?>> VINDICATOR_TYPES = forgeEntityTypeTag("vindicator");
        public static final TagKey<EntityType<?>> WARDEN_TYPES = forgeEntityTypeTag("warden");
        public static final TagKey<EntityType<?>> WANDERING_TRADER_TYPES = forgeEntityTypeTag("wandering_trader");
        public static final TagKey<EntityType<?>> WITCH_TYPES = forgeEntityTypeTag("witch");
        public static final TagKey<EntityType<?>> WITHER_TYPES = forgeEntityTypeTag("wither");
        public static final TagKey<EntityType<?>> WITHER_SKELETON_TYPES = forgeEntityTypeTag("wither_skeleton");
        public static final TagKey<EntityType<?>> WOLF_TYPES = forgeEntityTypeTag("wolf");
        public static final TagKey<EntityType<?>> ZOGLIN_TYPES = forgeEntityTypeTag("zoglin");
        public static final TagKey<EntityType<?>> ZOMBIE_TYPES = forgeEntityTypeTag("zombie");
        public static final TagKey<EntityType<?>> ZOMBIE_HORSE_TYPES = forgeEntityTypeTag("zombie_horse");
        public static final TagKey<EntityType<?>> ZOMBIFIED_PIGLIN_TYPES = forgeEntityTypeTag("zombified_piglin");
        public static final TagKey<EntityType<?>> HOGLIN_TYPES = forgeEntityTypeTag("hoglin");
        public static final TagKey<EntityType<?>> PIGLIN_BRUTE_TYPES = forgeEntityTypeTag("piglin_brute");
        public static final TagKey<EntityType<?>> ZOMBIE_VILLAGER_TYPES = forgeEntityTypeTag("zombie_villager");
    }

    public static class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS = forgeBlockTag("storage_blocks");
        public static final TagKey<Block> CURRENCY_BLOCKS = forgeBlockTag("storage_blocks/currency_blocks");
    }

    public static class Items {
        public static final TagKey<Item> BANKNOTES = forgeItemTag("banknotes");
        public static final TagKey<Item> COINS = forgeItemTag("coins");
        public static final TagKey<Item> CURRENCY = forgeItemTag("currency");
        public static final TagKey<Item> CURRENCY_MATERIALS = forgeItemTag("currency_materials");
        public static final TagKey<Item> CURRENCY_STAMPS = forgeItemTag("currency_stamps");

        public static final TagKey<Item> PIGLIN_BARTER_ITEMS = forgeItemTag("piglin_barter_items");

        public static final TagKey<Item> TEXTILES = forgeItemTag("textiles");
        public static final TagKey<Item> BARK = forgeItemTag("textiles/bark");
        public static final TagKey<Item> FIBRE = forgeItemTag("textiles/fibre");
        public static final TagKey<Item> STRING = forgeItemTag("textiles/string");
        public static final TagKey<Item> PAPER = forgeItemTag("textiles/paper");
        public static final TagKey<Item> FABRIC = forgeItemTag("textiles/fabric");
        public static final TagKey<Item> THREAD = forgeItemTag("textiles/thread");
        public static final TagKey<Item> CURRENCY_FIBER = forgeItemTag("textiles/currency_fiber");
        public static final TagKey<Item> CURRENCY_PAPER = forgeItemTag("textiles/currency_paper");

        public static final TagKey<Item> GEMS = forgeItemTag("gems");
        public static final TagKey<Item> AMETHYST = forgeItemTag("gems/amethyst");
        public static final TagKey<Item> DIAMOND = forgeItemTag("gems/diamond");
        public static final TagKey<Item> ECHO_SHARD = forgeItemTag("gems/echo_shard");
        public static final TagKey<Item> EMERALD = forgeItemTag("gems/emerald");
        public static final TagKey<Item> END_CRYSTAL = forgeItemTag("gems/end_crystal");
        public static final TagKey<Item> ENDER_EYE = forgeItemTag("gems/ender_eye");
        public static final TagKey<Item> ENDER_PEARL = forgeItemTag("gems/ender_pearl");
        public static final TagKey<Item> GLOWSTONE = forgeItemTag("gems/glowstone");
        public static final TagKey<Item> LAPIS_LAZULI = forgeItemTag("gems/lapis_lazuli");
        public static final TagKey<Item> NETHER_STAR = forgeItemTag("gems/nether_star");
        public static final TagKey<Item> PRISMARINE = forgeItemTag("gems/prismarine");
        public static final TagKey<Item> QUARTZ = forgeItemTag("gems/quartz");
        public static final TagKey<Item> REDSTONE = forgeItemTag("gems/redstone");

        public static final TagKey<Item> NUGGETS = forgeItemTag("nuggets");
        public static final TagKey<Item> COPPER_NUGGET = forgeItemTag("nuggets/copper");
        public static final TagKey<Item> IRON_NUGGET = forgeItemTag("nuggets/iron");
        public static final TagKey<Item> GOLD_NUGGET = forgeItemTag("nuggets/gold");
        public static final TagKey<Item> LUCKY_NUGGET = forgeItemTag("nuggets/lucky");
        public static final TagKey<Item> NETHERITE_NUGGET = forgeItemTag("nuggets/netherite");

        public static final TagKey<Item> INGOTS = forgeItemTag("ingots");
        public static final TagKey<Item> COPPER_INGOT = forgeItemTag("ingots/copper");
        public static final TagKey<Item> IRON_INGOT = forgeItemTag("ingots/iron");
        public static final TagKey<Item> GOLD_INGOT = forgeItemTag("ingots/gold");
        public static final TagKey<Item> NETHERITE_INGOT = forgeItemTag("ingots/netherite");
    }

    public interface StructureTags {
        TagKey<Structure> ON_ANCIENT_CITY_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_BASTION_REMNANT_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_DESERT_PYRAMID_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_END_CITY_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_IGLOO_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_JUNGLE_TEMPLE_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_MINESHAFT_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_NETHER_FORTRESS_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_NETHER_FOSSIL_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_NETHER_RUINED_PORTAL_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_OCEAN_RUIN_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_OVERWORLD_RUINED_PORTAL_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_PILLAGER_OUTPOST_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_SHIPWRECK_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_STRONGHOLD_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_SWAMP_HUT_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
        TagKey<Structure> ON_VILLAGE_EXPLORER_MAPS = forgeStructureTag("worldgen/structure");
    }

    private static TagKey<EntityType<?>> forgeEntityTypeTag(String path) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge", path));
    }

    private static TagKey<Block> forgeBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge", path));
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", path));
    }

    private static TagKey<Structure> forgeStructureTag(String path) {
        return TagKey.create(Registry.STRUCTURE_REGISTRY, new ResourceLocation("forge", path));
    }
}