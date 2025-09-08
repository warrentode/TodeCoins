package com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.loot_table_types;

import com.github.warrentode.todecoins.entity.trades.TradeOfferConstants;
import com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types.LootTableForSpecifiedEnchantmentLootTable;
import com.github.warrentode.todecoins.entity.trades.trade_api.SerializableTradeOfferFactory;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public record LootTableForSpecifiedEnchantmentFactory(ResourceLocation enchantedTable, ResourceLocation requestedLootTable, int maxUses, int experience, float multiplier, int enchantmentLevel, String enchantments) implements SerializableTradeOfferFactory {
    public static final Codec<LootTableForSpecifiedEnchantmentFactory> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.offerTable).forGetter(LootTableForSpecifiedEnchantmentFactory::enchantedTable),
            ResourceLocation.CODEC.fieldOf(TradeOfferConstants.requestTable).forGetter(LootTableForSpecifiedEnchantmentFactory::requestedLootTable),
            Codec.INT.optionalFieldOf(TradeOfferConstants.maxUses, TradeOfferConstants.RARE_MAX_TRADES).forGetter(LootTableForSpecifiedEnchantmentFactory::maxUses),
            Codec.INT.optionalFieldOf(TradeOfferConstants.experience, TradeOfferConstants.BASE_XP).forGetter(LootTableForSpecifiedEnchantmentFactory::experience),
            Codec.FLOAT.optionalFieldOf(TradeOfferConstants.multiplier, TradeOfferConstants.RARE_TRADE_MULTIPLIER).forGetter(LootTableForSpecifiedEnchantmentFactory::multiplier),
            Codec.INT.fieldOf("enchantment_level").forGetter(LootTableForSpecifiedEnchantmentFactory::enchantmentLevel),
            Codec.STRING.fieldOf("enchantment").forGetter(LootTableForSpecifiedEnchantmentFactory::enchantments)
    ).apply(instance, LootTableForSpecifiedEnchantmentFactory::new));

    // enchantment instance getter
    @Contract("_, _ -> new")
    public static @NotNull EnchantmentInstance[] getEnchantmentInstance(String enchantment, int level) {
        ResourceLocation enchantmentLocation = ResourceLocation.tryParse(enchantment);

        if (enchantmentLocation != null) {
            Enchantment enchantmentKey = ForgeRegistries.ENCHANTMENTS.getValue(ResourceLocation.tryParse(String.valueOf(enchantmentLocation)));
            assert enchantmentKey != null;
            return new EnchantmentInstance[]{new EnchantmentInstance(enchantmentKey, level)};
        }
        else {
            return new EnchantmentInstance[]{new EnchantmentInstance(Enchantments.ALL_DAMAGE_PROTECTION, 1)};
        }
    }

    @Override
    public @Nullable MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        return new LootTableForSpecifiedEnchantmentLootTable(enchantedTable, requestedLootTable,
                maxUses, experience, multiplier, enchantmentLevel,
                getEnchantmentInstance(enchantments, enchantmentLevel)
        ).getOffer(trader, random);
    }

    @SuppressWarnings("SameReturnValue")
    public Supplier<TradeOfferFactoryType<?>> getType() {
        return TradeOfferFactoryType.LOOT_TABLE_FOR_SPECIFIED_ENCHANTMENT; // Replace as appropriate
    }
}