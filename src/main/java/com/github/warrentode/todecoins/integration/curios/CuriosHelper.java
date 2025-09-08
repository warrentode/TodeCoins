package com.github.warrentode.todecoins.integration.curios;

import com.github.warrentode.todecoins.item.custom.bracelet.FriendshipBraceletItem;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinItem;
import com.github.warrentode.todecoins.item.custom.wallet.WalletItem;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CuriosHelper {
    // checks if a player has an item equipped in a curio slot
    public static boolean hasCurioItemEquipped(Player player, Item... items) {
        if (!ModList.get().isLoaded("curios")) return false;

        return CuriosApi.getCuriosInventory(player)
                .map(itemHandler -> {
                    for (Item item : items) {
                        if (itemHandler.isEquipped(item)) return true;
                    }
                    return false;
                })
                .orElse(false);
    }

    // checks for an Item from a curio slot first, if not present it checks player inventory
    public static ItemStack getEquippedOrInventoryStack(Player player, Item... items) {
        if (player == null) return ItemStack.EMPTY;

        AtomicReference<ItemStack> foundStack = new AtomicReference<>();

        // First check Curios slots
        if (ModList.get().isLoaded("curios")) {
            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
                IItemHandlerModifiable equipped = handler.getEquippedCurios();
                for (int i = 0; i < equipped.getSlots(); i++) {
                    ItemStack stack = equipped.getStackInSlot(i);
                    for (Item item : items) {
                        if (stack.getItem() == item) {
                            foundStack.set(stack);
                            return;
                        }
                    }
                }
            });
        }

        // Fallback to inventory if not found in Curios
        if (foundStack.get() == null) {
            Inventory inv = player.getInventory();
            for (int i = 0; i < inv.getContainerSize(); i++) {
                ItemStack stack = inv.getItem(i);
                for (Item item : items) {
                    if (stack.getItem() == item) {
                        foundStack.set(stack);
                        break;
                    }
                }
                if (foundStack.get() != null) break;
            }
        }

        return foundStack.get() != null ? foundStack.get() : ItemStack.EMPTY;
    }

    // Returns a list of all equipped coin ItemStacks in Curios slots
    public static @NotNull List<ItemStack> getEquippedCoins(Player player) {
        List<ItemStack> coins = new ArrayList<>();
        if (player == null || !ModList.get().isLoaded("curios")) return coins;

        CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
            IItemHandlerModifiable curiosHandler = handler.getEquippedCurios();
            for (int i = 0; i < curiosHandler.getSlots(); i++) {
                ItemStack stack = curiosHandler.getStackInSlot(i);
                if (!stack.isEmpty() && stack.getItem() instanceof CollectibleCoinItem) {
                    coins.add(stack);
                }
            }
        });

        return coins;
    }

    // Returns a list of all equipped bracelet ItemStacks in Curios slots
    public static @NotNull List<ItemStack> getEquippedBracelets(Player player) {
        List<ItemStack> bracelets = new ArrayList<>();
        if (player == null || !ModList.get().isLoaded("curios")) return bracelets;

        CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
            IItemHandlerModifiable curiosHandler = handler.getEquippedCurios();
            for (int i = 0; i < curiosHandler.getSlots(); i++) {
                ItemStack stack = curiosHandler.getStackInSlot(i);
                if (!stack.isEmpty() && stack.getItem() instanceof FriendshipBraceletItem) {
                    bracelets.add(stack);
                }
            }
        });

        return bracelets;
    }

    // Returns a list of all equipped wallet ItemStacks in Curios slots
    public static @NotNull List<ItemStack> getEquippedWallets(Player player) {
        List<ItemStack> wallets = new ArrayList<>();
        if (player == null || !ModList.get().isLoaded("curios")) return wallets;

        CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
            IItemHandlerModifiable curiosHandler = handler.getEquippedCurios();
            for (int i = 0; i < curiosHandler.getSlots(); i++) {
                ItemStack stack = curiosHandler.getStackInSlot(i);
                if (!stack.isEmpty() && stack.getItem() instanceof WalletItem) {
                    wallets.add(stack);
                }
            }
        });

        return wallets;
    }
}