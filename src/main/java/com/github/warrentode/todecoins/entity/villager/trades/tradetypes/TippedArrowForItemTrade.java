package com.github.warrentode.todecoins.entity.villager.trades.tradetypes;

import net.minecraft.core.Registry;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TippedArrowForItemTrade implements VillagerTrades.ItemListing {
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

    private final ItemStack tippedArrow;
    private final int tippedArrowCount;
    private final ItemStack requestedItem;
    private final int requestedItemCount;
    private final ItemStack requestedArrow;
    private final int requestedArrowCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public TippedArrowForItemTrade(ItemStack requestedItem, int requestedItemCount, int requestedArrowCount, int maxUses, int xpValue, float priceMultiplier) {
        this.requestedItem = requestedItem;
        this.requestedItemCount = requestedItemCount;
        this.requestedArrow = Items.ARROW.asItem().getDefaultInstance();
        this.requestedArrowCount = requestedArrowCount;
        this.tippedArrow = new ItemStack(Items.TIPPED_ARROW.asItem().getDefaultInstance().getItem());
        this.tippedArrowCount = requestedArrowCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @SuppressWarnings("deprecation")
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack requestedStack = new ItemStack(this.requestedItem.getItem(), this.requestedItemCount);
        List<Potion> list = Registry.POTION.stream().filter((potion) ->
                !potion.getEffects().isEmpty() && PotionBrewing.isBrewablePotion(potion)).toList();
        Potion potion = list.get(source.nextInt(list.size()));
        ItemStack offeredTippedArrow = PotionUtils.setPotion(new ItemStack(this.tippedArrow.getItem(), this.tippedArrowCount), potion);
        return new MerchantOffer(requestedStack, new ItemStack(this.requestedArrow.getItem(), this.requestedArrowCount), offeredTippedArrow, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}