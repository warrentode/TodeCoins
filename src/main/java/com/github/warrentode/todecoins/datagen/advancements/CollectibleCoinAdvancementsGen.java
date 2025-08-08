package com.github.warrentode.todecoins.datagen.advancements;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import com.google.common.collect.Sets;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosTriggers;
import top.theillusivec4.curios.api.SlotPredicate;
import top.theillusivec4.curios.api.SlotTypePreset;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CollectibleCoinAdvancementsGen extends AdvancementProvider {
    private final Path PATH;

    public CollectibleCoinAdvancementsGen(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
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

        new CollectibleCoinAdvancements().accept(consumer);
    }

    public static class CollectibleCoinAdvancements implements Consumer<Consumer<Advancement>> {
        @SuppressWarnings("SameParameterValue")
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
            @SuppressWarnings("removal") Advancement collectibleCoins = Advancement.Builder.advancement().display(ModItems.SCHOLAR_OWL_COIN.get(),
                    Component.translatable("advancement.collectibleCoins"), Component.translatable("advancement.collectibleCoins.desc"),
                    new ResourceLocation("todecoins:textures/block/pot.png"),
                    FrameType.TASK, false, false, false).addCriterion("trade",
                    InventoryChangeTrigger.TriggerInstance
                            .hasItems(new ItemLike[]{})).save(consumer, getPath("collectible" + "/root"));

            Advancement first_coin = getAdvancement(collectibleCoins, ModItems.TUXEDO_CAT_COIN.get(),
                    "first_coin", FrameType.TASK, true, true, false)
                    .addCriterion("find_first_coin",
                            InventoryChangeTrigger.TriggerInstance
                                    .hasItems(ItemPredicate.Builder.item().of(TodeCoinsTags.Items.COLLECTIBLE_COINS).build()))
                    .requirements(RequirementsStrategy.OR).save(consumer, getPath("collectible/first_coin"));

            //noinspection unused
            Advancement equipLuckyCoin = getAdvancement(collectibleCoins, ModItems.LUCKY_COIN.get(),
                    "equip_lucky_coin", FrameType.TASK, true, true, false)
                    .addCriterion("equip_lucky_coin",
                            CuriosTriggers.equip()
                                    .withItem(ItemPredicate.Builder.item().of(ModItems.LUCKY_COIN.get()))
                                    .withSlot(SlotPredicate.Builder.slot().of(SlotTypePreset.CHARM.getIdentifier()))
                                    .withLocation(LocationPredicate.Builder.location())
                                    .build())
                    .rewards(AdvancementRewards.Builder.function(Objects.requireNonNull(ResourceLocation.tryParse("todecoins:add_charm_slot"))))
                    .requirements(RequirementsStrategy.OR).save(consumer, getCuriosPath("advancements/equip_lucky_coin"));

            //noinspection unused
            Advancement equipWallet = getAdvancement(collectibleCoins, Items.BUNDLE,
                    "equip_wallet", FrameType.TASK, true, true, false)
                    .addCriterion("equip_wallet",
                            CuriosTriggers.equip()
                                    .withItem(ItemPredicate.Builder.item().of(TodeCoinsTags.Items.WALLETS))
                                    .withSlot(SlotPredicate.Builder.slot().of(SlotTypePreset.BELT.getIdentifier()))
                                    .withLocation(LocationPredicate.Builder.location())
                                    .build())
                    .rewards(AdvancementRewards.Builder.function(Objects.requireNonNull(ResourceLocation.tryParse("todecoins:add_belt_slot"))))
                    .requirements(RequirementsStrategy.OR).save(consumer, getCuriosPath("advancements/equip_wallet"));

            Advancement lifetimePatronCoinSet = getAdvancement(first_coin, ModItems.LITTLE_BEAR_COIN.get(),
                    "lifetimePatronCoinSet", FrameType.TASK, true, true, false)

                    .addCriterion("find_" + ModItems.SCHOLAR_OWL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SCHOLAR_OWL_COIN.get()))
                    .addCriterion("find_" + ModItems.TUXEDO_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TUXEDO_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.LITTLE_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LITTLE_BEAR_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/lifetime_patron_coins"));

            Advancement patronNashCoinSet = getAdvancement(lifetimePatronCoinSet, ModItems.MARSHALL_NASH_CARNATION_COIN.get(),
                    "patronNashCoinSet", FrameType.TASK, true, true, false)

                    .addCriterion("find_" + ModItems.MARSHALL_NASH_CARNATION_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MARSHALL_NASH_CARNATION_COIN.get()))
                    .addCriterion("find_" + ModItems.MARSHALL_NASH_COSMOS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MARSHALL_NASH_COSMOS_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/patron_nash_coins"));

            Advancement patronBranniganCoinSet = getAdvancement(patronNashCoinSet, ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get(),
                    "patronBranniganCoinSet", FrameType.TASK, true, true, false)

                    .addCriterion("find_" + ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get()))
                    .addCriterion("find_" + ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/patron_brannigan_coins"));

            Advancement holidayCoinSet = getAdvancement(patronBranniganCoinSet, ModItems.CHRISTMAS_COIN.get(),
                    "holidayCoinSet", FrameType.TASK, true, true, false)

                    .addCriterion("find_" + ModItems.BIRTHDAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BIRTHDAY_COIN.get()))
                    .addCriterion("find_" + ModItems.HALLOWEEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HALLOWEEN_COIN.get()))
                    .addCriterion("find_" + ModItems.CHRISTMAS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHRISTMAS_COIN.get()))
                    .addCriterion("find_" + ModItems.EASTER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EASTER_COIN.get()))
                    .addCriterion("find_" + ModItems.NEW_YEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NEW_YEAR_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/holiday_coins"));

            Advancement allayCoinSet = getAdvancement(holidayCoinSet, ModItems.COPPER_ALLAY_COIN.get(),
                    "allayCoinSet", FrameType.TASK, true, true, false)

                    .addCriterion("find_" + ModItems.COPPER_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ALLAY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ALLAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ALLAY_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/allay_coins"));

            Advancement armadilloCoinSet = getAdvancement(allayCoinSet, ModItems.COPPER_ARMADILLO_COIN.get(),
                    "armadilloCoinSet", FrameType.TASK, true, true, false)

                    .addCriterion("find_" + ModItems.COPPER_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ARMADILLO_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ARMADILLO_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ARMADILLO_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ARMADILLO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ARMADILLO_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/armadillo_coins"));

            Advancement axolotlCoinSet = getAdvancement(armadilloCoinSet, ModItems.COPPER_AXOLOTL_COIN.get(),
                    "axolotlCoinSet", FrameType.TASK, true, true, false)

                    .addCriterion("find_" + ModItems.COPPER_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_AXOLOTL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_AXOLOTL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_AXOLOTL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_AXOLOTL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_AXOLOTL_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/axolotl_coins"));

            Advancement batCoinSet = getAdvancement(axolotlCoinSet, ModItems.COPPER_BAT_COIN.get(),
                    "batCoinSet", FrameType.TASK, true, true, false)

                    .addCriterion("find_" + ModItems.COPPER_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_BAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_BAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_BAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_BAT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/bat_coins"));

            Advancement beeCoinSet = getAdvancement(batCoinSet, ModItems.COPPER_BEE_COIN.get(),
                    "beeCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BEE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_BEE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_BEE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_BEE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_BEE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/bee_coins"));

            Advancement blazeCoinSet = getAdvancement(beeCoinSet, ModItems.COPPER_BLAZE_COIN.get(),
                    "blazeCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_BLAZE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_BLAZE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_BLAZE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_BLAZE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_BLAZE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/blaze_coins"));

            Advancement camelCoinSet = getAdvancement(blazeCoinSet, ModItems.COPPER_CAMEL_COIN.get(),
                    "camelCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAMEL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAMEL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAMEL_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/camel_coins"));

            Advancement catCoinSet = getAdvancement(camelCoinSet, ModItems.COPPER_CAT_COIN.get(),
                    "catCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/cat_coins"));

            Advancement caveSpiderCoinSet = getAdvancement(catCoinSet, ModItems.COPPER_CAVE_SPIDER_COIN.get(),
                    "caveSpiderCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CAVE_SPIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CAVE_SPIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CAVE_SPIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CAVE_SPIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CAVE_SPIDER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/cave_spider_coins"));

            Advancement chickenCoinSet = getAdvancement(caveSpiderCoinSet, ModItems.COPPER_CHICKEN_COIN.get(),
                    "chickenCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CHICKEN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CHICKEN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CHICKEN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CHICKEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CHICKEN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/chicken_coins"));

            Advancement codCoinSet = getAdvancement(chickenCoinSet, ModItems.COPPER_COD_COIN.get(),
                    "codCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COD_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COD_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COD_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COD_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/cod_coins"));

            Advancement copperGolemCoinSet = getAdvancement(codCoinSet, ModItems.COPPER_COPPER_GOLEM_COIN.get(),
                    "copperGolemCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COPPER_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COPPER_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COPPER_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COPPER_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COPPER_GOLEM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/copper_golem_coins"));

            Advancement cowCoinSet = getAdvancement(copperGolemCoinSet, ModItems.COPPER_COW_COIN.get(),
                    "cowCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_COW_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_COW_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_COW_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/cow_coins"));

            Advancement crabCoinSet = getAdvancement(cowCoinSet, ModItems.COPPER_CRAB_COIN.get(),
                    "crabCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CRAB_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CRAB_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CRAB_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CRAB_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CRAB_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/crab_coins"));

            Advancement creeperCoinSet = getAdvancement(crabCoinSet, ModItems.COPPER_CREEPER_COIN.get(),
                    "creeperCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CREEPER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_CREEPER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_CREEPER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_CREEPER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_CREEPER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/creeper_coins"));

            Advancement dolphinCoinSet = getAdvancement(creeperCoinSet, ModItems.COPPER_DOLPHIN_COIN.get(),
                    "dolphinCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DOLPHIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DOLPHIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DOLPHIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_DOLPHIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DOLPHIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/dolphin_coins"));

            Advancement donkeyCoinSet = getAdvancement(dolphinCoinSet, ModItems.COPPER_DONKEY_COIN.get(),
                    "donkeyCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DONKEY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DONKEY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DONKEY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_DONKEY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DONKEY_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/donkey_coins"));

            Advancement drownedCoinSet = getAdvancement(donkeyCoinSet, ModItems.COPPER_DROWNED_COIN.get(),
                    "drownedCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DROWNED_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DROWNED_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DROWNED_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_DROWNED_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DROWNED_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/drowned_coins"));

            Advancement elderGuardianCoinSet = getAdvancement(drownedCoinSet, ModItems.COPPER_ELDER_GUARDIAN_COIN.get(),
                    "elderGuardianCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ELDER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ELDER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ELDER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/elder_guardian_coins"));

            Advancement enderDragonCoinSet = getAdvancement(elderGuardianCoinSet, ModItems.COPPER_ENDER_DRAGON_COIN.get(),
                    "enderDragonCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDER_DRAGON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDER_DRAGON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDER_DRAGON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ENDER_DRAGON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDER_DRAGON_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/ender_dragon_coins"));

            Advancement endermanCoinSet = getAdvancement(enderDragonCoinSet, ModItems.COPPER_ENDERMAN_COIN.get(),
                    "endermanCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDERMAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDERMAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDERMAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ENDERMAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDERMAN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/enderman_coins"));

            Advancement endermiteCoinSet = getAdvancement(endermanCoinSet, ModItems.COPPER_ENDERMITE_COIN.get(),
                    "endermiteCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ENDERMITE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ENDERMITE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ENDERMITE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ENDERMITE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ENDERMITE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/endermite_coins"));

            Advancement evokerCoinSet = getAdvancement(endermiteCoinSet, ModItems.COPPER_EVOKER_COIN.get(),
                    "evokerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_EVOKER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_EVOKER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_EVOKER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_EVOKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_EVOKER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/evoker_coins"));

            Advancement frogCoinSet = getAdvancement(evokerCoinSet, ModItems.COPPER_FROG_COIN.get(),
                    "frogCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_FROG_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_FROG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_FROG_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/frog_coins"));

            Advancement foxCoinSet = getAdvancement(frogCoinSet, ModItems.COPPER_FOX_COIN.get(),
                    "foxCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_FOX_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_FOX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_FOX_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/fox_coins"));

            Advancement ghastCoinSet = getAdvancement(foxCoinSet, ModItems.COPPER_GHAST_COIN.get(),
                    "ghastCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GHAST_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GHAST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GHAST_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/ghast_coins"));

            Advancement giantCoinSet = getAdvancement(ghastCoinSet, ModItems.COPPER_GIANT_COIN.get(),
                    "giantCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GIANT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GIANT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GIANT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GIANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GIANT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/giant_coins"));

            Advancement goatCoinSet = getAdvancement(giantCoinSet, ModItems.COPPER_GOAT_COIN.get(),
                    "goatCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GOAT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GOAT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GOAT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/goat_coins"));

            Advancement glareCoinSet = getAdvancement(goatCoinSet, ModItems.COPPER_GLARE_COIN.get(),
                    "glareCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GLARE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GLARE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GLARE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GLARE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GLARE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/glare_coins"));

            Advancement glowSquidCoinSet = getAdvancement(glareCoinSet, ModItems.COPPER_GLOW_SQUID_COIN.get(),
                    "glowSquidCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GLOW_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GLOW_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GLOW_SQUID_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/glow_squid_coins"));

            Advancement guardVillagerCoinSet = getAdvancement(glowSquidCoinSet, ModItems.COPPER_GUARD_COIN.get(),
                    "guardVillagerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GUARD_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GUARD_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GUARD_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GUARD_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GUARD_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/guardvillagers_coins"));

            Advancement guardianCoinSet = getAdvancement(guardVillagerCoinSet, ModItems.COPPER_GUARDIAN_COIN.get(),
                    "guardianCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_GUARDIAN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_GUARDIAN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GUARDIAN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/guardian_coins"));

            Advancement heroCoinSet = getAdvancement(guardianCoinSet, ModItems.COPPER_HERO_COIN.get(),
                    "heroCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HERO_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HERO_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HERO_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/hero_coins"));

            Advancement hoglinCoinSet = getAdvancement(heroCoinSet, ModItems.COPPER_HOGLIN_COIN.get(),
                    "hoglinCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HOGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/hoglin_coins"));

            Advancement horseCoinSet = getAdvancement(hoglinCoinSet, ModItems.COPPER_HORSE_COIN.get(),
                    "horseCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HORSE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/horse_coins"));

            Advancement huskCoinSet = getAdvancement(horseCoinSet, ModItems.COPPER_HUSK_COIN.get(),
                    "huskCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_HUSK_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_HUSK_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_HUSK_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_HUSK_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HUSK_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/husk_coins"));

            Advancement iceologerCoinSet = getAdvancement(huskCoinSet, ModItems.COPPER_ICEOLOGER_COIN.get(),
                    "iceologerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ICEOLOGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ICEOLOGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ICEOLOGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ICEOLOGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ICEOLOGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/iceologer_coins"));

            Advancement illusionerCoinSet = getAdvancement(iceologerCoinSet, ModItems.COPPER_ILLUSIONER_COIN.get(),
                    "illusionerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ILLUSIONER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ILLUSIONER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ILLUSIONER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ILLUSIONER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ILLUSIONER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/illusioner_coins"));

            Advancement ironGolemCoinSet = getAdvancement(illusionerCoinSet, ModItems.COPPER_IRON_GOLEM_COIN.get(),
                    "ironGolemCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_IRON_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_IRON_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_IRON_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_IRON_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_IRON_GOLEM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/iron_golem_coins"));

            Advancement llamaCoinSet = getAdvancement(ironGolemCoinSet, ModItems.COPPER_LLAMA_COIN.get(),
                    "llamaCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_LLAMA_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/llama_coins"));

            Advancement magmaCubeCoinSet = getAdvancement(llamaCoinSet, ModItems.COPPER_MAGMA_CUBE_COIN.get(),
                    "magmaCubeCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MAGMA_CUBE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MAGMA_CUBE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MAGMA_CUBE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MAGMA_CUBE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MAGMA_CUBE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/magma_cube_coins"));

            Advancement maulerCoinSet = getAdvancement(magmaCubeCoinSet, ModItems.COPPER_MAULER_COIN.get(),
                    "maulerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MAULER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MAULER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MAULER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MAULER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MAULER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/mauler_coins"));

            Advancement moobloomCoinSet = getAdvancement(maulerCoinSet, ModItems.COPPER_MOOBLOOM_COIN.get(),
                    "moobloomCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MOOBLOOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MOOBLOOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MOOBLOOM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/moobloom_coins"));

            Advancement mooshroomCoinSet = getAdvancement(moobloomCoinSet, ModItems.COPPER_MOOSHROOM_COIN.get(),
                    "mooshroomCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MOOSHROOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MOOSHROOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MOOSHROOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MOOSHROOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MOOSHROOM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/mooshroom_coins"));

            Advancement muleCoinSet = getAdvancement(mooshroomCoinSet, ModItems.COPPER_MULE_COIN.get(),
                    "muleCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_MULE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_MULE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_MULE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_MULE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_MULE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/mule_coins"));

            Advancement numismatistCoinSet = getAdvancement(muleCoinSet, ModItems.COPPER_NUMISMATIST_COIN.get(),
                    "numismatistCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_NUMISMATIST_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_NUMISMATIST_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_NUMISMATIST_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_NUMISMATIST_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_NUMISMATIST_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/numismatist_coins"));

            Advancement ocelotCoinSet = getAdvancement(numismatistCoinSet, ModItems.COPPER_OCELOT_COIN.get(),
                    "ocelotCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_OCELOT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_OCELOT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_OCELOT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_OCELOT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_OCELOT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/ocelot_coins"));

            Advancement pandaCoinSet = getAdvancement(ocelotCoinSet, ModItems.COPPER_PANDA_COIN.get(),
                    "pandaCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PANDA_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PANDA_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PANDA_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PANDA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PANDA_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/panda_coins"));

            Advancement parrotCoinSet = getAdvancement(pandaCoinSet, ModItems.COPPER_PARROT_COIN.get(),
                    "parrotCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PARROT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PARROT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PARROT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PARROT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PARROT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/parrot_coins"));

            Advancement penguinCoinSet = getAdvancement(parrotCoinSet, ModItems.COPPER_PENGUIN_COIN.get(),
                    "penguinCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PENGUIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PENGUIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PENGUIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PENGUIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PENGUIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/penguin_coins"));

            Advancement phantomCoinSet = getAdvancement(penguinCoinSet, ModItems.COPPER_PHANTOM_COIN.get(),
                    "phantomCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PHANTOM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PHANTOM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PHANTOM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PHANTOM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PHANTOM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/phantom_coins"));

            Advancement pigCoinSet = getAdvancement(phantomCoinSet, ModItems.COPPER_PIG_COIN.get(),
                    "pigCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIG_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIG_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIG_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIG_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIG_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/pig_coins"));

            Advancement piglinCoinSet = getAdvancement(pigCoinSet, ModItems.COPPER_PIGLIN_COIN.get(),
                    "piglinCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/piglin_coins"));

            Advancement piglinBruteCoinSet = getAdvancement(piglinCoinSet, ModItems.COPPER_PIGLIN_BRUTE_COIN.get(),
                    "piglinBruteCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_BRUTE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/piglin_brute_coins"));

            Advancement collectibleTodePiglinsCoins = getAdvancement(piglinBruteCoinSet, ModItems.COPPER_PIGLIN_MERCHANT_COIN.get(),
                    "collectibleTodePiglinsCoins", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PIGLIN_MERCHANT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PIGLIN_MERCHANT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PIGLIN_MERCHANT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/todepiglins_coins"));

            Advancement pillagerCoinSet = getAdvancement(collectibleTodePiglinsCoins, ModItems.COPPER_PILLAGER_COIN.get(),
                    "pillagerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PILLAGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/pillager_coins"));

            Advancement polarBearCoinSet = getAdvancement(pillagerCoinSet, ModItems.COPPER_POLAR_BEAR_COIN.get(),
                    "polarBearCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_POLAR_BEAR_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_POLAR_BEAR_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_POLAR_BEAR_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_POLAR_BEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_POLAR_BEAR_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/polar_bear_coins"));

            Advancement pufferfishCoinSet = getAdvancement(polarBearCoinSet, ModItems.COPPER_PUFFERFISH_COIN.get(),
                    "pufferfishCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_PUFFERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PUFFERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_PUFFERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_PUFFERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_PUFFERFISH_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/pufferfish_coins"));

            Advancement rabbitCoinSet = getAdvancement(pufferfishCoinSet, ModItems.COPPER_RABBIT_COIN.get(),
                    "rabbitCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_RABBIT_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_RABBIT_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_RABBIT_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_RABBIT_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_RABBIT_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/rabbit_coins"));

            Advancement rascalCoinSet = getAdvancement(rabbitCoinSet, ModItems.COPPER_RASCAL_COIN.get(),
                    "rascalCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_RASCAL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_RASCAL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_RASCAL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_RASCAL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_RASCAL_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/rascal_coins"));

            Advancement ravagerCoinSet = getAdvancement(rascalCoinSet, ModItems.COPPER_RAVAGER_COIN.get(),
                    "ravagerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_RAVAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_RAVAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_RAVAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_RAVAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_RAVAGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/ravager_coins"));

            Advancement salmonCoinSet = getAdvancement(ravagerCoinSet, ModItems.COPPER_SALMON_COIN.get(),
                    "salmonCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SALMON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SALMON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SALMON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SALMON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SALMON_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/salmon_coins"));

            Advancement sheepCoinSet = getAdvancement(salmonCoinSet, ModItems.COPPER_SHEEP_COIN.get(),
                    "sheepCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SHEEP_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SHEEP_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SHEEP_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SHEEP_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SHEEP_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/sheep_coins"));

            Advancement shulkerCoinSet = getAdvancement(sheepCoinSet, ModItems.COPPER_SHULKER_COIN.get(),
                    "shulkerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SHULKER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SHULKER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SHULKER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SHULKER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SHULKER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/shulker_coins"));

            Advancement silverfishCoinSet = getAdvancement(shulkerCoinSet, ModItems.COPPER_SILVERFISH_COIN.get(),
                    "silverfishCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SILVERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SILVERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SILVERFISH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SILVERFISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SILVERFISH_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/silverfish_coins"));

            Advancement skeletonCoinSet = getAdvancement(silverfishCoinSet, ModItems.COPPER_SKELETON_COIN.get(),
                    "skeletonCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SKELETON_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/skeleton_coins"));

            Advancement skeletonHorseCoinSet = getAdvancement(skeletonCoinSet, ModItems.COPPER_SKELETON_HORSE_COIN.get(),
                    "skeletonHorseCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SKELETON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SKELETON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SKELETON_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SKELETON_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SKELETON_HORSE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/skeleton_horse_coins"));

            Advancement slimeCoinSet = getAdvancement(skeletonHorseCoinSet, ModItems.COPPER_SLIME_COIN.get(),
                    "slimeCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SLIME_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SLIME_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SLIME_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SLIME_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SLIME_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/slime_coins"));

            Advancement snifferCoinSet = getAdvancement(slimeCoinSet, ModItems.COPPER_SNIFFER_COIN.get(),
                    "snifferCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SNIFFER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SNIFFER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SNIFFER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/sniffer_coins"));

            Advancement snowGolemCoinSet = getAdvancement(snifferCoinSet, ModItems.COPPER_SNOW_GOLEM_COIN.get(),
                    "snowGolemCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SNOW_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SNOW_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SNOW_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SNOW_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SNOW_GOLEM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/snow_golem_coins"));

            Advancement squidCoinSet = getAdvancement(snowGolemCoinSet, ModItems.COPPER_SQUID_COIN.get(),
                    "squidCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SQUID_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SQUID_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SQUID_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/squid_coins"));

            Advancement squirrelCoinSet = getAdvancement(squidCoinSet, ModItems.COPPER_SQUIRREL_COIN.get(),
                    "squirrelCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_SQUIRREL_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_SQUIRREL_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_SQUIRREL_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_SQUIRREL_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_SQUIRREL_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/squirrel_coins"));

            Advancement strayCoinSet = getAdvancement(squirrelCoinSet, ModItems.COPPER_STRAY_COIN.get(),
                    "strayCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_STRAY_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_STRAY_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_STRAY_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_STRAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_STRAY_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/stray_coins"));

            Advancement striderCoinSet = getAdvancement(strayCoinSet, ModItems.COPPER_STRIDER_COIN.get(),
                    "striderCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_STRIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_STRIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_STRIDER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_STRIDER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_STRIDER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/strider_coins"));

            Advancement tadpoleCoinSet = getAdvancement(striderCoinSet, ModItems.COPPER_TADPOLE_COIN.get(),
                    "tadpoleCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TADPOLE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TADPOLE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TADPOLE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TADPOLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TADPOLE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/tadpole_coins"));

            Advancement traderLlamaCoinSet = getAdvancement(tadpoleCoinSet, ModItems.COPPER_TRADER_LLAMA_COIN.get(),
                    "traderLlamaCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TRADER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TRADER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TRADER_LLAMA_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TRADER_LLAMA_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TRADER_LLAMA_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/trader_llama_coins"));

            Advancement tropicalFishCoinSet = getAdvancement(traderLlamaCoinSet, ModItems.COPPER_TROPICAL_FISH_COIN.get(),
                    "tropicalFishCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TROPICAL_FISH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TROPICAL_FISH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TROPICAL_FISH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TROPICAL_FISH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TROPICAL_FISH_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/tropical_fish_coins"));

            Advancement tuffGolemCoinSet = getAdvancement(tropicalFishCoinSet, ModItems.COPPER_TUFF_GOLEM_COIN.get(),
                    "tuffGolemCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TUFF_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TUFF_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TUFF_GOLEM_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TUFF_GOLEM_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TUFF_GOLEM_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/tuff_golem_coins"));

            Advancement turtleCoinSet = getAdvancement(tuffGolemCoinSet, ModItems.COPPER_TURTLE_COIN.get(),
                    "turtleCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_TURTLE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TURTLE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_TURTLE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_TURTLE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TURTLE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/turtle_coins"));

            Advancement vexCoinSet = getAdvancement(turtleCoinSet, ModItems.COPPER_VEX_COIN.get(),
                    "vexCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_VEX_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_VEX_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_VEX_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_VEX_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_VEX_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/vex_coins"));

            Advancement villagerCoinSet = getAdvancement(vexCoinSet, ModItems.COPPER_VILLAGER_COIN.get(),
                    "villagerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_VILLAGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/villager_coins"));

            Advancement vindicatorCoinSet = getAdvancement(villagerCoinSet, ModItems.COPPER_VINDICATOR_COIN.get(),
                    "vindicatorCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_VINDICATOR_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_VINDICATOR_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_VINDICATOR_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_VINDICATOR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_VINDICATOR_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/vindicator_coins"));

            Advancement wanderingTraderCoinSet = getAdvancement(vindicatorCoinSet, ModItems.COPPER_WANDERING_TRADER_COIN.get(),
                    "wanderingTraderCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WANDERING_TRADER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WANDERING_TRADER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WANDERING_TRADER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WANDERING_TRADER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WANDERING_TRADER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wandering_trader_coins"));

            Advancement wardenCoinSet = getAdvancement(wanderingTraderCoinSet, ModItems.COPPER_WARDEN_COIN.get(),
                    "wardenCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WARDEN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WARDEN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WARDEN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WARDEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WARDEN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/warden_coins"));

            Advancement wildfireCoinSet = getAdvancement(wardenCoinSet, ModItems.COPPER_WILDFIRE_COIN.get(),
                    "wildfireCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WILDFIRE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WILDFIRE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WILDFIRE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WILDFIRE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WILDFIRE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wildfire_coins"));

            Advancement witchCoinSet = getAdvancement(wildfireCoinSet, ModItems.COPPER_WITCH_COIN.get(),
                    "witchCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WITCH_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WITCH_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WITCH_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WITCH_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WITCH_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/witch_coins"));

            Advancement witherCoinSet = getAdvancement(witchCoinSet, ModItems.COPPER_WITHER_COIN.get(),
                    "witherCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WITHER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WITHER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WITHER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WITHER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WITHER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wither_coins"));

            Advancement witherSkeletonCoinSet = getAdvancement(witherCoinSet, ModItems.COPPER_WITHER_SKELETON_COIN.get(),
                    "witherSkeletonCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WITHER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WITHER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WITHER_SKELETON_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WITHER_SKELETON_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WITHER_SKELETON_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wither_skeleton_coins"));

            Advancement wolfCoinSet = getAdvancement(witherSkeletonCoinSet, ModItems.COPPER_WOLF_COIN.get(),
                    "wolfCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_WOLF_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_WOLF_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WOLF_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/wolf_coins"));

            Advancement zoglinCoinSet = getAdvancement(wolfCoinSet, ModItems.COPPER_ZOGLIN_COIN.get(),
                    "zoglinCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zoglin_coins"));

            Advancement zombieCoinSet = getAdvancement(zoglinCoinSet, ModItems.COPPER_ZOMBIE_COIN.get(),
                    "zombieCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zombie_coins"));

            Advancement zombieHorseCoinSet = getAdvancement(zombieCoinSet, ModItems.COPPER_ZOMBIE_HORSE_COIN.get(),
                    "zombieHorseCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_HORSE_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zombie_horse_coins"));

            Advancement zombieVillagerCoinSet = getAdvancement(zombieHorseCoinSet, ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get(),
                    "zombieVillagerCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIE_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zombie_villager_coins"));

            Advancement zombifiedPiglinCoinSet = getAdvancement(zombieVillagerCoinSet, ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get(),
                    "zombifiedPiglinCoinSet", FrameType.TASK, true, true, false)


                    .addCriterion("find_" + ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get()))
                    .addCriterion("find_" + ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get()))

                    .requirements(RequirementsStrategy.AND).save(consumer, getPath("collectible/zombified_piglin_coins"));

            // Obtain all Collectible Coins
            //noinspection unused
            Advancement all_coins = getAdvancement(zombifiedPiglinCoinSet, ModItems.COPPER_HERO_COIN.get(),
                    "all_coins", FrameType.CHALLENGE, true, true, false)

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

                    .addCriterion("find_" + ModItems.BIRTHDAY_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BIRTHDAY_COIN.get()))
                    .addCriterion("find_" + ModItems.HALLOWEEN_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HALLOWEEN_COIN.get()))
                    .addCriterion("find_" + ModItems.CHRISTMAS_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHRISTMAS_COIN.get()))
                    .addCriterion("find_" + ModItems.EASTER_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EASTER_COIN.get()))
                    .addCriterion("find_" + ModItems.NEW_YEAR_COIN.get().getDescriptionId(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NEW_YEAR_COIN.get()))

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
        }

        private String getCuriosPath(String id) {
            return "curios" + ":" + id;
        }

        private String getPath(String id) {
            return TodeCoins.MODID + ":" + id;
        }
    }
}