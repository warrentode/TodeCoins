package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.integration.Curios;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SweetBerryBushBlock.class)
public abstract class WalkThroughBerryBushMixin {
    @Inject(at = @At("HEAD"), method = "entityInside", cancellable = true)
    private void todecoins_injectEntityInside(BlockState state, Level level, BlockPos pos, Entity entity, CallbackInfo ci) {
        Player player = Minecraft.getInstance().player;
        if (entity instanceof LivingEntity && entity.getType() == EntityType.PLAYER && player != null) {
            if (TodeCoins.isModLoaded("curios")) {
                ItemStack stack = Curios.getCharmSlot(player);
                if (stack != null && stack.is(ModTags.Items.FOX_COIN_SET)) {
                    ci.cancel();
                }
            }
        }
    }
}