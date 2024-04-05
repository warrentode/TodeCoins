package com.github.warrentode.todecoins.entity.villager.tradetypes;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class SuspiciousStewForItemsTrade implements VillagerTrades.ItemListing {
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
    final MobEffect effect;
    final int duration;
    private final ItemStack requestedItem;
    private final int requestedItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public SuspiciousStewForItemsTrade(MobEffect effect, int duration, ItemStack requestedItem, int requestedItemCount, int maxUses, int xpValue, float priceMultiplier) {
        this.effect = effect;
        this.duration = duration;
        this.requestedItem = requestedItem;
        this.requestedItemCount = requestedItemCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack offeredBowl = new ItemStack(Items.SUSPICIOUS_STEW, 1);
        ItemStack requestedStack = new ItemStack(this.requestedItem.getItem(), this.requestedItemCount);
        saveMobEffect(offeredBowl, this.effect, this.duration);
        return new MerchantOffer(requestedStack, offeredBowl, this.maxUses, this.xpValue, this.priceMultiplier);
    }

    public void saveMobEffect(ItemStack bowlStack, MobEffect mobEffect, int effectDuration) {
        CompoundTag compoundTag = bowlStack.getOrCreateTag();
        ListTag listTag = compoundTag.getList("Effects", 9);
        CompoundTag compoundTag1 = new CompoundTag();
        compoundTag1.putInt("EffectId", MobEffect.getId(mobEffect));
        net.minecraftforge.common.ForgeHooks.saveMobEffect(compoundTag1, "forge:effect_id", mobEffect);
        compoundTag1.putInt("EffectDuration", effectDuration);
        listTag.add(compoundTag1);
        compoundTag.put("Effects", listTag);
    }
}