package com.github.warrentode.todecoins.entity.trades.tradetypes;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// MIT License Copyright (c) 2023 Warren Tode

public class ItemForItemTrade implements VillagerTrades.ItemListing {
    private final ItemStack requestItem;
    private final int requestItemCount;
    private final ItemStack offerItem;
    private final int offerItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public ItemForItemTrade(ItemStack offerItem, int offerItemCount, ItemStack requestItem, int requestItemCount, int maxUses, int xpValue, float priceMultiplier) {
        this.offerItem = offerItem;
        this.offerItemCount = offerItemCount;
        this.requestItem = requestItem;
        this.requestItemCount = requestItemCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack offerStack = new ItemStack(this.offerItem.getItem(), this.offerItemCount);
        ItemStack requestStack = new ItemStack(this.requestItem.getItem(), this.requestItemCount);
        return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}