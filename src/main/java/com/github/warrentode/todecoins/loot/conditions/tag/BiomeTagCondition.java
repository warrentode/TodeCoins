package com.github.warrentode.todecoins.loot.conditions.tag;

import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BiomeTagCondition implements LootItemCondition {
    final TagKey<Biome> biomeTag;

    public BiomeTagCondition(TagKey<Biome> biomeTag) {
        this.biomeTag = biomeTag;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull BiomeTagCondition isTag(TagKey<Biome> tag) {
        return new BiomeTagCondition(tag);
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.BIOMETAG_CONDITION.get();
    }

    public @NotNull Set<LootContextParam<?>> getReferencedContextParams() {
        return ImmutableSet.of(LootContextParams.ORIGIN);
    }

    public boolean test(@NotNull LootContext context) {
        Vec3 vec3 = context.getParamOrNull(LootContextParams.ORIGIN);
        if (vec3 != null) {
            Holder<Biome> biome = context.getLevel().getBiome(new BlockPos(vec3));
            return biome.is(this.biomeTag);
        }
        return false;
    }

    public static BiomeTagCondition.Builder tag() {
        return new BiomeTagCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        TagKey<Biome> biomeTag;

        public BiomeTagCondition.Builder setTag(TagKey<Biome> biomeTag) {
            this.biomeTag = biomeTag;
            return this;
        }

        public @NotNull BiomeTagCondition build() {
            return new BiomeTagCondition(this.biomeTag);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<BiomeTagCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull BiomeTagCondition condition, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("tag", condition.biomeTag.location().toString());
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull BiomeTagCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            ResourceLocation resourcelocation = new ResourceLocation(GsonHelper.getAsString(jsonObject, "tag"));
            TagKey<Biome> biomeTag = TagKey.create(Registry.BIOME_REGISTRY, resourcelocation);
            return new BiomeTagCondition(biomeTag);
        }
    }
}
