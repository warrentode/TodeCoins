package com.github.warrentode.todecoins.datagen.trades;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom.*;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import io.github.mortuusars.wares.data.agreement.component.TextProvider;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@SuppressWarnings("removal")
public class JsonTradesProvider implements DataProvider {
    @SuppressWarnings("unused")
    private final DataGenerator generator;
    @SuppressWarnings("unused")
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public JsonTradesProvider(DataGenerator generator) {
        this.generator = generator;
    }

    protected void buildTrades(@NotNull JsonTradesBuilder builder) {
        // nitwit trades
        builder.add(new ResourceLocation(VillagerProfession.NITWIT.toString()),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIREWORK_ROCKET_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SMALLEST_COIN,
                        ResourceLocation.tryParse("todecoins:trade_tables/misc/player_heads"),
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );

        // armorer trades
        builder.add(new ResourceLocation(VillagerProfession.ARMORER.toString()),
                TradeOfferConstants.novice,
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
        );
        builder.add(new ResourceLocation(VillagerProfession.ARMORER.toString()),
                TradeOfferConstants.apprentice,
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
        );
        builder.add(new ResourceLocation(VillagerProfession.ARMORER.toString()),
                TradeOfferConstants.journeyman,
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
        );
        builder.add(new ResourceLocation(VillagerProfession.ARMORER.toString()),
                TradeOfferConstants.expert,
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
        );
        builder.add(new ResourceLocation(VillagerProfession.ARMORER.toString()),
                TradeOfferConstants.master,
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
        );
        // butcher trades
        builder.add(new ResourceLocation(VillagerProfession.BUTCHER.toString()),
                TradeOfferConstants.novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_MEATS_TABLE,
                        12,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_MEAT_SOUPS_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.BUTCHER.toString()),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.BUTCHER.toString()),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.STONE_TIER_KNIVES,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_MEATS_TABLE,
                        12,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.BUTCHER.toString()),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_SALTS_TABLE,
                        18,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_ASH_TABLE,
                        18,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.BUTCHER.toString()),
                TradeOfferConstants.master,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_FOX_FOOD_TABLE,
                        8,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // cartographer trades
        builder.add(new ResourceLocation(VillagerProfession.CARTOGRAPHER.toString()),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.PAPER_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BLANK_MAP_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.CARTOGRAPHER.toString()),
                TradeOfferConstants.apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.OVERWORLD_POI.location().toString(),
                        "Exploration Map",
                        String.valueOf(MapDecoration.Type.TARGET_POINT),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.CARTOGRAPHER.toString()),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.COMPASS_TABLE,
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.OVERWORLD_POI.location().toString(),
                        "Exploration Map",
                        String.valueOf(MapDecoration.Type.TARGET_POINT),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.CARTOGRAPHER.toString()),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ITEM_FRAME_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_BANNER_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.CARTOGRAPHER.toString()),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BANNER_PATTERN_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.OVERWORLD_POI.location().toString(),
                        "Exploration Map",
                        String.valueOf(MapDecoration.Type.TARGET_POINT),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // cleric trades
        builder.add(new ResourceLocation(VillagerProfession.CLERIC.toString()),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_GEMS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.CLERIC.toString()),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_METALS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_GEMS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.CLERIC.toString()),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_GEMS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.CLERIC.toString()),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_GEMS,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SCUTE_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.CLERIC.toString()),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // farmer trades
        builder.add(new ResourceLocation(VillagerProfession.FARMER.toString()),
                TradeOfferConstants.novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_VEGGIES_AND_GRAINS_TABLE,
                        24,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_BREADS_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FARMER.toString()),
                TradeOfferConstants.apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_GOURDS_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PIES_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FARMER.toString()),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_FRUITS_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKIES_TABLE,
                        8,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // sus. stew trades
        ForgeRegistries.MOB_EFFECTS.forEach(mobEffect ->
                builder.add(new ResourceLocation(VillagerProfession.FARMER.toString()),
                        TradeOfferConstants.expert,
                        new LootTableForSUSStewFactory(mobEffect, 300,
                                TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                TradeOfferConstants.COMMON_MAX_TRADES,
                                TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                                TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                        )
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FARMER.toString()),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CAKES_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FARMER.toString()),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOLDEN_FOOD_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOLDEN_FOOD_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // fisherman trades
        builder.add(new ResourceLocation(VillagerProfession.FISHERMAN.toString()),
                TradeOfferConstants.novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STRING_TABLE,
                        16,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FISH_BUCKET_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FISHERMAN.toString()),
                TradeOfferConstants.apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CAMPFIRE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FISHERMAN.toString()),
                TradeOfferConstants.journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FISHING_GEAR_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FISHERMAN.toString()),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_ASH_TABLE,
                        16,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FISHING_ROD_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FISHERMAN.toString()),
                TradeOfferConstants.master,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FISHING_GEAR_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // fletcher trades
        builder.add(new ResourceLocation(VillagerProfession.FLETCHER.toString()),
                TradeOfferConstants.novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STICK_TABLE,
                        16,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForLootTableFactory(
                        TradeLootTables.FLINT_SELL_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GRAVEL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FLETCHER.toString()),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLINT_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BOWS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FLETCHER.toString()),
                TradeOfferConstants.journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STRING_TABLE,
                        16,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FEATHER_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FLETCHER.toString()),
                TradeOfferConstants.expert,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.BOWS_TABLE,
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_QUIVERS_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TRIPWIRE_HOOK_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.FLETCHER.toString()),
                TradeOfferConstants.master,
                new LootTableForTippedArrowFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY, 5,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTippedArrowFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY, 5,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // leatherworker trades
        builder.add(new ResourceLocation(VillagerProfession.LEATHERWORKER.toString()),
                TradeOfferConstants.novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_LEATHER_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LEATHER_TIER_LEGGINGS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.LEATHERWORKER.toString()),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLINT_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LEATHER_TIER_BOOTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.LEATHERWORKER.toString()),
                TradeOfferConstants.journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_LEATHER_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.LEATHERWORKER.toString()),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SCUTE_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.LEATHERWORKER.toString()),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SADDLE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // librarian trades
        builder.add(new ResourceLocation(VillagerProfession.LIBRARIAN.toString()),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SMALLEST_COIN,
                        TradeLootTables.GUIDE_BOOKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.PAPER_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BOOKSHELF_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.LIBRARIAN.toString()),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.BOOK_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LANTERN_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.LIBRARIAN.toString()),
                TradeOfferConstants.journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_INK_TABLE,
                        3,
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.LIBRARIAN.toString()),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.BOOK_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CLOCK_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.LIBRARIAN.toString()),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_INK_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.NAME_TAG_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // mason trades
        builder.add(new ResourceLocation(VillagerProfession.MASON.toString()),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.CLAY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BRICK_ITEMS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.MASON.toString()),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_BRICK_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.MASON.toString()),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_POLISHED_STONE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.MASON.toString()),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.MASON.toString()),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // shepherd trades
        builder.add(new ResourceLocation(VillagerProfession.SHEPHERD.toString()),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.NATURAL_WOOL_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SHEARS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.SHEPHERD.toString()),
                TradeOfferConstants.apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_WOOL_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_WOOL_CARPETS_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.SHEPHERD.toString()),
                TradeOfferConstants.journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_BEDS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.SHEPHERD.toString()),
                TradeOfferConstants.expert,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BANNER_PATTERN_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.SHEPHERD.toString()),
                TradeOfferConstants.master,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PAINTINGS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // toolsmith trades
        builder.add(new ResourceLocation(VillagerProfession.TOOLSMITH.toString()),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.STONE_TIER_TOOLS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.TOOLSMITH.toString()),
                TradeOfferConstants.apprentice,
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
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.TOOLSMITH.toString()),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FLINT_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.TOOLSMITH.toString()),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_ASH_TABLE,
                        18,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.TOOLSMITH.toString()),
                TradeOfferConstants.master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOLD_TIER_TOOLS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY,
                        TradeLootTables.NETHERITE_TIER_TOOLS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // weaponsmith trades
        builder.add(new ResourceLocation(VillagerProfession.WEAPONSMITH.toString()),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_WEAPONS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.WEAPONSMITH.toString()),
                TradeOfferConstants.apprentice,
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
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.WEAPONSMITH.toString()),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLINT_BUY_TABLE,
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
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.WEAPONSMITH.toString()),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_ASH_TABLE,
                        18,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOLD_TIER_WEAPONS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ANVIL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation(VillagerProfession.WEAPONSMITH.toString()),
                TradeOfferConstants.master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_WEAPONS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY,
                        TradeLootTables.NETHERITE_TIER_WEAPONS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // wandering trader trades
        builder.add(new ResourceLocation("minecraft:wandering_trader"),
                TradeOfferConstants.common,
                new LootTableForLootTableFactory(
                        TradeLootTables.WANDERING_PURCHASE_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_DYES_TABLE,
                        3,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_TWO_EMERALD_VALUE_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_THREE_EMERALD_VALUE_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        new ItemStack(Items.SLIME_BALL),
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_FIVE_EMERALD_VALUE_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("minecraft:wandering_trader"),
                TradeOfferConstants.rare,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_SPECIAL_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        new ItemStack(Items.BLUE_ICE),
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootBoxFactory(
                        new ItemStack(Items.SHULKER_BOX),
                        "Mystery Loot Box",
                        new ResourceLocation(BuiltInLootTables.ABANDONED_MINESHAFT.toString()),
                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                        1,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // banker trades
        builder.add(new ResourceLocation("todecoins:banker"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todecoins:banker"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todecoins:banker"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE,
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todecoins:banker"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE,
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todecoins:banker"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_METALS,
                        TradeLootTables.ONE_EMERALD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.ONE_EMERALD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_METALS,
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_GEMS,
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // leprechaun trades
        builder.add(new ResourceLocation("todecoins:leprechaun"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY,
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE,
                        TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todecoins:leprechaun"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_POT_OF_GOLD_VALUE_GEMS,
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS,
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE,
                        TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE,
                        TradeLootTables.FOUR_POT_OF_GOLD_VALUE_GEMS,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE,
                        TradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE,
                        TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todecoins:leprechaun"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE,
                        TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_ITEMS,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE,
                        TradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE,
                        TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_GEMS,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE,
                        TradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE,
                        TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_ITEMS,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE,
                        TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_GEMS,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todecoins:leprechaun"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY,
                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todecoins:leprechaun"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_GEMS,
                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS,
                        TradeLootTables.THREE_LUCKY_COIN_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS,
                        TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // numismatist trades
        builder.add(new ResourceLocation("todecoins:numismatist"),
                TradeOfferConstants.common,
                new LootTableForLootTableFactory(
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        0
                ),
                new LootTableForLootTableFactory(
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        0
                ),
                new TwoLootTableForMapFactory(
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.SETTLEMENT.location().toString(),
                        "Settlement Map",
                        MapDecoration.Type.TARGET_POINT.toString(),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        0
                ),
                new TwoLootTableForLootTableFactory(
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                        TradeLootTables.NUMISMATIST_CONTAINER_OFFERS,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        0
                ),
                new TwoLootTableForLootBoxFactory(
                        Items.SHULKER_BOX.getDefaultInstance(),
                        "tooltips.collectible_coin_pack",
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        0
                )
        );
        builder.add(new ResourceLocation("todecoins:numismatist"),
                TradeOfferConstants.rare,
                new TwoLootTableForLootTableFactory(
                        TradeLootTables.NUMISMATIST_RARE_OFFERS,
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                        0
                ),
                new TwoLootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK.toString()),
                        ResourceLocation.tryParse(ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString()),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.rare,
                        0
                )
        );
        // piglin merchant trades
        builder.add(new ResourceLocation("todecoins:piglin_merchant"),
                TradeOfferConstants.common,
                new LootTableForTagTableFactory(
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.CHEAP_TRADE_GOODS,
                        6,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.COMMON_TRADE_GOODS,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.IRON_TIER_EQUIPMENT_SET,
                        TradeLootTables.SIX_NETHER_GOLD_COIN_BAG_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.FIFTEEN_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.UNCOMMON_TRADE_GOODS,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_NETHER_GOLD_COIN_BAG_TABLE,
                        TradeLootTables.DIAMOND_TIER_EQUIPMENT_SET,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todecoins:piglin_merchant"),
                TradeOfferConstants.rare,
                new LootTableForTagTableFactory(
                        TradeLootTables.RARE_BARTER_CURRENCY,
                        TradeLootTables.RARE_TRADE_GOODS,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.RARE_BARTER_CURRENCY,
                        TradeLootTables.RARE_TRADE_GOODS,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.IRON_TIER_BOOTS_TABLE,
                        TradeLootTables.RARE_BARTER_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.common,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER,
                        1, "minecraft:soul_speed"
                )
        );
        // wares:packager
        // PACKAGER
        if (ModList.get().isLoaded("wares")) {
            builder.add(new ResourceLocation("wares:packager"),
                    TradeOfferConstants.novice,
                    new LootTableForTagTableFactory(
                            TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            TradeOfferConstants.COMMON_MAX_TRADES,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                            TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
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
                    )
            );
            builder.add(new ResourceLocation("wares:packager"),
                    TradeOfferConstants.apprentice,
                    new LootTableForTagTableFactory(
                            TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            TradeOfferConstants.COMMON_MAX_TRADES,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                            TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
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
                    )
            );
            builder.add(new ResourceLocation("wares:packager"),
                    TradeOfferConstants.journeyman,
                    new LootTableForTagTableFactory(
                            TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            TradeOfferConstants.COMMON_MAX_TRADES,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                            TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
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
                    )
            );
            builder.add(new ResourceLocation("wares:packager"),
                    TradeOfferConstants.expert,
                    new LootTableForTagTableFactory(
                            TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            TradeOfferConstants.COMMON_MAX_TRADES,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                            TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
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
                    )
            );
            builder.add(new ResourceLocation("wares:packager"),
                    TradeOfferConstants.master,
                    new LootTableForTagTableFactory(
                            TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            TradeOfferConstants.COMMON_MAX_TRADES,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                            TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
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
                    )
            );
        }
        // dynamicvillage:mechanical_engineer
        builder.add(new ResourceLocation("dynamicvillage:mechanical_engineer"),
                TradeOfferConstants.novice,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CREATE_INGOTS_TAG_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ZINC_MATERIALS_TAG_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WRENCH_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOGGLES_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("dynamicvillage:mechanical_engineer"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENGINEER_TOOLS_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("dynamicvillage:mechanical_engineer"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("dynamicvillage:mechanical_engineer"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("dynamicvillage:mechanical_engineer"),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // dynamicvillage:miner
        builder.add(new ResourceLocation("dynamicvillage:miner"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_METALS,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TORCH_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOGGLES_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("dynamicvillage:miner"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("dynamicvillage:miner"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("dynamicvillage:miner"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("dynamicvillage:miner"),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MINING_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // dynamicvillage:train_mechanic
        builder.add(new ResourceLocation("dynamicvillage:train_mechanic"),
                TradeOfferConstants.novice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );

        builder.add(new ResourceLocation("dynamicvillage:train_mechanic"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );

        builder.add(new ResourceLocation("dynamicvillage:train_mechanic"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );

        builder.add(new ResourceLocation("dynamicvillage:train_mechanic"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );

        builder.add(new ResourceLocation("dynamicvillage:train_mechanic"),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRAIN_EQUIPMENT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // villagersplus:alchemist
        builder.add(new ResourceLocation("villagersplus:alchemist"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:alchemist"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:alchemist"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:alchemist"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // Master level: Potion trades (1 trade per mob effect)
        ForgeRegistries.MOB_EFFECTS.forEach(mobEffect ->
                builder.add(new ResourceLocation("villagersplus:alchemist"),
                        TradeOfferConstants.master,
                        new LootTableForPotionFactory(
                                mobEffect,
                                300,
                                TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                                TradeOfferConstants.RARE_MAX_TRADES,
                                TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                                TradeOfferConstants.RARE_TRADE_MULTIPLIER
                        )
                )
        );
        // villagersplus:horticulturist
        builder.add(new ResourceLocation("villagersplus:horticulturist"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SEED_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:horticulturist"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LEAVES_TAG_TABLE,
                        2,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DECOR_PLANTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:horticulturist"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_POT_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:horticulturist"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BONE_MEAL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:horticulturist"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BONE_MEAL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // villagersplus:oceanographer
        builder.add(new ResourceLocation("villagersplus:oceanographer"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.PRISMARINE_SHARD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                        TradeLootTables.SEA_LANTERN_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:oceanographer"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CORAL_BLOCK_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:oceanographer"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SEASHELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.OCEAN_POI.location().toString(),
                        "Ocean Explorer Map",
                        MapDecoration.Type.MONUMENT.name(),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:oceanographer"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.HEART_OF_THE_SEA_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.TRIDENT_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:oceanographer"),
                TradeOfferConstants.master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                        TradeLootTables.TRIDENT_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // villagersplus:occultist
        builder.add(new ResourceLocation("villagersplus:occultist"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:occultist"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_INK_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LANTERN_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:occultist"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TORCH_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:occultist"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BONE_MEAL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villagersplus:occultist"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // domesticationinnovation:animal_tamer
        builder.add(new ResourceLocation("domesticationinnovation:animal_tamer"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.RARE_MAX_TRADES
                )
        );
        builder.add(new ResourceLocation("domesticationinnovation:animal_tamer"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_MAX_TRADES
                )
        );
        builder.add(new ResourceLocation("domesticationinnovation:animal_tamer"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_MAX_TRADES
                )
        );
        builder.add(new ResourceLocation("domesticationinnovation:animal_tamer"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_MAX_TRADES
                )
        );
        builder.add(new ResourceLocation("domesticationinnovation:animal_tamer"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_MAX_TRADES
                )
        );
        // kawaiidishes:barista
        builder.add(new ResourceLocation("kawaiidishes:barista"),
                TradeOfferConstants.novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );

        builder.add(new ResourceLocation("kawaiidishes:barista"),
                TradeOfferConstants.apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );

        builder.add(new ResourceLocation("kawaiidishes:barista"),
                TradeOfferConstants.journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );

        builder.add(new ResourceLocation("kawaiidishes:barista"),
                TradeOfferConstants.expert,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );

        builder.add(new ResourceLocation("kawaiidishes:barista"),
                TradeOfferConstants.master,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // villager_enchanter:enchanter
        builder.add(new ResourceLocation("villager_enchanter:enchanter"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_GEMS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villager_enchanter:enchanter"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.BOOK_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villager_enchanter:enchanter"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_GEMS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villager_enchanter:enchanter"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.BOOK_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("villager_enchanter:enchanter"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_GEMS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // fastfooddelight:fast_food_waiter
        builder.add(new ResourceLocation("fastfooddelight:fast_food_waiter"),
                TradeOfferConstants.novice,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SIDE_DISH_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("fastfooddelight:fast_food_waiter"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SANDWICH_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("fastfooddelight:fast_food_waiter"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SOUP_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("fastfooddelight:fast_food_waiter"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PLATED_FOODS_TAG_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("fastfooddelight:fast_food_waiter"),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // chefsdelight:delightchef
        builder.add(new ResourceLocation("chefsdelight:delightchef"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COOKING_TOOLS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        16,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("chefsdelight:delightchef"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKIES_TABLE,
                        8,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("chefsdelight:delightchef"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SOUP_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("chefsdelight:delightchef"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CAKES_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PIES_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("chefsdelight:delightchef"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FEAST_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FEAST_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // chefsdelight:delightcook
        builder.add(new ResourceLocation("chefsdelight:delightcook"),
                TradeOfferConstants.novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        16,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        16,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("chefsdelight:delightcook"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SANDWICH_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SIDE_DISH_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("chefsdelight:delightcook"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SOUP_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PLATED_FOODS_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("chefsdelight:delightcook"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("chefsdelight:delightcook"),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        9,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        9,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // beautify:botanist
        builder.add(new ResourceLocation("beautify:botanist"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_POT_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DECOR_PLANTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("beautify:botanist"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRELLIS_TAG_TABLE,
                        2,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("beautify:botanist"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FRAMES_TABLE,
                        2,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("beautify:botanist"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LANTERN_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("beautify:botanist"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // sewingkit:tailor
        builder.add(new ResourceLocation("sewingkit:tailor"),
                TradeOfferConstants.novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_LEATHER_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_WOOL_TABLE,
                        18,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STRING_TABLE,
                        16,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("sewingkit:tailor"),
                TradeOfferConstants.apprentice,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_LEGGINGS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_HELMETS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_BOOTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_CHESTPLATES_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("sewingkit:tailor"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_DYES_TABLE,
                        3,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.PATTERNS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("sewingkit:tailor"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEXTILES_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAILOR_TOOLS_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("sewingkit:tailor"),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEXTILES_TAG_TABLE,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAILOR_TOOLS_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.PATTERNS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // sawmill:carpenter
        builder.add(new ResourceLocation("sawmill:carpenter"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("sawmill:carpenter"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("sawmill:carpenter"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("sawmill:carpenter"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("sawmill:carpenter"),
                TradeOfferConstants.master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                        TradeLootTables.IRON_TIER_LUMBER_TOOLS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_LUMBER_TOOLS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // annabethsextravillagers:carpenter
        builder.add(new ResourceLocation("annabethsextravillagers:carpenter"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:carpenter"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:carpenter"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:carpenter"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:carpenter"),
                TradeOfferConstants.master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_LUMBER_TOOLS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                        TradeLootTables.DIAMOND_TIER_LUMBER_TOOLS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // annabethsextravillagers:musician
        builder.add(new ResourceLocation("annabethsextravillagers:musician"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.DISC_FRAGMENTS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:musician"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:musician"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:musician"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:musician"),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        //annabethsextravillagers:potter
        builder.add(new ResourceLocation("annabethsextravillagers:potter"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.CLAY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_POT_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:potter"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:potter"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:potter"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("annabethsextravillagers:potter"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // morevillagers:miner
        builder.add(new ResourceLocation("morevillagers:miner"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TORCH_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:miner"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_METALS,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:miner"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LANTERN_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:miner"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:miner"),
                TradeOfferConstants.master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.UNDERGROUND_POI.location().toString(),
                        "Underground Map",
                        MapDecoration.Type.TARGET_POINT.name(),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:hunter
        builder.add(new ResourceLocation("morevillagers:hunter"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SLIMEBALL_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:hunter"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:hunter"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:hunter"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:hunter"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.PILLAGER_POI.location().toString(),
                        "Scout Map",
                        String.valueOf(MapDecoration.Type.TARGET_POINT),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:florist
        builder.add(new ResourceLocation("morevillagers:florist"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_POT_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BONE_MEAL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:florist"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FLOWER_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:florist"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FLOWER_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:florist"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLOWER_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:florist"),
                TradeOfferConstants.master,
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.WITCH_SIGHTING.location().toString(),
                        "Swamp Map",
                        String.valueOf(MapDecoration.Type.TARGET_POINT),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.JUNGLE_POI.location().toString(),
                        "Jungle Map",
                        String.valueOf(MapDecoration.Type.TARGET_POINT),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:engineer
        builder.add(new ResourceLocation("morevillagers:engineer"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.NINE_EMERALD_VALUE_REDSTONE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_TORCH_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:engineer"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:engineer"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:engineer"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:engineer"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // morevillagers:enderian
        builder.add(new ResourceLocation("morevillagers:enderian"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ENDONIAN_COIN_TABLE,
                        TradeLootTables.END_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ENDONIAN_COIN_TABLE,
                        TradeLootTables.END_ROD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:enderian"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_ENDONIAN_COIN_TABLE,
                        TradeLootTables.ENDER_PEARL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ENDONIAN_COIN_TABLE,
                        TradeLootTables.FIREWORK_ROCKET_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:enderian"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ENDONIAN_COIN_TABLE,
                        TradeLootTables.DRAGON_BREATH_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:enderian"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE,
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_ENDONIAN_COIN_TABLE,
                        TradeLootTables.SHULKER_SHELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:enderian"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIFTY_ENDONIAN_COIN_TABLE,
                        TradeLootTables.DRAGON_HEAD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_ENDONIAN_COIN_TABLE,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.END_POI.location().toString(),
                        "End Explorer Map",
                        MapDecoration.Type.TARGET_POINT.name(),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:woodworker
        builder.add(new ResourceLocation("morevillagers:woodworker"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:woodworker"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:woodworker"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:woodworker"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:woodworker"),
                TradeOfferConstants.master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                        TradeLootTables.IRON_TIER_LUMBER_TOOLS_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_LUMBER_TOOLS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // morevillagers:netherian
        builder.add(new ResourceLocation("morevillagers:netherian"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.SOUL_LIGHTS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.NETHER_WART_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:netherian"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.NETHER_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.NETHER_WART_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:netherian"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.GHAST_TEAR_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.NINE_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.THREE_EMERALD_VALUE_GOLD,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:netherian"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.NETHER_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.NETHER_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:netherian"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.EIGHTEEN_NETHERITE_COIN_VALUE_CURRENCY,
                        TradeLootTables.NETHER_STAR_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FORTY_TWO_NETHER_GOLD_COIN_TABLE,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.NETHER_POI.location().toString(),
                        "Nether Explorer Map",
                        MapDecoration.Type.RED_MARKER.name(),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:oceanographer
        builder.add(new ResourceLocation("morevillagers:oceanographer"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.PRISMARINE_SHARD_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                        TradeLootTables.SEA_LANTERN_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:oceanographer"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CORAL_BLOCK_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:oceanographer"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SEASHELL_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.HEART_OF_THE_SEA_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:oceanographer"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.TRIDENT_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TRIDENT_TABLE,
                        TradeLootTables.ONE_LUCKY_COIN_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("morevillagers:oceanographer"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TodeCoinsTags.StructureTags.OCEAN_POI.location().toString(),
                        "Ocean Explorer Map",
                        MapDecoration.Type.MONUMENT.name(),
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // todevillagers:retired_trader
        builder.add(new ResourceLocation("todevillagers:retired_trader"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.WANDERING_PURCHASE_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_DYES_TABLE,
                        3,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:retired_trader"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_TWO_EMERALD_VALUE_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_THREE_EMERALD_VALUE_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:retired_trader"),
                TradeOfferConstants.journeyman,
                new LootTableForItemFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        new ItemStack(Items.SLIME_BALL),
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_FIVE_EMERALD_VALUE_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:retired_trader"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_SPECIAL_TABLE,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:retired_trader"),
                TradeOfferConstants.master,
                new LootTableForItemFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        new ItemStack(Items.BLUE_ICE),
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootBoxFactory(
                        new ItemStack(Items.SHULKER_BOX),
                        "Mystery Loot Box",
                        BuiltInLootTables.ABANDONED_MINESHAFT,
                        TradeLootTables.SIXTEEN_EMERALD_TABLE,
                        1,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                )
        );
        // todevillagers:disc_jockey
        builder.add(new ResourceLocation("todevillagers:disc_jockey"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.DISC_FRAGMENTS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:disc_jockey"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:disc_jockey"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:disc_jockey"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:disc_jockey"),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        TradeOfferConstants.RARE_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // todevillagers:glassblower
        builder.add(new ResourceLocation("todevillagers:glassblower"),
                TradeOfferConstants.novice,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.RECYCLABLE_GLASS_TAG_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.SAND_TAG_TABLE,
                        6,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:glassblower"),
                TradeOfferConstants.apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:glassblower"),
                TradeOfferConstants.journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE,
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:glassblower"),
                TradeOfferConstants.expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("todevillagers:glassblower"),
                TradeOfferConstants.master,
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // friendsandfoes:beekeeper
        builder.add(new ResourceLocation("friendsandfoes:beekeeper"),
                TradeOfferConstants.novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLOWER_BUY_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("friendsandfoes:beekeeper"),
                TradeOfferConstants.apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BOTTLED_HONEY_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SHEARS_TABLE,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.apprentice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("friendsandfoes:beekeeper"),
                TradeOfferConstants.journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.HONEY_BLOCK_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.HONEY_COMB_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.journeyman,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("friendsandfoes:beekeeper"),
                TradeOfferConstants.expert,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STRING_TABLE,
                        16,
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.expert,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("friendsandfoes:beekeeper"),
                TradeOfferConstants.master,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BEEHIVE_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BEE_EGG_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        // example file
        builder.add(new ResourceLocation("example_modid:examplemod_profession"),
                TradeOfferConstants.novice,
                new ItemForLootTableFactory(
                        new ItemStack(Items.EMERALD),
                        1,
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForEnchantedItemFactory(
                        new ItemStack(Items.LEATHER_BOOTS),
                        BuiltInLootTables.VILLAGE_ARMORER,
                        new ItemStack(Items.EMERALD),
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForItemFactory(
                        BuiltInLootTables.VILLAGE_ARMORER,
                        new ItemStack(Items.EMERALD),
                        1,
                        new ItemStack(Items.STONE_AXE),
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("example_modid:examplemod_profession"),
                TradeOfferConstants.apprentice,
                new LootTableForDyedArmorFactory(
                        BuiltInLootTables.VILLAGE_ARMORER,
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        new ItemStack(Items.LEATHER_BOOTS),
                        BuiltInLootTables.VILLAGE_ARMORER,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                        BuiltInLootTables.VILLAGE_ARMORER,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.master,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("example_modid:examplemod_profession"),
                TradeOfferConstants.journeyman,
                new LootTableForItemFactory(
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        new ItemStack(Items.EMERALD),
                        1,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootBoxFactory(
                        new ItemStack(Items.CHEST),
                        "Loot Box",
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForLootBoxFactory(
                        new ItemStack(Items.CHEST),
                        "Loot Box",
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        BuiltInLootTables.VILLAGE_DESERT_HOUSE,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("example_modid:examplemod_profession"),
                TradeOfferConstants.expert,
                new LootTableForLootTableFactory(
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForPotionFactory(
                        MobEffects.BLINDNESS,
                        200,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER,
                        1, "minecraft:soul_speed"
                )
        );
        builder.add(new ResourceLocation("example_modid:examplemod_profession"),
                TradeOfferConstants.master,
                new LootTableForSUSStewFactory(
                        MobEffects.WATER_BREATHING,
                        200,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        BuiltInLootTables.VILLAGE_SHEPHERD,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        BuiltInLootTables.VILLAGE_SHEPHERD,
                        6,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("example_modid:examplemod_profession"),
                TradeOfferConstants.common,
                new LootTableForTippedArrowFactory(
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        6,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new SellItemForItemsFactory(
                        new ItemStack(Items.APPLE),
                        new ItemStack(Items.EMERALD),
                        new ItemStack(Items.COAL),
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForEnchantedItemFactory(
                        new ItemStack(Items.IRON_SWORD),
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        BuiltInLootTables.VILLAGE_SHEPHERD,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(new ResourceLocation("example_modid:examplemod_profession"),
                TradeOfferConstants.rare,
                new TwoLootTableForLootTableFactory(
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        BuiltInLootTables.VILLAGE_FLETCHER,
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        StructureTags.MINESHAFT.location().toString(),
                        "Mineshaft Map",
                        MapDecoration.Type.RED_X.name(),
                        TradeOfferConstants.COMMON_MAX_TRADES,
                        TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                        TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                )
        );
        if (ModList.get().isLoaded("wares")) {
            builder.add(new ResourceLocation("example_modid:examplemod_profession"),
                    TradeOfferConstants.rare,
                    new LootTableForSealedAgreementFactory(
                            BuiltInLootTables.VILLAGE_BUTCHER,
                            BuiltInLootTables.VILLAGE_PLAINS_HOUSE,
                            BuiltInLootTables.VILLAGE_ARMORER,
                            "example_agreement_id",
                            TextProvider.of(Component.nullToEmpty("Example Agreement Tile")),
                            Component.literal("Example Backside Message"),
                            TextProvider.of(Component.nullToEmpty("Example Buyer Name")),
                            TextProvider.of(Component.nullToEmpty("Example Address")),
                            TextProvider.of(Component.nullToEmpty("Example Buyer Message")),
                            "default",
                            Component.literal("Example Seal Tooltip"),
                            12,
                            TradeOfferConstants.BASE_XP,
                            TradeOfferConstants.COMMON_MAX_TRADES,
                            TradeOfferConstants.BASE_XP * TradeOfferConstants.novice,
                            TradeOfferConstants.COMMON_TRADE_MULTIPLIER
                    )
            );
        }
    }

    @Override
    public void run(@NotNull CachedOutput output) throws IOException {
        Path outputPath = generator.getOutputFolder().resolve("data").resolve(MODID).resolve("trades");

        JsonTradesBuilder builder = JsonTradesBuilder.create();
        buildTrades(builder);

        for (var professionEntry : builder.build().entrySet()) {
            ResourceLocation professionId = professionEntry.getKey();
            Map<Integer, List<VillagerTrades.ItemListing>> tradeLevels = professionEntry.getValue();

            // wrap and encode with your CustomVillagerTrades codec
            TradeOfferManager.CustomVillagerTrades villagerTrades =
                    new TradeOfferManager.CustomVillagerTrades(professionId, false, tradeLevels);
            JsonElement villagerJson = TradeOfferManager.CustomVillagerTrades.CUSTOM_VILLAGER_TRADES_CODEC
                    .encodeStart(JsonOps.INSTANCE, villagerTrades)
                    .getOrThrow(false, error -> TodeCoins.LOGGER.error("Failed to encode for villager: {}", error));

            TradeOfferManager.CustomWanderingTraderTrades traderTrades =
                    new TradeOfferManager.CustomWanderingTraderTrades(professionId, false, tradeLevels);
            JsonElement traderJson = TradeOfferManager.CustomWanderingTraderTrades.CUSTOM_WANDERING_TRADER_TRADES_CODEC
                    .encodeStart(JsonOps.INSTANCE, traderTrades)
                    .getOrThrow(false, e -> TodeCoins.LOGGER.error("Failed to encode for trader: {}", e));

            Path tradeFile = outputPath.resolve(professionId.getNamespace()).resolve(professionId.getPath() + ".json");
            //noinspection BlockingMethodInNonBlockingContext
            Files.createDirectories(tradeFile.getParent());
            DataProvider.saveStable(output, villagerJson, tradeFile);
            DataProvider.saveStable(output, traderJson, tradeFile);
        }
    }

    @Override
    public @NotNull String getName() {
        return "JsonTrades - Custom Trade JSON Generator";
    }
}