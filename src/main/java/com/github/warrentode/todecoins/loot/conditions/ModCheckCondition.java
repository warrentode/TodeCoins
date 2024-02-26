package com.github.warrentode.todecoins.loot.conditions;

import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
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

public class ModCheckCondition implements LootItemCondition {
    @Nullable
    String modid;

    ModCheckCondition(@Nullable String modid) {
        this.modid = modid;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.MODLOADED_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel level = context.getLevel();
        return ModList.get().isLoaded(this.modid);
    }

    public static Builder mod() {
        return new Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        String modid;

        public Builder isLoaded(@Nullable String modid) {
            this.modid = modid;
            return this;
        }

        public @NotNull ModCheckCondition build() {
            return new ModCheckCondition(this.modid);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<ModCheckCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull ModCheckCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("modid", check.modid);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull ModCheckCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            String modid = jsonObject.has("modid") ? GsonHelper.getAsString(jsonObject, "modid") : null;
            return new ModCheckCondition(modid);
        }
    }
}