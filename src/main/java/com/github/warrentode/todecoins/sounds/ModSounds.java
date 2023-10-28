package com.github.warrentode.todecoins.sounds;

import com.github.warrentode.todecoins.TodeCoins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TodeCoins.MODID);

    public static final RegistryObject<SoundEvent> COINPRESS_USE = SOUNDS.register("coin_press_use",
            () -> new SoundEvent(new ResourceLocation("todecoins", "coin_press_use")));
    public static final RegistryObject<SoundEvent> COINPRESS_TAKE_RESULT = SOUNDS.register("coin_press_take",
            () -> new SoundEvent(new ResourceLocation("todecoins", "coin_press_take")));
    public static final RegistryObject<SoundEvent> WORK_BANKER = SOUNDS.register("work_banker",
            () -> new SoundEvent(new ResourceLocation("todecoins", "work_banker")));
    public static final RegistryObject<SoundEvent> WORK_LEPRECHAUN = SOUNDS.register("work_leprechaun",
            () -> new SoundEvent(new ResourceLocation("todecoins", "work_leprechaun")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_DEATH = SOUNDS.register("numismatist_death",
            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_death")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_DRINK_MILK = SOUNDS.register("numismatist_drink_milk",
            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_drink_milk")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_DRINK_POTION = SOUNDS.register("numismatist_drink_potion",
            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_drink_potion")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_HAGGLE = SOUNDS.register("numismatist_haggle",

            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_haggle")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_HURT = SOUNDS.register("numismatist_hurt",
            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_hurt")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_IDLE = SOUNDS.register("numismatist_idle",
            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_idle")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_NO = SOUNDS.register("numismatist_no",
            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_no")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_YES = SOUNDS.register("numismatist_yes",
            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_yes")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_APPEARED = SOUNDS.register("numismatist_appeared",
            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_appeared")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_DISAPPEARED = SOUNDS.register("numismatist_disappeared",
            () -> new SoundEvent(new ResourceLocation("todecoins", "numismatist_disappeared")));
}