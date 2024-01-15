package com.github.warrentode.todecoins.util;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static com.github.warrentode.todecoins.TodeCoins.MODID;

public class PlayerUtil {
    public static final String BRACELET_MAKER_TAG = MODID + ":" + "braceletMakerName";

    @Nullable
    public static Player getPlayerEntityByName(@NotNull ServerLevel serverLevel, String name) {
        return serverLevel.players().stream().filter(player -> player.getName().getString().equals(name)).findFirst().orElse(null);
    }
}