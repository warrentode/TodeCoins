package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table;

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
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ResourceLocation requestTable;
    private final ResourceLocation offerTable;

    public LootTableForLootTable(ResourceLocation requestTable, ResourceLocation offerTable, int maxUses, int xpValue, float priceMultiplier) {
        this.requestTable = requestTable;
        this.offerTable = offerTable;
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
            LootTable requestedTable = minecraftServer.getLootTables().get(requestTable);
            LootTable offeredTable = minecraftServer.getLootTables().get(offerTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> requested = requestedTable.getRandomItems(lootContext);
            List<ItemStack> offered = offeredTable.getRandomItems(lootContext);

            ItemStack requestStack = new ItemStack(
                    requested.get(source.nextInt(requested.size())).getItem(),
                    requested.get(source.nextInt(requested.size())).getCount());

            ItemStack offerStack = new ItemStack(
                    offered.get(source.nextInt(offered.size())).getItem(),
                    offered.get(source.nextInt(offered.size())).getCount());

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}