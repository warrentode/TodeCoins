package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.item.ModItems;
import com.google.common.collect.Sets;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AdvancementsGen extends AdvancementProvider {
    private final Path PATH;

    private static String cageriumPath = "cagerium/recipes/spawn_eggs/";

    public AdvancementsGen(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, fileHelperIn);
        PATH = generatorIn.getOutputFolder();
    }

    private static Path getPath(Path pathIn, Advancement advancementIn) {
        return pathIn.resolve("data/" + advancementIn.getId().getNamespace() + "/advancements/" + advancementIn.getId().getPath() + ".json");
    }

    @Override
    public void run(CachedOutput cache) {
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (advancement) -> {
            if (!set.add(advancement.getId())) {
                throw new IllegalStateException("Duplicate advancement " + advancement.getId());
            }
            else {
                Path path1 = getPath(PATH, advancement);
                try {
                    DataProvider.saveStable(cache, advancement.deconstruct().serializeToJson(), path1);
                }
                catch (IOException ioException) {
                    TodeCoins.LOGGER.error("Couldn't save advancement {}", path1, ioException);
                }
            }
        };

        new TodeCoinsAdvancements().accept(consumer);
    }

    public static class TodeCoinsAdvancements implements Consumer<Consumer<Advancement>> {
        protected static Advancement.Builder getAdvancement(Advancement parent, ItemLike display, String name,
                                                            FrameType frame, boolean showToast,
                                                            boolean announceToChat, boolean hidden) {
            return Advancement.Builder.advancement()
                    .parent(parent).display(display,
                            Component.translatable("advancement." + name),
                            Component.translatable("advancement." + name + ".desc"),
                            null, frame, showToast, announceToChat, hidden);
        }

        public void accept(Consumer<Advancement> consumer) {
            Advancement todeCoins = Advancement.Builder.advancement().display(ModItems.GOLD_COIN.get(),
                    Component.translatable("advancement.root"), Component.translatable("advancement.root.desc"),
                    new ResourceLocation("todecoins:textures/block/pot.png"),
                    FrameType.TASK, false, false, false).addCriterion("trade",
                    InventoryChangeTrigger.TriggerInstance
                            .hasItems(new ItemLike[]{})).save(consumer, getPath("main" + "/root"));

            // Craft Coin Press
            Advancement craftCoinPress = getAdvancement(todeCoins, ModBlocks.COINPRESSBLOCK.get(),
                    "craftCoinPress", FrameType.TASK, true, true, false)
                    .addCriterion("craft_coinpress",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COINPRESSBLOCK.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/craft_coinpress"));

            // Lucky Clover
            Advancement luckyClover = getAdvancement(todeCoins, ModItems.FOUR_LEAF_CLOVER.get(),
                    "luckyClover", FrameType.CHALLENGE, true, true, false)
                    .addCriterion("find_four_leaf_clover",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOUR_LEAF_CLOVER.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/lucky_clover"));

            // Lucky Pennies
            Advancement luckyPenny = getAdvancement(todeCoins, ModItems.LUCKY_COIN.get(),
                    "luckyPenny", FrameType.CHALLENGE, true, true, false)
                    .parent(luckyClover)
                    .addCriterion("craft_lucky_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_COIN.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/lucky_penny"));

            // Emerald Textile Engineering
            Advancement textileEngineering1 = getAdvancement(todeCoins, ModItems.EMERALD_FIBER.get(),
                    "textileEngineering1", FrameType.TASK, true, true, false)
                    .parent(craftCoinPress)
                    .addCriterion("craft_emerald_fiber",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_FIBER.get()))
                    .addCriterion("craft_coarse_wove_paper",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_COARSE_WOVE_PAPER.get()))
                    .addCriterion("craft_emerald_wove_paper",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_WOVE_PAPER.get()))
                    .addCriterion("craft_emerald_smooth_paper",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_SMOOTH_WOVE_PAPER.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/textile_engineering_1"));

            // Lucky Textile Engineering
            Advancement textileEngineering2 = getAdvancement(todeCoins, ModItems.LUCKY_THREAD.get(),
                    "textileEngineering2", FrameType.TASK, true, true, false)
                    .parent(luckyClover).parent(luckyPenny)
                    .addCriterion("craft_lucky_fiber",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_FIBER.get()))
                    .addCriterion("craft_lucky_thread",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_THREAD.get()))
                    .addCriterion("craft_lucky_fabric",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_FABRIC.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/textile_engineering_2"));

            // Minting Coins
            Advancement mintingCoins = getAdvancement(todeCoins, ModItems.CURRENCY_STAMP.get(),
                    "mintingCoins", FrameType.TASK, true, true, false)
                    .parent(craftCoinPress)
                    .addCriterion("craft_coin_press",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COINPRESSBLOCK.get()))
                    .addCriterion("craft_currency_stamp",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                    .addCriterion("craft_copper_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COIN.get()))
                    .addCriterion("craft_iron_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COIN.get()))
                    .addCriterion("craft_gold_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COIN.get()))
                    .addCriterion("craft_netherite_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COIN.get()))
                    .addCriterion("craft_endonian_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDONIAN_COIN.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/minting_coins"));

            // Printing Notes
            Advancement printingMoney = getAdvancement(todeCoins, ModItems.EMERALD_BANK_NOTE.get(),
                    "printingMoney", FrameType.TASK, true, true, false)
                    .parent(mintingCoins).parent(textileEngineering1)
                    .addCriterion("craft_emerald_quarter_bank_note",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_QUARTER_BANK_NOTE.get()))
                    .addCriterion("craft_emerald_half_bank_note",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_HALF_BANK_NOTE.get()))
                    .addCriterion("craft_emerald_bank_note",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_BANK_NOTE.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/printing_money"));

            // Nether Dough
            Advancement netherDough = getAdvancement(todeCoins, ModItems.NETHER_GOLD_COIN.get(),
                    "netherDough", FrameType.TASK, true, true, false)
                    .parent(mintingCoins)
                    .addCriterion("craft_nether_currency_stamp",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHER_CURRENCY_STAMP.get()))
                    .addCriterion("craft_nether_gold_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHER_GOLD_COIN.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/nether_dough"));

            // Heavenly Coin
            Advancement otherworldlyCoin = getAdvancement(todeCoins, ModItems.ENDONIAN_COIN.get(),
                    "otherworldlyCoin", FrameType.TASK, true, true, false)
                    .parent(mintingCoins)
                    .addCriterion("craft_endonian_currency_stamp",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDONIAN_CURRENCY_STAMP.get()))
                    .addCriterion("craft_endonian_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDONIAN_COIN.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/otherworldly_coin"));

            // Money to Burn
            Advancement baggingDough = getAdvancement(todeCoins, ModBlocks.GOLD_COIN_BAG.get(),
                    "baggingDough", FrameType.TASK, true, true, false)
                    .parent(textileEngineering1).parent(mintingCoins).parent(printingMoney).parent(netherDough)
                    .addCriterion("craft_copper_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COPPER_COIN_BAG.get()))
                    .addCriterion("craft_iron_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_COIN_BAG.get()))
                    .addCriterion("craft_gold_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GOLD_COIN_BAG.get()))
                    .addCriterion("craft_netherite_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHERITE_COIN_BAG.get()))
                    .addCriterion("craft_emerald_quarter_bank_note_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()))
                    .addCriterion("craft_emerald_half_bank_note_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()))
                    .addCriterion("craft_emerald_bank_note_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMERALD_BANK_NOTE_BAG.get()))
                    .addCriterion("craft_nether_gold_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHER_GOLD_COIN_BAG.get()))
                    .addCriterion("craft_endonian_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ENDONIAN_COIN_BAG.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/bagging_dough"));

            // Rainbow's End
            Advancement rainbowEnd = getAdvancement(todeCoins, ModBlocks.POT_OF_GOLD.get(),
                    "rainbowEnd", FrameType.GOAL, true, true, false)
                    .parent(baggingDough)
                    .addCriterion("craft_pot_of_gold",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.POT_OF_GOLD.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/rainbows_end"));

            // Lucky Armor Set
            Advancement luckyArmor = getAdvancement(todeCoins, ModItems.LUCKY_SHIRT.get(),
                    "luckyArmor", FrameType.GOAL, true, true, false)
                    .parent(textileEngineering2)
                    .addCriterion("craft_lucky_shirt",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_SHIRT.get()))
                    .addCriterion("craft_lucky_pants",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_PANTS.get()))
                    .addCriterion("craft_lucky_hat",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_HAT.get()))
                    .addCriterion("craft_lucky_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_BOOTS.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/lucky_armor"));

            // Vanilla Collectible Coins
            Advancement collectibleCoins = getAdvancement(todeCoins, ModItems.COPPER_HERO_COIN.get(),
                    "collectibleCoins", FrameType.CHALLENGE, true, true, false)
                    // holiday coins
                    .addCriterion("find_" + ModItems.BIRTHDAY_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BIRTHDAY_COIN_2023.get()))
                    .addCriterion("find_" + ModItems.HALLOWEEN_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HALLOWEEN_COIN_2023.get()))
                    .addCriterion("find_" + ModItems.CHRISTMAS_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHRISTMAS_COIN_2023.get()))

                    .addCriterion("find_" + ModItems.MARSHALL_NASH_CARNATION_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MARSHALL_NASH_CARNATION_COIN.get()))
                    .addCriterion("find_" + ModItems.MARSHALL_NASH_COSMOS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MARSHALL_NASH_COSMOS_COIN.get()))

                    .addCriterion("find_" + ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get()))
                    .addCriterion("find_" + ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get()))

                    // gameplay coins
                    .addCriterion("find_" + ModItems.COPPER_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HERO_COIN.get()))

                    // entity coins
                    .addCriterion("find_" + ModItems.COPPER_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ALLAY_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_AXOLOTL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_AXOLOTL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_AXOLOTL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_AXOLOTL_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_BAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_BAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_BAT_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BEE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_BEE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_BEE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_BEE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BLAZE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_BLAZE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_BLAZE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_BLAZE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAT_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAVE_SPIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAVE_SPIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAVE_SPIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAVE_SPIDER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CHICKEN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CHICKEN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CHICKEN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CHICKEN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COD_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COD_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COD_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COD_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COW_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CREEPER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CREEPER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CREEPER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CREEPER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DOLPHIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DOLPHIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DOLPHIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DOLPHIN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DONKEY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DONKEY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DONKEY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DONKEY_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DROWNED_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DROWNED_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DROWNED_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DROWNED_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ELDER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ELDER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ELDER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDERMAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDERMAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDERMAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDERMAN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDERMITE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDERMITE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDERMITE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDERMITE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_EVOKER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_EVOKER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_EVOKER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_EVOKER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_FOX_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_FROG_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GHAST_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GOAT_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GUARDIAN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GLOW_SQUID_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HOGLIN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HORSE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HUSK_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HUSK_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HUSK_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HUSK_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_IRON_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_IRON_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_IRON_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_IRON_GOLEM_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_LLAMA_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MAGMA_CUBE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MAGMA_CUBE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MAGMA_CUBE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MAGMA_CUBE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MOOSHROOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MOOSHROOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MOOSHROOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MOOSHROOM_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MULE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MULE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MULE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MULE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_NUMISMATIST_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_NUMISMATIST_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_NUMISMATIST_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_NUMISMATIST_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_OCELOT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_OCELOT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_OCELOT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_OCELOT_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PANDA_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PANDA_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PANDA_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PANDA_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PARROT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PARROT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PARROT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PARROT_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PHANTOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PHANTOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PHANTOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PHANTOM_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIG_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIG_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIG_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIG_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PILLAGER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_POLAR_BEAR_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_POLAR_BEAR_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_POLAR_BEAR_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_POLAR_BEAR_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PUFFERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PUFFERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PUFFERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PUFFERFISH_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_RABBIT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_RABBIT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_RABBIT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_RABBIT_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_RAVAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_RAVAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_RAVAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_RAVAGER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SALMON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SALMON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SALMON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SALMON_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SHEEP_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SHEEP_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SHEEP_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SHEEP_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SHULKER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SHULKER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SHULKER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SHULKER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SILVERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SILVERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SILVERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SILVERFISH_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SKELETON_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SKELETON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SKELETON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SKELETON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SKELETON_HORSE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SLIME_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SLIME_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SLIME_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SLIME_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SNOW_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SNOW_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SNOW_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SNOW_GOLEM_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SQUID_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_STRAY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_STRAY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_STRAY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_STRAY_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_STRIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_STRIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_STRIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_STRIDER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TADPOLE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TADPOLE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TADPOLE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TADPOLE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TRADER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TRADER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TRADER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TRADER_LLAMA_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TROPICAL_FISH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TROPICAL_FISH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TROPICAL_FISH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TROPICAL_FISH_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TURTLE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TURTLE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TURTLE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TURTLE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_VEX_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_VEX_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_VEX_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_VEX_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_VILLAGER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_VINDICATOR_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_VINDICATOR_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_VINDICATOR_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_VINDICATOR_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WANDERING_TRADER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WANDERING_TRADER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WANDERING_TRADER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WANDERING_TRADER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WOLF_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/collectible_coins"));

            // TODO change the icon for this to the crab coin when it's made and added to represent this achievement tree
            // Ecologics Collectible Coins
            Advancement collectibleEcologicsCoins = getAdvancement(todeCoins, ModItems.COPPER_CAMEL_COIN.get(),
                    "collectibleEcologicsCoins", FrameType.CHALLENGE, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAMEL_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/collectible_ecologics_coins"));

            // Friends and Foes Collectible Coins
            Advancement collectibleFriendsAndFoesCoins = getAdvancement(todeCoins, ModItems.COPPER_MOOBLOOM_COIN.get(),
                    "collectibleFriendsAndFoesCoins", FrameType.CHALLENGE, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MOOBLOOM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/collectible_friendsandfoes_coins"));

            // Upcoming Version Collectible Coins
            Advancement collectibleUpcomingCoins = getAdvancement(todeCoins, ModItems.COPPER_SNIFFER_COIN.get(),
                    "collectibleUpcomingCoins", FrameType.CHALLENGE, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAMEL_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SNIFFER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/collectible_upcoming_coins"));
        }

        private String getPath(String id) {
            return TodeCoins.MODID + ":" + id;
        }
    }
}