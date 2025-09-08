package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.entity.TCEntityTypes;
import com.github.warrentode.todecoins.entity.spawners.numismatist.NumismatistSpawner;
import com.github.warrentode.todecoins.entity.spawners.piglinmerchant.PiglinMerchantSpawner;
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
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class CustomSpawnerHandler {
    private static final Map<ResourceLocation, NumismatistSpawner> numismatistSpawner = new HashMap<>();
    private static final Map<ResourceLocation, PiglinMerchantSpawner> piglinMerchantSpawner = new HashMap<>();

    @SubscribeEvent
    public static void onWorldLoad(@NotNull ServerStartingEvent event) {
        MinecraftServer server = event.getServer();

        numismatistSpawner.put(BuiltinDimensionTypes.OVERWORLD.location(), new NumismatistSpawner(server, "Numismatist", TCEntityTypes.NUMISMATIST.get()));
        piglinMerchantSpawner.put(BuiltinDimensionTypes.NETHER.location(), new PiglinMerchantSpawner(server, "PiglinMerchant", TCEntityTypes.PIGLINMERCHANT.get()));
    }

    @SubscribeEvent
    public static void onServerStopped(ServerStoppedEvent event) {
        numismatistSpawner.clear();
        piglinMerchantSpawner.clear();
    }

    @SubscribeEvent
    public static void onWorldTick(@NotNull TickEvent.LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.START) {
            return;
        }

        if (event.side != LogicalSide.SERVER) {
            return;
        }

        NumismatistSpawner numismatistSpawn = numismatistSpawner.get(event.level.dimension().location());
        if (numismatistSpawn != null) {
            numismatistSpawn.tick((ServerLevel) event.level, true, true);
        }

        PiglinMerchantSpawner piglinMerchantSpawn = piglinMerchantSpawner.get(event.level.dimension().location());
        if (piglinMerchantSpawn != null) {
            piglinMerchantSpawn.tick((ServerLevel) event.level, true, true);
        }
    }
}