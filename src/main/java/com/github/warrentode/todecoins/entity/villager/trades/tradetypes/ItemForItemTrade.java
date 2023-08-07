package com.github.warrentode.todecoins.entity.villager.trades.tradetypes;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// MIT License Copyright (c) 2023 Warren Tode

public class ItemForItemTrade implements VillagerTrades.ItemListing {
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

    private final ItemStack buyItem;
    private final int buyItemCount;
    private final ItemStack sellItem;
    private final int sellItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public ItemForItemTrade(ItemStack sellItem, int sellItemCount, ItemStack buyItem, int buyItemCount, int maxUses, int xpValue, float priceMultiplier) {
        this.sellItem = sellItem;
        this.sellItemCount = sellItemCount;
        this.buyItem = buyItem;
        this.buyItemCount = buyItemCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack sellStack = new ItemStack(this.sellItem.getItem(), this.sellItemCount);
        ItemStack buyStack = new ItemStack(this.buyItem.getItem(), this.buyItemCount);
        return new MerchantOffer(buyStack, sellStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}