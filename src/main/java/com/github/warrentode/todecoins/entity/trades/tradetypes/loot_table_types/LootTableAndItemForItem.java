package com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types;

import com.github.warrentode.todecoins.TodeCoins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LootTableAndItemForItem implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ResourceLocation requestTable;
    private final ItemStack requestItem;
    private final int requestCount;
    private final ItemStack offerItem;
    private final int offerCount;

    public LootTableAndItemForItem(ResourceLocation requestTable, ItemStack requestItem, int requestCount, ItemStack offerItem, int offerCount, int maxUses, int xpValue, float priceMultiplier) {
        this.requestTable = requestTable;
        this.requestItem = requestItem;
        this.requestCount = requestCount;
        this.offerItem = offerItem;
        this.offerCount = offerCount;
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
            LootTable requestTable = minecraftServer.getLootTables().get(this.requestTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> requested = requestTable.getRandomItems(lootContext);

            if (requested.isEmpty()) {
                TodeCoins.LOGGER.warn("Requested loot table '{}' returned no items.", requestTable); // Log the warning
                return null;
            }

            ItemStack requestStack1 = requested.get(source.nextInt(requested.size())).copy();
            ItemStack requestStack2 = new ItemStack(this.requestItem.getItem(), this.requestCount);

            ItemStack offerStack = new ItemStack(this.offerItem.getItem(), this.offerCount);
            return new MerchantOffer(requestStack1, requestStack2, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}