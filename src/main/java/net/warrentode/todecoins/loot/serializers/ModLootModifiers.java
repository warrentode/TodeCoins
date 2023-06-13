package net.warrentode.todecoins.loot.serializers;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.warrentode.todecoins.loot.modifiers.AddItemLootModifier;
import net.warrentode.todecoins.loot.modifiers.AddLootTableModifier;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MODID);

    @SuppressWarnings("unused")
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOT_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemLootModifier.CODEC);
    @SuppressWarnings("unused")
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOT_TABLE =
            LOOT_MODIFIER_SERIALIZERS.register("add_loot_table", AddLootTableModifier.CODEC);

    public static void register(IEventBus bus) {
        LOOT_MODIFIER_SERIALIZERS.register(bus);
    }
}