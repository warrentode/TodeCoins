package com.github.warrentode.todecoins.item.custom.bracelet;

import com.github.warrentode.todecoins.util.PlayerUtil;
import com.github.warrentode.todecoins.util.customtabs.ModCreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraftforge.common.util.FakePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FriendshipBraceletItem extends Item {
    public static int braceletDurability;
    private final BraceletProperties braceletMaterials;
    private final int braceletCooldown;

    public FriendshipBraceletItem(@NotNull Properties properties, @NotNull BraceletProperties braceletProperties) {
        super(properties.tab(ModCreativeModeTab.TODECOINSTAB).setNoRepair());
        this.braceletMaterials = braceletProperties.getMaterials();
        this.braceletDurability = braceletMaterials.getMaxUses();
        this.braceletCooldown = braceletMaterials.getCooldown();
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.SPYGLASS;
    }

    public int getBraceletDamage(@NotNull ItemStack stack) {
        return stack.getDamageValue();
    }

    @NotNull
    public static GlobalPos getSpawnPosition(@NotNull Level level) {
        return GlobalPos.of(level.dimension(), level.getSharedSpawnPos());
    }

    public static BlockPos getRespawnPosition(@NotNull ServerPlayer serverPlayer) {
        return serverPlayer.getRespawnPosition();
    }

    public static ResourceKey<Level> getRespawnDimension(@NotNull ServerPlayer serverPlayer) {
        return serverPlayer.getRespawnDimension();
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player playerUsing, @NotNull InteractionHand useHand) {
        ItemStack stack = playerUsing.getItemInHand(useHand);

        if (!level.isClientSide && stack.getTag() != null) {
            // checks if the braceletMakerName tag contains a player name
            if (stack.getTag().contains(PlayerUtil.BRACELET_MAKER_TAG)) {
                String braceletMakerName = stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG);

                // checks if name of the playerUsing matches the braceletMakerName
                if (braceletMakerName.equalsIgnoreCase(playerUsing.getGameProfile().getName())) {
                    MinecraftServer minecraftServer = playerUsing.getServer();
                    ServerPlayer serverPlayerUsing = playerUsing.createCommandSourceStack().getPlayer();

                    if (minecraftServer != null && serverPlayerUsing != null) {
                        if (serverPlayerUsing.getRespawnPosition() != null) {
                            // teleports the playerUsing to their Respawn Point
                            minecraftServer.getCommands().performPrefixedCommand(serverPlayerUsing.createCommandSourceStack(),
                                    "execute as @s at @s in "
                                            + getRespawnDimension(serverPlayerUsing).location().getPath()
                                            + " run teleport @s "
                                            + getRespawnPosition(serverPlayerUsing).getX() + " "
                                            + getRespawnPosition(serverPlayerUsing).getY() + " "
                                            + getRespawnPosition(serverPlayerUsing).getZ());

                            // calls the use bracelet methods that are the same for all the actions available to the bracelet
                            braceletUsed(level, playerUsing, stack, useHand);
                        }
                        else {
                            // teleports the playerUsing to the World Spawn Point
                            playerUsing.teleportTo(getSpawnPosition(level).pos().getX(), getSpawnPosition(level).pos().getY(), getSpawnPosition(level).pos().getZ());

                            // calls the use bracelet methods that are the same for all the actions available to the bracelet
                            braceletUsed(level, playerUsing, stack, useHand);
                        }
                    }
                }
                else {
                    boolean isOnline = false;
                    MinecraftServer minecraftServer = playerUsing.getServer();
                    ServerPlayer serverPlayerUsing = playerUsing.createCommandSourceStack().getPlayer();

                    if (minecraftServer != null && serverPlayerUsing != null) {
                        ServerLevel serverLevel = minecraftServer.getLevel(playerUsing.level.dimension());

                        if (serverLevel != null) {
                            // checks if name of the player matching the braceletMakerName is online
                            for (Player player : serverLevel.players()) {
                                if (player.getGameProfile().getName().equalsIgnoreCase(braceletMakerName)) {
                                    isOnline = true;
                                    break;
                                }
                            }

                            if (isOnline) {
                                // gets and isolates the name from the item tag
                                Player braceletMaker = PlayerUtil.getPlayerEntityByName(serverLevel, braceletMakerName);

                                if (!(playerUsing instanceof FakePlayer) && braceletMaker != null) {
                                    // teleports playerUsing to braceletMaker's position
                                    minecraftServer.getCommands().performPrefixedCommand(serverPlayerUsing.createCommandSourceStack(),
                                            "execute as @s at @s in "
                                                    + braceletMaker.getCommandSenderWorld().dimension().location().getPath()
                                                    + " run teleport @s "
                                                    + braceletMaker.getX() + " "
                                                    + braceletMaker.getY() + " "
                                                    + braceletMaker.getZ());

                                    // calls the use bracelet methods that are the same for all the actions available to the bracelet
                                    braceletUsed(level, playerUsing, stack, useHand);
                                }
                            }
                            // when braceletMaker is offline, notify playerUsing
                            else {
                                playerUsing.sendSystemMessage(Component.translatable(stack.getDescriptionId() + ".offline", ChatFormatting.RED + braceletMakerName));
                            }
                            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
                        }
                    }
                }
            }
        }
        // if braceletMakerTag is not present or empty, create one with name of playerUsing
        else {
            final CompoundTag itemTag = stack.getOrCreateTag();
            itemTag.putString(PlayerUtil.BRACELET_MAKER_TAG, playerUsing.getGameProfile().getName());

            playerUsing.sendSystemMessage(Component.translatable(stack.getDescriptionId() + ".linked").withStyle(ChatFormatting.GOLD));

            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }
        // item use fails if all checks above fail
        return new InteractionResultHolder<>(InteractionResult.FAIL, stack);
    }

    private void braceletUsed(@NotNull Level level, @NotNull Player playerUsing, ItemStack stack, InteractionHand useHand) {
        // play item use sound event
        level.playSound(null, playerUsing.getX(), playerUsing.getY(), playerUsing.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));
        // apply item cooldown
        playerUsing.getCooldowns().addCooldown(this, this.braceletCooldown);

        // damage or break bracelet
        if (getBraceletDamage(stack) >= this.braceletDurability - 1) {
            stack.hurtAndBreak(1, playerUsing, (playerLambda) -> playerLambda.broadcastBreakEvent(useHand));
        }
        else {
            stack.hurt(1, new SingleThreadedRandomSource(1), (ServerPlayer) playerUsing);
        }
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        if (stack.hasTag() && stack.getTag() != null && stack.getTag().contains(PlayerUtil.BRACELET_MAKER_TAG)) {
            CompoundTag tag = stack.getTag();
            String braceletMaker = tag.getString(PlayerUtil.BRACELET_MAKER_TAG);
            return Component.literal(braceletMaker + "'s ").append(Component.translatable(this.getDescriptionId(stack)));
        }
        else {
            return super.getName(stack);
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag tooltipFlag) {
        if (stack.getTag() != null && !stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG).isEmpty()) {
            String braceletMakerName = stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG);
            tooltips.add(Component.translatable("tooltips.bracelet_linked_player").append(braceletMakerName).withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC));
        }
        else {
            tooltips.add(Component.translatable("tooltips.bracelet_not_linked").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC));
        }
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltips.bracelet_use_info").withStyle(ChatFormatting.GRAY));
        }
        else {
            tooltips.add(Component.translatable("tooltips.shift.hover").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, tooltips, tooltipFlag);
    }
}