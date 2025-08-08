package com.github.warrentode.todecoins.entity.trades.tradetypes;

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
    private final ItemStack offerItem;
    private final int offerItemCount;
    private final ItemStack requestItem;
    private final int requestItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public EnchantedItemForItemTrade(ItemStack offerItem, int offerItemCount, ItemStack requestItem, int requestItemCount, int maxUses, int xpValue, float priceMultiplier) {
        this.offerItem = offerItem;
        this.offerItemCount = offerItemCount;
        this.requestItem = requestItem;
        this.requestItemCount = requestItemCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        int i = 5 + source.nextInt(15);
        int j = Math.min(this.requestItemCount + i, 64);
        ItemStack requestStack = new ItemStack(this.requestItem.getItem(), j);
        ItemStack itemStack = EnchantmentHelper.enchantItem(source, new ItemStack(this.offerItem.getItem()), i, false);
        ItemStack offerStack = new ItemStack(itemStack.getItem(), this.offerItemCount);
        return new MerchantOffer(offerStack, requestStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}