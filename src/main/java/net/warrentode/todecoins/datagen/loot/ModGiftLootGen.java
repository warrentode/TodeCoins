package net.warrentode.todecoins.datagen.loot;

import net.minecraft.data.loot.GiftLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.warrentode.todecoins.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModGiftLootGen extends GiftLoot {
    private static final ResourceLocation BANKER_GIFT = new ResourceLocation(MODID, "gameplay/hero_of_the_village/banker_gift");
    private static final ResourceLocation LEPRECHAUN_GIFT = new ResourceLocation(MODID, "gameplay/hero_of_the_village/leprechaun_gift");

    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(BANKER_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.CURRENCY_STAMP.get()))
                                        .add(LootItem.lootTableItem(ModItems.NETHER_CURRENCY_STAMP.get()))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()))
                                        .add(LootItem.lootTableItem(ModItems.IRON_COIN.get()))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get()))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_COIN.get()))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get()))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get()))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get()))
                        )
        );
        consumer.accept(LEPRECHAUN_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(ModItems.COPPER_COIN.get()))
                                        .add(LootItem.lootTableItem(ModItems.IRON_COIN.get()))
                                        .add(LootItem.lootTableItem(ModItems.GOLD_COIN.get()))
                                        .add(LootItem.lootTableItem(ModItems.NETHERITE_COIN.get()))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_QUARTER_BANK_NOTE.get()))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_HALF_BANK_NOTE.get()))
                                        .add(LootItem.lootTableItem(ModItems.EMERALD_BANK_NOTE.get()))
                                        .add(LootItem.lootTableItem(ModItems.LUCKY_COIN.get()))
                        )
        );
    }
}