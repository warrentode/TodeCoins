package com.github.warrentode.todecoins.item.custom.bracelet;

import com.github.warrentode.todecoins.Config;
import com.github.warrentode.todecoins.datagen.translations.TooltipTranslations;
import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.integration.curios.CurioCapabilityProvider;
import com.github.warrentode.todecoins.util.PlayerUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;
// TODO add a blacklist to/from dimension check prior to teleport
public class FriendshipBraceletItem extends Item {
    public static int braceletDurability;
    private final BraceletProperties braceletMaterials;
    private final int braceletCooldown;

    public FriendshipBraceletItem(@NotNull Properties properties, @NotNull BraceletProperties braceletProperties) {
        super(properties.setNoRepair());
        this.braceletMaterials = braceletProperties.getMaterials();
        this.braceletDurability = braceletMaterials.getMaxUses();
        this.braceletCooldown = braceletMaterials.getCooldown();
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        if (!ModList.get().isLoaded("curios")) {
            return null;
        }
        // Delegate to a helper class that only exists if Curios is loaded
        return CurioCapabilityProvider.initCapabilities(stack, nbt);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.SPYGLASS;
    }

    public int getBraceletDamage(@NotNull ItemStack stack) {
        return stack.getDamageValue();
    }

    public static BlockPos getRespawnPosition(@NotNull ServerPlayer serverPlayer) {
        return serverPlayer.getRespawnPosition();
    }

    public static @NotNull ResourceKey<Level> getRespawnDimension(@NotNull ServerPlayer serverPlayer) {
        return serverPlayer.getRespawnDimension();
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player playerUsing, @NotNull InteractionHand useHand) {
        ItemStack stack = playerUsing.getItemInHand(useHand);

        if (!level.isClientSide && stack.getTag() != null && !stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG).isEmpty()) {
            String braceletMakerName = stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG);

            if (braceletMakerName.equalsIgnoreCase(playerUsing.getGameProfile().getName())) {
                if (playerUsing instanceof ServerPlayer serverPlayerUsing) {
                    // teleport to self if effect not applied
                    if (!serverPlayerUsing.hasEffect(TCMobEffects.TELEPORTATION_SICKNESS.get())) {
                        teleportToSelf(serverPlayerUsing, stack, level);
                        braceletUsed(level, playerUsing, stack, useHand);
                    }
                }
            }
            else {
                if (playerUsing instanceof ServerPlayer serverPlayerUsing) {
                    // teleport to friend if effect is not applied
                    if (!serverPlayerUsing.hasEffect(TCMobEffects.TELEPORTATION_SICKNESS.get())) {
                        teleportToFriend(serverPlayerUsing, braceletMakerName, stack);
                        braceletUsed(level, playerUsing, stack, useHand);
                    }
                }
            }

            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }
        else if (!level.isClientSide && (stack.getTag() == null || stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG).isEmpty())) {
            final CompoundTag itemTag = stack.getOrCreateTag();
            itemTag.putString(PlayerUtil.BRACELET_MAKER_TAG, playerUsing.getGameProfile().getName());

            playerUsing.sendSystemMessage(Component.translatable(stack.getDescriptionId() + ".linked").withStyle(ChatFormatting.GOLD));

            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }

        return new InteractionResultHolder<>(InteractionResult.FAIL, stack);
    }

    private void braceletUsed(@NotNull Level level, @NotNull Player playerUsing, ItemStack stack, InteractionHand useHand) {
        level.playSound(null, playerUsing.getX(), playerUsing.getY(), playerUsing.getZ(),
                SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));

        if (getBraceletDamage(stack) >= this.braceletDurability - 1) {
            stack.hurtAndBreak(1, playerUsing, (playerLambda) -> playerLambda.broadcastBreakEvent(useHand));
        }
        else if (playerUsing instanceof ServerPlayer serverPlayerUsing) {
            stack.hurt(1, level.getRandom(), serverPlayerUsing);
        }
    }

    private void applyBraceletCooldown(@NotNull ServerPlayer serverPlayer) {
        MobEffectInstance cooldownEffect = new MobEffectInstance(TCMobEffects.TELEPORTATION_SICKNESS.get(),
                braceletCooldown, 0, false, true, true);

        serverPlayer.addEffect(cooldownEffect);
    }

    // ---------- TELEPORT METHODS ----------

    private void teleportToSelf(@NotNull ServerPlayer playerUsing, @NotNull ItemStack stack, @NotNull Level ignoredCurrentLevel) {
        BlockPos respawnPos = getRespawnPosition(playerUsing);
        ResourceKey<Level> respawnDim = getRespawnDimension(playerUsing);
        boolean teleported = false;

        // Log current position and dimension
        TC_LOGGER.info("[FriendshipBracelet] {} is currently at {} {} {} in {}",
                playerUsing.getName().getString(),
                playerUsing.getX(), playerUsing.getY(), playerUsing.getZ(),
                playerUsing.level.dimension().location());

        try {
            if (respawnPos != null) {
                // Teleport to respawn point (cross-dimension)
                ServerLevel targetLevel = Objects.requireNonNull(playerUsing.getServer()).getLevel(respawnDim);
                if (targetLevel != null) {
                    if (isDimensionBlacklisted(playerUsing.level) || isDimensionBlacklisted(targetLevel)) {
                        if (isDimensionBlacklisted(playerUsing.level)) {
                            playerUsing.sendSystemMessage(Component.literal("Cannot teleport from this dimension!").withStyle(ChatFormatting.RED));
                        }
                        else {
                            playerUsing.sendSystemMessage(Component.literal("Cannot teleport to this dimension!").withStyle(ChatFormatting.RED));
                        }
                        return;
                    }
                    TC_LOGGER.info("[FriendshipBracelet] {}'s respawn point at {} {} {} in {}",
                            playerUsing.getName().getString(),
                            respawnPos.getX(), respawnPos.getY(), respawnPos.getZ(),
                            targetLevel.dimension().location());

                    playerUsing.teleportTo(targetLevel,
                            respawnPos.getX(), respawnPos.getY(), respawnPos.getZ(),
                            playerUsing.getYRot(), playerUsing.getXRot());
                    teleported = true;

                    // sets the post-teleport effect to self
                    applyBraceletCooldown(playerUsing);
                }
            }

            if (!teleported) {
                // Fallback: Overworld spawn
                ServerLevel overworld = Objects.requireNonNull(playerUsing.getServer()).getLevel(Level.OVERWORLD);
                GlobalPos spawn = GlobalPos.of(Objects.requireNonNull(overworld).dimension(), overworld.getSharedSpawnPos());

                TC_LOGGER.info("[FriendshipBracelet] {} has no respawn point, teleporting to Overworld spawn at {} {} {} in {}",
                        playerUsing.getName().getString(),
                        spawn.pos().getX(), spawn.pos().getY(), spawn.pos().getZ(),
                        overworld.dimension().location());

                playerUsing.teleportTo(overworld,
                        spawn.pos().getX(), spawn.pos().getY(), spawn.pos().getZ(),
                        playerUsing.getYRot(), playerUsing.getXRot());
                teleported = true;

                // sets the post-teleport effect to self
                applyBraceletCooldown(playerUsing);
            }

        }
        catch (Exception exception) {
            TC_LOGGER.warn("[FriendshipBracelet] Failed to teleport {}: {}", playerUsing.getName().getString(), exception.getMessage());
        }

        if (!teleported) {
            playerUsing.sendSystemMessage(
                    Component.translatable(stack.getDescriptionId() + ".teleport_failed")
                            .withStyle(ChatFormatting.RED));
        }
    }

    private void teleportToFriend(@NotNull ServerPlayer playerUsing, @NotNull String friendName, @NotNull ItemStack stack) {
        MinecraftServer server = playerUsing.getServer();
        if (server == null) {
            playerUsing.sendSystemMessage(
                    Component.translatable(stack.getDescriptionId() + ".teleport_failed").withStyle(ChatFormatting.RED));
            TC_LOGGER.warn("[FriendshipBracelet] {} tried to teleport to {} but server is null", playerUsing.getName().getString(), friendName);
            return;
        }

        Player friend = server.getPlayerList().getPlayerByName(friendName);

        if (friend instanceof ServerPlayer targetServerPlayer) {
            try {
                ServerLevel targetLevel = (ServerLevel) targetServerPlayer.level;

                if (isDimensionBlacklisted(playerUsing.level) || isDimensionBlacklisted(targetLevel)) {
                    if (isDimensionBlacklisted(playerUsing.level)) {
                        playerUsing.sendSystemMessage(Component.literal("Cannot teleport from this dimension!").withStyle(ChatFormatting.RED));
                    }
                    else {
                        playerUsing.sendSystemMessage(Component.literal("Cannot teleport to this dimension!").withStyle(ChatFormatting.RED));
                    }
                    return;
                }

                TC_LOGGER.info("[FriendshipBracelet] {} is currently at {} {} {} in {}",
                        playerUsing.getName().getString(),
                        playerUsing.getX(), playerUsing.getY(), playerUsing.getZ(),
                        playerUsing.level.dimension().location());

                TC_LOGGER.info("[FriendshipBracelet] Teleporting {} to {} at {} {} {} in {}",
                        playerUsing.getName().getString(),
                        friendName,
                        targetServerPlayer.getX(),
                        targetServerPlayer.getY(),
                        targetServerPlayer.getZ(),
                        targetLevel.dimension().location());

                playerUsing.teleportTo(targetLevel,
                        targetServerPlayer.getX(),
                        targetServerPlayer.getY(),
                        targetServerPlayer.getZ(),
                        playerUsing.getYRot(),
                        playerUsing.getXRot());

                // sets the post-teleport effect to friend
                applyBraceletCooldown(playerUsing);

            }
            catch (Exception exception) {
                TC_LOGGER.warn("[FriendshipBracelet] Failed to teleport {} to {}: {}", playerUsing.getName().getString(), friendName, exception.getMessage());
                playerUsing.sendSystemMessage(Component.translatable(stack.getDescriptionId() + ".teleport_failed").withStyle(ChatFormatting.RED));
            }
        }
        else {
            // Target offline
            playerUsing.sendSystemMessage(Component.translatable(stack.getDescriptionId() + ".offline", ChatFormatting.RED + friendName));
            TC_LOGGER.info("[FriendshipBracelet] {} attempted to teleport to {} but they are offline or not a ServerPlayer",
                    playerUsing.getName().getString(), friendName);
        }
    }

    public static boolean isDimensionBlacklisted(@NotNull Level level) {
        ResourceLocation dimId = level.dimension().location();
        List<? extends String> blacklist = Config.getDimensionBlacklist();
        return blacklist.contains(dimId.toString());
    }

    // ---------- CURIO KEYBIND USE METHOD ----------
    public void useFromCurios(@NotNull Player playerUsing, @NotNull ItemStack stack) {
        Level level = playerUsing.level;

        if (!level.isClientSide && stack.getTag() != null && !stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG).isEmpty()) {
            String braceletMakerName = stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG);

            if (braceletMakerName.equalsIgnoreCase(playerUsing.getGameProfile().getName())) {
                if (playerUsing instanceof ServerPlayer serverPlayerUsing) {
                    // teleport to self if effect not applied
                    if (!serverPlayerUsing.hasEffect(TCMobEffects.TELEPORTATION_SICKNESS.get())) {
                        teleportToSelf(serverPlayerUsing, stack, level);
                        braceletUsed(level, playerUsing, stack, null); // hand null for Curios
                    }
                }
            }
            else {
                if (playerUsing instanceof ServerPlayer serverPlayerUsing) {
                    // teleport to self if effect not applied
                    if (!serverPlayerUsing.hasEffect(TCMobEffects.TELEPORTATION_SICKNESS.get())) {
                        teleportToFriend(serverPlayerUsing, braceletMakerName, stack);
                        braceletUsed(level, playerUsing, stack, null);
                    }
                }
            }
        }
        else if (!level.isClientSide && (stack.getTag() == null || stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG).isEmpty())) {
            final CompoundTag itemTag = stack.getOrCreateTag();
            itemTag.putString(PlayerUtil.BRACELET_MAKER_TAG, playerUsing.getGameProfile().getName());

            playerUsing.sendSystemMessage(Component.translatable(stack.getDescriptionId() + ".linked").withStyle(ChatFormatting.GOLD));
        }
    }

    // ---------- NAME & TOOLTIP METHODS ----------

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        if (stack.hasTag() && stack.getTag() != null && stack.getTag().contains(PlayerUtil.BRACELET_MAKER_TAG)) {
            String braceletMaker = stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG);
            return Component.literal(braceletMaker + "'s ").append(Component.translatable(this.getDescriptionId(stack)));
        }
        return super.getName(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag tooltipFlag) {
        if (stack.getTag() != null && !stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG).isEmpty()) {
            String braceletMakerName = stack.getTag().getString(PlayerUtil.BRACELET_MAKER_TAG);
            tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + "bracelet_linked_player")
                    .append(braceletMakerName).withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        }
        else {
            tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + "bracelet_not_linked")
                    .withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        }

        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + "bracelet_use_info")
                    .withStyle(ChatFormatting.GRAY));
        }
        else {
            tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + "shift.hover")
                    .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        }

        super.appendHoverText(stack, level, tooltips, tooltipFlag);
    }
}