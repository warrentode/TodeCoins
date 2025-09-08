package com.github.warrentode.todecoins.effect.custom;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.raid.Raider;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class IllagerBaneEffect extends MobEffect {
    public IllagerBaneEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
    }

    @SubscribeEvent
    public static void onAttackEntity(@NotNull AttackEntityEvent event) {
        LivingEntity attacker = event.getEntity();
        Entity target = event.getTarget();

        int targetDuration = switch (attacker.level.getDifficulty()) {
            case EASY -> 20;
            case NORMAL -> 15;
            case HARD -> 10;
            default -> 5; // peaceful or other
        };

        if (!attacker.level.isClientSide && target instanceof LivingEntity livingTarget) {
            MobEffectInstance effectInstance = attacker.getEffect(TCMobEffects.ILLAGER_BANE.get());
            if (effectInstance != null && ((livingTarget instanceof Vex || livingTarget instanceof Raider))) {
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