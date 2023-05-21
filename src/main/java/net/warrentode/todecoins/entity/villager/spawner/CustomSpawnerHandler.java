package net.warrentode.todecoins.entity.villager.spawner;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todecoins.entity.ModEntityTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static net.warrentode.todecoins.TodeCoins.MODID;

// AUTHOR: MrCrayfish https://github.com/MrCrayfish/GoblinTraders/tree/1.19.X
@Mod.EventBusSubscriber(modid = MODID)
public class CustomSpawnerHandler {
    private static Map<ResourceLocation, NumismatistSpawner> numismatistSpawner = new HashMap<>();

    @SubscribeEvent
    public static void onWorldLoad(@NotNull ServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        numismatistSpawner.put(BuiltinDimensionTypes.OVERWORLD.location(), new NumismatistSpawner(server, "Numismatist", ModEntityTypes.NUMISMATIST.get()));
    }

    @SubscribeEvent
    public static void onServerStart(ServerStoppedEvent event) {
        numismatistSpawner.clear();
    }

    @SubscribeEvent
    public static void onWorldTick(TickEvent.@NotNull LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.START) {
            return;
        }

        if (event.side != LogicalSide.SERVER) {
            return;
        }

        NumismatistSpawner spawner = numismatistSpawner.get(event.level.dimension().location());
        if (spawner != null) {
            spawner.tick((ServerLevel) event.level, true, true);
        }
    }
}