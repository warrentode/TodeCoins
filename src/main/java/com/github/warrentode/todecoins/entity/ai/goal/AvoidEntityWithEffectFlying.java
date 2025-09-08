package com.github.warrentode.todecoins.entity.ai.goal;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.function.Predicate;

import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

public class AvoidEntityWithEffectFlying<T extends LivingEntity, M extends FlyingMob> extends Goal {
    protected final M mob;
    protected final Class<T> avoidedClass;
    protected final Predicate<LivingEntity> avoidedPredicate;
    protected final Predicate<LivingEntity> predicateOnAvoidEntity;
    protected final float maxDist;
    private final double flySpeed;
    private final MobEffect requiredEffect;
    private final SoundEvent fleeSound;
    @Nullable
    protected LivingEntity toAvoid;
    protected Vec3 fleeTarget;
    protected final TargetingConditions avoidEntityTargeting;
    private final RandomSource random = RandomSource.create();
    private int logCooldown = 0; // only log every N ticks to avoid spamming

    public AvoidEntityWithEffectFlying(M mob, Class<T> avoidedClass, float maxDistance, double flySpeed, @Nullable MobEffect requiredEffect, @Nullable SoundEvent fleeSound, Predicate<LivingEntity> avoidedPredicate, Predicate<LivingEntity> predicateOnAvoidEntity) {
        this.mob = mob;
        this.avoidedClass = avoidedClass;
        this.avoidedPredicate = avoidedPredicate;
        this.predicateOnAvoidEntity = predicateOnAvoidEntity;
        this.maxDist = maxDistance;
        this.flySpeed = flySpeed;
        this.requiredEffect = requiredEffect;
        this.fleeSound = fleeSound;

        // TargetingConditions used for getNearestEntity
        this.avoidEntityTargeting = TargetingConditions.forCombat().range(maxDistance).selector(e -> requiredEffect == null || e.hasEffect(requiredEffect));

        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public final boolean canUse() {
        TC_LOGGER.info("[{}] Checking for nearby entities to flee from...", mob.getName().getString());

        this.toAvoid = this.mob.level.getNearestEntity(
                this.mob.level.getEntitiesOfClass(this.avoidedClass,
                        this.mob.getBoundingBox().inflate(this.maxDist, 3.0D, this.maxDist),
                        entity -> {
                            if (!this.avoidedPredicate.test(entity)) return false;
                            if (!this.predicateOnAvoidEntity.test(entity)) return false;
                            if (requiredEffect != null) return entity.hasEffect(requiredEffect);
                            return true;
                        }),
                this.avoidEntityTargeting, this.mob, this.mob.getX(), this.mob.getY(), this.mob.getZ()
        );

        if (this.toAvoid == null) {
            TC_LOGGER.info("[{}] No valid entities found within range.", mob.getName().getString());
            return false;
        }

        // Calculate flee vector
        Vec3 away = mob.position().subtract(this.toAvoid.position()).normalize().scale(maxDist);
        this.fleeTarget = mob.position().add(away);
        TC_LOGGER.info("[{}] Flee target calculated at: {}", mob.getName().getString(), this.fleeTarget);
        return true;
    }

    @Override
    public final boolean canContinueToUse() {
        double distanceSqr = mob.distanceToSqr(fleeTarget);
        boolean continueFlying = distanceSqr > 1.0;
        if (!continueFlying) {
            TC_LOGGER.info("[{}] Reached flee target, stopping fleeing.", mob.getName().getString());
        }
        return continueFlying;
    }

    @Override
    public final void start() {
        TC_LOGGER.info("[{}] Starting flee movement.", mob.getName().getString());
        moveToTarget();
    }

    @Override
    public final void stop() {
        TC_LOGGER.info("[{}] Stopping flee goal.", mob.getName().getString());
        this.toAvoid = null;
    }

    @Override
    public final void tick() {
        if (this.toAvoid != null) {
            moveToTarget();

            this.mob.playSound(fleeSound, 0.15F, random.nextFloat());
        }
    }

    private void moveToTarget() {
        if (fleeTarget == null) return;

        // Compute normalized direction vector
        Vec3 direction = fleeTarget.subtract(mob.position()).normalize();

        // Scale by flySpeed and mob's movement speed
        double effectiveSpeed = flySpeed * mob.getSpeed();
        mob.setDeltaMovement(direction.scale(effectiveSpeed));

        // Update look direction
        mob.getLookControl().setLookAt(fleeTarget.x, fleeTarget.y, fleeTarget.z, 30.0F, 30.0F);

        // Log periodically for debugging, every 20 ticks (~1 second)
        if (logCooldown <= 0) {
            TC_LOGGER.info("[{}] Moving towards flee target: {}, current position: {}, speed: {}",
                    mob.getName().getString(), fleeTarget, mob.position(), effectiveSpeed);
            logCooldown = 20;
        }
        else {
            logCooldown--;
        }
    }
}