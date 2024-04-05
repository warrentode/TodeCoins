package com.github.warrentode.todecoins.entity.villager.tradetypes;

import com.google.common.collect.Lists;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.*;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DyedArmorForItemsTrade implements VillagerTrades.ItemListing {
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

    private final ItemStack offeredItem;
    private final int offeredItemCount;
    private final ItemStack requestedItem;
    private final int requestedItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public DyedArmorForItemsTrade(ItemStack offeredItem, int offeredItemCount, ItemStack requestedItem, int requestedItemCount, int maxUses, int xpValue, float priceMultiplier) {
        this.offeredItem = offeredItem;
        this.offeredItemCount = offeredItemCount;
        this.requestedItem = requestedItem;
        this.requestedItemCount = requestedItemCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack offeredStack = new ItemStack(this.offeredItem.getItem(), this.offeredItemCount);
        ItemStack requestedStack = new ItemStack(this.requestedItem.getItem(), this.requestedItemCount);
        if (this.offeredItem.getItem() instanceof DyeableArmorItem) {
            List<DyeItem> list = Lists.newArrayList();
            list.add(getRandomDye(source));
            if (source.nextFloat() > 0.7F) {
                list.add(getRandomDye(source));
            }

            if (source.nextFloat() > 0.8F) {
                list.add(getRandomDye(source));
            }

            offeredStack = DyeableLeatherItem.dyeArmor(offeredStack, list);
        }

        return new MerchantOffer(offeredStack, requestedStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }

    private static DyeItem getRandomDye(RandomSource pRandom) {
        return DyeItem.byColor(DyeColor.byId(pRandom.nextInt(16)));
    }
}