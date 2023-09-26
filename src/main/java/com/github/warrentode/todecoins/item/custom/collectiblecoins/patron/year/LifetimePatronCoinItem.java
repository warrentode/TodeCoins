package com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.year;

import com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.PatronCommemorativeCoinItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LifetimePatronCoinItem extends PatronCommemorativeCoinItem {
    public LifetimePatronCoinItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltips.collectible_coin_lifetime.hover").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }
}