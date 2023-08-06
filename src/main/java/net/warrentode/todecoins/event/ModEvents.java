package net.warrentode.todecoins.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.villager.ModVillagers;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.List;
import java.util.Optional;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {

            // BANKER TRADES SET
            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModBlocks.COPPER_COIN_BAG.get(), 18);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.EMERALD, 1);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModBlocks.COPPER_COIN_BAG.get(), 18),
                        stack, 16, 8, 0.02F));
            }

            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.IRON_COIN.get(), 1);
                int villagerLevel = 2;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COPPER_COIN.get(), 2),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.COPPER_COIN.get(), 2);
                int villagerLevel = 2;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.IRON_COIN.get(), 1),
                        stack, 16, 8, 0.02F));
            }

            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.GOLD_COIN.get(), 1);
                int villagerLevel = 3;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.IRON_COIN.get(), 2),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.IRON_COIN.get(), 2);
                int villagerLevel = 3;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.GOLD_COIN.get(), 1),
                        stack, 16, 8, 0.02F));
            }

            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
                int villagerLevel = 4;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 64),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.EMERALD, 64);
                int villagerLevel = 4;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }

            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.NETHERITE_COIN.get(), 2);
                int villagerLevel = 5;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.BANKER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
                int villagerLevel = 5;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.NETHERITE_COIN.get(), 2),
                        stack, 16, 8, 0.02F));
            }

            // LEPRECHAUN TRADES SET
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
                int villagerLevel = 1;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModBlocks.POT_OF_GOLD.get(), 11),
                        stack, 16, 8, 0.02F)
                );
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModBlocks.POT_OF_GOLD.get(), 11);
                int villagerLevel = 1;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }

            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1);
                int villagerLevel = 2;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModBlocks.POT_OF_GOLD.get(), 21),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModBlocks.POT_OF_GOLD.get(), 21);
                int villagerLevel = 2;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }

            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
                int villagerLevel = 3;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModBlocks.POT_OF_GOLD.get(), 43),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModBlocks.POT_OF_GOLD.get(), 43);
                int villagerLevel = 3;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }

            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.PRISMARINE_SHARD, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.REDSTONE_BLOCK, 2);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.NAME_TAG, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.PRISMARINE_CRYSTALS, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.BELL, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.DRAGON_HEAD, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.DRAGON_EGG, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.ELYTRA, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.NETHERITE_SCRAP, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.PRISMARINE, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 4),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.SEA_LANTERN, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 24),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.NETHER_STAR, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 9),
                        stack, 16, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.NETHERITE_INGOT, 1);
                int villagerLevel = 4;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 36),
                        stack, 16, 8, 0.02F));
            }

            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.LUCKY_COIN.get(), 1);
                int villagerLevel = 5;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 3),
                        stack, 16, 8, 0.02F)
                );
            }
            if (event.getType() == ModVillagers.LEPRECHAUN.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 3);
                int villagerLevel = 5;
                //price
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.LUCKY_COIN.get(), 1),
                        stack, 16, 8, 0.02F));
            }

        }

        @SuppressWarnings("SameReturnValue")
        @SubscribeEvent
        public static boolean onLivingDeath(LivingDeathEvent event) {
            LivingEntity entity = event.getEntity();
            Level level = entity.getCommandSenderWorld();
            if (!level.isClientSide) {
                if (entity instanceof ServerPlayer player) {
                    Inventory playerInventory = player.getInventory();
                    DamageSource damageSource = player.getLastDamageSource();
                    ItemStack luckyCoin = null;

                    if (TodeCoins.isCuriosLoaded()) {
                        Optional<SlotResult> optional = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.LUCKY_COIN.get());
                        if (optional.isPresent()) {
                            luckyCoin = optional.get().stack();
                        }
                        else {
                            for (int i = 0; i < playerInventory.getContainerSize(); ++i) {
                                ItemStack stack = playerInventory.getItem(i);
                                if (stack.getItem().equals(ModItems.LUCKY_COIN.get())) {
                                    luckyCoin = stack;
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        for (int i = 0; i < playerInventory.getContainerSize(); ++i) {
                            ItemStack stack = playerInventory.getItem(i);
                            if (stack.getItem().equals(ModItems.LUCKY_COIN.get())) {
                                luckyCoin = stack;
                                break;
                            }
                        }
                    }

                    if (luckyCoin != null) {
                        player.setHealth(1.0F);
                        player.removeAllEffects();
                        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                        if (damageSource != null && damageSource == DamageSource.OUT_OF_WORLD) {
                            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 900, 0));
                        }
                        level.broadcastEntityEvent(player, (byte) 35);
                        luckyCoin.shrink(1);
                        event.setCanceled(true);
                    }
                }
            }
            return false;
        }
    }
}