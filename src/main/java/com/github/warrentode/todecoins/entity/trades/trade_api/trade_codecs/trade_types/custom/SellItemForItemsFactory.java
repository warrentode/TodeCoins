package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom;

import com.github.warrentode.todecoins.entity.trades.trade_api.CodecHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public record SellItemForItemsFactory(ItemStack buy1, ItemStack buy2, ItemStack sell, int maxUses, int experience, float multiplier) implements SerializableTradeOfferFactory {
    public static final Codec<SellItemForItemsFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CodecHelper.SIMPLE_ITEM_STACK_CODEC.fieldOf(TradeOfferConstants.requestStack).forGetter(factory -> factory.buy1),
            CodecHelper.SIMPLE_ITEM_STACK_CODEC.optionalFieldOf(TradeOfferConstants.secondaryRequestStack, ItemStack.EMPTY).forGetter(factory -> factory.buy2),
            CodecHelper.SIMPLE_ITEM_STACK_CODEC.fieldOf(TradeOfferConstants.offerStack).forGetter(factory -> factory.sell),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> factory.maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> factory.experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.COMMON_TRADE_MULTIPLIER).forGetter(factory -> factory.multiplier)
    ).apply(instance, SellItemForItemsFactory::new));

    @Override
    public @NotNull MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new MerchantOffer(this.buy1.copy(), this.buy2.copy(), this.sell.copy(), this.maxUses, this.experience, this.multiplier);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.SELL_ITEM_FOR_ITEMS;
    }
}