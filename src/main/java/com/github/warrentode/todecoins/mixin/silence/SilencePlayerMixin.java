package com.github.warrentode.todecoins.mixin.silence;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class SilencePlayerMixin {

    @Inject(
            method = {"eat"},
            at = @At("HEAD"),
            cancellable = true
    )
    protected final void todeCoins$eat(Level level, ItemStack food, CallbackInfoReturnable<ItemStack> cir) {
        Player todeCoins$player = (Player) ((Object) this);
        if (todeCoins$player.hasEffect(TCMobEffects.SILENCE_CLOAK.get())) {
            if (food.isEdible()) {
                todeCoins$player.getFoodData().eat(food.getItem(), food, todeCoins$player);
                todeCoins$player.awardStat(Stats.ITEM_USED.get(food.getItem()));
                todeCoins$player.addEatEffect(food, level, todeCoins$player);

                if (todeCoins$player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, food);
                }

                if (!(todeCoins$player instanceof Player) || !todeCoins$player.getAbilities().instabuild) {
                    food.shrink(1);
                }

                todeCoins$player.gameEvent(GameEvent.EAT);
            }

            cir.setReturnValue(food);
        }
    }

    @Redirect(
            method = {"attack"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"
            )
    )
    private void todeCoins$redirectAttackSounds(Level level, @Nullable Player player, double x, double y, double z,
                                                SoundEvent sound, SoundSource source, float volume, float pitch) {
        // Only block player attack-related sounds if Silence Cloak is active
        if (player != null && player.hasEffect(TCMobEffects.SILENCE_CLOAK.get()) && todeCoins$isAttackSound(sound)) {
            return; // Skip playing this sound
        }
        level.playSound(player, x, y, z, sound, source, volume, pitch);
    }

    @Unique
    private boolean todeCoins$isAttackSound(SoundEvent sound) {
        return sound == SoundEvents.PLAYER_ATTACK_SWEEP
                || sound == SoundEvents.PLAYER_ATTACK_CRIT
                || sound == SoundEvents.PLAYER_ATTACK_KNOCKBACK
                || sound == SoundEvents.PLAYER_ATTACK_NODAMAGE
                || sound == SoundEvents.PLAYER_ATTACK_STRONG
                || sound == SoundEvents.PLAYER_ATTACK_WEAK;
    }
}