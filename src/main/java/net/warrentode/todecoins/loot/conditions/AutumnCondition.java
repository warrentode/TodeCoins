package net.warrentode.todecoins.loot.conditions;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import net.warrentode.todecoins.util.CalendarUtil;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class AutumnCondition implements LootItemCondition {
    @Nullable
    Boolean isAutumn;

    AutumnCondition(@Nullable Boolean isSeason) {
        this.isAutumn = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.AUTUMN_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel serverlevel = context.getLevel();
        return this.isAutumn = CalendarUtil.Season.isAutumn();
    }

    public static AutumnCondition.Builder season() {
        return new AutumnCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isAutumn;

        public AutumnCondition.Builder setEvent(@Nullable Boolean isAutumn) {
            this.isAutumn = isAutumn;
            return this;
        }

        public @NotNull AutumnCondition build() {
            return new AutumnCondition(this.isAutumn);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<AutumnCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull AutumnCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("spring", check.isAutumn);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull AutumnCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("spring") ? GsonHelper.getAsBoolean(jsonObject, "spring") : null;
            return new AutumnCondition(booleanValue);
        }
    }
}