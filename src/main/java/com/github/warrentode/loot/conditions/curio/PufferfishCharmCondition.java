package com.github.warrentode.loot.conditions.curio;

import com.github.warrentode.integration.Curios;
import com.github.warrentode.integration.ModListHandler;
import com.github.warrentode.loot.serializers.ModLootItemConditions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class PufferfishCharmCondition implements LootItemCondition {
    @Nullable
    Boolean isPufferfishCharm;

    PufferfishCharmCondition(@Nullable Boolean isPufferfishCharm) {
        this.isPufferfishCharm = isPufferfishCharm;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.PUFFERFISH_CHARM_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel serverlevel = context.getLevel();
        Player player = Minecraft.getInstance().player;
        if (ModListHandler.curiosLoaded) {
            ItemStack isPufferfishCharm = Curios.getCharmSlot(player);
            return this.isPufferfishCharm = Curios.matchPufferfishCharm(isPufferfishCharm);
        }
        else {return false;}
    }

    public static PufferfishCharmCondition.Builder matches() {
        return new PufferfishCharmCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isPufferfishCharm;

        public PufferfishCharmCondition.Builder setMatch(@Nullable Boolean isPufferfishCharm) {
            this.isPufferfishCharm = isPufferfishCharm;
            return this;
        }

        public @NotNull PufferfishCharmCondition build() {
            return new PufferfishCharmCondition(this.isPufferfishCharm);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<PufferfishCharmCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull PufferfishCharmCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("pufferfish_charm", check.isPufferfishCharm);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull PufferfishCharmCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("pufferfish_charm") ? GsonHelper.getAsBoolean(jsonObject, "pufferfish_charm") : null;
            return new PufferfishCharmCondition(booleanValue);
        }
    }
}