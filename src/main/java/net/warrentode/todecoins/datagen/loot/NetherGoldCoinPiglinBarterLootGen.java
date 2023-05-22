package net.warrentode.todecoins.datagen.loot;

import net.minecraft.data.loot.PiglinBarterLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.loot.ModBuiltInLootTables;

import java.util.function.BiConsumer;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class NetherGoldCoinPiglinBarterLootGen extends PiglinBarterLoot {
    private static final ResourceLocation NETHER_GOLD_COIN_PIGLIN_BARTERING = new ResourceLocation(MODID, "gameplay/nether_gold_coin_piglin_bartering");

    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.NETHER_GOLD_COIN_PIGLIN_BARTERING,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.NETHERITE_PIGLIN_COIN.get()).setQuality(4)
                                        .setWeight(1))
                                .add(LootItem.lootTableItem(ModItems.GOLD_PIGLIN_COIN.get()).setQuality(3)
                                        .setWeight(2))
                                .add(LootItem.lootTableItem(ModItems.IRON_PIGLIN_COIN.get()).setQuality(2)
                                        .setWeight(3))
                                .add(LootItem.lootTableItem(ModItems.COPPER_PIGLIN_COIN.get()).setQuality(1)
                                        .setWeight(4))
                                .add(LootItem.lootTableItem(Items.LODESTONE)
                                        .setWeight(5))
                                .add(LootItem.lootTableItem(Items.BOOK).setWeight(5)
                                        .apply((new EnchantRandomlyFunction.Builder())
                                                .withEnchantment(Enchantments.QUICK_CHARGE)))
                                .add(LootItem.lootTableItem(Items.BOOK).setWeight(5)
                                        .apply((new EnchantRandomlyFunction.Builder())
                                                .withEnchantment(Enchantments.SMITE)))
                                .add(LootItem.lootTableItem(Items.GHAST_TEAR)
                                        .setWeight(10)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                                .add(LootItem.lootTableItem(Items.POTION).setWeight(8)
                                        .apply(SetPotionFunction.setPotion(Potions.LONG_FIRE_RESISTANCE)))
                                .add(LootItem.lootTableItem(Items.SPLASH_POTION).setWeight(8)
                                        .apply(SetPotionFunction.setPotion(Potions.LONG_FIRE_RESISTANCE)))
                                .add(LootItem.lootTableItem(Items.CROSSBOW)
                                        .setWeight(10))
                                .add(LootItem.lootTableItem(Items.GOLDEN_AXE)
                                        .setWeight(10))
                                .add(LootItem.lootTableItem(Items.SADDLE)
                                        .setWeight(10))
                                .add(LootItem.lootTableItem(Items.WARPED_FUNGUS_ON_A_STICK)
                                        .setWeight(10))
                                .add(LootItem.lootTableItem(Items.MUSIC_DISC_PIGSTEP)
                                        .setWeight(10))
                                .add(LootItem.lootTableItem(Items.PIGLIN_BANNER_PATTERN)
                                        .setWeight(10))
                                .add(LootItem.lootTableItem(Items.GLOWSTONE_DUST)
                                        .setWeight(20))
                                .add(LootItem.lootTableItem(Items.CRIMSON_NYLIUM)
                                        .setWeight(40))
                                .add(LootItem.lootTableItem(Items.WARPED_NYLIUM)
                                        .setWeight(40))
                                .add(LootItem.lootTableItem(Items.SHROOMLIGHT)
                                        .setWeight(40))
                                .add(LootItem.lootTableItem(Items.RED_NETHER_BRICKS)
                                        .setWeight(40)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F))))
                                .add(LootItem.lootTableItem(Items.MUSHROOM_STEW)
                                        .setWeight(40))
                                .add(LootItem.lootTableItem(Items.NETHER_WART)
                                        .setWeight(40)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 10.0F)))))
        );
    }
}