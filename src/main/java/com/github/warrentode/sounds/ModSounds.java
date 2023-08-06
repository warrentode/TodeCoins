package com.github.warrentode.sounds;

import com.github.warrentode.TodeCoins;
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
}