package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.loot_table_types;

import com.github.warrentode.todecoins.entity.trades.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.TwoLootTableForEnchantedItem;
import com.github.warrentode.todecoins.entity.trades.trade_api.CodecHelper;
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

public record TwoLootTableForEnchantedItemFactory(ItemStack offeredItem, ResourceLocation requestedTable1, ResourceLocation requestedTable2, int maxUses, int experience, float priceMultiplier) implements SerializableTradeOfferFactory {
    public static final Codec<TwoLootTableForEnchantedItemFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CodecHelper.SIMPLE_ITEM_STACK_CODEC.fieldOf(TradeOfferConstants.offerStack).forGetter(TwoLootTableForEnchantedItemFactory::offeredItem),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(TwoLootTableForEnchantedItemFactory::requestedTable1),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.secondaryRequestTable).forGetter(TwoLootTableForEnchantedItemFactory::requestedTable2),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.RARE_MAX_TRADES).forGetter(TwoLootTableForEnchantedItemFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(TwoLootTableForEnchantedItemFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.RARE_TRADE_MULTIPLIER).forGetter(TwoLootTableForEnchantedItemFactory::priceMultiplier)
    ).apply(instance, TwoLootTableForEnchantedItemFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new TwoLootTableForEnchantedItem(offeredItem, requestedTable1, requestedTable2, maxUses, experience, priceMultiplier).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.TWO_LOOT_TABLE_FOR_ENCHANTED;
    }
}