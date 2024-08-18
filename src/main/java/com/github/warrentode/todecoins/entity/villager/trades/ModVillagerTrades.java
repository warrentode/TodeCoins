package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.config.trades.annabethsextravillagers.CarpenterTradesConfig;
import com.github.warrentode.todecoins.config.trades.annabethsextravillagers.MusicianTradesConfig;
import com.github.warrentode.todecoins.config.trades.annabethsextravillagers.PotterTradesConfig;
import com.github.warrentode.todecoins.config.trades.beautify.BotanistTradesConfig;
import com.github.warrentode.todecoins.config.trades.chefsdelight.ChefTradesConfig;
import com.github.warrentode.todecoins.config.trades.chefsdelight.CookTradesConfig;
import com.github.warrentode.todecoins.config.trades.domesticationinnovation.AnimalTamerTradesConfig;
import com.github.warrentode.todecoins.config.trades.dynamicvillage.HydraulicEngineerTradesConfig;
import com.github.warrentode.todecoins.config.trades.dynamicvillage.MechanicalEngineerTradesConfig;
import com.github.warrentode.todecoins.config.trades.dynamicvillage.TrainMechanicTradesConfig;
import com.github.warrentode.todecoins.config.trades.fastfooddelight.WaiterTradesConfig;
import com.github.warrentode.todecoins.config.trades.friendsandfoes.BeekeeperTradesConfig;
import com.github.warrentode.todecoins.config.trades.kawaiidishes.BaristaTradesConfig;
import com.github.warrentode.todecoins.config.trades.minecraft.*;
import com.github.warrentode.todecoins.config.trades.morevillagers.*;
import com.github.warrentode.todecoins.config.trades.sawmill.SawmillTradesConfig;
import com.github.warrentode.todecoins.config.trades.sewingkit.TailorTradesConfig;
import com.github.warrentode.todecoins.config.trades.todecoins.BankerTradesConfig;
import com.github.warrentode.todecoins.config.trades.todecoins.LeprechaunTradesConfig;
import com.github.warrentode.todecoins.config.trades.todevillagers.DiscJockeyTradesConfig;
import com.github.warrentode.todecoins.config.trades.todevillagers.GlassblowerTradesConfig;
import com.github.warrentode.todecoins.config.trades.todevillagers.RetiredTraderTradesConfig;
import com.github.warrentode.todecoins.config.trades.villager_enchanter.EnchanterTradesConfig;
import com.github.warrentode.todecoins.config.trades.villagersplus.AlchemistTradesConfig;
import com.github.warrentode.todecoins.config.trades.villagersplus.HorticulturistTradesConfig;
import com.github.warrentode.todecoins.config.trades.villagersplus.OccultistTradesConfig;
import com.github.warrentode.todecoins.entity.villager.ModVillagers;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table.*;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.TradeLootTables;
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
    static int BASE_XP = 5;
    static int COMMON_MAX_TRADES = 12;
    static int RARE_MAX_TRADES = 3;
    static float COMMON_TRADE_MULTIPLIER = 0.05F;
    static float RARE_TRADE_MULTIPLIER = 0.2F;
    static int CONFIG_BASE_XP = CommonConfig.getBaseXP();
    static int CONFIG_COMMON_MAX_TRADES = CommonConfig.getCommonMaxUses();
    static int CONFIG_RARE_MAX_TRADES = CommonConfig.getRareMaxUses();
    static float CONFIG_COMMON_TRADE_MULTIPLIER = (float) CommonConfig.getCommonTradeMultiplier();
    static float CONFIG_RARE_TRADE_MULTIPLIER = (float) CommonConfig.getRareTradeMultiplier();
    static boolean REPLACE_TRADES = CommonConfig.getReplaceTrades();

    //TODO: merge todepiglin with todecoins
    //TODO: add todepiglin trades

    //TODO: add dynamicvillage (create) trades

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            if (CommonConfig.getCustomTrades()) {
                // DynamicVillage mod trades
                if (ModList.get().isLoaded("dynamicvillage")) {
                    // MECHANICAL ENGINEER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("dynamicvillage:mechanical_engineer"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Request1()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Offer1()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer1Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Request2()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Offer2()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer1Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Request3()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Offer3()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer1Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Request4()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Request5()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer1Offer5()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer1Offer5Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer2Request1()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer2Offer1()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer2Request2()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer2Offer2()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer3Request1()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer3Offer1()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer3Request2()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer3Offer2()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer4Request1()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer4Offer1()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer4Request2()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer4Offer2()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer5Request1()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer5Offer1()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer5Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer5Request2()),
                                    ResourceLocation.tryParse(MechanicalEngineerTradesConfig.getMechanicalEngineer5Offer2()),
                                    MechanicalEngineerTradesConfig.getMechanicalEngineer5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // HYDRAULIC ENGINEER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("dynamicvillage:hydraulic_engineer"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Request1()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Offer1()),
                                    HydraulicEngineerTradesConfig.getHydraulicEngineer1Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Request2()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Request3()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Offer3()),
                                    HydraulicEngineerTradesConfig.getHydraulicEngineer1Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Request4()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Request5()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer1Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer2Request1()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer2Offer1()),
                                    HydraulicEngineerTradesConfig.getHydraulicEngineer2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer2Request2()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer2Offer2()),
                                    HydraulicEngineerTradesConfig.getHydraulicEngineer2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer3Request1()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer3Offer1()),
                                    HydraulicEngineerTradesConfig.getHydraulicEngineer3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer3Request2()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer3Offer2()),
                                    HydraulicEngineerTradesConfig.getHydraulicEngineer3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer4Request1()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer4Offer1()),
                                    HydraulicEngineerTradesConfig.getHydraulicEngineer4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer4Request2()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer4Offer2()),
                                    HydraulicEngineerTradesConfig.getHydraulicEngineer4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer5Request1()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer5Offer1()),
                                    HydraulicEngineerTradesConfig.getHydraulicEngineer5Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer5Request2()),
                                    ResourceLocation.tryParse(HydraulicEngineerTradesConfig.getHydraulicEngineer5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // TRAIN MECHANIC
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("dynamicvillage:train_mechanic"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic1Request1()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic1Offer1()),
                                    TrainMechanicTradesConfig.getTrainMechanic1Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic1Request2()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic1Offer2()),
                                    TrainMechanicTradesConfig.getTrainMechanic1Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic2Request1()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic2Offer1()),
                                    TrainMechanicTradesConfig.getTrainMechanic2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic2Request2()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic2Offer2()),
                                    TrainMechanicTradesConfig.getTrainMechanic2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic3Request1()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic3Offer1()),
                                    TrainMechanicTradesConfig.getTrainMechanic3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic3Request2()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic3Offer2()),
                                    TrainMechanicTradesConfig.getTrainMechanic3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic4Request1()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic4Offer1()),
                                    TrainMechanicTradesConfig.getTrainMechanic4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic4Request2()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic4Offer2()),
                                    TrainMechanicTradesConfig.getTrainMechanic4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic5Request1()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic5Offer1()),
                                    TrainMechanicTradesConfig.getTrainMechanic5Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic5Request2()),
                                    ResourceLocation.tryParse(TrainMechanicTradesConfig.getTrainMechanic5Offer2()),
                                    TrainMechanicTradesConfig.getTrainMechanic5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // MINER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("dynamicvillage:miner"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Request1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Request3()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Request4()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Offer4()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Offer4Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Request5()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Offer5()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner1Offer5Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner2Request1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner2Offer1()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner2Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner2Offer2()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner3Request1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner3Offer1()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner3Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner3Offer2()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner4Request1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner4Offer1()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner4Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner4Offer2()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner5Request1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner5Offer1()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner5Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner5Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner5Offer2()),
                                    com.github.warrentode.todecoins.config.trades.dynamicvillage.MinerTradesConfig.getMiner5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // VillagersPlus mod trades
                if (ModList.get().isLoaded("villagersplus")) {
                    // ALCHEMIST
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villagersplus:alchemist"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist1Request1()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist1Request2()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist1Request3()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist1Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist1Request4()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist1Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist2Request1()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist2Request2()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist2Request3()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist2Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist2Request4()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist2Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist3Request1()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist3Request2()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist3Request3()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist3Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist3Request4()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist3Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist4Request1()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist4Request2()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist4Request3()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist4Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist4Request4()),
                                    ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist4Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                        // potion trades
                        ForgeRegistries.MOB_EFFECTS.forEach(mobEffect ->
                                trades.get(master).add(new LootTableForPotion(
                                        mobEffect, AlchemistTradesConfig.getAlchemist5Request1Duration(),
                                        ResourceLocation.tryParse(AlchemistTradesConfig.getAlchemist5Request1()),
                                        CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * novice,
                                        CONFIG_RARE_TRADE_MULTIPLIER
                                ))
                        );
                    }
                    // HORTICULTURIST
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villagersplus:horticulturist"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Request1()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Request2()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Offer2()),
                                    HorticulturistTradesConfig.getHorticulturist1Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Request3()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Offer3()),
                                    HorticulturistTradesConfig.getHorticulturist1Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Request4()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Request5()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Request6()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Request7()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Request8()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist1Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Request1()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Request2()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Offer2()),
                                    HorticulturistTradesConfig.getHorticulturist2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Request3()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Offer3()),
                                    HorticulturistTradesConfig.getHorticulturist2Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Request4()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Request5()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Request6()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Request7()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Request8()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist2Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Request1()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Request2()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Offer2()),
                                    HorticulturistTradesConfig.getHorticulturist3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Request3()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Offer3()),
                                    HorticulturistTradesConfig.getHorticulturist3Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Request4()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Request5()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Request6()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Request7()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Request8()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist3Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Request1()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Request2()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Offer2()),
                                    HorticulturistTradesConfig.getHorticulturist4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Request3()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Offer3()),
                                    HorticulturistTradesConfig.getHorticulturist4Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Request4()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Request5()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Request6()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Request7()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Request8()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist4Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Request1()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Request2()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Offer2()),
                                    HorticulturistTradesConfig.getHorticulturist5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Request3()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Offer3()),
                                    HorticulturistTradesConfig.getHorticulturist5Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Request4()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Request5()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Request6()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Request7()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Request8()),
                                    ResourceLocation.tryParse(HorticulturistTradesConfig.getHorticulturist5Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // OCEANOGRAPHER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villagersplus:oceanographer"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer1Request1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer1Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer2Request1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer2Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer2Offer2()),
                                    com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer3Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer4Request1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer4Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer5Offer1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer5Request1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer5Request2()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            // map trade
                            trades.get(journeyman).add(new TwoLootTableForMap(
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer3Request1()),
                                    ResourceLocation.tryParse(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer3Request1Secondary()),
                                    CommonConfig.getStructureTag(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer3Request1StructureTag()),
                                    com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer3Request1MapName(),
                                    MapDecoration.Type.valueOf(com.github.warrentode.todecoins.config.trades.villagersplus.OceanographerTradesConfig.getOceanographer3Request1MapMarker()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // OCCULTIST
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villagersplus:occultist"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Request1()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Request2()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Offer2()),
                                    OccultistTradesConfig.getOccultist1Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Request3()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Offer3()),
                                    OccultistTradesConfig.getOccultist1Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Request4()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Request5()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Request6()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Request7()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Request8()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist1Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Request1()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Request2()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Offer2()),
                                    OccultistTradesConfig.getOccultist2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Request3()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Offer3()),
                                    OccultistTradesConfig.getOccultist2Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Request4()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Request5()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Request6()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Request7()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Request8()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist2Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Request1()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Request2()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Offer2()),
                                    OccultistTradesConfig.getOccultist3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Request3()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Offer3()),
                                    OccultistTradesConfig.getOccultist3Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Request4()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Request5()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Request6()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Request7()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Request8()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist3Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Request1()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Request2()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Offer2()),
                                    OccultistTradesConfig.getOccultist4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Request3()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Offer3()),
                                    OccultistTradesConfig.getOccultist4Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Request4()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Request5()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Request6()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Request7()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Request8()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist4Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Request1()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Request2()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Offer2()),
                                    OccultistTradesConfig.getOccultist5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Request3()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Offer3()),
                                    OccultistTradesConfig.getOccultist5Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Request4()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Request5()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Offer5()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Request6()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Offer6()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Request7()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Offer7()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Request8()),
                                    ResourceLocation.tryParse(OccultistTradesConfig.getOccultist5Offer8()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // DomesticationInnovation mod trades
                if (ModList.get().isLoaded("domesticationinnovation")) {
                    // ANIMAL TAMER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("domesticationinnovation:animal_tamer"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer1Request1()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer1Request2()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer1Offer2()),
                                    AnimalTamerTradesConfig.getAnimalTamer1Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer2Request1()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer2Request2()),
                                    AnimalTamerTradesConfig.getAnimalTamer2Request2Count(),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Request1()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Offer1()),
                                    AnimalTamerTradesConfig.getAnimalTamer3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Request2()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Request1()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Offer1()),
                                    AnimalTamerTradesConfig.getAnimalTamer3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Request2()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer4Request1()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer4Offer1()),
                                    AnimalTamerTradesConfig.getAnimalTamer4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer4Request2()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer5Request1()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer5Request2()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer5Offer2()),
                                    AnimalTamerTradesConfig.getAnimalTamer5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            // enchanted pet gear trades
                            trades.get(novice).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer1Offer3()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer1Request3()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                            trades.get(apprentice).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer2Offer3()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer2Request3()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                            trades.get(journeyman).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Offer3()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer3Request3()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                            trades.get(expert).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer4Offer3()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer4Request3()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                            trades.get(master).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer5Offer3()),
                                    ResourceLocation.tryParse(AnimalTamerTradesConfig.getAnimalTamer5Request3()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                        }
                    }
                }
                // KawaiiDishes mod trades
                if (ModList.get().isLoaded("kawaiidishes")) {
                    // BARISTA
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("kawaiidishes:barista"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista1Request1()),
                                    BaristaTradesConfig.getBarista1Request1Count(),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista1Request2()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista1Offer2()),
                                    BaristaTradesConfig.getBarista1Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista1Request3()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista1Offer3()),
                                    BaristaTradesConfig.getBarista1Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista1Request4()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista1Offer4()),
                                    BaristaTradesConfig.getBarista1Request4Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista2Request1()),
                                    BaristaTradesConfig.getBarista2Request1Count(),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista2Request2()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista2Offer2()),
                                    BaristaTradesConfig.getBarista2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista2Request3()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista2Offer3()),
                                    BaristaTradesConfig.getBarista2Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista2Request4()),
                                    BaristaTradesConfig.getBarista2Request4Count(),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista3Request1()),
                                    BaristaTradesConfig.getBarista3Request1Count(),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista3Request2()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista3Offer2()),
                                    BaristaTradesConfig.getBarista3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista3Request3()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista3Offer3()),
                                    BaristaTradesConfig.getBarista3Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista3Request4()),
                                    BaristaTradesConfig.getBarista3Request4Count(),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista4Request1()),
                                    BaristaTradesConfig.getBarista4Request1Count(),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista4Request2()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista4Offer2()),
                                    BaristaTradesConfig.getBarista4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista4Request3()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista4Offer3()),
                                    BaristaTradesConfig.getBarista4Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista4Request4()),
                                    BaristaTradesConfig.getBarista4Request4Count(),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista5Request1()),
                                    BaristaTradesConfig.getBarista5Request1Count(),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista5Request2()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista5Offer2()),
                                    BaristaTradesConfig.getBarista5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista5Request3()),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista5Offer3()),
                                    BaristaTradesConfig.getBarista5Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista5Request4()),
                                    BaristaTradesConfig.getBarista5Request4Count(),
                                    ResourceLocation.tryParse(BaristaTradesConfig.getBarista5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // VillagerEnchanter mod trades
                if (ModList.get().isLoaded("villager_enchanter")) {
                    // ENCHANTER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villager_enchanter:enchanter"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter1Request2()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter2Request1()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter3Request3()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter3Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter4Request1()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter5Request1()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            // enchanted book trades
                            trades.get(novice).add(new LootTableForEnchanted(
                                    Items.BOOK.getDefaultInstance(),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter1Request3()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                            trades.get(apprentice).add(new LootTableForEnchanted(
                                    Items.BOOK.getDefaultInstance(),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter2Request2()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                            trades.get(journeyman).add(new LootTableForEnchanted(
                                    Items.BOOK.getDefaultInstance(),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter3Request1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                            trades.get(expert).add(new LootTableForEnchanted(
                                    Items.BOOK.getDefaultInstance(),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter4Request2()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                            trades.get(master).add(new LootTableForEnchanted(
                                    Items.BOOK.getDefaultInstance(),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter5Request3()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_MAX_TRADES
                            ));
                            // refresh book trades
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter1Request1()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter1Offer1()),
                                    EnchanterTradesConfig.getEnchanter1Offer1Count(),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter2Request3()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter2Offer3()),
                                    EnchanterTradesConfig.getEnchanter2Offer3Count(),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter3Request2()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter3Offer2()),
                                    EnchanterTradesConfig.getEnchanter3Offer2Count(),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter4Request3()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter4Offer3()),
                                    EnchanterTradesConfig.getEnchanter4Offer3Count(),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter5Request2()),
                                    ResourceLocation.tryParse(EnchanterTradesConfig.getEnchanter5Offer2()),
                                    EnchanterTradesConfig.getEnchanter5Offer2Count(),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // FastFoodDelight mod trades
                if (ModList.get().isLoaded("fastfooddelight")) {
                    // WAITER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("fastfooddelight:fast_food_waiter"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter1Request1()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter1Offer1()),
                                    WaiterTradesConfig.getWaiter1Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter1Request2()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter1Offer2()),
                                    WaiterTradesConfig.getWaiter1Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter2Request1()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter2Offer1()),
                                    WaiterTradesConfig.getWaiter2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter2Request2()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter2Offer2()),
                                    WaiterTradesConfig.getWaiter2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter3Request1()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter3Offer1()),
                                    WaiterTradesConfig.getWaiter3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter3Request2()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter3Offer2()),
                                    WaiterTradesConfig.getWaiter3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter4Request1()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter4Offer1()),
                                    WaiterTradesConfig.getWaiter4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter4Request2()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter4Offer2()),
                                    WaiterTradesConfig.getWaiter4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter5Request1()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter5Offer1()),
                                    WaiterTradesConfig.getWaiter5Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter5Request2()),
                                    ResourceLocation.tryParse(WaiterTradesConfig.getWaiter5Offer2()),
                                    WaiterTradesConfig.getWaiter5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // ChefsDelight mod trades
                if (ModList.get().isLoaded("chefsdelight")) {
                    // CHEF
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("chefsdelight:delightchef"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef1Request1()),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef1Request2()),
                                    ChefTradesConfig.getChef1Request2Count(),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef2Request1()),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef2Offer1()),
                                    ChefTradesConfig.getChef2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef2Request2()),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef2Offer2()),
                                    ChefTradesConfig.getChef2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef3Request1()),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef3Offer1()),
                                    ChefTradesConfig.getChef3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef3Request2()),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef3Offer2()),
                                    ChefTradesConfig.getChef3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef4Request1()),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef4Offer1()),
                                    ChefTradesConfig.getChef4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef4Request2()),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef4Offer2()),
                                    ChefTradesConfig.getChef4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef5Request1()),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef5Request2()),
                                    ResourceLocation.tryParse(ChefTradesConfig.getChef5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // COOK
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("chefsdelight:delightcook"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook1Request1()),
                                    CookTradesConfig.getCook1Request1Count(),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook1Request2()),
                                    CookTradesConfig.getCook1Request2Count(),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook2Request1()),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook2Offer1()),
                                    CookTradesConfig.getCook2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook2Request2()),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook2Offer2()),
                                    CookTradesConfig.getCook2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook3Request1()),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook3Offer1()),
                                    CookTradesConfig.getCook3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook3Request2()),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook3Offer2()),
                                    CookTradesConfig.getCook3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook4Request1()),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook4Offer1()),
                                    CookTradesConfig.getCook4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook4Request2()),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook4Offer2()),
                                    CookTradesConfig.getCook4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook5Request1()),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook5Offer1()),
                                    CookTradesConfig.getCook5Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(CookTradesConfig.getCook5Request2()),
                                    ResourceLocation.tryParse(CookTradesConfig.getCook5Offer2()),
                                    CookTradesConfig.getCook5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // Beautify mod trades
                if (ModList.get().isLoaded("beautify")) {
                    // BOTANIST
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("beautify:botanist"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist1Request1()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist1Request2()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist1Request3()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist1Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist2Request1()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist2Offer1()),
                                    BotanistTradesConfig.getBotanist2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist2Request2()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist3Request1()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist3Offer1()),
                                    BotanistTradesConfig.getBotanist3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist3Request2()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist3Offer2()),
                                    BotanistTradesConfig.getBotanist3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist4Request1()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist4Request2()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist4Offer2()),
                                    BotanistTradesConfig.getBotanist4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist5Request1()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist5Request2()),
                                    ResourceLocation.tryParse(BotanistTradesConfig.getBotanist5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // SewingKit mod trades
                if (ModList.get().isLoaded("sewingkit")) {
                    // TAILOR
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("sewingkit:tailor"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor1Request1()),
                                    TailorTradesConfig.getTailor1Request1Count(),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor1Request2()),
                                    TailorTradesConfig.getTailor1Request2Count(),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor1Request3()),
                                    TailorTradesConfig.getTailor1Request3Count(),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor1Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor1Request4()),
                                    TailorTradesConfig.getTailor1Request4Count(),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor1Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForDyedArmor(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor2Request1()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForDyedArmor(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor2Request2()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForDyedArmor(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor2Request3()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor2Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForDyedArmor(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor2Request4()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor2Offer4()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor3Request1()),
                                    TailorTradesConfig.getTailor3Request1Count(),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor3Request2()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor3Offer2()),
                                    TailorTradesConfig.getTailor3Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor4Request1()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor4Offer1()),
                                    TailorTradesConfig.getTailor4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor4Request2()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor4Offer2()),
                                    TailorTradesConfig.getTailor4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor5Request1()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor5Offer1()),
                                    TailorTradesConfig.getTailor5Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor5Request2()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor5Offer2()),
                                    TailorTradesConfig.getTailor5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor5Request3()),
                                    ResourceLocation.tryParse(TailorTradesConfig.getTailor5Offer3()),
                                    TailorTradesConfig.getTailor5Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // Sawmill mod trades
                if (ModList.get().isLoaded("sawmill")) {
                    // CARPENTER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("sawmill:carpenter"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill1Request1()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill1Request2()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill2Request1()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill2Request2()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill3Request1()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill3Request2()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill4Request1()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill4Request2()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill5Offer1()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill5Request1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill5Request2()),
                                    ResourceLocation.tryParse(SawmillTradesConfig.getSawmill5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // AnnaBethsExtraVillager mod trades
                if (ModList.get().isLoaded("annabethsextravillagers")) {
                    // CARPENTER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("annabethsextravillagers:carpenter"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter1Request1()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter1Request2()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter2Request1()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter2Request2()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter3Request1()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter3Request2()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter4Request1()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter4Request2()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter5Offer1()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter5Request1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter5Request2()),
                                    ResourceLocation.tryParse(CarpenterTradesConfig.getCarpenter5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // MUSICIAN
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("annabethsextravillagers:musician"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician1Request1()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician1Request2()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician1Request3()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician1Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician2Request1()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician2Offer1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician2Request2()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician3Request1()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician3Offer1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician3Request2()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician4Request1()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician4Offer1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician4Request2()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician5Request1()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician5Offer1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician5Request2()),
                                    ResourceLocation.tryParse(MusicianTradesConfig.getMusician5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // POTTER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("annabethsextravillagers:potter"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter1Request1()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter1Request2()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter2Request1()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter2Request2()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter3Request1()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter3Request2()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter4Request1()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter4Request2()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter5Request1()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter5Request2()),
                                    ResourceLocation.tryParse(PotterTradesConfig.getPotter5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // MoreVillagers mod trades
                if (ModList.get().isLoaded("morevillagers")) {
                    // MINER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:miner"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner1Request1()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner1Request2()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner2Request1()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner2Request2()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner3Request1()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner3Request2()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner4Request1()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner4Request2()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner5Offer1()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner5Request1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner5Request2()),
                                    ResourceLocation.tryParse(MinerTradesConfig.getMiner5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // HUNTER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:hunter"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter1Request1()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter1Request2()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter2Request1()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter2Request2()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter3Request1()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter3Request2()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter4Request1()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter4Request2()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter5Request1()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter5Request2()),
                                    ResourceLocation.tryParse(HunterTradesConfig.getHunter5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // FLORIST
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:florist"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist1Request1()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist1Request2()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist2Request1()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist2Request2()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist3Request1()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist3Request2()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist4Request1()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist4Request2()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist5Request1()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist5Request2()),
                                    ResourceLocation.tryParse(FloristTradesConfig.getFlorist5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // ENGINEER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:engineer"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer1Request1()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer1Request2()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer2Request1()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer2Request2()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer3Request1()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer3Request2()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer4Request1()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer4Request2()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer5Request1()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer5Request2()),
                                    ResourceLocation.tryParse(EngineerTradesConfig.getEngineer5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // ENDERIAN
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:enderian"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian1Request1()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian1Request2()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian2Request1()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian2Request2()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian3Request1()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian3Request2()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian4Request1()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian5Request1()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian5Request2()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            // map trade
                            trades.get(expert).add(new TwoLootTableForMap(
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian4Request2()),
                                    ResourceLocation.tryParse(EnderianTradesConfig.getEnderian4Request2Secondary()),
                                    CommonConfig.getStructureTag(EnderianTradesConfig.getEnderian4Request2StructureTag()),
                                    EnderianTradesConfig.getEnderian4Request2MapName(),
                                    MapDecoration.Type.valueOf(EnderianTradesConfig.getEnderian4Request2MapMarker()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // WOODWORKER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:woodworker"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker1Request1()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker1Request2()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker2Request1()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker2Request2()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker3Request1()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker3Request2()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker4Request1()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker4Request2()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker5Offer1()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker5Request1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker5Request2()),
                                    ResourceLocation.tryParse(WoodworkerTradesConfig.getWoodworker5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // NETHERIAN
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:netherian"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian1Request1()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian1Request2()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian2Request1()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian2Request2()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian3Request1()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian4Request1()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian4Request2()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian5Request1()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian5Request2()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            // map trade
                            trades.get(journeyman).add(new TwoLootTableForMap(
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian3Request2()),
                                    ResourceLocation.tryParse(NetherianTradesConfig.getNetherian3Request2Secondary()),
                                    CommonConfig.getStructureTag(NetherianTradesConfig.getNetherian3Request2StructureTag()),
                                    NetherianTradesConfig.getNetherian3Request2MapName(),
                                    MapDecoration.Type.valueOf(NetherianTradesConfig.getNetherian3Request2MapMarker()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // OCEANOGRAPHER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:oceanographer"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer1Request1()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer1Request2()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer2Request1()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer2Request2()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer2Offer2()),
                                    OceanographerTradesConfig.getOceanographer2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer3Request2()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer4Request1()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer4Request2()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForEnchantedTable(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer5Offer1()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer5Request1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer5Request2()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            // map trade
                            trades.get(journeyman).add(new TwoLootTableForMap(
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer3Request1()),
                                    ResourceLocation.tryParse(OceanographerTradesConfig.getOceanographer3Request1Secondary()),
                                    CommonConfig.getStructureTag(OceanographerTradesConfig.getOceanographer3Request1StructureTag()),
                                    OceanographerTradesConfig.getOceanographer3Request1MapName(),
                                    MapDecoration.Type.valueOf(OceanographerTradesConfig.getOceanographer3Request1MapMarker()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // TodeVillagers mod trades
                if (ModList.get().isLoaded("todevillagers")) {
                    // RETIRED TRADER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("todevillagers:retired_trader"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader1Request1()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader1Request2()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader1Request3()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader1Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader2Request1()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader2Offer1()),
                                    RetiredTraderTradesConfig.getRetiredTrader2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader2Request2()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader2Offer2()),
                                    RetiredTraderTradesConfig.getRetiredTrader2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader2Request3()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader2Offer3()),
                                    RetiredTraderTradesConfig.getRetiredTrader2Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader3Request2()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader3Request1()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader3Offer1()),
                                    RetiredTraderTradesConfig.getRetiredTrader3Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader3Request3()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader3Offer3()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader4Request1()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader4Offer1()),
                                    RetiredTraderTradesConfig.getRetiredTrader4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader4Request2()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader4Request3()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader4Offer3()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader5Request1()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader5Offer1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader5Request2()),
                                    ResourceLocation.tryParse(RetiredTraderTradesConfig.getRetiredTrader5Offer2()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // DISC JOCKEY
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("todevillagers:disc_jockey"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey1Request1()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey1Request2()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey1Request3()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey1Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey2Request1()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey2Offer1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey2Request2()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey3Request1()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey3Offer1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey3Request2()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey4Request1()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey4Offer1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey4Request2()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey4Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey5Request1()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey5Offer1()),
                                    CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_RARE_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey5Request2()),
                                    ResourceLocation.tryParse(DiscJockeyTradesConfig.getDiscJockey5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                    // GLASSBLOWER
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("todevillagers:glassblower"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower1Request1()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower1Offer1()),
                                    GlassblowerTradesConfig.getGlassblower1Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower1Request2()),
                                    GlassblowerTradesConfig.getGlassblower1Request2Count(),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower1Request3()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower1Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower2Request1()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower2Offer1()),
                                    GlassblowerTradesConfig.getGlassblower2Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower2Request2()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower2Offer2()),
                                    GlassblowerTradesConfig.getGlassblower2Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower2Request3()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower2Offer3()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower3Request1()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower3Request2()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower4Request1()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower4Offer1()),
                                    GlassblowerTradesConfig.getGlassblower4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower4Request2()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower4Offer2()),
                                    GlassblowerTradesConfig.getGlassblower4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower5Request1()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower5Offer1()),
                                    GlassblowerTradesConfig.getGlassblower5Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower5Request2()),
                                    ResourceLocation.tryParse(GlassblowerTradesConfig.getGlassblower5Offer2()),
                                    GlassblowerTradesConfig.getGlassblower5Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // FriendsAndFoes mod trades
                if (ModList.get().isLoaded("friendsandfoes")) {
                    if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("friendsandfoes:beekeeper"))) {
                        if (REPLACE_TRADES) {
                            trades.get(novice).clear();
                            trades.get(apprentice).clear();
                            trades.get(journeyman).clear();
                            trades.get(expert).clear();
                            trades.get(master).clear();
                        }

                        for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper1Request1()),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper1Request2()),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper1Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper2Request1()),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper2Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(apprentice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper2Request2()),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper2Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper3Request1()),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper3Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper3Request2()),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(expert).add(new TagTableForLootTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper4Request1()),
                                    BeekeeperTradesConfig.getBeekeeper4Request1Count(),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper4Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper4Request2()),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper4Offer2()),
                                    BeekeeperTradesConfig.getBeekeeper4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));

                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper5Request1()),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper5Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                            trades.get(master).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper5Request2()),
                                    ResourceLocation.tryParse(BeekeeperTradesConfig.getBeekeeper5Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }

                // WEAPONSMITH
                if (event.getType() == VillagerProfession.WEAPONSMITH) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith1Request1()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith1Request2()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith2Request1()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith2Request2()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith2Offer2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith3Request1()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith3Request2()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        if (ModList.get().isLoaded("supplementaries")) {
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith4Request2()),
                                    ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith4Offer2()),
                                    WeaponsmithTradesConfig.getWeaponsmith4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                        trades.get(expert).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith4Offer1()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith4Request1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith4Request3()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith4Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith5Offer1()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith5Request1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith5Offer2()),
                                ResourceLocation.tryParse(WeaponsmithTradesConfig.getWeaponsmith5Request2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                    }
                }
                // TOOLSMITH
                if (event.getType() == VillagerProfession.TOOLSMITH) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith1Request1()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith1Request2()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith2Request1()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith2Request2()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith2Offer2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith3Request2()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith3Request1()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        if (ModList.get().isLoaded("supplementaries")) {
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith4Request3()),
                                    ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith4Offer3()),
                                    ToolsmithTradesConfig.getToolsmith4Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                        trades.get(expert).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith4Offer1()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith4Request1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith4Request2()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith4Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith5Offer3()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith5Request3()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith5Offer1()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith5Request1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith5Offer2()),
                                ResourceLocation.tryParse(ToolsmithTradesConfig.getToolsmith5Request2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                    }
                }
                // SHEPHERD
                if (event.getType() == VillagerProfession.SHEPHERD) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd1Request1()),
                                ShepherdTradesConfig.getShepherd1Request1Count(),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd1Request2()),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd2Request1()),
                                ShepherdTradesConfig.getShepherd2Request1Count(),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd2Request2()),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd2Offer2()),
                                ShepherdTradesConfig.getShepherd2Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd2Request3()),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd2Offer3()),
                                ShepherdTradesConfig.getShepherd2Offer3Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd3Request1()),
                                ShepherdTradesConfig.getShepherd3Request1Count(),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd3Request2()),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd4Request1()),
                                ShepherdTradesConfig.getShepherd4Request1Count(),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd4Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd4Request2()),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd4Offer2()),
                                ShepherdTradesConfig.getShepherd4Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd5Request1()),
                                ShepherdTradesConfig.getShepherd5Request1Count(),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd5Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd5Request2()),
                                ResourceLocation.tryParse(ShepherdTradesConfig.getShepherd5Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                    }
                }
                // MASON
                if (event.getType() == VillagerProfession.MASON) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason1Request1()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason1Request2()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason2Request1()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason2Request2()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason2Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason3Request1()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason3Request2()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason4Request1()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason4Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason4Request2()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason4Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason5Request1()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason5Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(MasonTradesConfig.getMason5Request2()),
                                ResourceLocation.tryParse(MasonTradesConfig.getMason5Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                    }
                }
                // LIBRARIAN
                if (event.getType() == VillagerProfession.LIBRARIAN) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian1Request2()),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian1Request4()),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian1Offer4()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian2Request1()),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian2Request3()),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian2Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian3Request2()),
                                LibrarianTradesConfig.getLibrarian3Request2Count(),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        if (!ModList.get().isLoaded("todevillagers")) {
                            trades.get(journeyman).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian3Request3()),
                                    ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian3Offer3()),
                                    LibrarianTradesConfig.getLibrarian3Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }

                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian4Request1()),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian4Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian4Request3()),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian4Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian5Request1()),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian5Offer1()),
                                LibrarianTradesConfig.getLibrarian5Offer1Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian5Request2()),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian5Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian5Request3()),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian5Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        // enchanted book trades
                        trades.get(novice).add(new LootTableForEnchanted(
                                Items.BOOK.getDefaultInstance(),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian1Request3()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForEnchanted(
                                Items.BOOK.getDefaultInstance(),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian2Request2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForEnchanted(
                                Items.BOOK.getDefaultInstance(),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian3Request1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForEnchanted(
                                Items.BOOK.getDefaultInstance(),
                                ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian4Request2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        // guide book trade
                        if (ModList.get().isLoaded("patchouli")) {
                            trades.get(novice).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian1Request1()),
                                    ResourceLocation.tryParse(LibrarianTradesConfig.getLibrarian1Offer1()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                    }
                }
                // LEATHERWORKER
                if (event.getType() == VillagerProfession.LEATHERWORKER) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker1Request1()),
                                LeatherworkerTradesConfig.getLeatherworker1Request1Count(),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForDyedArmor(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker1Request2()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForDyedArmor(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker1Request3()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker1Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker2Request1()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForDyedArmor(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker2Request2()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker2Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForDyedArmor(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker2Request3()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker2Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker3Request1()),
                                LeatherworkerTradesConfig.getLeatherworker3Request1Count(),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForDyedArmor(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker3Request2()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker4Request1()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker4Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForDyedArmor(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker4Request2()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker4Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker5Request1()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker5Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForDyedArmor(
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker5Request2()),
                                ResourceLocation.tryParse(LeatherworkerTradesConfig.getLeatherworker5Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                    }
                }
                // FLETCHER
                if (event.getType() == VillagerProfession.FLETCHER) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher1Request1()),
                                FletcherTradesConfig.getFletcher1Request1Count(),
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new TwoLootTableForLootTable(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher1Request2()),
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher1Request2Secondary()),
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher2Request1()),
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher2Request2()),
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher2Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher3Request1()),
                                FletcherTradesConfig.getFletcher3Request1Count(),
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher3Request2()),
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher4Offer1()),
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher4Request1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        if (ModList.get().isLoaded("supplementaries")) {
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(FletcherTradesConfig.getFletcher4Request2()),
                                    ResourceLocation.tryParse(FletcherTradesConfig.getFletcher4Offer2()),
                                    FletcherTradesConfig.getFletcher4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher4Request3()),
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher4Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForTippedArrow(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher5Request1()), 5,
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForTippedArrow(
                                ResourceLocation.tryParse(FletcherTradesConfig.getFletcher5Request2()), 5,
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                    }
                }
                // FISHERMAN
                if (event.getType() == VillagerProfession.FISHERMAN) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman1Request1()),
                                FishermanTradesConfig.getFisherman1Request1Count(),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman1Request2()),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman1Request3()),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman1Offer3()),
                                FishermanTradesConfig.getFisherman1Offer3Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman1Request4()),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman1Offer4()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman2Request1()),
                                FishermanTradesConfig.getFisherman2Request1Count(),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman2Request2()),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman2Offer2()),
                                FishermanTradesConfig.getFisherman2Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman2Request3()),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman2Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman3Request1()),
                                FishermanTradesConfig.getFisherman3Request1Count(),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman3Request2()),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        if (ModList.get().isLoaded("supplementaries")) {
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(FishermanTradesConfig.getFisherman4Request1()),
                                    ResourceLocation.tryParse(FishermanTradesConfig.getFisherman4Offer1()),
                                    FishermanTradesConfig.getFisherman4Offer1Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                        trades.get(expert).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman4Offer2()),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman4Request2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman4Request3()),
                                FishermanTradesConfig.getFisherman4Request3Count(),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman4Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman5Request1()),
                                FishermanTradesConfig.getFisherman5Request1Count(),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman5Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman5Request2()),
                                ResourceLocation.tryParse(FishermanTradesConfig.getFisherman5Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                    }
                }
                // FARMER
                if (event.getType() == VillagerProfession.FARMER) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer1Request1()),
                                FarmerTradesConfig.getFarmer1Request1Count(),
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer1Request2()),
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer1Offer2()),
                                FarmerTradesConfig.getFarmer1Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer2Request1()),
                                FarmerTradesConfig.getFarmer2Request1Count(),
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer2Request2()),
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer2Offer2()),
                                FarmerTradesConfig.getFarmer2Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, 5 + apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer3Request1()),
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer3Offer1()),
                                FarmerTradesConfig.getFarmer3Offer1Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer3Request2()),
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer3Offer2()),
                                FarmerTradesConfig.getFarmer3Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer4Request1()),
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer4Offer1()),
                                FarmerTradesConfig.getFarmer4Offer1Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer5Request1()),
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer5Offer1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer5Request2()),
                                ResourceLocation.tryParse(FarmerTradesConfig.getFarmer5Offer2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                    }
                    // sus. stew trades
                    ForgeRegistries.MOB_EFFECTS.forEach( mobEffect ->
                            trades.get(expert).add(new LootTableForSUSStew(
                                    mobEffect, 300,
                                    ResourceLocation.tryParse(FarmerTradesConfig.getFarmer4Request2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                            CONFIG_COMMON_TRADE_MULTIPLIER
                            ))
                    );
                }
                // CLERIC
                if (event.getType() == VillagerProfession.CLERIC) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric1Request1()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric1Request2()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric2Request1()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric2Request2()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric2Offer2()),
                                CONFIG_COMMON_MAX_TRADES, 5 + apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric3Request1()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric3Request2()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, 5 + journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric4Request1()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric4Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric4Request2()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric4Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric4Request3()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric4Offer3()),
                                CONFIG_COMMON_MAX_TRADES, 5 + expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric5Request1()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric5Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric5Request2()),
                                ResourceLocation.tryParse(ClericTradesConfig.getCleric5Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                    }
                }
                // CARTOGRAPHER
                if (event.getType() == VillagerProfession.CARTOGRAPHER) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer1Request1()),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer1Request2()),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer2Request1()),
                                CartographerTradesConfig.getCartographer2Request1Count(),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer3Request1()),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer4Request1()),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer4Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer4Request2()),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer4Offer2()),
                                CartographerTradesConfig.getCartographer4Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer5Request1()),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer5Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        // map trades
                        trades.get(apprentice).add(new TwoLootTableForMap(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer2Request2()),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer2Request2Secondary()),
                                CommonConfig.getStructureTag(CartographerTradesConfig.getCartographer2Request2StructureTag()),
                                CartographerTradesConfig.getCartographer2Request2MapName(),
                                MapDecoration.Type.valueOf(CartographerTradesConfig.getCartographer2Request2MapMarker()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new TwoLootTableForMap(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer3Request2()),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer3Request2Secondary()),
                                CommonConfig.getStructureTag(CartographerTradesConfig.getCartographer3Request2StructureTag()),
                                CartographerTradesConfig.getCartographer3Request2MapName(),
                                MapDecoration.Type.valueOf(CartographerTradesConfig.getCartographer3Request2MapMarker()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new TwoLootTableForMap(
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer5Request2()),
                                ResourceLocation.tryParse(CartographerTradesConfig.getCartographer5Request2Secondary()),
                                CommonConfig.getStructureTag(CartographerTradesConfig.getCartographer5Request2StructureTag()),
                                CartographerTradesConfig.getCartographer5Request2MapName(),
                                MapDecoration.Type.valueOf(CartographerTradesConfig.getCartographer5Request2MapMarker()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                    }
                }
                // BUTCHER
                if (event.getType() == VillagerProfession.BUTCHER) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher1Request1()),
                                ButcherTradesConfig.getButcher1Request1Count(),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher1Request2()),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher1Offer2()),
                                ButcherTradesConfig.getButcher1Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher2Request1()),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher2Request2()),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher2Offer2()),
                                ButcherTradesConfig.getButcher2Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher3Request1()),
                                ButcherTradesConfig.getButcher3Request1Count(),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        if (ModList.get().isLoaded("farmersdelight")) {
                            trades.get(journeyman).add(new LootTableForLootTable(
                                    ResourceLocation.tryParse(ButcherTradesConfig.getButcher3Request2()),
                                    ResourceLocation.tryParse(ButcherTradesConfig.getButcher3Offer2()),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher3Request3()),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher3Offer3()),
                                ButcherTradesConfig.getButcher3Offer3Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher4Request1()),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher4Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        if (ModList.get().isLoaded("salt") || ModList.get().isLoaded("turtleblockacademy")) {
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ButcherTradesConfig.getButcher4Request2()),
                                    ResourceLocation.tryParse(ButcherTradesConfig.getButcher4Offer2()),
                                    ButcherTradesConfig.getButcher4Offer2Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                        if (ModList.get().isLoaded("supplementaries")) {
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ButcherTradesConfig.getButcher4Request3()),
                                    ResourceLocation.tryParse(ButcherTradesConfig.getButcher4Offer3()),
                                    ButcherTradesConfig.getButcher4Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher4Request4()),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher4Offer4()),
                                ButcherTradesConfig.getButcher4Offer4Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new TagTableForLootTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher5Request1()),
                                ButcherTradesConfig.getButcher5Request1Count(),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher5Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher5Request2()),
                                ResourceLocation.tryParse(ButcherTradesConfig.getButcher5Offer2()),
                                ButcherTradesConfig.getButcher5Offer2Count(),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                    }
                }
                // ARMORER
                if (event.getType() == VillagerProfession.ARMORER) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Request1()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Request2()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Request3()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Request4()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Offer4()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Request5()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer1Offer5()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer2Request1()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer2Request2()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer2Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer2Request3()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer2Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer2Request4()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer2Offer4()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Request1()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Request2()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Request3()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Request4()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Offer4()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Request5()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Offer5()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Request6()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer3Offer6()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer4Offer1()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer4Request1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer4Offer2()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer4Request2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        if (ModList.get().isLoaded("supplementaries")) {
                            trades.get(expert).add(new LootTableForTagTable(
                                    ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer4Request3()),
                                    ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer4Offer3()),
                                    ArmorerTradesConfig.getArmorer4Offer3Count(),
                                    CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                    CONFIG_COMMON_TRADE_MULTIPLIER
                            ));
                        }

                        trades.get(master).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer5Offer1()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer5Request1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForEnchantedTable(
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer5Offer2()),
                                ResourceLocation.tryParse(ArmorerTradesConfig.getArmorer5Request2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                    }
                }

                // BANKER TRADES SET
                if (event.getType() == ModVillagers.BANKER.get()) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker1Request1()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker1Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker1Request2()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker1Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker2Request1()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker2Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker2Request2()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker2Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker3Request1()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker3Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker3Request2()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker3Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker4Request1()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker4Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker4Request2()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker4Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker5Request1()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker5Offer1()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker5Request2()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker5Offer2()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker5Request3()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker5Offer3()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker5Request4()),
                                ResourceLocation.tryParse(BankerTradesConfig.getBanker5Offer4()),
                                CONFIG_COMMON_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_COMMON_TRADE_MULTIPLIER
                        ));
                    }
                }
                // LEPRECHAUN TRADES SET
                if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                    if (REPLACE_TRADES) {
                        trades.get(novice).clear();
                        trades.get(apprentice).clear();
                        trades.get(journeyman).clear();
                        trades.get(expert).clear();
                        trades.get(master).clear();
                    }

                    for (int i = 0; i < CommonConfig.getMaxVillagerTrades(); ++i) {
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun1Request1()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun1Offer1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(novice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun1Request2()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun1Offer2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * novice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));

                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Request1()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Offer1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Request2()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Offer2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Request3()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Offer3()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Request4()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Offer4()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Request5()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Offer5()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(apprentice).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Request6()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun2Offer6()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * apprentice,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));

                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Request1()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Offer1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Request2()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Offer2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Request3()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Offer3()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Request4()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Offer4()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Request5()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Offer5()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Request6()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun3Offer6()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * journeyman,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));

                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun4Request1()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun4Offer1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(expert).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun4Request2()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun4Offer2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * expert,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));

                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun5Request1()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun5Offer1()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun5Request2()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun5Offer2()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                        trades.get(master).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun5Request3()),
                                ResourceLocation.tryParse(LeprechaunTradesConfig.getLeprechaun5Offer3()),
                                CONFIG_RARE_MAX_TRADES, CONFIG_BASE_XP * master,
                                CONFIG_RARE_TRADE_MULTIPLIER
                        ));
                    }
                }
            }

            else {
                // BANKER DEFAULT TRADES SET
                if (event.getType() == ModVillagers.BANKER.get()) {
                    trades.get(novice).add(new ItemForLootTable(
                            Items.EMERALD.getDefaultInstance(), 1,
                            TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            Items.EMERALD.getDefaultInstance(), 1,
                            COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.EMERALD.getDefaultInstance(), 16,
                            TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                            Items.EMERALD.getDefaultInstance(), 16,
                            COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.EMERALD.getDefaultInstance(), 32,
                            TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForItem(
                            TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                            Items.EMERALD.getDefaultInstance(), 32,
                            COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForItem(
                            TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                            Items.EMERALD.getDefaultInstance(), 64,
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new ItemForLootTable(
                            Items.EMERALD.getDefaultInstance(), 64,
                            TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                            COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            TradeLootTables.SINGLE_EMERALD_VALUE_METALS,
                            Items.EMERALD.getDefaultInstance(), 1,
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            Items.EMERALD.getDefaultInstance(), 1,
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            TradeLootTables.EMERALD_BANK_NOTE_VALUE_METALS,
                            ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1,
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            TradeLootTables.EMERALD_BANK_NOTE_VALUE_GEMS,
                            ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1,
                            COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                    ));
                }
                // LEPRECHAUN DEFAULT TRADES SET
                if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                    trades.get(novice).add(new LootTableForItem(
                            TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY,
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                            RARE_MAX_TRADES, BASE_XP * novice, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(novice).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                            TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY,
                            RARE_MAX_TRADES, BASE_XP * novice, RARE_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForItem(
                            TradeLootTables.TWO_POT_OF_GOLD_VALUE_GEMS,
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                            RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            TradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS,
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                            RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                            TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY,
                            RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                            TradeLootTables.FOUR_POT_OF_GOLD_VALUE_GEMS,
                            RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                            TradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS,
                            RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                            TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY,
                            RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                            TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_ITEMS,
                            RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                            TradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_CURRENCY,
                            RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                            TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_GEMS,
                            RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                            TradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_CURRENCY,
                            RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                            TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_ITEMS,
                            RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new ItemForLootTable(
                            ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                            TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_GEMS,
                            RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForItem(
                            TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY,
                            ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                            RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(expert).add(new ItemForLootTable(
                            ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                            TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY,
                            RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            TradeLootTables.SINGLE_LUCKY_COIN_VALUE_GEMS,
                            ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            TradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS,
                            ModItems.LUCKY_COIN.get().getDefaultInstance(), 3,
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS,
                            ModItems.LUCKY_COIN.get().getDefaultInstance(), 27,
                            RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                    ));
                }
            }
        }
    }
}