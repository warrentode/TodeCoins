package net.warrentode.todecoins.loot.conditions.curio;

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
import net.warrentode.todecoins.integration.Curios;
import net.warrentode.todecoins.integration.ModListHandler;
import net.warrentode.todecoins.loot.serializers.ModLootItemConditions;
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
        ServerLevel serverlevel = context.getLevel();
        Player player = Minecraft.getInstance().player;
        if (ModListHandler.curiosLoaded) {
            ItemStack isTropicalFishCharm = Curios.getCharmSlot(player);
            return this.isTropicalFishCharm = Curios.matchTropicalFishCharm(isTropicalFishCharm);
        }
        else {return false;}
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