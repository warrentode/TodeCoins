package net.warrentode.todecoins.mixin;

import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.warrentode.todecoins.attribute.PlayerCharisma;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Villager.class)
public abstract class VillagerMixin {

    @Inject(at = {@At("TAIL")}, method = {"getPlayerReputation(Lnet/minecraft/world/entity/player/Player;)I"}, cancellable = true)
    private void todecoins_updateSpecialPrices(Player player, @NotNull CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(cir.getReturnValue() + PlayerCharisma.getCharismaBonus(player));
    }
}