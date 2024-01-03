package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.effect.ModEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class SilencePlayerMixin {
    @Unique
    Player todeCoins$player = (Player) ((Object) this);

    @Inject(
            method = {"eat"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    protected void todeCoins_eat(Level level, ItemStack food, CallbackInfoReturnable<ItemStack> cir) {
        if (todeCoins$player.hasEffect(ModEffects.SILENCE_CLOAK.get())) {
            if (food.isEdible()) {
                todeCoins$player.getFoodData().eat(food.getItem(), food, todeCoins$player);
                todeCoins$player.awardStat(Stats.ITEM_USED.get(food.getItem()));
                todeCoins$player.addEatEffect(food, level, todeCoins$player);

                if (todeCoins$player instanceof ServerPlayer) {
                    CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) todeCoins$player, food);
                }

                if (!(todeCoins$player instanceof Player) || !todeCoins$player.getAbilities().instabuild) {
                    food.shrink(1);
                }

                todeCoins$player.gameEvent(GameEvent.EAT);
            }

            cir.setReturnValue(food);
        }
    }
}