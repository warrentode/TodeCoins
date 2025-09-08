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

public class TwoLootTableForLootTable implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ResourceLocation offerTable;
    private final ResourceLocation requestTable1;
    private final ResourceLocation requestTable2;

    public TwoLootTableForLootTable(ResourceLocation offerTable, ResourceLocation requestTable1, ResourceLocation requestTable2, int maxUses, int xpValue, float priceMultiplier) {
        this.offerTable = offerTable;
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
            LootTable offerTable = minecraftServer.getLootData().getLootTable(this.offerTable);
            LootTable requestTable1 = minecraftServer.getLootData().getLootTable(this.requestTable1);
            LootTable requestTable2 = minecraftServer.getLootData().getLootTable(this.requestTable2);

            LootParams.Builder builder = new LootParams.Builder((ServerLevel) trader.level);
            builder.withParameter(LootContextParams.ORIGIN, trader.position());
            builder.withParameter(LootContextParams.THIS_ENTITY, trader);

            LootParams lootParams = builder.create(LootContextParamSets.GIFT);

            List<ItemStack> requested1 = requestTable1.getRandomItems(lootParams);
            List<ItemStack> requested2 = requestTable2.getRandomItems(lootParams);
            List<ItemStack> offered = offerTable.getRandomItems(lootParams);

            if (requested1.isEmpty()) {
                TC_LOGGER.warn("First requested loot table '{}' returned no items.", requestTable1); // Log the warning
                return null;
            }
            if (requested2.isEmpty()) {
                TC_LOGGER.warn("Second requested loot table '{}' returned no items.", requestTable2); // Log the warning
                return null;
            }
            if (offered.isEmpty()) {
                TC_LOGGER.warn("Offered loot table '{}' returned no items.", offerTable); // Log the warning
                return null;
            }

            ItemStack offerStack = offered.get(source.nextInt(offered.size())).copy();
            ItemStack requestStack1 = requested1.get(source.nextInt(requested1.size())).copy();
            ItemStack requestStack2 = requested2.get(source.nextInt(requested2.size())).copy();

            return new MerchantOffer(requestStack1, requestStack2, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}