package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom;

import com.github.warrentode.todecoins.entity.trades.trade_api.CodecHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types.ItemForLootTable;
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

public record ItemForLootTableFactory(ItemStack requestItem, int requestItemCount, ResourceLocation offerLootTable, int maxUses, int experience, float priceMultiplier) implements SerializableTradeOfferFactory {
    public static final Codec<ItemForLootTableFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CodecHelper.SIMPLE_ITEM_STACK_CODEC.fieldOf(TradeOfferConstants.requestStack).forGetter(ItemForLootTableFactory::requestItem),
            Codec.INT.optionalFieldOf(TradeOfferConstants.requestStackCount, 1).forGetter(ItemForLootTableFactory::requestItemCount),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.offerTable).forGetter(ItemForLootTableFactory::offerLootTable),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(ItemForLootTableFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(ItemForLootTableFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.COMMON_TRADE_MULTIPLIER).forGetter(ItemForLootTableFactory::priceMultiplier)
    ).apply(instance, ItemForLootTableFactory::new));

    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new ItemForLootTable(requestItem, requestItemCount, offerLootTable, maxUses, experience, priceMultiplier).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.ITEM_FOR_LOOT_TABLE;
    }
}