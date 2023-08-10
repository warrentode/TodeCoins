package com.github.warrentode.todecoins.item;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.item.custom.*;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.entity.hostile.*;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.entity.neutral.*;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.entity.passive.*;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.gameplay.FishCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.gameplay.HeroCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday.BirthdayCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday.ChristmasCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday.HalloweenCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.year.CarnationPatronCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.year.CosmosPatronCoinItem;
import com.github.warrentode.todecoins.util.customtabs.ModCreativeModeTabs;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TodeCoins.MODID);

    public static final RegistryObject<Item> FOUR_LEAF_CLOVER = ITEMS.register("four_leaf_clover",
            () -> new FourLeafCloverItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> CURRENCY_STAMP = ITEMS.register("currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB).defaultDurability(64).setNoRepair()));
    public static final RegistryObject<Item> NETHER_CURRENCY_STAMP = ITEMS.register("nether_currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB).defaultDurability(64).setNoRepair()));
    public static final RegistryObject<Item> ENDONIAN_CURRENCY_STAMP = ITEMS.register("endonian_currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB).defaultDurability(64).setNoRepair()));

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> ENDONIAN_NUGGET = ITEMS.register("endonian_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> ENDONIAN_INGOT = ITEMS.register("endonian_ingot",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_NUGGET = ITEMS.register("lucky_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> IRON_COIN = ITEMS.register("iron_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_COIN = ITEMS.register("netherite_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> ENDONIAN_COIN = ITEMS.register("endonian_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> LUCKY_COIN = ITEMS.register("lucky_coin",
            () -> new LuckyCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> NETHER_GOLD_COIN = ITEMS.register("nether_gold_coin",
            () -> new BarterCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> EMERALD_QUARTER_BANK_NOTE = ITEMS.register("emerald_quarter_bank_note",
            () -> new BankNoteItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> EMERALD_HALF_BANK_NOTE = ITEMS.register("emerald_half_bank_note",
            () -> new BankNoteItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> EMERALD_BANK_NOTE = ITEMS.register("emerald_bank_note",
            () -> new BankNoteItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> EMERALD_FIBER = ITEMS.register("emerald_fiber",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_FIBER = ITEMS.register("lucky_fiber",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_THREAD = ITEMS.register("lucky_thread",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> EMERALD_COARSE_WOVE_PAPER = ITEMS.register("emerald_coarse_wove_paper",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> EMERALD_WOVE_PAPER = ITEMS.register("emerald_wove_paper",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> EMERALD_SMOOTH_WOVE_PAPER = ITEMS.register("emerald_smooth_wove_paper",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> LUCKY_FABRIC = ITEMS.register("lucky_fabric",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> LUCKY_BOOTS = ITEMS.register("lucky_boots",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_PANTS = ITEMS.register("lucky_pants",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_SHIRT = ITEMS.register("lucky_shirt",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_HAT = ITEMS.register("lucky_hat",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));

    // SPAWN EGGS
    public static final RegistryObject<ForgeSpawnEggItem> NUMISMATIST_SPAWN_EGG = ITEMS.register(
            "numismatist_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NUMISMATIST, 0xFFDC0A, 0x562300,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SNOW_GOLEM_SPAWN_EGG = ITEMS.register("snow_golem_spawn_egg",
            () -> new ForgeSpawnEggItem(() -> EntityType.SNOW_GOLEM, 0xFFFFFF, 0x00FFFF,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));

    // COLLECTIBLE COIN SETS
    // holiday collection
    // birthday set
    public static final RegistryObject<Item> BIRTHDAY_COIN_2023 = ITEMS.register("collectible_coin_birthday_2023",
            () -> new BirthdayCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // halloween set
    public static final RegistryObject<Item> HALLOWEEN_COIN_2023 = ITEMS.register("collectible_coin_halloween_2023",
            () -> new HalloweenCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // christmas coin
    public static final RegistryObject<Item> CHRISTMAS_COIN_2023 = ITEMS.register("collectible_coin_christmas_2023",
            () -> new ChristmasCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // patron collection
    // patron carnation anniversary set
    public static final RegistryObject<Item> MARSHALL_NASH_CARNATION_COIN = ITEMS.register("collectible_coin_carnation_marshall_nash",
            () -> new CarnationPatronCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> TREVOR_BRANNIGAN_CARNATION_COIN = ITEMS.register("collectible_coin_carnation_trevor_brannigan",
            () -> new CarnationPatronCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // patron cosmos anniversary set
    public static final RegistryObject<Item> MARSHALL_NASH_COSMOS_COIN = ITEMS.register("collectible_coin_cosmos_marshall_nash",
            () -> new CosmosPatronCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> TREVOR_BRANNIGAN_COSMOS_COIN = ITEMS.register("collectible_coin_cosmos_trevor_brannigan",
            () -> new CosmosPatronCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // gameplay collection
    // cod set
    public static final RegistryObject<Item> COPPER_COD_COIN = ITEMS.register("collectible_coin_cod_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_COD_COIN = ITEMS.register("collectible_coin_cod_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_COD_COIN = ITEMS.register("collectible_coin_cod_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_COD_COIN = ITEMS.register("collectible_coin_cod_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // hero set
    public static final RegistryObject<Item> COPPER_HERO_COIN = ITEMS.register("collectible_coin_hero_copper",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_HERO_COIN = ITEMS.register("collectible_coin_hero_iron",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_HERO_COIN = ITEMS.register("collectible_coin_hero_gold",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_HERO_COIN = ITEMS.register("collectible_coin_hero_netherite",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // pufferfish set
    public static final RegistryObject<Item> COPPER_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // salmon set
    public static final RegistryObject<Item> COPPER_SALMON_COIN = ITEMS.register("collectible_coin_salmon_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SALMON_COIN = ITEMS.register("collectible_coin_salmon_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SALMON_COIN = ITEMS.register("collectible_coin_salmon_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SALMON_COIN = ITEMS.register("collectible_coin_salmon_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // tropical fish set
    public static final RegistryObject<Item> COPPER_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // entity collection
    // allay set
    public static final RegistryObject<Item> COPPER_ALLAY_COIN = ITEMS.register("collectible_coin_allay_copper",
            () -> new AllayCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ALLAY_COIN = ITEMS.register("collectible_coin_allay_iron",
            () -> new AllayCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ALLAY_COIN = ITEMS.register("collectible_coin_allay_gold",
            () -> new AllayCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ALLAY_COIN = ITEMS.register("collectible_coin_allay_netherite",
            () -> new AllayCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // axolotl set
    public static final RegistryObject<Item> COPPER_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_copper",
            () -> new AxolotlCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_iron",
            () -> new AxolotlCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_gold",
            () -> new AxolotlCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_netherite",
            () -> new AxolotlCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // bat set
    public static final RegistryObject<Item> COPPER_BAT_COIN = ITEMS.register("collectible_coin_bat_copper",
            () -> new BatCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_BAT_COIN = ITEMS.register("collectible_coin_bat_iron",
            () -> new BatCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_BAT_COIN = ITEMS.register("collectible_coin_bat_gold",
            () -> new BatCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_BAT_COIN = ITEMS.register("collectible_coin_bat_netherite",
            () -> new BatCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // bee set
    public static final RegistryObject<Item> COPPER_BEE_COIN = ITEMS.register("collectible_coin_bee_copper",
            () -> new BeeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_BEE_COIN = ITEMS.register("collectible_coin_bee_iron",
            () -> new BeeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_BEE_COIN = ITEMS.register("collectible_coin_bee_gold",
            () -> new BeeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_BEE_COIN = ITEMS.register("collectible_coin_bee_netherite",
            () -> new BeeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // blaze set
    public static final RegistryObject<Item> COPPER_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_copper",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_iron",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_gold",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_netherite",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // camel set
    public static final RegistryObject<Item> COPPER_CAMEL_COIN = ITEMS.register("collectible_coin_camel_copper",
            () -> new CamelCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CAMEL_COIN = ITEMS.register("collectible_coin_camel_iron",
            () -> new CamelCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CAMEL_COIN = ITEMS.register("collectible_coin_camel_gold",
            () -> new CamelCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CAMEL_COIN = ITEMS.register("collectible_coin_camel_netherite",
            () -> new CamelCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // cat set
    public static final RegistryObject<Item> COPPER_CAT_COIN = ITEMS.register("collectible_coin_cat_copper",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CAT_COIN = ITEMS.register("collectible_coin_cat_iron",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CAT_COIN = ITEMS.register("collectible_coin_cat_gold",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CAT_COIN = ITEMS.register("collectible_coin_cat_netherite",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // cave spider set
    public static final RegistryObject<Item> COPPER_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_copper",
            () -> new CaveSpiderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_iron",
            () -> new CaveSpiderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_gold",
            () -> new CaveSpiderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_netherite",
            () -> new CaveSpiderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // chicken set
    public static final RegistryObject<Item> COPPER_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_copper",
            () -> new ChickenCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_iron",
            () -> new ChickenCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_gold",
            () -> new ChickenCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_netherite",
            () -> new ChickenCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // cow set
    public static final RegistryObject<Item> COPPER_COW_COIN = ITEMS.register("collectible_coin_cow_copper",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_COW_COIN = ITEMS.register("collectible_coin_cow_iron",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_COW_COIN = ITEMS.register("collectible_coin_cow_gold",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_COW_COIN = ITEMS.register("collectible_coin_cow_netherite",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // creeper set
    public static final RegistryObject<Item> COPPER_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_copper",
            () -> new CreeperCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_iron",
            () -> new CreeperCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_gold",
            () -> new CreeperCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_netherite",
            () -> new CreeperCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // dolphin set
    public static final RegistryObject<Item> COPPER_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_copper",
            () -> new DolphinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_iron",
            () -> new DolphinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_gold",
            () -> new DolphinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_netherite",
            () -> new DolphinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // donkey set
    public static final RegistryObject<Item> COPPER_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // drowned set
    public static final RegistryObject<Item> COPPER_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // elder guardian set
    public static final RegistryObject<Item> COPPER_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_copper",
            () -> new GuardianCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_iron",
            () -> new GuardianCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_gold",
            () -> new GuardianCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_netherite",
            () -> new GuardianCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // enderman set
    public static final RegistryObject<Item> COPPER_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_copper",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_iron",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_gold",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_netherite",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // endermite set
    public static final RegistryObject<Item> COPPER_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_copper",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_iron",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_gold",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_netherite",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // evoker set
    public static final RegistryObject<Item> COPPER_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_copper",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_iron",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_gold",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_netherite",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // fox set
    public static final RegistryObject<Item> COPPER_FOX_COIN = ITEMS.register("collectible_coin_fox_copper",
            () -> new FoxCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_FOX_COIN = ITEMS.register("collectible_coin_fox_iron",
            () -> new FoxCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_FOX_COIN = ITEMS.register("collectible_coin_fox_gold",
            () -> new FoxCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_FOX_COIN = ITEMS.register("collectible_coin_fox_netherite",
            () -> new FoxCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // frog set
    public static final RegistryObject<Item> COPPER_FROG_COIN = ITEMS.register("collectible_coin_frog_copper",
            () -> new FrogCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_FROG_COIN = ITEMS.register("collectible_coin_frog_iron",
            () -> new FrogCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_FROG_COIN = ITEMS.register("collectible_coin_frog_gold",
            () -> new FrogCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_FROG_COIN = ITEMS.register("collectible_coin_frog_netherite",
            () -> new FrogCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // glow squid set
    public static final RegistryObject<Item> COPPER_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_copper",
            () -> new SquidCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_iron",
            () -> new SquidCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_gold",
            () -> new SquidCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_netherite",
            () -> new SquidCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // goat set
    public static final RegistryObject<Item> COPPER_GOAT_COIN = ITEMS.register("collectible_coin_goat_copper",
            () -> new GoatCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GOAT_COIN = ITEMS.register("collectible_coin_goat_iron",
            () -> new GoatCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GOAT_COIN = ITEMS.register("collectible_coin_goat_gold",
            () -> new GoatCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GOAT_COIN = ITEMS.register("collectible_coin_goat_netherite",
            () -> new GoatCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // guardian set
    public static final RegistryObject<Item> COPPER_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_copper",
            () -> new GuardianCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_iron",
            () -> new GuardianCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_gold",
            () -> new GuardianCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_netherite",
            () -> new GuardianCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // ghast set
    public static final RegistryObject<Item> COPPER_GHAST_COIN = ITEMS.register("collectible_coin_ghast_copper",
            () -> new GhastCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GHAST_COIN = ITEMS.register("collectible_coin_ghast_iron",
            () -> new GhastCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GHAST_COIN = ITEMS.register("collectible_coin_ghast_gold",
            () -> new GhastCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GHAST_COIN = ITEMS.register("collectible_coin_ghast_netherite",
            () -> new GhastCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // hoglin set
    public static final RegistryObject<Item> COPPER_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_copper",
            () -> new HoglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_iron",
            () -> new HoglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_gold",
            () -> new HoglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_netherite",
            () -> new HoglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // horse set
    public static final RegistryObject<Item> COPPER_HORSE_COIN = ITEMS.register("collectible_coin_horse_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_HORSE_COIN = ITEMS.register("collectible_coin_horse_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_HORSE_COIN = ITEMS.register("collectible_coin_horse_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_HORSE_COIN = ITEMS.register("collectible_coin_horse_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // husk set
    public static final RegistryObject<Item> COPPER_HUSK_COIN = ITEMS.register("collectible_coin_husk_copper",
            () -> new HuskCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_HUSK_COIN = ITEMS.register("collectible_coin_husk_iron",
            () -> new HuskCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_HUSK_COIN = ITEMS.register("collectible_coin_husk_gold",
            () -> new HuskCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_HUSK_COIN = ITEMS.register("collectible_coin_husk_netherite",
            () -> new HuskCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // iron golem set
    public static final RegistryObject<Item> COPPER_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_copper",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_iron",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_gold",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_netherite",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // llama set
    public static final RegistryObject<Item> COPPER_LLAMA_COIN = ITEMS.register("collectible_coin_llama_copper",
            () -> new LlamaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_LLAMA_COIN = ITEMS.register("collectible_coin_llama_iron",
            () -> new LlamaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_LLAMA_COIN = ITEMS.register("collectible_coin_llama_gold",
            () -> new LlamaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_LLAMA_COIN = ITEMS.register("collectible_coin_llama_netherite",
            () -> new LlamaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // magma cube set
    public static final RegistryObject<Item> COPPER_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_copper",
            () -> new MagmaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_iron",
            () -> new MagmaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_gold",
            () -> new MagmaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_netherite",
            () -> new MagmaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // moobloom set
    public static final RegistryObject<Item> COPPER_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_copper",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_iron",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_gold",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_netherite",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // mooshroom set
    public static final RegistryObject<Item> COPPER_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_copper",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_iron",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_gold",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_netherite",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // mule set
    public static final RegistryObject<Item> COPPER_MULE_COIN = ITEMS.register("collectible_coin_mule_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_MULE_COIN = ITEMS.register("collectible_coin_mule_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_MULE_COIN = ITEMS.register("collectible_coin_mule_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_MULE_COIN = ITEMS.register("collectible_coin_mule_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // numismatist set
    public static final RegistryObject<Item> COPPER_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_copper",
            () -> new TraderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_iron",
            () -> new TraderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_gold",
            () -> new TraderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_netherite",
            () -> new TraderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // ocelot set
    public static final RegistryObject<Item> COPPER_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_copper",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_iron",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_gold",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_netherite",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // panda set
    public static final RegistryObject<Item> COPPER_PANDA_COIN = ITEMS.register("collectible_coin_panda_copper",
            () -> new PandaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PANDA_COIN = ITEMS.register("collectible_coin_panda_iron",
            () -> new PandaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PANDA_COIN = ITEMS.register("collectible_coin_panda_gold",
            () -> new PandaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PANDA_COIN = ITEMS.register("collectible_coin_panda_netherite",
            () -> new PandaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // parrot set
    public static final RegistryObject<Item> COPPER_PARROT_COIN = ITEMS.register("collectible_coin_parrot_copper",
            () -> new ParrotCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PARROT_COIN = ITEMS.register("collectible_coin_parrot_iron",
            () -> new ParrotCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PARROT_COIN = ITEMS.register("collectible_coin_parrot_gold",
            () -> new ParrotCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PARROT_COIN = ITEMS.register("collectible_coin_parrot_netherite",
            () -> new ParrotCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // pig set
    public static final RegistryObject<Item> COPPER_PIG_COIN = ITEMS.register("collectible_coin_pig_copper",
            () -> new PigCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PIG_COIN = ITEMS.register("collectible_coin_pig_iron",
            () -> new PigCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PIG_COIN = ITEMS.register("collectible_coin_pig_gold",
            () -> new PigCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PIG_COIN = ITEMS.register("collectible_coin_pig_netherite",
            () -> new PigCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // piglin set
    public static final RegistryObject<Item> COPPER_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_copper",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_iron",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_gold",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_netherite",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // polar bear set
    public static final RegistryObject<Item> COPPER_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_copper",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_iron",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_gold",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_netherite",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // rabbit set
    public static final RegistryObject<Item> COPPER_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_copper",
            () -> new RabbitCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_iron",
            () -> new RabbitCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_gold",
            () -> new RabbitCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_netherite",
            () -> new RabbitCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // sheep set
    public static final RegistryObject<Item> COPPER_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_copper",
            () -> new SheepCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_iron",
            () -> new SheepCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_gold",
            () -> new SheepCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_netherite",
            () -> new SheepCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // skeleton horse set
    public static final RegistryObject<Item> COPPER_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // slime set
    public static final RegistryObject<Item> COPPER_SLIME_COIN = ITEMS.register("collectible_coin_slime_copper",
            () -> new SlimeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SLIME_COIN = ITEMS.register("collectible_coin_slime_iron",
            () -> new SlimeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SLIME_COIN = ITEMS.register("collectible_coin_slime_gold",
            () -> new SlimeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SLIME_COIN = ITEMS.register("collectible_coin_slime_netherite",
            () -> new SlimeCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // sniffer set
    public static final RegistryObject<Item> COPPER_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_copper",
            () -> new SnifferCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_iron",
            () -> new SnifferCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_gold",
            () -> new SnifferCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_netherite",
            () -> new SnifferCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // snow golem set
    public static final RegistryObject<Item> COPPER_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_copper",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_iron",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_gold",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_netherite",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // spider set
    public static final RegistryObject<Item> COPPER_SPIDER_COIN = ITEMS.register("collectible_coin_spider_copper",
            () -> new SpiderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SPIDER_COIN = ITEMS.register("collectible_coin_spider_iron",
            () -> new SpiderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SPIDER_COIN = ITEMS.register("collectible_coin_spider_gold",
            () -> new SpiderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SPIDER_COIN = ITEMS.register("collectible_coin_spider_netherite",
            () -> new SpiderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // squid set
    public static final RegistryObject<Item> COPPER_SQUID_COIN = ITEMS.register("collectible_coin_squid_copper",
            () -> new SquidCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SQUID_COIN = ITEMS.register("collectible_coin_squid_iron",
            () -> new SquidCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SQUID_COIN = ITEMS.register("collectible_coin_squid_gold",
            () -> new SquidCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SQUID_COIN = ITEMS.register("collectible_coin_squid_netherite",
            () -> new SquidCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // strider set
    public static final RegistryObject<Item> COPPER_STRIDER_COIN = ITEMS.register("collectible_coin_strider_copper",
            () -> new StriderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_STRIDER_COIN = ITEMS.register("collectible_coin_strider_iron",
            () -> new StriderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_STRIDER_COIN = ITEMS.register("collectible_coin_strider_gold",
            () -> new StriderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_STRIDER_COIN = ITEMS.register("collectible_coin_strider_netherite",
            () -> new StriderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // tadpole set
    public static final RegistryObject<Item> COPPER_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_copper",
            () -> new TadpoleCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_iron",
            () -> new TadpoleCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_gold",
            () -> new TadpoleCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_netherite",
            () -> new TadpoleCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // trader llama set
    public static final RegistryObject<Item> COPPER_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_copper",
            () -> new LlamaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_iron",
            () -> new LlamaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_gold",
            () -> new LlamaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_netherite",
            () -> new LlamaCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // turtle set
    public static final RegistryObject<Item> COPPER_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_copper",
            () -> new TurtleCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_iron",
            () -> new TurtleCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_gold",
            () -> new TurtleCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_netherite",
            () -> new TurtleCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // villager set
    public static final RegistryObject<Item> COPPER_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_copper",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_iron",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_gold",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_netherite",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // wandering trader set
    public static final RegistryObject<Item> COPPER_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_copper",
            () -> new TraderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_iron",
            () -> new TraderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_gold",
            () -> new TraderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_netherite",
            () -> new TraderCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // wolf set
    public static final RegistryObject<Item> COPPER_WOLF_COIN = ITEMS.register("collectible_coin_wolf_copper",
            () -> new WolfCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_WOLF_COIN = ITEMS.register("collectible_coin_wolf_iron",
            () -> new WolfCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_WOLF_COIN = ITEMS.register("collectible_coin_wolf_gold",
            () -> new WolfCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_WOLF_COIN = ITEMS.register("collectible_coin_wolf_netherite",
            () -> new WolfCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // zombie horse set
    public static final RegistryObject<Item> COPPER_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // zombified piglin set
    public static final RegistryObject<Item> COPPER_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_copper",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_iron",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_gold",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_netherite",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}