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

public class OneSetForTwoSetsTrade implements VillagerTrades.ItemListing {
    private final ImmutableSet<ItemLike> offerItems;
    private final int offerItemsCount;
    private final ImmutableSet<ItemLike> requestItemsA;
    private final int requestItemsCountA;
    private final ImmutableSet<ItemLike> requestItemsB;
    private final int requestItemsCountB;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public OneSetForTwoSetsTrade(ImmutableSet<ItemLike> offerItems, int offeringItemCount, ImmutableSet<ItemLike> requestItemsA, int requestItemsCountA, ImmutableSet<ItemLike> requestItemsB, int requestItemsCountB, int maxUses, int xpValue) {
        this(offerItems, offeringItemCount, requestItemsA, requestItemsCountA, requestItemsB, requestItemsCountB, maxUses, xpValue, xpValue);
    }

    public OneSetForTwoSetsTrade(ImmutableSet<ItemLike> offerItems, int offeringItemCount, ImmutableSet<ItemLike> requestItemsA, int requestItemsCountA, ImmutableSet<ItemLike> requestItemsB, int requestItemsCountB, int maxUses, int xpValue, float priceMultiplier) {
        this.offerItems = offerItems;
        this.offerItemsCount = offeringItemCount;
        this.requestItemsA = requestItemsA;
        this.requestItemsCountA = requestItemsCountA;
        this.requestItemsB = requestItemsB;
        this.requestItemsCountB = requestItemsCountB;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack offerSet = new ItemStack(this.offerItems.asList().get(source.nextInt(offerItems.size() - 1)).asItem(), this.offerItemsCount);
        ItemStack requestSetA = new ItemStack(this.requestItemsA.asList().get(source.nextInt(requestItemsA.size() - 1)).asItem(), this.requestItemsCountA);
        ItemStack requestSetB = new ItemStack(this.requestItemsB.asList().get(source.nextInt(requestItemsB.size() - 1)).asItem(), this.requestItemsCountB);
        return new MerchantOffer(requestSetA, requestSetB, offerSet, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}