package com.github.warrentode.todecoins.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

// step 2 of world gen
public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ENDONIAN_ORE_PLACED_KEY = registerKey("endonian_ore_placed");

    public static void bootstrap(@NotNull BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ENDONIAN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENDONIAN_ORE_KEY),
                // the veinSize = number of ore blocks per vein
                ModOrePlacement.commonOrePlacement(5,
                        // the height range here is set to cover roughly the area that generates in vanilla for the end
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(70))));
    }

    @SuppressWarnings("SameParameterValue")
    private static @NotNull ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.parse(MODID + ":" + name));
    }

    @SuppressWarnings("SameParameterValue")
    private static void register(@NotNull BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}