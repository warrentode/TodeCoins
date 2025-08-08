package com.github.warrentode.todecoins.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> COINPRESS_USE = SOUNDS.register("coin_press_use",
            () -> new SoundEvent(new ResourceLocation(MODID, "coin_press_use")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> COINPRESS_TAKE_RESULT = SOUNDS.register("coin_press_take",
            () -> new SoundEvent(new ResourceLocation(MODID, "coin_press_take")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> WORK_BANKER = SOUNDS.register("work_banker",
            () -> new SoundEvent(new ResourceLocation(MODID, "work_banker")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> WORK_LEPRECHAUN = SOUNDS.register("work_leprechaun",
            () -> new SoundEvent(new ResourceLocation(MODID, "work_leprechaun")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_DEATH = SOUNDS.register("numismatist_death",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_death")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_DRINK_MILK = SOUNDS.register("numismatist_drink_milk",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_drink_milk")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_DRINK_POTION = SOUNDS.register("numismatist_drink_potion",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_drink_potion")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_HAGGLE = SOUNDS.register("numismatist_haggle",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_haggle")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_HURT = SOUNDS.register("numismatist_hurt",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_hurt")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_IDLE = SOUNDS.register("numismatist_idle",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_idle")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_NO = SOUNDS.register("numismatist_no",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_no")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_YES = SOUNDS.register("numismatist_yes",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_yes")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_APPEARED = SOUNDS.register("numismatist_appeared",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_appeared")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> NUMISMATIST_DISAPPEARED = SOUNDS.register("numismatist_disappeared",
            () -> new SoundEvent(new ResourceLocation(MODID, "numismatist_disappeared")));

    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_HURT = SOUNDS.register("piglinmerchant_hurt",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_hurt")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_DEATH = SOUNDS.register("piglinmerchant_death",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_death")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_STEP = SOUNDS.register("piglinmerchant_step",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_step")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_RETREAT = SOUNDS.register("piglinmerchant_retreat",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_retreat")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_JEALOUS = SOUNDS.register("piglinmerchant_jealous",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_jealous")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_AMBIENT = SOUNDS.register("piglinmerchant_ambient",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_ambient")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_CELEBRATE = SOUNDS.register("piglinmerchant_celebrate",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_celebrate")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_ANGER = SOUNDS.register("piglinmerchant_anger",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_anger")));
    @SuppressWarnings("removal")
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_EXAMINE = SOUNDS.register("piglinmerchant_examine",
            () -> new SoundEvent(new ResourceLocation(MODID, "piglinmerchant_examine")));
}