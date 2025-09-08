package com.github.warrentode.todecoins.loot.serializers;

import com.github.warrentode.todecoins.loot.condition.EntityHasEffectCondition;
import com.github.warrentode.todecoins.loot.condition.ModCheckCondition;
import com.github.warrentode.todecoins.loot.condition.NotFakePlayerCondition;
import com.github.warrentode.todecoins.loot.condition.season.*;
import com.github.warrentode.todecoins.loot.condition.tag.BiomeTagCondition;
import com.github.warrentode.todecoins.loot.condition.tag.BlockTagCondition;
import com.github.warrentode.todecoins.loot.condition.tag.EntityTypeTagCondition;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class ModLootItemConditions extends LootItemConditions {
    private static final DeferredRegister<LootItemConditionType> REGISTER = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, MODID);

    public static final RegistryObject<LootItemConditionType> MODLOADED_CONDITION = REGISTER.register("modloaded_condition",
            () -> new LootItemConditionType(new ModCheckCondition.Serializer()));

    public static final RegistryObject<LootItemConditionType> BIOMETAG_CONDITION = REGISTER.register("biometag_condition",
            () -> new LootItemConditionType(new BiomeTagCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> BLOCKTAG_CONDITION = REGISTER.register("blocktag_condition",
            () -> new LootItemConditionType(new BlockTagCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> ENTITY_TYPE_TAG_CONDITION = REGISTER.register("entity_type_tag_condition",
            () -> new LootItemConditionType(new EntityTypeTagCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> ENTITY_HAS_EFFECT = REGISTER.register("entity_has_effect",
            () -> new LootItemConditionType(new EntityHasEffectCondition.Serializer()));

    public static final RegistryObject<LootItemConditionType> NOT_FAKE_PLAYER = REGISTER.register("not_fake_player",
            () -> new LootItemConditionType(new NotFakePlayerCondition.Serializer()));

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
    public static final RegistryObject<LootItemConditionType> EASTER_CONDITION = REGISTER.register("easter_condition",
            () -> new LootItemConditionType(new EasterCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> NEW_YEAR_CONDITION = REGISTER.register("new_year_condition",
            () -> new LootItemConditionType(new NewYearCondition.Serializer()));
    public static final RegistryObject<LootItemConditionType> ANNIVERSARY_CONDITION = REGISTER.register("anniversary_condition",
            () -> new LootItemConditionType(new AnniversaryCondition.Serializer()));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}