package com.github.warrentode.block.entity;

import com.github.warrentode.TodeCoins;
import com.github.warrentode.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TodeCoins.MODID);

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<CoinPressBlockEntity>> COINPRESS_ENTITY =
            BLOCK_ENTITIES.register("coin_press", ()->
                    BlockEntityType.Builder.of(CoinPressBlockEntity::new,
                            ModBlocks.COINPRESSBLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}