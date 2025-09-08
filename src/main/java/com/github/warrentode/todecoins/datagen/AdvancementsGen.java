package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.curios.api.CuriosTriggers;
import top.theillusivec4.curios.api.SlotPredicate;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AdvancementsGen extends ForgeAdvancementProvider {

    public AdvancementsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(
                new TodeCoinsAdvancements(),
                new CollectibleCoinAdvancements()
        ));
    }

    @SuppressWarnings("SameParameterValue")
    protected static Advancement.Builder getAdvancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.advancement()
                .parent(parent).display(display,
                        Component.translatable("advancement." + name),
                        Component.translatable("advancement." + name + ".desc"),
                        null, frame, showToast, announceToChat, hidden);
    }

    public static class TodeCoinsAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            Advancement todeCoins = Advancement.Builder.advancement().display(TCItems.GOLD_COIN.get(),
                    Component.translatable("advancement.root"),
                    Component.translatable("advancement.root.desc"),
                    ResourceLocation.parse("todecoins:textures/block/pot.png"),
                    FrameType.TASK, false, false, true).addCriterion("trade",
                    InventoryChangeTrigger.TriggerInstance
                            .hasItems(new ItemLike[]{})).save(consumer, getPath("main" + "/root"));

            // Craft Coin Press
            Advancement craftCoinPress = getAdvancement(todeCoins, TCBlocks.COINPRESSBLOCK.get(),
                    "craft_coinpress", FrameType.TASK, true, true, false)
                    .addCriterion("craft_coinpress",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.COINPRESSBLOCK.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/craft_coinpress"));

            // Lucky Clover
            Advancement luckyClover = getAdvancement(todeCoins, TCItems.FOUR_LEAF_CLOVER.get(),
                    "lucky_clover", FrameType.CHALLENGE, true, true, false)
                    .addCriterion("find_four_leaf_clover",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.FOUR_LEAF_CLOVER.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/lucky_clover"));

            // Lucky Pennies
            Advancement luckyPenny = getAdvancement(luckyClover, TCItems.LUCKY_COIN.get(),
                    "lucky_penny", FrameType.CHALLENGE, true, true, false)
                    .addCriterion("craft_lucky_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.LUCKY_COIN.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/lucky_penny"));

            // Emerald Textile Engineering
            Advancement textileEngineering1 = getAdvancement(craftCoinPress, TCItems.EMERALD_FIBER.get(),
                    "textile_engineering_1", FrameType.TASK, true, true, false)
                    .addCriterion("craft_emerald_fiber",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.EMERALD_FIBER.get()))
                    .addCriterion("craft_coarse_wove_paper",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.EMERALD_COARSE_WOVE_PAPER.get()))
                    .addCriterion("craft_emerald_wove_paper",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.EMERALD_WOVE_PAPER.get()))
                    .addCriterion("craft_emerald_smooth_paper",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.EMERALD_SMOOTH_WOVE_PAPER.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/textile_engineering_1"));

            // Lucky Textile Engineering
            Advancement textileEngineering2 = getAdvancement(luckyPenny, TCItems.LUCKY_THREAD.get(),
                    "textile_engineering_2", FrameType.TASK, true, true, false)
                    .addCriterion("craft_lucky_fiber",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.LUCKY_FIBER.get()))
                    .addCriterion("craft_lucky_thread",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.LUCKY_THREAD.get()))
                    .addCriterion("craft_lucky_fabric",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.LUCKY_FABRIC.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/textile_engineering_2"));

            // Minting Coins
            Advancement mintingCoins = getAdvancement(craftCoinPress, TCItems.CURRENCY_STAMP.get(),
                    "minting_coins", FrameType.TASK, true, true, false)
                    .addCriterion("craft_currency_stamp",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.CURRENCY_STAMP.get()))
                    .addCriterion("craft_copper_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.COPPER_COIN.get()))
                    .addCriterion("craft_iron_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.IRON_COIN.get()))
                    .addCriterion("craft_gold_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.GOLD_COIN.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/minting_coins"));

            // Underground Coin
            Advancement cave_coins = getAdvancement(mintingCoins, TCItems.GEM_CURRENCY_STAMP.get(),
                    "cave_coins", FrameType.TASK, true, true, false)
                    .addCriterion("craft_currency_stamp",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.GEM_CURRENCY_STAMP.get()))
                    .addCriterion("craft_lapis_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.LAPIS_FLORIN.get()))
                    .addCriterion("craft_amethyst_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.AMETHYST_FLORIN.get()))
                    .addCriterion("craft_diamond_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.DIAMOND_FLORIN.get()))
                    .addCriterion("craft_emerald_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.EMERALD_FLORIN.get()))
                    .addCriterion("craft_echo_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ECHO_FLORIN.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/cave_coins"));

            // Nether Dough
            Advancement netherDough = getAdvancement(cave_coins, TCItems.NETHER_GOLD_COIN.get(),
                    "nether_dough", FrameType.TASK, true, true, false)
                    .addCriterion("craft_nether_currency_stamp",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.NETHER_CURRENCY_STAMP.get()))
                    .addCriterion("craft_nether_gold_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.NETHER_GOLD_COIN.get()))
                    .addCriterion("craft_netherite_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.NETHERITE_COIN.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/nether_dough"));

            // Otherworldly Coin
            Advancement otherworldlyCoin = getAdvancement(netherDough, TCItems.ENDONIAN_COIN.get(),
                    "otherworldly_coin", FrameType.TASK, true, true, false)
                    .addCriterion("craft_endonian_currency_stamp",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ENDONIAN_CURRENCY_STAMP.get()))
                    .addCriterion("craft_endonian_coin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ENDONIAN_COIN.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/otherworldly_coin"));

            // Printing Notes
            Advancement printingMoney = getAdvancement(textileEngineering1, TCItems.EMERALD_BANK_NOTE.get(),
                    "printing_money", FrameType.TASK, true, true, false)
                    .addCriterion("craft_emerald_quarter_bank_note",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.EMERALD_QUARTER_BANK_NOTE.get()))
                    .addCriterion("craft_emerald_half_bank_note",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.EMERALD_HALF_BANK_NOTE.get()))
                    .addCriterion("craft_emerald_bank_note",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.EMERALD_BANK_NOTE.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/printing_money"));

            // Bagging Dough
            Advancement baggingDough = getAdvancement(printingMoney, TCBlocks.GOLD_COIN_BAG.get(),
                    "bagging_dough", FrameType.TASK, true, true, false)
                    .addCriterion("craft_copper_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.COPPER_COIN_BAG.get()))
                    .addCriterion("craft_iron_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.IRON_COIN_BAG.get()))
                    .addCriterion("craft_gold_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.GOLD_COIN_BAG.get()))
                    .addCriterion("craft_emerald_quarter_bank_note_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get()))
                    .addCriterion("craft_emerald_half_bank_note_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.EMERALD_HALF_BANK_NOTE_BAG.get()))
                    .addCriterion("craft_emerald_bank_note_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.EMERALD_BANK_NOTE_BAG.get()))
                    .addCriterion("craft_lucky_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.LUCKY_COIN_BAG.get()))
                    .addCriterion("craft_nether_gold_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.NETHER_GOLD_COIN_BAG.get()))
                    .addCriterion("craft_netherite_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.NETHERITE_COIN_BAG.get()))
                    .addCriterion("craft_endonian_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.ENDONIAN_COIN_BAG.get()))
                    .addCriterion("craft_lapis_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.LAPIS_FLORIN_BAG.get()))
                    .addCriterion("craft_amethyst_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.AMETHYST_FLORIN_BAG.get()))
                    .addCriterion("craft_diamond_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.DIAMOND_FLORIN_BAG.get()))
                    .addCriterion("craft_emerald_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.EMERALD_FLORIN_BAG.get()))
                    .addCriterion("craft_echo_coin_bag",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.ECHO_COIN_BAG.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/bagging_dough"));

            // Rainbow's End
            getAdvancement(baggingDough, TCBlocks.POT_OF_GOLD.get(),
                    "rainbows_end", FrameType.GOAL, true, true, false)
                    .addCriterion("craft_pot_of_gold",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCBlocks.POT_OF_GOLD.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/rainbows_end"));

            // Lucky Armor Set
            getAdvancement(textileEngineering2, TCItems.LUCKY_SHIRT.get(),
                    "lucky_armor", FrameType.GOAL, true, true, false)
                    .addCriterion("craft_lucky_shirt",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.LUCKY_SHIRT.get()))
                    .addCriterion("craft_lucky_pants",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.LUCKY_PANTS.get()))
                    .addCriterion("craft_lucky_hat",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.LUCKY_HAT.get()))
                    .addCriterion("craft_lucky_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.LUCKY_BOOTS.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/lucky_armor"));

            // Endonian Thread
            Advancement textileEngineering3 = getAdvancement(otherworldlyCoin, TCItems.ENDONIAN_THREAD.get(),
                    "textile_engineering_3", FrameType.TASK, true, true, false)
                    .addCriterion("craft_endonian_fiber",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ENDONIAN_FIBER.get()))
                    .addCriterion("craft_endonian_thread",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ENDONIAN_THREAD.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/textile_engineering_3"));

            // Echo Thread
            Advancement textileEngineering4 = getAdvancement(textileEngineering3, TCItems.ECHO_THREAD.get(),
                    "textile_engineering_4", FrameType.TASK, true, true, false)
                    .addCriterion("craft_echo_fiber",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ECHO_FIBER.get()))
                    .addCriterion("craft_echo_thread",
                            InventoryChangeTrigger.TriggerInstance.hasItems(TCItems.ECHO_THREAD.get()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("main/textile_engineering_4"));

            Advancement craftWallet = getAdvancement(textileEngineering4, TCItems.WALLET.get(),
                    "craft_wallet", FrameType.GOAL, true, true, false)
                    .addCriterion("craft_wallet",
                            InventoryChangeTrigger.TriggerInstance
                                    .hasItems(ItemPredicate.Builder.item().of(TCItems.WALLET.get()).build()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/craft_wallet"));

            // equip a wallet
            getAdvancement(craftWallet, TCItems.WALLET.get(),
                    "equip_wallet", FrameType.TASK, true, true, true)
                    .addCriterion("equip_wallet",
                            CuriosTriggers.equip()
                                    .withItem(ItemPredicate.Builder.item().of(TCItemTags.WALLETS))
                                    .withLocation(LocationPredicate.Builder.location())
                                    .withSlot(SlotPredicate.Builder.slot().of("belt"))
                                    .build())
                    .rewards(AdvancementRewards.Builder.function(ResourceLocation.parse(MODID + ":add_belt_slot")))
                    .requirements(RequirementsStrategy.OR)
                    .save(consumer, getPath("main/equip_wallet"));

            // Friends Forever
            Advancement friendsForever = getAdvancement(textileEngineering4, TCItems.BRACELET_FRIENDSHIP_ENDONIAN.get(),
                    "friends_forever", FrameType.GOAL, true, true, false)
                    .addCriterion("friends_forever",
                            InventoryChangeTrigger.TriggerInstance
                                    .hasItems(ItemPredicate.Builder.item().of(TCItemTags.FRIENDSHIP_BRACELETS).build()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("main/friends_forever"));

            // equip a bracelet
            getAdvancement(friendsForever, TCItems.BRACELET_FRIENDSHIP_EMERALD.get(),
                    "equip_bracelet", FrameType.TASK, true, true, true)
                    .addCriterion("equip_bracelet",
                            CuriosTriggers.equip()
                                    .withItem(ItemPredicate.Builder.item().of(TCItemTags.FRIENDSHIP_BRACELETS))
                                    .withLocation(LocationPredicate.Builder.location())
                                    .withSlot(SlotPredicate.Builder.slot().of("bracelet"))
                                    .build())
                    .rewards(AdvancementRewards.Builder.function(ResourceLocation.parse(MODID + ":add_bracelet_slot")))
                    .requirements(RequirementsStrategy.OR)
                    .save(consumer, getPath("main/equip_bracelet"));
        }

        private String getPath(String id) {
            return MODID + ":" + id;
        }
    }

    public static class CollectibleCoinAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            Advancement collectibleCoins = Advancement.Builder.advancement()
                    .display(TCItems.COLLECTIBLE_COIN_SCHOLAR_OWL.get(),
                            Component.translatable("advancement.collectible_coins"),
                            Component.translatable("advancement.collectible_coins.desc"),
                            ResourceLocation.parse("todecoins:textures/block/pot.png"),
                            FrameType.TASK, false, false, false)
                    .addCriterion("trade", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                    .save(consumer, getPath("collectible" + "/root"));

            // find first coin
            Advancement find_first_coin = getAdvancement(collectibleCoins, TCItems.COLLECTIBLE_COIN_TUXEDO_CAT.get(),
                    "find_first_coin", FrameType.TASK, true, true, false)
                    .addCriterion("find_first_coin",
                            InventoryChangeTrigger.TriggerInstance
                                    .hasItems(ItemPredicate.Builder.item().of(TCItemTags.COLLECTIBLE_COINS_TAG).build()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("collectible/find_first_coin"));

            // obtain a collectible coin album
            Advancement obtain_coin_album = getAdvancement(find_first_coin, TCItems.COIN_ALBUM_BLOCK_ITEM.get(),
                    "obtain_coin_album", FrameType.TASK, true, true, false)
                    .addCriterion("obtain_coin_album",
                            InventoryChangeTrigger.TriggerInstance
                                    .hasItems(ItemPredicate.Builder.item().of(TCItems.COIN_ALBUM_BLOCK_ITEM.get()).build()))
                    .rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/obtain_coin_album"));

            // equip a coin
            getAdvancement(find_first_coin, TCItems.COLLECTIBLE_COIN_PATRON_COSMOS.get(),
                    "equip_coin", FrameType.TASK, true, true, true)
                    .addCriterion("equip_lucky_coin",
                            CuriosTriggers.equip().withItem(ItemPredicate.Builder.item().of(TCItems.LUCKY_COIN.get()))
                                    .withLocation(LocationPredicate.Builder.location())
                                    .withSlot(SlotPredicate.Builder.slot().of("charm"))
                                    .build())
                    .addCriterion("equip_collectible_coin",
                            CuriosTriggers.equip().withItem(ItemPredicate.Builder.item().of(TCItemTags.COLLECTIBLE_COINS_TAG))
                                    .withLocation(LocationPredicate.Builder.location())
                                    .withSlot(SlotPredicate.Builder.slot().of("charm"))
                                    .build())
                    .rewards(AdvancementRewards.Builder.function(ResourceLocation.parse(MODID + ":add_charm_slot")))
                    .requirements(RequirementsStrategy.OR)
                    .save(consumer, getPath("collectible/equip_coin"));

            // Get all collectible coins dynamically from the registry
            List<Item> allCoins = ForgeRegistries.ITEMS.getValues().stream()
                    .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath().contains("collectible_coin"))
                    .toList();

            // find all coins
            Advancement.Builder find_all_coins_builder = getAdvancement(obtain_coin_album, TCItems.COLLECTIBLE_COIN_LITTLE_BEAR.get(),
                    "find_all_coins", FrameType.TASK, true, true, false
            );

            for (Item coin : allCoins) {
                String coinName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(coin)).getPath();
                find_all_coins_builder.addCriterion(
                        "has_" + coinName,
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(coin).build())
                );
            }

            Advancement find_all_coins = find_all_coins_builder.rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                    .requirements(RequirementsStrategy.AND)
                    .save(consumer, getPath("collectible/find_all_coins"));

            // Coin Set Achievements
            Set<String> coinSets = Set.of(
                    "aerial", "aquatic", "arthropod", "blaze",
                    "breedable", "celebration", "fish", "golem",
                    "humanoid", "misc", "piglin", "raider",
                    "slime", "steed", "undead", "wild"
            );

            for (String setName : coinSets) {
                // Gather all items in the set
                List<Item> coinsInSet = getCoinsForSet(setName, allCoins);

                // Build the advancement
                Advancement.Builder setAdv = getAdvancement(find_all_coins, getRepresentativeItemForSet(setName),
                        "complete_" + setName + "_coin_set", FrameType.TASK, true, true, true);

                // Dynamically add every coin as a criterion
                Map<String, CriterionTriggerInstance> criteriaMap = new LinkedHashMap<>();
                for (Item coin : coinsInSet) {
                    String coinName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(coin)).getPath();
                    criteriaMap.put("has_" + coinName,
                            InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(coin).build()));
                }

                // Fallback to representative coin if the set is empty
                if (criteriaMap.isEmpty()) {
                    Item fallback = getRepresentativeItemForSet(setName);
                    criteriaMap.put("has_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(fallback)).getPath(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(fallback).build()));
                }

                // Add all criteria to the advancement
                criteriaMap.forEach(setAdv::addCriterion);

                setAdv.rewards(AdvancementRewards.Builder.loot(ResourceLocation.parse(TradeLootTables.SERVER_TOKEN_COIN.toString())))
                        .requirements(RequirementsStrategy.AND)
                        .save(consumer, getPath("collectible/complete_" + setName + "_coin_set"));
            }
        }

        // Helper: picks a representative item from a tag for the advancement icon
        private static Item getRepresentativeItemForSet(String setName) {
            return switch (setName) {
                case "aerial" -> TCItems.COLLECTIBLE_COIN_ALLAY_COPPER.get();
                case "aquatic" -> TCItems.COLLECTIBLE_COIN_DOLPHIN_IRON.get();
                case "arthropod" -> TCItems.COLLECTIBLE_COIN_SPIDER_GOLD.get();
                case "blaze" -> TCItems.COLLECTIBLE_COIN_BLAZE_NETHERITE.get();
                case "breedable" -> TCItems.COLLECTIBLE_COIN_CHICKEN_COPPER.get();
                case "celebration" -> TCItems.COLLECTIBLE_COIN_HERO_IRON.get();
                case "fish" -> TCItems.COLLECTIBLE_COIN_TROPICAL_FISH_GOLD.get();
                case "golem" -> TCItems.COLLECTIBLE_COIN_TUFF_GOLEM_NETHERITE.get();
                case "humanoid" -> TCItems.COLLECTIBLE_COIN_VILLAGER_COPPER.get();
                case "misc" -> TCItems.COLLECTIBLE_COIN_WARDEN_IRON.get();
                case "piglin" -> TCItems.COLLECTIBLE_COIN_PIGLIN_BRUTE_GOLD.get();
                case "raider" -> TCItems.COLLECTIBLE_COIN_PILLAGER_NETHERITE.get();
                case "slime" -> TCItems.COLLECTIBLE_COIN_SLIME_COPPER.get();
                case "steed" -> TCItems.COLLECTIBLE_COIN_HORSE_IRON.get();
                case "undead" -> TCItems.COLLECTIBLE_COIN_ZOMBIE_VILLAGER_GOLD.get();
                case "wild" -> TCItems.COLLECTIBLE_COIN_PENGUIN_NETHERITE.get();
                default -> TCItems.COLLECTIBLE_COIN_PATRON_CARNATION.get();
            };
        }

        private static List<Item> getCoinsForSet(String setName, List<Item> allCoins) {
            Map<String, List<String>> coinKeywords = Map.ofEntries(
                    Map.entry("aerial", List.of("allay", "bat", "dragon", "ghast", "parrot", "phantom", "glare", "bee", "breeze")),
                    Map.entry("aquatic", List.of("axolotl", "crab", "dolphin", "guardian", "frog", "squid", "penguin", "tadpole", "turtle")),
                    Map.entry("arthropod", List.of("spider", "endermite", "silverfish")),
                    Map.entry("blaze", List.of("blaze", "wildfire")),
                    // this check NEEDS to exclude anything with "piglin", "little_bear", "scholar_owl", "tuxedo_cat"
                    Map.entry("breedable", List.of("armadillo", "cat", "chicken", "cow", "fox", "goat", "moo", "ocelot", "panda", "pig", "rabbit", "sheep", "wolf")),
                    Map.entry("celebration", List.of("hero", "patron", "little_bear", "scholar_owl", "tuxedo_cat", "new_year", "birthday", "christmas", "halloween", "easter")),
                    Map.entry("fish", List.of("tropical_fish", "salmon", "cod", "pufferfish")),
                    Map.entry("golem", List.of("golem")),
                    // this check NEEDS to exclude anything with "zombie_villager"
                    Map.entry("humanoid", List.of("villager", "guard", "numismatist", "rascal", "wandering_trader")),
                    Map.entry("misc", List.of("creeper", "enderman", "giant", "shulker", "warden", "sniffer", "creaking")),
                    Map.entry("piglin", List.of("piglin", "hoglin")),
                    Map.entry("raider", List.of("evoker", "iceologer", "illusioner", "pillager", "ravager", "vex", "vindicator", "witch")),
                    Map.entry("slime", List.of("slime", "cube")),
                    Map.entry("steed", List.of("horse", "donkey", "mule", "llama", "strider", "camel")),
                    // this check NEEDS to exclude anything with "horse" - and yes, "zombi" is intentional
                    Map.entry("undead", List.of("zombi", "skeleton", "drowned", "husk", "stray", "wither", "zoglin", "bogged")),
                    // this check NEEDS to exlude anything with "little_bear", "scholar_owl", "tuxedo_cat"
                    Map.entry("wild", List.of("mauler", "bear", "squirrel"))
            );

            List<String> keywords = coinKeywords.getOrDefault(setName, List.of());
            List<String> exclusions = switch (setName) {
                case "breedable" -> List.of("piglin", "little_bear", "scholar_owl", "tuxedo_cat");
                case "humanoid" -> List.of("zombie_villager");
                case "undead" -> List.of("horse");
                case "wild" -> List.of("little_bear", "scholar_owl", "tuxedo_cat");
                default -> List.of();
            };

            return allCoins.stream()
                    .filter(item -> {
                        String path = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
                        boolean matchesKeyword = keywords.stream().anyMatch(path::contains);
                        boolean excluded = exclusions.stream().anyMatch(path::contains);
                        return matchesKeyword && !excluded;
                    })
                    .toList();
        }

        private String getPath(String id) {
            return MODID + ":" + id;
        }
    }
}