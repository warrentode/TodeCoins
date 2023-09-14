package com.github.warrentode.todecoins.attribute;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerPufferfishProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    LivingEntity entity;
    public static Capability<PlayerPufferfishBonus> PLAYER_PUFFERFISH_BONUS = CapabilityManager.get(new CapabilityToken<>() {
    });

    private PlayerPufferfishBonus playerPufferfishBonus = null;
    private final LazyOptional<PlayerPufferfishBonus> optional = LazyOptional.of(this::createPlayerPufferfishBonus);

    private PlayerPufferfishBonus createPlayerPufferfishBonus() {
        if (this.playerPufferfishBonus == null) {
            this.playerPufferfishBonus = new PlayerPufferfishBonus(entity);
        }

        return this.playerPufferfishBonus;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_PUFFERFISH_BONUS) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerPufferfishBonus().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerPufferfishBonus().loadNBTData(nbt);
    }
}