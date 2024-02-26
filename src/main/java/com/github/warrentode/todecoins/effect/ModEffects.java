package com.github.warrentode.todecoins.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MODID);

    public static final RegistryObject<MobEffect> VENOM_STRIKE = MOB_EFFECTS.register("venom_strike",
            () -> new VenomEffect(MobEffectCategory.BENEFICIAL, 0x507550));

    public static final RegistryObject<MobEffect> ILLAGER_BANE = MOB_EFFECTS.register("illager_bane",
            () -> new IllagerBaneEffect(MobEffectCategory.BENEFICIAL, 0x696969));

    public static final RegistryObject<MobEffect> THORN_SHIELD = MOB_EFFECTS.register("thorn_shield",
            () -> new ThornShieldEffect(MobEffectCategory.BENEFICIAL, 0xB8860B));

    public static final RegistryObject<MobEffect> THUNDERSTRIKE = MOB_EFFECTS.register("thunderstrike",
            () -> new ThunderstrikeEffect(MobEffectCategory.BENEFICIAL, 0xB0C4DE));

    public static final RegistryObject<MobEffect> BLIND_SHIELD = MOB_EFFECTS.register("blind_shield",
            () -> new BlindShroudEffect(MobEffectCategory.BENEFICIAL, 0x708090));

    public static final RegistryObject<MobEffect> FROST_STRIKE = MOB_EFFECTS.register("frost_strike",
            () -> new FrostStrikeEffect(MobEffectCategory.BENEFICIAL, 0xE0FFFF));

    public static final RegistryObject<MobEffect> BURNING_STRIKE = MOB_EFFECTS.register("burning_strike",
            () -> new BurningStrikeEffect(MobEffectCategory.BENEFICIAL, 0xFF4500));

    public static final RegistryObject<MobEffect> GLOWING_AURA = MOB_EFFECTS.register("glowing_aura",
            () -> new GlowingAuraEffect(MobEffectCategory.NEUTRAL, 0xFAFAD2));

    public static final RegistryObject<MobEffect> HEALING_MIST = MOB_EFFECTS.register("healing_mist",
            () -> new HealingMistEffect(MobEffectCategory.BENEFICIAL, 0xFF69B4));

    public static final RegistryObject<MobEffect> ARTHROPOD_BLIGHT = MOB_EFFECTS.register("arthropod_blight",
            () -> new ArthropodBlightEffect(MobEffectCategory.BENEFICIAL, 0x800000));

    public static final RegistryObject<MobEffect> SILENCE_CLOAK = MOB_EFFECTS.register("silence_cloak",
            () -> new SilenceCloakEffect(MobEffectCategory.BENEFICIAL, 0x87CEEB));

    public static final RegistryObject<MobEffect> WITHERING_STRIKE = MOB_EFFECTS.register("withering_strike",
            () -> new WitheringStrikeEffect(MobEffectCategory.BENEFICIAL, 0x000000));

    public static final RegistryObject<MobEffect> HOLY_STRIKE = MOB_EFFECTS.register("holy_strike",
            () -> new HolyStrikeEffect(MobEffectCategory.BENEFICIAL, 0xFFF8DC));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}