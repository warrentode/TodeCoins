package net.warrentode.todecoins.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.warrentode.todecoins.integration.Curios;
import net.warrentode.todecoins.util.tags.ForgeTags;
import net.warrentode.todecoins.util.tags.ModTags;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class PlayerVisibilityMixin {
    @Inject(at = @At("HEAD"), method = "getVisibilityPercent")
    protected void getVisibilityPercent(@NotNull Entity lookingEntity, CallbackInfoReturnable<Double> cir) {
        double d0 = 1.0D;
        Player player = Minecraft.getInstance().player;
        EntityType<?> entitytype = lookingEntity.getType();

        // TODO
        //  further testing of mob head visibility function with coins needed
        if (lookingEntity != null && player != null) {
            ItemStack stack = Curios.getCharmSlot(player);
            if (entitytype == EntityType.CREEPER && (stack != null && stack.is(ModTags.Items.CREEPER_COIN_SET))) {
                //noinspection UnusedAssignment
                d0 *= 0.5D;
            }
            else if (entitytype == EntityType.DROWNED && (stack != null && stack.is(ModTags.Items.DROWNED_COIN_SET))) {
                //noinspection UnusedAssignment
                d0 *= 0.5D;
            }
            else if (entitytype.is(ForgeTags.EntityTypes.ILLAGERS) && (stack != null && stack.is(ModTags.Items.EVOKER_COIN_SET))) {
                //noinspection UnusedAssignment
                d0 *= 0.5D;
            }
        }
    }
}