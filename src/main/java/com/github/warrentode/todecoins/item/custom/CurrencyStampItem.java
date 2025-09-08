package com.github.warrentode.todecoins.item.custom;

import com.github.warrentode.todecoins.datagen.translations.TooltipTranslations;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CurrencyStampItem extends Item {
    public CurrencyStampItem(Properties properties) {
        super(properties);
    }

    @Override
    public final void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag tooltipFlag) {
        tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + "currency_stamp").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        super.appendHoverText(stack, level, tooltips, tooltipFlag);
    }
}