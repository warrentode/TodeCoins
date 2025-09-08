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

public class HalloweenCondition implements LootItemCondition {
    @Nullable
    Boolean isHalloween;

    HalloweenCondition(@Nullable Boolean isSeason) {
        this.isHalloween = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.HALLOWEEN_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        return this.isHalloween = CalendarUtil.check("HALLOWEEN");
    }

    public static Builder event() {
        return new Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isHalloween;

        public Builder setEvent(@Nullable Boolean isHalloween) {
            this.isHalloween = isHalloween;
            return this;
        }

        public @NotNull HalloweenCondition build() {
            return new HalloweenCondition(this.isHalloween);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<HalloweenCondition> {
        /** Serialize the value by putting its data into the JsonObject. */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull HalloweenCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("halloween", check.isHalloween);
        }

        /** Deserialize a value by reading it from the JsonObject. */
        public @NotNull HalloweenCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("halloween") ? GsonHelper.getAsBoolean(jsonObject, "halloween") : null;
            return new HalloweenCondition(booleanValue);
        }
    }
}