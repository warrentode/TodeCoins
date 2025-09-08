package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.item.custom.bracelet.FriendshipBraceletItem;
import com.github.warrentode.todecoins.util.PlayerUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BraceletNameHandler {
    /**
     * Registers the name of the crafter onto the Friendship Bracelet for future use.
     * The name of the user (if the bracelet is obtained through other means)
     * is handled within the item’s use method.
     */
    @SubscribeEvent
    public static void onItemCrafted(@NotNull PlayerEvent.ItemCraftedEvent event) {
        ItemStack stack = event.getCrafting();
        Player player = event.getEntity();
        if (stack.getItem() instanceof FriendshipBraceletItem) {
            final CompoundTag itemTag = stack.getOrCreateTag();
            itemTag.putString(PlayerUtil.BRACELET_MAKER_TAG, player.getGameProfile().getName());
        }
    }
}