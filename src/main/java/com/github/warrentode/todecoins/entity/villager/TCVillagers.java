package com.github.warrentode.todecoins.entity.villager;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.sounds.TCSounds;
import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TCVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MODID);

    public static final RegistryObject<PoiType> BANKER_POI = POI_TYPES.register("banker_poi",
            () -> new PoiType(ImmutableSet.copyOf(TCBlocks.COINPRESSBLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));
    public static final RegistryObject<VillagerProfession> BANKER = VILLAGER_PROFESSIONS.register("banker",
            () -> new VillagerProfession("banker", x -> x.get() == BANKER_POI.get(),
                    x -> x.get() == BANKER_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    TCSounds.WORK_BANKER.get()));

    public static final RegistryObject<PoiType> LEPRECHAUN_POI = POI_TYPES.register("leprechaun_poi",
            () -> new PoiType(ImmutableSet.copyOf(TCBlocks.POT_OF_GOLD.get().getStateDefinition().getPossibleStates()),
                    1, 1));
    public static final RegistryObject<VillagerProfession> LEPRECHAUN = VILLAGER_PROFESSIONS.register("leprechaun",
            () -> new VillagerProfession("leprechaun", x -> x.get() == LEPRECHAUN_POI.get(),
                    x -> x.get() == LEPRECHAUN_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    TCSounds.WORK_LEPRECHAUN.get()));

    public static void init() {
        setHeroGifts(ResourceLocation.parse(MODID + ":banker_gift"), BANKER.get());
        setHeroGifts(ResourceLocation.parse(MODID + ":leprechaun_gift"), LEPRECHAUN.get());
    }

    public static void setHeroGifts(@NotNull ResourceLocation name, VillagerProfession profession) {
        ResourceLocation location = ResourceLocation.parse(name.getNamespace() + ":gameplay/hero_of_the_village/" + name.getPath());
        GiveGiftToHero.GIFTS.put(profession, location);
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}