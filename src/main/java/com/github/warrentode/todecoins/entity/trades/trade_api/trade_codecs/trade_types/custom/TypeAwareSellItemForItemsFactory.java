package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.custom;

import com.github.warrentode.todecoins.entity.trades.trade_api.CodecHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferConstants;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class TypeAwareSellItemForItemsFactory implements SerializableTradeOfferFactory {
    public static final Codec<TypeAwareSellItemForItemsFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CodecHelper.villagerTypeMap(CodecHelper.SIMPLE_ITEM_STACK_CODEC).fieldOf(TradeOfferConstants.requestStack).forGetter(typeAwareSellItemForItemsFactory -> typeAwareSellItemForItemsFactory.buyMap1),
            CodecHelper.villagerTypeMap(CodecHelper.SIMPLE_ITEM_STACK_CODEC).optionalFieldOf(TradeOfferConstants.secondaryRequestStack).forGetter(typeAwareSellItemForItemsFactory -> Optional.ofNullable(typeAwareSellItemForItemsFactory.buyMap2)),
            CodecHelper.villagerTypeMap(CodecHelper.SIMPLE_ITEM_STACK_CODEC).fieldOf(TradeOfferConstants.offerStack).forGetter(typeAwareSellItemForItemsFactory -> typeAwareSellItemForItemsFactory.sellMap),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> factory.maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> factory.experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.COMMON_TRADE_MULTIPLIER).forGetter(factory -> factory.multiplier)
    ).apply(instance, TypeAwareSellItemForItemsFactory::new));

    public final Map<VillagerType, ItemStack> buyMap1;
    public final Map<VillagerType, ItemStack> buyMap2;
    public final Map<VillagerType, ItemStack> sellMap;
    public final int maxUses;
    public final int experience;
    public final float multiplier;

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public TypeAwareSellItemForItemsFactory(Map<VillagerType, ItemStack> buyMap1, Optional<Map<VillagerType, ItemStack>> buyMap2, Map<VillagerType, ItemStack> sellMap, int maxUses, int experience, float multiplier) {
        Registry.VILLAGER_TYPE.stream().filter((villagerType) -> !buyMap1.containsKey(villagerType) || (buyMap2.isPresent() && !buyMap2.get().containsKey(villagerType)) || !sellMap.containsKey(villagerType)).findAny().ifPresent((villagerType) -> {
            throw new IllegalStateException("Missing trade for villager type: " + Registry.VILLAGER_TYPE.getId(villagerType));
        });
        this.buyMap1 = buyMap1;
        this.buyMap2 = buyMap2.orElse(null);
        this.sellMap = sellMap;
        this.maxUses = maxUses;
        this.experience = experience;
        this.multiplier = multiplier;
    }


    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        if (trader instanceof VillagerDataHolder) {
            ItemStack buy1 = this.buyMap1.get(((VillagerDataHolder) trader).getVillagerData().getType()).copy();
            ItemStack buy2 = this.buyMap2 != null ? this.buyMap2.get(((VillagerDataHolder) trader).getVillagerData().getType()).copy() : ItemStack.EMPTY;
            ItemStack sell = this.sellMap.get(((VillagerDataHolder) trader).getVillagerData().getType()).copy();
            return new MerchantOffer(buy1, buy2, sell, this.maxUses, this.experience, this.multiplier);
        }
        else {
            return null;
        }
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.TYPE_AWARE_SELL_ITEMS_FOR_ITEM;
    }
}