package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.integration.Curios;
import com.github.warrentode.todecoins.integration.ModListHandler;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(Phantom.PhantomSweepAttackGoal.class)
public abstract class PhantomBehaviorMixin {
    @Unique
    @Final
    Phantom this$0;
    @Unique
    private final Phantom.PhantomSweepAttackGoal todeCoins$phantomSweepAttackGoal = (Phantom.PhantomSweepAttackGoal) (Object) this;
    @Unique
    private int todeCoins$tickCount;
    @Unique
    private boolean todeCoins$isScaredOfCat;
    @Unique
    private int todeCoins$catSearchTick;

    @Unique
    private static boolean todeCoins$isWearingCatCoin(Player player) {
        ItemStack stack = Curios.getCharmSlot(player);
        ItemStack catCoin = null;

        if (ModListHandler.curiosLoaded) {
            if (stack != null && (stack.is(ModTags.Items.CAT_COIN_SET) || stack.is(ModTags.Items.OCELOT_COIN_SET))) {
                catCoin = stack;
            }
        }
        return catCoin != null;
    }

    @Inject(at = @At("HEAD"), method = "canContinueToUse()Z", cancellable = true)
    private void todecoins_canContinueToUse(CallbackInfoReturnable<Boolean> cir) {
        Player player = Minecraft.getInstance().player;

        // TODO: fix random tick crash on Phantom with this
        if (this$0.tickCount > this.todeCoins$catSearchTick) {
            this.todeCoins$catSearchTick = this$0.tickCount + 20;
            List<Player> playerList = this$0.level.getEntitiesOfClass(Player.class, this$0.getBoundingBox().inflate(16.0D), EntitySelector.ENTITY_STILL_ALIVE);
            List<Player> fakeCat = new ArrayList<>();

            if (player != null && todeCoins$isWearingCatCoin(player) && !player.isCreative() && !player.isSpectator()) {
                fakeCat.add(player);
                player.playSound(SoundEvents.CAT_HISS, 1.0F, player.getVoicePitch());

                this.todeCoins$isScaredOfCat = !fakeCat.isEmpty();
                todeCoins$phantomSweepAttackGoal.stop();
                cir.setReturnValue(false);
            }
        }
    }
}