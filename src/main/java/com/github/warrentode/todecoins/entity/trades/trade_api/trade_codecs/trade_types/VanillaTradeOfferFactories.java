package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types;

import com.github.warrentode.todecoins.entity.trades.trade_api.CodecHelper;
import com.github.warrentode.todecoins.mixin.TradeOffersAccessor;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class VanillaTradeOfferFactories {
    // the villager is the one buying and selling, so the item they're buying is the requested item
    // while the item they are selling is the offered item
    public static final Codec<VillagerTrades.EmeraldForItems> BUY_FOR_ONE_EMERALD =
            RecordCodecBuilder.create(instance -> instance.group(
            ForgeRegistries.ITEMS.getCodec().fieldOf(TradeOfferConstants.requestStack).forGetter(factory -> ((TradeOffersAccessor.EmeraldForItemsAccessor) factory).getBuy()),
            Codec.INT.fieldOf(TradeOfferConstants.requestStackCount).forGetter(factory -> ((TradeOffersAccessor.EmeraldForItemsAccessor) factory).getPrice()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> ((TradeOffersAccessor.EmeraldForItemsAccessor) factory).getMaxUses()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> ((TradeOffersAccessor.EmeraldForItemsAccessor) factory).getExperience())
    ).apply(instance, VillagerTrades.EmeraldForItems::new));

    public static final Codec<VillagerTrades.ItemsForEmeralds> SELL_ITEM = RecordCodecBuilder.create(instance -> instance.group(
            ForgeRegistries.ITEMS.getCodec().fieldOf(TradeOfferConstants.offerStack).forGetter(factory -> ((TradeOffersAccessor.ItemsForEmeraldsAccessor) factory).getSell().getItem()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.emeraldCount, 1).forGetter(factory -> ((TradeOffersAccessor.ItemsForEmeraldsAccessor) factory).getPrice()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.offerStackCount, 1).forGetter(factory -> ((TradeOffersAccessor.ItemsForEmeraldsAccessor) factory).getCount()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> ((TradeOffersAccessor.ItemsForEmeraldsAccessor) factory).getMaxUses()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> ((TradeOffersAccessor.ItemsForEmeraldsAccessor) factory).getExperience())
    ).apply(instance, VillagerTrades.ItemsForEmeralds::new));

    public static final Codec<VillagerTrades.SuspiciousStewForEmerald> SELL_SUSPICIOUS_STEW = RecordCodecBuilder.create(instance -> instance.group(
            ForgeRegistries.MOB_EFFECTS.getCodec().fieldOf(TradeOfferConstants.effect).forGetter(factory -> ((TradeOffersAccessor.SuspiciousStewForEmeraldAccessor) factory).getEffect()),
            Codec.INT.fieldOf(TradeOfferConstants.duration).forGetter(factory -> ((TradeOffersAccessor.SuspiciousStewForEmeraldAccessor) factory).getDuration()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> ((TradeOffersAccessor.SuspiciousStewForEmeraldAccessor) factory).getExperience())
    ).apply(instance, VillagerTrades.SuspiciousStewForEmerald::new));

    public static final Codec<VillagerTrades.ItemsAndEmeraldsToItems> PROCESS_ITEM = RecordCodecBuilder.create(instance -> instance.group(
            ForgeRegistries.ITEMS.getCodec().fieldOf(TradeOfferConstants.secondaryRequestStack).forGetter(factory -> ((TradeOffersAccessor.ItemsAndEmeraldsToItemsAccessor) factory).getSecondBuy().getItem()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.secondaryRequestStackCount, 1).forGetter(factory -> ((TradeOffersAccessor.ItemsAndEmeraldsToItemsAccessor) factory).getSecondCount()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.emeraldCount, 1).forGetter(factory -> ((TradeOffersAccessor.ItemsAndEmeraldsToItemsAccessor) factory).getPrice()),
            ForgeRegistries.ITEMS.getCodec().fieldOf(TradeOfferConstants.offerStack).forGetter(factory -> ((TradeOffersAccessor.ItemsAndEmeraldsToItemsAccessor) factory).getSell().getItem()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.offerStackCount, 1).forGetter(factory -> ((TradeOffersAccessor.ItemsAndEmeraldsToItemsAccessor) factory).getSellCount()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> ((TradeOffersAccessor.ItemsAndEmeraldsToItemsAccessor) factory).getMaxUses()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> ((TradeOffersAccessor.ItemsAndEmeraldsToItemsAccessor) factory).getExperience())
    ).apply(instance, VillagerTrades.ItemsAndEmeraldsToItems::new));

    public static final Codec<VillagerTrades.EnchantedItemForEmeralds> SELL_ENCHANTED_ITEM = RecordCodecBuilder.create(instance -> instance.group(
            ForgeRegistries.ITEMS.getCodec().fieldOf(TradeOfferConstants.offerStack).forGetter(factory -> ((TradeOffersAccessor.EnchantedItemForEmeraldsAccessor) factory).getEnchantedItem().getItem()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.emeraldCount, 1).forGetter(factory -> ((TradeOffersAccessor.EnchantedItemForEmeraldsAccessor) factory).getBasePrice()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.RARE_MAX_TRADES).forGetter(factory -> ((TradeOffersAccessor.EnchantedItemForEmeraldsAccessor) factory).getMaxUses()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> ((TradeOffersAccessor.EnchantedItemForEmeraldsAccessor) factory).getExperience()),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.RARE_TRADE_MULTIPLIER).forGetter(factory -> ((TradeOffersAccessor.EnchantedItemForEmeraldsAccessor) factory).getMultiplier())
    ).apply(instance, VillagerTrades.EnchantedItemForEmeralds::new));

    public static final Codec<VillagerTrades.EmeraldsForVillagerTypeItem> TYPE_AWARE_BUY_FOR_ONE_EMERALD = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.optionalFieldOf(TradeOfferConstants.requestStackCount, 1).forGetter(factory -> ((TradeOffersAccessor.EmeraldsForVillagerTypeItemAccessor) factory).getCount()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> ((TradeOffersAccessor.EmeraldsForVillagerTypeItemAccessor) factory).getMaxUses()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> ((TradeOffersAccessor.EmeraldsForVillagerTypeItemAccessor) factory).getExperience()),
            CodecHelper.villagerTypeMap(ForgeRegistries.ITEMS.getCodec()).fieldOf(TradeOfferConstants.offerStackList).forGetter(factory -> ((TradeOffersAccessor.EmeraldsForVillagerTypeItemAccessor) factory).getMap())
    ).apply(instance, VillagerTrades.EmeraldsForVillagerTypeItem::new));

    public static final Codec<VillagerTrades.TippedArrowForItemsAndEmeralds> SELL_TIPPED_ARROW = RecordCodecBuilder.create(instance -> instance.group(
            ForgeRegistries.ITEMS.getCodec().optionalFieldOf("arrow", Items.ARROW).forGetter(factory -> ((TradeOffersAccessor.TippedArrowForItemsAndEmeraldsAccessor) factory).getSecondBuy()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.arrowCount, 1).forGetter(factory -> ((TradeOffersAccessor.TippedArrowForItemsAndEmeraldsAccessor) factory).getSecondCount()),
            ForgeRegistries.ITEMS.getCodec().optionalFieldOf("tipped_arrow", Items.TIPPED_ARROW).forGetter(factory -> ((TradeOffersAccessor.TippedArrowForItemsAndEmeraldsAccessor) factory).getSell().getItem()),
            Codec.INT.fieldOf(TradeOfferConstants.emeraldCount).forGetter(factory -> ((TradeOffersAccessor.TippedArrowForItemsAndEmeraldsAccessor) factory).getPrice()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.tippedArrowCount, 1).forGetter(factory -> ((TradeOffersAccessor.TippedArrowForItemsAndEmeraldsAccessor) factory).getSellCount()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> ((TradeOffersAccessor.TippedArrowForItemsAndEmeraldsAccessor) factory).getMaxUses()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> ((TradeOffersAccessor.TippedArrowForItemsAndEmeraldsAccessor) factory).getExperience())
    ).apply(instance, VillagerTrades.TippedArrowForItemsAndEmeralds::new));

    public static final Codec<VillagerTrades.EnchantBookForEmeralds> SELL_ENCHANT_BOOK =
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).xmap(VillagerTrades.EnchantBookForEmeralds::new, enchantBookForEmeralds -> ((TradeOffersAccessor.EnchantBookForEmeraldsAccessor) enchantBookForEmeralds).getExperience()).codec();

    public static final Codec<VillagerTrades.TreasureMapForEmeralds> SELL_MAP = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.optionalFieldOf(TradeOfferConstants.emeraldCount, 1).forGetter(factory -> ((TradeOffersAccessor.TreasureMapForEmeraldsAccessor) factory).getPrice()),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.structureTag).xmap(resourceLocation -> TagKey.create(Registry.STRUCTURE_REGISTRY, resourceLocation),TagKey::location).forGetter(factory -> ((TradeOffersAccessor.TreasureMapForEmeraldsAccessor) factory).getStructure()),
            Codec.STRING.fieldOf(TradeOfferConstants.mapName).forGetter(factory -> ((TradeOffersAccessor.TreasureMapForEmeraldsAccessor) factory).getNameKey()),
            CodecHelper.forEnum(MapDecoration.Type.class).optionalFieldOf(TradeOfferConstants.mapMarker, MapDecoration.Type.TARGET_X).forGetter(factory -> ((TradeOffersAccessor.TreasureMapForEmeraldsAccessor) factory).getIconType()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> ((TradeOffersAccessor.TreasureMapForEmeraldsAccessor) factory).getMaxUses()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> ((TradeOffersAccessor.TreasureMapForEmeraldsAccessor) factory).getExperience())
    ).apply(instance, VillagerTrades.TreasureMapForEmeralds::new));

    public static final Codec<VillagerTrades.DyedArmorForEmeralds> SELL_DYED_ARMOR = RecordCodecBuilder.create(instance -> instance.group(
            ForgeRegistries.ITEMS.getCodec().fieldOf(TradeOfferConstants.offerStack).forGetter(factory -> ((TradeOffersAccessor.DyedArmorForEmeraldsAccessor) factory).getSell()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.emeraldCount, 1).forGetter(factory -> ((TradeOffersAccessor.DyedArmorForEmeraldsAccessor) factory).getPrice()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.COMMON_MAX_TRADES).forGetter(factory -> ((TradeOffersAccessor.DyedArmorForEmeraldsAccessor) factory).getMaxUses()),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(factory -> ((TradeOffersAccessor.DyedArmorForEmeraldsAccessor) factory).getExperience())
    ).apply(instance, VillagerTrades.DyedArmorForEmeralds::new));

    @Contract("null -> fail")
    public static @NotNull Supplier<TradeOfferFactoryType<?>> getVanillaFactoryCodec(VillagerTrades.ItemListing itemListing) {
        if (itemListing instanceof VillagerTrades.EmeraldForItems) {
            return TradeOfferFactoryType.BUY_FOR_ONE_EMERALD;
        }
        if (itemListing instanceof VillagerTrades.ItemsForEmeralds) {
            return TradeOfferFactoryType.SELL_ITEM;
        }
        if (itemListing instanceof VillagerTrades.SuspiciousStewForEmerald) {
            return TradeOfferFactoryType.SELL_SUSPICIOUS_STEW;
        }
        if (itemListing instanceof VillagerTrades.ItemsAndEmeraldsToItems) {
            return TradeOfferFactoryType.PROCESS_ITEM;
        }
        if (itemListing instanceof VillagerTrades.EnchantedItemForEmeralds) {
            return TradeOfferFactoryType.SELL_ENCHANTED_ITEM;
        }
        if (itemListing instanceof VillagerTrades.EmeraldsForVillagerTypeItem) {
            return TradeOfferFactoryType.TYPE_AWARE_BUY_FOR_ONE_EMERALD;
        }
        if (itemListing instanceof VillagerTrades.TippedArrowForItemsAndEmeralds) {
            return TradeOfferFactoryType.SELL_TIPPED_ARROW;
        }
        if (itemListing instanceof VillagerTrades.EnchantBookForEmeralds) {
            return TradeOfferFactoryType.SELL_ENCHANT_BOOK;
        }
        if (itemListing instanceof VillagerTrades.TreasureMapForEmeralds) {
            return TradeOfferFactoryType.SELL_MAP;
        }
        if (itemListing instanceof VillagerTrades.DyedArmorForEmeralds) {
            return TradeOfferFactoryType.SELL_DYED_ARMOR;
        }

        throw new IllegalStateException("Could not find codec for factory " + itemListing.getClass());
    }
}