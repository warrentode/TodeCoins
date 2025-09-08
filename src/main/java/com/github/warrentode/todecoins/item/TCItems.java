package com.github.warrentode.todecoins.item;

import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.entity.TCEntityTypes;
import com.github.warrentode.todecoins.item.custom.*;
import com.github.warrentode.todecoins.item.custom.armor.LuckyArmorItem;
import com.github.warrentode.todecoins.item.custom.armor.ModArmorMaterials;
import com.github.warrentode.todecoins.item.custom.bracelet.BraceletProperties;
import com.github.warrentode.todecoins.item.custom.bracelet.FriendshipBraceletItem;
import com.github.warrentode.todecoins.item.custom.collectible.sets.*;
import com.github.warrentode.todecoins.item.custom.wallet.WalletItem;
import com.github.warrentode.todecoins.util.tabs.TabCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.function.Supplier;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinMaterial.*;
import static com.github.warrentode.todecoins.item.custom.collectible.CollectibleCoinSetDefinitions.*;

public class TCItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Maps for dynamic generation
    public static final Map<RegistryObject<Item>, TabCategory> ITEM_CATEGORIES = new HashMap<>();

    public static final RegistryObject<Item> FOUR_LEAF_CLOVER = registerItem(
            "four_leaf_clover",
            () -> new FourLeafCloverItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );

    public static final RegistryObject<Item> CURRENCY_STAMP = registerItem(
            "currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties()
                    .defaultDurability(64)),
            TabCategory.TOOL
    );
    public static final RegistryObject<Item> NETHER_CURRENCY_STAMP = registerItem(
            "nether_currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties()
                    .defaultDurability(64)),
            TabCategory.TOOL
    );
    public static final RegistryObject<Item> ENDONIAN_CURRENCY_STAMP = registerItem(
            "endonian_currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties()
                    .defaultDurability(64)),
            TabCategory.TOOL
    );
    public static final RegistryObject<Item> GEM_CURRENCY_STAMP = registerItem(
            "gem_currency_stamp",
            () -> new CurrencyStampItem(new Item.Properties()
                    .defaultDurability(64)),
            TabCategory.TOOL
    );

    public static final RegistryObject<Item> ENDONIAN_CRYSTAL = registerItem(
            "endonian_crystal",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );

    public static final RegistryObject<Item> COPPER_NUGGET = registerItem(
            "copper_nugget",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> NETHERITE_NUGGET = registerItem(
            "netherite_nugget",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> ENDONIAN_NUGGET = registerItem(
            "endonian_nugget",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> LUCKY_NUGGET = registerItem(
            "lucky_nugget",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> ENDONIAN_INGOT = registerItem(
            "endonian_ingot",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );

    public static final RegistryObject<Item> COPPER_COIN = registerItem(
            "copper_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> IRON_COIN = registerItem(
            "iron_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> GOLD_COIN = registerItem(
            "gold_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> NETHERITE_COIN = registerItem(
            "netherite_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> ENDONIAN_COIN = registerItem(
            "endonian_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> SERVER_TOKEN_COIN = registerItem(
            "server_token_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> LUCKY_COIN = registerItem(
            "lucky_coin",
            () -> new LuckyCoinItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> LAPIS_FLORIN = registerItem(
            "lapis_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> AMETHYST_FLORIN = registerItem(
            "amethyst_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> DIAMOND_FLORIN = registerItem(
            "diamond_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> EMERALD_FLORIN = registerItem(
            "emerald_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> ECHO_FLORIN = registerItem(
            "echo_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> NETHER_GOLD_COIN = registerItem(
            "nether_gold_coin",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> EMERALD_QUARTER_BANK_NOTE = registerItem(
            "emerald_quarter_bank_note",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> EMERALD_HALF_BANK_NOTE = registerItem(
            "emerald_half_bank_note",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> EMERALD_BANK_NOTE = registerItem(
            "emerald_bank_note",
            () -> new CurrencyItem(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );

    public static final RegistryObject<Item> EMERALD_FIBER = registerItem(
            "emerald_fiber",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> LUCKY_FIBER = registerItem(
            "lucky_fiber",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> ENDONIAN_FIBER = registerItem(
            "endonian_fiber",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> ECHO_FIBER = registerItem(
            "echo_fiber",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );

    public static final RegistryObject<Item> EMERALD_THREAD = registerItem(
            "emerald_thread",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> LUCKY_THREAD = registerItem(
            "lucky_thread",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> ENDONIAN_THREAD = registerItem(
            "endonian_thread",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> ECHO_THREAD = registerItem(
            "echo_thread",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );

    public static final RegistryObject<Item> EMERALD_COARSE_WOVE_PAPER = registerItem(
            "emerald_coarse_wove_paper",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> EMERALD_WOVE_PAPER = registerItem(
            "emerald_wove_paper",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> EMERALD_SMOOTH_WOVE_PAPER = registerItem(
            "emerald_smooth_wove_paper",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );

    public static final RegistryObject<Item> LUCKY_FABRIC = registerItem(
            "lucky_fabric",
            () -> new Item(new Item.Properties().stacksTo(64)),
            TabCategory.CURRENCY
    );

    public static final RegistryObject<Item> BRACELET_FRIENDSHIP_EMERALD = registerItem(
            "bracelet_friendship_emerald",
            () -> new FriendshipBraceletItem(new Item.Properties()
                    .durability(BraceletProperties.EMERALD.getMaxUses()),
                    BraceletProperties.EMERALD),
            TabCategory.TOOL
    );
    public static final RegistryObject<Item> BRACELET_FRIENDSHIP_ENDONIAN = registerItem(
            "bracelet_friendship_endonian",
            () -> new FriendshipBraceletItem(new Item.Properties()
                    .durability(BraceletProperties.ENDONIAN.getMaxUses()),
                    BraceletProperties.ENDONIAN),
            TabCategory.TOOL
    );
    public static final RegistryObject<Item> BRACELET_FRIENDSHIP_ECHO = registerItem(
            "bracelet_friendship_echo",
            () -> new FriendshipBraceletItem(new Item.Properties()
                    .durability(BraceletProperties.ECHO.getMaxUses()),
                    BraceletProperties.ECHO),
            TabCategory.TOOL
    );
    public static final RegistryObject<Item> BRACELET_FRIENDSHIP_LUCKY = registerItem(
            "bracelet_friendship_lucky",
            () -> new FriendshipBraceletItem(new Item.Properties()
                    .durability(BraceletProperties.LUCKY.getMaxUses()),
                    BraceletProperties.LUCKY),
            TabCategory.TOOL
    );

    // lucky armor set
    public static final RegistryObject<Item> LUCKY_HAT = registerItem(
            "lucky_hat",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, ArmorItem.Type.HELMET,
                    new Item.Properties()),
            TabCategory.EQUIPMENT
    );
    public static final RegistryObject<Item> LUCKY_SHIRT = registerItem(
            "lucky_shirt",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()),
            TabCategory.EQUIPMENT
    );
    public static final RegistryObject<Item> LUCKY_PANTS = registerItem(
            "lucky_pants",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()),
            TabCategory.EQUIPMENT
    );
    public static final RegistryObject<Item> LUCKY_BOOTS = registerItem(
            "lucky_boots",
            () -> new LuckyArmorItem(ModArmorMaterials.LUCKY, ArmorItem.Type.BOOTS,
                    new Item.Properties()),
            TabCategory.EQUIPMENT
    );

    public static final RegistryObject<Item> CHOCOLATE_COIN_CRIMSON_SPORE = registerItem(
            "chocolate_coin_crimson_spore",
            () -> new Item(new Item.Properties().stacksTo(64)
                    .food(TCFoods.CRIMSON_SPORE_CHOCOLATE_COIN)),
            TabCategory.FOOD
    );
    public static final RegistryObject<Item> CHOCOLATE_COIN_WARPED_SPICE = registerItem(
            "chocolate_coin_warped_spice",
            () -> new Item(new Item.Properties().stacksTo(64)
                    .food(TCFoods.WARPED_SPICE_CHOCOLATE_COIN)),
            TabCategory.FOOD
    );
    public static final RegistryObject<Item> CHOCOLATE_COIN_MILK_BONE = registerItem(
            "chocolate_coin_milk_bone",
            () -> new Item(new Item.Properties().stacksTo(64)
                    .food(TCFoods.MILK_BONE_CHOCOLATE_COIN)),
            TabCategory.FOOD
    );
    public static final RegistryObject<Item> CHOCOLATE_COIN_ULTIMATE_DARK = registerItem(
            "chocolate_coin_ultimate_dark",
            () -> new Item(new Item.Properties().stacksTo(64)
                    .food(TCFoods.ULTIMATE_DARK_CHOCOLATE_COIN)),
            TabCategory.FOOD
    );
    public static final RegistryObject<Item> CHOCOLATE_COIN_BUBBLY_BERRY = registerItem(
            "chocolate_coin_bubbly_berry",
            () -> new Item(new Item.Properties().stacksTo(64)
                    .food(TCFoods.BUBBLY_BERRY_CHOCOLATE_COIN)),
            TabCategory.FOOD
    );
    public static final RegistryObject<Item> CHOCOLATE_COIN_VELVETY_CLOVER = registerItem(
            "chocolate_coin_velvety_clover",
            () -> new Item(new Item.Properties().stacksTo(64)
                    .food(TCFoods.VELVETY_CLOVER_CHOCOLATE_COIN)),
            TabCategory.FOOD
    );
    public static final RegistryObject<Item> CHOCOLATE_COIN_FESTIVE_FUDGE = registerItem(
            "chocolate_coin_festive_fudge",
            () -> new Item(new Item.Properties().stacksTo(64)
                    .food(TCFoods.FESTIVE_FUDGE_CHOCOLATE_COIN)),
            TabCategory.FOOD
    );
    public static final RegistryObject<Item> CHOCOLATE_COIN_FUEGO_FUDGE = registerItem(
            "chocolate_coin_fuego_fudge",
            () -> new Item(new Item.Properties().stacksTo(64)
                    .food(TCFoods.FUEGO_FUDGE_CHOCOLATE_COIN)),
            TabCategory.FOOD
    );
    public static final RegistryObject<Item> CHOCOLATE_COIN_CARMEL_CRISP = registerItem(
            "chocolate_coin_carmel_crisp",
            () -> new Item(new Item.Properties().stacksTo(64)
                    .food(TCFoods.CARMEL_CRISP_CHOCOLATE_COIN)),
            TabCategory.FOOD
    );

    // COLLECTIBLE COIN SETS
//-------- CELEBRATION SET --------
    // holiday
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BIRTHDAY = registerItem(
            "collectible_coin_birthday",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CHRISTMAS = registerItem(
            "collectible_coin_christmas",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HALLOWEEN = registerItem(
            "collectible_coin_halloween",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_EASTER = registerItem(
            "collectible_coin_easter",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_NEW_YEAR = registerItem(
            "collectible_coin_new_year",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    // anniversary
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SCHOLAR_OWL = registerItem(
            "collectible_coin_scholar_owl",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TUXEDO_CAT = registerItem(
            "collectible_coin_tuxedo_cat",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_LITTLE_BEAR = registerItem(
            "collectible_coin_little_bear",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PATRON_CARNATION = registerItem(
            "collectible_coin_patron_carnation",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PATRON_COSMOS = registerItem(
            "collectible_coin_patron_cosmos",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PATRON_SUNFLOWER = registerItem(
            "collectible_coin_patron_sunflower",
            () -> new CelebrationCoinItem(ENDONIAN, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    // hero set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HERO_COPPER = registerItem(
            "collectible_coin_hero_copper",
            () -> new CelebrationCoinItem(COPPER, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HERO_IRON = registerItem(
            "collectible_coin_hero_iron",
            () -> new CelebrationCoinItem(IRON, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HERO_GOLD = registerItem(
            "collectible_coin_hero_gold",
            () -> new CelebrationCoinItem(GOLD, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HERO_NETHERITE = registerItem(
            "collectible_coin_hero_netherite",
            () -> new CelebrationCoinItem(NETHERITE, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
//-------- FISH SET --------
    // cod set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COD_COPPER = registerItem(
            "collectible_coin_cod_copper",
            () -> new FishCoinItem(COPPER, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COD_IRON = registerItem(
            "collectible_coin_cod_iron",
            () -> new FishCoinItem(IRON, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COD_GOLD = registerItem(
            "collectible_coin_cod_gold",
            () -> new FishCoinItem(GOLD, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COD_NETHERITE = registerItem(
            "collectible_coin_cod_netherite",
            () -> new FishCoinItem(NETHERITE, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    // pufferfish set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PUFFERFISH_COPPER = registerItem(
            "collectible_coin_pufferfish_copper",
            () -> new FishCoinItem(COPPER, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PUFFERFISH_IRON = registerItem(
            "collectible_coin_pufferfish_iron",
            () -> new FishCoinItem(IRON, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PUFFERFISH_GOLD = registerItem(
            "collectible_coin_pufferfish_gold",
            () -> new FishCoinItem(GOLD, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PUFFERFISH_NETHERITE = registerItem(
            "collectible_coin_pufferfish_netherite",
            () -> new FishCoinItem(NETHERITE, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    // salmon set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SALMON_COPPER = registerItem(
            "collectible_coin_salmon_copper",
            () -> new FishCoinItem(COPPER, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SALMON_IRON = registerItem(
            "collectible_coin_salmon_iron",
            () -> new FishCoinItem(IRON, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SALMON_GOLD = registerItem(
            "collectible_coin_salmon_gold",
            () -> new FishCoinItem(GOLD, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SALMON_NETHERITE = registerItem(
            "collectible_coin_salmon_netherite",
            () -> new FishCoinItem(NETHERITE, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    // tropical_fish set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TROPICAL_FISH_COPPER = registerItem(
            "collectible_coin_tropical_fish_copper",
            () -> new FishCoinItem(COPPER, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TROPICAL_FISH_IRON = registerItem(
            "collectible_coin_tropical_fish_iron",
            () -> new FishCoinItem(IRON, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TROPICAL_FISH_GOLD = registerItem(
            "collectible_coin_tropical_fish_gold",
            () -> new FishCoinItem(GOLD, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TROPICAL_FISH_NETHERITE = registerItem(
            "collectible_coin_tropical_fish_netherite",
            () -> new FishCoinItem(NETHERITE, CELEBRATION_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    //-------- AERIAL SET --------
    // breeze set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BREEZE_COPPER = registerItem(
            "collectible_coin_breeze_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BREEZE_IRON = registerItem(
            "collectible_coin_breeze_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BREEZE_GOLD = registerItem(
            "collectible_coin_breeze_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BREEZE_NETHERITE = registerItem(
            "collectible_coin_breeze_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    // happy ghast set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HAPPY_GHAST_COPPER = registerItem(
            "collectible_coin_happy_ghast_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HAPPY_GHAST_IRON = registerItem(
            "collectible_coin_happy_ghast_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HAPPY_GHAST_GOLD = registerItem(
            "collectible_coin_happy_ghast_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HAPPY_GHAST_NETHERITE = registerItem(
            "collectible_coin_happy_ghast_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    // allay set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ALLAY_COPPER = registerItem(
            "collectible_coin_allay_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ALLAY_IRON = registerItem(
            "collectible_coin_allay_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ALLAY_GOLD = registerItem(
            "collectible_coin_allay_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ALLAY_NETHERITE = registerItem(
            "collectible_coin_allay_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // bat set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BAT_COPPER = registerItem(
            "collectible_coin_bat_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BAT_IRON = registerItem(
            "collectible_coin_bat_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BAT_GOLD = registerItem(
            "collectible_coin_bat_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BAT_NETHERITE = registerItem(
            "collectible_coin_bat_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // bee set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BEE_COPPER = registerItem(
            "collectible_coin_bee_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BEE_IRON = registerItem(
            "collectible_coin_bee_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BEE_GOLD = registerItem(
            "collectible_coin_bee_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BEE_NETHERITE = registerItem(
            "collectible_coin_bee_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // ender_dragon set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDER_DRAGON_COPPER = registerItem(
            "collectible_coin_ender_dragon_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDER_DRAGON_IRON = registerItem(
            "collectible_coin_ender_dragon_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDER_DRAGON_GOLD = registerItem(
            "collectible_coin_ender_dragon_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDER_DRAGON_NETHERITE = registerItem(
            "collectible_coin_ender_dragon_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // ghast set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GHAST_COPPER = registerItem(
            "collectible_coin_ghast_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GHAST_IRON = registerItem(
            "collectible_coin_ghast_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GHAST_GOLD = registerItem(
            "collectible_coin_ghast_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GHAST_NETHERITE = registerItem(
            "collectible_coin_ghast_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // glare set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GLARE_COPPER = registerItem(
            "collectible_coin_glare_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GLARE_IRON = registerItem(
            "collectible_coin_glare_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GLARE_GOLD = registerItem(
            "collectible_coin_glare_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GLARE_NETHERITE = registerItem(
            "collectible_coin_glare_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // parrot set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PARROT_COPPER = registerItem(
            "collectible_coin_parrot_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PARROT_IRON = registerItem(
            "collectible_coin_parrot_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PARROT_GOLD = registerItem(
            "collectible_coin_parrot_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PARROT_NETHERITE = registerItem(
            "collectible_coin_parrot_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // phantom set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PHANTOM_COPPER = registerItem(
            "collectible_coin_phantom_copper",
            () -> new AerialCoinItem(COPPER, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PHANTOM_IRON = registerItem(
            "collectible_coin_phantom_iron",
            () -> new AerialCoinItem(IRON, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PHANTOM_GOLD = registerItem(
            "collectible_coin_phantom_gold",
            () -> new AerialCoinItem(GOLD, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PHANTOM_NETHERITE = registerItem(
            "collectible_coin_phantom_netherite",
            () -> new AerialCoinItem(NETHERITE, AERIAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- AQUATIC SET --------
    // axolotl set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_AXOLOTL_COPPER = registerItem(
            "collectible_coin_axolotl_copper",
            () -> new AquaticCoinItem(COPPER, AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_AXOLOTL_IRON = registerItem(
            "collectible_coin_axolotl_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_AXOLOTL_GOLD = registerItem(
            "collectible_coin_axolotl_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_AXOLOTL_NETHERITE = registerItem(
            "collectible_coin_axolotl_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // crab set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CRAB_COPPER = registerItem(
            "collectible_coin_crab_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CRAB_IRON = registerItem(
            "collectible_coin_crab_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CRAB_GOLD = registerItem(
            "collectible_coin_crab_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CRAB_NETHERITE = registerItem(
            "collectible_coin_crab_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // elder_guardian set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ELDER_GUARDIAN_COPPER = registerItem(
            "collectible_coin_elder_guardian_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ELDER_GUARDIAN_IRON = registerItem(
            "collectible_coin_elder_guardian_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ELDER_GUARDIAN_GOLD = registerItem(
            "collectible_coin_elder_guardian_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ELDER_GUARDIAN_NETHERITE = registerItem(
            "collectible_coin_elder_guardian_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    // dolphin set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DOLPHIN_COPPER = registerItem(
            "collectible_coin_dolphin_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DOLPHIN_IRON = registerItem(
            "collectible_coin_dolphin_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DOLPHIN_GOLD = registerItem(
            "collectible_coin_dolphin_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DOLPHIN_NETHERITE = registerItem(
            "collectible_coin_dolphin_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // frog set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_FROG_COPPER = registerItem(
            "collectible_coin_frog_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_FROG_IRON = registerItem(
            "collectible_coin_frog_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_FROG_GOLD = registerItem(
            "collectible_coin_frog_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_FROG_NETHERITE = registerItem(
            "collectible_coin_frog_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // glow_squid set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GLOW_SQUID_COPPER = registerItem(
            "collectible_coin_glow_squid_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GLOW_SQUID_IRON = registerItem(
            "collectible_coin_glow_squid_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GLOW_SQUID_GOLD = registerItem(
            "collectible_coin_glow_squid_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GLOW_SQUID_NETHERITE = registerItem(
            "collectible_coin_glow_squid_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // guardian set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GUARDIAN_COPPER = registerItem(
            "collectible_coin_guardian_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GUARDIAN_IRON = registerItem(
            "collectible_coin_guardian_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GUARDIAN_GOLD = registerItem(
            "collectible_coin_guardian_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GUARDIAN_NETHERITE = registerItem(
            "collectible_coin_guardian_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // penguin set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PENGUIN_COPPER = registerItem(
            "collectible_coin_penguin_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PENGUIN_IRON = registerItem(
            "collectible_coin_penguin_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PENGUIN_GOLD = registerItem(
            "collectible_coin_penguin_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PENGUIN_NETHERITE = registerItem(
            "collectible_coin_penguin_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // squid set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SQUID_COPPER = registerItem(
            "collectible_coin_squid_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SQUID_IRON = registerItem(
            "collectible_coin_squid_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SQUID_GOLD = registerItem(
            "collectible_coin_squid_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SQUID_NETHERITE = registerItem(
            "collectible_coin_squid_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // tadpole set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TADPOLE_COPPER = registerItem(
            "collectible_coin_tadpole_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TADPOLE_IRON = registerItem(
            "collectible_coin_tadpole_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TADPOLE_GOLD = registerItem(
            "collectible_coin_tadpole_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TADPOLE_NETHERITE = registerItem(
            "collectible_coin_tadpole_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // turtle set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TURTLE_COPPER = registerItem(
            "collectible_coin_turtle_copper",
            () -> new AquaticCoinItem(COPPER,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TURTLE_IRON = registerItem(
            "collectible_coin_turtle_iron",
            () -> new AquaticCoinItem(IRON,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TURTLE_GOLD = registerItem(
            "collectible_coin_turtle_gold",
            () -> new AquaticCoinItem(GOLD,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TURTLE_NETHERITE = registerItem(
            "collectible_coin_turtle_netherite",
            () -> new AquaticCoinItem(NETHERITE,AQUATIC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    //-------- STEED SET --------
    // camel set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAMEL_COPPER = registerItem(
            "collectible_coin_camel_copper",
            () -> new SteedCoinItem(COPPER, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAMEL_GOLD = registerItem(
            "collectible_coin_camel_gold",
            () -> new SteedCoinItem(GOLD, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAMEL_IRON = registerItem(
            "collectible_coin_camel_iron",
            () -> new SteedCoinItem(IRON, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAMEL_NETHERITE = registerItem(
            "collectible_coin_camel_netherite",
            () -> new SteedCoinItem(NETHERITE, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // donkey set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DONKEY_COPPER = registerItem(
            "collectible_coin_donkey_copper",
            () -> new SteedCoinItem(COPPER, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DONKEY_IRON = registerItem(
            "collectible_coin_donkey_iron",
            () -> new SteedCoinItem(IRON, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DONKEY_GOLD = registerItem(
            "collectible_coin_donkey_gold",
            () -> new SteedCoinItem(GOLD, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DONKEY_NETHERITE = registerItem(
            "collectible_coin_donkey_netherite",
            () -> new SteedCoinItem(NETHERITE, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // horse set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HORSE_COPPER = registerItem(
            "collectible_coin_horse_copper",
            () -> new SteedCoinItem(COPPER, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HORSE_GOLD = registerItem(
            "collectible_coin_horse_gold",
            () -> new SteedCoinItem(GOLD, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HORSE_IRON = registerItem(
            "collectible_coin_horse_iron",
            () -> new SteedCoinItem(IRON, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HORSE_NETHERITE = registerItem(
            "collectible_coin_horse_netherite",
            () -> new SteedCoinItem(NETHERITE, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // llama set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_LLAMA_COPPER = registerItem(
            "collectible_coin_llama_copper",
            () -> new SteedCoinItem(COPPER, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_LLAMA_GOLD = registerItem(
            "collectible_coin_llama_gold",
            () -> new SteedCoinItem(GOLD, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_LLAMA_IRON = registerItem(
            "collectible_coin_llama_iron",
            () -> new SteedCoinItem(IRON, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_LLAMA_NETHERITE = registerItem(
            "collectible_coin_llama_netherite",
            () -> new SteedCoinItem(NETHERITE, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // mule set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MULE_COPPER = registerItem(
            "collectible_coin_mule_copper",
            () -> new SteedCoinItem(COPPER, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MULE_GOLD = registerItem(
            "collectible_coin_mule_gold",
            () -> new SteedCoinItem(GOLD, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MULE_IRON = registerItem(
            "collectible_coin_mule_iron",
            () -> new SteedCoinItem(IRON, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MULE_NETHERITE = registerItem(
            "collectible_coin_mule_netherite",
            () -> new SteedCoinItem(NETHERITE, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // skeleton_horse set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SKELETON_HORSE_COPPER = registerItem(
            "collectible_coin_skeleton_horse_copper",
            () -> new SteedCoinItem(COPPER, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SKELETON_HORSE_GOLD = registerItem(
            "collectible_coin_skeleton_horse_gold",
            () -> new SteedCoinItem(GOLD, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SKELETON_HORSE_IRON = registerItem(
            "collectible_coin_skeleton_horse_iron",
            () -> new SteedCoinItem(IRON, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SKELETON_HORSE_NETHERITE = registerItem(
            "collectible_coin_skeleton_horse_netherite",
            () -> new SteedCoinItem(NETHERITE, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // strider set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_STRIDER_COPPER = registerItem(
            "collectible_coin_strider_copper",
            () -> new SteedCoinItem(COPPER, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_STRIDER_IRON = registerItem(
            "collectible_coin_strider_iron",
            () -> new SteedCoinItem(IRON, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_STRIDER_GOLD = registerItem(
            "collectible_coin_strider_gold",
            () -> new SteedCoinItem(GOLD, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_STRIDER_NETHERITE = registerItem(
            "collectible_coin_strider_netherite",
            () -> new SteedCoinItem(NETHERITE, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // trader_llama set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TRADER_LLAMA_COPPER = registerItem(
            "collectible_coin_trader_llama_copper",
            () -> new SteedCoinItem(COPPER, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TRADER_LLAMA_GOLD = registerItem(
            "collectible_coin_trader_llama_gold",
            () -> new SteedCoinItem(GOLD, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TRADER_LLAMA_IRON = registerItem(
            "collectible_coin_trader_llama_iron",
            () -> new SteedCoinItem(IRON, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TRADER_LLAMA_NETHERITE = registerItem(
            "collectible_coin_trader_llama_netherite",
            () -> new SteedCoinItem(NETHERITE, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // zombie_horse set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_HORSE_COPPER = registerItem(
            "collectible_coin_zombie_horse_copper",
            () -> new SteedCoinItem(COPPER, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_HORSE_GOLD = registerItem(
            "collectible_coin_zombie_horse_gold",
            () -> new SteedCoinItem(GOLD, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_HORSE_IRON = registerItem(
            "collectible_coin_zombie_horse_iron",
            () -> new SteedCoinItem(IRON, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_HORSE_NETHERITE = registerItem(
            "collectible_coin_zombie_horse_netherite",
            () -> new SteedCoinItem(NETHERITE, STEED_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    //-------- BREEDABLE SET --------

    // armadillo set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ARMADILLO_COPPER = registerItem(
            "collectible_coin_armadillo_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ARMADILLO_IRON = registerItem(
            "collectible_coin_armadillo_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ARMADILLO_GOLD = registerItem(
            "collectible_coin_armadillo_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ARMADILLO_NETHERITE = registerItem(
            "collectible_coin_armadillo_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // cat set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAT_COPPER = registerItem(
            "collectible_coin_cat_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAT_IRON = registerItem(
            "collectible_coin_cat_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAT_GOLD = registerItem(
            "collectible_coin_cat_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAT_NETHERITE = registerItem(
            "collectible_coin_cat_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // chicken set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CHICKEN_COPPER = registerItem(
            "collectible_coin_chicken_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CHICKEN_IRON = registerItem(
            "collectible_coin_chicken_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CHICKEN_GOLD = registerItem(
            "collectible_coin_chicken_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CHICKEN_NETHERITE = registerItem(
            "collectible_coin_chicken_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // cow set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COW_COPPER = registerItem(
            "collectible_coin_cow_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COW_IRON = registerItem(
            "collectible_coin_cow_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COW_GOLD = registerItem(
            "collectible_coin_cow_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COW_NETHERITE = registerItem(
            "collectible_coin_cow_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // fox set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_FOX_COPPER = registerItem(
            "collectible_coin_fox_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_FOX_IRON = registerItem(
            "collectible_coin_fox_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_FOX_GOLD = registerItem(
            "collectible_coin_fox_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_FOX_NETHERITE = registerItem(
            "collectible_coin_fox_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // goat set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GOAT_COPPER = registerItem(
            "collectible_coin_goat_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GOAT_IRON = registerItem(
            "collectible_coin_goat_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GOAT_GOLD = registerItem(
            "collectible_coin_goat_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GOAT_NETHERITE = registerItem(
            "collectible_coin_goat_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // moobloom set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MOOBLOOM_COPPER = registerItem(
            "collectible_coin_moobloom_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MOOBLOOM_IRON = registerItem(
            "collectible_coin_moobloom_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MOOBLOOM_GOLD = registerItem(
            "collectible_coin_moobloom_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MOOBLOOM_NETHERITE = registerItem(
            "collectible_coin_moobloom_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // mooshroom set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MOOSHROOM_COPPER = registerItem(
            "collectible_coin_mooshroom_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MOOSHROOM_IRON = registerItem(
            "collectible_coin_mooshroom_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MOOSHROOM_GOLD = registerItem(
            "collectible_coin_mooshroom_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MOOSHROOM_NETHERITE = registerItem(
            "collectible_coin_mooshroom_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // ocelot set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_OCELOT_COPPER = registerItem(
            "collectible_coin_ocelot_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_OCELOT_IRON = registerItem(
            "collectible_coin_ocelot_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_OCELOT_GOLD = registerItem(
            "collectible_coin_ocelot_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_OCELOT_NETHERITE = registerItem(
            "collectible_coin_ocelot_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // panda set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PANDA_COPPER = registerItem(
            "collectible_coin_panda_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PANDA_IRON = registerItem(
            "collectible_coin_panda_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PANDA_GOLD = registerItem(
            "collectible_coin_panda_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PANDA_NETHERITE = registerItem(
            "collectible_coin_panda_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // pig set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIG_COPPER = registerItem(
            "collectible_coin_pig_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIG_IRON = registerItem(
            "collectible_coin_pig_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIG_GOLD = registerItem(
            "collectible_coin_pig_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIG_NETHERITE = registerItem(
            "collectible_coin_pig_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // rabbit set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RABBIT_COPPER = registerItem(
            "collectible_coin_rabbit_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RABBIT_IRON = registerItem(
            "collectible_coin_rabbit_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RABBIT_GOLD = registerItem(
            "collectible_coin_rabbit_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RABBIT_NETHERITE = registerItem(
            "collectible_coin_rabbit_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // sheep set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SHEEP_COPPER = registerItem(
            "collectible_coin_sheep_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SHEEP_IRON = registerItem(
            "collectible_coin_sheep_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SHEEP_GOLD = registerItem(
            "collectible_coin_sheep_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SHEEP_NETHERITE = registerItem(
            "collectible_coin_sheep_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // wolf set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WOLF_COPPER = registerItem(
            "collectible_coin_wolf_copper",
            () -> new BreedableCoinItem(COPPER, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WOLF_IRON = registerItem(
            "collectible_coin_wolf_iron",
            () -> new BreedableCoinItem(IRON, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WOLF_GOLD = registerItem(
            "collectible_coin_wolf_gold",
            () -> new BreedableCoinItem(GOLD, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WOLF_NETHERITE = registerItem(
            "collectible_coin_wolf_netherite",
            () -> new BreedableCoinItem(NETHERITE, BREEDABLE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    //-------- WILD SET --------

    // mauler set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MAULER_COPPER = registerItem(
            "collectible_coin_mauler_copper",
            () -> new WildAnimalCoinItem(COPPER, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MAULER_IRON = registerItem(
            "collectible_coin_mauler_iron",
            () -> new WildAnimalCoinItem(IRON, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MAULER_GOLD = registerItem(
            "collectible_coin_mauler_gold",
            () -> new WildAnimalCoinItem(GOLD, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MAULER_NETHERITE = registerItem(
            "collectible_coin_mauler_netherite",
            () -> new WildAnimalCoinItem(NETHERITE, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // polar_bear set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_POLAR_BEAR_COPPER = registerItem(
            "collectible_coin_polar_bear_copper",
            () -> new WildAnimalCoinItem(COPPER, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_POLAR_BEAR_IRON = registerItem(
            "collectible_coin_polar_bear_iron",
            () -> new WildAnimalCoinItem(IRON, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_POLAR_BEAR_GOLD = registerItem(
            "collectible_coin_polar_bear_gold",
            () -> new WildAnimalCoinItem(GOLD, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_POLAR_BEAR_NETHERITE = registerItem(
            "collectible_coin_polar_bear_netherite",
            () -> new WildAnimalCoinItem(NETHERITE, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // squirrel set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SQUIRREL_COPPER = registerItem(
            "collectible_coin_squirrel_copper",
            () -> new WildAnimalCoinItem(COPPER, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SQUIRREL_IRON = registerItem(
            "collectible_coin_squirrel_iron",
            () -> new WildAnimalCoinItem(IRON, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SQUIRREL_GOLD = registerItem(
            "collectible_coin_squirrel_gold",
            () -> new WildAnimalCoinItem(GOLD, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SQUIRREL_NETHERITE = registerItem(
            "collectible_coin_squirrel_netherite",
            () -> new WildAnimalCoinItem(NETHERITE, WILD_ANIMAL_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- ARTHROPOD SET --------

    // cave_spider set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAVE_SPIDER_COPPER = registerItem(
            "collectible_coin_cave_spider_copper",
            () -> new ArthropodCoinItem(COPPER, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAVE_SPIDER_IRON = registerItem(
            "collectible_coin_cave_spider_iron",
            () -> new ArthropodCoinItem(IRON, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAVE_SPIDER_GOLD = registerItem(
            "collectible_coin_cave_spider_gold",
            () -> new ArthropodCoinItem(GOLD, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CAVE_SPIDER_NETHERITE = registerItem(
            "collectible_coin_cave_spider_netherite",
            () -> new ArthropodCoinItem(NETHERITE,  ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // endermite set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDERMITE_COPPER = registerItem(
            "collectible_coin_endermite_copper",
            () -> new ArthropodCoinItem(COPPER, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDERMITE_IRON = registerItem(
            "collectible_coin_endermite_iron",
            () -> new ArthropodCoinItem(IRON, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDERMITE_GOLD = registerItem(
            "collectible_coin_endermite_gold",
            () -> new ArthropodCoinItem(GOLD, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDERMITE_NETHERITE = registerItem(
            "collectible_coin_endermite_netherite",
            () -> new ArthropodCoinItem(NETHERITE, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // silverfish set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SILVERFISH_COPPER = registerItem(
            "collectible_coin_silverfish_copper",
            () -> new ArthropodCoinItem(COPPER, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SILVERFISH_IRON = registerItem(
            "collectible_coin_silverfish_iron",
            () -> new ArthropodCoinItem(IRON, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SILVERFISH_GOLD = registerItem(
            "collectible_coin_silverfish_gold",
            () -> new ArthropodCoinItem(GOLD, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SILVERFISH_NETHERITE = registerItem(
            "collectible_coin_silverfish_netherite",
            () -> new ArthropodCoinItem(NETHERITE, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // spider set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SPIDER_COPPER = registerItem(
            "collectible_coin_spider_copper",
            () -> new ArthropodCoinItem(COPPER, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SPIDER_IRON = registerItem(
            "collectible_coin_spider_iron",
            () -> new ArthropodCoinItem(IRON, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SPIDER_GOLD = registerItem(
            "collectible_coin_spider_gold",
            () -> new ArthropodCoinItem(GOLD, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SPIDER_NETHERITE = registerItem(
            "collectible_coin_spider_netherite",
            () -> new ArthropodCoinItem(NETHERITE, ARTHROPOD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- UNDEAD SET --------
// bogged set
public static final RegistryObject<Item> COLLECTIBLE_COIN_BOGGED_COPPER = registerItem(
        "collectible_coin_bogged_copper",
        () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                new Item.Properties().stacksTo(1)),
        TabCategory.CURRENCY
);
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BOGGED_IRON = registerItem(
            "collectible_coin_bogged_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BOGGED_GOLD = registerItem(
            "collectible_coin_bogged_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BOGGED_NETHERITE = registerItem(
            "collectible_coin_bogged_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // drowned set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DROWNED_COPPER = registerItem(
            "collectible_coin_drowned_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DROWNED_IRON = registerItem(
            "collectible_coin_drowned_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DROWNED_GOLD = registerItem(
            "collectible_coin_drowned_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_DROWNED_NETHERITE = registerItem(
            "collectible_coin_drowned_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // husk set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HUSK_COPPER = registerItem(
            "collectible_coin_husk_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HUSK_IRON = registerItem(
            "collectible_coin_husk_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HUSK_GOLD = registerItem(
            "collectible_coin_husk_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HUSK_NETHERITE = registerItem(
            "collectible_coin_husk_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // skeleton set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SKELETON_COPPER = registerItem(
            "collectible_coin_skeleton_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SKELETON_IRON = registerItem(
            "collectible_coin_skeleton_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SKELETON_GOLD = registerItem(
            "collectible_coin_skeleton_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SKELETON_NETHERITE = registerItem(
            "collectible_coin_skeleton_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // stray set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_STRAY_COPPER = registerItem(
            "collectible_coin_stray_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_STRAY_IRON = registerItem(
            "collectible_coin_stray_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_STRAY_GOLD = registerItem(
            "collectible_coin_stray_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_STRAY_NETHERITE = registerItem(
            "collectible_coin_stray_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // wither set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITHER_COPPER = registerItem(
            "collectible_coin_wither_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITHER_IRON = registerItem(
            "collectible_coin_wither_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITHER_GOLD = registerItem(
            "collectible_coin_wither_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITHER_NETHERITE = registerItem(
            "collectible_coin_wither_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // wither_skeleton set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITHER_SKELETON_COPPER = registerItem(
            "collectible_coin_wither_skeleton_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITHER_SKELETON_IRON = registerItem(
            "collectible_coin_wither_skeleton_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITHER_SKELETON_GOLD = registerItem(
            "collectible_coin_wither_skeleton_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITHER_SKELETON_NETHERITE = registerItem(
            "collectible_coin_wither_skeleton_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // zoglin set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOGLIN_COPPER = registerItem(
            "collectible_coin_zoglin_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOGLIN_IRON = registerItem(
            "collectible_coin_zoglin_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOGLIN_GOLD = registerItem(
            "collectible_coin_zoglin_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOGLIN_NETHERITE = registerItem(
            "collectible_coin_zoglin_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // zombie set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_COPPER = registerItem(
            "collectible_coin_zombie_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_IRON = registerItem(
            "collectible_coin_zombie_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_GOLD = registerItem(
            "collectible_coin_zombie_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_NETHERITE = registerItem(
            "collectible_coin_zombie_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // zombie_villager set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_VILLAGER_COPPER = registerItem(
            "collectible_coin_zombie_villager_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_VILLAGER_IRON = registerItem(
            "collectible_coin_zombie_villager_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_VILLAGER_GOLD = registerItem(
            "collectible_coin_zombie_villager_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIE_VILLAGER_NETHERITE = registerItem(
            "collectible_coin_zombie_villager_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // zombified_piglin set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIFIED_PIGLIN_COPPER = registerItem(
            "collectible_coin_zombified_piglin_copper",
            () -> new UndeadCoinItem(COPPER, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIFIED_PIGLIN_IRON = registerItem(
            "collectible_coin_zombified_piglin_iron",
            () -> new UndeadCoinItem(IRON, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIFIED_PIGLIN_GOLD = registerItem(
            "collectible_coin_zombified_piglin_gold",
            () -> new UndeadCoinItem(GOLD, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ZOMBIFIED_PIGLIN_NETHERITE = registerItem(
            "collectible_coin_zombified_piglin_netherite",
            () -> new UndeadCoinItem(NETHERITE, UNDEAD_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- PIGLIN SET --------

    // hoglin set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HOGLIN_COPPER = registerItem(
            "collectible_coin_hoglin_copper",
            () -> new PiglinCoinItem(COPPER, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HOGLIN_IRON = registerItem(
            "collectible_coin_hoglin_iron",
            () -> new PiglinCoinItem(IRON, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HOGLIN_GOLD = registerItem(
            "collectible_coin_hoglin_gold",
            () -> new PiglinCoinItem(GOLD, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_HOGLIN_NETHERITE = registerItem(
            "collectible_coin_hoglin_netherite",
            () -> new PiglinCoinItem(NETHERITE, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // piglin set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_COPPER = registerItem(
            "collectible_coin_piglin_copper",
            () -> new PiglinCoinItem(COPPER, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_IRON = registerItem(
            "collectible_coin_piglin_iron",
            () -> new PiglinCoinItem(IRON, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_GOLD = registerItem(
            "collectible_coin_piglin_gold",
            () -> new PiglinCoinItem(GOLD, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_NETHERITE = registerItem(
            "collectible_coin_piglin_netherite",
            () -> new PiglinCoinItem(NETHERITE, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // piglin_brute set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_BRUTE_COPPER = registerItem(
            "collectible_coin_piglin_brute_copper",
            () -> new PiglinCoinItem(COPPER, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_BRUTE_IRON = registerItem(
            "collectible_coin_piglin_brute_iron",
            () -> new PiglinCoinItem(IRON, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_BRUTE_GOLD = registerItem(
            "collectible_coin_piglin_brute_gold",
            () -> new PiglinCoinItem(GOLD, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_BRUTE_NETHERITE = registerItem(
            "collectible_coin_piglin_brute_netherite",
            () -> new PiglinCoinItem(NETHERITE, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // piglin_merchant set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_MERCHANT_COPPER = registerItem(
            "collectible_coin_piglin_merchant_copper",
            () -> new PiglinCoinItem(COPPER, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_MERCHANT_IRON = registerItem(
            "collectible_coin_piglin_merchant_iron",
            () -> new PiglinCoinItem(IRON, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_MERCHANT_GOLD = registerItem(
            "collectible_coin_piglin_merchant_gold",
            () -> new PiglinCoinItem(GOLD, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PIGLIN_MERCHANT_NETHERITE = registerItem(
            "collectible_coin_piglin_merchant_netherite",
            () -> new PiglinCoinItem(NETHERITE, PIGLIN_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- RAIDER SET --------

    // evoker set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_EVOKER_COPPER = registerItem(
            "collectible_coin_evoker_copper",
            () -> new RaiderCoinItem(COPPER, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_EVOKER_IRON = registerItem(
            "collectible_coin_evoker_iron",
            () -> new RaiderCoinItem(IRON, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_EVOKER_GOLD = registerItem(
            "collectible_coin_evoker_gold",
            () -> new RaiderCoinItem(GOLD, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_EVOKER_NETHERITE = registerItem(
            "collectible_coin_evoker_netherite",
            () -> new RaiderCoinItem(NETHERITE, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // iceologer set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ICEOLOGER_COPPER = registerItem(
            "collectible_coin_iceologer_copper",
            () -> new RaiderCoinItem(COPPER, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ICEOLOGER_IRON = registerItem(
            "collectible_coin_iceologer_iron",
            () -> new RaiderCoinItem(IRON, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ICEOLOGER_GOLD = registerItem(
            "collectible_coin_iceologer_gold",
            () -> new RaiderCoinItem(GOLD, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ICEOLOGER_NETHERITE = registerItem(
            "collectible_coin_iceologer_netherite",
            () -> new RaiderCoinItem(NETHERITE, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // illusioner set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ILLUSIONER_COPPER = registerItem(
            "collectible_coin_illusioner_copper",
            () -> new RaiderCoinItem(COPPER, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ILLUSIONER_IRON = registerItem(
            "collectible_coin_illusioner_iron",
            () -> new RaiderCoinItem(IRON, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ILLUSIONER_GOLD = registerItem(
            "collectible_coin_illusioner_gold",
            () -> new RaiderCoinItem(GOLD, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ILLUSIONER_NETHERITE = registerItem(
            "collectible_coin_illusioner_netherite",
            () -> new RaiderCoinItem(NETHERITE, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // pillager set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PILLAGER_COPPER = registerItem(
            "collectible_coin_pillager_copper",
            () -> new RaiderCoinItem(COPPER, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PILLAGER_IRON = registerItem(
            "collectible_coin_pillager_iron",
            () -> new RaiderCoinItem(IRON, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PILLAGER_GOLD = registerItem(
            "collectible_coin_pillager_gold",
            () -> new RaiderCoinItem(GOLD, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_PILLAGER_NETHERITE = registerItem(
            "collectible_coin_pillager_netherite",
            () -> new RaiderCoinItem(NETHERITE,  RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // ravager set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RAVAGER_COPPER = registerItem(
            "collectible_coin_ravager_copper",
            () -> new RaiderCoinItem(COPPER, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RAVAGER_IRON = registerItem(
            "collectible_coin_ravager_iron",
            () -> new RaiderCoinItem(IRON, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RAVAGER_GOLD = registerItem(
            "collectible_coin_ravager_gold",
            () -> new RaiderCoinItem(GOLD, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RAVAGER_NETHERITE = registerItem(
            "collectible_coin_ravager_netherite",
            () -> new RaiderCoinItem(NETHERITE, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // vex set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VEX_COPPER = registerItem(
            "collectible_coin_vex_copper",
            () -> new RaiderCoinItem(COPPER, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VEX_IRON = registerItem(
            "collectible_coin_vex_iron",
            () -> new RaiderCoinItem(IRON, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VEX_GOLD = registerItem(
            "collectible_coin_vex_gold",
            () -> new RaiderCoinItem(GOLD, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VEX_NETHERITE = registerItem(
            "collectible_coin_vex_netherite",
            () -> new RaiderCoinItem(NETHERITE, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // vindicator set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VINDICATOR_COPPER = registerItem(
            "collectible_coin_vindicator_copper",
            () -> new RaiderCoinItem(COPPER, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VINDICATOR_IRON = registerItem(
            "collectible_coin_vindicator_iron",
            () -> new RaiderCoinItem(IRON, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VINDICATOR_GOLD = registerItem(
            "collectible_coin_vindicator_gold",
            () -> new RaiderCoinItem(GOLD, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VINDICATOR_NETHERITE = registerItem(
            "collectible_coin_vindicator_netherite",
            () -> new RaiderCoinItem(NETHERITE, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // witch set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITCH_COPPER = registerItem(
            "collectible_coin_witch_copper",
            () -> new RaiderCoinItem(COPPER, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITCH_IRON = registerItem(
            "collectible_coin_witch_iron",
            () -> new RaiderCoinItem(IRON, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITCH_GOLD = registerItem(
            "collectible_coin_witch_gold",
            () -> new RaiderCoinItem(GOLD, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WITCH_NETHERITE = registerItem(
            "collectible_coin_witch_netherite",
            () -> new RaiderCoinItem(NETHERITE, RAIDER_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- GOLEM SET --------

    // copper_golem set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COPPER_GOLEM_COPPER = registerItem(
            "collectible_coin_copper_golem_copper",
            () -> new GolemCoinItem(COPPER, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COPPER_GOLEM_IRON = registerItem(
            "collectible_coin_copper_golem_iron",
            () -> new GolemCoinItem(IRON, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COPPER_GOLEM_GOLD = registerItem(
            "collectible_coin_copper_golem_gold",
            () -> new GolemCoinItem(GOLD, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_COPPER_GOLEM_NETHERITE = registerItem(
            "collectible_coin_copper_golem_netherite",
            () -> new GolemCoinItem(NETHERITE, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // iron_golem set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_IRON_GOLEM_COPPER = registerItem(
            "collectible_coin_iron_golem_copper",
            () -> new GolemCoinItem(COPPER, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_IRON_GOLEM_IRON = registerItem(
            "collectible_coin_iron_golem_iron",
            () -> new GolemCoinItem(IRON, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_IRON_GOLEM_GOLD = registerItem(
            "collectible_coin_iron_golem_gold",
            () -> new GolemCoinItem(GOLD, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_IRON_GOLEM_NETHERITE = registerItem(
            "collectible_coin_iron_golem_netherite",
            () -> new GolemCoinItem(NETHERITE, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // snow_golem set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SNOW_GOLEM_COPPER = registerItem(
            "collectible_coin_snow_golem_copper",
            () -> new GolemCoinItem(COPPER, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SNOW_GOLEM_IRON = registerItem(
            "collectible_coin_snow_golem_iron",
            () -> new GolemCoinItem(IRON, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SNOW_GOLEM_GOLD = registerItem(
            "collectible_coin_snow_golem_gold",
            () -> new GolemCoinItem(GOLD, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SNOW_GOLEM_NETHERITE = registerItem(
            "collectible_coin_snow_golem_netherite",
            () -> new GolemCoinItem(NETHERITE, GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // tuff_golem set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TUFF_GOLEM_COPPER = registerItem(
            "collectible_coin_tuff_golem_copper",
            () -> new GolemCoinItem(COPPER,GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TUFF_GOLEM_IRON = registerItem(
            "collectible_coin_tuff_golem_iron",
            () -> new GolemCoinItem(IRON,GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TUFF_GOLEM_GOLD = registerItem(
            "collectible_coin_tuff_golem_gold",
            () -> new GolemCoinItem(GOLD,GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_TUFF_GOLEM_NETHERITE = registerItem(
            "collectible_coin_tuff_golem_netherite",
            () -> new GolemCoinItem(NETHERITE,GOLEM_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- SLIME SET --------

    // magma_cube set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MAGMA_CUBE_COPPER = registerItem(
            "collectible_coin_magma_cube_copper",
            () -> new SlimeCoinItem(COPPER, SLIME_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MAGMA_CUBE_IRON = registerItem(
            "collectible_coin_magma_cube_iron",
            () -> new SlimeCoinItem(IRON, SLIME_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MAGMA_CUBE_GOLD = registerItem(
            "collectible_coin_magma_cube_gold",
            () -> new SlimeCoinItem(GOLD, SLIME_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_MAGMA_CUBE_NETHERITE = registerItem(
            "collectible_coin_magma_cube_netherite",
            () -> new SlimeCoinItem(NETHERITE, SLIME_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // slime set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SLIME_COPPER = registerItem(
            "collectible_coin_slime_copper",
            () -> new SlimeCoinItem(COPPER, SLIME_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SLIME_IRON = registerItem(
            "collectible_coin_slime_iron",
            () -> new SlimeCoinItem(IRON, SLIME_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SLIME_GOLD = registerItem(
            "collectible_coin_slime_gold",
            () -> new SlimeCoinItem(GOLD, SLIME_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SLIME_NETHERITE = registerItem(
            "collectible_coin_slime_netherite",
            () -> new SlimeCoinItem(NETHERITE, SLIME_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- HUMANOID SET --------

    // guard set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GUARD_COPPER = registerItem(
            "collectible_coin_guard_copper",
            () -> new HumanoidCoinItem(COPPER, HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GUARD_IRON = registerItem(
            "collectible_coin_guard_iron",
            () -> new HumanoidCoinItem(IRON, HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GUARD_GOLD = registerItem(
            "collectible_coin_guard_gold",
            () -> new HumanoidCoinItem(GOLD, HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GUARD_NETHERITE = registerItem(
            "collectible_coin_guard_netherite",
            () -> new HumanoidCoinItem(NETHERITE,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // numismatist set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_NUMISMATIST_COPPER = registerItem(
            "collectible_coin_numismatist_copper",
            () -> new HumanoidCoinItem(COPPER,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_NUMISMATIST_IRON = registerItem(
            "collectible_coin_numismatist_iron",
            () -> new HumanoidCoinItem(IRON,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_NUMISMATIST_GOLD = registerItem(
            "collectible_coin_numismatist_gold",
            () -> new HumanoidCoinItem(GOLD,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_NUMISMATIST_NETHERITE = registerItem(
            "collectible_coin_numismatist_netherite",
            () -> new HumanoidCoinItem(NETHERITE,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // rascal set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RASCAL_COPPER = registerItem(
            "collectible_coin_rascal_copper",
            () -> new HumanoidCoinItem(COPPER,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RASCAL_IRON = registerItem(
            "collectible_coin_rascal_iron",
            () -> new HumanoidCoinItem(IRON,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RASCAL_GOLD = registerItem(
            "collectible_coin_rascal_gold",
            () -> new HumanoidCoinItem(GOLD,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_RASCAL_NETHERITE = registerItem(
            "collectible_coin_rascal_netherite",
            () -> new HumanoidCoinItem(NETHERITE,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // villager set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VILLAGER_COPPER = registerItem(
            "collectible_coin_villager_copper",
            () -> new HumanoidCoinItem(COPPER,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VILLAGER_IRON = registerItem(
            "collectible_coin_villager_iron",
            () -> new HumanoidCoinItem(IRON,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VILLAGER_GOLD = registerItem(
            "collectible_coin_villager_gold",
            () -> new HumanoidCoinItem(GOLD,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_VILLAGER_NETHERITE = registerItem(
            "collectible_coin_villager_netherite",
            () -> new HumanoidCoinItem(NETHERITE,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // wandering_trader set
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WANDERING_TRADER_COPPER = registerItem(
            "collectible_coin_wandering_trader_copper",
            () -> new HumanoidCoinItem(COPPER,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WANDERING_TRADER_IRON = registerItem(
            "collectible_coin_wandering_trader_iron",
            () -> new HumanoidCoinItem(IRON,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WANDERING_TRADER_GOLD = registerItem(
            "collectible_coin_wandering_trader_gold",
            () -> new HumanoidCoinItem(GOLD,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WANDERING_TRADER_NETHERITE = registerItem(
            "collectible_coin_wandering_trader_netherite",
            () -> new HumanoidCoinItem(NETHERITE,HUMANOID_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- BLAZE SET --------

    // blaze subset
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BLAZE_COPPER = registerItem(
            "collectible_coin_blaze_copper",
            () -> new BlazeCoinItem(COPPER, BLAZE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BLAZE_IRON = registerItem(
            "collectible_coin_blaze_iron",
            () -> new BlazeCoinItem(IRON, BLAZE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BLAZE_GOLD = registerItem(
            "collectible_coin_blaze_gold",
            () -> new BlazeCoinItem(GOLD, BLAZE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_BLAZE_NETHERITE = registerItem(
            "collectible_coin_blaze_netherite",
            () -> new BlazeCoinItem(NETHERITE, BLAZE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // wildfire subset
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WILDFIRE_COPPER = registerItem(
            "collectible_coin_wildfire_copper",
            () -> new BlazeCoinItem(COPPER, BLAZE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WILDFIRE_IRON = registerItem(
            "collectible_coin_wildfire_iron",
            () -> new BlazeCoinItem(IRON, BLAZE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WILDFIRE_GOLD = registerItem(
            "collectible_coin_wildfire_gold",
            () -> new BlazeCoinItem(GOLD, BLAZE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WILDFIRE_NETHERITE = registerItem(
            "collectible_coin_wildfire_netherite",
            () -> new BlazeCoinItem(NETHERITE, BLAZE_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

//-------- MISC SET --------
    // creeper subset
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CREEPER_COPPER = registerItem(
            "collectible_coin_creeper_copper",
            () -> new MiscCoinItem(COPPER, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CREEPER_IRON = registerItem(
            "collectible_coin_creeper_iron",
            () -> new MiscCoinItem(IRON, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CREEPER_GOLD = registerItem(
            "collectible_coin_creeper_gold",
            () -> new MiscCoinItem(GOLD, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CREEPER_NETHERITE = registerItem(
            "collectible_coin_creeper_netherite",
            () -> new MiscCoinItem(NETHERITE, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // enderman subset
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDERMAN_COPPER = registerItem(
            "collectible_coin_enderman_copper",
            () -> new MiscCoinItem(COPPER, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDERMAN_IRON = registerItem(
            "collectible_coin_enderman_iron",
            () -> new MiscCoinItem(IRON, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDERMAN_GOLD = registerItem(
            "collectible_coin_enderman_gold",
            () -> new MiscCoinItem(GOLD, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_ENDERMAN_NETHERITE = registerItem(
            "collectible_coin_enderman_netherite",
            () -> new MiscCoinItem(NETHERITE, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // giant subset
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GIANT_COPPER = registerItem(
            "collectible_coin_giant_copper",
            () -> new MiscCoinItem(COPPER, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GIANT_IRON = registerItem(
            "collectible_coin_giant_iron",
            () -> new MiscCoinItem(IRON, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GIANT_GOLD = registerItem(
            "collectible_coin_giant_gold",
            () -> new MiscCoinItem(GOLD, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_GIANT_NETHERITE = registerItem(
            "collectible_coin_giant_netherite",
            () -> new MiscCoinItem(NETHERITE, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // shulker subset
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SHULKER_COPPER = registerItem(
            "collectible_coin_shulker_copper",
            () -> new MiscCoinItem(COPPER, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SHULKER_IRON = registerItem(
            "collectible_coin_shulker_iron",
            () -> new MiscCoinItem(IRON, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SHULKER_GOLD = registerItem(
            "collectible_coin_shulker_gold",
            () -> new MiscCoinItem(GOLD, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SHULKER_NETHERITE = registerItem(
            "collectible_coin_shulker_netherite",
            () -> new MiscCoinItem(NETHERITE, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // sniffer subset
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SNIFFER_COPPER = registerItem(
            "collectible_coin_sniffer_copper",
            () -> new MiscCoinItem(COPPER, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SNIFFER_IRON = registerItem(
            "collectible_coin_sniffer_iron",
            () -> new MiscCoinItem(IRON, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SNIFFER_GOLD = registerItem(
            "collectible_coin_sniffer_gold",
            () -> new MiscCoinItem(GOLD, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_SNIFFER_NETHERITE = registerItem(
            "collectible_coin_sniffer_netherite",
            () -> new MiscCoinItem(NETHERITE, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // warden subset
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WARDEN_COPPER = registerItem(
            "collectible_coin_warden_copper",
            () -> new MiscCoinItem(COPPER, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WARDEN_IRON = registerItem(
            "collectible_coin_warden_iron",
            () -> new MiscCoinItem(IRON, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WARDEN_GOLD = registerItem(
            "collectible_coin_warden_gold",
            () -> new MiscCoinItem(GOLD, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_WARDEN_NETHERITE = registerItem(
            "collectible_coin_warden_netherite",
            () -> new MiscCoinItem(NETHERITE, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // creaking subset
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CREAKING_COPPER = registerItem(
            "collectible_coin_creaking_copper",
            () -> new MiscCoinItem(COPPER, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CREAKING_IRON = registerItem(
            "collectible_coin_creaking_iron",
            () -> new MiscCoinItem(IRON, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CREAKING_GOLD = registerItem(
            "collectible_coin_creaking_gold",
            () -> new MiscCoinItem(GOLD, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );
    public static final RegistryObject<Item> COLLECTIBLE_COIN_CREAKING_NETHERITE = registerItem(
            "collectible_coin_creaking_netherite",
            () -> new MiscCoinItem(NETHERITE, MISC_COIN_SET,
                    new Item.Properties().stacksTo(1)),
            TabCategory.CURRENCY
    );

    // ----- SPAWN EGGS -----
    public static final RegistryObject<Item> ILLUSIONER_SPAWN_EGG = registerItem(
            "illusioner_spawn_egg",
            () -> new ForgeSpawnEggItem(() -> EntityType.ILLUSIONER,
                    0x6495ED, 0xFFFFFF,
                    new Item.Properties()),
            TabCategory.SPAWN
    );
    public static final RegistryObject<Item> GIANT_SPAWN_EGG = registerItem(
            "giant_spawn_egg",
            () -> new ForgeSpawnEggItem(() -> EntityType.GIANT,
                    7969893, 44975,
                    new Item.Properties()),
            TabCategory.SPAWN
    );
    public static final RegistryObject<Item> NUMISMATIST_SPAWN_EGG = registerItem(
            "numismatist_spawn_egg",
            () -> new ForgeSpawnEggItem(TCEntityTypes.NUMISMATIST,
                    0xFFDC0A, 0x562300,
                    new Item.Properties()),
            TabCategory.SPAWN
    );
    public static final RegistryObject<Item> PIGLINMERCHANT_SPAWN_EGG = registerItem(
            "piglinmerchant_spawn_egg",
            () -> new ForgeSpawnEggItem(TCEntityTypes.PIGLINMERCHANT,
                    0x800000, 0xF9F3A4,
                    new Item.Properties()),
            TabCategory.SPAWN
    );

    // wallet
    public static final RegistryObject<Item> WALLET = registerItem(
            "wallet",
            () -> new WalletItem(new Item.Properties()),
            TabCategory.TOOL
    );

    // tip jar block item
    @SuppressWarnings("unused")
    public static final RegistryObject<Item> TIP_JAR_BLOCK_ITEM = registerItem(
            "tip_jar",
            () -> new TipJarBlockItem(TCBlocks.TIP_JAR_BLOCK.get(),
                    new Item.Properties().stacksTo(1)),
            TabCategory.DECORATIVE
    );

    // coin album block item
    @SuppressWarnings("unused")
    public static final RegistryObject<Item> COIN_ALBUM_BLOCK_ITEM = registerItem(
            "coin_album",
            () -> new CoinAlbumBlockItem(TCBlocks.COIN_ALBUM_BLOCK.get(),
                    new Item.Properties().stacksTo(1)),
            TabCategory.DECORATIVE
    );

    // register item with lang keys
    private static RegistryObject<Item> registerItem(String name, Supplier<Item> supplier, TabCategory category) {
        RegistryObject<Item> item = ITEMS.register(name, supplier);
        ITEM_CATEGORIES.put(item, category);
        return item;
    }

    // register the full list in the class
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}