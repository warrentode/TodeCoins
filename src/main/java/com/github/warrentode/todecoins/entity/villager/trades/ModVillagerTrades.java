package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.config.CommonConfig;
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

    //TODO: add morevillagers trades
    //TODO: add annabethsextravillagers trades
    //TODO: add sewingkit trades
    //TODO: add beautify trades
    //TODO: add chefsdelight trades
    //TODO: add domesticationinnovation trades
    //TODO: add dynamicvillage (create) trades
    //TODO: add fastfooddelight trades
    //TODO: add goblintraders trades json files?
    //TODO: add sawmill trades
    //TODO: add todepiglin trades
    //TODO: merge todepiglin with todecoins
    //TODO: add unusualend wandering trader trades?
    //TODO: add villagerenchanter trades
    //TODO: add villagersplus trades
    //TODO: add wares trades?

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            if (CommonConfig.getCustomTrades()) {
                // vanilla trades
                // WEAPONSMITH
                if (event.getType() == VillagerProfession.WEAPONSMITH) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith1Request1()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith2Offer2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith3Request1()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getWeaponsmith4Request2()),
                                ResourceLocation.tryParse(CommonConfig.getWeaponsmith4Offer2()),
                                CommonConfig.getWeaponsmith4Offer2Count(),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith4Offer1()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith4Request1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith4Request3()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith4Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith5Offer1()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith5Request1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith5Offer2()),
                            ResourceLocation.tryParse(CommonConfig.getWeaponsmith5Request2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getToolsmith1Request1()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith2Offer2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith3Request1()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getToolsmith4Request3()),
                                ResourceLocation.tryParse(CommonConfig.getToolsmith4Offer3()),
                                CommonConfig.getToolsmith4Offer3Count(),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith4Offer1()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith4Request1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith4Request2()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith4Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith5Offer3()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith5Request3()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith5Offer1()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith5Request1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getToolsmith5Offer2()),
                            ResourceLocation.tryParse(CommonConfig.getToolsmith5Request2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getShepherd1Request1()),
                            CommonConfig.getShepherd1Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getShepherd1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getShepherd1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd2Request1()),
                            CommonConfig.getShepherd2Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getShepherd2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getShepherd2Offer2()),
                            CommonConfig.getShepherd2Offer2Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd2Request3()),
                            ResourceLocation.tryParse(CommonConfig.getShepherd2Offer3()),
                            CommonConfig.getShepherd2Offer3Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd3Request1()),
                            CommonConfig.getShepherd3Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getShepherd3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getShepherd3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd4Request1()),
                            CommonConfig.getShepherd4Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getShepherd4Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd4Request2()),
                            ResourceLocation.tryParse(CommonConfig.getShepherd4Offer2()),
                            CommonConfig.getShepherd4Offer2Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd5Request1()),
                            CommonConfig.getShepherd5Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getShepherd5Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getShepherd5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getShepherd5Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getMason1Request1()),
                            ResourceLocation.tryParse(CommonConfig.getMason1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMason1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getMason1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMason2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getMason2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMason2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getMason2Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMason3Request1()),
                            ResourceLocation.tryParse(CommonConfig.getMason3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMason3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getMason3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMason4Request1()),
                            ResourceLocation.tryParse(CommonConfig.getMason4Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMason4Request2()),
                            ResourceLocation.tryParse(CommonConfig.getMason4Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMason5Request1()),
                            ResourceLocation.tryParse(CommonConfig.getMason5Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getMason5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getMason5Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
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
                                ResourceLocation.tryParse(CommonConfig.getLibrarian1Request1()),
                                ResourceLocation.tryParse(CommonConfig.getLibrarian1Offer1()),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian1Request3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian1Request4()),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian1Offer4()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian2Request2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian2Request3()),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian2Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian3Request1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian3Request2()),
                            CommonConfig.getLibrarian3Request2Count(),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    if (!ModList.get().isLoaded("todevillagers")) {
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getLibrarian3Request3()),
                                ResourceLocation.tryParse(CommonConfig.getLibrarian3Offer3()),
                                CommonConfig.getLibrarian3Offer3Count(),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian4Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian4Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian4Request2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian4Request3()),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian4Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian5Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian5Offer1()),
                            CommonConfig.getLibrarian5Offer1Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLibrarian5Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getLibrarian5Request3()),
                            Items.NAME_TAG.getDefaultInstance(), 1,
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker1Request1()),
                            CommonConfig.getLeatherworker1Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker1Request3()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker1Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker2Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker2Request3()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker2Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker3Request1()),
                            CommonConfig.getLeatherworker3Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker4Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker4Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(expert).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker4Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker4Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker5Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker5Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherworker5Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getFletcher1Request1()),
                            CommonConfig.getFletcher1Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getFletcher1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new TwoLootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFletcher1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFletcher1Request2Secondary()),
                            ResourceLocation.tryParse(CommonConfig.getFletcher1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFletcher2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getFletcher2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFletcher2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFletcher2Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFletcher3Request1()),
                            CommonConfig.getFletcher3Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getFletcher3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFletcher3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFletcher3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getFletcher4Offer1()),
                            ResourceLocation.tryParse(CommonConfig.getFletcher4Request1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getFletcher4Request2()),
                                ResourceLocation.tryParse(CommonConfig.getFletcher4Offer2()),
                                CommonConfig.getFletcher4Offer2Count(),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFletcher4Request3()),
                            ResourceLocation.tryParse(CommonConfig.getFletcher4Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new TippedArrowForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFletcher5Request1()), 5,
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new TippedArrowForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFletcher5Request2()), 5,
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getFisherman1Request1()),
                            CommonConfig.getFisherman1Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getFisherman1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFisherman1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman1Request3()),
                            ResourceLocation.tryParse(CommonConfig.getFisherman1Offer3()),
                            CommonConfig.getFisherman1Offer3Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman1Request4()),
                            ResourceLocation.tryParse(CommonConfig.getFisherman1Offer4()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman2Request1()),
                            CommonConfig.getFisherman2Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getFisherman2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFisherman2Offer2()),
                            CommonConfig.getFisherman2Offer2Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman2Request3()),
                            ResourceLocation.tryParse(CommonConfig.getFisherman2Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman3Request1()),
                            CommonConfig.getFisherman3Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getFisherman3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFisherman3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getFisherman4Request1()),
                                ResourceLocation.tryParse(CommonConfig.getFisherman4Offer1()),
                                CommonConfig.getFisherman4Offer1Count(),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman4Offer2()),
                            ResourceLocation.tryParse(CommonConfig.getFisherman4Request2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(expert).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman4Request3()),
                            CommonConfig.getFisherman4Request3Count(),
                            ResourceLocation.tryParse(CommonConfig.getFisherman4Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman5Request1()),
                            CommonConfig.getFisherman5Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getFisherman5Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFisherman5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFisherman5Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getFarmer1Request1()),
                            CommonConfig.getFarmer1Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getFarmer1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getFarmer1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFarmer1Offer2()),
                            CommonConfig.getFarmer1Offer2Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFarmer2Request1()),
                            CommonConfig.getFarmer2Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getFarmer2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getFarmer2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFarmer2Offer2()),
                            CommonConfig.getFarmer2Offer2Count(),
                            CommonConfig.getCommonMaxUses(), 5 + apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getFarmer3Request1()),
                            ResourceLocation.tryParse(CommonConfig.getFarmer3Offer1()),
                            CommonConfig.getFarmer3Offer1Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getFarmer3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFarmer3Offer2()),
                            CommonConfig.getFarmer3Offer2Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getFarmer4Request1()),
                            ResourceLocation.tryParse(CommonConfig.getFarmer4Offer1()),
                            CommonConfig.getFarmer4Offer1Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    ForgeRegistries.MOB_EFFECTS.forEach( mobEffect ->
                            trades.get(expert).add(new SUSStewForLootTable(
                                    mobEffect, 300,
                                    ResourceLocation.tryParse(CommonConfig.getFarmer4Request2()),
                                    CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                            ))
                    );

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFarmer5Request1()),
                            ResourceLocation.tryParse(CommonConfig.getFarmer5Offer1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFarmer5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getFarmer5Offer2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getCleric1Request1()),
                            ResourceLocation.tryParse(CommonConfig.getCleric1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCleric1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getCleric2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCleric2Offer2()),
                            CommonConfig.getCommonMaxUses(), 5 + apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric3Request1()),
                            ResourceLocation.tryParse(CommonConfig.getCleric3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCleric3Offer2()),
                            CommonConfig.getCommonMaxUses(), 5 + journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric4Request1()),
                            ResourceLocation.tryParse(CommonConfig.getCleric4Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric4Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCleric4Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric4Request3()),
                            ResourceLocation.tryParse(CommonConfig.getCleric4Offer3()),
                            CommonConfig.getCommonMaxUses(), 5 + expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric5Request1()),
                            ResourceLocation.tryParse(CommonConfig.getCleric5Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCleric5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCleric5Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getCartographer1Request1()),
                            ResourceLocation.tryParse(CommonConfig.getCartographer1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCartographer1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCartographer1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCartographer2Request1()),
                            CommonConfig.getCartographer2Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getCartographer2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new MapForLootTables(
                            ResourceLocation.tryParse(CommonConfig.getCartographer2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCartographer2Request2Secondary()),
                            CommonConfig.getStructureTag(CommonConfig.getCartographer2Request2StructureTag()),
                            CommonConfig.getCartographer2Request2MapName(),
                            MapDecoration.Type.valueOf(CommonConfig.getCartographer2Request2MapMarker()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCartographer3Request1()),
                            ResourceLocation.tryParse(CommonConfig.getCartographer3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new MapForLootTables(
                            ResourceLocation.tryParse(CommonConfig.getCartographer3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCartographer3Request2Secondary()),
                            CommonConfig.getStructureTag(CommonConfig.getCartographer3Request2StructureTag()),
                            CommonConfig.getCartographer3Request2MapName(),
                            MapDecoration.Type.valueOf(CommonConfig.getCartographer3Request2MapMarker()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCartographer4Request1()),
                            ResourceLocation.tryParse(CommonConfig.getCartographer4Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getCartographer4Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCartographer4Offer2()),
                            CommonConfig.getCartographer4Offer2Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getCartographer5Request1()),
                            ResourceLocation.tryParse(CommonConfig.getCartographer5Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new MapForLootTables(
                            ResourceLocation.tryParse(CommonConfig.getCartographer5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getCartographer5Request2Secondary()),
                            CommonConfig.getStructureTag(CommonConfig.getCartographer5Request2StructureTag()),
                            CommonConfig.getCartographer5Request2MapName(),
                            MapDecoration.Type.valueOf(CommonConfig.getCartographer5Request2MapMarker()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getButcher1Request1()),
                            CommonConfig.getButcher1Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getButcher1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getButcher1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getButcher1Offer2()),
                            CommonConfig.getButcher1Offer2Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getButcher2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getButcher2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getButcher2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getButcher2Offer2()),
                            CommonConfig.getButcher2Offer2Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getButcher3Request1()),
                            CommonConfig.getButcher3Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getButcher3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    if (ModList.get().isLoaded("farmersdelight")) {
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getButcher3Request2()),
                                ResourceLocation.tryParse(CommonConfig.getButcher3Offer2()),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getButcher3Request3()),
                            ResourceLocation.tryParse(CommonConfig.getButcher3Offer3()),
                            CommonConfig.getButcher3Offer3Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getButcher4Request1()),
                            ResourceLocation.tryParse(CommonConfig.getButcher4Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    if (ModList.get().isLoaded("salt") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getButcher4Request2()),
                                ResourceLocation.tryParse(CommonConfig.getButcher4Offer2()),
                                CommonConfig.getButcher4Offer2Count(),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }
                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getButcher4Request3()),
                                ResourceLocation.tryParse(CommonConfig.getButcher4Offer3()),
                                CommonConfig.getButcher4Offer3Count(),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }
                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getButcher4Request4()),
                            ResourceLocation.tryParse(CommonConfig.getButcher4Offer4()),
                            CommonConfig.getButcher4Offer4Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getButcher5Request1()),
                            CommonConfig.getButcher5Request1Count(),
                            ResourceLocation.tryParse(CommonConfig.getButcher5Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getButcher5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getButcher5Offer2()),
                            CommonConfig.getButcher5Offer2Count(),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
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
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Request1()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Request3()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Request4()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Offer4()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Request5()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer1Offer5()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer2Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer2Request3()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer2Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer2Request4()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer2Offer4()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Request1()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Request3()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Request4()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Offer4()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Request5()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Offer5()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Request6()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer3Offer6()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer4Offer1()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer4Request1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer4Offer2()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer4Request2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getArmorer4Request3()),
                                ResourceLocation.tryParse(CommonConfig.getArmorer4Offer3()),
                                CommonConfig.getArmorer4Offer3Count(),
                                CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                        ));
                    }

                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer5Request1()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer5Offer1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getArmorer5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getArmorer5Offer2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                }

                // BANKER TRADES SET
                if (event.getType() == ModVillagers.BANKER.get()) {
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker1Request1()),
                            ResourceLocation.tryParse(CommonConfig.getBanker1Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getBanker1Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getBanker2Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getBanker2Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker3Request1()),
                            ResourceLocation.tryParse(CommonConfig.getBanker3Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getBanker3Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker4Request1()),
                            ResourceLocation.tryParse(CommonConfig.getBanker4Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker4Request2()),
                            ResourceLocation.tryParse(CommonConfig.getBanker4Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker5Request1()),
                            ResourceLocation.tryParse(CommonConfig.getBanker5Offer1()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getBanker5Offer2()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker5Request3()),
                            ResourceLocation.tryParse(CommonConfig.getBanker5Offer3()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getBanker5Request4()),
                            ResourceLocation.tryParse(CommonConfig.getBanker5Offer4()),
                            CommonConfig.getCommonMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getCommonTradeMultiplier()
                    ));
                }

                // LEPRECHAUN TRADES SET
                if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun1Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun1Offer1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun1Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun1Offer2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * novice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Offer1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Offer2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Request3()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Offer3()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Request4()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Offer4()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Request5()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Offer5()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Request6()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun2Offer6()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * apprentice,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Offer1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Offer2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Request3()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Offer3()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Request4()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Offer4()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Request5()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Offer5()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Request6()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun3Offer6()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * journeyman,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun4Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun4Offer1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun4Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun4Offer2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * expert,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun5Request1()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun5Offer1()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun5Request2()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun5Offer2()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun5Request3()),
                            ResourceLocation.tryParse(CommonConfig.getLeprechaun5Offer3()),
                            CommonConfig.getRareMaxUses(), CommonConfig.getBaseXP() * master,
                            (float) CommonConfig.getRareTradeMultiplier()
                    ));
                }
            }

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