package com.github.warrentode.todecoins.entity.villager.tradetypes.loot_table_types;

import net.minecraft.core.Registry;
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
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class LootTableForPotion implements VillagerTrades.ItemListing {
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;
    private final MobEffect effect;
    private final int duration;
    private final ResourceLocation requestTable;

    public LootTableForPotion(MobEffect effect, int duration, ResourceLocation requestTable, int maxUses, int xpValue, float priceMultiplier) {
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

            //noinspection deprecation
            List<Potion> list = Registry.POTION.stream().filter((potion) ->
                    !potion.getEffects().isEmpty() && PotionBrewing.isBrewablePotion(potion)).toList();
            Potion potion = list.get(source.nextInt(list.size()));

            ItemStack offeredPotion = PotionUtils.setPotion(
                    new ItemStack(Items.POTION, 1), potion);
            saveMobEffect(offeredPotion, this.effect, this.duration);

            return new MerchantOffer(requestStack, offeredPotion, this.maxUses, this.xpValue, this.priceMultiplier);
        }
    }

    public void saveMobEffect(ItemStack potionStack, MobEffect mobEffect, int effectDuration) {
        CompoundTag compoundTag = potionStack.getOrCreateTag();
        ListTag listTag = compoundTag.getList("Effects", 9);
        CompoundTag compoundTag1 = new CompoundTag();
        compoundTag1.putInt("EffectId", MobEffect.getId(mobEffect));
        ForgeHooks.saveMobEffect(compoundTag1, "forge:effect_id", mobEffect);
        compoundTag1.putInt("EffectDuration", effectDuration);
        listTag.add(compoundTag1);
        compoundTag.put("Effects", listTag);
    }
}