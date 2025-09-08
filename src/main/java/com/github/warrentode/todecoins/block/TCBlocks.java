package com.github.warrentode.todecoins.block;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.block.custom.CoinAlbumBlock;
import com.github.warrentode.todecoins.block.custom.CoinPressBlock;
import com.github.warrentode.todecoins.block.custom.PotOfGoldBlock;
import com.github.warrentode.todecoins.block.custom.TipJarBlock;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.util.tabs.TabCategory;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.function.Supplier;

public class TCBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TodeCoins.MODID);

    // Maps for dynamic generation
    public static final Map<RegistryObject<? extends Block>, TabCategory> BLOCK_CATEGORIES = new HashMap<>();

    // --- All blocks ---
    public static final RegistryObject<Block> COPPER_COIN_BAG = registerBlock("copper_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> IRON_COIN_BAG = registerBlock("iron_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> GOLD_COIN_BAG = registerBlock("gold_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> NETHERITE_COIN_BAG = registerBlock("netherite_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> NETHER_GOLD_COIN_BAG = registerBlock("nether_gold_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> ENDONIAN_COIN_BAG = registerBlock("endonian_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> LUCKY_COIN_BAG = registerBlock("lucky_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> LAPIS_FLORIN_BAG = registerBlock("lapis_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> AMETHYST_FLORIN_BAG = registerBlock("amethyst_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> DIAMOND_FLORIN_BAG = registerBlock("diamond_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> EMERALD_FLORIN_BAG = registerBlock("emerald_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> ECHO_COIN_BAG = registerBlock("echo_coin_bag",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(2f)),
            TabCategory.DECORATIVE);

    public static final RegistryObject<Block> EMERALD_QUARTER_BANK_NOTE_BAG = registerBlock("emerald_quarter_bank_note_bag",
            () -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).sound(SoundType.WOOL).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> EMERALD_HALF_BANK_NOTE_BAG = registerBlock("emerald_half_bank_note_bag",
            () -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).sound(SoundType.WOOL).strength(2f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> EMERALD_BANK_NOTE_BAG = registerBlock("emerald_bank_note_bag",
            () -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).sound(SoundType.WOOL).strength(2f)),
            TabCategory.DECORATIVE);

    public static final RegistryObject<Block> ENDONIAN_BLOCK = registerBlock("endonian_block",
            () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOD).strength(2f)),
            TabCategory.BUILDING);
    public static final RegistryObject<Block> POT_OF_GOLD = registerBlock("pot_of_gold",
            () -> new PotOfGoldBlock(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(82f)),
            TabCategory.DECORATIVE);
    public static final RegistryObject<Block> COINPRESSBLOCK = registerBlock("coin_press",
            () -> new CoinPressBlock(Block.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHAIN).strength(8f)),
            TabCategory.DECORATIVE);

    public static final RegistryObject<Block> ENDONIAN_ORE = registerBlock("endonian_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F).requiresCorrectToolForDrops(), UniformInt.of(3, 7)),
            TabCategory.NATURAL);

    public static final RegistryObject<Block> TIP_JAR_BLOCK = registerBlockWithoutBlockItem("tip_jar",
            () -> new TipJarBlock(Block.Properties.copy(Blocks.GLASS)
                    .sound(SoundType.GLASS)
                    .isRedstoneConductor((state, world, pos) -> false)
                    .noOcclusion().strength(2F)));

    public static final RegistryObject<Block> COIN_ALBUM_BLOCK = registerBlockWithoutBlockItem("coin_album",
            () -> new CoinAlbumBlock(Block.Properties.copy(Blocks.WHITE_WOOL)
                    .sound(SoundType.WOOD).strength(2F)));

    // register the block without a block item - will be handled in item registry
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    // --- Registration helpers ---
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier, TabCategory category) {
        RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
        BLOCK_CATEGORIES.put(block, category);

        // Register BlockItem
        TCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}