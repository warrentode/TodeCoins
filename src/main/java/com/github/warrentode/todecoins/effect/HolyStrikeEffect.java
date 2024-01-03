package com.github.warrentode.todecoins.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class HolyStrikeEffect extends MobEffect {
    static int amplifier;

    protected HolyStrikeEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.BENEFICIAL, 0xFFF8DC);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        super.applyEffectTick(livingEntity, amplifier);
        // applies slowness and deals extra damage to undead attack targets during the living attack event in the ModEvents class
    }

    public static int getAmplifier() {
        return amplifier;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}