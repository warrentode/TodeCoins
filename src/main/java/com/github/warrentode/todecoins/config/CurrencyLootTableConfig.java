package com.github.warrentode.todecoins.config;

import com.github.warrentode.todecoins.loot.TradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CurrencyLootTableConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // currency table variables
    public static final ForgeConfigSpec.ConfigValue<String> SMALLEST_COIN;
    public static final ForgeConfigSpec.ConfigValue<String> ONE_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> TWO_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> THREE_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> FOUR_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> FIVE_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> SIX_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> SEVEN_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EIGHT_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> NINE_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> FOURTEEN_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> TWENTY_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> TWENTY_SIX_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> THIRTY_SIX_EMERALD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_QUARTER_NOTE_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_HALF_NOTE_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_NOTE_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> TWO_GOLD_POT_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> FOUR_GOLD_POT_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> THIRTY_GOLD_POT_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> SIXTY_GOLD_POT_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> ONE_LUCKY_COIN_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> SEVEN_NETHERITE_COIN_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> ONE_LUCKY_COIN_BAG_VALUE;

    static {
        BUILDER.push("Currency Loot Table Trade Settings");
        SMALLEST_COIN = BUILDER
                .comment(" 1 Copper Coin Value Currency Table")
                .define("smallest_coin",
                        TradeLootTables.SMALLEST_COIN.toString());
        ONE_EMERALD_VALUE = BUILDER
                .comment(" 1 Emerald Value Currency")
                .define("one_emerald_value",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TWO_EMERALD_VALUE = BUILDER
                .comment(" 2 Emerald Value Currency")
                .define("two_emerald_value",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        THREE_EMERALD_VALUE = BUILDER
                .comment(" 3 Emerald Value Currency")
                .define("three_emerald_value",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        FOUR_EMERALD_VALUE = BUILDER
                .comment(" 4 Emerald Value Currency")
                .define("four_emerald_value",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        FIVE_EMERALD_VALUE = BUILDER
                .comment(" 5 Emerald Value Currency")
                .define("five_emerald_value",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        SIX_EMERALD_VALUE = BUILDER
                .comment(" 6 Emerald Value Currency")
                .define("six_emerald_value",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        SEVEN_EMERALD_VALUE = BUILDER
                .comment(" 7 Emerald Value Currency")
                .define("seven_emerald_value",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        EIGHT_EMERALD_VALUE = BUILDER
                .comment(" 8 Emerald Value Currency")
                .define("eight_emerald_value",
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY.toString());
        NINE_EMERALD_VALUE = BUILDER
                .comment(" 9 Emerald Value Currency")
                .define("nine_emerald_value",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        FOURTEEN_EMERALD_VALUE = BUILDER
                .comment(" 14 Emerald Value Currency")
                .define("fourteen_emerald_value",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        TWENTY_EMERALD_VALUE = BUILDER
                .comment(" 20 Emerald Value Currency")
                .define("twenty_emerald_value",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        TWENTY_SIX_EMERALD_VALUE = BUILDER
                .comment(" 26 Emerald Value Currency")
                .define("twenty_six_emerald_value",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        THIRTY_SIX_EMERALD_VALUE = BUILDER
                .comment(" 36 Emerald Value Currency")
                .define("thirty_six_emerald_value",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        EMERALD_QUARTER_NOTE_VALUE = BUILDER
                .comment(" 1 Emerald Quarter Bank Note = 16 Emeralds")
                .define("emerald_quarter_note_value",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        EMERALD_HALF_NOTE_VALUE = BUILDER
                .comment(" 1 Emerald Half Bank Note = 32 Emeralds")
                .define("emerald_half_note_value",
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        EMERALD_NOTE_VALUE = BUILDER
                .comment(" 1 Emerald Bank Note = 64 Emeralds")
                .define("emerald_note_value",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        TWO_GOLD_POT_VALUE = BUILDER
                .comment(" 2 Pots of Gold = 3 Emeralds")
                .define("two_gold_pot_value",
                        TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        FOUR_GOLD_POT_VALUE = BUILDER
                .comment(" 4 Pots of Gold = 6 Emeralds")
                .define("four_gold_pot_value",
                        TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        THIRTY_GOLD_POT_VALUE = BUILDER
                .comment(" 30 Pots of Gold = 45 Emeralds")
                .define("thirty_gold_pot_value",
                        TradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        SIXTY_GOLD_POT_VALUE = BUILDER
                .comment(" 60 Pots of Gold = 90 Emeralds")
                .define("sixty_gold_pot_value",
                        TradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        ONE_LUCKY_COIN_VALUE = BUILDER
                .comment(" 1 Lucky Coin = 192 Emeralds")
                .define("lucky_coin_value",
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY.toString());
        SEVEN_NETHERITE_COIN_VALUE = BUILDER
                .comment(" 7 Netherite Coin = 224 Emeralds")
                .define("seven_netherite_coin_value",
                        TradeLootTables.SEVEN_NETHERITE_COIN_VALUE_CURRENCY.toString());
        ONE_LUCKY_COIN_BAG_VALUE = BUILDER
                .comment(" 9 Lucky Coin Value Currency Table")
                .comment(" 1,728 Emerald Value Currency Table")
                .define("lucky_coin_bag_value",
                        TradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY.toString());
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}