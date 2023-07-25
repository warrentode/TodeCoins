package net.warrentode.todecoins.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todecoins.datagen.recipes.RecipesGen;
import net.warrentode.todecoins.datagen.recipes.recipe.ConditionalCageriumRecipes;
import net.warrentode.todecoins.datagen.recipes.recipe.ConditionalSpawnEggRecipes;
import net.warrentode.todecoins.datagen.tags.*;
import org.jetbrains.annotations.NotNull;

import static net.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        BlockTagsGen blockTagsGen = new BlockTagsGen(generator, MODID, helper);
        generator.addProvider(event.includeServer(), blockTagsGen);

        ItemTagsGen itemTagsGen = new ItemTagsGen(generator, blockTagsGen, MODID, helper);
        generator.addProvider(event.includeServer(), itemTagsGen);

        PoiTypeTagsGen poiTypeTagsGen = new PoiTypeTagsGen(generator, MODID, helper);
        generator.addProvider(event.includeServer(), poiTypeTagsGen);

        EntityTypeTagsGen entityTypeTagsGen = new EntityTypeTagsGen(generator, MODID, helper);
        generator.addProvider(event.includeServer(), entityTypeTagsGen);

        StructureTagsGen structureTagsGen = new StructureTagsGen(generator, MODID, helper);
        generator.addProvider(event.includeServer(), structureTagsGen);

        generator.addProvider(event.includeClient(), new LanguageFileGen(generator, MODID, "en_us"));

        generator.addProvider(event.includeServer(), new RecipesGen(generator));
        generator.addProvider(event.includeServer(), new ConditionalSpawnEggRecipes(generator));
        generator.addProvider(event.includeServer(), new ConditionalCageriumRecipes(generator));
        generator.addProvider(event.includeServer(), new AdvancementsGen(generator, helper));
        generator.addProvider(event.includeServer(), new ModLootTableGenProvider(generator));
        generator.addProvider(event.includeServer(), new ModLootModifierGenProvider(generator, MODID));
    }
}