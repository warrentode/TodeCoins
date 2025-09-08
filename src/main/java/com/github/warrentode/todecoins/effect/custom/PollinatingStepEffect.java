package com.github.warrentode.todecoins.effect.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PollinatingStepEffect extends MobEffect {

    public PollinatingStepEffect(MobEffectCategory category, int tintIndex) {
        super(category, tintIndex); // honey-gold potion color
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Trigger twice per second
        return duration % 10 == 0;
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (!(entity instanceof Player player)) return;

        Level level = player.level();
        if (level.isClientSide) return; // server only

        BlockPos pos = player.blockPosition().below();
        BlockState blockState = level.getBlockState(pos);

        if (blockState.getBlock() instanceof BonemealableBlock bonemealableBlock) {
            if (bonemealableBlock.isValidBonemealTarget(level, pos, blockState, false)) {
                if (bonemealableBlock.isBonemealSuccess(level, level.random, pos, blockState)) {
                    bonemealableBlock.performBonemeal((ServerLevel) level, level.random, pos, blockState);

                    // Spawn nectar particles
                    ((ServerLevel) level).sendParticles(
                            ParticleTypes.FALLING_NECTAR,
                            pos.getX() + 0.5,
                            pos.getY() + 1.0,
                            pos.getZ() + 0.5,
                            8,      // count
                            0.3,    // x spread
                            0.1,    // y spread
                            0.3,    // z spread
                            0.01    // speed
                    );

                    // Play bee pollinate sound
                    level.playSound(null, pos, SoundEvents.BEE_POLLINATE, SoundSource.PLAYERS, 0.8F, 1.0F);
                }
            }
        }
    }
}