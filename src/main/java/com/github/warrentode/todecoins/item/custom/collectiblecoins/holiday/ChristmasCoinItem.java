package com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday;

import com.github.warrentode.todecoins.integration.Curios;
import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChristmasCoinItem extends CollectibleCoin {
    public ChristmasCoinItem(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return !ModList.get().isLoaded("curios") ? null : Curios.createCoinCharmProvider(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        tooltips.add(Component.translatable("tooltips.collectible_christmas_coin.hover").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }
}