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
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.util.CalendarUtil;

public class NumismatistTrades {
    private static ImmutableSet<ItemLike> CageriumList = ImmutableSet.of(
            Cagerium.PLATE_GEM.get().asItem().getDefaultInstance().getItem(),
            Cagerium.CAGE_KEY.get().asItem().getDefaultInstance().getItem(),
            Cagerium.FIRE_UPGRADE.get().asItem().getDefaultInstance().getItem());
    private static ImmutableSet<ItemLike> CageriumBackupList = ImmutableSet.of(
            Items.SHULKER_BOX.asItem().getDefaultInstance().getItem(),
            Items.ENDER_CHEST.asItem().getDefaultInstance().getItem());
    private static ImmutableSet<ItemLike> VanillaWalletList = ImmutableSet.of(
            Items.BUNDLE.asItem().getDefaultInstance().getItem(),
            Items.BUNDLE.asItem().getDefaultInstance().getItem());
    private static ImmutableSet<ItemLike> BagOfHoldingWalletList = ImmutableSet.of(
            Items.BUNDLE.asItem().getDefaultInstance().getItem(),
            ForgeModRegistry.LEATHER_BAG_OF_HOLDING_ITEM.get().asItem().getDefaultInstance().getItem(),
            ForgeModRegistry.IRON_BAG_OF_HOLDING_ITEM.get().asItem().getDefaultInstance().getItem(),
            ForgeModRegistry.GOLDEN_BAG_OF_HOLDING_ITEM.get().asItem().getDefaultInstance().getItem());
    private static ImmutableSet<ItemLike> BirthdaySeasonCoins = ImmutableSet.of(
            ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem(),
            ModItems.BIRTHDAY_COIN_2023.get().asItem().getDefaultInstance().getItem());
    private static ImmutableSet<ItemLike> AnniversarySeasonCoins = ImmutableSet.of(
            ModItems.MARSHALL_NASH_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.MARSHALL_NASH_COSMOS_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().asItem().getDefaultInstance().getItem());
    private static ImmutableSet<ItemLike> HalloweenSeasonCoins = ImmutableSet.of(
            ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem(),
            ModItems.HALLOWEEN_COIN_2023.get().asItem().getDefaultInstance().getItem());
    private static ImmutableSet<ItemLike> ChristmasSeasonCoins = ImmutableSet.of(
            ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem(),
            ModItems.CHRISTMAS_COIN_2023.get().asItem().getDefaultInstance().getItem());
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
            ModItems.COPPER_TROPICAL_FISH_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_COW_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_MOOSHROOM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_MOOBLOOM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_DONKEY_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_MULE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_SKELETON_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_ZOMBIE_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_FOX_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_FROG_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_GLOW_SQUID_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_SQUID_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_PARROT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_PIG_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_HOGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_RABBIT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_SHEEP_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_SNIFFER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_SNOW_GOLEM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_STRIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_TADPOLE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_TURTLE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_VILLAGER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_WANDERING_TRADER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_NUMISMATIST_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_DOLPHIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_GOAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_IRON_GOLEM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_LLAMA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_TRADER_LLAMA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_PANDA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_POLAR_BEAR_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_SPIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_WOLF_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_CREEPER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_DROWNED_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_GUARDIAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_ELDER_GUARDIAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_ENDERMITE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.COPPER_EVOKER_COIN.get().asItem().getDefaultInstance().getItem()
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
            ModItems.IRON_TROPICAL_FISH_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_COW_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_MOOSHROOM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_MOOBLOOM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_DONKEY_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_MULE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_SKELETON_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_ZOMBIE_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_FOX_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_FROG_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_GLOW_SQUID_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_SQUID_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_PARROT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_PIG_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_HOGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_RABBIT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_SHEEP_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_SNIFFER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_SNOW_GOLEM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_STRIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_TADPOLE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_TURTLE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_VILLAGER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_WANDERING_TRADER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_NUMISMATIST_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_DOLPHIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_GOAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_IRON_GOLEM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_LLAMA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_TRADER_LLAMA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_PANDA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_POLAR_BEAR_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_SPIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_WOLF_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_CREEPER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_DROWNED_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_GUARDIAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_ELDER_GUARDIAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_ENDERMITE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.IRON_EVOKER_COIN.get().asItem().getDefaultInstance().getItem()
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
            ModItems.GOLD_TROPICAL_FISH_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_COW_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_MOOSHROOM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_MOOBLOOM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_DONKEY_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_MULE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_SKELETON_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_ZOMBIE_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_FOX_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_FROG_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_GLOW_SQUID_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_SQUID_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_PARROT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_PIG_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_HOGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_RABBIT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_SHEEP_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_SNIFFER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_SNOW_GOLEM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_STRIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_TADPOLE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_TURTLE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_VILLAGER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_WANDERING_TRADER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_NUMISMATIST_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_DOLPHIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_GOAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_IRON_GOLEM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_LLAMA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_TRADER_LLAMA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_PANDA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_POLAR_BEAR_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_SPIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_WOLF_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_CREEPER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_DROWNED_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_GUARDIAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_ELDER_GUARDIAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_ENDERMITE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.GOLD_EVOKER_COIN.get().asItem().getDefaultInstance().getItem()
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
            ModItems.NETHERITE_TROPICAL_FISH_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_COW_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_MOOSHROOM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_MOOBLOOM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_DONKEY_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_MULE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_SKELETON_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_FOX_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_FROG_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_GLOW_SQUID_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_SQUID_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_PARROT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_PIG_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_HOGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_RABBIT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_SHEEP_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_SNIFFER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_SNOW_GOLEM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_STRIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_TADPOLE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_TURTLE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_VILLAGER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_WANDERING_TRADER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_NUMISMATIST_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_DOLPHIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_GOAT_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_IRON_GOLEM_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_LLAMA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_TRADER_LLAMA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_PANDA_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_POLAR_BEAR_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_SPIDER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_WOLF_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_CREEPER_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_DROWNED_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_GUARDIAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_ENDERMITE_COIN.get().asItem().getDefaultInstance().getItem(),
            ModItems.NETHERITE_EVOKER_COIN.get().asItem().getDefaultInstance().getItem()
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
        return OfferedCurrentSeasonCoin;
    }

    private static ImmutableSet<ItemLike> getRequestedCurrentSeasonCoin() {
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
        return RequestedCurrentSeasonCoin;
    }

    private static ImmutableSet<ItemLike> getRequestedOffSeasonCoin() {
        if (OfferedCurrentSeasonCoin == BirthdaySeasonCoins) {
            RequestedOffSeasonCoin = WinterSeasonCoins;
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
            RequestedOffSeasonCoin = AutumnSeasonCoins;
        }
        return RequestedOffSeasonCoin;
    }

    private static ImmutableSet<ItemLike> getOfferedOffSeasonCoin() {
        if (OfferedCurrentSeasonCoin == BirthdaySeasonCoins) {
            OfferedOffSeasonCoin = WinterSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == AnniversarySeasonCoins) {
            OfferedOffSeasonCoin = WinterSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == HalloweenSeasonCoins) {
            OfferedOffSeasonCoin = AutumnSeasonCoins;
        }
        else if (OfferedCurrentSeasonCoin == ChristmasSeasonCoins) {
            OfferedOffSeasonCoin = WinterSeasonCoins;
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