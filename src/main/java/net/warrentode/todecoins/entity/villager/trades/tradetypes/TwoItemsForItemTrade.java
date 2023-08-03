package net.warrentode.todecoins.entity.villager.trades.tradetypes;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TwoItemsForItemTrade implements VillagerTrades.ItemListing {
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

    private final ItemStack sellItemA;
    private final int sellItemCountA;
    private final ItemStack sellItemB;
    private final int sellItemCountB;
    private final ItemStack buyItem;
    private final int buyItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public TwoItemsForItemTrade(ItemStack sellItemA, int sellItemCountA, ItemStack sellItemB, int sellItemCountB, ItemStack buyItem, int buyItemCount, int maxUses, int xpValue, float priceMultiplier) {
        this.sellItemA = sellItemA;
        this.sellItemCountA = sellItemCountA;
        this.sellItemB = sellItemB;
        this.sellItemCountB = sellItemCountB;
        this.buyItem = buyItem;
        this.buyItemCount = buyItemCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack sellStackA = new ItemStack(this.sellItemA.getItem(), this.sellItemCountA);
        ItemStack sellStackB = new ItemStack(this.sellItemB.getItem(), this.sellItemCountB);
        ItemStack buyStack = new ItemStack(this.buyItem.getItem(), this.buyItemCount);
        return new MerchantOffer(buyStack, sellStackA, sellStackB, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}