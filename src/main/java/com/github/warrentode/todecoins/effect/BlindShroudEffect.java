package com.github.warrentode.todecoins.effect;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BlindShroudEffect extends MobEffect {
    static int amplifier;

    protected BlindShroudEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.BENEFICIAL, 0x708090);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.hasEffect(MobEffects.BLINDNESS)) {
                serverPlayer.removeEffect(MobEffects.BLINDNESS);
            }
        }
    }

    public static int getAmplifier() {
        return amplifier;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}