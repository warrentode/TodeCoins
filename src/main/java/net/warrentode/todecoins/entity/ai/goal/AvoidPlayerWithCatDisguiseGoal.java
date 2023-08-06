package net.warrentode.todecoins.entity.ai.goal;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.warrentode.todecoins.integration.Curios;
import net.warrentode.todecoins.integration.ModListHandler;
import net.warrentode.todecoins.util.tags.ModTags;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;

public class AvoidPlayerWithCatDisguiseGoal<T extends LivingEntity> extends Goal {
    protected final PathfinderMob mob;
    protected final float maxDist;
    protected final PathNavigation pathNav;
    /**
     * Class of entity this behavior seeks to avoid
     */
    protected final Class<T> avoidClass;
    protected final Predicate<LivingEntity> avoidPredicate;
    protected final Predicate<LivingEntity> predicateOnAvoidEntity;
    private final double walkSpeedModifier;
    private final double sprintSpeedModifier;
    private final TargetingConditions avoidEntityTargeting;
    @Nullable
    protected T toAvoid;
    @Nullable
    protected Path path;

    /**
     * Goal that helps mobs avoid mobs of a specific class
     */
    public AvoidPlayerWithCatDisguiseGoal(PathfinderMob pMob, Class<T> avoidClass, float pMaxDistance, double pWalkSpeedModifier, double pSprintSpeedModifier) {
        this(pMob, avoidClass, (entity) -> true, pMaxDistance, pWalkSpeedModifier, pSprintSpeedModifier, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test);
    }

    /**
     * Goal that helps mobs avoid mobs of a specific class
     */
    public AvoidPlayerWithCatDisguiseGoal(PathfinderMob pMob, Class<T> avoidClass, Predicate<LivingEntity> pAvoidPredicate, float pMaxDistance, double pWalkSpeedModifier, double pSprintSpeedModifier, Predicate<LivingEntity> pPredicateOnAvoidEntity) {
        this.mob = pMob;
        this.avoidClass = avoidClass;
        this.avoidPredicate = pAvoidPredicate;
        this.maxDist = pMaxDistance;
        this.walkSpeedModifier = pWalkSpeedModifier;
        this.sprintSpeedModifier = pSprintSpeedModifier;
        this.predicateOnAvoidEntity = pPredicateOnAvoidEntity;
        this.pathNav = pMob.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE));
        this.avoidEntityTargeting = TargetingConditions.forCombat().range(pMaxDistance).selector(pPredicateOnAvoidEntity.and(pAvoidPredicate));
    }

    /**
     * Goal that helps mobs avoid mobs of a specific class
     */
    public AvoidPlayerWithCatDisguiseGoal(PathfinderMob pMob, Class<T> avoidClass, float pMaxDistance, double pWalkSpeedModifier, double pSprintSpeedModifier, Predicate<LivingEntity> pPredicateOnAvoidEntity) {
        this(pMob, avoidClass, (entity) -> true, pMaxDistance, pWalkSpeedModifier, pSprintSpeedModifier, pPredicateOnAvoidEntity);
    }

    private static boolean isWearingCatCoin(Player player) {
        ItemStack stack = Curios.getCharmSlot(player);

        return ModListHandler.curiosLoaded && (stack != null && stack.is(ModTags.Items.CAT_COIN_SET)
                || stack != null && stack.is(ModTags.Items.OCELOT_COIN_SET));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        Player player = Minecraft.getInstance().player;
        this.toAvoid = this.mob.level.getNearestEntity(this.mob.level.getEntitiesOfClass(this.avoidClass, this.mob.getBoundingBox().inflate(this.maxDist, 3.0D, this.maxDist), (typeTest) -> true), this.avoidEntityTargeting, this.mob, this.mob.getX(), this.mob.getY(), this.mob.getZ());
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
            else if (!isWearingCatCoin(player)) {
                return false;
            }
            else {
                this.path = this.pathNav.createPath(vec3.x, vec3.y, vec3.z, 0);
                return this.path != null;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean canContinueToUse() {
        return !this.pathNav.isDone();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void start() {
        this.pathNav.moveTo(this.path, this.walkSpeedModifier);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void stop() {
        this.toAvoid = null;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        if (this.toAvoid != null && this.mob.distanceToSqr(this.toAvoid) < 49.0D) {
            this.mob.getNavigation().setSpeedModifier(this.sprintSpeedModifier);
        }

    }
}