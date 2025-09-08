package com.github.warrentode.todecoins.datagen.models;

import com.github.warrentode.todecoins.item.TCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected final void registerModels() {
        // basic item models
        TCItems.ITEMS.getEntries().stream().map(RegistryObject::get).filter(item -> {
            ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
            // items with special model formats are excluded to be added by hand
            return location != null && !location.getPath().contains("spawn_egg")
                    && !location.getPath().contains("coin_bag")
                    && !location.getPath().contains("note_bag")
                    && !location.getPath().contains("coin_press")
                    && !location.getPath().contains("echo_thread")
                    && !location.getPath().contains("emerald_thread")
                    && !location.getPath().contains("endonian_thread")
                    && !location.getPath().contains("lucky_fabric")
                    && !location.getPath().contains("lucky_thread")
                    && !location.getPath().contains("nether_currency_stamp")
                    && !location.getPath().contains("nether_gold_coin")
                    && !location.getPath().contains("pot_of_gold")
                    && !location.getPath().contains("endonian_crystal")
                    && !location.getPath().contains("endonian_block")
                    && !location.getPath().contains("tip_jar")
                    && !location.getPath().contains("coin_album");
        }).forEach(this::basicItem);

        // spawn egg models
        TCItems.ITEMS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(item -> {
                    ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
                    return location != null && location.getPath().contains("spawn_egg");
                })
                .forEach(item -> spawnEggItem((ForgeSpawnEggItem) item));

        // remaining special models added to the pack manually
    }

    private @NotNull String itemName(Item item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    private void spawnEggItem(ForgeSpawnEggItem item) {
        withExistingParent(itemName(item), mcLoc("template_spawn_egg"));
    }
}