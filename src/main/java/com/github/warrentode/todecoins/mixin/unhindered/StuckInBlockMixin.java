package com.github.warrentode.todecoins.mixin.unhindered;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class StuckInBlockMixin {
    @Inject(at = @At("HEAD"), method = "makeStuckInBlock", cancellable = true)
    public final void todeCoins_makeStuckInBlock(@NotNull BlockState state, Vec3 vec3, CallbackInfo ci) {
        Entity todeCoins$entity = (Entity) (Object) this;

        if (todeCoins$entity instanceof Player player) {
            // Only check equipped coins, ignore inventory
            if (state.is(Blocks.COBWEB) && ModList.get().isLoaded("curios") &&
                    CuriosHelper.hasCurioItemEquipped(player,
                            TCItems.COLLECTIBLE_COIN_CAVE_SPIDER_COPPER.get(),
                            TCItems.COLLECTIBLE_COIN_CAVE_SPIDER_IRON.get(),
                            TCItems.COLLECTIBLE_COIN_CAVE_SPIDER_GOLD.get(),
                            TCItems.COLLECTIBLE_COIN_CAVE_SPIDER_NETHERITE.get(),
                            TCItems.COLLECTIBLE_COIN_SPIDER_COPPER.get(),
                            TCItems.COLLECTIBLE_COIN_SPIDER_IRON.get(),
                            TCItems.COLLECTIBLE_COIN_SPIDER_GOLD.get(),
                            TCItems.COLLECTIBLE_COIN_SPIDER_NETHERITE.get()
                    )) {
                ci.cancel(); // cancel the stuck-in-block effect
            }
        }
        else if (todeCoins$entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(TCMobEffects.UNHINDERED.get())) {
                ci.cancel(); // cancels the method that applies stuck hasEffect logic
            }
        }
    }
}