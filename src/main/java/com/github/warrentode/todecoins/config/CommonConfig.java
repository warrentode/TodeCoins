package com.github.warrentode.todecoins.config;

import com.github.warrentode.todecoins.util.tags.ForgeTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // general trade setting variables
    public static final ForgeConfigSpec.BooleanValue USE_MOD_TRADES;
    public static final ForgeConfigSpec.BooleanValue REPLACE_TRADES;
    public static final ForgeConfigSpec.BooleanValue RESET_TRADES_ON_RESTOCK;
    public static final ForgeConfigSpec.IntValue MAX_VILLAGER_TRADES_PER_LEVEL;
    public static final ForgeConfigSpec.IntValue MAX_WANDERER_COMMON_TRADES;
    public static final ForgeConfigSpec.IntValue BASE_XP;
    public static final ForgeConfigSpec.IntValue MAX_USES;
    public static final ForgeConfigSpec.IntValue RARE_MAX_USES;
    public static final ForgeConfigSpec.DoubleValue PRICE_MULTIPLIER;
    public static final ForgeConfigSpec.DoubleValue RARE_PRICE_MULTIPLIER;
    public static final ForgeConfigSpec.BooleanValue ALLOW_TREASURE_ENCHANTMENTS;
    public static final ForgeConfigSpec.IntValue PIGLIN_MERCHANT_PORTAL_SPAWN_CHANCE;
    public static final ForgeConfigSpec.IntValue PIGLIN_MERCHANT_NETHER_SPAWN_DELAY;
    public static final ForgeConfigSpec.IntValue PIGLIN_MERCHANT_NETHER_DESPAWN_DELAY;

    // general trade variable setters
    static {
        BUILDER.push("General Trade Settings");
        USE_MOD_TRADES = BUILDER
                .comment(" Use Loot Table Trades?")
                .define("use_loot_table_trades", false);
        REPLACE_TRADES = BUILDER
                .comment(" Replace Trade with Configured Loot Table Trades?")
                .define("replace_trades", true);
        BASE_XP = BUILDER
                .comment(" Default Base XP per Level")
                .defineInRange("default_base_xp_per_level", 5, 0, Integer.MAX_VALUE);
        MAX_USES = BUILDER
                .comment(" Default Max Uses per Trade")
                .defineInRange("default_max_uses_per_trade", 12, 1, Integer.MAX_VALUE);
        RARE_MAX_USES = BUILDER
                .comment(" Default Max Uses per Rare Trade")
                .defineInRange("default_max_uses_per_rare_trade", 3, 1, Integer.MAX_VALUE);
        PRICE_MULTIPLIER = BUILDER
                .comment(" Default Price Multiplier")
                .defineInRange("default_common_price_multiplier", 0.05, 0, Double.MAX_VALUE);
        RARE_PRICE_MULTIPLIER = BUILDER
                .comment(" Default Price Multiplier")
                .defineInRange("default_rare_price_multiplier", 0.2, 0, Double.MAX_VALUE);
        RESET_TRADES_ON_RESTOCK = BUILDER
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
                .defineInRange("piglin_merchant_portal_spawn_chance", 1000, 1, Integer.MAX_VALUE);
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
    public static Boolean getCustomTrades() {
        if (Objects.equals(USE_MOD_TRADES.get(), USE_MOD_TRADES.getDefault())) {
            return USE_MOD_TRADES.getDefault();
        }
        else {
            return USE_MOD_TRADES.get();
        }
    }
    public static Boolean getReplaceTrades() {
        if (Objects.equals(REPLACE_TRADES.get(), REPLACE_TRADES.getDefault())) {
            return REPLACE_TRADES.getDefault();
        }
        else {
            return REPLACE_TRADES.get();
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
    public static int getBaseXP() {
        if (Objects.equals(BASE_XP.get(), BASE_XP.getDefault())) {
            return BASE_XP.getDefault();
        }
        else {
            return BASE_XP.get();
        }
    }
    public static int getRareMaxUses() {
        if (Objects.equals(RARE_MAX_USES.get(), RARE_MAX_USES.getDefault())) {
            return RARE_MAX_USES.getDefault();
        }
        else {
            return RARE_MAX_USES.get();
        }
    }
    public static int getCommonMaxUses() {
        if (Objects.equals(MAX_USES.get(), MAX_USES.getDefault())) {
            return MAX_USES.getDefault();
        }
        else {
            return MAX_USES.get();
        }
    }
    public static double getCommonTradeMultiplier() {
        if (Objects.equals(PRICE_MULTIPLIER.get(), PRICE_MULTIPLIER.getDefault())) {
            return PRICE_MULTIPLIER.getDefault();
        }
        else {
            return PRICE_MULTIPLIER.get();
        }
    }
    public static double getRareTradeMultiplier() {
        if (Objects.equals(RARE_PRICE_MULTIPLIER.get(), RARE_PRICE_MULTIPLIER.getDefault())) {
            return RARE_PRICE_MULTIPLIER.getDefault();
        }
        else {
            return RARE_PRICE_MULTIPLIER.get();
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
            return USE_MOD_TRADES.getDefault();
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

    // structure tag getter
    public static @NotNull TagKey<Structure> getStructureTag(String structureTag) {
        ResourceLocation structureTagLocation = ResourceLocation.tryParse(structureTag);
        if (structureTagLocation != null) {
            return ForgeTags.forgeStructureTag(structureTagLocation.getNamespace(), structureTagLocation.getPath());
        }
        else {
            return ForgeTags.StructureTags.OVERWORLD_POI;
        }
    }
}