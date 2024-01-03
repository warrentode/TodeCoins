package com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday;

import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.attribute.PlayerCharisma;
import com.github.warrentode.todecoins.effect.ModEffects;
import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.CollectibleCoinProperties;
import com.github.warrentode.todecoins.util.CalendarUtil;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
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

public class ChristmasCoinItem extends CollectibleCoin implements ICurioItem {
    private CollectibleCoinProperties.Material material;
    private int coinEffectDuration;
    private int coinEffectAmplifier;

    public ChristmasCoinItem(Properties properties, @NotNull CollectibleCoinProperties.Material material) {
        super(properties);
        this.material = material.getCoinMaterial();
        this.coinEffectDuration = material.getCoinMaterialEffectDuration();
        this.coinEffectAmplifier = material.getCoinMaterialEffectAmplifier();
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
            public boolean canWalkOnPowderedSnow(SlotContext slotContext) {
                return true;
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                attribute.put(Attributes.MAX_HEALTH,
                        new AttributeModifier(uuid, "generic.max_health", 2,
                                AttributeModifier.Operation.ADDITION));
                attribute.put(Attributes.LUCK,
                        new AttributeModifier(uuid, "generic.luck", 1,
                                AttributeModifier.Operation.ADDITION));
                attribute.put(ModAttributes.CHARISMA.get(),
                        new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 1,
                                AttributeModifier.Operation.ADDITION));
                return attribute;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();

                if (livingEntity != null && !livingEntity.level.isClientSide()
                        && (!livingEntity.hasEffect(MobEffects.HERO_OF_THE_VILLAGE) || !livingEntity.hasEffect(ModEffects.HEALING_MIST.get()))) {
                    if (CalendarUtil.check("CHRISTMAS")) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, getCoinEffectDuration(), getCoinEffectAmplifier(),
                                false, false, true));
                        livingEntity.addEffect(new MobEffectInstance(ModEffects.HEALING_MIST.get(), getCoinEffectDuration(), getCoinEffectAmplifier(),
                                false, false, true));

                        stack.hurtAndBreak(1, livingEntity, (livingEntity1) -> curioBreak(slotContext));
                    }
                }
            }

            @Override
            public void onEquip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onEquip(slotContext, prevStack);
                PlayerCharisma.addCharisma(1);
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onUnequip(slotContext, prevStack);
                PlayerCharisma.subtractCharisma(1);
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
                tooltips.add(Component.translatable("tooltips.coin_effects.snow_walk").withStyle(ChatFormatting.BLUE));
                tooltips.add(Component.translatable("tooltips.coin_effects_holiday").withStyle(ChatFormatting.GOLD));
                tooltips.add(Component.translatable(MobEffects.HERO_OF_THE_VILLAGE.getDescriptionId()).withStyle(ChatFormatting.BLUE));
                tooltips.add(Component.translatable(ModEffects.HEALING_MIST.get().getDescriptionId()).withStyle(ChatFormatting.BLUE));
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltips.collectible_coin_christmas.hover").withStyle(ChatFormatting.GRAY));
        }
        else {
            tooltips.add(Component.translatable("tooltips.shift.hover").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, tooltips, flag);
    }
}