package com.github.warrentode.todecoins.item.custom;

import com.github.warrentode.todecoins.block.custom.TipJarBlock;
import com.github.warrentode.todecoins.block.entity.custom.TipJarBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TipJarBlockItem extends BlockItem {
    public final TipJarBlock tipJarBlock;

    public TipJarBlockItem(Block block, Properties properties) {
        super(block, properties);
        this.tipJarBlock = (TipJarBlock) block;
    }

    @SuppressWarnings("SameReturnValue")
    public int getInventorySize(ItemStack ignoredStack) {
        return TipJarBlockEntity.INVENTORY_SIZE;
    }

    @Override
    public @NotNull InteractionResult place(@NotNull BlockPlaceContext context) {
        Player player = context.getPlayer();
        if (player != null) {
            return super.place(context);
        }
        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack tipJarItem, @Nullable Level level, @NotNull List<Component> toolTip, @NotNull TooltipFlag flag) {
        CompoundTag tag = tipJarItem.getTag();
        if (tag != null) {
            if (tipJarItem.getTag().contains("BlockEntityTag")) {
                tipJarItem.getTag().getCompound("BlockEntityTag").getCompound("inventory");
                ItemStackHandler tipJarInventory = new ItemStackHandler(getInventorySize(tipJarItem));
                tipJarInventory.deserializeNBT(tipJarItem.getTag().getCompound("BlockEntityTag").getCompound("inventory"));

                toolTip.add(Component.translatable("container.todecoins.tip_jar.contents").withStyle(ChatFormatting.ITALIC));

                for (int i = 0; i < tipJarInventory.getSlots(); i++) {
                    if (tipJarInventory.getStackInSlot(i).getItem() != Items.AIR) {
                        MutableComponent mutableComponent = tipJarInventory.getStackInSlot(i).getHoverName().copy();
                        mutableComponent.append(" x").append(String.valueOf(tipJarItem.getCount()));
                        toolTip.add(Component.literal( "- " ).append(mutableComponent).withStyle(ChatFormatting.ITALIC));
                    }
                }
            }
        }
    }
}