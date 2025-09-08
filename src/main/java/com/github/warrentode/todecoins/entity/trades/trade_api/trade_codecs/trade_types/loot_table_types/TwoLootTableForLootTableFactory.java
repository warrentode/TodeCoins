package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.loot_table_types;

import com.github.warrentode.todecoins.entity.trades.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.TwoLootTableForLootTable;
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

public record TwoLootTableForLootTableFactory(ResourceLocation offerTable, ResourceLocation requestTable, ResourceLocation secondaryRequestTable, int maxUses, int experience, float multiplier) implements SerializableTradeOfferFactory {
    public static final Codec<TwoLootTableForLootTableFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.offerTable).forGetter(TwoLootTableForLootTableFactory::offerTable),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(TwoLootTableForLootTableFactory::requestTable),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.secondaryRequestTable).forGetter(TwoLootTableForLootTableFactory::secondaryRequestTable),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(TwoLootTableForLootTableFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(TwoLootTableForLootTableFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.COMMON_TRADE_MULTIPLIER).forGetter(TwoLootTableForLootTableFactory::multiplier)
    ).apply(instance, TwoLootTableForLootTableFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new TwoLootTableForLootTable(offerTable, requestTable, secondaryRequestTable, maxUses, experience, multiplier).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.LOOT_TABLE_FOR_TWO_LOOT_TABLE;
    }
}