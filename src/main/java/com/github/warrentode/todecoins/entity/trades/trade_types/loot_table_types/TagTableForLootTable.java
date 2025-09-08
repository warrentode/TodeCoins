package com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

public class TagTableForLootTable implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ResourceLocation requestedTagTable;
    private final int requestedTagCount;
    private final ResourceLocation offeredTable;

    public TagTableForLootTable(ResourceLocation requestedTagTable, int requestedTagCount, ResourceLocation offeredTable, int maxUses, int xpValue, float priceMultiplier) {
        this.requestedTagTable = requestedTagTable;
        this.requestedTagCount = requestedTagCount;
        this.offeredTable = offeredTable;
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
            LootTable requestTable = minecraftServer.getLootData().getLootTable(this.requestedTagTable);
            LootTable offerTable = minecraftServer.getLootData().getLootTable(this.offeredTable);

            LootParams.Builder builder = new LootParams.Builder((ServerLevel) trader.level);
            builder.withParameter(LootContextParams.ORIGIN, trader.position());
            builder.withParameter(LootContextParams.THIS_ENTITY, trader);

            LootParams lootParams = builder.create(LootContextParamSets.GIFT);

            List<ItemStack> requested = requestTable.getRandomItems(lootParams);
            List<ItemStack> offered = offerTable.getRandomItems(lootParams);

            if (requested.isEmpty()) {
                TC_LOGGER.warn("Requested loot table '{}' returned no items.", requestTable); // Log the warning
                return null;
            }
            if (offered.isEmpty()) {
                TC_LOGGER.warn("Offered loot table '{}' returned no items.", offerTable); // Log the warning
                return null;
            }

            ItemStack request = requested.get(source.nextInt(requested.size())).copy();
            ItemStack requestStack = new ItemStack(request.getItem(), this.requestedTagCount);

            ItemStack offerStack = offered.get(source.nextInt(offered.size())).copy();

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}