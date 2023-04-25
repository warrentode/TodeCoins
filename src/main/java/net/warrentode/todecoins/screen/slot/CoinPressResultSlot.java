package net.warrentode.todecoins.screen.slot;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.warrentode.todecoins.block.entity.CoinPressBlockEntity;
import org.jetbrains.annotations.NotNull;

public class CoinPressResultSlot extends SlotItemHandler {
    public final CoinPressBlockEntity blockEntity;
    public ContainerLevelAccess levelAccess;
    private final Player player;
    private int removeCount;
    
    private long lastSoundTime;
    
    @ParametersAreNonnullByDefault
    public CoinPressResultSlot(Player player, CoinPressBlockEntity blockEntity, IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
        this.blockEntity = blockEntity;
        this.player = player;
    }
    
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return false;
    }
    
    @Override
    @Nonnull
    public ItemStack remove(int amount) {
        if (this.hasItem()) {
            this.removeCount += Math.min(amount, this.getItem().getCount());
        }
        
        return super.remove(amount);
    }
    
    @Override
    public void onTake(@NotNull Player thePlayer, @NotNull ItemStack stack) {
        this.checkTakeAchievements(stack);
        super.onTake(thePlayer, stack);
        
        levelAccess.execute((level, blockPos) -> {
            long levelGameTime = level.getGameTime();
            if (this.lastSoundTime != levelGameTime) {
                level.playSound(null, blockPos, SoundEvents.CHAIN_PLACE, SoundSource.BLOCKS, 0.5F, 3.0F);
                this.lastSoundTime = levelGameTime;
            }
        });
        super.onTake(player, stack);
    }
    
    @Override
    protected void onQuickCraft(@NotNull ItemStack stack, int amount) {
        this.removeCount += amount;
        this.checkTakeAchievements(stack);
    }
    
    @Override
    protected void checkTakeAchievements(ItemStack stack) {
        stack.onCraftedBy(this.player.level, this.player, this.removeCount);
        
        if (!this.player.level.isClientSide) {
            blockEntity.awardUsedRecipes(this.player);
        }
        
        this.removeCount = 0;
    }
}