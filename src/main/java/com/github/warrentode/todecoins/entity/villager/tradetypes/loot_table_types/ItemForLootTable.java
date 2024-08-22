package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table_types;

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

public class ItemForLootTable implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ItemStack requestItem;
    private final int requestItemCount;
    private final ResourceLocation offerLootTable;

    public ItemForLootTable(ItemStack requestItem, int requestItemCount, ResourceLocation offerLootTable, int maxUses, int xpValue, float priceMultiplier) {
        this.requestItem = requestItem;
        this.requestItemCount = requestItemCount;
        this.offerLootTable = offerLootTable;
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
            LootTable offerTable = minecraftServer.getLootTables().get(offerLootTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> offered = offerTable.getRandomItems(lootContext);

            ItemStack requestStack = new ItemStack(this.requestItem.getItem(), this.requestItemCount);
            ItemStack offerStack = new ItemStack(
                    offered.get(source.nextInt(offered.size())).getItem(),
                    offered.get(source.nextInt(offered.size())).getCount());

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}