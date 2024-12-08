package com.github.warrentode.todecoins.entity.villager.tradetypes;

import net.minecraft.core.Registry;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Map;

public class VillagerTypeLootTableTrade implements VillagerTrades.ItemListing {
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

    private final Map<VillagerType, Item> offeredItemType;
    private final int offeredItemTypeCount;
    private final Map<VillagerType, Item> requestedItemType;
    private final int requestedItemTypeCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public VillagerTypeLootTableTrade(Map<VillagerType, Item> offeredItemType, int offeredItemTypeCount, Map<VillagerType, Item> requestedItemType, int requestedItemTypeCount, int maxUses, int xpValue, float priceMultiplier) {
        Registry.VILLAGER_TYPE.stream().filter((containsKey) -> !offeredItemType.containsKey(containsKey)).findAny().ifPresent((villagerType) -> {
            throw new IllegalStateException("Missing trade for villager type: " + Registry.VILLAGER_TYPE.getKey(villagerType));
        });
        this.offeredItemType = offeredItemType;
        this.offeredItemTypeCount = offeredItemTypeCount;
        this.requestedItemType = requestedItemType;
        this.requestedItemTypeCount = requestedItemTypeCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        if (trader instanceof VillagerDataHolder) {
            ItemStack offerSet = new ItemStack(this.offeredItemType.get(((VillagerDataHolder) trader).getVillagerData().getType()), this.offeredItemTypeCount);
            ItemStack requestSet = new ItemStack(this.requestedItemType.get(((VillagerDataHolder) trader).getVillagerData().getType()), this.requestedItemTypeCount);
            return new MerchantOffer(offerSet, requestSet, this.maxUses, this.xpValue, this.priceMultiplier);
        }
        else {
            return null;
        }
    }
}