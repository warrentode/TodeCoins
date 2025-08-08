package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom;

import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types.LootTableForTippedArrow;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public record LootTableForTippedArrowFactory(ResourceLocation requestTable, int requestedArrowCount, int maxUses, int experience, float multiplier) implements SerializableTradeOfferFactory {
    public static final Codec<LootTableForTippedArrowFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(LootTableForTippedArrowFactory::requestTable),
            Codec.INT.fieldOf(TradeOfferConstants.arrowCount).forGetter(LootTableForTippedArrowFactory::requestedArrowCount),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.RARE_MAX_TRADES).forGetter(LootTableForTippedArrowFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(LootTableForTippedArrowFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.RARE_TRADE_MULTIPLIER).forGetter(LootTableForTippedArrowFactory::multiplier)
    ).apply(instance, LootTableForTippedArrowFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new LootTableForTippedArrow(requestTable, requestedArrowCount, maxUses, experience, multiplier).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.LOOT_TABLE_FOR_TIPPED_ARROW;
    }
}