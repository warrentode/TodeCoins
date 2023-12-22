package com.github.warrentode.todecoins.item;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.item.custom.*;
import com.github.warrentode.todecoins.item.custom.armor.LuckyArmorItem;
import com.github.warrentode.todecoins.item.custom.armor.ModArmorMaterials;
import com.github.warrentode.todecoins.item.custom.bracelet.BraceletProperties;
import com.github.warrentode.todecoins.item.custom.bracelet.FriendshipBraceletItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.entity.*;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.gameplay.FishCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.gameplay.HeroCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.holiday.*;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.LifetimePatronCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.year.CarnationPatronCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.year.CosmosPatronCoinItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.patron.year.SunflowerPatronCoinItem;
import com.github.warrentode.todecoins.util.customtabs.CollectibleCoinsTab;
import com.github.warrentode.todecoins.util.customtabs.ModCreativeModeTab;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // TODO learn how to make Item Capabilities work - either with Curios or not - to make a functional wallet for these coins
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TodeCoins.MODID);
    public static final RegistryObject<Item> FOUR_LEAF_CLOVER = ITEMS.register("four_leaf_clover",
            () -> new FourLeafCloverItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> CURRENCY_STAMP = ITEMS.register("currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties().tab(ModCreativeModeTab.TODECOINSTAB).defaultDurability(64).setNoRepair()));
    public static final RegistryObject<Item> NETHER_CURRENCY_STAMP = ITEMS.register("nether_currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties().tab(ModCreativeModeTab.TODECOINSTAB).defaultDurability(64).setNoRepair()));
    public static final RegistryObject<Item> ENDONIAN_CURRENCY_STAMP = ITEMS.register("endonian_currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties().tab(ModCreativeModeTab.TODECOINSTAB).defaultDurability(64).setNoRepair()));

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> ENDONIAN_NUGGET = ITEMS.register("endonian_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> ENDONIAN_INGOT = ITEMS.register("endonian_ingot",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_NUGGET = ITEMS.register("lucky_nugget",
            () -> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> IRON_COIN = ITEMS.register("iron_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_COIN = ITEMS.register("netherite_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> ENDONIAN_COIN = ITEMS.register("endonian_coin",
            () -> new CoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> SERVER_TOKEN_COIN = ITEMS.register("server_token_coin",
            () -> new ServerTokenCoin(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> LUCKY_COIN = ITEMS.register("lucky_coin",
            () -> new LuckyCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> NETHER_GOLD_COIN = ITEMS.register("nether_gold_coin",
            () -> new BarterCoinItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> EMERALD_QUARTER_BANK_NOTE = ITEMS.register("emerald_quarter_bank_note",
            () -> new BankNoteItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> EMERALD_HALF_BANK_NOTE = ITEMS.register("emerald_half_bank_note",
            () -> new BankNoteItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> EMERALD_BANK_NOTE = ITEMS.register("emerald_bank_note",
            () -> new BankNoteItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> EMERALD_FIBER = ITEMS.register("emerald_fiber",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_FIBER = ITEMS.register("lucky_fiber",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> ENDONIAN_FIBER = ITEMS.register("endonian_fiber",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> ECHO_FIBER = ITEMS.register("echo_fiber",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> EMERALD_THREAD = ITEMS.register("emerald_thread",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_THREAD = ITEMS.register("lucky_thread",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> ENDONIAN_THREAD = ITEMS.register("endonian_thread",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> ECHO_THREAD = ITEMS.register("echo_thread",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> EMERALD_COARSE_WOVE_PAPER = ITEMS.register("emerald_coarse_wove_paper",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> EMERALD_WOVE_PAPER = ITEMS.register("emerald_wove_paper",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> EMERALD_SMOOTH_WOVE_PAPER = ITEMS.register("emerald_smooth_wove_paper",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> LUCKY_FABRIC = ITEMS.register("lucky_fabric",
            () -> new TextileItem(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.TODECOINSTAB)));

    public static final RegistryObject<Item> BRACELET_FRIENDSHIP_EMERALD = ITEMS.register("bracelet_friendship_emerald",
            () -> new FriendshipBraceletItem(new Item.Properties()
                    .durability(BraceletProperties.EMERALD.getMaxUses()),
                    BraceletProperties.EMERALD));
    public static final RegistryObject<Item> BRACELET_FRIENDSHIP_ENDONIAN = ITEMS.register("bracelet_friendship_endonian",
            () -> new FriendshipBraceletItem(new Item.Properties()
                    .durability(BraceletProperties.ENDONIAN.getMaxUses()),
                    BraceletProperties.ENDONIAN));
    public static final RegistryObject<Item> BRACELET_FRIENDSHIP_ECHO = ITEMS.register("bracelet_friendship_echo",
            () -> new FriendshipBraceletItem(new Item.Properties()
                    .durability(BraceletProperties.ECHO.getMaxUses()),
                    BraceletProperties.ECHO));
    public static final RegistryObject<Item> BRACELET_FRIENDSHIP_LUCKY = ITEMS.register("bracelet_friendship_lucky",
            () -> new FriendshipBraceletItem(new Item.Properties()
                    .durability(BraceletProperties.LUCKY.getMaxUses()),
                    BraceletProperties.LUCKY));

    public static final RegistryObject<Item> LUCKY_BOOTS = ITEMS.register("lucky_boots",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_PANTS = ITEMS.register("lucky_pants",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_SHIRT = ITEMS.register("lucky_shirt",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> LUCKY_HAT = ITEMS.register("lucky_hat",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.TODECOINSTAB)));

    // SPAWN EGGS
    public static final RegistryObject<ForgeSpawnEggItem> NUMISMATIST_SPAWN_EGG = ITEMS.register("numismatist_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NUMISMATIST, 0xFFDC0A, 0x562300,
                    new Item.Properties().tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SNOW_GOLEM_SPAWN_EGG = ITEMS.register("snow_golem_spawn_egg",
            () -> new ForgeSpawnEggItem(() -> EntityType.SNOW_GOLEM, 0xFFFFFF, 0x00FFFF,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> ILLUSIONER_SPAWN_EGG = ITEMS.register("illusioner_spawn_egg",
            () -> new ForgeSpawnEggItem(() -> EntityType.ILLUSIONER, 0x6495ED, 0xFFFFFF,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> GIANT_SPAWN_EGG = ITEMS.register("giant_spawn_egg",
            () -> new ForgeSpawnEggItem(() -> EntityType.GIANT, 7969893, 44975,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    // CANDY COINS FOR HOLIDAY EVENTS
    public static final RegistryObject<Item> CRIMSON_SPORE_CHOCOLATE_COIN = ITEMS.register("chocolate_coin_crimson_spore",
            () -> new Item(new Item.Properties().food(ModFoods.CRIMSON_SPORE_CHOCOLATE_COIN).tab(CreativeModeTab.TAB_FOOD)
                    .tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> WARPED_SPICE_CHOCOLATE_COIN = ITEMS.register("chocolate_coin_warped_spice",
            () -> new Item(new Item.Properties().food(ModFoods.WARPED_SPICE_CHOCOLATE_COIN).tab(CreativeModeTab.TAB_FOOD)
                    .tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> MILK_BONE_CHOCOLATE_COIN = ITEMS.register("chocolate_coin_milk_bone",
            () -> new Item(new Item.Properties().food(ModFoods.MILK_BONE_CHOCOLATE_COIN).tab(CreativeModeTab.TAB_FOOD)
                    .tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> ULTIMATE_DARK_CHOCOLATE_COIN = ITEMS.register("chocolate_coin_ultimate_dark",
            () -> new Item(new Item.Properties().food(ModFoods.ULTIMATE_DARK_CHOCOLATE_COIN).tab(CreativeModeTab.TAB_FOOD)
                    .tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> BUBBLY_BERRY_CHOCOLATE_COIN = ITEMS.register("chocolate_coin_bubbly_berry",
            () -> new Item(new Item.Properties().food(ModFoods.BUBBLY_BERRY_CHOCOLATE_COIN).tab(CreativeModeTab.TAB_FOOD)
                    .tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> VELVETY_CLOVER_CHOCOLATE_COIN = ITEMS.register("chocolate_coin_velvety_clover",
            () -> new Item(new Item.Properties().food(ModFoods.VELVETY_CLOVER_CHOCOLATE_COIN).tab(CreativeModeTab.TAB_FOOD)
                    .tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> FESTIVE_FUDGE_CHOCOLATE_COIN = ITEMS.register("chocolate_coin_festive_fudge",
            () -> new Item(new Item.Properties().food(ModFoods.FESTIVE_FUDGE_CHOCOLATE_COIN).tab(CreativeModeTab.TAB_FOOD)
                    .tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> FUEGO_FUDGE_CHOCOLATE_COIN = ITEMS.register("chocolate_coin_fuego_fudge",
            () -> new Item(new Item.Properties().food(ModFoods.FUEGO_FUDGE_CHOCOLATE_COIN).tab(CreativeModeTab.TAB_FOOD)
                    .tab(ModCreativeModeTab.TODECOINSTAB)));
    public static final RegistryObject<Item> CARMEL_CRISP_CHOCOLATE_COIN = ITEMS.register("chocolate_coin_carmel_crisp",
            () -> new Item(new Item.Properties().food(ModFoods.CARMEL_CRISP_CHOCOLATE_COIN).tab(CreativeModeTab.TAB_FOOD)
                    .tab(ModCreativeModeTab.TODECOINSTAB)));

    // COLLECTIBLE COIN SETS
    // holiday collection
    public static final RegistryObject<Item> BIRTHDAY_COIN = ITEMS.register("collectible_coin_birthday",
            () -> new BirthdayCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> HALLOWEEN_COIN = ITEMS.register("collectible_coin_halloween",
            () -> new HalloweenCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> CHRISTMAS_COIN = ITEMS.register("collectible_coin_christmas",
            () -> new ChristmasCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> EASTER_COIN = ITEMS.register("collectible_coin_easter",
            () -> new EasterCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NEW_YEAR_COIN = ITEMS.register("collectible_coin_new_year",
            () -> new NewYearCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // patron collection
    // patron lifetime anniversary set
    public static final RegistryObject<Item> SCHOLAR_OWL_COIN = ITEMS.register("collectible_coin_scholar_owl",
            () -> new LifetimePatronCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> TUXEDO_CAT_COIN = ITEMS.register("collectible_coin_tuxedo_cat",
            () -> new LifetimePatronCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> LITTLE_BEAR_COIN = ITEMS.register("collectible_coin_little_bear",
            () -> new LifetimePatronCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // patron marshall nash anniversary set
    public static final RegistryObject<Item> MARSHALL_NASH_CARNATION_COIN = ITEMS.register("collectible_coin_carnation_marshall_nash",
            () -> new CarnationPatronCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> MARSHALL_NASH_COSMOS_COIN = ITEMS.register("collectible_coin_cosmos_marshall_nash",
            () -> new CosmosPatronCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> MARSHALL_NASH_SUNFLOWER_COIN = ITEMS.register("collectible_coin_sunflower_marshall_nash",
            () -> new SunflowerPatronCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // patron trevor brannigan anniversary set
    public static final RegistryObject<Item> TREVOR_BRANNIGAN_CARNATION_COIN = ITEMS.register("collectible_coin_carnation_trevor_brannigan",
            () -> new CarnationPatronCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> TREVOR_BRANNIGAN_COSMOS_COIN = ITEMS.register("collectible_coin_cosmos_trevor_brannigan",
            () -> new CosmosPatronCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // gameplay collection
    // cod set
    public static final RegistryObject<Item> COPPER_COD_COIN = ITEMS.register("collectible_coin_cod_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_COD_COIN = ITEMS.register("collectible_coin_cod_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_COD_COIN = ITEMS.register("collectible_coin_cod_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_COD_COIN = ITEMS.register("collectible_coin_cod_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // hero set
    public static final RegistryObject<Item> COPPER_HERO_COIN = ITEMS.register("collectible_coin_hero_copper",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_HERO_COIN = ITEMS.register("collectible_coin_hero_iron",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_HERO_COIN = ITEMS.register("collectible_coin_hero_gold",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_HERO_COIN = ITEMS.register("collectible_coin_hero_netherite",
            () -> new HeroCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // pufferfish set
    public static final RegistryObject<Item> COPPER_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // salmon set
    public static final RegistryObject<Item> COPPER_SALMON_COIN = ITEMS.register("collectible_coin_salmon_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SALMON_COIN = ITEMS.register("collectible_coin_salmon_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SALMON_COIN = ITEMS.register("collectible_coin_salmon_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SALMON_COIN = ITEMS.register("collectible_coin_salmon_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // tropical fish set
    public static final RegistryObject<Item> COPPER_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_copper",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_iron",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_gold",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_netherite",
            () -> new FishCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // entity collection
    // allay set
    public static final RegistryObject<Item> COPPER_ALLAY_COIN = ITEMS.register("collectible_coin_allay_copper",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ALLAY_COIN = ITEMS.register("collectible_coin_allay_iron",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ALLAY_COIN = ITEMS.register("collectible_coin_allay_gold",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ALLAY_COIN = ITEMS.register("collectible_coin_allay_netherite",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // axolotl set
    public static final RegistryObject<Item> COPPER_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_copper",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_iron",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_gold",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_netherite",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // bat set
    public static final RegistryObject<Item> COPPER_BAT_COIN = ITEMS.register("collectible_coin_bat_copper",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_BAT_COIN = ITEMS.register("collectible_coin_bat_iron",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_BAT_COIN = ITEMS.register("collectible_coin_bat_gold",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_BAT_COIN = ITEMS.register("collectible_coin_bat_netherite",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // bee set
    public static final RegistryObject<Item> COPPER_BEE_COIN = ITEMS.register("collectible_coin_bee_copper",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_BEE_COIN = ITEMS.register("collectible_coin_bee_iron",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_BEE_COIN = ITEMS.register("collectible_coin_bee_gold",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_BEE_COIN = ITEMS.register("collectible_coin_bee_netherite",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // blaze set
    public static final RegistryObject<Item> COPPER_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_copper",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_iron",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_gold",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_netherite",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // camel set
    public static final RegistryObject<Item> COPPER_CAMEL_COIN = ITEMS.register("collectible_coin_camel_copper",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CAMEL_COIN = ITEMS.register("collectible_coin_camel_iron",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CAMEL_COIN = ITEMS.register("collectible_coin_camel_gold",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CAMEL_COIN = ITEMS.register("collectible_coin_camel_netherite",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // cat set
    public static final RegistryObject<Item> COPPER_CAT_COIN = ITEMS.register("collectible_coin_cat_copper",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CAT_COIN = ITEMS.register("collectible_coin_cat_iron",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CAT_COIN = ITEMS.register("collectible_coin_cat_gold",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CAT_COIN = ITEMS.register("collectible_coin_cat_netherite",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // cave spider set
    public static final RegistryObject<Item> COPPER_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_copper",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_iron",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_gold",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_netherite",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // chicken set
    public static final RegistryObject<Item> COPPER_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_copper",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_iron",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_gold",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_netherite",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // cow set
    public static final RegistryObject<Item> COPPER_COW_COIN = ITEMS.register("collectible_coin_cow_copper",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_COW_COIN = ITEMS.register("collectible_coin_cow_iron",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_COW_COIN = ITEMS.register("collectible_coin_cow_gold",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_COW_COIN = ITEMS.register("collectible_coin_cow_netherite",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // creeper set
    public static final RegistryObject<Item> COPPER_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_copper",
            () -> new CreeperCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_iron",
            () -> new CreeperCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_gold",
            () -> new CreeperCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_netherite",
            () -> new CreeperCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // dolphin set
    public static final RegistryObject<Item> COPPER_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_copper",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_iron",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_gold",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_netherite",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // donkey set
    public static final RegistryObject<Item> COPPER_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // drowned set
    public static final RegistryObject<Item> COPPER_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_copper",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_iron",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_gold",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_netherite",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // elder guardian set
    public static final RegistryObject<Item> COPPER_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_copper",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_iron",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_gold",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_netherite",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // ender dragon set
    public static final RegistryObject<Item> COPPER_ENDER_DRAGON_COIN = ITEMS.register("collectible_coin_ender_dragon_copper",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ENDER_DRAGON_COIN = ITEMS.register("collectible_coin_ender_dragon_iron",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ENDER_DRAGON_COIN = ITEMS.register("collectible_coin_ender_dragon_gold",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ENDER_DRAGON_COIN = ITEMS.register("collectible_coin_ender_dragon_netherite",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // enderman set
    public static final RegistryObject<Item> COPPER_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_copper",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_iron",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_gold",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_netherite",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // endermite set
    public static final RegistryObject<Item> COPPER_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_copper",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_iron",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_gold",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_netherite",
            () -> new EndermanCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // evoker set
    public static final RegistryObject<Item> COPPER_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_copper",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_iron",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_gold",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_netherite",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // fox set
    public static final RegistryObject<Item> COPPER_FOX_COIN = ITEMS.register("collectible_coin_fox_copper",
            () -> new CanineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_FOX_COIN = ITEMS.register("collectible_coin_fox_iron",
            () -> new CanineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_FOX_COIN = ITEMS.register("collectible_coin_fox_gold",
            () -> new CanineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_FOX_COIN = ITEMS.register("collectible_coin_fox_netherite",
            () -> new CanineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // frog set
    public static final RegistryObject<Item> COPPER_FROG_COIN = ITEMS.register("collectible_coin_frog_copper",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_FROG_COIN = ITEMS.register("collectible_coin_frog_iron",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_FROG_COIN = ITEMS.register("collectible_coin_frog_gold",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_FROG_COIN = ITEMS.register("collectible_coin_frog_netherite",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // giant set
    public static final RegistryObject<Item> COPPER_GIANT_COIN = ITEMS.register("collectible_coin_giant_copper",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GIANT_COIN = ITEMS.register("collectible_coin_giant_iron",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GIANT_COIN = ITEMS.register("collectible_coin_giant_gold",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GIANT_COIN = ITEMS.register("collectible_coin_giant_netherite",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // glow squid set
    public static final RegistryObject<Item> COPPER_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_copper",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_iron",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_gold",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_netherite",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // goat set
    public static final RegistryObject<Item> COPPER_GOAT_COIN = ITEMS.register("collectible_coin_goat_copper",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GOAT_COIN = ITEMS.register("collectible_coin_goat_iron",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GOAT_COIN = ITEMS.register("collectible_coin_goat_gold",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GOAT_COIN = ITEMS.register("collectible_coin_goat_netherite",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // guardian set
    public static final RegistryObject<Item> COPPER_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_copper",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_iron",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_gold",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_netherite",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // ghast set
    public static final RegistryObject<Item> COPPER_GHAST_COIN = ITEMS.register("collectible_coin_ghast_copper",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GHAST_COIN = ITEMS.register("collectible_coin_ghast_iron",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GHAST_COIN = ITEMS.register("collectible_coin_ghast_gold",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GHAST_COIN = ITEMS.register("collectible_coin_ghast_netherite",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // hoglin set
    public static final RegistryObject<Item> COPPER_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_copper",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_iron",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_gold",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_netherite",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // horse set
    public static final RegistryObject<Item> COPPER_HORSE_COIN = ITEMS.register("collectible_coin_horse_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_HORSE_COIN = ITEMS.register("collectible_coin_horse_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_HORSE_COIN = ITEMS.register("collectible_coin_horse_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_HORSE_COIN = ITEMS.register("collectible_coin_horse_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // husk set
    public static final RegistryObject<Item> COPPER_HUSK_COIN = ITEMS.register("collectible_coin_husk_copper",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_HUSK_COIN = ITEMS.register("collectible_coin_husk_iron",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_HUSK_COIN = ITEMS.register("collectible_coin_husk_gold",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_HUSK_COIN = ITEMS.register("collectible_coin_husk_netherite",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // iron golem set
    public static final RegistryObject<Item> COPPER_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_copper",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_iron",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_gold",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_netherite",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // illusioner set
    public static final RegistryObject<Item> COPPER_ILLUSIONER_COIN = ITEMS.register("collectible_coin_illusioner_copper",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ILLUSIONER_COIN = ITEMS.register("collectible_coin_illusioner_iron",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ILLUSIONER_COIN = ITEMS.register("collectible_coin_illusioner_gold",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ILLUSIONER_COIN = ITEMS.register("collectible_coin_illusioner_netherite",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // llama set
    public static final RegistryObject<Item> COPPER_LLAMA_COIN = ITEMS.register("collectible_coin_llama_copper",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_LLAMA_COIN = ITEMS.register("collectible_coin_llama_iron",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_LLAMA_COIN = ITEMS.register("collectible_coin_llama_gold",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_LLAMA_COIN = ITEMS.register("collectible_coin_llama_netherite",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // magma cube set
    public static final RegistryObject<Item> COPPER_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_copper",
            () -> new CubeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_iron",
            () -> new CubeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_gold",
            () -> new CubeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_netherite",
            () -> new CubeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // mooshroom set
    public static final RegistryObject<Item> COPPER_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_copper",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_iron",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_gold",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_netherite",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // mule set
    public static final RegistryObject<Item> COPPER_MULE_COIN = ITEMS.register("collectible_coin_mule_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_MULE_COIN = ITEMS.register("collectible_coin_mule_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_MULE_COIN = ITEMS.register("collectible_coin_mule_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_MULE_COIN = ITEMS.register("collectible_coin_mule_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // numismatist set
    public static final RegistryObject<Item> COPPER_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_copper",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_iron",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_gold",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_netherite",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // ocelot set
    public static final RegistryObject<Item> COPPER_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_copper",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_iron",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_gold",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_netherite",
            () -> new FelineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // panda set
    public static final RegistryObject<Item> COPPER_PANDA_COIN = ITEMS.register("collectible_coin_panda_copper",
            () -> new BearCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PANDA_COIN = ITEMS.register("collectible_coin_panda_iron",
            () -> new BearCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PANDA_COIN = ITEMS.register("collectible_coin_panda_gold",
            () -> new BearCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PANDA_COIN = ITEMS.register("collectible_coin_panda_netherite",
            () -> new BearCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // parrot set
    public static final RegistryObject<Item> COPPER_PARROT_COIN = ITEMS.register("collectible_coin_parrot_copper",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PARROT_COIN = ITEMS.register("collectible_coin_parrot_iron",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PARROT_COIN = ITEMS.register("collectible_coin_parrot_gold",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PARROT_COIN = ITEMS.register("collectible_coin_parrot_netherite",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // phantom set
    public static final RegistryObject<Item> COPPER_PHANTOM_COIN = ITEMS.register("collectible_coin_phantom_copper",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PHANTOM_COIN = ITEMS.register("collectible_coin_phantom_iron",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PHANTOM_COIN = ITEMS.register("collectible_coin_phantom_gold",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PHANTOM_COIN = ITEMS.register("collectible_coin_phantom_netherite",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // pig set
    public static final RegistryObject<Item> COPPER_PIG_COIN = ITEMS.register("collectible_coin_pig_copper",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PIG_COIN = ITEMS.register("collectible_coin_pig_iron",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PIG_COIN = ITEMS.register("collectible_coin_pig_gold",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PIG_COIN = ITEMS.register("collectible_coin_pig_netherite",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // piglin merchant set
    public static final RegistryObject<Item> COPPER_PIGLIN_MERCHANT_COIN = ITEMS.register("collectible_coin_piglin_merchant_copper",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PIGLIN_MERCHANT_COIN = ITEMS.register("collectible_coin_piglin_merchant_iron",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PIGLIN_MERCHANT_COIN = ITEMS.register("collectible_coin_piglin_merchant_gold",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PIGLIN_MERCHANT_COIN = ITEMS.register("collectible_coin_piglin_merchant_netherite",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // piglin brute set
    public static final RegistryObject<Item> COPPER_PIGLIN_BRUTE_COIN = ITEMS.register("collectible_coin_piglin_brute_copper",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PIGLIN_BRUTE_COIN = ITEMS.register("collectible_coin_piglin_brute_iron",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PIGLIN_BRUTE_COIN = ITEMS.register("collectible_coin_piglin_brute_gold",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PIGLIN_BRUTE_COIN = ITEMS.register("collectible_coin_piglin_brute_netherite",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // piglin set
    public static final RegistryObject<Item> COPPER_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_copper",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_iron",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_gold",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_netherite",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // pillager set
    public static final RegistryObject<Item> COPPER_PILLAGER_COIN = ITEMS.register("collectible_coin_pillager_copper",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PILLAGER_COIN = ITEMS.register("collectible_coin_pillager_iron",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PILLAGER_COIN = ITEMS.register("collectible_coin_pillager_gold",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PILLAGER_COIN = ITEMS.register("collectible_coin_pillager_netherite",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // polar bear set
    public static final RegistryObject<Item> COPPER_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_copper",
            () -> new BearCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_iron",
            () -> new BearCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_gold",
            () -> new BearCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_netherite",
            () -> new BearCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // rabbit set
    public static final RegistryObject<Item> COPPER_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_copper",
            () -> new RabbitCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_iron",
            () -> new RabbitCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_gold",
            () -> new RabbitCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_netherite",
            () -> new RabbitCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // ravager set
    public static final RegistryObject<Item> COPPER_RAVAGER_COIN = ITEMS.register("collectible_coin_ravager_copper",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_RAVAGER_COIN = ITEMS.register("collectible_coin_ravager_iron",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_RAVAGER_COIN = ITEMS.register("collectible_coin_ravager_gold",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_RAVAGER_COIN = ITEMS.register("collectible_coin_ravager_netherite",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // sheep set
    public static final RegistryObject<Item> COPPER_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_copper",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_iron",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_gold",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_netherite",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // shulker set
    public static final RegistryObject<Item> COPPER_SHULKER_COIN = ITEMS.register("collectible_coin_shulker_copper",
            () -> new ShulkerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SHULKER_COIN = ITEMS.register("collectible_coin_shulker_iron",
            () -> new ShulkerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SHULKER_COIN = ITEMS.register("collectible_coin_shulker_gold",
            () -> new ShulkerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SHULKER_COIN = ITEMS.register("collectible_coin_shulker_netherite",
            () -> new ShulkerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // silverfish set
    public static final RegistryObject<Item> COPPER_SILVERFISH_COIN = ITEMS.register("collectible_coin_silverfish_copper",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SILVERFISH_COIN = ITEMS.register("collectible_coin_silverfish_iron",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SILVERFISH_COIN = ITEMS.register("collectible_coin_silverfish_gold",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SILVERFISH_COIN = ITEMS.register("collectible_coin_silverfish_netherite",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // skeleton set
    public static final RegistryObject<Item> COPPER_SKELETON_COIN = ITEMS.register("collectible_coin_skeleton_copper",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SKELETON_COIN = ITEMS.register("collectible_coin_skeleton_iron",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SKELETON_COIN = ITEMS.register("collectible_coin_skeleton_gold",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SKELETON_COIN = ITEMS.register("collectible_coin_skeleton_netherite",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // skeleton horse set
    public static final RegistryObject<Item> COPPER_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // slime set
    public static final RegistryObject<Item> COPPER_SLIME_COIN = ITEMS.register("collectible_coin_slime_copper",
            () -> new CubeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SLIME_COIN = ITEMS.register("collectible_coin_slime_iron",
            () -> new CubeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SLIME_COIN = ITEMS.register("collectible_coin_slime_gold",
            () -> new CubeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SLIME_COIN = ITEMS.register("collectible_coin_slime_netherite",
            () -> new CubeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // sniffer set
    public static final RegistryObject<Item> COPPER_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_copper",
            () -> new SnifferCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_iron",
            () -> new SnifferCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_gold",
            () -> new SnifferCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_netherite",
            () -> new SnifferCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // armadillo set
    public static final RegistryObject<Item> COPPER_ARMADILLO_COIN = ITEMS.register("collectible_coin_armadillo_copper",
            () -> new ArmadilloCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ARMADILLO_COIN = ITEMS.register("collectible_coin_armadillo_iron",
            () -> new ArmadilloCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ARMADILLO_COIN = ITEMS.register("collectible_coin_armadillo_gold",
            () -> new ArmadilloCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ARMADILLO_COIN = ITEMS.register("collectible_coin_armadillo_netherite",
            () -> new ArmadilloCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // snow golem set
    public static final RegistryObject<Item> COPPER_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_copper",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_iron",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_gold",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_netherite",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // spider set
    public static final RegistryObject<Item> COPPER_SPIDER_COIN = ITEMS.register("collectible_coin_spider_copper",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SPIDER_COIN = ITEMS.register("collectible_coin_spider_iron",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SPIDER_COIN = ITEMS.register("collectible_coin_spider_gold",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SPIDER_COIN = ITEMS.register("collectible_coin_spider_netherite",
            () -> new ArthropodCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // squid set
    public static final RegistryObject<Item> COPPER_SQUID_COIN = ITEMS.register("collectible_coin_squid_copper",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SQUID_COIN = ITEMS.register("collectible_coin_squid_iron",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SQUID_COIN = ITEMS.register("collectible_coin_squid_gold",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SQUID_COIN = ITEMS.register("collectible_coin_squid_netherite",
            () -> new AquaticCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // stray set
    public static final RegistryObject<Item> COPPER_STRAY_COIN = ITEMS.register("collectible_coin_stray_copper",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_STRAY_COIN = ITEMS.register("collectible_coin_stray_iron",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_STRAY_COIN = ITEMS.register("collectible_coin_stray_gold",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_STRAY_COIN = ITEMS.register("collectible_coin_stray_netherite",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // strider set
    public static final RegistryObject<Item> COPPER_STRIDER_COIN = ITEMS.register("collectible_coin_strider_copper",
            () -> new StriderCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_STRIDER_COIN = ITEMS.register("collectible_coin_strider_iron",
            () -> new StriderCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_STRIDER_COIN = ITEMS.register("collectible_coin_strider_gold",
            () -> new StriderCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_STRIDER_COIN = ITEMS.register("collectible_coin_strider_netherite",
            () -> new StriderCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // tadpole set
    public static final RegistryObject<Item> COPPER_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_copper",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_iron",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_gold",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_netherite",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // trader llama set
    public static final RegistryObject<Item> COPPER_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_copper",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_iron",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_gold",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_netherite",
            () -> new CamelidCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // turtle set
    public static final RegistryObject<Item> COPPER_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_copper",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_iron",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_gold",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_netherite",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // vex set
    public static final RegistryObject<Item> COPPER_VEX_COIN = ITEMS.register("collectible_coin_vex_copper",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_VEX_COIN = ITEMS.register("collectible_coin_vex_iron",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_VEX_COIN = ITEMS.register("collectible_coin_vex_gold",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_VEX_COIN = ITEMS.register("collectible_coin_vex_netherite",
            () -> new AerialCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // villager set
    public static final RegistryObject<Item> COPPER_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_copper",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_iron",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_gold",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_netherite",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // vindicator set
    public static final RegistryObject<Item> COPPER_VINDICATOR_COIN = ITEMS.register("collectible_coin_vindicator_copper",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_VINDICATOR_COIN = ITEMS.register("collectible_coin_vindicator_iron",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_VINDICATOR_COIN = ITEMS.register("collectible_coin_vindicator_gold",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_VINDICATOR_COIN = ITEMS.register("collectible_coin_vindicator_netherite",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // wandering trader set
    public static final RegistryObject<Item> COPPER_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_copper",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_iron",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_gold",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_netherite",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // warden set
    public static final RegistryObject<Item> COPPER_WARDEN_COIN = ITEMS.register("collectible_coin_warden_copper",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_WARDEN_COIN = ITEMS.register("collectible_coin_warden_iron",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_WARDEN_COIN = ITEMS.register("collectible_coin_warden_gold",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_WARDEN_COIN = ITEMS.register("collectible_coin_warden_netherite",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // witch set
    public static final RegistryObject<Item> COPPER_WITCH_COIN = ITEMS.register("collectible_coin_witch_copper",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_WITCH_COIN = ITEMS.register("collectible_coin_witch_iron",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_WITCH_COIN = ITEMS.register("collectible_coin_witch_gold",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_WITCH_COIN = ITEMS.register("collectible_coin_witch_netherite",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // wither set
    public static final RegistryObject<Item> COPPER_WITHER_COIN = ITEMS.register("collectible_coin_wither_copper",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_WITHER_COIN = ITEMS.register("collectible_coin_wither_iron",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_WITHER_COIN = ITEMS.register("collectible_coin_wither_gold",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_WITHER_COIN = ITEMS.register("collectible_coin_wither_netherite",
            () -> new BossCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // wither_skeleton set
    public static final RegistryObject<Item> COPPER_WITHER_SKELETON_COIN = ITEMS.register("collectible_coin_wither_skeleton_copper",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_WITHER_SKELETON_COIN = ITEMS.register("collectible_coin_wither_skeleton_iron",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_WITHER_SKELETON_COIN = ITEMS.register("collectible_coin_wither_skeleton_gold",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_WITHER_SKELETON_COIN = ITEMS.register("collectible_coin_wither_skeleton_netherite",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // wolf set
    public static final RegistryObject<Item> COPPER_WOLF_COIN = ITEMS.register("collectible_coin_wolf_copper",
            () -> new CanineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_WOLF_COIN = ITEMS.register("collectible_coin_wolf_iron",
            () -> new CanineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_WOLF_COIN = ITEMS.register("collectible_coin_wolf_gold",
            () -> new CanineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_WOLF_COIN = ITEMS.register("collectible_coin_wolf_netherite",
            () -> new CanineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // zoglin set
    public static final RegistryObject<Item> COPPER_ZOGLIN_COIN = ITEMS.register("collectible_coin_zoglin_copper",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ZOGLIN_COIN = ITEMS.register("collectible_coin_zoglin_iron",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ZOGLIN_COIN = ITEMS.register("collectible_coin_zoglin_gold",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ZOGLIN_COIN = ITEMS.register("collectible_coin_zoglin_netherite",
            () -> new SwineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // zombie set
    public static final RegistryObject<Item> COPPER_ZOMBIE_COIN = ITEMS.register("collectible_coin_zombie_copper",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ZOMBIE_COIN = ITEMS.register("collectible_coin_zombie_iron",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ZOMBIE_COIN = ITEMS.register("collectible_coin_zombie_gold",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ZOMBIE_COIN = ITEMS.register("collectible_coin_zombie_netherite",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // zombie horse set
    public static final RegistryObject<Item> COPPER_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_copper",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_iron",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_gold",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_netherite",
            () -> new EquineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // zombie villager set
    public static final RegistryObject<Item> COPPER_ZOMBIE_VILLAGER_COIN = ITEMS.register("collectible_coin_zombie_villager_copper",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ZOMBIE_VILLAGER_COIN = ITEMS.register("collectible_coin_zombie_villager_iron",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ZOMBIE_VILLAGER_COIN = ITEMS.register("collectible_coin_zombie_villager_gold",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ZOMBIE_VILLAGER_COIN = ITEMS.register("collectible_coin_zombie_villager_netherite",
            () -> new UndeadCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // zombified piglin set
    public static final RegistryObject<Item> COPPER_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_copper",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_iron",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_gold",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_netherite",
            () -> new PiglinCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));

    // friends and foes
    // moobloom set
    public static final RegistryObject<Item> COPPER_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_copper",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_iron",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_gold",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_netherite",
            () -> new BovineCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // copper golem set
    public static final RegistryObject<Item> COPPER_COPPER_GOLEM_COIN = ITEMS.register("collectible_coin_copper_golem_copper",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_COPPER_GOLEM_COIN = ITEMS.register("collectible_coin_copper_golem_iron",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_COPPER_GOLEM_COIN = ITEMS.register("collectible_coin_copper_golem_gold",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_COPPER_GOLEM_COIN = ITEMS.register("collectible_coin_copper_golem_netherite",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // glare set
    public static final RegistryObject<Item> COPPER_GLARE_COIN = ITEMS.register("collectible_coin_glare_copper",
            () -> new GlareCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GLARE_COIN = ITEMS.register("collectible_coin_glare_iron",
            () -> new GlareCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GLARE_COIN = ITEMS.register("collectible_coin_glare_gold",
            () -> new GlareCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GLARE_COIN = ITEMS.register("collectible_coin_glare_netherite",
            () -> new GlareCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // iceologer set
    public static final RegistryObject<Item> COPPER_ICEOLOGER_COIN = ITEMS.register("collectible_coin_iceologer_copper",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_ICEOLOGER_COIN = ITEMS.register("collectible_coin_iceologer_iron",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_ICEOLOGER_COIN = ITEMS.register("collectible_coin_iceologer_gold",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_ICEOLOGER_COIN = ITEMS.register("collectible_coin_iceologer_netherite",
            () -> new IllagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // mauler set
    public static final RegistryObject<Item> COPPER_MAULER_COIN = ITEMS.register("collectible_coin_mauler_copper",
            () -> new MaulerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_MAULER_COIN = ITEMS.register("collectible_coin_mauler_iron",
            () -> new MaulerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_MAULER_COIN = ITEMS.register("collectible_coin_mauler_gold",
            () -> new MaulerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_MAULER_COIN = ITEMS.register("collectible_coin_mauler_netherite",
            () -> new MaulerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // tuff_golem set
    public static final RegistryObject<Item> COPPER_TUFF_GOLEM_COIN = ITEMS.register("collectible_coin_tuff_golem_copper",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_TUFF_GOLEM_COIN = ITEMS.register("collectible_coin_tuff_golem_iron",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_TUFF_GOLEM_COIN = ITEMS.register("collectible_coin_tuff_golem_gold",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_TUFF_GOLEM_COIN = ITEMS.register("collectible_coin_tuff_golem_netherite",
            () -> new GolemCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // wildfire set
    public static final RegistryObject<Item> COPPER_WILDFIRE_COIN = ITEMS.register("collectible_coin_wildfire_copper",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_WILDFIRE_COIN = ITEMS.register("collectible_coin_wildfire_iron",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_WILDFIRE_COIN = ITEMS.register("collectible_coin_wildfire_gold",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_WILDFIRE_COIN = ITEMS.register("collectible_coin_wildfire_netherite",
            () -> new BlazeCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // rascal set
    public static final RegistryObject<Item> COPPER_RASCAL_COIN = ITEMS.register("collectible_coin_rascal_copper",
            () -> new RascalCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_RASCAL_COIN = ITEMS.register("collectible_coin_rascal_iron",
            () -> new RascalCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_RASCAL_COIN = ITEMS.register("collectible_coin_rascal_gold",
            () -> new RascalCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_RASCAL_COIN = ITEMS.register("collectible_coin_rascal_netherite",
            () -> new RascalCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));

    // ecologics
    // crab set
    public static final RegistryObject<Item> COPPER_CRAB_COIN = ITEMS.register("collectible_coin_crab_copper",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_CRAB_COIN = ITEMS.register("collectible_coin_crab_iron",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_CRAB_COIN = ITEMS.register("collectible_coin_crab_gold",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_CRAB_COIN = ITEMS.register("collectible_coin_crab_netherite",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // squirrel set
    public static final RegistryObject<Item> COPPER_SQUIRREL_COIN = ITEMS.register("collectible_coin_squirrel_copper",
            () -> new RodentCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_SQUIRREL_COIN = ITEMS.register("collectible_coin_squirrel_iron",
            () -> new RodentCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_SQUIRREL_COIN = ITEMS.register("collectible_coin_squirrel_gold",
            () -> new RodentCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_SQUIRREL_COIN = ITEMS.register("collectible_coin_squirrel_netherite",
            () -> new RodentCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    // penguin set
    public static final RegistryObject<Item> COPPER_PENGUIN_COIN = ITEMS.register("collectible_coin_penguin_copper",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_PENGUIN_COIN = ITEMS.register("collectible_coin_penguin_iron",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_PENGUIN_COIN = ITEMS.register("collectible_coin_penguin_gold",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_PENGUIN_COIN = ITEMS.register("collectible_coin_penguin_netherite",
            () -> new AmphibianCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));

    // guard villagers
    // guard set
    public static final RegistryObject<Item> COPPER_GUARD_COIN = ITEMS.register("collectible_coin_guard_copper",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> IRON_GUARD_COIN = ITEMS.register("collectible_coin_guard_iron",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> GOLD_GUARD_COIN = ITEMS.register("collectible_coin_guard_gold",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));
    public static final RegistryObject<Item> NETHERITE_GUARD_COIN = ITEMS.register("collectible_coin_guard_netherite",
            () -> new VillagerCoinItem(new Item.Properties().stacksTo(1).tab(CollectibleCoinsTab.COLLECTORCOINSTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}