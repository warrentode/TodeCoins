package com.github.warrentode.todecoins.entity.ai.goal;

import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.EnumSet;

public class OfferRandomItemGestureGoal extends Goal {
    private static final TargetingConditions OFFER_TARGET_CONTEXT = TargetingConditions.forNonCombat().range(6.0D);
    public static final int OFFER_TICKS = 400;
    private int offerCooldown = 0; // ticks until next possible offer

    private final PiglinMerchant piglin;
    private Villager villager;
    private int tick;

    // Predefined items to “offer”
    private final ItemStack[] possibleOffers = new ItemStack[]{
            new ItemStack(Items.COOKED_BEEF),     // piece of meat
            new ItemStack(Items.FIREWORK_ROCKET), // fireworks arrow equivalent
            new ItemStack(Items.EGG),         // baby chicken
            new ItemStack(Items.FISHING_ROD),     // fishing rod
            new ItemStack(Items.EMERALD)          // the item villagers actually accept
    };

    public OfferRandomItemGestureGoal(PiglinMerchant piglin) {
        this.piglin = piglin;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (!this.piglin.level.isDay()) {
            return false;
        }

        // Check cooldown
        if (offerCooldown > 0) {
            offerCooldown--;
            return false;
        }

        // Random chance to trigger offer
        if (this.piglin.getRandom().nextInt(200) != 0) { // ~0.5% chance per tick
            return false;
        }

        this.villager = this.piglin.level.getNearestEntity(
                Villager.class,
                OFFER_TARGET_CONTEXT,
                this.piglin,
                this.piglin.getX(),
                this.piglin.getY(),
                this.piglin.getZ(),
                this.piglin.getBoundingBox().inflate(6.0D, 2.0D, 6.0D)
        );

        if (this.villager != null) {
            offerCooldown = 200 + this.piglin.getRandom().nextInt(200); // wait 10-20 seconds before next attempt
            return true;
        }

        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return this.tick > 0;
    }

    @Override
    public void start() {
        this.tick = this.adjustedTickDelay(OFFER_TICKS);
        performOfferGesture(true);
    }

    @Override
    public void stop() {
        endOfferGesture(); // always restore spawn weapon
        this.villager = null;
    }

    @Override
    public void tick() {
        if (this.villager != null) {
            this.piglin.getLookControl().setLookAt(this.villager, 30.0F, 30.0F);
        }
        --this.tick;
    }

    @SuppressWarnings("SameParameterValue")
    private void performOfferGesture(boolean offering) {
        if (offering) {
            ItemStack offeredItem = possibleOffers[piglin.getRandom().nextInt(possibleOffers.length)];
            piglin.setItemInHand(InteractionHand.MAIN_HAND, offeredItem);
            piglin.setOfferingItem(true); // trigger model animation
        }
        else {
            endOfferGesture();
        }
    }

    private void endOfferGesture() {
        // Force the original spawn weapon back
        piglin.setItemInHand(InteractionHand.MAIN_HAND, piglin.createSpawnWeapon());
        piglin.setOfferingItem(false); // stop animation
    }
}