package com.github.warrentode.todecoins.mixin.unhindered;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SweetBerryBushBlock.class)
public abstract class WalkThroughBerryBushMixin {
    @Inject(at = @At("HEAD"), method = "entityInside", cancellable = true)
    private void todeCoins_injectEntityInside(BlockState state, Level level, BlockPos pos, Entity entity, CallbackInfo ci) {
        if (entity instanceof Player player) {
            // Only check equipped coins, ignore inventory
            if (ModList.get().isLoaded("curios") &&
                    CuriosHelper.hasCurioItemEquipped(player,
                            TCItems.COLLECTIBLE_COIN_FOX_COPPER.get(),
                            TCItems.COLLECTIBLE_COIN_FOX_IRON.get(),
                            TCItems.COLLECTIBLE_COIN_FOX_GOLD.get(),
                            TCItems.COLLECTIBLE_COIN_FOX_NETHERITE.get(),
                            TCItems.COLLECTIBLE_COIN_BEE_COPPER.get(),
                            TCItems.COLLECTIBLE_COIN_BEE_IRON.get(),
                            TCItems.COLLECTIBLE_COIN_BEE_GOLD.get(),
                            TCItems.COLLECTIBLE_COIN_BEE_NETHERITE.get()
                    )) {
                ci.cancel(); // cancel the stuck-in-block effect
            }
        }
        else if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(TCMobEffects.UNHINDERED.get())) {
                ci.cancel(); // cancels the method that applies stuck effect logic
            }
        }
    }
}