package net.warrentode.todecoins.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = TodeCoins.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        // BANKER TRADES SET
        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModBlocks.COPPER_COIN_BAG.get(), 18);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModBlocks.COPPER_COIN_BAG.get(), 18),
                    stack, 16, 8, 0.02F));
        }

        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.IRON_COIN.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.COPPER_COIN.get(), 2),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COPPER_COIN.get(), 2);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.IRON_COIN.get(), 1),
                    stack, 16, 8, 0.02F));
        }

        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.GOLD_COIN.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.IRON_COIN.get(), 2),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.IRON_COIN.get(), 2);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.GOLD_COIN.get(), 1),
                    stack, 16, 8, 0.02F));
        }

        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 64),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.EMERALD, 64);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1),
                    stack, 16, 8, 0.02F));
        }

        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.NETHERITE_COIN.get(), 2);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1),
                    stack, 16, 8, 0.02F));
        }
        if(event.getType() == ModVillagers.BANKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.NETHERITE_COIN.get(), 2),
                    stack,16,8,0.02F));
        }

        // LEPRECHAUN TRADES SET
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 1);
            int villagerLevel = 1;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModBlocks.GOLD_COIN_BAG.get(), 6),
                    stack, 16, 8, 0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModBlocks.GOLD_COIN_BAG.get(), 6);
            int villagerLevel = 1;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 1),
                    stack,16,8,0.02F));
        }

        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 2;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 16),
                    stack, 16, 8, 0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 16);
            int villagerLevel = 2;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1),
                    stack,16,8,0.02F));
        }

        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1);
            int villagerLevel = 3;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 32),
                    stack, 16, 8, 0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 32);
            int villagerLevel = 3;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1),
                    stack,16,8,0.02F));
        }

        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
            int villagerLevel = 4;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 64),
                    stack, 16, 8, 0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 64);
            int villagerLevel = 4;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1),
                    stack,16,8,0.02F));
        }

        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.ENDER_EYE, 1);
            int villagerLevel = 5;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 5),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BLAZE_ROD, 1);
            int villagerLevel = 5;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 5),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.PRISMARINE_SHARD, 1);
            int villagerLevel = 5;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.PRISMARINE_CRYSTALS, 1);
            int villagerLevel = 5;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 2),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.PRISMARINE_SHARD, 1);
            int villagerLevel = 5;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.SEA_LANTERN, 1);
            int villagerLevel = 5;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 7),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Blocks.NETHERITE_BLOCK, 1);
            int villagerLevel = 5;
            //price
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 18),
                    stack,16,8,0.02F));
        }

    }
}
