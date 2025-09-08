package com.github.warrentode.todecoins.item.custom;

import com.github.warrentode.todecoins.block.custom.CoinAlbumBlock;
import com.github.warrentode.todecoins.datagen.translations.TooltipTranslations;
import com.github.warrentode.todecoins.gui.coinalbum.CoinAlbumMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CoinAlbumBlockItem extends BlockItem {
    public final CoinAlbumBlock coinAlbumBlock;

    public CoinAlbumBlockItem(Block block, Properties properties) {
        super(block, properties);
        this.coinAlbumBlock = (CoinAlbumBlock) block;
    }

    // Open by hand
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider(
                    (id, inv, p) -> new CoinAlbumMenu(id, inv, heldStack),
                    Component.translatable("container.todecoins.coin_album")
            ), buf -> buf.writeItemStack(heldStack, false));

            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BOOK_PAGE_TURN,
                    SoundSource.PLAYERS, 0.5f, 1.0f);
        }
        return InteractionResultHolder.sidedSuccess(heldStack, level.isClientSide());
    }

    @Override
    public @NotNull InteractionResult place(@NotNull BlockPlaceContext context) {
        Player player = context.getPlayer();
        if (player != null && player.isShiftKeyDown()) {
            return super.place(context);
        }
        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack coinAlbumItem, @Nullable Level level, @NotNull List<Component> toolTip, @NotNull TooltipFlag flag) {
        toolTip.add(Component.translatable(TooltipTranslations.tooltipPrefix + "coin_album.hover").withStyle(ChatFormatting.ITALIC));
    }
}