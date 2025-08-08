package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom;

import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types.LootTableForPotion;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public record LootTableForPotionFactory(MobEffect effect, int duration, ResourceLocation requestTable, int maxUses, int experience, float multiplier) implements SerializableTradeOfferFactory {
    public static final Codec<LootTableForPotionFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ForgeRegistries.MOB_EFFECTS.getCodec().fieldOf(TradeOfferConstants.effect).forGetter(LootTableForPotionFactory::effect),
            Codec.INT.fieldOf(TradeOfferConstants.duration).forGetter(LootTableForPotionFactory::duration),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(LootTableForPotionFactory::requestTable),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.RARE_MAX_TRADES).forGetter(LootTableForPotionFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(LootTableForPotionFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.RARE_TRADE_MULTIPLIER).forGetter(LootTableForPotionFactory::multiplier)
    ).apply(instance, LootTableForPotionFactory::new));

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new LootTableForPotion(effect, duration, requestTable, maxUses, experience, multiplier).getOffer(trader, random);
    }
    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.LOOT_TABLE_FOR_POTION;
    }
}