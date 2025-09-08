package com.github.warrentode.todecoins.mixin.silence;

import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(ClientLevel.class)
public class SilenceClientLevelMixin {
    @Unique
    private boolean todeCoins$checkSoundWhiteList(@NotNull String soundId) {
        // Cancel other general interaction sounds regardless of entity type
        return soundId.contains("attack")
                || soundId.contains("hurt")
                || soundId.contains("death")
                || soundId.contains("eat")
                || soundId.contains("drink")
                || soundId.contains("burp")
                || soundId.contains("step")
                || soundId.contains("break")
                || soundId.contains("place")
                || soundId.contains("close")
                || soundId.contains("open")
                || soundId.contains("lever")
                || soundId.contains("button")
                || soundId.contains("big_fall")
                || soundId.contains("small_fall")
                || soundId.contains("splash")
                || soundId.contains("swim")
                || soundId.contains("brushing");
    }

    @Inject(
            method = "playSeededSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/core/Holder;Lnet/minecraft/sounds/SoundSource;FFJ)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void todeCoins$onPlaySeededSoundAtEntity(@Nullable Player player, Entity entity, Holder<SoundEvent> soundHolder, SoundSource source, float volume, float pitch, long seed, CallbackInfo ci) {
        boolean coinEquipped = false;

        if (ModList.get().isLoaded("curios") && entity instanceof Player playerEntity) {
            coinEquipped = CuriosHelper.hasCurioItemEquipped(playerEntity,
                    TCItems.COLLECTIBLE_COIN_WARDEN_COPPER.get(),
                    TCItems.COLLECTIBLE_COIN_WARDEN_IRON.get(),
                    TCItems.COLLECTIBLE_COIN_WARDEN_GOLD.get(),
                    TCItems.COLLECTIBLE_COIN_WARDEN_NETHERITE.get()
            );
        }

        if (entity instanceof LivingEntity living && (living.hasEffect(TCMobEffects.SILENCE_CLOAK.get()) || coinEquipped)) {
            String soundId = soundHolder.value().getLocation().toString();

            if (living instanceof Player) {
                if (soundId.contains("player") || todeCoins$checkSoundWhiteList(soundId)) {
                    ci.cancel();
                }
            }
            else {
                String entityName = Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(living.getType())).getPath();
                if (soundId.contains(entityName) || todeCoins$checkSoundWhiteList(soundId)) {
                    ci.cancel();
                }
            }
        }
    }
}