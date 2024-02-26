package com.github.warrentode.todecoins.datagen.loot_tables.merchant;

import com.faboslav.friendsandfoes.init.FriendsAndFoesItems;
import com.github.warrentode.todecoins.loot.ModBuiltInLootTables;
import com.github.warrentode.todecoins.loot.conditions.ModCheckCondition;
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.mehvahdjukaar.cagerium.Cagerium;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class MerchantOffersGen extends ChestLoot {
    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModBuiltInLootTables.NUMISMATIST_RARE_OFFERS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(TagEntry.expandTag(ItemTags.MUSIC_DISCS))
                                .add(TagEntry.expandTag(ModTags.Items.SOUL_BINDER))
                                .add(LootItem.lootTableItem(Items.HEART_OF_THE_SEA))
                                .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE))
                                .add(LootItem.lootTableItem(Items.MOJANG_BANNER_PATTERN))
                                .add(LootItem.lootTableItem(Items.TOTEM_OF_UNDYING))
                                .add(LootItem.lootTableItem(Items.DRAGON_BREATH))
                                .add(LootItem.lootTableItem(Items.AMETHYST_BLOCK))
                                .add(LootItem.lootTableItem(Items.ELYTRA))
                                .add(LootItem.lootTableItem(Cagerium.TERRARIUM_BASE.get())
                                        .when(ModCheckCondition.mod().isLoaded("cagerium")))
                                .add(LootItem.lootTableItem(Cagerium.CAGE_BASE.get())
                                        .when(ModCheckCondition.mod().isLoaded("cagerium")))
                                .add(LootItem.lootTableItem(Cagerium.PLATE_GEM.get())
                                        .when(ModCheckCondition.mod().isLoaded("cagerium")))
                                .add(LootItem.lootTableItem(Cagerium.FIRE_UPGRADE.get())
                                        .when(ModCheckCondition.mod().isLoaded("cagerium")))
                                .add(LootItem.lootTableItem(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get())
                                        .when(ModCheckCondition.mod().isLoaded("friendsandfoes")))
                                .add(LootItem.lootTableItem(FriendsAndFoesItems.TOTEM_OF_FREEZING.get())
                                        .when(ModCheckCondition.mod().isLoaded("friendsandfoes")))
                                .add(LootItem.lootTableItem(FriendsAndFoesItems.WILDFIRE_CROWN_FRAGMENT.get())
                                        .when(ModCheckCondition.mod().isLoaded("friendsandfoes")))
                        ));
        consumer.accept(ModBuiltInLootTables.NUMISMATIST_CONTAINER_OFFERS,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .setBonusRolls(ConstantValue.exactly(0F))
                                .add(TagEntry.expandTag(ModTags.Items.SHULKER_BOXES))
                                .add(TagEntry.expandTag(ModTags.Items.WALLETS))
                                .add(LootItem.lootTableItem(Items.ENDER_CHEST))
                        ));
    }
}