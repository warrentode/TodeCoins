package com.github.warrentode.todecoins.entity.trades.trade_types.loot_table_types;

import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

public class TwoLootTableForLootBox implements VillagerTrades.ItemListing {
    private final ItemStack lootChest;
    private final String displayName;
    private final ResourceLocation requestTable1;
    private final ResourceLocation requestTable2;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final ResourceLocation lootTable;

    public TwoLootTableForLootBox(ItemStack lootChest, String displayName, ResourceLocation lootTable,
                                  ResourceLocation requestTable1, ResourceLocation requestTable2,
                                  int maxUses, int xpValue, float priceMultiplier) {
        this.lootChest = lootChest;
        this.displayName = displayName;
        this.lootTable = lootTable;
        this.requestTable1 = requestTable1;
        this.requestTable2 = requestTable2;
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
            LootTable requested1 = minecraftServer.getLootData().getLootTable(requestTable1);
            LootTable requested2 = minecraftServer.getLootData().getLootTable(requestTable2);

            LootParams.Builder builder = new LootParams.Builder((ServerLevel) trader.level);
            builder.withParameter(LootContextParams.ORIGIN, trader.position());
            builder.withParameter(LootContextParams.THIS_ENTITY, trader);

            LootParams lootParams = builder.create(LootContextParamSets.GIFT);

            List<ItemStack> request1 = requested1.getRandomItems(lootParams);
            List<ItemStack> request2 = requested2.getRandomItems(lootParams);

            if (request1.isEmpty()) {
                TC_LOGGER.warn("First requested loot table '{}' returned no items.", requested1); // Log the warning
                return null;
            }
            if (request2.isEmpty()) {
                TC_LOGGER.warn("Second requested loot table '{}' returned no items.", requested2); // Log the warning
                return null;
            }

            ItemStack requestStack1 = request1.get(source.nextInt(request1.size())).copy();
            ItemStack requestStack2 = request2.get(source.nextInt(request2.size())).copy();

            int coinPackCount = 1;
            ItemStack sellStack = new ItemStack(this.lootChest.getItem(), coinPackCount);

            setLootTable(sellStack, this.lootTable, source.nextLong());

            sellStack.setHoverName(Component.translatable(this.displayName));

            return new MerchantOffer(requestStack1, requestStack2, sellStack, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }

    public BlockEntity getBlockEntity() {
        ItemStack stack = this.lootChest.getItem().getDefaultInstance();
        if (stack == Items.TRAPPED_CHEST.getDefaultInstance()) {
            return new TrappedChestBlockEntity(BlockPos.ZERO, Blocks.TRAPPED_CHEST.defaultBlockState());
        }
        else if (stack == Items.BARREL.getDefaultInstance()) {
            return new BarrelBlockEntity(BlockPos.ZERO, Blocks.BARREL.defaultBlockState());
        }
        else if (stack.is(TCItemTags.SHULKER_BOXES)) {
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