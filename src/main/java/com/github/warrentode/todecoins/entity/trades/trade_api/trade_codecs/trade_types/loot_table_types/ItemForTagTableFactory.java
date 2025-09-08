package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.loot_table_types;

import com.github.warrentode.todecoins.entity.trades.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.ItemForTagTable;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
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

public record ItemForTagTableFactory(ItemStack requestedItem, int requestedCount, ResourceLocation offeredTagTable, int offeredTagCount, int maxUses, int experience, float multiplier) implements SerializableTradeOfferFactory {
    public static final Codec<ItemForTagTableFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ItemStack.CODEC.fieldOf(TradeOfferConstants.requestStack).forGetter(ItemForTagTableFactory::requestedItem),
            Codec.INT.fieldOf(TradeOfferConstants.requestStackCount).forGetter(ItemForTagTableFactory::requestedCount),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.offerTable).forGetter(ItemForTagTableFactory::offeredTagTable),
            Codec.INT.fieldOf(TradeOfferConstants.offerStackCount).forGetter(ItemForTagTableFactory::offeredTagCount),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(ItemForTagTableFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(ItemForTagTableFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.COMMON_TRADE_MULTIPLIER).forGetter(ItemForTagTableFactory::multiplier)
    ).apply(instance, ItemForTagTableFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new ItemForTagTable(requestedItem, requestedCount, offeredTagTable, offeredTagCount, maxUses, experience, multiplier)
                .getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.ITEM_FOR_TAG_TABLE;
    }
}