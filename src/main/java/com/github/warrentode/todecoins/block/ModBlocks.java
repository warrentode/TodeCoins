package com.github.warrentode.todecoins.block;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.block.custom.CoinPressBlock;
import com.github.warrentode.todecoins.block.custom.PotOfGoldBlock;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.customtabs.ModCreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // TODO design coin collection display blocks
    // something that doesn't count as an entity so it doesn't tick
    // probably best if done by sets? recipes to make and unmake?
    // most of the coins already come in sets of four
    // probably means I need to redesign the textures and models of these coins so they look nice on a block
    // as it is, I feel they are hard to see in the gui right now
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TodeCoins.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TodeCoins.MODID);

    public static final RegistryObject<Block> COPPER_COIN_BAG = registerBlock("copper_coin_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.CHAIN).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);
    public static final RegistryObject<Block> IRON_COIN_BAG = registerBlock("iron_coin_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.CHAIN).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);
    public static final RegistryObject<Block> GOLD_COIN_BAG = registerBlock("gold_coin_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.CHAIN).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);
    public static final RegistryObject<Block> NETHERITE_COIN_BAG = registerBlock("netherite_coin_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.CHAIN).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);

    public static final RegistryObject<Block> NETHER_GOLD_COIN_BAG = registerBlock("nether_gold_coin_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.CHAIN).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);
    public static final RegistryObject<Block> ENDONIAN_COIN_BAG = registerBlock("endonian_coin_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.CHAIN).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);
    public static final RegistryObject<Block> LUCKY_COIN_BAG = registerBlock("lucky_coin_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.CHAIN).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);

    public static final RegistryObject<Block> EMERALD_QUARTER_BANK_NOTE_BAG = registerBlock("emerald_quarter_bank_note_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOL).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);
    public static final RegistryObject<Block> EMERALD_HALF_BANK_NOTE_BAG = registerBlock("emerald_half_bank_note_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOL).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);
    public static final RegistryObject<Block> EMERALD_BANK_NOTE_BAG = registerBlock("emerald_bank_note_bag",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOL).strength(2f)),
            ModCreativeModeTab.TODECOINSTAB);

    public static final RegistryObject<Block> ENDONIAN_BLOCK = registerBlock("endonian_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.CHAIN).strength(0.4F)
                    .sound(SoundType.WOOD).noOcclusion()), ModCreativeModeTab.TODECOINSTAB);

    public static final RegistryObject<Block> POT_OF_GOLD = registerBlock("pot_of_gold",
            () -> new PotOfGoldBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.CHAIN).strength(8f)
                    .requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TODECOINSTAB);
    public static final RegistryObject<Block> COINPRESSBLOCK = registerBlock("coin_press",
            () -> new CoinPressBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.ANVIL).strength(8f)
                    .requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TODECOINSTAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, @SuppressWarnings("SameParameterValue") CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    @SuppressWarnings("UnusedReturnValue")
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}