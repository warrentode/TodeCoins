package net.warrentode.todecoins.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.warrentode.todecoins.entity.ModEntityTypes;
import net.warrentode.todecoins.item.custom.*;
import net.warrentode.todecoins.item.custom.collectiblecoins.entity.hostile.BlazeCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.entity.neutral.BeeCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.entity.neutral.CaveSpiderCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.entity.neutral.EndermanCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.entity.neutral.PiglinCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.entity.passive.*;
import net.warrentode.todecoins.item.custom.collectiblecoins.gameplay.FishCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.gameplay.HeroCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.holiday.BirthdayCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.holiday.ChristmasCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.holiday.HalloweenCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.patron.year.CarnationPatronCoinItem;
import net.warrentode.todecoins.item.custom.collectiblecoins.patron.year.CosmosPatronCoinItem;
import net.warrentode.todecoins.util.customtabs.ModCreativeModeTabs;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> FOUR_LEAF_CLOVER = ITEMS.register("four_leaf_clover",
            () -> new FourLeafCloverItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> CURRENCY_STAMP = ITEMS.register("currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB).defaultDurability(64).setNoRepair()));
    public static final RegistryObject<Item> NETHER_CURRENCY_STAMP = ITEMS.register("nether_currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB).defaultDurability(64).setNoRepair()));

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_NUGGET = ITEMS.register("lucky_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> IRON_COIN = ITEMS.register("iron_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin", () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_COIN = ITEMS.register("netherite_coin", () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.TODECOINSTAB)));

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
            () -> new ModArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_PANTS = ITEMS.register("lucky_pants",
            () -> new ModArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_SHIRT = ITEMS.register("lucky_shirt",
            () -> new ModArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_HAT = ITEMS.register("lucky_hat",
            () -> new ModArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));

    // SPAWN EGGS
    public static final RegistryObject<ForgeSpawnEggItem> NUMISMATIST_SPAWN_EGG = ITEMS.register("numismatist_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NUMISMATIST, 0xFFDC0A, 0x562300,
                    new Item.Properties().tab(ModCreativeModeTabs.TODECOINSTAB)));

    // COLLECTIBLE COIN SETS
    // holiday collection
    // birthday set
    public static final RegistryObject<Item> BIRTHDAY_COIN_2023 = ITEMS.register("collectible_coin_birthday_2023",
            () -> new BirthdayCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // halloween set
    public static final RegistryObject<Item> HALLOWEEN_COIN_2023 = ITEMS.register("collectible_coin_halloween_2023",
            () -> new HalloweenCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // christmas coin
    public static final RegistryObject<Item> CHRISTMAS_COIN_2023 = ITEMS.register("collectible_coin_christmas_2023",
            () -> new ChristmasCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // patron collection
    // patron carnation anniversary set
    public static final RegistryObject<Item> MARSHALL_NASH_CARNATION_COIN = ITEMS.register("collectible_coin_carnation_marshall_nash",
            () -> new CarnationPatronCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> TREVOR_BRANNIGAN_CARNATION_COIN = ITEMS.register("collectible_coin_carnation_trevor_brannigan",
            () -> new CarnationPatronCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // patron cosmos anniversary set
    public static final RegistryObject<Item> MARSHALL_NASH_COSMOS_COIN = ITEMS.register("collectible_coin_cosmos_marshall_nash",
            () -> new CosmosPatronCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> TREVOR_BRANNIGAN_COSMOS_COIN = ITEMS.register("collectible_coin_cosmos_trevor_brannigan",
            () -> new CosmosPatronCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // gameplay collection
    // cod set
    public static final RegistryObject<Item> COPPER_COD_COIN = ITEMS.register("collectible_coin_cod_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_COD_COIN = ITEMS.register("collectible_coin_cod_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_COD_COIN = ITEMS.register("collectible_coin_cod_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_COD_COIN = ITEMS.register("collectible_coin_cod_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // hero set
    public static final RegistryObject<Item> COPPER_HERO_COIN = ITEMS.register("collectible_coin_hero_copper",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_HERO_COIN = ITEMS.register("collectible_coin_hero_iron",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_HERO_COIN = ITEMS.register("collectible_coin_hero_gold",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_HERO_COIN = ITEMS.register("collectible_coin_hero_netherite",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // pufferfish set
    public static final RegistryObject<Item> COPPER_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // salmon set
    public static final RegistryObject<Item> COPPER_SALMON_COIN = ITEMS.register("collectible_coin_salmon_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SALMON_COIN = ITEMS.register("collectible_coin_salmon_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SALMON_COIN = ITEMS.register("collectible_coin_salmon_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SALMON_COIN = ITEMS.register("collectible_coin_salmon_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // tropical fish set
    public static final RegistryObject<Item> COPPER_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // entity collection
    // allay set
    public static final RegistryObject<Item> COPPER_ALLAY_COIN = ITEMS.register("collectible_coin_allay_copper",
            () -> new AllayCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ALLAY_COIN = ITEMS.register("collectible_coin_allay_iron",
            () -> new AllayCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ALLAY_COIN = ITEMS.register("collectible_coin_allay_gold",
            () -> new AllayCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ALLAY_COIN = ITEMS.register("collectible_coin_allay_netherite",
            () -> new AllayCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // axolotl set
    public static final RegistryObject<Item> COPPER_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_copper",
            () -> new AxolotlCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_iron",
            () -> new AxolotlCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_gold",
            () -> new AxolotlCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_netherite",
            () -> new AxolotlCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // bat set
    public static final RegistryObject<Item> COPPER_BAT_COIN = ITEMS.register("collectible_coin_bat_copper",
            () -> new BatCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_BAT_COIN = ITEMS.register("collectible_coin_bat_iron",
            () -> new BatCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_BAT_COIN = ITEMS.register("collectible_coin_bat_gold",
            () -> new BatCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_BAT_COIN = ITEMS.register("collectible_coin_bat_netherite",
            () -> new BatCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // bee set
    public static final RegistryObject<Item> COPPER_BEE_COIN = ITEMS.register("collectible_coin_bee_copper",
            () -> new BeeCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_BEE_COIN = ITEMS.register("collectible_coin_bee_iron",
            () -> new BeeCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_BEE_COIN = ITEMS.register("collectible_coin_bee_gold",
            () -> new BeeCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_BEE_COIN = ITEMS.register("collectible_coin_bee_netherite",
            () -> new BeeCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // blaze set
    public static final RegistryObject<Item> COPPER_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_copper",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_iron",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_gold",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_netherite",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // camel set
    public static final RegistryObject<Item> COPPER_CAMEL_COIN = ITEMS.register("collectible_coin_camel_copper",
            () -> new CamelCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CAMEL_COIN = ITEMS.register("collectible_coin_camel_iron",
            () -> new CamelCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CAMEL_COIN = ITEMS.register("collectible_coin_camel_gold",
            () -> new CamelCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CAMEL_COIN = ITEMS.register("collectible_coin_camel_netherite",
            () -> new CamelCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // cat set
    public static final RegistryObject<Item> COPPER_CAT_COIN = ITEMS.register("collectible_coin_cat_copper",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CAT_COIN = ITEMS.register("collectible_coin_cat_iron",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CAT_COIN = ITEMS.register("collectible_coin_cat_gold",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CAT_COIN = ITEMS.register("collectible_coin_cat_netherite",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // cave spider set
    public static final RegistryObject<Item> COPPER_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_copper",
            () -> new CaveSpiderCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_iron",
            () -> new CaveSpiderCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_gold",
            () -> new CaveSpiderCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_netherite",
            () -> new CaveSpiderCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // chicken set
    public static final RegistryObject<Item> COPPER_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_copper",
            () -> new ChickenCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_iron",
            () -> new ChickenCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_gold",
            () -> new ChickenCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_netherite",
            () -> new ChickenCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // enderman set
    public static final RegistryObject<Item> COPPER_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_copper",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_iron",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_gold",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_netherite",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // ocelot set
    public static final RegistryObject<Item> COPPER_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_copper",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_iron",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_gold",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_netherite",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    // piglin set
    public static final RegistryObject<Item> COPPER_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_copper",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_iron",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_gold",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_netherite",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTabs.COLLECTORCOINSTAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}