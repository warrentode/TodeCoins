package com.github.warrentode.todecoins.integration.curios.network.packets;

import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class UseEquippedCoinPacket {

    public UseEquippedCoinPacket() {
        // No data needed for this packet
    }

    @SuppressWarnings("EmptyMethod")
    public static void encode(UseEquippedCoinPacket ignoredPacket, net.minecraft.network.FriendlyByteBuf ignoredBuffer) {
        // Nothing to encode
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull UseEquippedCoinPacket decode(net.minecraft.network.FriendlyByteBuf ignoredBuffer) {
        //noinspection InstantiationOfUtilityClass
        return new UseEquippedCoinPacket();
    }

    public static void handle(UseEquippedCoinPacket ignoredPacket, @NotNull Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {

                // Get all equipped coins via Curios
                List<ItemStack> equippedCoins = CuriosHelper.getEquippedCoins(player);

                // Call each coin's own use method, which handles effects and sub-effects
                for (ItemStack coinStack : equippedCoins) {
                    if (coinStack.getItem() instanceof CollectibleCoinItem coinItem) {
                        coinItem.useFromCurios(player, coinStack);
                    }
                }
            }
        });
        context.setPacketHandled(true);
    }
}