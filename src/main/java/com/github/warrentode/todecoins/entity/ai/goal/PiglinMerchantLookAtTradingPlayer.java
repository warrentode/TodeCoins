package com.github.warrentode.todecoins.entity.ai.goal;

import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;

public class PiglinMerchantLookAtTradingPlayer extends LookAtPlayerGoal {
    private final PiglinMerchant piglinMerchant;

    public PiglinMerchantLookAtTradingPlayer(PiglinMerchant piglinMerchant) {
        super(piglinMerchant, Player.class, 8.0F);
        this.piglinMerchant = piglinMerchant;
    }

    public boolean canUse() {
        if (this.piglinMerchant.isTrading()) {
            this.lookAt = this.piglinMerchant.getTradingPlayer();
            return true;
        }
        else {
            return false;
        }
    }
}