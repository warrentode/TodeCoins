package com.github.warrentode.todecoins.effect;

import com.github.warrentode.todecoins.effect.custom.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class TCMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MODID);

    public static final RegistryObject<MobEffect> GUST_STRIKE = registerEffect("gust_strike",
            // Cyan (#00FFFF)
            () -> new GustStrikeEffect(MobEffectCategory.BENEFICIAL, 0x00FFFF)
                    .addAttributeModifier(Attributes.ATTACK_KNOCKBACK,
                            "08db5946-fe31-42e0-964a-d415493a323f",
                            1.0D, AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<MobEffect> TELEPORTATION_SICKNESS = registerEffect("teleportation_sickness",
            // Indigo (#4B0082)
            () -> new TeleportationSicknessEffect(MobEffectCategory.NEUTRAL, 0x4B0082));

    public static final RegistryObject<MobEffect> POLLINATING_STEP = registerEffect("pollinating_step",
            // Honey Gold (#FFD600)
            () -> new PollinatingStepEffect(MobEffectCategory.BENEFICIAL, 0xFFD600));

    public static final RegistryObject<MobEffect> FISHERMANS_BLESSING = registerEffect("fishermans_blessing",
            // Medium Aqua Marine (#66CDAA)
            () -> new FishermansBlessingEffect(MobEffectCategory.BENEFICIAL, 0x66CDAA)
                    .addAttributeModifier(Attributes.LUCK,
                            "9b6f8c8e-2d44-4a1c-9f77-2c4f7b5a6c12",
                            1.0D, AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<MobEffect> VENOM_STRIKE = registerEffect("venom_strike",
            // Dark Olive Green (#556B2F) — closest vanilla: Hunger (#587653), dist ≈ 8.6
            () -> new VenomEffect(MobEffectCategory.BENEFICIAL, 0x556B2F));

    public static final RegistryObject<MobEffect> ILLAGER_BANE = registerEffect("illager_bane",
            // Steel Gray (#708090) — closest vanilla: Slowness (#5A6C81), dist ≈ 28.4
            () -> new IllagerBaneEffect(MobEffectCategory.BENEFICIAL, 0x708090));

    public static final RegistryObject<MobEffect> THORN_SHIELD = registerEffect("thorn_shield",
            // Dark Red (#8B0000) — closest vanilla: Weakness (#484D48), dist ≈ 51.1
            () -> new ThornShieldEffect(MobEffectCategory.BENEFICIAL, 0x8B0000));

    public static final RegistryObject<MobEffect> THUNDERSTRIKE = registerEffect("thunderstrike",
            // Gold (#FFD700) — closest vanilla: Fire Resistance (#E49A3A), dist ≈ 67.4
            () -> new ThunderstrikeEffect(MobEffectCategory.BENEFICIAL, 0xFFD700));

    public static final RegistryObject<MobEffect> BLIND_SHIELD = registerEffect("blind_shield",
            // Charcoal Gray (#36454F) — closest vanilla: Invisibility (#7F8392), dist ≈ 54.3
            () -> new BlindShroudEffect(MobEffectCategory.BENEFICIAL, 0x36454F));

    public static final RegistryObject<MobEffect> FROST_STRIKE = registerEffect("frost_strike",
            // Light Cyan (#E0FFFF) — closest vanilla: Water Breathing (#2E5299), dist ≈ 84.7
            () -> new FrostStrikeEffect(MobEffectCategory.BENEFICIAL, 0xE0FFFF));

    public static final RegistryObject<MobEffect> BURNING_STRIKE = registerEffect("burning_strike",
            // OrangeRed (#FF4500) — closest vanilla: Strength (#932423), dist ≈ 80.9
            () -> new BurningStrikeEffect(MobEffectCategory.BENEFICIAL, 0xFF4500));

    public static final RegistryObject<MobEffect> GLOWING_AURA = registerEffect("glowing_aura",
            // Light Goldenrod Yellow (#FAFAD2) — closest vanilla: Night Vision (#1F1FA1), dist ≈ 91.8
            () -> new GlowingAuraEffect(MobEffectCategory.NEUTRAL, 0xFAFAD2));

    public static final RegistryObject<MobEffect> HEALING_MIST = registerEffect("healing_mist",
            // Hot Pink (#FF69B4) — closest vanilla: Instant Health (#F82423), dist ≈ 87.2
            () -> new HealingMistEffect(MobEffectCategory.BENEFICIAL, 0xFF69B4));

    public static final RegistryObject<MobEffect> ARTHROPOD_BLIGHT = registerEffect("arthropod_blight",
            // Maroon (#800000) — closest vanilla: Weakness (#484D48), dist ≈ 46.7
            () -> new ArthropodBlightEffect(MobEffectCategory.BENEFICIAL, 0x800000));

    public static final RegistryObject<MobEffect> SILENCE_CLOAK = registerEffect("silence_cloak",
            // Sky Blue (#87CEEB) — closest vanilla: Slow Falling (#C3C3DB), dist ≈ 73.5
            () -> new SilenceCloakEffect(MobEffectCategory.BENEFICIAL, 0x87CEEB));

    public static final RegistryObject<MobEffect> WITHERING_STRIKE = registerEffect("withering_strike",
            // Black (#000000) — closest vanilla: Wither (#352A27), dist ≈ 22.3
            () -> new WitheringStrikeEffect(MobEffectCategory.BENEFICIAL, 0x000000));

    public static final RegistryObject<MobEffect> HOLY_STRIKE = registerEffect("holy_strike",
            // Cornsilk (#FFF8DC) — closest vanilla: Night Vision (#1F1FA1), dist ≈ 94.1
            () -> new HolyStrikeEffect(MobEffectCategory.BENEFICIAL, 0xFFF8DC));

    public static final RegistryObject<MobEffect> UNHINDERED = registerEffect("unhindered",
            // Pastel Teal (#A0FFA0) — closest vanilla: Luck (#339900), dist ≈ 72.0
            () -> new UnhinderedEffect(MobEffectCategory.BENEFICIAL, 0xA0FFA0));

    public static final RegistryObject<MobEffect> HUNTERS_WARD = registerEffect("hunters_ward",
            // Light Orange (#FFCC99) — cat-like color I think
            () -> new HuntersCloakEffect(MobEffectCategory.BENEFICIAL, 0xFFCC99));

    // -------------------- HELPER METHODS --------------------

    /**
     * Registers an effect with lazy translation fetching
     */
    private static RegistryObject<MobEffect> registerEffect(String name, Supplier<MobEffect> supplier) {
        return MOB_EFFECTS.register(name, supplier);
    }

    /**
     * Registers the deferred register to the event bus
     */
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}