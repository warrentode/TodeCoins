package com.github.warrentode.todecoins.item.custom.collectiblecoins.entity;


import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.CollectibleCoinProperties;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

public class DolphinCoinItem extends CollectibleCoin implements ICurioItem {
    private CollectibleCoinProperties.Material material;
    private int coinEffectDuration;
    private int coinEffectAmplifier;

    public DolphinCoinItem(Properties properties, @NotNull CollectibleCoinProperties.Material material) {
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


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player playerUsing, @NotNull InteractionHand useHand) {
        ItemStack stack = playerUsing.getItemInHand(useHand);

        if (!level.isClientSide && (!playerUsing.hasEffect(MobEffects.DOLPHINS_GRACE) || !playerUsing.hasEffect(MobEffects.DIG_SPEED))) {
            level.playSound(null, playerUsing.getX(), playerUsing.getY(), playerUsing.getZ(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));

            playerUsing.getCooldowns().addCooldown(this, getCoinEffectDuration() / 2);

            playerUsing.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, getCoinEffectDuration(), getCoinEffectAmplifier(),
                    false, false, true));
            playerUsing.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, getCoinEffectDuration(), getCoinEffectAmplifier(),
                    false, false, true));

            stack.hurtAndBreak(1, playerUsing, (playerLambda) -> playerLambda.broadcastBreakEvent(useHand));

            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }

        return new InteractionResultHolder<>(InteractionResult.FAIL, stack);
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


                attribute.put(Attributes.ARMOR,
                        new AttributeModifier(uuid, "generic.armor", 1,
                                AttributeModifier.Operation.ADDITION));
                attribute.put(Attributes.ATTACK_KNOCKBACK,
                        new AttributeModifier(uuid, "generic.attack_knockback", 1,
                                AttributeModifier.Operation.ADDITION));

                return attribute;
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
                return false;
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
                tooltips.add(Component.translatable(MobEffects.DOLPHINS_GRACE.getDescriptionId()).withStyle(ChatFormatting.BLUE));
                tooltips.add(Component.translatable(MobEffects.DIG_SPEED.getDescriptionId()).withStyle(ChatFormatting.BLUE));
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }
}