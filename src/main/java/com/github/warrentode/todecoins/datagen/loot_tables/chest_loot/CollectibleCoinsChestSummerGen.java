package com.github.warrentode.todecoins.datagen.loot_tables.chest_loot;

import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static com.github.warrentode.todecoins.datagen.ModLootTableGenProvider.*;

public class CollectibleCoinsChestSummerGen extends ChestLoot {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.SUMMER_COINS_CHEST,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.IRON_ELDER_GUARDIAN_COIN.get()).when(IN_OCEAN_MONUMENT))
                                .add(LootItem.lootTableItem(ModItems.IRON_ENDER_DRAGON_COIN.get()).when(IN_END_CITY))
                                .add(LootItem.lootTableItem(ModItems.IRON_WITHER_COIN.get()).when(IN_NETHER_FORTRESS))
                                .add(LootItem.lootTableItem(ModItems.IRON_WILDFIRE_COIN.get()).when(IN_NETHER_FORTRESS))
                                .add(LootItem.lootTableItem(ModItems.IRON_WARDEN_COIN.get()).when(IN_ANCIENT_CITY))

                                .add(LootItem.lootTableItem(ModItems.IRON_BLAZE_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.IRON_HOGLIN_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.IRON_ZOMBIFIED_PIGLIN_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.IRON_GHAST_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.IRON_MAGMA_CUBE_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_BRUTE_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.IRON_WITHER_SKELETON_COIN.get()).when(IN_NETHER))

                                .add(LootItem.lootTableItem(ModItems.IRON_ENDERMITE_COIN.get()).when(IN_END))
                                .add(LootItem.lootTableItem(ModItems.IRON_SHULKER_COIN.get()).when(IN_END))

                                .add(LootItem.lootTableItem(ModItems.IRON_SKELETON_HORSE_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))
                                .add(LootItem.lootTableItem(ModItems.IRON_ZOMBIE_HORSE_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))
                                .add(LootItem.lootTableItem(ModItems.IRON_SKELETON_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))
                                .add(LootItem.lootTableItem(ModItems.IRON_ZOGLIN_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))
                                .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_MERCHANT_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))

                                .add(LootItem.lootTableItem(ModItems.IRON_ENDERMAN_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER).or(IN_END)))

                                .add(LootItem.lootTableItem(ModItems.IRON_ALLAY_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_AXOLOTL_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_BAT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_BEE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_CAMEL_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_CAT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_CAVE_SPIDER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_CHICKEN_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_COD_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_COW_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_FOX_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_FROG_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_MOOBLOOM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_MOOSHROOM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_OCELOT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_PUFFERFISH_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_SALMON_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_TROPICAL_FISH_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_HORSE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_DONKEY_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_MULE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_SQUID_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_GLOW_SQUID_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_PARROT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_PIG_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_RABBIT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_SHEEP_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_SNIFFER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_NUMISMATIST_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_WANDERING_TRADER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_VILLAGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_SNOW_GOLEM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_TADPOLE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_TURTLE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_DOLPHIN_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_GOAT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_IRON_GOLEM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_LLAMA_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_TRADER_LLAMA_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_PANDA_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_POLAR_BEAR_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_SPIDER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_WOLF_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_CREEPER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_DROWNED_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_GUARDIAN_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_EVOKER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_VINDICATOR_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_VEX_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_HUSK_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_SLIME_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_PHANTOM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_PILLAGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_RAVAGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_SILVERFISH_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_STRAY_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_WITCH_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_ZOMBIE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_ZOMBIE_VILLAGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_GIANT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_ILLUSIONER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_COPPER_GOLEM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_TUFF_GOLEM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_GLARE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_ICEOLOGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_MAULER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_CRAB_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_SQUIRREL_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_PENGUIN_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_GUARD_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_RASCAL_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.IRON_ARMADILLO_COIN.get()).when(IN_OVERWORLD))
                        ));
    }
}