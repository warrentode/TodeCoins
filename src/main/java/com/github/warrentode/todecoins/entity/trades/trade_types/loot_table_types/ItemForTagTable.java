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

public class ItemForTagTable implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ItemStack requestItem;
    private final int requestItemCount;
    private final ResourceLocation offerLootTable;
    private final int offeredTagCount;

    public ItemForTagTable(ItemStack requestItem, int requestItemCount, ResourceLocation offerLootTable, int offeredTagCount, int maxUses, int xpValue, float priceMultiplier) {
        this.requestItem = requestItem;
        this.requestItemCount = requestItemCount;
        this.offerLootTable = offerLootTable;
        this.offeredTagCount = offeredTagCount;
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
            LootTable offerTable = minecraftServer.getLootData().getLootTable(offerLootTable);

            LootParams.Builder builder = new LootParams.Builder((ServerLevel) trader.level);
            builder.withParameter(LootContextParams.ORIGIN, trader.position());
            builder.withParameter(LootContextParams.THIS_ENTITY, trader);

            LootParams lootParams = builder.create(LootContextParamSets.GIFT);

            List<ItemStack> offered = offerTable.getRandomItems(lootParams);

            if (offered.isEmpty()) {
                TC_LOGGER.warn("Offered loot table '{}' returned no items.", offerTable); // Log the warning
                return null;
            }

            ItemStack requestStack = new ItemStack(this.requestItem.getItem(), this.requestItemCount);
            ItemStack offer = offered.get(source.nextInt(offered.size())).copy();
            ItemStack offerStack = new ItemStack(offer.getItem(), this.offeredTagCount);

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}