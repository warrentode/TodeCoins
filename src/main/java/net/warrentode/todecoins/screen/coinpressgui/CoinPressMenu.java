package net.warrentode.todecoins.screen.coinpressgui;

import java.util.Objects;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.block.entity.CoinPressBlockEntity;
import net.warrentode.todecoins.screen.ModMenuTypes;
import net.warrentode.todecoins.screen.slot.CoinPressInputSlotA;
import net.warrentode.todecoins.screen.slot.CoinPressInputSlotB;
import net.warrentode.todecoins.screen.slot.CoinPressResultSlot;
import org.jetbrains.annotations.NotNull;

public class CoinPressMenu extends RecipeBookMenu<RecipeWrapper> {
    public final CoinPressBlockEntity blockEntity;
    public ItemStackHandler inventory;
    private final ContainerData data;
    protected final ContainerLevelAccess canInteractWithCallable;
    public Player player;
    private final Level level;
    Slot resultSlot;
    public CoinPressMenu(final int windowId, final Inventory playerInventory, @NotNull FriendlyByteBuf extraData) {
        this(windowId, playerInventory, playerInventory.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }
    public CoinPressMenu(int windowId, Inventory inv, BlockEntity coinPress, ContainerData data) {
        super(ModMenuTypes.COIN_PRESS_MENU.get(), windowId);
        checkContainerSize(inv, 3);
        blockEntity = (CoinPressBlockEntity) coinPress;
        this.level = inv.player.level;
        this.data = data;
        this.canInteractWithCallable = ContainerLevelAccess.create(Objects.requireNonNull(blockEntity.getLevel()), blockEntity.getBlockPos());
        
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        
        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new CoinPressInputSlotA(handler, 0, 8, 47));
            this.addSlot(new CoinPressInputSlotB(handler, 1, 44, 47));
            this.resultSlot = this.addSlot(new CoinPressResultSlot(player, blockEntity, handler, 2, 116, 47));
        });
        
        addDataSlots(data);
    }
    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, ModBlocks.COINPRESSBLOCK.get());
    }
    
    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    
    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 3;  // must be the number of slots you have!
    
    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();
        
        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        }
        else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        }
        else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        }
        else {
            sourceSlot.setChanged();
        }
        
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }
    
    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }
    
    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
    
    public int getScaledProgress() {
        int progress = blockEntity.stampingTime = this.data.get(0);
        int maxProgress = blockEntity.totalStampingTime = this.data.get(1);  // Max Progress
        int progressArrowSize = 15; // This is the length in pixels of your arrow
        
        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }
    public boolean isCrafting() {
        return data.get(0) > 0;
    }
    @Override
    public void fillCraftSlotsStackedContents(@NotNull StackedContents helper) {
        for (int i = 0; i < inventory.getSlots(); i++) {
            helper.accountSimpleStack(inventory.getStackInSlot(i));
        }
    }
    @Override
    public void clearCraftingContent() {
        for (int i = 0; i < 6; i++) {
            this.inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }
    @Override
    public boolean recipeMatches(Recipe<? super RecipeWrapper> recipe) {
        return recipe.matches(new RecipeWrapper(inventory), level);
    }
    @Override
    public int getResultSlotIndex() {
        return 2;
    }
    @Override
    public int getGridWidth() {
        return 2;
    }
    @Override
    public int getGridHeight() {
        return 1;
    }
    @Override
    public int getSize() {
        return 3;
    }
    @Override
    public @NotNull RecipeBookType getRecipeBookType() {
        return TodeCoins.RECIPE_TYPE_COINPRESS;
    }
    @Override
    public boolean shouldMoveToInventory(int slot) {
        return slot < (getGridWidth() * getGridHeight());
    }
}