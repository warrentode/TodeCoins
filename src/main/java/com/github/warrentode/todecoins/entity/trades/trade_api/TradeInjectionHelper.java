package com.github.warrentode.todecoins.entity.trades.trade_api;

import net.minecraft.world.entity.Entity;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class TradeInjectionHelper {

    private static final Set<Entity> alreadyInjected = Collections.newSetFromMap(new WeakHashMap<>());

    public static void clearCache() {
        alreadyInjected.clear();
    }
}