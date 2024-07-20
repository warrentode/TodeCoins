package com.github.warrentode.todecoins.entity.villager.tradetypes.item_set;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class MapForItemSetTrade implements VillagerTrades.ItemListing {
    private final ImmutableSet<ItemLike> requestedItemSet;
    private final int requestedItemSetCount;
    private final ItemStack requestedItemB;
    private final int requestedItemCountB;
    private final TagKey<Structure> structureTag;
    private final String mapName;
    private final MapDecoration.Type mapMarker;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public MapForItemSetTrade(ImmutableSet<ItemLike> requestedItemSet, int requestedItemSetCount, ItemStack requestedItemB, int requestedItemCountB,
                              TagKey<Structure> structureTag, String mapName, MapDecoration.Type mapMarker,
                              int maxUses, int xpValue, float priceMultiplier) {
        this.requestedItemSet = requestedItemSet;
        this.requestedItemSetCount = requestedItemSetCount;
        this.requestedItemB = requestedItemB;
        this.requestedItemCountB = requestedItemCountB;
        this.structureTag = structureTag;
        this.mapName = mapName;
        this.mapMarker = mapMarker;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        if (!(trader.level instanceof ServerLevel serverlevel)) {
            return null;
        }
        else {
            BlockPos blockpos = serverlevel.findNearestMapStructure(this.structureTag, trader.blockPosition(), 100, true);
            if (blockpos != null) {
                ItemStack offeredMap = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte) 2, true, true);
                MapItem.renderBiomePreviewMap(serverlevel, offeredMap);
                MapItemSavedData.addTargetDecoration(offeredMap, blockpos, "+", this.mapMarker);
                offeredMap.setHoverName(Component.translatable(this.mapName));
                return new MerchantOffer(new ItemStack(this.requestedItemSet.asList().get(source.nextInt(requestedItemSet.size() - 1)).asItem(), this.requestedItemSetCount),
                        new ItemStack(this.requestedItemB.getItem(), this.requestedItemCountB), offeredMap, this.maxUses, this.xpValue, this.priceMultiplier);
            }
            else {
                return null;
            }
        }
    }
}