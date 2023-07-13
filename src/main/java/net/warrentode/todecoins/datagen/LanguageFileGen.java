package net.warrentode.todecoins.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.common.data.LanguageProvider;
import net.warrentode.todecoins.attribute.ModAttributes;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.entity.ModEntityTypes;
import net.warrentode.todecoins.item.ModItems;

import java.util.Map;
import java.util.TreeMap;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class LanguageFileGen extends LanguageProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().setLenient().create();
    private final Map<String, String> data = new TreeMap<>();
    private final DataGenerator generator;
    private final String modid;
    private final String locale;

    public LanguageFileGen(DataGenerator generator, String modid, String locale) {
        super(generator, MODID, locale);
        this.generator = generator;
        this.modid = modid;
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        addItems();
        addAdvancements();
        addAttributes();
        addContainers();
        addVillagers();
        addBlocks();
        addEffect();
        addItemGroups();
        addSubtitles();
        addTooltips();
    }

    private void addItems() {
        // annual coins
        addCollectibleCoins(ModItems.BIRTHDAY_COIN_2023.get().getDescriptionId(), "Birthday Coin 2023");
        addCollectibleCoins(ModItems.HALLOWEEN_COIN_2023.get().getDescriptionId(), "Halloween Coin 2023");
        addCollectibleCoins(ModItems.CHRISTMAS_COIN_2023.get().getDescriptionId(), "Christmas Coin 2023");
        addCollectibleCoins(ModItems.MARSHALL_NASH_CARNATION_COIN.get().getDescriptionId(), "Marshall Nash Carnation Coin");
        addCollectibleCoins(ModItems.MARSHALL_NASH_COSMOS_COIN.get().getDescriptionId(), "Marshall Nash Carnation Coin");
        addCollectibleCoins(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().getDescriptionId(), "Trevor Brannigan Carnation Coin");
        addCollectibleCoins(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().getDescriptionId(), "Trevor Brannigan Cosmos Coin");

        // gameplay coins
        addCollectibleCoins(ModItems.COPPER_COD_COIN.get().getDescriptionId(), "Copper Cod Coin");
        addCollectibleCoins(ModItems.IRON_COD_COIN.get().getDescriptionId(), "Iron Cod Coin");
        addCollectibleCoins(ModItems.GOLD_COD_COIN.get().getDescriptionId(), "Gold Cod Coin");
        addCollectibleCoins(ModItems.NETHERITE_COD_COIN.get().getDescriptionId(), "Netherite Cod Coin");

        addCollectibleCoins(ModItems.COPPER_HERO_COIN.get().getDescriptionId(), "Copper Hero Coin");
        addCollectibleCoins(ModItems.IRON_HERO_COIN.get().getDescriptionId(), "Iron Hero Coin");
        addCollectibleCoins(ModItems.GOLD_HERO_COIN.get().getDescriptionId(), "Gold Hero Coin");
        addCollectibleCoins(ModItems.NETHERITE_HERO_COIN.get().getDescriptionId(), "Netherite Hero Coin");

        addCollectibleCoins(ModItems.COPPER_PUFFERFISH_COIN.get().getDescriptionId(), "Copper Pufferfish Coin");
        addCollectibleCoins(ModItems.IRON_PUFFERFISH_COIN.get().getDescriptionId(), "Iron Pufferfish Coin");
        addCollectibleCoins(ModItems.GOLD_PUFFERFISH_COIN.get().getDescriptionId(), "Gold Pufferfish Coin");
        addCollectibleCoins(ModItems.NETHERITE_PUFFERFISH_COIN.get().getDescriptionId(), "Netherite Pufferfish Coin");

        addCollectibleCoins(ModItems.COPPER_SALMON_COIN.get().getDescriptionId(), "Copper Salmon Coin");
        addCollectibleCoins(ModItems.IRON_SALMON_COIN.get().getDescriptionId(), "Iron Salmon Coin");
        addCollectibleCoins(ModItems.GOLD_SALMON_COIN.get().getDescriptionId(), "Gold Salmon Coin");
        addCollectibleCoins(ModItems.NETHERITE_SALMON_COIN.get().getDescriptionId(), "Netherite Salmon Coin");

        addCollectibleCoins(ModItems.COPPER_TROPICAL_FISH_COIN.get().getDescriptionId(), "Copper Tropical Fish Coin");
        addCollectibleCoins(ModItems.IRON_TROPICAL_FISH_COIN.get().getDescriptionId(), "Iron Tropical Fish Coin");
        addCollectibleCoins(ModItems.GOLD_TROPICAL_FISH_COIN.get().getDescriptionId(), "Gold Tropical Fish Coin");
        addCollectibleCoins(ModItems.NETHERITE_TROPICAL_FISH_COIN.get().getDescriptionId(), "Netherite Tropical Fish Coin");

        // entity coins
        addCollectibleCoins(ModItems.COPPER_ALLAY_COIN.get().getDescriptionId(), "Copper Allay Coin");
        addCollectibleCoins(ModItems.IRON_ALLAY_COIN.get().getDescriptionId(), "Iron Allay Coin");
        addCollectibleCoins(ModItems.GOLD_ALLAY_COIN.get().getDescriptionId(), "Gold Allay Coin");
        addCollectibleCoins(ModItems.NETHERITE_ALLAY_COIN.get().getDescriptionId(), "Netherite Allay Coin");

        addCollectibleCoins(ModItems.COPPER_AXOLOTL_COIN.get().getDescriptionId(), "Copper Axolotl Coin");
        addCollectibleCoins(ModItems.IRON_AXOLOTL_COIN.get().getDescriptionId(), "Iron Axolotl Coin");
        addCollectibleCoins(ModItems.GOLD_AXOLOTL_COIN.get().getDescriptionId(), "Gold Axolotl Coin");
        addCollectibleCoins(ModItems.NETHERITE_AXOLOTL_COIN.get().getDescriptionId(), "Netherite Axolotl Coin");

        addCollectibleCoins(ModItems.COPPER_BAT_COIN.get().getDescriptionId(), "Copper Bat Coin");
        addCollectibleCoins(ModItems.IRON_BAT_COIN.get().getDescriptionId(), "Iron Bat Coin");
        addCollectibleCoins(ModItems.GOLD_BAT_COIN.get().getDescriptionId(), "Gold Bat Coin");
        addCollectibleCoins(ModItems.NETHERITE_BAT_COIN.get().getDescriptionId(), "Netherite Bat Coin");

        addCollectibleCoins(ModItems.COPPER_BEE_COIN.get().getDescriptionId(), "Copper Bee Coin");
        addCollectibleCoins(ModItems.IRON_BEE_COIN.get().getDescriptionId(), "Iron Bee Coin");
        addCollectibleCoins(ModItems.GOLD_BEE_COIN.get().getDescriptionId(), "Gold Bee Coin");
        addCollectibleCoins(ModItems.NETHERITE_BEE_COIN.get().getDescriptionId(), "Netherite Bee Coin");

        addCollectibleCoins(ModItems.COPPER_BLAZE_COIN.get().getDescriptionId(), "Copper Blaze Coin");
        addCollectibleCoins(ModItems.IRON_BLAZE_COIN.get().getDescriptionId(), "Iron Blaze Coin");
        addCollectibleCoins(ModItems.GOLD_BLAZE_COIN.get().getDescriptionId(), "Gold Blaze Coin");
        addCollectibleCoins(ModItems.NETHERITE_BLAZE_COIN.get().getDescriptionId(), "Netherite Blaze Coin");

        addCollectibleCoins(ModItems.COPPER_CAMEL_COIN.get().getDescriptionId(), "Copper Camel Coin");
        addCollectibleCoins(ModItems.IRON_CAMEL_COIN.get().getDescriptionId(), "Iron Camel Coin");
        addCollectibleCoins(ModItems.GOLD_CAMEL_COIN.get().getDescriptionId(), "Gold Camel Coin");
        addCollectibleCoins(ModItems.NETHERITE_CAMEL_COIN.get().getDescriptionId(), "Netherite Camel Coin");

        addCollectibleCoins(ModItems.COPPER_CAT_COIN.get().getDescriptionId(), "Copper Cat Coin");
        addCollectibleCoins(ModItems.IRON_CAT_COIN.get().getDescriptionId(), "Iron Cat Coin");
        addCollectibleCoins(ModItems.GOLD_CAT_COIN.get().getDescriptionId(), "Gold Cat Coin");
        addCollectibleCoins(ModItems.NETHERITE_CAT_COIN.get().getDescriptionId(), "Netherite Cat Coin");

        addCollectibleCoins(ModItems.COPPER_CAVE_SPIDER_COIN.get().getDescriptionId(), "Copper Cave Spider Coin");
        addCollectibleCoins(ModItems.IRON_CAVE_SPIDER_COIN.get().getDescriptionId(), "Iron Cave Spider Coin");
        addCollectibleCoins(ModItems.GOLD_CAVE_SPIDER_COIN.get().getDescriptionId(), "Gold Cave Spider Coin");
        addCollectibleCoins(ModItems.NETHERITE_CAVE_SPIDER_COIN.get().getDescriptionId(), "Netherite Cave Spider Coin");

        addCollectibleCoins(ModItems.COPPER_CHICKEN_COIN.get().getDescriptionId(), "Copper Chicken Coin");
        addCollectibleCoins(ModItems.IRON_CHICKEN_COIN.get().getDescriptionId(), "Iron Chicken Coin");
        addCollectibleCoins(ModItems.GOLD_CHICKEN_COIN.get().getDescriptionId(), "Gold Chicken Coin");
        addCollectibleCoins(ModItems.NETHERITE_CHICKEN_COIN.get().getDescriptionId(), "Netherite Chicken Coin");

        addCollectibleCoins(ModItems.COPPER_COW_COIN.get().getDescriptionId(), "Copper Cow Coin");
        addCollectibleCoins(ModItems.IRON_COW_COIN.get().getDescriptionId(), "Iron Cow Coin");
        addCollectibleCoins(ModItems.GOLD_COW_COIN.get().getDescriptionId(), "Gold Cow Coin");
        addCollectibleCoins(ModItems.NETHERITE_COW_COIN.get().getDescriptionId(), "Netherite Cow Coin");

        addCollectibleCoins(ModItems.COPPER_DONKEY_COIN.get().getDescriptionId(), "Copper Donkey Coin");
        addCollectibleCoins(ModItems.IRON_DONKEY_COIN.get().getDescriptionId(), "Iron Donkey Coin");
        addCollectibleCoins(ModItems.GOLD_DONKEY_COIN.get().getDescriptionId(), "Gold Donkey Coin");
        addCollectibleCoins(ModItems.NETHERITE_DONKEY_COIN.get().getDescriptionId(), "Netherite Donkey Coin");

        addCollectibleCoins(ModItems.COPPER_ENDERMAN_COIN.get().getDescriptionId(), "Copper Enderman Coin");
        addCollectibleCoins(ModItems.IRON_ENDERMAN_COIN.get().getDescriptionId(), "Iron Enderman Coin");
        addCollectibleCoins(ModItems.GOLD_ENDERMAN_COIN.get().getDescriptionId(), "Gold Enderman Coin");
        addCollectibleCoins(ModItems.NETHERITE_ENDERMAN_COIN.get().getDescriptionId(), "Netherite Enderman Coin");

        addCollectibleCoins(ModItems.COPPER_FOX_COIN.get().getDescriptionId(), "Copper Fox Coin");
        addCollectibleCoins(ModItems.IRON_FOX_COIN.get().getDescriptionId(), "Iron Fox Coin");
        addCollectibleCoins(ModItems.GOLD_FOX_COIN.get().getDescriptionId(), "Gold Fox Coin");
        addCollectibleCoins(ModItems.NETHERITE_FOX_COIN.get().getDescriptionId(), "Netherite Fox Coin");

        addCollectibleCoins(ModItems.COPPER_FROG_COIN.get().getDescriptionId(), "Copper Frog Coin");
        addCollectibleCoins(ModItems.IRON_FROG_COIN.get().getDescriptionId(), "Iron Frog Coin");
        addCollectibleCoins(ModItems.GOLD_FROG_COIN.get().getDescriptionId(), "Gold Frog Coin");
        addCollectibleCoins(ModItems.NETHERITE_FROG_COIN.get().getDescriptionId(), "Netherite Frog Coin");

        addCollectibleCoins(ModItems.COPPER_GLOW_SQUID_COIN.get().getDescriptionId(), "Copper Glow Squid Coin");
        addCollectibleCoins(ModItems.IRON_GLOW_SQUID_COIN.get().getDescriptionId(), "Iron Glow Squid Coin");
        addCollectibleCoins(ModItems.GOLD_GLOW_SQUID_COIN.get().getDescriptionId(), "Gold Glow Squid Coin");
        addCollectibleCoins(ModItems.NETHERITE_GLOW_SQUID_COIN.get().getDescriptionId(), "Netherite Glow Squid Coin");

        addCollectibleCoins(ModItems.COPPER_HORSE_COIN.get().getDescriptionId(), "Copper Horse Coin");
        addCollectibleCoins(ModItems.IRON_HORSE_COIN.get().getDescriptionId(), "Iron Horse Coin");
        addCollectibleCoins(ModItems.GOLD_HORSE_COIN.get().getDescriptionId(), "Gold Horse Coin");
        addCollectibleCoins(ModItems.NETHERITE_HORSE_COIN.get().getDescriptionId(), "Netherite Horse Coin");

        addCollectibleCoins(ModItems.COPPER_MOOBLOOM_COIN.get().getDescriptionId(), "Copper Moobloom Coin");
        addCollectibleCoins(ModItems.IRON_MOOBLOOM_COIN.get().getDescriptionId(), "Iron Moobloom Coin");
        addCollectibleCoins(ModItems.GOLD_MOOBLOOM_COIN.get().getDescriptionId(), "Gold Moobloom Coin");
        addCollectibleCoins(ModItems.NETHERITE_MOOBLOOM_COIN.get().getDescriptionId(), "Netherite Moobloom Coin");

        addCollectibleCoins(ModItems.COPPER_MOOSHROOM_COIN.get().getDescriptionId(), "Copper Mooshroom Coin");
        addCollectibleCoins(ModItems.IRON_MOOSHROOM_COIN.get().getDescriptionId(), "Iron Mooshroom Coin");
        addCollectibleCoins(ModItems.GOLD_MOOSHROOM_COIN.get().getDescriptionId(), "Gold Mooshroom Coin");
        addCollectibleCoins(ModItems.NETHERITE_MOOSHROOM_COIN.get().getDescriptionId(), "Netherite Mooshroom Coin");

        addCollectibleCoins(ModItems.COPPER_MULE_COIN.get().getDescriptionId(), "Copper Mule Coin");
        addCollectibleCoins(ModItems.IRON_MULE_COIN.get().getDescriptionId(), "Iron Mule Coin");
        addCollectibleCoins(ModItems.GOLD_MULE_COIN.get().getDescriptionId(), "Gold Mule Coin");
        addCollectibleCoins(ModItems.NETHERITE_MULE_COIN.get().getDescriptionId(), "Netherite Mule Coin");

        addCollectibleCoins(ModItems.COPPER_NUMISMATIST_COIN.get().getDescriptionId(), "Copper Numismatist Coin");
        addCollectibleCoins(ModItems.IRON_NUMISMATIST_COIN.get().getDescriptionId(), "Iron Numismatist Coin");
        addCollectibleCoins(ModItems.GOLD_NUMISMATIST_COIN.get().getDescriptionId(), "Gold Numismatist Coin");
        addCollectibleCoins(ModItems.NETHERITE_NUMISMATIST_COIN.get().getDescriptionId(), "Netherite Numismatist Coin");

        addCollectibleCoins(ModItems.COPPER_OCELOT_COIN.get().getDescriptionId(), "Copper Ocelot Coin");
        addCollectibleCoins(ModItems.IRON_OCELOT_COIN.get().getDescriptionId(), "Iron Ocelot Coin");
        addCollectibleCoins(ModItems.GOLD_OCELOT_COIN.get().getDescriptionId(), "Gold Ocelot Coin");
        addCollectibleCoins(ModItems.NETHERITE_OCELOT_COIN.get().getDescriptionId(), "Netherite Ocelot Coin");

        addCollectibleCoins(ModItems.COPPER_PARROT_COIN.get().getDescriptionId(), "Copper Parrot Coin");
        addCollectibleCoins(ModItems.IRON_PARROT_COIN.get().getDescriptionId(), "Iron Parrot Coin");
        addCollectibleCoins(ModItems.GOLD_PARROT_COIN.get().getDescriptionId(), "Gold Parrot Coin");
        addCollectibleCoins(ModItems.NETHERITE_PARROT_COIN.get().getDescriptionId(), "Netherite Parrot Coin");

        addCollectibleCoins(ModItems.COPPER_PIGLIN_COIN.get().getDescriptionId(), "Copper Piglin Coin");
        addCollectibleCoins(ModItems.IRON_PIGLIN_COIN.get().getDescriptionId(), "Iron Piglin Coin");
        addCollectibleCoins(ModItems.GOLD_PIGLIN_COIN.get().getDescriptionId(), "Gold Piglin Coin");
        addCollectibleCoins(ModItems.NETHERITE_PIGLIN_COIN.get().getDescriptionId(), "Netherite Piglin Coin");

        addCollectibleCoins(ModItems.COPPER_SHEEP_COIN.get().getDescriptionId(), "Copper Sheep Coin");
        addCollectibleCoins(ModItems.IRON_SHEEP_COIN.get().getDescriptionId(), "Iron Sheep Coin");
        addCollectibleCoins(ModItems.GOLD_SHEEP_COIN.get().getDescriptionId(), "Gold Sheep Coin");
        addCollectibleCoins(ModItems.NETHERITE_SHEEP_COIN.get().getDescriptionId(), "Netherite Sheep Coin");

        addCollectibleCoins(ModItems.COPPER_SKELETON_HORSE_COIN.get().getDescriptionId(), "Copper Skeleton Horse Coin");
        addCollectibleCoins(ModItems.IRON_SKELETON_HORSE_COIN.get().getDescriptionId(), "Iron Skeleton Horse Coin");
        addCollectibleCoins(ModItems.GOLD_SKELETON_HORSE_COIN.get().getDescriptionId(), "Gold Skeleton Horse Coin");
        addCollectibleCoins(ModItems.NETHERITE_SKELETON_HORSE_COIN.get().getDescriptionId(), "Netherite Skeleton Horse Coin");

        addCollectibleCoins(ModItems.COPPER_SNIFFER_COIN.get().getDescriptionId(), "Copper Sniffer Coin");
        addCollectibleCoins(ModItems.IRON_SNIFFER_COIN.get().getDescriptionId(), "Iron Sniffer Coin");
        addCollectibleCoins(ModItems.GOLD_SNIFFER_COIN.get().getDescriptionId(), "Gold Sniffer Coin");
        addCollectibleCoins(ModItems.NETHERITE_SNIFFER_COIN.get().getDescriptionId(), "Netherite Sniffer Coin");

        addCollectibleCoins(ModItems.COPPER_SNOW_GOLEM_COIN.get().getDescriptionId(), "Copper Snow Golem Coin");
        addCollectibleCoins(ModItems.IRON_SNOW_GOLEM_COIN.get().getDescriptionId(), "Iron Snow Golem Coin");
        addCollectibleCoins(ModItems.GOLD_SNOW_GOLEM_COIN.get().getDescriptionId(), "Gold Snow Golem Coin");
        addCollectibleCoins(ModItems.NETHERITE_SNOW_GOLEM_COIN.get().getDescriptionId(), "Netherite Snow Golem Coin");

        addCollectibleCoins(ModItems.COPPER_SQUID_COIN.get().getDescriptionId(), "Copper Squid Coin");
        addCollectibleCoins(ModItems.IRON_SQUID_COIN.get().getDescriptionId(), "Iron Squid Coin");
        addCollectibleCoins(ModItems.GOLD_SQUID_COIN.get().getDescriptionId(), "Gold Squid Coin");
        addCollectibleCoins(ModItems.NETHERITE_SQUID_COIN.get().getDescriptionId(), "Netherite Squid Coin");

        addCollectibleCoins(ModItems.COPPER_STRIDER_COIN.get().getDescriptionId(), "Copper Strider Coin");
        addCollectibleCoins(ModItems.IRON_STRIDER_COIN.get().getDescriptionId(), "Iron Strider Coin");
        addCollectibleCoins(ModItems.GOLD_STRIDER_COIN.get().getDescriptionId(), "Gold Strider Coin");
        addCollectibleCoins(ModItems.NETHERITE_STRIDER_COIN.get().getDescriptionId(), "Netherite Strider Coin");

        addCollectibleCoins(ModItems.COPPER_TADPOLE_COIN.get().getDescriptionId(), "Copper Tadpole Coin");
        addCollectibleCoins(ModItems.IRON_TADPOLE_COIN.get().getDescriptionId(), "Iron Tadpole Coin");
        addCollectibleCoins(ModItems.GOLD_TADPOLE_COIN.get().getDescriptionId(), "Gold Tadpole Coin");
        addCollectibleCoins(ModItems.NETHERITE_TADPOLE_COIN.get().getDescriptionId(), "Netherite Tadpole Coin");

        addCollectibleCoins(ModItems.COPPER_TURTLE_COIN.get().getDescriptionId(), "Copper Turtle Coin");
        addCollectibleCoins(ModItems.IRON_TURTLE_COIN.get().getDescriptionId(), "Iron Turtle Coin");
        addCollectibleCoins(ModItems.GOLD_TURTLE_COIN.get().getDescriptionId(), "Gold Turtle Coin");
        addCollectibleCoins(ModItems.NETHERITE_TURTLE_COIN.get().getDescriptionId(), "Netherite Turtle Coin");

        addCollectibleCoins(ModItems.COPPER_VILLAGER_COIN.get().getDescriptionId(), "Copper Villager Coin");
        addCollectibleCoins(ModItems.IRON_VILLAGER_COIN.get().getDescriptionId(), "Iron Villager Coin");
        addCollectibleCoins(ModItems.GOLD_VILLAGER_COIN.get().getDescriptionId(), "Gold Villager Coin");
        addCollectibleCoins(ModItems.NETHERITE_VILLAGER_COIN.get().getDescriptionId(), "Netherite Villager Coin");

        addCollectibleCoins(ModItems.COPPER_WANDERING_TRADER_COIN.get().getDescriptionId(), "Copper Wandering Trader Coin");
        addCollectibleCoins(ModItems.IRON_WANDERING_TRADER_COIN.get().getDescriptionId(), "Iron Wandering Trader Coin");
        addCollectibleCoins(ModItems.GOLD_WANDERING_TRADER_COIN.get().getDescriptionId(), "Gold Wandering Trader Coin");
        addCollectibleCoins(ModItems.NETHERITE_WANDERING_TRADER_COIN.get().getDescriptionId(), "Netherite Wandering Trader Coin");

        addCollectibleCoins(ModItems.COPPER_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Copper Zombie Horse Coin");
        addCollectibleCoins(ModItems.IRON_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Iron Zombie Horse Coin");
        addCollectibleCoins(ModItems.GOLD_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Gold Zombie Horse Coin");
        addCollectibleCoins(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Netherite Zombie Horse Coin");

        // regular mod items
        add(ModItems.NUMISMATIST_SPAWN_EGG.get(), "Numismatist Spawn Egg");
        add(ModItems.SNOW_GOLEM_SPAWN_EGG.get(), "Snow Golem Spawn Egg");
        add(ModItems.FOUR_LEAF_CLOVER.get(), "Four Leaf Clover");
        add(ModItems.CURRENCY_STAMP.get(), "Currency Stamp");
        add(ModItems.NETHER_CURRENCY_STAMP.get(), "Nether Currency Stamp");
        add(ModItems.COPPER_NUGGET.get(), "Copper Nugget");
        add(ModItems.NETHERITE_NUGGET.get(), "Netherite Nugget");
        add(ModItems.LUCKY_NUGGET.get(), "Lucky Nugget");
        add(ModItems.COPPER_COIN.get(), "Copper Coin");
        add(ModItems.IRON_COIN.get(), "Iron Coin");
        add(ModItems.GOLD_COIN.get(), "Gold Coin");
        add(ModItems.NETHERITE_COIN.get(), "Netherite Coin");
        add(ModItems.LUCKY_COIN.get(), "Lucky Coin");
        add(ModItems.NETHER_GOLD_COIN.get(), "Nether Gold Coin");
        add(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), "Emerald Quarter Bank Note");
        add(ModItems.EMERALD_HALF_BANK_NOTE.get(), "Emerald Half Bank Note");
        add(ModItems.EMERALD_BANK_NOTE.get(), "Emerald Bank Note");
        add(ModItems.EMERALD_FIBER.get(), "Emerald Fiber");
        add(ModItems.LUCKY_FIBER.get(), "Lucky Fiber");
        add(ModItems.LUCKY_THREAD.get(), "Lucky Thread");
        add(ModItems.LUCKY_FABRIC.get(), "Lucky Fabric");
        add(ModItems.EMERALD_WOVE_PAPER.get(), "Emerald Wove Paper");
        add(ModItems.EMERALD_COARSE_WOVE_PAPER.get(), "Emerald Coarse Wove Paper");
        add(ModItems.EMERALD_SMOOTH_WOVE_PAPER.get(), "Emerald Smooth Wove Paper");
        add(ModItems.LUCKY_BOOTS.get(), "Lucky Boots");
        add(ModItems.LUCKY_PANTS.get(), "Lucky Pants");
        add(ModItems.LUCKY_SHIRT.get(), "Lucky Shirt");
        add(ModItems.LUCKY_HAT.get(), "Lucky Hat");
    }

    private void addCollectibleCoins(String id, String name) {
        // name
        add(id, "Collectible " + name);
        // advancement
        add("advancement.find_" + id, "Obtain the " + name);
    }

    private void addAdvancements() {
        add("advancement.root", "Tode Coins Advancements");
        add("advancement.root.desc", "Tode Coins Advancement Description");
        add("advancement.craftCoinPress", "Start Minting");
        add("advancement.craftCoinPress.desc", "Obtain a Coin Press");
        add("advancement.mintingCoins", "Minting Coins");
        add("advancement.mintingCoins.desc", "Mint all the standard Overworld coins");
        add("advancement.baggingDough", "Bagging Dough");
        add("advancement.baggingDough.desc", "Craft all the Bagged Currency");
        add("advancement.printingMoney", "Printing Money");
        add("advancement.printingMoney.desc", "Mint all the bank notes");
        add("advancement.rainbowEnd", "End of the Rainbow");
        add("advancement.rainbowEnd.desc", "Obtain a Pot of Gold");
        add("advancement.netherDough", "Nether Dough");
        add("advancement.netherDough.desc", "Obtain a Nether Coin");
        add("advancement.luckyClover", "Lucky Clover");
        add("advancement.luckyClover.desc", "Find a Four-Leaf Clover");
        add("advancement.luckyPenny", "Lucky Penny");
        add("advancement.luckyPenny.desc", "Obtain a Lucky Coin");
        add("advancement.textileEngineering1", "Emerald Textile Engineering");
        add("advancement.textileEngineering1.desc", "Craft all the Emerald Fibers and Papers");
        add("advancement.textileEngineering2", "Lucky Textile Engineering");
        add("advancement.textileEngineering2.desc", "Craft the Lucky Fiber and Fabric");
        add("advancement.luckyArmor", "Feeling Lucky?");
        add("advancement.luckyArmor.desc", "Obtain a full set of Lucky Armor");

        add("advancement.collectibleCoins", "Collectible Coins");
        add("advancement.collectibleCoins.desc", "Find All the Collectible Coins!");

        add("advancement.dependency.condition.spawn_egg_recipes", "Conditional Spawn Egg Recipes for the Cagerium Mod");
        add("advancement.dependency.condition.spawn_egg_recipes.desc", "Available Only when the Cagerium mod is Loaded");

        add("advancement.dependency.spawn_egg_recipes.allay_spawn_egg", "Allay Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.axolotl_spawn_egg", "Axolotl Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.bat_spawn_egg", "Bat Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.blaze_spawn_egg", "Blaze Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.cat_spawn_egg", "Cat Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.cave_spider_spawn_egg", "Cave Spider Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.chicken_spawn_egg", "Chicken Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.cod_spawn_egg", "Cod Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.cow_spawn_egg", "Cow Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.donkey_spawn_egg", "Donkey Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.enderman_spawn_egg", "Enderman Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.fox_spawn_egg", "Fox Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.frog_spawn_egg", "Frog Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.glow_squid_spawn_egg", "Glow Squid Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.hoglin_spawn_egg", "Hoglin Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.horse_spawn_egg", "Horse Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.mooshroom_spawn_egg", "Mooshroom Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.mule_spawn_egg", "Mule Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.numismatist_spawn_egg", "Numismatist Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.ocelot_spawn_egg", "Ocelot Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.parrot_spawn_egg", "Parrot Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.pig_spawn_egg", "Pig Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.piglin_spawn_egg", "Piglin Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.pufferfish_spawn_egg", "Pufferfish Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.rabbit_spawn_egg", "Rabbit Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.salmon_spawn_egg", "Salmon Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.sheep_spawn_egg", "Sheep Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.skeleton_horse_spawn_egg", "Skeleton Horse Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.strider_spawn_egg", "Strider Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.squid_spawn_egg", "Squid Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.tadpole_spawn_egg", "Tadpole Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.tropical_fish_spawn_egg", "Tropical Fish Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.villager_spawn_egg", "Villager Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.wandering_trader_spawn_egg", "Wandering Trader Spawn Egg Recipe");
        add("advancement.dependency.spawn_egg_recipes.zombie_horse_spawn_egg", "Zombie Horse Spawn Egg Recipe");
    }

    private void addTooltips() {
        add("tooltips.textile_item.hover", "Textiles are used to make materials like paper and fabric.");
        add("tooltips.lucky_coin.hover", "Smells like fresh clover, what an unusual coin...");
        add("tooltips.four_leaf_clover.hover", "Many people believe this is a lucky charm...");
        add("tooltips.barter_coin_item.hover", "Anthropological evidence suggests bartering actually occurs when currency isn't readily available.");
        add("tooltips.bank_note_item.hover", "The original bank notes were created by China and worked much like our debit cards today.");
        add("tooltips.coin_item.hover", "Since ancient times, coins were either stamped or forged into molds.");
        add("tooltips.coin_stamp.hover", "This is for stamping currency in a press.");

        // passive entity collectible coin bases
        add("tooltips.collectible_feline_coin.hover", "One of Eight Feline Seasonal Coins");
        add("tooltips.collectible_squid_coin.hover", "One of Eight Squid Seasonal Coins");
        add("tooltips.collectible_golem_coin.hover", "One of Eight Sheep Seasonal Coins");
        add("tooltips.collectible_trader_coin.hover", "One of Eight Trader Seasonal Coins");

        add("tooltips.collectible_bovine_coin.hover", "One of Twelve Bovine Seasonal Coins");
        add("tooltips.collectible_equine_coin.hover", "One of Twenty Equine Seasonal Coins");

        add("tooltips.collectible_allay_coin.hover", "One of Four Allay Seasonal Coins");
        add("tooltips.collectible_axolotl_coin.hover", "One of Four Axolotl Seasonal Coins");
        add("tooltips.collectible_bat_coin.hover", "One of Four Bat Seasonal Coins");
        add("tooltips.collectible_camel_coin.hover", "One of Four Camel Seasonal Coins");
        add("tooltips.collectible_chicken_coin.hover", "One of Four Chicken Seasonal Coins");
        add("tooltips.collectible_fox_coin.hover", "One of Four Fox Seasonal Coins");
        add("tooltips.collectible_frog_coin.hover", "One of Four Frog Seasonal Coins");
        add("tooltips.collectible_parrot_coin.hover", "One of Four Parrot Seasonal Coins");
        add("tooltips.collectible_pig_coin.hover", "One of Four Pig Seasonal Coins");
        add("tooltips.collectible_rabbit_coin.hover", "One of Four Rabbit Seasonal Coins");
        add("tooltips.collectible_sheep_coin.hover", "One of Four Sheep Seasonal Coins");
        add("tooltips.collectible_sniffer_coin.hover", "One of Four Sniffer Seasonal Coins");
        add("tooltips.collectible_strider_coin.hover", "One of Four Strider Seasonal Coins");
        add("tooltips.collectible_tadpole_coin.hover", "One of Four Tadpole Seasonal Coins");
        add("tooltips.collectible_turtle_coin.hover", "One of Four Turtle Seasonal Coins");
        add("tooltips.collectible_villager_coin.hover", "One of Four Villager Seasonal Coins");

        // neutral entity collectible coin bases
        add("tooltips.collectible_bee_coin.hover", "One of Four Bee Seasonal Coins");
        add("tooltips.collectible_cave_spider_coin.hover", "One of Four Cave Spider Seasonal Coins");
        add("tooltips.collectible_enderman_coin.hover", "One of Four Enderman Seasonal Coins");
        add("tooltips.collectible_piglin_coin.hover", "One of Four Piglin Seasonal Coins");

        // hostile entity collectible coin bases
        add("tooltips.collectible_blaze_coin.hover", "One of Four Blaze Seasonal Coins");
        add("tooltips.collectible_hoglin_coin.hover", "One of Four Hoglin Seasonal Coins");

        // gameplay collectible coin bases
        add("tooltips.collectible_hero_coin.hover", "One of Four Hero Seasonal Coins");
        add("tooltips.collectible_fish_coin.hover", "One of Sixteen Fishing Seasonal Coins");

        // holiday collectible coin bases
        add("tooltips.collectible_birthday_coin.hover", "A Birthday Seasonal Coin");
        add("tooltips.collectible_christmas_coin.hover", "A Christmas Seasonal Coin");
        add("tooltips.collectible_halloween_coin.hover", "A Halloween Seasonal Coin");

        // annual patron coin bases
        add("tooltips.collectible_patron_coin.hover", "A collectible coin to publicly honor, acknowledge, and appreciate those that support my work");
        add("tooltips.collectible_coin_carnation.hover", "This coin celebrates the 1st year anniversary of this supporter");
        add("tooltips.collectible_coin_cosmos.hover", "This coin celebrates the 2nd year anniversary of this supporter");

        // all collectible coin bases
        add("tooltips.collectible_coin.hover", "These types of coins aren't used as currency, but are instead collected and traded for their unique value");
    }

    private void addBlocks() {
        add(ModBlocks.COPPER_COIN_BAG.get(), "Copper Coin Bag");
        add(ModBlocks.IRON_COIN_BAG.get(), "Iron Coin Bag");
        add(ModBlocks.GOLD_COIN_BAG.get(), "Gold Coin Bag");
        add(ModBlocks.NETHERITE_COIN_BAG.get(), "Netherite Coin Bag");
        add(ModBlocks.NETHER_GOLD_COIN_BAG.get(), "Netherite Gold Coin Bag");
        add(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get(), "Emerald Quarter Bank Note Bag");
        add(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get(), "Emerald Half Bank Note Bag");
        add(ModBlocks.EMERALD_BANK_NOTE_BAG.get(), "Emerald Bank Note Bag");
        add(ModBlocks.POT_OF_GOLD.get(), "Pot of Gold");
        add(ModBlocks.COINPRESSBLOCK.get(), "Coin Press");
    }

    private void addVillagers() {
        add(ModEntityTypes.NUMISMATIST.get(), "Numismatist");
        add("entity.minecraft.villager.todecoins.banker", "Banker");
        add("entity.minecraft.villager.todecoins.leprechaun", "Leprechaun");
    }

    private void addContainers() {
        add("container.coin_press_block_gui", "Coin Press");
        add("container.recipe_book.coin_press", "Coin Press Recipe Book");
    }

    private void addSubtitles() {
        add("subtitles.todecoins.work_banker", "Banker Works");
        add("subtitles.todecoins.work_leprechaun", "Leprechaun Works");
        add("subtitles.todecoins.coin_press_take", "Coin Press Cashes Out");
        add("subtitles.todecoins.coin_press_use", "Coin Press Used");
    }

    private void addAttributes() {
        add(ModAttributes.CHARISMA.get().getDescriptionId(), "Charisma");
    }

    private void addItemGroups() {
        add("itemGroup.todecoinstab", "TodeCoins Main Tab");
        add("itemGroup.collectorcoinstab", "TodeCoins Collectible Coins");
    }

    private void addEffect() {
        add(MobEffects.LUCK, "Luck");
        add(MobEffects.UNLUCK, "Bad Luck");

        addPotionEffects(MobEffects.LUCK.getDescriptionId(), "Luck");
        addPotionEffects(MobEffects.UNLUCK.getDescriptionId(), "Bad Luck");
    }

    private void addPotionEffects(String id, String name) {
        // regular potion of normal effect
        add("item.minecraft.potion." + id, "Potion of " + name);
        add("item.minecraft.potion." + id + "_2", "Potion of " + name + " II");
        add("item.minecraft.potion." + id + "_3", "Potion of " + name + " III");
        add("item.minecraft.potion." + id + "_4", "Potion of " + name + " IV");
        add("item.minecraft.potion." + id + "_5", "Potion of " + name + " V");
        add("item.minecraft.potion." + id + "_6", "Potion of " + name + " VI");

        // regular potion of extended effect
        add("item.minecraft.potion.long_" + id, "Potion of Extended " + name);
        add("item.minecraft.potion.long_" + id + "_2", "Potion of Extended " + name + " II");
        add("item.minecraft.potion.long_" + id + "_3", "Potion of Extended " + name + " III");
        add("item.minecraft.potion.long_" + id + "_4", "Potion of Extended " + name + " IV");
        add("item.minecraft.potion.long_" + id + "_5", "Potion of Extended " + name + " V");
        add("item.minecraft.potion.long_" + id + "_6", "Potion of Extended " + name + " VI");

        // splash potion of normal effect
        add("item.minecraft.splash_potion." + id, "Splash Potion of " + name);
        add("item.minecraft.splash_potion." + id + "_2", "Splash Potion of " + name + " II");
        add("item.minecraft.splash_potion." + id + "_3", "Splash Potion of " + name + " III");
        add("item.minecraft.splash_potion." + id + "_4", "Splash Potion of " + name + " IV");
        add("item.minecraft.splash_potion." + id + "_5", "Splash Potion of " + name + " V");
        add("item.minecraft.splash_potion." + id + "_6", "Splash Potion of " + name + " VI");

        // splash potion of extended effect
        add("item.minecraft.splash_potion.long_" + id, "Splash Potion of Extended " + name);
        add("item.minecraft.splash_potion.long_" + id + "_2", "Splash Potion of Extended " + name + " II");
        add("item.minecraft.splash_potion.long_" + id + "_3", "Splash Potion of Extended " + name + " III");
        add("item.minecraft.splash_potion.long_" + id + "_4", "Splash Potion of Extended " + name + " IV");
        add("item.minecraft.splash_potion.long_" + id + "_5", "Splash Potion of Extended " + name + " V");
        add("item.minecraft.splash_potion.long_" + id + "_6", "Splash Potion of Extended " + name + " VI");

        // lingering potion of normal effect
        add("item.minecraft.lingering_potion." + id, "Lingering Potion of " + name);
        add("item.minecraft.lingering_potion." + id + "_2", "Lingering Potion of " + name + " II");
        add("item.minecraft.lingering_potion." + id + "_3", "Lingering Potion of " + name + " III");
        add("item.minecraft.lingering_potion." + id + "_4", "Lingering Potion of " + name + " IV");
        add("item.minecraft.lingering_potion." + id + "_5", "Lingering Potion of " + name + " V");
        add("item.minecraft.lingering_potion." + id + "_6", "Lingering Potion of " + name + " VI");

        // lingering potion of extended effect
        add("item.minecraft.lingering_potion.long_" + id, "Lingering Potion of Extended " + name);
        add("item.minecraft.lingering_potion.long_" + id + "_2", "Lingering Potion of Extended " + name + " II");
        add("item.minecraft.lingering_potion.long_" + id + "_3", "Lingering Potion of Extended " + name + " III");
        add("item.minecraft.lingering_potion.long_" + id + "_4", "Lingering Potion of Extended " + name + " IV");
        add("item.minecraft.lingering_potion.long_" + id + "_5", "Lingering Potion of Extended " + name + " V");
        add("item.minecraft.lingering_potion.long_" + id + "_6", "Lingering Potion of Extended " + name + " VI");

        // tipped arrow of normal effect
        add("item.minecraft.tipped_arrow." + id, "Arrow of " + name);
        add("item.minecraft.tipped_arrow." + id + "_2", "Arrow of " + name + " II");
        add("item.minecraft.tipped_arrow." + id + "_3", "Arrow of " + name + " III");
        add("item.minecraft.tipped_arrow." + id + "_4", "Arrow of " + name + " IV");
        add("item.minecraft.tipped_arrow." + id + "_5", "Arrow of " + name + " V");
        add("item.minecraft.tipped_arrow." + id + "_6", "Arrow of " + name + " VI");

        // tipped arrow of extended effect
        add("item.minecraft.tipped_arrow.long_" + id, "Arrow of Extended " + name);
        add("item.minecraft.tipped_arrow.long_" + id + "_2", "Arrow of Extended " + name + " II");
        add("item.minecraft.tipped_arrow.long_" + id + "_3", "Arrow of Extended " + name + " III");
        add("item.minecraft.tipped_arrow.long_" + id + "_4", "Arrow of Extended " + name + " IV");
        add("item.minecraft.tipped_arrow.long_" + id + "_5", "Arrow of Extended " + name + " V");
        add("item.minecraft.tipped_arrow.long_" + id + "_6", "Arrow of Extended " + name + " VI");
    }
}