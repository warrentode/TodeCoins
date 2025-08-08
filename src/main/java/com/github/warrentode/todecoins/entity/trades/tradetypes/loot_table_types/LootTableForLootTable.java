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
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        if (!(trader.level instanceof ServerLevel)) {
            return null;
        }
        else {
            MinecraftServer minecraftServer = trader.level.getServer();
            LootTable requestedTable = minecraftServer.getLootTables().get(requestTable);
            LootTable offeredTable = minecraftServer.getLootTables().get(offerTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> requested = requestedTable.getRandomItems(lootContext);
            List<ItemStack> offered = offeredTable.getRandomItems(lootContext);

            if (requested.isEmpty()) {
                TodeCoins.LOGGER.warn("Requested loot table '{}' returned no items.", requestedTable); // Log the warning
                return null;
            }
            if (offered.isEmpty()) {
                TodeCoins.LOGGER.warn("Offered loot table '{}' returned no items.", offeredTable); // Log the warning
                return null;
            }

            ItemStack requestStack = requested.get(source.nextInt(requested.size())).copy();
            ItemStack offerStack = offered.get(source.nextInt(offered.size())).copy();

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.tradeXP, this.priceMultiplier);
        }
    }
}