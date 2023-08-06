package net.warrentode.todecoins.attribute;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, MODID);

    public static final RegistryObject<Attribute> CHARISMA = ATTRIBUTES.register("charisma",
            () -> new RangedAttribute("attribute.name.todecoins.charisma",
                    0.0D, -1024.0D, 1024.0D).setSyncable(true));
    public static final UUID CHR_MODIFIER_UUID = UUID.fromString("e4c6b947-d382-4343-b687-c34ebf01dd9e");
    public static final String CHR_MODIFIER_NAME = MODID + ":charisma_bonus";
}