package com.github.warrentode.todecoins.item.custom.collectible.sets;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.integration.CurioCapabilityProvider;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinItem;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinMaterial;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinSetDefinitions;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.github.warrentode.todecoins.datagen.translations.TooltipTranslations.*;
import static com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinSetDefinitions.getEffectTooltipString;

public class CurioCollectibleCoinItemTemplate extends CollectibleCoinItem {
    private final CollectibleCoinMaterial material;
    private final CollectibleCoinSetDefinitions coinSet;

    public CurioCollectibleCoinItemTemplate(@NotNull CollectibleCoinMaterial material, @NotNull CollectibleCoinSetDefinitions coinSet, @NotNull Properties properties) {
        super(material, properties.durability(material.getMaxDurability()));
        this.material = material;
        this.coinSet = coinSet; // store which set this coin belongs to
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return CurioCapabilityProvider.initCapabilities(stack, nbt);
    }

    public CollectibleCoinSetDefinitions getCoinSet() {
        return coinSet;
    }

    // sub coin variables
    static final TagKey<Item> subCoinTag1 = subSetTag1;
    static final TagKey<Item> subCoinTag2 = subSetTag2;
    static final TagKey<Item> subCoinTag3 = subSetTag3;
    static final TagKey<Item> subCoinTag4 = subSetTag4;
    static final TagKey<Item> subCoinTag5 = subSetTag5;
    static final TagKey<Item> subCoinTag6 = subSetTag6;
    static final TagKey<Item> subCoinTag7 = subSetTag7;
    static final TagKey<Item> subCoinTag8 = subSetTag8;
    // sub coin effect variables
    static final MobEffect subEffect1 = effect1;
    static final MobEffect subEffect2 = effect2;
    static final MobEffect subEffect3 = effect3;
    static final MobEffect subEffect4 = effect4;
    static final MobEffect subEffect5 = effect5;
    static final MobEffect subEffect6 = effect6;
    static final MobEffect subEffect7 = effect7;
    static final MobEffect subEffect8 = effect8;

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

        // sub set check variables
        boolean isSubCoin1 = stack.is(subCoinTag1);
        boolean isSubCoin2 = stack.is(subCoinTag2);
        boolean isSubCoin3 = stack.is(subCoinTag3);
        boolean isSubCoin4 = stack.is(subCoinTag4);
        boolean isSubCoin5 = stack.is(subCoinTag5);
        boolean isSubCoin6 = stack.is(subCoinTag6);
        boolean isSubCoin7 = stack.is(subCoinTag7);
        boolean isSubCoin8 = stack.is(subCoinTag8);
        // sub effect check variables
        boolean hasSubEffect1 = player.hasEffect(subEffect1);
        boolean hasSubEffect2 = player.hasEffect(subEffect2);
        boolean hasSubEffect3 = player.hasEffect(subEffect3);
        boolean hasSubEffect4 = player.hasEffect(subEffect4);
        boolean hasSubEffect5 = player.hasEffect(subEffect5);
        boolean hasSubEffect6 = player.hasEffect(subEffect6);
        boolean hasSubEffect7 = player.hasEffect(subEffect7);
        boolean hasSubEffect8 = player.hasEffect(subEffect8);

        // check for missing effects before use
        if (!hasSetEffect && ((isSubCoin1 && !hasSubEffect1) || (isSubCoin2 && !hasSubEffect2)
                || (isSubCoin3 && !hasSubEffect3) || (isSubCoin4 && !hasSubEffect4))
                || (isSubCoin5 && !hasSubEffect5) || (isSubCoin6 && !hasSubEffect6)
                || (isSubCoin7 && !hasSubEffect7) || (isSubCoin8 && !hasSubEffect8)) {

            // play coin use sound
            level.playSound(player, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.NEUTRAL,
                    0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

            // check for server side
            if (!level.isClientSide) {
                // apply set effect
                player.addEffect(new MobEffectInstance(setEffect,
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

                // damage or break the item
                if (stack.getDamageValue() >= material.getMaxDurability() - 1) {
                    stack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
                }
                else {
                    stack.hurt(1, new SingleThreadedRandomSource(1), (ServerPlayer) player);
                }
            }

            // particle effects for client side
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
        tooltips.add((Component.translatable(tooltipPrefix + coinTipKey4)).withStyle(ChatFormatting.LIGHT_PURPLE));

        if (stack.getItem() instanceof CurioCollectibleCoinItemTemplate setCoin) {
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
            else if (stack.is(subCoinTag8)) {
                subSetEffect = subEffect8;
            }

            if (subSetEffect != null) {
                tooltips.add(Component.translatable(coinUseTipPrefix).withStyle(ChatFormatting.GOLD));
                tooltips.add((Component.translatable(getEffectTooltipString(setEffect)).withStyle(ChatFormatting.BLUE)));
                tooltips.add(Component.translatable(getEffectTooltipString(subSetEffect)).withStyle(ChatFormatting.BLUE));
            }
        }

        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable(tooltipPrefix + "collectible_coin").withStyle(ChatFormatting.DARK_GRAY).withStyle(ChatFormatting.ITALIC));
        }
        else {
            tooltips.add(Component.translatable(tooltipPrefix + "shift.hover").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
    }
}