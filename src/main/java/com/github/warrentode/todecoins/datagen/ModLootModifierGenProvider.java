package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.conditions.tag.BlockTagCondition;
import com.github.warrentode.todecoins.loot.modifiers.AddItemLootModifier;
import com.github.warrentode.todecoins.loot.modifiers.AddLootTableModifier;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.AlternativeLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModLootModifierGenProvider extends GlobalLootModifierProvider {
    public ModLootModifierGenProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void start() {
        add("add_four_leaf_clover_drops", new AddItemLootModifier(
                new LootItemCondition[]{
                        BlockTagCondition.isTag(ModTags.Blocks.DROPS_FOUR_LEAF_CLOVER)
                },
                ModItems.FOUR_LEAF_CLOVER.get(), 0.01F
        ));
        add("add_todecoins_chest", new AddLootTableModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(ModBuiltInLootTables.TODECOINS_CHEST_LOOT).build()
                },
                ModBuiltInLootTables.TODECOINS_CHEST_LOOT
        ));
        add("add_todecoins_bonus_fishing_table", new AddLootTableModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.FISHING).build()
                },
                ModBuiltInLootTables.TODECOINS_BONUS_FISHING
        ));
        add("add_todecoins_fishing_coins", new AddLootTableModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.FISHING_TREASURE).build()
                },
                ModBuiltInLootTables.TODECOINS_FISHING_COINS
        ));
        add("add_loot_chest_currency", new AddLootTableModifier(
                new LootItemCondition[]{
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(BuiltInLootTables.ABANDONED_MINESHAFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.ANCIENT_CITY))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.BASTION_BRIDGE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.BASTION_HOGLIN_STABLE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.BASTION_OTHER))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.BASTION_TREASURE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.BURIED_TREASURE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.DESERT_PYRAMID))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.END_CITY_TREASURE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.IGLOO_CHEST))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.JUNGLE_TEMPLE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.NETHER_BRIDGE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.PILLAGER_OUTPOST))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.RUINED_PORTAL))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.SHIPWRECK_TREASURE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.SIMPLE_DUNGEON))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.SPAWN_BONUS_CHEST))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.STRONGHOLD_CORRIDOR))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.STRONGHOLD_CROSSING))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.UNDERWATER_RUIN_BIG))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.UNDERWATER_RUIN_SMALL))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_ARMORER))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_BUTCHER))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_CARTOGRAPHER))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_FISHER))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_FLETCHER))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_DESERT_HOUSE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_MASON))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_PLAINS_HOUSE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_SAVANNA_HOUSE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_SHEPHERD))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_SNOWY_HOUSE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_TAIGA_HOUSE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_TANNERY))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_TEMPLE))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_TOOLSMITH))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_WEAPONSMITH))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.WOODLAND_MANSION))
                                .build()
                },
                ModBuiltInLootTables.TODECOINS_CHEST_LOOT
        ));
        add("add_loot_boss_currency_drops", new AddLootTableModifier(
                new LootItemCondition[]{
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(EntityType.ENDER_DRAGON.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.WARDEN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.WITHER.getDefaultLootTable()))
                                .build()
                },
                ModBuiltInLootTables.TODECOINS_BOSS_CURRENCY_DROPS
        ));
        add("add_loot_currency_drops", new AddLootTableModifier(
                new LootItemCondition[]{
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(EntityType.ALLAY.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.AXOLOTL.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.BAT.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.BEE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.BLAZE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.CAT.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.CAVE_SPIDER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.CHICKEN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.COD.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.COW.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.CREEPER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.DOLPHIN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.DONKEY.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.DROWNED.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ELDER_GUARDIAN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ENDERMAN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ENDERMITE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.EVOKER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.FOX.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.FROG.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.GHAST.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.GLOW_SQUID.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.GOAT.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.GUARDIAN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.HORSE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.HUSK.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.RABBIT.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.RAVAGER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ILLUSIONER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.IRON_GOLEM.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.LLAMA.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.MAGMA_CUBE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.MULE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.MOOSHROOM.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.OCELOT.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.PANDA.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.PARROT.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.PHANTOM.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.PIG.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.PILLAGER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.POLAR_BEAR.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.PUFFERFISH.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.RABBIT.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SALMON.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SHEEP.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SHULKER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.BAT.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SILVERFISH.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SKELETON.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SKELETON_HORSE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SLIME.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SNOW_GOLEM.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SPIDER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.SQUID.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.STRAY.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.STRIDER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.TADPOLE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.TRADER_LLAMA.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.TROPICAL_FISH.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.TURTLE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.VEX.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.VILLAGER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.WANDERING_TRADER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.VINDICATOR.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.WITCH.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.WITHER_SKELETON.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.WOLF.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ZOGLIN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ZOMBIE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ZOMBIE_HORSE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ZOMBIFIED_PIGLIN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.HOGLIN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.PIGLIN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.PIGLIN_BRUTE.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ZOMBIE_VILLAGER.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ELDER_GUARDIAN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.ENDER_DRAGON.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.WARDEN.getDefaultLootTable()))
                                .or(LootTableIdCondition.builder(EntityType.WITHER.getDefaultLootTable()))
                                .build()

                },
                ModBuiltInLootTables.TODECOINS_CURRENCY_DROPS
        ));
        add("add_loot_hero_gift_coins", new AddLootTableModifier(
                new LootItemCondition[]{
                        AlternativeLootItemCondition
                                .alternative(LootTableIdCondition.builder(BuiltInLootTables.ARMORER_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.BUTCHER_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.CARTOGRAPHER_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.CLERIC_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.FARMER_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.FISHERMAN_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.FLETCHER_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.LEATHERWORKER_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.LIBRARIAN_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.MASON_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.SHEPHERD_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.TOOLSMITH_GIFT))
                                .or(LootTableIdCondition.builder(BuiltInLootTables.WEAPONSMITH_GIFT))
                                .build()
                },
                ModBuiltInLootTables.TODECOINS_COIN_GIFT_LOOT
        ));
    }
}