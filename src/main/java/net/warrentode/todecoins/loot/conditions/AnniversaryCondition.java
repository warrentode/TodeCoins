package net.warrentode.todecoins.loot.conditions;

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

public class AnniversaryCondition implements LootItemCondition {
    @Nullable
    Boolean isAnniversary;

    AnniversaryCondition(@Nullable Boolean isSeason) {
        this.isAnniversary = isSeason;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.ANNIVERSARY_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel serverlevel = context.getLevel();
        if (TodeCoins.isSereneSeasonsLoaded()) {
            return this.isAnniversary = SereneSeasons.Season.isAnniversary();
        }
        else {
            return this.isAnniversary = CalendarUtil.Season.isAnniversary();
        }
    }

    public static AnniversaryCondition.Builder event() {
        return new AnniversaryCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isAnniversary;

        public AnniversaryCondition.Builder setEvent(@Nullable Boolean isAnniversary) {
            this.isAnniversary = isAnniversary;
            return this;
        }

        public @NotNull AnniversaryCondition build() {
            return new AnniversaryCondition(this.isAnniversary);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<AnniversaryCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull AnniversaryCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("anniversary", check.isAnniversary);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull AnniversaryCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("anniversary") ? GsonHelper.getAsBoolean(jsonObject, "anniversary") : null;
            return new AnniversaryCondition(booleanValue);
        }
    }
}