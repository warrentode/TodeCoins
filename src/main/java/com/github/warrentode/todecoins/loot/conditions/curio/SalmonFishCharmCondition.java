package com.github.warrentode.todecoins.loot.conditions.curio;

import com.github.warrentode.todecoins.integration.Curios;
import com.github.warrentode.todecoins.loot.serializers.ModLootItemConditions;
import com.github.warrentode.todecoins.util.tags.ModTags;
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
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class SalmonFishCharmCondition implements LootItemCondition {
    @Nullable
    Boolean isSalmonFishCharm;

    SalmonFishCharmCondition(@Nullable Boolean isSalmonFishCharm) {
        this.isSalmonFishCharm = isSalmonFishCharm;
    }

    public @NotNull LootItemConditionType getType() {
        return ModLootItemConditions.SALMON_FISH_CHARM_CONDITION.get();
    }

    public boolean test(@NotNull LootContext context) {
        ServerLevel serverlevel = context.getLevel();
        Player player = Minecraft.getInstance().player;
        if (ModList.get().isLoaded("curios")) {
            ItemStack stack = Curios.getCharmSlot(player);
            return this.isSalmonFishCharm = stack.is(ModTags.Items.SALMON_COIN_SET);
        }
        else {
            return false;
        }
    }

    public static SalmonFishCharmCondition.Builder matches() {
        return new SalmonFishCharmCondition.Builder();
    }

    public static class Builder implements LootItemCondition.Builder {
        @Nullable
        Boolean isSalmonFishCharm;

        public SalmonFishCharmCondition.Builder setMatch(@Nullable Boolean isSalmonFishCharm) {
            this.isSalmonFishCharm = isSalmonFishCharm;
            return this;
        }

        public @NotNull SalmonFishCharmCondition build() {
            return new SalmonFishCharmCondition(this.isSalmonFishCharm);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<SalmonFishCharmCondition> {
        /**
         * Serialize the value by putting its data into the JsonObject.
         */
        public void serialize(@NotNull JsonObject jsonObject, @NotNull SalmonFishCharmCondition check, @NotNull JsonSerializationContext context) {
            jsonObject.addProperty("salmon_fish_charm", check.isSalmonFishCharm);
        }

        /**
         * Deserialize a value by reading it from the JsonObject.
         */
        public @NotNull SalmonFishCharmCondition deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext context) {
            Boolean booleanValue = jsonObject.has("salmon_fish_charm") ? GsonHelper.getAsBoolean(jsonObject, "salmon_fish_charm") : null;
            return new SalmonFishCharmCondition(booleanValue);
        }
    }
}