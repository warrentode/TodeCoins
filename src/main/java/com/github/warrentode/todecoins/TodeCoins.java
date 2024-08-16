package com.github.warrentode.todecoins;

import com.github.warrentode.todecoins.attribute.ModAttributes;
import com.github.warrentode.todecoins.block.ModBlocks;
import com.github.warrentode.todecoins.block.entity.ModBlockEntities;
import com.github.warrentode.todecoins.config.CommonConfig;
import com.github.warrentode.todecoins.config.trades.annabethsextravillagers.CarpenterTradesConfig;
import com.github.warrentode.todecoins.config.trades.annabethsextravillagers.MusicianTradesConfig;
import com.github.warrentode.todecoins.config.trades.annabethsextravillagers.PotterTradesConfig;
import com.github.warrentode.todecoins.config.trades.beautify.BotanistTradesConfig;
import com.github.warrentode.todecoins.config.trades.chefsdelight.ChefTradesConfig;
import com.github.warrentode.todecoins.config.trades.chefsdelight.CookTradesConfig;
import com.github.warrentode.todecoins.config.trades.domesticationinnovation.AnimalTamerTradesConfig;
import com.github.warrentode.todecoins.config.trades.fastfooddelight.WaiterTradesConfig;
import com.github.warrentode.todecoins.config.trades.friendsandfoes.BeekeeperTradesConfig;
import com.github.warrentode.todecoins.config.trades.kawaiidishes.BaristaTradesConfig;
import com.github.warrentode.todecoins.config.trades.minecraft.*;
import com.github.warrentode.todecoins.config.trades.morevillagers.*;
import com.github.warrentode.todecoins.config.trades.sawmill.SawmillTradesConfig;
import com.github.warrentode.todecoins.config.trades.sewingkit.TailorTradesConfig;
import com.github.warrentode.todecoins.config.trades.todecoins.BankerTradesConfig;
import com.github.warrentode.todecoins.config.trades.todecoins.LeprechaunTradesConfig;
import com.github.warrentode.todecoins.config.trades.todecoins.NumismatistTradesConfig;
import com.github.warrentode.todecoins.config.trades.todevillagers.DiscJockeyTradesConfig;
import com.github.warrentode.todecoins.config.trades.todevillagers.GlassblowerTradesConfig;
import com.github.warrentode.todecoins.config.trades.todevillagers.RetiredTraderTradesConfig;
import com.github.warrentode.todecoins.config.trades.villager_enchanter.EnchanterTradesConfig;
import com.github.warrentode.todecoins.effect.ModEffects;
import com.github.warrentode.todecoins.entity.ModEntityTypes;
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
import com.github.warrentode.todecoins.util.tags.ModTags;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurio;

@Mod(TodeCoins.MODID)
public class TodeCoins {
    public static final String MODID = "todecoins";
    public static final Logger LOGGER = LogManager.getLogger();

    public TodeCoins() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, MODID + "/common.toml");
        // annabethsextravillagers trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CarpenterTradesConfig.SPEC, MODID + "/trades/annabethsextravillagers/carpenter.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MusicianTradesConfig.SPEC, MODID + "/trades/annabethsextravillagers/musician.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PotterTradesConfig.SPEC, MODID + "/trades/annabethsextravillagers/potter.toml");
        // beautify trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BotanistTradesConfig.SPEC, MODID + "/trades/beautify/botanist.toml");
        // chefsdelight trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ChefTradesConfig.SPEC, MODID + "/trades/chefsdelight/delightchef.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CookTradesConfig.SPEC, MODID + "/trades/chefsdelight/delightcook.toml");
        // domesticationinnovation trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AnimalTamerTradesConfig.SPEC, MODID + "/trades/domesticationinnovation/animal_tamer.toml");
        // fastfooddelight trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WaiterTradesConfig.SPEC, MODID + "/trades/fastfooddelight/waiter.toml");
        // friendsandfoes trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BeekeeperTradesConfig.SPEC, MODID + "/trades/friendsandfoes/beekeeper.toml");
        // kawaiidishes trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BaristaTradesConfig.SPEC, MODID + "/trades/kawaiidishes/barista.toml");
        // minecraft trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ArmorerTradesConfig.SPEC, MODID + "/trades/minecraft/armorer.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ButcherTradesConfig.SPEC, MODID + "/trades/minecraft/butcher.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CartographerTradesConfig.SPEC, MODID + "/trades/minecraft/cartographer.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ClericTradesConfig.SPEC, MODID + "/trades/minecraft/cleric.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FarmerTradesConfig.SPEC, MODID + "/trades/minecraft/farmer.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FishermanTradesConfig.SPEC, MODID + "/trades/minecraft/fisherman.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FletcherTradesConfig.SPEC, MODID + "/trades/minecraft/fletcher.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, LeatherworkerTradesConfig.SPEC, MODID + "/trades/minecraft/leatherworker.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, LibrarianTradesConfig.SPEC, MODID + "/trades/minecraft/librarian.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MasonTradesConfig.SPEC, MODID + "/trades/minecraft/mason.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ShepherdTradesConfig.SPEC, MODID + "/trades/minecraft/shepherd.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ToolsmithTradesConfig.SPEC, MODID + "/trades/minecraft/toolsmith.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WanderingTraderTradesConfig.SPEC, MODID + "/trades/minecraft/wandering_trader.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WeaponsmithTradesConfig.SPEC, MODID + "/trades/minecraft/weaponsmith.toml");
        // morevillagers trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, EnderianTradesConfig.SPEC, MODID + "/trades/morevillagers/enderian.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, EngineerTradesConfig.SPEC, MODID + "/trades/morevillagers/engineer.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FloristTradesConfig.SPEC, MODID + "/trades/morevillagers/florist.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, HunterTradesConfig.SPEC, MODID + "/trades/morevillagers/hunter.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NetherianTradesConfig.SPEC, MODID + "/trades/morevillagers/netherian.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OceanographerTradesConfig.SPEC, MODID + "/trades/morevillagers/oceanographer.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WoodworkerTradesConfig.SPEC, MODID + "/trades/morevillagers/woodworker.toml");
        // sawmill trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SawmillTradesConfig.SPEC, MODID + "/trades/sawmill/carpenter.toml");
        // sewingkit trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TailorTradesConfig.SPEC, MODID + "/trades/sewingkit/tailor.toml");
        // todecoins trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BankerTradesConfig.SPEC, MODID + "/trades/todecoins/banker.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, LeprechaunTradesConfig.SPEC, MODID + "/trades/todecoins/leprechaun.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NumismatistTradesConfig.SPEC, MODID + "/trades/todecoins/numismatist.toml");
        // todevillagers trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RetiredTraderTradesConfig.SPEC, MODID + "/trades/todevillagers/retired_trader.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GlassblowerTradesConfig.SPEC, MODID + "/trades/todevillagers/glassblower.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DiscJockeyTradesConfig.SPEC, MODID + "/trades/todevillagers/disc_jockey.toml");
        // villager_enchanter trade config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, EnchanterTradesConfig.SPEC, MODID + "/trades/villager_enchanter/enchanter.toml");

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::onIMEnqueueEvent);
        modEventBus.addListener(this::commonSetup);

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
        if (stack.is(ModTags.Items.WALLETS)) {
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
        event.enqueueWork(ModVillagers::registerPOIs);
        event.enqueueWork(ModVillagers::init);
        event.enqueueWork(() -> {
            //noinspection deprecation
            SpawnPlacements.register(ModEntityTypes.NUMISMATIST.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        });
        event.enqueueWork(() -> {
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
                    Items.GOLDEN_CARROT, ModPotions.BLIND_SHROUD_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHROUD_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION_2.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHROUD_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION_3.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHROUD_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION_4.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHROUD_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION_5.get(),
                    Items.GLOWSTONE_DUST, ModPotions.BLIND_SHROUD_POTION_6.get()));
            // Long Blind Shroud Potions
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHROUD_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION_2.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHROUD_POTION_2.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION_3.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHROUD_POTION_3.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION_4.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHROUD_POTION_4.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION_5.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHROUD_POTION_5.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLIND_SHROUD_POTION_6.get(),
                    Items.REDSTONE, ModPotions.LONG_BLIND_SHROUD_POTION_6.get()));

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
        }

        @SubscribeEvent
        public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
            CoinPressRecipeCategories.init(event);
        }
    }
}