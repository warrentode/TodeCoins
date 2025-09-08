package com.github.warrentode.todecoins.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.fml.common.Mod;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class UnhinderedEffect extends MobEffect {
    public UnhinderedEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
        // Effect logic handled by mixins (e.g. cancel stuck in block, berry bush effects)
    }
}