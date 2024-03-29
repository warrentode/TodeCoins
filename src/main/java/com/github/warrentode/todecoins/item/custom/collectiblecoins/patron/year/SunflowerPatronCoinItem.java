package com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.year;

import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.attribute.PlayerCharisma;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.CollectibleCoinProperties;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.PatronCommemorativeCoinItem;
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
import net.minecraft.world.item.Item;
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

public class SunflowerPatronCoinItem extends PatronCommemorativeCoinItem implements ICurioItem {
    private CollectibleCoinProperties.Material material;
    private int coinEffectDuration;
    private int coinEffectAmplifier;

    public SunflowerPatronCoinItem(Item.Properties properties, @NotNull CollectibleCoinProperties.Material material) {
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
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attribute = LinkedHashMultimap.create();
                attribute.put(ModAttributes.CHARISMA.get(),
                        new AttributeModifier(ModAttributes.CHR_MODIFIER_UUID, ModAttributes.CHR_MODIFIER_NAME, 2,
                                AttributeModifier.Operation.ADDITION));
                attribute.put(Attributes.LUCK,
                        new AttributeModifier(uuid, "generic.luck", 1,
                                AttributeModifier.Operation.ADDITION));
                return attribute;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();

                if (livingEntity != null && !livingEntity.level.isClientSide()
                        && (!livingEntity.hasEffect(MobEffects.HERO_OF_THE_VILLAGE) || !livingEntity.hasEffect(MobEffects.LUCK))) {
                    if (CalendarUtil.check("ANNIVERSARY")) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, getCoinEffectDuration(), getCoinEffectAmplifier(),
                                false, false, true));
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.LUCK, getCoinEffectDuration(), getCoinEffectAmplifier(),
                                false, false, true));

                        stack.hurtAndBreak(1, livingEntity, (livingEntity1) -> curioBreak(slotContext));
                    }
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
                PlayerCharisma.addCharisma(2);
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack prevStack) {
                ICurio.super.onUnequip(slotContext, prevStack);
                PlayerCharisma.subtractCharisma(2);
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
                tooltips.add(Component.translatable("tooltips.coin_effects_holiday").withStyle(ChatFormatting.GOLD));
                tooltips.add(Component.translatable(MobEffects.HERO_OF_THE_VILLAGE.getDescriptionId()).withStyle(ChatFormatting.BLUE));
                tooltips.add(Component.translatable(MobEffects.LUCK.getDescriptionId()).withStyle(ChatFormatting.BLUE));
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltips.collectible_coin_sunflower.hover").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, tooltips, flag);
    }
}