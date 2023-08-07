package com.github.warrentode.todecoins.entity;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.villager.Numismatist;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.Keys.ENTITY_TYPES, TodeCoins.MODID);

    public static final RegistryObject<EntityType<Numismatist>> NUMISMATIST =
            ENTITY_TYPES.register("numismatist",
                    () -> EntityType.Builder.of(Numismatist::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(TodeCoins.MODID, "numismatist").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}