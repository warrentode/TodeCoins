package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // clover
        basicItem(ModItems.FOUR_LEAF_CLOVER.get());

        // nuggets
        basicItem(ModItems.COPPER_NUGGET.get());
        basicItem(ModItems.ENDONIAN_NUGGET.get());
        basicItem(ModItems.NETHERITE_NUGGET.get());
        basicItem(ModItems.LUCKY_NUGGET.get());

        // ingots
        basicItem(ModItems.ENDONIAN_INGOT.get());

        // fiber
        basicItem(ModItems.EMERALD_FIBER.get());
        basicItem(ModItems.LUCKY_FIBER.get());
        basicItem(ModItems.ENDONIAN_FIBER.get());
        basicItem(ModItems.ECHO_FIBER.get());

        // paper
        basicItem(ModItems.EMERALD_COARSE_WOVE_PAPER.get());
        basicItem(ModItems.EMERALD_WOVE_PAPER.get());
        basicItem(ModItems.EMERALD_SMOOTH_WOVE_PAPER.get());

        // currency - stamps
        basicItem(ModItems.CURRENCY_STAMP.get());
        basicItem(ModItems.ENDONIAN_CURRENCY_STAMP.get());

        // currency - coins
        basicItem(ModItems.COPPER_COIN.get());
        basicItem(ModItems.IRON_COIN.get());
        basicItem(ModItems.GOLD_COIN.get());
        basicItem(ModItems.ENDONIAN_COIN.get());
        basicItem(ModItems.NETHERITE_COIN.get());
        basicItem(ModItems.LUCKY_COIN.get());
        basicItem(ModItems.SERVER_TOKEN_COIN.get());

        // currency - banknotes
        basicItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get());
        basicItem(ModItems.EMERALD_BANK_NOTE.get());
        basicItem(ModItems.EMERALD_HALF_BANK_NOTE.get());

        // armor
        basicItem(ModItems.LUCKY_HAT.get());
        basicItem(ModItems.LUCKY_SHIRT.get());
        basicItem(ModItems.LUCKY_PANTS.get());
        basicItem(ModItems.LUCKY_BOOTS.get());

        // friendship bracelets
        basicItem(ModItems.BRACELET_FRIENDSHIP_EMERALD.get());
        basicItem(ModItems.BRACELET_FRIENDSHIP_ENDONIAN.get());
        basicItem(ModItems.BRACELET_FRIENDSHIP_ECHO.get());
        basicItem(ModItems.BRACELET_FRIENDSHIP_LUCKY.get());

        // candy coins
        basicItem(ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get());
        basicItem(ModItems.MILK_BONE_CHOCOLATE_COIN.get());
        basicItem(ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get());
        basicItem(ModItems.WARPED_SPICE_CHOCOLATE_COIN.get());
        basicItem(ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get());
        basicItem(ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get());
        basicItem(ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get());
        basicItem(ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get());
        basicItem(ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get());

        // spawn eggs
        withExistingParent(ModItems.GIANT_SPAWN_EGG.getId().toString(), "minecraft:item/template_spawn_egg");
        withExistingParent(ModItems.ILLUSIONER_SPAWN_EGG.getId().toString(), "minecraft:item/template_spawn_egg");
        withExistingParent(ModItems.NUMISMATIST_SPAWN_EGG.getId().toString(), "minecraft:item/template_spawn_egg");
        withExistingParent(ModItems.SNOW_GOLEM_SPAWN_EGG.getId().toString(), "minecraft:item/template_spawn_egg");

        // collectible coins
        basicItem(ModItems.EASTER_COIN.get());
        basicItem(ModItems.HALLOWEEN_COIN.get());
        basicItem(ModItems.CHRISTMAS_COIN.get());
        basicItem(ModItems.BIRTHDAY_COIN.get());
        basicItem(ModItems.NEW_YEAR_COIN.get());

        basicItem(ModItems.MARSHALL_NASH_CARNATION_COIN.get());
        basicItem(ModItems.MARSHALL_NASH_COSMOS_COIN.get());
        basicItem(ModItems.MARSHALL_NASH_SUNFLOWER_COIN.get());
        basicItem(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get());
        basicItem(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get());

        basicItem(ModItems.COPPER_HERO_COIN.get());
        basicItem(ModItems.IRON_HERO_COIN.get());
        basicItem(ModItems.GOLD_HERO_COIN.get());
        basicItem(ModItems.NETHERITE_HERO_COIN.get());

        basicItem(ModItems.COPPER_ALLAY_COIN.get());
        basicItem(ModItems.IRON_ALLAY_COIN.get());
        basicItem(ModItems.GOLD_ALLAY_COIN.get());
        basicItem(ModItems.NETHERITE_ALLAY_COIN.get());
        basicItem(ModItems.COPPER_AXOLOTL_COIN.get());
        basicItem(ModItems.IRON_AXOLOTL_COIN.get());
        basicItem(ModItems.GOLD_AXOLOTL_COIN.get());
        basicItem(ModItems.NETHERITE_AXOLOTL_COIN.get());
        basicItem(ModItems.COPPER_BAT_COIN.get());
        basicItem(ModItems.IRON_BAT_COIN.get());
        basicItem(ModItems.GOLD_BAT_COIN.get());
        basicItem(ModItems.NETHERITE_BAT_COIN.get());
        basicItem(ModItems.COPPER_BEE_COIN.get());
        basicItem(ModItems.IRON_BEE_COIN.get());
        basicItem(ModItems.GOLD_BEE_COIN.get());
        basicItem(ModItems.NETHERITE_BEE_COIN.get());
        basicItem(ModItems.COPPER_BLAZE_COIN.get());
        basicItem(ModItems.IRON_BLAZE_COIN.get());
        basicItem(ModItems.GOLD_BLAZE_COIN.get());
        basicItem(ModItems.NETHERITE_BLAZE_COIN.get());
        basicItem(ModItems.COPPER_CAMEL_COIN.get());
        basicItem(ModItems.IRON_CAMEL_COIN.get());
        basicItem(ModItems.GOLD_CAMEL_COIN.get());
        basicItem(ModItems.NETHERITE_CAMEL_COIN.get());
        basicItem(ModItems.COPPER_CAT_COIN.get());
        basicItem(ModItems.IRON_CAT_COIN.get());
        basicItem(ModItems.GOLD_CAT_COIN.get());
        basicItem(ModItems.NETHERITE_CAT_COIN.get());
        basicItem(ModItems.COPPER_CAVE_SPIDER_COIN.get());
        basicItem(ModItems.IRON_CAVE_SPIDER_COIN.get());
        basicItem(ModItems.GOLD_CAVE_SPIDER_COIN.get());
        basicItem(ModItems.NETHERITE_CAVE_SPIDER_COIN.get());
        basicItem(ModItems.COPPER_CHICKEN_COIN.get());
        basicItem(ModItems.IRON_CHICKEN_COIN.get());
        basicItem(ModItems.GOLD_CHICKEN_COIN.get());
        basicItem(ModItems.NETHERITE_CHICKEN_COIN.get());
        basicItem(ModItems.COPPER_COD_COIN.get());
        basicItem(ModItems.IRON_COD_COIN.get());
        basicItem(ModItems.GOLD_COD_COIN.get());
        basicItem(ModItems.NETHERITE_COD_COIN.get());
        basicItem(ModItems.COPPER_COPPER_GOLEM_COIN.get());
        basicItem(ModItems.IRON_COPPER_GOLEM_COIN.get());
        basicItem(ModItems.GOLD_COPPER_GOLEM_COIN.get());
        basicItem(ModItems.NETHERITE_COPPER_GOLEM_COIN.get());
        basicItem(ModItems.COPPER_COW_COIN.get());
        basicItem(ModItems.IRON_COW_COIN.get());
        basicItem(ModItems.GOLD_COW_COIN.get());
        basicItem(ModItems.NETHERITE_COW_COIN.get());
        basicItem(ModItems.COPPER_CRAB_COIN.get());
        basicItem(ModItems.IRON_CRAB_COIN.get());
        basicItem(ModItems.GOLD_CRAB_COIN.get());
        basicItem(ModItems.NETHERITE_CRAB_COIN.get());
        basicItem(ModItems.COPPER_CREEPER_COIN.get());
        basicItem(ModItems.IRON_CREEPER_COIN.get());
        basicItem(ModItems.GOLD_CREEPER_COIN.get());
        basicItem(ModItems.NETHERITE_CREEPER_COIN.get());
        basicItem(ModItems.COPPER_DOLPHIN_COIN.get());
        basicItem(ModItems.IRON_DOLPHIN_COIN.get());
        basicItem(ModItems.GOLD_DOLPHIN_COIN.get());
        basicItem(ModItems.NETHERITE_DOLPHIN_COIN.get());
        basicItem(ModItems.COPPER_DONKEY_COIN.get());
        basicItem(ModItems.IRON_DONKEY_COIN.get());
        basicItem(ModItems.GOLD_DONKEY_COIN.get());
        basicItem(ModItems.NETHERITE_DONKEY_COIN.get());
        basicItem(ModItems.COPPER_DROWNED_COIN.get());
        basicItem(ModItems.IRON_DROWNED_COIN.get());
        basicItem(ModItems.GOLD_DROWNED_COIN.get());
        basicItem(ModItems.NETHERITE_DROWNED_COIN.get());
        basicItem(ModItems.COPPER_ELDER_GUARDIAN_COIN.get());
        basicItem(ModItems.IRON_ELDER_GUARDIAN_COIN.get());
        basicItem(ModItems.GOLD_ELDER_GUARDIAN_COIN.get());
        basicItem(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get());
        basicItem(ModItems.COPPER_ENDER_DRAGON_COIN.get());
        basicItem(ModItems.IRON_ENDER_DRAGON_COIN.get());
        basicItem(ModItems.GOLD_ENDER_DRAGON_COIN.get());
        basicItem(ModItems.NETHERITE_ENDER_DRAGON_COIN.get());
        basicItem(ModItems.COPPER_ENDERMAN_COIN.get());
        basicItem(ModItems.IRON_ENDERMAN_COIN.get());
        basicItem(ModItems.GOLD_ENDERMAN_COIN.get());
        basicItem(ModItems.NETHERITE_ENDERMAN_COIN.get());
        basicItem(ModItems.COPPER_ENDERMITE_COIN.get());
        basicItem(ModItems.IRON_ENDERMITE_COIN.get());
        basicItem(ModItems.GOLD_ENDERMITE_COIN.get());
        basicItem(ModItems.NETHERITE_ENDERMITE_COIN.get());
        basicItem(ModItems.COPPER_EVOKER_COIN.get());
        basicItem(ModItems.IRON_EVOKER_COIN.get());
        basicItem(ModItems.GOLD_EVOKER_COIN.get());
        basicItem(ModItems.NETHERITE_EVOKER_COIN.get());
        basicItem(ModItems.COPPER_FOX_COIN.get());
        basicItem(ModItems.IRON_FOX_COIN.get());
        basicItem(ModItems.GOLD_FOX_COIN.get());
        basicItem(ModItems.NETHERITE_FOX_COIN.get());
        basicItem(ModItems.COPPER_FROG_COIN.get());
        basicItem(ModItems.IRON_FROG_COIN.get());
        basicItem(ModItems.GOLD_FROG_COIN.get());
        basicItem(ModItems.NETHERITE_FROG_COIN.get());
        basicItem(ModItems.COPPER_GHAST_COIN.get());
        basicItem(ModItems.IRON_GHAST_COIN.get());
        basicItem(ModItems.GOLD_GHAST_COIN.get());
        basicItem(ModItems.NETHERITE_GHAST_COIN.get());
        basicItem(ModItems.COPPER_GIANT_COIN.get());
        basicItem(ModItems.IRON_GIANT_COIN.get());
        basicItem(ModItems.GOLD_GIANT_COIN.get());
        basicItem(ModItems.NETHERITE_GIANT_COIN.get());
        basicItem(ModItems.COPPER_GLARE_COIN.get());
        basicItem(ModItems.IRON_GLARE_COIN.get());
        basicItem(ModItems.GOLD_GLARE_COIN.get());
        basicItem(ModItems.NETHERITE_GLARE_COIN.get());
        basicItem(ModItems.COPPER_GLOW_SQUID_COIN.get());
        basicItem(ModItems.IRON_GLOW_SQUID_COIN.get());
        basicItem(ModItems.GOLD_GLOW_SQUID_COIN.get());
        basicItem(ModItems.NETHERITE_GLOW_SQUID_COIN.get());
        basicItem(ModItems.COPPER_GOAT_COIN.get());
        basicItem(ModItems.IRON_GOAT_COIN.get());
        basicItem(ModItems.GOLD_GOAT_COIN.get());
        basicItem(ModItems.NETHERITE_GOAT_COIN.get());
        basicItem(ModItems.COPPER_GUARD_COIN.get());
        basicItem(ModItems.IRON_GUARD_COIN.get());
        basicItem(ModItems.GOLD_GUARD_COIN.get());
        basicItem(ModItems.NETHERITE_GUARD_COIN.get());
        basicItem(ModItems.COPPER_GUARDIAN_COIN.get());
        basicItem(ModItems.IRON_GUARDIAN_COIN.get());
        basicItem(ModItems.GOLD_GUARDIAN_COIN.get());
        basicItem(ModItems.NETHERITE_GUARDIAN_COIN.get());
        basicItem(ModItems.COPPER_HOGLIN_COIN.get());
        basicItem(ModItems.IRON_HOGLIN_COIN.get());
        basicItem(ModItems.GOLD_HOGLIN_COIN.get());
        basicItem(ModItems.NETHERITE_HOGLIN_COIN.get());
        basicItem(ModItems.COPPER_HORSE_COIN.get());
        basicItem(ModItems.IRON_HORSE_COIN.get());
        basicItem(ModItems.GOLD_HORSE_COIN.get());
        basicItem(ModItems.NETHERITE_HORSE_COIN.get());
        basicItem(ModItems.COPPER_HUSK_COIN.get());
        basicItem(ModItems.IRON_HUSK_COIN.get());
        basicItem(ModItems.GOLD_HUSK_COIN.get());
        basicItem(ModItems.NETHERITE_HUSK_COIN.get());
        basicItem(ModItems.COPPER_ICEOLOGER_COIN.get());
        basicItem(ModItems.IRON_ICEOLOGER_COIN.get());
        basicItem(ModItems.GOLD_ICEOLOGER_COIN.get());
        basicItem(ModItems.NETHERITE_ICEOLOGER_COIN.get());
        basicItem(ModItems.COPPER_ILLUSIONER_COIN.get());
        basicItem(ModItems.IRON_ILLUSIONER_COIN.get());
        basicItem(ModItems.GOLD_ILLUSIONER_COIN.get());
        basicItem(ModItems.NETHERITE_ILLUSIONER_COIN.get());
        basicItem(ModItems.COPPER_IRON_GOLEM_COIN.get());
        basicItem(ModItems.IRON_IRON_GOLEM_COIN.get());
        basicItem(ModItems.GOLD_IRON_GOLEM_COIN.get());
        basicItem(ModItems.NETHERITE_IRON_GOLEM_COIN.get());
        basicItem(ModItems.LITTLE_BEAR_COIN.get());
        basicItem(ModItems.COPPER_LLAMA_COIN.get());
        basicItem(ModItems.IRON_LLAMA_COIN.get());
        basicItem(ModItems.GOLD_LLAMA_COIN.get());
        basicItem(ModItems.NETHERITE_LLAMA_COIN.get());
        basicItem(ModItems.COPPER_MAGMA_CUBE_COIN.get());
        basicItem(ModItems.IRON_MAGMA_CUBE_COIN.get());
        basicItem(ModItems.GOLD_MAGMA_CUBE_COIN.get());
        basicItem(ModItems.NETHERITE_MAGMA_CUBE_COIN.get());
        basicItem(ModItems.COPPER_MAULER_COIN.get());
        basicItem(ModItems.IRON_MAULER_COIN.get());
        basicItem(ModItems.GOLD_MAULER_COIN.get());
        basicItem(ModItems.NETHERITE_MAULER_COIN.get());
        basicItem(ModItems.COPPER_MOOBLOOM_COIN.get());
        basicItem(ModItems.IRON_MOOBLOOM_COIN.get());
        basicItem(ModItems.GOLD_MOOBLOOM_COIN.get());
        basicItem(ModItems.NETHERITE_MOOBLOOM_COIN.get());
        basicItem(ModItems.COPPER_MOOSHROOM_COIN.get());
        basicItem(ModItems.IRON_MOOSHROOM_COIN.get());
        basicItem(ModItems.GOLD_MOOSHROOM_COIN.get());
        basicItem(ModItems.NETHERITE_MOOSHROOM_COIN.get());
        basicItem(ModItems.COPPER_MULE_COIN.get());
        basicItem(ModItems.IRON_MULE_COIN.get());
        basicItem(ModItems.GOLD_MULE_COIN.get());
        basicItem(ModItems.NETHERITE_MULE_COIN.get());
        basicItem(ModItems.COPPER_NUMISMATIST_COIN.get());
        basicItem(ModItems.IRON_NUMISMATIST_COIN.get());
        basicItem(ModItems.GOLD_NUMISMATIST_COIN.get());
        basicItem(ModItems.NETHERITE_NUMISMATIST_COIN.get());
        basicItem(ModItems.COPPER_OCELOT_COIN.get());
        basicItem(ModItems.IRON_OCELOT_COIN.get());
        basicItem(ModItems.GOLD_OCELOT_COIN.get());
        basicItem(ModItems.NETHERITE_OCELOT_COIN.get());
        basicItem(ModItems.COPPER_PANDA_COIN.get());
        basicItem(ModItems.IRON_PANDA_COIN.get());
        basicItem(ModItems.GOLD_PANDA_COIN.get());
        basicItem(ModItems.NETHERITE_PANDA_COIN.get());
        basicItem(ModItems.COPPER_PARROT_COIN.get());
        basicItem(ModItems.IRON_PARROT_COIN.get());
        basicItem(ModItems.GOLD_PARROT_COIN.get());
        basicItem(ModItems.NETHERITE_PARROT_COIN.get());
        basicItem(ModItems.COPPER_PENGUIN_COIN.get());
        basicItem(ModItems.IRON_PENGUIN_COIN.get());
        basicItem(ModItems.GOLD_PENGUIN_COIN.get());
        basicItem(ModItems.NETHERITE_PENGUIN_COIN.get());
        basicItem(ModItems.COPPER_PHANTOM_COIN.get());
        basicItem(ModItems.IRON_PHANTOM_COIN.get());
        basicItem(ModItems.GOLD_PHANTOM_COIN.get());
        basicItem(ModItems.NETHERITE_PHANTOM_COIN.get());
        basicItem(ModItems.COPPER_PIG_COIN.get());
        basicItem(ModItems.IRON_PIG_COIN.get());
        basicItem(ModItems.GOLD_PIG_COIN.get());
        basicItem(ModItems.NETHERITE_PIG_COIN.get());
        basicItem(ModItems.COPPER_PIGLIN_COIN.get());
        basicItem(ModItems.IRON_PIGLIN_COIN.get());
        basicItem(ModItems.GOLD_PIGLIN_COIN.get());
        basicItem(ModItems.NETHERITE_PIGLIN_COIN.get());
        basicItem(ModItems.COPPER_PIGLIN_BRUTE_COIN.get());
        basicItem(ModItems.IRON_PIGLIN_BRUTE_COIN.get());
        basicItem(ModItems.GOLD_PIGLIN_BRUTE_COIN.get());
        basicItem(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get());
        basicItem(ModItems.COPPER_PIGLIN_MERCHANT_COIN.get());
        basicItem(ModItems.IRON_PIGLIN_MERCHANT_COIN.get());
        basicItem(ModItems.GOLD_PIGLIN_MERCHANT_COIN.get());
        basicItem(ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get());
        basicItem(ModItems.COPPER_PILLAGER_COIN.get());
        basicItem(ModItems.IRON_PILLAGER_COIN.get());
        basicItem(ModItems.GOLD_PILLAGER_COIN.get());
        basicItem(ModItems.NETHERITE_PILLAGER_COIN.get());
        basicItem(ModItems.COPPER_POLAR_BEAR_COIN.get());
        basicItem(ModItems.IRON_POLAR_BEAR_COIN.get());
        basicItem(ModItems.GOLD_POLAR_BEAR_COIN.get());
        basicItem(ModItems.NETHERITE_POLAR_BEAR_COIN.get());
        basicItem(ModItems.COPPER_PUFFERFISH_COIN.get());
        basicItem(ModItems.IRON_PUFFERFISH_COIN.get());
        basicItem(ModItems.GOLD_PUFFERFISH_COIN.get());
        basicItem(ModItems.NETHERITE_PUFFERFISH_COIN.get());
        basicItem(ModItems.COPPER_RABBIT_COIN.get());
        basicItem(ModItems.IRON_RABBIT_COIN.get());
        basicItem(ModItems.GOLD_RABBIT_COIN.get());
        basicItem(ModItems.NETHERITE_RABBIT_COIN.get());
        basicItem(ModItems.COPPER_RAVAGER_COIN.get());
        basicItem(ModItems.IRON_RAVAGER_COIN.get());
        basicItem(ModItems.GOLD_RAVAGER_COIN.get());
        basicItem(ModItems.NETHERITE_RAVAGER_COIN.get());
        basicItem(ModItems.COPPER_SALMON_COIN.get());
        basicItem(ModItems.IRON_SALMON_COIN.get());
        basicItem(ModItems.GOLD_SALMON_COIN.get());
        basicItem(ModItems.NETHERITE_SALMON_COIN.get());
        basicItem(ModItems.SCHOLAR_OWL_COIN.get());
        basicItem(ModItems.COPPER_SHEEP_COIN.get());
        basicItem(ModItems.IRON_SHEEP_COIN.get());
        basicItem(ModItems.GOLD_SHEEP_COIN.get());
        basicItem(ModItems.NETHERITE_SHEEP_COIN.get());
        basicItem(ModItems.COPPER_SHULKER_COIN.get());
        basicItem(ModItems.IRON_SHULKER_COIN.get());
        basicItem(ModItems.GOLD_SHULKER_COIN.get());
        basicItem(ModItems.NETHERITE_SHULKER_COIN.get());
        basicItem(ModItems.COPPER_SILVERFISH_COIN.get());
        basicItem(ModItems.IRON_SILVERFISH_COIN.get());
        basicItem(ModItems.GOLD_SILVERFISH_COIN.get());
        basicItem(ModItems.NETHERITE_SILVERFISH_COIN.get());
        basicItem(ModItems.COPPER_SKELETON_COIN.get());
        basicItem(ModItems.IRON_SKELETON_COIN.get());
        basicItem(ModItems.GOLD_SKELETON_COIN.get());
        basicItem(ModItems.NETHERITE_SKELETON_COIN.get());
        basicItem(ModItems.COPPER_SKELETON_HORSE_COIN.get());
        basicItem(ModItems.IRON_SKELETON_HORSE_COIN.get());
        basicItem(ModItems.GOLD_SKELETON_HORSE_COIN.get());
        basicItem(ModItems.NETHERITE_SKELETON_HORSE_COIN.get());
        basicItem(ModItems.COPPER_SLIME_COIN.get());
        basicItem(ModItems.IRON_SLIME_COIN.get());
        basicItem(ModItems.GOLD_SLIME_COIN.get());
        basicItem(ModItems.NETHERITE_SLIME_COIN.get());
        basicItem(ModItems.COPPER_SNIFFER_COIN.get());
        basicItem(ModItems.IRON_SNIFFER_COIN.get());
        basicItem(ModItems.GOLD_SNIFFER_COIN.get());
        basicItem(ModItems.NETHERITE_SNIFFER_COIN.get());
        basicItem(ModItems.COPPER_SNOW_GOLEM_COIN.get());
        basicItem(ModItems.IRON_SNOW_GOLEM_COIN.get());
        basicItem(ModItems.GOLD_SNOW_GOLEM_COIN.get());
        basicItem(ModItems.NETHERITE_SNOW_GOLEM_COIN.get());
        basicItem(ModItems.COPPER_SPIDER_COIN.get());
        basicItem(ModItems.IRON_SPIDER_COIN.get());
        basicItem(ModItems.GOLD_SPIDER_COIN.get());
        basicItem(ModItems.NETHERITE_SPIDER_COIN.get());
        basicItem(ModItems.COPPER_SQUID_COIN.get());
        basicItem(ModItems.IRON_SQUID_COIN.get());
        basicItem(ModItems.GOLD_SQUID_COIN.get());
        basicItem(ModItems.NETHERITE_SQUID_COIN.get());
        basicItem(ModItems.COPPER_SQUIRREL_COIN.get());
        basicItem(ModItems.IRON_SQUIRREL_COIN.get());
        basicItem(ModItems.GOLD_SQUIRREL_COIN.get());
        basicItem(ModItems.NETHERITE_SQUIRREL_COIN.get());
        basicItem(ModItems.COPPER_STRAY_COIN.get());
        basicItem(ModItems.IRON_STRAY_COIN.get());
        basicItem(ModItems.GOLD_STRAY_COIN.get());
        basicItem(ModItems.NETHERITE_STRAY_COIN.get());
        basicItem(ModItems.COPPER_STRIDER_COIN.get());
        basicItem(ModItems.IRON_STRIDER_COIN.get());
        basicItem(ModItems.GOLD_STRIDER_COIN.get());
        basicItem(ModItems.NETHERITE_STRIDER_COIN.get());
        basicItem(ModItems.COPPER_TADPOLE_COIN.get());
        basicItem(ModItems.IRON_TADPOLE_COIN.get());
        basicItem(ModItems.GOLD_TADPOLE_COIN.get());
        basicItem(ModItems.NETHERITE_TADPOLE_COIN.get());
        basicItem(ModItems.COPPER_TRADER_LLAMA_COIN.get());
        basicItem(ModItems.IRON_TRADER_LLAMA_COIN.get());
        basicItem(ModItems.GOLD_TRADER_LLAMA_COIN.get());
        basicItem(ModItems.NETHERITE_TRADER_LLAMA_COIN.get());
        basicItem(ModItems.COPPER_TROPICAL_FISH_COIN.get());
        basicItem(ModItems.IRON_TROPICAL_FISH_COIN.get());
        basicItem(ModItems.GOLD_TROPICAL_FISH_COIN.get());
        basicItem(ModItems.NETHERITE_TROPICAL_FISH_COIN.get());
        basicItem(ModItems.COPPER_TUFF_GOLEM_COIN.get());
        basicItem(ModItems.IRON_TUFF_GOLEM_COIN.get());
        basicItem(ModItems.GOLD_TUFF_GOLEM_COIN.get());
        basicItem(ModItems.NETHERITE_TUFF_GOLEM_COIN.get());
        basicItem(ModItems.COPPER_TURTLE_COIN.get());
        basicItem(ModItems.IRON_TURTLE_COIN.get());
        basicItem(ModItems.GOLD_TURTLE_COIN.get());
        basicItem(ModItems.NETHERITE_TURTLE_COIN.get());
        basicItem(ModItems.TUXEDO_CAT_COIN.get());
        basicItem(ModItems.COPPER_VEX_COIN.get());
        basicItem(ModItems.IRON_VEX_COIN.get());
        basicItem(ModItems.GOLD_VEX_COIN.get());
        basicItem(ModItems.NETHERITE_VEX_COIN.get());
        basicItem(ModItems.COPPER_VILLAGER_COIN.get());
        basicItem(ModItems.IRON_VILLAGER_COIN.get());
        basicItem(ModItems.GOLD_VILLAGER_COIN.get());
        basicItem(ModItems.NETHERITE_VILLAGER_COIN.get());
        basicItem(ModItems.COPPER_VINDICATOR_COIN.get());
        basicItem(ModItems.IRON_VINDICATOR_COIN.get());
        basicItem(ModItems.GOLD_VINDICATOR_COIN.get());
        basicItem(ModItems.NETHERITE_VINDICATOR_COIN.get());
        basicItem(ModItems.COPPER_WANDERING_TRADER_COIN.get());
        basicItem(ModItems.IRON_WANDERING_TRADER_COIN.get());
        basicItem(ModItems.GOLD_WANDERING_TRADER_COIN.get());
        basicItem(ModItems.NETHERITE_WANDERING_TRADER_COIN.get());
        basicItem(ModItems.COPPER_WARDEN_COIN.get());
        basicItem(ModItems.IRON_WARDEN_COIN.get());
        basicItem(ModItems.GOLD_WARDEN_COIN.get());
        basicItem(ModItems.NETHERITE_WARDEN_COIN.get());
        basicItem(ModItems.COPPER_WILDFIRE_COIN.get());
        basicItem(ModItems.IRON_WILDFIRE_COIN.get());
        basicItem(ModItems.GOLD_WILDFIRE_COIN.get());
        basicItem(ModItems.NETHERITE_WILDFIRE_COIN.get());
        basicItem(ModItems.COPPER_WITCH_COIN.get());
        basicItem(ModItems.IRON_WITCH_COIN.get());
        basicItem(ModItems.GOLD_WITCH_COIN.get());
        basicItem(ModItems.NETHERITE_WITCH_COIN.get());
        basicItem(ModItems.COPPER_WITHER_COIN.get());
        basicItem(ModItems.IRON_WITHER_COIN.get());
        basicItem(ModItems.GOLD_WITHER_COIN.get());
        basicItem(ModItems.NETHERITE_WITHER_COIN.get());
        basicItem(ModItems.COPPER_WITHER_SKELETON_COIN.get());
        basicItem(ModItems.IRON_WITHER_SKELETON_COIN.get());
        basicItem(ModItems.GOLD_WITHER_SKELETON_COIN.get());
        basicItem(ModItems.NETHERITE_WITHER_SKELETON_COIN.get());
        basicItem(ModItems.COPPER_WOLF_COIN.get());
        basicItem(ModItems.IRON_WOLF_COIN.get());
        basicItem(ModItems.GOLD_WOLF_COIN.get());
        basicItem(ModItems.NETHERITE_WOLF_COIN.get());
        basicItem(ModItems.COPPER_ZOGLIN_COIN.get());
        basicItem(ModItems.IRON_ZOGLIN_COIN.get());
        basicItem(ModItems.GOLD_ZOGLIN_COIN.get());
        basicItem(ModItems.NETHERITE_ZOGLIN_COIN.get());
        basicItem(ModItems.COPPER_ZOMBIE_COIN.get());
        basicItem(ModItems.IRON_ZOMBIE_COIN.get());
        basicItem(ModItems.GOLD_ZOMBIE_COIN.get());
        basicItem(ModItems.NETHERITE_ZOMBIE_COIN.get());
        basicItem(ModItems.COPPER_ZOMBIE_HORSE_COIN.get());
        basicItem(ModItems.IRON_ZOMBIE_HORSE_COIN.get());
        basicItem(ModItems.GOLD_ZOMBIE_HORSE_COIN.get());
        basicItem(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get());
        basicItem(ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get());
        basicItem(ModItems.IRON_ZOMBIE_VILLAGER_COIN.get());
        basicItem(ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get());
        basicItem(ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get());
        basicItem(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get());
        basicItem(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get());
        basicItem(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get());
        basicItem(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get());
        basicItem(ModItems.COPPER_RASCAL_COIN.get());
        basicItem(ModItems.IRON_RASCAL_COIN.get());
        basicItem(ModItems.GOLD_RASCAL_COIN.get());
        basicItem(ModItems.NETHERITE_RASCAL_COIN.get());
        basicItem(ModItems.COPPER_ARMADILLO_COIN.get());
        basicItem(ModItems.IRON_ARMADILLO_COIN.get());
        basicItem(ModItems.GOLD_ARMADILLO_COIN.get());
        basicItem(ModItems.NETHERITE_ARMADILLO_COIN.get());
    }
}