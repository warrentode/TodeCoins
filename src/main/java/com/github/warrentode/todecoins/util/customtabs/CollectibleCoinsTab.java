package com.github.warrentode.todecoins.util.customtabs;

import com.github.warrentode.todecoins.item.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CollectibleCoinsTab extends CreativeModeTab {
    public static final CollectibleCoinsTab COLLECTORCOINSTAB = new CollectibleCoinsTab("collectorcoinstab");

    public CollectibleCoinsTab(String label) {
        super(label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ModItems.COPPER_HERO_COIN.get());
    }

    @Override
    public void fillItemList(final @NotNull NonNullList<ItemStack> items) {
        // holiday coins
        // BIRTHDAY COIN
        items.add(ModItems.BIRTHDAY_COIN_2023.get().getDefaultInstance());
        // HALLOWEEN COIN SET
        items.add(ModItems.HALLOWEEN_COIN_2023.get().getDefaultInstance());
        // CHRISTMAS COIN
        items.add(ModItems.CHRISTMAS_COIN_2023.get().getDefaultInstance());
        // PATRON COIN SET
        items.add(ModItems.SCHOLAR_OWL_COIN.get().getDefaultInstance());
        items.add(ModItems.TUXEDO_CAT_COIN.get().getDefaultInstance());
        items.add(ModItems.LITTLE_BEAR_COIN.get().getDefaultInstance());
        items.add(ModItems.MARSHALL_NASH_CARNATION_COIN.get().getDefaultInstance());
        items.add(ModItems.MARSHALL_NASH_COSMOS_COIN.get().getDefaultInstance());
        items.add(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().getDefaultInstance());
        items.add(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().getDefaultInstance());
        // gameplay coins
        // HERO COIN SET
        items.add(ModItems.COPPER_HERO_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_HERO_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_HERO_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_HERO_COIN.get().getDefaultInstance());
        // entity coins
        // ALLAY COIN SET
        items.add(ModItems.COPPER_ALLAY_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ALLAY_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ALLAY_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ALLAY_COIN.get().getDefaultInstance());
        // AXOLOTL COIN SET
        items.add(ModItems.COPPER_AXOLOTL_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_AXOLOTL_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_AXOLOTL_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_AXOLOTL_COIN.get().getDefaultInstance());
        // BAT COIN SET
        items.add(ModItems.COPPER_BAT_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_BAT_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_BAT_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_BAT_COIN.get().getDefaultInstance());
        // BEE COIN SET
        items.add(ModItems.COPPER_BEE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_BEE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_BEE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_BEE_COIN.get().getDefaultInstance());
        // BLAZE COIN SET
        items.add(ModItems.COPPER_BLAZE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_BLAZE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_BLAZE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_BLAZE_COIN.get().getDefaultInstance());
        // CAMEL COIN SET
        items.add(ModItems.COPPER_CAMEL_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_CAMEL_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_CAMEL_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_CAMEL_COIN.get().getDefaultInstance());
        // CAT COIN SET
        items.add(ModItems.COPPER_CAT_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_CAT_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_CAT_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_CAT_COIN.get().getDefaultInstance());
        // CAVE SPIDER COIN SET
        items.add(ModItems.COPPER_CAVE_SPIDER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_CAVE_SPIDER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_CAVE_SPIDER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_CAVE_SPIDER_COIN.get().getDefaultInstance());
        // CHICKEN COIN SET
        items.add(ModItems.COPPER_CHICKEN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_CHICKEN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_CHICKEN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_CHICKEN_COIN.get().getDefaultInstance());
        // COD COIN SET
        items.add(ModItems.COPPER_COD_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_COD_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_COD_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_COD_COIN.get().getDefaultInstance());
        // COW COIN SET
        items.add(ModItems.COPPER_COW_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_COW_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_COW_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_COW_COIN.get().getDefaultInstance());
        // CREEPER COIN SET
        items.add(ModItems.COPPER_CREEPER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_CREEPER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_CREEPER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_CREEPER_COIN.get().getDefaultInstance());
        // DOLPHIN COIN SET
        items.add(ModItems.COPPER_DOLPHIN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_DOLPHIN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_DOLPHIN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_DOLPHIN_COIN.get().getDefaultInstance());
        // DONKEY COIN SET
        items.add(ModItems.COPPER_DONKEY_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_DONKEY_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_DONKEY_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_DONKEY_COIN.get().getDefaultInstance());
        // DROWNED COIN SET
        items.add(ModItems.COPPER_DROWNED_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_DROWNED_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_DROWNED_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_DROWNED_COIN.get().getDefaultInstance());
        // ELDER GUARDIAN COIN SET
        items.add(ModItems.COPPER_ELDER_GUARDIAN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ELDER_GUARDIAN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ELDER_GUARDIAN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get().getDefaultInstance());
        // ENDER DRAGON COIN SET
        items.add(ModItems.COPPER_ENDER_DRAGON_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ENDER_DRAGON_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ENDER_DRAGON_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ENDER_DRAGON_COIN.get().getDefaultInstance());
        // ENDERMAN COIN SET
        items.add(ModItems.COPPER_ENDERMAN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ENDERMAN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ENDERMAN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ENDERMAN_COIN.get().getDefaultInstance());
        // ENDERMITE COIN SET
        items.add(ModItems.COPPER_ENDERMITE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ENDERMITE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ENDERMITE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ENDERMITE_COIN.get().getDefaultInstance());
        // EVOKER COIN SET
        items.add(ModItems.COPPER_EVOKER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_EVOKER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_EVOKER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_EVOKER_COIN.get().getDefaultInstance());
        // FOX COIN SET
        items.add(ModItems.COPPER_FOX_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_FOX_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_FOX_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_FOX_COIN.get().getDefaultInstance());
        // FROG COIN SET
        items.add(ModItems.COPPER_FROG_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_FROG_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_FROG_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_FROG_COIN.get().getDefaultInstance());
        // GIANT COIN SET
        items.add(ModItems.COPPER_GIANT_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_GIANT_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_GIANT_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_GIANT_COIN.get().getDefaultInstance());
        // GLOW SQUID COIN SET
        items.add(ModItems.COPPER_GLOW_SQUID_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_GLOW_SQUID_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_GLOW_SQUID_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_GLOW_SQUID_COIN.get().getDefaultInstance());
        // GOAT COIN SET
        items.add(ModItems.COPPER_GOAT_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_GOAT_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_GOAT_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_GOAT_COIN.get().getDefaultInstance());
        // GUARDIAN COIN SET
        items.add(ModItems.COPPER_GUARDIAN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_GUARDIAN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_GUARDIAN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_GUARDIAN_COIN.get().getDefaultInstance());
        // GHAST COIN SET
        items.add(ModItems.COPPER_GHAST_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_GHAST_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_GHAST_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_GHAST_COIN.get().getDefaultInstance());
        // HOGLIN COIN SET
        items.add(ModItems.COPPER_HOGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_HOGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_HOGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_HOGLIN_COIN.get().getDefaultInstance());
        // HORSE COIN SET
        items.add(ModItems.COPPER_HORSE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_HORSE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_HORSE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_HORSE_COIN.get().getDefaultInstance());
        // HUSK COIN SET
        items.add(ModItems.COPPER_HUSK_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_HUSK_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_HUSK_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_HUSK_COIN.get().getDefaultInstance());
        // IRON GOLEM COIN SET
        items.add(ModItems.COPPER_IRON_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_IRON_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_IRON_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_IRON_GOLEM_COIN.get().getDefaultInstance());
        // ILLUSIONER COIN SET
        items.add(ModItems.COPPER_ILLUSIONER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ILLUSIONER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ILLUSIONER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ILLUSIONER_COIN.get().getDefaultInstance());
        // LLAMA COIN SET
        items.add(ModItems.COPPER_LLAMA_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_LLAMA_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_LLAMA_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_LLAMA_COIN.get().getDefaultInstance());
        // MAGMA CUBE COIN SET
        items.add(ModItems.COPPER_MAGMA_CUBE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_MAGMA_CUBE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_MAGMA_CUBE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_MAGMA_CUBE_COIN.get().getDefaultInstance());
        // MOOSHROOM COIN SET
        items.add(ModItems.COPPER_MOOSHROOM_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_MOOSHROOM_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_MOOSHROOM_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_MOOSHROOM_COIN.get().getDefaultInstance());
        // MULE COIN SET
        items.add(ModItems.COPPER_MULE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_MULE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_MULE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_MULE_COIN.get().getDefaultInstance());
        // NUMISMATIST COIN SET
        items.add(ModItems.COPPER_NUMISMATIST_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_NUMISMATIST_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_NUMISMATIST_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_NUMISMATIST_COIN.get().getDefaultInstance());
        // OCELOT COIN SET
        items.add(ModItems.COPPER_OCELOT_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_OCELOT_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_OCELOT_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_OCELOT_COIN.get().getDefaultInstance());
        // PANDA COIN SET
        items.add(ModItems.COPPER_PANDA_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PANDA_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PANDA_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PANDA_COIN.get().getDefaultInstance());
        // PARROT COIN SET
        items.add(ModItems.COPPER_PARROT_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PARROT_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PARROT_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PARROT_COIN.get().getDefaultInstance());
        // PHANTOM COIN SET
        items.add(ModItems.COPPER_PHANTOM_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PHANTOM_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PHANTOM_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PHANTOM_COIN.get().getDefaultInstance());
        // PIG COIN SET
        items.add(ModItems.COPPER_PIG_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PIG_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PIG_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PIG_COIN.get().getDefaultInstance());
        // PIGLIN BRUTE COIN SET
        items.add(ModItems.COPPER_PIGLIN_BRUTE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PIGLIN_BRUTE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PIGLIN_BRUTE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get().getDefaultInstance());
        // PIGLIN COIN SET
        items.add(ModItems.COPPER_PIGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PIGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PIGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PIGLIN_COIN.get().getDefaultInstance());
        // PILLAGER COIN SET
        items.add(ModItems.COPPER_PILLAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PILLAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PILLAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PILLAGER_COIN.get().getDefaultInstance());
        // POLAR BEAR COIN SET
        items.add(ModItems.COPPER_POLAR_BEAR_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_POLAR_BEAR_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_POLAR_BEAR_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_POLAR_BEAR_COIN.get().getDefaultInstance());
        // PUFFERFISH COIN SET
        items.add(ModItems.COPPER_PUFFERFISH_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PUFFERFISH_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PUFFERFISH_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PUFFERFISH_COIN.get().getDefaultInstance());
        // RABBIT COIN SET
        items.add(ModItems.COPPER_RABBIT_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_RABBIT_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_RABBIT_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_RABBIT_COIN.get().getDefaultInstance());
        // RAVAGER COIN SET
        items.add(ModItems.COPPER_RAVAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_RAVAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_RAVAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_RAVAGER_COIN.get().getDefaultInstance());
        // SALMON COIN SET
        items.add(ModItems.COPPER_SALMON_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SALMON_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SALMON_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SALMON_COIN.get().getDefaultInstance());
        // SHEEP COIN SET
        items.add(ModItems.COPPER_SHEEP_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SHEEP_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SHEEP_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SHEEP_COIN.get().getDefaultInstance());
        // SHULKER COIN SET
        items.add(ModItems.COPPER_SHULKER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SHULKER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SHULKER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SHULKER_COIN.get().getDefaultInstance());
        // SILVERFISH COIN SET
        items.add(ModItems.COPPER_SILVERFISH_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SILVERFISH_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SILVERFISH_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SILVERFISH_COIN.get().getDefaultInstance());
        // SKELETON COIN SET
        items.add(ModItems.COPPER_SKELETON_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SKELETON_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SKELETON_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SKELETON_COIN.get().getDefaultInstance());
        // SKELETON HORSE COIN SET
        items.add(ModItems.COPPER_SKELETON_HORSE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SKELETON_HORSE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SKELETON_HORSE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SKELETON_HORSE_COIN.get().getDefaultInstance());
        // SLIME COIN SET
        items.add(ModItems.COPPER_SLIME_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SLIME_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SLIME_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SLIME_COIN.get().getDefaultInstance());
        // SNIFFER COIN SET
        items.add(ModItems.COPPER_SNIFFER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SNIFFER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SNIFFER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SNIFFER_COIN.get().getDefaultInstance());
        // SNOW GOLEM COIN SET
        items.add(ModItems.COPPER_SNOW_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SNOW_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SNOW_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SNOW_GOLEM_COIN.get().getDefaultInstance());
        // SPIDER COIN SET
        items.add(ModItems.COPPER_SPIDER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SPIDER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SPIDER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SPIDER_COIN.get().getDefaultInstance());
        // STRAY COIN SET
        items.add(ModItems.COPPER_STRAY_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_STRAY_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_STRAY_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_STRAY_COIN.get().getDefaultInstance());
        // STRIDER COIN SET
        items.add(ModItems.COPPER_STRIDER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_STRIDER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_STRIDER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_STRIDER_COIN.get().getDefaultInstance());
        // SQUID COIN SET
        items.add(ModItems.COPPER_SQUID_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SQUID_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SQUID_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SQUID_COIN.get().getDefaultInstance());
        // TADPOLE COIN SET
        items.add(ModItems.COPPER_TADPOLE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_TADPOLE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_TADPOLE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_TADPOLE_COIN.get().getDefaultInstance());
        // TRADER LLAMA COIN SET
        items.add(ModItems.COPPER_TRADER_LLAMA_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_TRADER_LLAMA_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_TRADER_LLAMA_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_TRADER_LLAMA_COIN.get().getDefaultInstance());
        // TROPICAL FISH COIN SET
        items.add(ModItems.COPPER_TROPICAL_FISH_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_TROPICAL_FISH_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_TROPICAL_FISH_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_TROPICAL_FISH_COIN.get().getDefaultInstance());
        // TURTLE COIN SET
        items.add(ModItems.COPPER_TURTLE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_TURTLE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_TURTLE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_TURTLE_COIN.get().getDefaultInstance());
        // VEX COIN SET
        items.add(ModItems.COPPER_VEX_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_VEX_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_VEX_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_VEX_COIN.get().getDefaultInstance());
        // VILLAGER COIN SET
        items.add(ModItems.COPPER_VILLAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_VILLAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_VILLAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_VILLAGER_COIN.get().getDefaultInstance());
        // VINDICATOR COIN SET
        items.add(ModItems.COPPER_VINDICATOR_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_VINDICATOR_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_VINDICATOR_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_VINDICATOR_COIN.get().getDefaultInstance());
        // WANDERING TRADER COIN SET
        items.add(ModItems.COPPER_WANDERING_TRADER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_WANDERING_TRADER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_WANDERING_TRADER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_WANDERING_TRADER_COIN.get().getDefaultInstance());
        // WARDEN COIN SET
        items.add(ModItems.COPPER_WARDEN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_WARDEN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_WARDEN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_WARDEN_COIN.get().getDefaultInstance());
        // WITCH COIN SET
        items.add(ModItems.COPPER_WITCH_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_WITCH_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_WITCH_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_WITCH_COIN.get().getDefaultInstance());
        // WITHER COIN SET
        items.add(ModItems.COPPER_WITHER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_WITHER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_WITHER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_WITHER_COIN.get().getDefaultInstance());
        // WITHER SKELETON COIN SET
        items.add(ModItems.COPPER_WITHER_SKELETON_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_WITHER_SKELETON_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_WITHER_SKELETON_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_WITHER_SKELETON_COIN.get().getDefaultInstance());
        // WOLF COIN SET
        items.add(ModItems.COPPER_WOLF_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_WOLF_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_WOLF_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_WOLF_COIN.get().getDefaultInstance());
        // ZOGLIN COIN SET
        items.add(ModItems.COPPER_ZOGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ZOGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ZOGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ZOGLIN_COIN.get().getDefaultInstance());
        // ZOMBIE COIN SET
        items.add(ModItems.COPPER_ZOMBIE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ZOMBIE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ZOMBIE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ZOMBIE_COIN.get().getDefaultInstance());
        // ZOMBIE HORSE COIN SET
        items.add(ModItems.COPPER_ZOMBIE_HORSE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ZOMBIE_HORSE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ZOMBIE_HORSE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().getDefaultInstance());
        // ZOMBIE VILLAGER COIN SET
        items.add(ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ZOMBIE_VILLAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get().getDefaultInstance());
        // ZOMBIFIED PIGLIN COIN SET
        items.add(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get().getDefaultInstance());

        // friends and foes
        // COPPER GOLEM COIN SET
        items.add(ModItems.COPPER_COPPER_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_COPPER_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_COPPER_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_COPPER_GOLEM_COIN.get().getDefaultInstance());
        // GLARE COIN SET
        items.add(ModItems.COPPER_GLARE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_GLARE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_GLARE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_GLARE_COIN.get().getDefaultInstance());
        // ICEOLOGER COIN SET
        items.add(ModItems.COPPER_ICEOLOGER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_ICEOLOGER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_ICEOLOGER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_ICEOLOGER_COIN.get().getDefaultInstance());
        // MAULER COIN SET
        items.add(ModItems.COPPER_MAULER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_MAULER_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_MAULER_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_MAULER_COIN.get().getDefaultInstance());
        // MOOBLOOM COIN SET
        items.add(ModItems.COPPER_MOOBLOOM_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_MOOBLOOM_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_MOOBLOOM_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_MOOBLOOM_COIN.get().getDefaultInstance());
        // WILDFIRE COIN SET
        items.add(ModItems.COPPER_WILDFIRE_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_WILDFIRE_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_WILDFIRE_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_WILDFIRE_COIN.get().getDefaultInstance());
        // TUFF GOLEM COIN SET
        items.add(ModItems.COPPER_TUFF_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_TUFF_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_TUFF_GOLEM_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_TUFF_GOLEM_COIN.get().getDefaultInstance());

        //ecologics
        // CRAB COIN SET
        items.add(ModItems.COPPER_CRAB_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_CRAB_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_CRAB_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_CRAB_COIN.get().getDefaultInstance());
        // SQUIRREL COIN SET
        items.add(ModItems.COPPER_SQUIRREL_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_SQUIRREL_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_SQUIRREL_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_SQUIRREL_COIN.get().getDefaultInstance());
        // PENGUIN COIN SET
        items.add(ModItems.COPPER_PENGUIN_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PENGUIN_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PENGUIN_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PENGUIN_COIN.get().getDefaultInstance());

        // villager guards
        // GUARD COIN SET
        items.add(ModItems.COPPER_GUARD_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_GUARD_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_GUARD_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_GUARD_COIN.get().getDefaultInstance());

        // todepiglins
        // PIGLIN MERCHANT COIN SET
        items.add(ModItems.COPPER_PIGLIN_MERCHANT_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_PIGLIN_MERCHANT_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_PIGLIN_MERCHANT_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get().getDefaultInstance());
    }
}