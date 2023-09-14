package com.github.warrentode.todecoins.attribute;

import com.github.warrentode.todecoins.TodeCoins;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, TodeCoins.MODID);

    public static final RegistryObject<Attribute> CHARISMA = ATTRIBUTES.register("charisma",
            () -> new RangedAttribute("attribute.name.todecoins.charisma",
                    0.0D, -1024.0D, 1024.0D).setSyncable(true));
    public static final RegistryObject<Attribute> COD_BONUS = ATTRIBUTES.register("cod_bonus",
            () -> new RangedAttribute("attribute.name.todecoins.cod_bonus",
                    0.0D, -1024.0D, 1024.0D).setSyncable(true));
    public static final RegistryObject<Attribute> PUFFERFISH_BONUS = ATTRIBUTES.register("pufferfish_bonus",
            () -> new RangedAttribute("attribute.name.todecoins.pufferfish_bonus",
                    0.0D, -1024.0D, 1024.0D).setSyncable(true));
    public static final RegistryObject<Attribute> SALMON_BONUS = ATTRIBUTES.register("salmon_bonus",
            () -> new RangedAttribute("attribute.name.todecoins.salmon_bonus",
                    0.0D, -1024.0D, 1024.0D).setSyncable(true));
    public static final RegistryObject<Attribute> TROPICAL_FISH_BONUS = ATTRIBUTES.register("tropical_fish_bonus",
            () -> new RangedAttribute("attribute.name.todecoins.tropical_fish_bonus",
                    0.0D, -1024.0D, 1024.0D).setSyncable(true));

    public static final UUID CHR_MODIFIER_UUID = UUID.fromString("e4c6b947-d382-4343-b687-c34ebf01dd9e");
    public static final UUID COD_BONUS_MODIFIER_UUID = UUID.fromString("2187bbc4-f843-4c4a-8187-0f3781d82d69");
    public static final UUID PUFFERFISH_BONUS_MODIFIER_UUID = UUID.fromString("33363200-930b-4347-9075-4c9fe1dcf4f3");
    public static final UUID SALMON_BONUS_MODIFIER_UUID = UUID.fromString("d5a1b454-2a1c-4652-b479-875151850f39");
    public static final UUID TROPICAL_FISH_BONUS_MODIFIER_UUID = UUID.fromString("f0ad947a-cd9c-4c95-b2ba-927652967ba3");

    public static final String CHR_MODIFIER_NAME = TodeCoins.MODID + ":charisma_bonus";
    public static final String COD_BONUS_MODIFIER_NAME = TodeCoins.MODID + ":cod_modifier";
    public static final String PUFFERFISH_BONUS_MODIFIER_NAME = TodeCoins.MODID + ":pufferfish_modifier";
    public static final String SALMON_BONUS_MODIFIER_NAME = TodeCoins.MODID + ":salmon_modifier";
    public static final String TROPICAL_FISH_BONUS_MODIFIER_NAME = TodeCoins.MODID + ":tropical_fish_modifier";
}