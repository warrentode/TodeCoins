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

public class LootTableForEnchantedItemTable implements VillagerTrades.ItemListing {
    private final ResourceLocation enchantedTable;
    private final ResourceLocation requestedLootTable;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public LootTableForEnchantedItemTable(ResourceLocation enchantedTable, ResourceLocation requestedLootTable,
                                          int maxUses, int xpValue, float priceMultiplier) {
        this.enchantedTable = enchantedTable;
        this.requestedLootTable = requestedLootTable;
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
            LootTable enchanted = minecraftServer.getLootTables().get(enchantedTable);
            LootTable requested = minecraftServer.getLootTables().get(requestedLootTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> enchantStack = enchanted.getRandomItems(lootContext);
            List<ItemStack> request = requested.getRandomItems(lootContext);


            if (request.isEmpty()) {
                TodeCoins.LOGGER.warn("Requested loot table '{}' returned no items.", requested); // Log the warning
                return null;
            }
            if (enchantStack.isEmpty()) {
                TodeCoins.LOGGER.warn("Offered loot table '{}' returned no items.", enchanted); // Log the warning
                return null;
            }


            ItemStack requestStack = request.get(source.nextInt(request.size())).copy();

            int i = 5 + source.nextInt(15);
            ItemStack offerStack = EnchantmentHelper.enchantItem(source,
                    new ItemStack(enchantStack.get(source.nextInt(enchantStack.size())).getItem()), i,
                    Config.getAllowTreasureEnchantments());

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}