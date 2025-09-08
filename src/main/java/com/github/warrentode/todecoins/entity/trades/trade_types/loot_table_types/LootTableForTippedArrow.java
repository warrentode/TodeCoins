package com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

public class LootTableForTippedArrow implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ItemStack tippedArrow;
    private final int tippedArrowCount;
    private final ResourceLocation requestTable;
    private final ItemStack requestedArrow;
    private final int requestedArrowCount;

    public LootTableForTippedArrow(ResourceLocation requestTable, int requestedArrowCount, int maxUses, int xpValue, float priceMultiplier) {
        this.requestTable = requestTable;
        this.requestedArrow = Items.ARROW.asItem().getDefaultInstance();
        this.requestedArrowCount = requestedArrowCount;
        this.tippedArrow = new ItemStack(Items.TIPPED_ARROW.asItem().getDefaultInstance().getItem());
        this.tippedArrowCount = requestedArrowCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        if (!(trader.level instanceof ServerLevel)) {
            return null;
        }
        else {
            MinecraftServer minecraftServer = trader.level.getServer();
            LootTable requestedTable = minecraftServer.getLootData().getLootTable(requestTable);

            LootParams.Builder builder = new LootParams.Builder((ServerLevel) trader.level);
            builder.withParameter(LootContextParams.ORIGIN, trader.position());
            builder.withParameter(LootContextParams.THIS_ENTITY, trader);

            LootParams lootParams = builder.create(LootContextParamSets.GIFT);

            List<ItemStack> requested = requestedTable.getRandomItems(lootParams);

            if (requested.isEmpty()) {
                TC_LOGGER.warn("Requested loot table '{}' returned no items.", requestedTable); // Log the warning
                return null;
            }

            ItemStack requestStack = requested.get(source.nextInt(requested.size())).copy();

            List<Potion> list = ForgeRegistries.POTIONS.getValues().stream().filter((potion) ->
                    !potion.getEffects().isEmpty() && PotionBrewing.isBrewablePotion(potion)).toList();
            Potion potion = list.get(source.nextInt(list.size()));
            ItemStack offeredTippedArrow = PotionUtils.setPotion(
                    new ItemStack(this.tippedArrow.getItem(),
                            this.tippedArrowCount), potion);

            return new MerchantOffer(requestStack,
                    new ItemStack(this.requestedArrow.getItem(),
                            this.requestedArrowCount), offeredTippedArrow, this.maxUses,
                    this.xpValue, this.priceMultiplier);
        }

    }
}