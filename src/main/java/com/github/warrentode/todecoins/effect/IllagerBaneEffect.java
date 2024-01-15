package com.github.warrentode.todecoins.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class IllagerBaneEffect extends MobEffect {
    static int amplifier;

    protected IllagerBaneEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.BENEFICIAL, 0x696969);

        // applies slowness to the attack target if they are vexes, illagers, raiders, and patrolling monsters in the living attack event in the ModEvents class
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        super.applyEffectTick(livingEntity, amplifier);
    }

    public static int getAmplifier() {
        return amplifier;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}