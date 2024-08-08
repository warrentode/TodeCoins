package com.github.warrentode.todecoins.commands;

import com.github.warrentode.todecoins.entity.villager.Numismatist;
import com.github.warrentode.todecoins.entity.villager.trades.NumismatistTrades;
import com.github.warrentode.todecoins.mixin.AbstractVillagerAccessor;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.entity.EntityTypeTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 Author: PssbleTrngle
 <a
 href="https://github.com/PssbleTrngle/DataTrades/blob/1.19/common/src/main/java/com/possible_triangle/data_trades/command/VillagersCommand.java#L95">DataTrades</a> */
public class VillagerTradeCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("trades").requires(it -> it.hasPermission(3))
                .then(Commands.literal("reset").executes(VillagerTradeCommands::resetAllVillagers)
                        .then(Commands.argument("target", EntityArgument.entities())
                                .executes(VillagerTradeCommands::resetTargetedVillagers)
                        )
                )
        );
    }

    private static int resetVillagers(Stream<AbstractVillager> villagers) {
        return (int) villagers.filter(VillagerTradeCommands::reset).count();
    }

    private static int resetTargetedVillagers(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        var targets = EntityArgument.getEntities(context, "target").stream()
                .filter(AbstractVillager.class::isInstance)
                .map(it -> (AbstractVillager) it);
        return resetVillagers(targets);
    }

    private static int resetAllVillagers(CommandContext<CommandSourceStack> context) {
        var server = context.getSource().getServer();
        return resetVillagers(StreamSupport.stream(server.getAllLevels().spliterator(), false)
                .flatMap(level -> level.getEntities(EntityTypeTest.forClass(AbstractVillager.class), $ -> true).stream())
        );
    }

    private static boolean reset(AbstractVillager entity) {
        if (entity instanceof WanderingTrader trader) {
            return resetTrader(trader);
        }
        if (entity instanceof Villager villager) {
            return resetVillager(villager);
        }
        return false;
    }

    @SuppressWarnings("SameReturnValue")
    private static boolean resetTrader(WanderingTrader trader) {
        var offers = new MerchantOffers();

        if (trader instanceof Numismatist) {
            {
                var trades = NumismatistTrades.NUMISMATIST_TRADES.get(1);
                var tradeCount = 5;

                var shuffled = Arrays.asList(trades);
                Collections.shuffle(shuffled, new Random(trader.getRandom().nextLong()));
                shuffled.subList(0, Math.min(shuffled.size(), tradeCount)).stream()
                        .map(it -> it.getOffer(trader, trader.getRandom()))
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            }

            {
                var trades = NumismatistTrades.NUMISMATIST_TRADES.get(2);
                var tradeCount = 1;

                var shuffled = Arrays.asList(trades);
                Collections.shuffle(shuffled, new Random(trader.getRandom().nextLong()));
                shuffled.subList(0, Math.min(shuffled.size(), tradeCount)).stream()
                        .map(it -> it.getOffer(trader, trader.getRandom()))
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            }

            var accessor = (AbstractVillagerAccessor) trader;
            accessor.setOffers(offers);
        }

        else if (trader instanceof WanderingTrader) {
            {
                var trades = VillagerTrades.WANDERING_TRADER_TRADES.get(1);
                var tradeCount = 2;

                var shuffled = Arrays.asList(trades);
                Collections.shuffle(shuffled, new Random(trader.getRandom().nextLong()));
                shuffled.subList(0, Math.min(shuffled.size(), tradeCount)).stream()
                        .map(it -> it.getOffer(trader, trader.getRandom()))
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            }

            {
                var trades = VillagerTrades.WANDERING_TRADER_TRADES.get(2);
                var tradeCount = 1;

                var shuffled = Arrays.asList(trades);
                Collections.shuffle(shuffled, new Random(trader.getRandom().nextLong()));
                shuffled.subList(0, Math.min(shuffled.size(), tradeCount)).stream()
                        .map(it -> it.getOffer(trader, trader.getRandom()))
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            }

            var accessor = (AbstractVillagerAccessor) trader;
            accessor.setOffers(offers);
        }

        return true;
    }

    private static boolean resetVillager(Villager villager) {
        var offers = new MerchantOffers();
        var data = villager.getVillagerData();

        var trades = VillagerTrades.TRADES.get(data.getProfession());
        if (trades == null || trades.isEmpty()) {
            return false;
        }

        for (int level = 1; level <= data.getLevel(); level++) {
            var listings = trades.get(level);
            var tradeCount = 2;
            if (listings == null) {
                continue;
            }

            var shuffled = Arrays.asList(listings);
            Collections.shuffle(shuffled, new Random(villager.getRandom().nextLong()));
            shuffled.subList(0, Math.min(shuffled.size(), tradeCount)).stream()
                    .map(it -> it.getOffer(villager, villager.getRandom()))
                    .filter(Objects::nonNull)
                    .forEach(offers::add);
        }

        villager.setOffers(offers);
        return true;
    }
}