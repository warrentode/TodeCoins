package com.github.warrentode.todecoins.datagen.recipes.recipe;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.faboslav.friendsandfoes.common.init.FriendsAndFoesItems;
import com.github.warrentode.todecoins.datagen.recipes.builder.SpawnEggShapelessRecipeBuilder;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.util.ModUtil;
import com.github.warrentode.todecoins.util.tags.TCItemTags;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import samebutdifferent.ecologics.registry.ModItems;
import tallestegg.guardvillagers.GuardItems;

import java.util.Objects;
import java.util.function.Consumer;

import static com.github.warrentode.todecoins.TodeCoins.MODID;
import static com.github.warrentode.todecoins.datagen.RecipesGen.setLocation;

public class ConditionalSpawnEggRecipes extends RecipeProvider implements IConditionBuilder {
    public ConditionalSpawnEggRecipes(PackOutput output) {
        super(output);
    }

    public static @NotNull String getMODID(Item item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getNamespace();
    }

    public static Item getNamespaceIdentifierItem(@NotNull String modid) {
        return switch (modid) {
            case "goblintraders" -> Items.EMERALD;
            case "snowyspirit" -> net.mehvahdjukaar.snowyspirit.reg.ModRegistry.CANDY_CANE.get();
            case "supplementaries" -> ModRegistry.CANDY_ITEM.get();
            case "ecologics" -> ModItems.WALNUT.get();
            case "aether" -> AetherItems.ZANITE_GEMSTONE.get();
            case "tconstruct" -> ModUtil.getItem("tconstruct:earth_slime_crystal");
            case "friendsandfoes" -> FriendsAndFoesItems.BUTTERCUP.get();
            case "guardvillagers" -> Items.IRON_SWORD;
            case "minecraft" -> Items.STONE_PICKAXE;
            case MODID -> TCItems.COPPER_COIN.get();
            default -> throw new IllegalStateException("Unexpected value: " + modid);
        };
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        register(consumer);
    }

    public void register(Consumer<FinishedRecipe> consumer) {
        spawnEggRecipes(consumer);
    }

    private void spawnEggRecipes(Consumer<FinishedRecipe> consumer) {
        todeCoins(consumer);
        minecraft(consumer);
        guardVillagers(consumer);
        friendsAndFoes(consumer);
        tconstruct(consumer);
        aether(consumer);
        ecologics(consumer);
        snowyspirit(consumer);
        goblinTraders(consumer);
    }

    private void snowyspirit(Consumer<FinishedRecipe> consumer) {
        recipeTemplate(consumer, net.mehvahdjukaar.snowyspirit.reg.ModRegistry.GINGERBREAD_GOLEM_EGG.get(), null, net.mehvahdjukaar.snowyspirit.reg.ModRegistry.GINGERBREAD_COOKIE.get());
    }

    private void goblinTraders(Consumer<FinishedRecipe> consumer) {
        recipeTemplate(consumer, com.mrcrayfish.goblintraders.core.ModItems.GOBLIN_TRADER_SPAWN_EGG.get(), null, Items.APPLE);
        recipeTemplate(consumer, com.mrcrayfish.goblintraders.core.ModItems.VEIN_GOBLIN_TRADER_SPAWN_EGG.get(), null, Items.CARROT);
    }

    private void ecologics(Consumer<FinishedRecipe> consumer) {
        recipeTemplate(consumer, ModItems.COCONUT_CRAB_SPAWN_EGG.get(), TCItemTags.AQUATIC_COINS_CRAB_TAG, null);
        recipeTemplate(consumer, ModItems.PENGUIN_SPAWN_EGG.get(), TCItemTags.AQUATIC_COINS_PENGUIN_TAG, null);
        recipeTemplate(consumer, ModItems.SQUIRREL_SPAWN_EGG.get(), TCItemTags.WILD_COINS_SQUIRREL_TAG, null);
    }

    private void aether(Consumer<FinishedRecipe> consumer) {
        recipeTemplate(consumer, AetherItems.PHYG_SPAWN_EGG.get(), null, AetherItems.AMBROSIUM_SHARD.get());
        recipeTemplate(consumer, AetherItems.FLYING_COW_SPAWN_EGG.get(), null, AetherItems.SKYROOT_MILK_BUCKET.get());
        recipeTemplate(consumer, AetherItems.SHEEPUFF_SPAWN_EGG.get(), null, AetherBlocks.COLD_AERCLOUD.get().asItem());
        recipeTemplate(consumer, AetherItems.MOA_SPAWN_EGG.get(), null, AetherItems.GOLDEN_FEATHER.get());
        recipeTemplate(consumer, AetherItems.AERBUNNY_SPAWN_EGG.get(), null, AetherItems.WHITE_APPLE.get());
        recipeTemplate(consumer, AetherItems.AERWHALE_SPAWN_EGG.get(), null, AetherItems.SKYROOT_COD_BUCKET.get());
        recipeTemplate(consumer, AetherItems.BLUE_SWET_SPAWN_EGG.get(), null, AetherItems.BLUE_GUMMY_SWET.get());
        recipeTemplate(consumer, AetherItems.GOLDEN_SWET_SPAWN_EGG.get(), null, AetherItems.GOLDEN_GUMMY_SWET.get());
        recipeTemplate(consumer, AetherItems.WHIRLWIND_SPAWN_EGG.get(), null, AetherItems.GOLDEN_AMBER.get());
        recipeTemplate(consumer, AetherItems.EVIL_WHIRLWIND_SPAWN_EGG.get(), null, AetherItems.GRAVITITE_BOOTS.get());
        recipeTemplate(consumer, AetherItems.AECHOR_PLANT_SPAWN_EGG.get(), null, AetherItems.AECHOR_PETAL.get());
        recipeTemplate(consumer, AetherItems.COCKATRICE_SPAWN_EGG.get(), null, AetherBlocks.CARVED_STONE.get().asItem());
        recipeTemplate(consumer, AetherItems.ZEPHYR_SPAWN_EGG.get(), null, AetherBlocks.BLUE_AERCLOUD.get().asItem());
        recipeTemplate(consumer, AetherItems.MIMIC_SPAWN_EGG.get(), null, AetherItems.LIFE_SHARD.get());
        recipeTemplate(consumer, AetherItems.SENTRY_SPAWN_EGG.get(), null, AetherBlocks.SENTRY_STONE.get().asItem());
        recipeTemplate(consumer, AetherItems.SLIDER_SPAWN_EGG.get(), null, AetherItems.MUSIC_DISC_SLIDERS_WRATH.get());
        recipeTemplate(consumer, AetherItems.VALKYRIE_SPAWN_EGG.get(), null, AetherItems.VALKYRIE_LANCE.get());
        recipeTemplate(consumer, AetherItems.VALKYRIE_QUEEN_SPAWN_EGG.get(), null, AetherItems.MUSIC_DISC_ASCENDING_DAWN.get());
        recipeTemplate(consumer, AetherItems.FIRE_MINION_SPAWN_EGG.get(), null, AetherBlocks.HELLFIRE_STONE.get().asItem());
        recipeTemplate(consumer, AetherItems.SUN_SPIRIT_SPAWN_EGG.get(), null, AetherItems.MUSIC_DISC_KLEPTO.get());
    }

    private void tconstruct(Consumer<FinishedRecipe> consumer) {
        recipeTemplate(consumer, ModUtil.getItem("tconstruct:sky_slime_spawn_egg"), null, ModUtil.getItem("tconstruct:sky_slime_ball"));
        recipeTemplate(consumer, ModUtil.getItem("tconstruct:ender_slime_spawn_egg"), null, ModUtil.getItem("tconstruct:ender_slime_ball"));
        recipeTemplate(consumer, ModUtil.getItem("tconstruct:terracube_spawn_egg"), null, Items.CLAY);
    }

    private void friendsAndFoes(Consumer<FinishedRecipe> consumer) {
        recipeTemplate(consumer, FriendsAndFoesItems.ILLUSIONER_SPAWN_EGG.get(), TCItemTags.RAIDER_COINS_ILLUSIONER_TAG, null);
        recipeTemplate(consumer, FriendsAndFoesItems.CRAB_SPAWN_EGG.get(), TCItemTags.AQUATIC_COINS_CRAB_TAG, null);
        recipeTemplate(consumer, FriendsAndFoesItems.GLARE_SPAWN_EGG.get(), TCItemTags.AERIAL_COINS_GLARE_TAG, null);
        recipeTemplate(consumer, FriendsAndFoesItems.ICEOLOGER_SPAWN_EGG.get(), TCItemTags.RAIDER_COINS_ICEOLOGER_TAG, null);
        recipeTemplate(consumer, FriendsAndFoesItems.MAULER_SPAWN_EGG.get(), TCItemTags.WILD_COINS_MAULER_TAG, null);
        recipeTemplate(consumer, FriendsAndFoesItems.MOOBLOOM_SPAWN_EGG.get(), TCItemTags.BREEDABLE_COINS_MOOBLOOM_TAG, null);
        recipeTemplate(consumer, FriendsAndFoesItems.RASCAL_SPAWN_EGG.get(), TCItemTags.HUMANOID_COINS_RASCAL_TAG, null);
        recipeTemplate(consumer, FriendsAndFoesItems.WILDFIRE_SPAWN_EGG.get(), TCItemTags.BLAZE_COINS_WILDFIRE_TAG, null);
        recipeTemplate(consumer, FriendsAndFoesItems.TUFF_GOLEM_SPAWN_EGG.get(), TCItemTags.GOLEM_COINS_TUFF_GOLEM_TAG, null);
        recipeTemplate(consumer, FriendsAndFoesItems.COPPER_GOLEM_SPAWN_EGG.get(), TCItemTags.GOLEM_COINS_COPPER_GOLEM_TAG, null);
    }

    private void guardVillagers(Consumer<FinishedRecipe> consumer) {
        recipeTemplate(consumer, GuardItems.GUARD_SPAWN_EGG.get(), TCItemTags.HUMANOID_COINS_GUARD_TAG, null);
        recipeTemplate(consumer, GuardItems.ILLUSIONER_SPAWN_EGG.get(), TCItemTags.RAIDER_COINS_ILLUSIONER_TAG, null);
    }

    private void todeCoins(Consumer<FinishedRecipe> consumer) {
        recipeTemplate(consumer, TCItems.GIANT_SPAWN_EGG.get(), TCItemTags.MISC_COINS_GIANT_TAG, null);
        recipeTemplate(consumer, TCItems.NUMISMATIST_SPAWN_EGG.get(), TCItemTags.HUMANOID_COINS_VILLAGER_TAG, null);
        recipeTemplate(consumer, TCItems.PIGLINMERCHANT_SPAWN_EGG.get(), TCItemTags.PIGLIN_COINS_PIGLIN_MERCHANT_TAG, null);
    }

    private void minecraft(Consumer<FinishedRecipe> consumer) {
        recipeTemplate(consumer, Items.ALLAY_SPAWN_EGG, TCItemTags.AERIAL_COINS_ALLAY_TAG, null);
        recipeTemplate(consumer, Items.AXOLOTL_SPAWN_EGG, TCItemTags.AQUATIC_COINS_AXOLOTL_TAG, null);
        recipeTemplate(consumer, Items.BAT_SPAWN_EGG, TCItemTags.AERIAL_COINS_BAT_TAG, null);
        recipeTemplate(consumer, Items.BEE_SPAWN_EGG, TCItemTags.AERIAL_COINS_BEE_TAG, null);
        recipeTemplate(consumer, Items.BLAZE_SPAWN_EGG, TCItemTags.BLAZE_COINS_BLAZE_TAG, null);
        recipeTemplate(consumer, Items.CAMEL_SPAWN_EGG, TCItemTags.STEED_COINS_CAMEL_TAG, null);
        recipeTemplate(consumer, Items.CAT_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_CAT_TAG, null);
        recipeTemplate(consumer, Items.CAVE_SPIDER_SPAWN_EGG, TCItemTags.ARTHROPOD_COINS_CAVE_SPIDER_TAG, null);
        recipeTemplate(consumer, Items.CHICKEN_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_CHICKEN_TAG, null);
        recipeTemplate(consumer, Items.COD_SPAWN_EGG, TCItemTags.FISH_COINS_COD_TAG, null);
        recipeTemplate(consumer, Items.COW_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_COW_TAG, null);
        recipeTemplate(consumer, Items.CREEPER_SPAWN_EGG, TCItemTags.MISC_COINS_CREEPER_TAG, null);
        recipeTemplate(consumer, Items.DOLPHIN_SPAWN_EGG, TCItemTags.AQUATIC_COINS_DOLPHIN_TAG, null);
        recipeTemplate(consumer, Items.DONKEY_SPAWN_EGG, TCItemTags.STEED_COINS_DONKEY_TAG, null);
        recipeTemplate(consumer, Items.DROWNED_SPAWN_EGG, TCItemTags.UNDEAD_COINS_DROWNED_TAG, null);
        recipeTemplate(consumer, Items.ELDER_GUARDIAN_SPAWN_EGG, TCItemTags.AQUATIC_COINS_ELDER_GUARDIAN_TAG, null);
        recipeTemplate(consumer, Items.ENDER_DRAGON_SPAWN_EGG, TCItemTags.AERIAL_COINS_DRAGON_TAG, null);
        recipeTemplate(consumer, Items.ENDERMAN_SPAWN_EGG, TCItemTags.MISC_COINS_ENDERMAN_TAG, null);
        recipeTemplate(consumer, Items.ENDERMITE_SPAWN_EGG, TCItemTags.ARTHROPOD_COINS_ENDERMITE_TAG, null);
        recipeTemplate(consumer, Items.EVOKER_SPAWN_EGG, TCItemTags.RAIDER_COINS_EVOKER_TAG, null);
        recipeTemplate(consumer, Items.FOX_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_FOX_TAG, null);
        recipeTemplate(consumer, Items.FROG_SPAWN_EGG, TCItemTags.AQUATIC_COINS_FROG_TAG, null);
        recipeTemplate(consumer, Items.GHAST_SPAWN_EGG, TCItemTags.AERIAL_COINS_GHAST_TAG, null);
        recipeTemplate(consumer, Items.GLOW_SQUID_SPAWN_EGG, TCItemTags.AQUATIC_COINS_GLOW_SQUID_TAG, null);
        recipeTemplate(consumer, Items.GOAT_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_GOAT_TAG, null);
        recipeTemplate(consumer, Items.GUARDIAN_SPAWN_EGG, TCItemTags.AQUATIC_COINS_ELDER_GUARDIAN_TAG, null);
        recipeTemplate(consumer, Items.HOGLIN_SPAWN_EGG, TCItemTags.PIGLIN_COINS_HOGLIN_TAG, null);
        recipeTemplate(consumer, Items.HORSE_SPAWN_EGG, TCItemTags.STEED_COINS_HORSE_TAG, null);
        recipeTemplate(consumer, Items.HUSK_SPAWN_EGG, TCItemTags.UNDEAD_COINS_HUSK_TAG, null);
        recipeTemplate(consumer, Items.IRON_GOLEM_SPAWN_EGG, TCItemTags.GOLEM_COINS_IRON_GOLEM_TAG, null);
        recipeTemplate(consumer, Items.LLAMA_SPAWN_EGG, TCItemTags.STEED_COINS_LLAMA_TAG, null);
        recipeTemplate(consumer, Items.MAGMA_CUBE_SPAWN_EGG, TCItemTags.SLIME_COINS_MAGMA_CUBE_TAG, null);
        recipeTemplate(consumer, Items.MOOSHROOM_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_MOOSHROOM_TAG, null);
        recipeTemplate(consumer, Items.MULE_SPAWN_EGG, TCItemTags.STEED_COINS_MULE_TAG, null);
        recipeTemplate(consumer, Items.OCELOT_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_OCELOT_TAG, null);
        recipeTemplate(consumer, Items.PANDA_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_PANDA_TAG, null);
        recipeTemplate(consumer, Items.PARROT_SPAWN_EGG, TCItemTags.AERIAL_COINS_PARROT_TAG, null);
        recipeTemplate(consumer, Items.PHANTOM_SPAWN_EGG, TCItemTags.AERIAL_COINS_PHANTOM_TAG, null);
        recipeTemplate(consumer, Items.PIG_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_PIG_TAG, null);
        recipeTemplate(consumer, Items.PIGLIN_SPAWN_EGG, TCItemTags.PIGLIN_COINS_PIGLIN_TAG, null);
        recipeTemplate(consumer, Items.PIGLIN_BRUTE_SPAWN_EGG, TCItemTags.PIGLIN_COINS_PIGLIN_BRUTE_TAG, null);
        recipeTemplate(consumer, Items.POLAR_BEAR_SPAWN_EGG, TCItemTags.WILD_COINS_POLAR_BEAR_TAG, null);
        recipeTemplate(consumer, Items.PUFFERFISH_SPAWN_EGG, TCItemTags.FISH_COINS_PUFFERFISH_TAG, null);
        recipeTemplate(consumer, Items.RABBIT_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_RABBIT_TAG, null);
        recipeTemplate(consumer, Items.RAVAGER_SPAWN_EGG, TCItemTags.RAIDER_COINS_RAVAGER_TAG, null);
        recipeTemplate(consumer, Items.SALMON_SPAWN_EGG, TCItemTags.FISH_COINS_SALMON_TAG, null);
        recipeTemplate(consumer, Items.SHEEP_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_SHEEP_TAG, null);
        recipeTemplate(consumer, Items.SHULKER_SPAWN_EGG, TCItemTags.MISC_COINS_SHULKER_TAG, null);
        recipeTemplate(consumer, Items.SILVERFISH_SPAWN_EGG, TCItemTags.ARTHROPOD_COINS_SILVERFISH_TAG, null);
        recipeTemplate(consumer, Items.SKELETON_SPAWN_EGG, TCItemTags.UNDEAD_COINS_SKELETON_TAG, null);
        recipeTemplate(consumer, Items.SKELETON_HORSE_SPAWN_EGG, TCItemTags.STEED_COINS_SKELETON_HORSE_TAG, null);
        recipeTemplate(consumer, Items.SNIFFER_SPAWN_EGG, TCItemTags.MISC_COINS_SNIFFER_TAG, null);
        recipeTemplate(consumer, Items.SNOW_GOLEM_SPAWN_EGG, TCItemTags.GOLEM_COINS_SNOW_GOLEM_TAG, null);
        recipeTemplate(consumer, Items.SPIDER_SPAWN_EGG, TCItemTags.ARTHROPOD_COINS_SPIDER_TAG, null);
        recipeTemplate(consumer, Items.SQUID_SPAWN_EGG, TCItemTags.AQUATIC_COINS_SQUID_TAG, null);
        recipeTemplate(consumer, Items.STRAY_SPAWN_EGG, TCItemTags.UNDEAD_COINS_STRAY_TAG, null);
        recipeTemplate(consumer, Items.STRIDER_SPAWN_EGG, TCItemTags.STEED_COINS_STRIDER_TAG, null);
        recipeTemplate(consumer, Items.TADPOLE_SPAWN_EGG, TCItemTags.AQUATIC_COINS_TADPOLE_TAG, null);
        recipeTemplate(consumer, Items.TRADER_LLAMA_SPAWN_EGG, TCItemTags.STEED_COINS_TRADER_LLAMA_TAG, null);
        recipeTemplate(consumer, Items.TROPICAL_FISH_SPAWN_EGG, TCItemTags.FISH_COINS_TROPICAL_FISH_TAG, null);
        recipeTemplate(consumer, Items.TURTLE_SPAWN_EGG, TCItemTags.AQUATIC_COINS_TURTLE_TAG, null);
        recipeTemplate(consumer, Items.VEX_SPAWN_EGG, TCItemTags.RAIDER_COINS_VEX_TAG, null);
        recipeTemplate(consumer, Items.VILLAGER_SPAWN_EGG, TCItemTags.HUMANOID_COINS_VILLAGER_TAG, null);
        recipeTemplate(consumer, Items.VINDICATOR_SPAWN_EGG, TCItemTags.RAIDER_COINS_VINDICATOR_TAG, null);
        recipeTemplate(consumer, Items.WANDERING_TRADER_SPAWN_EGG, TCItemTags.HUMANOID_COINS_WANDERING_TRADER_TAG, null);
        recipeTemplate(consumer, Items.WARDEN_SPAWN_EGG, TCItemTags.MISC_COINS_WARDEN_TAG, null);
        recipeTemplate(consumer, Items.WITCH_SPAWN_EGG, TCItemTags.RAIDER_COINS_WITCH_TAG, null);
        recipeTemplate(consumer, Items.WITHER_SPAWN_EGG, TCItemTags.UNDEAD_COINS_WITHER_TAG, null);
        recipeTemplate(consumer, Items.WITHER_SKELETON_SPAWN_EGG, TCItemTags.UNDEAD_COINS_WITHER_SKELETON_TAG, null);
        recipeTemplate(consumer, Items.WOLF_SPAWN_EGG, TCItemTags.BREEDABLE_COINS_WOLF_TAG, null);
        recipeTemplate(consumer, Items.ZOGLIN_SPAWN_EGG, TCItemTags.UNDEAD_COINS_ZOGLIN_TAG, null);
        recipeTemplate(consumer, Items.ZOMBIE_SPAWN_EGG, TCItemTags.UNDEAD_COINS_ZOMBIE_TAG, null);
        recipeTemplate(consumer, Items.ZOMBIE_HORSE_SPAWN_EGG, TCItemTags.STEED_COINS_ZOMBIE_HORSE_TAG, null);
        recipeTemplate(consumer, Items.ZOMBIE_VILLAGER_SPAWN_EGG, TCItemTags.UNDEAD_COINS_ZOMBIE_VILLAGER_TAG, null);
        recipeTemplate(consumer, Items.ZOMBIFIED_PIGLIN_SPAWN_EGG, TCItemTags.UNDEAD_COINS_ZOMBIFIED_PIGLIN_TAG, null);
    }

    protected void recipeTemplate(Consumer<FinishedRecipe> consumer, Item result, @Nullable TagKey<Item> entityIdentifierItemTag, @Nullable Item entityIdentifierItemStack) {
        ConditionalRecipe.builder()
                .addCondition(modLoaded(getMODID(result)))
                .addRecipe(finishedRecipeConsumer -> {
                    SpawnEggShapelessRecipeBuilder builder = SpawnEggShapelessRecipeBuilder
                            .shapelessSpawnEggRecipe(RecipeCategory.MISC, result)
                            .group("spawn_eggs")
                            // egg base
                            .addIngredient(Tags.Items.EGGS)
                            // soul activator
                            .addIngredient(TCItemTags.SOUL_BINDER)
                            // material item cost
                            .addIngredient(TCItemTags.NETHERITE_NUGGET)
                            // life bringer item
                            .addIngredient(Items.HEART_OF_THE_SEA);

                    // namespace identifier item
                    builder.addIngredient(getNamespaceIdentifierItem(getMODID(result)));

                    // dynamically add either tag or stack for entity identifier
                    if (entityIdentifierItemTag != null) {
                        builder.addIngredient(entityIdentifierItemTag);
                    }
                    else if (entityIdentifierItemStack != null) {
                        builder.addIngredient(entityIdentifierItemStack);
                    }

                    // unlock criterion
                    builder.unlockedBy("has_soul_binder", has(TCItemTags.SOUL_BINDER))
                            .build(finishedRecipeConsumer);
                })
                .build(consumer, setLocation(MODID, "spawn_eggs/" + getMODID(result) + "/" + result));
    }
}