package com.github.warrentode.todecoins.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> USE_MOD_CURRENCY;

    static {
        BUILDER.push("Use the TodeCoins Currency for Vanilla Villager Trades? default: false");

        USE_MOD_CURRENCY = BUILDER.define("use_mod_currency", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static Boolean getCurrency() {
        if (Objects.equals(USE_MOD_CURRENCY.get(), USE_MOD_CURRENCY.getDefault())) {
            return USE_MOD_CURRENCY.getDefault();
        }
        else {
            return USE_MOD_CURRENCY.get();
        }
    }
}
