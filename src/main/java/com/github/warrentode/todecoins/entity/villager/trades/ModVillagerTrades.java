package com.github.warrentode.todecoins.entity.villager.trades;

import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.entity.villager.ModVillagers;
import com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table.*;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.VillagerTradeLootTables;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
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
            if (CommonConfig.getCurrency()) {
                // TOOLSMITH
                if (event.getType() == VillagerProfession.TOOLSMITH) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.STONE_TIER_TOOLS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.IRON_INGOT.getDefaultInstance(), 4,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            VillagerTradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                            Items.BELL.getDefaultInstance(), 1,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.IRON_TIER_TOOLS_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.IRON_TIER_TOOLS_TABLE,
                            VillagerTradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            VillagerTradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_TOOLS_TABLE,
                            VillagerTradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.GOLD_TIER_TOOLS_TABLE,
                            VillagerTradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            Items.SHEARS.getDefaultInstance(), 1,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_DYES_TABLE, 12,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_WOOL_TABLE, 1,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_WOOL_CARPETS_TABLE, 4,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_DYES_TABLE, 12,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_BEDS_TABLE, 1,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_DYES_TABLE, 12,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_BANNER_TABLE, 1,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_DYES_TABLE, 12,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            VillagerTradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.SINGLE_BRICK_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.OVERWORLD_BRICK_BLOCKS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.OVERWORLD_POLISHED_BLOCKS_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TERRACOTTA_BLOCKS_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.OTHER_STONE_BLOCKS_TABLE,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            VillagerTradeLootTables.OTHER_STONE_BLOCKS_TABLE,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            VillagerTradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.BOOKSHELF_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.BOOK.getDefaultInstance(), 4,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            VillagerTradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.LANTERN_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.INK_SAC.getDefaultInstance(), 5,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            VillagerTradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_GLASS_TABLE, 4,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new ItemForLootTable(
                            Items.WRITABLE_BOOK.getDefaultInstance(), 2,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            VillagerTradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new DyedArmorForLootTable(
                            VillagerTradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForItem(
                            VillagerTradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                            Items.CLOCK.getDefaultInstance(), 1,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(master).add(new LootTableForTagTable(
                                VillagerTradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                VillagerTradeLootTables.TAGGED_INK_TABLE, 5,
                                MAX_USES, 5 * master, PRICE_MULTIPLIER
                        ));
                    }
                    trades.get(master).add(new LootTableForItem(
                            VillagerTradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                            Items.COMPASS.getDefaultInstance(), 1,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            VillagerTradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.LEATHER_TIER_LEGGINGS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            VillagerTradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            VillagerTradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.LEATHER_TIER_HELMETS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            VillagerTradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.LEATHER_TIER_BOOTS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_LEATHER_TABLE, 6,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new DyedArmorForLootTable(
                            VillagerTradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new ItemForLootTable(
                            Items.SCUTE.getDefaultInstance(), 4,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new DyedArmorForLootTable(
                            VillagerTradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            VillagerTradeLootTables.SIX_EMERALD_VALUE_CURRENCY,
                            Items.SADDLE.getDefaultInstance(), 1,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new DyedArmorForLootTable(
                            VillagerTradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableAndItemForItem(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            Items.GRAVEL.getDefaultInstance(), 10,
                            Items.FLINT.getDefaultInstance(), 10,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.BOWS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.STRING.getDefaultInstance(), 14,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.FEATHER.getDefaultInstance(), 24,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.BOWS_TABLE,
                            VillagerTradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                VillagerTradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                VillagerTradeLootTables.TAGGED_QUIVERS_TABLE, 1,
                                MAX_USES, 5 * expert, PRICE_MULTIPLIER
                        ));
                    }
                    trades.get(expert).add(new ItemForLootTable(
                            Items.TRIPWIRE_HOOK.getDefaultInstance(), 8,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new TippedArrowForLootTable(
                            VillagerTradeLootTables.TWO_EMERALD_VALUE_CURRENCY, 5,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new TippedArrowForLootTable(
                            VillagerTradeLootTables.TWO_EMERALD_VALUE_CURRENCY, 5,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE, 6,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            Items.COD_BUCKET.getDefaultInstance(), 1,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE, 8,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE, 6,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            VillagerTradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                            Items.CAMPFIRE.getDefaultInstance(), 1,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE, 8,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.FISHING_GEAR_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchanted(
                            Items.FISHING_ROD.getDefaultInstance(),
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE, 8,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_SEAFOOD_TABLE, 8,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            VillagerTradeLootTables.FISHING_GEAR_TABLE,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_BREADS_TABLE, 6,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_GOURDS_TABLE, 6,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_PIES_TABLE, 4,
                            MAX_USES, 5 + apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_FRUITS_TABLE, 4,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_COOKIES_TABLE, 18,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_CAKES_TABLE, 1,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.NIGHT_VISION, 300,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.JUMP, 300,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.WEAKNESS, 300,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.BLINDNESS, 300,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.POISON, 300,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.SATURATION, 300,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            Items.GOLDEN_CARROT.getDefaultInstance(), 3,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            VillagerTradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.GOLD_INGOT.getDefaultInstance(), 3,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            MAX_USES, 5 + apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.RABBIT_FOOT.getDefaultInstance(), 2,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            MAX_USES, 5 + journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new ItemForLootTable(
                            Items.SCUTE.getDefaultInstance(), 4,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new ItemForLootTable(
                            Items.GLASS_BOTTLE.getDefaultInstance(), 9,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            VillagerTradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.FIVE_EMERALD_VALUE_GEMS,
                            MAX_USES, 5 + expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new ItemForLootTable(
                            Items.NETHER_WART.getDefaultInstance(), 22,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            VillagerTradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                            Items.MAP.getDefaultInstance(), 1,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_GLASS_PANES_TABLE, 11,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new MapForLootTable(
                            VillagerTradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                            Items.COMPASS.getDefaultInstance(), 1,
                            ForgeTags.StructureTags.OVERWORLD_POI,
                            "Overworld Exploration Map", MapDecoration.Type.TARGET_POINT,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.COMPASS.getDefaultInstance(), 1,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new MapForLootTable(
                            VillagerTradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                            Items.COMPASS.getDefaultInstance(), 1,
                            ForgeTags.StructureTags.OVERWORLD_POI,
                            "Overworld Exploration Map", MapDecoration.Type.TARGET_POINT,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForItem(
                            VillagerTradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                            Items.ITEM_FRAME.getDefaultInstance(), 1,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForTagTable(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_BANNER_TABLE, 1,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            VillagerTradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY,
                            Items.GLOBE_BANNER_PATTERN.getDefaultInstance(), 1,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new MapForLootTable(
                            VillagerTradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_MEAT_SOUPS_TABLE, 1,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.TAGGED_COOKED_MEATS_TABLE, 8,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_RAW_MEATS_TABLE, 8,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("farmersdelight")) {
                        trades.get(journeyman).add(new LootTableForTagTable(
                                VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                VillagerTradeLootTables.STONE_TIER_KNIVES, 1,
                                MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                        ));
                    }
                    else {
                        trades.get(journeyman).add(new LootTableForTagTable(
                                VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                VillagerTradeLootTables.TAGGED_COOKED_MEATS_TABLE, 8,
                                MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                        ));
                    }

                    trades.get(expert).add(new ItemForLootTable(
                            Items.DRIED_KELP_BLOCK.getDefaultInstance(), 10,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("salt")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                VillagerTradeLootTables.TAGGED_SALTS_TABLE, 8,
                                MAX_USES, 5 * expert, PRICE_MULTIPLIER
                        ));
                    }
                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                VillagerTradeLootTables.TAGGED_ASH_TABLE, 8,
                                MAX_USES, 5 * expert, PRICE_MULTIPLIER
                        ));
                    }
                    else {
                        trades.get(expert).add(new LootTableForTagTable(
                                VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                                VillagerTradeLootTables.TAGGED_COOKED_MEATS_TABLE, 8,
                                MAX_USES, 5 * expert, PRICE_MULTIPLIER
                        ));
                    }

                    trades.get(master).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_FOX_FOOD_TABLE, 8,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForTagTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
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
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.CHAINMAIL_TIER_HELMETS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.CHAINMAIL_TIER_CHESTPLATES_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.CHAINMAIL_TIER_LEGGINGS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.CHAINMAIL_TIER_BOOTS_TABLE,
                            MAX_USES, novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.IRON_INGOT.getDefaultInstance(), 4,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            VillagerTradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY,
                            Items.BELL.getDefaultInstance(), 1,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.IRON_TIER_LEGGINGS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            VillagerTradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.IRON_TIER_BOOTS_TABLE,
                            MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.LAVA_BUCKET.getDefaultInstance(), 1,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_GEMS,
                            VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.IRON_TIER_HELMETS_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            VillagerTradeLootTables.NINE_EMERALD_VALUE_CURRENCY,
                            VillagerTradeLootTables.IRON_TIER_CHESTPLATES_TABLE,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForItem(
                            VillagerTradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                            Items.SHIELD.getDefaultInstance(), 1,
                            MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_LEGGINGS_TABLE,
                            VillagerTradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_BOOTS_TABLE,
                            VillagerTradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_HELMETS_TABLE,
                            VillagerTradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * master, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            VillagerTradeLootTables.DIAMOND_TIER_CHESTPLATES_TABLE,
                            VillagerTradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY,
                            MAX_USES, 5 * expert, PRICE_MULTIPLIER
                    ));
                }
            }

            // BANKER TRADES SET
            if (event.getType() == ModVillagers.BANKER.get()) {
                trades.get(novice).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 1,
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        MAX_USES, novice, PRICE_MULTIPLIER
                ));
                trades.get(novice).add(new LootTableForItem(
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY,
                        Items.EMERALD.getDefaultInstance(), 1,
                        MAX_USES, novice, PRICE_MULTIPLIER
                ));

                trades.get(apprentice).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 16,
                        VillagerTradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new LootTableForItem(
                        VillagerTradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY,
                        Items.EMERALD.getDefaultInstance(), 16,
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 32,
                        VillagerTradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new LootTableForItem(
                        VillagerTradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY,
                        Items.EMERALD.getDefaultInstance(), 32,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));

                trades.get(expert).add(new LootTableForItem(
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
                        Items.EMERALD.getDefaultInstance(), 64,
                        MAX_USES, 5 * expert, PRICE_MULTIPLIER
                ));
                trades.get(expert).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 64,
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY,
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
                        VillagerTradeLootTables.TWO_POT_OF_GOLD_VALUE_CURRENCY,
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        MAX_USES, novice, PRICE_MULTIPLIER
                ));
                trades.get(novice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        VillagerTradeLootTables.TWO_POT_OF_GOLD_VALUE_CURRENCY,
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
                        VillagerTradeLootTables.FOUR_POT_OF_GOLD_VALUE_CURRENCY,
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        VillagerTradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS,
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        VillagerTradeLootTables.FOUR_POT_OF_GOLD_VALUE_CURRENCY,
                        MAX_USES, 5 * apprentice, PRICE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        VillagerTradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_ITEMS,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        VillagerTradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_CURRENCY,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        VillagerTradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_GEMS,
                        MAX_USES, 5 * journeyman, PRICE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        VillagerTradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_CURRENCY,
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
                        VillagerTradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY,
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        MAX_USES, 5 * expert, PRICE_MULTIPLIER
                ));
                trades.get(expert).add(new ItemForLootTable(
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        VillagerTradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY,
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