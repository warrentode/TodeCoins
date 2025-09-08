package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.loot_table_types;

import com.github.warrentode.todecoins.entity.trades.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.TwoLootTableForMap;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.util.tags.TCStructureTags;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public record TwoLootTableForMapFactory(ResourceLocation currencyLootTable, ResourceLocation secondaryRequestLootTable, String structureTag, String mapName, String mapMarker, int maxUses, int experience, float multiplier) implements SerializableTradeOfferFactory {
    public static final Codec<TwoLootTableForMapFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(TwoLootTableForMapFactory::currencyLootTable),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.secondaryRequestTable).forGetter(TwoLootTableForMapFactory::secondaryRequestLootTable),
            Codec.STRING.fieldOf("structure_tag").forGetter(TwoLootTableForMapFactory::structureTag),
            Codec.STRING.fieldOf("map_name").forGetter(TwoLootTableForMapFactory::mapName),
            Codec.STRING.fieldOf("map_marker").forGetter(TwoLootTableForMapFactory::mapMarker),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.RARE_MAX_TRADES).forGetter(TwoLootTableForMapFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(TwoLootTableForMapFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.RARE_TRADE_MULTIPLIER).forGetter(TwoLootTableForMapFactory::multiplier)
    ).apply(instance, TwoLootTableForMapFactory::new));

    // structure tag getter
    public static @NotNull TagKey<Structure> getStructureTag(String structureTag) {
        ResourceLocation structureTagLocation = ResourceLocation.tryParse(structureTag);
        if (structureTagLocation != null) {
            return TCStructureTags.modStructureTag(structureTagLocation.getNamespace(), structureTagLocation.getPath());
        }
        else {
            return TCStructureTags.OVERWORLD_POI;
        }
    }

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        var markerName = MapDecoration.Type.valueOf(this.mapMarker);

        return new TwoLootTableForMap(this.currencyLootTable, this.secondaryRequestLootTable, getStructureTag(this.structureTag), this.mapName, markerName, this.maxUses, this.experience, this.multiplier).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.TWO_LOOT_TABLE_FOR_MAP;
    }
}