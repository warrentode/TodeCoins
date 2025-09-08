package com.github.warrentode.todecoins.loot.condition.season;

import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.github.warrentode.todecoins.util.seasonal.CalendarUtil;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class NewYearCondition implements LootItemCondition {
    @Nullable
    Boolean isNewYear;

    NewYearCondition(@Nullable Boolean isSeason) {
        this.isNewYear = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.NEW_YEAR_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        return this.isNewYear = CalendarUtil.check("NEW_YEAR");
    }

    public static Builder event() {
        return new Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isNewYear;

        public Builder setEvent(@Nullable Boolean isNewYear) {
            this.isNewYear = isNewYear;
            return this;
        }

        public @NotNull NewYearCondition build() {
            return new NewYearCondition(this.isNewYear);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<NewYearCondition> {
        /** Serialize the value by putting its data into the JsonObject. */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull NewYearCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("new_year", check.isNewYear);
        }

        /** Deserialize a value by reading it from the JsonObject. */
        public @NotNull NewYearCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("new_year") ? GsonHelper.getAsBoolean(jsonObject, "new_year") : null;
            return new NewYearCondition(booleanValue);
        }
    }
}