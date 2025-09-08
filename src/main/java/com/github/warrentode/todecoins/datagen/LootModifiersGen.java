package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.condition.NotFakePlayerCondition;
import com.github.warrentode.todecoins.loot.condition.tag.BlockTagCondition;
import com.github.warrentode.todecoins.loot.modifiers.AddItemLootModifier;
import com.github.warrentode.todecoins.loot.modifiers.AddLootTableModifier;
import com.github.warrentode.todecoins.util.tags.TCBlockTags;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class LootModifiersGen extends GlobalLootModifierProvider {
    public LootModifiersGen(PackOutput output, String modid) {
        super(output, modid);
    }

    @Override
    protected void start() {
// ----- BLOCK LOOT INJECTION -----
        add("add_four_leaf_clover_drops", new AddItemLootModifier(
                new LootItemCondition[]{
                        BlockTagCondition.isTag(TCBlockTags.DROPS_FOUR_LEAF_CLOVER)
                },
                TCItems.FOUR_LEAF_CLOVER.get(), 0.001F
        ));

// ----- GIFT LOOT INJECTION -----
        // Set of your modded professions to skip
        Set<ResourceLocation> excludedProfessions = Set.of(
                ResourceLocation.parse(MODID + ":" + "banker"),
                ResourceLocation.parse(MODID + ":" + "leprechaun")
        );
        // Build dynamic list of gift tables
        List<ResourceLocation> giftTables = ForgeRegistries.VILLAGER_PROFESSIONS.getValues().stream()
                .map(ForgeRegistries.VILLAGER_PROFESSIONS::getKey)
                .filter(Objects::nonNull)
                .filter(name -> !excludedProfessions.contains(name))
                .map(name -> ResourceLocation.parse(name.getNamespace() + ":gameplay/hero_of_the_village/" + name.getPath()))
                .toList();
        // Add a single modifier that covers all gift tables
        add("add_loot_hero_gift_coins", new AddLootTableModifier(
                new LootItemCondition[]{
                        AnyOfCondition.anyOf(giftTables.stream()
                                .map(LootTableIdCondition::builder)
                                .toArray(LootItemCondition.Builder[]::new)
                        ).build()
                },
                ModBuiltInLootTables.COLLECTIBLE_COIN_GIFT_LOOT
        ));

// ----- REWARDS LOOT INJECTION -----
        add("add_rascal_coin_rewards", new AddLootTableModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(ResourceLocation.parse("friendsandfoes:rewards/rascal_good_reward")).build()
                },
                ModBuiltInLootTables.RASCAL_COIN_REWARD
        ));

// ----- FISHING LOOT INJECTION -----
        add("add_loot_fishing_treasure", new AddLootTableModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.FISHING_TREASURE).build()
                },
                ModBuiltInLootTables.FISHING_COINS
        ));
        add("add_loot_fishing_junk", new AddLootTableModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.FISHING_JUNK).build()
                },
                ModBuiltInLootTables.FISHING_EXTRA_JUNK
        ));
        add("add_loot_fishing_bonus_fish", new AddLootTableModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.FISHING_FISH).build()
                },
                ModBuiltInLootTables.FISHING_BONUS_FISH
        ));

// ----- ENTITY DROPS INJECTION -----
        // Collect all entity types that have spawn eggs (vanilla + modded via ForgeSpawnEggItem)
        Set<ResourceLocation> eggEntities = ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> item instanceof SpawnEggItem)
                .map(item -> item instanceof ForgeSpawnEggItem forgeSpawnEggItem
                        ? forgeSpawnEggItem.getType(null) // Forge mod eggs
                        : ((SpawnEggItem) item).getType(null) // vanilla eggs
                )
                .filter(Objects::nonNull)
                .map(ForgeRegistries.ENTITY_TYPES::getKey)
                .filter(Objects::nonNull)
                // set up the location of the entity loot tables
                .map(id -> ResourceLocation.parse(id.getNamespace() + ":entities/" + id.getPath()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        // Build conditions directly from the loot tables
        LootItemCondition[] conditions = new LootItemCondition[] {
                AnyOfCondition.anyOf(
                        eggEntities.stream()
                                .map(LootTableIdCondition::builder)
                                .toArray(LootItemCondition.Builder[]::new)
                ).build(),
                new NotFakePlayerCondition.Builder().build()
        };
        // Add the loot modifier
        add("add_loot_entity_drops", new AddLootTableModifier(
                conditions, ModBuiltInLootTables.MASTER_DROPS_LOOT
        ));

// ----- CHEST LOOT INJECTION -----
        // static list of vanilla chest loot
        List<ResourceLocation> chestLoot = List.of(
                ModBuiltInLootTables.LEPRECHAUN_CHEST,
                ModBuiltInLootTables.BANKER_CHEST,
                BuiltInLootTables.SPAWN_BONUS_CHEST,
                BuiltInLootTables.END_CITY_TREASURE,
                BuiltInLootTables.SIMPLE_DUNGEON,
                BuiltInLootTables.VILLAGE_WEAPONSMITH,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_CARTOGRAPHER,
                BuiltInLootTables.VILLAGE_MASON,
                BuiltInLootTables.VILLAGE_SHEPHERD,
                BuiltInLootTables.VILLAGE_BUTCHER,
                BuiltInLootTables.VILLAGE_FLETCHER,
                BuiltInLootTables.VILLAGE_FISHER,
                BuiltInLootTables.VILLAGE_TANNERY,
                BuiltInLootTables.VILLAGE_TEMPLE,
                BuiltInLootTables.VILLAGE_DESERT_HOUSE,
                BuiltInLootTables.VILLAGE_PLAINS_HOUSE,
                BuiltInLootTables.VILLAGE_TAIGA_HOUSE,
                BuiltInLootTables.VILLAGE_SNOWY_HOUSE,
                BuiltInLootTables.VILLAGE_SAVANNA_HOUSE,
                BuiltInLootTables.ABANDONED_MINESHAFT,
                BuiltInLootTables.NETHER_BRIDGE,
                BuiltInLootTables.STRONGHOLD_LIBRARY,
                BuiltInLootTables.STRONGHOLD_CROSSING,
                BuiltInLootTables.STRONGHOLD_CORRIDOR,
                BuiltInLootTables.DESERT_PYRAMID,
                BuiltInLootTables.JUNGLE_TEMPLE,
                BuiltInLootTables.JUNGLE_TEMPLE_DISPENSER,
                BuiltInLootTables.IGLOO_CHEST,
                BuiltInLootTables.WOODLAND_MANSION,
                BuiltInLootTables.UNDERWATER_RUIN_SMALL,
                BuiltInLootTables.UNDERWATER_RUIN_BIG,
                BuiltInLootTables.BURIED_TREASURE,
                BuiltInLootTables.SHIPWRECK_MAP,
                BuiltInLootTables.SHIPWRECK_SUPPLY,
                BuiltInLootTables.SHIPWRECK_TREASURE,
                BuiltInLootTables.PILLAGER_OUTPOST,
                BuiltInLootTables.BASTION_TREASURE,
                BuiltInLootTables.BASTION_OTHER,
                BuiltInLootTables.BASTION_BRIDGE,
                BuiltInLootTables.BASTION_HOGLIN_STABLE,
                BuiltInLootTables.ANCIENT_CITY,
                BuiltInLootTables.ANCIENT_CITY_ICE_BOX,
                BuiltInLootTables.RUINED_PORTAL
        );

        // Add a single modifier that covers all chest loot tables
        add("add_loot_chest_currency", new AddLootTableModifier(
                new LootItemCondition[]{
                        AnyOfCondition.anyOf(
                                chestLoot.stream().map(LootTableIdCondition::builder).toArray(LootItemCondition.Builder[]::new)
                        ).build()
                },
                ModBuiltInLootTables.MASTER_CHEST_LOOT
        ));

// ----- "DIG" LOOT INJECTION -----
        // static list of vanilla "dig" loot
        List<ResourceLocation> digLoot = List.of(
                BuiltInLootTables.SNIFFER_DIGGING,
                BuiltInLootTables.DESERT_WELL_ARCHAEOLOGY,
                BuiltInLootTables.DESERT_PYRAMID_ARCHAEOLOGY,
                BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON,
                BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE,
                BuiltInLootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY,
                BuiltInLootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY
        );

        // Add a single modifier that covers all "dig" loot tables
        add("add_loot_dig_currency", new AddLootTableModifier(
                new LootItemCondition[]{
                        AnyOfCondition.anyOf(
                                digLoot.stream().map(LootTableIdCondition::builder).toArray(LootItemCondition.Builder[]::new)
                        ).build()
                },
                ModBuiltInLootTables.MASTER_CHEST_LOOT
        ));
    }
}