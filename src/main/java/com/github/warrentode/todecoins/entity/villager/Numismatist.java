package com.github.warrentode.todecoins.entity.villager;

import com.github.warrentode.todecoins.entity.villager.trades.NumismatistTrades;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Numismatist extends WanderingTrader {
    // TODO create custom sound file with the correct subtitles for Numismatist
    /**
     * the number of total trades this merchant has to offer can be altered here - default is 5 for Wandering Trader
     **/
    private static final int maxOFFERS = 5;
    @Nullable
    private BlockPos wanderTarget;
    private int despawnDelay;

    public Numismatist(EntityType<? extends WanderingTrader> entityType, Level level) {
        super(entityType, level);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new UseItemGoal<>(this, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.INVISIBILITY),
                SoundEvents.WANDERING_TRADER_DISAPPEARED, (numismatist) -> this.level.isNight() && !numismatist.isInvisible()));
        this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET),
                SoundEvents.WANDERING_TRADER_REAPPEARED, (numismatist) -> this.level.isDay() && numismatist.isInvisible()));
        this.goalSelector.addGoal(1, new TradeWithPlayerGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zombie.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Evoker.class, 12.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Vindicator.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Vex.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Pillager.class, 15.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Illusioner.class, 12.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zoglin.class, 10.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
        this.goalSelector.addGoal(1, new LookAtTradingPlayerGoal(this));
        this.goalSelector.addGoal(2, new Numismatist.WanderToPositionGoal(this, 2.0D, 0.35D));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.35D));
        this.goalSelector.addGoal(9, new InteractGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
    }

    public @NotNull InteractionResult mobInteract(@NotNull Player pPlayer, @NotNull InteractionHand hand) {
        ItemStack stack = pPlayer.getItemInHand(hand);
        if (!stack.is(Items.VILLAGER_SPAWN_EGG) && this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (hand == InteractionHand.MAIN_HAND) {
                pPlayer.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (!this.getOffers().isEmpty()) {
                if (!this.level.isClientSide) {
                    this.setTradingPlayer(pPlayer);
                    this.openTradingScreen(pPlayer, this.getDisplayName(), 1);
                }
            }
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }
        else {
            return super.mobInteract(pPlayer, hand);
        }
    }

    @Override
    public void updateTrades() {
        VillagerTrades.ItemListing[] avillagertrades$itemlisting = NumismatistTrades.NUMISMATIST_TRADES.get(1);
        VillagerTrades.ItemListing[] avillagertrades$itemlisting1 = NumismatistTrades.NUMISMATIST_TRADES.get(2);
        if (avillagertrades$itemlisting != null && avillagertrades$itemlisting1 != null) {
            MerchantOffers merchantoffers = this.getOffers();
            this.addOffersFromItemListings(merchantoffers, avillagertrades$itemlisting, maxOFFERS);
            int i = this.random.nextInt(avillagertrades$itemlisting1.length);
            VillagerTrades.ItemListing villagertrades$itemlisting = avillagertrades$itemlisting1[i];
            MerchantOffer merchantOffer = villagertrades$itemlisting.getOffer(this, this.random);
            if (merchantOffer != null) {
                merchantoffers.add(merchantOffer);
            }
        }
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("DespawnDelay", this.despawnDelay);
        if (this.wanderTarget != null) {
            nbt.put("WanderTarget", NbtUtils.writeBlockPos(this.wanderTarget));
        }
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("DespawnDelay", 99)) {
            this.despawnDelay = nbt.getInt("DespawnDelay");
        }

        if (nbt.contains("WanderTarget")) {
            this.wanderTarget = NbtUtils.readBlockPos(nbt.getCompound("WanderTarget"));
        }

        this.setAge(Math.max(0, this.getAge()));
    }

    @Override
    protected @NotNull SoundEvent getDrinkingSound(@NotNull ItemStack stack) {
        return stack.is(Items.MILK_BUCKET) ? SoundEvents.WANDERING_TRADER_DRINK_MILK : SoundEvents.WANDERING_TRADER_DRINK_POTION;
    }

    @Override
    protected @NotNull SoundEvent getTradeUpdatedSound(boolean pGetYesSound) {
        return pGetYesSound ? SoundEvents.WANDERING_TRADER_YES : SoundEvents.WANDERING_TRADER_NO;
    }

    @Override
    public @NotNull SoundEvent getNotifyTradeSound() {
        return SoundEvents.WANDERING_TRADER_YES;
    }

    @Override
    public void setDespawnDelay(int despawnDelay) {
        this.despawnDelay = despawnDelay;
    }

    @Override
    public int getDespawnDelay() {
        return this.despawnDelay;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide) {
            this.maybeDespawn();
        }
    }

    private void maybeDespawn() {
        if (this.despawnDelay > 0 && !this.isTrading() && --this.despawnDelay == 0) {
            this.discard();
        }
    }

    @Override
    public void setWanderTarget(@Nullable BlockPos wanderTarget) {
        this.wanderTarget = wanderTarget;
    }

    @Nullable
    BlockPos getWanderTarget() {
        return this.wanderTarget;
    }

    // WHY IS THIS NOT A SEPARATE FILE?! Wouldn't this be better as a reusable goal in terms of overall AI/Brain building?
    // I really do not understand why they have built their entities the way they have in many cases
    // then I remember how easy it was to build a bot for a certain game ages ago and wonder if that is a big reason why
    // I mean... that bot was really just a very long series of IF/THAN statements in XML, which in retrospect, for an online game should not be possible
    // and granted, all I did was create the means to control more than one character at the same time, but still
    // even if you need to put in place anti-cheating measures, it doesn't explain some of this weird and seemingly lazy organization
    // if I decide to use this particular goal for another entity, I will be moving it to a unique file and editing it for generic use
    class WanderToPositionGoal extends Goal {
        final Numismatist trader;
        final double stopDistance;
        final double speedModifier;

        WanderToPositionGoal(Numismatist numismatist, double stopDistance, double speedModifier) {
            this.trader = numismatist;
            this.stopDistance = stopDistance;
            this.speedModifier = speedModifier;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void stop() {
            this.trader.setWanderTarget(null);
            Numismatist.this.navigation.stop();
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            BlockPos blockPos = this.trader.getWanderTarget();
            return blockPos != null && this.isTooFarAway(blockPos, this.stopDistance);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            BlockPos blockPos = this.trader.getWanderTarget();
            if (blockPos != null && Numismatist.this.navigation.isDone()) {
                if (this.isTooFarAway(blockPos, 10.0D)) {
                    Vec3 vec3 = (new Vec3((double) blockPos.getX() - this.trader.getX(), (double) blockPos.getY() - this.trader.getY(), (double) blockPos.getZ() - this.trader.getZ())).normalize();
                    Vec3 vec31 = vec3.scale(10.0D).add(this.trader.getX(), this.trader.getY(), this.trader.getZ());
                    Numismatist.this.navigation.moveTo(vec31.x, vec31.y, vec31.z, this.speedModifier);
                }
                else {
                    Numismatist.this.navigation.moveTo(blockPos.getX(), blockPos.getY(), blockPos.getZ(), this.speedModifier);
                }
            }
        }

        private boolean isTooFarAway(@NotNull BlockPos blockPos, double distance) {
            return !blockPos.closerToCenterThan(this.trader.position(), distance);
        }
    }
}