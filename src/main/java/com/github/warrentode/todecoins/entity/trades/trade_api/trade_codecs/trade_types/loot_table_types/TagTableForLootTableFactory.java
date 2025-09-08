package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.loot_table_types;

import com.github.warrentode.todecoins.entity.trades.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.TagTableForLootTable;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public record TagTableForLootTableFactory(ResourceLocation requestedTagTable, int requestedTagCount, ResourceLocation offeredTable, int maxUses, int xpValue, float priceMultiplier) implements SerializableTradeOfferFactory {
    public static final Codec<TagTableForLootTableFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(factory -> factory.requestedTagTable),
            Codec.INT.optionalFieldOf(TradeOfferConstants.requestStackCount, 1).forGetter(factory -> factory.requestedTagCount),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.offerTable).forGetter(factory -> factory.offeredTable),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> factory.maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> factory.xpValue),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.COMMON_TRADE_MULTIPLIER).forGetter(factory -> factory.priceMultiplier)
    ).apply(instance, TagTableForLootTableFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new TagTableForLootTable(requestedTagTable, requestedTagCount, offeredTable, maxUses, xpValue, priceMultiplier).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.TAG_TABLE_FOR_LOOT_TABLE;
    }
}