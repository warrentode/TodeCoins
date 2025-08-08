package com.github.warrentode.todecoins.loot.conditions.tag;

import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Set;

public class EntityTypeTagCondition implements LootItemCondition {
    final TagKey<EntityType<?>> entityTypeTag;

    public EntityTypeTagCondition(TagKey<EntityType<?>> entityTypeTag) {
        this.entityTypeTag = entityTypeTag;
    }

    public static EntityTypeTagCondition isTag(TagKey<EntityType<?>> tag) {
        return new EntityTypeTagCondition(tag);
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.ENTITY_TYPE_TAG_CONDITION.get();
    }

    public @NotNull Set<LootContextParam<?>> getReferencedContextParams() {
        return ImmutableSet.of(LootContextParams.THIS_ENTITY);
    }

    public boolean test(@NotNull LootContext context) {
        EntityType<?> entityType = Objects.requireNonNull(context.getParamOrNull(LootContextParams.THIS_ENTITY)).getType();
        //noinspection ConstantValue
        return entityType != null && entityType.is(this.entityTypeTag);
    }

    public EntityTypeTagCondition.Builder build() {
        return new EntityTypeTagCondition.Builder(this.entityTypeTag);
    }

    public static class Builder implements LootItemCondition.Builder {
        final TagKey<EntityType<?>> entityTypeTag;

        public Builder(TagKey<EntityType<?>> entityTypeTag) {
            this.entityTypeTag = entityTypeTag;
        }

        public @NotNull EntityTypeTagCondition build() {
            return new EntityTypeTagCondition(this.entityTypeTag);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<EntityTypeTagCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull EntityTypeTagCondition condition, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("tag", condition.entityTypeTag.location().toString());
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull EntityTypeTagCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            //noinspection removal
            ResourceLocation resourcelocation = new ResourceLocation(GsonHelper.getAsString(jsonObject, "tag"));
            TagKey<EntityType<?>> entityTypeTag = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, resourcelocation);
            return new EntityTypeTagCondition(entityTypeTag);
        }
    }
}