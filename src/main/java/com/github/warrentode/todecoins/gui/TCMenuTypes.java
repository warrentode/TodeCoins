package com.github.warrentode.todecoins.gui;

import com.github.warrentode.todecoins.gui.coinalbum.CoinAlbumMenu;
import com.github.warrentode.todecoins.gui.coinpressgui.CoinPressMenu;
import com.github.warrentode.todecoins.gui.walletgui.WalletMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TCMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);

    public static final RegistryObject<MenuType<CoinPressMenu>> COIN_PRESS_MENU =
            registerMenuType(CoinPressMenu::new, "coin_press_menu");

    public static final RegistryObject<MenuType<WalletMenu>> WALLET_MENU =
            MENUS.register("wallet_menu", () -> IForgeMenuType.create((id, inv, buf) ->
                            new WalletMenu(id, inv, buf.readItem())));

    public static final RegistryObject<MenuType<CoinAlbumMenu>> COIN_ALBUM_MENU =
            MENUS.register("coin_album_menu", () -> IForgeMenuType.create((id, inv, buf) ->
                    new CoinAlbumMenu(id, inv, buf.readItem())));

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, @SuppressWarnings("SameParameterValue") String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}