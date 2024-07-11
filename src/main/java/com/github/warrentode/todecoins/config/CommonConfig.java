package com.github.warrentode.todecoins.config;

import com.github.warrentode.todecoins.loot.VillagerTradeLootTables;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> USE_MOD_TRADES;
    // currency value tables
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
    // custom currency value tables
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_QUARTER_NOTE_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_HALF_NOTE_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> EMERALD_NOTE_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> TWO_POT_GOLD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> FOUR_POT_GOLD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> THIRTY_POT_GOLD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> SIXTY_POT_GOLD_VALUE;
    public static final ForgeConfigSpec.ConfigValue<String> ONE_LUCKY_COIN_VALUE;

    static {
        BUILDER.push("Config Settings for TodeCoins");

        USE_MOD_TRADES = BUILDER.comment("Use this mod's trade tables for vanilla villager trades? default: false")
                .define("use_mod_trade_tables", false);
        // currency value tables
        ONE_EMERALD_VALUE = BUILDER.comment("Set Loot Table for One Emerald Value Currency")
                .define("one_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TWO_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Two Emerald Value Currency")
                .define("two_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        THREE_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Three Emerald Value Currency")
                .define("three_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        FOUR_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Four Emerald Value Currency")
                .define("four_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        FIVE_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Five Emerald Value Currency")
                .define("five_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        SIX_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Six Emerald Value Currency")
                .define("six_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        SEVEN_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Seven Emerald Value Currency")
                .define("seven_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        EIGHT_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Eight Emerald Value Currency")
                .define("eight_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY.toString());
        NINE_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Nine Emerald Value Currency")
                .define("nine_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        FOURTEEN_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Fourteen Emerald Value Currency")
                .define("fourteen_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        TWENTY_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Twenty Emerald Value Currency")
                .define("twenty_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        TWENTY_SIX_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Twenty-Six Emerald Value Currency")
                .define("twenty_six_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        THIRTY_SIX_EMERALD_VALUE = BUILDER.comment("Set Loot Table for Thirty-Six Emerald Value Currency")
                .define("thirty_six_emerald_value_currency_loot_table",
                        VillagerTradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        // custom currency value tables
        EMERALD_QUARTER_NOTE_VALUE = BUILDER
                .comment("Set Loot Table for Emerald Quarter Bank Note Value Currency (16 Emerald Value)")
                .define("emerald_quarter_note_value_currency_loot_table",
                        VillagerTradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        EMERALD_HALF_NOTE_VALUE = BUILDER
                .comment("Set Loot Table for Emerald Half Bank Note Value Currency (32 Emerald Value)")
                .define("emerald_half_note_value_currency_loot_table",
                        VillagerTradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        EMERALD_NOTE_VALUE = BUILDER
                .comment("Set Loot Table for Emerald Bank Note Value Currency (64 Emerald Value)")
                .define("emerald_half_note_value_currency_loot_table",
                        VillagerTradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        TWO_POT_GOLD_VALUE = BUILDER
                .comment("Set Loot Table for Two Pots of Gold Currency (3 Emerald Value)")
                .define("two_pot_gold_value_currency_loot_table",
                        VillagerTradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        FOUR_POT_GOLD_VALUE = BUILDER
                .comment("Set Loot Table for Four Pots of Gold Currency (6 Emerald Value)")
                .define("four_pot_gold_value_currency_loot_table",
                        VillagerTradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        THIRTY_POT_GOLD_VALUE = BUILDER
                .comment("Set Loot Table for Thirty Pots of Gold Currency (45 Emerald Value)")
                .define("thirty_pot_gold_value_currency_loot_table",
                        VillagerTradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        SIXTY_POT_GOLD_VALUE = BUILDER
                .comment("Set Loot Table for Sixty Pots of Gold Currency (60 Emerald Value)")
                .define("sixty_pot_gold_value_currency_loot_table",
                        VillagerTradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        ONE_LUCKY_COIN_VALUE = BUILDER
                .comment("Set Loot Table for One Lucky Coin Currency (192 Emerald Value)")
                .define("one_lucky_coin_value_currency_loot_table",
                        VillagerTradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY.toString());

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static Boolean getCustomTrades() {
        if (Objects.equals(USE_MOD_TRADES.get(), USE_MOD_TRADES.getDefault())) {
            return USE_MOD_TRADES.getDefault();
        }
        else {
            return USE_MOD_TRADES.get();
        }
    }
    // currency value tables
    public static String getOneEmeraldValueTable() {
        if (Objects.equals(ONE_EMERALD_VALUE.get(), ONE_EMERALD_VALUE.getDefault())) {
            return ONE_EMERALD_VALUE.getDefault();
        }
        else {
            return ONE_EMERALD_VALUE.get();
        }
    }
    public static String getTwoEmeraldValueTable() {
        if (Objects.equals(TWO_EMERALD_VALUE.get(), TWO_EMERALD_VALUE.getDefault())) {
            return TWO_EMERALD_VALUE.getDefault();
        }
        else {
            return TWO_EMERALD_VALUE.get();
        }
    }
    public static String getThreeEmeraldValueTable() {
        if (Objects.equals(THREE_EMERALD_VALUE.get(), THREE_EMERALD_VALUE.getDefault())) {
            return THREE_EMERALD_VALUE.getDefault();
        }
        else {
            return THREE_EMERALD_VALUE.get();
        }
    }
    public static String getFourEmeraldValueTable() {
        if (Objects.equals(FOUR_EMERALD_VALUE.get(), FOUR_EMERALD_VALUE.getDefault())) {
            return FOUR_EMERALD_VALUE.getDefault();
        }
        else {
            return FOUR_EMERALD_VALUE.get();
        }
    }
    public static String getFiveEmeraldValueTable() {
        if (Objects.equals(FIVE_EMERALD_VALUE.get(), FIVE_EMERALD_VALUE.getDefault())) {
            return FIVE_EMERALD_VALUE.getDefault();
        }
        else {
            return FIVE_EMERALD_VALUE.get();
        }
    }
    public static String getSixEmeraldValueTable() {
        if (Objects.equals(SIX_EMERALD_VALUE.get(), SIX_EMERALD_VALUE.getDefault())) {
            return SIX_EMERALD_VALUE.getDefault();
        }
        else {
            return SIX_EMERALD_VALUE.get();
        }
    }
    public static String getSevenEmeraldValueTable() {
        if (Objects.equals(SEVEN_EMERALD_VALUE.get(), SEVEN_EMERALD_VALUE.getDefault())) {
            return SEVEN_EMERALD_VALUE.getDefault();
        }
        else {
            return SEVEN_EMERALD_VALUE.get();
        }
    }
    public static String getEightEmeraldValueTable() {
        if (Objects.equals(EIGHT_EMERALD_VALUE.get(), EIGHT_EMERALD_VALUE.getDefault())) {
            return EIGHT_EMERALD_VALUE.getDefault();
        }
        else {
            return EIGHT_EMERALD_VALUE.get();
        }
    }
    public static String getNineEmeraldValueTable() {
        if (Objects.equals(NINE_EMERALD_VALUE.get(), NINE_EMERALD_VALUE.getDefault())) {
            return NINE_EMERALD_VALUE.getDefault();
        }
        else {
            return NINE_EMERALD_VALUE.get();
        }
    }
    public static String getFourteenEmeraldValueTable() {
        if (Objects.equals(FOURTEEN_EMERALD_VALUE.get(), FOURTEEN_EMERALD_VALUE.getDefault())) {
            return FOURTEEN_EMERALD_VALUE.getDefault();
        }
        else {
            return FOURTEEN_EMERALD_VALUE.get();
        }
    }
    public static String getTwentyEmeraldValueTable() {
        if (Objects.equals(TWENTY_EMERALD_VALUE.get(), TWENTY_EMERALD_VALUE.getDefault())) {
            return TWENTY_EMERALD_VALUE.getDefault();
        }
        else {
            return TWENTY_EMERALD_VALUE.get();
        }
    }
    public static String getTwentySixEmeraldValueTable() {
        if (Objects.equals(TWENTY_SIX_EMERALD_VALUE.get(), TWENTY_SIX_EMERALD_VALUE.getDefault())) {
            return TWENTY_SIX_EMERALD_VALUE.getDefault();
        }
        else {
            return TWENTY_SIX_EMERALD_VALUE.get();
        }
    }
    public static String getThirtySixEmeraldValueTable() {
        if (Objects.equals(THIRTY_SIX_EMERALD_VALUE.get(), THIRTY_SIX_EMERALD_VALUE.getDefault())) {
            return THIRTY_SIX_EMERALD_VALUE.getDefault();
        }
        else {
            return THIRTY_SIX_EMERALD_VALUE.get();
        }
    }
    // custom currency value tables
    public static String getEmeraldQuarterNoteValueTable() {
        if (Objects.equals(EMERALD_QUARTER_NOTE_VALUE.get(), EMERALD_QUARTER_NOTE_VALUE.getDefault())) {
            return EMERALD_QUARTER_NOTE_VALUE.getDefault();
        }
        else {
            return EMERALD_QUARTER_NOTE_VALUE.get();
        }
    }
    public static String getEmeraldHalfNoteValueTable() {
        if (Objects.equals(EMERALD_HALF_NOTE_VALUE.get(), EMERALD_HALF_NOTE_VALUE.getDefault())) {
            return EMERALD_HALF_NOTE_VALUE.getDefault();
        }
        else {
            return EMERALD_HALF_NOTE_VALUE.get();
        }
    }
    public static String getEmeraldNoteValueTable() {
        if (Objects.equals(EMERALD_NOTE_VALUE.get(), EMERALD_NOTE_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return EMERALD_NOTE_VALUE.get();
        }
    }
    public static String getTwoPotGoldValueTable() {
        if (Objects.equals(TWO_POT_GOLD_VALUE.get(), TWO_POT_GOLD_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return TWO_POT_GOLD_VALUE.get();
        }
    }
    public static String getFourPotGoldValueTable() {
        if (Objects.equals(FOUR_POT_GOLD_VALUE.get(), FOUR_POT_GOLD_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return FOUR_POT_GOLD_VALUE.get();
        }
    }
    public static String getThirtyPotGoldValueTable() {
        if (Objects.equals(THIRTY_POT_GOLD_VALUE.get(), THIRTY_POT_GOLD_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return THIRTY_POT_GOLD_VALUE.get();
        }
    }
    public static String getSixtyPotGoldValueTable() {
        if (Objects.equals(SIXTY_POT_GOLD_VALUE.get(), SIXTY_POT_GOLD_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return SIXTY_POT_GOLD_VALUE.get();
        }
    }
    public static String getOneLuckyCoinValueTable() {
        if (Objects.equals(ONE_LUCKY_COIN_VALUE.get(), ONE_LUCKY_COIN_VALUE.getDefault())) {
            return EMERALD_NOTE_VALUE.getDefault();
        }
        else {
            return ONE_LUCKY_COIN_VALUE.get();
        }
    }
}