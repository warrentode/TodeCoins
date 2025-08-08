package com.github.warrentode.todecoins.entity.piglinmerchant;

import com.github.warrentode.todecoins.entity.ai.goal.*;
import com.github.warrentode.todecoins.entity.trades.PiglinMerchantTrades;
import com.github.warrentode.todecoins.sounds.ModSounds;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class PiglinMerchant extends PathfinderMob implements Merchant, InventoryCarrier {
    public static final float MAX_DISTANCE = 16.0F;
    public static final int DANCE_DURATION = 150;
    private static final float CHANCE_OF_WEARING_EACH_ARMOUR_ITEM = 0.1F;
    private static final int MAX_HEALTH = 50;
    private static final double SPEED_WALK = 0.4D;
    private static final float SPEED_SPRINT = 0.8F;
    private static final double KNOCKBACK_RESISTANCE = 1.0D;
    private static final double ATTACK_DAMAGE = 7.0D;
    private static final float LOOK_TIME = 3.0F;
    private static final int MELEE_COOLDOWN = 20;
    private static final int maxOFFERS = 10;
    private static final EntityDataAccessor<Boolean> DEFAULT = SynchedEntityData.defineId(PiglinMerchant.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> WALKING = SynchedEntityData.defineId(PiglinMerchant.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IDLE = SynchedEntityData.defineId(PiglinMerchant.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> MIGHT_DANCE = SynchedEntityData.defineId(PiglinMerchant.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DANCE_TIMER = SynchedEntityData.defineId(PiglinMerchant.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DANCING = SynchedEntityData.defineId(PiglinMerchant.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(PiglinMerchant.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DYING = SynchedEntityData.defineId(PiglinMerchant.class, EntityDataSerializers.BOOLEAN);
    public final SimpleContainer inventory = new SimpleContainer(8);
    public final AnimationState defaultAnimationState = new AnimationState();
    public final AnimationState walkLegsOnlyAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState danceAnimationState = new AnimationState();
    public final AnimationState meleeLeftAnimationState = new AnimationState();
    public final AnimationState meleeRightAnimationState = new AnimationState();
    public final AnimationState deathAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;
    public int attackAnimationTimeout = 0;
    @Nullable
    private Player tradingPlayer;
    @Nullable
    private MerchantOffers offers;
    @Nullable
    private BlockPos wanderTarget;
    private int despawnDelay;

    public PiglinMerchant(EntityType<? extends PiglinMerchant> entityType, Level level) {
        super(entityType, level);
        this.setCanPickUpLoot(true);
        this.applyOpenDoorsAbility();
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_CACTUS, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_CACTUS, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.BLOCKED, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.BLOCKED, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.LEAVES, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.LEAVES, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.BREACH, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.BREACH, -1.0F);
        this.xpReward = 10;
    }

    public static @NotNull AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                       .add(Attributes.MAX_HEALTH, MAX_HEALTH)
                       .add(Attributes.MOVEMENT_SPEED, SPEED_WALK)
                       .add(Attributes.KNOCKBACK_RESISTANCE, KNOCKBACK_RESISTANCE)
                       .add(Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE)
                       .build();
    }

    public static boolean isFood(@NotNull ItemStack stack) {
        return stack.is(TodeCoinsTags.Items.PIGLIN_MERCHANT_FOOD);
    }
    private static @NotNull ItemStack removeOneItemFromItemEntity(@NotNull ItemEntity item) {
        ItemStack stack = item.getItem();
        ItemStack stack1 = stack.split(1);
        if (stack.isEmpty()) {
            item.discard();
        }
        else {
            item.setItem(stack);
        }

        return stack1;
    }

    public static void holdInOffhand(@NotNull PiglinMerchant merchant, @NotNull ItemStack stack) {
        merchant.setItemInHand(InteractionHand.OFF_HAND, stack);
        merchant.setItemSlot(EquipmentSlot.OFFHAND, stack);
        merchant.setGuaranteedDrop(EquipmentSlot.OFFHAND);
    }

    @SuppressWarnings("unused")
    public static void setCelebrate(@NotNull PiglinMerchant merchant, boolean dancing) {
        merchant.setDancing(true);
    }

    @SuppressWarnings("unused")
    public static void setUpAttack(@NotNull PiglinMerchant merchant, boolean attacking) {
        merchant.setAttacking(true);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new CelebrateVictory<>(this));
        this.goalSelector.addGoal(1, new PiglinMerchantMeleeAttackWithSound(this, SPEED_SPRINT,
                false, MELEE_COOLDOWN, ModSounds.PIGLINMERCHANT_ANGER.get()));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Raider.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractSkeleton.class, true));
        this.targetSelector.addGoal(1, new PiglinMerchantDefendVillageTarget(this));

        this.goalSelector.addGoal(2, new AvoidEntityWithSound<>(this, Creeper.class, MAX_DISTANCE,
                SPEED_WALK, SPEED_SPRINT, ModSounds.PIGLINMERCHANT_RETREAT.get()));
        this.goalSelector.addGoal(2, new AvoidEntityWithSound<>(this, Zombie.class, MAX_DISTANCE,
                SPEED_WALK, SPEED_SPRINT, ModSounds.PIGLINMERCHANT_RETREAT.get()));
        this.goalSelector.addGoal(2, new AvoidEntityWithSound<>(this, ZombieVillager.class, MAX_DISTANCE,
                SPEED_WALK, SPEED_SPRINT, ModSounds.PIGLINMERCHANT_RETREAT.get()));
        this.goalSelector.addGoal(2, new AvoidEntityWithSound<>(this, ZombieHorse.class, MAX_DISTANCE,
                SPEED_WALK, SPEED_SPRINT, ModSounds.PIGLINMERCHANT_RETREAT.get()));
        this.goalSelector.addGoal(2, new AvoidEntityWithSound<>(this, ZombifiedPiglin.class, MAX_DISTANCE,
                SPEED_WALK, SPEED_SPRINT, ModSounds.PIGLINMERCHANT_RETREAT.get()));
        this.goalSelector.addGoal(2, new AvoidEntityWithSound<>(this, Zoglin.class, MAX_DISTANCE,
                SPEED_WALK, SPEED_SPRINT, ModSounds.PIGLINMERCHANT_RETREAT.get()));
        this.goalSelector.addGoal(2, new AvoidRepellentWithSound<>(this,
                BlockTags.PIGLIN_REPELLENTS, (int) MAX_DISTANCE,
                SPEED_WALK, SPEED_SPRINT, ModSounds.PIGLINMERCHANT_RETREAT.get()));

        this.goalSelector.addGoal(3, new PiglinMerchantTradeWithPlayer(this));
        this.goalSelector.addGoal(3, new PiglinMerchantLookAtTradingPlayer(this));

        this.goalSelector.addGoal(4, new MoveTowardsTargetGoal(this, SPEED_SPRINT, MAX_DISTANCE));
        this.goalSelector.addGoal(4, new WanderToPositionGoal(this));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, SPEED_WALK));

        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, SPEED_WALK));
        this.goalSelector.addGoal(9, new PiglinMerchantInteractWithSound(this, Player.class, MAX_DISTANCE, LOOK_TIME, ModSounds.PIGLINMERCHANT_JEALOUS.get()));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, MAX_DISTANCE));
        this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
    }

    private void applyOpenDoorsAbility() {
        if (GoalUtils.hasGroundPathNavigation(this)) {
            ((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(true);
        }
    }

    public @NotNull InteractionResult mobInteract(@NotNull Player player, @NotNull InteractionHand hand) {
        if (this.isAlive() && !this.isTrading() && !this.isDancing() && !this.isAttacking()) {
            if (!this.getOffers().isEmpty() && !this.level.isClientSide) {
                this.setTradingPlayer(player);
                this.openTradingScreen(player, this.getDisplayName(), 1);
            }
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }
        else {
            return super.mobInteract(player, hand);
        }
    }

    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor levelAccessor, @NotNull DifficultyInstance difficultyInstance,
            @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag nbt) {
        RandomSource randomsource = levelAccessor.getRandom();
        this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
        this.populateDefaultEquipmentSlots(randomsource, difficultyInstance);
        this.populateDefaultEquipmentEnchantments(randomsource, difficultyInstance);
        return super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, nbt);
    }

    public int getExperienceReward() {
        return this.xpReward;
    }

    protected void dropCustomDeathLoot(@NotNull DamageSource source, int looting, boolean lastHit) {
        super.dropCustomDeathLoot(source, looting, lastHit);
        this.inventory.removeAllItems()
                .forEach(this::spawnAtLocation);
    }

    private ItemStack createSpawnWeapon() {
        return new ItemStack(Items.GOLDEN_AXE);
    }

    protected void populateDefaultEquipmentSlots(@NotNull RandomSource randomSource, @NotNull DifficultyInstance difficultyInstance) {
        super.populateDefaultEquipmentSlots(randomSource, difficultyInstance);
        this.maybeWearArmor(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET), randomSource);
        this.maybeWearArmor(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE), randomSource);
        this.maybeWearArmor(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS), randomSource);
        this.maybeWearArmor(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS), randomSource);
    }

    private void maybeWearArmor(EquipmentSlot slot, ItemStack stack, @NotNull RandomSource randomSource) {
        if (randomSource.nextFloat() < CHANCE_OF_WEARING_EACH_ARMOUR_ITEM) {
            this.setItemSlot(slot, stack);
        }
    }

    // inventory
    @Override
    @VisibleForDebug
    public @NotNull SimpleContainer getInventory() {
        return this.inventory;
    }

    public @NotNull SlotAccess getSlot(int pSlot) {
        int i = pSlot - 300;
        return i >= 0 && i < this.inventory.getContainerSize() ? SlotAccess.forContainer(this.inventory, i) : super.getSlot(pSlot);
    }

    public boolean wantsToPickUp(@NotNull ItemStack stack) {
        return isFood(stack) && this.canHoldItem(stack) && (this.getHealth() < this.getMaxHealth())
                       && ForgeEventFactory.getMobGriefingEvent(this.level, this);
    }

    protected void pickUpItem(ItemEntity item) {
        if (isFood(item.getItem())) {
            pickUpItem(this, item);
        }
    }

    protected void pickUpItem(PiglinMerchant merchant, ItemEntity item) {
        stopWalking(merchant);
        ItemStack stack;

        merchant.take(item, 1);
        stack = removeOneItemFromItemEntity(item);

        if (isFood(stack) && (this.getHealth() < this.getMaxHealth())) {
            holdInOffhand(merchant, stack);

            int nutrition = Objects.requireNonNull(stack.getItem().getFoodProperties(stack, this)).getNutrition();
            int saturation = (int) Objects.requireNonNull(stack.getItem().getFoodProperties(stack, this)).getSaturationModifier();

            this.addEffect(new MobEffectInstance(MobEffects.HEAL));
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, saturation * 20, nutrition, true, false));
            eat(this.level, stack);
        }
    }

    // read and save data
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.put("Inventory", this.inventory.createTag());
        MerchantOffers offers = this.getOffers();
        if (!offers.isEmpty()) {
            nbt.put("Offers", offers.createTag());
        }
        nbt.putInt("DespawnDelay", this.despawnDelay);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.inventory.fromTag(nbt.getList("Inventory", 10));

        if (nbt.contains("Offers", 10)) {
            this.offers = new MerchantOffers(nbt.getCompound("Offers"));
        }
        if (nbt.contains("DespawnDelay", 99)) {
            this.despawnDelay = nbt.getInt("DespawnDelay");
        }
    }

    // synced data management
    private void stopWalking(PathfinderMob pathfinderMob) {
        pathfinderMob.getNavigation().stop();
        setWalking(false);
    }

    public void setDefault(boolean defaultPose) {
        this.entityData.set(DEFAULT, defaultPose);
    }

    public boolean isDefault() {
        return this.entityData.get(DEFAULT);
    }

    public void setWalking(boolean walking) {
        this.entityData.set(WALKING, walking);
    }

    public boolean isWalking() {
        return this.entityData.get(WALKING);
    }

    public void setDancing(boolean dancing) {
        this.entityData.set(DANCING, dancing);
    }

    public boolean isDancing() {
        return this.entityData.get(DANCING);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DEFAULT, false);
        this.entityData.define(WALKING, false);
        this.entityData.define(IDLE, false);
        this.entityData.define(DANCING, false);
        this.entityData.define(ATTACKING, false);
        this.entityData.define(DYING, false);
        this.entityData.define(MIGHT_DANCE, false);
        this.entityData.define(DANCE_TIMER, 0);
    }

    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> key) {
        super.onSyncedDataUpdated(key);
    }

    // trading details
    @Override
    public void setTradingPlayer(@Nullable Player player) {
        this.tradingPlayer = player;
    }

    @Nullable
    @Override
    public Player getTradingPlayer() {
        return this.tradingPlayer;
    }

    public boolean isTrading() {
        return this.tradingPlayer != null;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
            this.setTrades();
        }
        return this.offers;
    }

    @Override
    public void overrideOffers(@NotNull MerchantOffers offers) {}

    public void setTrades() {
        VillagerTrades.ItemListing[] trades$itemlisting = PiglinMerchantTrades.PIGLINMERCHANT_TRADES.get(1);
        VillagerTrades.ItemListing[] trades$itemlisting1 = PiglinMerchantTrades.PIGLINMERCHANT_TRADES.get(2);
        if (trades$itemlisting != null && trades$itemlisting1 != null) {
            MerchantOffers merchantOffers = this.getOffers();
            this.addOffersFromItemListings(merchantOffers, trades$itemlisting);
            int i = this.random.nextInt(trades$itemlisting1.length);
            VillagerTrades.ItemListing villagertrades$itemlisting = trades$itemlisting1[i];
            MerchantOffer merchantOffer = villagertrades$itemlisting.getOffer(this, this.random);
            if (merchantOffer != null) {
                merchantOffers.add(merchantOffer);
            }
        }
    }

    protected void addOffersFromItemListings(MerchantOffers offers, VillagerTrades.ItemListing[] listings) {
        Set<Integer> set = Sets.newHashSet();
        if (listings.length > PiglinMerchant.maxOFFERS) {
            while (set.size() < PiglinMerchant.maxOFFERS) {
                set.add(this.random.nextInt(listings.length));
            }
        }
        else {
            for (int i = 0; i < listings.length; ++i) {
                set.add(i);
            }
        }

        for (Integer integer : set) {
            VillagerTrades.ItemListing villagertrades$itemlisting = listings[integer];
            MerchantOffer merchantoffer = villagertrades$itemlisting.getOffer(this, this.random);
            if (merchantoffer != null) {
                offers.add(merchantoffer);
            }
        }
    }

    @Override
    public void notifyTrade(MerchantOffer offer) {
        offer.increaseUses();
        this.ambientSoundTime = -this.getAmbientSoundInterval();
        this.rewardTradeXp(offer);
    }

    protected void rewardTradeXp(MerchantOffer offer) {
        if (offer.shouldRewardExp()) {
            int i = 3 + this.random.nextInt(4);
            this.level.addFreshEntity(new ExperienceOrb(this.level, this.getX(), this.getY() + 0.5D, this.getZ(), i));
        }
    }

    @Override
    public void notifyTradeUpdated(@NotNull ItemStack stack) {
        if (!this.level.isClientSide && this.ambientSoundTime > -this.getAmbientSoundInterval() + 20) {
            this.ambientSoundTime = -this.getAmbientSoundInterval();
            this.playSound(this.getTradeUpdatedSound(!stack.isEmpty()), this.getSoundVolume(), this.getVoicePitch());
        }
    }

    @Override
    public int getVillagerXp() {
        return 0;
    }

    @Override
    public void overrideXp(int xp) {}

    @Override
    public boolean showProgressBar() {
        return false;
    }

    @Override
    public boolean isClientSide() {
        return this.getLevel().isClientSide;
    }

    @Override
    public void openTradingScreen(@NotNull Player pPlayer, @NotNull Component pDisplayName, int pLevel) {
        Merchant.super.openTradingScreen(pPlayer, pDisplayName, pLevel);
    }

    // sound events
    protected @NotNull SoundEvent getTradeUpdatedSound(boolean likesOffer) {
        return likesOffer ? ModSounds.PIGLINMERCHANT_CELEBRATE.get() : ModSounds.PIGLINMERCHANT_EXAMINE.get();
    }

    @Override
    public @NotNull SoundEvent getNotifyTradeSound() {
        return ModSounds.PIGLINMERCHANT_CELEBRATE.get();
    }

    protected SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return ModSounds.PIGLINMERCHANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.PIGLINMERCHANT_DEATH.get();
    }

    protected void playStepSound(@NotNull BlockPos pPos, @NotNull BlockState pBlock) {
        this.playSound(ModSounds.PIGLINMERCHANT_STEP.get(), 0.15F, 1.0F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return ModSounds.PIGLINMERCHANT_AMBIENT.get();
    }

    // "lifespan" control
    public void setDespawnDelay(int despawnDelay) {
        this.despawnDelay = despawnDelay;
    }

    public int getDespawnDelay() {
        return this.despawnDelay;
    }

    private void maybeDespawn() {
        if (getDespawnDelay() > 0 && !this.isTrading() && --this.despawnDelay == 0) {
            this.discard();
        }
    }

    // tick and animation
    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.maybeDespawn();
        }

        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        }
        else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && this.attackAnimationTimeout <= 0) {
            this.attackAnimationTimeout = 30;
            if (this.isLeftHanded()) {
                this.meleeLeftAnimationState.start(this.tickCount);
            }
            else {
                this.meleeRightAnimationState.start(this.tickCount);
            }
        }
        else {
            --this.attackAnimationTimeout;
        }
        if (!this.isAttacking() || !this.isAggressive()) {
            this.meleeLeftAnimationState.stop();
            this.meleeRightAnimationState.stop();
        }

        //noinspection RedundantIfStatement
        if (isMovingOnLand()) {
            this.setWalking(true);
        }
        else {
            this.setWalking(false);
        }
        if (isWalking()) {
            if (!this.swinging) {
                this.walkAnimationState.startIfStopped(this.tickCount);
            }
            else {
                this.walkLegsOnlyAnimationState.startIfStopped(this.tickCount);
            }
        }
        else {
            this.walkAnimationState.stop();
            this.walkLegsOnlyAnimationState.stop();
        }

        if (this.level.isClientSide()) {
            if (isAttacking()) {
                if (this.isLeftHanded()) {
                    clientParticles(this.meleeLeftAnimationState);
                }
                else {
                    clientParticles(this.meleeRightAnimationState);
                }
            }
        }

        updateSwingTime();
    }

    private boolean isMovingOnLand() {
        return this.onGround && this.getDeltaMovement()
                                        .horizontalDistanceSqr() > 1.0E-6 && !this.isInWaterOrBubble();
    }

    private void clientParticles(AnimationState animationState) {
        if (isDancing()) {
            if ((float) animationState.getAccumulatedTime() < DANCE_DURATION) {
                RandomSource random = getRandom();
                BlockState blockstate = getBlockStateOn();
                if (blockstate.getRenderShape() != RenderShape.INVISIBLE) {
                    for (int i = 0; i < 1; ++i) {
                        Vec3 vec3 = new Vec3(((double) random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, ((double) random.nextFloat() - 0.5D) * 0.1D);
                        vec3 = vec3.xRot(-getXRot() * ((float) Math.PI / 180F));
                        vec3 = vec3.yRot(-getYRot() * ((float) Math.PI / 180F));
                        double d0 = (double) (-random.nextFloat()) * 0.6D - 0.3D;
                        Vec3 vec31 = new Vec3(((double) random.nextFloat() - 0.5D) * 0.8D, d0, 1.0D + ((double) random.nextFloat() - 0.5D) * 0.4D);
                        vec31 = vec31.yRot(-yBodyRot * ((float) Math.PI / 180F));
                        vec31 = vec31.add(getX(), getEyeY() - 0.2D, getZ());
                        level.addParticle(ParticleTypes.NOTE, vec31.x, vec31.y, vec31.z, vec3.x, vec3.y + 0.05D, vec3.z);
                    }
                }
            }
        }
        else if (this.isAggressive()) {
            if ((float) animationState.getAccumulatedTime() < MELEE_COOLDOWN) {
                RandomSource random = getRandom();
                BlockState blockstate = getBlockStateOn();
                if (blockstate.getRenderShape() != RenderShape.INVISIBLE) {
                    for (int i = 0; i < 1; ++i) {
                        Vec3 vec3 = new Vec3(((double) random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, ((double) random.nextFloat() - 0.5D) * 0.1D);
                        vec3 = vec3.xRot(-getXRot() * ((float) Math.PI / 180F));
                        vec3 = vec3.yRot(-getYRot() * ((float) Math.PI / 180F));
                        double d0 = (double) (-random.nextFloat()) * 0.6D - 0.3D;
                        Vec3 vec31 = new Vec3(((double) random.nextFloat() - 0.5D) * 0.8D, d0, 1.0D + ((double) random.nextFloat() - 0.5D) * 0.4D);
                        vec31 = vec31.yRot(-yBodyRot * ((float) Math.PI / 180F));
                        vec31 = vec31.add(getX(), getEyeY() - 0.2D, getZ());
                        level.addParticle(ParticleTypes.ANGRY_VILLAGER, vec31.x, vec31.y, vec31.z, vec3.x, vec3.y + 0.05D, vec3.z);
                    }
                }
            }
        }
    }

    // wander control
    public void setWanderTarget(@javax.annotation.Nullable BlockPos wanderTarget) {
        this.wanderTarget = wanderTarget;
    }

    @Nullable
    BlockPos getWanderTarget() {
        return this.wanderTarget;
    }

    class WanderToPositionGoal extends Goal {
        final PiglinMerchant trader;
        final double stopDistance;
        final double speedModifier;

        WanderToPositionGoal(PiglinMerchant merchant) {
            this.trader = merchant;
            this.stopDistance = 2.0D;
            this.speedModifier = PiglinMerchant.SPEED_WALK;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public void stop() {
            this.trader.setWanderTarget(null);
            PiglinMerchant.this.navigation.stop();
        }

        public boolean canUse() {
            BlockPos blockPos = this.trader.getWanderTarget();
            return blockPos != null && this.isTooFarAway(blockPos, this.stopDistance);
        }

        public void tick() {
            BlockPos blockPos = this.trader.getWanderTarget();
            if (blockPos != null && PiglinMerchant.this.navigation.isDone()) {
                if (this.isTooFarAway(blockPos, 10.0D)) {
                    Vec3 vec3 = (new Vec3((double) blockPos.getX() - this.trader.getX(), (double) blockPos.getY() - this.trader.getY(), (double) blockPos.getZ() - this.trader.getZ())).normalize();
                    Vec3 vec31 = vec3.scale(10.0D)
                                         .add(this.trader.getX(), this.trader.getY(), this.trader.getZ());
                    PiglinMerchant.this.navigation.moveTo(vec31.x, vec31.y, vec31.z, this.speedModifier);
                }
                else {
                    PiglinMerchant.this.navigation.moveTo(blockPos.getX(), blockPos.getY(), blockPos.getZ(), this.speedModifier);
                }
            }
        }

        private boolean isTooFarAway(@NotNull BlockPos blockPos, double distance) {
            return !blockPos.closerToCenterThan(this.trader.position(), distance);
        }
    }
}