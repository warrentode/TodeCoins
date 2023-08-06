package net.warrentode.todecoins.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        DataGenerator.PathProvider pathProvider = event.getGenerator().createPathProvider(DataGenerator.Target.DATA_PACK, "trades");
        boolean run = true;

        generator.addProvider(run, new VillagerTradeProvider(generator, pathProvider));
    }
}