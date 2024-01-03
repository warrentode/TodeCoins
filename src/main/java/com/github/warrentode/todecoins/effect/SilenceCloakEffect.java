package com.github.warrentode.todecoins.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class SilenceCloakEffect extends MobEffect {
    protected SilenceCloakEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.BENEFICIAL, 0x87CEEB);

        // silences the entity under this effect
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}