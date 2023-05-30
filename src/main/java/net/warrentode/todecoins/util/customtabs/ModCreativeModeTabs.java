package net.warrentode.todecoins.util.customtabs;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTabs extends CreativeModeTab {
    public ModCreativeModeTabs(String label) {
        super(label);
    }

    public @NotNull ItemStack makeIcon() {
        return getIconItem();
    }

    public static final CreativeModeTab TODECOINSTAB = new CreativeModeTab("todecoinstab") {
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
        }
    };

    public static final CreativeModeTab COLLECTORCOINSTAB = new CreativeModeTab("collectorcoinstab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.COPPER_HERO_COIN.get());
        }

        @Override
        public void fillItemList(final @NotNull NonNullList<ItemStack> items) {
            // LUCKY COIN
            items.add(ModItems.LUCKY_COIN.get().getDefaultInstance());
            // PATRON COIN SET
            items.add(ModItems.MARSHALL_NASH_CARNATION_COIN.get().getDefaultInstance());
            items.add(ModItems.MARSHALL_NASH_COSMOS_COIN.get().getDefaultInstance());
            items.add(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().getDefaultInstance());
            items.add(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().getDefaultInstance());
            // HERO COIN SET
            items.add(ModItems.COPPER_HERO_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_HERO_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_HERO_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_HERO_COIN.get().getDefaultInstance());
            // PIGLIN COIN SET
            items.add(ModItems.COPPER_PIGLIN_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_PIGLIN_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_PIGLIN_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_PIGLIN_COIN.get().getDefaultInstance());
            // ENDERMAN COIN SET
            items.add(ModItems.COPPER_ENDERMAN_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_ENDERMAN_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_ENDERMAN_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_ENDERMAN_COIN.get().getDefaultInstance());
            // BIRTHDAY COIN
            items.add(ModItems.BIRTHDAY_COIN_2023.get().getDefaultInstance());
            // HALLOWEEN COIN SET
            items.add(ModItems.HALLOWEEN_COIN_2023.get().getDefaultInstance());
            // CHRISTMAS COIN
            items.add(ModItems.CHRISTMAS_COIN_2023.get().getDefaultInstance());
        }
    };
}