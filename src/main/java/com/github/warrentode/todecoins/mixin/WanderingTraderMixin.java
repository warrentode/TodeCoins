package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.config.Config;
import net.minecraft.world.entity.npc.WanderingTrader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(WanderingTrader.class)
public class WanderingTraderMixin {
    @ModifyConstant(method = "updateTrades", constant = @Constant(intValue = 5))
    private int changeTradeOfferCount(int value) {
        return Config.MAX_WANDERER_COMMON_TRADES.get();
    }
}