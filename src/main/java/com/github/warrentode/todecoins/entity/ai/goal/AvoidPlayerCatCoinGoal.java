package com.github.warrentode.todecoins.entity.ai.goal;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Predicate;

public class AvoidPlayerCatCoinGoal<T extends LivingEntity> extends Goal {
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
    public AvoidPlayerCatCoinGoal(PathfinderMob pMob, Class<T> avoidClass, float pMaxDistance, double pWalkSpeedModifier, double pSprintSpeedModifier) {
        this(pMob, avoidClass, (entity) -> true, pMaxDistance, pWalkSpeedModifier, pSprintSpeedModifier, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test);
    }

    /**
     * Goal that helps mobs avoid mobs of a specific class
     */
    public AvoidPlayerCatCoinGoal(PathfinderMob pMob, Class<T> avoidClass, Predicate<LivingEntity> pAvoidPredicate, float pMaxDistance, double pWalkSpeedModifier, double pSprintSpeedModifier, Predicate<LivingEntity> pPredicateOnAvoidEntity) {
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
    public AvoidPlayerCatCoinGoal(PathfinderMob pMob, Class<T> avoidClass, float pMaxDistance, double pWalkSpeedModifier, double pSprintSpeedModifier, Predicate<LivingEntity> pPredicateOnAvoidEntity) {
        this(pMob, avoidClass, (entity) -> true, pMaxDistance, pWalkSpeedModifier, pSprintSpeedModifier, pPredicateOnAvoidEntity);
    }

    private static boolean isWearingCatCoin(ServerPlayer player) {
        if (player != null) {
            ItemStack catCharm = null;

            Optional<SlotResult> catCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_CAT_COIN.get());
            Optional<SlotResult> catCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_CAT_COIN.get());
            Optional<SlotResult> catCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_CAT_COIN.get());
            Optional<SlotResult> catCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_CAT_COIN.get());

            Optional<SlotResult> ocelotCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_OCELOT_COIN.get());
            Optional<SlotResult> ocelotCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_OCELOT_COIN.get());
            Optional<SlotResult> ocelotCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_OCELOT_COIN.get());
            Optional<SlotResult> ocelotCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_OCELOT_COIN.get());

            if (catCoin1.isPresent()) {
                catCharm = catCoin1.get().stack();
            }
            else if (catCoin2.isPresent()) {
                catCharm = catCoin2.get().stack();
            }
            else if (catCoin3.isPresent()) {
                catCharm = catCoin3.get().stack();
            }
            else if (catCoin4.isPresent()) {
                catCharm = catCoin4.get().stack();
            }
            else if (ocelotCoin1.isPresent()) {
                catCharm = ocelotCoin1.get().stack();
            }
            else if (ocelotCoin2.isPresent()) {
                catCharm = ocelotCoin2.get().stack();
            }
            else if (ocelotCoin3.isPresent()) {
                catCharm = ocelotCoin3.get().stack();
            }
            else if (ocelotCoin4.isPresent()) {
                catCharm = ocelotCoin4.get().stack();
            }

            return ModList.get().isLoaded("curios") && (catCharm != null && catCharm.is(ModTags.Items.CAT_COIN_SET)
                    || catCharm != null && catCharm.is(ModTags.Items.OCELOT_COIN_SET));
        }
        return false;
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        MinecraftServer server = this.mob != null ? this.mob.getServer() : null;
        ServerLevel serverLevel = server != null ? server.getLevel(this.mob.level.dimension()) : null;
        ServerPlayer player = server != null ? server.createCommandSourceStack().getPlayer() : null;

        this.toAvoid = this.mob != null ? this.mob.level.getNearestEntity(this.mob.level.getEntitiesOfClass(this.avoidClass, this.mob.getBoundingBox().inflate(this.maxDist, 3.0D, this.maxDist), (typeTest) -> true), this.avoidEntityTargeting, this.mob, this.mob.getX(), this.mob.getY(), this.mob.getZ()) : null;
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