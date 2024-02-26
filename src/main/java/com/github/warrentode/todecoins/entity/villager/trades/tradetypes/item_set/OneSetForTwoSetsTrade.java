package com.github.warrentode.todecoins.entity.villager.trades.tradetypes.item_set;

import com.google.common.collect.ImmutableSet;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OneSetForTwoSetsTrade implements VillagerTrades.ItemListing {
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

    private final ImmutableSet<ItemLike> sellItems;
    private final int sellItemsCount;
    private final ImmutableSet<ItemLike> buyItemsA;
    private final int buyItemsCountA;
    private final ImmutableSet<ItemLike> buyItemsB;
    private final int buyItemsCountB;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public OneSetForTwoSetsTrade(ImmutableSet<ItemLike> sellItems, int sellingItemCount, ImmutableSet<ItemLike> buyItemsA, int buyItemsCountA, ImmutableSet<ItemLike> buyItemsB, int buyItemsCountB, int maxUses, int xpValue) {
        this(sellItems, sellingItemCount, buyItemsA, buyItemsCountA, buyItemsB, buyItemsCountB, maxUses, xpValue, xpValue);
    }

    public OneSetForTwoSetsTrade(ImmutableSet<ItemLike> sellItems, int sellingItemCount, ImmutableSet<ItemLike> buyItemsA, int buyItemsCountA, ImmutableSet<ItemLike> buyItemsB, int buyItemsCountB, int maxUses, int xpValue, float priceMultiplier) {
        this.sellItems = sellItems;
        this.sellItemsCount = sellingItemCount;
        this.buyItemsA = buyItemsA;
        this.buyItemsCountA = buyItemsCountA;
        this.buyItemsB = buyItemsB;
        this.buyItemsCountB = buyItemsCountB;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack sellSet = new ItemStack(this.sellItems.asList().get(source.nextInt(sellItems.size() - 1)).asItem(), this.sellItemsCount);
        ItemStack buySetA = new ItemStack(this.buyItemsA.asList().get(source.nextInt(buyItemsA.size() - 1)).asItem(), this.buyItemsCountA);
        ItemStack buySetB = new ItemStack(this.buyItemsB.asList().get(source.nextInt(buyItemsB.size() - 1)).asItem(), this.buyItemsCountB);
        return new MerchantOffer(buySetA, buySetB, sellSet, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}