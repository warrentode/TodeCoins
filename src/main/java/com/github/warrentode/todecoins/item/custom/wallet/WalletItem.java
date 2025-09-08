package com.github.warrentode.todecoins.item.custom.wallet;

import com.github.warrentode.todecoins.gui.walletgui.WalletMenu;
import com.github.warrentode.todecoins.integration.curios.CurioCapabilityProvider;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

public class WalletItem extends Item {

    public static final int INVENTORY_SIZE = 9; // 9 slots

    public WalletItem(Properties properties) {
        super(properties);
    }

    // Open by hand
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider(
                    (id, inv, p) -> new WalletMenu(id, inv, heldStack),
                    Component.translatable("container.todecoins.wallet")
            ), buf -> buf.writeItemStack(heldStack, false));

            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ARMOR_EQUIP_GENERIC,
                    SoundSource.PLAYERS, 0.5f, 1.0f);
        }
        return InteractionResultHolder.sidedSuccess(heldStack, level.isClientSide());
    }

    // Open from equipped Curio
    public void useFromCurios(@NotNull Player player, @NotNull ItemStack stack) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider(
                (id, inv, p) -> new WalletMenu(id, inv, stack),
                Component.translatable("container.todecoins.wallet")
        ), buf -> buf.writeItemStack(stack, false));

        Level level = player.level;
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ARMOR_EQUIP_GENERIC,
                SoundSource.PLAYERS, 0.5f, 1.0f);
    }

    // Attach capability with NBT persistence
    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        WalletCapabilityProvider walletCap = new WalletCapabilityProvider(stack, nbt);
        ICapabilityProvider curiosCap = CurioCapabilityProvider.initCapabilities(stack, nbt);

        if (curiosCap == null) {
            return walletCap;
        }

        // Wrap both capabilities together
        return new ICapabilityProvider() {
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                LazyOptional<T> wallet = walletCap.getCapability(cap, side);
                if (wallet.isPresent()) return wallet;

                LazyOptional<T> curios = curiosCap.getCapability(cap, side);
                return curios.isPresent() ? curios : LazyOptional.empty();
            }
        };
    }

    // Capability provider with automatic NBT persistence
    private static class WalletCapabilityProvider implements ICapabilitySerializable<CompoundTag> {
        private final ItemStackHandler inventory;

        private WalletCapabilityProvider(ItemStack stack, @Nullable CompoundTag ignored) {
            this.inventory = new ItemStackHandler(INVENTORY_SIZE) {
                @Override
                protected void onContentsChanged(int slot) {
                    super.onContentsChanged(slot);
                    // Always write back to the *stack* tag
                    stack.getOrCreateTag().put("Inventory", this.serializeNBT());
                }
            };

            // Always read from the *stack* tag, not the parameter
            CompoundTag tag = stack.getTag();
            if (tag != null && tag.contains("Inventory")) {
                this.inventory.deserializeNBT(tag.getCompound("Inventory"));
            }
        }

        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
            return cap == ForgeCapabilities.ITEM_HANDLER ? LazyOptional.of(() -> inventory).cast() : LazyOptional.empty();
        }

        @Override
        public @NotNull CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            tag.put("Inventory", inventory.serializeNBT());
            TC_LOGGER.debug("[Wallet] serializeNBT: {}", tag);
            return tag;
        }

        @Override
        public void deserializeNBT(@NotNull CompoundTag nbt) {
            TC_LOGGER.debug("[Wallet] deserializeNBT: {}", nbt);
            inventory.deserializeNBT(nbt.getCompound("Inventory"));
        }
    }
}