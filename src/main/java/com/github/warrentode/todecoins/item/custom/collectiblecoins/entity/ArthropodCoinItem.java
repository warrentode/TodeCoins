package com.github.warrentode.todecoins.item.custom.collectiblecoins.entity;

import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import com.github.warrentode.todecoins.util.tags.ModTags;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
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

public class ArthropodCoinItem extends CollectibleCoin implements ICurioItem {
    public ArthropodCoinItem(Properties pProperties) {
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
            public boolean canWalkOnPowderedSnow(SlotContext slotContext) {
                return stack.is(ModTags.Items.SILVERFISH_COIN_SET);
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                LivingEntity livingEntity = slotContext.entity();

                if (livingEntity != null) {
                    double d = 0;
                    if (livingEntity.level.getDifficulty() == Difficulty.EASY) {
                        d = 0.01;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.NORMAL) {
                        d = 0.02;
                    }
                    else if (livingEntity.level.getDifficulty() == Difficulty.HARD) {
                        d = 0.03;
                    }
                    attribute.put(Attributes.MOVEMENT_SPEED,
                            new AttributeModifier(uuid, "generic.movement_speed", 0.01 + d,
                                    AttributeModifier.Operation.ADDITION));
                }

                return attribute;
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
                tooltips.add(Component.translatable("tooltips.coin_effects.arthropod_damage").withStyle(ChatFormatting.BLUE));
                if (stack.is(ModTags.Items.SILVERFISH_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects.snow_walk").withStyle(ChatFormatting.BLUE));
                }
                if (stack.is(ModTags.Items.BEE_COIN_SET) || stack.is(ModTags.Items.CAVE_SPIDER_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects.poison_attack").withStyle(ChatFormatting.BLUE));
                }
                if (stack.is(ModTags.Items.SPIDER_COIN_SET)) {
                    tooltips.add(Component.translatable("tooltips.coin_effects.slow_attack").withStyle(ChatFormatting.BLUE));
                }
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        tooltips.add(Component.translatable("tooltips.collectible_arthropod_coin.hover").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }
}