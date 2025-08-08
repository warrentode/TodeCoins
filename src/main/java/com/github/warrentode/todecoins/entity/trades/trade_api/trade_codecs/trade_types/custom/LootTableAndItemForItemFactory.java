package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom;

import com.github.warrentode.todecoins.entity.trades.trade_api.CodecHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types.LootTableAndItemForItem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public record LootTableAndItemForItemFactory(ResourceLocation requestLootTable, ItemStack requestItem, int requestCount, ItemStack offerItem, int offerCount, int maxUses, int experience, float priceMultiplier) implements SerializableTradeOfferFactory {
    public static final Codec<LootTableAndItemForItemFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(LootTableAndItemForItemFactory::requestLootTable),
            CodecHelper.SIMPLE_ITEM_STACK_CODEC.fieldOf(TradeOfferConstants.secondaryRequestStack).forGetter(LootTableAndItemForItemFactory::requestItem),
            Codec.INT.optionalFieldOf(TradeOfferConstants.secondaryRequestStackCount, 1).forGetter(LootTableAndItemForItemFactory::requestCount),
            CodecHelper.SIMPLE_ITEM_STACK_CODEC.fieldOf(TradeOfferConstants.offerStack).forGetter(LootTableAndItemForItemFactory::offerItem),
            Codec.INT.optionalFieldOf(TradeOfferConstants.offerStackCount, 1).forGetter(LootTableAndItemForItemFactory::offerCount),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(LootTableAndItemForItemFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(LootTableAndItemForItemFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.COMMON_TRADE_MULTIPLIER).forGetter(LootTableAndItemForItemFactory::priceMultiplier)
    ).apply(instance, LootTableAndItemForItemFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new LootTableAndItemForItem(requestLootTable, requestItem, requestCount, offerItem, offerCount, maxUses, experience, priceMultiplier).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.LOOT_TABLE_AND_ITEM_FOR_ITEM;
    }
}