package com.github.warrentode.todecoins.entity.villager.trades.tradetypes;

import com.github.warrentode.todecoins.util.tags.ModTags;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LootBoxForTwoRequestSetsTrade implements VillagerTrades.ItemListing {
    public static final int DEFAULT_SUPPLY = 12;
    public static final int COMMON_ITEMS_SUPPLY = 16;
    public static final int UNCOMMON_ITEMS_SUPPLY = 3;
    public static final int XP_LEVEL_1_SELL = 1;
    public static final int XP_LEVEL_1_BUY = 2;
    public static final int XP_LEVEL_2_SELL = 5;
    public static final int XP_LEVEL_2_BUY = 10;
    public static final int XP_LEVEL_3_SELL = 10;
    public static final int XP_LEVEL_3_BUY = 20;
    public static final int XP_LEVEL_4_SELL = 15;
    public static final int XP_LEVEL_4_BUY = 30;
    public static final int XP_LEVEL_5_TRADE = 30;
    public static final float LOW_TIER_PRICE_MULTIPLIER = 0.05F;
    public static final float HIGH_TIER_PRICE_MULTIPLIER = 0.2F;

    private final ItemStack lootChest;
    private final int coinPackCount = 1;
    private final String displayName;
    private final ImmutableSet<ItemLike> requestItemsA;
    private final int requestItemsCountA;
    private final ImmutableSet<ItemLike> requestItemsB;
    private final int requestItemsCountB;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private ResourceLocation lootTable;

    public LootBoxForTwoRequestSetsTrade(ItemStack lootChest, String displayName, ResourceLocation lootTable, ImmutableSet<ItemLike> requestItemsA, int requestItemsCountA, ImmutableSet<ItemLike> requestItemsB, int requestItemsCountB, int maxUses, int xpValue, float priceMultiplier) {
        this.lootChest = lootChest;
        this.displayName = displayName;
        this.lootTable = lootTable;
        this.requestItemsA = requestItemsA;
        this.requestItemsCountA = requestItemsCountA;
        this.requestItemsB = requestItemsB;
        this.requestItemsCountB = requestItemsCountB;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack sellStack = new ItemStack(this.lootChest.getItem(), this.coinPackCount);

        setLootTable(sellStack, this.lootTable, source.nextLong());

        sellStack.setHoverName(Component.translatable(this.displayName));

        ItemStack requestSetA = new ItemStack(this.requestItemsA.asList().get(source.nextInt(requestItemsA.size() - 1)).asItem(), this.requestItemsCountA);
        ItemStack requestSetB = new ItemStack(this.requestItemsB.asList().get(source.nextInt(requestItemsB.size() - 1)).asItem(), this.requestItemsCountB);
        return new MerchantOffer(requestSetA, requestSetB, sellStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }

    public BlockEntity getBlockEntity() {
        ItemStack stack = this.lootChest.getItem().getDefaultInstance();
        if (stack == Items.TRAPPED_CHEST.getDefaultInstance()) {
            return new TrappedChestBlockEntity(BlockPos.ZERO, Blocks.TRAPPED_CHEST.defaultBlockState());
        }
        else if (stack == Items.BARREL.getDefaultInstance()) {
            return new BarrelBlockEntity(BlockPos.ZERO, Blocks.BARREL.defaultBlockState());
        }
        else if (stack.is(ModTags.Items.SHULKER_BOXES)) {
            return new ShulkerBoxBlockEntity(BlockPos.ZERO, Blocks.SHULKER_BOX.defaultBlockState());
        }
        else {
            return new ChestBlockEntity(BlockPos.ZERO, Blocks.CHEST.defaultBlockState());
        }
    }

    private void setLootTable(@NotNull ItemStack stack, ResourceLocation lootTable, long lootTableSeed) {
        RandomizableContainerBlockEntity blockEntity = (RandomizableContainerBlockEntity) getBlockEntity();
        blockEntity.setLootTable(lootTable, lootTableSeed);

        CompoundTag blockEntityTag = stack.getOrCreateTagElement("BlockEntityTag");
        blockEntityTag.putString("LootTable", lootTable.toString());
        blockEntityTag.putLong("LootTableSeed", lootTableSeed);
        stack.save(blockEntityTag);
    }
}