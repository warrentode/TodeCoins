package com.github.warrentode.todecoins.datagen.trades;

import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class JsonTradesBuilder {
    private final Map<ResourceLocation, Map<Integer, List<VillagerTrades.ItemListing>>> tradeMap = new LinkedHashMap<>();

    @Contract(" -> new")
    public static @NotNull JsonTradesBuilder create() {
        return new JsonTradesBuilder();
    }

    public JsonTradesBuilder add(@NotNull ResourceLocation professionId, int level, @NotNull SerializableTradeOfferFactory... trades) {
        tradeMap.computeIfAbsent(professionId, k -> new TreeMap<>())
                .computeIfAbsent(level, k -> new ArrayList<>())
                .addAll(Arrays.asList(trades));
        return this;
    }

    public JsonTradesBuilder add(@NotNull ResourceLocation professionId, @NotNull Map<Integer, List<SerializableTradeOfferFactory>> levelMap) {
        levelMap.forEach((level, trades) -> this.add(professionId, level, trades.toArray(new SerializableTradeOfferFactory[0])));
        return this;
    }

    public Map<ResourceLocation, Map<Integer, List<VillagerTrades.ItemListing>>> build() {
        return tradeMap;
    }
}