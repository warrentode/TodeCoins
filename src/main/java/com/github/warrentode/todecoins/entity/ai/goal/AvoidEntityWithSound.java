package com.github.warrentode.todecoins.entity.ai.goal;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;

public class AvoidEntityWithSound<T extends LivingEntity> extends Goal {
    protected final PathfinderMob mob;
    protected final float maxDist;
    protected final PathNavigation pathNav;
    protected final Class<T> avoidedClass;
    protected final Predicate<LivingEntity> avoidedPredicate;
    protected final Predicate<LivingEntity> predicateOnAvoidEntity;
    private final double walkSpeedModifier;
    private final double sprintSpeedModifier;
    private final SoundEvent fleeSound;
    private final RandomSource random = RandomSource.create();
    private final TargetingConditions avoidEntityTargeting;
    @Nullable
    private final MobEffect requiredEffect;
    @Nullable
    protected T toAvoid;
    @Nullable
    protected Path path;

    /**
     * Constructor for hasEffect-based or class-based avoidance
     */
    public AvoidEntityWithSound(PathfinderMob mob, Class<T> avoidedClass, float maxDistance, double walkSpeedModifier, double sprintSpeedModifier, @Nullable SoundEvent fleeSound, @Nullable MobEffect requiredEffect, Predicate<LivingEntity> avoidedPredicate, Predicate<LivingEntity> predicateOnAvoidEntity) {
        this.mob = mob;
        this.maxDist = maxDistance;
        this.walkSpeedModifier = walkSpeedModifier;
        this.sprintSpeedModifier = sprintSpeedModifier;
        this.fleeSound = fleeSound;
        this.avoidedClass = avoidedClass;
        this.avoidedPredicate = avoidedPredicate;
        this.predicateOnAvoidEntity = predicateOnAvoidEntity;
        this.pathNav = mob.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE));
        this.avoidEntityTargeting = TargetingConditions.forCombat().range(maxDistance).selector(this.avoidedPredicate.and(this.predicateOnAvoidEntity));
        this.requiredEffect = requiredEffect;
    }

    @Override
    public final boolean canUse() {
        // Find the nearest entity matching class and (optionally) hasEffect
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

        if (this.toAvoid == null) return false;

        Vec3 fleePos = DefaultRandomPos.getPosAway(this.mob, 16, 7, this.toAvoid.position());
        if (fleePos == null) return false;
        if (this.toAvoid.distanceToSqr(fleePos.x, fleePos.y, fleePos.z) < this.toAvoid.distanceToSqr(this.mob))
            return false;

        this.path = this.pathNav.createPath(fleePos.x, fleePos.y, fleePos.z, 0);
        return this.path != null;
    }

    @Override
    public final boolean canContinueToUse() {
        return !this.pathNav.isDone();
    }

    @Override
    public final void start() {
        this.pathNav.moveTo(this.path, this.walkSpeedModifier);
    }

    @Override
    public final void stop() {
        this.toAvoid = null;
    }

    @Override
    public final void tick() {
        if (this.toAvoid != null) {
            double distanceSqr = this.mob.distanceToSqr(this.toAvoid);
            if (distanceSqr < (this.maxDist / 4)) {
                this.pathNav.setSpeedModifier(this.sprintSpeedModifier);
            }
            else {
                this.pathNav.setSpeedModifier(this.walkSpeedModifier);
            }

            this.mob.playSound(fleeSound, 0.15F, random.nextFloat());
        }
    }
}