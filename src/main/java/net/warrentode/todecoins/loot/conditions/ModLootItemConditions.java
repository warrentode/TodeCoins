package net.warrentode.todecoins.loot.conditions;

import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.warrentode.todecoins.TodeCoins.MODID;

public class ModLootItemConditions extends LootItemConditions {
    private static final DeferredRegister<LootItemConditionType> REGISTER = DeferredRegister.create(Registry.LOOT_ITEM_REGISTRY, MODID);

    public static final RegistryObject<LootItemConditionType> BLOCKTAG_CONDITION = REGISTER.register("blocktag_condition",
            () -> new LootItemConditionType(new BlockTagCondition.Serializer()));

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