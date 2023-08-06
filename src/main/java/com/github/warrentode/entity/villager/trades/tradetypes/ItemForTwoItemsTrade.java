package com.github.warrentode.entity.villager.trades.tradetypes;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemForTwoItemsTrade implements VillagerTrades.ItemListing {
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
    private final ItemStack buyingItemA;
    private final int buyingItemCountA;
    private final ItemStack buyingItemB;
    private final int buyingItemCountB;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public ItemForTwoItemsTrade(ItemStack sellItem, int sellItemCount, ItemStack buyingItemA, int buyingItemCountA, ItemStack buyingItemB, int buyingItemCountB, int maxUses, int xpValue, float priceMultiplier) {
        this.sellItem = sellItem;
        this.sellItemCount = sellItemCount;
        this.buyingItemA = buyingItemA;
        this.buyingItemCountA = buyingItemCountA;
        this.buyingItemB = buyingItemB;
        this.buyingItemCountB = buyingItemCountB;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack sellStack = new ItemStack(this.sellItem.getItem(), this.sellItemCount);
        ItemStack buyStackA = new ItemStack(this.buyingItemA.getItem(), this.buyingItemCountA);
        ItemStack buyStackB = new ItemStack(this.buyingItemB.getItem(), this.buyingItemCountB);
        return new MerchantOffer(buyStackA, buyStackB, sellStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}