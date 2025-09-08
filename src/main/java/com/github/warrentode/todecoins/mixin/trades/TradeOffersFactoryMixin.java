package com.github.warrentode.todecoins.mixin.trades;

import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryTypeHolder;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.VanillaTradeOfferFactories;
import net.minecraft.world.entity.npc.VillagerTrades;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Supplier;

@Mixin(VillagerTrades.ItemListing.class)
public interface TradeOffersFactoryMixin extends TradeOfferFactoryTypeHolder {
    @Override
    @SuppressWarnings("AddedMixinMembersNamePattern")
    default Supplier<TradeOfferFactoryType<?>> getType() {
        return VanillaTradeOfferFactories.getVanillaFactoryCodec((VillagerTrades.ItemListing) this);
    }
}