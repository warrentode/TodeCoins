package com.github.warrentode.todecoins.loot.condition;

import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class EntityHasEffectCondition implements LootItemCondition {
    @Nullable
    private final MobEffect effect;

    public EntityHasEffectCondition(@Nullable MobEffect effect) {
        this.effect = effect;
    }

    @Override
    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.ENTITY_HAS_EFFECT.get();
    }

    @Override
    public boolean test(@NotNull LootContext context) {
        Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (entity instanceof LivingEntity living && effect != null) {
            return living.hasEffect(effect);
        }
        return false;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull Builder hasEffect(MobEffect effect) {
        return new Builder(effect);
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        private final MobEffect effect;

        public Builder(@Nullable MobEffect effect) {
            this.effect = effect;
        }

        @Override
        public @NotNull EntityHasEffectCondition build() {
            return new EntityHasEffectCondition(effect);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<EntityHasEffectCondition> {
        @Override
        public void serialize(@NotNull JsonObject json, @NotNull EntityHasEffectCondition condition, @NotNull JsonSerializationContext context) {
            if (condition.effect != null) {
                json.addProperty("hasEffect", Objects.requireNonNull(ForgeRegistries.MOB_EFFECTS.getKey(condition.effect)).toString());
            }
        }

        @Override
        public @NotNull EntityHasEffectCondition deserialize(@NotNull JsonObject json, @NotNull JsonDeserializationContext context) {
            if (json.has("hasEffect")) {
                ResourceLocation id = ResourceLocation.parse(GsonHelper.getAsString(json, "hasEffect"));
                MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(id);
                return new EntityHasEffectCondition(effect);
            }
            return new EntityHasEffectCondition(null);
        }
    }
}