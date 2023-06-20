package net.warrentode.todecoins.loot.conditions.season;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.warrentode.todecoins.TodeCoins;
import net.warrentode.todecoins.integration.SereneSeasons;
import net.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import net.warrentode.todecoins.util.CalendarUtil;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ChristmasCondition implements LootItemCondition {
    @Nullable
    Boolean isChristmas;

    ChristmasCondition(@Nullable Boolean isSeason) {
        this.isChristmas = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.CHRISTMAS_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel serverlevel = context.getLevel();
        if (TodeCoins.isSereneSeasonsLoaded()) {
            return this.isChristmas = SereneSeasons.Season.isChristmas();
        }
        else {
            return this.isChristmas = CalendarUtil.Season.isChristmas();
        }
    }

    public static ChristmasCondition.Builder event() {
        return new ChristmasCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isChristmas;

        public ChristmasCondition.Builder setEvent(@Nullable Boolean isChristmas) {
            this.isChristmas = isChristmas;
            return this;
        }

        public @NotNull ChristmasCondition build() {
            return new ChristmasCondition(this.isChristmas);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<ChristmasCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull ChristmasCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("christmas", check.isChristmas);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull ChristmasCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("christmas") ? GsonHelper.getAsBoolean(jsonObject, "christmas") : null;
            return new ChristmasCondition(booleanValue);
        }
    }
}