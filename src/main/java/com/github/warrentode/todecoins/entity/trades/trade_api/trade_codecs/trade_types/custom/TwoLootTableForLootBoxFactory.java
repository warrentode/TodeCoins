package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom;

import com.github.warrentode.todecoins.entity.trades.trade_api.CodecHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types.TwoLootTableForLootBox;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
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

public record TwoLootTableForLootBoxFactory(ItemStack offeredItem, String displayName, ResourceLocation lootTable, ResourceLocation requestedTable, ResourceLocation secondaryRequestedTable, int maxUses, int experience, float priceMultiplier) implements SerializableTradeOfferFactory {
    public static final Codec<TwoLootTableForLootBoxFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CodecHelper.SIMPLE_ITEM_STACK_CODEC.fieldOf(TradeOfferConstants.offerStack).forGetter(TwoLootTableForLootBoxFactory::offeredItem),
            Codec.STRING.fieldOf("display_name").forGetter(TwoLootTableForLootBoxFactory::displayName),
            ResourceLocation.CODEC.fieldOf("loot_table").forGetter(TwoLootTableForLootBoxFactory::lootTable),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(TwoLootTableForLootBoxFactory::requestedTable),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.secondaryRequestTable).forGetter(TwoLootTableForLootBoxFactory::secondaryRequestedTable),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(TwoLootTableForLootBoxFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(TwoLootTableForLootBoxFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.COMMON_TRADE_MULTIPLIER).forGetter(TwoLootTableForLootBoxFactory::priceMultiplier)
    ).apply(instance, TwoLootTableForLootBoxFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new TwoLootTableForLootBox( this.offeredItem, this.displayName, this.lootTable, this.requestedTable, this.secondaryRequestedTable, this.maxUses, this.experience, this.priceMultiplier).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.TWO_LOOT_TABLE_FOR_LOOT_BOX;
    }
}