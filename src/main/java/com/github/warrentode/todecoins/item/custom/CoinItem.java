package com.github.warrentode.todecoins.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CoinItem extends Item {
    public CoinItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltips.coin_item.hover").withStyle(ChatFormatting.DARK_GRAY));
        }
        else {
            tooltips.add(Component.translatable("tooltips.shift.hover").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }

}