package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.entity.villager.ModVillagers;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table.*;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.VillagerTradeLootTables;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModVillagerTrades {
    static int novice = 1;
    static int apprentice = 2;
    static int journeyman = 3;
    static int expert = 4;
    static int master = 5;
    static int MAX_USES = 16;
    static float PRICE_MULTIPLIER = 0.05F;

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // vanilla trades
            if (CommonConfig.getCustomTrades()) {
                // TOOLSMITH
                if (event.getType() == VillagerProfession.TOOLSMITH) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.STONE_TIER_TOOLS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.IRON_INGOT.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldValueTable()),
                            Items.BELL.getDefaultInstance(), 1,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.IRON_TIER_TOOLS_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.IRON_TIER_TOOLS_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldValueTable()),
                            VillagerTradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldValueTable()),
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.GOLD_TIER_TOOLS_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldValueTable()),
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                }
                // SHEPHERD
                if (event.getType() == VillagerProfession.SHEPHERD) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.WHITE_WOOL.getDefaultInstance(), 18,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            Items.SHEARS.getDefaultInstance(), 1,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_DYES_TABLE, 12,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_WOOL_TABLE, 1,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_WOOL_CARPETS_TABLE, 4,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_DYES_TABLE, 12,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_BEDS_TABLE, 1,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_DYES_TABLE, 12,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_BANNER_TABLE, 1,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_DYES_TABLE, 12,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldValueTable()),
                            VillagerTradeLootTables.PAINTINGS_TABLE,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                }
                // MASON
                if (event.getType() == VillagerProfession.MASON) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.CLAY_BALL.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.SINGLE_BRICK_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.OVERWORLD_BRICK_BLOCKS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.OVERWORLD_POLISHED_BLOCKS_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.OTHER_STONE_BLOCKS_TABLE,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            VillagerTradeLootTables.OTHER_STONE_BLOCKS_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
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
                        trades.get(novice).add(new LootTableForItem(
                                VillagerTradeLootTables.GUIDE_BOOKS_TABLE,
                                ModItems.COPPER_COIN.get().getDefaultInstance(), 1,
                                MAX_USES, novice, PRICE_MULTIPLIER
                        ));
                    }
                    trades.get(novice).add(new ItemForLootTable(
                            Items.PAPER.getDefaultInstance(), 24,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getNineEmeraldValueTable()),
                            VillagerTradeLootTables.BOOKSHELF_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.BOOK.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.LANTERN_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.INK_SAC.getDefaultInstance(), 5,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_GLASS_TABLE, 4,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new ItemForLootTable(
                            Items.WRITABLE_BOOK.getDefaultInstance(), 2,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSixEmeraldValueTable()),
                            VillagerTradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldValueTable()),
                            Items.CLOCK.getDefaultInstance(), 1,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(master).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getFourEmeraldValueTable()),
                                VillagerTradeLootTables.TAGGED_INK_TABLE, 5,
                                MAX_USES, 5 * master, PRICE_MULTIPLIER
                        ));
                    }
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldValueTable()),
                            Items.COMPASS.getDefaultInstance(), 1,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldValueTable()),
                            Items.NAME_TAG.getDefaultInstance(), 1,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
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
                            VillagerTradeLootTables.TAGGED_LEATHER_TABLE, 6,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.LEATHER_TIER_LEGGINGS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldValueTable()),
                            VillagerTradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldValueTable()),
                            VillagerTradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldValueTable()),
                            VillagerTradeLootTables.LEATHER_TIER_BOOTS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_LEATHER_TABLE, 6,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldValueTable()),
                            VillagerTradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new ItemForLootTable(
                            Items.SCUTE.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSixEmeraldValueTable()),
                            VillagerTradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getSixEmeraldValueTable()),
                            Items.SADDLE.getDefaultInstance(), 1,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldValueTable()),
                            VillagerTradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                }
                // FLETCHER
                if (event.getType() == VillagerProfession.FLETCHER) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.STICK.getDefaultInstance(), 32,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableAndItemForItem(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            Items.GRAVEL.getDefaultInstance(), 10,
                            Items.FLINT.getDefaultInstance(), 10,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.BOWS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.STRING.getDefaultInstance(), 14,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.FEATHER.getDefaultInstance(), 24,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.BOWS_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getTwoEmeraldValueTable()),
                                VillagerTradeLootTables.TAGGED_QUIVERS_TABLE, 1,
                                MAX_USES, 5 * expert, PRICE_MULTIPLIER
                        ));
                    }
                    trades.get(expert).add(new ItemForLootTable(
                            Items.TRIPWIRE_HOOK.getDefaultInstance(), 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new TippedArrowForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldValueTable()), 5,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new TippedArrowForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldValueTable()), 5,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                }
                // FISHERMAN
                if (event.getType() == VillagerProfession.FISHERMAN) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.STRING.getDefaultInstance(), 20,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE, 6,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldValueTable()),
                            Items.COD_BUCKET.getDefaultInstance(), 1,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE, 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE, 6,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldValueTable()),
                            Items.CAMPFIRE.getDefaultInstance(), 1,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE, 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.FISHING_GEAR_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchanted(
                            Items.FISHING_ROD.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE, 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE, 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            VillagerTradeLootTables.FISHING_GEAR_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
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
                            VillagerTradeLootTables.TAGGED_VEGGIES_AND_GRAINS_TABLE, 16,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_BREADS_TABLE, 6,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_GOURDS_TABLE, 6,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_PIES_TABLE, 4,
                            MAX_USES, 5 + apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_FRUITS_TABLE, 4,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_COOKIES_TABLE, 18,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_CAKES_TABLE, 1,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.NIGHT_VISION, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.JUMP, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.WEAKNESS, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.BLINDNESS, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.POISON, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.SATURATION, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldValueTable()),
                            Items.GOLDEN_CARROT.getDefaultInstance(), 3,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldValueTable()),
                            Items.GLISTERING_MELON_SLICE.getDefaultInstance(), 3,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                }
                // CLERIC
                if (event.getType() == VillagerProfession.CLERIC) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.ROTTEN_FLESH.getDefaultInstance(), 32,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.GOLD_INGOT.getDefaultInstance(), 3,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            MAX_USES, 5 + apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.RABBIT_FOOT.getDefaultInstance(), 2,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            MAX_USES, 5 + journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new ItemForLootTable(
                            Items.SCUTE.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new ItemForLootTable(
                            Items.GLASS_BOTTLE.getDefaultInstance(), 9,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldValueTable()),
                            VillagerTradeLootTables.FIVE_EMERALD_VALUE_GEMS,
                            MAX_USES, 5 + expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new ItemForLootTable(
                            Items.NETHER_WART.getDefaultInstance(), 22,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldValueTable()),
                            Items.EXPERIENCE_BOTTLE.getDefaultInstance(), 1,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                }
                // CARTOGRAPHER
                if (event.getType() == VillagerProfession.CARTOGRAPHER) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.PAPER.getDefaultInstance(), 24,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldValueTable()),
                            Items.MAP.getDefaultInstance(), 1,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_GLASS_PANES_TABLE, 11,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new MapForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourteenEmeraldValueTable()),
                            Items.COMPASS.getDefaultInstance(), 1,
                            ForgeTags.StructureTags.OVERWORLD_POI,
                            "Overworld Exploration Map", MapDecoration.Type.TARGET_POINT,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.COMPASS.getDefaultInstance(), 1,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new MapForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourteenEmeraldValueTable()),
                            Items.COMPASS.getDefaultInstance(), 1,
                            ForgeTags.StructureTags.OVERWORLD_POI,
                            "Overworld Exploration Map", MapDecoration.Type.TARGET_POINT,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldValueTable()),
                            Items.ITEM_FRAME.getDefaultInstance(), 1,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_BANNER_TABLE, 1,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getEightEmeraldValueTable()),
                            Items.GLOBE_BANNER_PATTERN.getDefaultInstance(), 1,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new MapForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourteenEmeraldValueTable()),
                            Items.COMPASS.getDefaultInstance(), 1,
                            ForgeTags.StructureTags.OVERWORLD_POI,
                            "Overworld Exploration Map", MapDecoration.Type.TARGET_POINT,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
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
                            VillagerTradeLootTables.TAGGED_RAW_MEATS_TABLE, 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_MEAT_SOUPS_TABLE, 1,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_COOKED_MEATS_TABLE, 8,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_MEATS_TABLE, 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("farmersdelight")) {
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                                VillagerTradeLootTables.STONE_TIER_KNIVES, 1,
                                MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                        ));
                    }
                    else {
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                                VillagerTradeLootTables.TAGGED_COOKED_MEATS_TABLE, 8,
                                MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                        ));
                    }

                    trades.get(expert).add(new ItemForLootTable(
                            Items.DRIED_KELP_BLOCK.getDefaultInstance(), 10,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("salt")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                                VillagerTradeLootTables.TAGGED_SALTS_TABLE, 8,
                                MAX_USES, 5 * expert, PRICE_MULTIPLIER
                        ));
                    }
                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                                VillagerTradeLootTables.TAGGED_ASH_TABLE, 8,
                                MAX_USES, 5 * expert, PRICE_MULTIPLIER
                        ));
                    }
                    else {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                                VillagerTradeLootTables.TAGGED_COOKED_MEATS_TABLE, 8,
                                MAX_USES, 5 * expert, PRICE_MULTIPLIER
                        ));
                    }

                    trades.get(master).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_FOX_FOOD_TABLE, 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.TAGGED_COOKED_MEATS_TABLE, 8,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                }
                // ARMORER
                if (event.getType() == VillagerProfession.ARMORER) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 15,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.CHAINMAIL_TIER_HELMETS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldValueTable()),
                            VillagerTradeLootTables.CHAINMAIL_TIER_CHESTPLATES_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldValueTable()),
                            VillagerTradeLootTables.CHAINMAIL_TIER_LEGGINGS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            VillagerTradeLootTables.CHAINMAIL_TIER_BOOTS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.IRON_INGOT.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldValueTable()),
                            Items.BELL.getDefaultInstance(), 1,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldValueTable()),
                            VillagerTradeLootTables.IRON_TIER_LEGGINGS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldValueTable()),
                            VillagerTradeLootTables.IRON_TIER_BOOTS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.LAVA_BUCKET.getDefaultInstance(), 1,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldValueTable()),
                            VillagerTradeLootTables.IRON_TIER_HELMETS_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getNineEmeraldValueTable()),
                            VillagerTradeLootTables.IRON_TIER_CHESTPLATES_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldValueTable()),
                            Items.SHIELD.getDefaultInstance(), 1,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_LEGGINGS_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_BOOTS_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_HELMETS_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldValueTable()),
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_CHESTPLATES_TABLE,
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldValueTable()),
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                }
            }

            // BANKER TRADES SET
            if (event.getType() == ModVillagers.BANKER.get()) {
                trades.get(novice).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 1,
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                        MAX_USES, novice, PRICE_MULTIPLIER
                ));
                trades.get(novice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldValueTable()),
                        Items.EMERALD.getDefaultInstance(), 1,
                        MAX_USES, novice, PRICE_MULTIPLIER
                ));

                trades.get(apprentice).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 16,
                        ResourceLocation.tryParse(CommonConfig.getEmeraldQuarterNoteValueTable()),
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldQuarterNoteValueTable()),
                        Items.EMERALD.getDefaultInstance(), 16,
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 32,
                        ResourceLocation.tryParse(CommonConfig.getEmeraldHalfNoteValueTable()),
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldHalfNoteValueTable()),
                        Items.EMERALD.getDefaultInstance(), 32,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));

                trades.get(expert).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteValueTable()),
                        Items.EMERALD.getDefaultInstance(), 64,
                        MAX_USES, 5 * expert, PRICE_MULTIPLIER
                ));
                trades.get(expert).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 64,
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteValueTable()),
                        MAX_USES, 5 * expert, PRICE_MULTIPLIER
                ));

                trades.get(master).add(new LootTableForItem(
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_METALS,
                        Items.EMERALD.getDefaultInstance(), 1,
                        MAX_USES, 5 * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                        Items.EMERALD.getDefaultInstance(), 1,
                        MAX_USES, 5 * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_METALS,
                        ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1,
                        MAX_USES, 5 * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_GEMS,
                        ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1,
                        MAX_USES, 5 * master, PRICE_MULTIPLIER
                ));
            }

            // LEPRECHAUN TRADES SET
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                trades.get(novice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getTwoPotGoldValueTable()),
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        MAX_USES, novice, PRICE_MULTIPLIER
                ));
                trades.get(novice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        ResourceLocation.tryParse(CommonConfig.getTwoPotGoldValueTable()),
                        MAX_USES, novice, PRICE_MULTIPLIER
                ));

                trades.get(apprentice).add(new LootTableForItem(
                        VillagerTradeLootTables.TWO_POT_OF_GOLD_VALUE_GEMS,
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new LootTableForItem(
                        VillagerTradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS,
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));

                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        ResourceLocation.tryParse(CommonConfig.getFourPotGoldValueTable()),
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        VillagerTradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS,
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        ResourceLocation.tryParse(CommonConfig.getFourPotGoldValueTable()),
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        VillagerTradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_ITEMS,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        ResourceLocation.tryParse(CommonConfig.getThirtyPotGoldValueTable()),
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        VillagerTradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_GEMS,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        ResourceLocation.tryParse(CommonConfig.getSixtyPotGoldValueTable()),
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        VillagerTradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_ITEMS,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        VillagerTradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_GEMS,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));

                trades.get(expert).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneLuckyCoinValueTable()),
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        MAX_USES, 5 * expert, PRICE_MULTIPLIER
                ));
                trades.get(expert).add(new ItemForLootTable(
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        ResourceLocation.tryParse(CommonConfig.getOneLuckyCoinValueTable()),
                        MAX_USES, 5 * expert, PRICE_MULTIPLIER
                ));

                trades.get(master).add(new LootTableForItem(
                        VillagerTradeLootTables.SINGLE_LUCKY_COIN_VALUE_GEMS,
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        MAX_USES, 5 * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        VillagerTradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS,
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 3,
                        MAX_USES, 5 * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        VillagerTradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS,
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 27,
                        MAX_USES, 5 * master, PRICE_MULTIPLIER
                ));
            }
        }
    }
}