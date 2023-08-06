package com.github.warrentode.entity.villager.trades.tradetypes;

import com.google.common.collect.ImmutableSet;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemForOneSetTrade implements VillagerTrades.ItemListing {
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

    private final ImmutableSet<ItemLike> buyItems;
    private final int buyItemsCount;
    private final ItemStack sellItem;
    private final int sellItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public ItemForOneSetTrade(ItemStack sellItem, int sellItemCount, ImmutableSet<ItemLike> buyItems, int buyItemsCount, int maxUses, int xpValue) {
        this(sellItem, sellItemCount, buyItems, buyItemsCount, maxUses, xpValue, xpValue);
    }

    public ItemForOneSetTrade(ItemStack sellItem, int sellItemCount, ImmutableSet<ItemLike> buyItems, int buyItemsCount, int maxUses, int xpValue, float priceMultiplier) {
        this.sellItem = sellItem;
        this.sellItemCount = sellItemCount;
        this.buyItems = buyItems;
        this.buyItemsCount = buyItemsCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack sellStack = new ItemStack(this.sellItem.getItem(), this.sellItemCount);
        ItemStack buySet = new ItemStack(this.buyItems.asList().get(source.nextInt(buyItems.size() - 1)).asItem(), this.buyItemsCount);
        return new MerchantOffer(buySet, sellStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}