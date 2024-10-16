package com.github.warrentode.todecoins.entity.ai.goal;

import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class PiglinMerchantDefendVillageTarget extends TargetGoal {
    private final PiglinMerchant merchant;
    private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0D);
    @Nullable
    private LivingEntity potentialTarget;

    public PiglinMerchantDefendVillageTarget(PiglinMerchant merchant) {
        super(merchant, true, true);
        this.merchant = merchant;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {
        AABB aabb = this.merchant.getBoundingBox().inflate(10.0D, 8.0D, 10.0D);
        List<? extends LivingEntity> list = this.merchant.level.getNearbyEntities(Villager.class, this.attackTargeting, this.merchant, aabb);
        List<Player> list1 = this.merchant.level.getNearbyPlayers(this.attackTargeting, this.merchant, aabb);

        for (LivingEntity livingentity : list) {
            Villager villager = (Villager) livingentity;

            for (Player player : list1) {
                int i = villager.getPlayerReputation(player);
                if (i <= -100) {
                    this.potentialTarget = player;
                }
            }
        }

        if (this.potentialTarget == null) {
            return false;
        }
        else {
            return !(this.potentialTarget instanceof Player) || !this.potentialTarget.isSpectator() && !((Player) this.potentialTarget).isCreative();
        }
    }

    public void start() {
        this.merchant.setTarget(this.potentialTarget);
        super.start();
    }
}