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
            LootTable requestTable = minecraftServer.getLootTables().get(this.requestedTagTable);
            LootTable offerTable = minecraftServer.getLootTables().get(this.offeredTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> requesting = requestTable.getRandomItems(lootContext);
            List<ItemStack> offering = offerTable.getRandomItems(lootContext);

            if (requesting.isEmpty()) {
                TodeCoins.LOGGER.warn("Requested loot table '{}' returned no items.", requestTable); // Log the warning
            }
            if (offering.isEmpty()) {
                TodeCoins.LOGGER.warn("Offered loot table '{}' returned no items.", offerTable); // Log the warning
            }

            ItemStack requestStack = new ItemStack(
                    requesting.get(source.nextInt(offering.size())).getItem(), this.requestedTagCount);
            ItemStack offerStack = new ItemStack(
                    offering.get(source.nextInt(offering.size())).getItem(),
                    offering.get(source.nextInt(offering.size())).getCount());

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}