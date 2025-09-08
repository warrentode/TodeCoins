package com.github.warrentode.todecoins.integration.curios.network;

import com.github.warrentode.todecoins.events.KeyMapHandler;
import com.github.warrentode.todecoins.integration.curios.network.packets.OpenEquippedWalletPacket;
import com.github.warrentode.todecoins.integration.curios.network.packets.UseEquippedBraceletPacket;
import com.github.warrentode.todecoins.integration.curios.network.packets.UseEquippedCoinPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CurioKeyHandler {

    // Track key state to debounce
    private static boolean coinKeyWasPressed = false;
    private static boolean braceletKeyWasPressed = false;
    private static boolean walletKeyWasPressed = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.@NotNull ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        // run ONLY if curios is loaded
        if (ModList.get().isLoaded("curios")) {
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer player = minecraft.player;
            if (player == null) return;

            boolean coinKeyPressed = KeyMapHandler.useCurioCoinKey.isDown();
            boolean braceletKeyPressed = KeyMapHandler.useCurioBraceletKey.isDown();
            boolean walletKeyPressed = KeyMapHandler.openCurioWalletKey.isDown();

            // Only trigger when key was just pressed
            if (coinKeyPressed && !coinKeyWasPressed) {
                coinKeyWasPressed = true;
                // send a single packet to the server
                //noinspection InstantiationOfUtilityClass
                CurioNetwork.CHANNEL.sendToServer(new UseEquippedCoinPacket());
            }
            if (braceletKeyPressed && !braceletKeyWasPressed) {
                braceletKeyWasPressed = true;
                // send a single packet to the server
                //noinspection InstantiationOfUtilityClass
                CurioNetwork.CHANNEL.sendToServer(new UseEquippedBraceletPacket());
            }
            if (walletKeyPressed && !walletKeyWasPressed) {
                walletKeyWasPressed = true;
                // send a single packet to the server
                //noinspection InstantiationOfUtilityClass
                CurioNetwork.CHANNEL.sendToServer(new OpenEquippedWalletPacket());
            }

            // Reset when key is released
            if (!coinKeyPressed && coinKeyWasPressed) {
                coinKeyWasPressed = false;
            }
            if (!braceletKeyPressed && braceletKeyWasPressed) {
                braceletKeyWasPressed = false;
            }
            if (!walletKeyPressed && walletKeyWasPressed) {
                walletKeyWasPressed = false;
            }
        }
    }
}