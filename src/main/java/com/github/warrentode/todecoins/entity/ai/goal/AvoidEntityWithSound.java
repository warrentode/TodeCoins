package com.github.warrentode.todecoins.entity.ai.goal;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

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
    private final SoundEvent soundEvent;
    private final TargetingConditions avoidEntityTargeting;
    @Nullable
    protected T toAvoid;
    @Nullable
    protected Path path;

    public AvoidEntityWithSound(PathfinderMob mob, Class<T> avoidedClass, float maxDistance, double walkSpeedModifier, double sprintSpeedModifier, SoundEvent soundEvent) {
        this(mob, soundEvent, avoidedClass, (newGoal) -> true,
                maxDistance, walkSpeedModifier, sprintSpeedModifier, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test);
    }

    public AvoidEntityWithSound(@NotNull PathfinderMob mob, SoundEvent soundEvent, Class<T> avoidedClass, Predicate<LivingEntity> avoidedPredicate, float maxDistance, double walkSpeedModifier, double sprintSpeedModifier, @NotNull Predicate<LivingEntity> predicateOnAvoidEntity) {
        this.mob = mob;
        this.soundEvent = soundEvent;
        this.avoidedClass = avoidedClass;
        this.avoidedPredicate = avoidedPredicate;
        this.maxDist = maxDistance;
        this.walkSpeedModifier = walkSpeedModifier;
        this.sprintSpeedModifier = sprintSpeedModifier;
        this.predicateOnAvoidEntity = predicateOnAvoidEntity;
        this.pathNav = mob.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE));
        this.avoidEntityTargeting = TargetingConditions.forCombat().range(maxDistance).selector(predicateOnAvoidEntity.and(avoidedPredicate));
    }

    public AvoidEntityWithSound(PathfinderMob mob, Class<T> avoidedClass, float maxDistance, double walkSpeedModifier, double sprintSpeedModifier, Predicate<LivingEntity> avoidedPredicate, SoundEvent soundEvent) {
        this(mob, soundEvent, avoidedClass, (newGoal) -> true, maxDistance, walkSpeedModifier, sprintSpeedModifier, avoidedPredicate);
    }

    public boolean canUse() {
        this.toAvoid = this.mob.level.getNearestEntity(this.mob.level.getEntitiesOfClass(this.avoidedClass,
                this.mob.getBoundingBox().inflate(this.maxDist, 3.0D, this.maxDist), (canUse) -> true),
                this.avoidEntityTargeting, this.mob, this.mob.getX(), this.mob.getY(), this.mob.getZ());
        if (this.toAvoid == null) {
            return false;
        }
        else {
            Vec3 vec3 = DefaultRandomPos.getPosAway(this.mob, 16, 7, this.toAvoid.position());
            if (vec3 == null) {
                return false;
            }
            else if (this.toAvoid.distanceToSqr(vec3.x, vec3.y, vec3.z) < this.toAvoid.distanceToSqr(this.mob)) {
                return false;
            }
            else {
                this.path = this.pathNav.createPath(vec3.x, vec3.y, vec3.z, 0);
                return this.path != null;
            }
        }
    }

    public boolean canContinueToUse() {
        return !this.pathNav.isDone();
    }

    public void start() {
        this.pathNav.moveTo(this.path, this.walkSpeedModifier);
    }

    public void stop() {
        this.toAvoid = null;
    }

    public void tick() {
        if (this.toAvoid != null) {
            if (this.mob.distanceToSqr(this.toAvoid) < (this.maxDist / 4)) {
                this.mob.getNavigation().setSpeedModifier(this.sprintSpeedModifier);
            }
            else {
                this.mob.getNavigation().setSpeedModifier(this.walkSpeedModifier);
            }

            if (RandomSource.create().nextFloat() < 0.0125) {
                this.mob.playSound(soundEvent, 0.15F, RandomSource.create().nextFloat());
            }
        }
    }
}