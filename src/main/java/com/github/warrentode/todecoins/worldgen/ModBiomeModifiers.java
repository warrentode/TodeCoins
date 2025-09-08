package com.github.warrentode.todecoins.worldgen;

import com.github.warrentode.todecoins.util.tags.TCBiomeTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

// step 3 of world gen
public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_ENDONIAN_ORE = registerKey("add_endonian_ore");

    public static void bootstrap(@NotNull BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_ENDONIAN_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(TCBiomeTags.HAS_ENDONIAN_ORE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ENDONIAN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    @SuppressWarnings("SameParameterValue")
    private static @NotNull ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.parse(MODID + ":" + name));
    }
}