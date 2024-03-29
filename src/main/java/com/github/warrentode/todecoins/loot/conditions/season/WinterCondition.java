package com.github.warrentode.todecoins.loot.conditions.season;

import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.github.warrentode.todecoins.util.CalendarUtil;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WinterCondition implements LootItemCondition {
    @Nullable
    Boolean isWinter;

    WinterCondition(@Nullable Boolean isSeason) {
        this.isWinter = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.WINTER_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel level = context.getLevel();
        return this.isWinter = CalendarUtil.check("WINTER");
    }

    public static WinterCondition.Builder season() {
        return new WinterCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isWinter;

        public WinterCondition.Builder setEvent(@Nullable Boolean isWinter) {
            this.isWinter = isWinter;
            return this;
        }

        public @NotNull WinterCondition build() {
            return new WinterCondition(this.isWinter);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<WinterCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull WinterCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("winter", check.isWinter);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull WinterCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("winter") ? GsonHelper.getAsBoolean(jsonObject, "winter") : null;
            return new WinterCondition(booleanValue);
        }
    }
}