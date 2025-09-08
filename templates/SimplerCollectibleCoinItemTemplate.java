package com.github.warrentode.todecoins.item.custom.collectible.sets;

import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinItem;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinMaterial;
import com.github.warrentode.todecoins.util.translations.TooltipTranslations;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.github.warrentode.todecoins.util.seasonal.CalendarUtil.*;

public class CollectibleCoinItemSetTemplate extends CollectibleCoinItem {
    private final CollectibleCoinMaterial material;

    public CollectibleCoinItemSetTemplate(@NotNull CollectibleCoinMaterial material, Properties properties) {
        super(properties.durability(material.getMaxDurability()));
        this.material = material;
    }

    // main coin effect variables
    static final MobEffect mainEffect1 = desiredMainEffect1;
    static final MobEffect mainEffect2 = desiredMainEffect2;
    // sub coin effect variables
    static final MobEffect subEffect1 = desiredSubEffect1;
    static final MobEffect subEffect2 = desiredSubEffect2;
    static final MobEffect subEffect3 = desiredSubEffect3;
    static final MobEffect subEffect4 = desiredSubEffect4;
    static final MobEffect subEffect5 = desiredSubEffect5;
    static final MobEffect subEffect6 = desiredSubEffect6;
    static final MobEffect subEffect7 = desiredSubEffect7;
    static final MobEffect subEffect8 = desiredSubEffect8;
    static final MobEffect subEffect9 = desiredSubEffect9;
    static final MobEffect subEffect10 = desiredSubEffect10;
    static final MobEffect subEffect11 = desiredSubEffect11;
    static final MobEffect subEffect12 = desiredSubEffect12;
    static final MobEffect subEffect13 = desiredSubEffect13;
    static final MobEffect subEffect14 = desiredSubEffect14;
    // season effect variables
    static final MobEffect seasonEffect1 = desiredSeasonEffect1;
    static final MobEffect seasonEffect2 = desiredSeasonEffect2;
    static final MobEffect seasonEffect3 = desiredSeasonEffect3;
    static final MobEffect seasonEffect4 = desiredSeasonEffect4;

    // tooltip strings
    static final String coinTipKey = "collectible_coin_set_4"; // - total count of the sub set

    public final int getCoinEffectDuration() {
        return material.getEffectDuration();
    }

    public final int getCoinEffectAmplifier() {
        return material.getEffectAmplifier();
    }

    @Override
    public final @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // main effect check variables
        boolean hasMainEffect1 = player.hasEffect(mainEffect1);
        boolean hasMainEffect2 = player.hasEffect(mainEffect2);

        // ------------------------
        // Sub Coin Checks & Effects
        // ------------------------
        boolean isSubCoin1 = stack.is(subCoin1);
        boolean isSubCoin2 = stack.is(subCoin2);
        boolean isSubCoin3 = stack.is(subCoin3);
        boolean isSubCoin4 = stack.is(subCoin4);
        boolean isSubCoin5 = stack.is(subCoin5);
        boolean isSubCoin6 = stack.is(subCoin6);
        boolean isSubCoin7 = stack.is(subCoin7);
        boolean isSubCoin8 = stack.is(subCoin8);
        boolean isSubCoin9 = stack.is(subCoin9);
        boolean isSubCoin10 = stack.is(subCoin10);
        boolean isSubCoin11 = stack.is(subCoin11);
        boolean isSubCoin12 = stack.is(subCoin12);
        boolean isSubCoin13 = stack.is(subCoin13);
        boolean isSubCoin14 = stack.is(subCoin14);
        // sub effect check variables
        boolean hasSubEffect1 = player.hasEffect(subEffect1);
        boolean hasSubEffect2 = player.hasEffect(subEffect2);
        boolean hasSubEffect3 = player.hasEffect(subEffect3);
        boolean hasSubEffect4 = player.hasEffect(subEffect4);
        boolean hasSubEffect5 = player.hasEffect(subEffect5);
        boolean hasSubEffect6 = player.hasEffect(subEffect6);
        boolean hasSubEffect7 = player.hasEffect(subEffect7);
        boolean hasSubEffect8 = player.hasEffect(subEffect8);
        boolean hasSubEffect9 = player.hasEffect(subEffect9);
        boolean hasSubEffect10 = player.hasEffect(subEffect10);
        boolean hasSubEffect11 = player.hasEffect(subEffect11);
        boolean hasSubEffect12 = player.hasEffect(subEffect12);
        boolean hasSubEffect13 = player.hasEffect(subEffect13);
        boolean hasSubEffect14 = player.hasEffect(subEffect14);

        // season check variables
        boolean isSeason1 = isSpring;
        boolean isSeason2 = isSummer;
        boolean isSeason3 = isAutumn;
        boolean isSeason4 = isWinter;
        // season effect check variables
        boolean hasSeasonEffect1 = player.hasEffect(seasonEffect1);
        boolean hasSeasonEffect2 = player.hasEffect(seasonEffect2);
        boolean hasSeasonEffect3 = player.hasEffect(seasonEffect3);
        boolean hasSeasonEffect4 = player.hasEffect(seasonEffect4);

        // check for missing effects before use
        if (!hasMainEffect1 || !hasMainEffect2
                && ((isSubCoin1 && !hasSubEffect1) || (isSubCoin2 && !hasSubEffect2)
                || (isSubCoin3 && !hasSubEffect3) || (isSubCoin4 && !hasSubEffect4)
                || (isSubCoin5 && !hasSubEffect5) || (isSubCoin6 && !hasSubEffect6)
                || (isSubCoin7 && !hasSubEffect7) || (isSubCoin8 && !hasSubEffect8)
                || (isSubCoin9 && !hasSubEffect9) || (isSubCoin10 && !hasSubEffect10)
                || (isSubCoin11 && !hasSubEffect11) || (isSubCoin12 && !hasSubEffect12)
                || (isSubCoin13 && !hasSubEffect13) || (isSubCoin14 && !hasSubEffect14))) {

            // play coin use sound
            level.playSound(player, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.NEUTRAL,
                    0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

            // check for server side
            if (!level.isClientSide) {
                // apply main effects
                player.addEffect(new MobEffectInstance(mainEffect1,
                        getCoinEffectDuration(),
                        getCoinEffectAmplifier(),
                        false, false, true));
                player.addEffect(new MobEffectInstance(mainEffect2,
                        getCoinEffectDuration(),
                        getCoinEffectAmplifier(),
                        false, false, true));

                // check for sub coins
                if (isSubCoin1) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect1,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin2) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect2,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin3) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect3,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin4) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect4,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin5) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect5,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin6) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect6,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin7) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect7,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin8) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect8,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin9) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect9,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin10) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect10,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin11) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect11,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin12) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect12,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin13) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect13,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSubCoin14) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(subEffect14,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                // check for seasons - seasonal checks directly imported from CalendarUtil
                if (isSeason1 && !hasSeasonEffect1) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(seasonEffect1,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSeason2 && !hasSeasonEffect2) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(seasonEffect2,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSeason3 && !hasSeasonEffect3) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(seasonEffect3,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }
                else if (isSeason4 && !hasSeasonEffect4) {
                    // apply sub effect(s)
                    player.addEffect(new MobEffectInstance(seasonEffect4,
                            getCoinEffectDuration(),
                            getCoinEffectAmplifier(),
                            false, false, true));
                }

                // damage or break the item
                if (stack.getDamageValue() >= material.getMaxDurability() - 1) {
                    stack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
                }
                else {
                    stack.hurt(1, new SingleThreadedRandomSource(1), (ServerPlayer) player);
                }
            }

            // Particle ring around player - client side
            double centerX = player.getEyePosition().x();
            double centerY = player.getEyePosition().y();
            double centerZ = player.getEyePosition().z();

            int particleCount = 50;
            double radius = 1.5;

            // apply item use particles
            for (int i = 0; i < particleCount; i++) {
                double angle = 2 * Math.PI * i / particleCount;
                double offsetX = Math.cos(angle) * radius;
                double offsetZ = Math.sin(angle) * radius;
                double offsetY = (level.random.nextDouble() - 0.5) * 0.5; // small random vertical offset

                level.addParticle(ParticleTypes.HAPPY_VILLAGER,
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
            }

            // use check sucessful
            return InteractionResultHolder.success(stack);
        }
        // prevent item use on failed checks
        return InteractionResultHolder.fail(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        // set count tooltip
        tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + coinTipKey).withStyle(ChatFormatting.GOLD));

        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + "collectible_coin").withStyle(ChatFormatting.DARK_GRAY).withStyle(ChatFormatting.ITALIC));
        }
        else {
            tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + "shift.hover").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
    }
}