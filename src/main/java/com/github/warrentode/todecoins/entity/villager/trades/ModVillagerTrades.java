package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.entity.villager.ModVillagers;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table.*;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.VillagerTradeLootTables;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModVillagerTrades {
    static int novice = 1;
    static int apprentice = 2;
    static int journeyman = 3;
    static int expert = 4;
    static int master = 5;
    static int BASE_XP = CommonConfig.getBaseXP();
    static int COMMON_MAX_TRADES = CommonConfig.getCommonMaxTrades();
    static int RARE_MAX_TRADES = CommonConfig.getRareMaxTrades();
    static float COMMON_TRADE_MULTIPLIER = CommonConfig.getCommonTradeMultiplier();
    static float RARE_TRADE_MULTIPLIER = CommonConfig.getRareTradeMultiplier();

    //TODO: add morevillagers trades
    //TODO: add annabethsextravillagers trades
    //TODO: add sewingkit trades
    //TODO: add beautify trades
    //TODO: add chefsdelight trades
    //TODO: add domesticationinnovation trades
    //TODO: add dynamicvillage (create) trades
    //TODO: add fastfooddelight trades
    //TODO: add goblintraders trades json files
    //TODO: add sawmill trades
    //TODO: add todepiglin trades
    //TODO: merge todepiglin with todecoins
    //TODO: add villagerenchanter trades
    //TODO: add villagersplus trades
    //TODO: add wares trades?

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            if (CommonConfig.getCustomTrades()) {
                if (ModList.get().isLoaded("todevillagers")) {
                    // RETIRED TRADER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("todevillagers:retired_trader"))) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();

                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getFlowerSellTable()),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getSaplingSellTable()),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getWanderingTraderCommonOffersTable()),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));


                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getSeedTagTable()),
                                CommonConfig.getSeedCount(),
                                COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getSlimeballTagTable()),
                                CommonConfig.getSlimeballCount(),
                                COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getCoralBlockTagTable()),
                                CommonConfig.getCoralBlockCount(),
                                COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                                COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getSandTagTable()),
                                CommonConfig.getSandCount(),
                                COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getFishBucketTable()),
                                RARE_MAX_TRADES, BASE_XP * journeyman, RARE_MAX_TRADES
                        ));

                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                                CommonConfig.getDyeSellCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getSeaShellTable()),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getSpecialDirtTable()),
                                RARE_MAX_TRADES, BASE_XP * expert, RARE_MAX_TRADES
                        ));

                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getSixEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getIceTable()),
                                RARE_MAX_TRADES, BASE_XP * master, RARE_MAX_TRADES
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getWanderingTraderRareOffersTable()),
                                RARE_MAX_TRADES, BASE_XP * master, RARE_MAX_TRADES
                        ));
                    }
                    // DISC JOCKEY
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("todevillagers:disc_jockey"))) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();

                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getDiscFragmentsTable()),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getMusicDiscTagTable()),
                                CommonConfig.getMusicDiscTagCount(),
                                COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getMusicDiscTagTable()),
                                CommonConfig.getMusicDiscTagCount(),
                                COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getMusicDiscTagTable()),
                                CommonConfig.getMusicDiscTagCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getMusicDiscTagTable()),
                                CommonConfig.getMusicDiscTagCount(),
                                COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                    // GLASSBLOWER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("todevillagers:glassblower"))) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();

                        trades.get(novice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getRecyclableGlassTagTable()),
                                CommonConfig.getRecyclableGlassTagCount(),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getSandTagTable()),
                                CommonConfig.getSandCount(),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldFuelTable()),
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassTagTable()),
                                CommonConfig.getGlassCount(),
                                COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassPaneTagTable()),
                                CommonConfig.getGlassPaneCount(),
                                COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassBottleTable()),
                                COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getSixEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassblowingToolsTagTable()),
                                CommonConfig.getGlassblowingToolsCount(),
                                COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getSixEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassblowingToolsTagTable()),
                                CommonConfig.getGlassblowingToolsCount(),
                                COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassTagTable()),
                                CommonConfig.getGlassCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassTagTable()),
                                CommonConfig.getGlassCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassTagTable()),
                                CommonConfig.getGlassCount(),
                                COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassTagTable()),
                                CommonConfig.getGlassCount(),
                                COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                }
                // BEEKEEPER
                if (ModList.get().isLoaded("friendsandfoes") && event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("friendsandfoes:beekeeper"))) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFlowerBuyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getGlassBottleTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBottledHoneyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getShearsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getHoneyBlockTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getHoneyCombTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getStringTagTable()),
                            CommonConfig.getStringCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCandleTagTable()),
                            CommonConfig.getCandleCount(),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBeehiveTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBeeEggTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // WEAPONSMITH
                if (event.getType() == VillagerProfession.WEAPONSMITH) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldFuelTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getIronWeaponTable()),
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldMetalsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBellTable()),
                            RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFlintBuyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getEquipmentGemsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getAshTagTable()),
                                CommonConfig.getAshCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getGoldTierWeaponTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getAnvilTable()),
                            ResourceLocation.tryParse(CommonConfig.getEightEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierWeaponTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getNetheriteTierWeaponTable()),
                            ResourceLocation.tryParse(CommonConfig.getLuckyCoinBagValueCurrency()),
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                }
                // TOOLSMITH
                if (event.getType() == VillagerProfession.TOOLSMITH) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldFuelTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getStoneTierToolTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldMetalsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBellTable()),
                            RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFlintBuyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierToolTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getAshTagTable()),
                                CommonConfig.getAshCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getIronTierToolTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierToolTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierToolTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getGoldTierToolTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getNetheriteTierToolTable()),
                            ResourceLocation.tryParse(CommonConfig.getLuckyCoinBagValueCurrency()),
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                }
                // SHEPHERD
                if (event.getType() == VillagerProfession.SHEPHERD) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getWoolTagTable()),
                            CommonConfig.getWoolBuyCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getShearsTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                            CommonConfig.getDyeBuyCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getWoolTagTable()),
                            CommonConfig.getWoolSellCount(),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getWoolCarpetTagTable()),
                            CommonConfig.getWoolCarpetCount(),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                            CommonConfig.getDyeBuyCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBedTagTable()),
                            CommonConfig.getBedCount(),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                            CommonConfig.getDyeBuyCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBannerTagTable()),
                            CommonConfig.getBannerCount(),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                            CommonConfig.getDyeBuyCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getPaintingsTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // MASON
                if (event.getType() == VillagerProfession.MASON) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getClayTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOverworldBrickTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOverworldStoneTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOverworldBrickBlockTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOverworldPolishedStoneTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getTerracottaTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOtherStoneTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getGlazedTerracottaTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOtherStoneTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // LIBRARIAN
                if (event.getType() == VillagerProfession.LIBRARIAN) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    if (ModList.get().isLoaded("patchouli")) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getGuideBookTable()),
                                ResourceLocation.tryParse(CommonConfig.getSmallestCoin()),
                                COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getPaperTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getNineEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBookshelfTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBookTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLanternTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getInkTagTable()),
                            CommonConfig.getInkBuyCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    if (!ModList.get().isLoaded("todevillagers")) {
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getGlassTagTable()),
                                CommonConfig.getGlassCount(),
                                COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                        ));
                    }

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBookTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getClockTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getInkTagTable()),
                            CommonConfig.getInkSellCount(),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCompassTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            Items.NAME_TAG.getDefaultInstance(), 1,
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // LEATHERWORKER
                if (event.getType() == VillagerProfession.LEATHERWORKER) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherTagTable()),
                            CommonConfig.getLeatherCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierLeggingsTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierChestplateTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFlintBuyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierHelmetTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierBootsTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherTagTable()),
                            CommonConfig.getLeatherCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierChestplateTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getScuteTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSixEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierHorseArmorTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSixEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getSaddleTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierHelmetTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // FLETCHER
                if (event.getType() == VillagerProfession.FLETCHER) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getStickTagTable()),
                            CommonConfig.getStickCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new TwoLootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getGravelTable()),
                            ResourceLocation.tryParse(CommonConfig.getFlintSellTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFlintBuyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBowsTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getStringTagTable()),
                            CommonConfig.getStringCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFeatherTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getBowsTable()),
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getQuiversTagTable()),
                                CommonConfig.getQuiverCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTripwireHookTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new TippedArrowForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()), 5,
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new TippedArrowForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()), 5,
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // FISHERMAN
                if (event.getType() == VillagerProfession.FISHERMAN) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getStringTagTable()),
                            CommonConfig.getStickCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldFuelTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getPreppedSeafoodTagTable()),
                            CommonConfig.getPreppedSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getFishBucketTable()),
                            RARE_MAX_TRADES, BASE_XP * novice, RARE_MAX_TRADES
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawSeafoodTagTable()),
                            CommonConfig.getRawSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getPreppedSeafoodTagTable()),
                            CommonConfig.getPreppedSeafoodCount(),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCampfireTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawSeafoodTagTable()),
                            CommonConfig.getRawSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getFishingGearTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getAshTagTable()),
                                CommonConfig.getAshCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getFishingRodTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawSeafoodTagTable()),
                            CommonConfig.getRawSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawSeafoodTagTable()),
                            CommonConfig.getRawSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFishingGearTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // FARMER
                if (event.getType() == VillagerProfession.FARMER) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getVegGrainTagTable()),
                            CommonConfig.getVegGrainCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBreadTagTable()),
                            CommonConfig.getBreadCount(),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getGourdTagTable()),
                            CommonConfig.getGourdCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getPieTagTable()),
                            CommonConfig.getPieCount(),
                            COMMON_MAX_TRADES, 5 + apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getFruitTagTable()),
                            CommonConfig.getFruitCount(),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCookieTagTable()),
                            CommonConfig.getCookieCount(),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCakeTagTable()),
                            CommonConfig.getCakeCount(),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    ForgeRegistries.MOB_EFFECTS.forEach( mobEffect ->
                            trades.get(expert).add(new SUSStewForLootTable(
                                    mobEffect, 300,
                                    ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                    COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                            ))
                    );

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getGoldenFoodTable()),
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                }
                // CLERIC
                if (event.getType() == VillagerProfession.CLERIC) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMobPartsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getEnchantingGemsTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldMetalsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getEnchantingGemsTable()),
                            COMMON_MAX_TRADES, 5 + apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMobPartsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getEnchantingGemsTable()),
                            COMMON_MAX_TRADES, 5 + journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getScuteTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getGlassBottleTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldGemsTable()),
                            COMMON_MAX_TRADES, 5 + expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getPotionIngredientTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getExperienceBottleTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // CARTOGRAPHER
                if (event.getType() == VillagerProfession.CARTOGRAPHER) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getPaperTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBlankMapTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getGlassPaneTagTable()),
                            CommonConfig.getGlassPaneCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new MapForLootTables(
                            ResourceLocation.tryParse(CommonConfig.getFourteenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCompassTable()),
                            CommonConfig.getStructureTag(CommonConfig.getCartographerMap1StructureTag()),
                            CommonConfig.getCartographerMap1Name(),
                            MapDecoration.Type.valueOf(CommonConfig.getCartographerMap1Marker()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCompassTable()),
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new MapForLootTables(
                            ResourceLocation.tryParse(CommonConfig.getFourteenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCompassTable()),
                            CommonConfig.getStructureTag(CommonConfig.getCartographerMap2StructureTag()),
                            CommonConfig.getCartographerMap2Name(),
                            MapDecoration.Type.valueOf(CommonConfig.getCartographerMap2Marker()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getItemFrameTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBannerTagTable()),
                            CommonConfig.getBannerCount(),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getEightEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBannerPatternTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new MapForLootTables(
                            ResourceLocation.tryParse(CommonConfig.getFourteenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCompassTable()),
                            CommonConfig.getStructureTag(CommonConfig.getCartographerMap3StructureTag()),
                            CommonConfig.getCartographerMap3Name(),
                            MapDecoration.Type.valueOf(CommonConfig.getCartographerMap3Marker()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // BUTCHER
                if (event.getType() == VillagerProfession.BUTCHER) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawMeatTagTable()),
                            CommonConfig.getRawMeatCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getMeatSoupTagTable()),
                            CommonConfig.getMeatSoupCount(),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldFuelTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCookedMeatTagTable()),
                            CommonConfig.getCookedMeatCount(),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawMeatTagTable()),
                            CommonConfig.getRawMeatCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("farmersdelight")) {
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getStoneTierKnifeTable()),
                                COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                    else {
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getCookedMeatTagTable()),
                                CommonConfig.getCookedMeatCount(),
                                COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                        ));
                    }

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldFuelTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("salt") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getSaltTagTable()),
                                CommonConfig.getSaltCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getAshTagTable()),
                                CommonConfig.getAshCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                    }
                    else {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getCookedMeatTagTable()),
                                CommonConfig.getCookedMeatCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                    }

                    trades.get(master).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_FOX_FOOD_TABLE, 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCookedMeatTagTable()),
                            CommonConfig.getCookedMeatCount(),
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // ARMORER
                if (event.getType() == VillagerProfession.ARMORER) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldFuelTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getChainmailTierHelmetTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getChainmailTierChestplateTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getChainmailTierLeggingsTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getChainmailTierBootsTable()),
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldMetalsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBellTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierLeggingsTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierBootsTable()),
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldFuelTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getEquipmentGemsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierHelmetTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getNineEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierChestplateTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getShieldTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getNineEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierHorseArmorTable()),
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierLeggingsTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierBootsTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getAshTagTable()),
                                CommonConfig.getAshCount(),
                                COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                        ));
                    }

                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierHelmetTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierChestplateTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                            RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                    ));
                }
            }

            // BANKER TRADES SET
            if (event.getType() == ModVillagers.BANKER.get()) {
                trades.get(novice).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 1,
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                ));
                trades.get(novice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        Items.EMERALD.getDefaultInstance(), 1,
                        COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                ));

                trades.get(apprentice).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 16,
                        ResourceLocation.tryParse(CommonConfig.getEmeraldQuarterNoteCurrencyTable()),
                        COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                ));
                trades.get(apprentice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldQuarterNoteCurrencyTable()),
                        Items.EMERALD.getDefaultInstance(), 16,
                        COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 32,
                        ResourceLocation.tryParse(CommonConfig.getEmeraldHalfNoteCurrencyTable()),
                        COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                ));
                trades.get(journeyman).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldHalfNoteCurrencyTable()),
                        Items.EMERALD.getDefaultInstance(), 32,
                        COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                ));

                trades.get(expert).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteCurrencyTable()),
                        Items.EMERALD.getDefaultInstance(), 64,
                        COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                ));
                trades.get(expert).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 64,
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteCurrencyTable()),
                        COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                ));

                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldMetalsTable()),
                        Items.EMERALD.getDefaultInstance(), 1,
                        COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                        Items.EMERALD.getDefaultInstance(), 1,
                        COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteMetalsTable()),
                        ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1,
                        COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteGemsTable()),
                        ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1,
                        COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                ));
            }

            // LEPRECHAUN TRADES SET
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                trades.get(novice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getTwoPotGoldCurrencyTable()),
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        RARE_MAX_TRADES, BASE_XP * novice, RARE_TRADE_MULTIPLIER
                ));
                trades.get(novice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        ResourceLocation.tryParse(CommonConfig.getTwoPotGoldCurrencyTable()),
                        RARE_MAX_TRADES, BASE_XP * novice, RARE_TRADE_MULTIPLIER
                ));

                trades.get(apprentice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getTwoGoldPotGemsTable()),
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ));
                trades.get(apprentice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getTwoGoldPotItemsTable()),
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ));

                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        ResourceLocation.tryParse(CommonConfig.getFourPotGoldCurrencyTable()),
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        ResourceLocation.tryParse(CommonConfig.getFourGoldPotItemsTable()),
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        ResourceLocation.tryParse(CommonConfig.getFourGoldPotGemsTable()),
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        ResourceLocation.tryParse(CommonConfig.getFourPotGoldCurrencyTable()),
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        ResourceLocation.tryParse(CommonConfig.getThirtyGoldPotItemsTable()),
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        ResourceLocation.tryParse(CommonConfig.getThirtyPotGoldCurrencyTable()),
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        ResourceLocation.tryParse(CommonConfig.getThirtyGoldPotGemsTable()),
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        ResourceLocation.tryParse(CommonConfig.getSixtyPotGoldCurrencyTable()),
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        ResourceLocation.tryParse(CommonConfig.getSixtyGoldPotItemsTable()),
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        ResourceLocation.tryParse(CommonConfig.getSixtyGoldPotGemsTable()),
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ));

                trades.get(expert).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneLuckyCoinCurrencyTable()),
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                ));
                trades.get(expert).add(new ItemForLootTable(
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        ResourceLocation.tryParse(CommonConfig.getOneLuckyCoinCurrencyTable()),
                        RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                ));

                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getLuckyCoinGemsTable()),
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getThreeLuckyCoinItemsTable()),
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 3,
                        RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getTwentySevenLuckyCoinItemsTable()),
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 27,
                        RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                ));
            }
        }
    }
}