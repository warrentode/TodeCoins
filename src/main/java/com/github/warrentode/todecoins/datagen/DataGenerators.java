package com.github.warrentode.todecoins.datagen;

import com.github.warrentode.todecoins.datagen.models.BlockStateGen;
import com.github.warrentode.todecoins.datagen.models.ItemModelGen;
import com.github.warrentode.todecoins.datagen.tags.*;
import com.github.warrentode.todecoins.datagen.trades.JsonTradesProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        // dynamically call for lang file locales
        String[] supportedLanguages = {
                "en_us", "en_gb", "en_ca", "en_au", "de_de", "fr_fr", "fr_ca", "es_es", "es_mx", "pt_pt",
                "pt_br", "it_it", "nl_nl", "ru_ru", "uk_ua", "pl_pl", "cs_cz", "sk_sk", "hu_hu",
                "sv_se", "no_no", "da_dk", "fi_fi", "tr_tr", "el_gr", "ro_ro", "bg_bg", "zh_cn",
                "zh_tw", "ja_jp", "ko_kr", "th_th", "ar_sa", "he_il", "hi_in", "id_id", "ms_my",
                "en_pt" // Pirate Speak ☠️
        };

        // lang filee
        if (event.includeClient()) {
            for (String locale : supportedLanguages) {
                generator.addProvider(true, new LanguageFilesGen(packOutput, MODID, locale));
            }
        }

        // models
        generator.addProvider(event.includeServer(), new ItemModelGen(packOutput, MODID, helper));
        generator.addProvider(event.includeServer(), new BlockStateGen(packOutput, MODID, helper));

        // tags
        BlockTagsGen blockTagsGen = new BlockTagsGen(packOutput, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTagsGen);
        generator.addProvider(event.includeServer(), new ItemTagsGen(packOutput, lookupProvider, blockTagsGen.contentsGetter(), MODID, helper));
        generator.addProvider(event.includeServer(), new BiomeTagsGen(packOutput, lookupProvider, MODID, helper));
        generator.addProvider(event.includeServer(), new StructureTagsGen(packOutput, lookupProvider, MODID, helper));
        generator.addProvider(event.includeServer(), new EntityTypeTagsGen(packOutput, lookupProvider, MODID, helper));
        generator.addProvider(event.includeServer(), new PoiTypeTagsGen(packOutput, lookupProvider, MODID, helper));

        // sound files
        generator.addProvider(event.includeClient(), new SoundsFileGen(packOutput, MODID, helper));

        // loot tables
        generator.addProvider(event.includeServer(), LootTablesGen.create(packOutput));
        generator.addProvider(event.includeServer(), new LootModifiersGen(packOutput, MODID));

        // world gen
        generator.addProvider(event.includeServer(), new WorldGen(packOutput, lookupProvider));

        // recipe gen
        generator.addProvider(event.includeServer(), new RecipesGen(packOutput));

        // json trades gen
        generator.addProvider(event.includeServer(), new JsonTradesProvider(packOutput));

        // advancement gen
        generator.addProvider(event.includeServer(), new AdvancementsGen(packOutput, lookupProvider, helper));
    }
}