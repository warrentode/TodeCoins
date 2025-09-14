package com.github.warrentode.todecoins.item.custom.collectible.sets;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.integration.curios.CurioCapabilityProvider;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinItem;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinMaterial;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinSetDefinitions;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.github.warrentode.todecoins.datagen.translations.TooltipTranslations.*;
import static com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinSetDefinitions.getEffectTooltipString;

public class CelebrationCoinItem extends CollectibleCoinItem {
    private final CollectibleCoinMaterial material;
    private final CollectibleCoinSetDefinitions coinSet;

    public CelebrationCoinItem(@NotNull CollectibleCoinMaterial material, @NotNull CollectibleCoinSetDefinitions coinSet, @NotNull Properties properties) {
        super(material, coinSet, properties.durability(material.getMaxDurability()));
        this.material = material;
        this.coinSet = coinSet; // store which set this coin belongs to
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        if (!ModList.get().isLoaded("curios")) {
            return null;
        }
        // Delegate to a helper class that only exists if Curios is loaded
        return CurioCapabilityProvider.initCapabilities(stack, nbt);
    }

    // sub coin variables
    static final TagKey<Item> subCoinTag1 = TCItemTags.ANNIVERSARY_COINS_TAG;
    static final TagKey<Item> subCoinTag2 = TCItemTags.EASTER_COIN_TAG;
    static final TagKey<Item> subCoinTag3 = TCItemTags.BIRTHDAY_COIN_TAG;
    static final TagKey<Item> subCoinTag4 = TCItemTags.HALLOWEEN_COIN_TAG;
    static final TagKey<Item> subCoinTag5 = TCItemTags.CHRISTMAS_COIN_TAG;
    static final TagKey<Item> subCoinTag6 = TCItemTags.NEW_YEAR_COIN_TAG;
    static final TagKey<Item> subCoinTag7 = TCItemTags.HERO_COINS_TAG;
    // sub coin effect variables
    static final MobEffect subEffect1 = TCMobEffects.UNHINDERED.get();
    static final MobEffect subEffect2 = MobEffects.JUMP;
    static final MobEffect subEffect3 = TCMobEffects.HEALING_MIST.get();
    static final MobEffect subEffect4 = MobEffects.NIGHT_VISION;
    static final MobEffect subEffect5 = TCMobEffects.FROST_STRIKE.get();
    static final MobEffect subEffect6 = MobEffects.REGENERATION;
    static final MobEffect subEffect7 = TCMobEffects.GLOWING_AURA.get();

    // Sub-coin tags
    @SuppressWarnings("unchecked")
    private final TagKey<Item>[] subCoinTags = new TagKey[]{
            subCoinTag1, subCoinTag2, subCoinTag3, subCoinTag4,
            subCoinTag5, subCoinTag6, subCoinTag7
    };

    // Corresponding sub-effects
    private final MobEffect[] subEffects = new MobEffect[]{
            subEffect1, subEffect2, subEffect3, subEffect4,
            subEffect5, subEffect6, subEffect7
    };

    public final int getCoinEffectDuration() {
        return material.getEffectDuration();
    }

    public final int getCoinEffectAmplifier() {
        return material.getEffectAmplifier();
    }

    @Override
    public final @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // get the set effect
        MobEffect setEffect = coinSet.getSetEffect();
        // check if set effect is present
        boolean hasSetEffect = player.hasEffect(setEffect);

        // apply effects conditionally
        if (!hasSetEffect) {
            if (!player.level.isClientSide) {
                // apply effects
                player.addEffect(new MobEffectInstance(setEffect, getCoinEffectDuration(), getCoinEffectAmplifier(), false, false, true));

                for (int i = 0; i < subCoinTags.length; i++) {
                    if (subCoinTags[i] != null && stack.is(subCoinTags[i])) {
                        MobEffect subEffect = subEffects[i];
                        if (subEffect != null && !player.hasEffect(subEffect)) {
                            player.addEffect(new MobEffectInstance(subEffect, getCoinEffectDuration(), getCoinEffectAmplifier(), false, false, true));
                        }
                    }
                }

                // durability handling
                if (stack.getDamageValue() >= material.getMaxDurability() - 1) {
                    stack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(InteractionHand.MAIN_HAND));
                }
                else {
                    stack.hurt(1, new SingleThreadedRandomSource(1), (ServerPlayer) player);
                }
            }

            // coin use sound and particles
            clientSeasonSoundParticles(player, player.level, stack);

            // use check sucessful
            return InteractionResultHolder.success(stack);
        }
        // prevent item use on failed checks
        return InteractionResultHolder.fail(stack);
    }

    // use method for curio keybind
    @Override
    public void useFromCurios(@NotNull Player player, ItemStack stack) {
        MobEffect setEffect = coinSet.getSetEffect();
        boolean hasSetEffect = player.hasEffect(setEffect);

        if (!hasSetEffect) {
            if (!player.level.isClientSide) {
                // apply effects
                player.addEffect(new MobEffectInstance(setEffect, getCoinEffectDuration(), getCoinEffectAmplifier(), false, false, true));

                for (int i = 0; i < subCoinTags.length; i++) {
                    if (subCoinTags[i] != null && stack.is(subCoinTags[i])) {
                        MobEffect subEffect = subEffects[i];
                        if (subEffect != null && !player.hasEffect(subEffect)) {
                            player.addEffect(new MobEffectInstance(subEffect, getCoinEffectDuration(), getCoinEffectAmplifier(), false, false, true));
                        }
                    }
                }

                // durability handling
                if (stack.getDamageValue() >= material.getMaxDurability() - 1) {
                    stack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(InteractionHand.MAIN_HAND));
                }
                else {
                    stack.hurt(1, new SingleThreadedRandomSource(1), (ServerPlayer) player);
                }
            }

            // coin use sound & particles
            if (player.level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
                serverSeasonalSoundParticles(serverLevel, serverPlayer, stack);
            }
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        if (stack.is(TCItemTags.HERO_COINS_TAG)) {
            tooltips.add(Component.translatable(tooltipPrefix + setCountTipKey4).withStyle(ChatFormatting.LIGHT_PURPLE));
        }
        else if (stack.is(TCItemTags.PATRON_COINS_TAG)) {
            tooltips.add(Component.translatable(tooltipPrefix + patronCoinCountTipKey).withStyle(ChatFormatting.LIGHT_PURPLE));
        }
        else if (stack.is(TCItemTags.HOLIDAY_COINS_TAG)) {
            tooltips.add(Component.translatable(tooltipPrefix + holidayCoinCountTipKey).withStyle(ChatFormatting.LIGHT_PURPLE));
        }

        // set coin use effect tooltips
        if (stack.getItem() instanceof CollectibleCoinItem setCoin) {
            MobEffect setEffect = setCoin.getCoinSet().getSetEffect();
            MobEffect subSetEffect = null;

            if (stack.is(subCoinTag1)) {
                subSetEffect = subEffect1;
            }
            else if (stack.is(subCoinTag2)) {
                subSetEffect = subEffect2;
            }
            else if (stack.is(subCoinTag3)) {
                subSetEffect = subEffect3;
            }
            else if (stack.is(subCoinTag4)) {
                subSetEffect = subEffect4;
            }
            else if (stack.is(subCoinTag5)) {
                subSetEffect = subEffect5;
            }
            else if (stack.is(subCoinTag6)) {
                subSetEffect = subEffect6;
            }
            else if (stack.is(subCoinTag7)) {
                subSetEffect = subEffect7;
            }

            if (subSetEffect != null) {
                tooltips.add(Component.translatable(coinUseTipPrefix).withStyle(ChatFormatting.GOLD));
                tooltips.add((Component.translatable(getEffectTooltipString(setEffect)).withStyle(ChatFormatting.BLUE)));
                tooltips.add(Component.translatable(getEffectTooltipString(subSetEffect)).withStyle(ChatFormatting.BLUE));
            }
        }

        if (Screen.hasShiftDown()) {
            if (stack.is(TCItemTags.LIFETIME_COINS_TAG)) {
                tooltips.add(Component.translatable(tooltipPrefix + lifetimeCoinCountTipKey).withStyle(ChatFormatting.GOLD));
            }
            else if (stack.is(TCItems.COLLECTIBLE_COIN_PATRON_CARNATION.get())) {
                tooltips.add(Component.translatable(tooltipPrefix + "collectible_coin_patron_carnation").withStyle(ChatFormatting.GOLD));
            }
            else if (stack.is(TCItems.COLLECTIBLE_COIN_PATRON_COSMOS.get())) {
                tooltips.add(Component.translatable(tooltipPrefix + "collectible_coin_patron_cosmos").withStyle(ChatFormatting.GOLD));
            }
            else if (stack.is(TCItems.COLLECTIBLE_COIN_PATRON_SUNFLOWER.get())) {
                tooltips.add(Component.translatable(tooltipPrefix + "collectible_coin_patron_sunflower").withStyle(ChatFormatting.GOLD));
            }
        }
        super.appendHoverText(stack, level, tooltips, flag);
    }
}