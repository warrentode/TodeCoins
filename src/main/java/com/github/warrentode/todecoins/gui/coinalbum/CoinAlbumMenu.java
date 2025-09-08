package com.github.warrentode.todecoins.gui.coinalbum;

import com.github.warrentode.todecoins.block.entity.container.coinalbum.CoinAlbumSlotHandler;
import com.github.warrentode.todecoins.block.entity.custom.CoinAlbumBlockEntity;
import com.github.warrentode.todecoins.gui.TCMenuTypes;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CoinAlbumMenu extends AbstractContainerMenu {

    private static final int CONTAINER_SLOT_COUNT = CoinAlbumBlockEntity.INVENTORY_SIZE;
    private final ItemStack coinAlbumItem;
    private final ItemStackHandler coinAlbumInventory;

    // --- Page configuration ---
    private static final int SLOTS_PER_PAGE = 54;
    private static final int COLUMNS = 9;
    private static final int SLOT_SPACING = 18;
    private static final int START_X = 8;
    private static final int START_Y = 18;

    private int currentPage = 0;
    private final List<List<CoinAlbumSlotHandler>> pages = new ArrayList<>();

    public CoinAlbumMenu(int containerId, @NotNull Inventory playerInventory, @NotNull ItemStack coinAlbumStack) {
        super(TCMenuTypes.COIN_ALBUM_MENU.get(), containerId);
        this.coinAlbumItem = coinAlbumStack;

        // --- NBT based inventory ---
        this.coinAlbumInventory = new ItemStackHandler(CONTAINER_SLOT_COUNT) {
            @Override
            protected void onContentsChanged(int slot) {
                super.onContentsChanged(slot);
                CompoundTag tag = coinAlbumItem.getOrCreateTag();
                CompoundTag blockEntityTag = new CompoundTag();
                blockEntityTag.put("inventory", CoinAlbumMenu.this.coinAlbumInventory.serializeNBT());
                tag.put("BlockEntityTag", blockEntityTag);
            }
        };

        // Load existing items from the stack's NBT
        CompoundTag tag = coinAlbumStack.getTag();
        if (tag != null && tag.contains("BlockEntityTag")) {
            CompoundTag inventoryTag = tag.getCompound("BlockEntityTag").getCompound("inventory");
            coinAlbumInventory.deserializeNBT(inventoryTag);
        }

        // --- Build pages ---
        int totalPages = (int) Math.ceil(coinAlbumInventory.getSlots() / (double) SLOTS_PER_PAGE);
        for (int pageIndex = 0; pageIndex < totalPages; pageIndex++) {
            List<CoinAlbumSlotHandler> pageSlots = new ArrayList<>();
            for (int i = 0; i < SLOTS_PER_PAGE; i++) {
                int slotIndex = pageIndex * SLOTS_PER_PAGE + i;
                if (slotIndex >= coinAlbumInventory.getSlots()) break;

                int row = i / COLUMNS;
                int col = i % COLUMNS;

                CoinAlbumSlotHandler slot = new CoinAlbumSlotHandler(coinAlbumInventory, slotIndex,
                        START_X + col * SLOT_SPACING,
                        START_Y + row * SLOT_SPACING) {
                    @Override
                    public boolean mayPlace(@NotNull ItemStack stack) {
                        if (!stack.is(TCItemTags.COLLECTIBLE_COINS_TAG)) return false;

                        // check if this coin is already in the album
                        for (int i = 0; i < coinAlbumInventory.getSlots(); i++) {
                            ItemStack existing = coinAlbumInventory.getStackInSlot(i);
                            if (!existing.isEmpty() && existing.is(stack.getItem())) {
                                return false; // already in album
                            }
                        }
                        return true;
                    }
                };

                addSlot(slot);
                pageSlots.add(slot);
            }
            pages.add(pageSlots);
        }

        updateActivePage();

        // --- Player inventory slots ---
        int invStartX = 8;
        int invStartY = 140;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9,
                        invStartX + col * 18, invStartY + row * 18));
            }
        }

        // --- Hotbar slots ---
        int hotbarY = invStartY + 58;
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, invStartX + col * 18, hotbarY));
        }
    }

    private void updateActivePage() {
        for (int pageIndex = 0; pageIndex < pages.size(); pageIndex++) {
            boolean active = pageIndex == currentPage;
            for (CoinAlbumSlotHandler slot : pages.get(pageIndex)) {
                slot.setActive(active);
            }
        }
    }

    public void nextPage() {
        if (currentPage < pages.size() - 1) {
            currentPage++;
            updateActivePage();
        }
    }

    public void previousPage() {
        if (currentPage > 0) {
            currentPage--;
            updateActivePage();
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return pages.size();
    }

    // --- Quick move logic ---
    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        Slot slot = this.slots.get(index);
        if (!slot.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = slot.getItem();
        ItemStack copy = stack.copy();

        if (index < CONTAINER_SLOT_COUNT) {
            if (!this.moveItemStackTo(stack, CONTAINER_SLOT_COUNT, this.slots.size(), true))
                return ItemStack.EMPTY;
        } else {
            if (!this.moveItemStackTo(stack, 0, CONTAINER_SLOT_COUNT, false))
                return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }

        return copy;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        if (player.isDeadOrDying() || coinAlbumItem.isEmpty()) return false;
        return player.getMainHandItem() == coinAlbumItem || player.getOffhandItem() == coinAlbumItem;
    }
}