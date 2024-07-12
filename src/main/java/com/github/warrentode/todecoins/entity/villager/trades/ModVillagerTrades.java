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
    static int MAX_USES = 16;
    static float PRICE_MULTIPLIER = 0.05F;

    // TODO: add weaponsmith trades

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // vanilla trades
            if (CommonConfig.getCustomTrades()) {
                // WEAPONSMITH
                if (event.getType() == VillagerProfession.WEAPONSMITH) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getIronWeaponTable()),
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getIronTierToolTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.IRON_INGOT.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            Items.BELL.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierWeaponTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getGoldTierWeaponTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getNetheriteTierWeaponTable()),
                            ResourceLocation.tryParse(CommonConfig.getLuckyCoinBagValueCurrency()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                }
                // TOOLSMITH
                if (event.getType() == VillagerProfession.TOOLSMITH) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getStoneTierToolTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.IRON_INGOT.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            Items.BELL.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierToolTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getIronTierToolTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierToolTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierToolTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getGoldTierToolTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getNetheriteTierToolTable()),
                            ResourceLocation.tryParse(CommonConfig.getLuckyCoinBagValueCurrency()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                }
                // SHEPHERD
                if (event.getType() == ForgeRegistries.VILLAGER_PROFESSIONS.getValue(ResourceLocation.tryParse("minecraft:shepherd"))) {
                    trades.get(novice).clear();
                    trades.get(apprentice).clear();
                    trades.get(journeyman).clear();
                    trades.get(expert).clear();
                    trades.get(master).clear();

                    trades.get(novice).add(new ItemForLootTable(
                            Items.WHITE_WOOL.getDefaultInstance(), 18,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            Items.SHEARS.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                            CommonConfig.getDyeCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getWoolTagTable()),
                            CommonConfig.getWoolCount(),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getWoolCarpetTagTable()),
                            CommonConfig.getWoolCarpetCount(),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                            CommonConfig.getDyeCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBedTagTable()),
                            CommonConfig.getBedCount(),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                            CommonConfig.getDyeCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBannerTagTable()),
                            CommonConfig.getBannerCount(),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getDyeTagTable()),
                            CommonConfig.getDyeCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getPaintingsTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOverworldBrickTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOverworldStoneTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOverworldBrickBlockTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOverworldPolishedStoneTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getTerracottaTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOtherStoneTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getGlazedTerracottaTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOtherStoneTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                                ResourceLocation.tryParse(CommonConfig.getGuideBookTable()),
                                ModItems.COPPER_COIN.get().getDefaultInstance(), 1,
                                MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                        ));
                    }
                    trades.get(novice).add(new ItemForLootTable(
                            Items.PAPER.getDefaultInstance(), 24,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getNineEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBookshelfTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.BOOK.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLanternTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.INK_SAC.getDefaultInstance(), 5,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getGlassTagTable()),
                            CommonConfig.getGlassCount(),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new ItemForLootTable(
                            Items.WRITABLE_BOOK.getDefaultInstance(), 2,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchanted(
                            Items.BOOK.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSixEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierHorseArmorTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            Items.CLOCK.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));

                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(master).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getInkTagTable()),
                                CommonConfig.getInkCount(),
                                MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                        ));
                    }
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            Items.COMPASS.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            Items.NAME_TAG.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierLeggingsTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierChestplateTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierHelmetTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierBootsTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getLeatherTagTable()),
                            CommonConfig.getLeatherCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierChestplateTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new ItemForLootTable(
                            Items.SCUTE.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSixEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierHorseArmorTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getSixEmeraldCurrencyTable()),
                            Items.SADDLE.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new DyedArmorForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getLeatherTierHelmetTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableAndItemForItem(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            Items.GRAVEL.getDefaultInstance(), 10,
                            Items.FLINT.getDefaultInstance(), 10,
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.FLINT.getDefaultInstance(), 26,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBowsTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.STRING.getDefaultInstance(), 14,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.FEATHER.getDefaultInstance(), 24,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getBowsTable()),
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("supplementaries")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getQuiversTagTable()),
                                CommonConfig.getQuiverCount(),
                                MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                        ));
                    }
                    trades.get(expert).add(new ItemForLootTable(
                            Items.TRIPWIRE_HOOK.getDefaultInstance(), 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new TippedArrowForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()), 5,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new TippedArrowForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()), 5,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getPreppedSeafoodTagTable()),
                            CommonConfig.getPreppedSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            Items.COD_BUCKET.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawSeafoodTagTable()),
                            CommonConfig.getRawSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getPreppedSeafoodTagTable()),
                            CommonConfig.getPreppedSeafoodCount(),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getTwoEmeraldCurrencyTable()),
                            Items.CAMPFIRE.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawSeafoodTagTable()),
                            CommonConfig.getRawSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getFishingGearTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchanted(
                            Items.FISHING_ROD.getDefaultInstance(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawSeafoodTagTable()),
                            CommonConfig.getRawSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawSeafoodTagTable()),
                            CommonConfig.getRawSeafoodCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFishingGearTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBreadTagTable()),
                            CommonConfig.getBreadCount(),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getGourdTagTable()),
                            CommonConfig.getGourdCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getPieTagTable()),
                            CommonConfig.getPieCount(),
                            MAX_USES, 5 + apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getFruitTagTable()),
                            CommonConfig.getFruitCount(),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCookieTagTable()),
                            CommonConfig.getCookieCount(),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCakeTagTable()),
                            CommonConfig.getCakeCount(),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.NIGHT_VISION, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.JUMP, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.WEAKNESS, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.BLINDNESS, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.POISON, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new SUSStewForLootTable(
                            MobEffects.SATURATION, 300,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            Items.GOLDEN_CARROT.getDefaultInstance(), 3,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            Items.GLISTERING_MELON_SLICE.getDefaultInstance(), 3,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.GOLD_INGOT.getDefaultInstance(), 3,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                            MAX_USES, 5 + apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.RABBIT_FOOT.getDefaultInstance(), 2,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                            MAX_USES, 5 + journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new ItemForLootTable(
                            Items.SCUTE.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new ItemForLootTable(
                            Items.GLASS_BOTTLE.getDefaultInstance(), 9,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldGemsTable()),
                            MAX_USES, 5 + expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new ItemForLootTable(
                            Items.NETHER_WART.getDefaultInstance(), 22,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            Items.EXPERIENCE_BOTTLE.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            Items.MAP.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getGlassPaneTagTable()),
                            CommonConfig.getGlassPaneCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new MapForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourteenEmeraldCurrencyTable()),
                            Items.COMPASS.getDefaultInstance(), 1,
                            ForgeTags.StructureTags.OVERWORLD_POI,
                            "Overworld Exploration Map", MapDecoration.Type.TARGET_POINT,
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.COMPASS.getDefaultInstance(), 1,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new MapForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourteenEmeraldCurrencyTable()),
                            Items.COMPASS.getDefaultInstance(), 1,
                            ForgeTags.StructureTags.OVERWORLD_POI,
                            "Overworld Exploration Map", MapDecoration.Type.TARGET_POINT,
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            Items.ITEM_FRAME.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getBannerTagTable()),
                            CommonConfig.getBannerCount(),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getEightEmeraldCurrencyTable()),
                            Items.GLOBE_BANNER_PATTERN.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new MapForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourteenEmeraldCurrencyTable()),
                            Items.COMPASS.getDefaultInstance(), 1,
                            ForgeTags.StructureTags.OVERWORLD_POI,
                            "Overworld Exploration Map", MapDecoration.Type.TARGET_POINT,
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getMeatSoupTagTable()),
                            CommonConfig.getMeatSoupCount(),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.COAL.getDefaultInstance(), 16,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCookedMeatTagTable()),
                            CommonConfig.getCookedMeatCount(),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new TagTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getRawMeatTagTable()),
                            CommonConfig.getRawMeatCount(),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("farmersdelight")) {
                        trades.get(journeyman).add(new LootTableForLootTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getStoneTierKnifeTable()),
                                MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                        ));
                    }
                    else {
                        trades.get(journeyman).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getCookedMeatTagTable()),
                                CommonConfig.getCookedMeatCount(),
                                MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                        ));
                    }

                    trades.get(expert).add(new ItemForLootTable(
                            Items.DRIED_KELP_BLOCK.getDefaultInstance(), 10,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    if (ModList.get().isLoaded("salt") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getSaltTagTable()),
                                CommonConfig.getSaltCount(),
                                MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                        ));
                    }
                    if (ModList.get().isLoaded("supplementaries") || ModList.get().isLoaded("turtleblockacademy")) {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getAshTagTable()),
                                CommonConfig.getAshCount(),
                                MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                        ));
                    }
                    else {
                        trades.get(expert).add(new LootTableForTagTable(
                                ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                                ResourceLocation.tryParse(CommonConfig.getCookedMeatTagTable()),
                                CommonConfig.getCookedMeatCount(),
                                MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                        ));
                    }

                    trades.get(master).add(new TagTableForLootTable(
                            VillagerTradeLootTables.TAGGED_FOX_FOOD_TABLE, 8,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(master).add(new LootTableForTagTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getCookedMeatTagTable()),
                            CommonConfig.getCookedMeatCount(),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
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
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getChainmailTierHelmetTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getChainmailTierChestplateTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getThreeEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getChainmailTierLeggingsTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));
                    trades.get(novice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getChainmailTierBootsTable()),
                            MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                    ));

                    trades.get(apprentice).add(new ItemForLootTable(
                            Items.IRON_INGOT.getDefaultInstance(), 4,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getThirtySixEmeraldCurrencyTable()),
                            Items.BELL.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getSevenEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierLeggingsTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));
                    trades.get(apprentice).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFourEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierBootsTable()),
                            MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                    ));

                    trades.get(journeyman).add(new ItemForLootTable(
                            Items.LAVA_BUCKET.getDefaultInstance(), 1,
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                            ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierHelmetTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getNineEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierChestplateTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForItem(
                            ResourceLocation.tryParse(CommonConfig.getFiveEmeraldCurrencyTable()),
                            Items.SHIELD.getDefaultInstance(), 1,
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));
                    trades.get(journeyman).add(new LootTableForLootTable(
                            ResourceLocation.tryParse(CommonConfig.getNineEmeraldCurrencyTable()),
                            ResourceLocation.tryParse(CommonConfig.getIronTierHorseArmorTable()),
                            MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                    ));

                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierLeggingsTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierBootsTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));

                    trades.get(master).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierHelmetTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentyEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                    ));
                    trades.get(expert).add(new LootTableForEnchantedTable(
                            ResourceLocation.tryParse(CommonConfig.getDiamondTierChestplateTable()),
                            ResourceLocation.tryParse(CommonConfig.getTwentySixEmeraldCurrencyTable()),
                            MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                    ));
                }
            }

            // BANKER TRADES SET
            if (event.getType() == ModVillagers.BANKER.get()) {
                trades.get(novice).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 1,
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                ));
                trades.get(novice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldCurrencyTable()),
                        Items.EMERALD.getDefaultInstance(), 1,
                        MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                ));

                trades.get(apprentice).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 16,
                        ResourceLocation.tryParse(CommonConfig.getEmeraldQuarterNoteCurrencyTable()),
                        MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldQuarterNoteCurrencyTable()),
                        Items.EMERALD.getDefaultInstance(), 16,
                        MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 32,
                        ResourceLocation.tryParse(CommonConfig.getEmeraldHalfNoteCurrencyTable()),
                        MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldHalfNoteCurrencyTable()),
                        Items.EMERALD.getDefaultInstance(), 32,
                        MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                ));

                trades.get(expert).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteCurrencyTable()),
                        Items.EMERALD.getDefaultInstance(), 64,
                        MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                ));
                trades.get(expert).add(new ItemForLootTable(
                        Items.EMERALD.getDefaultInstance(), 64,
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteCurrencyTable()),
                        MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                ));

                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldMetalsTable()),
                        Items.EMERALD.getDefaultInstance(), 1,
                        MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneEmeraldGemsTable()),
                        Items.EMERALD.getDefaultInstance(), 1,
                        MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteMetalsTable()),
                        ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1,
                        MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getEmeraldNoteGemsTable()),
                        ModItems.EMERALD_BANK_NOTE.get().getDefaultInstance(), 1,
                        MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                ));
            }

            // LEPRECHAUN TRADES SET
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                trades.get(novice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getTwoPotGoldCurrencyTable()),
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                ));
                trades.get(novice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        ResourceLocation.tryParse(CommonConfig.getTwoPotGoldCurrencyTable()),
                        MAX_USES, BASE_XP * novice, PRICE_MULTIPLIER
                ));

                trades.get(apprentice).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getTwoGoldPotGemsTable()),
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new LootTableForItem(
                        VillagerTradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS,
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 2,
                        MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                ));

                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        ResourceLocation.tryParse(CommonConfig.getFourPotGoldCurrencyTable()),
                        MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        VillagerTradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS,
                        MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        ResourceLocation.tryParse(CommonConfig.getFourGoldPotGemsTable()),
                        MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                ));
                trades.get(apprentice).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 4,
                        ResourceLocation.tryParse(CommonConfig.getFourPotGoldCurrencyTable()),
                        MAX_USES, BASE_XP * apprentice, PRICE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        VillagerTradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_ITEMS,
                        MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        ResourceLocation.tryParse(CommonConfig.getThirtyPotGoldCurrencyTable()),
                        MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 30,
                        ResourceLocation.tryParse(CommonConfig.getThirtyGoldPotGemsTable()),
                        MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                ));

                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        ResourceLocation.tryParse(CommonConfig.getSixtyPotGoldCurrencyTable()),
                        MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        VillagerTradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_ITEMS,
                        MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                ));
                trades.get(journeyman).add(new ItemForLootTable(
                        ModBlocks.POT_OF_GOLD.get().asItem().getDefaultInstance(), 60,
                        ResourceLocation.tryParse(CommonConfig.getSixtyGoldPotGemsTable()),
                        MAX_USES, BASE_XP * journeyman, PRICE_MULTIPLIER
                ));

                trades.get(expert).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getOneLuckyCoinCurrencyTable()),
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                ));
                trades.get(expert).add(new ItemForLootTable(
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        ResourceLocation.tryParse(CommonConfig.getOneLuckyCoinCurrencyTable()),
                        MAX_USES, BASE_XP * expert, PRICE_MULTIPLIER
                ));

                trades.get(master).add(new LootTableForItem(
                        ResourceLocation.tryParse(CommonConfig.getLuckyCoinGemsTable()),
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 1,
                        MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        VillagerTradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS,
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 3,
                        MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                ));
                trades.get(master).add(new LootTableForItem(
                        VillagerTradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS,
                        ModItems.LUCKY_COIN.get().getDefaultInstance(), 27,
                        MAX_USES, BASE_XP * master, PRICE_MULTIPLIER
                ));
            }
        }
    }
}