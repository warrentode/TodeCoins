package com.github.warrentode.todecoins.loot.conditions.season;

import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.github.warrentode.todecoins.util.CalendarUtil;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class EasterCondition implements LootItemCondition {
    @Nullable
    Boolean isEaster;

    EasterCondition(@Nullable Boolean isSeason) {
        this.isEaster = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.EASTER_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        return this.isEaster = CalendarUtil.check("EASTER");
    }

    public static EasterCondition.Builder event() {
        return new EasterCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isEaster;

        public EasterCondition.Builder setEvent(@Nullable Boolean isEaster) {
            this.isEaster = isEaster;
            return this;
        }

        public @NotNull EasterCondition build() {
            return new EasterCondition(this.isEaster);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<EasterCondition> {
        /** Serialize the value by putting its data into the JsonObject. */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull EasterCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("easter", check.isEaster);
        }

        /** Deserialize a value by reading it from the JsonObject. */
        public @NotNull EasterCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("easter") ? GsonHelper.getAsBoolean(jsonObject, "easter") : null;
            return new EasterCondition(booleanValue);
        }
    }
}