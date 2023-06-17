package net.warrentode.todecoins.datagen.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.util.tags.CuriosTags;
import net.warrentode.todecoins.util.tags.ForgeTags;
import net.warrentode.todecoins.util.tags.ModTags;
import net.warrentode.todecoins.util.tags.SupplementariesTags;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

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
                .addTag(ModTags.Items.JAR_PLACEABLE);
    }

    private void registerCuriosTags() {
        tag(CuriosTags.Items.CHARM)
                .add(ModItems.LUCKY_COIN.get())
                .addTag(ModTags.Items.COLLECTIBLE_COINS);
        tag(CuriosTags.Items.BELT)
                .addTag(ModTags.Items.WALLETS);
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
        tag(ModTags.Items.SOUL_BINDER)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("cagerium:binding_gemstone")));
        tag(ModTags.Items.JAR_PLACEABLE)
                .addTag(ModTags.Items.COLLECTIBLE_COINS)
                .addTag(ForgeTags.Items.CURRENCY);
        tag(ModTags.Items.COLLECTIBLE_COINS)
                .addTag(ModTags.Items.HOLIDAY_COIN_SET)
                .addTag(ModTags.Items.PATRON_COIN_SET)
                .addTag(ModTags.Items.GAMEPLAY_COIN_SET)
                .addTag(ModTags.Items.ENTITY_COIN_SET);
        tag(ModTags.Items.GAMEPLAY_COIN_SET)
                .addTag(ModTags.Items.HERO_COIN_SET);
        tag(ModTags.Items.HERO_COIN_SET)
                .add(ModItems.COPPER_HERO_COIN.get())
                .add(ModItems.IRON_HERO_COIN.get())
                .add(ModItems.GOLD_HERO_COIN.get())
                .add(ModItems.NETHERITE_HERO_COIN.get());
        tag(ModTags.Items.HOLIDAY_COIN_SET)
                .addTag(ModTags.Items.BIRTHDAY_COIN_SET)
                .addTag(ModTags.Items.CHRISTMAS_COIN_SET)
                .addTag(ModTags.Items.HALLOWEEN_COIN_SET);
        tag(ModTags.Items.CHRISTMAS_COIN_SET)
                .add(ModItems.CHRISTMAS_COIN_2023.get());
        tag(ModTags.Items.HALLOWEEN_COIN_SET)
                .add(ModItems.HALLOWEEN_COIN_2023.get());
        tag(ModTags.Items.BIRTHDAY_COIN_SET)
                .add(ModItems.BIRTHDAY_COIN_2023.get());
        tag(ModTags.Items.PATRON_COIN_SET)
                .addTag(ModTags.Items.CARNATION_PATRON_COIN_SET)
                .addTag(ModTags.Items.COSMOS_PATRON_COIN_SET);
        tag(ModTags.Items.CARNATION_PATRON_COIN_SET)
                .add(ModItems.MARSHALL_NASH_CARNATION_COIN.get())
                .add(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get());
        tag(ModTags.Items.COSMOS_PATRON_COIN_SET)
                .add(ModItems.MARSHALL_NASH_COSMOS_COIN.get())
                .add(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get());
        tag(ModTags.Items.ENTITY_COIN_SET)
                .addTag(ModTags.Items.ALLAY_COIN_SET)
                .addTag(ModTags.Items.AXOLOTL_COIN_SET)
                .addTag(ModTags.Items.BAT_COIN_SET)
                .addTag(ModTags.Items.BEE_COIN_SET)
                .addTag(ModTags.Items.BLAZE_COIN_SET)
                .addTag(ModTags.Items.CAMEL_COIN_SET)
                .addTag(ModTags.Items.CAT_COIN_SET)
                .addTag(ModTags.Items.CAVE_SPIDER_COIN_SET)
                .addTag(ModTags.Items.CHICKEN_COIN_SET)
                .addTag(ModTags.Items.ENDERMAN_COIN_SET)
                .addTag(ModTags.Items.OCELOT_COIN_SET)
                .addTag(ModTags.Items.PIGLIN_COIN_SET);
        tag(ModTags.Items.BEE_COIN_SET)
                .add(ModItems.COPPER_BEE_COIN.get())
                .add(ModItems.IRON_BEE_COIN.get())
                .add(ModItems.GOLD_BEE_COIN.get())
                .add(ModItems.NETHERITE_BEE_COIN.get());
        tag(ModTags.Items.OCELOT_COIN_SET)
                .add(ModItems.COPPER_OCELOT_COIN.get())
                .add(ModItems.IRON_OCELOT_COIN.get())
                .add(ModItems.GOLD_OCELOT_COIN.get())
                .add(ModItems.NETHERITE_OCELOT_COIN.get());
        tag(ModTags.Items.ALLAY_COIN_SET)
                .add(ModItems.COPPER_ALLAY_COIN.get())
                .add(ModItems.IRON_ALLAY_COIN.get())
                .add(ModItems.GOLD_ALLAY_COIN.get())
                .add(ModItems.NETHERITE_ALLAY_COIN.get());
        tag(ModTags.Items.AXOLOTL_COIN_SET)
                .add(ModItems.COPPER_AXOLOTL_COIN.get())
                .add(ModItems.IRON_AXOLOTL_COIN.get())
                .add(ModItems.GOLD_AXOLOTL_COIN.get())
                .add(ModItems.NETHERITE_AXOLOTL_COIN.get());
        tag(ModTags.Items.BAT_COIN_SET)
                .add(ModItems.COPPER_BAT_COIN.get())
                .add(ModItems.IRON_BAT_COIN.get())
                .add(ModItems.GOLD_BAT_COIN.get())
                .add(ModItems.NETHERITE_BAT_COIN.get());
        tag(ModTags.Items.BLAZE_COIN_SET)
                .add(ModItems.COPPER_BLAZE_COIN.get())
                .add(ModItems.IRON_BLAZE_COIN.get())
                .add(ModItems.GOLD_BLAZE_COIN.get())
                .add(ModItems.NETHERITE_BLAZE_COIN.get());
        tag(ModTags.Items.CAMEL_COIN_SET)
                .add(ModItems.COPPER_CAMEL_COIN.get())
                .add(ModItems.IRON_CAMEL_COIN.get())
                .add(ModItems.GOLD_CAMEL_COIN.get())
                .add(ModItems.NETHERITE_CAMEL_COIN.get());
        tag(ModTags.Items.CAT_COIN_SET)
                .add(ModItems.COPPER_CAT_COIN.get())
                .add(ModItems.IRON_CAT_COIN.get())
                .add(ModItems.GOLD_CAT_COIN.get())
                .add(ModItems.NETHERITE_CAT_COIN.get());
        tag(ModTags.Items.CAVE_SPIDER_COIN_SET)
                .add(ModItems.COPPER_CAVE_SPIDER_COIN.get())
                .add(ModItems.IRON_CAVE_SPIDER_COIN.get())
                .add(ModItems.GOLD_CAVE_SPIDER_COIN.get())
                .add(ModItems.NETHERITE_CAVE_SPIDER_COIN.get());
        tag(ModTags.Items.CHICKEN_COIN_SET)
                .add(ModItems.COPPER_CHICKEN_COIN.get())
                .add(ModItems.IRON_CHICKEN_COIN.get())
                .add(ModItems.GOLD_CHICKEN_COIN.get())
                .add(ModItems.NETHERITE_CHICKEN_COIN.get());
        tag(ModTags.Items.ENDERMAN_COIN_SET)
                .add(ModItems.COPPER_ENDERMAN_COIN.get())
                .add(ModItems.IRON_ENDERMAN_COIN.get())
                .add(ModItems.GOLD_ENDERMAN_COIN.get())
                .add(ModItems.NETHERITE_ENDERMAN_COIN.get());
        tag(ModTags.Items.PIGLIN_COIN_SET)
                .add(ModItems.COPPER_PIGLIN_COIN.get())
                .add(ModItems.IRON_PIGLIN_COIN.get())
                .add(ModItems.GOLD_PIGLIN_COIN.get())
                .add(ModItems.NETHERITE_PIGLIN_COIN.get());
        tag(ModTags.Items.SHULKER_BOXES)
                .add(Blocks.SHULKER_BOX.asItem())
                .add(Blocks.BLACK_SHULKER_BOX.asItem())
                .add(Blocks.BLUE_SHULKER_BOX.asItem())
                .add(Blocks.BROWN_SHULKER_BOX.asItem())
                .add(Blocks.CYAN_SHULKER_BOX.asItem())
                .add(Blocks.GRAY_SHULKER_BOX.asItem())
                .add(Blocks.GREEN_SHULKER_BOX.asItem())
                .add(Blocks.LIGHT_BLUE_SHULKER_BOX.asItem())
                .add(Blocks.LIGHT_GRAY_SHULKER_BOX.asItem())
                .add(Blocks.LIME_SHULKER_BOX.asItem())
                .add(Blocks.MAGENTA_SHULKER_BOX.asItem())
                .add(Blocks.ORANGE_SHULKER_BOX.asItem())
                .add(Blocks.PINK_SHULKER_BOX.asItem())
                .add(Blocks.PURPLE_SHULKER_BOX.asItem())
                .add(Blocks.RED_SHULKER_BOX.asItem())
                .add(Blocks.WHITE_SHULKER_BOX.asItem())
                .add(Blocks.YELLOW_SHULKER_BOX.asItem());
        tag(ModTags.Items.BUNDLES)
                .add(Items.BUNDLE);
        tag(ModTags.Items.WALLETS)
                .addTag(ModTags.Items.BUNDLES)
                .addTag(ModTags.Items.SHULKER_BOXES)
                .addTag(Tags.Items.BARRELS)
                .addTag(Tags.Items.CHESTS)
                .addTag(Tags.Items.CHESTS_ENDER);
        tag(ModTags.Items.GEMS)
                .addTag(ForgeTags.Items.GEMS);
        tag(ModTags.Items.BANKNOTES)
                .add(ModItems.EMERALD_BANK_NOTE.get())
                .add(ModItems.EMERALD_HALF_BANK_NOTE.get())
                .add(ModItems.EMERALD_QUARTER_BANK_NOTE.get())
                .add(ModBlocks.EMERALD_BANK_NOTE_BAG.get().asItem())
                .add(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get().asItem())
                .add(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get().asItem());
        tag(ModTags.Items.COINS)
                .add(ModItems.COPPER_COIN.get())
                .add(ModItems.IRON_COIN.get())
                .add(ModItems.GOLD_COIN.get())
                .add(ModItems.NETHER_GOLD_COIN.get())
                .add(ModItems.NETHERITE_COIN.get())
                .add(ModItems.LUCKY_COIN.get())
                .add(ModBlocks.COPPER_COIN_BAG.get().asItem())
                .add(ModBlocks.IRON_COIN_BAG.get().asItem())
                .add(ModBlocks.GOLD_COIN_BAG.get().asItem())
                .add(ModBlocks.POT_OF_GOLD.get().asItem())
                .add(ModBlocks.NETHER_GOLD_COIN_BAG.get().asItem())
                .add(ModBlocks.NETHERITE_COIN_BAG.get().asItem());
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
        tag(Tags.Items.EGGS)
                .add(Items.TURTLE_EGG)
                .add(Items.EGG);
        tag(Tags.Items.ENCHANTING_FUELS)
                .add(Items.LAPIS_LAZULI);
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
        tag(ForgeTags.Items.CURRENCY_STAMPS)
                .addTag(ModTags.Items.CURRENCY_STAMPS);
        tag(ForgeTags.Items.CURRENCY)
                .addTag(ModTags.Items.CURRENCY);
        tag(ForgeTags.Items.BANKNOTES)
                .addTag(ModTags.Items.BANKNOTES);
        tag(ForgeTags.Items.COINS)
                .addTag(ModTags.Items.COINS);
        tag(ForgeTags.Items.PIGLIN_BARTER_ITEMS).add(
                ModItems.NETHER_GOLD_COIN.get(),
                ModItems.NETHERITE_PIGLIN_COIN.get()
        );
    }
}