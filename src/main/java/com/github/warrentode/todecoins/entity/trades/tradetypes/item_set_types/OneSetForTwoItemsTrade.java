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

public class OneSetForTwoItemsTrade implements VillagerTrades.ItemListing {
    private final ImmutableSet<ItemLike> offerItems;
    private final int offerItemsCount;
    private final ItemStack requestItemA;
    private final int requestItemCountA;
    private final ItemStack requestItemB;
    private final int requestItemCountB;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public OneSetForTwoItemsTrade(ImmutableSet<ItemLike> offerItems, int offerItemsCount, ItemStack requestItemA, int requestItemCountA, ItemStack requestItemB, int requestItemCountB, int maxUses, int xpValue) {
        this(offerItems, offerItemsCount, requestItemA, requestItemCountA, requestItemB, requestItemCountB, maxUses, xpValue, xpValue);
    }

    public OneSetForTwoItemsTrade(ImmutableSet<ItemLike> offerItems, int offerItemsCount, ItemStack requestItemA, int requestItemCountA, ItemStack requestItemB, int requestItemCountB, int maxUses, int xpValue, float priceMultiplier) {
        this.offerItems = offerItems;
        this.offerItemsCount = offerItemsCount;
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
        ItemStack offerSet = new ItemStack(this.offerItems.asList().get(source.nextInt(offerItems.size() - 1)).asItem(), this.offerItemsCount);
        ItemStack requestStackA = new ItemStack(this.requestItemA.getItem(), this.requestItemCountA);
        ItemStack requestStackB = new ItemStack(this.requestItemB.getItem(), this.requestItemCountB);
        return new MerchantOffer(requestStackA, requestStackB, offerSet, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}