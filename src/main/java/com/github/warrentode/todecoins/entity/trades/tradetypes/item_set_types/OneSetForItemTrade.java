package com.github.warrentode.todecoins.entity.trades.tradetypes.item_set_types;

import com.google.common.collect.ImmutableSet;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OneSetForItemTrade implements VillagerTrades.ItemListing {
    private final ImmutableSet<ItemLike> offerItems;
    private final int offerItemsCount;
    private final ItemStack requestItem;
    private final int requestItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public OneSetForItemTrade(ImmutableSet<ItemLike> offerItem, int offerItemCount, ItemStack requestItems, int requestItemsCount, int maxUses, int xpValue) {
        this(offerItem, offerItemCount, requestItems, requestItemsCount, maxUses, xpValue, xpValue);
    }

    public OneSetForItemTrade(ImmutableSet<ItemLike> offerItems, int offerItemsCount, ItemStack requestItem, int requestItemCount, int maxUses, int xpValue, float priceMultiplier) {
        this.offerItems = offerItems;
        this.offerItemsCount = offerItemsCount;
        this.requestItem = requestItem;
        this.requestItemCount = requestItemCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack offerSet = new ItemStack(this.offerItems.asList().get(source.nextInt(offerItems.size() - 1)).asItem(), this.offerItemsCount);
        ItemStack requestStack = new ItemStack(this.requestItem.getItem(), this.requestItemCount);
        return new MerchantOffer(requestStack, offerSet, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}