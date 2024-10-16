package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.effect.ModEffects;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.util.PlayerUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.LanguageProvider;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.TreeMap;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class LanguageFileGen extends LanguageProvider {
    @SuppressWarnings("unused")
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().setLenient().create();
    @SuppressWarnings("unused")
    private final Map<String, String> data = new TreeMap<>();

    public LanguageFileGen(DataGenerator generator, String ignoredModid, String locale) {
        super(generator, MODID, locale);
    }

    @Override
    protected void addTranslations() {
        addItems();
        addAdvancements();
        addAttributes();
        addContainers();
        addEntities();
        addBlocks();
        addEffect();
        addItemGroups();
        addSubtitles();
        addTooltips();
        addFriendshipBracelets();
    }

    private void addFriendshipBracelets() {
        add("tooltips.bracelet_not_linked", "This bracelet is not yet linked to anyone. First time use will link it to the user.");
        add("tooltips.bracelet_linked_player", "This bracelet is linked to: ");
        add("tooltips.bracelet_use_info", "If this bracelet is linked to you, use it to teleport to your spawn point. Otherwise, use it to teleport to the player it's linked to.");

        add(ModItems.BRACELET_FRIENDSHIP_EMERALD.get(), "Emerald Friendship Bracelet");
        fillInBraceletTranslations(ModItems.BRACELET_FRIENDSHIP_EMERALD.get().getDefaultInstance());

        add(ModItems.BRACELET_FRIENDSHIP_ENDONIAN.get(), "Endonian Friendship Bracelet");
        fillInBraceletTranslations(ModItems.BRACELET_FRIENDSHIP_ENDONIAN.get().getDefaultInstance());

        add(ModItems.BRACELET_FRIENDSHIP_ECHO.get(), "Echo Friendship Bracelet");
        fillInBraceletTranslations(ModItems.BRACELET_FRIENDSHIP_ECHO.get().getDefaultInstance());

        add(ModItems.BRACELET_FRIENDSHIP_LUCKY.get(), "Lucky Friendship Bracelet");
        fillInBraceletTranslations(ModItems.BRACELET_FRIENDSHIP_LUCKY.get().getDefaultInstance());
    }

    private void fillInBraceletTranslations(@NotNull ItemStack stack) {
        add(stack.getDescriptionId() + "." + PlayerUtil.BRACELET_MAKER_TAG, "§cLinked player§r %s");
        add(stack.getDescriptionId() + ".offline", "§cLinked player§r %s §cis offline. Teleport aborted.§r");
        add(stack.getDescriptionId() + ".linked", "This bracelet is linked to you!");
    }

    private void addItems() {
        // annual coins
        addCollectibleCoins(ModItems.BIRTHDAY_COIN.get().getDescriptionId(), "Birthday Coin",
                "Holiday Coin Set", 1, 5);
        addCollectibleCoins(ModItems.HALLOWEEN_COIN.get().getDescriptionId(), "Halloween Coin",
                "Holiday Coin Set", 2, 5);
        addCollectibleCoins(ModItems.CHRISTMAS_COIN.get().getDescriptionId(), "Christmas Coin",
                "Holiday Coin Set", 3, 5);
        addCollectibleCoins(ModItems.EASTER_COIN.get().getDescriptionId(), "Easter Coin",
                "Holiday Coin Set", 4, 5);
        addCollectibleCoins(ModItems.NEW_YEAR_COIN.get().getDescriptionId(), "New Year Coin",
                "Holiday Coin Set", 5, 5);

        addCollectibleCoins(ModItems.SCHOLAR_OWL_COIN.get().getDescriptionId(), "Scholar Owl Lifetime Coin",
                "LifeTime Patron Coin Set", 1, 3);
        addCollectibleCoins(ModItems.TUXEDO_CAT_COIN.get().getDescriptionId(), "Tuxedo Cat Lifetime Coin",
                "LifeTime Patron Coin Set", 2, 3);
        addCollectibleCoins(ModItems.LITTLE_BEAR_COIN.get().getDescriptionId(), "Little Bear Lifetime Coin",
                "LifeTime Patron Coin Set", 3, 3);

        addCollectibleCoins(ModItems.MARSHALL_NASH_CARNATION_COIN.get().getDescriptionId(), "Marshall Nash Carnation Coin",
                "Nash Patron Coin Set", 1, 3);
        addCollectibleCoins(ModItems.MARSHALL_NASH_COSMOS_COIN.get().getDescriptionId(), "Marshall Nash Cosmos Coin",
                "Nash Patron Coin Set", 2, 3);
        addCollectibleCoins(ModItems.MARSHALL_NASH_SUNFLOWER_COIN.get().getDescriptionId(), "Marshall Nash Sunflower Coin",
                "Nash Patron Coin Set", 3, 3);

        addCollectibleCoins(ModItems.TREVOR_BRANNIGAN_CARNATION_COIN.get().getDescriptionId(), "Trevor Brannigan Carnation Coin",
                "Brannigan Patron Coin Set", 1, 2);
        addCollectibleCoins(ModItems.TREVOR_BRANNIGAN_COSMOS_COIN.get().getDescriptionId(), "Trevor Brannigan Cosmos Coin",
                "Brannigan Patron Coin Set", 2, 2);

        // gameplay coins

        addCollectibleCoins(ModItems.COPPER_HERO_COIN.get().getDescriptionId(), "Copper Hero Coin",
                "Hero Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_HERO_COIN.get().getDescriptionId(), "Iron Hero Coin",
                "Hero Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_HERO_COIN.get().getDescriptionId(), "Gold Hero Coin",
                "Hero Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_HERO_COIN.get().getDescriptionId(), "Netherite Hero Coin",
                "Hero Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_COD_COIN.get().getDescriptionId(), "Copper Cod Coin",
                "Cod Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_COD_COIN.get().getDescriptionId(), "Iron Cod Coin",
                "Cod Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_COD_COIN.get().getDescriptionId(), "Gold Cod Coin",
                "Cod Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_COD_COIN.get().getDescriptionId(), "Netherite Cod Coin",
                "Cod Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_PUFFERFISH_COIN.get().getDescriptionId(), "Copper Pufferfish Coin",
                "Pufferfish Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PUFFERFISH_COIN.get().getDescriptionId(), "Iron Pufferfish Coin",
                "Pufferfish Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PUFFERFISH_COIN.get().getDescriptionId(), "Gold Pufferfish Coin",
                "Pufferfish Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PUFFERFISH_COIN.get().getDescriptionId(), "Netherite Pufferfish Coin",
                "Pufferfish Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SALMON_COIN.get().getDescriptionId(), "Copper Salmon Coin",
                "Salmon Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SALMON_COIN.get().getDescriptionId(), "Iron Salmon Coin",
                "Salmon Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SALMON_COIN.get().getDescriptionId(), "Gold Salmon Coin",
                "Salmon Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SALMON_COIN.get().getDescriptionId(), "Netherite Salmon Coin",
                "Salmon Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_TROPICAL_FISH_COIN.get().getDescriptionId(), "Copper Tropical Fish Coin",
                "Tropical Fish Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_TROPICAL_FISH_COIN.get().getDescriptionId(), "Iron Tropical Fish Coin",
                "Tropical Fish Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_TROPICAL_FISH_COIN.get().getDescriptionId(), "Gold Tropical Fish Coin",
                "Tropical Fish Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_TROPICAL_FISH_COIN.get().getDescriptionId(), "Netherite Tropical Fish Coin",
                "Tropical Fish Coin Set", 4, 4);

        // entity coins
        addCollectibleCoins(ModItems.COPPER_ALLAY_COIN.get().getDescriptionId(), "Copper Allay Coin",
                "Allay Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ALLAY_COIN.get().getDescriptionId(), "Iron Allay Coin",
                "Allay Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ALLAY_COIN.get().getDescriptionId(), "Gold Allay Coin",
                "Allay Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ALLAY_COIN.get().getDescriptionId(), "Netherite Allay Coin",
                "Allay Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_AXOLOTL_COIN.get().getDescriptionId(), "Copper Axolotl Coin",
                "Axolotl Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_AXOLOTL_COIN.get().getDescriptionId(), "Iron Axolotl Coin",
                "Axolotl Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_AXOLOTL_COIN.get().getDescriptionId(), "Gold Axolotl Coin",
                "Axolotl Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_AXOLOTL_COIN.get().getDescriptionId(), "Netherite Axolotl Coin",
                "Axolotl Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_BAT_COIN.get().getDescriptionId(), "Copper Bat Coin",
                "Bat Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_BAT_COIN.get().getDescriptionId(), "Iron Bat Coin",
                "Bat Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_BAT_COIN.get().getDescriptionId(), "Gold Bat Coin",
                "Bat Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_BAT_COIN.get().getDescriptionId(), "Netherite Bat Coin",
                "Bat Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_BEE_COIN.get().getDescriptionId(), "Copper Bee Coin",
                "Bee Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_BEE_COIN.get().getDescriptionId(), "Iron Bee Coin",
                "Bee Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_BEE_COIN.get().getDescriptionId(), "Gold Bee Coin",
                "Bee Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_BEE_COIN.get().getDescriptionId(), "Netherite Bee Coin",
                "Bee Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_BLAZE_COIN.get().getDescriptionId(), "Copper Blaze Coin",
                "Blaze Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_BLAZE_COIN.get().getDescriptionId(), "Iron Blaze Coin",
                "Blaze Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_BLAZE_COIN.get().getDescriptionId(), "Gold Blaze Coin",
                "Blaze Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_BLAZE_COIN.get().getDescriptionId(), "Netherite Blaze Coin",
                "Blaze Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_CAMEL_COIN.get().getDescriptionId(), "Copper Camel Coin",
                "Camel Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_CAMEL_COIN.get().getDescriptionId(), "Iron Camel Coin",
                "Camel Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_CAMEL_COIN.get().getDescriptionId(), "Gold Camel Coin",
                "Camel Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_CAMEL_COIN.get().getDescriptionId(), "Netherite Camel Coin",
                "Camel Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_CAT_COIN.get().getDescriptionId(), "Copper Cat Coin",
                "Cat Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_CAT_COIN.get().getDescriptionId(), "Iron Cat Coin",
                "Cat Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_CAT_COIN.get().getDescriptionId(), "Gold Cat Coin",
                "Cat Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_CAT_COIN.get().getDescriptionId(), "Netherite Cat Coin",
                "Cat Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_CAVE_SPIDER_COIN.get().getDescriptionId(), "Copper Cave Spider Coin",
                "Cave Spider Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_CAVE_SPIDER_COIN.get().getDescriptionId(), "Iron Cave Spider Coin",
                "Cave Spider Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_CAVE_SPIDER_COIN.get().getDescriptionId(), "Gold Cave Spider Coin",
                "Cave Spider Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_CAVE_SPIDER_COIN.get().getDescriptionId(), "Netherite Cave Spider Coin",
                "Cave Spider Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_CHICKEN_COIN.get().getDescriptionId(), "Copper Chicken Coin",
                "Chicken Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_CHICKEN_COIN.get().getDescriptionId(), "Iron Chicken Coin",
                "Chicken Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_CHICKEN_COIN.get().getDescriptionId(), "Gold Chicken Coin",
                "Chicken Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_CHICKEN_COIN.get().getDescriptionId(), "Netherite Chicken Coin",
                "Chicken Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_COW_COIN.get().getDescriptionId(), "Copper Cow Coin",
                "Cow Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_COW_COIN.get().getDescriptionId(), "Iron Cow Coin",
                "Cow Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_COW_COIN.get().getDescriptionId(), "Gold Cow Coin",
                "Cow Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_COW_COIN.get().getDescriptionId(), "Netherite Cow Coin",
                "Cow Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_CREEPER_COIN.get().getDescriptionId(), "Copper Creeper Coin",
                "Creeper Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_CREEPER_COIN.get().getDescriptionId(), "Iron Creeper Coin",
                "Creeper Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_CREEPER_COIN.get().getDescriptionId(), "Gold Creeper Coin",
                "Creeper Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_CREEPER_COIN.get().getDescriptionId(), "Netherite Creeper Coin",
                "Creeper Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_DOLPHIN_COIN.get().getDescriptionId(), "Copper Dolphin Coin",
                "Dolphin Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_DOLPHIN_COIN.get().getDescriptionId(), "Iron Dolphin Coin",
                "Dolphin Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_DOLPHIN_COIN.get().getDescriptionId(), "Gold Dolphin Coin",
                "Dolphin Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_DOLPHIN_COIN.get().getDescriptionId(), "Netherite Dolphin Coin",
                "Dolphin Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_DONKEY_COIN.get().getDescriptionId(), "Copper Donkey Coin",
                "Donkey Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_DONKEY_COIN.get().getDescriptionId(), "Iron Donkey Coin",
                "Donkey Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_DONKEY_COIN.get().getDescriptionId(), "Gold Donkey Coin",
                "Donkey Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_DONKEY_COIN.get().getDescriptionId(), "Netherite Donkey Coin",
                "Donkey Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_DROWNED_COIN.get().getDescriptionId(), "Copper Drowned Coin",
                "Drowned Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_DROWNED_COIN.get().getDescriptionId(), "Iron Drowned Coin",
                "Drowned Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_DROWNED_COIN.get().getDescriptionId(), "Gold Drowned Coin",
                "Drowned Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_DROWNED_COIN.get().getDescriptionId(), "Netherite Drowned Coin",
                "Drowned Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ELDER_GUARDIAN_COIN.get().getDescriptionId(), "Copper Elder Guardian Coin",
                "Elder Guardian Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ELDER_GUARDIAN_COIN.get().getDescriptionId(), "Iron Elder Guardian Coin",
                "Elder Guardian Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ELDER_GUARDIAN_COIN.get().getDescriptionId(), "Gold Elder Guardian Coin",
                "Elder Guardian Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get().getDescriptionId(), "Netherite Elder Guardian Coin",
                "Elder Guardian Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ENDER_DRAGON_COIN.get().getDescriptionId(), "Copper Ender Dragon Coin",
                "Ender Dragon Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ENDER_DRAGON_COIN.get().getDescriptionId(), "Iron Ender Dragon Coin",
                "Ender Dragon Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ENDER_DRAGON_COIN.get().getDescriptionId(), "Gold Ender Dragon Coin",
                "Ender Dragon Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ENDER_DRAGON_COIN.get().getDescriptionId(), "Netherite Ender Dragon Coin",
                "Ender Dragon Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ENDERMAN_COIN.get().getDescriptionId(), "Copper Enderman Coin",
                "Enderman Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ENDERMAN_COIN.get().getDescriptionId(), "Iron Enderman Coin",
                "Enderman Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ENDERMAN_COIN.get().getDescriptionId(), "Gold Enderman Coin",
                "Enderman Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ENDERMAN_COIN.get().getDescriptionId(), "Netherite Enderman Coin",
                "Enderman Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ENDERMITE_COIN.get().getDescriptionId(), "Copper Endermite Coin",
                "Endermite Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ENDERMITE_COIN.get().getDescriptionId(), "Iron Endermite Coin",
                "Endermite Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ENDERMITE_COIN.get().getDescriptionId(), "Gold Endermite Coin",
                "Endermite Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ENDERMITE_COIN.get().getDescriptionId(), "Netherite Endermite Coin",
                "Endermite Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_EVOKER_COIN.get().getDescriptionId(), "Copper Evoker Coin",
                "Evoker Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_EVOKER_COIN.get().getDescriptionId(), "Iron Evoker Coin",
                "Evoker Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_EVOKER_COIN.get().getDescriptionId(), "Gold Evoker Coin",
                "Evoker Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_EVOKER_COIN.get().getDescriptionId(), "Netherite Evoker Coin",
                "Evoker Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_FOX_COIN.get().getDescriptionId(), "Copper Fox Coin",
                "Fox Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_FOX_COIN.get().getDescriptionId(), "Iron Fox Coin",
                "Fox Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_FOX_COIN.get().getDescriptionId(), "Gold Fox Coin",
                "Fox Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_FOX_COIN.get().getDescriptionId(), "Netherite Fox Coin",
                "Fox Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_FROG_COIN.get().getDescriptionId(), "Copper Frog Coin",
                "Frog Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_FROG_COIN.get().getDescriptionId(), "Iron Frog Coin",
                "Frog Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_FROG_COIN.get().getDescriptionId(), "Gold Frog Coin",
                "Frog Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_FROG_COIN.get().getDescriptionId(), "Netherite Frog Coin",
                "Frog Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_GIANT_COIN.get().getDescriptionId(), "Copper Giant Coin",
                "Giant Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_GIANT_COIN.get().getDescriptionId(), "Iron Giant Coin",
                "Giant Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_GIANT_COIN.get().getDescriptionId(), "Gold Giant Coin",
                "Giant Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_GIANT_COIN.get().getDescriptionId(), "Netherite Giant Coin",
                "Giant Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_GLOW_SQUID_COIN.get().getDescriptionId(), "Copper Glow Squid Coin",
                "Glow Squid Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_GLOW_SQUID_COIN.get().getDescriptionId(), "Iron Glow Squid Coin",
                "Glow Squid Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_GLOW_SQUID_COIN.get().getDescriptionId(), "Gold Glow Squid Coin",
                "Glow Squid Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_GLOW_SQUID_COIN.get().getDescriptionId(), "Netherite Glow Squid Coin",
                "Glow Squid Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_GOAT_COIN.get().getDescriptionId(), "Copper Goat Coin",
                "Goat Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_GOAT_COIN.get().getDescriptionId(), "Iron Goat Coin",
                "Goat Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_GOAT_COIN.get().getDescriptionId(), "Gold Goat Coin",
                "Goat Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_GOAT_COIN.get().getDescriptionId(), "Netherite Goat Coin",
                "Goat Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_GUARDIAN_COIN.get().getDescriptionId(), "Copper Guardian Coin",
                "Guardian Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_GUARDIAN_COIN.get().getDescriptionId(), "Iron Guardian Coin",
                "Guardian Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_GUARDIAN_COIN.get().getDescriptionId(), "Gold Guardian Coin",
                "Guardian Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_GUARDIAN_COIN.get().getDescriptionId(), "Netherite Guardian Coin",
                "Guardian Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_GHAST_COIN.get().getDescriptionId(), "Copper Ghast Coin",
                "Ghast Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_GHAST_COIN.get().getDescriptionId(), "Iron Ghast Coin",
                "Ghast Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_GHAST_COIN.get().getDescriptionId(), "Gold Ghast Coin",
                "Ghast Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_GHAST_COIN.get().getDescriptionId(), "Netherite Ghast Coin",
                "Ghast Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_HOGLIN_COIN.get().getDescriptionId(), "Copper Hoglin Coin",
                "Hoglin Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_HOGLIN_COIN.get().getDescriptionId(), "Iron Hoglin Coin",
                "Hoglin Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_HOGLIN_COIN.get().getDescriptionId(), "Gold Hoglin Coin",
                "Hoglin Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_HOGLIN_COIN.get().getDescriptionId(), "Netherite Hoglin Coin",
                "Hoglin Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_HORSE_COIN.get().getDescriptionId(), "Copper Horse Coin",
                "Horse Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_HORSE_COIN.get().getDescriptionId(), "Iron Horse Coin",
                "Horse Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_HORSE_COIN.get().getDescriptionId(), "Gold Horse Coin",
                "Horse Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_HORSE_COIN.get().getDescriptionId(), "Netherite Horse Coin",
                "Horse Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_HUSK_COIN.get().getDescriptionId(), "Copper Husk Coin",
                "Husk Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_HUSK_COIN.get().getDescriptionId(), "Iron Husk Coin",
                "Husk Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_HUSK_COIN.get().getDescriptionId(), "Gold Husk Coin",
                "Husk Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_HUSK_COIN.get().getDescriptionId(), "Netherite Husk Coin",
                "Husk Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_IRON_GOLEM_COIN.get().getDescriptionId(), "Copper Iron Golem Coin",
                "Iron Golem Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_IRON_GOLEM_COIN.get().getDescriptionId(), "Iron Iron Golem Coin",
                "Iron Golem Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_IRON_GOLEM_COIN.get().getDescriptionId(), "Gold Iron Golem Coin",
                "Iron Golem Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_IRON_GOLEM_COIN.get().getDescriptionId(), "Netherite Iron Golem Coin",
                "Iron Golem Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ILLUSIONER_COIN.get().getDescriptionId(), "Copper Illusioner Coin",
                "Illusioner Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ILLUSIONER_COIN.get().getDescriptionId(), "Iron Illusioner Coin",
                "Illusioner Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ILLUSIONER_COIN.get().getDescriptionId(), "Gold Illusioner Coin",
                "Illusioner Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ILLUSIONER_COIN.get().getDescriptionId(), "Netherite Illusioner Coin",
                "Illusioner Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_LLAMA_COIN.get().getDescriptionId(), "Copper Llama Coin",
                "Llama Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_LLAMA_COIN.get().getDescriptionId(), "Iron Llama Coin",
                "Llama Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_LLAMA_COIN.get().getDescriptionId(), "Gold Llama Coin",
                "Llama Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_LLAMA_COIN.get().getDescriptionId(), "Netherite Llama Coin",
                "Llama Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_MAGMA_CUBE_COIN.get().getDescriptionId(), "Copper Magma Cube Coin",
                "Magma Cube Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_MAGMA_CUBE_COIN.get().getDescriptionId(), "Iron Magma Cube Coin",
                "Magma Cube Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_MAGMA_CUBE_COIN.get().getDescriptionId(), "Gold Magma Cube Coin",
                "Magma Cube Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_MAGMA_CUBE_COIN.get().getDescriptionId(), "Netherite Magma Cube Coin",
                "Magma Cube Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_MOOSHROOM_COIN.get().getDescriptionId(), "Copper Mooshroom Coin",
                "Mooshroom Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_MOOSHROOM_COIN.get().getDescriptionId(), "Iron Mooshroom Coin",
                "Mooshroom Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_MOOSHROOM_COIN.get().getDescriptionId(), "Gold Mooshroom Coin",
                "Mooshroom Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_MOOSHROOM_COIN.get().getDescriptionId(), "Netherite Mooshroom Coin",
                "Mooshroom Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_MULE_COIN.get().getDescriptionId(), "Copper Mule Coin",
                "Mule Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_MULE_COIN.get().getDescriptionId(), "Iron Mule Coin",
                "Mule Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_MULE_COIN.get().getDescriptionId(), "Gold Mule Coin",
                "Mule Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_MULE_COIN.get().getDescriptionId(), "Netherite Mule Coin",
                "Mule Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_NUMISMATIST_COIN.get().getDescriptionId(), "Copper Numismatist Coin",
                "Numismatist Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_NUMISMATIST_COIN.get().getDescriptionId(), "Iron Numismatist Coin",
                "Numismatist Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_NUMISMATIST_COIN.get().getDescriptionId(), "Gold Numismatist Coin",
                "Numismatist Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_NUMISMATIST_COIN.get().getDescriptionId(), "Netherite Numismatist Coin",
                "Numismatist Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_OCELOT_COIN.get().getDescriptionId(), "Copper Ocelot Coin",
                "Ocelot Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_OCELOT_COIN.get().getDescriptionId(), "Iron Ocelot Coin",
                "Ocelot Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_OCELOT_COIN.get().getDescriptionId(), "Gold Ocelot Coin",
                "Ocelot Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_OCELOT_COIN.get().getDescriptionId(), "Netherite Ocelot Coin",
                "Ocelot Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_PANDA_COIN.get().getDescriptionId(), "Copper Panda Coin",
                "Panda Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PANDA_COIN.get().getDescriptionId(), "Iron Panda Coin",
                "Panda Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PANDA_COIN.get().getDescriptionId(), "Gold Panda Coin",
                "Panda Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PANDA_COIN.get().getDescriptionId(), "Netherite Panda Coin",
                "Panda Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_PARROT_COIN.get().getDescriptionId(), "Copper Parrot Coin",
                "Parrot Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PARROT_COIN.get().getDescriptionId(), "Iron Parrot Coin",
                "Parrot Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PARROT_COIN.get().getDescriptionId(), "Gold Parrot Coin",
                "Parrot Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PARROT_COIN.get().getDescriptionId(), "Netherite Parrot Coin",
                "Parrot Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_PHANTOM_COIN.get().getDescriptionId(), "Copper Phantom Coin",
                "Phantom Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PHANTOM_COIN.get().getDescriptionId(), "Iron Phantom Coin",
                "Phantom Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PHANTOM_COIN.get().getDescriptionId(), "Gold Phantom Coin",
                "Phantom Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PHANTOM_COIN.get().getDescriptionId(), "Netherite Phantom Coin",
                "Phantom Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_PIG_COIN.get().getDescriptionId(), "Copper Pig Coin",
                "Pig Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PIG_COIN.get().getDescriptionId(), "Iron Pig Coin",
                "Pig Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PIG_COIN.get().getDescriptionId(), "Gold Pig Coin",
                "Pig Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PIG_COIN.get().getDescriptionId(), "Netherite Pig Coin",
                "Pig Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_PIGLIN_BRUTE_COIN.get().getDescriptionId(), "Copper Piglin Brute Coin",
                "Piglin Brute Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PIGLIN_BRUTE_COIN.get().getDescriptionId(), "Iron Piglin Brute Coin",
                "Piglin Brute Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PIGLIN_BRUTE_COIN.get().getDescriptionId(), "Gold Piglin Brute Coin",
                "Piglin Brute Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get().getDescriptionId(), "Netherite Piglin Brute Coin",
                "Piglin Brute Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_PIGLIN_COIN.get().getDescriptionId(), "Copper Piglin Coin",
                "Piglin Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PIGLIN_COIN.get().getDescriptionId(), "Iron Piglin Coin",
                "Piglin Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PIGLIN_COIN.get().getDescriptionId(), "Gold Piglin Coin",
                "Piglin Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PIGLIN_COIN.get().getDescriptionId(), "Netherite Piglin Coin",
                "Piglin Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_PILLAGER_COIN.get().getDescriptionId(), "Copper Pillager Coin",
                "Pillager Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PILLAGER_COIN.get().getDescriptionId(), "Iron Pillager Coin",
                "Pillager Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PILLAGER_COIN.get().getDescriptionId(), "Gold Pillager Coin",
                "Pillager Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PILLAGER_COIN.get().getDescriptionId(), "Netherite Pillager Coin",
                "Pillager Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_POLAR_BEAR_COIN.get().getDescriptionId(), "Copper Polar Bear Coin",
                "Polar Bear Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_POLAR_BEAR_COIN.get().getDescriptionId(), "Iron Polar Bear Coin",
                "Polar Bear Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_POLAR_BEAR_COIN.get().getDescriptionId(), "Gold Polar Bear Coin",
                "Polar Bear Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_POLAR_BEAR_COIN.get().getDescriptionId(), "Netherite Polar Bear Coin",
                "Polar Bear Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_RABBIT_COIN.get().getDescriptionId(), "Copper Rabbit Coin",
                "Rabbit Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_RABBIT_COIN.get().getDescriptionId(), "Iron Rabbit Coin",
                "Rabbit Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_RABBIT_COIN.get().getDescriptionId(), "Gold Rabbit Coin",
                "Rabbit Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_RABBIT_COIN.get().getDescriptionId(), "Netherite Rabbit Coin",
                "Rabbit Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_RAVAGER_COIN.get().getDescriptionId(), "Copper Ravager Coin",
                "Ravager Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_RAVAGER_COIN.get().getDescriptionId(), "Iron Ravager Coin",
                "Ravager Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_RAVAGER_COIN.get().getDescriptionId(), "Gold Ravager Coin",
                "Ravager Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_RAVAGER_COIN.get().getDescriptionId(), "Netherite Ravager Coin",
                "Ravager Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SHEEP_COIN.get().getDescriptionId(), "Copper Sheep Coin",
                "Sheep Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SHEEP_COIN.get().getDescriptionId(), "Iron Sheep Coin",
                "Sheep Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SHEEP_COIN.get().getDescriptionId(), "Gold Sheep Coin",
                "Sheep Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SHEEP_COIN.get().getDescriptionId(), "Netherite Sheep Coin",
                "Sheep Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SHULKER_COIN.get().getDescriptionId(), "Copper Shulker Coin",
                "Shulker Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SHULKER_COIN.get().getDescriptionId(), "Iron Shulker Coin",
                "Shulker Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SHULKER_COIN.get().getDescriptionId(), "Gold Shulker Coin",
                "Shulker Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SHULKER_COIN.get().getDescriptionId(), "Netherite Shulker Coin",
                "Shulker Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SILVERFISH_COIN.get().getDescriptionId(), "Copper Silverfish Coin",
                "Silverfish Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SILVERFISH_COIN.get().getDescriptionId(), "Iron Silverfish Coin",
                "Silverfish Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SILVERFISH_COIN.get().getDescriptionId(), "Gold Silverfish Coin",
                "Silverfish Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SILVERFISH_COIN.get().getDescriptionId(), "Netherite Silverfish Coin",
                "Silverfish Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SKELETON_COIN.get().getDescriptionId(), "Copper Skeleton Coin",
                "Skeleton Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SKELETON_COIN.get().getDescriptionId(), "Iron Skeleton Coin",
                "Skeleton Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SKELETON_COIN.get().getDescriptionId(), "Gold Skeleton Coin",
                "Skeleton Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SKELETON_COIN.get().getDescriptionId(), "Netherite Skeleton Coin",
                "Skeleton Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SKELETON_HORSE_COIN.get().getDescriptionId(), "Copper Skeleton Horse Coin",
                "Skeleton Horse Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SKELETON_HORSE_COIN.get().getDescriptionId(), "Iron Skeleton Horse Coin",
                "Skeleton Horse Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SKELETON_HORSE_COIN.get().getDescriptionId(), "Gold Skeleton Horse Coin",
                "Skeleton Horse Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SKELETON_HORSE_COIN.get().getDescriptionId(), "Netherite Skeleton Horse Coin",
                "Skeleton Horse Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SLIME_COIN.get().getDescriptionId(), "Copper Slime Coin",
                "Slime Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SLIME_COIN.get().getDescriptionId(), "Iron Slime Coin",
                "Slime Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SLIME_COIN.get().getDescriptionId(), "Gold Slime Coin",
                "Slime Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SLIME_COIN.get().getDescriptionId(), "Netherite Slime Coin",
                "Slime Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SNIFFER_COIN.get().getDescriptionId(), "Copper Sniffer Coin",
                "Sniffer Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SNIFFER_COIN.get().getDescriptionId(), "Iron Sniffer Coin",
                "Sniffer Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SNIFFER_COIN.get().getDescriptionId(), "Gold Sniffer Coin",
                "Sniffer Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SNIFFER_COIN.get().getDescriptionId(), "Netherite Sniffer Coin",
                "Sniffer Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ARMADILLO_COIN.get().getDescriptionId(), "Copper Armadillo Coin",
                "Armadillo Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ARMADILLO_COIN.get().getDescriptionId(), "Iron Armadillo Coin",
                "Armadillo Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ARMADILLO_COIN.get().getDescriptionId(), "Gold Armadillo Coin",
                "Armadillo Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ARMADILLO_COIN.get().getDescriptionId(), "Netherite Armadillo Coin",
                "Armadillo Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SNOW_GOLEM_COIN.get().getDescriptionId(), "Copper Snow Golem Coin",
                "Snow Golem Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SNOW_GOLEM_COIN.get().getDescriptionId(), "Iron Snow Golem Coin",
                "Snow Golem Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SNOW_GOLEM_COIN.get().getDescriptionId(), "Gold Snow Golem Coin",
                "Snow Golem Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SNOW_GOLEM_COIN.get().getDescriptionId(), "Netherite Snow Golem Coin",
                "Snow Golem Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SPIDER_COIN.get().getDescriptionId(), "Copper Spider Coin",
                "Spider Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SPIDER_COIN.get().getDescriptionId(), "Iron Spider Coin",
                "Spider Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SPIDER_COIN.get().getDescriptionId(), "Gold Spider Coin",
                "Spider Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SPIDER_COIN.get().getDescriptionId(), "Netherite Spider Coin",
                "Spider Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SQUID_COIN.get().getDescriptionId(), "Copper Squid Coin",
                "Squid Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SQUID_COIN.get().getDescriptionId(), "Iron Squid Coin",
                "Squid Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SQUID_COIN.get().getDescriptionId(), "Gold Squid Coin",
                "Squid Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SQUID_COIN.get().getDescriptionId(), "Netherite Squid Coin",
                "Squid Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_STRAY_COIN.get().getDescriptionId(), "Copper Stray Coin",
                "Stray Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_STRAY_COIN.get().getDescriptionId(), "Iron Stray Coin",
                "Stray Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_STRAY_COIN.get().getDescriptionId(), "Gold Stray Coin",
                "Stray Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_STRAY_COIN.get().getDescriptionId(), "Netherite Stray Coin",
                "Stray Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_STRIDER_COIN.get().getDescriptionId(), "Copper Strider Coin",
                "Strider Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_STRIDER_COIN.get().getDescriptionId(), "Iron Strider Coin",
                "Strider Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_STRIDER_COIN.get().getDescriptionId(), "Gold Strider Coin",
                "Strider Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_STRIDER_COIN.get().getDescriptionId(), "Netherite Strider Coin",
                "Strider Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_TADPOLE_COIN.get().getDescriptionId(), "Copper Tadpole Coin",
                "Tadpole Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_TADPOLE_COIN.get().getDescriptionId(), "Iron Tadpole Coin",
                "Tadpole Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_TADPOLE_COIN.get().getDescriptionId(), "Gold Tadpole Coin",
                "Tadpole Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_TADPOLE_COIN.get().getDescriptionId(), "Netherite Tadpole Coin",
                "Tadpole Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_TRADER_LLAMA_COIN.get().getDescriptionId(), "Copper Trader Llama Coin",
                "Trader Llama Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_TRADER_LLAMA_COIN.get().getDescriptionId(), "Iron Trader Llama Coin",
                "Trader Llama Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_TRADER_LLAMA_COIN.get().getDescriptionId(), "Gold Trader Llama Coin",
                "Trader Llama Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_TRADER_LLAMA_COIN.get().getDescriptionId(), "Netherite Trader Llama Coin",
                "Trader Llama Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_TURTLE_COIN.get().getDescriptionId(), "Copper Turtle Coin",
                "Turtle Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_TURTLE_COIN.get().getDescriptionId(), "Iron Turtle Coin",
                "Turtle Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_TURTLE_COIN.get().getDescriptionId(), "Gold Turtle Coin",
                "Turtle Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_TURTLE_COIN.get().getDescriptionId(), "Netherite Turtle Coin",
                "Turtle Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_VEX_COIN.get().getDescriptionId(), "Copper Vex Coin",
                "Vex Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_VEX_COIN.get().getDescriptionId(), "Iron Vex Coin",
                "Vex Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_VEX_COIN.get().getDescriptionId(), "Gold Vex Coin",
                "Vex Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_VEX_COIN.get().getDescriptionId(), "Netherite Vex Coin",
                "Vex Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_VILLAGER_COIN.get().getDescriptionId(), "Copper Villager Coin",
                "Villager Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_VILLAGER_COIN.get().getDescriptionId(), "Iron Villager Coin",
                "Villager Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_VILLAGER_COIN.get().getDescriptionId(), "Gold Villager Coin",
                "Villager Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_VILLAGER_COIN.get().getDescriptionId(), "Netherite Villager Coin",
                "Villager Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_VINDICATOR_COIN.get().getDescriptionId(), "Copper Vindicator Coin",
                "Vindicator Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_VINDICATOR_COIN.get().getDescriptionId(), "Iron Vindicator Coin",
                "Vindicator Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_VINDICATOR_COIN.get().getDescriptionId(), "Gold Vindicator Coin",
                "Vindicator Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_VINDICATOR_COIN.get().getDescriptionId(), "Netherite Vindicator Coin",
                "Vindicator Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_WANDERING_TRADER_COIN.get().getDescriptionId(), "Copper Wandering Trader Coin",
                "Wandering Trader Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_WANDERING_TRADER_COIN.get().getDescriptionId(), "Iron Wandering Trader Coin",
                "Wandering Trader Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_WANDERING_TRADER_COIN.get().getDescriptionId(), "Gold Wandering Trader Coin",
                "Wandering Trader Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_WANDERING_TRADER_COIN.get().getDescriptionId(), "Netherite Wandering Trader Coin",
                "Wandering Trader Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_WARDEN_COIN.get().getDescriptionId(), "Copper Warden Coin",
                "Warden Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_WARDEN_COIN.get().getDescriptionId(), "Iron Warden Coin",
                "Warden Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_WARDEN_COIN.get().getDescriptionId(), "Gold Warden Coin",
                "Warden Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_WARDEN_COIN.get().getDescriptionId(), "Netherite Warden Coin",
                "Warden Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_WITCH_COIN.get().getDescriptionId(), "Copper Witch Coin",
                "Witch Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_WITCH_COIN.get().getDescriptionId(), "Iron Witch Coin",
                "Witch Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_WITCH_COIN.get().getDescriptionId(), "Gold Witch Coin",
                "Witch Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_WITCH_COIN.get().getDescriptionId(), "Netherite Witch Coin",
                "Witch Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_WITHER_SKELETON_COIN.get().getDescriptionId(), "Copper Wither Skeleton Coin",
                "Wither Skeleton Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_WITHER_SKELETON_COIN.get().getDescriptionId(), "Iron Wither Skeleton Coin",
                "Wither Skeleton Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_WITHER_SKELETON_COIN.get().getDescriptionId(), "Gold Wither Skeleton Coin",
                "Wither Skeleton Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_WITHER_SKELETON_COIN.get().getDescriptionId(), "Netherite Wither Skeleton Coin",
                "Wither Skeleton Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_WITHER_COIN.get().getDescriptionId(), "Copper Wither Coin",
                "Wither Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_WITHER_COIN.get().getDescriptionId(), "Iron Wither Coin",
                "Wither Coin Set", 1, 4);
        addCollectibleCoins(ModItems.GOLD_WITHER_COIN.get().getDescriptionId(), "Gold Wither Coin",
                "Wither Coin Set", 1, 4);
        addCollectibleCoins(ModItems.NETHERITE_WITHER_COIN.get().getDescriptionId(), "Netherite Wither Coin",
                "Wither Coin Set", 1, 4);

        addCollectibleCoins(ModItems.COPPER_WOLF_COIN.get().getDescriptionId(), "Copper Wolf Coin",
                "Wolf Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_WOLF_COIN.get().getDescriptionId(), "Iron Wolf Coin",
                "Wolf Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_WOLF_COIN.get().getDescriptionId(), "Gold Wolf Coin",
                "Wolf Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_WOLF_COIN.get().getDescriptionId(), "Netherite Wolf Coin",
                "Wolf Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ZOGLIN_COIN.get().getDescriptionId(), "Copper Zoglin Coin",
                "Zoglin Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ZOGLIN_COIN.get().getDescriptionId(), "Iron Zoglin Coin",
                "Zoglin Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ZOGLIN_COIN.get().getDescriptionId(), "Gold Zoglin Coin",
                "Zoglin Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ZOGLIN_COIN.get().getDescriptionId(), "Netherite Zoglin Coin",
                "Zoglin Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ZOMBIE_COIN.get().getDescriptionId(), "Copper Zombie Coin",
                "Zombie Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ZOMBIE_COIN.get().getDescriptionId(), "Iron Zombie Coin",
                "Zombie Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ZOMBIE_COIN.get().getDescriptionId(), "Gold Zombie Coin",
                "Zombie Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ZOMBIE_COIN.get().getDescriptionId(), "Netherite Zombie Coin",
                "Zombie Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Copper Zombie Horse Coin",
                "Zombie Horse Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Iron Zombie Horse Coin",
                "Zombie Horse Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Gold Zombie Horse Coin",
                "Zombie Horse Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Netherite Zombie Horse Coin",
                "Zombie Horse Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(), "Copper Zombie Villager Coin",
                "Zombie Villager Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(), "Iron Zombie Villager Coin",
                "Zombie Villager Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(), "Gold Zombie Villager Coin",
                "Zombie Villager Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(), "Netherite Zombie Villager Coin",
                "Zombie Villager Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(), "Copper Zombified Piglin Coin",
                "Zombified Piglin Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(), "Iron Zombified Piglin Coin",
                "Zombified Piglin Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(), "Gold Zombified Piglin Coin",
                "Zombified Piglin Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(), "Netherite Zombified Piglin Coin",
                "Zombified Piglin Coin Set", 4, 4);

        // friends and foes theme coins
        addCollectibleCoins(ModItems.COPPER_MOOBLOOM_COIN.get().getDescriptionId(), "Copper Moobloom Coin",
                "Moobloom Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_MOOBLOOM_COIN.get().getDescriptionId(), "Iron Moobloom Coin",
                "Moobloom Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_MOOBLOOM_COIN.get().getDescriptionId(), "Gold Moobloom Coin",
                "Moobloom Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_MOOBLOOM_COIN.get().getDescriptionId(), "Netherite Moobloom Coin",
                "Moobloom Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_COPPER_GOLEM_COIN.get().getDescriptionId(), "Copper Copper Golem Coin",
                "Copper Golem Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_COPPER_GOLEM_COIN.get().getDescriptionId(), "Iron Copper Golem Coin",
                "Copper Golem Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_COPPER_GOLEM_COIN.get().getDescriptionId(), "Gold Copper Golem Coin",
                "Copper Golem Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_COPPER_GOLEM_COIN.get().getDescriptionId(), "Netherite Copper Golem Coin",
                "Copper Golem Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_GLARE_COIN.get().getDescriptionId(), "Copper Glare Coin",
                "Glare Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_GLARE_COIN.get().getDescriptionId(), "Iron Glare Coin",
                "Glare Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_GLARE_COIN.get().getDescriptionId(), "Gold Glare Coin",
                "Glare Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_GLARE_COIN.get().getDescriptionId(), "Netherite Glare Coin",
                "Glare Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_ICEOLOGER_COIN.get().getDescriptionId(), "Copper Iceologer Coin",
                "Iceologer Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_ICEOLOGER_COIN.get().getDescriptionId(), "Iron Iceologer Coin",
                "Iceologer Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_ICEOLOGER_COIN.get().getDescriptionId(), "Gold Iceologer Coin",
                "Iceologer Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_ICEOLOGER_COIN.get().getDescriptionId(), "Netherite Iceologer Coin",
                "Iceologer Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_MAULER_COIN.get().getDescriptionId(), "Copper Mauler Coin",
                "Mauler Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_MAULER_COIN.get().getDescriptionId(), "Iron Mauler Coin",
                "Mauler Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_MAULER_COIN.get().getDescriptionId(), "Gold Mauler Coin",
                "Mauler Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_MAULER_COIN.get().getDescriptionId(), "Netherite Mauler Coin",
                "Mauler Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_WILDFIRE_COIN.get().getDescriptionId(), "Copper Wildfire Coin",
                "Wildfire Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_WILDFIRE_COIN.get().getDescriptionId(), "Iron Wildfire Coin",
                "Wildfire Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_WILDFIRE_COIN.get().getDescriptionId(), "Gold Wildfire Coin",
                "Wildfire Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_WILDFIRE_COIN.get().getDescriptionId(), "Netherite Wildfire Coin",
                "Wildfire Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_TUFF_GOLEM_COIN.get().getDescriptionId(), "Copper Tuff Golem Coin",
                "Tuff Golem Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_TUFF_GOLEM_COIN.get().getDescriptionId(), "Iron Tuff Golem Coin",
                "Tuff Golem Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_TUFF_GOLEM_COIN.get().getDescriptionId(), "Gold Tuff Golem Coin",
                "Tuff Golem Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_TUFF_GOLEM_COIN.get().getDescriptionId(), "Netherite Tuff Golem Coin",
                "Tuff Golem Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_RASCAL_COIN.get().getDescriptionId(), "Copper Rascal Coin",
                "Rascal Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_RASCAL_COIN.get().getDescriptionId(), "Iron Rascal Coin",
                "Rascal Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_RASCAL_COIN.get().getDescriptionId(), "Gold Rascal Coin",
                "Rascal Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_RASCAL_COIN.get().getDescriptionId(), "Netherite Rascal Coin",
                "Rascal Coin Set", 4, 4);

        // ecologics theme coins
        addCollectibleCoins(ModItems.COPPER_CRAB_COIN.get().getDescriptionId(), "Copper Crab Coin",
                "Crab Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_CRAB_COIN.get().getDescriptionId(), "Iron Crab Coin",
                "Crab Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_CRAB_COIN.get().getDescriptionId(), "Gold Crab Coin",
                "Crab Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_CRAB_COIN.get().getDescriptionId(), "Netherite Crab Coin",
                "Crab Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_SQUIRREL_COIN.get().getDescriptionId(), "Copper Squirrel Coin",
                "Squirrel Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_SQUIRREL_COIN.get().getDescriptionId(), "Iron Squirrel Coin",
                "Squirrel Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_SQUIRREL_COIN.get().getDescriptionId(), "Gold Squirrel Coin",
                "Squirrel Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_SQUIRREL_COIN.get().getDescriptionId(), "Netherite Squirrel Coin",
                "Squirrel Coin Set", 4, 4);

        addCollectibleCoins(ModItems.COPPER_PENGUIN_COIN.get().getDescriptionId(), "Copper Penguin Coin",
                "Penguin Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PENGUIN_COIN.get().getDescriptionId(), "Iron Penguin Coin",
                "Penguin Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PENGUIN_COIN.get().getDescriptionId(), "Gold Penguin Coin",
                "Penguin Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PENGUIN_COIN.get().getDescriptionId(), "Netherite Penguin Coin",
                "Penguin Coin Set", 4, 4);

        // guard villagers theme coins
        addCollectibleCoins(ModItems.COPPER_GUARD_COIN.get().getDescriptionId(), "Copper Guard Coin",
                "Guard Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_GUARD_COIN.get().getDescriptionId(), "Iron Guard Coin",
                "Guard Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_GUARD_COIN.get().getDescriptionId(), "Gold Guard Coin",
                "Guard Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_GUARD_COIN.get().getDescriptionId(), "Netherite Guard Coin",
                "Guard Coin Set", 4, 4);

        // todepiglins theme coins
        addCollectibleCoins(ModItems.COPPER_PIGLIN_MERCHANT_COIN.get().getDescriptionId(), "Copper Piglin Merchant Coin",
                "Piglin Merchant Coin Set", 1, 4);
        addCollectibleCoins(ModItems.IRON_PIGLIN_MERCHANT_COIN.get().getDescriptionId(), "Iron Piglin Merchant Coin",
                "Piglin Merchant Coin Set", 2, 4);
        addCollectibleCoins(ModItems.GOLD_PIGLIN_MERCHANT_COIN.get().getDescriptionId(), "Gold Piglin Merchant Coin",
                "Piglin Merchant Coin Set", 3, 4);
        addCollectibleCoins(ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get().getDescriptionId(), "Netherite Piglin Merchant Coin",
                "Piglin Merchant Coin Set", 4, 4);

        // regular mod items
        add(ModItems.NUMISMATIST_SPAWN_EGG.get(), "Numismatist Spawn Egg");
        add(ModItems.SNOW_GOLEM_SPAWN_EGG.get(), "Snow Golem Spawn Egg");
        add(ModItems.ILLUSIONER_SPAWN_EGG.get(), "Illusioner Spawn Egg");
        add(ModItems.GIANT_SPAWN_EGG.get(), "Giant Spawn Egg");
        add(ModItems.PIGLINMERCHANT_SPAWN_EGG.get(), "Piglin Merchant Spawn Egg");
        add(ModItems.FOUR_LEAF_CLOVER.get(), "Four Leaf Clover");
        add(ModItems.CURRENCY_STAMP.get(), "Currency Stamp");
        add(ModItems.NETHER_CURRENCY_STAMP.get(), "Nether Currency Stamp");
        add(ModItems.ENDONIAN_CURRENCY_STAMP.get(), "Endonian Currency Stamp");
        add(ModItems.COPPER_NUGGET.get(), "Copper Nugget");
        add(ModItems.NETHERITE_NUGGET.get(), "Netherite Nugget");
        add(ModItems.ENDONIAN_NUGGET.get(), "Endonian Nugget");
        add(ModItems.ENDONIAN_INGOT.get(), "Endonian Ingot");
        add(ModItems.LUCKY_NUGGET.get(), "Lucky Nugget");
        add(ModItems.COPPER_COIN.get(), "Copper Coin");
        add(ModItems.IRON_COIN.get(), "Iron Coin");
        add(ModItems.GOLD_COIN.get(), "Gold Coin");
        add(ModItems.NETHERITE_COIN.get(), "Netherite Coin");
        add(ModItems.ENDONIAN_COIN.get(), "Endonian Coin");
        add(ModItems.LUCKY_COIN.get(), "Lucky Coin");
        add(ModItems.NETHER_GOLD_COIN.get(), "Nether Gold Coin");
        add(ModItems.SERVER_TOKEN_COIN.get(), "Server Token Coin");
        add(ModItems.EMERALD_QUARTER_BANK_NOTE.get(), "Emerald Quarter Bank Note");
        add(ModItems.EMERALD_HALF_BANK_NOTE.get(), "Emerald Half Bank Note");
        add(ModItems.EMERALD_BANK_NOTE.get(), "Emerald Bank Note");
        add(ModItems.EMERALD_FIBER.get(), "Emerald Fiber");
        add(ModItems.LUCKY_FIBER.get(), "Lucky Fiber");
        add(ModItems.ENDONIAN_FIBER.get(), "Endonian Fiber");
        add(ModItems.ECHO_FIBER.get(), "Echo Fiber");
        add(ModItems.EMERALD_THREAD.get(), "Emerald Thread");
        add(ModItems.LUCKY_THREAD.get(), "Lucky Thread");
        add(ModItems.ENDONIAN_THREAD.get(), "Endonian Thread");
        add(ModItems.ECHO_THREAD.get(), "Echo Thread");
        add(ModItems.LUCKY_FABRIC.get(), "Lucky Fabric");
        add(ModItems.EMERALD_WOVE_PAPER.get(), "Emerald Wove Paper");
        add(ModItems.EMERALD_COARSE_WOVE_PAPER.get(), "Emerald Coarse Wove Paper");
        add(ModItems.EMERALD_SMOOTH_WOVE_PAPER.get(), "Emerald Smooth Wove Paper");
        add(ModItems.LUCKY_BOOTS.get(), "Lucky Boots");
        add(ModItems.LUCKY_PANTS.get(), "Lucky Pants");
        add(ModItems.LUCKY_SHIRT.get(), "Lucky Shirt");
        add(ModItems.LUCKY_HAT.get(), "Lucky Hat");

        // candy coin items
        add(ModItems.WARPED_SPICE_CHOCOLATE_COIN.get(), "Warped Spice Chocolate Coin");
        add(ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get(), "Crimson Spore Chocolate Coin");
        add(ModItems.MILK_BONE_CHOCOLATE_COIN.get(), "Milk Bone Chocolate Coin");
        add(ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get(), "Ultimate Dark Chocolate Coin");
        add(ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get(), "Bubbly Berry Chocolate Coin");
        add(ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get(), "Velvety Clover Chocolate Coin");
        add(ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get(), "Festive Fudge Chocolate Coin");
        add(ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get(), "Fuego Fudge Chocolate Coin");
        add(ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get(), "Carmel Crisp Chocolate Coin");
    }

    private void addCollectibleCoins(String id, String name, String setName, int coinSetCount, int coinSetTotal) {
        // name
        add(id, "Collectible " + name);
        // advancement
        add("advancement.find_" + id, "Obtain the " + name);
        // coin set count tooltip
        add("tooltips." + id + ".set_count",
                coinSetCount + " of " + coinSetTotal + " in the " + setName);
    }

    private void addAdvancements() {
        add("advancement.root", "TodeCoins Advancements");
        add("advancement.root.desc", "Primary Advancements for TodeCoins");
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
        add("advancement.netherDough.desc", "Mint a Nether Coin");
        add("advancement.otherworldlyCoin", "Otherworldly Coin");
        add("advancement.otherworldlyCoin.desc", "Mint an Endonian Coin");
        add("advancement.luckyClover", "Lucky Clover");
        add("advancement.luckyClover.desc", "Find a Four-Leaf Clover");
        add("advancement.luckyPenny", "Lucky Penny");
        add("advancement.luckyPenny.desc", "Obtain a Lucky Coin");
        add("advancement.textileEngineering1", "Emerald Textile Engineering");
        add("advancement.textileEngineering1.desc", "Craft all the Emerald Fibers and Papers");
        add("advancement.textileEngineering2", "Lucky Textile Engineering");
        add("advancement.textileEngineering2.desc", "Craft the Lucky Fiber, Thread, and Fabric");
        add("advancement.luckyArmor", "Feeling Lucky?");
        add("advancement.luckyArmor.desc", "Obtain a full set of Lucky Armor");
        add("advancement.textileEngineering3", "Otherworldly Textile Engineering");
        add("advancement.textileEngineering3.desc", "Craft the Endonian Fiber and Thread");
        add("advancement.friendsForever", "BFF");
        add("advancement.friendsForever.desc", "Craft a Friendship Bracelet");
        add("advancement.textileEngineering4", "Ethereal Textile Engineering");
        add("advancement.textileEngineering4.desc", "Craft the Echo Fiber and Thread");

        add("advancement.collectibleCoins", "Collectible Coins");
        add("advancement.collectibleCoins.desc", "Collectible Coin Advancements");

        add("advancement.first_coin", "A Lucky Find");
        add("advancement.first_coin.desc", "Obtain Your First Collectible Coin");

        add("advancement.equip_lucky_coin", "And All Day You'll Have Good Luck!");
        add("advancement.equip_lucky_coin.desc", "Equip a Lucky Coin");

        add("advancement.equip_wallet", "Cash on Hand");
        add("advancement.equip_wallet.desc", "Equip a Wallet Item");

        add("advancement.all_coins", "Be the Numismatist");
        add("advancement.all_coins.desc", "Collect all the Collectible Coins");

        add("advancement.collectibleTodePiglinsCoins", "Piglin Merchant Coin Set");
        add("advancement.collectibleTodePiglinsCoins.desc", "Find All the Piglin Merchant Coins!");

        add("advancement.snifferCoinSet", "Sniffer Coin Set");
        add("advancement.snifferCoinSet.desc", "Find All the Sniffer Coins!");

        add("advancement.armadilloCoinSet", "Armadillo Coin Set");
        add("advancement.armadilloCoinSet.desc", "Find All the Armadillo Coins!");

        add("advancement.camelCoinSet", "Camel Coin Set");
        add("advancement.camelCoinSet.desc", "Find All the Camel Coins!");

        add("advancement.zombieHorseCoinSet", "Zombie Horse Coin Set");
        add("advancement.zombieHorseCoinSet.desc", "Find All the Zombie Horse Coins!");

        add("advancement.illusionerCoinSet", "Illusioner Coin Set");
        add("advancement.illusionerCoinSet.desc", "Find All the Illusioner Coins!");

        add("advancement.giantCoinSet", "Giant Coin Set");
        add("advancement.giantCoinSet.desc", "Find All the Giant Coins!");

        add("advancement.guardVillagerCoinSet", "Guard Villager Coin Set");
        add("advancement.guardVillagerCoinSet.desc", "Find All the Guard Villager Coins!");

        add("advancement.rascalCoinSet", "Rascal Coin Set");
        add("advancement.rascalCoinSet.desc", "Find All the Rascal Coins!");

        add("advancement.wildfireCoinSet", "Wildfire Coin Set");
        add("advancement.wildfireCoinSet.desc", "Find All the Wildfire Coins!");

        add("advancement.tuffGolemCoinSet", "Tuff Golem Coin Set");
        add("advancement.tuffGolemCoinSet.desc", "Find All the Tuff Golem Coins!");

        add("advancement.moobloomCoinSet", "Moobloom Coin Set");
        add("advancement.moobloomCoinSet.desc", "Find All the Moobloom Coins!");

        add("advancement.maulerCoinSet", "Mauler Coin Set");
        add("advancement.maulerCoinSet.desc", "Find All the Mauler Coins!");

        add("advancement.iceologerCoinSet", "Iceologer Coin Set");
        add("advancement.iceologerCoinSet.desc", "Find All the Iceologer Coins!");

        add("advancement.glareCoinSet", "Glare Coin Set");
        add("advancement.glareCoinSet.desc", "Find All the Glare Coins!");

        add("advancement.copperGolemCoinSet", "Copper Golem Coin Set");
        add("advancement.copperGolemCoinSet.desc", "Find All the Copper Golem Coins!");

        add("advancement.penguinCoinSet", "Penguin Coin Set");
        add("advancement.penguinCoinSet.desc", "Find All the Penguin Coins!");

        add("advancement.squirrelCoinSet", "Squirrel Coin Set");
        add("advancement.squirrelCoinSet.desc", "Find All the Squirrel Coins!");

        add("advancement.crabCoinSet", "Crab Coin Set");
        add("advancement.crabCoinSet.desc", "Find All the Crab Coins!");

        add("advancement.zombifiedPiglinCoinSet", "Zombified Piglin Coin Set");
        add("advancement.zombifiedPiglinCoinSet.desc", "Find All the Zombified Piglin Coins!");

        add("advancement.zombieVillagerCoinSet", "Zombie Villager Coin Set");
        add("advancement.zombieVillagerCoinSet.desc", "Find All the Zombie Villager Coins!");

        add("advancement.zombieCoinSet", "Zombie Coin Set");
        add("advancement.zombieCoinSet.desc", "Find All the Zombie Coins!");

        add("advancement.zoglinCoinSet", "Zoglin Coin Set");
        add("advancement.zoglinCoinSet.desc", "Find All the Zoglin Coins!");

        add("advancement.wolfCoinSet", "Wolf Coin Set");
        add("advancement.wolfCoinSet.desc", "Find All the Wolf Coins!");

        add("advancement.witherSkeletonCoinSet", "Wither Skeleton Coin Set");
        add("advancement.witherSkeletonCoinSet.desc", "Find All the Wither Skeleton Coins!");

        add("advancement.witherCoinSet", "Wither Coin Set");
        add("advancement.witherCoinSet.desc", "Find All the Wither Coins!");

        add("advancement.witchCoinSet", "Witch Coin Set");
        add("advancement.witchCoinSet.desc", "Find All the Witch Coins!");

        add("advancement.wardenCoinSet", "Warden Coin Set");
        add("advancement.wardenCoinSet.desc", "Find All the Warden Coins!");

        add("advancement.wanderingTraderCoinSet", "Wandering Trader Coin Set");
        add("advancement.wanderingTraderCoinSet.desc", "Find All the Wandering Trader Coins!");

        add("advancement.vindicatorCoinSet", "Vindicator Coin Set");
        add("advancement.vindicatorCoinSet.desc", "Find All the Vindicator Coins!");

        add("advancement.villagerCoinSet", "Villager Coin Set");
        add("advancement.villagerCoinSet.desc", "Find All the Villager Coins!");

        add("advancement.vexCoinSet", "Vex Coin Set");
        add("advancement.vexCoinSet.desc", "Find All the Vex Coins!");

        add("advancement.turtleCoinSet", "Turtle Coin Set");
        add("advancement.turtleCoinSet.desc", "Find All the Turtle Coins!");

        add("advancement.tropicalFishCoinSet", "Tropical Fish Coin Set");
        add("advancement.tropicalFishCoinSet.desc", "Find All the Tropical Fish Coins!");

        add("advancement.llamaCoinSet", "Llama Coin Set");
        add("advancement.llamaCoinSet.desc", "Find All the Llama Coins!");

        add("advancement.tadpoleCoinSet", "Tadpole Coin Set");
        add("advancement.tadpoleCoinSet.desc", "Find All the Tadpole Coins!");

        add("advancement.striderCoinSet", "Strider Coin Set");
        add("advancement.striderCoinSet.desc", "Find All the Strider Coins!");

        add("advancement.strayCoinSet", "Stray Coin Set");
        add("advancement.strayCoinSet.desc", "Find All the Stray Coins!");

        add("advancement.squidCoinSet", "Squid Coin Set");
        add("advancement.squidCoinSet.desc", "Find All the Squid Coins!");

        add("advancement.snowGolemCoinSet", "Snow Golem Coin Set");
        add("advancement.snowGolemCoinSet.desc", "Find All the Snow Golem Coins!");

        add("advancement.slimeCoinSet", "Slime Coin Set");
        add("advancement.slimeCoinSet.desc", "Find All the Slime Coins!");

        add("advancement.skeletonHorseCoinSet", "Skeleton Horse Coin Set");
        add("advancement.skeletonHorseCoinSet.desc", "Find All the Skeleton Horse Coins!");

        add("advancement.skeletonCoinSet", "Skeleton Coin Set");
        add("advancement.skeletonCoinSet.desc", "Find All the Skeleton Coins!");

        add("advancement.silverfishCoinSet", "Silverfish Coin Set");
        add("advancement.silverfishCoinSet.desc", "Find All the Silverfish Coins!");

        add("advancement.traderLlamaCoinSet", "Trader Llama Coin Set");
        add("advancement.traderLlamaCoinSet.desc", "Find All the Trader Llama Coins!");

        add("advancement.shulkerCoinSet", "Shulker Coin Set");
        add("advancement.shulkerCoinSet.desc", "Find All the Shulker Coins!");

        add("advancement.sheepCoinSet", "Sheep Coin Set");
        add("advancement.sheepCoinSet.desc", "Find All the Sheep Coins!");

        add("advancement.salmonCoinSet", "Salmon Coin Set");
        add("advancement.salmonCoinSet.desc", "Find All the Salmon Coins!");

        add("advancement.ravagerCoinSet", "Ravager Coin Set");
        add("advancement.ravagerCoinSet.desc", "Find All the Ravager Coins!");

        add("advancement.rabbitCoinSet", "Rabbit Coin Set");
        add("advancement.rabbitCoinSet.desc", "Find All the Rabbit Coins!");

        add("advancement.pillagerCoinSet", "Pillager Coin Set");
        add("advancement.pillagerCoinSet.desc", "Find All the Pillager Coins!");

        add("advancement.polarBearCoinSet", "Polar Bear Coin Set");
        add("advancement.polarBearCoinSet.desc", "Find All the Polar Bear Coins!");

        add("advancement.pufferfishCoinSet", "Pufferfish Coin Set");
        add("advancement.pufferfishCoinSet.desc", "Find All the Pufferfish Coins!");

        add("advancement.pandaCoinSet", "Panda Coin Set");
        add("advancement.pandaCoinSet.desc", "Find All the Panda Coins!");

        add("advancement.parrotCoinSet", "Parrot Coin Set");
        add("advancement.parrotCoinSet.desc", "Find All the Parrot Coins!");

        add("advancement.phantomCoinSet", "Phantom Coin Set");
        add("advancement.phantomCoinSet.desc", "Find All the Phantom Coins!");

        add("advancement.pigCoinSet", "Pig Coin Set");
        add("advancement.pigCoinSet.desc", "Find All the Pig Coins!");

        add("advancement.piglinCoinSet", "Piglin Coin Set");
        add("advancement.piglinCoinSet.desc", "Find All the Piglin Coins!");

        add("advancement.piglinBruteCoinSet", "Piglin Brute Coin Set");
        add("advancement.piglinBruteCoinSet.desc", "Find All the Piglin Brute Coins!");

        add("advancement.ocelotCoinSet", "Ocelot Coin Set");
        add("advancement.ocelotCoinSet.desc", "Find All the Ocelot Coins!");

        add("advancement.numismatistCoinSet", "Numismatist Coin Set");
        add("advancement.numismatistCoinSet.desc", "Find All the Numismatist Coins!");

        add("advancement.muleCoinSet", "Mule Coin Set");
        add("advancement.muleCoinSet.desc", "Find All the Mule Coins!");

        add("advancement.mooshroomCoinSet", "Mooshroom Coin Set");
        add("advancement.mooshroomCoinSet.desc", "Find All the Mooshroom Coins!");

        add("advancement.magmaCubeCoinSet", "Magma Cube Coin Set");
        add("advancement.magmaCubeCoinSet.desc", "Find All the Magma Cube Coins!");

        add("advancement.ironGolemCoinSet", "Iron Golem Coin Set");
        add("advancement.ironGolemCoinSet.desc", "Find All the Iron Golem Coins!");

        add("advancement.huskCoinSet", "Husk Coin Set");
        add("advancement.huskCoinSet.desc", "Find All the Husk Coins!");

        add("advancement.horseCoinSet", "Horse Coin Set");
        add("advancement.horseCoinSet.desc", "Find All the Horse Coins!");

        add("advancement.glowSquidCoinSet", "Glow Squid Coin Set");
        add("advancement.glowSquidCoinSet.desc", "Find All the Glow Squid Coins!");

        add("advancement.guardianCoinSet", "Guardian Coin Set");
        add("advancement.guardianCoinSet.desc", "Find All the Guardian Coins!");

        add("advancement.goatCoinSet", "Goat Coin Set");
        add("advancement.goatCoinSet.desc", "Find All the Goat Coins!");

        add("advancement.ghastCoinSet", "Ghast Coin Set");
        add("advancement.ghastCoinSet.desc", "Find All the Ghast Coins!");

        add("advancement.frogCoinSet", "Frog Coin Set");
        add("advancement.frogCoinSet.desc", "Find All the Frog Coins!");

        add("advancement.foxCoinSet", "Fox Coin Set");
        add("advancement.foxCoinSet.desc", "Find All the Fox Coins!");

        add("advancement.evokerCoinSet", "Evoker Coin Set");
        add("advancement.evokerCoinSet.desc", "Find All the Evoker Coins!");

        add("advancement.endermiteCoinSet", "Endermite Coin Set");
        add("advancement.endermiteCoinSet.desc", "Find All the Endermite Coins!");

        add("advancement.endermanCoinSet", "Enderman Coin Set");
        add("advancement.endermanCoinSet.desc", "Find All the Enderman Coins!");

        add("advancement.enderDragonCoinSet", "Ender Dragon Coin Set");
        add("advancement.enderDragonCoinSet.desc", "Find All the Ender Dragon Coins!");

        add("advancement.elderGuardianCoinSet", "Elder Guardian Coin Set");
        add("advancement.elderGuardianCoinSet.desc", "Find All the Elder Guardian Coins!");

        add("advancement.drownedCoinSet", "Drowned Coin Set");
        add("advancement.drownedCoinSet.desc", "Find All the Drowned Coins!");

        add("advancement.donkeyCoinSet", "Donkey Coin Set");
        add("advancement.donkeyCoinSet.desc", "Find All the Donkey Coins!");

        add("advancement.dolphinCoinSet", "Dolphin Coin Set");
        add("advancement.dolphinCoinSet.desc", "Find All the Dolphin Coins!");

        add("advancement.creeperCoinSet", "Creeper Coin Set");
        add("advancement.creeperCoinSet.desc", "Find All the Creeper Coins!");

        add("advancement.cowCoinSet", "Cow Coin Set");
        add("advancement.cowCoinSet.desc", "Find All the Cow Coins!");

        add("advancement.codCoinSet", "Cod Coin Set");
        add("advancement.codCoinSet.desc", "Find All the Cod Coins!");

        add("advancement.chickenCoinSet", "Chicken Coin Set");
        add("advancement.chickenCoinSet.desc", "Find All the Chicken Coins!");

        add("advancement.caveSpiderCoinSet", "Cave Spider Coin Set");
        add("advancement.caveSpiderCoinSet.desc", "Find All the Cave Spider Coins!");

        add("advancement.catCoinSet", "Cat Coin Set");
        add("advancement.catCoinSet.desc", "Find All the Cat Coins!");

        add("advancement.blazeCoinSet", "Blaze Coin Set");
        add("advancement.blazeCoinSet.desc", "Find All the Blaze Coins!");

        add("advancement.beeCoinSet", "Bee Coin Set");
        add("advancement.beeCoinSet.desc", "Find All the Bee Coins!");

        add("advancement.batCoinSet", "Bat Coin Set");
        add("advancement.batCoinSet.desc", "Find All the Bat Coins!");

        add("advancement.axolotlCoinSet", "Axolotl Coin Set");
        add("advancement.axolotlCoinSet.desc", "Find All the Axolotl Coins!");

        add("advancement.allayCoinSet", "Allay Coin Set");
        add("advancement.allayCoinSet.desc", "Find All the Allay Coins!");

        add("advancement.heroCoinSet", "Hero Coin Set");
        add("advancement.heroCoinSet.desc", "Find All the Hero Coins!");

        add("advancement.patronBranniganCoinSet", "Patron Brannigan Coin Set");
        add("advancement.patronBranniganCoinSet.desc", "Find All the Patron Brannigan Coins!");

        add("advancement.patronNashCoinSet", "Patron Nash Coin Set");
        add("advancement.patronNashCoinSet.desc", "Find All the Patron Nash Coins!");

        add("advancement.lifetimePatronCoinSet", "Lifetime Patron Coin Set");
        add("advancement.lifetimePatronCoinSet.desc", "Find All the Lifetime Patron Coins!");

        add("advancement.holidayCoinSet", "Holiday Coin Set");
        add("advancement.holidayCoinSet.desc", "Find All the Holiday Coins!");

        add("advancement.hoglinCoinSet", "Hoglin Coin Set");
        add("advancement.hoglinCoinSet.desc", "Find All the Hoglin Coins!");
    }

    private void addTooltips() {
        add("tooltips.no_ai_spawn_egg", "Spawns with No AI");
        add("tooltips.collectible_coin_pack", "Mystery Coin Pack");

        add("tooltips.shift.hover", "Press SHIFT for more info...");
        add("tooltips.textile_item.hover", "Textiles are used to make materials like paper and fabric.");
        add("tooltips.lucky_coin.hover", "Smells like fresh clover, what an unusual coin...");
        add("tooltips.four_leaf_clover.hover", "Many people believe this is a lucky charm...");
        add("tooltips.lucky_armor_item.hover", "Just wearing this garment makes you feel luckier...");
        add("tooltips.barter_coin_item.hover", "Anthropological evidence suggests bartering occurs whenever currency isn't readily available.");
        add("tooltips.endonian_coin_item.hover", "An otherworldly coin for interdimensional trading.");
        add("tooltips.bank_note_item.hover", "The original bank notes were created by China and worked much like our debit cards today.");
        add("tooltips.coin_item.hover", "Since ancient times, coins were either stamped or forged into molds.");
        add("tooltips.coin_stamp.hover", "This is for stamping currency in a press.");
        add("tooltips.server_token_coin.hover", "A special coin for server use.");

        // coin effects
        add("tooltips.coin_effects", "Coin Use Effects:");
        add("tooltips.coin_effects_equip", "Coin Effects while Equipped:");

        add("tooltips.coin_effects.fortune_1", "Fortune I");
        add("tooltips.coin_effects.looting_1", "Looting I");

        add("tooltips.coin_effects.snow_walk", "Can Walk on Powdered Snow");
        add("tooltips.coin_effects.berry_walk", "Can Walk in Berry Bushes Unharmed");
        add("tooltips.coin_effects.piglin_neutral", "Makes Piglins Neutral");
        add("tooltips.coin_effects.enderman_neutral", "Makes Endermen Neutral");

        add("tooltips.coin_effects.undying", "Functions as a Totem of Undying while Equipped or in Inventory");
        add("tooltips.coin_effects.fishing_loot", "Unlocks Additional Sub Loot Tables for Fishing");

        add("tooltips.coin_effects.cat_intimidation", "Intimidates Creepers and Phantoms");

        // food tooltips
        add("tooltips." + ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get() + "_effects", "90% Chance of Fire Resistance, 10% Chance of Hunger");
        add("tooltips." + ModItems.WARPED_SPICE_CHOCOLATE_COIN.get() + "_effects", "90% Chance of Increased Movement Speed, 10% Chance of Confusion");
        add("tooltips." + ModItems.MILK_BONE_CHOCOLATE_COIN.get() + "_effects", "90% Chance of Damage Resistance, 10% Chance of Slowness");
        add("tooltips." + ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get() + " _effects", "90% Chance of Hero of the Village, 10% Chance of Darkness");
        add("tooltips." + ModItems.BUBBLY_BERRY_CHOCOLATE_COIN.get() + "_effects", "Puts a spring in your step and makes you light on your feet!");
        add("tooltips." + ModItems.VELVETY_CLOVER_CHOCOLATE_COIN.get() + "_effects", "So smooth and fresh, it's your lucky day!");
        add("tooltips." + ModItems.FESTIVE_FUDGE_CHOCOLATE_COIN.get() + "_effects", "Sparkling, rich, and surprisingly rejuvenating too!");
        add("tooltips." + ModItems.FUEGO_FUDGE_CHOCOLATE_COIN.get() + "_effects", "Feel the burn as you glow it up in style!");
        add("tooltips." + ModItems.CARMEL_CRISP_CHOCOLATE_COIN.get() + "_effects", "Crunchy and gooey, just the thing to keep you on task!");

        // holiday collectible coin bases
        add("tooltips.collectible_coin_birthday.hover", "A Coin to Celebrate Birthdays");
        add("tooltips.collectible_coin_christmas.hover", "A Coin to Celebrate Many Holidays before and around the Hibernal Solstice, such as Christmas, Hanukkah, Kwanzaa, Yule, and many more!");
        add("tooltips.collectible_coin_halloween.hover", "A Coin to Celebrate Many Holidays before and around the Autumnal Equinox, such as Harvest Festivals, All Hallows' Eve, Samhain, Halloween, Day of the Dead, and possibly more.");
        add("tooltips.collectible_coin_easter.hover", "A Coin to Celebrate Many Holidays before and around the Vernal Equinox, such as the day itself in Japan, Passover, Easter, Ostara, and many more.");
        add("tooltips.collectible_coin_new_year.hover", "A Coin to Celebrate the New Year");

        // annual patron coin bases
        add("tooltips.collectible_patron_coin.hover", "A collectible coin to publicly honor, acknowledge, and appreciate those that support my work");
        add("tooltips.collectible_coin_lifetime.hover", "This coin celebrates a special champion in my life");
        add("tooltips.collectible_coin_carnation.hover", "This coin celebrates the 1st year anniversary of this supporter");
        add("tooltips.collectible_coin_cosmos.hover", "This coin celebrates the 2nd year anniversary of this supporter");
        add("tooltips.collectible_coin_sunflower.hover", "This coin celebrates the 3rd year anniversary of this supporter");

        // all collectible coin bases
        add("tooltips.collectible_coin.hover", "These types of coins aren't used as currency, but are instead collected and traded for their unique value");
    }

    private void addBlocks() {
        add(ModBlocks.COPPER_COIN_BAG.get(), "Copper Coin Bag");
        add(ModBlocks.IRON_COIN_BAG.get(), "Iron Coin Bag");
        add(ModBlocks.GOLD_COIN_BAG.get(), "Gold Coin Bag");
        add(ModBlocks.NETHERITE_COIN_BAG.get(), "Netherite Coin Bag");
        add(ModBlocks.NETHER_GOLD_COIN_BAG.get(), "Nether Gold Coin Bag");
        add(ModBlocks.ENDONIAN_COIN_BAG.get(), "Endonian Coin Bag");
        add(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get(), "Emerald Quarter Bank Note Bag");
        add(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get(), "Emerald Half Bank Note Bag");
        add(ModBlocks.EMERALD_BANK_NOTE_BAG.get(), "Emerald Bank Note Bag");
        add(ModBlocks.LUCKY_COIN_BAG.get(), "Lucky Coin Bag");
        add(ModBlocks.ENDONIAN_BLOCK.get(), "Endonian Block");
        add(ModBlocks.POT_OF_GOLD.get(), "Pot of Gold");
        add(ModBlocks.COINPRESSBLOCK.get(), "Coin Press");
    }

    private void addEntities() {
        add(ModEntityTypes.NUMISMATIST.get(), "Numismatist");
        add(ModEntityTypes.PIGLINMERCHANT.get(), "Piglin Merchant");
        add("entity.minecraft.villager." + MODID + ".banker", "Banker");
        add("entity.minecraft.villager." + MODID + ".leprechaun", "Leprechaun");
    }

    private void addContainers() {
        add("container.coin_press_block_gui", "Coin Press");
        add("container.recipe_book.coin_press", "Coin Press Recipe Book");
    }

    private void addSubtitles() {
        add("subtitles." + MODID + ".work_banker", "Banker Works");
        add("subtitles." + MODID + ".work_leprechaun", "Leprechaun Works");
        add("subtitles." + MODID + ".coin_press_take", "Coin Press Cashes Out");
        add("subtitles." + MODID + ".coin_press_use", "Coin Press Used");

        add("subtitles." + MODID + ".numismatist_drink_milk", "Numismatist Drinks Milk");
        add("subtitles." + MODID + ".numismatist_drink_potion", "Numismatist Drinks Potion");
        add("subtitles." + MODID + ".numismatist_appeared", "Numismatist Appears");
        add("subtitles." + MODID + ".numismatist_disappeared", "Numismatist Disappears");
        add("subtitles." + MODID + ".numismatist_haggle", "Numismatist Haggles");
        add("subtitles." + MODID + ".numismatist_no", "Numismatist Disagrees");
        add("subtitles." + MODID + ".numismatist_yes", "Numismatist Agrees");
        add("subtitles." + MODID + ".numismatist_idle", "Numismatist Mumbles");
        add("subtitles." + MODID + ".numismatist_hurt", "Numismatist Hurt");
        add("subtitles." + MODID + ".numismatist_death", "Numismatist Dies");

        add("subtitles." + MODID + ".piglinmerchant_hurt", "Piglin Merchant Hurt");
        add("subtitles." + MODID + ".piglinmerchant_death", "Piglin Merchant Dies");
        add("subtitles." + MODID + ".piglinmerchant_step", "Piglin Merchant Steps");
        add("subtitles." + MODID + ".piglinmerchant_retreat", "Piglin Merchant Retreats");
        add("subtitles." + MODID + ".piglinmerchant_jealous", "Piglin Merchant Snorts Enviously");
        add("subtitles." + MODID + ".piglinmerchant_ambient", "Piglin Merchant Snorts");
        add("subtitles." + MODID + ".piglinmerchant_celebrates", "Piglin Merchant Celebrates");
        add("subtitles." + MODID + ".piglinmerchant_anger", "Piglin Merchant Snarls");
        add("subtitles." + MODID + ".piglinmerchant_examine", "Piglin Merchant Examines Item");
    }

    private void addAttributes() {
        add(ModAttributes.CHARISMA.get().getDescriptionId(), "Charisma");
        add(ModAttributes.COD_BONUS.get().getDescriptionId(), "Cod Chance");
        add(ModAttributes.PUFFERFISH_BONUS.get().getDescriptionId(), "Pufferfish Chance");
        add(ModAttributes.SALMON_BONUS.get().getDescriptionId(), "Salmon Chance");
        add(ModAttributes.TROPICAL_FISH_BONUS.get().getDescriptionId(), "Tropical Fish Chance");
    }

    private void addItemGroups() {
        add("itemGroup.todecoinstab", "TodeCoins Main Tab");
        add("itemGroup.collectorcoinstab", "TodeCoins Collectible Coins");
    }

    private void addEffect() {
        add(MobEffects.LUCK, "Luck");
        addPotionEffects("luck", "Luck");

        add(MobEffects.UNLUCK, "Bad Luck");
        addPotionEffects("unluck", "Bad Luck");

        add(ModEffects.VENOM_STRIKE.get(), "Venomous Strike");
        addPotionEffects("venom_strike", "Venomous Strike");

        add(ModEffects.THORN_SHIELD.get(), "Shield of Thorns");
        addPotionEffects("thorn_shield", "Shield of Thorns");

        add(ModEffects.ILLAGER_BANE.get(), "Illager's Bane");
        addPotionEffects("illager_bane", "Illager's Bane");

        add(ModEffects.THUNDERSTRIKE.get(), "Thunder's Strike");
        addPotionEffects("thunderstrike", "Thunder's Strike");

        add(ModEffects.BLIND_SHIELD.get(), "Blindness Shield");
        addPotionEffects("blind_shield", "Blindness Shield");

        add(ModEffects.FROST_STRIKE.get(), "Frost Strike");
        addPotionEffects("frost_strike", "Frost Strike");

        add(ModEffects.BURNING_STRIKE.get(), "Burning Strike");
        addPotionEffects("burning_strike", "Burning Strike");

        add(ModEffects.GLOWING_AURA.get(), "Glowing Aura");
        addPotionEffects("glowing_aura", "Glowing Aura");

        add(ModEffects.HEALING_MIST.get(), "Healing Mist");
        addPotionEffects("healing_mist", "Healing Mist");

        add(ModEffects.ARTHROPOD_BLIGHT.get(), "Blight of Arthropods");
        addPotionEffects("arthropod_blight", "Blight of Arthropods");

        add(ModEffects.SILENCE_CLOAK.get(), "Cloak of Silence");
        addPotionEffects("silence_cloak", "Cloak of Silence");

        add(ModEffects.WITHERING_STRIKE.get(), "Withering Strike");
        addPotionEffects("withering_strike", "Withering Strike");

        add(ModEffects.HOLY_STRIKE.get(), "Holy Strike");
        addPotionEffects("holy_strike", "Holy Strike");
    }

    private void addPotionEffects(String id, String name) {
        String potionKey = id + "_potion";
        // regular potion of normal effect
        add("item.minecraft.potion.effect." + potionKey, "Potion of " + name);
        add("item.minecraft.potion.effect." + potionKey + "_2", "Potion of " + name + " II");
        add("item.minecraft.potion.effect." + potionKey + "_3", "Potion of " + name + " III");
        add("item.minecraft.potion.effect." + potionKey + "_4", "Potion of " + name + " IV");
        add("item.minecraft.potion.effect." + potionKey + "_5", "Potion of " + name + " V");
        add("item.minecraft.potion.effect." + potionKey + "_6", "Potion of " + name + " VI");

        // regular potion of extended effect
        add("item.minecraft.potion.effect.long_" + potionKey, "Potion of Extended " + name);
        add("item.minecraft.potion.effect.long_" + potionKey + "_2", "Potion of Extended " + name + " II");
        add("item.minecraft.potion.effect.long_" + potionKey + "_3", "Potion of Extended " + name + " III");
        add("item.minecraft.potion.effect.long_" + potionKey + "_4", "Potion of Extended " + name + " IV");
        add("item.minecraft.potion.effect.long_" + potionKey + "_5", "Potion of Extended " + name + " V");
        add("item.minecraft.potion.effect.long_" + potionKey + "_6", "Potion of Extended " + name + " VI");

        // splash potion of normal effect
        add("item.minecraft.splash_potion.effect." + potionKey, "Splash Potion of " + name);
        add("item.minecraft.splash_potion.effect." + potionKey + "_2", "Splash Potion of " + name + " II");
        add("item.minecraft.splash_potion.effect." + potionKey + "_3", "Splash Potion of " + name + " III");
        add("item.minecraft.splash_potion.effect." + potionKey + "_4", "Splash Potion of " + name + " IV");
        add("item.minecraft.splash_potion.effect." + potionKey + "_5", "Splash Potion of " + name + " V");
        add("item.minecraft.splash_potion.effect." + potionKey + "_6", "Splash Potion of " + name + " VI");

        // splash potion of extended effect
        add("item.minecraft.splash_potion.effect.long_" + potionKey, "Splash Potion of Extended " + name);
        add("item.minecraft.splash_potion.effect.long_" + potionKey + "_2", "Splash Potion of Extended " + name + " II");
        add("item.minecraft.splash_potion.effect.long_" + potionKey + "_3", "Splash Potion of Extended " + name + " III");
        add("item.minecraft.splash_potion.effect.long_" + potionKey + "_4", "Splash Potion of Extended " + name + " IV");
        add("item.minecraft.splash_potion.effect.long_" + potionKey + "_5", "Splash Potion of Extended " + name + " V");
        add("item.minecraft.splash_potion.effect.long_" + potionKey + "_6", "Splash Potion of Extended " + name + " VI");

        // lingering potion of normal effect
        add("item.minecraft.lingering_potion.effect." + potionKey, "Lingering Potion of " + name);
        add("item.minecraft.lingering_potion.effect." + potionKey + "_2", "Lingering Potion of " + name + " II");
        add("item.minecraft.lingering_potion.effect." + potionKey + "_3", "Lingering Potion of " + name + " III");
        add("item.minecraft.lingering_potion.effect." + potionKey + "_4", "Lingering Potion of " + name + " IV");
        add("item.minecraft.lingering_potion.effect." + potionKey + "_5", "Lingering Potion of " + name + " V");
        add("item.minecraft.lingering_potion.effect." + potionKey + "_6", "Lingering Potion of " + name + " VI");

        // lingering potion of extended effect
        add("item.minecraft.lingering_potion.effect.long_" + potionKey, "Lingering Potion of Extended " + name);
        add("item.minecraft.lingering_potion.effect.long_" + potionKey + "_2", "Lingering Potion of Extended " + name + " II");
        add("item.minecraft.lingering_potion.effect.long_" + potionKey + "_3", "Lingering Potion of Extended " + name + " III");
        add("item.minecraft.lingering_potion.effect.long_" + potionKey + "_4", "Lingering Potion of Extended " + name + " IV");
        add("item.minecraft.lingering_potion.effect.long_" + potionKey + "_5", "Lingering Potion of Extended " + name + " V");
        add("item.minecraft.lingering_potion.effect.long_" + potionKey + "_6", "Lingering Potion of Extended " + name + " VI");

        // tipped arrow of normal effect
        add("item.minecraft.tipped_arrow.effect." + potionKey, "Arrow of " + name);
        add("item.minecraft.tipped_arrow.effect." + potionKey + "_2", "Arrow of " + name + " II");
        add("item.minecraft.tipped_arrow.effect." + potionKey + "_3", "Arrow of " + name + " III");
        add("item.minecraft.tipped_arrow.effect." + potionKey + "_4", "Arrow of " + name + " IV");
        add("item.minecraft.tipped_arrow.effect." + potionKey + "_5", "Arrow of " + name + " V");
        add("item.minecraft.tipped_arrow.effect." + potionKey + "_6", "Arrow of " + name + " VI");

        // tipped arrow of extended effect
        add("item.minecraft.tipped_arrow.effect.long_" + potionKey, "Arrow of Extended " + name);
        add("item.minecraft.tipped_arrow.effect.long_" + potionKey + "_2", "Arrow of Extended " + name + " II");
        add("item.minecraft.tipped_arrow.effect.long_" + potionKey + "_3", "Arrow of Extended " + name + " III");
        add("item.minecraft.tipped_arrow.effect.long_" + potionKey + "_4", "Arrow of Extended " + name + " IV");
        add("item.minecraft.tipped_arrow.effect.long_" + potionKey + "_5", "Arrow of Extended " + name + " V");
        add("item.minecraft.tipped_arrow.effect.long_" + potionKey + "_6", "Arrow of Extended " + name + " VI");
    }
}