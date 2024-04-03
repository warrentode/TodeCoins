package com.github.warrentode.todecoins.item;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.item.custom.*;
import com.github.warrentode.todecoins.item.custom.armor.LuckyArmorItem;
import com.github.warrentode.todecoins.item.custom.armor.ModArmorMaterials;
import com.github.warrentode.todecoins.item.custom.bracelet.BraceletProperties;
import com.github.warrentode.todecoins.item.custom.bracelet.FriendshipBraceletItem;
import com.github.warrentode.todecoins.item.custom.collectiblecoins.CollectibleCoinProperties;
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
            () -> new BirthdayCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    public static final RegistryObject<Item> CHRISTMAS_COIN = ITEMS.register("collectible_coin_christmas",
            () -> new ChristmasCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    public static final RegistryObject<Item> HALLOWEEN_COIN = ITEMS.register("collectible_coin_halloween",
            () -> new HalloweenCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    public static final RegistryObject<Item> EASTER_COIN = ITEMS.register("collectible_coin_easter",
            () -> new EasterCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    public static final RegistryObject<Item> NEW_YEAR_COIN = ITEMS.register("collectible_coin_new_year",
            () -> new NewYearCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    // patron collection
    // patron lifetime anniversary set
    public static final RegistryObject<Item> SCHOLAR_OWL_COIN = ITEMS.register("collectible_coin_scholar_owl",
            () -> new LifetimePatronCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    public static final RegistryObject<Item> TUXEDO_CAT_COIN = ITEMS.register("collectible_coin_tuxedo_cat",
            () -> new LifetimePatronCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    public static final RegistryObject<Item> LITTLE_BEAR_COIN = ITEMS.register("collectible_coin_little_bear",
            () -> new LifetimePatronCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    // patron marshall nash anniversary set
    public static final RegistryObject<Item> MARSHALL_NASH_CARNATION_COIN = ITEMS.register("collectible_coin_carnation_marshall_nash",
            () -> new CarnationPatronCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    public static final RegistryObject<Item> MARSHALL_NASH_COSMOS_COIN = ITEMS.register("collectible_coin_cosmos_marshall_nash",
            () -> new CosmosPatronCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    public static final RegistryObject<Item> MARSHALL_NASH_SUNFLOWER_COIN = ITEMS.register("collectible_coin_sunflower_marshall_nash",
            () -> new SunflowerPatronCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    // patron trevor brannigan anniversary set
    public static final RegistryObject<Item> TREVOR_BRANNIGAN_CARNATION_COIN = ITEMS.register("collectible_coin_carnation_trevor_brannigan",
            () -> new CarnationPatronCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    public static final RegistryObject<Item> TREVOR_BRANNIGAN_COSMOS_COIN = ITEMS.register("collectible_coin_cosmos_trevor_brannigan",
            () -> new CosmosPatronCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.ENDONIAN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.ENDONIAN));
    // gameplay collection
    // cod set
    public static final RegistryObject<Item> COPPER_COD_COIN = ITEMS.register("collectible_coin_cod_copper",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_COD_COIN = ITEMS.register("collectible_coin_cod_iron",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_COD_COIN = ITEMS.register("collectible_coin_cod_gold",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_COD_COIN = ITEMS.register("collectible_coin_cod_netherite",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // pufferfish set
    public static final RegistryObject<Item> COPPER_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_copper",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_iron",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_gold",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PUFFERFISH_COIN = ITEMS.register("collectible_coin_pufferfish_netherite",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // salmon set
    public static final RegistryObject<Item> COPPER_SALMON_COIN = ITEMS.register("collectible_coin_salmon_copper",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SALMON_COIN = ITEMS.register("collectible_coin_salmon_iron",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SALMON_COIN = ITEMS.register("collectible_coin_salmon_gold",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SALMON_COIN = ITEMS.register("collectible_coin_salmon_netherite",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // tropical fish set
    public static final RegistryObject<Item> COPPER_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_copper",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_iron",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_gold",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_TROPICAL_FISH_COIN = ITEMS.register("collectible_coin_tropical_fish_netherite",
            () -> new FishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // hero set
    public static final RegistryObject<Item> COPPER_HERO_COIN = ITEMS.register("collectible_coin_hero_copper",
            () -> new HeroCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_HERO_COIN = ITEMS.register("collectible_coin_hero_iron",
            () -> new HeroCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_HERO_COIN = ITEMS.register("collectible_coin_hero_gold",
            () -> new HeroCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_HERO_COIN = ITEMS.register("collectible_coin_hero_netherite",
            () -> new HeroCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // entity collection
    // allay set
    public static final RegistryObject<Item> COPPER_ALLAY_COIN = ITEMS.register("collectible_coin_allay_copper",
            () -> new AllayCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ALLAY_COIN = ITEMS.register("collectible_coin_allay_iron",
            () -> new AllayCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ALLAY_COIN = ITEMS.register("collectible_coin_allay_gold",
            () -> new AllayCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ALLAY_COIN = ITEMS.register("collectible_coin_allay_netherite",
            () -> new AllayCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // axolotl set
    public static final RegistryObject<Item> COPPER_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_copper",
            () -> new AxolotlCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_iron",
            () -> new AxolotlCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_gold",
            () -> new AxolotlCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_AXOLOTL_COIN = ITEMS.register("collectible_coin_axolotl_netherite",
            () -> new AxolotlCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // bat set
    public static final RegistryObject<Item> COPPER_BAT_COIN = ITEMS.register("collectible_coin_bat_copper",
            () -> new BatCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_BAT_COIN = ITEMS.register("collectible_coin_bat_iron",
            () -> new BatCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_BAT_COIN = ITEMS.register("collectible_coin_bat_gold",
            () -> new BatCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_BAT_COIN = ITEMS.register("collectible_coin_bat_netherite",
            () -> new BatCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // bee set
    public static final RegistryObject<Item> COPPER_BEE_COIN = ITEMS.register("collectible_coin_bee_copper",
            () -> new BeeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_BEE_COIN = ITEMS.register("collectible_coin_bee_iron",
            () -> new BeeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_BEE_COIN = ITEMS.register("collectible_coin_bee_gold",
            () -> new BeeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_BEE_COIN = ITEMS.register("collectible_coin_bee_netherite",
            () -> new BeeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // blaze set
    public static final RegistryObject<Item> COPPER_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_copper",
            () -> new BlazeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_iron",
            () -> new BlazeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_gold",
            () -> new BlazeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_BLAZE_COIN = ITEMS.register("collectible_coin_blaze_netherite",
            () -> new BlazeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // camel set
    public static final RegistryObject<Item> COPPER_CAMEL_COIN = ITEMS.register("collectible_coin_camel_copper",
            () -> new CamelCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_CAMEL_COIN = ITEMS.register("collectible_coin_camel_iron",
            () -> new CamelCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_CAMEL_COIN = ITEMS.register("collectible_coin_camel_gold",
            () -> new CamelCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_CAMEL_COIN = ITEMS.register("collectible_coin_camel_netherite",
            () -> new CamelCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // cat set
    public static final RegistryObject<Item> COPPER_CAT_COIN = ITEMS.register("collectible_coin_cat_copper",
            () -> new FelineCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_CAT_COIN = ITEMS.register("collectible_coin_cat_iron",
            () -> new FelineCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_CAT_COIN = ITEMS.register("collectible_coin_cat_gold",
            () -> new FelineCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_CAT_COIN = ITEMS.register("collectible_coin_cat_netherite",
            () -> new FelineCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // cave spider set
    public static final RegistryObject<Item> COPPER_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_copper",
            () -> new CaveSpiderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_iron",
            () -> new CaveSpiderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_gold",
            () -> new CaveSpiderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_CAVE_SPIDER_COIN = ITEMS.register("collectible_coin_cave_spider_netherite",
            () -> new CaveSpiderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // chicken set
    public static final RegistryObject<Item> COPPER_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_copper",
            () -> new ChickenCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_iron",
            () -> new ChickenCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_gold",
            () -> new ChickenCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_CHICKEN_COIN = ITEMS.register("collectible_coin_chicken_netherite",
            () -> new ChickenCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // cow set
    public static final RegistryObject<Item> COPPER_COW_COIN = ITEMS.register("collectible_coin_cow_copper",
            () -> new CowCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_COW_COIN = ITEMS.register("collectible_coin_cow_iron",
            () -> new CowCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_COW_COIN = ITEMS.register("collectible_coin_cow_gold",
            () -> new CowCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_COW_COIN = ITEMS.register("collectible_coin_cow_netherite",
            () -> new CowCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // creeper set
    public static final RegistryObject<Item> COPPER_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_copper",
            () -> new CreeperCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_iron",
            () -> new CreeperCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_gold",
            () -> new CreeperCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_CREEPER_COIN = ITEMS.register("collectible_coin_creeper_netherite",
            () -> new CreeperCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // dolphin set
    public static final RegistryObject<Item> COPPER_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_copper",
            () -> new DolphinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_iron",
            () -> new DolphinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_gold",
            () -> new DolphinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_DOLPHIN_COIN = ITEMS.register("collectible_coin_dolphin_netherite",
            () -> new DolphinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // donkey set
    public static final RegistryObject<Item> COPPER_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_copper",
            () -> new DonkeyCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_iron",
            () -> new DonkeyCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_gold",
            () -> new DonkeyCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_DONKEY_COIN = ITEMS.register("collectible_coin_donkey_netherite",
            () -> new DonkeyCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // drowned set
    public static final RegistryObject<Item> COPPER_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_copper",
            () -> new DrownedCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_iron",
            () -> new DrownedCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_gold",
            () -> new DrownedCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_DROWNED_COIN = ITEMS.register("collectible_coin_drowned_netherite",
            () -> new DrownedCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // elder guardian set
    public static final RegistryObject<Item> COPPER_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_copper",
            () -> new GuardianCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_iron",
            () -> new GuardianCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_gold",
            () -> new GuardianCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ELDER_GUARDIAN_COIN = ITEMS.register("collectible_coin_elder_guardian_netherite",
            () -> new GuardianCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // ender dragon set
    public static final RegistryObject<Item> COPPER_ENDER_DRAGON_COIN = ITEMS.register("collectible_coin_ender_dragon_copper",
            () -> new DragonCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ENDER_DRAGON_COIN = ITEMS.register("collectible_coin_ender_dragon_iron",
            () -> new DragonCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ENDER_DRAGON_COIN = ITEMS.register("collectible_coin_ender_dragon_gold",
            () -> new DragonCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ENDER_DRAGON_COIN = ITEMS.register("collectible_coin_ender_dragon_netherite",
            () -> new DragonCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // enderman set
    public static final RegistryObject<Item> COPPER_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_copper",
            () -> new EndermanCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_iron",
            () -> new EndermanCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_gold",
            () -> new EndermanCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ENDERMAN_COIN = ITEMS.register("collectible_coin_enderman_netherite",
            () -> new EndermanCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // endermite set
    public static final RegistryObject<Item> COPPER_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_copper",
            () -> new EndermiteCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_iron",
            () -> new EndermiteCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_gold",
            () -> new EndermiteCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ENDERMITE_COIN = ITEMS.register("collectible_coin_endermite_netherite",
            () -> new EndermiteCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // evoker set
    public static final RegistryObject<Item> COPPER_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_copper",
            () -> new EvokerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_iron",
            () -> new EvokerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_gold",
            () -> new EvokerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_EVOKER_COIN = ITEMS.register("collectible_coin_evoker_netherite",
            () -> new EvokerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // fox set
    public static final RegistryObject<Item> COPPER_FOX_COIN = ITEMS.register("collectible_coin_fox_copper",
            () -> new FoxCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_FOX_COIN = ITEMS.register("collectible_coin_fox_iron",
            () -> new FoxCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_FOX_COIN = ITEMS.register("collectible_coin_fox_gold",
            () -> new FoxCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_FOX_COIN = ITEMS.register("collectible_coin_fox_netherite",
            () -> new FoxCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // frog set
    public static final RegistryObject<Item> COPPER_FROG_COIN = ITEMS.register("collectible_coin_frog_copper",
            () -> new FrogCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_FROG_COIN = ITEMS.register("collectible_coin_frog_iron",
            () -> new FrogCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_FROG_COIN = ITEMS.register("collectible_coin_frog_gold",
            () -> new FrogCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_FROG_COIN = ITEMS.register("collectible_coin_frog_netherite",
            () -> new FrogCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // giant set
    public static final RegistryObject<Item> COPPER_GIANT_COIN = ITEMS.register("collectible_coin_giant_copper",
            () -> new GiantCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_GIANT_COIN = ITEMS.register("collectible_coin_giant_iron",
            () -> new GiantCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_GIANT_COIN = ITEMS.register("collectible_coin_giant_gold",
            () -> new GiantCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_GIANT_COIN = ITEMS.register("collectible_coin_giant_netherite",
            () -> new GiantCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // glow squid set
    public static final RegistryObject<Item> COPPER_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_copper",
            () -> new GlowSquidCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_iron",
            () -> new GlowSquidCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_gold",
            () -> new GlowSquidCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_GLOW_SQUID_COIN = ITEMS.register("collectible_coin_glow_squid_netherite",
            () -> new GlowSquidCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // goat set
    public static final RegistryObject<Item> COPPER_GOAT_COIN = ITEMS.register("collectible_coin_goat_copper",
            () -> new GoatCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_GOAT_COIN = ITEMS.register("collectible_coin_goat_iron",
            () -> new GoatCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_GOAT_COIN = ITEMS.register("collectible_coin_goat_gold",
            () -> new GoatCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_GOAT_COIN = ITEMS.register("collectible_coin_goat_netherite",
            () -> new GoatCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // guardian set
    public static final RegistryObject<Item> COPPER_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_copper",
            () -> new GuardianCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_iron",
            () -> new GuardianCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_gold",
            () -> new GuardianCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_GUARDIAN_COIN = ITEMS.register("collectible_coin_guardian_netherite",
            () -> new GuardianCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // ghast set
    public static final RegistryObject<Item> COPPER_GHAST_COIN = ITEMS.register("collectible_coin_ghast_copper",
            () -> new GhastCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_GHAST_COIN = ITEMS.register("collectible_coin_ghast_iron",
            () -> new GhastCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_GHAST_COIN = ITEMS.register("collectible_coin_ghast_gold",
            () -> new GhastCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_GHAST_COIN = ITEMS.register("collectible_coin_ghast_netherite",
            () -> new GhastCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // hoglin set
    public static final RegistryObject<Item> COPPER_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_copper",
            () -> new HoglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_iron",
            () -> new HoglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_gold",
            () -> new HoglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_HOGLIN_COIN = ITEMS.register("collectible_coin_hoglin_netherite",
            () -> new HoglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // horse set
    public static final RegistryObject<Item> COPPER_HORSE_COIN = ITEMS.register("collectible_coin_horse_copper",
            () -> new HorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_HORSE_COIN = ITEMS.register("collectible_coin_horse_iron",
            () -> new HorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> GOLD_HORSE_COIN = ITEMS.register("collectible_coin_horse_gold",
            () -> new HorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> NETHERITE_HORSE_COIN = ITEMS.register("collectible_coin_horse_netherite",
            () -> new HorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    // husk set
    public static final RegistryObject<Item> COPPER_HUSK_COIN = ITEMS.register("collectible_coin_husk_copper",
            () -> new HorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_HUSK_COIN = ITEMS.register("collectible_coin_husk_iron",
            () -> new HorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_HUSK_COIN = ITEMS.register("collectible_coin_husk_gold",
            () -> new HorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_HUSK_COIN = ITEMS.register("collectible_coin_husk_netherite",
            () -> new HorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // iron golem set
    public static final RegistryObject<Item> COPPER_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_copper",
            () -> new IronGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_iron",
            () -> new IronGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_gold",
            () -> new IronGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_IRON_GOLEM_COIN = ITEMS.register("collectible_coin_iron_golem_netherite",
            () -> new IronGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // illusioner set
    public static final RegistryObject<Item> COPPER_ILLUSIONER_COIN = ITEMS.register("collectible_coin_illusioner_copper",
            () -> new IllusionerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ILLUSIONER_COIN = ITEMS.register("collectible_coin_illusioner_iron",
            () -> new IllusionerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ILLUSIONER_COIN = ITEMS.register("collectible_coin_illusioner_gold",
            () -> new IllusionerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ILLUSIONER_COIN = ITEMS.register("collectible_coin_illusioner_netherite",
            () -> new IllusionerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // llama set
    public static final RegistryObject<Item> COPPER_LLAMA_COIN = ITEMS.register("collectible_coin_llama_copper",
            () -> new LlamaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_LLAMA_COIN = ITEMS.register("collectible_coin_llama_iron",
            () -> new LlamaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_LLAMA_COIN = ITEMS.register("collectible_coin_llama_gold",
            () -> new LlamaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_LLAMA_COIN = ITEMS.register("collectible_coin_llama_netherite",
            () -> new LlamaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // magma cube set
    public static final RegistryObject<Item> COPPER_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_copper",
            () -> new CubeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_iron",
            () -> new CubeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_gold",
            () -> new CubeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_MAGMA_CUBE_COIN = ITEMS.register("collectible_coin_magma_cube_netherite",
            () -> new CubeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // mooshroom set
    public static final RegistryObject<Item> COPPER_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_copper",
            () -> new MooshroomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_iron",
            () -> new MooshroomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_gold",
            () -> new MooshroomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_MOOSHROOM_COIN = ITEMS.register("collectible_coin_mooshroom_netherite",
            () -> new MooshroomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // mule set
    public static final RegistryObject<Item> COPPER_MULE_COIN = ITEMS.register("collectible_coin_mule_copper",
            () -> new MuleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_MULE_COIN = ITEMS.register("collectible_coin_mule_iron",
            () -> new MuleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_MULE_COIN = ITEMS.register("collectible_coin_mule_gold",
            () -> new MuleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_MULE_COIN = ITEMS.register("collectible_coin_mule_netherite",
            () -> new MuleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // numismatist set
    public static final RegistryObject<Item> COPPER_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_copper",
            () -> new NumismatistCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_iron",
            () -> new NumismatistCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_gold",
            () -> new NumismatistCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_NUMISMATIST_COIN = ITEMS.register("collectible_coin_numismatist_netherite",
            () -> new NumismatistCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // ocelot set
    public static final RegistryObject<Item> COPPER_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_copper",
            () -> new FelineCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_iron",
            () -> new FelineCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_gold",
            () -> new FelineCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_OCELOT_COIN = ITEMS.register("collectible_coin_ocelot_netherite",
            () -> new FelineCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // panda set
    public static final RegistryObject<Item> COPPER_PANDA_COIN = ITEMS.register("collectible_coin_panda_copper",
            () -> new PandaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PANDA_COIN = ITEMS.register("collectible_coin_panda_iron",
            () -> new PandaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PANDA_COIN = ITEMS.register("collectible_coin_panda_gold",
            () -> new PandaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PANDA_COIN = ITEMS.register("collectible_coin_panda_netherite",
            () -> new PandaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // parrot set
    public static final RegistryObject<Item> COPPER_PARROT_COIN = ITEMS.register("collectible_coin_parrot_copper",
            () -> new ParrotCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PARROT_COIN = ITEMS.register("collectible_coin_parrot_iron",
            () -> new ParrotCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PARROT_COIN = ITEMS.register("collectible_coin_parrot_gold",
            () -> new ParrotCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PARROT_COIN = ITEMS.register("collectible_coin_parrot_netherite",
            () -> new ParrotCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // phantom set
    public static final RegistryObject<Item> COPPER_PHANTOM_COIN = ITEMS.register("collectible_coin_phantom_copper",
            () -> new PhantomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PHANTOM_COIN = ITEMS.register("collectible_coin_phantom_iron",
            () -> new PhantomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PHANTOM_COIN = ITEMS.register("collectible_coin_phantom_gold",
            () -> new PhantomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PHANTOM_COIN = ITEMS.register("collectible_coin_phantom_netherite",
            () -> new PhantomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // pig set
    public static final RegistryObject<Item> COPPER_PIG_COIN = ITEMS.register("collectible_coin_pig_copper",
            () -> new PigCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PIG_COIN = ITEMS.register("collectible_coin_pig_iron",
            () -> new PigCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PIG_COIN = ITEMS.register("collectible_coin_pig_gold",
            () -> new PigCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PIG_COIN = ITEMS.register("collectible_coin_pig_netherite",
            () -> new PigCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // piglin merchant set
    public static final RegistryObject<Item> COPPER_PIGLIN_MERCHANT_COIN = ITEMS.register("collectible_coin_piglin_merchant_copper",
            () -> new PiglinMerchantCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PIGLIN_MERCHANT_COIN = ITEMS.register("collectible_coin_piglin_merchant_iron",
            () -> new PiglinMerchantCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PIGLIN_MERCHANT_COIN = ITEMS.register("collectible_coin_piglin_merchant_gold",
            () -> new PiglinMerchantCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PIGLIN_MERCHANT_COIN = ITEMS.register("collectible_coin_piglin_merchant_netherite",
            () -> new PiglinMerchantCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // piglin brute set
    public static final RegistryObject<Item> COPPER_PIGLIN_BRUTE_COIN = ITEMS.register("collectible_coin_piglin_brute_copper",
            () -> new PiglinBruteCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PIGLIN_BRUTE_COIN = ITEMS.register("collectible_coin_piglin_brute_iron",
            () -> new PiglinBruteCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PIGLIN_BRUTE_COIN = ITEMS.register("collectible_coin_piglin_brute_gold",
            () -> new PiglinBruteCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PIGLIN_BRUTE_COIN = ITEMS.register("collectible_coin_piglin_brute_netherite",
            () -> new PiglinBruteCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // piglin set
    public static final RegistryObject<Item> COPPER_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_copper",
            () -> new PiglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_iron",
            () -> new PiglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_gold",
            () -> new PiglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PIGLIN_COIN = ITEMS.register("collectible_coin_piglin_netherite",
            () -> new PiglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // pillager set
    public static final RegistryObject<Item> COPPER_PILLAGER_COIN = ITEMS.register("collectible_coin_pillager_copper",
            () -> new PillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PILLAGER_COIN = ITEMS.register("collectible_coin_pillager_iron",
            () -> new PillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PILLAGER_COIN = ITEMS.register("collectible_coin_pillager_gold",
            () -> new PillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PILLAGER_COIN = ITEMS.register("collectible_coin_pillager_netherite",
            () -> new PillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // polar bear set
    public static final RegistryObject<Item> COPPER_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_copper",
            () -> new PolarBearCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_iron",
            () -> new PolarBearCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_gold",
            () -> new PolarBearCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_POLAR_BEAR_COIN = ITEMS.register("collectible_coin_polar_bear_netherite",
            () -> new PolarBearCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // rabbit set
    public static final RegistryObject<Item> COPPER_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_copper",
            () -> new RabbitCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_iron",
            () -> new RabbitCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_gold",
            () -> new RabbitCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_RABBIT_COIN = ITEMS.register("collectible_coin_rabbit_netherite",
            () -> new RabbitCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // ravager set
    public static final RegistryObject<Item> COPPER_RAVAGER_COIN = ITEMS.register("collectible_coin_ravager_copper",
            () -> new RavagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_RAVAGER_COIN = ITEMS.register("collectible_coin_ravager_iron",
            () -> new RavagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_RAVAGER_COIN = ITEMS.register("collectible_coin_ravager_gold",
            () -> new RavagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_RAVAGER_COIN = ITEMS.register("collectible_coin_ravager_netherite",
            () -> new RavagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // sheep set
    public static final RegistryObject<Item> COPPER_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_copper",
            () -> new SheepCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_iron",
            () -> new SheepCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_gold",
            () -> new SheepCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SHEEP_COIN = ITEMS.register("collectible_coin_sheep_netherite",
            () -> new SheepCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // shulker set
    public static final RegistryObject<Item> COPPER_SHULKER_COIN = ITEMS.register("collectible_coin_shulker_copper",
            () -> new ShulkerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SHULKER_COIN = ITEMS.register("collectible_coin_shulker_iron",
            () -> new ShulkerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SHULKER_COIN = ITEMS.register("collectible_coin_shulker_gold",
            () -> new ShulkerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SHULKER_COIN = ITEMS.register("collectible_coin_shulker_netherite",
            () -> new ShulkerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // silverfish set
    public static final RegistryObject<Item> COPPER_SILVERFISH_COIN = ITEMS.register("collectible_coin_silverfish_copper",
            () -> new SilverfishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SILVERFISH_COIN = ITEMS.register("collectible_coin_silverfish_iron",
            () -> new SilverfishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SILVERFISH_COIN = ITEMS.register("collectible_coin_silverfish_gold",
            () -> new SilverfishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SILVERFISH_COIN = ITEMS.register("collectible_coin_silverfish_netherite",
            () -> new SilverfishCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // skeleton set
    public static final RegistryObject<Item> COPPER_SKELETON_COIN = ITEMS.register("collectible_coin_skeleton_copper",
            () -> new SkeletonCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SKELETON_COIN = ITEMS.register("collectible_coin_skeleton_iron",
            () -> new SkeletonCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SKELETON_COIN = ITEMS.register("collectible_coin_skeleton_gold",
            () -> new SkeletonCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SKELETON_COIN = ITEMS.register("collectible_coin_skeleton_netherite",
            () -> new SkeletonCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // skeleton horse set
    public static final RegistryObject<Item> COPPER_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_copper",
            () -> new SkeletonHorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_iron",
            () -> new SkeletonHorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_gold",
            () -> new SkeletonHorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SKELETON_HORSE_COIN = ITEMS.register("collectible_coin_skeleton_horse_netherite",
            () -> new SkeletonHorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // slime set
    public static final RegistryObject<Item> COPPER_SLIME_COIN = ITEMS.register("collectible_coin_slime_copper",
            () -> new CubeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SLIME_COIN = ITEMS.register("collectible_coin_slime_iron",
            () -> new CubeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SLIME_COIN = ITEMS.register("collectible_coin_slime_gold",
            () -> new CubeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SLIME_COIN = ITEMS.register("collectible_coin_slime_netherite",
            () -> new CubeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // sniffer set
    public static final RegistryObject<Item> COPPER_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_copper",
            () -> new SnifferCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_iron",
            () -> new SnifferCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_gold",
            () -> new SnifferCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SNIFFER_COIN = ITEMS.register("collectible_coin_sniffer_netherite",
            () -> new SnifferCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // armadillo set
    public static final RegistryObject<Item> COPPER_ARMADILLO_COIN = ITEMS.register("collectible_coin_armadillo_copper",
            () -> new ArmadilloCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ARMADILLO_COIN = ITEMS.register("collectible_coin_armadillo_iron",
            () -> new ArmadilloCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ARMADILLO_COIN = ITEMS.register("collectible_coin_armadillo_gold",
            () -> new ArmadilloCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ARMADILLO_COIN = ITEMS.register("collectible_coin_armadillo_netherite",
            () -> new ArmadilloCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // snow golem set
    public static final RegistryObject<Item> COPPER_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_copper",
            () -> new SnowGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_iron",
            () -> new SnowGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_gold",
            () -> new SnowGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SNOW_GOLEM_COIN = ITEMS.register("collectible_coin_snow_golem_netherite",
            () -> new SnowGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // spider set
    public static final RegistryObject<Item> COPPER_SPIDER_COIN = ITEMS.register("collectible_coin_spider_copper",
            () -> new SpiderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SPIDER_COIN = ITEMS.register("collectible_coin_spider_iron",
            () -> new SpiderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SPIDER_COIN = ITEMS.register("collectible_coin_spider_gold",
            () -> new SpiderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SPIDER_COIN = ITEMS.register("collectible_coin_spider_netherite",
            () -> new SpiderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // squid set
    public static final RegistryObject<Item> COPPER_SQUID_COIN = ITEMS.register("collectible_coin_squid_copper",
            () -> new SquidCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SQUID_COIN = ITEMS.register("collectible_coin_squid_iron",
            () -> new SquidCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SQUID_COIN = ITEMS.register("collectible_coin_squid_gold",
            () -> new SquidCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SQUID_COIN = ITEMS.register("collectible_coin_squid_netherite",
            () -> new SquidCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // stray set
    public static final RegistryObject<Item> COPPER_STRAY_COIN = ITEMS.register("collectible_coin_stray_copper",
            () -> new StrayCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_STRAY_COIN = ITEMS.register("collectible_coin_stray_iron",
            () -> new StrayCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_STRAY_COIN = ITEMS.register("collectible_coin_stray_gold",
            () -> new StrayCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_STRAY_COIN = ITEMS.register("collectible_coin_stray_netherite",
            () -> new StrayCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // strider set
    public static final RegistryObject<Item> COPPER_STRIDER_COIN = ITEMS.register("collectible_coin_strider_copper",
            () -> new StriderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_STRIDER_COIN = ITEMS.register("collectible_coin_strider_iron",
            () -> new StriderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_STRIDER_COIN = ITEMS.register("collectible_coin_strider_gold",
            () -> new StriderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_STRIDER_COIN = ITEMS.register("collectible_coin_strider_netherite",
            () -> new StriderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // tadpole set
    public static final RegistryObject<Item> COPPER_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_copper",
            () -> new TadpoleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_iron",
            () -> new TadpoleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_gold",
            () -> new TadpoleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_TADPOLE_COIN = ITEMS.register("collectible_coin_tadpole_netherite",
            () -> new TadpoleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // trader llama set
    public static final RegistryObject<Item> COPPER_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_copper",
            () -> new TraderLlamaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_iron",
            () -> new TraderLlamaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_gold",
            () -> new TraderLlamaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_TRADER_LLAMA_COIN = ITEMS.register("collectible_coin_trader_llama_netherite",
            () -> new TraderLlamaCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // turtle set
    public static final RegistryObject<Item> COPPER_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_copper",
            () -> new TurtleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_iron",
            () -> new TurtleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_gold",
            () -> new TurtleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_TURTLE_COIN = ITEMS.register("collectible_coin_turtle_netherite",
            () -> new TurtleCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // vex set
    public static final RegistryObject<Item> COPPER_VEX_COIN = ITEMS.register("collectible_coin_vex_copper",
            () -> new VexCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_VEX_COIN = ITEMS.register("collectible_coin_vex_iron",
            () -> new VexCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_VEX_COIN = ITEMS.register("collectible_coin_vex_gold",
            () -> new VexCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_VEX_COIN = ITEMS.register("collectible_coin_vex_netherite",
            () -> new VexCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // villager set
    public static final RegistryObject<Item> COPPER_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_copper",
            () -> new VillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_iron",
            () -> new VillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_gold",
            () -> new VillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_VILLAGER_COIN = ITEMS.register("collectible_coin_villager_netherite",
            () -> new VillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // vindicator set
    public static final RegistryObject<Item> COPPER_VINDICATOR_COIN = ITEMS.register("collectible_coin_vindicator_copper",
            () -> new VindicatorCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_VINDICATOR_COIN = ITEMS.register("collectible_coin_vindicator_iron",
            () -> new VindicatorCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_VINDICATOR_COIN = ITEMS.register("collectible_coin_vindicator_gold",
            () -> new VindicatorCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_VINDICATOR_COIN = ITEMS.register("collectible_coin_vindicator_netherite",
            () -> new VindicatorCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // wandering trader set
    public static final RegistryObject<Item> COPPER_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_copper",
            () -> new WanderingTraderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_iron",
            () -> new WanderingTraderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_gold",
            () -> new WanderingTraderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_WANDERING_TRADER_COIN = ITEMS.register("collectible_coin_wandering_trader_netherite",
            () -> new WanderingTraderCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // warden set
    public static final RegistryObject<Item> COPPER_WARDEN_COIN = ITEMS.register("collectible_coin_warden_copper",
            () -> new WardenCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_WARDEN_COIN = ITEMS.register("collectible_coin_warden_iron",
            () -> new WardenCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_WARDEN_COIN = ITEMS.register("collectible_coin_warden_gold",
            () -> new WardenCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_WARDEN_COIN = ITEMS.register("collectible_coin_warden_netherite",
            () -> new WardenCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // witch set
    public static final RegistryObject<Item> COPPER_WITCH_COIN = ITEMS.register("collectible_coin_witch_copper",
            () -> new WitchCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_WITCH_COIN = ITEMS.register("collectible_coin_witch_iron",
            () -> new WitchCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_WITCH_COIN = ITEMS.register("collectible_coin_witch_gold",
            () -> new WitchCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_WITCH_COIN = ITEMS.register("collectible_coin_witch_netherite",
            () -> new WitchCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // wither set
    public static final RegistryObject<Item> COPPER_WITHER_COIN = ITEMS.register("collectible_coin_wither_copper",
            () -> new WitherCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_WITHER_COIN = ITEMS.register("collectible_coin_wither_iron",
            () -> new WitherCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_WITHER_COIN = ITEMS.register("collectible_coin_wither_gold",
            () -> new WitherCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_WITHER_COIN = ITEMS.register("collectible_coin_wither_netherite",
            () -> new WitherCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // wither_skeleton set
    public static final RegistryObject<Item> COPPER_WITHER_SKELETON_COIN = ITEMS.register("collectible_coin_wither_skeleton_copper",
            () -> new WitherCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_WITHER_SKELETON_COIN = ITEMS.register("collectible_coin_wither_skeleton_iron",
            () -> new WitherCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_WITHER_SKELETON_COIN = ITEMS.register("collectible_coin_wither_skeleton_gold",
            () -> new WitherCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_WITHER_SKELETON_COIN = ITEMS.register("collectible_coin_wither_skeleton_netherite",
            () -> new WitherCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // wolf set
    public static final RegistryObject<Item> COPPER_WOLF_COIN = ITEMS.register("collectible_coin_wolf_copper",
            () -> new WolfCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_WOLF_COIN = ITEMS.register("collectible_coin_wolf_iron",
            () -> new WolfCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_WOLF_COIN = ITEMS.register("collectible_coin_wolf_gold",
            () -> new WolfCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_WOLF_COIN = ITEMS.register("collectible_coin_wolf_netherite",
            () -> new WolfCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // zoglin set
    public static final RegistryObject<Item> COPPER_ZOGLIN_COIN = ITEMS.register("collectible_coin_zoglin_copper",
            () -> new ZoglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ZOGLIN_COIN = ITEMS.register("collectible_coin_zoglin_iron",
            () -> new ZoglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ZOGLIN_COIN = ITEMS.register("collectible_coin_zoglin_gold",
            () -> new ZoglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ZOGLIN_COIN = ITEMS.register("collectible_coin_zoglin_netherite",
            () -> new ZoglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // zombie set
    public static final RegistryObject<Item> COPPER_ZOMBIE_COIN = ITEMS.register("collectible_coin_zombie_copper",
            () -> new ZombieCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ZOMBIE_COIN = ITEMS.register("collectible_coin_zombie_iron",
            () -> new ZombieCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ZOMBIE_COIN = ITEMS.register("collectible_coin_zombie_gold",
            () -> new ZombieCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ZOMBIE_COIN = ITEMS.register("collectible_coin_zombie_netherite",
            () -> new ZombieCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // zombie horse set
    public static final RegistryObject<Item> COPPER_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_copper",
            () -> new ZombieHorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_iron",
            () -> new ZombieHorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_gold",
            () -> new ZombieHorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ZOMBIE_HORSE_COIN = ITEMS.register("collectible_coin_zombie_horse_netherite",
            () -> new ZombieHorseCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // zombie villager set
    public static final RegistryObject<Item> COPPER_ZOMBIE_VILLAGER_COIN = ITEMS.register("collectible_coin_zombie_villager_copper",
            () -> new ZombieVillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ZOMBIE_VILLAGER_COIN = ITEMS.register("collectible_coin_zombie_villager_iron",
            () -> new ZombieVillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ZOMBIE_VILLAGER_COIN = ITEMS.register("collectible_coin_zombie_villager_gold",
            () -> new ZombieVillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ZOMBIE_VILLAGER_COIN = ITEMS.register("collectible_coin_zombie_villager_netherite",
            () -> new ZombieVillagerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // zombified piglin set
    public static final RegistryObject<Item> COPPER_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_copper",
            () -> new ZombiePiglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_iron",
            () -> new ZombiePiglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_gold",
            () -> new ZombiePiglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ZOMBIFIED_PIGLIN_COIN = ITEMS.register("collectible_coin_zombified_piglin_netherite",
            () -> new ZombiePiglinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));

    // friends and foes
    // moobloom set
    public static final RegistryObject<Item> COPPER_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_copper",
            () -> new MoobloomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_iron",
            () -> new MoobloomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_gold",
            () -> new MoobloomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_MOOBLOOM_COIN = ITEMS.register("collectible_coin_moobloom_netherite",
            () -> new MoobloomCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // copper golem set
    public static final RegistryObject<Item> COPPER_COPPER_GOLEM_COIN = ITEMS.register("collectible_coin_copper_golem_copper",
            () -> new CopperGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_COPPER_GOLEM_COIN = ITEMS.register("collectible_coin_copper_golem_iron",
            () -> new CopperGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_COPPER_GOLEM_COIN = ITEMS.register("collectible_coin_copper_golem_gold",
            () -> new CopperGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_COPPER_GOLEM_COIN = ITEMS.register("collectible_coin_copper_golem_netherite",
            () -> new CopperGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // glare set
    public static final RegistryObject<Item> COPPER_GLARE_COIN = ITEMS.register("collectible_coin_glare_copper",
            () -> new GlareCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_GLARE_COIN = ITEMS.register("collectible_coin_glare_iron",
            () -> new GlareCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_GLARE_COIN = ITEMS.register("collectible_coin_glare_gold",
            () -> new GlareCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_GLARE_COIN = ITEMS.register("collectible_coin_glare_netherite",
            () -> new GlareCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // iceologer set
    public static final RegistryObject<Item> COPPER_ICEOLOGER_COIN = ITEMS.register("collectible_coin_iceologer_copper",
            () -> new IceologerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_ICEOLOGER_COIN = ITEMS.register("collectible_coin_iceologer_iron",
            () -> new IceologerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_ICEOLOGER_COIN = ITEMS.register("collectible_coin_iceologer_gold",
            () -> new IceologerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_ICEOLOGER_COIN = ITEMS.register("collectible_coin_iceologer_netherite",
            () -> new IceologerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // mauler set
    public static final RegistryObject<Item> COPPER_MAULER_COIN = ITEMS.register("collectible_coin_mauler_copper",
            () -> new MaulerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_MAULER_COIN = ITEMS.register("collectible_coin_mauler_iron",
            () -> new MaulerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_MAULER_COIN = ITEMS.register("collectible_coin_mauler_gold",
            () -> new MaulerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_MAULER_COIN = ITEMS.register("collectible_coin_mauler_netherite",
            () -> new MaulerCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // tuff_golem set
    public static final RegistryObject<Item> COPPER_TUFF_GOLEM_COIN = ITEMS.register("collectible_coin_tuff_golem_copper",
            () -> new TuffGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_TUFF_GOLEM_COIN = ITEMS.register("collectible_coin_tuff_golem_iron",
            () -> new TuffGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_TUFF_GOLEM_COIN = ITEMS.register("collectible_coin_tuff_golem_gold",
            () -> new TuffGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_TUFF_GOLEM_COIN = ITEMS.register("collectible_coin_tuff_golem_netherite",
            () -> new TuffGolemCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // wildfire set
    public static final RegistryObject<Item> COPPER_WILDFIRE_COIN = ITEMS.register("collectible_coin_wildfire_copper",
            () -> new BlazeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_WILDFIRE_COIN = ITEMS.register("collectible_coin_wildfire_iron",
            () -> new BlazeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_WILDFIRE_COIN = ITEMS.register("collectible_coin_wildfire_gold",
            () -> new BlazeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_WILDFIRE_COIN = ITEMS.register("collectible_coin_wildfire_netherite",
            () -> new BlazeCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // rascal set
    public static final RegistryObject<Item> COPPER_RASCAL_COIN = ITEMS.register("collectible_coin_rascal_copper",
            () -> new RascalCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_RASCAL_COIN = ITEMS.register("collectible_coin_rascal_iron",
            () -> new RascalCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_RASCAL_COIN = ITEMS.register("collectible_coin_rascal_gold",
            () -> new RascalCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_RASCAL_COIN = ITEMS.register("collectible_coin_rascal_netherite",
            () -> new RascalCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));

    // ecologics
    // crab set
    public static final RegistryObject<Item> COPPER_CRAB_COIN = ITEMS.register("collectible_coin_crab_copper",
            () -> new CrabCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_CRAB_COIN = ITEMS.register("collectible_coin_crab_iron",
            () -> new CrabCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_CRAB_COIN = ITEMS.register("collectible_coin_crab_gold",
            () -> new CrabCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_CRAB_COIN = ITEMS.register("collectible_coin_crab_netherite",
            () -> new CrabCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // squirrel set
    public static final RegistryObject<Item> COPPER_SQUIRREL_COIN = ITEMS.register("collectible_coin_squirrel_copper",
            () -> new SquirrelCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_SQUIRREL_COIN = ITEMS.register("collectible_coin_squirrel_iron",
            () -> new SquirrelCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_SQUIRREL_COIN = ITEMS.register("collectible_coin_squirrel_gold",
            () -> new SquirrelCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_SQUIRREL_COIN = ITEMS.register("collectible_coin_squirrel_netherite",
            () -> new SquirrelCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));
    // penguin set
    public static final RegistryObject<Item> COPPER_PENGUIN_COIN = ITEMS.register("collectible_coin_penguin_copper",
            () -> new PenguinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_PENGUIN_COIN = ITEMS.register("collectible_coin_penguin_iron",
            () -> new PenguinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_PENGUIN_COIN = ITEMS.register("collectible_coin_penguin_gold",
            () -> new PenguinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_PENGUIN_COIN = ITEMS.register("collectible_coin_penguin_netherite",
            () -> new PenguinCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));

    // guard villagers
    // guard set
    public static final RegistryObject<Item> COPPER_GUARD_COIN = ITEMS.register("collectible_coin_guard_copper",
            () -> new GuardCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.COPPER.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.COPPER));
    public static final RegistryObject<Item> IRON_GUARD_COIN = ITEMS.register("collectible_coin_guard_iron",
            () -> new GuardCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.IRON.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.IRON));
    public static final RegistryObject<Item> GOLD_GUARD_COIN = ITEMS.register("collectible_coin_guard_gold",
            () -> new GuardCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.GOLDEN.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.GOLDEN));
    public static final RegistryObject<Item> NETHERITE_GUARD_COIN = ITEMS.register("collectible_coin_guard_netherite",
            () -> new GuardCoinItem(new Item.Properties().durability(CollectibleCoinProperties.Material.NETHERITE.getCoinMaxDurability())
                    .tab(CollectibleCoinsTab.COLLECTORCOINSTAB), CollectibleCoinProperties.Material.NETHERITE));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}