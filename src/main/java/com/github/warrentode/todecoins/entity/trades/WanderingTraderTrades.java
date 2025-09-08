package com.github.warrentode.todecoins.entity.trades;

import com.github.warrentode.todecoins.Config;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.*;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.entity.trades.TradeOfferConstants.*;

public class WanderingTraderTrades {
    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull WandererTradesEvent event) {
            List<VillagerTrades.ItemListing> commonWandererTrades = event.getGenericTrades();
            List<VillagerTrades.ItemListing> rareWandererTrades = event.getRareTrades();

            commonWandererTrades.clear();
            rareWandererTrades.clear();

            for (int i = 0; i < Config.getMaxWandererTrades(); ++i) {
                // COMMON TRADES
                commonWandererTrades.add(
                        new LootTableForLootTable(
                                TradeLootTables.WANDERING_PURCHASE_TABLE,
                                TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                                RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForTagTable(
                                TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                                TradeLootTables.TAGGED_DYES_TABLE, 3,
                                RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForLootTable(
                                TradeLootTables.TWO_EMERALD_VALUE_CURRENCY,
                                TradeLootTables.WANDERING_SELL_TWO_EMERALD_VALUE_TABLE,
                                RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForLootTable(
                                TradeLootTables.THREE_EMERALD_VALUE_CURRENCY,
                                TradeLootTables.WANDERING_SELL_THREE_EMERALD_VALUE_TABLE,
                                RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForLootTable(
                                TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY,
                                TradeLootTables.SLIMEBALL_TAG_TABLE,
                                RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                        ));
                commonWandererTrades.add(
                        new LootTableForLootTable(
                                TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY,
                                TradeLootTables.WANDERING_SELL_FIVE_EMERALD_VALUE_TABLE,
                                RARE_MAX_TRADES, BASE_XP * common, RARE_TRADE_MULTIPLIER
                        ));
            }

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

            // RARE TRADES
            chestLoot.forEach(chestTable -> rareWandererTrades.add(
                    new LootTableForLootBox(
                            Items.SHULKER_BOX.getDefaultInstance(),
                            "tooltip.todecoins.mystery_loot_box",
                            chestTable,
                            TradeLootTables.SIXTEEN_EMERALD_VALUE_CURRENCY,
                            RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                    )));
            rareWandererTrades.add(
                    new LootTableForLootTable(
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            TradeLootTables.WANDERING_SELL_SPECIAL_TABLE,
                            RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                    ));
            rareWandererTrades.add(
                    new LootTableForEnchantedItemTable(
                            TradeLootTables.IRON_TIER_TOOLS_TABLE,
                            TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY,
                            RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                    ));
            rareWandererTrades.add(
                    new LootTableForItem(
                            TradeLootTables.ONE_EMERALD_VALUE_CURRENCY,
                            new ItemStack(Items.BLUE_ICE),
                            1,
                            RARE_MAX_TRADES, BASE_XP * rare, RARE_TRADE_MULTIPLIER
                    ));
        }
    }
}