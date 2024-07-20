package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table;

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

public class MapForLootTablesTradeType implements VillagerTrades.ItemListing {
    public final ResourceLocation currencyLootTable;
    public final ResourceLocation secondaryRequestLootTable;
    public final TagKey<Structure> structureTag;
    public final String mapName;
    public final MapDecoration.Type mapMarker;
    public final int maxUses;
    public final int tradeXP;
    public final float priceMultiplier;

    public MapForLootTablesTradeType(ResourceLocation currencyLootTable, ResourceLocation secondaryRequestLootTable,
                                     TagKey<Structure> structureTag, String mapName, MapDecoration.Type mapMarker,
                                     int maxUses, int tradeXP, float priceMultiplier) {
        this.currencyLootTable = currencyLootTable;
        this.secondaryRequestLootTable = secondaryRequestLootTable;
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
                LootTable currencyTable = minecraftServer.getLootTables().get(currencyLootTable);
                LootTable requestedTable = minecraftServer.getLootTables().get(secondaryRequestLootTable);

                LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                        .withParameter(LootContextParams.ORIGIN, trader.position())
                        .withParameter(LootContextParams.THIS_ENTITY, trader)
                        .withRandom(trader.level.random).create(LootContextParamSets.GIFT);
                List<ItemStack> currency = currencyTable.getRandomItems(lootContext);
                List<ItemStack> requested = requestedTable.getRandomItems(lootContext);

                ItemStack offeredMap = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte) 2, true, true);
                MapItem.renderBiomePreviewMap(serverlevel, offeredMap);
                MapItemSavedData.addTargetDecoration(offeredMap, blockpos, "+", this.mapMarker);
                offeredMap.setHoverName(Component.translatable(this.mapName));

                ItemStack currencyStack = new ItemStack(
                        currency.get(source.nextInt(currency.size())).getItem(),
                        currency.get(source.nextInt(currency.size())).getCount());
                ItemStack requestStack = new ItemStack(
                        requested.get(source.nextInt(requested.size())).getItem());

                return new MerchantOffer(currencyStack, requestStack, offeredMap, this.maxUses, this.tradeXP, this.priceMultiplier);
            }
            else {
                return null;
            }
        }
    }
}