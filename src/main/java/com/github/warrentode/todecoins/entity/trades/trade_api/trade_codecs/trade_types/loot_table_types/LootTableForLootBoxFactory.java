package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.loot_table_types;

import com.github.warrentode.todecoins.entity.trades.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.LootTableForLootBox;
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

public record LootTableForLootBoxFactory(ItemStack offeredItem, String displayName, ResourceLocation lootTable, ResourceLocation requestedTable, int maxUses, int experience, float priceMultiplier) implements SerializableTradeOfferFactory {
    public static final Codec<LootTableForLootBoxFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CodecHelper.SIMPLE_ITEM_STACK_CODEC.fieldOf(TradeOfferConstants.offerStack).forGetter(LootTableForLootBoxFactory::offeredItem),
            Codec.STRING.fieldOf("display_name").forGetter(LootTableForLootBoxFactory::displayName),
            ResourceLocation.CODEC.fieldOf("loot_table").forGetter(LootTableForLootBoxFactory::lootTable),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(LootTableForLootBoxFactory::requestedTable),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(LootTableForLootBoxFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(LootTableForLootBoxFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.COMMON_TRADE_MULTIPLIER).forGetter(LootTableForLootBoxFactory::priceMultiplier)
    ).apply(instance, LootTableForLootBoxFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new LootTableForLootBox( this.offeredItem, this.displayName, this.lootTable, this.requestedTable, this.maxUses, this.experience, this.priceMultiplier).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.LOOT_TABLE_FOR_LOOT_BOX;
    }
}