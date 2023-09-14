package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.datagen.recipes.RecipesGen;
import com.github.warrentode.todecoins.datagen.recipes.recipe.ConditionalCageriumRecipes;
import com.github.warrentode.todecoins.datagen.recipes.recipe.ConditionalSpawnEggRecipes;
import com.github.warrentode.todecoins.datagen.tags.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = TodeCoins.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        BlockTagsGen blockTagsGen = new BlockTagsGen(generator, TodeCoins.MODID, helper);
        generator.addProvider(event.includeServer(), blockTagsGen);

        ItemTagsGen itemTagsGen = new ItemTagsGen(generator, blockTagsGen, TodeCoins.MODID, helper);
        generator.addProvider(event.includeServer(), itemTagsGen);

        PoiTypeTagsGen poiTypeTagsGen = new PoiTypeTagsGen(generator, TodeCoins.MODID, helper);
        generator.addProvider(event.includeServer(), poiTypeTagsGen);

        EntityTypeTagsGen entityTypeTagsGen = new EntityTypeTagsGen(generator, TodeCoins.MODID, helper);
        generator.addProvider(event.includeServer(), entityTypeTagsGen);

        StructureTagsGen structureTagsGen = new StructureTagsGen(generator, TodeCoins.MODID, helper);
        generator.addProvider(event.includeServer(), structureTagsGen);

        generator.addProvider(event.includeClient(), new LanguageFileGen(generator, TodeCoins.MODID, "en_us"));

        generator.addProvider(event.includeServer(), new RecipesGen(generator));
        generator.addProvider(event.includeServer(), new ConditionalCageriumRecipes(generator));
        generator.addProvider(event.includeServer(), new ConditionalSpawnEggRecipes(generator));
        generator.addProvider(event.includeServer(), new AdvancementsGen(generator, helper));
        generator.addProvider(event.includeServer(), new ModLootTableGenProvider(generator));
        generator.addProvider(event.includeServer(), new ModLootModifierGenProvider(generator, TodeCoins.MODID));
    }
}