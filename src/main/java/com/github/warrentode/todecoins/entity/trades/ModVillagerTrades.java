package com.github.warrentode.todecoins.entity.trades;

import com.github.warrentode.todecoins.config.Config;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom.*;
import com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types.LootTableForSealedAgreement;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import io.github.mortuusars.wares.data.agreement.component.TextProvider;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModVillagerTrades {
    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // NITWIT
            if (event.getType() == VillagerProfession.NITWIT) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();


                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).addAll(List.of(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SMALLEST_COIN,
                                    ResourceLocation.tryParse("todecoins:trade_tables/misc/player_heads"),
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.FIREWORK_ROCKET_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            )
                    ));
                }
            }
            // ARMORER
            if (event.getType() == VillagerProfession.ARMORER) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).addAll(List.of(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.CHAINMAIL_TIER_HELMETS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.CHAINMAIL_TIER_CHESTPLATES_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.CHAINMAIL_TIER_LEGGINGS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.CHAINMAIL_TIER_BOOTS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            )
                    ));
                    trades.get(TradeOfferConstants.apprentice).addAll(List.of(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_METALS,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.BELL_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.IRON_TIER_LEGGINGS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.IRON_TIER_BOOTS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            )
                    ));
                    trades.get(TradeOfferConstants.journeyman).addAll(List.of(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.EQUIPMENT_GEMS_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.IRON_TIER_HELMETS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.IRON_TIER_CHESTPLATES_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.SHIELD_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ),
                            new LootTableForLootTableFactory(
                                    TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.IRON_TIER_HORSE_ARMOR_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            )
                    ));
                    trades.get(TradeOfferConstants.expert).addAll(List.of(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.DIAMOND_TIER_LEGGINGS_TABLE,
                                    TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ),
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.DIAMOND_TIER_BOOTS_TABLE,
                                    TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ),
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_ASH_TABLE,
                                    18,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            )
                    ));
                    trades.get(TradeOfferConstants.master).addAll(List.of(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.DIAMOND_TIER_HELMETS_TABLE,
                                    TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ),
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.DIAMOND_TIER_CHESTPLATES_TABLE,
                                    TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            )
                    ));
                }
            }
            // BUTCHER
            if (event.getType() == VillagerProfession.BUTCHER) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_RAW_MEATS_TABLE,
                                    12,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_MEAT_SOUPS_TABLE,
                                    1,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                                    6,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.STONE_TIER_KNIVES,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_RAW_MEATS_TABLE,
                                    12,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                                    6,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_SALTS_TABLE,
                                    18,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_ASH_TABLE,
                                    18,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                                    6,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_FOX_FOOD_TABLE,
                                    8,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                                    6,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                }
            }
            // CARTOGRAPHER
            if (event.getType() == VillagerProfession.CARTOGRAPHER) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.PAPER_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.BLANK_MAP_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                                    16,
                                    TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new TwoLootTableForMapFactory(
                                    TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.COMPASS_TABLE,
                                    TodeCoinsTags.StructureTags.OVERWORLD_POI.location().toString(),
                                    "Exploration Map",
                                    String.valueOf(MapDecoration.Type.TARGET_POINT),
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.COMPASS_TABLE,
                                    TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new TwoLootTableForMapFactory(
                                    TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.COMPASS_TABLE,
                                    TodeCoinsTags.StructureTags.OVERWORLD_POI.location().toString(),
                                    "Exploration Map",
                                    String.valueOf(MapDecoration.Type.TARGET_POINT),
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.ITEM_FRAME_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_BANNER_TABLE,
                                    3,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.BANNER_PATTERN_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new TwoLootTableForMapFactory(
                                    TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.COMPASS_TABLE,
                                    TodeCoinsTags.StructureTags.OVERWORLD_POI.location().toString(),
                                    "Exploration Map",
                                    String.valueOf(MapDecoration.Type.TARGET_POINT),
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                }
            }
            // CLERIC
            if (event.getType() == VillagerProfession.CLERIC) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.ENCHANTING_GEMS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_METALS,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.ENCHANTING_GEMS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.ENCHANTING_GEMS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.FIVE_EMERALD_VALUE_GEMS,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.GLASS_BOTTLE_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SCUTE_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.EXPERIENCE_BOTTLE_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                }
            }
            // FARMER
            if (event.getType() == VillagerProfession.FARMER) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_VEGGIES_AND_GRAINS_TABLE,
                                    24,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_BREADS_TABLE,
                                    6,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_GOURDS_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_PIES_TABLE,
                                    4,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_FRUITS_TABLE,
                                    6,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_COOKIES_TABLE,
                                    8,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_CAKES_TABLE,
                                    1,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.GOLDEN_FOOD_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.GOLDEN_FOOD_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                }
                // SUS stew trades (special handling, outside the loop)
                ForgeRegistries.MOB_EFFECTS.forEach(mobEffect ->
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForSUSStewFactory(
                                        mobEffect,
                                        300,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                )));
            }
            // FISHERMAN
            if (event.getType() == VillagerProfession.FISHERMAN) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_STRING_TABLE,
                                    16,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE,
                                    6,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.FISH_BUCKET_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE,
                                    6,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.CAMPFIRE_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.FISHING_GEAR_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_ASH_TABLE,
                                    16,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.FISHING_ROD_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.FISHING_GEAR_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                }
            }
            // FLETCHER
            if (event.getType() == VillagerProfession.FLETCHER) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_STICK_TABLE,
                                    16,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new TwoLootTableForLootTableFactory(
                                    TradeLootTables.FLINT_SELL_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.GRAVEL_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FLINT_BUY_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.BOWS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_STRING_TABLE,
                                    16,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FEATHER_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.BOWS_TABLE,
                                    TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_QUIVERS_TABLE,
                                    1,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.TRIPWIRE_HOOK_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForTippedArrowFactory(
                                    TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                    5,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForTippedArrowFactory(
                                    TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                    5,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                }
            }
            // LEATHERWORKER
            if (event.getType() == VillagerProfession.LEATHERWORKER) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_LEATHER_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForDyedArmorFactory(
                                    TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.LEATHER_TIER_LEGGINGS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForDyedArmorFactory(
                                    TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FLINT_BUY_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForDyedArmorFactory(
                                    TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForDyedArmorFactory(
                                    TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.LEATHER_TIER_BOOTS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_LEATHER_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForDyedArmorFactory(
                                    TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SCUTE_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForDyedArmorFactory(
                                    TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.SADDLE_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForDyedArmorFactory(
                                    TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                }
            }
            // LIBRARIAN
            if (event.getType() == VillagerProfession.LIBRARIAN) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SMALLEST_COIN,
                                    TradeLootTables.GUIDE_BOOKS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.PAPER_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForEnchantedItemFactory(
                                    Items.BOOK.getDefaultInstance(),
                                    TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.BOOKSHELF_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.BOOK_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.LANTERN_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForEnchantedItemFactory(
                                    Items.BOOK.getDefaultInstance(),
                                    TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_INK_TABLE,
                                    3,
                                    TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_GLASS_TABLE,
                                    1,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForEnchantedItemFactory(
                                    Items.BOOK.getDefaultInstance(),
                                    TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.BOOK_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.CLOCK_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForEnchantedItemFactory(
                                    Items.BOOK.getDefaultInstance(),
                                    TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_INK_TABLE,
                                    1,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.NAME_TAG_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.COMPASS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                }
            }
            // MASON
            if (event.getType() == VillagerProfession.MASON) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.CLAY_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.BRICK_ITEMS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.OVERWORLD_BRICK_BLOCKS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.OVERWORLD_POLISHED_STONE_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                }
            }
            // SHEPHERD
            if (event.getType() == VillagerProfession.SHEPHERD) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.NATURAL_WOOL_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.SHEARS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_DYES_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_WOOL_TABLE,
                                    1,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_WOOL_CARPETS_TABLE,
                                    3,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_DYES_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_BEDS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_DYES_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.BANNER_PATTERN_TABLE,
                                    3,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new TagTableForLootTableFactory(
                                    TradeLootTables.TAGGED_DYES_TABLE,
                                    6,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.PAINTINGS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                }
            }
            // TOOLSMITH
            if (event.getType() == VillagerProfession.TOOLSMITH) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.STONE_TIER_TOOLS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_METALS,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.BELL_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.IRON_TIER_TOOLS_TABLE,
                                    TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FLINT_BUY_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_ASH_TABLE,
                                    18,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                    TradeLootTables.IRON_TIER_TOOLS_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.GOLD_TIER_TOOLS_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY,
                                    TradeLootTables.NETHERITE_TIER_TOOLS_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                }
            }
            // WEAPONSMITH
            if (event.getType() == VillagerProfession.WEAPONSMITH) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.IRON_TIER_WEAPONS_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_METALS,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.BELL_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FLINT_BUY_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.EQUIPMENT_GEMS_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForTagTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.TAGGED_ASH_TABLE,
                                    18,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.GOLD_TIER_WEAPONS_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.ANVIL_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.DIAMOND_TIER_WEAPONS_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForEnchantedItemTableFactory(
                                    TradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY,
                                    TradeLootTables.NETHERITE_TIER_WEAPONS_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                }
            }

            // my custom villager professions
            // BANKER
            if (event.getType().toString().equals("todecoins:banker")) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_TABLE,
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                    TradeLootTables.ONE_EMERALD_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SIXTEEN_EMERALD_TABLE,
                                    TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                    TradeLootTables.SIXTEEN_EMERALD_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THIRTY_TWO_EMERALD_TABLE,
                                    TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                                    TradeLootTables.THIRTY_TWO_EMERALD_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SIXTY_FOUR_EMERALD_TABLE,
                                    TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                                    TradeLootTables.SIXTY_FOUR_EMERALD_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_EMERALD_VALUE_METALS,
                                    TradeLootTables.ONE_EMERALD_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                    TradeLootTables.ONE_EMERALD_TABLE,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.EMERALD_BANK_NOTE_VALUE_METALS,
                                    TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.EMERALD_BANK_NOTE_VALUE_GEMS,
                                    TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                                    TradeOfferConstants.COMMON_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                            ));
                }
            }
            // LEPRECHAUN
            if (event.getType().toString().equals("todecoins:leprechaun")) {
                trades.get(TradeOfferConstants.novice).clear();
                trades.get(TradeOfferConstants.apprentice).clear();
                trades.get(TradeOfferConstants.journeyman).clear();
                trades.get(TradeOfferConstants.expert).clear();
                trades.get(TradeOfferConstants.master).clear();

                for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY,
                                    TradeLootTables.TWO_POTS_OF_GOLD_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.novice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.TWO_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.TWO_POT_OF_GOLD_VALUE_GEMS,
                                    TradeLootTables.TWO_POTS_OF_GOLD_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS,
                                    TradeLootTables.TWO_POTS_OF_GOLD_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FOUR_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FOUR_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.FOUR_POT_OF_GOLD_VALUE_GEMS,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FOUR_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.apprentice).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.FOUR_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_ITEMS,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_GEMS,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_ITEMS,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.journeyman).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE,
                                    TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_GEMS,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY,
                                    TradeLootTables.ONE_LUCKY_COIN_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.expert).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.ONE_LUCKY_COIN_TABLE,
                                    TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.SINGLE_LUCKY_COIN_VALUE_GEMS,
                                    TradeLootTables.ONE_LUCKY_COIN_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS,
                                    TradeLootTables.THREE_LUCKY_COIN_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                    trades.get(TradeOfferConstants.master).add(
                            new LootTableForLootTableFactory(
                                    TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS,
                                    TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_TABLE,
                                    TradeOfferConstants.RARE_MAX_TRADES,
                                    TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                    TradeOfferConstants.RARE_TRADE_MULTIPLIER
                            ));
                }
            }

            // support for other villager professions
            // Wares mod trades
            if (ModList.get().isLoaded("wares")) {
                // PACKAGER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("wares:packager"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PACKAGE_TAG_TABLE,
                                        8,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForSealedAgreement(
                                        TradeLootTables.SMALLEST_COIN,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WANDERING_SELL_ONE_EMERALD_VALUE_TABLE,
                                        "packager_delivery_agreement_1",
                                        TextProvider.of(Component.literal("Delivery Order")),
                                        Component.literal("Deliveries Sent All Over Minecraft On Demand!"),
                                        TextProvider.of(Component.literal("Packager")),
                                        TextProvider.of(Component.literal("100 Tode Lane, Todeville Minecraft 00000")),
                                        TextProvider.of(Component.literal("Willing to pay on delivery for these goods right away!")),
                                        "default",
                                        Component.literal("Wares R Us"),
                                        12,
                                        TradeOfferConstants.BASE_XP,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PACKAGE_TAG_TABLE,
                                        8,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForSealedAgreement(
                                        TradeLootTables.SMALLEST_COIN,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WANDERING_SELL_ONE_EMERALD_VALUE_TABLE,
                                        "packager_delivery_agreement_1",
                                        TextProvider.of(Component.literal("Delivery Order")),
                                        Component.literal("Deliveries Sent All Over Minecraft On Demand!"),
                                        TextProvider.of(Component.literal("Packager")),
                                        TextProvider.of(Component.literal("100 Tode Lane, Todeville Minecraft 00000")),
                                        TextProvider.of(Component.literal("Willing to pay on delivery for these goods right away!")),
                                        "default",
                                        Component.literal("Wares R Us"),
                                        12,
                                        TradeOfferConstants.BASE_XP,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PACKAGE_TAG_TABLE,
                                        8,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForSealedAgreement(
                                        TradeLootTables.SMALLEST_COIN,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WANDERING_SELL_ONE_EMERALD_VALUE_TABLE,
                                        "packager_delivery_agreement_1",
                                        TextProvider.of(Component.literal("Delivery Order")),
                                        Component.literal("Deliveries Sent All Over Minecraft On Demand!"),
                                        TextProvider.of(Component.literal("Packager")),
                                        TextProvider.of(Component.literal("100 Tode Lane, Todeville Minecraft 00000")),
                                        TextProvider.of(Component.literal("Willing to pay on delivery for these goods right away!")),
                                        "default",
                                        Component.literal("Wares R Us"),
                                        12,
                                        TradeOfferConstants.BASE_XP,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PACKAGE_TAG_TABLE,
                                        8,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForSealedAgreement(
                                        TradeLootTables.SMALLEST_COIN,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WANDERING_SELL_ONE_EMERALD_VALUE_TABLE,
                                        "packager_delivery_agreement_1",
                                        TextProvider.of(Component.literal("Delivery Order")),
                                        Component.literal("Deliveries Sent All Over Minecraft On Demand!"),
                                        TextProvider.of(Component.literal("Packager")),
                                        TextProvider.of(Component.literal("100 Tode Lane, Todeville Minecraft 00000")),
                                        TextProvider.of(Component.literal("Willing to pay on delivery for these goods right away!")),
                                        "default",
                                        Component.literal("Wares R Us"),
                                        12,
                                        TradeOfferConstants.BASE_XP,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PACKAGE_TAG_TABLE,
                                        8,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForSealedAgreement(
                                        TradeLootTables.SMALLEST_COIN,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WANDERING_SELL_ONE_EMERALD_VALUE_TABLE,
                                        "packager_delivery_agreement_1",
                                        TextProvider.of(Component.literal("Delivery Order")),
                                        Component.literal("Deliveries Sent All Over Minecraft On Demand!"),
                                        TextProvider.of(Component.literal("Packager")),
                                        TextProvider.of(Component.literal("100 Tode Lane, Todeville Minecraft 00000")),
                                        TextProvider.of(Component.literal("Willing to pay on delivery for these goods right away!")),
                                        "default",
                                        Component.literal("Wares R Us"),
                                        12,
                                        TradeOfferConstants.BASE_XP,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // DynamicVillage mod trades
            if (ModList.get().isLoaded("dynamicvillage")) {
                // MECHANICAL ENGINEER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("dynamicvillage:mechanical_engineer"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.CREATE_INGOTS_TAG_TABLE,
                                        3,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ZINC_MATERIALS_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WRENCH_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GOGGLES_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ENGINEER_TOOLS_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // MINER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("dynamicvillage:miner"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ONE_EMERALD_VALUE_METALS,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TORCH_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GOGGLES_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // HYDRAULIC ENGINEER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("dynamicvillage:hydraulic_engineer"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COPPER_MATERIALS_TAG_TABLE,
                                        9,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRIED_KELP_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ONE_EMERALD_VALUE_METALS,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COPPER_DIVING_GEAR_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COPPER_MATERIALS_TAG_TABLE,
                                        9,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COPPER_MATERIALS_TAG_TABLE,
                                        9,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HYDRAULIC_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COPPER_MATERIALS_TAG_TABLE,
                                        9,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // TRAIN MECHANIC
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("dynamicvillage:train_mechanic"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // VillagersPlus mod trades
            if (ModList.get().isLoaded("villagersplus")) {
                // ALCHEMIST
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villagersplus:alchemist"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLASS_BOTTLE_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLASS_BOTTLE_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLASS_BOTTLE_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLASS_BOTTLE_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                    // potion trades
                    ForgeRegistries.MOB_EFFECTS.forEach(mobEffect ->
                            trades.get(TradeOfferConstants.master).add(
                                    new LootTableForPotionFactory(
                                            mobEffect, 300,
                                            TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                            TradeOfferConstants.RARE_MAX_TRADES,
                                            TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                            TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                    ))
                    );
                }
                // HORTICULTURIST
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villagersplus:horticulturist"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SEED_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LEAVES_TAG_TABLE,
                                        2,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DECOR_PLANTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_POT_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SAPLING_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.BONE_MEAL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.BONE_MEAL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // OCEANOGRAPHER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villagersplus:oceanographer"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.PRISMARINE_SHARD_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                                        TradeLootTables.SEA_LANTERN_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.CORAL_BLOCK_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SEASHELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HEART_OF_THE_SEA_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.TRIDENT_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                                        TradeLootTables.TRIDENT_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        // map trade
                        trades.get(TradeOfferConstants.journeyman).add(
                                new TwoLootTableForMapFactory(
                                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COMPASS_TABLE,
                                        TodeCoinsTags.StructureTags.OCEAN_POI.location().toString(),
                                        "Ocean Explorer Map",
                                        MapDecoration.Type.MONUMENT.name(),
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                    }
                }
                // OCCULTIST
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villagersplus:occultist"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_CANDLE_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_INK_TABLE,
                                        3,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LANTERN_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TORCH_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.BONE_MEAL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_CANDLE_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // DomesticationInnovation mod trades
            if (ModList.get().isLoaded("domesticationinnovation")) {
                // ANIMAL TAMER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("domesticationinnovation:animal_tamer"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PET_FOOD_TAG_TABLE,
                                        3,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.PET_FOOD_TAG_TABLE,
                                        3,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PET_FOOD_TAG_TABLE,
                                        3,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PET_FOOD_TAG_TABLE,
                                        3,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PET_FOOD_TAG_TABLE,
                                        3,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));
                    }
                }
            }
            // KawaiiDishes mod trades
            if (ModList.get().isLoaded("kawaiidishes")) {
                // BARISTA
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("kawaiidishes:barista"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                                        12,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DESSERT_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.CUPS_TAG_TABLE,
                                        9,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                                        12,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DESSERT_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.CUPS_TAG_TABLE,
                                        9,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                                        12,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DESSERT_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.CUPS_TAG_TABLE,
                                        9,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                                        12,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DESSERT_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.CUPS_TAG_TABLE,
                                        9,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                                        12,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DESSERT_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.CUPS_TAG_TABLE,
                                        9,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // VillagerEnchanter mod trades
            if (ModList.get().isLoaded("villager_enchanter")) {
                // ENCHANTER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("villager_enchanter:enchanter"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ENCHANTING_GEMS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.BOOK_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ENCHANTING_GEMS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.BOOK_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ENCHANTING_GEMS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        // enchanted book trades
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForEnchantedItemFactory(
                                        Items.BOOK.getDefaultInstance(),
                                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForEnchantedItemFactory(
                                        Items.BOOK.getDefaultInstance(),
                                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForEnchantedItemFactory(
                                        Items.BOOK.getDefaultInstance(),
                                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForEnchantedItemFactory(
                                        Items.BOOK.getDefaultInstance(),
                                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForEnchantedItemFactory(
                                        Items.BOOK.getDefaultInstance(),
                                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_MAX_TRADES
                                ));
                        // refresh book trades
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.REFRESH_BOOK_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.REFRESH_BOOK_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.REFRESH_BOOK_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.REFRESH_BOOK_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.REFRESH_BOOK_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // FastFoodDelight mod trades
            if (ModList.get().isLoaded("fastfooddelight")) {
                // WAITER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("fastfooddelight:fast_food_waiter"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SIDE_DISH_TAG_TABLE,
                                        6,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SANDWICH_TAG_TABLE,
                                        6,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SOUP_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PLATED_FOODS_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DRINKS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DESSERT_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // ChefsDelight mod trades
            if (ModList.get().isLoaded("chefsdelight")) {
                // CHEF
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("chefsdelight:delightchef"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COOKING_TOOLS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                                        16,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                                        6,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_COOKIES_TABLE,
                                        8,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE,
                                        6,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SOUP_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_CAKES_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_PIES_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FEAST_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FEAST_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // COOK
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("chefsdelight:delightcook"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                                        16,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                                        16,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SANDWICH_TAG_TABLE,
                                        6,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SIDE_DISH_TAG_TABLE,
                                        6,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SOUP_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.PLATED_FOODS_TAG_TABLE,
                                        6,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DESSERT_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DESSERT_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                                        9,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                                        9,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // Beautify mod trades
            if (ModList.get().isLoaded("beautify")) {
                // BOTANIST
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("beautify:botanist"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_POT_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DECOR_PLANTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TRELLIS_TAG_TABLE,
                                        2,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FRAMES_TABLE,
                                        2,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_CANDLE_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LANTERN_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_CANDLE_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // SewingKit mod trades
            if (ModList.get().isLoaded("sewingkit")) {
                // TAILOR
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("sewingkit:tailor"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.TAGGED_LEATHER_TABLE,
                                        6,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.TAGGED_WOOL_TABLE,
                                        18,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.TAGGED_STRING_TABLE,
                                        16,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.TAGGED_DYES_TABLE,
                                        6,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DYEABLE_LEGGINGS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DYEABLE_HELMETS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DYEABLE_BOOTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DYEABLE_CHESTPLATES_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_DYES_TABLE,
                                        3,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.PATTERNS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TEXTILES_TAG_TABLE,
                                        6,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAILOR_TOOLS_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TEXTILES_TAG_TABLE,
                                        6,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAILOR_TOOLS_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.PATTERNS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // Sawmill mod trades
            if (ModList.get().isLoaded("sawmill")) {
                // CARPENTER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("sawmill:carpenter"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SAPLING_BUY_TABLE,
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SAPLING_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.LOGS_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LOGS_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SAPLING_BUY_TABLE,
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SAPLING_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.LOGS_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LOGS_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                                        TradeLootTables.IRON_TIER_LUMBER_TOOLS_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DIAMOND_TIER_LUMBER_TOOLS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // AnnaBethsExtraVillager mod trades
            if (ModList.get().isLoaded("annabethsextravillagers")) {
                // CARPENTER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("annabethsextravillagers:carpenter"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SAPLING_BUY_TABLE,
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SAPLING_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.LOGS_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LOGS_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SAPLING_BUY_TABLE,
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SAPLING_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.LOGS_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LOGS_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                                        TradeLootTables.IRON_TIER_LUMBER_TOOLS_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DIAMOND_TIER_LUMBER_TOOLS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // MUSICIAN
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("annabethsextravillagers:musician"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.DISC_FRAGMENTS_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // POTTER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("annabethsextravillagers:potter"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.CLAY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_POT_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // MoreVillagers mod trades
            if (ModList.get().isLoaded("morevillagers")) {
                // MINER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:miner"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TORCH_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.ONE_EMERALD_VALUE_METALS,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LANTERN_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new TwoLootTableForMapFactory(
                                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COMPASS_TABLE,
                                        TodeCoinsTags.StructureTags.UNDERGROUND_POI.location().toString(),
                                        "Underground Map",
                                        String.valueOf(MapDecoration.Type.TARGET_POINT),
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                    }
                }
                // HUNTER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:hunter"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SLIMEBALL_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE,
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE,
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE,
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TEN_EMERALD_VALUE_MOB_PARTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new TwoLootTableForMapFactory(
                                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COMPASS_TABLE,
                                        TodeCoinsTags.StructureTags.PILLAGER_POI.location().toString(),
                                        "Scout Map",
                                        String.valueOf(MapDecoration.Type.TARGET_POINT),
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                    }
                }
                // FLORIST
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:florist"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_POT_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.BONE_MEAL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FLOWER_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FLOWER_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FLOWER_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.FLOWER_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new TwoLootTableForMapFactory(
                                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COMPASS_TABLE,
                                        TodeCoinsTags.StructureTags.WITCH_SIGHTING.location().toString(),
                                        "Swamp Map",
                                        MapDecoration.Type.TARGET_POINT.name(),
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new TwoLootTableForMapFactory(
                                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COMPASS_TABLE,
                                        TodeCoinsTags.StructureTags.JUNGLE_POI.location().toString(),
                                        "Jungle Map",
                                        MapDecoration.Type.TARGET_POINT.name(),
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                    }
                }
                // ENGINEER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:engineer"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.NINE_EMERALD_VALUE_REDSTONE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.REDSTONE_TORCH_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // ENDERIAN
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:enderian"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ENDONIAN_COIN_TABLE,
                                        TradeLootTables.END_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ENDONIAN_COIN_TABLE,
                                        TradeLootTables.END_ROD_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_ENDONIAN_COIN_TABLE,
                                        TradeLootTables.ENDER_PEARL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ENDONIAN_COIN_TABLE,
                                        TradeLootTables.FIREWORK_ROCKET_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ENDONIAN_COIN_TABLE,
                                        TradeLootTables.DRAGON_BREATH_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE,
                                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THIRTY_TWO_ENDONIAN_COIN_TABLE,
                                        TradeLootTables.SHULKER_SHELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIFTY_ENDONIAN_COIN_TABLE,
                                        TradeLootTables.DRAGON_HEAD_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new TwoLootTableForMapFactory(
                                        TradeLootTables.FOURTEEN_ENDONIAN_COIN_TABLE,
                                        TradeLootTables.COMPASS_TABLE,
                                        TodeCoinsTags.StructureTags.END_POI.location().toString(),
                                        "End Explorer Map",
                                        MapDecoration.Type.TARGET_POINT.name(),
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                    }
                }
                // WOODWORKER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:woodworker"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SAPLING_BUY_TABLE,
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SAPLING_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.LOGS_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LOGS_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SAPLING_BUY_TABLE,
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SAPLING_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.LOGS_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.LOGS_SELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                                        TradeLootTables.IRON_TIER_LUMBER_TOOLS_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.DIAMOND_TIER_LUMBER_TOOLS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // NETHERIAN
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:netherian"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.SOUL_LIGHTS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.NETHER_WART_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.NETHER_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.NETHER_WART_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THIRTY_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.GHAST_TEAR_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.NINE_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.THREE_EMERALD_VALUE_GOLD,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.NETHER_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.NETHER_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EIGHTEEN_NETHERITE_COIN_VALUE_CURRENCY,
                                        TradeLootTables.NETHER_STAR_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new TwoLootTableForMapFactory(
                                        TradeLootTables.FORTY_TWO_NETHER_GOLD_COIN_TABLE,
                                        TradeLootTables.COMPASS_TABLE,
                                        TodeCoinsTags.StructureTags.NETHER_POI.location().toString(),
                                        "Nether Explorer Map",
                                        MapDecoration.Type.RED_MARKER.name(),
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                    }
                }
                // OCEANOGRAPHER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("morevillagers:oceanographer"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.PRISMARINE_SHARD_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                                        TradeLootTables.SEA_LANTERN_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.CORAL_BLOCK_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.SEASHELL_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HEART_OF_THE_SEA_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.TRIDENT_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.TRIDENT_TABLE,
                                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new TwoLootTableForMapFactory(
                                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.COMPASS_TABLE,
                                        TodeCoinsTags.StructureTags.OCEAN_POI.location().toString(),
                                        "Ocean Explorer Map",
                                        MapDecoration.Type.MONUMENT.name(),
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // TodeVillagers mod trades
            if (ModList.get().isLoaded("todevillagers")) {
                // RETIRED TRADER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("todevillagers:retired_trader"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.WANDERING_PURCHASE_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_DYES_TABLE,
                                        3,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WANDERING_SELL_TWO_EMERALD_VALUE_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WANDERING_SELL_THREE_EMERALD_VALUE_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForItemFactory(
                                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                        new ItemStack(Items.SLIME_BALL),
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WANDERING_SELL_FIVE_EMERALD_VALUE_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.WANDERING_SELL_SPECIAL_TABLE,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForEnchantedItemTableFactory(
                                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForItemFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        new ItemStack(Items.BLUE_ICE),
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootBoxFactory(
                                        new ItemStack(Items.SHULKER_BOX),
                                        "Mystery Loot Box",
                                        BuiltInLootTables.ABANDONED_MINESHAFT,
                                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                                        1,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                    }
                }
                // DISC JOCKEY
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("todevillagers:disc_jockey"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.DISC_FRAGMENTS_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.RARE_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
                // GLASSBLOWER
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("todevillagers:glassblower"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.RECYCLABLE_GLASS_TAG_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.SAND_TAG_TABLE,
                                        6,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_GLASS_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                                        16,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE,
                                        1,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.GLASS_BOTTLE_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_GLASS_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                                        16,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                                        16,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_GLASS_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
            // FriendsAndFoes mod trades
            if (ModList.get().isLoaded("friendsandfoes")) {
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("friendsandfoes:beekeeper"))) {
                    trades.get(TradeOfferConstants.novice).clear();
                    trades.get(TradeOfferConstants.apprentice).clear();
                    trades.get(TradeOfferConstants.journeyman).clear();
                    trades.get(TradeOfferConstants.expert).clear();
                    trades.get(TradeOfferConstants.master).clear();

                    for (int i = 0; i < Config.getMaxVillagerTrades(); ++i) {
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FLOWER_BUY_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.novice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.GLASS_BOTTLE_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.BOTTLED_HONEY_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.apprentice).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SHEARS_TABLE,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HONEY_BLOCK_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.journeyman).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.HONEY_COMB_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.expert).add(
                                new TagTableForLootTableFactory(
                                        TradeLootTables.TAGGED_STRING_TABLE,
                                        16,
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.expert).add(
                                new LootTableForTagTableFactory(
                                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.TAGGED_CANDLE_TABLE,
                                        4,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));

                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.BEEHIVE_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                        trades.get(TradeOfferConstants.master).add(
                                new LootTableForLootTableFactory(
                                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                        TradeLootTables.BEE_EGG_TABLE,
                                        TradeOfferConstants.COMMON_MAX_TRADES,
                                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                                ));
                    }
                }
            }
        }
    }
}