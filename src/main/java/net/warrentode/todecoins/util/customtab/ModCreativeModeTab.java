package net.warrentode.todecoins.util.customtab;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab extends CreativeModeTab {

    public ModCreativeModeTab(String label) {
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
        public void fillItemList(final NonNullList<ItemStack> items) {
            items.add(ModItems.FOUR_LEAF_CLOVER.get().getDefaultInstance());
            items.add(ModItems.COPPER_NUGGET.get().getDefaultInstance());
            items.add(ModItems.LUCKY_NUGGET.get().getDefaultInstance());

            items.add(ModItems.CURRENCY_STAMP.get().getDefaultInstance());

            items.add(ModItems.COPPER_COIN.get().getDefaultInstance());
            items.add(ModItems.IRON_COIN.get().getDefaultInstance());
            items.add(ModItems.GOLD_COIN.get().getDefaultInstance());
            items.add(ModItems.NETHERITE_COIN.get().getDefaultInstance());
            items.add(ModItems.LUCKY_COIN.get().getDefaultInstance());

            items.add(ModItems.EMERALD_QUARTER_BANK_NOTE.get().getDefaultInstance());
            items.add(ModItems.EMERALD_HALF_BANK_NOTE.get().getDefaultInstance());
            items.add(ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance());

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

            items.add((ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.IRON_COIN_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.GOLD_COIN_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.NETHERITE_COIN_BAG.get().asItem().getDefaultInstance()));

            items.add((ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.EMERALD_BANK_NOTE_BAG.get().asItem().getDefaultInstance()));

            items.add((ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance()));
            items.add((ModBlocks.COINPRESSBLOCK.get().asItem().getDefaultInstance()));
        }
    };
}
