package com.github.warrentode.loot.conditions;

import com.github.warrentode.integration.ModListHandler;
import com.github.warrentode.loot.serializers.ModLootItemConditions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ModCheckCondition implements LootItemCondition {
    @Nullable
    Boolean modIsLoaded;
    String modid;

    ModCheckCondition(@Nullable Boolean modIsLoaded) {
        this.modIsLoaded = modIsLoaded;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.MODLOADED_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        return ModListHandler.isModLoaded(modid);
    }

    public static ModCheckCondition.Builder check() {
        return new ModCheckCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean modIsLoaded;

        public ModCheckCondition.Builder setEvent(@Nullable Boolean modIsLoaded) {
            this.modIsLoaded = modIsLoaded;
            return this;
        }

        public @NotNull ModCheckCondition build() {
            return new ModCheckCondition(this.modIsLoaded);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<ModCheckCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull ModCheckCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("modid", check.modIsLoaded);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull ModCheckCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("modid") ? GsonHelper.getAsBoolean(jsonObject, "modid") : null;
            return new ModCheckCondition(booleanValue);
        }
    }
}