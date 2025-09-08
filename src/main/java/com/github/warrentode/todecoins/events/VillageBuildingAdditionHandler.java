package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.Config;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

/** used the chef's delight VillageAdditions class as a template for this one */

@Mod.EventBusSubscriber(modid = MODID)
public class VillageBuildingAdditionHandler {
    private static final ResourceKey<StructureProcessorList> EMPTY_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.parse("minecraft:empty"));
    private static final ResourceKey<StructureProcessorList> ZOMBIE_PLAINS_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.parse("minecraft:zombie_plains"));
    private static final ResourceKey<StructureProcessorList> ZOMBIE_DESERT_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.parse("minecraft:zombie_desert"));
    private static final ResourceKey<StructureProcessorList> ZOMBIE_SAVANNA_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.parse("minecraft:zombie_savanna"));
    private static final ResourceKey<StructureProcessorList> ZOMBIE_SNOWY_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.parse("minecraft:zombie_snowy"));
    private static final ResourceKey<StructureProcessorList> ZOMBIE_TAIGA_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.parse("minecraft:zombie_taiga"));

    VillageBuildingAdditionHandler() {}

    private static void addBuildingToPool(@NotNull Registry<StructureTemplatePool> templatePoolRegistry, @NotNull Registry<StructureProcessorList> processorListRegistry, @NotNull ResourceKey<StructureProcessorList> processorKey, ResourceLocation templatePoolLocation, String pieceLocation, int spawnWeight) {
        Holder<StructureProcessorList> processorList = processorListRegistry.getHolderOrThrow(processorKey);
        StructureTemplatePool pool = templatePoolRegistry.get(templatePoolLocation);
        if (pool == null) return;

        SinglePoolElement piece = SinglePoolElement.legacy(pieceLocation, processorList)
                .apply(StructureTemplatePool.Projection.RIGID);

        // Check if the pool already contains a piece with the same toString() representation
        boolean alreadyAdded = pool.templates.stream().anyMatch(poolElement -> poolElement.toString().equals(piece.toString()));
        if (alreadyAdded) return;

        for (int i = 0; i < spawnWeight; ++i) {
            pool.templates.add(piece);
        }

        boolean inRawTemplates = pool.rawTemplates.stream().anyMatch(entry -> entry.getFirst().toString().equals(piece.toString()));
        if (!inRawTemplates) {
            List<Pair<StructurePoolElement, Integer>> updatedRawTemplates = new ArrayList<>(pool.rawTemplates);
            updatedRawTemplates.add(new Pair<>(piece, spawnWeight));
            pool.rawTemplates = updatedRawTemplates;
        }
    }

    @SubscribeEvent
    public static void addNewVillageBuilding(@NotNull ServerAboutToStartEvent event) {
        Registry<StructureTemplatePool> templatePoolRegistry = event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
        Registry<StructureProcessorList> processorListRegistry = event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();
        // normal villages
        addBuildingToPool(templatePoolRegistry, processorListRegistry, EMPTY_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/desert/houses"), MODID + ":village/desert/houses/desert_bank", Config.getDesertBankSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, EMPTY_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/plains/houses"), MODID + ":village/plains/houses/plains_bank", Config.getPlainsBankSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, EMPTY_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/savanna/houses"), MODID + ":village/savanna/houses/savanna_bank", Config.getSavannaBankSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, EMPTY_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/snowy/houses"), MODID + ":village/snowy/houses/snowy_bank", Config.getSnowyBankSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, EMPTY_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/taiga/houses"), MODID + ":village/taiga/houses/taiga_bank", Config.getTaigaBankSpawnWeight());
        // zombie villages
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_DESERT_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/desert/zombie/houses"), MODID + ":village/desert/houses/desert_bank", Config.getDesertBankSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_PLAINS_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/plains/zombie/houses"), MODID + ":village/plains/houses/plains_bank", Config.getPlainsBankSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SAVANNA_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/savanna/zombie/houses"), MODID + ":village/savanna/houses/savanna_bank", Config.getSavannaBankSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SNOWY_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/snowy/zombie/houses"), MODID + ":village/snowy/houses/snowy_bank", Config.getSnowyBankSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_TAIGA_PROCESSOR_KEY, ResourceLocation.parse("minecraft:village/taiga/zombie/houses"), MODID + ":village/taiga/houses/taiga_bank", Config.getTaigaBankSpawnWeight());
    }
}