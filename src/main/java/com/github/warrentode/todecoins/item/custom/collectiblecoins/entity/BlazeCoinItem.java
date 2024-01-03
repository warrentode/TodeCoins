package com.github.warrentode.todecoins.item.custom.collectiblecoins.entity;

import com.github.warrentode.todecoins.effect.ModEffects;
import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.CollectibleCoinProperties;
import com.github.warrentode.todecoins.util.tags.ModTags;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
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

public class BlazeCoinItem extends CollectibleCoin implements ICurioItem {
    private CollectibleCoinProperties.Material material;
    private int coinEffectDuration;
    private int coinEffectAmplifier;

    public BlazeCoinItem(Properties properties, @NotNull CollectibleCoinProperties.Material material) {
        super(properties);
        this.material = material.getCoinMaterial();
        this.coinEffectDuration = material.getCoinMaterialEffectDuration();
        this.coinEffectAmplifier = material.getCoinMaterialEffectAmplifier();
    }

    public CollectibleCoinProperties.Material getCoinMaterial() {
        return this.material;
    }

    public int getCoinEffectDuration() {
        return this.coinEffectDuration;
    }

    public int getCoinEffectAmplifier() {
        return this.coinEffectAmplifier;
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

                // material based attributes
                if (getCoinMaterial() == CollectibleCoinProperties.Material.COPPER) {
                    if (stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                        attribute.put(Attributes.MAX_HEALTH,
                                new AttributeModifier(uuid, "generic.max_health", 4,
                                        AttributeModifier.Operation.ADDITION));
                    }
                    else {
                        attribute.put(Attributes.MAX_HEALTH,
                                new AttributeModifier(uuid, "generic.max_health", 2,
                                        AttributeModifier.Operation.ADDITION));
                    }
                }
                if (getCoinMaterial() == CollectibleCoinProperties.Material.IRON) {
                    if (stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                        attribute.put(Attributes.ATTACK_DAMAGE,
                                new AttributeModifier(uuid, "generic.attack_damage", 2,
                                        AttributeModifier.Operation.ADDITION));
                    }
                    else {
                        attribute.put(Attributes.ATTACK_DAMAGE,
                                new AttributeModifier(uuid, "generic.attack_damage", 1,
                                        AttributeModifier.Operation.ADDITION));
                    }
                }
                if (getCoinMaterial() == CollectibleCoinProperties.Material.GOLDEN) {
                    if (stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                        attribute.put(Attributes.ATTACK_SPEED,
                                new AttributeModifier(uuid, "generic.attack_speed", 2,
                                        AttributeModifier.Operation.ADDITION));
                    }
                    else {
                        attribute.put(Attributes.ATTACK_SPEED,
                                new AttributeModifier(uuid, "generic.attack_speed", 1,
                                        AttributeModifier.Operation.ADDITION));
                    }
                }
                if (getCoinMaterial() == CollectibleCoinProperties.Material.NETHERITE) {
                    if (stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                        attribute.put(Attributes.KNOCKBACK_RESISTANCE,
                                new AttributeModifier(uuid, "generic.knockback_resistance", 0.2,
                                        AttributeModifier.Operation.ADDITION));
                    }
                    else {
                        attribute.put(Attributes.KNOCKBACK_RESISTANCE,
                                new AttributeModifier(uuid, "generic.knockback_resistance", 0.1,
                                        AttributeModifier.Operation.ADDITION));
                    }
                }

                if (stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                    attribute.put(Attributes.ATTACK_KNOCKBACK,
                            new AttributeModifier(uuid, "generic.attack_knockback", 2,
                                    AttributeModifier.Operation.ADDITION));
                    attribute.put(Attributes.ARMOR,
                            new AttributeModifier(uuid, "generic.armor", 2,
                                    AttributeModifier.Operation.ADDITION));
                }
                else {
                    attribute.put(Attributes.ATTACK_KNOCKBACK,
                            new AttributeModifier(uuid, "generic.attack_knockback", 1,
                                    AttributeModifier.Operation.ADDITION));
                    attribute.put(Attributes.ARMOR,
                            new AttributeModifier(uuid, "generic.armor", 1,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();

                if (livingEntity != null && !livingEntity.level.isClientSide()
                        && (!livingEntity.hasEffect(MobEffects.FIRE_RESISTANCE) || !livingEntity.hasEffect(ModEffects.BURNING_STRIKE.get())
                        || !livingEntity.hasEffect(ModEffects.HEALING_MIST.get()))) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, getCoinEffectDuration(), getCoinEffectAmplifier(),
                            false, false, true));
                    livingEntity.addEffect(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), getCoinEffectDuration(), getCoinEffectAmplifier(),
                            false, false, true));

                    if (stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                        livingEntity.addEffect(new MobEffectInstance(ModEffects.HEALING_MIST.get(), getCoinEffectDuration(), getCoinEffectAmplifier(),
                                false, false, true));
                    }

                    if (stack.is(ModTags.Items.WILDFIRE_COIN_SET) && RandomSource.create().nextInt(100) > 50) {
                        stack.hurtAndBreak(1, livingEntity, (livingEntity1) -> curioBreak(slotContext));
                    }
                    else {
                        stack.hurtAndBreak(1, livingEntity, (livingEntity1) -> curioBreak(slotContext));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
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
                tooltips.add(Component.translatable(MobEffects.FIRE_RESISTANCE.getDescriptionId()).withStyle(ChatFormatting.BLUE));
                tooltips.add(Component.translatable(ModEffects.BURNING_STRIKE.get().getDescriptionId()).withStyle(ChatFormatting.BLUE));
                if (stack.is(ModTags.Items.WILDFIRE_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects_boss").withStyle(ChatFormatting.GOLD)
                            .withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.ITALIC));
                    tooltips.add(Component.translatable(ModEffects.HEALING_MIST.get().getDescriptionId())
                            .withStyle(ChatFormatting.BLUE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.ITALIC));
                }
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }
}