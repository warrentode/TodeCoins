package com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday;

import com.github.warrentode.todecoins.integration.SereneSeasonsCompat;
import com.github.warrentode.todecoins.item.custom.CollectibleCoin;
import com.github.warrentode.todecoins.util.CalendarUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.common.capability.CurioItemCapability;

import javax.annotation.Nonnull;
import java.util.List;

public class NewYearCoinItem extends CollectibleCoin implements ICurioItem {
    public NewYearCoinItem(Properties pProperties) {
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
            public int getFortuneLevel(SlotContext slotContext, @Nullable LootContext lootContext) {
                return 1;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity livingEntity = slotContext.entity();
                MinecraftServer server = livingEntity != null ? livingEntity.getServer() : null;
                ServerLevel serverLevel = server != null ? server.getLevel(livingEntity.level.dimension()) : null;

                if (livingEntity != null && !livingEntity.level.isClientSide()) {
                    if (ModList.get().isLoaded("sereneseasons") && SereneSeasonsCompat.isNewYear(serverLevel)) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                false, false, true));
                    }
                    else if (CalendarUtil.isNewYear() && !ModList.get().isLoaded("sereneseasons")) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 200, 0,
                                false, false, true));
                    }
                    else {
                        livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
                    }
                }
            }

            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                livingEntity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
            }

            @Nonnull
            @Override
            public SoundInfo getEquipSound(SlotContext context) {
                return new SoundInfo(SoundEvents.CHAIN_STEP, 1.0F, 1.5F);
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
                tooltips.add(Component.translatable("tooltips.coin_effects.new_year_hero").withStyle(ChatFormatting.BLUE));
                return ICurio.super.getSlotsTooltip(tooltips);
            }
        });
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> tooltips, @NotNull TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltips.collectible_coin_new_year.hover").withStyle(ChatFormatting.GRAY));
        }
        else {
            tooltips.add(Component.translatable("tooltips.shift.hover").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(pStack, pLevel, tooltips, pIsAdvanced);
    }
}