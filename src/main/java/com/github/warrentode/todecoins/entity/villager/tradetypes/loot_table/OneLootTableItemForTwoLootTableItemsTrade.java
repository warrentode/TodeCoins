package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OneLootTableItemForTwoLootTableItemsTrade implements VillagerTrades.ItemListing {
    public static final int DEFAULT_SUPPLY = 12;
    public static final int COMMON_ITEMS_SUPPLY = 16;
    public static final int UNCOMMON_ITEMS_SUPPLY = 3;
    public static final int XP_LEVEL_1_SELL = 1;
    public static final int XP_LEVEL_1_BUY = 2;
    public static final int XP_LEVEL_2_SELL = 5;
    public static final int XP_LEVEL_2_BUY = 10;
    public static final int XP_LEVEL_3_SELL = 10;
    public static final int XP_LEVEL_3_BUY = 20;
    public static final int XP_LEVEL_4_SELL = 15;
    public static final int XP_LEVEL_4_BUY = 30;
    public static final int XP_LEVEL_5_TRADE = 30;
    public static final float LOW_TIER_PRICE_MULTIPLIER = 0.05F;
    public static final float HIGH_TIER_PRICE_MULTIPLIER = 0.2F;

    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ResourceLocation sellingLootTable;
    private final ResourceLocation currencyLootTable1;
    private final ResourceLocation currencyLootTable2;

    public OneLootTableItemForTwoLootTableItemsTrade(ResourceLocation sellingLootTable,
                                                     ResourceLocation currencyLootTable1, ResourceLocation currencyLootTable2,
                                                     int maxUses, int xpValue, float priceMultiplier) {
        this.sellingLootTable = sellingLootTable;
        this.currencyLootTable1 = currencyLootTable1;
        this.currencyLootTable2 = currencyLootTable2;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        if (!(trader.level instanceof ServerLevel)) {
            return null;
        }
        else {
            MinecraftServer minecraftServer = trader.level.getServer();
            LootTable sellingTable = minecraftServer.getLootTables().get(sellingLootTable);
            LootTable currencyTable1 = minecraftServer.getLootTables().get(currencyLootTable1);
            LootTable currencyTable2 = minecraftServer.getLootTables().get(currencyLootTable2);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> sellGoods = sellingTable.getRandomItems(lootContext);
            List<ItemStack> currency1 = currencyTable1.getRandomItems(lootContext);
            List<ItemStack> currency2 = currencyTable2.getRandomItems(lootContext);

            ItemStack sellStack = new ItemStack(sellGoods.get(source.nextInt(sellGoods.size())).getItem());
            ItemStack requestStack1 = new ItemStack(currency1.get(source.nextInt(currency1.size())).getItem());
            ItemStack requestStack2 = new ItemStack(currency2.get(source.nextInt(currency1.size())).getItem());
            return new MerchantOffer(requestStack1, requestStack2, sellStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}