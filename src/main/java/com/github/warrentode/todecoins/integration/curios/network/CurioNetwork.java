package com.github.warrentode.todecoins.integration.curios.network;

import com.github.warrentode.todecoins.integration.curios.network.packets.OpenEquippedWalletPacket;
import com.github.warrentode.todecoins.integration.curios.network.packets.UseEquippedBraceletPacket;
import com.github.warrentode.todecoins.integration.curios.network.packets.UseEquippedCoinPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkDirection;

import java.util.Optional;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class CurioNetwork {

    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            ResourceLocation.parse(MODID + ":curio_channel"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int packetId = 0;

    /** Call this during mod setup to register all Curios packets */
    public static void registerPackets() {
        CHANNEL.registerMessage(
                packetId++,
                UseEquippedCoinPacket.class,
                UseEquippedCoinPacket::encode,
                UseEquippedCoinPacket::decode,
                UseEquippedCoinPacket::handle,
                Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );
        CHANNEL.registerMessage(
                packetId++,
                UseEquippedBraceletPacket.class,
                UseEquippedBraceletPacket::encode,
                UseEquippedBraceletPacket::decode,
                UseEquippedBraceletPacket::handle,
                Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );
        CHANNEL.registerMessage(
                packetId++,
                OpenEquippedWalletPacket.class,
                OpenEquippedWalletPacket::encode,
                OpenEquippedWalletPacket::decode,
                OpenEquippedWalletPacket::handle,
                Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );
    }
}