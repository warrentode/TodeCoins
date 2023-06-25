package net.warrentode.todecoins.util.customtabs;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTabs extends CreativeModeTab {
    public ModCreativeModeTabs(String label) {
        super(-1, label);
    }

    public @NotNull ItemStack makeIcon() {
        return getIconItem();
    }

    public static final CreativeModeTab TODECOINSTAB = new CreativeModeTab(-1, "todecoinstab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.COPPER_COIN.get());
        }

        @Override
        public void fillItemList(final @NotNull NonNullList<ItemStack> items) {
            items.add(ModItems.CURRENCY_STAMP.get().getDefaultInstance());
            items.add(ModItems.NETHER_CURRENCY_STAMP.get().getDefaultInstance());

            items.add(ModItems.COPPER_NUGGET.get().getDefaultInstance());
            items.add(Items.IRON_NUGGET.getDefaultInstance());
            items.add(Items.GOLD_NUGGET.getDefaultInstance());
            items.add(ModItems.NETHERITE_NUGGET.get().getDefaultInstance());
            items.add(ModItems.LUCKY_NUGGET.get().getDefaultInstance());

            items.add(Items.GOLD_INGOT.getDefaultInstance());

            items.add(ModItems.COPPER_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_COIN.get().getDefaultInstance());
            items.add(ModItems.LUCKY_COIN.get().getDefaultInstance());

            items.add(ModItems.NETHER_GOLD_COIN.get().getDefaultInstance());

            items.add(ModItems.EMERALD_QUARTER_BANK_NOTE.get().getDefaultInstance());
            items.add(ModItems.EMERALD_HALF_BANK_NOTE.get().getDefaultInstance());
            items.add(ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance());

            items.add(ModItems.FOUR_LEAF_CLOVER.get().getDefaultInstance());

            items.add(ModItems.EMERALD_FIBER.get().getDefaultInstance());
            items.add(ModItems.LUCKY_FIBER.get().getDefaultInstance());

            items.add(ModItems.LUCKY_THREAD.get().getDefaultInstance());

            items.add(ModItems.EMERALD_COARSE_WOVE_PAPER.get().getDefaultInstance());
            items.add(ModItems.EMERALD_WOVE_PAPER.get().getDefaultInstance());
            items.add(ModItems.EMERALD_SMOOTH_WOVE_PAPER.get().getDefaultInstance());

            items.add(ModItems.LUCKY_FABRIC.get().getDefaultInstance());

            items.add(ModItems.LUCKY_HAT.get().getDefaultInstance());
            items.add(ModItems.LUCKY_SHIRT.get().getDefaultInstance());
            items.add(ModItems.LUCKY_PANTS.get().getDefaultInstance());
            items.add(ModItems.LUCKY_BOOTS.get().getDefaultInstance());

            items.add(Items.BUNDLE.getDefaultInstance());

            items.add((ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.IRON_COIN_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.GOLD_COIN_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.NETHERITE_COIN_BAG.get().asItem().getDefaultInstance()));

            items.add((ModBlocks.NETHER_GOLD_COIN_BAG.get().asItem().getDefaultInstance()));

            items.add((ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.EMERALD_BANK_NOTE_BAG.get().asItem().getDefaultInstance()));

            items.add((ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.COINPRESSBLOCK.get().asItem().getDefaultInstance()));

            items.add(ModItems.NUMISMATIST_SPAWN_EGG.get().getDefaultInstance());
            if (TodeCoins.isCageriumLoaded()) {
                items.add(ModItems.SNOW_GOLEM_SPAWN_EGG.get().getDefaultInstance());
            }
        }
    };

    public static final CreativeModeTab COLLECTORCOINSTAB = new CreativeModeTab(-1, "collectorcoinstab") {
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
            items.add(ModItems.MARSHALL_NASH_CARNATION_COIN.get().getDefaultInstance());
            items.add(ModItems.MARSHALL_NASH_COSMOS_COIN.get().getDefaultInstance());
            items.add(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().getDefaultInstance());
            items.add(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().getDefaultInstance());
            // gameplay coins
            // COD COIN SET
            items.add(ModItems.COPPER_COD_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_COD_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_COD_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_COD_COIN.get().getDefaultInstance());
            // HERO COIN SET
            items.add(ModItems.COPPER_HERO_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_HERO_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_HERO_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_HERO_COIN.get().getDefaultInstance());
            // PUFFERFISH COIN SET
            items.add(ModItems.COPPER_PUFFERFISH_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_PUFFERFISH_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_PUFFERFISH_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_PUFFERFISH_COIN.get().getDefaultInstance());
            // SALMON COIN SET
            items.add(ModItems.COPPER_SALMON_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_SALMON_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_SALMON_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_SALMON_COIN.get().getDefaultInstance());
            // TROPICAL FISH COIN SET
            items.add(ModItems.COPPER_TROPICAL_FISH_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_TROPICAL_FISH_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_TROPICAL_FISH_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_TROPICAL_FISH_COIN.get().getDefaultInstance());
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
            // COW COIN SET
            items.add(ModItems.COPPER_COW_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_COW_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_COW_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_COW_COIN.get().getDefaultInstance());
            // DONKEY COIN SET
            items.add(ModItems.COPPER_DONKEY_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_DONKEY_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_DONKEY_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_DONKEY_COIN.get().getDefaultInstance());
            // ENDERMAN COIN SET
            items.add(ModItems.COPPER_ENDERMAN_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_ENDERMAN_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_ENDERMAN_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_ENDERMAN_COIN.get().getDefaultInstance());
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
            // GLOW SQUID COIN SET
            items.add(ModItems.COPPER_GLOW_SQUID_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_GLOW_SQUID_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_GLOW_SQUID_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_GLOW_SQUID_COIN.get().getDefaultInstance());
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
            // MOOBLOOM COIN SET
            items.add(ModItems.COPPER_MOOBLOOM_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_MOOBLOOM_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_MOOBLOOM_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_MOOBLOOM_COIN.get().getDefaultInstance());
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
            // PIG COIN SET
            items.add(ModItems.COPPER_PIG_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_PIG_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_PIG_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_PIG_COIN.get().getDefaultInstance());
            // PIGLIN COIN SET
            items.add(ModItems.COPPER_PIGLIN_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_PIGLIN_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_PIGLIN_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_PIGLIN_COIN.get().getDefaultInstance());
            // RABBIT COIN SET
            items.add(ModItems.COPPER_RABBIT_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_RABBIT_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_RABBIT_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_RABBIT_COIN.get().getDefaultInstance());
            // SHEEP COIN SET
            items.add(ModItems.COPPER_SHEEP_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_SHEEP_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_SHEEP_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_SHEEP_COIN.get().getDefaultInstance());
            // SKELETON HORSE COIN SET
            items.add(ModItems.COPPER_SKELETON_HORSE_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_SKELETON_HORSE_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_SKELETON_HORSE_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_SKELETON_HORSE_COIN.get().getDefaultInstance());
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
            // TURTLE COIN SET
            items.add(ModItems.COPPER_TURTLE_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_TURTLE_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_TURTLE_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_TURTLE_COIN.get().getDefaultInstance());
            // VILLAGER COIN SET
            items.add(ModItems.COPPER_VILLAGER_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_VILLAGER_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_VILLAGER_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_VILLAGER_COIN.get().getDefaultInstance());
            // WANDERING TRADER COIN SET
            items.add(ModItems.COPPER_WANDERING_TRADER_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_WANDERING_TRADER_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_WANDERING_TRADER_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_WANDERING_TRADER_COIN.get().getDefaultInstance());
            // ZOMBIE HORSE COIN SET
            items.add(ModItems.COPPER_ZOMBIE_HORSE_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_ZOMBIE_HORSE_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_ZOMBIE_HORSE_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().getDefaultInstance());
        }
    };
}