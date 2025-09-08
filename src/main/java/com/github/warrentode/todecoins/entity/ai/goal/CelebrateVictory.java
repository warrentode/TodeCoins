package com.github.warrentode.todecoins.entity.ai.goal;

import com.github.warrentode.todecoins.entity.piglinmerchant.PiglinMerchant;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.raid.Raid;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;

public class CelebrateVictory extends Goal {
    private final MinecraftServer minecraftServer = ServerLifecycleHooks.getCurrentServer().getPlayerList().getServer();
    private final LivingEntity entity;
    private final ServerLevel level = minecraftServer.createCommandSourceStack().getLevel();

    public CelebrateVictory(@NotNull LivingEntity entity) {
        this.entity = entity;
    }
    @Override
    public boolean canUse() {
        Raid raid = level.getRaidAt(entity.blockPosition());
        return raid != null && raid.isVictory();
    }

    public void start() {
        PiglinMerchant.setCelebrate((PiglinMerchant) this.entity, true);
        super.start();
    }
}