package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.util.tags.TCEntityTypeTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BossCoinDropsHandler {

    /**
     * Fires whenever a LivingEntity dies and drops items.
     * Spawns additional copies of dropped boss coins for all nearby real players.
     */
    @SubscribeEvent
    public static void onLivingDrops(@NotNull LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();

        // --- Only tagged bosses ---
        if (!entity.getType().is(TCEntityTypeTags.BOSSES)) return;

        // --- Must be server-side ---
        if (!(entity.level instanceof ServerLevel serverLevel)) return;

        // --- Entity must actually be dead ---
        if (!entity.isDeadOrDying()) return;

        // --- Get all nearby non-spectator, non-fake players within 16 blocks ---
        List<Player> nearbyPlayers = serverLevel.getEntitiesOfClass(Player.class,
                entity.getBoundingBox().inflate(16),
                player -> !player.isSpectator() && !(player instanceof FakePlayer));

        // We already have the original drops; we only need extra copies
        int extraCopies = Math.max(0, nearbyPlayers.size() - 1);

        for (int i = 0; i < extraCopies; i++) {
            for (ItemEntity droppedItem : event.getDrops()) {
                // Only copy boss coins (optional: filter further if needed)
                ItemStack spawnStack = droppedItem.getItem().copy();

                ItemEntity extraEntity = entity.spawnAtLocation(spawnStack);
                if (extraEntity != null) {
                    extraEntity.setDefaultPickUpDelay();
                    extraEntity.setExtendedLifetime();
                    extraEntity.setUUID(UUID.randomUUID());
                }
            }
        }
    }
}