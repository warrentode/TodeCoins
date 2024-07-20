package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class SUSStewForLootTable implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final MobEffect effect;
    private final int duration;
    private final ResourceLocation requestTable;

    public SUSStewForLootTable(MobEffect effect, int duration, ResourceLocation requestTable, int maxUses, int xpValue, float priceMultiplier) {
        this.effect = effect;
        this.duration = duration;
        this.requestTable = requestTable;
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
            LootTable requestedTable = minecraftServer.getLootTables().get(requestTable);

            LootContext lootContext = new LootContext.Builder(minecraftServer.createCommandSourceStack().getLevel())
                    .withParameter(LootContextParams.ORIGIN, trader.position())
                    .withParameter(LootContextParams.THIS_ENTITY, trader)
                    .withRandom(trader.level.random).create(LootContextParamSets.GIFT);

            List<ItemStack> requested = requestedTable.getRandomItems(lootContext);

            ItemStack requestStack = new ItemStack(
                    requested.get(source.nextInt(requested.size())).getItem(),
                    requested.get(source.nextInt(requested.size())).getCount());

            ItemStack offeredBowl = new ItemStack(Items.SUSPICIOUS_STEW, 1);
            saveMobEffect(offeredBowl, this.effect, this.duration);

            return new MerchantOffer(requestStack, offeredBowl, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }

    public void saveMobEffect(ItemStack bowlStack, MobEffect mobEffect, int effectDuration) {
        CompoundTag compoundTag = bowlStack.getOrCreateTag();
        ListTag listTag = compoundTag.getList("Effects", 9);
        CompoundTag compoundTag1 = new CompoundTag();
        compoundTag1.putInt("EffectId", MobEffect.getId(mobEffect));
        net.minecraftforge.common.ForgeHooks.saveMobEffect(compoundTag1, "forge:effect_id", mobEffect);
        compoundTag1.putInt("EffectDuration", effectDuration);
        listTag.add(compoundTag1);
        compoundTag.put("Effects", listTag);
    }
}