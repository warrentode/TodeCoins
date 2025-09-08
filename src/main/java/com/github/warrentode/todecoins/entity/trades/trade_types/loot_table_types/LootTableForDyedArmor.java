package com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types;

import com.google.common.collect.Lists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.DyeableLeatherItem;
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

public class LootTableForDyedArmor implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ResourceLocation requestTable;
    private final ResourceLocation offerTable;

    public LootTableForDyedArmor(ResourceLocation requestTable, ResourceLocation offerTable, int maxUses, int xpValue, float priceMultiplier) {
        this.requestTable = requestTable;
        this.offerTable = offerTable;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        if (!(trader.level instanceof ServerLevel)) {
            return null;
        }
        else {
            MinecraftServer minecraftServer = trader.level.getServer();
            LootTable requestedTable = minecraftServer.getLootData().getLootTable(requestTable);
            LootTable offeredTable = minecraftServer.getLootData().getLootTable(offerTable);

            LootParams.Builder builder = new LootParams.Builder((ServerLevel) trader.level);
            builder.withParameter(LootContextParams.ORIGIN, trader.position());
            builder.withParameter(LootContextParams.THIS_ENTITY, trader);

            LootParams lootParams = builder.create(LootContextParamSets.GIFT);

            List<ItemStack> requested = requestedTable.getRandomItems(lootParams);
            List<ItemStack> offered = offeredTable.getRandomItems(lootParams);

            if (requested.isEmpty()) {
                TC_LOGGER.warn("Requested loot table '{}' returned no items.", requestedTable); // Log the warning
                return null;
            }
            if (offered.isEmpty()) {
                TC_LOGGER.warn("Offered loot table '{}' returned no items.", offeredTable); // Log the warning
                return null;
            }

            ItemStack requestStack = requested.get(source.nextInt(requested.size())).copy();
            ItemStack offerStack = offered.get(source.nextInt(offered.size())).copy();

            if (offerStack.getItem() instanceof DyeableLeatherItem) {
                List<DyeItem> list = Lists.newArrayList();
                list.add(getRandomDye(source));
                if (source.nextFloat() > 0.7F) {
                    list.add(getRandomDye(source));
                }

                if (source.nextFloat() > 0.8F) {
                    list.add(getRandomDye(source));
                }

                offerStack = DyeableLeatherItem.dyeArmor(offerStack, list);
            }

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }

    private static DyeItem getRandomDye(RandomSource pRandom) {
        return DyeItem.byColor(DyeColor.byId(pRandom.nextInt(16)));
    }
}