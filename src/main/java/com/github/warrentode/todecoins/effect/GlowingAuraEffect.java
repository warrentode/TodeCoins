package com.github.warrentode.todecoins.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class GlowingAuraEffect extends MobEffect {
    static int amplifier;

    protected GlowingAuraEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.NEUTRAL, 0xFAFAD2);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            ServerLevel serverLevel = serverPlayer.getLevel();
            addEffectToMobsAround(serverLevel, serverPlayer, serverPlayer.position(), serverLevel.getMaxEntityRadius(),
                    new MobEffectInstance(this), 600);
        }
    }

    public static int getAmplifier() {
        return amplifier;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    public static void addEffectToMobsAround(ServerLevel serverLevel, @Nullable Entity auraSource, Vec3 vec3, double radius, @NotNull MobEffectInstance effect, int duration) {
        MobEffect mobEffect = effect.getEffect();
        if (auraSource instanceof ServerPlayer serverPlayer) {
            List<Monster> monsters = serverLevel.getEntitiesOfClass(Monster.class,
                    serverPlayer.getBoundingBox().inflate(16.0 * amplifier), EntitySelector.ENTITY_STILL_ALIVE);

            for (Monster next : monsters) {
                next.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600));
            }
        }
    }
}