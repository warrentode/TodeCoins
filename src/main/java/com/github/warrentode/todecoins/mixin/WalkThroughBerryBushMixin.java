package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
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
    private void todeCoins_injectEntityInside(BlockState state, Level level, BlockPos pos, Entity entity, CallbackInfo ci) {
        if (entity instanceof ServerPlayer player) {
            if (ModList.get().isLoaded("curios")) {
                ItemStack stack = null;

                Optional<SlotResult> foxCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.COPPER_FOX_COIN.get());
                Optional<SlotResult> foxCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.IRON_FOX_COIN.get());
                Optional<SlotResult> foxCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.GOLD_FOX_COIN.get());
                Optional<SlotResult> foxCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.NETHERITE_FOX_COIN.get());

                if (foxCoin1.isPresent()) {
                    stack = foxCoin1.get().stack();
                }
                else if (foxCoin2.isPresent()) {
                    stack = foxCoin2.get().stack();
                }
                else if (foxCoin3.isPresent()) {
                    stack = foxCoin3.get().stack();
                }
                else if (foxCoin4.isPresent()) {
                    stack = foxCoin4.get().stack();
                }

                if (stack != null && stack.is(ModTags.Items.FOX_COIN_SET)) {
                    ci.cancel();
                }
            }
        }
    }
}