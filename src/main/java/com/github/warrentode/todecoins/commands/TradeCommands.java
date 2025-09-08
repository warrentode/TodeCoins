package com.github.warrentode.todecoins.commands;

import com.github.warrentode.todecoins.Config;
import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import com.github.warrentode.todecoins.entity.trades.BankerTrades;
import com.github.warrentode.todecoins.entity.trades.LeprechaunTrades;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import com.github.warrentode.todecoins.entity.villager.Numismatist;
import com.github.warrentode.todecoins.entity.villager.TCVillagers;
import com.github.warrentode.todecoins.mixin.villagers.AbstractVillagerAccessor;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

/** Original Author: PssbleTrngle <a
 href="https://github.com/PssbleTrngle/DataTrades/blob/1.19/common/src/main/java/com/possible_triangle/data_trades/command/VillagersCommand.java#L95">DataTrades</a> */
public class TradeCommands {
    public static void register(@NotNull CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("trades").requires(it -> it.hasPermission(3))
                        .then(Commands.literal("reset").executes(TradeCommands::resetAll)
                                .then(Commands.argument("target", EntityArgument.entities())
                                        .executes(TradeCommands::resetTargeted)
                                )
                        )
        );
    }

    private static int resetAll(@NotNull CommandContext<CommandSourceStack> context) {
        var server = context.getSource().getServer();

        try {
            // Reload trade data before resetting
            TodeCoins.TRADE_OFFER_MANAGER.reload(server);
            TC_LOGGER.info("Reloading and Resetting Trades");
            context.getSource().sendSystemMessage(Component.literal("Reloading and Resetting all Trade Files").withStyle(ChatFormatting.GRAY));

            // Reset all villagers (wandering trader and numismatist)
            int villagersReset = resetVillagers(StreamSupport.stream(server.getAllLevels().spliterator(), false)
                    .flatMap(level -> level.getEntities(EntityTypeTest.forClass(AbstractVillager.class), entity -> true).stream())
            );

            // Reset all other merchants (such as piglin merchant)
            int merchantsReset = resetMerchants(StreamSupport.stream(server.getAllLevels().spliterator(), false)
                    .flatMap(level -> level.getEntities(EntityTypeTest.forClass(LivingEntity.class), entity -> entity instanceof LivingEntity)
                            .stream()).map(entity -> entity)
            );

            int totalReset = villagersReset + merchantsReset;
            context.getSource().sendSystemMessage(Component.literal("Reloaded and reset trades for " + totalReset + " entities").withStyle(ChatFormatting.GREEN));
            return totalReset;

        }
        catch (Exception exception) {
            TC_LOGGER.error("Error while resetting all villagers and merchants", exception);
            context.getSource().sendFailure(Component.literal("Failed to reset trades: " + exception.getMessage()));
            return 0;
        }
    }

    private static int resetTargeted(@NotNull CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        var targets = EntityArgument.getEntities(context, "target");

        int villagersReset = resetVillagers(targets.stream().filter(AbstractVillager.class::isInstance).map(AbstractVillager.class::cast));

        int merchantsReset = resetMerchants(targets.stream().filter(Objects::nonNull).map(LivingEntity.class::cast));

        int totalReset = villagersReset + merchantsReset;

        context.getSource().sendSystemMessage(Component.literal("Reloading and resetting trades for " + totalReset + " targeted entities").withStyle(ChatFormatting.GRAY));
        TC_LOGGER.info("Reset trades for targeted {} villagers and {} merchants", villagersReset, merchantsReset);

        return totalReset;
    }

    private static int resetVillagers(@NotNull Stream<AbstractVillager> villagers) {
        TC_LOGGER.info("Checking for villager trades");
        return (int) villagers.filter(TradeCommands::reset).count();
    }

    private static int resetMerchants(@NotNull Stream<LivingEntity> merchants) {
        TC_LOGGER.info("Checking for merchant trades");
        return (int) merchants.filter(TradeCommands::reset).count();
    }

    private static boolean reset(LivingEntity entity) {
        if (entity instanceof AbstractVillager abstractVillager) {
            return resetAbstractVillager(abstractVillager);
        }
        if (entity instanceof PiglinMerchant trader) {
            TC_LOGGER.info("Reset trades for PiglinMerchant: {}", trader);
            return resetTraderPiglin(trader);
        }
        if (ModList.get().isLoaded("goblintraders")) {
            EntityType<?> goblinTraderType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse("goblintraders:goblin_trader"));
            EntityType<?> veinGoblinTraderType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse("goblintraders:vein_goblin_trader"));

            if (goblinTraderType != null && entity.getType() == goblinTraderType) {
                return resetGoblin(entity);
            }
            if (veinGoblinTraderType != null && entity.getType() == veinGoblinTraderType) {
                return resetGoblin(entity);
            }
        }
        TC_LOGGER.warn("Reset trades failed for unknown merchant type: {}", entity);
        return false;
    }

    public static boolean resetGoblin(@NotNull Entity entity) {
        if (ModList.get().isLoaded("goblintraders") && Config.getReplaceGoblinTraderTrades()) {
            EntityType<?> goblinTraderType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse("goblintraders:goblin_trader"));
            EntityType<?> veinGoblinTraderType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse("goblintraders:vein_goblin_trader"));

            var offers = new MerchantOffers();
            var manager = TodeCoins.TRADE_OFFER_MANAGER;

            Random random = new Random();
            RandomSource randomSource = RandomSource.create();

            if (entity instanceof Merchant trader) {
                if (goblinTraderType != null && entity.getType() == goblinTraderType) {
                    // Common trades
                    manager.getOffersForGoblinTrader(TradeOfferManager.MerchantLevel.COMMON).ifPresent(commonTrades -> {
                        var tradeCount = Config.getMaxWandererTrades();
                        var shuffled = Arrays.asList(commonTrades);
                        Collections.shuffle(shuffled, random);
                        shuffled.stream()
                                .limit(tradeCount)
                                .map(itemListing -> {
                                    var offer = itemListing.getOffer(entity, randomSource);
                                    if (offer == null) {
                                        TC_LOGGER.warn("Null goblin trader common trade offer from factory: {}", itemListing.getClass().getSimpleName());
                                    }
                                    return offer;
                                })
                                .filter(Objects::nonNull)
                                .forEach(offers::add);
                    });
                    // Rare trades
                    manager.getOffersForGoblinTrader(TradeOfferManager.MerchantLevel.RARE).ifPresent(rareTrades -> {
                        var shuffled = Arrays.asList(rareTrades);
                        Collections.shuffle(shuffled, random);
                        shuffled.stream()
                                .limit(1)
                                .map(itemListing -> {
                                    var offer = itemListing.getOffer(entity, randomSource);
                                    if (offer == null) {
                                        TC_LOGGER.warn("Null goblin trader rare trade offer from factory: {}", itemListing.getClass().getSimpleName());
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
                if (veinGoblinTraderType != null && entity.getType() == veinGoblinTraderType) {
                    // Common trades
                    manager.getOffersForVeinGoblinTrader(TradeOfferManager.MerchantLevel.COMMON).ifPresent(commonTrades -> {
                        var tradeCount = Config.getMaxWandererTrades();
                        var shuffled = Arrays.asList(commonTrades);
                        Collections.shuffle(shuffled, random);
                        shuffled.stream()
                                .limit(tradeCount)
                                .map(itemListing -> {
                                    var offer = itemListing.getOffer(entity, randomSource);
                                    if (offer == null) {
                                        TC_LOGGER.warn("Null vein goblin trader common trade offer from factory: {}", itemListing.getClass().getSimpleName());
                                    }
                                    return offer;
                                })
                                .filter(Objects::nonNull)
                                .forEach(offers::add);
                    });
                    // Rare trades
                    manager.getOffersForVeinGoblinTrader(TradeOfferManager.MerchantLevel.RARE).ifPresent(rareTrades -> {
                        var shuffled = Arrays.asList(rareTrades);
                        Collections.shuffle(shuffled, random);
                        shuffled.stream()
                                .limit(1)
                                .map(itemListing -> {
                                    var offer = itemListing.getOffer(entity, randomSource);
                                    if (offer == null) {
                                        TC_LOGGER.warn("Null vein goblin trader rare trade offer from factory: {}", itemListing.getClass().getSimpleName());
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
            }
        }

        return false;
    }

    public static boolean resetAbstractVillager(AbstractVillager entity) {
        if (ModList.get().isLoaded("supplementaries")) {
            EntityType<?> redMerchantType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse("supplementaries:red_merchant"));

            if (redMerchantType != null && entity.getType() == redMerchantType) {
                TC_LOGGER.info("Reset trades for RedMerchant: {}", entity);
                return resetTrader(entity);
            }
        }
        if (entity instanceof WanderingTrader trader) {
            TC_LOGGER.info("Reset trades for WanderingTrader: {}", trader);
            return resetTrader(trader);
        }
        if (entity instanceof Villager villager) {
            TC_LOGGER.info("Reset trades for Villager: {}", villager);
            return resetVillager(villager);
        }
        if (entity instanceof Numismatist trader) {
            TC_LOGGER.info("Reset trades for Numismatist: {}", trader);
            return resetTrader(trader);
        }
        TC_LOGGER.warn("Reset trades failed for unknown abstract villager type: {}", entity);
        return false;
    }

    @SuppressWarnings("SameReturnValue")
    public static boolean resetTraderPiglin(@NotNull PiglinMerchant trader) {
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
                    .map(itemListing -> {
                        var offer = itemListing.getOffer(trader, trader.getRandom());
                        if (offer == null) {
                            TC_LOGGER.warn("Null piglin merchant common trade offer from factory: {}", itemListing.getClass().getSimpleName());
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
                    .map(itemListing -> {
                        var offer = itemListing.getOffer(trader, trader.getRandom());
                        if (offer == null) {
                            TC_LOGGER.warn("Null piglin merchant rare trade offer from factory: {}", itemListing.getClass().getSimpleName());
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

    public static boolean resetTrader(@NotNull AbstractVillager trader) {
        var offers = new MerchantOffers();
        var manager = TodeCoins.TRADE_OFFER_MANAGER;
        var random = new Random(trader.getRandom().nextLong());
        RandomSource randomSource = RandomSource.create();

        if (trader instanceof Numismatist) {
            // Numismatist common trades
            manager.getNumismatistOffers(TradeOfferManager.MerchantLevel.COMMON).ifPresent(commonTrades -> {
                var tradeCount = Config.getMaxWandererTrades();
                var shuffled = Arrays.asList(commonTrades);
                Collections.shuffle(shuffled, random);
                shuffled.stream()
                        .limit(tradeCount)
                        .map(itemListing -> {
                            var offer = itemListing.getOffer(trader, trader.getRandom());
                            if (offer == null) {
                                TC_LOGGER.warn("Null numismatist common trade offer from factory: {}", itemListing.getClass().getSimpleName());
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
                        .map(itemListing -> {
                            var offer = itemListing.getOffer(trader, trader.getRandom());
                            if (offer == null) {
                                TC_LOGGER.warn("Null numismatist rare trade offer from factory: {}", itemListing.getClass().getSimpleName());
                            }
                            return offer;
                        })
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            });

            ((AbstractVillagerAccessor) trader).setOffers(offers);

            return true;
        }
        if (trader instanceof WanderingTrader) {
            if (Config.getReplaceWanderingTraderTrades()) {
                TC_LOGGER.info("Replacing wandering trader trades with TodeCoins JSON offers.");
                // WanderingTrader common trades
                manager.getWanderingTraderOffers(TradeOfferManager.MerchantLevel.COMMON).ifPresent(commonTrades -> {
                    var tradeCount = Config.getMaxWandererTrades();
                    var shuffled = Arrays.asList(commonTrades);
                    Collections.shuffle(shuffled, random);
                    shuffled.stream()
                            .limit(tradeCount)
                            .map(itemListing -> {
                                var offer = itemListing.getOffer(trader, trader.getRandom());
                                if (offer == null) {
                                    TC_LOGGER.warn("Null wandering common trade offer from factory: {}", itemListing.getClass().getSimpleName());
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
                            .map(itemListing -> {
                                var offer = itemListing.getOffer(trader, trader.getRandom());
                                if (offer == null) {
                                    TC_LOGGER.warn("Null wandering rare trade offer from factory: {}", itemListing.getClass().getSimpleName());
                                }
                                return offer;
                            })
                            .filter(Objects::nonNull)
                            .forEach(offers::add);
                });
            }
            else {
                TC_LOGGER.info("Using wandering trader fallback trades.");
                // --- Fallback: vanilla (or other modded) trades ---
                var vanillaCommon = VillagerTrades.WANDERING_TRADER_TRADES.get(1);
                var vanillaRare = VillagerTrades.WANDERING_TRADER_TRADES.get(2);

                if (vanillaCommon != null) {
                    trader.addOffersFromItemListings(offers, vanillaCommon, 5); // vanilla default is 5
                }
                if (vanillaRare != null && vanillaRare.length > 0) {
                    var rareListing = vanillaRare[random.nextInt(vanillaRare.length)];
                    var offer = rareListing.getOffer(trader, trader.getRandom());
                    if (offer != null) offers.add(offer);
                }
            }

            ((AbstractVillagerAccessor) trader).setOffers(offers);

            return true;
        }
        if (ModList.get().isLoaded("supplementaries") && Config.getReplaceRedMerchantTrades()) {
            EntityType<?> redMerchantType = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.parse("supplementaries:red_merchant"));

            if (redMerchantType != null && trader.getType() == redMerchantType) {
                // Common trades
                manager.getOffersForRedMerchant(TradeOfferManager.MerchantLevel.COMMON).ifPresent(commonTrades -> {
                    var tradeCount = Config.getMaxWandererTrades();
                    var shuffled = Arrays.asList(commonTrades);
                    Collections.shuffle(shuffled, random);
                    shuffled.stream()
                            .limit(tradeCount)
                            .map(itemListing -> {
                                var offer = itemListing.getOffer(trader, randomSource);
                                if (offer == null) {
                                    TC_LOGGER.warn("Null red merchant common trade offer from factory: {}", itemListing.getClass().getSimpleName());
                                }
                                return offer;
                            })
                            .filter(Objects::nonNull)
                            .forEach(offers::add);
                });
                // Rare trades
                manager.getOffersForRedMerchant(TradeOfferManager.MerchantLevel.RARE).ifPresent(rareTrades -> {
                    var shuffled = Arrays.asList(rareTrades);
                    Collections.shuffle(shuffled, random);
                    shuffled.stream()
                            .limit(1)
                            .map(itemListing -> {
                                var offer = itemListing.getOffer(trader, randomSource);
                                if (offer == null) {
                                    TC_LOGGER.warn("Null red merchnat rare trade offer from factory: {}", itemListing.getClass().getSimpleName());
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
        }

        return false;
    }

    private static boolean resetVillager(@NotNull Villager villager) {
        var offers = new MerchantOffers();
        var data = villager.getVillagerData();
        var profession = data.getProfession();
        var level = data.getLevel();

        TradeOfferManager manager = TodeCoins.TRADE_OFFER_MANAGER;
        var random = new Random(villager.getRandom().nextLong());

        // --- Config toggle: replace vs fallback ---
        if (Config.getReplaceVillagerTrades()) {
            var optionalTrades = manager.getVillagerOffers(profession);
            if (optionalTrades.isEmpty()) {
                return false;
            }

            var levelToTrades = optionalTrades.get();

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
                        .map(itemListing -> {
                            var offer = itemListing.getOffer(villager, villager.getRandom());
                            if (offer == null) {
                                TC_LOGGER.warn("Null villager trade offer from factory: {}", itemListing.getClass().getSimpleName());
                            }
                            return offer;
                        })
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            }
        } else {
            // --- Fallback: vanilla or custom profession trades ---
            var fallback = new Int2ObjectOpenHashMap<List<VillagerTrades.ItemListing>>();

            // Banker fallback
            if (profession.equals(TCVillagers.BANKER.get())) {
                Int2ObjectMap<VillagerTrades.ItemListing[]> banker = BankerTrades.BANKER_TRADES;
                for (int lvl : banker.keySet()) {
                    fallback.put(lvl, Arrays.asList(banker.get(lvl)));
                }
            }
            // Leprechaun fallback
            else if (profession.equals(TCVillagers.LEPRECHAUN.get())) {
                Int2ObjectMap<VillagerTrades.ItemListing[]> leprechaun = LeprechaunTrades.LEPRECHAUN_TRADES;
                for (int lvl : leprechaun.keySet()) {
                    fallback.put(lvl, Arrays.asList(leprechaun.get(lvl)));
                }
            }
            // Vanilla professions fallback
            else {
                var vanilla = VillagerTrades.TRADES.get(profession);
                if (vanilla != null) {
                    for (int lvl : vanilla.keySet()) {
                        fallback.put(lvl, Arrays.asList(vanilla.get(lvl)));
                    }
                }
            }

            // Pick trades up to villager’s current level
            for (int i = 1; i <= level; i++) {
                var listings = fallback.get(i);
                if (listings == null || listings.isEmpty()) continue;

                var tradeCount = 2;
                var shuffled = new ArrayList<>(listings);
                Collections.shuffle(shuffled, random);

                shuffled.stream()
                        .limit(tradeCount)
                        .map(itemListing -> itemListing.getOffer(villager, villager.getRandom()))
                        .filter(Objects::nonNull)
                        .forEach(offers::add);
            }
        }

        villager.setOffers(offers);
        return true;
    }
}