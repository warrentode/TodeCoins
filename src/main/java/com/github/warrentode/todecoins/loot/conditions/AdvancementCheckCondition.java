package com.github.warrentode.todecoins.loot.conditions;

import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.PredicateManager;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.common.crafting.conditions.ICondition;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class AdvancementCheckCondition implements LootItemCondition {
    private final PredicateManager predicateManager = new PredicateManager();
    @Nullable
    String advancementCheck;

    AdvancementCheckCondition(@Nullable String advancementCheck) {
        this.advancementCheck = advancementCheck;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.ADVANCEMENT_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel serverLevel = context.getLevel();
        ServerPlayer serverPlayer = (ServerPlayer) context.getLevel().getPlayers(LivingEntity::isAlive);
        ServerAdvancementManager manager = new ServerAdvancementManager(this.predicateManager, (ICondition.IContext) context);

        if (serverLevel != null && this.advancementCheck != null) {
            return serverPlayer.getAdvancements().getOrStartProgress(Objects.requireNonNull(manager.getAdvancement(new ResourceLocation(this.advancementCheck)))).isDone();
        }
        return false;
    }

    public static Builder advancementCondition() {
        return new Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        String advancementCheck;

        public Builder check(@Nullable String advancementCheck) {
            this.advancementCheck = advancementCheck;
            return this;
        }

        public @NotNull AdvancementCheckCondition build() {
            return new AdvancementCheckCondition(this.advancementCheck);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<AdvancementCheckCondition> {
        private String advancementCheck;

        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull AdvancementCheckCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("advancementCheck", check.advancementCheck);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull AdvancementCheckCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            String modid = jsonObject.has("advancementCheck") ? GsonHelper.getAsString(jsonObject, "advancementCheck") : null;
            return new AdvancementCheckCondition(this.advancementCheck);
        }
    }
}