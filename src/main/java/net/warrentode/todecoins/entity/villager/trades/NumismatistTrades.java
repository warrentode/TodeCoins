package net.warrentode.todecoins.entity.villager.trades;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemsForItemsBuySetTrade;
import net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemsForItemsTrade;
import net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemsSaleSetForItemsBuySetTrade;
import net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemsSaleSetForItemsTrade;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.util.CalendarUtil;

public class NumismatistTrades {
    static int rarityLevel1 = 1;
    static int rarityLevel2 = 2;

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> pMap) {
        return new Int2ObjectOpenHashMap<>(pMap);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> NUMISMATIST_TRADES = makeNumismatistTrades();

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeNumismatistTrades() {
        // yearly events
        if (CalendarUtil.Season.isBirthday()) {
            return makeBirthdayTrades();
        } else if (CalendarUtil.Season.isAnniversary()) {
            return makeAnniversaryTrades();
        }
        // holidays
        else if (CalendarUtil.Season.isHalloween()) {
            return makeHalloweenTrades();
        } else if (CalendarUtil.Season.isChristmas()) {
            return makeChristmasTrades();
        }
        // seasons
        else if (CalendarUtil.Season.isSpring()) {
            return makeSpringTrades();
        } else if (CalendarUtil.Season.isSummer()) {
            return makeSummerTrades();
        } else if (CalendarUtil.Season.isAutumn()) {
            return makeAutumnTrades();
        } else if (CalendarUtil.Season.isWinter()) {
            return makeWinterTrades();
        }
        return makeSpringTrades();
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeChristmasTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // newest coins - buy with copper coins
                                new ItemsForItemsTrade(
                                        ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // newest coins - buy with other coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // old coins - all old coins in one pool - buy with copper coins
                                new ItemsForItemsTrade(
                                        ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // old coins - all old coins in one pool - buy with other coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // bundle for new coin
                                new ItemsForItemsTrade(
                                        Items.BUNDLE.asItem().getDefaultInstance(), 1,
                                        ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // ender chest for new coin
                                new ItemsForItemsTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // shulker boxes for new coin
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                Blocks.SHULKER_BOX.asItem(),
                                                Blocks.BLACK_SHULKER_BOX.asItem(),
                                                Blocks.BLUE_SHULKER_BOX.asItem(),
                                                Blocks.BROWN_SHULKER_BOX.asItem(),
                                                Blocks.CYAN_SHULKER_BOX.asItem(),
                                                Blocks.GRAY_SHULKER_BOX.asItem(),
                                                Blocks.GREEN_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_BLUE_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_GRAY_SHULKER_BOX.asItem(),
                                                Blocks.LIME_SHULKER_BOX.asItem(),
                                                Blocks.MAGENTA_SHULKER_BOX.asItem(),
                                                Blocks.ORANGE_SHULKER_BOX.asItem(),
                                                Blocks.PINK_SHULKER_BOX.asItem(),
                                                Blocks.PURPLE_SHULKER_BOX.asItem(),
                                                Blocks.RED_SHULKER_BOX.asItem(),
                                                Blocks.WHITE_SHULKER_BOX.asItem(),
                                                Blocks.YELLOW_SHULKER_BOX.asItem()
                                        ), 1,
                                        ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeHalloweenTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // newest coins - buy with copper coins
                                new ItemsForItemsTrade(
                                        ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // newest coins - buy with other coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // old coins - all old coins in one pool - buy with copper coins
                                new ItemsForItemsTrade(
                                        ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // old coins - all old coins in one pool - buy with other coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // bundle for new coin
                                new ItemsForItemsTrade(
                                        Items.BUNDLE.asItem().getDefaultInstance(), 1,
                                        ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // ender chest for new coin
                                new ItemsForItemsTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // shulker boxes for new coin
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                Blocks.SHULKER_BOX.asItem(),
                                                Blocks.BLACK_SHULKER_BOX.asItem(),
                                                Blocks.BLUE_SHULKER_BOX.asItem(),
                                                Blocks.BROWN_SHULKER_BOX.asItem(),
                                                Blocks.CYAN_SHULKER_BOX.asItem(),
                                                Blocks.GRAY_SHULKER_BOX.asItem(),
                                                Blocks.GREEN_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_BLUE_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_GRAY_SHULKER_BOX.asItem(),
                                                Blocks.LIME_SHULKER_BOX.asItem(),
                                                Blocks.MAGENTA_SHULKER_BOX.asItem(),
                                                Blocks.ORANGE_SHULKER_BOX.asItem(),
                                                Blocks.PINK_SHULKER_BOX.asItem(),
                                                Blocks.PURPLE_SHULKER_BOX.asItem(),
                                                Blocks.RED_SHULKER_BOX.asItem(),
                                                Blocks.WHITE_SHULKER_BOX.asItem(),
                                                Blocks.YELLOW_SHULKER_BOX.asItem()
                                        ), 1,
                                        ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeAnniversaryTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // newest coins - buy with copper coins
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.MARSHALL_NASH_COSMOS_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // newest coins - buy with other coins
                                new ItemsSaleSetForItemsBuySetTrade(
                                        ImmutableSet.of(
                                                ModItems.MARSHALL_NASH_COSMOS_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // old coins - all old coins in one pool - buy with copper coins
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.MARSHALL_NASH_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // old coins - all old coins in one pool - buy with other coins
                                new ItemsSaleSetForItemsBuySetTrade(
                                        ImmutableSet.of(
                                                ModItems.MARSHALL_NASH_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0)
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // bundle
                                new ItemsForItemsBuySetTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.MARSHALL_NASH_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.MARSHALL_NASH_COSMOS_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // ender chest
                                new ItemsForItemsBuySetTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.MARSHALL_NASH_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.MARSHALL_NASH_COSMOS_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // shulker boxes
                                new ItemsSaleSetForItemsBuySetTrade(
                                        ImmutableSet.of(
                                                Blocks.SHULKER_BOX.asItem(),
                                                Blocks.BLACK_SHULKER_BOX.asItem(),
                                                Blocks.BLUE_SHULKER_BOX.asItem(),
                                                Blocks.BROWN_SHULKER_BOX.asItem(),
                                                Blocks.CYAN_SHULKER_BOX.asItem(),
                                                Blocks.GRAY_SHULKER_BOX.asItem(),
                                                Blocks.GREEN_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_BLUE_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_GRAY_SHULKER_BOX.asItem(),
                                                Blocks.LIME_SHULKER_BOX.asItem(),
                                                Blocks.MAGENTA_SHULKER_BOX.asItem(),
                                                Blocks.ORANGE_SHULKER_BOX.asItem(),
                                                Blocks.PINK_SHULKER_BOX.asItem(),
                                                Blocks.PURPLE_SHULKER_BOX.asItem(),
                                                Blocks.RED_SHULKER_BOX.asItem(),
                                                Blocks.WHITE_SHULKER_BOX.asItem(),
                                                Blocks.YELLOW_SHULKER_BOX.asItem()
                                        ), 1,
                                        ImmutableSet.of(
                                                ModItems.MARSHALL_NASH_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.MARSHALL_NASH_COSMOS_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeBirthdayTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // newest coins - buy with copper coins
                                new ItemsForItemsTrade(
                                        ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // newest coins - buy with other coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // old coins - all old coins in one pool - buy with copper coins
                                new ItemsForItemsTrade(
                                        ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // old coins - all old coins in one pool - buy with other coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // bundle for new coin
                                new ItemsForItemsTrade(
                                        Items.BUNDLE.asItem().getDefaultInstance(), 1,
                                        ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // ender chest for new coin
                                new ItemsForItemsTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
                                // shulker boxes for new coin
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                Blocks.SHULKER_BOX.asItem(),
                                                Blocks.BLACK_SHULKER_BOX.asItem(),
                                                Blocks.BLUE_SHULKER_BOX.asItem(),
                                                Blocks.BROWN_SHULKER_BOX.asItem(),
                                                Blocks.CYAN_SHULKER_BOX.asItem(),
                                                Blocks.GRAY_SHULKER_BOX.asItem(),
                                                Blocks.GREEN_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_BLUE_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_GRAY_SHULKER_BOX.asItem(),
                                                Blocks.LIME_SHULKER_BOX.asItem(),
                                                Blocks.MAGENTA_SHULKER_BOX.asItem(),
                                                Blocks.ORANGE_SHULKER_BOX.asItem(),
                                                Blocks.PINK_SHULKER_BOX.asItem(),
                                                Blocks.PURPLE_SHULKER_BOX.asItem(),
                                                Blocks.RED_SHULKER_BOX.asItem(),
                                                Blocks.WHITE_SHULKER_BOX.asItem(),
                                                Blocks.YELLOW_SHULKER_BOX.asItem()
                                        ), 1,
                                        ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeSpringTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // copper hero coin buy with other hero coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.IRON_HERO_COIN.get().asItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // copper piglin coin buy with other piglin coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.IRON_PIGLIN_COIN.get().asItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // copper enderman coin buy with other enderman coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // bundle buy with copper coins
                                new ItemsForItemsBuySetTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // ender chest buy with copper coins
                                new ItemsForItemsBuySetTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // shulker boxes buy with copper coins
                                new ItemsSaleSetForItemsBuySetTrade(
                                        ImmutableSet.of(
                                                Blocks.SHULKER_BOX.asItem(),
                                                Blocks.BLACK_SHULKER_BOX.asItem(),
                                                Blocks.BLUE_SHULKER_BOX.asItem(),
                                                Blocks.BROWN_SHULKER_BOX.asItem(),
                                                Blocks.CYAN_SHULKER_BOX.asItem(),
                                                Blocks.GRAY_SHULKER_BOX.asItem(),
                                                Blocks.GREEN_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_BLUE_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_GRAY_SHULKER_BOX.asItem(),
                                                Blocks.LIME_SHULKER_BOX.asItem(),
                                                Blocks.MAGENTA_SHULKER_BOX.asItem(),
                                                Blocks.ORANGE_SHULKER_BOX.asItem(),
                                                Blocks.PINK_SHULKER_BOX.asItem(),
                                                Blocks.PURPLE_SHULKER_BOX.asItem(),
                                                Blocks.RED_SHULKER_BOX.asItem(),
                                                Blocks.WHITE_SHULKER_BOX.asItem(),
                                                Blocks.YELLOW_SHULKER_BOX.asItem()
                                        ), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeSummerTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // iron hero coin buy with other hero coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // iron piglin coin buy with other piglin coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // iron enderman coin buy with other enderman coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // bundle buy with iron coins
                                new ItemsForItemsBuySetTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // ender chest buy with iron coins
                                new ItemsForItemsBuySetTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // shulker boxes buy with iron coins
                                new ItemsSaleSetForItemsBuySetTrade(
                                        ImmutableSet.of(
                                                Blocks.SHULKER_BOX.asItem(),
                                                Blocks.BLACK_SHULKER_BOX.asItem(),
                                                Blocks.BLUE_SHULKER_BOX.asItem(),
                                                Blocks.BROWN_SHULKER_BOX.asItem(),
                                                Blocks.CYAN_SHULKER_BOX.asItem(),
                                                Blocks.GRAY_SHULKER_BOX.asItem(),
                                                Blocks.GREEN_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_BLUE_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_GRAY_SHULKER_BOX.asItem(),
                                                Blocks.LIME_SHULKER_BOX.asItem(),
                                                Blocks.MAGENTA_SHULKER_BOX.asItem(),
                                                Blocks.ORANGE_SHULKER_BOX.asItem(),
                                                Blocks.PINK_SHULKER_BOX.asItem(),
                                                Blocks.PURPLE_SHULKER_BOX.asItem(),
                                                Blocks.RED_SHULKER_BOX.asItem(),
                                                Blocks.WHITE_SHULKER_BOX.asItem(),
                                                Blocks.YELLOW_SHULKER_BOX.asItem()
                                        ), 1,
                                        ImmutableSet.of(
                                                ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeAutumnTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // gold hero coin buy with other hero coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // gold piglin coin buy with other piglin coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // gold enderman coin buy with other enderman coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // bundle buy with gold coins
                                new ItemsForItemsBuySetTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // ender chest buy with gold coins
                                new ItemsForItemsBuySetTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // shulker boxes buy with gold coins
                                new ItemsSaleSetForItemsBuySetTrade(
                                        ImmutableSet.of(
                                                Blocks.SHULKER_BOX.asItem(),
                                                Blocks.BLACK_SHULKER_BOX.asItem(),
                                                Blocks.BLUE_SHULKER_BOX.asItem(),
                                                Blocks.BROWN_SHULKER_BOX.asItem(),
                                                Blocks.CYAN_SHULKER_BOX.asItem(),
                                                Blocks.GRAY_SHULKER_BOX.asItem(),
                                                Blocks.GREEN_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_BLUE_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_GRAY_SHULKER_BOX.asItem(),
                                                Blocks.LIME_SHULKER_BOX.asItem(),
                                                Blocks.MAGENTA_SHULKER_BOX.asItem(),
                                                Blocks.ORANGE_SHULKER_BOX.asItem(),
                                                Blocks.PINK_SHULKER_BOX.asItem(),
                                                Blocks.PURPLE_SHULKER_BOX.asItem(),
                                                Blocks.RED_SHULKER_BOX.asItem(),
                                                Blocks.WHITE_SHULKER_BOX.asItem(),
                                                Blocks.YELLOW_SHULKER_BOX.asItem()
                                        ), 1,
                                        ImmutableSet.of(
                                                ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeWinterTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // netherite hero coin buy with other hero coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // netherite piglin coin buy with other piglin coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_PIGLIN_COIN.get().asItem(),
                                                ModItems.IRON_PIGLIN_COIN.get().asItem(),
                                                ModItems.GOLD_PIGLIN_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // netherite enderman coin buy with other enderman coins
                                new ItemsForItemsBuySetTrade(
                                        ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.COPPER_ENDERMAN_COIN.get().asItem(),
                                                ModItems.IRON_ENDERMAN_COIN.get().asItem(),
                                                ModItems.GOLD_ENDERMAN_COIN.get().asItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // bundle buy with netherite coins
                                new ItemsForItemsBuySetTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0
                                ),
                                // ender chest buy with netherite coins
                                new ItemsForItemsBuySetTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ImmutableSet.of(
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // shulker boxes buy with netherite coins
                                new ItemsSaleSetForItemsBuySetTrade(
                                        ImmutableSet.of(
                                                Blocks.SHULKER_BOX.asItem(),
                                                Blocks.BLACK_SHULKER_BOX.asItem(),
                                                Blocks.BLUE_SHULKER_BOX.asItem(),
                                                Blocks.BROWN_SHULKER_BOX.asItem(),
                                                Blocks.CYAN_SHULKER_BOX.asItem(),
                                                Blocks.GRAY_SHULKER_BOX.asItem(),
                                                Blocks.GREEN_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_BLUE_SHULKER_BOX.asItem(),
                                                Blocks.LIGHT_GRAY_SHULKER_BOX.asItem(),
                                                Blocks.LIME_SHULKER_BOX.asItem(),
                                                Blocks.MAGENTA_SHULKER_BOX.asItem(),
                                                Blocks.ORANGE_SHULKER_BOX.asItem(),
                                                Blocks.PINK_SHULKER_BOX.asItem(),
                                                Blocks.PURPLE_SHULKER_BOX.asItem(),
                                                Blocks.RED_SHULKER_BOX.asItem(),
                                                Blocks.WHITE_SHULKER_BOX.asItem(),
                                                Blocks.YELLOW_SHULKER_BOX.asItem()
                                        ), 1,
                                        ImmutableSet.of(
                                                ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
                                                ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem()
                                        ), 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }
}