package com.github.warrentode.todecoins.effect.custom;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class BurningStrikeEffect extends MobEffect {
    public BurningStrikeEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
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
            default -> targetDuration = 5; // peaceful
        }

        if (!attacker.level.isClientSide && target instanceof LivingEntity livingTarget) {
            if (attacker.hasEffect(TCMobEffects.BURNING_STRIKE.get())) {
                livingTarget.setSecondsOnFire(targetDuration + 1);
            }
        }
    }
}