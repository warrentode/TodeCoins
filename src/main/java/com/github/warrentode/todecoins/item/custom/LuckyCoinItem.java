package com.github.warrentode.todecoins.item.custom;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.integration.Curios;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LuckyCoinItem extends CoinItem implements Wearable {

    public LuckyCoinItem(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return !TodeCoins.isModLoaded("curios") ? null : Curios.createLuckyCoinCharmProvider(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltips.lucky_coin.hover").withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }

}