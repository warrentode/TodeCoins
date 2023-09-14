package com.github.warrentode.todecoins;

import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.block.entity.ModBlockEntities;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.entity.villager.ModVillagers;
import com.github.warrentode.todecoins.entity.villager.renderer.NumismatistRenderer;
import com.github.warrentode.todecoins.gui.ModMenuTypes;
import com.github.warrentode.todecoins.gui.coinpressgui.CoinPressScreen;
import com.github.warrentode.todecoins.integration.Curios;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.github.warrentode.todecoins.loot.serializers.ModLootModifiers;
import com.github.warrentode.todecoins.potion.BetterBrewingRecipe;
import com.github.warrentode.todecoins.potion.ModPotions;
import com.github.warrentode.todecoins.recipe.ModRecipes;
import com.github.warrentode.todecoins.recipe.recipebook.CoinPressRecipeCategories;
import com.github.warrentode.todecoins.sounds.ModSounds;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.concurrent.atomic.AtomicReference;

@Mod(TodeCoins.MODID)
public class TodeCoins {
    public static final String MODID = "todecoins";
    public static final Logger LOGGER = LogManager.getLogger();

    public TodeCoins() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::onIMEnqueueEvent);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::setup);

        ModSounds.SOUNDS.register(modEventBus);
        ModAttributes.ATTRIBUTES.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModEntityTypes.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModPotions.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModLootItemConditions.register(modEventBus);
    }

    public static ItemStack setCurioSlots(Player player) {
        AtomicReference<ItemStack> slot = new AtomicReference<>(ItemStack.EMPTY);
        if (ModList.get().isLoaded("curios")) {
            slot.set(Curios.getCharmSlot(player));
            slot.set(Curios.getBeltSlot(player));
        }
        return slot.get();
    }

    private void commonSetup(final @NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(ModVillagers::registerPOIs);
        event.enqueueWork(ModVillagers::init);
        event.enqueueWork(() -> {
            //noinspection deprecation
            SpawnPlacements.register(ModEntityTypes.NUMISMATIST.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        });
    }

    private void onIMEnqueueEvent(InterModEnqueueEvent event) {
        if (ModList.get().isLoaded("curios")) {
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                    () -> SlotTypePreset.CHARM.getMessageBuilder().build());
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                    () -> SlotTypePreset.BELT.getMessageBuilder().build());
        }
    }

    private void setup(final @NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
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

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> MenuScreens.register(ModMenuTypes.COIN_PRESS_MENU.get(), CoinPressScreen::new));
            EntityRenderers.register(ModEntityTypes.NUMISMATIST.get(), NumismatistRenderer::new);
        }

        @SubscribeEvent
        public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
            CoinPressRecipeCategories.init(event);
        }
    }
}