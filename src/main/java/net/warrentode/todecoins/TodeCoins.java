package net.warrentode.todecoins;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.warrentode.todecoins.block.ModBlocks;
import net.warrentode.todecoins.block.entity.ModBlockEntities;
import net.warrentode.todecoins.item.ModItems;
import net.warrentode.todecoins.loot.ModLootModifiers;
import net.warrentode.todecoins.potion.ModPotions;
import net.warrentode.todecoins.recipe.ModRecipes;
import net.warrentode.todecoins.screen.CoinPressScreen;
import net.warrentode.todecoins.screen.ModMenuTypes;
import net.warrentode.todecoins.trades.TradeManager;
import net.warrentode.todecoins.trades.type.BasicType;
import net.warrentode.todecoins.util.BetterBrewingRecipe;
import net.warrentode.todecoins.villager.ModVillagers;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("ALL")
@Mod(TodeCoins.MODID)
public class TodeCoins {
    public static final String MODID = "todecoins";
    public TodeCoins() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::setup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModRecipes.register(modEventBus);
        ModPotions.register(modEventBus);

        ModLootModifiers.register(modEventBus);
    }


    private void commonSetup(final @NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(()-> {
           ModVillagers.registerPOIs();
        });
        // AUTHOR: MrCrayfish https://github.com/MrCrayfish/GoblinTraders/tree/1.19.X
        TradeManager manager = TradeManager.instance();
        manager.registerTradeSerializer(BasicType.SERIALIZER);
        manager.registerTrader(ModVillagers.BANKER.get());
        manager.registerTrader(ModVillagers.LEPRECHAUN.get());
        manager.registerTrader(VillagerProfession.ARMORER);
        manager.registerTrader(VillagerProfession.BUTCHER);
        manager.registerTrader(VillagerProfession.CARTOGRAPHER);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.COIN_PRESS_MENU.get(), CoinPressScreen::new);
        }
    }

    private void setup(final @NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(()-> {
            // Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.WATER,
                    ModItems.LUCKY_COIN.get(), Potions.THICK));
            // Luck Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    ModItems.LUCKY_COIN.get(), Potions.LUCK));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.LUCK,
                    Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.LUCK_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.LUCK_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.LUCK_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.LUCK_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_6.get()));
            // Long Luck Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.LUCK,
                    Items.REDSTONE, ModPotions.LONG_LUCK_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.LUCK_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_LUCK_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.LUCK_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_LUCK_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.LUCK_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_LUCK_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.LUCK_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_LUCK_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.LUCK_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_LUCK_POTION_6.get()));
            // Bad Luck Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.LUCK,
                    Items.FERMENTED_SPIDER_EYE, ModPotions.UNLUCK_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.UNLUCK_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.UNLUCK_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.UNLUCK_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.UNLUCK_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.UNLUCK_POTION_6.get()));
            // Long Bad Luck Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_UNLUCK_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_UNLUCK_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_UNLUCK_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_UNLUCK_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_UNLUCK_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.UNLUCK_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_UNLUCK_POTION_6.get()));
        });
    }
}