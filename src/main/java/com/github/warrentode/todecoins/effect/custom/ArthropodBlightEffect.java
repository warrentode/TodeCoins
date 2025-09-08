package com.github.warrentode.todecoins.effect.custom;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.util.ModUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class ArthropodBlightEffect extends MobEffect {
    public ArthropodBlightEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
    }

    @Override
    public final void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.hasEffect(MobEffects.POISON)) {
                serverPlayer.removeEffect(MobEffects.POISON);
            }
            if (serverPlayer.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                serverPlayer.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }
            if (ModList.get().isLoaded("unusual_end") && serverPlayer.hasEffect(ModUtil.getEffect("unusual_end:ender_infection"))) {
                serverPlayer.removeEffect(ModUtil.getEffect("unusual_end:ender_infection"));
            }
        }
    }

    @SubscribeEvent
    public static void onAttackEntity(@NotNull AttackEntityEvent event) {
        LivingEntity attacker = event.getEntity();
        Entity target = event.getTarget();

        int targetDuration;
        switch (attacker.level.getDifficulty()) {
            case EASY -> targetDuration = 20;
            case NORMAL -> targetDuration = 15;
            case HARD -> targetDuration = 10;
            // default for peaceful
            default -> targetDuration = 5;
        }

        if (!attacker.level.isClientSide && target instanceof LivingEntity livingTarget) {
            MobEffectInstance effectInstance = attacker.getEffect(TCMobEffects.ARTHROPOD_BLIGHT.get());
            if (effectInstance != null && livingTarget.getMobType() == MobType.ARTHROPOD) {
                int amplifier = effectInstance.getAmplifier();
                livingTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, targetDuration * 20, amplifier), livingTarget);
                livingTarget.hurt(attacker.damageSources().generic(), 2.5F * getDamage(amplifier, attacker.level.random));
            }
        }
    }

    public static int getDamage(int level, RandomSource random) {
        return level > 10 ? level - 10 : 1 + random.nextInt(4);
    }
}