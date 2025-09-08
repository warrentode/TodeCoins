package com.github.warrentode.todecoins.loot.condition;

import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.common.util.FakePlayer;
import org.jetbrains.annotations.NotNull;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;

public class NotFakePlayerCondition implements LootItemCondition {
    NotFakePlayerCondition() {
        // no params needed
    }

    @Override
    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.NOT_FAKE_PLAYER.get(); // register this in your conditions registry
    }

    @Override
    public boolean test(@NotNull LootContext context) {
        Entity killer = context.getParamOrNull(LootContextParams.KILLER_ENTITY);
        // Return true ONLY if killer is not a FakePlayer
        return !(killer instanceof FakePlayer);
    }

    // ---- Builder (for JSON / DSL compatibility) ----
    public static class Builder implements LootItemCondition.Builder {
        @Override
        public @NotNull NotFakePlayerCondition build() {
            return new NotFakePlayerCondition();
        }
    }

    // ---- Serializer (so JSON just looks like { "condition": "yourmod:not_fake_player" }) ----
    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<NotFakePlayerCondition> {
        @Override
        public void serialize(@NotNull JsonObject jsonObject, @NotNull NotFakePlayerCondition condition, @NotNull JsonSerializationContext context) {
            // Nothing to serialize, no fields
        }

        @Override
        public @NotNull NotFakePlayerCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            return new NotFakePlayerCondition();
        }
    }
}