package net.warrentode.todecoins.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.jetbrains.annotations.NotNull;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS = modBlockTag("storage_blocks");
        public static final TagKey<Block> CURRENCY_BLOCKS = modBlockTag("storage_blocks/currency_blocks");
        public static final TagKey<Block> JOB_BLOCKS = modBlockTag("job_blocks");
        public static final TagKey<Block> DROPS_FOUR_LEAF_CLOVER = modBlockTag("drops_four_leaf_clover");
    }

    public static class Items {
        public static final TagKey<Item> WALLETS = modItemTag("wallets");
        public static final TagKey<Item> BUNDLES = modItemTag("bundles");
        public static final TagKey<Item> SHULKER_BOXES = modItemTag("shulker_boxes");

        public static final TagKey<Item> CURRENCY = modItemTag("currency");
        public static final TagKey<Item> BANKNOTES = modItemTag("currency/banknotes");
        public static final TagKey<Item> COINS = modItemTag("currency/coins");

        public static final TagKey<Item> CURRENCY_MATERIALS = modItemTag("currency_materials");
        public static final TagKey<Item> CURRENCY_STAMPS = modItemTag("currency_stamps");

        public static final TagKey<Item> COLLECTIBLE_COINS = modItemTag("collectible_coins");
        // holiday coins
        public static final TagKey<Item> HOLIDAY_COIN_SET = modItemTag("collectible_coins/holiday_coin_set");
        public static final TagKey<Item> BIRTHDAY_COIN_SET = modItemTag("collectible_coins/holiday_coins/birthday_coin_set");
        public static final TagKey<Item> CHRISTMAS_COIN_SET = modItemTag("collectible_coins/holiday_coins/christmas_coin_set");
        public static final TagKey<Item> HALLOWEEN_COIN_SET = modItemTag("collectible_coins/holiday_coins/halloween_coin_set");
        // sponsor perk coins
        public static final TagKey<Item> PATRON_COIN_SET = modItemTag("collectible_coins/patron_coin_set");
        public static final TagKey<Item> CARNATION_PATRON_COIN_SET = modItemTag("collectible_coins/patron_coins/carnation_patron_coin_set");
        public static final TagKey<Item> COSMOS_PATRON_COIN_SET = modItemTag("collectible_coins/patron_coins/cosmos_patron_coin_set");
        // gameplay coins
        public static final TagKey<Item> GAMEPLAY_COIN_SET = modItemTag("collectible_coins/gameplay_coin_set");
        public static final TagKey<Item> FISHING_COIN_SET = modItemTag("collectible_coins/gameplay_coins/fishing_coin_set");
        public static final TagKey<Item> HERO_COIN_SET = modItemTag("collectible_coins/gameplay_coins/hero_coin_set");
        //entity coins
        public static final TagKey<Item> ENTITY_COIN_SET = modItemTag("collectible_coins/entity_coin_set");
        public static final TagKey<Item> ALLAY_COIN_SET = modItemTag("collectible_coins/entity_coins/allay_coin_set");
        public static final TagKey<Item> AXOLOTL_COIN_SET = modItemTag("collectible_coins/entity_coins/axolotl_coin_set");
        public static final TagKey<Item> BAT_COIN_SET = modItemTag("collectible_coins/entity_coins/bat_coin_set");
        public static final TagKey<Item> BEE_COIN_SET = modItemTag("collectible_coins/entity_coins/bee_coin_set");
        public static final TagKey<Item> BLAZE_COIN_SET = modItemTag("collectible_coins/entity_coins/blaze_coin_set");
        public static final TagKey<Item> CAMEL_COIN_SET = modItemTag("collectible_coins/entity_coins/camel_coin_set");
        public static final TagKey<Item> CAT_COIN_SET = modItemTag("collectible_coins/entity_coins/cat_coin_set");
        public static final TagKey<Item> CAVE_SPIDER_COIN_SET = modItemTag("collectible_coins/entity_coins/cave_spider_coin_set");
        public static final TagKey<Item> CHICKEN_COIN_SET = modItemTag("collectible_coins/entity_coins/chicken_coin_set");
        public static final TagKey<Item> COD_COIN_SET = modItemTag("collectible_coins/entity_coins/cod_coin_set");
        public static final TagKey<Item> ENDERMAN_COIN_SET = modItemTag("collectible_coins/entity_coins/enderman_coin_set");
        public static final TagKey<Item> OCELOT_COIN_SET = modItemTag("collectible_coins/entity_coins/ocelot_coin_set");
        public static final TagKey<Item> PIGLIN_COIN_SET = modItemTag("collectible_coins/entity_coins/piglin_coin_set");
        public static final TagKey<Item> PUFFERFISH_COIN_SET = modItemTag("collectible_coins/entity_coins/pufferfish_coin_set");
        public static final TagKey<Item> SALMON_COIN_SET = modItemTag("collectible_coins/entity_coins/salmon_coin_set");
        public static final TagKey<Item> TROPICAL_FISH_COIN_SET = modItemTag("collectible_coins/entity_coins/tropical_fish_coin_set");

        public static final TagKey<Item> TEXTILES = modItemTag("textiles");
        public static final TagKey<Item> FIBRE = modItemTag("textiles/fibre");
        public static final TagKey<Item> FABRIC = modItemTag("textiles/fabric");
        public static final TagKey<Item> THREAD = modItemTag("textiles/thread");
        public static final TagKey<Item> CURRENCY_FIBER = modItemTag("textiles/currency_fiber");
        public static final TagKey<Item> CURRENCY_PAPER = modItemTag("textiles/currency_paper");

        public static final TagKey<Item> GEMS = modItemTag("gems");
        public static final TagKey<Item> SOUL_BINDER = modItemTag("soul_binder");
        public static final TagKey<Item> JAR_PLACEABLE = modItemTag("jar_placeable");

        public static final TagKey<Item> NUGGETS = modItemTag("nuggets");
        public static final TagKey<Item> COPPER_NUGGET = modItemTag("nuggets/copper");
        public static final TagKey<Item> IRON_NUGGET = modItemTag("nuggets/iron");
        public static final TagKey<Item> GOLD_NUGGET = modItemTag("nuggets/gold");
        public static final TagKey<Item> LUCKY_NUGGET = modItemTag("nuggets/lucky");
        public static final TagKey<Item> NETHERITE_NUGGET = modItemTag("nuggets/netherite");

        public static final TagKey<Item> INGOTS = modItemTag("ingots");
        public static final TagKey<Item> COPPER_INGOT = modItemTag("ingots/copper");
        public static final TagKey<Item> IRON_INGOT = modItemTag("ingots/iron");
        public static final TagKey<Item> GOLD_INGOT = modItemTag("ingots/gold");
        public static final TagKey<Item> NETHERITE_INGOT = modItemTag("ingots/netherite");
    }

    public interface StructureTags {
        TagKey<Structure> ON_ANCIENT_CITY_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_BASTION_REMNANT_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_DESERT_PYRAMID_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_END_CITY_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_IGLOO_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_JUNGLE_TEMPLE_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_MINESHAFT_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_NETHER_FORTRESS_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_NETHER_FOSSIL_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_NETHER_RUINED_PORTAL_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_OCEAN_RUIN_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_OVERWORLD_RUINED_PORTAL_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_PILLAGER_OUTPOST_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_SHIPWRECK_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_STRONGHOLD_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_SWAMP_HUT_EXPLORER_MAPS = modStructureTag("worldgen/structure");
        TagKey<Structure> ON_VILLAGE_EXPLORER_MAPS = modStructureTag("worldgen/structure");
    }

    private static @NotNull TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(MODID, path));
    }
    private static @NotNull TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, path));
    }
    private static TagKey<Structure> modStructureTag(String path) {
        return TagKey.create(Registry.STRUCTURE_REGISTRY, new ResourceLocation(MODID, path));
    }
}