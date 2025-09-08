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

public class LootTableForLootTable implements VillagerTrades.ItemListing {
    private final ResourceLocation requestTable;
    private final ResourceLocation offerTable;
    private final int maxUses;
    private final int tradeXP;
    private final float priceMultiplier;

    public LootTableForLootTable(ResourceLocation requestTable, ResourceLocation offerTable, int maxUses, int tradeXP, float priceMultiplier) {
        this.requestTable = requestTable;
        this.offerTable = offerTable;
        this.maxUses = maxUses;
        this.tradeXP = tradeXP;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
        if (!(trader.level instanceof ServerLevel serverLevel)) {
            return null;
        }

        MinecraftServer minecraftServer = serverLevel.getServer();

        LootTable requestedTable = minecraftServer.getLootData().getLootTable(requestTable);
        LootTable offeredTable = minecraftServer.getLootData().getLootTable(offerTable);

        LootParams.Builder builder = new LootParams.Builder((ServerLevel) trader.level);
        builder.withParameter(LootContextParams.ORIGIN, trader.position());
        builder.withParameter(LootContextParams.THIS_ENTITY, trader);

        LootParams lootParams = builder.create(LootContextParamSets.GIFT);

        List<ItemStack> requested = requestedTable.getRandomItems(lootParams);
        List<ItemStack> offered = offeredTable.getRandomItems(lootParams);

        if (requested.isEmpty()) {
            TC_LOGGER.warn("Requested loot table '{}' returned no items.", requestTable);
            return null;
        }
        if (offered.isEmpty()) {
            TC_LOGGER.warn("Offered loot table '{}' returned no items.", offerTable);
            return null;
        }

        ItemStack requestStack = requested.get(random.nextInt(requested.size())).copy();
        ItemStack offerStack = offered.get(random.nextInt(offered.size())).copy();

        return new MerchantOffer(requestStack, offerStack, maxUses, tradeXP, priceMultiplier);
    }
}