package com.github.warrentode.todecoins.commands;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.config.Config;
import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import com.github.warrentode.todecoins.entity.villager.Numismatist;
import com.github.warrentode.todecoins.mixin.AbstractVillagerAccessor;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.entity.EntityTypeTest;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/** Original Author: PssbleTrngle <a
 href="https://github.com/PssbleTrngle/DataTrades/blob/1.19/common/src/main/java/com/possible_triangle/data_trades/command/VillagersCommand.java#L95">DataTrades</a> */
public class VillagerTradeCommands {
    public static void register(@NotNull CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("trades").requires(it -> it.hasPermission(3))
                        .then(Commands.literal("reset").executes(VillagerTradeCommands::resetAll)
                                .then(Commands.argument("target", EntityArgument.entities())
                                        .executes(VillagerTradeCommands::resetTargeted)
                                )
                        )
        );
    }

    private static int resetAll(@NotNull CommandContext<CommandSourceStack> context) {
        var server = context.getSource().getServer();

        try {
            // Reload trade data before resetting
            TodeCoins.TRADE_OFFER_MANAGER.reload(server);
            TodeCoins.LOGGER.info("Reloading and Resetting Trades");
            context.getSource().sendSystemMessage(Component.literal("Reloading and Resetting all Trade Files").withStyle(ChatFormatting.GRAY));

            // Reset all villagers (wandering trader and numismatist)
            int villagersReset = resetVillagers(StreamSupport.stream(server.getAllLevels().spliterator(), false)
                    .flatMap(level -> level.getEntities(EntityTypeTest.forClass(AbstractVillager.class), entity -> true).stream())
            );

            // Reset all merchants (includes piglin merchant)
            int merchantsReset = resetMerchants(StreamSupport.stream(server.getAllLevels().spliterator(), false)
                    .flatMap(level -> level.getEntities(EntityTypeTest.forClass(Entity.class), entity -> entity instanceof Merchant)
                            .stream()).map(entity -> (Merchant) entity)
            );

            int totalReset = villagersReset + merchantsReset;
            context.getSource().sendSystemMessage(Component.literal("Reloaded and reset trades for " + totalReset + " entities").withStyle(ChatFormatting.GREEN));
            return totalReset;

        }
        catch (Exception exception) {
            TodeCoins.LOGGER.error("Error while resetting all villagers and merchants", exception);
            context.getSource().sendFailure(Component.literal("Failed to reset trades: " + exception.getMessage()));
            return 0;
        }
    }

    private static int resetTargeted(@NotNull CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        var targets = EntityArgument.getEntities(context, "target");

        int villagersReset = resetVillagers(targets.stream().filter(AbstractVillager.class::isInstance).map(AbstractVillager.class::cast));

        int merchantsReset = resetMerchants(targets.stream().filter(Merchant.class::isInstance).map(Merchant.class::cast));

        int totalReset = villagersReset + merchantsReset;

        context.getSource().sendSystemMessage(Component.literal("Reloading and resetting trades for " + totalReset + " targeted entities").withStyle(ChatFormatting.GRAY));
        TodeCoins.LOGGER.info("Reset trades for targeted {} villagers and {} merchants", villagersReset, merchantsReset);

        return totalReset;
    }

    private static int resetVillagers(@NotNull Stream<AbstractVillager> villagers) {
        TodeCoins.LOGGER.info("Checking for villager trades");
        return (int) villagers.filter(VillagerTradeCommands::reset).count();
    }

    private static int resetMerchants(@NotNull Stream<Merchant> merchants) {
        TodeCoins.LOGGER.info("Checking for merchant trades");
        return (int) merchants.filter(VillagerTradeCommands::reset).count();
    }

    private static boolean reset(Merchant entity) {
        if (entity instanceof AbstractVillager abstractVillager) {
            return resetAbstract(abstractVillager);
        }
        if (entity instanceof PiglinMerchant trader) {
            TodeCoins.LOGGER.info("Reset trades for PiglinMerchant: {}", trader);
            return resetTraderPiglin(trader);
        }
        TodeCoins.LOGGER.warn("Reset trades failed for unknown merchant type: {}", entity);
        return false;
    }

    private static boolean resetAbstract(AbstractVillager entity) {
        if (entity instanceof WanderingTrader trader) {
            TodeCoins.LOGGER.info("Reset trades for WanderingTrader: {}", trader);
            return resetTrader(trader);
        }
        if (entity instanceof Villager villager) {
            TodeCoins.LOGGER.info("Reset trades for Villager: {}", villager);
            return resetVillager(villager);
        }
        if (entity instanceof Numismatist trader) {
            TodeCoins.LOGGER.info("Reset trades for Numismatist: {}", trader);
            return resetTrader(trader);
        }
        TodeCoins.LOGGER.warn("Reset trades failed for unknown abstract villager type: {}", entity);
        return false;
    }

    @SuppressWarnings("SameReturnValue")
    private static boolean resetTraderPiglin(@NotNull PiglinMerchant trader) {
        var offers = new MerchantOffers();
        var manager = TodeCoins.TRADE_OFFER_MANAGER;
        var random = new Random(trader.getRandom().nextLong());

        // Common trades
        manager.getPiglinMerchantOffers(TradeOfferManager.MerchantLevel.COMMON).ifPresent(commonTrades -> {
            var tradeCount = Config.getMaxWandererTrades();
            var shuffled = Arrays.asList(commonTrades);
            Collections.shuffle(shuffled, random);
            shuffled.stream()
                    .limit(tradeCount)
                    .map(f -> {
                        var offer = f.getOffer(trader, trader.getRandom());
                        if (offer == null) {
                            TodeCoins.LOGGER.warn("Null piglin merchant common trade offer from factory: {}", f.getClass().getSimpleName());
                        }
                        return offer;
                    })
                    .filter(Objects::nonNull)
                    .forEach(offers::add);
        });

        // Rare trades
        manager.getPiglinMerchantOffers(TradeOfferManager.MerchantLevel.RARE).ifPresent(rareTrades -> {
            var shuffled = Arrays.asList(rareTrades);
            Collections.shuffle(shuffled, random);
            shuffled.stream()
                    .limit(1)
                    .map(f -> {
                        var offer = f.getOffer(trader, trader.getRandom());
                        if (offer == null) {
                            TodeCoins.LOGGER.warn("Null piglin merchant rare trade offer from factory: {}", f.getClass().getSimpleName());
                        }
                        return offer;
                    })
                    .filter(Objects::nonNull)
                    .forEach(offers::add);
        });

        trader.getOffers().clear();
        trader.getOffers().addAll(offers);
        return true;
    }

    @SuppressWarnings("SameReturnValue")
    private static boolean resetTrader(@NotNull WanderingTrader trader) {
        var offers = new MerchantOffers();
        var manager = TodeCoins.TRADE_OFFER_MANAGER;
        var random = new Random(trader.getRandom().nextLong());

        if (trader instanceof Numismatist) {
            // Numismatist common trades
            manager.getNumismatistOffers(TradeOfferManager.MerchantLevel.COMMON).ifPresent(commonTrades -> {
                var tradeCount = Config.getMaxWandererTrades();
                var shuffled = Arrays.asList(commonTrades);
                Collections.shuffle(shuffled, random);
                shuffled.stream()
                        .limit(tradeCount)
                        .map(f -> {
                            var offer = f.getOffer(trader, trader.getRandom());
                            if (offer == null) {
                                TodeCoins.LOGGER.warn("Null numismatist common trade offer from factory: {}", f.getClass().getSimpleName());
                            }
                            return offer;
                        })
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            });

            // Numismatist rare trades
            manager.getNumismatistOffers(TradeOfferManager.MerchantLevel.RARE).ifPresent(rareTrades -> {
                var shuffled = Arrays.asList(rareTrades);
                Collections.shuffle(shuffled, random);
                shuffled.stream()
                        .limit(1)
                        .map(f -> {
                            var offer = f.getOffer(trader, trader.getRandom());
                            if (offer == null) {
                                TodeCoins.LOGGER.warn("Null numismatist rare trade offer from factory: {}", f.getClass().getSimpleName());
                            }
                            return offer;
                        })
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            });

            ((AbstractVillagerAccessor) trader).setOffers(offers);
        }
        else {
            // WanderingTrader common trades
            manager.getWanderingTraderOffers(TradeOfferManager.MerchantLevel.COMMON).ifPresent(commonTrades -> {
                var tradeCount = Config.getMaxWandererTrades();
                var shuffled = Arrays.asList(commonTrades);
                Collections.shuffle(shuffled, random);
                shuffled.stream()
                        .limit(tradeCount)
                        .map(f -> {
                            var offer = f.getOffer(trader, trader.getRandom());
                            if (offer == null) {
                                TodeCoins.LOGGER.warn("Null wandering common trade offer from factory: {}", f.getClass().getSimpleName());
                            }
                            return offer;
                        })
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            });

            // WanderingTrader rare trades
            manager.getWanderingTraderOffers(TradeOfferManager.MerchantLevel.RARE).ifPresent(rareTrades -> {
                var shuffled = Arrays.asList(rareTrades);
                Collections.shuffle(shuffled, random);
                shuffled.stream()
                        .limit(1)
                        .map(f -> {
                            var offer = f.getOffer(trader, trader.getRandom());
                            if (offer == null) {
                                TodeCoins.LOGGER.warn("Null wandering rare trade offer from factory: {}", f.getClass().getSimpleName());
                            }
                            return offer;
                        })
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            });

            ((AbstractVillagerAccessor) trader).setOffers(offers);
        }

        return true;
    }

    private static boolean resetVillager(@NotNull Villager villager) {
        var offers = new MerchantOffers();
        var data = villager.getVillagerData();
        var profession = data.getProfession();
        var level = data.getLevel();

        TradeOfferManager manager = TodeCoins.TRADE_OFFER_MANAGER;
        var optionalTrades = manager.getVillagerOffers(profession);
        if (optionalTrades.isEmpty()) {
            return false;
        }

        var levelToTrades = optionalTrades.get();
        var random = new Random(villager.getRandom().nextLong());

        for (int i = 1; i <= level; i++) {
            var listings = levelToTrades.get(i);
            if (listings == null || listings.isEmpty()) {
                continue;
            }

            var tradeCount = Config.getMaxVillagerTrades();
            var shuffled = new ArrayList<>(listings);
            Collections.shuffle(shuffled, random);

            shuffled.stream()
                    .limit(tradeCount)
                    .map(f -> {
                        var offer = f.getOffer(villager, villager.getRandom());
                        if (offer == null) {
                            TodeCoins.LOGGER.warn("Null villager trade offer from factory: {}", f.getClass().getSimpleName());
                        }
                        return offer;
                    })
                    .filter(Objects::nonNull)
                    .forEach(offers::add);
        }

        villager.setOffers(offers);
        return true;
    }
}