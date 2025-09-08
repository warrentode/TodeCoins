package com.github.warrentode.todecoins.item.custom.collectible;

import com.github.warrentode.todecoins.datagen.translations.TooltipTranslations;
import com.github.warrentode.todecoins.util.seasonal.SeasonalParticleColors;
import com.github.warrentode.todecoins.util.seasonal.SeasonalSounds;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;

import static com.github.warrentode.todecoins.util.seasonal.CalendarUtil.*;

public abstract class CollectibleCoinItem extends Item {
    private final CollectibleCoinMaterial material;
    private final CollectibleCoinSetDefinitions coinSet;

    public CollectibleCoinItem(@NotNull CollectibleCoinMaterial material, @NotNull CollectibleCoinSetDefinitions coinSet, @NotNull Item.Properties properties) {
        super(properties.durability(material.getMaxDurability()));
        this.material = material;
        this.coinSet = coinSet;
    }

    public CollectibleCoinMaterial getMaterial() {
        return material;
    }

    public CollectibleCoinSetDefinitions getCoinSet() {
        return coinSet;
    }

    // call on server side
    public static void serverSeasonalSoundParticles(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer player, ItemStack coin) {
        // set seasonal sounds on item use
        List<SoundEvent> soundsToPlay = SeasonalSounds.getSeasonalSounds(3);

        // play sound set for holidays for the matching coin
        if (isAnniversary && coin.is(TCItemTags.ANNIVERSARY_COINS_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                serverLevel.playSeededSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        sound, SoundSource.NEUTRAL,
                        0.2F + serverLevel.random.nextFloat() * 0.2F,
                        0.4F / (serverLevel.random.nextFloat() * 0.4F + 0.8F),
                        serverLevel.random.nextLong()
                );
            }
        }
        else if (isBirthday && coin.is(TCItemTags.BIRTHDAY_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                serverLevel.playSeededSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        sound, SoundSource.NEUTRAL,
                        0.2F + player.level.random.nextFloat() * 0.2F,
                        0.4F / (serverLevel.random.nextFloat() * 0.4F + 0.8F),
                        serverLevel.random.nextLong()
                );
            }
        }
        else if (isHalloween && coin.is(TCItemTags.HALLOWEEN_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                serverLevel.playSeededSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        sound, SoundSource.NEUTRAL,
                        0.2F + player.level.random.nextFloat() * 0.2F,
                        0.4F / (serverLevel.random.nextFloat() * 0.4F + 0.8F),
                        serverLevel.random.nextLong()
                );
            }
        }
        else if (isChristmas && coin.is(TCItemTags.CHRISTMAS_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                serverLevel.playSeededSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        sound, SoundSource.NEUTRAL,
                        0.2F + player.level.random.nextFloat() * 0.2F,
                        0.4F / (serverLevel.random.nextFloat() * 0.4F + 0.8F),
                        serverLevel.random.nextLong()
                );
            }
        }
        else if (isEaster && coin.is(TCItemTags.EASTER_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                serverLevel.playSeededSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        sound, SoundSource.NEUTRAL,
                        0.2F + player.level.random.nextFloat() * 0.2F,
                        0.4F / (serverLevel.random.nextFloat() * 0.4F + 0.8F),
                        serverLevel.random.nextLong()
                );
            }
        }
        else if (isNewYear && coin.is(TCItemTags.NEW_YEAR_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                serverLevel.playSeededSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        sound, SoundSource.NEUTRAL,
                        0.2F + player.level.random.nextFloat() * 0.2F,
                        0.4F / (serverLevel.random.nextFloat() * 0.4F + 0.8F),
                        serverLevel.random.nextLong()
                );
            }
        }
        else {
            // play default coin use sound
            serverLevel.playSeededSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.NEUTRAL,
                    0.2F + player.level.random.nextFloat() * 0.2F,
                    0.4F / (serverLevel.random.nextFloat() * 0.4F + 0.8F),
                    serverLevel.random.nextLong()
            );
        }

        // particle effects for server side
        double centerX = player.getEyePosition().x();
        double centerY = player.getEyePosition().y();
        double centerZ = player.getEyePosition().z();

        int particleCount = 100;
        double radius = 1.5;
        float scale = 0.1f + serverLevel.random.nextFloat() * 0.9f; // random particle size between 0.1 and 1.0

        // set seasonl colors on item use
        Vector3f primaryColor = SeasonalParticleColors.getPrimarySeasonalParticleColor();
        Vector3f secondaryColor = SeasonalParticleColors.getSecondarySeasonalParticleColor();

        // spawn particles set for holidays for the matching case
        for (int i = 0; i < particleCount; i++) {
            double angle = 2 * Math.PI * i / particleCount;
            double offsetX = Math.cos(angle) * radius;
            double offsetZ = Math.sin(angle) * radius;
            double offsetY = (serverLevel.random.nextDouble() - 0.5) * 0.5; // small random vertical offset

            // holiday particles for matching coin
            if (isBirthday && coin.is(TCItemTags.BIRTHDAY_COIN_TAG)) {
                serverLevel.sendParticles(new DustParticleOptions(primaryColor, scale),
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
                serverLevel.sendParticles(new DustParticleOptions(secondaryColor, scale),
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
            }
            else if (isNewYear && coin.is(TCItemTags.NEW_YEAR_COIN_TAG)) {
                serverLevel.sendParticles(new DustParticleOptions(primaryColor, scale),
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
                serverLevel.sendParticles(new DustParticleOptions(secondaryColor, scale),
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
            }
            else if (isHalloween && coin.is(TCItemTags.HALLOWEEN_COIN_TAG)) {
                serverLevel.sendParticles(ParticleTypes.WITCH,
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
                serverLevel.sendParticles(new DustParticleOptions(primaryColor, scale),
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
                serverLevel.sendParticles(new DustParticleOptions(secondaryColor, scale),
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
            }
            else if (isChristmas && coin.is(TCItemTags.CHRISTMAS_COIN_TAG)) {
                serverLevel.sendParticles(ParticleTypes.SNOWFLAKE,
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
                serverLevel.sendParticles(new DustParticleOptions(primaryColor, scale),
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
                serverLevel.sendParticles(new DustParticleOptions(secondaryColor, scale),
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
            }
            else if (isEaster && coin.is(TCItemTags.EASTER_COIN_TAG)) {
                serverLevel.sendParticles(ParticleTypes.CHERRY_LEAVES,
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
                serverLevel.sendParticles(ParticleTypes.SPORE_BLOSSOM_AIR,
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
            }
            else if (isAnniversary && coin.is(TCItemTags.ANNIVERSARY_COINS_TAG)) {
                serverLevel.sendParticles(ParticleTypes.CRIMSON_SPORE,
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
                serverLevel.sendParticles(ParticleTypes.HEART,
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
            }
            // default particles for all celebration coins
            else {
                serverLevel.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                        centerX + offsetX, centerY + offsetY, centerZ + offsetZ,
                        1, 0, 0, 0, 0
                );
            }
        }
    }

    // call on client side
    public static void clientSeasonSoundParticles(@NotNull Player player, @NotNull Level level, ItemStack coin) {
        // set seasonal sounds on item use
        List<SoundEvent> soundsToPlay = SeasonalSounds.getSeasonalSounds(3);

        // play sound set for holidays for the matching coin
        if (isAnniversary && coin.is(TCItemTags.ANNIVERSARY_COINS_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                player.level.playSound(player, player.getX(), player.getY(), player.getZ(), sound, SoundSource.NEUTRAL, 0.5F, 1.0F);
            }
        }
        else if (isBirthday && coin.is(TCItemTags.BIRTHDAY_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                player.level.playSound(player, player.getX(), player.getY(), player.getZ(), sound, SoundSource.NEUTRAL, 0.5F, 1.0F);
            }
        }
        else if (isHalloween && coin.is(TCItemTags.HALLOWEEN_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                player.level.playSound(player, player.getX(), player.getY(), player.getZ(), sound, SoundSource.NEUTRAL, 0.5F, 1.0F);
            }
        }
        else if (isChristmas && coin.is(TCItemTags.CHRISTMAS_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                player.level.playSound(player, player.getX(), player.getY(), player.getZ(), sound, SoundSource.NEUTRAL, 0.5F, 0.4F / (player.level.getRandom().nextFloat() * 0.4F + 0.8F));
            }
        }
        else if (isEaster && coin.is(TCItemTags.EASTER_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                player.level.playSound(player, player.getX(), player.getY(), player.getZ(), sound, SoundSource.NEUTRAL, 0.5F, 1.0F);
            }
        }
        else if (isNewYear && coin.is(TCItemTags.NEW_YEAR_COIN_TAG)) {
            for (SoundEvent sound : soundsToPlay) {
                player.level.playSound(player, player.getX(), player.getY(), player.getZ(), sound, SoundSource.NEUTRAL, 0.5F, 1.0F);
            }
        }
        else {
            // play default coin use sound
            player.level.playSound(player, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.NEUTRAL, 0.5F, 0.4F / (player.level.getRandom().nextFloat() * 0.4F + 0.8F));
        }

        // particle effects for client side
        double centerX = player.getEyePosition().x();
        double centerY = player.getEyePosition().y();
        double centerZ = player.getEyePosition().z();

        int particleCount = 100;
        double radius = 1.5;
        float scale = 0.1f + level.random.nextFloat() * 0.9f; // random particle size between 0.1 and 1.0

        // set seasonl colors on item use
        Vector3f primaryColor = SeasonalParticleColors.getPrimarySeasonalParticleColor();
        Vector3f secondaryColor = SeasonalParticleColors.getSecondarySeasonalParticleColor();

        for (int i = 0; i < particleCount; i++) {
            double angle = 2 * Math.PI * i / particleCount;
            double offsetX = Math.cos(angle) * radius;
            double offsetZ = Math.sin(angle) * radius;
            double offsetY = (level.random.nextDouble() - 0.5) * 0.5; // small random vertical offset

            // holiday particles for matching coin
            if (isBirthday && coin.is(TCItemTags.BIRTHDAY_COIN_TAG)) {
                level.addParticle(new DustParticleOptions(primaryColor, scale),
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
                level.addParticle(new DustParticleOptions(secondaryColor, scale),
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
            }
            else if (isNewYear && coin.is(TCItemTags.NEW_YEAR_COIN_TAG)) {
                level.addParticle(new DustParticleOptions(primaryColor, scale),
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
                level.addParticle(new DustParticleOptions(secondaryColor, scale),
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
            }
            else if (isHalloween && coin.is(TCItemTags.HALLOWEEN_COIN_TAG)) {
                level.addParticle(ParticleTypes.WITCH,
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
                level.addParticle(new DustParticleOptions(primaryColor, scale),
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
                level.addParticle(new DustParticleOptions(secondaryColor, scale),
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
            }
            else if (isChristmas && coin.is(TCItemTags.CHRISTMAS_COIN_TAG)) {
                level.addParticle(ParticleTypes.SNOWFLAKE,
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
                level.addParticle(new DustParticleOptions(primaryColor, scale),
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
                level.addParticle(new DustParticleOptions(secondaryColor, scale),
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
            }
            else if (isEaster && coin.is(TCItemTags.EASTER_COIN_TAG)) {
                level.addParticle(ParticleTypes.CHERRY_LEAVES,
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
                level.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR,
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
            }
            else if (isAnniversary && coin.is(TCItemTags.ANNIVERSARY_COINS_TAG)) {
                level.addParticle(ParticleTypes.HEART,
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
                level.addParticle(ParticleTypes.CRIMSON_SPORE,
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
            }
            // default particles for all celebration coins
            else {
                level.addParticle(ParticleTypes.HAPPY_VILLAGER,
                        centerX + offsetX,
                        centerY + offsetY,
                        centerZ + offsetZ,
                        0, 0, 0);
            }
        }
    }

    // **abstract method** for subclasses to implement
    public abstract void useFromCurios(Player player, ItemStack stack);

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + "collectible_coin").withStyle(ChatFormatting.DARK_GRAY).withStyle(ChatFormatting.ITALIC));
        }
        else {
            tooltips.add(Component.translatable(TooltipTranslations.tooltipPrefix + "shift.hover").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
        super.appendHoverText(stack, level, tooltips, flag);
    }
}