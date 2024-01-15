package com.github.warrentode.todecoins.item.custom.collectiblecoins.entity;


import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.CollectibleCoinProperties;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
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

public class MuleCoinItem extends CollectibleCoin implements ICurioItem {
    private CollectibleCoinProperties.Material material;
    private int coinEffectDuration;
    private int coinEffectAmplifier;

    public MuleCoinItem(Properties properties, @NotNull CollectibleCoinProperties.Material material) {
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

                // material based attributes
                if (getCoinMaterial() == CollectibleCoinProperties.Material.COPPER) {
                    attribute.put(Attributes.MAX_HEALTH,
                            new AttributeModifier(uuid, "generic.max_health", 2,
                                    AttributeModifier.Operation.ADDITION));
                }
                if (getCoinMaterial() == CollectibleCoinProperties.Material.IRON) {
                    attribute.put(Attributes.ATTACK_DAMAGE,
                            new AttributeModifier(uuid, "generic.attack_damage", 1,
                                    AttributeModifier.Operation.ADDITION));
                }
                if (getCoinMaterial() == CollectibleCoinProperties.Material.GOLDEN) {
                    attribute.put(Attributes.ATTACK_SPEED,
                            new AttributeModifier(uuid, "generic.attack_speed", 1,
                                    AttributeModifier.Operation.ADDITION));
                }
                if (getCoinMaterial() == CollectibleCoinProperties.Material.NETHERITE) {
                    attribute.put(Attributes.KNOCKBACK_RESISTANCE,
                            new AttributeModifier(uuid, "generic.knockback_resistance", 0.1,
                                    AttributeModifier.Operation.ADDITION));
                }


                attribute.put(Attributes.ARMOR_TOUGHNESS,
                        new AttributeModifier(uuid, "generic.armor_toughness", 1,
                                AttributeModifier.Operation.ADDITION));
                attribute.put(Attributes.MOVEMENT_SPEED,
                        new AttributeModifier(uuid, "generic.movement_speed", 0.01,
                                AttributeModifier.Operation.ADDITION));

                return attribute;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();

                if (livingEntity != null && !livingEntity.level.isClientSide()
                        && (!livingEntity.hasEffect(MobEffects.JUMP) || !livingEntity.hasEffect(MobEffects.HEALTH_BOOST))) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, getCoinEffectDuration(), getCoinEffectAmplifier(),
                            false, false, true));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, getCoinEffectDuration(), getCoinEffectAmplifier(),
                            false, false, true));

                    stack.hurtAndBreak(1, livingEntity, (livingEntity1) -> curioBreak(slotContext));
                }
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 2.0F);
            }

            @Override
            public void onEquip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onEquip(slotContext, prevStack);
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onUnequip(slotContext, prevStack);
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
                tooltips.add(Component.translatable(MobEffects.JUMP.getDescriptionId()).withStyle(ChatFormatting.BLUE));
                tooltips.add(Component.translatable(MobEffects.HEALTH_BOOST.getDescriptionId()).withStyle(ChatFormatting.BLUE));
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }
}