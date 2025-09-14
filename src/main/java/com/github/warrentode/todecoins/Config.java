package com.github.warrentode.todecoins;

import com.github.warrentode.todecoins.util.seasonal.CustomEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.time.MonthDay;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.TodeCoins.TC_LOGGER;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue RESET_TRADES_ON_RESTOCK;
    public static final ForgeConfigSpec.BooleanValue REPLACE_GOBLIN_TRADER_TRADES;
    public static final ForgeConfigSpec.BooleanValue REPLACE_RED_MERCHANT_TRADES;
    public static final ForgeConfigSpec.BooleanValue REPLACE_WANDERING_TRADER_TRADES;
    public static final ForgeConfigSpec.BooleanValue REPLACE_VILLAGER_TRADES;
    public static final ForgeConfigSpec.IntValue MAX_VILLAGER_TRADES_PER_LEVEL;
    public static final ForgeConfigSpec.IntValue MAX_WANDERER_COMMON_TRADES;
    public static final ForgeConfigSpec.BooleanValue ALLOW_TREASURE_ENCHANTMENTS;

    public static final ForgeConfigSpec.IntValue PIGLIN_MERCHANT_PORTAL_SPAWN_CHANCE;
    public static final ForgeConfigSpec.IntValue PIGLIN_MERCHANT_NETHER_SPAWN_DELAY;
    public static final ForgeConfigSpec.IntValue PIGLIN_MERCHANT_NETHER_DESPAWN_DELAY;

    public static final ForgeConfigSpec.IntValue NUMISMATIST_SPAWN_DELAY;
    public static final ForgeConfigSpec.IntValue NUMISMATIST_DESPAWN_DELAY;

    public static final ForgeConfigSpec.IntValue PLAINS_VILLAGE_BANK_SPAWN_WEIGHT;
    public static final ForgeConfigSpec.IntValue DESERT_VILLAGE_BANK_SPAWN_WEIGHT;
    public static final ForgeConfigSpec.IntValue SAVANNA_VILLAGE_BANK_SPAWN_WEIGHT;
    public static final ForgeConfigSpec.IntValue TAIGA_VILLAGE_BANK_SPAWN_WEIGHT;
    public static final ForgeConfigSpec.IntValue SNOWY_VILLAGE_BANK_SPAWN_WEIGHT;

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CUSTOM_EVENTS;

    // config setting setters
    static {
        // General trade settings
        BUILDER.push("General Trade Settings");
        RESET_TRADES_ON_RESTOCK = BUILDER
                .comment("Reset Villager Trades on Restock?")
                .define("reset_trades_on_restock", false);
        REPLACE_GOBLIN_TRADER_TRADES = BUILDER
                .comment("If Goblin Traders is Loaded, Replace These Trades?")
                .define("replace_goblin_trader_trades", false);
        REPLACE_RED_MERCHANT_TRADES = BUILDER
                .comment("If Supplementaries is Loaded, Replace These Trades?")
                .define("replace_red_merchant_trades", false);
        REPLACE_WANDERING_TRADER_TRADES = BUILDER
                .comment("Replace These Trades? (both vanilla and modded)")
                .define("replace_wandering_trader_trades", false);
        REPLACE_VILLAGER_TRADES = BUILDER
                .comment("Replace These Trades? (both vanilla and modded)")
                .define("replace_villager_trades", false);
        MAX_VILLAGER_TRADES_PER_LEVEL = BUILDER
                .comment("Max Villager Trades per Level (if trades are replaced)")
                .defineInRange("max_villager_trades_per_level", 2, 1, Integer.MAX_VALUE);
        MAX_WANDERER_COMMON_TRADES = BUILDER
                .comment("Max Wandering Trader Common Trades per Level (if trades are replaced)")
                .defineInRange("max_wanderer_common_trades", 5, 1, Integer.MAX_VALUE);
        ALLOW_TREASURE_ENCHANTMENTS = BUILDER
                .comment("Allow Treasure Enchantments in Trades")
                .define("allow_treasure_enchantments", false);
        BUILDER.pop();

        // Piglin Merchant settings
        BUILDER.push("Piglin Merchant Settings");
        PIGLIN_MERCHANT_PORTAL_SPAWN_CHANCE = BUILDER
                .comment("Delay for Piglin Merchant Portal Spawn Chance")
                .defineInRange("piglin_merchant_portal_spawn_chance", 1000, 0, Integer.MAX_VALUE);
        PIGLIN_MERCHANT_NETHER_SPAWN_DELAY = BUILDER
                .comment("Delay for Piglin Merchant Nether Spawn Chance")
                .defineInRange("piglin_merchant_nether_spawn_delay", 24000, 20, Integer.MAX_VALUE);
        PIGLIN_MERCHANT_NETHER_DESPAWN_DELAY = BUILDER
                .comment("Delay for Piglin Merchant Nether Despawn")
                .defineInRange("piglin_merchant_nether_despawn_delay", 48000, 40, Integer.MAX_VALUE);
        BUILDER.pop();

        // Numismatist settings
        BUILDER.push("Numismatist Settings");
        NUMISMATIST_SPAWN_DELAY = BUILDER
                .comment("Delay for Numismatist Spawn Chance")
                .defineInRange("numismatist_spawn_delay", 24000, 20, Integer.MAX_VALUE);
        NUMISMATIST_DESPAWN_DELAY = BUILDER
                .comment("Delay for Numismatist Despawn")
                .defineInRange("numismatist_despawn_delay", 48000, 40, Integer.MAX_VALUE);
        BUILDER.pop();

        // Village Bank spawn weights
        BUILDER.push("Village Bank Spawn Weights");
        PLAINS_VILLAGE_BANK_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance of the bank in plains villages")
                .defineInRange("plains_village_bank_spawn_weight", 2, 1, Integer.MAX_VALUE);
        DESERT_VILLAGE_BANK_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance of the bank in desert villages")
                .defineInRange("desert_village_bank_spawn_weight", 2, 1, Integer.MAX_VALUE);
        SAVANNA_VILLAGE_BANK_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance of the bank in savanna villages")
                .defineInRange("savanna_village_bank_spawn_weight", 2, 1, Integer.MAX_VALUE);
        TAIGA_VILLAGE_BANK_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance of the bank in taiga villages")
                .defineInRange("taiga_village_bank_spawn_weight", 2, 1, Integer.MAX_VALUE);
        SNOWY_VILLAGE_BANK_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance of the bank in snowy villages")
                .defineInRange("snowy_village_bank_spawn_weight", 2, 1, Integer.MAX_VALUE);
        BUILDER.pop();

        // Custom events
        BUILDER.push("Custom Events");
        CUSTOM_EVENTS = BUILDER
                .comment("Custom events (format: NAME:MM-DD or NAME:MM-DD~MM-DD)")
                .defineList("custom_events",
                        List.of(
                                "Mod Birthday:12-21",
                                "Minecraft Steve's Birthday:05-17",
                                "Christmas Party:12-24~12-26"
                        ),
                        customEvent -> customEvent instanceof String
                );
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // config setting getters
    public static Boolean getReplaceGoblinTraderTrades() {
        if (Objects.equals(REPLACE_GOBLIN_TRADER_TRADES.get(), REPLACE_GOBLIN_TRADER_TRADES.getDefault())) {
            return REPLACE_GOBLIN_TRADER_TRADES.getDefault();
        }
        else {
            return REPLACE_GOBLIN_TRADER_TRADES.get();
        }
    }
    public static Boolean getReplaceRedMerchantTrades() {
        if (Objects.equals(REPLACE_RED_MERCHANT_TRADES.get(), REPLACE_RED_MERCHANT_TRADES.getDefault())) {
            return REPLACE_RED_MERCHANT_TRADES.getDefault();
        }
        else {
            return REPLACE_RED_MERCHANT_TRADES.get();
        }
    }
    public static Boolean getReplaceWanderingTraderTrades() {
        if (Objects.equals(REPLACE_WANDERING_TRADER_TRADES.get(), REPLACE_WANDERING_TRADER_TRADES.getDefault())) {
            return REPLACE_WANDERING_TRADER_TRADES.getDefault();
        }
        else {
            return REPLACE_WANDERING_TRADER_TRADES.get();
        }
    }

    public static Boolean getResetTrades() {
        if (Objects.equals(RESET_TRADES_ON_RESTOCK.get(), RESET_TRADES_ON_RESTOCK.getDefault())) {
            return RESET_TRADES_ON_RESTOCK.getDefault();
        }
        else {
            return RESET_TRADES_ON_RESTOCK.get();
        }
    }
    public static Boolean getReplaceVillagerTrades() {
        if (Objects.equals(REPLACE_VILLAGER_TRADES.get(), REPLACE_VILLAGER_TRADES.getDefault())) {
            return REPLACE_VILLAGER_TRADES.getDefault();
        }
        else {
            return REPLACE_VILLAGER_TRADES.get();
        }
    }
    public static int getMaxVillagerTrades() {
        if (Objects.equals(MAX_VILLAGER_TRADES_PER_LEVEL.get(), MAX_VILLAGER_TRADES_PER_LEVEL.getDefault())) {
            return MAX_VILLAGER_TRADES_PER_LEVEL.getDefault();
        }
        else {
            return MAX_VILLAGER_TRADES_PER_LEVEL.get();
        }
    }
    public static int getMaxWandererTrades() {
        if (Objects.equals(MAX_WANDERER_COMMON_TRADES.get(), MAX_WANDERER_COMMON_TRADES.getDefault())) {
            return MAX_WANDERER_COMMON_TRADES.getDefault();
        }
        else {
            return MAX_WANDERER_COMMON_TRADES.get();
        }
    }
    public static Boolean getAllowTreasureEnchantments() {
        if (Objects.equals(ALLOW_TREASURE_ENCHANTMENTS.get(), ALLOW_TREASURE_ENCHANTMENTS.getDefault())) {
            return ALLOW_TREASURE_ENCHANTMENTS.getDefault();
        }
        else {
            return ALLOW_TREASURE_ENCHANTMENTS.get();
        }
    }

    public static int getPiglinMerchantPortalTickSpawnChance() {
        if (Objects.equals(PIGLIN_MERCHANT_PORTAL_SPAWN_CHANCE.get(), PIGLIN_MERCHANT_PORTAL_SPAWN_CHANCE.getDefault())) {
            return PIGLIN_MERCHANT_PORTAL_SPAWN_CHANCE.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_PORTAL_SPAWN_CHANCE.get();
        }
    }
    public static int getPiglinMerchantNetherSpawnDelay() {
        if (Objects.equals(PIGLIN_MERCHANT_NETHER_SPAWN_DELAY.get(), PIGLIN_MERCHANT_NETHER_SPAWN_DELAY.getDefault())) {
            return PIGLIN_MERCHANT_NETHER_SPAWN_DELAY.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_NETHER_SPAWN_DELAY.get();
        }
    }
    public static int getPiglinMerchantNetherDespawnDelay() {
        if (Objects.equals(PIGLIN_MERCHANT_NETHER_DESPAWN_DELAY.get(), PIGLIN_MERCHANT_NETHER_DESPAWN_DELAY.getDefault())) {
            return PIGLIN_MERCHANT_NETHER_DESPAWN_DELAY.getDefault();
        }
        else {
            return PIGLIN_MERCHANT_NETHER_DESPAWN_DELAY.get();
        }
    }

    public static int getNumismatistSpawnDelay() {
        if (Objects.equals(NUMISMATIST_SPAWN_DELAY.get(), NUMISMATIST_SPAWN_DELAY.getDefault())) {
            return NUMISMATIST_SPAWN_DELAY.getDefault();
        }
        else {
            return NUMISMATIST_SPAWN_DELAY.get();
        }
    }
    public static int getNumismatistDespawnDelay() {
        if (Objects.equals(NUMISMATIST_DESPAWN_DELAY.get(), NUMISMATIST_DESPAWN_DELAY.getDefault())) {
            return NUMISMATIST_DESPAWN_DELAY.getDefault();
        }
        else {
            return NUMISMATIST_DESPAWN_DELAY.get();
        }
    }

    public static int getPlainsBankSpawnWeight() {
        if (Objects.equals(PLAINS_VILLAGE_BANK_SPAWN_WEIGHT.get(), PLAINS_VILLAGE_BANK_SPAWN_WEIGHT.getDefault())) {
            return PLAINS_VILLAGE_BANK_SPAWN_WEIGHT.getDefault();
        }
        else {
            return PLAINS_VILLAGE_BANK_SPAWN_WEIGHT.get();
        }
    }
    public static int getDesertBankSpawnWeight() {
        if (Objects.equals(DESERT_VILLAGE_BANK_SPAWN_WEIGHT.get(), DESERT_VILLAGE_BANK_SPAWN_WEIGHT.getDefault())) {
            return DESERT_VILLAGE_BANK_SPAWN_WEIGHT.getDefault();
        }
        else {
            return DESERT_VILLAGE_BANK_SPAWN_WEIGHT.get();
        }
    }
    public static int getSavannaBankSpawnWeight() {
        if (Objects.equals(SAVANNA_VILLAGE_BANK_SPAWN_WEIGHT.get(), SAVANNA_VILLAGE_BANK_SPAWN_WEIGHT.getDefault())) {
            return SAVANNA_VILLAGE_BANK_SPAWN_WEIGHT.getDefault();
        }
        else {
            return SAVANNA_VILLAGE_BANK_SPAWN_WEIGHT.get();
        }
    }
    public static int getTaigaBankSpawnWeight() {
        if (Objects.equals(TAIGA_VILLAGE_BANK_SPAWN_WEIGHT.get(), TAIGA_VILLAGE_BANK_SPAWN_WEIGHT.getDefault())) {
            return TAIGA_VILLAGE_BANK_SPAWN_WEIGHT.getDefault();
        }
        else {
            return TAIGA_VILLAGE_BANK_SPAWN_WEIGHT.get();
        }
    }
    public static int getSnowyBankSpawnWeight() {
        if (Objects.equals(SNOWY_VILLAGE_BANK_SPAWN_WEIGHT.get(), SNOWY_VILLAGE_BANK_SPAWN_WEIGHT.getDefault())) {
            return SNOWY_VILLAGE_BANK_SPAWN_WEIGHT.getDefault();
        }
        else {
            return SNOWY_VILLAGE_BANK_SPAWN_WEIGHT.get();
        }
    }

    public static @NotNull List<CustomEvent> getCustomEvents() {
        List<CustomEvent> events = new ArrayList<>();

        for (String entry : CUSTOM_EVENTS.get()) {
            // normalize whitespace
            String cleanEntry = entry.trim().replaceAll("\\s+", " ");

            // split on the first colon, spaces around colon are ignored
            String[] parts = cleanEntry.split("\\s*:\\s*", 2);
            if (parts.length != 2) {
                TC_LOGGER.warn("Custom event entry missing colon or malformed: '{}'", entry);
                continue;
            }

            String name = parts[0].trim();
            String datePart = parts[1].trim();

            try {
                if (datePart.contains("~")) {
                    // range format: MM-DD~MM-DD
                    String[] range = datePart.split("\\s*~\\s*");
                    if (range.length != 2) throw new DateTimeParseException("Invalid range", datePart, 0);

                    MonthDay start = parseLenientMonthDay(range[0].trim());
                    MonthDay end = parseLenientMonthDay(range[1].trim());
                    events.add(new CustomEvent(name, start, end));
                }
                else {
                    MonthDay single = parseLenientMonthDay(datePart);
                    events.add(new CustomEvent(name, single, null));
                }
            }
            catch (DateTimeParseException exception) {
                TC_LOGGER.warn("Invalid custom event date format for '{}': {}", entry, exception.getMessage());
            }
        }

        return events;
    }

    /** Parses a MonthDay string leniently, allowing single-digit months or days (e.g., "5-1" -> "--05-01"). */
    private static @NotNull MonthDay parseLenientMonthDay(@NotNull String input) {
        String[] split = input.split("-");
        if (split.length != 2) throw new DateTimeParseException("Invalid month-day format", input, 0);

        int month = Integer.parseInt(split[0].trim());
        int day = Integer.parseInt(split[1].trim());

        // format with leading zeros
        String formatted = String.format("--%02d-%02d", month, day);
        return MonthDay.parse(formatted);
    }

    public static @NotNull List<String> getTodayEvents() {
        List<String> todayEvents = new ArrayList<>();
        for (CustomEvent event : getCustomEvents()) {
            if (event.isActiveToday()) {
                todayEvents.add(event.getName());
            }
        }
        return todayEvents;
    }

    public static boolean hasEventToday() {
        return !getTodayEvents().isEmpty();
    }
}