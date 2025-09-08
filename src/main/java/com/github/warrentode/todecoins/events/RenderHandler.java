package com.github.warrentode.todecoins.events;

import com.github.warrentode.todecoins.block.entity.TCBlockEntities;
import com.github.warrentode.todecoins.block.entity.renderer.TipJarEntityRenderer;
import com.github.warrentode.todecoins.gui.TCMenuTypes;
import com.github.warrentode.todecoins.gui.coinalbum.CoinAlbumScreen;
import com.github.warrentode.todecoins.gui.coinpressgui.CoinPressScreen;
import com.github.warrentode.todecoins.entity.TCEntityTypes;
import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchantModel;
import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchantModelLayers;
import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchantRenderer;
import com.github.warrentode.todecoins.entity.villager.renderer.NumismatistRenderer;
import com.github.warrentode.todecoins.gui.walletgui.WalletScreen;
import com.github.warrentode.todecoins.particle.TCParticles;
import com.github.warrentode.todecoins.particle.custom.LuckParticles;
import com.github.warrentode.todecoins.recipe.recipebook.CoinPressRecipeCategories;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderHandler {
    @SubscribeEvent
    public static void onClientSetup(@NotNull FMLClientSetupEvent event) {
        // screens
        event.enqueueWork(() -> {
            MenuScreens.register(TCMenuTypes.COIN_PRESS_MENU.get(), CoinPressScreen::new);
            MenuScreens.register(TCMenuTypes.WALLET_MENU.get(), WalletScreen::new);
            MenuScreens.register(TCMenuTypes.COIN_ALBUM_MENU.get(), CoinAlbumScreen::new);
        });

        // entity renderers
        EntityRenderers.register(TCEntityTypes.NUMISMATIST.get(), NumismatistRenderer::new);
        EntityRenderers.register(TCEntityTypes.PIGLINMERCHANT.get(), PiglinMerchantRenderer::new);

        // block entity renderers
        BlockEntityRenderers.register(TCBlockEntities.TIP_JAR_BLOCK_ENTITY.get(), TipJarEntityRenderer::new);

    }

    // render layers for entity models
    @SubscribeEvent
    public static void registerLayerDefinitions(@NotNull EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PiglinMerchantModelLayers.PIGLINMERCHANT, PiglinMerchantModel::createBodyLayer);
    }

    // custom recipe book screen
    @SubscribeEvent
    public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
        CoinPressRecipeCategories.init(event);
    }

    @SubscribeEvent
    public static void registerParticleProvider(@NotNull RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(TCParticles.LUCK_PARTICLES.get(), LuckParticles.Provider::new);
    }
}