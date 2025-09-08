package com.github.warrentode.todecoins.block.entity.container.coinalbum;

import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class CoinAlbumSlotHandler extends SlotItemHandler {
    @SuppressWarnings("CanBeFinal")
    public int mutableX;
    @SuppressWarnings("CanBeFinal")
    public int mutableY;
    private final int slotIndex;
    private boolean active = true; // track if slot is on-screen and interactable

    public CoinAlbumSlotHandler(IItemHandlerModifiable inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.slotIndex = index;
        this.mutableX = x;
        this.mutableY = y;
    }

    public int x() {
        return mutableX;
    }

    public int y() {
        return mutableY;
    }

    @Override
    public int getSlotIndex() {
        return slotIndex;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isActive() {
        // only allow interaction if explicitly active
        return active;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        // fallback: allow if slot is active and item matches collectible tag
        return active && stack.is(TCItemTags.COLLECTIBLE_COINS_TAG);
    }
}