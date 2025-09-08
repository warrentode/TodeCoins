package com.github.warrentode.todecoins.events;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyMapHandler {

    public static KeyMapping useCurioCoinKey;
    public static KeyMapping useCurioBraceletKey;
    public static KeyMapping openCurioWalletKey;

    @SubscribeEvent
    public static void registerKeys(@NotNull RegisterKeyMappingsEvent event) {
        if (ModList.get().isLoaded("curios")) {
            useCurioCoinKey = new KeyMapping(
                    "key.todecoins.use_coin",
                    KeyConflictContext.IN_GAME,
                    KeyModifier.CONTROL,
                    InputConstants.Type.KEYSYM,
                    InputConstants.KEY_C,
                    "key.categories.todecoins"
            );
            event.register(useCurioCoinKey);

            useCurioBraceletKey = new KeyMapping(
                    "key.todecoins.use_bracelet",
                    KeyConflictContext.IN_GAME,
                    KeyModifier.ALT,
                    InputConstants.Type.KEYSYM,
                    InputConstants.KEY_B,
                    "key.categories.todecoins"
            );
            event.register(useCurioBraceletKey);

            openCurioWalletKey = new KeyMapping(
                    "key.todecoins.open_wallet",
                    KeyConflictContext.IN_GAME,
                    KeyModifier.CONTROL,
                    InputConstants.Type.KEYSYM,
                    InputConstants.KEY_Z,
                    "key.categories.todecoins"
            );
            event.register(openCurioWalletKey);
        }
    }
}