package com.github.warrentode.todecoins.config;

import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.TradeLootTables;
import com.github.warrentode.todecoins.util.tags.ForgeTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
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
    public static final ForgeConfigSpec.IntValue BASE_XP;
    public static final ForgeConfigSpec.IntValue MAX_USES;
    public static final ForgeConfigSpec.IntValue RARE_MAX_USES;
    public static final ForgeConfigSpec.DoubleValue PRICE_MULTIPLIER;
    public static final ForgeConfigSpec.DoubleValue RARE_PRICE_MULTIPLIER;
    public static final ForgeConfigSpec.BooleanValue RESET_TRADES_ON_RESTOCK;
    // Numismatist Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_3A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_3B;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_TRADE_3_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_TRADE_3_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_TRADE_3_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_4A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_4B;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_LOOT_BOX_DISPLAY_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_LOOT_BOX_LOOT_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_5A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_REQUEST_5B;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_OFFER;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_REQUEST_1A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_REQUEST_1B;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_REQUEST_2A;
    public static final ForgeConfigSpec.ConfigValue<String> NUMISMATIST_RARE_REQUEST_2B;
    // Wandering Trader Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_3;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_4;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_6;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_6_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_7;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_7;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_7_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_8;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_8;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_9;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_9;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_REQUEST_10;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_OFFER_10;
    public static final ForgeConfigSpec.IntValue WANDERING_OFFER_10_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> WANDERING_RARE_OFFER_4;
    // Leprechaun Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_2_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_3_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEPRECHAUN_5_OFFER_3;
    // Banker Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> BANKER_5_OFFER_4;
    // Weaponsmith Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> WEAPONSMITH_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> WEAPONSMITH_5_OFFER_2;
    // Toolsmith Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> TOOLSMITH_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> TOOLSMITH_5_OFFER_3;
    // Shepherd Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_2_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_2_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_4_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHEPHERD_5_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> SHEPHERD_5_OFFER_2;
    // Mason Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> MASON_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> MASON_5_OFFER_2;
    // Librarian Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> LIBRARIAN_3_REQUEST_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> LIBRARIAN_3_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> LIBRARIAN_5_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LIBRARIAN_5_REQUEST_3;
    // Leatherworker Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEATHERWORKER_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEATHERWORKER_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> LEATHERWORKER_5_OFFER_2;
    // Fletcher Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FLETCHER_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FLETCHER_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FLETCHER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FLETCHER_5_REQUEST_2;
    // Fisherman Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_1_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_2_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_4_REQUEST_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FISHERMAN_5_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FISHERMAN_5_OFFER_2;
    // Farmer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_2_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_3_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_3_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> FARMER_4_OFFER_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> FARMER_5_OFFER_2;
    // Cleric Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CLERIC_5_OFFER_2;
    // Cartographer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> CARTOGRAPHER_2_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_REQUEST_2_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_REQUEST_2_MAP_MARKER;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> CARTOGRAPHER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2_SECONDARY;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2_MAP_NAME;
    public static final ForgeConfigSpec.ConfigValue<String> CARTOGRAPHER_5_REQUEST_2_MAP_MARKER;
    // Butcher Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_1_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_1_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_2_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_3_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_3_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_4_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_4_OFFER_4_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_5_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BUTCHER_5_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BUTCHER_5_OFFER_2_COUNT;
    // Armorer Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_1_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_2_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_4;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_5;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_5;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_REQUEST_6;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_3_OFFER_6;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_REQUEST_3;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_4_OFFER_3;
    public static final ForgeConfigSpec.ConfigValue<Integer> ARMORER_4_OFFER_3_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> ARMORER_5_OFFER_2;
    // FriendsAndFoes mod
    // Beekeeper Trade Variables
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_1_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_1_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_1_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_1_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_2_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_2_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_2_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_2_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_3_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_3_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_3_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_3_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_4_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<Integer> BEEKEEPER_4_REQUEST_1_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_4_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_4_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_4_OFFER_2;
    public static final ForgeConfigSpec.ConfigValue<Integer> BEEKEEPER_4_OFFER_2_COUNT;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_5_REQUEST_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_5_OFFER_1;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_5_REQUEST_2;
    public static final ForgeConfigSpec.ConfigValue<String> BEEKEEPER_5_OFFER_2;

    // general trade variable setters
    static {
        BUILDER.push("General Trade Settings");
        USE_MOD_TRADES = BUILDER
                .comment(" Use Loot Table Trades?")
                .define("use_loot_table_trades", false);
        BASE_XP = BUILDER
                .comment("Default Base XP per Level")
                .defineInRange("default_base_xp_per_level", 5, 0, Integer.MAX_VALUE);
        MAX_USES = BUILDER
                .comment("Default Max Uses per Trade")
                .defineInRange("default_max_uses_per_trade", 12, 1, Integer.MAX_VALUE);
        RARE_MAX_USES = BUILDER
                .comment("Default Max Uses per Rare Trade")
                .defineInRange("default_max_uses_per_rare_trade", 3, 1, Integer.MAX_VALUE);
        PRICE_MULTIPLIER = BUILDER
                .comment("Default Price Multiplier")
                .defineInRange("default_common_price_multiplier", 0.05, 0, Double.MAX_VALUE);
        RARE_PRICE_MULTIPLIER = BUILDER
                .comment("Default Price Multiplier")
                .defineInRange("default_rare_price_multiplier", 0.2, 0, Double.MAX_VALUE);
        RESET_TRADES_ON_RESTOCK = BUILDER
                .comment(" Reset Villager Trades on Restock?")
                .define("reset_trades_on_restock", false);
        BUILDER.pop();

        // FriendsAndFoes Trades
        // BEEKEEPER TRADES
        BUILDER.push("Beekeeper Trade Settings");
        // level 1
        BUILDER.push("Beekeeper Level One Trade One");
        BEEKEEPER_1_REQUEST_1 = BUILDER
                .comment("Beekeeper 1 Trade Request 1 Table")
                .define("beekeeper_1_trade_request_1_table",
                        TradeLootTables.FLOWER_BUY_TABLE.toString());
        BEEKEEPER_1_OFFER_1 = BUILDER
                .comment("Beekeeper 1 Trade Offer 1 Table")
                .define("beekeeper_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level One Trade Two");
        BEEKEEPER_1_REQUEST_2 = BUILDER
                .comment("Beekeeper 1 Trade Request 2 Table")
                .define("beekeeper_1_trade_request_2_table",
                        TradeLootTables.GLASS_BOTTLE_TABLE.toString());
        BEEKEEPER_1_OFFER_2 = BUILDER
                .comment("Beekeeper 1 Trade Offer 2 Table")
                .define("beekeeper_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Beekeeper Level Two Trade One");
        BEEKEEPER_2_REQUEST_1 = BUILDER
                .comment("Beekeeper 2 Trade Request 1 Table")
                .define("beekeeper_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_2_OFFER_1 = BUILDER
                .comment("Beekeeper 2 Trade Offer 1 Table")
                .define("beekeeper_2_trade_offer_1_table",
                        TradeLootTables.BOTTLED_HONEY_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level Two Trade Two");
        BEEKEEPER_2_REQUEST_2 = BUILDER
                .comment("Beekeeper 2 Trade Request 2 Table")
                .define("beekeeper_2_trade_request_2_table",
                        TradeLootTables.SHEARS_TABLE.toString());
        BEEKEEPER_2_OFFER_2 = BUILDER
                .comment("Beekeeper 2 Trade Offer 2 Table")
                .define("beekeeper_2_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Beekeeper Level Three Trade One");
        BEEKEEPER_3_REQUEST_1 = BUILDER
                .comment("Beekeeper 3 Trade Request 1 Table")
                .define("beekeeper_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_3_OFFER_1 = BUILDER
                .comment("Beekeeper 3 Trade Offer 1 Table")
                .define("beekeeper_3_trade_offer_1_table",
                        TradeLootTables.HONEY_BLOCK_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level Three Trade Two");
        BEEKEEPER_3_REQUEST_2 = BUILDER
                .comment("Beekeeper 3 Trade Request 2 Table")
                .define("beekeeper_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_3_OFFER_2 = BUILDER
                .comment("Beekeeper 3 Trade Offer 2 Table")
                .define("beekeeper_3_trade_offer_2_table",
                        TradeLootTables.HONEY_COMB_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Beekeeper Level Four Trade One");
        BEEKEEPER_4_REQUEST_1 = BUILDER
                .comment("Beekeeper 4 Trade Request 1 Table")
                .define("beekeeper_4_trade_request_1_table",
                        TradeLootTables.TAGGED_STRING_TABLE.toString());
        BEEKEEPER_4_REQUEST_1_COUNT = BUILDER
                .define("beekeeper_4_trade_request_1_count", 16);
        BEEKEEPER_4_OFFER_1 = BUILDER
                .comment("Beekeeper 4 Trade Offer 1 Table")
                .define("beekeeper_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level Four Trade Two");
        BEEKEEPER_4_REQUEST_2 = BUILDER
                .comment("Beekeeper 4 Trade Request 2 Table")
                .define("beekeeper_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_4_OFFER_2 = BUILDER
                .comment("Beekeeper 4 Trade Offer 2 Table")
                .define("beekeeper_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_CANDLE_TABLE.toString());
        BEEKEEPER_4_OFFER_2_COUNT = BUILDER
                .define("beekeeper_4_trade_offer_2_count", 4);
        BUILDER.pop();
        // level 5
        BUILDER.push("Beekeeper Level Five Trade One");
        BEEKEEPER_5_REQUEST_1 = BUILDER
                .comment("Beekeeper 5 Trade Request 1 Table")
                .define("beekeeper_5_trade_request_1_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_5_OFFER_1 = BUILDER
                .comment("Beekeeper 5 Trade Offer 1 Table")
                .define("beekeeper_5_trade_offer_1_table",
                        TradeLootTables.BEEHIVE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Beekeeper Level Five Trade Two");
        BEEKEEPER_5_REQUEST_2 = BUILDER
                .comment("Beekeeper 5 Trade Request 2 Table")
                .define("beekeeper_5_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        BEEKEEPER_5_OFFER_2 = BUILDER
                .comment("Beekeeper 5 Trade Offer 2 Table")
                .define("beekeeper_5_trade_offer_2_table",
                        TradeLootTables.BEE_EGG_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        // Vanilla Trades
        // ARMORER TRADES
        BUILDER.push("Armorer Trade Settings");
        // level 1
        BUILDER.push("Armorer Level One Trade One");
        ARMORER_1_REQUEST_1 = BUILDER
                .comment("Armorer 1 Trade Request 1 Table")
                .define("armorer_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        ARMORER_1_OFFER_1 = BUILDER
                .comment("Armorer 1 Trade Offer 1 Table")
                .define("armorer_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level One Trade Two");
        ARMORER_1_REQUEST_2 = BUILDER
                .comment("Armorer 1 Trade Request 2 Table")
                .define("armorer_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_1_OFFER_2 = BUILDER
                .comment("Armorer 1 Trade Offer 2 Table")
                .define("armorer_1_trade_offer_2_table",
                        TradeLootTables.CHAINMAIL_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level One Trade Three");
        ARMORER_1_REQUEST_3 = BUILDER
                .comment("Armorer 1 Trade Request 3 Table")
                .define("armorer_1_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_1_OFFER_3 = BUILDER
                .comment("Armorer 1 Trade Offer 3 Table")
                .define("armorer_1_trade_offer_3_table",
                        TradeLootTables.CHAINMAIL_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level One Trade Four");
        ARMORER_1_REQUEST_4 = BUILDER
                .comment("Armorer 1 Trade Request 4 Table")
                .define("armorer_1_trade_request_4_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_1_OFFER_4 = BUILDER
                .comment("Armorer 1 Trade Offer 4 Table")
                .define("armorer_1_trade_offer_4_table",
                        TradeLootTables.CHAINMAIL_TIER_LEGGINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level One Trade Five");
        ARMORER_1_REQUEST_5 = BUILDER
                .comment("Armorer 1 Trade Request 5 Table")
                .define("armorer_1_trade_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_1_OFFER_5 = BUILDER
                .comment("Armorer 1 Trade Offer 4 Table")
                .define("armorer_1_trade_offer_4_table",
                        TradeLootTables.CHAINMAIL_TIER_BOOTS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Armorer Level Two Trade One");
        ARMORER_2_REQUEST_1 = BUILDER
                .comment("Armorer 2 Trade Request 1 Table")
                .define("armorer_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        ARMORER_2_OFFER_1 = BUILDER
                .comment("Armorer 2 Trade Offer 1 Table")
                .define("armorer_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Two Trade Two");
        ARMORER_2_REQUEST_2 = BUILDER
                .comment("Armorer 2 Trade Request 2 Table")
                .define("armorer_2_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_2_OFFER_2 = BUILDER
                .comment("Armorer 2 Trade Offer 2 Table")
                .define("armorer_2_trade_offer_2_table",
                        TradeLootTables.BELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Two Trade Three");
        ARMORER_2_REQUEST_3 = BUILDER
                .comment("Armorer 2 Trade Request 3 Table")
                .define("armorer_2_trade_request_3_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_2_OFFER_3 = BUILDER
                .comment("Armorer 2 Trade Offer 3 Table")
                .define("armorer_2_trade_offer_3_table",
                        TradeLootTables.IRON_TIER_LEGGINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Two Trade Four");
        ARMORER_2_REQUEST_4 = BUILDER
                .comment("Armorer 2 Trade Request 4 Table")
                .define("armorer_2_trade_request_4_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_2_OFFER_4 = BUILDER
                .comment("Armorer 2 Trade Offer 4 Table")
                .define("armorer_2_trade_offer_4_table",
                        TradeLootTables.IRON_TIER_BOOTS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Armorer Level Three Trade One");
        ARMORER_3_REQUEST_1 = BUILDER
                .comment("Armorer 3 Trade Request 1 Table")
                .define("armorer_3_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        ARMORER_3_OFFER_1 = BUILDER
                .comment("Armorer 3 Trade Offer 1 Table")
                .define("armorer_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Two");
        ARMORER_3_REQUEST_2 = BUILDER
                .comment("Armorer 3 Trade Request 2 Table")
                .define("armorer_3_trade_request_2_table",
                        TradeLootTables.EQUIPMENT_GEMS_TABLE.toString());
        ARMORER_3_OFFER_2 = BUILDER
                .comment("Armorer 3 Trade Offer 2 Table")
                .define("armorer_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Three");
        ARMORER_3_REQUEST_3 = BUILDER
                .comment("Armorer 3 Trade Request 3 Table")
                .define("armorer_3_trade_request_3_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_3_OFFER_3 = BUILDER
                .comment("Armorer 3 Trade Offer 3 Table")
                .define("armorer_3_trade_offer_3_table",
                        TradeLootTables.IRON_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Four");
        ARMORER_3_REQUEST_4 = BUILDER
                .comment("Armorer 3 Trade Request 4 Table")
                .define("armorer_3_trade_request_4_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_3_OFFER_4 = BUILDER
                .comment("Armorer 3 Trade Offer 4 Table")
                .define("armorer_3_trade_offer_4_table",
                        TradeLootTables.IRON_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Five");
        ARMORER_3_REQUEST_5 = BUILDER
                .comment("Armorer 3 Trade Request 5 Table")
                .define("armorer_3_trade_request_5_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_3_OFFER_5 = BUILDER
                .comment("Armorer 3 Trade Offer 5 Table")
                .define("armorer_3_trade_offer_5_table",
                        TradeLootTables.SHIELD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Three Trade Six");
        ARMORER_3_REQUEST_6 = BUILDER
                .comment("Armorer 3 Trade Request 6 Table")
                .define("armorer_3_trade_request_6_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_3_OFFER_6 = BUILDER
                .comment("Armorer 3 Trade Offer 6 Table")
                .define("armorer_3_trade_offer_6_table",
                        TradeLootTables.IRON_TIER_HORSE_ARMOR_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Armorer Level Four Trade One");
        ARMORER_4_REQUEST_1 = BUILDER
                .comment("Armorer 4 Trade Request 1 Table")
                .define("armorer_4_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_4_OFFER_1 = BUILDER
                .comment("Armorer 4 Trade Offer 1 Table")
                .define("armorer_4_trade_offer_1_table",
                        TradeLootTables.DIAMOND_TIER_LEGGINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Four Trade Two");
        ARMORER_4_REQUEST_2 = BUILDER
                .comment("Armorer 4 Trade Request 2 Table")
                .define("armorer_4_trade_request_2_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_4_OFFER_2 = BUILDER
                .comment("Armorer 4 Trade Offer 2 Table")
                .define("armorer_4_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_BOOTS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Four Trade Three")
                .comment("Available if Supplementaries mod or Turtle Block Academy mod is Loaded");
        ARMORER_4_REQUEST_3 = BUILDER
                .comment("Armorer 4 Trade Request 3 Table")
                .define("armorer_4_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_4_OFFER_3 = BUILDER
                .comment("Armorer 4 Trade Offer 3 Table")
                .define("armorer_4_trade_offer_3_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        ARMORER_4_OFFER_3_COUNT = BUILDER
                .define("armorer_4_trade_offer_3_count", 18);
        BUILDER.pop();
        // level 5
        BUILDER.push("Armorer Level Five Trade One");
        ARMORER_5_REQUEST_1 = BUILDER
                .comment("Armorer 5 Trade Request 1 Table")
                .define("armorer_5_trade_request_1_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_5_OFFER_1 = BUILDER
                .comment("Armorer 5 Trade Offer 1 Table")
                .define("armorer_5_trade_offer_1_table",
                        TradeLootTables.DIAMOND_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Armorer Level Five Trade Two");
        ARMORER_5_REQUEST_2 = BUILDER
                .comment("Armorer 5 Trade Request 2 Table")
                .define("armorer_5_trade_request_2_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        ARMORER_5_OFFER_2 = BUILDER
                .comment("Armorer 5 Trade Offer 2 Table")
                .define("armorer_5_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();
        // BUTCHER TRADES
        BUILDER.push("Butcher Trade Settings");
        // level 1
        BUILDER.push("Butcher Level One Trade One");
        BUTCHER_1_REQUEST_1 = BUILDER
                .comment("Butcher 1 Trade Request 1 Table")
                .define("butcher_1_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_MEATS_TABLE.toString());
        BUTCHER_1_REQUEST_1_COUNT = BUILDER
                .define("butcher_1_trade_request_1_count", 12);
        BUTCHER_1_OFFER_1 = BUILDER
                .comment("Butcher 1 Trade Offer 1 Table")
                .define("butcher_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level One Trade Two");
        BUTCHER_1_REQUEST_2 = BUILDER
                .comment("Butcher 1 Trade Request 2 Table")
                .define("butcher_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_1_OFFER_2 = BUILDER
                .comment("Butcher 1 Trade Offer 2 Table")
                .define("butcher_1_trade_offer_2_table",
                        TradeLootTables.TAGGED_MEAT_SOUPS_TABLE.toString());
        BUTCHER_1_OFFER_2_COUNT = BUILDER
                .define("butcher_1_trade_offer_2_count", 1);
        BUILDER.pop();
        // level 2
        BUILDER.push("Butcher Level Two Trade One");
        BUTCHER_2_REQUEST_1 = BUILDER
                .comment("Butcher 2 Trade Request 1 Table")
                .define("butcher_2_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        BUTCHER_2_OFFER_1 = BUILDER
                .comment("Butcher 2 Trade Offer 1 Table")
                .define("butcher_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Two Trade Two");
        BUTCHER_2_REQUEST_2 = BUILDER
                .comment("Butcher 2 Trade Request 2 Table")
                .define("butcher_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_2_OFFER_2 = BUILDER
                .comment("Butcher 2 Trade Offer 2 Table")
                .define("butcher_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        BUTCHER_2_OFFER_2_COUNT = BUILDER
                .define("butcher_2_trade_offer_2_count", 6);
        BUILDER.pop();
        // level 3
        BUILDER.push("Butcher Level Three Trade One");
        BUTCHER_3_REQUEST_1 = BUILDER
                .comment("Butcher 3 Trade Request 1 Table")
                .define("butcher_3_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_MEATS_TABLE.toString());
        BUTCHER_3_REQUEST_1_COUNT = BUILDER
                .define("butcher_3_trade_request_1_count", 12);
        BUTCHER_3_OFFER_1 = BUILDER
                .comment("Butcher 3 Trade Offer 1 Table")
                .define("butcher_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Three Trade Two")
                .comment("Available if Farmers Delight mod is Loaded");
        BUTCHER_3_REQUEST_2 = BUILDER
                .comment("Butcher 3 Trade Request 2 Table")
                .define("butcher_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_3_OFFER_2 = BUILDER
                .comment("Butcher 3 Trade Offer 2 Table")
                .define("butcher_3_trade_offer_2_table",
                        TradeLootTables.STONE_TIER_KNIVES.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Three Trade Three");
        BUTCHER_3_REQUEST_3 = BUILDER
                .comment("Butcher 3 Trade Request 3 Table")
                .define("butcher_3_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_3_OFFER_3 = BUILDER
                .comment("Butcher 2 Trade Offer 2 Table")
                .define("butcher_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        BUTCHER_3_OFFER_3_COUNT = BUILDER
                .define("butcher_2_trade_offer_2_count", 6);
        BUILDER.pop();
        // level 4
        BUILDER.push("Butcher Level Four Trade One");
        BUTCHER_4_REQUEST_1 = BUILDER
                .comment("Butcher 4 Trade Request 1 Table")
                .define("butcher_4_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        BUTCHER_4_OFFER_1 = BUILDER
                .comment("Butcher 4 Trade Offer 1 Table")
                .define("butcher_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Four Trade Two")
                .comment("Available if Salt mod or Turtle Block Academy mod is Loaded");
        BUTCHER_4_REQUEST_2 = BUILDER
                .comment("Butcher 4 Trade Request 2 Table")
                .define("butcher_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_4_OFFER_2 = BUILDER
                .comment("Butcher 4 Trade Offer 2 Table")
                .define("butcher_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_SALTS_TABLE.toString());
        BUTCHER_4_OFFER_2_COUNT = BUILDER
                .define("butcher_4_trade_offer_2_count", 18);
        BUILDER.pop();
        BUILDER.push("Butcher Level Four Trade Three")
                .comment("Available if Supplementaries mod or Turtle Block Academy mod is Loaded");
        BUTCHER_4_REQUEST_3 = BUILDER
                .comment("Butcher 4 Trade Request 3 Table")
                .define("butcher_4_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_4_OFFER_3 = BUILDER
                .comment("Butcher 4 Trade Offer 3 Table")
                .define("butcher_4_trade_offer_3_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        BUTCHER_4_OFFER_3_COUNT = BUILDER
                .define("butcher_4_trade_offer_3_count", 18);
        BUILDER.pop();
        BUILDER.push("Butcher Level Four Trade Four");
        BUTCHER_4_REQUEST_4 = BUILDER
                .comment("Butcher 4 Trade Request 4 Table")
                .define("butcher_4_trade_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_4_OFFER_4 = BUILDER
                .comment("Butcher 4 Trade Offer 4 Table")
                .define("butcher_4_trade_offer_4_table",
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        BUTCHER_4_OFFER_4_COUNT = BUILDER
                .define("butcher_4_trade_offer_4_count", 6);
        BUILDER.pop();
        // level 5
        BUILDER.push("Butcher Level Five Trade One");
        BUTCHER_5_REQUEST_1 = BUILDER
                .comment("Butcher 5 Trade Request 1 Table")
                .define("butcher_5_trade_request_1_table",
                        TradeLootTables.TAGGED_FOX_FOOD_TABLE.toString());
        BUTCHER_5_REQUEST_1_COUNT = BUILDER
                .define("butcher_5_trade_request_1_count", 8);
        BUTCHER_5_OFFER_1 = BUILDER
                .comment("Butcher 5 Trade Offer 1 Table")
                .define("butcher_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Butcher Level Five Trade Two");
        BUTCHER_5_REQUEST_2 = BUILDER
                .comment("Butcher 5 Trade Request 2 Table")
                .define("butcher_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUTCHER_5_OFFER_2 = BUILDER
                .comment("Butcher 5 Trade Offer 2 Table")
                .define("butcher_5_trade_offer_2_table",
                        TradeLootTables.TAGGED_COOKED_MEATS_TABLE.toString());
        BUTCHER_5_OFFER_2_COUNT = BUILDER
                .define("butcher_5_trade_offer_23_count", 6);
        BUILDER.pop();
        BUILDER.pop();
        // CARTOGRAPHER TRADES
        BUILDER.push("Cartographer Trade Settings");
        // level 1
        BUILDER.push("Cartographer Level One Trade One");
        CARTOGRAPHER_1_REQUEST_1 = BUILDER
                .comment("Cartographer 1 Trade Request 1 Table")
                .define("cartographer_1_trade_request_1_table",
                        TradeLootTables.PAPER_TABLE.toString());
        CARTOGRAPHER_1_OFFER_1 = BUILDER
                .comment("Cartographer 1 Trade Offer 1 Table")
                .define("cartographer_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level One Trade Two");
        CARTOGRAPHER_1_REQUEST_2 = BUILDER
                .comment("Cartographer 1 Trade Request 2 Table")
                .define("cartographer_1_trade_request_2_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_1_OFFER_2 = BUILDER
                .comment("Cartographer 1 Trade Offer 2 Table")
                .define("cartographer_1_trade_offer_2_table",
                        TradeLootTables.BLANK_MAP_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Cartographer Level Two Trade One");
        CARTOGRAPHER_2_REQUEST_1 = BUILDER
                .comment("Cartographer 2 Trade Request 1 Table")
                .define("cartographer_2_trade_request_1_table",
                        TradeLootTables.TAGGED_GLASS_PANES_TABLE.toString());
        CARTOGRAPHER_2_REQUEST_1_COUNT = BUILDER
                .define("cartographer_2_trade_request_1_count", 16);
        CARTOGRAPHER_2_OFFER_1 = BUILDER
                .comment("Cartographer 2 Trade Offer 1 Table")
                .define("cartographer_2_trade_offer_1_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level Two Trade Two");
        CARTOGRAPHER_2_REQUEST_2 = BUILDER
                .comment("Cartographer 2 Trade Request 2 Table")
                .define("cartographer_2_trade_request_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_2_REQUEST_2_SECONDARY = BUILDER
                .comment("Cartographer 2 Trade Secondary Request 2 Table")
                .define("cartographer_2_trade_secondary_request_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG = BUILDER
                .comment("Cartographer 2 Trade Request 2 Structure Tag")
                .define("cartographer_2_trade_secondary_request_2_structure_tag",
                        String.valueOf(ForgeTags.StructureTags.OVERWORLD_POI));
        CARTOGRAPHER_2_REQUEST_2_MAP_NAME = BUILDER
                .comment("Cartographer 2 Trade Request 2 Map Name")
                .define("cartographer_2_trade_secondary_request_2_map_name",
                        "Overworld Explorer Map");
        CARTOGRAPHER_2_REQUEST_2_MAP_MARKER = BUILDER
                .comment("Cartographer 2 Trade Request 2 Map Name")
                .define("cartographer_2_trade_secondary_request_2_map_name",
                        String.valueOf(MapDecoration.Type.TARGET_X));
        CARTOGRAPHER_2_OFFER_2 = BUILDER
                .comment("Cartographer 2 Trade Offer 2 Table")
                .define("cartographer_2_trade_offer_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Cartographer Level Three Trade One");
        CARTOGRAPHER_3_REQUEST_1 = BUILDER
                .comment("Cartographer 3 Trade Request 1 Table")
                .define("cartographer_3_trade_request_1_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        CARTOGRAPHER_3_OFFER_1 = BUILDER
                .comment("Cartographer 3 Trade Offer 1 Table")
                .define("cartographer_3_trade_offer_1_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level Three Trade Two");
        CARTOGRAPHER_3_REQUEST_2 = BUILDER
                .comment("Cartographer 3 Trade Request 2 Table")
                .define("cartographer_3_trade_request_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_3_REQUEST_2_SECONDARY = BUILDER
                .comment("Cartographer 3 Trade Secondary Request 2 Table")
                .define("cartographer_3_trade_secondary_request_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG = BUILDER
                .comment("Cartographer 3 Trade Request 2 Structure Tag")
                .define("cartographer_3_trade_secondary_request_2_structure_tag",
                        String.valueOf(ForgeTags.StructureTags.OVERWORLD_POI));
        CARTOGRAPHER_3_REQUEST_2_MAP_NAME = BUILDER
                .comment("Cartographer 3 Trade Request 2 Map Name")
                .define("cartographer_3_trade_secondary_request_2_map_name",
                        "Overworld Explorer Map");
        CARTOGRAPHER_3_REQUEST_2_MAP_MARKER = BUILDER
                .comment("Cartographer 3 Trade Request 2 Map Name")
                .define("cartographer_3_trade_secondary_request_2_map_name",
                        String.valueOf(MapDecoration.Type.TARGET_X));
        CARTOGRAPHER_3_OFFER_2 = BUILDER
                .comment("Cartographer 3 Trade Offer 2 Table")
                .define("cartographer_3_trade_offer_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Cartographer Level Four Trade One");
        CARTOGRAPHER_4_REQUEST_1 = BUILDER
                .comment("Cartographer 4 Trade Request 1 Table")
                .define("cartographer_4_trade_request_1_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_4_OFFER_1 = BUILDER
                .comment("Cartographer 4 Trade Offer 1 Table")
                .define("cartographer_4_trade_offer_1_table",
                        TradeLootTables.ITEM_FRAME_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level Four Trade Two");
        CARTOGRAPHER_4_REQUEST_2 = BUILDER
                .comment("Cartographer 4 Trade Request 2 Table")
                .define("cartographer_4_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_4_OFFER_2 = BUILDER
                .comment("Cartographer 4 Trade Offer 2 Table")
                .define("cartographer_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_BANNER_TABLE.toString());
        CARTOGRAPHER_4_OFFER_2_COUNT = BUILDER
                .define("cartographer_4_trade_offer_2_count", 3);
        BUILDER.pop();
        // level 5
        BUILDER.push("Cartographer Level Five Trade One");
        CARTOGRAPHER_5_REQUEST_1 = BUILDER
                .comment("Cartographer 5 Trade Request 1 Table")
                .define("cartographer_5_trade_request_1_table",
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_5_OFFER_1 = BUILDER
                .comment("Cartographer 5 Trade Offer 1 Table")
                .define("cartographer_5_trade_offer_1_table",
                        TradeLootTables.BANNER_PATTERN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Cartographer Level Five Trade Two");
        CARTOGRAPHER_5_REQUEST_2 = BUILDER
                .comment("Cartographer 5 Trade Request 2 Table")
                .define("cartographer_5_trade_request_2_table",
                        TradeLootTables.FOURTEEN_EMERALD_VALUE_CURRENCY.toString());
        CARTOGRAPHER_5_REQUEST_2_SECONDARY = BUILDER
                .comment("Cartographer 5 Trade Secondary Request 2 Table")
                .define("cartographer_5_trade_secondary_request_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG = BUILDER
                .comment("Cartographer 5 Trade Request 2 Structure Tag")
                .define("cartographer_5_trade_secondary_request_2_structure_tag",
                        String.valueOf(ForgeTags.StructureTags.OVERWORLD_POI));
        CARTOGRAPHER_5_REQUEST_2_MAP_NAME = BUILDER
                .comment("Cartographer 5 Trade Request 2 Map Name")
                .define("cartographer_5_trade_secondary_request_2_map_name",
                        "Overworld Explorer Map");
        CARTOGRAPHER_5_REQUEST_2_MAP_MARKER = BUILDER
                .comment("Cartographer 5 Trade Request 2 Map Name")
                .define("cartographer_5_trade_secondary_request_2_map_name",
                        String.valueOf(MapDecoration.Type.TARGET_X));
        BUILDER.pop();
        BUILDER.pop();
        // CLERIC TRADES
        BUILDER.push("Cleric Trade Settings");
        // level 1
        BUILDER.push("Cleric Level One Trade One");
        CLERIC_1_REQUEST_1 = BUILDER
                .comment("Cleric 1 Trade Request 1 Table")
                .define("cleric_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        CLERIC_1_OFFER_1 = BUILDER
                .comment("Cleric 1 Trade Offer 1 Table")
                .define("cleric_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level One Trade Two");
        CLERIC_1_REQUEST_2 = BUILDER
                .comment("Cleric 1 Trade Request 2 Table")
                .define("cleric_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_1_OFFER_2 = BUILDER
                .comment("Cleric 1 Trade Offer 2 Table")
                .define("cleric_1_trade_offer_2_table",
                        TradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Cleric Level Two Trade One");
        CLERIC_2_REQUEST_1 = BUILDER
                .comment("Cleric 2 Trade Request 1 Table")
                .define("cleric_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        CLERIC_2_OFFER_1 = BUILDER
                .comment("Cleric 2 Trade Offer 1 Table")
                .define("cleric_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Two Trade Two");
        CLERIC_2_REQUEST_2 = BUILDER
                .comment("Cleric 2 Trade Request 2 Table")
                .define("cleric_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_2_OFFER_2 = BUILDER
                .comment("Cleric 2 Trade Offer 2 Table")
                .define("cleric_2_trade_offer_2_table",
                        TradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Cleric Level Three Trade One");
        CLERIC_3_REQUEST_1 = BUILDER
                .comment("Cleric 3 Trade Request 1 Table")
                .define("cleric_3_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_MOB_PARTS_TABLE.toString());
        CLERIC_3_OFFER_1 = BUILDER
                .comment("Cleric 3 Trade Offer 1 Table")
                .define("cleric_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Three Trade Two");
        CLERIC_3_REQUEST_2 = BUILDER
                .comment("Cleric 3 Trade Request 2 Table")
                .define("cleric_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_3_OFFER_2 = BUILDER
                .comment("Cleric 3 Trade Offer 2 Table")
                .define("cleric_3_trade_offer_2_table",
                        TradeLootTables.ENCHANTING_GEMS_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Cleric Level Four Trade One");
        CLERIC_4_REQUEST_1 = BUILDER
                .comment("Cleric 4 Trade Request 1 Table")
                .define("cleric_4_trade_request_1_table",
                        TradeLootTables.SCUTE_TABLE.toString());
        CLERIC_4_OFFER_1 = BUILDER
                .comment("Cleric 4 Trade Offer 1 Table")
                .define("cleric_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Four Trade Two");
        CLERIC_4_REQUEST_2 = BUILDER
                .comment("Cleric 4 Trade Request 2 Table")
                .define("cleric_4_trade_request_2_table",
                        TradeLootTables.GLASS_BOTTLE_TABLE.toString());
        CLERIC_4_OFFER_2 = BUILDER
                .comment("Cleric 4 Trade Offer 2 Table")
                .define("cleric_4_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Four Trade Three");
        CLERIC_4_REQUEST_3 = BUILDER
                .comment("Cleric 4 Trade Request 3 Table")
                .define("cleric_4_trade_request_3_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_4_OFFER_3 = BUILDER
                .comment("Cleric 4 Trade Offer 3 Table")
                .define("cleric_4_trade_offer_3_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Cleric Level Five Trade One");
        CLERIC_5_REQUEST_1 = BUILDER
                .comment("Cleric 5 Trade Request 1 Table")
                .define("cleric_5_trade_request_1_table",
                        TradeLootTables.POTION_INGREDIENTS_TABLE.toString());
        CLERIC_5_OFFER_1 = BUILDER
                .comment("Cleric 5 Trade Offer 1 Table")
                .define("cleric_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Cleric Level Five Trade Two");
        CLERIC_5_REQUEST_2 = BUILDER
                .comment("Cleric 5 Trade Request 2 Table")
                .define("cleric_5_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        CLERIC_5_OFFER_2 = BUILDER
                .comment("Cleric 5 Trade Offer 2 Table")
                .define("cleric_5_trade_offer_2_table",
                        TradeLootTables.EXPERIENCE_BOTTLE_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();
        // FARMER TRADES
        BUILDER.push("Farmer Trade Settings");
        // level 1
        BUILDER.push("Farmer Level One Trade One");
        FARMER_1_REQUEST_1 = BUILDER
                .comment("Farmer 1 Trade Request 1 Table")
                .define("farmer_1_trade_request_1_table",
                        TradeLootTables.TAGGED_VEGGIES_AND_GRAINS_TABLE.toString());
        FARMER_1_REQUEST_1_COUNT = BUILDER
                .define("farmer_1_trade_request_1_count", 24);
        FARMER_1_OFFER_1 = BUILDER
                .comment("Farmer 1 Trade Offer 1 Table")
                .define("farmer_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Farmer Level One Trade Two");
        FARMER_1_REQUEST_2 = BUILDER
                .comment("Farmer 1 Trade Request 2 Table")
                .define("farmer_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_1_OFFER_2 = BUILDER
                .comment("Farmer 1 Trade Offer 2 Table")
                .define("farmer_1_trade_offer_2_table",
                        TradeLootTables.TAGGED_BREADS_TABLE.toString());
        FARMER_1_OFFER_2_COUNT = BUILDER
                .define("farmer_1_trade_offer_2_count", 6);
        BUILDER.pop();
        // level 2
        BUILDER.push("Farmer Level Two Trade One");
        FARMER_2_REQUEST_1 = BUILDER
                .comment("Farmer 2 Trade Request 1 Table")
                .define("farmer_2_trade_request_1_table",
                        TradeLootTables.TAGGED_GOURDS_TABLE.toString());
        FARMER_2_REQUEST_1_COUNT = BUILDER
                .define("farmer_2_trade_request_1_count", 6);
        FARMER_2_OFFER_1 = BUILDER
                .comment("Farmer 2 Trade Offer 1 Table")
                .define("farmer_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Farmer Level Two Trade Two");
        FARMER_2_REQUEST_2 = BUILDER
                .comment("Farmer 2 Trade Request 2 Table")
                .define("farmer_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_2_OFFER_2 = BUILDER
                .comment("Farmer 2 Trade Offer 2 Table")
                .define("farmer_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_PIES_TABLE.toString());
        FARMER_2_OFFER_2_COUNT = BUILDER
                .define("farmer_2_trade_offer_2_count", 4);
        BUILDER.pop();
        // level 3
        BUILDER.push("Farmer Level Three Trade One");
        FARMER_3_REQUEST_1 = BUILDER
                .comment("Farmer 3 Trade Request 1 Table")
                .define("farmer_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_3_OFFER_1 = BUILDER
                .comment("Farmer 3 Trade Offer 1 Table")
                .define("farmer_3_trade_offer_1_table",
                        TradeLootTables.TAGGED_FRUITS_TABLE.toString());
        FARMER_3_OFFER_1_COUNT = BUILDER
                .define("farmer_3_trade_offer_1_count", 6);
        BUILDER.pop();
        BUILDER.push("Farmer Level Three Trade Two");
        FARMER_3_REQUEST_2 = BUILDER
                .comment("Farmer 3 Trade Request 2 Table")
                .define("farmer_3_trade_request_2_count",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_3_OFFER_2 = BUILDER
                .comment("Farmer 3 Trade Offer 2 Table")
                .define("farmer_3_trade_offer_2_table",
                        TradeLootTables.TAGGED_COOKIES_TABLE.toString());
        FARMER_3_OFFER_2_COUNT = BUILDER
                .define("farmer_3_trade_offer_2_count", 8);
        BUILDER.pop();
        // level 4
        BUILDER.push("Farmer Level Four Trade One");
        FARMER_4_REQUEST_1 = BUILDER
                .comment("Farmer 4 Trade Request 1 Table")
                .define("farmer_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_4_OFFER_1 = BUILDER
                .comment("Farmer 4 Trade Offer 1 Table")
                .define("farmer_4_trade_offer_1_table",
                        TradeLootTables.TAGGED_CAKES_TABLE.toString());
        FARMER_4_OFFER_1_COUNT = BUILDER
                .define("farmer_4_trade_offer_1_count", 1);
        BUILDER.pop();
        BUILDER.push("Farmer Level Four Trade Two");
        FARMER_4_REQUEST_2 = BUILDER
                .comment("Farmer 4 Trade Request 2 Table")
                .comment("Suspicious Stew Trade - adds all registered mob effects")
                .define("farmer_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Farmer Level Five Trade One");
        FARMER_5_REQUEST_1 = BUILDER
                .comment("Farmer 5 Trade Request 1 Table")
                .define("farmer_5_trade_request_1_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_5_OFFER_1 = BUILDER
                .comment("Farmer 5 Trade Offer 1 Table")
                .define("farmer_5_trade_offer_1_table",
                        TradeLootTables.GOLDEN_FOOD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Farmer Level Five Trade Two");
        FARMER_5_REQUEST_2 = BUILDER
                .comment("Farmer 5 Trade Request 2 Table")
                .define("farmer_5_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        FARMER_5_OFFER_2 = BUILDER
                .comment("Farmer 5 Trade Offer 2 Table")
                .define("farmer_5_trade_offer_2_table",
                        TradeLootTables.GOLDEN_FOOD_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();
        // FISHERMAN TRADES
        BUILDER.push("Fisherman Trade Settings");
        // level 1
        BUILDER.push("Fisherman Level One Trade One");
        FISHERMAN_1_REQUEST_1 = BUILDER
                .comment("Fisherman 1 Trade Request 1 Table")
                .define("fisherman_1_trade_request_1_table",
                        TradeLootTables.TAGGED_STRING_TABLE.toString());
        FISHERMAN_1_REQUEST_1_COUNT = BUILDER
                .define("fisherman_1_trade_request_1_count", 16);
        FISHERMAN_1_OFFER_1 = BUILDER
                .comment("Fisherman 1 Trade Offer 1 Table")
                .define("fisherman_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level One Trade Two");
        FISHERMAN_1_REQUEST_2 = BUILDER
                .comment("Fisherman 1 Trade Request 2 Table")
                .define("fisherman_1_trade_request_2_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        FISHERMAN_1_OFFER_2 = BUILDER
                .comment("Fisherman 1 Trade Offer 2 Table")
                .define("fisherman_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level One Trade Three");
        FISHERMAN_1_REQUEST_3 = BUILDER
                .comment("Fisherman 1 Trade Request 3 Table")
                .define("fisherman_1_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_1_OFFER_3 = BUILDER
                .comment("Fisherman 1 Trade Offer 3 Table")
                .define("fisherman_1_trade_offer_3_table",
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE.toString());
        FISHERMAN_1_OFFER_3_COUNT = BUILDER
                .define("fisherman_1_trade_offer_3_count", 6);
        BUILDER.pop();
        BUILDER.push("Fisherman Level One Trade Four");
        FISHERMAN_1_REQUEST_4 = BUILDER
                .comment("Fisherman 1 Trade Request 4 Table")
                .define("fisherman_1_trade_request_4_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_1_OFFER_4 = BUILDER
                .comment("Fisherman 1 Trade Offer 4 Table")
                .define("fisherman_1_trade_offer_4_table",
                        TradeLootTables.FISH_BUCKET_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Fisherman Level Two Trade One");
        FISHERMAN_2_REQUEST_1 = BUILDER
                .comment("Fisherman 2 Trade Request 1 Table")
                .define("fisherman_2_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        FISHERMAN_2_REQUEST_1_COUNT = BUILDER
                .define("fisherman_2_trade_request_1_count", 6);
        FISHERMAN_2_OFFER_1 = BUILDER
                .comment("Fisherman 2 Trade Offer 1 Table")
                .define("fisherman_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level Two Trade Three");
        FISHERMAN_2_REQUEST_2 = BUILDER
                .comment("Fisherman 2 Trade Request 2 Table")
                .define("fisherman_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_2_OFFER_2 = BUILDER
                .comment("Fisherman 2 Trade Offer 2 Table")
                .define("fisherman_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_PREPARED_SEAFOOD_TABLE.toString());
        FISHERMAN_2_OFFER_2_COUNT = BUILDER
                .define("fisherman_2_trade_offer_2_count", 6);
        BUILDER.pop();
        BUILDER.push("Fisherman Level Two Trade Three");
        FISHERMAN_2_REQUEST_3 = BUILDER
                .comment("Fisherman 2 Trade Request 3 Table")
                .define("fisherman_2_trade_request_3_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_2_OFFER_3 = BUILDER
                .comment("Fisherman 2 Trade Offer 3 Table")
                .define("fisherman_2_trade_offer_3_table",
                        TradeLootTables.CAMPFIRE_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Fisherman Level Three Trade One");
        FISHERMAN_3_REQUEST_1 = BUILDER
                .comment("Fisherman 3 Trade Request 1 Table")
                .define("fisherman_3_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        FISHERMAN_3_REQUEST_1_COUNT = BUILDER
                .define("fisherman_3_trade_request_1_count", 6);
        FISHERMAN_3_OFFER_1 = BUILDER
                .comment("Fisherman 3 Trade Offer 1 Table")
                .define("fisherman_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level Three Trade Two");
        FISHERMAN_3_REQUEST_2 = BUILDER
                .comment("Fisherman 3 Trade Request 2 Table")
                .define("fisherman_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_3_OFFER_2 = BUILDER
                .comment("Fisherman 3 Trade Offer 2 Table")
                .define("fisherman_3_trade_offer_2_table",
                        TradeLootTables.FISHING_GEAR_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Fisherman Level Four Trade One");
        FISHERMAN_4_REQUEST_1 = BUILDER
                .comment("Fisherman 4 Trade Request 1 Table")
                .define("fisherman_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_4_OFFER_1 = BUILDER
                .comment("Fisherman 4 Trade Offer 1 Table")
                .comment("Available if Supplementaries or Turtle Block Academy mod is Loaded")
                .define("fisherman_4_trade_offer_1_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        FISHERMAN_4_OFFER_1_COUNT = BUILDER
                .define("fisherman_4_trade_offer_1_count", 18);
        BUILDER.pop();
        BUILDER.push("Fisherman Level Four Trade Two");
        FISHERMAN_4_REQUEST_2 = BUILDER
                .comment("Fisherman 4 Trade Request 2 Table")
                .define("fisherman_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_4_OFFER_2 = BUILDER
                .comment("Fisherman 4 Trade Offer 2 Table")
                .define("fisherman_4_trade_offer_2_table",
                        TradeLootTables.FISHING_ROD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level Four Trade Three");
        FISHERMAN_4_REQUEST_3 = BUILDER
                .comment("Fisherman 4 Trade Request 3 Table")
                .define("fisherman_4_trade_request_3_table",
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        FISHERMAN_4_REQUEST_3_COUNT = BUILDER
                .define("fisherman_4_trade_request_3_count", 6);
        FISHERMAN_4_OFFER_3 = BUILDER
                .comment("Fisherman 4 Trade Offer 3 Table")
                .define("fisherman_4_trade_offer_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Fisherman Level Five Trade One");
        FISHERMAN_5_REQUEST_1 = BUILDER
                .comment("Fisherman 5 Trade Request 1 Table")
                .define("fisherman_5_trade_request_1_table",
                        TradeLootTables.TAGGED_RAW_SEAFOOD_TABLE.toString());
        FISHERMAN_5_REQUEST_1_COUNT = BUILDER
                .define("fisherman_5_trade_request_1_count", 6);
        FISHERMAN_5_OFFER_1 = BUILDER
                .comment("Fisherman 5 Trade Offer 1 Table")
                .define("fisherman_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fisherman Level Five Trade Two");
        FISHERMAN_5_REQUEST_2 = BUILDER
                .comment("Fisherman 5 Trade Request 2 Table")
                .define("fisherman_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FISHERMAN_5_OFFER_2 = BUILDER
                .comment("Fisherman 5 Trade Offer 2 Table")
                .define("fisherman_5_trade_offer_2_table",
                        TradeLootTables.FISHING_GEAR_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();
        // FLETCHER TRADES
        BUILDER.push("Fletcher Trade Settings");
        // level 1
        BUILDER.push("Fletcher Level One Trade One");
        FLETCHER_1_REQUEST_1 = BUILDER
                .comment("Fletcher 1 Trade Request 1 Table")
                .define("fletcher_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_TABLE.toString());
        FLETCHER_1_REQUEST_1_COUNT = BUILDER
                .define("fletcher_1_trade_request_1_count", 16);
        FLETCHER_1_OFFER_1 = BUILDER
                .comment("Fletcher 1 Trade Offer 1 Table")
                .define("fletcher_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level One Trade Two");
        FLETCHER_1_REQUEST_2 = BUILDER
                .comment("Fletcher 1 Trade Request 2 Table")
                .define("fletcher_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        FLETCHER_1_REQUEST_2_SECONDARY = BUILDER
                .comment("Fletcher 1 Trade Secondary Request 2 Table")
                .define("fletcher_1_trade_secondary_request_2_table",
                        TradeLootTables.GRAVEL_TABLE.toString());
        FLETCHER_1_OFFER_2 = BUILDER
                .comment("Fletcher 1 Trade Offer 2 Table")
                .define("fletcher_1_trade_offer_2_table",
                        TradeLootTables.FLINT_SELL_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Fletcher Level Two Trade One");
        FLETCHER_2_REQUEST_1 = BUILDER
                .comment("Fletcher 2 Trade Request 1 Table")
                .define("fletcher_2_trade_request_1_table",
                        TradeLootTables.FLINT_BUY_TABLE.toString());
        FLETCHER_2_OFFER_1 = BUILDER
                .comment("Fletcher 2 Trade Offer 1 Table")
                .define("fletcher_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level Two Trade Two");
        FLETCHER_2_REQUEST_2 = BUILDER
                .comment("Fletcher 2 Trade Request 2 Table")
                .define("fletcher_2_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        FLETCHER_2_OFFER_2 = BUILDER
                .comment("Fletcher 2 Trade Offer 2 Table")
                .define("fletcher_2_trade_offer_2_table",
                        TradeLootTables.BOWS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Fletcher Level Three Trade One");
        FLETCHER_3_REQUEST_1 = BUILDER
                .comment("Fletcher 3 Trade Request 1 Table")
                .define("fletcher_3_trade_request_1_table",
                        TradeLootTables.TAGGED_STRING_TABLE.toString());
        FLETCHER_3_REQUEST_1_COUNT = BUILDER
                .define("fletcher_3_trade_request_1_count", 16);
        FLETCHER_3_OFFER_1 = BUILDER
                .comment("Fletcher 3 Trade Offer 1 Table")
                .define("fletcher_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level Three Trade Two");
        FLETCHER_3_REQUEST_2 = BUILDER
                .comment("Fletcher 3 Trade Request 2 Table")
                .define("fletcher_3_trade_request_2_table",
                        TradeLootTables.FEATHER_TABLE.toString());
        FLETCHER_3_OFFER_2 = BUILDER
                .comment("Fletcher 3 Trade Offer 2 Table")
                .define("fletcher_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Fletcher Level Four Trade One");
        FLETCHER_4_REQUEST_1 = BUILDER
                .comment("Fletcher 4 Trade Request 1 Table")
                .define("fletcher_4_trade_request_1_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        FLETCHER_4_OFFER_1 = BUILDER
                .comment("Fletcher 4 Trade Offer 1 Table")
                .define("fletcher_4_trade_offer_1_table",
                        TradeLootTables.BOWS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level Four Trade Two");
        FLETCHER_4_REQUEST_2 = BUILDER
                .comment("Fletcher 4 Trade Request 2 Table")
                .comment("Available if Supplementaries mod is Loaded")
                .define("fletcher_4_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        FLETCHER_4_OFFER_2 = BUILDER
                .comment("Fletcher 4 Trade Offer 2 Table")
                .comment("Available if Supplementaries mod is Loaded")
                .define("fletcher_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_QUIVERS_TABLE.toString());
        FLETCHER_4_OFFER_2_COUNT = BUILDER
                .define("fletcher_4_trade_offer_2_count", 1);
        BUILDER.pop();
        BUILDER.push("Fletcher Level Four Trade Two");
        FLETCHER_4_REQUEST_3 = BUILDER
                .comment("Fletcher 4 Trade Request 3 Table")
                .define("fletcher_4_trade_request_3_table",
                        TradeLootTables.TRIPWIRE_HOOK_TABLE.toString());
        FLETCHER_4_OFFER_3 = BUILDER
                .comment("Fletcher 4 Trade Offer 3 Table")
                .define("fletcher_4_trade_offer_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Fletcher Level Five Trade One");
        FLETCHER_5_REQUEST_1 = BUILDER
                .comment("Fletcher 5 Trade Request 1 Table")
                .comment("Tipped Arrow Trade")
                .define("fletcher_5_trade_request_1_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Fletcher Level Five Trade Two");
        FLETCHER_5_REQUEST_2 = BUILDER
                .comment("Fletcher 5 Trade Request 2 Table")
                .comment("Tipped Arrow Trade")
                .define("fletcher_5_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();
        // LEATHERWORKER TRADES
        BUILDER.push("Leatherworker Trade Settings");
        // level 1
        BUILDER.push("Leatherworker Level One Trade One");
        LEATHERWORKER_1_REQUEST_1 = BUILDER
                .comment("Leatherworker 1 Trade Request 1 Table")
                .define("leatherworker_1_trade_request_1_table",
                        TradeLootTables.TAGGED_LEATHER_TABLE.toString());
        LEATHERWORKER_1_REQUEST_1_COUNT = BUILDER
                .define("leatherworker_1_trade_request_1_count", 6);
        LEATHERWORKER_1_OFFER_1 = BUILDER
                .comment("Leatherworker 1 Trade Offer 1 Table")
                .define("leatherworker_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level One Trade Two");
        LEATHERWORKER_1_REQUEST_2 = BUILDER
                .comment("Leatherworker 1 Trade Request 2 Table")
                .define("leatherworker_1_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_1_OFFER_2 = BUILDER
                .comment("Leatherworker 1 Trade Offer 2 Table")
                .define("leatherworker_1_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_LEGGINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level One Trade Three");
        LEATHERWORKER_1_REQUEST_3 = BUILDER
                .comment("Leatherworker 1 Trade Request 3 Table")
                .define("leatherworker_1_trade_request_3_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_1_OFFER_3 = BUILDER
                .comment("Leatherworker 1 Trade Offer 3 Table")
                .define("leatherworker_1_trade_offer_3_table",
                        TradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Leatherworker Level Two Trade One");
        LEATHERWORKER_2_REQUEST_1 = BUILDER
                .comment("Leatherworker 2 Trade Request 1 Table")
                .define("leatherworker_2_trade_request_1_table",
                        TradeLootTables.FLINT_BUY_TABLE.toString());
        LEATHERWORKER_2_OFFER_1 = BUILDER
                .comment("Leatherworker 2 Trade Offer 1 Table")
                .define("leatherworker_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Two Trade Two");
        LEATHERWORKER_2_REQUEST_2 = BUILDER
                .comment("Leatherworker 2 Trade Request 2 Table")
                .define("leatherworker_2_trade_request_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_2_OFFER_2 = BUILDER
                .comment("Leatherworker 2 Trade Offer 2 Table")
                .define("leatherworker_2_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Two Trade Three");
        LEATHERWORKER_2_REQUEST_3 = BUILDER
                .comment("Leatherworker 2 Trade Request 3 Table")
                .define("leatherworker_2_trade_request_3_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_2_OFFER_3 = BUILDER
                .comment("Leatherworker 2 Trade Offer 3 Table")
                .define("leatherworker_2_trade_offer_3_table",
                        TradeLootTables.LEATHER_TIER_BOOTS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Leatherworker Level Three Trade One");
        LEATHERWORKER_3_REQUEST_1 = BUILDER
                .comment("Leatherworker 3 Trade Request 1 Table")
                .define("leatherworker_3_trade_request_1_table",
                        TradeLootTables.TAGGED_LEATHER_TABLE.toString());
        LEATHERWORKER_3_REQUEST_1_COUNT = BUILDER
                .define("leatherworker_3_trade_request_1_count", 6);
        LEATHERWORKER_3_OFFER_1 = BUILDER
                .comment("Leatherworker 3 Trade Offer 1 Table")
                .define("leatherworker_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Three Trade Two");
        LEATHERWORKER_3_REQUEST_2 = BUILDER
                .comment("Leatherworker 3 Trade Request 2 Table")
                .define("leatherworker_3_trade_request_2_table",
                        TradeLootTables.SEVEN_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_3_OFFER_2 = BUILDER
                .comment("Leatherworker 3 Trade Offer 2 Table")
                .define("leatherworker_3_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_CHESTPLATES_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Leatherworker Level Four Trade One");
        LEATHERWORKER_4_REQUEST_1 = BUILDER
                .comment("Leatherworker 4 Trade Request 1 Table")
                .define("leatherworker_4_trade_request_1_table",
                        TradeLootTables.SCUTE_TABLE.toString());
        LEATHERWORKER_4_OFFER_1 = BUILDER
                .comment("Leatherworker 4 Trade Offer 1 Table")
                .define("leatherworker_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Four Trade Two");
        LEATHERWORKER_4_REQUEST_2 = BUILDER
                .comment("Leatherworker 4 Trade Request 2 Table")
                .define("leatherworker_4_trade_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_4_OFFER_2 = BUILDER
                .comment("Leatherworker 4 Trade Offer 2 Table")
                .define("leatherworker_4_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_HORSE_ARMOR_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Leatherworker Level Five Trade One");
        LEATHERWORKER_5_REQUEST_1 = BUILDER
                .comment("Leatherworker 5 Trade Request 1 Table")
                .define("leatherworker_5_trade_request_1_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_5_OFFER_1 = BUILDER
                .comment("Leatherworker 5 Trade Offer 1 Table")
                .define("leatherworker_5_trade_offer_1_table",
                        TradeLootTables.SADDLE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leatherworker Level Five Trade Two");
        LEATHERWORKER_5_REQUEST_2 = BUILDER
                .comment("Leatherworker 5 Trade Request 2 Table")
                .define("leatherworker_5_trade_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        LEATHERWORKER_5_OFFER_2 = BUILDER
                .comment("Leatherworker 5 Trade Offer 2 Table")
                .define("leatherworker_5_trade_offer_2_table",
                        TradeLootTables.LEATHER_TIER_HELMETS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();
        // LIBRARIAN TRADES
        BUILDER.push("Librarian Trade Settings");
        // level 1
        BUILDER.push("Librarian Level One Trade One");
        LIBRARIAN_1_REQUEST_1 = BUILDER
                .comment("Librarian 1 Trade Request 1 Table")
                .define("librarian_1_trade_request_1_table",
                        TradeLootTables.SMALLEST_COIN.toString());
        LIBRARIAN_1_OFFER_1 = BUILDER
                .comment("Librarian 1 Trade Offer 1 Table")
                .define("librarian_1_trade_offer_1_table",
                        TradeLootTables.GUIDE_BOOKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level One Trade Two");
        LIBRARIAN_1_REQUEST_2 = BUILDER
                .comment("Librarian 1 Trade Request 2 Table")
                .define("librarian_1_trade_request_2_table",
                        TradeLootTables.PAPER_TABLE.toString());
        LIBRARIAN_1_OFFER_2 = BUILDER
                .comment("Librarian 1 Trade Offer 2 Table")
                .define("librarian_1_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level One Trade Three");
        LIBRARIAN_1_REQUEST_3 = BUILDER
                .comment("Librarian 1 Trade Request 2 Table")
                .define("librarian_1_trade_request_3_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level One Trade Four");
        LIBRARIAN_1_REQUEST_4 = BUILDER
                .comment("Librarian 1 Trade Request 4 Table")
                .define("librarian_1_trade_request_4_table",
                        TradeLootTables.NINE_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_1_OFFER_4 = BUILDER
                .comment("Librarian 1 Trade Offer 4 Table")
                .define("librarian_1_trade_offer_4_table",
                        TradeLootTables.BOOKSHELF_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Librarian Level Two Trade One");
        LIBRARIAN_2_REQUEST_1 = BUILDER
                .comment("Librarian 2 Trade Request 1 Table")
                .define("librarian_2_trade_request_1_table",
                        TradeLootTables.BOOK_TABLE.toString());
        LIBRARIAN_2_OFFER_1 = BUILDER
                .comment("Librarian 2 Trade Offer 1 Table")
                .define("librarian_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Two Trade Two");
        LIBRARIAN_2_REQUEST_2 = BUILDER
                .comment("Librarian 2 Trade Request 2 Table")
                .define("librarian_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Two Trade Three");
        LIBRARIAN_2_REQUEST_3 = BUILDER
                .comment("Librarian 2 Trade Request 3 Table")
                .define("librarian_2_trade_request_3_table",
                        TradeLootTables.BOOK_TABLE.toString());
        LIBRARIAN_2_OFFER_3 = BUILDER
                .comment("Librarian 2 Trade Offer 3 Table")
                .define("librarian_2_trade_offer_3_table",
                        TradeLootTables.LANTERN_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Librarian Level Three Trade One");
        LIBRARIAN_3_REQUEST_1 = BUILDER
                .comment("Librarian 3 Trade Request 1 Table")
                .define("librarian_3_trade_request_1_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Three Trade Two");
        LIBRARIAN_3_REQUEST_2 = BUILDER
                .comment("Librarian 3 Trade Request 2 Table")
                .define("librarian_3_trade_request_2_table",
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        LIBRARIAN_3_REQUEST_2_COUNT = BUILDER
                .define("librarian_3_trade_request_2_count", 1);
        LIBRARIAN_3_OFFER_2 = BUILDER
                .comment("Librarian 3 Trade Offer 2 Table")
                .define("librarian_3_trade_offer_2_table",
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Three Trade Three");
        LIBRARIAN_3_REQUEST_3 = BUILDER
                .comment("Librarian 3 Trade Request 3 Table")
                .define("librarian_3_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_3_OFFER_3 = BUILDER
                .comment("Librarian 3 Trade Offer 3 Table")
                .define("librarian_3_trade_offer_3_table",
                        TradeLootTables.TAGGED_GLASS_TABLE.toString());
        LIBRARIAN_3_OFFER_3_COUNT = BUILDER
                .define("librarian_3_trade_request_3_count", 1);
        BUILDER.pop();
        // level 4
        BUILDER.push("Librarian Level Four Trade One");
        LIBRARIAN_4_REQUEST_1 = BUILDER
                .comment("Librarian 4 Trade Request 1 Table")
                .define("librarian_4_trade_request_1_table",
                        TradeLootTables.BOOK_TABLE.toString());
        LIBRARIAN_4_OFFER_1 = BUILDER
                .comment("Librarian 4 Trade Offer 1 Table")
                .define("librarian_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Four Trade Two");
        LIBRARIAN_4_REQUEST_2 = BUILDER
                .comment("Librarian 4 Trade Request 2 Table")
                .define("librarian_4_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Four Trade Three");
        LIBRARIAN_4_REQUEST_3 = BUILDER
                .comment("Librarian 4 Trade Request 3 Table")
                .define("librarian_4_trade_request_3_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_4_OFFER_3 = BUILDER
                .comment("Librarian 4 Trade Offer 3 Table")
                .define("librarian_4_trade_offer_3_table",
                        TradeLootTables.CLOCK_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Librarian Level Five Trade One");
        LIBRARIAN_5_REQUEST_1 = BUILDER
                .comment("Librarian 5 Trade Request 1 Table")
                .define("librarian_5_trade_request_1_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_5_OFFER_1 = BUILDER
                .comment("Librarian 5 Trade Offer 1 Table")
                .define("librarian_5_trade_offer_1_table",
                        TradeLootTables.TAGGED_INK_TABLE.toString());
        LIBRARIAN_5_OFFER_1_COUNT = BUILDER
                .define("librarian_5_trade_offer_1_count", 3);
        BUILDER.pop();
        BUILDER.push("Librarian Level Five Trade Two");
        LIBRARIAN_5_REQUEST_2 = BUILDER
                .comment("Librarian 5 Trade Request 2 Table")
                .define("librarian_5_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        LIBRARIAN_5_OFFER_2 = BUILDER
                .comment("Librarian 5 Trade Offer 2 Table")
                .define("librarian_5_trade_offer_2_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Librarian Level Five Trade Three");
        LIBRARIAN_5_REQUEST_3 = BUILDER
                .comment("Librarian 5 Trade Request 3 Table")
                .define("librarian_5_trade_request_3_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();
        // MASON TRADES
        BUILDER.push("Mason Trade Settings");
        // level 1
        BUILDER.push("Mason Level One Trade One");
        MASON_1_REQUEST_1 = BUILDER
                .comment("Mason 1 Trade Request 1 Table")
                .define("mason_1_trade_request_1_table",
                        TradeLootTables.CLAY_TABLE.toString());
        MASON_1_OFFER_1 = BUILDER
                .comment("Mason 1 Trade Offer 1 Table")
                .define("mason_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level One Trade Two");
        MASON_1_REQUEST_2 = BUILDER
                .comment("Mason 1 Trade Request 2 Table")
                .define("mason_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_1_OFFER_2 = BUILDER
                .comment("Mason 1 Trade Offer 2 Table")
                .define("mason_1_trade_offer_2_table",
                        TradeLootTables.OVERWORLD_BRICK_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Mason Level Two Trade One");
        MASON_2_REQUEST_1 = BUILDER
                .comment("Mason 2 Trade Request 1 Table")
                .define("mason_2_trade_request_1_table",
                        TradeLootTables.OVERWORLD_STONE_BLOCKS_TABLE.toString());
        MASON_2_OFFER_1 = BUILDER
                .comment("Mason 2 Trade Offer 1 Table")
                .define("mason_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level Two Trade Two");
        MASON_2_REQUEST_2 = BUILDER
                .comment("Mason 2 Trade Request 2 Table")
                .define("mason_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_2_OFFER_2 = BUILDER
                .comment("Mason 2 Trade Offer 2 Table")
                .define("mason_2_trade_offer_2_table",
                        TradeLootTables.OVERWORLD_BRICK_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Mason Level Three Trade One");
        MASON_3_REQUEST_1 = BUILDER
                .comment("Mason 3 Trade Request 1 Table")
                .define("mason_3_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_3_OFFER_1 = BUILDER
                .comment("Mason 3 Trade Offer 1 Table")
                .define("mason_3_trade_offer_1_table",
                        TradeLootTables.OVERWORLD_POLISHED_STONE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level Three Trade Two");
        MASON_3_REQUEST_2 = BUILDER
                .comment("Mason 3 Trade Request 2 Table")
                .define("mason_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_3_OFFER_2 = BUILDER
                .comment("Mason 3 Trade Offer 2 Table")
                .define("mason_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Mason Level Four Trade One");
        MASON_4_REQUEST_1 = BUILDER
                .comment("Mason 4 Trade Request 1 Table")
                .define("mason_4_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_4_OFFER_1 = BUILDER
                .comment("Mason 4 Trade Offer 1 Table")
                .define("mason_4_trade_offer_1_table",
                        TradeLootTables.TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level Four Trade Two");
        MASON_4_REQUEST_2 = BUILDER
                .comment("Mason 4 Trade Request 2 Table")
                .define("mason_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_4_OFFER_2 = BUILDER
                .comment("Mason 4 Trade Offer 2 Table")
                .define("mason_4_trade_offer_2_table",
                        TradeLootTables.OTHER_STONE_BLOCKS_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Mason Level Five Trade One");
        MASON_5_REQUEST_1 = BUILDER
                .comment("Mason 5 Trade Request 1 Table")
                .define("mason_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        MASON_5_OFFER_1 = BUILDER
                .comment("Mason 5 Trade Offer 1 Table")
                .define("mason_5_trade_offer_1_table",
                        TradeLootTables.GLAZED_TERRACOTTA_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Mason Level Five Trade Two");
        MASON_5_REQUEST_2 = BUILDER
                .comment("Mason 5 Trade Request 2 Table")
                .define("mason_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        MASON_5_OFFER_2 = BUILDER
                .comment("Mason 5 Trade Offer 2 Table")
                .define("mason_5_trade_offer_2_table",
                        TradeLootTables.OTHER_STONE_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        // SHEPHERD TRADES
        BUILDER.push("Shepherd Trade Settings");
        // level 1
        BUILDER.push("Shepherd Level One Trade One");
        SHEPHERD_1_REQUEST_1 = BUILDER
                .comment("Shepherd 1 Trade Request 1 Table")
                .define("shepherd_1_trade_request_1_table",
                        TradeLootTables.TAGGED_WOOL_TABLE.toString());
        SHEPHERD_1_REQUEST_1_COUNT = BUILDER
                .define("shepherd_1_trade_offer_1_count", 18);
        SHEPHERD_1_OFFER_1 = BUILDER
                .comment("Shepherd 1 Trade Offer 1 Table")
                .define("shepherd_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level One Trade Two");
        SHEPHERD_1_REQUEST_2 = BUILDER
                .comment("Shepherd 1 Trade Request 2 Table")
                .define("shepherd_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_1_OFFER_2 = BUILDER
                .comment("Shepherd 1 Trade Offer 2 Table")
                .define("shepherd_1_trade_offer_2_table",
                        TradeLootTables.SHEARS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Shepherd Level Two Trade One");
        SHEPHERD_2_REQUEST_1 = BUILDER
                .comment("Shepherd 2 Trade Request 1 Table")
                .define("shepherd_2_trade_request_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        SHEPHERD_2_REQUEST_1_COUNT = BUILDER
                .define("shepherd_2_trade_offer_1_count", 6);
        SHEPHERD_2_OFFER_1 = BUILDER
                .comment("Shepherd 2 Trade Offer 1 Table")
                .define("shepherd_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level Two Trade Two");
        SHEPHERD_2_REQUEST_2 = BUILDER
                .comment("Shepherd 2 Trade Request 2 Table")
                .define("shepherd_2_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_2_OFFER_2 = BUILDER
                .comment("Shepherd 2 Trade Offer 2 Table")
                .define("shepherd_2_trade_offer_2_table",
                        TradeLootTables.TAGGED_WOOL_TABLE.toString());
        SHEPHERD_2_OFFER_2_COUNT = BUILDER
                .define("shepherd_2_trade_offer_2_count", 1);
        BUILDER.pop();
        BUILDER.push("Shepherd Level Two Trade Three");
        SHEPHERD_2_REQUEST_3 = BUILDER
                .comment("Shepherd 2 Trade Request 3 Table")
                .define("shepherd_2_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_2_OFFER_3 = BUILDER
                .comment("Shepherd 2 Trade Offer 3 Table")
                .define("shepherd_2_trade_offer_3_table",
                        TradeLootTables.TAGGED_WOOL_CARPETS_TABLE.toString());
        SHEPHERD_2_OFFER_3_COUNT = BUILDER
                .define("shepherd_2_trade_offer_3_count", 3);
        BUILDER.pop();
        // level 3
        BUILDER.push("Shepherd Level Three Trade One");
        SHEPHERD_3_REQUEST_1 = BUILDER
                .comment("Shepherd 3 Trade Request 1 Table")
                .define("shepherd_3_trade_request_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        SHEPHERD_3_REQUEST_1_COUNT = BUILDER
                .define("shepherd_3_trade_offer_1_count", 6);
        SHEPHERD_3_OFFER_1 = BUILDER
                .comment("Shepherd 2 Trade Offer 1 Table")
                .define("shepherd_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level Three Trade Two");
        SHEPHERD_3_REQUEST_2 = BUILDER
                .comment("Shepherd 3 Trade Request 2 Table")
                .define("shepherd_3_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_3_OFFER_2 = BUILDER
                .comment("Shepherd 3 Trade Offer 2 Table")
                .define("shepherd_3_trade_offer_2_table",
                        TradeLootTables.TAGGED_BEDS_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Shepherd Level Four Trade One");
        SHEPHERD_4_REQUEST_1 = BUILDER
                .comment("Shepherd 4 Trade Request 1 Table")
                .define("shepherd_4_trade_request_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        SHEPHERD_4_REQUEST_1_COUNT = BUILDER
                .define("shepherd_4_trade_offer_1_count", 6);
        SHEPHERD_4_OFFER_1 = BUILDER
                .comment("Shepherd 4 Trade Offer 1 Table")
                .define("shepherd_4_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level Four Trade Two");
        SHEPHERD_4_REQUEST_2 = BUILDER
                .comment("Shepherd 4 Trade Request 2 Table")
                .define("shepherd_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_4_OFFER_2 = BUILDER
                .comment("Shepherd 4 Trade Offer 2 Table")
                .define("shepherd_4_trade_offer_2_table",
                        TradeLootTables.BANNER_PATTERN_TABLE.toString());
        SHEPHERD_4_OFFER_2_COUNT = BUILDER
                .define("shepherd_4_trade_offer_2_count", 3);
        BUILDER.pop();
        // level 5
        BUILDER.push("Shepherd Level Five Trade One");
        SHEPHERD_5_REQUEST_1 = BUILDER
                .comment("Shepherd 5 Trade Request 1 Table")
                .define("shepherd_5_trade_request_1_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        SHEPHERD_5_REQUEST_1_COUNT = BUILDER
                .define("shepherd_5_trade_offer_1_count", 6);
        SHEPHERD_5_OFFER_1 = BUILDER
                .comment("Shepherd 5 Trade Offer 1 Table")
                .define("shepherd_5_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Shepherd Level Five Trade Two");
        SHEPHERD_5_REQUEST_2 = BUILDER
                .comment("Shepherd 5 Trade Request 2 Table")
                .define("shepherd_5_trade_request_2_table",
                        TradeLootTables.TWO_EMERALD_VALUE_CURRENCY.toString());
        SHEPHERD_5_OFFER_2 = BUILDER
                .comment("Shepherd 5 Trade Offer 2 Table")
                .define("shepherd_5_trade_offer_2_table",
                        TradeLootTables.PAINTINGS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();
        // TOOLSMITH TRADES
        BUILDER.push("Toolsmith Trade Settings");
        // level 1
        BUILDER.push("Toolsmith Level One Trade One");
        TOOLSMITH_1_REQUEST_1 = BUILDER
                .comment("Toolsmith 1 Trade Request 1 Table")
                .define("toolsmith_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        TOOLSMITH_1_OFFER_1 = BUILDER
                .comment("Toolsmith 1 Trade Offer 1 Table")
                .define("toolsmith_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level One Trade Two");
        TOOLSMITH_1_REQUEST_2 = BUILDER
                .comment("Toolsmith 1 Trade Request 2 Table")
                .define("toolsmith_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_1_OFFER_2 = BUILDER
                .comment("Toolsmith 1 Trade Offer 2 Table")
                .define("toolsmith_1_trade_offer_2_table",
                        TradeLootTables.STONE_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Toolsmith Level Two Trade One");
        TOOLSMITH_2_REQUEST_1 = BUILDER
                .comment("Toolsmith 2 Trade Request 1 Table")
                .define("toolsmith_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        TOOLSMITH_2_OFFER_1 = BUILDER
                .comment("Toolsmith 2 Trade Offer 1 Table")
                .define("toolsmith_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Two Trade Two");
        TOOLSMITH_2_REQUEST_2 = BUILDER
                .comment("Toolsmith 2 Trade Request 2 Table")
                .define("toolsmith_2_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_2_OFFER_2 = BUILDER
                .comment("Toolsmith 2 Trade Offer 2 Table")
                .define("toolsmith_2_trade_offer_2_table",
                        TradeLootTables.BELL_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Toolsmith Level Three Trade One");
        TOOLSMITH_3_REQUEST_1 = BUILDER
                .comment("Toolsmith 3 Trade Request 1 Table")
                .define("toolsmith_3_trade_request_1_table",
                        TradeLootTables.IRON_TIER_TOOLS_TABLE.toString());
        TOOLSMITH_3_OFFER_1 = BUILDER
                .comment("Toolsmith 3 Trade Offer 1 Table")
                .define("toolsmith_3_trade_offer_1_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Three Trade Two");
        TOOLSMITH_3_REQUEST_2 = BUILDER
                .comment("Toolsmith 3 Trade Request 2 Table")
                .define("toolsmith_3_trade_request_2_table",
                        TradeLootTables.FLINT_BUY_TABLE.toString());
        TOOLSMITH_3_OFFER_2 = BUILDER
                .comment("Toolsmith 3 Trade Offer 2 Table")
                .define("toolsmith_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Toolsmith Level Four Trade One");
        TOOLSMITH_4_REQUEST_1 = BUILDER
                .comment("Toolsmith 4 Trade Request 1 Table")
                .define("toolsmith_4_trade_request_1_table",
                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE.toString());
        TOOLSMITH_4_OFFER_1 = BUILDER
                .comment("Toolsmith 4 Trade Offer 1 Table")
                .define("toolsmith_4_trade_offer_1_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Four Trade Two");
        TOOLSMITH_4_REQUEST_2 = BUILDER
                .comment("Toolsmith 4 Trade Request 2 Table")
                .define("toolsmith_4_trade_request_2_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_4_OFFER_2 = BUILDER
                .comment("Toolsmith 4 Trade Offer 2 Table")
                .define("toolsmith_4_trade_offer_2_table",
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Four Trade Three");
        TOOLSMITH_4_REQUEST_3 = BUILDER
                .comment("Toolsmith 4 Trade Request 3 Table")
                .comment("for either supplementaries mod or turtleblockacademy mod")
                .define("toolsmith_4_trade_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_4_OFFER_3 = BUILDER
                .comment("Toolsmith 4 Trade Offer 3 Table")
                .define("toolsmith_4_trade_offer_3_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        TOOLSMITH_4_OFFER_3_COUNT = BUILDER
                .define("toolsmith_4_trade_offer_2_count", 18);
        BUILDER.pop();
        // level 5
        BUILDER.push("Toolsmith Level Five Trade One");
        TOOLSMITH_5_REQUEST_1 = BUILDER
                .comment("Toolsmith 5 Trade Request 1 Table")
                .define("toolsmith_5_trade_request_1_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_5_OFFER_1 = BUILDER
                .comment("Toolsmith 5 Trade Offer 1 Table")
                .define("toolsmith_5_trade_offer_1_table",
                        TradeLootTables.GOLD_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Five Trade Two");
        TOOLSMITH_5_REQUEST_2 = BUILDER
                .comment("Toolsmith 5 Trade Request 2 Table")
                .define("toolsmith_5_trade_request_2_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY.toString());
        TOOLSMITH_5_OFFER_2 = BUILDER
                .comment("Toolsmith 5 Trade Offer 2 Table")
                .define("toolsmith_5_trade_offer_2_table",
                        TradeLootTables.NETHERITE_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Toolsmith Level Five Trade Three");
        TOOLSMITH_5_REQUEST_3 = BUILDER
                .comment("Toolsmith 5 Trade Request 3 Table")
                .define("toolsmith_5_trade_request_3_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        TOOLSMITH_5_OFFER_3 = BUILDER
                .comment("Toolsmith 5 Trade Offer 3 Table")
                .define("toolsmith_5_trade_offer_3_table",
                        TradeLootTables.DIAMOND_TIER_TOOLS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();
        // WEAPONSMITH TRADES
        BUILDER.push("Weaponsmith Trade Settings");
        // level 1
        BUILDER.push("Weaponsmith Level One Trade One");
        WEAPONSMITH_1_REQUEST_1 = BUILDER
                .comment("Weaponsmith 1 Trade Request 1 Table")
                .define("weaponsmith_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_VALUE_FUEL.toString());
        WEAPONSMITH_1_OFFER_1 = BUILDER
                .comment("Weaponsmith 1 Trade Offer 1 Table")
                .define("weaponsmith_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level One Trade Two");
        WEAPONSMITH_1_REQUEST_2 = BUILDER
                .comment("Weaponsmith 1 Trade Request 2 Table")
                .define("weaponsmith_1_trade_request_2_table",
                        TradeLootTables.IRON_TIER_WEAPONS_TABLE.toString());
        WEAPONSMITH_1_OFFER_2 = BUILDER
                .comment("Weaponsmith 1 Trade Offer 2 Table")
                .define("weaponsmith_1_trade_offer_2_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Weaponsmith Level Two Trade One");
        WEAPONSMITH_2_REQUEST_1 = BUILDER
                .comment("Weaponsmith 2 Trade Request 1 Table")
                .define("weaponsmith_2_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        WEAPONSMITH_2_OFFER_1 = BUILDER
                .comment("Weaponsmith 2 Trade Offer 1 Table")
                .define("weaponsmith_2_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Two Trade Two");
        WEAPONSMITH_2_REQUEST_2 = BUILDER
                .comment("Weaponsmith 2 Trade Request 2 Table")
                .define("weaponsmith_2_trade_request_2_table",
                        TradeLootTables.THIRTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        WEAPONSMITH_2_OFFER_2 = BUILDER
                .comment("Weaponsmith 2 Trade Offer 2 Table")
                .define("weaponsmith_2_trade_offer_2_table",
                        TradeLootTables.BELL_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Weaponsmith Level Three Trade One");
        WEAPONSMITH_3_REQUEST_1 = BUILDER
                .comment("Weaponsmith 3 Trade Request 1 Table")
                .define("weaponsmith_3_trade_request_1_table",
                        TradeLootTables.FLINT_BUY_TABLE.toString());
        WEAPONSMITH_3_OFFER_1 = BUILDER
                .comment("Weaponsmith 3 Trade Offer 1 Table")
                .define("weaponsmith_3_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Three Trade Two");
        WEAPONSMITH_3_REQUEST_2 = BUILDER
                .comment("Weaponsmith 3 Trade Request 2 Table")
                .define("weaponsmith_3_trade_request_2_table",
                        TradeLootTables.EQUIPMENT_GEMS_TABLE.toString());
        WEAPONSMITH_3_OFFER_2 = BUILDER
                .comment("Weaponsmith 3 Trade Offer 2 Table")
                .define("weaponsmith_3_trade_offer_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Weaponsmith Level Four Trade One");
        WEAPONSMITH_4_REQUEST_1 = BUILDER
                .comment("Weaponsmith 4 Trade Request 1 Table")
                .define("weaponsmith_4_trade_request_1_table",
                        TradeLootTables.TWENTY_EMERALD_VALUE_CURRENCY.toString());
        WEAPONSMITH_4_OFFER_1 = BUILDER
                .comment("Weaponsmith 4 Trade Offer 1 Table")
                .define("weaponsmith_4_trade_offer_1_table",
                        TradeLootTables.GOLD_TIER_WEAPONS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Four Trade Two");
        WEAPONSMITH_4_REQUEST_2 = BUILDER
                .comment("Weaponsmith 4 Trade Request 2 Table")
                .comment("for either supplementaries mod or turtleblockacademy mod")
                .define("weaponsmith_4_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WEAPONSMITH_4_OFFER_2 = BUILDER
                .comment("Weaponsmith 4 Trade Offer 2 Table")
                .define("weaponsmith_4_trade_offer_2_table",
                        TradeLootTables.TAGGED_ASH_TABLE.toString());
        WEAPONSMITH_4_OFFER_2_COUNT = BUILDER
                .define("weaponsmith_4_trade_offer_2_count", 18);
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Four Trade Three");
        WEAPONSMITH_4_REQUEST_3 = BUILDER
                .comment("Weaponsmith 4 Trade Request 3 Table")
                .define("weaponsmith_4_trade_request_3_table",
                        TradeLootTables.ANVIL_TABLE.toString());
        WEAPONSMITH_4_OFFER_3 = BUILDER
                .comment("Weaponsmith 4 Trade Offer 3 Table")
                .define("weaponsmith_4_trade_offer_3_table",
                        TradeLootTables.EIGHT_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Weaponsmith Level Five Trade One");
        WEAPONSMITH_5_REQUEST_1 = BUILDER
                .comment("Weaponsmith 5 Trade Request 1 Table")
                .define("weaponsmith_5_trade_request_1_table",
                        TradeLootTables.TWENTY_SIX_EMERALD_VALUE_CURRENCY.toString());
        WEAPONSMITH_5_OFFER_1 = BUILDER
                .comment("Weaponsmith 5 Trade Offer 1 Table")
                .define("weaponsmith_5_trade_offer_1_table",
                        TradeLootTables.DIAMOND_TIER_WEAPONS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Weaponsmith Level Five Trade Two");
        WEAPONSMITH_5_REQUEST_2 = BUILDER
                .comment("Weaponsmith 5 Trade Request 2 Table")
                .define("weaponsmith_5_trade_request_2_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_BAG_VALUE_CURRENCY.toString());
        WEAPONSMITH_5_OFFER_2 = BUILDER
                .comment("Weaponsmith 5 Trade Offer 2 Table")
                .define("weaponsmith_5_trade_offer_2_table",
                        TradeLootTables.NETHERITE_TIER_WEAPONS_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();
        // WANDERING TRADER TRADES
        BUILDER.push("Wandering Trader Trade Settings");
        BUILDER.push("Wandering Trader Common Trade One");
        WANDERING_REQUEST_1 = BUILDER
                .comment("Wandering Trader Request 1 Table")
                .define("wandering_trader_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_1 = BUILDER
                .comment("Wandering Trader Offer 1 Table")
                .define("wandering_trader_offer_1_table",
                        TradeLootTables.FLOWER_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Two");
        WANDERING_REQUEST_2 = BUILDER
                .comment("Wandering Trader Request 2 Table")
                .define("wandering_trader_request_2_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_2 = BUILDER
                .comment("Wandering Trader Offer 2 Table")
                .define("wandering_trader_offer_2_table",
                        TradeLootTables.SAPLING_SELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Three");
        WANDERING_REQUEST_3 = BUILDER
                .comment("Wandering Trader Request 3 Table")
                .define("wandering_trader_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_3 = BUILDER
                .comment("Wandering Trader Offer 3 Tag Table")
                .define("wandering_trader_offer_3_tag_table",
                        TradeLootTables.SEED_TAG_TABLE.toString());
        WANDERING_OFFER_3_COUNT = BUILDER
                .comment("Wandering Trader Offer 3 Count Override")
                .defineInRange("wandering_trader_offer_3_table_override", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Four");
        WANDERING_REQUEST_4 = BUILDER
                .comment("Wandering Trader Request 4 Table")
                .define("wandering_trader_request_4_table",
                        TradeLootTables.FOUR_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_4 = BUILDER
                .comment("Wandering Trader Offer 4 Tag Table")
                .define("wandering_trader_offer_4_tag_table",
                        TradeLootTables.SLIMEBALL_TAG_TABLE.toString());
        WANDERING_OFFER_4_COUNT = BUILDER
                .comment("Wandering Trader Offer 4 Count Override")
                .defineInRange("wandering_trader_offer_4_table_override", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Five");
        WANDERING_REQUEST_5 = BUILDER
                .comment("Wandering Trader Request 5 Table")
                .define("wandering_trader_request_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_5 = BUILDER
                .comment("Wandering Trader Offer 5 Tag Table")
                .define("wandering_trader_offer_5_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Six");
        WANDERING_REQUEST_6 = BUILDER
                .comment("Wandering Trader Request 6 Table")
                .define("wandering_trader_request_6_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_6 = BUILDER
                .comment("Wandering Trader Offer 6 Tag Table")
                .define("wandering_trader_offer_6_tag_table",
                        TradeLootTables.SAND_TAG_TABLE.toString());
        WANDERING_OFFER_6_COUNT = BUILDER
                .comment("Wandering Trader Offer 6 Count Override")
                .defineInRange("wandering_trader_offer_6_table_override", 6, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Seven");
        WANDERING_REQUEST_7 = BUILDER
                .comment("Wandering Trader Offer 7 Table")
                .define("wandering_trader_request_7_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_7 = BUILDER
                .comment("Wandering Trader Request 7 Tag Table")
                .define("wandering_trader_offer_7_tag_table",
                        TradeLootTables.TAGGED_DYES_TABLE.toString());
        WANDERING_OFFER_7_COUNT = BUILDER
                .comment("Wandering Trader Offer 7 Count Override")
                .defineInRange("wandering_trader_offer_7_table_override", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Eight");
        WANDERING_REQUEST_8 = BUILDER
                .comment("Wandering Trader Request 8 Table")
                .define("wandering_trader_request_8_table",
                        TradeLootTables.FIVE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_8 = BUILDER
                .comment("Wandering Trader Offer 8 Table")
                .define("wandering_trader_offer_8_table",
                        TradeLootTables.SEASHELL_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Nine");
        WANDERING_REQUEST_9 = BUILDER
                .comment("Wandering Trader Request 9 Table")
                .define("wandering_trader_request_9_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_9 = BUILDER
                .comment("Wandering Trader Offer 9 Table")
                .define("wandering_trader_offer_9_table",
                        TradeLootTables.WANDERING_TRADER_COMMON_OFFERS.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Common Trade Ten");
        WANDERING_REQUEST_10 = BUILDER
                .comment("Wandering Trader Request 10 Table")
                .define("wandering_trader_request_10_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_OFFER_10 = BUILDER
                .comment("Wandering Trader Offer 10 Tag Table")
                .define("wandering_trader_offer_10_tag_table",
                        TradeLootTables.CORAL_BLOCK_TAG_TABLE.toString());
        WANDERING_OFFER_10_COUNT = BUILDER
                .comment("Wandering Trader Offer 10 Count Override")
                .defineInRange("wandering_trader_offer_10_table_override", 1, 1, 64);
        BUILDER.pop();
        BUILDER.push("Wandering Trader Rare Trade One");
        WANDERING_RARE_REQUEST_1 = BUILDER
                .comment("Wandering Trader Rare Request 1 Table")
                .define("wandering_trader_rare_request_1_table",
                        TradeLootTables.THREE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_RARE_OFFER_1 = BUILDER
                .comment("Wandering Trader Rare Offer 1 Table")
                .define("wandering_trader_rare_offer_1_table",
                        TradeLootTables.FISH_BUCKET_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Rare Trade Two");
        WANDERING_RARE_REQUEST_2 = BUILDER
                .comment("Wandering Trader Rare Request 2 Table")
                .define("wandering_trader_rare_request_2_table",
                        TradeLootTables.SIX_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_RARE_OFFER_2 = BUILDER
                .comment("Wandering Trader Rare Offer 2 Table")
                .define("wandering_trader_rare_offer_2_table",
                        TradeLootTables.ICE_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Rare Trade Three");
        WANDERING_RARE_REQUEST_3 = BUILDER
                .comment("Wandering Trader Rare Request 3 Table")
                .define("wandering_trader_rare_request_3_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_RARE_OFFER_3 = BUILDER
                .comment("Wandering Trader Rare Offer 3 Table")
                .define("wandering_trader_rare_offer_3_table",
                        TradeLootTables.DIRT_BLOCKS_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Wandering Trader Rare Trade Four");
        WANDERING_RARE_REQUEST_4 = BUILDER
                .comment("Wandering Trader Rare Request 4 Table")
                .define("wandering_trader_rare_request_4_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        WANDERING_RARE_OFFER_4 = BUILDER
                .comment("Wandering Trader Rare Offer 4 Table")
                .define("wandering_trader_rare_offer_4_table",
                        TradeLootTables.WANDERING_TRADER_RARE_OFFERS.toString());
        BUILDER.pop();
        BUILDER.pop();

        // todecoins trades
        BUILDER.push("TodeCoins");
        // BANKER TRADES
        BUILDER.push("Banker Trade Settings");
        // level 1
        BUILDER.push("Banker Level One Trade One");
        BANKER_1_REQUEST_1 = BUILDER
                .comment("Banker 1 Trade Request 1 Table")
                .define("banker_1_trade_request_1_table",
                        TradeLootTables.ONE_EMERALD_TABLE.toString());
        BANKER_1_OFFER_1 = BUILDER
                .comment("Banker 1 Trade Offer 1 Table")
                .define("banker_1_trade_offer_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level One Trade Two");
        BANKER_1_REQUEST_2 = BUILDER
                .comment("Banker 1 Trade Request 2 Table")
                .define("banker_1_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_CURRENCY.toString());
        BANKER_1_OFFER_2 = BUILDER
                .comment("Banker 1 Trade Offer 2 Table")
                .define("banker_1_trade_offer_2_table",
                        TradeLootTables.ONE_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Banker Level Two Trade One");
        BANKER_2_REQUEST_1 = BUILDER
                .comment("Banker 2 Trade Request 1 Table")
                .define("banker_2_trade_request_1_table",
                        TradeLootTables.SIXTEEN_EMERALD_TABLE.toString());
        BANKER_2_OFFER_1 = BUILDER
                .comment("Banker 2 Trade Offer 1 Table")
                .define("banker_2_trade_offer_1_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Two Trade Two");
        BANKER_2_REQUEST_2 = BUILDER
                .comment("Banker 2 Trade Request 2 Table")
                .define("banker_2_trade_request_2_table",
                        TradeLootTables.EMERALD_QUARTER_BANK_NOTE_VALUE_CURRENCY.toString());
        BANKER_2_OFFER_2 = BUILDER
                .comment("Banker 2 Trade Offer 2 Table")
                .define("banker_2_trade_offer_2_table",
                        TradeLootTables.SIXTEEN_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Banker Level Three Trade One");
        BANKER_3_REQUEST_1 = BUILDER
                .comment("Banker 3 Trade Request 1 Table")
                .define("banker_3_trade_request_1_table",
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE.toString());
        BANKER_3_OFFER_1 = BUILDER
                .comment("Banker 3 Trade Offer 1 Table")
                .define("banker_3_trade_offer_1_table",
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Three Trade Two");
        BANKER_3_REQUEST_2 = BUILDER
                .comment("Banker 3 Trade Request 2 Table")
                .define("banker_3_trade_request_2_table",
                        TradeLootTables.EMERALD_HALF_BANK_NOTE_VALUE_CURRENCY.toString());
        BANKER_3_OFFER_2 = BUILDER
                .comment("Banker 3 Trade Offer 2 Table")
                .define("banker_3_trade_offer_2_table",
                        TradeLootTables.THIRTY_TWO_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Banker Level Four Trade One");
        BANKER_4_REQUEST_1 = BUILDER
                .comment("Banker 4 Trade Request 1 Table")
                .define("banker_4_trade_request_1_table",
                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE.toString());
        BANKER_4_OFFER_1 = BUILDER
                .comment("Banker 4 Trade Offer 1 Table")
                .define("banker_4_trade_offer_1_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Four Trade Two");
        BANKER_4_REQUEST_2 = BUILDER
                .comment("Banker 4 Trade Request 2 Table")
                .define("banker_4_trade_request_2_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BANKER_4_OFFER_2 = BUILDER
                .comment("Banker 4 Trade Offer 2 Table")
                .define("banker_4_trade_offer_2_table",
                        TradeLootTables.SIXTY_FOUR_EMERALD_TABLE.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Banker Level Five Trade One");
        BANKER_5_REQUEST_1 = BUILDER
                .comment("Banker 5 Trade Request 1 Table")
                .define("banker_5_trade_request_1_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_METALS.toString());
        BANKER_5_OFFER_1 = BUILDER
                .comment("Banker 5 Trade Offer 1 Table")
                .define("banker_5_trade_offer_1_table",
                        TradeLootTables.ONE_EMERALD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Five Trade Two");
        BANKER_5_REQUEST_2 = BUILDER
                .comment("Banker 5 Trade Request 2 Table")
                .define("banker_5_trade_request_2_table",
                        TradeLootTables.SINGLE_EMERALD_VALUE_GEMS.toString());
        BANKER_5_OFFER_2 = BUILDER
                .comment("Banker 5 Trade Offer 2 Table")
                .define("banker_5_trade_offer_2_table",
                        TradeLootTables.ONE_EMERALD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Five Trade Three");
        BANKER_5_REQUEST_3 = BUILDER
                .comment("Banker 5 Trade Request 3 Table")
                .define("banker_5_trade_request_3_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_METALS.toString());
        BANKER_5_OFFER_3 = BUILDER
                .comment("Banker 5 Trade Offer 3 Table")
                .define("banker_5_trade_offer_3_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Banker Level Five Trade Four");
        BANKER_5_REQUEST_4 = BUILDER
                .comment("Banker 5 Trade Request 4 Table")
                .define("banker_5_trade_request_4_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_GEMS.toString());
        BANKER_5_OFFER_4 = BUILDER
                .comment("Banker 5 Trade Offer 4 Table")
                .define("banker_5_trade_offer_4_table",
                        TradeLootTables.EMERALD_BANK_NOTE_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.pop();
        // LEPRECHAUN TRADES
        BUILDER.push("Leprechaun Trade Settings");
        // level 1
        BUILDER.push("Leprechaun Level One Trade One");
        LEPRECHAUN_1_REQUEST_1 = BUILDER
                .comment("Leprechaun 1 Trade Request 1 Table")
                .define("leprechaun_1_trade_request_1_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        LEPRECHAUN_1_OFFER_1 = BUILDER
                .comment("Leprechaun 1 Trade Offer 1 Table")
                .define("leprechaun_1_trade_offer_1_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level One Trade Two");
        LEPRECHAUN_1_REQUEST_2 = BUILDER
                .comment("Leprechaun 1 Trade Request 2 Table")
                .define("leprechaun_1_trade_request_2_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_1_OFFER_2 = BUILDER
                .comment("Leprechaun 1 Trade Offer 2 Table")
                .define("leprechaun_1_trade_offer_2_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 2
        BUILDER.push("Leprechaun Level Two Trade One");
        LEPRECHAUN_2_REQUEST_1 = BUILDER
                .comment("Leprechaun 2 Trade Request 1 Table")
                .define("leprechaun_2_trade_request_1_table",
                        TradeLootTables.TWO_POT_OF_GOLD_VALUE_GEMS.toString());
        LEPRECHAUN_2_OFFER_1 = BUILDER
                .comment("Leprechaun 2 Trade Offer 1 Table")
                .define("leprechaun_2_trade_offer_1_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Two");
        LEPRECHAUN_2_REQUEST_2 = BUILDER
                .comment("Leprechaun 2 Trade Request 2 Table")
                .define("leprechaun_2_trade_request_2_table",
                        TradeLootTables.TWO_POT_OF_GOLD_VALUE_ITEMS.toString());
        LEPRECHAUN_2_OFFER_2 = BUILDER
                .comment("Leprechaun 2 Trade Offer 2 Table")
                .define("leprechaun_2_trade_offer_2_table",
                        TradeLootTables.TWO_POTS_OF_GOLD_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Three");
        LEPRECHAUN_2_REQUEST_3 = BUILDER
                .comment("Leprechaun 2 Trade Request 3 Table")
                .define("leprechaun_2_trade_request_3_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_2_OFFER_3 = BUILDER
                .comment("Leprechaun 2 Trade Offer 3 Table")
                .define("leprechaun_2_trade_offer_3_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Four");
        LEPRECHAUN_2_REQUEST_4 = BUILDER
                .comment("Leprechaun 2 Trade Request 4 Table")
                .define("leprechaun_2_trade_request_4_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_2_OFFER_4 = BUILDER
                .comment("Leprechaun 2 Trade Offer 4 Table")
                .define("leprechaun_2_trade_offer_4_table",
                        TradeLootTables.FOUR_POT_OF_GOLD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Five");
        LEPRECHAUN_2_REQUEST_5 = BUILDER
                .comment("Leprechaun 2 Trade Request 5 Table")
                .define("leprechaun_2_trade_request_5_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_2_OFFER_5 = BUILDER
                .comment("Leprechaun 2 Trade Offer 5 Table")
                .define("leprechaun_2_trade_offer_5_table",
                        TradeLootTables.FOUR_POT_OF_GOLD_VALUE_ITEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Two Trade Six");
        LEPRECHAUN_2_REQUEST_6 = BUILDER
                .comment("Leprechaun 2 Trade Request 6 Table")
                .define("leprechaun_2_trade_request_6_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_2_OFFER_6 = BUILDER
                .comment("Leprechaun 2 Trade Offer 6 Table")
                .define("leprechaun_2_trade_offer_6_table",
                        TradeLootTables.FOUR_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 3
        BUILDER.push("Leprechaun Level Three Trade One");
        LEPRECHAUN_3_REQUEST_1 = BUILDER
                .comment("Leprechaun 3 Trade Request 1 Table")
                .define("leprechaun_3_trade_request_1_table",
                        TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_1 = BUILDER
                .comment("Leprechaun 3 Trade Offer 1 Table")
                .define("leprechaun_3_trade_offer_1_table",
                        TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_ITEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade One");
        LEPRECHAUN_3_REQUEST_2 = BUILDER
                .comment("Leprechaun 3 Trade Request 2 Table")
                .define("leprechaun_3_trade_request_2_table",
                        TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_2 = BUILDER
                .comment("Leprechaun 3 Trade Offer 2 Table")
                .define("leprechaun_3_trade_offer_2_table",
                        TradeLootTables.THIRTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade Three");
        LEPRECHAUN_3_REQUEST_3 = BUILDER
                .comment("Leprechaun 3 Trade Request 3 Table")
                .define("leprechaun_3_trade_request_3_table",
                        TradeLootTables.THIRTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_3 = BUILDER
                .comment("Leprechaun 3 Trade Offer 3 Table")
                .define("leprechaun_3_trade_offer_3_table",
                        TradeLootTables.THIRTY_POT_OF_GOLD_VALUE_GEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade Four");
        LEPRECHAUN_3_REQUEST_4 = BUILDER
                .comment("Leprechaun 3 Trade Request 4 Table")
                .define("leprechaun_3_trade_request_4_table",
                        TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_4 = BUILDER
                .comment("Leprechaun 3 Trade Offer 4 Table")
                .define("leprechaun_3_trade_offer_4_table",
                        TradeLootTables.SIXTY_POTS_OF_GOLD_VALUE_CURRENCY.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade Five");
        LEPRECHAUN_3_REQUEST_5 = BUILDER
                .comment("Leprechaun 3 Trade Request 5 Table")
                .define("leprechaun_3_trade_request_5_table",
                        TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_5 = BUILDER
                .comment("Leprechaun 3 Trade Offer 5 Table")
                .define("leprechaun_3_trade_offer_5_table",
                        TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_ITEMS.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Three Trade Six");
        LEPRECHAUN_3_REQUEST_6 = BUILDER
                .comment("Leprechaun 3 Trade Request 6 Table")
                .define("leprechaun_3_trade_request_6_table",
                        TradeLootTables.SIXTY_POTS_OF_GOLD_TABLE.toString());
        LEPRECHAUN_3_OFFER_6 = BUILDER
                .comment("Leprechaun 3 Trade Offer 6 Table")
                .define("leprechaun_3_trade_offer_6_table",
                        TradeLootTables.SIXTY_POT_OF_GOLD_VALUE_GEMS.toString());
        BUILDER.pop();
        // level 4
        BUILDER.push("Leprechaun Level Four Trade One");
        LEPRECHAUN_4_REQUEST_1 = BUILDER
                .comment("Leprechaun 4 Trade Request 1 Table")
                .define("leprechaun_4_trade_request_1_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY.toString());
        LEPRECHAUN_4_OFFER_1 = BUILDER
                .comment("Leprechaun 4 Trade Offer 1 Table")
                .define("leprechaun_4_trade_offer_1_table",
                        TradeLootTables.ONE_LUCKY_COIN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Four Trade Two");
        LEPRECHAUN_4_REQUEST_2 = BUILDER
                .comment("Leprechaun 4 Trade Request 2 Table")
                .define("leprechaun_4_trade_request_2_table",
                        TradeLootTables.ONE_LUCKY_COIN_TABLE.toString());
        LEPRECHAUN_4_OFFER_2 = BUILDER
                .comment("Leprechaun 4 Trade Offer 2 Table")
                .define("leprechaun_4_trade_offer_2_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_CURRENCY.toString());
        BUILDER.pop();
        // level 5
        BUILDER.push("Leprechaun Level Five Trade One");
        LEPRECHAUN_5_REQUEST_1 = BUILDER
                .comment("Leprechaun 5 Trade Request 1 Table")
                .define("leprechaun_5_trade_request_1_table",
                        TradeLootTables.SINGLE_LUCKY_COIN_VALUE_GEMS.toString());
        LEPRECHAUN_5_OFFER_1 = BUILDER
                .comment("Leprechaun 5 Trade Offer 1 Table")
                .define("leprechaun_5_trade_offer_1_table",
                        TradeLootTables.ONE_LUCKY_COIN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Five Trade Two");
        LEPRECHAUN_5_REQUEST_2 = BUILDER
                .comment("Leprechaun 5 Trade Request 2 Table")
                .define("leprechaun_5_trade_request_2_table",
                        TradeLootTables.THREE_LUCKY_COIN_VALUE_ITEMS.toString());
        LEPRECHAUN_5_OFFER_2 = BUILDER
                .comment("Leprechaun 5 Trade Offer 2 Table")
                .define("leprechaun_5_trade_offer_2_table",
                        TradeLootTables.THREE_LUCKY_COIN_TABLE.toString());
        BUILDER.pop();
        BUILDER.push("Leprechaun Level Five Trade Three");
        LEPRECHAUN_5_REQUEST_3 = BUILDER
                .comment("Leprechaun 5 Trade Request 3 Table")
                .define("leprechaun_5_trade_request_3_table",
                        TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_VALUE_ITEMS.toString());
        LEPRECHAUN_5_OFFER_3 = BUILDER
                .comment("Leprechaun 5 Trade Offer 3 Table")
                .define("leprechaun_5_trade_offer_3_table",
                        TradeLootTables.TWENTY_SEVEN_LUCKY_COIN_TABLE.toString());
        BUILDER.pop();
        BUILDER.pop();

        // NUMISMATIST TRADES
        BUILDER.push("Numismatist Trade Settings");
        BUILDER.push("Numismatist Common Trade One");
        NUMISMATIST_REQUEST_1 = BUILDER
                .comment("Numismatist Trade Request 1 Table")
                .define("numismatist_trade_request_1_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        NUMISMATIST_OFFER_1 = BUILDER
                .comment("Numismatist Trade Offer 1 Table")
                .define("numismatist_trade_offer_1_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Common Trade Two");
        NUMISMATIST_REQUEST_2 = BUILDER
                .comment("Numismatist Trade Request 2 Table")
                .define("numismatist_trade_request_2_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_OFFER_2 = BUILDER
                .comment("Numismatist Trade Offer 2 Table")
                .define("numismatist_trade_offer_2_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Common Trade Three");
        NUMISMATIST_REQUEST_3A = BUILDER
                .comment("Numismatist Trade Request 3A Table")
                .define("numismatist_trade_request_3a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_3B = BUILDER
                .comment("Numismatist Trade Request 3B Table")
                .define("numismatist_trade_request_3b_table",
                        TradeLootTables.COMPASS_TABLE.toString());
        NUMISMATIST_TRADE_3_STRUCTURE_TAG = BUILDER
                .comment("Numismatist Trade 2 Structure Tag")
                .define("numismatist_trade_3_structure_tag",
                        ForgeTags.StructureTags.ON_VILLAGE_EXPLORER_MAPS.toString());
        NUMISMATIST_TRADE_3_MAP_NAME = BUILDER
                .comment("Numismatist Trade 3 Map Name")
                .define("numismatist_trade_3_map_name",
                        "Merchant Map");
        NUMISMATIST_TRADE_3_MAP_MARKER = BUILDER
                .comment("Numismatist Trade 3 Map Marker")
                .define("numismatist_trade_3_map_marker",
                        MapDecoration.Type.MANSION.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Common Trade Four");
        NUMISMATIST_REQUEST_4A = BUILDER
                .comment("Numismatist Trade Request 4A Table")
                .define("numismatist_trade_request_4a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_4B = BUILDER
                .comment("Numismatist Trade Request 4B Table")
                .define("numismatist_trade_request_4b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        NUMISMATIST_OFFER_4 = BUILDER
                .comment("Numismatist Trade Offer 4 Table")
                .define("numismatist_trade_offer_4_table",
                        TradeLootTables.NUMISMATIST_CONTAINER_OFFERS.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Common Trade Five");
        NUMISMATIST_LOOT_BOX_DISPLAY_NAME = BUILDER
                .comment("Numismatist Loot Box Display Name")
                .comment("sorry, I don't know how to make a single item/block customizable in a config file")
                .define("numismatist_trade_loot_box_display_name",
                        "tooltips.collectible_coin_pack");
        NUMISMATIST_LOOT_BOX_LOOT_TABLE = BUILDER
                .comment("Numismatist Trade Loot Box Loot Table")
                .comment("recommend blacklisting this loot table in lootr")
                .define("numismatist_trade_loot_box_loot_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_5A = BUILDER
                .comment("Numismatist Trade Request 5A Table")
                .define("numismatist_trade_request_5a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_REQUEST_5B = BUILDER
                .comment("Numismatist Trade Request 5B Table")
                .define("numismatist_trade_request_5b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Rare Trade One");
        NUMISMATIST_RARE_OFFER = BUILDER
                .comment("Numismatist Trade Rare Offers Table")
                .define("numismatist_trade_offers_table",
                        TradeLootTables.NUMISMATIST_RARE_OFFERS.toString());
        NUMISMATIST_RARE_REQUEST_1A = BUILDER
                .comment("Numismatist Trade Rare Request 1A Table")
                .define("numismatist_trade_rare_request_1a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_RARE_REQUEST_1B = BUILDER
                .comment("Numismatist Trade Rare Request 1B Table")
                .define("numismatist_trade_rare_request_1b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        BUILDER.pop();
        BUILDER.push("Numismatist Rare Trade Two");
        NUMISMATIST_RARE_REQUEST_2A = BUILDER
                .comment("Numismatist Trade Rare Request 2A Table")
                .comment("for enchanted book offer")
                .define("numismatist_trade_rare_request_2a_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK.toString());
        NUMISMATIST_RARE_REQUEST_2B = BUILDER
                .comment("Numismatist Trade Rare Request 2B Table")
                .comment("for enchanted book offer")
                .define("numismatist_trade_rare_request_2b_table",
                        ModBuiltInLootTables.MYSTERY_COIN_PACK_INVERTED.toString());
        BUILDER.pop();
        BUILDER.pop();
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    // FriendsAndFoes Trades
    // BEEKEEPER TRADE GETTERS
    public static String getBeekeeper5Offer2() {
        if (Objects.equals(BEEKEEPER_5_OFFER_2.get(), BEEKEEPER_5_OFFER_2.getDefault())) {
            return BEEKEEPER_5_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_5_OFFER_2.get();
        }
    }
    public static String getBeekeeper5Request2() {
        if (Objects.equals(BEEKEEPER_5_REQUEST_2.get(), BEEKEEPER_5_REQUEST_2.getDefault())) {
            return BEEKEEPER_5_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_5_REQUEST_2.get();
        }
    }
    public static String getBeekeeper5Offer1() {
        if (Objects.equals(BEEKEEPER_5_OFFER_1.get(), BEEKEEPER_5_OFFER_1.getDefault())) {
            return BEEKEEPER_5_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_5_OFFER_1.get();
        }
    }
    public static String getBeekeeper5Request1() {
        if (Objects.equals(BEEKEEPER_5_REQUEST_1.get(), BEEKEEPER_5_REQUEST_1.getDefault())) {
            return BEEKEEPER_5_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_5_REQUEST_1.get();
        }
    }
    public static int getBeekeeper4Offer2Count() {
        if (Objects.equals(BEEKEEPER_4_OFFER_2_COUNT.get(), BEEKEEPER_4_OFFER_2_COUNT.getDefault())) {
            return BEEKEEPER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return BEEKEEPER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getBeekeeper4Offer2() {
        if (Objects.equals(BEEKEEPER_4_OFFER_2.get(), BEEKEEPER_4_OFFER_2.getDefault())) {
            return BEEKEEPER_4_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_4_OFFER_2.get();
        }
    }
    public static String getBeekeeper4Request2() {
        if (Objects.equals(BEEKEEPER_4_REQUEST_2.get(), BEEKEEPER_4_REQUEST_2.getDefault())) {
            return BEEKEEPER_4_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_4_REQUEST_2.get();
        }
    }
    public static String getBeekeeper4Offer1() {
        if (Objects.equals(BEEKEEPER_4_OFFER_1.get(), BEEKEEPER_4_OFFER_1.getDefault())) {
            return BEEKEEPER_4_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_4_OFFER_1.get();
        }
    }
    public static int getBeekeeper4Request1Count() {
        if (Objects.equals(BEEKEEPER_4_REQUEST_1_COUNT.get(), BEEKEEPER_4_REQUEST_1_COUNT.getDefault())) {
            return BEEKEEPER_4_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BEEKEEPER_4_REQUEST_1_COUNT.get();
        }
    }
    public static String getBeekeeper4Request1() {
        if (Objects.equals(BEEKEEPER_4_REQUEST_1.get(), BEEKEEPER_4_REQUEST_1.getDefault())) {
            return BEEKEEPER_4_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_4_REQUEST_1.get();
        }
    }
    public static String getBeekeeper3Offer2() {
        if (Objects.equals(BEEKEEPER_3_OFFER_2.get(), BEEKEEPER_3_OFFER_2.getDefault())) {
            return BEEKEEPER_3_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_3_OFFER_2.get();
        }
    }
    public static String getBeekeeper3Request2() {
        if (Objects.equals(BEEKEEPER_3_REQUEST_2.get(), BEEKEEPER_3_REQUEST_2.getDefault())) {
            return BEEKEEPER_3_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_3_REQUEST_2.get();
        }
    }
    public static String getBeekeeper3Offer1() {
        if (Objects.equals(BEEKEEPER_3_OFFER_1.get(), BEEKEEPER_3_OFFER_1.getDefault())) {
            return BEEKEEPER_3_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_3_OFFER_1.get();
        }
    }
    public static String getBeekeeper3Request1() {
        if (Objects.equals(BEEKEEPER_3_REQUEST_1.get(), BEEKEEPER_3_REQUEST_1.getDefault())) {
            return BEEKEEPER_3_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_3_REQUEST_1.get();
        }
    }
    public static String getBeekeeper2Offer2() {
        if (Objects.equals(BEEKEEPER_2_OFFER_2.get(), BEEKEEPER_2_OFFER_2.getDefault())) {
            return BEEKEEPER_2_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_2_OFFER_2.get();
        }
    }
    public static String getBeekeeper2Request2() {
        if (Objects.equals(BEEKEEPER_2_REQUEST_2.get(), BEEKEEPER_2_REQUEST_2.getDefault())) {
            return BEEKEEPER_2_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_2_REQUEST_2.get();
        }
    }
    public static String getBeekeeper2Offer1() {
        if (Objects.equals(BEEKEEPER_2_OFFER_1.get(), BEEKEEPER_2_OFFER_1.getDefault())) {
            return BEEKEEPER_2_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_2_OFFER_1.get();
        }
    }
    public static String getBeekeeper2Request1() {
        if (Objects.equals(BEEKEEPER_2_REQUEST_1.get(), BEEKEEPER_2_REQUEST_1.getDefault())) {
            return BEEKEEPER_2_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_2_REQUEST_1.get();
        }
    }
    public static String getBeekeeper1Offer2() {
        if (Objects.equals(BEEKEEPER_1_OFFER_2.get(), BEEKEEPER_1_OFFER_2.getDefault())) {
            return BEEKEEPER_1_OFFER_2.getDefault();
        }
        else {
            return BEEKEEPER_1_OFFER_2.get();
        }
    }
    public static String getBeekeeper1Request2() {
        if (Objects.equals(BEEKEEPER_1_REQUEST_2.get(), BEEKEEPER_1_REQUEST_2.getDefault())) {
            return BEEKEEPER_1_REQUEST_2.getDefault();
        }
        else {
            return BEEKEEPER_1_REQUEST_2.get();
        }
    }
    public static String getBeekeeper1Offer1() {
        if (Objects.equals(BEEKEEPER_1_OFFER_1.get(), BEEKEEPER_1_OFFER_1.getDefault())) {
            return BEEKEEPER_1_OFFER_1.getDefault();
        }
        else {
            return BEEKEEPER_1_OFFER_1.get();
        }
    }
    public static String getBeekeeper1Request1() {
        if (Objects.equals(BEEKEEPER_1_REQUEST_1.get(), BEEKEEPER_1_REQUEST_1.getDefault())) {
            return BEEKEEPER_1_REQUEST_1.getDefault();
        }
        else {
            return BEEKEEPER_1_REQUEST_1.get();
        }
    }
    // Vanilla Trades
    // ARMORER TRADE GETTERS
    public static String getArmorer5Offer2() {
        if (Objects.equals(ARMORER_5_OFFER_2.get(), ARMORER_5_OFFER_2.getDefault())) {
            return ARMORER_5_OFFER_2.getDefault();
        }
        else {
            return ARMORER_5_OFFER_2.get();
        }
    }
    public static String getArmorer5Request2() {
        if (Objects.equals(ARMORER_5_REQUEST_2.get(), ARMORER_5_REQUEST_2.getDefault())) {
            return ARMORER_5_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_5_REQUEST_2.get();
        }
    }
    public static String getArmorer5Offer1() {
        if (Objects.equals(ARMORER_5_OFFER_1.get(), ARMORER_5_OFFER_1.getDefault())) {
            return ARMORER_5_OFFER_1.getDefault();
        }
        else {
            return ARMORER_5_OFFER_1.get();
        }
    }
    public static String getArmorer5Request1() {
        if (Objects.equals(ARMORER_5_REQUEST_1.get(), ARMORER_5_REQUEST_1.getDefault())) {
            return ARMORER_5_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_5_REQUEST_1.get();
        }
    }
    public static int getArmorer4Offer3Count() {
        if (Objects.equals(ARMORER_4_OFFER_3_COUNT.get(), ARMORER_4_OFFER_3_COUNT.getDefault())) {
            return ARMORER_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return ARMORER_4_OFFER_3_COUNT.get();
        }
    }
    public static String getArmorer4Offer3() {
        if (Objects.equals(ARMORER_4_OFFER_3.get(), ARMORER_4_OFFER_3.getDefault())) {
            return ARMORER_4_OFFER_3.getDefault();
        }
        else {
            return ARMORER_4_OFFER_3.get();
        }
    }
    public static String getArmorer4Request3() {
        if (Objects.equals(ARMORER_4_REQUEST_3.get(), ARMORER_4_REQUEST_3.getDefault())) {
            return ARMORER_4_REQUEST_3.getDefault();
        }
        else {
            return ARMORER_4_REQUEST_3.get();
        }
    }
    public static String getArmorer4Offer2() {
        if (Objects.equals(ARMORER_4_OFFER_2.get(), ARMORER_4_OFFER_2.getDefault())) {
            return ARMORER_4_OFFER_2.getDefault();
        }
        else {
            return ARMORER_4_OFFER_2.get();
        }
    }
    public static String getArmorer4Request2() {
        if (Objects.equals(ARMORER_4_REQUEST_2.get(), ARMORER_4_REQUEST_2.getDefault())) {
            return ARMORER_4_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_4_REQUEST_2.get();
        }
    }
    public static String getArmorer4Offer1() {
        if (Objects.equals(ARMORER_4_OFFER_1.get(), ARMORER_4_OFFER_1.getDefault())) {
            return ARMORER_4_OFFER_1.getDefault();
        }
        else {
            return ARMORER_4_OFFER_1.get();
        }
    }
    public static String getArmorer4Request1() {
        if (Objects.equals(ARMORER_4_REQUEST_1.get(), ARMORER_4_REQUEST_1.getDefault())) {
            return ARMORER_4_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_4_REQUEST_1.get();
        }
    }
    public static String getArmorer3Offer6() {
        if (Objects.equals(ARMORER_3_OFFER_6.get(), ARMORER_3_OFFER_6.getDefault())) {
            return ARMORER_3_OFFER_6.getDefault();
        }
        else {
            return ARMORER_3_OFFER_6.get();
        }
    }
    public static String getArmorer3Request6() {
        if (Objects.equals(ARMORER_3_REQUEST_6.get(), ARMORER_3_REQUEST_6.getDefault())) {
            return ARMORER_3_REQUEST_6.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_6.get();
        }
    }
    public static String getArmorer3Offer5() {
        if (Objects.equals(ARMORER_3_OFFER_5.get(), ARMORER_3_OFFER_5.getDefault())) {
            return ARMORER_3_OFFER_5.getDefault();
        }
        else {
            return ARMORER_3_OFFER_5.get();
        }
    }
    public static String getArmorer3Request5() {
        if (Objects.equals(ARMORER_3_REQUEST_5.get(), ARMORER_3_REQUEST_5.getDefault())) {
            return ARMORER_3_REQUEST_5.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_5.get();
        }
    }
    public static String getArmorer3Offer4() {
        if (Objects.equals(ARMORER_3_OFFER_4.get(), ARMORER_3_OFFER_4.getDefault())) {
            return ARMORER_3_OFFER_4.getDefault();
        }
        else {
            return ARMORER_3_OFFER_4.get();
        }
    }
    public static String getArmorer3Request4() {
        if (Objects.equals(ARMORER_3_REQUEST_4.get(), ARMORER_3_REQUEST_4.getDefault())) {
            return ARMORER_3_REQUEST_4.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_4.get();
        }
    }
    public static String getArmorer3Offer3() {
        if (Objects.equals(ARMORER_3_OFFER_3.get(), ARMORER_3_OFFER_3.getDefault())) {
            return ARMORER_3_OFFER_3.getDefault();
        }
        else {
            return ARMORER_3_OFFER_3.get();
        }
    }
    public static String getArmorer3Request3() {
        if (Objects.equals(ARMORER_3_REQUEST_3.get(), ARMORER_3_REQUEST_3.getDefault())) {
            return ARMORER_3_REQUEST_3.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_3.get();
        }
    }
    public static String getArmorer3Offer2() {
        if (Objects.equals(ARMORER_3_OFFER_2.get(), ARMORER_3_OFFER_2.getDefault())) {
            return ARMORER_3_OFFER_2.getDefault();
        }
        else {
            return ARMORER_3_OFFER_2.get();
        }
    }
    public static String getArmorer3Request2() {
        if (Objects.equals(ARMORER_3_REQUEST_2.get(), ARMORER_3_REQUEST_2.getDefault())) {
            return ARMORER_3_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_2.get();
        }
    }
    public static String getArmorer3Offer1() {
        if (Objects.equals(ARMORER_3_OFFER_1.get(), ARMORER_3_OFFER_1.getDefault())) {
            return ARMORER_3_OFFER_1.getDefault();
        }
        else {
            return ARMORER_3_OFFER_1.get();
        }
    }
    public static String getArmorer3Request1() {
        if (Objects.equals(ARMORER_3_REQUEST_1.get(), ARMORER_3_REQUEST_1.getDefault())) {
            return ARMORER_3_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_3_REQUEST_1.get();
        }
    }
    public static String getArmorer2Offer4() {
        if (Objects.equals(ARMORER_2_OFFER_4.get(), ARMORER_2_OFFER_4.getDefault())) {
            return ARMORER_2_OFFER_4.getDefault();
        }
        else {
            return ARMORER_2_OFFER_4.get();
        }
    }
    public static String getArmorer2Request4() {
        if (Objects.equals(ARMORER_2_REQUEST_4.get(), ARMORER_2_REQUEST_4.getDefault())) {
            return ARMORER_2_REQUEST_4.getDefault();
        }
        else {
            return ARMORER_2_REQUEST_4.get();
        }
    }
    public static String getArmorer2Offer3() {
        if (Objects.equals(ARMORER_2_OFFER_3.get(), ARMORER_2_OFFER_3.getDefault())) {
            return ARMORER_2_OFFER_3.getDefault();
        }
        else {
            return ARMORER_2_OFFER_3.get();
        }
    }
    public static String getArmorer2Request3() {
        if (Objects.equals(ARMORER_2_REQUEST_3.get(), ARMORER_2_REQUEST_3.getDefault())) {
            return ARMORER_2_REQUEST_3.getDefault();
        }
        else {
            return ARMORER_2_REQUEST_3.get();
        }
    }
    public static String getArmorer2Offer2() {
        if (Objects.equals(ARMORER_2_OFFER_2.get(), ARMORER_2_OFFER_2.getDefault())) {
            return ARMORER_2_OFFER_2.getDefault();
        }
        else {
            return ARMORER_2_OFFER_2.get();
        }
    }
    public static String getArmorer2Request2() {
        if (Objects.equals(ARMORER_2_REQUEST_2.get(), ARMORER_2_REQUEST_2.getDefault())) {
            return ARMORER_2_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_2_REQUEST_2.get();
        }
    }
    public static String getArmorer2Offer1() {
        if (Objects.equals(ARMORER_2_OFFER_1.get(), ARMORER_2_OFFER_1.getDefault())) {
            return ARMORER_2_OFFER_1.getDefault();
        }
        else {
            return ARMORER_2_OFFER_1.get();
        }
    }
    public static String getArmorer2Request1() {
        if (Objects.equals(ARMORER_2_REQUEST_1.get(), ARMORER_2_REQUEST_1.getDefault())) {
            return ARMORER_2_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_2_REQUEST_1.get();
        }
    }
    public static String getArmorer1Offer5() {
        if (Objects.equals(ARMORER_1_OFFER_5.get(), ARMORER_1_OFFER_5.getDefault())) {
            return ARMORER_1_OFFER_5.getDefault();
        }
        else {
            return ARMORER_1_OFFER_5.get();
        }
    }
    public static String getArmorer1Request5() {
        if (Objects.equals(ARMORER_1_REQUEST_5.get(), ARMORER_1_REQUEST_5.getDefault())) {
            return ARMORER_1_REQUEST_5.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_5.get();
        }
    }
    public static String getArmorer1Offer4() {
        if (Objects.equals(ARMORER_1_OFFER_4.get(), ARMORER_1_OFFER_4.getDefault())) {
            return ARMORER_1_OFFER_4.getDefault();
        }
        else {
            return ARMORER_1_OFFER_4.get();
        }
    }
    public static String getArmorer1Request4() {
        if (Objects.equals(ARMORER_1_REQUEST_4.get(), ARMORER_1_REQUEST_4.getDefault())) {
            return ARMORER_1_REQUEST_4.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_4.get();
        }
    }
    public static String getArmorer1Offer3() {
        if (Objects.equals(ARMORER_1_OFFER_3.get(), ARMORER_1_OFFER_3.getDefault())) {
            return ARMORER_1_OFFER_3.getDefault();
        }
        else {
            return ARMORER_1_OFFER_3.get();
        }
    }
    public static String getArmorer1Request3() {
        if (Objects.equals(ARMORER_1_REQUEST_3.get(), ARMORER_1_REQUEST_3.getDefault())) {
            return ARMORER_1_REQUEST_3.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_3.get();
        }
    }
    public static String getArmorer1Offer2() {
        if (Objects.equals(ARMORER_1_OFFER_2.get(), ARMORER_1_OFFER_2.getDefault())) {
            return ARMORER_1_OFFER_2.getDefault();
        }
        else {
            return ARMORER_1_OFFER_2.get();
        }
    }
    public static String getArmorer1Request2() {
        if (Objects.equals(ARMORER_1_REQUEST_2.get(), ARMORER_1_REQUEST_2.getDefault())) {
            return ARMORER_1_REQUEST_2.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_2.get();
        }
    }
    public static String getArmorer1Offer1() {
        if (Objects.equals(ARMORER_1_OFFER_1.get(), ARMORER_1_OFFER_1.getDefault())) {
            return ARMORER_1_OFFER_1.getDefault();
        }
        else {
            return ARMORER_1_OFFER_1.get();
        }
    }
    public static String getArmorer1Request1() {
        if (Objects.equals(ARMORER_1_REQUEST_1.get(), ARMORER_1_REQUEST_1.getDefault())) {
            return ARMORER_1_REQUEST_1.getDefault();
        }
        else {
            return ARMORER_1_REQUEST_1.get();
        }
    }
    // BUTCHER TRADE GETTERS
    public static int getButcher5Offer2Count() {
        if (Objects.equals(BUTCHER_5_OFFER_2_COUNT.get(), BUTCHER_5_OFFER_2_COUNT.getDefault())) {
            return BUTCHER_5_OFFER_2_COUNT.getDefault();
        }
        else {
            return BUTCHER_5_OFFER_2_COUNT.get();
        }
    }
    public static String getButcher5Offer2() {
        if (Objects.equals(BUTCHER_5_OFFER_2.get(), BUTCHER_5_OFFER_2.getDefault())) {
            return BUTCHER_5_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_5_OFFER_2.get();
        }
    }
    public static String getButcher5Request2() {
        if (Objects.equals(BUTCHER_5_REQUEST_2.get(), BUTCHER_5_REQUEST_2.getDefault())) {
            return BUTCHER_5_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_5_REQUEST_2.get();
        }
    }
    public static String getButcher5Offer1() {
        if (Objects.equals(BUTCHER_5_OFFER_1.get(), BUTCHER_5_OFFER_1.getDefault())) {
            return BUTCHER_5_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_5_OFFER_1.get();
        }
    }
    public static int getButcher5Request1Count() {
        if (Objects.equals(BUTCHER_5_REQUEST_1_COUNT.get(), BUTCHER_5_REQUEST_1_COUNT.getDefault())) {
            return BUTCHER_5_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BUTCHER_5_REQUEST_1_COUNT.get();
        }
    }
    public static String getButcher5Request1() {
        if (Objects.equals(BUTCHER_5_REQUEST_1.get(), BUTCHER_5_REQUEST_1.getDefault())) {
            return BUTCHER_5_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_5_REQUEST_1.get();
        }
    }
    public static int getButcher4Offer4Count() {
        if (Objects.equals(BUTCHER_4_OFFER_4_COUNT.get(), BUTCHER_4_OFFER_4_COUNT.getDefault())) {
            return BUTCHER_4_OFFER_4_COUNT.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_4_COUNT.get();
        }
    }
    public static String getButcher4Offer4() {
        if (Objects.equals(BUTCHER_4_OFFER_4.get(), BUTCHER_4_OFFER_4.getDefault())) {
            return BUTCHER_4_OFFER_4.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_4.get();
        }
    }
    public static String getButcher4Request4() {
        if (Objects.equals(BUTCHER_4_REQUEST_4.get(), BUTCHER_4_REQUEST_4.getDefault())) {
            return BUTCHER_4_REQUEST_4.getDefault();
        }
        else {
            return BUTCHER_4_REQUEST_4.get();
        }
    }
    public static int getButcher4Offer3Count() {
        if (Objects.equals(BUTCHER_4_OFFER_3_COUNT.get(), BUTCHER_4_OFFER_3_COUNT.getDefault())) {
            return BUTCHER_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_3_COUNT.get();
        }
    }
    public static String getButcher4Offer3() {
        if (Objects.equals(BUTCHER_4_OFFER_3.get(), BUTCHER_4_OFFER_3.getDefault())) {
            return BUTCHER_4_OFFER_3.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_3.get();
        }
    }
    public static String getButcher4Request3() {
        if (Objects.equals(BUTCHER_4_REQUEST_3.get(), BUTCHER_4_REQUEST_3.getDefault())) {
            return BUTCHER_4_REQUEST_3.getDefault();
        }
        else {
            return BUTCHER_4_REQUEST_3.get();
        }
    }
    public static int getButcher4Offer2Count() {
        if (Objects.equals(BUTCHER_4_OFFER_2_COUNT.get(), BUTCHER_4_OFFER_2_COUNT.getDefault())) {
            return BUTCHER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getButcher4Offer2() {
        if (Objects.equals(BUTCHER_4_OFFER_2.get(), BUTCHER_4_OFFER_2.getDefault())) {
            return BUTCHER_4_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_2.get();
        }
    }
    public static String getButcher4Request2() {
        if (Objects.equals(BUTCHER_4_REQUEST_2.get(), BUTCHER_4_REQUEST_2.getDefault())) {
            return BUTCHER_4_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_4_REQUEST_2.get();
        }
    }
    public static String getButcher4Offer1() {
        if (Objects.equals(BUTCHER_4_OFFER_1.get(), BUTCHER_4_OFFER_1.getDefault())) {
            return BUTCHER_4_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_4_OFFER_1.get();
        }
    }
    public static String getButcher4Request1() {
        if (Objects.equals(BUTCHER_4_REQUEST_1.get(), BUTCHER_4_REQUEST_1.getDefault())) {
            return BUTCHER_4_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_4_REQUEST_1.get();
        }
    }
    public static int getButcher3Offer3Count() {
        if (Objects.equals(BUTCHER_3_OFFER_3_COUNT.get(), BUTCHER_3_OFFER_3_COUNT.getDefault())) {
            return BUTCHER_3_OFFER_3_COUNT.getDefault();
        }
        else {
            return BUTCHER_3_OFFER_3_COUNT.get();
        }
    }
    public static String getButcher3Offer3() {
        if (Objects.equals(BUTCHER_3_OFFER_3.get(), BUTCHER_3_OFFER_3.getDefault())) {
            return BUTCHER_3_OFFER_3.getDefault();
        }
        else {
            return BUTCHER_3_OFFER_3.get();
        }
    }
    public static String getButcher3Request3() {
        if (Objects.equals(BUTCHER_3_REQUEST_3.get(), BUTCHER_3_REQUEST_3.getDefault())) {
            return BUTCHER_3_REQUEST_3.getDefault();
        }
        else {
            return BUTCHER_3_REQUEST_3.get();
        }
    }
    public static String getButcher3Offer2() {
        if (Objects.equals(BUTCHER_3_OFFER_2.get(), BUTCHER_3_OFFER_2.getDefault())) {
            return BUTCHER_3_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_3_OFFER_2.get();
        }
    }
    public static String getButcher3Request2() {
        if (Objects.equals(BUTCHER_3_REQUEST_2.get(), BUTCHER_3_REQUEST_2.getDefault())) {
            return BUTCHER_3_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_3_REQUEST_2.get();
        }
    }
    public static String getButcher3Offer1() {
        if (Objects.equals(BUTCHER_3_OFFER_1.get(), BUTCHER_3_OFFER_1.getDefault())) {
            return BUTCHER_3_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_3_OFFER_1.get();
        }
    }
    public static int getButcher3Request1Count() {
        if (Objects.equals(BUTCHER_3_REQUEST_1_COUNT.get(), BUTCHER_3_REQUEST_1_COUNT.getDefault())) {
            return BUTCHER_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BUTCHER_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getButcher3Request1() {
        if (Objects.equals(BUTCHER_3_REQUEST_1.get(), BUTCHER_3_REQUEST_1.getDefault())) {
            return BUTCHER_3_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_3_REQUEST_1.get();
        }
    }
    public static int getButcher2Offer2Count() {
        if (Objects.equals(BUTCHER_2_OFFER_2_COUNT.get(), BUTCHER_2_OFFER_2_COUNT.getDefault())) {
            return BUTCHER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return BUTCHER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getButcher2Offer2() {
        if (Objects.equals(BUTCHER_2_OFFER_2.get(), BUTCHER_2_OFFER_2.getDefault())) {
            return BUTCHER_2_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_2_OFFER_2.get();
        }
    }
    public static String getButcher2Request2() {
        if (Objects.equals(BUTCHER_2_REQUEST_2.get(), BUTCHER_2_REQUEST_2.getDefault())) {
            return BUTCHER_2_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_2_REQUEST_2.get();
        }
    }
    public static String getButcher2Offer1() {
        if (Objects.equals(BUTCHER_2_OFFER_1.get(), BUTCHER_2_OFFER_1.getDefault())) {
            return BUTCHER_2_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_2_OFFER_1.get();
        }
    }
    public static String getButcher2Request1() {
        if (Objects.equals(BUTCHER_2_REQUEST_1.get(), BUTCHER_2_REQUEST_1.getDefault())) {
            return BUTCHER_2_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_2_REQUEST_1.get();
        }
    }
    public static int getButcher1Offer2Count() {
        if (Objects.equals(BUTCHER_1_OFFER_2_COUNT.get(), BUTCHER_1_OFFER_2_COUNT.getDefault())) {
            return BUTCHER_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return BUTCHER_1_OFFER_2_COUNT.get();
        }
    }
    public static String getButcher1Offer2() {
        if (Objects.equals(BUTCHER_1_OFFER_2.get(), BUTCHER_1_OFFER_2.getDefault())) {
            return BUTCHER_1_OFFER_2.getDefault();
        }
        else {
            return BUTCHER_1_OFFER_2.get();
        }
    }
    public static String getButcher1Request2() {
        if (Objects.equals(BUTCHER_1_REQUEST_2.get(), BUTCHER_1_REQUEST_2.getDefault())) {
            return BUTCHER_1_REQUEST_2.getDefault();
        }
        else {
            return BUTCHER_1_REQUEST_2.get();
        }
    }
    public static String getButcher1Offer1() {
        if (Objects.equals(BUTCHER_1_OFFER_1.get(), BUTCHER_1_OFFER_1.getDefault())) {
            return BUTCHER_1_OFFER_1.getDefault();
        }
        else {
            return BUTCHER_1_OFFER_1.get();
        }
    }
    public static int getButcher1Request1Count() {
        if (Objects.equals(BUTCHER_1_REQUEST_1_COUNT.get(), BUTCHER_1_REQUEST_1_COUNT.getDefault())) {
            return BUTCHER_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return BUTCHER_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getButcher1Request1() {
        if (Objects.equals(BUTCHER_1_REQUEST_1.get(), BUTCHER_1_REQUEST_1.getDefault())) {
            return BUTCHER_1_REQUEST_1.getDefault();
        }
        else {
            return BUTCHER_1_REQUEST_1.get();
        }
    }
    // CARTOGRAPHER TRADE GETTERS
    public static String getCartographer5Request2MapMarker() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2_MAP_MARKER.get(), CARTOGRAPHER_5_REQUEST_2_MAP_MARKER.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2_MAP_MARKER.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2_MAP_MARKER.get();
        }
    }
    public static String getCartographer5Request2MapName() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2_MAP_NAME.get(), CARTOGRAPHER_5_REQUEST_2_MAP_NAME.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2_MAP_NAME.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2_MAP_NAME.get();
        }
    }
    public static String getCartographer5Request2StructureTag() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG.get(), CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2_STRUCTURE_TAG.get();
        }
    }
    public static String getCartographer5Request2Secondary() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2_SECONDARY.get(), CARTOGRAPHER_5_REQUEST_2_SECONDARY.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getCartographer5Request2() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_2.get(), CARTOGRAPHER_5_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_2.get();
        }
    }
    public static String getCartographer5Offer1() {
        if (Objects.equals(CARTOGRAPHER_5_OFFER_1.get(), CARTOGRAPHER_5_OFFER_1.getDefault())) {
            return CARTOGRAPHER_5_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_5_OFFER_1.get();
        }
    }
    public static String getCartographer5Request1() {
        if (Objects.equals(CARTOGRAPHER_5_REQUEST_1.get(), CARTOGRAPHER_5_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_5_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_5_REQUEST_1.get();
        }
    }
    public static int getCartographer4Offer2Count() {
        if (Objects.equals(CARTOGRAPHER_4_OFFER_2_COUNT.get(), CARTOGRAPHER_4_OFFER_2_COUNT.getDefault())) {
            return CARTOGRAPHER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return CARTOGRAPHER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getCartographer4Offer2() {
        if (Objects.equals(CARTOGRAPHER_4_OFFER_2.get(), CARTOGRAPHER_4_OFFER_2.getDefault())) {
            return CARTOGRAPHER_4_OFFER_2.getDefault();
        }
        else {
            return CARTOGRAPHER_4_OFFER_2.get();
        }
    }
    public static String getCartographer4Request2() {
        if (Objects.equals(CARTOGRAPHER_4_REQUEST_2.get(), CARTOGRAPHER_4_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_4_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_4_REQUEST_2.get();
        }
    }
    public static String getCartographer4Offer1() {
        if (Objects.equals(CARTOGRAPHER_4_OFFER_1.get(), CARTOGRAPHER_4_OFFER_1.getDefault())) {
            return CARTOGRAPHER_4_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_4_OFFER_1.get();
        }
    }
    public static String getCartographer4Request1() {
        if (Objects.equals(CARTOGRAPHER_4_REQUEST_1.get(), CARTOGRAPHER_4_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_4_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_4_REQUEST_1.get();
        }
    }
    public static String getCartographer3Request2MapMarker() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2_MAP_MARKER.get(), CARTOGRAPHER_3_REQUEST_2_MAP_MARKER.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2_MAP_MARKER.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2_MAP_MARKER.get();
        }
    }
    public static String getCartographer3Request2MapName() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2_MAP_NAME.get(), CARTOGRAPHER_3_REQUEST_2_MAP_NAME.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2_MAP_NAME.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2_MAP_NAME.get();
        }
    }
    public static String getCartographer3Request2StructureTag() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG.get(), CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2_STRUCTURE_TAG.get();
        }
    }
    public static String getCartographer3Request2Secondary() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2_SECONDARY.get(), CARTOGRAPHER_3_REQUEST_2_SECONDARY.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getCartographer3Request2() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_2.get(), CARTOGRAPHER_3_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_2.get();
        }
    }
    public static String getCartographer3Offer1() {
        if (Objects.equals(CARTOGRAPHER_3_OFFER_1.get(), CARTOGRAPHER_3_OFFER_1.getDefault())) {
            return CARTOGRAPHER_3_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_3_OFFER_1.get();
        }
    }
    public static String getCartographer3Request1() {
        if (Objects.equals(CARTOGRAPHER_3_REQUEST_1.get(), CARTOGRAPHER_3_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_3_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_3_REQUEST_1.get();
        }
    }
    public static String getCartographer2Request2MapMarker() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2_MAP_MARKER.get(), CARTOGRAPHER_2_REQUEST_2_MAP_MARKER.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2_MAP_MARKER.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2_MAP_MARKER.get();
        }
    }
    public static String getCartographer2Request2MapName() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2_MAP_NAME.get(), CARTOGRAPHER_2_REQUEST_2_MAP_NAME.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2_MAP_NAME.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2_MAP_NAME.get();
        }
    }
    public static String getCartographer2Request2StructureTag() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG.get(), CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2_STRUCTURE_TAG.get();
        }
    }
    public static String getCartographer2Request2Secondary() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2_SECONDARY.get(), CARTOGRAPHER_2_REQUEST_2_SECONDARY.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getCartographer2Request2() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_2.get(), CARTOGRAPHER_2_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_2.get();
        }
    }
    public static String getCartographer2Offer1() {
        if (Objects.equals(CARTOGRAPHER_2_OFFER_1.get(), CARTOGRAPHER_2_OFFER_1.getDefault())) {
            return CARTOGRAPHER_2_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_2_OFFER_1.get();
        }
    }
    public static int getCartographer2Request1Count() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_1_COUNT.get(), CARTOGRAPHER_2_REQUEST_1_COUNT.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_1_COUNT.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_1_COUNT.get();
        }
    }
    public static String getCartographer2Request1() {
        if (Objects.equals(CARTOGRAPHER_2_REQUEST_1.get(), CARTOGRAPHER_2_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_2_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_2_REQUEST_1.get();
        }
    }
    public static String getCartographer1Offer2() {
        if (Objects.equals(CARTOGRAPHER_1_OFFER_2.get(), CARTOGRAPHER_1_OFFER_2.getDefault())) {
            return CARTOGRAPHER_1_OFFER_2.getDefault();
        }
        else {
            return CARTOGRAPHER_1_OFFER_2.get();
        }
    }
    public static String getCartographer1Request2() {
        if (Objects.equals(CARTOGRAPHER_1_REQUEST_2.get(), CARTOGRAPHER_1_REQUEST_2.getDefault())) {
            return CARTOGRAPHER_1_REQUEST_2.getDefault();
        }
        else {
            return CARTOGRAPHER_1_REQUEST_2.get();
        }
    }
    public static String getCartographer1Offer1() {
        if (Objects.equals(CARTOGRAPHER_1_OFFER_1.get(), CARTOGRAPHER_1_OFFER_1.getDefault())) {
            return CARTOGRAPHER_1_OFFER_1.getDefault();
        }
        else {
            return CARTOGRAPHER_1_OFFER_1.get();
        }
    }
    public static String getCartographer1Request1() {
        if (Objects.equals(CARTOGRAPHER_1_REQUEST_1.get(), CARTOGRAPHER_1_REQUEST_1.getDefault())) {
            return CARTOGRAPHER_1_REQUEST_1.getDefault();
        }
        else {
            return CARTOGRAPHER_1_REQUEST_1.get();
        }
    }
    // CLERIC TRADE GETTERS
    public static String getCleric5Offer2() {
        if (Objects.equals(CLERIC_5_OFFER_2.get(), CLERIC_5_OFFER_2.getDefault())) {
            return CLERIC_5_OFFER_2.getDefault();
        }
        else {
            return CLERIC_5_OFFER_2.get();
        }
    }
    public static String getCleric5Request2() {
        if (Objects.equals(CLERIC_5_REQUEST_2.get(), CLERIC_5_REQUEST_2.getDefault())) {
            return CLERIC_5_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_5_REQUEST_2.get();
        }
    }
    public static String getCleric5Offer1() {
        if (Objects.equals(CLERIC_5_OFFER_1.get(), CLERIC_5_OFFER_1.getDefault())) {
            return CLERIC_5_OFFER_1.getDefault();
        }
        else {
            return CLERIC_5_OFFER_1.get();
        }
    }
    public static String getCleric5Request1() {
        if (Objects.equals(CLERIC_5_REQUEST_1.get(), CLERIC_5_REQUEST_1.getDefault())) {
            return CLERIC_5_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_5_REQUEST_1.get();
        }
    }
    public static String getCleric4Offer3() {
        if (Objects.equals(CLERIC_4_OFFER_3.get(), CLERIC_4_OFFER_3.getDefault())) {
            return CLERIC_4_OFFER_3.getDefault();
        }
        else {
            return CLERIC_4_OFFER_3.get();
        }
    }
    public static String getCleric4Request3() {
        if (Objects.equals(CLERIC_4_REQUEST_3.get(), CLERIC_4_REQUEST_3.getDefault())) {
            return CLERIC_4_REQUEST_3.getDefault();
        }
        else {
            return CLERIC_4_REQUEST_3.get();
        }
    }
    public static String getCleric4Offer2() {
        if (Objects.equals(CLERIC_4_OFFER_2.get(), CLERIC_4_OFFER_2.getDefault())) {
            return CLERIC_4_OFFER_2.getDefault();
        }
        else {
            return CLERIC_4_OFFER_2.get();
        }
    }
    public static String getCleric4Request2() {
        if (Objects.equals(CLERIC_4_REQUEST_2.get(), CLERIC_4_REQUEST_2.getDefault())) {
            return CLERIC_4_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_4_REQUEST_2.get();
        }
    }
    public static String getCleric4Offer1() {
        if (Objects.equals(CLERIC_4_OFFER_1.get(), CLERIC_4_OFFER_1.getDefault())) {
            return CLERIC_4_OFFER_1.getDefault();
        }
        else {
            return CLERIC_4_OFFER_1.get();
        }
    }
    public static String getCleric4Request1() {
        if (Objects.equals(CLERIC_4_REQUEST_1.get(), CLERIC_4_REQUEST_1.getDefault())) {
            return CLERIC_4_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_4_REQUEST_1.get();
        }
    }
    public static String getCleric3Offer2() {
        if (Objects.equals(CLERIC_3_OFFER_2.get(), CLERIC_3_OFFER_2.getDefault())) {
            return CLERIC_3_OFFER_2.getDefault();
        }
        else {
            return CLERIC_3_OFFER_2.get();
        }
    }
    public static String getCleric3Request2() {
        if (Objects.equals(CLERIC_3_REQUEST_2.get(), CLERIC_3_REQUEST_2.getDefault())) {
            return CLERIC_3_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_3_REQUEST_2.get();
        }
    }
    public static String getCleric3Offer1() {
        if (Objects.equals(CLERIC_3_OFFER_1.get(), CLERIC_3_OFFER_1.getDefault())) {
            return CLERIC_3_OFFER_1.getDefault();
        }
        else {
            return CLERIC_3_OFFER_1.get();
        }
    }
    public static String getCleric3Request1() {
        if (Objects.equals(CLERIC_3_REQUEST_1.get(), CLERIC_3_REQUEST_1.getDefault())) {
            return CLERIC_3_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_3_REQUEST_1.get();
        }
    }
    public static String getCleric2Offer2() {
        if (Objects.equals(CLERIC_2_OFFER_2.get(), CLERIC_2_OFFER_2.getDefault())) {
            return CLERIC_2_OFFER_2.getDefault();
        }
        else {
            return CLERIC_2_OFFER_2.get();
        }
    }
    public static String getCleric2Request2() {
        if (Objects.equals(CLERIC_2_REQUEST_2.get(), CLERIC_2_REQUEST_2.getDefault())) {
            return CLERIC_2_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_2_REQUEST_2.get();
        }
    }
    public static String getCleric2Offer1() {
        if (Objects.equals(CLERIC_2_OFFER_1.get(), CLERIC_2_OFFER_1.getDefault())) {
            return CLERIC_2_OFFER_1.getDefault();
        }
        else {
            return CLERIC_2_OFFER_1.get();
        }
    }
    public static String getCleric2Request1() {
        if (Objects.equals(CLERIC_2_REQUEST_1.get(), CLERIC_2_REQUEST_1.getDefault())) {
            return CLERIC_2_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_2_REQUEST_1.get();
        }
    }
    public static String getCleric1Offer2() {
        if (Objects.equals(CLERIC_1_OFFER_2.get(), CLERIC_1_OFFER_2.getDefault())) {
            return CLERIC_1_OFFER_2.getDefault();
        }
        else {
            return CLERIC_1_OFFER_2.get();
        }
    }
    public static String getCleric1Request2() {
        if (Objects.equals(CLERIC_1_REQUEST_2.get(), CLERIC_1_REQUEST_2.getDefault())) {
            return CLERIC_1_REQUEST_2.getDefault();
        }
        else {
            return CLERIC_1_REQUEST_2.get();
        }
    }
    public static String getCleric1Offer1() {
        if (Objects.equals(CLERIC_1_OFFER_1.get(), CLERIC_1_OFFER_1.getDefault())) {
            return CLERIC_1_OFFER_1.getDefault();
        }
        else {
            return CLERIC_1_OFFER_1.get();
        }
    }
    public static String getCleric1Request1() {
        if (Objects.equals(CLERIC_1_REQUEST_1.get(), CLERIC_1_REQUEST_1.getDefault())) {
            return CLERIC_1_REQUEST_1.getDefault();
        }
        else {
            return CLERIC_1_REQUEST_1.get();
        }
    }
    // FARMER TRADE GETTERS
    public static String getFarmer5Offer2() {
        if (Objects.equals(FARMER_5_OFFER_2.get(), FARMER_5_OFFER_2.getDefault())) {
            return FARMER_5_OFFER_2.getDefault();
        }
        else {
            return FARMER_5_OFFER_2.get();
        }
    }
    public static String getFarmer5Request2() {
        if (Objects.equals(FARMER_5_REQUEST_2.get(), FARMER_5_REQUEST_2.getDefault())) {
            return FARMER_5_REQUEST_2.getDefault();
        }
        else {
            return FARMER_5_REQUEST_2.get();
        }
    }
    public static String getFarmer5Offer1() {
        if (Objects.equals(FARMER_5_OFFER_1.get(), FARMER_5_OFFER_1.getDefault())) {
            return FARMER_5_OFFER_1.getDefault();
        }
        else {
            return FARMER_5_OFFER_1.get();
        }
    }
    public static String getFarmer5Request1() {
        if (Objects.equals(FARMER_5_REQUEST_1.get(), FARMER_5_REQUEST_1.getDefault())) {
            return FARMER_5_REQUEST_1.getDefault();
        }
        else {
            return FARMER_5_REQUEST_1.get();
        }
    }
    public static String getFarmer4Request2() {
        if (Objects.equals(FARMER_4_REQUEST_2.get(), FARMER_4_REQUEST_2.getDefault())) {
            return FARMER_4_REQUEST_2.getDefault();
        }
        else {
            return FARMER_4_REQUEST_2.get();
        }
    }
    public static int getFarmer4Offer1Count() {
        if (Objects.equals(FARMER_4_OFFER_1_COUNT.get(), FARMER_4_OFFER_1_COUNT.getDefault())) {
            return FARMER_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return FARMER_4_OFFER_1_COUNT.get();
        }
    }
    public static String getFarmer4Offer1() {
        if (Objects.equals(FARMER_4_OFFER_1.get(), FARMER_4_OFFER_1.getDefault())) {
            return FARMER_4_OFFER_1.getDefault();
        }
        else {
            return FARMER_4_OFFER_1.get();
        }
    }
    public static String getFarmer4Request1() {
        if (Objects.equals(FARMER_4_REQUEST_1.get(), FARMER_4_REQUEST_1.getDefault())) {
            return FARMER_4_REQUEST_1.getDefault();
        }
        else {
            return FARMER_4_REQUEST_1.get();
        }
    }
    public static int getFarmer3Offer2Count() {
        if (Objects.equals(FARMER_3_OFFER_2_COUNT.get(), FARMER_3_OFFER_2_COUNT.getDefault())) {
            return FARMER_3_OFFER_2_COUNT.getDefault();
        }
        else {
            return FARMER_3_OFFER_2_COUNT.get();
        }
    }
    public static String getFarmer3Offer2() {
        if (Objects.equals(FARMER_3_OFFER_2.get(), FARMER_3_OFFER_2.getDefault())) {
            return FARMER_3_OFFER_2.getDefault();
        }
        else {
            return FARMER_3_OFFER_2.get();
        }
    }
    public static String getFarmer3Request2() {
        if (Objects.equals(FARMER_3_REQUEST_2.get(), FARMER_3_REQUEST_2.getDefault())) {
            return FARMER_3_REQUEST_2.getDefault();
        }
        else {
            return FARMER_3_REQUEST_2.get();
        }
    }
    public static int getFarmer3Offer1Count() {
        if (Objects.equals(FARMER_3_OFFER_1_COUNT.get(), FARMER_3_OFFER_1_COUNT.getDefault())) {
            return FARMER_3_OFFER_1_COUNT.getDefault();
        }
        else {
            return FARMER_3_OFFER_1_COUNT.get();
        }
    }
    public static String getFarmer3Offer1() {
        if (Objects.equals(FARMER_3_OFFER_1.get(), FARMER_3_OFFER_1.getDefault())) {
            return FARMER_3_OFFER_1.getDefault();
        }
        else {
            return FARMER_3_OFFER_1.get();
        }
    }
    public static String getFarmer3Request1() {
        if (Objects.equals(FARMER_3_REQUEST_1.get(), FARMER_3_REQUEST_1.getDefault())) {
            return FARMER_3_REQUEST_1.getDefault();
        }
        else {
            return FARMER_3_REQUEST_1.get();
        }
    }
    public static int getFarmer2Offer2Count() {
        if (Objects.equals(FARMER_2_OFFER_2_COUNT.get(), FARMER_2_OFFER_2_COUNT.getDefault())) {
            return FARMER_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return FARMER_2_OFFER_2_COUNT.get();
        }
    }
    public static String getFarmer2Offer2() {
        if (Objects.equals(FARMER_2_OFFER_2.get(), FARMER_2_OFFER_2.getDefault())) {
            return FARMER_2_OFFER_2.getDefault();
        }
        else {
            return FARMER_2_OFFER_2.get();
        }
    }
    public static String getFarmer2Request2() {
        if (Objects.equals(FARMER_2_REQUEST_2.get(), FARMER_2_REQUEST_2.getDefault())) {
            return FARMER_2_REQUEST_2.getDefault();
        }
        else {
            return FARMER_2_REQUEST_2.get();
        }
    }
    public static String getFarmer2Offer1() {
        if (Objects.equals(FARMER_2_OFFER_1.get(), FARMER_2_OFFER_1.getDefault())) {
            return FARMER_2_OFFER_1.getDefault();
        }
        else {
            return FARMER_2_OFFER_1.get();
        }
    }
    public static int getFarmer2Request1Count() {
        if (Objects.equals(FARMER_2_REQUEST_1_COUNT.get(), FARMER_2_REQUEST_1_COUNT.getDefault())) {
            return FARMER_2_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FARMER_2_REQUEST_1_COUNT.get();
        }
    }
    public static String getFarmer2Request1() {
        if (Objects.equals(FARMER_2_REQUEST_1.get(), FARMER_2_REQUEST_1.getDefault())) {
            return FARMER_2_REQUEST_1.getDefault();
        }
        else {
            return FARMER_2_REQUEST_1.get();
        }
    }
    public static int getFarmer1Offer2Count() {
        if (Objects.equals(FARMER_1_OFFER_2_COUNT.get(), FARMER_1_OFFER_2_COUNT.getDefault())) {
            return FARMER_1_OFFER_2_COUNT.getDefault();
        }
        else {
            return FARMER_1_OFFER_2_COUNT.get();
        }
    }
    public static String getFarmer1Offer2() {
        if (Objects.equals(FARMER_1_OFFER_2.get(), FARMER_1_OFFER_2.getDefault())) {
            return FARMER_1_OFFER_2.getDefault();
        }
        else {
            return FARMER_1_OFFER_2.get();
        }
    }
    public static String getFarmer1Request2() {
        if (Objects.equals(FARMER_1_REQUEST_2.get(), FARMER_1_REQUEST_2.getDefault())) {
            return FARMER_1_REQUEST_2.getDefault();
        }
        else {
            return FARMER_1_REQUEST_2.get();
        }
    }
    public static String getFarmer1Offer1() {
        if (Objects.equals(FARMER_1_OFFER_1.get(), FARMER_1_OFFER_1.getDefault())) {
            return FARMER_1_OFFER_1.getDefault();
        }
        else {
            return FARMER_1_OFFER_1.get();
        }
    }
    public static int getFarmer1Request1Count() {
        if (Objects.equals(FARMER_1_REQUEST_1_COUNT.get(), FARMER_1_REQUEST_1_COUNT.getDefault())) {
            return FARMER_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FARMER_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getFarmer1Request1() {
        if (Objects.equals(FARMER_1_REQUEST_1.get(), FARMER_1_REQUEST_1.getDefault())) {
            return FARMER_1_REQUEST_1.getDefault();
        }
        else {
            return FARMER_1_REQUEST_1.get();
        }
    }
    // FISHERMAN TRADE GETTERS
    public static String getFisherman5Offer2() {
        if (Objects.equals(FISHERMAN_5_OFFER_2.get(), FISHERMAN_5_OFFER_2.getDefault())) {
            return FISHERMAN_5_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_5_OFFER_2.get();
        }
    }
    public static String getFisherman5Request2() {
        if (Objects.equals(FISHERMAN_5_REQUEST_2.get(), FISHERMAN_5_REQUEST_2.getDefault())) {
            return FISHERMAN_5_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_5_REQUEST_2.get();
        }
    }
    public static String getFisherman5Offer1() {
        if (Objects.equals(FISHERMAN_5_OFFER_1.get(), FISHERMAN_5_OFFER_1.getDefault())) {
            return FISHERMAN_5_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_5_OFFER_1.get();
        }
    }
    public static int getFisherman5Request1Count() {
        if (Objects.equals(FISHERMAN_5_REQUEST_1_COUNT.get(), FISHERMAN_5_REQUEST_1_COUNT.getDefault())) {
            return FISHERMAN_5_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_5_REQUEST_1_COUNT.get();
        }
    }
    public static String getFisherman5Request1() {
        if (Objects.equals(FISHERMAN_5_REQUEST_1.get(), FISHERMAN_5_REQUEST_1.getDefault())) {
            return FISHERMAN_5_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_5_REQUEST_1.get();
        }
    }
    public static String getFisherman4Offer3() {
        if (Objects.equals(FISHERMAN_4_OFFER_3.get(), FISHERMAN_4_OFFER_3.getDefault())) {
            return FISHERMAN_4_OFFER_3.getDefault();
        }
        else {
            return FISHERMAN_4_OFFER_3.get();
        }
    }
    public static int getFisherman4Request3Count() {
        if (Objects.equals(FISHERMAN_4_REQUEST_3_COUNT.get(), FISHERMAN_4_REQUEST_3_COUNT.getDefault())) {
            return FISHERMAN_4_REQUEST_3_COUNT.getDefault();
        }
        else {
            return FISHERMAN_4_REQUEST_3_COUNT.get();
        }
    }
    public static String getFisherman4Request3() {
        if (Objects.equals(FISHERMAN_4_REQUEST_3.get(), FISHERMAN_4_REQUEST_3.getDefault())) {
            return FISHERMAN_4_REQUEST_3.getDefault();
        }
        else {
            return FISHERMAN_4_REQUEST_3.get();
        }
    }
    public static String getFisherman4Offer2() {
        if (Objects.equals(FISHERMAN_4_OFFER_2.get(), FISHERMAN_4_OFFER_2.getDefault())) {
            return FISHERMAN_4_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_4_OFFER_2.get();
        }
    }
    public static String getFisherman4Request2() {
        if (Objects.equals(FISHERMAN_4_REQUEST_2.get(), FISHERMAN_4_REQUEST_2.getDefault())) {
            return FISHERMAN_4_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_4_REQUEST_2.get();
        }
    }
    public static int getFisherman4Offer1Count() {
        if (Objects.equals(FISHERMAN_4_OFFER_1_COUNT.get(), FISHERMAN_4_OFFER_1_COUNT.getDefault())) {
            return FISHERMAN_4_OFFER_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_4_OFFER_1_COUNT.get();
        }
    }
    public static String getFisherman4Offer1() {
        if (Objects.equals(FISHERMAN_4_OFFER_1.get(), FISHERMAN_4_OFFER_1.getDefault())) {
            return FISHERMAN_4_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_4_OFFER_1.get();
        }
    }
    public static String getFisherman4Request1() {
        if (Objects.equals(FISHERMAN_4_REQUEST_1.get(), FISHERMAN_4_REQUEST_1.getDefault())) {
            return FISHERMAN_4_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_4_REQUEST_1.get();
        }
    }
    public static String getFisherman3Offer2() {
        if (Objects.equals(FISHERMAN_3_OFFER_2.get(), FISHERMAN_3_OFFER_2.getDefault())) {
            return FISHERMAN_3_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_3_OFFER_2.get();
        }
    }
    public static String getFisherman3Request2() {
        if (Objects.equals(FISHERMAN_3_REQUEST_2.get(), FISHERMAN_3_REQUEST_2.getDefault())) {
            return FISHERMAN_3_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_3_REQUEST_2.get();
        }
    }
    public static String getFisherman3Offer1() {
        if (Objects.equals(FISHERMAN_3_OFFER_1.get(), FISHERMAN_3_OFFER_1.getDefault())) {
            return FISHERMAN_3_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_3_OFFER_1.get();
        }
    }
    public static int getFisherman3Request1Count() {
        if (Objects.equals(FISHERMAN_3_REQUEST_1_COUNT.get(), FISHERMAN_3_REQUEST_1_COUNT.getDefault())) {
            return FISHERMAN_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getFisherman3Request1() {
        if (Objects.equals(FISHERMAN_3_REQUEST_1.get(), FISHERMAN_3_REQUEST_1.getDefault())) {
            return FISHERMAN_3_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_3_REQUEST_1.get();
        }
    }
    public static String getFisherman2Offer3() {
        if (Objects.equals(FISHERMAN_2_OFFER_3.get(), FISHERMAN_2_OFFER_3.getDefault())) {
            return FISHERMAN_2_OFFER_3.getDefault();
        }
        else {
            return FISHERMAN_2_OFFER_3.get();
        }
    }
    public static String getFisherman2Request3() {
        if (Objects.equals(FISHERMAN_2_REQUEST_3.get(), FISHERMAN_2_REQUEST_3.getDefault())) {
            return FISHERMAN_2_REQUEST_3.getDefault();
        }
        else {
            return FISHERMAN_2_REQUEST_3.get();
        }
    }
    public static int getFisherman2Offer2Count() {
        if (Objects.equals(FISHERMAN_2_OFFER_2_COUNT.get(), FISHERMAN_2_OFFER_2_COUNT.getDefault())) {
            return FISHERMAN_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return FISHERMAN_2_OFFER_2_COUNT.get();
        }
    }
    public static String getFisherman2Offer2() {
        if (Objects.equals(FISHERMAN_2_OFFER_2.get(), FISHERMAN_2_OFFER_2.getDefault())) {
            return FISHERMAN_2_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_2_OFFER_2.get();
        }
    }
    public static String getFisherman2Request2() {
        if (Objects.equals(FISHERMAN_2_REQUEST_2.get(), FISHERMAN_2_REQUEST_2.getDefault())) {
            return FISHERMAN_2_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_2_REQUEST_2.get();
        }
    }
    public static String getFisherman2Offer1() {
        if (Objects.equals(FISHERMAN_2_OFFER_1.get(), FISHERMAN_2_OFFER_1.getDefault())) {
            return FISHERMAN_2_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_2_OFFER_1.get();
        }
    }
    public static int getFisherman2Request1Count() {
        if (Objects.equals(FISHERMAN_2_REQUEST_1_COUNT.get(), FISHERMAN_2_REQUEST_1_COUNT.getDefault())) {
            return FISHERMAN_2_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_2_REQUEST_1_COUNT.get();
        }
    }
    public static String getFisherman2Request1() {
        if (Objects.equals(FISHERMAN_2_REQUEST_1.get(), FISHERMAN_2_REQUEST_1.getDefault())) {
            return FISHERMAN_2_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_2_REQUEST_1.get();
        }
    }
    public static String getFisherman1Offer4() {
        if (Objects.equals(FISHERMAN_1_OFFER_4.get(), FISHERMAN_1_OFFER_4.getDefault())) {
            return FISHERMAN_1_OFFER_4.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_4.get();
        }
    }
    public static String getFisherman1Request4() {
        if (Objects.equals(FISHERMAN_1_REQUEST_4.get(), FISHERMAN_1_REQUEST_4.getDefault())) {
            return FISHERMAN_1_REQUEST_4.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_4.get();
        }
    }
    public static String getFisherman1Offer3() {
        if (Objects.equals(FISHERMAN_1_OFFER_3.get(), FISHERMAN_1_OFFER_3.getDefault())) {
            return FISHERMAN_1_OFFER_3.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_3.get();
        }
    }
    public static int getFisherman1Offer3Count() {
        if (Objects.equals(FISHERMAN_1_OFFER_3_COUNT.get(), FISHERMAN_1_OFFER_3_COUNT.getDefault())) {
            return FISHERMAN_1_OFFER_3_COUNT.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_3_COUNT.get();
        }
    }
    public static String getFisherman1Request3() {
        if (Objects.equals(FISHERMAN_1_REQUEST_3.get(), FISHERMAN_1_REQUEST_3.getDefault())) {
            return FISHERMAN_1_REQUEST_3.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_3.get();
        }
    }
    public static String getFisherman1Offer2() {
        if (Objects.equals(FISHERMAN_1_OFFER_2.get(), FISHERMAN_1_OFFER_2.getDefault())) {
            return FISHERMAN_1_OFFER_2.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_2.get();
        }
    }
    public static String getFisherman1Request2() {
        if (Objects.equals(FISHERMAN_1_REQUEST_2.get(), FISHERMAN_1_REQUEST_2.getDefault())) {
            return FISHERMAN_1_REQUEST_2.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_2.get();
        }
    }
    public static String getFisherman1Offer1() {
        if (Objects.equals(FISHERMAN_1_OFFER_1.get(), FISHERMAN_1_OFFER_1.getDefault())) {
            return FISHERMAN_1_OFFER_1.getDefault();
        }
        else {
            return FISHERMAN_1_OFFER_1.get();
        }
    }
    public static int getFisherman1Request1Count() {
        if (Objects.equals(FISHERMAN_1_REQUEST_1_COUNT.get(), FISHERMAN_1_REQUEST_1_COUNT.getDefault())) {
            return FISHERMAN_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getFisherman1Request1() {
        if (Objects.equals(FISHERMAN_1_REQUEST_1.get(), FISHERMAN_1_REQUEST_1.getDefault())) {
            return FISHERMAN_1_REQUEST_1.getDefault();
        }
        else {
            return FISHERMAN_1_REQUEST_1.get();
        }
    }
    // FLETCHER TRADE GETTERS
    public static String getFletcher5Request2() {
        if (Objects.equals(FLETCHER_5_REQUEST_2.get(), FLETCHER_5_REQUEST_2.getDefault())) {
            return FLETCHER_5_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_5_REQUEST_2.get();
        }
    }
    public static String getFletcher5Request1() {
        if (Objects.equals(FLETCHER_5_REQUEST_1.get(), FLETCHER_5_REQUEST_1.getDefault())) {
            return FLETCHER_5_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_5_REQUEST_1.get();
        }
    }
    public static String getFletcher4Offer3() {
        if (Objects.equals(FLETCHER_4_OFFER_3.get(), FLETCHER_4_OFFER_3.getDefault())) {
            return FLETCHER_4_OFFER_3.getDefault();
        }
        else {
            return FLETCHER_4_OFFER_3.get();
        }
    }
    public static String getFletcher4Request3() {
        if (Objects.equals(FLETCHER_4_REQUEST_3.get(), FLETCHER_4_REQUEST_3.getDefault())) {
            return FLETCHER_4_REQUEST_3.getDefault();
        }
        else {
            return FLETCHER_4_REQUEST_3.get();
        }
    }
    public static int getFletcher4Offer2Count() {
        if (Objects.equals(FLETCHER_4_OFFER_2_COUNT.get(), FLETCHER_4_OFFER_2_COUNT.getDefault())) {
            return FLETCHER_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return FLETCHER_4_OFFER_2_COUNT.get();
        }
    }
    public static String getFletcher4Offer2() {
        if (Objects.equals(FLETCHER_4_OFFER_2.get(), FLETCHER_4_OFFER_2.getDefault())) {
            return FLETCHER_4_OFFER_2.getDefault();
        }
        else {
            return FLETCHER_4_OFFER_2.get();
        }
    }
    public static String getFletcher4Request2() {
        if (Objects.equals(FLETCHER_4_REQUEST_2.get(), FLETCHER_4_REQUEST_2.getDefault())) {
            return FLETCHER_4_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_4_REQUEST_2.get();
        }
    }
    public static String getFletcher4Offer1() {
        if (Objects.equals(FLETCHER_4_OFFER_1.get(), FLETCHER_4_OFFER_1.getDefault())) {
            return FLETCHER_4_OFFER_1.getDefault();
        }
        else {
            return FLETCHER_4_OFFER_1.get();
        }
    }
    public static String getFletcher4Request1() {
        if (Objects.equals(FLETCHER_4_REQUEST_1.get(), FLETCHER_4_REQUEST_1.getDefault())) {
            return FLETCHER_4_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_4_REQUEST_1.get();
        }
    }
    public static String getFletcher3Offer2() {
        if (Objects.equals(FLETCHER_3_OFFER_2.get(), FLETCHER_3_OFFER_2.getDefault())) {
            return FLETCHER_3_OFFER_2.getDefault();
        }
        else {
            return FLETCHER_3_OFFER_2.get();
        }
    }
    public static String getFletcher3Request2() {
        if (Objects.equals(FLETCHER_3_REQUEST_2.get(), FLETCHER_3_REQUEST_2.getDefault())) {
            return FLETCHER_3_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_3_REQUEST_2.get();
        }
    }
    public static String getFletcher3Offer1() {
        if (Objects.equals(FLETCHER_3_OFFER_1.get(), FLETCHER_3_OFFER_1.getDefault())) {
            return FLETCHER_3_OFFER_1.getDefault();
        }
        else {
            return FLETCHER_3_OFFER_1.get();
        }
    }
    public static int getFletcher3Request1Count() {
        if (Objects.equals(FLETCHER_3_REQUEST_1_COUNT.get(), FLETCHER_3_REQUEST_1_COUNT.getDefault())) {
            return FLETCHER_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FLETCHER_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getFletcher3Request1() {
        if (Objects.equals(FLETCHER_3_REQUEST_1.get(), FLETCHER_3_REQUEST_1.getDefault())) {
            return FLETCHER_3_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_3_REQUEST_1.get();
        }
    }
    public static String getFletcher2Offer2() {
        if (Objects.equals(FLETCHER_2_OFFER_2.get(), FLETCHER_2_OFFER_2.getDefault())) {
            return FLETCHER_2_OFFER_2.getDefault();
        }
        else {
            return FLETCHER_2_OFFER_2.get();
        }
    }
    public static String getFletcher2Request2() {
        if (Objects.equals(FLETCHER_2_REQUEST_2.get(), FLETCHER_2_REQUEST_2.getDefault())) {
            return FLETCHER_2_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_2_REQUEST_2.get();
        }
    }
    public static String getFletcher2Offer1() {
        if (Objects.equals(FLETCHER_2_OFFER_1.get(), FLETCHER_2_OFFER_1.getDefault())) {
            return FLETCHER_2_OFFER_1.getDefault();
        }
        else {
            return FLETCHER_2_OFFER_1.get();
        }
    }
    public static String getFletcher2Request1() {
        if (Objects.equals(FLETCHER_2_REQUEST_1.get(), FLETCHER_2_REQUEST_1.getDefault())) {
            return FLETCHER_2_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_2_REQUEST_1.get();
        }
    }
    public static String getFletcher1Offer2() {
        if (Objects.equals(FLETCHER_1_OFFER_2.get(), FLETCHER_1_OFFER_2.getDefault())) {
            return FLETCHER_1_OFFER_2.getDefault();
        }
        else {
            return FLETCHER_1_OFFER_2.get();
        }
    }
    public static String getFletcher1Request2Secondary() {
        if (Objects.equals(FLETCHER_1_REQUEST_2_SECONDARY.get(), FLETCHER_1_REQUEST_2_SECONDARY.getDefault())) {
            return FLETCHER_1_REQUEST_2_SECONDARY.getDefault();
        }
        else {
            return FLETCHER_1_REQUEST_2_SECONDARY.get();
        }
    }
    public static String getFletcher1Request2() {
        if (Objects.equals(FLETCHER_1_REQUEST_2.get(), FLETCHER_1_REQUEST_2.getDefault())) {
            return FLETCHER_1_REQUEST_2.getDefault();
        }
        else {
            return FLETCHER_1_REQUEST_2.get();
        }
    }
    public static String getFletcher1Offer1() {
        if (Objects.equals(FLETCHER_1_OFFER_1.get(), FLETCHER_1_OFFER_1.getDefault())) {
            return FLETCHER_1_OFFER_1.getDefault();
        }
        else {
            return FLETCHER_1_OFFER_1.get();
        }
    }
    public static int getFletcher1Request1Count() {
        if (Objects.equals(FLETCHER_1_REQUEST_1_COUNT.get(), FLETCHER_1_REQUEST_1_COUNT.getDefault())) {
            return FLETCHER_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return FLETCHER_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getFletcher1Request1() {
        if (Objects.equals(FLETCHER_1_REQUEST_1.get(), FLETCHER_1_REQUEST_1.getDefault())) {
            return FLETCHER_1_REQUEST_1.getDefault();
        }
        else {
            return FLETCHER_1_REQUEST_1.get();
        }
    }
    // LEATHERWORKER TRADE GETTERS
    public static String getLeatherworker5Offer2() {
        if (Objects.equals(LEATHERWORKER_5_OFFER_2.get(), LEATHERWORKER_5_OFFER_2.getDefault())) {
            return LEATHERWORKER_5_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_5_OFFER_2.get();
        }
    }
    public static String getLeatherworker5Request2() {
        if (Objects.equals(LEATHERWORKER_5_REQUEST_2.get(), LEATHERWORKER_5_REQUEST_2.getDefault())) {
            return LEATHERWORKER_5_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_5_REQUEST_2.get();
        }
    }
    public static String getLeatherworker5Offer1() {
        if (Objects.equals(LEATHERWORKER_5_OFFER_1.get(), LEATHERWORKER_5_OFFER_1.getDefault())) {
            return LEATHERWORKER_5_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_5_OFFER_1.get();
        }
    }
    public static String getLeatherworker5Request1() {
        if (Objects.equals(LEATHERWORKER_5_REQUEST_1.get(), LEATHERWORKER_5_REQUEST_1.getDefault())) {
            return LEATHERWORKER_5_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_5_REQUEST_1.get();
        }
    }
    public static String getLeatherworker4Offer2() {
        if (Objects.equals(LEATHERWORKER_4_OFFER_2.get(), LEATHERWORKER_4_OFFER_2.getDefault())) {
            return LEATHERWORKER_4_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_4_OFFER_2.get();
        }
    }
    public static String getLeatherworker4Request2() {
        if (Objects.equals(LEATHERWORKER_4_REQUEST_2.get(), LEATHERWORKER_4_REQUEST_2.getDefault())) {
            return LEATHERWORKER_4_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_4_REQUEST_2.get();
        }
    }
    public static String getLeatherworker4Offer1() {
        if (Objects.equals(LEATHERWORKER_4_OFFER_1.get(), LEATHERWORKER_4_OFFER_1.getDefault())) {
            return LEATHERWORKER_4_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_4_OFFER_1.get();
        }
    }
    public static String getLeatherworker4Request1() {
        if (Objects.equals(LEATHERWORKER_4_REQUEST_1.get(), LEATHERWORKER_4_REQUEST_1.getDefault())) {
            return LEATHERWORKER_4_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_4_REQUEST_1.get();
        }
    }
    public static String getLeatherworker3Offer2() {
        if (Objects.equals(LEATHERWORKER_3_OFFER_2.get(), LEATHERWORKER_3_OFFER_2.getDefault())) {
            return LEATHERWORKER_3_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_3_OFFER_2.get();
        }
    }
    public static String getLeatherworker3Request2() {
        if (Objects.equals(LEATHERWORKER_3_REQUEST_2.get(), LEATHERWORKER_3_REQUEST_2.getDefault())) {
            return LEATHERWORKER_3_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_3_REQUEST_2.get();
        }
    }
    public static String getLeatherworker3Offer1() {
        if (Objects.equals(LEATHERWORKER_3_OFFER_1.get(), LEATHERWORKER_3_OFFER_1.getDefault())) {
            return LEATHERWORKER_3_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_3_OFFER_1.get();
        }
    }
    public static int getLeatherworker3Request1Count() {
        if (Objects.equals(LEATHERWORKER_3_REQUEST_1_COUNT.get(), LEATHERWORKER_3_REQUEST_1_COUNT.getDefault())) {
            return LEATHERWORKER_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return LEATHERWORKER_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getLeatherworker3Request1() {
        if (Objects.equals(LEATHERWORKER_3_REQUEST_1.get(), LEATHERWORKER_3_REQUEST_1.getDefault())) {
            return LEATHERWORKER_3_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_3_REQUEST_1.get();
        }
    }
    public static String getLeatherworker2Offer3() {
        if (Objects.equals(LEATHERWORKER_2_OFFER_3.get(), LEATHERWORKER_2_OFFER_3.getDefault())) {
            return LEATHERWORKER_2_OFFER_3.getDefault();
        }
        else {
            return LEATHERWORKER_2_OFFER_3.get();
        }
    }
    public static String getLeatherworker2Request3() {
        if (Objects.equals(LEATHERWORKER_2_REQUEST_3.get(), LEATHERWORKER_2_REQUEST_3.getDefault())) {
            return LEATHERWORKER_2_REQUEST_3.getDefault();
        }
        else {
            return LEATHERWORKER_2_REQUEST_3.get();
        }
    }
    public static String getLeatherworker2Offer2() {
        if (Objects.equals(LEATHERWORKER_2_OFFER_2.get(), LEATHERWORKER_2_OFFER_2.getDefault())) {
            return LEATHERWORKER_2_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_2_OFFER_2.get();
        }
    }
    public static String getLeatherworker2Request2() {
        if (Objects.equals(LEATHERWORKER_2_REQUEST_2.get(), LEATHERWORKER_2_REQUEST_2.getDefault())) {
            return LEATHERWORKER_2_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_2_REQUEST_2.get();
        }
    }
    public static String getLeatherworker2Offer1() {
        if (Objects.equals(LEATHERWORKER_2_OFFER_1.get(), LEATHERWORKER_2_OFFER_1.getDefault())) {
            return LEATHERWORKER_2_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_2_OFFER_1.get();
        }
    }
    public static String getLeatherworker2Request1() {
        if (Objects.equals(LEATHERWORKER_2_REQUEST_1.get(), LEATHERWORKER_2_REQUEST_1.getDefault())) {
            return LEATHERWORKER_2_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_2_REQUEST_1.get();
        }
    }
    public static String getLeatherworker1Offer3() {
        if (Objects.equals(LEATHERWORKER_1_OFFER_3.get(), LEATHERWORKER_1_OFFER_3.getDefault())) {
            return LEATHERWORKER_1_OFFER_3.getDefault();
        }
        else {
            return LEATHERWORKER_1_OFFER_3.get();
        }
    }
    public static String getLeatherworker1Request3() {
        if (Objects.equals(LEATHERWORKER_1_REQUEST_3.get(), LEATHERWORKER_1_REQUEST_3.getDefault())) {
            return LEATHERWORKER_1_REQUEST_3.getDefault();
        }
        else {
            return LEATHERWORKER_1_REQUEST_3.get();
        }
    }
    public static String getLeatherworker1Offer2() {
        if (Objects.equals(LEATHERWORKER_1_OFFER_2.get(), LEATHERWORKER_1_OFFER_2.getDefault())) {
            return LEATHERWORKER_1_OFFER_2.getDefault();
        }
        else {
            return LEATHERWORKER_1_OFFER_2.get();
        }
    }
    public static String getLeatherworker1Request2() {
        if (Objects.equals(LEATHERWORKER_1_REQUEST_2.get(), LEATHERWORKER_1_REQUEST_2.getDefault())) {
            return LEATHERWORKER_1_REQUEST_2.getDefault();
        }
        else {
            return LEATHERWORKER_1_REQUEST_2.get();
        }
    }
    public static String getLeatherworker1Offer1() {
        if (Objects.equals(LEATHERWORKER_1_OFFER_1.get(), LEATHERWORKER_1_OFFER_1.getDefault())) {
            return LEATHERWORKER_1_OFFER_1.getDefault();
        }
        else {
            return LEATHERWORKER_1_OFFER_1.get();
        }
    }
    public static int getLeatherworker1Request1Count() {
        if (Objects.equals(LEATHERWORKER_1_REQUEST_1_COUNT.get(), LEATHERWORKER_1_REQUEST_1_COUNT.getDefault())) {
            return LEATHERWORKER_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return LEATHERWORKER_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getLeatherworker1Request1() {
        if (Objects.equals(LEATHERWORKER_1_REQUEST_1.get(), LEATHERWORKER_1_REQUEST_1.getDefault())) {
            return LEATHERWORKER_1_REQUEST_1.getDefault();
        }
        else {
            return LEATHERWORKER_1_REQUEST_1.get();
        }
    }
    // LIBRARIAN TRADE GETTERS
    public static String getLibrarian5Request3() {
        if (Objects.equals(LIBRARIAN_5_REQUEST_3.get(), LIBRARIAN_5_REQUEST_3.getDefault())) {
            return LIBRARIAN_5_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_5_REQUEST_3.get();
        }
    }
    public static String getLibrarian5Offer2() {
        if (Objects.equals(LIBRARIAN_5_OFFER_2.get(), LIBRARIAN_5_OFFER_2.getDefault())) {
            return LIBRARIAN_5_OFFER_2.getDefault();
        }
        else {
            return LIBRARIAN_5_OFFER_2.get();
        }
    }
    public static String getLibrarian5Request2() {
        if (Objects.equals(LIBRARIAN_5_REQUEST_2.get(), LIBRARIAN_5_REQUEST_2.getDefault())) {
            return LIBRARIAN_5_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_5_REQUEST_2.get();
        }
    }
    public static int getLibrarian5Offer1Count() {
        if (Objects.equals(LIBRARIAN_5_OFFER_1_COUNT.get(), LIBRARIAN_5_OFFER_1_COUNT.getDefault())) {
            return LIBRARIAN_5_OFFER_1_COUNT.getDefault();
        }
        else {
            return LIBRARIAN_5_OFFER_1_COUNT.get();
        }
    }
    public static String getLibrarian5Offer1() {
        if (Objects.equals(LIBRARIAN_5_OFFER_1.get(), LIBRARIAN_5_OFFER_1.getDefault())) {
            return LIBRARIAN_5_OFFER_1.getDefault();
        }
        else {
            return LIBRARIAN_5_OFFER_1.get();
        }
    }
    public static String getLibrarian5Request1() {
        if (Objects.equals(LIBRARIAN_5_REQUEST_1.get(), LIBRARIAN_5_REQUEST_1.getDefault())) {
            return LIBRARIAN_5_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_5_REQUEST_1.get();
        }
    }
    public static String getLibrarian4Request3() {
        if (Objects.equals(LIBRARIAN_4_REQUEST_3.get(), LIBRARIAN_4_REQUEST_3.getDefault())) {
            return LIBRARIAN_4_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_4_REQUEST_3.get();
        }
    }
    public static String getLibrarian4Offer3() {
        if (Objects.equals(LIBRARIAN_4_OFFER_3.get(), LIBRARIAN_4_OFFER_3.getDefault())) {
            return LIBRARIAN_4_OFFER_3.getDefault();
        }
        else {
            return LIBRARIAN_4_OFFER_3.get();
        }
    }
    public static String getLibrarian4Request2() {
        if (Objects.equals(LIBRARIAN_4_REQUEST_2.get(), LIBRARIAN_4_REQUEST_2.getDefault())) {
            return LIBRARIAN_4_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_4_REQUEST_2.get();
        }
    }
    public static String getLibrarian4Offer1() {
        if (Objects.equals(LIBRARIAN_4_OFFER_1.get(), LIBRARIAN_4_OFFER_1.getDefault())) {
            return LIBRARIAN_4_OFFER_1.getDefault();
        }
        else {
            return LIBRARIAN_4_OFFER_1.get();
        }
    }
    public static String getLibrarian4Request1() {
        if (Objects.equals(LIBRARIAN_4_REQUEST_1.get(), LIBRARIAN_4_REQUEST_1.getDefault())) {
            return LIBRARIAN_4_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_4_REQUEST_1.get();
        }
    }
    public static String getLibrarian3Offer3() {
        if (Objects.equals(LIBRARIAN_3_OFFER_3.get(), LIBRARIAN_3_OFFER_3.getDefault())) {
            return LIBRARIAN_3_OFFER_3.getDefault();
        }
        else {
            return LIBRARIAN_3_OFFER_3.get();
        }
    }
    public static int getLibrarian3Offer3Count() {
        if (Objects.equals(LIBRARIAN_3_OFFER_3_COUNT.get(), LIBRARIAN_3_OFFER_3_COUNT.getDefault())) {
            return LIBRARIAN_3_OFFER_3_COUNT.getDefault();
        }
        else {
            return LIBRARIAN_3_OFFER_3_COUNT.get();
        }
    }
    public static String getLibrarian3Request3() {
        if (Objects.equals(LIBRARIAN_3_REQUEST_3.get(), LIBRARIAN_3_REQUEST_3.getDefault())) {
            return LIBRARIAN_3_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_3_REQUEST_3.get();
        }
    }
    public static String getLibrarian3Offer2() {
        if (Objects.equals(LIBRARIAN_3_OFFER_2.get(), LIBRARIAN_3_OFFER_2.getDefault())) {
            return LIBRARIAN_3_OFFER_2.getDefault();
        }
        else {
            return LIBRARIAN_3_OFFER_2.get();
        }
    }
    public static int getLibrarian3Request2Count() {
        if (Objects.equals(LIBRARIAN_3_REQUEST_2_COUNT.get(), LIBRARIAN_3_REQUEST_2_COUNT.getDefault())) {
            return LIBRARIAN_3_REQUEST_2_COUNT.getDefault();
        }
        else {
            return LIBRARIAN_3_REQUEST_2_COUNT.get();
        }
    }
    public static String getLibrarian3Request2() {
        if (Objects.equals(LIBRARIAN_3_REQUEST_2.get(), LIBRARIAN_3_REQUEST_2.getDefault())) {
            return LIBRARIAN_3_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_3_REQUEST_2.get();
        }
    }
    public static String getLibrarian3Request1() {
        if (Objects.equals(LIBRARIAN_3_REQUEST_1.get(), LIBRARIAN_3_REQUEST_1.getDefault())) {
            return LIBRARIAN_3_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_3_REQUEST_1.get();
        }
    }
    public static String getLibrarian2Request3() {
        if (Objects.equals(LIBRARIAN_2_REQUEST_3.get(), LIBRARIAN_2_REQUEST_3.getDefault())) {
            return LIBRARIAN_2_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_2_REQUEST_3.get();
        }
    }
    public static String getLibrarian2Offer3() {
        if (Objects.equals(LIBRARIAN_2_OFFER_3.get(), LIBRARIAN_2_OFFER_3.getDefault())) {
            return LIBRARIAN_2_OFFER_3.getDefault();
        }
        else {
            return LIBRARIAN_2_OFFER_3.get();
        }
    }
    public static String getLibrarian2Request2() {
        if (Objects.equals(LIBRARIAN_2_REQUEST_2.get(), LIBRARIAN_2_REQUEST_2.getDefault())) {
            return LIBRARIAN_2_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_2_REQUEST_2.get();
        }
    }
    public static String getLibrarian2Offer1() {
        if (Objects.equals(LIBRARIAN_2_OFFER_1.get(), LIBRARIAN_2_OFFER_1.getDefault())) {
            return LIBRARIAN_2_OFFER_1.getDefault();
        }
        else {
            return LIBRARIAN_2_OFFER_1.get();
        }
    }
    public static String getLibrarian2Request1() {
        if (Objects.equals(LIBRARIAN_2_REQUEST_1.get(), LIBRARIAN_2_REQUEST_1.getDefault())) {
            return LIBRARIAN_2_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_2_REQUEST_1.get();
        }
    }
    public static String getLibrarian1Offer1() {
        if (Objects.equals(LIBRARIAN_1_OFFER_1.get(), LIBRARIAN_1_OFFER_1.getDefault())) {
            return LIBRARIAN_1_OFFER_1.getDefault();
        }
        else {
            return LIBRARIAN_1_OFFER_1.get();
        }
    }
    public static String getLibrarian1Request1() {
        if (Objects.equals(LIBRARIAN_1_REQUEST_1.get(), LIBRARIAN_1_REQUEST_1.getDefault())) {
            return LIBRARIAN_1_REQUEST_1.getDefault();
        }
        else {
            return LIBRARIAN_1_REQUEST_1.get();
        }
    }
    public static String getLibrarian1Offer2() {
        if (Objects.equals(LIBRARIAN_1_OFFER_2.get(), LIBRARIAN_1_OFFER_2.getDefault())) {
            return LIBRARIAN_1_OFFER_2.getDefault();
        }
        else {
            return LIBRARIAN_1_OFFER_2.get();
        }
    }
    public static String getLibrarian1Request2() {
        if (Objects.equals(LIBRARIAN_1_REQUEST_2.get(), LIBRARIAN_1_REQUEST_2.getDefault())) {
            return LIBRARIAN_1_REQUEST_2.getDefault();
        }
        else {
            return LIBRARIAN_1_REQUEST_2.get();
        }
    }
    public static String getLibrarian1Request3() {
        if (Objects.equals(LIBRARIAN_1_REQUEST_3.get(), LIBRARIAN_1_REQUEST_3.getDefault())) {
            return LIBRARIAN_1_REQUEST_3.getDefault();
        }
        else {
            return LIBRARIAN_1_REQUEST_3.get();
        }
    }
    public static String getLibrarian1Offer4() {
        if (Objects.equals(LIBRARIAN_1_OFFER_4.get(), LIBRARIAN_1_OFFER_4.getDefault())) {
            return LIBRARIAN_1_OFFER_4.getDefault();
        }
        else {
            return LIBRARIAN_1_OFFER_4.get();
        }
    }
    public static String getLibrarian1Request4() {
        if (Objects.equals(LIBRARIAN_1_REQUEST_4.get(), LIBRARIAN_1_REQUEST_4.getDefault())) {
            return LIBRARIAN_1_REQUEST_4.getDefault();
        }
        else {
            return LIBRARIAN_1_REQUEST_4.get();
        }
    }
    // MASON TRADE GETTERS
    public static String getMason5Offer2() {
        if (Objects.equals(MASON_5_OFFER_2.get(), MASON_5_OFFER_2.getDefault())) {
            return MASON_5_OFFER_2.getDefault();
        }
        else {
            return MASON_5_OFFER_2.get();
        }
    }
    public static String getMason5Request2() {
        if (Objects.equals(MASON_5_REQUEST_2.get(), MASON_5_REQUEST_2.getDefault())) {
            return MASON_5_REQUEST_2.getDefault();
        }
        else {
            return MASON_5_REQUEST_2.get();
        }
    }
    public static String getMason5Offer1() {
        if (Objects.equals(MASON_5_OFFER_1.get(), MASON_5_OFFER_1.getDefault())) {
            return MASON_5_OFFER_1.getDefault();
        }
        else {
            return MASON_5_OFFER_1.get();
        }
    }
    public static String getMason5Request1() {
        if (Objects.equals(MASON_5_REQUEST_1.get(), MASON_5_REQUEST_1.getDefault())) {
            return MASON_5_REQUEST_1.getDefault();
        }
        else {
            return MASON_5_REQUEST_1.get();
        }
    }
    public static String getMason4Offer2() {
        if (Objects.equals(MASON_4_OFFER_2.get(), MASON_4_OFFER_2.getDefault())) {
            return MASON_4_OFFER_2.getDefault();
        }
        else {
            return MASON_4_OFFER_2.get();
        }
    }
    public static String getMason4Request2() {
        if (Objects.equals(MASON_4_REQUEST_2.get(), MASON_4_REQUEST_2.getDefault())) {
            return MASON_4_REQUEST_2.getDefault();
        }
        else {
            return MASON_4_REQUEST_2.get();
        }
    }
    public static String getMason4Offer1() {
        if (Objects.equals(MASON_4_OFFER_1.get(), MASON_4_OFFER_1.getDefault())) {
            return MASON_4_OFFER_1.getDefault();
        }
        else {
            return MASON_4_OFFER_1.get();
        }
    }
    public static String getMason4Request1() {
        if (Objects.equals(MASON_4_REQUEST_1.get(), MASON_4_REQUEST_1.getDefault())) {
            return MASON_4_REQUEST_1.getDefault();
        }
        else {
            return MASON_4_REQUEST_1.get();
        }
    }
    public static String getMason3Offer2() {
        if (Objects.equals(MASON_3_OFFER_2.get(), MASON_3_OFFER_2.getDefault())) {
            return MASON_3_OFFER_2.getDefault();
        }
        else {
            return MASON_3_OFFER_2.get();
        }
    }
    public static String getMason3Request2() {
        if (Objects.equals(MASON_3_REQUEST_2.get(), MASON_3_REQUEST_2.getDefault())) {
            return MASON_3_REQUEST_2.getDefault();
        }
        else {
            return MASON_3_REQUEST_2.get();
        }
    }
    public static String getMason3Offer1() {
        if (Objects.equals(MASON_3_OFFER_1.get(), MASON_3_OFFER_1.getDefault())) {
            return MASON_3_OFFER_1.getDefault();
        }
        else {
            return MASON_3_OFFER_1.get();
        }
    }
    public static String getMason3Request1() {
        if (Objects.equals(MASON_3_REQUEST_1.get(), MASON_3_REQUEST_1.getDefault())) {
            return MASON_3_REQUEST_1.getDefault();
        }
        else {
            return MASON_3_REQUEST_1.get();
        }
    }
    public static String getMason2Offer2() {
        if (Objects.equals(MASON_2_OFFER_2.get(), MASON_2_OFFER_2.getDefault())) {
            return MASON_2_OFFER_2.getDefault();
        }
        else {
            return MASON_2_OFFER_2.get();
        }
    }
    public static String getMason2Request2() {
        if (Objects.equals(MASON_2_REQUEST_2.get(), MASON_2_REQUEST_2.getDefault())) {
            return MASON_2_REQUEST_2.getDefault();
        }
        else {
            return MASON_2_REQUEST_2.get();
        }
    }
    public static String getMason2Offer1() {
        if (Objects.equals(MASON_2_OFFER_1.get(), MASON_2_OFFER_1.getDefault())) {
            return MASON_2_OFFER_1.getDefault();
        }
        else {
            return MASON_2_OFFER_1.get();
        }
    }
    public static String getMason2Request1() {
        if (Objects.equals(MASON_2_REQUEST_1.get(), MASON_2_REQUEST_1.getDefault())) {
            return MASON_2_REQUEST_1.getDefault();
        }
        else {
            return MASON_2_REQUEST_1.get();
        }
    }
    public static String getMason1Offer2() {
        if (Objects.equals(MASON_1_OFFER_2.get(), MASON_1_OFFER_2.getDefault())) {
            return MASON_1_OFFER_2.getDefault();
        }
        else {
            return MASON_1_OFFER_2.get();
        }
    }
    public static String getMason1Request2() {
        if (Objects.equals(MASON_1_REQUEST_2.get(), MASON_1_REQUEST_2.getDefault())) {
            return MASON_1_REQUEST_2.getDefault();
        }
        else {
            return MASON_1_REQUEST_2.get();
        }
    }
    public static String getMason1Offer1() {
        if (Objects.equals(MASON_1_OFFER_1.get(), MASON_1_OFFER_1.getDefault())) {
            return MASON_1_OFFER_1.getDefault();
        }
        else {
            return MASON_1_OFFER_1.get();
        }
    }
    public static String getMason1Request1() {
        if (Objects.equals(MASON_1_REQUEST_1.get(), MASON_1_REQUEST_1.getDefault())) {
            return MASON_1_REQUEST_1.getDefault();
        }
        else {
            return MASON_1_REQUEST_1.get();
        }
    }
    // SHEPHERD TRADE GETTERS
    public static String getShepherd5Offer2() {
        if (Objects.equals(SHEPHERD_5_OFFER_2.get(), SHEPHERD_5_OFFER_2.getDefault())) {
            return SHEPHERD_5_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_5_OFFER_2.get();
        }
    }
    public static String getShepherd5Request2() {
        if (Objects.equals(SHEPHERD_5_REQUEST_2.get(), SHEPHERD_5_REQUEST_2.getDefault())) {
            return SHEPHERD_5_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_5_REQUEST_2.get();
        }
    }
    public static String getShepherd5Offer1() {
        if (Objects.equals(SHEPHERD_5_OFFER_1.get(), SHEPHERD_5_OFFER_1.getDefault())) {
            return SHEPHERD_5_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_5_OFFER_1.get();
        }
    }
    public static int getShepherd5Request1Count() {
        if (Objects.equals(SHEPHERD_5_REQUEST_1_COUNT.get(), SHEPHERD_5_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_5_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_5_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd5Request1() {
        if (Objects.equals(SHEPHERD_5_REQUEST_1.get(), SHEPHERD_5_REQUEST_1.getDefault())) {
            return SHEPHERD_5_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_5_REQUEST_1.get();
        }
    }
    public static int getShepherd4Offer2Count() {
        if (Objects.equals(SHEPHERD_4_OFFER_2_COUNT.get(), SHEPHERD_4_OFFER_2_COUNT.getDefault())) {
            return SHEPHERD_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return SHEPHERD_4_OFFER_2_COUNT.get();
        }
    }
    public static String getShepherd4Offer2() {
        if (Objects.equals(SHEPHERD_4_OFFER_2.get(), SHEPHERD_4_OFFER_2.getDefault())) {
            return SHEPHERD_4_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_4_OFFER_2.get();
        }
    }
    public static String getShepherd4Request2() {
        if (Objects.equals(SHEPHERD_4_REQUEST_2.get(), SHEPHERD_4_REQUEST_2.getDefault())) {
            return SHEPHERD_4_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_4_REQUEST_2.get();
        }
    }
    public static String getShepherd4Offer1() {
        if (Objects.equals(SHEPHERD_4_OFFER_1.get(), SHEPHERD_4_OFFER_1.getDefault())) {
            return SHEPHERD_4_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_4_OFFER_1.get();
        }
    }
    public static int getShepherd4Request1Count() {
        if (Objects.equals(SHEPHERD_4_REQUEST_1_COUNT.get(), SHEPHERD_4_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_4_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_4_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd4Request1() {
        if (Objects.equals(SHEPHERD_4_REQUEST_1.get(), SHEPHERD_4_REQUEST_1.getDefault())) {
            return SHEPHERD_4_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_4_REQUEST_1.get();
        }
    }
    public static String getShepherd3Offer2() {
        if (Objects.equals(SHEPHERD_3_OFFER_2.get(), SHEPHERD_3_OFFER_2.getDefault())) {
            return SHEPHERD_3_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_3_OFFER_2.get();
        }
    }
    public static String getShepherd3Request2() {
        if (Objects.equals(SHEPHERD_3_REQUEST_2.get(), SHEPHERD_3_REQUEST_2.getDefault())) {
            return SHEPHERD_3_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_3_REQUEST_2.get();
        }
    }
    public static String getShepherd3Offer1() {
        if (Objects.equals(SHEPHERD_3_OFFER_1.get(), SHEPHERD_3_OFFER_1.getDefault())) {
            return SHEPHERD_3_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_3_OFFER_1.get();
        }
    }
    public static int getShepherd3Request1Count() {
        if (Objects.equals(SHEPHERD_3_REQUEST_1_COUNT.get(), SHEPHERD_3_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_3_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_3_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd3Request1() {
        if (Objects.equals(SHEPHERD_3_REQUEST_1.get(), SHEPHERD_3_REQUEST_1.getDefault())) {
            return SHEPHERD_3_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_3_REQUEST_1.get();
        }
    }
    public static int getShepherd2Offer3Count() {
        if (Objects.equals(SHEPHERD_2_OFFER_3_COUNT.get(), SHEPHERD_2_OFFER_3_COUNT.getDefault())) {
            return SHEPHERD_2_OFFER_3_COUNT.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_3_COUNT.get();
        }
    }
    public static String getShepherd2Offer3() {
        if (Objects.equals(SHEPHERD_2_OFFER_3.get(), SHEPHERD_2_OFFER_3.getDefault())) {
            return SHEPHERD_2_OFFER_3.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_3.get();
        }
    }
    public static String getShepherd2Request3() {
        if (Objects.equals(SHEPHERD_2_REQUEST_3.get(), SHEPHERD_2_REQUEST_3.getDefault())) {
            return SHEPHERD_2_REQUEST_3.getDefault();
        }
        else {
            return SHEPHERD_2_REQUEST_3.get();
        }
    }
    public static int getShepherd2Offer2Count() {
        if (Objects.equals(SHEPHERD_2_OFFER_2_COUNT.get(), SHEPHERD_2_OFFER_2_COUNT.getDefault())) {
            return SHEPHERD_2_OFFER_2_COUNT.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_2_COUNT.get();
        }
    }
    public static String getShepherd2Offer2() {
        if (Objects.equals(SHEPHERD_2_OFFER_2.get(), SHEPHERD_2_OFFER_2.getDefault())) {
            return SHEPHERD_2_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_2.get();
        }
    }
    public static String getShepherd2Request2() {
        if (Objects.equals(SHEPHERD_2_REQUEST_2.get(), SHEPHERD_2_REQUEST_2.getDefault())) {
            return SHEPHERD_2_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_2_REQUEST_2.get();
        }
    }
    public static String getShepherd2Offer1() {
        if (Objects.equals(SHEPHERD_2_OFFER_1.get(), SHEPHERD_2_OFFER_1.getDefault())) {
            return SHEPHERD_2_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_2_OFFER_1.get();
        }
    }
    public static int getShepherd2Request1Count() {
        if (Objects.equals(SHEPHERD_2_REQUEST_1_COUNT.get(), SHEPHERD_2_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_2_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_2_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd2Request1() {
        if (Objects.equals(SHEPHERD_2_REQUEST_1.get(), SHEPHERD_2_REQUEST_1.getDefault())) {
            return SHEPHERD_2_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_2_REQUEST_1.get();
        }
    }
    public static String getShepherd1Offer2() {
        if (Objects.equals(SHEPHERD_1_OFFER_2.get(), SHEPHERD_1_OFFER_2.getDefault())) {
            return SHEPHERD_1_OFFER_2.getDefault();
        }
        else {
            return SHEPHERD_1_OFFER_2.get();
        }
    }
    public static String getShepherd1Request2() {
        if (Objects.equals(SHEPHERD_1_REQUEST_2.get(), SHEPHERD_1_REQUEST_2.getDefault())) {
            return SHEPHERD_1_REQUEST_2.getDefault();
        }
        else {
            return SHEPHERD_1_REQUEST_2.get();
        }
    }
    public static String getShepherd1Offer1() {
        if (Objects.equals(SHEPHERD_1_OFFER_1.get(), SHEPHERD_1_OFFER_1.getDefault())) {
            return SHEPHERD_1_OFFER_1.getDefault();
        }
        else {
            return SHEPHERD_1_OFFER_1.get();
        }
    }
    public static int getShepherd1Request1Count() {
        if (Objects.equals(SHEPHERD_1_REQUEST_1_COUNT.get(), SHEPHERD_1_REQUEST_1_COUNT.getDefault())) {
            return SHEPHERD_1_REQUEST_1_COUNT.getDefault();
        }
        else {
            return SHEPHERD_1_REQUEST_1_COUNT.get();
        }
    }
    public static String getShepherd1Request1() {
        if (Objects.equals(SHEPHERD_1_REQUEST_1.get(), SHEPHERD_1_REQUEST_1.getDefault())) {
            return SHEPHERD_1_REQUEST_1.getDefault();
        }
        else {
            return SHEPHERD_1_REQUEST_1.get();
        }
    }
    // TOOLSMITH TRADE GETTERS
    public static String getToolsmith5Offer3() {
        if (Objects.equals(TOOLSMITH_5_OFFER_3.get(), TOOLSMITH_5_OFFER_3.getDefault())) {
            return TOOLSMITH_5_OFFER_3.getDefault();
        }
        else {
            return TOOLSMITH_5_OFFER_3.get();
        }
    }
    public static String getToolsmith5Request3() {
        if (Objects.equals(TOOLSMITH_5_REQUEST_3.get(), TOOLSMITH_5_REQUEST_3.getDefault())) {
            return TOOLSMITH_5_REQUEST_3.getDefault();
        }
        else {
            return TOOLSMITH_5_REQUEST_3.get();
        }
    }
    public static String getToolsmith5Offer2() {
        if (Objects.equals(TOOLSMITH_5_OFFER_2.get(), TOOLSMITH_5_OFFER_2.getDefault())) {
            return TOOLSMITH_5_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_5_OFFER_2.get();
        }
    }
    public static String getToolsmith5Request2() {
        if (Objects.equals(TOOLSMITH_5_REQUEST_2.get(), TOOLSMITH_5_REQUEST_2.getDefault())) {
            return TOOLSMITH_5_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_5_REQUEST_2.get();
        }
    }
    public static String getToolsmith5Offer1() {
        if (Objects.equals(TOOLSMITH_5_OFFER_1.get(), TOOLSMITH_5_OFFER_1.getDefault())) {
            return TOOLSMITH_5_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_5_OFFER_1.get();
        }
    }
    public static String getToolsmith5Request1() {
        if (Objects.equals(TOOLSMITH_5_REQUEST_1.get(), TOOLSMITH_5_REQUEST_1.getDefault())) {
            return TOOLSMITH_5_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_5_REQUEST_1.get();
        }
    }
    public static String getToolsmith4Offer3() {
        if (Objects.equals(TOOLSMITH_4_OFFER_3.get(), TOOLSMITH_4_OFFER_3.getDefault())) {
            return TOOLSMITH_4_OFFER_3.getDefault();
        }
        else {
            return TOOLSMITH_4_OFFER_3.get();
        }
    }
    public static String getToolsmith4Request3() {
        if (Objects.equals(TOOLSMITH_4_REQUEST_3.get(), TOOLSMITH_4_REQUEST_3.getDefault())) {
            return TOOLSMITH_4_REQUEST_3.getDefault();
        }
        else {
            return TOOLSMITH_4_REQUEST_3.get();
        }
    }
    public static int getToolsmith4Offer3Count() {
        if (Objects.equals(TOOLSMITH_4_OFFER_3_COUNT.get(), TOOLSMITH_4_OFFER_3_COUNT.getDefault())) {
            return TOOLSMITH_4_OFFER_3_COUNT.getDefault();
        }
        else {
            return TOOLSMITH_4_OFFER_3_COUNT.get();
        }
    }
    public static String getToolsmith4Offer2() {
        if (Objects.equals(TOOLSMITH_4_OFFER_2.get(), TOOLSMITH_4_OFFER_2.getDefault())) {
            return TOOLSMITH_4_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_4_OFFER_2.get();
        }
    }
    public static String getToolsmith4Request2() {
        if (Objects.equals(TOOLSMITH_4_REQUEST_2.get(), TOOLSMITH_4_REQUEST_2.getDefault())) {
            return TOOLSMITH_4_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_4_REQUEST_2.get();
        }
    }
    public static String getToolsmith4Offer1() {
        if (Objects.equals(TOOLSMITH_4_OFFER_1.get(), TOOLSMITH_4_OFFER_1.getDefault())) {
            return TOOLSMITH_4_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_4_OFFER_1.get();
        }
    }
    public static String getToolsmith4Request1() {
        if (Objects.equals(TOOLSMITH_4_REQUEST_1.get(), TOOLSMITH_4_REQUEST_1.getDefault())) {
            return TOOLSMITH_4_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_4_REQUEST_1.get();
        }
    }
    public static String getToolsmith3Offer2() {
        if (Objects.equals(TOOLSMITH_3_OFFER_2.get(), TOOLSMITH_3_OFFER_2.getDefault())) {
            return TOOLSMITH_3_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_3_OFFER_2.get();
        }
    }
    public static String getToolsmith3Request2() {
        if (Objects.equals(TOOLSMITH_3_REQUEST_2.get(), TOOLSMITH_3_REQUEST_2.getDefault())) {
            return TOOLSMITH_3_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_3_REQUEST_2.get();
        }
    }
    public static String getToolsmith3Offer1() {
        if (Objects.equals(TOOLSMITH_3_OFFER_1.get(), TOOLSMITH_3_OFFER_1.getDefault())) {
            return TOOLSMITH_3_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_3_OFFER_1.get();
        }
    }
    public static String getToolsmith3Request1() {
        if (Objects.equals(TOOLSMITH_3_REQUEST_1.get(), TOOLSMITH_3_REQUEST_1.getDefault())) {
            return TOOLSMITH_3_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_3_REQUEST_1.get();
        }
    }
    public static String getToolsmith2Offer2() {
        if (Objects.equals(TOOLSMITH_2_OFFER_2.get(), TOOLSMITH_2_OFFER_2.getDefault())) {
            return TOOLSMITH_2_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_2_OFFER_2.get();
        }
    }
    public static String getToolsmith2Request2() {
        if (Objects.equals(TOOLSMITH_2_REQUEST_2.get(), TOOLSMITH_2_REQUEST_2.getDefault())) {
            return TOOLSMITH_2_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_2_REQUEST_2.get();
        }
    }
    public static String getToolsmith2Offer1() {
        if (Objects.equals(TOOLSMITH_2_OFFER_1.get(), TOOLSMITH_2_OFFER_1.getDefault())) {
            return TOOLSMITH_2_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_2_OFFER_1.get();
        }
    }
    public static String getToolsmith2Request1() {
        if (Objects.equals(TOOLSMITH_2_REQUEST_1.get(), TOOLSMITH_2_REQUEST_1.getDefault())) {
            return TOOLSMITH_2_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_2_REQUEST_1.get();
        }
    }
    public static String getToolsmith1Offer2() {
        if (Objects.equals(TOOLSMITH_1_OFFER_2.get(), TOOLSMITH_1_OFFER_2.getDefault())) {
            return TOOLSMITH_1_OFFER_2.getDefault();
        }
        else {
            return TOOLSMITH_1_OFFER_2.get();
        }
    }
    public static String getToolsmith1Request2() {
        if (Objects.equals(TOOLSMITH_1_REQUEST_2.get(), TOOLSMITH_1_REQUEST_2.getDefault())) {
            return TOOLSMITH_1_REQUEST_2.getDefault();
        }
        else {
            return TOOLSMITH_1_REQUEST_2.get();
        }
    }
    public static String getToolsmith1Offer1() {
        if (Objects.equals(TOOLSMITH_1_OFFER_1.get(), TOOLSMITH_1_OFFER_1.getDefault())) {
            return TOOLSMITH_1_OFFER_1.getDefault();
        }
        else {
            return TOOLSMITH_1_OFFER_1.get();
        }
    }
    public static String getToolsmith1Request1() {
        if (Objects.equals(TOOLSMITH_1_REQUEST_1.get(), TOOLSMITH_1_REQUEST_1.getDefault())) {
            return TOOLSMITH_1_REQUEST_1.getDefault();
        }
        else {
            return TOOLSMITH_1_REQUEST_1.get();
        }
    }
    // WEAPONSMITH TRADE GETTERS
    public static String getWeaponsmith5Offer2() {
        if (Objects.equals(WEAPONSMITH_5_OFFER_2.get(), WEAPONSMITH_5_OFFER_2.getDefault())) {
            return WEAPONSMITH_5_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_5_OFFER_2.get();
        }
    }
    public static String getWeaponsmith5Request2() {
        if (Objects.equals(WEAPONSMITH_5_REQUEST_2.get(), WEAPONSMITH_5_REQUEST_2.getDefault())) {
            return WEAPONSMITH_5_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_5_REQUEST_2.get();
        }
    }
    public static String getWeaponsmith5Offer1() {
        if (Objects.equals(WEAPONSMITH_5_OFFER_1.get(), WEAPONSMITH_5_OFFER_1.getDefault())) {
            return WEAPONSMITH_5_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_5_OFFER_1.get();
        }
    }
    public static String getWeaponsmith5Request1() {
        if (Objects.equals(WEAPONSMITH_5_REQUEST_1.get(), WEAPONSMITH_5_REQUEST_1.getDefault())) {
            return WEAPONSMITH_5_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_5_REQUEST_1.get();
        }
    }
    public static String getWeaponsmith4Offer2() {
        if (Objects.equals(WEAPONSMITH_4_OFFER_2.get(), WEAPONSMITH_4_OFFER_2.getDefault())) {
            return WEAPONSMITH_4_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_4_OFFER_2.get();
        }
    }
    public static String getWeaponsmith4Request2() {
        if (Objects.equals(WEAPONSMITH_4_REQUEST_2.get(), WEAPONSMITH_4_REQUEST_2.getDefault())) {
            return WEAPONSMITH_4_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_4_REQUEST_2.get();
        }
    }
    public static int getWeaponsmith4Offer2Count() {
        if (Objects.equals(WEAPONSMITH_4_OFFER_2_COUNT.get(), WEAPONSMITH_4_OFFER_2_COUNT.getDefault())) {
            return WEAPONSMITH_4_OFFER_2_COUNT.getDefault();
        }
        else {
            return WEAPONSMITH_4_OFFER_2_COUNT.get();
        }
    }
    public static String getWeaponsmith4Offer3() {
        if (Objects.equals(WEAPONSMITH_4_OFFER_3.get(), WEAPONSMITH_4_OFFER_3.getDefault())) {
            return WEAPONSMITH_4_OFFER_3.getDefault();
        }
        else {
            return WEAPONSMITH_4_OFFER_3.get();
        }
    }
    public static String getWeaponsmith4Request3() {
        if (Objects.equals(WEAPONSMITH_4_REQUEST_3.get(), WEAPONSMITH_4_REQUEST_3.getDefault())) {
            return WEAPONSMITH_4_REQUEST_3.getDefault();
        }
        else {
            return WEAPONSMITH_4_REQUEST_3.get();
        }
    }
    public static String getWeaponsmith4Offer1() {
        if (Objects.equals(WEAPONSMITH_4_OFFER_1.get(), WEAPONSMITH_4_OFFER_1.getDefault())) {
            return WEAPONSMITH_4_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_4_OFFER_1.get();
        }
    }
    public static String getWeaponsmith4Request1() {
        if (Objects.equals(WEAPONSMITH_4_REQUEST_1.get(), WEAPONSMITH_4_REQUEST_1.getDefault())) {
            return WEAPONSMITH_4_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_4_REQUEST_1.get();
        }
    }
    public static String getWeaponsmith3Offer2() {
        if (Objects.equals(WEAPONSMITH_3_OFFER_2.get(), WEAPONSMITH_3_OFFER_2.getDefault())) {
            return WEAPONSMITH_3_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_3_OFFER_2.get();
        }
    }
    public static String getWeaponsmith3Request2() {
        if (Objects.equals(WEAPONSMITH_3_REQUEST_2.get(), WEAPONSMITH_3_REQUEST_2.getDefault())) {
            return WEAPONSMITH_3_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_3_REQUEST_2.get();
        }
    }
    public static String getWeaponsmith3Offer1() {
        if (Objects.equals(WEAPONSMITH_3_OFFER_1.get(), WEAPONSMITH_3_OFFER_1.getDefault())) {
            return WEAPONSMITH_3_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_3_OFFER_1.get();
        }
    }
    public static String getWeaponsmith3Request1() {
        if (Objects.equals(WEAPONSMITH_3_REQUEST_1.get(), WEAPONSMITH_3_REQUEST_1.getDefault())) {
            return WEAPONSMITH_3_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_3_REQUEST_1.get();
        }
    }
    public static String getWeaponsmith2Offer2() {
        if (Objects.equals(WEAPONSMITH_2_OFFER_2.get(), WEAPONSMITH_2_OFFER_2.getDefault())) {
            return WEAPONSMITH_2_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_2_OFFER_2.get();
        }
    }
    public static String getWeaponsmith2Request2() {
        if (Objects.equals(WEAPONSMITH_2_REQUEST_2.get(), WEAPONSMITH_2_REQUEST_2.getDefault())) {
            return WEAPONSMITH_2_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_2_REQUEST_2.get();
        }
    }
    public static String getWeaponsmith2Offer1() {
        if (Objects.equals(WEAPONSMITH_2_OFFER_1.get(), WEAPONSMITH_2_OFFER_1.getDefault())) {
            return WEAPONSMITH_2_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_2_OFFER_1.get();
        }
    }
    public static String getWeaponsmith2Request1() {
        if (Objects.equals(WEAPONSMITH_2_REQUEST_1.get(), WEAPONSMITH_2_REQUEST_1.getDefault())) {
            return WEAPONSMITH_2_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_2_REQUEST_1.get();
        }
    }
    public static String getWeaponsmith1Offer2() {
        if (Objects.equals(WEAPONSMITH_1_OFFER_2.get(), WEAPONSMITH_1_OFFER_2.getDefault())) {
            return WEAPONSMITH_1_OFFER_2.getDefault();
        }
        else {
            return WEAPONSMITH_1_OFFER_2.get();
        }
    }
    public static String getWeaponsmith1Request2() {
        if (Objects.equals(WEAPONSMITH_1_REQUEST_2.get(), WEAPONSMITH_1_REQUEST_2.getDefault())) {
            return WEAPONSMITH_1_REQUEST_2.getDefault();
        }
        else {
            return WEAPONSMITH_1_REQUEST_2.get();
        }
    }
    public static String getWeaponsmith1Offer1() {
        if (Objects.equals(WEAPONSMITH_1_OFFER_1.get(), WEAPONSMITH_1_OFFER_1.getDefault())) {
            return WEAPONSMITH_1_OFFER_1.getDefault();
        }
        else {
            return WEAPONSMITH_1_OFFER_1.get();
        }
    }
    public static String getWeaponsmith1Request1() {
        if (Objects.equals(WEAPONSMITH_1_REQUEST_1.get(), WEAPONSMITH_1_REQUEST_1.getDefault())) {
            return WEAPONSMITH_1_REQUEST_1.getDefault();
        }
        else {
            return WEAPONSMITH_1_REQUEST_1.get();
        }
    }
    // WANDERING TRADER TRADE GETTERS
    public static String getWanderingRareOffer4() {
        if (Objects.equals(WANDERING_RARE_OFFER_4.get(), WANDERING_RARE_OFFER_4.getDefault())) {
            return WANDERING_RARE_OFFER_4.getDefault();
        }
        else {
            return WANDERING_RARE_OFFER_4.get();
        }
    }
    public static String getWanderingRareRequest4() {
        if (Objects.equals(WANDERING_RARE_REQUEST_4.get(), WANDERING_RARE_REQUEST_4.getDefault())) {
            return WANDERING_RARE_REQUEST_4.getDefault();
        }
        else {
            return WANDERING_RARE_REQUEST_4.get();
        }
    }
    public static String getWanderingRareOffer3() {
        if (Objects.equals(WANDERING_RARE_OFFER_3.get(), WANDERING_RARE_OFFER_3.getDefault())) {
            return WANDERING_RARE_OFFER_3.getDefault();
        }
        else {
            return WANDERING_RARE_OFFER_3.get();
        }
    }
    public static String getWanderingRareRequest3() {
        if (Objects.equals(WANDERING_RARE_REQUEST_3.get(), WANDERING_RARE_REQUEST_3.getDefault())) {
            return WANDERING_RARE_REQUEST_3.getDefault();
        }
        else {
            return WANDERING_RARE_REQUEST_3.get();
        }
    }
    public static String getWanderingRareOffer2() {
        if (Objects.equals(WANDERING_RARE_OFFER_2.get(), WANDERING_RARE_OFFER_2.getDefault())) {
            return WANDERING_RARE_OFFER_2.getDefault();
        }
        else {
            return WANDERING_RARE_OFFER_2.get();
        }
    }
    public static String getWanderingRareRequest2() {
        if (Objects.equals(WANDERING_RARE_REQUEST_2.get(), WANDERING_RARE_REQUEST_2.getDefault())) {
            return WANDERING_RARE_REQUEST_2.getDefault();
        }
        else {
            return WANDERING_RARE_REQUEST_2.get();
        }
    }
    public static String getWanderingRareOffer1() {
        if (Objects.equals(WANDERING_RARE_OFFER_1.get(), WANDERING_RARE_OFFER_1.getDefault())) {
            return WANDERING_RARE_OFFER_1.getDefault();
        }
        else {
            return WANDERING_RARE_OFFER_1.get();
        }
    }
    public static String getWanderingRareRequest1() {
        if (Objects.equals(WANDERING_RARE_REQUEST_1.get(), WANDERING_RARE_REQUEST_1.getDefault())) {
            return WANDERING_RARE_REQUEST_1.getDefault();
        }
        else {
            return WANDERING_RARE_REQUEST_1.get();
        }
    }
    public static int getWanderingOffer10Count() {
        if (Objects.equals(WANDERING_OFFER_10_COUNT.get(), WANDERING_OFFER_10_COUNT.getDefault())) {
            return WANDERING_OFFER_10_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_10_COUNT.get();
        }
    }
    public static String getWanderingOffer10() {
        if (Objects.equals(WANDERING_OFFER_10.get(), WANDERING_OFFER_10.getDefault())) {
            return WANDERING_OFFER_10.getDefault();
        }
        else {
            return WANDERING_OFFER_10.get();
        }
    }
    public static String getWanderingRequest10() {
        if (Objects.equals(WANDERING_REQUEST_10.get(), WANDERING_REQUEST_10.getDefault())) {
            return WANDERING_REQUEST_10.getDefault();
        }
        else {
            return WANDERING_REQUEST_10.get();
        }
    }
    public static String getWanderingOffer9() {
        if (Objects.equals(WANDERING_OFFER_9.get(), WANDERING_OFFER_9.getDefault())) {
            return WANDERING_OFFER_9.getDefault();
        }
        else {
            return WANDERING_OFFER_9.get();
        }
    }
    public static String getWanderingRequest9() {
        if (Objects.equals(WANDERING_REQUEST_9.get(), WANDERING_REQUEST_9.getDefault())) {
            return WANDERING_REQUEST_9.getDefault();
        }
        else {
            return WANDERING_REQUEST_9.get();
        }
    }
    public static String getWanderingOffer8() {
        if (Objects.equals(WANDERING_OFFER_8.get(), WANDERING_OFFER_8.getDefault())) {
            return WANDERING_OFFER_8.getDefault();
        }
        else {
            return WANDERING_OFFER_8.get();
        }
    }
    public static String getWanderingRequest8() {
        if (Objects.equals(WANDERING_REQUEST_8.get(), WANDERING_REQUEST_8.getDefault())) {
            return WANDERING_REQUEST_8.getDefault();
        }
        else {
            return WANDERING_REQUEST_8.get();
        }
    }
    public static int getWanderingOffer7Count() {
        if (Objects.equals(WANDERING_OFFER_7_COUNT.get(), WANDERING_OFFER_7_COUNT.getDefault())) {
            return WANDERING_OFFER_7_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_7_COUNT.get();
        }
    }
    public static String getWanderingOffer7() {
        if (Objects.equals(WANDERING_OFFER_7.get(), WANDERING_OFFER_7.getDefault())) {
            return WANDERING_OFFER_7.getDefault();
        }
        else {
            return WANDERING_OFFER_7.get();
        }
    }
    public static String getWanderingRequest7() {
        if (Objects.equals(WANDERING_REQUEST_7.get(), WANDERING_REQUEST_7.getDefault())) {
            return WANDERING_REQUEST_7.getDefault();
        }
        else {
            return WANDERING_REQUEST_7.get();
        }
    }
    public static int getWanderingOffer6Count() {
        if (Objects.equals(WANDERING_OFFER_6_COUNT.get(), WANDERING_OFFER_6_COUNT.getDefault())) {
            return WANDERING_OFFER_6_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_6_COUNT.get();
        }
    }
    public static String getWanderingOffer6() {
        if (Objects.equals(WANDERING_OFFER_6.get(), WANDERING_OFFER_6.getDefault())) {
            return WANDERING_OFFER_6.getDefault();
        }
        else {
            return WANDERING_OFFER_6.get();
        }
    }
    public static String getWanderingRequest6() {
        if (Objects.equals(WANDERING_REQUEST_6.get(), WANDERING_REQUEST_6.getDefault())) {
            return WANDERING_REQUEST_6.getDefault();
        }
        else {
            return WANDERING_REQUEST_6.get();
        }
    }
    public static String getWanderingOffer5() {
        if (Objects.equals(WANDERING_OFFER_5.get(), WANDERING_OFFER_5.getDefault())) {
            return WANDERING_OFFER_5.getDefault();
        }
        else {
            return WANDERING_OFFER_5.get();
        }
    }
    public static String getWanderingRequest5() {
        if (Objects.equals(WANDERING_REQUEST_5.get(), WANDERING_REQUEST_5.getDefault())) {
            return WANDERING_REQUEST_5.getDefault();
        }
        else {
            return WANDERING_REQUEST_5.get();
        }
    }
    public static int getWanderingOffer4Count() {
        if (Objects.equals(WANDERING_OFFER_4_COUNT.get(), WANDERING_OFFER_4_COUNT.getDefault())) {
            return WANDERING_OFFER_4_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_4_COUNT.get();
        }
    }
    public static String getWanderingOffer4() {
        if (Objects.equals(WANDERING_OFFER_4.get(), WANDERING_OFFER_4.getDefault())) {
            return WANDERING_OFFER_4.getDefault();
        }
        else {
            return WANDERING_OFFER_4.get();
        }
    }
    public static String getWanderingRequest4() {
        if (Objects.equals(WANDERING_REQUEST_4.get(), WANDERING_REQUEST_4.getDefault())) {
            return WANDERING_REQUEST_4.getDefault();
        }
        else {
            return WANDERING_REQUEST_4.get();
        }
    }
    public static int getWanderingOffer3Count() {
        if (Objects.equals(WANDERING_OFFER_3_COUNT.get(), WANDERING_OFFER_3_COUNT.getDefault())) {
            return WANDERING_OFFER_3_COUNT.getDefault();
        }
        else {
            return WANDERING_OFFER_3_COUNT.get();
        }
    }
    public static String getWanderingOffer3() {
        if (Objects.equals(WANDERING_OFFER_3.get(), WANDERING_OFFER_3.getDefault())) {
            return WANDERING_OFFER_3.getDefault();
        }
        else {
            return WANDERING_OFFER_3.get();
        }
    }
    public static String getWanderingRequest3() {
        if (Objects.equals(WANDERING_REQUEST_3.get(), WANDERING_REQUEST_3.getDefault())) {
            return WANDERING_REQUEST_3.getDefault();
        }
        else {
            return WANDERING_REQUEST_3.get();
        }
    }
    public static String getWanderingOffer2() {
        if (Objects.equals(WANDERING_OFFER_2.get(), WANDERING_OFFER_2.getDefault())) {
            return WANDERING_OFFER_2.getDefault();
        }
        else {
            return WANDERING_OFFER_2.get();
        }
    }
    public static String getWanderingRequest2() {
        if (Objects.equals(WANDERING_REQUEST_2.get(), WANDERING_REQUEST_2.getDefault())) {
            return WANDERING_REQUEST_2.getDefault();
        }
        else {
            return WANDERING_REQUEST_2.get();
        }
    }
    public static String getWanderingOffer1() {
        if (Objects.equals(WANDERING_OFFER_1.get(), WANDERING_OFFER_1.getDefault())) {
            return WANDERING_OFFER_1.getDefault();
        }
        else {
            return WANDERING_OFFER_1.get();
        }
    }
    public static String getWanderingRequest1() {
        if (Objects.equals(WANDERING_REQUEST_1.get(), WANDERING_REQUEST_1.getDefault())) {
            return WANDERING_REQUEST_1.getDefault();
        }
        else {
            return WANDERING_REQUEST_1.get();
        }
    }
    // TodeCoin Trades
    // BANKER TRADE GETTERS
    public static String getBanker5Offer4() {
        if (Objects.equals(BANKER_5_OFFER_4.get(), BANKER_5_OFFER_4.getDefault())) {
            return BANKER_5_OFFER_4.getDefault();
        }
        else {
            return BANKER_5_OFFER_4.get();
        }
    }
    public static String getBanker5Request4() {
        if (Objects.equals(BANKER_5_REQUEST_4.get(), BANKER_5_REQUEST_4.getDefault())) {
            return BANKER_5_REQUEST_4.getDefault();
        }
        else {
            return BANKER_5_REQUEST_4.get();
        }
    }
    public static String getBanker5Offer3() {
        if (Objects.equals(BANKER_5_OFFER_3.get(), BANKER_5_OFFER_3.getDefault())) {
            return BANKER_5_OFFER_3.getDefault();
        }
        else {
            return BANKER_5_OFFER_3.get();
        }
    }
    public static String getBanker5Request3() {
        if (Objects.equals(BANKER_5_REQUEST_3.get(), BANKER_5_REQUEST_3.getDefault())) {
            return BANKER_5_REQUEST_3.getDefault();
        }
        else {
            return BANKER_5_REQUEST_3.get();
        }
    }
    public static String getBanker5Offer2() {
        if (Objects.equals(BANKER_5_OFFER_2.get(), BANKER_5_OFFER_2.getDefault())) {
            return BANKER_5_OFFER_2.getDefault();
        }
        else {
            return BANKER_5_OFFER_2.get();
        }
    }
    public static String getBanker5Request2() {
        if (Objects.equals(BANKER_5_REQUEST_2.get(), BANKER_5_REQUEST_2.getDefault())) {
            return BANKER_5_REQUEST_2.getDefault();
        }
        else {
            return BANKER_5_REQUEST_2.get();
        }
    }
    public static String getBanker5Offer1() {
        if (Objects.equals(BANKER_5_OFFER_1.get(), BANKER_5_OFFER_1.getDefault())) {
            return BANKER_5_OFFER_1.getDefault();
        }
        else {
            return BANKER_5_OFFER_1.get();
        }
    }
    public static String getBanker5Request1() {
        if (Objects.equals(BANKER_5_REQUEST_1.get(), BANKER_5_REQUEST_1.getDefault())) {
            return BANKER_5_REQUEST_1.getDefault();
        }
        else {
            return BANKER_5_REQUEST_1.get();
        }
    }
    public static String getBanker4Offer2() {
        if (Objects.equals(BANKER_4_OFFER_2.get(), BANKER_4_OFFER_2.getDefault())) {
            return BANKER_4_OFFER_2.getDefault();
        }
        else {
            return BANKER_4_OFFER_2.get();
        }
    }
    public static String getBanker4Request2() {
        if (Objects.equals(BANKER_4_REQUEST_2.get(), BANKER_4_REQUEST_2.getDefault())) {
            return BANKER_4_REQUEST_2.getDefault();
        }
        else {
            return BANKER_4_REQUEST_2.get();
        }
    }
    public static String getBanker4Offer1() {
        if (Objects.equals(BANKER_4_OFFER_1.get(), BANKER_4_OFFER_1.getDefault())) {
            return BANKER_4_OFFER_1.getDefault();
        }
        else {
            return BANKER_4_OFFER_1.get();
        }
    }
    public static String getBanker4Request1() {
        if (Objects.equals(BANKER_4_REQUEST_1.get(), BANKER_4_REQUEST_1.getDefault())) {
            return BANKER_4_REQUEST_1.getDefault();
        }
        else {
            return BANKER_4_REQUEST_1.get();
        }
    }
    public static String getBanker3Offer2() {
        if (Objects.equals(BANKER_3_OFFER_2.get(), BANKER_3_OFFER_2.getDefault())) {
            return BANKER_3_OFFER_2.getDefault();
        }
        else {
            return BANKER_3_OFFER_2.get();
        }
    }
    public static String getBanker3Request2() {
        if (Objects.equals(BANKER_3_REQUEST_2.get(), BANKER_3_REQUEST_2.getDefault())) {
            return BANKER_3_REQUEST_2.getDefault();
        }
        else {
            return BANKER_3_REQUEST_2.get();
        }
    }
    public static String getBanker3Offer1() {
        if (Objects.equals(BANKER_3_OFFER_1.get(), BANKER_3_OFFER_1.getDefault())) {
            return BANKER_3_OFFER_1.getDefault();
        }
        else {
            return BANKER_3_OFFER_1.get();
        }
    }
    public static String getBanker3Request1() {
        if (Objects.equals(BANKER_3_REQUEST_1.get(), BANKER_3_REQUEST_1.getDefault())) {
            return BANKER_3_REQUEST_1.getDefault();
        }
        else {
            return BANKER_3_REQUEST_1.get();
        }
    }
    public static String getBanker2Offer2() {
        if (Objects.equals(BANKER_2_OFFER_2.get(), BANKER_2_OFFER_2.getDefault())) {
            return BANKER_2_OFFER_2.getDefault();
        }
        else {
            return BANKER_2_OFFER_2.get();
        }
    }
    public static String getBanker2Request2() {
        if (Objects.equals(BANKER_2_REQUEST_2.get(), BANKER_2_REQUEST_2.getDefault())) {
            return BANKER_2_REQUEST_2.getDefault();
        }
        else {
            return BANKER_2_REQUEST_2.get();
        }
    }
    public static String getBanker2Offer1() {
        if (Objects.equals(BANKER_2_OFFER_1.get(), BANKER_2_OFFER_1.getDefault())) {
            return BANKER_2_OFFER_1.getDefault();
        }
        else {
            return BANKER_2_OFFER_1.get();
        }
    }
    public static String getBanker2Request1() {
        if (Objects.equals(BANKER_2_REQUEST_1.get(), BANKER_2_REQUEST_1.getDefault())) {
            return BANKER_2_REQUEST_1.getDefault();
        }
        else {
            return BANKER_2_REQUEST_1.get();
        }
    }
    public static String getBanker1Offer2() {
        if (Objects.equals(BANKER_1_OFFER_2.get(), BANKER_1_OFFER_2.getDefault())) {
            return BANKER_1_OFFER_2.getDefault();
        }
        else {
            return BANKER_1_OFFER_2.get();
        }
    }
    public static String getBanker1Request2() {
        if (Objects.equals(BANKER_1_REQUEST_2.get(), BANKER_1_REQUEST_2.getDefault())) {
            return BANKER_1_REQUEST_2.getDefault();
        }
        else {
            return BANKER_1_REQUEST_2.get();
        }
    }
    public static String getBanker1Offer1() {
        if (Objects.equals(BANKER_1_OFFER_1.get(), BANKER_1_OFFER_1.getDefault())) {
            return BANKER_1_OFFER_1.getDefault();
        }
        else {
            return BANKER_1_OFFER_1.get();
        }
    }
    public static String getBanker1Request1() {
        if (Objects.equals(BANKER_1_REQUEST_1.get(), BANKER_1_REQUEST_1.getDefault())) {
            return BANKER_1_REQUEST_1.getDefault();
        }
        else {
            return BANKER_1_REQUEST_1.get();
        }
    }
    // LEPRECHAUN TRADE GETTERS
    public static String getLeprechaun5Offer3() {
        if (Objects.equals(LEPRECHAUN_5_OFFER_3.get(), LEPRECHAUN_5_OFFER_3.getDefault())) {
            return LEPRECHAUN_5_OFFER_3.getDefault();
        }
        else {
            return LEPRECHAUN_5_OFFER_3.get();
        }
    }
    public static String getLeprechaun5Request3() {
        if (Objects.equals(LEPRECHAUN_5_REQUEST_3.get(), LEPRECHAUN_5_REQUEST_3.getDefault())) {
            return LEPRECHAUN_5_REQUEST_3.getDefault();
        }
        else {
            return LEPRECHAUN_5_REQUEST_3.get();
        }
    }
    public static String getLeprechaun5Offer2() {
        if (Objects.equals(LEPRECHAUN_5_OFFER_2.get(), LEPRECHAUN_5_OFFER_2.getDefault())) {
            return LEPRECHAUN_5_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_5_OFFER_2.get();
        }
    }
    public static String getLeprechaun5Request2() {
        if (Objects.equals(LEPRECHAUN_5_REQUEST_2.get(), LEPRECHAUN_5_REQUEST_2.getDefault())) {
            return LEPRECHAUN_5_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_5_REQUEST_2.get();
        }
    }
    public static String getLeprechaun5Offer1() {
        if (Objects.equals(LEPRECHAUN_5_OFFER_1.get(), LEPRECHAUN_5_OFFER_1.getDefault())) {
            return LEPRECHAUN_5_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_5_OFFER_1.get();
        }
    }
    public static String getLeprechaun5Request1() {
        if (Objects.equals(LEPRECHAUN_5_REQUEST_1.get(), LEPRECHAUN_5_REQUEST_1.getDefault())) {
            return LEPRECHAUN_5_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_5_REQUEST_1.get();
        }
    }
    public static String getLeprechaun4Offer2() {
        if (Objects.equals(LEPRECHAUN_4_OFFER_2.get(), LEPRECHAUN_4_OFFER_2.getDefault())) {
            return LEPRECHAUN_4_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_4_OFFER_2.get();
        }
    }
    public static String getLeprechaun4Request2() {
        if (Objects.equals(LEPRECHAUN_4_REQUEST_2.get(), LEPRECHAUN_4_REQUEST_2.getDefault())) {
            return LEPRECHAUN_4_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_4_REQUEST_2.get();
        }
    }
    public static String getLeprechaun4Offer1() {
        if (Objects.equals(LEPRECHAUN_4_OFFER_1.get(), LEPRECHAUN_4_OFFER_1.getDefault())) {
            return LEPRECHAUN_4_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_4_OFFER_1.get();
        }
    }
    public static String getLeprechaun4Request1() {
        if (Objects.equals(LEPRECHAUN_4_REQUEST_1.get(), LEPRECHAUN_4_REQUEST_1.getDefault())) {
            return LEPRECHAUN_4_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_4_REQUEST_1.get();
        }
    }
    public static String getLeprechaun3Offer6() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_6.get(), LEPRECHAUN_3_OFFER_6.getDefault())) {
            return LEPRECHAUN_3_OFFER_6.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_6.get();
        }
    }
    public static String getLeprechaun3Request6() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_6.get(), LEPRECHAUN_3_REQUEST_6.getDefault())) {
            return LEPRECHAUN_3_REQUEST_6.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_6.get();
        }
    }
    public static String getLeprechaun3Offer5() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_5.get(), LEPRECHAUN_3_OFFER_5.getDefault())) {
            return LEPRECHAUN_3_OFFER_5.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_5.get();
        }
    }
    public static String getLeprechaun3Request5() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_5.get(), LEPRECHAUN_3_REQUEST_5.getDefault())) {
            return LEPRECHAUN_3_REQUEST_5.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_5.get();
        }
    }
    public static String getLeprechaun3Offer4() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_4.get(), LEPRECHAUN_3_OFFER_4.getDefault())) {
            return LEPRECHAUN_3_OFFER_4.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_4.get();
        }
    }
    public static String getLeprechaun3Request4() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_4.get(), LEPRECHAUN_3_OFFER_4.getDefault())) {
            return LEPRECHAUN_3_OFFER_4.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_4.get();
        }
    }
    public static String getLeprechaun3Offer3() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_3.get(), LEPRECHAUN_3_OFFER_3.getDefault())) {
            return LEPRECHAUN_3_OFFER_3.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_3.get();
        }
    }
    public static String getLeprechaun3Request3() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_3.get(), LEPRECHAUN_3_REQUEST_3.getDefault())) {
            return LEPRECHAUN_3_REQUEST_3.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_3.get();
        }
    }
    public static String getLeprechaun3Offer2() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_2.get(), LEPRECHAUN_3_OFFER_2.getDefault())) {
            return LEPRECHAUN_3_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_2.get();
        }
    }
    public static String getLeprechaun3Request2() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_2.get(), LEPRECHAUN_3_REQUEST_2.getDefault())) {
            return LEPRECHAUN_3_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_2.get();
        }
    }
    public static String getLeprechaun3Offer1() {
        if (Objects.equals(LEPRECHAUN_3_OFFER_1.get(), LEPRECHAUN_3_OFFER_1.getDefault())) {
            return LEPRECHAUN_3_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_3_OFFER_1.get();
        }
    }
    public static String getLeprechaun3Request1() {
        if (Objects.equals(LEPRECHAUN_3_REQUEST_1.get(), LEPRECHAUN_3_REQUEST_1.getDefault())) {
            return LEPRECHAUN_3_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_3_REQUEST_1.get();
        }
    }
    public static String getLeprechaun2Offer6() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_6.get(), LEPRECHAUN_2_OFFER_6.getDefault())) {
            return LEPRECHAUN_2_OFFER_6.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_6.get();
        }
    }
    public static String getLeprechaun2Request6() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_6.get(), LEPRECHAUN_2_REQUEST_6.getDefault())) {
            return LEPRECHAUN_2_REQUEST_6.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_6.get();
        }
    }
    public static String getLeprechaun2Offer5() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_5.get(), LEPRECHAUN_2_OFFER_5.getDefault())) {
            return LEPRECHAUN_2_OFFER_5.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_5.get();
        }
    }
    public static String getLeprechaun2Request5() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_5.get(), LEPRECHAUN_2_REQUEST_5.getDefault())) {
            return LEPRECHAUN_2_REQUEST_5.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_5.get();
        }
    }
    public static String getLeprechaun2Offer4() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_4.get(), LEPRECHAUN_2_OFFER_4.getDefault())) {
            return LEPRECHAUN_2_OFFER_4.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_4.get();
        }
    }
    public static String getLeprechaun2Request4() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_4.get(), LEPRECHAUN_2_REQUEST_4.getDefault())) {
            return LEPRECHAUN_2_REQUEST_4.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_4.get();
        }
    }
    public static String getLeprechaun2Offer3() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_3.get(), LEPRECHAUN_2_OFFER_3.getDefault())) {
            return LEPRECHAUN_2_OFFER_3.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_3.get();
        }
    }
    public static String getLeprechaun2Request3() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_3.get(), LEPRECHAUN_2_REQUEST_3.getDefault())) {
            return LEPRECHAUN_2_REQUEST_3.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_3.get();
        }
    }
    public static String getLeprechaun2Offer2() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_2.get(), LEPRECHAUN_2_OFFER_2.getDefault())) {
            return LEPRECHAUN_2_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_2.get();
        }
    }
    public static String getLeprechaun2Request2() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_2.get(), LEPRECHAUN_2_REQUEST_2.getDefault())) {
            return LEPRECHAUN_2_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_2.get();
        }
    }
    public static String getLeprechaun2Offer1() {
        if (Objects.equals(LEPRECHAUN_2_OFFER_1.get(), LEPRECHAUN_2_OFFER_1.getDefault())) {
            return LEPRECHAUN_2_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_2_OFFER_1.get();
        }
    }
    public static String getLeprechaun2Request1() {
        if (Objects.equals(LEPRECHAUN_2_REQUEST_1.get(), LEPRECHAUN_2_REQUEST_1.getDefault())) {
            return LEPRECHAUN_2_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_2_REQUEST_1.get();
        }
    }
    public static String getLeprechaun1Offer2() {
        if (Objects.equals(LEPRECHAUN_1_OFFER_2.get(), LEPRECHAUN_1_OFFER_2.getDefault())) {
            return LEPRECHAUN_1_OFFER_2.getDefault();
        }
        else {
            return LEPRECHAUN_1_OFFER_2.get();
        }
    }
    public static String getLeprechaun1Request2() {
        if (Objects.equals(LEPRECHAUN_1_REQUEST_2.get(), LEPRECHAUN_1_REQUEST_2.getDefault())) {
            return LEPRECHAUN_1_REQUEST_2.getDefault();
        }
        else {
            return LEPRECHAUN_1_REQUEST_2.get();
        }
    }
    public static String getLeprechaun1Offer1() {
        if (Objects.equals(LEPRECHAUN_1_OFFER_1.get(), LEPRECHAUN_1_OFFER_1.getDefault())) {
            return LEPRECHAUN_1_OFFER_1.getDefault();
        }
        else {
            return LEPRECHAUN_1_OFFER_1.get();
        }
    }
    public static String getLeprechaun1Request1() {
        if (Objects.equals(LEPRECHAUN_1_REQUEST_1.get(), LEPRECHAUN_1_REQUEST_1.getDefault())) {
            return LEPRECHAUN_1_REQUEST_1.getDefault();
        }
        else {
            return LEPRECHAUN_1_REQUEST_1.get();
        }
    }
    // NUMISMATIST TRADE GETTERS
    public static String getNumismatistRareRequest2B() {
        if (Objects.equals(NUMISMATIST_RARE_REQUEST_2B.get(), NUMISMATIST_RARE_REQUEST_2B.getDefault())) {
            return NUMISMATIST_RARE_REQUEST_2B.getDefault();
        }
        else {
            return NUMISMATIST_RARE_REQUEST_2B.get();
        }
    }
    public static String getNumismatistRareRequest2A() {
        if (Objects.equals(NUMISMATIST_RARE_REQUEST_2A.get(), NUMISMATIST_RARE_REQUEST_2A.getDefault())) {
            return NUMISMATIST_RARE_REQUEST_2A.getDefault();
        }
        else {
            return NUMISMATIST_RARE_REQUEST_2A.get();
        }
    }
    public static String getNumismatistRareOffer() {
        if (Objects.equals(NUMISMATIST_RARE_OFFER.get(), NUMISMATIST_RARE_OFFER.getDefault())) {
            return NUMISMATIST_RARE_OFFER.getDefault();
        }
        else {
            return NUMISMATIST_RARE_OFFER.get();
        }
    }
    public static String getNumismatistRareRequest1B() {
        if (Objects.equals(NUMISMATIST_RARE_REQUEST_1B.get(), NUMISMATIST_RARE_REQUEST_1B.getDefault())) {
            return NUMISMATIST_RARE_REQUEST_1B.getDefault();
        }
        else {
            return NUMISMATIST_RARE_REQUEST_1B.get();
        }
    }
    public static String getNumismatistRareRequest1A() {
        if (Objects.equals(NUMISMATIST_RARE_REQUEST_1A.get(), NUMISMATIST_RARE_REQUEST_1A.getDefault())) {
            return NUMISMATIST_RARE_REQUEST_1A.getDefault();
        }
        else {
            return NUMISMATIST_RARE_REQUEST_1A.get();
        }
    }
    public static String getNumismatistRequest5B() {
        if (Objects.equals(NUMISMATIST_REQUEST_5B.get(), NUMISMATIST_REQUEST_5B.getDefault())) {
            return NUMISMATIST_REQUEST_5B.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_5B.get();
        }
    }
    public static String getNumismatistRequest5A() {
        if (Objects.equals(NUMISMATIST_REQUEST_5A.get(), NUMISMATIST_REQUEST_5A.getDefault())) {
            return NUMISMATIST_REQUEST_5A.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_5A.get();
        }
    }
    public static String getNumismatistLootBoxLootTable() {
        if (Objects.equals(NUMISMATIST_LOOT_BOX_LOOT_TABLE.get(), NUMISMATIST_LOOT_BOX_LOOT_TABLE.getDefault())) {
            return NUMISMATIST_LOOT_BOX_LOOT_TABLE.getDefault();
        }
        else {
            return NUMISMATIST_LOOT_BOX_LOOT_TABLE.get();
        }
    }
    public static String getNumismatistLootBoxDisplayName() {
        if (Objects.equals(NUMISMATIST_LOOT_BOX_DISPLAY_NAME.get(), NUMISMATIST_LOOT_BOX_DISPLAY_NAME.getDefault())) {
            return NUMISMATIST_LOOT_BOX_DISPLAY_NAME.getDefault();
        }
        else {
            return NUMISMATIST_LOOT_BOX_DISPLAY_NAME.get();
        }
    }
    public static String getNumismatistOffer4() {
        if (Objects.equals(NUMISMATIST_OFFER_4.get(), NUMISMATIST_OFFER_4.getDefault())) {
            return NUMISMATIST_OFFER_4.getDefault();
        }
        else {
            return NUMISMATIST_OFFER_4.get();
        }
    }
    public static String getNumismatistRequest4B() {
        if (Objects.equals(NUMISMATIST_REQUEST_4B.get(), NUMISMATIST_REQUEST_4B.getDefault())) {
            return NUMISMATIST_REQUEST_4B.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_4B.get();
        }
    }
    public static String getNumismatistRequest4A() {
        if (Objects.equals(NUMISMATIST_REQUEST_4A.get(), NUMISMATIST_REQUEST_4A.getDefault())) {
            return NUMISMATIST_REQUEST_4A.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_4A.get();
        }
    }
    public static String getNumismatistTrade3MapMarker() {
        if (Objects.equals(NUMISMATIST_TRADE_3_MAP_MARKER.get(), NUMISMATIST_TRADE_3_MAP_MARKER.getDefault())) {
            return NUMISMATIST_TRADE_3_MAP_MARKER.getDefault();
        }
        else {
            return NUMISMATIST_TRADE_3_MAP_MARKER.get();
        }
    }
    public static String getNumismatistTrade3MapName() {
        if (Objects.equals(NUMISMATIST_TRADE_3_MAP_NAME.get(), NUMISMATIST_TRADE_3_MAP_NAME.getDefault())) {
            return NUMISMATIST_TRADE_3_MAP_NAME.getDefault();
        }
        else {
            return NUMISMATIST_TRADE_3_MAP_NAME.get();
        }
    }
    public static String getNumismatistTrade3StructureTag() {
        if (Objects.equals(NUMISMATIST_TRADE_3_STRUCTURE_TAG.get(), NUMISMATIST_TRADE_3_STRUCTURE_TAG.getDefault())) {
            return NUMISMATIST_TRADE_3_STRUCTURE_TAG.getDefault();
        }
        else {
            return NUMISMATIST_TRADE_3_STRUCTURE_TAG.get();
        }
    }
    public static String getNumismatistTradeRequest3B() {
        if (Objects.equals(NUMISMATIST_REQUEST_3B.get(), NUMISMATIST_REQUEST_3B.getDefault())) {
            return NUMISMATIST_REQUEST_3B.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_3B.get();
        }
    }
    public static String getNumismatistTradeRequest3A() {
        if (Objects.equals(NUMISMATIST_REQUEST_3A.get(), NUMISMATIST_REQUEST_3A.getDefault())) {
            return NUMISMATIST_REQUEST_3A.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_3A.get();
        }
    }
    public static String getNumismatistTradeOffer2() {
        if (Objects.equals(NUMISMATIST_OFFER_2.get(), NUMISMATIST_OFFER_2.getDefault())) {
            return NUMISMATIST_OFFER_2.getDefault();
        }
        else {
            return NUMISMATIST_OFFER_2.get();
        }
    }
    public static String getNumismatistTradeRequest2() {
        if (Objects.equals(NUMISMATIST_REQUEST_2.get(), NUMISMATIST_REQUEST_2.getDefault())) {
            return NUMISMATIST_REQUEST_2.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_2.get();
        }
    }
    public static String getNumismatistTradeOffer1() {
        if (Objects.equals(NUMISMATIST_OFFER_1.get(), NUMISMATIST_OFFER_1.getDefault())) {
            return NUMISMATIST_OFFER_1.getDefault();
        }
        else {
            return NUMISMATIST_OFFER_1.get();
        }
    }
    public static String getNumismatistTradeRequest1() {
        if (Objects.equals(NUMISMATIST_REQUEST_1.get(), NUMISMATIST_REQUEST_1.getDefault())) {
            return NUMISMATIST_REQUEST_1.getDefault();
        }
        else {
            return NUMISMATIST_REQUEST_1.get();
        }
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