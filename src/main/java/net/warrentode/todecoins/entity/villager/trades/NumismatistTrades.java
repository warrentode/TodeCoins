package net.warrentode.todecoins.entity.villager.trades;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import fuzs.bagofholding.init.ForgeModRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.mehvahdjukaar.cagerium.Cagerium;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemsSaleSetForItemsBuySetTrade;
import net.warrentode.todecoins.integration.SereneSeasons;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.util.CalendarUtil;

public class NumismatistTrades {
    private static ImmutableSet<ItemLike> CageriumList = ImmutableSet.of(
            Cagerium.PLATE_GEM.get().asItem().getDefaultInstance().getItem(),
            Cagerium.CAGE_KEY.get().asItem().getDefaultInstance().getItem(),
            Cagerium.FIRE_UPGRADE.get().asItem().getDefaultInstance().getItem()
                                                                        );
    private static ImmutableSet<ItemLike> CageriumBackupList = ImmutableSet.of(
            Items.SHULKER_BOX.asItem().getDefaultInstance().getItem(),
            Items.ENDER_CHEST.asItem().getDefaultInstance().getItem()
                                                                              );
    private static ImmutableSet<ItemLike> VanillaWalletList = ImmutableSet.of(
            Items.BUNDLE.asItem().getDefaultInstance().getItem(),
            Items.BUNDLE.asItem().getDefaultInstance().getItem()
                                                                             );
    private static ImmutableSet<ItemLike> BagOfHoldingWalletList = ImmutableSet.of(
            Items.BUNDLE.asItem().getDefaultInstance().getItem(),
            ForgeModRegistry.LEATHER_BAG_OF_HOLDING_ITEM.get().asItem().getDefaultInstance().getItem(),
            ForgeModRegistry.IRON_BAG_OF_HOLDING_ITEM.get().asItem().getDefaultInstance().getItem(),
            ForgeModRegistry.GOLDEN_BAG_OF_HOLDING_ITEM.get().asItem().getDefaultInstance().getItem()
                                                                                  );
    private static ImmutableSet<ItemLike> BirthdaySeasonCoins = ImmutableSet.of(
            ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem(),
            ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                                                               );
    private static ImmutableSet<ItemLike> AnniversarySeasonCoins = ImmutableSet.of(
            ModItems.MARSHALL_NASH_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.MARSHALL_NASH_COSMOS_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().asItem().getDefaultInstance().getItem()
                                                                                  );
    private static ImmutableSet<ItemLike> HalloweenSeasonCoins = ImmutableSet.of(
            ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem(),
            ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                                                                );
    private static ImmutableSet<ItemLike> ChristmasSeasonCoins = ImmutableSet.of(
            ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem(),
            ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem()
                                                                                );
    private static ImmutableSet<ItemLike> SpringSeasonCoins = ImmutableSet.of(
            ModItems.COPPER_ALLAY_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_AXOLOTL_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_BAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_BEE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_BLAZE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_CAMEL_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_CAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_CAVE_SPIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_CHICKEN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_OCELOT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_COD_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_PUFFERFISH_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_SALMON_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_TROPICAL_FISH_COIN.get().asItem().getDefaultInstance().getItem()
                                                                             );
    private static ImmutableSet<ItemLike> SummerSeasonCoins = ImmutableSet.of(
            ModItems.IRON_ALLAY_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_AXOLOTL_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_BAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_BEE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_BLAZE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_CAMEL_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_CAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_CAVE_SPIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_CHICKEN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_OCELOT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_COD_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_PUFFERFISH_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_SALMON_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_TROPICAL_FISH_COIN.get().asItem().getDefaultInstance().getItem()
                                                                             );
    private static ImmutableSet<ItemLike> AutumnSeasonCoins = ImmutableSet.of(
            ModItems.GOLD_ALLAY_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_AXOLOTL_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_BAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_BEE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_BLAZE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_CAMEL_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_CAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_CAVE_SPIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_CHICKEN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_OCELOT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_COD_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_PUFFERFISH_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_SALMON_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_TROPICAL_FISH_COIN.get().asItem().getDefaultInstance().getItem()
                                                                             );
    private static ImmutableSet<ItemLike> WinterSeasonCoins = ImmutableSet.of(
            ModItems.NETHERITE_ALLAY_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_AXOLOTL_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_BAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_BEE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_BLAZE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_CAMEL_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_CAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_CAVE_SPIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_CHICKEN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_ENDERMAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_HERO_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_OCELOT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_COD_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_PUFFERFISH_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_SALMON_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_TROPICAL_FISH_COIN.get().asItem().getDefaultInstance().getItem()
                                                                             );
    private static ImmutableSet<ItemLike> OfferedCurrentSeasonCoin = getOfferedCurrentSeasonCoin();
    private static ImmutableSet<ItemLike> RequestedCurrentSeasonCoin = getRequestedCurrentSeasonCoin();
    private static ImmutableSet<ItemLike> OfferedOffSeasonCoin = getOfferedOffSeasonCoin();
    private static ImmutableSet<ItemLike> RequestedOffSeasonCoin = getRequestedOffSeasonCoin();
    private static ImmutableSet<ItemLike> OfferedWallets = getOfferedWallets();
    private static ImmutableSet<ItemLike> CageriumOffers = getCageriumOffers();

    static int rarityLevel1 = 1;
    static int rarityLevel2 = 2;

    private static ImmutableSet<ItemLike> getOfferedCurrentSeasonCoin() {
        if (TodeCoins.isSereneSeasonsLoaded()) {
            if (SereneSeasons.Season.isBirthday()) {
                OfferedCurrentSeasonCoin = BirthdaySeasonCoins;
            }
            else if (SereneSeasons.Season.isAnniversary()) {
                OfferedCurrentSeasonCoin = AnniversarySeasonCoins;
            }
            else if (SereneSeasons.Season.isHalloween()) {
                OfferedCurrentSeasonCoin = HalloweenSeasonCoins;
            }
            else if (SereneSeasons.Season.isChristmas()) {
                OfferedCurrentSeasonCoin = ChristmasSeasonCoins;
            }
            else if (SereneSeasons.Season.isSpring()) {
                OfferedCurrentSeasonCoin = SpringSeasonCoins;
            }
            else if (SereneSeasons.Season.isSummer()) {
                OfferedCurrentSeasonCoin = SummerSeasonCoins;
            }
            else if (SereneSeasons.Season.isAutumn()) {
                OfferedCurrentSeasonCoin = AutumnSeasonCoins;
            }
            else {
                OfferedCurrentSeasonCoin = WinterSeasonCoins;
            }
        }
        else {
            if (CalendarUtil.Season.isBirthday()) {
                OfferedCurrentSeasonCoin = BirthdaySeasonCoins;
            }
            else if (CalendarUtil.Season.isAnniversary()) {
                OfferedCurrentSeasonCoin = AnniversarySeasonCoins;
            }
            else if (CalendarUtil.Season.isHalloween()) {
                OfferedCurrentSeasonCoin = HalloweenSeasonCoins;
            }
            else if (CalendarUtil.Season.isChristmas()) {
                OfferedCurrentSeasonCoin = ChristmasSeasonCoins;
            }
            else if (CalendarUtil.Season.isSpring()) {
                OfferedCurrentSeasonCoin = SpringSeasonCoins;
            }
            else if (CalendarUtil.Season.isSummer()) {
                OfferedCurrentSeasonCoin = SummerSeasonCoins;
            }
            else if (CalendarUtil.Season.isAutumn()) {
                OfferedCurrentSeasonCoin = AutumnSeasonCoins;
            }
            else {
                OfferedCurrentSeasonCoin = WinterSeasonCoins;
            }
        }
        return OfferedCurrentSeasonCoin;
    }

    private static ImmutableSet<ItemLike> getRequestedCurrentSeasonCoin() {
        if (TodeCoins.isSereneSeasonsLoaded()) {
            if (SereneSeasons.Season.isBirthday()) {
                RequestedCurrentSeasonCoin = AutumnSeasonCoins;
            }
            else if (SereneSeasons.Season.isAnniversary()) {
                RequestedCurrentSeasonCoin = WinterSeasonCoins;
            }
            else if (SereneSeasons.Season.isHalloween()) {
                RequestedCurrentSeasonCoin = AutumnSeasonCoins;
            }
            else if (SereneSeasons.Season.isChristmas()) {
                RequestedCurrentSeasonCoin = WinterSeasonCoins;
            }
            else if (SereneSeasons.Season.isSpring()) {
                RequestedCurrentSeasonCoin = SpringSeasonCoins;
            }
            else if (SereneSeasons.Season.isSummer()) {
                RequestedCurrentSeasonCoin = SummerSeasonCoins;
            }
            else if (SereneSeasons.Season.isAutumn()) {
                RequestedCurrentSeasonCoin = AutumnSeasonCoins;
            }
            else {
                RequestedCurrentSeasonCoin = WinterSeasonCoins;
            }
        }
        else {
            if (CalendarUtil.Season.isBirthday()) {
                RequestedCurrentSeasonCoin = WinterSeasonCoins;
            }
            else if (CalendarUtil.Season.isAnniversary()) {
                RequestedCurrentSeasonCoin = WinterSeasonCoins;
            }
            else if (CalendarUtil.Season.isHalloween()) {
                RequestedCurrentSeasonCoin = AutumnSeasonCoins;
            }
            else if (CalendarUtil.Season.isChristmas()) {
                RequestedCurrentSeasonCoin = WinterSeasonCoins;
            }
            else if (CalendarUtil.Season.isSpring()) {
                RequestedCurrentSeasonCoin = SpringSeasonCoins;
            }
            else if (CalendarUtil.Season.isSummer()) {
                RequestedCurrentSeasonCoin = SummerSeasonCoins;
            }
            else if (CalendarUtil.Season.isAutumn()) {
                RequestedCurrentSeasonCoin = AutumnSeasonCoins;
            }
            else {
                RequestedCurrentSeasonCoin = WinterSeasonCoins;
            }
        }

        return RequestedCurrentSeasonCoin;
    }

    private static ImmutableSet<ItemLike> getRequestedOffSeasonCoin() {
        if (OfferedCurrentSeasonCoin == BirthdaySeasonCoins) {
            RequestedOffSeasonCoin = AutumnSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == AnniversarySeasonCoins) {
            RequestedOffSeasonCoin = WinterSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == HalloweenSeasonCoins) {
            RequestedOffSeasonCoin = AutumnSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == ChristmasSeasonCoins) {
            RequestedOffSeasonCoin = WinterSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == SpringSeasonCoins) {
            RequestedOffSeasonCoin = WinterSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == SummerSeasonCoins) {
            RequestedOffSeasonCoin = SpringSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == AutumnSeasonCoins) {
            RequestedOffSeasonCoin = SummerSeasonCoins;
        }
        else {
            RequestedOffSeasonCoin = WinterSeasonCoins;
        }
        return RequestedOffSeasonCoin;
    }

    private static ImmutableSet<ItemLike> getOfferedOffSeasonCoin() {
        if (OfferedCurrentSeasonCoin == BirthdaySeasonCoins) {
            OfferedOffSeasonCoin = SpringSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == AnniversarySeasonCoins) {
            OfferedOffSeasonCoin = SummerSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == HalloweenSeasonCoins) {
            OfferedOffSeasonCoin = SpringSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == ChristmasSeasonCoins) {
            OfferedOffSeasonCoin = SummerSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == SpringSeasonCoins) {
            OfferedOffSeasonCoin = AutumnSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == SummerSeasonCoins) {
            OfferedOffSeasonCoin = WinterSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == AutumnSeasonCoins) {
            OfferedOffSeasonCoin = SpringSeasonCoins;
        }
        else {
            OfferedOffSeasonCoin = SummerSeasonCoins;
        }
        return OfferedOffSeasonCoin;
    }

    private static ImmutableSet<ItemLike> getOfferedWallets() {
        if (TodeCoins.isBagofholdingLoaded()) {
            OfferedWallets = BagOfHoldingWalletList;
        }
        else {
            OfferedWallets = VanillaWalletList;
        }
        return OfferedWallets;
    }

    private static ImmutableSet<ItemLike> getCageriumOffers() {
        if (TodeCoins.isCageriumLoaded()) {
            CageriumOffers = CageriumList;
        }
        else {
            CageriumOffers = CageriumBackupList;
        }

        return CageriumOffers;
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> pMap) {
        return new Int2ObjectOpenHashMap<>(pMap);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> NUMISMATIST_TRADES = makeNumismatistTrades();

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> makeNumismatistTrades() {

        return NUMISMATIST_TRADES = toIntMap(
                ImmutableMap.of(
                        // 5 normal, season based trades
                        rarityLevel1, new VillagerTrades.ItemListing[]{
                                // TODO create a coin box with randomize loot table to offer as a trade
                                // offer a current season coin for an off season coin
                                new ItemsSaleSetForItemsBuySetTrade(
                                        OfferedCurrentSeasonCoin, 1,
                                        RequestedOffSeasonCoin, 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // offer a current season coin for an off season coin
                                new ItemsSaleSetForItemsBuySetTrade(
                                        OfferedCurrentSeasonCoin, 1,
                                        RequestedOffSeasonCoin, 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // offer an off season coin for a current season coin
                                new ItemsSaleSetForItemsBuySetTrade(
                                        OfferedOffSeasonCoin, 1,
                                        RequestedCurrentSeasonCoin, 1,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // offer a wallet for a current season coin
                                new ItemsSaleSetForItemsBuySetTrade(
                                        OfferedWallets, 1,
                                        RequestedCurrentSeasonCoin, 2,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0),
                                // offer a wallet for an off season coin
                                new ItemsSaleSetForItemsBuySetTrade(
                                        OfferedWallets, 1,
                                        RequestedOffSeasonCoin, 2,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0)
                        },
                        // 1 rare, season based trade
                        rarityLevel2, new VillagerTrades.ItemListing[]{
                                // offer a wallet for a current season coin
                                new ItemsSaleSetForItemsBuySetTrade(
                                        CageriumOffers, 1,
                                        RequestedCurrentSeasonCoin, 10,
                                        ItemsSaleSetForItemsBuySetTrade.UNCOMMON_ITEMS_SUPPLY,
                                        ItemsSaleSetForItemsBuySetTrade.XP_LEVEL_1_SELL, 0)
                        }));
    }
}