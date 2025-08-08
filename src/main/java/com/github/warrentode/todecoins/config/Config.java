package com.github.warrentode.todecoins.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue RESET_TRADES_ON_RESTOCK;
    public static final ForgeConfigSpec.IntValue MAX_VILLAGER_TRADES_PER_LEVEL;
    public static final ForgeConfigSpec.IntValue MAX_WANDERER_COMMON_TRADES;
    public static final ForgeConfigSpec.BooleanValue ALLOW_TREASURE_ENCHANTMENTS;
    public static final ForgeConfigSpec.IntValue PIGLIN_MERCHANT_PORTAL_SPAWN_CHANCE;
    public static final ForgeConfigSpec.IntValue PIGLIN_MERCHANT_NETHER_SPAWN_DELAY;
    public static final ForgeConfigSpec.IntValue PIGLIN_MERCHANT_NETHER_DESPAWN_DELAY;

    // general trade variable setters
    static {
        BUILDER.push("General Trade Settings");RESET_TRADES_ON_RESTOCK = BUILDER
                .comment(" Reset Villager Trades on Restock?")
                .define("reset_trades_on_restock", false);
        MAX_VILLAGER_TRADES_PER_LEVEL = BUILDER
                .comment(" Max Villager Trades per Level")
                .defineInRange("max_villager_trades_per_level", 2, 0, Integer.MAX_VALUE);
        MAX_WANDERER_COMMON_TRADES = BUILDER
                .comment(" Max Wandering Trader Common Trades per Level")
                .defineInRange("max_wanderer_common_trades", 5, 0, Integer.MAX_VALUE);
        ALLOW_TREASURE_ENCHANTMENTS = BUILDER
                .comment(" Allow Treasure Enchantments in Trades")
                .define("allow_treasure_enchantments", false);
        PIGLIN_MERCHANT_PORTAL_SPAWN_CHANCE = BUILDER
                .comment(" Delay for Piglin Merchant Portal Spawn Chance")
                .defineInRange("piglin_merchant_portal_spawn_chance", 1000, 0, Integer.MAX_VALUE);
        PIGLIN_MERCHANT_NETHER_SPAWN_DELAY = BUILDER
                .comment(" Delay for Piglin Merchant Nether Spawn Chance")
                .defineInRange("piglin_merchant_nether_spawn_delay", 24000, 20, Integer.MAX_VALUE);
        PIGLIN_MERCHANT_NETHER_DESPAWN_DELAY = BUILDER
                .comment(" Delay for Piglin Merchant Nether Despawn")
                .defineInRange("piglin_merchant_nether_despawn_delay", 48000, 40, Integer.MAX_VALUE);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // general trade setting getters
    public static Boolean getResetTrades() {
        if (Objects.equals(RESET_TRADES_ON_RESTOCK.get(), RESET_TRADES_ON_RESTOCK.getDefault())) {
            return RESET_TRADES_ON_RESTOCK.getDefault();
        }
        else {
            return RESET_TRADES_ON_RESTOCK.get();
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
}