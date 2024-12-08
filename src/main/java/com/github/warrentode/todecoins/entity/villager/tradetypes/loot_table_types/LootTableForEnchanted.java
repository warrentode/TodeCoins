package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table_types;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.config.CommonConfig;
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

public class LootTableForEnchanted implements VillagerTrades.ItemListing {
    private final ItemStack sellItem;
    private final ResourceLocation currencyLootTable;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public LootTableForEnchanted(ItemStack sellItem, ResourceLocation currencyLootTable,
                                 int maxUses, int xpValue, float priceMultiplier) {
        this.sellItem = sellItem;
        this.currencyLootTable = currencyLootTable;
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
            LootTable currencyTable1 = minecraftServer.getLootTables().get(currencyLootTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);
            List<ItemStack> currency1 = currencyTable1.getRandomItems(lootContext);

            if (currency1.isEmpty()) {
                TodeCoins.LOGGER.warn("Requested loot table '{}' returned no items.", currencyTable1); // Log the warning
            }

            ItemStack requestStack1 = new ItemStack(
                    currency1.get(source.nextInt(currency1.size())).getItem(),
                    currency1.get(source.nextInt(currency1.size())).getCount());

            int i = 5 + source.nextInt(15);
            ItemStack enchantedItem = EnchantmentHelper.enchantItem(source,
                    new ItemStack(this.sellItem.getItem()), i,
                    CommonConfig.getAllowTreasureEnchantments());

            return new MerchantOffer(requestStack1, enchantedItem, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}