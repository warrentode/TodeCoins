package net.warrentode.todecoins.datagen.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.util.tags.CuriosTags;
import net.warrentode.todecoins.util.tags.ForgeTags;
import net.warrentode.todecoins.util.tags.ModTags;
import net.warrentode.todecoins.util.tags.SupplementariesTags;
import org.jetbrains.annotations.Nullable;

public class ItemTagsGen extends ItemTagsProvider {
    public ItemTagsGen(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.registerModTags();
        this.registerMinecraftTags();
        this.registerForgeTags();
        this.registerCuriosTags();
        this.registerSupplementariesTags();
    }

    private void registerSupplementariesTags() {
        tag(SupplementariesTags.Items.COOKIES)
                .addTag(ForgeTags.Items.CURRENCY);
    }

    private void registerCuriosTags() {
        tag(CuriosTags.Items.CHARM).add(ModItems.LUCKY_COIN.get());
        tag(CuriosTags.Items.BELT)
                .addTag(ModTags.Items.BUNDLES);
    }

    private void registerMinecraftTags() {
        tag(net.minecraft.tags.ItemTags.PIGLIN_LOVED).add(
                ModItems.GOLD_COIN.get(),
                ModItems.NETHER_GOLD_COIN.get(),
                ModBlocks.GOLD_COIN_BAG.get().asItem(),
                ModBlocks.NETHER_GOLD_COIN_BAG.get().asItem()
        ).addTag(ForgeTags.Items.PIGLIN_BARTER_ITEMS);
    }

    private void registerModTags() {
        tag(ModTags.Items.BUNDLES)
                .add(Items.BUNDLE);
        tag(ModTags.Items.BANKNOTES).add(
                ModItems.EMERALD_QUARTER_BANK_NOTE.get(),
                ModItems.EMERALD_HALF_BANK_NOTE.get(),
                ModItems.EMERALD_BANK_NOTE.get()
        );
        tag(ModTags.Items.COINS).add(
                ModItems.COPPER_COIN.get(),
                ModItems.IRON_COIN.get(),
                ModItems.GOLD_COIN.get(),
                ModItems.NETHER_GOLD_COIN.get(),
                ModItems.NETHERITE_COIN.get(),
                ModItems.LUCKY_COIN.get()
        );
        tag(ModTags.Items.CURRENCY)
                .addTag(ModTags.Items.BANKNOTES)
                .addTag(ModTags.Items.COINS)
                .addTag(ForgeTags.Items.PIGLIN_BARTER_ITEMS);
        tag(ModTags.Items.CURRENCY_MATERIALS)
                .addTag(ModTags.Items.COPPER_NUGGET)
                .addTag(ModTags.Items.IRON_NUGGET)
                .addTag(ModTags.Items.GOLD_NUGGET)
                .addTag(ModTags.Items.NETHERITE_NUGGET)
                .addTag(ModTags.Items.CURRENCY_FIBER)
                .addTag(ModTags.Items.CURRENCY_PAPER);
        tag(ModTags.Items.CURRENCY_STAMPS).add(
                ModItems.CURRENCY_STAMP.get(),
                ModItems.NETHER_CURRENCY_STAMP.get()
        );
        tag(ModTags.Items.TEXTILES)
                .addTag(ModTags.Items.CURRENCY_FIBER)
                .addTag(ModTags.Items.CURRENCY_PAPER)
                .addTag(ModTags.Items.FABRIC)
                .addTag(ModTags.Items.FIBRE)
                .addTag(ModTags.Items.THREAD);
        tag(ModTags.Items.CURRENCY_FIBER).add(
                Items.PAPER,
                Items.STRING
        )
                .addTag(ForgeTags.Items.FIBRE)
                .addTag(ForgeTags.Items.BARK)
                .addTag(ForgeTags.Items.STRING)
                .addTag(ForgeTags.Items.PAPER);
        tag(ModTags.Items.CURRENCY_PAPER).add(
                ModItems.EMERALD_COARSE_WOVE_PAPER.get(),
                ModItems.EMERALD_WOVE_PAPER.get(),
                ModItems.EMERALD_SMOOTH_WOVE_PAPER.get()
        );
        tag(ModTags.Items.FABRIC).add(
                ModItems.LUCKY_FABRIC.get()
        );
        tag(ModTags.Items.FIBRE).add(
                ModItems.EMERALD_FIBER.get(),
                ModItems.LUCKY_FIBER.get()
        );
        tag(ModTags.Items.THREAD).add(
                ModItems.LUCKY_THREAD.get()
        );
        tag(ModTags.Items.NUGGETS)
                .addTag(ModTags.Items.COPPER_NUGGET)
                .addTag(ModTags.Items.IRON_NUGGET)
                .addTag(ModTags.Items.GOLD_NUGGET)
                .addTag(ModTags.Items.LUCKY_NUGGET)
                .addTag(ModTags.Items.NETHERITE_NUGGET);
        tag(ModTags.Items.COPPER_NUGGET).add(
                ModItems.COPPER_NUGGET.get()
        );
        tag(ModTags.Items.IRON_NUGGET).add(
                Items.IRON_NUGGET
        );
        tag(ModTags.Items.GOLD_NUGGET).add(
                Items.GOLD_NUGGET
        );
        tag(ModTags.Items.LUCKY_NUGGET).add(
                ModItems.LUCKY_NUGGET.get()
        );
        tag(ModTags.Items.NETHERITE_NUGGET).add(
                ModItems.NETHERITE_NUGGET.get()
        );
        tag(ModTags.Items.INGOTS)
                .addTag(ForgeTags.Items.COPPER_INGOT)
                .addTag(ForgeTags.Items.IRON_INGOT)
                .addTag(ForgeTags.Items.GOLD_INGOT)
                .addTag(ForgeTags.Items.NETHERITE_INGOT);
        tag(ModTags.Items.COPPER_INGOT).add(
                Items.COPPER_INGOT
        );
        tag(ModTags.Items.IRON_INGOT).add(
                Items.IRON_INGOT
        );
        tag(ModTags.Items.GOLD_INGOT).add(
                Items.GOLD_INGOT
        );
        tag(ModTags.Items.NETHERITE_INGOT).add(
                Items.NETHERITE_INGOT
        );
    }
    private void registerForgeTags() {
        tag(ForgeTags.Items.GEMS)
                .addTag(ForgeTags.Items.AMETHYST)
                .addTag(ForgeTags.Items.DIAMOND)
                .addTag(ForgeTags.Items.ECHO_SHARD)
                .addTag(ForgeTags.Items.EMERALD)
                .addTag(ForgeTags.Items.END_CRYSTAL)
                .addTag(ForgeTags.Items.ENDER_EYE)
                .addTag(ForgeTags.Items.ENDER_PEARL)
                .addTag(ForgeTags.Items.GLOWSTONE)
                .addTag(ForgeTags.Items.LAPIS_LAZULI)
                .addTag(ForgeTags.Items.NETHER_STAR)
                .addTag(ForgeTags.Items.PRISMARINE)
                .addTag(ForgeTags.Items.QUARTZ)
                .addTag(ForgeTags.Items.REDSTONE)
                .add(Items.SEA_LANTERN)
                .add(Items.SHULKER_SHELL)
                .add(Items.BLAZE_ROD)
                .add(Items.BLAZE_POWDER)
                .add(Items.GHAST_TEAR);
        tag(ForgeTags.Items.AMETHYST).add(
                Items.AMETHYST_BLOCK,
                Items.AMETHYST_CLUSTER,
                Items.AMETHYST_SHARD,
                Items.BUDDING_AMETHYST,
                Items.LARGE_AMETHYST_BUD,
                Items.MEDIUM_AMETHYST_BUD,
                Items.SMALL_AMETHYST_BUD
        );
        tag(ForgeTags.Items.DIAMOND).add(
                Items.DIAMOND,
                Items.DIAMOND_BLOCK
        );
        tag(ForgeTags.Items.ECHO_SHARD).add(
                Items.ECHO_SHARD
        );
        tag(ForgeTags.Items.EMERALD).add(
                Items.EMERALD,
                Items.EMERALD_BLOCK
        );
        tag(ForgeTags.Items.END_CRYSTAL).add(
                Items.END_CRYSTAL
        );
        tag(ForgeTags.Items.ENDER_EYE).add(
                Items.ENDER_EYE
        );
        tag(ForgeTags.Items.ENDER_PEARL).add(
                Items.ENDER_PEARL
        );
        tag(ForgeTags.Items.GLOWSTONE).add(
                Items.GLOWSTONE,
                Items.GLOWSTONE_DUST
        );
        tag(ForgeTags.Items.LAPIS_LAZULI).add(
                Items.LAPIS_LAZULI,
                Items.LAPIS_BLOCK
        );
        tag(ForgeTags.Items.NETHER_STAR).add(
                Items.NETHER_STAR
        );
        tag(ForgeTags.Items.PRISMARINE).add(
                Items.PRISMARINE_CRYSTALS,
                Items.PRISMARINE_SHARD,
                Items.PRISMARINE
        );
        tag(ForgeTags.Items.QUARTZ).add(
                Items.QUARTZ,
                Items.QUARTZ_BLOCK
        );
        tag(ForgeTags.Items.REDSTONE).add(
                Items.REDSTONE,
                Items.REDSTONE_BLOCK
        );
        tag(ForgeTags.Items.NUGGETS)
                .addTag(ForgeTags.Items.COPPER_NUGGET)
                .addTag(ForgeTags.Items.IRON_NUGGET)
                .addTag(ForgeTags.Items.GOLD_NUGGET)
                .addTag(ForgeTags.Items.LUCKY_NUGGET)
                .addTag(ForgeTags.Items.NETHERITE_NUGGET);
        tag(ForgeTags.Items.COPPER_NUGGET)
                .addTag(ModTags.Items.COPPER_NUGGET);
        tag(ForgeTags.Items.IRON_NUGGET)
                .addTag(ModTags.Items.IRON_NUGGET);
        tag(ForgeTags.Items.GOLD_NUGGET)
                .addTag(ModTags.Items.GOLD_NUGGET);
        tag(ForgeTags.Items.LUCKY_NUGGET)
                .addTag(ModTags.Items.LUCKY_NUGGET);
        tag(ForgeTags.Items.NETHERITE_NUGGET)
                .addTag(ModTags.Items.NETHERITE_NUGGET);
        tag(ForgeTags.Items.INGOTS)
                .addTag(ForgeTags.Items.COPPER_INGOT)
                .addTag(ForgeTags.Items.IRON_INGOT)
                .addTag(ForgeTags.Items.GOLD_INGOT)
                .addTag(ForgeTags.Items.NETHERITE_INGOT);
        tag(ForgeTags.Items.COPPER_INGOT).add(
                Items.COPPER_INGOT
        );
        tag(ForgeTags.Items.IRON_INGOT).add(
                Items.IRON_INGOT
        );
        tag(ForgeTags.Items.GOLD_INGOT).add(
                Items.GOLD_INGOT
        );
        tag(ForgeTags.Items.NETHERITE_INGOT).add(
                Items.NETHERITE_INGOT
        );
        tag(ForgeTags.Items.CURRENCY_MATERIALS)
                .addTag(ForgeTags.Items.COPPER_NUGGET)
                .addTag(ForgeTags.Items.IRON_NUGGET)
                .addTag(ForgeTags.Items.GOLD_NUGGET)
                .addTag(ModTags.Items.NETHERITE_NUGGET)
                .addTag(ModTags.Items.CURRENCY_FIBER)
                .addTag(ModTags.Items.CURRENCY_PAPER);
        tag(ForgeTags.Items.TEXTILES)
                .addTag(ForgeTags.Items.BARK)
                .addTag(ForgeTags.Items.FIBRE)
                .addTag(ForgeTags.Items.STRING)
                .addTag(ForgeTags.Items.PAPER)
                .addTag(ForgeTags.Items.FABRIC)
                .addTag(ForgeTags.Items.THREAD)
                .addTag(ForgeTags.Items.CURRENCY_PAPER)
                .addTag(ForgeTags.Items.CURRENCY_FIBER);
        tag(ForgeTags.Items.BARK);
        tag(ForgeTags.Items.THREAD);
        tag(ForgeTags.Items.CURRENCY_PAPER);
        tag(ForgeTags.Items.CURRENCY_FIBER);
        tag(ForgeTags.Items.FABRIC)
                .addTag(net.minecraft.tags.ItemTags.WOOL);
        tag(ForgeTags.Items.FIBRE);
        tag(ForgeTags.Items.PAPER).add(
                Items.PAPER
        );
        tag(ForgeTags.Items.STRING).add(
                Items.STRING
        );
        tag(ForgeTags.Items.CURRENCY).addTag(ModTags.Items.CURRENCY);
        tag(ForgeTags.Items.PIGLIN_BARTER_ITEMS).add(
                ModItems.NETHER_GOLD_COIN.get()
        );
    }
}