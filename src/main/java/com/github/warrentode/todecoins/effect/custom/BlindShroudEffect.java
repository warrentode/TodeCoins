package com.github.warrentode.todecoins.effect.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BlindShroudEffect extends MobEffect {
    public BlindShroudEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
    }

    @Override
    public final void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.hasEffect(MobEffects.BLINDNESS)) {
                serverPlayer.removeEffect(MobEffects.BLINDNESS);
            }
        }
    }
}