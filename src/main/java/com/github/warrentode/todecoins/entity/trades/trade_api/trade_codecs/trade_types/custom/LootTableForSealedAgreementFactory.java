package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom;

import com.github.warrentode.todecoins.entity.trades.trade_api.CodecHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types.LootTableForSealedAgreement;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.mortuusars.wares.data.agreement.component.TextProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public record LootTableForSealedAgreementFactory(
        ResourceLocation requestTable,
        ResourceLocation agreementPriceTable,
        ResourceLocation agreementOfferTable,
        String agreementID,
        TextProvider title,
        Component backsideMessage,
        TextProvider buyerName,
        TextProvider buyerAddress,
        TextProvider buyerMessage,
        String seal,
        Component sealTooltip,
        int orderCount,
        int orderXP,
        int maxUses,
        int experience,
        float priceMultiplier
) implements SerializableTradeOfferFactory {

    public static final Codec<LootTableForSealedAgreementFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("request_table").forGetter(LootTableForSealedAgreementFactory::requestTable),
            ResourceLocation.CODEC.fieldOf("agreement_price_table").forGetter(LootTableForSealedAgreementFactory::agreementPriceTable),
            ResourceLocation.CODEC.fieldOf("agreement_offer_table").forGetter(LootTableForSealedAgreementFactory::agreementOfferTable),
            Codec.STRING.fieldOf("agreement_id").forGetter(LootTableForSealedAgreementFactory::agreementID),
            TextProvider.CODEC.fieldOf("title").forGetter(LootTableForSealedAgreementFactory::title),
            CodecHelper.COMPONENT_CODEC.fieldOf("backside_message").forGetter(LootTableForSealedAgreementFactory::backsideMessage),
            TextProvider.CODEC.fieldOf("buyer_name").forGetter(LootTableForSealedAgreementFactory::buyerName),
            TextProvider.CODEC.fieldOf("buyer_address").forGetter(LootTableForSealedAgreementFactory::buyerAddress),
            TextProvider.CODEC.fieldOf("buyer_message").forGetter(LootTableForSealedAgreementFactory::buyerMessage),
            Codec.STRING.fieldOf("seal").forGetter(LootTableForSealedAgreementFactory::seal),
            CodecHelper.COMPONENT_CODEC.fieldOf("seal_tooltip").forGetter(LootTableForSealedAgreementFactory::sealTooltip),
            Codec.INT.fieldOf("order_count").forGetter(LootTableForSealedAgreementFactory::orderCount),
            Codec.INT.fieldOf("order_xp").forGetter(LootTableForSealedAgreementFactory::orderXP),
            Codec.INT.optionalFieldOf("max_trades", TradeOfferConstants.RARE_MAX_TRADES).forGetter(LootTableForSealedAgreementFactory::maxUses),
            Codec.INT.optionalFieldOf("trade_experience", TradeOfferConstants.BASE_XP).forGetter(LootTableForSealedAgreementFactory::experience),
            Codec.FLOAT.optionalFieldOf("price_multiplier", TradeOfferConstants.RARE_TRADE_MULTIPLIER).forGetter(LootTableForSealedAgreementFactory::priceMultiplier)
    ).apply(instance, LootTableForSealedAgreementFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        return new LootTableForSealedAgreement(requestTable, agreementPriceTable, agreementOfferTable, agreementID, title, backsideMessage, buyerName, buyerAddress, buyerMessage, seal, sealTooltip, orderCount, orderXP, maxUses, experience, priceMultiplier).getOffer(trader, source);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.LOOT_TABLE_FOR_SEALED_AGREEMENT;
    }
}