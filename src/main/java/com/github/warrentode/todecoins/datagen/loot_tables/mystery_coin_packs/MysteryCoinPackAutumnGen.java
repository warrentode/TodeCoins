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

public class MysteryCoinPackAutumnGen extends ChestLoot {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.AUTUMN_MYSTERY_COIN_PACK,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                // boss coins
                                .add(LootItem.lootTableItem(ModItems.GOLD_ELDER_GUARDIAN_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ENDER_DRAGON_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WITHER_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WILDFIRE_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WARDEN_COIN.get())
                                        .when(LootItemRandomChanceCondition.randomChance(0.001F)))
                                // non-boss coins
                                .add(LootItem.lootTableItem(ModItems.GOLD_BLAZE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_HOGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOMBIFIED_PIGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GHAST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_MAGMA_CUBE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_BRUTE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WITHER_SKELETON_COIN.get()))

                                .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMITE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SHULKER_COIN.get()))

                                .add(LootItem.lootTableItem(ModItems.GOLD_SKELETON_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOMBIE_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SKELETON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOGLIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_MERCHANT_COIN.get()))

                                .add(LootItem.lootTableItem(ModItems.GOLD_ENDERMAN_COIN.get()))

                                .add(LootItem.lootTableItem(ModItems.GOLD_ALLAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_AXOLOTL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_BAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_BEE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CAMEL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CAVE_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CHICKEN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COD_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COW_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_FOX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_FROG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_MOOBLOOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_MOOSHROOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_OCELOT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PUFFERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SALMON_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_TROPICAL_FISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_HORSE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_DONKEY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_MULE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GLOW_SQUID_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PARROT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PIG_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_RABBIT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SHEEP_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SNIFFER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_NUMISMATIST_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WANDERING_TRADER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_VILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SNOW_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_TADPOLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_TURTLE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_DOLPHIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GOAT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_IRON_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_TRADER_LLAMA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PANDA_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_POLAR_BEAR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SPIDER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WOLF_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CREEPER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_DROWNED_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GUARDIAN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_EVOKER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_VINDICATOR_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_VEX_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_HUSK_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SLIME_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PHANTOM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_RAVAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SILVERFISH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_STRAY_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_WITCH_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOMBIE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ZOMBIE_VILLAGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GIANT_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ILLUSIONER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_COPPER_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_TUFF_GOLEM_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GLARE_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ICEOLOGER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_MAULER_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_CRAB_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_SQUIRREL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PENGUIN_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_GUARD_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_RASCAL_COIN.get()))
                                .add(LootItem.lootTableItem(ModItems.GOLD_ARMADILLO_COIN.get()))
                        ));
    }
}