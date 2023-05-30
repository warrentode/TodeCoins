package net.warrentode.todecoins.loot.conditions;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.warrentode.todecoins.util.CalendarUtil;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class SpringCondition implements LootItemCondition {
    @Nullable
    Boolean isSpring;

    SpringCondition(@Nullable Boolean isSeason) {
        this.isSpring = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.SPRING_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel serverlevel = context.getLevel();
        return this.isSpring = CalendarUtil.Season.isSpring();
    }

    public static SpringCondition.Builder season() {
        return new SpringCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isSpring;

        public SpringCondition.Builder setAnniversary(@Nullable Boolean isSpring) {
            this.isSpring = isSpring;
            return this;
        }

        public @NotNull SpringCondition build() {
            return new SpringCondition(this.isSpring);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<SpringCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull SpringCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("spring", check.isSpring);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull SpringCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("spring") ? GsonHelper.getAsBoolean(jsonObject, "spring") : null;
            return new SpringCondition(booleanValue);
        }
    }
}