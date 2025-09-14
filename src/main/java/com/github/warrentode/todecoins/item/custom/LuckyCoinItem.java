package com.github.warrentode.todecoins.item.custom;

import com.github.warrentode.todecoins.integration.curios.CurioCapabilityProvider;
import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.particle.TCParticles;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class LuckyCoinItem extends CurrencyItem {
    public LuckyCoinItem(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        if (!ModList.get().isLoaded("curios")) {
            return null;
        }
        // Delegate to a helper class that only exists if Curios is loaded
        return CurioCapabilityProvider.initCapabilities(stack, nbt);
    }

    @SubscribeEvent
    public static void onLivingDeath(@NotNull LivingDeathEvent event) {
        LivingEntity dyingEntity = event.getEntity();
        Level level = dyingEntity.getCommandSenderWorld();
        if (!level.isClientSide) {
            if (dyingEntity instanceof ServerPlayer player) {
                DamageSource damageSource = player.getLastDamageSource();
                ItemStack luckyCoin = CuriosHelper.getEquippedOrInventoryStack(player, TCItems.LUCKY_COIN.get());

                if (!luckyCoin.isEmpty()) {
                    player.setHealth(1.0F);
                    player.removeAllEffects();
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));

                    // Optional levitation if fell out of world
                    if (damageSource != null && damageSource.is(DamageTypes.FELL_OUT_OF_WORLD)) {
                        player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 3000, 0));
                        // Set flags for server slow-fall
                        player.getPersistentData().putBoolean("LuckyCoinSlowFall", true);
                    }

                    // Smooth spiral particle animation for all nearby clients
                    spawnSpiralParticles((ServerLevel) level, player);

                    luckyCoin.shrink(1);
                    event.setCanceled(true);
                }
            }
        }
    }

    private static void spawnSpiralParticles(ServerLevel serverLevel, @NotNull ServerPlayer player) {
        RandomSource random = RandomSource.create();

        double centerX = player.getX();
        double centerY = player.getY();
        double centerZ = player.getZ();

        // particle settings
        int particleCount = 100;
        double radius = 1.5;
        double height = 2.5;
        int turns = 3;

        for (int i = 0; i < particleCount; i++) {
            double progress = (double) i / particleCount;
            double angle = 2 * Math.PI * turns * progress;

            // random offsets
            double randX = (random.nextDouble() - 0.5) * 0.3;
            double randY = (random.nextDouble() - 0.5) * 0.5;
            double randZ = (random.nextDouble() - 0.5) * 0.3;

            double offsetX = Math.cos(angle) * radius + randX;
            double offsetZ = Math.sin(angle) * radius + randZ;
            double offsetY = height * progress + randY;

            // velocity along spiral
            double velocityX = -Math.sin(angle) * 0.08 + (random.nextDouble() - 0.5) * 0.02;
            double velocityZ =  Math.cos(angle) * 0.08 + (random.nextDouble() - 0.5) * 0.02;
            double velocityY = 0.03 + (random.nextDouble() - 0.5) * 0.01;

            serverLevel.sendParticles(TCParticles.LUCK_PARTICLES.get(),
                    centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                    1, velocityX, velocityY, velocityZ,
                    0.03    // speed (small for subtle movement)
            );

            // intentionally called inside the loop for a layered "resonance" effect
            serverLevel.playSeededSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    SoundEvents.AMETHYST_BLOCK_RESONATE,
                    SoundSource.NEUTRAL,
                    0.2F + random.nextFloat() * 0.2F,
                    0.4F / (serverLevel.getRandom().nextFloat() * 0.4F + 0.8F),
                    serverLevel.random.nextLong()
            );
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(@NotNull TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level level = player.level;

        // --- Server-side: Apply slow-falling after levitation ---
        if (!level.isClientSide && event.player.getPersistentData().getBoolean("LuckyCoinSlowFall")) {
            if (!player.hasEffect(MobEffects.LEVITATION)) {
                player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2000, 0));
                // set flag for slow fall application when levitate wears off
                player.getPersistentData().remove("LuckyCoinSlowFall");
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerDamage(@NotNull LivingHurtEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        DamageSource source = event.getSource();

        // Only intercept void damage
        if (source.is(DamageTypes.FELL_OUT_OF_WORLD)) {
            // Check if the Lucky Coin levitation is active
            if (player.getPersistentData().getBoolean("LuckyCoinSlowFall")) {
                // Cancel the damage while levitating
                event.setCanceled(true);

                double y = player.getY();
                double upwardVelocity = 0.5;

                if (y < -100) {
                    upwardVelocity = 1.5;
                }
                else if (y < 0) {
                    upwardVelocity = 1.0;
                }

                player.setDeltaMovement(player.getDeltaMovement().x,
                        upwardVelocity,
                        player.getDeltaMovement().z);
            }
        }
    }
}