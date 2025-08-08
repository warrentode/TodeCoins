package com.github.warrentode.todecoins.entity.trades.tradetypes.loot_table_types;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.config.Config;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LootTableAndItemForEnchantedItem implements VillagerTrades.ItemListing {
    private final ItemStack offerItem;
    private final ResourceLocation requestTable;
    private final ItemStack requestItem;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public LootTableAndItemForEnchantedItem(ItemStack offerItem, ResourceLocation requestTable, ItemStack requestItem,
                                            int maxUses, int xpValue, float priceMultiplier) {
        this.offerItem = offerItem;
        this.requestTable = requestTable;
        this.requestItem = requestItem;
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

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);
            List<ItemStack> requested = requestedTable.getRandomItems(lootContext);

            if (requested.isEmpty()) {
                TodeCoins.LOGGER.warn("Requested loot table '{}' returned no items.", requestedTable); // Log the warning
                return null;
            }

            ItemStack requestStack = requested.get(source.nextInt(requested.size())).copy();

            int i = 5 + source.nextInt(15);
            ItemStack enchantedItem = EnchantmentHelper.enchantItem(source,
                    new ItemStack(this.offerItem.getItem()), i,
                    Config.getAllowTreasureEnchantments());

            return new MerchantOffer(requestStack, this.requestItem, enchantedItem, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}