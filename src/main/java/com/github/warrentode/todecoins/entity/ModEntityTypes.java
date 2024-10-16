package com.github.warrentode.todecoins.entity;

import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import com.github.warrentode.todecoins.entity.villager.Numismatist;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.Keys.ENTITY_TYPES, MODID);

    public static final RegistryObject<EntityType<Numismatist>> NUMISMATIST =
            ENTITY_TYPES.register("numismatist",
                    () -> EntityType.Builder.of(Numismatist::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(MODID, "numismatist").toString()));

    public static final RegistryObject<EntityType<PiglinMerchant>> PIGLINMERCHANT =
            ENTITY_TYPES.register("piglinmerchant",
                    () -> EntityType.Builder.of(PiglinMerchant::new, MobCategory.MISC)
                            .sized(0.6f, 1.95f)
                            .build(new ResourceLocation(MODID, "piglinmerchant").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}