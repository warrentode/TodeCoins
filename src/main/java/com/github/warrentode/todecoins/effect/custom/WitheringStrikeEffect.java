package com.github.warrentode.todecoins.effect.custom;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class WitheringStrikeEffect extends MobEffect {
    public WitheringStrikeEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
        // applies wither to the attack target during the living attack event
    }

    @SubscribeEvent
    public static void onAttackEntity(@NotNull AttackEntityEvent event) {
        LivingEntity attacker = event.getEntity();
        Entity target = event.getTarget();

        // Duration in seconds, converted to ticks (20 ticks = 1 second)
        int targetDuration;
        switch (attacker.level.getDifficulty()) {
            case EASY -> targetDuration = 20;
            case NORMAL -> targetDuration = 15;
            case HARD -> targetDuration = 10;
            default -> targetDuration = 5; // Peaceful or unknown difficulty
        }

        if (!attacker.level.isClientSide && target instanceof LivingEntity livingTarget) {
            MobEffectInstance effectInstance = attacker.getEffect(TCMobEffects.WITHERING_STRIKE.get());
            if (effectInstance != null) {
                MobEffectInstance existingWither = livingTarget.getEffect(MobEffects.WITHER);
                if (existingWither == null
                        || existingWither.getAmplifier() < effectInstance.getAmplifier()
                        || existingWither.getDuration() < targetDuration * 20) {
                    livingTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, targetDuration * 20, effectInstance.getAmplifier()), livingTarget);
                }
            }
        }
    }
}