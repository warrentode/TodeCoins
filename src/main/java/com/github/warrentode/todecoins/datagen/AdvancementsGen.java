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

            // Obtain all Collectible Coins
            Advancement collectibleCoins = getAdvancement(todeCoins, ModItems.COPPER_HERO_COIN.get(),
                    "collectibleCoins", FrameType.CHALLENGE, true, true, false)
                    .parent(todeCoins)

                    .addCriterion("find_" + ModItems.SCHOLAR_OWL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SCHOLAR_OWL_COIN.get()))
                    .addCriterion("find_" + ModItems.TUXEDO_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TUXEDO_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.LITTLE_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LITTLE_BEAR_COIN.get()))

                    .addCriterion("find_" + ModItems.MARSHALL_NASH_CARNATION_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MARSHALL_NASH_CARNATION_COIN.get()))
                    .addCriterion("find_" + ModItems.MARSHALL_NASH_COSMOS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MARSHALL_NASH_COSMOS_COIN.get()))

                    .addCriterion("find_" + ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get()))
                    .addCriterion("find_" + ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get()))

                    .addCriterion("find_" + ModItems.BIRTHDAY_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BIRTHDAY_COIN_2023.get()))
                    .addCriterion("find_" + ModItems.HALLOWEEN_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HALLOWEEN_COIN_2023.get()))
                    .addCriterion("find_" + ModItems.CHRISTMAS_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHRISTMAS_COIN_2023.get()))
                    .addCriterion("find_" + ModItems.EASTER_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EASTER_COIN_2023.get()))

                    .addCriterion("find_" + ModItems.COPPER_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ALLAY_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ARMADILLO_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ARMADILLO_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ARMADILLO_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ARMADILLO_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAMEL_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COPPER_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COPPER_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COPPER_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COPPER_GOLEM_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COW_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CRAB_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CRAB_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CRAB_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CRAB_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDER_DRAGON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDER_DRAGON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDER_DRAGON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDER_DRAGON_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_FROG_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_FOX_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GHAST_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GIANT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GIANT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GIANT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GIANT_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GOAT_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GLARE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GLARE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GLARE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GLARE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GLOW_SQUID_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GUARD_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GUARD_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GUARD_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GUARD_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GUARDIAN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HERO_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ICEOLOGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ICEOLOGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ICEOLOGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ICEOLOGER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ILLUSIONER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ILLUSIONER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ILLUSIONER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ILLUSIONER_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MAULER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MAULER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MAULER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MAULER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MOOBLOOM_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PENGUIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PENGUIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PENGUIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PENGUIN_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_MERCHANT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_MERCHANT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_MERCHANT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_RASCAL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_RASCAL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_RASCAL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_RASCAL_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SNIFFER_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SQUIRREL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SQUIRREL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SQUIRREL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SQUIRREL_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TUFF_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TUFF_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TUFF_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TUFF_GOLEM_COIN.get()))

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

                    .addCriterion("find_" + ModItems.COPPER_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WARDEN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WARDEN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WARDEN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WARDEN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WILDFIRE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WILDFIRE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WILDFIRE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WILDFIRE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WITCH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WITCH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WITCH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WITCH_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WITHER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WITHER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WITHER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WITHER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WITHER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WITHER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WITHER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WITHER_SKELETON_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WOLF_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOGLIN_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get()))

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/all_coins"));

            Advancement lifetimePatronCoinSet = getAdvancement(todeCoins, ModItems.SCHOLAR_OWL_COIN.get(),
                    "lifetimePatronCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.SCHOLAR_OWL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SCHOLAR_OWL_COIN.get()))
                    .addCriterion("find_" + ModItems.TUXEDO_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TUXEDO_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.LITTLE_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LITTLE_BEAR_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/lifetime_patron_coins"));

            Advancement patronNashCoinSet = getAdvancement(todeCoins, ModItems.MARSHALL_NASH_CARNATION_COIN.get(),
                    "patronNashCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.MARSHALL_NASH_CARNATION_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MARSHALL_NASH_CARNATION_COIN.get()))
                    .addCriterion("find_" + ModItems.MARSHALL_NASH_COSMOS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MARSHALL_NASH_COSMOS_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/patron_nash_coins"));

            Advancement patronBranniganCoinSet = getAdvancement(todeCoins, ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get(),
                    "patronBranniganCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get()))
                    .addCriterion("find_" + ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/patron_brannigan_coins"));

            Advancement holidayCoinSet = getAdvancement(todeCoins, ModItems.CHRISTMAS_COIN_2023.get(),
                    "holidayCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.BIRTHDAY_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BIRTHDAY_COIN_2023.get()))
                    .addCriterion("find_" + ModItems.HALLOWEEN_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HALLOWEEN_COIN_2023.get()))
                    .addCriterion("find_" + ModItems.CHRISTMAS_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHRISTMAS_COIN_2023.get()))
                    .addCriterion("find_" + ModItems.EASTER_COIN_2023.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EASTER_COIN_2023.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/holiday_coins"));

            Advancement allayCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ALLAY_COIN.get(),
                    "allayCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ALLAY_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/allay_coins"));

            Advancement armadilloCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ARMADILLO_COIN.get(),
                    "armadilloCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ARMADILLO_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ARMADILLO_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ARMADILLO_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ARMADILLO_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/armadillo_coins"));

            Advancement axolotlCoinSet = getAdvancement(todeCoins, ModItems.COPPER_AXOLOTL_COIN.get(),
                    "axolotlCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_AXOLOTL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_AXOLOTL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_AXOLOTL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_AXOLOTL_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/axolotl_coins"));

            Advancement batCoinSet = getAdvancement(todeCoins, ModItems.COPPER_BAT_COIN.get(),
                    "batCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_BAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_BAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_BAT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/bat_coins"));

            Advancement beeCoinSet = getAdvancement(todeCoins, ModItems.COPPER_BEE_COIN.get(),
                    "beeCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BEE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_BEE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_BEE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_BEE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/bee_coins"));

            Advancement blazeCoinSet = getAdvancement(todeCoins, ModItems.COPPER_BLAZE_COIN.get(),
                    "blazeCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BLAZE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_BLAZE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_BLAZE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_BLAZE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/blaze_coins"));

            Advancement camelCoinSet = getAdvancement(todeCoins, ModItems.COPPER_CAMEL_COIN.get(),
                    "camelCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAMEL_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/camel_coins"));

            Advancement catCoinSet = getAdvancement(todeCoins, ModItems.COPPER_CAT_COIN.get(),
                    "catCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/cat_coins"));

            Advancement caveSpiderCoinSet = getAdvancement(todeCoins, ModItems.COPPER_CAVE_SPIDER_COIN.get(),
                    "caveSpiderCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAVE_SPIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAVE_SPIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAVE_SPIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAVE_SPIDER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/cave_spider_coins"));

            Advancement chickenCoinSet = getAdvancement(todeCoins, ModItems.COPPER_CHICKEN_COIN.get(),
                    "chickenCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CHICKEN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CHICKEN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CHICKEN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CHICKEN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/chicken_coins"));

            Advancement codCoinSet = getAdvancement(todeCoins, ModItems.COPPER_COD_COIN.get(),
                    "codCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COD_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COD_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COD_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COD_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/cod_coins"));

            Advancement copperGolemCoinSet = getAdvancement(todeCoins, ModItems.COPPER_COPPER_GOLEM_COIN.get(),
                    "copperGolemCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COPPER_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COPPER_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COPPER_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COPPER_GOLEM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/copper_golem_coins"));

            Advancement cowCoinSet = getAdvancement(todeCoins, ModItems.COPPER_COW_COIN.get(),
                    "cowCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COW_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/cow_coins"));

            Advancement crabCoinSet = getAdvancement(todeCoins, ModItems.COPPER_CRAB_COIN.get(),
                    "crabCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CRAB_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CRAB_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CRAB_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CRAB_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/crab_coins"));

            Advancement creeperCoinSet = getAdvancement(todeCoins, ModItems.COPPER_CREEPER_COIN.get(),
                    "creeperCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CREEPER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CREEPER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CREEPER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CREEPER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/creeper_coins"));

            Advancement dolphinCoinSet = getAdvancement(todeCoins, ModItems.COPPER_DOLPHIN_COIN.get(),
                    "dolphinCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DOLPHIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DOLPHIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DOLPHIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DOLPHIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/dolphin_coins"));

            Advancement donkeyCoinSet = getAdvancement(todeCoins, ModItems.COPPER_DONKEY_COIN.get(),
                    "donkeyCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DONKEY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DONKEY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DONKEY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DONKEY_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/donkey_coins"));

            Advancement drownedCoinSet = getAdvancement(todeCoins, ModItems.COPPER_DROWNED_COIN.get(),
                    "drownedCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DROWNED_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DROWNED_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DROWNED_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DROWNED_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/drowned_coins"));

            Advancement elderGuardianCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ELDER_GUARDIAN_COIN.get(),
                    "elderGuardianCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ELDER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ELDER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ELDER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/elder_guardian_coins"));

            Advancement enderDragonCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ENDER_DRAGON_COIN.get(),
                    "enderDragonCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDER_DRAGON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDER_DRAGON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDER_DRAGON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDER_DRAGON_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/ender_dragon_coins"));

            Advancement endermanCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ENDERMAN_COIN.get(),
                    "endermanCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDERMAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDERMAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDERMAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDERMAN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/enderman_coins"));

            Advancement endermiteCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ENDERMITE_COIN.get(),
                    "endermiteCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDERMITE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDERMITE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDERMITE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDERMITE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/endermite_coins"));

            Advancement evokerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_EVOKER_COIN.get(),
                    "evokerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_EVOKER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_EVOKER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_EVOKER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_EVOKER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/evoker_coins"));

            Advancement frogCoinSet = getAdvancement(todeCoins, ModItems.COPPER_FROG_COIN.get(),
                    "frogCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_FROG_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/frog_coins"));

            Advancement foxCoinSet = getAdvancement(todeCoins, ModItems.COPPER_FOX_COIN.get(),
                    "foxCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_FOX_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/fox_coins"));

            Advancement ghastCoinSet = getAdvancement(todeCoins, ModItems.COPPER_GHAST_COIN.get(),
                    "ghastCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GHAST_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/ghast_coins"));

            Advancement giantCoinSet = getAdvancement(todeCoins, ModItems.COPPER_GIANT_COIN.get(),
                    "giantCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GIANT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GIANT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GIANT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GIANT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/giant_coins"));

            Advancement goatCoinSet = getAdvancement(todeCoins, ModItems.COPPER_GOAT_COIN.get(),
                    "goatCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GOAT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/goat_coins"));

            Advancement glareCoinSet = getAdvancement(todeCoins, ModItems.COPPER_GLARE_COIN.get(),
                    "glareCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GLARE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GLARE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GLARE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GLARE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/glare_coins"));

            Advancement glowSquidCoinSet = getAdvancement(todeCoins, ModItems.COPPER_GLOW_SQUID_COIN.get(),
                    "glowSquidCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GLOW_SQUID_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/glow_squid_coins"));

            Advancement guardVillagerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_GUARD_COIN.get(),
                    "guardVillagerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GUARD_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GUARD_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GUARD_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GUARD_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/guardvillagers_coins"));

            Advancement guardianCoinSet = getAdvancement(todeCoins, ModItems.COPPER_GUARDIAN_COIN.get(),
                    "guardianCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GUARDIAN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/guardian_coins"));

            Advancement heroCoinSet = getAdvancement(todeCoins, ModItems.COPPER_HERO_COIN.get(),
                    "heroCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HERO_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/hero_coins"));

            Advancement hoglinCoinSet = getAdvancement(todeCoins, ModItems.COPPER_HOGLIN_COIN.get(),
                    "hoglinCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HOGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/hoglin_coins"));

            Advancement horseCoinSet = getAdvancement(todeCoins, ModItems.COPPER_HORSE_COIN.get(),
                    "horseCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HORSE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/horse_coins"));

            Advancement huskCoinSet = getAdvancement(todeCoins, ModItems.COPPER_HUSK_COIN.get(),
                    "huskCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HUSK_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HUSK_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HUSK_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HUSK_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/husk_coins"));

            Advancement iceologerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ICEOLOGER_COIN.get(),
                    "iceologerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ICEOLOGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ICEOLOGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ICEOLOGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ICEOLOGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/iceologer_coins"));

            Advancement illusionerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ILLUSIONER_COIN.get(),
                    "illusionerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ILLUSIONER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ILLUSIONER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ILLUSIONER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ILLUSIONER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/illusioner_coins"));

            Advancement ironGolemCoinSet = getAdvancement(todeCoins, ModItems.COPPER_IRON_GOLEM_COIN.get(),
                    "ironGolemCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_IRON_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_IRON_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_IRON_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_IRON_GOLEM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/iron_golem_coins"));

            Advancement llamaCoinSet = getAdvancement(todeCoins, ModItems.COPPER_LLAMA_COIN.get(),
                    "llamaCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_LLAMA_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/llama_coins"));

            Advancement magmaCubeCoinSet = getAdvancement(todeCoins, ModItems.COPPER_MAGMA_CUBE_COIN.get(),
                    "magmaCubeCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MAGMA_CUBE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MAGMA_CUBE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MAGMA_CUBE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MAGMA_CUBE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/magma_cube_coins"));

            Advancement maulerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_MAULER_COIN.get(),
                    "maulerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MAULER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MAULER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MAULER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MAULER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/mauler_coins"));

            Advancement moobloomCoinSet = getAdvancement(todeCoins, ModItems.COPPER_MOOBLOOM_COIN.get(),
                    "moobloomCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MOOBLOOM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/moobloom_coins"));

            Advancement mooshroomCoinSet = getAdvancement(todeCoins, ModItems.COPPER_MOOSHROOM_COIN.get(),
                    "mooshroomCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MOOSHROOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MOOSHROOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MOOSHROOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MOOSHROOM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/mooshroom_coins"));

            Advancement muleCoinSet = getAdvancement(todeCoins, ModItems.COPPER_MULE_COIN.get(),
                    "muleCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MULE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MULE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MULE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MULE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/mule_coins"));

            Advancement numismatistCoinSet = getAdvancement(todeCoins, ModItems.COPPER_NUMISMATIST_COIN.get(),
                    "numismatistCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_NUMISMATIST_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_NUMISMATIST_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_NUMISMATIST_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_NUMISMATIST_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/numismatist_coins"));

            Advancement ocelotCoinSet = getAdvancement(todeCoins, ModItems.COPPER_OCELOT_COIN.get(),
                    "ocelotCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_OCELOT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_OCELOT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_OCELOT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_OCELOT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/ocelot_coins"));

            Advancement pandaCoinSet = getAdvancement(todeCoins, ModItems.COPPER_PANDA_COIN.get(),
                    "pandaCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PANDA_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PANDA_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PANDA_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PANDA_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/panda_coins"));

            Advancement parrotCoinSet = getAdvancement(todeCoins, ModItems.COPPER_PARROT_COIN.get(),
                    "parrotCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PARROT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PARROT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PARROT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PARROT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/parrot_coins"));

            Advancement penguinCoinSet = getAdvancement(todeCoins, ModItems.COPPER_PENGUIN_COIN.get(),
                    "penguinCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PENGUIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PENGUIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PENGUIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PENGUIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/penguin_coins"));

            Advancement phantomCoinSet = getAdvancement(todeCoins, ModItems.COPPER_PHANTOM_COIN.get(),
                    "phantomCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PHANTOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PHANTOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PHANTOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PHANTOM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/phantom_coins"));

            Advancement pigCoinSet = getAdvancement(todeCoins, ModItems.COPPER_PIG_COIN.get(),
                    "pigCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIG_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIG_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIG_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIG_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/pig_coins"));

            Advancement piglinCoinSet = getAdvancement(todeCoins, ModItems.COPPER_PIGLIN_COIN.get(),
                    "piglinCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/piglin_coins"));

            Advancement piglinBruteCoinSet = getAdvancement(todeCoins, ModItems.COPPER_PIGLIN_BRUTE_COIN.get(),
                    "piglinBruteCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/piglin_brute_coins"));

            Advancement collectibleTodePiglinsCoins = getAdvancement(todeCoins, ModItems.COPPER_PIGLIN_MERCHANT_COIN.get(),
                    "collectibleTodePiglinsCoins", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_MERCHANT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_MERCHANT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_MERCHANT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/todepiglins_coins"));

            Advancement pillagerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_PILLAGER_COIN.get(),
                    "pillagerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PILLAGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/pillager_coins"));

            Advancement polarBearCoinSet = getAdvancement(todeCoins, ModItems.COPPER_POLAR_BEAR_COIN.get(),
                    "polarBearCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_POLAR_BEAR_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_POLAR_BEAR_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_POLAR_BEAR_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_POLAR_BEAR_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/polar_bear_coins"));

            Advancement pufferfishCoinSet = getAdvancement(todeCoins, ModItems.COPPER_PUFFERFISH_COIN.get(),
                    "pufferfishCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PUFFERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PUFFERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PUFFERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PUFFERFISH_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/pufferfish_coins"));

            Advancement rabbitCoinSet = getAdvancement(todeCoins, ModItems.COPPER_RABBIT_COIN.get(),
                    "rabbitCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_RABBIT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_RABBIT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_RABBIT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_RABBIT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/rabbit_coins"));

            Advancement rascalCoinSet = getAdvancement(todeCoins, ModItems.COPPER_RASCAL_COIN.get(),
                    "rascalCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_RASCAL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_RASCAL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_RASCAL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_RASCAL_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/rascal_coins"));

            Advancement ravagerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_RAVAGER_COIN.get(),
                    "ravagerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_RAVAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_RAVAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_RAVAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_RAVAGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/ravager_coins"));

            Advancement salmonCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SALMON_COIN.get(),
                    "salmonCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SALMON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SALMON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SALMON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SALMON_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/salmon_coins"));

            Advancement sheepCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SHEEP_COIN.get(),
                    "sheepCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SHEEP_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SHEEP_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SHEEP_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SHEEP_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/sheep_coins"));

            Advancement shulkerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SHULKER_COIN.get(),
                    "shulkerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SHULKER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SHULKER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SHULKER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SHULKER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/shulker_coins"));

            Advancement silverfishCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SILVERFISH_COIN.get(),
                    "silverfishCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SILVERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SILVERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SILVERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SILVERFISH_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/silverfish_coins"));

            Advancement skeletonCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SKELETON_COIN.get(),
                    "skeletonCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SKELETON_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/skeleton_coins"));

            Advancement skeletonHorseCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SKELETON_HORSE_COIN.get(),
                    "skeletonHorseCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SKELETON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SKELETON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SKELETON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SKELETON_HORSE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/skeleton_horse_coins"));

            Advancement slimeCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SLIME_COIN.get(),
                    "slimeCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SLIME_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SLIME_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SLIME_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SLIME_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/slime_coins"));

            Advancement snifferCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SNIFFER_COIN.get(),
                    "snifferCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SNIFFER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/sniffer_coins"));

            Advancement snowGolemCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SNOW_GOLEM_COIN.get(),
                    "snowGolemCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SNOW_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SNOW_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SNOW_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SNOW_GOLEM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/snow_golem_coins"));

            Advancement squidCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SQUID_COIN.get(),
                    "squidCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SQUID_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/squid_coins"));

            Advancement squirrelCoinSet = getAdvancement(todeCoins, ModItems.COPPER_SQUIRREL_COIN.get(),
                    "squirrelCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SQUIRREL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SQUIRREL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SQUIRREL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SQUIRREL_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/squirrel_coins"));

            Advancement strayCoinSet = getAdvancement(todeCoins, ModItems.COPPER_STRAY_COIN.get(),
                    "strayCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_STRAY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_STRAY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_STRAY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_STRAY_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/stray_coins"));

            Advancement striderCoinSet = getAdvancement(todeCoins, ModItems.COPPER_STRIDER_COIN.get(),
                    "striderCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_STRIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_STRIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_STRIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_STRIDER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/strider_coins"));

            Advancement tadpoleCoinSet = getAdvancement(todeCoins, ModItems.COPPER_TADPOLE_COIN.get(),
                    "tadpoleCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TADPOLE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TADPOLE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TADPOLE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TADPOLE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/tadpole_coins"));

            Advancement traderLlamaCoinSet = getAdvancement(todeCoins, ModItems.COPPER_TRADER_LLAMA_COIN.get(),
                    "traderLlamaCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TRADER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TRADER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TRADER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TRADER_LLAMA_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/trader_llama_coins"));

            Advancement tropicalFishCoinSet = getAdvancement(todeCoins, ModItems.COPPER_TROPICAL_FISH_COIN.get(),
                    "tropicalFishCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TROPICAL_FISH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TROPICAL_FISH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TROPICAL_FISH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TROPICAL_FISH_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/tropical_fish_coins"));

            Advancement tuffGolemCoinSet = getAdvancement(todeCoins, ModItems.COPPER_TUFF_GOLEM_COIN.get(),
                    "tuffGolemCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TUFF_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TUFF_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TUFF_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TUFF_GOLEM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/tuff_golem_coins"));

            Advancement turtleCoinSet = getAdvancement(todeCoins, ModItems.COPPER_TURTLE_COIN.get(),
                    "turtleCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TURTLE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TURTLE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TURTLE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TURTLE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/turtle_coins"));

            Advancement vexCoinSet = getAdvancement(todeCoins, ModItems.COPPER_VEX_COIN.get(),
                    "vexCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_VEX_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_VEX_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_VEX_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_VEX_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/vex_coins"));

            Advancement villagerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_VILLAGER_COIN.get(),
                    "villagerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_VILLAGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/villager_coins"));

            Advancement vindicatorCoinSet = getAdvancement(todeCoins, ModItems.COPPER_VINDICATOR_COIN.get(),
                    "vindicatorCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_VINDICATOR_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_VINDICATOR_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_VINDICATOR_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_VINDICATOR_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/vindicator_coins"));

            Advancement wanderingTraderCoinSet = getAdvancement(todeCoins, ModItems.COPPER_WANDERING_TRADER_COIN.get(),
                    "wanderingTraderCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WANDERING_TRADER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WANDERING_TRADER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WANDERING_TRADER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WANDERING_TRADER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wandering_trader_coins"));

            Advancement wardenCoinSet = getAdvancement(todeCoins, ModItems.COPPER_WARDEN_COIN.get(),
                    "wardenCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WARDEN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WARDEN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WARDEN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WARDEN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/warden_coins"));

            Advancement wildfireCoinSet = getAdvancement(todeCoins, ModItems.COPPER_WILDFIRE_COIN.get(),
                    "wildfireCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WILDFIRE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WILDFIRE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WILDFIRE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WILDFIRE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wildfire_coins"));

            Advancement witchCoinSet = getAdvancement(todeCoins, ModItems.COPPER_WITCH_COIN.get(),
                    "witchCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WITCH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WITCH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WITCH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WITCH_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/witch_coins"));

            Advancement witherCoinSet = getAdvancement(todeCoins, ModItems.COPPER_WITHER_COIN.get(),
                    "witherCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WITHER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WITHER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WITHER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WITHER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wither_coins"));

            Advancement witherSkeletonCoinSet = getAdvancement(todeCoins, ModItems.COPPER_WITHER_SKELETON_COIN.get(),
                    "witherSkeletonCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WITHER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WITHER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WITHER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WITHER_SKELETON_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wither_skeleton_coins"));

            Advancement wolfCoinSet = getAdvancement(todeCoins, ModItems.COPPER_WOLF_COIN.get(),
                    "wolfCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WOLF_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wolf_coins"));

            Advancement zoglinCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ZOGLIN_COIN.get(),
                    "zoglinCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zoglin_coins"));

            Advancement zombieCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ZOMBIE_COIN.get(),
                    "zombieCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zombie_coins"));

            Advancement zombieHorseCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ZOMBIE_HORSE_COIN.get(),
                    "zombieHorseCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zombie_horse_coins"));

            Advancement zombieVillagerCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get(),
                    "zombieVillagerCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zombie_villager_coins"));

            Advancement zombifiedPiglinCoinSet = getAdvancement(todeCoins, ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get(),
                    "zombified_piglinCoinSet", FrameType.TASK, true, true, false)
                    .parent(collectibleCoins)

                    .addCriterion("find_" + ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zombified_piglin_coins"));
        }

        private String getPath(String id) {
            return TodeCoins.MODID + ":" + id;
        }
    }
}