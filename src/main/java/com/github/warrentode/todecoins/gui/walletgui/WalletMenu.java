package com.github.warrentode.todecoins.gui.walletgui;

import com.github.warrentode.todecoins.gui.TCMenuTypes;
import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.custom.wallet.WalletItem;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class WalletMenu extends AbstractContainerMenu {

    private static final int CONTAINER_SLOT_COUNT = WalletItem.INVENTORY_SIZE;
    private final ItemStack walletItem;
    private final ItemStackHandler walletInventory;

    public WalletMenu(int containerId, @NotNull Inventory playerInventory, @NotNull ItemStack walletStack) {
        super(TCMenuTypes.WALLET_MENU.get(), containerId);
        this.walletItem = walletStack;

        this.walletInventory = (ItemStackHandler) walletStack
                .getCapability(ForgeCapabilities.ITEM_HANDLER)
                .orElseThrow(() -> new IllegalStateException("Wallet ItemStack has no ITEM_HANDLER capability!"));

        // Wallet slots
        int walletStartX = 62;
        int walletStartY = 17;
        int columns = 3;
        int slotSpacing = 18;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < columns; col++) {
                int index = row * columns + col;
                this.addSlot(new SlotItemHandler(walletInventory, index,
                        walletStartX + col * slotSpacing,
                        walletStartY + row * slotSpacing) {
                    @Override
                    public boolean mayPlace(@NotNull ItemStack stack) {
                        return stack.is(TCItemTags.CURRENCY);
                    }
                });
            }
        }

        // Player inventory
        int invStartX = 8;
        int invStartY = 84;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9,
                        invStartX + col * 18, invStartY + row * 18));
            }
        }

        // Hotbar
        int hotbarY = invStartY + 58;
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, invStartX + col * 18, hotbarY));
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        Slot slot = this.slots.get(index);
        if (!slot.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = slot.getItem();
        ItemStack copy = stack.copy();

        if (index < CONTAINER_SLOT_COUNT) {
            if (!this.moveItemStackTo(stack, CONTAINER_SLOT_COUNT, this.slots.size(), true))
                return ItemStack.EMPTY;
        }
        else {
            if (!this.moveItemStackTo(stack, 0, CONTAINER_SLOT_COUNT, false))
                return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        }
        else {
            slot.setChanged();
        }

        return copy;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        if (player.isDeadOrDying() || walletItem.isEmpty()) return false;

        // Hand check
        if (player.getMainHandItem() == walletItem || player.getOffhandItem() == walletItem) return true;

        // Curios check
        if (ModList.get().isLoaded("curios")) {
            return CuriosHelper.getEquippedWallets(player).stream().anyMatch(stack -> stack == walletItem);
        }

        return false;
    }
}