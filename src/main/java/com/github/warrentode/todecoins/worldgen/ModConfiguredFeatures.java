package com.github.warrentode.todecoins.worldgen;

import com.github.warrentode.todecoins.block.TCBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

// configured feature -> placed feature -> biome modifier (so we start here)
public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDONIAN_ORE_KEY = registerKey("endonian_ore");

    // yes, that typo "Bootstap" is the real spelling for it in this version for some reason
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        register(context, ENDONIAN_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                TCBlocks.ENDONIAN_ORE.get().defaultBlockState(), 9));
    }

    public static @NotNull ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.parse(MODID + ":" + name));
    }

    @SuppressWarnings("SameParameterValue")
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(@NotNull BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}