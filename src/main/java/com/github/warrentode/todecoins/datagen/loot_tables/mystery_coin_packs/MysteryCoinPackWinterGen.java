package com.github.warrentode.todecoins.datagen.loot_tables.mystery_coin_packs;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class MysteryCoinPackWinterGen extends ChestLoot {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.WINTER_MYSTERY_COIN_PACK,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                // boss coins
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ELDER_GUARDIAN_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDER_DRAGON_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WITHER_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WILDFIRE_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WARDEN_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                // non-boss coins
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_BLAZE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HOGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOMBIFIED_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GHAST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MAGMA_CUBE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_BRUTE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WITHER_SKELETON_COIN.get()))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMITE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SHULKER_COIN.get()))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SKELETON_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOMBIE_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_MERCHANT_COIN.get()))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ENDERMAN_COIN.get()))

                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ALLAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_AXOLOTL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_BAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_BEE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CAMEL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CAVE_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CHICKEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COD_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COW_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_FOX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_FROG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MOOBLOOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MOOSHROOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_OCELOT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PUFFERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SALMON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TROPICAL_FISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_DONKEY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MULE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GLOW_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PARROT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_RABBIT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SHEEP_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SNIFFER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_NUMISMATIST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WANDERING_TRADER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_VILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SNOW_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TADPOLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TURTLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_DOLPHIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GOAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_IRON_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TRADER_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PANDA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_POLAR_BEAR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WOLF_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CREEPER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_DROWNED_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_EVOKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_VINDICATOR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_VEX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_HUSK_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SLIME_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PHANTOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_RAVAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SILVERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_STRAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_WITCH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOMBIE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ZOMBIE_VILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GIANT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ILLUSIONER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_COPPER_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_TUFF_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GLARE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ICEOLOGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_MAULER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_CRAB_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_SQUIRREL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PENGUIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_GUARD_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_RASCAL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_ARMADILLO_COIN.get()))
                        ));
    }
}