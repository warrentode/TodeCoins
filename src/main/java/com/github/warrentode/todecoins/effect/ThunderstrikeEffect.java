package com.github.warrentode.todecoins.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class ThunderstrikeEffect extends MobEffect {
    protected ThunderstrikeEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.BENEFICIAL, 0xB0C4DE);

        // summons a thunderbolt upon the attacked target in the living attack event in the ModEvents class
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