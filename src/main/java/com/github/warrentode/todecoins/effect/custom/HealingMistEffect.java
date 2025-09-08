package com.github.warrentode.todecoins.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HealingMistEffect extends MobEffect {
    public HealingMistEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
    }

    @Override
    public final void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            ServerLevel serverLevel = (ServerLevel) serverPlayer.level();

            int baseDuration = 600;
            int scaledDuration = baseDuration * (amplifier + 1);

            MobEffectInstance effectInstance = new MobEffectInstance(this, scaledDuration, amplifier);
            addEffectToPlayersAndPetsAround(serverLevel, serverPlayer, effectInstance);
        }
    }

    public static void addEffectToPlayersAndPetsAround(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer player, @NotNull MobEffectInstance effectInstance) {
        int amplifier = effectInstance.getAmplifier();
        double baseRadius = 4.0;
        double maxRadius = 32.0;

        double radius = Math.min(baseRadius * (amplifier + 1), maxRadius);

        // Get nearby players
        List<ServerPlayer> nearbyPlayers = serverLevel.getEntitiesOfClass(ServerPlayer.class,
                player.getBoundingBox().inflate(radius), EntitySelector.ENTITY_STILL_ALIVE);

        for (ServerPlayer nearbyPlayer : nearbyPlayers) {
            nearbyPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, effectInstance.getDuration(), amplifier));

            // Heal their tameable pets
            List<LivingEntity> pets = serverLevel.getEntitiesOfClass(LivingEntity.class,
                    player.getBoundingBox().inflate(radius),
                    entity -> entity.isAlive()
                            && entity instanceof OwnableEntity ownable
                            && ownable.getOwnerUUID() != null
                            && ownable.getOwnerUUID().equals(player.getUUID()));

            for (LivingEntity pet : pets) {
                pet.addEffect(new MobEffectInstance(MobEffects.REGENERATION, effectInstance.getDuration(), amplifier));
            }
        }
    }
}