package com.github.warrentode.todecoins.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Enemy;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GlowingAuraEffect extends MobEffect {
    public GlowingAuraEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
    }

    @Override
    public final void applyEffectTick(@NotNull LivingEntity auraSource, int amplifier) {
        if (!auraSource.level.isClientSide) {
            // Scale duration by (amplifier + 1)
            int baseDuration = 600;
            int targetDuration = baseDuration * (amplifier + 1);

            MobEffectInstance effectInstance = new MobEffectInstance(this, targetDuration, amplifier);
            addEffectToMobsAround(auraSource.createCommandSourceStack().getLevel(), auraSource, effectInstance);
        }
    }

    public static void addEffectToMobsAround(@NotNull ServerLevel serverLevel, @NotNull LivingEntity auraSource, @NotNull MobEffectInstance effectInstance) {
        int amplifier = effectInstance.getAmplifier();
        double baseRadius = 16.0;
        double maxRadius = 64.0;

        double radius = Math.min(baseRadius * (amplifier + 1), maxRadius);

        List<Mob> hostileMobs = serverLevel.getEntitiesOfClass(Mob.class,
                auraSource.getBoundingBox().inflate(radius),
                mob -> mob instanceof Enemy && mob.isAlive());

        for (Mob mob : hostileMobs) {
            mob.addEffect(new MobEffectInstance(MobEffects.GLOWING, effectInstance.getDuration(), amplifier));
        }
    }
}