package com.github.warrentode.todecoins.entity.trades.trade_api;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CustomRegistryHelper {

    public static final RegistryHelper<TradeOfferFactoryType<?>> tradeOfferFactoryTypeRegistryHelper =
            new RegistryHelper<>(() -> TodeCoins.supplier.get());
    @SuppressWarnings("SameReturnValue")
    public static RegistryHelper<TradeOfferFactoryType<?>> getTradeOfferRegistry() {
        return tradeOfferFactoryTypeRegistryHelper;
    }

    public static class RegistryHelper<T> {
        private boolean registered = false;
        private final Supplier<IForgeRegistry<T>> registry;
        private final Map<ResourceLocation, Supplier<? extends T>> entries = new LinkedHashMap<>();

        private RegistryHelper(Supplier<IForgeRegistry<T>> registry) {
            this.registry = registry;
        }

        public Supplier<Codec<T>> getCodec() {
            return () -> this.registry.get().getCodec();
        }

        public void registerAll(@NotNull RegisterEvent event) {
            ResourceKey<Registry<T>> registryKey = this.registry.get().getRegistryKey();
            TodeCoins.LOGGER.info("Getting custom registry keys: {}_{}", event.getRegistryKey(), registryKey.toString());
            if (event.getRegistryKey().equals(registryKey)) {
                registered = true;
                TodeCoins.LOGGER.info("Registered custom registry key: {}", event.getRegistryKey() + "_" + registryKey);
                for (Map.Entry<ResourceLocation, Supplier<? extends T>> supplierEntry : this.entries.entrySet()) {
                    event.register(registryKey, supplierEntry.getKey(), () -> supplierEntry.getValue().get());
                    TodeCoins.LOGGER.info("{}", supplierEntry.getKey().toString());
                }
                this.entries.clear();
            }
        }

        public <V extends T> Supplier<V> register(@NotNull ResourceLocation name, Supplier<V> entry) {
            TodeCoins.LOGGER.info("{}", "register " + name);
            if (registered) {
                this.registry.get().register(name, entry.get());
            }
            else {
                this.entries.put(name, entry);
            }
            //noinspection unchecked
            return () -> (V) this.registry.get().getValue(name);
        }
    }
}