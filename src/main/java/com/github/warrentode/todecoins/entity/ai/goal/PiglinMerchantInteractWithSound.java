package com.github.warrentode.todecoins.entity.ai.goal;

import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;

import java.util.EnumSet;

public class PiglinMerchantInteractWithSound extends LookAtPlayerGoal {
    @SuppressWarnings("unused")
    private final PiglinMerchant merchant;
    private final SoundEvent soundEvent;
    @SuppressWarnings("unused")
    public PiglinMerchantInteractWithSound(PiglinMerchant merchant, Class<? extends LivingEntity> aClass, float probability, SoundEvent soundEvent) {
        super(merchant, aClass, probability);
        this.merchant = merchant;
        this.soundEvent = soundEvent;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    public PiglinMerchantInteractWithSound(PiglinMerchant merchant, Class<? extends LivingEntity> aClass, float lookDistance, float lookTime, SoundEvent soundEvent) {
        super(merchant, aClass, lookDistance, lookTime);
        this.merchant = merchant;
        this.soundEvent = soundEvent;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    public boolean canUse() {
        if (this.lookAt instanceof Player player) {
            if (player.getOffhandItem().is(TCItemTags.PIGLIN_LOVED) || player.getMainHandItem().is(ItemTags.PIGLIN_LOVED)) {
                if (RandomSource.create().nextFloat() < 0.0125) {
                    this.mob.playSound(soundEvent, 0.15F, RandomSource.create().nextFloat());
                }
            }
            return true;
        }
        return false;
    }
}