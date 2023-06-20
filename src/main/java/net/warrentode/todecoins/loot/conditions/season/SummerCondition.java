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

public class SummerCondition implements LootItemCondition {
    @Nullable
    Boolean isSummer;

    SummerCondition(@Nullable Boolean isSeason) {
        this.isSummer = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.SUMMER_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel serverlevel = context.getLevel();
        if (TodeCoins.isSereneSeasonsLoaded()) {
            return this.isSummer = SereneSeasons.Season.isSummer();
        }
        else {
            return this.isSummer = CalendarUtil.Season.isSummer();
        }
    }

    public static SummerCondition.Builder season() {
        return new SummerCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isSummer;

        public SummerCondition.Builder setEvent(@Nullable Boolean isSummer) {
            this.isSummer = isSummer;
            return this;
        }

        public @NotNull SummerCondition build() {
            return new SummerCondition(this.isSummer);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<SummerCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull SummerCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("summer", check.isSummer);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull SummerCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("summer") ? GsonHelper.getAsBoolean(jsonObject, "summer") : null;
            return new SummerCondition(booleanValue);
        }
    }
}