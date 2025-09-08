package com.github.warrentode.todecoins;

import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.block.TCBlocks;
import com.github.warrentode.todecoins.block.entity.TCBlockEntities;
import com.github.warrentode.todecoins.gui.TCMenuTypes;
import com.github.warrentode.todecoins.effect.TCMobEffects;
import com.github.warrentode.todecoins.entity.TCEntityTypes;
import com.github.warrentode.todecoins.entity.trades.trade_api.CustomRegistryHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.villager.TCVillagers;
import com.github.warrentode.todecoins.events.EntitySetupHandler;
import com.github.warrentode.todecoins.integration.curios.network.CurioNetwork;
import com.github.warrentode.todecoins.item.TCItems;
import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.github.warrentode.todecoins.loot.serializers.ModLootModifiers;
import com.github.warrentode.todecoins.particle.TCParticles;
import com.github.warrentode.todecoins.potion.TCPotions;
import com.github.warrentode.todecoins.potion.TCBrewingRecipes;
import com.github.warrentode.todecoins.recipe.TCRecipes;
import com.github.warrentode.todecoins.sounds.TCSounds;
import com.github.warrentode.todecoins.util.tabs.TCCreativeTabs;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.function.Supplier;

@Mod(TodeCoins.MODID)
public class TodeCoins {
    public static final String MODID = "todecoins";
    public static final Logger TC_LOGGER = LogUtils.getLogger();

    public static Supplier<IForgeRegistry<TradeOfferFactoryType<?>>> supplier = null;
    public static final ResourceLocation TRADE_OFFER_FACTORY_REGISTRY_KEY = ResourceLocation.parse(MODID + ":trade_offer_factory");

    // Instance of TradeOfferManager
    public static final TradeOfferManager TRADE_OFFER_MANAGER = new TradeOfferManager();

    // registrations & lifecycle hooks
    public TodeCoins(@NotNull FMLJavaModLoadingContext context) {
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC, MODID + "/common.toml");
        IEventBus modEventBus = context.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        // add listeners
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::newRegistryEventListener);
        modEventBus.addListener(this::registerEventListener);

        // Register trade offer manager as a reload listener
        MinecraftForge.EVENT_BUS.addListener(TRADE_OFFER_MANAGER::onDataPackReload);

        TCSounds.register(modEventBus);
        ModAttributes.register(modEventBus);

        TCItems.register(modEventBus);
        TCBlocks.register(modEventBus);

        // Optional Cagerium tab registration
        TCCreativeTabs.registerOptionalTabs();
        TCCreativeTabs.CREATIVE_TABS.register(modEventBus);

        TCBlockEntities.register(modEventBus);
        TCEntityTypes.register(modEventBus);
        TCVillagers.register(modEventBus);

        TCMenuTypes.register(modEventBus);
        TCRecipes.register(modEventBus);
        TCMobEffects.register(modEventBus);
        TCPotions.register(modEventBus);

        TCParticles.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModLootItemConditions.register(modEventBus);

        // forces the class to load early
        TradeOfferFactoryType.init();
    }

    // trade offer registries
    private void newRegistryEventListener(@NotNull NewRegistryEvent event) {
        RegistryBuilder<TradeOfferFactoryType<?>> builder = new RegistryBuilder<>();
        builder.setName(TRADE_OFFER_FACTORY_REGISTRY_KEY);
        supplier = event.create(builder);
    }

    private void registerEventListener(RegisterEvent event) {
        CustomRegistryHelper.tradeOfferFactoryTypeRegistryHelper.registerAll(event);
    }

    // Server + client-safe setup code, like brewing recipes & network registration
    private void commonSetup(final @NotNull FMLCommonSetupEvent event) {
        TC_LOGGER.info("Common Setup for TodeCoins");
        event.enqueueWork(() -> {
            // custom hero gift setup
            TCVillagers.init();
            // entity setup and non-villager trade manager setup
            EntitySetupHandler.initMerchants();
            // Register Curios specifc network packets
            CurioNetwork.registerPackets();
            // Register Brewing Recipes
            TCBrewingRecipes.registerAll();
        });
    }
}