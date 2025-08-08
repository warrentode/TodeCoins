package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types;

import org.jetbrains.annotations.ApiStatus;

import java.util.function.Supplier;

@ApiStatus.Internal
public interface TradeOfferFactoryTypeHolder {
    Supplier<TradeOfferFactoryType<?>> getType();
}