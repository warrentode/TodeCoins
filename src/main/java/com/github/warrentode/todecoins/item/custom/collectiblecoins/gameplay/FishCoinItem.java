package com.github.warrentode.todecoins.item.custom.collectiblecoins.gameplay;

import com.github.warrentode.todecoins.attribute.*;
import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import com.github.warrentode.todecoins.util.tags.ModTags;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
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

public class FishCoinItem extends CollectibleCoin implements ICurioItem {
    public FishCoinItem(Properties pProperties) {
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
                if (stack.is(ModTags.Items.COD_COIN_SET)) {
                    attribute.put(ModAttributes.COD_BONUS.get(),
                            new AttributeModifier(ModAttributes.COD_BONUS_MODIFIER_UUID,
                                    ModAttributes.COD_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModTags.Items.PUFFERFISH_COIN_SET)) {
                    attribute.put(ModAttributes.PUFFERFISH_BONUS.get(),
                            new AttributeModifier(ModAttributes.PUFFERFISH_BONUS_MODIFIER_UUID,
                                    ModAttributes.PUFFERFISH_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModTags.Items.SALMON_COIN_SET)) {
                    attribute.put(ModAttributes.SALMON_BONUS.get(),
                            new AttributeModifier(ModAttributes.SALMON_BONUS_MODIFIER_UUID,
                                    ModAttributes.SALMON_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                else if (stack.is(ModTags.Items.TROPICAL_FISH_COIN_SET)) {
                    attribute.put(ModAttributes.TROPICAL_FISH_BONUS.get(),
                            new AttributeModifier(ModAttributes.TROPICAL_FISH_BONUS_MODIFIER_UUID,
                                    ModAttributes.TROPICAL_FISH_BONUS_MODIFIER_NAME, 1,
                                    AttributeModifier.Operation.ADDITION));
                    return attribute;
                }
                return attribute;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
                    //noinspection deprecation
                    if (livingEntity.isEyeInFluid(FluidTags.WATER)) {

                        int i = 0;
                        if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                            i = 1;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                            i = 2;
                        }
                        else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                            i = 3;
                        }
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, i,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onEquip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onEquip(slotContext, prevStack);
                if (stack.is(ModTags.Items.COD_COIN_SET)) {
                    PlayerCodBonus.addBonus(1);
                }
                if (stack.is(ModTags.Items.PUFFERFISH_COIN_SET)) {
                    PlayerPufferfishBonus.addBonus(1);
                }
                if (stack.is(ModTags.Items.SALMON_COIN_SET)) {
                    PlayerSalmonBonus.addBonus(1);
                }
                if (stack.is(ModTags.Items.TROPICAL_FISH_COIN_SET)) {
                    PlayerTropicalFishBonus.addBonus(1);
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                livingEntity.removeEffect(MobEffects.WATER_BREATHING);

                if (stack.is(ModTags.Items.COD_COIN_SET)) {
                    PlayerCodBonus.subtractBonus(1);
                }
                if (stack.is(ModTags.Items.PUFFERFISH_COIN_SET)) {
                    PlayerPufferfishBonus.subtractBonus(1);
                }
                if (stack.is(ModTags.Items.SALMON_COIN_SET)) {
                    PlayerSalmonBonus.subtractBonus(1);
                }
                if (stack.is(ModTags.Items.TROPICAL_FISH_COIN_SET)) {
                    PlayerTropicalFishBonus.subtractBonus(1);
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
                tooltips.add(Component.translatable("tooltips.coin_effects.fishing_loot").withStyle(ChatFormatting.BLUE));
                tooltips.add(Component.translatable("tooltips.coin_effects.water_breathing").withStyle(ChatFormatting.BLUE));
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        tooltips.add(Component.translatable("tooltips.collectible_fish_coin.hover").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }
}