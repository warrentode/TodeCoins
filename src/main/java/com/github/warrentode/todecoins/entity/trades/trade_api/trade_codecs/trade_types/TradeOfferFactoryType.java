package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types;

import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.loot_table_types.*;
import com.github.warrentode.todecoins.entity.trades.trade_api.CustomRegistryHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.semi_vanilla.SellItemForItemsFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.semi_vanilla.TypeAwareSellItemForItemsFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.semi_vanilla.TypeAwareTradeFactory;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.fml.ModList;

import java.util.function.Supplier;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TradeOfferFactoryType<P extends VillagerTrades.ItemListing> {
    private final Codec<P> tradeTypeCodec;

    public TradeOfferFactoryType(Codec<P> codec) {
        this.tradeTypeCodec = codec;
    }

    public Codec<P> codec() {
        return this.tradeTypeCodec;
    }

    // Custom registry for TradeOfferFactoryType
    public static final CustomRegistryHelper.RegistryHelper<TradeOfferFactoryType<?>> TRADE_OFFER_FACTORY_REGISTRY =
            CustomRegistryHelper.getTradeOfferRegistry();

    public static final Codec<VillagerTrades.ItemListing> TRADE_OFFER_FACTORY_REGISTRY_CODEC = ExtraCodecs.lazyInitializedCodec(
            () -> TRADE_OFFER_FACTORY_REGISTRY.getCodec().get().dispatch("type",
                    factory -> ((TradeOfferFactoryTypeHolder) factory).getType().get(),
                    TradeOfferFactoryType::codec));

    public static final Supplier<TradeOfferFactoryType<?>> BUY_FOR_ONE_EMERALD =
            register(ResourceLocation.parse("minecraft:buy_for_one_emerald"),
                    VanillaTradeOfferFactories.BUY_FOR_ONE_EMERALD);
    public static final Supplier<TradeOfferFactoryType<?>> SELL_ITEM =
            register(ResourceLocation.parse("minecraft:sell_for_emeralds"),
                    VanillaTradeOfferFactories.SELL_ITEM);
    public static final Supplier<TradeOfferFactoryType<?>> SELL_SUSPICIOUS_STEW =
            register(ResourceLocation.parse("minecraft:sell_suspicious_stew"),
                    VanillaTradeOfferFactories.SELL_SUSPICIOUS_STEW);
    public static final Supplier<TradeOfferFactoryType<?>> PROCESS_ITEM =
            register(ResourceLocation.parse("minecraft:items_and_emeralds_to_items"),
                    VanillaTradeOfferFactories.PROCESS_ITEM);
    public static final Supplier<TradeOfferFactoryType<?>> SELL_ENCHANTED_ITEM =
            register(ResourceLocation.parse("minecraft:sell_enchanted_item"),
                    VanillaTradeOfferFactories.SELL_ENCHANTED_ITEM);
    public static final Supplier<TradeOfferFactoryType<?>> TYPE_AWARE_BUY_FOR_ONE_EMERALD =
            register(ResourceLocation.parse("minecraft:type_aware_buy_for_one_emerald"),
                    VanillaTradeOfferFactories.TYPE_AWARE_BUY_FOR_ONE_EMERALD);
    public static final Supplier<TradeOfferFactoryType<?>> SELL_TIPPED_ARROW =
            register(ResourceLocation.parse("minecraft:sell_tipped_arrow"),
                    VanillaTradeOfferFactories.SELL_TIPPED_ARROW);
    public static final Supplier<TradeOfferFactoryType<?>> SELL_ENCHANT_BOOK =
            register(ResourceLocation.parse("minecraft:sell_enchanted_book"),
                    VanillaTradeOfferFactories.SELL_ENCHANT_BOOK);
    public static final Supplier<TradeOfferFactoryType<?>> SELL_MAP =
            register(ResourceLocation.parse("minecraft:sell_map"),
                    VanillaTradeOfferFactories.SELL_MAP);
    public static final Supplier<TradeOfferFactoryType<?>> SELL_DYED_ARMOR =
            register(ResourceLocation.parse("minecraft:sell_dyed_armor"),
                    VanillaTradeOfferFactories.SELL_DYED_ARMOR);

    public static final Supplier<TradeOfferFactoryType<?>> SELL_ITEM_FOR_ITEMS =
            register(ResourceLocation.parse("minecraft:sell_item_for_items"),
                    SellItemForItemsFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> TYPE_AWARE_SELL_ITEMS_FOR_ITEM =
            register(ResourceLocation.parse("minecraft:type_aware_sell_item_for_items"),
                    TypeAwareSellItemForItemsFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> TYPE_AWARE =
            register(ResourceLocation.parse("minecraft:type_aware"),
                    TypeAwareTradeFactory.CODEC);

    // my custom trade types
    public static final Supplier<TradeOfferFactoryType<?>> ITEM_FOR_LOOT_TABLE =
            register(ResourceLocation.parse(MODID + ":item_for_loot_table"),
                    ItemForLootTableFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> ITEM_FOR_TAG_TABLE =
            register(ResourceLocation.parse(MODID + ":item_for_tag_table"),
                    ItemForTagTableFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_AND_ITEM_FOR_ITEM =
            register(ResourceLocation.parse(MODID + ":loot_table_and_item_for_item"),
                    LootTableAndItemForItemFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_DYED_ARMOR =
            register(ResourceLocation.parse(MODID + ":loot_table_for_dyed_armor"),
                    LootTableForDyedArmorFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_ENCHANTED =
            register(ResourceLocation.parse(MODID + ":loot_table_for_enchanted_item"),
                    LootTableForEnchantedItemFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_ENCHANTED_ITEM_TABLE =
            register(ResourceLocation.parse(MODID + ":loot_table_for_enchanted_item_table"),
                    LootTableForEnchantedItemTableFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_ITEM =
            register(ResourceLocation.parse(MODID + ":loot_table_for_item"),
                    LootTableForItemFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_LOOT_TABLE =
            register(ResourceLocation.parse(MODID + ":loot_table_for_loot_table"),
                    LootTableForLootTableFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_POTION =
            register(ResourceLocation.parse(MODID + ":loot_table_for_potion"),
                    LootTableForPotionFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_SPECIFIED_ENCHANTMENT =
            register(ResourceLocation.parse(MODID + ":loot_table_for_specified_enchantment"),
                    LootTableForSpecifiedEnchantmentFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_SUS_STEW =
            register(ResourceLocation.parse(MODID + ":loot_table_for_sus_stew"),
                    LootTableForSUSStewFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_TAG_TABLE =
            register(ResourceLocation.parse(MODID + ":loot_table_for_tag_table"),
                    LootTableForTagTableFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_TIPPED_ARROW =
            register(ResourceLocation.parse(MODID + ":loot_table_for_tipped_arrow"),
                    LootTableForTippedArrowFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_TWO_LOOT_TABLE =
            register(ResourceLocation.parse(MODID + ":loot_table_for_two_loot_table"),
                    TwoLootTableForLootTableFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> TAG_TABLE_FOR_LOOT_TABLE =
            register(ResourceLocation.parse(MODID + ":tag_table_for_loot_table"),
                    TagTableForLootTableFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> TWO_LOOT_TABLE_FOR_ENCHANTED =
            register(ResourceLocation.parse(MODID + ":two_loot_table_for_enchanted_item"),
                    TwoLootTableForEnchantedItemFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> TWO_LOOT_TABLE_FOR_LOOT_BOX =
            register(ResourceLocation.parse(MODID + ":two_loot_table_for_loot_box"),
                    TwoLootTableForLootBoxFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> TWO_LOOT_TABLE_FOR_MAP =
            register(ResourceLocation.parse(MODID + ":two_loot_table_for_map"),
                    TwoLootTableForMapFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_LOOT_BOX =
            register(ResourceLocation.parse(MODID + ":loot_table_for_loot_box"),
                    LootTableForLootBoxFactory.CODEC);
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_AND_ITEM_FOR_ENCHANTED_ITEM =
            register(ResourceLocation.parse(MODID + ":loot_table_and_item_for_enchanted_item"),
                    LootTableAndItemForEnchantedItemFactory.CODEC);

    // requires wares mod
    public static final Supplier<TradeOfferFactoryType<?>> LOOT_TABLE_FOR_SEALED_AGREEMENT = createSealedAgreementFactory();
    private static Supplier<TradeOfferFactoryType<?>> createSealedAgreementFactory() {
        if (ModList.get().isLoaded("wares")) {
            return register(
                    ResourceLocation.parse(MODID + ":loot_table_for_sealed_agreement"),
                    LootTableForSealedAgreementFactory.CODEC
            );
        }
        else {
            // Safe no-op supplier that won’t crash when called, but indicates not present
            return () -> {
                throw new IllegalStateException("LOOT_TABLE_FOR_SEALED_AGREEMENT used without wares mod being loaded!");
            };
        }
    }


    @SuppressWarnings("SameParameterValue")
    static <P extends VillagerTrades.ItemListing> Supplier<TradeOfferFactoryType<?>> register(ResourceLocation id, Codec<P> codec) {
        return TRADE_OFFER_FACTORY_REGISTRY.register(id, () -> new TradeOfferFactoryType<>(codec));
    }

    @SuppressWarnings("EmptyMethod")
    public static void init() {
    }
}