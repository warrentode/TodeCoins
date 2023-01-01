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
            ItemStack stack = new ItemStack(ModBlocks.GOLD_COIN_BAG.get(), 6);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 1),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModBlocks.GOLD_COIN_BAG.get(), 6),
                    stack, 16, 8, 0.02F));
        }


        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 16),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COPPER_BANK_NOTE.get(), 16);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModBlocks.GOLD_COIN_BAG.get(), 6),
                    stack, 16, 8, 0.02F));
        }


        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 2);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 2),
                    stack, 16, 8, 0.02F));
        }

        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 2);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 2),
                    stack, 16, 8, 0.02F));
        }

        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.NETHERITE_COIN.get(), 2),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.PRISMARINE_SHARD, 1),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.PRISMARINE_SHARD, 2),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.PRISMARINE_SHARD, 4),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_HALF_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.PRISMARINE_CRYSTALS, 1),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.PRISMARINE_CRYSTALS, 2),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Blocks.COAL_BLOCK, 18),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.REDSTONE, 32),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.AMETHYST_SHARD, 64),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Blocks.AMETHYST_BLOCK, 16),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Blocks.QUARTZ_BLOCK, 48),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 16),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.LAPIS_LAZULI, 16),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Blocks.RED_SAND, 64),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.GUNPOWDER, 16),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.RABBIT_FOOT, 32),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.SCUTE, 64),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BOOK, 64),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.LANTERN, 64),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Blocks.CHISELED_STONE_BRICKS, 64),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.FLINT, 32),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BLAZE_ROD, 3),
                    stack,16,8,0.02F));
        }
        if(event.getType() == ModVillagers.LEPRECHAUN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.ENDER_EYE, 3),
                    stack,16,8,0.02F));
        }

    }
}
