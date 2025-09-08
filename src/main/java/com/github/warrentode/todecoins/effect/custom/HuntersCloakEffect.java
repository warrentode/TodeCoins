package com.github.warrentode.todecoins.effect.custom;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.entity.ai.goal.AvoidEntityWithEffectFlying;
import com.github.warrentode.todecoins.entity.ai.goal.AvoidEntityWithSound;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class HuntersCloakEffect extends MobEffect {
    public HuntersCloakEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
        // effects handled by events
    }

    @SubscribeEvent
    public static void onEntityJoinLevelEvent(@NotNull EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Creeper creeper) {
            SoundEvent fleeSound = SoundEvents.CAT_HISS;
            MobEffect huntersCloakEffect = TCMobEffects.HUNTERS_WARD.get();
            creeper.goalSelector.addGoal(3, new AvoidEntityWithSound<>(creeper, LivingEntity.class,
                    16.0F, 1.0D, 1.2D, fleeSound, huntersCloakEffect,
                    livingEntity -> true, livingEntity -> livingEntity.hasEffect(huntersCloakEffect)));
        }
        if (entity instanceof Ravager ravager) {
            SoundEvent fleeSound = SoundEvents.RAVAGER_ROAR;
            MobEffect huntersCloakEffect = TCMobEffects.HUNTERS_WARD.get();
            // Add the avoidance goal to the ravager to avoid all living entites with the effect active
            ravager.goalSelector.addGoal(3, new AvoidEntityWithSound<>(ravager, LivingEntity.class,
                    16.0F, 1.0D, 1.2D, fleeSound, huntersCloakEffect,
                    livingEntity -> true, livingEntity -> livingEntity.hasEffect(huntersCloakEffect)));
        }
        if (entity instanceof Phantom phantom) {
            SoundEvent fleeSound = SoundEvents.CAT_HISS;
            MobEffect huntersCloakEffect = TCMobEffects.HUNTERS_WARD.get();
            // Add the avoidance goal to the phantom to avoid all living entites with the effect active
            phantom.goalSelector.addGoal(3, new AvoidEntityWithEffectFlying<>(phantom, LivingEntity.class,
                            16.0F, 1.0D, TCMobEffects.HUNTERS_WARD.get(), fleeSound,
                    livingEntity -> true, livingEntity -> livingEntity.hasEffect(huntersCloakEffect)));
        }
        if (entity instanceof Piglin piglin) {
            SoundEvent fleeSound = SoundEvents.PIGLIN_RETREAT;
            MobEffect huntersCloakEffect = TCMobEffects.HUNTERS_WARD.get();
            // Add the avoidance goal to the phantom to avoid all living entites with the effect active
            piglin.goalSelector.addGoal(3, new AvoidEntityWithSound<>(piglin, LivingEntity.class,
                    16.0F, 1.0D, 1.2D, fleeSound, huntersCloakEffect,
                    livingEntity -> true, livingEntity -> livingEntity.hasEffect(huntersCloakEffect)));
        }
    }
}