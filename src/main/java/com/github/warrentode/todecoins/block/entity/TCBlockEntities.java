package com.github.warrentode.todecoins.block.entity;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.block.entity.custom.CoinAlbumBlockEntity;
import com.github.warrentode.todecoins.block.entity.custom.CoinPressBlockEntity;
import com.github.warrentode.todecoins.block.entity.custom.TipJarBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TCBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TodeCoins.MODID);

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<CoinPressBlockEntity>> COINPRESS_ENTITY =
            BLOCK_ENTITIES.register("coin_press", ()->
                    BlockEntityType.Builder.of(CoinPressBlockEntity::new,
                            TCBlocks.COINPRESSBLOCK.get()).build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<TipJarBlockEntity>> TIP_JAR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("tip_jar_block_entity",()->
                    BlockEntityType.Builder.of(TipJarBlockEntity::new,
                            TCBlocks.TIP_JAR_BLOCK.get()).build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<CoinAlbumBlockEntity>> COIN_ALBUM_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("coin_album_block_entity",()->
                    BlockEntityType.Builder.of(CoinAlbumBlockEntity::new,
                            TCBlocks.COIN_ALBUM_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}