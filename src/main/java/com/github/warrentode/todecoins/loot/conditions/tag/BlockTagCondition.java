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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BlockTagCondition implements LootItemCondition {
    final TagKey<Block> blockTag;

    public BlockTagCondition(TagKey<Block> blockTag) {
        this.blockTag = blockTag;
    }

    public static BlockTagCondition isTag(TagKey<Block> tag) {
        return new BlockTagCondition(tag);
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.BLOCKTAG_CONDITION.get();
    }

    public @NotNull Set<LootContextParam<?>> getReferencedContextParams() {
        return ImmutableSet.of(LootContextParams.BLOCK_STATE);
    }

    public boolean test(@NotNull LootContext context) {
        BlockState blockstate = context.getParamOrNull(LootContextParams.BLOCK_STATE);
        return blockstate != null && blockstate.is(this.blockTag);
    }

    public static BlockTagCondition.Builder tag() {
        return new BlockTagCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        TagKey<Block> blockTag;

        public BlockTagCondition.Builder setTag(TagKey<Block> blockTag) {
            this.blockTag = blockTag;
            return this;
        }

        public @NotNull BlockTagCondition build() {
            return new BlockTagCondition(this.blockTag);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<BlockTagCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull BlockTagCondition condition, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("tag", condition.blockTag.location().toString());
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull BlockTagCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            //noinspection removal
            ResourceLocation resourcelocation = new ResourceLocation(GsonHelper.getAsString(jsonObject, "tag"));
            TagKey<Block> blockTag = TagKey.create(Registry.BLOCK_REGISTRY, resourcelocation);
            return new BlockTagCondition(blockTag);
        }
    }
}