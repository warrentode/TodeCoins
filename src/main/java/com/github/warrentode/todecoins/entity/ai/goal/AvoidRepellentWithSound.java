package com.github.warrentode.todecoins.entity.ai.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class AvoidRepellentWithSound<T extends Blocks> extends Goal {
    protected final PathfinderMob mob;
    protected final int maxDist;
    protected final PathNavigation pathNav;
    protected final TagKey<Block> avoidedPredicate;
    private final double walkSpeedModifier;
    private final double sprintSpeedModifier;
    private final SoundEvent soundEvent;
    @Nullable
    protected BlockPos toAvoid;
    @Nullable
    protected Path path;

    public AvoidRepellentWithSound(@NotNull PathfinderMob mob, TagKey<Block> avoidedPredicate, int maxDistance, double walkSpeedModifier, double sprintSpeedModifier, SoundEvent soundEvent) {
        this.mob = mob;
        this.soundEvent = soundEvent;
        this.avoidedPredicate = avoidedPredicate;
        this.maxDist = maxDistance;
        this.walkSpeedModifier = walkSpeedModifier;
        this.sprintSpeedModifier = sprintSpeedModifier;
        this.pathNav = mob.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    public boolean canUse() {
        this.toAvoid = BlockPos.findClosestMatch(this.mob.blockPosition(), this.maxDist, (this.maxDist / 4), pos -> {
            BlockState state = this.mob.level.getBlockState(pos);
            return state.is(BlockTags.PIGLIN_REPELLENTS);
        }).orElse(null);


        if (this.toAvoid == null) {
            return false;
        }
        else {
            Vec3 vec3 = LandRandomPos.getPosAway(this.mob, (this.maxDist * 2), this.maxDist, Vec3.atCenterOf(this.toAvoid));
            if (vec3 == null) {
                return false;
            }
            else if (this.toAvoid.distToCenterSqr(vec3.x, vec3.y, vec3.z) < this.toAvoid.distToCenterSqr(this.mob.position())) {
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
            if (this.mob.distanceToSqr(Vec3.atCenterOf(this.toAvoid)) < this.maxDist) {
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