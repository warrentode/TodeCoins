package com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

public class TwoLootTableForEnchantedItem implements VillagerTrades.ItemListing {
    private final ItemStack offerItem;
    private final ResourceLocation requestTable1;
    private final ResourceLocation requestTable2;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public TwoLootTableForEnchantedItem(ItemStack offerItem, ResourceLocation requestTable1,
                                        ResourceLocation requestTable2,
                                        int maxUses, int xpValue, float priceMultiplier) {
        this.offerItem = offerItem;
        this.requestTable1 = requestTable1;
        this.requestTable2 = requestTable2;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        if (!(trader.level instanceof ServerLevel)) {
            return null;
        }
        else {
            MinecraftServer minecraftServer = trader.level.getServer();
            LootTable requestedTable1 = minecraftServer.getLootData().getLootTable(requestTable1);
            LootTable requestedTable2 = minecraftServer.getLootData().getLootTable(requestTable2);

            LootParams.Builder builder = new LootParams.Builder((ServerLevel) trader.level);
            builder.withParameter(LootContextParams.ORIGIN, trader.position());
            builder.withParameter(LootContextParams.THIS_ENTITY, trader);

            LootParams lootParams = builder.create(LootContextParamSets.GIFT);

            List<ItemStack> requested1 = requestedTable1.getRandomItems(lootParams);
            List<ItemStack> requested2 = requestedTable2.getRandomItems(lootParams);

            if (requested1.isEmpty()) {
                TC_LOGGER.warn("First requested loot table '{}' returned no items.", requestedTable1); // Log the warning
                return null;
            }
            if (requested2.isEmpty()) {
                TC_LOGGER.warn("Second requested loot table '{}' returned no items.", requestedTable2); // Log the warning
                return null;
            }

            ItemStack requestStack1 = requested1.get(source.nextInt(requested1.size())).copy();
            ItemStack requestStack2 = requested2.get(source.nextInt(requested2.size())).copy();

            int i = 5 + source.nextInt(15);
            ItemStack enchantedItem = EnchantmentHelper.enchantItem(source, new ItemStack(this.offerItem.getItem()), i, false);

            return new MerchantOffer(requestStack1, requestStack2, enchantedItem, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}