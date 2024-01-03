package com.github.warrentode.todecoins.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CollectibleCoin extends CoinItem {
    public CollectibleCoin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        tooltips.add(Component.translatable("tooltips." + stack.getDescriptionId() + ".set_count").withStyle(ChatFormatting.GRAY));
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltips.collectible_coin.hover").withStyle(ChatFormatting.DARK_GRAY).withStyle(ChatFormatting.ITALIC));
        }
        super.appendHoverText(stack, level, tooltips, flag);
    }
}