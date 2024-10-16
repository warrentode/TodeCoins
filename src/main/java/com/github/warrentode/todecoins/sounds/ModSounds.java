package com.github.warrentode.todecoins.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> COINPRESS_USE = SOUNDS.register("coin_press_use",
            () -> new SoundEvent(new ResourceLocation(MODID, "coin_press_use")));
    public static final RegistryObject<SoundEvent> COINPRESS_TAKE_RESULT = SOUNDS.register("coin_press_take",
            () -> new SoundEvent(new ResourceLocation(MODID, "coin_press_take")));
    public static final RegistryObject<SoundEvent> WORK_BANKER = SOUNDS.register("work_banker",
            () -> new SoundEvent(new ResourceLocation(MODID, "work_banker")));
    public static final RegistryObject<SoundEvent> WORK_LEPRECHAUN = SOUNDS.register("work_leprechaun",
            () -> new SoundEvent(new ResourceLocation(MODID, "work_leprechaun")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_DEATH = SOUNDS.register("numismatist_death",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_death")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_DRINK_MILK = SOUNDS.register("numismatist_drink_milk",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_drink_milk")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_DRINK_POTION = SOUNDS.register("numismatist_drink_potion",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_drink_potion")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_HAGGLE = SOUNDS.register("numismatist_haggle",

            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_haggle")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_HURT = SOUNDS.register("numismatist_hurt",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_hurt")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_IDLE = SOUNDS.register("numismatist_idle",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_idle")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_NO = SOUNDS.register("numismatist_no",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_no")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_YES = SOUNDS.register("numismatist_yes",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_yes")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_APPEARED = SOUNDS.register("numismatist_appeared",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_appeared")));
    public static final RegistryObject<SoundEvent> NUMISMATIST_DISAPPEARED = SOUNDS.register("numismatist_disappeared",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_disappeared")));

    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_HURT = SOUNDS.register("piglinmerchant_hurt",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_hurt")));
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_DEATH = SOUNDS.register("piglinmerchant_death",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_death")));
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_STEP = SOUNDS.register("piglinmerchant_step",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_step")));
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_RETREAT = SOUNDS.register("piglinmerchant_retreat",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_retreat")));
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_JEALOUS = SOUNDS.register("piglinmerchant_jealous",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_jealous")));
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_AMBIENT = SOUNDS.register("piglinmerchant_ambient",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_ambient")));
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_CELEBRATE = SOUNDS.register("piglinmerchant_celebrate",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_celebrate")));
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_ANGER = SOUNDS.register("piglinmerchant_anger",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_anger")));
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_EXAMINE = SOUNDS.register("piglinmerchant_examine",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_examine")));
}