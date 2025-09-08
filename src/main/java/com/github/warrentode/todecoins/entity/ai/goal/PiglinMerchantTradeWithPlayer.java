package com.github.warrentode.todecoins.entity.ai.goal;

import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

import java.util.EnumSet;

public class PiglinMerchantTradeWithPlayer extends Goal {
    private final PiglinMerchant piglinMerchant;

    public PiglinMerchantTradeWithPlayer(PiglinMerchant merchant) {
        this.piglinMerchant = merchant;
        this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
    }

    public boolean canUse() {
        if (!this.piglinMerchant.isAlive()) {
            return false;
        }
        else if (this.piglinMerchant.isInWater()) {
            return false;
        }
        else if (!this.piglinMerchant.onGround()) {
            return false;
        }
        else if (this.piglinMerchant.hurtMarked) {
            return false;
        }
        else {
            Player player = this.piglinMerchant.getTradingPlayer();
            if (player == null) {
                return false;
            }
            else {
                return !(this.piglinMerchant.distanceToSqr(player) > 16.0D);
            }
        }
    }

    public void start() {
        this.piglinMerchant.getNavigation().stop();
    }

    public void stop() {
        this.piglinMerchant.setTradingPlayer(null);
    }
}