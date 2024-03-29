package com.github.warrentode.todecoins.item.custom.collectiblecoins.patron;

import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PatronCommemorativeCoinItem extends CollectibleCoin {
    public PatronCommemorativeCoinItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltips.collectible_patron_coin.hover").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, tooltips, flag);
    }
}