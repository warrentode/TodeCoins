package com.github.warrentode.todecoins.integration;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;

public class CurioBeltSlot implements ICurio {

    private final ItemStack stack;

    public CurioBeltSlot(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public ItemStack getStack() {
        return this.stack;
    }

    @Nonnull
    @Override
    public SoundInfo getEquipSound(SlotContext context) {
        return new SoundInfo(SoundEvents.ARMOR_EQUIP_GENERIC, 1.0F, 1.5F);
    }

    @Override
    public boolean canEquipFromUse(SlotContext context) {
        return true;
    }

    @Nonnull
    @Override
    public DropRule getDropRule(SlotContext context, DamageSource source, int lootingLevel, boolean recentlyHit) {
        return DropRule.DEFAULT;
    }
}
