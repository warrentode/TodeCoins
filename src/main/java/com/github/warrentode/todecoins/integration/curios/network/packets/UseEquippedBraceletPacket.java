package com.github.warrentode.todecoins.integration.curios.network.packets;

import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.custom.bracelet.FriendshipBraceletItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class UseEquippedBraceletPacket {

    public UseEquippedBraceletPacket() {
        // No data needed for this packet
    }

    @SuppressWarnings("EmptyMethod")
    public static void encode(UseEquippedBraceletPacket ignoredPacket, net.minecraft.network.FriendlyByteBuf ignoredBuffer) {
        // Nothing to encode
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull UseEquippedBraceletPacket decode(net.minecraft.network.FriendlyByteBuf ignoredBuffer) {
        //noinspection InstantiationOfUtilityClass
        return new UseEquippedBraceletPacket();
    }

    public static void handle(UseEquippedBraceletPacket ignoredPacket, @NotNull Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {

                // Get all equipped bracelets via Curios
                List<ItemStack> equippedBracelets = CuriosHelper.getEquippedBracelets(player);

                // Only use the first equipped bracelet, if any
                if (!equippedBracelets.isEmpty()) {
                    ItemStack firstBraceletStack = equippedBracelets.get(0);
                    if (firstBraceletStack.getItem() instanceof FriendshipBraceletItem braceletItem) {
                        braceletItem.useFromCurios(player, firstBraceletStack);
                    }
                }
            }
        });
        context.setPacketHandled(true);
    }
}