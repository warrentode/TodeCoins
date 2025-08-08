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

public class OneSetForOneSetTrade implements VillagerTrades.ItemListing {
    private final ImmutableSet<ItemLike> offerItems;
    private final int offerItemsCount;
    private final ImmutableSet<ItemLike> requestItems;
    private final int requestItemsCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public OneSetForOneSetTrade(ImmutableSet<ItemLike> offerItems, int offeringItemCount, ImmutableSet<ItemLike> requestItems, int requestItemsCount, int maxUses, int xpValue) {
        this(offerItems, offeringItemCount, requestItems, requestItemsCount, maxUses, xpValue, xpValue);
    }

    public OneSetForOneSetTrade(ImmutableSet<ItemLike> offerItems, int offeringItemCount, ImmutableSet<ItemLike> requestItems, int requestItemsCount, int maxUses, int xpValue, float priceMultiplier) {
        this.offerItems = offerItems;
        this.offerItemsCount = offeringItemCount;
        this.requestItems = requestItems;
        this.requestItemsCount = requestItemsCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack offerSet = new ItemStack(this.offerItems.asList().get(source.nextInt(offerItems.size() - 1)).asItem(), this.offerItemsCount);
        ItemStack requestSet = new ItemStack(this.requestItems.asList().get(source.nextInt(requestItems.size() - 1)).asItem(), this.requestItemsCount);
        return new MerchantOffer(requestSet, offerSet, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}