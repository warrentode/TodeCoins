package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.datagen.recipes.builder.RemainderShapelessRecipeBuilder;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinItem;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Consumer;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.datagen.RecipesGen.*;

public class CraftingRecipesGen extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipesGen(@NotNull DataGenerator generator) {
        super(generator.getPackOutput());
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        register(consumer);
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        currencyStampsRecipes(consumer);
        jobBlockRecipes(consumer);
        armorRecipes(consumer);
        ingotRecipes(consumer);
        nuggetRecipes(consumer);
        currencyBagRecipes(consumer);
        currencyRecipes(consumer);
        materialBlockRecipes(consumer);
        textileRecipes(consumer);
        chocolateCoinRecipes(consumer);
        toolRecipes(consumer);
        smeltingRecipes(consumer);
        blastingRecipes(consumer);
    }

    private static void smeltingRecipes(Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TCItems.ENDONIAN_CRYSTAL.get()),
                        RecipeCategory.MISC, TCItems.ENDONIAN_NUGGET.get(), 0.1F, 200)
                .unlockedBy("has_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(TCItems.ENDONIAN_NUGGET.get())).getPath(),
                        InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ENDONIAN_CRYSTAL.get()))
                .save(consumer, setLocation(MODID, "nuggets/smelting/" +
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(TCItems.ENDONIAN_NUGGET.get())).getPath()));

        getCoinByMaterial().forEach((material, coins) -> {
            Item nugget = getNuggetForCoin(material);
            for (CollectibleCoinItem coin : coins) {
                String coinPath = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(coin)).getPath();
                String nuggetPath = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(nugget)).getPath();

                SimpleCookingRecipeBuilder.smelting(Ingredient.of(coin), RecipeCategory.MISC, nugget, 0.1F, 200)
                        .unlockedBy("has_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(nugget)).getPath(),
                                InventoryChangeTrigger.TriggerInstance.hasItems(nugget))
                        .save(consumer, setLocation(MODID,"nuggets/smelting/" + nuggetPath + "_from_" + coinPath));
            }
        });
    }

    private static void blastingRecipes(Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(TCItems.ENDONIAN_CRYSTAL.get()),
                        RecipeCategory.MISC, TCItems.ENDONIAN_NUGGET.get(), 0.1F, 100)
                .unlockedBy("has_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(TCItems.ENDONIAN_NUGGET.get())).getPath(),
                        InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ENDONIAN_CRYSTAL.get()))
                .save(consumer, setLocation(MODID, "nuggets/blasting/" +
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(TCItems.ENDONIAN_NUGGET.get())).getPath()));

        getCoinByMaterial().forEach((material, coins) -> {
            Item nugget = getNuggetForCoin(material);
            for (CollectibleCoinItem coin : coins) {
                String coinPath = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(coin)).getPath();
                String nuggetPath = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(nugget)).getPath();

                SimpleCookingRecipeBuilder.blasting(Ingredient.of(coin), RecipeCategory.MISC, nugget, 0.1F, 100)
                        .unlockedBy("has_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(nugget)).getPath(),
                                InventoryChangeTrigger.TriggerInstance.hasItems(nugget))
                        .save(consumer, setLocation(MODID,"nuggets/blasting/" + nuggetPath + "_from_" + coinPath));
            }
        });
    }

    private static void toolRecipes(Consumer<FinishedRecipe> consumer) {
        RemainderShapelessRecipeBuilder.shapelessRemainderRecipe(RecipeCategory.TOOLS, TCItems.COIN_ALBUM_BLOCK_ITEM.get(), 1)
                .addIngredient(TCItemTags.COLLECTIBLE_COINS_TAG)
                .addIngredient(Items.BOOK)
                .unlockedBy("has_collectible_coin", has(TCItemTags.COLLECTIBLE_COINS_TAG))
                .build(consumer, setLocation(MODID, "coin_album"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,TCItems.BRACELET_FRIENDSHIP_EMERALD.get(), 1)
                .pattern("#A#")
                .pattern("APA")
                .pattern("#A#")
                .define('#', TCItems.ENDONIAN_THREAD.get())
                .define('A', TCItems.EMERALD_THREAD.get())
                .define('P', Items.ENDER_PEARL)
                .unlockedBy("has_emerald_thread", has(TCItems.EMERALD_THREAD.get()))
                .save(consumer, setLocation(MODID, "bracelets/bracelet_friendship_emerald"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,TCItems.BRACELET_FRIENDSHIP_ECHO.get(), 1)
                .pattern("#A#")
                .pattern("APA")
                .pattern("#A#")
                .define('#', TCItems.ENDONIAN_THREAD.get())
                .define('A', TCItems.ECHO_THREAD.get())
                .define('P', Items.ENDER_PEARL)
                .unlockedBy("has_echo_thread", has(TCItems.ECHO_THREAD.get()))
                .save(consumer, setLocation(MODID, "bracelets/bracelet_friendship_echo"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,TCItems.BRACELET_FRIENDSHIP_ENDONIAN.get(), 1)
                .pattern("###")
                .pattern("#P#")
                .pattern("###")
                .define('#', TCItems.ENDONIAN_THREAD.get())
                .define('P', Items.ENDER_PEARL)
                .unlockedBy("has_endonian_thread", has(TCItems.ENDONIAN_THREAD.get()))
                .save(consumer, setLocation(MODID, "bracelets/bracelet_friendship_endonian"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,TCItems.BRACELET_FRIENDSHIP_LUCKY.get(), 1)
                .pattern("#A#")
                .pattern("APA")
                .pattern("#A#")
                .define('#', TCItems.ENDONIAN_THREAD.get())
                .define('A', TCItems.LUCKY_THREAD.get())
                .define('P', Items.ENDER_PEARL)
                .unlockedBy("has_lucky_thread", has(TCItems.LUCKY_THREAD.get()))
                .save(consumer, setLocation(MODID, "bracelets/bracelet_friendship_lucky"));
    }

    private static void chocolateCoinRecipes(Consumer<FinishedRecipe> consumer) {
        chocolateCoinRecipeTemplate(consumer, TCItems.CHOCOLATE_COIN_CRIMSON_SPORE.get(), 4, Items.CRIMSON_FUNGUS, Items.ROTTEN_FLESH, null, null);
        chocolateCoinRecipeTemplate(consumer, TCItems.CHOCOLATE_COIN_WARPED_SPICE.get(), 4, Items.WARPED_FUNGUS, Items.PUFFERFISH, null, null);
        chocolateCoinRecipeTemplate(consumer, TCItems.CHOCOLATE_COIN_MILK_BONE.get(), 4, Items.BONE_MEAL, Items.COBWEB, null, null);
        chocolateCoinRecipeTemplate(consumer, TCItems.CHOCOLATE_COIN_ULTIMATE_DARK.get(), 4, Items.EMERALD, Items.INK_SAC, null, null);
        chocolateCoinRecipeTemplate(consumer, TCItems.CHOCOLATE_COIN_FUEGO_FUDGE.get(), 4, Items.MAGMA_CREAM, Items.GLOWSTONE_DUST, null, null);
        chocolateCoinRecipeTemplate(consumer, TCItems.CHOCOLATE_COIN_CARMEL_CRISP.get(), 4, Items.HONEY_BLOCK, Items.COOKIE, null, null);
        chocolateCoinRecipeTemplate(consumer, TCItems.CHOCOLATE_COIN_BUBBLY_BERRY.get(), 4, null,Items.PHANTOM_MEMBRANE, TCItemTags.BERRIES, null);
        chocolateCoinRecipeTemplate(consumer, TCItems.CHOCOLATE_COIN_FESTIVE_FUDGE.get(), 4, null, Items.GLOW_LICHEN, TCItemTags.COCOA_INGREDIENTS, null);
        chocolateCoinRecipeTemplate(consumer, TCItems.CHOCOLATE_COIN_VELVETY_CLOVER.get(), 2, null,null, TCItemTags.CLOVER, TCItemTags.CLOVER);
    }

    private static void textileRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.EMERALD_FIBER.get(), 1)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .define('#', TCItemTags.CURRENCY_FIBER)
                .define('E', Items.EMERALD)
                .unlockedBy("has_emerald", has(TCItemTags.CURRENCY_FIBER))
                .save(consumer, setLocation(MODID, "textiles/fiber/emerald_fiber"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.EMERALD_THREAD.get(), 1)
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.EMERALD_FIBER.get())
                .unlockedBy("has_emerald_fiber", has(TCItems.EMERALD_FIBER.get()))
                .save(consumer, setLocation(MODID, "textiles/thread/emerald_thread"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.EMERALD_SMOOTH_WOVE_PAPER.get(), 1)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', TCItems.EMERALD_FIBER.get())
                .unlockedBy("has_emerald_fiber", has(TCItems.EMERALD_FIBER.get()))
                .save(consumer, setLocation(MODID, "textiles/paper/emerald_smooth_wove_paper"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.EMERALD_WOVE_PAPER.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', TCItems.EMERALD_FIBER.get())
                .unlockedBy("has_emerald_fiber", has(TCItems.EMERALD_FIBER.get()))
                .save(consumer, setLocation(MODID, "textiles/paper/emerald_wove_paper"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.EMERALD_COARSE_WOVE_PAPER.get(), 1)
                .pattern("##")
                .define('#', TCItems.EMERALD_FIBER.get())
                .unlockedBy("has_emerald_fiber", has(TCItems.EMERALD_FIBER.get()))
                .save(consumer, setLocation(MODID, "textiles/paper/emerald_coarse_wove_paper"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.LUCKY_FIBER.get(), 1)
                .pattern("###")
                .pattern("#C#")
                .pattern("###")
                .define('#', TCItemTags.CURRENCY_FIBER)
                .define('C', TCItems.LUCKY_COIN.get())
                .unlockedBy("has_lucky_coin", has(TCItems.LUCKY_COIN.get()))
                .save(consumer, setLocation(MODID, "textiles/fiber/lucky_fiber"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.LUCKY_THREAD.get(), 1)
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.LUCKY_FIBER.get())
                .unlockedBy("has_lucky_fiber", has(TCItems.LUCKY_FIBER.get()))
                .save(consumer, setLocation(MODID, "textiles/thread/lucky_thread"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.LUCKY_FABRIC.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.LUCKY_THREAD.get())
                .unlockedBy("has_lucky_thread", has(TCItems.LUCKY_THREAD.get()))
                .save(consumer, setLocation(MODID, "textiles/fabric/lucky_fabric"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.ENDONIAN_FIBER.get(), 1)
                .pattern("###")
                .pattern("#C#")
                .pattern("###")
                .define('#', TCItemTags.CURRENCY_FIBER)
                .define('C', TCItems.ENDONIAN_NUGGET.get())
                .unlockedBy("has_endonian_nugget", has(TCItems.ENDONIAN_NUGGET.get()))
                .save(consumer, setLocation(MODID, "textiles/fiber/endonian_fiber"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.ENDONIAN_THREAD.get(), 1)
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.ENDONIAN_FIBER.get())
                .unlockedBy("has_endonian_fiber", has(TCItems.ENDONIAN_FIBER.get()))
                .save(consumer, setLocation(MODID, "textiles/thread/endonian_thread"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.ECHO_FIBER.get(), 1)
                .pattern("###")
                .pattern("#C#")
                .pattern("###")
                .define('#', TCItems.ENDONIAN_FIBER.get())
                .define('C', Items.ECHO_SHARD)
                .unlockedBy("has_echo_shard", has(Items.ECHO_SHARD))
                .save(consumer, setLocation(MODID, "textiles/fiber/echo_fiber"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.ECHO_THREAD.get(), 1)
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.ECHO_FIBER.get())
                .unlockedBy("has_echo_fiber", has(TCItems.ECHO_FIBER.get()))
                .save(consumer, setLocation(MODID, "textiles/thread/echo_thread"));
    }

    private static void materialBlockRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.ENDONIAN_BLOCK.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItemTags.ENDONIAN_INGOT)
                .unlockedBy("has_endonian_ingot", has(TCItemTags.ENDONIAN_INGOT))
                .save(consumer, setLocation(MODID, "blocks/from_ingots/endonian_block"));
    }

    private static void currencyRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.COPPER_COIN.get(), 9)
                .requires(TCBlocks.COPPER_COIN_BAG.get())
                .unlockedBy("has_copper_bag", has(TCBlocks.COPPER_COIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/copper_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.IRON_COIN.get(), 9)
                .requires(TCBlocks.IRON_COIN_BAG.get())
                .unlockedBy("has_iron_bag", has(TCBlocks.IRON_COIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/iron_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.GOLD_COIN.get(), 9)
                .requires(TCBlocks.GOLD_COIN_BAG.get())
                .unlockedBy("has_gold_bag", has(TCBlocks.GOLD_COIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/gold_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.NETHERITE_COIN.get(), 9)
                .requires(TCBlocks.NETHERITE_COIN_BAG.get())
                .unlockedBy("has_netherite_bag", has(TCBlocks.NETHERITE_COIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/netherite_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.ENDONIAN_COIN.get(), 9)
                .requires(TCBlocks.ENDONIAN_COIN_BAG.get())
                .unlockedBy("has_endonian_bag", has(TCBlocks.ENDONIAN_COIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/endonian_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.NETHER_GOLD_COIN.get(), 9)
                .requires(TCBlocks.NETHER_GOLD_COIN_BAG.get())
                .unlockedBy("has_nether_gold_bag", has(TCBlocks.NETHER_GOLD_COIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/nether_gold_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.LUCKY_COIN.get(), 9)
                .requires(TCBlocks.LUCKY_COIN_BAG.get())
                .unlockedBy("has_lucky_coin_bag", has(TCBlocks.LUCKY_COIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/lucky_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.EMERALD_QUARTER_BANK_NOTE.get(), 9)
                .requires(TCBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get())
                .unlockedBy("has_emerald_quarter_note_bag", has(TCBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/emerald_quarter_bank_notes"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.EMERALD_HALF_BANK_NOTE.get(), 9)
                .requires(TCBlocks.EMERALD_HALF_BANK_NOTE_BAG.get())
                .unlockedBy("has_emerald_half_note_bag", has(TCBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/emerald_half_bank_notes"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.EMERALD_BANK_NOTE.get(), 9)
                .requires(TCBlocks.EMERALD_BANK_NOTE_BAG.get())
                .unlockedBy("has_emerald_note_bag", has(TCBlocks.EMERALD_BANK_NOTE_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/emerald_bank_notes"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.LAPIS_FLORIN.get(), 9)
                .requires(TCBlocks.LAPIS_FLORIN_BAG.get())
                .unlockedBy("has_lapis_coin_bag", has(TCBlocks.LAPIS_FLORIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/lapis_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.AMETHYST_FLORIN.get(), 9)
                .requires(TCBlocks.AMETHYST_FLORIN_BAG.get())
                .unlockedBy("has_amethyst_coin_bag", has(TCBlocks.AMETHYST_FLORIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/amethyst_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.DIAMOND_FLORIN.get(), 9)
                .requires(TCBlocks.DIAMOND_FLORIN_BAG.get())
                .unlockedBy("has_diamond_coin_bag", has(TCBlocks.DIAMOND_FLORIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/diamond_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.EMERALD_FLORIN.get(), 9)
                .requires(TCBlocks.EMERALD_FLORIN_BAG.get())
                .unlockedBy("has_emerald_coin_bag", has(TCBlocks.EMERALD_FLORIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/emerald_coins"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.ECHO_FLORIN.get(), 9)
                .requires(TCBlocks.ECHO_COIN_BAG.get())
                .unlockedBy("has_echo_coin_bag", has(TCBlocks.ECHO_COIN_BAG.get()))
                .save(consumer, setLocation(MODID, "currency/from_bag/echo_coins"));
    }

    private static void currencyBagRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.COPPER_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.COPPER_COIN.get())
                .unlockedBy("has_copper_coin", has(TCItems.COPPER_COIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/copper_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.IRON_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.IRON_COIN.get())
                .unlockedBy("has_iron_coin", has(TCItems.IRON_COIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/iron_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.GOLD_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.GOLD_COIN.get())
                .unlockedBy("has_gold_coin", has(TCItems.GOLD_COIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/gold_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.NETHERITE_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.NETHERITE_COIN.get())
                .unlockedBy("has_netherite_coin", has(TCItems.NETHERITE_COIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/netherite_coin_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.ENDONIAN_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.ENDONIAN_COIN.get())
                .unlockedBy("has_endonian_coin", has(TCItems.ENDONIAN_COIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/endonian_coin_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.NETHER_GOLD_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.NETHER_GOLD_COIN.get())
                .unlockedBy("has_nether_gold_coin", has(TCItems.NETHER_GOLD_COIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/nether_gold_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.LUCKY_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.LUCKY_COIN.get())
                .unlockedBy("has_lucky_coin", has(TCItems.LUCKY_COIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/lucky_coin_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.EMERALD_QUARTER_BANK_NOTE.get())
                .unlockedBy("has_emerald_quarter_note", has(TCItems.EMERALD_QUARTER_BANK_NOTE.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/emerald_quarter_bank_note_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.EMERALD_HALF_BANK_NOTE_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.EMERALD_HALF_BANK_NOTE.get())
                .unlockedBy("has_emerald_half_note", has(TCItems.EMERALD_HALF_BANK_NOTE.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/bank_notes_to_bags/emerald_half_bank_note_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.EMERALD_BANK_NOTE_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.EMERALD_BANK_NOTE.get())
                .unlockedBy("has_emerald_note", has(TCItems.EMERALD_BANK_NOTE.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/emerald_bank_note_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.LAPIS_FLORIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.LAPIS_FLORIN.get())
                .unlockedBy("has_lapis_coin", has(TCItems.LAPIS_FLORIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/lapis_coin_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.AMETHYST_FLORIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.AMETHYST_FLORIN.get())
                .unlockedBy("has_amethyst_coin", has(TCItems.AMETHYST_FLORIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/amethyst_coin_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.DIAMOND_FLORIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.DIAMOND_FLORIN.get())
                .unlockedBy("has_diamond_coin", has(TCItems.DIAMOND_FLORIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/diamond_coin_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.EMERALD_FLORIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.EMERALD_FLORIN.get())
                .unlockedBy("has_emerald_coin", has(TCItems.EMERALD_FLORIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/emerald_coin_bag"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCBlocks.ECHO_COIN_BAG.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItems.ECHO_FLORIN.get())
                .unlockedBy("has_echo_coin", has(TCItems.ECHO_FLORIN.get()))
                .save(consumer, setLocation(MODID, "storage_blocks/echo_coin_bag"));
    }

    private static void nuggetRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.LUCKY_NUGGET.get(), 1)
                .pattern("###")
                .pattern(" # ")
                .pattern("###")
                .define('#', TCItems.FOUR_LEAF_CLOVER.get())
                .unlockedBy("has_four_leaf_clover", has(TCItems.FOUR_LEAF_CLOVER.get()))
                .save(consumer, setLocation(MODID, "nuggets/from_other/lucky_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.COPPER_NUGGET.get(), 9)
                .requires(TCItemTags.COPPER_INGOT)
                .unlockedBy("has_copper_ingot", has(TCItemTags.COPPER_INGOT))
                .save(consumer, setLocation(MODID, "nuggets/from_ingots/copper_nugget"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.NETHERITE_NUGGET.get(), 9)
                .requires(TCItemTags.NETHERITE_INGOT)
                .unlockedBy("has_netherite_ingot", has(TCItemTags.NETHERITE_INGOT))
                .save(consumer, setLocation(MODID, "nuggets/from_ingots/netherite_nugget"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.ENDONIAN_NUGGET.get(), 9)
                .requires(TCItemTags.ENDONIAN_INGOT)
                .unlockedBy("has_endonian_ingot", has(TCItemTags.ENDONIAN_INGOT))
                .save(consumer, setLocation(MODID, "nuggets/from_ingots/endonian_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.COPPER_NUGGET.get())
                .requires(TCItems.COPPER_COIN.get(), 2)
                .unlockedBy("has_copper_coin", has(TCItemTags.COPPER_NUGGET))
                .save(consumer, setLocation(MODID, "nuggets/from_coins/copper_nugget"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_NUGGET)
                .requires(TCItems.IRON_COIN.get(), 2)
                .unlockedBy("has_iron_coin", has(TCItemTags.IRON_NUGGET))
                .save(consumer, setLocation(MODID, "nuggets/from_coins/iron_nugget"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_NUGGET)
                .requires(TCItems.GOLD_COIN.get(), 2)
                .unlockedBy("has_gold_coin", has(TCItemTags.GOLD_NUGGET))
                .save(consumer, setLocation(MODID, "nuggets/from_coins/gold_nugget"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.NETHERITE_NUGGET.get())
                .requires(TCItems.NETHERITE_COIN.get(), 2)
                .unlockedBy("has_netherite_coin", has(TCItemTags.NETHERITE_NUGGET))
                .save(consumer, setLocation(MODID, "nuggets/from_coins/netherite_nugget"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.ENDONIAN_NUGGET.get())
                .requires(TCItems.ENDONIAN_COIN.get(), 2)
                .unlockedBy("has_endonian_coin", has(TCItemTags.ENDONIAN_NUGGET))
                .save(consumer, setLocation(MODID, "nuggets/from_coins/endonian_nugget"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.LUCKY_NUGGET.get())
                .requires(TCItems.LUCKY_COIN.get(), 2)
                .unlockedBy("has_lucky_coin", has(TCItems.LUCKY_COIN.get()))
                .save(consumer, setLocation(MODID, "nuggets/from_coins/lucky_nugget"));
    }

    private static void ingotRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COPPER_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItemTags.COPPER_NUGGET)
                .unlockedBy("has_copper_nugget", has(TCItemTags.COPPER_NUGGET))
                .save(consumer, setLocation(MODID, "ingots/from_nuggets/copper_ingot"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NETHERITE_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItemTags.NETHERITE_NUGGET)
                .unlockedBy("has_netherite_nugget", has(TCItemTags.NETHERITE_NUGGET))
                .save(consumer, setLocation(MODID, "ingots/ingot_from_nuggets/netherite_ingot"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.ENDONIAN_INGOT.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCItemTags.ENDONIAN_NUGGET)
                .unlockedBy("has_endonian_nugget", has(TCItemTags.ENDONIAN_NUGGET))
                .save(consumer, setLocation(MODID, "ingots/ingot_from_nuggets/endonian_ingot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCItems.ENDONIAN_INGOT.get(), 9)
                .requires(TCBlocks.ENDONIAN_BLOCK.get())
                .unlockedBy("has_endonian_block", has(TCBlocks.ENDONIAN_BLOCK.get()))
                .save(consumer, setLocation(MODID, "ingots/from_blocks/endonian_ingot"));
    }

    private static void armorRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TCItems.LUCKY_HAT.get(), 1)
                .pattern("CCC")
                .pattern("C C")
                .define('C', TCItems.LUCKY_FABRIC.get())
                .unlockedBy("has_lucky_fabric", has(TCItems.LUCKY_FABRIC.get()))
                .save(consumer, setLocation(MODID, "armor/lucky_fabric/lucky_hat"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TCItems.LUCKY_SHIRT.get(), 1)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', TCItems.LUCKY_FABRIC.get())
                .unlockedBy("has_lucky_fabric", has(TCItems.LUCKY_FABRIC.get()))
                .save(consumer, setLocation(MODID, "armor/lucky_fabric/lucky_shirt"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TCItems.LUCKY_BOOTS.get(), 1)
                .pattern("C C")
                .pattern("C C")
                .define('C', TCItems.LUCKY_FABRIC.get())
                .unlockedBy("has_lucky_fabric", has(TCItems.LUCKY_FABRIC.get()))
                .save(consumer, setLocation(MODID, "armor/lucky_fabric/lucky_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TCItems.LUCKY_PANTS.get(), 1)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', TCItems.LUCKY_FABRIC.get())
                .unlockedBy("has_lucky_fabric", has(TCItems.LUCKY_FABRIC.get()))
                .save(consumer, setLocation(MODID, "armor/lucky_fabric/lucky_pants"));
    }

    private static void jobBlockRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TCBlocks.COINPRESSBLOCK.get(), 1)
                .pattern("III")
                .pattern("DID")
                .pattern("PPP")
                .define('I', Items.IRON_INGOT)
                .define('D', Items.POLISHED_DEEPSLATE)
                .define('P', ItemTags.PLANKS)
                .unlockedBy("has_polished_deepslate", has(Items.POLISHED_DEEPSLATE))
                .save(consumer, setLocation(MODID, "job_blocks/coin_press"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TCBlocks.POT_OF_GOLD.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', TCBlocks.GOLD_COIN_BAG.get())
                .unlockedBy("has_gold_coin_bag", has(TCBlocks.GOLD_COIN_BAG.get()))
                .save(consumer, setLocation(MODID, "job_blocks/pot_of_gold"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TCBlocks.GOLD_COIN_BAG.get(), 9)
                .requires(TCBlocks.POT_OF_GOLD.get())
                .unlockedBy("has_pot_of_gold", has(TCBlocks.POT_OF_GOLD.get()))
                .save(consumer, setLocation(MODID, "currency/bags_of_gold_from_pot_of_gold"));
    }

    private static void currencyStampsRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.CURRENCY_STAMP.get(), 1)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" S ")
                .define('S', Items.SMOOTH_STONE_SLAB)
                .define('C', Items.COBBLESTONE)
                .unlockedBy("has_smooth_stone", has(Items.SMOOTH_STONE_SLAB))
                .save(consumer, setLocation(MODID, "currency_stamps/currency_stamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.NETHER_CURRENCY_STAMP.get(), 1)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" S ")
                .define('S', Items.BLACKSTONE_SLAB)
                .define('C', Items.CHISELED_POLISHED_BLACKSTONE)
                .unlockedBy("has_chiseled_polished_blackstone", has(Items.CHISELED_POLISHED_BLACKSTONE))
                .save(consumer, setLocation(MODID, "currency_stamps/nether_currency_stamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.ENDONIAN_CURRENCY_STAMP.get(), 1)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" S ")
                .define('S', Items.PURPUR_SLAB)
                .define('C', Items.ENDER_EYE)
                .unlockedBy("has_purpur_slab", has(Items.PURPUR_SLAB))
                .save(consumer, setLocation(MODID, "currency_stamps/endonian_currency_stamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TCItems.GEM_CURRENCY_STAMP.get(), 1)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" S ")
                .define('S', Items.POLISHED_DEEPSLATE_SLAB)
                .define('C', Items.DEEPSLATE_TILES)
                .unlockedBy("has_deepslate", has(Items.COBBLED_DEEPSLATE))
                .save(consumer, setLocation(MODID, "currency_stamps/gem_currency_stamp"));
    }

    private static void chocolateCoinRecipeTemplate(Consumer<FinishedRecipe> consumer, Item result, int resultAmount, @Nullable Item flavorA, @Nullable Item flavorB, @Nullable TagKey<Item> flavorTagA, @Nullable TagKey<Item> flavorTagB) {
        RemainderShapelessRecipeBuilder builder = RemainderShapelessRecipeBuilder
                .shapelessRemainderRecipe(RecipeCategory.FOOD, result, resultAmount)
                .group("chocolate_coins")
                .addIngredient(TCItemTags.COCOA_INGREDIENTS)
                .addIngredient(TCItemTags.SWEETENER)
                .addIngredient(TCItemTags.MILK)
                .addIngredient(TCItemTags.FAT);

        int ingredientCount = 4; // base ingredients

        // flavor A (must be either item or tag if used)
        if (flavorA != null) {
            builder.addIngredient(flavorA);
            ingredientCount++;
        }
        else if (flavorTagA != null) {
            builder.addIngredient(flavorTagA);
            ingredientCount++;
        }

        // flavor B (must be either item or tag if used)
        if (flavorB != null) {
            builder.addIngredient(flavorB);
            ingredientCount++;
        }
        else if (flavorTagB != null) {
            builder.addIngredient(flavorTagB);
            ingredientCount++;
        }

        // enforce exactly 6 ingredients
        if (ingredientCount != 6) {
            throw new IllegalArgumentException("Chocolate coin recipe for " + result + " must have exactly 6 ingredients (found " + ingredientCount + ")");
        }

        builder.unlockedBy("has_cocoa", has(TCItemTags.COCOA_INGREDIENTS))
                .build(consumer, setLocation(MODID, "chocolate_coins/" + result));
    }
}