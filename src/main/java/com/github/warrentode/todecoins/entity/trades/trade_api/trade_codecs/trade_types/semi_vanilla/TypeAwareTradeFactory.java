package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.semi_vanilla;

import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.trades.trade_api.CodecHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.mojang.serialization.Codec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Supplier;

public record TypeAwareTradeFactory(Map<VillagerType, VillagerTrades.ItemListing> tradeOffers) implements SerializableTradeOfferFactory {
    public static final Codec<TypeAwareTradeFactory> CODEC =
            CodecHelper.villagerTypeMap(TradeOfferFactoryType.TRADE_OFFER_FACTORY_REGISTRY_CODEC)
                    .fieldOf("trades").xmap(TypeAwareTradeFactory::new,
                            TypeAwareTradeFactory::tradeOffers).codec();

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        if (trader instanceof VillagerDataHolder villager) {
            return this.tradeOffers.get(villager.getVillagerData().getType()).getOffer(trader, random);
        }
        return null;
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.TYPE_AWARE;
    }
}