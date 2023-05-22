package net.warrentode.todecoins.datagen;

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
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

import static net.warrentode.todecoins.TodeCoins.MODID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AdvancementsGen extends AdvancementProvider {
    private final Path PATH;

    public AdvancementsGen(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, fileHelperIn);
        PATH = generatorIn.getOutputFolder();
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

    private static Path getPath(Path pathIn, Advancement advancementIn) {
        return pathIn.resolve("data/" + advancementIn.getId().getNamespace() + "/advancements/" + advancementIn.getId().getPath() + ".json");
    }

    public static class TodeCoinsAdvancements implements Consumer<Consumer<Advancement>> {
        public void accept(Consumer<Advancement> consumer) {
            Advancement todeCoins = Advancement.Builder.advancement().display(ModItems.GOLD_COIN.get(),
                    Component.translatable("advancement.root"), Component.translatable("advancement.root.desc"),
                    new ResourceLocation("todecoins:textures/block/pot.png"),
                    FrameType.TASK, false, false, false).addCriterion("trade",
                    InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{})).save(consumer, getPath("main/root"));

            // Craft Coin Press
            Advancement craftCoinPress = getAdvancement(todeCoins, ModBlocks.COINPRESSBLOCK.get(),
                    "craftCoinPress", FrameType.TASK, true, true, false)
                    .addCriterion("craft_coinpress", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COINPRESSBLOCK.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/craft_coinpress"));

            // Lucky Clover
            Advancement luckyClover = getAdvancement(todeCoins, ModItems.FOUR_LEAF_CLOVER.get(),
                    "luckyClover", FrameType.CHALLENGE, true, true, false)
                    .addCriterion("find_four_leaf_clover", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FOUR_LEAF_CLOVER.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/lucky_clover"));

            // Lucky Pennies
            Advancement luckyPenny = getAdvancement(todeCoins, ModItems.LUCKY_COIN.get(),
                    "luckyPenny", FrameType.CHALLENGE, true, true, false).parent(luckyClover)
                    .addCriterion("craft_lucky_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_COIN.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/lucky_penny"));

            // Emerald Textile Engineering
            Advancement textileEngineering1 = getAdvancement(todeCoins, ModItems.EMERALD_FIBER.get(),
                    "textileEngineering1", FrameType.TASK, true, true, false)
                    .parent(craftCoinPress)
                    .addCriterion("craft_emerald_fiber", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_FIBER.get()))
                    .addCriterion("craft_coarse_wove_paper", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_COARSE_WOVE_PAPER.get()))
                    .addCriterion("craft_emerald_wove_paper", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_WOVE_PAPER.get()))
                    .addCriterion("craft_emerald_smooth_paper", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_SMOOTH_WOVE_PAPER.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/textile_engineering_1"));

            // Lucky Textile Engineering
            Advancement textileEngineering2 = getAdvancement(todeCoins, ModItems.LUCKY_THREAD.get(),
                    "textileEngineering2", FrameType.TASK, true, true, false)
                    .parent(luckyClover).parent(luckyPenny)
                    .addCriterion("craft_lucky_fiber", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_FIBER.get()))
                    .addCriterion("craft_lucky_thread", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_THREAD.get()))
                    .addCriterion("craft_lucky_fabric", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_FABRIC.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/textile_engineering_2"));

            // Minting Coins
            Advancement mintingCoins = getAdvancement(todeCoins, ModItems.CURRENCY_STAMP.get(),
                    "mintingCoins", FrameType.TASK, true, true, false).parent(craftCoinPress)
                    .addCriterion("craft_coin_press", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                    .addCriterion("craft_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURRENCY_STAMP.get()))
                    .addCriterion("craft_copper_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COIN.get()))
                    .addCriterion("craft_iron_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COIN.get()))
                    .addCriterion("craft_gold_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COIN.get()))
                    .addCriterion("craft_netherite_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COIN.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/minting_coins"));

            // Printing Notes
            Advancement printingMoney = getAdvancement(todeCoins, ModItems.EMERALD_BANK_NOTE.get(),
                    "printingMoney", FrameType.TASK, true, true, false)
                    .parent(mintingCoins).parent(textileEngineering1)
                    .addCriterion("craft_emerald_quarter_bank_note", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_QUARTER_BANK_NOTE.get()))
                    .addCriterion("craft_emerald_half_bank_note", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_HALF_BANK_NOTE.get()))
                    .addCriterion("craft_emerald_bank_note", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_BANK_NOTE.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/printing_money"));

            // Nether Dough
            Advancement netherDough = getAdvancement(todeCoins, ModItems.NETHER_GOLD_COIN.get(),
                    "netherDough", FrameType.TASK, true, true, false)
                    .parent(mintingCoins)
                    .addCriterion("craft_nether_currency_stamp", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHER_CURRENCY_STAMP.get()))
                    .addCriterion("craft_nether_gold_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHER_GOLD_COIN.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/nether_dough"));

            // Money to Burn
            Advancement baggingDough = getAdvancement(todeCoins, ModBlocks.GOLD_COIN_BAG.get(),
                    "baggingDough", FrameType.TASK, true, true, false)
                    .parent(textileEngineering1).parent(mintingCoins).parent(printingMoney).parent(netherDough)
                    .addCriterion("craft_copper_coin_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COPPER_COIN_BAG.get()))
                    .addCriterion("craft_iron_coin_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_COIN_BAG.get()))
                    .addCriterion("craft_gold_coin_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GOLD_COIN_BAG.get()))
                    .addCriterion("craft_netherite_coin_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHERITE_COIN_BAG.get()))
                    .addCriterion("craft_emerald_quarter_bank_note_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()))
                    .addCriterion("craft_emerald_half_bank_note_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()))
                    .addCriterion("craft_emerald_bank_note_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMERALD_BANK_NOTE_BAG.get()))
                    .addCriterion("craft_nether_gold_coin_bag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHER_GOLD_COIN_BAG.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/bagging_dough"));

            // Rainbow's End
            Advancement rainbowEnd = getAdvancement(todeCoins, ModBlocks.POT_OF_GOLD.get(),
                    "rainbowEnd", FrameType.GOAL, true, true, false)
                    .parent(baggingDough)
                    .addCriterion("craft_pot_of_gold", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.POT_OF_GOLD.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/rainbows_end"));

            // Lucky Armor Set
            Advancement luckyArmor = getAdvancement(todeCoins, ModItems.LUCKY_SHIRT.get(),
                    "luckyArmor", FrameType.GOAL, true, true, false)
                    .parent(textileEngineering2)
                    .addCriterion("craft_lucky_shirt", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_SHIRT.get()))
                    .addCriterion("craft_lucky_pants", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_PANTS.get()))
                    .addCriterion("craft_lucky_hat", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_HAT.get()))
                    .addCriterion("craft_lucky_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUCKY_BOOTS.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/lucky_armor"));

            // Collectible Coins
            Advancement collectibleCoins = getAdvancement(todeCoins, ModItems.COPPER_HERO_COIN.get(),
                    "collectibleCoins", FrameType.CHALLENGE, true, true, false)
                    .addCriterion("find_copper_hero_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HERO_COIN.get()))
                    .addCriterion("find_iron_hero_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HERO_COIN.get()))
                    .addCriterion("find_gold_hero_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HERO_COIN.get()))
                    .addCriterion("find_netherite_hero_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HERO_COIN.get()))
                    .addCriterion("find_copper_piglin_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_COIN.get()))
                    .addCriterion("find_iron_piglin_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_COIN.get()))
                    .addCriterion("find_gold_piglin_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_COIN.get()))
                    .addCriterion("find_netherite_piglin_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_COIN.get()))
                    .addCriterion("find_copper_enderman_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDERMAN_COIN.get()))
                    .addCriterion("find_iron_enderman_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDERMAN_COIN.get()))
                    .addCriterion("find_gold_enderman_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDERMAN_COIN.get()))
                    .addCriterion("find_netherite_enderman_coin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDERMAN_COIN.get()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/collectible_coins"));
        }

        protected static Advancement.Builder getAdvancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
            return Advancement.Builder.advancement()
                    .parent(parent).display(display,
                            Component.translatable("advancement." + name),
                            Component.translatable("advancement." + name + ".desc"),
                            null, frame, showToast, announceToChat, hidden);
        }

        private String getPath(String id) {
            return MODID + ":" + id;
        }
    }
}