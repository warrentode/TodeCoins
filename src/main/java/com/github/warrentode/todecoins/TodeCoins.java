package com.github.warrentode.todecoins;

import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.block.entity.ModBlockEntities;
import com.github.warrentode.todecoins.config.Config;
import com.github.warrentode.todecoins.effect.ModEffects;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchantRenderer;
import com.github.warrentode.todecoins.entity.trades.trade_api.CustomRegistryHelper;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.TradeOfferManager;
import com.github.warrentode.todecoins.entity.trades.trade_api.trade_codecs.trade_types.TradeOfferFactoryType;
import com.github.warrentode.todecoins.entity.villager.ModVillagers;
import com.github.warrentode.todecoins.entity.villager.renderer.NumismatistRenderer;
import com.github.warrentode.todecoins.gui.ModMenuTypes;
import com.github.warrentode.todecoins.gui.coinpressgui.CoinPressScreen;
import com.github.warrentode.todecoins.integration.CurioBeltSlot;
import com.github.warrentode.todecoins.item.ModItems;
import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.github.warrentode.todecoins.loot.serializers.ModLootModifiers;
import com.github.warrentode.todecoins.potion.BetterBrewingRecipe;
import com.github.warrentode.todecoins.potion.ModPotions;
import com.github.warrentode.todecoins.recipe.ModRecipes;
import com.github.warrentode.todecoins.recipe.recipebook.CoinPressRecipeCategories;
import com.github.warrentode.todecoins.sounds.ModSounds;
import com.github.warrentode.todecoins.util.TodeCoinsTags;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.function.Supplier;

@Mod(TodeCoins.MODID)
public class TodeCoins {
    public static final String MODID = "todecoins";
    public static final Logger LOGGER = LogManager.getLogger();

    public static Supplier<IForgeRegistry<TradeOfferFactoryType<?>>> supplier = null;
    @SuppressWarnings("removal")
    public static final ResourceLocation TRADE_OFFER_FACTORY_REGISTRY_KEY = new ResourceLocation(MODID, "trade_offer_factory");

    // Instance of TradeOfferManager
    public static final TradeOfferManager TRADE_OFFER_MANAGER = new TradeOfferManager();

    @SuppressWarnings("removal")
    public TodeCoins() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, MODID + "/common.toml");

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        // add listeners
        modEventBus.addListener(this::onIMEnqueueEvent);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::newRegistryEventListener);
        modEventBus.addListener(this::registerEventListener);

        // Register manager as a reload listener
        MinecraftForge.EVENT_BUS.addListener(TRADE_OFFER_MANAGER::onDataPackReload);

        ModSounds.SOUNDS.register(modEventBus);
        ModAttributes.ATTRIBUTES.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModEntityTypes.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModLootItemConditions.register(modEventBus);

        // forces the class to load early
        TradeOfferFactoryType.init();

        LOGGER.info("Initializing TodeCoins.");
    }

    private void newRegistryEventListener(@NotNull NewRegistryEvent event) {
        RegistryBuilder<TradeOfferFactoryType<?>> builder = new RegistryBuilder<>();
        builder.setName(TRADE_OFFER_FACTORY_REGISTRY_KEY);
        supplier = event.create(builder);
    }

    private void registerEventListener(RegisterEvent event) {
        CustomRegistryHelper.tradeOfferFactoryTypeRegistryHelper.registerAll(event);
    }

    private void onIMEnqueueEvent(InterModEnqueueEvent event) {
        if (ModList.get().isLoaded("curios")) {
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                    () -> SlotTypePreset.CHARM.getMessageBuilder().build());
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                    () -> SlotTypePreset.BELT.getMessageBuilder().build());
        }
    }

    @SubscribeEvent
    public void attachCapabilities(@NotNull AttachCapabilitiesEvent<ItemStack> event) {
        ItemStack stack = event.getObject();
        //noinspection unused
        Item item = stack.getItem();
        if (stack.is(TodeCoinsTags.Items.WALLETS)) {
            final LazyOptional<ICurio> curioBeltSlot = LazyOptional.of(() -> new CurioBeltSlot(stack));
            event.addCapability(CuriosCapability.ID_ITEM, new ICapabilityProvider() {
                @Override
                public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
                    return CuriosCapability.ITEM.orEmpty(cap, curioBeltSlot);
                }
            });
            event.addListener(curioBeltSlot::invalidate);
        }
    }

    private void commonSetup(final @NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Register all Merchant-implementing entity types
            ForgeRegistries.ENTITY_TYPES.getValues().forEach(entityType -> {
                Class<?> entityClass = entityType.getBaseClass();

                if (Merchant.class.isAssignableFrom(entityClass)) {
                    ResourceLocation id = ForgeRegistries.ENTITY_TYPES.getKey(entityType);
                    if (id != null) {
                        TradeOfferManager.registerGenericMerchant(entityType, id);
                        TodeCoins.LOGGER.info("Registered merchant entity: {}", id);
                    }
                }
            });

            // Register POIs and Villager-related setup
            ModVillagers.registerPOIs();
            ModVillagers.init();

            // Register spawn placements
            //noinspection deprecation
            SpawnPlacements.register(ModEntityTypes.NUMISMATIST.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);

            //noinspection deprecation
            SpawnPlacements.register(ModEntityTypes.PIGLINMERCHANT.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);

            // Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.WATER,
                    ModItems.LUCKY_COIN.get(), Potions.THICK));

            // Holy Strike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.BONE, ModPotions.HOLY_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HOLY_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HOLY_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HOLY_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HOLY_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HOLY_STRIKE_POTION_6.get()));
            // Long Holy Strike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_HOLY_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_HOLY_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_HOLY_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_HOLY_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_HOLY_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HOLY_STRIKE_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_HOLY_STRIKE_POTION_6.get()));

            // Withering Strike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.WITHER_ROSE, ModPotions.WITHERING_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.WITHERING_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.WITHERING_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.WITHERING_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.WITHERING_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.WITHERING_STRIKE_POTION_6.get()));
            // Long Withering Strike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_WITHERING_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_WITHERING_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_WITHERING_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_WITHERING_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_WITHERING_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.WITHERING_STRIKE_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_WITHERING_STRIKE_POTION_6.get()));

            // Cloak of Silence Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.ECHO_SHARD, ModPotions.SILENCE_CLOAK_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.SILENCE_CLOAK_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.SILENCE_CLOAK_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.SILENCE_CLOAK_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.SILENCE_CLOAK_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.SILENCE_CLOAK_POTION_6.get()));
            // Long Cloak of Silence Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_SILENCE_CLOAK_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_SILENCE_CLOAK_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_SILENCE_CLOAK_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_SILENCE_CLOAK_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_SILENCE_CLOAK_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SILENCE_CLOAK_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_SILENCE_CLOAK_POTION_6.get()));

            // Arthropod's Blight Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.FERMENTED_SPIDER_EYE, ModPotions.ARTHROPOD_BLIGHT_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ARTHROPOD_BLIGHT_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ARTHROPOD_BLIGHT_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ARTHROPOD_BLIGHT_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ARTHROPOD_BLIGHT_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ARTHROPOD_BLIGHT_POTION_6.get()));
            // Long Arthropod's Blight Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_ARTHROPOD_BLIGHT_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_ARTHROPOD_BLIGHT_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_ARTHROPOD_BLIGHT_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_ARTHROPOD_BLIGHT_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_ARTHROPOD_BLIGHT_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ARTHROPOD_BLIGHT_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_ARTHROPOD_BLIGHT_POTION_6.get()));

            // Healing Mist Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.GHAST_TEAR, ModPotions.HEALING_MIST_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HEALING_MIST_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HEALING_MIST_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HEALING_MIST_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HEALING_MIST_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.HEALING_MIST_POTION_6.get()));
            // Long Healing Mist Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_HEALING_MIST_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_HEALING_MIST_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_HEALING_MIST_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_HEALING_MIST_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_HEALING_MIST_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.HEALING_MIST_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_HEALING_MIST_POTION_6.get()));

            // Glowing Aura Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.GLOW_INK_SAC, ModPotions.GLOWING_AURA_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.GLOWING_AURA_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.GLOWING_AURA_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.GLOWING_AURA_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.GLOWING_AURA_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.GLOWING_AURA_POTION_6.get()));
            // Long Glowing Aura Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_GLOWING_AURA_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_GLOWING_AURA_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_GLOWING_AURA_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_GLOWING_AURA_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_GLOWING_AURA_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_AURA_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_GLOWING_AURA_POTION_6.get()));

            // Burning Strike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.FIRE_CHARGE, ModPotions.BURNING_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BURNING_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BURNING_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BURNING_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BURNING_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BURNING_STRIKE_POTION_6.get()));
            // Long Burning Strike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_BURNING_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_BURNING_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_BURNING_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_BURNING_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_BURNING_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BURNING_STRIKE_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_BURNING_STRIKE_POTION_6.get()));

            // Frost Strike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.SNOWBALL, ModPotions.FROST_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.FROST_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.FROST_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.FROST_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.FROST_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.FROST_STRIKE_POTION_6.get()));
            // Long Frost Strike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_FROST_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_FROST_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_FROST_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_FROST_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_FROST_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FROST_STRIKE_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_FROST_STRIKE_POTION_6.get()));

            // Illager Bane Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.ARROW, ModPotions.ILLAGER_BANE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ILLAGER_BANE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ILLAGER_BANE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ILLAGER_BANE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ILLAGER_BANE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.ILLAGER_BANE_POTION_6.get()));
            // Long Illager Bane Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_ILLAGER_BANE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_ILLAGER_BANE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_ILLAGER_BANE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_ILLAGER_BANE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_ILLAGER_BANE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.ILLAGER_BANE_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_ILLAGER_BANE_POTION_6.get()));

            // Blind Shroud Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.GOLDEN_CARROT, ModPotions.BLIND_SHIELD_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHIELD_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHIELD_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHIELD_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHIELD_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHIELD_POTION_6.get()));
            // Long Blind Shroud Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHIELD_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHIELD_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHIELD_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHIELD_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHIELD_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHIELD_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHIELD_POTION_6.get()));

            // Thunderstrike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.LIGHTNING_ROD, ModPotions.THUNDERSTRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THUNDERSTRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THUNDERSTRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THUNDERSTRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THUNDERSTRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THUNDERSTRIKE_POTION_6.get()));
            // Long Thunderstrike Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_THUNDERSTRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_THUNDERSTRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_THUNDERSTRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_THUNDERSTRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_THUNDERSTRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THUNDERSTRIKE_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_THUNDERSTRIKE_POTION_6.get()));

            // Thorn Shield Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Blocks.SWEET_BERRY_BUSH.asItem(), ModPotions.THORN_SHIELD_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THORN_SHIELD_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THORN_SHIELD_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THORN_SHIELD_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THORN_SHIELD_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.THORN_SHIELD_POTION_6.get()));
            // Long Thorn Shield Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_THORN_SHIELD_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_THORN_SHIELD_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_THORN_SHIELD_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_THORN_SHIELD_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_THORN_SHIELD_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.THORN_SHIELD_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_THORN_SHIELD_POTION_6.get()));

            // Venom Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                    Items.SPIDER_EYE, ModPotions.VENOM_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.VENOM_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.VENOM_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.VENOM_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.VENOM_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.VENOM_STRIKE_POTION_6.get()));
            // Long Venom Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_VENOM_STRIKE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_VENOM_STRIKE_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_VENOM_STRIKE_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_VENOM_STRIKE_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_VENOM_STRIKE_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.VENOM_STRIKE_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_VENOM_STRIKE_POTION_6.get()));

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
        public static void onClientSetup(@NotNull FMLClientSetupEvent event) {
            event.enqueueWork(() -> MenuScreens.register(ModMenuTypes.COIN_PRESS_MENU.get(), CoinPressScreen::new));
            EntityRenderers.register(ModEntityTypes.NUMISMATIST.get(), NumismatistRenderer::new);
            EntityRenderers.register(ModEntityTypes.PIGLINMERCHANT.get(), PiglinMerchantRenderer::new);
        }

        @SubscribeEvent
        public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
            CoinPressRecipeCategories.init(event);
        }
    }
}