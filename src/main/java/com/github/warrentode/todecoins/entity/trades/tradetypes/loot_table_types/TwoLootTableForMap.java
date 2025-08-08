package com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types;

import com.github.warrentode.todecoins.TodeCoins;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class TwoLootTableForMap implements VillagerTrades.ItemListing {
    private final ResourceLocation requestTable1;
    private final ResourceLocation requestTable2;
    private final TagKey<Structure> structureTag;
    private final String mapName;
    private final MapDecoration.Type mapMarker;
    private final int maxUses;
    private final int tradeXP;
    private final float priceMultiplier;

    public TwoLootTableForMap(ResourceLocation requestTable1, ResourceLocation requestTable2,
                              TagKey<Structure> structureTag, String mapName, MapDecoration.Type mapMarker,
                              int maxUses, int tradeXP, float priceMultiplier) {
        this.requestTable1 = requestTable1;
        this.requestTable2 = requestTable2;
        this.structureTag = structureTag;
        this.mapName = mapName;
        this.mapMarker = mapMarker;
        this.maxUses = maxUses;
        this.tradeXP = tradeXP;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        if (!(trader.level instanceof ServerLevel serverlevel)) {
            return null;
        }
        else {
            MinecraftServer minecraftServer = trader.level.getServer();
            BlockPos blockpos = serverlevel.findNearestMapStructure(this.structureTag, trader.blockPosition(), 100, true);
            if (blockpos != null) {
                LootTable requestTable1 = minecraftServer.getLootTables().get(this.requestTable1);
                LootTable requestTable2 = minecraftServer.getLootTables().get(this.requestTable2);

                LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                        .withParameter(LootContextParams.ORIGIN, trader.position())
                        .withParameter(LootContextParams.THIS_ENTITY, trader)
                        .withRandom(trader.level.random).create(LootContextParamSets.GIFT);
                List<ItemStack> request1 = requestTable1.getRandomItems(lootContext);
                List<ItemStack> request2 = requestTable2.getRandomItems(lootContext);

                if (request2.isEmpty()) {
                    TodeCoins.LOGGER.warn("First requested loot table '{}' returned no items.", requestTable2); // Log the warning
                    return null;
                }
                if (request1.isEmpty()) {
                    TodeCoins.LOGGER.warn("Second requested loot table '{}' returned no items.", requestTable1); // Log the warning
                    return null;
                }

                ItemStack offeredMap = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte) 2, true, true);
                MapItem.renderBiomePreviewMap(serverlevel, offeredMap);
                MapItemSavedData.addTargetDecoration(offeredMap, blockpos, "+", this.mapMarker);
                offeredMap.setHoverName(Component.translatable(this.mapName));

                ItemStack requestStack1 = request1.get(source.nextInt(request1.size())).copy();
                ItemStack requestStack2 = request2.get(source.nextInt(request2.size())).copy();

                return new MerchantOffer(requestStack1, requestStack2, offeredMap, this.maxUses, this.tradeXP, this.priceMultiplier);
            }
            else {
                return null;
            }
        }
    }
}