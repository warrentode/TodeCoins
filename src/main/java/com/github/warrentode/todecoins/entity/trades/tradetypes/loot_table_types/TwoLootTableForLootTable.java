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
            LootTable offerTable = minecraftServer.getLootTables().get(this.offerTable);
            LootTable requestTable1 = minecraftServer.getLootTables().get(this.requestTable1);
            LootTable requestTable2 = minecraftServer.getLootTables().get(this.requestTable2);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> offered = offerTable.getRandomItems(lootContext);
            List<ItemStack> requested1 = requestTable1.getRandomItems(lootContext);
            List<ItemStack> requested2 = requestTable2.getRandomItems(lootContext);

            if (requested1.isEmpty()) {
                TodeCoins.LOGGER.warn("First requested loot table '{}' returned no items.", requestTable1); // Log the warning
                return null;
            }
            if (requested2.isEmpty()) {
                TodeCoins.LOGGER.warn("Second requested loot table '{}' returned no items.", requestTable2); // Log the warning
                return null;
            }
            if (offered.isEmpty()) {
                TodeCoins.LOGGER.warn("Offered loot table '{}' returned no items.", offerTable); // Log the warning
                return null;
            }

            ItemStack offerStack = offered.get(source.nextInt(offered.size())).copy();
            ItemStack requestStack1 = requested1.get(source.nextInt(requested1.size())).copy();
            ItemStack requestStack2 = requested2.get(source.nextInt(requested2.size())).copy();

            return new MerchantOffer(requestStack1, requestStack2, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}