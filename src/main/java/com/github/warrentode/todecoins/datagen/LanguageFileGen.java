package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.item.ModItems;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Map;
import java.util.TreeMap;

public class LanguageFileGen extends LanguageProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().setLenient().create();
    private final Map<String, String> data = new TreeMap<>();
    private final DataGenerator generator;
    private final String modid;
    private final String locale;

    public LanguageFileGen(DataGenerator generator, String modid, String locale) {
        super(generator, TodeCoins.MODID, locale);
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
        addCollectibleCoins(ModItems.SCHOLAR_OWL_COIN.get().getDescriptionId(), "Scholar Owl Lifetime Coin");
        addCollectibleCoins(ModItems.TUXEDO_CAT_COIN.get().getDescriptionId(), "Tuxedo Cat Lifetime Coin");
        addCollectibleCoins(ModItems.LITTLE_BEAR_COIN.get().getDescriptionId(), "Little Bear Lifetime Coin");
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

        addCollectibleCoins(ModItems.COPPER_CREEPER_COIN.get().getDescriptionId(), "Copper Creeper Coin");
        addCollectibleCoins(ModItems.IRON_CREEPER_COIN.get().getDescriptionId(), "Iron Creeper Coin");
        addCollectibleCoins(ModItems.GOLD_CREEPER_COIN.get().getDescriptionId(), "Gold Creeper Coin");
        addCollectibleCoins(ModItems.NETHERITE_CREEPER_COIN.get().getDescriptionId(), "Netherite Creeper Coin");

        addCollectibleCoins(ModItems.COPPER_DOLPHIN_COIN.get().getDescriptionId(), "Copper Dolphin Coin");
        addCollectibleCoins(ModItems.IRON_DOLPHIN_COIN.get().getDescriptionId(), "Iron Dolphin Coin");
        addCollectibleCoins(ModItems.GOLD_DOLPHIN_COIN.get().getDescriptionId(), "Gold Dolphin Coin");
        addCollectibleCoins(ModItems.NETHERITE_DOLPHIN_COIN.get().getDescriptionId(), "Netherite Dolphin Coin");

        addCollectibleCoins(ModItems.COPPER_DONKEY_COIN.get().getDescriptionId(), "Copper Donkey Coin");
        addCollectibleCoins(ModItems.IRON_DONKEY_COIN.get().getDescriptionId(), "Iron Donkey Coin");
        addCollectibleCoins(ModItems.GOLD_DONKEY_COIN.get().getDescriptionId(), "Gold Donkey Coin");
        addCollectibleCoins(ModItems.NETHERITE_DONKEY_COIN.get().getDescriptionId(), "Netherite Donkey Coin");

        addCollectibleCoins(ModItems.COPPER_DROWNED_COIN.get().getDescriptionId(), "Copper Drowned Coin");
        addCollectibleCoins(ModItems.IRON_DROWNED_COIN.get().getDescriptionId(), "Iron Drowned Coin");
        addCollectibleCoins(ModItems.GOLD_DROWNED_COIN.get().getDescriptionId(), "Gold Drowned Coin");
        addCollectibleCoins(ModItems.NETHERITE_DROWNED_COIN.get().getDescriptionId(), "Netherite Drowned Coin");

        addCollectibleCoins(ModItems.COPPER_ELDER_GUARDIAN_COIN.get().getDescriptionId(), "Copper Elder Guardian Coin");
        addCollectibleCoins(ModItems.IRON_ELDER_GUARDIAN_COIN.get().getDescriptionId(), "Iron Elder Guardian Coin");
        addCollectibleCoins(ModItems.GOLD_ELDER_GUARDIAN_COIN.get().getDescriptionId(), "Gold Elder Guardian Coin");
        addCollectibleCoins(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get().getDescriptionId(), "Netherite Elder Guardian Coin");

        addCollectibleCoins(ModItems.COPPER_ENDER_DRAGON_COIN.get().getDescriptionId(), "Copper Ender Dragon Coin");
        addCollectibleCoins(ModItems.IRON_ENDER_DRAGON_COIN.get().getDescriptionId(), "Iron Ender Dragon Coin");
        addCollectibleCoins(ModItems.GOLD_ENDER_DRAGON_COIN.get().getDescriptionId(), "Gold Ender Dragon Coin");
        addCollectibleCoins(ModItems.NETHERITE_ENDER_DRAGON_COIN.get().getDescriptionId(), "Netherite Ender Dragon Coin");

        addCollectibleCoins(ModItems.COPPER_ENDERMAN_COIN.get().getDescriptionId(), "Copper Enderman Coin");
        addCollectibleCoins(ModItems.IRON_ENDERMAN_COIN.get().getDescriptionId(), "Iron Enderman Coin");
        addCollectibleCoins(ModItems.GOLD_ENDERMAN_COIN.get().getDescriptionId(), "Gold Enderman Coin");
        addCollectibleCoins(ModItems.NETHERITE_ENDERMAN_COIN.get().getDescriptionId(), "Netherite Enderman Coin");

        addCollectibleCoins(ModItems.COPPER_ENDERMITE_COIN.get().getDescriptionId(), "Copper Endermite Coin");
        addCollectibleCoins(ModItems.IRON_ENDERMITE_COIN.get().getDescriptionId(), "Iron Endermite Coin");
        addCollectibleCoins(ModItems.GOLD_ENDERMITE_COIN.get().getDescriptionId(), "Gold Endermite Coin");
        addCollectibleCoins(ModItems.NETHERITE_ENDERMITE_COIN.get().getDescriptionId(), "Netherite Endermite Coin");

        addCollectibleCoins(ModItems.COPPER_EVOKER_COIN.get().getDescriptionId(), "Copper Evoker Coin");
        addCollectibleCoins(ModItems.IRON_EVOKER_COIN.get().getDescriptionId(), "Iron Evoker Coin");
        addCollectibleCoins(ModItems.GOLD_EVOKER_COIN.get().getDescriptionId(), "Gold Evoker Coin");
        addCollectibleCoins(ModItems.NETHERITE_EVOKER_COIN.get().getDescriptionId(), "Netherite Evoker Coin");

        addCollectibleCoins(ModItems.COPPER_FOX_COIN.get().getDescriptionId(), "Copper Fox Coin");
        addCollectibleCoins(ModItems.IRON_FOX_COIN.get().getDescriptionId(), "Iron Fox Coin");
        addCollectibleCoins(ModItems.GOLD_FOX_COIN.get().getDescriptionId(), "Gold Fox Coin");
        addCollectibleCoins(ModItems.NETHERITE_FOX_COIN.get().getDescriptionId(), "Netherite Fox Coin");

        addCollectibleCoins(ModItems.COPPER_FROG_COIN.get().getDescriptionId(), "Copper Frog Coin");
        addCollectibleCoins(ModItems.IRON_FROG_COIN.get().getDescriptionId(), "Iron Frog Coin");
        addCollectibleCoins(ModItems.GOLD_FROG_COIN.get().getDescriptionId(), "Gold Frog Coin");
        addCollectibleCoins(ModItems.NETHERITE_FROG_COIN.get().getDescriptionId(), "Netherite Frog Coin");

        addCollectibleCoins(ModItems.COPPER_GIANT_COIN.get().getDescriptionId(), "Copper Giant Coin");
        addCollectibleCoins(ModItems.IRON_GIANT_COIN.get().getDescriptionId(), "Iron Giant Coin");
        addCollectibleCoins(ModItems.GOLD_GIANT_COIN.get().getDescriptionId(), "Gold Giant Coin");
        addCollectibleCoins(ModItems.NETHERITE_GIANT_COIN.get().getDescriptionId(), "Netherite Giant Coin");

        addCollectibleCoins(ModItems.COPPER_GLOW_SQUID_COIN.get().getDescriptionId(), "Copper Glow Squid Coin");
        addCollectibleCoins(ModItems.IRON_GLOW_SQUID_COIN.get().getDescriptionId(), "Iron Glow Squid Coin");
        addCollectibleCoins(ModItems.GOLD_GLOW_SQUID_COIN.get().getDescriptionId(), "Gold Glow Squid Coin");
        addCollectibleCoins(ModItems.NETHERITE_GLOW_SQUID_COIN.get().getDescriptionId(), "Netherite Glow Squid Coin");

        addCollectibleCoins(ModItems.COPPER_GOAT_COIN.get().getDescriptionId(), "Copper Goat Coin");
        addCollectibleCoins(ModItems.IRON_GOAT_COIN.get().getDescriptionId(), "Iron Goat Coin");
        addCollectibleCoins(ModItems.GOLD_GOAT_COIN.get().getDescriptionId(), "Gold Goat Coin");
        addCollectibleCoins(ModItems.NETHERITE_GOAT_COIN.get().getDescriptionId(), "Netherite Goat Coin");

        addCollectibleCoins(ModItems.COPPER_GUARDIAN_COIN.get().getDescriptionId(), "Copper Guardian Coin");
        addCollectibleCoins(ModItems.IRON_GUARDIAN_COIN.get().getDescriptionId(), "Iron Guardian Coin");
        addCollectibleCoins(ModItems.GOLD_GUARDIAN_COIN.get().getDescriptionId(), "Gold Guardian Coin");
        addCollectibleCoins(ModItems.NETHERITE_GUARDIAN_COIN.get().getDescriptionId(), "Netherite Guardian Coin");

        addCollectibleCoins(ModItems.COPPER_GHAST_COIN.get().getDescriptionId(), "Copper Ghast Coin");
        addCollectibleCoins(ModItems.IRON_GHAST_COIN.get().getDescriptionId(), "Iron Ghast Coin");
        addCollectibleCoins(ModItems.GOLD_GHAST_COIN.get().getDescriptionId(), "Gold Ghast Coin");
        addCollectibleCoins(ModItems.NETHERITE_GHAST_COIN.get().getDescriptionId(), "Netherite Ghast Coin");

        addCollectibleCoins(ModItems.COPPER_HOGLIN_COIN.get().getDescriptionId(), "Copper Hoglin Coin");
        addCollectibleCoins(ModItems.IRON_HOGLIN_COIN.get().getDescriptionId(), "Iron Hoglin Coin");
        addCollectibleCoins(ModItems.GOLD_HOGLIN_COIN.get().getDescriptionId(), "Gold Hoglin Coin");
        addCollectibleCoins(ModItems.NETHERITE_HOGLIN_COIN.get().getDescriptionId(), "Netherite Hoglin Coin");

        addCollectibleCoins(ModItems.COPPER_HORSE_COIN.get().getDescriptionId(), "Copper Horse Coin");
        addCollectibleCoins(ModItems.IRON_HORSE_COIN.get().getDescriptionId(), "Iron Horse Coin");
        addCollectibleCoins(ModItems.GOLD_HORSE_COIN.get().getDescriptionId(), "Gold Horse Coin");
        addCollectibleCoins(ModItems.NETHERITE_HORSE_COIN.get().getDescriptionId(), "Netherite Horse Coin");

        addCollectibleCoins(ModItems.COPPER_HUSK_COIN.get().getDescriptionId(), "Copper Husk Coin");
        addCollectibleCoins(ModItems.IRON_HUSK_COIN.get().getDescriptionId(), "Iron Husk Coin");
        addCollectibleCoins(ModItems.GOLD_HUSK_COIN.get().getDescriptionId(), "Gold Husk Coin");
        addCollectibleCoins(ModItems.NETHERITE_HUSK_COIN.get().getDescriptionId(), "Netherite Husk Coin");

        addCollectibleCoins(ModItems.COPPER_IRON_GOLEM_COIN.get().getDescriptionId(), "Copper Iron Golem Coin");
        addCollectibleCoins(ModItems.IRON_IRON_GOLEM_COIN.get().getDescriptionId(), "Iron Iron Golem Coin");
        addCollectibleCoins(ModItems.GOLD_IRON_GOLEM_COIN.get().getDescriptionId(), "Gold Iron Golem Coin");
        addCollectibleCoins(ModItems.NETHERITE_IRON_GOLEM_COIN.get().getDescriptionId(), "Netherite Iron Golem Coin");

        addCollectibleCoins(ModItems.COPPER_ILLUSIONER_COIN.get().getDescriptionId(), "Copper Illusioner Coin");
        addCollectibleCoins(ModItems.IRON_ILLUSIONER_COIN.get().getDescriptionId(), "Iron Illusioner Coin");
        addCollectibleCoins(ModItems.GOLD_ILLUSIONER_COIN.get().getDescriptionId(), "Gold Illusioner Coin");
        addCollectibleCoins(ModItems.NETHERITE_ILLUSIONER_COIN.get().getDescriptionId(), "Netherite Illusioner Coin");

        addCollectibleCoins(ModItems.COPPER_LLAMA_COIN.get().getDescriptionId(), "Copper Llama Coin");
        addCollectibleCoins(ModItems.IRON_LLAMA_COIN.get().getDescriptionId(), "Iron Llama Coin");
        addCollectibleCoins(ModItems.GOLD_LLAMA_COIN.get().getDescriptionId(), "Gold Llama Coin");
        addCollectibleCoins(ModItems.NETHERITE_LLAMA_COIN.get().getDescriptionId(), "Netherite Llama Coin");

        addCollectibleCoins(ModItems.COPPER_MAGMA_CUBE_COIN.get().getDescriptionId(), "Copper Magma Cube Coin");
        addCollectibleCoins(ModItems.IRON_MAGMA_CUBE_COIN.get().getDescriptionId(), "Iron Magma Cube Coin");
        addCollectibleCoins(ModItems.GOLD_MAGMA_CUBE_COIN.get().getDescriptionId(), "Gold Magma Cube Coin");
        addCollectibleCoins(ModItems.NETHERITE_MAGMA_CUBE_COIN.get().getDescriptionId(), "Netherite Magma Cube Coin");

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

        addCollectibleCoins(ModItems.COPPER_PANDA_COIN.get().getDescriptionId(), "Copper Panda Coin");
        addCollectibleCoins(ModItems.IRON_PANDA_COIN.get().getDescriptionId(), "Iron Panda Coin");
        addCollectibleCoins(ModItems.GOLD_PANDA_COIN.get().getDescriptionId(), "Gold Panda Coin");
        addCollectibleCoins(ModItems.NETHERITE_PANDA_COIN.get().getDescriptionId(), "Netherite Panda Coin");

        addCollectibleCoins(ModItems.COPPER_PARROT_COIN.get().getDescriptionId(), "Copper Parrot Coin");
        addCollectibleCoins(ModItems.IRON_PARROT_COIN.get().getDescriptionId(), "Iron Parrot Coin");
        addCollectibleCoins(ModItems.GOLD_PARROT_COIN.get().getDescriptionId(), "Gold Parrot Coin");
        addCollectibleCoins(ModItems.NETHERITE_PARROT_COIN.get().getDescriptionId(), "Netherite Parrot Coin");

        addCollectibleCoins(ModItems.COPPER_PHANTOM_COIN.get().getDescriptionId(), "Copper Phantom Coin");
        addCollectibleCoins(ModItems.IRON_PHANTOM_COIN.get().getDescriptionId(), "Iron Phantom Coin");
        addCollectibleCoins(ModItems.GOLD_PHANTOM_COIN.get().getDescriptionId(), "Gold Phantom Coin");
        addCollectibleCoins(ModItems.NETHERITE_PHANTOM_COIN.get().getDescriptionId(), "Netherite Phantom Coin");

        addCollectibleCoins(ModItems.COPPER_PIG_COIN.get().getDescriptionId(), "Copper Pig Coin");
        addCollectibleCoins(ModItems.IRON_PIG_COIN.get().getDescriptionId(), "Iron Pig Coin");
        addCollectibleCoins(ModItems.GOLD_PIG_COIN.get().getDescriptionId(), "Gold Pig Coin");
        addCollectibleCoins(ModItems.NETHERITE_PIG_COIN.get().getDescriptionId(), "Netherite Pig Coin");

        addCollectibleCoins(ModItems.COPPER_PIGLIN_BRUTE_COIN.get().getDescriptionId(), "Copper Piglin Brute Coin");
        addCollectibleCoins(ModItems.IRON_PIGLIN_BRUTE_COIN.get().getDescriptionId(), "Iron Piglin Brute Coin");
        addCollectibleCoins(ModItems.GOLD_PIGLIN_BRUTE_COIN.get().getDescriptionId(), "Gold Piglin Brute Coin");
        addCollectibleCoins(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get().getDescriptionId(), "Netherite Piglin Brute Coin");

        addCollectibleCoins(ModItems.COPPER_PIGLIN_COIN.get().getDescriptionId(), "Copper Piglin Coin");
        addCollectibleCoins(ModItems.IRON_PIGLIN_COIN.get().getDescriptionId(), "Iron Piglin Coin");
        addCollectibleCoins(ModItems.GOLD_PIGLIN_COIN.get().getDescriptionId(), "Gold Piglin Coin");
        addCollectibleCoins(ModItems.NETHERITE_PIGLIN_COIN.get().getDescriptionId(), "Netherite Piglin Coin");

        addCollectibleCoins(ModItems.COPPER_PILLAGER_COIN.get().getDescriptionId(), "Copper Pillager Coin");
        addCollectibleCoins(ModItems.IRON_PILLAGER_COIN.get().getDescriptionId(), "Iron Pillager Coin");
        addCollectibleCoins(ModItems.GOLD_PILLAGER_COIN.get().getDescriptionId(), "Gold Pillager Coin");
        addCollectibleCoins(ModItems.NETHERITE_PILLAGER_COIN.get().getDescriptionId(), "Netherite Pillager Coin");

        addCollectibleCoins(ModItems.COPPER_POLAR_BEAR_COIN.get().getDescriptionId(), "Copper Polar Bear Coin");
        addCollectibleCoins(ModItems.IRON_POLAR_BEAR_COIN.get().getDescriptionId(), "Iron Polar Bear Coin");
        addCollectibleCoins(ModItems.GOLD_POLAR_BEAR_COIN.get().getDescriptionId(), "Gold Polar Bear Coin");
        addCollectibleCoins(ModItems.NETHERITE_POLAR_BEAR_COIN.get().getDescriptionId(), "Netherite Polar Bear Coin");

        addCollectibleCoins(ModItems.COPPER_RABBIT_COIN.get().getDescriptionId(), "Copper Rabbit Coin");
        addCollectibleCoins(ModItems.IRON_RABBIT_COIN.get().getDescriptionId(), "Iron Rabbit Coin");
        addCollectibleCoins(ModItems.GOLD_RABBIT_COIN.get().getDescriptionId(), "Gold Rabbit Coin");
        addCollectibleCoins(ModItems.NETHERITE_RABBIT_COIN.get().getDescriptionId(), "Netherite Rabbit Coin");

        addCollectibleCoins(ModItems.COPPER_RAVAGER_COIN.get().getDescriptionId(), "Copper Ravager Coin");
        addCollectibleCoins(ModItems.IRON_RAVAGER_COIN.get().getDescriptionId(), "Iron Ravager Coin");
        addCollectibleCoins(ModItems.GOLD_RAVAGER_COIN.get().getDescriptionId(), "Gold Ravager Coin");
        addCollectibleCoins(ModItems.NETHERITE_RAVAGER_COIN.get().getDescriptionId(), "Netherite Ravager Coin");

        addCollectibleCoins(ModItems.COPPER_SHEEP_COIN.get().getDescriptionId(), "Copper Sheep Coin");
        addCollectibleCoins(ModItems.IRON_SHEEP_COIN.get().getDescriptionId(), "Iron Sheep Coin");
        addCollectibleCoins(ModItems.GOLD_SHEEP_COIN.get().getDescriptionId(), "Gold Sheep Coin");
        addCollectibleCoins(ModItems.NETHERITE_SHEEP_COIN.get().getDescriptionId(), "Netherite Sheep Coin");

        addCollectibleCoins(ModItems.COPPER_SHULKER_COIN.get().getDescriptionId(), "Copper Shulker Coin");
        addCollectibleCoins(ModItems.IRON_SHULKER_COIN.get().getDescriptionId(), "Iron Shulker Coin");
        addCollectibleCoins(ModItems.GOLD_SHULKER_COIN.get().getDescriptionId(), "Gold Shulker Coin");
        addCollectibleCoins(ModItems.NETHERITE_SHULKER_COIN.get().getDescriptionId(), "Netherite Shulker Coin");

        addCollectibleCoins(ModItems.COPPER_SILVERFISH_COIN.get().getDescriptionId(), "Copper Silverfish Coin");
        addCollectibleCoins(ModItems.IRON_SILVERFISH_COIN.get().getDescriptionId(), "Iron Silverfish Coin");
        addCollectibleCoins(ModItems.GOLD_SILVERFISH_COIN.get().getDescriptionId(), "Gold Silverfish Coin");
        addCollectibleCoins(ModItems.NETHERITE_SILVERFISH_COIN.get().getDescriptionId(), "Netherite Silverfish Coin");

        addCollectibleCoins(ModItems.COPPER_SKELETON_COIN.get().getDescriptionId(), "Copper Skeleton Coin");
        addCollectibleCoins(ModItems.IRON_SKELETON_COIN.get().getDescriptionId(), "Iron Skeleton Coin");
        addCollectibleCoins(ModItems.GOLD_SKELETON_COIN.get().getDescriptionId(), "Gold Skeleton Coin");
        addCollectibleCoins(ModItems.NETHERITE_SKELETON_COIN.get().getDescriptionId(), "Netherite Skeleton Coin");

        addCollectibleCoins(ModItems.COPPER_SKELETON_HORSE_COIN.get().getDescriptionId(), "Copper Skeleton Horse Coin");
        addCollectibleCoins(ModItems.IRON_SKELETON_HORSE_COIN.get().getDescriptionId(), "Iron Skeleton Horse Coin");
        addCollectibleCoins(ModItems.GOLD_SKELETON_HORSE_COIN.get().getDescriptionId(), "Gold Skeleton Horse Coin");
        addCollectibleCoins(ModItems.NETHERITE_SKELETON_HORSE_COIN.get().getDescriptionId(), "Netherite Skeleton Horse Coin");

        addCollectibleCoins(ModItems.COPPER_SLIME_COIN.get().getDescriptionId(), "Copper Slime Coin");
        addCollectibleCoins(ModItems.IRON_SLIME_COIN.get().getDescriptionId(), "Iron Slime Coin");
        addCollectibleCoins(ModItems.GOLD_SLIME_COIN.get().getDescriptionId(), "Gold Slime Coin");
        addCollectibleCoins(ModItems.NETHERITE_SLIME_COIN.get().getDescriptionId(), "Netherite Slime Coin");

        addCollectibleCoins(ModItems.COPPER_SNIFFER_COIN.get().getDescriptionId(), "Copper Sniffer Coin");
        addCollectibleCoins(ModItems.IRON_SNIFFER_COIN.get().getDescriptionId(), "Iron Sniffer Coin");
        addCollectibleCoins(ModItems.GOLD_SNIFFER_COIN.get().getDescriptionId(), "Gold Sniffer Coin");
        addCollectibleCoins(ModItems.NETHERITE_SNIFFER_COIN.get().getDescriptionId(), "Netherite Sniffer Coin");

        addCollectibleCoins(ModItems.COPPER_SNOW_GOLEM_COIN.get().getDescriptionId(), "Copper Snow Golem Coin");
        addCollectibleCoins(ModItems.IRON_SNOW_GOLEM_COIN.get().getDescriptionId(), "Iron Snow Golem Coin");
        addCollectibleCoins(ModItems.GOLD_SNOW_GOLEM_COIN.get().getDescriptionId(), "Gold Snow Golem Coin");
        addCollectibleCoins(ModItems.NETHERITE_SNOW_GOLEM_COIN.get().getDescriptionId(), "Netherite Snow Golem Coin");

        addCollectibleCoins(ModItems.COPPER_SPIDER_COIN.get().getDescriptionId(), "Copper Spider Coin");
        addCollectibleCoins(ModItems.IRON_SPIDER_COIN.get().getDescriptionId(), "Iron Spider Coin");
        addCollectibleCoins(ModItems.GOLD_SPIDER_COIN.get().getDescriptionId(), "Gold Spider Coin");
        addCollectibleCoins(ModItems.NETHERITE_SPIDER_COIN.get().getDescriptionId(), "Netherite Spider Coin");

        addCollectibleCoins(ModItems.COPPER_SQUID_COIN.get().getDescriptionId(), "Copper Squid Coin");
        addCollectibleCoins(ModItems.IRON_SQUID_COIN.get().getDescriptionId(), "Iron Squid Coin");
        addCollectibleCoins(ModItems.GOLD_SQUID_COIN.get().getDescriptionId(), "Gold Squid Coin");
        addCollectibleCoins(ModItems.NETHERITE_SQUID_COIN.get().getDescriptionId(), "Netherite Squid Coin");

        addCollectibleCoins(ModItems.COPPER_STRAY_COIN.get().getDescriptionId(), "Copper Stray Coin");
        addCollectibleCoins(ModItems.IRON_STRAY_COIN.get().getDescriptionId(), "Iron Stray Coin");
        addCollectibleCoins(ModItems.GOLD_STRAY_COIN.get().getDescriptionId(), "Gold Stray Coin");
        addCollectibleCoins(ModItems.NETHERITE_STRAY_COIN.get().getDescriptionId(), "Netherite Stray Coin");

        addCollectibleCoins(ModItems.COPPER_STRIDER_COIN.get().getDescriptionId(), "Copper Strider Coin");
        addCollectibleCoins(ModItems.IRON_STRIDER_COIN.get().getDescriptionId(), "Iron Strider Coin");
        addCollectibleCoins(ModItems.GOLD_STRIDER_COIN.get().getDescriptionId(), "Gold Strider Coin");
        addCollectibleCoins(ModItems.NETHERITE_STRIDER_COIN.get().getDescriptionId(), "Netherite Strider Coin");

        addCollectibleCoins(ModItems.COPPER_TADPOLE_COIN.get().getDescriptionId(), "Copper Tadpole Coin");
        addCollectibleCoins(ModItems.IRON_TADPOLE_COIN.get().getDescriptionId(), "Iron Tadpole Coin");
        addCollectibleCoins(ModItems.GOLD_TADPOLE_COIN.get().getDescriptionId(), "Gold Tadpole Coin");
        addCollectibleCoins(ModItems.NETHERITE_TADPOLE_COIN.get().getDescriptionId(), "Netherite Tadpole Coin");

        addCollectibleCoins(ModItems.COPPER_TRADER_LLAMA_COIN.get().getDescriptionId(), "Copper Trader Llama Coin");
        addCollectibleCoins(ModItems.IRON_TRADER_LLAMA_COIN.get().getDescriptionId(), "Iron Trader Llama Coin");
        addCollectibleCoins(ModItems.GOLD_TRADER_LLAMA_COIN.get().getDescriptionId(), "Gold Trader Llama Coin");
        addCollectibleCoins(ModItems.NETHERITE_TRADER_LLAMA_COIN.get().getDescriptionId(), "Netherite Trader Llama Coin");

        addCollectibleCoins(ModItems.COPPER_TURTLE_COIN.get().getDescriptionId(), "Copper Turtle Coin");
        addCollectibleCoins(ModItems.IRON_TURTLE_COIN.get().getDescriptionId(), "Iron Turtle Coin");
        addCollectibleCoins(ModItems.GOLD_TURTLE_COIN.get().getDescriptionId(), "Gold Turtle Coin");
        addCollectibleCoins(ModItems.NETHERITE_TURTLE_COIN.get().getDescriptionId(), "Netherite Turtle Coin");

        addCollectibleCoins(ModItems.COPPER_VEX_COIN.get().getDescriptionId(), "Copper Vex Coin");
        addCollectibleCoins(ModItems.IRON_VEX_COIN.get().getDescriptionId(), "Iron Vex Coin");
        addCollectibleCoins(ModItems.GOLD_VEX_COIN.get().getDescriptionId(), "Gold Vex Coin");
        addCollectibleCoins(ModItems.NETHERITE_VEX_COIN.get().getDescriptionId(), "Netherite Vex Coin");

        addCollectibleCoins(ModItems.COPPER_VILLAGER_COIN.get().getDescriptionId(), "Copper Villager Coin");
        addCollectibleCoins(ModItems.IRON_VILLAGER_COIN.get().getDescriptionId(), "Iron Villager Coin");
        addCollectibleCoins(ModItems.GOLD_VILLAGER_COIN.get().getDescriptionId(), "Gold Villager Coin");
        addCollectibleCoins(ModItems.NETHERITE_VILLAGER_COIN.get().getDescriptionId(), "Netherite Villager Coin");

        addCollectibleCoins(ModItems.COPPER_VINDICATOR_COIN.get().getDescriptionId(), "Copper Vindicator Coin");
        addCollectibleCoins(ModItems.IRON_VINDICATOR_COIN.get().getDescriptionId(), "Iron Vindicator Coin");
        addCollectibleCoins(ModItems.GOLD_VINDICATOR_COIN.get().getDescriptionId(), "Gold Vindicator Coin");
        addCollectibleCoins(ModItems.NETHERITE_VINDICATOR_COIN.get().getDescriptionId(), "Netherite Vindicator Coin");

        addCollectibleCoins(ModItems.COPPER_WANDERING_TRADER_COIN.get().getDescriptionId(), "Copper Wandering Trader Coin");
        addCollectibleCoins(ModItems.IRON_WANDERING_TRADER_COIN.get().getDescriptionId(), "Iron Wandering Trader Coin");
        addCollectibleCoins(ModItems.GOLD_WANDERING_TRADER_COIN.get().getDescriptionId(), "Gold Wandering Trader Coin");
        addCollectibleCoins(ModItems.NETHERITE_WANDERING_TRADER_COIN.get().getDescriptionId(), "Netherite Wandering Trader Coin");

        addCollectibleCoins(ModItems.COPPER_WARDEN_COIN.get().getDescriptionId(), "Copper Warden Coin");
        addCollectibleCoins(ModItems.IRON_WARDEN_COIN.get().getDescriptionId(), "Iron Warden Coin");
        addCollectibleCoins(ModItems.GOLD_WARDEN_COIN.get().getDescriptionId(), "Gold Warden Coin");
        addCollectibleCoins(ModItems.NETHERITE_WARDEN_COIN.get().getDescriptionId(), "Netherite Warden Coin");

        addCollectibleCoins(ModItems.COPPER_WITCH_COIN.get().getDescriptionId(), "Copper Witch Coin");
        addCollectibleCoins(ModItems.IRON_WITCH_COIN.get().getDescriptionId(), "Iron Witch Coin");
        addCollectibleCoins(ModItems.GOLD_WITCH_COIN.get().getDescriptionId(), "Gold Witch Coin");
        addCollectibleCoins(ModItems.NETHERITE_WITCH_COIN.get().getDescriptionId(), "Netherite Witch Coin");

        addCollectibleCoins(ModItems.COPPER_WITHER_SKELETON_COIN.get().getDescriptionId(), "Copper Wither Skeleton Coin");
        addCollectibleCoins(ModItems.IRON_WITHER_SKELETON_COIN.get().getDescriptionId(), "Iron Wither Skeleton Coin");
        addCollectibleCoins(ModItems.GOLD_WITHER_SKELETON_COIN.get().getDescriptionId(), "Gold Wither Skeleton Coin");
        addCollectibleCoins(ModItems.NETHERITE_WITHER_SKELETON_COIN.get().getDescriptionId(), "Netherite Wither Skeleton Coin");

        addCollectibleCoins(ModItems.COPPER_WITHER_COIN.get().getDescriptionId(), "Copper Wither Coin");
        addCollectibleCoins(ModItems.IRON_WITHER_COIN.get().getDescriptionId(), "Iron Wither Coin");
        addCollectibleCoins(ModItems.GOLD_WITHER_COIN.get().getDescriptionId(), "Gold Wither Coin");
        addCollectibleCoins(ModItems.NETHERITE_WITHER_COIN.get().getDescriptionId(), "Netherite Wither Coin");

        addCollectibleCoins(ModItems.COPPER_WOLF_COIN.get().getDescriptionId(), "Copper Wolf Coin");
        addCollectibleCoins(ModItems.IRON_WOLF_COIN.get().getDescriptionId(), "Iron Wolf Coin");
        addCollectibleCoins(ModItems.GOLD_WOLF_COIN.get().getDescriptionId(), "Gold Wolf Coin");
        addCollectibleCoins(ModItems.NETHERITE_WOLF_COIN.get().getDescriptionId(), "Netherite Wolf Coin");

        addCollectibleCoins(ModItems.COPPER_ZOGLIN_COIN.get().getDescriptionId(), "Copper Zoglin Coin");
        addCollectibleCoins(ModItems.IRON_ZOGLIN_COIN.get().getDescriptionId(), "Iron Zoglin Coin");
        addCollectibleCoins(ModItems.GOLD_ZOGLIN_COIN.get().getDescriptionId(), "Gold Zoglin Coin");
        addCollectibleCoins(ModItems.NETHERITE_ZOGLIN_COIN.get().getDescriptionId(), "Netherite Zoglin Coin");

        addCollectibleCoins(ModItems.COPPER_ZOMBIE_COIN.get().getDescriptionId(), "Copper Zombie Coin");
        addCollectibleCoins(ModItems.IRON_ZOMBIE_COIN.get().getDescriptionId(), "Iron Zombie Coin");
        addCollectibleCoins(ModItems.GOLD_ZOMBIE_COIN.get().getDescriptionId(), "Gold Zombie Coin");
        addCollectibleCoins(ModItems.NETHERITE_ZOMBIE_COIN.get().getDescriptionId(), "Netherite Zombie Coin");

        addCollectibleCoins(ModItems.COPPER_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Copper Zombie Horse Coin");
        addCollectibleCoins(ModItems.IRON_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Iron Zombie Horse Coin");
        addCollectibleCoins(ModItems.GOLD_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Gold Zombie Horse Coin");
        addCollectibleCoins(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get().getDescriptionId(), "Netherite Zombie Horse Coin");

        addCollectibleCoins(ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(), "Copper Zombie Villager Coin");
        addCollectibleCoins(ModItems.IRON_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(), "Iron Zombie Villager Coin");
        addCollectibleCoins(ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(), "Gold Zombie Villager Coin");
        addCollectibleCoins(ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get().getDescriptionId(), "Netherite Zombie Villager Coin");

        addCollectibleCoins(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(), "Copper Zombified Piglin Coin");
        addCollectibleCoins(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(), "Iron Zombified Piglin Coin");
        addCollectibleCoins(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(), "Gold Zombified Piglin Coin");
        addCollectibleCoins(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get().getDescriptionId(), "Netherite Zombified Piglin Coin");

        // friends and foes theme coins
        addCollectibleCoins(ModItems.COPPER_MOOBLOOM_COIN.get().getDescriptionId(), "Copper Moobloom Coin");
        addCollectibleCoins(ModItems.IRON_MOOBLOOM_COIN.get().getDescriptionId(), "Iron Moobloom Coin");
        addCollectibleCoins(ModItems.GOLD_MOOBLOOM_COIN.get().getDescriptionId(), "Gold Moobloom Coin");
        addCollectibleCoins(ModItems.NETHERITE_MOOBLOOM_COIN.get().getDescriptionId(), "Netherite Moobloom Coin");

        addCollectibleCoins(ModItems.COPPER_COPPER_GOLEM_COIN.get().getDescriptionId(), "Copper Copper Golem Coin");
        addCollectibleCoins(ModItems.IRON_COPPER_GOLEM_COIN.get().getDescriptionId(), "Iron Copper Golem Coin");
        addCollectibleCoins(ModItems.GOLD_COPPER_GOLEM_COIN.get().getDescriptionId(), "Gold Copper Golem Coin");
        addCollectibleCoins(ModItems.NETHERITE_COPPER_GOLEM_COIN.get().getDescriptionId(), "Netherite Copper Golem Coin");

        addCollectibleCoins(ModItems.COPPER_GLARE_COIN.get().getDescriptionId(), "Copper Glare Coin");
        addCollectibleCoins(ModItems.IRON_GLARE_COIN.get().getDescriptionId(), "Iron Glare Coin");
        addCollectibleCoins(ModItems.GOLD_GLARE_COIN.get().getDescriptionId(), "Gold Glare Coin");
        addCollectibleCoins(ModItems.NETHERITE_GLARE_COIN.get().getDescriptionId(), "Netherite Glare Coin");

        addCollectibleCoins(ModItems.COPPER_ICEOLOGER_COIN.get().getDescriptionId(), "Copper Iceologer Coin");
        addCollectibleCoins(ModItems.IRON_ICEOLOGER_COIN.get().getDescriptionId(), "Iron Iceologer Coin");
        addCollectibleCoins(ModItems.GOLD_ICEOLOGER_COIN.get().getDescriptionId(), "Gold Iceologer Coin");
        addCollectibleCoins(ModItems.NETHERITE_ICEOLOGER_COIN.get().getDescriptionId(), "Netherite Iceologer Coin");

        addCollectibleCoins(ModItems.COPPER_MAULER_COIN.get().getDescriptionId(), "Copper Mauler Coin");
        addCollectibleCoins(ModItems.IRON_MAULER_COIN.get().getDescriptionId(), "Iron Mauler Coin");
        addCollectibleCoins(ModItems.GOLD_MAULER_COIN.get().getDescriptionId(), "Gold Mauler Coin");
        addCollectibleCoins(ModItems.NETHERITE_MAULER_COIN.get().getDescriptionId(), "Netherite Mauler Coin");

        addCollectibleCoins(ModItems.COPPER_WILDFIRE_COIN.get().getDescriptionId(), "Copper Wildfire Coin");
        addCollectibleCoins(ModItems.IRON_WILDFIRE_COIN.get().getDescriptionId(), "Iron Wildfire Coin");
        addCollectibleCoins(ModItems.GOLD_WILDFIRE_COIN.get().getDescriptionId(), "Gold Wildfire Coin");
        addCollectibleCoins(ModItems.NETHERITE_WILDFIRE_COIN.get().getDescriptionId(), "Netherite Wildfire Coin");

        addCollectibleCoins(ModItems.COPPER_TUFF_GOLEM_COIN.get().getDescriptionId(), "Copper Tuff Golem Coin");
        addCollectibleCoins(ModItems.IRON_TUFF_GOLEM_COIN.get().getDescriptionId(), "Iron Tuff Golem Coin");
        addCollectibleCoins(ModItems.GOLD_TUFF_GOLEM_COIN.get().getDescriptionId(), "Gold Tuff Golem Coin");
        addCollectibleCoins(ModItems.NETHERITE_TUFF_GOLEM_COIN.get().getDescriptionId(), "Netherite Tuff Golem Coin");

        // ecologics theme coins
        addCollectibleCoins(ModItems.COPPER_CRAB_COIN.get().getDescriptionId(), "Copper Crab Coin");
        addCollectibleCoins(ModItems.IRON_CRAB_COIN.get().getDescriptionId(), "Iron Crab Coin");
        addCollectibleCoins(ModItems.GOLD_CRAB_COIN.get().getDescriptionId(), "Gold Crab Coin");
        addCollectibleCoins(ModItems.NETHERITE_CRAB_COIN.get().getDescriptionId(), "Netherite Crab Coin");

        addCollectibleCoins(ModItems.COPPER_SQUIRREL_COIN.get().getDescriptionId(), "Copper Squirrel Coin");
        addCollectibleCoins(ModItems.IRON_SQUIRREL_COIN.get().getDescriptionId(), "Iron Squirrel Coin");
        addCollectibleCoins(ModItems.GOLD_SQUIRREL_COIN.get().getDescriptionId(), "Gold Squirrel Coin");
        addCollectibleCoins(ModItems.NETHERITE_SQUIRREL_COIN.get().getDescriptionId(), "Netherite Squirrel Coin");

        addCollectibleCoins(ModItems.COPPER_PENGUIN_COIN.get().getDescriptionId(), "Copper Penguin Coin");
        addCollectibleCoins(ModItems.IRON_PENGUIN_COIN.get().getDescriptionId(), "Iron Penguin Coin");
        addCollectibleCoins(ModItems.GOLD_PENGUIN_COIN.get().getDescriptionId(), "Gold Penguin Coin");
        addCollectibleCoins(ModItems.NETHERITE_PENGUIN_COIN.get().getDescriptionId(), "Netherite Penguin Coin");

        // guard villagers theme coins
        addCollectibleCoins(ModItems.COPPER_GUARD_COIN.get().getDescriptionId(), "Copper Guard Coin");
        addCollectibleCoins(ModItems.IRON_GUARD_COIN.get().getDescriptionId(), "Iron Guard Coin");
        addCollectibleCoins(ModItems.GOLD_GUARD_COIN.get().getDescriptionId(), "Gold Guard Coin");
        addCollectibleCoins(ModItems.NETHERITE_GUARD_COIN.get().getDescriptionId(), "Netherite Guard Coin");

        // todepiglins theme coins
        addCollectibleCoins(ModItems.COPPER_PIGLIN_MERCHANT_COIN.get().getDescriptionId(), "Copper Piglin Merchant Coin");
        addCollectibleCoins(ModItems.IRON_PIGLIN_MERCHANT_COIN.get().getDescriptionId(), "Iron Piglin Merchant Coin");
        addCollectibleCoins(ModItems.GOLD_PIGLIN_MERCHANT_COIN.get().getDescriptionId(), "Gold Piglin Merchant Coin");
        addCollectibleCoins(ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get().getDescriptionId(), "Netherite Piglin Merchant Coin");

        // regular mod items
        add(ModItems.NUMISMATIST_SPAWN_EGG.get(), "Numismatist Spawn Egg");
        add(ModItems.SNOW_GOLEM_SPAWN_EGG.get(), "Snow Golem Spawn Egg");
        add(ModItems.ILLUSIONER_SPAWN_EGG.get(), "Illusioner Spawn Egg");
        add(ModItems.GIANT_SPAWN_EGG.get(), "Giant Spawn Egg");
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

        // candy coin items
        add(ModItems.WARPED_SPICE_CHOCOLATE_COIN.get(), "Warped Spice Chocolate Coin");
        add(ModItems.CRIMSON_SPORE_CHOCOLATE_COIN.get(), "Crimson Spore Chocolate Coin");
        add(ModItems.MILK_BONE_CHOCOLATE_COIN.get(), "Milk Bone Chocolate Coin");
        add(ModItems.ULTIMATE_DARK_CHOCOLATE_COIN.get(), "Ultimate Dark Chocolate Coin");
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
        add("advancement.otherworldlyCoin", "Otherworldly Coin");
        add("advancement.otherworldlyCoin.desc", "Obtain an Endonian Coin");
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

        add("advancement.collectibleCoins", "Collectible Vanilla Coins");
        add("advancement.collectibleCoins.desc", "Find All the Vanilla Collectible Coins!");

        add("advancement.collectibleEcologicsCoins", "Collectible Ecologics Coins");
        add("advancement.collectibleEcologicsCoins.desc", "Find All the Ecologics Collectible Coins!");

        add("advancement.collectibleFriendsAndFoesCoins", "Collectible Friends and Foes Coins");
        add("advancement.collectibleFriendsAndFoesCoins.desc", "Find All the Friends and Foes Collectible Coins!");

        add("advancement.collectibleGuardVillagerCoins", "Collectible Guard Villager Coins");
        add("advancement.collectibleGuardVillagerCoins.desc", "Find All the Guard Villager Collectible Coins!");

        add("advancement.collectibleTodePiglinsCoins", "Collectible TodePiglins Coins");
        add("advancement.collectibleTodePiglinsCoins.desc", "Find All the TodePiglins Collectible Coins!");

        add("advancement.collectibleUnusedUpcomingCoins", "Collectible Unused or Upcoming Vanilla Mob Coins");
        add("advancement.collectibleUnusedUpcomingCoins.desc", "Find All the Collectible Coins for the Unused or Upcoming Mobs!");
    }

    private void addTooltips() {
        add("tooltips.no_ai_spawn_egg", "Spawns with No AI");
        add("tooltips.collectible_coin_pack", "Mystery Coin Pack");

        add("tooltips.shift.hover", "Press SHIFT for more info...");
        add("tooltips.textile_item.hover", "Textiles are used to make materials like paper and fabric.");
        add("tooltips.lucky_coin.hover", "Smells like fresh clover, what an unusual coin...");
        add("tooltips.four_leaf_clover.hover", "Many people believe this is a lucky charm...");
        add("tooltips.lucky_armor_item.hover", "Just wearing this garment makes you feel luckier...");
        add("tooltips.barter_coin_item.hover", "Anthropological evidence suggests bartering actually occurs when currency isn't readily available.");
        add("tooltips.endonian_coin_item.hover", "An otherworldly coin for interdimensional trading.");
        add("tooltips.bank_note_item.hover", "The original bank notes were created by China and worked much like our debit cards today.");
        add("tooltips.coin_item.hover", "Since ancient times, coins were either stamped or forged into molds.");
        add("tooltips.coin_stamp.hover", "This is for stamping currency in a press.");
        add("tooltips.server_token_coin.hover", "A special coin for server use.");

        // coin effects
        add("tooltips.coin_effects", "Coin Effects:");

        add("tooltips.fortune_1", "Fortune I");
        add("tooltips.looting_1", "Looting I");

        add("tooltips.night_vision", "Night Vision");
        add("tooltips.water_breathing", "Water Breathing");
        add("tooltips.saturation", "Increases Saturation");
        add("tooltips.fire_resist", "Increases Fire Resistance");
        add("tooltips.damage_resist", "Increases Damage Resistance");
        add("tooltips.dig_speed", "Increases Dig Speed");
        add("tooltips.levitation", "Levitation");
        add("tooltips.jump_boost", "Jump Boost");
        add("tooltips.slow_fall", "Slow Falling");
        add("tooltips.health_boost", "Health Boost");
        add("tooltips.dolphin_grace", "Dolphin's Grace");
        add("tooltips.regen", "Regeneration");

        add("tooltips.snow_walk", "Can Walk on Powdered Snow");
        add("tooltips.berry_walk", "Can Walk in Berry Bushes Unharmed");
        add("tooltips.piglin_neutral", "Makes Piglins Neutral");
        add("tooltips.enderman_neutral", "Makes Endermen Neutral");

        add("tooltips.undying", "Functions as a Totem of Undying while Equipped or in Inventory");
        add("tooltips.halloween_hero", "Hero of the Village during Halloween Event");
        add("tooltips.christmas_hero", "Hero of the Village during Christmas Event");
        add("tooltips.birthday_hero", "Hero of the Village during Birthday Event");
        add("tooltips.fishing_loot", "Unlocks Additional Sub Loot Tables for Fishing");
        add("tooltips.night_invisibility", "Invisibility at Night");
        add("tooltips.night_movement", "Increased Movement Speed at Night");
        add("tooltips.cat_intimidation", "Intimidates Creepers and Phantoms");
        add("tooltips.undead_damage", "Increased Damage vs. Undead");
        add("tooltips.illager_damage", "Increased Damage vs. Illagers");
        add("tooltips.arthropod_damage", "Increased Damage vs. Arthropods");
        add("tooltips.slow_attack", "Attacks Inflict Slowness");
        add("tooltips.poison_attack", "Attacks Inflict Poison");
        add("tooltips.wither_attack", "Attacks Inflict Wither");
        add("tooltips.burning_attack", "Attacks Inflict Burning");

        // food tooltips
        add("tooltips.crimson_spore_chocolate_effects", "90% Chance of Fire Resistance, 10% Chance of Hunger");
        add("tooltips.warped_spice_chocolate_effects", "90% Chance of Increased Movement Speed, 10% Chance of Confusion");
        add("tooltips.milk_bone_chocolate_effects", "90% Chance of Damage Resistance, 10% Chance of Slowness");
        add("tooltips.ultimate_dark_chocolate_effects", "90% Chance of Hero of the Village, 10% Chance of Darkness");

        // entity collectible coin bases
        add("tooltips.collectible_aerial_coin.hover", "One of Twenty Aerial Seasonal Coins");
        add("tooltips.collectible_amphibian_coin.hover", "One of Twenty-Four Amphibian Seasonal Coins");
        add("tooltips.collectible_aquatic_coin.hover", "One of Sixteen Aquatic Seasonal Coins");
        add("tooltips.collectible_arthropod_coin.hover", "One of Twenty Arthropod Seasonal Coins");

        add("tooltips.collectible_bear_coin.hover", "One of Eight Bear Seasonal Coins");
        add("tooltips.collectible_boss_coin.hover", "One of Sixteen Boss Seasonal Coins");
        add("tooltips.collectible_blaze_coin.hover", "One of Eight Blaze Seasonal Coins");
        add("tooltips.collectible_bovine_coin.hover", "One of Twenty-Four Bovine Seasonal Coins");

        add("tooltips.collectible_camelid_coin.hover", "One of Twelve Camelid Seasonal Coins");
        add("tooltips.collectible_canine_coin.hover", "One of Eight Canine Seasonal Coins");
        add("tooltips.collectible_creeper_coin.hover", "One of Four Creeper Seasonal Coins");
        add("tooltips.collectible_cube_coin.hover", "One of Eight Cuboid Seasonal Coins");

        add("tooltips.collectible_enderman_coin.hover", "One of Four Enderman Seasonal Coins");
        add("tooltips.collectible_equine_coin.hover", "One of Twenty Equine Seasonal Coins");

        add("tooltips.collectible_feline_coin.hover", "One of Eight Feline Seasonal Coins");

        add("tooltips.collectible_golem_coin.hover", "One of Sixteen Golem Seasonal Coins");

        add("tooltips.collectible_illager_coin.hover", "One of Twenty-Four Illager Seasonal Coins");

        add("tooltips.collectible_villager_coin.hover", "One of Sixteen Villager Seasonal Coins");

        add("tooltips.collectible_piglin_coin.hover", "One of Sixteen Piglin Seasonal Coins");

        add("tooltips.collectible_rabbit_coin.hover", "One of Four Rabbit Seasonal Coins");
        add("tooltips.collectible_rodent_coin.hover", "One of Four Rodent Seasonal Coins");

        add("tooltips.collectible_shulker_coin.hover", "One of Four Shulker Seasonal Coins");
        add("tooltips.collectible_sniffer_coin.hover", "One of Four Sniffer Seasonal Coins");
        add("tooltips.collectible_strider_coin.hover", "One of Four Strider Seasonal Coins");
        add("tooltips.collectible_swine_coin.hover", "One of Eight Pig Seasonal Coins");

        add("tooltips.collectible_undead_coin.hover", "One of Thirty-Six Undead Seasonal Coins");

        // friends and foes specific theme bases
        add("tooltips.collectible_glare_coin.hover", "One of Four Glare Seasonal Coins");
        add("tooltips.collectible_mauler_coin.hover", "One of Four Mauler Seasonal Coins");

        // gameplay collectible coin bases
        add("tooltips.collectible_hero_coin.hover", "One of Four Hero Seasonal Coins");
        add("tooltips.collectible_fish_coin.hover", "One of Sixteen Fishing Seasonal Coins");

        // holiday collectible coin bases
        add("tooltips.collectible_birthday_coin.hover", "A Birthday Seasonal Coin");
        add("tooltips.collectible_christmas_coin.hover", "A Christmas Seasonal Coin");
        add("tooltips.collectible_halloween_coin.hover", "A Halloween Seasonal Coin");

        // annual patron coin bases
        add("tooltips.collectible_patron_coin.hover", "A collectible coin to publicly honor, acknowledge, and appreciate those that support my work");
        add("tooltips.collectible_coin_lifetime.hover", "This coin celebrates a special champion in my life");
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
        add(ModBlocks.ENDONIAN_COIN_BAG.get(), "Endonian Coin Bag");
        add(ModBlocks.EMERALD_QUARTER_BANK_NOTE_BAG.get(), "Emerald Quarter Bank Note Bag");
        add(ModBlocks.EMERALD_HALF_BANK_NOTE_BAG.get(), "Emerald Half Bank Note Bag");
        add(ModBlocks.EMERALD_BANK_NOTE_BAG.get(), "Emerald Bank Note Bag");
        add(ModBlocks.LUCKY_COIN_BAG.get(), "Lucky Coin Bag");
        add(ModBlocks.ENDONIAN_BLOCK.get(), "Endonian Block");
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
        add(MobEffects.UNLUCK, "Bad Luck");

        addPotionEffects("luck_potion", "Luck");
        addPotionEffects("unluck_potion", "Bad Luck");
    }

    private void addPotionEffects(String id, String name) {
        // regular potion of normal effect
        add("item.minecraft.potion.effect." + id, "Potion of " + name);
        add("item.minecraft.potion.effect." + id + "_2", "Potion of " + name + " II");
        add("item.minecraft.potion.effect." + id + "_3", "Potion of " + name + " III");
        add("item.minecraft.potion.effect." + id + "_4", "Potion of " + name + " IV");
        add("item.minecraft.potion.effect." + id + "_5", "Potion of " + name + " V");
        add("item.minecraft.potion.effect." + id + "_6", "Potion of " + name + " VI");

        // regular potion of extended effect
        add("item.minecraft.potion.effect.long_" + id, "Potion of Extended " + name);
        add("item.minecraft.potion.effect.long_" + id + "_2", "Potion of Extended " + name + " II");
        add("item.minecraft.potion.effect.long_" + id + "_3", "Potion of Extended " + name + " III");
        add("item.minecraft.potion.effect.long_" + id + "_4", "Potion of Extended " + name + " IV");
        add("item.minecraft.potion.effect.long_" + id + "_5", "Potion of Extended " + name + " V");
        add("item.minecraft.potion.effect.long_" + id + "_6", "Potion of Extended " + name + " VI");

        // splash potion of normal effect
        add("item.minecraft.splash_potion.effect." + id, "Splash Potion of " + name);
        add("item.minecraft.splash_potion.effect." + id + "_2", "Splash Potion of " + name + " II");
        add("item.minecraft.splash_potion.effect." + id + "_3", "Splash Potion of " + name + " III");
        add("item.minecraft.splash_potion.effect." + id + "_4", "Splash Potion of " + name + " IV");
        add("item.minecraft.splash_potion.effect." + id + "_5", "Splash Potion of " + name + " V");
        add("item.minecraft.splash_potion.effect." + id + "_6", "Splash Potion of " + name + " VI");

        // splash potion of extended effect
        add("item.minecraft.splash_potion.effect.long_" + id, "Splash Potion of Extended " + name);
        add("item.minecraft.splash_potion.effect.long_" + id + "_2", "Splash Potion of Extended " + name + " II");
        add("item.minecraft.splash_potion.effect.long_" + id + "_3", "Splash Potion of Extended " + name + " III");
        add("item.minecraft.splash_potion.effect.long_" + id + "_4", "Splash Potion of Extended " + name + " IV");
        add("item.minecraft.splash_potion.effect.long_" + id + "_5", "Splash Potion of Extended " + name + " V");
        add("item.minecraft.splash_potion.effect.long_" + id + "_6", "Splash Potion of Extended " + name + " VI");

        // lingering potion of normal effect
        add("item.minecraft.lingering_potion.effect." + id, "Lingering Potion of " + name);
        add("item.minecraft.lingering_potion.effect." + id + "_2", "Lingering Potion of " + name + " II");
        add("item.minecraft.lingering_potion.effect." + id + "_3", "Lingering Potion of " + name + " III");
        add("item.minecraft.lingering_potion.effect." + id + "_4", "Lingering Potion of " + name + " IV");
        add("item.minecraft.lingering_potion.effect." + id + "_5", "Lingering Potion of " + name + " V");
        add("item.minecraft.lingering_potion.effect." + id + "_6", "Lingering Potion of " + name + " VI");

        // lingering potion of extended effect
        add("item.minecraft.lingering_potion.effect.long_" + id, "Lingering Potion of Extended " + name);
        add("item.minecraft.lingering_potion.effect.long_" + id + "_2", "Lingering Potion of Extended " + name + " II");
        add("item.minecraft.lingering_potion.effect.long_" + id + "_3", "Lingering Potion of Extended " + name + " III");
        add("item.minecraft.lingering_potion.effect.long_" + id + "_4", "Lingering Potion of Extended " + name + " IV");
        add("item.minecraft.lingering_potion.effect.long_" + id + "_5", "Lingering Potion of Extended " + name + " V");
        add("item.minecraft.lingering_potion.effect.long_" + id + "_6", "Lingering Potion of Extended " + name + " VI");

        // tipped arrow of normal effect
        add("item.minecraft.tipped_arrow.effect." + id, "Arrow of " + name);
        add("item.minecraft.tipped_arrow.effect." + id + "_2", "Arrow of " + name + " II");
        add("item.minecraft.tipped_arrow.effect." + id + "_3", "Arrow of " + name + " III");
        add("item.minecraft.tipped_arrow.effect." + id + "_4", "Arrow of " + name + " IV");
        add("item.minecraft.tipped_arrow.effect." + id + "_5", "Arrow of " + name + " V");
        add("item.minecraft.tipped_arrow.effect." + id + "_6", "Arrow of " + name + " VI");

        // tipped arrow of extended effect
        add("item.minecraft.tipped_arrow.effect.long_" + id, "Arrow of Extended " + name);
        add("item.minecraft.tipped_arrow.effect.long_" + id + "_2", "Arrow of Extended " + name + " II");
        add("item.minecraft.tipped_arrow.effect.long_" + id + "_3", "Arrow of Extended " + name + " III");
        add("item.minecraft.tipped_arrow.effect.long_" + id + "_4", "Arrow of Extended " + name + " IV");
        add("item.minecraft.tipped_arrow.effect.long_" + id + "_5", "Arrow of Extended " + name + " V");
        add("item.minecraft.tipped_arrow.effect.long_" + id + "_6", "Arrow of Extended " + name + " VI");
    }
}