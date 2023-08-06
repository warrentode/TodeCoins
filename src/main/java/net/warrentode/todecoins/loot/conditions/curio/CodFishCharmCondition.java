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

public class CodFishCharmCondition implements LootItemCondition {
    @Nullable
    Boolean isCodFishCharm;

    CodFishCharmCondition(@Nullable Boolean isCodFishCharm) {
        this.isCodFishCharm = isCodFishCharm;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.COD_FISH_CHARM_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel serverlevel = context.getLevel();
        Player player = Minecraft.getInstance().player;
        if (ModListHandler.curiosLoaded) {
            ItemStack isCodFishCharm = Curios.getCharmSlot(player);
            return this.isCodFishCharm = Curios.matchCodFishCharm(isCodFishCharm);
        }
        else {return false;}
    }

    public static CodFishCharmCondition.Builder matches() {
        return new CodFishCharmCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isCodFishCharm;

        public CodFishCharmCondition.Builder setMatch(@Nullable Boolean isCodFishCharm) {
            this.isCodFishCharm = isCodFishCharm;
            return this;
        }

        public @NotNull CodFishCharmCondition build() {
            return new CodFishCharmCondition(this.isCodFishCharm);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<CodFishCharmCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull CodFishCharmCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("cod_fish_charm", check.isCodFishCharm);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull CodFishCharmCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("cod_fish_charm") ? GsonHelper.getAsBoolean(jsonObject, "cod_fish_charm") : null;
            return new CodFishCharmCondition(booleanValue);
        }
    }
}