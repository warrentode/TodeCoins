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

public class BirthdayCondition implements LootItemCondition {
    @Nullable
    Boolean isBirthday;

    BirthdayCondition(@Nullable Boolean isSeason) {
        this.isBirthday = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.BIRTHDAY_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel level = context.getLevel();
        return this.isBirthday = CalendarUtil.check("BIRTHDAY");
    }

    public static BirthdayCondition.Builder event() {
        return new BirthdayCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isBirthday;

        public BirthdayCondition.Builder setEvent(@Nullable Boolean isBirthday) {
            this.isBirthday = isBirthday;
            return this;
        }

        public @NotNull BirthdayCondition build() {
            return new BirthdayCondition(this.isBirthday);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<BirthdayCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull BirthdayCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("birthday", check.isBirthday);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull BirthdayCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("birthday") ? GsonHelper.getAsBoolean(jsonObject, "birthday") : null;
            return new BirthdayCondition(booleanValue);
        }
    }
}