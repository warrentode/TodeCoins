package com.github.warrentode.todecoins.effect.custom;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class ThornShieldEffect extends MobEffect {
    public ThornShieldEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
        // deal dmg back to the attacker during the living hurt event
    }

    @SubscribeEvent
    public static void onHurtEntity(@NotNull LivingHurtEvent event) {
        LivingEntity injured = event.getEntity();
        Entity attacker = event.getSource().getEntity();

        if (!injured.level.isClientSide && attacker != null && attacker.isAttackable()) {
            MobEffectInstance effectInstance = injured.getEffect(TCMobEffects.THORN_SHIELD.get());
            if (effectInstance != null) {
                int amplifier = effectInstance.getAmplifier();
                attacker.hurt(injured.damageSources().thorns(injured), (float) getDamage(amplifier, injured.level.random));
            }
        }
    }

    public static int getDamage(int level, RandomSource random) {
        return level > 10 ? level - 10 : 1 + random.nextInt(4);
    }
}