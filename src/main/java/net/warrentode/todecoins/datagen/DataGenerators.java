package net.warrentode.todecoins.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todecoins.datagen.recipes.Recipes;
import net.warrentode.todecoins.datagen.tags.BlockTags;
import net.warrentode.todecoins.datagen.tags.ItemTags;
import net.warrentode.todecoins.datagen.tags.PoiTypeTags;
import net.warrentode.todecoins.datagen.tags.StructureTags;
import org.jetbrains.annotations.NotNull;

import static net.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        BlockTags blockTags = new BlockTags(generator, MODID, helper);
        generator.addProvider(event.includeServer(), blockTags);

        ItemTags itemTags = new ItemTags(generator, blockTags, MODID, helper);
        generator.addProvider(event.includeServer(), itemTags);

        PoiTypeTags poiTypeTags = new PoiTypeTags(generator, MODID, helper);
        generator.addProvider(event.includeServer(), poiTypeTags);

        StructureTags structureTags = new StructureTags(generator, MODID, helper);
        generator.addProvider(event.includeServer(), structureTags);

        generator.addProvider(event.includeServer(), new Recipes(generator));
        generator.addProvider(event.includeServer(), new Advancements(generator, helper));
        generator.addProvider(event.validate(), new ModLootTableProvider(generator));
    }
}