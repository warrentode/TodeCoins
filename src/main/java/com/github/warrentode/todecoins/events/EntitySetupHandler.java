package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.entity.TCEntityTypes;
import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntitySetupHandler {

    /** Register entity attributes (called during mod setup) */
    @SubscribeEvent
    public static void onEntityAttributeEvent(final @NotNull EntityAttributeCreationEvent event) {
        event.put(TCEntityTypes.NUMISMATIST.get(), Mob.createMobAttributes().build());
        event.put(TCEntityTypes.PIGLINMERCHANT.get(), PiglinMerchant.setAttributes());
    }

    /** Initialize entities with trade offer registration and spawn placement */
    public static void initMerchants() {
        // Spawn placements
        //noinspection deprecation
        SpawnPlacements.register(TCEntityTypes.NUMISMATIST.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules);
        //noinspection deprecation
        SpawnPlacements.register(TCEntityTypes.PIGLINMERCHANT.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules);
    }
}