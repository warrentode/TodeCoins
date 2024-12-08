package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table_types;

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

public class LootTableForTagTable implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ResourceLocation offeredTagTable;
    private final int offeredTagCount;
    private final ResourceLocation requestedTable;

    public LootTableForTagTable(ResourceLocation requestedTable, ResourceLocation offeredTagTable, int offeredTagCount, int maxUses, int xpValue, float priceMultiplier) {
        this.offeredTagTable = offeredTagTable;
        this.offeredTagCount = offeredTagCount;
        this.requestedTable = requestedTable;
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
            LootTable offeredTable = minecraftServer.getLootTables().get(this.offeredTagTable);
            LootTable requestedTable = minecraftServer.getLootTables().get(this.requestedTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> offered = offeredTable.getRandomItems(lootContext);
            List<ItemStack> requested = requestedTable.getRandomItems(lootContext);

            if (requested.isEmpty()) {
                TodeCoins.LOGGER.warn("Requested loot table '{}' returned no items.", requestedTable); // Log the warning
            }
            if (offered.isEmpty()) {
                TodeCoins.LOGGER.warn("Offered loot table '{}' returned no items.", offeredTable); // Log the warning
            }

            ItemStack offerStack = new ItemStack(
                    offered.get(source.nextInt(requested.size())).getItem(), this.offeredTagCount);
            ItemStack requestStack = new ItemStack(
                    requested.get(source.nextInt(requested.size())).getItem(),
                    requested.get(source.nextInt(requested.size())).getCount());

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}