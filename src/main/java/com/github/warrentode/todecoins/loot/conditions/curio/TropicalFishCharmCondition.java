package com.github.warrentode.todecoins.loot.conditions.curio;

import com.github.warrentode.todecoins.attribute.PlayerTropicalFishBonus;
import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class TropicalFishCharmCondition implements LootItemCondition {
    @Nullable
    Boolean isTropicalFishCharm;

    TropicalFishCharmCondition(@Nullable Boolean isTropicalFishCharm) {
        this.isTropicalFishCharm = isTropicalFishCharm;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.TROPICAL_FISH_CHARM_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        Level level = context.getLevel();
        if (ModList.get().isLoaded("curios")) {
            return this.isTropicalFishCharm = (PlayerTropicalFishBonus.getBonus() > 0);
        }
        else {
            return false;
        }
    }

    public static TropicalFishCharmCondition.Builder matches() {
        return new TropicalFishCharmCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isTropicalFishCharm;

        public TropicalFishCharmCondition.Builder setMatch(@Nullable Boolean isTropicalFishCharm) {
            this.isTropicalFishCharm = isTropicalFishCharm;
            return this;
        }

        public @NotNull TropicalFishCharmCondition build() {
            return new TropicalFishCharmCondition(this.isTropicalFishCharm);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<TropicalFishCharmCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull TropicalFishCharmCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("tropical_fish_charm", check.isTropicalFishCharm);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull TropicalFishCharmCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("tropical_fish_charm") ? GsonHelper.getAsBoolean(jsonObject, "tropical_fish_charm") : null;
            return new TropicalFishCharmCondition(booleanValue);
        }
    }
}