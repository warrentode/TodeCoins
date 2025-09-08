package com.github.warrentode.todecoins.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TCSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> COINPRESS_USE = registerSoundEvents("coin_press_use");
    public static final RegistryObject<SoundEvent> COINPRESS_TAKE_RESULT = registerSoundEvents("coin_press_take");
    public static final RegistryObject<SoundEvent> WORK_BANKER = registerSoundEvents("work_banker");
    public static final RegistryObject<SoundEvent> WORK_LEPRECHAUN = registerSoundEvents("work_leprechaun");
    public static final RegistryObject<SoundEvent> NUMISMATIST_DEATH = registerSoundEvents("numismatist_death");
    public static final RegistryObject<SoundEvent> NUMISMATIST_DRINK_MILK = registerSoundEvents("numismatist_drink_milk");
    public static final RegistryObject<SoundEvent> NUMISMATIST_DRINK_POTION = registerSoundEvents("numismatist_drink_potion");
    public static final RegistryObject<SoundEvent> NUMISMATIST_HAGGLE = registerSoundEvents("numismatist_haggle");
    public static final RegistryObject<SoundEvent> NUMISMATIST_HURT = registerSoundEvents("numismatist_hurt");
    public static final RegistryObject<SoundEvent> NUMISMATIST_IDLE = registerSoundEvents("numismatist_idle");
    public static final RegistryObject<SoundEvent> NUMISMATIST_NO = registerSoundEvents("numismatist_no");
    public static final RegistryObject<SoundEvent> NUMISMATIST_YES = registerSoundEvents("numismatist_yes");
    public static final RegistryObject<SoundEvent> NUMISMATIST_APPEARED = registerSoundEvents("numismatist_appeared");
    public static final RegistryObject<SoundEvent> NUMISMATIST_DISAPPEARED = registerSoundEvents("numismatist_disappeared");

    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_HURT = registerSoundEvents("piglinmerchant_hurt");
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_DEATH = registerSoundEvents("piglinmerchant_death");
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_STEP = registerSoundEvents("piglinmerchant_step");
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_RETREAT = registerSoundEvents("piglinmerchant_retreat");
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_JEALOUS = registerSoundEvents("piglinmerchant_jealous");
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_AMBIENT = registerSoundEvents("piglinmerchant_ambient");
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_CELEBRATE = registerSoundEvents("piglinmerchant_celebrate");
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_ANGER = registerSoundEvents("piglinmerchant_anger");
    public static final RegistryObject<SoundEvent> PIGLINMERCHANT_EXAMINE = registerSoundEvents("piglinmerchant_examine");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.parse(MODID + ":" + name)));
    }
    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}