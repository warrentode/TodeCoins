package com.github.warrentode.todecoins.effect;

import net.mcreator.unusualend.init.UnusualendModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ArthropodBlightEffect extends MobEffect {
    @Nullable
    private String descriptionId;
    static int amplifier;
    static int duration;

    protected ArthropodBlightEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.BENEFICIAL, 0x800000);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.hasEffect(MobEffects.POISON)) {
                serverPlayer.removeEffect(MobEffects.POISON);
            }
            if (serverPlayer.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                serverPlayer.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }
            if (ModList.get().isLoaded("unusual_end") && serverPlayer.hasEffect(UnusualendModMobEffects.ENDER_INFECTION.get())) {
                serverPlayer.removeEffect(UnusualendModMobEffects.ENDER_INFECTION.get());
            }
        }

        // also inflicts slow and extra dmg upon arthropods during the living hurt event in the ModEvents class
    }

    public static int getAmplifier() {
        return amplifier;
    }

    public static int getDuration() {
        return duration;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}