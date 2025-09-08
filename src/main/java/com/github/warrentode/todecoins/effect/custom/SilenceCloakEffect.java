package com.github.warrentode.todecoins.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class SilenceCloakEffect extends MobEffect {
    public SilenceCloakEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex);
        // silences the entity under this effect with mixins
    }
}