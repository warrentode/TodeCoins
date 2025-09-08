package com.github.warrentode.todecoins.effect.custom;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class ThunderstrikeEffect extends MobEffect {
    public ThunderstrikeEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
        // summons a thunderbolt upon the attacked target in the living attack event
    }

    @SubscribeEvent
    public static void onAttackEntity(@NotNull AttackEntityEvent event) {
        LivingEntity attacker = event.getEntity();
        Entity target = event.getTarget();

        if (!attacker.level.isClientSide && target instanceof LivingEntity livingTarget) {
            MobEffectInstance effectInstance = attacker.getEffect(TCMobEffects.THUNDERSTRIKE.get());
            if (effectInstance != null) {
                // chance increases with effect strength
                double chance = 0.1 + 0.15 * (effectInstance.getAmplifier() + 1);

                if (attacker.level.random.nextDouble() < chance) {
                    LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(attacker.level);
                    if (lightningBolt != null) {
                        lightningBolt.moveTo(Vec3.atBottomCenterOf(livingTarget.getOnPos()));
                        attacker.level.addFreshEntity(lightningBolt);
                    }
                }
            }
        }
    }
}