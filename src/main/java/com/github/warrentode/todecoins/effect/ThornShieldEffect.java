package com.github.warrentode.todecoins.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class ThornShieldEffect extends MobEffect {
    static int amplifier;

    protected ThornShieldEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.BENEFICIAL, 0xB8860B);
        // deal dmg back to the attacker during the living hurt event in the ModEvents class
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        super.applyEffectTick(livingEntity, amplifier);

        // deals dmg back to the attacker during the living hurt event in the ModEvents class
    }

    public static int getAmplifier() {
        return amplifier;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}