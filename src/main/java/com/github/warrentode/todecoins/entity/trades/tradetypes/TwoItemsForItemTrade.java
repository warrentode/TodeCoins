package com.github.warrentode.todecoins.entity.trades.tradetypes;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TwoItemsForItemTrade implements VillagerTrades.ItemListing {
    private final ItemStack offerItem;
    private final int offerItemCount;
    private final ItemStack requestItemA;
    private final int requestItemCountA;
    private final ItemStack requestItemB;
    private final int requestItemCountB;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public TwoItemsForItemTrade(ItemStack offerItem, int offerItemCount, ItemStack requestItemA, int requestItemCountA, ItemStack requestItemB, int requestItemCountB, int maxUses, int xpValue, float priceMultiplier) {
        this.offerItem = offerItem;
        this.offerItemCount = offerItemCount;
        this.requestItemA = requestItemA;
        this.requestItemCountA = requestItemCountA;
        this.requestItemB = requestItemB;
        this.requestItemCountB = requestItemCountB;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack offerStack = new ItemStack(this.offerItem.getItem(), this.offerItemCount);
        ItemStack requestStackA = new ItemStack(this.requestItemA.getItem(), this.requestItemCountA);
        ItemStack requestStackB = new ItemStack(this.requestItemB.getItem(), this.requestItemCountB);
        return new MerchantOffer(requestStackA, requestStackB, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}