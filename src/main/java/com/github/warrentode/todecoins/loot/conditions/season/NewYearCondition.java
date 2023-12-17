package com.github.warrentode.todecoins.loot.conditions.season;

import com.github.warrentode.todecoins.integration.SereneSeasonsCompat;
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
import net.minecraftforge.fml.ModList;
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
        ServerLevel level = context.getLevel();
        if (ModList.get().isLoaded("sereneseasons")) {
            return this.isNewYear = SereneSeasonsCompat.isNewYear(level);
        }
        else {
            return this.isNewYear = CalendarUtil.isNewYear();
        }
    }

    public static NewYearCondition.Builder event() {
        return new NewYearCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isNewYear;

        public NewYearCondition.Builder setEvent(@Nullable Boolean isNewYear) {
            this.isNewYear = isNewYear;
            return this;
        }

        public @NotNull NewYearCondition build() {
            return new NewYearCondition(this.isNewYear);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<NewYearCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull NewYearCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("new_year", check.isNewYear);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull NewYearCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("new_year") ? GsonHelper.getAsBoolean(jsonObject, "new_year") : null;
            return new NewYearCondition(booleanValue);
        }
    }
}