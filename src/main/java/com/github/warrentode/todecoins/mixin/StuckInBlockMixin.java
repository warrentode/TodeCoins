package com.github.warrentode.todecoins.mixin;

import com.github.warrentode.todecoins.effect.ModEffects;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;

@Mixin(Entity.class)
public class StuckInBlockMixin {
    @Unique
    Entity todeCoins$entity = (Entity) (Object) this;

    @Inject(at = @At("HEAD"), method = "makeStuckInBlock", cancellable = true)
    public void todeCoins_makeStuckInBlock(@NotNull BlockState state, Vec3 vec3, CallbackInfo ci) {
        if (todeCoins$entity instanceof LivingEntity livingEntity) {
            ItemStack stack = null;
            if (ModList.get().isLoaded("curios")) {
                Optional<SlotResult> foxCoin1 = CuriosApi.getCuriosHelper().findFirstCurio(livingEntity, ModItems.COPPER_FOX_COIN.get());
                Optional<SlotResult> foxCoin2 = CuriosApi.getCuriosHelper().findFirstCurio(livingEntity, ModItems.IRON_FOX_COIN.get());
                Optional<SlotResult> foxCoin3 = CuriosApi.getCuriosHelper().findFirstCurio(livingEntity, ModItems.GOLD_FOX_COIN.get());
                Optional<SlotResult> foxCoin4 = CuriosApi.getCuriosHelper().findFirstCurio(livingEntity, ModItems.NETHERITE_FOX_COIN.get());

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
            }

            if (livingEntity.hasEffect(ModEffects.ARTHROPOD_BLIGHT.get()) && state.is(Blocks.COBWEB)) {
                ci.cancel();
            }
            if ((stack != null && stack.is(TodeCoinsTags.Items.FOX_COIN_SET)) && state.is(Blocks.SWEET_BERRY_BUSH)) {
                ci.cancel();
            }
        }
    }
}