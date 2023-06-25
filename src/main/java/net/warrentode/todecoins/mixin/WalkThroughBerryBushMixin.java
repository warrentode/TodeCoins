package net.warrentode.todecoins.mixin;

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
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;

@Mixin(SweetBerryBushBlock.class)
public abstract class WalkThroughBerryBushMixin {

    @Inject(at = @At("HEAD"), method = "entityInside", cancellable = true)
    private void todecoins_injectEntityInside(BlockState state, Level level, BlockPos pos, Entity entity, CallbackInfo ci) {
        Player player = Minecraft.getInstance().player;
        ItemStack foxCoin = null;
        if (entity instanceof LivingEntity && entity.getType() == EntityType.PLAYER && player != null) {
            if (TodeCoins.isCuriosLoaded()) {
                Optional<SlotResult> optional1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_FOX_COIN.get());
                Optional<SlotResult> optional2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_FOX_COIN.get());
                Optional<SlotResult> optional3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_FOX_COIN.get());
                Optional<SlotResult> optional4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_FOX_COIN.get());
                if (optional1.isPresent()) {
                    foxCoin = optional1.get().stack();
                } else if (optional2.isPresent()) {
                    foxCoin = optional2.get().stack();
                } else if (optional3.isPresent()) {
                    foxCoin = optional3.get().stack();
                } else if (optional4.isPresent()) {
                    foxCoin = optional4.get().stack();
                }

                if (foxCoin != null) {
                    ci.cancel();
                }
            }
        }
    }
}