package net.warrentode.todecoins.loot;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModLootContextParamSets extends LootContextParamSets {
    private static final BiMap<ResourceLocation, LootContextParamSet> REGISTRY = HashBiMap.create();

    public static final LootContextParamSet CURRENCY = register(MODID + ":" + "currency", (builder) ->
            builder.required(LootContextParams.THIS_ENTITY)
                    .required(LootContextParams.ORIGIN)
                    .required(LootContextParams.DAMAGE_SOURCE)
                    .optional(LootContextParams.KILLER_ENTITY)
                    .optional(LootContextParams.DIRECT_KILLER_ENTITY)
                    .optional(LootContextParams.LAST_DAMAGE_PLAYER)
    );
    public static final LootContextParamSet NETHER_GOLD_COIN_BARTER = register(MODID + ":" + "nether_gold_coin_barter", (builder) ->
            builder.required(LootContextParams.THIS_ENTITY));

    private static LootContextParamSet register(String registryName, Consumer<LootContextParamSet.Builder> builderConsumer) {
        LootContextParamSet.Builder lootContextParamSet$builder = new LootContextParamSet.Builder();
        builderConsumer.accept(lootContextParamSet$builder);
        LootContextParamSet lootContextParamSet = lootContextParamSet$builder.build();
        ResourceLocation resourceLocation = new ResourceLocation(registryName);
        LootContextParamSet lootContextParamSet1 = REGISTRY.put(resourceLocation, lootContextParamSet);
        if (lootContextParamSet1 != null) {
            throw new IllegalStateException("Loot table parameter set " + resourceLocation + " is already registered");
        }
        else {
            return lootContextParamSet;
        }
    }

    @Nullable
    public static LootContextParamSet get(@NotNull ResourceLocation registryName) {
        return REGISTRY.get(registryName);
    }

    @Nullable
    public static ResourceLocation getKey(@NotNull LootContextParamSet parameterSet) {
        return REGISTRY.inverse().get(parameterSet);
    }
}