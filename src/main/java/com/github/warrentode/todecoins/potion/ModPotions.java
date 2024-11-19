package com.github.warrentode.todecoins.potion;

import com.github.warrentode.todecoins.TodeCoins;
import com.github.warrentode.todecoins.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, TodeCoins.MODID);

    public static final RegistryObject<Potion> HOLY_STRIKE_POTION = POTIONS.register("holy_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 6000, 0)));
    public static final RegistryObject<Potion> HOLY_STRIKE_POTION_2 = POTIONS.register("holy_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 6000, 1)));
    public static final RegistryObject<Potion> HOLY_STRIKE_POTION_3 = POTIONS.register("holy_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 6000, 2)));
    public static final RegistryObject<Potion> HOLY_STRIKE_POTION_4 = POTIONS.register("holy_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 6000, 3)));
    public static final RegistryObject<Potion> HOLY_STRIKE_POTION_5 = POTIONS.register("holy_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 6000, 4)));
    public static final RegistryObject<Potion> HOLY_STRIKE_POTION_6 = POTIONS.register("holy_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_HOLY_STRIKE_POTION = POTIONS.register("long_holy_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_HOLY_STRIKE_POTION_2 = POTIONS.register("long_holy_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_HOLY_STRIKE_POTION_3 = POTIONS.register("long_holy_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_HOLY_STRIKE_POTION_4 = POTIONS.register("long_holy_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_HOLY_STRIKE_POTION_5 = POTIONS.register("long_holy_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_HOLY_STRIKE_POTION_6 = POTIONS.register("long_holy_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.HOLY_STRIKE.get(), 9600, 5)));

    public static final RegistryObject<Potion> WITHERING_STRIKE_POTION = POTIONS.register("withering_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 6000, 0)));
    public static final RegistryObject<Potion> WITHERING_STRIKE_POTION_2 = POTIONS.register("withering_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 6000, 1)));
    public static final RegistryObject<Potion> WITHERING_STRIKE_POTION_3 = POTIONS.register("withering_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 6000, 2)));
    public static final RegistryObject<Potion> WITHERING_STRIKE_POTION_4 = POTIONS.register("withering_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 6000, 3)));
    public static final RegistryObject<Potion> WITHERING_STRIKE_POTION_5 = POTIONS.register("withering_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 6000, 4)));
    public static final RegistryObject<Potion> WITHERING_STRIKE_POTION_6 = POTIONS.register("withering_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_WITHERING_STRIKE_POTION = POTIONS.register("long_withering_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_WITHERING_STRIKE_POTION_2 = POTIONS.register("long_withering_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_WITHERING_STRIKE_POTION_3 = POTIONS.register("long_withering_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_WITHERING_STRIKE_POTION_4 = POTIONS.register("long_withering_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_WITHERING_STRIKE_POTION_5 = POTIONS.register("long_withering_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_WITHERING_STRIKE_POTION_6 = POTIONS.register("long_withering_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.WITHERING_STRIKE.get(), 9600, 5)));

    public static final RegistryObject<Potion> SILENCE_CLOAK_POTION = POTIONS.register("silence_cloak_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 6000, 0)));
    public static final RegistryObject<Potion> SILENCE_CLOAK_POTION_2 = POTIONS.register("silence_cloak_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 6000, 1)));
    public static final RegistryObject<Potion> SILENCE_CLOAK_POTION_3 = POTIONS.register("silence_cloak_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 6000, 2)));
    public static final RegistryObject<Potion> SILENCE_CLOAK_POTION_4 = POTIONS.register("silence_cloak_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 6000, 3)));
    public static final RegistryObject<Potion> SILENCE_CLOAK_POTION_5 = POTIONS.register("silence_cloak_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 6000, 4)));
    public static final RegistryObject<Potion> SILENCE_CLOAK_POTION_6 = POTIONS.register("silence_cloak_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_SILENCE_CLOAK_POTION = POTIONS.register("long_silence_cloak_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_SILENCE_CLOAK_POTION_2 = POTIONS.register("long_silence_cloak_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_SILENCE_CLOAK_POTION_3 = POTIONS.register("long_silence_cloak_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_SILENCE_CLOAK_POTION_4 = POTIONS.register("long_silence_cloak_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_SILENCE_CLOAK_POTION_5 = POTIONS.register("long_silence_cloak_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_SILENCE_CLOAK_POTION_6 = POTIONS.register("long_silence_cloak_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.SILENCE_CLOAK.get(), 9600, 5)));

    public static final RegistryObject<Potion> ARTHROPOD_BLIGHT_POTION = POTIONS.register("arthropod_blight_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 6000, 0)));
    public static final RegistryObject<Potion> ARTHROPOD_BLIGHT_POTION_2 = POTIONS.register("arthropod_blight_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 6000, 1)));
    public static final RegistryObject<Potion> ARTHROPOD_BLIGHT_POTION_3 = POTIONS.register("arthropod_blight_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 6000, 2)));
    public static final RegistryObject<Potion> ARTHROPOD_BLIGHT_POTION_4 = POTIONS.register("arthropod_blight_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 6000, 3)));
    public static final RegistryObject<Potion> ARTHROPOD_BLIGHT_POTION_5 = POTIONS.register("arthropod_blight_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 6000, 4)));
    public static final RegistryObject<Potion> ARTHROPOD_BLIGHT_POTION_6 = POTIONS.register("arthropod_blight_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_ARTHROPOD_BLIGHT_POTION = POTIONS.register("long_arthropod_blight_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_ARTHROPOD_BLIGHT_POTION_2 = POTIONS.register("long_arthropod_blight_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_ARTHROPOD_BLIGHT_POTION_3 = POTIONS.register("long_arthropod_blight_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_ARTHROPOD_BLIGHT_POTION_4 = POTIONS.register("long_arthropod_blight_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_ARTHROPOD_BLIGHT_POTION_5 = POTIONS.register("long_arthropod_blight_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_ARTHROPOD_BLIGHT_POTION_6 = POTIONS.register("long_arthropod_blight_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.ARTHROPOD_BLIGHT.get(), 9600, 5)));

    public static final RegistryObject<Potion> HEALING_MIST_POTION = POTIONS.register("healing_mist_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 6000, 0)));
    public static final RegistryObject<Potion> HEALING_MIST_POTION_2 = POTIONS.register("healing_mist_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 6000, 1)));
    public static final RegistryObject<Potion> HEALING_MIST_POTION_3 = POTIONS.register("healing_mist_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 6000, 2)));
    public static final RegistryObject<Potion> HEALING_MIST_POTION_4 = POTIONS.register("healing_mist_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 6000, 3)));
    public static final RegistryObject<Potion> HEALING_MIST_POTION_5 = POTIONS.register("healing_mist_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 6000, 4)));
    public static final RegistryObject<Potion> HEALING_MIST_POTION_6 = POTIONS.register("healing_mist_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_HEALING_MIST_POTION = POTIONS.register("long_healing_mist_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_HEALING_MIST_POTION_2 = POTIONS.register("long_healing_mist_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_HEALING_MIST_POTION_3 = POTIONS.register("long_healing_mist_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_HEALING_MIST_POTION_4 = POTIONS.register("long_healing_mist_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_HEALING_MIST_POTION_5 = POTIONS.register("long_healing_mist_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_HEALING_MIST_POTION_6 = POTIONS.register("long_healing_mist_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.HEALING_MIST.get(), 9600, 5)));

    public static final RegistryObject<Potion> GLOWING_AURA_POTION = POTIONS.register("glowing_aura_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 6000, 0)));
    public static final RegistryObject<Potion> GLOWING_AURA_POTION_2 = POTIONS.register("glowing_aura_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 6000, 1)));
    public static final RegistryObject<Potion> GLOWING_AURA_POTION_3 = POTIONS.register("glowing_aura_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 6000, 2)));
    public static final RegistryObject<Potion> GLOWING_AURA_POTION_4 = POTIONS.register("glowing_aura_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 6000, 3)));
    public static final RegistryObject<Potion> GLOWING_AURA_POTION_5 = POTIONS.register("glowing_aura_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 6000, 4)));
    public static final RegistryObject<Potion> GLOWING_AURA_POTION_6 = POTIONS.register("glowing_aura_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_GLOWING_AURA_POTION = POTIONS.register("long_glowing_aura_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_GLOWING_AURA_POTION_2 = POTIONS.register("long_glowing_aura_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_GLOWING_AURA_POTION_3 = POTIONS.register("long_glowing_aura_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_GLOWING_AURA_POTION_4 = POTIONS.register("long_glowing_aura_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_GLOWING_AURA_POTION_5 = POTIONS.register("long_glowing_aura_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_GLOWING_AURA_POTION_6 = POTIONS.register("long_glowing_aura_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.GLOWING_AURA.get(), 9600, 5)));

    public static final RegistryObject<Potion> BURNING_STRIKE_POTION = POTIONS.register("burning_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 6000, 0)));
    public static final RegistryObject<Potion> BURNING_STRIKE_POTION_2 = POTIONS.register("burning_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 6000, 1)));
    public static final RegistryObject<Potion> BURNING_STRIKE_POTION_3 = POTIONS.register("burning_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 6000, 2)));
    public static final RegistryObject<Potion> BURNING_STRIKE_POTION_4 = POTIONS.register("burning_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 6000, 3)));
    public static final RegistryObject<Potion> BURNING_STRIKE_POTION_5 = POTIONS.register("burning_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 6000, 4)));
    public static final RegistryObject<Potion> BURNING_STRIKE_POTION_6 = POTIONS.register("burning_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_BURNING_STRIKE_POTION = POTIONS.register("long_burning_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_BURNING_STRIKE_POTION_2 = POTIONS.register("long_burning_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_BURNING_STRIKE_POTION_3 = POTIONS.register("long_burning_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_BURNING_STRIKE_POTION_4 = POTIONS.register("long_burning_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_BURNING_STRIKE_POTION_5 = POTIONS.register("long_burning_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_BURNING_STRIKE_POTION_6 = POTIONS.register("long_burning_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.BURNING_STRIKE.get(), 9600, 5)));

    public static final RegistryObject<Potion> FROST_STRIKE_POTION = POTIONS.register("frost_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 6000, 0)));
    public static final RegistryObject<Potion> FROST_STRIKE_POTION_2 = POTIONS.register("frost_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 6000, 1)));
    public static final RegistryObject<Potion> FROST_STRIKE_POTION_3 = POTIONS.register("frost_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 6000, 2)));
    public static final RegistryObject<Potion> FROST_STRIKE_POTION_4 = POTIONS.register("frost_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 6000, 3)));
    public static final RegistryObject<Potion> FROST_STRIKE_POTION_5 = POTIONS.register("frost_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 6000, 4)));
    public static final RegistryObject<Potion> FROST_STRIKE_POTION_6 = POTIONS.register("frost_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_FROST_STRIKE_POTION = POTIONS.register("long_frost_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_FROST_STRIKE_POTION_2 = POTIONS.register("long_frost_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_FROST_STRIKE_POTION_3 = POTIONS.register("long_frost_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_FROST_STRIKE_POTION_4 = POTIONS.register("long_frost_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_FROST_STRIKE_POTION_5 = POTIONS.register("long_frost_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_FROST_STRIKE_POTION_6 = POTIONS.register("long_frost_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.FROST_STRIKE.get(), 9600, 5)));

    public static final RegistryObject<Potion> ILLAGER_BANE_POTION = POTIONS.register("illager_bane_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 6000, 0)));
    public static final RegistryObject<Potion> ILLAGER_BANE_POTION_2 = POTIONS.register("illager_bane_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 6000, 1)));
    public static final RegistryObject<Potion> ILLAGER_BANE_POTION_3 = POTIONS.register("illager_bane_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 6000, 2)));
    public static final RegistryObject<Potion> ILLAGER_BANE_POTION_4 = POTIONS.register("illager_bane_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 6000, 3)));
    public static final RegistryObject<Potion> ILLAGER_BANE_POTION_5 = POTIONS.register("illager_bane_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 6000, 4)));
    public static final RegistryObject<Potion> ILLAGER_BANE_POTION_6 = POTIONS.register("illager_bane_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_ILLAGER_BANE_POTION = POTIONS.register("long_illager_bane_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_ILLAGER_BANE_POTION_2 = POTIONS.register("long_illager_bane_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_ILLAGER_BANE_POTION_3 = POTIONS.register("long_illager_bane_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_ILLAGER_BANE_POTION_4 = POTIONS.register("long_illager_bane_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_ILLAGER_BANE_POTION_5 = POTIONS.register("long_illager_bane_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_ILLAGER_BANE_POTION_6 = POTIONS.register("long_illager_bane_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.ILLAGER_BANE.get(), 9600, 5)));

    public static final RegistryObject<Potion> BLIND_SHIELD_POTION = POTIONS.register("blind_shield_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 6000, 0)));
    public static final RegistryObject<Potion> BLIND_SHIELD_POTION_2 = POTIONS.register("blind_shield_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 6000, 1)));
    public static final RegistryObject<Potion> BLIND_SHIELD_POTION_3 = POTIONS.register("blind_shield_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 6000, 2)));
    public static final RegistryObject<Potion> BLIND_SHIELD_POTION_4 = POTIONS.register("blind_shield_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 6000, 3)));
    public static final RegistryObject<Potion> BLIND_SHIELD_POTION_5 = POTIONS.register("blind_shield_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 6000, 4)));
    public static final RegistryObject<Potion> BLIND_SHIELD_POTION_6 = POTIONS.register("blind_shield_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_BLIND_SHIELD_POTION = POTIONS.register("long_blind_shield_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_BLIND_SHIELD_POTION_2 = POTIONS.register("long_blind_shield_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_BLIND_SHIELD_POTION_3 = POTIONS.register("long_blind_shield_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_BLIND_SHIELD_POTION_4 = POTIONS.register("long_blind_shield_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_BLIND_SHIELD_POTION_5 = POTIONS.register("long_blind_shield_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_BLIND_SHIELD_POTION_6 = POTIONS.register("long_blind_shield_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.BLIND_SHIELD.get(), 9600, 5)));

    public static final RegistryObject<Potion> THUNDERSTRIKE_POTION = POTIONS.register("thunderstrike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 6000, 0)));
    public static final RegistryObject<Potion> THUNDERSTRIKE_POTION_2 = POTIONS.register("thunderstrike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 6000, 1)));
    public static final RegistryObject<Potion> THUNDERSTRIKE_POTION_3 = POTIONS.register("thunderstrike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 6000, 2)));
    public static final RegistryObject<Potion> THUNDERSTRIKE_POTION_4 = POTIONS.register("thunderstrike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 6000, 3)));
    public static final RegistryObject<Potion> THUNDERSTRIKE_POTION_5 = POTIONS.register("thunderstrike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 6000, 4)));
    public static final RegistryObject<Potion> THUNDERSTRIKE_POTION_6 = POTIONS.register("thunderstrike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_THUNDERSTRIKE_POTION = POTIONS.register("long_thunderstrike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_THUNDERSTRIKE_POTION_2 = POTIONS.register("long_thunderstrike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_THUNDERSTRIKE_POTION_3 = POTIONS.register("long_thunderstrike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_THUNDERSTRIKE_POTION_4 = POTIONS.register("long_thunderstrike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_THUNDERSTRIKE_POTION_5 = POTIONS.register("long_thunderstrike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_THUNDERSTRIKE_POTION_6 = POTIONS.register("long_thunderstrike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.THUNDERSTRIKE.get(), 9600, 5)));

    public static final RegistryObject<Potion> THORN_SHIELD_POTION = POTIONS.register("thorn_shield_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 6000, 0)));
    public static final RegistryObject<Potion> THORN_SHIELD_POTION_2 = POTIONS.register("thorn_shield_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 6000, 1)));
    public static final RegistryObject<Potion> THORN_SHIELD_POTION_3 = POTIONS.register("thorn_shield_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 6000, 2)));
    public static final RegistryObject<Potion> THORN_SHIELD_POTION_4 = POTIONS.register("thorn_shield_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 6000, 3)));
    public static final RegistryObject<Potion> THORN_SHIELD_POTION_5 = POTIONS.register("thorn_shield_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 6000, 4)));
    public static final RegistryObject<Potion> THORN_SHIELD_POTION_6 = POTIONS.register("thorn_shield_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_THORN_SHIELD_POTION = POTIONS.register("long_thorn_shield_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_THORN_SHIELD_POTION_2 = POTIONS.register("long_thorn_shield_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_THORN_SHIELD_POTION_3 = POTIONS.register("long_thorn_shield_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_THORN_SHIELD_POTION_4 = POTIONS.register("long_thorn_shield_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_THORN_SHIELD_POTION_5 = POTIONS.register("long_thorn_shield_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_THORN_SHIELD_POTION_6 = POTIONS.register("long_thorn_shield_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.THORN_SHIELD.get(), 9600, 5)));

    public static final RegistryObject<Potion> VENOM_STRIKE_POTION = POTIONS.register("venom_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 6000, 0)));
    public static final RegistryObject<Potion> VENOM_STRIKE_POTION_2 = POTIONS.register("venom_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 6000, 1)));
    public static final RegistryObject<Potion> VENOM_STRIKE_POTION_3 = POTIONS.register("venom_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 6000, 2)));
    public static final RegistryObject<Potion> VENOM_STRIKE_POTION_4 = POTIONS.register("venom_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 6000, 3)));
    public static final RegistryObject<Potion> VENOM_STRIKE_POTION_5 = POTIONS.register("venom_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 6000, 4)));
    public static final RegistryObject<Potion> VENOM_STRIKE_POTION_6 = POTIONS.register("venom_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 6000, 5)));

    public static final RegistryObject<Potion> LONG_VENOM_STRIKE_POTION = POTIONS.register("long_venom_strike_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 9600, 0)));
    public static final RegistryObject<Potion> LONG_VENOM_STRIKE_POTION_2 = POTIONS.register("long_venom_strike_potion_2",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 9600, 1)));
    public static final RegistryObject<Potion> LONG_VENOM_STRIKE_POTION_3 = POTIONS.register("long_venom_strike_potion_3",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 9600, 2)));
    public static final RegistryObject<Potion> LONG_VENOM_STRIKE_POTION_4 = POTIONS.register("long_venom_strike_potion_4",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 9600, 3)));
    public static final RegistryObject<Potion> LONG_VENOM_STRIKE_POTION_5 = POTIONS.register("long_venom_strike_potion_5",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 9600, 4)));
    public static final RegistryObject<Potion> LONG_VENOM_STRIKE_POTION_6 = POTIONS.register("long_venom_strike_potion_6",
            () -> new Potion(new MobEffectInstance(ModEffects.VENOM_STRIKE.get(), 9600, 5)));

    public static final RegistryObject<Potion> LUCK_POTION_2 = POTIONS.register("luck_potion_2",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 6000, 1)));
    public static final RegistryObject<Potion> LUCK_POTION_3 = POTIONS.register("luck_potion_3",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 6000, 2)));
    public static final RegistryObject<Potion> LUCK_POTION_4 = POTIONS.register("luck_potion_4",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 6000, 3)));
    public static final RegistryObject<Potion> LUCK_POTION_5 = POTIONS.register("luck_potion_5",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 6000, 4)));
    public static final RegistryObject<Potion> LUCK_POTION_6 = POTIONS.register("luck_potion_6",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 6000, 5)));

    public static final RegistryObject<Potion> LONG_LUCK_POTION = POTIONS.register("long_luck_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 9600, 0)));
    public static final RegistryObject<Potion> LONG_LUCK_POTION_2 = POTIONS.register("long_luck_potion_2",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 9600, 1)));
    public static final RegistryObject<Potion> LONG_LUCK_POTION_3 = POTIONS.register("long_luck_potion_3",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 9600, 2)));
    public static final RegistryObject<Potion> LONG_LUCK_POTION_4 = POTIONS.register("long_luck_potion_4",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 9600, 3)));
    public static final RegistryObject<Potion> LONG_LUCK_POTION_5 = POTIONS.register("long_luck_potion_5",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 9600, 4)));
    public static final RegistryObject<Potion> LONG_LUCK_POTION_6 = POTIONS.register("long_luck_potion_6",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 9600, 5)));

    public static final RegistryObject<Potion> UNLUCK_POTION = POTIONS.register("unluck_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 6000, 0)));
    public static final RegistryObject<Potion> UNLUCK_POTION_2 = POTIONS.register("unluck_potion_2",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 6000, 1)));
    public static final RegistryObject<Potion> UNLUCK_POTION_3 = POTIONS.register("unluck_potion_3",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 6000, 2)));
    public static final RegistryObject<Potion> UNLUCK_POTION_4 = POTIONS.register("unluck_potion_4",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 6000, 3)));
    public static final RegistryObject<Potion> UNLUCK_POTION_5 = POTIONS.register("unluck_potion_5",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 6000, 4)));
    public static final RegistryObject<Potion> UNLUCK_POTION_6 = POTIONS.register("unluck_potion_6",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 6000, 5)));

    public static final RegistryObject<Potion> LONG_UNLUCK_POTION = POTIONS.register("long_unluck_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 9600, 0)));
    public static final RegistryObject<Potion> LONG_UNLUCK_POTION_2 = POTIONS.register("long_unluck_potion_2",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 9600, 1)));
    public static final RegistryObject<Potion> LONG_UNLUCK_POTION_3 = POTIONS.register("long_unluck_potion_3",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 9600, 2)));
    public static final RegistryObject<Potion> LONG_UNLUCK_POTION_4 = POTIONS.register("long_unluck_potion_4",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 9600, 3)));
    public static final RegistryObject<Potion> LONG_UNLUCK_POTION_5 = POTIONS.register("long_unluck_potion_5",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 9600, 4)));
    public static final RegistryObject<Potion> LONG_UNLUCK_POTION_6 = POTIONS.register("long_unluck_potion_6",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 9600, 5)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}