package com.github.warrentode.todecoins.entity.villager.tradetypes;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// MIT License Copyright (c) 2023 Warren Tode

public class EnchantedItemForItemTrade implements VillagerTrades.ItemListing {
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

    private final ItemStack sellItem;
    private final int sellItemCount;
    private final ItemStack buyingItem;
    private final int buyingItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public EnchantedItemForItemTrade(ItemStack sellItem, int sellItemCount, ItemStack buyingItem, int buyingItemCount, int maxUses, int xpValue, float priceMultiplier) {
        this.sellItem = sellItem;
        this.sellItemCount = sellItemCount;
        this.buyingItem = buyingItem;
        this.buyingItemCount = buyingItemCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        int i = 5 + source.nextInt(15);
        int j = Math.min(this.buyingItemCount + i, 64);
        ItemStack buyStack = new ItemStack(this.buyingItem.getItem(), j);
        ItemStack itemStack = EnchantmentHelper.enchantItem(source, new ItemStack(this.sellItem.getItem()), i, false);
        ItemStack sellStack = new ItemStack(itemStack.getItem(), this.sellItemCount);
        return new MerchantOffer(sellStack, buyStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}