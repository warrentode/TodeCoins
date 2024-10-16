package com.github.warrentode.todecoins.entity.ai.goal;

import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Path;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public class PiglinMerchantMeleeAttackWithSound extends MeleeAttackGoal {
    private static final long COOLDOWN_BETWEEN_CAN_USE_CHECKS = 20L;
    protected final PathfinderMob merchant;
    private final double speedModifier;
    private final boolean followingTargetEvenIfNotSeen;
    private final int attackInterval;
    private Path path;
    private double pathTargetX;
    private double pathTargetY;
    private double pathTargetZ;
    private int ticksUntilNextPathRecalculation;
    private int ticksUntilNextAttack;
    private long lastCanUseCheck;
    private int failedPathFindingPenalty = 0;
    private final boolean canPenalize = false;
    private final SoundEvent soundEvent;

    public PiglinMerchantMeleeAttackWithSound(PathfinderMob mob, double speedModifier, boolean followingTargetEvenIfNotSeen, int attackInterval, SoundEvent soundEvent) {
        super(mob, speedModifier, followingTargetEvenIfNotSeen);
        this.merchant = mob;
        this.speedModifier = speedModifier;
        this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
        this.attackInterval = attackInterval;
        this.soundEvent = soundEvent;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    public boolean canUse() {
        long i = this.merchant.level.getGameTime();
        if (i - this.lastCanUseCheck < COOLDOWN_BETWEEN_CAN_USE_CHECKS) {
            return false;
        }
        else {
            this.lastCanUseCheck = i;
            LivingEntity livingentity = this.merchant.getTarget();
            if (livingentity == null) {
                return false;
            }
            else if (!livingentity.isAlive()) {
                return false;
            }
            else {
                if (canPenalize) {
                    if (--this.ticksUntilNextPathRecalculation <= 0) {
                        this.path = this.merchant.getNavigation().createPath(livingentity, 0);
                        this.ticksUntilNextPathRecalculation = 4 + this.merchant.getRandom().nextInt(7);
                        return this.path != null;
                    }
                    else {
                        return true;
                    }
                }
                this.path = this.merchant.getNavigation().createPath(livingentity, 0);
                if (this.path != null) {
                    return true;
                }
                else {
                    this.merchant.playSound(soundEvent, 0.15F, RandomSource.create().nextFloat());
                    return this.getAttackReachSqr(livingentity) >= this.merchant.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                }
            }
        }
    }

    public boolean canContinueToUse() {
        LivingEntity livingentity = this.merchant.getTarget();
        if (livingentity == null) {
            return false;
        }
        else if (!livingentity.isAlive()) {
            return false;
        }
        else if (!this.followingTargetEvenIfNotSeen) {
            return !this.merchant.getNavigation().isDone();
        }
        else if (!this.merchant.isWithinRestriction(livingentity.blockPosition())) {
            return false;
        }
        else {
            return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player) livingentity).isCreative();
        }
    }

    public void start() {
        this.merchant.getNavigation().moveTo(this.path, this.speedModifier);
        this.merchant.setAggressive(true);
        this.ticksUntilNextPathRecalculation = 0;
        this.ticksUntilNextAttack = 0;
    }

    public void stop() {
        LivingEntity livingentity = this.merchant.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.merchant.setTarget(null);
        }

        this.merchant.setAggressive(false);
        this.merchant.getNavigation().stop();
    }

    @SuppressWarnings("RedundantMethodOverride")
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity target = this.merchant.getTarget();
        if (target != null) {
            this.merchant.getLookControl().setLookAt(target, 30.0F, 30.0F);
            double d0 = this.merchant.distanceToSqr(target.getX(), target.getY(), target.getZ());
            this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
            if ((this.followingTargetEvenIfNotSeen || this.merchant.getSensing().hasLineOfSight(target)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathTargetX == 0.0D && this.pathTargetY == 0.0D && this.pathTargetZ == 0.0D || target.distanceToSqr(this.pathTargetX, this.pathTargetY, this.pathTargetZ) >= 1.0D || this.merchant.getRandom().nextFloat() < 0.05F)) {
                this.pathTargetX = target.getX();
                this.pathTargetY = target.getY();
                this.pathTargetZ = target.getZ();
                this.ticksUntilNextPathRecalculation = 4 + this.merchant.getRandom().nextInt(7);
                if (this.canPenalize) {
                    this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
                    if (this.merchant.getNavigation().getPath() != null) {
                        net.minecraft.world.level.pathfinder.Node finalPathPoint = this.merchant.getNavigation().getPath().getEndNode();
                        if (finalPathPoint != null && target.distanceToSqr(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1) {
                            failedPathFindingPenalty = 0;
                        }
                        else {
                            failedPathFindingPenalty += 10;
                        }
                    }
                    else {
                        failedPathFindingPenalty += 10;
                    }
                }
                if (d0 > 1024.0D) {
                    this.ticksUntilNextPathRecalculation += 10;
                }
                else if (d0 > 256.0D) {
                    this.ticksUntilNextPathRecalculation += 5;
                }

                if (!this.merchant.getNavigation().moveTo(target, this.speedModifier)) {
                    this.ticksUntilNextPathRecalculation += 15;
                }

                this.ticksUntilNextPathRecalculation = this.adjustedTickDelay(this.ticksUntilNextPathRecalculation);
            }

            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndPerformAttack(target, d0);
        }
    }

    protected void checkAndPerformAttack(@NotNull LivingEntity target, double distToTargetSqr) {
        double d0 = this.getAttackReachSqr(target);
        if (distToTargetSqr <= d0 && this.ticksUntilNextAttack <= 0) {
            this.resetAttackCooldown();
            PiglinMerchant.setUpAttack((PiglinMerchant) this.merchant,true);
            this.merchant.swing(InteractionHand.MAIN_HAND);
            this.merchant.doHurtTarget(target);
        }
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackInterval);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }

    protected int getAttackInterval() {
        return this.adjustedTickDelay(attackInterval);
    }

    protected double getAttackReachSqr(@NotNull LivingEntity target) {
        return this.merchant.getBbWidth() * 2.0F * this.merchant.getBbWidth() * 2.0F + target.getBbWidth();
    }
}