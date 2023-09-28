package com.github.warrentode.todecoins.item.custom.collectiblecoins.entity;

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

public class GolemCoinItem extends CollectibleCoin {
    public GolemCoinItem(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return !ModList.get().isLoaded("curios") ? null : Curios.createKnockbackCharmProvider(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        tooltips.add(Component.translatable("tooltips.collectible_golem_coin.hover").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }
}