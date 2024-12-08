package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table_types;

import com.github.warrentode.todecoins.TodeCoins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LootTableForSpecifiedEnchantmentLootTable implements VillagerTrades.ItemListing {
    private final ResourceLocation enchantedTable;
    private final ResourceLocation requestedLootTable;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final EnchantmentInstance[] enchantments;
    private final int enchantmentLevel;

    public LootTableForSpecifiedEnchantmentLootTable(ResourceLocation enchantedTable, ResourceLocation requestedLootTable,
                                                     int maxUses, int xpValue, float priceMultiplier, int enchantmentLevel, EnchantmentInstance[] enchantments) {
        this.enchantedTable = enchantedTable;
        this.requestedLootTable = requestedLootTable;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
        this.enchantments = enchantments;
        this.enchantmentLevel = enchantmentLevel;
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

            ItemStack requestStack = new ItemStack(
                    request.get(source.nextInt(request.size())).getItem(),
                    request.get(source.nextInt(request.size())).getCount());

            ItemStack offerStack = new ItemStack(enchantStack.get(source.nextInt(enchantStack.size())).getItem());



            if (requestStack.isEmpty()) {
                TodeCoins.LOGGER.warn("Requested loot table '{}' returned no items.", request); // Log the warning
            }
            if (enchantStack.isEmpty()) {
                TodeCoins.LOGGER.warn("Offered loot table '{}' returned no items.", enchanted); // Log the warning
            }

            if (offerStack.getItem() == Items.ENCHANTED_BOOK) {
                EnchantmentHelper.setEnchantments(Stream.of(this.enchantments).collect(Collectors.toMap(o -> o.enchantment, e -> e.level)), offerStack);
            }
            else {
                for (EnchantmentInstance data : this.enchantments) {
                    offerStack.enchant(data.enchantment, enchantmentLevel);
                }
            }

            return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }
}