package net.warrentode.todecoins.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.warrentode.todecoins.entity.ai.goal.AvoidPlayerWithCatDisguiseGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Creeper.class)
public abstract class CreeperBehaviorMixin extends PathfinderMob {
    protected CreeperBehaviorMixin(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(at = @At("HEAD"), method = "registerGoals()V")
    private void todecoins_registerGoals(CallbackInfo ci) {
        Player player = Minecraft.getInstance().player;
        this.goalSelector.addGoal(3, new AvoidPlayerWithCatDisguiseGoal<>(this, Player.class, 6.0F, 1.0D, 1.2D));
    }
}