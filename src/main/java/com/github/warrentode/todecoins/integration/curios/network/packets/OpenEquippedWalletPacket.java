package com.github.warrentode.todecoins.integration.curios.network.packets;

import com.github.warrentode.todecoins.integration.curios.CuriosHelper;
import com.github.warrentode.todecoins.item.custom.wallet.WalletItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class OpenEquippedWalletPacket {

    public OpenEquippedWalletPacket() {
        // No data needed for this packet
    }

    @SuppressWarnings("EmptyMethod")
    public static void encode(OpenEquippedWalletPacket ignoredPacket, net.minecraft.network.FriendlyByteBuf ignoredBuffer) {
        // Nothing to encode
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull OpenEquippedWalletPacket decode(net.minecraft.network.FriendlyByteBuf ignoredBuffer) {
        //noinspection InstantiationOfUtilityClass
        return new OpenEquippedWalletPacket();
    }

    public static void handle(OpenEquippedWalletPacket ignoredPacket, @NotNull Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {

                // Get all equipped wallets via Curios
                @NotNull List<ItemStack> equippedWallets = CuriosHelper.getEquippedWallets(player);

                // Only use the first equipped wallet, if any
                if (!equippedWallets.isEmpty()) {
                    ItemStack firstWalletStack = equippedWallets.get(0);
                    if (firstWalletStack.getItem() instanceof WalletItem walletItem) {
                        walletItem.useFromCurios(player, firstWalletStack);
                    }
                }
            }
        });
        context.setPacketHandled(true);
    }
}