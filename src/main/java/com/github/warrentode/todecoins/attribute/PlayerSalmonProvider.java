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

public class PlayerSalmonProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    LivingEntity entity;
    public static Capability<PlayerSalmonBonus> PLAYER_SALMON_BONUS = CapabilityManager.get(new CapabilityToken<>() {
    });

    private PlayerSalmonBonus playerSalmonBonus = null;
    private final LazyOptional<PlayerSalmonBonus> optional = LazyOptional.of(this::createPlayerSalmonBonus);

    private PlayerSalmonBonus createPlayerSalmonBonus() {
        if (this.playerSalmonBonus == null) {
            this.playerSalmonBonus = new PlayerSalmonBonus(entity);
        }

        return this.playerSalmonBonus;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_SALMON_BONUS) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerSalmonBonus().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerSalmonBonus().loadNBTData(nbt);
    }
}