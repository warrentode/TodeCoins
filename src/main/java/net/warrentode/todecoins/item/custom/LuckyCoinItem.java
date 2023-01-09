package net.warrentode.todecoins.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LuckyCoinItem extends Item {
    public LuckyCoinItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltips, TooltipFlag pIsAdvanced) {
        tooltips.add(Component.translatable("tooltips.lucky_coin.hover").withStyle(ChatFormatting.GOLD));
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }

}