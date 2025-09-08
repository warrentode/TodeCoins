package com.github.warrentode.todecoins.datagen.trades;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.datagen.translations.TooltipTranslations;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.loot_table_types.*;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.semi_vanilla.SellItemForItemsFactory;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.tags.TCStructureTags;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import io.github.mortuusars.wares.data.agreement.component.TextProvider;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;
import static com.github.warrentode.todecoins.entity.trades.TradeOfferConstants.*;

public class JsonTradesProvider implements DataProvider {
    private final PackOutput output;
    @SuppressWarnings("unused")
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public JsonTradesProvider(PackOutput output) {
        this.output = output;
    }

    protected void buildTrades(@NotNull JsonTradesBuilder builder) {
        // nitwit trades
        builder.add(ResourceLocation.parse(VillagerProfession.NITWIT.toString()),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SERVER_TOKEN_COIN,
                        TradeLootTables.PLAYER_HEADS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SERVER_TOKEN_COIN,
                        TradeLootTables.BUCKETS_TAG_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * novice,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SERVER_TOKEN_COIN,
                        TradeLootTables.FIREWORK_ROCKET_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );

        // armorer trades
        builder.add(ResourceLocation.parse(VillagerProfession.ARMORER.toString()),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CHAINMAIL_TIER_HELMETS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CHAINMAIL_TIER_CHESTPLATES_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CHAINMAIL_TIER_LEGGINGS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CHAINMAIL_TIER_BOOTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.ARMORER.toString()),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        Items.BELL.getDefaultInstance(), 1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_LEGGINGS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_BOOTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.ARMORER.toString()),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_HELMETS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_CHESTPLATES_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SHIELD_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_HORSE_ARMOR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.ARMORER.toString()),
                expert,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.DIAMOND_TIER_LEGGINGS_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.DIAMOND_TIER_BOOTS_TABLE,
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_ASH_TABLE,
                        18,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.ARMORER.toString()),
                master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.DIAMOND_TIER_HELMETS_TABLE,
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.DIAMOND_TIER_CHESTPLATES_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // butcher trades
        builder.add(ResourceLocation.parse(VillagerProfession.BUTCHER.toString()),
                novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_MEATS_TABLE,
                        12,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_MEAT_SOUPS_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.BUTCHER.toString()),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.BUTCHER.toString()),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.STONE_TIER_KNIVES,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_MEATS_TABLE,
                        12,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.BUTCHER.toString()),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_SALTS_TABLE,
                        18,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_ASH_TABLE,
                        18,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.BUTCHER.toString()),
                master,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_FOX_FOOD_TABLE,
                        8,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // cartographer trades
        builder.add(ResourceLocation.parse(VillagerProfession.CARTOGRAPHER.toString()),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.PAPER_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BLANK_MAP_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.CARTOGRAPHER.toString()),
                apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.OVERWORLD_POI.location().toString(),
                        "filled_map.overworld_poi",
                        MapDecoration.Type.TARGET_POINT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.CARTOGRAPHER.toString()),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.COMPASS_TABLE,
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.OVERWORLD_POI.location().toString(),
                        "filled_map.overworld_poi",
                        MapDecoration.Type.TARGET_POINT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.CARTOGRAPHER.toString()),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ITEM_FRAME_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_BANNER_TABLE,
                        3,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.CARTOGRAPHER.toString()),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BANNER_PATTERN_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.OVERWORLD_POI.location().toString(),
                        "filled_map.overworld_poi",
                        MapDecoration.Type.TARGET_POINT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // cleric trades
        builder.add(ResourceLocation.parse(VillagerProfession.CLERIC.toString()),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_FUEL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.CLERIC.toString()),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_FUEL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.CLERIC.toString()),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_FUEL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.CLERIC.toString()),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_GEMS,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SCUTE_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.CLERIC.toString()),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // farmer trades
        builder.add(ResourceLocation.parse(VillagerProfession.FARMER.toString()),
                novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_CROPS_TABLE,
                        24,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_BREADS_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FARMER.toString()),
                apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_GOURDS_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PIES_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FARMER.toString()),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_FRUITS_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKIES_TABLE,
                        8,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // sus. stew trades - one for each registered effect at time of data gen
        ForgeRegistries.MOB_EFFECTS.forEach(mobEffect ->
                builder.add(ResourceLocation.parse(VillagerProfession.FARMER.toString()),
                        expert,
                        new LootTableForSUSStewFactory(
                                mobEffect,
                                300,
                                TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                                COMMON_MAX_TRADES,
                                BASE_XP * expert,
                                COMMON_TRADE_MULTIPLIER
                        )
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FARMER.toString()),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CAKES_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FARMER.toString()),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOLDEN_FOOD_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOLDEN_FOOD_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // fisherman trades
        builder.add(ResourceLocation.parse(VillagerProfession.FISHERMAN.toString()),
                novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STRING_TABLE,
                        16,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FISH_BUCKET_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * novice,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FISHERMAN.toString()),
                apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CAMPFIRE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FISHERMAN.toString()),
                journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FISHING_GEAR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FISHERMAN.toString()),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_ASH_TABLE,
                        16,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FISHING_ROD_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FISHERMAN.toString()),
                master,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FISHING_GEAR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // fletcher trades
        builder.add(ResourceLocation.parse(VillagerProfession.FLETCHER.toString()),
                novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STICK_TABLE,
                        16,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForLootTableFactory(
                        TradeLootTables.FLINT_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GRAVEL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FLETCHER.toString()),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLINT_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BOWS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FLETCHER.toString()),
                journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STRING_TABLE,
                        16,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FEATHER_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FLETCHER.toString()),
                expert,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.BOWS_TABLE,
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.QUIVERS_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TRIPWIRE_HOOK_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.FLETCHER.toString()),
                master,
                new LootTableForTippedArrowFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        5,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTippedArrowFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        5,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // leatherworker trades
        builder.add(ResourceLocation.parse(VillagerProfession.LEATHERWORKER.toString()),
                novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_LEATHER_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_ARMOR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_ARMOR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.LEATHERWORKER.toString()),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLINT_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_ARMOR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_ARMOR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.LEATHERWORKER.toString()),
                journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_LEATHER_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_ARMOR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.LEATHERWORKER.toString()),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SCUTE_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_ARMOR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.LEATHERWORKER.toString()),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SADDLE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForDyedArmorFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_ARMOR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // librarian trades
        builder.add(ResourceLocation.parse(VillagerProfession.LIBRARIAN.toString()),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SERVER_TOKEN_COIN,
                        TradeLootTables.GUIDE_BOOKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.PAPER_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * novice,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BOOKSHELF_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.LIBRARIAN.toString()),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.BOOK_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LANTERN_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * apprentice,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.LIBRARIAN.toString()),
                journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_INK_TABLE,
                        3,
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.LIBRARIAN.toString()),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.BOOK_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CLOCK_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.LIBRARIAN.toString()),
                master,
                new LootTableForTagTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_INK_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.NAME_TAG_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // mason trades
        builder.add(ResourceLocation.parse(VillagerProfession.MASON.toString()),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.CLAY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BRICK_ITEMS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.MASON.toString()),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_BRICK_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.MASON.toString()),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_POLISHED_STONE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.MASON.toString()),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.MASON.toString()),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // shepherd trades
        builder.add(ResourceLocation.parse(VillagerProfession.SHEPHERD.toString()),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.NATURAL_WOOL_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SHEARS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.SHEPHERD.toString()),
                apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_WOOL_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_WOOL_CARPETS_TABLE,
                        3,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.SHEPHERD.toString()),
                journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_BEDS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.SHEPHERD.toString()),
                expert,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_BANNER_TABLE,
                        3,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.SHEPHERD.toString()),
                master,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PAINTINGS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // toolsmith trades
        builder.add(ResourceLocation.parse(VillagerProfession.TOOLSMITH.toString()),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.STONE_TIER_TOOLS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.TOOLSMITH.toString()),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        Items.BELL.getDefaultInstance(),
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * apprentice,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.TOOLSMITH.toString()),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FLINT_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.TOOLSMITH.toString()),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_ASH_TABLE,
                        18,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.TOOLSMITH.toString()),
                master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOLD_TIER_TOOLS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.ONE_THOUSAND_ONE_HUNDRED_FIFTY_TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.NETHERITE_TIER_TOOLS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // weaponsmith trades
        builder.add(ResourceLocation.parse(VillagerProfession.WEAPONSMITH.toString()),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_WEAPONS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.WEAPONSMITH.toString()),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        Items.BELL.getDefaultInstance(),
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * apprentice,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.WEAPONSMITH.toString()),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLINT_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.WEAPONSMITH.toString()),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_ASH_TABLE,
                        18,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GOLD_TIER_WEAPONS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                        Items.ANVIL.getDefaultInstance(),
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse(VillagerProfession.WEAPONSMITH.toString()),
                master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_WEAPONS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.ONE_THOUSAND_ONE_HUNDRED_FIFTY_TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.NETHERITE_TIER_WEAPONS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // wandering trader trades
        builder.add(ResourceLocation.parse("minecraft:wandering_trader"),
                common,
                new LootTableForLootTableFactory(
                        TradeLootTables.WANDERING_PURCHASE_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_DYES_TABLE, 3,
                        RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_TWO_EMERALD_VALUE_TABLE,
                        RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_THREE_EMERALD_VALUE_TABLE,
                        RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SLIMEBALL_TAG_TABLE,
                        RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_FIVE_EMERALD_VALUE_TABLE,
                        RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                )
        );
        List<ResourceLocation> chestLoot = List.of(
                BuiltInLootTables.SPAWN_BONUS_CHEST,
                BuiltInLootTables.END_CITY_TREASURE,
                BuiltInLootTables.SIMPLE_DUNGEON,
                BuiltInLootTables.VILLAGE_WEAPONSMITH,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_CARTOGRAPHER,
                BuiltInLootTables.VILLAGE_MASON,
                BuiltInLootTables.VILLAGE_SHEPHERD,
                BuiltInLootTables.VILLAGE_BUTCHER,
                BuiltInLootTables.VILLAGE_FLETCHER,
                BuiltInLootTables.VILLAGE_FISHER,
                BuiltInLootTables.VILLAGE_TANNERY,
                BuiltInLootTables.VILLAGE_TEMPLE,
                BuiltInLootTables.VILLAGE_DESERT_HOUSE,
                BuiltInLootTables.VILLAGE_PLAINS_HOUSE,
                BuiltInLootTables.VILLAGE_TAIGA_HOUSE,
                BuiltInLootTables.VILLAGE_SNOWY_HOUSE,
                BuiltInLootTables.VILLAGE_SAVANNA_HOUSE,
                BuiltInLootTables.ABANDONED_MINESHAFT,
                BuiltInLootTables.NETHER_BRIDGE,
                BuiltInLootTables.STRONGHOLD_LIBRARY,
                BuiltInLootTables.STRONGHOLD_CROSSING,
                BuiltInLootTables.STRONGHOLD_CORRIDOR,
                BuiltInLootTables.DESERT_PYRAMID,
                BuiltInLootTables.JUNGLE_TEMPLE,
                BuiltInLootTables.JUNGLE_TEMPLE_DISPENSER,
                BuiltInLootTables.IGLOO_CHEST,
                BuiltInLootTables.WOODLAND_MANSION,
                BuiltInLootTables.UNDERWATER_RUIN_SMALL,
                BuiltInLootTables.UNDERWATER_RUIN_BIG,
                BuiltInLootTables.BURIED_TREASURE,
                BuiltInLootTables.SHIPWRECK_MAP,
                BuiltInLootTables.SHIPWRECK_SUPPLY,
                BuiltInLootTables.SHIPWRECK_TREASURE,
                BuiltInLootTables.PILLAGER_OUTPOST,
                BuiltInLootTables.BASTION_TREASURE,
                BuiltInLootTables.BASTION_OTHER,
                BuiltInLootTables.BASTION_BRIDGE,
                BuiltInLootTables.BASTION_HOGLIN_STABLE,
                BuiltInLootTables.ANCIENT_CITY,
                BuiltInLootTables.ANCIENT_CITY_ICE_BOX,
                BuiltInLootTables.RUINED_PORTAL
        );
        chestLoot.forEach(chestTable -> builder.add(
                ResourceLocation.parse("minecraft:wandering_trader"),
                rare,
                new LootTableForLootBoxFactory(
                        Items.SHULKER_BOX.getDefaultInstance(),
                        "tooltip.todecoins.mystery_loot_box",
                        chestTable,
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                )));
        builder.add(ResourceLocation.parse("minecraft:wandering_trader"),
                rare,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_SPECIAL_TABLE,
                        RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        new ItemStack(Items.BLUE_ICE),
                        1,
                        RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                )
        );
        // banker trades
        builder.add(ResourceLocation.parse("todecoins:banker"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * novice, COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todecoins:banker"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * apprentice, COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todecoins:banker"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * journeyman, COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todecoins:banker"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * expert, COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todecoins:banker"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES, BASE_XP * master, COMMON_TRADE_MULTIPLIER
                )
        );
        // leprechaun trades
        builder.add(ResourceLocation.parse("todecoins:leprechaun"),
                novice,
                new LootTableForItemFactory(
                        TradeLootTables.THREE_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                        Items.EMERALD.getDefaultInstance(), 3,
                        RARE_MAX_TRADES, BASE_XP * novice, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        Items.EMERALD.getDefaultInstance(), 2,
                        TradeLootTables.THREE_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                        RARE_MAX_TRADES, BASE_XP * novice, RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todecoins:leprechaun"),
                apprentice,
                new ItemForLootTableFactory(
                        TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        TradeLootTables.THREE_EMERALD_VALUE_GEMS,
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        TradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS,
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        Items.EMERALD.getDefaultInstance(), 6,
                        TradeLootTables.SIX_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        Items.EMERALD.getDefaultInstance(), 6,
                        TradeLootTables.SIX_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        TradeLootTables.SIX_EMERALD_VALUE_GEMS,
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        TradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS,
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        Items.EMERALD.getDefaultInstance(), 6,
                        TradeLootTables.SIX_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                        RARE_MAX_TRADES, BASE_XP * apprentice, RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todecoins:leprechaun"),
                journeyman,
                new ItemForLootTableFactory(
                        TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_ITEMS,
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        Items.EMERALD.getDefaultInstance(), 32,
                        TradeLootTables.THIRTY_TWO_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_GEMS,
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        Items.EMERALD.getDefaultInstance(), 64,
                        TradeLootTables.SIXTY_FOUR_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        TCBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_ITEMS,
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_LEPRECHAUN_CURRENCY_VALUE,
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_GEMS,
                        RARE_MAX_TRADES, BASE_XP * journeyman, RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todecoins:leprechaun"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_LEPRECHAUN_VALUE_CURRENCY,
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                        RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_LEPRECHAUN_VALUE_CURRENCY,
                        RARE_MAX_TRADES, BASE_XP * expert, RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todecoins:leprechaun"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_GEMS,
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_LEPRECHAUN_VALUE_CURRENCY,
                        RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS,
                        TCItems.LUCKY_COIN.get().getDefaultInstance(), 3,
                        RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS,
                        TCItems.LUCKY_COIN.get().getDefaultInstance(), 27,
                        RARE_MAX_TRADES, BASE_XP * master, RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_TRIMS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // numismatist trades
        builder.add(ResourceLocation.parse("todecoins:numismatist"),
                common,
                // a season coin for an off season coin trade
                new LootTableForLootTableFactory(
                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                        TradeLootTables.MYSTERY_COIN_PACK,
                        RARE_MAX_TRADES, BASE_XP * common, 0
                ),
                // an off season coin for a season coin trade
                new LootTableForLootTableFactory(
                        TradeLootTables.MYSTERY_COIN_PACK,
                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                        RARE_MAX_TRADES, BASE_XP * common, 0
                ),
                // offer a map for a season coin
                new TwoLootTableForMapFactory(
                        TradeLootTables.MYSTERY_COIN_PACK,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.SETTLEMENT.location().toString(),
                        "filled_map.settlement",
                        MapDecoration.Type.TARGET_POINT.name(),
                        RARE_MAX_TRADES, BASE_XP * common, 0
                ),
                // offer a container for 2 coins
                new TwoLootTableForLootTableFactory(
                        TradeLootTables.MYSTERY_COIN_PACK,
                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                        TradeLootTables.NUMISMATIST_CONTAINER_OFFERS,
                        RARE_MAX_TRADES, BASE_XP * common, 0
                ),
                // offer a coin pack in a shulker box for 2 coins
                new TwoLootTableForLootBoxFactory(
                        Items.SHULKER_BOX.getDefaultInstance(),
                        "tooltip.todecoins.collectible_coin_pack",
                        TradeLootTables.MYSTERY_COIN_PACK,
                        TradeLootTables.MYSTERY_COIN_PACK,
                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                        RARE_MAX_TRADES, BASE_XP * common, 0
                )
        );
        builder.add(ResourceLocation.parse("todecoins:numismatist"),
                rare,
                // offer a rare item for 2 coins
                new TwoLootTableForLootTableFactory(
                        TradeLootTables.NUMISMATIST_RARE_OFFERS,
                        TradeLootTables.MYSTERY_COIN_PACK,
                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                        RARE_MAX_TRADES, BASE_XP * rare, 0
                ),
                // enchanted book for 2 coins
                new TwoLootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.MYSTERY_COIN_PACK,
                        TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                        RARE_MAX_TRADES, BASE_XP * rare, 0
                )
        );
        // piglin merchant trades
        builder.add(ResourceLocation.parse("todecoins:piglin_merchant"),
                common,
                // cheap barter loot trade
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.CHEAP_TRADE_GOODS,
                        6, COMMON_MAX_TRADES, BASE_XP * common, COMMON_TRADE_MULTIPLIER
                ),
                // common currency barter loot
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.COMMON_TRADE_GOODS,
                        1,
                        COMMON_MAX_TRADES, BASE_XP * common, COMMON_TRADE_MULTIPLIER
                ),
                // common currency enchantable barter loot
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.IRON_TIER_EQUIPMENT_SET,
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                ),
                // uncommon currency barter loot
                new LootTableForTagTableFactory(
                        TradeLootTables.FIVE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.UNCOMMON_TRADE_GOODS,
                        1, RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                ),
                // uncommon currency enchantable barter loot
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.DIAMOND_TIER_EQUIPMENT_SET,
                        TradeLootTables.TWENTY_SIX_EMERALD_NETHER_CURRENCY_VALUE,
                        RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todecoins:piglin_merchant"),
                rare,
                // rare currency barter loot
                new LootTableForTagTableFactory(
                        TradeLootTables.RARE_BARTER_CURRENCY,
                        TradeLootTables.RARE_TRADE_GOODS,
                        1, RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                ),
                // rare currency enchantable barter loot
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NETHERITE_TIER_EQUIPMENT_SET,
                        TradeLootTables.RARE_BARTER_CURRENCY,
                        RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                ),
                // rare soul speed boots trade
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.IRON_TIER_BOOTS_TABLE,
                        TradeLootTables.RARE_BARTER_CURRENCY,
                        RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER,
                        1, "minecraft:soul_speed"
                ),
                // rare netherite gear trade
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_HUNDRED_SEVENTY_SIX_EMERALD_NETHER_VALUE_CURRENCY,
                        TradeLootTables.NETHERITE_TIER_EQUIPMENT_SET,
                        RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                )
        );
        // wares:packager
        // PACKAGER
        if (ModList.get().isLoaded("wares")) {
            builder.add(ResourceLocation.parse("wares:packager"),
                    novice,
                    new LootTableForTagTableFactory(
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            COMMON_MAX_TRADES,
                            BASE_XP * novice,
                            COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
                            TradeLootTables.SERVER_TOKEN_COIN,
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            // this table includes the sale of flowers and other decor plants
                            TradeLootTables.WANDERING_SELL_ONE_EMERALD_VALUE_TABLE,
                            "packager_delivery_agreement_1",
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "delivery_order")),
                            Component.literal(TooltipTranslations.tooltipPrefix + "backside_message"),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_name")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_address")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_message")),
                            "default",
                            Component.literal("Wares R Us"),
                            12,
                            BASE_XP,
                            COMMON_MAX_TRADES,
                            BASE_XP * novice,
                            COMMON_TRADE_MULTIPLIER
                    )
            );
            builder.add(ResourceLocation.parse("wares:packager"),
                    apprentice,
                    new LootTableForTagTableFactory(
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            COMMON_MAX_TRADES,
                            BASE_XP * apprentice,
                            COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
                            TradeLootTables.SERVER_TOKEN_COIN,
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.LOGS_SELL_TABLE,
                            "packager_delivery_agreement_2",
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "delivery_order")),
                            Component.literal(TooltipTranslations.tooltipPrefix + "backside_message"),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_name")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_address")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_message")),
                            "default",
                            Component.literal(TooltipTranslations.tooltipPrefix + "seal_tooltip"),
                            12,
                            BASE_XP,
                            COMMON_MAX_TRADES,
                            BASE_XP * apprentice,
                            COMMON_TRADE_MULTIPLIER
                    )
            );
            builder.add(ResourceLocation.parse("wares:packager"),
                    journeyman,
                    new LootTableForTagTableFactory(
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            COMMON_MAX_TRADES,
                            BASE_XP * journeyman,
                            COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
                            TradeLootTables.SERVER_TOKEN_COIN,
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                            "packager_delivery_agreement_3",
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "delivery_order")),
                            Component.literal(TooltipTranslations.tooltipPrefix + "backside_message"),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_name")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_address")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_message")),
                            "default",
                            Component.literal(TooltipTranslations.tooltipPrefix + "seal_tooltip"),
                            12,
                            BASE_XP,
                            COMMON_MAX_TRADES,
                            BASE_XP * journeyman,
                            COMMON_TRADE_MULTIPLIER
                    )
            );
            builder.add(ResourceLocation.parse("wares:packager"),
                    expert,
                    new LootTableForTagTableFactory(
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            COMMON_MAX_TRADES,
                            BASE_XP * expert,
                            COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
                            TradeLootTables.SERVER_TOKEN_COIN,
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                            "packager_delivery_agreement_4",
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "delivery_order")),
                            Component.literal(TooltipTranslations.tooltipPrefix + "backside_message"),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_name")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_address")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_message")),
                            "default",
                            Component.literal(TooltipTranslations.tooltipPrefix + "seal_tooltip"),
                            12,
                            BASE_XP,
                            COMMON_MAX_TRADES,
                            BASE_XP * expert,
                            COMMON_TRADE_MULTIPLIER
                    )
            );
            builder.add(ResourceLocation.parse("wares:packager"),
                    master,
                    new LootTableForTagTableFactory(
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.PACKAGE_TAG_TABLE,
                            8,
                            COMMON_MAX_TRADES,
                            BASE_XP * master,
                            COMMON_TRADE_MULTIPLIER
                    ),
                    new LootTableForSealedAgreementFactory(
                            TradeLootTables.SERVER_TOKEN_COIN,
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.MYSTERY_COIN_PACK_INVERTED,
                            "packager_delivery_agreement_5",
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "delivery_order")),
                            Component.literal(TooltipTranslations.tooltipPrefix + "backside_message"),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_name")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_address")),
                            TextProvider.of(Component.literal(TooltipTranslations.tooltipPrefix + "buyer_message")),
                            "default",
                            Component.literal(TooltipTranslations.tooltipPrefix + "seal_tooltip"),
                            1,
                            BASE_XP,
                            COMMON_MAX_TRADES,
                            BASE_XP * master,
                            COMMON_TRADE_MULTIPLIER
                    )
            );
        }
        // dynamicvillage:mechanical_engineer
        builder.add(ResourceLocation.parse("dynamicvillage:mechanical_engineer"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.WRENCH_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.GOGGLES_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:mechanical_engineer"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.ENGINEER_TOOLS_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:mechanical_engineer"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:mechanical_engineer"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:mechanical_engineer"),
                master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MECHANICAL_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // dynamicvillage:miner
        builder.add(ResourceLocation.parse("dynamicvillage:miner"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TORCH_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.GOGGLES_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MINING_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:miner"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MINING_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MINING_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:miner"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MINING_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MINING_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:miner"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MINING_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MINING_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:miner"),
                master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MINING_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.MINING_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // dynamicvillage:train_mechanic
        builder.add(ResourceLocation.parse("dynamicvillage:train_mechanic"),
                novice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:train_mechanic"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:train_mechanic"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:train_mechanic"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:train_mechanic"),
                master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.TRAIN_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // dynamicvillage:hydraulic_engineer
        builder.add(ResourceLocation.parse("dynamicvillage:hydraulic_engineer"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.DRIED_KELP_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.FOUR_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.COPPER_DIVING_GEAR_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:hydraulic_engineer"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:hydraulic_engineer"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:hydraulic_engineer"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("dynamicvillage:hydraulic_engineer"),
                master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWO_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.HYDRAULIC_EQUIPMENT_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_MOUNTAIN_CURRENCY_VALUE,
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // villagersplus:alchemist
        builder.add(ResourceLocation.parse("villagersplus:alchemist"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:alchemist"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:alchemist"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:alchemist"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIVE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // Master level - one trade per potion effect
        ForgeRegistries.MOB_EFFECTS.forEach(mobEffect ->
                builder.add(ResourceLocation.parse("villagersplus:alchemist"),
                        master,
                        new LootTableForPotionFactory(
                                mobEffect,
                                300,
                                TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                                RARE_MAX_TRADES,
                                BASE_XP * master,
                                RARE_TRADE_MULTIPLIER
                        ))
        );
        // villagersplus:horticulturist
        builder.add(ResourceLocation.parse("villagersplus:horticulturist"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SEED_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:horticulturist"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LEAVES_TAG_TABLE,
                        2,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DECOR_PLANTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:horticulturist"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_POT_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:horticulturist"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FERTILIZER_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:horticulturist"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FERTILIZER_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // villagersplus:oceanographer
        builder.add(ResourceLocation.parse("villagersplus:oceanographer"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PRISMARINE_SHARD_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        TCItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        TradeLootTables.SEA_LANTERN_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:oceanographer"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CORAL_BLOCK_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:oceanographer"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SEASHELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.OCEAN_POI.location().toString(),
                        "filled_map.ocean_poi",
                        MapDecoration.Type.MONUMENT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:oceanographer"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.HEART_OF_THE_SEA_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRIDENT_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:oceanographer"),
                master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_LEPRECHAUN_VALUE_CURRENCY,
                        TradeLootTables.TRIDENT_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // villagersplus:occultist
        builder.add(ResourceLocation.parse("villagersplus:occultist"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:occultist"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_INK_TABLE,
                        3,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LANTERN_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:occultist"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_POTION_INGREDIENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TORCH_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:occultist"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FERTILIZER_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villagersplus:occultist"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // domesticationinnovation:animal_tamer
        builder.add(ResourceLocation.parse("domesticationinnovation:animal_tamer"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * novice,
                        RARE_MAX_TRADES
                )
        );
        builder.add(ResourceLocation.parse("domesticationinnovation:animal_tamer"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * apprentice,
                        RARE_MAX_TRADES
                )
        );
        builder.add(ResourceLocation.parse("domesticationinnovation:animal_tamer"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_MAX_TRADES
                )
        );
        builder.add(ResourceLocation.parse("domesticationinnovation:animal_tamer"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_MAX_TRADES
                )
        );
        builder.add(ResourceLocation.parse("domesticationinnovation:animal_tamer"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_SUPPLIES_TAG_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PET_FOOD_TAG_TABLE,
                        3,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTABLE_PET_GEAR_TAG_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_MAX_TRADES
                )
        );
        // kawaiidishes:barista
        builder.add(ResourceLocation.parse("kawaiidishes:barista"),
                novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("kawaiidishes:barista"),
                apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("kawaiidishes:barista"),
                journeyman,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("kawaiidishes:barista"),
                expert,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("kawaiidishes:barista"),
                master,
                new TagTableForLootTableFactory(
                        TradeLootTables.COFFEE_INGREDIENTS_TAG_TABLE,
                        12,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.CUPS_TAG_TABLE,
                        9,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // villager_enchanter:enchanter
        builder.add(ResourceLocation.parse("villager_enchanter:enchanter"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_FUEL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * novice,
                        RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * novice,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villager_enchanter:enchanter"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.BOOK_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * apprentice,
                        RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * apprentice,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villager_enchanter:enchanter"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_FUEL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villager_enchanter:enchanter"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.BOOK_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("villager_enchanter:enchanter"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ENCHANTING_FUEL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        Items.BOOK.getDefaultInstance(),
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_MAX_TRADES
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REFRESH_BOOK_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // fastfooddelight:fast_food_waiter
        builder.add(ResourceLocation.parse("fastfooddelight:fast_food_waiter"),
                novice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SIDE_DISH_TAG_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("fastfooddelight:fast_food_waiter"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SANDWICH_TAG_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("fastfooddelight:fast_food_waiter"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SOUP_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("fastfooddelight:fast_food_waiter"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PLATED_FOODS_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );

        builder.add(ResourceLocation.parse("fastfooddelight:fast_food_waiter"),
                master,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DRINKS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // chefsdelight:delightchef
        builder.add(ResourceLocation.parse("chefsdelight:delightchef"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COOKING_TOOLS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        16,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("chefsdelight:delightchef"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_COOKIES_TABLE,
                        8,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("chefsdelight:delightchef"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SOUP_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("chefsdelight:delightchef"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CAKES_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_PIES_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("chefsdelight:delightchef"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FEAST_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FEAST_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // chefsdelight:delightcook
        builder.add(ResourceLocation.parse("chefsdelight:delightcook"),
                novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        16,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        16,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("chefsdelight:delightcook"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SANDWICH_TAG_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SIDE_DISH_TAG_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("chefsdelight:delightcook"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SOUP_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PLATED_FOODS_TAG_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("chefsdelight:delightcook"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DESSERT_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("chefsdelight:delightcook"),
                master,
                new TagTableForLootTableFactory(
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        9,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.INGREDIENTS_TAG_TABLE,
                        9,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // beautify:botanist
        builder.add(ResourceLocation.parse("beautify:botanist"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BLINDS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DECOR_PLANTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("beautify:botanist"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRELLIS_TAG_TABLE,
                        2,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("beautify:botanist"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FRAMES_TABLE,
                        2,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("beautify:botanist"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LANTERN_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("beautify:botanist"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SPECIAL_DIRT_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // sewingkit:tailor
        builder.add(ResourceLocation.parse("sewingkit:tailor"), novice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_LEATHER_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_WOOL_TABLE,
                        18,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STRING_TABLE,
                        16,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("sewingkit:tailor"), apprentice,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_DYES_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DYEABLE_ARMOR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.STONE_TIER_SEWING_TOOLS_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("sewingkit:tailor"), journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_SEWING_TOOLS_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_DYES_TABLE,
                        3,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PATTERNS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("sewingkit:tailor"), expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEXTILES_TAG_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_SEWING_TOOLS_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("sewingkit:tailor"), master,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEXTILES_TAG_TABLE,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.FIVE_HUNDRED_SEVENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.NETHERITE_TIER_SEWING_TOOLS_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PATTERNS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // sawmill:carpenter
        builder.add(ResourceLocation.parse("sawmill:carpenter"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("sawmill:carpenter"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("sawmill:carpenter"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("sawmill:carpenter"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("sawmill:carpenter"),
                master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // morevillagers:miner
        builder.add(ResourceLocation.parse("morevillagers:miner"), novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TORCH_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:miner"), apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_OVERWORLD_INGOTS,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:miner"), journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LANTERN_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:miner"), expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OVERWORLD_OTHER_STONE_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:miner"), master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.UNDERGROUND_POI.location().toString(),
                        "filled_map.underground_poi",
                        MapDecoration.Type.TARGET_POINT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:hunter
        builder.add(ResourceLocation.parse("morevillagers:hunter"), novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SLIMEBALL_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:hunter"), apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:hunter"), journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:hunter"), expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:hunter"), master,
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TEN_EMERALD_VALUE_MOB_PARTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.PILLAGER_POI.location().toString(),
                        "filled_map.pillager_poi",
                        MapDecoration.Type.TARGET_POINT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:florist
        builder.add(ResourceLocation.parse("morevillagers:florist"), novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_POT_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FERTILIZER_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:florist"), apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FLOWER_BUY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:florist"), journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FLOWER_BUY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:florist"), expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLOWER_BUY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:florist"), master,
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.WITCH_SIGHTING.location().toString(),
                        "filled_map.swamp_poi",
                        MapDecoration.Type.TARGET_POINT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.JUNGLE_POI.location().toString(),
                        "filled_map.jungle_poi",
                        MapDecoration.Type.TARGET_POINT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:engineer
        builder.add(ResourceLocation.parse("morevillagers:engineer"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.NINE_EMERALD_VALUE_REDSTONE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:engineer"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:engineer"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:engineer"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:engineer"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.REDSTONE_COMPONENTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // morevillagers:enderian
        builder.add(ResourceLocation.parse("morevillagers:enderian"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        TradeLootTables.END_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        TradeLootTables.END_ROD_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:enderian"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        TradeLootTables.ENDER_PEARL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        TradeLootTables.FIREWORK_ROCKET_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:enderian"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        TradeLootTables.DRAGON_BREATH_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.THIRTY_TWO_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:enderian"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY_INVERTED,
                        TradeLootTables.SIXTY_FOUR_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        TradeLootTables.SHULKER_SHELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:enderian"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        TradeLootTables.DRAGON_HEAD_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_ENDONIAN_CURRENCY_VALUE,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.END_POI.location().toString(),
                        "filled_map.end_poi",
                        MapDecoration.Type.TARGET_POINT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:woodworker
        builder.add(ResourceLocation.parse("morevillagers:woodworker"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:woodworker"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:woodworker"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.SAPLING_BUY_TABLE,
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SAPLING_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:woodworker"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.LOGS_BUY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LOGS_SELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:woodworker"),
                master,
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // morevillagers:netherian
        builder.add(ResourceLocation.parse("morevillagers:netherian"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.SOUL_LIGHTS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.NETHER_WART_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:netherian"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.NETHER_BLOCKS,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.NETHER_WART_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:netherian"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.TEN_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.GHAST_TEAR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.ONE_EMERALD_VALUE_NETHER_INGOTS,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:netherian"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.NETHER_BLOCKS,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.NETHER_BLOCKS,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:netherian"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_HUNDRED_SEVENTY_SIX_EMERALD_NETHER_VALUE_CURRENCY,
                        TradeLootTables.NETHER_STAR_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.NETHER_POI.location().toString(),
                        "filled_map.nether_poi",
                        MapDecoration.Type.RED_MARKER.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // morevillagers:oceanographer
        builder.add(ResourceLocation.parse("morevillagers:oceanographer"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.PRISMARINE_SHARD_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SEA_LANTERN_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:oceanographer"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.CORAL_BLOCK_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:oceanographer"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.SEASHELL_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.HEART_OF_THE_SEA_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:oceanographer"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TRIDENT_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.TRIDENT_TABLE,
                        TradeLootTables.ONE_HUNDRED_NINETY_TWO_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("morevillagers:oceanographer"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.SIXTY_FOUR_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.COMPASS_TABLE,
                        TCStructureTags.OCEAN_POI.location().toString(),
                        "filled_map.ocean_poi",
                        MapDecoration.Type.MONUMENT.name(),
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // todevillagers:retired_trader
        builder.add(ResourceLocation.parse("todevillagers:retired_trader"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.WANDERING_PURCHASE_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * novice,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_DYES_TABLE,
                        3,
                        RARE_MAX_TRADES,
                        BASE_XP * novice,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:retired_trader"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_TWO_EMERALD_VALUE_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * apprentice,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_THREE_EMERALD_VALUE_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * apprentice,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:retired_trader"),
                journeyman,
                new LootTableForItemFactory(
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                        new ItemStack(Items.SLIME_BALL),
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_FIVE_EMERALD_VALUE_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:retired_trader"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.WANDERING_SELL_SPECIAL_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.IRON_TIER_TOOLS_TABLE,
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:retired_trader"),
                master,
                new LootTableForItemFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        new ItemStack(Items.BLUE_ICE),
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );

        // Add mystery loot boxes for master
        chestLoot.forEach(chestTable ->
                builder.add(ResourceLocation.parse("todevillagers:retired_trader"),
                        master,
                        new LootTableForLootBoxFactory(
                                Items.SHULKER_BOX.getDefaultInstance(),
                                "tooltip.todecoins.mystery_loot_box",
                                chestTable,
                                TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                                1,
                                BASE_XP * master,
                                RARE_TRADE_MULTIPLIER
                        )
                )
        );
        // todevillagers:disc_jockey
        builder.add(ResourceLocation.parse("todevillagers:disc_jockey"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.DISC_FRAGMENTS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:disc_jockey"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * apprentice,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:disc_jockey"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * journeyman,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:disc_jockey"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:disc_jockey"),
                master,
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // todevillagers:glassblower
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                novice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.RECYCLABLE_GLASS_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.SAND_TAG_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                master,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        //todevillagers:potter
        builder.add(ResourceLocation.parse("todevillagers:potter"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.CLAY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FLOWER_POT_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:potter"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:potter"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:potter"),
                expert,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:potter"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        //todevillagers:glassblower
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                novice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.RECYCLABLE_GLASS_TAG_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        TradeLootTables.SAND_TAG_TABLE,
                        6,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                apprentice,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                journeyman,
                new LootTableForTagTableFactory(
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASSBLOWING_TOOLS_TAG_TABLE,
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                expert,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("todevillagers:glassblower"),
                master,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE,
                        16,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_GLASS_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // friendsandfoes:beekeeper
        builder.add(ResourceLocation.parse("friendsandfoes:beekeeper"),
                novice,
                new LootTableForLootTableFactory(
                        TradeLootTables.FLOWER_BUY_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.GLASS_BOTTLE_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("friendsandfoes:beekeeper"),
                apprentice,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.HONEY_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.SHEARS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * apprentice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("friendsandfoes:beekeeper"),
                journeyman,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.HONEY_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.HONEY_COMB_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * journeyman,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("friendsandfoes:beekeeper"),
                expert,
                new TagTableForLootTableFactory(
                        TradeLootTables.TAGGED_STRING_TABLE,
                        16,
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TAGGED_CANDLE_TABLE,
                        4,
                        COMMON_MAX_TRADES,
                        BASE_XP * expert,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("friendsandfoes:beekeeper"),
                master,
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BEEHIVE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BEE_EGG_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        // vein goblin trader
        builder.add(ResourceLocation.parse("goblintraders:vein_goblin_trader"),
                common,
                new LootTableForItemFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        Items.CARROT.getDefaultInstance(), 8,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForItemFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        Items.GLOWSTONE.getDefaultInstance(), 1,
                        Items.GLOWSTONE_DUST.getDefaultInstance(), 5,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new ItemForLootTableFactory(
                        Items.NETHERRACK.getDefaultInstance(), 64,
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        Items.NETHER_WART.getDefaultInstance(), 22,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_NETHER_CURRENCY_VALUE,
                        TradeLootTables.NETHER_BLOCKS,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("goblintraders:vein_goblin_trader"),
                rare,
                new LootTableForItemFactory(
                        TradeLootTables.ONE_THOUSAND_ONE_HUNDRED_FIFTY_TWO_EMERALD_NETHER_VALUE_CURRENCY,
                        Items.TOTEM_OF_UNDYING.getDefaultInstance(), 1,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.FIVE_HUNDRED_SEVENTY_SIX_EMERALD_NETHER_VALUE_CURRENCY,
                        Items.NETHERITE_SCRAP.getDefaultInstance(), 1,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.DIAMOND_TIER_EQUIPMENT_SET,
                        TradeLootTables.TWENTY_SIX_EMERALD_NETHER_CURRENCY_VALUE,
                        RARE_MAX_TRADES,
                        BASE_XP * master,
                        RARE_TRADE_MULTIPLIER
                )
        );
        // Rare level - one trade per potion effect
        ForgeRegistries.MOB_EFFECTS.forEach(mobEffect ->
                builder.add(ResourceLocation.parse("goblintraders:vein_goblin_trader"),
                        rare,
                        new LootTableForPotionFactory(
                                mobEffect,
                                300,
                                TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                                RARE_MAX_TRADES,
                                BASE_XP * rare,
                                RARE_TRADE_MULTIPLIER
                        ))
        );
        // goblin trader
        builder.add(ResourceLocation.parse("goblintraders:goblin_trader"),
                common,
                new LootTableForItemFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        Items.APPLE.getDefaultInstance(), 8,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForItemFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        Items.RAW_IRON.getDefaultInstance(), 3,
                        Items.IRON_INGOT.getDefaultInstance(), 4,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForItemFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        Items.RAW_GOLD.getDefaultInstance(), 2,
                        Items.GOLD_INGOT.getDefaultInstance(), 3,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForItemFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        Items.RAW_COPPER.getDefaultInstance(), 8,
                        Items.COPPER_INGOT.getDefaultInstance(), 9,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE,
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.GRAVEL_TABLE,
                        TradeLootTables.FLINT_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        TradeLootTables.WANDERING_SELL_ONE_EMERALD_VALUE_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        TradeLootTables.FISH_BUCKET_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_FLORIN_CURRENCY_VALUE,
                        TradeLootTables.OCEAN_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.EIGHT_EMERALD_FLORIN_CURRENCY_VALUE,
                        Items.TURTLE_EGG.getDefaultInstance(), 1,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForItemFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        Items.CHIPPED_ANVIL.getDefaultInstance(), 1,
                        Items.DAMAGED_ANVIL.getDefaultInstance(), 1,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForItemFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        Items.DAMAGED_ANVIL.getDefaultInstance(), 1,
                        Items.ANVIL.getDefaultInstance(), 1,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.CLAY_TABLE,
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.TAGGED_LEATHER_TABLE,
                        Items.BOOKSHELF.getDefaultInstance(), 2,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        TradeLootTables.ONE_EMERALD_VALUE_GEMS,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("goblintraders:goblin_trader"),
                rare,
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.TWENTY_EMERALD_FLORIN_CURRENCY_VALUE,
                        TradeLootTables.NAME_TAG_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.ONE_EMERALD_FLORIN_CURRENCY_VALUE,
                        new ItemStack(Items.BLUE_ICE),
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.FISHING_ROD_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_FLORIN_CURRENCY_VALUE,
                        RARE_MAX_TRADES,
                        BASE_XP * expert,
                        RARE_TRADE_MULTIPLIER,
                        1, "minecraft:luck_of_the_sea"
                ),
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.FISHING_ROD_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_FLORIN_CURRENCY_VALUE,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER,
                        1, "minecraft:lure"
                ),
                new LootTableForTagTableFactory(
                        TradeLootTables.TWENTY_SIX_EMERALD_FLORIN_CURRENCY_VALUE,
                        TradeLootTables.MUSIC_DISC_TAG_TABLE,
                        1,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER
                ),
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_FLORIN_CURRENCY_VALUE,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER,
                        5, "minecraft:efficiency"
                ),
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_FLORIN_CURRENCY_VALUE,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER,
                        5, "minecraft:unbreaking"
                ),
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_FLORIN_CURRENCY_VALUE,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER,
                        5, "minecraft:fortune"
                ),
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                        TradeLootTables.TWENTY_SIX_EMERALD_FLORIN_CURRENCY_VALUE,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER,
                        5, "minecraft:silk_touch"
                )
        );

        builder.add(ResourceLocation.parse("supplementaries:red_merchant"),
                common,
                new LootTableForTagTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.ROPE_TAG_TABLE, 4,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForItemFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        Items.GUNPOWDER.getDefaultInstance(), 4,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.FIREWORK_ROCKET_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.LANTERN_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootTableFactory(
                        TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.TORCH_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * common,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("supplementaries:red_merchant"),
                rare,
                new LootTableForLootTableFactory(
                        TradeLootTables.THIRTY_TWO_EMERALD_VALUE_CURRENCY,
                        TradeLootTables.BOMB_TABLE,
                        RARE_MAX_TRADES,
                        BASE_XP * rare,
                        RARE_TRADE_MULTIPLIER
                )
        );

        // example file
        builder.add(ResourceLocation.parse("example_modid:examplemod_profession"),
                novice,
                new ItemForLootTableFactory(
                        new ItemStack(Items.EMERALD),
                        1,
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForEnchantedItemFactory(
                        new ItemStack(Items.LEATHER_BOOTS),
                        BuiltInLootTables.VILLAGE_ARMORER,
                        new ItemStack(Items.EMERALD),
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableAndItemForItemFactory(
                        BuiltInLootTables.VILLAGE_ARMORER,
                        new ItemStack(Items.EMERALD),
                        1,
                        new ItemStack(Items.STONE_AXE),
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("example_modid:examplemod_profession"),
                apprentice,
                new LootTableForDyedArmorFactory(
                        BuiltInLootTables.VILLAGE_ARMORER,
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemFactory(
                        new ItemStack(Items.LEATHER_BOOTS),
                        BuiltInLootTables.VILLAGE_ARMORER,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForEnchantedItemTableFactory(
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                        BuiltInLootTables.VILLAGE_ARMORER,
                        COMMON_MAX_TRADES,
                        BASE_XP * master,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("example_modid:examplemod_profession"),
                journeyman,
                new LootTableForItemFactory(
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        new ItemStack(Items.EMERALD),
                        1,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForLootBoxFactory(
                        new ItemStack(Items.CHEST),
                        "Loot Box",
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForLootBoxFactory(
                        new ItemStack(Items.CHEST),
                        "Loot Box",
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        BuiltInLootTables.VILLAGE_DESERT_HOUSE,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("example_modid:examplemod_profession"),
                expert,
                new LootTableForLootTableFactory(
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForPotionFactory(
                        MobEffects.BLINDNESS,
                        200,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForSpecifiedEnchantmentFactory(
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER,
                        1, "minecraft:soul_speed"
                )
        );
        builder.add(ResourceLocation.parse("example_modid:examplemod_profession"),
                master,
                new LootTableForSUSStewFactory(
                        MobEffects.WATER_BREATHING,
                        200,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new LootTableForTagTableFactory(
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        BuiltInLootTables.VILLAGE_SHEPHERD,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TagTableForLootTableFactory(
                        BuiltInLootTables.VILLAGE_SHEPHERD,
                        6,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new SellItemForItemsFactory(
                        Items.EMERALD.getDefaultInstance(),
                        Items.CHICKEN.getDefaultInstance(),
                        Items.COOKED_CHICKEN.getDefaultInstance(),
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("example_modid:examplemod_profession"),
                common,
                new LootTableForTippedArrowFactory(
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        6,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new SellItemForItemsFactory(
                        new ItemStack(Items.APPLE),
                        new ItemStack(Items.EMERALD),
                        new ItemStack(Items.COAL),
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForEnchantedItemFactory(
                        new ItemStack(Items.IRON_SWORD),
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        BuiltInLootTables.VILLAGE_SHEPHERD,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        builder.add(ResourceLocation.parse("example_modid:examplemod_profession"),
                rare,
                new TwoLootTableForLootTableFactory(
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        BuiltInLootTables.VILLAGE_FLETCHER,
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                ),
                new TwoLootTableForMapFactory(
                        BuiltInLootTables.SIMPLE_DUNGEON,
                        BuiltInLootTables.VILLAGE_BUTCHER,
                        StructureTags.MINESHAFT.location().toString(),
                        "Mineshaft Map",
                        MapDecoration.Type.RED_X.name(),
                        COMMON_MAX_TRADES,
                        BASE_XP * novice,
                        COMMON_TRADE_MULTIPLIER
                )
        );
        if (ModList.get().isLoaded("wares")) {
            builder.add(ResourceLocation.parse("example_modid:examplemod_profession"),
                    rare,
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
                            BASE_XP,
                            COMMON_MAX_TRADES,
                            BASE_XP * novice,
                            COMMON_TRADE_MULTIPLIER
                    )
            );
        }
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput output) {
        Path outputPath = this.output.getOutputFolder().resolve("data").resolve(MODID).resolve("trades");

        JsonTradesBuilder builder = JsonTradesBuilder.create();
        buildTrades(builder);

        List<CompletableFuture<?>> futures = new ArrayList<>();

        for (var professionEntry : builder.build().entrySet()) {
            ResourceLocation professionId = professionEntry.getKey();
            Map<Integer, List<VillagerTrades.ItemListing>> tradeLevels = professionEntry.getValue();

            TradeOfferManager.CustomWanderingTraderTrades traderTrades =
                    new TradeOfferManager.CustomWanderingTraderTrades(professionId, false, tradeLevels);
            TradeOfferManager.CustomVillagerTrades villagerTrades =
                    new TradeOfferManager.CustomVillagerTrades(professionId, false, tradeLevels);

            JsonElement tradeJson;

            // ID pre-check
            boolean isWanderingTrader = professionId.equals(TradeOfferManager.WANDERING_TRADER_PROFESSION_ID);
            boolean isNumismatist = professionId.equals(TradeOfferManager.NUMISMATIST_PROFESSION_ID);
            boolean isPiglinMerchant = professionId.equals(TradeOfferManager.PIGLINMERCHANT_PROFESSION_ID);
            boolean isGoblinTrader = professionId.equals(TradeOfferManager.GOBLIN_TRADER_ID);
            boolean isVeinGoblinTrader = professionId.equals(TradeOfferManager.VEIN_GOBLIN_TRADER_ID);
            boolean isRedMerchant = professionId.equals(TradeOfferManager.RED_MERCHANT_ID);

            if (isNumismatist || isPiglinMerchant || isWanderingTrader || isGoblinTrader || isVeinGoblinTrader || isRedMerchant) {
                tradeJson = TradeOfferManager.CustomWanderingTraderTrades.CUSTOM_WANDERING_TRADER_TRADES_CODEC
                        .encodeStart(JsonOps.INSTANCE, traderTrades)
                        .getOrThrow(false, error -> TC_LOGGER.error("Failed to encode for trader: {}", error));
            }
            else {
                tradeJson = TradeOfferManager.CustomVillagerTrades.CUSTOM_VILLAGER_TRADES_CODEC
                        .encodeStart(JsonOps.INSTANCE, villagerTrades)
                        .getOrThrow(false, error -> TC_LOGGER.error("Failed to encode for villager: {}", error));
            }

            Path tradeFile = outputPath.resolve(professionId.getNamespace()).resolve(professionId.getPath() + ".json");
            try {
                Files.createDirectories(tradeFile.getParent());
            }
            catch (IOException ioException) {
                throw new RuntimeException(ioException);
            }
            // Add save tasks to future list
            futures.add(DataProvider.saveStable(output, tradeJson, tradeFile));
        }

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public @NotNull String getName() {
        return "JsonTrades - Custom Trade JSON Generator";
    }
}