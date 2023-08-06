package com.github.warrentode.integration;

import net.minecraftforge.fml.ModList;

public class ModListHandler {
    public static boolean curiosLoaded = isModLoaded("curios");
    public static boolean cageriumLoaded = isModLoaded("cagerium");
    public static boolean moonlightLoaded = isModLoaded("moonlight");
    public static boolean supplementariesLoaded = isModLoaded("supplementaries");
    public static boolean sereneseasonsLoaded = isModLoaded("sereneseasons");
    public static boolean bagofholdingLoaded = isModLoaded("bagofholding");
    public static boolean sophisticatedbackpacksLoaded = isModLoaded("sophisticatedbackpacks");

    public static boolean isModLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }
}