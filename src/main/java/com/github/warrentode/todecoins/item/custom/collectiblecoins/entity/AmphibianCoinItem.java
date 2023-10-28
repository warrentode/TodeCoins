package com.github.warrentode.todecoins.item.custom.collectiblecoins.entity;

import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import com.github.warrentode.todecoins.util.tags.ModTags;
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

public class AmphibianCoinItem extends CollectibleCoin implements ICurioItem {
    public AmphibianCoinItem(Properties pProperties) {
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
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity != null) {
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

                    if (stack.is(ModTags.Items.AXOLOTL_COIN_SET) || stack.is(ModTags.Items.CRAB_COIN_SET)
                            || stack.is(ModTags.Items.TURTLE_COIN_SET) || stack.is(ModTags.Items.TADPOLE_COIN_SET)) {
                        //noinspection deprecation
                        if (livingEntity.isEyeInFluid(FluidTags.WATER)) {
                            livingEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, i,
                                    false, false, false));
                        }
                    }

                    if (stack.is(ModTags.Items.AXOLOTL_COIN_SET) || stack.is(ModTags.Items.PENGUIN_COIN_SET)) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, i,
                                false, false, false));
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (stack.is(ModTags.Items.AXOLOTL_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.WATER_BREATHING);
                    livingEntity.removeEffect(MobEffects.REGENERATION);
                }
                if (stack.is(ModTags.Items.PENGUIN_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.REGENERATION);
                }
                if (stack.is(ModTags.Items.CRAB_COIN_SET) || stack.is(ModTags.Items.TURTLE_COIN_SET) || stack.is(ModTags.Items.TADPOLE_COIN_SET)) {
                    livingEntity.removeEffect(MobEffects.WATER_BREATHING);
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
                if (stack.is(ModTags.Items.AXOLOTL_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects").withStyle(ChatFormatting.GOLD));
                    tooltips.add(Component.translatable("tooltips.water_breathing").withStyle(ChatFormatting.BLUE));
                    tooltips.add(Component.translatable("tooltips.regen").withStyle(ChatFormatting.BLUE));
                }
                if (stack.is(ModTags.Items.PENGUIN_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects").withStyle(ChatFormatting.GOLD));
                    tooltips.add(Component.translatable("tooltips.regen").withStyle(ChatFormatting.BLUE));
                }
                if (stack.is(ModTags.Items.CRAB_COIN_SET) || stack.is(ModTags.Items.TURTLE_COIN_SET) || stack.is(ModTags.Items.TADPOLE_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects").withStyle(ChatFormatting.GOLD));
                    tooltips.add(Component.translatable("tooltips.water_breathing").withStyle(ChatFormatting.BLUE));
                }
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        tooltips.add(Component.translatable("tooltips.collectible_amphibian_coin.hover").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }
}