package com.github.warrentode.todecoins.entity.villager.trades.tradetypes.loot_table;

import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LootBoxForTwoLootTableItemsTrade implements VillagerTrades.ItemListing {
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
    private final ResourceLocation currencyLootTable1;
    private final ResourceLocation currencyLootTable2;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private ResourceLocation lootTable;

    public LootBoxForTwoLootTableItemsTrade(ItemStack lootChest, String displayName, ResourceLocation lootTable,
                                            ResourceLocation currencyLootTable1, ResourceLocation currencyLootTable2,
                                            int maxUses, int xpValue, float priceMultiplier) {
        this.lootChest = lootChest;
        this.displayName = displayName;
        this.lootTable = lootTable;
        this.currencyLootTable1 = currencyLootTable1;
        this.currencyLootTable2 = currencyLootTable2;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack sellStack = new ItemStack(this.lootChest.getItem(), this.coinPackCount);

        setLootTable(sellStack, this.lootTable, source.nextLong());

        sellStack.setHoverName(Component.translatable(this.displayName));

        MinecraftServer minecraftServer = ServerLifecycleHooks.getCurrentServer().getPlayerList().getServer();
        LootTable currencyTable1 = minecraftServer.getLootTables().get(currencyLootTable1);
        LootTable currencyTable2 = minecraftServer.getLootTables().get(currencyLootTable2);

        LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                .withParameter(LootContextParams.ORIGIN, trader.position())
                .withParameter(LootContextParams.THIS_ENTITY, trader)
                .withRandom(trader.level.random).create(LootContextParamSets.GIFT);
        List<ItemStack> currency1 = currencyTable1.getRandomItems(lootContext);
        List<ItemStack> currency2 = currencyTable2.getRandomItems(lootContext);

        ItemStack requestStack1 = new ItemStack(currency1.get(source.nextInt(1)).getItem(), 1);
        ItemStack requestStack2 = new ItemStack(currency2.get(source.nextInt(1)).getItem(), 1);

        return new MerchantOffer(requestStack1, requestStack2, sellStack, this.maxUses, this.xpValue, this.priceMultiplier);
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