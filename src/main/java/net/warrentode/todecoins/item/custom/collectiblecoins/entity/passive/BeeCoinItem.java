package net.warrentode.todecoins.item.custom.collectiblecoins.entity.passive;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.integration.Curios;
import net.warrentode.todecoins.item.custom.CollectibleCoin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BeeCoinItem extends CollectibleCoin {
    public BeeCoinItem(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return !TodeCoins.isCuriosLoaded() ? null : Curios.createBeeCoinCharmProvider(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        tooltips.add(Component.translatable("tooltips.collectible_bee_coin.hover").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }
}