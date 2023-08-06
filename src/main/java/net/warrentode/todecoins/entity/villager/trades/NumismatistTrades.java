package net.warrentode.todecoins.entity.villager.trades;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemsForItemsTrade;
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
        if (CalendarUtil.Season.isBirthday()) {
            return addNumismatistBirthdayTrades();
        }
        if (CalendarUtil.Season.isSpring()) {
            return makeNumismatistSpringTrades();
        }
        else if (CalendarUtil.Season.isSummer()) {
            return makeNumismatistSummerTrades();
        }
        else if (CalendarUtil.Season.isAutumn()) {
            return makeNumismatistAutumnTrades();
        }
        else if (CalendarUtil.Season.isWinter()) {
            return makeNumismatistWinterTrades();
        }
        return makeNumismatistSpringTrades();
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> addNumismatistBirthdayTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.IRON_HERO_COIN.get().asItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem()
                                        ), 1,
                                        ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem()
                                        ), 1,
                                        ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem()
                                        ), 1,
                                        ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.COPPER_HERO_COIN.get().asItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem()
                                        ), 1,
                                        ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                new ItemsForItemsTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0)
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                new ItemsForItemsTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
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
                                        ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeNumismatistSpringTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.IRON_HERO_COIN.get().asItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem()
                                        ), 1,
                                        ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                new ItemsForItemsTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0)
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                new ItemsForItemsTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
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
                                        ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeNumismatistSummerTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.COPPER_COIN.get().asItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem()
                                        ), 1,
                                        ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                new ItemsForItemsTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0)
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                new ItemsForItemsTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
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
                                        ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeNumismatistAutumnTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.COPPER_COIN.get().asItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem(),
                                                ModItems.NETHERITE_HERO_COIN.get().asItem()
                                        ), 1,
                                        ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                new ItemsForItemsTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0)
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                new ItemsForItemsTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
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
                                        ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeNumismatistWinterTrades() {
        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                new ItemsSaleSetForItemsTrade(
                                        ImmutableSet.of(
                                                ModItems.COPPER_COIN.get().asItem(),
                                                ModItems.IRON_HERO_COIN.get().asItem(),
                                                ModItems.GOLD_HERO_COIN.get().asItem()
                                        ), 1,
                                        ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0),
                                new ItemsForItemsTrade(
                                        Items.BUNDLE.getDefaultInstance(), 1,
                                        ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0)
                        },
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                new ItemsForItemsTrade(
                                        Blocks.ENDER_CHEST.asItem().getDefaultInstance(), 1,
                                        ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsForItemsTrade.XP_LEVEL_1_SELL, 0),
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
                                        ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance(), 1,
                                        ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsTrade.XP_LEVEL_1_SELL, 0)
                        }
                )
        );
    }
}