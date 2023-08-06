package com.github.warrentode.loot.serializers;

import com.github.warrentode.loot.conditions.ModCheckCondition;
import com.github.warrentode.loot.conditions.curio.CodFishCharmCondition;
import com.github.warrentode.loot.conditions.curio.PufferfishCharmCondition;
import com.github.warrentode.loot.conditions.curio.SalmonFishCharmCondition;
import com.github.warrentode.loot.conditions.curio.TropicalFishCharmCondition;
import com.github.warrentode.loot.conditions.season.*;
import com.github.warrentode.loot.conditions.tag.BlockTagCondition;
import com.github.warrentode.loot.conditions.tag.EntityTypeTagCondition;
import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.TodeCoins.MODID;

public class ModLootItemConditions extends LootItemConditions {
    private static final DeferredRegister<LootItemConditionType> REGISTER = DeferredRegister.create(Registry.LOOT_ITEM_REGISTRY, MODID);

    public static final RegistryObject<LootItemConditionType> COD_FISH_CHARM_CONDITION = REGISTER.register("cod_fish_charm_condition",
            () -> new LootItemConditionType(new CodFishCharmCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> PUFFERFISH_CHARM_CONDITION = REGISTER.register("pufferfish_charm_condition",
            () -> new LootItemConditionType(new PufferfishCharmCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> SALMON_FISH_CHARM_CONDITION = REGISTER.register("salmon_fish_charm_condition",
            () -> new LootItemConditionType(new SalmonFishCharmCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> TROPICAL_FISH_CHARM_CONDITION = REGISTER.register("tropical_fish_charm_condition",
            () -> new LootItemConditionType(new TropicalFishCharmCondition.Serializer()));

    public static final RegistryObject<LootItemConditionType> MODLOADED_CONDITION = REGISTER.register("modloaded_condition",
            () -> new LootItemConditionType(new ModCheckCondition.Serializer()));

    public static final RegistryObject<LootItemConditionType> BLOCKTAG_CONDITION = REGISTER.register("blocktag_condition",
            () -> new LootItemConditionType(new BlockTagCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> ENTITY_TYPE_TAG_CONDITION = REGISTER.register("entity_type_tag_condition",
            () -> new LootItemConditionType(new EntityTypeTagCondition.Serializer()));

    public static final RegistryObject<LootItemConditionType> SPRING_CONDITION = REGISTER.register("spring_condition",
            () -> new LootItemConditionType(new SpringCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> SUMMER_CONDITION = REGISTER.register("summer_condition",
            () -> new LootItemConditionType(new SummerCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> AUTUMN_CONDITION = REGISTER.register("autumn_condition",
            () -> new LootItemConditionType(new AutumnCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> WINTER_CONDITION = REGISTER.register("winter_condition",
            () -> new LootItemConditionType(new WinterCondition.Serializer()));

    public static final RegistryObject<LootItemConditionType> BIRTHDAY_CONDITION = REGISTER.register("birthday_condition",
            () -> new LootItemConditionType(new BirthdayCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> HALLOWEEN_CONDITION = REGISTER.register("halloween_condition",
            () -> new LootItemConditionType(new HalloweenCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> CHRISTMAS_CONDITION = REGISTER.register("christmas_condition",
            () -> new LootItemConditionType(new ChristmasCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> ANNIVERSARY_CONDITION = REGISTER.register("anniversary_condition",
            () -> new LootItemConditionType(new AnniversaryCondition.Serializer()));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}