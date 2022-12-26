package net.warrentode.todecoins.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab {
    public static final CreativeModeTab TODECOINSTAB = new CreativeModeTab("todecoinstab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.COPPER_COIN.get());
        }
    };
}
