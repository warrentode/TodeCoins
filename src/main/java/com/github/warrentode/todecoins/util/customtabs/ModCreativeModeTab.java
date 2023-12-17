package com.github.warrentode.todecoins.util.customtabs;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.item.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab extends CreativeModeTab {
    public static final ModCreativeModeTab TODECOINSTAB = new ModCreativeModeTab("todecoinstab");

    public ModCreativeModeTab(String label) {
        super(label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ModItems.COPPER_COIN.get());
    }

    @Override
    public void fillItemList(final @NotNull NonNullList<ItemStack> items) {
        items.add(ModItems.CURRENCY_STAMP.get().getDefaultInstance());
        items.add(ModItems.NETHER_CURRENCY_STAMP.get().getDefaultInstance());
        items.add(ModItems.ENDONIAN_CURRENCY_STAMP.get().getDefaultInstance());

        items.add(ModItems.COPPER_NUGGET.get().getDefaultInstance());
        items.add(Items.IRON_NUGGET.getDefaultInstance());
        items.add(Items.GOLD_NUGGET.getDefaultInstance());
        items.add(ModItems.NETHERITE_NUGGET.get().getDefaultInstance());
        items.add(ModItems.ENDONIAN_NUGGET.get().getDefaultInstance());
        items.add(ModItems.LUCKY_NUGGET.get().getDefaultInstance());

        items.add(Items.GOLD_INGOT.getDefaultInstance());
        items.add(ModItems.ENDONIAN_INGOT.get().getDefaultInstance());

        items.add(ModItems.COPPER_COIN.get().getDefaultInstance());
        items.add(ModItems.IRON_COIN.get().getDefaultInstance());
        items.add(ModItems.GOLD_COIN.get().getDefaultInstance());
        items.add(ModItems.NETHERITE_COIN.get().getDefaultInstance());
        items.add(ModItems.LUCKY_COIN.get().getDefaultInstance());

        items.add(ModItems.NETHER_GOLD_COIN.get().getDefaultInstance());
        items.add(ModItems.ENDONIAN_COIN.get().getDefaultInstance());

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
        items.add((ModBlocks.ENDONIAN_COIN_BAG.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.LUCKY_COIN_BAG.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.EMERALD_BANK_NOTE_BAG.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.ENDONIAN_BLOCK.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.COINPRESSBLOCK.get().asItem().getDefaultInstance()));

        items.add((ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get().getDefaultInstance()));
        items.add((ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get().getDefaultInstance()));
        items.add((ModItems.MILK_BONE_CHOCOLATE_COIN.get().getDefaultInstance()));
        items.add((ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get().getDefaultInstance()));
        items.add((ModItems.WARPED_SPICE_CHOCOLATE_COIN.get().getDefaultInstance()));
        items.add((ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get().getDefaultInstance()));
        items.add((ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get().getDefaultInstance()));
        items.add((ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get().getDefaultInstance()));
        items.add((ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get().getDefaultInstance()));

        items.add(ModItems.NUMISMATIST_SPAWN_EGG.get().getDefaultInstance());

        if (ModList.get().isLoaded("cagerium")) {
            items.add(ModItems.GIANT_SPAWN_EGG.get().getDefaultInstance());
            if (!ModList.get().isLoaded("friendsandfoes")) {
                items.add(ModItems.ILLUSIONER_SPAWN_EGG.get().getDefaultInstance());
            }
            items.add(ModItems.SNOW_GOLEM_SPAWN_EGG.get().getDefaultInstance());
        }

        items.add(ModItems.SERVER_TOKEN_COIN.get().getDefaultInstance());
    }
}