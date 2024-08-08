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

public class CollectibleCoinsChestSpringGen extends ChestLoot {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.SPRING_COINS_CHEST,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ELDER_GUARDIAN_COIN.get()).when(IN_OCEAN_MONUMENT))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ENDER_DRAGON_COIN.get()).when(IN_END_CITY))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WITHER_COIN.get()).when(IN_NETHER_FORTRESS))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WILDFIRE_COIN.get()).when(IN_NETHER_FORTRESS))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WARDEN_COIN.get()).when(IN_ANCIENT_CITY))

                                .add(LootItem.lootTableItem(ModItems.COPPER_BLAZE_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.COPPER_HOGLIN_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOMBIFIED_PIGLIN_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GHAST_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.COPPER_MAGMA_CUBE_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_BRUTE_COIN.get()).when(IN_NETHER))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WITHER_SKELETON_COIN.get()).when(IN_NETHER))

                                .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMITE_COIN.get()).when(IN_END))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SHULKER_COIN.get()).when(IN_END))

                                .add(LootItem.lootTableItem(ModItems.COPPER_SKELETON_HORSE_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOMBIE_HORSE_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SKELETON_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOGLIN_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_MERCHANT_COIN.get()).when(IN_OVERWORLD.or(IN_NETHER)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_ENDERMAN_COIN.get())
                                        .when(IN_OVERWORLD.or(IN_NETHER).or(IN_END)))

                                .add(LootItem.lootTableItem(ModItems.COPPER_ALLAY_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_AXOLOTL_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_BAT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_BEE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CAMEL_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CAT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CAVE_SPIDER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CHICKEN_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COD_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COW_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_FOX_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_FROG_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_MOOBLOOM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_MOOSHROOM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_OCELOT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PUFFERFISH_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SALMON_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_TROPICAL_FISH_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_HORSE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_DONKEY_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_MULE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SQUID_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GLOW_SQUID_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PARROT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PIG_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_RABBIT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SHEEP_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SNIFFER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_NUMISMATIST_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WANDERING_TRADER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_VILLAGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SNOW_GOLEM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_TADPOLE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_TURTLE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_DOLPHIN_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GOAT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_IRON_GOLEM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_LLAMA_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_TRADER_LLAMA_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PANDA_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_POLAR_BEAR_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SPIDER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WOLF_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CREEPER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_DROWNED_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GUARDIAN_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_EVOKER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_VINDICATOR_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_VEX_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_HUSK_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SLIME_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PHANTOM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PILLAGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_RAVAGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SILVERFISH_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_STRAY_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_WITCH_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOMBIE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ZOMBIE_VILLAGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GIANT_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ILLUSIONER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_COPPER_GOLEM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_TUFF_GOLEM_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GLARE_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ICEOLOGER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_MAULER_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_CRAB_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_SQUIRREL_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PENGUIN_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_GUARD_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_RASCAL_COIN.get()).when(IN_OVERWORLD))
                                .add(LootItem.lootTableItem(ModItems.COPPER_ARMADILLO_COIN.get()).when(IN_OVERWORLD))
                        ));
    }
}