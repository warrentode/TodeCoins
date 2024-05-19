package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table;

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

public class TwoLootTableForEnchanted implements VillagerTrades.ItemListing {
    private final ItemStack sellItem;
    private final ResourceLocation currencyLootTable1;
    private final ResourceLocation currencyLootTable2;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public TwoLootTableForEnchanted(ItemStack sellItem, ResourceLocation currencyLootTable1,
                                    ResourceLocation currencyLootTable2,
                                    int maxUses, int xpValue, float priceMultiplier) {
        this.sellItem = sellItem;
        this.currencyLootTable1 = currencyLootTable1;
        this.currencyLootTable2 = currencyLootTable2;
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
            LootTable currencyTable1 = minecraftServer.getLootTables().get(currencyLootTable1);
            LootTable currencyTable2 = minecraftServer.getLootTables().get(currencyLootTable2);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);
            List<ItemStack> currency1 = currencyTable1.getRandomItems(lootContext);
            List<ItemStack> currency2 = currencyTable2.getRandomItems(lootContext);

            ItemStack requestStack1 = new ItemStack(
                    currency1.get(source.nextInt(currency1.size())).getItem(),
                    currency1.get(source.nextInt(currency1.size())).getCount());
            ItemStack requestStack2 = new ItemStack(
                    currency2.get(source.nextInt(currency1.size())).getItem(),
                    currency2.get(source.nextInt(currency2.size())).getCount());

            int i = 5 + source.nextInt(15);
            ItemStack enchantedItem = EnchantmentHelper.enchantItem(source, new ItemStack(this.sellItem.getItem()), i, false);

            return new MerchantOffer(requestStack1, requestStack2, enchantedItem, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}