package net.warrentode.todecoins.entity.villager.trades;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.entity.villager.ModVillagers;
import net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemForItemTrade;
import net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemsAndItemsForItemsTrade;
import net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemsSaleSetForItemsTrade;
import net.warrentode.todecoins.item.ModItems;

import java.util.List;

import static net.warrentode.todecoins.TodeCoins.MODID;
import static net.warrentode.todecoins.entity.villager.trades.tradetypes.ItemsSaleSetForItemsTrade.*;

public class ModVillagerTrades {
    static int novice = 1;
    static int apprentice = 2;
    static int journeyman = 3;
    static int expert = 4;
    static int master = 5;

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // BANKER TRADES SET
            if (event.getType() == ModVillagers.BANKER.get()) {
                trades.get(novice).add(new ItemForItemTrade(ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18, Items.EMERALD.getDefaultInstance(), 1, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_1_SELL, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));
                trades.get(novice).add(new ItemForItemTrade(Items.EMERALD.getDefaultInstance(), 1, ModBlocks.COPPER_COIN_BAG.get().asItem().getDefaultInstance(), 18, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_1_BUY, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));

                trades.get(apprentice).add(new ItemForItemTrade(ModItems.IRON_COIN.get().asItem().getDefaultInstance(), 1, ModItems.COPPER_COIN.get().asItem().getDefaultInstance(), 2, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_2_SELL, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));
                trades.get(apprentice).add(new ItemForItemTrade(ModItems.COPPER_COIN.get().asItem().getDefaultInstance(), 2, ModItems.IRON_COIN.get().asItem().getDefaultInstance(), 1, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_2_BUY, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));

                trades.get(journeyman).add(new ItemForItemTrade(ModItems.GOLD_COIN.get().asItem().getDefaultInstance(), 1, ModItems.IRON_COIN.get().asItem().getDefaultInstance(), 2, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_3_SELL, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));
                trades.get(journeyman).add(new ItemForItemTrade(ModItems.IRON_COIN.get().asItem().getDefaultInstance(), 2, ModItems.GOLD_COIN.get().asItem().getDefaultInstance(), 1, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_3_BUY, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));

                trades.get(journeyman).add(new ItemForItemTrade(ModItems.GOLD_COIN.get().asItem().getDefaultInstance(), 1, ModItems.IRON_COIN.get().asItem().getDefaultInstance(), 2, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_3_SELL, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));
                trades.get(journeyman).add(new ItemForItemTrade(ModItems.IRON_COIN.get().asItem().getDefaultInstance(), 2, ModItems.GOLD_COIN.get().asItem().getDefaultInstance(), 1, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_3_BUY, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));

                trades.get(expert).add(new ItemForItemTrade(ModItems.EMERALD_BANK_NOTE.get().asItem().getDefaultInstance(), 1, Items.EMERALD.asItem().getDefaultInstance(), 64, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_4_SELL, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));
                trades.get(expert).add(new ItemForItemTrade(Items.EMERALD.asItem().getDefaultInstance(), 64, ModItems.EMERALD_BANK_NOTE.get().asItem().getDefaultInstance(), 1, COMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_4_BUY, ItemForItemTrade.LOW_TIER_PRICE_MULTIPLIER));

                trades.get(master).add(new ItemForItemTrade(ModItems.NETHERITE_COIN.get().asItem().getDefaultInstance(), 2, ModItems.EMERALD_BANK_NOTE.get().asItem().getDefaultInstance(), 1, UNCOMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_5_TRADE, ItemForItemTrade.HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(master).add(new ItemForItemTrade(ModItems.EMERALD_BANK_NOTE.get().asItem().getDefaultInstance(), 1, ModItems.NETHERITE_COIN.get().asItem().getDefaultInstance(), 1, UNCOMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_5_TRADE, ItemForItemTrade.HIGH_TIER_PRICE_MULTIPLIER));
            }

            // LEPRECHAUN TRADES SET
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                trades.get(novice).add(new ItemForItemTrade(ModItems.EMERALD_QUARTER_BANK_NOTE.get().getDefaultInstance(), 1, ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 11, ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_1_BUY, ItemForItemTrade.HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(novice).add(new ItemForItemTrade(ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 11, ModItems.EMERALD_QUARTER_BANK_NOTE.get().getDefaultInstance(), 1, ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_1_SELL, ItemForItemTrade.HIGH_TIER_PRICE_MULTIPLIER));

                trades.get(apprentice).add(new ItemForItemTrade(ModItems.EMERALD_HALF_BANK_NOTE.get().getDefaultInstance(), 1, ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 21, ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_2_BUY, ItemForItemTrade.HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(apprentice).add(new ItemForItemTrade(ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 21, ModItems.EMERALD_HALF_BANK_NOTE.get().getDefaultInstance(), 1, ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_2_SELL, ItemForItemTrade.HIGH_TIER_PRICE_MULTIPLIER));

                trades.get(journeyman).add(new ItemForItemTrade(ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1, ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 43, ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_3_BUY, ItemForItemTrade.HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(journeyman).add(new ItemForItemTrade(ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 43, ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1, ItemsSaleSetForItemsTrade.UNCOMMON_ITEMS_SUPPLY, ItemForItemTrade.XP_LEVEL_3_SELL, ItemForItemTrade.HIGH_TIER_PRICE_MULTIPLIER));

                trades.get(expert).add(new ItemsSaleSetForItemsTrade(ImmutableSet.of(Items.PRISMARINE_SHARD, Items.NAME_TAG), 1,
                        ModItems.EMERALD_QUARTER_BANK_NOTE.get().asItem().getDefaultInstance(), 1,
                        UNCOMMON_ITEMS_SUPPLY, XP_LEVEL_4_SELL, HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(expert).add(new ItemForItemTrade(Items.REDSTONE_BLOCK.getDefaultInstance(), 2, ModItems.EMERALD_QUARTER_BANK_NOTE.get().getDefaultInstance(), 2, UNCOMMON_ITEMS_SUPPLY, XP_LEVEL_4_SELL, HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(expert).add(new ItemsSaleSetForItemsTrade(
                        ImmutableSet.of(
                                Items.PRISMARINE_CRYSTALS,
                                Items.BELL,
                                Items.DRAGON_HEAD,
                                Items.DRAGON_EGG,
                                Items.ELYTRA,
                                Items.NETHERITE_SCRAP
                        ), 1,
                        ModItems.EMERALD_HALF_BANK_NOTE.get().getDefaultInstance(), 1,
                        UNCOMMON_ITEMS_SUPPLY, XP_LEVEL_4_SELL, HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(expert).add(new ItemForItemTrade(Items.PRISMARINE.getDefaultInstance(), 1, ModItems.EMERALD_HALF_BANK_NOTE.get().getDefaultInstance(), 4, UNCOMMON_ITEMS_SUPPLY, XP_LEVEL_4_SELL, HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(expert).add(new ItemsAndItemsForItemsTrade(
                        Blocks.SEA_LANTERN.asItem().getDefaultInstance(), 1,
                        ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 3,
                        ModItems.EMERALD_HALF_BANK_NOTE.get().getDefaultInstance(), 1,
                        UNCOMMON_ITEMS_SUPPLY, XP_LEVEL_4_SELL, HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(expert).add(new ItemsSaleSetForItemsTrade(
                        ImmutableSet.of(Items.NETHER_STAR, Items.NETHERITE_INGOT), 1,
                        ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 9,
                        UNCOMMON_ITEMS_SUPPLY, XP_LEVEL_4_SELL, HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(master).add(new ItemForItemTrade(ModItems.LUCKY_COIN.get().getDefaultInstance(), 1, ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 3, 1, XP_LEVEL_4_SELL, HIGH_TIER_PRICE_MULTIPLIER));
                trades.get(master).add(new ItemForItemTrade(ModItems.NETHERITE_COIN.get().getDefaultInstance(), 1, ModItems.EMERALD_HALF_BANK_NOTE.get().getDefaultInstance(), 1, UNCOMMON_ITEMS_SUPPLY, XP_LEVEL_4_SELL, HIGH_TIER_PRICE_MULTIPLIER));
            }
        }
    }
}