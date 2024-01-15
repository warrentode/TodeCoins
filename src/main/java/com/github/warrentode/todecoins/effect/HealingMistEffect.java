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
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class HealingMistEffect extends MobEffect {
    static int amplifier;

    protected HealingMistEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.BENEFICIAL, 0xFF69B4);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            ServerLevel serverLevel = serverPlayer.getLevel();
            addEffectToPlayersAround(serverLevel, serverPlayer, serverPlayer.position(), serverLevel.getMaxEntityRadius(),
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

    public static void addEffectToPlayersAround(@NotNull ServerLevel serverLevel, @Nullable Entity mistSource, Vec3 vec3, double radius, @NotNull MobEffectInstance effect, int duration) {
        MobEffect mobEffect = effect.getEffect();
        if (mistSource instanceof ServerPlayer serverPlayer) {
            List<ServerPlayer> players = serverLevel.getEntitiesOfClass(ServerPlayer.class,
                    serverPlayer.getBoundingBox().inflate(4.0 * amplifier), EntitySelector.ENTITY_STILL_ALIVE);

            for (ServerPlayer next : players) {
                next.addEffect(new MobEffectInstance(MobEffects.REGENERATION, duration, amplifier));
            }
        }
    }
}