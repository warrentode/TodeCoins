package com.github.warrentode.todecoins.item.custom.collectiblecoins.entity;

import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import com.github.warrentode.todecoins.util.tags.ModTags;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.common.capability.CurioItemCapability;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

public class UndeadCoinItem extends CollectibleCoin implements ICurioItem {
    public UndeadCoinItem(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    attribute.put(Attributes.ARMOR_TOUGHNESS,
                            new AttributeModifier(uuid, "generic.armor_toughness", 1,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    if (stack.is(ModTags.Items.DROWNED_COIN_SET)) {
                        //noinspection deprecation
                        if (livingEntity.isEyeInFluid(FluidTags.WATER)) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0,
                                    false, false, false));
                        }
                    }
                    if (stack.is(ModTags.Items.PHANTOM_COIN_SET)) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (stack.is(ModTags.Items.DROWNED_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.WATER_BREATHING);
                }
                if (stack.is(ModTags.Items.PHANTOM_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.SLOW_FALLING);
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public boolean canEquipFromUse(SlotContext context) {
                return true;
            }

            @Override
            public boolean canSync(SlotContext context) {
                return true;
            }

            @Nonnull
            @Override
            public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
                return DropRule.DEFAULT;
            }

            @Override
            public List<Component> getSlotsTooltip(List<Component> tooltips) {
                tooltips.add(Component.translatable("tooltips.coin_effects").withStyle(ChatFormatting.GOLD));
                tooltips.add(Component.translatable("tooltips.coin_effects.undead_damage").withStyle(ChatFormatting.BLUE));

                if (stack.is(ModTags.Items.DROWNED_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects.water_breathing").withStyle(ChatFormatting.BLUE));
                }
                if (stack.is(ModTags.Items.STRAY_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects.slow_attack").withStyle(ChatFormatting.BLUE));
                }
                if (stack.is(ModTags.Items.WITHER_SKELETON_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects.wither_attack").withStyle(ChatFormatting.BLUE));
                }
                if (stack.is(ModTags.Items.PHANTOM_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects.slow_fall").withStyle(ChatFormatting.BLUE));
                }
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        tooltips.add(Component.translatable("tooltips.collectible_undead_coin.hover").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }
}